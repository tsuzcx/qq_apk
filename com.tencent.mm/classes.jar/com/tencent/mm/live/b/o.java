package com.tencent.mm.live.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ae;
import com.tencent.mm.kernel.c;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.f;
import com.tencent.mm.live.model.l.c;
import com.tencent.mm.live.model.u;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.k.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "changeToInputMode", "", "changeToPreviewMode", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends a
  implements com.tencent.mm.am.h
{
  public static final o.a nik;
  private Context context;
  private final b nfT;
  private final int nil;
  private final int nim;
  private final int nin;
  private final LinearLayout nio;
  private final LinearLayout nip;
  private final View niq;
  private final MMEditText nir;
  private final TextView nis;
  private final ImageView nit;
  private final TextView niu;
  private SmileyPanel niv;
  private int niw;
  private boolean nix;
  private int niy;
  private int niz;
  
  static
  {
    AppMethodBeat.i(247309);
    nik = new o.a((byte)0);
    AppMethodBeat.o(247309);
  }
  
  public o(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247117);
    this.nfT = paramb;
    this.nim = 1;
    this.nin = 2;
    this.nio = ((LinearLayout)paramViewGroup.findViewById(b.e.live_input_layout));
    this.nip = ((LinearLayout)paramViewGroup.findViewById(b.e.live_emoji_layout));
    this.niq = paramViewGroup.findViewById(b.e.live_input_parent);
    this.nir = ((MMEditText)paramViewGroup.findViewById(b.e.live_input_txt));
    this.nis = ((TextView)paramViewGroup.findViewById(b.e.live_send_btn));
    this.nit = ((ImageView)paramViewGroup.findViewById(b.e.live_input_emoji));
    this.niu = ((TextView)paramViewGroup.findViewById(b.e.live_click_cancel));
    paramb = ae.m(paramViewGroup.getContext(), false);
    kotlin.g.b.s.s(paramb, "getSmileyPanel(root.context, false)");
    this.niv = paramb;
    paramb = paramViewGroup.getContext();
    kotlin.g.b.s.s(paramb, "root.context");
    this.context = paramb;
    this.niy = this.nil;
    this.niy = this.nil;
    this.nit.setImageDrawable(bb.e(paramViewGroup.getContext().getResources().getDrawable(b.g.icons_filled_sticker), -1));
    this.nit.setOnClickListener(new o..ExternalSyntheticLambda3(this));
    paramb = new o..ExternalSyntheticLambda0(this);
    InputFilter localInputFilter = (InputFilter)new o.c(com.tencent.mm.ui.tools.g.a.afII);
    this.nir.setFilters(new InputFilter[] { paramb, localInputFilter });
    this.nir.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      private static final void a(o paramAnonymouso, ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(247331);
        kotlin.g.b.s.u(paramAnonymouso, "this$0");
        if (paramAnonymousValueAnimator == null) {}
        for (paramAnonymousValueAnimator = null; paramAnonymousValueAnimator == null; paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue())
        {
          paramAnonymouso = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(247331);
          throw paramAnonymouso;
        }
        float f = ((Integer)paramAnonymousValueAnimator).intValue();
        paramAnonymousValueAnimator = o.j(paramAnonymouso).getLayoutParams();
        paramAnonymousValueAnimator.width = kotlin.h.a.eH(f);
        o.j(paramAnonymouso).setLayoutParams(paramAnonymousValueAnimator);
        o.j(paramAnonymouso).setAlpha(f / o.i(paramAnonymouso));
        AppMethodBeat.o(247331);
      }
      
      private static final void b(o paramAnonymouso, ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(247336);
        kotlin.g.b.s.u(paramAnonymouso, "this$0");
        if (paramAnonymousValueAnimator == null) {}
        for (paramAnonymousValueAnimator = null; paramAnonymousValueAnimator == null; paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue())
        {
          paramAnonymouso = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(247336);
          throw paramAnonymouso;
        }
        float f = ((Integer)paramAnonymousValueAnimator).intValue();
        paramAnonymousValueAnimator = o.j(paramAnonymouso).getLayoutParams();
        paramAnonymousValueAnimator.width = kotlin.h.a.eH(f);
        o.j(paramAnonymouso).setLayoutParams(paramAnonymousValueAnimator);
        o.j(paramAnonymouso).setAlpha(f / o.i(paramAnonymouso));
        AppMethodBeat.o(247336);
      }
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(247360);
        if ((o.e(this.niA) == 0) || (o.e(this.niA) != this.niA.bjo().getHeight()))
        {
          o.a(this.niA, this.niA.bjo().getHeight());
          paramAnonymousEditable = new Bundle();
          paramAnonymousEditable.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", KeyBoardUtil.getKeyBordHeightPx(o.d(this.niA)) + this.niA.bjo().getHeight() + bf.bk(paramViewGroup.getContext()) + o.f(this.niA).getPaddingBottom());
          o.c(this.niA).statusChange(b.c.ndn, paramAnonymousEditable);
        }
        paramAnonymousEditable = o.b(this.niA).getText();
        int i;
        if ((paramAnonymousEditable != null) && (((CharSequence)paramAnonymousEditable).length() > 0))
        {
          i = 1;
          if (i == 0) {
            break label218;
          }
          paramAnonymousEditable = o.b(this.niA).getText();
          if ((paramAnonymousEditable == null) || (n.bp((CharSequence)paramAnonymousEditable))) {
            break label213;
          }
          i = 1;
          label185:
          if (i == 0) {
            break label218;
          }
        }
        label213:
        label218:
        for (boolean bool = true;; bool = false)
        {
          if (bool != o.g(this.niA)) {
            break label223;
          }
          AppMethodBeat.o(247360);
          return;
          i = 0;
          break;
          i = 0;
          break label185;
        }
        label223:
        o.a(this.niA, bool);
        if (o.g(this.niA))
        {
          paramAnonymousEditable = o.h(this.niA).getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(247360);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cd.a.br(paramViewGroup.getContext(), com.tencent.mm.live.b.c.Edge_1_5_A));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, o.i(this.niA) });
          paramAnonymousEditable.addUpdateListener(new o.1..ExternalSyntheticLambda1(this.niA));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new a(this.niA));
          paramAnonymousEditable.start();
          AppMethodBeat.o(247360);
          return;
        }
        paramAnonymousEditable = o.h(this.niA).getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(247360);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cd.a.br(paramViewGroup.getContext(), com.tencent.mm.live.b.c.Edge_2A));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { o.i(this.niA), 0 });
        paramAnonymousEditable.addUpdateListener(new o.1..ExternalSyntheticLambda0(this.niA));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this.niA));
        paramAnonymousEditable.start();
        AppMethodBeat.o(247360);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements Animator.AnimatorListener
      {
        a(o paramo) {}
        
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(246987);
          paramAnimator = o.j(this.niA).getLayoutParams();
          paramAnimator.width = o.i(this.niA);
          o.j(this.niA).setLayoutParams(paramAnimator);
          o.j(this.niA).setAlpha(1.0F);
          AppMethodBeat.o(246987);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(246980);
          o.j(this.niA).setVisibility(0);
          paramAnimator = o.j(this.niA).getLayoutParams();
          paramAnimator.width = o.i(this.niA);
          o.j(this.niA).setLayoutParams(paramAnimator);
          o.j(this.niA).setAlpha(1.0F);
          AppMethodBeat.o(246980);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(246994);
          o.j(this.niA).setVisibility(0);
          AppMethodBeat.o(246994);
        }
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class b
        implements Animator.AnimatorListener
      {
        b(o paramo) {}
        
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(246984);
          o.j(this.niA).setVisibility(8);
          AppMethodBeat.o(246984);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(246979);
          o.j(this.niA).setVisibility(8);
          AppMethodBeat.o(246979);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(246991);
          o.j(this.niA).setVisibility(0);
          AppMethodBeat.o(246991);
        }
      }
    });
    if (isLandscape())
    {
      paramb = this.niq.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247117);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bf.bk(paramViewGroup.getContext()));
    }
    this.nis.setOnClickListener(new o..ExternalSyntheticLambda1(this));
    this.nio.setOnClickListener(o..ExternalSyntheticLambda4.INSTANCE);
    this.niu.setOnClickListener(new o..ExternalSyntheticLambda2(this));
    this.niv.setEntranceScene(ChatFooterPanel.XYy);
    this.niv.iKh();
    this.niv.iKi();
    this.niv.JA(false);
    this.niv.setVisibility(4);
    this.niv.onResume();
    this.niv.setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    AppMethodBeat.o(247117);
  }
  
  private static final CharSequence a(o paramo, CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(247184);
    kotlin.g.b.s.u(paramo, "this$0");
    paramo.nir.getText();
    paramo = paramCharSequence.toString();
    paramCharSequence = (CharSequence)"\n";
    if (paramo == null)
    {
      paramo = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(247184);
      throw paramo;
    }
    if (paramo.contentEquals(paramCharSequence))
    {
      paramo = (CharSequence)"";
      AppMethodBeat.o(247184);
      return paramo;
    }
    AppMethodBeat.o(247184);
    return null;
  }
  
  private static final void a(o paramo, View paramView)
  {
    AppMethodBeat.i(247164);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramo);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramo, "this$0");
    int i;
    if (paramo.niy != paramo.nin)
    {
      i = 1;
      if (i != 0) {
        break label159;
      }
      paramo.bjm();
      ((MMActivity)paramo.context).showVKB();
      label94:
      if (i == 0) {
        break label247;
      }
      paramo.nit.setImageDrawable(bb.e(paramo.mJe.getContext().getResources().getDrawable(b.g.icons_filled_keyboard), -1));
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247164);
      return;
      i = 0;
      break;
      label159:
      paramo.niv.setVisibility(0);
      paramo.nit.setImageDrawable(bb.e(paramo.mJe.getContext().getResources().getDrawable(b.g.icons_filled_keyboard), -1));
      paramo.niy = paramo.nin;
      paramo.niv.setAlpha(0.0F);
      paramo.niv.animate().alpha(1.0F).setDuration(220L).setListener(null).start();
      ((MMActivity)paramo.context).hideVKB();
      break label94;
      label247:
      paramo.nit.setImageDrawable(bb.e(paramo.mJe.getContext().getResources().getDrawable(b.g.icons_filled_sticker), -1));
    }
  }
  
  private static final void b(o paramo, View paramView)
  {
    AppMethodBeat.i(247210);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramo);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramo, "this$0");
    paramView = u.mZl;
    if (u.bio())
    {
      paramView = new com.tencent.mm.ui.widget.a.g.a(paramo.context);
      paramView.Xdm = true;
      paramView.bf((CharSequence)paramo.context.getResources().getString(b.h.live_comment_tip_foreigner)).aEX(b.h.app_i_know).b(o..ExternalSyntheticLambda5.INSTANCE).show();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247210);
      return;
      if (paramo.nir.getText() != null)
      {
        paramo.bjm();
        ((MMActivity)paramo.context).hideVKB();
        paramo.bjn();
        paramView = paramo.nir.getText();
        paramo.nir.setText(null);
        localObject = com.tencent.mm.live.model.o.mZb;
        paramView = paramView.toString();
        localObject = l.c.mYi;
        com.tencent.mm.live.model.o.aB(paramView, l.c.bhp());
        b.b.a(paramo.nfT, b.c.ncJ);
        if (paramo.nfT.getLiveRole() == 0) {
          f.bkE();
        }
      }
    }
  }
  
  private final void bjm()
  {
    AppMethodBeat.i(247133);
    if (this.niy != this.nin)
    {
      AppMethodBeat.o(247133);
      return;
    }
    this.nit.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(b.g.icons_filled_sticker), -1));
    this.niv.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(247133);
  }
  
  private final void bjn()
  {
    AppMethodBeat.i(247144);
    this.niy = this.nil;
    this.mJe.setVisibility(4);
    this.nir.clearFocus();
    Object localObject = this.mJe.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(247144);
      throw ((Throwable)localObject);
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(this.nir.getWindowToken(), 0);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_IS_ENTERING_COMMENT", false);
    this.nfT.statusChange(b.c.ncO, (Bundle)localObject);
    AppMethodBeat.o(247144);
  }
  
  private static final void c(o paramo, View paramView)
  {
    AppMethodBeat.i(247225);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramo);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramo, "this$0");
    paramo.bjm();
    ((MMActivity)paramo.context).hideVKB();
    paramo.bjn();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247225);
  }
  
  private static final void dh(View paramView)
  {
    AppMethodBeat.i(247219);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247219);
  }
  
  private static final void p(boolean paramBoolean, String paramString) {}
  
  private final void tQ(int paramInt)
  {
    AppMethodBeat.i(247156);
    Object localObject;
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.mJe.getContext() instanceof Activity))
    {
      localObject = this.niq.getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(247156);
        throw ((Throwable)localObject);
      }
      localLayoutParams = (LinearLayout.LayoutParams)localObject;
      if (isLandscape()) {
        break label213;
      }
      localLayoutParams.bottomMargin = (bf.bk(this.context) + paramInt);
      this.niq.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(-1, paramInt);
      if (isLandscape()) {
        break label221;
      }
      ((LinearLayout.LayoutParams)localObject).bottomMargin = bf.bk(this.context);
    }
    for (;;)
    {
      this.niv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.niv.getParent() == null) {
        this.nip.addView((View)this.niv, (ViewGroup.LayoutParams)localObject);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", bjo().getHeight() + paramInt + bf.bk(this.mJe.getContext()) + this.nio.getPaddingBottom());
      this.nfT.statusChange(b.c.ndn, (Bundle)localObject);
      AppMethodBeat.o(247156);
      return;
      label213:
      localLayoutParams.bottomMargin = paramInt;
      break;
      label221:
      ((LinearLayout.LayoutParams)localObject).setMarginEnd(bf.bk(this.context));
    }
  }
  
  public final View bjo()
  {
    AppMethodBeat.i(247359);
    View localView = this.niq;
    kotlin.g.b.s.s(localView, "inputParent");
    AppMethodBeat.o(247359);
    return localView;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(247357);
    super.keyboardChange(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      if (this.niy == this.nim)
      {
        this.niy = this.nil;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.niv.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        tQ(0);
        AppMethodBeat.o(247357);
      }
    }
    else
    {
      this.niy = this.nim;
      bjm();
      tQ(paramInt);
    }
    AppMethodBeat.o(247357);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(247364);
    super.mount();
    int i = (int)StaticLayout.getDesiredWidth(this.nis.getText(), this.nis.getPaint());
    this.niw = k.qu(bd.bs(this.context, com.tencent.mm.live.b.c.Edge_7A), i + this.nis.getPaddingStart() + this.nis.getPaddingEnd());
    com.tencent.mm.kernel.h.baD().mCm.a(904, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247364);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(247374);
    if (this.mJe.getVisibility() == 0)
    {
      if (this.niy == this.nin)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.niv.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        this.niy = this.nil;
        tQ(0);
      }
      for (;;)
      {
        AppMethodBeat.o(247374);
        return true;
        bjn();
      }
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(247374);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(247380);
    if (((paramp instanceof com.tencent.mm.live.model.a.s)) && (paramInt2 == -100065))
    {
      paramString = u.mZl;
      u.bip();
      d.uiThread((kotlin.g.a.a)new o.e(this));
    }
    AppMethodBeat.o(247380);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(247349);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (o.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label189:
    for (;;)
    {
      AppMethodBeat.o(247349);
      return;
      tO(8);
      AppMethodBeat.o(247349);
      return;
      AppMethodBeat.o(247349);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
      for (;;)
      {
        if (i == 0) {
          break label189;
        }
        this.mJe.setVisibility(0);
        this.nit.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(b.g.icons_filled_sticker), -1));
        this.nir.requestFocus();
        paramc = (InputMethodManager)this.mJe.getContext().getSystemService("input_method");
        if (paramc == null) {
          break;
        }
        paramc.showSoftInput((View)this.nir, 0);
        break;
        i = 0;
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247368);
    super.unMount();
    com.tencent.mm.kernel.h.baD().mCm.b(904, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(247368);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(o paramo) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(247061);
      o.a(this.niA).setAlpha(1.0F);
      o.a(this.niA).setVisibility(4);
      AppMethodBeat.o(247061);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements ChatFooterPanel.a
  {
    f(o paramo) {}
    
    public final void aWL() {}
    
    public final void aWM()
    {
      AppMethodBeat.i(247152);
      Object localObject = o.b(this.niA);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = o.b(this.niA);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
        }
      }
      AppMethodBeat.o(247152);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(247141);
      MMEditText localMMEditText = o.b(this.niA);
      if (localMMEditText != null) {
        localMMEditText.bDt(paramString);
      }
      if (o.c(this.niA).getLiveRole() == 0) {
        f.bkF();
      }
      AppMethodBeat.o(247141);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.o
 * JD-Core Version:    0.7.0.1
 */