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
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S4NumberKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "keyList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "Lkotlin/collections/ArrayList;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "handleNormalTouch", "", "v", "event", "Landroid/view/MotionEvent;", "onClick", "", "Landroid/view/View;", "onCreate", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onTouch", "transparentBg", "transparent", "updateChildrenView", "id", "Companion", "plugin-hld_release"})
public final class S4NumberKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnTouchListener
{
  public static final a DyV;
  private final ArrayList<ImeKeyRelativeLayout> DyK;
  private b DyL;
  
  static
  {
    AppMethodBeat.i(211106);
    DyV = new a((byte)0);
    AppMethodBeat.o(211106);
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
    AppMethodBeat.i(211105);
    this.DyK = new ArrayList();
    AppMethodBeat.o(211105);
  }
  
  private final void Uv(int paramInt)
  {
    AppMethodBeat.i(211102);
    ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)findViewById(paramInt);
    localImeKeyRelativeLayout.setPadding(localImeKeyRelativeLayout.getKeyMarginLeft(), localImeKeyRelativeLayout.getKeyMarginTop(), localImeKeyRelativeLayout.getKeyMarginRight(), localImeKeyRelativeLayout.getKeyMarginBottom());
    this.DyK.add(localImeKeyRelativeLayout);
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    p.j(localImeKeyRelativeLayout, "view");
    if (com.tencent.mm.plugin.hld.f.l.e(localImeKeyRelativeLayout))
    {
      localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
      AppMethodBeat.o(211102);
      return;
    }
    localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(211102);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(211095);
    super.b(paramc);
    ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).onResume();
    paramc = getMKeyboardActionListener();
    if (paramc != null)
    {
      ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).setOnKeyboardActionListener(paramc);
      AppMethodBeat.o(211095);
      return;
    }
    AppMethodBeat.o(211095);
  }
  
  protected final ImeKeyButton getActionKey()
  {
    AppMethodBeat.i(211100);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.s4_key_action);
    AppMethodBeat.o(211100);
    return localImeKeyButton;
  }
  
  public final c getKeyboardType()
  {
    return c.Dyo;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(211099);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S4NumberKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) != 2) {
        break label178;
      }
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Up(((ImeKeyRelativeLayout)paramView).getFunctionCode());
      }
    }
    label178:
    while ((((ImeKeyRelativeLayout)paramView).getType() & 0x1) != 1)
    {
      localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.fi(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S4NumberKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211099);
      return;
    }
    localObject1 = ((ImeKeyRelativeLayout)paramView).getText();
    label240:
    Object localObject2;
    if (eDJ())
    {
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(211099);
        throw paramView;
      }
      localObject1 = ((String)localObject1).toUpperCase();
      p.j(localObject1, "(this as java.lang.String).toUpperCase()");
      localObject2 = this.DyL;
      if (localObject2 == null) {
        break label318;
      }
    }
    label318:
    for (localObject1 = new g((String)localObject1, ((b)localObject2).Dyi);; localObject1 = new g((String)localObject1))
    {
      localObject2 = getMKeyboardActionListener();
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.hld.a.c)localObject2).b((g)localObject1);
      break;
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(211099);
        throw paramView;
      }
      localObject1 = ((String)localObject1).toLowerCase();
      p.j(localObject1, "(this as java.lang.String).toLowerCase()");
      break label240;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(211093);
    super.onCreate();
    Uv(a.f.s4_key_1);
    Uv(a.f.s4_key_2);
    Uv(a.f.s4_key_3);
    Uv(a.f.s4_key_4);
    Uv(a.f.s4_key_5);
    Uv(a.f.s4_key_6);
    Uv(a.f.s4_key_7);
    Uv(a.f.s4_key_8);
    Uv(a.f.s4_key_9);
    Uv(a.f.s4_key_0);
    Uv(a.f.s4_key_back);
    Uv(a.f.s4_key_dot);
    Uv(a.f.s4_key_delete);
    Uv(a.f.s4_key_space);
    Uv(a.f.s4_key_at);
    Uv(a.f.s4_key_action);
    AppMethodBeat.o(211093);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(211097);
    super.onReset();
    ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).reset();
    AppMethodBeat.o(211097);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(211103);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.e((ImeKeyRelativeLayout)paramView))
      {
        boolean bool = a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(404));
        AppMethodBeat.o(211103);
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
          break label259;
        }
        localObject1 = Float.valueOf(paramMotionEvent.getRawX());
        i = (int)((Float)localObject1).floatValue();
        if (paramMotionEvent == null) {
          break label268;
        }
      }
      int j;
      long l;
      label259:
      label268:
      for (paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY());; paramMotionEvent = Double.valueOf(0.0D))
      {
        j = (int)((Float)paramMotionEvent).floatValue();
        l = System.currentTimeMillis();
        paramMotionEvent = ((ImeKeyRelativeLayout)localObject2).getText();
        localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", "onTouch action " + paramView + ' ' + i + ' ' + j + ' ' + l + ' ' + paramMotionEvent);
        if (this.DyL == null) {
          break label431;
        }
        localObject1 = this.DyL;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((b)localObject1).Dyg;
        if (localObject1 != null) {
          break label276;
        }
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(211103);
        throw paramView;
        paramView = null;
        break;
        localObject1 = Double.valueOf(0.0D);
        break label94;
      }
      label276:
      localObject1 = ((String)localObject1).toLowerCase();
      p.j(localObject1, "(this as java.lang.String).toLowerCase()");
      if (paramMotionEvent == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(211103);
        throw paramView;
      }
      String str = paramMotionEvent.toLowerCase();
      p.j(str, "(this as java.lang.String).toLowerCase()");
      if (!Util.isEqual((String)localObject1, str)) {
        if (paramView == null)
        {
          if (paramView != null) {
            break label526;
          }
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject1 = new StringBuilder("lastKey:");
          localObject2 = this.DyL;
          if (localObject2 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", ((b)localObject2).Dyg + " currentKey:" + paramMotionEvent + " action:" + paramView);
          label414:
          break label443;
        }
      }
      label415:
      label431:
      label435:
      label439:
      label443:
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(211103);
            return false;
            if (paramView.intValue() != 5) {
              break;
            }
            if (paramView != null) {
              break label536;
            }
            if (paramView != null) {
              break label858;
            }
            if (paramView != null) {
              break label1025;
            }
          } while ((paramView == null) || (paramView.intValue() != 3));
          ((ImeKeyRelativeLayout)localObject2).setSelected(false);
          paramView = this.DyL;
          if (paramView != null) {
            paramView.Dyh = true;
          }
        } while ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2);
        paramMotionEvent = getMKeyboardActionListener();
      } while (paramMotionEvent == null);
      paramView = this.DyL;
      if (paramView != null) {}
      for (paramView = paramView.Dyg;; paramView = null)
      {
        paramMotionEvent.c(new g(paramView));
        break label415;
        label526:
        if (paramView.intValue() == 0) {
          break label431;
        }
        break;
        label536:
        if (paramView.intValue() != 0) {
          break label435;
        }
        if ((localObject2 instanceof ImeKeyRelativeLayout))
        {
          paramView = i.DHq;
          i.d((ImeKeyRelativeLayout)localObject2);
        }
        paramView = this.DyL;
        if ((paramView != null) && (!paramView.Dyh) && (!Util.isNullOrNil(paramView.Dyg)))
        {
          paramMotionEvent = getMKeyboardActionListener();
          if (paramMotionEvent != null) {
            paramMotionEvent.b(new g(paramView.Dyg, paramView.Dyi));
          }
          paramMotionEvent = (View)paramView.aFW.get();
          if (paramMotionEvent != null)
          {
            p.j(paramMotionEvent, "view");
            paramMotionEvent.setSelected(false);
            localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
            com.tencent.mm.plugin.hld.model.k.fi(paramMotionEvent);
          }
          paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", "process no ACTION_UP input:" + paramView.Dyg);
        }
        paramView = ((ImeKeyRelativeLayout)localObject2).getText();
        if (eDJ())
        {
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(211103);
            throw paramView;
          }
          paramView = paramView.toUpperCase();
          p.j(paramView, "(this as java.lang.String).toUpperCase()");
          label728:
          this.DyL = new b(i, j, l, paramView, new WeakReference(localObject2), l, 16);
          ((ImeKeyRelativeLayout)localObject2).setSelected(true);
          if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2) {
            break label415;
          }
          paramMotionEvent = getMKeyboardActionListener();
          if (paramMotionEvent == null) {
            break label415;
          }
          paramView = this.DyL;
          if (paramView == null) {
            break label853;
          }
        }
        label853:
        for (paramView = paramView.Dyg;; paramView = null)
        {
          paramMotionEvent.a(new g(paramView));
          break;
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(211103);
            throw paramView;
          }
          paramView = paramView.toLowerCase();
          p.j(paramView, "(this as java.lang.String).toLowerCase()");
          break label728;
        }
        label858:
        if (paramView.intValue() != 2) {
          break label439;
        }
        paramView = this.DyL;
        if (paramView == null) {
          break label415;
        }
        paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", "onTouch yOffset:" + Math.abs(i - paramView.x) + " 15%ScreenWidth:" + com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height));
        j = Math.abs(paramView.x - i);
        paramMotionEvent = com.tencent.mm.plugin.hld.f.k.DHH;
        if (j <= com.tencent.mm.plugin.hld.f.k.eGQ()) {
          break label415;
        }
        paramMotionEvent = com.tencent.mm.plugin.hld.e.c.DxP;
        com.tencent.mm.plugin.hld.e.c.a(null, (View)localObject2, this.DyL, i);
        if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) != 2)
        {
          paramMotionEvent = getMKeyboardActionListener();
          if (paramMotionEvent != null) {
            if (paramView == null) {
              break label1020;
            }
          }
        }
        label1020:
        for (paramView = paramView.Dyg;; paramView = null)
        {
          paramMotionEvent.c(new g(paramView));
          AppMethodBeat.o(211103);
          return true;
        }
        label1025:
        if (paramView.intValue() != 1) {
          break label414;
        }
        ((ImeKeyRelativeLayout)localObject2).setSelected(false);
        paramView = this.DyL;
        if (paramView != null) {
          paramView.Dyh = true;
        }
        onClick((View)localObject2);
        break label415;
      }
    }
    AppMethodBeat.o(211103);
    return false;
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(211101);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(211101);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(211101);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S4NumberKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S4NumberKeyboard
 * JD-Core Version:    0.7.0.1
 */