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
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S2ChineseQwertyKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentKeyArea", "Lcom/tencent/mm/plugin/hld/keyboard/KeyArea;", "diffScale", "", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "computeMedia", "", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getViewText", "", "v", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "handleClickUpperKey", "doubleClick", "", "handleNormalTouch", "event", "Landroid/view/MotionEvent;", "onClick", "Landroid/view/View;", "onClickForSupportDoubleClick", "onCreate", "onDoubleClick", "onLongClick", "onTextKeyClick", "onTouch", "onUpperSlide", "supportDoubleClick", "transparentBg", "transparent", "updateChildrenView", "id", "updateUpperKeyImp", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S2ChineseQwertyKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener
{
  public static final S2ChineseQwertyKeyboard.a JrU;
  private b JrQ;
  private a JrV;
  private float JrW;
  
  static
  {
    AppMethodBeat.i(312946);
    JrU = new S2ChineseQwertyKeyboard.a((byte)0);
    AppMethodBeat.o(312946);
  }
  
  public S2ChineseQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S2ChineseQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S2ChineseQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private final void Ys(int paramInt)
  {
    AppMethodBeat.i(312941);
    Object localObject1 = (ImeKeyRelativeLayout)findViewById(paramInt);
    Object localObject2 = (ViewGroup)((ImeKeyRelativeLayout)localObject1).findViewById(a.f.inside_root);
    ViewGroup.LayoutParams localLayoutParams = ((ViewGroup)localObject2).getLayoutParams();
    if (localLayoutParams == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(312941);
      throw ((Throwable)localObject1);
    }
    localLayoutParams.width = ((int)(((ImeKeyRelativeLayout)localObject1).getKeyWidth() * this.JrW));
    localLayoutParams.height = ((ImeKeyRelativeLayout)localObject1).getKeyHeight();
    ((ViewGroup)localObject2).setLayoutParams(localLayoutParams);
    ((ImeKeyRelativeLayout)localObject1).setPadding((int)(((ImeKeyRelativeLayout)localObject1).getKeyMarginLeft() * this.JrW), ((ImeKeyRelativeLayout)localObject1).getKeyMarginTop(), (int)(((ImeKeyRelativeLayout)localObject1).getKeyMarginRight() * this.JrW), ((ImeKeyRelativeLayout)localObject1).getKeyMarginBottom());
    localObject2 = l.JyV;
    s.s(localObject1, "view");
    if (l.f((ImeKeyRelativeLayout)localObject1))
    {
      com.tencent.mm.plugin.hld.view.f.JzR.a((View)localObject1, (View.OnClickListener)this);
      ((ImeKeyRelativeLayout)localObject1).setOnLongClickListener((View.OnLongClickListener)this);
      AppMethodBeat.o(312941);
      return;
    }
    localObject2 = l.JyV;
    if (l.e((ImeKeyRelativeLayout)localObject1))
    {
      ((ImeKeyRelativeLayout)localObject1).setOnTouchListener((View.OnTouchListener)this);
      AppMethodBeat.o(312941);
      return;
    }
    if (((a((ImeKeyRelativeLayout)localObject1)) || (paramInt == a.f.s2_key_comma) || (paramInt == a.f.s2_key_at)) && (!b((ImeKeyRelativeLayout)localObject1))) {
      ((ImeKeyRelativeLayout)localObject1).setOnLongClickListener((View.OnLongClickListener)this);
    }
    ((ImeKeyRelativeLayout)localObject1).setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(312941);
  }
  
  private static String c(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(312925);
    String str = paramImeKeyRelativeLayout.getText();
    if (paramImeKeyRelativeLayout.getId() == a.f.s2_key_comma)
    {
      if (str == null)
      {
        paramImeKeyRelativeLayout = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(312925);
        throw paramImeKeyRelativeLayout;
      }
      paramImeKeyRelativeLayout = n.bq((CharSequence)str).toString();
      AppMethodBeat.o(312925);
      return paramImeKeyRelativeLayout;
    }
    AppMethodBeat.o(312925);
    return str;
  }
  
  private final void wT(boolean paramBoolean)
  {
    AppMethodBeat.i(312932);
    int i = getUpperMode();
    if (paramBoolean)
    {
      if (i == 3) {
        break label47;
      }
      Yr(3);
    }
    for (;;)
    {
      fLM();
      AppMethodBeat.o(312932);
      return;
      if (i == 1) {
        Yr(2);
      } else {
        label47:
        Yr(1);
      }
    }
  }
  
  protected final void fLN()
  {
    AppMethodBeat.i(313000);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.s2_key_upper);
    switch (getUpperMode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(313000);
      return;
      localImeKeyButton.YN(a.i.icons_outlined_capslock);
      AppMethodBeat.o(313000);
      return;
      localImeKeyButton.YN(a.i.icons_filled_capslock);
      AppMethodBeat.o(313000);
      return;
      localImeKeyButton.YN(a.i.icons_filled_capslocked);
    }
  }
  
  protected final ImeKeyButton getActionKey()
  {
    AppMethodBeat.i(313050);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.s2_key_action);
    AppMethodBeat.o(313050);
    return localImeKeyButton;
  }
  
  public final c getKeyboardType()
  {
    return c.Jrq;
  }
  
  public final boolean hL(View paramView)
  {
    AppMethodBeat.i(312980);
    if (((paramView instanceof ImeKeyRelativeLayout)) && (((ImeKeyRelativeLayout)paramView).getType() == 2) && (((ImeKeyRelativeLayout)paramView).getFunctionCode() == 3))
    {
      AppMethodBeat.o(312980);
      return true;
    }
    AppMethodBeat.o(312980);
    return false;
  }
  
  public final void hM(View paramView)
  {
    AppMethodBeat.i(312984);
    if (((paramView instanceof ImeKeyRelativeLayout)) && (((ImeKeyRelativeLayout)paramView).getType() == 2) && (((ImeKeyRelativeLayout)paramView).getFunctionCode() == 3)) {
      wT(false);
    }
    AppMethodBeat.o(312984);
  }
  
  public final void hN(View paramView)
  {
    AppMethodBeat.i(312989);
    super.hN(paramView);
    if (((paramView instanceof ImeKeyRelativeLayout)) && (((ImeKeyRelativeLayout)paramView).getType() == 2) && (((ImeKeyRelativeLayout)paramView).getFunctionCode() == 3)) {
      wT(true);
    }
    AppMethodBeat.o(312989);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312973);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S2ChineseQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = l.JyV;
      l.jC("WxIme.S2ChineseQwertyKeyboard", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if (hO(paramView))
      {
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.YA(201);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S2ChineseQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(312973);
        return;
      }
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) != 2) {
        break label231;
      }
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Yl(((ImeKeyRelativeLayout)paramView).getFunctionCode());
      }
    }
    label231:
    while ((((ImeKeyRelativeLayout)paramView).getType() & 0x4) != 4)
    {
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.hS(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S2ChineseQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312973);
      return;
    }
    localObject1 = c((ImeKeyRelativeLayout)paramView);
    Object localObject2;
    if (fLL())
    {
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(312973);
        throw paramView;
      }
      localObject2 = ((String)localObject1).toUpperCase();
      s.s(localObject2, "(this as java.lang.String).toUpperCase()");
      label294:
      localObject1 = this.JrQ;
      if (localObject1 != null) {
        break label375;
      }
      localObject1 = null;
      label305:
      if (localObject1 != null) {
        break label391;
      }
      localObject1 = new g((String)localObject2);
    }
    label391:
    for (;;)
    {
      localObject2 = getMKeyboardActionListener();
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.hld.a.c)localObject2).b((g)localObject1);
      break;
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(312973);
        throw paramView;
      }
      localObject2 = ((String)localObject1).toLowerCase();
      s.s(localObject2, "(this as java.lang.String).toLowerCase()");
      break label294;
      label375:
      localObject1 = new g((String)localObject2, ((b)localObject1).Jrm);
      break label305;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(312960);
    super.onCreate();
    Object localObject = com.tencent.mm.plugin.hld.f.k.JyF;
    if (com.tencent.mm.plugin.hld.f.k.isLandscape()) {}
    DisplayMetrics localDisplayMetrics;
    int i;
    for (this.JrW = 1.0F;; this.JrW = (i / (localDisplayMetrics.widthPixels - i) + 1.0F))
    {
      Ys(a.f.s2_key_q);
      Ys(a.f.s2_key_w);
      Ys(a.f.s2_key_e);
      Ys(a.f.s2_key_r);
      Ys(a.f.s2_key_t);
      Ys(a.f.s2_key_y);
      Ys(a.f.s2_key_u);
      Ys(a.f.s2_key_i);
      Ys(a.f.s2_key_o);
      Ys(a.f.s2_key_p);
      Ys(a.f.s2_key_a);
      Ys(a.f.s2_key_s);
      Ys(a.f.s2_key_d);
      Ys(a.f.s2_key_f);
      Ys(a.f.s2_key_g);
      Ys(a.f.s2_key_h);
      Ys(a.f.s2_key_j);
      Ys(a.f.s2_key_k);
      Ys(a.f.s2_key_l);
      Ys(a.f.s2_key_upper);
      Ys(a.f.s2_key_z);
      Ys(a.f.s2_key_x);
      Ys(a.f.s2_key_c);
      Ys(a.f.s2_key_v);
      Ys(a.f.s2_key_b);
      Ys(a.f.s2_key_n);
      Ys(a.f.s2_key_m);
      Ys(a.f.s2_key_delete);
      Ys(a.f.s2_key_symbol);
      Ys(a.f.s2_key_number);
      Ys(a.f.s2_key_comma);
      Ys(a.f.s2_key_space);
      Ys(a.f.s2_key_at);
      Ys(a.f.s2_key_exchange);
      Ys(a.f.s2_key_action);
      AppMethodBeat.o(312960);
      return;
      localObject = (ImeKeyRelativeLayout)findViewById(a.f.s2_key_q);
      localDisplayMetrics = getContext().getResources().getDisplayMetrics();
      i = localDisplayMetrics.widthPixels - ((ImeKeyRelativeLayout)localObject).getKeyWidth() * 10 - ((ImeKeyRelativeLayout)localObject).getKeyMarginLeft() * 10 - ((ImeKeyRelativeLayout)localObject).getKeyMarginRight() * 10;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(312995);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S2ChineseQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = l.JyV;
      l.jC("WxIme.S2ChineseQwertyKeyboard", "onLongClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      localObject1 = l.JyV;
      if (l.f((ImeKeyRelativeLayout)paramView))
      {
        paramView = (d)h.ax(d.class);
        if (paramView != null)
        {
          paramView = paramView.fKG();
          if (paramView != null) {
            paramView.fKs();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/keyboard/S2ChineseQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(312995);
        return true;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(((ImeKeyRelativeLayout)paramView).getSecondText());
      Object localObject2 = com.tencent.mm.plugin.hld.model.f.JuH;
      localObject2 = (ImeKeyRelativeLayout)paramView;
      paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
      s.checkNotNull(paramView);
      com.tencent.mm.plugin.hld.model.f.a(3, (ArrayList)localObject1, (ImeKeyRelativeLayout)localObject2, paramView, this.JrQ);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/keyboard/S2ChineseQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(312995);
      return true;
    }
    paramView = com.tencent.mm.plugin.hld.model.f.JuH;
    com.tencent.mm.plugin.hld.model.f.fLV();
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/keyboard/S2ChineseQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(312995);
    return false;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313041);
    label265:
    label276:
    label429:
    label433:
    label1971:
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      Object localObject1 = l.JyV;
      boolean bool;
      if (l.e((ImeKeyRelativeLayout)paramView))
      {
        bool = a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(208));
        AppMethodBeat.o(313041);
        return bool;
      }
      a((ImeKeyRelativeLayout)paramView, paramMotionEvent);
      Object localObject2 = (ImeKeyRelativeLayout)paramView;
      label85:
      int j;
      if (paramMotionEvent == null)
      {
        paramView = null;
        if (paramMotionEvent != null) {
          break label253;
        }
        localObject1 = Double.valueOf(0.0D);
        j = (int)((Float)localObject1).floatValue();
        if (paramMotionEvent != null) {
          break label265;
        }
      }
      int k;
      long l;
      for (paramMotionEvent = Double.valueOf(0.0D);; paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY()))
      {
        k = (int)((Float)paramMotionEvent).floatValue();
        l = System.currentTimeMillis();
        paramMotionEvent = c((ImeKeyRelativeLayout)localObject2);
        localObject1 = l.JyV;
        l.jC("WxIme.S2ChineseQwertyKeyboard", "onTouch action " + paramView + ' ' + j + ' ' + k + ' ' + l + ' ' + paramMotionEvent);
        if (this.JrQ == null) {
          break label429;
        }
        localObject1 = this.JrQ;
        s.checkNotNull(localObject1);
        localObject1 = ((b)localObject1).Jrk;
        if (localObject1 != null) {
          break label276;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313041);
        throw paramView;
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        label253:
        localObject1 = Float.valueOf(paramMotionEvent.getRawX());
        break label85;
      }
      localObject1 = ((String)localObject1).toLowerCase();
      s.s(localObject1, "(this as java.lang.String).toLowerCase()");
      if (paramMotionEvent == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313041);
        throw paramView;
      }
      Object localObject3 = paramMotionEvent.toLowerCase();
      s.s(localObject3, "(this as java.lang.String).toLowerCase()");
      if (!Util.isEqual((String)localObject1, (String)localObject3)) {
        if (paramView == null)
        {
          if (paramView != null) {
            break label636;
          }
          localObject1 = l.JyV;
          localObject1 = new StringBuilder("lastKey:");
          localObject2 = this.JrQ;
          s.checkNotNull(localObject2);
          l.jC("WxIme.S2ChineseQwertyKeyboard", ((b)localObject2).Jrk + " currentKey:" + paramMotionEvent + " action:" + paramView);
        }
      }
      label437:
      label439:
      label636:
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              AppMethodBeat.o(313041);
              return false;
              if (paramView.intValue() != 5) {
                break;
              }
              int i;
              if (paramView == null)
              {
                if (paramView != null) {
                  break label659;
                }
                i = 0;
                if (i == 0) {
                  break label1127;
                }
                paramView = i.JyA;
                i.d((ImeKeyRelativeLayout)localObject2);
                localObject1 = this.JrQ;
                if (localObject1 != null) {
                  if ((!((b)localObject1).Jrl) && (!Util.isNullOrNil(((b)localObject1).Jrk)))
                  {
                    paramView = l.JyV;
                    l.jC("WxIme.S2ChineseQwertyKeyboard", s.X("process no ACTION_UP input:", ((b)localObject1).Jrk));
                    paramView = (View)((b)localObject1).viewRef.get();
                    if (paramView != null)
                    {
                      paramView.setSelected(false);
                      if ((!(paramView instanceof ImeKeyRelativeLayout)) || (!a((ImeKeyRelativeLayout)paramView))) {
                        break label671;
                      }
                      localObject3 = getMKeyboardActionListener();
                      if (localObject3 != null)
                      {
                        ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new g(((b)localObject1).Jrk, ((b)localObject1).Jrm));
                        localObject1 = ah.aiuX;
                      }
                      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
                      com.tencent.mm.plugin.hld.model.k.hS(paramView);
                    }
                  }
                }
              }
              for (;;)
              {
                paramView = ah.aiuX;
                paramView = ah.aiuX;
                paramView = ah.aiuX;
                paramView = ah.aiuX;
                if (!fLL()) {
                  break label913;
                }
                if (paramMotionEvent != null) {
                  break label679;
                }
                paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(313041);
                throw paramView;
                if (paramView.intValue() == 0) {
                  break label429;
                }
                break;
                if (paramView.intValue() != 5) {
                  break label433;
                }
                i = 1;
                break label439;
                if (paramView.intValue() != 0) {
                  break label437;
                }
                i = 1;
                break label439;
                onClick(paramView);
              }
              paramView = paramMotionEvent.toUpperCase();
              s.s(paramView, "(this as java.lang.String).toUpperCase()");
              for (;;)
              {
                this.JrQ = new b(j, k, l, paramView, new WeakReference(localObject2), l, 16);
                paramView = new int[2];
                ((ImeKeyRelativeLayout)localObject2).getLocationOnScreen(paramView);
                this.JrV = new a(paramView[0], paramView[1], paramView[0] + ((ImeKeyRelativeLayout)localObject2).getMeasuredWidth(), paramView[1] + ((ImeKeyRelativeLayout)localObject2).getMeasuredHeight());
                if (!a((ImeKeyRelativeLayout)localObject2)) {
                  break label1109;
                }
                paramMotionEvent = (View)localObject2;
                if (!(paramMotionEvent instanceof ImeKeyRelativeLayout)) {
                  break label1099;
                }
                paramView = l.JyV;
                l.jC("WxIme.S2ChineseQwertyKeyboard", "onTextKeyClick:" + ((ImeKeyRelativeLayout)paramMotionEvent).getType() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getText() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getFunctionCode());
                localObject1 = new ArrayList();
                paramView = c((ImeKeyRelativeLayout)paramMotionEvent);
                if (!fLL()) {
                  break label1061;
                }
                if (paramView != null) {
                  break;
                }
                paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(313041);
                throw paramView;
                if (paramMotionEvent == null)
                {
                  paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(313041);
                  throw paramView;
                }
                paramView = paramMotionEvent.toLowerCase();
                s.s(paramView, "(this as java.lang.String).toLowerCase()");
              }
              paramView = paramView.toUpperCase();
              s.s(paramView, "(this as java.lang.String).toUpperCase()");
              ((ArrayList)localObject1).add(paramView);
              paramView = com.tencent.mm.plugin.hld.model.f.JuH;
              paramView = (ImeKeyRelativeLayout)paramMotionEvent;
              paramMotionEvent = ((ImeKeyRelativeLayout)paramMotionEvent).getInsideView();
              s.checkNotNull(paramMotionEvent);
              com.tencent.mm.plugin.hld.model.f.a(1, (ArrayList)localObject1, paramView, paramMotionEvent, this.JrQ);
              ((ImeKeyRelativeLayout)localObject2).setSelected(true);
              if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) != 2)
              {
                paramMotionEvent = getMKeyboardActionListener();
                if (paramMotionEvent != null)
                {
                  paramView = this.JrQ;
                  if (paramView == null) {}
                  for (paramView = null;; paramView = paramView.Jrk)
                  {
                    paramMotionEvent.a(new g(paramView));
                    paramView = ah.aiuX;
                    break;
                    if (paramView == null)
                    {
                      paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(313041);
                      throw paramView;
                    }
                    paramView = paramView.toLowerCase();
                    s.s(paramView, "(this as java.lang.String).toLowerCase()");
                    break label963;
                    paramView = com.tencent.mm.plugin.hld.model.f.JuH;
                    com.tencent.mm.plugin.hld.model.f.fLV();
                    break label1003;
                    paramView = com.tencent.mm.plugin.hld.model.f.JuH;
                    com.tencent.mm.plugin.hld.model.f.fLV();
                    break label1003;
                  }
                  if (paramView == null)
                  {
                    if (paramView != null) {
                      break label1804;
                    }
                    if (paramView != null) {
                      break label1818;
                    }
                    i = 0;
                  }
                  for (;;)
                  {
                    if (i == 0) {
                      break label1971;
                    }
                    ((ImeKeyRelativeLayout)localObject2).setSelected(false);
                    paramView = this.JrQ;
                    if (paramView != null)
                    {
                      paramView.Jrl = true;
                      paramView = ah.aiuX;
                      paramView = ah.aiuX;
                    }
                    paramView = com.tencent.mm.plugin.hld.model.f.JuH;
                    com.tencent.mm.plugin.hld.model.f.rL(70L);
                    if (!a((ImeKeyRelativeLayout)localObject2)) {
                      break label1959;
                    }
                    paramView = c((ImeKeyRelativeLayout)localObject2);
                    if (!fLL()) {
                      break label1902;
                    }
                    if (paramView != null) {
                      break label1831;
                    }
                    paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(313041);
                    throw paramView;
                    if (paramView.intValue() != 2) {
                      break label1131;
                    }
                    if (a((ImeKeyRelativeLayout)localObject2))
                    {
                      paramView = this.JrV;
                      if (paramView != null)
                      {
                        if ((j < paramView.x) || (j > paramView.Jri) || (k < paramView.y) || (k > paramView.Jrj))
                        {
                          paramView = com.tencent.mm.plugin.hld.model.f.JuH;
                          com.tencent.mm.plugin.hld.model.f.fLW();
                        }
                        paramView = ah.aiuX;
                        paramView = ah.aiuX;
                      }
                    }
                    paramView = this.JrQ;
                    if (paramView == null) {
                      break;
                    }
                    paramMotionEvent = l.JyV;
                    paramMotionEvent = new StringBuilder("onTouch ");
                    if (paramView.y - k > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)) {}
                    for (bool = true;; bool = false)
                    {
                      l.jC("WxIme.S2ChineseQwertyKeyboard", bool + " diff:" + (l - paramView.time) + " yOffset:" + (paramView.y - k) + " minHeight:" + com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height));
                      i = Math.abs(paramView.x - j);
                      paramMotionEvent = com.tencent.mm.plugin.hld.f.k.JyF;
                      if (i <= com.tencent.mm.plugin.hld.f.k.fOz()) {
                        break;
                      }
                      paramMotionEvent = com.tencent.mm.plugin.hld.e.b.JqP;
                      paramMotionEvent = (View)localObject2;
                      localObject1 = ((ImeKeyRelativeLayout)localObject2).getInsideView();
                      s.checkNotNull(localObject1);
                      com.tencent.mm.plugin.hld.e.b.a(paramMotionEvent, (View)localObject1, this.JrQ, j);
                      if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) != 2)
                      {
                        paramMotionEvent = getMKeyboardActionListener();
                        if (paramMotionEvent != null)
                        {
                          paramMotionEvent.c(new g(paramView.Jrk));
                          paramView = ah.aiuX;
                        }
                      }
                      AppMethodBeat.o(313041);
                      return true;
                    }
                    if (((a((ImeKeyRelativeLayout)localObject2)) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.s2_key_comma) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.s2_key_at)) && (!b((ImeKeyRelativeLayout)localObject2)) && (paramView.y - k > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)))
                    {
                      paramView = new int[2];
                      ((ImeKeyRelativeLayout)localObject2).getLocationOnScreen(paramView);
                      if ((j >= paramView[0]) && (j <= paramView[0] + ((ImeKeyRelativeLayout)localObject2).getMeasuredWidth()))
                      {
                        paramView = (View)localObject2;
                        if ((paramView instanceof ImeKeyRelativeLayout))
                        {
                          paramMotionEvent = l.JyV;
                          l.jC("WxIme.S2ChineseQwertyKeyboard", "onUpperSlide:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
                          paramMotionEvent = new ArrayList();
                          paramMotionEvent.add(c((ImeKeyRelativeLayout)paramView));
                          paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getSecondText());
                          localObject1 = com.tencent.mm.plugin.hld.model.f.JuH;
                          localObject1 = (ImeKeyRelativeLayout)paramView;
                          paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
                          s.checkNotNull(paramView);
                          com.tencent.mm.plugin.hld.model.f.a(2, paramMotionEvent, (ImeKeyRelativeLayout)localObject1, paramView, this.JrQ);
                        }
                        for (;;)
                        {
                          AppMethodBeat.o(313041);
                          return true;
                          paramView = com.tencent.mm.plugin.hld.model.f.JuH;
                          com.tencent.mm.plugin.hld.model.f.fLV();
                        }
                      }
                    }
                    paramView = ah.aiuX;
                    paramView = ah.aiuX;
                    break;
                    if (paramView.intValue() != 6) {
                      break label1135;
                    }
                    i = 1;
                    continue;
                    if (paramView.intValue() != 1) {
                      break label1139;
                    }
                    i = 1;
                  }
                  paramMotionEvent = paramView.toUpperCase();
                  s.s(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
                  paramView = this.JrQ;
                  if (paramView == null)
                  {
                    paramView = null;
                    if (paramView != null) {
                      break label1956;
                    }
                    paramView = new g(paramMotionEvent);
                  }
                  for (;;)
                  {
                    paramMotionEvent = getMKeyboardActionListener();
                    if (paramMotionEvent != null)
                    {
                      paramMotionEvent.b(paramView);
                      paramView = ah.aiuX;
                    }
                    paramView = com.tencent.mm.plugin.hld.model.k.JvH;
                    com.tencent.mm.plugin.hld.model.k.hS((View)localObject2);
                    break;
                    if (paramView == null)
                    {
                      paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(313041);
                      throw paramView;
                    }
                    paramMotionEvent = paramView.toLowerCase();
                    s.s(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
                    break label1843;
                    paramView = new g(paramMotionEvent, paramView.Jrm);
                    break label1854;
                  }
                  onClick((View)localObject2);
                }
              }
            }
          } while ((paramView == null) || (paramView.intValue() != 3));
          ((ImeKeyRelativeLayout)localObject2).setSelected(false);
          paramView = this.JrQ;
          if (paramView != null)
          {
            paramView.Jrl = true;
            paramView = ah.aiuX;
            paramView = ah.aiuX;
          }
          paramView = com.tencent.mm.plugin.hld.model.f.JuH;
          com.tencent.mm.plugin.hld.model.f.rL(70L);
        } while ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2);
        paramMotionEvent = getMKeyboardActionListener();
      } while (paramMotionEvent == null);
      label963:
      label1003:
      label1131:
      label1135:
      label1139:
      paramView = this.JrQ;
      label1099:
      label1109:
      label1127:
      label1902:
      if (paramView == null) {}
      label1843:
      label1854:
      for (paramView = null;; paramView = paramView.Jrk)
      {
        paramMotionEvent.c(new g(paramView));
        paramView = ah.aiuX;
        break;
      }
    }
    label659:
    label671:
    label679:
    label1831:
    label1959:
    AppMethodBeat.o(313041);
    label913:
    label1061:
    return false;
  }
  
  public final void wS(boolean paramBoolean)
  {
    AppMethodBeat.i(313058);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(313058);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(313058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S2ChineseQwertyKeyboard
 * JD-Core Version:    0.7.0.1
 */