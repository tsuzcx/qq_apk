package com.tencent.mm.plugin.hld.keyboard.selfdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.model.r;
import com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysScrollView;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.info.Candidate;
import com.tencent.wxhld.info.PendingInput;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S1ChineseT9Keyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "enterKey", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "isIgnoreUpdateForOneKeySpecial", "", "isOneKeySpecialMode", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "fetchOriginConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "getEnterKey", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getViewText", "", "button", "handleNormalTouch", "event", "Landroid/view/MotionEvent;", "initButtonDrawer", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "isNumberButton", "onButtonClick", "", "onButtonLongClick", "onButtonUp", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSelectCandidate", "text", "id", "", "suffix", "onTouch", "onUpperSlide", "transparentBg", "transparent", "updatePendingInputData", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "lastPendingInputContent", "", "cursorIndex", "([Lcom/tencent/wxhld/info/PendingInput;Ljava/lang/CharSequence;I)V", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S1ChineseT9Keyboard
  extends KeyboardView
  implements com.tencent.mm.plugin.hld.candidate.b
{
  public static final S1ChineseT9Keyboard.a JtA;
  private boolean JrR;
  private boolean JrS;
  private KeyboardView.c JtB;
  private b JtC;
  
  static
  {
    AppMethodBeat.i(313166);
    JtA = new S1ChineseT9Keyboard.a((byte)0);
    AppMethodBeat.o(313166);
  }
  
  public S1ChineseT9Keyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S1ChineseT9Keyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S1ChineseT9Keyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private static String k(b paramb)
  {
    AppMethodBeat.i(313159);
    paramb = paramb.mainText;
    if (paramb == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(313159);
      throw paramb;
    }
    paramb = paramb.toLowerCase();
    s.s(paramb, "(this as java.lang.String).toLowerCase()");
    if (paramb == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(313159);
      throw paramb;
    }
    paramb = kotlin.n.n.bq((CharSequence)paramb).toString();
    AppMethodBeat.o(313159);
    return paramb;
  }
  
  public final boolean Z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313243);
    s.u(paramMotionEvent, "event");
    Object localObject2 = getActionButton();
    if (localObject2 != null)
    {
      boolean bool;
      if (((b)localObject2).JsU == 1)
      {
        bool = a((b)localObject2, paramMotionEvent, Integer.valueOf(404));
        AppMethodBeat.o(313243);
        return bool;
      }
      a((b)localObject2, paramMotionEvent);
      int k = paramMotionEvent.getActionMasked();
      int i = (int)paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
      int j = (int)paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
      long l = System.currentTimeMillis();
      Object localObject1 = k((b)localObject2);
      Object localObject3 = l.JyV;
      l.jC("WxIme.S1ChineseT9Keyboard", "onTouch action " + k + ' ' + i + ' ' + j + ' ' + l + ' ' + (String)localObject1);
      if (this.JtB != null)
      {
        localObject3 = this.JtB;
        s.checkNotNull(localObject3);
        localObject3 = ((KeyboardView.c)localObject3).Jrk;
        if (localObject3 == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313243);
          throw paramMotionEvent;
        }
        localObject3 = ((String)localObject3).toLowerCase();
        s.s(localObject3, "(this as java.lang.String).toLowerCase()");
        if (localObject1 == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313243);
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
          l.jC("WxIme.S1ChineseT9Keyboard", ((KeyboardView.c)localObject2).Jrk + " currentKey:" + (String)localObject1 + " action:" + k);
        }
      }
      label560:
      label584:
      label1512:
      label1514:
      label1527:
      label1790:
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(313243);
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
                l.jC("WxIme.S1ChineseT9Keyboard", s.X("process no ACTION_UP input:", paramMotionEvent.Jrk));
                paramMotionEvent.Jtx.wV(false);
                if (!f(paramMotionEvent.Jtx)) {
                  break label560;
                }
                localObject3 = getMKeyboardActionListener();
                if (localObject3 != null) {
                  ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new g(paramMotionEvent.Jrk, paramMotionEvent.Jrm));
                }
                paramMotionEvent = com.tencent.mm.plugin.hld.model.k.JvH;
                com.tencent.mm.plugin.hld.model.k.l((b)localObject2);
              }
              for (;;)
              {
                if (fLL()) {
                  if (localObject1 == null)
                  {
                    paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(313243);
                    throw paramMotionEvent;
                    h(paramMotionEvent.Jtx);
                  }
                  else
                  {
                    paramMotionEvent = ((String)localObject1).toUpperCase();
                    s.s(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
                    this.JtB = new KeyboardView.c(i, j, l, paramMotionEvent, (b)localObject2, l, 16);
                    ((b)localObject2).wV(true);
                    if ((((b)localObject2).type & 0x2) == 2) {
                      break;
                    }
                    localObject1 = getMKeyboardActionListener();
                    if (localObject1 == null) {
                      break;
                    }
                    paramMotionEvent = this.JtB;
                    if (paramMotionEvent != null) {
                      break label700;
                    }
                  }
                }
              }
              for (paramMotionEvent = null;; paramMotionEvent = paramMotionEvent.Jrk)
              {
                ((com.tencent.mm.plugin.hld.a.c)localObject1).a(new g(paramMotionEvent));
                break;
                if (localObject1 == null)
                {
                  paramMotionEvent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(313243);
                  throw paramMotionEvent;
                }
                paramMotionEvent = ((String)localObject1).toLowerCase();
                s.s(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
                break label584;
              }
            case 2: 
              paramMotionEvent = this.JtB;
              if (paramMotionEvent != null)
              {
                localObject1 = l.JyV;
                localObject1 = new StringBuilder("onTouch ");
                if (paramMotionEvent.y - j > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)) {}
                for (bool = true;; bool = false)
                {
                  l.jC("WxIme.S1ChineseT9Keyboard", bool + " diff:" + (l - paramMotionEvent.time) + " yOffset:" + (paramMotionEvent.y - j) + " minHeight:" + com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height));
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
                  AppMethodBeat.o(313243);
                  return true;
                }
                if (((f((b)localObject2)) || (s.p(((b)localObject2).id, "space"))) && (!g((b)localObject2)) && (paramMotionEvent.y - j > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)) && (i >= ((b)localObject2).JsF.left) && (i <= ((b)localObject2).JsF.right))
                {
                  paramMotionEvent = l.JyV;
                  l.jC("WxIme.S1ChineseT9Keyboard", "onUpperSlide:" + ((b)localObject2).type + ' ' + ((b)localObject2).mainText + ' ' + ((b)localObject2).floatText + ' ' + ((b)localObject2).JsU);
                  paramMotionEvent = new ArrayList();
                  paramMotionEvent.add(k((b)localObject2));
                  paramMotionEvent.add(((b)localObject2).floatText);
                  localObject1 = com.tencent.mm.plugin.hld.model.f.JuH;
                  com.tencent.mm.plugin.hld.model.f.a(2, paramMotionEvent, (KeyboardView)this, (b)localObject2, this.JtB);
                  AppMethodBeat.o(313243);
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
                if (this.JrR)
                {
                  if ((s.p(((b)localObject2).id, "S1_key_1")) || (s.p(((b)localObject2).id, "S1_key_2")) || (s.p(((b)localObject2).id, "S1_key_3")) || (s.p(((b)localObject2).id, "S1_key_4")) || (s.p(((b)localObject2).id, "S1_key_5")) || (s.p(((b)localObject2).id, "S1_key_6")) || (s.p(((b)localObject2).id, "S1_key_7")) || (s.p(((b)localObject2).id, "S1_key_8")) || (s.p(((b)localObject2).id, "S1_key_9")) || (s.p(((b)localObject2).id, "space")))
                  {
                    i = 1;
                    if (i == 0) {
                      break label1796;
                    }
                    localObject3 = ((b)localObject2).floatText;
                    paramMotionEvent = this.JtB;
                    if (paramMotionEvent != null) {
                      break label1527;
                    }
                    paramMotionEvent = null;
                    localObject1 = paramMotionEvent;
                    if (paramMotionEvent == null) {
                      localObject1 = new g((String)localObject3);
                    }
                    paramMotionEvent = getMKeyboardActionListener();
                    if (paramMotionEvent != null) {
                      paramMotionEvent.d((g)localObject1);
                    }
                    paramMotionEvent = com.tencent.mm.plugin.hld.model.f.JuH;
                    com.tencent.mm.plugin.hld.model.f.fLV();
                    paramMotionEvent = com.tencent.mm.plugin.hld.model.k.JvH;
                    s.u(localObject2, "btn");
                    if (com.tencent.mm.plugin.hld.model.k.fMC()) {
                      continue;
                    }
                    paramMotionEvent = ((b)localObject2).id;
                    switch (paramMotionEvent.hashCode())
                    {
                    default: 
                      i = -1;
                    }
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.hld.model.k.js(i, 1);
                    break;
                    i = 0;
                    break label1299;
                    paramMotionEvent = new g((String)localObject3, paramMotionEvent.Jrm);
                    break label1321;
                    if (!paramMotionEvent.equals("num")) {
                      break label1512;
                    }
                    i = 103;
                    continue;
                    if (!paramMotionEvent.equals("clear")) {
                      break label1512;
                    }
                    i = 107;
                    continue;
                    if (!paramMotionEvent.equals("space")) {
                      break label1512;
                    }
                    i = 104;
                    continue;
                    if (!paramMotionEvent.equals("S1_key_3")) {
                      break label1512;
                    }
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    i = 100;
                                    break;
                                  } while (paramMotionEvent.equals("S1_key_4"));
                                  break;
                                } while (paramMotionEvent.equals("S1_key_1"));
                                break;
                              } while (paramMotionEvent.equals("S1_key_2"));
                              break;
                            } while (paramMotionEvent.equals("S1_key_7"));
                            break;
                          } while (paramMotionEvent.equals("S1_key_8"));
                          break;
                        } while (paramMotionEvent.equals("S1_key_5"));
                        break;
                      } while (paramMotionEvent.equals("S1_key_6"));
                      break;
                    } while (paramMotionEvent.equals("S1_key_9"));
                    if ((goto 1512) || (!paramMotionEvent.equals("enter"))) {
                      break label1512;
                    }
                    paramMotionEvent = (d)h.ax(d.class);
                    if (paramMotionEvent != null)
                    {
                      paramMotionEvent = paramMotionEvent.fKG();
                      if ((paramMotionEvent == null) || (paramMotionEvent.fKr() != true)) {}
                    }
                    for (i = 1;; i = 0)
                    {
                      if (i == 0) {
                        break label1790;
                      }
                      i = 108;
                      break label1514;
                      if (!paramMotionEvent.equals("cnSwitch")) {
                        break;
                      }
                      i = 105;
                      break label1514;
                    }
                    i = 109;
                  }
                }
                if (f((b)localObject2))
                {
                  if (s.p(((b)localObject2).id, "S1_key_1"))
                  {
                    paramMotionEvent = com.tencent.mm.plugin.hld.model.n.JvW;
                    if (!com.tencent.mm.plugin.hld.model.n.fMH())
                    {
                      paramMotionEvent = com.tencent.mm.plugin.hld.model.n.JvW;
                      localObject3 = com.tencent.mm.plugin.hld.model.n.fMS();
                      paramMotionEvent = com.tencent.mm.plugin.hld.model.n.JvW;
                      localObject1 = ((Candidate)localObject3).text;
                      s.s(localObject1, "candidate.text");
                      localObject3 = ((Candidate)localObject3).id;
                      s.s(localObject3, "candidate.id");
                      com.tencent.mm.plugin.hld.model.n.a(paramMotionEvent, (String)localObject1, (byte[])localObject3, "", false, 0L, true, 8);
                      paramMotionEvent = com.tencent.mm.plugin.hld.model.k.JvH;
                      com.tencent.mm.plugin.hld.model.k.jr(1, 0);
                    }
                    localObject3 = s.X(((b)localObject2).floatText, ((b)localObject2).mainText);
                    paramMotionEvent = this.JtB;
                    if (paramMotionEvent == null) {}
                    for (paramMotionEvent = null;; paramMotionEvent = new g((String)localObject3, paramMotionEvent.Jrm))
                    {
                      localObject1 = paramMotionEvent;
                      if (paramMotionEvent == null) {
                        localObject1 = new g((String)localObject3);
                      }
                      paramMotionEvent = getMKeyboardActionListener();
                      if (paramMotionEvent != null) {
                        paramMotionEvent.d((g)localObject1);
                      }
                      this.JrR = true;
                      this.JrS = true;
                      paramMotionEvent = com.tencent.mm.plugin.hld.model.k.JvH;
                      com.tencent.mm.plugin.hld.model.k.l((b)localObject2);
                      break;
                    }
                  }
                  localObject3 = k((b)localObject2);
                  paramMotionEvent = this.JtB;
                  if (paramMotionEvent == null) {}
                  for (paramMotionEvent = null;; paramMotionEvent = new g((String)localObject3, paramMotionEvent.Jrm))
                  {
                    localObject1 = paramMotionEvent;
                    if (paramMotionEvent == null) {
                      localObject1 = new g((String)localObject3);
                    }
                    paramMotionEvent = getMKeyboardActionListener();
                    if (paramMotionEvent == null) {
                      break;
                    }
                    paramMotionEvent.b((g)localObject1);
                    break;
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
          paramMotionEvent = com.tencent.mm.plugin.hld.model.f.JuH;
          com.tencent.mm.plugin.hld.model.f.rL(70L);
        } while ((((b)localObject2).type & 0x2) == 2);
        localObject1 = getMKeyboardActionListener();
      } while (localObject1 == null);
      label700:
      paramMotionEvent = this.JtB;
      label1299:
      label1321:
      if (paramMotionEvent == null) {}
      label1796:
      for (paramMotionEvent = null;; paramMotionEvent = paramMotionEvent.Jrk)
      {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent));
        break;
      }
    }
    AppMethodBeat.o(313243);
    return false;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(313248);
    s.u(paramString1, "text");
    s.u(paramArrayOfByte, "id");
    super.a(paramString1, paramArrayOfByte, paramString2);
    this.JrR = false;
    AppMethodBeat.o(313248);
  }
  
  public final void a(PendingInput[] paramArrayOfPendingInput, CharSequence paramCharSequence, int paramInt)
  {
    if (this.JrR) {
      if (paramArrayOfPendingInput != null) {
        if (paramArrayOfPendingInput.length != 0) {
          break label40;
        }
      }
    }
    label40:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        if (!this.JrS) {
          this.JrR = false;
        }
      }
      this.JrS = false;
      return;
    }
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(313189);
    super.b(paramc);
    paramc = (ImeVerticalScrollView)findViewById(a.f.t9_symbol_key_list);
    com.tencent.mm.plugin.hld.a.c localc = getMKeyboardActionListener();
    if (localc != null) {
      paramc.setOnKeyboardActionListener(localc);
    }
    paramc.onResume();
    s.s(paramc, "symbolKeyList");
    h((View)paramc, "S1_recycleview");
    paramc = com.tencent.mm.plugin.hld.model.n.JvW;
    com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.candidate.b)this);
    AppMethodBeat.o(313189);
  }
  
  public final a fLR()
  {
    AppMethodBeat.i(313173);
    a locala = new a((KeyboardView)this);
    locala.a((com.tencent.mm.plugin.hld.keyboard.selfdraw.a.b)new com.tencent.mm.plugin.hld.keyboard.selfdraw.a.f(locala.JsC));
    AppMethodBeat.o(313173);
    return locala;
  }
  
  public final KeyboardData fLS()
  {
    AppMethodBeat.i(313178);
    Object localObject = r.JwA;
    localObject = getContext();
    s.s(localObject, "context");
    localObject = r.a((Context)localObject, getKeyboardType(), getCurrentModeInt());
    AppMethodBeat.o(313178);
    return localObject;
  }
  
  protected final b getEnterKey()
  {
    AppMethodBeat.i(313214);
    b localb = this.JtC;
    if (localb == null)
    {
      localb = aIp("enter");
      this.JtC = localb;
      AppMethodBeat.o(313214);
      return localb;
    }
    AppMethodBeat.o(313214);
    return localb;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.c getKeyboardType()
  {
    return com.tencent.mm.plugin.hld.keyboard.c.Jrp;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(313205);
    s.u(paramb, "button");
    super.h(paramb);
    Object localObject1 = l.JyV;
    l.jC("WxIme.S1ChineseT9Keyboard", "onClick:" + paramb.id + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.JsQ);
    if (e(paramb))
    {
      paramb = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.YA(201);
      AppMethodBeat.o(313205);
      return;
    }
    if ((paramb.type & 0x2) == 2) {
      switch (paramb.JsU)
      {
      default: 
        localObject1 = getMKeyboardActionListener();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.hld.a.c)localObject1).Yl(paramb.JsU);
        }
        break;
      }
    }
    while ((paramb.type & 0x4) != 4) {
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.l(paramb);
        AppMethodBeat.o(313205);
        return;
        this.JrR = false;
      }
    }
    String str = k(paramb);
    localObject1 = this.JtB;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = new g(str, ((KeyboardView.c)localObject1).Jrm))
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new g(str);
      }
      localObject1 = getMKeyboardActionListener();
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.hld.a.c)localObject1).b((g)localObject2);
      break;
    }
  }
  
  public final boolean i(b paramb)
  {
    int i = 0;
    AppMethodBeat.i(313220);
    s.u(paramb, "button");
    if (paramb.JsR)
    {
      Object localObject1 = l.JyV;
      l.jC("WxIme.S1ChineseT9Keyboard", "onLongClick:" + paramb.type + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.JsU);
      localObject1 = new ArrayList();
      Object localObject2 = paramb.mainText;
      if (localObject2 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313220);
        throw paramb;
      }
      localObject2 = ((String)localObject2).toCharArray();
      s.s(localObject2, "(this as java.lang.String).toCharArray()");
      ((ArrayList)localObject1).add(paramb.floatText);
      if (s.p(paramb.id, "S1_key_1"))
      {
        int j = localObject2.length;
        while (i < j)
        {
          char c = localObject2[i];
          i += 1;
          String str = String.valueOf(c);
          if (str == null)
          {
            paramb = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(313220);
            throw paramb;
          }
          str = str.toLowerCase();
          s.s(str, "(this as java.lang.String).toLowerCase()");
          ((ArrayList)localObject1).add(str);
        }
      }
      localObject2 = com.tencent.mm.plugin.hld.model.f.JuH;
      com.tencent.mm.plugin.hld.model.f.a(3, (ArrayList)localObject1, (KeyboardView)this, paramb, this.JtB);
      AppMethodBeat.o(313220);
      return true;
    }
    AppMethodBeat.o(313220);
    return false;
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(313253);
    s.u(paramb, "button");
    super.j(paramb);
    Object localObject = this.JtB;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((KeyboardView.c)localObject).Jtx)
    {
      if (s.p(localObject, paramb))
      {
        paramb = com.tencent.mm.plugin.hld.model.f.JuH;
        com.tencent.mm.plugin.hld.model.f.fLV();
      }
      AppMethodBeat.o(313253);
      return;
    }
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(313196);
    super.onReset();
    ((ImeVerticalScrollView)findViewById(a.f.t9_symbol_key_list)).reset();
    ((ImeSboAndSybKeysScrollView)findViewById(a.f.t9_symbol_key_list)).reset();
    com.tencent.mm.plugin.hld.model.n localn = com.tencent.mm.plugin.hld.model.n.JvW;
    com.tencent.mm.plugin.hld.model.n.b((com.tencent.mm.plugin.hld.candidate.b)this);
    AppMethodBeat.o(313196);
  }
  
  public final void wS(boolean paramBoolean)
  {
    AppMethodBeat.i(313211);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(313211);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(313211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.S1ChineseT9Keyboard
 * JD-Core Version:    0.7.0.1
 */