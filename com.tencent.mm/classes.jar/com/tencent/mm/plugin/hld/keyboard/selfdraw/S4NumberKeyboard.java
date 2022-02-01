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
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S4NumberKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "enterKey", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "fetchOriginConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "getEnterKey", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "handleNormalTouch", "", "button", "event", "Landroid/view/MotionEvent;", "initButtonDrawer", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "onButtonClick", "", "onButtonUp", "onInitFinish", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onTouch", "transparentBg", "transparent", "Companion", "plugin-hld_release"})
public final class S4NumberKeyboard
  extends KeyboardView
{
  public static final a DAH;
  private KeyboardView.c DAA;
  private b DAB;
  
  static
  {
    AppMethodBeat.i(210090);
    DAH = new a((byte)0);
    AppMethodBeat.o(210090);
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
  
  public final boolean X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(210089);
    p.k(paramMotionEvent, "event");
    Object localObject1 = getActionButton();
    if (localObject1 != null)
    {
      boolean bool;
      if (((b)localObject1).DzR == 1)
      {
        bool = a((b)localObject1, paramMotionEvent, Integer.valueOf(404));
        AppMethodBeat.o(210089);
        return bool;
      }
      a((b)localObject1, paramMotionEvent);
      int j = paramMotionEvent.getActionMasked();
      int i = (int)paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
      int k = (int)paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
      long l = System.currentTimeMillis();
      Object localObject2 = ((b)localObject1).mainText;
      Object localObject3 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", "onTouch action " + j + ' ' + i + ' ' + k + ' ' + l + ' ' + (String)localObject2);
      if (this.DAA != null)
      {
        localObject3 = this.DAA;
        if (localObject3 == null) {
          p.iCn();
        }
        localObject3 = ((KeyboardView.c)localObject3).Dyg;
        if (localObject3 == null)
        {
          paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(210089);
          throw paramMotionEvent;
        }
        localObject3 = ((String)localObject3).toLowerCase();
        p.j(localObject3, "(this as java.lang.String).toLowerCase()");
        if (localObject2 == null)
        {
          paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(210089);
          throw paramMotionEvent;
        }
        String str = ((String)localObject2).toLowerCase();
        p.j(str, "(this as java.lang.String).toLowerCase()");
        if ((!Util.isEqual((String)localObject3, str)) && (j != 5) && (j != 0))
        {
          paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
          paramMotionEvent = new StringBuilder("lastKey:");
          localObject1 = this.DAA;
          if (localObject1 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", ((KeyboardView.c)localObject1).Dyg + " currentKey:" + (String)localObject2 + " action:" + j);
        }
      }
      label571:
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(210089);
            return false;
            switch (j)
            {
            case 4: 
            default: 
              break;
            case 0: 
            case 5: 
              paramMotionEvent = i.DHq;
              paramMotionEvent = getContext();
              p.j(paramMotionEvent, "context");
              i.a((b)localObject1, paramMotionEvent);
              paramMotionEvent = this.DAA;
              if ((paramMotionEvent != null) && (!paramMotionEvent.Dyh) && (!Util.isNullOrNil(paramMotionEvent.Dyg)))
              {
                localObject3 = com.tencent.mm.plugin.hld.f.l.DHK;
                com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", "process no ACTION_UP input:" + paramMotionEvent.Dyg);
                paramMotionEvent.DAw.sP(false);
                localObject3 = getMKeyboardActionListener();
                if (localObject3 != null) {
                  ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new g(paramMotionEvent.Dyg, paramMotionEvent.Dyi));
                }
                paramMotionEvent = com.tencent.mm.plugin.hld.model.k.DDb;
                com.tencent.mm.plugin.hld.model.k.n((b)localObject1);
              }
              if (eDJ())
              {
                if (localObject2 == null)
                {
                  paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(210089);
                  throw paramMotionEvent;
                }
                paramMotionEvent = ((String)localObject2).toUpperCase();
                p.j(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
                this.DAA = new KeyboardView.c(i, k, l, paramMotionEvent, (b)localObject1, l, 16);
                ((b)localObject1).sP(true);
                if ((((b)localObject1).type & 0x2) == 2) {
                  continue;
                }
                localObject1 = getMKeyboardActionListener();
                if (localObject1 == null) {
                  continue;
                }
                paramMotionEvent = this.DAA;
                if (paramMotionEvent == null) {
                  break label691;
                }
              }
              for (paramMotionEvent = paramMotionEvent.Dyg;; paramMotionEvent = null)
              {
                ((com.tencent.mm.plugin.hld.a.c)localObject1).a(new g(paramMotionEvent));
                break;
                if (localObject2 == null)
                {
                  paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(210089);
                  throw paramMotionEvent;
                }
                paramMotionEvent = ((String)localObject2).toLowerCase();
                p.j(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
                break label571;
              }
            case 2: 
              paramMotionEvent = this.DAA;
              if (paramMotionEvent != null)
              {
                localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
                localObject2 = new StringBuilder("onTouch ");
                if (paramMotionEvent.y - k > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height))
                {
                  bool = true;
                  com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", bool + ' ' + "diff:" + (l - paramMotionEvent.time) + " yOffset:" + (paramMotionEvent.y - k) + " minHeight:" + com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height));
                  j = Math.abs(paramMotionEvent.x - i);
                  localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
                  if (j <= com.tencent.mm.plugin.hld.f.k.eGQ()) {
                    continue;
                  }
                  localObject2 = com.tencent.mm.plugin.hld.e.c.DxP;
                  com.tencent.mm.plugin.hld.e.c.a((View)this, this.DAA, i);
                  if ((((b)localObject1).type & 0x2) != 2)
                  {
                    localObject1 = getMKeyboardActionListener();
                    if (localObject1 != null) {
                      if (paramMotionEvent == null) {
                        break label923;
                      }
                    }
                  }
                }
                for (paramMotionEvent = paramMotionEvent.Dyg;; paramMotionEvent = null)
                {
                  ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent));
                  this.DAA = null;
                  reset();
                  AppMethodBeat.o(210089);
                  return true;
                  bool = false;
                  break;
                }
              }
              break;
            case 1: 
            case 6: 
              if (ae(paramMotionEvent))
              {
                ((b)localObject1).sP(false);
                paramMotionEvent = this.DAA;
                if (paramMotionEvent != null) {
                  paramMotionEvent.Dyh = true;
                }
                h((b)localObject1);
              }
              break;
            }
          }
          ((b)localObject1).sP(false);
          paramMotionEvent = this.DAA;
          if (paramMotionEvent != null) {
            paramMotionEvent.Dyh = true;
          }
        } while ((((b)localObject1).type & 0x2) == 2);
        localObject1 = getMKeyboardActionListener();
      } while (localObject1 == null);
      label691:
      paramMotionEvent = this.DAA;
      label923:
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = paramMotionEvent.Dyg;; paramMotionEvent = null)
      {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent));
        break;
      }
    }
    AppMethodBeat.o(210089);
    return false;
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(210081);
    super.b(paramc);
    ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).onResume();
    paramc = getMKeyboardActionListener();
    if (paramc != null)
    {
      ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).setOnKeyboardActionListener(paramc);
      AppMethodBeat.o(210081);
      return;
    }
    AppMethodBeat.o(210081);
  }
  
  public final a eDO()
  {
    AppMethodBeat.i(210076);
    a locala = new a((KeyboardView)this);
    AppMethodBeat.o(210076);
    return locala;
  }
  
  public final KeyboardData eDP()
  {
    AppMethodBeat.i(210077);
    Object localObject = com.tencent.mm.plugin.hld.model.t.DET;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = com.tencent.mm.plugin.hld.model.t.a((Context)localObject, getKeyboardType(), getCurrentModeInt());
    AppMethodBeat.o(210077);
    return localObject;
  }
  
  public final void eDQ()
  {
    AppMethodBeat.i(210079);
    View localView = findViewById(a.f.s4_symbol_key_container);
    p.j(localView, "findViewById<ImeSboAndSy….s4_symbol_key_container)");
    h(localView, "S4_recycleview");
    AppMethodBeat.o(210079);
  }
  
  protected final b getEnterKey()
  {
    AppMethodBeat.i(210087);
    b localb2 = this.DAB;
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = aLy("enter");
      this.DAB = localb1;
    }
    AppMethodBeat.o(210087);
    return localb1;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.c getKeyboardType()
  {
    return com.tencent.mm.plugin.hld.keyboard.c.Dyo;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(210086);
    p.k(paramb, "button");
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.S4NumberKeyboard", "onClick:" + paramb.id + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.DzN);
    if ((paramb.type & 0x2) == 2)
    {
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Up(paramb.DzR);
        AppMethodBeat.o(210086);
        return;
      }
      AppMethodBeat.o(210086);
      return;
    }
    Object localObject2;
    if ((paramb.type & 0x1) == 1)
    {
      localObject1 = paramb.mainText;
      localObject2 = this.DAA;
      if (localObject2 == null) {
        break label189;
      }
    }
    label189:
    for (localObject1 = new g((String)localObject1, ((KeyboardView.c)localObject2).Dyi);; localObject1 = new g((String)localObject1))
    {
      localObject2 = getMKeyboardActionListener();
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject2).b((g)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.n(paramb);
      AppMethodBeat.o(210086);
      return;
    }
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(210083);
    p.k(paramb, "button");
    super.j(paramb);
    Object localObject = this.DAA;
    if (localObject != null) {}
    for (localObject = ((KeyboardView.c)localObject).DAw;; localObject = null)
    {
      if (p.h(localObject, paramb))
      {
        paramb = f.DBL;
        f.eDS();
      }
      AppMethodBeat.o(210083);
      return;
    }
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(210084);
    super.onReset();
    ((ImeVerticalScrollView)findViewById(a.f.s4_symbol_key_container)).reset();
    AppMethodBeat.o(210084);
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(210088);
    if (paramBoolean)
    {
      findViewById(a.f.root).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(210088);
      return;
    }
    findViewById(a.f.root).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(210088);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S4NumberKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.S4NumberKeyboard
 * JD-Core Version:    0.7.0.1
 */