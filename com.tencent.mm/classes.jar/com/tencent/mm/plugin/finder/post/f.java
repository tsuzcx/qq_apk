package com.tencent.mm.plugin.finder.post;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.autogen.mmdata.rpt.qn;
import com.tencent.mm.live.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo.Resp;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.i.a;
import com.tencent.mm.plugin.finder.utils.LocalFinderAtContactParcel;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.finder.view.FinderChooseNewsView;
import com.tencent.mm.plugin.finder.view.FinderChooseOriginalView;
import com.tencent.mm.plugin.finder.view.FinderExtendActivityView;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "FLUTTER_TAG", "", "TAG", "actionBarHeight", "", "activityPostView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "activityWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget;", "addMediaBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getAddMediaBtn", "()Landroid/view/View;", "addMediaBtn$delegate", "Lkotlin/Lazy;", "avatarIv", "Landroid/widget/ImageView;", "backBtn", "getBackBtn", "backBtn$delegate", "bottomSpace", "checkPostTime", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "delMediaBtn", "getDelMediaBtn", "delMediaBtn$delegate", "edtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "extendLinkWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendLinkWidget;", "getExtendLinkWidget", "()Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendLinkWidget;", "setExtendLinkWidget", "(Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendLinkWidget;)V", "hasStartKeyBoardProvider", "", "header", "getHeader", "header$delegate", "jumpId", "jumpInfoEventListener", "com/tencent/mm/plugin/finder/post/PostMainUIC$jumpInfoEventListener$1", "Lcom/tencent/mm/plugin/finder/post/PostMainUIC$jumpInfoEventListener$1;", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "mediaViewContainer", "Landroid/view/ViewGroup;", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "myFinderUser", "newsWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderSetNewsFeedWidget;", "nickTv", "Landroid/widget/TextView;", "originalWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "pageInTimeStamp", "", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "setPostDataManager", "(Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "reportFlag", "reportObj", "Lorg/json/JSONObject;", "getReportObj", "()Lorg/json/JSONObject;", "setReportObj", "(Lorg/json/JSONObject;)V", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "setScrollView", "(Landroid/widget/ScrollView;)V", "sendBtn", "getSendBtn", "sendBtn$delegate", "srcType", "udfContent", "vstId", "backtoApp", "", "appId", "checkNeedScroll", "checkNextEnable", "checkPostData", "delMediaInternal", "enterFinderMediaPreviewAtTimelineUI", "exitAndSave", "fillCampaignJumpInfo", "intent", "Landroid/content/Intent;", "getJumpInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "isSave", "getLayoutId", "getTransaction", "transData", "Landroid/os/Bundle;", "initDelMediaBtn", "initPostMediaWidget", "initView", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onCreate", "savedInstanceState", "onDestroy", "onKeyboardHeightChanged", "height", "isResized", "onResume", "onUserVisibleFocused", "postEditUIC", "Lcom/tencent/mm/plugin/finder/post/PostEditUIC;", "postExtendLinkUIC", "Lcom/tencent/mm/plugin/finder/post/PostExtendLinkUIC;", "postLocationUIC", "Lcom/tencent/mm/plugin/finder/post/PostLocationUIC;", "reportMediaDelOp", "action", "restore", "routeBack", "saved", "routeForward", "localId", "save", "selectMedia", "send", "bundle", "resp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "appInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppInfo;", "setWindowStyle", "showDelBottomSheet", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
  implements com.tencent.mm.ui.tools.h
{
  public static final f.a ETt;
  private String AtZ;
  private String Aua;
  private int BqU;
  private String Bre;
  private String DUN;
  private View DXr;
  private View DXs;
  private final View.OnLayoutChangeListener DXz;
  private com.tencent.mm.plugin.finder.upload.postui.h ETA;
  private com.tencent.mm.plugin.finder.upload.postui.a ETB;
  private FinderExtendActivityView ETC;
  private final kotlin.j ETD;
  private final kotlin.j ETE;
  private final kotlin.j ETF;
  private final kotlin.j ETG;
  private final kotlin.j ETH;
  public com.tencent.mm.plugin.finder.widget.post.c ETI;
  private long ETJ;
  private int ETK;
  private JSONObject ETL;
  private boolean ETM;
  private JSONObject ETN;
  private final PostMainUIC.jumpInfoEventListener.1 ETO;
  private final String ETu;
  private ViewGroup ETv;
  private boolean ETw;
  private com.tencent.mm.plugin.finder.widget.post.a ETx;
  public com.tencent.mm.plugin.finder.upload.postui.e ETy;
  private com.tencent.mm.plugin.finder.upload.postui.g ETz;
  private final String TAG;
  private com.tencent.mm.plugin.finder.api.m contact;
  public ScrollView lDL;
  private ImageView lKK;
  private com.tencent.mm.ui.tools.i lKz;
  private TextView pWj;
  private w psR;
  
  static
  {
    AppMethodBeat.i(349888);
    ETt = new f.a((byte)0);
    AppMethodBeat.o(349888);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(349511);
    this.TAG = "Finder.FinderPostUI";
    this.ETu = "Finder.FinderRecordPluginLayout.FlutterVideoEditor_DataReport";
    this.Bre = "";
    this.ETD = kotlin.k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.ETE = kotlin.k.cm((kotlin.g.a.a)new b(paramAppCompatActivity));
    this.ETF = kotlin.k.cm((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.ETG = kotlin.k.cm((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.ETH = kotlin.k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.AtZ = "";
    this.Aua = "";
    this.DUN = "";
    this.DXz = new f..ExternalSyntheticLambda8(this);
    this.ETN = new JSONObject();
    this.ETO = new PostMainUIC.jumpInfoEventListener.1(this, paramAppCompatActivity, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(349511);
  }
  
  private static void a(Bundle paramBundle, BaseResp paramBaseResp, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(349636);
    paramBaseResp.openId = paramg.field_openId;
    paramBaseResp.toBundle(paramBundle);
    paramBaseResp = new MMessageActV2.Args();
    paramBaseResp.targetPkgName = paramg.field_packageName;
    paramBaseResp.bundle = paramBundle;
    com.tencent.mm.pluginsdk.model.app.u.bS(paramBundle);
    com.tencent.mm.pluginsdk.model.app.u.bT(paramBundle);
    MMessageActV2.send(MMApplicationContext.getContext(), paramBaseResp);
    AppMethodBeat.o(349636);
  }
  
  private static final void a(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(349754);
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.ewP().scrollBy(0, paramInt1 - paramInt2);
    AppMethodBeat.o(349754);
  }
  
  private static final void a(f paramf, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(349797);
    kotlin.g.b.s.u(paramf, "this$0");
    paramDialogInterface = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
    paramDialogInterface = v.FrN;
    paramDialogInterface = v.eMS();
    if (paramDialogInterface == null)
    {
      paramDialogInterface = "";
      localObject1 = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(paramDialogInterface, com.tencent.mm.plugin.finder.report.postreport.b.eOj());
      paramDialogInterface = paramf.ETx;
      if (paramDialogInterface != null) {
        break label162;
      }
      paramDialogInterface = null;
      label56:
      localObject1 = paramDialogInterface;
      if (paramDialogInterface == null)
      {
        paramDialogInterface = paramf.eHl().Gcx;
        if (paramDialogInterface != null) {
          break label170;
        }
      }
    }
    com.tencent.mm.plugin.finder.widget.post.c localc;
    Activity localActivity;
    label162:
    label170:
    for (paramInt = 0;; paramInt = paramDialogInterface.getMediaType())
    {
      localObject1 = new com.tencent.mm.plugin.finder.widget.post.h(false, paramInt, null);
      localc = paramf.eHl();
      localActivity = (Activity)paramf.getActivity();
      paramDialogInterface = paramf.eHw().eGZ().getText().toString();
      if (paramDialogInterface != null) {
        break label178;
      }
      paramf = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(349797);
      throw paramf;
      localObject1 = paramDialogInterface.flowId;
      paramDialogInterface = (DialogInterface)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramDialogInterface = "";
      break;
      paramDialogInterface = paramDialogInterface.fqC();
      break label56;
    }
    label178:
    String str = n.br((CharSequence)paramDialogInterface).toString();
    ArrayList localArrayList = paramf.eHw().eHc().fmb().flX();
    Object localObject2 = paramf.ETB;
    paramDialogInterface = (DialogInterface)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("activityWidget");
      paramDialogInterface = null;
    }
    brg localbrg = paramDialogInterface.Gfj.getActivityEvent();
    localObject2 = paramf.ETB;
    paramDialogInterface = (DialogInterface)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("activityWidget");
      paramDialogInterface = null;
    }
    Object localObject1 = localc.a(localActivity, str, (com.tencent.mm.plugin.finder.widget.post.h)localObject1, false, localArrayList, localbrg, paramDialogInterface.feC(), paramf.sW(true));
    if (paramf.eHl().GZS > 0L)
    {
      if (paramf.eHl().GZU) {
        com.tencent.mm.plugin.finder.storage.j.FKc.pY(paramf.eHl().GZS);
      }
    }
    else
    {
      paramDialogInterface = null;
      if ((paramf.eHl().Gcx == null) || (paramDialogInterface == null)) {
        break label573;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.i.FKa;
      localObject1 = i.a.p((FinderItem)localObject1);
      ((com.tencent.mm.plugin.finder.storage.i)localObject1).field_objectId = paramDialogInterface.field_objectId;
      ((com.tencent.mm.plugin.finder.storage.i)localObject1).field_localFlag = 1;
      ((com.tencent.mm.plugin.finder.storage.i)localObject1).field_version = (paramDialogInterface.field_version + 1);
      paramDialogInterface = ((com.tencent.mm.plugin.finder.storage.i)localObject1).eYK().field_postinfo;
      if (paramDialogInterface != null) {
        paramDialogInterface.nrQ = 0;
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
      com.tencent.mm.plugin.finder.storage.logic.c.af(((com.tencent.mm.plugin.finder.storage.i)localObject1).field_localId, 1);
      paramInt = 1;
      Log.i(paramf.TAG, kotlin.g.b.s.X("save update version: ", Integer.valueOf(((com.tencent.mm.plugin.finder.storage.i)localObject1).field_version)));
      paramDialogInterface = (DialogInterface)localObject1;
      label432:
      paramDialogInterface.field_localFlag = 1;
      paramDialogInterface.field_objectType = 0;
      paramDialogInterface.eYK().setCreateTime(com.tencent.mm.model.cn.getSyncServerTimeSecond());
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
      com.tencent.mm.plugin.finder.storage.logic.c.g(paramDialogInterface);
      if (paramInt != 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.j.FKc;
        long l = paramDialogInterface.field_localId;
        com.tencent.mm.plugin.finder.storage.j.as(com.tencent.mm.plugin.finder.storage.j.FKg, l);
      }
      Log.i(paramf.TAG, "LogPost save draft.");
      paramDialogInterface = com.tencent.mm.plugin.finder.upload.g.GbJ;
      com.tencent.mm.plugin.finder.upload.g.fdW().eKX();
      paramDialogInterface = a.EST;
      if (a.eGY() == null) {
        break label600;
      }
      paramDialogInterface = a.EST;
      a.bz(2, "");
      paramf.getActivity().finish();
    }
    for (;;)
    {
      paramf = v.FrN;
      v.aQ(4, true);
      AppMethodBeat.o(349797);
      return;
      paramDialogInterface = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getDraftStorage().qm(paramf.eHl().GZS);
      break;
      label573:
      paramDialogInterface = com.tencent.mm.plugin.finder.storage.i.FKa;
      paramDialogInterface = i.a.p((FinderItem)localObject1);
      paramDialogInterface.field_localId = 0L;
      paramDialogInterface.field_createTime = com.tencent.mm.model.cn.getSyncServerTimeSecond();
      paramInt = 0;
      break label432;
      label600:
      paramf.sY(true);
    }
  }
  
  private static final void a(f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(349732);
    kotlin.g.b.s.u(paramf, "this$0");
    if (paramMenuItem.getItemId() == 20003)
    {
      Object localObject2 = paramf.eHo().getLayoutParams();
      Object localObject1 = paramf.ETv;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("mediaViewContainer");
        paramMenuItem = null;
      }
      ((ViewGroup.LayoutParams)localObject2).width = paramMenuItem.getWidth();
      localObject2 = paramf.eHo().getLayoutParams();
      localObject1 = paramf.ETv;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("mediaViewContainer");
        paramMenuItem = null;
      }
      ((ViewGroup.LayoutParams)localObject2).height = paramMenuItem.getHeight();
      localObject1 = paramf.ETv;
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("mediaViewContainer");
        paramMenuItem = null;
      }
      paramMenuItem.removeAllViews();
      paramMenuItem = paramf.ETx;
      if (paramMenuItem != null) {
        paramMenuItem.fqA();
      }
      paramf.eHl().GZH = Integer.valueOf(-1);
      localObject1 = paramf.eHl();
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("postType");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("postMediaList");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("key_post_media_quality_list");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("video_composition");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("postTypeList");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("postRefMediaList");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("postRefFeedInfo");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("KEY_POST_FROM_CAMERA");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("postVideoCropList");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("postThumbList");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("KEY_POST_VLOG_CROP_RECT");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("MEDIA_EXTRA_MUSIC");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("ORIGIN_MUSIC_ID");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("ORIGIN_MUSIC_INFO");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("ORIGIN_MUSIC_PATH");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("ORIGIN_BGM_URL");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("MEDIA_IS_MUTE");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("MUSIC_IS_MUTE");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("SOUND_TRACK_TYPE");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("MUSIC_FEED_ID");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("isLongVideoPost");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("KEY_POST_HALF_IMAGE_LIST");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("KEY_POST_HALF_RECT_LIST");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("VIDEO_COVER_URL");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("VIDEO_FULL_COVER_URL");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("VIDEO_COVER_QUALITY");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.removeExtra("KEY_POST_MIAOJIAN_TONGKUAN_META");
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).GZZ = null;
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).Haa = null;
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).Hab = null;
      paramMenuItem = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).Gcx;
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.getMediaExtList();
        if (paramMenuItem != null) {
          paramMenuItem.clear();
        }
      }
      paramMenuItem = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).Gcx;
      if (paramMenuItem != null) {
        paramMenuItem.setMediaType(-1);
      }
      paramMenuItem = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).Gcx;
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.getFeedObject();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.objectDesc;
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.media;
            if (paramMenuItem != null) {
              paramMenuItem.clear();
            }
          }
        }
      }
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent;
      paramMenuItem = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).Gcx;
      if (paramMenuItem != null) {
        break label653;
      }
      paramMenuItem = null;
      ((Intent)localObject2).putExtra("KEY_POST_DRAFT_FINDER_ITEM", paramMenuItem);
      paramMenuItem = com.tencent.mm.plugin.finder.upload.postlogic.a.GdF;
      paramMenuItem = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).Gcx;
      if (paramMenuItem != null) {
        break label680;
      }
      paramMenuItem = null;
      label554:
      com.tencent.mm.plugin.finder.upload.postlogic.a.a(paramMenuItem);
      paramMenuItem = com.tencent.mm.plugin.finder.upload.postlogic.a.GdF;
      paramMenuItem = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).Gcx;
      if (paramMenuItem != null) {
        break label702;
      }
      paramMenuItem = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.upload.postlogic.a.a(paramMenuItem);
      paramMenuItem = com.tencent.mm.ui.component.k.aeZF;
      ((i)com.tencent.mm.ui.component.k.nq((Context)paramf.getContext()).q(i.class)).EUo.clear();
      paramf.getIntent().removeExtra("postType");
      paramf.ETx = null;
      paramf.eHt();
      paramf.eHo().setVisibility(0);
      paramf.eHn().setVisibility(8);
      paramf.eHs();
      AppMethodBeat.o(349732);
      return;
      label653:
      FinderItem.a locala = FinderItem.Companion;
      paramMenuItem = FinderItem.a.r(paramMenuItem);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        break;
      }
      paramMenuItem = paramMenuItem.toByteArray();
      break;
      label680:
      paramMenuItem = paramMenuItem.getFeedObject();
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        break label554;
      }
      paramMenuItem = paramMenuItem.objectDesc;
      break label554;
      label702:
      paramMenuItem = paramMenuItem.field_finderObject;
      if (paramMenuItem == null) {
        paramMenuItem = null;
      } else {
        paramMenuItem = paramMenuItem.objectDesc;
      }
    }
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(349673);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "this$0");
    paramView = com.tencent.mm.plugin.vlog.report.a.UeF;
    com.tencent.mm.plugin.vlog.report.a.a(74, 1, System.currentTimeMillis() - paramf.ETJ, 0, paramf.ETL, paramf.DUN);
    paramf.eHy();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349673);
  }
  
  private static final void a(f paramf, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(349750);
    kotlin.g.b.s.u(paramf, "this$0");
    Log.i(paramf.TAG, "oldBottom " + paramInt8 + ", bottom " + paramInt4);
    if (paramInt8 != paramInt4) {
      paramf.ewS();
    }
    AppMethodBeat.o(349750);
  }
  
  private static final void a(f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(349718);
    kotlin.g.b.s.u(paramf, "this$0");
    if (params.jmw()) {
      params.a(20003, paramf.getContext().getResources().getColor(b.b.Red), (CharSequence)paramf.getContext().getResources().getString(l.i.finder_post_del));
    }
    AppMethodBeat.o(349718);
  }
  
  private static final void a(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(349664);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMMActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMMActivity, "$activity");
    paramMMActivity.hideVKB();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349664);
  }
  
  private static final void a(boolean[] paramArrayOfBoolean, f paramf, MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(349693);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramArrayOfBoolean);
    localb.cH(paramf);
    localb.cH(paramMMActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramArrayOfBoolean, "$postOnTouchDownCalled");
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramMMActivity, "$activity");
    if (paramArrayOfBoolean[0] != 0) {
      paramArrayOfBoolean[0] = false;
    }
    for (;;)
    {
      paramArrayOfBoolean = com.tencent.mm.plugin.vlog.report.a.UeF;
      com.tencent.mm.plugin.vlog.report.a.a(74, 1, System.currentTimeMillis() - paramf.ETJ, 1, paramf.ETL, paramf.DUN);
      paramArrayOfBoolean = com.tencent.mm.ui.component.k.aeZF;
      paramArrayOfBoolean = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).q(g.class);
      kotlin.g.b.s.s(paramArrayOfBoolean, "UICProvider.of(activity)…tPreCheckUIC::class.java)");
      if (g.a((g)paramArrayOfBoolean, (kotlin.g.a.a)new f.g(paramf))) {
        break;
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349693);
      return;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_publish", "<FeedPublish>");
      paramArrayOfBoolean = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_publish", paramArrayOfBoolean);
      com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_publish");
    }
    paramArrayOfBoolean = z.bAW();
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paramView = ((i)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).q(i.class)).eHB();
    if (Util.isNullOrNil(paramArrayOfBoolean))
    {
      paramArrayOfBoolean = new Intent();
      if (Util.isNullOrNil(paramView)) {
        paramArrayOfBoolean.putExtra("key_create_scene", 4);
      }
      for (;;)
      {
        paramArrayOfBoolean.putExtra("key_router_to_profile", false);
        com.tencent.mm.plugin.finder.utils.a.GfO.x((Context)paramMMActivity, paramArrayOfBoolean);
        com.tencent.mm.plugin.report.service.h.OAn.b(20694, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(349693);
        return;
        paramArrayOfBoolean.putExtra("key_create_scene", 5);
      }
    }
    if (paramf.ETK == 0)
    {
      if (paramf.getIntent().getIntExtra("key_finder_post_from", -1) == 5)
      {
        paramArrayOfBoolean = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() == 1)
        {
          paramArrayOfBoolean = com.tencent.mm.plugin.finder.storage.d.FAy;
          int i = com.tencent.mm.plugin.finder.storage.d.eSE();
          if (i < 3)
          {
            paramArrayOfBoolean = com.tencent.mm.plugin.finder.storage.d.FAy;
            com.tencent.mm.plugin.finder.storage.d.Tn(i + 1);
          }
        }
      }
      paramArrayOfBoolean = com.tencent.mm.plugin.vlog.model.m.TYW;
      com.tencent.mm.plugin.vlog.model.m.hQA();
      paramArrayOfBoolean = paramf.psR;
      if (paramArrayOfBoolean != null) {
        paramArrayOfBoolean.dismiss();
      }
      paramf.psR = com.tencent.mm.ui.base.k.a((Context)paramMMActivity, paramf.getString(l.i.app_sending), false, null);
      paramArrayOfBoolean = paramf.psR;
      if (paramArrayOfBoolean != null) {
        paramArrayOfBoolean.show();
      }
      paramf.eHx();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349693);
  }
  
  private final void aF(Intent paramIntent)
  {
    AppMethodBeat.i(349642);
    List localList1;
    if (paramIntent != null)
    {
      localObject = paramIntent.getSerializableExtra("key_activity_jump_info_list");
      if (!(localObject instanceof List)) {
        break label144;
      }
      localList1 = (List)localObject;
      if (localList1 != null) {
        break label150;
      }
    }
    label144:
    label150:
    boolean bool;
    for (Object localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        ((d)com.tencent.mm.ui.component.k.d(getActivity()).q(d.class)).o(null, false);
      }
      localObject = paramIntent.getStringExtra("key_activity_post_wording");
      if ((localObject != null) && (!Util.isNullOrNil((String)localObject)))
      {
        paramIntent = paramIntent.getStringExtra("key_activity_post_wording");
        localObject = eHw().eGZ().getText().toString();
        eHw().eGZ().setText((CharSequence)kotlin.g.b.s.X((String)localObject, paramIntent));
      }
      AppMethodBeat.o(349642);
      return;
      localList1 = null;
      break;
      localObject = com.tencent.mm.ui.component.k.aeZF;
      d locald = (d)com.tencent.mm.ui.component.k.d(getActivity()).q(d.class);
      if ((!locald.ETp) || (!localList1.isEmpty()) || (paramIntent.getBooleanExtra("key_activity_already_participate", false))) {
        break label256;
      }
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).reset();
      localObject = com.tencent.mm.plugin.finder.activity.b.Aty;
      localObject = com.tencent.mm.plugin.finder.activity.b.fR(localList1);
      bool = false;
      label240:
      locald.o((List)localObject, bool);
    }
    label256:
    if (!((Collection)localList1).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).reset();
      }
      localObject = com.tencent.mm.plugin.finder.activity.b.Aty;
      List localList2 = com.tencent.mm.plugin.finder.activity.b.fR(localList1);
      localObject = localList2;
      if (((Collection)localList1).isEmpty()) {
        break;
      }
      bool = true;
      localObject = localList2;
      break label240;
    }
  }
  
  private static final void b(f paramf)
  {
    AppMethodBeat.i(349710);
    kotlin.g.b.s.u(paramf, "this$0");
    float f = paramf.eHn().getY();
    ViewGroup localViewGroup2 = paramf.ETv;
    ViewGroup localViewGroup1 = localViewGroup2;
    if (localViewGroup2 == null)
    {
      kotlin.g.b.s.bIx("mediaViewContainer");
      localViewGroup1 = null;
    }
    if ((f < localViewGroup1.getY()) && (paramf.ETv == null)) {
      kotlin.g.b.s.bIx("mediaViewContainer");
    }
    AppMethodBeat.o(349710);
  }
  
  private static final void b(f paramf, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(349808);
    kotlin.g.b.s.u(paramf, "this$0");
    paramDialogInterface = a.EST;
    a.bz(2, "");
    paramDialogInterface = v.FrN;
    v.aQ(4, false);
    paramDialogInterface = a.EST;
    if (a.eGY() != null)
    {
      paramDialogInterface = a.EST;
      a.bz(2, "");
      paramf.getActivity().finish();
      paramf = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramf = v.FrN;
      paramf = v.eMS();
      if (paramf != null) {
        break label107;
      }
      paramf = "";
    }
    for (;;)
    {
      paramDialogInterface = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(paramf, com.tencent.mm.plugin.finder.report.postreport.b.eOk());
      AppMethodBeat.o(349808);
      return;
      paramf.sY(false);
      break;
      label107:
      paramDialogInterface = paramf.flowId;
      paramf = paramDialogInterface;
      if (paramDialogInterface == null) {
        paramf = "";
      }
    }
  }
  
  private static final void b(f paramf, View paramView)
  {
    AppMethodBeat.i(349703);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.eHr();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349703);
  }
  
  private static final void c(f paramf)
  {
    AppMethodBeat.i(349739);
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.eHs();
    AppMethodBeat.o(349739);
  }
  
  private static final void c(f paramf, View paramView)
  {
    AppMethodBeat.i(349716);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.eHw().eHf();
    paramView = new Intent();
    paramView.putExtras(paramf.getIntent());
    paramView.putExtra("album_from_finder_add_media", true);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.b(paramView, paramf.getIntent());
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.ac((Context)paramf.getActivity(), paramView);
    paramf = v.FrN;
    v.Sz(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349716);
  }
  
  private static final boolean c(boolean[] paramArrayOfBoolean, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(349678);
    kotlin.g.b.s.u(paramArrayOfBoolean, "$postOnTouchDownCalled");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(349678);
      return false;
      paramArrayOfBoolean[0] = true;
      com.tencent.mm.plugin.normsg.a.d.MtP.kI("ce_feed_publish", "<FeedPublish>");
      continue;
      com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_feed_publish", paramMotionEvent);
      com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_feed_publish");
    }
  }
  
  private static final void d(f paramf)
  {
    AppMethodBeat.i(349774);
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.eHx();
    AppMethodBeat.o(349774);
  }
  
  private static final void d(f paramf, View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(349743);
    kotlin.g.b.s.u(paramf, "this$0");
    Object localObject3 = paramf.TAG;
    StringBuilder localStringBuilder = new StringBuilder("after add view  widgetView:").append(paramView.getWidth()).append(" height:").append(paramView.getHeight()).append("  mediaViewContainer:");
    Object localObject1 = paramf.ETv;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mediaViewContainer");
      paramView = null;
    }
    localStringBuilder = localStringBuilder.append(paramView.getWidth()).append(" height:");
    localObject1 = paramf.ETv;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mediaViewContainer");
      paramView = null;
    }
    Log.i((String)localObject3, paramView.getHeight());
    localObject1 = paramf.ETv;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mediaViewContainer");
      paramView = null;
    }
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof FrameLayout.LayoutParams))
    {
      paramView = (FrameLayout.LayoutParams)paramView;
      if (paramView != null)
      {
        localObject3 = paramf.ETv;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("mediaViewContainer");
          localObject1 = null;
        }
        float f = ((ViewGroup)localObject1).getResources().getDimension(l.c.Edge_4_5_A);
        Log.i(paramf.TAG, "topMargin:" + f + " originMargin:" + paramView.topMargin);
        if (Math.abs(paramView.topMargin - f) > 5.0F)
        {
          paramView.topMargin = ((int)f);
          paramf = paramf.ETv;
          if (paramf != null) {
            break label303;
          }
          kotlin.g.b.s.bIx("mediaViewContainer");
          paramf = localObject2;
        }
      }
    }
    label303:
    for (;;)
    {
      paramf.setLayoutParams((ViewGroup.LayoutParams)paramView);
      AppMethodBeat.o(349743);
      return;
      paramView = null;
      break;
    }
  }
  
  private static final void e(f paramf, View paramView)
  {
    View localView1 = null;
    AppMethodBeat.i(349768);
    kotlin.g.b.s.u(paramf, "this$0");
    kotlin.g.b.s.u(paramView, "$footerContainer");
    Log.i(paramf.TAG, "footer.height " + paramView.getHeight() + ", footer.oldHeight " + paramf.eHw().ESZ);
    if (paramView.getVisibility() == 0)
    {
      if ((paramf.eHw().eGZ().hasFocus()) && (paramView.getHeight() != paramf.eHw().ESZ))
      {
        paramf.eHw().ESZ = paramView.getHeight();
        paramf.ewS();
      }
      localView1 = paramf.DXs;
      paramView = localView1;
      if (localView1 == null)
      {
        kotlin.g.b.s.bIx("edtContainer");
        paramView = null;
      }
      paramView.addOnLayoutChangeListener(paramf.DXz);
      AppMethodBeat.o(349768);
      return;
    }
    if ((paramView.getVisibility() == 8) || (paramView.getHeight() == 0))
    {
      paramf.eHw().ESZ = 0;
      paramf.ewP().scrollTo(0, 0);
      View localView2 = paramf.DXr;
      paramView = localView2;
      if (localView2 == null)
      {
        kotlin.g.b.s.bIx("bottomSpace");
        paramView = null;
      }
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramf = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(349768);
        throw paramf;
      }
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView;
      localLayoutParams.height = 0;
      localLayoutParams.weight = 1.0F;
      localView2 = paramf.DXr;
      paramView = localView2;
      if (localView2 == null)
      {
        kotlin.g.b.s.bIx("bottomSpace");
        paramView = null;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      localView2 = paramf.DXr;
      paramView = localView2;
      if (localView2 == null)
      {
        kotlin.g.b.s.bIx("bottomSpace");
        paramView = null;
      }
      paramView.requestLayout();
      paramView = paramf.DXs;
      if (paramView != null) {
        break label329;
      }
      kotlin.g.b.s.bIx("edtContainer");
      paramView = localView1;
    }
    label329:
    for (;;)
    {
      paramView.removeOnLayoutChangeListener(paramf.DXz);
      AppMethodBeat.o(349768);
      return;
    }
  }
  
  private com.tencent.mm.plugin.finder.upload.postui.e eHm()
  {
    AppMethodBeat.i(349519);
    com.tencent.mm.plugin.finder.upload.postui.e locale = this.ETy;
    if (locale != null)
    {
      AppMethodBeat.o(349519);
      return locale;
    }
    kotlin.g.b.s.bIx("extendLinkWidget");
    AppMethodBeat.o(349519);
    return null;
  }
  
  private final View eHn()
  {
    AppMethodBeat.i(349523);
    View localView = (View)this.ETD.getValue();
    AppMethodBeat.o(349523);
    return localView;
  }
  
  private final View eHo()
  {
    AppMethodBeat.i(349530);
    View localView = (View)this.ETE.getValue();
    AppMethodBeat.o(349530);
    return localView;
  }
  
  private final View eHp()
  {
    AppMethodBeat.i(349540);
    View localView = (View)this.ETG.getValue();
    AppMethodBeat.o(349540);
    return localView;
  }
  
  private final void eHq()
  {
    int j = 8;
    AppMethodBeat.i(349548);
    View localView = eHn();
    ViewGroup localViewGroup = this.ETv;
    Object localObject = localViewGroup;
    if (localViewGroup == null)
    {
      kotlin.g.b.s.bIx("mediaViewContainer");
      localObject = null;
    }
    if (((ViewGroup)localObject).getChildCount() != 0)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      if (((i)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(i.class)).eHC())
      {
        i = 0;
        localView.setVisibility(i);
        localObject = eHo();
        if (eHn().getVisibility() != 0) {
          break label162;
        }
      }
    }
    label162:
    for (int i = j;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      eHn().setOnClickListener(new f..ExternalSyntheticLambda2(this));
      eHn().post(new f..ExternalSyntheticLambda14(this));
      eHo().setOnClickListener(new f..ExternalSyntheticLambda4(this));
      AppMethodBeat.o(349548);
      return;
      i = 8;
      break;
    }
  }
  
  private final void eHr()
  {
    AppMethodBeat.i(349555);
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)getContext(), 1, true);
    View localView = af.mU((Context)getContext()).inflate(l.f.finder_post_del_confirm_header, null);
    TextView localTextView = (TextView)localView.findViewById(l.e.finder_post_del_header_txt);
    Object localObject = eHl().GZH;
    if (localObject == null)
    {
      localObject = eHl().GZH;
      if (localObject != null) {
        break label164;
      }
    }
    label77:
    for (localObject = (CharSequence)getContext().getResources().getString(l.i.finder_post_del_img);; localObject = (CharSequence)getContext().getResources().getString(l.i.finder_post_del_video))
    {
      localTextView.setText((CharSequence)localObject);
      localf.af(localView, false);
      localf.Vtg = new f..ExternalSyntheticLambda10(this);
      localf.GAC = new f..ExternalSyntheticLambda11(this);
      localf.aeLi = new f..ExternalSyntheticLambda12(this);
      localf.dDn();
      AppMethodBeat.o(349555);
      return;
      if (((Integer)localObject).intValue() == 2) {
        break label77;
      }
      break;
      if (((Integer)localObject).intValue() != 4) {
        break label77;
      }
    }
  }
  
  private final void eHs()
  {
    AppMethodBeat.i(349565);
    Object localObject = eHl().GZH;
    if (localObject == null) {}
    while (((Integer)localObject).intValue() != 2)
    {
      localObject = eHl().GZH;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(349565);
      return;
    }
    int i;
    afb localafb;
    long l1;
    if ((this.ETx instanceof com.tencent.mm.plugin.finder.widget.post.e))
    {
      localObject = v.FrN;
      localObject = eHl().GZH;
      if (localObject == null) {}
      for (i = -1;; i = ((Integer)localObject).intValue())
      {
        localObject = this.ETx;
        if (localObject != null) {
          break;
        }
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.post.PostImageWidget");
        AppMethodBeat.o(349565);
        throw ((Throwable)localObject);
      }
      localObject = ((com.tencent.mm.plugin.finder.widget.post.e)localObject).Hak;
      if (localObject == null) {}
      for (int j = 0;; j = ((ArrayList)localObject).size())
      {
        v.m(i, j, 0L);
        AppMethodBeat.o(349565);
        return;
      }
      if ((((Integer)localObject).intValue() == 4) && ((this.ETx instanceof com.tencent.mm.plugin.finder.widget.post.g)))
      {
        localObject = v.FrN;
        localObject = eHl().GZH;
        if (localObject == null) {}
        for (i = -1;; i = ((Integer)localObject).intValue())
        {
          localObject = this.ETx;
          if (localObject != null) {
            break;
          }
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.post.PostVideoWidget");
          AppMethodBeat.o(349565);
          throw ((Throwable)localObject);
        }
        localObject = (com.tencent.mm.plugin.finder.widget.post.g)localObject;
        localafb = ((com.tencent.mm.plugin.finder.widget.post.g)localObject).HaH;
        if (localafb != null) {
          break label299;
        }
        l1 = 0L;
        localObject = ((com.tencent.mm.plugin.finder.widget.post.g)localObject).HaH;
        if (localObject != null) {
          break label308;
        }
      }
    }
    label299:
    label308:
    for (long l2 = 0L;; l2 = ((afb)localObject).Znh)
    {
      v.m(i, 0L, kotlin.k.k.bR(l1 - l2, 0L));
      AppMethodBeat.o(349565);
      return;
      l1 = localafb.Zni;
      break;
    }
  }
  
  private final e eHu()
  {
    AppMethodBeat.i(349571);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
    kotlin.g.b.s.s(localObject, "UICProvider.of(activity)…tLocationUIC::class.java)");
    localObject = (e)localObject;
    AppMethodBeat.o(349571);
    return localObject;
  }
  
  private final c eHv()
  {
    AppMethodBeat.i(349577);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(c.class);
    kotlin.g.b.s.s(localObject, "UICProvider.of(activity)…xtendLinkUIC::class.java)");
    localObject = (c)localObject;
    AppMethodBeat.o(349577);
    return localObject;
  }
  
  private final b eHw()
  {
    AppMethodBeat.i(349590);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(b.class);
    kotlin.g.b.s.s(localObject, "UICProvider.of(activity)…(PostEditUIC::class.java)");
    localObject = (b)localObject;
    AppMethodBeat.o(349590);
    return localObject;
  }
  
  private final void eHx()
  {
    AppMethodBeat.i(349606);
    Log.i(this.TAG, kotlin.g.b.s.X("check post time ", Integer.valueOf(this.ETK)));
    boolean bool;
    if (this.ETK < 10)
    {
      this.ETK += 1;
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zde, true);
      Log.i(this.TAG, kotlin.g.b.s.X("xCheck :", Boolean.valueOf(bool)));
      localObject1 = this.ETx;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.widget.post.a)localObject1).dqm() != true)) {
        break label237;
      }
    }
    label237:
    for (int i = 1; (i == 0) && (bool); i = 0)
    {
      aa.makeText((Context)getContext(), l.i.finder_post_fail_for_empty_file, 0).show();
      localObject1 = this.psR;
      if (localObject1 != null) {
        ((w)localObject1).dismiss();
      }
      this.psR = null;
      if (!this.ETw)
      {
        localObject1 = new qn();
        ((qn)localObject1).jsG = 0L;
        ((qn)localObject1).bMH();
        this.ETw = true;
      }
      AppMethodBeat.o(349606);
      return;
      Log.w(this.TAG, "check post data ready exceed MAX times!");
      localObject1 = this.psR;
      if (localObject1 != null) {
        ((w)localObject1).dismiss();
      }
      this.psR = null;
      Toast.makeText((Context)getActivity(), l.i.finder_post_tip_failed, 0).show();
      this.ETK = 0;
      AppMethodBeat.o(349606);
      return;
    }
    Object localObject1 = this.ETx;
    final com.tencent.mm.plugin.finder.widget.post.h localh;
    Object localObject2;
    if (localObject1 == null)
    {
      localh = null;
      if ((localh == null) || (!localh.ifx)) {
        break label715;
      }
      if (localh.HaW != null)
      {
        localObject1 = v.FrN;
        localObject1 = localh.HaW;
        if (localObject1 != null) {
          break label546;
        }
        localObject2 = null;
        label292:
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localh.HaW;
          if (localObject1 != null) {
            break label555;
          }
          localObject1 = "";
        }
        label314:
        v.azN((String)localObject1);
        localObject1 = localh.HaW;
        if ((localObject1 == null) || (((djh)localObject1).GZQ)) {
          break label592;
        }
        i = 1;
        label337:
        if ((i == 0) || (localh.HaW.GZR)) {
          break label597;
        }
        localObject1 = v.FrN;
        v.Sx(3);
        label360:
        localObject1 = v.FrN;
        localObject1 = localh.HaW;
        if (localObject1 != null) {
          break label686;
        }
        i = 0;
        label376:
        v.Sw(i);
        localObject1 = v.FrN;
        localObject1 = localh.HaW;
        if (localObject1 != null) {
          break label694;
        }
        localObject1 = "";
      }
    }
    for (;;)
    {
      v.azM((String)localObject1);
      localObject1 = v.FrN;
      v.f(eHw().eHc().fmb().Gct, eHw().eHc().fmb().GHE, eHw().eHc().fmb().GHF);
      Bundle localBundle = eHl().Gfy;
      localObject2 = this.ETA;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("newsWidget");
        localObject1 = null;
      }
      localBundle.putBoolean("isNews", ((com.tencent.mm.plugin.finder.upload.postui.h)localObject1).isChecked());
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new d(this, localh, ((i)com.tencent.mm.ui.component.k.d(getActivity()).q(i.class)).eHB()));
      AppMethodBeat.o(349606);
      return;
      localh = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).fqC();
      break;
      label546:
      localObject2 = ((djh)localObject1).FSW;
      break label292;
      label555:
      localObject1 = ((djh)localObject1).aaOZ;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label314;
      }
      localObject2 = ((bqj)localObject1).HsD;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label314;
      }
      localObject1 = "";
      break label314;
      label592:
      i = 0;
      break label337;
      label597:
      localObject1 = localh.HaW;
      if ((localObject1 != null) && (!((djh)localObject1).GZQ)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label636;
        }
        localObject1 = v.FrN;
        v.Sx(2);
        break;
      }
      label636:
      localObject1 = localh.HaW;
      if ((localObject1 != null) && (!((djh)localObject1).GZR)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label675;
        }
        localObject1 = v.FrN;
        v.Sx(1);
        break;
      }
      label675:
      localObject1 = v.FrN;
      v.Sx(0);
      break label360;
      label686:
      i = ((djh)localObject1).soundTrackType;
      break label376;
      label694:
      localObject2 = ((djh)localObject1).musicFeedId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    label715:
    Log.i(this.TAG, "not ready to post");
    MMHandlerThread.postToMainThreadDelayed(new f..ExternalSyntheticLambda13(this), 500L);
    AppMethodBeat.o(349606);
  }
  
  private final void eHy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(349623);
    Object localObject1 = this.ETx;
    com.tencent.mm.plugin.finder.widget.post.h localh;
    label27:
    label53:
    label73:
    int i;
    if (localObject1 == null)
    {
      localh = null;
      if (localh != null) {
        break label283;
      }
      localObject1 = null;
      if ((localObject1 != null) && (localh.ifx))
      {
        localObject1 = v.FrN;
        localObject1 = localh.HaW;
        if (localObject1 != null) {
          break label292;
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localh.HaW;
          if (localObject1 != null) {
            break label300;
          }
          localObject1 = "";
        }
        v.azN((String)localObject1);
        localObject1 = localh.HaW;
        if ((localObject1 == null) || (((djh)localObject1).GZQ)) {
          break label334;
        }
        i = 1;
        label96:
        if ((i == 0) || (localh.HaW.GZR)) {
          break label339;
        }
        localObject1 = v.FrN;
        v.Sx(3);
        label119:
        localObject1 = v.FrN;
        v.Sw(localh.HaW.soundTrackType);
        localObject1 = v.FrN;
        localObject2 = localh.HaW.musicFeedId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        v.azM((String)localObject1);
      }
      if (!Util.isNullOrNil(z.bAW()))
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        if (((i)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(i.class)).eHD()) {
          break label454;
        }
      }
      localObject1 = v.FrN;
      v.aQ(4, false);
      localObject1 = a.EST;
      if (a.eGY() == null) {
        break label428;
      }
      localObject1 = a.EST;
      a.bz(1, "");
      getActivity().finish();
      label236:
      localObject1 = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      localObject1 = v.FrN;
      localObject1 = v.eMS();
      if (localObject1 != null) {
        break label436;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a((String)localObject1, com.tencent.mm.plugin.finder.report.postreport.b.eOk());
      AppMethodBeat.o(349623);
      return;
      localh = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).fqC();
      break;
      label283:
      localObject1 = localh.HaW;
      break label27;
      label292:
      localObject2 = ((djh)localObject1).FSW;
      break label53;
      label300:
      localObject1 = ((djh)localObject1).aaOZ;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label73;
      }
      localObject2 = ((bqj)localObject1).HsD;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label73;
      }
      localObject1 = "";
      break label73;
      label334:
      i = 0;
      break label96;
      label339:
      localObject1 = localh.HaW;
      if ((localObject1 != null) && (!((djh)localObject1).GZQ)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label378;
        }
        localObject1 = v.FrN;
        v.Sx(2);
        break;
      }
      label378:
      localObject1 = localh.HaW;
      if ((localObject1 != null) && (!((djh)localObject1).GZR)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label417;
        }
        localObject1 = v.FrN;
        v.Sx(1);
        break;
      }
      label417:
      localObject1 = v.FrN;
      v.Sx(0);
      break label119;
      label428:
      sY(false);
      break label236;
      label436:
      localObject2 = ((FinderFeedReportObject)localObject1).flowId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    label454:
    localObject1 = v.FrN;
    v.f(eHw().eHc().fmb().Gct, eHw().eHc().fmb().GHE, eHw().eHc().fmb().GHF);
    localObject1 = getString(l.i.finder_upload_exit_and_save_tips1);
    if (eHl().GZS > 0L) {
      localObject1 = getString(l.i.finder_upload_exit_and_save_tips2);
    }
    com.tencent.mm.ui.base.k.a((Context)getActivity(), (String)localObject1, "", getString(l.i.finder_upload_exit_save), getString(l.i.finder_upload_exit_not_save), true, new f..ExternalSyntheticLambda0(this), new f..ExternalSyntheticLambda1(this), l.b.alert_btn_color_no);
    AppMethodBeat.o(349623);
  }
  
  private final void ewS()
  {
    Object localObject2 = null;
    AppMethodBeat.i(349585);
    Object localObject3 = new Point();
    getActivity().getWindowManager().getDefaultDisplay().getSize((Point)localObject3);
    Object localObject4 = new int[2];
    View localView1 = this.DXs;
    Object localObject1 = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("edtContainer");
      localObject1 = null;
    }
    ((View)localObject1).getLocationInWindow((int[])localObject4);
    View localView2 = eHw().eHb();
    int i = ((Point)localObject3).y - localView2.getHeight() - getResources().getDimensionPixelSize(l.c.Edge_2A);
    int j = localObject4[1];
    localView1 = this.DXs;
    localObject1 = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("edtContainer");
      localObject1 = null;
    }
    j += ((View)localObject1).getHeight();
    Log.i(this.TAG, "window.y " + ((Point)localObject3).y + " footer.height " + localView2.getHeight() + " bottom " + j + ", maxBottom " + i + ' ');
    localView1 = this.DXr;
    localObject1 = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("bottomSpace");
      localObject1 = null;
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(349585);
      throw ((Throwable)localObject1);
    }
    localObject3 = (LinearLayout.LayoutParams)localObject1;
    localObject4 = this.TAG;
    localView1 = this.DXr;
    localObject1 = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("bottomSpace");
      localObject1 = null;
    }
    Log.i((String)localObject4, kotlin.g.b.s.X("bottom height ", Integer.valueOf(((View)localObject1).getHeight())));
    localView1 = this.DXr;
    localObject1 = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("bottomSpace");
      localObject1 = null;
    }
    ((LinearLayout.LayoutParams)localObject3).height = (((View)localObject1).getHeight() + (j - i));
    localView1 = this.DXr;
    localObject1 = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("bottomSpace");
      localObject1 = null;
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localView1 = this.DXr;
    localObject1 = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("bottomSpace");
      localObject1 = null;
    }
    ((View)localObject1).requestLayout();
    localObject1 = this.DXr;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("bottomSpace");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((View)localObject1).post(new f..ExternalSyntheticLambda15(this, j, i));
      AppMethodBeat.o(349585);
      return;
    }
  }
  
  private final View getBackBtn()
  {
    AppMethodBeat.i(349533);
    View localView = (View)this.ETF.getValue();
    AppMethodBeat.o(349533);
    return localView;
  }
  
  private static final void h(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(349697);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "$this_apply");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/post/PostMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349697);
  }
  
  private final LinkedList<FinderJumpInfo> sW(boolean paramBoolean)
  {
    AppMethodBeat.i(349651);
    LinkedList localLinkedList = eHv().sW(paramBoolean);
    AppMethodBeat.o(349651);
    return localLinkedList;
  }
  
  private final void sY(boolean paramBoolean)
  {
    AppMethodBeat.i(349628);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((i)com.tencent.mm.ui.component.k.d(getActivity()).q(i.class)).eHB();
    if (!paramBoolean)
    {
      int i = getIntent().getIntExtra("key_finder_post_from", -1);
      if ((i != -1) && (i != 6))
      {
        localIntent = new Intent();
        localIntent.putExtra("key_finder_post_router", i);
        locala = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)getActivity(), localIntent);
        aze((String)localObject);
        getActivity().overridePendingTransition(0, MMFragmentActivity.a.upX);
      }
      getActivity().finish();
      AppMethodBeat.o(349628);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_finder_post_router", 13);
    localIntent.putExtra("key_finder_post_from", getIntent().getIntExtra("key_finder_post_from", -1));
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)getActivity(), localIntent);
    aze((String)localObject);
    getActivity().overridePendingTransition(0, MMFragmentActivity.a.upX);
    getActivity().finish();
    AppMethodBeat.o(349628);
  }
  
  public final void aze(String paramString)
  {
    AppMethodBeat.i(350096);
    kotlin.g.b.s.u(paramString, "appId");
    com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(paramString, true, false);
    if (localg == null)
    {
      Log.i(this.TAG, "can not find app info");
      AppMethodBeat.o(350096);
      return;
    }
    Bundle localBundle = new Bundle();
    Log.i(this.TAG, "Finder share video backToApp: %s", new Object[] { paramString });
    paramString = new WXChannelShareVideo.Resp();
    paramString.errCode = 0;
    paramString.extMsg = "{}";
    a(localBundle, (BaseResp)paramString, localg);
    AppMethodBeat.o(350096);
  }
  
  public final com.tencent.mm.plugin.finder.widget.post.c eHl()
  {
    AppMethodBeat.i(349995);
    com.tencent.mm.plugin.finder.widget.post.c localc = this.ETI;
    if (localc != null)
    {
      AppMethodBeat.o(349995);
      return localc;
    }
    kotlin.g.b.s.bIx("postDataManager");
    AppMethodBeat.o(349995);
    return null;
  }
  
  public final void eHt()
  {
    AppMethodBeat.i(350078);
    getActivity();
    if ((!eHm().feG()) || (!eHw().ESY))
    {
      eHp().setEnabled(false);
      AppMethodBeat.o(350078);
      return;
    }
    if (this.ETx != null)
    {
      eHp().setEnabled(true);
      AppMethodBeat.o(350078);
      return;
    }
    eHp().setEnabled(false);
    AppMethodBeat.o(350078);
  }
  
  public final void eHz()
  {
    AppMethodBeat.i(350135);
    Object localObject1 = this.ETx;
    if (localObject1 == null)
    {
      localObject2 = null;
      if ((eHl().Gcx == null) || (Util.isNullOrNil((List)eHl().GZZ))) {
        break label78;
      }
    }
    label78:
    for (int i = 1;; i = 0)
    {
      if ((localObject2 != null) && (((com.tencent.mm.plugin.finder.widget.post.h)localObject2).ifx)) {
        break label83;
      }
      AppMethodBeat.o(350135);
      return;
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).fqC();
      break;
    }
    label83:
    localObject1 = ((com.tencent.mm.plugin.finder.widget.post.h)localObject2).HaW;
    if (localObject1 == null) {
      localObject1 = null;
    }
    com.tencent.mm.plugin.finder.widget.post.c localc;
    for (;;)
    {
      if (localObject1 != null) {
        ((dji)localObject1).mediaId = UUID.randomUUID().toString();
      }
      if (i != 0) {
        break label653;
      }
      localc = eHl();
      localObject1 = eHw().eGZ().getText().toString();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(350135);
      throw ((Throwable)localObject1);
      localObject1 = ((djh)localObject1).mediaList;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = (dji)kotlin.a.p.ae((List)localObject1, 0);
      }
    }
    Object localObject6 = n.br((CharSequence)localObject1).toString();
    Object localObject4 = eHw().eHc().fmb().flX();
    Object localObject5 = sW(false);
    Object localObject3 = this.ETB;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("activityWidget");
      localObject1 = null;
    }
    localObject1 = ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).Gfj.getActivityEvent();
    kotlin.g.b.s.u(localObject6, "desc");
    kotlin.g.b.s.u(localObject2, "uploadData");
    kotlin.g.b.s.u(localObject5, "jumpInfoList");
    localObject3 = new boi();
    Object localObject7 = new axa();
    new dls();
    Object localObject8 = localc.Gfy.getByteArray("post_location");
    if (localObject8 != null) {
      ((boi)localObject3).parseFrom((byte[])localObject8);
    }
    localObject8 = localc.Gfy.getByteArray("post_extend_reading");
    if (localObject8 != null) {
      ((axa)localObject7).parseFrom((byte[])localObject8);
    }
    i = localc.Gfy.getInt("POST_ORIGINAL_FLAG", 0);
    boolean bool1 = localc.Gfy.getBoolean("post_from_camera", false);
    boolean bool2 = localc.Gfy.getBoolean("isNews");
    localObject8 = com.tencent.mm.plugin.finder.upload.g.GbJ;
    localObject8 = com.tencent.mm.plugin.finder.upload.g.fdW();
    int j = ((com.tencent.mm.plugin.finder.widget.post.h)localObject2).type;
    localObject6 = Util.nullAsNil((String)localObject6);
    kotlin.g.b.s.s(localObject6, "nullAsNil(desc)");
    Object localObject2 = ((com.tencent.mm.plugin.finder.upload.g)localObject8).a(j, (String)localObject6, ((com.tencent.mm.plugin.finder.widget.post.h)localObject2).HaW, (boi)localObject3, (axa)localObject7, i, localc.GZC, bool1, ((com.tencent.mm.plugin.finder.widget.post.h)localObject2).Gcs, (ArrayList)localObject4, localc.isLongVideo, bool2, (LinkedList)localObject5, (brg)localObject1);
    ((FinderItem)localObject2).setPreview(true);
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject2);
    localObject3 = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.feed.jumper.i)com.tencent.mm.ui.component.k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).q(com.tencent.mm.plugin.finder.feed.jumper.i.class)).F(kotlin.a.p.listOf(localObject2), 62);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("KEY_FROM_SCENE", 1);
    ((Intent)localObject2).putExtra("KEY_USERNAME", z.bAW());
    ((Intent)localObject2).putExtra("KEY_FINDER_SELF_FLAG", true);
    ((Intent)localObject2).putExtra("KEY_IS_FULLSCREEN", true);
    localObject3 = av.GiL;
    if (!av.isDisablePostHalfScreen()) {}
    for (bool1 = true;; bool1 = false)
    {
      ((Intent)localObject2).putExtra("KEY_ENABLE_SWITCH_PREVIEW_MODE", bool1);
      localObject3 = av.GiL;
      av.a(0, kotlin.a.p.listOf(localObject1), null, (Intent)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.S((Context)getContext(), (Intent)localObject2);
      AppMethodBeat.o(350135);
      return;
    }
    label653:
    if (i != 0)
    {
      localc = eHl();
      localObject4 = (Activity)getActivity();
      localObject1 = eHw().eGZ().getText().toString();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(350135);
        throw ((Throwable)localObject1);
      }
      localObject5 = n.br((CharSequence)localObject1).toString();
      localObject6 = eHw().eHc().fmb().flX();
      localObject3 = this.ETB;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("activityWidget");
        localObject1 = null;
      }
      localObject7 = ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).Gfj.getActivityEvent();
      localObject3 = this.ETB;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("activityWidget");
        localObject1 = null;
      }
      localObject2 = localc.a((Activity)localObject4, (String)localObject5, (com.tencent.mm.plugin.finder.widget.post.h)localObject2, true, (ArrayList)localObject6, (brg)localObject7, ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).feC(), sW(false));
      ((FinderItem)localObject2).setPreview(true);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject2);
      localObject3 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.feed.jumper.i)com.tencent.mm.ui.component.k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).q(com.tencent.mm.plugin.finder.feed.jumper.i.class)).F(kotlin.a.p.listOf(localObject2), 62);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("KEY_FROM_SCENE", 1);
      ((Intent)localObject2).putExtra("KEY_USERNAME", z.bAW());
      ((Intent)localObject2).putExtra("KEY_FINDER_SELF_FLAG", true);
      ((Intent)localObject2).putExtra("KEY_IS_FULLSCREEN", true);
      localObject3 = av.GiL;
      if (av.isDisablePostHalfScreen()) {
        break label990;
      }
    }
    label990:
    for (bool1 = true;; bool1 = false)
    {
      ((Intent)localObject2).putExtra("KEY_ENABLE_SWITCH_PREVIEW_MODE", bool1);
      localObject3 = av.GiL;
      av.a(0, kotlin.a.p.listOf(localObject1), null, (Intent)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.S((Context)getContext(), (Intent)localObject2);
      AppMethodBeat.o(350135);
      return;
    }
  }
  
  public final ScrollView ewP()
  {
    AppMethodBeat.i(349988);
    ScrollView localScrollView = this.lDL;
    if (localScrollView != null)
    {
      AppMethodBeat.o(349988);
      return localScrollView;
    }
    kotlin.g.b.s.bIx("scrollView");
    AppMethodBeat.o(349988);
    return null;
  }
  
  public final int getLayoutId()
  {
    return l.f.finder_post_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(350115);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject4;
    if (paramInt1 == 20000)
    {
      localObject4 = eHu();
      if (paramIntent != null)
      {
        localObject3 = ((e)localObject4).EsQ;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("locationWidget");
          localObject1 = null;
        }
        ((com.tencent.mm.plugin.finder.api.h)localObject1).ar(paramIntent);
        localObject1 = ((e)localObject4).EsQ;
        paramIntent = (Intent)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("locationWidget");
          paramIntent = null;
        }
        paramIntent.dUo();
        paramIntent = ((e)localObject4).EsQ;
        if (paramIntent == null)
        {
          kotlin.g.b.s.bIx("locationWidget");
          paramIntent = (Intent)localObject2;
        }
        for (;;)
        {
          paramIntent = paramIntent.getLocation();
          if (paramIntent == null) {
            break label184;
          }
          if ((Util.isNullOrNil(paramIntent.poiName)) && (Util.isNullOrNil(paramIntent.city))) {
            break;
          }
          localObject1 = v.FrN;
          v.a(2, paramIntent);
          AppMethodBeat.o(350115);
          return;
        }
        localObject1 = v.FrN;
        v.a(3, paramIntent);
      }
      label184:
      AppMethodBeat.o(350115);
      return;
    }
    localObject2 = com.tencent.mm.plugin.finder.widget.post.g.HaE;
    if (paramInt1 == com.tencent.mm.plugin.finder.widget.post.g.fqQ())
    {
      label217:
      label224:
      label230:
      com.tencent.mm.plugin.finder.widget.post.c localc;
      if (paramIntent == null)
      {
        localObject1 = null;
        if (paramIntent != null) {
          break label486;
        }
        localObject2 = null;
        if (paramIntent != null) {
          break label503;
        }
        localObject3 = null;
        if (paramIntent != null) {
          break label524;
        }
        paramIntent = null;
        localObject4 = paramIntent;
        if (paramIntent == null) {
          localObject4 = new LocalVideoCropInfoParcelable();
        }
        if (Util.isNullOrNil((String)localObject2)) {
          break label1097;
        }
        localc = eHl();
        kotlin.g.b.s.checkNotNull(localObject1);
        kotlin.g.b.s.checkNotNull(localObject2);
        if (localObject3 != null) {
          break label543;
        }
        paramInt1 = 0;
        label277:
        kotlin.g.b.s.u(localObject1, "fullCoverUrl");
        kotlin.g.b.s.u(localObject2, "coverUrl");
        kotlin.g.b.s.u(localObject4, "cropInfo");
        localc.Gfy.putString("VIDEO_FULL_COVER_URL", (String)localObject1);
        localc.intent.putExtra("VIDEO_FULL_COVER_URL", (String)localObject1);
        localc.Gfy.putString("VIDEO_COVER_URL", (String)localObject2);
        localc.intent.putExtra("VIDEO_COVER_URL", (String)localObject2);
        localc.Gfy.putInt("VIDEO_COVER_QUALITY", paramInt1);
        localc.intent.putExtra("VIDEO_COVER_QUALITY", paramInt1);
        localObject4 = ((LocalVideoCropInfoParcelable)localObject4).EDC;
        if (localObject4 == null) {
          break label629;
        }
        localObject3 = localc.GZK;
        if (localObject3 == null) {
          break label629;
        }
        if ((((ArrayList)localObject3).size() <= 0) || (!(((ArrayList)localObject3).get(0) instanceof LocalVideoCropInfoParcelable))) {
          break label552;
        }
      }
      label524:
      label543:
      label552:
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        paramIntent = localObject5;
        if (paramInt2 != 0) {
          paramIntent = (Intent)localObject3;
        }
        if (paramIntent == null) {
          break label629;
        }
        paramIntent = paramIntent.get(0);
        if (paramIntent != null) {
          break label557;
        }
        paramIntent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable");
        AppMethodBeat.o(350115);
        throw paramIntent;
        localObject1 = com.tencent.mm.plugin.finder.widget.post.g.HaE;
        localObject1 = paramIntent.getStringExtra(com.tencent.mm.plugin.finder.widget.post.g.fqR());
        break;
        label486:
        localObject2 = com.tencent.mm.plugin.finder.widget.post.g.HaE;
        localObject2 = paramIntent.getStringExtra(com.tencent.mm.plugin.finder.widget.post.g.fqS());
        break label217;
        label503:
        localObject3 = com.tencent.mm.plugin.finder.widget.post.g.HaE;
        localObject3 = Integer.valueOf(paramIntent.getIntExtra(com.tencent.mm.plugin.finder.widget.post.g.fqT(), 0));
        break label224;
        localObject4 = com.tencent.mm.plugin.finder.widget.post.g.HaE;
        paramIntent = (LocalVideoCropInfoParcelable)paramIntent.getParcelableExtra(com.tencent.mm.plugin.finder.widget.post.g.fqU());
        break label230;
        paramInt1 = ((Integer)localObject3).intValue();
        break label277;
      }
      label557:
      paramIntent = ((LocalVideoCropInfoParcelable)paramIntent).EDC;
      if (paramIntent != null)
      {
        paramIntent.aaPJ = ((dju)localObject4).aaPJ;
        paramIntent.aaPL = ((dju)localObject4).aaPL;
        paramIntent.aaPK = ((dju)localObject4).aaPK;
        localc.intent.putParcelableArrayListExtra("postVideoCropList", localc.GZK);
        localc.Gfy.putParcelableArrayList("VIDEO_CROP_LIST", localc.GZK);
        label629:
        if ((localc.Gcx != null) && (!Util.isNullOrNil((List)localc.GZZ)))
        {
          paramIntent = localc.GZZ;
          if (paramIntent != null)
          {
            paramIntent = (dji)kotlin.a.p.oL((List)paramIntent);
            if (paramIntent != null)
            {
              paramIntent.HaI = ((String)localObject1);
              paramIntent.coverUrl = ((String)localObject2);
              localObject1 = paramIntent.codec_info;
              if (localObject1 != null) {
                ((boy)localObject1).ZXr = paramInt1;
              }
              paramIntent.aaPg = "";
              paramIntent.aaPq = "";
            }
          }
        }
      }
      paramIntent = this.ETx;
      if (paramIntent != null)
      {
        paramIntent.av(eHl().Gfy);
        paramIntent.bDL();
        AppMethodBeat.o(350115);
      }
    }
    else if (paramInt1 == 20002)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject2 = this.ETB;
        if (localObject2 == null) {
          kotlin.g.b.s.bIx("activityWidget");
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).ap(paramIntent);
          getIntent().putExtra("key_activity_src_type", "key_scene_from_post");
          if (paramIntent.getIntExtra("key_activity_type", 100) == 100) {
            getIntent().putExtra("saveActivity", false);
          }
          aF(paramIntent);
          AppMethodBeat.o(350115);
          return;
          localObject1 = localObject2;
        }
      }
    }
    else if (paramInt1 == 20003)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = this.ETB;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("activityWidget");
          localObject1 = localObject3;
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).ap(paramIntent);
          getIntent().putExtra("key_activity_src_type", "key_scene_from_post");
          if (paramIntent.getIntExtra("key_activity_type", 100) == 100) {
            getIntent().putExtra("saveActivity", false);
          }
          aF(paramIntent);
          AppMethodBeat.o(350115);
          return;
        }
      }
    }
    else
    {
      if (paramInt1 == 20001)
      {
        ((MMActivity)getActivity()).showVKB();
        eHw().f(paramInt2, paramIntent);
        AppMethodBeat.o(350115);
        return;
      }
      if (paramInt1 == 20004)
      {
        localObject2 = eHv();
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          ((c)localObject2).eHk();
          localObject1 = ((c)localObject2).ETg;
          if (localObject1 != null)
          {
            localObject2 = (kotlin.g.a.a)new c.a((c)localObject2);
            kotlin.g.b.s.u(paramIntent, "data");
            localObject3 = new ArrayList();
            localObject4 = (com.tencent.mm.bx.a)new FinderJumpInfo();
            paramIntent = paramIntent.getByteArrayExtra("JUMP_INFO");
          }
        }
      }
    }
    try
    {
      ((com.tencent.mm.bx.a)localObject4).parseFrom(paramIntent);
      paramIntent = ah.aiuX;
      ((com.tencent.mm.plugin.finder.upload.postui.d)localObject1).hG((List)localObject3);
      ((com.tencent.mm.plugin.finder.upload.postui.d)localObject1).Gft = ((kotlin.g.a.a)localObject2);
      label1097:
      AppMethodBeat.o(350115);
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramIntent });
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(350073);
    Object localObject = com.tencent.mm.plugin.vlog.report.a.UeF;
    com.tencent.mm.plugin.vlog.report.a.a(74, 1, System.currentTimeMillis() - this.ETJ, 0, this.ETL, this.DUN);
    localObject = eHm();
    if (((com.tencent.mm.plugin.finder.upload.postui.e)localObject).Gfx.GHO) {
      ((com.tencent.mm.plugin.finder.upload.postui.e)localObject).Gfx.flY();
    }
    for (int i = 1; i == 0; i = 0)
    {
      eHy();
      AppMethodBeat.o(350073);
      return true;
    }
    AppMethodBeat.o(350073);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(350054);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity))
    {
      ((MMActivity)getActivity()).setSelfNavigationBarVisible(8);
      ((MMActivity)getActivity()).getController().updataStatusBarIcon(aw.isDarkMode());
    }
    getContext().getWindow().addFlags(2097280);
    if (Build.VERSION.SDK_INT >= 21) {
      getContext().getWindow().getDecorView().setSystemUiVisibility(getContext().getWindow().getDecorView().getSystemUiVisibility() | 0x400 | 0x100);
    }
    paramBundle = new com.tencent.mm.plugin.finder.widget.post.c(getIntent());
    kotlin.g.b.s.u(paramBundle, "<set-?>");
    this.ETI = paramBundle;
    paramBundle = z.bAW();
    kotlin.g.b.s.s(paramBundle, "getMyFinderUsername()");
    this.Bre = paramBundle;
    if (!Util.isNullOrNil(this.Bre))
    {
      paramBundle = com.tencent.mm.plugin.finder.api.d.AwY;
      this.contact = com.tencent.mm.plugin.finder.api.d.a.auT(this.Bre);
    }
    Object localObject3 = (MMActivity)getActivity();
    ((MMActivity)localObject3).setMMTitle("");
    ((MMActivity)localObject3).setActionbarColor(getResources().getColor(l.b.BW_100));
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.post_media_widget_container);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.…t_media_widget_container)");
    this.ETv = ((ViewGroup)paramBundle);
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.post_avatar);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.post_avatar)");
    this.lKK = ((ImageView)paramBundle);
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.post_nickname);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.post_nickname)");
    this.pWj = ((TextView)paramBundle);
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.scroll_view);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.scroll_view)");
    paramBundle = (ScrollView)paramBundle;
    kotlin.g.b.s.u(paramBundle, "<set-?>");
    this.lDL = paramBundle;
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.bottom_space);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.bottom_space)");
    this.DXr = paramBundle;
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.edt_container);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.edt_container)");
    this.DXs = paramBundle;
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.choose_original_view);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.choose_original_view)");
    this.ETz = new com.tencent.mm.plugin.finder.upload.postui.g((MMActivity)localObject3, (FinderChooseOriginalView)paramBundle);
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.choose_news_view);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.choose_news_view)");
    this.ETA = new com.tencent.mm.plugin.finder.upload.postui.h((MMActivity)localObject3, (FinderChooseNewsView)paramBundle);
    paramBundle = ((MMActivity)localObject3).findViewById(l.e.choose_activity_view);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.choose_activity_view)");
    this.ETC = ((FinderExtendActivityView)paramBundle);
    Object localObject1 = this.ETC;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("activityPostView");
      paramBundle = null;
    }
    this.ETB = new com.tencent.mm.plugin.finder.upload.postui.a(paramBundle);
    this.lKz = new com.tencent.mm.ui.tools.i((Activity)localObject3);
    paramBundle = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    float f1 = com.tencent.mm.plugin.finder.accessibility.a.g((Context)getContext(), 17.0F);
    paramBundle = getBackBtn();
    label570:
    int i;
    label648:
    Object localObject5;
    Object localObject6;
    if ((paramBundle instanceof TextView))
    {
      paramBundle = (TextView)paramBundle;
      if (paramBundle != null) {
        paramBundle.setTextSize(1, f1);
      }
      paramBundle = com.tencent.mm.plugin.vlog.util.a.UsM;
      paramBundle = getBackBtn();
      kotlin.g.b.s.s(paramBundle, "backBtn");
      com.tencent.mm.plugin.vlog.util.a.iM(paramBundle);
      paramBundle = eHp();
      if (!(paramBundle instanceof TextView)) {
        break label1247;
      }
      paramBundle = (TextView)paramBundle;
      if (paramBundle != null) {
        paramBundle.setTextSize(1, f1);
      }
      paramBundle = com.tencent.mm.plugin.vlog.util.a.UsM;
      paramBundle = eHp();
      kotlin.g.b.s.s(paramBundle, "sendBtn");
      com.tencent.mm.plugin.vlog.util.a.iM(paramBundle);
      ((MMActivity)localObject3).findViewById(l.e.scroll_view_child_parent).setOnClickListener(new f..ExternalSyntheticLambda6((MMActivity)localObject3));
      paramBundle = ((View)this.ETH.getValue()).getLayoutParams();
      if (!(paramBundle instanceof ViewGroup.MarginLayoutParams)) {
        break label1252;
      }
      paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
      if (paramBundle != null)
      {
        i = paramBundle.topMargin;
        paramBundle.topMargin = (bf.getStatusBarHeight((Context)localObject3) + i);
      }
      localObject4 = this.contact;
      if (localObject4 != null) {
        break label1257;
      }
      paramBundle = null;
      if (paramBundle == null)
      {
        localObject4 = (f)this;
        localObject1 = ((f)localObject4).lKK;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("avatarIv");
          paramBundle = null;
        }
        paramBundle.setVisibility(8);
        localObject1 = ((f)localObject4).pWj;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("nickTv");
          paramBundle = null;
        }
        paramBundle.setVisibility(8);
      }
      getBackBtn().setOnClickListener(new f..ExternalSyntheticLambda3(this));
      eHp().setEnabled(false);
      paramBundle = new boolean[1];
      paramBundle[0] = 0;
      eHp().setOnTouchListener(new f..ExternalSyntheticLambda9(paramBundle));
      eHp().setOnClickListener(new f..ExternalSyntheticLambda7(paramBundle, this, (MMActivity)localObject3));
      eHw().initView();
      paramBundle = eHu();
      localObject1 = com.tencent.mm.ui.component.k.aeZF.co(com.tencent.mm.plugin.finder.api.h.class);
      localObject4 = (com.tencent.mm.plugin.finder.api.h)localObject1;
      localObject5 = (MMActivity)paramBundle.getActivity();
      localObject6 = paramBundle.getActivity().findViewById(l.e.post_location_view);
      kotlin.g.b.s.s(localObject6, "activity.findViewById<Lo…(R.id.post_location_view)");
      ((com.tencent.mm.plugin.finder.api.h)localObject4).a((MMActivity)localObject5, (com.tencent.mm.pluginsdk.location.b)localObject6, paramBundle.getActivity().findViewById(l.e.poi_tip_layout), (TextView)paramBundle.getActivity().findViewById(l.e.poi_tip_tv));
      localObject4 = ah.aiuX;
      paramBundle.EsQ = ((com.tencent.mm.plugin.finder.api.h)localObject1);
      if (paramBundle.eBW())
      {
        paramBundle = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).pH(false);
      }
      paramBundle = this.lKz;
      if (paramBundle != null) {
        break label1573;
      }
      kotlin.g.b.s.bIx("keyboardHeightProvider");
      paramBundle = null;
      label976:
      paramBundle.afIL = ((com.tencent.mm.ui.tools.h)this);
      paramBundle = this.contact;
      localObject1 = ((MMActivity)localObject3).findViewById(l.e.extend_reading_view);
      kotlin.g.b.s.s(localObject1, "activity.findViewById(R.id.extend_reading_view)");
      paramBundle = new com.tencent.mm.plugin.finder.upload.postui.e((MMActivity)localObject3, paramBundle, (FinderExtendReadingView)localObject1, (kotlin.g.a.b)new f.h(this));
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.ETy = paramBundle;
      localObject1 = getIntent().getStringExtra("saveDesc");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        paramBundle = com.tencent.mm.plugin.finder.activity.a.Atw;
        paramBundle = com.tencent.mm.plugin.finder.activity.a.dTp();
        if (paramBundle != null) {
          break label1576;
        }
        paramBundle = "";
      }
    }
    Object localObject7;
    for (;;)
    {
      kotlin.g.b.s.s(paramBundle, "intent.getStringExtra(Co…ramStore.getPostWording()");
      localObject1 = getIntent().getParcelableArrayListExtra("saveDescAt");
      if (localObject1 == null) {
        break label1600;
      }
      localObject4 = eHw().eHc().fmb();
      kotlin.g.b.s.u(localObject1, "atContactParcelList");
      localObject5 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject1 = (LocalFinderAtContactParcel)((Iterator)localObject5).next();
        try
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.h.Gga;
          kotlin.g.b.s.s(localObject1, "atContactParcel");
          localObject6 = com.tencent.mm.plugin.finder.utils.h.a((LocalFinderAtContactParcel)localObject1);
          localObject7 = ((com.tencent.mm.plugin.finder.view.manager.b)localObject4).GHC;
          localObject3 = ((djg)localObject6).nickname;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          ((HashMap)localObject7).put(localObject1, localObject6);
        }
        catch (Exception localException)
        {
          Log.e(com.tencent.mm.plugin.finder.view.manager.b.TAG, "restoreAtContactMap transformToLocalFinderAtContact parseFrom:%s", new Object[] { localException.getMessage() });
        }
      }
      paramBundle = null;
      break;
      label1247:
      paramBundle = null;
      break label570;
      label1252:
      paramBundle = null;
      break label648;
      label1257:
      localObject5 = com.tencent.mm.plugin.finder.api.c.a((com.tencent.mm.plugin.finder.api.m)localObject4, true);
      if (localObject5 == null)
      {
        paramBundle = null;
        if (paramBundle == null)
        {
          paramBundle = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
          localObject6 = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.plugin.finder.api.m)localObject4).field_avatarUrl);
          localObject2 = this.lKK;
          paramBundle = (Bundle)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("avatarIv");
            paramBundle = null;
          }
          localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject5).a(localObject6, paramBundle, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
          paramBundle = this.pWj;
          if (paramBundle != null) {
            break label1570;
          }
          kotlin.g.b.s.bIx("nickTv");
          paramBundle = null;
        }
      }
      label1570:
      for (;;)
      {
        paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject4).getNickname()));
        paramBundle = ((MMActivity)localObject3).findViewById(l.e.biz_title_area);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
        localObject2 = this.ETC;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("activityPostView");
          paramBundle = null;
        }
        paramBundle.setContact((com.tencent.mm.plugin.finder.api.m)localObject4);
        paramBundle = ah.aiuX;
        break;
        paramBundle = ((MMActivity)localObject3).findViewById(l.e.biz_title_area);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        paramBundle = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject6 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject7 = new com.tencent.mm.plugin.finder.loader.b(((pu)localObject5).xkY);
        localObject2 = this.lKK;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("avatarIv");
          paramBundle = null;
        }
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject6).a(localObject7, paramBundle, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        paramBundle = this.pWj;
        if (paramBundle == null)
        {
          kotlin.g.b.s.bIx("nickTv");
          paramBundle = null;
        }
        for (;;)
        {
          paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getContext(), (CharSequence)((pu)localObject5).YTl));
          paramBundle = ah.aiuX;
          break;
        }
      }
      label1573:
      break label976;
      label1576:
      localObject2 = paramBundle.getStringExtra("key_activity_post_wording");
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null) {
        paramBundle = "";
      }
    }
    label1600:
    Object localObject4 = eHw().eHc().fmb();
    Object localObject2 = eHl().Hac;
    if (localObject2 != null)
    {
      localObject5 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject2 = (FinderContact)((Iterator)localObject5).next();
        localObject3 = com.tencent.mm.plugin.finder.utils.h.Gga;
        localObject6 = com.tencent.mm.plugin.finder.utils.h.i((FinderContact)localObject2);
        if (localObject6 != null)
        {
          localObject7 = ((com.tencent.mm.plugin.finder.view.manager.b)localObject4).GHC;
          localObject3 = ((djg)localObject6).nickname;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          ((HashMap)localObject7).put(localObject2, localObject6);
        }
      }
    }
    if (!Util.isNullOrNil(paramBundle)) {
      eHw().eGZ().setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getContext(), (CharSequence)paramBundle));
    }
    localObject3 = eHu();
    localObject2 = ((e)localObject3).EsQ;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("locationWidget");
      paramBundle = null;
    }
    paramBundle.c(((e)localObject3).getIntent(), ((e)localObject3).eHl().Gfy);
    eHm().c(getIntent(), eHl().Gfy);
    eHv().a(eHm());
    localObject2 = this.ETz;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("originalWidget");
      paramBundle = null;
    }
    paramBundle.c(getIntent(), eHl().Gfy);
    localObject2 = this.ETA;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("newsWidget");
      paramBundle = null;
    }
    paramBundle.c(getIntent(), eHl().Gfy);
    localObject2 = this.ETB;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("activityWidget");
      paramBundle = null;
    }
    paramBundle.c(getIntent(), eHl().Gfy);
    paramBundle = eHl().GZH;
    label1956:
    label1959:
    label1985:
    label1986:
    long l;
    if (paramBundle == null)
    {
      if (paramBundle != null) {
        break label2672;
      }
      i = 0;
      if (i == 0) {
        break label2687;
      }
      this.ETx = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.e((Context)getActivity(), (byte)0));
      break label2691;
      localObject3 = this.ETx;
      if (localObject3 != null) {
        break label2760;
      }
      paramBundle = null;
      if (paramBundle == null) {
        eHq();
      }
      localObject3 = eHl();
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZP;
      if (paramBundle != null) {
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putByteArray("MEDIA_EXTRA_MUSIC", paramBundle);
      }
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).FSX;
      if (paramBundle != null) {
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putByteArray("ORIGIN_MUSIC_INFO", paramBundle);
      }
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putString("ORIGIN_MUSIC_ID", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).FSW);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putString("ORIGIN_MUSIC_PATH", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).FSU);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putString("ORIGIN_BGM_URL", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).FSY);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putBoolean("MEDIA_IS_MUTE", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZQ);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putBoolean("MUSIC_IS_MUTE", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZR);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putInt("SOUND_TRACK_TYPE", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).soundTrackType);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putString("MUSIC_FEED_ID", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).musicFeedId);
      if ((((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZN == null) || (((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZC == null)) {
        break label2932;
      }
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy;
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZN;
      kotlin.g.b.s.checkNotNull(localObject2);
      paramBundle.putByteArray("post_ref_feed_content", ((FinderObjectDesc)localObject2).toByteArray());
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy;
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZC;
      kotlin.g.b.s.checkNotNull(localObject2);
      paramBundle.putByteArray("post_ref_feed_info", ((brq)localObject2).toByteArray());
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putBoolean("post_from_camera", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sft);
      paramBundle = this.ETx;
      if (paramBundle != null)
      {
        paramBundle.av(eHl().Gfy);
        paramBundle.bDL();
      }
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new i(this));
      eHt();
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      i = com.tencent.mm.plugin.finder.storage.d.eUn();
      paramBundle = ac.Ghd;
      if ((ac.ffe()) && (i > 0))
      {
        paramBundle = new com.tencent.mm.plugin.finder.view.d((Context)getContext());
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        com.tencent.mm.plugin.finder.storage.d.To(i - 1);
        paramBundle.UD(l.f.finder_original_post_tips_bottom_sheet);
        localObject2 = (TextView)paramBundle.rootView.findViewById(l.e.original_post_title_tv);
        kotlin.g.b.s.s(localObject2, "titleTv");
        com.tencent.mm.plugin.finder.utils.i.setTextBold((TextView)localObject2);
        paramBundle.rootView.findViewById(l.e.original_apply_btn).setOnClickListener(new f..ExternalSyntheticLambda5(paramBundle));
        paramBundle.dDn();
      }
      if (getIntent().getBooleanExtra("KEY_FINDER_POST_FORM_FLUTTER", false))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1565, 3);
        Log.i(this.ETu, "enter export activity");
        l = getIntent().getLongExtra("KEY_FINDER_POST_EXPORT_START_TIME", 0L);
        l = System.currentTimeMillis() - l;
        com.tencent.mm.plugin.report.service.h.OAn.p(1565L, 5L, l);
        Log.i(this.ETu, "enter export activity cost " + l + "ms");
      }
      this.ETJ = System.currentTimeMillis();
      if (eHl().GZY != null) {
        break label4178;
      }
      paramBundle = null;
      this.ETL = paramBundle;
      paramBundle = getIntent().getStringExtra("key_jump_id");
      if (paramBundle != null) {
        break label4246;
      }
      paramBundle = "";
      label2558:
      this.DUN = paramBundle;
      paramBundle = com.tencent.mm.plugin.vlog.report.a.UeF;
      com.tencent.mm.plugin.vlog.report.a.a(74, 0, 0L, 0, this.ETL, this.DUN, 12);
      paramBundle = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramBundle = v.FrN;
      paramBundle = v.eMS();
      if (paramBundle != null) {
        break label4273;
      }
      paramBundle = "";
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(paramBundle, com.tencent.mm.plugin.finder.report.postreport.b.eOh());
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      this.AtZ = ((com.tencent.mm.plugin.finder.activity.uic.a)com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.plugin.finder.activity.uic.a.class)).AtZ;
      this.ETO.alive();
      AppMethodBeat.o(350054);
      return;
      if (paramBundle.intValue() != 2) {
        break;
      }
      i = 1;
      break label1959;
      label2672:
      if (paramBundle.intValue() != 7) {
        break label1956;
      }
      i = 1;
      break label1959;
      label2687:
      if (paramBundle == null)
      {
        if ((paramBundle == null) || (paramBundle.intValue() != 8)) {
          break label1986;
        }
        this.ETx = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.f((Context)getActivity()));
        break label1986;
      }
      label2691:
      if (paramBundle.intValue() != 4) {
        break label1985;
      }
      this.ETx = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.g((Context)getActivity()));
      break label1986;
      label2760:
      localObject2 = this.ETv;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mediaViewContainer");
        paramBundle = null;
      }
      paramBundle.removeAllViews();
      localObject3 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject3).fqB();
      if (localObject3 == null)
      {
        localObject2 = this.ETv;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("mediaViewContainer");
          paramBundle = null;
        }
        paramBundle.setVisibility(8);
      }
      for (;;)
      {
        paramBundle = ah.aiuX;
        break;
        localObject2 = this.ETv;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("mediaViewContainer");
          paramBundle = null;
        }
        paramBundle.addView((View)localObject3);
        localObject2 = this.ETv;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("mediaViewContainer");
          paramBundle = null;
        }
        paramBundle.post(new f..ExternalSyntheticLambda17(this, (View)localObject3));
        localObject2 = this.ETv;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("mediaViewContainer");
          paramBundle = null;
        }
        paramBundle.setOnClickListener(null);
        eHq();
      }
      label2932:
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZH;
      if (paramBundle == null)
      {
        label2942:
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZH;
        if (paramBundle != null) {
          break label3230;
        }
        label2952:
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZH;
        if (paramBundle != null) {
          break label3266;
        }
      }
      label3075:
      label3118:
      label3253:
      label3266:
      while (paramBundle.intValue() != 4)
      {
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZH;
        if ((paramBundle == null) || (paramBundle.intValue() != 8)) {
          break;
        }
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putStringArrayList("MEDIA_FILE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).ofu);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putIntegerArrayList("MEDIA_TYPE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZM);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZK);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putStringArrayList("MEDIA_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZL);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putParcelable("vlog_crop_rect", (Parcelable)((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZO);
        break;
        if (paramBundle.intValue() != 2) {
          break label2942;
        }
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy;
        localObject2 = com.tencent.mm.plugin.finder.widget.post.e.Hag;
        paramBundle.putStringArrayList(com.tencent.mm.plugin.finder.widget.post.e.fqE(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).ofu);
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZI != null)
        {
          paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZI;
          if (paramBundle != null) {
            break label3242;
          }
          paramBundle = null;
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).ofu;
          if (localObject2 != null) {
            break label3253;
          }
        }
        for (localObject2 = null;; localObject2 = Integer.valueOf(((ArrayList)localObject2).size()))
        {
          if (kotlin.g.b.s.p(paramBundle, localObject2))
          {
            paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy;
            localObject2 = com.tencent.mm.plugin.finder.widget.post.e.Hag;
            paramBundle.putIntegerArrayList(com.tencent.mm.plugin.finder.widget.post.e.fqF(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZI);
          }
          paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy;
          localObject2 = com.tencent.mm.plugin.finder.widget.post.e.Hag;
          paramBundle.putStringArrayList(com.tencent.mm.plugin.finder.widget.post.e.fqG(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZL);
          paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy;
          localObject2 = com.tencent.mm.plugin.finder.widget.post.e.Hag;
          paramBundle.putStringArrayList(com.tencent.mm.plugin.finder.widget.post.e.fqH(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZW);
          ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putParcelableArrayList("HALF_RECT_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZX);
          break;
          if (paramBundle.intValue() != 7) {
            break label2952;
          }
          break label3075;
          paramBundle = Integer.valueOf(paramBundle.size());
          break label3118;
        }
      }
      label3230:
      label3242:
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putStringArrayList("video_file_list", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).ofu);
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZJ != null) {
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putByteArray("video_composition", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZJ);
      }
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject3).isLongVideo)
      {
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZK;
        if (paramBundle != null)
        {
          if (paramBundle.size() <= 0) {
            break label3575;
          }
          i = 1;
          label3342:
          if (i == 0) {
            break label3581;
          }
          label3347:
          if (paramBundle != null) {}
        }
        else
        {
          localObject2 = new LocalVideoCropInfoParcelable();
          paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).ofu;
          if (paramBundle != null) {
            break label3586;
          }
          paramBundle = null;
        }
      }
      for (;;)
      {
        if (paramBundle != null)
        {
          localObject5 = MultiMediaVideoChecker.ObB.aTG(paramBundle);
          if (localObject5 != null) {
            break label3633;
          }
          Log.e(((com.tencent.mm.plugin.finder.widget.post.c)localObject3).TAG, "initLongVideoCropInfo: video info is null");
        }
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putBoolean("post_long_video", true);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZK);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putStringArrayList("VIDEO_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZL);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putString("video_before_cut_path", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.getStringExtra("select_video_path"));
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putString("VIDEO_COVER_URL", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.getStringExtra("VIDEO_COVER_URL"));
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putString("VIDEO_FULL_COVER_URL", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.getStringExtra("VIDEO_FULL_COVER_URL"));
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putInt("VIDEO_COVER_QUALITY", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.getIntExtra("VIDEO_COVER_QUALITY", 0));
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putParcelableArrayList("HALF_RECT_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZX);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).Gfy.putByteArray("KEY_POST_VIDEO_TEMPLATE", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.getByteArrayExtra("KEY_POST_VIDEO_TEMPLATE"));
        break;
        label3575:
        i = 0;
        break label3342;
        label3581:
        paramBundle = null;
        break label3347;
        label3586:
        if (paramBundle.size() > 0)
        {
          i = 1;
          label3596:
          if (i == 0) {
            break label3616;
          }
        }
        for (;;)
        {
          if (paramBundle != null) {
            break label3621;
          }
          paramBundle = null;
          break;
          i = 0;
          break label3596;
          label3616:
          paramBundle = null;
        }
        label3621:
        paramBundle = (String)paramBundle.get(0);
      }
      label3633:
      f1 = ((MultiMediaVideoChecker.a)localObject5).height;
      float f2 = ((MultiMediaVideoChecker.a)localObject5).width;
      label3676:
      float f5;
      float f3;
      float f4;
      switch (SightVideoJNI.getMp4RotateVFS(paramBundle))
      {
      default: 
        localObject4 = new Matrix();
        f5 = bf.bf(MMApplicationContext.getContext()).x;
        f3 = f2 / f1;
        if (f3 < 0.75F)
        {
          f2 = f5 / f2;
          ((Matrix)localObject4).postScale(f2, f2);
          f4 = f5 / 0.75F;
          f3 = (f1 * f2 - f4) / 2.0F;
          f4 = f3 + f4;
          f1 = 0.0F;
          label3751:
          paramBundle = new dju();
          localObject6 = com.tencent.mm.plugin.finder.storage.d.FAy;
          l = com.tencent.mm.plugin.finder.storage.d.eRl() * 1000L;
          if (((MultiMediaVideoChecker.a)localObject5).duration <= l) {
            break label4167;
          }
        }
        break;
      }
      label4167:
      for (i = (int)l;; i = (int)((MultiMediaVideoChecker.a)localObject5).duration)
      {
        paramBundle.endTime = i;
        localObject5 = new fyb();
        ((fyb)localObject5).left = ((int)f1);
        ((fyb)localObject5).top = ((int)f4);
        ((fyb)localObject5).bottom = ((int)f3);
        ((fyb)localObject5).right = ((int)f5);
        localObject6 = ah.aiuX;
        paramBundle.aaPJ = ((fyb)localObject5);
        localObject5 = new fyb();
        ((fyb)localObject5).left = ((int)(f1 / f2));
        ((fyb)localObject5).top = ((int)(f4 / f2));
        ((fyb)localObject5).bottom = ((int)(f3 / f2));
        ((fyb)localObject5).right = ((int)(f5 / f2));
        localObject6 = ah.aiuX;
        paramBundle.aaPL = ((fyb)localObject5);
        paramBundle.height = ((int)(f4 - f3));
        paramBundle.width = ((int)(f5 - f1));
        ((Matrix)localObject4).postTranslate(-f1, -f3);
        localObject5 = new byz();
        localObject6 = new float[9];
        ((Matrix)localObject4).getValues((float[])localObject6);
        ((byz)localObject5).aaib.addAll((Collection)kotlin.a.k.D((float[])localObject6));
        localObject4 = ah.aiuX;
        paramBundle.aaPK = ((byz)localObject5);
        paramBundle.editId = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).editId;
        ((LocalVideoCropInfoParcelable)localObject2).EDC = paramBundle;
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZK == null) {
          ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZK = new ArrayList();
        }
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZK;
        if (paramBundle != null) {
          paramBundle.add(localObject2);
        }
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.putParcelableArrayListExtra("postVideoCropList", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).GZK);
        break;
        f1 = ((MultiMediaVideoChecker.a)localObject5).width;
        f2 = ((MultiMediaVideoChecker.a)localObject5).height;
        break label3676;
        if (f3 > 1.0F)
        {
          float f7 = f1 * 1.0F;
          float f6 = f5 / f7;
          ((Matrix)localObject4).postScale(f6, f6);
          f4 = f1 * f6;
          f3 = 0.0F;
          f1 = (f2 - f7) * f6 / 2.0F;
          f5 = f1 + f7 * f6;
          f2 = f6;
          break label3751;
        }
        f2 = f5 / f2;
        ((Matrix)localObject4).postScale(f2, f2);
        f4 = f1 * f2;
        f1 = 0.0F;
        f3 = 0.0F;
        break label3751;
      }
      label4178:
      localObject2 = eHl().GZY;
      kotlin.g.b.s.checkNotNull(localObject2);
      paramBundle = new JSONObject();
      if (((byy)localObject2).type == 2) {
        paramBundle.put("shooting_templateid", ((byy)localObject2).id);
      }
      for (;;)
      {
        localObject2 = ah.aiuX;
        break;
        paramBundle.put("templateid", ((byy)localObject2).id);
      }
      label4246:
      localObject2 = n.bV(paramBundle, ",", ";");
      paramBundle = (Bundle)localObject2;
      if (localObject2 != null) {
        break label2558;
      }
      paramBundle = "";
      break label2558;
      label4273:
      localObject2 = paramBundle.flowId;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null) {
        paramBundle = "";
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(350144);
    super.onDestroy();
    if (this.ETB == null) {
      kotlin.g.b.s.bIx("activityWidget");
    }
    com.tencent.mm.plugin.finder.upload.postui.a.onDestroy();
    this.ETO.dead();
    a locala = a.EST;
    a.bz(3, "");
    AppMethodBeat.o(350144);
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(350092);
    Object localObject1 = eHw().eHa();
    View localView = eHw().eHb();
    if (paramInt > 0) {}
    Object localObject2;
    for (int i = 1;; i = 0)
    {
      if ((paramInt > 0) && (paramInt != (int)((FinderPostFooter)localObject1).FZp))
      {
        KeyBoardUtil.saveKeyBordHeightPx(((FinderPostFooter)localObject1).getContext(), paramInt);
        ((FinderPostFooter)localObject1).FZp = paramInt;
        localObject2 = new LinearLayout.LayoutParams(-1, (int)((FinderPostFooter)localObject1).FZp);
        ((FinderPostFooter)localObject1).getSmileyPanel().setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = ((FinderPostFooter)localObject1).getSmileyBtn().getTag();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(350092);
      throw ((Throwable)localObject1);
    }
    paramBoolean = ((Boolean)localObject2).booleanValue();
    if ((i == 0) && (!paramBoolean))
    {
      localObject2 = ((FinderPostFooter)localObject1).hDw;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      if ((i != 0) && (paramBoolean)) {
        ((FinderPostFooter)localObject1).ao(false, false);
      }
      if (eHw().ESV == null) {
        break label226;
      }
    }
    label226:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label231;
      }
      AppMethodBeat.o(350092);
      return;
      localObject2 = ((FinderPostFooter)localObject1).hDw;
      if (localObject2 == null) {
        break;
      }
      ((View)localObject2).setVisibility(0);
      break;
    }
    label231:
    ((FinderPostFooter)localObject1).post(new f..ExternalSyntheticLambda16(this, localView));
    AppMethodBeat.o(350092);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(350065);
    super.onResume();
    this.BqU = bf.fs((Context)getContext());
    eHm().Gfx.flZ();
    com.tencent.mm.plugin.vlog.model.m localm = com.tencent.mm.plugin.vlog.model.m.TYW;
    com.tencent.mm.plugin.vlog.model.m.hQz();
    AppMethodBeat.o(350065);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(350060);
    if (!this.ETM)
    {
      com.tencent.mm.ui.tools.i locali2 = this.lKz;
      com.tencent.mm.ui.tools.i locali1 = locali2;
      if (locali2 == null)
      {
        kotlin.g.b.s.bIx("keyboardHeightProvider");
        locali1 = null;
      }
      locali1.start();
      this.ETM = true;
    }
    AppMethodBeat.o(350060);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(f paramf, com.tencent.mm.plugin.finder.widget.post.h paramh, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    i(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.f
 * JD-Core Version:    0.7.0.1
 */