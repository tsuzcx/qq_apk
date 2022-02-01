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
import com.tencent.mm.api.ad;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "activityReqCode", "", "getActivityReqCode", "()I", "setActivityReqCode", "(I)V", "atBtn", "Landroid/view/View;", "getAtBtn", "()Landroid/view/View;", "setAtBtn", "(Landroid/view/View;)V", "atReqCode", "getAtReqCode", "setAtReqCode", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "container", "getContainer", "setContainer", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "iTopicCallback", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "getITopicCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "setITopicCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;)V", "isShowKeyboard", "", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "topicBtn", "getTopicBtn", "setTopicBtn", "initView", "onFinishInflate", "onHideSmileyPanel", "onKeyboardHeightChanged", "height", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "showAtBtn", "show", "showTopicBtn", "Companion", "ITopicCallback", "plugin-finder_release"})
public final class FinderPostFooter
  extends LinearLayout
{
  public static final a AZA;
  public ImageView AVM;
  public MMEditText AVN;
  public float AVS;
  private kotlin.g.a.a<x> AVV;
  public View AZv;
  public View AZw;
  public int AZx;
  public int AZy;
  public b AZz;
  public MMActivity activity;
  public View fyN;
  public SmileyPanel kFp;
  
  static
  {
    AppMethodBeat.i(168396);
    AZA = new a((byte)0);
    AppMethodBeat.o(168396);
  }
  
  public FinderPostFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168395);
    this.AVS = KeyBoardUtil.getKeyBordHeightPx(getContext());
    AppMethodBeat.o(168395);
  }
  
  private final void aPz()
  {
    AppMethodBeat.i(168394);
    Object localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(b.e.chatting_setmode_biaoqing_btn);
    localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i(this)).start();
    AppMethodBeat.o(168394);
  }
  
  private final void eiZ()
  {
    AppMethodBeat.i(168393);
    Object localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(0);
    localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(b.e.chatting_setmode_biaoqing_btn);
    localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.TRUE);
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).setAlpha(0.0F);
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(1.0F).setDuration(220L).setListener(null).start();
    AppMethodBeat.o(168393);
  }
  
  public final void Z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168391);
    if (!paramBoolean1)
    {
      aPz();
      if (paramBoolean2)
      {
        localObject = getContext();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168391);
          throw ((Throwable)localObject);
        }
        ((MMActivity)localObject).showVKB();
      }
    }
    while (paramBoolean1)
    {
      localObject = this.AVM;
      if (localObject == null) {
        p.bGy("smileyBtn");
      }
      ((ImageView)localObject).setImageResource(b.e.chatting_setmode_keyboard_btn);
      AppMethodBeat.o(168391);
      return;
      eiZ();
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(168391);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).hideVKB();
    }
    Object localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(b.e.chatting_setmode_biaoqing_btn);
    AppMethodBeat.o(168391);
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(272489);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      p.bGy("activity");
    }
    AppMethodBeat.o(272489);
    return localMMActivity;
  }
  
  public final int getActivityReqCode()
  {
    return this.AZy;
  }
  
  public final View getAtBtn()
  {
    AppMethodBeat.i(272494);
    View localView = this.AZw;
    if (localView == null) {
      p.bGy("atBtn");
    }
    AppMethodBeat.o(272494);
    return localView;
  }
  
  public final int getAtReqCode()
  {
    return this.AZx;
  }
  
  public final kotlin.g.a.a<x> getBackClickListener()
  {
    return this.AVV;
  }
  
  public final View getContainer()
  {
    return this.fyN;
  }
  
  public final MMEditText getEditText()
  {
    return this.AVN;
  }
  
  public final b getITopicCallback()
  {
    AppMethodBeat.i(272496);
    b localb = this.AZz;
    if (localb == null) {
      p.bGy("iTopicCallback");
    }
    AppMethodBeat.o(272496);
    return localb;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168388);
    ImageView localImageView = this.AVM;
    if (localImageView == null) {
      p.bGy("smileyBtn");
    }
    AppMethodBeat.o(168388);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168386);
    SmileyPanel localSmileyPanel = this.kFp;
    if (localSmileyPanel == null) {
      p.bGy("smileyPanel");
    }
    AppMethodBeat.o(168386);
    return localSmileyPanel;
  }
  
  public final View getTopicBtn()
  {
    AppMethodBeat.i(272492);
    View localView = this.AZv;
    if (localView == null) {
      p.bGy("topicBtn");
    }
    AppMethodBeat.o(272492);
    return localView;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168390);
    super.onFinishInflate();
    Object localObject = findViewById(b.f.smiley_btn);
    p.j(localObject, "findViewById(R.id.smiley_btn)");
    this.AVM = ((ImageView)localObject);
    this.AVN = ((MMEditText)findViewById(b.f.comment_et));
    localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = ad.m(getContext(), false);
    p.j(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
    this.kFp = ((SmileyPanel)localObject);
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.xde);
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).setBackgroundResource(b.e.finder_bottombar_bg);
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).hjp();
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).hjq();
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).DS(false);
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(4);
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).onResume();
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    localObject = new LinearLayout.LayoutParams(-1, (int)this.AVS);
    SmileyPanel localSmileyPanel = this.kFp;
    if (localSmileyPanel == null) {
      p.bGy("smileyPanel");
    }
    localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localSmileyPanel = this.kFp;
    if (localSmileyPanel == null) {
      p.bGy("smileyPanel");
    }
    addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
    localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new g(this));
    localObject = this.AVN;
    if (localObject != null)
    {
      ((MMEditText)localObject).setBackListener((MMEditText.a)new h(this));
      AppMethodBeat.o(168390);
      return;
    }
    AppMethodBeat.o(168390);
  }
  
  public final void rr(boolean paramBoolean)
  {
    AppMethodBeat.i(272498);
    Object localObject = d.AjH;
    if ((d.dTd()) && (paramBoolean))
    {
      localObject = this.AZv;
      if (localObject == null) {
        p.bGy("topicBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(272498);
      return;
    }
    localObject = this.AZv;
    if (localObject == null) {
      p.bGy("topicBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(272498);
  }
  
  public final void rs(boolean paramBoolean)
  {
    AppMethodBeat.i(272499);
    Object localObject = d.AjH;
    if ((d.dTe()) && (paramBoolean))
    {
      localObject = this.AZw;
      if (localObject == null) {
        p.bGy("atBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(272499);
      return;
    }
    localObject = this.AZw;
    if (localObject == null) {
      p.bGy("atBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(272499);
  }
  
  public final void setActivity(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(272490);
    p.k(paramMMActivity, "<set-?>");
    this.activity = paramMMActivity;
    AppMethodBeat.o(272490);
  }
  
  public final void setActivityReqCode(int paramInt)
  {
    this.AZy = paramInt;
  }
  
  public final void setAtBtn(View paramView)
  {
    AppMethodBeat.i(272495);
    p.k(paramView, "<set-?>");
    this.AZw = paramView;
    AppMethodBeat.o(272495);
  }
  
  public final void setAtReqCode(int paramInt)
  {
    this.AZx = paramInt;
  }
  
  public final void setBackClickListener(kotlin.g.a.a<x> parama)
  {
    this.AVV = parama;
  }
  
  public final void setContainer(View paramView)
  {
    this.fyN = paramView;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    this.AVN = paramMMEditText;
  }
  
  public final void setITopicCallback(b paramb)
  {
    AppMethodBeat.i(272497);
    p.k(paramb, "<set-?>");
    this.AZz = paramb;
    AppMethodBeat.o(272497);
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168389);
    p.k(paramImageView, "<set-?>");
    this.AVM = paramImageView;
    AppMethodBeat.o(168389);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168387);
    p.k(paramSmileyPanel, "<set-?>");
    this.kFp = paramSmileyPanel;
    AppMethodBeat.o(168387);
  }
  
  public final void setTopicBtn(View paramView)
  {
    AppMethodBeat.i(272493);
    p.k(paramView, "<set-?>");
    this.AZv = paramView;
    AppMethodBeat.o(272493);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "", "onTopicClick", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void dDZ();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(FinderPostFooter.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269266);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.AZB.dDZ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269266);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void aDN() {}
    
    public final void aDO()
    {
      AppMethodBeat.i(168382);
      Object localObject = this.AZE.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = this.AZE.getEditText();
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
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168381);
      MMEditText localMMEditText = this.AZE.getEditText();
      if (localMMEditText != null)
      {
        localMMEditText.bBa(paramString);
        AppMethodBeat.o(168381);
        return;
      }
      AppMethodBeat.o(168381);
    }
    
    public final void eE(boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168383);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(168383);
        throw paramView;
      }
      paramView = ((ImageView)paramView).getTag();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(168383);
        throw paramView;
      }
      if (!((Boolean)paramView).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        FinderPostFooter.a(this.AZE, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168383);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onBack"})
  static final class h
    implements MMEditText.a
  {
    h(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onBack()
    {
      AppMethodBeat.i(168384);
      kotlin.g.a.a locala = this.AZE.getBackClickListener();
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(168384);
        return;
      }
      AppMethodBeat.o(168384);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168385);
      this.AZE.getSmileyPanel().setAlpha(1.0F);
      this.AZE.getSmileyPanel().setVisibility(4);
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