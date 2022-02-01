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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "banSwitchScene", "", "getBanSwitchScene", "()Z", "setBanSwitchScene", "(Z)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "getEditText", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setEditText", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "setFrozen", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "lastActionStr", "", "getLastActionStr", "()Ljava/lang/String;", "setLastActionStr", "(Ljava/lang/String;)V", "lastFromName", "getLastFromName", "setLastFromName", "lastTag", "", "getLastTag", "()Ljava/lang/Object;", "setLastTag", "(Ljava/lang/Object;)V", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Landroid/widget/ImageView;", "getSmileyBtn", "()Landroid/widget/ImageView;", "setSmileyBtn", "(Landroid/widget/ImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "fromName", "actionStr", "tag", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "showRemark", "changeReplyToCommenter", "toName", "changeReplyToPoster", "changeSelfName", "selfName", "checkShowReplyBtn", "s", "Landroid/text/Editable;", "ellipseName", "name", "getAvatarView", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "showVKB", "isShow", "Companion", "IModeChangeCallback", "plugin-finder_release"})
public final class FinderCommentFooter
  extends LinearLayout
  implements h
{
  public static final a AWc;
  public ImageView AVI;
  public TextView AVJ;
  public View AVK;
  public TextView AVL;
  public ImageView AVM;
  public MMEditText AVN;
  public View AVO;
  public View AVP;
  public ImageView AVQ;
  private int AVR;
  private float AVS;
  private boolean AVT;
  private b AVU;
  private kotlin.g.a.a<x> AVV;
  private kotlin.g.a.a<x> AVW;
  private boolean AVX;
  public int AVY;
  public String AVZ;
  private String AWa;
  private Object AWb;
  public SmileyPanel kFp;
  private int kFq;
  private boolean kFr;
  private int scene;
  private boolean zxL;
  private boolean zyt;
  
  static
  {
    AppMethodBeat.i(168295);
    AWc = new a((byte)0);
    AppMethodBeat.o(168295);
  }
  
  public FinderCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168294);
    this.AVS = KeyBoardUtil.getKeyBordHeightPx(getContext());
    this.kFq = aw.aZ(getContext(), b.d.Edge_7A);
    this.scene = 2;
    this.AVZ = "";
    this.AWa = "";
    AppMethodBeat.o(168294);
  }
  
  private void aGv(String paramString)
  {
    AppMethodBeat.i(269224);
    p.k(paramString, "selfName");
    f(aGw(paramString), this.AWa, this.AWb);
    AppMethodBeat.o(269224);
  }
  
  private final boolean eiz()
  {
    AppMethodBeat.i(178488);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.dUh().aSr()).intValue() == 1) && (!this.zxL))
    {
      localObject = aj.AGc;
      if ((aj.edY()) && (!this.AVX))
      {
        AppMethodBeat.o(178488);
        return true;
      }
    }
    AppMethodBeat.o(178488);
    return false;
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168288);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.AVT; paramBoolean = false)
    {
      AppMethodBeat.o(168288);
      return;
    }
    if ((paramInt > 0) && (paramInt != (int)this.AVS))
    {
      KeyBoardUtil.saveKeyBordHeightPx(getContext(), paramInt);
      this.AVS = paramInt;
      localObject = new LinearLayout.LayoutParams(-1, (int)this.AVS);
      SmileyPanel localSmileyPanel = this.kFp;
      if (localSmileyPanel == null) {
        p.bGy("smileyPanel");
      }
      localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.zyt != paramBoolean)
    {
      this.zyt = paramBoolean;
      if (!paramBoolean) {
        break label191;
      }
      animate().setDuration(90L).translationY(0.0F).setListener((Animator.AnimatorListener)new m(this)).start();
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((com.tencent.mm.plugin.finder.storage.d.dUk() <= 0) || (!eiz())) {
        break;
      }
      localObject = this.AVK;
      if (localObject == null) {
        p.bGy("switchSceneTip");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(168288);
      return;
      label191:
      if ((this.AVY == 2) || (this.AVY == 0)) {
        animate().setDuration(180L).translationY(this.AVS).setListener((Animator.AnimatorListener)new n(this)).start();
      }
    }
    Object localObject = this.AVK;
    if (localObject == null) {
      p.bGy("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(168288);
  }
  
  public final String aGw(String paramString)
  {
    AppMethodBeat.i(269229);
    Object localObject = com.tencent.mm.plugin.finder.convert.d.xgJ;
    localObject = getContext();
    p.j(localObject, "context");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    int i = com.tencent.mm.plugin.finder.convert.d.ae((Context)localObject, com.tencent.mm.plugin.finder.storage.d.dTn());
    localObject = com.tencent.mm.plugin.finder.convert.d.xgJ;
    localObject = getContext();
    p.j(localObject, "context");
    locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    int j = com.tencent.mm.plugin.finder.convert.d.ae((Context)localObject, com.tencent.mm.plugin.finder.storage.d.dTn() + 1);
    localObject = com.tencent.mm.plugin.finder.convert.d.xgJ;
    localObject = this.AVN;
    if (localObject == null) {
      p.bGy("editText");
    }
    localObject = ((MMEditText)localObject).getPaint();
    p.j(localObject, "editText.paint");
    paramString = com.tencent.mm.plugin.finder.convert.d.a((TextPaint)localObject, paramString, i, j);
    AppMethodBeat.o(269229);
    return paramString;
  }
  
  public final void dd(boolean paramBoolean)
  {
    Context localContext = null;
    Object localObject = null;
    AppMethodBeat.i(168292);
    if (this.AVT)
    {
      AppMethodBeat.o(168292);
      return;
    }
    if ((this.zyt) && (paramBoolean))
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
  
  public final void e(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(178487);
    p.k(paramString1, "fromName");
    p.k(paramString2, "toName");
    f(this.AVZ, " " + getResources().getString(b.j.comment_other_hint2, new Object[] { paramString2 }), paramObject);
    AppMethodBeat.o(178487);
  }
  
  public final void eix()
  {
    AppMethodBeat.i(178484);
    Object localObject = this.AVK;
    if (localObject == null) {
      p.bGy("switchSceneTip");
    }
    ((View)localObject).setVisibility(8);
    eiy();
    localObject = findViewById(b.f.comment_switch_scene_click_layout);
    if (eiz())
    {
      ((View)localObject).findViewById(b.f.comment_scene_btn).setVisibility(0);
      ((View)localObject).setOnClickListener((View.OnClickListener)new q(this));
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dUk() > 0)
      {
        localObject = this.AVK;
        if (localObject == null) {
          p.bGy("switchSceneTip");
        }
        ((View)localObject).setVisibility(0);
      }
      localObject = this.AVQ;
      if (localObject == null) {
        p.bGy("targetAvatar");
      }
      ((ImageView)localObject).setVisibility(8);
      localObject = this.AVN;
      if (localObject == null) {
        p.bGy("editText");
      }
      Context localContext = ((MMEditText)localObject).getContext();
      p.j(localContext, "this.context");
      int i = (int)localContext.getResources().getDimension(b.d.Edge_A);
      localContext = ((MMEditText)localObject).getContext();
      p.j(localContext, "this.context");
      ((MMEditText)localObject).setPadding(i, 0, (int)localContext.getResources().getDimension(b.d.Edge_A), 0);
      AppMethodBeat.o(178484);
      return;
      ((View)localObject).setOnClickListener((View.OnClickListener)FinderCommentFooter.r.AWk);
      localObject = ((View)localObject).findViewById(b.f.comment_scene_btn);
      p.j(localObject, "switchClickLayout.findVi…>(R.id.comment_scene_btn)");
      ((View)localObject).setVisibility(8);
    }
  }
  
  public final void eiy()
  {
    AppMethodBeat.i(178485);
    Object localObject1;
    if (this.scene == 2)
    {
      localObject1 = this.AVI;
      if (localObject1 == null) {
        p.bGy("switchSceneAvatar");
      }
      com.tencent.mm.ui.h.a.a.c((ImageView)localObject1, z.bcZ());
      localObject1 = this.AVL;
      if (localObject1 == null) {
        p.bGy("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(b.j.finder_switch_scene_float_tips3);
    }
    for (;;)
    {
      localObject1 = this.AVJ;
      if (localObject1 == null) {
        p.bGy("switchSceneName");
      }
      Object localObject2 = getContext();
      Object localObject3 = aj.AGc;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)aj.QR(this.scene)));
      localObject1 = aj.AGc;
      aGv(aj.QR(this.scene));
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dUk() <= 0)
      {
        localObject1 = this.AVK;
        if (localObject1 == null) {
          p.bGy("switchSceneTip");
        }
        if (((View)localObject1).getVisibility() == 0)
        {
          localObject1 = this.AVK;
          if (localObject1 == null) {
            p.bGy("switchSceneTip");
          }
          ((View)localObject1).setVisibility(8);
        }
      }
      AppMethodBeat.o(178485);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject1 = d.a.aAK(z.bdh());
      if (localObject1 != null)
      {
        localObject2 = ((i)localObject1).Mm();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject2 = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
      localObject3 = this.AVI;
      if (localObject3 == null) {
        p.bGy("switchSceneAvatar");
      }
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject1 = this.AVL;
      if (localObject1 == null) {
        p.bGy("switchSceneTipTv");
      }
      ((TextView)localObject1).setText(b.j.finder_switch_scene_float_tips3);
    }
  }
  
  public final void f(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(269228);
    if (paramString1 == null) {}
    for (String str = "";; str = paramString1)
    {
      this.AVZ = str;
      this.AWa = paramString2;
      this.AWb = paramObject;
      paramString1 = p.I(paramString1, paramString2);
      paramString2 = this.AVN;
      if (paramString2 == null) {
        p.bGy("editText");
      }
      paramString2.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), (CharSequence)paramString1));
      paramString1 = this.AVN;
      if (paramString1 == null) {
        p.bGy("editText");
      }
      paramString1.setTag(paramObject);
      paramString1 = this.AVN;
      if (paramString1 == null) {
        p.bGy("editText");
      }
      if (!paramString1.hasFocus())
      {
        paramString1 = this.AVN;
        if (paramString1 == null) {
          p.bGy("editText");
        }
        paramString1.requestFocus();
      }
      AppMethodBeat.o(269228);
      return;
    }
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(168293);
    ImageView localImageView = this.AVQ;
    if (localImageView == null) {
      p.bGy("targetAvatar");
    }
    AppMethodBeat.o(168293);
    return localImageView;
  }
  
  public final kotlin.g.a.a<x> getBackClickListener()
  {
    return this.AVV;
  }
  
  public final boolean getBanSwitchScene()
  {
    return this.AVX;
  }
  
  public final View getCommentEditTextLayout()
  {
    AppMethodBeat.i(168283);
    View localView = this.AVP;
    if (localView == null) {
      p.bGy("commentEditTextLayout");
    }
    AppMethodBeat.o(168283);
    return localView;
  }
  
  public final int getCommentTextLimit()
  {
    return this.AVR;
  }
  
  public final MMEditText getEditText()
  {
    AppMethodBeat.i(168279);
    MMEditText localMMEditText = this.AVN;
    if (localMMEditText == null) {
      p.bGy("editText");
    }
    AppMethodBeat.o(168279);
    return localMMEditText;
  }
  
  public final int getFooterMode()
  {
    return this.AVY;
  }
  
  public final String getLastActionStr()
  {
    return this.AWa;
  }
  
  public final String getLastFromName()
  {
    return this.AVZ;
  }
  
  public final Object getLastTag()
  {
    return this.AWb;
  }
  
  public final b getModeChangeCallback()
  {
    return this.AVU;
  }
  
  public final View getReplyBtn()
  {
    AppMethodBeat.i(168281);
    View localView = this.AVO;
    if (localView == null) {
      p.bGy("replyBtn");
    }
    AppMethodBeat.o(168281);
    return localView;
  }
  
  public final int getReplyBtnWidth()
  {
    return this.kFq;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final boolean getSendBtnEnabled()
  {
    return this.kFr;
  }
  
  public final ImageView getSmileyBtn()
  {
    AppMethodBeat.i(168277);
    ImageView localImageView = this.AVM;
    if (localImageView == null) {
      p.bGy("smileyBtn");
    }
    AppMethodBeat.o(168277);
    return localImageView;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168275);
    SmileyPanel localSmileyPanel = this.kFp;
    if (localSmileyPanel == null) {
      p.bGy("smileyPanel");
    }
    AppMethodBeat.o(168275);
    return localSmileyPanel;
  }
  
  public final ImageView getSwitchSceneAvatar()
  {
    AppMethodBeat.i(178476);
    ImageView localImageView = this.AVI;
    if (localImageView == null) {
      p.bGy("switchSceneAvatar");
    }
    AppMethodBeat.o(178476);
    return localImageView;
  }
  
  public final kotlin.g.a.a<x> getSwitchSceneListener()
  {
    return this.AVW;
  }
  
  public final TextView getSwitchSceneName()
  {
    AppMethodBeat.i(178478);
    TextView localTextView = this.AVJ;
    if (localTextView == null) {
      p.bGy("switchSceneName");
    }
    AppMethodBeat.o(178478);
    return localTextView;
  }
  
  public final View getSwitchSceneTip()
  {
    AppMethodBeat.i(178480);
    View localView = this.AVK;
    if (localView == null) {
      p.bGy("switchSceneTip");
    }
    AppMethodBeat.o(178480);
    return localView;
  }
  
  public final TextView getSwitchSceneTipTv()
  {
    AppMethodBeat.i(178482);
    TextView localTextView = this.AVL;
    if (localTextView == null) {
      p.bGy("switchSceneTipTv");
    }
    AppMethodBeat.o(178482);
    return localTextView;
  }
  
  public final ImageView getTargetAvatar()
  {
    AppMethodBeat.i(168285);
    ImageView localImageView = this.AVQ;
    if (localImageView == null) {
      p.bGy("targetAvatar");
    }
    AppMethodBeat.o(168285);
    return localImageView;
  }
  
  public final void hy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178486);
    p.k(paramString1, "fromName");
    p.k(paramString2, "toName");
    f(this.AVZ, " " + getResources().getString(b.j.comment_ower_hint3), null);
    AppMethodBeat.o(178486);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168289);
    super.onFinishInflate();
    Object localObject = findViewById(b.f.comment_scene_avatar);
    p.j(localObject, "findViewById(R.id.comment_scene_avatar)");
    this.AVI = ((ImageView)localObject);
    localObject = findViewById(b.f.comment_scene_name);
    p.j(localObject, "findViewById(R.id.comment_scene_name)");
    this.AVJ = ((TextView)localObject);
    localObject = findViewById(b.f.comment_switch_scene_tip_layout);
    p.j(localObject, "findViewById(R.id.comment_switch_scene_tip_layout)");
    this.AVK = ((View)localObject);
    localObject = findViewById(b.f.comment_switch_scene_tip_tv);
    p.j(localObject, "findViewById(R.id.comment_switch_scene_tip_tv)");
    this.AVL = ((TextView)localObject);
    localObject = findViewById(b.f.smiley_btn);
    p.j(localObject, "findViewById(R.id.smiley_btn)");
    this.AVM = ((ImageView)localObject);
    localObject = findViewById(b.f.comment_et);
    p.j(localObject, "findViewById(R.id.comment_et)");
    this.AVN = ((MMEditText)localObject);
    localObject = findViewById(b.f.comment_target_avatar);
    p.j(localObject, "findViewById(R.id.comment_target_avatar)");
    this.AVQ = ((ImageView)localObject);
    localObject = findViewById(b.f.reply_btn);
    p.j(localObject, "findViewById(R.id.reply_btn)");
    this.AVO = ((View)localObject);
    localObject = findViewById(b.f.comment_et_layout);
    p.j(localObject, "findViewById(R.id.comment_et_layout)");
    this.AVP = ((View)localObject);
    if (ar.isDarkMode())
    {
      localObject = this.AVK;
      if (localObject == null) {
        p.bGy("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(b.e.finder_switch_scene_tip_dark_bg2);
    }
    for (;;)
    {
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
      ((SmileyPanel)localObject).setOnTextOperationListener((ChatFooterPanel.a)new FinderCommentFooter.h(this));
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
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new i(this));
      setTranslationY(this.AVS);
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      this.AVR = (((Number)com.tencent.mm.plugin.finder.storage.d.dTT().aSr()).intValue() * 2);
      localObject = this.AVO;
      if (localObject == null) {
        p.bGy("replyBtn");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.AVN;
      if (localObject == null) {
        p.bGy("editText");
      }
      ((MMEditText)localObject).addTextChangedListener((TextWatcher)new j(this));
      localObject = this.AVN;
      if (localObject == null) {
        p.bGy("editText");
      }
      c.i((EditText)localObject).mM(0, this.AVR).a(null);
      eix();
      AppMethodBeat.o(168289);
      return;
      localObject = this.AVK;
      if (localObject == null) {
        p.bGy("switchSceneTip");
      }
      ((View)localObject).setBackgroundResource(b.e.finder_switch_scene_tip_bg2);
    }
  }
  
  public final void rq(final boolean paramBoolean)
  {
    AppMethodBeat.i(168290);
    if (this.AVT)
    {
      AppMethodBeat.o(168290);
      return;
    }
    Object localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setImageResource(b.e.chatting_setmode_biaoqing_btn);
    localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ImageView localImageView = this.AVM;
    if (localImageView == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setContentDescription((CharSequence)localImageView.getContext().getString(b.j.chat_footer_smiley_btn));
    localObject = this.AVM;
    if (localObject == null) {
      p.bGy("smileyBtn");
    }
    ((ImageView)localObject).setTag(Boolean.FALSE);
    if (paramBoolean)
    {
      animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(220L).translationY(this.AVS).setListener((Animator.AnimatorListener)new k(this, paramBoolean)).start();
      AppMethodBeat.o(168290);
      return;
    }
    localObject = this.kFp;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((SmileyPanel)localObject).animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new l(this)).start();
    AppMethodBeat.o(168290);
  }
  
  public final void setBackClickListener(kotlin.g.a.a<x> parama)
  {
    this.AVV = parama;
  }
  
  public final void setBanSwitchScene(boolean paramBoolean)
  {
    this.AVX = paramBoolean;
  }
  
  public final void setCommentEditTextLayout(View paramView)
  {
    AppMethodBeat.i(168284);
    p.k(paramView, "<set-?>");
    this.AVP = paramView;
    AppMethodBeat.o(168284);
  }
  
  public final void setCommentTextLimit(int paramInt)
  {
    this.AVR = paramInt;
  }
  
  public final void setEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(168280);
    p.k(paramMMEditText, "<set-?>");
    this.AVN = paramMMEditText;
    AppMethodBeat.o(168280);
  }
  
  public final void setFooterMode(int paramInt)
  {
    AppMethodBeat.i(168287);
    b localb = this.AVU;
    if (localb != null) {
      localb.gA(this.AVY, paramInt);
    }
    this.AVY = paramInt;
    AppMethodBeat.o(168287);
  }
  
  public final void setFrozen(boolean paramBoolean)
  {
    this.AVT = paramBoolean;
  }
  
  public final void setLastActionStr(String paramString)
  {
    AppMethodBeat.i(269227);
    p.k(paramString, "<set-?>");
    this.AWa = paramString;
    AppMethodBeat.o(269227);
  }
  
  public final void setLastFromName(String paramString)
  {
    AppMethodBeat.i(269226);
    p.k(paramString, "<set-?>");
    this.AVZ = paramString;
    AppMethodBeat.o(269226);
  }
  
  public final void setLastTag(Object paramObject)
  {
    this.AWb = paramObject;
  }
  
  public final void setModeChangeCallback(b paramb)
  {
    this.AVU = paramb;
  }
  
  public final void setReplyBtn(View paramView)
  {
    AppMethodBeat.i(168282);
    p.k(paramView, "<set-?>");
    this.AVO = paramView;
    AppMethodBeat.o(168282);
  }
  
  public final void setReplyBtnWidth(int paramInt)
  {
    this.kFq = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(269219);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      Log.printInfoStack("Finder.FinderCommentFooter", "set footer scene:".concat(String.valueOf(paramInt)), new Object[0]);
    }
    this.scene = paramInt;
    AppMethodBeat.o(269219);
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.zxL = paramBoolean;
  }
  
  public final void setSendBtnEnabled(boolean paramBoolean)
  {
    this.kFr = paramBoolean;
  }
  
  public final void setSmileyBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(168278);
    p.k(paramImageView, "<set-?>");
    this.AVM = paramImageView;
    AppMethodBeat.o(168278);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168276);
    p.k(paramSmileyPanel, "<set-?>");
    this.kFp = paramSmileyPanel;
    AppMethodBeat.o(168276);
  }
  
  public final void setSwitchSceneAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(178477);
    p.k(paramImageView, "<set-?>");
    this.AVI = paramImageView;
    AppMethodBeat.o(178477);
  }
  
  public final void setSwitchSceneListener(kotlin.g.a.a<x> parama)
  {
    this.AVW = parama;
  }
  
  public final void setSwitchSceneName(TextView paramTextView)
  {
    AppMethodBeat.i(178479);
    p.k(paramTextView, "<set-?>");
    this.AVJ = paramTextView;
    AppMethodBeat.o(178479);
  }
  
  public final void setSwitchSceneTip(View paramView)
  {
    AppMethodBeat.i(178481);
    p.k(paramView, "<set-?>");
    this.AVK = paramView;
    AppMethodBeat.o(178481);
  }
  
  public final void setSwitchSceneTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(178483);
    p.k(paramTextView, "<set-?>");
    this.AVL = paramTextView;
    AppMethodBeat.o(178483);
  }
  
  public final void setTargetAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(168286);
    p.k(paramImageView, "<set-?>");
    this.AVQ = paramImageView;
    AppMethodBeat.o(168286);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$Companion;", "", "()V", "MODE_DEFAULT", "", "MODE_KEYBOARD", "MODE_SMILEY", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "", "onModeChange", "", "from", "", "to", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void gA(int paramInt1, int paramInt2);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(285967);
      if (paramValueAnimator != null) {}
      for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(285967);
        throw paramValueAnimator;
      }
      float f = ((Integer)paramValueAnimator).intValue();
      paramValueAnimator = this.AWd.getReplyBtn().getLayoutParams();
      paramValueAnimator.width = kotlin.h.a.dm(f);
      this.AWd.getReplyBtn().setLayoutParams(paramValueAnimator);
      this.AWd.getReplyBtn().setAlpha(f / this.AWd.getReplyBtnWidth());
      AppMethodBeat.o(285967);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$checkShowReplyBtn$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(279105);
      paramAnimator = this.AWd.getReplyBtn().getLayoutParams();
      paramAnimator.width = this.AWd.getReplyBtnWidth();
      this.AWd.getReplyBtn().setLayoutParams(paramAnimator);
      this.AWd.getReplyBtn().setAlpha(1.0F);
      AppMethodBeat.o(279105);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(279104);
      paramAnimator = this.AWd.getReplyBtn().getLayoutParams();
      paramAnimator.width = this.AWd.getReplyBtnWidth();
      this.AWd.getReplyBtn().setLayoutParams(paramAnimator);
      this.AWd.getReplyBtn().setAlpha(1.0F);
      AppMethodBeat.o(279104);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(279106);
      this.AWd.getReplyBtn().setVisibility(0);
      AppMethodBeat.o(279106);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(283864);
      if (paramValueAnimator != null) {}
      for (paramValueAnimator = paramValueAnimator.getAnimatedValue(); paramValueAnimator == null; paramValueAnimator = null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(283864);
        throw paramValueAnimator;
      }
      float f = ((Integer)paramValueAnimator).intValue();
      paramValueAnimator = this.AWd.getReplyBtn().getLayoutParams();
      paramValueAnimator.width = kotlin.h.a.dm(f);
      this.AWd.getReplyBtn().setLayoutParams(paramValueAnimator);
      this.AWd.getReplyBtn().setAlpha(f / this.AWd.getReplyBtnWidth());
      AppMethodBeat.o(283864);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$checkShowReplyBtn$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(277456);
      this.AWd.getReplyBtn().setVisibility(8);
      AppMethodBeat.o(277456);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(277455);
      this.AWd.getReplyBtn().setVisibility(8);
      AppMethodBeat.o(277455);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(277457);
      this.AWd.getReplyBtn().setVisibility(0);
      AppMethodBeat.o(277457);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(168258);
        throw paramView;
      }
      paramView = ((ImageView)paramView).getTag();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(168258);
        throw paramView;
      }
      if (!((Boolean)paramView).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        FinderCommentFooter.a(this.AWd, bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168258);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class j
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(284932);
      this.AWd.getEditText().postDelayed((Runnable)new a(this), 160L);
      AppMethodBeat.o(284932);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderCommentFooter.j paramj) {}
      
      public final void run()
      {
        AppMethodBeat.i(267742);
        FinderCommentFooter.a(this.AWg.AWd, this.AWg.AWd.getEditText().getText());
        AppMethodBeat.o(267742);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class k
    implements Animator.AnimatorListener
  {
    k(boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168269);
      this.AWd.getSmileyPanel().setVisibility(4);
      this.AWd.getSmileyBtn().setImageResource(b.e.chatting_setmode_biaoqing_btn);
      this.AWd.getSmileyBtn().setContentDescription((CharSequence)this.AWd.getSmileyBtn().getContext().getString(b.j.chat_footer_smiley_btn));
      if (paramBoolean) {
        this.AWd.setFooterMode(0);
      }
      AppMethodBeat.o(168269);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class l
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168270);
      this.AWd.getSmileyPanel().setAlpha(1.0F);
      this.AWd.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168270);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class m
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(273377);
      this.AWd.setFooterMode(2);
      AppMethodBeat.o(273377);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class n
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(288176);
      this.AWd.setFooterMode(0);
      AppMethodBeat.o(288176);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class o
    implements View.OnLayoutChangeListener
  {
    o(kotlin.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(168273);
      this.AWd.getSmileyPanel().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      this.AWi.invoke();
      AppMethodBeat.o(168273);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(FinderCommentFooter paramFinderCommentFooter)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291248);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dUk() > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        com.tencent.mm.plugin.finder.storage.d.Qc(0);
        this.AWd.getSwitchSceneTip().setVisibility(8);
        paramView = new e(this.AWd.getContext());
        paramView.RB(b.g.finder_switch_scene_bottom_sheet_layout);
        ar.a((Paint)((TextView)paramView.oFW.findViewById(b.f.finder_mm_bottom_sheet_title)).getPaint(), 0.8F);
        localObject = paramView.oFW.findViewById(b.f.finder_mm_bottom_sheet_item1);
        FinderCommentFooter localFinderCommentFooter = this.AWd;
        p.j(localObject, "item1");
        FinderCommentFooter.a(localFinderCommentFooter, (View)localObject, 1, (kotlin.g.a.b)new a(paramView, this));
        localObject = paramView.oFW.findViewById(b.f.finder_mm_bottom_sheet_item2);
        localFinderCommentFooter = this.AWd;
        p.j(localObject, "item2");
        FinderCommentFooter.a(localFinderCommentFooter, (View)localObject, 2, (kotlin.g.a.b)new b(paramView, this));
        paramView.eik();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291248);
        return;
        FinderCommentFooter.a(this.AWd);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.b<Integer, x>
    {
      a(e parame, FinderCommentFooter.q paramq)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "selectScene", "", "invoke", "com/tencent/mm/plugin/finder/view/FinderCommentFooter$refreshSwitchSceneView$2$1$2"})
    static final class b
      extends q
      implements kotlin.g.a.b<Integer, x>
    {
      b(e parame, FinderCommentFooter.q paramq)
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