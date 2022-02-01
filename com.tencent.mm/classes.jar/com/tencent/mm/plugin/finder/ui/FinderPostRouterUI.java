package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC;
import com.tencent.mm.plugin.finder.publish.i;
import com.tencent.mm.plugin.finder.publish.l.a;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.u;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "bgmIfOrigin", "", "finderContextId", "", "fromAddMedia", "fromRecordUI", "hasStopped", "originBgmUrl", "originMusicId", "originMusicInfo", "", "originMusicName", "originMusicPath", "postId", "routeFrom", "", "getRouteFrom", "()I", "setRouteFrom", "(I)V", "router", "sessionId", "choosePostRouterByVideoDurationMs", "", "getLayoutId", "goRouter", "gotoMediaEdit", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "context", "Landroid/content/Context;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onNewIntent", "intent", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "takePhoto", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPostRouterUI
  extends MMFinderUI
  implements CaptureDataManager.b
{
  public static final a FSQ;
  private int Bqi = -1;
  private boolean FSR;
  private boolean FSS;
  private String FST = "";
  private String FSU;
  private String FSV;
  private String FSW;
  private byte[] FSX;
  private String FSY;
  private boolean FSZ;
  private boolean FTa;
  private int FTb = -1;
  private String postId = "";
  private String sessionId = "";
  
  static
  {
    AppMethodBeat.i(347353);
    FSQ = new a((byte)0);
    AppMethodBeat.o(347353);
  }
  
  private static final void a(FinderPostRouterUI paramFinderPostRouterUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(347291);
    s.u(paramFinderPostRouterUI, "this$0");
    paramDialogInterface.dismiss();
    paramFinderPostRouterUI.finish();
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramFinderPostRouterUI.getContext());
    AppMethodBeat.o(347291);
  }
  
  private static final void b(FinderPostRouterUI paramFinderPostRouterUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(347301);
    s.u(paramFinderPostRouterUI, "this$0");
    paramDialogInterface.dismiss();
    paramFinderPostRouterUI.finish();
    AppMethodBeat.o(347301);
  }
  
  private void bpM()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167502);
    boolean bool3;
    Object localObject1;
    Object localObject2;
    if ((TextUtils.isEmpty((CharSequence)this.FSW)) && (TextUtils.isEmpty((CharSequence)this.FSU)) && (TextUtils.isEmpty((CharSequence)this.FSV)) && (TextUtils.isEmpty((CharSequence)this.FSY)) && (this.FSX == null))
    {
      bool1 = true;
      bool3 = getIntent().hasExtra("KEY_POST_VIDEO_TEMPLATE");
      localObject1 = new StringBuilder("takePhoto canUseTemplatePage:").append(bool1).append(" isTemplateFollow:").append(bool3).append(" enableTemplate:");
      localObject2 = com.tencent.mm.plugin.finder.record.config.a.Fix;
      Log.i("Finder.FinderPostRouterUI", com.tencent.mm.plugin.finder.record.config.a.eLj());
      if (!bool1) {
        break label474;
      }
      bool1 = bool2;
      if (!bool3)
      {
        localObject1 = com.tencent.mm.plugin.finder.record.config.a.Fix;
        if (!com.tencent.mm.plugin.finder.record.config.a.eLj()) {
          break label474;
        }
      }
    }
    label474:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject1 = com.tencent.mm.plugin.finder.ui.edit.a.FXw;
      localObject1 = com.tencent.mm.plugin.finder.ui.edit.a.uo(bool1);
      ((RecordConfigProvider)localObject1).oSS = new Bundle();
      ((RecordConfigProvider)localObject1).oSS.putAll(getIntent().getExtras());
      ((RecordConfigProvider)localObject1).oSS.remove("key_view_info");
      localObject2 = ((RecordConfigProvider)localObject1).oSS;
      Object localObject3 = bm.GlZ;
      ((Bundle)localObject2).putString("output_dir", bm.fit());
      ((RecordConfigProvider)localObject1).oSS.putString("FINDER_CONTEXT_ID", this.FST);
      ((RecordConfigProvider)localObject1).oSS.putString("FINDER_SESSION_ID", this.sessionId);
      ((RecordConfigProvider)localObject1).oSS.putString("post_id", this.postId);
      ((RecordConfigProvider)localObject1).oSS.putString("KEY_ORIGIN_MUSIC_ID", this.FSW);
      ((RecordConfigProvider)localObject1).oSS.putString("KEY_ORIGIN_MUSIC_PATH", this.FSU);
      ((RecordConfigProvider)localObject1).oSS.putString("KEY_ORIGIN_MUSIC_NAME", this.FSV);
      ((RecordConfigProvider)localObject1).oSS.putByteArray("KEY_ORIGIN_MUSIC_INFO", this.FSX);
      ((RecordConfigProvider)localObject1).oSS.putString("KEY_ORIGIN_BGM_URL", this.FSY);
      ((RecordConfigProvider)localObject1).oSS.putBoolean("KEY_BGM_IF_ORIGIN", this.FSZ);
      if (bool3) {
        ((RecordConfigProvider)localObject1).oSS.putByteArray("KEY_POST_VIDEO_TEMPLATE", getIntent().getByteArrayExtra("KEY_POST_VIDEO_TEMPLATE"));
      }
      if (bool1)
      {
        localObject2 = com.tencent.mm.media.camera.e.a.nvP;
        localObject2 = (Context)this;
        localObject3 = com.tencent.mm.media.camera.e.a.nvP;
        localObject3 = getContext();
        s.s(localObject3, "context");
        com.tencent.mm.media.camera.e.a.a((Context)localObject2, com.tencent.mm.media.camera.e.a.dC((Context)localObject3));
      }
      CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)this);
      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, l.a.sight_slide_bottom_in, l.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
      AppMethodBeat.o(167502);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(167503);
    s.u(paramContext, "context");
    s.u(paramCaptureVideoNormalModel, "model");
    s.u(paramBundle, "extData");
    Log.i("Finder.FinderPostRouterUI", "onMediaGenerated");
    this.FSS = false;
    Object localObject1 = new dmb();
    ((dmb)localObject1).aaSg = true;
    ((dmb)localObject1).aaSf = false;
    localObject1 = getIntent();
    ArrayList localArrayList = (ArrayList)paramCaptureVideoNormalModel.gHE().J("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
    Object localObject2 = paramBundle.getByteArray("MEDIA_EXTRA_MUSIC");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("MEDIA_EXTRA_MUSIC", (byte[])localObject2);
    }
    localObject2 = paramBundle.getByteArray("ORIGIN_MUSIC_INFO");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("ORIGIN_MUSIC_INFO", (byte[])localObject2);
    }
    s.s(localObject1, "postIntent");
    com.tencent.mm.ae.d.a((Intent)localObject1, paramBundle, "ORIGIN_MUSIC_ID");
    com.tencent.mm.ae.d.a((Intent)localObject1, paramBundle, "ORIGIN_MUSIC_PATH");
    com.tencent.mm.ae.d.a((Intent)localObject1, paramBundle, "ORIGIN_BGM_URL");
    com.tencent.mm.ae.d.b((Intent)localObject1, paramBundle, "MEDIA_IS_MUTE");
    com.tencent.mm.ae.d.b((Intent)localObject1, paramBundle, "MUSIC_IS_MUTE");
    com.tencent.mm.ae.d.c((Intent)localObject1, paramBundle, "SOUND_TRACK_TYPE");
    com.tencent.mm.ae.d.a((Intent)localObject1, paramBundle, "MUSIC_FEED_ID");
    localObject2 = paramBundle.getParcelableArrayList("KEY_POST_HALF_RECT_LIST");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("KEY_POST_HALF_RECT_LIST", (Serializable)localObject2);
    }
    localObject2 = paramBundle.getByteArray("KEY_POST_VIDEO_TEMPLATE");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("KEY_POST_VIDEO_TEMPLATE", (byte[])localObject2);
    }
    localObject2 = (Collection)paramCaptureVideoNormalModel.NHM;
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)new ArrayList((Collection)paramCaptureVideoNormalModel.NHM));
      localObject2 = paramCaptureVideoNormalModel.NHM;
      s.s(localObject2, "model.multiImagePath");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          ((Iterator)localObject3).next();
          ((Collection)localObject2).add(Integer.valueOf(2));
          continue;
          i = 0;
          break;
        }
      }
      ((Intent)localObject1).putExtra("postTypeList", (Serializable)localObject2);
      if ((localArrayList != null) && (localArrayList.size() == paramCaptureVideoNormalModel.NHM.size())) {
        ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
      com.tencent.mm.ae.d.d((Intent)localObject1, paramBundle, "KEY_POST_HALF_IMAGE_LIST");
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("KEY_POST_FROM_CAMERA", true);
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)paramCaptureVideoNormalModel.gHE().J("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramBundle = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, (Intent)localObject1);
      paramContext = v.FrN;
      paramContext = paramCaptureVideoNormalModel.gHE();
      s.s(paramContext, "model.reportInfo");
      v.a(paramContext);
      AppMethodBeat.o(167503);
      return;
      localObject2 = paramCaptureVideoNormalModel.NHK;
      s.s(localObject2, "model.photo");
      if (!((Boolean)localObject2).booleanValue()) {
        break;
      }
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.thumbPath);
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
    }
    if (paramBundle.getByteArray("video_composition") != null)
    {
      ((Intent)localObject1).putExtra("video_composition", paramBundle.getByteArray("video_composition"));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)p.al(new String[] { paramCaptureVideoNormalModel.thumbPath }));
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("postType", 4);
      break;
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.videoPath);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
    }
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(347443);
    s.u(paramRecordMediaReportInfo, "reportInfo");
    s.u(paramBundle, "extData");
    paramBundle = v.FrN;
    v.b(paramRecordMediaReportInfo);
    AppMethodBeat.o(347443);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(167504);
    s.u(paramContext, "context");
    s.u(paramBundle, "extData");
    s.u(parama, "finishController");
    AppMethodBeat.o(167504);
    return false;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(347465);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("Finder.FinderPostRouterUI", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(347465);
      return;
      if (paramInt2 == 0)
      {
        Log.i("Finder.FinderPostRouterUI", "record cancel");
        if (paramIntent != null)
        {
          paramIntent = (RecordMediaReportInfo)paramIntent.getParcelableExtra("report");
          if (paramIntent != null)
          {
            localObject1 = v.FrN;
            v.a(paramIntent);
          }
        }
        paramIntent = v.FrN;
        v.SA(1);
      }
      finish();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(347465);
      return;
      if (paramInt2 != -1)
      {
        finish();
        overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
        AppMethodBeat.o(347465);
        return;
      }
      s.checkNotNull(paramIntent);
      Object localObject1 = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      s.checkNotNull(localObject1);
      s.s(localObject1, "data!!.getParcelableExtr…geUI.KSEGMENTMEDIAINFO)!!");
      CaptureDataManager.CaptureVideoNormalModel localCaptureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel)localObject1;
      localObject1 = new Intent();
      Object localObject2 = paramIntent.getBundleExtra("key_extra_data");
      s.checkNotNull(localObject2);
      localObject2 = ((Bundle)localObject2).getByteArray("video_composition");
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("video_composition", (byte[])localObject2);
      }
      ((Intent)localObject1).putExtra("postType", 4);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)p.al(new String[] { localCaptureVideoNormalModel.videoPath }));
      ((Intent)localObject1).putExtra("postTypeList", (Serializable)p.al(new Integer[] { Integer.valueOf(4) }));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)p.al(new String[] { localCaptureVideoNormalModel.thumbPath }));
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)localCaptureVideoNormalModel.gHE().J("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      ((Intent)localObject1).putExtra("KEY_POST_DIRECTLY_FROM_SNS", true);
      ((Intent)localObject1).putExtra("KEY_POST_HALF_RECT_LIST", (Serializable)paramIntent.getParcelableArrayListExtra("KEY_POST_HALF_RECT_LIST"));
      paramIntent = v.FrN;
      v.aP(5, false);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramIntent = getIntent();
      s.s(paramIntent, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b((Intent)localObject1, paramIntent);
      ((Intent)localObject1).putExtra("key_context_id", getIntent().getStringExtra("key_context_id"));
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, (Intent)localObject1);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167499);
    super.onCreate(paramBundle);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    this.Bqi = getIntent().getIntExtra("key_finder_post_router", -1);
    Object localObject1 = getIntent().getStringExtra("key_finder_context_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.FST = paramBundle;
    localObject1 = getIntent().getStringExtra("key_finder_session_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.sessionId = paramBundle;
    localObject1 = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      paramBundle = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      paramBundle = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    }
    this.postId = paramBundle;
    this.FSW = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
    this.FSU = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH");
    this.FSV = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME");
    this.FSX = getIntent().getByteArrayExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO");
    this.FSY = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_BGM_URL");
    this.FSZ = getIntent().getBooleanExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", false);
    paramBundle = v.FrN;
    v.azP(this.postId);
    Log.i("Finder.FinderPostRouterUI", s.X("router ", Integer.valueOf(this.Bqi)));
    switch (this.Bqi)
    {
    case 8: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      Log.i("Finder.FinderPostRouterUI", "invalid router " + this.Bqi + ", finish");
      finish();
      AppMethodBeat.o(167499);
      return;
    case 1: 
      paramBundle = new Intent();
      paramBundle.putExtra("finder_username", z.bAW());
      paramBundle.addFlags(67108864);
      paramBundle.putExtra("KEY_FINDER_SELF_FLAG", true);
      localObject1 = as.GSQ;
      as.a.a((Context)this, paramBundle, 0L, 0, false, 124);
      com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)this, paramBundle);
      finish();
      AppMethodBeat.o(167499);
      return;
    case 3: 
      paramBundle = new Intent();
      paramBundle.putExtra("key_finder_context_id", this.FST);
      paramBundle.putExtra("key_finder_session_id", this.sessionId);
      paramBundle.putExtra("key_finder_post_id", this.postId);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.FSW);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.FSU);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.FSV);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.FSX);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.FSY);
      paramBundle.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.FSZ);
      paramBundle.putExtra("key_maas_entrance", getIntent().getIntExtra("key_maas_entrance", 0));
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = getIntent();
      s.s(localObject1, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramBundle, (Intent)localObject1);
      localObject1 = as.GSQ;
      as.a.a((Context)this, paramBundle, 0L, 0, false, 124);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ac((Context)this, paramBundle);
      paramBundle = v.FrN;
      v.Sz(1);
      AppMethodBeat.o(167499);
      return;
    case 2: 
      this.FSS = true;
      paramBundle = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramBundle = v.FrN;
      paramBundle = v.eMS();
      if (paramBundle == null) {
        paramBundle = "";
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
        com.tencent.mm.plugin.finder.report.postreport.a.a(paramBundle, com.tencent.mm.plugin.finder.report.postreport.b.eOf());
        bpM();
        paramBundle = v.FrN;
        v.Sz(2);
        AppMethodBeat.o(167499);
        return;
        localObject1 = paramBundle.flowId;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
      }
    case 17: 
      this.FSS = true;
      paramBundle = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
      paramBundle = v.FrN;
      paramBundle = v.eMS();
      if (paramBundle == null) {
        paramBundle = "";
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
        com.tencent.mm.plugin.finder.report.postreport.a.a(paramBundle, com.tencent.mm.plugin.finder.report.postreport.b.eOf());
        bpM();
        paramBundle = v.FrN;
        v.Sz(2);
        AppMethodBeat.o(167499);
        return;
        localObject1 = paramBundle.flowId;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
      }
    case 4: 
      paramBundle = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.X((Context)this, getIntent());
      AppMethodBeat.o(167499);
      return;
    case 5: 
      finish();
      AppMethodBeat.o(167499);
      return;
    case 6: 
      switch (getIntent().getIntExtra("key_finder_sns_post_type", 0))
      {
      default: 
        finish();
        AppMethodBeat.o(167499);
        return;
      case 1: 
        paramBundle = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramBundle = (Context)this;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_from_comment_scene", 41);
        localObject2 = ah.aiuX;
        com.tencent.mm.plugin.finder.utils.a.as(paramBundle, (Intent)localObject1);
        overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
        AppMethodBeat.o(167499);
        return;
      case 2: 
        localObject2 = GalleryItem.MediaItem.a(2, 0L, getIntent().getStringExtra("key_finder_post_sns_video_path"), "", "");
        int i = getIntent().getIntExtra("key_finder_post_sns_video_duration_ms", 0);
        paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eUN().bmg()).intValue() == 1)
        {
          l = i;
          paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
          if ((l >= (com.tencent.mm.plugin.finder.storage.d.eRl() + 1) * 1000L) && (i < ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgA() * 1000L))
          {
            paramBundle = new Intent();
            paramBundle.putExtra("post_id", this.postId);
            paramBundle.putExtra("postType", 4);
            paramBundle.putExtra("postMediaList", (Serializable)p.al(new String[] { ((GalleryItem.MediaItem)localObject2).Gcc }));
            paramBundle.putExtra("postTypeList", (Serializable)p.al(new Integer[] { Integer.valueOf(4) }));
            paramBundle.putExtra("isLongVideoPost", true);
            paramBundle.putExtra("KEY_POST_DIRECTLY_FROM_SNS", true);
            localObject1 = v.FrN;
            v.aP(5, false);
            localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
            localObject1 = getIntent();
            s.s(localObject1, "getIntent()");
            com.tencent.mm.plugin.finder.utils.a.b(paramBundle, (Intent)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, paramBundle);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(20694, new Object[] { Integer.valueOf(2) });
          AppMethodBeat.o(167499);
          return;
          paramBundle = com.tencent.mm.plugin.finder.ui.edit.a.FXw;
          paramBundle = com.tencent.mm.plugin.finder.ui.edit.a.fcN();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putParcelableArrayList("media_list", p.al(new GalleryItem.MediaItem[] { localObject2 }));
          localObject2 = com.tencent.mm.ui.aw.bf((Context)this);
          Object localObject3 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
          localObject3 = getBaseContext();
          s.s(localObject3, "baseContext");
          localObject2 = com.tencent.mm.plugin.finder.utils.aw.i((Context)localObject3, ((Point)localObject2).x, ((Point)localObject2).y);
          localObject2 = new Point(((Number)((u)localObject2).bsD).intValue(), ((Number)((u)localObject2).aiuN).intValue());
          ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", ((Point)localObject2).x);
          ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", ((Point)localObject2).y);
          localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
          ((Bundle)localObject1).putLong("video_max_duration", com.tencent.mm.plugin.finder.storage.d.eRl() * 1000L);
          localObject2 = bm.GlZ;
          ((Bundle)localObject1).putString("output_dir", bm.fit());
          paramBundle.oSS = ((Bundle)localObject1);
          localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
          com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, l.a.slide_right_in, l.a.slide_right_out, paramBundle, 4, 0);
        }
      }
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.eRl();
      paramBundle = getIntent().getStringExtra("key_finder_post_sns_video_path");
      localObject1 = g.HRf;
      localObject1 = g.aBH(paramBundle);
      localObject2 = getContext();
      s.s(localObject2, "context");
      a.a((Context)localObject2, getIntent(), paramBundle, ((com.tencent.mm.plugin.sight.base.b)localObject1).width, ((com.tencent.mm.plugin.sight.base.b)localObject1).height, this.postId, false);
      AppMethodBeat.o(167499);
      return;
    case 7: 
      getIntent().addFlags(536870912);
      getIntent().addFlags(67108864);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      paramBundle.A((Context)localObject1, getIntent());
      AppMethodBeat.o(167499);
      return;
    case 9: 
      getIntent().addFlags(536870912);
      getIntent().addFlags(67108864);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramBundle = MMApplicationContext.getContext();
      s.s(paramBundle, "getContext()");
      com.tencent.mm.plugin.finder.utils.a.aq(paramBundle, getIntent());
      AppMethodBeat.o(167499);
      return;
    case 10: 
      paramBundle = new Intent();
      paramBundle.putExtra("key_finder_post_id", this.postId);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.FSW);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.FSU);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.FSV);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.FSX);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.FSY);
      paramBundle.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.FSZ);
      paramBundle.putExtra("KEY_FINDER_POST_FORM_FLUTTER", true);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = getIntent();
      s.s(localObject1, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramBundle, (Intent)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ac((Context)this, paramBundle);
      paramBundle = v.FrN;
      v.Sz(1);
      AppMethodBeat.o(167499);
      return;
    case 14: 
      getIntent().putExtra("key_finder_context_id", this.FST);
      getIntent().putExtra("key_finder_session_id", this.sessionId);
      getIntent().putExtra("key_finder_post_id", this.postId);
      getIntent().putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.FSW);
      getIntent().putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.FSU);
      getIntent().putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.FSV);
      getIntent().putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.FSX);
      getIntent().putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.FSY);
      getIntent().putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.FSZ);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ay((Context)this, getIntent());
      AppMethodBeat.o(167499);
      return;
    }
    long l = getIntent().getLongExtra("key_topic_id", 0L);
    paramBundle = getIntent();
    localObject1 = (com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class);
    Object localObject2 = (Context)this;
    s.s(paramBundle, "localIntent");
    ((com.tencent.mm.mj_template.api.d)localObject1).launchTemplateSquare((Context)localObject2, l, paramBundle, (com.tencent.mm.mj_template.api.b)new b(paramBundle, this));
    Log.i("Finder.FinderPostRouterUI", "start mj flutter page");
    AppMethodBeat.o(167499);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347419);
    CaptureDataManager.NHH.NHG = null;
    super.onDestroy();
    AppMethodBeat.o(347419);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    int j = -1;
    AppMethodBeat.i(347405);
    super.onNewIntent(paramIntent);
    if (paramIntent == null)
    {
      i = -1;
      this.Bqi = i;
      if (paramIntent != null) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = paramIntent.getIntExtra("key_finder_post_from", -1))
    {
      this.FTb = i;
      AppMethodBeat.o(347405);
      return;
      i = paramIntent.getIntExtra("key_finder_post_router", -1);
      break;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(167506);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(167506);
      return;
    }
    Log.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    label199:
    label330:
    for (;;)
    {
      AppMethodBeat.o(167506);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label199;
        }
      }
      for (paramInt = j;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label204;
        }
        bpM();
        AppMethodBeat.o(167506);
        return;
        paramInt = 0;
        break;
      }
      label204:
      k.a((Context)getContext(), com.tencent.mm.cd.a.bt((Context)getContext(), l.i.permission_camera_request_again_msg), com.tencent.mm.cd.a.bt((Context)getContext(), l.i.permission_tips_title), com.tencent.mm.cd.a.bt((Context)getContext(), l.i.jump_to_settings), com.tencent.mm.cd.a.bt((Context)getContext(), l.i.permission_cancel), false, new FinderPostRouterUI..ExternalSyntheticLambda0(this), new FinderPostRouterUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(167506);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label327;
        }
      }
      for (paramInt = k;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label330;
        }
        bpM();
        break;
        paramInt = 0;
        break label298;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167500);
    super.onResume();
    Log.i("Finder.FinderPostRouterUI", "onResume");
    this.FTa = getIntent().getBooleanExtra("KEY_FINDER_POST_FROM_ADD_MEDIA", false);
    if (this.FSR)
    {
      if (this.Bqi == 13)
      {
        Object localObject;
        if (this.FTb == 1)
        {
          localObject = FinderProfileTabUIC.Ffv;
          FinderProfileTabUIC.eKu();
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(167500);
          return;
          localObject = new Intent();
          ((Intent)localObject).putExtra("finder_username", z.bAW());
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).putExtra("KEY_FINDER_SELF_FLAG", true);
          ((Intent)localObject).putExtra("key_enter_profile_tab", 4);
          as.a locala = as.GSQ;
          as.a.a((Context)this, (Intent)localObject, 0L, 0, false, 124);
          com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)this, (Intent)localObject);
        }
      }
      finish();
      if (this.FSS) {
        overridePendingTransition(0, l.a.sight_slide_bottom_out);
      }
      if (this.Bqi == 6) {
        overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
      }
      if (this.Bqi == 16) {
        overridePendingTransition(0, l.a.slide_right_out);
      }
    }
    AppMethodBeat.o(167500);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(167501);
    super.onStop();
    Log.i("Finder.FinderPostRouterUI", "onStop");
    this.FSR = true;
    AppMethodBeat.o(167501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI$Companion;", "", "()V", "REQUEST_CODE", "", "TAG", "", "jumpToLongVideoPostPage", "", "context", "Landroid/content/Context;", "pendingIntent", "Landroid/content/Intent;", "path", "mediaWidth", "mediaHeight", "postId", "isFromFinderAddMedia", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean a(Context paramContext, Intent paramIntent, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(346991);
      s.u(paramContext, "context");
      float f = paramInt2 / paramInt1;
      if ((f > ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgB()) || (f < ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgC()))
      {
        aa.makeText(paramContext, l.i.gallery_pic_video_special_ratio_desc, 0).show();
        AppMethodBeat.o(346991);
        return false;
      }
      if (!y.ZC(paramString1))
      {
        AppMethodBeat.o(346991);
        return false;
      }
      Intent localIntent = new Intent();
      if ((paramBoolean) && ((paramContext instanceof Activity))) {
        localIntent.putExtras(((Activity)paramContext).getIntent());
      }
      localIntent.putExtra("post_id", paramString2);
      paramString2 = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localIntent.putExtra("edit_id", com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond());
      localIntent.putExtra("postType", 4);
      localIntent.putExtra("postMediaList", (Serializable)p.al(new String[] { paramString1 }));
      localIntent.putExtra("postTypeList", (Serializable)p.al(new Integer[] { Integer.valueOf(4) }));
      localIntent.putExtra("isLongVideoPost", true);
      paramString1 = v.FrN;
      v.aP(5, false);
      if (paramIntent != null)
      {
        paramString1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.b(localIntent, paramIntent);
      }
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, localIntent);
      paramContext = ax.Fur;
      paramContext = v.FrN;
      paramContext = v.eMS();
      if (paramContext == null)
      {
        paramContext = "";
        paramIntent = v.FrN;
        paramIntent = v.eMS();
        if (paramIntent != null) {
          break label356;
        }
        paramIntent = "";
      }
      for (;;)
      {
        ax.a(paramContext, paramIntent, 2, com.tencent.mm.model.cn.bDw() / 1000L, 2);
        AppMethodBeat.o(346991);
        return true;
        paramIntent = paramContext.clickId;
        paramContext = paramIntent;
        if (paramIntent != null) {
          break;
        }
        paramContext = "";
        break;
        label356:
        paramString1 = paramIntent.postId;
        paramIntent = paramString1;
        if (paramString1 == null) {
          paramIntent = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderPostRouterUI$goRouter$2", "Lcom/tencent/mm/mj_template/api/IFinderModuleApi;", "startPost", "", "context", "Landroid/app/Activity;", "requestCode", "", "intent", "Landroid/content/Intent;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.mj_template.api.b
  {
    b(Intent paramIntent, FinderPostRouterUI paramFinderPostRouterUI) {}
    
    public final void c(Activity paramActivity, Intent paramIntent)
    {
      AppMethodBeat.i(346968);
      s.u(paramActivity, "context");
      s.u(paramIntent, "intent");
      Log.i("Finder.FinderPostRouterUI", "start template post, enter album");
      paramIntent.putExtras(this.FTc);
      paramIntent.putExtra("key_finder_post_from", 5);
      paramIntent.putExtra("key_finder_context_id", FinderPostRouterUI.a(jdField_this));
      paramIntent.putExtra("key_finder_session_id", FinderPostRouterUI.b(jdField_this));
      paramIntent.putExtra("key_finder_post_id", FinderPostRouterUI.c(jdField_this));
      paramIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", FinderPostRouterUI.d(jdField_this));
      paramIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", FinderPostRouterUI.e(jdField_this));
      paramIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", FinderPostRouterUI.f(jdField_this));
      paramIntent.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", FinderPostRouterUI.g(jdField_this));
      paramIntent.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", FinderPostRouterUI.h(jdField_this));
      paramIntent.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", FinderPostRouterUI.i(jdField_this));
      i.FhR.c(paramActivity, paramIntent, 1);
      AppMethodBeat.o(346968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostRouterUI
 * JD-Core Version:    0.7.0.1
 */