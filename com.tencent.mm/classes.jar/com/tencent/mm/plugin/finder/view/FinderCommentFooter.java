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
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import d.n.n;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "", "()Z", "setFrozen", "(Z)V", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "hint", "", "tag", "", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "showRemark", "changeReplyToCommenter", "fromName", "toName", "changeReplyToPoster", "getAvatarView", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "showVKB", "isShow", "Companion", "IModeChangeCallback", "plugin-finder_release"})
public final class FinderCommentFooter
  extends LinearLayout
  implements g
{
  public static final a qWj;
  private boolean qVE;
  public ImageView qVP;
  public TextView qVQ;
  public View qVR;
  public TextView qVS;
  public SmileyPanel qVT;
  public ImageView qVU;
  public MMEditText qVV;
  public View qVW;
  public View qVX;
  public ImageView qVY;
  private int qVZ;
  private float qWa;
  private boolean qWb;
  private boolean qWc;
  private b qWd;
  private d.g.a.a<y> qWe;
  private d.g.a.a<y> qWf;
  private int qWg;
  private boolean qWh;
  public int qWi;
  private int scene;
  
  static
  {
    AppMethodBeat.i(168295);
    qWj = new a((byte)0);
    AppMethodBeat.o(168295);
  }
  
  public FinderCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168294);
    this.qWa = z.ik(getContext());
    this.qWg = ao.ap(getContext(), 2131165299);
    this.scene = 2;
    AppMethodBeat.o(168294);
  }
  
  private final boolean csM()
  {
    AppMethodBeat.i(178488);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    if ((com.tencent.mm.plugin.finder.storage.b.cqa()) && (!this.qVE))
    {
      AppMethodBeat.o(178488);
      return true;
    }
    AppMethodBeat.o(178488);
    return false;
  }
  
  public final void bV(boolean paramBoolean)
  {
    Context localContext = null;
    Object localObject = null;
    AppMethodBeat.i(168292);
    if (this.qWc)
    {
      AppMethodBeat.o(168292);
      return;
    }
    if ((this.qWb) && (paramBoolean))
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
  
  public final void csK()
  {
    AppMethodBeat.i(178484);
    Object localObject1 = this.qVR;
    if (localObject1 == null) {
      d.g.b.k.aPZ("switchSceneTip");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = findViewById(2131298534);
    d.g.b.k.g(localObject1, "switchLayout");
    ((View)localObject1).setVisibility(0);
    csL();
    localObject1 = findViewById(2131298533);
    Object localObject2;
    if (csM())
    {
      localObject2 = ((View)localObject1).findViewById(2131298530);
      d.g.b.k.g(localObject2, "switchClickLayout.findVi…>(R.id.comment_scene_btn)");
      ((View)localObject2).setVisibility(0);
      ((View)localObject1).setOnClickListener((View.OnClickListener)new n(this));
      ((View)localObject1).setBackgroundResource(2131232373);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.cpZ())
      {
        localObject1 = this.qVR;
        if (localObject1 == null) {
          d.g.b.k.aPZ("switchSceneTip");
        }
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = this.qVY;
      if (localObject1 == null) {
        d.g.b.k.aPZ("targetAvatar");
      }
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = this.qVV;
      if (localObject1 == null) {
        d.g.b.k.aPZ("editText");
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
  
  public final void csL()
  {
    AppMethodBeat.i(178485);
    Object localObject1;
    if (this.scene == 2)
    {
      localObject1 = this.qVP;
      if (localObject1 == null) {
        d.g.b.k.aPZ("switchSceneAvatar");
      }
      com.tencent.mm.ui.f.a.a.c((ImageView)localObject1, u.aqG());
      localObject1 = this.qVS;
      if (localObject1 == null) {
        d.g.b.k.aPZ("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131759363);
    }
    for (;;)
    {
      localObject1 = this.qVQ;
      if (localObject1 == null) {
        d.g.b.k.aPZ("switchSceneName");
      }
      Object localObject2 = getContext();
      Object localObject3 = i.qTa;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)i.Dj(this.scene)));
      localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.cpZ())
      {
        localObject1 = this.qVR;
        if (localObject1 == null) {
          d.g.b.k.aPZ("switchSceneTip");
        }
        if (((View)localObject1).getVisibility() == 0)
        {
          localObject1 = this.qVR;
          if (localObject1 == null) {
            d.g.b.k.aPZ("switchSceneTip");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(178485);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
      localObject1 = u.aqO();
      d.g.b.k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = b.a.YL((String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = ((f)localObject1).cks();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cmV();
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject3 = this.qVP;
      if (localObject3 == null) {
        d.g.b.k.aPZ("switchSceneAvatar");
      }
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
      localObject1 = this.qVS;
      if (localObject1 == null) {
        d.g.b.k.aPZ("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131759362);
    }
  }
  
  public final void e(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(178487);
    d.g.b.k.h(paramString1, "fromName");
    d.g.b.k.h(paramString2, "toName");
    paramString1 = getResources();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.getString(2131757530, new Object[] { paramString2 });; paramString1 = null)
    {
      u(paramString1, paramObject);
      AppMethodBeat.o(178487);
      return;
    }
  }
  
  public final void fZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178486);
    d.g.b.k.h(paramString1, "fromName");
    d.g.b.k.h(paramString2, "toName");
    paramString1 = getResources();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.getString(2131757532, new Object[] { paramString2 });; paramString1 = null)
    {
      u(paramString1, null);
      AppMethodBeat.o(178486);
      return;
    }
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(168293);
    ImageView localImageView = this.qVY;
    if (localImageView == null) {
      d.g.b.k.aPZ("targetAvatar");
    }
    AppMethodBeat.o(168293);
    return localImageView;
  }
  
  public final d.g.a.a<y> getBackClickListener()
  {
    return this.qWe;
  }
  
  public final View getCommentEditTextLayout()
  {
    AppMethodBeat.i(168283);
    View localView = this.qVX;
    if (localView == null) {
      d.g.b.k.aPZ("commentEditTextLayout");
    }
    AppMethodBeat.o(168283);
    return localView;
  }
  
  public final int getCommentTextLimit()
  {
    return this.qVZ;
  }
  
  public final MMEditText getEditText()
  {
    AppMethodBeat.i(168279);
    MMEditText localMMEditText = this.qVV;
    if (localMMEditText == null) {
      d.g.b.k.aPZ("editText");
    }
    AppMethodBeat.o(168279);
    return localMMEditText;
  }
  
  public final int getFooterMode()
  {
    return this.qWi;
  }
  
  public final b getModeChangeCallback()
  {
    return this.qWd;
  }
  
  public final View getReplyBtn()
  {
    AppMethodBeat.i(168281);
    View localView = this.qVW;
    if (localView == null) {
      d.g.b.k.aPZ("replyBtn");
    }
    AppMethodBeat.o(168281);
    return localView;
  }
  
  public final int getReplyBtnWidth()
  {
    return this.qWg;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final boolean getSendBtnEnabled()
  {
    return this.qWh;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168277);
    ImageView localImageView = this.qVU;
    if (localImageView == null) {
      d.g.b.k.aPZ("smileyBtn");
    }
    AppMethodBeat.o(168277);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168275);
    SmileyPanel localSmileyPanel = this.qVT;
    if (localSmileyPanel == null) {
      d.g.b.k.aPZ("smileyPanel");
    }
    AppMethodBeat.o(168275);
    return localSmileyPanel;
  }
  
  public final ImageView getSwitchSceneAvatar()
  {
    AppMethodBeat.i(178476);
    ImageView localImageView = this.qVP;
    if (localImageView == null) {
      d.g.b.k.aPZ("switchSceneAvatar");
    }
    AppMethodBeat.o(178476);
    return localImageView;
  }
  
  public final d.g.a.a<y> getSwitchSceneListener()
  {
    return this.qWf;
  }
  
  public final TextView getSwitchSceneName()
  {
    AppMethodBeat.i(178478);
    TextView localTextView = this.qVQ;
    if (localTextView == null) {
      d.g.b.k.aPZ("switchSceneName");
    }
    AppMethodBeat.o(178478);
    return localTextView;
  }
  
  public final View getSwitchSceneTip()
  {
    AppMethodBeat.i(178480);
    View localView = this.qVR;
    if (localView == null) {
      d.g.b.k.aPZ("switchSceneTip");
    }
    AppMethodBeat.o(178480);
    return localView;
  }
  
  public final TextView getSwitchSceneTipTv()
  {
    AppMethodBeat.i(178482);
    TextView localTextView = this.qVS;
    if (localTextView == null) {
      d.g.b.k.aPZ("switchSceneTipTv");
    }
    AppMethodBeat.o(178482);
    return localTextView;
  }
  
  public final ImageView getTargetAvatar()
  {
    AppMethodBeat.i(168285);
    ImageView localImageView = this.qVY;
    if (localImageView == null) {
      d.g.b.k.aPZ("targetAvatar");
    }
    AppMethodBeat.o(168285);
    return localImageView;
  }
  
  public final void ll(final boolean paramBoolean)
  {
    AppMethodBeat.i(168290);
    if (this.qWc)
    {
      AppMethodBeat.o(168290);
      return;
    }
    Object localObject = this.qVU;
    if (localObject == null) {
      d.g.b.k.aPZ("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.qVU;
    if (localObject == null) {
      d.g.b.k.aPZ("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    if (paramBoolean)
    {
      animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(220L).translationY(this.qWa).setListener((Animator.AnimatorListener)new h(this, paramBoolean)).start();
      AppMethodBeat.o(168290);
      return;
    }
    localObject = this.qVT;
    if (localObject == null) {
      d.g.b.k.aPZ("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i(this)).start();
    AppMethodBeat.o(168290);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168289);
    super.onFinishInflate();
    Object localObject = findViewById(2131298529);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_scene_avatar)");
    this.qVP = ((ImageView)localObject);
    localObject = findViewById(2131298531);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_scene_name)");
    this.qVQ = ((TextView)localObject);
    localObject = findViewById(2131298535);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_switch_scene_tip_layout)");
    this.qVR = ((View)localObject);
    localObject = findViewById(2131298536);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_switch_scene_tip_tv)");
    this.qVS = ((TextView)localObject);
    localObject = findViewById(2131304863);
    d.g.b.k.g(localObject, "findViewById(R.id.smiley_btn)");
    this.qVU = ((ImageView)localObject);
    localObject = findViewById(2131298513);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_et)");
    this.qVV = ((MMEditText)localObject);
    localObject = findViewById(2131298537);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_target_avatar)");
    this.qVY = ((ImageView)localObject);
    localObject = findViewById(2131304080);
    d.g.b.k.g(localObject, "findViewById(R.id.reply_btn)");
    this.qVW = ((View)localObject);
    localObject = findViewById(2131298514);
    d.g.b.k.g(localObject, "findViewById(R.id.comment_et_layout)");
    this.qVX = ((View)localObject);
    if (ai.Eq())
    {
      localObject = this.qVR;
      if (localObject == null) {
        d.g.b.k.aPZ("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131232375);
    }
    for (;;)
    {
      localObject = this.qVU;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyBtn");
      }
      ((ImageView)localObject).setTag(Boolean.FALSE);
      localObject = aa.k(getContext(), false);
      d.g.b.k.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
      this.qVT = ((SmileyPanel)localObject);
      localObject = this.qVT;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.qpk);
      localObject = this.qVT;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      ((SmileyPanel)localObject).setBackgroundResource(2131232332);
      localObject = this.qVT;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      ((SmileyPanel)localObject).exn();
      localObject = this.qVT;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      ((SmileyPanel)localObject).exp();
      localObject = this.qVT;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      ((SmileyPanel)localObject).exo();
      localObject = this.qVT;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      ((SmileyPanel)localObject).setVisibility(4);
      localObject = this.qVT;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      ((SmileyPanel)localObject).onResume();
      localObject = this.qVT;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new d(this));
      localObject = new LinearLayout.LayoutParams(-1, (int)this.qWa);
      SmileyPanel localSmileyPanel = this.qVT;
      if (localSmileyPanel == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localSmileyPanel = this.qVT;
      if (localSmileyPanel == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
      localObject = this.qVU;
      if (localObject == null) {
        d.g.b.k.aPZ("smileyBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      setTranslationY(this.qWa);
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      this.qVZ = (com.tencent.mm.plugin.finder.storage.b.cpm() * 2);
      localObject = this.qVW;
      if (localObject == null) {
        d.g.b.k.aPZ("replyBtn");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.qVV;
      if (localObject == null) {
        d.g.b.k.aPZ("editText");
      }
      ((MMEditText)localObject).addTextChangedListener((TextWatcher)new f(this));
      localObject = this.qVV;
      if (localObject == null) {
        d.g.b.k.aPZ("editText");
      }
      com.tencent.mm.ui.tools.b.c.d((EditText)localObject).jE(0, this.qVZ).a(null);
      csK();
      AppMethodBeat.o(168289);
      return;
      localObject = this.qVR;
      if (localObject == null) {
        d.g.b.k.aPZ("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131232374);
    }
  }
  
  public final void setBackClickListener(d.g.a.a<y> parama)
  {
    this.qWe = parama;
  }
  
  public final void setCommentEditTextLayout(View paramView)
  {
    AppMethodBeat.i(168284);
    d.g.b.k.h(paramView, "<set-?>");
    this.qVX = paramView;
    AppMethodBeat.o(168284);
  }
  
  public final void setCommentTextLimit(int paramInt)
  {
    this.qVZ = paramInt;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(168280);
    d.g.b.k.h(paramMMEditText, "<set-?>");
    this.qVV = paramMMEditText;
    AppMethodBeat.o(168280);
  }
  
  public final void setFooterMode(int paramInt)
  {
    AppMethodBeat.i(168287);
    b localb = this.qWd;
    if (localb != null) {
      localb.onModeChange(this.qWi, paramInt);
    }
    this.qWi = paramInt;
    AppMethodBeat.o(168287);
  }
  
  public final void setFrozen(boolean paramBoolean)
  {
    this.qWc = paramBoolean;
  }
  
  public final void setModeChangeCallback(b paramb)
  {
    this.qWd = paramb;
  }
  
  public final void setReplyBtn(View paramView)
  {
    AppMethodBeat.i(168282);
    d.g.b.k.h(paramView, "<set-?>");
    this.qVW = paramView;
    AppMethodBeat.o(168282);
  }
  
  public final void setReplyBtnWidth(int paramInt)
  {
    this.qWg = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(200073);
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {
      ad.m("Finder.FinderCommentFooter", "set footer scene:".concat(String.valueOf(paramInt)), new Object[0]);
    }
    this.scene = paramInt;
    AppMethodBeat.o(200073);
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.qVE = paramBoolean;
  }
  
  public final void setSendBtnEnabled(boolean paramBoolean)
  {
    this.qWh = paramBoolean;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168278);
    d.g.b.k.h(paramImageView, "<set-?>");
    this.qVU = paramImageView;
    AppMethodBeat.o(168278);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168276);
    d.g.b.k.h(paramSmileyPanel, "<set-?>");
    this.qVT = paramSmileyPanel;
    AppMethodBeat.o(168276);
  }
  
  public final void setSwitchSceneAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(178477);
    d.g.b.k.h(paramImageView, "<set-?>");
    this.qVP = paramImageView;
    AppMethodBeat.o(178477);
  }
  
  public final void setSwitchSceneListener(d.g.a.a<y> parama)
  {
    this.qWf = parama;
  }
  
  public final void setSwitchSceneName(TextView paramTextView)
  {
    AppMethodBeat.i(178479);
    d.g.b.k.h(paramTextView, "<set-?>");
    this.qVQ = paramTextView;
    AppMethodBeat.o(178479);
  }
  
  public final void setSwitchSceneTip(View paramView)
  {
    AppMethodBeat.i(178481);
    d.g.b.k.h(paramView, "<set-?>");
    this.qVR = paramView;
    AppMethodBeat.o(178481);
  }
  
  public final void setSwitchSceneTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(178483);
    d.g.b.k.h(paramTextView, "<set-?>");
    this.qVS = paramTextView;
    AppMethodBeat.o(178483);
  }
  
  public final void setTargetAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(168286);
    d.g.b.k.h(paramImageView, "<set-?>");
    this.qVY = paramImageView;
    AppMethodBeat.o(168286);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168288);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.qWc; paramBoolean = false)
    {
      AppMethodBeat.o(168288);
      return;
    }
    if ((paramInt > 0) && (paramInt != (int)this.qWa))
    {
      z.aw(getContext(), paramInt);
      this.qWa = paramInt;
      localObject = new LinearLayout.LayoutParams(-1, (int)this.qWa);
      SmileyPanel localSmileyPanel = this.qVT;
      if (localSmileyPanel == null) {
        d.g.b.k.aPZ("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.qWb != paramBoolean)
    {
      this.qWb = paramBoolean;
      if (!paramBoolean) {
        break label201;
      }
      animate().setDuration(90L).translationY(0.0F).withEndAction((Runnable)new j(this)).start();
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.cpZ()) {
        break;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((!com.tencent.mm.plugin.finder.storage.b.cqa()) || (this.qVE)) {
        break;
      }
      localObject = this.qVR;
      if (localObject == null) {
        d.g.b.k.aPZ("switchSceneTip");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(168288);
      return;
      label201:
      if ((this.qWi == 2) || (this.qWi == 0)) {
        animate().setDuration(180L).translationY(this.qWa).withEndAction((Runnable)new k(this)).start();
      }
    }
    Object localObject = this.qVR;
    if (localObject == null) {
      d.g.b.k.aPZ("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168288);
  }
  
  public final void u(String paramString, Object paramObject)
  {
    AppMethodBeat.i(168291);
    MMEditText localMMEditText = this.qVV;
    if (localMMEditText == null) {
      d.g.b.k.aPZ("editText");
    }
    localMMEditText.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), (CharSequence)paramString));
    paramString = this.qVV;
    if (paramString == null) {
      d.g.b.k.aPZ("editText");
    }
    paramString.setTag(paramObject);
    paramString = this.qVV;
    if (paramString == null) {
      d.g.b.k.aPZ("editText");
    }
    if (!paramString.hasFocus())
    {
      paramString = this.qVV;
      if (paramString == null) {
        d.g.b.k.aPZ("editText");
      }
      paramString.requestFocus();
    }
    AppMethodBeat.o(168291);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$Companion;", "", "()V", "MODE_DEFAULT", "", "MODE_KEYBOARD", "MODE_SMILEY", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "", "onModeChange", "", "from", "", "to", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void onModeChange(int paramInt1, int paramInt2);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class d
    implements ChatFooterPanel.a
  {
    public final void append(String paramString)
    {
      AppMethodBeat.i(168256);
      this.qWm.getEditText().aMd(paramString);
      AppMethodBeat.o(168256);
    }
    
    public final void btF()
    {
      AppMethodBeat.i(168257);
      if (this.qWm.getEditText().getInputConnection() != null)
      {
        this.qWm.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        this.qWm.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      }
      AppMethodBeat.o(168257);
    }
    
    public final void cqY() {}
    
    public final void lf(boolean paramBoolean) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
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
        FinderCommentFooter.a(this.qWm, bool);
        AppMethodBeat.o(168258);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class f
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(200072);
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
            AppMethodBeat.o(200072);
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
        if (bool != this.qWm.getSendBtnEnabled()) {
          break label119;
        }
        AppMethodBeat.o(200072);
        return;
        i = 0;
        break;
      }
      label119:
      this.qWm.setSendBtnEnabled(bool);
      if (this.qWm.getSendBtnEnabled())
      {
        paramEditable = new ValueAnimator();
        paramEditable.setIntValues(new int[] { 0, this.qWm.getReplyBtnWidth() });
        paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FinderCommentFooter.f.a(this));
        paramEditable.setDuration(150L);
        paramEditable.addListener((Animator.AnimatorListener)new FinderCommentFooter.f.b(this));
        paramEditable.start();
        AppMethodBeat.o(200072);
        return;
      }
      paramEditable = new ValueAnimator();
      paramEditable.setIntValues(new int[] { this.qWm.getReplyBtnWidth(), 0 });
      paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FinderCommentFooter.f.c(this));
      paramEditable.setDuration(150L);
      paramEditable.addListener((Animator.AnimatorListener)new FinderCommentFooter.f.d(this));
      paramEditable.start();
      AppMethodBeat.o(200072);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168269);
      this.qWm.getSmileyPanel().setVisibility(4);
      this.qWm.getSmileyBtn().setImageResource(2131231701);
      if (paramBoolean) {
        this.qWm.setFooterMode(0);
      }
      AppMethodBeat.o(168269);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168270);
      this.qWm.getSmileyPanel().setAlpha(1.0F);
      this.qWm.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168270);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void run()
    {
      AppMethodBeat.i(168271);
      this.qWm.setFooterMode(2);
      AppMethodBeat.o(168271);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void run()
    {
      AppMethodBeat.i(168272);
      this.qWm.setFooterMode(0);
      AppMethodBeat.o(168272);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class l
    implements View.OnLayoutChangeListener
  {
    l(d.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(168273);
      this.qWm.getSmileyPanel().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      this.qWp.invoke();
      AppMethodBeat.o(168273);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(FinderCommentFooter paramFinderCommentFooter)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178475);
      paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.cpZ())
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        com.tencent.mm.plugin.finder.storage.b.le(false);
        this.qWm.getSwitchSceneTip().setVisibility(8);
        paramView = new c(this.qWm.getContext());
        paramView.Do(2131494115);
        ai.a((Paint)((TextView)paramView.jGG.findViewById(2131300009)).getPaint(), 0.8F);
        View localView = paramView.jGG.findViewById(2131300007);
        FinderCommentFooter localFinderCommentFooter = this.qWm;
        d.g.b.k.g(localView, "item1");
        FinderCommentFooter.a(localFinderCommentFooter, localView, 1, (d.g.a.b)new a(paramView, this));
        localView = paramView.jGG.findViewById(2131300008);
        localFinderCommentFooter = this.qWm;
        d.g.b.k.g(localView, "item2");
        FinderCommentFooter.a(localFinderCommentFooter, localView, 2, (d.g.a.b)new b(paramView, this));
        paramView.csG();
        AppMethodBeat.o(178475);
        return;
      }
      FinderCommentFooter.a(this.qWm);
      AppMethodBeat.o(178475);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$1$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<Integer, y>
    {
      a(c paramc, FinderCommentFooter.n paramn)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$1$1$2"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<Integer, y>
    {
      b(c paramc, FinderCommentFooter.n paramn)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter
 * JD-Core Version:    0.7.0.1
 */