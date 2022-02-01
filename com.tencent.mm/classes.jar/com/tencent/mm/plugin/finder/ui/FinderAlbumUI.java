package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.v.f;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.e.b;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.n;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
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
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "clickTimestamp", "", "isFolloPat", "", "isFromFinderAddMedia", "isHideAfterClick", "originalVideoDuration", "", "originalVideoPath", "", "pageInTimeStamp", "postId", "startActivityFromFlutter", "checkFinderVideoItemFormatValid", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "checkMediaRatio", "width", "height", "checkSelectedImage", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "checkSelectedVideo", "checkVideoPixelFormat", "", "path", "doEnterMMRecordVLogUI", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "doubleClickCheck", "enterFinderMediaCropUI", "vlogVideo", "enterFinderPostUI", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getMaxDurationSec", "getMaxDurationSecTip", "getMenuText", "initView", "isAllPathIsImage", "jumpImagePreviewUI", "mediaPosition", "onActivityResult", "requestCode", "resultCode", "data", "onBackBtnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaClick", "position", "itemView", "Landroid/view/View;", "itemViewType", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onResume", "onSendItemClick", "onStart", "setupFinderSelectVideoRestriction", "updateOptionMenuText", "menuID", "text", "Companion", "plugin-finder_release"})
public final class FinderAlbumUI
  extends AlbumPreviewUI
  implements CaptureDataManager.b
{
  public static final a Aof;
  private boolean AnZ;
  private boolean Aoa;
  private boolean Aob;
  private boolean Aoc;
  private int Aod;
  private String Aoe = "";
  private HashMap _$_findViewCache;
  private long pSM;
  private String postId = "";
  private long yPd;
  
  static
  {
    AppMethodBeat.i(167139);
    Aof = new a((byte)0);
    AppMethodBeat.o(167139);
  }
  
  private final void Qu(int paramInt)
  {
    AppMethodBeat.i(285627);
    Intent localIntent = new Intent((Context)this, ImagePreviewUI.class);
    Object localObject = this.Cai;
    p.j(localObject, "adapter");
    localIntent.putStringArrayListExtra("preview_image_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).eun());
    localObject = this.Cai;
    p.j(localObject, "adapter");
    localIntent.putParcelableArrayListExtra("preview_media_item_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).euo());
    localIntent.putExtra("preview_all", true);
    localIntent.putExtra("preview_position", paramInt);
    aD(paramInt, true);
    localIntent.putExtra("send_raw_img", this.tNu);
    localIntent.putExtra("key_force_hide_edit_image_button", true);
    localIntent.putExtra("max_select_count", this.AYg);
    localIntent.putExtra("GalleryUI_FromUser", this.fLi);
    localIntent.putExtra("GalleryUI_ToUser", this.toUser);
    localIntent.putExtra("album_business_tag", this.BZJ);
    localIntent.putExtra("album_video_max_duration", Math.max(this.nrt, dZK()));
    localIntent.putExtra("album_video_min_duration", this.CaG);
    localIntent.putExtra("media_type", 2);
    localIntent.putExtra("key_support_max_ratio", 3.0F);
    localObject = com.tencent.mm.plugin.gallery.model.e.etl();
    p.j(localObject, "GalleryCore.getMediaQueryService()");
    if (((o)localObject).etR() == 14) {
      localIntent.putExtra("key_edit_video_max_time_length", 300500);
    }
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(285627);
  }
  
  private static boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(285625);
    String str = paramVideoMediaItem.etI();
    p.j(str, "item.originalPath");
    aFa(str);
    boolean bool = com.tencent.mm.plugin.gallery.a.a.CeX.b(25, (GalleryItem.MediaItem)paramVideoMediaItem);
    AppMethodBeat.o(285625);
    return bool;
  }
  
  private static void aFa(String paramString)
  {
    AppMethodBeat.i(285626);
    com.tencent.e.h.ZvG.be((Runnable)new b(paramString));
    AppMethodBeat.o(285626);
  }
  
  private final void ap(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    int k = 1;
    AppMethodBeat.i(285629);
    Object localObject1 = ((Iterable)paramArrayList).iterator();
    int i = 1;
    if (((Iterator)localObject1).hasNext())
    {
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).getType() != 2) {
        break label736;
      }
      i = 0;
    }
    label583:
    label736:
    for (;;)
    {
      break;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelableArrayList("media_list", paramArrayList);
      ((Bundle)localObject1).putString("FINDER_CONTEXT_ID", getIntent().getStringExtra("key_finder_context_id"));
      ((Bundle)localObject1).putString("FINDER_SESSION_ID", getIntent().getStringExtra("key_finder_session_id"));
      ((Bundle)localObject1).putString("post_id", this.postId);
      ((Bundle)localObject1).putString("KEY_ORIGIN_MUSIC_ID", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID"));
      ((Bundle)localObject1).putString("KEY_ORIGIN_BGM_URL", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_BGM_URL"));
      ((Bundle)localObject1).putString("KEY_ORIGIN_MUSIC_PATH", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH"));
      ((Bundle)localObject1).putString("KEY_ORIGIN_MUSIC_NAME", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME"));
      ((Bundle)localObject1).putByteArray("KEY_ORIGIN_MUSIC_INFO", getIntent().getByteArrayExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO"));
      ((Bundle)localObject1).putBoolean("KEY_BGM_IF_ORIGIN", getIntent().getBooleanExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", false));
      paramArrayList = aj.AGc;
      ((Bundle)localObject1).putBoolean("KEY_FULLSCREEN", aj.isAnyEnableFullScreenEnjoy());
      ((Bundle)localObject1).putInt("KEY_MEDIA_SOURCE_FROM", 1);
      paramArrayList = ar.au((Context)this);
      Object localObject2 = aj.AGc;
      localObject2 = getBaseContext();
      p.j(localObject2, "baseContext");
      paramArrayList = aj.g((Context)localObject2, paramArrayList.x, paramArrayList.y);
      paramArrayList = new Point(((Number)paramArrayList.My).intValue(), ((Number)paramArrayList.aazK).intValue());
      ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", paramArrayList.x);
      ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", paramArrayList.y);
      paramArrayList = com.tencent.mm.plugin.finder.storage.d.AjH;
      ((Bundle)localObject1).putLong("video_max_duration", com.tencent.mm.plugin.finder.storage.d.dSX() * 1000L);
      paramArrayList = com.tencent.mm.plugin.finder.storage.d.AjH;
      ((Bundle)localObject1).putInt("image_max_height", com.tencent.mm.plugin.finder.storage.d.dSc());
      paramArrayList = com.tencent.mm.plugin.finder.storage.d.AjH;
      ((Bundle)localObject1).putInt("image_max_width", com.tencent.mm.plugin.finder.storage.d.dSb());
      paramArrayList = com.tencent.mm.plugin.finder.storage.d.AjH;
      ((Bundle)localObject1).putInt("image_compress_quality", com.tencent.mm.plugin.finder.storage.d.dSd());
      paramArrayList = av.AJz;
      ((Bundle)localObject1).putString("output_dir", av.egt());
      paramArrayList = com.tencent.mm.plugin.finder.ui.edit.a.Aya;
      paramArrayList = com.tencent.mm.plugin.finder.ui.edit.a.ebG();
      paramArrayList.mab = ((Bundle)localObject1);
      int j;
      ArrayList localArrayList;
      label511:
      GalleryItem.MediaItem localMediaItem;
      if (i != 0)
      {
        j = 3;
        CaptureDataManager.HKJ.a((CaptureDataManager.b)this);
        localObject2 = new ArrayList();
        localArrayList = new ArrayList();
        Object localObject3 = ((Bundle)localObject1).getParcelableArrayList("media_list");
        i = k;
        if (!this.Aob) {
          break label609;
        }
        i = k;
        if (localObject3 == null) {
          break label609;
        }
        localObject3 = ((ArrayList)localObject3).iterator();
        i = 1;
        if (!((Iterator)localObject3).hasNext()) {
          break label609;
        }
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject3).next();
        if (!(localMediaItem instanceof GalleryItem.VideoMediaItem)) {
          break label583;
        }
        localArrayList.add("video");
        k = 0;
      }
      for (;;)
      {
        p.j(localMediaItem, "item");
        ((ArrayList)localObject2).add(localMediaItem.etI());
        i = k;
        break label511;
        j = 4;
        break;
        k = i;
        if ((localMediaItem instanceof GalleryItem.ImageMediaItem))
        {
          localArrayList.add("image");
          k = i;
        }
      }
      label609:
      if ((this.Aob) && (i == 0))
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(1565, 0);
        Log.i("Finder.AlbumUI.FlutterVideoEditor_DataReport", "click next step in album activity");
        ((Bundle)localObject1).putStringArrayList("pathList", (ArrayList)localObject2);
        ((Bundle)localObject1).putStringArrayList("typeList", localArrayList);
        ((Bundle)localObject1).putString("postId", this.postId);
        ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.flutter.a.a.class)).a((Context)getContext(), 293, (Bundle)localObject1);
        AppMethodBeat.o(285629);
        return;
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, 0, 0, paramArrayList, j, 0);
      AppMethodBeat.o(285629);
      return;
    }
  }
  
  private final void ar(Intent paramIntent)
  {
    AppMethodBeat.i(285631);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, paramIntent);
    AppMethodBeat.o(285631);
  }
  
  private final String dZJ()
  {
    AppMethodBeat.i(167135);
    Object localObject = this.Cai;
    p.j(localObject, "adapter");
    int i = ((com.tencent.mm.plugin.gallery.ui.a)localObject).euo().size();
    if (i > 0)
    {
      localObject = new StringBuilder();
      AppCompatActivity localAppCompatActivity = getContext();
      p.j(localAppCompatActivity, "context");
      localObject = localAppCompatActivity.getResources().getString(b.j.app_nextstep) + '(' + i + '/' + this.AYg + ')';
      AppMethodBeat.o(167135);
      return localObject;
    }
    localObject = getContext();
    p.j(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources().getString(b.j.app_nextstep);
    p.j(localObject, "context.resources.getString(R.string.app_nextstep)");
    AppMethodBeat.o(167135);
    return localObject;
  }
  
  private static int dZK()
  {
    AppMethodBeat.i(285624);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHJ, 300);
    Object localObject = com.tencent.mm.kernel.h.ag(ak.class);
    p.j(localObject, "plugin(IPluginFinder::class.java)");
    localObject = ((ak)localObject).getFinderUtilApi();
    p.j(localObject, "plugin(IPluginFinder::class.java).finderUtilApi");
    i = Math.max(i, ((ag)localObject).eeE() - 1);
    AppMethodBeat.o(285624);
    return i;
  }
  
  private static boolean gW(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    float f;
    do
    {
      return false;
      f = paramInt1 / paramInt2;
    } while ((f > 3.0F) || (f < 0.3333333F));
    return true;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(285636);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(285636);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(285635);
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
    AppMethodBeat.o(285635);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(285630);
    paramContext = k.zWs;
    paramContext = c.HUw;
    k.b(c.fxp());
    Object localObject1;
    if (paramCaptureVideoNormalModel != null)
    {
      paramContext = new Intent();
      if (this.Aoc) {
        paramContext.putExtras(getIntent());
      }
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getByteArray("MEDIA_EXTRA_MUSIC");
        if (localObject1 != null) {
          paramContext.putExtra("MEDIA_EXTRA_MUSIC", (byte[])localObject1);
        }
      }
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getByteArray("ORIGIN_MUSIC_INFO");
        if (localObject1 != null) {
          paramContext.putExtra("ORIGIN_MUSIC_INFO", (byte[])localObject1);
        }
      }
      com.tencent.mm.ae.d.a(paramContext, paramBundle, "ORIGIN_MUSIC_ID");
      com.tencent.mm.ae.d.a(paramContext, paramBundle, "ORIGIN_MUSIC_PATH");
      com.tencent.mm.ae.d.a(paramContext, paramBundle, "ORIGIN_BGM_URL");
      com.tencent.mm.ae.d.b(paramContext, paramBundle, "MEDIA_IS_MUTE");
      com.tencent.mm.ae.d.b(paramContext, paramBundle, "MUSIC_IS_MUTE");
      com.tencent.mm.ae.d.c(paramContext, paramBundle, "SOUND_TRACK_TYPE");
      com.tencent.mm.ae.d.a(paramContext, paramBundle, "MUSIC_FEED_ID");
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getParcelableArrayList("KEY_POST_HALF_RECT_LIST");
        if (localObject1 != null) {
          paramContext.putExtra("KEY_POST_HALF_RECT_LIST", (Serializable)localObject1);
        }
      }
      localObject1 = (ArrayList)paramCaptureVideoNormalModel.fvU().x("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
      if ((paramCaptureVideoNormalModel.fvV() == null) || (paramCaptureVideoNormalModel.fvV().size() <= 0)) {
        break label563;
      }
      paramContext.putExtra("postType", 2);
      Object localObject2 = paramCaptureVideoNormalModel.fvV();
      p.j(localObject2, "model.multiImagePath");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        p.j(str, "it");
        ((Collection)localObject2).add(str);
      }
      paramContext.putExtra("postMediaList", (Serializable)localObject2);
      localObject2 = paramCaptureVideoNormalModel.fvV();
      p.j(localObject2, "model.multiImagePath");
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((Iterator)localObject3).next();
        ((Collection)localObject2).add(Integer.valueOf(2));
      }
      paramContext.putExtra("postTypeList", (Serializable)localObject2);
      paramContext.putExtra("postThumbList", (Serializable)j.ag(new String[] { paramCaptureVideoNormalModel.aZe() }));
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == paramCaptureVideoNormalModel.fvV().size())) {
        paramContext.putExtra("key_post_media_quality_list", (Serializable)localObject1);
      }
      com.tencent.mm.ae.d.d(paramContext, paramBundle, "KEY_POST_HALF_IMAGE_LIST");
    }
    for (;;)
    {
      paramContext.putExtra("post_id", this.postId);
      paramContext.putExtra("edit_id", (String)paramCaptureVideoNormalModel.fvU().x("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramCaptureVideoNormalModel = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramCaptureVideoNormalModel = getIntent();
      p.j(paramCaptureVideoNormalModel, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramContext, paramCaptureVideoNormalModel);
      ar(paramContext);
      AppMethodBeat.o(285630);
      return;
      label563:
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getByteArray("video_composition");
        if (paramBundle != null) {
          paramContext.putExtra("video_composition", paramBundle);
        }
      }
      paramContext.putExtra("postType", 4);
      paramContext.putExtra("postMediaList", (Serializable)j.ag(new String[] { paramCaptureVideoNormalModel.getVideoPath() }));
      paramContext.putExtra("postTypeList", (Serializable)j.ag(new Integer[] { Integer.valueOf(4) }));
      paramContext.putExtra("postThumbList", (Serializable)j.ag(new String[] { paramCaptureVideoNormalModel.aZe() }));
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1)) {
        paramContext.putExtra("key_post_media_quality_list", (Serializable)localObject1);
      }
    }
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(285622);
    if ((paramMediaItem instanceof GalleryItem.ImageMediaItem))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(((GalleryItem.ImageMediaItem)paramMediaItem).etI(), localOptions);
      if (!gW(localOptions.outWidth, localOptions.outHeight))
      {
        com.tencent.mm.ui.base.h.a((Context)this, getString(b.j.gallery_select_pic_ratio_not_support), "", getString(b.j.app_i_know), false, null);
        AppMethodBeat.o(285622);
        return false;
      }
      AppMethodBeat.o(285622);
      return true;
    }
    AppMethodBeat.o(285622);
    return false;
  }
  
  public final boolean b(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(285623);
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      if (!gW(((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth, ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight))
      {
        com.tencent.mm.ui.base.h.a((Context)this, getString(b.j.gallery_select_video_ratio_not_support), "", getString(b.j.app_i_know), false, null);
        AppMethodBeat.o(285623);
        return false;
      }
      boolean bool = a((GalleryItem.VideoMediaItem)paramMediaItem);
      if (!bool)
      {
        v.f localf = v.f.zYN;
        v.f.af(((GalleryItem.VideoMediaItem)paramMediaItem).maR, ((GalleryItem.VideoMediaItem)paramMediaItem).maS, paramMediaItem.AAz);
        com.tencent.mm.ui.base.h.a((Context)this, getString(b.j.gallery_pic_video_not_support_desc), "", getString(b.j.app_i_know), false, null);
      }
      AppMethodBeat.o(285623);
      return bool;
    }
    AppMethodBeat.o(285623);
    return false;
  }
  
  public final boolean dZI()
  {
    AppMethodBeat.i(167131);
    Object localObject1 = com.tencent.mm.plugin.vlog.report.a.NqV;
    com.tencent.mm.plugin.vlog.report.a.c(100, 1, System.currentTimeMillis() - this.yPd, 1);
    if (this.jQj == 25)
    {
      localObject1 = this.Cai;
      p.j(localObject1, "adapter");
      Object localObject3 = new ArrayList((Collection)((com.tencent.mm.plugin.gallery.ui.a)localObject1).euo());
      if (((ArrayList)localObject3).isEmpty())
      {
        Log.e("Finder.AlbumUI", "[onSendItemClick] list isEmpty");
        AppMethodBeat.o(167131);
        return false;
      }
      Object localObject2 = ((ArrayList)localObject3).get(0);
      localObject1 = localObject2;
      if (!(localObject2 instanceof GalleryItem.VideoMediaItem)) {
        localObject1 = null;
      }
      localObject1 = (GalleryItem.VideoMediaItem)localObject1;
      if (localObject1 != null) {}
      for (int i = ((GalleryItem.VideoMediaItem)localObject1).maT;; i = 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if ((((Number)com.tencent.mm.plugin.finder.storage.d.dWd().aSr()).intValue() != 1) || (((ArrayList)localObject3).size() != 1)) {
          break label586;
        }
        long l = i;
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (l < (com.tencent.mm.plugin.finder.storage.d.dSX() + 1) * 1000L) {
          break label586;
        }
        l = i;
        localObject1 = com.tencent.mm.kernel.h.ag(ak.class);
        p.j(localObject1, "plugin(IPluginFinder::class.java)");
        localObject1 = ((ak)localObject1).getFinderUtilApi();
        p.j(localObject1, "plugin(IPluginFinder::class.java).finderUtilApi");
        if ((l >= ((ag)localObject1).eeE() * 1000L) || (this.AnZ)) {
          break label586;
        }
        localObject1 = new com.tencent.mm.plugin.finder.view.e((Context)getContext());
        localObject2 = ((ArrayList)localObject3).get(0);
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
        AppMethodBeat.o(167131);
        throw ((Throwable)localObject1);
      }
      localObject2 = (GalleryItem.VideoMediaItem)localObject2;
      ((com.tencent.mm.plugin.finder.view.e)localObject1).RB(b.g.finder_post_choose_video_layout);
      Object localObject4 = (TextView)((com.tencent.mm.plugin.finder.view.e)localObject1).oFW.findViewById(b.f.dialog_title);
      if (localObject4 != null) {
        ar.a((Paint)((TextView)localObject4).getPaint(), 0.8F);
      }
      localObject4 = ((com.tencent.mm.plugin.finder.view.e)localObject1).oFW.findViewById(b.f.dialog_back_btn);
      if (localObject4 != null) {
        ((View)localObject4).setOnClickListener((View.OnClickListener)new g((com.tencent.mm.plugin.finder.view.e)localObject1));
      }
      localObject4 = ((com.tencent.mm.plugin.finder.view.e)localObject1).oFW.findViewById(b.f.long_video_area);
      if (localObject4 != null) {
        ((View)localObject4).setOnClickListener((View.OnClickListener)new d((com.tencent.mm.plugin.finder.view.e)localObject1, (GalleryItem.VideoMediaItem)localObject2, this, (ArrayList)localObject3));
      }
      localObject2 = ((com.tencent.mm.plugin.finder.view.e)localObject1).oFW.findViewById(b.f.short_video_area);
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new e((com.tencent.mm.plugin.finder.view.e)localObject1, this, (ArrayList)localObject3));
      }
      ((com.tencent.mm.plugin.finder.view.e)localObject1).a((e.b)new f(this, (ArrayList)localObject3));
      ((com.tencent.mm.plugin.finder.view.e)localObject1).eik();
      localObject1 = ai.zZt;
      localObject1 = k.zWs;
      localObject1 = k.dPy();
      if (localObject1 != null)
      {
        localObject2 = ((FinderFeedReportObject)localObject1).clickId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = k.zWs;
      localObject2 = k.dPy();
      if (localObject2 != null)
      {
        localObject3 = ((FinderFeedReportObject)localObject2).postId;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      ai.l((String)localObject1, (String)localObject2, cm.bfE() / 1000L);
      for (;;)
      {
        AppMethodBeat.o(167131);
        return true;
        label586:
        localObject1 = n.NlN;
        n.gsZ();
        ap((ArrayList)localObject3);
      }
    }
    AppMethodBeat.o(167131);
    return false;
  }
  
  public final void h(int paramInt, View paramView)
  {
    AppMethodBeat.i(167136);
    p.k(paramView, "itemView");
    paramView = this.Cai.SY(paramInt);
    if ((paramView == null) || (Util.isNullOrNil(paramView.etI())))
    {
      if (paramView == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("Finder.AlbumUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(167136);
        return;
      }
    }
    if (this.jQj == 25)
    {
      if ((paramView instanceof GalleryItem.VideoMediaItem))
      {
        paramInt = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHJ, 300);
        localObject = com.tencent.mm.kernel.h.ag(ak.class);
        p.j(localObject, "plugin(IPluginFinder::class.java)");
        localObject = ((ak)localObject).getFinderUtilApi();
        p.j(localObject, "plugin(IPluginFinder::class.java).finderUtilApi");
        paramInt = Math.max(paramInt, ((ag)localObject).eeE());
        int i = dZK();
        this.Aod = ((GalleryItem.VideoMediaItem)paramView).maT;
        localObject = ((GalleryItem.VideoMediaItem)paramView).etI();
        p.j(localObject, "item.originalPath");
        this.Aoe = ((String)localObject);
        int j = ((GalleryItem.VideoMediaItem)paramView).maT;
        localObject = com.tencent.mm.modelcontrol.e.bkp();
        p.j(localObject, "SubCoreVideoControl.getCore()");
        if (j < ((com.tencent.mm.modelcontrol.e)localObject).bkv().minDuration * 1000)
        {
          paramView = (Context)getContext();
          localObject = getResources();
          paramInt = b.j.gallery_video_duration_below;
          com.tencent.mm.modelcontrol.e locale = com.tencent.mm.modelcontrol.e.bkp();
          p.j(locale, "SubCoreVideoControl.getCore()");
          com.tencent.mm.ui.base.h.c(paramView, ((Resources)localObject).getString(paramInt, new Object[] { Integer.valueOf(locale.bkv().minDuration) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        if (((GalleryItem.VideoMediaItem)paramView).maT > paramInt * 1000)
        {
          com.tencent.mm.ui.base.h.c((Context)getContext(), getResources().getString(b.j.gallery_video_duration_limit, new Object[] { Integer.valueOf(i) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        Log.i("Finder.AlbumUI", "onMediaClick, video mime:" + ((GalleryItem.VideoMediaItem)paramView).maR + ", audio mime:" + ((GalleryItem.VideoMediaItem)paramView).maS + ", path:" + paramView.AAz);
        if (!a((GalleryItem.VideoMediaItem)paramView))
        {
          localObject = v.f.zYN;
          v.f.af(((GalleryItem.VideoMediaItem)paramView).maR, ((GalleryItem.VideoMediaItem)paramView).maS, paramView.AAz);
          paramView = new f.a((Context)getContext());
          paramView.aR((CharSequence)com.tencent.mm.ci.a.ba((Context)getContext(), b.i.gallery_pic_video_not_support_desc));
          paramView.bBp(com.tencent.mm.ci.a.ba((Context)getContext(), b.i.gallery_i_know));
          paramView.b((f.c)c.Aog);
          paramView.show();
          AppMethodBeat.o(167136);
          return;
        }
        new ArrayList(1).add(paramView);
        localObject = this.Cai.SX(((GalleryItem.VideoMediaItem)paramView).getType());
        com.tencent.mm.plugin.gallery.model.e.au((ArrayList)localObject);
        Qu(((ArrayList)localObject).indexOf(paramView));
        AppMethodBeat.o(167136);
        return;
      }
      Object localObject = this.Cai.SX(paramView.getType());
      com.tencent.mm.plugin.gallery.model.e.au((ArrayList)localObject);
      Qu(((ArrayList)localObject).indexOf(paramView));
    }
    AppMethodBeat.o(167136);
  }
  
  public final void initView()
  {
    boolean bool = false;
    AppMethodBeat.i(167134);
    super.initView();
    removeOptionMenu(0);
    getController().Fy(true);
    addTextOptionMenu(0, dZJ(), this.CaQ, null, w.b.Waz);
    Object localObject = this.Cae;
    p.j(localObject, "gallery");
    ((RecyclerView)localObject).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    Ta(0);
    localObject = (CharSequence)getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bool = true;
      }
      this.AnZ = bool;
      AppMethodBeat.o(167134);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(167137);
    Log.i("Finder.AlbumUI", "onActivityResult requestCode " + paramInt1 + " resultCod " + paramInt2);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("clear_list", false)))
      {
        paramIntent = this.Cai;
        p.j(paramIntent, "adapter");
        paramIntent.euo().clear();
        this.Cai.notifyDataSetChanged();
        Ta(0);
        AppMethodBeat.o(167137);
        return;
      }
      setResult(-1, paramIntent);
      finish();
      AppMethodBeat.o(167137);
      return;
    }
    if (paramInt2 == 25)
    {
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = paramIntent.getStringArrayListExtra("preview_image_list");
      }
      if ((localObject1 != null) && (this.Cai != null))
      {
        this.Cai.aw((ArrayList)localObject1);
        this.Cai.notifyDataSetChanged();
        Ta(((ArrayList)localObject1).size());
      }
      dZI();
      AppMethodBeat.o(167137);
      return;
    }
    if ((291 == paramInt1) && (paramInt2 == -1))
    {
      localObject1 = new ArrayList(1);
      if (paramIntent == null) {
        p.iCn();
      }
      paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      p.j(paramIntent, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
      localObject2 = new GalleryItem.VideoMediaItem();
      ((GalleryItem.VideoMediaItem)localObject2).AAz = paramIntent.getVideoPath();
      ((GalleryItem.VideoMediaItem)localObject2).wAy = paramIntent.aZe();
      ((GalleryItem.VideoMediaItem)localObject2).maT = ((int)paramIntent.fvS().longValue());
      ((ArrayList)localObject1).add(localObject2);
      paramInt1 = this.Aod;
      localObject2 = this.Aoe;
      paramIntent = new Intent();
      paramIntent.putExtra("fromAppBrand", getIntent().getBooleanExtra("fromAppBrand", false));
      paramIntent.putParcelableArrayListExtra("select_path_list", (ArrayList)localObject1);
      paramIntent.putParcelableArrayListExtra("front_vlog_video", null);
      paramIntent.putExtra("select_video_path", (String)localObject2);
      paramIntent.putExtra("select_video_duration", paramInt1);
      paramIntent.setClass((Context)getContext(), FinderMediaCropUI.class);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = getIntent();
      p.j(localObject1, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramIntent, (Intent)localObject1);
      startActivityForResult(paramIntent, 1001);
      AppMethodBeat.o(167137);
      return;
    }
    if (292 == paramInt1)
    {
      localObject2 = (Context)this;
      if (paramIntent != null) {
        localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      }
      paramIntent = CaptureDataManager.HKJ;
      p.j(paramIntent, "CaptureDataManager.INSTANCE");
      a((Context)localObject2, (CaptureDataManager.CaptureVideoNormalModel)localObject1, paramIntent.getExtData());
      AppMethodBeat.o(167137);
      return;
    }
    if ((293 == paramInt1) && (paramInt2 == -1)) {
      finish();
    }
    AppMethodBeat.o(167137);
  }
  
  public final void onBackBtnClick()
  {
    AppMethodBeat.i(167133);
    Object localObject = k.zWs;
    k.Pw(3);
    localObject = com.tencent.mm.plugin.vlog.report.a.NqV;
    com.tencent.mm.plugin.vlog.report.a.c(100, 1, System.currentTimeMillis() - this.yPd, 0);
    AppMethodBeat.o(167133);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(285618);
    super.onCreate(paramBundle);
    Object localObject = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      paramBundle = new StringBuilder();
      p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond();
    }
    this.postId = paramBundle;
    this.Aoc = getIntent().getBooleanExtra("album_from_finder_add_media", false);
    paramBundle = k.zWs;
    k.aEa(this.postId);
    paramBundle = com.tencent.mm.plugin.gallery.a.a.CeX;
    paramBundle = com.tencent.mm.plugin.gallery.a.a.euY();
    paramBundle.put("qt-file", true);
    localObject = com.tencent.mm.plugin.gallery.a.a.CeX;
    com.tencent.mm.plugin.gallery.a.a.aX(paramBundle);
    AppMethodBeat.o(285618);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(285628);
    CaptureDataManager.HKJ.a(null);
    super.onDestroy();
    AppMethodBeat.o(285628);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(285621);
    super.onResume();
    this.yPd = System.currentTimeMillis();
    com.tencent.mm.plugin.vlog.report.a locala = com.tencent.mm.plugin.vlog.report.a.NqV;
    com.tencent.mm.plugin.vlog.report.a.aki(100);
    AppMethodBeat.o(285621);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(285619);
    super.onStart();
    if (this.Aob) {
      ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.flutter.a.a.class)).epU();
    }
    AppMethodBeat.o(285619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    AppMethodBeat.i(167132);
    super.updateOptionMenuText(paramInt, dZJ());
    AppMethodBeat.o(167132);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI$Companion;", "", "()V", "DOUBLE_CLICK_CHECK_INTERVAL", "", "FLUTTER_TAG", "", "REQUEST_CODE_EDIT_VIDEO", "", "REQUEST_CODE_EDIT_VLOG", "REQUEST_CODE_EDIT_VLOG_FLUTTER", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(271759);
      Object localObject1 = MultiMediaVideoChecker.NmA.cO(this.oyo, true);
      Object localObject2;
      int i;
      if ((localObject1 == null) || (((MultiMediaVideoChecker.a)localObject1).pixelFormat != -1))
      {
        localObject2 = MultiMediaVideoChecker.NmA;
        if (localObject1 == null) {
          break label97;
        }
        i = ((MultiMediaVideoChecker.a)localObject1).pixelFormat;
        if (!MultiMediaVideoChecker.ake(i))
        {
          localObject2 = new StringBuilder("select invalid pixelFormat video:");
          if (localObject1 == null) {
            break label102;
          }
        }
      }
      label97:
      label102:
      for (localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject1).pixelFormat);; localObject1 = null)
      {
        Log.i("Finder.AlbumUI", localObject1);
        localObject1 = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
        com.tencent.mm.plugin.vlog.model.report.a.gui();
        AppMethodBeat.o(271759);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements f.c
  {
    public static final c Aog;
    
    static
    {
      AppMethodBeat.i(167130);
      Aog = new c();
      AppMethodBeat.o(167130);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$3"})
  static final class d
    implements View.OnClickListener
  {
    d(com.tencent.mm.plugin.finder.view.e parame, GalleryItem.VideoMediaItem paramVideoMediaItem, FinderAlbumUI paramFinderAlbumUI, ArrayList paramArrayList) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(276944);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (FinderAlbumUI.a(jdField_this))
      {
        Log.i("Finder.AlbumUI", "onSendItemClick: long video btn hit double click check");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276944);
        return;
      }
      float f = this.Aoh.videoHeight / this.Aoh.videoWidth;
      paramView = com.tencent.mm.kernel.h.ag(ak.class);
      p.j(paramView, "plugin(IPluginFinder::class.java)");
      paramView = ((ak)paramView).getFinderUtilApi();
      p.j(paramView, "plugin(IPluginFinder::class.java).finderUtilApi");
      if (f <= paramView.eeF())
      {
        paramView = com.tencent.mm.kernel.h.ag(ak.class);
        p.j(paramView, "plugin(IPluginFinder::class.java)");
        paramView = ((ak)paramView).getFinderUtilApi();
        p.j(paramView, "plugin(IPluginFinder::class.java).finderUtilApi");
        if (f >= paramView.eeG()) {}
      }
      else
      {
        com.tencent.mm.ui.base.w.makeText((Context)jdField_this.getContext(), b.j.gallery_pic_video_special_ratio_desc, 0).show();
        FinderAlbumUI.a(jdField_this, true);
        this.wZH.bYF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276944);
        return;
      }
      FinderAlbumUI.a(jdField_this, true);
      this.wZH.bYF();
      paramView = new Intent();
      paramView.putExtra("post_id", FinderAlbumUI.c(jdField_this));
      paramView.putExtra("postType", 4);
      paramView.putExtra("postMediaList", (Serializable)j.ag(new String[] { this.Aoh.etI() }));
      paramView.putExtra("postTypeList", (Serializable)j.ag(new Integer[] { Integer.valueOf(4) }));
      paramView.putExtra("isLongVideoPost", true);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject = jdField_this.getIntent();
      p.j(localObject, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramView, (Intent)localObject);
      FinderAlbumUI.a(jdField_this, paramView);
      paramView = ai.zZt;
      paramView = k.zWs;
      paramView = k.dPy();
      if (paramView != null)
      {
        localObject = paramView.clickId;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      localObject = k.zWs;
      localObject = k.dPy();
      if (localObject != null)
      {
        String str = ((FinderFeedReportObject)localObject).postId;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      ai.a(paramView, (String)localObject, 2, cm.bfE() / 1000L, 2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(276944);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$4"})
  static final class e
    implements View.OnClickListener
  {
    e(com.tencent.mm.plugin.finder.view.e parame, FinderAlbumUI paramFinderAlbumUI, ArrayList paramArrayList) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287571);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (FinderAlbumUI.a(jdField_this))
      {
        Log.i("Finder.AlbumUI", "onSendItemClick: short video btn hit double click check");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287571);
        return;
      }
      FinderAlbumUI.a(jdField_this, true);
      this.wZH.bYF();
      FinderAlbumUI.a(jdField_this, this.Aoj);
      paramView = ai.zZt;
      paramView = k.zWs;
      paramView = k.dPy();
      if (paramView != null)
      {
        localObject = paramView.clickId;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      localObject = k.zWs;
      localObject = k.dPy();
      if (localObject != null)
      {
        String str = ((FinderFeedReportObject)localObject).postId;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      ai.a(paramView, (String)localObject, 2, cm.bfE() / 1000L, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287571);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$5"})
  static final class f
    implements e.b
  {
    f(FinderAlbumUI paramFinderAlbumUI, ArrayList paramArrayList) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(290728);
      if (FinderAlbumUI.b(this.Aoi))
      {
        FinderAlbumUI.a(this.Aoi, false);
        AppMethodBeat.o(290728);
        return;
      }
      Object localObject1 = ai.zZt;
      localObject1 = k.zWs;
      localObject1 = k.dPy();
      if (localObject1 != null)
      {
        localObject2 = ((FinderFeedReportObject)localObject1).clickId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      Object localObject2 = k.zWs;
      localObject2 = k.dPy();
      if (localObject2 != null)
      {
        String str = ((FinderFeedReportObject)localObject2).postId;
        localObject2 = str;
        if (str != null) {}
      }
      else
      {
        localObject2 = "";
      }
      ai.a((String)localObject1, (String)localObject2, 2, cm.bfE() / 1000L, 3);
      AppMethodBeat.o(290728);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(com.tencent.mm.plugin.finder.view.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244407);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.wZH.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(244407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderAlbumUI
 * JD-Core Version:    0.7.0.1
 */