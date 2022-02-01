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
import android.text.TextPaint;
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
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.cgi.n.a;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.cgi.u.a;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bf;
import com.tencent.mm.plugin.finder.live.report.s.bm;
import com.tencent.mm.plugin.finder.live.viewmodel.data.j;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "atContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "commentFailContent", "", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "getCommentPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "setCommentPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;)V", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "needNotifySendMsgResult", "", "notifySendResultSessionId", "", "getNotifySendResultSessionId", "()J", "setNotifySendResultSessionId", "(J)V", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "textLimitView", "addSelfComment", "", "content", "changeToInputMode", "atName", "extraMsg", "Landroid/os/Bundle;", "changeToPreviewMode", "notify", "checkTextLimit", "dealWithErrCode", "errType", "errCode", "realNameUrl", "doScreenClear", "clear", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "notifySendResult", "sessionId", "onBackPress", "onHideSmileyPanel", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "resendFailComment", "setVisible", "visible", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "Companion", "plugin-finder_release"})
public final class bg
  extends d
{
  public static final a ysL;
  private Context context;
  private final com.tencent.mm.live.c.b kCL;
  private final int kFf;
  private final int kFg;
  private final int kFh;
  private final LinearLayout kFi;
  private final LinearLayout kFj;
  private final View kFk;
  private final MMEditText kFl;
  private final TextView kFm;
  private final ImageView kFn;
  private final TextView kFo;
  private SmileyPanel kFp;
  private int kFq;
  private boolean kFr;
  private int kFs;
  private int kFt;
  private final TextView ysF;
  public aq ysG;
  public String ysH;
  public aza ysI;
  private boolean ysJ;
  long ysK;
  
  static
  {
    AppMethodBeat.i(281879);
    ysL = new a((byte)0);
    AppMethodBeat.o(281879);
  }
  
  public bg(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(281878);
    this.kCL = paramb;
    this.kFg = 1;
    this.kFh = 2;
    this.kFi = ((LinearLayout)paramViewGroup.findViewById(b.f.live_input_layout));
    this.kFj = ((LinearLayout)paramViewGroup.findViewById(b.f.live_emoji_layout));
    this.kFk = paramViewGroup.findViewById(b.f.live_input_parent);
    this.kFl = ((MMEditText)paramViewGroup.findViewById(b.f.live_input_txt));
    this.kFm = ((TextView)paramViewGroup.findViewById(b.f.live_send_btn));
    this.kFn = ((ImageView)paramViewGroup.findViewById(b.f.live_input_emoji));
    this.kFo = ((TextView)paramViewGroup.findViewById(b.f.live_click_cancel));
    this.ysF = ((TextView)paramViewGroup.findViewById(b.f.live_input_limit));
    paramb = ad.m(paramViewGroup.getContext(), false);
    p.j(paramb, "SmileyPanelFactory.getSm…anel(root.context, false)");
    this.kFp = paramb;
    paramb = paramViewGroup.getContext();
    p.j(paramb, "root.context");
    this.context = paramb;
    this.kFs = this.kFf;
    this.ysH = "";
    this.kFs = this.kFf;
    paramb = this.kFn;
    Object localObject = paramViewGroup.getContext();
    p.j(localObject, "root.context");
    paramb.setImageDrawable(au.e(((Context)localObject).getResources().getDrawable(b.i.icons_filled_sticker), -1));
    this.kFn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(292295);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (bg.g(this.ysM) != bg.h(this.ysM)) {}
        for (boolean bool = true;; bool = false)
        {
          bg.a(this.ysM, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(292295);
          return;
        }
      }
    });
    paramb = (InputFilter)h.ysU;
    localObject = (InputFilter)new i(g.a.XSu);
    MMEditText localMMEditText = this.kFl;
    p.j(localMMEditText, "inputEt");
    localMMEditText.setFilters(new InputFilter[] { paramb, localObject });
    this.kFl.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(285332);
        bg.i(this.ysM);
        int i;
        if ((bg.j(this.ysM) == 0) || (bg.j(this.ysM) != this.ysM.aPB().getHeight()))
        {
          bg.a(this.ysM, this.ysM.aPB().getHeight());
          paramAnonymousEditable = new Bundle();
          i = KeyBoardUtil.getKeyBordHeightPx(bg.d(this.ysM));
          int j = this.ysM.aPB().getHeight();
          int k = ax.aB(paramViewGroup.getContext());
          LinearLayout localLinearLayout = bg.k(this.ysM);
          p.j(localLinearLayout, "inputLayout");
          paramAnonymousEditable.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + j + k + localLinearLayout.getPaddingBottom());
          bg.b(this.ysM).statusChange(com.tencent.mm.live.c.b.c.kzX, paramAnonymousEditable);
        }
        paramAnonymousEditable = bg.f(this.ysM);
        p.j(paramAnonymousEditable, "inputEt");
        paramAnonymousEditable = paramAnonymousEditable.getText();
        if (paramAnonymousEditable != null) {
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label272;
            }
            paramAnonymousEditable = bg.f(this.ysM);
            p.j(paramAnonymousEditable, "inputEt");
            paramAnonymousEditable = paramAnonymousEditable.getText();
            if (paramAnonymousEditable == null) {
              break label267;
            }
            if (kotlin.n.n.ba((CharSequence)paramAnonymousEditable)) {
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
          if (bool != bg.l(this.ysM)) {
            break label278;
          }
          AppMethodBeat.o(285332);
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
        bg.b(this.ysM, bool);
        if (bg.l(this.ysM))
        {
          paramAnonymousEditable = bg.m(this.ysM);
          p.j(paramAnonymousEditable, "inputEmoji");
          paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(285332);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.ci.a.aY(paramViewGroup.getContext(), b.d.Edge_1_5_A));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, bg.n(this.ysM) });
          paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this));
          paramAnonymousEditable.start();
          AppMethodBeat.o(285332);
          return;
        }
        paramAnonymousEditable = bg.m(this.ysM);
        p.j(paramAnonymousEditable, "inputEmoji");
        paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(285332);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.ci.a.aY(paramViewGroup.getContext(), b.d.Edge_2A));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { bg.n(this.ysM), 0 });
        paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new d(this));
        paramAnonymousEditable.start();
        AppMethodBeat.o(285332);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class a
        implements ValueAnimator.AnimatorUpdateListener
      {
        a(bg.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(221538);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(221538);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = bg.o(this.ysN.ysM);
          p.j(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = kotlin.h.a.dm(f);
          TextView localTextView = bg.o(this.ysN.ysM);
          p.j(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = bg.o(this.ysN.ysM);
          p.j(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / bg.n(this.ysN.ysM));
          AppMethodBeat.o(221538);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
      public static final class b
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(265622);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = bg.n(this.ysN.ysM);
          TextView localTextView = bg.o(this.ysN.ysM);
          p.j(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(265622);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(265621);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = bg.n(this.ysN.ysM);
          TextView localTextView = bg.o(this.ysN.ysM);
          p.j(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(265621);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(265623);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(265623);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class c
        implements ValueAnimator.AnimatorUpdateListener
      {
        c(bg.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(271703);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(271703);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = bg.o(this.ysN.ysM);
          p.j(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = kotlin.h.a.dm(f);
          TextView localTextView = bg.o(this.ysN.ysM);
          p.j(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = bg.o(this.ysN.ysM);
          p.j(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / bg.n(this.ysN.ysM));
          AppMethodBeat.o(271703);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
      public static final class d
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(287947);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(287947);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(287946);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(287946);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(287948);
          paramAnimator = bg.o(this.ysN.ysM);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(287948);
        }
      }
    });
    if (isLandscape())
    {
      paramb = this.kFk;
      p.j(paramb, "inputParent");
      paramb = paramb.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(281878);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ax.aB(paramViewGroup.getContext()));
    }
    this.kFm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int j = 0;
        AppMethodBeat.i(278736);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = bg.f(this.ysM);
        p.j(paramAnonymousView, "inputEt");
        int i;
        final long l;
        final boolean bool;
        if (paramAnonymousView.getText() != null)
        {
          bg.p(this.ysM);
          paramAnonymousView = bg.d(this.ysM);
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(278736);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          paramAnonymousView = bg.f(this.ysM);
          p.j(paramAnonymousView, "inputEt");
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
          localObject1 = bg.f(this.ysM);
          p.j(localObject1, "inputEt");
          ((MMEditText)localObject1).setText(null);
          localObject1 = aj.AGc;
          paramAnonymousView = aj.aFP(paramAnonymousView);
          localObject1 = (CharSequence)paramAnonymousView;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1; i != 0; i = 0)
          {
            paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            com.tencent.mm.plugin.finder.live.utils.a.ha("Finder.LiveInputPlugin", "输入的内容为空");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(278736);
            return;
          }
          l = this.ysM.ysK;
          bool = bg.q(this.ysM);
          localObject1 = bg.r(this.ysM);
          if (localObject1 == null) {
            break label554;
          }
          Object localObject2 = m.yCt;
          localObject2 = paramAnonymousView.toString();
          p.k(localObject2, "replyContent");
          Object localObject3 = new com.tencent.mm.ad.i();
          ((com.tencent.mm.ad.i)localObject3).g("content", localObject2);
          m.a(s.bf.yLo, ((com.tencent.mm.ad.i)localObject3).toString());
          m.yBI += 1;
          localObject2 = com.tencent.mm.plugin.finder.live.cgi.n.xYm;
          localObject1 = n.a.a((aza)localObject1, paramAnonymousView.toString());
          localObject2 = new bid();
          localObject3 = ah.yhC;
          localObject3 = ah.dwh();
          if (localObject3 == null) {
            break label549;
          }
          localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject3).xVT;
          if (localObject3 == null) {
            break label549;
          }
          i = ((j)localObject3).xkX;
          ((bid)localObject2).fGo = i;
          localObject3 = ah.yhC;
          localObject3 = ah.dwh();
          i = j;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject3).xVT;
            i = j;
            if (localObject3 != null) {
              i = ((j)localObject3).xkX;
            }
          }
          ((bid)localObject2).xkX = i;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ysM.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgh.add(((axe)localObject1).SJs);
          new com.tencent.mm.plugin.finder.live.cgi.n((axe)localObject1, this.ysM.getBuContext(), (bid)localObject2, (r)new a(paramAnonymousView, bool, l, this)).bhW();
          paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          com.tencent.mm.plugin.finder.live.utils.a.a((axe)localObject1, this.ysM.getBuContext());
          b.b.a(bg.b(this.ysM), com.tencent.mm.live.c.b.c.kzt);
        }
        for (;;)
        {
          bg.a(this.ysM);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(278736);
          return;
          label549:
          i = 0;
          break;
          label554:
          localObject1 = bg.getFinderLiveAssistant();
          if (localObject1 != null) {
            ((an)localObject1).a(paramAnonymousView.toString(), 1, (u.a)new b(paramAnonymousView, bool, l, this));
          }
          bg.b(this.ysM, paramAnonymousView.toString());
          b.b.a(bg.b(this.ysM), com.tencent.mm.live.c.b.c.kzt);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$1$1$1", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$$special$$inlined$let$lambda$1"})
      static final class a
        extends q
        implements r<Integer, Integer, String, bgy, x>
      {
        a(String paramString, boolean paramBoolean, long paramLong, bg.3 param3)
        {
          super();
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$1$2$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$$special$$inlined$run$lambda$1"})
      public static final class b
        implements u.a
      {
        b(String paramString, boolean paramBoolean, long paramLong, bg.3 param3) {}
        
        public final void a(int paramInt1, int paramInt2, String paramString, bha parambha)
        {
          AppMethodBeat.i(256726);
          p.k(parambha, "resp");
          bg.a(this.ysR.ysM, paramInt1, paramInt2, this.ysO.toString(), parambha.OAl);
          if ((bg.b(this.ysR.ysM).getLiveRole() == 0) && (paramInt1 == 0) && (paramInt2 == 0))
          {
            m.yCt.a(s.bm.yMQ, this.ysO.toString());
            bg.a(this.ysR.ysM, bool, l, this.ysO);
          }
          AppMethodBeat.o(256726);
        }
      }
    });
    this.kFi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(269340);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        bg.p(this.ysM);
        paramAnonymousView = bg.d(this.ysM);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(269340);
          throw paramAnonymousView;
        }
        ((MMActivity)paramAnonymousView).hideVKB();
        bg.a(this.ysM);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(269340);
      }
    });
    this.kFp.setEntranceScene(ChatFooterPanel.Rct);
    this.kFp.hjp();
    this.kFp.hjq();
    this.kFp.DS(false);
    this.kFp.bhB();
    this.kFp.setVisibility(4);
    this.kFp.onResume();
    this.kFp.setOnTextOperationListener((ChatFooterPanel.a)new l(this));
    AppMethodBeat.o(281878);
  }
  
  private final void aPz()
  {
    AppMethodBeat.i(281867);
    if (this.kFs != this.kFh)
    {
      AppMethodBeat.o(281867);
      return;
    }
    ImageView localImageView = this.kFn;
    Context localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    localImageView.setImageDrawable(au.e(localContext.getResources().getDrawable(b.i.icons_filled_sticker), -1));
    this.kFp.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new k(this)).start();
    AppMethodBeat.o(281867);
  }
  
  private final void ph(boolean paramBoolean)
  {
    AppMethodBeat.i(281868);
    this.kFs = this.kFf;
    this.kiF.setVisibility(4);
    this.kFl.clearFocus();
    Object localObject = this.kiF.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(281868);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.kFl;
    p.j(localMMEditText, "inputEt");
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localMMEditText.getWindowToken(), 0);
    pi(false);
    if (paramBoolean) {
      this.kiF.post((Runnable)new e(this));
    }
    AppMethodBeat.o(281868);
  }
  
  private final void pi(boolean paramBoolean)
  {
    AppMethodBeat.i(281870);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm = paramBoolean;
    com.tencent.mm.live.c.b localb = this.kCL;
    com.tencent.mm.live.c.b.c localc = com.tencent.mm.live.c.b.c.kAC;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm);
    localb.statusChange(localc, localBundle);
    AppMethodBeat.o(281870);
  }
  
  private final void tW(int paramInt)
  {
    AppMethodBeat.i(281873);
    Object localObject1;
    Object localObject2;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    View localView;
    if ((this.kiF.getContext() instanceof Activity))
    {
      localObject1 = this.kFk;
      p.j(localObject1, "inputParent");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(281873);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject1;
      if (!isLandscape()) {}
      for (((LinearLayout.LayoutParams)localObject2).bottomMargin = (ax.aB(this.context) + paramInt);; ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt)
      {
        localObject2 = this.kFk;
        p.j(localObject2, "inputParent");
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.ysG;
        if (localObject1 == null) {
          break label251;
        }
        localObject2 = ((com.tencent.mm.live.c.a)localObject1).kiF.getLayoutParams();
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(281873);
        throw ((Throwable)localObject1);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)localObject2;
      if (isLandscape()) {
        break label404;
      }
      if (paramInt >= 0)
      {
        i = ax.aB(this.context);
        localView = this.kFk;
        p.j(localView, "inputParent");
        localLayoutParams.bottomMargin = (i + paramInt + localView.getHeight() + this.context.getResources().getDimensionPixelOffset(b.d.Edge_2A) * 2);
      }
      ((com.tencent.mm.live.c.a)localObject1).kiF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      label251:
      localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
      if (isLandscape()) {
        break label449;
      }
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = ax.aB(this.context);
    }
    for (;;)
    {
      this.kFp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.kFp.getParent() == null) {
        this.kFj.addView((View)this.kFp, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = new Bundle();
      i = aPB().getHeight();
      int j = ax.aB(this.kiF.getContext());
      localObject2 = this.kFi;
      p.j(localObject2, "inputLayout");
      ((Bundle)localObject1).putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + paramInt + j + ((LinearLayout)localObject2).getPaddingBottom());
      this.kCL.statusChange(com.tencent.mm.live.c.b.c.kzX, (Bundle)localObject1);
      AppMethodBeat.o(281873);
      return;
      label404:
      localView = this.kFk;
      p.j(localView, "inputParent");
      localLayoutParams.bottomMargin = (localView.getHeight() + paramInt + this.context.getResources().getDimensionPixelOffset(b.d.Edge_2A) * 2);
      break;
      label449:
      ((LinearLayout.LayoutParams)localObject1).setMarginEnd(ax.aB(this.context));
    }
  }
  
  public final View aPB()
  {
    AppMethodBeat.i(281874);
    View localView = this.kFk;
    p.j(localView, "inputParent");
    AppMethodBeat.o(281874);
    return localView;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(281872);
    super.keyboardChange(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      if (this.kFs == this.kFg)
      {
        this.kFs = this.kFf;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.kFp.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        tW(0);
        AppMethodBeat.o(281872);
      }
    }
    else
    {
      this.kFs = this.kFg;
      aPz();
      tW(paramInt);
    }
    AppMethodBeat.o(281872);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(281875);
    super.mount();
    Object localObject = this.kFm;
    p.j(localObject, "sendBtn");
    localObject = ((TextView)localObject).getText();
    TextView localTextView = this.kFm;
    p.j(localTextView, "sendBtn");
    int i = (int)StaticLayout.getDesiredWidth((CharSequence)localObject, localTextView.getPaint());
    int j = aw.aZ(this.context, b.d.Edge_7A);
    localObject = this.kFm;
    p.j(localObject, "sendBtn");
    int k = ((TextView)localObject).getPaddingStart();
    localObject = this.kFm;
    p.j(localObject, "sendBtn");
    this.kFq = kotlin.k.i.ov(j, i + k + ((TextView)localObject).getPaddingEnd());
    AppMethodBeat.o(281875);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(281877);
    if (this.kiF.getVisibility() == 0)
    {
      if (this.kFs == this.kFh)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.kFp.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        this.kFs = this.kFf;
        tW(0);
      }
      for (;;)
      {
        AppMethodBeat.o(281877);
        return true;
        ph(true);
      }
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(281877);
    return bool;
  }
  
  public final void statusChange(com.tencent.mm.live.c.b.c paramc, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(281871);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (bh.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(281871);
      return;
      tU(8);
      Util.hideVKB((View)this.kFl);
      AppMethodBeat.o(281871);
      return;
      boolean bool;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_NEED_NOTIFY_SEND_MSG_RESULT", false);
        this.ysJ = bool;
        if (!this.ysJ) {
          break label693;
        }
        if (paramBundle == null) {
          break label167;
        }
      }
      label167:
      for (paramc = Long.valueOf(paramBundle.getLong("PARAM_FINDER_LIVE_SEND_MSG_SESSION_ID", 0L));; paramc = null)
      {
        if (paramc != null) {
          break label172;
        }
        paramc = new t("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(281871);
        throw paramc;
        bool = false;
        break;
      }
      label172:
      this.ysK = paramc.longValue();
      label193:
      Object localObject1;
      label231:
      Object localObject2;
      label388:
      label406:
      int i;
      Object localObject4;
      label503:
      TextPaint localTextPaint;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT");
        if (!bool) {
          break label865;
        }
        if (paramBundle == null) {
          break label707;
        }
        localObject1 = paramBundle.getByteArray("PARAM_ENTER_COMMENT_AT_NAME");
        if (localObject1 == null) {
          break label707;
        }
        paramc = new aza();
        paramc.parseFrom((byte[])localObject1);
        this.kiF.setVisibility(0);
        localObject1 = this.kFn;
        localObject2 = this.kiF.getContext();
        p.j(localObject2, "root.context");
        ((ImageView)localObject1).setImageDrawable(au.e(((Context)localObject2).getResources().getDrawable(b.i.icons_filled_sticker), -1));
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
        p.j(localObject1, "extraMsg?.getString(ILiv…IVE_AUTO_INPUT_MSG) ?: \"\"");
        if (paramBundle != null) {
          paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT", false);
        }
        pi(true);
        localObject2 = new c(this);
        paramBundle = new d(this);
        if (paramc == null) {
          break label743;
        }
        if (this.ysI != null)
        {
          paramBundle = this.ysI;
          if (paramBundle == null) {
            break label712;
          }
          paramBundle = paramBundle.contact;
          if (paramBundle == null) {
            break label712;
          }
          paramBundle = paramBundle.nickname;
          localObject1 = paramc.contact;
          if (localObject1 == null) {
            break label717;
          }
          localObject1 = ((FinderContact)localObject1).nickname;
          if (!(p.h(paramBundle, localObject1) ^ true)) {}
        }
        else
        {
          localObject1 = this.context.getResources();
          i = b.j.finder_live_reply_someone_new_hint;
          paramBundle = com.tencent.mm.plugin.finder.convert.d.xgJ;
          localObject3 = this.kiF.getContext();
          p.j(localObject3, "root.context");
          paramBundle = this.kFl;
          p.j(paramBundle, "inputEt");
          localObject4 = paramBundle.getPaint();
          p.j(localObject4, "inputEt.paint");
          paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.nickname;
          if (paramBundle == null) {
            break label723;
          }
          paramBundle = (CharSequence)paramBundle;
          localObject3 = com.tencent.mm.plugin.finder.convert.d.a((Context)localObject3, (TextPaint)localObject4, paramBundle);
          paramBundle = com.tencent.mm.plugin.finder.convert.d.xgJ;
          localObject4 = this.kiF.getContext();
          p.j(localObject4, "root.context");
          paramBundle = this.kFl;
          p.j(paramBundle, "inputEt");
          localTextPaint = paramBundle.getPaint();
          p.j(localTextPaint, "inputEt.paint");
          paramBundle = paramc.contact;
          if (paramBundle == null) {
            break label733;
          }
          paramBundle = paramBundle.nickname;
          if (paramBundle == null) {
            break label733;
          }
        }
      }
      label693:
      label707:
      label712:
      label717:
      label723:
      label733:
      for (paramBundle = (CharSequence)paramBundle;; paramBundle = (CharSequence)"")
      {
        paramBundle = ((Resources)localObject1).getString(i, new Object[] { localObject3, com.tencent.mm.plugin.finder.convert.d.a((Context)localObject4, localTextPaint, paramBundle) });
        p.j(paramBundle, "context.resources.getStr…                  ?: \"\"))");
        localObject1 = this.kFl;
        p.j(localObject1, "inputEt");
        ((MMEditText)localObject1).setHint((CharSequence)paramBundle);
        paramBundle = this.kFl;
        p.j(paramBundle, "inputEt");
        paramBundle.setText(null);
        this.ysI = paramc;
        this.kFl.postDelayed((Runnable)new b(this, (c)localObject2), 100L);
        AppMethodBeat.o(281871);
        return;
        this.ysK = 0L;
        break;
        bool = false;
        break label193;
        paramc = null;
        break label231;
        paramBundle = null;
        break label388;
        localObject1 = null;
        break label406;
        paramBundle = (CharSequence)"";
        break label503;
      }
      label743:
      paramc = (bg)this;
      Object localObject3 = (CharSequence)localObject1;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label850;
        }
        localObject1 = paramc.kFl;
        p.j(localObject1, "inputEt");
        localObject1 = (CharSequence)((MMEditText)localObject1).getText();
        if (localObject1 != null)
        {
          i = j;
          if (((CharSequence)localObject1).length() != 0) {}
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          paramBundle.invoke();
        }
      }
      for (;;)
      {
        paramc.ysI = null;
        ((c)localObject2).invoke();
        AppMethodBeat.o(281871);
        return;
        i = 0;
        break;
        label850:
        paramc.kFl.setText((CharSequence)localObject1);
      }
      label865:
      ph(false);
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(281865);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w("Finder.LiveInputPlugin", "setVisible return for isTeenMode");
      AppMethodBeat.o(281865);
      return;
    }
    super.tU(paramInt);
    AppMethodBeat.o(281865);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(281876);
    super.unMount();
    AppMethodBeat.o(281876);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$Companion;", "", "()V", "AT_PREFFIX", "", "AT_SUFFIX", "MAX_COMMENT_TEXT_NUM", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$changeToInputMode$3$1"})
  static final class b
    implements Runnable
  {
    b(bg parambg, bg.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(289341);
      this.ysS.invoke();
      AppMethodBeat.o(289341);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"showKVB", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(bg parambg)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(285846);
      bg.f(this.ysM).requestFocus();
      if ((this.ysM.kiF.getContext() instanceof MMActivity))
      {
        Context localContext = this.ysM.kiF.getContext();
        localObject = localContext;
        if (!(localContext instanceof MMActivity)) {
          localObject = null;
        }
        localObject = (MMActivity)localObject;
        if (localObject != null)
        {
          ((MMActivity)localObject).showVKB();
          AppMethodBeat.o(285846);
          return;
        }
        AppMethodBeat.o(285846);
        return;
      }
      Object localObject = (InputMethodManager)this.ysM.kiF.getContext().getSystemService("input_method");
      if (localObject != null)
      {
        ((InputMethodManager)localObject).showSoftInput((View)bg.f(this.ysM), 0);
        AppMethodBeat.o(285846);
        return;
      }
      AppMethodBeat.o(285846);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"clearEditStatus", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(bg parambg)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(279817);
      MMEditText localMMEditText = bg.f(this.ysM);
      p.j(localMMEditText, "inputEt");
      StringBuilder localStringBuilder = new StringBuilder();
      String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ysM.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.nickname;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localMMEditText.setHint((CharSequence)((String)localObject + ':'));
      localObject = bg.f(this.ysM);
      p.j(localObject, "inputEt");
      ((MMEditText)localObject).setText(null);
      AppMethodBeat.o(279817);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(bg parambg) {}
    
    public final void run()
    {
      AppMethodBeat.i(270933);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_IS_ENTERING_COMMENT", false);
      bg.b(this.ysM).statusChange(com.tencent.mm.live.c.b.c.kzy, localBundle);
      AppMethodBeat.o(270933);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$checkTextLimit$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
  public static final class f
    implements c.a
  {
    public final void abc(String paramString)
    {
      AppMethodBeat.i(281789);
      int i = com.tencent.mm.ui.tools.g.dq(120, paramString);
      if (i > 5)
      {
        paramString = bg.c(this.ysM);
        p.j(paramString, "textLimitView");
        paramString.setVisibility(8);
        AppMethodBeat.o(281789);
        return;
      }
      paramString = bg.c(this.ysM);
      p.j(paramString, "textLimitView");
      paramString.setText((CharSequence)String.valueOf(i));
      bg.c(this.ysM).setTextColor(bg.d(this.ysM).getResources().getColor(com.tencent.mm.plugin.finder.b.c.BW_100_Alpha_0_5));
      paramString = bg.c(this.ysM);
      p.j(paramString, "textLimitView");
      paramString.setVisibility(0);
      AppMethodBeat.o(281789);
    }
    
    public final void abd(String paramString)
    {
      AppMethodBeat.i(281787);
      paramString = bg.c(this.ysM);
      p.j(paramString, "textLimitView");
      paramString.setVisibility(8);
      AppMethodBeat.o(281787);
    }
    
    public final void dN(String paramString)
    {
      AppMethodBeat.i(281788);
      TextView localTextView = bg.c(this.ysM);
      p.j(localTextView, "textLimitView");
      localTextView.setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.g.dq(120, paramString)));
      bg.c(this.ysM).setTextColor(bg.d(this.ysM).getResources().getColor(com.tencent.mm.plugin.finder.b.c.Red));
      paramString = bg.c(this.ysM);
      p.j(paramString, "textLimitView");
      paramString.setVisibility(0);
      AppMethodBeat.o(281788);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(bg parambg, int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "source", "", "kotlin.jvm.PlatformType", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class h
    implements InputFilter
  {
    public static final h ysU;
    
    static
    {
      AppMethodBeat.i(283947);
      ysU = new h();
      AppMethodBeat.o(283947);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
  public static final class i
    extends com.tencent.mm.ui.tools.g
  {
    i(g.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(279370);
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
        paramInt2 = com.tencent.mm.ui.tools.g.a(String.valueOf(localCharSequence), g.a.XSu);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label204;
        }
      }
      label183:
      label189:
      label204:
      for (paramInt3 = com.tencent.mm.ui.tools.g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.XSu);; paramInt3 = 0)
      {
        paramInt4 = com.tencent.mm.ui.tools.g.a(String.valueOf(paramCharSequence), g.a.XSu);
        int i = com.tencent.mm.ui.tools.g.bAE(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
          break label228;
        }
        paramInt2 = kotlin.k.i.ov(120 - paramInt2 - paramInt3 - i, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label210;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(279370);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = com.tencent.mm.ui.tools.g.a(String.valueOf(paramSpanned), g.a.XSu);
        break label53;
      }
      label210:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(279370);
      return paramCharSequence;
      label228:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(279370);
        return paramCharSequence;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(bg parambg, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class k
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(275066);
      bg.e(this.ysM).setAlpha(1.0F);
      bg.e(this.ysM).setVisibility(4);
      AppMethodBeat.o(275066);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class l
    implements ChatFooterPanel.a
  {
    public final void aDN() {}
    
    public final void aDO()
    {
      AppMethodBeat.i(280970);
      Object localObject = bg.f(this.ysM);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = bg.f(this.ysM);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(280970);
          return;
        }
      }
      AppMethodBeat.o(280970);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(280969);
      MMEditText localMMEditText = bg.f(this.ysM);
      if (localMMEditText != null)
      {
        if (com.tencent.mm.ui.tools.g.a(localMMEditText.getText() + paramString, g.a.XSu) <= 120) {
          localMMEditText.bBa(paramString);
        }
        AppMethodBeat.o(280969);
        return;
      }
      AppMethodBeat.o(280969);
    }
    
    public final void eE(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bg
 * JD-Core Version:    0.7.0.1
 */