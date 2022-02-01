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
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.aa;
import com.tencent.mm.live.b.e.c;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "replyBtnWidth", "", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "changeToInputMode", "", "changeToPreviewMode", "keyboardChange", "show", "height", "layoutInputView", "onBackPress", "onHideSmileyPanel", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class z
  extends a
{
  public static final a KvG;
  private final b IIs;
  private final LinearLayout KvA;
  private final View KvB;
  private final MMEditText KvC;
  private final TextView KvD;
  private final ImageView KvE;
  private final TextView KvF;
  private final LinearLayout Kvz;
  private Context context;
  private SmileyPanel qVT;
  private int qWg;
  private boolean qWh;
  
  static
  {
    AppMethodBeat.i(202970);
    KvG = new a((byte)0);
    AppMethodBeat.o(202970);
  }
  
  public z(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202969);
    this.IIs = paramb;
    this.Kvz = ((LinearLayout)paramViewGroup.findViewById(2131307556));
    this.KvA = ((LinearLayout)paramViewGroup.findViewById(2131307540));
    this.KvB = paramViewGroup.findViewById(2131307557);
    this.KvC = ((MMEditText)paramViewGroup.findViewById(2131307559));
    this.KvD = ((TextView)paramViewGroup.findViewById(2131307690));
    this.KvE = ((ImageView)paramViewGroup.findViewById(2131307553));
    this.KvF = ((TextView)paramViewGroup.findViewById(2131307517));
    paramb = aa.k(paramViewGroup.getContext(), false);
    k.g(paramb, "SmileyPanelFactory.getSm…anel(root.context, false)");
    this.qVT = paramb;
    paramb = paramViewGroup.getContext();
    k.g(paramb, "root.context");
    this.context = paramb;
    this.qWg = ao.ap(this.context, 2131165299);
    paramb = this.KvE;
    k.g(paramb, "inputEmoji");
    paramb.setTag(Boolean.FALSE);
    paramb = this.KvE;
    Context localContext = paramViewGroup.getContext();
    k.g(localContext, "root.context");
    paramb.setImageDrawable(am.e(localContext.getResources().getDrawable(2131690482), -1));
    this.KvE.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202946);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(202946);
          throw paramAnonymousView;
        }
        paramAnonymousView = ((ImageView)paramAnonymousView).getTag();
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(202946);
          throw paramAnonymousView;
        }
        if (!((Boolean)paramAnonymousView).booleanValue()) {}
        for (boolean bool = true;; bool = false)
        {
          z.a(this.KvH, bool);
          AppMethodBeat.o(202946);
          return;
        }
      }
    });
    paramb = this.KvC;
    k.g(paramb, "inputEt");
    paramb.setFilters(new InputFilter[] { (InputFilter)new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(202947);
        paramAnonymousCharSequence = String.valueOf(paramAnonymousCharSequence);
        paramAnonymousSpanned = (CharSequence)"\n";
        if (paramAnonymousCharSequence == null)
        {
          paramAnonymousCharSequence = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(202947);
          throw paramAnonymousCharSequence;
        }
        if (paramAnonymousCharSequence.contentEquals(paramAnonymousSpanned))
        {
          paramAnonymousCharSequence = (CharSequence)"";
          AppMethodBeat.o(202947);
          return paramAnonymousCharSequence;
        }
        AppMethodBeat.o(202947);
        return null;
      }
    }, (InputFilter)new InputFilter.LengthFilter(100) });
    this.KvC.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(202956);
        int i;
        if (paramAnonymousEditable != null) {
          if (((CharSequence)paramAnonymousEditable).length() > 0) {
            i = 1;
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            paramAnonymousEditable = String.valueOf(paramAnonymousEditable);
            if (paramAnonymousEditable == null)
            {
              paramAnonymousEditable = new v("null cannot be cast to non-null type kotlin.CharSequence");
              AppMethodBeat.o(202956);
              throw paramAnonymousEditable;
              i = 0;
              continue;
              i = 0;
            }
            else if (((CharSequence)n.trim((CharSequence)paramAnonymousEditable).toString()).length() > 0)
            {
              i = 1;
              if (i == 0) {
                break label114;
              }
            }
          }
        }
        label114:
        for (boolean bool = true;; bool = false)
        {
          if (bool != z.d(this.KvH)) {
            break label119;
          }
          AppMethodBeat.o(202956);
          return;
          i = 0;
          break;
        }
        label119:
        z.b(this.KvH, bool);
        if (z.d(this.KvH))
        {
          paramAnonymousEditable = z.e(this.KvH);
          k.g(paramAnonymousEditable, "inputEmoji");
          paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(202956);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cd.a.ao(paramViewGroup.getContext(), 2131165284));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, z.f(this.KvH) });
          paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this));
          paramAnonymousEditable.start();
          AppMethodBeat.o(202956);
          return;
        }
        paramAnonymousEditable = z.e(this.KvH);
        k.g(paramAnonymousEditable, "inputEmoji");
        paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(202956);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cd.a.ao(paramViewGroup.getContext(), 2131165289));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { z.f(this.KvH), 0 });
        paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new d(this));
        paramAnonymousEditable.start();
        AppMethodBeat.o(202956);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class a
        implements ValueAnimator.AnimatorUpdateListener
      {
        a(z.3 param3) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(202948);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(202948);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.g(this.KvI.KvH);
          k.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = d.h.a.bU(f);
          TextView localTextView = z.g(this.KvI.KvH);
          k.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.g(this.KvI.KvH);
          k.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.f(this.KvI.KvH));
          AppMethodBeat.o(202948);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveInputPlugin$3$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class b
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(202950);
          paramAnimator = z.g(this.KvI.KvH);
          k.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.f(this.KvI.KvH);
          TextView localTextView = z.g(this.KvI.KvH);
          k.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.g(this.KvI.KvH);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(202950);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(202949);
          paramAnimator = z.g(this.KvI.KvH);
          k.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.f(this.KvI.KvH);
          TextView localTextView = z.g(this.KvI.KvH);
          k.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.g(this.KvI.KvH);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(202949);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(202951);
          paramAnimator = z.g(this.KvI.KvH);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(202951);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class c
        implements ValueAnimator.AnimatorUpdateListener
      {
        c(z.3 param3) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(202952);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(202952);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.g(this.KvI.KvH);
          k.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = d.h.a.bU(f);
          TextView localTextView = z.g(this.KvI.KvH);
          k.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.g(this.KvI.KvH);
          k.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.f(this.KvI.KvH));
          AppMethodBeat.o(202952);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveInputPlugin$3$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class d
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(202954);
          paramAnimator = z.g(this.KvI.KvH);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(202954);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(202953);
          paramAnimator = z.g(this.KvI.KvH);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(202953);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(202955);
          paramAnimator = z.g(this.KvI.KvH);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(202955);
        }
      }
    });
    this.KvD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202957);
        paramAnonymousView = z.b(this.KvH);
        k.g(paramAnonymousView, "inputEt");
        if (paramAnonymousView.getText() != null)
        {
          z.h(this.KvH);
          paramAnonymousView = z.i(this.KvH);
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(202957);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          z.j(this.KvH);
          paramAnonymousView = z.b(this.KvH);
          k.g(paramAnonymousView, "inputEt");
          paramAnonymousView = paramAnonymousView.getText();
          Object localObject = z.b(this.KvH);
          k.g(localObject, "inputEt");
          ((MMEditText)localObject).setText(null);
          localObject = h.xfu;
          paramAnonymousView = paramAnonymousView.toString();
          localObject = e.c.qYs;
          h.gQ(paramAnonymousView, e.c.ema());
          b.b.a(z.c(this.KvH), b.c.FBt);
          if (z.c(this.KvH).getLiveRole() == 0) {
            f.fQh();
          }
        }
        AppMethodBeat.o(202957);
      }
    });
    this.KvF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202958);
        z.h(this.KvH);
        paramAnonymousView = z.i(this.KvH);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(202958);
          throw paramAnonymousView;
        }
        ((MMActivity)paramAnonymousView).hideVKB();
        z.j(this.KvH);
        AppMethodBeat.o(202958);
      }
    });
    this.qVT.setEntranceScene(ChatFooterPanel.Lwx);
    this.qVT.exn();
    this.qVT.exp();
    this.qVT.exo();
    this.qVT.setVisibility(4);
    this.qVT.onResume();
    this.qVT.setOnTextOperationListener((ChatFooterPanel.a)new c(this));
    AppMethodBeat.o(202969);
  }
  
  private final void csT()
  {
    AppMethodBeat.i(202964);
    ImageView localImageView = this.KvE;
    k.g(localImageView, "inputEmoji");
    if (k.g(localImageView.getTag(), Boolean.FALSE))
    {
      AppMethodBeat.o(202964);
      return;
    }
    localImageView = this.KvE;
    Context localContext = this.pTc.getContext();
    k.g(localContext, "root.context");
    localImageView.setImageDrawable(am.e(localContext.getResources().getDrawable(2131690482), -1));
    localImageView = this.KvE;
    k.g(localImageView, "inputEmoji");
    localImageView.setTag(Boolean.FALSE);
    this.qVT.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new b(this)).start();
    AppMethodBeat.o(202964);
  }
  
  private final void fOV()
  {
    AppMethodBeat.i(202965);
    Object localObject = this.KvE;
    k.g(localObject, "inputEmoji");
    if (k.g(((ImageView)localObject).getTag(), Boolean.TRUE))
    {
      AppMethodBeat.o(202965);
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("mode", "preview");
    this.IIs.a(b.c.IId, (Bundle)localObject);
    localObject = this.Kvz;
    k.g(localObject, "inputLayout");
    ((LinearLayout)localObject).setVisibility(4);
    this.KvC.clearFocus();
    localObject = this.pTc.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(202965);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.KvC;
    k.g(localMMEditText, "inputEt");
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localMMEditText.getWindowToken(), 0);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_IS_ENTERING_COMMENT", false);
    this.IIs.a(b.c.FJZ, (Bundle)localObject);
    AppMethodBeat.o(202965);
  }
  
  public final void X(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(202967);
    super.X(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      fOV();
      AppMethodBeat.o(202967);
      return;
    }
    csT();
    if ((this.pTc.getContext() instanceof Activity))
    {
      Object localObject = this.KvB;
      k.g(localObject, "inputParent");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(202967);
        throw ((Throwable)localObject);
      }
      ((LinearLayout.LayoutParams)localObject).bottomMargin = (ap.eb(this.context) + paramInt);
      View localView = this.KvB;
      k.g(localView, "inputParent");
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.qVT.getParent() == null)
      {
        localObject = new LinearLayout.LayoutParams(-1, paramInt);
        this.qVT.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.KvA.addView((View)this.qVT, (ViewGroup.LayoutParams)localObject);
      }
    }
    AppMethodBeat.o(202967);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202966);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (aa.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202966);
      return;
      agK(8);
      AppMethodBeat.o(202966);
      return;
      agK(0);
      AppMethodBeat.o(202966);
      return;
      if (paramBundle != null) {}
      for (paramc = paramBundle.getString("mode"); paramc == null; paramc = null)
      {
        AppMethodBeat.o(202966);
        return;
      }
      switch (paramc.hashCode())
      {
      default: 
        break;
      case 100358090: 
        if (paramc.equals("input"))
        {
          paramc = this.Kvz;
          k.g(paramc, "inputLayout");
          paramc.setVisibility(0);
          this.KvC.requestFocus();
          paramc = (InputMethodManager)this.pTc.getContext().getSystemService("input_method");
          if (paramc != null) {
            paramc.showSoftInput((View)this.KvC, 0);
          }
          paramc = new Bundle();
          paramc.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
          this.IIs.a(b.c.FJZ, paramc);
        }
        break;
      }
    }
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(202968);
    LinearLayout localLinearLayout = this.Kvz;
    k.g(localLinearLayout, "inputLayout");
    if (localLinearLayout.getVisibility() == 0)
    {
      fOV();
      AppMethodBeat.o(202968);
      return true;
    }
    AppMethodBeat.o(202968);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveInputPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(202960);
      z.a(this.KvH).setAlpha(1.0F);
      z.a(this.KvH).setVisibility(4);
      AppMethodBeat.o(202960);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-logic_release"})
  public static final class c
    implements ChatFooterPanel.a
  {
    public final void append(String paramString)
    {
      AppMethodBeat.i(202961);
      MMEditText localMMEditText = z.b(this.KvH);
      if (localMMEditText != null) {
        localMMEditText.aMd(paramString);
      }
      if (z.c(this.KvH).getLiveRole() == 0) {
        f.fQi();
      }
      AppMethodBeat.o(202961);
    }
    
    public final void btF()
    {
      AppMethodBeat.i(202962);
      Object localObject = z.b(this.KvH);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = z.b(this.KvH);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(202962);
          return;
        }
      }
      AppMethodBeat.o(202962);
    }
    
    public final void cqY() {}
    
    public final void lf(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.z
 * JD-Core Version:    0.7.0.1
 */