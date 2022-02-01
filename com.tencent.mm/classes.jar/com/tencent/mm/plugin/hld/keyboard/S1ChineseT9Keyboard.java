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
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.f;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mm/plugin/hld/candidate/IPendingInputDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "clearKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "getClearKey", "()Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "clearKey$delegate", "Lkotlin/Lazy;", "isIgnoreUpdateForOneKeySpecial", "", "isOneKeySpecialMode", "keyList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "newLineKey", "getNewLineKey", "newLineKey$delegate", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "handleNormalTouch", "v", "event", "Landroid/view/MotionEvent;", "onClick", "", "Landroid/view/View;", "onCreate", "onLongClick", "onReset", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onSelectCandidate", "text", "", "id", "", "suffix", "onTouch", "onUpperSlide", "transparentBg", "transparent", "updateChildrenView", "updateEnterKey", "actionStr", "actionMode", "updatePendingInputData", "pendingInputs", "", "Lcom/tencent/wxhld/info/PendingInput;", "lastPendingInputContent", "", "cursorIndex", "([Lcom/tencent/wxhld/info/PendingInput;Ljava/lang/CharSequence;I)V", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S1ChineseT9Keyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, com.tencent.mm.plugin.hld.candidate.b
{
  public static final S1ChineseT9Keyboard.a JrM;
  private final j JrN;
  private final j JrO;
  private final ArrayList<ImeKeyRelativeLayout> JrP;
  private b JrQ;
  private boolean JrR;
  private boolean JrS;
  
  static
  {
    AppMethodBeat.i(312979);
    JrM = new S1ChineseT9Keyboard.a((byte)0);
    AppMethodBeat.o(312979);
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
    AppMethodBeat.i(312966);
    this.JrN = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.JrO = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.JrP = new ArrayList();
    AppMethodBeat.o(312966);
  }
  
  private final void Ys(int paramInt)
  {
    AppMethodBeat.i(312972);
    ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)findViewById(paramInt);
    localImeKeyRelativeLayout.setPadding(localImeKeyRelativeLayout.getKeyMarginLeft(), localImeKeyRelativeLayout.getKeyMarginTop(), localImeKeyRelativeLayout.getKeyMarginRight(), localImeKeyRelativeLayout.getKeyMarginBottom());
    this.JrP.add(localImeKeyRelativeLayout);
    l locall = l.JyV;
    s.s(localImeKeyRelativeLayout, "view");
    if (l.e(localImeKeyRelativeLayout))
    {
      localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
      AppMethodBeat.o(312972);
      return;
    }
    if (a(localImeKeyRelativeLayout)) {
      localImeKeyRelativeLayout.setOnLongClickListener((View.OnLongClickListener)this);
    }
    localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(312972);
  }
  
  private final ImeKeyRelativeLayout getClearKey()
  {
    AppMethodBeat.i(312949);
    Object localObject = this.JrO.getValue();
    s.s(localObject, "<get-clearKey>(...)");
    localObject = (ImeKeyRelativeLayout)localObject;
    AppMethodBeat.o(312949);
    return localObject;
  }
  
  private final ImeKeyRelativeLayout getNewLineKey()
  {
    AppMethodBeat.i(312943);
    Object localObject = this.JrN.getValue();
    s.s(localObject, "<get-newLineKey>(...)");
    localObject = (ImeKeyRelativeLayout)localObject;
    AppMethodBeat.o(312943);
    return localObject;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(313094);
    s.u(paramString1, "text");
    s.u(paramArrayOfByte, "id");
    super.a(paramString1, paramArrayOfByte, paramString2);
    this.JrR = false;
    AppMethodBeat.o(313094);
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
    AppMethodBeat.i(312990);
    super.b(paramc);
    paramc = getMKeyboardActionListener();
    if (paramc != null) {
      ((ImeVerticalScrollView)findViewById(a.f.t9_symbol_key_list)).setOnKeyboardActionListener(paramc);
    }
    ((ImeSboAndSybKeysScrollView)findViewById(a.f.t9_symbol_key_list)).onResume();
    paramc = n.JvW;
    n.a((com.tencent.mm.plugin.hld.candidate.b)this);
    AppMethodBeat.o(312990);
  }
  
  public final void fG(String paramString, int paramInt)
  {
    AppMethodBeat.i(313026);
    s.u(paramString, "actionStr");
    super.fG(paramString, paramInt);
    getNewLineKey().setVisibility(8);
    getClearKey().setVisibility(0);
    AppMethodBeat.o(313026);
  }
  
  protected final ImeKeyButton getActionKey()
  {
    AppMethodBeat.i(313018);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.t9_key_action);
    AppMethodBeat.o(313018);
    return localImeKeyButton;
  }
  
  public final c getKeyboardType()
  {
    return c.Jrp;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(313011);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = l.JyV;
      l.jC("WxIme.S1ChineseT9Keyboard", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) != 2) {
        break label233;
      }
      switch (((ImeKeyRelativeLayout)paramView).getFunctionCode())
      {
      default: 
        localObject1 = getMKeyboardActionListener();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.hld.a.c)localObject1).Yl(((ImeKeyRelativeLayout)paramView).getFunctionCode());
        }
        break;
      }
    }
    label233:
    while ((((ImeKeyRelativeLayout)paramView).getType() & 0x1) != 1) {
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.hR(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(313011);
        return;
        this.JrR = false;
      }
    }
    localObject1 = ((ImeKeyRelativeLayout)paramView).getText();
    Object localObject2;
    if (fLL())
    {
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313011);
        throw paramView;
      }
      localObject2 = ((String)localObject1).toUpperCase();
      s.s(localObject2, "(this as java.lang.String).toUpperCase()");
      label296:
      localObject1 = this.JrQ;
      if (localObject1 != null) {
        break label377;
      }
      localObject1 = null;
      label307:
      if (localObject1 != null) {
        break label393;
      }
      localObject1 = new g((String)localObject2);
    }
    label393:
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
        AppMethodBeat.o(313011);
        throw paramView;
      }
      localObject2 = ((String)localObject1).toLowerCase();
      s.s(localObject2, "(this as java.lang.String).toLowerCase()");
      break label296;
      label377:
      localObject1 = new g((String)localObject2, ((b)localObject1).Jrm);
      break label307;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(312985);
    super.onCreate();
    Ys(a.f.t9_key1);
    Ys(a.f.t9_key2);
    Ys(a.f.t9_key3);
    Ys(a.f.t9_key4);
    Ys(a.f.t9_key5);
    Ys(a.f.t9_key6);
    Ys(a.f.t9_key7);
    Ys(a.f.t9_key8);
    Ys(a.f.t9_key9);
    Ys(a.f.t9_key_number);
    Ys(a.f.t9_key_space);
    Ys(a.f.t9_key_exchange);
    Ys(a.f.t9_key_delete);
    Ys(a.f.t9_key_new_line);
    Ys(a.f.t9_key_clear);
    Ys(a.f.t9_key_action);
    AppMethodBeat.o(312985);
  }
  
  public final boolean onLongClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(313043);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = l.JyV;
      l.jC("WxIme.S1ChineseT9Keyboard", "onLongClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      localObject1 = new ArrayList();
      Object localObject2 = ((ImeKeyRelativeLayout)paramView).getText();
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313043);
        throw paramView;
      }
      localObject2 = ((String)localObject2).toCharArray();
      s.s(localObject2, "(this as java.lang.String).toCharArray()");
      ((ArrayList)localObject1).add(((ImeKeyRelativeLayout)paramView).getSecondText());
      if (((ImeKeyRelativeLayout)paramView).getId() == a.f.t9_key1)
      {
        int j = localObject2.length;
        while (i < j)
        {
          char c = localObject2[i];
          i += 1;
          String str = String.valueOf(c);
          if (str == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(313043);
            throw paramView;
          }
          str = str.toLowerCase();
          s.s(str, "(this as java.lang.String).toLowerCase()");
          ((ArrayList)localObject1).add(str);
        }
      }
      localObject2 = f.JuH;
      localObject2 = (ImeKeyRelativeLayout)paramView;
      paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
      s.checkNotNull(paramView);
      f.a(3, (ArrayList)localObject1, (ImeKeyRelativeLayout)localObject2, paramView, this.JrQ);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(313043);
      return true;
    }
    paramView = f.JuH;
    f.fLV();
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/keyboard/S1ChineseT9Keyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(313043);
    return false;
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(312993);
    super.onReset();
    ((ImeVerticalScrollView)findViewById(a.f.t9_symbol_key_list)).reset();
    ((ImeSboAndSybKeysScrollView)findViewById(a.f.t9_symbol_key_list)).reset();
    n localn = n.JvW;
    n.b((com.tencent.mm.plugin.hld.candidate.b)this);
    AppMethodBeat.o(312993);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313089);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      Object localObject1 = l.JyV;
      boolean bool;
      if (l.e((ImeKeyRelativeLayout)paramView))
      {
        bool = a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(106));
        AppMethodBeat.o(313089);
        return bool;
      }
      a((ImeKeyRelativeLayout)paramView, paramMotionEvent);
      Object localObject2 = (ImeKeyRelativeLayout)paramView;
      label84:
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
        l.jC("WxIme.S1ChineseT9Keyboard", "onTouch action " + paramView + ' ' + i + ' ' + j + ' ' + l + ' ' + paramMotionEvent);
        if (this.JrQ == null) {
          break label426;
        }
        localObject1 = this.JrQ;
        s.checkNotNull(localObject1);
        localObject1 = ((b)localObject1).Jrk;
        if (localObject1 != null) {
          break label273;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313089);
        throw paramView;
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        label250:
        localObject1 = Float.valueOf(paramMotionEvent.getRawX());
        break label84;
      }
      label273:
      localObject1 = ((String)localObject1).toLowerCase();
      s.s(localObject1, "(this as java.lang.String).toLowerCase()");
      if (paramMotionEvent == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313089);
        throw paramView;
      }
      Object localObject3 = paramMotionEvent.toLowerCase();
      s.s(localObject3, "(this as java.lang.String).toLowerCase()");
      if (!Util.isEqual((String)localObject1, (String)localObject3)) {
        if (paramView == null)
        {
          if (paramView != null) {
            break label537;
          }
          localObject1 = l.JyV;
          localObject1 = new StringBuilder("lastKey:");
          localObject2 = this.JrQ;
          s.checkNotNull(localObject2);
          l.jC("WxIme.S1ChineseT9Keyboard", ((b)localObject2).Jrk + " currentKey:" + paramMotionEvent + " action:" + paramView);
          label409:
          break label438;
        }
      }
      label410:
      label426:
      label430:
      label434:
      label438:
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(313089);
            return false;
            if (paramView.intValue() != 5) {
              break;
            }
            if (paramView != null) {
              break label547;
            }
            if (paramView != null) {
              break label903;
            }
            if (paramView != null) {
              break label1428;
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
          paramView = f.JuH;
          f.fLV();
        } while ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2);
        paramMotionEvent = getMKeyboardActionListener();
      } while (paramMotionEvent == null);
      paramView = this.JrQ;
      if (paramView == null) {}
      for (paramView = null;; paramView = paramView.Jrk)
      {
        paramMotionEvent.c(new g(paramView));
        paramView = ah.aiuX;
        break label410;
        label537:
        if (paramView.intValue() == 0) {
          break label426;
        }
        break;
        label547:
        if (paramView.intValue() != 0) {
          break label430;
        }
        paramView = i.JyA;
        i.d((ImeKeyRelativeLayout)localObject2);
        paramView = this.JrQ;
        if (paramView != null) {
          if ((!paramView.Jrl) && (!Util.isNullOrNil(paramView.Jrk)))
          {
            localObject1 = (View)paramView.viewRef.get();
            if (localObject1 != null)
            {
              ((View)localObject1).setSelected(false);
              if ((!(localObject1 instanceof ImeKeyRelativeLayout)) || (!a((ImeKeyRelativeLayout)localObject1))) {
                break label748;
              }
              localObject3 = getMKeyboardActionListener();
              if (localObject3 != null)
              {
                ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new g(paramView.Jrk, paramView.Jrm));
                localObject3 = ah.aiuX;
              }
              localObject3 = com.tencent.mm.plugin.hld.model.k.JvH;
              com.tencent.mm.plugin.hld.model.k.hR((View)localObject1);
            }
          }
        }
        for (;;)
        {
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
          localObject1 = l.JyV;
          l.jC("WxIme.S1ChineseT9Keyboard", s.X("process no ACTION_UP input:", paramView.Jrk));
          paramView = ah.aiuX;
          paramView = ah.aiuX;
          if (!fLL()) {
            break label857;
          }
          if (paramMotionEvent != null) {
            break;
          }
          paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313089);
          throw paramView;
          label748:
          onClick((View)localObject1);
        }
        paramView = paramMotionEvent.toUpperCase();
        s.s(paramView, "(this as java.lang.String).toUpperCase()");
        label769:
        this.JrQ = new b(i, j, l, paramView, new WeakReference(localObject2), l, 16);
        ((ImeKeyRelativeLayout)localObject2).setSelected(true);
        if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2) {
          break label410;
        }
        paramMotionEvent = getMKeyboardActionListener();
        if (paramMotionEvent == null) {
          break label410;
        }
        paramView = this.JrQ;
        if (paramView == null) {}
        for (paramView = null;; paramView = paramView.Jrk)
        {
          paramMotionEvent.a(new g(paramView));
          paramView = ah.aiuX;
          break;
          label857:
          if (paramMotionEvent == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(313089);
            throw paramView;
          }
          paramView = paramMotionEvent.toLowerCase();
          s.s(paramView, "(this as java.lang.String).toLowerCase()");
          break label769;
        }
        label903:
        if (paramView.intValue() != 2) {
          break label434;
        }
        paramView = this.JrQ;
        if (paramView == null) {
          break label410;
        }
        paramMotionEvent = l.JyV;
        paramMotionEvent = new StringBuilder("onTouch ");
        if ((l - paramView.time < 500L) && (Math.abs(j - paramView.y) > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height))) {}
        for (bool = true;; bool = false)
        {
          l.jC("WxIme.S1ChineseT9Keyboard", bool + " diff:" + (l - paramView.time) + " yOffset:" + Math.abs(j - paramView.y) + " minHeight:" + com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height));
          int k = Math.abs(paramView.x - i);
          paramMotionEvent = com.tencent.mm.plugin.hld.f.k.JyF;
          if (k <= com.tencent.mm.plugin.hld.f.k.fOz()) {
            break;
          }
          paramMotionEvent = com.tencent.mm.plugin.hld.e.b.JqP;
          paramMotionEvent = (View)localObject2;
          localObject1 = ((ImeKeyRelativeLayout)localObject2).getInsideView();
          s.checkNotNull(localObject1);
          com.tencent.mm.plugin.hld.e.b.a(paramMotionEvent, (View)localObject1, this.JrQ, i);
          if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) != 2)
          {
            paramMotionEvent = getMKeyboardActionListener();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.c(new g(paramView.Jrk));
              paramView = ah.aiuX;
            }
          }
          AppMethodBeat.o(313089);
          return true;
        }
        if (((a((ImeKeyRelativeLayout)localObject2)) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key_space)) && (l - paramView.time < 500L) && (Math.abs(j - paramView.y) > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)))
        {
          paramView = new int[2];
          ((ImeKeyRelativeLayout)localObject2).getLocationOnScreen(paramView);
          if ((i >= paramView[0]) && (i <= paramView[0] + ((ImeKeyRelativeLayout)localObject2).getMeasuredWidth()))
          {
            paramView = (View)localObject2;
            if ((paramView instanceof ImeKeyRelativeLayout))
            {
              paramMotionEvent = l.JyV;
              l.jC("WxIme.S1ChineseT9Keyboard", "onUpperSlide:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
              paramMotionEvent = new ArrayList();
              paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getText());
              paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getSecondText());
              localObject1 = f.JuH;
              localObject1 = (ImeKeyRelativeLayout)paramView;
              paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
              s.checkNotNull(paramView);
              f.a(2, paramMotionEvent, (ImeKeyRelativeLayout)localObject1, paramView, this.JrQ);
            }
            for (;;)
            {
              AppMethodBeat.o(313089);
              return true;
              paramView = f.JuH;
              f.fLV();
            }
          }
        }
        paramView = ah.aiuX;
        paramView = ah.aiuX;
        break label410;
        label1428:
        if (paramView.intValue() != 1) {
          break label409;
        }
        ((ImeKeyRelativeLayout)localObject2).setSelected(false);
        paramView = this.JrQ;
        if (paramView != null)
        {
          paramView.Jrl = true;
          paramView = ah.aiuX;
          paramView = ah.aiuX;
        }
        if ((this.JrR) && ((((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key1) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key2) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key3) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key4) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key5) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key6) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key7) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key8) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key9) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key_space)))
        {
          localObject1 = ((ImeKeyRelativeLayout)localObject2).getSecondText();
          paramView = this.JrQ;
          if (paramView == null) {}
          for (paramView = null;; paramView = new g((String)localObject1, paramView.Jrm))
          {
            paramMotionEvent = paramView;
            if (paramView == null) {
              paramMotionEvent = new g((String)localObject1);
            }
            paramView = getMKeyboardActionListener();
            if (paramView != null)
            {
              paramView.d(paramMotionEvent);
              paramView = ah.aiuX;
            }
            paramView = f.JuH;
            f.fLV();
            paramView = com.tencent.mm.plugin.hld.model.k.JvH;
            com.tencent.mm.plugin.hld.model.k.hR((View)localObject2);
            break;
          }
        }
        if (a((ImeKeyRelativeLayout)localObject2))
        {
          if (((ImeKeyRelativeLayout)localObject2).getId() == a.f.t9_key1)
          {
            paramView = n.JvW;
            if (!n.fMH())
            {
              paramView = n.JvW;
              localObject1 = n.fMS();
              paramView = n.JvW;
              paramMotionEvent = ((Candidate)localObject1).text;
              s.s(paramMotionEvent, "candidate.text");
              localObject1 = ((Candidate)localObject1).id;
              s.s(localObject1, "candidate.id");
              n.a(paramView, paramMotionEvent, (byte[])localObject1, "", false, 0L, true, 8);
              paramView = com.tencent.mm.plugin.hld.model.k.JvH;
              com.tencent.mm.plugin.hld.model.k.jr(1, 0);
            }
            localObject1 = s.X(((ImeKeyRelativeLayout)localObject2).getSecondText(), ((ImeKeyRelativeLayout)localObject2).getText());
            paramView = this.JrQ;
            if (paramView == null) {}
            for (paramView = null;; paramView = new g((String)localObject1, paramView.Jrm))
            {
              paramMotionEvent = paramView;
              if (paramView == null) {
                paramMotionEvent = new g((String)localObject1);
              }
              paramView = getMKeyboardActionListener();
              if (paramView != null)
              {
                paramView.d(paramMotionEvent);
                paramView = ah.aiuX;
              }
              this.JrR = true;
              this.JrS = true;
              paramView = f.JuH;
              f.fLV();
              paramView = com.tencent.mm.plugin.hld.model.k.JvH;
              com.tencent.mm.plugin.hld.model.k.hR((View)localObject2);
              break;
            }
          }
          paramView = ((ImeKeyRelativeLayout)localObject2).getText();
          if (fLL())
          {
            if (paramView == null)
            {
              paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(313089);
              throw paramView;
            }
            paramMotionEvent = paramView.toUpperCase();
            s.s(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
            label1927:
            paramView = this.JrQ;
            if (paramView != null) {
              break label2012;
            }
            paramView = null;
            label1938:
            if (paramView != null) {
              break label2028;
            }
            paramView = new g(paramMotionEvent);
          }
          label2012:
          label2028:
          for (;;)
          {
            paramMotionEvent = getMKeyboardActionListener();
            if (paramMotionEvent == null) {
              break;
            }
            paramMotionEvent.b(paramView);
            paramView = ah.aiuX;
            break;
            if (paramView == null)
            {
              paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(313089);
              throw paramView;
            }
            paramMotionEvent = paramView.toLowerCase();
            s.s(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
            break label1927;
            paramView = new g(paramMotionEvent, paramView.Jrm);
            break label1938;
          }
        }
        onClick((View)localObject2);
        break label410;
      }
    }
    AppMethodBeat.o(313089);
    return false;
  }
  
  public final void wS(boolean paramBoolean)
  {
    AppMethodBeat.i(313033);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(313033);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(313033);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImeKeyRelativeLayout>
  {
    b(S1ChineseT9Keyboard paramS1ChineseT9Keyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
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