package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputConnection;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ae;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.publish.l.d;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "setActivity", "(Lcom/tencent/mm/ui/MMActivity;)V", "activityReqCode", "", "getActivityReqCode", "()I", "setActivityReqCode", "(I)V", "atBtn", "Landroid/view/View;", "getAtBtn", "()Landroid/view/View;", "setAtBtn", "(Landroid/view/View;)V", "atReqCode", "getAtReqCode", "setAtReqCode", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "container", "getContainer", "setContainer", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "iTopicCallback", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "getITopicCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "setITopicCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;)V", "isShowKeyboard", "", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "topicBtn", "getTopicBtn", "setTopicBtn", "initView", "onFinishInflate", "onHideSmileyPanel", "onKeyboardHeightChanged", "height", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "showAtBtn", "show", "showTopicBtn", "Companion", "ITopicCallback", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPostFooter
  extends LinearLayout
{
  public static final FinderPostFooter.a GBA;
  private kotlin.g.a.a<ah> EpU;
  public float FZp;
  public ImageView GBB;
  public View GBC;
  public View GBD;
  private MMEditText GBE;
  private int GBF;
  private int GBG;
  public FinderPostFooter.b GBH;
  public MMActivity activity;
  public View hDw;
  public SmileyPanel niv;
  
  static
  {
    AppMethodBeat.i(168396);
    GBA = new FinderPostFooter.a((byte)0);
    AppMethodBeat.o(168396);
  }
  
  public FinderPostFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168395);
    this.FZp = KeyBoardUtil.getKeyBordHeightPx(getContext());
    AppMethodBeat.o(168395);
  }
  
  private static final void a(FinderPostFooter.b paramb, View paramView)
  {
    AppMethodBeat.i(344023);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderPostFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$iTopicCallback");
    paramb.eHe();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderPostFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344023);
  }
  
  private static final void a(FinderPostFooter paramFinderPostFooter)
  {
    AppMethodBeat.i(344054);
    s.u(paramFinderPostFooter, "this$0");
    paramFinderPostFooter = paramFinderPostFooter.getBackClickListener();
    if (paramFinderPostFooter != null) {
      paramFinderPostFooter.invoke();
    }
    AppMethodBeat.o(344054);
  }
  
  private static final void a(FinderPostFooter paramFinderPostFooter, View paramView)
  {
    AppMethodBeat.i(344046);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderPostFooter);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderPostFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderPostFooter, "this$0");
    if (paramView == null)
    {
      paramFinderPostFooter = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(344046);
      throw paramFinderPostFooter;
    }
    paramView = ((ImageView)paramView).getTag();
    if (paramView == null)
    {
      paramFinderPostFooter = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(344046);
      throw paramFinderPostFooter;
    }
    if (!((Boolean)paramView).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      paramFinderPostFooter.ao(bool, true);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderPostFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344046);
      return;
    }
  }
  
  private static final void a(MMActivity paramMMActivity, int paramInt, View paramView)
  {
    AppMethodBeat.i(344030);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramMMActivity);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderPostFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMMActivity, "$activity");
    paramView = new Intent();
    paramView.putExtra("key_scene", 1);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.b(paramMMActivity, paramView, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderPostFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344030);
  }
  
  private final void bjm()
  {
    AppMethodBeat.i(168394);
    getSmileyBtn().setImageResource(l.d.chatting_setmode_biaoqing_btn);
    getSmileyBtn().setTag(Boolean.FALSE);
    getSmileyPanel().animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(168394);
  }
  
  private final void flc()
  {
    AppMethodBeat.i(168393);
    getSmileyPanel().setVisibility(0);
    getSmileyBtn().setImageResource(l.d.chatting_setmode_biaoqing_btn);
    getSmileyBtn().setTag(Boolean.TRUE);
    getSmileyPanel().setAlpha(0.0F);
    getSmileyPanel().animate().alpha(1.0F).setDuration(220L).setListener(null).start();
    AppMethodBeat.o(168393);
  }
  
  private static final void fm(View paramView)
  {
    AppMethodBeat.i(344037);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderPostFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderPostFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344037);
  }
  
  public final void a(MMActivity paramMMActivity, View paramView1, MMEditText paramMMEditText, FinderPostFooter.b paramb, View paramView2, View paramView3)
  {
    AppMethodBeat.i(344224);
    s.u(paramMMActivity, "activity");
    s.u(paramView1, "container");
    s.u(paramMMEditText, "editText");
    s.u(paramb, "iTopicCallback");
    s.u(paramView2, "atBtn");
    s.u(paramView3, "topicBtn");
    setActivity(paramMMActivity);
    this.hDw = paramView1;
    this.GBE = paramMMEditText;
    this.GBF = 20001;
    this.GBG = this.GBG;
    setITopicCallback(paramb);
    setAtBtn(paramView2);
    setTopicBtn(paramView3);
    paramView3.setOnClickListener(new FinderPostFooter..ExternalSyntheticLambda0(paramb));
    paramView2.setOnClickListener(new FinderPostFooter..ExternalSyntheticLambda2(paramMMActivity, 20001));
    paramMMActivity = d.FAy;
    if (d.eRs()) {
      paramView3.setVisibility(0);
    }
    for (;;)
    {
      setOnClickListener(FinderPostFooter..ExternalSyntheticLambda3.INSTANCE);
      AppMethodBeat.o(344224);
      return;
      paramView3.setVisibility(8);
    }
  }
  
  public final void ao(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(168391);
    Object localObject;
    if (!paramBoolean1)
    {
      bjm();
      if (paramBoolean2)
      {
        localObject = getContext();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(168391);
          throw ((Throwable)localObject);
        }
        ((MMActivity)localObject).showVKB();
      }
    }
    while (paramBoolean1)
    {
      getSmileyBtn().setImageResource(l.d.chatting_setmode_keyboard_btn);
      AppMethodBeat.o(168391);
      return;
      flc();
      localObject = getContext();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(168391);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).hideVKB();
    }
    getSmileyBtn().setImageResource(l.d.chatting_setmode_biaoqing_btn);
    AppMethodBeat.o(168391);
  }
  
  public final MMActivity getActivity()
  {
    AppMethodBeat.i(344107);
    MMActivity localMMActivity = this.activity;
    if (localMMActivity != null)
    {
      AppMethodBeat.o(344107);
      return localMMActivity;
    }
    s.bIx("activity");
    AppMethodBeat.o(344107);
    return null;
  }
  
  public final int getActivityReqCode()
  {
    return this.GBG;
  }
  
  public final View getAtBtn()
  {
    AppMethodBeat.i(344155);
    View localView = this.GBD;
    if (localView != null)
    {
      AppMethodBeat.o(344155);
      return localView;
    }
    s.bIx("atBtn");
    AppMethodBeat.o(344155);
    return null;
  }
  
  public final int getAtReqCode()
  {
    return this.GBF;
  }
  
  public final kotlin.g.a.a<ah> getBackClickListener()
  {
    return this.EpU;
  }
  
  public final View getContainer()
  {
    return this.hDw;
  }
  
  public final MMEditText getEditText()
  {
    return this.GBE;
  }
  
  public final FinderPostFooter.b getITopicCallback()
  {
    AppMethodBeat.i(344207);
    FinderPostFooter.b localb = this.GBH;
    if (localb != null)
    {
      AppMethodBeat.o(344207);
      return localb;
    }
    s.bIx("iTopicCallback");
    AppMethodBeat.o(344207);
    return null;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168388);
    ImageView localImageView = this.GBB;
    if (localImageView != null)
    {
      AppMethodBeat.o(168388);
      return localImageView;
    }
    s.bIx("smileyBtn");
    AppMethodBeat.o(168388);
    return null;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168386);
    SmileyPanel localSmileyPanel = this.niv;
    if (localSmileyPanel != null)
    {
      AppMethodBeat.o(168386);
      return localSmileyPanel;
    }
    s.bIx("smileyPanel");
    AppMethodBeat.o(168386);
    return null;
  }
  
  public final View getTopicBtn()
  {
    AppMethodBeat.i(344140);
    View localView = this.GBC;
    if (localView != null)
    {
      AppMethodBeat.o(344140);
      return localView;
    }
    s.bIx("topicBtn");
    AppMethodBeat.o(344140);
    return null;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168390);
    super.onFinishInflate();
    Object localObject = findViewById(l.e.smiley_btn);
    s.s(localObject, "findViewById(R.id.smiley_btn)");
    setSmileyBtn((ImageView)localObject);
    this.GBE = ((MMEditText)findViewById(l.e.comment_et));
    getSmileyBtn().setTag(Boolean.FALSE);
    localObject = ae.m(getContext(), false);
    s.s(localObject, "getSmileyPanel(context, false)");
    setSmileyPanel((SmileyPanel)localObject);
    getSmileyPanel().setEntranceScene(ChatFooterPanel.ACC);
    getSmileyPanel().setBackgroundResource(l.d.finder_bottombar_bg);
    getSmileyPanel().iKh();
    getSmileyPanel().iKi();
    getSmileyPanel().JA(false);
    getSmileyPanel().setVisibility(4);
    getSmileyPanel().onResume();
    getSmileyPanel().setOnTextOperationListener((ChatFooterPanel.a)new c(this));
    localObject = new LinearLayout.LayoutParams(-1, (int)this.FZp);
    getSmileyPanel().setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView((View)getSmileyPanel(), (ViewGroup.LayoutParams)localObject);
    getSmileyBtn().setOnClickListener(new FinderPostFooter..ExternalSyntheticLambda1(this));
    localObject = this.GBE;
    if (localObject != null) {
      ((MMEditText)localObject).setBackListener(new FinderPostFooter..ExternalSyntheticLambda4(this));
    }
    AppMethodBeat.o(168390);
  }
  
  public final void setActivity(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(344117);
    s.u(paramMMActivity, "<set-?>");
    this.activity = paramMMActivity;
    AppMethodBeat.o(344117);
  }
  
  public final void setActivityReqCode(int paramInt)
  {
    this.GBG = paramInt;
  }
  
  public final void setAtBtn(View paramView)
  {
    AppMethodBeat.i(344161);
    s.u(paramView, "<set-?>");
    this.GBD = paramView;
    AppMethodBeat.o(344161);
  }
  
  public final void setAtReqCode(int paramInt)
  {
    this.GBF = paramInt;
  }
  
  public final void setBackClickListener(kotlin.g.a.a<ah> parama)
  {
    this.EpU = parama;
  }
  
  public final void setContainer(View paramView)
  {
    this.hDw = paramView;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    this.GBE = paramMMEditText;
  }
  
  public final void setITopicCallback(FinderPostFooter.b paramb)
  {
    AppMethodBeat.i(344216);
    s.u(paramb, "<set-?>");
    this.GBH = paramb;
    AppMethodBeat.o(344216);
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168389);
    s.u(paramImageView, "<set-?>");
    this.GBB = paramImageView;
    AppMethodBeat.o(168389);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168387);
    s.u(paramSmileyPanel, "<set-?>");
    this.niv = paramSmileyPanel;
    AppMethodBeat.o(168387);
  }
  
  public final void setTopicBtn(View paramView)
  {
    AppMethodBeat.i(344149);
    s.u(paramView, "<set-?>");
    this.GBC = paramView;
    AppMethodBeat.o(344149);
  }
  
  public final void uV(boolean paramBoolean)
  {
    AppMethodBeat.i(344230);
    d locald = d.FAy;
    if ((d.eRs()) && (paramBoolean))
    {
      getTopicBtn().setVisibility(0);
      AppMethodBeat.o(344230);
      return;
    }
    getTopicBtn().setVisibility(8);
    AppMethodBeat.o(344230);
  }
  
  public final void uW(boolean paramBoolean)
  {
    AppMethodBeat.i(344237);
    d locald = d.FAy;
    if ((d.eRt()) && (paramBoolean))
    {
      getAtBtn().setVisibility(0);
      AppMethodBeat.o(344237);
      return;
    }
    getAtBtn().setVisibility(8);
    AppMethodBeat.o(344237);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ChatFooterPanel.a
  {
    c(FinderPostFooter paramFinderPostFooter) {}
    
    public final void aWL() {}
    
    public final void aWM()
    {
      AppMethodBeat.i(168382);
      Object localObject = this.GBI.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = this.GBI.getEditText();
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
        }
      }
      AppMethodBeat.o(168382);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168381);
      MMEditText localMMEditText = this.GBI.getEditText();
      if (localMMEditText != null) {
        localMMEditText.bDt(paramString);
      }
      AppMethodBeat.o(168381);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderPostFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(FinderPostFooter paramFinderPostFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168385);
      this.GBI.getSmileyPanel().setAlpha(1.0F);
      this.GBI.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter
 * JD-Core Version:    0.7.0.1
 */