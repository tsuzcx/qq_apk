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
import com.tencent.mm.api.aa;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.k;
import d.k.h;
import d.v;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveInputPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "cancelView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "lastEditHeight", "replyBtnWidth", "sendBtn", "sendBtnEnabled", "", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "changeToInputMode", "", "changeToPreviewMode", "getEditPanel", "keyboardChange", "show", "height", "layoutInputView", "mount", "onBackPress", "onHideSmileyPanel", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "setupEmojiPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class z
  extends a
  implements com.tencent.mm.ak.g
{
  public static final z.a gBI;
  private Context context;
  private final TextView gBA;
  private final ImageView gBB;
  private final TextView gBC;
  private SmileyPanel gBD;
  private int gBE;
  private boolean gBF;
  private int gBG;
  private int gBH;
  private final int gBt;
  private final int gBu;
  private final int gBv;
  private final LinearLayout gBw;
  private final LinearLayout gBx;
  private final View gBy;
  private final MMEditText gBz;
  private final b gzb;
  
  static
  {
    AppMethodBeat.i(190198);
    gBI = new z.a((byte)0);
    AppMethodBeat.o(190198);
  }
  
  public z(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190197);
    this.gzb = paramb;
    this.gBu = 1;
    this.gBv = 2;
    this.gBw = ((LinearLayout)paramViewGroup.findViewById(2131307640));
    this.gBx = ((LinearLayout)paramViewGroup.findViewById(2131307621));
    this.gBy = paramViewGroup.findViewById(2131307641);
    this.gBz = ((MMEditText)paramViewGroup.findViewById(2131307643));
    this.gBA = ((TextView)paramViewGroup.findViewById(2131307769));
    this.gBB = ((ImageView)paramViewGroup.findViewById(2131307637));
    this.gBC = ((TextView)paramViewGroup.findViewById(2131307598));
    paramb = aa.k(paramViewGroup.getContext(), false);
    k.g(paramb, "SmileyPanelFactory.getSm…anel(root.context, false)");
    this.gBD = paramb;
    paramb = paramViewGroup.getContext();
    k.g(paramb, "root.context");
    this.context = paramb;
    this.gBG = this.gBt;
    this.gBG = this.gBt;
    paramb = this.gBB;
    Object localObject = paramViewGroup.getContext();
    k.g(localObject, "root.context");
    paramb.setImageDrawable(am.e(((Context)localObject).getResources().getDrawable(2131690482), -1));
    this.gBB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190164);
        if (z.e(this.gBJ) != z.f(this.gBJ)) {}
        for (boolean bool = true;; bool = false)
        {
          z.a(this.gBJ, bool);
          AppMethodBeat.o(190164);
          return;
        }
      }
    });
    paramb = (InputFilter)new b(this);
    localObject = (InputFilter)new z.c(com.tencent.mm.ui.tools.f.a.IRJ);
    MMEditText localMMEditText = this.gBz;
    k.g(localMMEditText, "inputEt");
    localMMEditText.setFilters(new InputFilter[] { paramb, localObject });
    this.gBz.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(190173);
        int i;
        if ((z.g(this.gBJ) == 0) || (z.g(this.gBJ) != this.gBJ.ama().getHeight()))
        {
          z.a(this.gBJ, this.gBJ.ama().getHeight());
          paramAnonymousEditable = new Bundle();
          i = com.tencent.mm.sdk.platformtools.y.iv(z.d(this.gBJ));
          int j = this.gBJ.ama().getHeight();
          int k = ap.ej(paramViewGroup.getContext());
          LinearLayout localLinearLayout = z.h(this.gBJ);
          k.g(localLinearLayout, "inputLayout");
          paramAnonymousEditable.putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + j + k + localLinearLayout.getPaddingBottom());
          z.c(this.gBJ).a(b.c.gyK, paramAnonymousEditable);
        }
        paramAnonymousEditable = z.b(this.gBJ);
        k.g(paramAnonymousEditable, "inputEt");
        paramAnonymousEditable = paramAnonymousEditable.getText();
        if (paramAnonymousEditable != null) {
          if (((CharSequence)paramAnonymousEditable).length() > 0)
          {
            i = 1;
            if (i == 0) {
              break label265;
            }
            paramAnonymousEditable = z.b(this.gBJ);
            k.g(paramAnonymousEditable, "inputEt");
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
          if (bool != z.i(this.gBJ)) {
            break label271;
          }
          AppMethodBeat.o(190173);
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
        z.b(this.gBJ, bool);
        if (z.i(this.gBJ))
        {
          paramAnonymousEditable = z.j(this.gBJ);
          k.g(paramAnonymousEditable, "inputEmoji");
          paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
          if (paramAnonymousEditable == null)
          {
            paramAnonymousEditable = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(190173);
            throw paramAnonymousEditable;
          }
          ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cc.a.au(paramViewGroup.getContext(), 2131165284));
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, z.k(this.gBJ) });
          paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this));
          paramAnonymousEditable.start();
          AppMethodBeat.o(190173);
          return;
        }
        paramAnonymousEditable = z.j(this.gBJ);
        k.g(paramAnonymousEditable, "inputEmoji");
        paramAnonymousEditable = paramAnonymousEditable.getLayoutParams();
        if (paramAnonymousEditable == null)
        {
          paramAnonymousEditable = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(190173);
          throw paramAnonymousEditable;
        }
        ((LinearLayout.LayoutParams)paramAnonymousEditable).setMarginStart(com.tencent.mm.cc.a.au(paramViewGroup.getContext(), 2131165289));
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { z.k(this.gBJ), 0 });
        paramAnonymousEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new d(this));
        paramAnonymousEditable.start();
        AppMethodBeat.o(190173);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class a
        implements ValueAnimator.AnimatorUpdateListener
      {
        a(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(190165);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(190165);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.gBK.gBJ);
          k.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = d.h.a.cj(f);
          TextView localTextView = z.l(this.gBK.gBJ);
          k.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.gBK.gBJ);
          k.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.gBK.gBJ));
          AppMethodBeat.o(190165);
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class b
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(190167);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.gBK.gBJ);
          TextView localTextView = z.l(this.gBK.gBJ);
          k.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(190167);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(190166);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator = paramAnimator.getLayoutParams();
          paramAnimator.width = z.k(this.gBK.gBJ);
          TextView localTextView = z.l(this.gBK.gBJ);
          k.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramAnimator);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setAlpha(1.0F);
          AppMethodBeat.o(190166);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(190168);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(190168);
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
      static final class c
        implements ValueAnimator.AnimatorUpdateListener
      {
        c(z.2 param2) {}
        
        public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
        {
          AppMethodBeat.i(190169);
          if (paramValueAnimator != null) {}
          for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
          {
            paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(190169);
            throw paramValueAnimator;
          }
          float f = ((Integer)paramValueAnimator).intValue();
          paramValueAnimator = z.l(this.gBK.gBJ);
          k.g(paramValueAnimator, "sendBtn");
          paramValueAnimator = paramValueAnimator.getLayoutParams();
          paramValueAnimator.width = d.h.a.cj(f);
          TextView localTextView = z.l(this.gBK.gBJ);
          k.g(localTextView, "sendBtn");
          localTextView.setLayoutParams(paramValueAnimator);
          paramValueAnimator = z.l(this.gBK.gBJ);
          k.g(paramValueAnimator, "sendBtn");
          paramValueAnimator.setAlpha(f / z.k(this.gBK.gBJ));
          AppMethodBeat.o(190169);
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveInputPlugin$2$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
      public static final class d
        implements Animator.AnimatorListener
      {
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(190171);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(190171);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(190170);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(8);
          AppMethodBeat.o(190170);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(190172);
          paramAnimator = z.l(this.gBK.gBJ);
          k.g(paramAnimator, "sendBtn");
          paramAnimator.setVisibility(0);
          AppMethodBeat.o(190172);
        }
      }
    });
    if (aly())
    {
      paramb = this.gBy;
      k.g(paramb, "inputParent");
      paramb = paramb.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190197);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ap.ej(paramViewGroup.getContext()));
    }
    this.gBA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190175);
        paramAnonymousView = com.tencent.mm.live.b.g.guG;
        if (com.tencent.mm.live.b.g.akR())
        {
          new com.tencent.mm.ui.widget.a.f.a(z.d(this.gBJ)).fvx().av((CharSequence)z.d(this.gBJ).getResources().getString(2131766579)).acQ(2131755792).b((com.tencent.mm.ui.widget.a.f.c)1.gBL).show();
          AppMethodBeat.o(190175);
          return;
        }
        paramAnonymousView = z.b(this.gBJ);
        k.g(paramAnonymousView, "inputEt");
        if (paramAnonymousView.getText() != null)
        {
          z.m(this.gBJ);
          paramAnonymousView = z.d(this.gBJ);
          if (paramAnonymousView == null)
          {
            paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(190175);
            throw paramAnonymousView;
          }
          ((MMActivity)paramAnonymousView).hideVKB();
          z.n(this.gBJ);
          paramAnonymousView = z.b(this.gBJ);
          k.g(paramAnonymousView, "inputEt");
          paramAnonymousView = paramAnonymousView.getText();
          Object localObject = z.b(this.gBJ);
          k.g(localObject, "inputEt");
          ((MMEditText)localObject).setText(null);
          localObject = i.gvw;
          paramAnonymousView = paramAnonymousView.toString();
          localObject = com.tencent.mm.live.b.f.c.gtp;
          i.T(paramAnonymousView, com.tencent.mm.live.b.f.c.akl());
          b.b.a(z.c(this.gBJ), b.c.gyj);
          if (z.c(this.gBJ).getLiveRole() == 0) {
            f.anu();
          }
        }
        AppMethodBeat.o(190175);
      }
    });
    this.gBw.setOnClickListener((View.OnClickListener)z.4.gBM);
    this.gBC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190177);
        z.m(this.gBJ);
        paramAnonymousView = z.d(this.gBJ);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(190177);
          throw paramAnonymousView;
        }
        ((MMActivity)paramAnonymousView).hideVKB();
        z.n(this.gBJ);
        AppMethodBeat.o(190177);
      }
    });
    this.gBD.setEntranceScene(ChatFooterPanel.Dnw);
    this.gBD.eMH();
    this.gBD.eMJ();
    this.gBD.eMI();
    this.gBD.setVisibility(4);
    this.gBD.onResume();
    this.gBD.setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    AppMethodBeat.o(190197);
  }
  
  private final void alY()
  {
    AppMethodBeat.i(190187);
    if (this.gBG != this.gBv)
    {
      AppMethodBeat.o(190187);
      return;
    }
    ImageView localImageView = this.gBB;
    Context localContext = this.gnb.getContext();
    k.g(localContext, "root.context");
    localImageView.setImageDrawable(am.e(localContext.getResources().getDrawable(2131690482), -1));
    this.gBD.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(190187);
  }
  
  private final void alZ()
  {
    AppMethodBeat.i(190188);
    this.gBG = this.gBt;
    this.gnb.setVisibility(4);
    this.gBz.clearFocus();
    Object localObject = this.gnb.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(190188);
      throw ((Throwable)localObject);
    }
    localObject = (InputMethodManager)localObject;
    MMEditText localMMEditText = this.gBz;
    k.g(localMMEditText, "inputEt");
    ((InputMethodManager)localObject).hideSoftInputFromWindow(localMMEditText.getWindowToken(), 0);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("PARAM_IS_ENTERING_COMMENT", false);
    this.gzb.a(b.c.gyl, (Bundle)localObject);
    AppMethodBeat.o(190188);
  }
  
  private final void nl(int paramInt)
  {
    AppMethodBeat.i(190191);
    Object localObject1;
    Object localObject2;
    if ((this.gnb.getContext() instanceof Activity))
    {
      localObject1 = this.gBy;
      k.g(localObject1, "inputParent");
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(190191);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject1;
      if (aly()) {
        break label268;
      }
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = (ap.ej(this.context) + paramInt);
      localObject2 = this.gBy;
      k.g(localObject2, "inputParent");
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
      if (aly()) {
        break label277;
      }
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = ap.ej(this.context);
    }
    for (;;)
    {
      this.gBD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.gBD.getParent() == null) {
        this.gBx.addView((View)this.gBD, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = new Bundle();
      int i = ama().getHeight();
      int j = ap.ej(this.gnb.getContext());
      localObject2 = this.gBw;
      k.g(localObject2, "inputLayout");
      ((Bundle)localObject1).putInt("PARAM_LIVE_COMMENT_OFFSET_HEIGHT", i + paramInt + j + ((LinearLayout)localObject2).getPaddingBottom());
      this.gzb.a(b.c.gyK, (Bundle)localObject1);
      AppMethodBeat.o(190191);
      return;
      label268:
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt;
      break;
      label277:
      ((LinearLayout.LayoutParams)localObject1).setMarginEnd(ap.ej(this.context));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190189);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (aa.cfA[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(190189);
        return;
        nj(8);
        AppMethodBeat.o(190189);
        return;
        AppMethodBeat.o(190189);
        return;
        if (paramBundle == null) {
          break;
        }
      } while (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") != true);
      this.gnb.setVisibility(0);
      paramc = this.gBB;
      paramBundle = this.gnb.getContext();
      k.g(paramBundle, "root.context");
      paramc.setImageDrawable(am.e(paramBundle.getResources().getDrawable(2131690482), -1));
      this.gBz.requestFocus();
      paramc = (InputMethodManager)this.gnb.getContext().getSystemService("input_method");
    } while (paramc == null);
    paramc.showSoftInput((View)this.gBz, 0);
    AppMethodBeat.o(190189);
    return;
    AppMethodBeat.o(190189);
  }
  
  public final void alM()
  {
    AppMethodBeat.i(190193);
    super.alM();
    Object localObject = this.gBA;
    k.g(localObject, "sendBtn");
    localObject = ((TextView)localObject).getText();
    TextView localTextView = this.gBA;
    k.g(localTextView, "sendBtn");
    int i = (int)StaticLayout.getDesiredWidth((CharSequence)localObject, localTextView.getPaint());
    int j = ao.av(this.context, 2131165299);
    localObject = this.gBA;
    k.g(localObject, "sendBtn");
    int k = ((TextView)localObject).getPaddingStart();
    localObject = this.gBA;
    k.g(localObject, "sendBtn");
    this.gBE = h.la(j, i + k + ((TextView)localObject).getPaddingEnd());
    localObject = com.tencent.mm.kernel.g.agQ();
    k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).agi().a(904, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190193);
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190194);
    super.alN();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().b(904, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(190194);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(190195);
    if (this.gnb.getVisibility() == 0)
    {
      if (this.gBG == this.gBv)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.gBD.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        this.gBG = this.gBt;
        nl(0);
      }
      for (;;)
      {
        AppMethodBeat.o(190195);
        return true;
        alZ();
      }
    }
    boolean bool = super.alO();
    AppMethodBeat.o(190195);
    return bool;
  }
  
  public final View ama()
  {
    AppMethodBeat.i(190192);
    View localView = this.gBy;
    k.g(localView, "inputParent");
    AppMethodBeat.o(190192);
    return localView;
  }
  
  public final void i(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(190190);
    super.i(paramBoolean, paramInt);
    if (!paramBoolean)
    {
      if (this.gBG == this.gBu)
      {
        this.gBG = this.gBt;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.gBD.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        nl(0);
        AppMethodBeat.o(190190);
      }
    }
    else
    {
      this.gBG = this.gBu;
      alY();
      nl(paramInt);
    }
    AppMethodBeat.o(190190);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(190196);
    if (((paramn instanceof s)) && (paramInt2 == -100065))
    {
      paramString = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.akS();
      c.g((d.g.a.a)new e(this));
    }
    AppMethodBeat.o(190196);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class b
    implements InputFilter
  {
    b(z paramz) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(190179);
      paramSpanned = z.b(this.gBJ);
      k.g(paramSpanned, "inputEt");
      paramSpanned.getText();
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(190179);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(190179);
        return paramCharSequence;
      }
      AppMethodBeat.o(190179);
      return null;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(190181);
      z.a(this.gBJ).setAlpha(1.0F);
      z.a(this.gBJ).setVisibility(4);
      AppMethodBeat.o(190181);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    e(z paramz)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveInputPlugin$setupEmojiPanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-logic_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void amb()
    {
      AppMethodBeat.i(190185);
      Object localObject = z.b(this.gBJ);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = z.b(this.gBJ);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(190185);
          return;
        }
      }
      AppMethodBeat.o(190185);
    }
    
    public final void amc() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(190184);
      MMEditText localMMEditText = z.b(this.gBJ);
      if (localMMEditText != null) {
        localMMEditText.aRF(paramString);
      }
      if (z.c(this.gBJ).getLiveRole() == 0) {
        f.anv();
      }
      AppMethodBeat.o(190184);
    }
    
    public final void dS(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.z
 * JD-Core Version:    0.7.0.1
 */