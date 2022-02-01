package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.i;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentKeyArea", "Lcom/tencent/mm/plugin/hld/keyboard/KeyArea;", "diffScale", "", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "letterKeyList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "Lkotlin/collections/ArrayList;", "computeMedia", "", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "handleClickUpperKey", "doubleClick", "", "handleNormalTouch", "v", "event", "Landroid/view/MotionEvent;", "onClick", "Landroid/view/View;", "onClickForSupportDoubleClick", "onCreate", "onDoubleClick", "onLongClick", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onTextKeyClick", "onTouch", "onUpperSlide", "supportDoubleClick", "transparentBg", "transparent", "updateChildrenView", "id", "isLetter", "updateKeyUpperStatus", "isUpper", "updateUpperKeyImp", "Companion", "plugin-hld_release"})
public final class S3EnglishQwertyKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener
{
  public static final a DyU;
  private b DyL;
  private a DyQ;
  private float DyR;
  private final ArrayList<ImeKeyRelativeLayout> DyT;
  
  static
  {
    AppMethodBeat.i(216002);
    DyU = new a((byte)0);
    AppMethodBeat.o(216002);
  }
  
  public S3EnglishQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S3EnglishQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S3EnglishQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(216001);
    this.DyT = new ArrayList();
    AppMethodBeat.o(216001);
  }
  
  private final void aF(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(215999);
    Object localObject1 = (ImeKeyRelativeLayout)findViewById(paramInt);
    Object localObject2 = (ViewGroup)((ImeKeyRelativeLayout)localObject1).findViewById(a.f.inside_root);
    p.j(localObject2, "button");
    ViewGroup.LayoutParams localLayoutParams = ((ViewGroup)localObject2).getLayoutParams();
    if (localLayoutParams == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(215999);
      throw ((Throwable)localObject1);
    }
    localLayoutParams.height = ((ImeKeyRelativeLayout)localObject1).getKeyHeight();
    localLayoutParams.width = ((int)(((ImeKeyRelativeLayout)localObject1).getKeyWidth() * this.DyR));
    ((ViewGroup)localObject2).setLayoutParams(localLayoutParams);
    ((ImeKeyRelativeLayout)localObject1).setPadding((int)(((ImeKeyRelativeLayout)localObject1).getKeyMarginLeft() * this.DyR), ((ImeKeyRelativeLayout)localObject1).getKeyMarginTop(), (int)(((ImeKeyRelativeLayout)localObject1).getKeyMarginRight() * this.DyR), ((ImeKeyRelativeLayout)localObject1).getKeyMarginBottom());
    if (paramBoolean) {
      this.DyT.add(localObject1);
    }
    localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
    p.j(localObject1, "view");
    if (com.tencent.mm.plugin.hld.f.l.f((ImeKeyRelativeLayout)localObject1))
    {
      localObject2 = com.tencent.mm.plugin.hld.view.g.DIP;
      com.tencent.mm.plugin.hld.view.g.a((View)localObject1, (View.OnClickListener)this);
      ((ImeKeyRelativeLayout)localObject1).setOnLongClickListener((View.OnLongClickListener)this);
      AppMethodBeat.o(215999);
      return;
    }
    localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
    if (com.tencent.mm.plugin.hld.f.l.e((ImeKeyRelativeLayout)localObject1))
    {
      ((ImeKeyRelativeLayout)localObject1).setOnTouchListener((View.OnTouchListener)this);
      AppMethodBeat.o(215999);
      return;
    }
    if (((a((ImeKeyRelativeLayout)localObject1)) || (paramInt == a.f.s3_key_comma) || (paramInt == a.f.s3_key_at)) && (!b((ImeKeyRelativeLayout)localObject1))) {
      ((ImeKeyRelativeLayout)localObject1).setOnLongClickListener((View.OnLongClickListener)this);
    }
    ((ImeKeyRelativeLayout)localObject1).setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(215999);
  }
  
  private final void sN(boolean paramBoolean)
  {
    AppMethodBeat.i(215993);
    int i = getUpperMode();
    if (paramBoolean) {
      switch (i)
      {
      default: 
        Uu(3);
      }
    }
    for (;;)
    {
      eDK();
      AppMethodBeat.o(215993);
      return;
      Uu(1);
      continue;
      switch (i)
      {
      default: 
        Uu(1);
        break;
      case 1: 
        Uu(2);
      }
    }
  }
  
  private final void sO(boolean paramBoolean)
  {
    AppMethodBeat.i(216000);
    Iterator localIterator = this.DyT.iterator();
    if (localIterator.hasNext())
    {
      ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)localIterator.next();
      Object localObject;
      if (paramBoolean)
      {
        localObject = localImeKeyRelativeLayout.getText();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(216000);
          throw ((Throwable)localObject);
        }
        localObject = ((String)localObject).toUpperCase();
        p.j(localObject, "(this as java.lang.String).toUpperCase()");
      }
      for (;;)
      {
        localImeKeyRelativeLayout.b((String)localObject, Boolean.valueOf(paramBoolean));
        break;
        localObject = localImeKeyRelativeLayout.getText();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(216000);
          throw ((Throwable)localObject);
        }
        localObject = ((String)localObject).toLowerCase();
        p.j(localObject, "(this as java.lang.String).toLowerCase()");
      }
    }
    AppMethodBeat.o(216000);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(215987);
    super.b(paramc);
    eDK();
    AppMethodBeat.o(215987);
  }
  
  protected final void eDL()
  {
    AppMethodBeat.i(215994);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.s3_key_upper);
    switch (getUpperMode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215994);
      return;
      localImeKeyButton.UP(a.i.icons_outlined_capslock);
      sO(false);
      AppMethodBeat.o(215994);
      return;
      localImeKeyButton.UP(a.i.icons_filled_capslock);
      sO(true);
      AppMethodBeat.o(215994);
      return;
      localImeKeyButton.UP(a.i.icons_filled_capslocked);
      sO(true);
    }
  }
  
  public final boolean fa(View paramView)
  {
    AppMethodBeat.i(215989);
    if (((paramView instanceof ImeKeyRelativeLayout)) && (((ImeKeyRelativeLayout)paramView).getType() == 2) && (((ImeKeyRelativeLayout)paramView).getFunctionCode() == 3))
    {
      AppMethodBeat.o(215989);
      return true;
    }
    AppMethodBeat.o(215989);
    return false;
  }
  
  public final void fb(View paramView)
  {
    AppMethodBeat.i(215990);
    if ((paramView instanceof ImeKeyRelativeLayout)) {
      switch (((ImeKeyRelativeLayout)paramView).getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(215990);
      return;
      switch (((ImeKeyRelativeLayout)paramView).getFunctionCode())
      {
      default: 
        break;
      case 3: 
        sN(false);
      }
    }
  }
  
  public final void fc(View paramView)
  {
    AppMethodBeat.i(215991);
    super.fc(paramView);
    if ((paramView instanceof ImeKeyRelativeLayout)) {
      switch (((ImeKeyRelativeLayout)paramView).getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(215991);
      return;
      switch (((ImeKeyRelativeLayout)paramView).getFunctionCode())
      {
      default: 
        break;
      case 3: 
        sN(true);
      }
    }
  }
  
  protected final ImeKeyButton getActionKey()
  {
    AppMethodBeat.i(215997);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.s3_key_action);
    AppMethodBeat.o(215997);
    return localImeKeyButton;
  }
  
  public final c getKeyboardType()
  {
    return c.Dyn;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(215988);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S3EnglishQwertyKeyboard", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if (fd(paramView))
      {
        paramView = com.tencent.mm.plugin.hld.model.k.DDb;
        com.tencent.mm.plugin.hld.model.k.hO(301, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215988);
        return;
      }
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) != 2) {
        break label232;
      }
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Up(((ImeKeyRelativeLayout)paramView).getFunctionCode());
      }
    }
    label232:
    while ((((ImeKeyRelativeLayout)paramView).getType() & 0x4) != 4)
    {
      localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.fh(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(215988);
      return;
    }
    localObject1 = ((ImeKeyRelativeLayout)paramView).getText();
    label295:
    Object localObject2;
    if (eDJ())
    {
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215988);
        throw paramView;
      }
      localObject1 = ((String)localObject1).toUpperCase();
      p.j(localObject1, "(this as java.lang.String).toUpperCase()");
      localObject2 = this.DyL;
      if (localObject2 == null) {
        break label374;
      }
    }
    label374:
    for (localObject1 = new com.tencent.mm.plugin.hld.a.g((String)localObject1, ((b)localObject2).Dyi);; localObject1 = new com.tencent.mm.plugin.hld.a.g((String)localObject1))
    {
      localObject2 = getMKeyboardActionListener();
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.hld.a.c)localObject2).b((com.tencent.mm.plugin.hld.a.g)localObject1);
      break;
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215988);
        throw paramView;
      }
      localObject1 = ((String)localObject1).toLowerCase();
      p.j(localObject1, "(this as java.lang.String).toLowerCase()");
      break label295;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(215986);
    super.onCreate();
    Object localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
    if (com.tencent.mm.plugin.hld.f.k.isLandscape()) {}
    Object localObject2;
    int i;
    for (this.DyR = 1.0F;; this.DyR = (i / (((DisplayMetrics)localObject2).widthPixels - i) + 1.0F))
    {
      aF(a.f.s3_key_q, true);
      aF(a.f.s3_key_w, true);
      aF(a.f.s3_key_e, true);
      aF(a.f.s3_key_r, true);
      aF(a.f.s3_key_t, true);
      aF(a.f.s3_key_y, true);
      aF(a.f.s3_key_u, true);
      aF(a.f.s3_key_i, true);
      aF(a.f.s3_key_o, true);
      aF(a.f.s3_key_p, true);
      aF(a.f.s3_key_a, true);
      aF(a.f.s3_key_s, true);
      aF(a.f.s3_key_d, true);
      aF(a.f.s3_key_f, true);
      aF(a.f.s3_key_g, true);
      aF(a.f.s3_key_h, true);
      aF(a.f.s3_key_j, true);
      aF(a.f.s3_key_k, true);
      aF(a.f.s3_key_l, true);
      aF(a.f.s3_key_upper, false);
      aF(a.f.s3_key_z, true);
      aF(a.f.s3_key_x, true);
      aF(a.f.s3_key_c, true);
      aF(a.f.s3_key_v, true);
      aF(a.f.s3_key_b, true);
      aF(a.f.s3_key_n, true);
      aF(a.f.s3_key_m, true);
      aF(a.f.s3_key_delete, false);
      aF(a.f.s3_key_symbol, false);
      aF(a.f.s3_key_number, false);
      aF(a.f.s3_key_comma, false);
      aF(a.f.s3_key_space, false);
      aF(a.f.s3_key_at, false);
      aF(a.f.s3_key_exchange, false);
      aF(a.f.s3_key_action, false);
      eDK();
      AppMethodBeat.o(215986);
      return;
      localObject1 = (ImeKeyRelativeLayout)findViewById(a.f.s3_key_q);
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources();
      p.j(localObject2, "context.resources");
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      i = ((DisplayMetrics)localObject2).widthPixels - ((ImeKeyRelativeLayout)localObject1).getKeyWidth() * 10 - ((ImeKeyRelativeLayout)localObject1).getKeyMarginLeft() * 10 - ((ImeKeyRelativeLayout)localObject1).getKeyMarginRight() * 10;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(215992);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S3EnglishQwertyKeyboard", "onLongClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.f((ImeKeyRelativeLayout)paramView))
      {
        paramView = (d)h.ae(d.class);
        if (paramView != null)
        {
          paramView = paramView.eCD();
          if (paramView != null) {
            paramView.eCo();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(215992);
        return true;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(((ImeKeyRelativeLayout)paramView).getSecondText());
      Object localObject2 = f.DBL;
      localObject2 = (ImeKeyRelativeLayout)paramView;
      paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
      if (paramView == null) {
        p.iCn();
      }
      f.a(3, (ArrayList)localObject1, (ImeKeyRelativeLayout)localObject2, paramView, this.DyL);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(215992);
      return true;
    }
    paramView = f.DBL;
    f.eDS();
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(215992);
    return false;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215996);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      boolean bool;
      if (com.tencent.mm.plugin.hld.f.l.e((ImeKeyRelativeLayout)paramView))
      {
        bool = a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(308));
        AppMethodBeat.o(215996);
        return bool;
      }
      a((ImeKeyRelativeLayout)paramView, paramMotionEvent);
      Object localObject2 = (ImeKeyRelativeLayout)paramView;
      label94:
      int i;
      if (paramMotionEvent != null)
      {
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        if (paramMotionEvent == null) {
          break label260;
        }
        localObject1 = Float.valueOf(paramMotionEvent.getRawX());
        i = (int)((Float)localObject1).floatValue();
        if (paramMotionEvent == null) {
          break label269;
        }
      }
      int j;
      long l;
      label260:
      label269:
      for (paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY());; paramMotionEvent = Double.valueOf(0.0D))
      {
        j = (int)((Float)paramMotionEvent).floatValue();
        l = System.currentTimeMillis();
        paramMotionEvent = ((ImeKeyRelativeLayout)localObject2).getText();
        localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.it("WxIme.S3EnglishQwertyKeyboard", "onTouch action " + paramView + ' ' + i + ' ' + j + ' ' + l + ' ' + paramMotionEvent);
        if (this.DyL == null) {
          break label433;
        }
        localObject1 = this.DyL;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((b)localObject1).Dyg;
        if (localObject1 != null) {
          break label277;
        }
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215996);
        throw paramView;
        paramView = null;
        break;
        localObject1 = Double.valueOf(0.0D);
        break label94;
      }
      label277:
      localObject1 = ((String)localObject1).toLowerCase();
      p.j(localObject1, "(this as java.lang.String).toLowerCase()");
      if (paramMotionEvent == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215996);
        throw paramView;
      }
      Object localObject3 = paramMotionEvent.toLowerCase();
      p.j(localObject3, "(this as java.lang.String).toLowerCase()");
      if (!Util.isEqual((String)localObject1, (String)localObject3)) {
        if (paramView == null)
        {
          if (paramView != null) {
            break label546;
          }
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject1 = new StringBuilder("lastKey:");
          localObject2 = this.DyL;
          if (localObject2 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S3EnglishQwertyKeyboard", ((b)localObject2).Dyg + " currentKey:" + paramMotionEvent + " action:" + paramView);
          label416:
          break label445;
        }
      }
      label417:
      label433:
      label437:
      label441:
      label445:
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(215996);
            return false;
            if (paramView.intValue() != 5) {
              break;
            }
            if (paramView != null) {
              break label556;
            }
            if (paramView != null) {
              break label1230;
            }
            if (paramView != null) {
              break label1849;
            }
          } while ((paramView == null) || (paramView.intValue() != 3));
          ((ImeKeyRelativeLayout)localObject2).setSelected(false);
          paramView = this.DyL;
          if (paramView != null)
          {
            paramView.Dyh = true;
            paramView = x.aazN;
          }
          paramView = f.DBL;
          f.NU(70L);
        } while ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2);
        paramMotionEvent = getMKeyboardActionListener();
      } while (paramMotionEvent == null);
      paramView = this.DyL;
      if (paramView != null) {}
      for (paramView = paramView.Dyg;; paramView = null)
      {
        paramMotionEvent.c(new com.tencent.mm.plugin.hld.a.g(paramView));
        paramView = x.aazN;
        break label417;
        label546:
        if (paramView.intValue() == 0) {
          break label433;
        }
        break;
        label556:
        if (paramView.intValue() != 0) {
          break label437;
        }
        paramView = i.DHq;
        i.d((ImeKeyRelativeLayout)localObject2);
        localObject1 = this.DyL;
        if (localObject1 != null) {
          if ((!((b)localObject1).Dyh) && (!Util.isNullOrNil(((b)localObject1).Dyg)))
          {
            paramView = com.tencent.mm.plugin.hld.f.l.DHK;
            com.tencent.mm.plugin.hld.f.l.it("WxIme.S3EnglishQwertyKeyboard", "process no ACTION_UP input:" + ((b)localObject1).Dyg);
            paramView = (View)((b)localObject1).aFW.get();
            if (paramView != null)
            {
              p.j(paramView, "view");
              paramView.setSelected(false);
              if ((!(paramView instanceof ImeKeyRelativeLayout)) || (!a((ImeKeyRelativeLayout)paramView))) {
                break label764;
              }
              localObject3 = getMKeyboardActionListener();
              if (localObject3 != null)
              {
                ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new com.tencent.mm.plugin.hld.a.g(((b)localObject1).Dyg, ((b)localObject1).Dyi));
                localObject1 = x.aazN;
              }
              localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
              com.tencent.mm.plugin.hld.model.k.fh(paramView);
            }
          }
        }
        for (;;)
        {
          paramView = x.aazN;
          paramView = x.aazN;
          if (!eDJ()) {
            break label1005;
          }
          if (paramMotionEvent != null) {
            break;
          }
          paramView = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(215996);
          throw paramView;
          label764:
          onClick(paramView);
        }
        paramView = paramMotionEvent.toUpperCase();
        p.j(paramView, "(this as java.lang.String).toUpperCase()");
        for (;;)
        {
          this.DyL = new b(i, j, l, paramView, new WeakReference(localObject2), l, 16);
          paramView = new int[2];
          ((ImeKeyRelativeLayout)localObject2).getLocationOnScreen(paramView);
          this.DyQ = new a(paramView[0], paramView[1], paramView[0] + ((ImeKeyRelativeLayout)localObject2).getMeasuredWidth(), paramView[1] + ((ImeKeyRelativeLayout)localObject2).getMeasuredHeight());
          if (!a((ImeKeyRelativeLayout)localObject2)) {
            break label1215;
          }
          paramMotionEvent = (View)localObject2;
          if (!(paramMotionEvent instanceof ImeKeyRelativeLayout)) {
            break label1205;
          }
          paramView = com.tencent.mm.plugin.hld.f.l.DHK;
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S3EnglishQwertyKeyboard", "onTextKeyClick:" + ((ImeKeyRelativeLayout)paramMotionEvent).getType() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getText() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getFunctionCode());
          localObject1 = new ArrayList();
          if (!eDJ()) {
            break label1159;
          }
          paramView = ((ImeKeyRelativeLayout)paramMotionEvent).getText();
          if (paramView != null) {
            break;
          }
          paramView = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(215996);
          throw paramView;
          label1005:
          if (paramMotionEvent == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(215996);
            throw paramView;
          }
          paramView = paramMotionEvent.toLowerCase();
          p.j(paramView, "(this as java.lang.String).toLowerCase()");
        }
        paramView = paramView.toUpperCase();
        p.j(paramView, "(this as java.lang.String).toUpperCase()");
        label1055:
        ((ArrayList)localObject1).add(paramView);
        paramView = f.DBL;
        paramView = (ImeKeyRelativeLayout)paramMotionEvent;
        paramMotionEvent = ((ImeKeyRelativeLayout)paramMotionEvent).getInsideView();
        if (paramMotionEvent == null) {
          p.iCn();
        }
        f.a(1, (ArrayList)localObject1, paramView, paramMotionEvent, this.DyL);
        label1098:
        ((ImeKeyRelativeLayout)localObject2).setSelected(true);
        if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2) {
          break label417;
        }
        paramMotionEvent = getMKeyboardActionListener();
        if (paramMotionEvent == null) {
          break label417;
        }
        paramView = this.DyL;
        if (paramView != null) {}
        for (paramView = paramView.Dyg;; paramView = null)
        {
          paramMotionEvent.a(new com.tencent.mm.plugin.hld.a.g(paramView));
          paramView = x.aazN;
          break;
          label1159:
          paramView = ((ImeKeyRelativeLayout)paramMotionEvent).getText();
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(215996);
            throw paramView;
          }
          paramView = paramView.toLowerCase();
          p.j(paramView, "(this as java.lang.String).toLowerCase()");
          break label1055;
          label1205:
          paramView = f.DBL;
          f.eDS();
          break label1098;
          label1215:
          paramView = f.DBL;
          f.eDS();
          break label1098;
        }
        label1230:
        if (paramView.intValue() != 2) {
          break label441;
        }
        if (a((ImeKeyRelativeLayout)localObject2))
        {
          paramView = this.DyQ;
          if (paramView != null)
          {
            if ((i < paramView.x) || (i > paramView.Dye) || (j < paramView.y) || (j > paramView.Dyf))
            {
              paramView = f.DBL;
              f.eDT();
            }
            paramView = x.aazN;
          }
        }
        paramView = this.DyL;
        if (paramView == null) {
          break label417;
        }
        paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
        paramMotionEvent = new StringBuilder("onTouch ");
        if ((l - paramView.time < 500L) && (Math.abs(j - paramView.y) > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height)))
        {
          bool = true;
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S3EnglishQwertyKeyboard", bool + " diff:" + (l - paramView.time) + " yOffset:" + Math.abs(j - paramView.y) + " minHeight:" + com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height));
          int k = Math.abs(paramView.x - i);
          paramMotionEvent = com.tencent.mm.plugin.hld.f.k.DHH;
          if (k <= com.tencent.mm.plugin.hld.f.k.eGQ()) {
            break label1558;
          }
          paramMotionEvent = com.tencent.mm.plugin.hld.e.c.DxP;
          paramMotionEvent = (View)localObject2;
          localObject1 = ((ImeKeyRelativeLayout)localObject2).getInsideView();
          if (localObject1 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.hld.e.c.a(paramMotionEvent, (View)localObject1, this.DyL, i);
          if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) != 2)
          {
            paramMotionEvent = getMKeyboardActionListener();
            if (paramMotionEvent != null) {
              if (paramView == null) {
                break label1553;
              }
            }
          }
        }
        label1553:
        for (paramView = paramView.Dyg;; paramView = null)
        {
          paramMotionEvent.c(new com.tencent.mm.plugin.hld.a.g(paramView));
          paramView = x.aazN;
          AppMethodBeat.o(215996);
          return true;
          bool = false;
          break;
        }
        label1558:
        if (((a((ImeKeyRelativeLayout)localObject2)) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.s3_key_comma) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.s3_key_at)) && (!b((ImeKeyRelativeLayout)localObject2)) && (l - paramView.time < 500L) && (Math.abs(j - paramView.y) > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height)))
        {
          paramView = new int[2];
          ((ImeKeyRelativeLayout)localObject2).getLocationOnScreen(paramView);
          if ((i >= paramView[0]) && (i <= paramView[0] + ((ImeKeyRelativeLayout)localObject2).getMeasuredWidth()))
          {
            paramView = (View)localObject2;
            if ((paramView instanceof ImeKeyRelativeLayout))
            {
              paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
              com.tencent.mm.plugin.hld.f.l.it("WxIme.S3EnglishQwertyKeyboard", "onUpperSlide:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
              paramMotionEvent = new ArrayList();
              paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getText());
              paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getSecondText());
              localObject1 = f.DBL;
              localObject1 = (ImeKeyRelativeLayout)paramView;
              paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
              if (paramView == null) {
                p.iCn();
              }
              f.a(2, paramMotionEvent, (ImeKeyRelativeLayout)localObject1, paramView, this.DyL);
            }
            for (;;)
            {
              AppMethodBeat.o(215996);
              return true;
              paramView = f.DBL;
              f.eDS();
            }
          }
        }
        paramView = x.aazN;
        break label417;
        label1849:
        if (paramView.intValue() != 1) {
          break label416;
        }
        ((ImeKeyRelativeLayout)localObject2).setSelected(false);
        paramView = this.DyL;
        if (paramView != null)
        {
          paramView.Dyh = true;
          paramView = x.aazN;
        }
        paramView = f.DBL;
        f.NU(70L);
        if (a((ImeKeyRelativeLayout)localObject2))
        {
          paramView = ((ImeKeyRelativeLayout)localObject2).getText();
          if (eDJ())
          {
            if (paramView == null)
            {
              paramView = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(215996);
              throw paramView;
            }
            paramView = paramView.toUpperCase();
            p.j(paramView, "(this as java.lang.String).toUpperCase()");
            label1947:
            paramMotionEvent = this.DyL;
            if (paramMotionEvent == null) {
              break label2042;
            }
          }
          label2042:
          for (paramView = new com.tencent.mm.plugin.hld.a.g(paramView, paramMotionEvent.Dyi);; paramView = new com.tencent.mm.plugin.hld.a.g(paramView))
          {
            paramMotionEvent = getMKeyboardActionListener();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.b(paramView);
              paramView = x.aazN;
            }
            paramView = com.tencent.mm.plugin.hld.model.k.DDb;
            com.tencent.mm.plugin.hld.model.k.fh((View)localObject2);
            break;
            if (paramView == null)
            {
              paramView = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(215996);
              throw paramView;
            }
            paramView = paramView.toLowerCase();
            p.j(paramView, "(this as java.lang.String).toLowerCase()");
            break label1947;
          }
        }
        onClick((View)localObject2);
        break label417;
      }
    }
    AppMethodBeat.o(215996);
    return false;
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(215998);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(215998);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(215998);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S3EnglishQwertyKeyboard
 * JD-Core Version:    0.7.0.1
 */