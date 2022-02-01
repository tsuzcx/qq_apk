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
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.p;
import d.k.j;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "changeToInputMode", "", "changeToPreviewMode", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class z
  extends a
  implements com.tencent.mm.ak.f
{
  public static final z.a gYb;
  private Context context;
  private final b gVv;
  private final int gXM;
  private final int gXN;
  private final int gXO;
  private final LinearLayout gXP;
  private final LinearLayout gXQ;
  private final View gXR;
  private final MMEditText gXS;
  private final TextView gXT;
  private final ImageView gXU;
  private final TextView gXV;
  private SmileyPanel gXW;
  private int gXX;
  private boolean gXY;
  private int gXZ;
  private int gYa;
  
  static
  {
    AppMethodBeat.i(216108);
    gYb = new z.a((byte)0);
    AppMethodBeat.o(216108);
  }
  
  public z(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216107);
    this.gVv = paramb;
    this.gXN = 1;
    this.gXO = 2;
    this.gXP = ((LinearLayout)paramViewGroup.findViewById(2131307640));
    this.gXQ = ((LinearLayout)paramViewGroup.findViewById(2131307621));
    this.gXR = paramViewGroup.findViewById(2131307641);
    this.gXS = ((MMEditText)paramViewGroup.findViewById(2131307643));
    this.gXT = ((TextView)paramViewGroup.findViewById(2131307769));
    this.gXU = ((ImageView)paramViewGroup.findViewById(2131307637));
    this.gXV = ((TextView)paramViewGroup.findViewById(2131307598));
    paramb = com.tencent.mm.api.aa.k(paramViewGroup.getContext(), false);
    p.g(paramb, "SmileyPanelFactory.getSm…anel(root.context, false)");
    this.gXW = paramb;
    paramb = paramViewGroup.getContext();
    p.g(paramb, "root.context");
    this.context = paramb;
    this.gXZ = this.gXM;
    this.gXZ = this.gXM;
    paramb = this.gXU;
    Object localObject = paramViewGroup.getContext();
    p.g(localObject, "root.context");
    paramb.setImageDrawable(ao.e(((Context)localObject).getResources().getDrawable(2131690482), -1));
    this.gXU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216073);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (z.e(this.gYc) != z.f(this.gYc)) {}
        for (boolean bool = true;; bool = false)
        {
          z.a(this.gYc, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216073);
          return;
        }
      }
    });
    paramb = (InputFilter)new b(this);
    localObject = (InputFilter)new c(com.tencent.mm.ui.tools.f.a.Lfh);
    MMEditText localMMEditText = this.gXS;
    p.g(localMMEditText, "inputEt");
    localMMEditText.setFilters(new InputFilter[] { paramb, localObject });
    this.gXS.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(216082);
        int i;
        if ((z.g(this.gYc) == 0) || (z.g(this.gYc) != this.gYc.apb().getHeight()))
        {
          z.a(this.gYc, this.gYc.apb().getHeight());
          paramAnonymousEditable = new Bundle();
          i = com.tencent.mm.sdk.platformtools.aa.iK(z.d(this.gYc));
          int j = this.gYc.apb().getHeight();
          int k = ar.en(paramViewGroup.getContext());
          LinearLayout localLinearLayout = z.h(this.gYc);
          p.g(localLinearLayout, "inputLayout");
          paramAnonymousEditable.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + j + k + localLinearLayout.getPaddingBottom());
          z.c(this.gYc).a(b.c.gVd, paramAnonymousEditable);
        }
        paramAnonymousEditable = z.b(this.gYc);
        p.g(paramAnonymousEditable, "inputEt");
        paramAnonymousEditable = paramAnonymousEditable.getText();
        if (paramAnonymousEditable != null) {
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label265;
            }
            paramAnonymousEditable = z.b(this.gYc);
            p.g(paramAnonymousEditable, "inputEt");
            paramAnonymousEditable = paramAnonymousEditable.getText();
            if (paramAnonymousEditable == null) {
              break label260;
            }
            if (d.n.n.aD((CharSequence)paramAnonymousEditable)) {
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
          if (bool != z.i(this.gYc)) {
            break label271;
          }
          AppMethodBeat.o(216082);
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
        z.b(this.gYc, bool);
        if (z.i(this.gYc))
        {
          paramAnonymousEditable = z.j(this.gYc);
          p.g(paramAnonymousEditable, "inputEmoji");
          paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(216082);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cb.a.ax(paramViewGroup.getContext(), 2131165284));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, z.k(this.gYc) });
          paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this));
          paramAnonymousEditable.start();
          AppMethodBeat.o(216082);
          return;
        }
        paramAnonymousEditable = z.j(this.gYc);
        p.g(paramAnonymousEditable, "inputEmoji");
        paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(216082);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cb.a.ax(paramViewGroup.getContext(), 2131165289));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { z.k(this.gYc), 0 });
        paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new d(this));
        paramAnonymousEditable.start();
        AppMethodBeat.o(216082);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class a
        implements ValueAnimator.AnimatorUpdateListener
      {
        a(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(216074);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(216074);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.gYd.gYc);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = d.h.a.cm(f);
          TextView localTextView = z.l(this.gYd.gYc);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.gYd.gYc);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.gYd.gYc));
          AppMethodBeat.o(216074);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class b
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(216076);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.gYd.gYc);
          TextView localTextView = z.l(this.gYd.gYc);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(216076);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(216075);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.gYd.gYc);
          TextView localTextView = z.l(this.gYd.gYc);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(216075);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(216077);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(216077);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class c
        implements ValueAnimator.AnimatorUpdateListener
      {
        c(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(216078);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(216078);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.gYd.gYc);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = d.h.a.cm(f);
          TextView localTextView = z.l(this.gYd.gYc);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.gYd.gYc);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.gYd.gYc));
          AppMethodBeat.o(216078);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class d
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(216080);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(216080);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(216079);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(216079);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(216081);
          paramAnimator = z.l(this.gYd.gYc);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(216081);
        }
      }
    });
    if (aoA())
    {
      paramb = this.gXR;
      p.g(paramb, "inputParent");
      paramb = paramb.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216107);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.en(paramViewGroup.getContext()));
    }
    this.gXT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216084);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = com.tencent.mm.live.b.g.gQZ;
        if (com.tencent.mm.live.b.g.anT()) {
          new com.tencent.mm.ui.widget.a.f.a(z.d(this.gYc)).fQD().au((CharSequence)z.d(this.gYc).getResources().getString(2131766579)).afY(2131755792).b((com.tencent.mm.ui.widget.a.f.c)z.3.1.gYe).show();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216084);
          return;
          paramAnonymousView = z.b(this.gYc);
          p.g(paramAnonymousView, "inputEt");
          if (paramAnonymousView.getText() != null)
          {
            z.m(this.gYc);
            paramAnonymousView = z.d(this.gYc);
            if (paramAnonymousView == null)
            {
              paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(216084);
              throw paramAnonymousView;
            }
            ((MMActivity)paramAnonymousView).hideVKB();
            z.n(this.gYc);
            paramAnonymousView = z.b(this.gYc);
            p.g(paramAnonymousView, "inputEt");
            paramAnonymousView = paramAnonymousView.getText();
            localObject = z.b(this.gYc);
            p.g(localObject, "inputEt");
            ((MMEditText)localObject).setText(null);
            localObject = i.gRP;
            paramAnonymousView = paramAnonymousView.toString();
            localObject = com.tencent.mm.live.b.f.c.gPJ;
            i.Y(paramAnonymousView, com.tencent.mm.live.b.f.c.anm());
            b.b.a(z.c(this.gYc), b.c.gUC);
            if (z.c(this.gYc).getLiveRole() == 0) {
              com.tencent.mm.live.d.f.aqv();
            }
          }
        }
      }
    });
    this.gXP.setOnClickListener((View.OnClickListener)z.4.gYf);
    this.gXV.setOnClickListener((View.OnClickListener)new z.5(this));
    this.gXW.setEntranceScene(ChatFooterPanel.FkW);
    this.gXW.fft();
    this.gXW.ffv();
    this.gXW.ffu();
    this.gXW.setVisibility(4);
    this.gXW.onResume();
    this.gXW.setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    AppMethodBeat.o(216107);
  }
  
  private final void aoZ()
  {
    AppMethodBeat.i(216097);
    if (this.gXZ != this.gXO)
    {
      AppMethodBeat.o(216097);
      return;
    }
    ImageView localImageView = this.gXU;
    Context localContext = this.gJt.getContext();
    p.g(localContext, "root.context");
    localImageView.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131690482), -1));
    this.gXW.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(216097);
  }
  
  private final void apa()
  {
    AppMethodBeat.i(216098);
    this.gXZ = this.gXM;
    this.gJt.setVisibility(4);
    this.gXS.clearFocus();
    Object localObject = this.gJt.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(216098);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.gXS;
    p.g(localMMEditText, "inputEt");
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localMMEditText.getWindowToken(), 0);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_IS_ENTERING_COMMENT", false);
    this.gVv.a(b.c.gUE, (Bundle)localObject);
    AppMethodBeat.o(216098);
  }
  
  private final void nN(int paramInt)
  {
    AppMethodBeat.i(216101);
    Object localObject1;
    Object localObject2;
    if ((this.gJt.getContext() instanceof Activity))
    {
      localObject1 = this.gXR;
      p.g(localObject1, "inputParent");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(216101);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject1;
      if (aoA()) {
        break label268;
      }
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = (ar.en(this.context) + paramInt);
      localObject2 = this.gXR;
      p.g(localObject2, "inputParent");
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
      if (aoA()) {
        break label277;
      }
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = ar.en(this.context);
    }
    for (;;)
    {
      this.gXW.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.gXW.getParent() == null) {
        this.gXQ.addView((View)this.gXW, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = new Bundle();
      int i = apb().getHeight();
      int j = ar.en(this.gJt.getContext());
      localObject2 = this.gXP;
      p.g(localObject2, "inputLayout");
      ((Bundle)localObject1).putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + paramInt + j + ((LinearLayout)localObject2).getPaddingBottom());
      this.gVv.a(b.c.gVd, (Bundle)localObject1);
      AppMethodBeat.o(216101);
      return;
      label268:
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt;
      break;
      label277:
      ((LinearLayout.LayoutParams)localObject1).setMarginEnd(ar.en(this.context));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216099);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (aa.cqt[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(216099);
        return;
        nL(8);
        AppMethodBeat.o(216099);
        return;
        AppMethodBeat.o(216099);
        return;
        if (paramBundle == null) {
          break;
        }
      } while (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") != true);
      this.gJt.setVisibility(0);
      paramc = this.gXU;
      paramBundle = this.gJt.getContext();
      p.g(paramBundle, "root.context");
      paramc.setImageDrawable(ao.e(paramBundle.getResources().getDrawable(2131690482), -1));
      this.gXS.requestFocus();
      paramc = (InputMethodManager)this.gJt.getContext().getSystemService("input_method");
    } while (paramc == null);
    paramc.showSoftInput((View)this.gXS, 0);
    AppMethodBeat.o(216099);
    return;
    AppMethodBeat.o(216099);
  }
  
  public final void aoO()
  {
    AppMethodBeat.i(216103);
    super.aoO();
    Object localObject = this.gXT;
    p.g(localObject, "sendBtn");
    localObject = ((TextView)localObject).getText();
    TextView localTextView = this.gXT;
    p.g(localTextView, "sendBtn");
    int i = (int)StaticLayout.getDesiredWidth((CharSequence)localObject, localTextView.getPaint());
    int j = aq.ay(this.context, 2131165299);
    localObject = this.gXT;
    p.g(localObject, "sendBtn");
    int k = ((TextView)localObject).getPaddingStart();
    localObject = this.gXT;
    p.g(localObject, "sendBtn");
    this.gXX = j.lw(j, i + k + ((TextView)localObject).getPaddingEnd());
    localObject = com.tencent.mm.kernel.g.ajQ();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).ajj().a(904, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(216103);
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216104);
    super.aoP();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(904, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(216104);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(216105);
    if (this.gJt.getVisibility() == 0)
    {
      if (this.gXZ == this.gXO)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.gXW.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        this.gXZ = this.gXM;
        nN(0);
      }
      for (;;)
      {
        AppMethodBeat.o(216105);
        return true;
        apa();
      }
    }
    boolean bool = super.aoQ();
    AppMethodBeat.o(216105);
    return bool;
  }
  
  public final View apb()
  {
    AppMethodBeat.i(216102);
    View localView = this.gXR;
    p.g(localView, "inputParent");
    AppMethodBeat.o(216102);
    return localView;
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(216100);
    super.i(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      if (this.gXZ == this.gXN)
      {
        this.gXZ = this.gXM;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.gXW.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        nN(0);
        AppMethodBeat.o(216100);
      }
    }
    else
    {
      this.gXZ = this.gXN;
      aoZ();
      nN(paramInt);
    }
    AppMethodBeat.o(216100);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(216106);
    if (((paramn instanceof s)) && (paramInt2 == -100065))
    {
      paramString = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.anU();
      c.h((d.g.a.a)new z.e(this));
    }
    AppMethodBeat.o(216106);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class b
    implements InputFilter
  {
    b(z paramz) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(216089);
      paramSpanned = z.b(this.gYc);
      p.g(paramSpanned, "inputEt");
      paramSpanned.getText();
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(216089);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(216089);
        return paramCharSequence;
      }
      AppMethodBeat.o(216089);
      return null;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-logic_release"})
  public static final class c
    extends com.tencent.mm.ui.tools.f
  {
    c(com.tencent.mm.ui.tools.f.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(216090);
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
        paramInt2 = com.tencent.mm.ui.tools.f.a(String.valueOf(localCharSequence), com.tencent.mm.ui.tools.f.a.Lfh);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label204;
        }
      }
      label183:
      label189:
      label204:
      for (paramInt3 = com.tencent.mm.ui.tools.f.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), com.tencent.mm.ui.tools.f.a.Lfh);; paramInt3 = 0)
      {
        paramInt4 = com.tencent.mm.ui.tools.f.a(String.valueOf(paramCharSequence), com.tencent.mm.ui.tools.f.a.Lfh);
        int i = com.tencent.mm.ui.tools.f.aYM(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
          break label228;
        }
        paramInt2 = j.lw(120 - paramInt2 - paramInt3 - i, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label210;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(216090);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = com.tencent.mm.ui.tools.f.a(String.valueOf(paramSpanned), com.tencent.mm.ui.tools.f.a.Lfh);
        break label53;
      }
      label210:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(216090);
      return paramCharSequence;
      label228:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(216090);
        return paramCharSequence;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(216091);
      z.a(this.gYc).setAlpha(1.0F);
      z.a(this.gYc).setVisibility(4);
      AppMethodBeat.o(216091);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-logic_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void apc()
    {
      AppMethodBeat.i(216095);
      Object localObject = z.b(this.gYc);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = z.b(this.gYc);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(216095);
          return;
        }
      }
      AppMethodBeat.o(216095);
    }
    
    public final void apd() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(216094);
      MMEditText localMMEditText = z.b(this.gYc);
      if (localMMEditText != null) {
        localMMEditText.aZf(paramString);
      }
      if (z.c(this.gYc).getLiveRole() == 0) {
        com.tencent.mm.live.d.f.aqw();
      }
      AppMethodBeat.o(216094);
    }
    
    public final void dW(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.z
 * JD-Core Version:    0.7.0.1
 */