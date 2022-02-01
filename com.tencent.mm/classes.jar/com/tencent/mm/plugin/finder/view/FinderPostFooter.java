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
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "atBtn", "Landroid/view/View;", "getAtBtn", "()Landroid/view/View;", "setAtBtn", "(Landroid/view/View;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "container", "getContainer", "setContainer", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "iTopicCallback", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "getITopicCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "setITopicCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;)V", "isShowKeyboard", "", "reqCode", "", "getReqCode", "()I", "setReqCode", "(I)V", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "topicBtn", "getTopicBtn", "setTopicBtn", "initView", "onFinishInflate", "onHideSmileyPanel", "onKeyboardHeightChanged", "height", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "showAtBtn", "show", "showTopicBtn", "Companion", "ITopicCallback", "plugin-finder_release"})
public final class FinderPostFooter
  extends LinearLayout
{
  public static final a sVj;
  public MMActivity activity;
  public SmileyPanel gVn;
  public View ize;
  public int kqK;
  public ImageView sSV;
  public MMEditText sSW;
  public float sTb;
  private d.g.a.a<d.z> sTf;
  public View sVg;
  public View sVh;
  public b sVi;
  
  static
  {
    AppMethodBeat.i(168396);
    sVj = new a((byte)0);
    AppMethodBeat.o(168396);
  }
  
  public FinderPostFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168395);
    this.sTb = com.tencent.mm.sdk.platformtools.z.iF(getContext());
    AppMethodBeat.o(168395);
  }
  
  private final void aoL()
  {
    AppMethodBeat.i(168394);
    Object localObject = this.sSV;
    if (localObject == null) {
      p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.sSV;
    if (localObject == null) {
      p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i(this)).start();
    AppMethodBeat.o(168394);
  }
  
  private final void cNw()
  {
    AppMethodBeat.i(168393);
    Object localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(0);
    localObject = this.sSV;
    if (localObject == null) {
      p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.sSV;
    if (localObject == null) {
      p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.TRUE);
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).setAlpha(0.0F);
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(1.0F).setDuration(220L).setListener(null).start();
    AppMethodBeat.o(168393);
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168391);
    if (!paramBoolean1)
    {
      aoL();
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
      localObject = this.sSV;
      if (localObject == null) {
        p.bcb("smileyBtn");
      }
      ((ImageView)localObject).setImageResource(2131231706);
      AppMethodBeat.o(168391);
      return;
      cNw();
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(168391);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).hideVKB();
    }
    Object localObject = this.sSV;
    if (localObject == null) {
      p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    AppMethodBeat.o(168391);
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(205169);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      p.bcb("activity");
    }
    AppMethodBeat.o(205169);
    return localMMActivity;
  }
  
  public final View getAtBtn()
  {
    AppMethodBeat.i(205173);
    View localView = this.sVh;
    if (localView == null) {
      p.bcb("atBtn");
    }
    AppMethodBeat.o(205173);
    return localView;
  }
  
  public final d.g.a.a<d.z> getBackClickListener()
  {
    return this.sTf;
  }
  
  public final View getContainer()
  {
    return this.ize;
  }
  
  public final MMEditText getEditText()
  {
    return this.sSW;
  }
  
  public final b getITopicCallback()
  {
    AppMethodBeat.i(205175);
    b localb = this.sVi;
    if (localb == null) {
      p.bcb("iTopicCallback");
    }
    AppMethodBeat.o(205175);
    return localb;
  }
  
  public final int getReqCode()
  {
    return this.kqK;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168388);
    ImageView localImageView = this.sSV;
    if (localImageView == null) {
      p.bcb("smileyBtn");
    }
    AppMethodBeat.o(168388);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168386);
    SmileyPanel localSmileyPanel = this.gVn;
    if (localSmileyPanel == null) {
      p.bcb("smileyPanel");
    }
    AppMethodBeat.o(168386);
    return localSmileyPanel;
  }
  
  public final View getTopicBtn()
  {
    AppMethodBeat.i(205171);
    View localView = this.sVg;
    if (localView == null) {
      p.bcb("topicBtn");
    }
    AppMethodBeat.o(205171);
    return localView;
  }
  
  public final void mp(boolean paramBoolean)
  {
    AppMethodBeat.i(205177);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((com.tencent.mm.plugin.finder.storage.b.cGf()) && (paramBoolean))
    {
      localObject = this.sVg;
      if (localObject == null) {
        p.bcb("topicBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(205177);
      return;
    }
    localObject = this.sVg;
    if (localObject == null) {
      p.bcb("topicBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(205177);
  }
  
  public final void mq(boolean paramBoolean)
  {
    AppMethodBeat.i(205178);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((com.tencent.mm.plugin.finder.storage.b.cGg()) && (paramBoolean))
    {
      localObject = this.sVh;
      if (localObject == null) {
        p.bcb("atBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(205178);
      return;
    }
    localObject = this.sVh;
    if (localObject == null) {
      p.bcb("atBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(205178);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168390);
    super.onFinishInflate();
    Object localObject = findViewById(2131304863);
    p.g(localObject, "findViewById(R.id.smiley_btn)");
    this.sSV = ((ImageView)localObject);
    this.sSW = ((MMEditText)findViewById(2131298513));
    localObject = this.sSV;
    if (localObject == null) {
      p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = aa.k(getContext(), false);
    p.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
    this.gVn = ((SmileyPanel)localObject);
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.rJs);
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).setBackgroundResource(2131232332);
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).fbF();
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).fbH();
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).fbG();
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(4);
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).onResume();
    localObject = this.gVn;
    if (localObject == null) {
      p.bcb("smileyPanel");
    }
    ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    localObject = new LinearLayout.LayoutParams(-1, (int)this.sTb);
    SmileyPanel localSmileyPanel = this.gVn;
    if (localSmileyPanel == null) {
      p.bcb("smileyPanel");
    }
    localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localSmileyPanel = this.gVn;
    if (localSmileyPanel == null) {
      p.bcb("smileyPanel");
    }
    addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
    localObject = this.sSV;
    if (localObject == null) {
      p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new g(this));
    localObject = this.sSW;
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
    AppMethodBeat.i(205170);
    p.h(paramMMActivity, "<set-?>");
    this.activity = paramMMActivity;
    AppMethodBeat.o(205170);
  }
  
  public final void setAtBtn(View paramView)
  {
    AppMethodBeat.i(205174);
    p.h(paramView, "<set-?>");
    this.sVh = paramView;
    AppMethodBeat.o(205174);
  }
  
  public final void setBackClickListener(d.g.a.a<d.z> parama)
  {
    this.sTf = parama;
  }
  
  public final void setContainer(View paramView)
  {
    this.ize = paramView;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    this.sSW = paramMMEditText;
  }
  
  public final void setITopicCallback(b paramb)
  {
    AppMethodBeat.i(205176);
    p.h(paramb, "<set-?>");
    this.sVi = paramb;
    AppMethodBeat.o(205176);
  }
  
  public final void setReqCode(int paramInt)
  {
    this.kqK = paramInt;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168389);
    p.h(paramImageView, "<set-?>");
    this.sSV = paramImageView;
    AppMethodBeat.o(168389);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168387);
    p.h(paramSmileyPanel, "<set-?>");
    this.gVn = paramSmileyPanel;
    AppMethodBeat.o(168387);
  }
  
  public final void setTopicBtn(View paramView)
  {
    AppMethodBeat.i(205172);
    p.h(paramView, "<set-?>");
    this.sVg = paramView;
    AppMethodBeat.o(205172);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "", "onTopicClick", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void cKf();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(FinderPostFooter.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205165);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sVk.cKf();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205165);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(MMActivity paramMMActivity, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205166);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = new Intent();
      paramView.putExtra("key_scene", 1);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.d(this.lPs, paramView, this.sVl);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205166);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void aoO()
    {
      AppMethodBeat.i(168382);
      Object localObject = this.sVn.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = this.sVn.getEditText();
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
    
    public final void aoP() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168381);
      MMEditText localMMEditText = this.sVn.getEditText();
      if (localMMEditText != null)
      {
        localMMEditText.aXD(paramString);
        AppMethodBeat.o(168381);
        return;
      }
      AppMethodBeat.o(168381);
    }
    
    public final void dU(boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168383);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        FinderPostFooter.a(this.sVn, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168383);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onBack"})
  static final class h
    implements MMEditText.a
  {
    h(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onBack()
    {
      AppMethodBeat.i(168384);
      d.g.a.a locala = this.sVn.getBackClickListener();
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(168384);
        return;
      }
      AppMethodBeat.o(168384);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168385);
      this.sVn.getSmileyPanel().setAlpha(1.0F);
      this.sVn.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter
 * JD-Core Version:    0.7.0.1
 */