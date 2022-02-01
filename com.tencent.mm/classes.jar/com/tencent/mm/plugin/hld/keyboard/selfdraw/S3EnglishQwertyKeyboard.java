package com.tencent.mm.plugin.hld.keyboard.selfdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
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
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.plugin.hld.model.r;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S3EnglishQwertyKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentKeyArea", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyArea;", "enterKey", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "fetchOriginConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "getEnterKey", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getViewText", "", "button", "handleClickUpperKey", "", "doubleClick", "", "handleNormalTouch", "event", "Landroid/view/MotionEvent;", "initButtonDrawer", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "isEnterKey", "isOnlySupportClickFloatViewKey", "btn", "onButtonClick", "onButtonLongClick", "onButtonUp", "onClickForSupportDoubleClick", "onDoubleClick", "onTextKeyClick", "onTouch", "onUpperSlide", "supportDoubleClick", "transparentBg", "transparent", "updateUpperKeyImp", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S3EnglishQwertyKeyboard
  extends KeyboardView
{
  public static final S3EnglishQwertyKeyboard.a JtF;
  private KeyboardView.c JtB;
  private b JtC;
  private KeyboardView.b JtE;
  
  static
  {
    AppMethodBeat.i(313175);
    JtF = new S3EnglishQwertyKeyboard.a((byte)0);
    AppMethodBeat.o(313175);
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
  }
  
  private static String k(b paramb)
  {
    AppMethodBeat.i(313163);
    paramb = paramb.mainText;
    if (paramb == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(313163);
      throw paramb;
    }
    paramb = n.bq((CharSequence)paramb).toString();
    AppMethodBeat.o(313163);
    return paramb;
  }
  
  private final void wT(boolean paramBoolean)
  {
    AppMethodBeat.i(313172);
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
      AppMethodBeat.o(313172);
      return;
      if (i == 1) {
        Yr(2);
      } else {
        label47:
        Yr(1);
      }
    }
  }
  
  public final boolean Z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313224);
    s.u(paramMotionEvent, "event");
    Object localObject2 = getActionButton();
    if (localObject2 != null)
    {
      boolean bool;
      if (((b)localObject2).JsU == 1)
      {
        bool = a((b)localObject2, paramMotionEvent, Integer.valueOf(208));
        AppMethodBeat.o(313224);
        return bool;
      }
      a((b)localObject2, paramMotionEvent);
      int k = paramMotionEvent.getActionMasked();
      int i = (int)paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
      int j = (int)paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
      long l = System.currentTimeMillis();
      Object localObject1 = k((b)localObject2);
      Object localObject3 = l.JyV;
      l.jC("WxIme.S3EnglishQwertyKeyboard", "onTouch action " + k + ' ' + i + ' ' + j + ' ' + l + ' ' + (String)localObject1);
      if (this.JtB != null)
      {
        localObject3 = this.JtB;
        s.checkNotNull(localObject3);
        localObject3 = ((KeyboardView.c)localObject3).Jrk;
        if (localObject3 == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313224);
          throw paramMotionEvent;
        }
        localObject3 = ((String)localObject3).toLowerCase();
        s.s(localObject3, "(this as java.lang.String).toLowerCase()");
        if (localObject1 == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313224);
          throw paramMotionEvent;
        }
        String str = ((String)localObject1).toLowerCase();
        s.s(str, "(this as java.lang.String).toLowerCase()");
        if ((!Util.isEqual((String)localObject3, str)) && (k != 5) && (k != 0))
        {
          paramMotionEvent = l.JyV;
          paramMotionEvent = new StringBuilder("lastKey:");
          localObject2 = this.JtB;
          s.checkNotNull(localObject2);
          l.jC("WxIme.S3EnglishQwertyKeyboard", ((KeyboardView.c)localObject2).Jrk + " currentKey:" + (String)localObject1 + " action:" + k);
        }
      }
      label564:
      label822:
      label849:
      label1630:
      label1647:
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(313224);
            return false;
            switch (k)
            {
            case 4: 
            default: 
              break;
            case 0: 
            case 5: 
              paramMotionEvent = i.JyA;
              paramMotionEvent = getContext();
              s.s(paramMotionEvent, "context");
              i.a((b)localObject2, paramMotionEvent);
              paramMotionEvent = this.JtB;
              if ((paramMotionEvent != null) && (!paramMotionEvent.Jrl) && (!Util.isNullOrNil(paramMotionEvent.Jrk)))
              {
                localObject3 = l.JyV;
                l.jC("WxIme.S3EnglishQwertyKeyboard", s.X("process no ACTION_UP input:", paramMotionEvent.Jrk));
                paramMotionEvent.Jtx.wV(false);
                if (!f(paramMotionEvent.Jtx)) {
                  break label564;
                }
                localObject3 = getMKeyboardActionListener();
                if (localObject3 != null) {
                  ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new g(paramMotionEvent.Jrk, paramMotionEvent.Jrm));
                }
                paramMotionEvent = com.tencent.mm.plugin.hld.model.k.JvH;
                com.tencent.mm.plugin.hld.model.k.m((b)localObject2);
              }
              while (fLL()) {
                if (localObject1 == null)
                {
                  paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(313224);
                  throw paramMotionEvent;
                  h(paramMotionEvent.Jtx);
                }
                else
                {
                  paramMotionEvent = ((String)localObject1).toUpperCase();
                  s.s(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
                }
              }
              for (;;)
              {
                this.JtB = new KeyboardView.c(i, j, l, paramMotionEvent, (b)localObject2, l, 16);
                this.JtE = new KeyboardView.b(((b)localObject2).JsF.left, ((b)localObject2).JsF.top, ((b)localObject2).JsF.right, ((b)localObject2).JsF.bottom);
                if (!f((b)localObject2)) {
                  break label941;
                }
                paramMotionEvent = l.JyV;
                l.jC("WxIme.S3EnglishQwertyKeyboard", "onTextKeyClick:" + ((b)localObject2).type + ' ' + ((b)localObject2).mainText + ' ' + ((b)localObject2).floatText + ' ' + ((b)localObject2).JsU);
                localObject1 = new ArrayList();
                paramMotionEvent = k((b)localObject2);
                if (!fLL()) {
                  break label906;
                }
                if (paramMotionEvent != null) {
                  break;
                }
                paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(313224);
                throw paramMotionEvent;
                if (localObject1 == null)
                {
                  paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(313224);
                  throw paramMotionEvent;
                }
                paramMotionEvent = ((String)localObject1).toLowerCase();
                s.s(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
              }
              paramMotionEvent = paramMotionEvent.toUpperCase();
              s.s(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
              ((ArrayList)localObject1).add(paramMotionEvent);
              paramMotionEvent = f.JuH;
              f.a(1, (ArrayList)localObject1, (KeyboardView)this, (b)localObject2, this.JtB);
              ((b)localObject2).wV(true);
              if ((((b)localObject2).type & 0x2) != 2)
              {
                localObject1 = getMKeyboardActionListener();
                if (localObject1 != null)
                {
                  paramMotionEvent = this.JtB;
                  if (paramMotionEvent == null) {}
                  for (paramMotionEvent = null;; paramMotionEvent = paramMotionEvent.Jrk)
                  {
                    ((com.tencent.mm.plugin.hld.a.c)localObject1).a(new g(paramMotionEvent));
                    break;
                    if (paramMotionEvent == null)
                    {
                      paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(313224);
                      throw paramMotionEvent;
                    }
                    paramMotionEvent = paramMotionEvent.toLowerCase();
                    s.s(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
                    break label822;
                    paramMotionEvent = f.JuH;
                    f.fLV();
                    break label849;
                  }
                }
              }
              break;
            case 2: 
              if (f((b)localObject2))
              {
                paramMotionEvent = this.JtE;
                if ((paramMotionEvent != null) && ((i < paramMotionEvent.x) || (i > paramMotionEvent.Jri) || (j < paramMotionEvent.y) || (j > paramMotionEvent.Jrj)))
                {
                  paramMotionEvent = f.JuH;
                  f.fLW();
                }
              }
              paramMotionEvent = this.JtB;
              if (paramMotionEvent != null)
              {
                localObject1 = l.JyV;
                localObject1 = new StringBuilder("onTouch ");
                if (paramMotionEvent.y - j > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)) {}
                for (bool = true;; bool = false)
                {
                  l.jC("WxIme.S3EnglishQwertyKeyboard", bool + " diff:" + (l - paramMotionEvent.time) + " yOffset:" + (paramMotionEvent.y - j) + " minHeight:" + com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height));
                  k = Math.abs(paramMotionEvent.x - i);
                  localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
                  if (k <= com.tencent.mm.plugin.hld.f.k.fOz()) {
                    break;
                  }
                  localObject1 = com.tencent.mm.plugin.hld.e.b.JqP;
                  com.tencent.mm.plugin.hld.e.b.a((View)this, this.JtB, i);
                  if ((((b)localObject2).type & 0x2) != 2)
                  {
                    localObject1 = getMKeyboardActionListener();
                    if (localObject1 != null) {
                      ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent.Jrk));
                    }
                  }
                  this.JtB = null;
                  reset();
                  AppMethodBeat.o(313224);
                  return true;
                }
                if (((f((b)localObject2)) || (s.p(((b)localObject2).id, "at")) || (s.p(((b)localObject2).id, "dot"))) && (!g((b)localObject2)) && (paramMotionEvent.y - j > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)) && (i >= ((b)localObject2).JsF.left) && (i <= ((b)localObject2).JsF.right))
                {
                  paramMotionEvent = l.JyV;
                  l.jC("WxIme.S3EnglishQwertyKeyboard", "onUpperSlide:" + ((b)localObject2).type + ' ' + ((b)localObject2).mainText + ' ' + ((b)localObject2).floatText + ' ' + ((b)localObject2).JsU);
                  paramMotionEvent = new ArrayList();
                  paramMotionEvent.add(k((b)localObject2));
                  paramMotionEvent.add(((b)localObject2).floatText);
                  localObject1 = f.JuH;
                  f.a(2, paramMotionEvent, (KeyboardView)this, (b)localObject2, this.JtB);
                  AppMethodBeat.o(313224);
                  return true;
                }
              }
              break;
            case 1: 
            case 6: 
              if (af(paramMotionEvent))
              {
                ((b)localObject2).wV(false);
                paramMotionEvent = this.JtB;
                if (paramMotionEvent != null) {
                  paramMotionEvent.Jrl = true;
                }
                paramMotionEvent = f.JuH;
                f.rL(70L);
                if (f((b)localObject2))
                {
                  paramMotionEvent = k((b)localObject2);
                  if (fLL())
                  {
                    if (paramMotionEvent == null)
                    {
                      paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(313224);
                      throw paramMotionEvent;
                    }
                    localObject1 = paramMotionEvent.toUpperCase();
                    s.s(localObject1, "(this as java.lang.String).toUpperCase()");
                    paramMotionEvent = this.JtB;
                    if (paramMotionEvent != null) {
                      break label1630;
                    }
                    paramMotionEvent = null;
                    if (paramMotionEvent != null) {
                      break label1647;
                    }
                    paramMotionEvent = new g((String)localObject1);
                  }
                  for (;;)
                  {
                    localObject1 = getMKeyboardActionListener();
                    if (localObject1 != null) {
                      ((com.tencent.mm.plugin.hld.a.c)localObject1).b(paramMotionEvent);
                    }
                    paramMotionEvent = com.tencent.mm.plugin.hld.model.k.JvH;
                    com.tencent.mm.plugin.hld.model.k.m((b)localObject2);
                    break;
                    if (paramMotionEvent == null)
                    {
                      paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(313224);
                      throw paramMotionEvent;
                    }
                    localObject1 = paramMotionEvent.toLowerCase();
                    s.s(localObject1, "(this as java.lang.String).toLowerCase()");
                    break label1537;
                    paramMotionEvent = new g((String)localObject1, paramMotionEvent.Jrm);
                    break label1548;
                  }
                }
                h((b)localObject2);
              }
              break;
            }
          }
          ((b)localObject2).wV(false);
          paramMotionEvent = this.JtB;
          if (paramMotionEvent != null) {
            paramMotionEvent.Jrl = true;
          }
          paramMotionEvent = f.JuH;
          f.rL(70L);
        } while ((((b)localObject2).type & 0x2) == 2);
        localObject1 = getMKeyboardActionListener();
      } while (localObject1 == null);
      label906:
      label941:
      paramMotionEvent = this.JtB;
      label1537:
      label1548:
      if (paramMotionEvent == null) {}
      for (paramMotionEvent = null;; paramMotionEvent = paramMotionEvent.Jrk)
      {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent));
        break;
      }
    }
    AppMethodBeat.o(313224);
    return false;
  }
  
  public final boolean a(b paramb)
  {
    return (paramb != null) && (paramb.type == 2) && (paramb.JsU == 3);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(313244);
    if (paramb == null) {}
    for (Integer localInteger = null; localInteger == null; localInteger = Integer.valueOf(paramb.type))
    {
      AppMethodBeat.o(313244);
      return;
    }
    if ((localInteger.intValue() == 2) && (paramb.JsU == 3)) {
      wT(false);
    }
    AppMethodBeat.o(313244);
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(313255);
    if (paramb == null) {}
    for (Integer localInteger = null; localInteger == null; localInteger = Integer.valueOf(paramb.type))
    {
      AppMethodBeat.o(313255);
      return;
    }
    if ((localInteger.intValue() == 2) && (paramb.JsU == 3)) {
      wT(true);
    }
    AppMethodBeat.o(313255);
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(313230);
    s.u(paramb, "button");
    boolean bool = s.p(paramb.id, "enter");
    AppMethodBeat.o(313230);
    return bool;
  }
  
  protected final void fLN()
  {
    AppMethodBeat.i(313263);
    b localb = aIp("shift");
    switch (getUpperMode())
    {
    }
    for (;;)
    {
      ay((kotlin.g.a.b)new b(this));
      invalidate();
      AppMethodBeat.o(313263);
      return;
      if (localb != null)
      {
        localb.JsL = a.i.icons_outlined_capslock;
        continue;
        if (localb != null)
        {
          localb.JsL = a.i.icons_filled_capslock;
          continue;
          if (localb != null) {
            localb.JsL = a.i.icons_filled_capslocked;
          }
        }
      }
    }
  }
  
  public final a fLR()
  {
    AppMethodBeat.i(313185);
    a locala = new a((KeyboardView)this);
    locala.a((com.tencent.mm.plugin.hld.keyboard.selfdraw.a.b)new com.tencent.mm.plugin.hld.keyboard.selfdraw.a.c(locala.JsC));
    AppMethodBeat.o(313185);
    return locala;
  }
  
  public final KeyboardData fLS()
  {
    AppMethodBeat.i(313191);
    Object localObject = r.JwA;
    localObject = getContext();
    s.s(localObject, "context");
    localObject = r.a((Context)localObject, getKeyboardType(), getCurrentModeInt());
    AppMethodBeat.o(313191);
    return localObject;
  }
  
  public final boolean g(b paramb)
  {
    AppMethodBeat.i(313240);
    s.u(paramb, "btn");
    if (!paramb.JsT)
    {
      AppMethodBeat.o(313240);
      return true;
    }
    AppMethodBeat.o(313240);
    return false;
  }
  
  protected final b getEnterKey()
  {
    AppMethodBeat.i(313235);
    b localb = this.JtC;
    if (localb == null)
    {
      localb = aIp("enter");
      this.JtC = localb;
      AppMethodBeat.o(313235);
      return localb;
    }
    AppMethodBeat.o(313235);
    return localb;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.c getKeyboardType()
  {
    return com.tencent.mm.plugin.hld.keyboard.c.Jrr;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(313207);
    s.u(paramb, "button");
    super.h(paramb);
    Object localObject1 = l.JyV;
    l.jC("WxIme.S3EnglishQwertyKeyboard", "onClick:" + paramb.id + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.JsQ);
    if (e(paramb))
    {
      paramb = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.YA(201);
      AppMethodBeat.o(313207);
      return;
    }
    if ((paramb.type & 0x2) == 2)
    {
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Yl(paramb.JsU);
      }
    }
    while ((paramb.type & 0x4) != 4)
    {
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.m(paramb);
      AppMethodBeat.o(313207);
      return;
    }
    localObject1 = k(paramb);
    Object localObject2;
    if (fLL())
    {
      if (localObject1 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313207);
        throw paramb;
      }
      localObject2 = ((String)localObject1).toUpperCase();
      s.s(localObject2, "(this as java.lang.String).toUpperCase()");
      label208:
      localObject1 = this.JtB;
      if (localObject1 != null) {
        break label287;
      }
      localObject1 = null;
      label219:
      if (localObject1 != null) {
        break label303;
      }
      localObject1 = new g((String)localObject2);
    }
    label287:
    label303:
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
        paramb = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313207);
        throw paramb;
      }
      localObject2 = ((String)localObject1).toLowerCase();
      s.s(localObject2, "(this as java.lang.String).toLowerCase()");
      break label208;
      localObject1 = new g((String)localObject2, ((KeyboardView.c)localObject1).Jrm);
      break label219;
    }
  }
  
  public final boolean i(b paramb)
  {
    AppMethodBeat.i(313227);
    s.u(paramb, "button");
    Object localObject = l.JyV;
    l.jC("WxIme.S3EnglishQwertyKeyboard", "onLongClick:" + paramb.type + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.JsU);
    if (d(paramb))
    {
      paramb = (d)h.ax(d.class);
      if (paramb != null)
      {
        paramb = paramb.fKG();
        if (paramb != null) {
          paramb.fKs();
        }
      }
      AppMethodBeat.o(313227);
      return true;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramb.floatText);
    f localf = f.JuH;
    f.a(3, (ArrayList)localObject, (KeyboardView)this, paramb, this.JtB);
    AppMethodBeat.o(313227);
    return true;
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(313179);
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
      AppMethodBeat.o(313179);
      return;
    }
  }
  
  public final void wS(boolean paramBoolean)
  {
    AppMethodBeat.i(313266);
    if (paramBoolean)
    {
      findViewById(a.f.root).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(313266);
      return;
    }
    findViewById(a.f.root).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(313266);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<b, ah>
  {
    b(S3EnglishQwertyKeyboard paramS3EnglishQwertyKeyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.S3EnglishQwertyKeyboard
 * JD-Core Version:    0.7.0.1
 */