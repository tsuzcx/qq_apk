package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.report.r.f;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.d.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.n.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.plugin.vlog.ui.MultiVideoFullScreenPluginLayout;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t.b;
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
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "clickTimestamp", "", "isFolloPat", "", "isFromFinderAddMedia", "isHideAfterClick", "originalVideoDuration", "", "originalVideoPath", "", "postId", "startActivityFromFlutter", "checkFinderVideoItemFormatValid", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "checkMediaRatio", "width", "height", "checkSelectedImage", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "checkSelectedVideo", "checkVideoPixelFormat", "", "path", "doEnterMMRecordVLogUI", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "doubleClickCheck", "enterFinderMediaCropUI", "vlogVideo", "enterFinderPostUI", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getMaxDurationSec", "getMaxDurationSecTip", "getMenuText", "initView", "isAllPathIsImage", "jumpImagePreviewUI", "mediaPosition", "onActivityResult", "requestCode", "resultCode", "data", "onBackBtnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaClick", "position", "itemView", "Landroid/view/View;", "itemViewType", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onSendItemClick", "onStart", "updateOptionMenuText", "menuID", "text", "Companion", "plugin-finder_release"})
public final class FinderAlbumUI
  extends AlbumPreviewUI
  implements CaptureDataManager.b
{
  public static final a vHi;
  private HashMap _$_findViewCache;
  private long mRS;
  private String postId = "";
  private boolean vHc;
  private boolean vHd;
  private boolean vHe;
  private boolean vHf;
  private int vHg;
  private String vHh = "";
  
  static
  {
    AppMethodBeat.i(167139);
    vHi = new a((byte)0);
    AppMethodBeat.o(167139);
  }
  
  private final void Lk(int paramInt)
  {
    AppMethodBeat.i(252124);
    Intent localIntent = new Intent((Context)this, ImagePreviewUI.class);
    Object localObject = this.xnQ;
    p.g(localObject, "adapter");
    localIntent.putStringArrayListExtra("preview_image_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).dRL());
    localObject = this.xnQ;
    p.g(localObject, "adapter");
    localIntent.putParcelableArrayListExtra("preview_media_item_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).dRM());
    localIntent.putExtra("preview_all", true);
    localIntent.putExtra("preview_position", paramInt);
    az(paramInt, true);
    localIntent.putExtra("send_raw_img", this.qoL);
    localIntent.putExtra("key_force_hide_edit_image_button", true);
    localIntent.putExtra("max_select_count", this.wnd);
    localIntent.putExtra("GalleryUI_FromUser", this.dRL);
    localIntent.putExtra("GalleryUI_ToUser", this.toUser);
    localIntent.putExtra("album_business_tag", this.xnr);
    localIntent.putExtra("album_video_max_duration", Math.max(this.kyt, dyT()));
    localIntent.putExtra("album_video_min_duration", this.xoo);
    localIntent.putExtra("media_type", 2);
    localIntent.putExtra("key_support_max_ratio", 3.0F);
    localObject = com.tencent.mm.plugin.gallery.model.e.dQK();
    p.g(localObject, "GalleryCore.getMediaQueryService()");
    if (((o)localObject).dRp() == 14) {
      localIntent.putExtra("key_edit_video_max_time_length", 300500);
    }
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(252124);
  }
  
  private final boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(252122);
    int i;
    if ((n.I("video/hevc", paramVideoMediaItem.jkQ, true)) && (f.ejb())) {
      i = 1;
    }
    for (;;)
    {
      int j = i;
      if (!Util.isNullOrNil(paramVideoMediaItem.jkR))
      {
        j = i;
        if (!n.I("audio/mp4a-latm", paramVideoMediaItem.jkR, true)) {
          j = 0;
        }
      }
      if (com.tencent.mm.modelvideo.r.Ql(paramVideoMediaItem.xiW))
      {
        if ((Util.isNullOrNil(paramVideoMediaItem.jkQ)) || (!f.aFg(paramVideoMediaItem.jkQ)) || (Util.isNullOrNil(paramVideoMediaItem.jkR)) || (!f.aFg(paramVideoMediaItem.jkR))) {
          break label181;
        }
        Log.i("Finder.AlbumUI", "qt video can decode");
      }
      for (j = 1;; j = 0)
      {
        String str = paramVideoMediaItem.dRh();
        p.g(str, "item.originalPath");
        avJ(str);
        if ((j == 0) || (bG(paramVideoMediaItem.xiW, false))) {
          break label195;
        }
        AppMethodBeat.o(252122);
        return true;
        if (!n.I("video/avc", paramVideoMediaItem.jkQ, true)) {
          break label203;
        }
        i = 1;
        break;
        label181:
        Log.i("Finder.AlbumUI", "qt video cannot decode");
      }
      label195:
      AppMethodBeat.o(252122);
      return false;
      label203:
      i = 0;
    }
  }
  
  private final void ak(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    int j = 3;
    AppMethodBeat.i(252126);
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).apE();
    ((UICustomParam.a)localObject1).apD();
    ((UICustomParam.a)localObject1).dz(false);
    ((UICustomParam.a)localObject1).apF();
    ((UICustomParam.a)localObject1).a(2131231432, 0, "", 0);
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.jB("", "");
    localRecordConfigProvider.scene = 11;
    localRecordConfigProvider.BOn = ((UICustomParam.a)localObject1).apG();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    localRecordConfigProvider.BOm = com.tencent.mm.plugin.finder.storage.c.dqx();
    localRecordConfigProvider.BOp = 3;
    localRecordConfigProvider.BOv = (localRecordConfigProvider.BOm.duration * 1000);
    ((UICustomParam.a)localObject1).dy(false);
    localObject1 = ((Iterable)paramArrayList).iterator();
    int i = 1;
    if (((Iterator)localObject1).hasNext())
    {
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).getType() != 2) {
        break label909;
      }
      i = 0;
    }
    label779:
    label909:
    for (;;)
    {
      break;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelableArrayList("media_list", paramArrayList);
      ((Bundle)localObject1).putString("post_id", this.postId);
      ((Bundle)localObject1).putString("KEY_ORIGIN_MUSIC_ID", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID"));
      ((Bundle)localObject1).putString("KEY_ORIGIN_BGM_URL", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_BGM_URL"));
      ((Bundle)localObject1).putString("KEY_ORIGIN_MUSIC_PATH", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH"));
      ((Bundle)localObject1).putString("KEY_ORIGIN_MUSIC_NAME", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME"));
      ((Bundle)localObject1).putByteArray("KEY_ORIGIN_MUSIC_INFO", getIntent().getByteArrayExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO"));
      ((Bundle)localObject1).putBoolean("KEY_BGM_IF_ORIGIN", getIntent().getBooleanExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", false));
      paramArrayList = y.vXH;
      ((Bundle)localObject1).putBoolean("KEY_FULLSCREEN", y.isAnyEnableFullScreenEnjoy());
      ((Bundle)localObject1).putInt("KEY_MEDIA_SOURCE_FROM", 1);
      paramArrayList = ao.az((Context)this);
      localObject2 = y.vXH;
      localObject2 = getBaseContext();
      p.g(localObject2, "baseContext");
      paramArrayList = y.g((Context)localObject2, paramArrayList.x, paramArrayList.y);
      paramArrayList = new Point(((Number)paramArrayList.second).intValue(), ((Number)paramArrayList.SWY).intValue());
      ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", paramArrayList.x);
      ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", paramArrayList.y);
      paramArrayList = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((Bundle)localObject1).putLong("video_max_duration", com.tencent.mm.plugin.finder.storage.c.drG() * 1000L);
      paramArrayList = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((Bundle)localObject1).putInt("image_max_height", com.tencent.mm.plugin.finder.storage.c.dqP());
      paramArrayList = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((Bundle)localObject1).putInt("image_max_width", com.tencent.mm.plugin.finder.storage.c.dqO());
      paramArrayList = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((Bundle)localObject1).putInt("image_compress_quality", com.tencent.mm.plugin.finder.storage.c.dqQ());
      paramArrayList = al.waC;
      ((Bundle)localObject1).putString("output_dir", al.dEG());
      localRecordConfigProvider.jkf = ((Bundle)localObject1);
      paramArrayList = y.vXH;
      if (y.isAnyEnableFullScreenEnjoy())
      {
        paramArrayList = MultiVideoFullScreenPluginLayout.class.getName();
        p.g(paramArrayList, "if (FinderUtil.isAnyEnab…inLayout::class.java.name");
        localRecordConfigProvider.F(3, paramArrayList);
        localRecordConfigProvider.F(4, paramArrayList);
        if (i == 0) {
          break label679;
        }
      }
      GalleryItem.MediaItem localMediaItem;
      for (;;)
      {
        CaptureDataManager.BOb.a((CaptureDataManager.b)this);
        paramArrayList = new ArrayList();
        localObject2 = new ArrayList();
        Object localObject3 = ((Bundle)localObject1).getParcelableArrayList("media_list");
        if (localObject3 == null) {
          break label779;
        }
        localObject3 = ((ArrayList)localObject3).iterator();
        i = 1;
        k = i;
        if (!((Iterator)localObject3).hasNext()) {
          break label782;
        }
        localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject3).next();
        str = localMediaItem.mMimeType;
        p.g(str, "item.mMimeType");
        if (str != null) {
          break label684;
        }
        paramArrayList = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(252126);
        throw paramArrayList;
        paramArrayList = MultiVideoPluginLayout.class.getName();
        break;
        label679:
        j = 4;
      }
      label684:
      String str = str.substring(0, 5);
      p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (n.I(str, "video", true))
      {
        ((ArrayList)localObject2).add("video");
        k = 0;
      }
      for (;;)
      {
        p.g(localMediaItem, "item");
        paramArrayList.add(localMediaItem.dRh());
        i = k;
        break;
        k = i;
        if (n.I(str, "image", true))
        {
          ((ArrayList)localObject2).add("image");
          k = i;
        }
      }
      int k = 1;
      label782:
      if ((this.vHe) && (k == 0))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1565, 0);
        Log.i("Finder.AlbumUI.FlutterVideoEditor_DataReport", "click next step in album activity");
        ((Bundle)localObject1).putStringArrayList("pathList", paramArrayList);
        ((Bundle)localObject1).putStringArrayList("typeList", (ArrayList)localObject2);
        ((Bundle)localObject1).putString("postId", this.postId);
        ((com.tencent.mm.plugin.flutter.a.a)g.af(com.tencent.mm.plugin.flutter.a.a.class)).a((Context)getContext(), 293, (Bundle)localObject1);
        AppMethodBeat.o(252126);
        return;
      }
      paramArrayList = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, 0, 0, localRecordConfigProvider, j, 0);
      AppMethodBeat.o(252126);
      return;
    }
  }
  
  private final void am(Intent paramIntent)
  {
    AppMethodBeat.i(252128);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, paramIntent);
    AppMethodBeat.o(252128);
  }
  
  private static void avJ(String paramString)
  {
    AppMethodBeat.i(252123);
    com.tencent.f.h.RTc.aX((Runnable)new b(paramString));
    AppMethodBeat.o(252123);
  }
  
  private final String dyS()
  {
    AppMethodBeat.i(167135);
    Object localObject = this.xnQ;
    p.g(localObject, "adapter");
    int i = ((com.tencent.mm.plugin.gallery.ui.a)localObject).dRM().size();
    if (i > 0)
    {
      localObject = new StringBuilder();
      AppCompatActivity localAppCompatActivity = getContext();
      p.g(localAppCompatActivity, "context");
      localObject = localAppCompatActivity.getResources().getString(2131755916) + '(' + i + '/' + this.wnd + ')';
      AppMethodBeat.o(167135);
      return localObject;
    }
    localObject = getContext();
    p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources().getString(2131755916);
    p.g(localObject, "context.resources.getString(R.string.app_nextstep)");
    AppMethodBeat.o(167135);
    return localObject;
  }
  
  private static int dyT()
  {
    AppMethodBeat.i(252121);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sas, 300);
    Object localObject = g.ah(aj.class);
    p.g(localObject, "plugin(IPluginFinder::class.java)");
    localObject = ((aj)localObject).getFinderUtilApi();
    p.g(localObject, "plugin(IPluginFinder::class.java).finderUtilApi");
    i = Math.max(i, ((com.tencent.mm.plugin.i.a.af)localObject).dDc() - 1);
    AppMethodBeat.o(252121);
    return i;
  }
  
  private static boolean gl(int paramInt1, int paramInt2)
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
    AppMethodBeat.i(252133);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252133);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252132);
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
    AppMethodBeat.o(252132);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(252127);
    paramContext = com.tencent.mm.plugin.finder.report.i.vfo;
    paramContext = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.finder.report.i.b(com.tencent.mm.plugin.recordvideo.d.c.eKW());
    Object localObject1;
    if (paramCaptureVideoNormalModel != null)
    {
      paramContext = new Intent();
      if (this.vHf) {
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
      com.tencent.mm.ac.d.a(paramContext, paramBundle, "ORIGIN_MUSIC_ID");
      com.tencent.mm.ac.d.a(paramContext, paramBundle, "ORIGIN_MUSIC_PATH");
      com.tencent.mm.ac.d.a(paramContext, paramBundle, "ORIGIN_BGM_URL");
      com.tencent.mm.ac.d.b(paramContext, paramBundle, "MEDIA_IS_MUTE");
      com.tencent.mm.ac.d.b(paramContext, paramBundle, "MUSIC_IS_MUTE");
      com.tencent.mm.ac.d.c(paramContext, paramBundle, "SOUND_TRACK_TYPE");
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getParcelableArrayList("KEY_POST_HALF_RECT_LIST");
        if (localObject1 != null) {
          paramContext.putExtra("KEY_POST_HALF_RECT_LIST", (Serializable)localObject1);
        }
      }
      localObject1 = (ArrayList)paramCaptureVideoNormalModel.eJJ().y("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
      if ((paramCaptureVideoNormalModel.eJK() == null) || (paramCaptureVideoNormalModel.eJK().size() <= 0)) {
        break label555;
      }
      paramContext.putExtra("postType", 2);
      Object localObject2 = paramCaptureVideoNormalModel.eJK();
      p.g(localObject2, "model.multiImagePath");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        p.g(str, "it");
        ((Collection)localObject2).add(str);
      }
      paramContext.putExtra("postMediaList", (Serializable)localObject2);
      localObject2 = paramCaptureVideoNormalModel.eJK();
      p.g(localObject2, "model.multiImagePath");
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((Iterator)localObject3).next();
        ((Collection)localObject2).add(Integer.valueOf(2));
      }
      paramContext.putExtra("postTypeList", (Serializable)localObject2);
      paramContext.putExtra("postThumbList", (Serializable)j.ac(new String[] { paramCaptureVideoNormalModel.aQn() }));
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == paramCaptureVideoNormalModel.eJK().size())) {
        paramContext.putExtra("key_post_media_quality_list", (Serializable)localObject1);
      }
      com.tencent.mm.ac.d.d(paramContext, paramBundle, "KEY_POST_HALF_IMAGE_LIST");
    }
    for (;;)
    {
      paramContext.putExtra("post_id", this.postId);
      paramContext.putExtra("edit_id", (String)paramCaptureVideoNormalModel.eJJ().y("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramCaptureVideoNormalModel = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramCaptureVideoNormalModel = getIntent();
      p.g(paramCaptureVideoNormalModel, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramContext, paramCaptureVideoNormalModel);
      am(paramContext);
      AppMethodBeat.o(252127);
      return;
      label555:
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getByteArray("video_composition");
        if (paramBundle != null) {
          paramContext.putExtra("video_composition", paramBundle);
        }
      }
      paramContext.putExtra("postType", 4);
      paramContext.putExtra("postMediaList", (Serializable)j.ac(new String[] { paramCaptureVideoNormalModel.getVideoPath() }));
      paramContext.putExtra("postTypeList", (Serializable)j.ac(new Integer[] { Integer.valueOf(4) }));
      paramContext.putExtra("postThumbList", (Serializable)j.ac(new String[] { paramCaptureVideoNormalModel.aQn() }));
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
    AppMethodBeat.i(252119);
    if ((paramMediaItem instanceof GalleryItem.ImageMediaItem))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(((GalleryItem.ImageMediaItem)paramMediaItem).dRh(), localOptions);
      if (!gl(localOptions.outWidth, localOptions.outHeight))
      {
        com.tencent.mm.ui.base.h.cA((Context)this, getString(2131761135));
        AppMethodBeat.o(252119);
        return false;
      }
      AppMethodBeat.o(252119);
      return true;
    }
    AppMethodBeat.o(252119);
    return false;
  }
  
  public final boolean b(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(252120);
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      if (!gl(((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth, ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight))
      {
        com.tencent.mm.ui.base.h.cA((Context)this, getString(2131761138));
        AppMethodBeat.o(252120);
        return false;
      }
      boolean bool = a((GalleryItem.VideoMediaItem)paramMediaItem);
      if (!bool)
      {
        r.f localf = r.f.vhE;
        r.f.ai(((GalleryItem.VideoMediaItem)paramMediaItem).jkQ, ((GalleryItem.VideoMediaItem)paramMediaItem).jkR, paramMediaItem.xiW);
        com.tencent.mm.ui.base.h.cC((Context)this, getString(2131761117));
      }
      AppMethodBeat.o(252120);
      return bool;
    }
    AppMethodBeat.o(252120);
    return false;
  }
  
  public final boolean dyR()
  {
    AppMethodBeat.i(167131);
    if (this.het == 25)
    {
      Object localObject1 = this.xnQ;
      p.g(localObject1, "adapter");
      Object localObject3 = new ArrayList((Collection)((com.tencent.mm.plugin.gallery.ui.a)localObject1).dRM());
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
      for (int i = ((GalleryItem.VideoMediaItem)localObject1).jkS;; i = 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if ((((Number)com.tencent.mm.plugin.finder.storage.c.dvD().value()).intValue() != 1) || (((ArrayList)localObject3).size() != 1)) {
          break label566;
        }
        long l = i;
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (l < (com.tencent.mm.plugin.finder.storage.c.drG() + 1) * 1000L) {
          break label566;
        }
        l = i;
        localObject1 = g.ah(aj.class);
        p.g(localObject1, "plugin(IPluginFinder::class.java)");
        localObject1 = ((aj)localObject1).getFinderUtilApi();
        p.g(localObject1, "plugin(IPluginFinder::class.java).finderUtilApi");
        if ((l >= ((com.tencent.mm.plugin.i.a.af)localObject1).dDc() * 1000L) || (this.vHc)) {
          break label566;
        }
        localObject1 = new com.tencent.mm.plugin.finder.view.d((Context)getContext());
        localObject2 = ((ArrayList)localObject3).get(0);
        if (localObject2 != null) {
          break;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
        AppMethodBeat.o(167131);
        throw ((Throwable)localObject1);
      }
      localObject2 = (GalleryItem.VideoMediaItem)localObject2;
      ((com.tencent.mm.plugin.finder.view.d)localObject1).Ml(2131494567);
      Object localObject4 = (TextView)((com.tencent.mm.plugin.finder.view.d)localObject1).lJI.findViewById(2131299657);
      if (localObject4 != null) {
        ao.a((Paint)((TextView)localObject4).getPaint(), 0.8F);
      }
      localObject4 = ((com.tencent.mm.plugin.finder.view.d)localObject1).lJI.findViewById(2131299640);
      if (localObject4 != null) {
        ((View)localObject4).setOnClickListener((View.OnClickListener)new g((com.tencent.mm.plugin.finder.view.d)localObject1));
      }
      localObject4 = ((com.tencent.mm.plugin.finder.view.d)localObject1).lJI.findViewById(2131303826);
      if (localObject4 != null) {
        ((View)localObject4).setOnClickListener((View.OnClickListener)new d((com.tencent.mm.plugin.finder.view.d)localObject1, (GalleryItem.VideoMediaItem)localObject2, this, (ArrayList)localObject3));
      }
      localObject2 = ((com.tencent.mm.plugin.finder.view.d)localObject1).lJI.findViewById(2131307852);
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new e((com.tencent.mm.plugin.finder.view.d)localObject1, this, (ArrayList)localObject3));
      }
      ((com.tencent.mm.plugin.finder.view.d)localObject1).a((d.a)new f(this, (ArrayList)localObject3));
      ((com.tencent.mm.plugin.finder.view.d)localObject1).dGm();
      localObject1 = com.tencent.mm.plugin.finder.report.af.viA;
      localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
      localObject1 = com.tencent.mm.plugin.finder.report.i.dnX();
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
      localObject2 = com.tencent.mm.plugin.finder.report.i.vfo;
      localObject2 = com.tencent.mm.plugin.finder.report.i.dnX();
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
      com.tencent.mm.plugin.finder.report.af.j((String)localObject1, (String)localObject2, cl.aWA() / 1000L);
      for (;;)
      {
        AppMethodBeat.o(167131);
        return true;
        label566:
        localObject1 = m.Gyi;
        m.fAZ();
        ak((ArrayList)localObject3);
      }
    }
    AppMethodBeat.o(167131);
    return false;
  }
  
  public final void g(int paramInt, View paramView)
  {
    AppMethodBeat.i(167136);
    p.h(paramView, "itemView");
    paramView = this.xnQ.NK(paramInt);
    if ((paramView == null) || (Util.isNullOrNil(paramView.dRh())))
    {
      if (paramView == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("Finder.AlbumUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(167136);
        return;
      }
    }
    if (this.het == 25)
    {
      if ((paramView instanceof GalleryItem.VideoMediaItem))
      {
        paramInt = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sas, 300);
        localObject = g.ah(aj.class);
        p.g(localObject, "plugin(IPluginFinder::class.java)");
        localObject = ((aj)localObject).getFinderUtilApi();
        p.g(localObject, "plugin(IPluginFinder::class.java).finderUtilApi");
        paramInt = Math.max(paramInt, ((com.tencent.mm.plugin.i.a.af)localObject).dDc());
        int i = dyT();
        this.vHg = ((GalleryItem.VideoMediaItem)paramView).jkS;
        localObject = ((GalleryItem.VideoMediaItem)paramView).dRh();
        p.g(localObject, "item.originalPath");
        this.vHh = ((String)localObject);
        int j = ((GalleryItem.VideoMediaItem)paramView).jkS;
        localObject = com.tencent.mm.modelcontrol.e.baZ();
        p.g(localObject, "SubCoreVideoControl.getCore()");
        if (j < ((com.tencent.mm.modelcontrol.e)localObject).bbf().minDuration * 1000)
        {
          paramView = (Context)getContext();
          localObject = getResources();
          com.tencent.mm.modelcontrol.e locale = com.tencent.mm.modelcontrol.e.baZ();
          p.g(locale, "SubCoreVideoControl.getCore()");
          com.tencent.mm.ui.base.h.c(paramView, ((Resources)localObject).getString(2131761151, new Object[] { Integer.valueOf(locale.bbf().minDuration) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        if (((GalleryItem.VideoMediaItem)paramView).jkS > paramInt * 1000)
        {
          com.tencent.mm.ui.base.h.c((Context)getContext(), getResources().getString(2131761152, new Object[] { Integer.valueOf(i) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        Log.i("Finder.AlbumUI", "onMediaClick, video mime:" + ((GalleryItem.VideoMediaItem)paramView).jkQ + ", audio mime:" + ((GalleryItem.VideoMediaItem)paramView).jkR + ", path:" + paramView.xiW);
        if (!a((GalleryItem.VideoMediaItem)paramView))
        {
          localObject = r.f.vhE;
          r.f.ai(((GalleryItem.VideoMediaItem)paramView).jkQ, ((GalleryItem.VideoMediaItem)paramView).jkR, paramView.xiW);
          paramView = new f.a((Context)getContext());
          paramView.aC((CharSequence)com.tencent.mm.cb.a.aI((Context)getContext(), 2131761117));
          paramView.boA(com.tencent.mm.cb.a.aI((Context)getContext(), 2131761094));
          paramView.b((f.c)c.vHj);
          paramView.show();
          AppMethodBeat.o(167136);
          return;
        }
        new ArrayList(1).add(paramView);
        localObject = this.xnQ.NJ(((GalleryItem.VideoMediaItem)paramView).getType());
        com.tencent.mm.plugin.gallery.model.e.ao((ArrayList)localObject);
        Lk(((ArrayList)localObject).indexOf(paramView));
        AppMethodBeat.o(167136);
        return;
      }
      Object localObject = this.xnQ.NJ(paramView.getType());
      com.tencent.mm.plugin.gallery.model.e.ao((ArrayList)localObject);
      Lk(((ArrayList)localObject).indexOf(paramView));
    }
    AppMethodBeat.o(167136);
  }
  
  public final void initView()
  {
    boolean bool = false;
    AppMethodBeat.i(167134);
    super.initView();
    removeOptionMenu(0);
    getController().Bi(true);
    addTextOptionMenu(0, dyS(), this.xow, null, t.b.OHf);
    Object localObject = this.xnM;
    p.g(localObject, "gallery");
    ((RecyclerView)localObject).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    NM(0);
    localObject = (CharSequence)getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bool = true;
      }
      this.vHc = bool;
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
        paramIntent = this.xnQ;
        p.g(paramIntent, "adapter");
        paramIntent.dRM().clear();
        this.xnQ.notifyDataSetChanged();
        NM(0);
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
      if ((localObject1 != null) && (this.xnQ != null))
      {
        this.xnQ.aq((ArrayList)localObject1);
        this.xnQ.notifyDataSetChanged();
        NM(((ArrayList)localObject1).size());
      }
      dyR();
      AppMethodBeat.o(167137);
      return;
    }
    if ((291 == paramInt1) && (paramInt2 == -1))
    {
      localObject1 = new ArrayList(1);
      if (paramIntent == null) {
        p.hyc();
      }
      paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      p.g(paramIntent, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
      localObject2 = new GalleryItem.VideoMediaItem();
      ((GalleryItem.VideoMediaItem)localObject2).xiW = paramIntent.getVideoPath();
      ((GalleryItem.VideoMediaItem)localObject2).sUB = paramIntent.aQn();
      ((GalleryItem.VideoMediaItem)localObject2).jkS = ((int)paramIntent.eJH().longValue());
      ((ArrayList)localObject1).add(localObject2);
      paramInt1 = this.vHg;
      localObject2 = this.vHh;
      paramIntent = new Intent();
      paramIntent.putExtra("fromAppBrand", getIntent().getBooleanExtra("fromAppBrand", false));
      paramIntent.putParcelableArrayListExtra("select_path_list", (ArrayList)localObject1);
      paramIntent.putParcelableArrayListExtra("front_vlog_video", null);
      paramIntent.putExtra("select_video_path", (String)localObject2);
      paramIntent.putExtra("select_video_duration", paramInt1);
      paramIntent.setClass((Context)getContext(), FinderMediaCropUI.class);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject1 = getIntent();
      p.g(localObject1, "getIntent()");
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
      paramIntent = CaptureDataManager.BOb;
      p.g(paramIntent, "CaptureDataManager.INSTANCE");
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
    com.tencent.mm.plugin.finder.report.i locali = com.tencent.mm.plugin.finder.report.i.vfo;
    com.tencent.mm.plugin.finder.report.i.Ks(3);
    AppMethodBeat.o(167133);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252117);
    super.onCreate(paramBundle);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soL, 0);
    this.vHe = getIntent().getBooleanExtra("KEY_FINDER_POST_FORM_FLUTTER", false);
    if (!this.vHe)
    {
      paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
      if ((((Number)com.tencent.mm.plugin.finder.storage.c.dxh().value()).intValue() != 1) && (i != 1)) {
        break label211;
      }
    }
    label211:
    for (boolean bool = true;; bool = false)
    {
      this.vHe = bool;
      Log.i("Finder.AlbumUI", "openFlutterVideoEditor %d startActivityFromFlutter:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.vHe) });
      String str = getIntent().getStringExtra("key_finder_post_id");
      paramBundle = str;
      if (str == null)
      {
        paramBundle = new StringBuilder();
        p.g(g.aAf(), "MMKernel.account()");
        paramBundle = com.tencent.mm.kernel.a.ayV() + '_' + Util.nowMilliSecond();
      }
      this.postId = paramBundle;
      this.vHf = getIntent().getBooleanExtra("album_from_finder_add_media", false);
      paramBundle = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.auH(this.postId);
      AppMethodBeat.o(252117);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252125);
    CaptureDataManager.BOb.a(null);
    super.onDestroy();
    AppMethodBeat.o(252125);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(252118);
    super.onStart();
    if (this.vHe) {
      ((com.tencent.mm.plugin.flutter.a.a)g.af(com.tencent.mm.plugin.flutter.a.a.class)).dLp();
    }
    AppMethodBeat.o(252118);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    AppMethodBeat.i(167132);
    super.updateOptionMenuText(paramInt, dyS());
    AppMethodBeat.o(167132);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI$Companion;", "", "()V", "DOUBLE_CLICK_CHECK_INTERVAL", "", "FLUTTER_TAG", "", "REQUEST_CODE_EDIT_VIDEO", "", "REQUEST_CODE_EDIT_VLOG", "REQUEST_CODE_EDIT_VLOG_FLUTTER", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(252112);
      Object localObject1 = MultiMediaVideoChecker.GyY.cA(this.lCM, true);
      Object localObject2;
      int i;
      if ((localObject1 == null) || (((MultiMediaVideoChecker.a)localObject1).pixelFormat != -1))
      {
        localObject2 = MultiMediaVideoChecker.GyY;
        if (localObject1 == null) {
          break label97;
        }
        i = ((MultiMediaVideoChecker.a)localObject1).pixelFormat;
        if (!MultiMediaVideoChecker.acy(i))
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
        localObject1 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.fCk();
        AppMethodBeat.o(252112);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements f.c
  {
    public static final c vHj;
    
    static
    {
      AppMethodBeat.i(167130);
      vHj = new c();
      AppMethodBeat.o(167130);
    }
    
    public final void e(boolean paramBoolean, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$3"})
  static final class d
    implements View.OnClickListener
  {
    d(com.tencent.mm.plugin.finder.view.d paramd, GalleryItem.VideoMediaItem paramVideoMediaItem, FinderAlbumUI paramFinderAlbumUI, ArrayList paramArrayList) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252113);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (FinderAlbumUI.a(jdField_this))
      {
        Log.i("Finder.AlbumUI", "onSendItemClick: long video btn hit double click check");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252113);
        return;
      }
      float f = this.vHk.videoHeight / this.vHk.videoWidth;
      paramView = g.ah(aj.class);
      p.g(paramView, "plugin(IPluginFinder::class.java)");
      paramView = ((aj)paramView).getFinderUtilApi();
      p.g(paramView, "plugin(IPluginFinder::class.java).finderUtilApi");
      if (f <= paramView.dDd())
      {
        paramView = g.ah(aj.class);
        p.g(paramView, "plugin(IPluginFinder::class.java)");
        paramView = ((aj)paramView).getFinderUtilApi();
        p.g(paramView, "plugin(IPluginFinder::class.java).finderUtilApi");
        if (f >= paramView.dDe()) {}
      }
      else
      {
        u.makeText((Context)jdField_this.getContext(), 2131761119, 0).show();
        FinderAlbumUI.a(jdField_this, true);
        this.tru.bMo();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252113);
        return;
      }
      FinderAlbumUI.a(jdField_this, true);
      this.tru.bMo();
      paramView = new Intent();
      paramView.putExtra("post_id", FinderAlbumUI.c(jdField_this));
      paramView.putExtra("postType", 4);
      paramView.putExtra("postMediaList", (Serializable)j.ac(new String[] { this.vHk.dRh() }));
      paramView.putExtra("postTypeList", (Serializable)j.ac(new Integer[] { Integer.valueOf(4) }));
      paramView.putExtra("isLongVideoPost", true);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject = jdField_this.getIntent();
      p.g(localObject, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramView, (Intent)localObject);
      FinderAlbumUI.a(jdField_this, paramView);
      paramView = com.tencent.mm.plugin.finder.report.af.viA;
      paramView = com.tencent.mm.plugin.finder.report.i.vfo;
      paramView = com.tencent.mm.plugin.finder.report.i.dnX();
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
      localObject = com.tencent.mm.plugin.finder.report.i.vfo;
      localObject = com.tencent.mm.plugin.finder.report.i.dnX();
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
      com.tencent.mm.plugin.finder.report.af.a(paramView, (String)localObject, 2, cl.aWA() / 1000L, 2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252113);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$4"})
  static final class e
    implements View.OnClickListener
  {
    e(com.tencent.mm.plugin.finder.view.d paramd, FinderAlbumUI paramFinderAlbumUI, ArrayList paramArrayList) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252114);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (FinderAlbumUI.a(jdField_this))
      {
        Log.i("Finder.AlbumUI", "onSendItemClick: short video btn hit double click check");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252114);
        return;
      }
      FinderAlbumUI.a(jdField_this, true);
      this.tru.bMo();
      FinderAlbumUI.a(jdField_this, this.vHm);
      paramView = com.tencent.mm.plugin.finder.report.af.viA;
      paramView = com.tencent.mm.plugin.finder.report.i.vfo;
      paramView = com.tencent.mm.plugin.finder.report.i.dnX();
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
      localObject = com.tencent.mm.plugin.finder.report.i.vfo;
      localObject = com.tencent.mm.plugin.finder.report.i.dnX();
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
      com.tencent.mm.plugin.finder.report.af.a(paramView, (String)localObject, 2, cl.aWA() / 1000L, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252114);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$5"})
  static final class f
    implements d.a
  {
    f(FinderAlbumUI paramFinderAlbumUI, ArrayList paramArrayList) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(252115);
      if (FinderAlbumUI.b(this.vHl))
      {
        FinderAlbumUI.a(this.vHl, false);
        AppMethodBeat.o(252115);
        return;
      }
      Object localObject1 = com.tencent.mm.plugin.finder.report.af.viA;
      localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
      localObject1 = com.tencent.mm.plugin.finder.report.i.dnX();
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
      Object localObject2 = com.tencent.mm.plugin.finder.report.i.vfo;
      localObject2 = com.tencent.mm.plugin.finder.report.i.dnX();
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
      com.tencent.mm.plugin.finder.report.af.a((String)localObject1, (String)localObject2, 2, cl.aWA() / 1000L, 3);
      AppMethodBeat.o(252115);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(com.tencent.mm.plugin.finder.view.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252116);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tru.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderAlbumUI$onSendItemClick$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderAlbumUI
 * JD-Core Version:    0.7.0.1
 */