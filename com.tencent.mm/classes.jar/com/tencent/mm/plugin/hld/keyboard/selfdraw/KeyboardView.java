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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.keyboard.Keyboard;
import com.tencent.mm.plugin.hld.keyboard.Keyboard.a;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyData;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardConfig;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "Lcom/tencent/mm/plugin/hld/keyboard/Keyboard;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "actionButton", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "actionDownX", "actionDownY", "allDataComplete", "", "getAllDataComplete", "()Z", "setAllDataComplete", "(Z)V", "bottomMargin", "getBottomMargin", "()I", "setBottomMargin", "(I)V", "buttonDrawer", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "getButtonDrawer", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "setButtonDrawer", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;)V", "curTouchInButton", "customizeMap", "", "", "Landroid/view/View;", "deleteExeFuture", "Ljava/util/concurrent/Future;", "deleteFuture", "deleteKeyType", "deleteKeyWidth", "hasCallLongClick", "hasCreate", "imeButtons", "", "getImeButtons", "()Ljava/util/List;", "setImeButtons", "(Ljava/util/List;)V", "lastDeleteKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "lastFingerPointId", "Ljava/lang/Integer;", "lastModeInt", "leftMargin", "getLeftMargin", "setLeftMargin", "leftPadding", "getLeftPadding", "setLeftPadding", "line", "getLine", "setLine", "lineGap", "getLineGap", "setLineGap", "lineHeight", "", "getLineHeight", "setLineHeight", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "getMKeyboardActionListener", "()Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "setMKeyboardActionListener", "(Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;)V", "mLastClickButton", "mLastClickTime", "", "mLastUpperMode", "mUpperMode", "originData", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "resMap", "rightMargin", "getRightMargin", "setRightMargin", "rightPadding", "getRightPadding", "setRightPadding", "swipeable", "getSwipeable", "setSwipeable", "topMargin", "getTopMargin", "setTopMargin", "touchListener", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "getTouchListener", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "setTouchListener", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;)V", "triggerLeftDeleteMode", "vHeight", "getVHeight", "setVHeight", "vWidth", "getVWidth", "setVWidth", "bindView2Key", "", "view", "id", "calculateButtonData", "keyboard", "checkIsTouchInButton", "event", "Landroid/view/MotionEvent;", "checkNeedCalculate", "childContains", "value", "closeDeleteTouch", "btn", "dealDefaultConfigKey", "data", "doDelete", "deleteLength", "delayTime", "fetchOriginConfig", "findButtonById", "getActionButton", "getCurrentModeInt", "getEnterKey", "getHeightScale", "", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getPointId", "getResId", "s", "getUpperMode", "getWidthScale", "handleDeleteKey", "button", "reportKeyArea", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;Landroid/view/MotionEvent;Ljava/lang/Integer;)Z", "handleDoubleClick", "initButtonActionDispatch", "initButtonDrawer", "initConfig", "initKeyboardConfig", "config", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardConfig;", "isEnterKey", "isOnlySupportClickFloatViewKey", "isSupportFloatViewKey", "isUpper", "normalScale", "i", "(Ljava/lang/Float;)F", "onButtonClick", "onButtonLongClick", "onButtonPress", "onButtonUp", "onClick", "v", "onClickForSupportDoubleClick", "onCreate", "onDoubleClick", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onInitFinish", "onLayout", "changed", "l", "t", "r", "b", "onLongClick", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onReset", "onResume", "listener", "onSelectCandidate", "text", "", "suffix", "onTouch", "onTouchEvent", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "parseData", "path", "recordActionButton", "reset", "scaleHeight", "scaleWidth", "setOnTouchListener", "shouldCareEvent", "supportDoubleClick", "switchUpperMode", "upperMode", "transparentBg", "transparent", "updateEnterKey", "actionStr", "actionMode", "updateUpperKey", "updateUpperKeyImp", "visitImeButton", "visitor", "Lkotlin/Function1;", "Companion", "KeyArea", "KeyOperation", "OnTouchListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class KeyboardView
  extends Keyboard
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final KeyboardView.a Jtc = new KeyboardView.a((byte)0);
  private int Ips;
  private int Ipt;
  private com.tencent.mm.plugin.hld.a.c Jpf;
  private int JqW;
  private int JqX = 1;
  private long JqZ;
  private Future<?> Jrb;
  private Future<?> Jrc;
  private int Jrd;
  private int Jrf;
  private boolean Jrg;
  private boolean JsT;
  private boolean Jtd;
  private b Jte;
  private c Jtf;
  private final KeyboardData Jtg;
  private int Jth;
  private final Map<String, View> Jti = (Map)new LinkedHashMap();
  private boolean Jtj;
  private int Jtk;
  private int Jtl;
  private int Jtm;
  private List<List<b>> Jtn = (List)new ArrayList();
  private a Jto;
  private boolean Jtp;
  private final Map<String, Integer> Jtq = (Map)new LinkedHashMap();
  private d Jtr;
  private Integer Jts;
  private int Jtt;
  private int Jtu;
  private b Jtv;
  private boolean Jtw;
  private int bmt;
  private int bmu;
  private int bmv;
  private int bmw;
  private int line;
  private List<Integer> lineHeight = (List)ab.aivy;
  
  public KeyboardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(fLS().deepCopy());
    this.Jtg = fLS();
    this.Jth = getCurrentModeInt();
  }
  
  public KeyboardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(fLS().deepCopy());
    this.Jtg = fLS();
    this.Jth = getCurrentModeInt();
  }
  
  public KeyboardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    a(fLS().deepCopy());
    this.Jtg = fLS();
    this.Jth = getCurrentModeInt();
  }
  
  private static final void a(long paramLong, KeyboardView paramKeyboardView, int paramInt)
  {
    s.u(paramKeyboardView, "this$0");
    Log.i("WxIme.KeyboardView", s.X("doDeleteImp inter time:", Long.valueOf(System.currentTimeMillis() - paramLong)));
    com.tencent.mm.plugin.hld.a.c localc = paramKeyboardView.getMKeyboardActionListener();
    if (localc != null) {
      localc.K(1, new Keyboard.a(paramKeyboardView.Jrd, paramInt));
    }
  }
  
  private static final void a(KeyboardView paramKeyboardView)
  {
    s.u(paramKeyboardView, "this$0");
    for (;;)
    {
      int i;
      long l;
      try
      {
        Thread.sleep(100L);
        int j = 1;
        i = j;
        if (paramKeyboardView.Jrd == 2)
        {
          l = System.currentTimeMillis();
          c localc = paramKeyboardView.Jtf;
          s.checkNotNull(localc);
          l -= localc.time;
          if (l > 2000L) {
            i = 3;
          }
        }
        else
        {
          paramKeyboardView.aE(i, 0L);
          continue;
        }
        i = j;
      }
      catch (InterruptedException paramKeyboardView)
      {
        Log.e("WxIme.KeyboardView", s.X("deleteFuture ", paramKeyboardView.getMessage()));
        return;
      }
      if (l > 5000L) {
        i = 5;
      }
    }
  }
  
  private final void a(KeyboardConfig paramKeyboardConfig)
  {
    int j = 1;
    boolean bool = false;
    Object localObject1 = paramKeyboardConfig.getVWidth();
    int i;
    if (localObject1 == null)
    {
      i = 1;
      setVWidth(i);
      localObject1 = paramKeyboardConfig.getVHeight();
      if (localObject1 != null) {
        break label166;
      }
      i = j;
      label41:
      setVHeight(i);
      localObject1 = paramKeyboardConfig.getLine();
      if (localObject1 != null) {
        break label177;
      }
      i = 0;
      label61:
      setLine(i);
      localObject1 = paramKeyboardConfig.getSwipeable();
      if (localObject1 != null) {
        break label187;
      }
    }
    float f2;
    for (;;)
    {
      setSwipeable(bool);
      setLineGap((int)c(paramKeyboardConfig.getLineGap()));
      f2 = 0.0F;
      float f1 = 0.0F;
      localObject1 = paramKeyboardConfig.getLineHeight();
      if (localObject1 == null) {
        break label197;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        f2 = f1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        f1 = ((Number)((Iterator)localObject1).next()).floatValue() + f1;
      }
      i = (int)((Float)localObject1).floatValue();
      break;
      label166:
      i = (int)((Float)localObject1).floatValue();
      break label41;
      label177:
      i = ((Integer)localObject1).intValue();
      break label61;
      label187:
      bool = ((Boolean)localObject1).booleanValue();
    }
    label197:
    localObject1 = paramKeyboardConfig.getLineHeight();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (List)localObject1)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)ab.aivy;
      }
      setLineHeight((List)localObject2);
      setLeftPadding((int)b(paramKeyboardConfig.getPaddingLeft()));
      setRightPadding((int)b(paramKeyboardConfig.getPaddingRight()));
      setLeftMargin((int)b(paramKeyboardConfig.getMarginLeft()));
      setRightMargin((int)b(paramKeyboardConfig.getMarginRight()));
      setTopMargin((int)c(paramKeyboardConfig.getMarginTop()));
      setBottomMargin((int)c(paramKeyboardConfig.getMarginBottom()));
      return;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(Integer.valueOf((int)(c(Float.valueOf(((Number)((Iterator)localObject2).next()).floatValue())) * getVHeight() / f2)));
      }
    }
  }
  
  private void a(KeyboardData paramKeyboardData)
  {
    s.u(paramKeyboardData, "data");
    this.Jtn.clear();
    reset();
    a(paramKeyboardData.getConfig());
    c(paramKeyboardData);
    b(paramKeyboardData);
    this.Jtj = true;
  }
  
  private final void aE(int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    this.Jrc = ((Future)h.ahAA.o(new KeyboardView..ExternalSyntheticLambda0(l, this, paramInt), paramLong));
  }
  
  private final int aIo(String paramString)
  {
    Object localObject = (Integer)this.Jtq.get(paramString);
    if (localObject == null)
    {
      if (paramString == null) {
        return 0;
      }
      if (new kotlin.n.k("^[@](style|drawable|color|raw)[/].*$").bm((CharSequence)paramString))
      {
        localObject = kotlin.n.n.a(paramString, kotlin.k.k.qt(1, kotlin.n.n.a((CharSequence)paramString, '/', 0, false, 6)));
        int i = kotlin.n.n.a((CharSequence)paramString, '/', 0, false, 6);
        if (paramString == null) {
          throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String str = paramString.substring(i + 1);
        s.s(str, "(this as java.lang.String).substring(startIndex)");
        i = getResources().getIdentifier(str, (String)localObject, getContext().getPackageName());
        this.Jtq.put(paramString, Integer.valueOf(i));
        return i;
      }
      return 0;
    }
    return ((Integer)localObject).intValue();
  }
  
  private static int ae(MotionEvent paramMotionEvent)
  {
    s.u(paramMotionEvent, "event");
    return paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
  }
  
  private final void ag(MotionEvent paramMotionEvent)
  {
    b localb = getActionButton();
    if (localb == null) {}
    for (paramMotionEvent = null;; paramMotionEvent = ah.aiuX)
    {
      if (paramMotionEvent == null) {
        ((KeyboardView)this).Jtw = false;
      }
      return;
      this.Jtw = localb.jo((int)paramMotionEvent.getX(paramMotionEvent.findPointerIndex(ae(paramMotionEvent))), (int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(ae(paramMotionEvent))));
    }
  }
  
  private final float b(Float paramFloat)
  {
    if (paramFloat == null) {
      return 0.0F;
    }
    ((Number)paramFloat).floatValue();
    float f = paramFloat.floatValue();
    paramFloat = getContext();
    s.s(paramFloat, "context");
    return f * ie(paramFloat);
  }
  
  private final void b(KeyboardData paramKeyboardData)
  {
    Log.d("WxIme.KeyboardView", getKeyboardType().ordinal() + " calculateButtonData height:" + c(Float.valueOf(1.0F)) + " width:" + b(Float.valueOf(1.0F)));
    int i = this.bmv;
    int n = this.Ips;
    Iterator localIterator1 = ((Iterable)paramKeyboardData.getKeys()).iterator();
    int j = 0;
    while (localIterator1.hasNext())
    {
      paramKeyboardData = localIterator1.next();
      if (j < 0) {
        p.kkW();
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
        s.checkNotNull(paramKeyboardData);
        localb.width = ((int)paramKeyboardData.floatValue());
        paramKeyboardData = localKeyData.getHeight();
        s.checkNotNull(paramKeyboardData);
        localb.height = ((int)paramKeyboardData.floatValue());
        paramKeyboardData = localKeyData.getType();
        label242:
        Object localObject;
        float f1;
        float f2;
        boolean bool;
        if (paramKeyboardData == null)
        {
          m = 0;
          localb.type = m;
          localObject = localKeyData.getDrawerType();
          paramKeyboardData = (KeyboardData)localObject;
          if (localObject == null) {
            paramKeyboardData = "";
          }
          localb.setDrawerType(paramKeyboardData);
          paramKeyboardData = localb.JsF;
          f1 = k;
          localObject = localKeyData.getLeftMargin();
          s.checkNotNull(localObject);
          m = (int)(f1 + ((Float)localObject).floatValue());
          f1 = i;
          localObject = localKeyData.getTopMargin();
          s.checkNotNull(localObject);
          int i1 = (int)(f1 + ((Float)localObject).floatValue());
          f1 = k;
          localObject = localKeyData.getLeftMargin();
          s.checkNotNull(localObject);
          int i2 = (int)(f1 + ((Float)localObject).floatValue() + localb.width);
          f1 = i;
          localObject = localKeyData.getTopMargin();
          s.checkNotNull(localObject);
          paramKeyboardData.set(m, i1, i2, (int)(f1 + ((Float)localObject).floatValue() + localb.height));
          paramKeyboardData = localb.JsG;
          f1 = k;
          localObject = localKeyData.getLeftMargin();
          s.checkNotNull(localObject);
          f2 = ((Float)localObject).floatValue();
          localObject = localKeyData.getLeftPadding();
          s.checkNotNull(localObject);
          m = (int)(f1 + f2 + ((Float)localObject).floatValue());
          f1 = i;
          localObject = localKeyData.getTopMargin();
          s.checkNotNull(localObject);
          f2 = ((Float)localObject).floatValue();
          localObject = localKeyData.getTopPadding();
          s.checkNotNull(localObject);
          i1 = (int)(f1 + f2 + ((Float)localObject).floatValue());
          f1 = k;
          localObject = localKeyData.getLeftMargin();
          s.checkNotNull(localObject);
          f2 = ((Float)localObject).floatValue();
          float f3 = localb.width;
          localObject = localKeyData.getRightPadding();
          s.checkNotNull(localObject);
          i2 = (int)(f1 + f2 + f3 - ((Float)localObject).floatValue());
          f1 = i;
          localObject = localKeyData.getTopMargin();
          s.checkNotNull(localObject);
          f2 = ((Float)localObject).floatValue();
          f3 = localb.height;
          localObject = localKeyData.getBottomPadding();
          s.checkNotNull(localObject);
          paramKeyboardData.set(m, i1, i2, (int)(f1 + f2 + f3 - ((Float)localObject).floatValue()));
          localObject = localKeyData.getMainText();
          paramKeyboardData = (KeyboardData)localObject;
          if (localObject == null) {
            paramKeyboardData = "";
          }
          localb.setMainText(paramKeyboardData);
          paramKeyboardData = localKeyData.getClickable();
          if (paramKeyboardData != null) {
            break label1212;
          }
          bool = false;
          label664:
          localb.sdN = bool;
          paramKeyboardData = localKeyData.getLongClickable();
          if (paramKeyboardData != null) {
            break label1221;
          }
          bool = false;
          label684:
          localb.JsR = bool;
          paramKeyboardData = localKeyData.getTouchFunctionCode();
          if (paramKeyboardData != null) {
            break label1230;
          }
          m = -1;
          label704:
          localb.JsU = m;
          paramKeyboardData = localKeyData.getClickFunctionCode();
          if (paramKeyboardData != null) {
            break label1239;
          }
          m = -1;
          label724:
          localb.JsQ = m;
          paramKeyboardData = localKeyData.getLongClickFunctionCode();
          if (paramKeyboardData != null) {
            break label1248;
          }
          m = -1;
          label744:
          localb.JsS = m;
          paramKeyboardData = localKeyData.getSwipeable();
          if (paramKeyboardData != null) {
            break label1257;
          }
          bool = false;
          label764:
          localb.JsT = bool;
          paramKeyboardData = localKeyData.getBgCorner();
          s.checkNotNull(paramKeyboardData);
          localb.JsM = ((int)paramKeyboardData.floatValue());
          paramKeyboardData = localKeyData.getShadowHeight();
          s.checkNotNull(paramKeyboardData);
          localb.JsN = ((int)paramKeyboardData.floatValue());
          localb.JsL = aIo(localKeyData.getImgSrc());
          paramKeyboardData = localKeyData.getIconWidth();
          if (paramKeyboardData != null) {
            break label1266;
          }
          m = 0;
          label838:
          localb.iconWidth = m;
          paramKeyboardData = localKeyData.getIconHeight();
          if (paramKeyboardData != null) {
            break label1276;
          }
          m = 0;
          label858:
          localb.iconHeight = m;
          paramKeyboardData = getContext();
          localObject = localKeyData.getMainTextSize();
          if (localObject != null) {
            break label1286;
          }
          m = 0;
          label885:
          localb.JsH = com.tencent.mm.cd.a.fromDPToPix(paramKeyboardData, m);
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.JyF;
          paramKeyboardData = getContext();
          s.s(paramKeyboardData, "context");
          localb.JsI = com.tencent.mm.plugin.hld.f.k.bh(paramKeyboardData, localKeyData.getMainTextColor());
          paramKeyboardData = getContext();
          localObject = localKeyData.getFloatTextSize();
          if (localObject != null) {
            break label1296;
          }
        }
        label1286:
        label1296:
        for (m = 0;; m = ((Integer)localObject).intValue())
        {
          localb.JsJ = com.tencent.mm.cd.a.fromDPToPix(paramKeyboardData, m);
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.JyF;
          paramKeyboardData = getContext();
          s.s(paramKeyboardData, "context");
          localb.JsK = com.tencent.mm.plugin.hld.f.k.bh(paramKeyboardData, localKeyData.getFloatTextColor());
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.JyF;
          paramKeyboardData = getContext();
          s.s(paramKeyboardData, "context");
          localb.bgColor = com.tencent.mm.plugin.hld.f.k.bh(paramKeyboardData, localKeyData.getBgColor());
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.JyF;
          paramKeyboardData = getContext();
          s.s(paramKeyboardData, "context");
          localb.shadowColor = com.tencent.mm.plugin.hld.f.k.bh(paramKeyboardData, localKeyData.getShadowColor());
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.JyF;
          paramKeyboardData = getContext();
          s.s(paramKeyboardData, "context");
          localb.JsO = com.tencent.mm.plugin.hld.f.k.bh(paramKeyboardData, localKeyData.getInitialColor());
          paramKeyboardData = com.tencent.mm.plugin.hld.f.k.JyF;
          paramKeyboardData = getContext();
          s.s(paramKeyboardData, "context");
          localb.JsP = com.tencent.mm.plugin.hld.f.k.bh(paramKeyboardData, localKeyData.getPressMaskColor());
          localObject = localKeyData.getFloatText();
          paramKeyboardData = (KeyboardData)localObject;
          if (localObject == null) {
            paramKeyboardData = "";
          }
          localb.setFloatText(paramKeyboardData);
          paramKeyboardData = ah.aiuX;
          localList.add(localb);
          paramKeyboardData = localKeyData.getLeftMargin();
          s.checkNotNull(paramKeyboardData);
          f1 = paramKeyboardData.floatValue();
          paramKeyboardData = localKeyData.getWidth();
          s.checkNotNull(paramKeyboardData);
          f2 = paramKeyboardData.floatValue();
          paramKeyboardData = localKeyData.getRightMargin();
          s.checkNotNull(paramKeyboardData);
          k = (int)(paramKeyboardData.floatValue() + (f1 + f2)) + k;
          break;
          m = paramKeyboardData.intValue();
          break label242;
          label1212:
          bool = paramKeyboardData.booleanValue();
          break label664;
          label1221:
          bool = paramKeyboardData.booleanValue();
          break label684;
          label1230:
          m = paramKeyboardData.intValue();
          break label704;
          label1239:
          m = paramKeyboardData.intValue();
          break label724;
          label1248:
          m = paramKeyboardData.intValue();
          break label744;
          label1257:
          bool = paramKeyboardData.booleanValue();
          break label764;
          label1266:
          m = (int)paramKeyboardData.floatValue();
          break label838;
          label1276:
          m = (int)paramKeyboardData.floatValue();
          break label858;
          m = ((Integer)localObject).intValue();
          break label885;
        }
      }
      getImeButtons().add(localList);
      k = ((Number)getLineHeight().get(j)).intValue();
      int m = getLineGap();
      j += 1;
      i = k + m + i;
    }
  }
  
  private final float c(Float paramFloat)
  {
    if (paramFloat == null) {
      return 0.0F;
    }
    ((Number)paramFloat).floatValue();
    float f = paramFloat.floatValue();
    paramFloat = getContext();
    s.s(paramFloat, "context");
    return f * jdMethod_if(paramFloat);
  }
  
  private final void c(KeyboardData paramKeyboardData)
  {
    KeyData localKeyData1 = paramKeyboardData.getKeyDefaultConfig();
    Iterator localIterator1 = ((Iterable)paramKeyboardData.getKeys()).iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
      label50:
      KeyData localKeyData2;
      Object localObject;
      float f;
      if (localIterator2.hasNext())
      {
        localKeyData2 = (KeyData)localIterator2.next();
        localObject = localKeyData2.getType();
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
        paramKeyboardData = localKeyData2.getIconWidth();
        if (paramKeyboardData != null) {
          break label956;
        }
        paramKeyboardData = localKeyData1.getIconWidth();
        if (paramKeyboardData != null) {
          break label948;
        }
        f = 0.0F;
        label733:
        localKeyData2.setIconWidth(Float.valueOf(d(Float.valueOf(f))));
        paramKeyboardData = localKeyData2.getIconHeight();
        if (paramKeyboardData != null) {
          break label972;
        }
        paramKeyboardData = localKeyData1.getIconHeight();
        if (paramKeyboardData != null) {
          break label964;
        }
        f = 0.0F;
      }
      for (;;)
      {
        localKeyData2.setIconHeight(Float.valueOf(d(Float.valueOf(f))));
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
        break label50;
        break;
        label948:
        f = paramKeyboardData.floatValue();
        break label733;
        label956:
        f = paramKeyboardData.floatValue();
        break label733;
        label964:
        f = paramKeyboardData.floatValue();
        continue;
        label972:
        f = paramKeyboardData.floatValue();
      }
    }
  }
  
  private final float d(Float paramFloat)
  {
    if (paramFloat == null) {
      return 0.0F;
    }
    float f = ((Number)paramFloat).floatValue();
    return com.tencent.mm.cd.a.fromDPToPix(getContext(), f);
  }
  
  public static boolean f(b paramb)
  {
    s.u(paramb, "btn");
    return ((paramb.type & 0x2) != 2) && ((paramb.type & 0x4) != 4);
  }
  
  private final boolean hP(View paramView)
  {
    boolean bool2 = false;
    int k = getChildCount();
    boolean bool1 = bool2;
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (s.p(getChildAt(i), paramView)) {
        bool1 = true;
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (j >= k);
    }
  }
  
  private final float ie(Context paramContext)
  {
    if (getMeasuredWidth() != 0) {
      return getMeasuredWidth() / this.Jtk;
    }
    com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
    return (float)com.tencent.mm.plugin.hld.f.k.is(paramContext);
  }
  
  private final float jdMethod_if(Context paramContext)
  {
    if (getMeasuredHeight() != 0) {
      return getMeasuredHeight() / this.Jtl;
    }
    com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
    return (float)com.tencent.mm.plugin.hld.f.k.it(paramContext);
  }
  
  public final void Yr(int paramInt)
  {
    this.JqW = this.JqX;
    this.JqX = paramInt;
  }
  
  public boolean Z(MotionEvent paramMotionEvent)
  {
    s.u(paramMotionEvent, "event");
    return false;
  }
  
  public final void a(b paramb, MotionEvent paramMotionEvent)
  {
    Object localObject = null;
    int i = 1;
    s.u(paramb, "btn");
    if (paramb.JsU == 1)
    {
      paramb = this.Jrb;
      if (paramb != null)
      {
        paramb.cancel(true);
        this.Jrb = null;
      }
      if (paramMotionEvent != null) {
        break label81;
      }
      paramb = localObject;
      if (paramb != null) {
        break label92;
      }
      label53:
      if (paramb != null) {
        break label103;
      }
      label57:
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramb = this.Jtf;
        if (paramb != null) {
          paramb.Jtx.wV(false);
        }
      }
      return;
      label81:
      paramb = Integer.valueOf(paramMotionEvent.getActionMasked());
      break;
      label92:
      if (paramb.intValue() != 5) {
        break label53;
      }
      continue;
      label103:
      if (paramb.intValue() != 0) {
        break label57;
      }
    }
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    s.u(paramString1, "text");
    s.u(paramArrayOfByte, "id");
  }
  
  public boolean a(b paramb)
  {
    return false;
  }
  
  protected final boolean a(b paramb, MotionEvent paramMotionEvent, Integer paramInteger)
  {
    s.u(paramb, "button");
    Object localObject1;
    Object localObject2;
    label24:
    int j;
    label44:
    long l;
    label118:
    label123:
    int i;
    if (paramMotionEvent == null)
    {
      localObject1 = null;
      if (paramMotionEvent != null) {
        break label294;
      }
      localObject2 = Double.valueOf(0.0D);
      j = (int)((Float)localObject2).floatValue();
      if (paramMotionEvent != null) {
        break label306;
      }
      paramMotionEvent = Double.valueOf(0.0D);
      int k = (int)((Float)paramMotionEvent).floatValue();
      l = System.currentTimeMillis();
      Log.d("WxIme.KeyboardView", "handleBackKey action " + localObject1 + ' ' + j + ' ' + k + ' ' + l);
      if (localObject1 != null) {
        break label317;
      }
      if (localObject1 != null) {
        break label332;
      }
      i = 0;
      label126:
      if (i == 0) {
        break label352;
      }
      paramMotionEvent = com.tencent.mm.plugin.hld.f.i.JyA;
      paramMotionEvent = getContext();
      s.s(paramMotionEvent, "context");
      com.tencent.mm.plugin.hld.f.i.a(paramb, paramMotionEvent);
      this.Jtf = new c(j, k, l, null, paramb, 0L, 88);
      this.Jrf = paramb.width;
      paramb.wV(true);
      paramb = com.tencent.mm.plugin.hld.model.n.JvW;
      if (!com.tencent.mm.plugin.hld.model.n.fMH()) {
        break label346;
      }
      i = 2;
      label200:
      this.Jrd = i;
      aE(1, 300L);
      paramb = this.Jrb;
      if (paramb != null) {
        paramb.cancel(true);
      }
      this.Jrb = ((Future)h.ahAA.p(new KeyboardView..ExternalSyntheticLambda1(this), 300L));
      if (paramInteger != null)
      {
        i = ((Number)paramInteger).intValue();
        paramb = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.js(i, 1);
      }
    }
    for (;;)
    {
      return false;
      localObject1 = Integer.valueOf(paramMotionEvent.getActionMasked());
      break;
      label294:
      localObject2 = Float.valueOf(paramMotionEvent.getRawX());
      break label24;
      label306:
      paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY());
      break label44;
      label317:
      if (((Integer)localObject1).intValue() != 5) {
        break label118;
      }
      i = 1;
      break label126;
      label332:
      if (((Integer)localObject1).intValue() != 0) {
        break label123;
      }
      i = 1;
      break label126;
      label346:
      i = 1;
      break label200;
      label352:
      if (localObject1 == null)
      {
        label357:
        if (localObject1 != null) {
          break label583;
        }
        label362:
        if (localObject1 != null) {
          break label598;
        }
        label367:
        i = 0;
        label370:
        if (i == 0) {
          break label614;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label638;
        }
        paramb.wV(false);
        paramb = this.Jrb;
        if (paramb != null)
        {
          paramb.cancel(true);
          this.Jrb = null;
        }
        if (!this.Jrg) {
          break label649;
        }
        this.Jrg = false;
        paramb = this.Jtf;
        if (paramb == null) {
          break;
        }
        if (paramb.x - j <= this.Jrf) {
          break label640;
        }
        com.tencent.mm.plugin.hld.model.n.JvW.fMR();
        break;
        if (((Integer)localObject1).intValue() != 2) {
          break label357;
        }
        if (this.Jrg) {
          break;
        }
        paramb = this.Jtf;
        if ((paramb == null) || (this.Jrd != 1)) {
          break;
        }
        paramMotionEvent = this.Jtf;
        s.checkNotNull(paramMotionEvent);
        if ((l - paramMotionEvent.time >= 295L) || (paramb.x - j <= this.Jrf) || (this.Jrf == 0)) {
          break;
        }
        paramb = this.Jrb;
        if (paramb != null)
        {
          paramb.cancel(true);
          this.Jrb = null;
        }
        paramb = this.Jrc;
        if (paramb != null)
        {
          paramb.cancel(true);
          this.Jrc = null;
        }
        this.Jrg = true;
        break;
        label583:
        if (((Integer)localObject1).intValue() != 3) {
          break label362;
        }
        i = 1;
        break label370;
        label598:
        if (((Integer)localObject1).intValue() != 6) {
          break label367;
        }
        i = 1;
        break label370;
        label614:
        if (localObject1 == null) {}
        while (((Integer)localObject1).intValue() != 1)
        {
          i = 0;
          break;
        }
        i = 1;
      }
      label638:
      continue;
      label640:
      aE(1, 0L);
      continue;
      label649:
      paramb = this.Jtf;
      s.checkNotNull(paramb);
      if (l - paramb.time < 295L)
      {
        paramb = this.Jrc;
        if (paramb != null)
        {
          paramb.cancel(true);
          this.Jrc = null;
        }
        aE(1, 0L);
      }
    }
  }
  
  public final b aIp(String paramString)
  {
    s.u(paramString, "id");
    final ah.f localf = new ah.f();
    ay((kotlin.g.a.b)new e(paramString, localf));
    return (b)localf.aqH;
  }
  
  public final boolean af(MotionEvent paramMotionEvent)
  {
    s.u(paramMotionEvent, "event");
    return (paramMotionEvent.getPointerCount() == paramMotionEvent.getActionIndex() + 1) && (!this.Jtd);
  }
  
  protected final void ay(kotlin.g.a.b<? super b, ah> paramb)
  {
    s.u(paramb, "visitor");
    Iterator localIterator1 = ((Iterable)this.Jtn).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        paramb.invoke((b)localIterator2.next());
      }
    }
  }
  
  public void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.Jpf = paramc;
    requestLayout();
    invalidate();
  }
  
  public void b(b paramb) {}
  
  public void c(b paramb) {}
  
  public boolean d(b paramb)
  {
    s.u(paramb, "button");
    return false;
  }
  
  public final boolean e(b paramb)
  {
    b localb = this.Jte;
    long l = this.JqZ;
    this.Jte = paramb;
    this.JqZ = System.currentTimeMillis();
    if (!a(paramb)) {
      return false;
    }
    if ((s.p(paramb, localb)) && (System.currentTimeMillis() - l <= 200L))
    {
      c(paramb);
      return true;
    }
    Log.d("WxIme.KeyboardView", "supportDoubleKeyOnClickHandler");
    b(paramb);
    return true;
  }
  
  public final void fG(String paramString, int paramInt)
  {
    s.u(paramString, "actionStr");
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
      localb.sdN = true;
      localb.bgColor = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_grey_color);
      localb.shadowColor = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_grey_shadow_color);
      localb.JsP = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_pressed_mask_color);
      localb.JsI = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_text_color);
      continue;
      localb.sdN = true;
      localb.bgColor = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_green_color);
      localb.shadowColor = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_green_shadow_color);
      localb.JsP = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_pressed_mask_color);
      localb.JsI = com.tencent.mm.cd.a.w(getContext(), a.c.White);
      continue;
      localb.sdN = false;
      localb.bgColor = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_grey_color);
      localb.shadowColor = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_grey_shadow_color);
      localb.JsP = com.tencent.mm.cd.a.w(getContext(), a.c.ime_key_pressed_mask_color);
      localb.JsI = com.tencent.mm.cd.a.w(getContext(), a.c.S2_text_invalid_color);
    }
  }
  
  public final boolean fLL()
  {
    return this.JqX != 1;
  }
  
  public final void fLM()
  {
    if (this.JqW != this.JqX) {
      fLN();
    }
  }
  
  protected void fLN() {}
  
  public abstract a fLR();
  
  public abstract KeyboardData fLS();
  
  public void fLT() {}
  
  public boolean g(b paramb)
  {
    s.u(paramb, "btn");
    return false;
  }
  
  public final b getActionButton()
  {
    return this.Jtv;
  }
  
  public final boolean getAllDataComplete()
  {
    return this.Jtj;
  }
  
  public final int getBottomMargin()
  {
    return this.bmw;
  }
  
  public final a getButtonDrawer()
  {
    return this.Jto;
  }
  
  public final int getCurrentModeInt()
  {
    Object localObject1 = new StringBuilder("keyboard").append(getKeyboardType().ordinal()).append(" getCurrentModeInt: isDarkMode=").append(aw.isDarkMode()).append("  isLandscape=");
    Object localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
    Log.d("WxIme.KeyboardView", com.tencent.mm.plugin.hld.f.k.isLandscape());
    localObject1 = (List)new ArrayList();
    if (aw.isDarkMode()) {
      ((List)localObject1).add(c.Jta);
    }
    localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
    if (com.tencent.mm.plugin.hld.f.k.isLandscape()) {
      ((List)localObject1).add(c.JsZ);
    }
    localObject2 = q.Jwz;
    return q.iA((List)localObject1);
  }
  
  protected b getEnterKey()
  {
    return null;
  }
  
  public final List<List<b>> getImeButtons()
  {
    return this.Jtn;
  }
  
  public com.tencent.mm.plugin.hld.keyboard.c getKeyboardType()
  {
    return com.tencent.mm.plugin.hld.keyboard.c.Jrp;
  }
  
  public final int getLeftMargin()
  {
    return this.bmt;
  }
  
  public final int getLeftPadding()
  {
    return this.Ips;
  }
  
  public final int getLine()
  {
    return this.line;
  }
  
  public final int getLineGap()
  {
    return this.Jtm;
  }
  
  public final List<Integer> getLineHeight()
  {
    return this.lineHeight;
  }
  
  protected final com.tencent.mm.plugin.hld.a.c getMKeyboardActionListener()
  {
    return this.Jpf;
  }
  
  public final int getRightMargin()
  {
    return this.bmu;
  }
  
  public final int getRightPadding()
  {
    return this.Ipt;
  }
  
  public final boolean getSwipeable()
  {
    return this.JsT;
  }
  
  public final int getTopMargin()
  {
    return this.bmv;
  }
  
  public final d getTouchListener()
  {
    return this.Jtr;
  }
  
  public int getUpperMode()
  {
    return this.JqX;
  }
  
  public final int getVHeight()
  {
    return this.Jtl;
  }
  
  public final int getVWidth()
  {
    return this.Jtk;
  }
  
  public final void h(View paramView, String paramString)
  {
    s.u(paramView, "view");
    s.u(paramString, "id");
    this.Jti.put(paramString, paramView);
  }
  
  public void h(b paramb)
  {
    s.u(paramb, "button");
  }
  
  public boolean i(b paramb)
  {
    s.u(paramb, "button");
    return false;
  }
  
  public void j(b paramb)
  {
    s.u(paramb, "button");
    if (paramb.JsU == 1) {
      a(paramb, null);
    }
  }
  
  public final void onClick(View paramView)
  {
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    paramView = getActionButton();
    if ((paramView != null) && (paramView.sdN) && (this.Jtw))
    {
      paramView.ajZ("initial");
      localObject = paramView.Hop;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(paramView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public final void onCreate()
  {
    if (!this.Jtp)
    {
      setWillNotDraw(false);
      this.Jto = fLR();
      setOnClickListener((View.OnClickListener)this);
      setOnLongClickListener((View.OnLongClickListener)this);
      ay((kotlin.g.a.b)new f(this));
      fLT();
      this.Jtp = true;
      requestLayout();
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((paramCanvas != null) && (this.Jtj))
    {
      a locala = this.Jto;
      if (locala != null)
      {
        s.u(paramCanvas, "canvas");
        locala.cxr = paramCanvas;
      }
      ay((kotlin.g.a.b)new g(this));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getCurrentModeInt() != this.Jth)
    {
      a(fLS().deepCopy());
      this.Jth = getCurrentModeInt();
    }
    invalidate();
    if (this.Jtj)
    {
      Iterator localIterator = ((Iterable)this.Jti.entrySet()).iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (hP((View)localEntry.getValue()))
        {
          b localb = aIp((String)localEntry.getKey());
          if (localb != null) {
            ((View)localEntry.getValue()).layout(localb.JsG.left, localb.JsG.top, localb.JsG.right, localb.JsG.bottom);
          }
        }
      }
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    paramView = getActionButton();
    if ((paramView != null) && (paramView.JsR) && (this.Jtw))
    {
      this.Jtd = true;
      paramView.ajZ("press");
      localObject = paramView.JsV;
      boolean bool;
      if (localObject == null) {
        bool = false;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        return bool;
        paramView = (Boolean)((kotlin.g.a.b)localObject).invoke(paramView);
        if (paramView == null) {
          bool = false;
        } else {
          bool = paramView.booleanValue();
        }
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Iterator localIterator = ((Iterable)this.Jti.entrySet()).iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (hP((View)localEntry.getValue()))
      {
        b localb = aIp((String)localEntry.getKey());
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
    Yr(1);
    fLM();
    reset();
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i;
    if (paramMotionEvent != null) {
      if (paramMotionEvent.getActionMasked() == 5)
      {
        localObject = getActionButton();
        if ((localObject != null) && (((b)localObject).jo((int)paramMotionEvent.getX(paramMotionEvent.findPointerIndex(ae(paramMotionEvent))), (int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(ae(paramMotionEvent)))) == true))
        {
          i = 1;
          if (i == 0) {
            break label78;
          }
          bool = false;
        }
      }
    }
    label78:
    do
    {
      return bool;
      i = 0;
      break;
      switch (paramMotionEvent.getActionMasked())
      {
      case 3: 
      case 4: 
      default: 
        i = 0;
      }
    } while (i != 0);
    return super.onTouchEvent(paramMotionEvent);
    Object localObject = this.Jtv;
    if (localObject != null) {
      ((b)localObject).fLQ();
    }
    reset();
    this.Jtv = null;
    this.Jtt = ((int)paramMotionEvent.getX(paramMotionEvent.findPointerIndex(ae(paramMotionEvent))));
    this.Jtu = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(ae(paramMotionEvent))));
    ay((kotlin.g.a.b)new h(this));
    this.Jts = Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    ag(paramMotionEvent);
    localObject = getActionButton();
    if (localObject != null)
    {
      ((b)localObject).ajZ("press");
      kotlin.g.a.b localb = ((b)localObject).JsW;
      if (localb != null) {
        localb.invoke(localObject);
      }
    }
    localObject = getTouchListener();
    if ((localObject != null) && (((d)localObject).Z(paramMotionEvent) == true))
    {
      i = 1;
      label296:
      if (i == 0) {
        break label497;
      }
    }
    label366:
    label497:
    for (int j = 1;; j = 0)
    {
      i = j;
      if (j != 0) {
        break;
      }
      i = j;
      if (!Z(paramMotionEvent)) {
        break;
      }
      i = 1;
      break;
      i = 0;
      break label296;
      if (af(paramMotionEvent)) {
        ag(paramMotionEvent);
      }
      localObject = getTouchListener();
      if ((localObject != null) && (((d)localObject).Z(paramMotionEvent) == true))
      {
        i = 1;
        if (i == 0) {
          break label492;
        }
      }
      for (j = 1;; j = 0)
      {
        i = j;
        if (j != 0) {
          break;
        }
        i = j;
        if (!Z(paramMotionEvent)) {
          break;
        }
        i = 1;
        break;
        i = 0;
        break label366;
        localObject = getTouchListener();
        if ((localObject != null) && (((d)localObject).Z(paramMotionEvent) == true))
        {
          i = 1;
          if (i == 0) {
            break label487;
          }
        }
        for (i = 1;; i = 0)
        {
          j = i;
          if (i == 0)
          {
            j = i;
            if (Z(paramMotionEvent)) {
              j = 1;
            }
          }
          i = j;
          if (!af(paramMotionEvent)) {
            break;
          }
          localObject = getActionButton();
          if (localObject != null) {
            ((b)localObject).fLQ();
          }
          reset();
          i = j;
          break;
          i = 0;
          break label423;
        }
      }
    }
  }
  
  public final void reset()
  {
    this.Jts = null;
    b localb = this.Jtv;
    if (localb != null) {
      localb.ajZ("initial");
    }
    this.Jtv = null;
    this.Jtt = 0;
    this.Jtu = 0;
    this.Jtd = false;
  }
  
  public final void setAllDataComplete(boolean paramBoolean)
  {
    this.Jtj = paramBoolean;
  }
  
  public final void setBottomMargin(int paramInt)
  {
    this.bmw = paramInt;
  }
  
  public final void setButtonDrawer(a parama)
  {
    this.Jto = parama;
  }
  
  public final void setImeButtons(List<List<b>> paramList)
  {
    s.u(paramList, "<set-?>");
    this.Jtn = paramList;
  }
  
  public final void setLeftMargin(int paramInt)
  {
    this.bmt = paramInt;
  }
  
  public final void setLeftPadding(int paramInt)
  {
    this.Ips = paramInt;
  }
  
  public final void setLine(int paramInt)
  {
    this.line = paramInt;
  }
  
  public final void setLineGap(int paramInt)
  {
    this.Jtm = paramInt;
  }
  
  public final void setLineHeight(List<Integer> paramList)
  {
    s.u(paramList, "<set-?>");
    this.lineHeight = paramList;
  }
  
  protected final void setMKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.Jpf = paramc;
  }
  
  public final void setOnTouchListener(d paramd)
  {
    s.u(paramd, "listener");
    this.Jtr = paramd;
  }
  
  public final void setRightMargin(int paramInt)
  {
    this.bmu = paramInt;
  }
  
  public final void setRightPadding(int paramInt)
  {
    this.Ipt = paramInt;
  }
  
  public final void setSwipeable(boolean paramBoolean)
  {
    this.JsT = paramBoolean;
  }
  
  public final void setTopMargin(int paramInt)
  {
    this.bmv = paramInt;
  }
  
  public final void setTouchListener(d paramd)
  {
    this.Jtr = paramd;
  }
  
  public final void setVHeight(int paramInt)
  {
    this.Jtl = paramInt;
  }
  
  public final void setVWidth(int paramInt)
  {
    this.Jtk = paramInt;
  }
  
  public void wS(boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyArea;", "", "x", "", "y", "rightX", "bottomY", "(IIII)V", "getBottomY", "()I", "getRightX", "getX", "getY", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final int Jri;
    final int Jrj;
    final int x;
    final int y;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.x = paramInt1;
      this.y = paramInt2;
      this.Jri = paramInt3;
      this.Jrj = paramInt4;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "", "x", "", "y", "time", "", "processText", "", "process", "", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "pressTimestamp", "(IIJLjava/lang/String;ZLcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;J)V", "getButton", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "setButton", "(Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;)V", "getPressTimestamp", "()J", "getProcess", "()Z", "setProcess", "(Z)V", "getProcessText", "()Ljava/lang/String;", "setProcessText", "(Ljava/lang/String;)V", "getTime", "getX", "()I", "getY", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    String Jrk;
    public boolean Jrl;
    public final long Jrm;
    b Jtx;
    final long time;
    public final int x;
    public final int y;
    
    private c(int paramInt1, int paramInt2, long paramLong1, String paramString, b paramb, long paramLong2)
    {
      AppMethodBeat.i(313140);
      this.x = paramInt1;
      this.y = paramInt2;
      this.time = paramLong1;
      this.Jrk = paramString;
      this.Jrl = false;
      this.Jtx = paramb;
      this.Jrm = paramLong2;
      AppMethodBeat.o(313140);
    }
    
    public final void aIl(String paramString)
    {
      AppMethodBeat.i(313162);
      s.u(paramString, "<set-?>");
      this.Jrk = paramString;
      AppMethodBeat.o(313162);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "", "onTouch", "", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract boolean Z(MotionEvent paramMotionEvent);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<b, ah>
  {
    e(String paramString, ah.f<b> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<b, ah>
  {
    f(KeyboardView paramKeyboardView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<b, ah>
  {
    g(KeyboardView paramKeyboardView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<b, ah>
  {
    h(KeyboardView paramKeyboardView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView
 * JD-Core Version:    0.7.0.1
 */