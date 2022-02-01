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
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysScrollView;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.info.Candidate;
import com.tencent.wxhld.info.PendingInput;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S1ChineseT9Keyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "enterKey", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "isIgnoreUpdateForOneKeySpecial", "", "isOneKeySpecialMode", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "fetchOriginConfig", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "getEnterKey", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getViewText", "", "button", "handleNormalTouch", "event", "Landroid/view/MotionEvent;", "initButtonDrawer", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ButtonDrawer;", "isNumberButton", "onButtonClick", "", "onButtonLongClick", "onButtonUp", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSelectCandidate", "text", "id", "", "suffix", "onTouch", "onUpperSlide", "transparentBg", "transparent", "updatePendingInputData", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "lastPendingInputContent", "", "cursorIndex", "([Lcom/tencent/wxhld/info/PendingInput;Ljava/lang/CharSequence;I)V", "Companion", "plugin-hld_release"})
public final class S1ChineseT9Keyboard
  extends KeyboardView
  implements com.tencent.mm.plugin.hld.candidate.b
{
  public static final a DAC;
  private KeyboardView.c DAA;
  private b DAB;
  private boolean DyM;
  private boolean DyN;
  
  static
  {
    AppMethodBeat.i(214337);
    DAC = new a((byte)0);
    AppMethodBeat.o(214337);
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
    AppMethodBeat.i(214305);
    paramb = paramb.mainText;
    if (paramb == null)
    {
      paramb = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(214305);
      throw paramb;
    }
    paramb = paramb.toLowerCase();
    p.j(paramb, "(this as java.lang.String).toLowerCase()");
    if (paramb == null)
    {
      paramb = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(214305);
      throw paramb;
    }
    paramb = kotlin.n.n.bb((CharSequence)paramb).toString();
    AppMethodBeat.o(214305);
    return paramb;
  }
  
  public final boolean X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(214328);
    p.k(paramMotionEvent, "event");
    Object localObject1 = getActionButton();
    if (localObject1 != null)
    {
      boolean bool;
      if (((b)localObject1).DzR == 1)
      {
        bool = a((b)localObject1, paramMotionEvent, Integer.valueOf(404));
        AppMethodBeat.o(214328);
        return bool;
      }
      a((b)localObject1, paramMotionEvent);
      int k = paramMotionEvent.getActionMasked();
      int i = (int)paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
      int j = (int)paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
      long l = System.currentTimeMillis();
      Object localObject2 = k((b)localObject1);
      Object localObject3 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "onTouch action " + k + ' ' + i + ' ' + j + ' ' + l + ' ' + (String)localObject2);
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
          AppMethodBeat.o(214328);
          throw paramMotionEvent;
        }
        localObject3 = ((String)localObject3).toLowerCase();
        p.j(localObject3, "(this as java.lang.String).toLowerCase()");
        if (localObject2 == null)
        {
          paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(214328);
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
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", ((KeyboardView.c)localObject1).Dyg + " currentKey:" + (String)localObject2 + " action:" + k);
        }
      }
      label582:
      label606:
      label1391:
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(214328);
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
                  com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "process no ACTION_UP input:" + paramMotionEvent.Dyg);
                  paramMotionEvent.DAw.sP(false);
                  if (!f(paramMotionEvent.DAw)) {
                    break label582;
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
                  break label692;
                }
                if (localObject2 != null) {
                  break;
                }
                paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(214328);
                throw paramMotionEvent;
                h(paramMotionEvent.DAw);
              }
              paramMotionEvent = ((String)localObject2).toUpperCase();
              p.j(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
              this.DAA = new KeyboardView.c(i, j, l, paramMotionEvent, (b)localObject1, l, 16);
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
                    if (localObject2 == null)
                    {
                      paramMotionEvent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                      AppMethodBeat.o(214328);
                      throw paramMotionEvent;
                    }
                    paramMotionEvent = ((String)localObject2).toLowerCase();
                    p.j(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
                    break label606;
                  }
                }
              }
              break;
            case 2: 
              paramMotionEvent = this.DAA;
              if (paramMotionEvent != null)
              {
                localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
                localObject2 = new StringBuilder("onTouch ");
                if (paramMotionEvent.y - j > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height))
                {
                  bool = true;
                  com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", bool + ' ' + "diff:" + (l - paramMotionEvent.time) + " yOffset:" + (paramMotionEvent.y - j) + " minHeight:" + com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height));
                  k = Math.abs(paramMotionEvent.x - i);
                  localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
                  if (k <= com.tencent.mm.plugin.hld.f.k.eGQ()) {
                    break label970;
                  }
                  localObject2 = com.tencent.mm.plugin.hld.e.c.DxP;
                  com.tencent.mm.plugin.hld.e.c.a((View)this, this.DAA, i);
                  if ((((b)localObject1).type & 0x2) != 2)
                  {
                    localObject1 = getMKeyboardActionListener();
                    if (localObject1 != null) {
                      if (paramMotionEvent == null) {
                        break label965;
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
                  AppMethodBeat.o(214328);
                  return true;
                  bool = false;
                  break;
                }
                if (((f((b)localObject1)) || (p.h(((b)localObject1).id, "space"))) && (!g((b)localObject1)) && (paramMotionEvent.y - j > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height)) && (i >= ((b)localObject1).DzC.left) && (i <= ((b)localObject1).DzC.right))
                {
                  paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
                  com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "onUpperSlide:" + ((b)localObject1).type + ' ' + ((b)localObject1).mainText + ' ' + ((b)localObject1).floatText + ' ' + ((b)localObject1).DzR);
                  paramMotionEvent = new ArrayList();
                  paramMotionEvent.add(k((b)localObject1));
                  paramMotionEvent.add(((b)localObject1).floatText);
                  localObject2 = com.tencent.mm.plugin.hld.model.f.DBL;
                  com.tencent.mm.plugin.hld.model.f.a(2, paramMotionEvent, (KeyboardView)this, (b)localObject1, this.DAA);
                  AppMethodBeat.o(214328);
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
                if (this.DyM)
                {
                  if ((p.h(((b)localObject1).id, "S1_key_1")) || (p.h(((b)localObject1).id, "S1_key_2")) || (p.h(((b)localObject1).id, "S1_key_3")) || (p.h(((b)localObject1).id, "S1_key_4")) || (p.h(((b)localObject1).id, "S1_key_5")) || (p.h(((b)localObject1).id, "S1_key_6")) || (p.h(((b)localObject1).id, "S1_key_7")) || (p.h(((b)localObject1).id, "S1_key_8")) || (p.h(((b)localObject1).id, "S1_key_9")) || (p.h(((b)localObject1).id, "space")))
                  {
                    i = 1;
                    if (i == 0) {
                      break label1840;
                    }
                    paramMotionEvent = ((b)localObject1).floatText;
                    localObject2 = this.DAA;
                    if (localObject2 == null) {
                      break label1587;
                    }
                    paramMotionEvent = new g(paramMotionEvent, ((KeyboardView.c)localObject2).Dyi);
                    localObject2 = getMKeyboardActionListener();
                    if (localObject2 != null)
                    {
                      ((com.tencent.mm.plugin.hld.a.c)localObject2).d(paramMotionEvent);
                      paramMotionEvent = x.aazN;
                    }
                    paramMotionEvent = com.tencent.mm.plugin.hld.model.f.DBL;
                    com.tencent.mm.plugin.hld.model.f.eDS();
                    paramMotionEvent = com.tencent.mm.plugin.hld.model.k.DDb;
                    p.k(localObject1, "btn");
                    if (com.tencent.mm.plugin.hld.model.k.eEz()) {
                      continue;
                    }
                    paramMotionEvent = ((b)localObject1).id;
                    switch (paramMotionEvent.hashCode())
                    {
                    default: 
                      i = -1;
                    }
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.hld.model.k.hO(i, 1);
                    break;
                    i = 0;
                    break label1356;
                    paramMotionEvent = new g(paramMotionEvent);
                    break label1391;
                    if (!paramMotionEvent.equals("num")) {
                      break label1572;
                    }
                    i = 103;
                    continue;
                    if (!paramMotionEvent.equals("clear")) {
                      break label1572;
                    }
                    i = 107;
                    continue;
                    if (!paramMotionEvent.equals("space")) {
                      break label1572;
                    }
                    i = 104;
                    continue;
                    if (!paramMotionEvent.equals("S1_key_3")) {
                      break label1572;
                    }
                    for (;;)
                    {
                      i = 100;
                      break label1574;
                      if (!paramMotionEvent.equals("S1_key_4")) {
                        break;
                      }
                      continue;
                      if (!paramMotionEvent.equals("S1_key_1")) {
                        break;
                      }
                      continue;
                      if (!paramMotionEvent.equals("S1_key_2")) {
                        break;
                      }
                      continue;
                      if (!paramMotionEvent.equals("S1_key_7")) {
                        break;
                      }
                      continue;
                      if (!paramMotionEvent.equals("S1_key_8")) {
                        break;
                      }
                      continue;
                      if (!paramMotionEvent.equals("S1_key_5")) {
                        break;
                      }
                      continue;
                      if (!paramMotionEvent.equals("S1_key_6")) {
                        break;
                      }
                      continue;
                      if (!paramMotionEvent.equals("S1_key_9")) {
                        break;
                      }
                    }
                    if (!paramMotionEvent.equals("enter")) {
                      break label1572;
                    }
                    paramMotionEvent = (d)h.ae(d.class);
                    if (paramMotionEvent != null)
                    {
                      paramMotionEvent = paramMotionEvent.eCD();
                      if ((paramMotionEvent != null) && (paramMotionEvent.eCn() == true))
                      {
                        i = 108;
                        continue;
                        if (!paramMotionEvent.equals("cnSwitch")) {
                          break label1572;
                        }
                        i = 105;
                        continue;
                      }
                    }
                    i = 109;
                  }
                }
                if (f((b)localObject1))
                {
                  if (p.h(((b)localObject1).id, "S1_key_1"))
                  {
                    paramMotionEvent = com.tencent.mm.plugin.hld.model.n.DEn;
                    if (!com.tencent.mm.plugin.hld.model.n.eEE())
                    {
                      paramMotionEvent = com.tencent.mm.plugin.hld.model.n.DEn;
                      localObject3 = com.tencent.mm.plugin.hld.model.n.eEP();
                      paramMotionEvent = com.tencent.mm.plugin.hld.model.n.DEn;
                      localObject2 = ((Candidate)localObject3).text;
                      p.j(localObject2, "candidate.text");
                      localObject3 = ((Candidate)localObject3).id;
                      p.j(localObject3, "candidate.id");
                      com.tencent.mm.plugin.hld.model.n.a(paramMotionEvent, (String)localObject2, (byte[])localObject3, "", false, 0L, true, 8);
                      paramMotionEvent = com.tencent.mm.plugin.hld.model.k.DDb;
                      com.tencent.mm.plugin.hld.model.k.hN(1, 0);
                    }
                    paramMotionEvent = ((b)localObject1).floatText + ((b)localObject1).mainText;
                    localObject2 = this.DAA;
                    if (localObject2 != null) {}
                    for (paramMotionEvent = new g(paramMotionEvent, ((KeyboardView.c)localObject2).Dyi);; paramMotionEvent = new g(paramMotionEvent))
                    {
                      localObject2 = getMKeyboardActionListener();
                      if (localObject2 != null)
                      {
                        ((com.tencent.mm.plugin.hld.a.c)localObject2).d(paramMotionEvent);
                        paramMotionEvent = x.aazN;
                      }
                      this.DyM = true;
                      this.DyN = true;
                      paramMotionEvent = com.tencent.mm.plugin.hld.model.k.DDb;
                      com.tencent.mm.plugin.hld.model.k.l((b)localObject1);
                      break;
                    }
                  }
                  paramMotionEvent = k((b)localObject1);
                  localObject2 = this.DAA;
                  if (localObject2 != null) {}
                  for (paramMotionEvent = new g(paramMotionEvent, ((KeyboardView.c)localObject2).Dyi);; paramMotionEvent = new g(paramMotionEvent))
                  {
                    localObject2 = getMKeyboardActionListener();
                    if (localObject2 == null) {
                      break;
                    }
                    ((com.tencent.mm.plugin.hld.a.c)localObject2).b(paramMotionEvent);
                    paramMotionEvent = x.aazN;
                    break;
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
          paramMotionEvent = com.tencent.mm.plugin.hld.model.f.DBL;
          com.tencent.mm.plugin.hld.model.f.NU(70L);
        } while ((((b)localObject1).type & 0x2) == 2);
        localObject1 = getMKeyboardActionListener();
      } while (localObject1 == null);
      label692:
      label965:
      label970:
      label1356:
      paramMotionEvent = this.DAA;
      label1572:
      label1574:
      label1587:
      if (paramMotionEvent != null) {}
      label1840:
      for (paramMotionEvent = paramMotionEvent.Dyg;; paramMotionEvent = null)
      {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).c(new g(paramMotionEvent));
        paramMotionEvent = x.aazN;
        break;
      }
    }
    AppMethodBeat.o(214328);
    return false;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(214330);
    p.k(paramString1, "text");
    p.k(paramArrayOfByte, "id");
    super.a(paramString1, paramArrayOfByte, paramString2);
    this.DyM = false;
    AppMethodBeat.o(214330);
  }
  
  public final void a(PendingInput[] paramArrayOfPendingInput, CharSequence paramCharSequence, int paramInt)
  {
    if (this.DyM) {
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
        if (!this.DyN) {
          this.DyM = false;
        }
      }
      this.DyN = false;
      return;
    }
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(214296);
    super.b(paramc);
    paramc = (ImeVerticalScrollView)findViewById(a.f.t9_symbol_key_list);
    com.tencent.mm.plugin.hld.a.c localc = getMKeyboardActionListener();
    if (localc != null) {
      paramc.setOnKeyboardActionListener(localc);
    }
    paramc.onResume();
    p.j(paramc, "symbolKeyList");
    h((View)paramc, "S1_recycleview");
    paramc = com.tencent.mm.plugin.hld.model.n.DEn;
    com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.candidate.b)this);
    AppMethodBeat.o(214296);
  }
  
  public final a eDO()
  {
    AppMethodBeat.i(214288);
    a locala = new a((KeyboardView)this);
    locala.a((com.tencent.mm.plugin.hld.keyboard.selfdraw.a.b)new com.tencent.mm.plugin.hld.keyboard.selfdraw.a.f(locala.DzB));
    AppMethodBeat.o(214288);
    return locala;
  }
  
  public final KeyboardData eDP()
  {
    AppMethodBeat.i(214292);
    Object localObject = com.tencent.mm.plugin.hld.model.t.DET;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = com.tencent.mm.plugin.hld.model.t.a((Context)localObject, getKeyboardType(), getCurrentModeInt());
    AppMethodBeat.o(214292);
    return localObject;
  }
  
  protected final b getEnterKey()
  {
    AppMethodBeat.i(214314);
    b localb2 = this.DAB;
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = aLy("enter");
      this.DAB = localb1;
    }
    AppMethodBeat.o(214314);
    return localb1;
  }
  
  public final com.tencent.mm.plugin.hld.keyboard.c getKeyboardType()
  {
    return com.tencent.mm.plugin.hld.keyboard.c.Dyl;
  }
  
  public final void h(b paramb)
  {
    AppMethodBeat.i(214302);
    p.k(paramb, "button");
    super.h(paramb);
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "onClick:" + paramb.id + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.DzN);
    if (e(paramb))
    {
      paramb = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.hO(201, 1);
      AppMethodBeat.o(214302);
      return;
    }
    if ((paramb.type & 0x2) == 2) {
      switch (paramb.DzR)
      {
      default: 
        localObject1 = getMKeyboardActionListener();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.hld.a.c)localObject1).Up(paramb.DzR);
        }
        break;
      }
    }
    while ((paramb.type & 0x4) != 4) {
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
        com.tencent.mm.plugin.hld.model.k.l(paramb);
        AppMethodBeat.o(214302);
        return;
        this.DyM = false;
      }
    }
    localObject1 = k(paramb);
    Object localObject2 = this.DAA;
    if (localObject2 != null) {}
    for (localObject1 = new g((String)localObject1, ((KeyboardView.c)localObject2).Dyi);; localObject1 = new g((String)localObject1))
    {
      localObject2 = getMKeyboardActionListener();
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.hld.a.c)localObject2).b((g)localObject1);
      break;
    }
  }
  
  public final boolean i(b paramb)
  {
    int i = 0;
    AppMethodBeat.i(214317);
    p.k(paramb, "button");
    if (paramb.DzO)
    {
      Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "onLongClick:" + paramb.type + ' ' + paramb.mainText + ' ' + paramb.floatText + ' ' + paramb.DzR);
      localObject1 = new ArrayList();
      Object localObject2 = paramb.mainText;
      if (localObject2 == null)
      {
        paramb = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(214317);
        throw paramb;
      }
      localObject2 = ((String)localObject2).toCharArray();
      p.j(localObject2, "(this as java.lang.String).toCharArray()");
      ((ArrayList)localObject1).add(paramb.floatText);
      if (p.h(paramb.id, "S1_key_1"))
      {
        int j = localObject2.length;
        while (i < j)
        {
          String str = String.valueOf(localObject2[i]);
          if (str == null)
          {
            paramb = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(214317);
            throw paramb;
          }
          str = str.toLowerCase();
          p.j(str, "(this as java.lang.String).toLowerCase()");
          ((ArrayList)localObject1).add(str);
          i += 1;
        }
      }
      localObject2 = com.tencent.mm.plugin.hld.model.f.DBL;
      com.tencent.mm.plugin.hld.model.f.a(3, (ArrayList)localObject1, (KeyboardView)this, paramb, this.DAA);
      AppMethodBeat.o(214317);
      return true;
    }
    AppMethodBeat.o(214317);
    return false;
  }
  
  public final void j(b paramb)
  {
    AppMethodBeat.i(214332);
    p.k(paramb, "button");
    super.j(paramb);
    Object localObject = this.DAA;
    if (localObject != null) {}
    for (localObject = ((KeyboardView.c)localObject).DAw;; localObject = null)
    {
      if (p.h(localObject, paramb))
      {
        paramb = com.tencent.mm.plugin.hld.model.f.DBL;
        com.tencent.mm.plugin.hld.model.f.eDS();
      }
      AppMethodBeat.o(214332);
      return;
    }
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(214299);
    super.onReset();
    ((ImeVerticalScrollView)findViewById(a.f.t9_symbol_key_list)).reset();
    ((ImeSboAndSybKeysScrollView)findViewById(a.f.t9_symbol_key_list)).reset();
    com.tencent.mm.plugin.hld.model.n localn = com.tencent.mm.plugin.hld.model.n.DEn;
    com.tencent.mm.plugin.hld.model.n.b((com.tencent.mm.plugin.hld.candidate.b)this);
    AppMethodBeat.o(214299);
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(214311);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(214311);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(214311);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/S1ChineseT9Keyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.selfdraw.S1ChineseT9Keyboard
 * JD-Core Version:    0.7.0.1
 */