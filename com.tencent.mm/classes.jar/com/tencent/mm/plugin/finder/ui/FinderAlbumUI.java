package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.g;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.b;
import com.tencent.threadpool.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "clickTimestamp", "", "isFolloPat", "", "isFromFinderAddMedia", "isHideAfterClick", "originalVideoDuration", "", "originalVideoPath", "", "pageInTimeStamp", "postId", "startActivityFromFlutter", "checkFinderVideoItemFormatValid", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "checkMediaRatio", "width", "height", "checkMiaojianVideo", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "checkSelectedImage", "checkSelectedVideo", "checkVideoPixelFormat", "path", "continuePost", "doEnterMJTemplatePreviewUI", "doEnterMMRecordVLogUI", "doubleClickCheck", "enterFinderMediaCropUI", "vlogVideo", "enterFinderPostUI", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getFinderAlbumProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getMaxDurationSec", "getMaxDurationSecTip", "getMenuText", "initView", "isAllPathIsImage", "jumpImagePreviewUI", "mediaPosition", "onActivityResult", "requestCode", "resultCode", "data", "onBackBtnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaClick", "position", "itemView", "Landroid/view/View;", "itemViewType", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onResume", "onSendItemClick", "onStart", "refreshMaasPermissionTips", "visible", "requestMaasPermission", "setupFinderSelectVideoRestriction", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "updateOptionMenuText", "menuID", "text", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAlbumUI
  extends AlbumPreviewUI
  implements CaptureDataManager.b
{
  public static final FinderAlbumUI.a FOm;
  private long ETJ;
  private boolean FOn;
  private boolean FOo;
  private boolean FOp;
  private boolean FOq;
  private int FOr;
  private String FOs = "";
  private String postId = "";
  private long sXL;
  
  static
  {
    AppMethodBeat.i(167139);
    FOm = new FinderAlbumUI.a((byte)0);
    AppMethodBeat.o(167139);
  }
  
  private final void TB(int paramInt)
  {
    AppMethodBeat.i(347269);
    Intent localIntent = new Intent((Context)this, ImagePreviewUI.class);
    localIntent.putStringArrayListExtra("preview_image_list", this.HMh.fBk());
    localIntent.putParcelableArrayListExtra("preview_media_item_list", this.HMh.HLB);
    localIntent.putExtra("preview_all", true);
    localIntent.putExtra("preview_position", paramInt);
    bc(paramInt, true);
    localIntent.putExtra("send_raw_img", this.wQK);
    localIntent.putExtra("key_force_hide_edit_image_button", true);
    localIntent.putExtra("max_select_count", this.GzH);
    localIntent.putExtra("GalleryUI_FromUser", this.hQQ);
    localIntent.putExtra("GalleryUI_ToUser", this.toUser);
    localIntent.putExtra("album_business_tag", this.HLD);
    localIntent.putExtra("album_video_max_duration", Math.max(this.qqa, faH()));
    localIntent.putExtra("album_video_min_duration", this.HMI);
    localIntent.putExtra("media_type", 2);
    localIntent.putExtra("key_support_max_ratio", 3.0F);
    if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 14) {
      localIntent.putExtra("key_edit_video_max_time_length", 300500);
    }
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(347269);
  }
  
  private static final void a(FinderAlbumUI paramFinderAlbumUI)
  {
    AppMethodBeat.i(347352);
    s.u(paramFinderAlbumUI, "this$0");
    if (paramFinderAlbumUI.FOo)
    {
      paramFinderAlbumUI.FOo = false;
      AppMethodBeat.o(347352);
      return;
    }
    paramFinderAlbumUI = ax.Fur;
    paramFinderAlbumUI = v.FrN;
    paramFinderAlbumUI = v.eMS();
    Object localObject;
    if (paramFinderAlbumUI == null)
    {
      paramFinderAlbumUI = "";
      localObject = v.FrN;
      localObject = v.eMS();
      if (localObject != null) {
        break label104;
      }
      localObject = "";
    }
    for (;;)
    {
      ax.a(paramFinderAlbumUI, (String)localObject, 2, com.tencent.mm.model.cn.bDw() / 1000L, 3);
      AppMethodBeat.o(347352);
      return;
      localObject = paramFinderAlbumUI.clickId;
      paramFinderAlbumUI = (FinderAlbumUI)localObject;
      if (localObject != null) {
        break;
      }
      paramFinderAlbumUI = "";
      break;
      label104:
      String str = ((FinderFeedReportObject)localObject).postId;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  private static final void a(FinderAlbumUI paramFinderAlbumUI, View paramView)
  {
    AppMethodBeat.i(347370);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderAlbumUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderAlbumUI, "this$0");
    paramFinderAlbumUI.faF();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347370);
  }
  
  private static final void a(FinderAlbumUI paramFinderAlbumUI, com.tencent.mm.plugin.finder.view.d paramd, GalleryItem.VideoMediaItem paramVideoMediaItem, View paramView)
  {
    AppMethodBeat.i(347336);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderAlbumUI);
    localb.cH(paramd);
    localb.cH(paramVideoMediaItem);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderAlbumUI, "this$0");
    s.u(paramd, "$this_apply");
    s.u(paramVideoMediaItem, "$item");
    if (paramFinderAlbumUI.faE())
    {
      Log.i("Finder.AlbumUI", "onSendItemClick: long video btn hit double click check");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347336);
      return;
    }
    paramFinderAlbumUI.FOo = true;
    paramd.cyW();
    paramd = FinderPostRouterUI.FSQ;
    FinderPostRouterUI.a.a((Context)paramFinderAlbumUI, paramFinderAlbumUI.getIntent(), paramVideoMediaItem.Gcc, paramVideoMediaItem.videoWidth, paramVideoMediaItem.videoHeight, paramFinderAlbumUI.postId, true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347336);
  }
  
  private static final void a(FinderAlbumUI paramFinderAlbumUI, com.tencent.mm.plugin.finder.view.d paramd, ArrayList paramArrayList, View paramView)
  {
    AppMethodBeat.i(347343);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderAlbumUI);
    localb.cH(paramd);
    localb.cH(paramArrayList);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderAlbumUI, "this$0");
    s.u(paramd, "$this_apply");
    s.u(paramArrayList, "$list");
    if (paramFinderAlbumUI.faE())
    {
      Log.i("Finder.AlbumUI", "onSendItemClick: short video btn hit double click check");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347343);
      return;
    }
    paramFinderAlbumUI.FOo = true;
    paramd.cyW();
    paramFinderAlbumUI.az(paramArrayList);
    paramFinderAlbumUI = ax.Fur;
    paramFinderAlbumUI = v.FrN;
    paramFinderAlbumUI = v.eMS();
    if (paramFinderAlbumUI == null)
    {
      paramFinderAlbumUI = "";
      paramd = v.FrN;
      paramd = v.eMS();
      if (paramd != null) {
        break label244;
      }
      paramd = "";
    }
    for (;;)
    {
      ax.a(paramFinderAlbumUI, paramd, 2, com.tencent.mm.model.cn.bDw() / 1000L, 1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347343);
      return;
      paramd = paramFinderAlbumUI.clickId;
      paramFinderAlbumUI = paramd;
      if (paramd != null) {
        break;
      }
      paramFinderAlbumUI = "";
      break;
      label244:
      paramArrayList = paramd.postId;
      paramd = paramArrayList;
      if (paramArrayList == null) {
        paramd = "";
      }
    }
  }
  
  private static final void a(final ArrayList paramArrayList, com.tencent.mm.plugin.findersdk.b.b paramb, final FinderAlbumUI paramFinderAlbumUI)
  {
    AppMethodBeat.i(347362);
    s.u(paramArrayList, "$list");
    s.u(paramb, "$loading");
    s.u(paramFinderAlbumUI, "this$0");
    final String str2 = ((GalleryItem.MediaItem)paramArrayList.get(0)).Gcc;
    final kotlin.g.b.ah.f localf = new kotlin.g.b.ah.f();
    try
    {
      localf.aqH = f.aVZ(str2);
      JSONObject localJSONObject = (JSONObject)localf.aqH;
      if (localJSONObject == null)
      {
        localJSONObject = null;
        Log.i("Finder.AlbumUI", s.X("metadata:", localJSONObject));
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramb, localf, str2, paramFinderAlbumUI, paramArrayList));
        AppMethodBeat.o(347362);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.w("Finder.AlbumUI", "getVideoInfo failed.");
        continue;
        String str1 = localObject.toString();
      }
    }
  }
  
  private static boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(347253);
    String str = paramVideoMediaItem.Gcc;
    s.s(str, "item.originalPath");
    aAW(str);
    boolean bool = com.tencent.mm.plugin.gallery.b.b.HQZ.b(25, (GalleryItem.MediaItem)paramVideoMediaItem);
    AppMethodBeat.o(347253);
    return bool;
  }
  
  private final RecordConfigProvider aA(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(347307);
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("media_list", paramArrayList);
    localBundle.putString("FINDER_CONTEXT_ID", getIntent().getStringExtra("key_finder_context_id"));
    localBundle.putString("FINDER_SESSION_ID", getIntent().getStringExtra("key_finder_session_id"));
    localBundle.putString("post_id", this.postId);
    localBundle.putString("KEY_ORIGIN_MUSIC_ID", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID"));
    localBundle.putString("KEY_ORIGIN_BGM_URL", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_BGM_URL"));
    localBundle.putString("KEY_ORIGIN_MUSIC_PATH", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_PATH"));
    localBundle.putString("KEY_ORIGIN_MUSIC_NAME", getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_NAME"));
    localBundle.putByteArray("KEY_ORIGIN_MUSIC_INFO", getIntent().getByteArrayExtra("KEY_FINDER_POST_ORIGIN_MUSIC_INFO"));
    localBundle.putBoolean("KEY_BGM_IF_ORIGIN", getIntent().getBooleanExtra("KEY_FINDER_POST_BGM_IF_ORIGIN", false));
    localBundle.putBoolean("KEY_FULLSCREEN", true);
    localBundle.putInt("KEY_MEDIA_SOURCE_FROM", 1);
    paramArrayList = com.tencent.mm.ui.aw.bf((Context)this);
    Object localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    localObject = getBaseContext();
    s.s(localObject, "baseContext");
    paramArrayList = com.tencent.mm.plugin.finder.utils.aw.i((Context)localObject, paramArrayList.x, paramArrayList.y);
    paramArrayList = new Point(((Number)paramArrayList.bsD).intValue(), ((Number)paramArrayList.aiuN).intValue());
    localBundle.putInt("KEY_PREVIEW_WIDTH", paramArrayList.x);
    localBundle.putInt("KEY_PREVIEW_HEIGHT", paramArrayList.y);
    paramArrayList = com.tencent.mm.plugin.finder.storage.d.FAy;
    localBundle.putLong("video_max_duration", com.tencent.mm.plugin.finder.storage.d.eRl() * 1000L);
    paramArrayList = com.tencent.mm.plugin.finder.storage.d.FAy;
    localBundle.putInt("image_max_height", com.tencent.mm.plugin.finder.storage.d.eQp());
    paramArrayList = com.tencent.mm.plugin.finder.storage.d.FAy;
    localBundle.putInt("image_max_width", com.tencent.mm.plugin.finder.storage.d.eQo());
    paramArrayList = com.tencent.mm.plugin.finder.storage.d.FAy;
    localBundle.putInt("image_compress_quality", com.tencent.mm.plugin.finder.storage.d.eQq());
    paramArrayList = bm.GlZ;
    localBundle.putString("output_dir", bm.fit());
    paramArrayList = com.tencent.mm.plugin.finder.ui.edit.a.FXw;
    paramArrayList = com.tencent.mm.plugin.finder.ui.edit.a.fcN();
    paramArrayList.oSS = localBundle;
    AppMethodBeat.o(347307);
    return paramArrayList;
  }
  
  private static void aAW(String paramString)
  {
    AppMethodBeat.i(347259);
    com.tencent.threadpool.h.ahAA.bm(new FinderAlbumUI..ExternalSyntheticLambda6(paramString));
    AppMethodBeat.o(347259);
  }
  
  private static final void aAX(String paramString)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(347381);
    s.u(paramString, "$path");
    paramString = MultiMediaVideoChecker.ObB.cI(paramString, true);
    if ((paramString != null) && (paramString.pixelFormat == -1)) {
      if (i == 0)
      {
        MultiMediaVideoChecker localMultiMediaVideoChecker = MultiMediaVideoChecker.ObB;
        if (paramString != null) {
          break label97;
        }
        i = j;
        label52:
        if (!MultiMediaVideoChecker.ahd(i)) {
          if (paramString != null) {
            break label105;
          }
        }
      }
    }
    label97:
    label105:
    for (paramString = null;; paramString = Integer.valueOf(paramString.pixelFormat))
    {
      Log.i("Finder.AlbumUI", s.X("select invalid pixelFormat video:", paramString));
      paramString = com.tencent.mm.plugin.vlog.model.report.a.Uch;
      com.tencent.mm.plugin.vlog.model.report.a.hRQ();
      AppMethodBeat.o(347381);
      return;
      i = 0;
      break;
      i = paramString.pixelFormat;
      break label52;
    }
  }
  
  private final void aJ(Intent paramIntent)
  {
    AppMethodBeat.i(347314);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, paramIntent);
    AppMethodBeat.o(347314);
  }
  
  private static final void ab(boolean paramBoolean, String paramString) {}
  
  private final void ay(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(347216);
    m localm = m.TYW;
    m.hQv();
    az(paramArrayList);
    AppMethodBeat.o(347216);
  }
  
  private final void az(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(347290);
    Object localObject1 = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
    localObject1 = v.FrN;
    localObject1 = v.eMS();
    label54:
    int i;
    label87:
    label91:
    label98:
    int j;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a((String)localObject1, com.tencent.mm.plugin.finder.report.postreport.b.eOg());
      localObject2 = ((Iterable)paramArrayList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label265;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((GalleryItem.MediaItem)localObject1).getType() != 2) {
        break label260;
      }
      i = 1;
      if (i == 0) {
        break label263;
      }
      if (localObject1 != null) {
        break label271;
      }
      i = 1;
      localObject1 = aA(paramArrayList);
      if (i == 0) {
        break label276;
      }
      j = 3;
      label111:
      CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)this);
      if ((!this.FOp) || (i != 0)) {
        break label379;
      }
      paramArrayList = ((RecordConfigProvider)localObject1).oSS;
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      localObject3 = paramArrayList.getParcelableArrayList("media_list");
      if ((!this.FOp) || (localObject3 == null)) {
        break label301;
      }
      localObject3 = ((ArrayList)localObject3).iterator();
      label184:
      if (!((Iterator)localObject3).hasNext()) {
        break label301;
      }
      localObject4 = (GalleryItem.MediaItem)((Iterator)localObject3).next();
      if (!(localObject4 instanceof GalleryItem.VideoMediaItem)) {
        break label281;
      }
      ((ArrayList)localObject2).add("video");
    }
    for (;;)
    {
      ((ArrayList)localObject1).add(((GalleryItem.MediaItem)localObject4).Gcc);
      break label184;
      localObject2 = ((FinderFeedReportObject)localObject1).flowId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label260:
      i = 0;
      break label87;
      label263:
      break label54;
      label265:
      localObject1 = null;
      break label91;
      label271:
      i = 0;
      break label98;
      label276:
      j = 4;
      break label111;
      label281:
      if ((localObject4 instanceof GalleryItem.ImageMediaItem)) {
        ((ArrayList)localObject2).add("image");
      }
    }
    label301:
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1565, 0);
    Log.i("Finder.AlbumUI.FlutterVideoEditor_DataReport", "click next step in album activity");
    paramArrayList.putStringArrayList("pathList", (ArrayList)localObject1);
    paramArrayList.putStringArrayList("typeList", (ArrayList)localObject2);
    paramArrayList.putString("postId", this.postId);
    ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.a.a.class)).h((Context)getContext(), paramArrayList);
    AppMethodBeat.o(347290);
    return;
    label379:
    if ((this.FOn) || (!((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig().bxh()) || (!((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getMaasPermissionChecker().HC("scene_finder")))
    {
      paramArrayList = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, 0, 0, (RecordConfigProvider)localObject1, j, 0);
      AppMethodBeat.o(347290);
      return;
    }
    Object localObject2 = (com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class);
    Object localObject3 = (Activity)this;
    paramArrayList = (List)paramArrayList;
    Object localObject4 = new Intent();
    as.a locala = as.GSQ;
    as.a.a((Context)this, (Intent)localObject4, 0L, 0, false, 124);
    ((Intent)localObject4).putExtra("KEY_PARAMS_CONFIG", (Parcelable)localObject1);
    ((Intent)localObject4).putExtra("KEY_PARAMS_TO_WHERE", j);
    ((Intent)localObject4).putExtra("KEY_PARAMS_EXIT_ANIM", 0);
    ((Intent)localObject4).putExtra("KEY_PARAMS_SELECTED_BIZ_INT", 0);
    localObject1 = ah.aiuX;
    ((com.tencent.mm.mj_template.api.d)localObject2).enterMultiTemplatePreviewUI((Activity)localObject3, 294, paramArrayList, (Intent)localObject4);
    AppMethodBeat.o(347290);
  }
  
  private final boolean faE()
  {
    AppMethodBeat.i(347224);
    boolean bool = false;
    if (System.currentTimeMillis() - this.sXL < 1000L) {
      bool = true;
    }
    this.sXL = System.currentTimeMillis();
    AppMethodBeat.o(347224);
    return bool;
  }
  
  private final void faF()
  {
    AppMethodBeat.i(347230);
    ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getMaasPermissionChecker().a("scene_finder", (Context)this, (kotlin.g.a.a)new FinderAlbumUI.c(this), (kotlin.g.a.b)new FinderAlbumUI.d(this));
    AppMethodBeat.o(347230);
  }
  
  private final String faG()
  {
    AppMethodBeat.i(167135);
    int i = this.HMh.HLB.size();
    if (i > 0)
    {
      str = getContext().getResources().getString(l.i.app_nextstep) + '(' + i + '/' + this.GzH + ')';
      AppMethodBeat.o(167135);
      return str;
    }
    String str = getContext().getResources().getString(l.i.app_nextstep);
    s.s(str, "context.resources.getString(R.string.app_nextstep)");
    AppMethodBeat.o(167135);
    return str;
  }
  
  private static int faH()
  {
    AppMethodBeat.i(347247);
    int i = Math.max(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXN, 300), ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgA() - 1);
    AppMethodBeat.o(347247);
    return i;
  }
  
  private static boolean in(int paramInt1, int paramInt2)
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
  
  private static final void j(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(347322);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "$this_apply");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347322);
  }
  
  private final void ue(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(347235);
    Object localObject = (LinearLayout)findViewById(l.e.template_hint_ll);
    if (paramBoolean)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      ((TextView)findViewById(l.e.template_hint_tv)).setText(l.i.gallery_album_template_permission_tips);
      localObject = (TextView)findViewById(l.e.template_request_permission);
      if (!paramBoolean) {
        break label98;
      }
    }
    label98:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      ((TextView)localObject).setOnClickListener(new FinderAlbumUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(347235);
      return;
      i = 8;
      break;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(347562);
    paramContext = v.FrN;
    paramContext = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    v.b(com.tencent.mm.plugin.recordvideo.f.c.gJe());
    Object localObject1;
    if (paramCaptureVideoNormalModel != null)
    {
      paramContext = new Intent();
      if (this.FOq) {
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
      localObject1 = (ArrayList)paramCaptureVideoNormalModel.gHE().J("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
      if ((paramCaptureVideoNormalModel.NHM == null) || (paramCaptureVideoNormalModel.NHM.size() <= 0)) {
        break label551;
      }
      paramContext.putExtra("postType", 2);
      Object localObject2 = paramCaptureVideoNormalModel.NHM;
      s.s(localObject2, "model.multiImagePath");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add((String)((Iterator)localObject3).next());
      }
      paramContext.putExtra("postMediaList", (Serializable)localObject2);
      localObject2 = paramCaptureVideoNormalModel.NHM;
      s.s(localObject2, "model.multiImagePath");
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((Iterator)localObject3).next();
        ((Collection)localObject2).add(Integer.valueOf(2));
      }
      paramContext.putExtra("postTypeList", (Serializable)localObject2);
      paramContext.putExtra("postThumbList", (Serializable)p.al(new String[] { paramCaptureVideoNormalModel.thumbPath }));
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == paramCaptureVideoNormalModel.NHM.size())) {
        paramContext.putExtra("key_post_media_quality_list", (Serializable)localObject1);
      }
      com.tencent.mm.ae.d.d(paramContext, paramBundle, "KEY_POST_HALF_IMAGE_LIST");
    }
    for (;;)
    {
      paramContext.putExtra("post_id", this.postId);
      paramContext.putExtra("edit_id", (String)paramCaptureVideoNormalModel.gHE().J("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramCaptureVideoNormalModel = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramCaptureVideoNormalModel = getIntent();
      s.s(paramCaptureVideoNormalModel, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramContext, paramCaptureVideoNormalModel);
      aJ(paramContext);
      AppMethodBeat.o(347562);
      return;
      label551:
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getByteArray("video_composition");
        if (paramBundle != null) {
          paramContext.putExtra("video_composition", paramBundle);
        }
      }
      paramContext.putExtra("postType", 4);
      paramContext.putExtra("postMediaList", (Serializable)p.al(new String[] { paramCaptureVideoNormalModel.videoPath }));
      paramContext.putExtra("postTypeList", (Serializable)p.al(new Integer[] { Integer.valueOf(4) }));
      paramContext.putExtra("postThumbList", (Serializable)p.al(new String[] { paramCaptureVideoNormalModel.thumbPath }));
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
    AppMethodBeat.i(347507);
    if ((paramMediaItem instanceof GalleryItem.ImageMediaItem))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(((GalleryItem.ImageMediaItem)paramMediaItem).Gcc, localOptions);
      if (!in(localOptions.outWidth, localOptions.outHeight))
      {
        com.tencent.mm.ui.base.k.a((Context)this, getString(l.i.gallery_select_pic_ratio_not_support), "", getString(l.i.app_i_know), false, null);
        AppMethodBeat.o(347507);
        return false;
      }
      AppMethodBeat.o(347507);
      return true;
    }
    AppMethodBeat.o(347507);
    return false;
  }
  
  public final boolean b(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(347516);
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      Object localObject;
      if (getIntent().getBooleanExtra("key_filter_hdr_video", false))
      {
        localObject = com.tencent.mm.plugin.gallery.b.e.HRe;
        localObject = ((GalleryItem.VideoMediaItem)paramMediaItem).Gcc;
        s.s(localObject, "item.getOriginalPath()");
        if (!com.tencent.mm.plugin.gallery.b.e.aFe((String)localObject))
        {
          com.tencent.mm.ui.base.k.cY((Context)this, getString(l.i.gallery_select_video_not_support_hdr));
          AppMethodBeat.o(347516);
          return false;
        }
      }
      int i = getIntent().getIntExtra("key_max_video_duration", 0);
      if ((i > 0) && (com.tencent.mm.plugin.gallery.b.h.aFh(((GalleryItem.VideoMediaItem)paramMediaItem).Gcc) > i))
      {
        com.tencent.mm.ui.base.k.cY((Context)this, getString(b.i.gallery_select_video_to_long));
        AppMethodBeat.o(347516);
        return false;
      }
      if (!in(((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth, ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight))
      {
        com.tencent.mm.ui.base.k.a((Context)this, getString(l.i.gallery_select_video_ratio_not_support), "", getString(l.i.app_i_know), false, null);
        AppMethodBeat.o(347516);
        return false;
      }
      boolean bool = a((GalleryItem.VideoMediaItem)paramMediaItem);
      if (!bool)
      {
        localObject = com.tencent.mm.plugin.finder.report.ah.f.FtB;
        com.tencent.mm.plugin.finder.report.ah.f.al(((GalleryItem.VideoMediaItem)paramMediaItem).oTL, ((GalleryItem.VideoMediaItem)paramMediaItem).oTM, ((GalleryItem.VideoMediaItem)paramMediaItem).Gcc);
        com.tencent.mm.ui.base.k.a((Context)this, getString(l.i.gallery_pic_video_not_support_desc), "", getString(l.i.app_i_know), false, null);
      }
      AppMethodBeat.o(347516);
      return bool;
    }
    AppMethodBeat.o(347516);
    return false;
  }
  
  public final boolean faD()
  {
    Object localObject1 = null;
    AppMethodBeat.i(167131);
    Object localObject2 = com.tencent.mm.plugin.vlog.report.a.UeF;
    com.tencent.mm.plugin.vlog.report.a.a(100, 1, System.currentTimeMillis() - this.ETJ, 1, null, null, 48);
    int i;
    Object localObject3;
    label262:
    label271:
    Object localObject4;
    if (this.mpb == 25)
    {
      localObject2 = new ArrayList((Collection)this.HMh.HLB);
      if (((ArrayList)localObject2).isEmpty())
      {
        Log.e("Finder.AlbumUI", "[onSendItemClick] list isEmpty");
        AppMethodBeat.o(167131);
        return false;
      }
      localObject1 = ((ArrayList)localObject2).get(0);
      if ((localObject1 instanceof GalleryItem.VideoMediaItem))
      {
        localObject1 = (GalleryItem.VideoMediaItem)localObject1;
        if (localObject1 != null) {
          break label262;
        }
      }
      for (i = 0;; i = ((GalleryItem.VideoMediaItem)localObject1).oTN)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if ((((Number)com.tencent.mm.plugin.finder.storage.d.eUN().bmg()).intValue() != 1) || (((ArrayList)localObject2).size() != 1)) {
          break label553;
        }
        long l = i;
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if ((l < (com.tencent.mm.plugin.finder.storage.d.eRl() + 1) * 1000L) || (i >= ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgA() * 1000L) || (this.FOn)) {
          break label553;
        }
        localObject1 = new com.tencent.mm.plugin.finder.view.d((Context)getContext());
        localObject3 = ((ArrayList)localObject2).get(0);
        if (localObject3 != null) {
          break label271;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
        AppMethodBeat.o(167131);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
      }
      localObject3 = (GalleryItem.VideoMediaItem)localObject3;
      ((com.tencent.mm.plugin.finder.view.d)localObject1).UD(l.f.finder_post_choose_video_layout);
      localObject4 = (TextView)((com.tencent.mm.plugin.finder.view.d)localObject1).rootView.findViewById(l.e.dialog_title);
      if (localObject4 != null) {
        com.tencent.mm.ui.aw.a((Paint)((TextView)localObject4).getPaint(), 0.8F);
      }
      localObject4 = ((com.tencent.mm.plugin.finder.view.d)localObject1).rootView.findViewById(l.e.dialog_back_btn_container);
      if (localObject4 != null) {
        ((View)localObject4).setOnClickListener(new FinderAlbumUI..ExternalSyntheticLambda3((com.tencent.mm.plugin.finder.view.d)localObject1));
      }
      localObject4 = ((com.tencent.mm.plugin.finder.view.d)localObject1).rootView.findViewById(l.e.long_video_area);
      if (localObject4 != null) {
        ((View)localObject4).setOnClickListener(new FinderAlbumUI..ExternalSyntheticLambda1(this, (com.tencent.mm.plugin.finder.view.d)localObject1, (GalleryItem.VideoMediaItem)localObject3));
      }
      localObject3 = ((com.tencent.mm.plugin.finder.view.d)localObject1).rootView.findViewById(l.e.short_video_area);
      if (localObject3 != null) {
        ((View)localObject3).setOnClickListener(new FinderAlbumUI..ExternalSyntheticLambda2(this, (com.tencent.mm.plugin.finder.view.d)localObject1, (ArrayList)localObject2));
      }
      ((com.tencent.mm.plugin.finder.view.d)localObject1).GwT = new FinderAlbumUI..ExternalSyntheticLambda4(this);
      ((com.tencent.mm.plugin.finder.view.d)localObject1).dDn();
      localObject1 = ax.Fur;
      localObject1 = v.FrN;
      localObject1 = v.eMS();
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject2 = v.FrN;
        localObject2 = v.eMS();
        if (localObject2 != null) {
          break label530;
        }
        localObject2 = "";
        label485:
        ax.m((String)localObject1, (String)localObject2, com.tencent.mm.model.cn.bDw() / 1000L);
      }
      for (;;)
      {
        AppMethodBeat.o(167131);
        return true;
        localObject2 = ((FinderFeedReportObject)localObject1).clickId;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
        label530:
        localObject3 = ((FinderFeedReportObject)localObject2).postId;
        localObject2 = localObject3;
        if (localObject3 != null) {
          break label485;
        }
        localObject2 = "";
        break label485;
        label553:
        if ((((ArrayList)localObject2).size() == 1) && (i > 0))
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eSg().bmg()).intValue() == 1)
          {
            localObject1 = com.tencent.mm.plugin.findersdk.b.b.HcE;
            localObject1 = com.tencent.mm.plugin.findersdk.b.b.a.d((Context)this, getResources().getString(l.i.finder_waiting), 500L);
            ((com.tencent.mm.plugin.findersdk.b.b)localObject1).begin();
            com.tencent.threadpool.h.ahAA.bm(new FinderAlbumUI..ExternalSyntheticLambda7((ArrayList)localObject2, (com.tencent.mm.plugin.findersdk.b.b)localObject1, this));
            continue;
          }
        }
        ay((ArrayList)localObject2);
      }
    }
    if (this.mpb == 32)
    {
      i = getIntent().getIntExtra("min_select_count", 0);
      if (this.HMh.HLB.size() < i)
      {
        localObject2 = (Context)getContext();
        localObject3 = getContext().getResources();
        if (localObject3 == null) {}
        for (;;)
        {
          com.tencent.mm.ui.base.k.cZ((Context)localObject2, (String)localObject1);
          AppMethodBeat.o(167131);
          return false;
          localObject1 = ((Resources)localObject3).getQuantityString(l.g.gallery_pic_or_video_limit_min, i, new Object[] { Integer.valueOf(i) });
        }
      }
      localObject3 = new ArrayList((Collection)this.HMh.HLB);
      if (((ArrayList)localObject3).isEmpty())
      {
        Log.e("Finder.AlbumUI", "[onSendItemClick] list isEmpty");
        AppMethodBeat.o(167131);
        return false;
      }
      Log.i("Finder.AlbumUI", "perform enter template preview ui");
      localObject1 = (com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class);
      localObject2 = (Activity)this;
      localObject3 = (List)localObject3;
      localObject4 = getIntent();
      s.s(localObject4, "intent");
      ((com.tencent.mm.mj_template.api.d)localObject1).enterAlubmTemplatePreviewUI((Activity)localObject2, 294, (List)localObject3, (Intent)localObject4);
      AppMethodBeat.o(167131);
      return true;
    }
    AppMethodBeat.o(167131);
    return false;
  }
  
  public final void initView()
  {
    boolean bool = false;
    AppMethodBeat.i(167134);
    super.initView();
    removeOptionMenu(0);
    getController().Li(true);
    addTextOptionMenu(0, faG(), this.HMS, null, y.b.adEU);
    this.HMd.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    WH(0);
    CharSequence localCharSequence = (CharSequence)getIntent().getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bool = true;
      }
      this.FOn = bool;
      if ((this.FOn) || (!((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig().bxh())) {
        break label246;
      }
      if (!((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getMaasPermissionChecker().HC("scene_finder")) {
        break;
      }
      ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).preloadMaas();
      Log.i("Finder.AlbumUI", "has maas permission");
      AppMethodBeat.o(167134);
      return;
    }
    if (((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getMaasPermissionChecker().HD("scene_finder"))
    {
      Log.i("Finder.AlbumUI", "requested maas permission and denied");
      ue(true);
      AppMethodBeat.o(167134);
      return;
    }
    faF();
    label246:
    AppMethodBeat.o(167134);
  }
  
  public final void n(int paramInt, View paramView)
  {
    AppMethodBeat.i(167136);
    s.u(paramView, "itemView");
    paramView = this.HMh.WF(paramInt);
    if ((paramView == null) || (Util.isNullOrNil(paramView.Gcc)))
    {
      if (paramView == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("Finder.AlbumUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(167136);
        return;
      }
    }
    if (this.mpb == 25)
    {
      if ((paramView instanceof GalleryItem.VideoMediaItem))
      {
        paramInt = Math.max(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXN, 300), ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgA());
        int i = faH();
        this.FOr = ((GalleryItem.VideoMediaItem)paramView).oTN;
        localObject = ((GalleryItem.VideoMediaItem)paramView).Gcc;
        s.s(localObject, "item.originalPath");
        this.FOs = ((String)localObject);
        if (((GalleryItem.VideoMediaItem)paramView).oTN < com.tencent.mm.modelcontrol.e.bIg().bIn().minDuration * 1000)
        {
          com.tencent.mm.ui.base.k.c((Context)getContext(), getResources().getString(l.i.gallery_video_duration_below, new Object[] { Integer.valueOf(com.tencent.mm.modelcontrol.e.bIg().bIn().minDuration) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        if (((GalleryItem.VideoMediaItem)paramView).oTN > paramInt * 1000)
        {
          com.tencent.mm.ui.base.k.c((Context)getContext(), getResources().getString(l.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(i) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        Log.i("Finder.AlbumUI", "onMediaClick, video mime:" + ((GalleryItem.VideoMediaItem)paramView).oTL + ", audio mime:" + ((GalleryItem.VideoMediaItem)paramView).oTM + ", path:" + paramView.Gcc);
        if (!a((GalleryItem.VideoMediaItem)paramView))
        {
          localObject = com.tencent.mm.plugin.finder.report.ah.f.FtB;
          com.tencent.mm.plugin.finder.report.ah.f.al(((GalleryItem.VideoMediaItem)paramView).oTL, ((GalleryItem.VideoMediaItem)paramView).oTM, paramView.Gcc);
          paramView = new g.a((Context)getContext());
          paramView.bf((CharSequence)com.tencent.mm.cd.a.bt((Context)getContext(), b.i.gallery_pic_video_not_support_desc));
          paramView.bDI(com.tencent.mm.cd.a.bt((Context)getContext(), b.i.gallery_i_know));
          paramView.b(FinderAlbumUI..ExternalSyntheticLambda5.INSTANCE);
          paramView.show();
          AppMethodBeat.o(167136);
          return;
        }
        new ArrayList(1).add(paramView);
        localObject = this.HMh.WE(2);
        com.tencent.mm.plugin.gallery.model.e.aJ((ArrayList)localObject);
        TB(((ArrayList)localObject).indexOf(paramView));
        AppMethodBeat.o(167136);
        return;
      }
      Object localObject = this.HMh.WE(paramView.getType());
      com.tencent.mm.plugin.gallery.model.e.aJ((ArrayList)localObject);
      TB(((ArrayList)localObject).indexOf(paramView));
    }
    AppMethodBeat.o(167136);
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
        this.HMh.HLB.clear();
        this.HMh.bZE.notifyChanged();
        WH(0);
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
      if (paramIntent == null) {}
      for (paramIntent = (Intent)localObject2;; paramIntent = paramIntent.getStringArrayListExtra("preview_image_list"))
      {
        if ((paramIntent != null) && (this.HMh != null))
        {
          com.tencent.mm.plugin.gallery.ui.a locala = this.HMh;
          localObject2 = com.tencent.mm.plugin.gallery.model.e.fAp();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.HMh.HLA;
          }
          locala.j(paramIntent, (ArrayList)localObject1);
          this.HMh.bZE.notifyChanged();
          WH(paramIntent.size());
        }
        faD();
        AppMethodBeat.o(167137);
        return;
      }
    }
    if ((291 == paramInt1) && (paramInt2 == -1))
    {
      localObject1 = new ArrayList(1);
      s.checkNotNull(paramIntent);
      paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      s.checkNotNull(paramIntent);
      s.s(paramIntent, "data!!.getParcelableExtr…geUI.KSEGMENTMEDIAINFO)!!");
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
      localObject2 = new GalleryItem.VideoMediaItem();
      ((GalleryItem.VideoMediaItem)localObject2).Gcc = paramIntent.videoPath;
      ((GalleryItem.VideoMediaItem)localObject2).zWJ = paramIntent.thumbPath;
      ((GalleryItem.VideoMediaItem)localObject2).oTN = ((int)paramIntent.NHJ.longValue());
      ((ArrayList)localObject1).add(localObject2);
      paramInt1 = this.FOr;
      localObject2 = this.FOs;
      paramIntent = new Intent();
      paramIntent.putExtra("fromAppBrand", getIntent().getBooleanExtra("fromAppBrand", false));
      paramIntent.putParcelableArrayListExtra("select_path_list", (ArrayList)localObject1);
      paramIntent.putParcelableArrayListExtra("front_vlog_video", null);
      paramIntent.putExtra("select_video_path", (String)localObject2);
      paramIntent.putExtra("select_video_duration", paramInt1);
      paramIntent.setClass((Context)getContext(), FinderMediaCropUI.class);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = getIntent();
      s.s(localObject1, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.b(paramIntent, (Intent)localObject1);
      startActivityForResult(paramIntent, 1001);
      AppMethodBeat.o(167137);
      return;
    }
    if (292 == paramInt1)
    {
      localObject2 = (Context)this;
      if (paramIntent == null) {}
      for (paramIntent = (Intent)localObject1;; paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO"))
      {
        a((Context)localObject2, paramIntent, CaptureDataManager.NHH.rnY);
        AppMethodBeat.o(167137);
        return;
      }
    }
    if ((293 == paramInt1) && (paramInt2 == -1))
    {
      finish();
      AppMethodBeat.o(167137);
      return;
    }
    if ((294 == paramInt1) && (paramInt2 == -1))
    {
      ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).releaseMaas();
      setResult(-1);
      finish();
    }
    AppMethodBeat.o(167137);
  }
  
  public final void onBackBtnClick()
  {
    AppMethodBeat.i(167133);
    Object localObject = v.FrN;
    v.SA(3);
    localObject = com.tencent.mm.plugin.vlog.report.a.UeF;
    com.tencent.mm.plugin.vlog.report.a.a(100, 1, System.currentTimeMillis() - this.ETJ, 0, null, null, 48);
    AppMethodBeat.o(167133);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347487);
    super.onCreate(paramBundle);
    Object localObject = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      paramBundle = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      paramBundle = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    }
    this.postId = paramBundle;
    this.FOq = getIntent().getBooleanExtra("album_from_finder_add_media", false);
    paramBundle = v.FrN;
    v.azP(this.postId);
    paramBundle = com.tencent.mm.plugin.gallery.b.b.HQZ;
    paramBundle = com.tencent.mm.plugin.gallery.b.b.fBR();
    paramBundle.put("qt-file", true);
    localObject = com.tencent.mm.plugin.gallery.b.b.HQZ;
    com.tencent.mm.plugin.gallery.b.b.bk(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = (as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).cp(as.class);
    if (paramBundle != null) {
      as.a(paramBundle, 100);
    }
    paramBundle = com.tencent.mm.plugin.finder.report.postreport.a.FuZ;
    paramBundle = v.FrN;
    paramBundle = v.eMS();
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.report.postreport.b.Fvb;
      com.tencent.mm.plugin.finder.report.postreport.a.a(paramBundle, com.tencent.mm.plugin.finder.report.postreport.b.eOe());
      AppMethodBeat.o(347487);
      return;
      localObject = paramBundle.flowId;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(347545);
    CaptureDataManager.NHH.NHG = null;
    if ((!this.FOn) && (((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig().bxh())) {
      ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).releaseMaas();
    }
    super.onDestroy();
    AppMethodBeat.o(347545);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347495);
    super.onResume();
    this.ETJ = System.currentTimeMillis();
    com.tencent.mm.plugin.vlog.report.a locala = com.tencent.mm.plugin.vlog.report.a.UeF;
    com.tencent.mm.plugin.vlog.report.a.a(100, 0, 0L, 0, null, null, 60);
    AppMethodBeat.o(347495);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(347493);
    super.onStart();
    if (this.FOp) {
      ((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.a.a.class)).fuW();
    }
    AppMethodBeat.o(347493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(347447);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.finder.accessibility.b.class);
    paramHashSet.add(as.class);
    AppMethodBeat.o(347447);
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    AppMethodBeat.i(167132);
    super.updateOptionMenuText(paramInt, faG());
    AppMethodBeat.o(167132);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(com.tencent.mm.plugin.findersdk.b.b paramb, kotlin.g.b.ah.f<JSONObject> paramf, String paramString, FinderAlbumUI paramFinderAlbumUI, ArrayList<GalleryItem.MediaItem> paramArrayList)
    {
      super();
    }
    
    private static final ah a(FinderAlbumUI paramFinderAlbumUI, String paramString, ArrayList paramArrayList, com.tencent.mm.am.b.a parama)
    {
      AppMethodBeat.i(347424);
      s.u(paramFinderAlbumUI, "this$0");
      s.u(paramArrayList, "$list");
      if ((parama != null) && (parama.errType == 0) && (parama.errCode == 0) && (((baj)parama.ott).ieB))
      {
        Intent localIntent = new Intent();
        if (FinderAlbumUI.b(paramFinderAlbumUI)) {
          localIntent.putExtras(paramFinderAlbumUI.getIntent());
        }
        localIntent.putExtra("post_id", FinderAlbumUI.c(paramFinderAlbumUI));
        localIntent.putExtra("postType", 4);
        localIntent.putExtra("postMediaList", (Serializable)p.al(new String[] { paramString }));
        localIntent.putExtra("postTypeList", (Serializable)p.al(new Integer[] { Integer.valueOf(4) }));
        localIntent.putExtra("isLongVideoPost", false);
        paramString = (baj)parama.ott;
        if (paramString == null)
        {
          paramString = "";
          localIntent.putExtra("KEY_POST_MIAOJIAN_TONGKUAN_META", paramString);
          localIntent.putExtra("KEY_POST_FROM_APP_SOURCE", 4);
          paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
          paramString = paramFinderAlbumUI.getIntent();
          s.s(paramString, "getIntent()");
          com.tencent.mm.plugin.finder.utils.a.b(localIntent, paramString);
          FinderAlbumUI.a(paramFinderAlbumUI, localIntent);
          Log.i("Finder.AlbumUI", s.X("miaojianTongkuanMeta ", ((baj)parama.ott).ZLg));
        }
      }
      for (;;)
      {
        paramFinderAlbumUI = ah.aiuX;
        AppMethodBeat.o(347424);
        return paramFinderAlbumUI;
        paramArrayList = paramString.ZLg;
        paramString = paramArrayList;
        if (paramArrayList != null) {
          break;
        }
        paramString = "";
        break;
        Log.i("Finder.AlbumUI", "cgi error, continue post");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new FinderAlbumUI.b.a(paramFinderAlbumUI, paramArrayList));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderAlbumUI
 * JD-Core Version:    0.7.0.1
 */