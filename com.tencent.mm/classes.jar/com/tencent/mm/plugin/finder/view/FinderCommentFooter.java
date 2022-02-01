package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.q;
import d.l;
import d.n.n;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "banSwitchScene", "", "getBanSwitchScene", "()Z", "setBanSwitchScene", "(Z)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "setFrozen", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "lastActionStr", "", "getLastActionStr", "()Ljava/lang/String;", "setLastActionStr", "(Ljava/lang/String;)V", "lastFromName", "getLastFromName", "setLastFromName", "lastTag", "", "getLastTag", "()Ljava/lang/Object;", "setLastTag", "(Ljava/lang/Object;)V", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "fromName", "actionStr", "tag", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "showRemark", "changeReplyToCommenter", "toName", "changeReplyToPoster", "changeSelfName", "selfName", "ellipseName", "name", "getAvatarView", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "showVKB", "isShow", "Companion", "IModeChangeCallback", "plugin-finder_release"})
public final class FinderCommentFooter
  extends LinearLayout
  implements com.tencent.mm.ui.tools.g
{
  public static final FinderCommentFooter.a tey;
  public SmileyPanel gXW;
  private int gXX;
  private boolean gXY;
  private int scene;
  private boolean tdQ;
  public ImageView ted;
  public TextView tee;
  public View tef;
  public TextView teg;
  public ImageView teh;
  public MMEditText tei;
  public View tej;
  public View tek;
  public ImageView tel;
  private int tem;
  private float ten;
  private boolean teo;
  private boolean tep;
  private b teq;
  private d.g.a.a<z> ter;
  private d.g.a.a<z> tes;
  private boolean tet;
  public int teu;
  public String tev;
  private String tew;
  private Object tex;
  
  static
  {
    AppMethodBeat.i(168295);
    tey = new FinderCommentFooter.a((byte)0);
    AppMethodBeat.o(168295);
  }
  
  public FinderCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168294);
    this.ten = com.tencent.mm.sdk.platformtools.aa.iK(getContext());
    this.gXX = aq.ay(getContext(), 2131165299);
    this.scene = 2;
    this.tev = "";
    this.tew = "";
    AppMethodBeat.o(168294);
  }
  
  private void akf(String paramString)
  {
    AppMethodBeat.i(205740);
    d.g.b.p.h(paramString, "selfName");
    e(akg(paramString), this.tew, this.tex);
    AppMethodBeat.o(205740);
  }
  
  private final boolean cPP()
  {
    AppMethodBeat.i(178488);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cJa().value()).intValue() == 1) && (!this.tdQ))
    {
      localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      if ((com.tencent.mm.plugin.finder.utils.p.cOe()) && (!this.tet))
      {
        AppMethodBeat.o(178488);
        return true;
      }
    }
    AppMethodBeat.o(178488);
    return false;
  }
  
  public final String akg(String paramString)
  {
    AppMethodBeat.i(205744);
    Object localObject = com.tencent.mm.plugin.finder.convert.a.rUe;
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i = com.tencent.mm.plugin.finder.convert.a.U((Context)localObject, com.tencent.mm.plugin.finder.storage.b.cIp());
    localObject = com.tencent.mm.plugin.finder.convert.a.rUe;
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    int j = com.tencent.mm.plugin.finder.convert.a.U((Context)localObject, com.tencent.mm.plugin.finder.storage.b.cIp() + 1);
    localObject = com.tencent.mm.plugin.finder.convert.a.rUe;
    localObject = this.tei;
    if (localObject == null) {
      d.g.b.p.bdF("editText");
    }
    localObject = ((MMEditText)localObject).getPaint();
    d.g.b.p.g(localObject, "editText.paint");
    paramString = com.tencent.mm.plugin.finder.convert.a.a((TextPaint)localObject, paramString, i, j);
    AppMethodBeat.o(205744);
    return paramString;
  }
  
  public final void bY(boolean paramBoolean)
  {
    Context localContext = null;
    Object localObject = null;
    AppMethodBeat.i(168292);
    if (this.tep)
    {
      AppMethodBeat.o(168292);
      return;
    }
    if ((this.teo) && (paramBoolean))
    {
      AppMethodBeat.o(168292);
      return;
    }
    if (paramBoolean)
    {
      localContext = getContext();
      if ((localContext instanceof MMActivity)) {
        break label129;
      }
    }
    for (;;)
    {
      localObject = (MMActivity)localObject;
      if (localObject != null)
      {
        ((MMActivity)localObject).showVKB();
        AppMethodBeat.o(168292);
        return;
      }
      AppMethodBeat.o(168292);
      return;
      localObject = getContext();
      if (!(localObject instanceof MMActivity)) {
        localObject = localContext;
      }
      for (;;)
      {
        localObject = (MMActivity)localObject;
        if (localObject != null)
        {
          ((MMActivity)localObject).hideVKB();
          AppMethodBeat.o(168292);
          return;
        }
        AppMethodBeat.o(168292);
        return;
      }
      label129:
      localObject = localContext;
    }
  }
  
  public final void c(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(178487);
    d.g.b.p.h(paramString1, "fromName");
    d.g.b.p.h(paramString2, "toName");
    e(this.tev, " " + getResources().getString(2131757530, new Object[] { paramString2 }), paramObject);
    AppMethodBeat.o(178487);
  }
  
  public final void cPN()
  {
    AppMethodBeat.i(178484);
    Object localObject = this.tef;
    if (localObject == null) {
      d.g.b.p.bdF("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    cPO();
    localObject = findViewById(2131298533);
    if (cPP())
    {
      ((View)localObject).findViewById(2131298530).setVisibility(0);
      ((View)localObject).setOnClickListener((View.OnClickListener)new m(this));
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cJc() > 0)
      {
        localObject = this.tef;
        if (localObject == null) {
          d.g.b.p.bdF("switchSceneTip");
        }
        ((View)localObject).setVisibility(0);
      }
      localObject = this.tel;
      if (localObject == null) {
        d.g.b.p.bdF("targetAvatar");
      }
      ((ImageView)localObject).setVisibility(8);
      localObject = this.tei;
      if (localObject == null) {
        d.g.b.p.bdF("editText");
      }
      Context localContext = ((MMEditText)localObject).getContext();
      d.g.b.p.g(localContext, "this.context");
      int i = (int)localContext.getResources().getDimension(2131165303);
      localContext = ((MMEditText)localObject).getContext();
      d.g.b.p.g(localContext, "this.context");
      ((MMEditText)localObject).setPadding(i, 0, (int)localContext.getResources().getDimension(2131165303), 0);
      AppMethodBeat.o(178484);
      return;
      ((View)localObject).setOnClickListener((View.OnClickListener)FinderCommentFooter.n.teG);
      localObject = ((View)localObject).findViewById(2131298530);
      d.g.b.p.g(localObject, "switchClickLayout.findVi…>(R.id.comment_scene_btn)");
      ((View)localObject).setVisibility(8);
    }
  }
  
  public final void cPO()
  {
    AppMethodBeat.i(178485);
    Object localObject1;
    if (this.scene == 2)
    {
      localObject1 = this.ted;
      if (localObject1 == null) {
        d.g.b.p.bdF("switchSceneAvatar");
      }
      com.tencent.mm.ui.f.a.a.c((ImageView)localObject1, com.tencent.mm.model.v.aAC());
      localObject1 = this.teg;
      if (localObject1 == null) {
        d.g.b.p.bdF("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131766853);
    }
    for (;;)
    {
      localObject1 = this.tee;
      if (localObject1 == null) {
        d.g.b.p.bdF("switchSceneName");
      }
      Object localObject2 = getContext();
      Object localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
      ((TextView)localObject1).setText((CharSequence)k.c((Context)localObject2, (CharSequence)com.tencent.mm.plugin.finder.utils.p.Gk(this.scene)));
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      akf(com.tencent.mm.plugin.finder.utils.p.Gk(this.scene));
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cJc() <= 0)
      {
        localObject1 = this.tef;
        if (localObject1 == null) {
          d.g.b.p.bdF("switchSceneTip");
        }
        if (((View)localObject1).getVisibility() == 0)
        {
          localObject1 = this.tef;
          if (localObject1 == null) {
            d.g.b.p.bdF("switchSceneTip");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(178485);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
      localObject1 = c.a.ahT(com.tencent.mm.model.v.aAK());
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject1).czm();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = i.srW;
      localObject2 = i.cEo();
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject3 = this.ted;
      if (localObject3 == null) {
        d.g.b.p.bdF("switchSceneAvatar");
      }
      i locali = i.srW;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, i.a(i.a.srZ));
      localObject1 = this.teg;
      if (localObject1 == null) {
        d.g.b.p.bdF("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131766853);
    }
  }
  
  public final void e(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(205743);
    if (paramString1 == null) {}
    for (String str = "";; str = paramString1)
    {
      this.tev = str;
      this.tew = paramString2;
      this.tex = paramObject;
      paramString1 = d.g.b.p.C(paramString1, paramString2);
      paramString2 = this.tei;
      if (paramString2 == null) {
        d.g.b.p.bdF("editText");
      }
      paramString2.setHint((CharSequence)k.c(getContext(), (CharSequence)paramString1));
      paramString1 = this.tei;
      if (paramString1 == null) {
        d.g.b.p.bdF("editText");
      }
      paramString1.setTag(paramObject);
      paramString1 = this.tei;
      if (paramString1 == null) {
        d.g.b.p.bdF("editText");
      }
      if (!paramString1.hasFocus())
      {
        paramString1 = this.tei;
        if (paramString1 == null) {
          d.g.b.p.bdF("editText");
        }
        paramString1.requestFocus();
      }
      AppMethodBeat.o(205743);
      return;
    }
  }
  
  public final void gF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178486);
    d.g.b.p.h(paramString1, "fromName");
    d.g.b.p.h(paramString2, "toName");
    e(this.tev, " " + getResources().getString(2131763113), null);
    AppMethodBeat.o(178486);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(168293);
    ImageView localImageView = this.tel;
    if (localImageView == null) {
      d.g.b.p.bdF("targetAvatar");
    }
    AppMethodBeat.o(168293);
    return localImageView;
  }
  
  public final d.g.a.a<z> getBackClickListener()
  {
    return this.ter;
  }
  
  public final boolean getBanSwitchScene()
  {
    return this.tet;
  }
  
  public final View getCommentEditTextLayout()
  {
    AppMethodBeat.i(168283);
    View localView = this.tek;
    if (localView == null) {
      d.g.b.p.bdF("commentEditTextLayout");
    }
    AppMethodBeat.o(168283);
    return localView;
  }
  
  public final int getCommentTextLimit()
  {
    return this.tem;
  }
  
  public final MMEditText getEditText()
  {
    AppMethodBeat.i(168279);
    MMEditText localMMEditText = this.tei;
    if (localMMEditText == null) {
      d.g.b.p.bdF("editText");
    }
    AppMethodBeat.o(168279);
    return localMMEditText;
  }
  
  public final int getFooterMode()
  {
    return this.teu;
  }
  
  public final String getLastActionStr()
  {
    return this.tew;
  }
  
  public final String getLastFromName()
  {
    return this.tev;
  }
  
  public final Object getLastTag()
  {
    return this.tex;
  }
  
  public final b getModeChangeCallback()
  {
    return this.teq;
  }
  
  public final View getReplyBtn()
  {
    AppMethodBeat.i(168281);
    View localView = this.tej;
    if (localView == null) {
      d.g.b.p.bdF("replyBtn");
    }
    AppMethodBeat.o(168281);
    return localView;
  }
  
  public final int getReplyBtnWidth()
  {
    return this.gXX;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final boolean getSendBtnEnabled()
  {
    return this.gXY;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168277);
    ImageView localImageView = this.teh;
    if (localImageView == null) {
      d.g.b.p.bdF("smileyBtn");
    }
    AppMethodBeat.o(168277);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168275);
    SmileyPanel localSmileyPanel = this.gXW;
    if (localSmileyPanel == null) {
      d.g.b.p.bdF("smileyPanel");
    }
    AppMethodBeat.o(168275);
    return localSmileyPanel;
  }
  
  public final ImageView getSwitchSceneAvatar()
  {
    AppMethodBeat.i(178476);
    ImageView localImageView = this.ted;
    if (localImageView == null) {
      d.g.b.p.bdF("switchSceneAvatar");
    }
    AppMethodBeat.o(178476);
    return localImageView;
  }
  
  public final d.g.a.a<z> getSwitchSceneListener()
  {
    return this.tes;
  }
  
  public final TextView getSwitchSceneName()
  {
    AppMethodBeat.i(178478);
    TextView localTextView = this.tee;
    if (localTextView == null) {
      d.g.b.p.bdF("switchSceneName");
    }
    AppMethodBeat.o(178478);
    return localTextView;
  }
  
  public final View getSwitchSceneTip()
  {
    AppMethodBeat.i(178480);
    View localView = this.tef;
    if (localView == null) {
      d.g.b.p.bdF("switchSceneTip");
    }
    AppMethodBeat.o(178480);
    return localView;
  }
  
  public final TextView getSwitchSceneTipTv()
  {
    AppMethodBeat.i(178482);
    TextView localTextView = this.teg;
    if (localTextView == null) {
      d.g.b.p.bdF("switchSceneTipTv");
    }
    AppMethodBeat.o(178482);
    return localTextView;
  }
  
  public final ImageView getTargetAvatar()
  {
    AppMethodBeat.i(168285);
    ImageView localImageView = this.tel;
    if (localImageView == null) {
      d.g.b.p.bdF("targetAvatar");
    }
    AppMethodBeat.o(168285);
    return localImageView;
  }
  
  public final void mt(final boolean paramBoolean)
  {
    AppMethodBeat.i(168290);
    if (this.tep)
    {
      AppMethodBeat.o(168290);
      return;
    }
    Object localObject = this.teh;
    if (localObject == null) {
      d.g.b.p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.teh;
    if (localObject == null) {
      d.g.b.p.bdF("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    if (paramBoolean)
    {
      animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(220L).translationY(this.ten).setListener((Animator.AnimatorListener)new g(this, paramBoolean)).start();
      AppMethodBeat.o(168290);
      return;
    }
    localObject = this.gXW;
    if (localObject == null) {
      d.g.b.p.bdF("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new h(this)).start();
    AppMethodBeat.o(168290);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168289);
    super.onFinishInflate();
    Object localObject = findViewById(2131298529);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_scene_avatar)");
    this.ted = ((ImageView)localObject);
    localObject = findViewById(2131298531);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_scene_name)");
    this.tee = ((TextView)localObject);
    localObject = findViewById(2131298535);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_switch_scene_tip_layout)");
    this.tef = ((View)localObject);
    localObject = findViewById(2131298536);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_switch_scene_tip_tv)");
    this.teg = ((TextView)localObject);
    localObject = findViewById(2131304863);
    d.g.b.p.g(localObject, "findViewById(R.id.smiley_btn)");
    this.teh = ((ImageView)localObject);
    localObject = findViewById(2131298513);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_et)");
    this.tei = ((MMEditText)localObject);
    localObject = findViewById(2131298537);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_target_avatar)");
    this.tel = ((ImageView)localObject);
    localObject = findViewById(2131304080);
    d.g.b.p.g(localObject, "findViewById(R.id.reply_btn)");
    this.tej = ((View)localObject);
    localObject = findViewById(2131298514);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_et_layout)");
    this.tek = ((View)localObject);
    if (al.isDarkMode())
    {
      localObject = this.tef;
      if (localObject == null) {
        d.g.b.p.bdF("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131235001);
    }
    for (;;)
    {
      localObject = this.teh;
      if (localObject == null) {
        d.g.b.p.bdF("smileyBtn");
      }
      ((ImageView)localObject).setTag(Boolean.FALSE);
      localObject = com.tencent.mm.api.aa.k(getContext(), false);
      d.g.b.p.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
      this.gXW = ((SmileyPanel)localObject);
      localObject = this.gXW;
      if (localObject == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.rRG);
      localObject = this.gXW;
      if (localObject == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      ((SmileyPanel)localObject).setBackgroundResource(2131232332);
      localObject = this.gXW;
      if (localObject == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      ((SmileyPanel)localObject).fft();
      localObject = this.gXW;
      if (localObject == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      ((SmileyPanel)localObject).ffv();
      localObject = this.gXW;
      if (localObject == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      ((SmileyPanel)localObject).ffu();
      localObject = this.gXW;
      if (localObject == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      ((SmileyPanel)localObject).setVisibility(4);
      localObject = this.gXW;
      if (localObject == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      ((SmileyPanel)localObject).onResume();
      localObject = this.gXW;
      if (localObject == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new d(this));
      localObject = new LinearLayout.LayoutParams(-1, (int)this.ten);
      SmileyPanel localSmileyPanel = this.gXW;
      if (localSmileyPanel == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localSmileyPanel = this.gXW;
      if (localSmileyPanel == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
      localObject = this.teh;
      if (localObject == null) {
        d.g.b.p.bdF("smileyBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      setTranslationY(this.ten);
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      this.tem = (((Number)com.tencent.mm.plugin.finder.storage.b.cIT().value()).intValue() * 2);
      localObject = this.tej;
      if (localObject == null) {
        d.g.b.p.bdF("replyBtn");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.tei;
      if (localObject == null) {
        d.g.b.p.bdF("editText");
      }
      ((MMEditText)localObject).addTextChangedListener((TextWatcher)new f(this));
      localObject = this.tei;
      if (localObject == null) {
        d.g.b.p.bdF("editText");
      }
      com.tencent.mm.ui.tools.b.c.d((EditText)localObject).kj(0, this.tem).a(null);
      cPN();
      AppMethodBeat.o(168289);
      return;
      localObject = this.tef;
      if (localObject == null) {
        d.g.b.p.bdF("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131235000);
    }
  }
  
  public final void setBackClickListener(d.g.a.a<z> parama)
  {
    this.ter = parama;
  }
  
  public final void setBanSwitchScene(boolean paramBoolean)
  {
    this.tet = paramBoolean;
  }
  
  public final void setCommentEditTextLayout(View paramView)
  {
    AppMethodBeat.i(168284);
    d.g.b.p.h(paramView, "<set-?>");
    this.tek = paramView;
    AppMethodBeat.o(168284);
  }
  
  public final void setCommentTextLimit(int paramInt)
  {
    this.tem = paramInt;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(168280);
    d.g.b.p.h(paramMMEditText, "<set-?>");
    this.tei = paramMMEditText;
    AppMethodBeat.o(168280);
  }
  
  public final void setFooterMode(int paramInt)
  {
    AppMethodBeat.i(168287);
    b localb = this.teq;
    if (localb != null) {
      localb.onModeChange(this.teu, paramInt);
    }
    this.teu = paramInt;
    AppMethodBeat.o(168287);
  }
  
  public final void setFrozen(boolean paramBoolean)
  {
    this.tep = paramBoolean;
  }
  
  public final void setLastActionStr(String paramString)
  {
    AppMethodBeat.i(205742);
    d.g.b.p.h(paramString, "<set-?>");
    this.tew = paramString;
    AppMethodBeat.o(205742);
  }
  
  public final void setLastFromName(String paramString)
  {
    AppMethodBeat.i(205741);
    d.g.b.p.h(paramString, "<set-?>");
    this.tev = paramString;
    AppMethodBeat.o(205741);
  }
  
  public final void setLastTag(Object paramObject)
  {
    this.tex = paramObject;
  }
  
  public final void setModeChangeCallback(b paramb)
  {
    this.teq = paramb;
  }
  
  public final void setReplyBtn(View paramView)
  {
    AppMethodBeat.i(168282);
    d.g.b.p.h(paramView, "<set-?>");
    this.tej = paramView;
    AppMethodBeat.o(168282);
  }
  
  public final void setReplyBtnWidth(int paramInt)
  {
    this.gXX = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(205739);
    if ((j.DEBUG) || (j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED)) {
      ae.m("Finder.FinderCommentFooter", "set footer scene:".concat(String.valueOf(paramInt)), new Object[0]);
    }
    this.scene = paramInt;
    AppMethodBeat.o(205739);
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.tdQ = paramBoolean;
  }
  
  public final void setSendBtnEnabled(boolean paramBoolean)
  {
    this.gXY = paramBoolean;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168278);
    d.g.b.p.h(paramImageView, "<set-?>");
    this.teh = paramImageView;
    AppMethodBeat.o(168278);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168276);
    d.g.b.p.h(paramSmileyPanel, "<set-?>");
    this.gXW = paramSmileyPanel;
    AppMethodBeat.o(168276);
  }
  
  public final void setSwitchSceneAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(178477);
    d.g.b.p.h(paramImageView, "<set-?>");
    this.ted = paramImageView;
    AppMethodBeat.o(178477);
  }
  
  public final void setSwitchSceneListener(d.g.a.a<z> parama)
  {
    this.tes = parama;
  }
  
  public final void setSwitchSceneName(TextView paramTextView)
  {
    AppMethodBeat.i(178479);
    d.g.b.p.h(paramTextView, "<set-?>");
    this.tee = paramTextView;
    AppMethodBeat.o(178479);
  }
  
  public final void setSwitchSceneTip(View paramView)
  {
    AppMethodBeat.i(178481);
    d.g.b.p.h(paramView, "<set-?>");
    this.tef = paramView;
    AppMethodBeat.o(178481);
  }
  
  public final void setSwitchSceneTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(178483);
    d.g.b.p.h(paramTextView, "<set-?>");
    this.teg = paramTextView;
    AppMethodBeat.o(178483);
  }
  
  public final void setTargetAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(168286);
    d.g.b.p.h(paramImageView, "<set-?>");
    this.tel = paramImageView;
    AppMethodBeat.o(168286);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168288);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.tep; paramBoolean = false)
    {
      AppMethodBeat.o(168288);
      return;
    }
    if ((paramInt > 0) && (paramInt != (int)this.ten))
    {
      com.tencent.mm.sdk.platformtools.aa.aF(getContext(), paramInt);
      this.ten = paramInt;
      localObject = new LinearLayout.LayoutParams(-1, (int)this.ten);
      SmileyPanel localSmileyPanel = this.gXW;
      if (localSmileyPanel == null) {
        d.g.b.p.bdF("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.teo != paramBoolean)
    {
      this.teo = paramBoolean;
      if (!paramBoolean) {
        break label191;
      }
      animate().setDuration(90L).translationY(0.0F).setListener((Animator.AnimatorListener)new i(this)).start();
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if ((com.tencent.mm.plugin.finder.storage.b.cJc() <= 0) || (!cPP())) {
        break;
      }
      localObject = this.tef;
      if (localObject == null) {
        d.g.b.p.bdF("switchSceneTip");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(168288);
      return;
      label191:
      if ((this.teu == 2) || (this.teu == 0)) {
        animate().setDuration(180L).translationY(this.ten).setListener((Animator.AnimatorListener)new j(this)).start();
      }
    }
    Object localObject = this.tef;
    if (localObject == null) {
      d.g.b.p.bdF("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168288);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "", "onModeChange", "", "from", "", "to", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void onModeChange(int paramInt1, int paramInt2);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class d
    implements ChatFooterPanel.a
  {
    public final void apc()
    {
      AppMethodBeat.i(168257);
      if (this.teB.getEditText().getInputConnection() != null)
      {
        this.teB.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        this.teB.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      }
      AppMethodBeat.o(168257);
    }
    
    public final void apd() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168256);
      this.teB.getEditText().aZf(paramString);
      AppMethodBeat.o(168256);
    }
    
    public final void dW(boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (paramView == null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(168258);
        throw paramView;
      }
      paramView = ((ImageView)paramView).getTag();
      if (paramView == null)
      {
        paramView = new d.v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(168258);
        throw paramView;
      }
      if (!((Boolean)paramView).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        FinderCommentFooter.a(this.teB, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168258);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class f
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(205731);
      int i;
      if (paramEditable != null) {
        if (((CharSequence)paramEditable).length() > 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          paramEditable = String.valueOf(paramEditable);
          if (paramEditable == null)
          {
            paramEditable = new d.v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(205731);
            throw paramEditable;
            i = 0;
            continue;
            i = 0;
          }
          else if (((CharSequence)n.trim((CharSequence)paramEditable).toString()).length() > 0)
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
        if (bool != this.teB.getSendBtnEnabled()) {
          break label119;
        }
        AppMethodBeat.o(205731);
        return;
        i = 0;
        break;
      }
      label119:
      this.teB.setSendBtnEnabled(bool);
      if (this.teB.getSendBtnEnabled())
      {
        paramEditable = new ValueAnimator();
        paramEditable.setIntValues(new int[] { 0, this.teB.getReplyBtnWidth() });
        paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
        paramEditable.setDuration(150L);
        paramEditable.addListener((Animator.AnimatorListener)new b(this));
        paramEditable.start();
        AppMethodBeat.o(205731);
        return;
      }
      paramEditable = new ValueAnimator();
      paramEditable.setIntValues(new int[] { this.teB.getReplyBtnWidth(), 0 });
      paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
      paramEditable.setDuration(150L);
      paramEditable.addListener((Animator.AnimatorListener)new d(this));
      paramEditable.start();
      AppMethodBeat.o(205731);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(FinderCommentFooter.f paramf) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(205723);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(205723);
          throw paramValueAnimator;
        }
        float f = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.teC.teB.getReplyBtn().getLayoutParams();
        paramValueAnimator.width = d.h.a.cm(f);
        this.teC.teB.getReplyBtn().setLayoutParams(paramValueAnimator);
        this.teC.teB.getReplyBtn().setAlpha(f / this.teC.teB.getReplyBtnWidth());
        AppMethodBeat.o(205723);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(205725);
        paramAnimator = this.teC.teB.getReplyBtn().getLayoutParams();
        paramAnimator.width = this.teC.teB.getReplyBtnWidth();
        this.teC.teB.getReplyBtn().setLayoutParams(paramAnimator);
        this.teC.teB.getReplyBtn().setAlpha(1.0F);
        AppMethodBeat.o(205725);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(205724);
        paramAnimator = this.teC.teB.getReplyBtn().getLayoutParams();
        paramAnimator.width = this.teC.teB.getReplyBtnWidth();
        this.teC.teB.getReplyBtn().setLayoutParams(paramAnimator);
        this.teC.teB.getReplyBtn().setAlpha(1.0F);
        AppMethodBeat.o(205724);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(205726);
        this.teC.teB.getReplyBtn().setVisibility(0);
        AppMethodBeat.o(205726);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class c
      implements ValueAnimator.AnimatorUpdateListener
    {
      c(FinderCommentFooter.f paramf) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(205727);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(205727);
          throw paramValueAnimator;
        }
        float f = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.teC.teB.getReplyBtn().getLayoutParams();
        paramValueAnimator.width = d.h.a.cm(f);
        this.teC.teB.getReplyBtn().setLayoutParams(paramValueAnimator);
        this.teC.teB.getReplyBtn().setAlpha(f / this.teC.teB.getReplyBtnWidth());
        AppMethodBeat.o(205727);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class d
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(205729);
        this.teC.teB.getReplyBtn().setVisibility(8);
        AppMethodBeat.o(205729);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(205728);
        this.teC.teB.getReplyBtn().setVisibility(8);
        AppMethodBeat.o(205728);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(205730);
        this.teC.teB.getReplyBtn().setVisibility(0);
        AppMethodBeat.o(205730);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168269);
      this.teB.getSmileyPanel().setVisibility(4);
      this.teB.getSmileyBtn().setImageResource(2131231701);
      if (paramBoolean) {
        this.teB.setFooterMode(0);
      }
      AppMethodBeat.o(168269);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168270);
      this.teB.getSmileyPanel().setAlpha(1.0F);
      this.teB.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168270);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205732);
      this.teB.setFooterMode(2);
      AppMethodBeat.o(205732);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205733);
      this.teB.setFooterMode(0);
      AppMethodBeat.o(205733);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class k
    implements View.OnLayoutChangeListener
  {
    k(d.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(168273);
      this.teB.getSmileyPanel().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      this.teE.invoke();
      AppMethodBeat.o(168273);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<z>
  {
    l(FinderCommentFooter paramFinderCommentFooter)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205736);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cJc() > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
        com.tencent.mm.plugin.finder.storage.b.FE(0);
        this.teB.getSwitchSceneTip().setVisibility(8);
        paramView = new d(this.teB.getContext());
        paramView.GC(2131494115);
        al.a((Paint)((TextView)paramView.kFh.findViewById(2131300009)).getPaint(), 0.8F);
        localObject = paramView.kFh.findViewById(2131300007);
        FinderCommentFooter localFinderCommentFooter = this.teB;
        d.g.b.p.g(localObject, "item1");
        FinderCommentFooter.a(localFinderCommentFooter, (View)localObject, 1, (d.g.a.b)new a(paramView, this));
        localObject = paramView.kFh.findViewById(2131300008);
        localFinderCommentFooter = this.teB;
        d.g.b.p.g(localObject, "item2");
        FinderCommentFooter.a(localFinderCommentFooter, (View)localObject, 2, (d.g.a.b)new b(paramView, this));
        paramView.cPF();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205736);
        return;
        FinderCommentFooter.a(this.teB);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$1"})
    static final class a
      extends q
      implements d.g.a.b<Integer, z>
    {
      a(d paramd, FinderCommentFooter.m paramm)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$2"})
    static final class b
      extends q
      implements d.g.a.b<Integer, z>
    {
      b(d paramd, FinderCommentFooter.m paramm)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter
 * JD-Core Version:    0.7.0.1
 */