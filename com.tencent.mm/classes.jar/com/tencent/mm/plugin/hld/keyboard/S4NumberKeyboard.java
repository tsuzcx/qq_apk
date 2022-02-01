package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S4NumberKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "keyList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "Lkotlin/collections/ArrayList;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "handleNormalTouch", "", "v", "event", "Landroid/view/MotionEvent;", "onClick", "", "Landroid/view/View;", "onCreate", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onTouch", "transparentBg", "transparent", "updateChildrenView", "id", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S4NumberKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnTouchListener
{
  public static final S4NumberKeyboard.a JrZ;
  private final ArrayList<ImeKeyRelativeLayout> JrP;
  private b JrQ;
  
  static
  {
    AppMethodBeat.i(312889);
    JrZ = new S4NumberKeyboard.a((byte)0);
    AppMethodBeat.o(312889);
  }
  
  public S4NumberKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S4NumberKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S4NumberKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(312874);
    this.JrP = new ArrayList();
    AppMethodBeat.o(312874);
  }
  
  private final void Ys(int paramInt)
  {
    AppMethodBeat.i(312883);
    ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)findViewById(paramInt);
    localImeKeyRelativeLayout.setPadding(localImeKeyRelativeLayout.getKeyMarginLeft(), localImeKeyRelativeLayout.getKeyMarginTop(), localImeKeyRelativeLayout.getKeyMarginRight(), localImeKeyRelativeLayout.getKeyMarginBottom());
    this.JrP.add(localImeKeyRelativeLayout);
    l locall = l.JyV;
    s.s(localImeKeyRelativeLayout, "view");
    if (l.e(localImeKeyRelativeLayout))
    {
      localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
      AppMethodBeat.o(312883);
      return;
    }
    localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(312883);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(312902);
    super.b(paramc);
    ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).onResume();
    paramc = getMKeyboardActionListener();
    if (paramc != null) {
      ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).setOnKeyboardActionListener(paramc);
    }
    AppMethodBeat.o(312902);
  }
  
  protected final ImeKeyButton getActionKey()
  {
    AppMethodBeat.i(312928);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.s4_key_action);
    AppMethodBeat.o(312928);
    return localImeKeyButton;
  }
  
  public final c getKeyboardType()
  {
    return c.Jrs;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312923);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S4NumberKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = l.JyV;
      l.jC("WxIme.S4NumberKeyboard", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) != 2) {
        break label178;
      }
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Yl(((ImeKeyRelativeLayout)paramView).getFunctionCode());
      }
    }
    label178:
    while ((((ImeKeyRelativeLayout)paramView).getType() & 0x1) != 1)
    {
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.hU(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S4NumberKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312923);
      return;
    }
    localObject1 = ((ImeKeyRelativeLayout)paramView).getText();
    Object localObject2;
    if (fLL())
    {
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(312923);
        throw paramView;
      }
      localObject2 = ((String)localObject1).toUpperCase();
      s.s(localObject2, "(this as java.lang.String).toUpperCase()");
      label240:
      localObject1 = this.JrQ;
      if (localObject1 != null) {
        break label320;
      }
      localObject1 = null;
      label251:
      if (localObject1 != null) {
        break label336;
      }
      localObject1 = new g((String)localObject2);
    }
    label320:
    label336:
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
        AppMethodBeat.o(312923);
        throw paramView;
      }
      localObject2 = ((String)localObject1).toLowerCase();
      s.s(localObject2, "(this as java.lang.String).toLowerCase()");
      break label240;
      localObject1 = new g((String)localObject2, ((b)localObject1).Jrm);
      break label251;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(312896);
    super.onCreate();
    Ys(a.f.s4_key_1);
    Ys(a.f.s4_key_2);
    Ys(a.f.s4_key_3);
    Ys(a.f.s4_key_4);
    Ys(a.f.s4_key_5);
    Ys(a.f.s4_key_6);
    Ys(a.f.s4_key_7);
    Ys(a.f.s4_key_8);
    Ys(a.f.s4_key_9);
    Ys(a.f.s4_key_0);
    Ys(a.f.s4_key_back);
    Ys(a.f.s4_key_dot);
    Ys(a.f.s4_key_delete);
    Ys(a.f.s4_key_space);
    Ys(a.f.s4_key_at);
    Ys(a.f.s4_key_action);
    AppMethodBeat.o(312896);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(312907);
    super.onReset();
    ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).reset();
    AppMethodBeat.o(312907);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312958);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      Object localObject1 = l.JyV;
      if (l.e((ImeKeyRelativeLayout)paramView))
      {
        boolean bool = a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(404));
        AppMethodBeat.o(312958);
        return bool;
      }
      a((ImeKeyRelativeLayout)paramView, paramMotionEvent);
      Object localObject2 = (ImeKeyRelativeLayout)paramView;
      label85:
      int i;
      if (paramMotionEvent == null)
      {
        paramView = null;
        if (paramMotionEvent != null) {
          break label250;
        }
        localObject1 = Double.valueOf(0.0D);
        i = (int)((Float)localObject1).floatValue();
        if (paramMotionEvent != null) {
          break label262;
        }
      }
      int j;
      long l;
      label262:
      for (paramMotionEvent = Double.valueOf(0.0D);; paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY()))
      {
        j = (int)((Float)paramMotionEvent).floatValue();
        l = System.currentTimeMillis();
        paramMotionEvent = ((ImeKeyRelativeLayout)localObject2).getText();
        localObject1 = l.JyV;
        l.jC("WxIme.S4NumberKeyboard", "onTouch action " + paramView + ' ' + i + ' ' + j + ' ' + l + ' ' + paramMotionEvent);
        if (this.JrQ == null) {
          break label425;
        }
        localObject1 = this.JrQ;
        s.checkNotNull(localObject1);
        localObject1 = ((b)localObject1).Jrk;
        if (localObject1 != null) {
          break label273;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(312958);
        throw paramView;
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        label250:
        localObject1 = Float.valueOf(paramMotionEvent.getRawX());
        break label85;
      }
      label273:
      localObject1 = ((String)localObject1).toLowerCase();
      s.s(localObject1, "(this as java.lang.String).toLowerCase()");
      if (paramMotionEvent == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(312958);
        throw paramView;
      }
      String str = paramMotionEvent.toLowerCase();
      s.s(str, "(this as java.lang.String).toLowerCase()");
      if (!Util.isEqual((String)localObject1, str)) {
        if (paramView == null)
        {
          if (paramView != null) {
            break label517;
          }
          localObject1 = l.JyV;
          localObject1 = new StringBuilder("lastKey:");
          localObject2 = this.JrQ;
          s.checkNotNull(localObject2);
          l.jC("WxIme.S4NumberKeyboard", ((b)localObject2).Jrk + " currentKey:" + paramMotionEvent + " action:" + paramView);
          label408:
          break label437;
        }
      }
      label409:
      label425:
      label429:
      label433:
      label437:
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(312958);
            return false;
            if (paramView.intValue() != 5) {
              break;
            }
            if (paramView != null) {
              break label527;
            }
            if (paramView != null) {
              break label833;
            }
            if (paramView != null) {
              break label989;
            }
          } while ((paramView == null) || (paramView.intValue() != 3));
          ((ImeKeyRelativeLayout)localObject2).setSelected(false);
          paramView = this.JrQ;
          if (paramView != null) {
            paramView.Jrl = true;
          }
        } while ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2);
        paramMotionEvent = getMKeyboardActionListener();
      } while (paramMotionEvent == null);
      paramView = this.JrQ;
      if (paramView == null) {}
      for (paramView = null;; paramView = paramView.Jrk)
      {
        paramMotionEvent.c(new g(paramView));
        break label409;
        label517:
        if (paramView.intValue() == 0) {
          break label425;
        }
        break;
        label527:
        if (paramView.intValue() != 0) {
          break label429;
        }
        if ((localObject2 instanceof ImeKeyRelativeLayout))
        {
          paramView = i.JyA;
          i.d((ImeKeyRelativeLayout)localObject2);
        }
        paramView = this.JrQ;
        if ((paramView != null) && (!paramView.Jrl) && (!Util.isNullOrNil(paramView.Jrk)))
        {
          paramMotionEvent = getMKeyboardActionListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.b(new g(paramView.Jrk, paramView.Jrm));
          }
          paramMotionEvent = (View)paramView.viewRef.get();
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setSelected(false);
            localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
            com.tencent.mm.plugin.hld.model.k.hU(paramMotionEvent);
          }
          paramMotionEvent = l.JyV;
          l.jC("WxIme.S4NumberKeyboard", s.X("process no ACTION_UP input:", paramView.Jrk));
        }
        paramView = ((ImeKeyRelativeLayout)localObject2).getText();
        if (fLL())
        {
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(312958);
            throw paramView;
          }
          paramView = paramView.toUpperCase();
          s.s(paramView, "(this as java.lang.String).toUpperCase()");
          label703:
          this.JrQ = new b(i, j, l, paramView, new WeakReference(localObject2), l, 16);
          ((ImeKeyRelativeLayout)localObject2).setSelected(true);
          if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2) {
            break label409;
          }
          paramMotionEvent = getMKeyboardActionListener();
          if (paramMotionEvent == null) {
            break label409;
          }
          paramView = this.JrQ;
          if (paramView != null) {
            break label825;
          }
        }
        label825:
        for (paramView = null;; paramView = paramView.Jrk)
        {
          paramMotionEvent.a(new g(paramView));
          break;
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(312958);
            throw paramView;
          }
          paramView = paramView.toLowerCase();
          s.s(paramView, "(this as java.lang.String).toLowerCase()");
          break label703;
        }
        label833:
        if (paramView.intValue() != 2) {
          break label433;
        }
        paramView = this.JrQ;
        if (paramView == null) {
          break label409;
        }
        paramMotionEvent = l.JyV;
        l.jC("WxIme.S4NumberKeyboard", "onTouch yOffset:" + Math.abs(i - paramView.x) + " 15%ScreenWidth:" + com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height));
        j = Math.abs(paramView.x - i);
        paramMotionEvent = com.tencent.mm.plugin.hld.f.k.JyF;
        if (j <= com.tencent.mm.plugin.hld.f.k.fOz()) {
          break label409;
        }
        paramMotionEvent = com.tencent.mm.plugin.hld.e.b.JqP;
        com.tencent.mm.plugin.hld.e.b.a(null, (View)localObject2, this.JrQ, i);
        if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) != 2)
        {
          paramMotionEvent = getMKeyboardActionListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.c(new g(paramView.Jrk));
          }
        }
        AppMethodBeat.o(312958);
        return true;
        label989:
        if (paramView.intValue() != 1) {
          break label408;
        }
        ((ImeKeyRelativeLayout)localObject2).setSelected(false);
        paramView = this.JrQ;
        if (paramView != null) {
          paramView.Jrl = true;
        }
        onClick((View)localObject2);
        break label409;
      }
    }
    AppMethodBeat.o(312958);
    return false;
  }
  
  public final void wS(boolean paramBoolean)
  {
    AppMethodBeat.i(312935);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(312935);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(312935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S4NumberKeyboard
 * JD-Core Version:    0.7.0.1
 */