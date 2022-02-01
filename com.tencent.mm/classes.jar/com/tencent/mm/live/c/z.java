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
import com.tencent.mm.ad.c;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.aa;
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
import d.k.h;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "changeToInputMode", "", "changeToPreviewMode", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class z
  extends a
  implements com.tencent.mm.al.f
{
  public static final z.a gVs;
  private Context context;
  private final b gSM;
  private final int gVd;
  private final int gVe;
  private final int gVf;
  private final LinearLayout gVg;
  private final LinearLayout gVh;
  private final View gVi;
  private final MMEditText gVj;
  private final TextView gVk;
  private final ImageView gVl;
  private final TextView gVm;
  private SmileyPanel gVn;
  private int gVo;
  private boolean gVp;
  private int gVq;
  private int gVr;
  
  static
  {
    AppMethodBeat.i(212488);
    gVs = new z.a((byte)0);
    AppMethodBeat.o(212488);
  }
  
  public z(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212487);
    this.gSM = paramb;
    this.gVe = 1;
    this.gVf = 2;
    this.gVg = ((LinearLayout)paramViewGroup.findViewById(2131307640));
    this.gVh = ((LinearLayout)paramViewGroup.findViewById(2131307621));
    this.gVi = paramViewGroup.findViewById(2131307641);
    this.gVj = ((MMEditText)paramViewGroup.findViewById(2131307643));
    this.gVk = ((TextView)paramViewGroup.findViewById(2131307769));
    this.gVl = ((ImageView)paramViewGroup.findViewById(2131307637));
    this.gVm = ((TextView)paramViewGroup.findViewById(2131307598));
    paramb = aa.k(paramViewGroup.getContext(), false);
    p.g(paramb, "SmileyPanelFactory.getSm…anel(root.context, false)");
    this.gVn = paramb;
    paramb = paramViewGroup.getContext();
    p.g(paramb, "root.context");
    this.context = paramb;
    this.gVq = this.gVd;
    this.gVq = this.gVd;
    paramb = this.gVl;
    Object localObject = paramViewGroup.getContext();
    p.g(localObject, "root.context");
    paramb.setImageDrawable(ao.e(((Context)localObject).getResources().getDrawable(2131690482), -1));
    this.gVl.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212453);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (z.e(this.gVt) != z.f(this.gVt)) {}
        for (boolean bool = true;; bool = false)
        {
          z.a(this.gVt, bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212453);
          return;
        }
      }
    });
    paramb = (InputFilter)new b(this);
    localObject = (InputFilter)new c(com.tencent.mm.ui.tools.f.a.KIN);
    MMEditText localMMEditText = this.gVj;
    p.g(localMMEditText, "inputEt");
    localMMEditText.setFilters(new InputFilter[] { paramb, localObject });
    this.gVj.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(212462);
        int i;
        if ((z.g(this.gVt) == 0) || (z.g(this.gVt) != this.gVt.aoN().getHeight()))
        {
          z.a(this.gVt, this.gVt.aoN().getHeight());
          paramAnonymousEditable = new Bundle();
          i = com.tencent.mm.sdk.platformtools.z.iF(z.d(this.gVt));
          int j = this.gVt.aoN().getHeight();
          int k = ar.ej(paramViewGroup.getContext());
          LinearLayout localLinearLayout = z.h(this.gVt);
          p.g(localLinearLayout, "inputLayout");
          paramAnonymousEditable.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + j + k + localLinearLayout.getPaddingBottom());
          z.c(this.gVt).a(b.c.gSv, paramAnonymousEditable);
        }
        paramAnonymousEditable = z.b(this.gVt);
        p.g(paramAnonymousEditable, "inputEt");
        paramAnonymousEditable = paramAnonymousEditable.getText();
        if (paramAnonymousEditable != null) {
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label265;
            }
            paramAnonymousEditable = z.b(this.gVt);
            p.g(paramAnonymousEditable, "inputEt");
            paramAnonymousEditable = paramAnonymousEditable.getText();
            if (paramAnonymousEditable == null) {
              break label260;
            }
            if (d.n.n.aE((CharSequence)paramAnonymousEditable)) {
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
          if (bool != z.i(this.gVt)) {
            break label271;
          }
          AppMethodBeat.o(212462);
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
        z.b(this.gVt, bool);
        if (z.i(this.gVt))
        {
          paramAnonymousEditable = z.j(this.gVt);
          p.g(paramAnonymousEditable, "inputEmoji");
          paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(212462);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cc.a.ax(paramViewGroup.getContext(), 2131165284));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, z.k(this.gVt) });
          paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this));
          paramAnonymousEditable.start();
          AppMethodBeat.o(212462);
          return;
        }
        paramAnonymousEditable = z.j(this.gVt);
        p.g(paramAnonymousEditable, "inputEmoji");
        paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(212462);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cc.a.ax(paramViewGroup.getContext(), 2131165289));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { z.k(this.gVt), 0 });
        paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new d(this));
        paramAnonymousEditable.start();
        AppMethodBeat.o(212462);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class a
        implements ValueAnimator.AnimatorUpdateListener
      {
        a(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(212454);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(212454);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.gVu.gVt);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = d.h.a.co(f);
          TextView localTextView = z.l(this.gVu.gVt);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.gVu.gVt);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.gVu.gVt));
          AppMethodBeat.o(212454);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class b
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(212456);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.gVu.gVt);
          TextView localTextView = z.l(this.gVu.gVt);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(212456);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(212455);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.gVu.gVt);
          TextView localTextView = z.l(this.gVu.gVt);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(212455);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(212457);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(212457);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class c
        implements ValueAnimator.AnimatorUpdateListener
      {
        c(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(212458);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(212458);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.gVu.gVt);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = d.h.a.co(f);
          TextView localTextView = z.l(this.gVu.gVt);
          p.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.gVu.gVt);
          p.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.gVu.gVt));
          AppMethodBeat.o(212458);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class d
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(212460);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(212460);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(212459);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(212459);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(212461);
          paramAnimator = z.l(this.gVu.gVt);
          p.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(212461);
        }
      }
    });
    if (aol())
    {
      paramb = this.gVi;
      p.g(paramb, "inputParent");
      paramb = paramb.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212487);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.ej(paramViewGroup.getContext()));
    }
    this.gVk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212464);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = com.tencent.mm.live.b.g.gOr;
        if (com.tencent.mm.live.b.g.anE()) {
          new com.tencent.mm.ui.widget.a.f.a(z.d(this.gVt)).fMj().av((CharSequence)z.d(this.gVt).getResources().getString(2131766579)).afp(2131755792).b((com.tencent.mm.ui.widget.a.f.c)z.3.1.gVv).show();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212464);
          return;
          paramAnonymousView = z.b(this.gVt);
          p.g(paramAnonymousView, "inputEt");
          if (paramAnonymousView.getText() != null)
          {
            z.m(this.gVt);
            paramAnonymousView = z.d(this.gVt);
            if (paramAnonymousView == null)
            {
              paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(212464);
              throw paramAnonymousView;
            }
            ((MMActivity)paramAnonymousView).hideVKB();
            z.n(this.gVt);
            paramAnonymousView = z.b(this.gVt);
            p.g(paramAnonymousView, "inputEt");
            paramAnonymousView = paramAnonymousView.getText();
            localObject = z.b(this.gVt);
            p.g(localObject, "inputEt");
            ((MMEditText)localObject).setText(null);
            localObject = i.gPh;
            paramAnonymousView = paramAnonymousView.toString();
            localObject = com.tencent.mm.live.b.f.c.gNa;
            i.X(paramAnonymousView, com.tencent.mm.live.b.f.c.amX());
            b.b.a(z.c(this.gVt), b.c.gRU);
            if (z.c(this.gVt).getLiveRole() == 0) {
              com.tencent.mm.live.d.f.aqg();
            }
          }
        }
      }
    });
    this.gVg.setOnClickListener((View.OnClickListener)z.4.gVw);
    this.gVm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212467);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        z.m(this.gVt);
        paramAnonymousView = z.d(this.gVt);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(212467);
          throw paramAnonymousView;
        }
        ((MMActivity)paramAnonymousView).hideVKB();
        z.n(this.gVt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveInputPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212467);
      }
    });
    this.gVn.setEntranceScene(ChatFooterPanel.ESB);
    this.gVn.fbF();
    this.gVn.fbH();
    this.gVn.fbG();
    this.gVn.setVisibility(4);
    this.gVn.onResume();
    this.gVn.setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    AppMethodBeat.o(212487);
  }
  
  private final void aoL()
  {
    AppMethodBeat.i(212477);
    if (this.gVq != this.gVf)
    {
      AppMethodBeat.o(212477);
      return;
    }
    ImageView localImageView = this.gVl;
    Context localContext = this.gGK.getContext();
    p.g(localContext, "root.context");
    localImageView.setImageDrawable(ao.e(localContext.getResources().getDrawable(2131690482), -1));
    this.gVn.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(212477);
  }
  
  private final void aoM()
  {
    AppMethodBeat.i(212478);
    this.gVq = this.gVd;
    this.gGK.setVisibility(4);
    this.gVj.clearFocus();
    Object localObject = this.gGK.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(212478);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.gVj;
    p.g(localMMEditText, "inputEt");
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localMMEditText.getWindowToken(), 0);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_IS_ENTERING_COMMENT", false);
    this.gSM.a(b.c.gRW, (Bundle)localObject);
    AppMethodBeat.o(212478);
  }
  
  private final void nK(int paramInt)
  {
    AppMethodBeat.i(212481);
    Object localObject1;
    Object localObject2;
    if ((this.gGK.getContext() instanceof Activity))
    {
      localObject1 = this.gVi;
      p.g(localObject1, "inputParent");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(212481);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject1;
      if (aol()) {
        break label268;
      }
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = (ar.ej(this.context) + paramInt);
      localObject2 = this.gVi;
      p.g(localObject2, "inputParent");
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
      if (aol()) {
        break label277;
      }
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = ar.ej(this.context);
    }
    for (;;)
    {
      this.gVn.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.gVn.getParent() == null) {
        this.gVh.addView((View)this.gVn, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = new Bundle();
      int i = aoN().getHeight();
      int j = ar.ej(this.gGK.getContext());
      localObject2 = this.gVg;
      p.g(localObject2, "inputLayout");
      ((Bundle)localObject1).putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + paramInt + j + ((LinearLayout)localObject2).getPaddingBottom());
      this.gSM.a(b.c.gSv, (Bundle)localObject1);
      AppMethodBeat.o(212481);
      return;
      label268:
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt;
      break;
      label277:
      ((LinearLayout.LayoutParams)localObject1).setMarginEnd(ar.ej(this.context));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212479);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (aa.cpQ[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(212479);
        return;
        nI(8);
        AppMethodBeat.o(212479);
        return;
        AppMethodBeat.o(212479);
        return;
        if (paramBundle == null) {
          break;
        }
      } while (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") != true);
      this.gGK.setVisibility(0);
      paramc = this.gVl;
      paramBundle = this.gGK.getContext();
      p.g(paramBundle, "root.context");
      paramc.setImageDrawable(ao.e(paramBundle.getResources().getDrawable(2131690482), -1));
      this.gVj.requestFocus();
      paramc = (InputMethodManager)this.gGK.getContext().getSystemService("input_method");
    } while (paramc == null);
    paramc.showSoftInput((View)this.gVj, 0);
    AppMethodBeat.o(212479);
    return;
    AppMethodBeat.o(212479);
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212484);
    super.aoA();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(904, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(212484);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(212485);
    if (this.gGK.getVisibility() == 0)
    {
      if (this.gVq == this.gVf)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.gVn.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        this.gVq = this.gVd;
        nK(0);
      }
      for (;;)
      {
        AppMethodBeat.o(212485);
        return true;
        aoM();
      }
    }
    boolean bool = super.aoB();
    AppMethodBeat.o(212485);
    return bool;
  }
  
  public final View aoN()
  {
    AppMethodBeat.i(212482);
    View localView = this.gVi;
    p.g(localView, "inputParent");
    AppMethodBeat.o(212482);
    return localView;
  }
  
  public final void aoz()
  {
    AppMethodBeat.i(212483);
    super.aoz();
    Object localObject = this.gVk;
    p.g(localObject, "sendBtn");
    localObject = ((TextView)localObject).getText();
    TextView localTextView = this.gVk;
    p.g(localTextView, "sendBtn");
    int i = (int)StaticLayout.getDesiredWidth((CharSequence)localObject, localTextView.getPaint());
    int j = aq.ay(this.context, 2131165299);
    localObject = this.gVk;
    p.g(localObject, "sendBtn");
    int k = ((TextView)localObject).getPaddingStart();
    localObject = this.gVk;
    p.g(localObject, "sendBtn");
    this.gVo = h.lp(j, i + k + ((TextView)localObject).getPaddingEnd());
    localObject = com.tencent.mm.kernel.g.ajB();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aiU().a(904, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(212483);
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(212480);
    super.i(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      if (this.gVq == this.gVe)
      {
        this.gVq = this.gVd;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.gVn.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        nK(0);
        AppMethodBeat.o(212480);
      }
    }
    else
    {
      this.gVq = this.gVe;
      aoL();
      nK(paramInt);
    }
    AppMethodBeat.o(212480);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(212486);
    if (((paramn instanceof s)) && (paramInt2 == -100065))
    {
      paramString = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.anF();
      c.g((d.g.a.a)new e(this));
    }
    AppMethodBeat.o(212486);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class b
    implements InputFilter
  {
    b(z paramz) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(212469);
      paramSpanned = z.b(this.gVt);
      p.g(paramSpanned, "inputEt");
      paramSpanned.getText();
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(212469);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(212469);
        return paramCharSequence;
      }
      AppMethodBeat.o(212469);
      return null;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-logic_release"})
  public static final class c
    extends com.tencent.mm.ui.tools.f
  {
    c(com.tencent.mm.ui.tools.f.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(212470);
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
        paramInt2 = com.tencent.mm.ui.tools.f.a(String.valueOf(localCharSequence), com.tencent.mm.ui.tools.f.a.KIN);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label204;
        }
      }
      label183:
      label189:
      label204:
      for (paramInt3 = com.tencent.mm.ui.tools.f.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), com.tencent.mm.ui.tools.f.a.KIN);; paramInt3 = 0)
      {
        paramInt4 = com.tencent.mm.ui.tools.f.a(String.valueOf(paramCharSequence), com.tencent.mm.ui.tools.f.a.KIN);
        int i = com.tencent.mm.ui.tools.f.aXl(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
          break label228;
        }
        paramInt2 = h.lp(120 - paramInt2 - paramInt3 - i, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label210;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(212470);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = com.tencent.mm.ui.tools.f.a(String.valueOf(paramSpanned), com.tencent.mm.ui.tools.f.a.KIN);
        break label53;
      }
      label210:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(212470);
      return paramCharSequence;
      label228:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(212470);
        return paramCharSequence;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(212471);
      z.a(this.gVt).setAlpha(1.0F);
      z.a(this.gVt).setVisibility(4);
      AppMethodBeat.o(212471);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    e(z paramz)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-logic_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void aoO()
    {
      AppMethodBeat.i(212475);
      Object localObject = z.b(this.gVt);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = z.b(this.gVt);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(212475);
          return;
        }
      }
      AppMethodBeat.o(212475);
    }
    
    public final void aoP() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(212474);
      MMEditText localMMEditText = z.b(this.gVt);
      if (localMMEditText != null) {
        localMMEditText.aXD(paramString);
      }
      if (z.c(this.gVt).getLiveRole() == 0) {
        com.tencent.mm.live.d.f.aqh();
      }
      AppMethodBeat.o(212474);
    }
    
    public final void dU(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.z
 * JD-Core Version:    0.7.0.1
 */