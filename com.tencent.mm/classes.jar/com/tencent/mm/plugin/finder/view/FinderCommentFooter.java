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
import com.tencent.mm.api.aa;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import d.v;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "", "()Z", "setFrozen", "(Z)V", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "hint", "", "tag", "", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "showRemark", "changeReplyToCommenter", "fromName", "toName", "changeReplyToPoster", "getAvatarView", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "showVKB", "isShow", "Companion", "IModeChangeCallback", "plugin-finder_release"})
public final class FinderCommentFooter
  extends LinearLayout
  implements g
{
  public static final FinderCommentFooter.a rWy;
  public SmileyPanel gBD;
  private int gBE;
  private boolean gBF;
  private boolean rVV;
  public ImageView rWh;
  public TextView rWi;
  public View rWj;
  public TextView rWk;
  public ImageView rWl;
  public MMEditText rWm;
  public View rWn;
  public View rWo;
  public ImageView rWp;
  private int rWq;
  private float rWr;
  private boolean rWs;
  private boolean rWt;
  private b rWu;
  private d.g.a.a<d.y> rWv;
  private d.g.a.a<d.y> rWw;
  public int rWx;
  private int scene;
  
  static
  {
    AppMethodBeat.i(168295);
    rWy = new FinderCommentFooter.a((byte)0);
    AppMethodBeat.o(168295);
  }
  
  public FinderCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168294);
    this.rWr = com.tencent.mm.sdk.platformtools.y.iv(getContext());
    this.gBE = ao.av(getContext(), 2131165299);
    this.scene = 2;
    AppMethodBeat.o(168294);
  }
  
  private final boolean cEN()
  {
    AppMethodBeat.i(178488);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    if ((com.tencent.mm.plugin.finder.storage.b.czB()) && (!this.rVV))
    {
      AppMethodBeat.o(178488);
      return true;
    }
    AppMethodBeat.o(178488);
    return false;
  }
  
  public final void bW(boolean paramBoolean)
  {
    Context localContext = null;
    Object localObject = null;
    AppMethodBeat.i(168292);
    if (this.rWt)
    {
      AppMethodBeat.o(168292);
      return;
    }
    if ((this.rWs) && (paramBoolean))
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
    d.g.b.k.h(paramString1, "fromName");
    d.g.b.k.h(paramString2, "toName");
    paramString1 = getResources();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.getString(2131757530, new Object[] { paramString2 });; paramString1 = null)
    {
      t(paramString1, paramObject);
      AppMethodBeat.o(178487);
      return;
    }
  }
  
  public final void cEL()
  {
    AppMethodBeat.i(178484);
    Object localObject1 = this.rWj;
    if (localObject1 == null) {
      d.g.b.k.aVY("switchSceneTip");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = findViewById(2131298534);
    d.g.b.k.g(localObject1, "switchLayout");
    ((View)localObject1).setVisibility(0);
    cEM();
    localObject1 = findViewById(2131298533);
    Object localObject2;
    if (cEN())
    {
      localObject2 = ((View)localObject1).findViewById(2131298530);
      d.g.b.k.g(localObject2, "switchClickLayout.findVi…>(R.id.comment_scene_btn)");
      ((View)localObject2).setVisibility(0);
      ((View)localObject1).setOnClickListener((View.OnClickListener)new m(this));
      ((View)localObject1).setBackgroundResource(2131232373);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czz())
      {
        localObject1 = this.rWj;
        if (localObject1 == null) {
          d.g.b.k.aVY("switchSceneTip");
        }
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = this.rWp;
      if (localObject1 == null) {
        d.g.b.k.aVY("targetAvatar");
      }
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = this.rWm;
      if (localObject1 == null) {
        d.g.b.k.aVY("editText");
      }
      localObject2 = ((MMEditText)localObject1).getContext();
      d.g.b.k.g(localObject2, "this.context");
      int i = (int)((Context)localObject2).getResources().getDimension(2131165303);
      localObject2 = ((MMEditText)localObject1).getContext();
      d.g.b.k.g(localObject2, "this.context");
      ((MMEditText)localObject1).setPadding(i, 0, (int)((Context)localObject2).getResources().getDimension(2131165303), 0);
      AppMethodBeat.o(178484);
      return;
      localObject1 = ((View)localObject1).findViewById(2131298530);
      d.g.b.k.g(localObject1, "switchClickLayout.findVi…>(R.id.comment_scene_btn)");
      ((View)localObject1).setVisibility(8);
    }
  }
  
  public final void cEM()
  {
    AppMethodBeat.i(178485);
    Object localObject1;
    if (this.scene == 2)
    {
      localObject1 = this.rWh;
      if (localObject1 == null) {
        d.g.b.k.aVY("switchSceneAvatar");
      }
      com.tencent.mm.ui.f.a.a.c((ImageView)localObject1, u.axw());
      localObject1 = this.rWk;
      if (localObject1 == null) {
        d.g.b.k.aVY("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131759363);
    }
    for (;;)
    {
      localObject1 = this.rWi;
      if (localObject1 == null) {
        d.g.b.k.aVY("switchSceneName");
      }
      Object localObject2 = getContext();
      Object localObject3 = com.tencent.mm.plugin.finder.utils.n.rPN;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)com.tencent.mm.plugin.finder.utils.n.EC(this.scene)));
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czz())
      {
        localObject1 = this.rWj;
        if (localObject1 == null) {
          d.g.b.k.aVY("switchSceneTip");
        }
        if (((View)localObject1).getVisibility() == 0)
        {
          localObject1 = this.rWj;
          if (localObject1 == null) {
            d.g.b.k.aVY("switchSceneTip");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(178485);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
      localObject1 = u.axE();
      d.g.b.k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = b.a.adh((String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = ((f)localObject1).crZ();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cwo();
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject3 = this.rWh;
      if (localObject3 == null) {
        d.g.b.k.aVY("switchSceneAvatar");
      }
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
      ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
      localObject1 = this.rWk;
      if (localObject1 == null) {
        d.g.b.k.aVY("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131759362);
    }
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(168293);
    ImageView localImageView = this.rWp;
    if (localImageView == null) {
      d.g.b.k.aVY("targetAvatar");
    }
    AppMethodBeat.o(168293);
    return localImageView;
  }
  
  public final d.g.a.a<d.y> getBackClickListener()
  {
    return this.rWv;
  }
  
  public final View getCommentEditTextLayout()
  {
    AppMethodBeat.i(168283);
    View localView = this.rWo;
    if (localView == null) {
      d.g.b.k.aVY("commentEditTextLayout");
    }
    AppMethodBeat.o(168283);
    return localView;
  }
  
  public final int getCommentTextLimit()
  {
    return this.rWq;
  }
  
  public final MMEditText getEditText()
  {
    AppMethodBeat.i(168279);
    MMEditText localMMEditText = this.rWm;
    if (localMMEditText == null) {
      d.g.b.k.aVY("editText");
    }
    AppMethodBeat.o(168279);
    return localMMEditText;
  }
  
  public final int getFooterMode()
  {
    return this.rWx;
  }
  
  public final b getModeChangeCallback()
  {
    return this.rWu;
  }
  
  public final View getReplyBtn()
  {
    AppMethodBeat.i(168281);
    View localView = this.rWn;
    if (localView == null) {
      d.g.b.k.aVY("replyBtn");
    }
    AppMethodBeat.o(168281);
    return localView;
  }
  
  public final int getReplyBtnWidth()
  {
    return this.gBE;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final boolean getSendBtnEnabled()
  {
    return this.gBF;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168277);
    ImageView localImageView = this.rWl;
    if (localImageView == null) {
      d.g.b.k.aVY("smileyBtn");
    }
    AppMethodBeat.o(168277);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168275);
    SmileyPanel localSmileyPanel = this.gBD;
    if (localSmileyPanel == null) {
      d.g.b.k.aVY("smileyPanel");
    }
    AppMethodBeat.o(168275);
    return localSmileyPanel;
  }
  
  public final ImageView getSwitchSceneAvatar()
  {
    AppMethodBeat.i(178476);
    ImageView localImageView = this.rWh;
    if (localImageView == null) {
      d.g.b.k.aVY("switchSceneAvatar");
    }
    AppMethodBeat.o(178476);
    return localImageView;
  }
  
  public final d.g.a.a<d.y> getSwitchSceneListener()
  {
    return this.rWw;
  }
  
  public final TextView getSwitchSceneName()
  {
    AppMethodBeat.i(178478);
    TextView localTextView = this.rWi;
    if (localTextView == null) {
      d.g.b.k.aVY("switchSceneName");
    }
    AppMethodBeat.o(178478);
    return localTextView;
  }
  
  public final View getSwitchSceneTip()
  {
    AppMethodBeat.i(178480);
    View localView = this.rWj;
    if (localView == null) {
      d.g.b.k.aVY("switchSceneTip");
    }
    AppMethodBeat.o(178480);
    return localView;
  }
  
  public final TextView getSwitchSceneTipTv()
  {
    AppMethodBeat.i(178482);
    TextView localTextView = this.rWk;
    if (localTextView == null) {
      d.g.b.k.aVY("switchSceneTipTv");
    }
    AppMethodBeat.o(178482);
    return localTextView;
  }
  
  public final ImageView getTargetAvatar()
  {
    AppMethodBeat.i(168285);
    ImageView localImageView = this.rWp;
    if (localImageView == null) {
      d.g.b.k.aVY("targetAvatar");
    }
    AppMethodBeat.o(168285);
    return localImageView;
  }
  
  public final void gp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178486);
    d.g.b.k.h(paramString1, "fromName");
    d.g.b.k.h(paramString2, "toName");
    paramString1 = getResources();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.getString(2131757532, new Object[] { paramString2 });; paramString1 = null)
    {
      t(paramString1, null);
      AppMethodBeat.o(178486);
      return;
    }
  }
  
  public final void lW(final boolean paramBoolean)
  {
    AppMethodBeat.i(168290);
    if (this.rWt)
    {
      AppMethodBeat.o(168290);
      return;
    }
    Object localObject = this.rWl;
    if (localObject == null) {
      d.g.b.k.aVY("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.rWl;
    if (localObject == null) {
      d.g.b.k.aVY("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    if (paramBoolean)
    {
      animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(220L).translationY(this.rWr).setListener((Animator.AnimatorListener)new g(this, paramBoolean)).start();
      AppMethodBeat.o(168290);
      return;
    }
    localObject = this.gBD;
    if (localObject == null) {
      d.g.b.k.aVY("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new h(this)).start();
    AppMethodBeat.o(168290);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168289);
    super.onFinishInflate();
    Object localObject = findViewById(2131298529);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_scene_avatar)");
    this.rWh = ((ImageView)localObject);
    localObject = findViewById(2131298531);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_scene_name)");
    this.rWi = ((TextView)localObject);
    localObject = findViewById(2131298535);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_switch_scene_tip_layout)");
    this.rWj = ((View)localObject);
    localObject = findViewById(2131298536);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_switch_scene_tip_tv)");
    this.rWk = ((TextView)localObject);
    localObject = findViewById(2131304863);
    d.g.b.k.g(localObject, "findViewById(R.id.smiley_btn)");
    this.rWl = ((ImageView)localObject);
    localObject = findViewById(2131298513);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_et)");
    this.rWm = ((MMEditText)localObject);
    localObject = findViewById(2131298537);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_target_avatar)");
    this.rWp = ((ImageView)localObject);
    localObject = findViewById(2131304080);
    d.g.b.k.g(localObject, "findViewById(R.id.reply_btn)");
    this.rWn = ((View)localObject);
    localObject = findViewById(2131298514);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_et_layout)");
    this.rWo = ((View)localObject);
    if (aj.DT())
    {
      localObject = this.rWj;
      if (localObject == null) {
        d.g.b.k.aVY("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131232375);
    }
    for (;;)
    {
      localObject = this.rWl;
      if (localObject == null) {
        d.g.b.k.aVY("smileyBtn");
      }
      ((ImageView)localObject).setTag(Boolean.FALSE);
      localObject = aa.k(getContext(), false);
      d.g.b.k.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
      this.gBD = ((SmileyPanel)localObject);
      localObject = this.gBD;
      if (localObject == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.qYg);
      localObject = this.gBD;
      if (localObject == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      ((SmileyPanel)localObject).setBackgroundResource(2131232332);
      localObject = this.gBD;
      if (localObject == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      ((SmileyPanel)localObject).eMH();
      localObject = this.gBD;
      if (localObject == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      ((SmileyPanel)localObject).eMJ();
      localObject = this.gBD;
      if (localObject == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      ((SmileyPanel)localObject).eMI();
      localObject = this.gBD;
      if (localObject == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      ((SmileyPanel)localObject).setVisibility(4);
      localObject = this.gBD;
      if (localObject == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      ((SmileyPanel)localObject).onResume();
      localObject = this.gBD;
      if (localObject == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new d(this));
      localObject = new LinearLayout.LayoutParams(-1, (int)this.rWr);
      SmileyPanel localSmileyPanel = this.gBD;
      if (localSmileyPanel == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localSmileyPanel = this.gBD;
      if (localSmileyPanel == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
      localObject = this.rWl;
      if (localObject == null) {
        d.g.b.k.aVY("smileyBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      setTranslationY(this.rWr);
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      this.rWq = (com.tencent.mm.plugin.finder.storage.b.cyJ() * 2);
      localObject = this.rWn;
      if (localObject == null) {
        d.g.b.k.aVY("replyBtn");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.rWm;
      if (localObject == null) {
        d.g.b.k.aVY("editText");
      }
      ((MMEditText)localObject).addTextChangedListener((TextWatcher)new f(this));
      localObject = this.rWm;
      if (localObject == null) {
        d.g.b.k.aVY("editText");
      }
      com.tencent.mm.ui.tools.b.c.d((EditText)localObject).jQ(0, this.rWq).a(null);
      cEL();
      AppMethodBeat.o(168289);
      return;
      localObject = this.rWj;
      if (localObject == null) {
        d.g.b.k.aVY("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131232374);
    }
  }
  
  public final void setBackClickListener(d.g.a.a<d.y> parama)
  {
    this.rWv = parama;
  }
  
  public final void setCommentEditTextLayout(View paramView)
  {
    AppMethodBeat.i(168284);
    d.g.b.k.h(paramView, "<set-?>");
    this.rWo = paramView;
    AppMethodBeat.o(168284);
  }
  
  public final void setCommentTextLimit(int paramInt)
  {
    this.rWq = paramInt;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(168280);
    d.g.b.k.h(paramMMEditText, "<set-?>");
    this.rWm = paramMMEditText;
    AppMethodBeat.o(168280);
  }
  
  public final void setFooterMode(int paramInt)
  {
    AppMethodBeat.i(168287);
    b localb = this.rWu;
    if (localb != null) {
      localb.onModeChange(this.rWx, paramInt);
    }
    this.rWx = paramInt;
    AppMethodBeat.o(168287);
  }
  
  public final void setFrozen(boolean paramBoolean)
  {
    this.rWt = paramBoolean;
  }
  
  public final void setModeChangeCallback(b paramb)
  {
    this.rWu = paramb;
  }
  
  public final void setReplyBtn(View paramView)
  {
    AppMethodBeat.i(168282);
    d.g.b.k.h(paramView, "<set-?>");
    this.rWn = paramView;
    AppMethodBeat.o(168282);
  }
  
  public final void setReplyBtnWidth(int paramInt)
  {
    this.gBE = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(204144);
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
      ac.m("Finder.FinderCommentFooter", "set footer scene:".concat(String.valueOf(paramInt)), new Object[0]);
    }
    this.scene = paramInt;
    AppMethodBeat.o(204144);
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.rVV = paramBoolean;
  }
  
  public final void setSendBtnEnabled(boolean paramBoolean)
  {
    this.gBF = paramBoolean;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168278);
    d.g.b.k.h(paramImageView, "<set-?>");
    this.rWl = paramImageView;
    AppMethodBeat.o(168278);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168276);
    d.g.b.k.h(paramSmileyPanel, "<set-?>");
    this.gBD = paramSmileyPanel;
    AppMethodBeat.o(168276);
  }
  
  public final void setSwitchSceneAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(178477);
    d.g.b.k.h(paramImageView, "<set-?>");
    this.rWh = paramImageView;
    AppMethodBeat.o(178477);
  }
  
  public final void setSwitchSceneListener(d.g.a.a<d.y> parama)
  {
    this.rWw = parama;
  }
  
  public final void setSwitchSceneName(TextView paramTextView)
  {
    AppMethodBeat.i(178479);
    d.g.b.k.h(paramTextView, "<set-?>");
    this.rWi = paramTextView;
    AppMethodBeat.o(178479);
  }
  
  public final void setSwitchSceneTip(View paramView)
  {
    AppMethodBeat.i(178481);
    d.g.b.k.h(paramView, "<set-?>");
    this.rWj = paramView;
    AppMethodBeat.o(178481);
  }
  
  public final void setSwitchSceneTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(178483);
    d.g.b.k.h(paramTextView, "<set-?>");
    this.rWk = paramTextView;
    AppMethodBeat.o(178483);
  }
  
  public final void setTargetAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(168286);
    d.g.b.k.h(paramImageView, "<set-?>");
    this.rWp = paramImageView;
    AppMethodBeat.o(168286);
  }
  
  public final void t(String paramString, Object paramObject)
  {
    AppMethodBeat.i(168291);
    MMEditText localMMEditText = this.rWm;
    if (localMMEditText == null) {
      d.g.b.k.aVY("editText");
    }
    localMMEditText.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)paramString));
    paramString = this.rWm;
    if (paramString == null) {
      d.g.b.k.aVY("editText");
    }
    paramString.setTag(paramObject);
    paramString = this.rWm;
    if (paramString == null) {
      d.g.b.k.aVY("editText");
    }
    if (!paramString.hasFocus())
    {
      paramString = this.rWm;
      if (paramString == null) {
        d.g.b.k.aVY("editText");
      }
      paramString.requestFocus();
    }
    AppMethodBeat.o(168291);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168288);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.rWt; paramBoolean = false)
    {
      AppMethodBeat.o(168288);
      return;
    }
    if ((paramInt > 0) && (paramInt != (int)this.rWr))
    {
      com.tencent.mm.sdk.platformtools.y.aC(getContext(), paramInt);
      this.rWr = paramInt;
      localObject = new LinearLayout.LayoutParams(-1, (int)this.rWr);
      SmileyPanel localSmileyPanel = this.gBD;
      if (localSmileyPanel == null) {
        d.g.b.k.aVY("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.rWs != paramBoolean)
    {
      this.rWs = paramBoolean;
      if (!paramBoolean) {
        break label201;
      }
      animate().setDuration(90L).translationY(0.0F).withEndAction((Runnable)new i(this)).start();
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czz()) {
        break;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if ((!com.tencent.mm.plugin.finder.storage.b.czB()) || (this.rVV)) {
        break;
      }
      localObject = this.rWj;
      if (localObject == null) {
        d.g.b.k.aVY("switchSceneTip");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(168288);
      return;
      label201:
      if ((this.rWx == 2) || (this.rWx == 0)) {
        animate().setDuration(180L).translationY(this.rWr).withEndAction((Runnable)new j(this)).start();
      }
    }
    Object localObject = this.rWj;
    if (localObject == null) {
      d.g.b.k.aVY("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168288);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "", "onModeChange", "", "from", "", "to", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void onModeChange(int paramInt1, int paramInt2);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class d
    implements ChatFooterPanel.a
  {
    public final void amb()
    {
      AppMethodBeat.i(168257);
      if (this.rWB.getEditText().getInputConnection() != null)
      {
        this.rWB.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        this.rWB.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      }
      AppMethodBeat.o(168257);
    }
    
    public final void amc() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168256);
      this.rWB.getEditText().aRF(paramString);
      AppMethodBeat.o(168256);
    }
    
    public final void dS(boolean paramBoolean) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168258);
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(168258);
        throw paramView;
      }
      paramView = ((ImageView)paramView).getTag();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(168258);
        throw paramView;
      }
      if (!((Boolean)paramView).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        FinderCommentFooter.a(this.rWB, bool);
        AppMethodBeat.o(168258);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class f
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(204143);
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
            paramEditable = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(204143);
            throw paramEditable;
            i = 0;
            continue;
            i = 0;
          }
          else if (((CharSequence)d.n.n.trim((CharSequence)paramEditable).toString()).length() > 0)
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
        if (bool != this.rWB.getSendBtnEnabled()) {
          break label119;
        }
        AppMethodBeat.o(204143);
        return;
        i = 0;
        break;
      }
      label119:
      this.rWB.setSendBtnEnabled(bool);
      if (this.rWB.getSendBtnEnabled())
      {
        paramEditable = new ValueAnimator();
        paramEditable.setIntValues(new int[] { 0, this.rWB.getReplyBtnWidth() });
        paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
        paramEditable.setDuration(150L);
        paramEditable.addListener((Animator.AnimatorListener)new b(this));
        paramEditable.start();
        AppMethodBeat.o(204143);
        return;
      }
      paramEditable = new ValueAnimator();
      paramEditable.setIntValues(new int[] { this.rWB.getReplyBtnWidth(), 0 });
      paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
      paramEditable.setDuration(150L);
      paramEditable.addListener((Animator.AnimatorListener)new d(this));
      paramEditable.start();
      AppMethodBeat.o(204143);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(FinderCommentFooter.f paramf) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(204135);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(204135);
          throw paramValueAnimator;
        }
        float f = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.rWC.rWB.getReplyBtn().getLayoutParams();
        paramValueAnimator.width = d.h.a.cj(f);
        this.rWC.rWB.getReplyBtn().setLayoutParams(paramValueAnimator);
        this.rWC.rWB.getReplyBtn().setAlpha(f / this.rWC.rWB.getReplyBtnWidth());
        AppMethodBeat.o(204135);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(204137);
        paramAnimator = this.rWC.rWB.getReplyBtn().getLayoutParams();
        paramAnimator.width = this.rWC.rWB.getReplyBtnWidth();
        this.rWC.rWB.getReplyBtn().setLayoutParams(paramAnimator);
        this.rWC.rWB.getReplyBtn().setAlpha(1.0F);
        AppMethodBeat.o(204137);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(204136);
        paramAnimator = this.rWC.rWB.getReplyBtn().getLayoutParams();
        paramAnimator.width = this.rWC.rWB.getReplyBtnWidth();
        this.rWC.rWB.getReplyBtn().setLayoutParams(paramAnimator);
        this.rWC.rWB.getReplyBtn().setAlpha(1.0F);
        AppMethodBeat.o(204136);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(204138);
        this.rWC.rWB.getReplyBtn().setVisibility(0);
        AppMethodBeat.o(204138);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class c
      implements ValueAnimator.AnimatorUpdateListener
    {
      c(FinderCommentFooter.f paramf) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(204139);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(204139);
          throw paramValueAnimator;
        }
        float f = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.rWC.rWB.getReplyBtn().getLayoutParams();
        paramValueAnimator.width = d.h.a.cj(f);
        this.rWC.rWB.getReplyBtn().setLayoutParams(paramValueAnimator);
        this.rWC.rWB.getReplyBtn().setAlpha(f / this.rWC.rWB.getReplyBtnWidth());
        AppMethodBeat.o(204139);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class d
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(204141);
        this.rWC.rWB.getReplyBtn().setVisibility(8);
        AppMethodBeat.o(204141);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(204140);
        this.rWC.rWB.getReplyBtn().setVisibility(8);
        AppMethodBeat.o(204140);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(204142);
        this.rWC.rWB.getReplyBtn().setVisibility(0);
        AppMethodBeat.o(204142);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168269);
      this.rWB.getSmileyPanel().setVisibility(4);
      this.rWB.getSmileyBtn().setImageResource(2131231701);
      if (paramBoolean) {
        this.rWB.setFooterMode(0);
      }
      AppMethodBeat.o(168269);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168270);
      this.rWB.getSmileyPanel().setAlpha(1.0F);
      this.rWB.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168270);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void run()
    {
      AppMethodBeat.i(168271);
      this.rWB.setFooterMode(2);
      AppMethodBeat.o(168271);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void run()
    {
      AppMethodBeat.i(168272);
      this.rWB.setFooterMode(0);
      AppMethodBeat.o(168272);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class k
    implements View.OnLayoutChangeListener
  {
    k(d.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(168273);
      this.rWB.getSmileyPanel().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      this.rWE.invoke();
      AppMethodBeat.o(168273);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    l(FinderCommentFooter paramFinderCommentFooter)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178475);
      paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czz())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        com.tencent.mm.plugin.finder.storage.b.lJ(false);
        this.rWB.getSwitchSceneTip().setVisibility(8);
        paramView = new c(this.rWB.getContext());
        paramView.EP(2131494115);
        aj.a((Paint)((TextView)paramView.khe.findViewById(2131300009)).getPaint(), 0.8F);
        View localView = paramView.khe.findViewById(2131300007);
        FinderCommentFooter localFinderCommentFooter = this.rWB;
        d.g.b.k.g(localView, "item1");
        FinderCommentFooter.a(localFinderCommentFooter, localView, 1, (d.g.a.b)new a(paramView, this));
        localView = paramView.khe.findViewById(2131300008);
        localFinderCommentFooter = this.rWB;
        d.g.b.k.g(localView, "item2");
        FinderCommentFooter.a(localFinderCommentFooter, localView, 2, (d.g.a.b)new b(paramView, this));
        paramView.cED();
        AppMethodBeat.o(178475);
        return;
      }
      FinderCommentFooter.a(this.rWB);
      AppMethodBeat.o(178475);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$1$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<Integer, d.y>
    {
      a(c paramc, FinderCommentFooter.m paramm)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$1$1$2"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<Integer, d.y>
    {
      b(c paramc, FinderCommentFooter.m paramm)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter
 * JD-Core Version:    0.7.0.1
 */