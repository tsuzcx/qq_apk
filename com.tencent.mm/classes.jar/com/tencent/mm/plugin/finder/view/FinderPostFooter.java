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
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "atBtn", "Landroid/view/View;", "getAtBtn", "()Landroid/view/View;", "setAtBtn", "(Landroid/view/View;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "container", "getContainer", "setContainer", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "iTopicCallback", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "getITopicCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "setITopicCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;)V", "isShowKeyboard", "", "reqCode", "", "getReqCode", "()I", "setReqCode", "(I)V", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "topicBtn", "getTopicBtn", "setTopicBtn", "initView", "onFinishInflate", "onHideSmileyPanel", "onKeyboardHeightChanged", "height", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "showAtBtn", "show", "showTopicBtn", "Companion", "ITopicCallback", "plugin-finder_release"})
public final class FinderPostFooter
  extends LinearLayout
{
  public static final FinderPostFooter.a tgz;
  public MMActivity activity;
  public SmileyPanel gXW;
  public View iBX;
  public int ktZ;
  public ImageView teh;
  public MMEditText tei;
  public float ten;
  private d.g.a.a<z> ter;
  public View tgw;
  public View tgx;
  public FinderPostFooter.b tgy;
  
  static
  {
    AppMethodBeat.i(168396);
    tgz = new FinderPostFooter.a((byte)0);
    AppMethodBeat.o(168396);
  }
  
  public FinderPostFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168395);
    this.ten = com.tencent.mm.sdk.platformtools.aa.iK(getContext());
    AppMethodBeat.o(168395);
  }
  
  private final void aoZ()
  {
    AppMethodBeat.i(168394);
    Object localObject = this.teh;
    if (localObject == null) {
      p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.teh;
    if (localObject == null) {
      p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i(this)).start();
    AppMethodBeat.o(168394);
  }
  
  private final void cQg()
  {
    AppMethodBeat.i(168393);
    Object localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(0);
    localObject = this.teh;
    if (localObject == null) {
      p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.teh;
    if (localObject == null) {
      p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.TRUE);
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).setAlpha(0.0F);
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(1.0F).setDuration(220L).setListener(null).start();
    AppMethodBeat.o(168393);
  }
  
  public final void O(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168391);
    if (!paramBoolean1)
    {
      aoZ();
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
      localObject = this.teh;
      if (localObject == null) {
        p.bdF("smileyBtn");
      }
      ((ImageView)localObject).setImageResource(2131231706);
      AppMethodBeat.o(168391);
      return;
      cQg();
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(168391);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).hideVKB();
    }
    Object localObject = this.teh;
    if (localObject == null) {
      p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    AppMethodBeat.o(168391);
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(205805);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      p.bdF("activity");
    }
    AppMethodBeat.o(205805);
    return localMMActivity;
  }
  
  public final View getAtBtn()
  {
    AppMethodBeat.i(205809);
    View localView = this.tgx;
    if (localView == null) {
      p.bdF("atBtn");
    }
    AppMethodBeat.o(205809);
    return localView;
  }
  
  public final d.g.a.a<z> getBackClickListener()
  {
    return this.ter;
  }
  
  public final View getContainer()
  {
    return this.iBX;
  }
  
  public final MMEditText getEditText()
  {
    return this.tei;
  }
  
  public final FinderPostFooter.b getITopicCallback()
  {
    AppMethodBeat.i(205811);
    FinderPostFooter.b localb = this.tgy;
    if (localb == null) {
      p.bdF("iTopicCallback");
    }
    AppMethodBeat.o(205811);
    return localb;
  }
  
  public final int getReqCode()
  {
    return this.ktZ;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168388);
    ImageView localImageView = this.teh;
    if (localImageView == null) {
      p.bdF("smileyBtn");
    }
    AppMethodBeat.o(168388);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168386);
    SmileyPanel localSmileyPanel = this.gXW;
    if (localSmileyPanel == null) {
      p.bdF("smileyPanel");
    }
    AppMethodBeat.o(168386);
    return localSmileyPanel;
  }
  
  public final View getTopicBtn()
  {
    AppMethodBeat.i(205807);
    View localView = this.tgw;
    if (localView == null) {
      p.bdF("topicBtn");
    }
    AppMethodBeat.o(205807);
    return localView;
  }
  
  public final void mu(boolean paramBoolean)
  {
    AppMethodBeat.i(205813);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((com.tencent.mm.plugin.finder.storage.b.cIc()) && (paramBoolean))
    {
      localObject = this.tgw;
      if (localObject == null) {
        p.bdF("topicBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(205813);
      return;
    }
    localObject = this.tgw;
    if (localObject == null) {
      p.bdF("topicBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(205813);
  }
  
  public final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(205814);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((com.tencent.mm.plugin.finder.storage.b.cId()) && (paramBoolean))
    {
      localObject = this.tgx;
      if (localObject == null) {
        p.bdF("atBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(205814);
      return;
    }
    localObject = this.tgx;
    if (localObject == null) {
      p.bdF("atBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(205814);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168390);
    super.onFinishInflate();
    Object localObject = findViewById(2131304863);
    p.g(localObject, "findViewById(R.id.smiley_btn)");
    this.teh = ((ImageView)localObject);
    this.tei = ((MMEditText)findViewById(2131298513));
    localObject = this.teh;
    if (localObject == null) {
      p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = com.tencent.mm.api.aa.k(getContext(), false);
    p.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
    this.gXW = ((SmileyPanel)localObject);
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.rRG);
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).setBackgroundResource(2131232332);
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).fft();
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).ffv();
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).ffu();
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(4);
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).onResume();
    localObject = this.gXW;
    if (localObject == null) {
      p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    localObject = new LinearLayout.LayoutParams(-1, (int)this.ten);
    SmileyPanel localSmileyPanel = this.gXW;
    if (localSmileyPanel == null) {
      p.bdF("smileyPanel");
    }
    localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localSmileyPanel = this.gXW;
    if (localSmileyPanel == null) {
      p.bdF("smileyPanel");
    }
    addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
    localObject = this.teh;
    if (localObject == null) {
      p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new g(this));
    localObject = this.tei;
    if (localObject != null)
    {
      ((MMEditText)localObject).setBackListener((MMEditText.a)new h(this));
      AppMethodBeat.o(168390);
      return;
    }
    AppMethodBeat.o(168390);
  }
  
  public final void setActivity(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(205806);
    p.h(paramMMActivity, "<set-?>");
    this.activity = paramMMActivity;
    AppMethodBeat.o(205806);
  }
  
  public final void setAtBtn(View paramView)
  {
    AppMethodBeat.i(205810);
    p.h(paramView, "<set-?>");
    this.tgx = paramView;
    AppMethodBeat.o(205810);
  }
  
  public final void setBackClickListener(d.g.a.a<z> parama)
  {
    this.ter = parama;
  }
  
  public final void setContainer(View paramView)
  {
    this.iBX = paramView;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    this.tei = paramMMEditText;
  }
  
  public final void setITopicCallback(FinderPostFooter.b paramb)
  {
    AppMethodBeat.i(205812);
    p.h(paramb, "<set-?>");
    this.tgy = paramb;
    AppMethodBeat.o(205812);
  }
  
  public final void setReqCode(int paramInt)
  {
    this.ktZ = paramInt;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168389);
    p.h(paramImageView, "<set-?>");
    this.teh = paramImageView;
    AppMethodBeat.o(168389);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168387);
    p.h(paramSmileyPanel, "<set-?>");
    this.gXW = paramSmileyPanel;
    AppMethodBeat.o(168387);
  }
  
  public final void setTopicBtn(View paramView)
  {
    AppMethodBeat.i(205808);
    p.h(paramView, "<set-?>");
    this.tgw = paramView;
    AppMethodBeat.o(205808);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void apc()
    {
      AppMethodBeat.i(168382);
      Object localObject = this.tgD.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = this.tgD.getEditText();
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
    
    public final void apd() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168381);
      MMEditText localMMEditText = this.tgD.getEditText();
      if (localMMEditText != null)
      {
        localMMEditText.aZf(paramString);
        AppMethodBeat.o(168381);
        return;
      }
      AppMethodBeat.o(168381);
    }
    
    public final void dW(boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168383);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        FinderPostFooter.a(this.tgD, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168383);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onBack"})
  static final class h
    implements MMEditText.a
  {
    h(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onBack()
    {
      AppMethodBeat.i(168384);
      d.g.a.a locala = this.tgD.getBackClickListener();
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(168384);
        return;
      }
      AppMethodBeat.o(168384);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168385);
      this.tgD.getSmileyPanel().setAlpha(1.0F);
      this.tgD.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter
 * JD-Core Version:    0.7.0.1
 */