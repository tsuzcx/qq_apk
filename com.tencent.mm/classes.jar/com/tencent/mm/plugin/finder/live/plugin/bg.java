package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.cgi.e.a;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.ab;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ap.a;
import com.tencent.mm.plugin.finder.live.model.cgi.al.a;
import com.tencent.mm.plugin.finder.live.model.i;
import com.tencent.mm.plugin.finder.live.olympic.report.a.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.ag;
import com.tencent.mm.plugin.finder.live.report.q.ao;
import com.tencent.mm.plugin.finder.live.report.q.aq;
import com.tencent.mm.plugin.finder.live.report.q.b;
import com.tencent.mm.plugin.finder.live.report.q.ba;
import com.tencent.mm.plugin.finder.live.report.q.bg;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.cf;
import com.tencent.mm.plugin.finder.live.report.q.d;
import com.tencent.mm.plugin.finder.live.report.q.e;
import com.tencent.mm.plugin.finder.live.report.q.k;
import com.tencent.mm.plugin.finder.live.report.q.l;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.report.q.z;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.utils.ba;
import com.tencent.mm.plugin.finder.utils.bc;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.h;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;)V", "SHEET_MORE_ACTION_AUDIO_LINK", "", "SHEET_MORE_ACTION_BAN_COMMENT", "SHEET_MORE_ACTION_BAN_LIKE", "SHEET_MORE_ACTION_CAMERA_STATUS", "SHEET_MORE_ACTION_CAST_SCREEN", "SHEET_MORE_ACTION_COST_TIME_LOG", "SHEET_MORE_ACTION_CUSTOMER_VIDEO_LEVEL", "SHEET_MORE_ACTION_DEBUG_BATTLE_DRAW", "SHEET_MORE_ACTION_DEBUG_BATTLE_LOSE", "SHEET_MORE_ACTION_DEBUG_BATTLE_WIN", "SHEET_MORE_ACTION_EDIT_DESC", "SHEET_MORE_ACTION_FANS_CLUB", "SHEET_MORE_ACTION_FAST_COMMENT", "SHEET_MORE_ACTION_GAME_TEAM_CLOSE", "SHEET_MORE_ACTION_GAME_TEAM_OPEN", "SHEET_MORE_ACTION_GIFT", "SHEET_MORE_ACTION_GIFTS_MOCK_SINGLE", "SHEET_MORE_ACTION_GIFTS_MOCK_TCASE", "SHEET_MORE_ACTION_HANDOFF", "SHEET_MORE_ACTION_LINK_MIC", "SHEET_MORE_ACTION_LIVE_DEBUG", "SHEET_MORE_ACTION_LIVE_PLAY_DESKTOP", "SHEET_MORE_ACTION_MINI_WINDOW", "SHEET_MORE_ACTION_MUTE", "SHEET_MORE_ACTION_PAUSE_LIVE", "SHEET_MORE_ACTION_REPORT", "SHEET_MORE_ACTION_SAVE_IMAGE", "SHEET_MORE_ACTION_SCREEN_CLEAR", "SHEET_MORE_ACTION_SHARE_2_FRIEMD", "SHEET_MORE_ACTION_SHARE_2_SNS", "SHEET_MORE_ACTION_SHARE_2_STATUS", "SHEET_MORE_ACTION_SHOW_DEBUG", "SHEET_MORE_ACTION_SHOW_STATISTICS", "SHEET_MORE_ACTION_SPLIT_SCREEN", "SHEET_MORE_ACTION_STOP_LINK", "SHEET_MORE_ACTION_VIDEO_LINK", "SHEET_MORE_ACTION_VISITOR_ANONYMOUS_DISABLE", "SHEET_MORE_ACTION_VISITOR_ANONYMOUS_ENABLE", "SHEET_MORE_ACTION_VISITOR_GIFT_EFFECT", "SHEET_MORE_ACTION_VISITOR_ROLE", "SHEET_MORE_ACTION_WIN_LOTTERY_RECORD", "TAG", "", "anchorBottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderLiveAnchorMoreActionBottomSheet;", "assistantBottomSheet", "autoShowPanel", "", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "enableLivePlayOnDesktop", "enableVisitorRoleEntrance", "hasAutoShowPanel", "isLiving", "isOlympic", "()Z", "isOlympic$delegate", "Lkotlin/Lazy;", "isOlympicCertificateShare", "setOlympicCertificateShare", "(Z)V", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "moreActionBtn", "Landroid/widget/RelativeLayout;", "moreActionIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "quickShareHelper", "Lcom/tencent/mm/pluginsdk/IRecentForwardMenuHelper;", "sndDeviceBottomSheet", "videoDefinitionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVideoDefinitionWidget;", "visitorZeroMenuClickListener", "visitorZeroMenuLongClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemLongSelectedListener;", "applyState", "", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "assembleMenuItemTitleSpan", "Landroid/text/SpannableString;", "title", "subTitle", "banComment", "menuItem", "Landroid/view/MenuItem;", "banLike", "buildAnchorBottomSheet", "buildAssistantBottomSheet", "buildConfirmDialog", "buildSecondDeviceBottomSheet", "buildVisitorBottomSheet", "canClearScreen", "checkAnchorSplitScreen", "checkCreateBox", "toUsers", "", "chooseVisitorRole", "dpToPx", "dp", "expose", "exposeImpl", "hideMoreActionBottomSheet", "isAssistant", "isVisitorAnonymousEnable", "isVisitorAnonymousSwitchOn", "miniWindow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "actionInfo", "extraData", "", "pauseLive", "postDelayForDialogDismiss", "action", "prepareAnchorMenu", "prepareAnchorMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareAnchorSecondMenuItems", "prepareAnchorZeroMenuItems", "prepareAssistantMenu", "prepareLinkMenuItems", "prepareSndDeviceMenu", "prepareSndDeviceSecondMenuItems", "prepareVisitorMenu", "prepareVisitorMenuItems", "prepareVisitorSecondMenuItems", "save2Image", "screenClearAction", "setGameTeam", "open", "setJumpWithoutMiniWindow", "share2ChatGroup", "params", "share2Friend", "share2FriendImpl", "share2SNS", "share2SNSImpl", "share2Status", "share2StatusImpl", "showDebugLiveInfo", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "switchVisitorAnonymous", "isEnable", "try2ReplayLiveInfo", "sourceObject", "destLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "unMount", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
  extends b
{
  public static final bg.a Dfv;
  private static final String DgA;
  private static final String DgB;
  private static final String DgC;
  private static final String Dgy;
  private static final String Dgz;
  private final int DeO;
  private final int DeR;
  private final int DfA;
  private final int DfB;
  private final int DfC;
  private final int DfD;
  private final int DfE;
  private final int DfF;
  private final int DfG;
  private final int DfH;
  private final int DfI;
  private final int DfJ;
  private final int DfK;
  private final int DfL;
  private final int DfM;
  private final int DfN;
  private final int DfO;
  private final int DfP;
  private final int DfQ;
  private final int DfR;
  private final int DfS;
  private final int DfT;
  private final int DfU;
  private final int DfV;
  private final int DfW;
  private final int DfX;
  private final int DfY;
  private final int DfZ;
  private final int Dfw;
  private final int Dfx;
  private final int Dfy;
  private final int Dfz;
  private final int Dga;
  private final int Dgb;
  private final int Dgc;
  private final int Dgd;
  private final int Dge;
  private final int Dgf;
  private final int Dgg;
  private final int Dgh;
  private final int Dgi;
  private boolean Dgj;
  private boolean Dgk;
  private final RelativeLayout Dgl;
  private final WeImageView Dgm;
  private com.tencent.mm.plugin.finder.view.j Dgn;
  private com.tencent.mm.plugin.finder.view.j Dgo;
  private com.tencent.mm.plugin.finder.view.j Dgp;
  private com.tencent.mm.pluginsdk.q Dgq;
  private boolean Dgr;
  private boolean Dgs;
  private final kotlin.j Dgt;
  private com.tencent.mm.plugin.finder.live.widget.bd Dgu;
  private u.i Dgv;
  private final u.i Dgw;
  private final u.h Dgx;
  private final String TAG;
  private final MMActivity activity;
  private final com.tencent.mm.live.b.b nfT;
  private com.tencent.mm.ui.widget.a.f ngn;
  private boolean njA;
  
  static
  {
    AppMethodBeat.i(355815);
    Dfv = new bg.a((byte)0);
    Dgy = "PORTRAIT_ACTION_SHARE_2_FRIEND";
    Dgz = "PORTRAIT_ACTION_SHARE_2_SNS";
    DgA = "PORTRAIT_ACTION_SHARE_2_STATUS";
    DgB = "PORTRAIT_ACTION_EXPOSE";
    DgC = "PORTRAIT_ACTION_VISITOR_MODE";
    AppMethodBeat.o(355815);
  }
  
  public bg(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, MMActivity paramMMActivity)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355223);
    this.nfT = paramb;
    this.activity = paramMMActivity;
    this.TAG = "Finder.FinderLiveMoreActionPlugin";
    this.Dfx = 1;
    this.Dfy = 2;
    this.DeO = 3;
    this.Dfz = 4;
    this.DfA = 5;
    this.DeR = 6;
    this.DfB = 8;
    this.DfC = 9;
    this.DfD = 10;
    this.DfE = 11;
    this.DfF = 12;
    this.DfG = 13;
    this.DfH = 14;
    this.DfI = 15;
    this.DfJ = 16;
    this.DfK = 17;
    this.DfL = 18;
    this.DfM = 20;
    this.DfN = 21;
    this.DfO = 22;
    this.DfP = 23;
    this.DfQ = 26;
    this.DfR = 27;
    this.DfS = 24;
    this.DfT = 25;
    this.DfU = 28;
    this.DfV = 29;
    this.DfW = 30;
    this.DfX = 500;
    this.DfY = 501;
    this.DfZ = 502;
    this.Dga = 1000;
    this.Dgb = 1001;
    this.Dgc = 1002;
    this.Dgd = 1003;
    this.Dge = 1004;
    this.Dgf = 1005;
    this.Dgg = 1006;
    this.Dgh = 1007;
    this.Dgi = 1008;
    this.Dgj = true;
    this.Dgk = true;
    paramb = paramViewGroup.findViewById(p.e.BOQ);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…ve_more_action_btn_group)");
    this.Dgl = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(p.e.BOP);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…der_live_more_action_btn)");
    this.Dgm = ((WeImageView)paramb);
    this.Dgt = kotlin.k.cm((kotlin.g.a.a)new e(this));
    paramb = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    this.Dgj = com.tencent.mm.plugin.finder.live.utils.a.euD();
    paramb = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    this.Dgk = com.tencent.mm.plugin.finder.live.utils.a.euK();
    this.Dgl.setOnClickListener(new bg..ExternalSyntheticLambda0(this));
    paramb = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
    if (this.activity.getIntent().getIntExtra("KEY_PARAMS_DO_ACTION", 0) == 1) {
      this.Dgr = true;
    }
    paramb = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (((e)business(e.class)).DUe)) {
      this.Dgm.setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.icons_filled_more, -1));
    }
    for (;;)
    {
      Log.i(this.TAG, kotlin.g.b.s.X("enableVisitorRoleEntrance:", Boolean.valueOf(this.Dgj)));
      this.Dgv = new bg..ExternalSyntheticLambda18(this, paramViewGroup);
      this.Dgw = new bg..ExternalSyntheticLambda19(this, paramViewGroup);
      this.Dgx = new bg..ExternalSyntheticLambda17(this);
      AppMethodBeat.o(355223);
      return;
      paramb = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUr().bmg()).intValue() == 0) {
        this.Dgm.setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.finder_full_share_new, -1));
      } else {
        this.Dgm.setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.icons_filled_more, -1));
      }
    }
  }
  
  private static final void PW(boolean paramBoolean)
  {
    AppMethodBeat.i(371462);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.rU(paramBoolean);
    ce localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    q.s locals = q.s.Duu;
    if (paramBoolean) {}
    for (localObject = "1";; localObject = "0")
    {
      localce.a(locals, ak.f(new kotlin.r[] { new kotlin.r("button_click_type", localObject) }));
      AppMethodBeat.o(371462);
      return;
    }
  }
  
  private static final void a(bg parambg)
  {
    AppMethodBeat.i(371476);
    kotlin.g.b.s.u(parambg, "this$0");
    b.b.a(parambg.nfT, b.c.nec);
    parambg.Dgo = null;
    AppMethodBeat.o(371476);
  }
  
  private static final void a(bg parambg, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(371475);
    kotlin.g.b.s.u(parambg, "this$0");
    com.tencent.mm.ui.widget.a.f localf = parambg.ngn;
    FinderObject localFinderObject = ((e)parambg.business(e.class)).Eco;
    if ((localf != null) && (localFinderObject != null))
    {
      parambg = parambg.Dgq;
      if (parambg != null)
      {
        if (paramMenuItem == null)
        {
          parambg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
          AppMethodBeat.o(371475);
          throw parambg;
        }
        parambg.a(localf, (t)paramMenuItem);
      }
    }
    AppMethodBeat.o(371475);
  }
  
  private static final void a(bg parambg, View paramView)
  {
    AppMethodBeat.i(371459);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambg);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambg, "this$0");
    paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
    com.tencent.mm.plugin.finder.live.report.j.axq(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZr.aaNn + '_' + System.currentTimeMillis());
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject1 = q.s.Dui;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      paramView.a((q.s)localObject1, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      paramView = (n.e)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.n)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.class)).Ehd.getValue();
      if ((paramView != null) && (parambg.ere()) && (paramView.EhI))
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.n)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.class);
        localObject2 = new brs();
        ((brs)localObject2).ZVq = String.valueOf(paramView.CPl);
        ((brs)localObject2).ZVr = paramView.akhd;
        paramView = com.tencent.mm.plugin.finder.api.d.AwY;
        paramView = d.a.auT(z.bAW());
        if (paramView != null) {
          break label315;
        }
      }
    }
    label315:
    for (paramView = null;; paramView = paramView.dUs())
    {
      ((brs)localObject2).ZVs = paramView;
      paramView = ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.n)localObject1).Ehf = ((brs)localObject2);
      b.b.a(parambg.nfT, b.c.neb);
      parambg.activity.getIntent().putExtra("KEY_PARAMS_DO_ACTION", 0);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(371459);
      return;
      ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Dui);
      break;
    }
  }
  
  private static final void a(final bg parambg, ViewGroup paramViewGroup, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(371473);
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramViewGroup, "$root");
    if (paramMenuItem == null)
    {
      ??? = null;
      paramInt = parambg.Dfw;
      if (??? != null) {
        break label422;
      }
      label37:
      paramInt = parambg.Dfx;
      if (??? != null) {
        break label643;
      }
      label47:
      paramInt = parambg.Dfy;
      if (??? != null) {
        break label860;
      }
      label57:
      paramInt = parambg.DfW;
      if (??? != null) {
        break label1028;
      }
      label67:
      paramInt = parambg.DeO;
      if (??? != null) {
        break label1087;
      }
      label77:
      paramInt = parambg.DfL;
      if (??? != null) {
        break label1640;
      }
      label87:
      paramInt = parambg.Dfz;
      if (??? != null) {
        break label2155;
      }
      label97:
      paramInt = parambg.DfJ;
      if (??? != null) {
        break label2437;
      }
      label107:
      paramInt = parambg.DfK;
      if (??? != null) {
        break label2462;
      }
      label117:
      paramInt = parambg.DfQ;
      if (??? != null) {
        break label2487;
      }
      label127:
      paramInt = parambg.DfR;
      if (??? != null) {
        break label2714;
      }
      label137:
      paramInt = parambg.DeR;
      if (??? != null) {
        break label2739;
      }
      label147:
      paramInt = parambg.DfA;
      if (??? != null) {
        break label2852;
      }
      label157:
      paramInt = parambg.DfP;
      if (??? != null) {
        break label2973;
      }
      label167:
      paramInt = parambg.Dga;
      if (??? != null) {
        break label3341;
      }
      label177:
      paramInt = parambg.Dgb;
      if (??? != null) {
        break label3445;
      }
      label187:
      paramInt = parambg.Dgd;
      if (??? != null) {
        break label3511;
      }
      label197:
      paramInt = parambg.Dge;
      if (??? != null) {
        break label3541;
      }
      label207:
      paramInt = parambg.Dgc;
      if (??? != null) {
        break label3632;
      }
      label217:
      paramInt = parambg.DfB;
      if (??? != null) {
        break label3662;
      }
      label227:
      paramInt = parambg.DfC;
      if (??? != null) {
        break label3859;
      }
      label237:
      paramInt = parambg.DfD;
      if (??? != null) {
        break label4276;
      }
      label247:
      paramInt = parambg.DfE;
      if (??? != null) {
        break label4788;
      }
      label257:
      paramInt = parambg.DfU;
      if (??? != null) {
        break label4808;
      }
      label267:
      paramInt = parambg.DfG;
      if (??? != null) {
        break label4962;
      }
      label277:
      paramInt = parambg.DfN;
      if (??? != null) {
        break label5058;
      }
      label287:
      paramInt = parambg.DfI;
      if (??? != null) {
        break label5248;
      }
      label297:
      paramInt = parambg.DfH;
      if (??? != null) {
        break label5490;
      }
      label307:
      paramInt = parambg.Dgf;
      if (??? != null) {
        break label5676;
      }
      label317:
      paramInt = parambg.Dgg;
      if (??? != null) {
        break label5747;
      }
      label327:
      paramInt = parambg.Dgh;
      if (??? != null) {
        break label5818;
      }
      label337:
      paramInt = parambg.Dgi;
      if (??? != null) {
        break label5889;
      }
      label347:
      paramInt = parambg.DfM;
      if (??? != null) {
        break label5988;
      }
      label357:
      paramInt = parambg.DfT;
      if (??? != null) {
        break label6206;
      }
      label367:
      paramInt = parambg.DfV;
      if (??? != null) {
        break label6323;
      }
      label377:
      paramInt = parambg.DfO;
      if (??? != null) {
        break label6369;
      }
      label387:
      paramInt = parambg.DfS;
      if (??? != null) {
        break label6589;
      }
    }
    label422:
    label628:
    label3445:
    label6140:
    while (((Integer)???).intValue() != paramInt)
    {
      for (;;)
      {
        parambg.erj();
        for (;;)
        {
          AppMethodBeat.o(371473);
          return;
          ??? = Integer.valueOf(paramMenuItem.getItemId());
          break;
          if (((Integer)???).intValue() != paramInt) {
            break label37;
          }
          bool1 = parambg.isLandscape();
          Log.i(parambg.TAG, kotlin.g.b.s.X("share2Friend isLandscape:", Boolean.valueOf(bool1)));
          if ((bool1) && ((!com.tencent.mm.ui.aw.jkP()) || (com.tencent.mm.ui.aw.ato())))
          {
            b.b.a(parambg.nfT, b.c.nec);
            b.a((b)parambg, Dgy);
            paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
              break label628;
            }
            paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
            paramMenuItem = q.s.Dum;
            ??? = com.tencent.mm.plugin.finder.live.report.j.Dob;
            paramViewGroup.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          }
          for (;;)
          {
            ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.DvF);
            if (parambg.erd())
            {
              paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
              com.tencent.mm.plugin.finder.live.olympic.report.a.a(a.b.CRN);
            }
            parambg.erj();
            AppMethodBeat.o(371473);
            return;
            parambg.erk();
            b.b.a(parambg.nfT, b.c.nec);
            paramViewGroup = parambg.ngn;
            if (paramViewGroup != null) {
              paramViewGroup.cyW();
            }
            paramViewGroup = parambg.Dgn;
            if (paramViewGroup != null) {
              paramViewGroup.fkO().cyW();
            }
            paramViewGroup = parambg.Dgo;
            if (paramViewGroup == null) {
              break;
            }
            paramViewGroup.fkO().cyW();
            break;
            ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Dum);
          }
          if (((Integer)???).intValue() != paramInt) {
            break label47;
          }
          bool1 = parambg.isLandscape();
          Log.i(parambg.TAG, kotlin.g.b.s.X("share2SNS isLandscape:", Boolean.valueOf(bool1)));
          if ((bool1) && ((!com.tencent.mm.ui.aw.jkP()) || (com.tencent.mm.ui.aw.ato())))
          {
            b.b.a(parambg.nfT, b.c.nec);
            b.a((b)parambg, Dgz);
            paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
              break label845;
            }
            paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
            paramMenuItem = q.s.Dun;
            ??? = com.tencent.mm.plugin.finder.live.report.j.Dob;
            paramViewGroup.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          }
          for (;;)
          {
            ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.DvE);
            if (!parambg.erd()) {
              break;
            }
            parambg = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
            com.tencent.mm.plugin.finder.live.olympic.report.a.a(a.b.CRO);
            AppMethodBeat.o(371473);
            return;
            parambg.erl();
            b.b.a(parambg.nfT, b.c.nec);
            paramViewGroup = parambg.ngn;
            if (paramViewGroup != null) {
              paramViewGroup.cyW();
            }
            paramViewGroup = parambg.Dgn;
            if (paramViewGroup != null) {
              paramViewGroup.fkO().cyW();
            }
            paramViewGroup = parambg.Dgo;
            if (paramViewGroup == null) {
              break label713;
            }
            paramViewGroup.fkO().cyW();
            break label713;
            ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Dun);
          }
          if (((Integer)???).intValue() != paramInt) {
            break label57;
          }
          bool1 = parambg.isLandscape();
          Log.i(parambg.TAG, kotlin.g.b.s.X("share2Status isLandscape:", Boolean.valueOf(bool1)));
          if ((bool1) && ((!com.tencent.mm.ui.aw.jkP()) || (com.tencent.mm.ui.aw.ato())))
          {
            b.b.a(parambg.nfT, b.c.nec);
            b.a((b)parambg, DgA);
          }
          for (;;)
          {
            ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Duo);
            if (!parambg.erd()) {
              break;
            }
            parambg = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
            com.tencent.mm.plugin.finder.live.olympic.report.a.a(a.b.CRP);
            AppMethodBeat.o(371473);
            return;
            parambg.erm();
            b.b.a(parambg.nfT, b.c.nec);
            paramViewGroup = parambg.ngn;
            if (paramViewGroup != null) {
              paramViewGroup.cyW();
            }
            paramViewGroup = parambg.Dgn;
            if (paramViewGroup != null) {
              paramViewGroup.fkO().cyW();
            }
            paramViewGroup = parambg.Dgo;
            if (paramViewGroup != null) {
              paramViewGroup.fkO().cyW();
            }
          }
          if (((Integer)???).intValue() != paramInt) {
            break label67;
          }
          b.b.a(parambg.nfT, b.c.nfH);
          parambg.erj();
          if (parambg.erd())
          {
            parambg = com.tencent.mm.plugin.finder.live.olympic.report.a.CRJ;
            com.tencent.mm.plugin.finder.live.olympic.report.a.a(a.b.CRQ);
          }
          ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Duo);
          AppMethodBeat.o(371473);
          return;
          if (((Integer)???).intValue() != paramInt) {
            break label77;
          }
          kotlin.g.b.s.s(paramMenuItem, "menuItem");
          ??? = parambg.mJe.getContext().getResources().getString(p.h.CnU);
          kotlin.g.b.s.s(???, "root.context.resources.g…_more_action_ban_comment)");
          localObject2 = parambg.mJe.getContext().getResources().getString(p.h.CnM);
          kotlin.g.b.s.s(localObject2, "root.context.resources.g…ore_action_allow_comment)");
          paramViewGroup = new c(parambg);
          paramMenuItem = paramMenuItem.getTitle();
          if (kotlin.g.b.s.p(paramMenuItem, ???))
          {
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
            ??? = q.s.DuF;
            localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
            paramMenuItem.a((q.s)???, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
            ((e)parambg.business(e.class)).Ecp |= 0x8;
            paramMenuItem = com.tencent.mm.plugin.finder.live.util.u.DJC;
            com.tencent.mm.plugin.finder.live.util.u.ey("disableComment", ((e)parambg.business(e.class)).Ecp);
            paramMenuItem = aj.CGT;
            paramMenuItem = aj.getFinderLiveAssistant();
            if (paramMenuItem != null) {
              ap.a.a(paramMenuItem, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)parambg.business(e.class)).Ecp, 8L, 0, (e.a)paramViewGroup, 16);
            }
            if (parambg.nfT.getLiveRole() == 1)
            {
              paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
              paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Doc.Dqq;
              paramViewGroup.DGd += 1L;
              com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drj, String.valueOf(q.b.Drd.type));
            }
            if (parambg.erp()) {
              com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 3);
            }
          }
          for (;;)
          {
            parambg.erj();
            AppMethodBeat.o(371473);
            return;
            if (kotlin.g.b.s.p(paramMenuItem, localObject2))
            {
              paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
              ??? = q.s.DuE;
              localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
              paramMenuItem.a((q.s)???, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
              ((e)parambg.business(e.class)).Ecp &= 0xFFFFFFF7;
              paramMenuItem = com.tencent.mm.plugin.finder.live.util.u.DJC;
              com.tencent.mm.plugin.finder.live.util.u.ey("allowComment", ((e)parambg.business(e.class)).Ecp);
              paramMenuItem = aj.CGT;
              paramMenuItem = aj.getFinderLiveAssistant();
              if (paramMenuItem != null) {
                ap.a.a(paramMenuItem, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)parambg.business(e.class)).Ecp, 8L, 0, (e.a)paramViewGroup, 16);
              }
              if (parambg.nfT.getLiveRole() == 1)
              {
                paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
                paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Doc.Dqq;
                paramViewGroup.DGe += 1L;
                com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drj, String.valueOf(q.b.Dre.type));
              }
              if (parambg.erp()) {
                com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 4);
              }
            }
            else
            {
              Log.e(parambg.TAG, "comment state err!");
            }
          }
          if (((Integer)???).intValue() != paramInt) {
            break label87;
          }
          kotlin.g.b.s.s(paramMenuItem, "menuItem");
          ??? = parambg.mJe.getContext().getResources().getString(p.h.CnW);
          kotlin.g.b.s.s(???, "root.context.resources.g…ive_more_action_ban_like)");
          localObject2 = parambg.mJe.getContext().getResources().getString(p.h.CnO);
          kotlin.g.b.s.s(localObject2, "root.context.resources.g…e_more_action_allow_like)");
          paramViewGroup = new d(parambg);
          paramMenuItem = paramMenuItem.getTitle();
          if (kotlin.g.b.s.p(paramMenuItem, ???))
          {
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
            ??? = q.s.DuN;
            localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
            paramMenuItem.a((q.s)???, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
            ((e)parambg.business(e.class)).Ecp |= 0x200;
            paramMenuItem = com.tencent.mm.plugin.finder.live.util.u.DJC;
            com.tencent.mm.plugin.finder.live.util.u.ey("disableLike", ((e)parambg.business(e.class)).Ecp);
            paramMenuItem = aj.CGT;
            paramMenuItem = aj.getFinderLiveAssistant();
            if (paramMenuItem != null) {
              ap.a.a(paramMenuItem, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)parambg.business(e.class)).Ecp, 512L, 0, (e.a)paramViewGroup, 16);
            }
            if (parambg.nfT.getLiveRole() == 1) {
              com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrI, String.valueOf(q.ao.DyK.type));
            }
            if (parambg.erp()) {
              com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 9);
            }
          }
          for (;;)
          {
            parambg.erj();
            AppMethodBeat.o(371473);
            return;
            if (kotlin.g.b.s.p(paramMenuItem, localObject2))
            {
              paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
              ??? = q.s.DuM;
              localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
              paramMenuItem.a((q.s)???, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
              ((e)parambg.business(e.class)).Ecp &= 0xFFFFFDFF;
              paramMenuItem = com.tencent.mm.plugin.finder.live.util.u.DJC;
              com.tencent.mm.plugin.finder.live.util.u.ey("allowLike", ((e)parambg.business(e.class)).Ecp);
              paramMenuItem = aj.CGT;
              paramMenuItem = aj.getFinderLiveAssistant();
              if (paramMenuItem != null) {
                ap.a.a(paramMenuItem, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)parambg.business(e.class)).Ecp, 512L, 0, (e.a)paramViewGroup, 16);
              }
              if (parambg.nfT.getLiveRole() == 1) {
                com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrI, String.valueOf(q.ao.DyJ.type));
              }
              if (parambg.erp()) {
                com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 10);
              }
            }
            else
            {
              Log.e(parambg.TAG, "like state error");
            }
          }
          if (((Integer)???).intValue() != paramInt) {
            break label97;
          }
          if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
          {
            Log.e(parambg.TAG, "showVideoTalking, permission denied");
            b.b.a(parambg.nfT, b.c.ncz);
            RequestFloatWindowPermissionDialog.a(parambg.mJe.getContext(), parambg.mJe.getContext().getString(p.h.live_room_mini_view_fail), (RequestFloatWindowPermissionDialog.a)new j(parambg), false, com.tencent.mm.bq.a.aQB());
          }
          for (;;)
          {
            parambg.erj();
            parambg = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
              break;
            }
            parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
            paramViewGroup = q.s.Dup;
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
            parambg.a(paramViewGroup, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
            AppMethodBeat.o(371473);
            return;
            paramViewGroup = new Bundle();
            paramViewGroup.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
            paramViewGroup.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
            parambg.nfT.statusChange(b.c.ncx, paramViewGroup);
            if (parambg.nfT.getLiveRole() == 1)
            {
              paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
              com.tencent.mm.plugin.finder.live.report.j.Doc.Dqr = true;
              paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
              com.tencent.mm.plugin.finder.live.report.j.Doc.Dqs = false;
              com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Dri, String.valueOf(q.z.Dxy.type));
            }
            else if (parambg.nfT.getLiveRole() == 0)
            {
              com.tencent.mm.plugin.finder.live.report.k.Doi.a(true, q.z.Dxy);
            }
          }
          ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Dup);
          parambg = com.tencent.mm.kernel.h.ax(ce.class);
          kotlin.g.b.s.s(parambg, "service(IHellLiveReport::class.java)");
          ce.a.a((ce)parambg, q.s.Dus);
          AppMethodBeat.o(371473);
          return;
          if (((Integer)???).intValue() != paramInt) {
            break label107;
          }
          parambg.rv(true);
          parambg.erj();
          AppMethodBeat.o(371473);
          return;
          if (((Integer)???).intValue() != paramInt) {
            break label117;
          }
          parambg.rv(false);
          parambg.erj();
          AppMethodBeat.o(371473);
          return;
          if (((Integer)???).intValue() != paramInt) {
            break label127;
          }
          paramMenuItem = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (!com.tencent.mm.plugin.finder.live.utils.a.euI())
          {
            paramMenuItem = new com.tencent.mm.ui.widget.a.j(paramViewGroup.getContext(), 2, 2, true, (byte)0);
            paramMenuItem.au((CharSequence)paramViewGroup.getContext().getResources().getString(p.h.app_i_know));
            paramMenuItem.aFe(6);
            ??? = new TextView(paramViewGroup.getContext());
            ((TextView)???).setPaddingRelative(parambg.eri(), 0, 0, 0);
            ((TextView)???).setText(p.h.CnR);
            ((TextView)???).setTextColor(((TextView)???).getContext().getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_8));
            ((TextView)???).setTextSize(15.0F);
            localObject2 = ah.aiuX;
            paramMenuItem.setHeaderView((View)???);
            paramViewGroup = new TextView(paramViewGroup.getContext());
            paramViewGroup.setText(p.h.CnS);
            paramViewGroup.setTextColor(paramViewGroup.getContext().getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_8));
            paramViewGroup.setTextSize(15.0F);
            ??? = ah.aiuX;
            paramMenuItem.setCustomView((View)paramViewGroup);
            paramMenuItem.agfR = new bg..ExternalSyntheticLambda22(paramMenuItem, parambg);
            paramMenuItem.dDn();
          }
          for (;;)
          {
            parambg.erj();
            AppMethodBeat.o(371473);
            return;
            parambg.ru(true);
          }
          if (((Integer)???).intValue() != paramInt) {
            break label137;
          }
          parambg.ru(false);
          parambg.erj();
          AppMethodBeat.o(371473);
          return;
          if (((Integer)???).intValue() != paramInt) {
            break label147;
          }
          bool1 = parambg.isLandscape();
          Log.i(parambg.TAG, kotlin.g.b.s.X("expose isLandscape:", Boolean.valueOf(bool1)));
          if (bool1)
          {
            b.b.a(parambg.nfT, b.c.nec);
            b.a((b)parambg, DgB);
          }
          while (parambg.nfT.getLiveRole() == 0)
          {
            parambg = com.tencent.mm.plugin.finder.live.report.k.Doi;
            com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCl, null, 0L, null, null, null, 60);
            com.tencent.mm.plugin.finder.live.report.k.Doz += 1;
            AppMethodBeat.o(371473);
            return;
            parambg.ern();
            parambg.erj();
          }
        }
        if (((Integer)???).intValue() != paramInt) {
          break label157;
        }
        parambg.erj();
        ((e)parambg.business(e.class)).EcH = true;
        paramViewGroup = new Bundle();
        paramViewGroup.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", ((e)parambg.business(e.class)).EcH);
        parambg.nfT.statusChange(b.c.ndZ, paramViewGroup);
        if (parambg.nfT.getLiveRole() == 0) {
          if (!((e)parambg.business(e.class)).EcH) {
            break label2966;
          }
        }
        for (parambg = q.l.Dth;; parambg = q.l.Dtg)
        {
          com.tencent.mm.plugin.finder.live.report.k.Doi.a(parambg);
          AppMethodBeat.o(371473);
          return;
        }
        if (((Integer)???).intValue() != paramInt) {
          break label167;
        }
        parambg.erj();
        paramMenuItem = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        kotlin.g.b.s.s(paramMenuItem, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        boolean bool2;
        for (;;)
        {
          synchronized ((Iterable)paramMenuItem)
          {
            localObject2 = ((Iterable)???).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              paramMenuItem = ((Iterator)localObject2).next();
              bool1 = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramMenuItem).mXL, ((e)parambg.business(e.class)).eyF());
              if (!bool1) {
                continue;
              }
              if (paramMenuItem != null)
              {
                bool1 = true;
                bool2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eza();
                Log.i(parambg.TAG, "showCustomerVideoLevel linking:" + bool1 + ",linkWait:" + bool2);
                if ((!bool1) && (!bool2)) {
                  break;
                }
                com.tencent.mm.ui.base.aa.c(paramViewGroup.getContext(), (CharSequence)paramViewGroup.getContext().getResources().getString(p.h.Cts));
                AppMethodBeat.o(371473);
              }
            }
            else
            {
              paramMenuItem = null;
            }
          }
          bool1 = false;
        }
        if (((e)parambg.business(e.class)).Eep != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = NetStatusUtil.isConnected(MMApplicationContext.getContext());
          if ((!bool1) && (bool2)) {
            break;
          }
          Log.i(parambg.TAG, "anchor pause live:" + bool1 + ",networkEnable:" + bool2 + '!');
          com.tencent.mm.ui.base.aa.c(paramViewGroup.getContext(), (CharSequence)paramViewGroup.getContext().getResources().getString(p.h.Ctr));
          AppMethodBeat.o(371473);
          return;
        }
        paramViewGroup = parambg.Dgu;
        if (paramViewGroup != null)
        {
          paramViewGroup.sH(parambg.isLandscape());
          parambg = ah.aiuX;
        }
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label177;
        }
        paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
        {
          paramViewGroup = ba.Gjt;
          paramViewGroup = ba.fgK();
        }
        for (;;)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.tools.a.FNQ;
          com.tencent.mm.plugin.finder.tools.a.aF((Context)parambg.activity, paramViewGroup);
          break;
          paramViewGroup = com.tencent.mm.plugin.finder.utils.bd.Gli;
          paramViewGroup = com.tencent.mm.plugin.finder.utils.bd.fhT();
          paramMenuItem = com.tencent.mm.plugin.finder.utils.bd.Gli;
          paramViewGroup = (String)paramViewGroup.get(kotlin.g.b.s.X(com.tencent.mm.plugin.finder.utils.bd.fhS(), Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId)));
          if (paramViewGroup == null) {
            paramViewGroup = "";
          }
        }
        if (((Integer)???).intValue() != paramInt) {
          break label187;
        }
        paramViewGroup = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        if (com.tencent.mm.plugin.finder.utils.aw.bgV())
        {
          parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class);
          parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class);
          if (com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.eyO()) {
            break label3505;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.sm(bool1);
          parambg.erj();
          AppMethodBeat.o(371473);
          return;
        }
        if (((Integer)???).intValue() != paramInt) {
          break label197;
        }
        new com.tencent.mm.plugin.finder.live.utils.fake.b(parambg.activity, parambg.getBuContext()).show();
        continue;
        if (((Integer)???).intValue() != paramInt) {
          break label207;
        }
        parambg.erj();
        paramViewGroup = ((e)parambg.business(e.class)).Eco;
        if (paramViewGroup != null)
        {
          paramViewGroup = paramViewGroup.debugMessage;
          if ((paramViewGroup == null) || (TextUtils.isEmpty((CharSequence)paramViewGroup))) {}
        }
        for (;;)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.tools.a.FNQ;
          parambg = parambg.activity.getContext();
          kotlin.g.b.s.s(parambg, "activity.context");
          com.tencent.mm.plugin.finder.tools.a.aF((Context)parambg, paramViewGroup);
          AppMethodBeat.o(371473);
          return;
          paramViewGroup = "empty msg.";
        }
        if (((Integer)???).intValue() != paramInt) {
          break label217;
        }
        new com.tencent.mm.plugin.finder.live.utils.fake.d(parambg.activity, parambg.getBuContext()).show();
        continue;
        if (((Integer)???).intValue() != paramInt) {
          break label227;
        }
        paramViewGroup = new Intent();
        paramViewGroup.putExtra("KEY_LOTTERY_HISTORY_SCENE", 2);
        paramViewGroup.putExtra("KEY_LOTTERY_HISTORY_LIVE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
        paramViewGroup.putExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN);
        paramViewGroup.putExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
        paramViewGroup.putExtra("KEY_LIVE_ANCHOR_USERNAME", ((e)parambg.business(e.class)).mIC);
        paramMenuItem = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(paramMenuItem, "service(IFinderCommonService::class.java)");
        h.a.a((com.tencent.mm.plugin.h)paramMenuItem, (Context)parambg.activity, paramViewGroup, 0, 124);
        paramMenuItem = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        kotlin.g.b.s.s(paramMenuItem, "service(IActivityRouter::class.java)");
        f.a.a((com.tencent.mm.plugin.f)paramMenuItem, (Context)parambg.activity, paramViewGroup);
        parambg.erj();
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFl, "");
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label237;
        }
        Log.i(parambg.TAG, kotlin.g.b.s.X("enable/disable link mic. curEnableLinkMic:", Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW())));
        parambg.erj();
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW())
        {
          paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
          ??? = q.s.DuJ;
          localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem.a((q.s)???, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          ((e)parambg.business(e.class)).Ecp &= 0xFFFFFFBF;
          com.tencent.mm.ui.base.aa.db(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.ClG));
          paramViewGroup = com.tencent.mm.plugin.finder.live.util.u.DJC;
          com.tencent.mm.plugin.finder.live.util.u.ey("disableLinkMic", ((e)parambg.business(e.class)).Ecp);
          paramViewGroup = new Bundle();
          paramViewGroup.putBoolean("PARAM_FINDER_LIVE_LINK_MIC_ENABLE", false);
          parambg.nfT.statusChange(b.c.neE, paramViewGroup);
          paramViewGroup = ah.aiuX;
          if (parambg.nfT.getLiveRole() == 1) {
            com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drw, String.valueOf(q.aq.Dzc.action));
          }
        }
        for (;;)
        {
          parambg.business(e.class);
          e.pa(((e)parambg.business(e.class)).Ecp);
          AppMethodBeat.o(371473);
          return;
          paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
          ??? = q.s.DuI;
          localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem.a((q.s)???, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          ((e)parambg.business(e.class)).Ecp |= 0x40;
          com.tencent.mm.ui.base.aa.db(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.ClH));
          paramViewGroup = com.tencent.mm.plugin.finder.live.util.u.DJC;
          com.tencent.mm.plugin.finder.live.util.u.ey("enableLinkMic", ((e)parambg.business(e.class)).Ecp);
          paramViewGroup = new Bundle();
          paramViewGroup.putBoolean("PARAM_FINDER_LIVE_LINK_MIC_ENABLE", true);
          parambg.nfT.statusChange(b.c.neE, paramViewGroup);
          paramViewGroup = ah.aiuX;
          if (parambg.nfT.getLiveRole() == 1) {
            com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drw, String.valueOf(q.aq.Dzb.action));
          }
        }
        if (((Integer)???).intValue() != paramInt) {
          break label247;
        }
        Log.i(parambg.TAG, kotlin.g.b.s.X("enable/disable gift. curEnableGift:", Boolean.valueOf(((e)parambg.business(e.class)).eyr())));
        parambg.erj();
        if (((e)parambg.business(e.class)).eyr())
        {
          paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
          ??? = q.s.DuL;
          localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem.a((q.s)???, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          ((e)parambg.business(e.class)).Ecp &= 0xFFFFFF7F;
          com.tencent.mm.ui.base.aa.db(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.CkL));
          paramViewGroup = com.tencent.mm.plugin.finder.live.util.u.DJC;
          com.tencent.mm.plugin.finder.live.util.u.ey("disableGift", ((e)parambg.business(e.class)).Ecp);
          if (parambg.nfT.getLiveRole() == 1) {
            com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Dry, String.valueOf(q.ag.Dyc.action));
          }
          if (parambg.erp()) {
            com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 7);
          }
          paramViewGroup = aj.CGT;
          paramViewGroup = aj.getFinderLiveAssistant();
          if (paramViewGroup != null)
          {
            ap.a.a(paramViewGroup, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)parambg.business(e.class)).Ecp, 128L, 0, null, 48);
            paramViewGroup = ah.aiuX;
          }
        }
        for (;;)
        {
          parambg.business(e.class);
          e.pa(((e)parambg.business(e.class)).Ecp);
          AppMethodBeat.o(371473);
          return;
          paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
          ??? = q.s.DuK;
          localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem.a((q.s)???, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          ((e)parambg.business(e.class)).Ecp |= 0x80;
          paramMenuItem = com.tencent.mm.plugin.finder.live.util.u.DJC;
          com.tencent.mm.plugin.finder.live.util.u.ey("enableGift", ((e)parambg.business(e.class)).Ecp);
          if (parambg.nfT.getLiveRole() == 1) {
            com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Dry, String.valueOf(q.ag.Dyd.action));
          }
          if (parambg.erp()) {
            com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 8);
          }
          paramMenuItem = aj.CGT;
          paramMenuItem = aj.getFinderLiveAssistant();
          if (paramMenuItem != null)
          {
            ap.a.a(paramMenuItem, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)parambg.business(e.class)).Ecp, 128L, 0, (e.a)new h(paramViewGroup, parambg), 16);
            paramViewGroup = ah.aiuX;
          }
        }
        if (((Integer)???).intValue() != paramInt) {
          break label257;
        }
        parambg.ero();
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label267;
        }
        parambg.erj();
        parambg = new com.tencent.mm.ui.widget.a.h(paramViewGroup.getContext());
        parambg.jHQ();
        parambg.aFa(p.f.Cfg);
        paramViewGroup = (MMSwitchBtn)parambg.rootView.findViewById(p.e.switch_btn);
        paramMenuItem = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramViewGroup.setCheck(com.tencent.mm.plugin.finder.live.utils.a.bfK());
        paramViewGroup.setSwitchListener(bg..ExternalSyntheticLambda20.INSTANCE);
        parambg.rootView.findViewById(p.e.BQz).setOnClickListener(new bg..ExternalSyntheticLambda1(parambg));
        paramViewGroup = ah.aiuX;
        parambg.dDn();
        parambg = com.tencent.mm.kernel.h.ax(ce.class);
        kotlin.g.b.s.s(parambg, "service(IHellLiveReport::class.java)");
        ce.a.a((ce)parambg, q.t.DvD);
        parambg = com.tencent.mm.kernel.h.ax(ce.class);
        kotlin.g.b.s.s(parambg, "service(IHellLiveReport::class.java)");
        ce.a.a((ce)parambg, q.s.Dut);
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label277;
        }
        parambg.erj();
        if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo))
        {
          com.tencent.mm.ui.base.aa.dc(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.Cjl));
          AppMethodBeat.o(371473);
          return;
        }
        com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.k.DsY);
        b.b.a(parambg.nfT, b.c.neO);
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label287;
        }
        parambg.erj();
        if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo))
        {
          com.tencent.mm.ui.base.aa.dc(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.Cjm));
          AppMethodBeat.o(371473);
          return;
        }
        paramMenuItem = com.tencent.mm.plugin.finder.live.util.m.DJb;
        paramMenuItem = com.tencent.mm.plugin.finder.live.util.m.m(parambg.getBuContext());
        if (paramMenuItem != null)
        {
          Log.i("MicroMsg.FinderLiveHandOffUtil", kotlin.g.b.s.X("openHandOff ", paramMenuItem));
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).f((HandOff)paramMenuItem);
        }
        paramMenuItem = com.tencent.mm.plugin.finder.live.util.m.DJb;
        paramViewGroup = paramViewGroup.getContext();
        kotlin.g.b.s.s(paramViewGroup, "root.context");
        com.tencent.mm.plugin.finder.live.util.m.eK(paramViewGroup);
        if (parambg.nfT.getLiveRole() == 0)
        {
          com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.bg.DAO);
          AppMethodBeat.o(371473);
          return;
        }
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrJ, String.valueOf(q.bg.DAO.type));
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label297;
        }
        paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuC;
        ??? = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramViewGroup.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        paramViewGroup = parambg.Dgn;
        if (paramViewGroup != null)
        {
          paramViewGroup.fkO().cyW();
          paramViewGroup = ah.aiuX;
        }
        b.b.a(parambg.nfT, b.c.nec);
        paramViewGroup = aj.CGT;
        if (aj.elM() == null)
        {
          Log.e(parambg.TAG, "pauseLive wasn't anchor!");
          AppMethodBeat.o(371473);
          return;
        }
        paramViewGroup = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        kotlin.g.b.s.s(paramViewGroup, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        if (!((Collection)paramViewGroup).isEmpty()) {}
        for (paramInt = 1; (paramInt != 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv != null); paramInt = 0)
        {
          Log.i(parambg.TAG, "pauseLive mick linking!");
          com.tencent.mm.plugin.finder.live.view.a.showAlertDialog$default(parambg.eoH(), (Activity)parambg.activity, "", MMApplicationContext.getContext().getResources().getString(p.h.Cqs), "", false, 16, null);
          AppMethodBeat.o(371473);
          return;
        }
        paramViewGroup = aj.CGT;
        paramViewGroup = aj.getFinderLiveAssistant();
        if (paramViewGroup != null) {
          paramViewGroup.a(1, 0, (al.a)new k(parambg));
        }
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label307;
        }
        parambg.erj();
        if (((e)parambg.business(e.class)).Eem)
        {
          com.tencent.mm.ui.base.aa.db(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.ChZ));
          paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem = q.s.DuB;
          ??? = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramViewGroup.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          paramViewGroup = new Bundle();
          if (((e)parambg.business(e.class)).Eem) {
            break label5670;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          paramViewGroup.putBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", bool1);
          parambg.nfT.statusChange(b.c.neV, paramViewGroup);
          parambg = ah.aiuX;
          AppMethodBeat.o(371473);
          return;
          com.tencent.mm.ui.base.aa.db(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.Cio));
          paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem = q.s.DuA;
          ??? = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramViewGroup.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          break;
        }
        if (((Integer)???).intValue() != paramInt) {
          break label317;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfK = new i(null, 0L, 0, 1, 2, null, 39);
        b.b.a(parambg.nfT, b.c.nfa);
        com.tencent.mm.ae.d.a(5000L, (kotlin.g.a.a)new i(parambg));
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label327;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfK = new i(null, 0L, 0, 2, 2, null, 39);
        b.b.a(parambg.nfT, b.c.nfa);
        com.tencent.mm.ae.d.a(5000L, (kotlin.g.a.a)new f(parambg));
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label337;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfK = new i(null, 0L, 0, 3, 2, null, 39);
        b.b.a(parambg.nfT, b.c.nfa);
        com.tencent.mm.ae.d.a(5000L, (kotlin.g.a.a)new g(parambg));
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label347;
        }
        parambg.erj();
        paramViewGroup = "onLine: " + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class)).Efd + "\n " + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class)).eyP();
        paramMenuItem = com.tencent.mm.plugin.finder.tools.a.FNQ;
        parambg = parambg.activity.getContext();
        kotlin.g.b.s.s(parambg, "activity.context");
        com.tencent.mm.plugin.finder.tools.a.aF((Context)parambg, paramViewGroup);
        AppMethodBeat.o(371473);
        return;
        if (((Integer)???).intValue() != paramInt) {
          break label357;
        }
        paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUC())
        {
          paramViewGroup = parambg.mJe.getContext();
          if (!(paramViewGroup instanceof MMActivity)) {
            break label6140;
          }
          paramViewGroup = (MMActivity)paramViewGroup;
          if (paramViewGroup != null) {
            break label6145;
          }
          paramViewGroup = null;
          if (paramViewGroup != null) {
            break label6173;
          }
          paramMenuItem = null;
          if (paramMenuItem != null) {
            paramMenuItem.liveId = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
          }
          paramMenuItem = parambg.mJe.getContext();
          if (!(paramMenuItem instanceof MMActivity)) {
            break label6201;
          }
        }
        for (paramMenuItem = (MMActivity)paramMenuItem;; paramMenuItem = null)
        {
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.getIntent();
            if (paramMenuItem != null) {
              paramMenuItem.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramViewGroup);
            }
          }
          parambg.erh();
          ((e)parambg.business(e.class)).Eez = true;
          ag.a(parambg.activity.getTaskId(), null);
          break;
          paramViewGroup = null;
          break label6027;
          paramViewGroup = paramViewGroup.getIntent();
          if (paramViewGroup == null)
          {
            paramViewGroup = null;
            break label6033;
          }
          paramViewGroup = (FinderLiveBundle)paramViewGroup.getParcelableExtra("KEY_PARAMS_CONFIG");
          break label6033;
          paramMenuItem = paramViewGroup.CFa;
          if (paramMenuItem == null)
          {
            paramMenuItem = null;
            break label6039;
          }
          paramMenuItem = (LiveConfig)p.oL((List)paramMenuItem);
          break label6039;
        }
        if (((Integer)???).intValue() != paramInt) {
          break label367;
        }
        b.b.a(parambg.nfT, b.c.nfr);
        parambg.erj();
        if (parambg.erp()) {
          com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 1);
        }
        for (;;)
        {
          parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramViewGroup = q.s.DuO;
          paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
          parambg.a(paramViewGroup, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          AppMethodBeat.o(371473);
          return;
          parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramViewGroup = q.c.DrR;
          paramMenuItem = new JSONObject();
          paramMenuItem.put(q.d.Dsa.key, q.e.Dsf.Dsd);
          ??? = ah.aiuX;
          parambg.a(paramViewGroup, paramMenuItem.toString());
        }
        if (((Integer)???).intValue() != paramInt) {
          break label377;
        }
        paramViewGroup = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuG;
        ??? = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramViewGroup.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        b.b.a(parambg.nfT, b.c.nfs);
      }
      if (((Integer)???).intValue() != paramInt) {
        break label387;
      }
      long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      boolean bool1 = ((e)parambg.business(e.class)).EeM;
      if (bool1)
      {
        paramMenuItem = MultiProcessMMKV.getMMKV("FINDER_LIVE_MMKV");
        if (paramMenuItem != null) {
          paramMenuItem.putLong("VISITOR_GIFT_EFFECT_OFF_LIVE_ID", 0L);
        }
        com.tencent.mm.ui.base.aa.db(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.CkP));
        paramViewGroup = (e)parambg.business(e.class);
        if (bool1) {
          break label6583;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramViewGroup.EeM = bool1;
        parambg.erj();
        Log.i(parambg.TAG, "effectOff:" + ((e)parambg.business(e.class)).EeM + " liveId:" + l);
        AppMethodBeat.o(371473);
        return;
        paramMenuItem = MultiProcessMMKV.getMMKV("FINDER_LIVE_MMKV");
        if (paramMenuItem != null) {
          paramMenuItem.putLong("VISITOR_GIFT_EFFECT_OFF_LIVE_ID", l);
        }
        com.tencent.mm.ui.base.aa.db(paramViewGroup.getContext(), paramViewGroup.getContext().getResources().getString(p.h.CkN));
        break;
      }
    }
    label643:
    label713:
    label845:
    label860:
    label1640:
    label2155:
    label5490:
    label5747:
    paramViewGroup = parambg.nfT;
    label1028:
    label1087:
    label3541:
    label4962:
    label5988:
    paramMenuItem = b.c.nfw;
    label2437:
    label2462:
    label2487:
    label3662:
    label6369:
    ??? = new Bundle();
    label2714:
    label2739:
    label3511:
    label4808:
    ((Bundle)???).putBoolean("PARAM_FINDER_LIVE_SHOW_FANS_MODIFY", true);
    label2852:
    label3505:
    label4276:
    label5058:
    Object localObject2 = ah.aiuX;
    label2966:
    label2973:
    label3632:
    label4788:
    label5818:
    label6206:
    paramViewGroup.statusChange(paramMenuItem, (Bundle)???);
    label3341:
    label3859:
    label5670:
    label5676:
    label6201:
    label6589:
    parambg.erj();
    label5248:
    label5889:
    label6027:
    label6033:
    label6039:
    label6173:
    label6323:
    label6583:
    parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
    label6145:
    paramViewGroup = q.s.DuP;
    paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
    parambg.a(paramViewGroup, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    AppMethodBeat.o(371473);
  }
  
  private static final void a(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371477);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    params.a(parambg.Dfz, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.finder_live_more_action_mini_window), p.g.icons_outlined_mini_window_new);
    params.a(parambg.DfT, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CjN), p.g.icons_outlined_pencil);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jRP().bmg()).intValue() == 1) {
      params.a(parambg.DfV, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.Cko), p.g.icons_outlined_fast_comment);
    }
    parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
    params = q.t.Dvy;
    localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
    parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
    params = q.t.DvY;
    localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
    parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
    params = q.t.DvZ;
    localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
    parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    AppMethodBeat.o(371477);
  }
  
  private final void a(FinderObject paramFinderObject, bip parambip)
  {
    AppMethodBeat.i(355374);
    Object localObject = paramFinderObject.liveInfo;
    if ((localObject != null) && (((bip)localObject).liveId == parambip.liveId)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("source object:");
        com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        localStringBuilder = localStringBuilder.append(com.tencent.mm.plugin.finder.live.view.convert.a.c(paramFinderObject.liveInfo)).append(",dest live info's purchase info:");
        locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        Log.i((String)localObject, com.tencent.mm.plugin.finder.live.view.convert.a.a(parambip.ZSc));
        paramFinderObject.liveInfo = parambip;
      }
      AppMethodBeat.o(355374);
      return;
    }
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(371463);
    kotlin.g.b.s.u(paramh, "$this_apply");
    paramh.cyW();
    AppMethodBeat.o(371463);
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.j paramj, bg parambg)
  {
    AppMethodBeat.i(371460);
    kotlin.g.b.s.u(paramj, "$dialog");
    kotlin.g.b.s.u(parambg, "this$0");
    paramj.cyW();
    paramj = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.euJ();
    parambg.ru(true);
    AppMethodBeat.o(371460);
  }
  
  private static final void b(bg parambg)
  {
    AppMethodBeat.i(371479);
    kotlin.g.b.s.u(parambg, "this$0");
    b.b.a(parambg.nfT, b.c.nec);
    parambg.Dgp = null;
    AppMethodBeat.o(371479);
  }
  
  private static final void b(bg parambg, final ViewGroup paramViewGroup, final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(371474);
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramViewGroup, "$root");
    final FinderObject localFinderObject = ((e)parambg.business(e.class)).Eco;
    if (localFinderObject != null)
    {
      com.tencent.mm.pluginsdk.q localq = parambg.Dgq;
      if (localq != null)
      {
        if (paramMenuItem == null)
        {
          parambg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
          AppMethodBeat.o(371474);
          throw parambg;
        }
        localq.a((t)paramMenuItem, (kotlin.g.a.b)new p(parambg, paramViewGroup, localFinderObject, paramMenuItem));
      }
      ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Duq);
    }
    parambg.erj();
    AppMethodBeat.o(371474);
  }
  
  private static final void b(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371478);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    com.tencent.mm.plugin.finder.live.report.j localj;
    if (((e)parambg.business(e.class)).Edv)
    {
      if (((e)parambg.business(e.class)).eyr())
      {
        localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Cob);
        kotlin.g.b.s.s(localObject1, "root.context.resources.g…more_action_disable_gift)");
        i = p.g.finder_live_ungift;
        localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject3 = q.t.DvV;
        localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        params.a(parambg.DfD, (CharSequence)localObject1, i);
      }
    }
    else
    {
      if (!((e)parambg.business(e.class)).Ect) {
        break label401;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvR;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnU);
      label178:
      kotlin.g.b.s.s(localObject1, "if (business(LiveCommonS…ow_comment)\n            }");
      if (!((e)parambg.business(e.class)).Ect) {
        break label447;
      }
      i = p.g.icon_outlined_close_comment;
      label205:
      params.a(parambg.DeO, (CharSequence)localObject1, i);
      if (((e)parambg.business(e.class)).Ecw)
      {
        if (!((e)parambg.business(e.class)).Ecx) {
          break label454;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject2 = q.t.DvX;
        localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnW);
        label294:
        kotlin.g.b.s.s(localObject1, "if (business(LiveCommonS…w_like)\n                }");
        if (!((e)parambg.business(e.class)).Ecx) {
          break label500;
        }
      }
    }
    label401:
    label447:
    label454:
    label500:
    for (int i = p.g.icons_outlined_favour_off;; i = p.g.icons_outlined_favour_on)
    {
      params.a(parambg.DfL, (CharSequence)localObject1, i);
      AppMethodBeat.o(371478);
      return;
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Cod);
      kotlin.g.b.s.s(localObject1, "root.context.resources.g…_more_action_enable_gift)");
      i = p.g.finder_live_gift;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject3 = q.t.DvU;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      break;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvQ;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnM);
      break label178;
      i = p.g.icons_outlined_comment;
      break label205;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvW;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnO);
      break label294;
    }
  }
  
  private static final void c(bg parambg)
  {
    AppMethodBeat.i(371480);
    kotlin.g.b.s.u(parambg, "this$0");
    b.b.a(parambg.nfT, b.c.nec);
    parambg.Dgn = null;
    AppMethodBeat.o(371480);
  }
  
  private static final void c(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(355645);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    int j = parambg.Dfw;
    Object localObject = (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.Cot);
    int k = p.g.finder_icons_filled_share;
    int m = parambg.mJe.getContext().getResources().getColor(p.b.Brand);
    int i;
    if (((e)parambg.business(e.class)).Eco != null)
    {
      FinderObject localFinderObject = ((e)parambg.business(e.class)).Eco;
      if ((localFinderObject != null) && (localFinderObject.id == 0L))
      {
        i = 1;
        if (i == 0) {
          break label291;
        }
      }
    }
    else
    {
      bool = true;
      label121:
      params.a(j, (CharSequence)localObject, k, m, bool);
      j = parambg.Dfx;
      localObject = (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.Cou);
      k = p.g.bottomsheet_icon_moment;
      if (((e)parambg.business(e.class)).Eco != null)
      {
        parambg = ((e)parambg.business(e.class)).Eco;
        if ((parambg == null) || (parambg.id != 0L)) {
          break label297;
        }
        i = 1;
        label211:
        if (i == 0) {
          break label302;
        }
      }
    }
    label291:
    label297:
    label302:
    for (boolean bool = true;; bool = false)
    {
      params.a(j, (CharSequence)localObject, k, 0, bool);
      parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
      params = q.t.Dvv;
      localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
      parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
      params = q.t.Dvw;
      localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
      parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      AppMethodBeat.o(355645);
      return;
      i = 0;
      break;
      bool = false;
      break label121;
      i = 0;
      break label211;
    }
  }
  
  private static final void d(bg parambg)
  {
    AppMethodBeat.i(371492);
    kotlin.g.b.s.u(parambg, "this$0");
    b.b.a(parambg.nfT, b.c.nec);
    parambg.ngn = null;
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    localObject = parambg.mJe.getContext();
    kotlin.g.b.s.s(localObject, "root.context");
    localObject = (emx)com.tencent.mm.plugin.secdata.ui.a.a.c((Context)localObject, 14, emx.class);
    com.tencent.mm.pluginsdk.q localq;
    if (localObject != null)
    {
      ((emx)localObject).lsO = 1;
      ((emx)localObject).Qmp = ((int)(cn.bDw() - ((emx)localObject).startTime));
      ((emx)localObject).scene = 8;
      localq = parambg.Dgq;
      if (localq != null) {
        break label134;
      }
    }
    label134:
    for (int i = 0;; i = localq.getItemCount())
    {
      ((emx)localObject).abrf = i;
      localObject = com.tencent.mm.pluginsdk.j.a.XUW;
      parambg = parambg.mJe.getContext();
      kotlin.g.b.s.s(parambg, "root.context");
      com.tencent.mm.pluginsdk.j.a.ly(parambg);
      AppMethodBeat.o(371492);
      return;
    }
  }
  
  private static final void d(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371483);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    parambg.f(params);
    AppMethodBeat.o(371483);
  }
  
  private static final void e(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371486);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    com.tencent.mm.plugin.finder.live.report.j localj;
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfD) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfE) && (!((e)parambg.business(e.class)).eyC()) && (!((e)parambg.business(e.class)).Eet))
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW())
      {
        localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Coc);
        kotlin.g.b.s.s(localObject1, "root.context.resources.g…_action_disable_link_mic)");
        i = p.g.finder_live_unmic;
        localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject3 = q.t.DvT;
        localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        params.a(parambg.DfC, (CharSequence)localObject1, i);
      }
    }
    else
    {
      if ((((e)parambg.business(e.class)).Edv) && (((e)parambg.business(e.class)).Edx))
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUb())
        {
          if (!((e)parambg.business(e.class)).eyr()) {
            break label740;
          }
          localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Cob);
          kotlin.g.b.s.s(localObject1, "root.context.resources.g…more_action_disable_gift)");
          i = p.g.finder_live_ungift;
          localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localObject3 = q.t.DvV;
          localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
          ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
          label288:
          params.a(parambg.DfD, (CharSequence)localObject1, i);
        }
      }
      if (!((e)parambg.business(e.class)).Ect) {
        break label799;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvR;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnU);
      label361:
      kotlin.g.b.s.s(localObject1, "if (business(LiveCommonS…_allow_comment)\n        }");
      if (!((e)parambg.business(e.class)).Ect) {
        break label845;
      }
      i = p.g.icons_outlined_ban_chats;
      label388:
      params.a(parambg.DeO, (CharSequence)localObject1, i);
      if (((e)parambg.business(e.class)).Ecw)
      {
        if (!((e)parambg.business(e.class)).Ecx) {
          break label852;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject2 = q.t.DvX;
        localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnW);
        label477:
        kotlin.g.b.s.s(localObject1, "if (business(LiveCommonS…allow_like)\n            }");
        if (!((e)parambg.business(e.class)).Ecx) {
          break label898;
        }
        i = p.g.icons_outlined_favour_off;
        label504:
        params.a(parambg.DfL, (CharSequence)localObject1, i);
      }
      localObject1 = ((e)parambg.business(e.class)).CFy;
      if ((localObject1 != null) && (((bha)localObject1).ZQB == 1))
      {
        if (((bha)localObject1).ZQz != 1) {
          break label905;
        }
        params.a(parambg.DfJ, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CgW), p.g.icons_outlined_game_on);
      }
      label583:
      if (parambg.erf())
      {
        if (!parambg.erg()) {
          break label939;
        }
        params.a(parambg.DfR, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CnQ), p.g.finder_live_anonymous_1);
        parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
        params = q.t.Dwo;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
    }
    for (;;)
    {
      parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
      params = q.t.Dvy;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      AppMethodBeat.o(371486);
      return;
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Coe);
      kotlin.g.b.s.s(localObject1, "root.context.resources.g…e_action_enable_link_mic)");
      i = p.g.finder_icons_request_link_mic;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject3 = q.t.DvS;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      break;
      label740:
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Cod);
      kotlin.g.b.s.s(localObject1, "root.context.resources.g…_more_action_enable_gift)");
      i = p.g.finder_live_gift;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject3 = q.t.DvU;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      break label288;
      label799:
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvQ;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnM);
      break label361;
      label845:
      i = p.g.icons_outlined_chats;
      break label388;
      label852:
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvW;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnO);
      break label477;
      label898:
      i = p.g.icons_outlined_favour_on;
      break label504;
      label905:
      params.a(parambg.DfK, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CgU), p.g.icons_outlined_game_off);
      break label583;
      label939:
      params.a(parambg.DfQ, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CnR), p.g.finder_live_anonymous_0);
      parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
      params = q.t.Dwn;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    }
  }
  
  private final void e(com.tencent.mm.ui.base.s params)
  {
    Object localObject2 = null;
    AppMethodBeat.i(355302);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareAnchorZeroMenuItems: business(LiveCommonSlice::class.java).liveFinderObject.id:");
    Object localObject1 = ((e)business(e.class)).Eco;
    label89:
    int j;
    int k;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" hlsUrl:");
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu;
      if (localObject1 != null) {
        break label458;
      }
      localObject1 = localObject2;
      Log.i((String)localObject3, localObject1);
      j = this.Dfw;
      localObject1 = (CharSequence)this.mJe.getContext().getResources().getString(p.h.Cot);
      k = p.g.finder_icons_filled_share;
      int m = this.mJe.getContext().getResources().getColor(p.b.Brand);
      if (((e)business(e.class)).Eco != null)
      {
        localObject2 = ((e)business(e.class)).Eco;
        if ((localObject2 == null) || (((FinderObject)localObject2).id != 0L)) {
          break label500;
        }
        i = 1;
        label201:
        if (i == 0) {
          break label505;
        }
      }
      bool = true;
      label208:
      params.a(j, (CharSequence)localObject1, k, m, bool);
      j = this.Dfx;
      localObject1 = (CharSequence)this.mJe.getContext().getResources().getString(p.h.Cou);
      k = p.g.bottomsheet_icon_moment;
      if (((e)business(e.class)).Eco != null)
      {
        localObject2 = ((e)business(e.class)).Eco;
        if ((localObject2 == null) || (((FinderObject)localObject2).id != 0L)) {
          break label511;
        }
        i = 1;
        label301:
        if (i == 0) {
          break label516;
        }
      }
    }
    label516:
    for (boolean bool = true;; bool = false)
    {
      params.a(j, (CharSequence)localObject1, k, 0, bool);
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.Dvv;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.Dvw;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = com.tencent.mm.plugin.finder.live.util.m.DJb;
      if (com.tencent.mm.plugin.finder.live.util.m.euv())
      {
        params.a(this.DfN, (CharSequence)this.mJe.getContext().getResources().getString(p.h.Coh), p.g.icons_outlined_colorful_handoff, 0);
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrJ, String.valueOf(q.bg.DAN.type));
      }
      AppMethodBeat.o(355302);
      return;
      localObject1 = Long.valueOf(((FinderObject)localObject1).id);
      break;
      label458:
      Object localObject4 = ((com.tencent.mm.live.core.core.model.h)localObject1).mJH;
      localObject1 = localObject2;
      if (localObject4 == null) {
        break label89;
      }
      localObject4 = ((com.tencent.mm.live.core.core.model.g)localObject4).mNv;
      localObject1 = localObject2;
      if (localObject4 == null) {
        break label89;
      }
      localObject1 = ((diw)localObject4).aaNV;
      break label89;
      label500:
      i = 0;
      break label201;
      label505:
      bool = false;
      break label208;
      label511:
      i = 0;
      break label301;
    }
  }
  
  private boolean ere()
  {
    AppMethodBeat.i(355240);
    boolean bool = ((Boolean)this.Dgt.getValue()).booleanValue();
    AppMethodBeat.o(355240);
    return bool;
  }
  
  private final boolean erf()
  {
    AppMethodBeat.i(355248);
    boolean bool = ((e)business(e.class)).Ecu;
    AppMethodBeat.o(355248);
    return bool;
  }
  
  private final boolean erg()
  {
    AppMethodBeat.i(355255);
    boolean bool = ((e)business(e.class)).Ecv;
    AppMethodBeat.o(355255);
    return bool;
  }
  
  private final void erh()
  {
    AppMethodBeat.i(355346);
    ((e)business(e.class)).EcI = false;
    AppMethodBeat.o(355346);
  }
  
  private final int eri()
  {
    AppMethodBeat.i(355354);
    int i = com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 24);
    AppMethodBeat.o(355354);
    return i;
  }
  
  private final void erj()
  {
    AppMethodBeat.i(355363);
    b.b.a(this.nfT, b.c.nec);
    Object localObject = this.ngn;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject).cyW();
    }
    localObject = this.Dgn;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.view.j)localObject).fkO().cyW();
    }
    localObject = this.Dgo;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.view.j)localObject).fkO().cyW();
    }
    localObject = this.Dgp;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.view.j)localObject).fkO().cyW();
    }
    AppMethodBeat.o(355363);
  }
  
  private final void erk()
  {
    AppMethodBeat.i(355386);
    Log.i(this.TAG, "share2FriendImpl");
    Object localObject1 = ((e)business(e.class)).Eco;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      a((FinderObject)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo);
      localObject2 = FinderItem.Companion;
      localObject1 = FinderItem.a.e((FinderObject)localObject1, 16384);
      ((FinderItem)localObject1).setEcSource(((e)business(e.class)).Edn);
      localObject2 = new Bundle();
      localObject3 = this.Dgq;
      if (localObject3 != null) {
        break label168;
      }
    }
    label168:
    for (int i = 0;; i = ((com.tencent.mm.pluginsdk.q)localObject3).getItemCount())
    {
      ((Bundle)localObject2).putInt("quick_share_item_count", i);
      localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject3, "service(IActivityRouter::class.java)");
      f.a.a((com.tencent.mm.plugin.f)localObject3, (AppCompatActivity)this.activity, (FinderItem)localObject1, (Bundle)localObject2, 0, (kotlin.g.a.b)new bg.r(this), 8);
      erh();
      AppMethodBeat.o(355386);
      return;
    }
  }
  
  private final void erl()
  {
    AppMethodBeat.i(355396);
    Log.i(this.TAG, "share2SNSImpl");
    Object localObject1 = ((e)business(e.class)).Eco;
    if (localObject1 != null)
    {
      a((FinderObject)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo);
      Object localObject2 = FinderItem.Companion;
      localObject1 = FinderItem.a.e((FinderObject)localObject1, 16384);
      ((FinderItem)localObject1).setEcSource(((e)business(e.class)).Edn);
      localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject2, "service(IActivityRouter::class.java)");
      f.a.a((com.tencent.mm.plugin.f)localObject2, (AppCompatActivity)this.activity, (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.x((FinderItem)localObject1), null, 0, 28);
      erh();
    }
    AppMethodBeat.o(355396);
  }
  
  private final void erm()
  {
    AppMethodBeat.i(355409);
    Log.i(this.TAG, kotlin.g.b.s.X("share2StatusImpl ", Boolean.valueOf(ere())));
    if ((ere()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.n)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.class)).Ehh))
    {
      b.b.a(this.nfT, b.c.nfO);
      AppMethodBeat.o(355409);
      return;
    }
    Object localObject3 = ((e)business(e.class)).Eco;
    if (localObject3 != null)
    {
      a((FinderObject)localObject3, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo);
      Object localObject1 = c.zGj;
      Object localObject2 = ((e)business(e.class)).mIC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = ((FinderObject)localObject3).username;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      c.arw((String)localObject1);
      localObject1 = FinderItem.Companion;
      localObject3 = FinderItem.a.e((FinderObject)localObject3, 16384);
      ((FinderItem)localObject3).setEcSource(((e)business(e.class)).Edn);
      if (ere()) {
        ((FinderItem)localObject3).getFeedObject().wx_status_icon_id = "2022_hj";
      }
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject1, "service(IActivityRouter::class.java)");
      localObject1 = (com.tencent.mm.plugin.f)localObject1;
      localObject2 = (AppCompatActivity)this.activity;
      localObject3 = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.x((FinderItem)localObject3);
      Bundle localBundle = new Bundle();
      localBundle.putString("FINDER_LIVE_SHARE_KEY_STATUS_VERIFY", ((e)business(e.class)).EdM);
      ah localah = ah.aiuX;
      ((com.tencent.mm.plugin.f)localObject1).a((AppCompatActivity)localObject2, (BaseFinderFeed)localObject3, localBundle);
      erh();
    }
    AppMethodBeat.o(355409);
  }
  
  private final void ern()
  {
    AppMethodBeat.i(355419);
    Log.i(this.TAG, "exposeImpl");
    Object localObject = aj.CGT;
    localObject = aj.getFinderLiveAssistant();
    if (localObject != null) {
      ((ap)localObject).a((Context)this.activity, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((e)business(e.class)).mIC, null);
    }
    AppMethodBeat.o(355419);
  }
  
  private final void ero()
  {
    AppMethodBeat.i(355436);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
    kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    for (;;)
    {
      synchronized ((Iterable)localObject1)
      {
        Iterator localIterator = ???.iterator();
        if (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXL, ((e)business(e.class)).eyF());
          if (!bool) {
            continue;
          }
          if (localObject1 != null)
          {
            i = 1;
            if (i == 0) {
              break;
            }
            Log.i(this.TAG, "chooseVisitorRole linking");
            com.tencent.mm.plugin.finder.live.view.a.showAlertDialog$default(eoH(), (Activity)this.activity, "", MMApplicationContext.getContext().getResources().getString(p.h.CtM), "", false, 16, null);
            AppMethodBeat.o(355436);
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      int i = 0;
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eza())
    {
      b.b.a(this.nfT, b.c.neB);
      Log.i(this.TAG, "chooseVisitorRole linkWaiting");
      AppMethodBeat.o(355436);
      return;
    }
    boolean bool = isLandscape();
    Log.i(this.TAG, kotlin.g.b.s.X("chooseVisitorRole isLandscape:", Boolean.valueOf(bool)));
    if (bool)
    {
      b.b.a(this.nfT, b.c.nec);
      b.a((b)this, DgC);
      AppMethodBeat.o(355436);
      return;
    }
    Object localObject3 = aj.CGT;
    localObject3 = aj.getFinderLiveAssistant();
    if (localObject3 != null) {
      ap.a.a((ap)localObject3, (Activity)this.activity);
    }
    erj();
    AppMethodBeat.o(355436);
  }
  
  private final boolean erp()
  {
    AppMethodBeat.i(355447);
    boolean bool = ((e)business(e.class)).DUe;
    AppMethodBeat.o(355447);
    return bool;
  }
  
  private static final void f(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(355692);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    parambg.e(params);
    AppMethodBeat.o(355692);
  }
  
  private final void f(com.tencent.mm.ui.base.s params)
  {
    Object localObject2 = null;
    AppMethodBeat.i(355325);
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("prepareAnchorMenuItems: business(LiveCommonSlice::class.java).liveFinderObject.id:");
    Object localObject1 = ((e)business(e.class)).Eco;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(" hlsUrl:");
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu;
      if (localObject1 != null) {
        break label822;
      }
      localObject1 = localObject2;
      label82:
      Log.i((String)localObject3, localObject1);
      if ((com.tencent.mm.ui.aw.jlc()) && (com.tencent.mm.ui.aw.aAA(this.activity.getTaskId())))
      {
        if (!com.tencent.mm.ui.aw.aAj(this.activity.getTaskId())) {
          break label860;
        }
        params.a(this.DfM, (CharSequence)this.mJe.getContext().getString(p.h.close_split_screen), p.g.icons_outlined_merge);
      }
      label156:
      params.a(this.Dfz, (CharSequence)this.mJe.getContext().getResources().getString(p.h.finder_live_more_action_mini_window), p.g.icons_outlined_channels_minimize_new_bottom_sheet);
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.Dvy;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      if (!((e)business(e.class)).Eet)
      {
        localObject1 = com.tencent.mm.live.core.core.e.a.mRf;
        if (!com.tencent.mm.live.core.core.e.a.a.bek())
        {
          if (!((e)business(e.class)).Eem) {
            break label891;
          }
          params.a(this.DfH, (CharSequence)this.mJe.getContext().getResources().getString(p.h.CnY), p.g.icons_outlined_mic_on);
          localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localObject2 = q.t.DvN;
          localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        }
      }
      label312:
      localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
      if (b.a.bek())
      {
        params.a(this.DfI, (CharSequence)this.mJe.getContext().getResources().getString(p.h.Cqu), p.g.icons_outlined_time);
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject2 = q.t.DvO;
        localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
      params.a(this.DfT, (CharSequence)this.mJe.getContext().getResources().getString(p.h.CjN), p.g.icons_outlined_pencil);
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.c.DrR;
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put(q.d.Dsa.key, q.e.Dse.Dsd);
      localObject4 = ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.c)localObject2, ((JSONObject)localObject3).toString());
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvY;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jRP().bmg()).intValue() == 1)
      {
        params.a(this.DfV, (CharSequence)this.mJe.getContext().getResources().getString(p.h.Cko), p.g.icons_outlined_fast_comment);
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject2 = q.t.DvZ;
        localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
      if ((localObject1 == null) || (((bgw)localObject1).ZQq != true)) {
        break label951;
      }
    }
    label822:
    label951:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        params.bx(this.DfS, p.h.Cof, p.g.icons_outlined_fans);
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrO, "1");
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject2 = q.t.Dwb;
        localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if (com.tencent.mm.plugin.finder.utils.aw.bgV())
      {
        params.a(this.Dgi, (CharSequence)"Debug(内部)", p.g.icons_outlined_tag);
        params.a(this.Dgd, (CharSequence)"礼物用例(内部)", p.g.icons_outlined_tv);
        params.a(this.Dgc, (CharSequence)"单礼物动画(内部)", p.g.icons_outlined_tv);
        params.a(this.Dga, (CharSequence)"耗时(内部)", p.g.icons_outlined_time);
        params.a(this.Dgb, (CharSequence)"直播统计(内部)", p.g.icons_outlined_transfer);
        params.a(this.Dgf, (CharSequence)"battle胜", p.g.icons_outlined_tv);
        params.a(this.Dgg, (CharSequence)"battle负", p.g.icons_outlined_tv);
        params.a(this.Dgh, (CharSequence)"battle平", p.g.icons_outlined_tv);
      }
      AppMethodBeat.o(355325);
      return;
      localObject1 = Long.valueOf(((FinderObject)localObject1).id);
      break;
      Object localObject5 = ((com.tencent.mm.live.core.core.model.h)localObject1).mJH;
      localObject1 = localObject2;
      if (localObject5 == null) {
        break label82;
      }
      localObject5 = ((com.tencent.mm.live.core.core.model.g)localObject5).mNv;
      localObject1 = localObject2;
      if (localObject5 == null) {
        break label82;
      }
      localObject1 = ((diw)localObject5).aaNV;
      break label82;
      label860:
      params.a(this.DfM, (CharSequence)this.mJe.getContext().getString(p.h.split_screen), p.g.icons_outlined_sperated);
      break label156;
      label891:
      params.a(this.DfH, (CharSequence)this.mJe.getContext().getResources().getString(p.h.Cop), p.g.icons_outlined_mic_off);
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvM;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      break label312;
    }
  }
  
  private static final void g(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371488);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    parambg.f(params);
    AppMethodBeat.o(371488);
  }
  
  private static final void h(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371490);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    com.tencent.mm.plugin.finder.live.report.j localj;
    if ((((e)parambg.business(e.class)).Edv) && (((e)parambg.business(e.class)).Edx))
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUb())
      {
        if (!((e)parambg.business(e.class)).eyr()) {
          break label531;
        }
        localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Cob);
        kotlin.g.b.s.s(localObject1, "root.context.resources.g…more_action_disable_gift)");
        i = p.g.finder_live_ungift;
        localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject3 = q.t.DvV;
        localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        params.a(parambg.DfD, (CharSequence)localObject1, i);
      }
    }
    if (((e)parambg.business(e.class)).Ect)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvR;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnU);
      label211:
      kotlin.g.b.s.s(localObject1, "if (business(LiveCommonS…_allow_comment)\n        }");
      if (!((e)parambg.business(e.class)).Ect) {
        break label636;
      }
      i = p.g.icons_outlined_ban_chats;
      label238:
      params.a(parambg.DeO, (CharSequence)localObject1, i);
      if (((e)parambg.business(e.class)).Ecw)
      {
        if (!((e)parambg.business(e.class)).Ecx) {
          break label643;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject2 = q.t.DvX;
        localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnW);
        label327:
        kotlin.g.b.s.s(localObject1, "if (business(LiveCommonS…allow_like)\n            }");
        if (!((e)parambg.business(e.class)).Ecx) {
          break label689;
        }
        i = p.g.icons_outlined_favour_off;
        label354:
        params.a(parambg.DfL, (CharSequence)localObject1, i);
      }
      localObject1 = ((e)parambg.business(e.class)).CFy;
      if ((localObject1 != null) && (((bha)localObject1).ZQB == 1))
      {
        if (((bha)localObject1).ZQz != 1) {
          break label696;
        }
        params.a(parambg.DfJ, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CgW), p.g.icons_outlined_game_on);
      }
      label433:
      if (parambg.erf())
      {
        if (!parambg.erg()) {
          break label730;
        }
        params.a(parambg.DfR, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CnQ), p.g.finder_live_anonymous_1);
        parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
        params = q.t.Dwo;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
    }
    for (;;)
    {
      parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
      params = q.t.Dvy;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      AppMethodBeat.o(371490);
      return;
      label531:
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Cod);
      kotlin.g.b.s.s(localObject1, "root.context.resources.g…_more_action_enable_gift)");
      i = p.g.finder_live_gift;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject3 = q.t.DvU;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      break;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvQ;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnM);
      break label211;
      label636:
      i = p.g.icons_outlined_chats;
      break label238;
      label643:
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvW;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnO);
      break label327;
      label689:
      i = p.g.icons_outlined_favour_on;
      break label354;
      label696:
      params.a(parambg.DfK, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CgU), p.g.icons_outlined_game_off);
      break label433;
      label730:
      params.a(parambg.DfQ, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.CnR), p.g.finder_live_anonymous_0);
      parambg = com.tencent.mm.plugin.finder.live.report.j.Dob;
      params = q.t.Dwn;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      parambg.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    }
  }
  
  private final SpannableString hN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(355338);
    Object localObject = (CharSequence)paramString2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; (i != 0) || (!kotlin.n.n.a((CharSequence)paramString1, (CharSequence)paramString2, false)); i = 0)
    {
      Log.i(this.TAG, "assembleMenuItemTitleSpan title:" + paramString1 + ",subTitle:" + paramString2);
      paramString1 = new SpannableString((CharSequence)paramString1);
      AppMethodBeat.o(355338);
      return paramString1;
    }
    localObject = new SpannableString((CharSequence)paramString1);
    i = kotlin.n.n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    try
    {
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(this.mJe.getContext().getResources().getColor(p.b.BW_100_Alpha_0_5)), i, paramString2.length() + i, 33);
      AppMethodBeat.o(355338);
      return localObject;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString2 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        com.tencent.mm.plugin.finder.utils.aw.a(paramString1, kotlin.g.b.s.X(this.TAG, "-assembleMenuItemTitleSpan"));
      }
    }
  }
  
  private static final void i(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(355713);
    kotlin.g.b.s.u(parambg, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    parambg.e(params);
    AppMethodBeat.o(355713);
  }
  
  private static final void j(bg parambg, com.tencent.mm.ui.base.s params)
  {
    FinderObject localFinderObject = null;
    AppMethodBeat.i(371496);
    kotlin.g.b.s.u(parambg, "this$0");
    Object localObject1 = parambg.ngn;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject1).setFooterView(null);
    }
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    Object localObject2 = parambg.TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareVisitorMenuItems: business(LiveCommonSlice::class.java).liveFinderObject.id:");
    localObject1 = ((e)parambg.business(e.class)).Eco;
    label123:
    int j;
    int k;
    int m;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" hlsUrl:");
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu;
      if (localObject1 != null) {
        break label1146;
      }
      localObject1 = null;
      Log.i((String)localObject2, localObject1);
      j = parambg.Dfw;
      localObject1 = (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.Cot);
      k = p.g.finder_icons_filled_share;
      m = parambg.mJe.getContext().getResources().getColor(p.b.Brand);
      if (((e)parambg.business(e.class)).Eco != null)
      {
        localObject2 = ((e)parambg.business(e.class)).Eco;
        if ((localObject2 == null) || (((FinderObject)localObject2).id != 0L)) {
          break label1192;
        }
        i = 1;
        label235:
        if (i == 0) {
          break label1197;
        }
      }
      bool = true;
      label242:
      params.a(j, (CharSequence)localObject1, k, m, bool);
      j = parambg.Dfx;
      localObject1 = (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.Cou);
      k = p.g.bottomsheet_icon_moment;
      if (((e)parambg.business(e.class)).Eco != null)
      {
        localObject2 = ((e)parambg.business(e.class)).Eco;
        if ((localObject2 == null) || (((FinderObject)localObject2).id != 0L)) {
          break label1203;
        }
        i = 1;
        label335:
        if (i == 0) {
          break label1208;
        }
      }
      bool = true;
      label342:
      params.a(j, (CharSequence)localObject1, k, 0, bool);
      if ((ac.hFS()) && (((e)parambg.business(e.class)).EdM != null))
      {
        j = parambg.Dfy;
        localObject1 = (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.Cov);
        k = p.g.state_icon_main;
        m = parambg.mJe.getContext().getResources().getColor(p.b.Blue);
        if (((e)parambg.business(e.class)).Eco != null)
        {
          localObject2 = ((e)parambg.business(e.class)).Eco;
          if ((localObject2 == null) || (((FinderObject)localObject2).id != 0L)) {
            break label1214;
          }
          i = 1;
          label474:
          if (i == 0) {
            break label1219;
          }
        }
        bool = true;
        label481:
        params.a(j, (CharSequence)localObject1, k, m, bool);
        ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.Dvx);
      }
      if ((parambg.ere()) && (parambg.erd()))
      {
        j = parambg.DfW;
        localObject1 = (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.Cor);
        k = p.g.bottomsheet_icon_save_image;
        if (((e)parambg.business(e.class)).Eco != null)
        {
          localObject2 = ((e)parambg.business(e.class)).Eco;
          if ((localObject2 == null) || (((FinderObject)localObject2).id != 0L)) {
            break label1225;
          }
          i = 1;
          label600:
          if (i == 0) {
            break label1230;
          }
        }
        bool = true;
        label607:
        params.a(j, (CharSequence)localObject1, k, -16711936, bool);
        ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.Dvx);
      }
      if (!parambg.erd()) {
        if (!parambg.ere())
        {
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          label775:
          if (com.tencent.mm.plugin.finder.live.utils.a.euL())
          {
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu;
            if (localObject1 != null) {
              break label1236;
            }
            localObject1 = null;
            label682:
            if (!Util.isNullOrNil((String)localObject1))
            {
              if (((e)parambg.business(e.class)).Eed == null) {
                break label1292;
              }
              localObject2 = new StringBuilder().append(parambg.mJe.getContext().getResources().getString(p.h.CiQ)).append('\n');
              localObject1 = ((e)parambg.business(e.class)).Eed;
              if (localObject1 != null) {
                break label1282;
              }
              localObject1 = localFinderObject;
              label763:
              localObject1 = localObject1;
              j = parambg.DfG;
              localObject1 = (CharSequence)localObject1;
              k = p.g.finder_live_icons_outlined_cast_screen;
              m = parambg.mJe.getContext().getResources().getColor(p.b.Brand);
              if (((e)parambg.business(e.class)).Eco != null)
              {
                localFinderObject = ((e)parambg.business(e.class)).Eco;
                if ((localFinderObject == null) || (localFinderObject.id != 0L)) {
                  break label1321;
                }
                i = 1;
                label858:
                if (i == 0) {
                  break label1326;
                }
              }
            }
          }
        }
      }
    }
    label1192:
    label1197:
    label1326:
    for (boolean bool = true;; bool = false)
    {
      params.a(j, (CharSequence)localObject1, k, m, bool);
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.k.DsX);
      localObject1 = com.tencent.mm.plugin.finder.live.util.m.DJb;
      if ((com.tencent.mm.plugin.finder.live.util.m.euv()) && (!parambg.ere()))
      {
        params.a(parambg.DfN, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.Coh), p.g.icons_outlined_colorful_handoff, 0);
        com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.bg.DAN);
      }
      ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.Dvv);
      ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.Dvw);
      localObject1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if (com.tencent.mm.plugin.finder.utils.aw.bgV())
      {
        params.a(parambg.Dgi, (CharSequence)"Debug(内部)", p.g.icons_outlined_tag);
        params.a(parambg.Dgd, (CharSequence)"礼物用例(内部)", p.g.icons_outlined_tv);
        params.a(parambg.Dgc, (CharSequence)"单礼物动画(内部)", p.g.icons_outlined_tv);
        params.a(parambg.Dga, (CharSequence)"耗时(内部)", p.g.icons_outlined_time);
        params.a(parambg.Dgb, (CharSequence)"直播统计(内部)", p.g.icons_outlined_transfer);
        params.a(parambg.Dgf, (CharSequence)"battle胜", p.g.icons_outlined_tv);
        params.a(parambg.Dgg, (CharSequence)"battle负", p.g.icons_outlined_tv);
        params.a(parambg.Dgh, (CharSequence)"battle平", p.g.icons_outlined_tv);
      }
      AppMethodBeat.o(371496);
      return;
      localObject1 = Long.valueOf(((FinderObject)localObject1).id);
      break;
      label1146:
      localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mJH;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label123;
      }
      localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).mNv;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label123;
      }
      localObject1 = ((diw)localObject1).aaNV;
      break label123;
      i = 0;
      break label235;
      bool = false;
      break label242;
      label1203:
      i = 0;
      break label335;
      label1208:
      bool = false;
      break label342;
      label1214:
      i = 0;
      break label474;
      label1219:
      bool = false;
      break label481;
      label1225:
      i = 0;
      break label600;
      label1230:
      bool = false;
      break label607;
      label1236:
      localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mJH;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label682;
      }
      localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).mNv;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label682;
      }
      localObject1 = ((diw)localObject1).aaNV;
      break label682;
      localObject1 = ((o)localObject1).displayName;
      break label763;
      localObject1 = parambg.mJe.getContext().getResources().getString(p.h.CnZ);
      kotlin.g.b.s.s(localObject1, "{\n                root.c…ast_screen)\n            }");
      break label775;
      i = 0;
      break label858;
    }
  }
  
  private static final void k(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371497);
    kotlin.g.b.s.u(parambg, "this$0");
    com.tencent.mm.ui.widget.a.f localf = parambg.ngn;
    Object localObject;
    if ((localf != null) && (((e)parambg.business(e.class)).Eco != null))
    {
      localObject = ((e)parambg.business(e.class)).Eco;
      if ((localObject == null) || (((FinderObject)localObject).id != 0L)) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = parambg.Dgq;
        if (localObject != null)
        {
          parambg = parambg.mJe.getContext();
          kotlin.g.b.s.s(parambg, "root.context");
          kotlin.g.b.s.s(params, "it");
          ((com.tencent.mm.pluginsdk.q)localObject).a(parambg, params, localf, 2, (kotlin.g.a.b)l.DgE);
        }
      }
      AppMethodBeat.o(371497);
      return;
    }
  }
  
  private static final void l(bg parambg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(355772);
    kotlin.g.b.s.u(parambg, "this$0");
    Object localObject1 = parambg.ngn;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject1).setFooterView(null);
    }
    params.clear();
    int i;
    if (!parambg.erd())
    {
      kotlin.g.b.s.s(params, "menu");
      if (!parambg.erd()) {
        if ((com.tencent.mm.ui.aw.jlc()) && (com.tencent.mm.ui.aw.aAA(parambg.activity.getTaskId())))
        {
          if (com.tencent.mm.ui.aw.aAj(parambg.activity.getTaskId())) {
            params.a(parambg.DfM, (CharSequence)parambg.mJe.getContext().getString(p.h.close_split_screen), p.g.icons_outlined_merge);
          }
        }
        else
        {
          if (!((e)parambg.business(e.class)).EcH)
          {
            localObject1 = parambg.mJe.getContext().getResources().getString(p.h.Cos);
            kotlin.g.b.s.s(localObject1, "root.context.resources.g…more_action_screen_clear)");
            i = p.g.finder_icons_screen_clear;
            params.a(parambg.DfA, (CharSequence)localObject1, i);
          }
          localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
          if (((Number)com.tencent.d.a.a.a.a.a.jUC().bmg()).intValue() != 0) {
            break label938;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
          kotlin.g.b.s.s(localObject1, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
        }
      }
    }
    label535:
    label540:
    label550:
    label583:
    label592:
    label597:
    label1368:
    for (;;)
    {
      int j;
      synchronized ((Iterable)localObject1)
      {
        localObject3 = ((Iterable)???).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          boolean bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1).mXL, ((e)parambg.business(e.class)).eyF());
          if (!bool) {
            continue;
          }
          if (localObject1 == null) {
            break label535;
          }
          i = 1;
          localObject1 = com.tencent.mm.plugin.finder.live.widget.bd.EuM;
          localObject1 = aj.CGT;
          localObject1 = aj.elL();
          if (localObject1 != null) {
            break label540;
          }
          localObject3 = null;
          if (localObject3 != null) {
            break label550;
          }
          localObject1 = null;
          ??? = localObject1;
          if (i == 0) {
            break label611;
          }
          if (localObject1 != null) {
            break label583;
          }
          i = 0;
          ??? = localObject1;
          if (localObject3 == null) {
            break label597;
          }
          localObject3 = ((com.tencent.mm.live.core.core.d)localObject3).mJH;
          ??? = localObject1;
          if (localObject3 == null) {
            break label597;
          }
          localObject3 = ((com.tencent.mm.live.core.core.model.g)localObject3).mNt;
          ??? = localObject1;
          if (localObject3 == null) {
            break label597;
          }
          localObject3 = ((HashMap)localObject3).values();
          ??? = localObject1;
          if (localObject3 == null) {
            break label597;
          }
          localObject3 = ((Iterable)localObject3).iterator();
          ??? = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break label597;
          }
          ??? = (com.tencent.mm.live.core.core.model.j)((Iterator)localObject3).next();
          if (((com.tencent.mm.live.core.core.model.j)???).level <= i) {
            break label1368;
          }
          CharSequence localCharSequence = (CharSequence)((com.tencent.mm.live.core.core.model.j)???).desc;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label592;
          }
          j = 1;
          if (j != 0) {
            break label1368;
          }
          localObject1 = ???;
          continue;
          params.a(parambg.DfM, (CharSequence)parambg.mJe.getContext().getString(p.h.split_screen), p.g.icons_outlined_sperated);
          break;
        }
        localObject1 = null;
      }
      i = 0;
      continue;
      Object localObject3 = ((com.tencent.mm.live.core.core.f.d)localObject1).mUn;
      continue;
      localObject1 = ((com.tencent.mm.live.core.core.d)localObject3).mJH;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).sQ(((com.tencent.mm.live.core.core.d)localObject3).mJK);
        continue;
        i = ((com.tencent.mm.live.core.core.model.j)localObject1).level;
        continue;
        j = 0;
        continue;
        Log.i("FinderLiveVideoDefinitionWidget", kotlin.g.b.s.X("heightest level:", ???));
        label611:
        if (??? != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.model.j)???).desc;
          if (localObject1 != null) {
            if (((CharSequence)localObject1).length() == 0)
            {
              i = 1;
              if (i != 1) {
                break label1272;
              }
              i = 1;
              if (i != 0) {
                break label1316;
              }
              localObject1 = com.tencent.mm.plugin.finder.live.widget.bd.EuM;
              localObject1 = aj.CGT;
              localObject1 = aj.elL();
              if (localObject1 == null) {
                break label1287;
              }
              localObject1 = ((com.tencent.mm.live.core.core.f.d)localObject1).mUn;
              if (localObject1 == null) {
                break label1287;
              }
              localObject1 = ((com.tencent.mm.live.core.core.d)localObject1).mJH;
              if (localObject1 == null) {
                break label1287;
              }
              localObject1 = ((com.tencent.mm.live.core.core.model.g)localObject1).mNt.values();
              kotlin.g.b.s.s(localObject1, "liveInfo.cdnUrlMap.values");
              localObject1 = (Iterable)localObject1;
              if (((Collection)localObject1).isEmpty()) {
                break label1287;
              }
              localObject1 = ((Iterable)localObject1).iterator();
              label745:
              if (!((Iterator)localObject1).hasNext()) {
                break label1287;
              }
              localObject3 = (com.tencent.mm.live.core.core.model.j)((Iterator)localObject1).next();
              if (((com.tencent.mm.live.core.core.model.j)localObject3).level == 0) {
                break label1282;
              }
              localObject3 = (CharSequence)((com.tencent.mm.live.core.core.model.j)localObject3).desc;
              if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
                break label1277;
              }
              i = 1;
              if (i != 0) {
                break label1282;
              }
              i = 1;
              if (i == 0) {
                break label1285;
              }
              i = 1;
              if (i == 0) {
                break label1316;
              }
              if (??? != null) {
                break label1292;
              }
              localObject1 = "";
              localObject3 = parambg.mJe.getContext().getResources().getString(p.h.finder_live_more_action_customer_video_level, new Object[] { localObject1 });
              kotlin.g.b.s.s(localObject3, "root.context.resources.g…ideo_level, showLevelStr)");
              params.a(parambg.DfP, (CharSequence)parambg.hN((String)localObject3, (String)localObject1), p.g.finder_icons_video_definition);
              localObject1 = parambg.mJe.getContext();
              kotlin.g.b.s.s(localObject1, "root.context");
              parambg.Dgu = new com.tencent.mm.plugin.finder.live.widget.bd((Context)localObject1, parambg.getBuContext());
              localObject1 = parambg.Dgu;
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.finder.live.widget.bd)localObject1).EuN = ((com.tencent.mm.live.core.core.model.j)???);
              }
              if (!parambg.ere())
              {
                if (!((e)parambg.business(e.class)).EeM) {
                  break label1350;
                }
                params.bx(parambg.DfO, p.h.CkO, p.g.icons_filled_gift_effects_on);
              }
            }
          }
        }
        for (;;)
        {
          if ((parambg.Dgj) && (!parambg.ere()))
          {
            ??? = ((e)parambg.business(e.class)).EdI.nickname;
            localObject1 = ???;
            if (??? == null) {
              localObject1 = "";
            }
            ??? = parambg.mJe.getContext().getResources().getString(p.h.CtN, new Object[] { localObject1 });
            kotlin.g.b.s.s(???, "root.context.resources.g…ole_ui_new_tips, curRole)");
            params.a(parambg.DfE, (CharSequence)parambg.hN((String)???, (String)localObject1), p.g.icons_outlined_exchange);
          }
          if ((parambg.Dgk) && (!parambg.ere()))
          {
            params.bx(parambg.DfU, p.h.Coq, p.g.icons_outlined_more2);
            localObject1 = com.tencent.mm.kernel.h.ax(ce.class);
            kotlin.g.b.s.s(localObject1, "service(IHellLiveReport::class.java)");
            ce.a.a((ce)localObject1, q.t.DvC);
          }
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)parambg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egs) {
            params.bx(parambg.DfB, p.h.Cow, p.g.icons_outlined_winningrecord);
          }
          ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.Dvy);
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          if (((com.tencent.mm.plugin.findersdk.a.aa)com.tencent.mm.ui.component.k.d((AppCompatActivity)parambg.activity).cq(com.tencent.mm.plugin.findersdk.a.aa.class)).fnk()) {
            params.a(parambg.Dge, (CharSequence)"推荐信息", p.g.finder_icons_link);
          }
          params.a(parambg.DeR, (CharSequence)parambg.mJe.getContext().getResources().getString(p.h.finder_live_more_action_report), p.g.icons_outlined_report_problem);
          AppMethodBeat.o(355772);
          return;
          i = 0;
          break;
          label1272:
          i = 0;
          break label650;
          label1277:
          i = 0;
          break label802;
          i = 0;
          break label808;
          break label745;
          i = 0;
          break label814;
          localObject3 = ((com.tencent.mm.live.core.core.model.j)???).desc;
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label828;
          }
          localObject1 = "";
          break label828;
          Log.i(parambg.TAG, "showLevel:" + ??? + ", and not contain video level!");
          break label938;
          params.bx(parambg.DfO, p.h.CkM, p.g.icons_filled_gift_effects_off);
        }
      }
    }
  }
  
  private final void ru(boolean paramBoolean)
  {
    AppMethodBeat.i(355265);
    Log.i(this.TAG, kotlin.g.b.s.X("switchVisitorAnonymous isEnable:", Boolean.valueOf(paramBoolean)));
    if (paramBoolean) {}
    for (((e)business(e.class)).Ecp |= 0x2000;; ((e)business(e.class)).Ecp &= 0xFFFFDFFF)
    {
      o localo = new o(this);
      Object localObject = com.tencent.mm.plugin.finder.live.util.u.DJC;
      com.tencent.mm.plugin.finder.live.util.u.ey("VisitorAnonymous", ((e)business(e.class)).Ecp);
      localObject = aj.CGT;
      localObject = aj.getFinderLiveAssistant();
      if (localObject != null) {
        ap.a.a((ap)localObject, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)business(e.class)).Ecp, 8192L, 0, (e.a)localo, 16);
      }
      AppMethodBeat.o(355265);
      return;
    }
  }
  
  private final void rv(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(355287);
    final bha localbha = ((e)business(e.class)).CFy;
    String str = this.TAG;
    Object localObject3 = new StringBuilder("setGameTeam open:").append(paramBoolean).append(", gameInfo show:");
    if (localbha == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", size:");
      if (localbha != null) {
        break label132;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Log.i(str, localObject1);
      if ((localbha != null) && (localbha.ZQB == 1)) {
        break label181;
      }
      AppMethodBeat.o(355287);
      return;
      localObject1 = Integer.valueOf(localbha.ZQB);
      break;
      label132:
      localObject1 = localbha.ZQy;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((cbr)localObject1).aakZ;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
    }
    label181:
    if (paramBoolean)
    {
      localObject1 = localbha.ZQy;
      if (localObject1 == null) {}
      for (localObject1 = localObject2; (localObject1 == null) || (((LinkedList)localObject1).size() <= 0); localObject1 = ((cbr)localObject1).aakZ)
      {
        AppMethodBeat.o(355287);
        return;
      }
      localObject2 = new com.tencent.mm.plugin.finder.view.aa((kotlin.g.a.m)new n(this, localbha));
      str = this.mJe.getContext().getString(p.h.CgX);
      kotlin.g.b.s.s(str, "root.context.getString(R…ive_team_condition_title)");
      localObject3 = (List)localObject1;
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      int j;
      if (((Iterator)localObject1).hasNext()) {
        if (((des)((Iterator)localObject1).next()).value == localbha.ZQz)
        {
          j = 1;
          label330:
          if (j == 0) {
            break label387;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.view.aa)localObject2).c(str, (List)localObject3, i);
        ((com.tencent.mm.plugin.finder.view.m)localObject2).FyH = true;
        localObject1 = this.mJe.getContext();
        kotlin.g.b.s.s(localObject1, "root.context");
        ((com.tencent.mm.plugin.finder.view.aa)localObject2).hs((Context)localObject1);
        AppMethodBeat.o(355287);
        return;
        j = 0;
        break label330;
        i += 1;
        break;
        i = -1;
      }
    }
    label387:
    if (localbha.ZQz == 7) {
      com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.Dob, q.ba.DAq, 0, null, 6);
    }
    localbha.ZQz = 1;
    Object localObject1 = ab.CGy;
    ab.e(getBuContext());
    localObject1 = aj.CGT;
    localObject1 = aj.getFinderLiveAssistant();
    if (localObject1 != null)
    {
      localObject2 = this.mJe.getContext();
      kotlin.g.b.s.s(localObject2, "root.context");
      ((ap)localObject1).a((Context)localObject2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((e)business(e.class)).eyq(), (e.a)new m(this));
    }
    b.b.a(this.nfT, b.c.ndV);
    AppMethodBeat.o(355287);
  }
  
  public final void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(356026);
    if ((((e)business(e.class)).eyz()) || (((e)business(e.class)).isLiveStarted()))
    {
      if ((this.Dgr) && (!this.Dgs))
      {
        this.Dgl.performClick();
        this.Dgs = true;
      }
      if (com.tencent.mm.ae.d.ee(((e)business(e.class)).EcS, 2))
      {
        paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUC())
        {
          if (this.Dgn == null)
          {
            paramBundle = this.mJe.getContext();
            kotlin.g.b.s.s(paramBundle, "root.context");
            this.Dgn = new com.tencent.mm.plugin.finder.view.j(paramBundle);
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.fkS();
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.UE(this.mJe.getContext().getResources().getColor(p.b.ByL));
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.GAx = new bg..ExternalSyntheticLambda7(this);
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.GAy = new bg..ExternalSyntheticLambda8(this);
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.GAz = new bg..ExternalSyntheticLambda10(this);
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.a(this.Dgv);
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.b(this.Dgv);
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.c(this.Dgv);
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.a(new bg..ExternalSyntheticLambda3(this));
          }
          paramBundle = this.Dgn;
          if (paramBundle != null) {
            paramBundle.dDn();
          }
          AppMethodBeat.o(356026);
          return;
        }
        paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
        {
          if (this.Dgp == null)
          {
            paramBundle = this.mJe.getContext();
            kotlin.g.b.s.s(paramBundle, "root.context");
            this.Dgp = new com.tencent.mm.plugin.finder.view.j(paramBundle);
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.fkS();
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.UE(this.mJe.getContext().getResources().getColor(p.b.ByL));
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.GAx = new bg..ExternalSyntheticLambda11(this);
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.GAy = new bg..ExternalSyntheticLambda5(this);
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.GAz = new bg..ExternalSyntheticLambda15(this);
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.a(this.Dgv);
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.b(this.Dgv);
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.c(this.Dgv);
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.a(new bg..ExternalSyntheticLambda4(this));
          }
          paramBundle = this.Dgp;
          if (paramBundle != null) {
            paramBundle.dDn();
          }
          AppMethodBeat.o(356026);
          return;
        }
        if (((e)business(e.class)).DUe)
        {
          if (this.Dgo == null)
          {
            paramBundle = this.mJe.getContext();
            kotlin.g.b.s.s(paramBundle, "root.context");
            this.Dgo = new com.tencent.mm.plugin.finder.view.j(paramBundle);
          }
          paramBundle = this.Dgo;
          if (paramBundle != null) {
            paramBundle.fkS();
          }
          paramBundle = this.Dgo;
          if (paramBundle != null) {
            paramBundle.UE(this.mJe.getContext().getResources().getColor(p.b.ByL));
          }
          String str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("buildAssistantBottomSheet: business(LiveCommonSlice::class.java).liveFinderObject.id:");
          paramBundle = ((e)business(e.class)).Eco;
          if (paramBundle == null)
          {
            paramBundle = null;
            localStringBuilder = localStringBuilder.append(paramBundle).append(" hlsUrl:");
            paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZu;
            if (paramBundle != null) {
              break label923;
            }
            paramBundle = localObject1;
          }
          for (;;)
          {
            Log.i(str, paramBundle);
            com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, 11);
            paramBundle = this.Dgo;
            if (paramBundle != null) {
              paramBundle.GAx = new bg..ExternalSyntheticLambda9(this);
            }
            paramBundle = this.Dgo;
            if (paramBundle != null) {
              paramBundle.GAy = new bg..ExternalSyntheticLambda12(this);
            }
            paramBundle = this.Dgo;
            if (paramBundle != null) {
              paramBundle.GAz = new bg..ExternalSyntheticLambda14(this);
            }
            paramBundle = this.Dgo;
            if (paramBundle != null) {
              paramBundle.a(this.Dgv);
            }
            paramBundle = this.Dgo;
            if (paramBundle != null) {
              paramBundle.b(this.Dgv);
            }
            paramBundle = this.Dgo;
            if (paramBundle != null) {
              paramBundle.c(this.Dgv);
            }
            paramBundle = this.Dgo;
            if (paramBundle != null) {
              paramBundle.a(new bg..ExternalSyntheticLambda2(this));
            }
            paramBundle = this.Dgo;
            if (paramBundle != null) {
              paramBundle.dDn();
            }
            AppMethodBeat.o(356026);
            return;
            paramBundle = Long.valueOf(paramBundle.id);
            break;
            label923:
            Object localObject2 = paramBundle.mJH;
            paramBundle = localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((com.tencent.mm.live.core.core.model.g)localObject2).mNv;
              paramBundle = localObject1;
              if (localObject2 != null) {
                paramBundle = ((diw)localObject2).aaNV;
              }
            }
          }
        }
        if (this.ngn == null)
        {
          this.ngn = new com.tencent.mm.ui.widget.a.f(this.mJe.getContext(), 0, true);
          paramBundle = this.ngn;
          if (paramBundle != null) {
            paramBundle.sRz = isLandscape();
          }
          paramBundle = this.ngn;
          if (paramBundle != null) {
            paramBundle.NyV = true;
          }
        }
        if (this.Dgq == null)
        {
          this.Dgq = ((com.tencent.mm.pluginsdk.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.q.class)).iGI();
          paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
          paramBundle = this.mJe.getContext();
          kotlin.g.b.s.s(paramBundle, "root.context");
          paramBundle = (emx)com.tencent.mm.plugin.secdata.ui.a.a.c(paramBundle, 14, emx.class);
          if (paramBundle != null) {
            paramBundle.scene = 8;
          }
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.NE(true);
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.agfb = false;
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.Vtg = new bg..ExternalSyntheticLambda6(this);
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.GAz = new bg..ExternalSyntheticLambda13(this);
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.GAx = new bg..ExternalSyntheticLambda16(this);
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.GAC = this.Dgv;
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.agem = this.Dgv;
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.agen = this.Dgw;
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.ageo = this.Dgx;
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.aeLi = new bg..ExternalSyntheticLambda21(this);
        }
        paramBundle = this.ngn;
        if (paramBundle != null) {
          paramBundle.dDn();
        }
      }
    }
    AppMethodBeat.o(356026);
  }
  
  public final void c(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(356043);
    if (paramBundle == null) {
      paramBundle = "";
    }
    while (kotlin.g.b.s.p(paramBundle, Dgy))
    {
      erk();
      AppMethodBeat.o(356043);
      return;
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject == null) {
        paramBundle = "";
      }
    }
    if (kotlin.g.b.s.p(paramBundle, Dgz))
    {
      erl();
      AppMethodBeat.o(356043);
      return;
    }
    if (kotlin.g.b.s.p(paramBundle, DgA))
    {
      erm();
      AppMethodBeat.o(356043);
      return;
    }
    if (kotlin.g.b.s.p(paramBundle, DgB))
    {
      ern();
      AppMethodBeat.o(356043);
      return;
    }
    if (kotlin.g.b.s.p(paramBundle, DgC))
    {
      paramBundle = aj.CGT;
      paramBundle = aj.getFinderLiveAssistant();
      if (paramBundle != null) {
        ap.a.a(paramBundle, (Activity)this.activity);
      }
    }
    AppMethodBeat.o(356043);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final boolean erd()
  {
    AppMethodBeat.i(355232);
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.n)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.class)).Ehh;
    AppMethodBeat.o(355232);
    return bool;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(356047);
    if (paramInt1 == 1009)
    {
      if (paramIntent == null) {}
      for (;;)
      {
        Log.i(this.TAG, kotlin.g.b.s.X("REQUEST_FINDER_LIVE_ROLE fromUserGuide:", Boolean.valueOf(bool)));
        if ((paramInt2 != -1) || (bool)) {
          break;
        }
        paramIntent = aj.CGT;
        paramIntent = aj.getFinderLiveAssistant();
        if (paramIntent == null) {
          break label121;
        }
        paramIntent.ekn();
        AppMethodBeat.o(356047);
        return;
        bool = paramIntent.getBooleanExtra("KEY_IS_FROM_SETTING", false);
      }
      Log.i(this.TAG, "REQUEST_FINDER_LIVE_ROLE resultCode:" + paramInt2 + ",data:" + paramIntent);
    }
    label121:
    AppMethodBeat.o(356047);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(356035);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    int i;
    label225:
    do
    {
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(356035);
            return;
            tO(4);
            this.njA = false;
            AppMethodBeat.o(356035);
            return;
            this.njA = true;
            paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          } while ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!((e)business(e.class)).DUe));
          this.Dgm.setImageDrawable(bb.m(this.mJe.getContext(), p.g.icons_filled_more, -1));
          AppMethodBeat.o(356035);
          return;
          paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
          AppMethodBeat.o(356035);
          return;
          paramc = this.Dgu;
        } while (paramc == null);
        paramc.sI(true);
        AppMethodBeat.o(356035);
        return;
        paramc = this.Dgu;
      } while (paramc == null);
      paramc.sI(false);
      AppMethodBeat.o(356035);
      return;
      if (paramBundle != null) {
        break;
      }
      i = 0;
      paramc = ((e)business(e.class)).Eco;
    } while (paramc == null);
    a(paramc, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo);
    paramBundle = FinderItem.Companion;
    paramc = FinderItem.a.e(paramc, 16384);
    paramc.setEcSource(((e)business(e.class)).Edn);
    paramBundle = new Bundle();
    Object localObject = this.Dgq;
    if (localObject == null) {}
    for (int j = 0;; j = ((com.tencent.mm.pluginsdk.q)localObject).getItemCount())
    {
      paramBundle.putInt("quick_share_item_count", j);
      paramBundle.putInt("Select_Conv_Type", 16);
      paramBundle.putIntArray("search_range", new int[] { 131075 });
      localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject, "service(IActivityRouter::class.java)");
      f.a.a((com.tencent.mm.plugin.f)localObject, (AppCompatActivity)this.activity, paramc, paramBundle, 0, (kotlin.g.a.b)new bg.q(this, i), 8);
      erh();
      break;
      i = paramBundle.getInt("requestCode");
      break label225;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(356054);
    super.unMount();
    com.tencent.mm.plugin.finder.live.widget.bd localbd = this.Dgu;
    if (localbd != null)
    {
      localbd.EuO = false;
      localbd.EuN = null;
      localbd.buContext = null;
    }
    AppMethodBeat.o(356054);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$banComment$callBack$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements e.a
  {
    c(bg parambg) {}
    
    public final void a(bvg parambvg)
    {
      AppMethodBeat.i(354449);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354449);
    }
    
    public final void am(int paramInt, long paramLong)
    {
      AppMethodBeat.i(354428);
      if (!com.tencent.mm.ae.d.ee(paramInt, 8))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label74;
        }
      }
      label74:
      for (String str = this.DgD.mJe.getContext().getResources().getString(p.h.CnN);; str = this.DgD.mJe.getContext().getResources().getString(p.h.CnV))
      {
        kotlin.g.b.s.s(str, "if (enable) {\n          …t_done)\n                }");
        com.tencent.mm.ui.base.aa.db(this.DgD.mJe.getContext(), str);
        AppMethodBeat.o(354428);
        return;
        paramInt = 0;
        break;
      }
    }
    
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(354440);
      if (!com.tencent.mm.ae.d.ee(paramInt3, 8))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label140;
        }
      }
      label140:
      for (Object localObject = this.DgD.mJe.getContext().getResources().getString(p.h.CnM);; localObject = this.DgD.mJe.getContext().getResources().getString(p.h.CnU))
      {
        kotlin.g.b.s.s(localObject, "if (enable) root.context…_more_action_ban_comment)");
        com.tencent.mm.ui.base.aa.makeText(this.DgD.mJe.getContext(), (CharSequence)kotlin.g.b.s.X((String)localObject, this.DgD.mJe.getContext().getResources().getString(p.h.CgB)), 0).show();
        localObject = bc.GkH;
        String str = bc.fhO();
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
        this.DgD.getBuContext();
        bc.it(str, (String)localObject);
        AppMethodBeat.o(354440);
        return;
        paramInt1 = 0;
        break;
      }
    }
    
    public final void eho()
    {
      AppMethodBeat.i(354454);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354454);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$banLike$callback$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements e.a
  {
    d(bg parambg) {}
    
    public final void a(bvg parambvg)
    {
      AppMethodBeat.i(354556);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354556);
    }
    
    public final void am(int paramInt, long paramLong)
    {
      AppMethodBeat.i(354537);
      boolean bool;
      if (!com.tencent.mm.ae.d.ee(paramInt, 512))
      {
        bool = true;
        if (!bool) {
          break label117;
        }
      }
      label117:
      for (Object localObject = this.DgD.mJe.getContext().getResources().getString(p.h.CnP);; localObject = this.DgD.mJe.getContext().getResources().getString(p.h.CnX))
      {
        kotlin.g.b.s.s(localObject, "if (enable) {\n          …e_done)\n                }");
        com.tencent.mm.ui.base.aa.db(this.DgD.mJe.getContext(), (String)localObject);
        localObject = new Bundle();
        bg localbg = this.DgD;
        ((Bundle)localObject).putBoolean("PARAM_FINDER_LIVE_LIKE_ENABLE", bool);
        bg.f(localbg).statusChange(b.c.nfd, (Bundle)localObject);
        AppMethodBeat.o(354537);
        return;
        bool = false;
        break;
      }
    }
    
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(354546);
      if (!com.tencent.mm.ae.d.ee(paramInt3, 512))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label102;
        }
      }
      label102:
      for (paramString = this.DgD.mJe.getContext().getResources().getString(p.h.CnO);; paramString = this.DgD.mJe.getContext().getResources().getString(p.h.CnW))
      {
        kotlin.g.b.s.s(paramString, "if (enable) root.context…ive_more_action_ban_like)");
        com.tencent.mm.ui.base.aa.makeText(this.DgD.mJe.getContext(), (CharSequence)kotlin.g.b.s.X(paramString, this.DgD.mJe.getContext().getResources().getString(p.h.CgB)), 0).show();
        AppMethodBeat.o(354546);
        return;
        paramInt1 = 0;
        break;
      }
    }
    
    public final void eho()
    {
      AppMethodBeat.i(354564);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354564);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    e(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$menuItemClickListener$1$6", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFailWithResponse", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusResponse;", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements e.a
  {
    h(ViewGroup paramViewGroup, bg parambg) {}
    
    private static final void f(com.tencent.mm.ui.widget.a.j paramj)
    {
      AppMethodBeat.i(354890);
      kotlin.g.b.s.u(paramj, "$dialog");
      paramj.cyW();
      AppMethodBeat.o(354890);
    }
    
    public final void a(bvg parambvg)
    {
      AppMethodBeat.i(354910);
      kotlin.g.b.s.u((e.a)this, "this");
      int i;
      if (parambvg != null)
      {
        parambvg = parambvg.lym;
        if (parambvg != null)
        {
          if (((CharSequence)parambvg).length() <= 0) {
            break label264;
          }
          i = 1;
          if (i == 0) {
            break label269;
          }
        }
      }
      for (;;)
      {
        if (parambvg != null)
        {
          Object localObject1 = this.nhV;
          Object localObject2 = parambg;
          com.tencent.mm.ui.widget.a.j localj = new com.tencent.mm.ui.widget.a.j(((ViewGroup)localObject1).getContext(), 2, 2, true, (byte)0);
          localj.au((CharSequence)((ViewGroup)localObject1).getContext().getResources().getString(p.h.app_i_know));
          localj.aFe(6);
          TextView localTextView = new TextView(((ViewGroup)localObject1).getContext());
          localTextView.setPaddingRelative(bg.i((bg)localObject2), 0, 0, 0);
          localTextView.setText(p.h.Cog);
          localTextView.setTextColor(localTextView.getContext().getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_8));
          localTextView.setTextSize(17.0F);
          localObject2 = ah.aiuX;
          localj.setHeaderView((View)localTextView);
          localObject1 = new TextView(((ViewGroup)localObject1).getContext());
          ((TextView)localObject1).setText((CharSequence)parambvg);
          ((TextView)localObject1).setTextColor(((TextView)localObject1).getContext().getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_8));
          ((TextView)localObject1).setTextSize(15.0F);
          parambvg = ah.aiuX;
          localj.setCustomView((View)localObject1);
          localj.agfR = new bg.h..ExternalSyntheticLambda0(localj);
          localj.dDn();
        }
        AppMethodBeat.o(354910);
        return;
        label264:
        i = 0;
        break;
        label269:
        parambvg = null;
      }
    }
    
    public final void am(int paramInt, long paramLong)
    {
      AppMethodBeat.i(354899);
      kotlin.g.b.s.u((e.a)this, "this");
      com.tencent.mm.ui.base.aa.db(this.nhV.getContext(), this.nhV.getContext().getResources().getString(p.h.CkQ));
      AppMethodBeat.o(354899);
    }
    
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(354919);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354919);
    }
    
    public final void eho()
    {
      AppMethodBeat.i(354925);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354925);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    i(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements RequestFloatWindowPermissionDialog.a
  {
    j(bg parambg) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(354741);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      if (bg.e(this.DgD))
      {
        if (bg.f(this.DgD).getLiveRole() == 1)
        {
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (!com.tencent.mm.plugin.finder.live.utils.a.n(this.DgD.getBuContext()))
          {
            paramRequestFloatWindowPermissionDialog = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (!com.tencent.mm.plugin.finder.live.utils.a.o(this.DgD.getBuContext())) {}
          }
          else
          {
            paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.e.a.mRf;
            com.tencent.mm.live.core.core.e.a.a.beN().mRB.mNF = true;
          }
        }
        for (;;)
        {
          paramRequestFloatWindowPermissionDialog = new Bundle();
          bg localbg = this.DgD;
          paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
          paramRequestFloatWindowPermissionDialog.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
          bg.f(localbg).statusChange(b.c.ncx, paramRequestFloatWindowPermissionDialog);
          if (bg.f(this.DgD).getLiveRole() != 1) {
            break;
          }
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.plugin.finder.live.report.j.Dob;
          com.tencent.mm.plugin.finder.live.report.j.Doc.Dqr = true;
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.plugin.finder.live.report.j.Dob;
          com.tencent.mm.plugin.finder.live.report.j.Doc.Dqs = false;
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Dri, String.valueOf(q.z.Dxy.type));
          AppMethodBeat.o(354741);
          return;
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.a.b.mMo;
          b.a.bej().mRB.mNF = true;
          continue;
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.f.a.mUf;
          paramRequestFloatWindowPermissionDialog = com.tencent.mm.live.core.core.f.a.a.hH(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.DgD.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
          if (paramRequestFloatWindowPermissionDialog != null)
          {
            paramRequestFloatWindowPermissionDialog = paramRequestFloatWindowPermissionDialog.mRB;
            if (paramRequestFloatWindowPermissionDialog != null) {
              paramRequestFloatWindowPermissionDialog.mNF = true;
            }
          }
        }
        com.tencent.mm.plugin.finder.live.report.k.Doi.a(true, q.z.Dxy);
      }
      AppMethodBeat.o(354741);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(354752);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      paramRequestFloatWindowPermissionDialog.finish();
      b.b.a(bg.f(this.DgD), b.c.ncA);
      AppMethodBeat.o(354752);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(354761);
      kotlin.g.b.s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      b.b.a(bg.f(this.DgD), b.c.ncC);
      AppMethodBeat.o(354761);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$pauseLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements al.a
  {
    k(bg parambg) {}
    
    public final void a(int paramInt1, int paramInt2, bse parambse)
    {
      AppMethodBeat.i(354710);
      kotlin.g.b.s.u(parambse, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        parambse = (e)this.DgD.business(e.class);
        bix localbix = new bix();
        localbix.show_type = 2;
        localbix.ZSF = 0;
        ah localah = ah.aiuX;
        parambse.a(localbix, false, (kotlin.g.a.m)new a(this.DgD));
        AppMethodBeat.o(354710);
        return;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.DgD));
      AppMethodBeat.o(354710);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "pause", "", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.m<Boolean, Integer, ah>
    {
      a(bg parambg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      b(bg parambg)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "show", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    public static final l DgE;
    
    static
    {
      AppMethodBeat.i(354800);
      DgE = new l();
      AppMethodBeat.o(354800);
    }
    
    l()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$setGameTeam$2", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements e.a
  {
    m(bg parambg) {}
    
    public final void a(bvg parambvg)
    {
      AppMethodBeat.i(354783);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354783);
    }
    
    public final void am(int paramInt, long paramLong)
    {
      AppMethodBeat.i(354766);
      Log.i(bg.g(this.DgD), "onSuccess");
      com.tencent.mm.ui.base.aa.y(this.DgD.mJe.getContext(), this.DgD.mJe.getContext().getResources().getString(p.h.CgV), p.g.icons_filled_done);
      AppMethodBeat.o(354766);
    }
    
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(354773);
      Log.i(bg.g(this.DgD), "onFail");
      AppMethodBeat.o(354773);
    }
    
    public final void eho()
    {
      AppMethodBeat.i(354797);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354797);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JoinTeamQualificationsInfo;", "setValue", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.m<des, Integer, ah>
  {
    n(bg parambg, bha parambha)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$switchVisitorAnonymous$callBack$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements e.a
  {
    o(bg parambg) {}
    
    public final void a(bvg parambvg)
    {
      AppMethodBeat.i(354974);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354974);
    }
    
    public final void am(int paramInt, long paramLong)
    {
      AppMethodBeat.i(354956);
      Log.i(bg.g(this.DgD), kotlin.g.b.s.X("switchVisitorAnonymous-callBack-onSuccess anchorStatus", Integer.valueOf(paramInt)));
      q.s locals;
      com.tencent.mm.plugin.finder.live.report.j localj;
      if (com.tencent.mm.ae.d.ee(paramInt, 8192))
      {
        localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
        locals = q.s.Dvb;
        localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject).a(locals, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
      for (Object localObject = this.DgD.mJe.getContext().getResources().getString(p.h.CnT);; localObject = this.DgD.mJe.getContext().getResources().getString(p.h.CnL))
      {
        kotlin.g.b.s.s(localObject, "if (enable) {\n          …s_done)\n                }");
        com.tencent.mm.ui.base.aa.db(this.DgD.mJe.getContext(), (String)localObject);
        AppMethodBeat.o(354956);
        return;
        localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
        locals = q.s.Dvc;
        localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject).a(locals, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
    }
    
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(354964);
      Log.i(bg.g(this.DgD), "switchVisitorAnonymous-callBack-onFail anchorStatus" + paramInt3 + " errType=" + paramInt1 + " errCode=" + paramInt2 + " errMsg=" + paramString);
      AppMethodBeat.o(354964);
    }
    
    public final void eho()
    {
      AppMethodBeat.i(354984);
      kotlin.g.b.s.u(this, "this");
      AppMethodBeat.o(354984);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "userName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    p(bg parambg, ViewGroup paramViewGroup, FinderObject paramFinderObject, MenuItem paramMenuItem)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bg
 * JD-Core Version:    0.7.0.1
 */