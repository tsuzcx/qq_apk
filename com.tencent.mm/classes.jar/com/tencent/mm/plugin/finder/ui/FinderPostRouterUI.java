package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ar;
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
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "bgmIfOrigin", "", "finderContextId", "", "fromAddMedia", "fromRecordUI", "hasStopped", "originBgmUrl", "originMusicId", "originMusicInfo", "", "originMusicName", "originMusicPath", "postId", "router", "", "sessionId", "getLayoutId", "goRouter", "", "gotoMediaEdit", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "context", "Landroid/content/Context;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "takePhoto", "Companion", "plugin-finder_release"})
public final class FinderPostRouterUI
  extends MMFinderUI
  implements CaptureDataManager.b
{
  public static final a AtU;
  private boolean AtK;
  private boolean AtL;
  private String AtM = "";
  private String AtN;
  private String AtO;
  private String AtP;
  private byte[] AtQ;
  private String AtR;
  private boolean AtS;
  private boolean AtT;
  private HashMap _$_findViewCache;
  private String postId = "";
  private String sessionId = "";
  private int xQJ = -1;
  
  static
  {
    AppMethodBeat.i(267001);
    AtU = new a((byte)0);
    AppMethodBeat.o(267001);
  }
  
  private void aVe()
  {
    AppMethodBeat.i(167502);
    Object localObject = com.tencent.mm.plugin.finder.ui.edit.a.Aya;
    localObject = com.tencent.mm.plugin.finder.ui.edit.a.ebH();
    ((RecordConfigProvider)localObject).mab = new Bundle();
    ((RecordConfigProvider)localObject).mab.putString("FINDER_CONTEXT_ID", this.AtM);
    ((RecordConfigProvider)localObject).mab.putString("FINDER_SESSION_ID", this.sessionId);
    ((RecordConfigProvider)localObject).mab.putString("post_id", this.postId);
    ((RecordConfigProvider)localObject).mab.putString("KEY_ORIGIN_MUSIC_ID", this.AtP);
    ((RecordConfigProvider)localObject).mab.putString("KEY_ORIGIN_MUSIC_PATH", this.AtN);
    ((RecordConfigProvider)localObject).mab.putString("KEY_ORIGIN_MUSIC_NAME", this.AtO);
    ((RecordConfigProvider)localObject).mab.putByteArray("KEY_ORIGIN_MUSIC_INFO", this.AtQ);
    ((RecordConfigProvider)localObject).mab.putString("KEY_ORIGIN_BGM_URL", this.AtR);
    ((RecordConfigProvider)localObject).mab.putBoolean("KEY_BGM_IF_ORIGIN", this.AtS);
    CaptureDataManager.HKJ.a((CaptureDataManager.b)this);
    com.tencent.mm.plugin.recordvideo.jumper.a locala = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, b.a.sight_slide_bottom_in, b.a.sight_slide_bottom_out, (RecordConfigProvider)localObject);
    AppMethodBeat.o(167502);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(267003);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(267003);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(267002);
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
    AppMethodBeat.o(267002);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(167503);
    p.k(paramContext, "context");
    p.k(paramCaptureVideoNormalModel, "model");
    p.k(paramBundle, "extData");
    Log.i("Finder.FinderPostRouterUI", "onMediaGenerated");
    this.AtL = false;
    Object localObject1 = new cuv();
    ((cuv)localObject1).TCA = true;
    ((cuv)localObject1).TCz = false;
    localObject1 = new Intent();
    ArrayList localArrayList = (ArrayList)paramCaptureVideoNormalModel.fvU().x("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
    Object localObject2 = paramBundle.getByteArray("MEDIA_EXTRA_MUSIC");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("MEDIA_EXTRA_MUSIC", (byte[])localObject2);
    }
    localObject2 = paramBundle.getByteArray("ORIGIN_MUSIC_INFO");
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("ORIGIN_MUSIC_INFO", (byte[])localObject2);
    }
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
    localObject2 = (Collection)paramCaptureVideoNormalModel.fvV();
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)new ArrayList((Collection)paramCaptureVideoNormalModel.fvV()));
      localObject2 = paramCaptureVideoNormalModel.fvV();
      p.j(localObject2, "model.multiImagePath");
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
      if ((localArrayList != null) && (localArrayList.size() == paramCaptureVideoNormalModel.fvV().size())) {
        ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
      com.tencent.mm.ae.d.d((Intent)localObject1, paramBundle, "KEY_POST_HALF_IMAGE_LIST");
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("KEY_POST_FROM_CAMERA", true);
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)paramCaptureVideoNormalModel.fvU().x("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramBundle = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramBundle = getIntent();
      p.j(paramBundle, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b((Intent)localObject1, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, (Intent)localObject1);
      paramContext = k.zWs;
      paramContext = paramCaptureVideoNormalModel.fvU();
      p.j(paramContext, "model.reportInfo");
      k.a(paramContext);
      AppMethodBeat.o(167503);
      return;
      localObject2 = paramCaptureVideoNormalModel.fvT();
      p.j(localObject2, "model.photo");
      if (!((Boolean)localObject2).booleanValue()) {
        break;
      }
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.aZe());
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
    }
    if (paramBundle.getByteArray("video_composition") != null)
    {
      ((Intent)localObject1).putExtra("video_composition", paramBundle.getByteArray("video_composition"));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.ag(new String[] { paramCaptureVideoNormalModel.aZe() }));
    }
    for (;;)
    {
      p.j(((Intent)localObject1).putExtra("postType", 4), "postIntent.putExtra(Cons…iaType.FINDER_DATA_VIDEO)");
      break;
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.getVideoPath());
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
    }
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(266998);
    p.k(paramRecordMediaReportInfo, "reportInfo");
    p.k(paramBundle, "extData");
    paramBundle = k.zWs;
    k.b(paramRecordMediaReportInfo);
    AppMethodBeat.o(266998);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(167504);
    p.k(paramContext, "context");
    p.k(paramBundle, "extData");
    p.k(parama, "finishController");
    AppMethodBeat.o(167504);
    return false;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(267000);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("Finder.FinderPostRouterUI", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(267000);
      return;
      if (paramInt2 == 0)
      {
        Log.i("Finder.FinderPostRouterUI", "record cancel");
        if (paramIntent != null)
        {
          paramIntent = (RecordMediaReportInfo)paramIntent.getParcelableExtra("report");
          if (paramIntent != null)
          {
            localObject = k.zWs;
            k.a(paramIntent);
          }
        }
        paramIntent = k.zWs;
        k.Pw(1);
      }
      finish();
      AppMethodBeat.o(267000);
      return;
      if (paramInt2 != -1)
      {
        finish();
        overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
        AppMethodBeat.o(267000);
        return;
      }
      if (paramIntent == null) {
        p.iCn();
      }
      Object localObject = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      p.j(localObject, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      CaptureDataManager.CaptureVideoNormalModel localCaptureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel)localObject;
      localObject = new Intent();
      byte[] arrayOfByte = paramIntent.getBundleExtra("key_extra_data").getByteArray("video_composition");
      if (arrayOfByte != null) {
        ((Intent)localObject).putExtra("video_composition", arrayOfByte);
      }
      ((Intent)localObject).putExtra("postType", 4);
      ((Intent)localObject).putExtra("postMediaList", (Serializable)j.ag(new String[] { localCaptureVideoNormalModel.getVideoPath() }));
      ((Intent)localObject).putExtra("postTypeList", (Serializable)j.ag(new Integer[] { Integer.valueOf(4) }));
      ((Intent)localObject).putExtra("postThumbList", (Serializable)j.ag(new String[] { localCaptureVideoNormalModel.aZe() }));
      ((Intent)localObject).putExtra("post_id", this.postId);
      ((Intent)localObject).putExtra("edit_id", (String)localCaptureVideoNormalModel.fvU().x("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      ((Intent)localObject).putExtra("KEY_POST_DIRECTLY_FROM_SNS", true);
      ((Intent)localObject).putExtra("KEY_POST_HALF_RECT_LIST", (Serializable)paramIntent.getParcelableArrayListExtra("KEY_POST_HALF_RECT_LIST"));
      paramIntent = k.zWs;
      k.av(5, false);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramIntent = getIntent();
      p.j(paramIntent, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b((Intent)localObject, paramIntent);
      ((Intent)localObject).putExtra("key_context_id", getIntent().getStringExtra("key_context_id"));
      paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, (Intent)localObject);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167499);
    super.onCreate(paramBundle);
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    this.xQJ = getIntent().getIntExtra("key_finder_post_router", -1);
    Object localObject1 = getIntent().getStringExtra("key_finder_context_id");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.AtM = paramBundle;
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
      p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
      paramBundle = b.aGq() + '_' + Util.nowMilliSecond();
    }
    this.postId = paramBundle;
    this.AtP = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
    this.AtN = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH");
    this.AtO = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME");
    this.AtQ = getIntent().getByteArrayExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO");
    this.AtR = getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_BGM_URL");
    this.AtS = getIntent().getBooleanExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", false);
    paramBundle = k.zWs;
    k.aEa(this.postId);
    Log.i("Finder.FinderPostRouterUI", "router " + this.xQJ);
    switch (this.xQJ)
    {
    case 8: 
    default: 
      Log.i("Finder.FinderPostRouterUI", "invalid router " + this.xQJ + ", finish");
      finish();
      AppMethodBeat.o(167499);
      return;
    case 1: 
      paramBundle = new Intent();
      paramBundle.putExtra("finder_username", z.bdh());
      paramBundle.addFlags(67108864);
      paramBundle.putExtra("KEY_FINDER_SELF_FLAG", true);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      aj.a.a((Context)this, paramBundle, 0L, 0, false, 124);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramBundle);
      finish();
      AppMethodBeat.o(167499);
      return;
    case 3: 
      paramBundle = new Intent();
      paramBundle.putExtra("key_finder_context_id", this.AtM);
      paramBundle.putExtra("key_finder_session_id", this.sessionId);
      paramBundle.putExtra("key_finder_post_id", this.postId);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.AtP);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.AtN);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.AtO);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.AtQ);
      paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.AtR);
      paramBundle.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.AtS);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = getIntent();
      p.j(localObject1, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramBundle, (Intent)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.I((Context)this, paramBundle);
      paramBundle = k.zWs;
      k.Pv(1);
      AppMethodBeat.o(167499);
      return;
    case 2: 
      this.AtL = true;
      aVe();
      paramBundle = k.zWs;
      k.Pv(2);
      AppMethodBeat.o(167499);
      return;
    case 4: 
      paramBundle = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.D((Context)this, getIntent());
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
        paramBundle = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramBundle = (Context)this;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_comment_scene", 41);
        com.tencent.mm.plugin.finder.utils.a.ad(paramBundle, (Intent)localObject1);
        overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
        AppMethodBeat.o(167499);
        return;
      }
      paramBundle = com.tencent.mm.plugin.finder.ui.edit.a.Aya;
      paramBundle = com.tencent.mm.plugin.finder.ui.edit.a.ebG();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelableArrayList("media_list", j.ag(new GalleryItem.MediaItem[] { GalleryItem.MediaItem.a(2, 0L, getIntent().getStringExtra("key_finder_post_sns_video_path"), "", "") }));
      Object localObject2 = ar.au((Context)this);
      Object localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject3 = getBaseContext();
      p.j(localObject3, "baseContext");
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.g((Context)localObject3, ((Point)localObject2).x, ((Point)localObject2).y);
      localObject2 = new Point(((Number)((r)localObject2).My).intValue(), ((Number)((r)localObject2).aazK).intValue());
      ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", ((Point)localObject2).x);
      ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", ((Point)localObject2).y);
      localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
      ((Bundle)localObject1).putLong("video_max_duration", com.tencent.mm.plugin.finder.storage.d.dSX() * 1000L);
      localObject2 = av.AJz;
      ((Bundle)localObject1).putString("output_dir", av.egt());
      paramBundle.mab = ((Bundle)localObject1);
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, b.a.slide_right_in, b.a.slide_right_out, paramBundle, 4, 0);
      com.tencent.mm.plugin.report.service.h.IzE.a(20694, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(167499);
      return;
    case 7: 
      getIntent().addFlags(536870912);
      getIntent().addFlags(67108864);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramBundle = MMApplicationContext.getContext();
      p.j(paramBundle, "MMApplicationContext.getContext()");
      com.tencent.mm.plugin.finder.utils.a.O(paramBundle, getIntent());
      AppMethodBeat.o(167499);
      return;
    case 9: 
      getIntent().addFlags(536870912);
      getIntent().addFlags(67108864);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramBundle = MMApplicationContext.getContext();
      p.j(paramBundle, "MMApplicationContext.getContext()");
      com.tencent.mm.plugin.finder.utils.a.aa(paramBundle, getIntent());
      AppMethodBeat.o(167499);
      return;
    }
    paramBundle = new Intent();
    paramBundle.putExtra("key_finder_post_id", this.postId);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID", this.AtP);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH", this.AtN);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME", this.AtO);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO", this.AtQ);
    paramBundle.putExtra("KEY_FINDER_POST_ORIGIN_BGM_URL", this.AtR);
    paramBundle.putExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", this.AtS);
    paramBundle.putExtra("KEY_FINDER_POST_FORM_FLUTTER", true);
    localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
    localObject1 = getIntent();
    p.j(localObject1, "getIntent()");
    com.tencent.mm.plugin.finder.utils.a.b(paramBundle, (Intent)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.I((Context)this, paramBundle);
    paramBundle = k.zWs;
    k.Pv(1);
    AppMethodBeat.o(167499);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(266997);
    CaptureDataManager.HKJ.a(null);
    super.onDestroy();
    AppMethodBeat.o(266997);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(167506);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfString = Thread.currentThread();
      p.j(paramArrayOfString, "Thread.currentThread()");
      Log.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(167506);
      return;
    }
    i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    p.j(paramArrayOfString, "Thread.currentThread()");
    Log.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(paramArrayOfString.getId()) });
    switch (paramInt)
    {
    }
    label223:
    label228:
    label357:
    label360:
    for (;;)
    {
      AppMethodBeat.o(167506);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label223;
        }
      }
      for (paramInt = j;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label228;
        }
        aVe();
        AppMethodBeat.o(167506);
        return;
        paramInt = 0;
        break;
      }
      com.tencent.mm.ui.base.h.a((Context)getContext(), com.tencent.mm.ci.a.ba((Context)getContext(), b.j.permission_camera_request_again_msg), com.tencent.mm.ci.a.ba((Context)getContext(), b.j.permission_tips_title), com.tencent.mm.ci.a.ba((Context)getContext(), b.j.jump_to_settings), com.tencent.mm.ci.a.ba((Context)getContext(), b.j.permission_cancel), false, (DialogInterface.OnClickListener)new b(this), (DialogInterface.OnClickListener)new c(this));
      AppMethodBeat.o(167506);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label357;
        }
      }
      for (paramInt = k;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label360;
        }
        aVe();
        break;
        paramInt = 0;
        break label328;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167500);
    super.onResume();
    Log.i("Finder.FinderPostRouterUI", "onResume");
    this.AtT = getIntent().getBooleanExtra("KEY_FINDER_POST_FROM_ADD_MEDIA", false);
    if (this.AtK)
    {
      finish();
      if (this.AtL) {
        overridePendingTransition(0, b.a.sight_slide_bottom_out);
      }
      if (this.xQJ == 6) {
        overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
      }
    }
    AppMethodBeat.o(167500);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(167501);
    super.onStop();
    Log.i("Finder.FinderPostRouterUI", "onStop");
    this.AtK = true;
    AppMethodBeat.o(167501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI$Companion;", "", "()V", "REQUEST_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(FinderPostRouterUI paramFinderPostRouterUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(269360);
      paramDialogInterface.dismiss();
      this.AtV.finish();
      paramDialogInterface = this.AtV.getContext();
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/ui/FinderPostRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/plugin/finder/ui/FinderPostRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(269360);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(FinderPostRouterUI paramFinderPostRouterUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(291800);
      paramDialogInterface.dismiss();
      this.AtV.finish();
      AppMethodBeat.o(291800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostRouterUI
 * JD-Core Version:    0.7.0.1
 */