package com.tencent.mm.live.c;

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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.l.c;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "changeToInputMode", "", "changeToPreviewMode", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class z
  extends a
  implements com.tencent.mm.an.i
{
  public static final a kFu;
  private Context context;
  private final b kCL;
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
  
  static
  {
    AppMethodBeat.i(194925);
    kFu = new a((byte)0);
    AppMethodBeat.o(194925);
  }
  
  public z(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(194921);
    this.kCL = paramb;
    this.kFg = 1;
    this.kFh = 2;
    this.kFi = ((LinearLayout)paramViewGroup.findViewById(b.e.live_input_layout));
    this.kFj = ((LinearLayout)paramViewGroup.findViewById(b.e.live_emoji_layout));
    this.kFk = paramViewGroup.findViewById(b.e.live_input_parent);
    this.kFl = ((MMEditText)paramViewGroup.findViewById(b.e.live_input_txt));
    this.kFm = ((TextView)paramViewGroup.findViewById(b.e.live_send_btn));
    this.kFn = ((ImageView)paramViewGroup.findViewById(b.e.live_input_emoji));
    this.kFo = ((TextView)paramViewGroup.findViewById(b.e.live_click_cancel));
    paramb = ad.m(paramViewGroup.getContext(), false);
    p.j(paramb, "SmileyPanelFactory.getSm…anel(root.context, false)");
    this.kFp = paramb;
    paramb = paramViewGroup.getContext();
    p.j(paramb, "root.context");
    this.context = paramb;
    this.kFs = this.kFf;
    this.kFs = this.kFf;
    paramb = this.kFn;
    Object localObject = paramViewGroup.getContext();
    p.j(localObject, "root.context");
    paramb.setImageDrawable(au.e(((Context)localObject).getResources().getDrawable(b.g.icons_filled_sticker), -1));
    this.kFn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(195095);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (z.e(this.kFv) != z.f(this.kFv)) {}
        for (boolean bool = true;; bool = false)
        {
          z.a(this.kFv, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(195095);
          return;
        }
      }
    });
    paramb = (InputFilter)new b(this);
    localObject = (InputFilter)new c(g.a.XSu);
    MMEditText localMMEditText = this.kFl;
    p.j(localMMEditText, "inputEt");
    localMMEditText.setFilters(new InputFilter[] { paramb, localObject });
    this.kFl.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(196090);
        int i;
        if ((z.g(this.kFv) == 0) || (z.g(this.kFv) != this.kFv.aPB().getHeight()))
        {
          z.a(this.kFv, this.kFv.aPB().getHeight());
          paramAnonymousEditable = new Bundle();
          i = KeyBoardUtil.getKeyBordHeightPx(z.d(this.kFv));
          int j = this.kFv.aPB().getHeight();
          int k = ax.aB(paramViewGroup.getContext());
          LinearLayout localLinearLayout = z.h(this.kFv);
          p.j(localLinearLayout, "inputLayout");
          paramAnonymousEditable.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + j + k + localLinearLayout.getPaddingBottom());
          z.c(this.kFv).statusChange(b.c.kzX, paramAnonymousEditable);
        }
        paramAnonymousEditable = z.b(this.kFv);
        p.j(paramAnonymousEditable, "inputEt");
        paramAnonymousEditable = paramAnonymousEditable.getText();
        if (paramAnonymousEditable != null) {
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label265;
            }
            paramAnonymousEditable = z.b(this.kFv);
            p.j(paramAnonymousEditable, "inputEt");
            paramAnonymousEditable = paramAnonymousEditable.getText();
            if (paramAnonymousEditable == null) {
              break label260;
            }
            if (n.ba((CharSequence)paramAnonymousEditable)) {
              break label255;
            }
            i = 1;
            label220:
            if (i == 0) {
              break label265;
            }
          }
        }
        label260:
        label265:
        for (boolean bool = true;; bool = false)
        {
          if (bool != z.i(this.kFv)) {
            break label271;
          }
          AppMethodBeat.o(196090);
          return;
          i = 0;
          break;
          i = 0;
          break;
          label255:
          i = 0;
          break label220;
          i = 0;
          break label220;
        }
        label271:
        z.b(this.kFv, bool);
        if (z.i(this.kFv))
        {
          paramAnonymousEditable = z.j(this.kFv);
          p.j(paramAnonymousEditable, "inputEmoji");
          paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(196090);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.ci.a.aY(paramViewGroup.getContext(), com.tencent.mm.live.b.c.Edge_1_5_A));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, z.k(this.kFv) });
          paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this));
          paramAnonymousEditable.start();
          AppMethodBeat.o(196090);
          return;
        }
        paramAnonymousEditable = z.j(this.kFv);
        p.j(paramAnonymousEditable, "inputEmoji");
        paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(196090);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.ci.a.aY(paramViewGroup.getContext(), com.tencent.mm.live.b.c.Edge_2A));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { z.k(this.kFv), 0 });
        paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new d(this));
        paramAnonymousEditable.start();
        AppMethodBeat.o(196090);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class a
        implements ValueAnimator.AnimatorUpdateListener
      {
        a(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(200019);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(200019);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.kFw.kFv);
          p.j(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = kotlin.h.a.dm(f);
          TextView localTextView = z.l(this.kFw.kFv);
          p.j(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.kFw.kFv);
          p.j(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.kFw.kFv));
          AppMethodBeat.o(200019);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class b
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(189882);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.kFw.kFv);
          TextView localTextView = z.l(this.kFw.kFv);
          p.j(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(189882);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(189878);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.kFw.kFv);
          TextView localTextView = z.l(this.kFw.kFv);
          p.j(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(189878);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(189885);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(189885);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class c
        implements ValueAnimator.AnimatorUpdateListener
      {
        c(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(195671);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(195671);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.kFw.kFv);
          p.j(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = kotlin.h.a.dm(f);
          TextView localTextView = z.l(this.kFw.kFv);
          p.j(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.kFw.kFv);
          p.j(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.kFw.kFv));
          AppMethodBeat.o(195671);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class d
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(191319);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(191319);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(191317);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(191317);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(191320);
          paramAnimator = z.l(this.kFw.kFv);
          p.j(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(191320);
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
        paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(194921);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ax.aB(paramViewGroup.getContext()));
    }
    this.kFm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(189225);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = u.kwz;
        if (u.aOB()) {
          new f.a(z.d(this.kFv)).icD().aR((CharSequence)z.d(this.kFv).getResources().getString(b.h.live_comment_tip_foreigner)).ayp(b.h.app_i_know).b((f.c)1.kFx).show();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189225);
          return;
          paramAnonymousView = z.b(this.kFv);
          p.j(paramAnonymousView, "inputEt");
          if (paramAnonymousView.getText() != null)
          {
            z.m(this.kFv);
            paramAnonymousView = z.d(this.kFv);
            if (paramAnonymousView == null)
            {
              paramAnonymousView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(189225);
              throw paramAnonymousView;
            }
            ((MMActivity)paramAnonymousView).hideVKB();
            z.n(this.kFv);
            paramAnonymousView = z.b(this.kFv);
            p.j(paramAnonymousView, "inputEt");
            paramAnonymousView = paramAnonymousView.getText();
            localObject = z.b(this.kFv);
            p.j(localObject, "inputEt");
            ((MMEditText)localObject).setText(null);
            localObject = o.kvA;
            paramAnonymousView = paramAnonymousView.toString();
            localObject = l.c.kuq;
            o.as(paramAnonymousView, l.c.aNE());
            b.b.a(z.c(this.kFv), b.c.kzt);
            if (z.c(this.kFv).getLiveRole() == 0) {
              f.aQR();
            }
          }
        }
      }
    });
    this.kFi.setOnClickListener((View.OnClickListener)z.4.kFy);
    this.kFo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191411);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        z.m(this.kFv);
        paramAnonymousView = z.d(this.kFv);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(191411);
          throw paramAnonymousView;
        }
        ((MMActivity)paramAnonymousView).hideVKB();
        z.n(this.kFv);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191411);
      }
    });
    this.kFp.setEntranceScene(ChatFooterPanel.Rct);
    this.kFp.hjp();
    this.kFp.hjq();
    this.kFp.DS(false);
    this.kFp.setVisibility(4);
    this.kFp.onResume();
    this.kFp.setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    AppMethodBeat.o(194921);
  }
  
  private final void aPA()
  {
    AppMethodBeat.i(194870);
    this.kFs = this.kFf;
    this.kiF.setVisibility(4);
    this.kFl.clearFocus();
    Object localObject = this.kiF.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(194870);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.kFl;
    p.j(localMMEditText, "inputEt");
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localMMEditText.getWindowToken(), 0);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_IS_ENTERING_COMMENT", false);
    this.kCL.statusChange(b.c.kzy, (Bundle)localObject);
    AppMethodBeat.o(194870);
  }
  
  private final void aPz()
  {
    AppMethodBeat.i(194867);
    if (this.kFs != this.kFh)
    {
      AppMethodBeat.o(194867);
      return;
    }
    ImageView localImageView = this.kFn;
    Context localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    localImageView.setImageDrawable(au.e(localContext.getResources().getDrawable(b.g.icons_filled_sticker), -1));
    this.kFp.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(194867);
  }
  
  private final void tW(int paramInt)
  {
    AppMethodBeat.i(194885);
    Object localObject1;
    Object localObject2;
    if ((this.kiF.getContext() instanceof Activity))
    {
      localObject1 = this.kFk;
      p.j(localObject1, "inputParent");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(194885);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject1;
      if (isLandscape()) {
        break label268;
      }
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = (ax.aB(this.context) + paramInt);
      localObject2 = this.kFk;
      p.j(localObject2, "inputParent");
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
      if (isLandscape()) {
        break label277;
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
      int i = aPB().getHeight();
      int j = ax.aB(this.kiF.getContext());
      localObject2 = this.kFi;
      p.j(localObject2, "inputLayout");
      ((Bundle)localObject1).putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + paramInt + j + ((LinearLayout)localObject2).getPaddingBottom());
      this.kCL.statusChange(b.c.kzX, (Bundle)localObject1);
      AppMethodBeat.o(194885);
      return;
      label268:
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt;
      break;
      label277:
      ((LinearLayout.LayoutParams)localObject1).setMarginEnd(ax.aB(this.context));
    }
  }
  
  public final View aPB()
  {
    AppMethodBeat.i(194887);
    View localView = this.kFk;
    p.j(localView, "inputParent");
    AppMethodBeat.o(194887);
    return localView;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(194881);
    super.keyboardChange(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      if (this.kFs == this.kFg)
      {
        this.kFs = this.kFf;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.kFp.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        tW(0);
        AppMethodBeat.o(194881);
      }
    }
    else
    {
      this.kFs = this.kFg;
      aPz();
      tW(paramInt);
    }
    AppMethodBeat.o(194881);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(194892);
    super.mount();
    Object localObject = this.kFm;
    p.j(localObject, "sendBtn");
    localObject = ((TextView)localObject).getText();
    TextView localTextView = this.kFm;
    p.j(localTextView, "sendBtn");
    int i = (int)StaticLayout.getDesiredWidth((CharSequence)localObject, localTextView.getPaint());
    int j = aw.aZ(this.context, com.tencent.mm.live.b.c.Edge_7A);
    localObject = this.kFm;
    p.j(localObject, "sendBtn");
    int k = ((TextView)localObject).getPaddingStart();
    localObject = this.kFm;
    p.j(localObject, "sendBtn");
    this.kFq = kotlin.k.i.ov(j, i + k + ((TextView)localObject).getPaddingEnd());
    localObject = h.aHF();
    p.j(localObject, "MMKernel.network()");
    ((c)localObject).aGY().a(904, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(194892);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(194904);
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
        AppMethodBeat.o(194904);
        return true;
        aPA();
      }
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(194904);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(194912);
    if (((paramq instanceof s)) && (paramInt2 == -100065))
    {
      paramString = u.kwz;
      u.aOC();
      d.uiThread((kotlin.g.a.a)new e(this));
    }
    AppMethodBeat.o(194912);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(194878);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (aa.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(194878);
        return;
        tU(8);
        AppMethodBeat.o(194878);
        return;
        AppMethodBeat.o(194878);
        return;
        if (paramBundle == null) {
          break;
        }
      } while (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") != true);
      this.kiF.setVisibility(0);
      paramc = this.kFn;
      paramBundle = this.kiF.getContext();
      p.j(paramBundle, "root.context");
      paramc.setImageDrawable(au.e(paramBundle.getResources().getDrawable(b.g.icons_filled_sticker), -1));
      this.kFl.requestFocus();
      paramc = (InputMethodManager)this.kiF.getContext().getSystemService("input_method");
    } while (paramc == null);
    paramc.showSoftInput((View)this.kFl, 0);
    AppMethodBeat.o(194878);
    return;
    AppMethodBeat.o(194878);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(194897);
    super.unMount();
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(904, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(194897);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveInputPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class b
    implements InputFilter
  {
    b(z paramz) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(190341);
      paramSpanned = z.b(this.kFv);
      p.j(paramSpanned, "inputEt");
      paramSpanned.getText();
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(190341);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(190341);
        return paramCharSequence;
      }
      AppMethodBeat.o(190341);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-logic_release"})
  public static final class c
    extends g
  {
    c(g.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(195624);
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
        paramInt2 = g.a(String.valueOf(localCharSequence), g.a.XSu);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label204;
        }
      }
      label183:
      label189:
      label204:
      for (paramInt3 = g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.XSu);; paramInt3 = 0)
      {
        paramInt4 = g.a(String.valueOf(paramCharSequence), g.a.XSu);
        int i = g.bAE(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
          break label228;
        }
        paramInt2 = kotlin.k.i.ov(120 - paramInt2 - paramInt3 - i, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label210;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(195624);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = g.a(String.valueOf(paramSpanned), g.a.XSu);
        break label53;
      }
      label210:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(195624);
      return paramCharSequence;
      label228:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(195624);
        return paramCharSequence;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(199557);
      z.a(this.kFv).setAlpha(1.0F);
      z.a(this.kFv).setVisibility(4);
      AppMethodBeat.o(199557);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(z paramz)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-logic_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void aDN() {}
    
    public final void aDO()
    {
      AppMethodBeat.i(193971);
      Object localObject = z.b(this.kFv);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = z.b(this.kFv);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(193971);
          return;
        }
      }
      AppMethodBeat.o(193971);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(193969);
      MMEditText localMMEditText = z.b(this.kFv);
      if (localMMEditText != null) {
        localMMEditText.bBa(paramString);
      }
      if (z.c(this.kFv).getLiveRole() == 0) {
        f.aQS();
      }
      AppMethodBeat.o(193969);
    }
    
    public final void eE(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.z
 * JD-Core Version:    0.7.0.1
 */