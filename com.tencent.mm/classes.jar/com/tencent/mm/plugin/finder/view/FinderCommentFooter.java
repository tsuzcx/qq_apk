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
import com.tencent.mm.api.aa;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.q;
import d.l;
import d.n.n;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "banSwitchScene", "", "getBanSwitchScene", "()Z", "setBanSwitchScene", "(Z)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "setFrozen", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "lastActionStr", "", "getLastActionStr", "()Ljava/lang/String;", "setLastActionStr", "(Ljava/lang/String;)V", "lastFromName", "getLastFromName", "setLastFromName", "lastTag", "", "getLastTag", "()Ljava/lang/Object;", "setLastTag", "(Ljava/lang/Object;)V", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "fromName", "actionStr", "tag", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "showRemark", "changeReplyToCommenter", "toName", "changeReplyToPoster", "changeSelfName", "selfName", "ellipseName", "name", "getAvatarView", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "showVKB", "isShow", "Companion", "IModeChangeCallback", "plugin-finder_release"})
public final class FinderCommentFooter
  extends LinearLayout
  implements com.tencent.mm.ui.tools.g
{
  public static final a sTm;
  public SmileyPanel gVn;
  private int gVo;
  private boolean gVp;
  private boolean sSE;
  public ImageView sSR;
  public TextView sSS;
  public View sST;
  public TextView sSU;
  public ImageView sSV;
  public MMEditText sSW;
  public View sSX;
  public View sSY;
  public ImageView sSZ;
  private int sTa;
  private float sTb;
  private boolean sTc;
  private boolean sTd;
  private b sTe;
  private d.g.a.a<d.z> sTf;
  private d.g.a.a<d.z> sTg;
  private boolean sTh;
  public int sTi;
  public String sTj;
  private String sTk;
  private Object sTl;
  private int scene;
  
  static
  {
    AppMethodBeat.i(168295);
    sTm = new a((byte)0);
    AppMethodBeat.o(168295);
  }
  
  public FinderCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168294);
    this.sTb = com.tencent.mm.sdk.platformtools.z.iF(getContext());
    this.gVo = aq.ay(getContext(), 2131165299);
    this.scene = 2;
    this.sTj = "";
    this.sTk = "";
    AppMethodBeat.o(168294);
  }
  
  private void aji(String paramString)
  {
    AppMethodBeat.i(205108);
    d.g.b.p.h(paramString, "selfName");
    e(ajj(paramString), this.sTk, this.sTl);
    AppMethodBeat.o(205108);
  }
  
  private final boolean cNg()
  {
    AppMethodBeat.i(178488);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cHb().value()).intValue() == 1) && (!this.sSE))
    {
      localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      if ((com.tencent.mm.plugin.finder.utils.p.cLy()) && (!this.sTh))
      {
        AppMethodBeat.o(178488);
        return true;
      }
    }
    AppMethodBeat.o(178488);
    return false;
  }
  
  public final String ajj(String paramString)
  {
    AppMethodBeat.i(205112);
    Object localObject = com.tencent.mm.plugin.finder.convert.a.rLR;
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    int i = com.tencent.mm.plugin.finder.convert.a.U((Context)localObject, com.tencent.mm.plugin.finder.storage.b.cGs());
    localObject = com.tencent.mm.plugin.finder.convert.a.rLR;
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    int j = com.tencent.mm.plugin.finder.convert.a.U((Context)localObject, com.tencent.mm.plugin.finder.storage.b.cGs() + 1);
    localObject = com.tencent.mm.plugin.finder.convert.a.rLR;
    localObject = this.sSW;
    if (localObject == null) {
      d.g.b.p.bcb("editText");
    }
    localObject = ((MMEditText)localObject).getPaint();
    d.g.b.p.g(localObject, "editText.paint");
    paramString = com.tencent.mm.plugin.finder.convert.a.a((TextPaint)localObject, paramString, i, j);
    AppMethodBeat.o(205112);
    return paramString;
  }
  
  public final void bY(boolean paramBoolean)
  {
    Context localContext = null;
    Object localObject = null;
    AppMethodBeat.i(168292);
    if (this.sTd)
    {
      AppMethodBeat.o(168292);
      return;
    }
    if ((this.sTc) && (paramBoolean))
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
    e(this.sTj, " " + getResources().getString(2131757530, new Object[] { paramString2 }), paramObject);
    AppMethodBeat.o(178487);
  }
  
  public final void cNe()
  {
    AppMethodBeat.i(178484);
    Object localObject = this.sST;
    if (localObject == null) {
      d.g.b.p.bcb("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    cNf();
    localObject = findViewById(2131298533);
    if (cNg())
    {
      ((View)localObject).findViewById(2131298530).setVisibility(0);
      ((View)localObject).setOnClickListener((View.OnClickListener)new m(this));
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cHd() > 0)
      {
        localObject = this.sST;
        if (localObject == null) {
          d.g.b.p.bcb("switchSceneTip");
        }
        ((View)localObject).setVisibility(0);
      }
      localObject = this.sSZ;
      if (localObject == null) {
        d.g.b.p.bcb("targetAvatar");
      }
      ((ImageView)localObject).setVisibility(8);
      localObject = this.sSW;
      if (localObject == null) {
        d.g.b.p.bcb("editText");
      }
      Context localContext = ((MMEditText)localObject).getContext();
      d.g.b.p.g(localContext, "this.context");
      int i = (int)localContext.getResources().getDimension(2131165303);
      localContext = ((MMEditText)localObject).getContext();
      d.g.b.p.g(localContext, "this.context");
      ((MMEditText)localObject).setPadding(i, 0, (int)localContext.getResources().getDimension(2131165303), 0);
      AppMethodBeat.o(178484);
      return;
      ((View)localObject).setOnClickListener((View.OnClickListener)FinderCommentFooter.n.sTu);
      localObject = ((View)localObject).findViewById(2131298530);
      d.g.b.p.g(localObject, "switchClickLayout.findVi…>(R.id.comment_scene_btn)");
      ((View)localObject).setVisibility(8);
    }
  }
  
  public final void cNf()
  {
    AppMethodBeat.i(178485);
    Object localObject1;
    if (this.scene == 2)
    {
      localObject1 = this.sSR;
      if (localObject1 == null) {
        d.g.b.p.bcb("switchSceneAvatar");
      }
      com.tencent.mm.ui.f.a.a.c((ImageView)localObject1, u.aAm());
      localObject1 = this.sSU;
      if (localObject1 == null) {
        d.g.b.p.bcb("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131766853);
    }
    for (;;)
    {
      localObject1 = this.sSS;
      if (localObject1 == null) {
        d.g.b.p.bcb("switchSceneName");
      }
      Object localObject2 = getContext();
      Object localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
      ((TextView)localObject1).setText((CharSequence)k.c((Context)localObject2, (CharSequence)com.tencent.mm.plugin.finder.utils.p.FM(this.scene)));
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      aji(com.tencent.mm.plugin.finder.utils.p.FM(this.scene));
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cHd() <= 0)
      {
        localObject1 = this.sST;
        if (localObject1 == null) {
          d.g.b.p.bcb("switchSceneTip");
        }
        if (((View)localObject1).getVisibility() == 0)
        {
          localObject1 = this.sST;
          if (localObject1 == null) {
            d.g.b.p.bcb("switchSceneTip");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(178485);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
      localObject1 = u.aAu();
      d.g.b.p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = c.a.agW((String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject1).cxL();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
      localObject2 = com.tencent.mm.plugin.finder.loader.i.cCC();
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject3 = this.sSR;
      if (localObject3 == null) {
        d.g.b.p.bcb("switchSceneAvatar");
      }
      com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
      localObject1 = this.sSU;
      if (localObject1 == null) {
        d.g.b.p.bcb("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131766853);
    }
  }
  
  public final void e(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(205111);
    if (paramString1 == null) {}
    for (String str = "";; str = paramString1)
    {
      this.sTj = str;
      this.sTk = paramString2;
      this.sTl = paramObject;
      paramString1 = d.g.b.p.C(paramString1, paramString2);
      paramString2 = this.sSW;
      if (paramString2 == null) {
        d.g.b.p.bcb("editText");
      }
      paramString2.setHint((CharSequence)k.c(getContext(), (CharSequence)paramString1));
      paramString1 = this.sSW;
      if (paramString1 == null) {
        d.g.b.p.bcb("editText");
      }
      paramString1.setTag(paramObject);
      paramString1 = this.sSW;
      if (paramString1 == null) {
        d.g.b.p.bcb("editText");
      }
      if (!paramString1.hasFocus())
      {
        paramString1 = this.sSW;
        if (paramString1 == null) {
          d.g.b.p.bcb("editText");
        }
        paramString1.requestFocus();
      }
      AppMethodBeat.o(205111);
      return;
    }
  }
  
  public final void gA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178486);
    d.g.b.p.h(paramString1, "fromName");
    d.g.b.p.h(paramString2, "toName");
    e(this.sTj, " " + getResources().getString(2131763113), null);
    AppMethodBeat.o(178486);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(168293);
    ImageView localImageView = this.sSZ;
    if (localImageView == null) {
      d.g.b.p.bcb("targetAvatar");
    }
    AppMethodBeat.o(168293);
    return localImageView;
  }
  
  public final d.g.a.a<d.z> getBackClickListener()
  {
    return this.sTf;
  }
  
  public final boolean getBanSwitchScene()
  {
    return this.sTh;
  }
  
  public final View getCommentEditTextLayout()
  {
    AppMethodBeat.i(168283);
    View localView = this.sSY;
    if (localView == null) {
      d.g.b.p.bcb("commentEditTextLayout");
    }
    AppMethodBeat.o(168283);
    return localView;
  }
  
  public final int getCommentTextLimit()
  {
    return this.sTa;
  }
  
  public final MMEditText getEditText()
  {
    AppMethodBeat.i(168279);
    MMEditText localMMEditText = this.sSW;
    if (localMMEditText == null) {
      d.g.b.p.bcb("editText");
    }
    AppMethodBeat.o(168279);
    return localMMEditText;
  }
  
  public final int getFooterMode()
  {
    return this.sTi;
  }
  
  public final String getLastActionStr()
  {
    return this.sTk;
  }
  
  public final String getLastFromName()
  {
    return this.sTj;
  }
  
  public final Object getLastTag()
  {
    return this.sTl;
  }
  
  public final b getModeChangeCallback()
  {
    return this.sTe;
  }
  
  public final View getReplyBtn()
  {
    AppMethodBeat.i(168281);
    View localView = this.sSX;
    if (localView == null) {
      d.g.b.p.bcb("replyBtn");
    }
    AppMethodBeat.o(168281);
    return localView;
  }
  
  public final int getReplyBtnWidth()
  {
    return this.gVo;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final boolean getSendBtnEnabled()
  {
    return this.gVp;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168277);
    ImageView localImageView = this.sSV;
    if (localImageView == null) {
      d.g.b.p.bcb("smileyBtn");
    }
    AppMethodBeat.o(168277);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168275);
    SmileyPanel localSmileyPanel = this.gVn;
    if (localSmileyPanel == null) {
      d.g.b.p.bcb("smileyPanel");
    }
    AppMethodBeat.o(168275);
    return localSmileyPanel;
  }
  
  public final ImageView getSwitchSceneAvatar()
  {
    AppMethodBeat.i(178476);
    ImageView localImageView = this.sSR;
    if (localImageView == null) {
      d.g.b.p.bcb("switchSceneAvatar");
    }
    AppMethodBeat.o(178476);
    return localImageView;
  }
  
  public final d.g.a.a<d.z> getSwitchSceneListener()
  {
    return this.sTg;
  }
  
  public final TextView getSwitchSceneName()
  {
    AppMethodBeat.i(178478);
    TextView localTextView = this.sSS;
    if (localTextView == null) {
      d.g.b.p.bcb("switchSceneName");
    }
    AppMethodBeat.o(178478);
    return localTextView;
  }
  
  public final View getSwitchSceneTip()
  {
    AppMethodBeat.i(178480);
    View localView = this.sST;
    if (localView == null) {
      d.g.b.p.bcb("switchSceneTip");
    }
    AppMethodBeat.o(178480);
    return localView;
  }
  
  public final TextView getSwitchSceneTipTv()
  {
    AppMethodBeat.i(178482);
    TextView localTextView = this.sSU;
    if (localTextView == null) {
      d.g.b.p.bcb("switchSceneTipTv");
    }
    AppMethodBeat.o(178482);
    return localTextView;
  }
  
  public final ImageView getTargetAvatar()
  {
    AppMethodBeat.i(168285);
    ImageView localImageView = this.sSZ;
    if (localImageView == null) {
      d.g.b.p.bcb("targetAvatar");
    }
    AppMethodBeat.o(168285);
    return localImageView;
  }
  
  public final void mo(final boolean paramBoolean)
  {
    AppMethodBeat.i(168290);
    if (this.sTd)
    {
      AppMethodBeat.o(168290);
      return;
    }
    Object localObject = this.sSV;
    if (localObject == null) {
      d.g.b.p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(2131231701);
    localObject = this.sSV;
    if (localObject == null) {
      d.g.b.p.bcb("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    if (paramBoolean)
    {
      animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(220L).translationY(this.sTb).setListener((Animator.AnimatorListener)new g(this, paramBoolean)).start();
      AppMethodBeat.o(168290);
      return;
    }
    localObject = this.gVn;
    if (localObject == null) {
      d.g.b.p.bcb("smileyPanel");
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
    this.sSR = ((ImageView)localObject);
    localObject = findViewById(2131298531);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_scene_name)");
    this.sSS = ((TextView)localObject);
    localObject = findViewById(2131298535);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_switch_scene_tip_layout)");
    this.sST = ((View)localObject);
    localObject = findViewById(2131298536);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_switch_scene_tip_tv)");
    this.sSU = ((TextView)localObject);
    localObject = findViewById(2131304863);
    d.g.b.p.g(localObject, "findViewById(R.id.smiley_btn)");
    this.sSV = ((ImageView)localObject);
    localObject = findViewById(2131298513);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_et)");
    this.sSW = ((MMEditText)localObject);
    localObject = findViewById(2131298537);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_target_avatar)");
    this.sSZ = ((ImageView)localObject);
    localObject = findViewById(2131304080);
    d.g.b.p.g(localObject, "findViewById(R.id.reply_btn)");
    this.sSX = ((View)localObject);
    localObject = findViewById(2131298514);
    d.g.b.p.g(localObject, "findViewById(R.id.comment_et_layout)");
    this.sSY = ((View)localObject);
    if (al.isDarkMode())
    {
      localObject = this.sST;
      if (localObject == null) {
        d.g.b.p.bcb("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131235001);
    }
    for (;;)
    {
      localObject = this.sSV;
      if (localObject == null) {
        d.g.b.p.bcb("smileyBtn");
      }
      ((ImageView)localObject).setTag(Boolean.FALSE);
      localObject = aa.k(getContext(), false);
      d.g.b.p.g(localObject, "SmileyPanelFactory.getSmileyPanel(context, false)");
      this.gVn = ((SmileyPanel)localObject);
      localObject = this.gVn;
      if (localObject == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      ((SmileyPanel)localObject).setEntranceScene(ChatFooterPanel.rJs);
      localObject = this.gVn;
      if (localObject == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      ((SmileyPanel)localObject).setBackgroundResource(2131232332);
      localObject = this.gVn;
      if (localObject == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      ((SmileyPanel)localObject).fbF();
      localObject = this.gVn;
      if (localObject == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      ((SmileyPanel)localObject).fbH();
      localObject = this.gVn;
      if (localObject == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      ((SmileyPanel)localObject).fbG();
      localObject = this.gVn;
      if (localObject == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      ((SmileyPanel)localObject).setVisibility(4);
      localObject = this.gVn;
      if (localObject == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      ((SmileyPanel)localObject).onResume();
      localObject = this.gVn;
      if (localObject == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new d(this));
      localObject = new LinearLayout.LayoutParams(-1, (int)this.sTb);
      SmileyPanel localSmileyPanel = this.gVn;
      if (localSmileyPanel == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localSmileyPanel = this.gVn;
      if (localSmileyPanel == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      addView((View)localSmileyPanel, (ViewGroup.LayoutParams)localObject);
      localObject = this.sSV;
      if (localObject == null) {
        d.g.b.p.bcb("smileyBtn");
      }
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      setTranslationY(this.sTb);
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      this.sTa = (((Number)com.tencent.mm.plugin.finder.storage.b.cGU().value()).intValue() * 2);
      localObject = this.sSX;
      if (localObject == null) {
        d.g.b.p.bcb("replyBtn");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.sSW;
      if (localObject == null) {
        d.g.b.p.bcb("editText");
      }
      ((MMEditText)localObject).addTextChangedListener((TextWatcher)new f(this));
      localObject = this.sSW;
      if (localObject == null) {
        d.g.b.p.bcb("editText");
      }
      com.tencent.mm.ui.tools.b.c.d((EditText)localObject).kc(0, this.sTa).a(null);
      cNe();
      AppMethodBeat.o(168289);
      return;
      localObject = this.sST;
      if (localObject == null) {
        d.g.b.p.bcb("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131235000);
    }
  }
  
  public final void setBackClickListener(d.g.a.a<d.z> parama)
  {
    this.sTf = parama;
  }
  
  public final void setBanSwitchScene(boolean paramBoolean)
  {
    this.sTh = paramBoolean;
  }
  
  public final void setCommentEditTextLayout(View paramView)
  {
    AppMethodBeat.i(168284);
    d.g.b.p.h(paramView, "<set-?>");
    this.sSY = paramView;
    AppMethodBeat.o(168284);
  }
  
  public final void setCommentTextLimit(int paramInt)
  {
    this.sTa = paramInt;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(168280);
    d.g.b.p.h(paramMMEditText, "<set-?>");
    this.sSW = paramMMEditText;
    AppMethodBeat.o(168280);
  }
  
  public final void setFooterMode(int paramInt)
  {
    AppMethodBeat.i(168287);
    b localb = this.sTe;
    if (localb != null) {
      localb.onModeChange(this.sTi, paramInt);
    }
    this.sTi = paramInt;
    AppMethodBeat.o(168287);
  }
  
  public final void setFrozen(boolean paramBoolean)
  {
    this.sTd = paramBoolean;
  }
  
  public final void setLastActionStr(String paramString)
  {
    AppMethodBeat.i(205110);
    d.g.b.p.h(paramString, "<set-?>");
    this.sTk = paramString;
    AppMethodBeat.o(205110);
  }
  
  public final void setLastFromName(String paramString)
  {
    AppMethodBeat.i(205109);
    d.g.b.p.h(paramString, "<set-?>");
    this.sTj = paramString;
    AppMethodBeat.o(205109);
  }
  
  public final void setLastTag(Object paramObject)
  {
    this.sTl = paramObject;
  }
  
  public final void setModeChangeCallback(b paramb)
  {
    this.sTe = paramb;
  }
  
  public final void setReplyBtn(View paramView)
  {
    AppMethodBeat.i(168282);
    d.g.b.p.h(paramView, "<set-?>");
    this.sSX = paramView;
    AppMethodBeat.o(168282);
  }
  
  public final void setReplyBtnWidth(int paramInt)
  {
    this.gVo = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(205107);
    if ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
      ad.m("Finder.FinderCommentFooter", "set footer scene:".concat(String.valueOf(paramInt)), new Object[0]);
    }
    this.scene = paramInt;
    AppMethodBeat.o(205107);
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.sSE = paramBoolean;
  }
  
  public final void setSendBtnEnabled(boolean paramBoolean)
  {
    this.gVp = paramBoolean;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168278);
    d.g.b.p.h(paramImageView, "<set-?>");
    this.sSV = paramImageView;
    AppMethodBeat.o(168278);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168276);
    d.g.b.p.h(paramSmileyPanel, "<set-?>");
    this.gVn = paramSmileyPanel;
    AppMethodBeat.o(168276);
  }
  
  public final void setSwitchSceneAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(178477);
    d.g.b.p.h(paramImageView, "<set-?>");
    this.sSR = paramImageView;
    AppMethodBeat.o(178477);
  }
  
  public final void setSwitchSceneListener(d.g.a.a<d.z> parama)
  {
    this.sTg = parama;
  }
  
  public final void setSwitchSceneName(TextView paramTextView)
  {
    AppMethodBeat.i(178479);
    d.g.b.p.h(paramTextView, "<set-?>");
    this.sSS = paramTextView;
    AppMethodBeat.o(178479);
  }
  
  public final void setSwitchSceneTip(View paramView)
  {
    AppMethodBeat.i(178481);
    d.g.b.p.h(paramView, "<set-?>");
    this.sST = paramView;
    AppMethodBeat.o(178481);
  }
  
  public final void setSwitchSceneTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(178483);
    d.g.b.p.h(paramTextView, "<set-?>");
    this.sSU = paramTextView;
    AppMethodBeat.o(178483);
  }
  
  public final void setTargetAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(168286);
    d.g.b.p.h(paramImageView, "<set-?>");
    this.sSZ = paramImageView;
    AppMethodBeat.o(168286);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168288);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.sTd; paramBoolean = false)
    {
      AppMethodBeat.o(168288);
      return;
    }
    if ((paramInt > 0) && (paramInt != (int)this.sTb))
    {
      com.tencent.mm.sdk.platformtools.z.aF(getContext(), paramInt);
      this.sTb = paramInt;
      localObject = new LinearLayout.LayoutParams(-1, (int)this.sTb);
      SmileyPanel localSmileyPanel = this.gVn;
      if (localSmileyPanel == null) {
        d.g.b.p.bcb("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.sTc != paramBoolean)
    {
      this.sTc = paramBoolean;
      if (!paramBoolean) {
        break label191;
      }
      animate().setDuration(90L).translationY(0.0F).setListener((Animator.AnimatorListener)new i(this)).start();
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if ((com.tencent.mm.plugin.finder.storage.b.cHd() <= 0) || (!cNg())) {
        break;
      }
      localObject = this.sST;
      if (localObject == null) {
        d.g.b.p.bcb("switchSceneTip");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(168288);
      return;
      label191:
      if ((this.sTi == 2) || (this.sTi == 0)) {
        animate().setDuration(180L).translationY(this.sTb).setListener((Animator.AnimatorListener)new j(this)).start();
      }
    }
    Object localObject = this.sST;
    if (localObject == null) {
      d.g.b.p.bcb("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168288);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$Companion;", "", "()V", "MODE_DEFAULT", "", "MODE_KEYBOARD", "MODE_SMILEY", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "", "onModeChange", "", "from", "", "to", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void onModeChange(int paramInt1, int paramInt2);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class d
    implements ChatFooterPanel.a
  {
    public final void aoO()
    {
      AppMethodBeat.i(168257);
      if (this.sTp.getEditText().getInputConnection() != null)
      {
        this.sTp.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        this.sTp.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      }
      AppMethodBeat.o(168257);
    }
    
    public final void aoP() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168256);
      this.sTp.getEditText().aXD(paramString);
      AppMethodBeat.o(168256);
    }
    
    public final void dU(boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        FinderCommentFooter.a(this.sTp, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168258);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class f
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(205101);
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
            AppMethodBeat.o(205101);
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
        if (bool != this.sTp.getSendBtnEnabled()) {
          break label119;
        }
        AppMethodBeat.o(205101);
        return;
        i = 0;
        break;
      }
      label119:
      this.sTp.setSendBtnEnabled(bool);
      if (this.sTp.getSendBtnEnabled())
      {
        paramEditable = new ValueAnimator();
        paramEditable.setIntValues(new int[] { 0, this.sTp.getReplyBtnWidth() });
        paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
        paramEditable.setDuration(150L);
        paramEditable.addListener((Animator.AnimatorListener)new b(this));
        paramEditable.start();
        AppMethodBeat.o(205101);
        return;
      }
      paramEditable = new ValueAnimator();
      paramEditable.setIntValues(new int[] { this.sTp.getReplyBtnWidth(), 0 });
      paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
      paramEditable.setDuration(150L);
      paramEditable.addListener((Animator.AnimatorListener)new d(this));
      paramEditable.start();
      AppMethodBeat.o(205101);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(FinderCommentFooter.f paramf) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(205093);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(205093);
          throw paramValueAnimator;
        }
        float f = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.sTq.sTp.getReplyBtn().getLayoutParams();
        paramValueAnimator.width = d.h.a.co(f);
        this.sTq.sTp.getReplyBtn().setLayoutParams(paramValueAnimator);
        this.sTq.sTp.getReplyBtn().setAlpha(f / this.sTq.sTp.getReplyBtnWidth());
        AppMethodBeat.o(205093);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(205095);
        paramAnimator = this.sTq.sTp.getReplyBtn().getLayoutParams();
        paramAnimator.width = this.sTq.sTp.getReplyBtnWidth();
        this.sTq.sTp.getReplyBtn().setLayoutParams(paramAnimator);
        this.sTq.sTp.getReplyBtn().setAlpha(1.0F);
        AppMethodBeat.o(205095);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(205094);
        paramAnimator = this.sTq.sTp.getReplyBtn().getLayoutParams();
        paramAnimator.width = this.sTq.sTp.getReplyBtnWidth();
        this.sTq.sTp.getReplyBtn().setLayoutParams(paramAnimator);
        this.sTq.sTp.getReplyBtn().setAlpha(1.0F);
        AppMethodBeat.o(205094);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(205096);
        this.sTq.sTp.getReplyBtn().setVisibility(0);
        AppMethodBeat.o(205096);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class c
      implements ValueAnimator.AnimatorUpdateListener
    {
      c(FinderCommentFooter.f paramf) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(205097);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(205097);
          throw paramValueAnimator;
        }
        float f = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.sTq.sTp.getReplyBtn().getLayoutParams();
        paramValueAnimator.width = d.h.a.co(f);
        this.sTq.sTp.getReplyBtn().setLayoutParams(paramValueAnimator);
        this.sTq.sTp.getReplyBtn().setAlpha(f / this.sTq.sTp.getReplyBtnWidth());
        AppMethodBeat.o(205097);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class d
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(205099);
        this.sTq.sTp.getReplyBtn().setVisibility(8);
        AppMethodBeat.o(205099);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(205098);
        this.sTq.sTp.getReplyBtn().setVisibility(8);
        AppMethodBeat.o(205098);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(205100);
        this.sTq.sTp.getReplyBtn().setVisibility(0);
        AppMethodBeat.o(205100);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168269);
      this.sTp.getSmileyPanel().setVisibility(4);
      this.sTp.getSmileyBtn().setImageResource(2131231701);
      if (paramBoolean) {
        this.sTp.setFooterMode(0);
      }
      AppMethodBeat.o(168269);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168270);
      this.sTp.getSmileyPanel().setAlpha(1.0F);
      this.sTp.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168270);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221568);
      this.sTp.setFooterMode(2);
      AppMethodBeat.o(221568);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221569);
      this.sTp.setFooterMode(0);
      AppMethodBeat.o(221569);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class k
    implements View.OnLayoutChangeListener
  {
    k(d.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(168273);
      this.sTp.getSmileyPanel().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      this.sTs.invoke();
      AppMethodBeat.o(168273);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<d.z>
  {
    l(FinderCommentFooter paramFinderCommentFooter)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205104);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cHd() > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
        com.tencent.mm.plugin.finder.storage.b.Fi(0);
        this.sTp.getSwitchSceneTip().setVisibility(8);
        paramView = new d(this.sTp.getContext());
        paramView.Gc(2131494115);
        al.a((Paint)((TextView)paramView.kBS.findViewById(2131300009)).getPaint(), 0.8F);
        localObject = paramView.kBS.findViewById(2131300007);
        FinderCommentFooter localFinderCommentFooter = this.sTp;
        d.g.b.p.g(localObject, "item1");
        FinderCommentFooter.a(localFinderCommentFooter, (View)localObject, 1, (d.g.a.b)new a(paramView, this));
        localObject = paramView.kBS.findViewById(2131300008);
        localFinderCommentFooter = this.sTp;
        d.g.b.p.g(localObject, "item2");
        FinderCommentFooter.a(localFinderCommentFooter, (View)localObject, 2, (d.g.a.b)new b(paramView, this));
        paramView.cMW();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205104);
        return;
        FinderCommentFooter.a(this.sTp);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$1"})
    static final class a
      extends q
      implements d.g.a.b<Integer, d.z>
    {
      a(d paramd, FinderCommentFooter.m paramm)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$2"})
    static final class b
      extends q
      implements d.g.a.b<Integer, d.z>
    {
      b(d paramd, FinderCommentFooter.m paramm)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter
 * JD-Core Version:    0.7.0.1
 */