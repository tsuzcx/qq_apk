package com.tencent.mm.plugin.hld.keyboard.selfdraw;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.plugin.hld.model.r;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S4NumberKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "enterKey", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "fetchOriginConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "getEnterKey", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "handleNormalTouch", "", "button", "event", "Landroid/view/MotionEvent;", "initButtonDrawer", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "onButtonClick", "", "onButtonUp", "onInitFinish", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onTouch", "transparentBg", "transparent", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S4NumberKeyboard
  extends KeyboardView
{
  public static final S4NumberKeyboard.a JtH;
  private KeyboardView.c JtB;
  private b JtC;
  
  static
  {
    AppMethodBeat.i(313030);
    JtH = new S4NumberKeyboard.a((byte)0);
    AppMethodBeat.o(313030);
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
  }
  
  public final boolean Z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313122);
    s.u(paramMotionEvent, "event");
    Object localObject1 = getActionButton();
    if (localObject1 != null)
    {
      boolean bool;
      if (((b)localObject1).JsU == 1)
      {
        bool = a((b)localObject1, paramMotionEvent, Integer.valueOf(404));
        AppMethodBeat.o(313122);
        return bool;
      }
      a((b)localObject1, paramMotionEvent);
      int j = paramMotionEvent.getActionMasked();
      int i = (int)paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
      int k = (int)paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
      long l = System.currentTimeMillis();
      Object localObject2 = ((b)localObject1).mainText;
      Object localObject3 = l.JyV;
      l.jC("WxIme.S4NumberKeyboard", "onTouch action " + j + ' ' + i + ' ' + k + ' ' + l + ' ' + (String)localObject2);
      if (this.JtB != null)
      {
        localObject3 = this.JtB;
        s.checkNotNull(localObject3);
        localObject3 = ((KeyboardView.c)localObject3).Jrk;
        if (localObject3 == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313122);
          throw paramMotionEvent;
        }
        localObject3 = ((String)localObject3).toLowerCase();
        s.s(localObject3, "(this as java.lang.String).toLowerCase()");
        if (localObject2 == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313122);
          throw paramMotionEvent;
        }
        String str = ((String)localObject2).toLowerCase();
        s.s(str, "(this as java.lang.String).toLowerCase()");
        if ((!Util.isEqual((String)localObject3, str)) && (j != 5) && (j != 0))
        {
          paramMotionEvent = l.JyV;
          paramMotionEvent = new StringBuilder("lastKey:");
          localObject1 = this.JtB;
          s.checkNotNull(localObject1);
          l.jC("WxIme.S4NumberKeyboard", ((KeyboardView.c)localObject1).Jrk + " currentKey:" + (String)localObject2 + " action:" + j);
        }
      }
      label557:
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(313122);
            return false;
            switch (j)
            {
            case 4: 
            default: 
              break;
            case 0: 
            case 5: 
              paramMotionEvent = i.JyA;
              paramMotionEvent = getContext();
              s.s(paramMotionEvent, "context");
              i.a((b)localObject1, paramMotionEvent);
              paramMotionEvent = this.JtB;
              if ((paramMotionEvent != null) && (!paramMotionEvent.Jrl) && (!Util.isNullOrNil(paramMotionEvent.Jrk)))
              {
                localObject3 = l.JyV;
                l.jC("WxIme.S4NumberKeyboard", s.X("process no ACTION_UP input:", paramMotionEvent.Jrk));
                paramMotionEvent.Jtx.wV(false);
                localObject3 = getMKeyboardActionListener();
                if (localObject3 != null) {
                  ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new g(paramMotionEvent.Jrk, paramMotionEvent.Jrm));
                }
                paramMotionEvent = com.tencent.mm.plugin.hld.model.k.JvH;
                com.tencent.mm.plugin.hld.model.k.n((b)localObject1);
              }
              if (fLL())
              {
                if (localObject2 == null)
                {
                  paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(313122);
                  throw paramMotionEvent;
                }
                paramMotionEvent = ((String)localObject2).toUpperCase();
                s.s(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
                this.JtB = new KeyboardView.c(i, k, l, paramMotionEvent, (b)localObject1, l, 16);
                ((b)localObject1).wV(true);
                if ((((b)localObject1).type & 0x2) == 2) {
                  continue;
                }
                localObject1 = getMKeyboardActionListener();
                if (localObject1 == null) {
                  continue;
                }
                paramMotionEvent = this.JtB;
                if (paramMotionEvent != null) {
                  break label674;
                }
              }
              for (paramMotionEvent = null;; paramMotionEvent = paramMotionEvent.Jrk)
              {
                ((com.tencent.mm.plugin.hld.a.c)localObject1).a(new g(paramMotionEvent));
                break;
                if (localObject2 == null)
                {
                  paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(313122);
                  throw paramMotionEvent;
                }
                paramMotionEvent = ((String)localObject2).toLowerCase();
                s.s(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
                break label557;
              }
            case 2: 
              paramMotionEvent = this.JtB;
              if (paramMotionEvent != null)
              {
                localObject2 = l.JyV;
                localObject2 = new StringBuilder("onTouch ");
                if (paramMotionEvent.y - k > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)) {}
                for (bool = true;; bool = false)
                {
                  l.jC("WxIme.S4NumberKeyboard", bool + " diff:" + (l - paramMotionEvent.time) + " yOffset:" + (paramMotionEvent.y - k) + " minHeight:" + com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height));
                  j = Math.abs(paramMotionEvent.x - i);
                  localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
                  if (j <= com.tencent.mm.plugin.hld.f.k.fOz()) {
                    break;
                  }
                  localObject2 = com.tencent.mm.plugin.hld.e.b.JqP;
                  com.tencent.mm.plugin.hld.e.b.a((View)this, this.JtB, i);
                  if ((((b)localObject1).type & 0x2) != 2)
                  {
                    localObject1 = getMKeyboardActionListener();
                    if (localObject1 != null) {
                      ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent.Jrk));
                    }
                  }
                  this.JtB = null;
                  reset();
                  AppMethodBeat.o(313122);
                  return true;
                }
              }
              break;
            case 1: 
            case 6: 
              if (af(paramMotionEvent))
              {
                ((b)localObject1).wV(false);
                paramMotionEvent = this.JtB;
                if (paramMotionEvent != null) {
                  paramMotionEvent.Jrl = true;
                }
                h((b)localObject1);
              }
              break;
            }
          }
          ((b)localObject1).wV(false);
          paramMotionEvent = this.JtB;
          if (paramMotionEvent != null) {
            paramMotionEvent.Jrl = true;
          }
        } while ((((b)localObject1).type & 0x2) == 2);
        localObject1 = getMKeyboardActionListener();
      } while (localObject1 == null);
      label674:
      paramMotionEvent = this.JtB;
      if (paramMotionEvent == null) {}
      for (paramMotionEvent = null;; paramMotionEvent = paramMotionEvent.Jrk)
      {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent));
        break;
      }
    }
    AppMethodBeat.o(313122);
    return false;
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(313073);
    super.b(paramc);
    ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).onResume();
    paramc = getMKeyboardActionListener();
    if (paramc != null) {
      ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).setOnKeyboardActionListener(paramc);
    }
    AppMethodBeat.o(313073);
  }
  
  public final a fLR()
  {
    AppMethodBeat.i(313038);
    a locala = new a((KeyboardView)this);
    AppMethodBeat.o(313038);
    return locala;
  }
  
  public final KeyboardData fLS()
  {
    AppMethodBeat.i(313047);
    Object localObject = r.JwA;
    localObject = getContext();
    s.s(localObject, "context");
    localObject = r.a((Context)localObject, getKeyboardType(), getCurrentModeInt());
    AppMethodBeat.o(313047);
    return localObject;
  }
  
  public final void fLT()
  {
    AppMethodBeat.i(313062);
    View localView = findViewById(a.f.s4_symbol_key_container);
    s.s(localView, "findViewById<ImeSboAndSy….s4_symbol_key_container)");
    h(localView, "S4_recycleview");
    AppMethodBeat.o(313062);
  }
  
  protected final b getEnterKey()
  {
    AppMethodBeat.i(313104);
    b localb = this.JtC;
    if (localb == null)
    {
      localb = aIp("enter");
      this.JtC = localb;
      AppMethodBeat.o(313104);
      return localb;
    }
    AppMethodBeat.o(313104);
    return localb;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.c getKeyboardType()
  {
    return com.tencent.mm.plugin.hld.keyboard.c.Jrs;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(313100);
    s.u(paramb, "button");
    Object localObject1 = l.JyV;
    l.jC("WxIme.S4NumberKeyboard", "onClick:" + paramb.id + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.JsQ);
    String str;
    if ((paramb.type & 0x2) == 2)
    {
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Yl(paramb.JsU);
        AppMethodBeat.o(313100);
      }
    }
    else if ((paramb.type & 0x1) == 1)
    {
      str = paramb.mainText;
      localObject1 = this.JtB;
      if (localObject1 != null) {
        break label188;
      }
    }
    label188:
    for (localObject1 = null;; localObject1 = new g(str, ((KeyboardView.c)localObject1).Jrm))
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new g(str);
      }
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).b((g)localObject2);
      }
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.n(paramb);
      AppMethodBeat.o(313100);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(313082);
    s.u(paramb, "button");
    super.j(paramb);
    Object localObject = this.JtB;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((KeyboardView.c)localObject).Jtx)
    {
      if (s.p(localObject, paramb))
      {
        paramb = f.JuH;
        f.fLV();
      }
      AppMethodBeat.o(313082);
      return;
    }
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(313090);
    super.onReset();
    ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).reset();
    AppMethodBeat.o(313090);
  }
  
  public final void wS(boolean paramBoolean)
  {
    AppMethodBeat.i(313110);
    if (paramBoolean)
    {
      findViewById(a.f.root).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(313110);
      return;
    }
    findViewById(a.f.root).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(313110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.S4NumberKeyboard
 * JD-Core Version:    0.7.0.1
 */