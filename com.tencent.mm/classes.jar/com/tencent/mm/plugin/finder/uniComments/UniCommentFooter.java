package com.tencent.mm.plugin.finder.uniComments;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ae;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderCommentEditText;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.e;
import kotlin.n.i;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "atWxContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/uniComments/MentionContact;", "Lkotlin/collections/ArrayList;", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "banSwitchScene", "", "getBanSwitchScene", "()Z", "setBanSwitchScene", "(Z)V", "commentEditTextContainer", "Landroid/view/ViewGroup;", "getCommentEditTextContainer", "()Landroid/view/ViewGroup;", "setCommentEditTextContainer", "(Landroid/view/ViewGroup;)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;", "getEditText", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;", "setEditText", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "setFrozen", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "lastActionStr", "", "getLastActionStr", "()Ljava/lang/String;", "setLastActionStr", "(Ljava/lang/String;)V", "lastFromName", "getLastFromName", "setLastFromName", "lastTag", "", "getLastTag", "()Ljava/lang/Object;", "setLastTag", "(Ljava/lang/Object;)V", "mentionBtn", "Landroid/widget/ImageView;", "getMentionBtn", "()Landroid/widget/ImageView;", "setMentionBtn", "(Landroid/widget/ImageView;)V", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter$IModeChangeCallback;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSmileyBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setSmileyBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "fromName", "actionStr", "tag", "needFocus", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "showRemark", "changeReplyToCommenter", "toName", "changeReplyToPoster", "changeSelfName", "selfName", "checkAtWxContactValid", "checkShowReplyBtn", "s", "Landroid/text/Editable;", "ellipseName", "name", "getAvatarView", "getMentionListWhenReply", "", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "isCommentAtEnable", "onAtSomeone", "displayName", "username", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "setSmileyIcon", "showVKB", "isShow", "updateFeedIdToEditText", "feedId", "", "Companion", "IModeChangeCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UniCommentFooter
  extends LinearLayout
  implements com.tencent.mm.ui.tools.h
{
  public static final UniCommentFooter.a FZc;
  private static final at.a FZy;
  private ArrayList<a> Ddb;
  private boolean EAO;
  private boolean EBm;
  private kotlin.g.a.a<ah> EpU;
  public ImageView FZd;
  public TextView FZe;
  public View FZf;
  public TextView FZg;
  public WeImageView FZh;
  public ImageView FZi;
  public FinderCommentEditText FZj;
  public View FZk;
  public View FZl;
  private ViewGroup FZm;
  public ImageView FZn;
  private int FZo;
  private float FZp;
  private boolean FZq;
  private b FZr;
  private kotlin.g.a.a<ah> FZs;
  private boolean FZt;
  int FZu;
  String FZv;
  private String FZw;
  private Object FZx;
  public SmileyPanel niv;
  private int niw;
  private boolean nix;
  private int scene;
  
  static
  {
    AppMethodBeat.i(342075);
    FZc = new UniCommentFooter.a((byte)0);
    FZy = at.a.adhJ;
    AppMethodBeat.o(342075);
  }
  
  public UniCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(341736);
    this.FZp = KeyBoardUtil.getKeyBordHeightPx(getContext());
    this.niw = bd.bs(getContext(), e.c.Edge_7A);
    this.scene = 2;
    this.Ddb = new ArrayList();
    this.FZv = "";
    this.FZw = "";
    AppMethodBeat.o(341736);
  }
  
  private final void a(View paramView, int paramInt, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(341778);
    ImageView localImageView = (ImageView)paramView.findViewById(e.e.icon);
    TextView localTextView = (TextView)paramView.findViewById(e.e.title);
    Object localObject1 = (TextView)paramView.findViewById(e.e.desc);
    Object localObject2 = (ImageView)paramView.findViewById(e.e.right_icon);
    if (this.scene == paramInt)
    {
      ((ImageView)localObject2).setVisibility(0);
      localObject2 = getContext();
      Object localObject3 = av.GiL;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)av.Ud(paramInt)));
      if (paramInt != 1) {
        break label238;
      }
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject1 = d.a.auT(z.bAW());
      if (localObject1 != null) {
        break label214;
      }
      localObject1 = "";
      label127:
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
      localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      s.s(localImageView, "avatarIv");
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localTextView.setText(e.h.finder_switch_scene_tip_1);
    }
    for (;;)
    {
      paramView.setOnClickListener(new UniCommentFooter..ExternalSyntheticLambda5(paramb, paramInt));
      AppMethodBeat.o(341778);
      return;
      ((ImageView)localObject2).setVisibility(8);
      break;
      label214:
      localObject2 = ((m)localObject1).amx();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label127;
      }
      localObject1 = "";
      break label127;
      label238:
      com.tencent.mm.ui.i.a.a.g(localImageView, z.bAM());
      localTextView.setText(e.h.finder_switch_scene_tip_2);
    }
  }
  
  private static final void a(UniCommentFooter paramUniCommentFooter, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(341942);
    s.u(paramUniCommentFooter, "this$0");
    if (paramValueAnimator == null) {}
    for (paramValueAnimator = null; paramValueAnimator == null; paramValueAnimator = paramValueAnimator.getAnimatedValue())
    {
      paramUniCommentFooter = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(341942);
      throw paramUniCommentFooter;
    }
    float f = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = paramUniCommentFooter.getReplyBtn().getLayoutParams();
    paramValueAnimator.width = kotlin.h.a.eH(f);
    paramUniCommentFooter.getReplyBtn().setLayoutParams(paramValueAnimator);
    paramUniCommentFooter.getReplyBtn().setAlpha(f / paramUniCommentFooter.getReplyBtnWidth());
    AppMethodBeat.o(341942);
  }
  
  private static final void a(UniCommentFooter paramUniCommentFooter, final View paramView)
  {
    AppMethodBeat.i(341901);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramUniCommentFooter);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramUniCommentFooter, "this$0");
    if (paramView == null)
    {
      paramUniCommentFooter = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(341901);
      throw paramUniCommentFooter;
    }
    paramView = ((ImageView)paramView).getTag();
    if (paramView == null)
    {
      paramUniCommentFooter = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(341901);
      throw paramUniCommentFooter;
    }
    boolean bool;
    if (!((Boolean)paramView).booleanValue()) {
      bool = true;
    }
    while (!paramUniCommentFooter.FZq)
    {
      if (bool) {
        break label242;
      }
      paramUniCommentFooter.setFooterMode(2);
      paramUniCommentFooter.ur(false);
      paramUniCommentFooter.getEditText().setShowSoftInputOnFocus(true);
      paramUniCommentFooter.getEditText().requestFocus();
      paramView = paramUniCommentFooter.getContext();
      if (paramView == null)
      {
        paramUniCommentFooter = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(341901);
        throw paramUniCommentFooter;
        bool = false;
      }
      else
      {
        ((MMFragmentActivity)paramView).showVKB();
      }
    }
    for (;;)
    {
      paramUniCommentFooter.setSmileyIcon(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341901);
      return;
      label242:
      int i;
      if (paramUniCommentFooter.FZu != 2)
      {
        i = 1;
        if (!paramUniCommentFooter.FZq)
        {
          paramUniCommentFooter.getSmileyPanel().setVisibility(0);
          paramUniCommentFooter.setSmileyIcon(false);
          paramUniCommentFooter.getSmileyBtn().setTag(Boolean.TRUE);
          if (i == 0) {
            break label378;
          }
          paramView = (kotlin.g.a.a)new UniCommentFooter.m(paramUniCommentFooter);
          if (paramUniCommentFooter.getSmileyPanel().getHeight() > 0.0F) {
            break label368;
          }
          paramUniCommentFooter.getSmileyPanel().addOnLayoutChangeListener((View.OnLayoutChangeListener)new l(paramUniCommentFooter, paramView));
        }
      }
      for (;;)
      {
        paramUniCommentFooter.setFooterMode(1);
        paramView = paramUniCommentFooter.getContext();
        if (paramView != null) {
          break label413;
        }
        paramUniCommentFooter = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(341901);
        throw paramUniCommentFooter;
        i = 0;
        break;
        label368:
        paramView.invoke();
        continue;
        label378:
        paramUniCommentFooter.getSmileyPanel().setAlpha(0.0F);
        paramUniCommentFooter.getSmileyPanel().animate().alpha(1.0F).setDuration(220L).setListener(null).start();
      }
      label413:
      ((MMFragmentActivity)paramView).hideVKB();
    }
  }
  
  private final void a(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(341833);
    if (paramString1 == null) {}
    for (String str = "";; str = paramString1)
    {
      this.FZv = str;
      this.FZw = paramString2;
      this.FZx = paramObject;
      paramString1 = s.X(paramString1, paramString2);
      getEditText().setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)paramString1));
      getEditText().setTag(paramObject);
      paramString1 = this.FZm;
      if (paramString1 != null) {
        paramString1.setTag(e.e.finder_accessibility_edittext_hint_tag, getEditText().getHint());
      }
      if ((!getEditText().hasFocus()) && (paramBoolean)) {
        getEditText().requestFocus();
      }
      AppMethodBeat.o(341833);
      return;
    }
  }
  
  private static final boolean a(UniCommentFooter paramUniCommentFooter, View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(341931);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramUniCommentFooter);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", localObject, localb.aYj());
    s.u(paramUniCommentFooter, "this$0");
    int j;
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      j = paramUniCommentFooter.getEditText().getSelectionEnd();
      paramKeyEvent = paramUniCommentFooter.getEditText().getText();
      if (paramKeyEvent == null)
      {
        paramView = null;
        if (!s.p(String.valueOf(paramView), " ")) {
          break label266;
        }
        paramView = paramKeyEvent.subSequence(0, j);
        paramInt = paramView.length() - 1;
        if (paramInt < 0) {
          break label261;
        }
      }
    }
    for (;;)
    {
      int i = paramInt - 1;
      if (paramView.charAt(paramInt) == '@') {}
      for (;;)
      {
        paramUniCommentFooter.getEditText().setText((CharSequence)paramUniCommentFooter.getEditText().getText().replace(paramInt, j, (CharSequence)""));
        paramUniCommentFooter.getEditText().setSelection(paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(341931);
        return true;
        paramView = paramKeyEvent.subSequence(kotlin.k.k.qu(j - 1, 0), j);
        break;
        if (i >= 0) {
          break label297;
        }
        label261:
        paramInt = 0;
      }
      label266:
      com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(341931);
      return false;
      label297:
      paramInt = i;
    }
  }
  
  private static final void b(UniCommentFooter paramUniCommentFooter)
  {
    AppMethodBeat.i(342014);
    s.u(paramUniCommentFooter, "this$0");
    paramUniCommentFooter.getEditText().requestFocus();
    if ((paramUniCommentFooter.getContext() instanceof MMActivity))
    {
      paramUniCommentFooter = paramUniCommentFooter.getContext();
      if ((paramUniCommentFooter instanceof MMActivity)) {}
      for (paramUniCommentFooter = (MMActivity)paramUniCommentFooter; paramUniCommentFooter != null; paramUniCommentFooter = null)
      {
        paramUniCommentFooter.showVKB();
        AppMethodBeat.o(342014);
        return;
      }
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramUniCommentFooter.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput((View)paramUniCommentFooter.getEditText(), 0);
    }
    AppMethodBeat.o(342014);
  }
  
  private static final void b(UniCommentFooter paramUniCommentFooter, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(341952);
    s.u(paramUniCommentFooter, "this$0");
    if (paramValueAnimator == null) {}
    for (paramValueAnimator = null; paramValueAnimator == null; paramValueAnimator = paramValueAnimator.getAnimatedValue())
    {
      paramUniCommentFooter = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(341952);
      throw paramUniCommentFooter;
    }
    float f = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = paramUniCommentFooter.getReplyBtn().getLayoutParams();
    paramValueAnimator.width = kotlin.h.a.eH(f);
    paramUniCommentFooter.getReplyBtn().setLayoutParams(paramValueAnimator);
    paramUniCommentFooter.getReplyBtn().setAlpha(f / paramUniCommentFooter.getReplyBtnWidth());
    AppMethodBeat.o(341952);
  }
  
  private static final void b(UniCommentFooter paramUniCommentFooter, View paramView)
  {
    AppMethodBeat.i(341919);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramUniCommentFooter);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramUniCommentFooter, "this$0");
    paramView = paramUniCommentFooter.getContext();
    s.s(paramView, "context");
    new com.tencent.mm.plugin.finder.ui.at.d(paramView, Boolean.FALSE, FZy, (com.tencent.mm.plugin.finder.ui.at.a)new f(paramUniCommentFooter)).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341919);
  }
  
  private void bT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(341805);
    s.u(paramString, "selfName");
    a(aBi(paramString), this.FZw, this.FZx, paramBoolean);
    AppMethodBeat.o(341805);
  }
  
  private static final void c(UniCommentFooter paramUniCommentFooter, final View paramView)
  {
    AppMethodBeat.i(341966);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramUniCommentFooter);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramUniCommentFooter, "this$0");
    paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eSD() > 0)
    {
      paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.Tm(0);
      paramUniCommentFooter.getSwitchSceneTip().setVisibility(8);
      paramView = new com.tencent.mm.plugin.finder.view.d(paramUniCommentFooter.getContext());
      paramView.UD(e.f.uni_switch_scene_bottom_sheet_layout);
      aw.a((Paint)((TextView)paramView.rootView.findViewById(e.e.finder_mm_bottom_sheet_title)).getPaint(), 0.8F);
      localObject = paramView.rootView.findViewById(e.e.finder_mm_bottom_sheet_item1);
      s.s(localObject, "item1");
      paramUniCommentFooter.a((View)localObject, 1, (kotlin.g.a.b)new n(paramUniCommentFooter, paramView));
      localObject = paramView.rootView.findViewById(e.e.finder_mm_bottom_sheet_item2);
      s.s(localObject, "item2");
      paramUniCommentFooter.a((View)localObject, 2, (kotlin.g.a.b)new o(paramUniCommentFooter, paramView));
      paramView.dDn();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341966);
      return;
      paramUniCommentFooter.fdj();
    }
  }
  
  private static final void c(kotlin.g.a.b paramb, int paramInt, View paramView)
  {
    AppMethodBeat.i(341991);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$onItemSelect");
    paramb.invoke(Integer.valueOf(paramInt));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341991);
  }
  
  private final void fdj()
  {
    AppMethodBeat.i(341763);
    Object localObject = this.FZs;
    if (localObject != null) {
      ((kotlin.g.a.a)localObject).invoke();
    }
    localObject = av.GiL;
    setScene(av.Uf(this.scene));
    uq(true);
    AppMethodBeat.o(341763);
  }
  
  private final boolean fdk()
  {
    AppMethodBeat.i(341816);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.eSA().bmg()).intValue() == 1) && (!this.EAO))
    {
      localObject = av.GiL;
      if ((av.ffR()) && (!this.FZt))
      {
        AppMethodBeat.o(341816);
        return true;
      }
    }
    AppMethodBeat.o(341816);
    return false;
  }
  
  private static boolean fdl()
  {
    AppMethodBeat.i(341863);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXU().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(341863);
      return true;
    }
    AppMethodBeat.o(341863);
    return false;
  }
  
  private final void fdm()
  {
    AppMethodBeat.i(341880);
    Object localObject1 = getEditText().getText();
    if (localObject1 == null)
    {
      localObject1 = "";
      if (((CharSequence)localObject1).length() != 0) {
        break label145;
      }
    }
    Object localObject2;
    label145:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Ddb.clear();
      }
      localObject2 = new ArrayList();
      localObject1 = kotlin.n.k.b(new kotlin.n.k("@.*? "), (CharSequence)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ArrayList)localObject2).add(n.d(n.c(((i)((Iterator)localObject1).next()).getValue(), (CharSequence)"@"), (CharSequence)" "));
      }
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
    Object localObject3 = (Iterable)this.Ddb;
    localObject1 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (((ArrayList)localObject2).contains(((a)localObject4).nickname)) {
        ((Collection)localObject1).add(localObject4);
      }
    }
    this.Ddb = new ArrayList((Collection)localObject1);
    AppMethodBeat.o(341880);
  }
  
  private static final void gM(View paramView)
  {
    AppMethodBeat.i(341978);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/uniComments/UniCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341978);
  }
  
  private static final void gN(View paramView)
  {
    AppMethodBeat.i(342002);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(e.e.toast_text);
      if (paramView != null) {
        paramView.setTextSize(1, 14.0F);
      }
    }
    AppMethodBeat.o(342002);
  }
  
  private final void setSmileyIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(341792);
    if (paramBoolean)
    {
      getSmileyBtn().oR(e.g.icons_outlined_keyboard, e.b.FG_0);
      getSmileyBtn().setContentDescription((CharSequence)getSmileyBtn().getContext().getString(e.h.chat_footer_switch_mode_keybord_btn));
      AppMethodBeat.o(341792);
      return;
    }
    getSmileyBtn().oR(e.g.icons_outlined_emoji, e.b.FG_0);
    getSmileyBtn().setContentDescription((CharSequence)getSmileyBtn().getContext().getString(e.h.chat_footer_smiley_btn));
    AppMethodBeat.o(341792);
  }
  
  final String aBi(String paramString)
  {
    AppMethodBeat.i(342718);
    Object localObject = com.tencent.mm.plugin.finder.convert.d.AHD;
    localObject = getContext();
    s.s(localObject, "context");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = com.tencent.mm.plugin.finder.convert.d.ao((Context)localObject, com.tencent.mm.plugin.finder.storage.d.eRC());
    localObject = com.tencent.mm.plugin.finder.convert.d.AHD;
    localObject = getContext();
    s.s(localObject, "context");
    locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    int j = com.tencent.mm.plugin.finder.convert.d.ao((Context)localObject, com.tencent.mm.plugin.finder.storage.d.eRC() + 1);
    localObject = com.tencent.mm.plugin.finder.convert.d.AHD;
    localObject = getEditText().getPaint();
    s.s(localObject, "editText.paint");
    paramString = com.tencent.mm.plugin.finder.convert.d.a((TextPaint)localObject, paramString, i, j);
    AppMethodBeat.o(342718);
    return paramString;
  }
  
  public final void dP(boolean paramBoolean)
  {
    AppMethodBeat.i(342730);
    if (this.FZq)
    {
      AppMethodBeat.o(342730);
      return;
    }
    if ((this.EBm) && (paramBoolean))
    {
      AppMethodBeat.o(342730);
      return;
    }
    if (paramBoolean)
    {
      localObject = getContext();
      if ((localObject instanceof MMFragmentActivity)) {}
      for (localObject = (MMFragmentActivity)localObject; localObject != null; localObject = null)
      {
        ((MMFragmentActivity)localObject).showVKB();
        AppMethodBeat.o(342730);
        return;
      }
    }
    Object localObject = getContext();
    if ((localObject instanceof MMFragmentActivity)) {}
    for (localObject = (MMFragmentActivity)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((MMFragmentActivity)localObject).hideVKB();
      }
      AppMethodBeat.o(342730);
      return;
    }
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(342739);
    ImageView localImageView = getTargetAvatar();
    AppMethodBeat.o(342739);
    return localImageView;
  }
  
  public final kotlin.g.a.a<ah> getBackClickListener()
  {
    return this.EpU;
  }
  
  public final boolean getBanSwitchScene()
  {
    return this.FZt;
  }
  
  public final ViewGroup getCommentEditTextContainer()
  {
    return this.FZm;
  }
  
  public final View getCommentEditTextLayout()
  {
    AppMethodBeat.i(342326);
    View localView = this.FZl;
    if (localView != null)
    {
      AppMethodBeat.o(342326);
      return localView;
    }
    s.bIx("commentEditTextLayout");
    AppMethodBeat.o(342326);
    return null;
  }
  
  public final int getCommentTextLimit()
  {
    return this.FZo;
  }
  
  public final FinderCommentEditText getEditText()
  {
    AppMethodBeat.i(342290);
    FinderCommentEditText localFinderCommentEditText = this.FZj;
    if (localFinderCommentEditText != null)
    {
      AppMethodBeat.o(342290);
      return localFinderCommentEditText;
    }
    s.bIx("editText");
    AppMethodBeat.o(342290);
    return null;
  }
  
  public final int getFooterMode()
  {
    return this.FZu;
  }
  
  public final String getLastActionStr()
  {
    return this.FZw;
  }
  
  public final String getLastFromName()
  {
    return this.FZv;
  }
  
  public final Object getLastTag()
  {
    return this.FZx;
  }
  
  public final ImageView getMentionBtn()
  {
    AppMethodBeat.i(342273);
    ImageView localImageView = this.FZi;
    if (localImageView != null)
    {
      AppMethodBeat.o(342273);
      return localImageView;
    }
    s.bIx("mentionBtn");
    AppMethodBeat.o(342273);
    return null;
  }
  
  public final List<a> getMentionListWhenReply()
  {
    AppMethodBeat.i(342758);
    if (this.scene == 1)
    {
      this.Ddb.clear();
      localObject1 = (List)ab.aivy;
      AppMethodBeat.o(342758);
      return localObject1;
    }
    Object localObject1 = getEditText().getText();
    if (localObject1 == null)
    {
      localObject1 = "";
      if (((CharSequence)localObject1).length() != 0) {
        break label111;
      }
    }
    label111:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label116;
      }
      this.Ddb.clear();
      localObject1 = (List)this.Ddb;
      AppMethodBeat.o(342758);
      return localObject1;
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
    }
    label116:
    Object localObject2 = kotlin.n.k.b(new kotlin.n.k("@.*? "), (CharSequence)localObject1).iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (i)((Iterator)localObject2).next();
      String str = n.d(n.c(((i)localObject3).getValue(), (CharSequence)"@"), (CharSequence)" ");
      Iterator localIterator = ((Iterable)this.Ddb).iterator();
      label200:
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        a locala = (a)localObject1;
        if ((s.p(locala.nickname, str)) && (!locala.FYw))
        {
          i = 1;
          label247:
          if (i == 0) {
            break label290;
          }
        }
      }
      for (;;)
      {
        localObject1 = (a)localObject1;
        if (localObject1 != null) {
          ((a)localObject1).start = ((i)localObject3).kBn().fIj;
        }
        if (localObject1 == null) {
          break;
        }
        ((a)localObject1).FYw = true;
        break;
        i = 0;
        break label247;
        label290:
        break label200;
        localObject1 = null;
      }
    }
    localObject2 = (Iterable)this.Ddb;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((a)localObject3).FYw) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = new ArrayList((Collection)localObject1);
    localObject2 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a)((Iterator)localObject2).next();
      if (!Util.isNullOrNil(((a)localObject3).username))
      {
        Log.i("MicroMsg.MusicUni.UniCommentFooter", s.X("getMentionListWhenReply at user: ", ((a)localObject3).username));
        com.tencent.mm.plugin.finder.ui.at.k.FWG.a(FZy, ((a)localObject3).username);
      }
    }
    this.Ddb.clear();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(342758);
    return localObject1;
  }
  
  public final b getModeChangeCallback()
  {
    return this.FZr;
  }
  
  public final View getReplyBtn()
  {
    AppMethodBeat.i(342306);
    View localView = this.FZk;
    if (localView != null)
    {
      AppMethodBeat.o(342306);
      return localView;
    }
    s.bIx("replyBtn");
    AppMethodBeat.o(342306);
    return null;
  }
  
  public final int getReplyBtnWidth()
  {
    return this.niw;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final boolean getSendBtnEnabled()
  {
    return this.nix;
  }
  
  public final WeImageView getSmileyBtn()
  {
    AppMethodBeat.i(342257);
    WeImageView localWeImageView = this.FZh;
    if (localWeImageView != null)
    {
      AppMethodBeat.o(342257);
      return localWeImageView;
    }
    s.bIx("smileyBtn");
    AppMethodBeat.o(342257);
    return null;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(342244);
    SmileyPanel localSmileyPanel = this.niv;
    if (localSmileyPanel != null)
    {
      AppMethodBeat.o(342244);
      return localSmileyPanel;
    }
    s.bIx("smileyPanel");
    AppMethodBeat.o(342244);
    return null;
  }
  
  public final ImageView getSwitchSceneAvatar()
  {
    AppMethodBeat.i(342176);
    ImageView localImageView = this.FZd;
    if (localImageView != null)
    {
      AppMethodBeat.o(342176);
      return localImageView;
    }
    s.bIx("switchSceneAvatar");
    AppMethodBeat.o(342176);
    return null;
  }
  
  public final kotlin.g.a.a<ah> getSwitchSceneListener()
  {
    return this.FZs;
  }
  
  public final TextView getSwitchSceneName()
  {
    AppMethodBeat.i(342196);
    TextView localTextView = this.FZe;
    if (localTextView != null)
    {
      AppMethodBeat.o(342196);
      return localTextView;
    }
    s.bIx("switchSceneName");
    AppMethodBeat.o(342196);
    return null;
  }
  
  public final View getSwitchSceneTip()
  {
    AppMethodBeat.i(342213);
    View localView = this.FZf;
    if (localView != null)
    {
      AppMethodBeat.o(342213);
      return localView;
    }
    s.bIx("switchSceneTip");
    AppMethodBeat.o(342213);
    return null;
  }
  
  public final TextView getSwitchSceneTipTv()
  {
    AppMethodBeat.i(342233);
    TextView localTextView = this.FZg;
    if (localTextView != null)
    {
      AppMethodBeat.o(342233);
      return localTextView;
    }
    s.bIx("switchSceneTipTv");
    AppMethodBeat.o(342233);
    return null;
  }
  
  public final ImageView getTargetAvatar()
  {
    AppMethodBeat.i(342356);
    ImageView localImageView = this.FZn;
    if (localImageView != null)
    {
      AppMethodBeat.o(342356);
      return localImageView;
    }
    s.bIx("targetAvatar");
    AppMethodBeat.o(342356);
    return null;
  }
  
  public final void i(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(342647);
    s.u(paramString1, "fromName");
    s.u(paramString2, "toName");
    a(this, this.FZv, s.X(" ", getResources().getString(e.h.comment_other_hint2, new Object[] { paramString2 })), paramObject);
    AppMethodBeat.o(342647);
  }
  
  public final void ij(String paramString1, String paramString2)
  {
    AppMethodBeat.i(342635);
    s.u(paramString1, "fromName");
    s.u(paramString2, "toName");
    a(this, this.FZv, s.X(" ", getResources().getString(e.h.comment_ower_hint3)), null);
    AppMethodBeat.o(342635);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(342587);
    super.onFinishInflate();
    Object localObject = findViewById(e.e.comment_scene_avatar);
    s.s(localObject, "findViewById(R.id.comment_scene_avatar)");
    setSwitchSceneAvatar((ImageView)localObject);
    localObject = findViewById(e.e.comment_scene_name);
    s.s(localObject, "findViewById(R.id.comment_scene_name)");
    setSwitchSceneName((TextView)localObject);
    localObject = findViewById(e.e.comment_switch_scene_tip_layout);
    s.s(localObject, "findViewById(R.id.comment_switch_scene_tip_layout)");
    setSwitchSceneTip((View)localObject);
    localObject = findViewById(e.e.comment_switch_scene_tip_tv);
    s.s(localObject, "findViewById(R.id.comment_switch_scene_tip_tv)");
    setSwitchSceneTipTv((TextView)localObject);
    localObject = findViewById(e.e.smiley_btn);
    s.s(localObject, "findViewById(R.id.smiley_btn)");
    setSmileyBtn((WeImageView)localObject);
    localObject = findViewById(e.e.mention_btn);
    s.s(localObject, "findViewById(R.id.mention_btn)");
    setMentionBtn((ImageView)localObject);
    localObject = findViewById(e.e.comment_et);
    s.s(localObject, "findViewById(R.id.comment_et)");
    setEditText((FinderCommentEditText)localObject);
    localObject = findViewById(e.e.comment_target_avatar);
    s.s(localObject, "findViewById(R.id.comment_target_avatar)");
    setTargetAvatar((ImageView)localObject);
    localObject = findViewById(e.e.reply_btn);
    s.s(localObject, "findViewById(R.id.reply_btn)");
    setReplyBtn((View)localObject);
    localObject = findViewById(e.e.comment_et_layout);
    s.s(localObject, "findViewById(R.id.comment_et_layout)");
    setCommentEditTextLayout((View)localObject);
    this.FZm = ((ViewGroup)findViewById(e.e.comment_et_container));
    if (aw.isDarkMode()) {
      getSwitchSceneTip().setBackgroundResource(e.d.finder_switch_scene_tip_dark_bg2);
    }
    for (;;)
    {
      getSmileyBtn().setTag(Boolean.FALSE);
      localObject = ae.m(getContext(), false);
      s.s(localObject, "getSmileyPanel(context, false)");
      setSmileyPanel((SmileyPanel)localObject);
      getSmileyPanel().setEntranceScene(ChatFooterPanel.ACC);
      getSmileyPanel().setBackgroundResource(e.d.finder_bottombar_bg);
      getSmileyPanel().iKh();
      getSmileyPanel().iKi();
      getSmileyPanel().JA(false);
      getSmileyPanel().setVisibility(4);
      getSmileyPanel().onResume();
      getSmileyPanel().setOnTextOperationListener((ChatFooterPanel.a)new e(this));
      localObject = new LinearLayout.LayoutParams(-1, (int)this.FZp);
      getSmileyPanel().setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView((View)getSmileyPanel(), (ViewGroup.LayoutParams)localObject);
      getSmileyBtn().setOnClickListener(new UniCommentFooter..ExternalSyntheticLambda4(this));
      getMentionBtn().setOnClickListener(new UniCommentFooter..ExternalSyntheticLambda3(this));
      setTranslationY(this.FZp);
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      this.FZo = (((Number)com.tencent.mm.plugin.finder.storage.d.eSl().bmg()).intValue() * 2);
      getReplyBtn().setVisibility(8);
      getEditText().addTextChangedListener((TextWatcher)new g(this));
      getEditText().setOnKeyListener(new UniCommentFooter..ExternalSyntheticLambda7(this));
      c.i((EditText)getEditText()).oF(0, this.FZo).a(null);
      up(false);
      AppMethodBeat.o(342587);
      return;
      getSwitchSceneTip().setBackgroundResource(e.d.finder_switch_scene_tip_bg2);
    }
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(342560);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.FZq; paramBoolean = false)
    {
      AppMethodBeat.o(342560);
      return;
    }
    Object localObject;
    if ((paramInt > 0) && (paramInt != (int)this.FZp))
    {
      KeyBoardUtil.saveKeyBordHeightPx(getContext(), paramInt);
      this.FZp = paramInt;
      localObject = new LinearLayout.LayoutParams(-1, (int)this.FZp);
      getSmileyPanel().setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.EBm != paramBoolean)
    {
      this.EBm = paramBoolean;
      if (!paramBoolean) {
        break label164;
      }
      animate().setDuration(90L).translationY(0.0F).setListener((Animator.AnimatorListener)new j(this)).start();
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((com.tencent.mm.plugin.finder.storage.d.eSD() <= 0) || (!fdk())) {
        break;
      }
      getSwitchSceneTip().setVisibility(0);
      AppMethodBeat.o(342560);
      return;
      label164:
      if ((this.FZu == 2) || (this.FZu == 0)) {
        animate().setDuration(180L).translationY(this.FZp).setListener((Animator.AnimatorListener)new k(this)).start();
      }
    }
    getSwitchSceneTip().setVisibility(8);
    AppMethodBeat.o(342560);
  }
  
  public final void setBackClickListener(kotlin.g.a.a<ah> parama)
  {
    this.EpU = parama;
  }
  
  public final void setBanSwitchScene(boolean paramBoolean)
  {
    this.FZt = paramBoolean;
  }
  
  public final void setCommentEditTextContainer(ViewGroup paramViewGroup)
  {
    this.FZm = paramViewGroup;
  }
  
  public final void setCommentEditTextLayout(View paramView)
  {
    AppMethodBeat.i(342335);
    s.u(paramView, "<set-?>");
    this.FZl = paramView;
    AppMethodBeat.o(342335);
  }
  
  public final void setCommentTextLimit(int paramInt)
  {
    this.FZo = paramInt;
  }
  
  public final void setEditText(FinderCommentEditText paramFinderCommentEditText)
  {
    AppMethodBeat.i(342300);
    s.u(paramFinderCommentEditText, "<set-?>");
    this.FZj = paramFinderCommentEditText;
    AppMethodBeat.o(342300);
  }
  
  public final void setFooterMode(int paramInt)
  {
    AppMethodBeat.i(342540);
    b localb = this.FZr;
    if (localb != null) {
      localb.ht(this.FZu, paramInt);
    }
    this.FZu = paramInt;
    AppMethodBeat.o(342540);
  }
  
  public final void setFrozen(boolean paramBoolean)
  {
    this.FZq = paramBoolean;
  }
  
  public final void setLastActionStr(String paramString)
  {
    AppMethodBeat.i(342694);
    s.u(paramString, "<set-?>");
    this.FZw = paramString;
    AppMethodBeat.o(342694);
  }
  
  public final void setLastFromName(String paramString)
  {
    AppMethodBeat.i(342675);
    s.u(paramString, "<set-?>");
    this.FZv = paramString;
    AppMethodBeat.o(342675);
  }
  
  public final void setLastTag(Object paramObject)
  {
    this.FZx = paramObject;
  }
  
  public final void setMentionBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(342280);
    s.u(paramImageView, "<set-?>");
    this.FZi = paramImageView;
    AppMethodBeat.o(342280);
  }
  
  public final void setModeChangeCallback(b paramb)
  {
    this.FZr = paramb;
  }
  
  public final void setReplyBtn(View paramView)
  {
    AppMethodBeat.i(342317);
    s.u(paramView, "<set-?>");
    this.FZk = paramView;
    AppMethodBeat.o(342317);
  }
  
  public final void setReplyBtnWidth(int paramInt)
  {
    this.niw = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(342497);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      Log.printInfoStack("MicroMsg.MusicUni.UniCommentFooter", s.X("set footer scene:", Integer.valueOf(paramInt)), new Object[0]);
    }
    this.scene = paramInt;
    AppMethodBeat.o(342497);
  }
  
  public final void setSelfProfile(boolean paramBoolean)
  {
    this.EAO = paramBoolean;
  }
  
  public final void setSendBtnEnabled(boolean paramBoolean)
  {
    this.nix = paramBoolean;
  }
  
  public final void setSmileyBtn(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(342263);
    s.u(paramWeImageView, "<set-?>");
    this.FZh = paramWeImageView;
    AppMethodBeat.o(342263);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(342249);
    s.u(paramSmileyPanel, "<set-?>");
    this.niv = paramSmileyPanel;
    AppMethodBeat.o(342249);
  }
  
  public final void setSwitchSceneAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(342187);
    s.u(paramImageView, "<set-?>");
    this.FZd = paramImageView;
    AppMethodBeat.o(342187);
  }
  
  public final void setSwitchSceneListener(kotlin.g.a.a<ah> parama)
  {
    this.FZs = parama;
  }
  
  public final void setSwitchSceneName(TextView paramTextView)
  {
    AppMethodBeat.i(342205);
    s.u(paramTextView, "<set-?>");
    this.FZe = paramTextView;
    AppMethodBeat.o(342205);
  }
  
  public final void setSwitchSceneTip(View paramView)
  {
    AppMethodBeat.i(342225);
    s.u(paramView, "<set-?>");
    this.FZf = paramView;
    AppMethodBeat.o(342225);
  }
  
  public final void setSwitchSceneTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(342240);
    s.u(paramTextView, "<set-?>");
    this.FZg = paramTextView;
    AppMethodBeat.o(342240);
  }
  
  public final void setTargetAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(342364);
    s.u(paramImageView, "<set-?>");
    this.FZn = paramImageView;
    AppMethodBeat.o(342364);
  }
  
  public final void up(boolean paramBoolean)
  {
    AppMethodBeat.i(342598);
    getSwitchSceneTip().setVisibility(8);
    uq(paramBoolean);
    Object localObject = findViewById(e.e.comment_switch_scene_click_layout);
    if (fdk())
    {
      ((View)localObject).findViewById(e.e.comment_scene_btn).setVisibility(0);
      ((View)localObject).setOnClickListener(new UniCommentFooter..ExternalSyntheticLambda2(this));
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.eSD() > 0) {
        getSwitchSceneTip().setVisibility(0);
      }
      getTargetAvatar().setVisibility(8);
      localObject = getEditText();
      ((FinderCommentEditText)localObject).setPadding((int)((FinderCommentEditText)localObject).getContext().getResources().getDimension(e.c.Edge_A), 0, (int)((FinderCommentEditText)localObject).getContext().getResources().getDimension(e.c.Edge_A), 0);
      AppMethodBeat.o(342598);
      return;
      ((View)localObject).setOnClickListener(UniCommentFooter..ExternalSyntheticLambda6.INSTANCE);
      ((View)localObject).findViewById(e.e.comment_scene_btn).setVisibility(8);
    }
  }
  
  public final void uq(boolean paramBoolean)
  {
    AppMethodBeat.i(342614);
    Object localObject2;
    Object localObject3;
    if (this.scene == 2)
    {
      if (fdl()) {
        getMentionBtn().setVisibility(0);
      }
      com.tencent.mm.ui.i.a.a.g(getSwitchSceneAvatar(), z.bAM());
      getSwitchSceneTipTv().setText(e.h.finder_switch_scene_float_tips3);
      localObject1 = getSwitchSceneName();
      localObject2 = getContext();
      localObject3 = av.GiL;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)av.Ud(this.scene)));
      localObject1 = av.GiL;
      localObject1 = av.Ud(this.scene);
      bT((String)localObject1, paramBoolean);
      localObject2 = (ViewGroup)findViewById(e.e.comment_switch_scene_click_layout);
      if (localObject2 != null) {
        ((ViewGroup)localObject2).setTag(e.e.finder_accessibility_self_name_tag, localObject1);
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((com.tencent.mm.plugin.finder.storage.d.eSD() <= 0) && (getSwitchSceneTip().getVisibility() == 0)) {
        getSwitchSceneTip().setVisibility(8);
      }
      fdm();
      if ((this.scene == 1) && (!Util.isNullOrNil((List)this.Ddb)))
      {
        localObject1 = getContext().getString(e.h.finder_scene_finder_cannot_at_friend);
        s.s(localObject1, "context.getString(R.stri…_finder_cannot_at_friend)");
        aa.a(getContext(), (String)localObject1, UniCommentFooter..ExternalSyntheticLambda8.INSTANCE);
      }
      AppMethodBeat.o(342614);
      return;
    }
    getMentionBtn().setVisibility(8);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = d.a.auT(z.bAW());
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
      localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      localObject3 = getSwitchSceneAvatar();
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      getSwitchSceneTipTv().setText(e.h.finder_switch_scene_float_tips3);
      break;
      localObject2 = ((m)localObject1).amx();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  final void ur(final boolean paramBoolean)
  {
    AppMethodBeat.i(342624);
    if (this.FZq)
    {
      AppMethodBeat.o(342624);
      return;
    }
    setSmileyIcon(false);
    getSmileyBtn().setTag(Boolean.FALSE);
    if (paramBoolean)
    {
      animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(220L).translationY(this.FZp).setListener((Animator.AnimatorListener)new h(this, paramBoolean)).start();
      AppMethodBeat.o(342624);
      return;
    }
    getSmileyPanel().animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i(this)).start();
    AppMethodBeat.o(342624);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentFooter$IModeChangeCallback;", "", "onModeChange", "", "from", "", "to", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void ht(int paramInt1, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$checkShowReplyBtn$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(UniCommentFooter paramUniCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(341351);
      paramAnimator = this.FZz.getReplyBtn().getLayoutParams();
      paramAnimator.width = this.FZz.getReplyBtnWidth();
      this.FZz.getReplyBtn().setLayoutParams(paramAnimator);
      this.FZz.getReplyBtn().setAlpha(1.0F);
      AppMethodBeat.o(341351);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(341344);
      paramAnimator = this.FZz.getReplyBtn().getLayoutParams();
      paramAnimator.width = this.FZz.getReplyBtnWidth();
      this.FZz.getReplyBtn().setLayoutParams(paramAnimator);
      this.FZz.getReplyBtn().setAlpha(1.0F);
      AppMethodBeat.o(341344);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(341358);
      this.FZz.getReplyBtn().setVisibility(0);
      AppMethodBeat.o(341358);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$checkShowReplyBtn$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(UniCommentFooter paramUniCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(341391);
      this.FZz.getReplyBtn().setVisibility(8);
      AppMethodBeat.o(341391);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(341385);
      this.FZz.getReplyBtn().setVisibility(8);
      AppMethodBeat.o(341385);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(341395);
      this.FZz.getReplyBtn().setVisibility(0);
      AppMethodBeat.o(341395);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$onFinishInflate$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ChatFooterPanel.a
  {
    e(UniCommentFooter paramUniCommentFooter) {}
    
    public final void aWL() {}
    
    public final void aWM()
    {
      AppMethodBeat.i(341383);
      if (this.FZz.getEditText().getInputConnection() != null)
      {
        this.FZz.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        this.FZz.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      }
      AppMethodBeat.o(341383);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(341377);
      this.FZz.getEditText().bDt(paramString);
      AppMethodBeat.o(341377);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$onFinishInflate$3$dialog$1", "Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "at", "", "displayName", "", "username", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.finder.ui.at.a
  {
    f(UniCommentFooter paramUniCommentFooter) {}
    
    public final void hM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(341363);
      s.u(paramString1, "displayName");
      s.u(paramString2, "username");
      UniCommentFooter.a(this.FZz, paramString1, paramString2);
      AppMethodBeat.o(341363);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$onFinishInflate$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements TextWatcher
  {
    g(UniCommentFooter paramUniCommentFooter) {}
    
    private static final void e(UniCommentFooter paramUniCommentFooter)
    {
      AppMethodBeat.i(341360);
      s.u(paramUniCommentFooter, "this$0");
      UniCommentFooter.a(paramUniCommentFooter, paramUniCommentFooter.getEditText().getText());
      AppMethodBeat.o(341360);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(341373);
      this.FZz.getEditText().postDelayed(new UniCommentFooter.g..ExternalSyntheticLambda0(this.FZz), 160L);
      AppMethodBeat.o(341373);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(341384);
      if ((this.FZz.getScene() == 2) && (paramInt3 == 1)) {
        if (paramCharSequence != null) {
          break label58;
        }
      }
      label58:
      for (paramInt1 = 32;; paramInt1 = paramCharSequence.charAt(paramInt1))
      {
        if ((paramInt1 == 64) && (UniCommentFooter.fdn())) {
          this.FZz.getMentionBtn().performClick();
        }
        AppMethodBeat.o(341384);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements Animator.AnimatorListener
  {
    h(UniCommentFooter paramUniCommentFooter, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(341405);
      this.FZz.getSmileyPanel().setVisibility(4);
      UniCommentFooter.c(this.FZz);
      if (paramBoolean) {
        this.FZz.setFooterMode(0);
      }
      AppMethodBeat.o(341405);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements Animator.AnimatorListener
  {
    i(UniCommentFooter paramUniCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(341390);
      this.FZz.getSmileyPanel().setAlpha(1.0F);
      this.FZz.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(341390);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$onKeyboardHeightChanged$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements Animator.AnimatorListener
  {
    j(UniCommentFooter paramUniCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(341394);
      this.FZz.setFooterMode(2);
      UniCommentFooter.c(this.FZz);
      this.FZz.getSmileyBtn().setTag(Boolean.FALSE);
      AppMethodBeat.o(341394);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$onKeyboardHeightChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements Animator.AnimatorListener
  {
    k(UniCommentFooter paramUniCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(341387);
      this.FZz.setFooterMode(0);
      AppMethodBeat.o(341387);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements View.OnLayoutChangeListener
  {
    l(UniCommentFooter paramUniCommentFooter, kotlin.g.a.a<ah> parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(341403);
      this.FZz.getSmileyPanel().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramView.invoke();
      AppMethodBeat.o(341403);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "selectScene", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    n(UniCommentFooter paramUniCommentFooter, com.tencent.mm.plugin.finder.view.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "selectScene", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    o(UniCommentFooter paramUniCommentFooter, com.tencent.mm.plugin.finder.view.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.UniCommentFooter
 * JD-Core Version:    0.7.0.1
 */