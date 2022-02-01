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
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.o.d;
import com.tencent.mm.live.b.r;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "changeToInputMode", "", "changeToPreviewMode", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class z
  extends a
  implements i
{
  public static final a hQX;
  private Context context;
  private final b hOp;
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
  
  static
  {
    AppMethodBeat.i(208070);
    hQX = new a((byte)0);
    AppMethodBeat.o(208070);
  }
  
  public z(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208069);
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
    paramb = ad.l(paramViewGroup.getContext(), false);
    p.g(paramb, "SmileyPanelFactory.getSm…anel(root.context, false)");
    this.hQS = paramb;
    paramb = paramViewGroup.getContext();
    p.g(paramb, "root.context");
    this.context = paramb;
    this.hQV = this.hQI;
    this.hQV = this.hQI;
    paramb = this.hQQ;
    Object localObject = paramViewGroup.getContext();
    p.g(localObject, "root.context");
    paramb.setImageDrawable(ar.e(((Context)localObject).getResources().getDrawable(2131690683), -1));
    this.hQQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208035);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (z.e(this.hQY) != z.f(this.hQY)) {}
        for (boolean bool = true;; bool = false)
        {
          z.a(this.hQY, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208035);
          return;
        }
      }
    });
    paramb = (InputFilter)new b(this);
    localObject = (InputFilter)new c(com.tencent.mm.ui.tools.f.a.Qui);
    MMEditText localMMEditText = this.hQO;
    p.g(localMMEditText, "inputEt");
    localMMEditText.setFilters(new InputFilter[] { paramb, localObject });
    this.hQO.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(208044);
        int i;
        if ((z.g(this.hQY) == 0) || (z.g(this.hQY) != this.hQY.aHB().getHeight()))
        {
          z.a(this.hQY, this.hQY.aHB().getHeight());
          paramAnonymousEditable = new Bundle();
          i = KeyBoardUtil.getKeyBordHeightPx(z.d(this.hQY));
          int j = this.hQY.aHB().getHeight();
          int k = au.aD(paramViewGroup.getContext());
          LinearLayout localLinearLayout = z.h(this.hQY);
          p.g(localLinearLayout, "inputLayout");
          paramAnonymousEditable.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + j + k + localLinearLayout.getPaddingBottom());
          z.c(this.hQY).statusChange(b.c.hMD, paramAnonymousEditable);
        }
        paramAnonymousEditable = z.b(this.hQY);
        p.g(paramAnonymousEditable, "inputEt");
        paramAnonymousEditable = paramAnonymousEditable.getText();
        if (paramAnonymousEditable != null) {
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label265;
            }
            paramAnonymousEditable = z.b(this.hQY);
            p.g(paramAnonymousEditable, "inputEt");
            paramAnonymousEditable = paramAnonymousEditable.getText();
            if (paramAnonymousEditable == null) {
              break label260;
            }
            if (n.aL((CharSequence)paramAnonymousEditable)) {
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
          if (bool != z.i(this.hQY)) {
            break label271;
          }
          AppMethodBeat.o(208044);
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
        z.b(this.hQY, bool);
        if (z.i(this.hQY))
        {
          paramAnonymousEditable = z.j(this.hQY);
          p.g(paramAnonymousEditable, "inputEmoji");
          paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(208044);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cb.a.aG(paramViewGroup.getContext(), 2131165289));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, z.k(this.hQY) });
          paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this));
          paramAnonymousEditable.start();
          AppMethodBeat.o(208044);
          return;
        }
        paramAnonymousEditable = z.j(this.hQY);
        p.g(paramAnonymousEditable, "inputEmoji");
        paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(208044);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cb.a.aG(paramViewGroup.getContext(), 2131165296));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { z.k(this.hQY), 0 });
        paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new d(this));
        paramAnonymousEditable.start();
        AppMethodBeat.o(208044);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class a
        implements ValueAnimator.AnimatorUpdateListener
      {
        a(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(208036);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(208036);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.hQZ.hQY);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = kotlin.h.a.cR(f);
          TextView localTextView = z.l(this.hQZ.hQY);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.hQZ.hQY);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.hQZ.hQY));
          AppMethodBeat.o(208036);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class b
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(208038);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.hQZ.hQY);
          TextView localTextView = z.l(this.hQZ.hQY);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(208038);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(208037);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.hQZ.hQY);
          TextView localTextView = z.l(this.hQZ.hQY);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(208037);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(208039);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(208039);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class c
        implements ValueAnimator.AnimatorUpdateListener
      {
        c(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(208040);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(208040);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.hQZ.hQY);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = kotlin.h.a.cR(f);
          TextView localTextView = z.l(this.hQZ.hQY);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.hQZ.hQY);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.hQZ.hQY));
          AppMethodBeat.o(208040);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class d
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(208042);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(208042);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(208041);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(208041);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(208043);
          paramAnimator = z.l(this.hQZ.hQY);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(208043);
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
        paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(208069);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(au.aD(paramViewGroup.getContext()));
    }
    this.hQP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208046);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGB()) {
          new com.tencent.mm.ui.widget.a.f.a(z.d(this.hQY)).hbu().aC((CharSequence)z.d(this.hQY).getResources().getString(2131762268)).apa(2131755873).b((f.c)1.hRa).show();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208046);
          return;
          paramAnonymousView = z.b(this.hQY);
          p.g(paramAnonymousView, "inputEt");
          if (paramAnonymousView.getText() != null)
          {
            z.m(this.hQY);
            paramAnonymousView = z.d(this.hQY);
            if (paramAnonymousView == null)
            {
              paramAnonymousView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(208046);
              throw paramAnonymousView;
            }
            ((MMActivity)paramAnonymousView).hideVKB();
            z.n(this.hQY);
            paramAnonymousView = z.b(this.hQY);
            p.g(paramAnonymousView, "inputEt");
            paramAnonymousView = paramAnonymousView.getText();
            localObject = z.b(this.hQY);
            p.g(localObject, "inputEt");
            ((MMEditText)localObject).setText(null);
            localObject = r.hIg;
            paramAnonymousView = paramAnonymousView.toString();
            localObject = o.d.hGL;
            r.aa(paramAnonymousView, o.d.aFy());
            b.b.a(z.c(this.hQY), b.c.hMb);
            if (z.c(this.hQY).getLiveRole() == 0) {
              com.tencent.mm.live.d.f.aIT();
            }
          }
        }
      }
    });
    this.hQL.setOnClickListener((View.OnClickListener)z.4.hRb);
    this.hQR.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208049);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        z.m(this.hQY);
        paramAnonymousView = z.d(this.hQY);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(208049);
          throw paramAnonymousView;
        }
        ((MMActivity)paramAnonymousView).hideVKB();
        z.n(this.hQY);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208049);
      }
    });
    this.hQS.setEntranceScene(ChatFooterPanel.KbO);
    this.hQS.goD();
    this.hQS.goE();
    this.hQS.zN(false);
    this.hQS.setVisibility(4);
    this.hQS.onResume();
    this.hQS.setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    AppMethodBeat.o(208069);
  }
  
  private final void aHA()
  {
    AppMethodBeat.i(208060);
    this.hQV = this.hQI;
    this.hwr.setVisibility(4);
    this.hQO.clearFocus();
    Object localObject = this.hwr.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(208060);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.hQO;
    p.g(localMMEditText, "inputEt");
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localMMEditText.getWindowToken(), 0);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_IS_ENTERING_COMMENT", false);
    this.hOp.statusChange(b.c.hMd, (Bundle)localObject);
    AppMethodBeat.o(208060);
  }
  
  private final void aHz()
  {
    AppMethodBeat.i(208059);
    if (this.hQV != this.hQK)
    {
      AppMethodBeat.o(208059);
      return;
    }
    ImageView localImageView = this.hQQ;
    Context localContext = this.hwr.getContext();
    p.g(localContext, "root.context");
    localImageView.setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690683), -1));
    this.hQS.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(208059);
  }
  
  private final void ri(int paramInt)
  {
    AppMethodBeat.i(208063);
    Object localObject1;
    Object localObject2;
    if ((this.hwr.getContext() instanceof Activity))
    {
      localObject1 = this.hQN;
      p.g(localObject1, "inputParent");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(208063);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject1;
      if (isLandscape()) {
        break label268;
      }
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = (au.aD(this.context) + paramInt);
      localObject2 = this.hQN;
      p.g(localObject2, "inputParent");
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
      if (isLandscape()) {
        break label277;
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
      int i = aHB().getHeight();
      int j = au.aD(this.hwr.getContext());
      localObject2 = this.hQL;
      p.g(localObject2, "inputLayout");
      ((Bundle)localObject1).putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + paramInt + j + ((LinearLayout)localObject2).getPaddingBottom());
      this.hOp.statusChange(b.c.hMD, (Bundle)localObject1);
      AppMethodBeat.o(208063);
      return;
      label268:
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt;
      break;
      label277:
      ((LinearLayout.LayoutParams)localObject1).setMarginEnd(au.aD(this.context));
    }
  }
  
  public final View aHB()
  {
    AppMethodBeat.i(208064);
    View localView = this.hQN;
    p.g(localView, "inputParent");
    AppMethodBeat.o(208064);
    return localView;
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(208062);
    super.keyboardChange(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      if (this.hQV == this.hQJ)
      {
        this.hQV = this.hQI;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.hQS.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        ri(0);
        AppMethodBeat.o(208062);
      }
    }
    else
    {
      this.hQV = this.hQJ;
      aHz();
      ri(paramInt);
    }
    AppMethodBeat.o(208062);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(208065);
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
    localObject = g.aAg();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().a(904, (i)this);
    AppMethodBeat.o(208065);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(208067);
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
        AppMethodBeat.o(208067);
        return true;
        aHA();
      }
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(208067);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(208068);
    if (((paramq instanceof s)) && (paramInt2 == -100065))
    {
      paramString = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aGC();
      d.h((kotlin.g.a.a)new e(this));
    }
    AppMethodBeat.o(208068);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208061);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (aa.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(208061);
        return;
        rg(8);
        AppMethodBeat.o(208061);
        return;
        AppMethodBeat.o(208061);
        return;
        if (paramBundle == null) {
          break;
        }
      } while (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") != true);
      this.hwr.setVisibility(0);
      paramc = this.hQQ;
      paramBundle = this.hwr.getContext();
      p.g(paramBundle, "root.context");
      paramc.setImageDrawable(ar.e(paramBundle.getResources().getDrawable(2131690683), -1));
      this.hQO.requestFocus();
      paramc = (InputMethodManager)this.hwr.getContext().getSystemService("input_method");
    } while (paramc == null);
    paramc.showSoftInput((View)this.hQO, 0);
    AppMethodBeat.o(208061);
    return;
    AppMethodBeat.o(208061);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(208066);
    super.unMount();
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(904, (i)this);
    AppMethodBeat.o(208066);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveInputPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class b
    implements InputFilter
  {
    b(z paramz) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(208051);
      paramSpanned = z.b(this.hQY);
      p.g(paramSpanned, "inputEt");
      paramSpanned.getText();
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(208051);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(208051);
        return paramCharSequence;
      }
      AppMethodBeat.o(208051);
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-logic_release"})
  public static final class c
    extends com.tencent.mm.ui.tools.f
  {
    c(com.tencent.mm.ui.tools.f.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(208052);
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
        paramInt2 = com.tencent.mm.ui.tools.f.a(String.valueOf(localCharSequence), com.tencent.mm.ui.tools.f.a.Qui);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label204;
        }
      }
      label183:
      label189:
      label204:
      for (paramInt3 = com.tencent.mm.ui.tools.f.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), com.tencent.mm.ui.tools.f.a.Qui);; paramInt3 = 0)
      {
        paramInt4 = com.tencent.mm.ui.tools.f.a(String.valueOf(paramCharSequence), com.tencent.mm.ui.tools.f.a.Qui);
        int i = com.tencent.mm.ui.tools.f.bnR(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
          break label228;
        }
        paramInt2 = j.mZ(120 - paramInt2 - paramInt3 - i, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label210;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(208052);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = com.tencent.mm.ui.tools.f.a(String.valueOf(paramSpanned), com.tencent.mm.ui.tools.f.a.Qui);
        break label53;
      }
      label210:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(208052);
      return paramCharSequence;
      label228:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(208052);
        return paramCharSequence;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(208053);
      z.a(this.hQY).setAlpha(1.0F);
      z.a(this.hQY).setVisibility(4);
      AppMethodBeat.o(208053);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    e(z paramz)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-logic_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void aHC()
    {
      AppMethodBeat.i(208057);
      Object localObject = z.b(this.hQY);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = z.b(this.hQY);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(208057);
          return;
        }
      }
      AppMethodBeat.o(208057);
    }
    
    public final void aHD() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(208056);
      MMEditText localMMEditText = z.b(this.hQY);
      if (localMMEditText != null) {
        localMMEditText.bol(paramString);
      }
      if (z.c(this.hQY).getLiveRole() == 0) {
        com.tencent.mm.live.d.f.aIU();
      }
      AppMethodBeat.o(208056);
    }
    
    public final void eP(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.z
 * JD-Core Version:    0.7.0.1
 */