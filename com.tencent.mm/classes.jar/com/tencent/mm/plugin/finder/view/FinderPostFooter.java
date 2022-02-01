package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputConnection;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.aa;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "atBtn", "Landroid/widget/ImageView;", "getAtBtn", "()Landroid/widget/ImageView;", "setAtBtn", "(Landroid/widget/ImageView;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "iTopicCallback", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "getITopicCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "setITopicCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;)V", "isShowKeyboard", "", "reqCode", "", "getReqCode", "()I", "setReqCode", "(I)V", "smileyBtn", "getSmileyBtn", "setSmileyBtn", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "topicBtn", "getTopicBtn", "setTopicBtn", "initView", "onFinishInflate", "onHideSmileyPanel", "onKeyboardHeightChanged", "height", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "showAtBtn", "show", "showTopicBtn", "Companion", "ITopicCallback", "plugin-finder_release"})
public final class FinderPostFooter
  extends LinearLayout
{
  public static final a qXE;
  public ImageView Lfh;
  public FinderPostFooter.g Lfi;
  public MMActivity activity;
  public View hFi;
  public int jvX;
  public SmileyPanel qVT;
  public ImageView qVU;
  public MMEditText qVV;
  public float qWa;
  private a<y> qWe;
  public ImageView xye;
  
  static
  {
    AppMethodBeat.i(168396);
    qXE = new a((byte)0);
    AppMethodBeat.o(168396);
  }
  
  public FinderPostFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168395);
    this.qWa = z.ik(getContext());
    AppMethodBeat.o(168395);
  }
  
  private final void csS()
  {
    AppMethodBeat.i(168393);
    Object localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(0);
    localObject = this.qVU;
    if (localObject == null) {
      k.aPZ("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.qVU;
    if (localObject == null) {
      k.aPZ("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.TRUE);
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).setAlpha(0.0F);
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(1.0F).setDuration(220L).setListener(null).start();
    AppMethodBeat.o(168393);
  }
  
  private final void csT()
  {
    AppMethodBeat.i(168394);
    Object localObject = this.qVU;
    if (localObject == null) {
      k.aPZ("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.qVU;
    if (localObject == null) {
      k.aPZ("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new f(this)).start();
    AppMethodBeat.o(168394);
  }
  
  public final void K(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168391);
    if (!paramBoolean1)
    {
      csT();
      if (paramBoolean2)
      {
        localObject = getContext();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168391);
          throw ((Throwable)localObject);
        }
        ((MMActivity)localObject).showVKB();
      }
    }
    while (paramBoolean1)
    {
      localObject = this.qVU;
      if (localObject == null) {
        k.aPZ("smileyBtn");
      }
      ((ImageView)localObject).setImageResource(2131231706);
      AppMethodBeat.o(168391);
      return;
      csS();
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(168391);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).hideVKB();
    }
    Object localObject = this.qVU;
    if (localObject == null) {
      k.aPZ("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    AppMethodBeat.o(168391);
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(200120);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      k.aPZ("activity");
    }
    AppMethodBeat.o(200120);
    return localMMActivity;
  }
  
  public final ImageView getAtBtn()
  {
    AppMethodBeat.i(200124);
    ImageView localImageView = this.xye;
    if (localImageView == null) {
      k.aPZ("atBtn");
    }
    AppMethodBeat.o(200124);
    return localImageView;
  }
  
  public final a<y> getBackClickListener()
  {
    return this.qWe;
  }
  
  public final View getContainer()
  {
    return this.hFi;
  }
  
  public final MMEditText getEditText()
  {
    return this.qVV;
  }
  
  public final FinderPostFooter.g getITopicCallback()
  {
    AppMethodBeat.i(200126);
    FinderPostFooter.g localg = this.Lfi;
    if (localg == null) {
      k.aPZ("iTopicCallback");
    }
    AppMethodBeat.o(200126);
    return localg;
  }
  
  public final int getReqCode()
  {
    return this.jvX;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168388);
    ImageView localImageView = this.qVU;
    if (localImageView == null) {
      k.aPZ("smileyBtn");
    }
    AppMethodBeat.o(168388);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168386);
    SmileyPanel localSmileyPanel = this.qVT;
    if (localSmileyPanel == null) {
      k.aPZ("smileyPanel");
    }
    AppMethodBeat.o(168386);
    return localSmileyPanel;
  }
  
  public final ImageView getTopicBtn()
  {
    AppMethodBeat.i(200122);
    ImageView localImageView = this.Lfh;
    if (localImageView == null) {
      k.aPZ("topicBtn");
    }
    AppMethodBeat.o(200122);
    return localImageView;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168390);
    super.onFinishInflate();
    Object localObject = findViewById(2131304863);
    k.g(localObject, "findViewById(R.id.smiley_btn)");
    this.qVU = ((ImageView)localObject);
    localObject = findViewById(2131307897);
    k.g(localObject, "findViewById(R.id.topic_btn)");
    this.Lfh = ((ImageView)localObject);
    localObject = findViewById(2131307262);
    k.g(localObject, "findViewById(R.id.at_btn)");
    this.xye = ((ImageView)localObject);
    this.qVV = ((MMEditText)findViewById(2131298513));
    localObject = this.qVU;
    if (localObject == null) {
      k.aPZ("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = aa.k(getContext(), false);
    k.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
    this.qVT = ((SmileyPanel)localObject);
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.qpk);
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).setBackgroundResource(2131232332);
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).exn();
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).exp();
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).exo();
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(4);
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).onResume();
    localObject = this.qVT;
    if (localObject == null) {
      k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new c(this));
    localObject = new LinearLayout.LayoutParams(-1, (int)this.qWa);
    SmileyPanel localSmileyPanel = this.qVT;
    if (localSmileyPanel == null) {
      k.aPZ("smileyPanel");
    }
    localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localSmileyPanel = this.qVT;
    if (localSmileyPanel == null) {
      k.aPZ("smileyPanel");
    }
    addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
    localObject = b.qJA;
    if (b.cpO())
    {
      localObject = this.Lfh;
      if (localObject == null) {
        k.aPZ("topicBtn");
      }
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = this.qVU;
      if (localObject == null) {
        k.aPZ("smileyBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new d(this));
      localObject = this.Lfh;
      if (localObject == null) {
        k.aPZ("topicBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      localObject = this.xye;
      if (localObject == null) {
        k.aPZ("atBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new FinderPostFooter.h(this));
      localObject = this.qVV;
      if (localObject == null) {
        break;
      }
      ((MMEditText)localObject).setBackListener((MMEditText.a)new FinderPostFooter.i(this));
      AppMethodBeat.o(168390);
      return;
      localObject = this.Lfh;
      if (localObject == null) {
        k.aPZ("topicBtn");
      }
      ((ImageView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(168390);
  }
  
  public final void qo(boolean paramBoolean)
  {
    AppMethodBeat.i(200129);
    Object localObject = b.qJA;
    if ((b.fUh()) && (paramBoolean))
    {
      localObject = this.xye;
      if (localObject == null) {
        k.aPZ("atBtn");
      }
      ((ImageView)localObject).setVisibility(0);
      AppMethodBeat.o(200129);
      return;
    }
    localObject = this.xye;
    if (localObject == null) {
      k.aPZ("atBtn");
    }
    ((ImageView)localObject).setVisibility(8);
    AppMethodBeat.o(200129);
  }
  
  public final void setActivity(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(200121);
    k.h(paramMMActivity, "<set-?>");
    this.activity = paramMMActivity;
    AppMethodBeat.o(200121);
  }
  
  public final void setAtBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(200125);
    k.h(paramImageView, "<set-?>");
    this.xye = paramImageView;
    AppMethodBeat.o(200125);
  }
  
  public final void setBackClickListener(a<y> parama)
  {
    this.qWe = parama;
  }
  
  public final void setContainer(View paramView)
  {
    this.hFi = paramView;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    this.qVV = paramMMEditText;
  }
  
  public final void setITopicCallback(FinderPostFooter.g paramg)
  {
    AppMethodBeat.i(200127);
    k.h(paramg, "<set-?>");
    this.Lfi = paramg;
    AppMethodBeat.o(200127);
  }
  
  public final void setReqCode(int paramInt)
  {
    this.jvX = paramInt;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168389);
    k.h(paramImageView, "<set-?>");
    this.qVU = paramImageView;
    AppMethodBeat.o(168389);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168387);
    k.h(paramSmileyPanel, "<set-?>");
    this.qVT = paramSmileyPanel;
    AppMethodBeat.o(168387);
  }
  
  public final void setTopicBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(200123);
    k.h(paramImageView, "<set-?>");
    this.Lfh = paramImageView;
    AppMethodBeat.o(200123);
  }
  
  public final void yP(boolean paramBoolean)
  {
    AppMethodBeat.i(200128);
    Object localObject = b.qJA;
    if ((b.cpO()) && (paramBoolean))
    {
      localObject = this.Lfh;
      if (localObject == null) {
        k.aPZ("topicBtn");
      }
      ((ImageView)localObject).setVisibility(0);
      AppMethodBeat.o(200128);
      return;
    }
    localObject = this.Lfh;
    if (localObject == null) {
      k.aPZ("topicBtn");
    }
    ((ImageView)localObject).setVisibility(8);
    AppMethodBeat.o(200128);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class c
    implements ChatFooterPanel.a
  {
    public final void append(String paramString)
    {
      AppMethodBeat.i(168381);
      MMEditText localMMEditText = this.qXG.getEditText();
      if (localMMEditText != null)
      {
        localMMEditText.aMd(paramString);
        AppMethodBeat.o(168381);
        return;
      }
      AppMethodBeat.o(168381);
    }
    
    public final void btF()
    {
      AppMethodBeat.i(168382);
      Object localObject = this.qXG.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = this.qXG.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(168382);
          return;
        }
      }
      AppMethodBeat.o(168382);
    }
    
    public final void cqY() {}
    
    public final void lf(boolean paramBoolean) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168383);
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(168383);
        throw paramView;
      }
      paramView = ((ImageView)paramView).getTag();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(168383);
        throw paramView;
      }
      if (!((Boolean)paramView).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        FinderPostFooter.a(this.qXG, bool);
        AppMethodBeat.o(168383);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200117);
      this.qXG.getITopicCallback().fVB();
      AppMethodBeat.o(200117);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168385);
      this.qXG.getSmileyPanel().setAlpha(1.0F);
      this.qXG.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter
 * JD-Core Version:    0.7.0.1
 */