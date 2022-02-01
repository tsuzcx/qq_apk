package com.tencent.mm.plugin.hld.keyboard.selfdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.keyboard.Keyboard;
import com.tencent.mm.plugin.hld.keyboard.Keyboard.a;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyData;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardConfig;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "Lcom/tencent/mm/plugin/hld/keyboard/Keyboard;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "actionButton", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "actionDownX", "actionDownY", "allDataComplete", "", "getAllDataComplete", "()Z", "setAllDataComplete", "(Z)V", "bottomMargin", "getBottomMargin", "()I", "setBottomMargin", "(I)V", "buttonDrawer", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "getButtonDrawer", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "setButtonDrawer", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;)V", "curTouchInButton", "customizeMap", "", "", "Landroid/view/View;", "deleteExeFuture", "Ljava/util/concurrent/Future;", "deleteFuture", "deleteKeyType", "deleteKeyWidth", "hasCallLongClick", "hasCreate", "imeButtons", "", "getImeButtons", "()Ljava/util/List;", "setImeButtons", "(Ljava/util/List;)V", "lastDeleteKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "lastFingerPointId", "Ljava/lang/Integer;", "lastModeInt", "leftMargin", "getLeftMargin", "setLeftMargin", "leftPadding", "getLeftPadding", "setLeftPadding", "line", "getLine", "setLine", "lineGap", "getLineGap", "setLineGap", "lineHeight", "", "getLineHeight", "setLineHeight", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "getMKeyboardActionListener", "()Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "setMKeyboardActionListener", "(Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;)V", "mLastClickButton", "mLastClickTime", "", "mLastUpperMode", "mUpperMode", "originData", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "resMap", "rightMargin", "getRightMargin", "setRightMargin", "rightPadding", "getRightPadding", "setRightPadding", "swipeable", "getSwipeable", "setSwipeable", "topMargin", "getTopMargin", "setTopMargin", "touchListener", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;)V", "triggerLeftDeleteMode", "vHeight", "getVHeight", "setVHeight", "vWidth", "getVWidth", "setVWidth", "bindView2Key", "", "view", "id", "calculateButtonData", "keyboard", "checkIsTouchInButton", "event", "Landroid/view/MotionEvent;", "checkNeedCalculate", "childContains", "value", "closeDeleteTouch", "btn", "dealDefaultConfigKey", "data", "doDelete", "deleteLength", "delayTime", "fetchOriginConfig", "findButtonById", "getActionButton", "getCurrentModeInt", "getEnterKey", "getHeightScale", "", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getPointId", "getResId", "s", "getUpperMode", "getWidthScale", "handleDeleteKey", "button", "reportKeyArea", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;Landroid/view/MotionEvent;Ljava/lang/Integer;)Z", "handleDoubleClick", "initButtonActionDispatch", "initButtonDrawer", "initConfig", "initKeyboardConfig", "config", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "isEnterKey", "isOnlySupportClickFloatViewKey", "isSupportFloatViewKey", "isUpper", "normalScale", "i", "(Ljava/lang/Float;)F", "onButtonClick", "onButtonLongClick", "onButtonPress", "onButtonUp", "onClick", "v", "onClickForSupportDoubleClick", "onCreate", "onDoubleClick", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onInitFinish", "onLayout", "changed", "l", "t", "r", "b", "onLongClick", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onReset", "onResume", "listener", "onSelectCandidate", "text", "", "suffix", "onTouch", "onTouchEvent", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "parseData", "path", "recordActionButton", "reset", "scaleHeight", "scaleWidth", "setOnTouchListener", "shouldCareEvent", "supportDoubleClick", "switchUpperMode", "upperMode", "transparentBg", "transparent", "updateEnterKey", "actionStr", "actionMode", "updateUpperKey", "updateUpperKeyImp", "visitImeButton", "visitor", "Lkotlin/Function1;", "Companion", "KeyArea", "KeyOperation", "OnTouchListener", "plugin-hld_release"})
public abstract class KeyboardView
  extends Keyboard
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final a DAv = new a((byte)0);
  private int Cxs;
  private int Cxt;
  private boolean DAb;
  private b DAc;
  private c DAd;
  private final KeyboardData DAe;
  private int DAf;
  private final Map<String, View> DAg = (Map)new LinkedHashMap();
  private boolean DAh;
  private int DAi;
  private int DAj;
  private int DAk;
  private List<List<b>> DAl = (List)new ArrayList();
  private a DAm;
  private boolean DAn;
  private final Map<String, Integer> DAo = (Map)new LinkedHashMap();
  private d DAp;
  private Integer DAq;
  private int DAr;
  private int DAs;
  private b DAt;
  private boolean DAu;
  private com.tencent.mm.plugin.hld.a.c DvY;
  private int DxQ;
  private int DxR = 1;
  private long DxT;
  private Future<?> DxV;
  private Future<?> DxW;
  private int DxX;
  private int DxZ;
  private boolean Dya;
  private boolean DzQ;
  private int Gp;
  private int Gq;
  private int Gr;
  private int Gs;
  private int line;
  private List<Integer> lineHeight = (List)v.aaAd;
  
  public KeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(eDP().deepCopy());
    this.DAe = eDP();
    this.DAf = getCurrentModeInt();
  }
  
  public KeyboardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(eDP().deepCopy());
    this.DAe = eDP();
    this.DAf = getCurrentModeInt();
  }
  
  public KeyboardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    a(eDP().deepCopy());
    this.DAe = eDP();
    this.DAf = getCurrentModeInt();
  }
  
  private final void a(KeyboardConfig paramKeyboardConfig)
  {
    int j = 1;
    boolean bool = false;
    Object localObject1 = paramKeyboardConfig.getVWidth();
    if (localObject1 != null)
    {
      i = (int)((Float)localObject1).floatValue();
      this.DAi = i;
      localObject1 = paramKeyboardConfig.getVHeight();
      i = j;
      if (localObject1 != null) {
        i = (int)((Float)localObject1).floatValue();
      }
      this.DAj = i;
      localObject1 = paramKeyboardConfig.getLine();
      if (localObject1 == null) {
        break label173;
      }
    }
    float f;
    label173:
    for (int i = ((Integer)localObject1).intValue();; i = 0)
    {
      this.line = i;
      localObject1 = paramKeyboardConfig.getSwipeable();
      if (localObject1 != null) {
        bool = ((Boolean)localObject1).booleanValue();
      }
      this.DzQ = bool;
      this.DAk = ((int)c(paramKeyboardConfig.getLineGap()));
      f = 0.0F;
      localObject1 = paramKeyboardConfig.getLineHeight();
      if (localObject1 == null) {
        break label277;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        f = ((Number)((Iterator)localObject1).next()).floatValue() + f;
      }
      i = 1;
      break;
    }
    for (;;)
    {
      localObject1 = paramKeyboardConfig.getLineHeight();
      if (localObject1 == null) {
        break label374;
      }
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(Integer.valueOf((int)(c(Float.valueOf(((Number)((Iterator)localObject2).next()).floatValue())) * this.DAj / f)));
      }
      label277:
      f = 0.0F;
    }
    label374:
    for (localObject1 = (List)localObject1;; localObject1 = (List)v.aaAd)
    {
      this.lineHeight = ((List)localObject1);
      this.Cxs = ((int)b(paramKeyboardConfig.getPaddingLeft()));
      this.Cxt = ((int)b(paramKeyboardConfig.getPaddingRight()));
      this.Gp = ((int)b(paramKeyboardConfig.getMarginLeft()));
      this.Gq = ((int)b(paramKeyboardConfig.getMarginRight()));
      this.Gr = ((int)c(paramKeyboardConfig.getMarginTop()));
      this.Gs = ((int)c(paramKeyboardConfig.getMarginBottom()));
      return;
    }
  }
  
  private void a(KeyboardData paramKeyboardData)
  {
    p.k(paramKeyboardData, "data");
    this.DAl.clear();
    reset();
    a(paramKeyboardData.getConfig());
    c(paramKeyboardData);
    b(paramKeyboardData);
    this.DAh = true;
  }
  
  private final int aLx(String paramString)
  {
    int j = 0;
    Object localObject2 = (Integer)this.DAo.get(paramString);
    Object localObject1 = localObject2;
    int i;
    if (localObject2 == null)
    {
      if (paramString == null) {
        break label178;
      }
      if (!new kotlin.n.k("^[@](style|drawable|color|raw)[/].*$").aY((CharSequence)paramString)) {
        break label173;
      }
      localObject1 = kotlin.n.n.a(paramString, kotlin.k.i.ou(1, kotlin.n.n.a((CharSequence)paramString, '/', 0, false, 6)));
      localObject2 = paramString.substring(kotlin.n.n.a((CharSequence)paramString, '/', 0, false, 6) + 1);
      p.j(localObject2, "(this as java.lang.String).substring(startIndex)");
      Resources localResources = getResources();
      Context localContext = getContext();
      p.j(localContext, "context");
      i = localResources.getIdentifier((String)localObject2, (String)localObject1, localContext.getPackageName());
      this.DAo.put(paramString, Integer.valueOf(i));
    }
    label173:
    label178:
    for (localObject1 = Integer.valueOf(i);; localObject1 = null)
    {
      i = j;
      if (localObject1 != null) {
        i = ((Integer)localObject1).intValue();
      }
      return i;
      i = 0;
      break;
    }
  }
  
  private static int ad(MotionEvent paramMotionEvent)
  {
    p.k(paramMotionEvent, "event");
    return paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
  }
  
  private final void af(MotionEvent paramMotionEvent)
  {
    b localb = getActionButton();
    if (localb != null)
    {
      this.DAu = localb.hK((int)paramMotionEvent.getX(paramMotionEvent.findPointerIndex(ad(paramMotionEvent))), (int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(ad(paramMotionEvent))));
      return;
    }
    ((KeyboardView)this).DAu = false;
  }
  
  private final void ax(int paramInt, long paramLong)
  {
    final long l = System.currentTimeMillis();
    this.DxW = ((Future)h.ZvG.n((Runnable)new e(this, l, paramInt), paramLong));
  }
  
  private final float b(Float paramFloat)
  {
    if (paramFloat != null)
    {
      ((Number)paramFloat).floatValue();
      float f = paramFloat.floatValue();
      paramFloat = getContext();
      p.j(paramFloat, "context");
      return f * gL(paramFloat);
    }
    return 0.0F;
  }
  
  private final void b(KeyboardData paramKeyboardData)
  {
    Log.d("WxIme.KeyboardView", getKeyboardType().ordinal() + " calculateButtonData height:" + c(Float.valueOf(1.0F)) + " width:" + b(Float.valueOf(1.0F)));
    int i = this.Gr;
    int n = this.Cxs;
    Iterator localIterator1 = ((Iterable)paramKeyboardData.getKeys()).iterator();
    int j = 0;
    while (localIterator1.hasNext())
    {
      paramKeyboardData = localIterator1.next();
      if (j < 0) {
        j.iBO();
      }
      paramKeyboardData = (List)paramKeyboardData;
      List localList = (List)new ArrayList();
      Iterator localIterator2 = ((Iterable)paramKeyboardData).iterator();
      int k = n;
      if (localIterator2.hasNext())
      {
        KeyData localKeyData = (KeyData)localIterator2.next();
        b localb = new b(this);
        localb.setId(localKeyData.getId());
        paramKeyboardData = localKeyData.getWidth();
        if (paramKeyboardData == null) {
          p.iCn();
        }
        localb.width = ((int)paramKeyboardData.floatValue());
        paramKeyboardData = localKeyData.getHeight();
        if (paramKeyboardData == null) {
          p.iCn();
        }
        localb.height = ((int)paramKeyboardData.floatValue());
        paramKeyboardData = localKeyData.getType();
        label251:
        Object localObject;
        float f1;
        float f2;
        boolean bool;
        if (paramKeyboardData != null)
        {
          m = paramKeyboardData.intValue();
          localb.type = m;
          localObject = localKeyData.getDrawerType();
          paramKeyboardData = (KeyboardData)localObject;
          if (localObject == null) {
            paramKeyboardData = "";
          }
          localb.setDrawerType(paramKeyboardData);
          paramKeyboardData = localb.DzC;
          f1 = k;
          localObject = localKeyData.getLeftMargin();
          if (localObject == null) {
            p.iCn();
          }
          m = (int)(f1 + ((Float)localObject).floatValue());
          f1 = i;
          localObject = localKeyData.getTopMargin();
          if (localObject == null) {
            p.iCn();
          }
          int i1 = (int)(f1 + ((Float)localObject).floatValue());
          f1 = k;
          localObject = localKeyData.getLeftMargin();
          if (localObject == null) {
            p.iCn();
          }
          int i2 = (int)(f1 + ((Float)localObject).floatValue() + localb.width);
          f1 = i;
          localObject = localKeyData.getTopMargin();
          if (localObject == null) {
            p.iCn();
          }
          paramKeyboardData.set(m, i1, i2, (int)(f1 + ((Float)localObject).floatValue() + localb.height));
          paramKeyboardData = localb.DzD;
          f1 = k;
          localObject = localKeyData.getLeftMargin();
          if (localObject == null) {
            p.iCn();
          }
          f2 = ((Float)localObject).floatValue();
          localObject = localKeyData.getLeftPadding();
          if (localObject == null) {
            p.iCn();
          }
          m = (int)(f1 + f2 + ((Float)localObject).floatValue());
          f1 = i;
          localObject = localKeyData.getTopMargin();
          if (localObject == null) {
            p.iCn();
          }
          f2 = ((Float)localObject).floatValue();
          localObject = localKeyData.getTopPadding();
          if (localObject == null) {
            p.iCn();
          }
          i1 = (int)(f1 + f2 + ((Float)localObject).floatValue());
          f1 = k;
          localObject = localKeyData.getLeftMargin();
          if (localObject == null) {
            p.iCn();
          }
          f2 = ((Float)localObject).floatValue();
          float f3 = localb.width;
          localObject = localKeyData.getRightPadding();
          if (localObject == null) {
            p.iCn();
          }
          i2 = (int)(f1 + f2 + f3 - ((Float)localObject).floatValue());
          f1 = i;
          localObject = localKeyData.getTopMargin();
          if (localObject == null) {
            p.iCn();
          }
          f2 = ((Float)localObject).floatValue();
          f3 = localb.height;
          localObject = localKeyData.getBottomPadding();
          if (localObject == null) {
            p.iCn();
          }
          paramKeyboardData.set(m, i1, i2, (int)(f1 + f2 + f3 - ((Float)localObject).floatValue()));
          localObject = localKeyData.getMainText();
          paramKeyboardData = (KeyboardData)localObject;
          if (localObject == null) {
            paramKeyboardData = "";
          }
          localb.setMainText(paramKeyboardData);
          paramKeyboardData = localKeyData.getClickable();
          if (paramKeyboardData == null) {
            break label1299;
          }
          bool = paramKeyboardData.booleanValue();
          label712:
          localb.oYn = bool;
          paramKeyboardData = localKeyData.getLongClickable();
          if (paramKeyboardData == null) {
            break label1305;
          }
          bool = paramKeyboardData.booleanValue();
          label735:
          localb.DzO = bool;
          paramKeyboardData = localKeyData.getTouchFunctionCode();
          if (paramKeyboardData == null) {
            break label1311;
          }
          m = paramKeyboardData.intValue();
          label758:
          localb.DzR = m;
          paramKeyboardData = localKeyData.getClickFunctionCode();
          if (paramKeyboardData == null) {
            break label1317;
          }
          m = paramKeyboardData.intValue();
          label781:
          localb.DzN = m;
          paramKeyboardData = localKeyData.getLongClickFunctionCode();
          if (paramKeyboardData == null) {
            break label1323;
          }
          m = paramKeyboardData.intValue();
          label804:
          localb.DzP = m;
          paramKeyboardData = localKeyData.getSwipeable();
          if (paramKeyboardData == null) {
            break label1329;
          }
          bool = paramKeyboardData.booleanValue();
          label827:
          localb.DzQ = bool;
          paramKeyboardData = localKeyData.getBgCorner();
          if (paramKeyboardData == null) {
            p.iCn();
          }
          localb.DzJ = ((int)paramKeyboardData.floatValue());
          paramKeyboardData = localKeyData.getShadowHeight();
          if (paramKeyboardData == null) {
            p.iCn();
          }
          localb.DzK = ((int)paramKeyboardData.floatValue());
          localb.DzI = aLx(localKeyData.getImgSrc());
          paramKeyboardData = localKeyData.getIconWidth();
          if (paramKeyboardData == null) {
            break label1335;
          }
          m = (int)paramKeyboardData.floatValue();
          label911:
          localb.iconWidth = m;
          paramKeyboardData = localKeyData.getIconHeight();
          if (paramKeyboardData == null) {
            break label1341;
          }
          m = (int)paramKeyboardData.floatValue();
          label935:
          localb.iconHeight = m;
          paramKeyboardData = getContext();
          localObject = localKeyData.getMainTextSize();
          if (localObject == null) {
            break label1347;
          }
          m = ((Integer)localObject).intValue();
          label966:
          localb.DzE = com.tencent.mm.ci.a.fromDPToPix(paramKeyboardData, m);
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.DHH;
          paramKeyboardData = getContext();
          p.j(paramKeyboardData, "context");
          localb.DzF = com.tencent.mm.plugin.hld.f.k.bf(paramKeyboardData, localKeyData.getMainTextColor());
          paramKeyboardData = getContext();
          localObject = localKeyData.getFloatTextSize();
          if (localObject == null) {
            break label1353;
          }
        }
        label1299:
        label1305:
        label1311:
        label1317:
        label1323:
        label1329:
        label1335:
        label1341:
        label1347:
        label1353:
        for (m = ((Integer)localObject).intValue();; m = 0)
        {
          localb.DzG = com.tencent.mm.ci.a.fromDPToPix(paramKeyboardData, m);
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.DHH;
          paramKeyboardData = getContext();
          p.j(paramKeyboardData, "context");
          localb.DzH = com.tencent.mm.plugin.hld.f.k.bf(paramKeyboardData, localKeyData.getFloatTextColor());
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.DHH;
          paramKeyboardData = getContext();
          p.j(paramKeyboardData, "context");
          localb.bgColor = com.tencent.mm.plugin.hld.f.k.bf(paramKeyboardData, localKeyData.getBgColor());
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.DHH;
          paramKeyboardData = getContext();
          p.j(paramKeyboardData, "context");
          localb.shadowColor = com.tencent.mm.plugin.hld.f.k.bf(paramKeyboardData, localKeyData.getShadowColor());
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.DHH;
          paramKeyboardData = getContext();
          p.j(paramKeyboardData, "context");
          localb.DzL = com.tencent.mm.plugin.hld.f.k.bf(paramKeyboardData, localKeyData.getInitialColor());
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.DHH;
          paramKeyboardData = getContext();
          p.j(paramKeyboardData, "context");
          localb.DzM = com.tencent.mm.plugin.hld.f.k.bf(paramKeyboardData, localKeyData.getPressMaskColor());
          localObject = localKeyData.getFloatText();
          paramKeyboardData = (KeyboardData)localObject;
          if (localObject == null) {
            paramKeyboardData = "";
          }
          localb.setFloatText(paramKeyboardData);
          localList.add(localb);
          paramKeyboardData = localKeyData.getLeftMargin();
          if (paramKeyboardData == null) {
            p.iCn();
          }
          f1 = paramKeyboardData.floatValue();
          paramKeyboardData = localKeyData.getWidth();
          if (paramKeyboardData == null) {
            p.iCn();
          }
          f2 = paramKeyboardData.floatValue();
          paramKeyboardData = localKeyData.getRightMargin();
          if (paramKeyboardData == null) {
            p.iCn();
          }
          k = (int)(paramKeyboardData.floatValue() + (f1 + f2)) + k;
          break;
          m = 0;
          break label251;
          bool = false;
          break label712;
          bool = false;
          break label735;
          m = -1;
          break label758;
          m = -1;
          break label781;
          m = -1;
          break label804;
          bool = false;
          break label827;
          m = 0;
          break label911;
          m = 0;
          break label935;
          m = 0;
          break label966;
        }
      }
      this.DAl.add(localList);
      k = ((Number)this.lineHeight.get(j)).intValue();
      int m = this.DAk;
      j += 1;
      i = k + m + i;
    }
  }
  
  private final float c(Float paramFloat)
  {
    if (paramFloat != null)
    {
      ((Number)paramFloat).floatValue();
      float f = paramFloat.floatValue();
      paramFloat = getContext();
      p.j(paramFloat, "context");
      return f * gM(paramFloat);
    }
    return 0.0F;
  }
  
  private final void c(KeyboardData paramKeyboardData)
  {
    KeyData localKeyData1 = paramKeyboardData.getKeyDefaultConfig();
    Iterator localIterator1 = ((Iterable)paramKeyboardData.getKeys()).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
      {
        KeyData localKeyData2 = (KeyData)localIterator2.next();
        Object localObject = localKeyData2.getType();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getType();
        }
        localKeyData2.setType(paramKeyboardData);
        localObject = localKeyData2.getDrawerType();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getDrawerType();
        }
        localKeyData2.setDrawerType(paramKeyboardData);
        localObject = localKeyData2.getMainText();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getMainText();
        }
        localKeyData2.setMainText(paramKeyboardData);
        localObject = localKeyData2.getMainTextSize();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getMainTextSize();
        }
        localKeyData2.setMainTextSize(paramKeyboardData);
        localObject = localKeyData2.getMainTextColor();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getMainTextColor();
        }
        localKeyData2.setMainTextColor(paramKeyboardData);
        localObject = localKeyData2.getFloatText();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getFloatText();
        }
        localKeyData2.setFloatText(paramKeyboardData);
        localObject = localKeyData2.getFloatTextSize();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getFloatTextSize();
        }
        localKeyData2.setFloatTextSize(paramKeyboardData);
        localObject = localKeyData2.getFloatTextColor();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getFloatTextColor();
        }
        localKeyData2.setFloatTextColor(paramKeyboardData);
        localObject = localKeyData2.getImgSrc();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getImgSrc();
        }
        localKeyData2.setImgSrc(paramKeyboardData);
        localObject = localKeyData2.getWidth();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getWidth();
        }
        localKeyData2.setWidth(Float.valueOf(b(paramKeyboardData)));
        localObject = localKeyData2.getHeight();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getHeight();
        }
        localKeyData2.setHeight(Float.valueOf(c(paramKeyboardData)));
        localObject = localKeyData2.getLeftMargin();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getLeftMargin();
        }
        localKeyData2.setLeftMargin(Float.valueOf(b(paramKeyboardData)));
        localObject = localKeyData2.getLeftPadding();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getLeftPadding();
        }
        localKeyData2.setLeftPadding(Float.valueOf(b(paramKeyboardData)));
        localObject = localKeyData2.getTopMargin();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getTopMargin();
        }
        localKeyData2.setTopMargin(Float.valueOf(c(paramKeyboardData)));
        localObject = localKeyData2.getTopPadding();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getTopPadding();
        }
        localKeyData2.setTopPadding(Float.valueOf(c(paramKeyboardData)));
        localObject = localKeyData2.getBottomPadding();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getBottomPadding();
        }
        localKeyData2.setBottomPadding(Float.valueOf(c(paramKeyboardData)));
        localObject = localKeyData2.getRightMargin();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getRightMargin();
        }
        localKeyData2.setRightMargin(Float.valueOf(b(paramKeyboardData)));
        localObject = localKeyData2.getRightPadding();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getRightPadding();
        }
        localKeyData2.setRightPadding(Float.valueOf(b(paramKeyboardData)));
        localObject = localKeyData2.getClickable();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getClickable();
        }
        localKeyData2.setClickable(paramKeyboardData);
        localObject = localKeyData2.getTouchFunctionCode();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getTouchFunctionCode();
        }
        localKeyData2.setTouchFunctionCode(paramKeyboardData);
        localObject = localKeyData2.getLongClickable();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getLongClickable();
        }
        localKeyData2.setLongClickable(paramKeyboardData);
        localObject = localKeyData2.getClickFunctionCode();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getClickFunctionCode();
        }
        localKeyData2.setClickFunctionCode(paramKeyboardData);
        localObject = localKeyData2.getLongClickFunctionCode();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getLongClickFunctionCode();
        }
        localKeyData2.setLongClickFunctionCode(paramKeyboardData);
        localObject = localKeyData2.getSwipeable();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getSwipeable();
        }
        localKeyData2.setSwipeable(paramKeyboardData);
        localObject = localKeyData2.getIconWidth();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getIconWidth();
        }
        localObject = paramKeyboardData;
        if (paramKeyboardData == null) {
          localObject = Float.valueOf(0.0F);
        }
        localKeyData2.setIconWidth(Float.valueOf(d((Float)localObject)));
        localObject = localKeyData2.getIconHeight();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getIconHeight();
        }
        localObject = paramKeyboardData;
        if (paramKeyboardData == null) {
          localObject = Float.valueOf(0.0F);
        }
        localKeyData2.setIconHeight(Float.valueOf(d((Float)localObject)));
        localObject = localKeyData2.getBgCorner();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getBgCorner();
        }
        localKeyData2.setBgCorner(Float.valueOf(d(paramKeyboardData)));
        localObject = localKeyData2.getBgColor();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getBgColor();
        }
        localKeyData2.setBgColor(paramKeyboardData);
        localObject = localKeyData2.getShadowColor();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getShadowColor();
        }
        localKeyData2.setShadowColor(paramKeyboardData);
        localObject = localKeyData2.getShadowHeight();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getShadowHeight();
        }
        localKeyData2.setShadowHeight(Float.valueOf(d(paramKeyboardData)));
        localObject = localKeyData2.getInitialColor();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getInitialColor();
        }
        localKeyData2.setInitialColor(paramKeyboardData);
        localObject = localKeyData2.getPressMaskColor();
        paramKeyboardData = (KeyboardData)localObject;
        if (localObject == null) {
          paramKeyboardData = localKeyData1.getPressMaskColor();
        }
        localKeyData2.setPressMaskColor(paramKeyboardData);
      }
    }
  }
  
  private final float d(Float paramFloat)
  {
    if (paramFloat != null)
    {
      float f = ((Number)paramFloat).floatValue();
      return com.tencent.mm.ci.a.fromDPToPix(getContext(), f);
    }
    return 0.0F;
  }
  
  public static boolean f(b paramb)
  {
    p.k(paramb, "btn");
    return ((paramb.type & 0x2) != 2) && ((paramb.type & 0x4) != 4);
  }
  
  private final boolean fe(View paramView)
  {
    boolean bool2 = false;
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (p.h(getChildAt(i), paramView)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private final float gL(Context paramContext)
  {
    if (getMeasuredWidth() != 0) {
      return getMeasuredWidth() / this.DAi;
    }
    com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.DHH;
    return (float)com.tencent.mm.plugin.hld.f.k.gX(paramContext);
  }
  
  private final float gM(Context paramContext)
  {
    if (getMeasuredHeight() != 0) {
      return getMeasuredHeight() / this.DAj;
    }
    com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.DHH;
    return (float)com.tencent.mm.plugin.hld.f.k.gY(paramContext);
  }
  
  protected final void S(kotlin.g.a.b<? super b, x> paramb)
  {
    p.k(paramb, "visitor");
    Iterator localIterator1 = ((Iterable)this.DAl).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        paramb.invoke((b)localIterator2.next());
      }
    }
  }
  
  public final void Uu(int paramInt)
  {
    this.DxQ = this.DxR;
    this.DxR = paramInt;
  }
  
  public boolean X(MotionEvent paramMotionEvent)
  {
    p.k(paramMotionEvent, "event");
    return false;
  }
  
  public final void a(b paramb, MotionEvent paramMotionEvent)
  {
    Object localObject = null;
    p.k(paramb, "btn");
    if (paramb.DzR == 1)
    {
      paramb = this.DxV;
      if (paramb != null)
      {
        paramb.cancel(true);
        this.DxV = null;
      }
      paramb = localObject;
      if (paramMotionEvent != null) {
        paramb = Integer.valueOf(paramMotionEvent.getActionMasked());
      }
      if (paramb != null) {
        break label62;
      }
      break label61;
    }
    label61:
    label62:
    while (paramb.intValue() != 5)
    {
      if (paramb != null) {
        break;
      }
      return;
    }
    for (;;)
    {
      paramb = this.DAd;
      if (paramb == null) {
        break;
      }
      paramb.DAw.sP(false);
      return;
      if (paramb.intValue() != 0) {
        break;
      }
    }
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    p.k(paramString1, "text");
    p.k(paramArrayOfByte, "id");
  }
  
  public boolean a(b paramb)
  {
    return false;
  }
  
  protected final boolean a(b paramb, MotionEvent paramMotionEvent, Integer paramInteger)
  {
    p.k(paramb, "button");
    Integer localInteger;
    Object localObject;
    label33:
    int i;
    label56:
    int j;
    long l;
    if (paramMotionEvent != null)
    {
      localInteger = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (paramMotionEvent == null) {
        break label163;
      }
      localObject = Float.valueOf(paramMotionEvent.getRawX());
      i = (int)((Float)localObject).floatValue();
      if (paramMotionEvent == null) {
        break label172;
      }
      paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY());
      j = (int)((Float)paramMotionEvent).floatValue();
      l = System.currentTimeMillis();
      Log.d("WxIme.KeyboardView", "handleBackKey action " + localInteger + ' ' + i + ' ' + j + ' ' + l);
      if (localInteger != null) {
        break label180;
      }
      label130:
      if (localInteger != null) {
        break label344;
      }
      if (localInteger != null) {
        break label361;
      }
      label140:
      if (localInteger != null) {
        break label493;
      }
      label145:
      if (localInteger != null) {
        break label573;
      }
      if (localInteger != null) {
        break label586;
      }
    }
    for (;;)
    {
      label155:
      return false;
      localInteger = null;
      break;
      label163:
      localObject = Double.valueOf(0.0D);
      break label33;
      label172:
      paramMotionEvent = Double.valueOf(0.0D);
      break label56;
      label180:
      if (localInteger.intValue() != 5) {
        break label130;
      }
      label189:
      paramMotionEvent = com.tencent.mm.plugin.hld.f.i.DHq;
      paramMotionEvent = getContext();
      p.j(paramMotionEvent, "context");
      com.tencent.mm.plugin.hld.f.i.a(paramb, paramMotionEvent);
      this.DAd = new c(i, j, l, null, paramb, 0L, 88);
      this.DxZ = paramb.width;
      paramb.sP(true);
      paramb = com.tencent.mm.plugin.hld.model.n.DEn;
      if (com.tencent.mm.plugin.hld.model.n.eEE()) {}
      for (i = 2;; i = 1)
      {
        this.DxX = i;
        ax(1, 300L);
        paramb = this.DxV;
        if (paramb != null) {
          paramb.cancel(true);
        }
        this.DxV = ((Future)h.ZvG.o((Runnable)new g(this), 300L));
        if (paramInteger == null) {
          break label155;
        }
        i = ((Number)paramInteger).intValue();
        paramb = com.tencent.mm.plugin.hld.model.k.DDb;
        com.tencent.mm.plugin.hld.model.k.hO(i, 1);
        break label155;
        label344:
        if (localInteger.intValue() != 0) {
          break;
        }
        break label189;
      }
      label361:
      if (localInteger.intValue() != 2) {
        break label140;
      }
      if (!this.Dya)
      {
        paramb = this.DAd;
        if ((paramb != null) && (this.DxX == 1))
        {
          paramMotionEvent = this.DAd;
          if (paramMotionEvent == null) {
            p.iCn();
          }
          if ((l - paramMotionEvent.time < 295L) && (paramb.x - i > this.DxZ) && (this.DxZ != 0))
          {
            paramb = this.DxV;
            if (paramb != null)
            {
              paramb.cancel(true);
              this.DxV = null;
            }
            paramb = this.DxW;
            if (paramb != null)
            {
              paramb.cancel(true);
              this.DxW = null;
            }
            this.Dya = true;
            continue;
            label493:
            if (localInteger.intValue() != 3) {
              break label145;
            }
            for (;;)
            {
              paramb.sP(false);
              paramb = this.DxV;
              if (paramb != null)
              {
                paramb.cancel(true);
                this.DxV = null;
              }
              if (!this.Dya) {
                break label607;
              }
              this.Dya = false;
              paramb = this.DAd;
              if (paramb == null) {
                break label155;
              }
              if (paramb.x - i <= this.DxZ) {
                break label598;
              }
              com.tencent.mm.plugin.hld.model.n.DEn.eEO();
              break label155;
              label573:
              if (localInteger.intValue() != 6)
              {
                break;
                label586:
                if (localInteger.intValue() != 1) {
                  break label155;
                }
              }
            }
            label598:
            ax(1, 0L);
            continue;
            label607:
            paramb = this.DAd;
            if (paramb == null) {
              p.iCn();
            }
            if (l - paramb.time < 295L)
            {
              paramb = this.DxW;
              if (paramb != null)
              {
                paramb.cancel(true);
                this.DxW = null;
              }
              ax(1, 0L);
            }
          }
        }
      }
    }
  }
  
  public final b aLy(String paramString)
  {
    p.k(paramString, "id");
    final aa.f localf = new aa.f();
    localf.aaBC = null;
    S((kotlin.g.a.b)new f(paramString, localf));
    return (b)localf.aaBC;
  }
  
  public final boolean ae(MotionEvent paramMotionEvent)
  {
    p.k(paramMotionEvent, "event");
    return (paramMotionEvent.getPointerCount() == paramMotionEvent.getActionIndex() + 1) && (!this.DAb);
  }
  
  public void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.DvY = paramc;
    requestLayout();
    invalidate();
  }
  
  public void b(b paramb) {}
  
  public void c(b paramb) {}
  
  public boolean d(b paramb)
  {
    p.k(paramb, "button");
    return false;
  }
  
  public final boolean e(b paramb)
  {
    b localb = this.DAc;
    long l = this.DxT;
    this.DAc = paramb;
    this.DxT = System.currentTimeMillis();
    if (!a(paramb)) {
      return false;
    }
    if ((p.h(paramb, localb)) && (System.currentTimeMillis() - l <= 200L))
    {
      c(paramb);
      return true;
    }
    Log.d("WxIme.KeyboardView", "supportDoubleKeyOnClickHandler");
    b(paramb);
    return true;
  }
  
  public final boolean eDJ()
  {
    return this.DxR != 1;
  }
  
  public final void eDK()
  {
    if (this.DxQ != this.DxR) {
      eDL();
    }
  }
  
  protected void eDL() {}
  
  public abstract a eDO();
  
  public abstract KeyboardData eDP();
  
  public void eDQ() {}
  
  public final void eO(String paramString, int paramInt)
  {
    p.k(paramString, "actionStr");
    b localb = getEnterKey();
    if (localb != null)
    {
      localb.setMainText(paramString);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      invalidate();
      return;
      localb.oYn = true;
      localb.bgColor = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_grey_color);
      localb.shadowColor = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_grey_shadow_color);
      localb.DzM = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_pressed_mask_color);
      localb.DzF = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_text_color);
      continue;
      localb.oYn = true;
      localb.bgColor = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_green_color);
      localb.shadowColor = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_green_shadow_color);
      localb.DzM = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_pressed_mask_color);
      localb.DzF = com.tencent.mm.ci.a.w(getContext(), a.c.White);
      continue;
      localb.oYn = false;
      localb.bgColor = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_grey_color);
      localb.shadowColor = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_grey_shadow_color);
      localb.DzM = com.tencent.mm.ci.a.w(getContext(), a.c.ime_key_pressed_mask_color);
      localb.DzF = com.tencent.mm.ci.a.w(getContext(), a.c.S2_text_invalid_color);
    }
  }
  
  public boolean g(b paramb)
  {
    p.k(paramb, "btn");
    return false;
  }
  
  public final b getActionButton()
  {
    return this.DAt;
  }
  
  public final boolean getAllDataComplete()
  {
    return this.DAh;
  }
  
  public final int getBottomMargin()
  {
    return this.Gs;
  }
  
  public final a getButtonDrawer()
  {
    return this.DAm;
  }
  
  public final int getCurrentModeInt()
  {
    Object localObject1 = new StringBuilder("keyboard").append(getKeyboardType().ordinal()).append(" getCurrentModeInt: isDarkMode=").append(ar.isDarkMode()).append("  isLandscape=");
    Object localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
    Log.d("WxIme.KeyboardView", com.tencent.mm.plugin.hld.f.k.isLandscape());
    localObject1 = (List)new ArrayList();
    if (ar.isDarkMode()) {
      ((List)localObject1).add(c.DzZ);
    }
    localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
    if (com.tencent.mm.plugin.hld.f.k.isLandscape()) {
      ((List)localObject1).add(c.DzY);
    }
    localObject2 = r.DEQ;
    return r.fD((List)localObject1);
  }
  
  protected b getEnterKey()
  {
    return null;
  }
  
  public final List<List<b>> getImeButtons()
  {
    return this.DAl;
  }
  
  public com.tencent.mm.plugin.hld.keyboard.c getKeyboardType()
  {
    return com.tencent.mm.plugin.hld.keyboard.c.Dyl;
  }
  
  public final int getLeftMargin()
  {
    return this.Gp;
  }
  
  public final int getLeftPadding()
  {
    return this.Cxs;
  }
  
  public final int getLine()
  {
    return this.line;
  }
  
  public final int getLineGap()
  {
    return this.DAk;
  }
  
  public final List<Integer> getLineHeight()
  {
    return this.lineHeight;
  }
  
  protected final com.tencent.mm.plugin.hld.a.c getMKeyboardActionListener()
  {
    return this.DvY;
  }
  
  public final int getRightMargin()
  {
    return this.Gq;
  }
  
  public final int getRightPadding()
  {
    return this.Cxt;
  }
  
  public final boolean getSwipeable()
  {
    return this.DzQ;
  }
  
  public final int getTopMargin()
  {
    return this.Gr;
  }
  
  public final d getTouchListener()
  {
    return this.DAp;
  }
  
  public int getUpperMode()
  {
    return this.DxR;
  }
  
  public final int getVHeight()
  {
    return this.DAj;
  }
  
  public final int getVWidth()
  {
    return this.DAi;
  }
  
  public final void h(View paramView, String paramString)
  {
    p.k(paramView, "view");
    p.k(paramString, "id");
    this.DAg.put(paramString, paramView);
  }
  
  public void h(b paramb)
  {
    p.k(paramb, "button");
  }
  
  public boolean i(b paramb)
  {
    p.k(paramb, "button");
    return false;
  }
  
  public void j(b paramb)
  {
    p.k(paramb, "button");
    if (paramb.DzR == 1) {
      a(paramb, null);
    }
  }
  
  public final void onClick(View paramView)
  {
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = getActionButton();
    if ((paramView != null) && (paramView.oYn) && (this.DAu))
    {
      paramView.aqA("initial");
      localObject = paramView.DzT;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(paramView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public final void onCreate()
  {
    if (!this.DAn)
    {
      setWillNotDraw(false);
      this.DAm = eDO();
      setOnClickListener((View.OnClickListener)this);
      setOnLongClickListener((View.OnLongClickListener)this);
      S((kotlin.g.a.b)new h(this));
      eDQ();
      this.DAn = true;
      requestLayout();
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((paramCanvas != null) && (this.DAh))
    {
      a locala = this.DAm;
      if (locala != null)
      {
        p.k(paramCanvas, "canvas");
        locala.aBC = paramCanvas;
      }
      S((kotlin.g.a.b)new i(this));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getCurrentModeInt() != this.DAf)
    {
      a(eDP().deepCopy());
      this.DAf = getCurrentModeInt();
    }
    invalidate();
    if (this.DAh)
    {
      Iterator localIterator = ((Iterable)this.DAg.entrySet()).iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (fe((View)localEntry.getValue()))
        {
          b localb = aLy((String)localEntry.getKey());
          if (localb != null) {
            ((View)localEntry.getValue()).layout(localb.DzD.left, localb.DzD.top, localb.DzD.right, localb.DzD.bottom);
          }
        }
      }
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = getActionButton();
    if ((paramView != null) && (paramView.DzO) && (this.DAu))
    {
      this.DAb = true;
      paramView.aqA("press");
      localObject = paramView.DzS;
      if (localObject != null)
      {
        paramView = (Boolean)((kotlin.g.a.b)localObject).invoke(paramView);
        if (paramView == null) {}
      }
      for (boolean bool = paramView.booleanValue();; bool = false)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        return bool;
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Iterator localIterator = ((Iterable)this.DAg.entrySet()).iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (fe((View)localEntry.getValue()))
      {
        b localb = aLy((String)localEntry.getKey());
        if (localb != null)
        {
          int i;
          if (((View)localEntry.getValue()).getLayoutParams().width == -2)
          {
            i = -2147483648;
            label104:
            if (((View)localEntry.getValue()).getLayoutParams().height != -2) {
              break label173;
            }
          }
          label173:
          for (int j = -2147483648;; j = 1073741824)
          {
            measureChild((View)localEntry.getValue(), View.MeasureSpec.makeMeasureSpec(localb.width, i), View.MeasureSpec.makeMeasureSpec(localb.height, j));
            break;
            i = 1073741824;
            break label104;
          }
        }
      }
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void onReset()
  {
    Uu(1);
    eDK();
    reset();
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = j;
    Object localObject;
    if (paramMotionEvent != null)
    {
      if (paramMotionEvent.getActionMasked() == 5)
      {
        localObject = getActionButton();
        if ((localObject != null) && (((b)localObject).hK((int)paramMotionEvent.getX(paramMotionEvent.findPointerIndex(ad(paramMotionEvent))), (int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(ad(paramMotionEvent)))) == true)) {
          return false;
        }
      }
      i = j;
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        i = j;
      }
    }
    while (i != 0)
    {
      return true;
      localObject = this.DAt;
      if (localObject != null) {
        ((b)localObject).eDN();
      }
      reset();
      this.DAt = null;
      this.DAr = ((int)paramMotionEvent.getX(paramMotionEvent.findPointerIndex(ad(paramMotionEvent))));
      this.DAs = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(ad(paramMotionEvent))));
      S((kotlin.g.a.b)new j(this));
      this.DAq = Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      af(paramMotionEvent);
      localObject = getActionButton();
      if (localObject != null)
      {
        ((b)localObject).aqA("press");
        kotlin.g.a.b localb = ((b)localObject).DzU;
        if (localb != null) {
          localb.invoke(localObject);
        }
      }
      localObject = this.DAp;
      if (localObject != null) {
        ((d)localObject).X(paramMotionEvent);
      }
      i = j;
      if (X(paramMotionEvent))
      {
        i = 1;
        continue;
        if (ae(paramMotionEvent)) {
          af(paramMotionEvent);
        }
        localObject = this.DAp;
        if (localObject != null) {
          ((d)localObject).X(paramMotionEvent);
        }
        i = j;
        if (X(paramMotionEvent))
        {
          i = 1;
          continue;
          localObject = this.DAp;
          if (localObject != null) {
            ((d)localObject).X(paramMotionEvent);
          }
          if (!X(paramMotionEvent)) {
            break label405;
          }
        }
      }
    }
    label405:
    for (i = 1;; i = 0)
    {
      if (ae(paramMotionEvent))
      {
        localObject = getActionButton();
        if (localObject != null) {
          ((b)localObject).eDN();
        }
        reset();
      }
      break;
      return super.onTouchEvent(paramMotionEvent);
    }
  }
  
  public final void reset()
  {
    this.DAq = null;
    b localb = this.DAt;
    if (localb != null) {
      localb.aqA("initial");
    }
    this.DAt = null;
    this.DAr = 0;
    this.DAs = 0;
    this.DAb = false;
  }
  
  public void sM(boolean paramBoolean) {}
  
  public final void setAllDataComplete(boolean paramBoolean)
  {
    this.DAh = paramBoolean;
  }
  
  public final void setBottomMargin(int paramInt)
  {
    this.Gs = paramInt;
  }
  
  public final void setButtonDrawer(a parama)
  {
    this.DAm = parama;
  }
  
  public final void setImeButtons(List<List<b>> paramList)
  {
    p.k(paramList, "<set-?>");
    this.DAl = paramList;
  }
  
  public final void setLeftMargin(int paramInt)
  {
    this.Gp = paramInt;
  }
  
  public final void setLeftPadding(int paramInt)
  {
    this.Cxs = paramInt;
  }
  
  public final void setLine(int paramInt)
  {
    this.line = paramInt;
  }
  
  public final void setLineGap(int paramInt)
  {
    this.DAk = paramInt;
  }
  
  public final void setLineHeight(List<Integer> paramList)
  {
    p.k(paramList, "<set-?>");
    this.lineHeight = paramList;
  }
  
  protected final void setMKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.DvY = paramc;
  }
  
  public final void setOnTouchListener(d paramd)
  {
    p.k(paramd, "listener");
    this.DAp = paramd;
  }
  
  public final void setRightMargin(int paramInt)
  {
    this.Gq = paramInt;
  }
  
  public final void setRightPadding(int paramInt)
  {
    this.Cxt = paramInt;
  }
  
  public final void setSwipeable(boolean paramBoolean)
  {
    this.DzQ = paramBoolean;
  }
  
  public final void setTopMargin(int paramInt)
  {
    this.Gr = paramInt;
  }
  
  public final void setTouchListener(d paramd)
  {
    this.DAp = paramd;
  }
  
  public final void setVHeight(int paramInt)
  {
    this.DAj = paramInt;
  }
  
  public final void setVWidth(int paramInt)
  {
    this.DAi = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyArea;", "", "x", "", "y", "rightX", "bottomY", "(IIII)V", "getBottomY", "()I", "getRightX", "getX", "getY", "plugin-hld_release"})
  public static final class b
  {
    final int Dye;
    final int Dyf;
    final int x;
    final int y;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.x = paramInt1;
      this.y = paramInt2;
      this.Dye = paramInt3;
      this.Dyf = paramInt4;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "", "x", "", "y", "time", "", "processText", "", "process", "", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "pressTimestamp", "(IIJLjava/lang/String;ZLcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;J)V", "getButton", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "setButton", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;)V", "getPressTimestamp", "()J", "getProcess", "()Z", "setProcess", "(Z)V", "getProcessText", "()Ljava/lang/String;", "setProcessText", "(Ljava/lang/String;)V", "getTime", "getX", "()I", "getY", "plugin-hld_release"})
  public static final class c
  {
    b DAw;
    String Dyg;
    public boolean Dyh;
    public final long Dyi;
    final long time;
    public final int x;
    public final int y;
    
    private c(int paramInt1, int paramInt2, long paramLong1, String paramString, b paramb, long paramLong2)
    {
      AppMethodBeat.i(216818);
      this.x = paramInt1;
      this.y = paramInt2;
      this.time = paramLong1;
      this.Dyg = paramString;
      this.Dyh = false;
      this.DAw = paramb;
      this.Dyi = paramLong2;
      AppMethodBeat.o(216818);
    }
    
    public final void aLu(String paramString)
    {
      AppMethodBeat.i(216817);
      p.k(paramString, "<set-?>");
      this.Dyg = paramString;
      AppMethodBeat.o(216817);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "", "onTouch", "", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"})
  public static abstract interface d
  {
    public abstract boolean X(MotionEvent paramMotionEvent);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(KeyboardView paramKeyboardView, long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(214978);
      Log.i("WxIme.KeyboardView", "doDeleteImp inter time:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.hld.a.c localc = this.DAx.getMKeyboardActionListener();
      if (localc != null)
      {
        localc.q(1, new Keyboard.a(KeyboardView.a(this.DAx), this.Dyd));
        AppMethodBeat.o(214978);
        return;
      }
      AppMethodBeat.o(214978);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<b, x>
  {
    f(String paramString, aa.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(KeyboardView paramKeyboardView) {}
    
    public final void run()
    {
      AppMethodBeat.i(217112);
      for (;;)
      {
        int i;
        long l;
        try
        {
          Thread.sleep(100L);
          int j = 1;
          i = j;
          if (KeyboardView.a(this.DAx) == 2)
          {
            l = System.currentTimeMillis();
            KeyboardView.c localc = KeyboardView.b(this.DAx);
            if (localc == null) {
              p.iCn();
            }
            l -= localc.time;
            if (l > 2000L) {
              i = 3;
            }
          }
          else
          {
            KeyboardView.a(this.DAx, i);
            continue;
          }
          i = j;
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("WxIme.KeyboardView", "deleteFuture " + localInterruptedException.getMessage());
          AppMethodBeat.o(217112);
          return;
        }
        if (l > 5000L) {
          i = 5;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<b, x>
  {
    h(KeyboardView paramKeyboardView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<b, x>
  {
    i(KeyboardView paramKeyboardView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<b, x>
  {
    j(KeyboardView paramKeyboardView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView
 * JD-Core Version:    0.7.0.1
 */