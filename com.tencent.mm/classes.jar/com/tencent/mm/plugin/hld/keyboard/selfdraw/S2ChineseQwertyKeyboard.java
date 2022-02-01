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
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S2ChineseQwertyKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentKeyArea", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyArea;", "enterKey", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "fetchOriginConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "getEnterKey", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getViewText", "", "button", "handleClickUpperKey", "", "doubleClick", "", "handleNormalTouch", "event", "Landroid/view/MotionEvent;", "initButtonDrawer", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "isEnterKey", "isOnlySupportClickFloatViewKey", "btn", "onButtonClick", "onButtonLongClick", "onButtonUp", "onClickForSupportDoubleClick", "onDoubleClick", "onTextKeyClick", "onTouch", "onUpperSlide", "supportDoubleClick", "transparentBg", "transparent", "updateUpperKeyImp", "Companion", "plugin-hld_release"})
public final class S2ChineseQwertyKeyboard
  extends KeyboardView
{
  public static final a DAE;
  private KeyboardView.c DAA;
  private b DAB;
  private KeyboardView.b DAD;
  
  static
  {
    AppMethodBeat.i(215064);
    DAE = new a((byte)0);
    AppMethodBeat.o(215064);
  }
  
  public S2ChineseQwertyKeyboard(Context paramContext)
  {
    this(paramContext, null);
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
  
  private static String k(b paramb)
  {
    AppMethodBeat.i(215013);
    paramb = paramb.mainText;
    if (paramb == null)
    {
      paramb = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(215013);
      throw paramb;
    }
    paramb = n.bb((CharSequence)paramb).toString();
    AppMethodBeat.o(215013);
    return paramb;
  }
  
  private final void sN(boolean paramBoolean)
  {
    AppMethodBeat.i(215049);
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
      AppMethodBeat.o(215049);
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
  
  public final boolean X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215023);
    p.k(paramMotionEvent, "event");
    Object localObject1 = getActionButton();
    if (localObject1 != null)
    {
      boolean bool;
      if (((b)localObject1).DzR == 1)
      {
        bool = a((b)localObject1, paramMotionEvent, Integer.valueOf(208));
        AppMethodBeat.o(215023);
        return bool;
      }
      a((b)localObject1, paramMotionEvent);
      int k = paramMotionEvent.getActionMasked();
      int i = (int)paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
      int j = (int)paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
      long l = System.currentTimeMillis();
      Object localObject2 = k((b)localObject1);
      Object localObject3 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S2ChineseQwertyKeyboard", "onTouch action " + k + ' ' + i + ' ' + j + ' ' + l + ' ' + (String)localObject2);
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
          AppMethodBeat.o(215023);
          throw paramMotionEvent;
        }
        localObject3 = ((String)localObject3).toLowerCase();
        p.j(localObject3, "(this as java.lang.String).toLowerCase()");
        if (localObject2 == null)
        {
          paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(215023);
          throw paramMotionEvent;
        }
        String str = ((String)localObject2).toLowerCase();
        p.j(str, "(this as java.lang.String).toLowerCase()");
        if ((!Util.isEqual((String)localObject3, str)) && (k != 5) && (k != 0))
        {
          paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
          paramMotionEvent = new StringBuilder("lastKey:");
          localObject1 = this.DAA;
          if (localObject1 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S2ChineseQwertyKeyboard", ((KeyboardView.c)localObject1).Dyg + " currentKey:" + (String)localObject2 + " action:" + k);
        }
      }
      label586:
      label844:
      label871:
      label1276:
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(215023);
            return false;
            switch (k)
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
              if (paramMotionEvent != null) {
                if ((!paramMotionEvent.Dyh) && (!Util.isNullOrNil(paramMotionEvent.Dyg)))
                {
                  localObject3 = com.tencent.mm.plugin.hld.f.l.DHK;
                  com.tencent.mm.plugin.hld.f.l.it("WxIme.S2ChineseQwertyKeyboard", "process no ACTION_UP input:" + paramMotionEvent.Dyg);
                  paramMotionEvent.DAw.sP(false);
                  if (!f(paramMotionEvent.DAw)) {
                    break label586;
                  }
                  localObject3 = getMKeyboardActionListener();
                  if (localObject3 != null)
                  {
                    ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new g(paramMotionEvent.Dyg, paramMotionEvent.Dyi));
                    paramMotionEvent = x.aazN;
                  }
                  paramMotionEvent = com.tencent.mm.plugin.hld.model.k.DDb;
                  com.tencent.mm.plugin.hld.model.k.l((b)localObject1);
                }
              }
              for (;;)
              {
                paramMotionEvent = x.aazN;
                if (!eDJ()) {
                  break label795;
                }
                if (localObject2 != null) {
                  break;
                }
                paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(215023);
                throw paramMotionEvent;
                h(paramMotionEvent.DAw);
              }
              paramMotionEvent = ((String)localObject2).toUpperCase();
              p.j(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
              for (;;)
              {
                this.DAA = new KeyboardView.c(i, j, l, paramMotionEvent, (b)localObject1, l, 16);
                this.DAD = new KeyboardView.b(((b)localObject1).DzC.left, ((b)localObject1).DzC.top, ((b)localObject1).DzC.right, ((b)localObject1).DzC.bottom);
                if (!f((b)localObject1)) {
                  break label970;
                }
                paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
                com.tencent.mm.plugin.hld.f.l.it("WxIme.S2ChineseQwertyKeyboard", "onTextKeyClick:" + ((b)localObject1).type + ' ' + ((b)localObject1).mainText + ' ' + ((b)localObject1).floatText + ' ' + ((b)localObject1).DzR);
                localObject2 = new ArrayList();
                paramMotionEvent = k((b)localObject1);
                if (!eDJ()) {
                  break label935;
                }
                if (paramMotionEvent != null) {
                  break;
                }
                paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(215023);
                throw paramMotionEvent;
                if (localObject2 == null)
                {
                  paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(215023);
                  throw paramMotionEvent;
                }
                paramMotionEvent = ((String)localObject2).toLowerCase();
                p.j(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
              }
              paramMotionEvent = paramMotionEvent.toUpperCase();
              p.j(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
              ((ArrayList)localObject2).add(paramMotionEvent);
              paramMotionEvent = f.DBL;
              f.a(1, (ArrayList)localObject2, (KeyboardView)this, (b)localObject1, this.DAA);
              ((b)localObject1).sP(true);
              if ((((b)localObject1).type & 0x2) != 2)
              {
                localObject1 = getMKeyboardActionListener();
                if (localObject1 != null)
                {
                  paramMotionEvent = this.DAA;
                  if (paramMotionEvent != null) {}
                  for (paramMotionEvent = paramMotionEvent.Dyg;; paramMotionEvent = null)
                  {
                    ((com.tencent.mm.plugin.hld.a.c)localObject1).a(new g(paramMotionEvent));
                    paramMotionEvent = x.aazN;
                    break;
                    if (paramMotionEvent == null)
                    {
                      paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(215023);
                      throw paramMotionEvent;
                    }
                    paramMotionEvent = paramMotionEvent.toLowerCase();
                    p.j(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
                    break label844;
                    paramMotionEvent = f.DBL;
                    f.eDS();
                    break label871;
                  }
                }
              }
              break;
            case 2: 
              if (f((b)localObject1))
              {
                paramMotionEvent = this.DAD;
                if (paramMotionEvent != null)
                {
                  if ((i < paramMotionEvent.x) || (i > paramMotionEvent.Dye) || (j < paramMotionEvent.y) || (j > paramMotionEvent.Dyf))
                  {
                    paramMotionEvent = f.DBL;
                    f.eDT();
                  }
                  paramMotionEvent = x.aazN;
                }
              }
              paramMotionEvent = this.DAA;
              if (paramMotionEvent != null)
              {
                localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
                localObject2 = new StringBuilder("onTouch ");
                if (paramMotionEvent.y - j > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height))
                {
                  bool = true;
                  com.tencent.mm.plugin.hld.f.l.it("WxIme.S2ChineseQwertyKeyboard", bool + ' ' + "diff:" + (l - paramMotionEvent.time) + " yOffset:" + (paramMotionEvent.y - j) + " minHeight:" + com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height));
                  k = Math.abs(paramMotionEvent.x - i);
                  localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
                  if (k <= com.tencent.mm.plugin.hld.f.k.eGQ()) {
                    break label1281;
                  }
                  localObject2 = com.tencent.mm.plugin.hld.e.c.DxP;
                  com.tencent.mm.plugin.hld.e.c.a((View)this, this.DAA, i);
                  if ((((b)localObject1).type & 0x2) != 2)
                  {
                    localObject1 = getMKeyboardActionListener();
                    if (localObject1 != null) {
                      if (paramMotionEvent == null) {
                        break label1276;
                      }
                    }
                  }
                }
                for (paramMotionEvent = paramMotionEvent.Dyg;; paramMotionEvent = null)
                {
                  ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent));
                  paramMotionEvent = x.aazN;
                  this.DAA = null;
                  reset();
                  AppMethodBeat.o(215023);
                  return true;
                  bool = false;
                  break;
                }
                if (((f((b)localObject1)) || (p.h(((b)localObject1).id, "at")) || (p.h(((b)localObject1).id, "dot"))) && (!g((b)localObject1)) && (paramMotionEvent.y - j > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height)) && (i >= ((b)localObject1).DzC.left) && (i <= ((b)localObject1).DzC.right))
                {
                  paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
                  com.tencent.mm.plugin.hld.f.l.it("WxIme.S2ChineseQwertyKeyboard", "onUpperSlide:" + ((b)localObject1).type + ' ' + ((b)localObject1).mainText + ' ' + ((b)localObject1).floatText + ' ' + ((b)localObject1).DzR);
                  paramMotionEvent = new ArrayList();
                  paramMotionEvent.add(k((b)localObject1));
                  localObject2 = ((b)localObject1).floatText;
                  if (localObject2 == null)
                  {
                    paramMotionEvent = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
                    AppMethodBeat.o(215023);
                    throw paramMotionEvent;
                  }
                  paramMotionEvent.add(n.bb((CharSequence)localObject2).toString());
                  localObject2 = f.DBL;
                  f.a(2, paramMotionEvent, (KeyboardView)this, (b)localObject1, this.DAA);
                  AppMethodBeat.o(215023);
                  return true;
                }
                paramMotionEvent = x.aazN;
              }
              break;
            case 1: 
            case 6: 
              if (ae(paramMotionEvent))
              {
                ((b)localObject1).sP(false);
                paramMotionEvent = this.DAA;
                if (paramMotionEvent != null)
                {
                  paramMotionEvent.Dyh = true;
                  paramMotionEvent = x.aazN;
                }
                paramMotionEvent = f.DBL;
                f.NU(70L);
                if (f((b)localObject1))
                {
                  paramMotionEvent = k((b)localObject1);
                  if (eDJ())
                  {
                    if (paramMotionEvent == null)
                    {
                      paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(215023);
                      throw paramMotionEvent;
                    }
                    paramMotionEvent = paramMotionEvent.toUpperCase();
                    p.j(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
                    localObject2 = this.DAA;
                    if (localObject2 == null) {
                      break label1726;
                    }
                  }
                  for (paramMotionEvent = new g(paramMotionEvent, ((KeyboardView.c)localObject2).Dyi);; paramMotionEvent = new g(paramMotionEvent))
                  {
                    localObject2 = getMKeyboardActionListener();
                    if (localObject2 != null)
                    {
                      ((com.tencent.mm.plugin.hld.a.c)localObject2).b(paramMotionEvent);
                      paramMotionEvent = x.aazN;
                    }
                    paramMotionEvent = com.tencent.mm.plugin.hld.model.k.DDb;
                    com.tencent.mm.plugin.hld.model.k.l((b)localObject1);
                    break;
                    if (paramMotionEvent == null)
                    {
                      paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(215023);
                      throw paramMotionEvent;
                    }
                    paramMotionEvent = paramMotionEvent.toLowerCase();
                    p.j(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
                    break label1631;
                  }
                }
                h((b)localObject1);
              }
              break;
            }
          }
          ((b)localObject1).sP(false);
          paramMotionEvent = this.DAA;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.Dyh = true;
            paramMotionEvent = x.aazN;
          }
          paramMotionEvent = f.DBL;
          f.NU(70L);
        } while ((((b)localObject1).type & 0x2) == 2);
        localObject1 = getMKeyboardActionListener();
      } while (localObject1 == null);
      label795:
      label935:
      label970:
      label1631:
      paramMotionEvent = this.DAA;
      label1281:
      label1726:
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = paramMotionEvent.Dyg;; paramMotionEvent = null)
      {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent));
        paramMotionEvent = x.aazN;
        break;
      }
    }
    AppMethodBeat.o(215023);
    return false;
  }
  
  public final boolean a(b paramb)
  {
    return (paramb != null) && (paramb.type == 2) && (paramb.DzR == 3);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(215041);
    if (paramb != null) {}
    for (Integer localInteger = Integer.valueOf(paramb.type); localInteger == null; localInteger = null)
    {
      AppMethodBeat.o(215041);
      return;
    }
    if (localInteger.intValue() == 2) {
      switch (paramb.DzR)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(215041);
      return;
      sN(false);
    }
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(215046);
    if (paramb != null) {}
    for (Integer localInteger = Integer.valueOf(paramb.type); localInteger == null; localInteger = null)
    {
      AppMethodBeat.o(215046);
      return;
    }
    if (localInteger.intValue() == 2) {
      switch (paramb.DzR)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(215046);
      return;
      sN(true);
    }
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(215031);
    p.k(paramb, "button");
    boolean bool = p.h(paramb.id, "enter");
    AppMethodBeat.o(215031);
    return bool;
  }
  
  protected final void eDL()
  {
    AppMethodBeat.i(215053);
    b localb = aLy("shift");
    switch (getUpperMode())
    {
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(215053);
      return;
      if (localb != null)
      {
        localb.DzI = a.i.icons_outlined_capslock;
        continue;
        if (localb != null)
        {
          localb.DzI = a.i.icons_filled_capslock;
          continue;
          if (localb != null) {
            localb.DzI = a.i.icons_filled_capslocked;
          }
        }
      }
    }
  }
  
  public final a eDO()
  {
    AppMethodBeat.i(215003);
    a locala = new a((KeyboardView)this);
    locala.a((com.tencent.mm.plugin.hld.keyboard.selfdraw.a.b)new com.tencent.mm.plugin.hld.keyboard.selfdraw.a.a(locala.DzB));
    AppMethodBeat.o(215003);
    return locala;
  }
  
  public final KeyboardData eDP()
  {
    AppMethodBeat.i(215007);
    Object localObject = com.tencent.mm.plugin.hld.model.t.DET;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = com.tencent.mm.plugin.hld.model.t.a((Context)localObject, getKeyboardType(), getCurrentModeInt());
    AppMethodBeat.o(215007);
    return localObject;
  }
  
  public final boolean g(b paramb)
  {
    AppMethodBeat.i(215038);
    p.k(paramb, "btn");
    if (!paramb.DzQ)
    {
      AppMethodBeat.o(215038);
      return true;
    }
    AppMethodBeat.o(215038);
    return false;
  }
  
  protected final b getEnterKey()
  {
    AppMethodBeat.i(215034);
    b localb2 = this.DAB;
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = aLy("enter");
      this.DAB = localb1;
    }
    AppMethodBeat.o(215034);
    return localb1;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.c getKeyboardType()
  {
    return com.tencent.mm.plugin.hld.keyboard.c.Dym;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(215010);
    p.k(paramb, "button");
    super.h(paramb);
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.S2ChineseQwertyKeyboard", "onClick:" + paramb.id + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.DzN);
    if (e(paramb))
    {
      paramb = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.hO(201, 1);
      AppMethodBeat.o(215010);
      return;
    }
    if ((paramb.type & 0x2) == 2)
    {
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Up(paramb.DzR);
      }
    }
    while ((paramb.type & 0x4) != 4)
    {
      localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.l(paramb);
      AppMethodBeat.o(215010);
      return;
    }
    localObject1 = k(paramb);
    label209:
    Object localObject2;
    if (eDJ())
    {
      if (localObject1 == null)
      {
        paramb = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215010);
        throw paramb;
      }
      localObject1 = ((String)localObject1).toUpperCase();
      p.j(localObject1, "(this as java.lang.String).toUpperCase()");
      localObject2 = this.DAA;
      if (localObject2 == null) {
        break label286;
      }
    }
    label286:
    for (localObject1 = new g((String)localObject1, ((KeyboardView.c)localObject2).Dyi);; localObject1 = new g((String)localObject1))
    {
      localObject2 = getMKeyboardActionListener();
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.hld.a.c)localObject2).b((g)localObject1);
      break;
      if (localObject1 == null)
      {
        paramb = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(215010);
        throw paramb;
      }
      localObject1 = ((String)localObject1).toLowerCase();
      p.j(localObject1, "(this as java.lang.String).toLowerCase()");
      break label209;
    }
  }
  
  public final boolean i(b paramb)
  {
    AppMethodBeat.i(215028);
    p.k(paramb, "button");
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.S2ChineseQwertyKeyboard", "onLongClick:" + paramb.type + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.DzR);
    if (d(paramb))
    {
      paramb = (d)h.ae(d.class);
      if (paramb != null)
      {
        paramb = paramb.eCD();
        if (paramb != null) {
          paramb.eCo();
        }
      }
      AppMethodBeat.o(215028);
      return true;
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramb.floatText;
    if (localObject2 == null)
    {
      paramb = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(215028);
      throw paramb;
    }
    ((ArrayList)localObject1).add(n.bb((CharSequence)localObject2).toString());
    localObject2 = f.DBL;
    f.a(3, (ArrayList)localObject1, (KeyboardView)this, paramb, this.DAA);
    AppMethodBeat.o(215028);
    return true;
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(215056);
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
      AppMethodBeat.o(215056);
      return;
    }
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(215059);
    if (paramBoolean)
    {
      findViewById(a.f.root).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(215059);
      return;
    }
    findViewById(a.f.root).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(215059);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S2ChineseQwertyKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.S2ChineseQwertyKeyboard
 * JD-Core Version:    0.7.0.1
 */