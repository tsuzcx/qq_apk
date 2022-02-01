package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.live.b.o.c;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.cgi.x.a;
import com.tencent.mm.plugin.finder.live.model.cgi.l.a;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.s.ar;
import com.tencent.mm.plugin.finder.report.live.s.ay;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "atContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "commentFailContent", "", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "getCommentPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "setCommentPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;)V", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "textLimitView", "addSelfComment", "", "content", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "changeToInputMode", "atName", "changeToPreviewMode", "notify", "checkTextLimit", "dealWithErrCode", "errType", "errCode", "realNameUrl", "doScreenClear", "clear", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "resendFailComment", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "Companion", "plugin-finder_release"})
public final class ah
  extends d
{
  public static final a uqT;
  public v commentPlugin;
  private Context context;
  private final com.tencent.mm.live.c.b hOp;
  private final int hQI;
  private final int hQJ;
  private final int hQK;
  private final LinearLayout hQL;
  private final LinearLayout hQM;
  private final View hQN;
  private final MMEditText hQO;
  private final TextView hQP;
  private final ImageView hQQ;
  private final TextView hQR;
  private SmileyPanel hQS;
  private int hQT;
  private boolean hQU;
  private int hQV;
  private int hQW;
  private final TextView uqQ;
  public String uqR;
  public avn uqS;
  
  static
  {
    AppMethodBeat.i(246797);
    uqT = new a((byte)0);
    AppMethodBeat.o(246797);
  }
  
  public ah(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246796);
    this.hOp = paramb;
    this.hQJ = 1;
    this.hQK = 2;
    this.hQL = ((LinearLayout)paramViewGroup.findViewById(2131303408));
    this.hQM = ((LinearLayout)paramViewGroup.findViewById(2131303383));
    this.hQN = paramViewGroup.findViewById(2131303410);
    this.hQO = ((MMEditText)paramViewGroup.findViewById(2131303412));
    this.hQP = ((TextView)paramViewGroup.findViewById(2131303555));
    this.hQQ = ((ImageView)paramViewGroup.findViewById(2131303405));
    this.hQR = ((TextView)paramViewGroup.findViewById(2131303359));
    this.uqQ = ((TextView)paramViewGroup.findViewById(2131303409));
    paramb = ad.l(paramViewGroup.getContext(), false);
    p.g(paramb, "SmileyPanelFactory.getSm…anel(root.context, false)");
    this.hQS = paramb;
    paramb = paramViewGroup.getContext();
    p.g(paramb, "root.context");
    this.context = paramb;
    this.hQV = this.hQI;
    this.uqR = "";
    this.hQV = this.hQI;
    paramb = this.hQQ;
    Object localObject = paramViewGroup.getContext();
    p.g(localObject, "root.context");
    paramb.setImageDrawable(ar.e(((Context)localObject).getResources().getDrawable(2131690683), -1));
    this.hQQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246754);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ah.g(this.uqU) != ah.h(this.uqU)) {}
        for (boolean bool = true;; bool = false)
        {
          ah.a(this.uqU, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(246754);
          return;
        }
      }
    });
    paramb = (InputFilter)h.uqZ;
    localObject = (InputFilter)new i(f.a.Qui);
    MMEditText localMMEditText = this.hQO;
    p.g(localMMEditText, "inputEt");
    localMMEditText.setFilters(new InputFilter[] { paramb, localObject });
    this.hQO.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(246763);
        ah.i(this.uqU);
        int i;
        if ((ah.j(this.uqU) == 0) || (ah.j(this.uqU) != this.uqU.aHB().getHeight()))
        {
          ah.a(this.uqU, this.uqU.aHB().getHeight());
          paramAnonymousEditable = new Bundle();
          i = KeyBoardUtil.getKeyBordHeightPx(ah.d(this.uqU));
          int j = this.uqU.aHB().getHeight();
          int k = au.aD(paramViewGroup.getContext());
          LinearLayout localLinearLayout = ah.k(this.uqU);
          p.g(localLinearLayout, "inputLayout");
          paramAnonymousEditable.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + j + k + localLinearLayout.getPaddingBottom());
          ah.b(this.uqU).statusChange(b.c.hMD, paramAnonymousEditable);
        }
        paramAnonymousEditable = ah.f(this.uqU);
        p.g(paramAnonymousEditable, "inputEt");
        paramAnonymousEditable = paramAnonymousEditable.getText();
        if (paramAnonymousEditable != null) {
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label272;
            }
            paramAnonymousEditable = ah.f(this.uqU);
            p.g(paramAnonymousEditable, "inputEt");
            paramAnonymousEditable = paramAnonymousEditable.getText();
            if (paramAnonymousEditable == null) {
              break label267;
            }
            if (n.aL((CharSequence)paramAnonymousEditable)) {
              break label262;
            }
            i = 1;
            label227:
            if (i == 0) {
              break label272;
            }
          }
        }
        label262:
        label267:
        label272:
        for (boolean bool = true;; bool = false)
        {
          if (bool != ah.l(this.uqU)) {
            break label278;
          }
          AppMethodBeat.o(246763);
          return;
          i = 0;
          break;
          i = 0;
          break;
          i = 0;
          break label227;
          i = 0;
          break label227;
        }
        label278:
        ah.b(this.uqU, bool);
        if (ah.l(this.uqU))
        {
          paramAnonymousEditable = ah.m(this.uqU);
          p.g(paramAnonymousEditable, "inputEmoji");
          paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(246763);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cb.a.aG(paramViewGroup.getContext(), 2131165289));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, ah.n(this.uqU) });
          paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this));
          paramAnonymousEditable.start();
          AppMethodBeat.o(246763);
          return;
        }
        paramAnonymousEditable = ah.m(this.uqU);
        p.g(paramAnonymousEditable, "inputEmoji");
        paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(246763);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cb.a.aG(paramViewGroup.getContext(), 2131165296));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { ah.n(this.uqU), 0 });
        paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new d(this));
        paramAnonymousEditable.start();
        AppMethodBeat.o(246763);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class a
        implements ValueAnimator.AnimatorUpdateListener
      {
        a(ah.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(246755);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(246755);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = ah.o(this.uqV.uqU);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = kotlin.h.a.cR(f);
          TextView localTextView = ah.o(this.uqV.uqU);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = ah.o(this.uqV.uqU);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / ah.n(this.uqV.uqU));
          AppMethodBeat.o(246755);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
      public static final class b
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(246757);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = ah.n(this.uqV.uqU);
          TextView localTextView = ah.o(this.uqV.uqU);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(246757);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(246756);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = ah.n(this.uqV.uqU);
          TextView localTextView = ah.o(this.uqV.uqU);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(246756);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(246758);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(246758);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class c
        implements ValueAnimator.AnimatorUpdateListener
      {
        c(ah.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(246759);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(246759);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = ah.o(this.uqV.uqU);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = kotlin.h.a.cR(f);
          TextView localTextView = ah.o(this.uqV.uqU);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = ah.o(this.uqV.uqU);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / ah.n(this.uqV.uqU));
          AppMethodBeat.o(246759);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
      public static final class d
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(246761);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(246761);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(246760);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(246760);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(246762);
          paramAnimator = ah.o(this.uqV.uqU);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(246762);
        }
      }
    });
    if (isLandscape())
    {
      paramb = this.hQN;
      p.g(paramb, "inputParent");
      paramb = paramb.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(246796);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(au.aD(paramViewGroup.getContext()));
    }
    this.hQP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246766);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = ah.f(this.uqU);
        p.g(paramAnonymousView, "inputEt");
        Object localObject2;
        Object localObject3;
        if (paramAnonymousView.getText() != null)
        {
          ah.p(this.uqU);
          paramAnonymousView = ah.d(this.uqU);
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(246766);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          paramAnonymousView = ah.f(this.uqU);
          p.g(paramAnonymousView, "inputEt");
          paramAnonymousView = paramAnonymousView.getText();
          if (paramAnonymousView != null)
          {
            localObject1 = paramAnonymousView.toString();
            paramAnonymousView = (View)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramAnonymousView = "";
          }
          localObject1 = ah.f(this.uqU);
          p.g(localObject1, "inputEt");
          ((MMEditText)localObject1).setText(null);
          localObject1 = y.vXH;
          paramAnonymousView = y.awt(paramAnonymousView);
          localObject1 = (CharSequence)paramAnonymousView;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (int i = 1; i != 0; i = 0)
          {
            paramAnonymousView = com.tencent.mm.plugin.finder.utils.m.vVH;
            com.tencent.mm.plugin.finder.utils.m.hd("Finder.LiveInputPlugin", "输入的内容为空");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(246766);
            return;
          }
          localObject1 = ah.q(this.uqU);
          if (localObject1 == null) {
            break label387;
          }
          localObject2 = com.tencent.mm.plugin.finder.report.live.m.vli;
          localObject2 = paramAnonymousView.toString();
          p.h(localObject2, "replyContent");
          localObject3 = new i();
          ((i)localObject3).h("content", localObject2);
          com.tencent.mm.plugin.finder.report.live.m.a(s.ar.vry, ((i)localObject3).toString());
          com.tencent.mm.plugin.finder.report.live.m.vkA += 1;
          localObject2 = com.tencent.mm.plugin.finder.cgi.x.ttF;
          localObject1 = x.a.a((avn)localObject1, paramAnonymousView.toString());
          new com.tencent.mm.plugin.finder.cgi.x((aut)localObject1, this.uqU.getLiveData(), (r)new a(paramAnonymousView, this)).aYI();
          paramAnonymousView = com.tencent.mm.plugin.finder.utils.m.vVH;
          com.tencent.mm.plugin.finder.utils.m.a((aut)localObject1, this.uqU.getLiveData());
          b.b.a(ah.b(this.uqU), b.c.hMb);
        }
        for (;;)
        {
          ah.a(this.uqU);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(246766);
          return;
          label387:
          localObject1 = o.ujN;
          localObject1 = o.getFinderLiveAssistant();
          if (localObject1 != null)
          {
            localObject2 = paramAnonymousView.toString();
            localObject3 = o.c.hGH;
            ((s)localObject1).a((String)localObject2, o.c.aFn(), (l.a)new b(paramAnonymousView, this));
          }
          ah.b(this.uqU, paramAnonymousView.toString());
          b.b.a(ah.b(this.uqU), b.c.hMb);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$1$1$1", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$$special$$inlined$let$lambda$1"})
      static final class a
        extends q
        implements r<Integer, Integer, String, ban, kotlin.x>
      {
        a(String paramString, ah.3 param3)
        {
          super();
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$1$2$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$$special$$inlined$run$lambda$1"})
      public static final class b
        implements l.a
      {
        b(String paramString, ah.3 param3) {}
        
        public final void a(int paramInt1, int paramInt2, String paramString, bap parambap)
        {
          AppMethodBeat.i(246765);
          p.h(parambap, "resp");
          ah.a(jdField_this.uqU, paramInt1, paramInt2, this.uqW.toString(), parambap.HIt);
          if ((ah.b(jdField_this.uqU).getLiveRole() == 0) && (paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.a(s.ay.vsK, this.uqW.toString());
          }
          AppMethodBeat.o(246765);
        }
      }
    });
    this.hQL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246767);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ah.p(this.uqU);
        paramAnonymousView = ah.d(this.uqU);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(246767);
          throw paramAnonymousView;
        }
        ((MMActivity)paramAnonymousView).hideVKB();
        ah.a(this.uqU);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246767);
      }
    });
    this.hQS.setEntranceScene(ChatFooterPanel.KbO);
    this.hQS.goD();
    this.hQS.goE();
    this.hQS.zN(false);
    this.hQS.setVisibility(4);
    this.hQS.onResume();
    this.hQS.setOnTextOperationListener((ChatFooterPanel.a)new k(this));
    AppMethodBeat.o(246796);
  }
  
  private final void aHz()
  {
    AppMethodBeat.i(246785);
    if (this.hQV != this.hQK)
    {
      AppMethodBeat.o(246785);
      return;
    }
    ImageView localImageView = this.hQQ;
    Context localContext = this.hwr.getContext();
    p.g(localContext, "root.context");
    localImageView.setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690683), -1));
    this.hQS.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new j(this)).start();
    AppMethodBeat.o(246785);
  }
  
  private final void nu(boolean paramBoolean)
  {
    AppMethodBeat.i(246786);
    this.hQV = this.hQI;
    this.hwr.setVisibility(4);
    this.hQO.clearFocus();
    Object localObject = this.hwr.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(246786);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.hQO;
    p.g(localMMEditText, "inputEt");
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localMMEditText.getWindowToken(), 0);
    nv(false);
    if (paramBoolean) {
      this.hwr.post((Runnable)new e(this));
    }
    AppMethodBeat.o(246786);
  }
  
  private final void nv(boolean paramBoolean)
  {
    AppMethodBeat.i(246788);
    getLiveData().uDR = paramBoolean;
    com.tencent.mm.live.c.b localb = this.hOp;
    b.c localc = b.c.hNl;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", getLiveData().uDR);
    localb.statusChange(localc, localBundle);
    AppMethodBeat.o(246788);
  }
  
  private final void ri(int paramInt)
  {
    AppMethodBeat.i(246791);
    Object localObject1;
    Object localObject2;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    View localView;
    if ((this.hwr.getContext() instanceof Activity))
    {
      localObject1 = this.hQN;
      p.g(localObject1, "inputParent");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(246791);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject1;
      if (!isLandscape()) {}
      for (((LinearLayout.LayoutParams)localObject2).bottomMargin = (au.aD(this.context) + paramInt);; ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt)
      {
        localObject2 = this.hQN;
        p.g(localObject2, "inputParent");
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.commentPlugin;
        if (localObject1 == null) {
          break label247;
        }
        localObject2 = ((com.tencent.mm.live.c.a)localObject1).hwr.getLayoutParams();
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(246791);
        throw ((Throwable)localObject1);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)localObject2;
      if (isLandscape()) {
        break label400;
      }
      i = au.aD(this.context);
      localView = this.hQN;
      p.g(localView, "inputParent");
      localLayoutParams.bottomMargin = (i + paramInt + localView.getHeight() + this.context.getResources().getDimensionPixelOffset(2131165296) * 2);
      ((com.tencent.mm.live.c.a)localObject1).hwr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      label247:
      localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
      if (isLandscape()) {
        break label445;
      }
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = au.aD(this.context);
    }
    for (;;)
    {
      this.hQS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.hQS.getParent() == null) {
        this.hQM.addView((View)this.hQS, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = new Bundle();
      i = aHB().getHeight();
      int j = au.aD(this.hwr.getContext());
      localObject2 = this.hQL;
      p.g(localObject2, "inputLayout");
      ((Bundle)localObject1).putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + paramInt + j + ((LinearLayout)localObject2).getPaddingBottom());
      this.hOp.statusChange(b.c.hMD, (Bundle)localObject1);
      AppMethodBeat.o(246791);
      return;
      label400:
      localView = this.hQN;
      p.g(localView, "inputParent");
      localLayoutParams.bottomMargin = (localView.getHeight() + paramInt + this.context.getResources().getDimensionPixelOffset(2131165296) * 2);
      break;
      label445:
      ((LinearLayout.LayoutParams)localObject1).setMarginEnd(au.aD(this.context));
    }
  }
  
  public final View aHB()
  {
    AppMethodBeat.i(246792);
    View localView = this.hQN;
    p.g(localView, "inputParent");
    AppMethodBeat.o(246792);
    return localView;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(246790);
    super.keyboardChange(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      if (this.hQV == this.hQJ)
      {
        this.hQV = this.hQI;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.hQS.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        ri(0);
        AppMethodBeat.o(246790);
      }
    }
    else
    {
      this.hQV = this.hQJ;
      aHz();
      ri(paramInt);
    }
    AppMethodBeat.o(246790);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(246793);
    super.mount();
    Object localObject = this.hQP;
    p.g(localObject, "sendBtn");
    localObject = ((TextView)localObject).getText();
    TextView localTextView = this.hQP;
    p.g(localTextView, "sendBtn");
    int i = (int)StaticLayout.getDesiredWidth((CharSequence)localObject, localTextView.getPaint());
    int j = at.aH(this.context, 2131165310);
    localObject = this.hQP;
    p.g(localObject, "sendBtn");
    int k = ((TextView)localObject).getPaddingStart();
    localObject = this.hQP;
    p.g(localObject, "sendBtn");
    this.hQT = j.mZ(j, i + k + ((TextView)localObject).getPaddingEnd());
    AppMethodBeat.o(246793);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(246795);
    if (this.hwr.getVisibility() == 0)
    {
      if (this.hQV == this.hQK)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.hQS.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        this.hQV = this.hQI;
        ri(0);
      }
      for (;;)
      {
        AppMethodBeat.o(246795);
        return true;
        nu(true);
      }
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(246795);
    return bool;
  }
  
  public final void rf(int paramInt) {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246789);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ai.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246789);
      return;
      rg(8);
      Util.hideVKB((View)this.hQO);
      AppMethodBeat.o(246789);
      return;
      boolean bool;
      label142:
      Object localObject2;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT");
        if (!bool) {
          break label610;
        }
        if (paramBundle == null) {
          break label470;
        }
        localObject1 = paramBundle.getByteArray("PARAM_ENTER_COMMENT_AT_NAME");
        if (localObject1 == null) {
          break label470;
        }
        paramc = new avn();
        paramc.parseFrom((byte[])localObject1);
        this.hwr.setVisibility(0);
        localObject1 = this.hQQ;
        localObject2 = this.hwr.getContext();
        p.g(localObject2, "root.context");
        ((ImageView)localObject1).setImageDrawable(ar.e(((Context)localObject2).getResources().getDrawable(2131690683), -1));
        if (paramBundle != null)
        {
          localObject2 = paramBundle.getString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG");
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        p.g(localObject1, "extraMsg?.getString(ILiv…IVE_AUTO_INPUT_MSG) ?: \"\"");
        if (paramBundle != null) {
          paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT", false);
        }
        nv(true);
        localObject2 = new c(this);
        paramBundle = new d(this);
        if (paramc == null) {
          break label486;
        }
        if (this.uqS != null)
        {
          paramBundle = this.uqS;
          if (paramBundle == null) {
            break label475;
          }
          paramBundle = paramBundle.contact;
          if (paramBundle == null) {
            break label475;
          }
          paramBundle = paramBundle.nickname;
          label299:
          localObject1 = paramc.contact;
          if (localObject1 == null) {
            break label480;
          }
        }
      }
      label470:
      label475:
      label480:
      for (Object localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
      {
        if ((p.j(paramBundle, localObject1) ^ true))
        {
          localObject3 = this.context.getResources();
          paramBundle = paramc.contact;
          if (paramBundle != null)
          {
            localObject1 = paramBundle.nickname;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramBundle = "";
          }
          paramBundle = ((Resources)localObject3).getString(2131760171, new Object[] { paramBundle });
          p.g(paramBundle, "context.resources.getStr…it.contact?.nickname?:\"\")");
          localObject1 = this.hQO;
          p.g(localObject1, "inputEt");
          ((MMEditText)localObject1).setHint((CharSequence)paramBundle);
          paramBundle = this.hQO;
          p.g(paramBundle, "inputEt");
          paramBundle.setText(null);
        }
        this.uqS = paramc;
        this.hQO.postDelayed((Runnable)new b(this, (c)localObject2), 100L);
        AppMethodBeat.o(246789);
        return;
        bool = false;
        break;
        paramc = null;
        break label142;
        paramBundle = null;
        break label299;
      }
      label486:
      paramc = (ah)this;
      Object localObject3 = (CharSequence)localObject1;
      int i;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label595;
        }
        localObject1 = paramc.hQO;
        p.g(localObject1, "inputEt");
        localObject1 = (CharSequence)((MMEditText)localObject1).getText();
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label590;
        }
        i = 1;
        label560:
        if (i != 0) {
          paramBundle.invoke();
        }
      }
      for (;;)
      {
        paramc.uqS = null;
        ((c)localObject2).invoke();
        AppMethodBeat.o(246789);
        return;
        i = 0;
        break;
        label590:
        i = 0;
        break label560;
        label595:
        paramc.hQO.setText((CharSequence)localObject1);
      }
      label610:
      nu(false);
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246794);
    super.unMount();
    AppMethodBeat.o(246794);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$Companion;", "", "()V", "AT_PREFFIX", "", "AT_SUFFIX", "MAX_COMMENT_TEXT_NUM", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$changeToInputMode$3$1"})
  static final class b
    implements Runnable
  {
    b(ah paramah, ah.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(246769);
      this.uqY.invoke();
      AppMethodBeat.o(246769);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"showKVB", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    c(ah paramah)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(246771);
      ah.f(this.uqU).requestFocus();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.uqU.hwr.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)ah.f(this.uqU), 0);
        AppMethodBeat.o(246771);
        return;
      }
      AppMethodBeat.o(246771);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"clearEditStatus", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(ah paramah)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(246773);
      MMEditText localMMEditText = ah.f(this.uqU);
      p.g(localMMEditText, "inputEt");
      localMMEditText.setHint((CharSequence)ah.d(this.uqU).getResources().getString(2131759906));
      localMMEditText = ah.f(this.uqU);
      p.g(localMMEditText, "inputEt");
      localMMEditText.setText(null);
      AppMethodBeat.o(246773);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ah paramah) {}
    
    public final void run()
    {
      AppMethodBeat.i(246774);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_IS_ENTERING_COMMENT", false);
      ah.b(this.uqU).statusChange(b.c.hMd, localBundle);
      AppMethodBeat.o(246774);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$checkTextLimit$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
  public static final class f
    implements c.a
  {
    public final void Tw(String paramString)
    {
      AppMethodBeat.i(246777);
      int i = f.dp(120, paramString);
      if (i > 5)
      {
        paramString = ah.c(this.uqU);
        p.g(paramString, "textLimitView");
        paramString.setVisibility(8);
        AppMethodBeat.o(246777);
        return;
      }
      paramString = ah.c(this.uqU);
      p.g(paramString, "textLimitView");
      paramString.setText((CharSequence)String.valueOf(i));
      ah.c(this.uqU).setTextColor(ah.d(this.uqU).getResources().getColor(2131099677));
      paramString = ah.c(this.uqU);
      p.g(paramString, "textLimitView");
      paramString.setVisibility(0);
      AppMethodBeat.o(246777);
    }
    
    public final void Tx(String paramString)
    {
      AppMethodBeat.i(246775);
      paramString = ah.c(this.uqU);
      p.g(paramString, "textLimitView");
      paramString.setVisibility(8);
      AppMethodBeat.o(246775);
    }
    
    public final void dv(String paramString)
    {
      AppMethodBeat.i(246776);
      TextView localTextView = ah.c(this.uqU);
      p.g(localTextView, "textLimitView");
      localTextView.setText((CharSequence)String.valueOf(f.dp(120, paramString)));
      ah.c(this.uqU).setTextColor(ah.d(this.uqU).getResources().getColor(2131099818));
      paramString = ah.c(this.uqU);
      p.g(paramString, "textLimitView");
      paramString.setVisibility(0);
      AppMethodBeat.o(246776);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    g(ah paramah, int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "source", "", "kotlin.jvm.PlatformType", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class h
    implements InputFilter
  {
    public static final h uqZ;
    
    static
    {
      AppMethodBeat.i(246779);
      uqZ = new h();
      AppMethodBeat.o(246779);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
  public static final class i
    extends f
  {
    i(f.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(246780);
      CharSequence localCharSequence;
      if (paramSpanned != null)
      {
        paramInt2 = paramSpanned.length();
        if (paramInt2 <= paramInt3) {
          break label189;
        }
        if (paramSpanned == null) {
          break label183;
        }
        localCharSequence = paramSpanned.subSequence(0, paramInt3);
        label41:
        paramInt2 = f.a(String.valueOf(localCharSequence), f.a.Qui);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label204;
        }
      }
      label183:
      label189:
      label204:
      for (paramInt3 = f.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), f.a.Qui);; paramInt3 = 0)
      {
        paramInt4 = f.a(String.valueOf(paramCharSequence), f.a.Qui);
        int i = f.bnR(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
          break label228;
        }
        paramInt2 = j.mZ(120 - paramInt2 - paramInt3 - i, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label210;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(246780);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = f.a(String.valueOf(paramSpanned), f.a.Qui);
        break label53;
      }
      label210:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(246780);
      return paramCharSequence;
      label228:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(246780);
        return paramCharSequence;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(246781);
      ah.e(this.uqU).setAlpha(1.0F);
      ah.e(this.uqU).setVisibility(4);
      AppMethodBeat.o(246781);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class k
    implements ChatFooterPanel.a
  {
    public final void aHC()
    {
      AppMethodBeat.i(246783);
      Object localObject = ah.f(this.uqU);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = ah.f(this.uqU);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(246783);
          return;
        }
      }
      AppMethodBeat.o(246783);
    }
    
    public final void aHD() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(246782);
      MMEditText localMMEditText = ah.f(this.uqU);
      if (localMMEditText != null)
      {
        if (f.a(localMMEditText.getText() + paramString, f.a.Qui) <= 120) {
          localMMEditText.bol(paramString);
        }
        AppMethodBeat.o(246782);
        return;
      }
      AppMethodBeat.o(246782);
    }
    
    public final void eP(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ah
 * JD-Core Version:    0.7.0.1
 */