package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "atBtn", "Landroid/widget/ImageView;", "getAtBtn", "()Landroid/widget/ImageView;", "setAtBtn", "(Landroid/widget/ImageView;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "iTopicCallback", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "getITopicCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "setITopicCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;)V", "isShowKeyboard", "", "reqCode", "", "getReqCode", "()I", "setReqCode", "(I)V", "smileyBtn", "getSmileyBtn", "setSmileyBtn", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "topicBtn", "getTopicBtn", "setTopicBtn", "initView", "onFinishInflate", "onHideSmileyPanel", "onKeyboardHeightChanged", "height", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "showAtBtn", "show", "showTopicBtn", "Companion", "ITopicCallback", "plugin-finder_release"})
public final class FinderPostFooter
  extends LinearLayout
{
  public static final FinderPostFooter.a rYo;
  public MMActivity activity;
  public SmileyPanel gBD;
  public View ifK;
  public int jWt;
  public ImageView rWl;
  public MMEditText rWm;
  public float rWr;
  private d.g.a.a<d.y> rWv;
  public ImageView rYl;
  public ImageView rYm;
  public b rYn;
  
  static
  {
    AppMethodBeat.i(168396);
    rYo = new FinderPostFooter.a((byte)0);
    AppMethodBeat.o(168396);
  }
  
  public FinderPostFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168395);
    this.rWr = com.tencent.mm.sdk.platformtools.y.iv(getContext());
    AppMethodBeat.o(168395);
  }
  
  private final void alY()
  {
    AppMethodBeat.i(168394);
    Object localObject = this.rWl;
    if (localObject == null) {
      k.aVY("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.rWl;
    if (localObject == null) {
      k.aVY("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i(this)).start();
    AppMethodBeat.o(168394);
  }
  
  private final void cFc()
  {
    AppMethodBeat.i(168393);
    Object localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(0);
    localObject = this.rWl;
    if (localObject == null) {
      k.aVY("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.rWl;
    if (localObject == null) {
      k.aVY("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.TRUE);
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).setAlpha(0.0F);
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(1.0F).setDuration(220L).setListener(null).start();
    AppMethodBeat.o(168393);
  }
  
  public final void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168391);
    if (!paramBoolean1)
    {
      alY();
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
      localObject = this.rWl;
      if (localObject == null) {
        k.aVY("smileyBtn");
      }
      ((ImageView)localObject).setImageResource(2131231706);
      AppMethodBeat.o(168391);
      return;
      cFc();
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(168391);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).hideVKB();
    }
    Object localObject = this.rWl;
    if (localObject == null) {
      k.aVY("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    AppMethodBeat.o(168391);
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(204190);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      k.aVY("activity");
    }
    AppMethodBeat.o(204190);
    return localMMActivity;
  }
  
  public final ImageView getAtBtn()
  {
    AppMethodBeat.i(204194);
    ImageView localImageView = this.rYm;
    if (localImageView == null) {
      k.aVY("atBtn");
    }
    AppMethodBeat.o(204194);
    return localImageView;
  }
  
  public final d.g.a.a<d.y> getBackClickListener()
  {
    return this.rWv;
  }
  
  public final View getContainer()
  {
    return this.ifK;
  }
  
  public final MMEditText getEditText()
  {
    return this.rWm;
  }
  
  public final b getITopicCallback()
  {
    AppMethodBeat.i(204196);
    b localb = this.rYn;
    if (localb == null) {
      k.aVY("iTopicCallback");
    }
    AppMethodBeat.o(204196);
    return localb;
  }
  
  public final int getReqCode()
  {
    return this.jWt;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168388);
    ImageView localImageView = this.rWl;
    if (localImageView == null) {
      k.aVY("smileyBtn");
    }
    AppMethodBeat.o(168388);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168386);
    SmileyPanel localSmileyPanel = this.gBD;
    if (localSmileyPanel == null) {
      k.aVY("smileyPanel");
    }
    AppMethodBeat.o(168386);
    return localSmileyPanel;
  }
  
  public final ImageView getTopicBtn()
  {
    AppMethodBeat.i(204192);
    ImageView localImageView = this.rYl;
    if (localImageView == null) {
      k.aVY("topicBtn");
    }
    AppMethodBeat.o(204192);
    return localImageView;
  }
  
  public final void lX(boolean paramBoolean)
  {
    AppMethodBeat.i(204198);
    Object localObject = b.rCU;
    if ((b.czo()) && (paramBoolean))
    {
      localObject = this.rYl;
      if (localObject == null) {
        k.aVY("topicBtn");
      }
      ((ImageView)localObject).setVisibility(0);
      AppMethodBeat.o(204198);
      return;
    }
    localObject = this.rYl;
    if (localObject == null) {
      k.aVY("topicBtn");
    }
    ((ImageView)localObject).setVisibility(8);
    AppMethodBeat.o(204198);
  }
  
  public final void lY(boolean paramBoolean)
  {
    AppMethodBeat.i(204199);
    Object localObject = b.rCU;
    if ((b.czp()) && (paramBoolean))
    {
      localObject = this.rYm;
      if (localObject == null) {
        k.aVY("atBtn");
      }
      ((ImageView)localObject).setVisibility(0);
      AppMethodBeat.o(204199);
      return;
    }
    localObject = this.rYm;
    if (localObject == null) {
      k.aVY("atBtn");
    }
    ((ImageView)localObject).setVisibility(8);
    AppMethodBeat.o(204199);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168390);
    super.onFinishInflate();
    Object localObject = findViewById(2131304863);
    k.g(localObject, "findViewById(R.id.smiley_btn)");
    this.rWl = ((ImageView)localObject);
    localObject = findViewById(2131308037);
    k.g(localObject, "findViewById(R.id.topic_btn)");
    this.rYl = ((ImageView)localObject);
    localObject = findViewById(2131307268);
    k.g(localObject, "findViewById(R.id.at_btn)");
    this.rYm = ((ImageView)localObject);
    this.rWm = ((MMEditText)findViewById(2131298513));
    localObject = this.rWl;
    if (localObject == null) {
      k.aVY("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = aa.k(getContext(), false);
    k.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
    this.gBD = ((SmileyPanel)localObject);
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.qYg);
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).setBackgroundResource(2131232332);
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).eMH();
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).eMJ();
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).eMI();
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(4);
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).onResume();
    localObject = this.gBD;
    if (localObject == null) {
      k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new d(this));
    localObject = new LinearLayout.LayoutParams(-1, (int)this.rWr);
    SmileyPanel localSmileyPanel = this.gBD;
    if (localSmileyPanel == null) {
      k.aVY("smileyPanel");
    }
    localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localSmileyPanel = this.gBD;
    if (localSmileyPanel == null) {
      k.aVY("smileyPanel");
    }
    addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
    localObject = b.rCU;
    if (b.czo())
    {
      localObject = this.rYl;
      if (localObject == null) {
        k.aVY("topicBtn");
      }
      ((ImageView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = this.rWl;
      if (localObject == null) {
        k.aVY("smileyBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      localObject = this.rYl;
      if (localObject == null) {
        k.aVY("topicBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new f(this));
      localObject = this.rYm;
      if (localObject == null) {
        k.aVY("atBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new g(this));
      localObject = this.rWm;
      if (localObject == null) {
        break;
      }
      ((MMEditText)localObject).setBackListener((MMEditText.a)new h(this));
      AppMethodBeat.o(168390);
      return;
      localObject = this.rYl;
      if (localObject == null) {
        k.aVY("topicBtn");
      }
      ((ImageView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(168390);
  }
  
  public final void setActivity(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(204191);
    k.h(paramMMActivity, "<set-?>");
    this.activity = paramMMActivity;
    AppMethodBeat.o(204191);
  }
  
  public final void setAtBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(204195);
    k.h(paramImageView, "<set-?>");
    this.rYm = paramImageView;
    AppMethodBeat.o(204195);
  }
  
  public final void setBackClickListener(d.g.a.a<d.y> parama)
  {
    this.rWv = parama;
  }
  
  public final void setContainer(View paramView)
  {
    this.ifK = paramView;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    this.rWm = paramMMEditText;
  }
  
  public final void setITopicCallback(b paramb)
  {
    AppMethodBeat.i(204197);
    k.h(paramb, "<set-?>");
    this.rYn = paramb;
    AppMethodBeat.o(204197);
  }
  
  public final void setReqCode(int paramInt)
  {
    this.jWt = paramInt;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168389);
    k.h(paramImageView, "<set-?>");
    this.rWl = paramImageView;
    AppMethodBeat.o(168389);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168387);
    k.h(paramSmileyPanel, "<set-?>");
    this.gBD = paramSmileyPanel;
    AppMethodBeat.o(168387);
  }
  
  public final void setTopicBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(204193);
    k.h(paramImageView, "<set-?>");
    this.rYl = paramImageView;
    AppMethodBeat.o(204193);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "", "onTopicClick", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void cCg();
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class d
    implements ChatFooterPanel.a
  {
    public final void amb()
    {
      AppMethodBeat.i(168382);
      Object localObject = this.rYq.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = this.rYq.getEditText();
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
    
    public final void amc() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168381);
      MMEditText localMMEditText = this.rYq.getEditText();
      if (localMMEditText != null)
      {
        localMMEditText.aRF(paramString);
        AppMethodBeat.o(168381);
        return;
      }
      AppMethodBeat.o(168381);
    }
    
    public final void dS(boolean paramBoolean) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderPostFooter paramFinderPostFooter) {}
    
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
        FinderPostFooter.a(this.rYq, bool);
        AppMethodBeat.o(168383);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204187);
      this.rYq.getITopicCallback().cCg();
      AppMethodBeat.o(204187);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204188);
      paramView = new Intent();
      paramView.putExtra("key_scene", 1);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.c(this.rYq.getActivity(), paramView, this.rYq.getReqCode());
      AppMethodBeat.o(204188);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onBack"})
  static final class h
    implements MMEditText.a
  {
    h(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onBack()
    {
      AppMethodBeat.i(204189);
      d.g.a.a locala = this.rYq.getBackClickListener();
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(204189);
        return;
      }
      AppMethodBeat.o(204189);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168385);
      this.rYq.getSmileyPanel().setAlpha(1.0F);
      this.rYq.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter
 * JD-Core Version:    0.7.0.1
 */