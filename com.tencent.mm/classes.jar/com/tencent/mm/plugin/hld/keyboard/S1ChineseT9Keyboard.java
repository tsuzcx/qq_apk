package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysScrollView;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.info.Candidate;
import com.tencent.wxhld.info.PendingInput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "clearKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "getClearKey", "()Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "clearKey$delegate", "Lkotlin/Lazy;", "isIgnoreUpdateForOneKeySpecial", "", "isOneKeySpecialMode", "keyList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "newLineKey", "getNewLineKey", "newLineKey$delegate", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "handleNormalTouch", "v", "event", "Landroid/view/MotionEvent;", "onClick", "", "Landroid/view/View;", "onCreate", "onLongClick", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSelectCandidate", "text", "", "id", "", "suffix", "onTouch", "onUpperSlide", "transparentBg", "transparent", "updateChildrenView", "updateEnterKey", "actionStr", "actionMode", "updatePendingInputData", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "lastPendingInputContent", "", "cursorIndex", "([Lcom/tencent/wxhld/info/PendingInput;Ljava/lang/CharSequence;I)V", "Companion", "plugin-hld_release"})
public final class S1ChineseT9Keyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, com.tencent.mm.plugin.hld.candidate.b
{
  public static final a DyO;
  private final kotlin.f DyI;
  private final kotlin.f DyJ;
  private final ArrayList<ImeKeyRelativeLayout> DyK;
  private b DyL;
  private boolean DyM;
  private boolean DyN;
  
  static
  {
    AppMethodBeat.i(209124);
    DyO = new a((byte)0);
    AppMethodBeat.o(209124);
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
    AppMethodBeat.i(209123);
    this.DyI = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.DyJ = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.DyK = new ArrayList();
    AppMethodBeat.o(209123);
  }
  
  private final void Uv(int paramInt)
  {
    AppMethodBeat.i(209115);
    ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)findViewById(paramInt);
    localImeKeyRelativeLayout.setPadding(localImeKeyRelativeLayout.getKeyMarginLeft(), localImeKeyRelativeLayout.getKeyMarginTop(), localImeKeyRelativeLayout.getKeyMarginRight(), localImeKeyRelativeLayout.getKeyMarginBottom());
    this.DyK.add(localImeKeyRelativeLayout);
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    p.j(localImeKeyRelativeLayout, "view");
    if (com.tencent.mm.plugin.hld.f.l.e(localImeKeyRelativeLayout))
    {
      localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
      AppMethodBeat.o(209115);
      return;
    }
    if (a(localImeKeyRelativeLayout)) {
      localImeKeyRelativeLayout.setOnLongClickListener((View.OnLongClickListener)this);
    }
    localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(209115);
  }
  
  private final ImeKeyRelativeLayout getClearKey()
  {
    AppMethodBeat.i(209104);
    ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)this.DyJ.getValue();
    AppMethodBeat.o(209104);
    return localImeKeyRelativeLayout;
  }
  
  private final ImeKeyRelativeLayout getNewLineKey()
  {
    AppMethodBeat.i(209103);
    ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)this.DyI.getValue();
    AppMethodBeat.o(209103);
    return localImeKeyRelativeLayout;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(209120);
    p.k(paramString1, "text");
    p.k(paramArrayOfByte, "id");
    super.a(paramString1, paramArrayOfByte, paramString2);
    this.DyM = false;
    AppMethodBeat.o(209120);
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
    AppMethodBeat.i(209106);
    super.b(paramc);
    paramc = getMKeyboardActionListener();
    if (paramc != null) {
      ((ImeVerticalScrollView)findViewById(a.f.t9_symbol_key_list)).setOnKeyboardActionListener(paramc);
    }
    ((ImeSboAndSybKeysScrollView)findViewById(a.f.t9_symbol_key_list)).onResume();
    paramc = n.DEn;
    n.a((com.tencent.mm.plugin.hld.candidate.b)this);
    AppMethodBeat.o(209106);
  }
  
  public final void eO(String paramString, int paramInt)
  {
    AppMethodBeat.i(209111);
    p.k(paramString, "actionStr");
    super.eO(paramString, paramInt);
    getNewLineKey().setVisibility(8);
    getClearKey().setVisibility(0);
    AppMethodBeat.o(209111);
  }
  
  protected final ImeKeyButton getActionKey()
  {
    AppMethodBeat.i(209110);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.t9_key_action);
    AppMethodBeat.o(209110);
    return localImeKeyButton;
  }
  
  public final c getKeyboardType()
  {
    return c.Dyl;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209109);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) != 2) {
        break label233;
      }
      switch (((ImeKeyRelativeLayout)paramView).getFunctionCode())
      {
      default: 
        localObject1 = getMKeyboardActionListener();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.hld.a.c)localObject1).Up(((ImeKeyRelativeLayout)paramView).getFunctionCode());
        }
        break;
      }
    }
    label233:
    while ((((ImeKeyRelativeLayout)paramView).getType() & 0x1) != 1) {
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
        com.tencent.mm.plugin.hld.model.k.ff(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(209109);
        return;
        this.DyM = false;
      }
    }
    localObject1 = ((ImeKeyRelativeLayout)paramView).getText();
    label296:
    Object localObject2;
    if (eDJ())
    {
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(209109);
        throw paramView;
      }
      localObject1 = ((String)localObject1).toUpperCase();
      p.j(localObject1, "(this as java.lang.String).toUpperCase()");
      localObject2 = this.DyL;
      if (localObject2 == null) {
        break label375;
      }
    }
    label375:
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
        AppMethodBeat.o(209109);
        throw paramView;
      }
      localObject1 = ((String)localObject1).toLowerCase();
      p.j(localObject1, "(this as java.lang.String).toLowerCase()");
      break label296;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(209105);
    super.onCreate();
    Uv(a.f.t9_key1);
    Uv(a.f.t9_key2);
    Uv(a.f.t9_key3);
    Uv(a.f.t9_key4);
    Uv(a.f.t9_key5);
    Uv(a.f.t9_key6);
    Uv(a.f.t9_key7);
    Uv(a.f.t9_key8);
    Uv(a.f.t9_key9);
    Uv(a.f.t9_key_number);
    Uv(a.f.t9_key_space);
    Uv(a.f.t9_key_exchange);
    Uv(a.f.t9_key_delete);
    Uv(a.f.t9_key_new_line);
    Uv(a.f.t9_key_clear);
    Uv(a.f.t9_key_action);
    AppMethodBeat.o(209105);
  }
  
  public final boolean onLongClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(209117);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "onLongClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      localObject1 = new ArrayList();
      Object localObject2 = ((ImeKeyRelativeLayout)paramView).getText();
      if (localObject2 == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(209117);
        throw paramView;
      }
      localObject2 = ((String)localObject2).toCharArray();
      p.j(localObject2, "(this as java.lang.String).toCharArray()");
      ((ArrayList)localObject1).add(((ImeKeyRelativeLayout)paramView).getSecondText());
      if (((ImeKeyRelativeLayout)paramView).getId() == a.f.t9_key1)
      {
        int j = localObject2.length;
        while (i < j)
        {
          String str = String.valueOf(localObject2[i]);
          if (str == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(209117);
            throw paramView;
          }
          str = str.toLowerCase();
          p.j(str, "(this as java.lang.String).toLowerCase()");
          ((ArrayList)localObject1).add(str);
          i += 1;
        }
      }
      localObject2 = com.tencent.mm.plugin.hld.model.f.DBL;
      localObject2 = (ImeKeyRelativeLayout)paramView;
      paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
      if (paramView == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.hld.model.f.a(3, (ArrayList)localObject1, (ImeKeyRelativeLayout)localObject2, paramView, this.DyL);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(209117);
      return true;
    }
    paramView = com.tencent.mm.plugin.hld.model.f.DBL;
    com.tencent.mm.plugin.hld.model.f.eDS();
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(209117);
    return false;
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(209107);
    super.onReset();
    ((ImeVerticalScrollView)findViewById(a.f.t9_symbol_key_list)).reset();
    ((ImeSboAndSybKeysScrollView)findViewById(a.f.t9_symbol_key_list)).reset();
    n localn = n.DEn;
    n.b((com.tencent.mm.plugin.hld.candidate.b)this);
    AppMethodBeat.o(209107);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209119);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      boolean bool;
      if (com.tencent.mm.plugin.hld.f.l.e((ImeKeyRelativeLayout)paramView))
      {
        bool = a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(106));
        AppMethodBeat.o(209119);
        return bool;
      }
      a((ImeKeyRelativeLayout)paramView, paramMotionEvent);
      Object localObject2 = (ImeKeyRelativeLayout)paramView;
      label93:
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
        com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "onTouch action " + paramView + ' ' + i + ' ' + j + ' ' + l + ' ' + paramMotionEvent);
        if (this.DyL == null) {
          break label432;
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
        AppMethodBeat.o(209119);
        throw paramView;
        paramView = null;
        break;
        localObject1 = Double.valueOf(0.0D);
        break label93;
      }
      label276:
      localObject1 = ((String)localObject1).toLowerCase();
      p.j(localObject1, "(this as java.lang.String).toLowerCase()");
      if (paramMotionEvent == null)
      {
        paramView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(209119);
        throw paramView;
      }
      Object localObject3 = paramMotionEvent.toLowerCase();
      p.j(localObject3, "(this as java.lang.String).toLowerCase()");
      if (!Util.isEqual((String)localObject1, (String)localObject3)) {
        if (paramView == null)
        {
          if (paramView != null) {
            break label542;
          }
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          localObject1 = new StringBuilder("lastKey:");
          localObject2 = this.DyL;
          if (localObject2 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", ((b)localObject2).Dyg + " currentKey:" + paramMotionEvent + " action:" + paramView);
          label415:
          break label444;
        }
      }
      label416:
      label432:
      label436:
      label440:
      label444:
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(209119);
            return false;
            if (paramView.intValue() != 5) {
              break;
            }
            if (paramView != null) {
              break label552;
            }
            if (paramView != null) {
              break label916;
            }
            if (paramView != null) {
              break label1454;
            }
          } while ((paramView == null) || (paramView.intValue() != 3));
          ((ImeKeyRelativeLayout)localObject2).setSelected(false);
          paramView = this.DyL;
          if (paramView != null)
          {
            paramView.Dyh = true;
            paramView = x.aazN;
          }
          paramView = com.tencent.mm.plugin.hld.model.f.DBL;
          com.tencent.mm.plugin.hld.model.f.eDS();
        } while ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2);
        paramMotionEvent = getMKeyboardActionListener();
      } while (paramMotionEvent == null);
      paramView = this.DyL;
      if (paramView != null) {}
      for (paramView = paramView.Dyg;; paramView = null)
      {
        paramMotionEvent.c(new com.tencent.mm.plugin.hld.a.g(paramView));
        paramView = x.aazN;
        break label416;
        label542:
        if (paramView.intValue() == 0) {
          break label432;
        }
        break;
        label552:
        if (paramView.intValue() != 0) {
          break label436;
        }
        paramView = i.DHq;
        i.d((ImeKeyRelativeLayout)localObject2);
        paramView = this.DyL;
        if (paramView != null) {
          if ((!paramView.Dyh) && (!Util.isNullOrNil(paramView.Dyg)))
          {
            localObject1 = (View)paramView.aFW.get();
            if (localObject1 != null)
            {
              p.j(localObject1, "view");
              ((View)localObject1).setSelected(false);
              if ((!(localObject1 instanceof ImeKeyRelativeLayout)) || (!a((ImeKeyRelativeLayout)localObject1))) {
                break label761;
              }
              localObject3 = getMKeyboardActionListener();
              if (localObject3 != null)
              {
                ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new com.tencent.mm.plugin.hld.a.g(paramView.Dyg, paramView.Dyi));
                localObject3 = x.aazN;
              }
              localObject3 = com.tencent.mm.plugin.hld.model.k.DDb;
              com.tencent.mm.plugin.hld.model.k.ff((View)localObject1);
            }
          }
        }
        for (;;)
        {
          localObject1 = x.aazN;
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "process no ACTION_UP input:" + paramView.Dyg);
          paramView = x.aazN;
          if (!eDJ()) {
            break label873;
          }
          if (paramMotionEvent != null) {
            break;
          }
          paramView = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209119);
          throw paramView;
          label761:
          onClick((View)localObject1);
        }
        paramView = paramMotionEvent.toUpperCase();
        p.j(paramView, "(this as java.lang.String).toUpperCase()");
        label782:
        this.DyL = new b(i, j, l, paramView, new WeakReference(localObject2), l, 16);
        ((ImeKeyRelativeLayout)localObject2).setSelected(true);
        if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2) {
          break label416;
        }
        paramMotionEvent = getMKeyboardActionListener();
        if (paramMotionEvent == null) {
          break label416;
        }
        paramView = this.DyL;
        if (paramView != null) {}
        for (paramView = paramView.Dyg;; paramView = null)
        {
          paramMotionEvent.a(new com.tencent.mm.plugin.hld.a.g(paramView));
          paramView = x.aazN;
          break;
          label873:
          if (paramMotionEvent == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(209119);
            throw paramView;
          }
          paramView = paramMotionEvent.toLowerCase();
          p.j(paramView, "(this as java.lang.String).toLowerCase()");
          break label782;
        }
        label916:
        if (paramView.intValue() != 2) {
          break label440;
        }
        paramView = this.DyL;
        if (paramView == null) {
          break label416;
        }
        paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
        paramMotionEvent = new StringBuilder("onTouch ");
        if ((l - paramView.time < 500L) && (Math.abs(j - paramView.y) > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height)))
        {
          bool = true;
          com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", bool + " diff:" + (l - paramView.time) + " yOffset:" + Math.abs(j - paramView.y) + " minHeight:" + com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height));
          int k = Math.abs(paramView.x - i);
          paramMotionEvent = com.tencent.mm.plugin.hld.f.k.DHH;
          if (k <= com.tencent.mm.plugin.hld.f.k.eGQ()) {
            break label1182;
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
                break label1177;
              }
            }
          }
        }
        label1177:
        for (paramView = paramView.Dyg;; paramView = null)
        {
          paramMotionEvent.c(new com.tencent.mm.plugin.hld.a.g(paramView));
          paramView = x.aazN;
          AppMethodBeat.o(209119);
          return true;
          bool = false;
          break;
        }
        label1182:
        if (((a((ImeKeyRelativeLayout)localObject2)) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key_space)) && (l - paramView.time < 500L) && (Math.abs(j - paramView.y) > com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_upper_slide_min_height)))
        {
          paramView = new int[2];
          ((ImeKeyRelativeLayout)localObject2).getLocationOnScreen(paramView);
          if ((i >= paramView[0]) && (i <= paramView[0] + ((ImeKeyRelativeLayout)localObject2).getMeasuredWidth()))
          {
            paramView = (View)localObject2;
            if ((paramView instanceof ImeKeyRelativeLayout))
            {
              paramMotionEvent = com.tencent.mm.plugin.hld.f.l.DHK;
              com.tencent.mm.plugin.hld.f.l.it("WxIme.S1ChineseT9Keyboard", "onUpperSlide:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
              paramMotionEvent = new ArrayList();
              paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getText());
              paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getSecondText());
              localObject1 = com.tencent.mm.plugin.hld.model.f.DBL;
              localObject1 = (ImeKeyRelativeLayout)paramView;
              paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
              if (paramView == null) {
                p.iCn();
              }
              com.tencent.mm.plugin.hld.model.f.a(2, paramMotionEvent, (ImeKeyRelativeLayout)localObject1, paramView, this.DyL);
            }
            for (;;)
            {
              AppMethodBeat.o(209119);
              return true;
              paramView = com.tencent.mm.plugin.hld.model.f.DBL;
              com.tencent.mm.plugin.hld.model.f.eDS();
            }
          }
        }
        paramView = x.aazN;
        break label416;
        label1454:
        if (paramView.intValue() != 1) {
          break label415;
        }
        ((ImeKeyRelativeLayout)localObject2).setSelected(false);
        paramView = this.DyL;
        if (paramView != null)
        {
          paramView.Dyh = true;
          paramView = x.aazN;
        }
        if ((this.DyM) && ((((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key1) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key2) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key3) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key4) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key5) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key6) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key7) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key8) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key9) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key_space)))
        {
          paramView = ((ImeKeyRelativeLayout)localObject2).getSecondText();
          paramMotionEvent = this.DyL;
          if (paramMotionEvent != null) {}
          for (paramView = new com.tencent.mm.plugin.hld.a.g(paramView, paramMotionEvent.Dyi);; paramView = new com.tencent.mm.plugin.hld.a.g(paramView))
          {
            paramMotionEvent = getMKeyboardActionListener();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.d(paramView);
              paramView = x.aazN;
            }
            paramView = com.tencent.mm.plugin.hld.model.f.DBL;
            com.tencent.mm.plugin.hld.model.f.eDS();
            paramView = com.tencent.mm.plugin.hld.model.k.DDb;
            com.tencent.mm.plugin.hld.model.k.ff((View)localObject2);
            break;
          }
        }
        if (a((ImeKeyRelativeLayout)localObject2))
        {
          if (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key1)
          {
            paramView = n.DEn;
            if (!n.eEE())
            {
              paramView = n.DEn;
              localObject1 = n.eEP();
              paramView = n.DEn;
              paramMotionEvent = ((Candidate)localObject1).text;
              p.j(paramMotionEvent, "candidate.text");
              localObject1 = ((Candidate)localObject1).id;
              p.j(localObject1, "candidate.id");
              n.a(paramView, paramMotionEvent, (byte[])localObject1, "", false, 0L, true, 8);
              paramView = com.tencent.mm.plugin.hld.model.k.DDb;
              com.tencent.mm.plugin.hld.model.k.hN(1, 0);
            }
            paramView = ((ImeKeyRelativeLayout)localObject2).getSecondText() + ((ImeKeyRelativeLayout)localObject2).getText();
            paramMotionEvent = this.DyL;
            if (paramMotionEvent != null) {}
            for (paramView = new com.tencent.mm.plugin.hld.a.g(paramView, paramMotionEvent.Dyi);; paramView = new com.tencent.mm.plugin.hld.a.g(paramView))
            {
              paramMotionEvent = getMKeyboardActionListener();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.d(paramView);
                paramView = x.aazN;
              }
              this.DyM = true;
              this.DyN = true;
              paramView = com.tencent.mm.plugin.hld.model.f.DBL;
              com.tencent.mm.plugin.hld.model.f.eDS();
              paramView = com.tencent.mm.plugin.hld.model.k.DDb;
              com.tencent.mm.plugin.hld.model.k.ff((View)localObject2);
              break;
            }
          }
          paramView = ((ImeKeyRelativeLayout)localObject2).getText();
          if (eDJ())
          {
            if (paramView == null)
            {
              paramView = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(209119);
              throw paramView;
            }
            paramView = paramView.toUpperCase();
            p.j(paramView, "(this as java.lang.String).toUpperCase()");
            label1940:
            paramMotionEvent = this.DyL;
            if (paramMotionEvent == null) {
              break label2023;
            }
          }
          label2023:
          for (paramView = new com.tencent.mm.plugin.hld.a.g(paramView, paramMotionEvent.Dyi);; paramView = new com.tencent.mm.plugin.hld.a.g(paramView))
          {
            paramMotionEvent = getMKeyboardActionListener();
            if (paramMotionEvent == null) {
              break;
            }
            paramMotionEvent.b(paramView);
            paramView = x.aazN;
            break;
            if (paramView == null)
            {
              paramView = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(209119);
              throw paramView;
            }
            paramView = paramView.toLowerCase();
            p.j(paramView, "(this as java.lang.String).toLowerCase()");
            break label1940;
          }
        }
        onClick((View)localObject2);
        break label416;
      }
    }
    AppMethodBeat.o(209119);
    return false;
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(209113);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(209113);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(209113);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImeKeyRelativeLayout>
  {
    b(S1ChineseT9Keyboard paramS1ChineseT9Keyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ImeKeyRelativeLayout>
  {
    c(S1ChineseT9Keyboard paramS1ChineseT9Keyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S1ChineseT9Keyboard
 * JD-Core Version:    0.7.0.1
 */