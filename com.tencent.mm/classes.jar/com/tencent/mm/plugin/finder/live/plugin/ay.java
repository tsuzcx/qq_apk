package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ae;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.cgi.x.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.model.ak.b;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.w.a;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.cf;
import com.tencent.mm.plugin.finder.live.ui.at.c;
import com.tencent.mm.plugin.finder.live.util.ai;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.r;
import kotlin.g.b.u;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "INPUT_MODE_DEFAULT", "", "INPUT_MODE_INPUT", "INPUT_MODE_SMILEY", "atContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "atWxContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$AtWxContact;", "Lkotlin/collections/ArrayList;", "atWxView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "cacheFinderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "cachePoiCity", "", "chosenWxUserName", "commentFailContent", "commentPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "getCommentPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "setCommentPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;)V", "context", "Landroid/content/Context;", "curMode", "emojiLayout", "Landroid/widget/LinearLayout;", "fastCommentInfoList", "fastCommentInputAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentInputAdapter;", "fastCommentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "inputEmoji", "Landroid/widget/ImageView;", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "inputLayout", "inputParent", "Landroid/view/View;", "isLocationInit", "", "isPoiNoPermission", "keyboardHeight", "lastPoiSendTime", "", "localCommentList", "locationGuideAnimator", "Landroid/animation/AnimatorSet;", "mounted", "needNotifySendMsgResult", "notifySendResultSessionId", "getNotifySendResultSessionId", "()J", "setNotifySendResultSessionId", "(J)V", "replyBtnWidth", "sendBtn", "Landroid/widget/TextView;", "sendBtnEnabled", "smileyPanel", "Lcom/tencent/mm/api/SmileyPanel;", "textLimitView", "addFastComment", "", "content", "addSelfComment", "clientMsgId", "adjustCommentPlugin", "cancelLocationGuideAnimator", "changeToInputMode", "atName", "extraMsg", "Landroid/os/Bundle;", "changeToPreviewMode", "notify", "checkAtWxContactInContent", "checkIfCanSendLocationMsg", "checkTextLimit", "dealWithErrCode", "errType", "errCode", "realNameUrl", "elseFunction", "Lkotlin/Function0;", "diffLocalCommentList", "fastCommentInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShortcutWordingInfo;", "doScreenClear", "clear", "doSendLocationMsg", "finderLocation", "getEditPanel", "getLocationForFastCommentItem", "getPoiInfo", "longitude", "", "latitude", "getPoiInfoError", "getSelfNickname", "handlePoiNoPermission", "initFastCommentRecyclerView", "initListener", "isInBoxRoom", "keyboardChange", "show", "height", "layoutInputView", "mount", "notifySendResult", "sessionId", "onAtSomeOne", "userName", "diaplayName", "onBackPress", "onHideSmileyPanel", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "forceShowVKB", "openAtGroupDialog", "resendFailComment", "sendAtMsg", "it", "isNeedNotifySendMsg", "notifySessionId", "sendFastCommentMsg", "index", "sendNormalMsg", "sendReplayMsg", "setAdapterPoiInfo", "setFastCommentItemClickListener", "commentItemClickListener", "Lkotlin/Function1;", "setPoiItemClickListener", "poiClickListener", "setVisible", "visible", "setupEmojiPanel", "showKVB", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "uninitListener", "updateFastCommentList", "AtWxContact", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  extends b
{
  public static final ay.f DcJ;
  private static final long Dde;
  private static final long Ddf;
  private final TextView DcK;
  private final WeImageView DcL;
  private AnimatorSet DcM;
  private boolean DcN;
  private final RecyclerView DcO;
  private com.tencent.mm.plugin.finder.live.view.adapter.p DcP;
  private final ArrayList<String> DcQ;
  private final ArrayList<String> DcR;
  public ah DcS;
  public String DcT;
  public bgh DcU;
  private boolean DcV;
  private long DcW;
  private long DcX;
  private String DcY;
  private boi DcZ;
  private boolean Dda;
  private ArrayList<ay.e> Ddb;
  private String Ddc;
  private boolean Ddd;
  private Context context;
  private final com.tencent.mm.live.b.b nfT;
  private final int nil;
  private final int nim;
  private final int nin;
  private final LinearLayout nio;
  private final LinearLayout nip;
  private final View niq;
  private final MMEditText nir;
  private final TextView nis;
  private final ImageView nit;
  private SmileyPanel niv;
  private int niw;
  private boolean nix;
  private int niy;
  private int sNb;
  
  static
  {
    AppMethodBeat.i(355369);
    DcJ = new ay.f((byte)0);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    long l = ((Number)com.tencent.d.a.a.a.a.a.jTS().bmg()).longValue();
    Dde = l;
    Ddf = l;
    AppMethodBeat.o(355369);
  }
  
  public ay(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354931);
    this.nfT = paramb;
    this.nim = 1;
    this.nin = 2;
    this.nio = ((LinearLayout)paramViewGroup.findViewById(p.e.live_input_layout));
    this.nip = ((LinearLayout)paramViewGroup.findViewById(p.e.live_emoji_layout));
    this.niq = paramViewGroup.findViewById(p.e.live_input_parent);
    this.nir = ((MMEditText)paramViewGroup.findViewById(p.e.live_input_txt));
    this.nis = ((TextView)paramViewGroup.findViewById(p.e.live_send_btn));
    this.nit = ((ImageView)paramViewGroup.findViewById(p.e.live_input_emoji));
    this.DcK = ((TextView)paramViewGroup.findViewById(p.e.BWO));
    this.DcL = ((WeImageView)paramViewGroup.findViewById(p.e.BWo));
    this.DcO = ((RecyclerView)paramViewGroup.findViewById(p.e.BWR));
    this.DcQ = new ArrayList();
    this.DcR = new ArrayList();
    paramb = ae.m(paramViewGroup.getContext(), true);
    kotlin.g.b.s.s(paramb, "getSmileyPanel(root.context, true)");
    this.niv = paramb;
    paramb = paramViewGroup.getContext();
    kotlin.g.b.s.s(paramb, "root.context");
    this.context = paramb;
    this.niy = this.nil;
    this.DcT = "";
    this.DcY = "";
    this.niy = this.nil;
    this.nit.setImageDrawable(bb.e(paramViewGroup.getContext().getResources().getDrawable(p.g.icons_filled_sticker), -1));
    this.nit.setOnClickListener(new ay..ExternalSyntheticLambda4(this));
    paramb = this.DcM;
    if (paramb != null) {
      paramb.cancel();
    }
    this.DcP = new com.tencent.mm.plugin.finder.live.view.adapter.p(this.context);
    this.DcO.setAdapter((RecyclerView.a)this.DcP);
    this.mJe.getContext();
    paramb = new LinearLayoutManager();
    paramb.setItemPrefetchEnabled(true);
    paramb.setOrientation(0);
    this.DcO.setLayoutManager((RecyclerView.LayoutManager)paramb);
    this.DcO.setItemAnimator((RecyclerView.f)new androidx.recyclerview.widget.f());
    paramb = (kotlin.g.a.a)new s(this);
    Object localObject = this.DcP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.adapter.p)localObject).DRc = paramb;
    }
    paramb = (kotlin.g.a.b)new t(this);
    kotlin.g.b.s.u(paramb, "commentItemClickListener");
    localObject = this.DcP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.adapter.p)localObject).nod = paramb;
    }
    paramb = this.DcP;
    if (paramb != null)
    {
      localObject = paramb.pUj;
      String str = paramb.context.getResources().getString(p.h.finder_live_fast_comment_location_tip);
      kotlin.g.b.s.s(str, "context.resources.getStr…ast_comment_location_tip)");
      ((ArrayList)localObject).add(new com.tencent.mm.plugin.finder.live.view.adapter.p.c(str));
      paramb.bZE.notifyChanged();
    }
    eqD();
    paramb = v.GgU;
    v.a((kotlin.g.a.a)new o(this), (kotlin.g.a.a)new p(this), (kotlin.g.a.a)new q(this));
    this.sNb = KeyBoardUtil.getKeyBordHeightPx(this.context);
    paramb = ay..ExternalSyntheticLambda2.INSTANCE;
    localObject = (InputFilter)new n(g.a.afII);
    this.nir.setFilters(new InputFilter[] { paramb, localObject });
    this.nir.setOnKeyListener(new ay..ExternalSyntheticLambda6(this));
    this.nir.addTextChangedListener((TextWatcher)new TextWatcher()
    {
      private static final void a(ay paramAnonymousay, ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(354906);
        kotlin.g.b.s.u(paramAnonymousay, "this$0");
        if (paramAnonymousValueAnimator == null) {}
        for (paramAnonymousValueAnimator = null; paramAnonymousValueAnimator == null; paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue())
        {
          paramAnonymousay = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(354906);
          throw paramAnonymousay;
        }
        float f = ((Integer)paramAnonymousValueAnimator).intValue();
        paramAnonymousValueAnimator = ay.t(paramAnonymousay).getLayoutParams();
        paramAnonymousValueAnimator.width = kotlin.h.a.eH(f);
        ay.t(paramAnonymousay).setLayoutParams(paramAnonymousValueAnimator);
        ay.t(paramAnonymousay).setAlpha(f / ay.s(paramAnonymousay));
        AppMethodBeat.o(354906);
      }
      
      private static final void b(ay paramAnonymousay, ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(354911);
        kotlin.g.b.s.u(paramAnonymousay, "this$0");
        if (paramAnonymousValueAnimator == null) {}
        for (paramAnonymousValueAnimator = null; paramAnonymousValueAnimator == null; paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue())
        {
          paramAnonymousay = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(354911);
          throw paramAnonymousay;
        }
        float f = ((Integer)paramAnonymousValueAnimator).intValue();
        paramAnonymousValueAnimator = ay.t(paramAnonymousay).getLayoutParams();
        paramAnonymousValueAnimator.width = kotlin.h.a.eH(f);
        ay.t(paramAnonymousay).setLayoutParams(paramAnonymousValueAnimator);
        ay.t(paramAnonymousay).setAlpha(f / ay.s(paramAnonymousay));
        AppMethodBeat.o(354911);
      }
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(354937);
        ay.q(this.Ddg);
        paramAnonymousEditable = ay.p(this.Ddg).getText();
        int i;
        if ((paramAnonymousEditable != null) && (((CharSequence)paramAnonymousEditable).length() > 0))
        {
          i = 1;
          if (i == 0) {
            break label105;
          }
          paramAnonymousEditable = ay.p(this.Ddg).getText();
          if ((paramAnonymousEditable == null) || (n.bp((CharSequence)paramAnonymousEditable))) {
            break label100;
          }
          i = 1;
          label72:
          if (i == 0) {
            break label105;
          }
        }
        label100:
        label105:
        for (boolean bool = true;; bool = false)
        {
          if (bool != ay.r(this.Ddg)) {
            break label110;
          }
          AppMethodBeat.o(354937);
          return;
          i = 0;
          break;
          i = 0;
          break label72;
        }
        label110:
        ay.a(this.Ddg, bool);
        if (ay.r(this.Ddg))
        {
          paramAnonymousEditable = new ValueAnimator();
          paramAnonymousEditable.setIntValues(new int[] { 0, ay.s(this.Ddg) });
          paramAnonymousEditable.addUpdateListener(new ay.1..ExternalSyntheticLambda0(this.Ddg));
          paramAnonymousEditable.setDuration(150L);
          paramAnonymousEditable.addListener((Animator.AnimatorListener)new a(this.Ddg));
          paramAnonymousEditable.start();
          AppMethodBeat.o(354937);
          return;
        }
        paramAnonymousEditable = new ValueAnimator();
        paramAnonymousEditable.setIntValues(new int[] { ay.s(this.Ddg), 0 });
        paramAnonymousEditable.addUpdateListener(new ay.1..ExternalSyntheticLambda1(this.Ddg));
        paramAnonymousEditable.setDuration(150L);
        paramAnonymousEditable.addListener((Animator.AnimatorListener)new b(this.Ddg));
        paramAnonymousEditable.start();
        AppMethodBeat.o(354937);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(354946);
        if (paramAnonymousCharSequence == null) {
          paramAnonymousCharSequence = "";
        }
        for (;;)
        {
          if (kotlin.g.b.s.p(paramAnonymousCharSequence, "@")) {
            ay.u(this.Ddg).performClick();
          }
          AppMethodBeat.o(354946);
          return;
          String str = paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3).toString();
          paramAnonymousCharSequence = str;
          if (str == null) {
            paramAnonymousCharSequence = "";
          }
        }
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$afterTextChanged$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements Animator.AnimatorListener
      {
        a(ay paramay) {}
        
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(353509);
          paramAnimator = ay.t(this.Ddg).getLayoutParams();
          paramAnimator.width = ay.s(this.Ddg);
          ay.t(this.Ddg).setLayoutParams(paramAnimator);
          ay.t(this.Ddg).setAlpha(1.0F);
          AppMethodBeat.o(353509);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(353502);
          ay.t(this.Ddg).setVisibility(0);
          paramAnimator = ay.t(this.Ddg).getLayoutParams();
          paramAnimator.width = ay.s(this.Ddg);
          ay.t(this.Ddg).setLayoutParams(paramAnimator);
          ay.t(this.Ddg).setAlpha(1.0F);
          AppMethodBeat.o(353502);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(353515);
          ay.t(this.Ddg).setVisibility(0);
          AppMethodBeat.o(353515);
        }
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$3$afterTextChanged$4", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class b
        implements Animator.AnimatorListener
      {
        b(ay paramay) {}
        
        public final void onAnimationCancel(Animator paramAnimator)
        {
          AppMethodBeat.i(353501);
          ay.t(this.Ddg).setVisibility(8);
          AppMethodBeat.o(353501);
        }
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(353497);
          ay.t(this.Ddg).setVisibility(8);
          AppMethodBeat.o(353497);
        }
        
        public final void onAnimationRepeat(Animator paramAnimator) {}
        
        public final void onAnimationStart(Animator paramAnimator)
        {
          AppMethodBeat.i(353507);
          ay.t(this.Ddg).setVisibility(0);
          AppMethodBeat.o(353507);
        }
      }
    });
    if (isLandscape())
    {
      paramb = this.niq.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(354931);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bf.bk(paramViewGroup.getContext()));
    }
    this.nis.setOnClickListener(new ay..ExternalSyntheticLambda3(this));
    this.nio.setOnTouchListener(new ay..ExternalSyntheticLambda7(this));
    this.niv.setEntranceScene(ChatFooterPanel.XYy);
    this.niv.iKh();
    this.niv.iKi();
    this.niv.JA(false);
    this.niv.aBI();
    this.niv.setVisibility(4);
    this.niv.onResume();
    this.DcL.setOnClickListener(new ay..ExternalSyntheticLambda5(this));
    AppMethodBeat.o(354931);
  }
  
  private static final CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  private final void a(int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(354951);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new l(paramInt1, paramInt2, this, paramString1, paramString2, parama));
    AppMethodBeat.o(354951);
  }
  
  private static final void a(ay paramay, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(371441);
    kotlin.g.b.s.u(paramay, "this$0");
    paramDialogInterface = paramay.Ddc;
    if (paramDialogInterface == null)
    {
      paramDialogInterface = null;
      if (paramDialogInterface == null) {
        com.tencent.mm.plugin.finder.live.report.k.Doi.B(0, null);
      }
      paramay.Ddc = null;
      paramay.nir.postDelayed(new ay..ExternalSyntheticLambda11(paramay), 200L);
      AppMethodBeat.o(371441);
      return;
    }
    if (kotlin.g.b.s.p(paramDialogInterface, "notify@all")) {
      com.tencent.mm.plugin.finder.live.report.k.Doi.B(1, null);
    }
    for (;;)
    {
      paramDialogInterface = kotlin.ah.aiuX;
      break;
      com.tencent.mm.plugin.finder.live.report.k.Doi.B(2, kotlin.a.p.listOf(paramDialogInterface));
    }
  }
  
  private static final void a(ay paramay, View paramView)
  {
    AppMethodBeat.i(355040);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramay);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramay, "this$0");
    int i;
    if (paramay.niy != paramay.nin)
    {
      i = 1;
      if (i != 0) {
        break label159;
      }
      paramay.bjm();
      ((MMActivity)paramay.context).showVKB();
      label94:
      if (i == 0) {
        break label255;
      }
      paramay.nit.setImageDrawable(bb.e(paramay.mJe.getContext().getResources().getDrawable(p.g.icons_filled_keyboard), -1));
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355040);
      return;
      i = 0;
      break;
      label159:
      paramay.niv.setVisibility(0);
      paramay.nit.setImageDrawable(bb.e(paramay.mJe.getContext().getResources().getDrawable(p.g.icons_filled_keyboard), -1));
      paramay.niy = paramay.nin;
      paramay.niv.setAlpha(0.0F);
      paramay.niv.animate().alpha(1.0F).setDuration(220L).setListener(null).start();
      ((MMActivity)paramay.context).hideVKB();
      paramay.tQ(paramay.sNb);
      break label94;
      label255:
      paramay.nit.setImageDrawable(bb.e(paramay.mJe.getContext().getResources().getDrawable(p.g.icons_filled_sticker), -1));
    }
  }
  
  private final void a(ArrayList<ay.e> paramArrayList, final String paramString, final boolean paramBoolean, final long paramLong)
  {
    AppMethodBeat.i(371431);
    Object localObject1;
    Object localObject2;
    int i;
    if (!jdC())
    {
      localObject1 = com.tencent.mm.plugin.finder.live.cgi.x.CvN;
      localObject1 = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramArrayList.add(((ay.e)((Iterator)localObject1).next()).Ddj);
      }
      paramArrayList = x.a.k((List)paramArrayList, paramString.toString());
      localObject1 = new bui();
      localObject2 = aj.CGT;
      localObject2 = aj.egD();
      if (localObject2 == null)
      {
        i = 0;
        ((bui)localObject1).hLK = i;
        localObject2 = aj.CGT;
        localObject2 = aj.egD();
        if (localObject2 != null) {
          break label336;
        }
        i = 0;
        label148:
        ((bui)localObject1).AJo = i;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eea.add(paramArrayList.Tro);
        new com.tencent.mm.plugin.finder.live.cgi.x(paramArrayList, getBuContext(), (bui)localObject1, (r)new b(this, paramString, paramBoolean, paramLong)).bFJ();
        paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramArrayList = com.tencent.mm.plugin.finder.live.utils.a.a(paramArrayList, getBuContext());
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeb.add(paramArrayList);
        Log.i("Finder.LiveInputPlugin", "selfcomment add at msg, content:" + paramArrayList.getContent() + ", clientMsgId:" + paramArrayList.CER.Tro);
        b.b.a(this.nfT, b.c.ncJ);
      }
    }
    for (;;)
    {
      this.Ddb = null;
      AppMethodBeat.o(371431);
      return;
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject2).Bwy;
      if (localObject2 == null)
      {
        i = 0;
        break;
      }
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject2).AJo;
      break;
      label336:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject2).Bwy;
      if (localObject2 == null)
      {
        i = 0;
        break label148;
      }
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject2).AJo;
      break label148;
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
      localObject1 = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject2).akgQ.getValue();
      if (localObject1 == null) {
        localObject1 = "";
      }
      Object localObject3;
      for (;;)
      {
        localObject3 = bq.akii;
        localObject3 = bq.bLz((String)localObject1);
        Object localObject4 = ai.akfD;
        localObject4 = (Iterable)paramArrayList;
        paramArrayList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          paramArrayList.add(((ay.e)((Iterator)localObject4).next()).Ddj);
        }
        localObject1 = ((bfv)localObject1).id;
        if (localObject1 == null) {
          localObject1 = "";
        }
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject2).a((String)localObject1, ai.a((bfv)localObject3, (List)paramArrayList, paramString.toString()));
      paramArrayList = this.nfT;
      localObject1 = b.c.qMb;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("PARAM_FINDER_LIVE_BOX_MSG_TYPE", 20057);
      ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_BOX_MSG_CONTENT", paramString);
      paramString = kotlin.ah.aiuX;
      paramArrayList.statusChange((b.c)localObject1, (Bundle)localObject2);
    }
  }
  
  private static final boolean a(ay paramay, View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(355059);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramay);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramay, "this$0");
    int j;
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      j = paramay.nir.getSelectionEnd();
      paramKeyEvent = paramay.nir.getText();
      if (paramKeyEvent == null)
      {
        paramView = null;
        if (!kotlin.g.b.s.p(String.valueOf(paramView), " ")) {
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
        paramay.nir.setText((CharSequence)paramay.nir.getText().replace(paramInt, j, (CharSequence)""));
        paramay.nir.setSelection(paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(355059);
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
      com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(355059);
      return false;
      label297:
      paramInt = i;
    }
  }
  
  private static final boolean a(ay paramay, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(371439);
    kotlin.g.b.s.u(paramay, "this$0");
    Log.i("Finder.LiveInputPlugin", "onTouch");
    paramay.bjm();
    ((MMActivity)paramay.context).hideVKB();
    paramay.rq(true);
    AppMethodBeat.o(371439);
    return true;
  }
  
  private final void axa(String paramString)
  {
    AppMethodBeat.i(354949);
    Object localObject1;
    if (((CharSequence)paramString).length() == 0)
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = (Collection)this.Ddb;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label76;
        }
      }
    }
    label76:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label81;
      }
      paramString = this.Ddb;
      if (paramString != null) {
        paramString.clear();
      }
      AppMethodBeat.o(354949);
      return;
      i = 0;
      break;
    }
    label81:
    ArrayList localArrayList = new ArrayList();
    paramString = kotlin.n.k.b(new kotlin.n.k("@.*? "), (CharSequence)paramString).iterator();
    while (paramString.hasNext()) {
      localArrayList.add(n.d(n.c(((kotlin.n.i)paramString.next()).getValue(), (CharSequence)"@"), (CharSequence)" "));
    }
    paramString = this.Ddb;
    if (paramString == null) {}
    Collection localCollection;
    for (paramString = null;; paramString = new ArrayList((Collection)localCollection))
    {
      this.Ddb = paramString;
      AppMethodBeat.o(354949);
      return;
      paramString = (Iterable)paramString;
      localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramString.iterator();
      label288:
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        paramString = ((ay.e)localObject2).Ddj.contact;
        if (paramString == null) {
          paramString = "";
        }
        for (;;)
        {
          if (!localArrayList.contains(paramString)) {
            break label288;
          }
          localCollection.add(localObject2);
          break;
          localObject1 = paramString.nickname;
          paramString = (String)localObject1;
          if (localObject1 == null) {
            paramString = "";
          }
        }
      }
    }
  }
  
  private static final void b(ay paramay)
  {
    AppMethodBeat.i(371440);
    kotlin.g.b.s.u(paramay, "this$0");
    paramay.eqE();
    AppMethodBeat.o(371440);
  }
  
  private static final void b(ay paramay, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(371444);
    kotlin.g.b.s.u(paramay, "this$0");
    paramay.Ddc = null;
    paramay.nir.postDelayed(new ay..ExternalSyntheticLambda9(paramay), 200L);
    AppMethodBeat.o(371444);
  }
  
  private static final void b(ay paramay, View paramView)
  {
    AppMethodBeat.i(371438);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramay);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramay, "this$0");
    int i;
    label217:
    label222:
    long l;
    boolean bool;
    Object localObject3;
    if (paramay.nir.getText() != null)
    {
      paramay.bjm();
      ((MMActivity)paramay.context).hideVKB();
      paramView = paramay.nir.getText();
      if (paramView == null)
      {
        paramView = "";
        paramay.nir.setText(null);
        paramay.axa(paramView);
        localObject1 = aw.Gjk;
        localObject2 = aw.aBP(paramView);
        paramView = (CharSequence)localObject2;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label217;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label222;
        }
        paramay = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.hQ("Finder.LiveInputPlugin", "输入的内容为空");
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(371438);
        return;
        localObject1 = paramView.toString();
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramView = "";
        break;
      }
      paramView = ak.CHI;
      localObject1 = paramay.nfT;
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramay.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (paramView != null) {
        break label351;
      }
      paramView = null;
      ak.a((com.tencent.mm.live.b.b)localObject1, paramView.liveId, ak.b.CHN);
      l = paramay.DcW;
      bool = paramay.DcV;
      localObject3 = paramay.DcU;
      if (localObject3 != null) {
        break label359;
      }
      localObject1 = null;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        paramView = paramay.Ddb;
        if (paramView != null) {
          break label921;
        }
        paramView = null;
      }
    }
    for (;;)
    {
      if (paramView == null) {
        paramay.f((String)localObject2, bool, l);
      }
      a(paramay);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(371438);
      return;
      label351:
      paramView = paramView.liveInfo;
      break;
      label359:
      if (!paramay.jdC())
      {
        paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
        {
          com.tencent.mm.plugin.finder.live.report.j.Dob.Ph(2);
          label383:
          paramView = com.tencent.mm.plugin.finder.live.cgi.x.CvN;
          localObject1 = ((String)localObject2).toString();
          paramView = com.tencent.mm.live.core.core.f.mMm.bee();
          if (paramView != null) {
            break label691;
          }
          paramView = null;
          paramView = x.a.a((bgh)localObject3, (String)localObject1, paramView);
          localObject1 = new bui();
          localObject3 = aj.CGT;
          localObject3 = aj.egD();
          if (localObject3 != null) {
            break label699;
          }
          i = 0;
          ((bui)localObject1).hLK = i;
          localObject3 = aj.CGT;
          localObject3 = aj.egD();
          if (localObject3 != null) {
            break label725;
          }
          i = 0;
        }
        for (;;)
        {
          ((bui)localObject1).AJo = i;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramay.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eea.add(paramView.Tro);
          new com.tencent.mm.plugin.finder.live.cgi.x(paramView, paramay.getBuContext(), (bui)localObject1, (r)new ay.z(paramay, (String)localObject2, bool, l)).bFJ();
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          paramView = com.tencent.mm.plugin.finder.live.utils.a.a(paramView, paramay.getBuContext());
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramay.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeb.add(paramView);
          Log.i("Finder.LiveInputPlugin", "selfcomment add reply msg, content:" + paramView.getContent() + ", clientMsgId:" + paramView.CER.Tro);
          b.b.a(paramay.nfT, b.c.ncJ);
          paramay.DcU = null;
          localObject1 = kotlin.ah.aiuX;
          break;
          paramView = com.tencent.mm.plugin.finder.live.report.k.Doi;
          paramView = ((String)localObject2).toString();
          kotlin.g.b.s.u(paramView, "replyContent");
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("content", paramView);
          com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCx, ((JSONObject)localObject1).toString(), 0L, null, null, null, 60);
          com.tencent.mm.plugin.finder.live.report.k.DoE += 1;
          break label383;
          paramView = paramView.mNe;
          break label407;
          localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject3).Bwy;
          if (localObject3 == null)
          {
            i = 0;
            break label442;
          }
          i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject3).AJo;
          break label442;
          localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.g)localObject3).Bwy;
          if (localObject3 == null) {
            i = 0;
          } else {
            i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject3).AJo;
          }
        }
      }
      label407:
      label442:
      label699:
      label725:
      Object localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramay.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
      label691:
      paramView = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject4).akgQ.getValue();
      label783:
      bfv localbfv;
      if (paramView == null)
      {
        paramView = "";
        localObject1 = bq.akii;
        localbfv = bq.bLz(paramView);
        localObject1 = ai.akfD;
        localObject1 = com.tencent.mm.live.core.core.f.mMm.bee();
        if (localObject1 != null) {
          break label911;
        }
      }
      label911:
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.live.core.core.model.e)localObject1).mNe)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject4).a(paramView, ai.a(localbfv, (bgh)localObject3, (String)localObject2, (String)localObject1));
        paramView = paramay.nfT;
        localObject1 = b.c.qMb;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("PARAM_FINDER_LIVE_BOX_MSG_TYPE", 20057);
        ((Bundle)localObject3).putString("PARAM_FINDER_LIVE_BOX_MSG_CONTENT", (String)localObject2);
        localObject4 = kotlin.ah.aiuX;
        paramView.statusChange((b.c)localObject1, (Bundle)localObject3);
        break;
        localObject1 = paramView.id;
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label783;
        }
        paramView = "";
        break label783;
      }
      label921:
      if (!((Collection)paramView).isEmpty())
      {
        i = 1;
        label935:
        if (i == 0) {
          break label953;
        }
      }
      for (;;)
      {
        if (paramView != null) {
          break label958;
        }
        paramView = null;
        break;
        i = 0;
        break label935;
        label953:
        paramView = null;
      }
      label958:
      paramay.a(paramView, (String)localObject2, bool, l);
      paramView = kotlin.ah.aiuX;
    }
  }
  
  private final void bjm()
  {
    AppMethodBeat.i(354985);
    if (this.niv.getVisibility() != 0)
    {
      AppMethodBeat.o(354985);
      return;
    }
    this.nit.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(p.g.icons_filled_sticker), -1));
    this.niv.animate().alpha(0.0F).setDuration(220L).setListener((Animator.AnimatorListener)new w(this)).start();
    AppMethodBeat.o(354985);
  }
  
  private static final void c(ay paramay)
  {
    AppMethodBeat.i(371443);
    kotlin.g.b.s.u(paramay, "this$0");
    paramay.eqE();
    AppMethodBeat.o(371443);
  }
  
  private static final void c(ay paramay, View paramView)
  {
    AppMethodBeat.i(371442);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramay);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramay, "this$0");
    if (paramay.jdC())
    {
      if (paramay.DcU != null)
      {
        aa.dc(paramay.context, paramay.context.getResources().getString(p.h.Ctj));
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(371442);
        return;
      }
      paramView = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)paramay.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.getValue();
      if (paramView == null) {
        paramView = "";
      }
      for (;;)
      {
        paramView = new com.tencent.mm.plugin.finder.live.ui.at.i(paramView, paramay.context, Boolean.TRUE, (com.tencent.mm.plugin.finder.ui.at.a)new a(paramay));
        paramView.show();
        paramView.setOnDismissListener(new ay..ExternalSyntheticLambda0(paramay));
        break;
        paramView = paramView.id;
        if (paramView == null) {
          paramView = "";
        }
      }
    }
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramay.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI == 1) && (paramay.DcU == null))
    {
      paramView = new c(paramay.context, Boolean.TRUE, (com.tencent.mm.plugin.finder.ui.at.a)new d(paramay));
      paramView.show();
      paramView.setOnDismissListener(new ay..ExternalSyntheticLambda1(paramay));
      paramay = com.tencent.mm.plugin.finder.live.report.k.Doi;
      com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DDp, null, 0L, null, null, null, 60);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(371442);
      return;
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramay.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI == 1) {}
    for (paramView = paramay.context.getResources().getString(p.h.Ctj);; paramView = paramay.context.getResources().getString(p.h.Ctk))
    {
      kotlin.g.b.s.s(paramView, "if (business(LiveCommonS…ips_v2)\n                }");
      aa.dc(paramay.context, paramView);
      break;
    }
  }
  
  private static final void d(ay paramay)
  {
    AppMethodBeat.i(371445);
    kotlin.g.b.s.u(paramay, "this$0");
    paramay.eqE();
    AppMethodBeat.o(371445);
  }
  
  private final void eqD()
  {
    AppMethodBeat.i(354939);
    Object localObject3 = this.DcR;
    Object localObject1 = (bmw)kotlin.a.p.oL(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdT);
    Object localObject2;
    int i;
    label110:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      if ((((ArrayList)localObject3).size() == 0) && (((AbstractList)localObject2).size() == 0)) {
        break label336;
      }
      if (((ArrayList)localObject3).size() == ((AbstractList)localObject2).size()) {
        break label251;
      }
      ((ArrayList)localObject3).clear();
      ((ArrayList)localObject3).addAll((Collection)localObject2);
      i = 1;
      if (i == 0) {
        break label379;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll((Collection)this.DcR);
      localObject2 = ((Iterable)localObject1).iterator();
      j = 0;
      i = 0;
      label149:
      if (!((Iterator)localObject2).hasNext()) {
        break label341;
      }
      localObject3 = ((Iterator)localObject2).next();
      if (j < 0) {
        kotlin.a.p.kkW();
      }
      localObject3 = (String)localObject3;
      if ((!n.i((CharSequence)localObject3, (CharSequence)"<%@>")) || (j != ((ArrayList)localObject1).size() - 1)) {
        break label386;
      }
      com.tencent.mm.plugin.finder.live.view.adapter.p localp = this.DcP;
      if (localp != null) {
        localp.axY((String)localObject3);
      }
      ((ArrayList)localObject1).remove(localObject3);
      i = 1;
    }
    label386:
    for (;;)
    {
      j += 1;
      break label149;
      localObject1 = ((bmw)localObject1).YVU;
      break;
      label251:
      localObject1 = ((Iterable)localObject3).iterator();
      i = 0;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label336;
        }
        ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        if (!kotlin.g.b.s.p(((ArrayList)localObject3).get(i), ((AbstractList)localObject2).get(i)))
        {
          ((ArrayList)localObject3).clear();
          ((ArrayList)localObject3).addAll((Collection)localObject2);
          i = 1;
          break;
        }
        i += 1;
      }
      label336:
      i = 0;
      break label110;
      label341:
      if (i == 0)
      {
        localObject2 = this.DcP;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.live.view.adapter.p)localObject2).axY(null);
        }
      }
      localObject2 = this.DcP;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.live.view.adapter.p)localObject2).al((ArrayList)localObject1);
      }
      label379:
      AppMethodBeat.o(354939);
      return;
    }
  }
  
  private final void eqE()
  {
    AppMethodBeat.i(354992);
    this.nir.requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mJe.getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput((View)this.nir, 0);
    }
    AppMethodBeat.o(354992);
  }
  
  private final String eqF()
  {
    AppMethodBeat.i(355002);
    if (jdC())
    {
      localObject = ai.akfD;
      localObject = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.getValue();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((bfv)localObject).id)
      {
        localObject = ai.bkH((String)localObject);
        AppMethodBeat.o(355002);
        return localObject;
      }
    }
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject = d.a.auT(z.bAW());
      if (localObject == null)
      {
        AppMethodBeat.o(355002);
        return "";
      }
      localObject = ((m)localObject).dUr();
      if (localObject == null)
      {
        AppMethodBeat.o(355002);
        return "";
      }
      AppMethodBeat.o(355002);
      return localObject;
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DUe)
    {
      localObject = z.bAO();
      if (localObject == null)
      {
        AppMethodBeat.o(355002);
        return "";
      }
      AppMethodBeat.o(355002);
      return localObject;
    }
    localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.nickname;
    if (localObject == null)
    {
      AppMethodBeat.o(355002);
      return "";
    }
    AppMethodBeat.o(355002);
    return localObject;
  }
  
  private final void f(final String paramString, final boolean paramBoolean, final long paramLong)
  {
    AppMethodBeat.i(371430);
    Object localObject2;
    Object localObject4;
    if (!jdC())
    {
      localObject1 = aj.CGT;
      localObject1 = aj.getFinderLiveAssistant();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label295;
        }
        localObject1 = "";
      }
      label295:
      for (;;)
      {
        localObject2 = new bke();
        localObject3 = new bgh();
        localObject4 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        ((bgh)localObject3).contact = com.tencent.mm.plugin.finder.live.utils.a.p(getBuContext());
        ((bgh)localObject3).ZKa = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyL();
        localObject4 = kotlin.ah.aiuX;
        ((bke)localObject2).EbJ = ((bgh)localObject3);
        ((bke)localObject2).content = paramString;
        ((bke)localObject2).type = 1;
        ((bke)localObject2).kLn = ((String)localObject1);
        ((bke)localObject2).nickname = eqF();
        localObject3 = kotlin.ah.aiuX;
        localObject2 = new am((bke)localObject2);
        ((l)business(l.class)).EgE.add(localObject2);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeb.add(localObject2);
        Log.i("Finder.LiveInputPlugin", "selfcomment add comment msg, content:" + paramString + ", clientMsgId:" + (String)localObject1);
        paramString = com.tencent.mm.live.model.j.mXT;
        com.tencent.mm.live.model.j.bhf();
        b.b.a(this.nfT, b.c.ncJ);
        paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          break label418;
        }
        com.tencent.mm.plugin.finder.live.report.j.Dob.Ph(1);
        AppMethodBeat.o(371430);
        return;
        localObject1 = ((ap)localObject1).a(paramString, 1, (w.a)new c(this, paramString, paramBoolean, paramLong));
        break;
      }
    }
    Object localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
    Object localObject1 = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject3).akgQ.getValue();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject2 = bq.akii;
      localObject2 = bq.bLz((String)localObject1);
      localObject4 = ai.akfD;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject3).a((String)localObject1, ai.a((bfv)localObject2, paramString));
      localObject1 = this.nfT;
      localObject2 = b.c.qMb;
      localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("PARAM_FINDER_LIVE_BOX_MSG_TYPE", 20057);
      ((Bundle)localObject3).putString("PARAM_FINDER_LIVE_BOX_MSG_CONTENT", paramString);
      paramString = kotlin.ah.aiuX;
      ((com.tencent.mm.live.b.b)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
      label418:
      AppMethodBeat.o(371430);
      return;
      localObject2 = ((bfv)localObject1).id;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  private final boolean jdC()
  {
    AppMethodBeat.i(371434);
    Object localObject = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).akgQ.getValue();
    if (localObject != null)
    {
      localObject = ((bfv)localObject).id;
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() == 0) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(371434);
          return true;
        }
      }
    }
    AppMethodBeat.o(371434);
    return false;
  }
  
  private final void rq(boolean paramBoolean)
  {
    AppMethodBeat.i(355009);
    this.niy = this.nil;
    tO(4);
    this.nir.clearFocus();
    Object localObject = this.mJe.getContext().getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(355009);
      throw ((Throwable)localObject);
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(this.nir.getWindowToken(), 0);
    rr(false);
    if (paramBoolean) {
      this.mJe.post(new ay..ExternalSyntheticLambda10(this));
    }
    AppMethodBeat.o(355009);
  }
  
  private final void rr(boolean paramBoolean)
  {
    AppMethodBeat.i(355023);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcH = paramBoolean;
    com.tencent.mm.live.b.b localb = this.nfT;
    b.c localc = b.c.ndZ;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcH);
    kotlin.ah localah = kotlin.ah.aiuX;
    localb.statusChange(localc, localBundle);
    AppMethodBeat.o(355023);
  }
  
  private final void tQ(int paramInt)
  {
    AppMethodBeat.i(355030);
    Object localObject1;
    label112:
    label116:
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.mJe.getContext() instanceof Activity))
    {
      localObject1 = this.niq.getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(355030);
        throw ((Throwable)localObject1);
      }
      Object localObject2 = (LinearLayout.LayoutParams)localObject1;
      int i;
      if (!isLandscape())
      {
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = (bf.bk(this.context) + paramInt);
        this.niq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (com.tencent.mm.plugin.finder.live.gala.b.b)getPlugin(com.tencent.mm.plugin.finder.live.gala.b.b.class);
        if (localObject1 == null) {
          break label179;
        }
        if (((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() != 0) {
          break label174;
        }
        i = 1;
        if (i == 0) {
          break label179;
        }
        if (localObject1 != null) {
          break label184;
        }
        localObject1 = (b)this.DcS;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.live.b.a)localObject1).mJe.getLayoutParams();
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(355030);
            throw ((Throwable)localObject1);
            ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt;
            break;
            label174:
            i = 0;
            break label112;
            label179:
            localObject1 = null;
            break label116;
            label184:
            localObject1 = (b)localObject1;
            continue;
          }
          localLayoutParams = (RelativeLayout.LayoutParams)localObject2;
          if (isLandscape()) {
            break label325;
          }
          localLayoutParams.bottomMargin = (bf.bk(this.context) + paramInt + this.niq.getHeight() + this.context.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.finder.live.p.c.Edge_A));
          ((com.tencent.mm.live.b.a)localObject1).mJe.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      localObject1 = new LinearLayout.LayoutParams(-1, paramInt);
      if (isLandscape()) {
        break label358;
      }
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = bf.bk(this.context);
    }
    for (;;)
    {
      this.niv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.niv.getParent() == null) {
        this.nip.addView((View)this.niv, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(355030);
      return;
      label325:
      localLayoutParams.bottomMargin = (this.niq.getHeight() + paramInt + this.context.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.finder.live.p.c.Edge_2A) * 2);
      break;
      label358:
      ((LinearLayout.LayoutParams)localObject1).setMarginEnd(bf.bk(this.context));
    }
  }
  
  private static final void v(ay paramay)
  {
    AppMethodBeat.i(371446);
    kotlin.g.b.s.u(paramay, "this$0");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_IS_ENTERING_COMMENT", false);
    paramay.nfT.statusChange(b.c.ncO, localBundle);
    AppMethodBeat.o(371446);
  }
  
  public final void keyboardChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(355502);
    super.keyboardChange(paramBoolean, paramInt);
    if ((paramInt > 0) && (paramInt != this.sNb)) {
      this.sNb = paramInt;
    }
    if (!paramBoolean)
    {
      if (this.niy == this.nim)
      {
        this.niy = this.nil;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.niv.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        tQ(0);
        AppMethodBeat.o(355502);
      }
    }
    else
    {
      this.niy = this.nim;
      bjm();
      tQ(paramInt);
    }
    AppMethodBeat.o(355502);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355511);
    super.mount();
    this.niv.setOnTextOperationListener((ChatFooterPanel.a)new u(this));
    this.Dda = true;
    int i = (int)StaticLayout.getDesiredWidth(this.nis.getText(), this.nis.getPaint());
    this.niw = kotlin.k.k.qu(bd.bs(this.context, com.tencent.mm.plugin.finder.live.p.c.Edge_7A), i + this.nis.getPaddingStart() + this.nis.getPaddingEnd());
    AppMethodBeat.o(355511);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(355526);
    if (this.mJe.getVisibility() == 0)
    {
      if (this.niy == this.nin)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.niv.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        this.niy = this.nil;
        tQ(0);
      }
      for (;;)
      {
        AppMethodBeat.o(355526);
        return true;
        a(this);
      }
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(355526);
    return bool;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355497);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    boolean bool;
    label157:
    label172:
    label195:
    bgh localbgh;
    switch (g.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(355497);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      tO(8);
      Util.hideVKB((View)this.nir);
      AppMethodBeat.o(355497);
      return;
    case 5: 
      if (paramBundle == null)
      {
        bool = false;
        this.DcV = bool;
        if (!this.DcV) {
          break;
        }
        if (paramBundle != null) {
          break label157;
        }
      }
      for (paramc = null;; paramc = Long.valueOf(paramBundle.getLong("PARAM_FINDER_LIVE_SEND_MSG_SESSION_ID", 0L)))
      {
        if (paramc != null) {
          break label172;
        }
        paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(355497);
        throw paramc;
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_NEED_NOTIFY_SEND_MSG_RESULT", false);
        break;
      }
      this.DcW = paramc.longValue();
      this.DcL.setVisibility(0);
      if (paramBundle == null)
      {
        bool = false;
        if (!bool) {
          break label901;
        }
        if (paramBundle == null) {
          break label920;
        }
        paramc = paramBundle.getByteArray("PARAM_ENTER_COMMENT_AT_NAME");
        if (paramc == null) {
          break label920;
        }
        localbgh = new bgh();
        localbgh.parseFrom(paramc);
      }
      break;
    }
    for (;;)
    {
      tO(0);
      this.nit.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(p.g.icons_filled_sticker), -1));
      label272:
      Object localObject1;
      int i;
      if (paramBundle == null)
      {
        paramc = "";
        if (paramBundle != null) {
          paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT", false);
        }
        rr(true);
        if (localbgh != null) {
          break label479;
        }
        localObject1 = null;
        if (localObject1 == null)
        {
          localObject1 = (ay)this;
          if (((CharSequence)paramc).length() != 0) {
            break label849;
          }
          i = 1;
          label323:
          if (i == 0) {
            break label859;
          }
          paramc = (CharSequence)((ay)localObject1).nir.getText();
          if ((paramc != null) && (paramc.length() != 0)) {
            break label854;
          }
          i = 1;
          label354:
          if (i != 0)
          {
            this.nir.setHint((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)kotlin.g.b.s.X(eqF(), ":")));
            this.nir.setText(null);
          }
          label396:
          ((ay)localObject1).DcU = null;
          ((ay)localObject1).eqE();
        }
        if (paramBundle != null) {
          break label874;
        }
      }
      label479:
      label874:
      for (bool = false;; bool = paramBundle.getBoolean("PARAM_ENTER_COMMENT_HIDE_AT_ENTRANCE"))
      {
        if (!bool) {
          break label886;
        }
        this.DcL.setVisibility(8);
        AppMethodBeat.o(355497);
        return;
        this.DcW = 0L;
        break;
        bool = paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT");
        break label195;
        localObject1 = paramBundle.getString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG");
        paramc = (b.c)localObject1;
        if (localObject1 != null) {
          break label272;
        }
        paramc = "";
        break label272;
        label500:
        Object localObject2;
        Context localContext1;
        Resources localResources;
        Object localObject3;
        com.tencent.mm.plugin.h localh;
        Context localContext2;
        TextPaint localTextPaint;
        if (this.DcU != null)
        {
          localObject1 = this.DcU;
          if (localObject1 != null) {
            break label787;
          }
          localObject1 = null;
          localObject2 = localbgh.contact;
          if (localObject2 != null) {
            break label815;
          }
          localObject2 = null;
          if (kotlin.g.b.s.p(localObject1, localObject2)) {}
        }
        else
        {
          localContext1 = this.context;
          localResources = this.context.getResources();
          i = p.h.Csh;
          localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
          kotlin.g.b.s.s(localObject1, "service(IFinderCommonService::class.java)");
          localObject1 = (com.tencent.mm.plugin.h)localObject1;
          localObject2 = this.mJe.getContext();
          kotlin.g.b.s.s(localObject2, "root.context");
          localObject3 = this.nir.getPaint();
          kotlin.g.b.s.s(localObject3, "inputEt.paint");
          localObject3 = h.a.a((com.tencent.mm.plugin.h)localObject1, (Context)localObject2, (TextPaint)localObject3, (CharSequence)eqF());
          localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
          kotlin.g.b.s.s(localObject1, "service(IFinderCommonService::class.java)");
          localh = (com.tencent.mm.plugin.h)localObject1;
          localContext2 = this.mJe.getContext();
          kotlin.g.b.s.s(localContext2, "root.context");
          localTextPaint = this.nir.getPaint();
          kotlin.g.b.s.s(localTextPaint, "inputEt.paint");
          localObject1 = localbgh.contact;
          if (localObject1 != null) {
            break label825;
          }
          localObject1 = "";
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.b(localContext1, (CharSequence)localResources.getString(i, new Object[] { localObject3, h.a.a(localh, localContext2, localTextPaint, (CharSequence)localObject1) }));
          this.nir.setHint((CharSequence)localObject1);
          this.nir.setText(null);
          this.DcU = localbgh;
          localObject1 = Boolean.valueOf(this.nir.postDelayed(new ay..ExternalSyntheticLambda8(this), 100L));
          break;
          localObject1 = ((bgh)localObject1).contact;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label500;
          }
          localObject1 = ((FinderContact)localObject1).nickname;
          break label500;
          localObject2 = ((FinderContact)localObject2).nickname;
          break label515;
          localObject2 = ((FinderContact)localObject1).nickname;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
        i = 0;
        break label323;
        i = 0;
        break label354;
        ((ay)localObject1).nir.setText((CharSequence)paramc);
        break label396;
      }
      label515:
      label787:
      label815:
      label825:
      label849:
      label854:
      label859:
      label886:
      this.DcL.setVisibility(0);
      AppMethodBeat.o(355497);
      return;
      label901:
      rq(false);
      AppMethodBeat.o(355497);
      return;
      eqD();
      break;
      label920:
      localbgh = null;
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355470);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w("Finder.LiveInputPlugin", "setVisible return for isTeenMode");
      AppMethodBeat.o(355470);
      return;
    }
    super.tO(paramInt);
    AppMethodBeat.o(355470);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355520);
    super.unMount();
    this.niv.setOnTextOperationListener(null);
    this.Dda = false;
    AppMethodBeat.o(355520);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$openAtGroupDialog$dialog$1", "Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "at", "", "displayName", "", "username", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.finder.ui.at.a
  {
    a(ay paramay) {}
    
    public final void hM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(371357);
      kotlin.g.b.s.u(paramString1, "displayName");
      kotlin.g.b.s.u(paramString2, "username");
      ay.c(this.Ddg, paramString2);
      ay.a(this.Ddg, paramString2, paramString1);
      AppMethodBeat.o(371357);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements r<Integer, Integer, String, bsq, kotlin.ah>
  {
    b(ay paramay, String paramString, boolean paramBoolean, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$sendNormalMsg$clientMsgId$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements w.a
  {
    c(ay paramay, String paramString, boolean paramBoolean, long paramLong) {}
    
    public final void a(int paramInt1, int paramInt2, bst parambst)
    {
      AppMethodBeat.i(371362);
      kotlin.g.b.s.u(parambst, "resp");
      ay.a(this.Ddg, paramInt1, paramInt2, paramString.toString(), parambst.Vpy);
      if ((ay.f(this.Ddg).getLiveRole() == 0) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFh, paramString.toString());
        ay.a(this.Ddg, paramBoolean, paramLong, paramString);
      }
      AppMethodBeat.o(371362);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$6$dialog$1", "Lcom/tencent/mm/plugin/finder/ui/at/AtSomeoneCallback;", "at", "", "displayName", "", "username", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.finder.ui.at.a
  {
    d(ay paramay) {}
    
    public final void hM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(353721);
      kotlin.g.b.s.u(paramString1, "displayName");
      kotlin.g.b.s.u(paramString2, "username");
      ay.c(this.Ddg, paramString2);
      ay.a(this.Ddg, paramString2, paramString1);
      AppMethodBeat.o(353721);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    h(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    i(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    j(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$checkTextLimit$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements c.a
  {
    k(ay paramay) {}
    
    public final void Tw(String paramString)
    {
      AppMethodBeat.i(353759);
      int i = com.tencent.mm.ui.tools.g.ej(120, paramString);
      if (i > 5)
      {
        ay.g(this.Ddg).setVisibility(8);
        AppMethodBeat.o(353759);
        return;
      }
      ay.g(this.Ddg).setText((CharSequence)String.valueOf(i));
      ay.g(this.Ddg).setTextColor(ay.h(this.Ddg).getResources().getColor(p.b.BW_100_Alpha_0_5));
      ay.g(this.Ddg).setVisibility(0);
      AppMethodBeat.o(353759);
    }
    
    public final void Tx(String paramString)
    {
      AppMethodBeat.i(353748);
      ay.g(this.Ddg).setVisibility(8);
      AppMethodBeat.o(353748);
    }
    
    public final void eY(String paramString)
    {
      AppMethodBeat.i(353752);
      ay.g(this.Ddg).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.g.ej(120, paramString)));
      ay.g(this.Ddg).setTextColor(ay.h(this.Ddg).getResources().getColor(p.b.Red));
      ay.g(this.Ddg).setVisibility(0);
      AppMethodBeat.o(353752);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    l(int paramInt1, int paramInt2, ay paramay, String paramString1, String paramString2, kotlin.g.a.a<kotlin.ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements r<Integer, Integer, String, bsq, kotlin.ah>
  {
    m(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    extends com.tencent.mm.ui.tools.g
  {
    n(g.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(353762);
      Object localObject;
      if (paramSpanned == null)
      {
        paramInt2 = 0;
        if (paramInt2 <= paramInt3) {
          break label189;
        }
        if (paramSpanned != null) {
          break label174;
        }
        localObject = null;
        label26:
        paramInt2 = com.tencent.mm.ui.tools.g.a(String.valueOf(localObject), g.a.afII);
        label38:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label204;
        }
      }
      label174:
      label189:
      label204:
      for (paramInt3 = com.tencent.mm.ui.tools.g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.afII);; paramInt3 = 0)
      {
        paramInt4 = com.tencent.mm.ui.tools.g.a(String.valueOf(paramCharSequence), g.a.afII);
        int i = com.tencent.mm.ui.tools.g.bCA(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= 120) {
          break label228;
        }
        paramInt2 = kotlin.k.k.qu(120 - paramInt2 - paramInt3 - i, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label210;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(353762);
        return paramCharSequence;
        paramInt2 = paramSpanned.length();
        break;
        localObject = paramSpanned.subSequence(0, paramInt3);
        break label26;
        paramInt2 = com.tencent.mm.ui.tools.g.a(String.valueOf(paramSpanned), g.a.afII);
        break label38;
      }
      label210:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(353762);
      return paramCharSequence;
      label228:
      if (paramCharSequence == null)
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(353762);
        return paramCharSequence;
      }
      AppMethodBeat.o(353762);
      return paramCharSequence;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    o(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    p(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    q(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$getPoiInfo$1", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "onGetLbsLifes", "", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    implements a.a
  {
    r(ay paramay, float paramFloat1, float paramFloat2) {}
    
    public final void onGetLbsLifes(String paramString, List<dgz> paramList)
    {
      Object localObject2 = null;
      AppMethodBeat.i(353744);
      if (!ay.n(this.Ddg))
      {
        Log.i("Finder.LiveInputPlugin", "getPoiCityInfo: mounted = false");
        AppMethodBeat.o(353744);
        return;
      }
      Object localObject3 = new StringBuilder("getPoiCityInfo: onGetLbsLifes, city:").append(paramString).append(", list size:");
      if (paramList == null)
      {
        localObject1 = null;
        Log.i("Finder.LiveInputPlugin", localObject1);
        localObject1 = (CharSequence)paramString;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label127;
        }
      }
      label127:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label132;
        }
        ay.o(this.Ddg);
        AppMethodBeat.o(353744);
        return;
        localObject1 = Integer.valueOf(paramList.size());
        break;
      }
      label132:
      Object localObject1 = this.Ddg;
      localObject3 = v.GgU;
      if (paramList == null) {}
      for (paramList = localObject2;; paramList = (dgz)kotlin.a.p.oL(paramList))
      {
        ay.a((ay)localObject1, v.a(paramList, this.Ddo, this.Ddp, paramString));
        ay.b(this.Ddg, paramString);
        if (ay.k(this.Ddg) == null) {
          break;
        }
        ay.b(this.Ddg, ay.k(this.Ddg));
        AppMethodBeat.o(353744);
        return;
      }
      ay.o(this.Ddg);
      AppMethodBeat.o(353744);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    s(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "index", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.b<Integer, kotlin.ah>
  {
    t(ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$initListener$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class u
    implements ChatFooterPanel.a
  {
    u(ay paramay) {}
    
    public final void aWL() {}
    
    public final void aWM()
    {
      AppMethodBeat.i(353835);
      Object localObject = ay.p(this.Ddg);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        }
      }
      localObject = ay.p(this.Ddg);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null) {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
        }
      }
      AppMethodBeat.o(353835);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(353827);
      MMEditText localMMEditText = ay.p(this.Ddg);
      if ((localMMEditText != null) && (com.tencent.mm.ui.tools.g.a(localMMEditText.getText() + paramString, g.a.afII) <= 120)) {
        localMMEditText.bDt(paramString);
      }
      AppMethodBeat.o(353827);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    v(long paramLong, String paramString, ay paramay)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$onHideSmileyPanel$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class w
    implements Animator.AnimatorListener
  {
    w(ay paramay) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(353779);
      ay.i(this.Ddg).setAlpha(1.0F);
      ay.i(this.Ddg).setVisibility(4);
      AppMethodBeat.o(353779);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$sendFastCommentMsg$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class x
    implements w.a
  {
    x(ay paramay, String paramString, boolean paramBoolean, long paramLong) {}
    
    public final void a(int paramInt1, int paramInt2, bst parambst)
    {
      AppMethodBeat.i(353776);
      kotlin.g.b.s.u(parambst, "resp");
      ay.a(this.Ddg, paramInt1, paramInt2, this.nhk, parambst.Vpy);
      if ((ay.f(this.Ddg).getLiveRole() == 0) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFh, this.nhk);
        ay.a(this.Ddg, this.Ddh, this.Ddi, this.nhk);
      }
      AppMethodBeat.o(353776);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveInputPlugin$setAdapterPoiInfo$1", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "onGetLbsLifes", "", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class y
    implements a.a
  {
    y(ay paramay, float paramFloat1, float paramFloat2) {}
    
    public final void onGetLbsLifes(String paramString, List<dgz> paramList)
    {
      Object localObject2 = null;
      AppMethodBeat.i(353796);
      if (!ay.n(this.Ddg))
      {
        Log.i("Finder.LiveInputPlugin", "getPoiCityInfo: mounted = false");
        AppMethodBeat.o(353796);
        return;
      }
      Object localObject3 = new StringBuilder("getPoiCityInfo: onGetLbsLifes, city:").append(paramString).append(", list size:");
      if (paramList == null)
      {
        localObject1 = null;
        Log.i("Finder.LiveInputPlugin", localObject1);
        localObject1 = (CharSequence)paramString;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label120;
        }
      }
      label120:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label125;
        }
        AppMethodBeat.o(353796);
        return;
        localObject1 = Integer.valueOf(paramList.size());
        break;
      }
      label125:
      Object localObject1 = this.Ddg;
      localObject3 = v.GgU;
      if (paramList == null) {}
      for (paramList = localObject2;; paramList = (dgz)kotlin.a.p.oL(paramList))
      {
        ay.a((ay)localObject1, v.a(paramList, this.Ddo, this.Ddp, paramString));
        if (ay.k(this.Ddg) != null)
        {
          paramString = ay.l(this.Ddg);
          if (paramString != null) {
            paramString.a(ay.k(this.Ddg));
          }
        }
        AppMethodBeat.o(353796);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ay
 * JD-Core Version:    0.7.0.1
 */