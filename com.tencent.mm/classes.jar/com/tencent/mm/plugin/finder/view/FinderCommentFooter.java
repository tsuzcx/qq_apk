package com.tencent.mm.plugin.finder.view;

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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
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
import com.tencent.mm.plugin.finder.view.emoji.FinderEmojiPickView;
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
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.e;
import kotlin.n.i;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "atWxContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/view/MentionContact;", "Lkotlin/collections/ArrayList;", "backClickListener", "Lkotlin/Function0;", "", "getBackClickListener", "()Lkotlin/jvm/functions/Function0;", "setBackClickListener", "(Lkotlin/jvm/functions/Function0;)V", "banSwitchScene", "", "getBanSwitchScene", "()Z", "setBanSwitchScene", "(Z)V", "commentEditTextContainer", "Landroid/view/ViewGroup;", "getCommentEditTextContainer", "()Landroid/view/ViewGroup;", "setCommentEditTextContainer", "(Landroid/view/ViewGroup;)V", "commentEditTextLayout", "Landroid/view/View;", "getCommentEditTextLayout", "()Landroid/view/View;", "setCommentEditTextLayout", "(Landroid/view/View;)V", "commentTextLimit", "", "getCommentTextLimit", "()I", "setCommentTextLimit", "(I)V", "editText", "Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;", "getEditText", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;", "setEditText", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentEditText;)V", "value", "footerMode", "getFooterMode", "setFooterMode", "isFrozen", "setFrozen", "isSelfProfile", "setSelfProfile", "isShowKeyboard", "keyBoardHeight", "", "lastActionStr", "", "getLastActionStr", "()Ljava/lang/String;", "setLastActionStr", "(Ljava/lang/String;)V", "lastFromName", "getLastFromName", "setLastFromName", "lastTag", "", "getLastTag", "()Ljava/lang/Object;", "setLastTag", "(Ljava/lang/Object;)V", "mentionBtn", "Landroid/widget/ImageView;", "getMentionBtn", "()Landroid/widget/ImageView;", "setMentionBtn", "(Landroid/widget/ImageView;)V", "modeChangeCallback", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "getModeChangeCallback", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;", "setModeChangeCallback", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter$IModeChangeCallback;)V", "quickEmojiHeight", "quickPickEmoji", "Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiPickView;", "getQuickPickEmoji", "()Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiPickView;", "setQuickPickEmoji", "(Lcom/tencent/mm/plugin/finder/view/emoji/FinderEmojiPickView;)V", "replyBtn", "getReplyBtn", "setReplyBtn", "replyBtnWidth", "getReplyBtnWidth", "setReplyBtnWidth", "scene", "getScene", "setScene", "sendBtnEnabled", "getSendBtnEnabled", "setSendBtnEnabled", "smileyBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getSmileyBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setSmileyBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "smileyContainer", "Landroid/widget/FrameLayout;", "getSmileyContainer", "()Landroid/widget/FrameLayout;", "setSmileyContainer", "(Landroid/widget/FrameLayout;)V", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "getSmileyPanel", "()Lcom/tencent/mm/api/SmileyPanel;", "setSmileyPanel", "(Lcom/tencent/mm/api/SmileyPanel;)V", "smileyPanelHeight", "switchSceneAvatar", "getSwitchSceneAvatar", "setSwitchSceneAvatar", "switchSceneListener", "getSwitchSceneListener", "setSwitchSceneListener", "switchSceneName", "Landroid/widget/TextView;", "getSwitchSceneName", "()Landroid/widget/TextView;", "setSwitchSceneName", "(Landroid/widget/TextView;)V", "switchSceneTip", "getSwitchSceneTip", "setSwitchSceneTip", "switchSceneTipTv", "getSwitchSceneTipTv", "setSwitchSceneTipTv", "targetAvatar", "getTargetAvatar", "setTargetAvatar", "canSwitchScene", "changeReplyTo", "fromName", "actionStr", "tag", "needFocus", "changeReplyToAndFocus", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "showRemark", "changeReplyToCommenter", "toName", "changeReplyToPoster", "changeSelfName", "selfName", "checkAtWxContactValid", "checkShowReplyBtn", "s", "Landroid/text/Editable;", "ellipseName", "name", "getAvatarView", "getMentionListWhenReply", "", "initSelectItem", "item1", "itemScene", "onItemSelect", "Lkotlin/Function1;", "isCommentAtEnable", "onAtSomeone", "displayName", "username", "onFinishInflate", "onHideKeyBoardOrSmileyPanel", "onHideSmileyPanel", "isMoveAnim", "onKeyboardHeightChanged", "height", "isResized", "onSceneSwitch", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "refreshCommentScene", "refreshSwitchSceneView", "setSmileyIcon", "showVKB", "isShow", "updateFeedIdToEditText", "feedId", "", "Companion", "IModeChangeCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCommentFooter
  extends LinearLayout
  implements com.tencent.mm.ui.tools.h
{
  private static final at.a FZy;
  public static final FinderCommentFooter.a GxO;
  private ArrayList<ah> Ddb;
  private boolean EAO;
  private boolean EBm;
  private kotlin.g.a.a<kotlin.ah> EpU;
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
  private kotlin.g.a.a<kotlin.ah> FZs;
  private boolean FZt;
  public int FZu;
  public String FZv;
  private String FZw;
  private Object FZx;
  public FinderEmojiPickView GxP;
  public FrameLayout GxQ;
  private float GxR;
  private float GxS;
  private FinderCommentFooter.b GxT;
  public SmileyPanel niv;
  private int niw;
  private boolean nix;
  private int scene;
  
  static
  {
    AppMethodBeat.i(168295);
    GxO = new FinderCommentFooter.a((byte)0);
    FZy = at.a.adhJ;
    AppMethodBeat.o(168295);
  }
  
  public FinderCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168294);
    this.FZp = KeyBoardUtil.getKeyBordHeightPx(getContext());
    this.GxR = KeyBoardUtil.getKeyBordHeightPx(getContext());
    this.GxS = com.tencent.mm.cd.a.fromDPToPix(getContext(), 56);
    this.niw = bd.bs(getContext(), e.c.Edge_7A);
    this.scene = 2;
    this.Ddb = new ArrayList();
    this.FZv = "";
    this.FZw = "";
    AppMethodBeat.o(168294);
  }
  
  private final void a(View paramView, int paramInt, kotlin.g.a.b<? super Integer, kotlin.ah> paramb)
  {
    AppMethodBeat.i(345100);
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
      paramView.setOnClickListener(new FinderCommentFooter..ExternalSyntheticLambda5(paramb, paramInt));
      AppMethodBeat.o(345100);
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
  
  private static final void a(FinderCommentFooter paramFinderCommentFooter, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(345192);
    s.u(paramFinderCommentFooter, "this$0");
    if (paramValueAnimator == null) {}
    for (paramValueAnimator = null; paramValueAnimator == null; paramValueAnimator = paramValueAnimator.getAnimatedValue())
    {
      paramFinderCommentFooter = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(345192);
      throw paramFinderCommentFooter;
    }
    float f = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = paramFinderCommentFooter.getReplyBtn().getLayoutParams();
    paramValueAnimator.width = kotlin.h.a.eH(f);
    paramFinderCommentFooter.getReplyBtn().setLayoutParams(paramValueAnimator);
    paramFinderCommentFooter.getReplyBtn().setAlpha(f / paramFinderCommentFooter.getReplyBtnWidth());
    AppMethodBeat.o(345192);
  }
  
  private static final void a(FinderCommentFooter paramFinderCommentFooter, final View paramView)
  {
    AppMethodBeat.i(345157);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCommentFooter);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderCommentFooter, "this$0");
    if (paramView == null)
    {
      paramFinderCommentFooter = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(345157);
      throw paramFinderCommentFooter;
    }
    paramView = ((ImageView)paramView).getTag();
    if (paramView == null)
    {
      paramFinderCommentFooter = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(345157);
      throw paramFinderCommentFooter;
    }
    boolean bool;
    if (!((Boolean)paramView).booleanValue()) {
      bool = true;
    }
    while (!paramFinderCommentFooter.FZq)
    {
      if (bool) {
        break label242;
      }
      paramFinderCommentFooter.setFooterMode(2);
      paramFinderCommentFooter.ur(false);
      paramFinderCommentFooter.getEditText().setShowSoftInputOnFocus(true);
      paramFinderCommentFooter.getEditText().requestFocus();
      paramView = paramFinderCommentFooter.getContext();
      if (paramView == null)
      {
        paramFinderCommentFooter = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(345157);
        throw paramFinderCommentFooter;
        bool = false;
      }
      else
      {
        ((MMFragmentActivity)paramView).showVKB();
      }
    }
    for (;;)
    {
      paramFinderCommentFooter.setSmileyIcon(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345157);
      return;
      label242:
      int i;
      if (paramFinderCommentFooter.FZu != 2)
      {
        i = 1;
        if (!paramFinderCommentFooter.FZq)
        {
          paramFinderCommentFooter.getSmileyPanel().setVisibility(0);
          paramFinderCommentFooter.getQuickPickEmoji().setVisibility(4);
          paramFinderCommentFooter.setSmileyIcon(false);
          paramFinderCommentFooter.getSmileyBtn().setTag(Boolean.TRUE);
          if (i == 0) {
            break label386;
          }
          paramView = (kotlin.g.a.a)new FinderCommentFooter.m(paramFinderCommentFooter);
          if (paramFinderCommentFooter.getSmileyPanel().getHeight() > 0.0F) {
            break label376;
          }
          paramFinderCommentFooter.getSmileyPanel().addOnLayoutChangeListener((View.OnLayoutChangeListener)new l(paramFinderCommentFooter, paramView));
        }
      }
      for (;;)
      {
        paramFinderCommentFooter.setFooterMode(1);
        paramView = paramFinderCommentFooter.getContext();
        if (paramView != null) {
          break label421;
        }
        paramFinderCommentFooter = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(345157);
        throw paramFinderCommentFooter;
        i = 0;
        break;
        label376:
        paramView.invoke();
        continue;
        label386:
        paramFinderCommentFooter.getSmileyPanel().setAlpha(0.0F);
        paramFinderCommentFooter.getSmileyPanel().animate().alpha(1.0F).setDuration(220L).setListener(null).start();
      }
      label421:
      ((MMFragmentActivity)paramView).hideVKB();
    }
  }
  
  private final void a(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(345119);
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
      AppMethodBeat.o(345119);
      return;
    }
  }
  
  private static final boolean a(FinderCommentFooter paramFinderCommentFooter, View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(345180);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCommentFooter);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", localObject, localb.aYj());
    s.u(paramFinderCommentFooter, "this$0");
    int j;
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      j = paramFinderCommentFooter.getEditText().getSelectionEnd();
      paramKeyEvent = paramFinderCommentFooter.getEditText().getText();
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
        paramFinderCommentFooter.getEditText().setText((CharSequence)paramFinderCommentFooter.getEditText().getText().replace(paramInt, j, (CharSequence)""));
        paramFinderCommentFooter.getEditText().setSelection(paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(345180);
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
      com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(345180);
      return false;
      label297:
      paramInt = i;
    }
  }
  
  private static final void b(FinderCommentFooter paramFinderCommentFooter)
  {
    AppMethodBeat.i(345233);
    s.u(paramFinderCommentFooter, "this$0");
    paramFinderCommentFooter.getEditText().requestFocus();
    if ((paramFinderCommentFooter.getContext() instanceof MMActivity))
    {
      paramFinderCommentFooter = paramFinderCommentFooter.getContext();
      if ((paramFinderCommentFooter instanceof MMActivity)) {}
      for (paramFinderCommentFooter = (MMActivity)paramFinderCommentFooter; paramFinderCommentFooter != null; paramFinderCommentFooter = null)
      {
        paramFinderCommentFooter.showVKB();
        AppMethodBeat.o(345233);
        return;
      }
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramFinderCommentFooter.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput((View)paramFinderCommentFooter.getEditText(), 0);
    }
    AppMethodBeat.o(345233);
  }
  
  private static final void b(FinderCommentFooter paramFinderCommentFooter, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(345200);
    s.u(paramFinderCommentFooter, "this$0");
    if (paramValueAnimator == null) {}
    for (paramValueAnimator = null; paramValueAnimator == null; paramValueAnimator = paramValueAnimator.getAnimatedValue())
    {
      paramFinderCommentFooter = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(345200);
      throw paramFinderCommentFooter;
    }
    float f = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = paramFinderCommentFooter.getReplyBtn().getLayoutParams();
    paramValueAnimator.width = kotlin.h.a.eH(f);
    paramFinderCommentFooter.getReplyBtn().setLayoutParams(paramValueAnimator);
    paramFinderCommentFooter.getReplyBtn().setAlpha(f / paramFinderCommentFooter.getReplyBtnWidth());
    AppMethodBeat.o(345200);
  }
  
  private static final void b(FinderCommentFooter paramFinderCommentFooter, View paramView)
  {
    AppMethodBeat.i(345166);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCommentFooter);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderCommentFooter, "this$0");
    paramView = paramFinderCommentFooter.getContext();
    s.s(paramView, "context");
    new com.tencent.mm.plugin.finder.ui.at.d(paramView, Boolean.FALSE, FZy, (com.tencent.mm.plugin.finder.ui.at.a)new e(paramFinderCommentFooter)).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345166);
  }
  
  private void bT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(345110);
    s.u(paramString, "selfName");
    a(aBi(paramString), this.FZw, this.FZx, paramBoolean);
    AppMethodBeat.o(345110);
  }
  
  private static final void c(FinderCommentFooter paramFinderCommentFooter, final View paramView)
  {
    AppMethodBeat.i(345211);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCommentFooter);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderCommentFooter, "this$0");
    paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eSD() > 0)
    {
      paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.Tm(0);
      paramFinderCommentFooter.getSwitchSceneTip().setVisibility(8);
      paramView = new d(paramFinderCommentFooter.getContext());
      paramView.UD(e.f.finder_switch_scene_bottom_sheet_layout);
      aw.a((Paint)((TextView)paramView.rootView.findViewById(e.e.finder_mm_bottom_sheet_title)).getPaint(), 0.8F);
      localObject = paramView.rootView.findViewById(e.e.finder_mm_bottom_sheet_item1);
      s.s(localObject, "item1");
      paramFinderCommentFooter.a((View)localObject, 1, (kotlin.g.a.b)new n(paramFinderCommentFooter, paramView));
      localObject = paramView.rootView.findViewById(e.e.finder_mm_bottom_sheet_item2);
      s.s(localObject, "item2");
      paramFinderCommentFooter.a((View)localObject, 2, (kotlin.g.a.b)new o(paramFinderCommentFooter, paramView));
      paramView.dDn();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345211);
      return;
      paramFinderCommentFooter.fdj();
    }
  }
  
  private static final void c(kotlin.g.a.b paramb, int paramInt, View paramView)
  {
    AppMethodBeat.i(345222);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$onItemSelect");
    paramb.invoke(Integer.valueOf(paramInt));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345222);
  }
  
  private final void fdj()
  {
    AppMethodBeat.i(345089);
    Object localObject = this.FZs;
    if (localObject != null) {
      ((kotlin.g.a.a)localObject).invoke();
    }
    localObject = av.GiL;
    setScene(av.Uf(this.scene));
    uq(true);
    AppMethodBeat.o(345089);
  }
  
  private final boolean fdk()
  {
    AppMethodBeat.i(178488);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.eSA().bmg()).intValue() == 1) && (!this.EAO))
    {
      localObject = av.GiL;
      if ((av.ffR()) && (!this.FZt))
      {
        AppMethodBeat.o(178488);
        return true;
      }
    }
    AppMethodBeat.o(178488);
    return false;
  }
  
  private static boolean fdl()
  {
    AppMethodBeat.i(345133);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXU().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(345133);
      return true;
    }
    AppMethodBeat.o(345133);
    return false;
  }
  
  private final void fdm()
  {
    AppMethodBeat.i(345142);
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
      if (((ArrayList)localObject2).contains(((ah)localObject4).nickname)) {
        ((Collection)localObject1).add(localObject4);
      }
    }
    this.Ddb = new ArrayList((Collection)localObject1);
    AppMethodBeat.o(345142);
  }
  
  private static final void gM(View paramView)
  {
    AppMethodBeat.i(345215);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345215);
  }
  
  private static final void gN(View paramView)
  {
    AppMethodBeat.i(345227);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(e.e.toast_text);
      if (paramView != null) {
        paramView.setTextSize(1, 14.0F);
      }
    }
    AppMethodBeat.o(345227);
  }
  
  private final void setSmileyIcon(boolean paramBoolean)
  {
    AppMethodBeat.i(345106);
    if (paramBoolean)
    {
      getSmileyBtn().oR(e.g.icons_outlined_keyboard, e.b.FG_0);
      getSmileyBtn().setContentDescription((CharSequence)getSmileyBtn().getContext().getString(e.h.chat_footer_switch_mode_keybord_btn));
      AppMethodBeat.o(345106);
      return;
    }
    getSmileyBtn().oR(e.g.icons_outlined_emoji, e.b.FG_0);
    getSmileyBtn().setContentDescription((CharSequence)getSmileyBtn().getContext().getString(e.h.chat_footer_smiley_btn));
    AppMethodBeat.o(345106);
  }
  
  public final String aBi(String paramString)
  {
    AppMethodBeat.i(345664);
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
    AppMethodBeat.o(345664);
    return paramString;
  }
  
  public final void dP(boolean paramBoolean)
  {
    AppMethodBeat.i(168292);
    if (this.FZq)
    {
      AppMethodBeat.o(168292);
      return;
    }
    if ((this.EBm) && (paramBoolean))
    {
      AppMethodBeat.o(168292);
      return;
    }
    if (paramBoolean)
    {
      localObject = getContext();
      if ((localObject instanceof MMFragmentActivity)) {}
      for (localObject = (MMFragmentActivity)localObject; localObject != null; localObject = null)
      {
        ((MMFragmentActivity)localObject).showVKB();
        AppMethodBeat.o(168292);
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
      AppMethodBeat.o(168292);
      return;
    }
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(168293);
    ImageView localImageView = getTargetAvatar();
    AppMethodBeat.o(168293);
    return localImageView;
  }
  
  public final kotlin.g.a.a<kotlin.ah> getBackClickListener()
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
    AppMethodBeat.i(168283);
    View localView = this.FZl;
    if (localView != null)
    {
      AppMethodBeat.o(168283);
      return localView;
    }
    s.bIx("commentEditTextLayout");
    AppMethodBeat.o(168283);
    return null;
  }
  
  public final int getCommentTextLimit()
  {
    return this.FZo;
  }
  
  public final FinderCommentEditText getEditText()
  {
    AppMethodBeat.i(345429);
    FinderCommentEditText localFinderCommentEditText = this.FZj;
    if (localFinderCommentEditText != null)
    {
      AppMethodBeat.o(345429);
      return localFinderCommentEditText;
    }
    s.bIx("editText");
    AppMethodBeat.o(345429);
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
    AppMethodBeat.i(345413);
    ImageView localImageView = this.FZi;
    if (localImageView != null)
    {
      AppMethodBeat.o(345413);
      return localImageView;
    }
    s.bIx("mentionBtn");
    AppMethodBeat.o(345413);
    return null;
  }
  
  public final List<ah> getMentionListWhenReply()
  {
    AppMethodBeat.i(345688);
    if (this.scene == 1)
    {
      this.Ddb.clear();
      localObject1 = (List)ab.aivy;
      AppMethodBeat.o(345688);
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
      AppMethodBeat.o(345688);
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
        ah localah = (ah)localObject1;
        if ((s.p(localah.nickname, str)) && (!localah.FYw))
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
        localObject1 = (ah)localObject1;
        if (localObject1 != null) {
          ((ah)localObject1).start = ((i)localObject3).kBn().fIj;
        }
        if (localObject1 == null) {
          break;
        }
        ((ah)localObject1).FYw = true;
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
      if (((ah)localObject3).FYw) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = new ArrayList((Collection)localObject1);
    localObject2 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ah)((Iterator)localObject2).next();
      if (!Util.isNullOrNil(((ah)localObject3).username))
      {
        Log.i("Finder.FinderCommentFooter", s.X("getMentionListWhenReply at user: ", ((ah)localObject3).username));
        com.tencent.mm.plugin.finder.ui.at.k.FWG.a(FZy, ((ah)localObject3).username);
      }
    }
    this.Ddb.clear();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(345688);
    return localObject1;
  }
  
  public final FinderCommentFooter.b getModeChangeCallback()
  {
    return this.GxT;
  }
  
  public final FinderEmojiPickView getQuickPickEmoji()
  {
    AppMethodBeat.i(345475);
    FinderEmojiPickView localFinderEmojiPickView = this.GxP;
    if (localFinderEmojiPickView != null)
    {
      AppMethodBeat.o(345475);
      return localFinderEmojiPickView;
    }
    s.bIx("quickPickEmoji");
    AppMethodBeat.o(345475);
    return null;
  }
  
  public final View getReplyBtn()
  {
    AppMethodBeat.i(168281);
    View localView = this.FZk;
    if (localView != null)
    {
      AppMethodBeat.o(168281);
      return localView;
    }
    s.bIx("replyBtn");
    AppMethodBeat.o(168281);
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
    AppMethodBeat.i(345398);
    WeImageView localWeImageView = this.FZh;
    if (localWeImageView != null)
    {
      AppMethodBeat.o(345398);
      return localWeImageView;
    }
    s.bIx("smileyBtn");
    AppMethodBeat.o(345398);
    return null;
  }
  
  public final FrameLayout getSmileyContainer()
  {
    AppMethodBeat.i(345486);
    FrameLayout localFrameLayout = this.GxQ;
    if (localFrameLayout != null)
    {
      AppMethodBeat.o(345486);
      return localFrameLayout;
    }
    s.bIx("smileyContainer");
    AppMethodBeat.o(345486);
    return null;
  }
  
  public final SmileyPanel getSmileyPanel()
  {
    AppMethodBeat.i(168275);
    SmileyPanel localSmileyPanel = this.niv;
    if (localSmileyPanel != null)
    {
      AppMethodBeat.o(168275);
      return localSmileyPanel;
    }
    s.bIx("smileyPanel");
    AppMethodBeat.o(168275);
    return null;
  }
  
  public final ImageView getSwitchSceneAvatar()
  {
    AppMethodBeat.i(178476);
    ImageView localImageView = this.FZd;
    if (localImageView != null)
    {
      AppMethodBeat.o(178476);
      return localImageView;
    }
    s.bIx("switchSceneAvatar");
    AppMethodBeat.o(178476);
    return null;
  }
  
  public final kotlin.g.a.a<kotlin.ah> getSwitchSceneListener()
  {
    return this.FZs;
  }
  
  public final TextView getSwitchSceneName()
  {
    AppMethodBeat.i(178478);
    TextView localTextView = this.FZe;
    if (localTextView != null)
    {
      AppMethodBeat.o(178478);
      return localTextView;
    }
    s.bIx("switchSceneName");
    AppMethodBeat.o(178478);
    return null;
  }
  
  public final View getSwitchSceneTip()
  {
    AppMethodBeat.i(178480);
    View localView = this.FZf;
    if (localView != null)
    {
      AppMethodBeat.o(178480);
      return localView;
    }
    s.bIx("switchSceneTip");
    AppMethodBeat.o(178480);
    return null;
  }
  
  public final TextView getSwitchSceneTipTv()
  {
    AppMethodBeat.i(178482);
    TextView localTextView = this.FZg;
    if (localTextView != null)
    {
      AppMethodBeat.o(178482);
      return localTextView;
    }
    s.bIx("switchSceneTipTv");
    AppMethodBeat.o(178482);
    return null;
  }
  
  public final ImageView getTargetAvatar()
  {
    AppMethodBeat.i(168285);
    ImageView localImageView = this.FZn;
    if (localImageView != null)
    {
      AppMethodBeat.o(168285);
      return localImageView;
    }
    s.bIx("targetAvatar");
    AppMethodBeat.o(168285);
    return null;
  }
  
  public final void i(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(178487);
    s.u(paramString1, "fromName");
    s.u(paramString2, "toName");
    a(this, this.FZv, s.X(" ", getResources().getString(e.h.comment_other_hint2, new Object[] { paramString2 })), paramObject);
    AppMethodBeat.o(178487);
  }
  
  public final void ij(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178486);
    s.u(paramString1, "fromName");
    s.u(paramString2, "toName");
    a(this, this.FZv, s.X(" ", getResources().getString(e.h.comment_ower_hint3)), null);
    AppMethodBeat.o(178486);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(168289);
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
    localObject = findViewById(e.e.v_quick_pick_emoji);
    s.s(localObject, "findViewById(R.id.v_quick_pick_emoji)");
    setQuickPickEmoji((FinderEmojiPickView)localObject);
    localObject = findViewById(e.e.fl_smiley_container);
    s.s(localObject, "findViewById(R.id.fl_smiley_container)");
    setSmileyContainer((FrameLayout)localObject);
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
      localObject = new g(this);
      getSmileyPanel().setOnTextOperationListener((ChatFooterPanel.a)localObject);
      getQuickPickEmoji().setOnTextOperationListener((ChatFooterPanel.a)localObject);
      localObject = getQuickPickEmoji();
      ((FinderEmojiPickView)localObject).GHb.bz((List)((FinderEmojiPickView)localObject).mio);
      ((FinderEmojiPickView)localObject).GHb.bZE.notifyChanged();
      if (getQuickPickEmoji().getCanShowEmoji()) {
        this.FZp += this.GxS;
      }
      localObject = new FrameLayout.LayoutParams(-1, (int)this.FZp);
      getSmileyPanel().setLayoutParams((ViewGroup.LayoutParams)localObject);
      getSmileyContainer().addView((View)getSmileyPanel(), (ViewGroup.LayoutParams)localObject);
      getSmileyBtn().setOnClickListener(new FinderCommentFooter..ExternalSyntheticLambda2(this));
      getMentionBtn().setOnClickListener(new FinderCommentFooter..ExternalSyntheticLambda4(this));
      setTranslationY(this.FZp);
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      this.FZo = (((Number)com.tencent.mm.plugin.finder.storage.d.eSl().bmg()).intValue() * 2);
      getReplyBtn().setVisibility(8);
      getEditText().addTextChangedListener((TextWatcher)new f(this));
      getEditText().setOnKeyListener(new FinderCommentFooter..ExternalSyntheticLambda7(this));
      c.i((EditText)getEditText()).oF(0, this.FZo).a(null);
      up(false);
      AppMethodBeat.o(168289);
      return;
      getSwitchSceneTip().setBackgroundResource(e.d.finder_switch_scene_tip_bg2);
    }
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168288);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.FZq; paramBoolean = false)
    {
      AppMethodBeat.o(168288);
      return;
    }
    Log.i("Finder.FinderCommentFooter", s.X("onKeyboardHeightChanged isShow: ", Boolean.valueOf(paramBoolean)));
    float f;
    Object localObject;
    if ((paramInt > 0) && (paramInt != (int)this.GxR))
    {
      KeyBoardUtil.saveKeyBordHeightPx(getContext(), paramInt);
      this.GxR = paramInt;
      if (getQuickPickEmoji().getCanShowEmoji())
      {
        f = this.GxR + this.GxS;
        this.FZp = f;
        localObject = new FrameLayout.LayoutParams(-1, (int)this.FZp);
        getSmileyPanel().setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else if (this.EBm != paramBoolean)
    {
      this.EBm = paramBoolean;
      if (!paramBoolean) {
        break label216;
      }
      animate().setDuration(90L).translationY(0.0F).setListener((Animator.AnimatorListener)new j(this)).start();
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((com.tencent.mm.plugin.finder.storage.d.eSD() <= 0) || (!fdk())) {
        break label268;
      }
      getSwitchSceneTip().setVisibility(0);
      AppMethodBeat.o(168288);
      return;
      f = this.GxR;
      break;
      label216:
      if ((this.FZu == 2) || (this.FZu == 0)) {
        animate().setDuration(180L).translationY(this.FZp).setListener((Animator.AnimatorListener)new k(this)).start();
      }
    }
    label268:
    getSwitchSceneTip().setVisibility(8);
    AppMethodBeat.o(168288);
  }
  
  public final void setBackClickListener(kotlin.g.a.a<kotlin.ah> parama)
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
    AppMethodBeat.i(168284);
    s.u(paramView, "<set-?>");
    this.FZl = paramView;
    AppMethodBeat.o(168284);
  }
  
  public final void setCommentTextLimit(int paramInt)
  {
    this.FZo = paramInt;
  }
  
  public final void setEditText(FinderCommentEditText paramFinderCommentEditText)
  {
    AppMethodBeat.i(345435);
    s.u(paramFinderCommentEditText, "<set-?>");
    this.FZj = paramFinderCommentEditText;
    AppMethodBeat.o(345435);
  }
  
  public final void setFooterMode(int paramInt)
  {
    AppMethodBeat.i(168287);
    FinderCommentFooter.b localb = this.GxT;
    if (localb != null) {
      localb.ht(this.FZu, paramInt);
    }
    this.FZu = paramInt;
    AppMethodBeat.o(168287);
  }
  
  public final void setFrozen(boolean paramBoolean)
  {
    this.FZq = paramBoolean;
  }
  
  public final void setLastActionStr(String paramString)
  {
    AppMethodBeat.i(345646);
    s.u(paramString, "<set-?>");
    this.FZw = paramString;
    AppMethodBeat.o(345646);
  }
  
  public final void setLastFromName(String paramString)
  {
    AppMethodBeat.i(345636);
    s.u(paramString, "<set-?>");
    this.FZv = paramString;
    AppMethodBeat.o(345636);
  }
  
  public final void setLastTag(Object paramObject)
  {
    this.FZx = paramObject;
  }
  
  public final void setMentionBtn(ImageView paramImageView)
  {
    AppMethodBeat.i(345421);
    s.u(paramImageView, "<set-?>");
    this.FZi = paramImageView;
    AppMethodBeat.o(345421);
  }
  
  public final void setModeChangeCallback(FinderCommentFooter.b paramb)
  {
    this.GxT = paramb;
  }
  
  public final void setQuickPickEmoji(FinderEmojiPickView paramFinderEmojiPickView)
  {
    AppMethodBeat.i(345480);
    s.u(paramFinderEmojiPickView, "<set-?>");
    this.GxP = paramFinderEmojiPickView;
    AppMethodBeat.o(345480);
  }
  
  public final void setReplyBtn(View paramView)
  {
    AppMethodBeat.i(168282);
    s.u(paramView, "<set-?>");
    this.FZk = paramView;
    AppMethodBeat.o(168282);
  }
  
  public final void setReplyBtnWidth(int paramInt)
  {
    this.niw = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(345557);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
      Log.printInfoStack("Finder.FinderCommentFooter", s.X("set footer scene:", Integer.valueOf(paramInt)), new Object[0]);
    }
    this.scene = paramInt;
    AppMethodBeat.o(345557);
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
    AppMethodBeat.i(345407);
    s.u(paramWeImageView, "<set-?>");
    this.FZh = paramWeImageView;
    AppMethodBeat.o(345407);
  }
  
  public final void setSmileyContainer(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(345490);
    s.u(paramFrameLayout, "<set-?>");
    this.GxQ = paramFrameLayout;
    AppMethodBeat.o(345490);
  }
  
  public final void setSmileyPanel(SmileyPanel paramSmileyPanel)
  {
    AppMethodBeat.i(168276);
    s.u(paramSmileyPanel, "<set-?>");
    this.niv = paramSmileyPanel;
    AppMethodBeat.o(168276);
  }
  
  public final void setSwitchSceneAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(178477);
    s.u(paramImageView, "<set-?>");
    this.FZd = paramImageView;
    AppMethodBeat.o(178477);
  }
  
  public final void setSwitchSceneListener(kotlin.g.a.a<kotlin.ah> parama)
  {
    this.FZs = parama;
  }
  
  public final void setSwitchSceneName(TextView paramTextView)
  {
    AppMethodBeat.i(178479);
    s.u(paramTextView, "<set-?>");
    this.FZe = paramTextView;
    AppMethodBeat.o(178479);
  }
  
  public final void setSwitchSceneTip(View paramView)
  {
    AppMethodBeat.i(178481);
    s.u(paramView, "<set-?>");
    this.FZf = paramView;
    AppMethodBeat.o(178481);
  }
  
  public final void setSwitchSceneTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(178483);
    s.u(paramTextView, "<set-?>");
    this.FZg = paramTextView;
    AppMethodBeat.o(178483);
  }
  
  public final void setTargetAvatar(ImageView paramImageView)
  {
    AppMethodBeat.i(168286);
    s.u(paramImageView, "<set-?>");
    this.FZn = paramImageView;
    AppMethodBeat.o(168286);
  }
  
  public final void up(boolean paramBoolean)
  {
    AppMethodBeat.i(345594);
    getSwitchSceneTip().setVisibility(8);
    uq(paramBoolean);
    Object localObject = findViewById(e.e.comment_switch_scene_click_layout);
    if (fdk())
    {
      ((View)localObject).findViewById(e.e.comment_scene_btn).setVisibility(0);
      ((View)localObject).setOnClickListener(new FinderCommentFooter..ExternalSyntheticLambda3(this));
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
      AppMethodBeat.o(345594);
      return;
      ((View)localObject).setOnClickListener(FinderCommentFooter..ExternalSyntheticLambda6.INSTANCE);
      ((View)localObject).findViewById(e.e.comment_scene_btn).setVisibility(8);
    }
  }
  
  public final void uq(boolean paramBoolean)
  {
    AppMethodBeat.i(345601);
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
        aa.a(getContext(), (String)localObject1, FinderCommentFooter..ExternalSyntheticLambda8.INSTANCE);
      }
      AppMethodBeat.o(345601);
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
  
  public final void ur(final boolean paramBoolean)
  {
    AppMethodBeat.i(168290);
    if (this.FZq)
    {
      AppMethodBeat.o(168290);
      return;
    }
    getQuickPickEmoji().setVisibility(0);
    setSmileyIcon(false);
    getSmileyBtn().setTag(Boolean.FALSE);
    if (paramBoolean)
    {
      animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator()).setDuration(220L).translationY(this.FZp).setListener((Animator.AnimatorListener)new h(this, paramBoolean)).start();
      AppMethodBeat.o(168290);
      return;
    }
    getSmileyPanel().animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new i(this)).start();
    AppMethodBeat.o(168290);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$checkShowReplyBtn$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(344680);
      paramAnimator = this.GxU.getReplyBtn().getLayoutParams();
      paramAnimator.width = this.GxU.getReplyBtnWidth();
      this.GxU.getReplyBtn().setLayoutParams(paramAnimator);
      this.GxU.getReplyBtn().setAlpha(1.0F);
      AppMethodBeat.o(344680);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(344657);
      paramAnimator = this.GxU.getReplyBtn().getLayoutParams();
      paramAnimator.width = this.GxU.getReplyBtnWidth();
      this.GxU.getReplyBtn().setLayoutParams(paramAnimator);
      this.GxU.getReplyBtn().setAlpha(1.0F);
      AppMethodBeat.o(344657);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(344695);
      this.GxU.getReplyBtn().setVisibility(0);
      AppMethodBeat.o(344695);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$checkShowReplyBtn$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(344659);
      this.GxU.getReplyBtn().setVisibility(8);
      AppMethodBeat.o(344659);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(344654);
      this.GxU.getReplyBtn().setVisibility(8);
      AppMethodBeat.o(344654);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(344665);
      this.GxU.getReplyBtn().setVisibility(0);
      AppMethodBeat.o(344665);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$2$dialog$1", "Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "at", "", "displayName", "", "username", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.finder.ui.at.a
  {
    e(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void hM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(344670);
      s.u(paramString1, "displayName");
      s.u(paramString2, "username");
      FinderCommentFooter.a(this.GxU, paramString1, paramString2);
      AppMethodBeat.o(344670);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements TextWatcher
  {
    f(FinderCommentFooter paramFinderCommentFooter) {}
    
    private static final void e(FinderCommentFooter paramFinderCommentFooter)
    {
      AppMethodBeat.i(344483);
      s.u(paramFinderCommentFooter, "this$0");
      FinderCommentFooter.a(paramFinderCommentFooter, paramFinderCommentFooter.getEditText().getText());
      AppMethodBeat.o(344483);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(344495);
      this.GxU.getEditText().postDelayed(new FinderCommentFooter.f..ExternalSyntheticLambda0(this.GxU), 160L);
      AppMethodBeat.o(344495);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(344503);
      if ((this.GxU.getScene() == 2) && (paramInt3 == 1)) {
        if (paramCharSequence != null) {
          break label58;
        }
      }
      label58:
      for (paramInt1 = 32;; paramInt1 = paramCharSequence.charAt(paramInt1))
      {
        if ((paramInt1 == 64) && (FinderCommentFooter.fkt())) {
          this.GxU.getMentionBtn().performClick();
        }
        AppMethodBeat.o(344503);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onFinishInflate$textOperationListener$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ChatFooterPanel.a
  {
    g(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void aWL() {}
    
    public final void aWM()
    {
      AppMethodBeat.i(344493);
      if (this.GxU.getEditText().getInputConnection() != null)
      {
        this.GxU.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        this.GxU.getEditText().getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      }
      AppMethodBeat.o(344493);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(344485);
      this.GxU.getEditText().bDt(paramString);
      AppMethodBeat.o(344485);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements Animator.AnimatorListener
  {
    h(FinderCommentFooter paramFinderCommentFooter, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168269);
      this.GxU.getSmileyPanel().setVisibility(4);
      FinderCommentFooter.c(this.GxU);
      if (paramBoolean) {
        this.GxU.setFooterMode(0);
      }
      AppMethodBeat.o(168269);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements Animator.AnimatorListener
  {
    i(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168270);
      this.GxU.getSmileyPanel().setAlpha(1.0F);
      this.GxU.getSmileyPanel().setVisibility(4);
      AppMethodBeat.o(168270);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements Animator.AnimatorListener
  {
    j(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(344476);
      this.GxU.setFooterMode(2);
      FinderCommentFooter.c(this.GxU);
      this.GxU.getSmileyBtn().setTag(Boolean.FALSE);
      this.GxU.getSmileyPanel().setVisibility(4);
      this.GxU.getQuickPickEmoji().setVisibility(0);
      AppMethodBeat.o(344476);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onKeyboardHeightChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements Animator.AnimatorListener
  {
    k(FinderCommentFooter paramFinderCommentFooter) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(344480);
      this.GxU.setFooterMode(0);
      this.GxU.getQuickPickEmoji().setVisibility(4);
      this.GxU.ij("", "");
      AppMethodBeat.o(344480);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderCommentFooter$onShowSmileyPanel$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements View.OnLayoutChangeListener
  {
    l(FinderCommentFooter paramFinderCommentFooter, kotlin.g.a.a<kotlin.ah> parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(168273);
      this.GxU.getSmileyPanel().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      paramView.invoke();
      AppMethodBeat.o(168273);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "selectScene", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<Integer, kotlin.ah>
  {
    n(FinderCommentFooter paramFinderCommentFooter, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "selectScene", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.b<Integer, kotlin.ah>
  {
    o(FinderCommentFooter paramFinderCommentFooter, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCommentFooter
 * JD-Core Version:    0.7.0.1
 */