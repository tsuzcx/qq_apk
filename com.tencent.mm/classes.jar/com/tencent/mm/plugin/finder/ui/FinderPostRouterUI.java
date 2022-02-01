package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.plugin.finder.video.develop.DevFinderRecordPluginLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.plugin.vlog.ui.plugin.f;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.r;

@com.tencent.mm.ui.base.a(7)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "bgmIfOrigin", "", "fromAddMedia", "fromRecordUI", "hasStopped", "originBgmUrl", "", "originMusicId", "originMusicInfo", "", "originMusicName", "originMusicPath", "postId", "router", "", "getLayoutId", "goRouter", "", "gotoMediaEdit", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "context", "Landroid/content/Context;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "takePhoto", "Companion", "plugin-finder_release"})
public final class FinderPostRouterUI
  extends MMFinderUI
  implements CaptureDataManager.b
{
  public static final a vNc;
  private HashMap _$_findViewCache;
  private String postId = "";
  private int ubR = -1;
  private boolean vMT;
  private boolean vMU;
  private String vMV;
  private String vMW;
  private String vMX;
  private byte[] vMY;
  private String vMZ;
  private boolean vNa;
  private boolean vNb;
  
  static
  {
    AppMethodBeat.i(252597);
    vNc = new a((byte)0);
    AppMethodBeat.o(252597);
  }
  
  private void aML()
  {
    AppMethodBeat.i(167502);
    Object localObject1 = c.vCb;
    localObject1 = c.dqw();
    Object localObject2 = f.GHk;
    if (f.fDl()) {
      ((VideoTransPara)localObject1).height = ((int)(((VideoTransPara)localObject1).width / 0.75F));
    }
    Log.i("Finder.FinderPostRouterUI", "videoParams ".concat(String.valueOf(localObject1)));
    localObject2 = al.waC;
    localObject2 = RecordConfigProvider.a(al.dEC(), "", (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 11);
    ((RecordConfigProvider)localObject2).BOu = Boolean.FALSE;
    ((RecordConfigProvider)localObject2).BOJ.BOM = ((b)g.af(b.class)).a(b.a.slw, true);
    ((RecordConfigProvider)localObject2).BOJ.hDb = ((b)g.af(b.class)).a(b.a.slx, -1);
    ((RecordConfigProvider)localObject2).BOJ.hDc = ((b)g.af(b.class)).a(b.a.sly, -1);
    ((RecordConfigProvider)localObject2).BOJ.hDd = ((b)g.af(b.class)).a(b.a.slz, -1);
    ((RecordConfigProvider)localObject2).BOJ.hDe = ((b)g.af(b.class)).a(b.a.slA, -1);
    ((RecordConfigProvider)localObject2).BOJ.hDf = ((b)g.af(b.class)).a(b.a.slB, -1);
    localObject1 = new UICustomParam.a();
    Object localObject3 = f.GHk;
    if (f.fDl())
    {
      ((UICustomParam.a)localObject1).ai(0.75F);
      ((UICustomParam.a)localObject1).apE();
      ((UICustomParam.a)localObject1).apD();
      ((UICustomParam.a)localObject1).apC();
      ((UICustomParam.a)localObject1).dz(false);
      ((UICustomParam.a)localObject1).apF();
      localObject3 = getContext();
      p.g(localObject3, "context");
      ((UICustomParam.a)localObject1).oG(((AppCompatActivity)localObject3).getResources().getColor(2131100919));
      ((UICustomParam.a)localObject1).a(2131231432, 0, "", 0);
      ((RecordConfigProvider)localObject2).BOn = ((UICustomParam.a)localObject1).apG();
      ((RecordConfigProvider)localObject2).BOo = i.e.Kcb;
      ((RecordConfigProvider)localObject2).jkf = new Bundle();
      ((RecordConfigProvider)localObject2).jkf.putString("post_id", this.postId);
      ((RecordConfigProvider)localObject2).jkf.putString("KEY_ORIGIN_MUSIC_ID", this.vMX);
      ((RecordConfigProvider)localObject2).jkf.putString("KEY_ORIGIN_MUSIC_PATH", this.vMV);
      ((RecordConfigProvider)localObject2).jkf.putString("KEY_ORIGIN_MUSIC_NAME", this.vMW);
      ((RecordConfigProvider)localObject2).jkf.putByteArray("KEY_ORIGIN_MUSIC_INFO", this.vMY);
      ((RecordConfigProvider)localObject2).jkf.putString("KEY_ORIGIN_BGM_URL", this.vMZ);
      ((RecordConfigProvider)localObject2).jkf.putBoolean("KEY_BGM_IF_ORIGIN", this.vNa);
      localObject1 = y.vXH;
      if (!y.isAnyEnableFullScreenEnjoy()) {
        break label588;
      }
      localObject1 = MultiVideoFullScreenPluginLayout.class.getName();
      label460:
      p.g(localObject1, "if (FinderUtil.isAnyEnab…inLayout::class.java.name");
      ((RecordConfigProvider)localObject2).F(4, (String)localObject1);
      ((RecordConfigProvider)localObject2).F(1, (String)localObject1);
      ((RecordConfigProvider)localObject2).F(3, (String)localObject1);
      ((RecordConfigProvider)localObject2).F(0, FinderRecordPluginLayout.class.getName());
      localObject1 = g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      if (((e)localObject1).azQ().getInt(ar.a.Omu, 0) != 1) {
        break label598;
      }
    }
    label588:
    label598:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((RecordConfigProvider)localObject2).F(0, DevFinderRecordPluginLayout.class.getName());
      }
      CaptureDataManager.BOb.a((CaptureDataManager.b)this);
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, 2130772161, 2130772162, (RecordConfigProvider)localObject2);
      AppMethodBeat.o(167502);
      return;
      ((UICustomParam.a)localObject1).ai(0.8571429F);
      break;
      localObject1 = MultiVideoPluginLayout.class.getName();
      break label460;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252599);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252599);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252598);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(252598);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(167503);
    p.h(paramContext, "context");
    p.h(paramCaptureVideoNormalModel, "model");
    p.h(paramBundle, "extData");
    Log.i("Finder.FinderPostRouterUI", "onMediaGenerated");
    this.vMU = false;
    Object localObject1 = new cly();
    ((cly)localObject1).Mrn = true;
    ((cly)localObject1).Mrm = false;
    localObject1 = new Intent();
    ArrayList localArrayList = (ArrayList)paramCaptureVideoNormalModel.eJJ().y("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
    Object localObject2 = paramBundle.getByteArray("MEDIA_EXTRA_MUSIC");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("MEDIA_EXTRA_MUSIC", (byte[])localObject2);
    }
    localObject2 = paramBundle.getByteArray("ORIGIN_MUSIC_INFO");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("ORIGIN_MUSIC_INFO", (byte[])localObject2);
    }
    com.tencent.mm.ac.d.a((Intent)localObject1, paramBundle, "ORIGIN_MUSIC_ID");
    com.tencent.mm.ac.d.a((Intent)localObject1, paramBundle, "ORIGIN_MUSIC_PATH");
    com.tencent.mm.ac.d.a((Intent)localObject1, paramBundle, "ORIGIN_BGM_URL");
    com.tencent.mm.ac.d.b((Intent)localObject1, paramBundle, "MEDIA_IS_MUTE");
    com.tencent.mm.ac.d.b((Intent)localObject1, paramBundle, "MUSIC_IS_MUTE");
    com.tencent.mm.ac.d.c((Intent)localObject1, paramBundle, "SOUND_TRACK_TYPE");
    localObject2 = paramBundle.getParcelableArrayList("KEY_POST_HALF_RECT_LIST");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("KEY_POST_HALF_RECT_LIST", (Serializable)localObject2);
    }
    localObject2 = (Collection)paramCaptureVideoNormalModel.eJK();
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)new ArrayList((Collection)paramCaptureVideoNormalModel.eJK()));
      localObject2 = paramCaptureVideoNormalModel.eJK();
      p.g(localObject2, "model.multiImagePath");
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
      if ((localArrayList != null) && (localArrayList.size() == paramCaptureVideoNormalModel.eJK().size())) {
        ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
      com.tencent.mm.ac.d.d((Intent)localObject1, paramBundle, "KEY_POST_HALF_IMAGE_LIST");
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("KEY_POST_FROM_CAMERA", true);
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)paramCaptureVideoNormalModel.eJJ().y("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramBundle = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramBundle = getIntent();
      p.g(paramBundle, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b((Intent)localObject1, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, (Intent)localObject1);
      paramContext = i.vfo;
      paramContext = paramCaptureVideoNormalModel.eJJ();
      p.g(paramContext, "model.reportInfo");
      i.a(paramContext);
      AppMethodBeat.o(167503);
      return;
      localObject2 = paramCaptureVideoNormalModel.eJI();
      p.g(localObject2, "model.photo");
      if (!((Boolean)localObject2).booleanValue()) {
        break;
      }
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.aQn());
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
    }
    if (paramBundle.getByteArray("video_composition") != null)
    {
      ((Intent)localObject1).putExtra("video_composition", paramBundle.getByteArray("video_composition"));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.ac(new String[] { paramCaptureVideoNormalModel.aQn() }));
    }
    for (;;)
    {
      p.g(((Intent)localObject1).putExtra("postType", 4), "postIntent.putExtra(Cons…iaType.FINDER_DATA_VIDEO)");
      break;
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.getVideoPath());
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
    }
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(252595);
    p.h(paramRecordMediaReportInfo, "reportInfo");
    p.h(paramBundle, "extData");
    paramBundle = i.vfo;
    i.b(paramRecordMediaReportInfo);
    AppMethodBeat.o(252595);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(167504);
    p.h(paramContext, "context");
    p.h(paramBundle, "extData");
    p.h(parama, "finishController");
    AppMethodBeat.o(167504);
    return false;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252596);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(252596);
      return;
      if (paramInt2 == 0)
      {
        Log.i("Finder.FinderPostRouterUI", "record cancel");
        if (paramIntent != null)
        {
          paramIntent = (RecordMediaReportInfo)paramIntent.getParcelableExtra("report");
          if (paramIntent != null)
          {
            localObject = i.vfo;
            i.a(paramIntent);
          }
        }
        paramIntent = i.vfo;
        i.Ks(1);
      }
      finish();
      AppMethodBeat.o(252596);
      return;
      if (paramInt2 != -1)
      {
        finish();
        overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
        AppMethodBeat.o(252596);
        return;
      }
      if (paramIntent == null) {
        p.hyc();
      }
      Object localObject = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      p.g(localObject, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      CaptureDataManager.CaptureVideoNormalModel localCaptureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel)localObject;
      localObject = new Intent();
      paramIntent = paramIntent.getBundleExtra("key_extra_data").getByteArray("video_composition");
      if (paramIntent != null) {
        ((Intent)localObject).putExtra("video_composition", paramIntent);
      }
      ((Intent)localObject).putExtra("postType", 4);
      ((Intent)localObject).putExtra("postMediaList", (Serializable)j.ac(new String[] { localCaptureVideoNormalModel.getVideoPath() }));
      ((Intent)localObject).putExtra("postTypeList", (Serializable)j.ac(new Integer[] { Integer.valueOf(4) }));
      ((Intent)localObject).putExtra("postThumbList", (Serializable)j.ac(new String[] { localCaptureVideoNormalModel.aQn() }));
      ((Intent)localObject).putExtra("post_id", this.postId);
      ((Intent)localObject).putExtra("edit_id", (String)localCaptureVideoNormalModel.eJJ().y("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      ((Intent)localObject).putExtra("KEY_POST_DIRECTLY_FROM_SNS", true);
      paramIntent = i.vfo;
      i.as(5, false);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramIntent = getIntent();
      p.g(paramIntent, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b((Intent)localObject, paramIntent);
      ((Intent)localObject).putExtra("key_context_id", getIntent().getStringExtra("key_context_id"));
      paramIntent = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, (Intent)localObject);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167499);
    super.onCreate(paramBundle);
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    this.ubR = getIntent().getIntExtra("key_finder_post_router", -1);
    Object localObject1 = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      paramBundle = new StringBuilder();
      p.g(g.aAf(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.a.ayV() + '_' + Util.nowMilliSecond();
    }
    this.postId = paramBundle;
    this.vMX = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
    this.vMV = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH");
    this.vMW = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME");
    this.vMY = getIntent().getByteArrayExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO");
    this.vMZ = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_BGM_URL");
    this.vNa = getIntent().getBooleanExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", false);
    paramBundle = i.vfo;
    i.auH(this.postId);
    Log.i("Finder.FinderPostRouterUI", "router " + this.ubR);
    switch (this.ubR)
    {
    case 8: 
    default: 
      Log.i("Finder.FinderPostRouterUI", "invalid router " + this.ubR + ", finish");
      finish();
      AppMethodBeat.o(167499);
      return;
    case 1: 
      paramBundle = new Intent();
      paramBundle.putExtra("finder_username", z.aUg());
      paramBundle.addFlags(67108864);
      localObject1 = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this, paramBundle, 0L, 0, false, 124);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramBundle);
      finish();
      AppMethodBeat.o(167499);
      return;
    case 3: 
      paramBundle = new Intent();
      paramBundle.putExtra("key_finder_post_id", this.postId);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.vMX);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.vMV);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.vMW);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.vMY);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.vMZ);
      paramBundle.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.vNa);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject1 = getIntent();
      p.g(localObject1, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramBundle, (Intent)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.J((Context)this, paramBundle);
      paramBundle = i.vfo;
      i.Kr(1);
      AppMethodBeat.o(167499);
      return;
    case 2: 
      this.vMU = true;
      aML();
      paramBundle = i.vfo;
      i.Kr(2);
      AppMethodBeat.o(167499);
      return;
    case 4: 
      paramBundle = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.E((Context)this, getIntent());
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
        paramBundle = com.tencent.mm.plugin.finder.utils.a.vUU;
        paramBundle = (Context)this;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_comment_scene", 41);
        com.tencent.mm.plugin.finder.utils.a.ad(paramBundle, (Intent)localObject1);
        overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
        AppMethodBeat.o(167499);
        return;
      }
      paramBundle = new UICustomParam.a();
      paramBundle.apE();
      paramBundle.apD();
      paramBundle.dz(false);
      paramBundle.apF();
      localObject1 = RecordConfigProvider.jB("", "");
      ((RecordConfigProvider)localObject1).scene = 11;
      ((RecordConfigProvider)localObject1).BOn = paramBundle.apG();
      paramBundle = c.vCb;
      ((RecordConfigProvider)localObject1).BOm = c.dqx();
      ((RecordConfigProvider)localObject1).BOp = 3;
      ((RecordConfigProvider)localObject1).BOv = (((RecordConfigProvider)localObject1).BOm.duration * 1000);
      paramBundle = new Bundle();
      paramBundle.putParcelableArrayList("media_list", j.ac(new GalleryItem.MediaItem[] { GalleryItem.MediaItem.a(2, 0L, getIntent().getStringExtra("key_finder_post_sns_video_path"), "", "") }));
      Object localObject2 = com.tencent.mm.ui.ao.az((Context)this);
      Object localObject3 = y.vXH;
      localObject3 = getBaseContext();
      p.g(localObject3, "baseContext");
      localObject2 = y.g((Context)localObject3, ((Point)localObject2).x, ((Point)localObject2).y);
      localObject2 = new Point(((Number)((r)localObject2).second).intValue(), ((Number)((r)localObject2).SWY).intValue());
      paramBundle.putInt("KEY_PREVIEW_WIDTH", ((Point)localObject2).x);
      paramBundle.putInt("KEY_PREVIEW_HEIGHT", ((Point)localObject2).y);
      localObject2 = c.vCb;
      paramBundle.putLong("video_max_duration", c.drG() * 1000L);
      localObject2 = al.waC;
      paramBundle.putString("output_dir", al.dEG());
      ((RecordConfigProvider)localObject1).jkf = paramBundle;
      paramBundle = y.vXH;
      if (y.isAnyEnableFullScreenEnjoy()) {}
      for (paramBundle = MultiVideoFullScreenPluginLayout.class.getName();; paramBundle = MultiVideoPluginLayout.class.getName())
      {
        p.g(paramBundle, "if (FinderUtil.isAnyEnab…inLayout::class.java.name");
        ((RecordConfigProvider)localObject1).F(3, paramBundle);
        ((RecordConfigProvider)localObject1).F(4, paramBundle);
        paramBundle = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, 2130772169, 2130772170, (RecordConfigProvider)localObject1, 4, 0);
        com.tencent.mm.plugin.report.service.h.CyF.a(20694, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(167499);
        return;
      }
    case 7: 
      getIntent().addFlags(536870912);
      getIntent().addFlags(67108864);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramBundle = MMApplicationContext.getContext();
      p.g(paramBundle, "MMApplicationContext.getContext()");
      com.tencent.mm.plugin.finder.utils.a.O(paramBundle, getIntent());
      AppMethodBeat.o(167499);
      return;
    case 9: 
      getIntent().addFlags(536870912);
      getIntent().addFlags(67108864);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramBundle = MMApplicationContext.getContext();
      p.g(paramBundle, "MMApplicationContext.getContext()");
      com.tencent.mm.plugin.finder.utils.a.aa(paramBundle, getIntent());
      AppMethodBeat.o(167499);
      return;
    }
    paramBundle = new Intent();
    paramBundle.putExtra("key_finder_post_id", this.postId);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.vMX);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.vMV);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.vMW);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.vMY);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.vMZ);
    paramBundle.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.vNa);
    paramBundle.putExtra("KEY_FINDER_POST_FORM_FLUTTER", true);
    localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
    localObject1 = getIntent();
    p.g(localObject1, "getIntent()");
    com.tencent.mm.plugin.finder.utils.a.b(paramBundle, (Intent)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.J((Context)this, paramBundle);
    paramBundle = i.vfo;
    i.Kr(1);
    AppMethodBeat.o(167499);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252594);
    CaptureDataManager.BOb.a(null);
    super.onDestroy();
    AppMethodBeat.o(252594);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(167506);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfString = Thread.currentThread();
      p.g(paramArrayOfString, "Thread.currentThread()");
      Log.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(167506);
      return;
    }
    i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    p.g(paramArrayOfString, "Thread.currentThread()");
    Log.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(paramArrayOfString.getId()) });
    switch (paramInt)
    {
    }
    label219:
    label224:
    label353:
    label356:
    for (;;)
    {
      AppMethodBeat.o(167506);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label219;
        }
      }
      for (paramInt = j;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label224;
        }
        aML();
        AppMethodBeat.o(167506);
        return;
        paramInt = 0;
        break;
      }
      com.tencent.mm.ui.base.h.a((Context)getContext(), com.tencent.mm.cb.a.aI((Context)getContext(), 2131763864), com.tencent.mm.cb.a.aI((Context)getContext(), 2131763890), com.tencent.mm.cb.a.aI((Context)getContext(), 2131762043), com.tencent.mm.cb.a.aI((Context)getContext(), 2131763865), false, (DialogInterface.OnClickListener)new FinderPostRouterUI.b(this), (DialogInterface.OnClickListener)new FinderPostRouterUI.c(this));
      AppMethodBeat.o(167506);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label353;
        }
      }
      for (paramInt = k;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label356;
        }
        aML();
        break;
        paramInt = 0;
        break label324;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167500);
    super.onResume();
    Log.i("Finder.FinderPostRouterUI", "onResume");
    this.vNb = getIntent().getBooleanExtra("KEY_FINDER_POST_FROM_ADD_MEDIA", false);
    if (this.vMT)
    {
      finish();
      if (this.vMU) {
        overridePendingTransition(0, 2130772162);
      }
      if (this.ubR == 6) {
        overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
      }
    }
    AppMethodBeat.o(167500);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(167501);
    super.onStop();
    Log.i("Finder.FinderPostRouterUI", "onStop");
    this.vMT = true;
    AppMethodBeat.o(167501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI$Companion;", "", "()V", "REQUEST_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostRouterUI
 * JD-Core Version:    0.7.0.1
 */