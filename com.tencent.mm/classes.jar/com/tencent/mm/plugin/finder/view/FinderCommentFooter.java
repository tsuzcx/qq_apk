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
import com.tencent.mm.api.ad;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "banSwitchScene", "", "getBanSwitchScene", "()Z", "setBanSwitchScene", "(Z)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "setFrozen", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "lastActionStr", "", "getLastActionStr", "()Ljava/lang/String;", "setLastActionStr", "(Ljava/lang/String;)V", "lastFromName", "getLastFromName", "setLastFromName", "lastTag", "", "getLastTag", "()Ljava/lang/Object;", "setLastTag", "(Ljava/lang/Object;)V", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "fromName", "actionStr", "tag", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "showRemark", "changeReplyToCommenter", "toName", "changeReplyToPoster", "changeSelfName", "selfName", "ellipseName", "name", "getAvatarView", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "showVKB", "isShow", "Companion", "IModeChangeCallback", "plugin-finder_release"})
public final class FinderCommentFooter
  extends LinearLayout
  implements com.tencent.mm.ui.tools.g
{
  public static final a wlh;
  public SmileyPanel hQS;
  private int hQT;
  private boolean hQU;
  private int scene;
  private boolean uLZ;
  private boolean uMD;
  public ImageView wkN;
  public TextView wkO;
  public View wkP;
  public TextView wkQ;
  public ImageView wkR;
  public MMEditText wkS;
  public View wkT;
  public View wkU;
  public ImageView wkV;
  private int wkW;
  private float wkX;
  private boolean wkY;
  private b wkZ;
  private kotlin.g.a.a<x> wla;
  private kotlin.g.a.a<x> wlb;
  private boolean wlc;
  public int wld;
  public String wle;
  private String wlf;
  private Object wlg;
  
  static
  {
    AppMethodBeat.i(168295);
    wlh = new a((byte)0);
    AppMethodBeat.o(168295);
  }
  
  public FinderCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168294);
    this.wkX = KeyBoardUtil.getKeyBordHeightPx(getContext());
    this.hQT = at.aH(getContext(), 2131165310);
    this.scene = 2;
    this.wle = "";
    this.wlf = "";
    AppMethodBeat.o(168294);
  }
  
  private void awP(String paramString)
  {
    AppMethodBeat.i(254755);
    p.h(paramString, "selfName");
    f(awQ(paramString), this.wlf, this.wlg);
    AppMethodBeat.o(254755);
  }
  
  private final boolean dGz()
  {
    AppMethodBeat.i(178488);
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if ((((Number)com.tencent.mm.plugin.finder.storage.c.dsP().value()).intValue() == 1) && (!this.uLZ))
    {
      localObject = y.vXH;
      if ((y.dCB()) && (!this.wlc))
      {
        AppMethodBeat.o(178488);
        return true;
      }
    }
    AppMethodBeat.o(178488);
    return false;
  }
  
  public final String awQ(String paramString)
  {
    AppMethodBeat.i(254759);
    Object localObject = com.tencent.mm.plugin.finder.convert.d.tyZ;
    localObject = getContext();
    p.g(localObject, "context");
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    int i = com.tencent.mm.plugin.finder.convert.d.Z((Context)localObject, com.tencent.mm.plugin.finder.storage.c.drZ());
    localObject = com.tencent.mm.plugin.finder.convert.d.tyZ;
    localObject = getContext();
    p.g(localObject, "context");
    localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    int j = com.tencent.mm.plugin.finder.convert.d.Z((Context)localObject, com.tencent.mm.plugin.finder.storage.c.drZ() + 1);
    localObject = com.tencent.mm.plugin.finder.convert.d.tyZ;
    localObject = this.wkS;
    if (localObject == null) {
      p.btv("editText");
    }
    localObject = ((MMEditText)localObject).getPaint();
    p.g(localObject, "editText.paint");
    paramString = com.tencent.mm.plugin.finder.convert.d.a((TextPaint)localObject, paramString, i, j);
    AppMethodBeat.o(254759);
    return paramString;
  }
  
  public final void cH(boolean paramBoolean)
  {
    Context localContext = null;
    Object localObject = null;
    AppMethodBeat.i(168292);
    if (this.wkY)
    {
      AppMethodBeat.o(168292);
      return;
    }
    if ((this.uMD) && (paramBoolean))
    {
      AppMethodBeat.o(168292);
      return;
    }
    if (paramBoolean)
    {
      localContext = getContext();
      if ((localContext instanceof MMFragmentActivity)) {
        break label129;
      }
    }
    for (;;)
    {
      localObject = (MMFragmentActivity)localObject;
      if (localObject != null)
      {
        ((MMFragmentActivity)localObject).showVKB();
        AppMethodBeat.o(168292);
        return;
      }
      AppMethodBeat.o(168292);
      return;
      localObject = getContext();
      if (!(localObject instanceof MMFragmentActivity)) {
        localObject = localContext;
      }
      for (;;)
      {
        localObject = (MMFragmentActivity)localObject;
        if (localObject != null)
        {
          ((MMFragmentActivity)localObject).hideVKB();
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
  
  public final void dGx()
  {
    AppMethodBeat.i(178484);
    Object localObject = this.wkP;
    if (localObject == null) {
      p.btv("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    dGy();
    localObject = findViewById(2131298963);
    if (dGz())
    {
      ((View)localObject).findViewById(2131298960).setVisibility(0);
      ((View)localObject).setOnClickListener((View.OnClickListener)new m(this));
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.dsR() > 0)
      {
        localObject = this.wkP;
        if (localObject == null) {
          p.btv("switchSceneTip");
        }
        ((View)localObject).setVisibility(0);
      }
      localObject = this.wkV;
      if (localObject == null) {
        p.btv("targetAvatar");
      }
      ((ImageView)localObject).setVisibility(8);
      localObject = this.wkS;
      if (localObject == null) {
        p.btv("editText");
      }
      Context localContext = ((MMEditText)localObject).getContext();
      p.g(localContext, "this.context");
      int i = (int)localContext.getResources().getDimension(2131165314);
      localContext = ((MMEditText)localObject).getContext();
      p.g(localContext, "this.context");
      ((MMEditText)localObject).setPadding(i, 0, (int)localContext.getResources().getDimension(2131165314), 0);
      AppMethodBeat.o(178484);
      return;
      ((View)localObject).setOnClickListener((View.OnClickListener)FinderCommentFooter.n.wlp);
      localObject = ((View)localObject).findViewById(2131298960);
      p.g(localObject, "switchClickLayout.findVi…>(R.id.comment_scene_btn)");
      ((View)localObject).setVisibility(8);
    }
  }
  
  public final void dGy()
  {
    AppMethodBeat.i(178485);
    Object localObject1;
    if (this.scene == 2)
    {
      localObject1 = this.wkN;
      if (localObject1 == null) {
        p.btv("switchSceneAvatar");
      }
      com.tencent.mm.ui.g.a.a.c((ImageView)localObject1, z.aTY());
      localObject1 = this.wkQ;
      if (localObject1 == null) {
        p.btv("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131760609);
    }
    for (;;)
    {
      localObject1 = this.wkO;
      if (localObject1 == null) {
        p.btv("switchSceneName");
      }
      Object localObject2 = getContext();
      Object localObject3 = y.vXH;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)y.LD(this.scene)));
      localObject1 = y.vXH;
      awP(y.LD(this.scene));
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.dsR() <= 0)
      {
        localObject1 = this.wkP;
        if (localObject1 == null) {
          p.btv("switchSceneTip");
        }
        if (((View)localObject1).getVisibility() == 0)
        {
          localObject1 = this.wkP;
          if (localObject1 == null) {
            p.btv("switchSceneTip");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(178485);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
      localObject1 = c.a.asG(z.aUg());
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject1).cXH();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = m.uJa;
      localObject2 = m.dka();
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject3 = this.wkN;
      if (localObject3 == null) {
        p.btv("switchSceneAvatar");
      }
      m localm = m.uJa;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, m.a(m.a.uJe));
      localObject1 = this.wkQ;
      if (localObject1 == null) {
        p.btv("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(2131760609);
    }
  }
  
  public final void e(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(178487);
    p.h(paramString1, "fromName");
    p.h(paramString2, "toName");
    f(this.wle, " " + getResources().getString(2131757750, new Object[] { paramString2 }), paramObject);
    AppMethodBeat.o(178487);
  }
  
  public final void f(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(254758);
    if (paramString1 == null) {}
    for (String str = "";; str = paramString1)
    {
      this.wle = str;
      this.wlf = paramString2;
      this.wlg = paramObject;
      paramString1 = p.I(paramString1, paramString2);
      paramString2 = this.wkS;
      if (paramString2 == null) {
        p.btv("editText");
      }
      paramString2.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)paramString1));
      paramString1 = this.wkS;
      if (paramString1 == null) {
        p.btv("editText");
      }
      paramString1.setTag(paramObject);
      paramString1 = this.wkS;
      if (paramString1 == null) {
        p.btv("editText");
      }
      if (!paramString1.hasFocus())
      {
        paramString1 = this.wkS;
        if (paramString1 == null) {
          p.btv("editText");
        }
        paramString1.requestFocus();
      }
      AppMethodBeat.o(254758);
      return;
    }
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(168293);
    ImageView localImageView = this.wkV;
    if (localImageView == null) {
      p.btv("targetAvatar");
    }
    AppMethodBeat.o(168293);
    return localImageView;
  }
  
  public final kotlin.g.a.a<x> getBackClickListener()
  {
    return this.wla;
  }
  
  public final boolean getBanSwitchScene()
  {
    return this.wlc;
  }
  
  public final View getCommentEditTextLayout()
  {
    AppMethodBeat.i(168283);
    View localView = this.wkU;
    if (localView == null) {
      p.btv("commentEditTextLayout");
    }
    AppMethodBeat.o(168283);
    return localView;
  }
  
  public final int getCommentTextLimit()
  {
    return this.wkW;
  }
  
  public final MMEditText getEditText()
  {
    AppMethodBeat.i(168279);
    MMEditText localMMEditText = this.wkS;
    if (localMMEditText == null) {
      p.btv("editText");
    }
    AppMethodBeat.o(168279);
    return localMMEditText;
  }
  
  public final int getFooterMode()
  {
    return this.wld;
  }
  
  public final String getLastActionStr()
  {
    return this.wlf;
  }
  
  public final String getLastFromName()
  {
    return this.wle;
  }
  
  public final Object getLastTag()
  {
    return this.wlg;
  }
  
  public final b getModeChangeCallback()
  {
    return this.wkZ;
  }
  
  public final View getReplyBtn()
  {
    AppMethodBeat.i(168281);
    View localView = this.wkT;
    if (localView == null) {
      p.btv("replyBtn");
    }
    AppMethodBeat.o(168281);
    return localView;
  }
  
  public final int getReplyBtnWidth()
  {
    return this.hQT;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final boolean getSendBtnEnabled()
  {
    return this.hQU;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168277);
    ImageView localImageView = this.wkR;
    if (localImageView == null) {
      p.btv("smileyBtn");
    }
    AppMethodBeat.o(168277);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168275);
    SmileyPanel localSmileyPanel = this.hQS;
    if (localSmileyPanel == null) {
      p.btv("smileyPanel");
    }
    AppMethodBeat.o(168275);
    return localSmileyPanel;
  }
  
  public final ImageView getSwitchSceneAvatar()
  {
    AppMethodBeat.i(178476);
    ImageView localImageView = this.wkN;
    if (localImageView == null) {
      p.btv("switchSceneAvatar");
    }
    AppMethodBeat.o(178476);
    return localImageView;
  }
  
  public final kotlin.g.a.a<x> getSwitchSceneListener()
  {
    return this.wlb;
  }
  
  public final TextView getSwitchSceneName()
  {
    AppMethodBeat.i(178478);
    TextView localTextView = this.wkO;
    if (localTextView == null) {
      p.btv("switchSceneName");
    }
    AppMethodBeat.o(178478);
    return localTextView;
  }
  
  public final View getSwitchSceneTip()
  {
    AppMethodBeat.i(178480);
    View localView = this.wkP;
    if (localView == null) {
      p.btv("switchSceneTip");
    }
    AppMethodBeat.o(178480);
    return localView;
  }
  
  public final TextView getSwitchSceneTipTv()
  {
    AppMethodBeat.i(178482);
    TextView localTextView = this.wkQ;
    if (localTextView == null) {
      p.btv("switchSceneTipTv");
    }
    AppMethodBeat.o(178482);
    return localTextView;
  }
  
  public final ImageView getTargetAvatar()
  {
    AppMethodBeat.i(168285);
    ImageView localImageView = this.wkV;
    if (localImageView == null) {
      p.btv("targetAvatar");
    }
    AppMethodBeat.o(168285);
    return localImageView;
  }
  
  public final void hk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178486);
    p.h(paramString1, "fromName");
    p.h(paramString2, "toName");
    f(this.wle, " " + getResources().getString(2131757753), null);
    AppMethodBeat.o(178486);
  }
  
  public final void oW(final boolean paramBoolean)
  {
    AppMethodBeat.i(168290);
    if (this.wkY)
    {
      AppMethodBeat.o(168290);
      return;
    }
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
    if (paramBoolean)
    {
      animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(220L).translationY(this.wkX).setListener((Animator.AnimatorListener)new g(this, paramBoolean)).start();
      AppMethodBeat.o(168290);
      return;
    }
    localObject = this.hQS;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new h(this)).start();
    AppMethodBeat.o(168290);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168289);
    super.onFinishInflate();
    Object localObject = findViewById(2131298959);
    p.g(localObject, "findViewById(R.id.comment_scene_avatar)");
    this.wkN = ((ImageView)localObject);
    localObject = findViewById(2131298961);
    p.g(localObject, "findViewById(R.id.comment_scene_name)");
    this.wkO = ((TextView)localObject);
    localObject = findViewById(2131298964);
    p.g(localObject, "findViewById(R.id.comment_switch_scene_tip_layout)");
    this.wkP = ((View)localObject);
    localObject = findViewById(2131298965);
    p.g(localObject, "findViewById(R.id.comment_switch_scene_tip_tv)");
    this.wkQ = ((TextView)localObject);
    localObject = findViewById(2131307949);
    p.g(localObject, "findViewById(R.id.smiley_btn)");
    this.wkR = ((ImageView)localObject);
    localObject = findViewById(2131298939);
    p.g(localObject, "findViewById(R.id.comment_et)");
    this.wkS = ((MMEditText)localObject);
    localObject = findViewById(2131298966);
    p.g(localObject, "findViewById(R.id.comment_target_avatar)");
    this.wkV = ((ImageView)localObject);
    localObject = findViewById(2131306945);
    p.g(localObject, "findViewById(R.id.reply_btn)");
    this.wkT = ((View)localObject);
    localObject = findViewById(2131298940);
    p.g(localObject, "findViewById(R.id.comment_et_layout)");
    this.wkU = ((View)localObject);
    if (ao.isDarkMode())
    {
      localObject = this.wkP;
      if (localObject == null) {
        p.btv("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131232738);
    }
    for (;;)
    {
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
      ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new d(this));
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
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      setTranslationY(this.wkX);
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      this.wkW = (((Number)com.tencent.mm.plugin.finder.storage.c.dsz().value()).intValue() * 2);
      localObject = this.wkT;
      if (localObject == null) {
        p.btv("replyBtn");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.wkS;
      if (localObject == null) {
        p.btv("editText");
      }
      ((MMEditText)localObject).addTextChangedListener((TextWatcher)new f(this));
      localObject = this.wkS;
      if (localObject == null) {
        p.btv("editText");
      }
      com.tencent.mm.ui.tools.b.c.f((EditText)localObject).lv(0, this.wkW).a(null);
      dGx();
      AppMethodBeat.o(168289);
      return;
      localObject = this.wkP;
      if (localObject == null) {
        p.btv("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(2131232736);
    }
  }
  
  public final void setBackClickListener(kotlin.g.a.a<x> parama)
  {
    this.wla = parama;
  }
  
  public final void setBanSwitchScene(boolean paramBoolean)
  {
    this.wlc = paramBoolean;
  }
  
  public final void setCommentEditTextLayout(View paramView)
  {
    AppMethodBeat.i(168284);
    p.h(paramView, "<set-?>");
    this.wkU = paramView;
    AppMethodBeat.o(168284);
  }
  
  public final void setCommentTextLimit(int paramInt)
  {
    this.wkW = paramInt;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(168280);
    p.h(paramMMEditText, "<set-?>");
    this.wkS = paramMMEditText;
    AppMethodBeat.o(168280);
  }
  
  public final void setFooterMode(int paramInt)
  {
    AppMethodBeat.i(168287);
    b localb = this.wkZ;
    if (localb != null) {
      localb.onModeChange(this.wld, paramInt);
    }
    this.wld = paramInt;
    AppMethodBeat.o(168287);
  }
  
  public final void setFrozen(boolean paramBoolean)
  {
    this.wkY = paramBoolean;
  }
  
  public final void setLastActionStr(String paramString)
  {
    AppMethodBeat.i(254757);
    p.h(paramString, "<set-?>");
    this.wlf = paramString;
    AppMethodBeat.o(254757);
  }
  
  public final void setLastFromName(String paramString)
  {
    AppMethodBeat.i(254756);
    p.h(paramString, "<set-?>");
    this.wle = paramString;
    AppMethodBeat.o(254756);
  }
  
  public final void setLastTag(Object paramObject)
  {
    this.wlg = paramObject;
  }
  
  public final void setModeChangeCallback(b paramb)
  {
    this.wkZ = paramb;
  }
  
  public final void setReplyBtn(View paramView)
  {
    AppMethodBeat.i(168282);
    p.h(paramView, "<set-?>");
    this.wkT = paramView;
    AppMethodBeat.o(168282);
  }
  
  public final void setReplyBtnWidth(int paramInt)
  {
    this.hQT = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(254754);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      Log.printInfoStack("Finder.FinderCommentFooter", "set footer scene:".concat(String.valueOf(paramInt)), new Object[0]);
    }
    this.scene = paramInt;
    AppMethodBeat.o(254754);
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.uLZ = paramBoolean;
  }
  
  public final void setSendBtnEnabled(boolean paramBoolean)
  {
    this.hQU = paramBoolean;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168278);
    p.h(paramImageView, "<set-?>");
    this.wkR = paramImageView;
    AppMethodBeat.o(168278);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168276);
    p.h(paramSmileyPanel, "<set-?>");
    this.hQS = paramSmileyPanel;
    AppMethodBeat.o(168276);
  }
  
  public final void setSwitchSceneAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(178477);
    p.h(paramImageView, "<set-?>");
    this.wkN = paramImageView;
    AppMethodBeat.o(178477);
  }
  
  public final void setSwitchSceneListener(kotlin.g.a.a<x> parama)
  {
    this.wlb = parama;
  }
  
  public final void setSwitchSceneName(TextView paramTextView)
  {
    AppMethodBeat.i(178479);
    p.h(paramTextView, "<set-?>");
    this.wkO = paramTextView;
    AppMethodBeat.o(178479);
  }
  
  public final void setSwitchSceneTip(View paramView)
  {
    AppMethodBeat.i(178481);
    p.h(paramView, "<set-?>");
    this.wkP = paramView;
    AppMethodBeat.o(178481);
  }
  
  public final void setSwitchSceneTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(178483);
    p.h(paramTextView, "<set-?>");
    this.wkQ = paramTextView;
    AppMethodBeat.o(178483);
  }
  
  public final void setTargetAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(168286);
    p.h(paramImageView, "<set-?>");
    this.wkV = paramImageView;
    AppMethodBeat.o(168286);
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168288);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.wkY; paramBoolean = false)
    {
      AppMethodBeat.o(168288);
      return;
    }
    if ((paramInt > 0) && (paramInt != (int)this.wkX))
    {
      KeyBoardUtil.saveKeyBordHeightPx(getContext(), paramInt);
      this.wkX = paramInt;
      localObject = new LinearLayout.LayoutParams(-1, (int)this.wkX);
      SmileyPanel localSmileyPanel = this.hQS;
      if (localSmileyPanel == null) {
        p.btv("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.uMD != paramBoolean)
    {
      this.uMD = paramBoolean;
      if (!paramBoolean) {
        break label191;
      }
      animate().setDuration(90L).translationY(0.0F).setListener((Animator.AnimatorListener)new i(this)).start();
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((com.tencent.mm.plugin.finder.storage.c.dsR() <= 0) || (!dGz())) {
        break;
      }
      localObject = this.wkP;
      if (localObject == null) {
        p.btv("switchSceneTip");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(168288);
      return;
      label191:
      if ((this.wld == 2) || (this.wld == 0)) {
        animate().setDuration(180L).translationY(this.wkX).setListener((Animator.AnimatorListener)new j(this)).start();
      }
    }
    Object localObject = this.wkP;
    if (localObject == null) {
      p.btv("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168288);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$Companion;", "", "()V", "MODE_DEFAULT", "", "MODE_KEYBOARD", "MODE_SMILEY", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "", "onModeChange", "", "from", "", "to", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void onModeChange(int paramInt1, int paramInt2);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class d
    implements ChatFooterPanel.a
  {
    public final void aHC()
    {
      AppMethodBeat.i(168257);
      if (this.wlk.getEditText().getInputConnection() != null)
      {
        this.wlk.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        this.wlk.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      }
      AppMethodBeat.o(168257);
    }
    
    public final void aHD() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(168256);
      this.wlk.getEditText().bol(paramString);
      AppMethodBeat.o(168256);
    }
    
    public final void eP(boolean paramBoolean) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(168258);
        throw paramView;
      }
      paramView = ((ImageView)paramView).getTag();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(168258);
        throw paramView;
      }
      if (!((Boolean)paramView).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        FinderCommentFooter.a(this.wlk, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168258);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class f
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(254746);
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
            paramEditable = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(254746);
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
        if (bool != this.wlk.getSendBtnEnabled()) {
          break label119;
        }
        AppMethodBeat.o(254746);
        return;
        i = 0;
        break;
      }
      label119:
      this.wlk.setSendBtnEnabled(bool);
      if (this.wlk.getSendBtnEnabled())
      {
        paramEditable = new ValueAnimator();
        paramEditable.setIntValues(new int[] { 0, this.wlk.getReplyBtnWidth() });
        paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
        paramEditable.setDuration(150L);
        paramEditable.addListener((Animator.AnimatorListener)new b(this));
        paramEditable.start();
        AppMethodBeat.o(254746);
        return;
      }
      paramEditable = new ValueAnimator();
      paramEditable.setIntValues(new int[] { this.wlk.getReplyBtnWidth(), 0 });
      paramEditable.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
      paramEditable.setDuration(150L);
      paramEditable.addListener((Animator.AnimatorListener)new d(this));
      paramEditable.start();
      AppMethodBeat.o(254746);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(FinderCommentFooter.f paramf) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(254738);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(254738);
          throw paramValueAnimator;
        }
        float f = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.wll.wlk.getReplyBtn().getLayoutParams();
        paramValueAnimator.width = kotlin.h.a.cR(f);
        this.wll.wlk.getReplyBtn().setLayoutParams(paramValueAnimator);
        this.wll.wlk.getReplyBtn().setAlpha(f / this.wll.wlk.getReplyBtnWidth());
        AppMethodBeat.o(254738);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(254740);
        paramAnimator = this.wll.wlk.getReplyBtn().getLayoutParams();
        paramAnimator.width = this.wll.wlk.getReplyBtnWidth();
        this.wll.wlk.getReplyBtn().setLayoutParams(paramAnimator);
        this.wll.wlk.getReplyBtn().setAlpha(1.0F);
        AppMethodBeat.o(254740);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(254739);
        paramAnimator = this.wll.wlk.getReplyBtn().getLayoutParams();
        paramAnimator.width = this.wll.wlk.getReplyBtnWidth();
        this.wll.wlk.getReplyBtn().setLayoutParams(paramAnimator);
        this.wll.wlk.getReplyBtn().setAlpha(1.0F);
        AppMethodBeat.o(254739);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(254741);
        this.wll.wlk.getReplyBtn().setVisibility(0);
        AppMethodBeat.o(254741);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class c
      implements ValueAnimator.AnimatorUpdateListener
    {
      c(FinderCommentFooter.f paramf) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(254742);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(254742);
          throw paramValueAnimator;
        }
        float f = ((Integer)paramValueAnimator).intValue();
        paramValueAnimator = this.wll.wlk.getReplyBtn().getLayoutParams();
        paramValueAnimator.width = kotlin.h.a.cR(f);
        this.wll.wlk.getReplyBtn().setLayoutParams(paramValueAnimator);
        this.wll.wlk.getReplyBtn().setAlpha(f / this.wll.wlk.getReplyBtnWidth());
        AppMethodBeat.o(254742);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class d
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(254744);
        this.wll.wlk.getReplyBtn().setVisibility(8);
        AppMethodBeat.o(254744);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(254743);
        this.wll.wlk.getReplyBtn().setVisibility(8);
        AppMethodBeat.o(254743);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator)
      {
        AppMethodBeat.i(254745);
        this.wll.wlk.getReplyBtn().setVisibility(0);
        AppMethodBeat.o(254745);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168269);
      this.wlk.getSmileyPanel().setVisibility(4);
      this.wlk.getSmileyBtn().setImageResource(2131231772);
      if (paramBoolean) {
        this.wlk.setFooterMode(0);
      }
      AppMethodBeat.o(168269);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168270);
      this.wlk.getSmileyPanel().setAlpha(1.0F);
      this.wlk.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168270);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class i
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(254747);
      this.wlk.setFooterMode(2);
      AppMethodBeat.o(254747);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(254748);
      this.wlk.setFooterMode(0);
      AppMethodBeat.o(254748);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class k
    implements View.OnLayoutChangeListener
  {
    k(kotlin.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(168273);
      this.wlk.getSmileyPanel().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      this.wln.invoke();
      AppMethodBeat.o(168273);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(FinderCommentFooter paramFinderCommentFooter)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254751);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.dsR() > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c.KR(0);
        this.wlk.getSwitchSceneTip().setVisibility(8);
        paramView = new d(this.wlk.getContext());
        paramView.Ml(2131494644);
        ao.a((Paint)((TextView)paramView.lJI.findViewById(2131301359)).getPaint(), 0.8F);
        localObject = paramView.lJI.findViewById(2131301357);
        FinderCommentFooter localFinderCommentFooter = this.wlk;
        p.g(localObject, "item1");
        FinderCommentFooter.a(localFinderCommentFooter, (View)localObject, 1, (kotlin.g.a.b)new a(paramView, this));
        localObject = paramView.lJI.findViewById(2131301358);
        localFinderCommentFooter = this.wlk;
        p.g(localObject, "item2");
        FinderCommentFooter.a(localFinderCommentFooter, (View)localObject, 2, (kotlin.g.a.b)new b(paramView, this));
        paramView.dGm();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254751);
        return;
        FinderCommentFooter.a(this.wlk);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.b<Integer, x>
    {
      a(d paramd, FinderCommentFooter.m paramm)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$2"})
    static final class b
      extends q
      implements kotlin.g.a.b<Integer, x>
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