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
import com.tencent.mm.plugin.finder.storage.c;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "activityReqCode", "", "getActivityReqCode", "()I", "setActivityReqCode", "(I)V", "atBtn", "Landroid/view/View;", "getAtBtn", "()Landroid/view/View;", "setAtBtn", "(Landroid/view/View;)V", "atReqCode", "getAtReqCode", "setAtReqCode", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "container", "getContainer", "setContainer", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "iTopicCallback", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "getITopicCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "setITopicCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;)V", "isShowKeyboard", "", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "topicBtn", "getTopicBtn", "setTopicBtn", "initView", "onFinishInflate", "onHideSmileyPanel", "onKeyboardHeightChanged", "height", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "showAtBtn", "show", "showTopicBtn", "Companion", "ITopicCallback", "plugin-finder_release"})
public final class FinderPostFooter
  extends LinearLayout
{
  public static final a wot;
  public MMActivity activity;
  public SmileyPanel hQS;
  public View jxm;
  public ImageView wkR;
  public MMEditText wkS;
  public float wkX;
  private kotlin.g.a.a<x> wla;
  public View woo;
  public View wop;
  public int woq;
  public int wor;
  public b wos;
  
  static
  {
    AppMethodBeat.i(168396);
    wot = new a((byte)0);
    AppMethodBeat.o(168396);
  }
  
  public FinderPostFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168395);
    this.wkX = KeyBoardUtil.getKeyBordHeightPx(getContext());
    AppMethodBeat.o(168395);
  }
  
  private final void aHz()
  {
    AppMethodBeat.i(168394);
    Object localObject = this.wkR;
    if (localObject == null) {
      p.btv("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231772);
    localObject = this.wkR;
    if (localObject == null) {
      p.btv("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i(this)).start();
    AppMethodBeat.o(168394);
  }
  
  private final void dHa()
  {
    AppMethodBeat.i(168393);
    Object localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(0);
    localObject = this.wkR;
    if (localObject == null) {
      p.btv("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231772);
    localObject = this.wkR;
    if (localObject == null) {
      p.btv("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.TRUE);
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).setAlpha(0.0F);
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(1.0F).setDuration(220L).setListener(null).start();
    AppMethodBeat.o(168393);
  }
  
  public final void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168391);
    if (!paramBoolean1)
    {
      aHz();
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
      localObject = this.wkR;
      if (localObject == null) {
        p.btv("smileyBtn");
      }
      ((ImageView)localObject).setImageResource(2131231777);
      AppMethodBeat.o(168391);
      return;
      dHa();
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(168391);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).hideVKB();
    }
    Object localObject = this.wkR;
    if (localObject == null) {
      p.btv("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231772);
    AppMethodBeat.o(168391);
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(254895);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity == null) {
      p.btv("activity");
    }
    AppMethodBeat.o(254895);
    return localMMActivity;
  }
  
  public final int getActivityReqCode()
  {
    return this.wor;
  }
  
  public final View getAtBtn()
  {
    AppMethodBeat.i(254899);
    View localView = this.wop;
    if (localView == null) {
      p.btv("atBtn");
    }
    AppMethodBeat.o(254899);
    return localView;
  }
  
  public final int getAtReqCode()
  {
    return this.woq;
  }
  
  public final kotlin.g.a.a<x> getBackClickListener()
  {
    return this.wla;
  }
  
  public final View getContainer()
  {
    return this.jxm;
  }
  
  public final MMEditText getEditText()
  {
    return this.wkS;
  }
  
  public final b getITopicCallback()
  {
    AppMethodBeat.i(254901);
    b localb = this.wos;
    if (localb == null) {
      p.btv("iTopicCallback");
    }
    AppMethodBeat.o(254901);
    return localb;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168388);
    ImageView localImageView = this.wkR;
    if (localImageView == null) {
      p.btv("smileyBtn");
    }
    AppMethodBeat.o(168388);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168386);
    SmileyPanel localSmileyPanel = this.hQS;
    if (localSmileyPanel == null) {
      p.btv("smileyPanel");
    }
    AppMethodBeat.o(168386);
    return localSmileyPanel;
  }
  
  public final View getTopicBtn()
  {
    AppMethodBeat.i(254897);
    View localView = this.woo;
    if (localView == null) {
      p.btv("topicBtn");
    }
    AppMethodBeat.o(254897);
    return localView;
  }
  
  public final void oX(boolean paramBoolean)
  {
    AppMethodBeat.i(254903);
    Object localObject = c.vCb;
    if ((c.drN()) && (paramBoolean))
    {
      localObject = this.woo;
      if (localObject == null) {
        p.btv("topicBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(254903);
      return;
    }
    localObject = this.woo;
    if (localObject == null) {
      p.btv("topicBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(254903);
  }
  
  public final void oY(boolean paramBoolean)
  {
    AppMethodBeat.i(254904);
    Object localObject = c.vCb;
    if ((c.drO()) && (paramBoolean))
    {
      localObject = this.wop;
      if (localObject == null) {
        p.btv("atBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(254904);
      return;
    }
    localObject = this.wop;
    if (localObject == null) {
      p.btv("atBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(254904);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168390);
    super.onFinishInflate();
    Object localObject = findViewById(2131307949);
    p.g(localObject, "findViewById(R.id.smiley_btn)");
    this.wkR = ((ImageView)localObject);
    this.wkS = ((MMEditText)findViewById(2131298939));
    localObject = this.wkR;
    if (localObject == null) {
      p.btv("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    localObject = ad.l(getContext(), false);
    p.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
    this.hQS = ((SmileyPanel)localObject);
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.tvw);
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).setBackgroundResource(2131232481);
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).goD();
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).goE();
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).zN(false);
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).setVisibility(4);
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).onResume();
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new f(this));
    localObject = new LinearLayout.LayoutParams(-1, (int)this.wkX);
    SmileyPanel localSmileyPanel = this.hQS;
    if (localSmileyPanel == null) {
      p.btv("smileyPanel");
    }
    localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localSmileyPanel = this.hQS;
    if (localSmileyPanel == null) {
      p.btv("smileyPanel");
    }
    addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
    localObject = this.wkR;
    if (localObject == null) {
      p.btv("smileyBtn");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new g(this));
    localObject = this.wkS;
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
    AppMethodBeat.i(254896);
    p.h(paramMMActivity, "<set-?>");
    this.activity = paramMMActivity;
    AppMethodBeat.o(254896);
  }
  
  public final void setActivityReqCode(int paramInt)
  {
    this.wor = paramInt;
  }
  
  public final void setAtBtn(View paramView)
  {
    AppMethodBeat.i(254900);
    p.h(paramView, "<set-?>");
    this.wop = paramView;
    AppMethodBeat.o(254900);
  }
  
  public final void setAtReqCode(int paramInt)
  {
    this.woq = paramInt;
  }
  
  public final void setBackClickListener(kotlin.g.a.a<x> parama)
  {
    this.wla = parama;
  }
  
  public final void setContainer(View paramView)
  {
    this.jxm = paramView;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    this.wkS = paramMMEditText;
  }
  
  public final void setITopicCallback(b paramb)
  {
    AppMethodBeat.i(254902);
    p.h(paramb, "<set-?>");
    this.wos = paramb;
    AppMethodBeat.o(254902);
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168389);
    p.h(paramImageView, "<set-?>");
    this.wkR = paramImageView;
    AppMethodBeat.o(168389);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168387);
    p.h(paramSmileyPanel, "<set-?>");
    this.hQS = paramSmileyPanel;
    AppMethodBeat.o(168387);
  }
  
  public final void setTopicBtn(View paramView)
  {
    AppMethodBeat.i(254898);
    p.h(paramView, "<set-?>");
    this.woo = paramView;
    AppMethodBeat.o(254898);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "", "onTopicClick", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void dAB();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class c
    implements View.OnClickListener
  {
    public c(FinderPostFooter.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254891);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.wou.dAB();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(254891);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void aHC()
    {
      AppMethodBeat.i(168382);
      Object localObject = this.wox.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = this.wox.getEditText();
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
    
    public final void aHD() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168381);
      MMEditText localMMEditText = this.wox.getEditText();
      if (localMMEditText != null)
      {
        localMMEditText.bol(paramString);
        AppMethodBeat.o(168381);
        return;
      }
      AppMethodBeat.o(168381);
    }
    
    public final void eP(boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168383);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
        FinderPostFooter.a(this.wox, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168383);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onBack"})
  static final class h
    implements MMEditText.a
  {
    h(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onBack()
    {
      AppMethodBeat.i(168384);
      kotlin.g.a.a locala = this.wox.getBackClickListener();
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(168384);
        return;
      }
      AppMethodBeat.o(168384);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168385);
      this.wox.getSmileyPanel().setAlpha(1.0F);
      this.wox.getSmileyPanel().setVisibility(4);
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