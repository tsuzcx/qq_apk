package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.finder.report.i.e;
import com.tencent.mm.plugin.finder.vlog.MultiVideoPluginLayout;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.o.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.a.j;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "()V", "originalVideoDuration", "", "originalVideoPath", "", "postId", "checkFinderVideoItemFormatValid", "", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "checkSelectedVideo", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "doCreateVLog", "", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "doEnterMMRecordVLogUI", "enterFinderMediaCropUI", "vlogVideo", "getMenuText", "initView", "isAllPathIsImage", "jumpImagePreviewUI", "mediaPosition", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackBtnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMediaClick", "position", "itemView", "Landroid/view/View;", "itemViewType", "onSendItemClick", "updateOptionMenuText", "menuID", "text", "Companion", "plugin-finder_release"})
public final class FinderAlbumUI
  extends AlbumPreviewUI
{
  public static final FinderAlbumUI.a rFH;
  private String postId = "";
  private int rFF;
  private String rFG = "";
  
  static
  {
    AppMethodBeat.i(167139);
    rFH = new FinderAlbumUI.a((byte)0);
    AppMethodBeat.o(167139);
  }
  
  private final void Er(int paramInt)
  {
    AppMethodBeat.i(203090);
    Intent localIntent = new Intent((Context)this, ImagePreviewUI.class);
    Object localObject = this.sPl;
    k.g(localObject, "adapter");
    localIntent.putStringArrayListExtra("preview_image_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).cNv());
    localObject = this.sPl;
    k.g(localObject, "adapter");
    localIntent.putParcelableArrayListExtra("preview_media_item_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).cNw());
    localIntent.putExtra("preview_all", true);
    localIntent.putExtra("preview_position", paramInt);
    aj(paramInt, true);
    localIntent.putExtra("send_raw_img", this.opQ);
    localIntent.putExtra("key_force_hide_edit_image_button", true);
    localIntent.putExtra("max_select_count", this.rXO);
    localIntent.putExtra("GalleryUI_FromUser", this.dng);
    localIntent.putExtra("GalleryUI_ToUser", this.toUser);
    localIntent.putExtra("album_business_tag", this.sOM);
    localIntent.putExtra("album_video_max_duration", this.jbG);
    localIntent.putExtra("album_video_min_duration", this.sPJ);
    localObject = e.cMt();
    k.g(localObject, "GalleryCore.getMediaQueryService()");
    if (((o)localObject).cMZ() == 14) {
      localIntent.putExtra("key_edit_video_max_time_length", 300500);
    }
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(203090);
  }
  
  private final void X(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(203086);
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    int[] arrayOfInt = new int[this.rXO];
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (localMediaItem.getType() == 1)
      {
        if ((k.g(localMediaItem.getMimeType(), "edit")) && (!bs.isNullOrNil(localMediaItem.sKj))) {
          ((ArrayList)localObject1).add(localMediaItem.cMU());
        }
        for (;;)
        {
          arrayOfInt[i] = 1;
          i += 1;
          break;
          ((ArrayList)localObject1).add(localMediaItem.cMQ());
        }
      }
      if (localMediaItem.getType() != 2) {
        break label231;
      }
      ((ArrayList)localObject2).add(localMediaItem.cMQ());
      int j = i + 1;
      arrayOfInt[i] = 2;
      i = j;
    }
    label231:
    for (;;)
    {
      break;
      localObject1 = aj.cl((Context)this);
      localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
      localObject1 = com.tencent.mm.plugin.finder.utils.n.fE(((Point)localObject1).x, ((Point)localObject1).y);
      new Point(((Bundle)localObject1).getInt("media_layout_width", -1), ((Bundle)localObject1).getInt("media_layout_height", -1));
      Y(paramArrayList);
      AppMethodBeat.o(203086);
      return;
    }
  }
  
  private final void Y(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    int j = 3;
    AppMethodBeat.i(203091);
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).YX();
    ((UICustomParam.a)localObject1).YW();
    ((UICustomParam.a)localObject1).cN(false);
    ((UICustomParam.a)localObject1).YY();
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.iw("", "");
    localRecordConfigProvider.scene = 11;
    localRecordConfigProvider.wqu = ((UICustomParam.a)localObject1).Za();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    localRecordConfigProvider.wqt = com.tencent.mm.plugin.finder.storage.b.cxZ();
    localRecordConfigProvider.wqw = 3;
    localRecordConfigProvider.wqC = (localRecordConfigProvider.wqt.duration * 1000);
    ((UICustomParam.a)localObject1).cM(false);
    int i = 1;
    localObject1 = ((Iterable)paramArrayList).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).getType() != 2) {
        break label336;
      }
      i = 0;
    }
    label336:
    for (;;)
    {
      break;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelableArrayList("media_list", paramArrayList);
      ((Bundle)localObject1).putString("post_id", this.postId);
      paramArrayList = aj.cl((Context)this);
      localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
      paramArrayList = com.tencent.mm.plugin.finder.utils.n.fE(paramArrayList.x, paramArrayList.y);
      paramArrayList = new Point(paramArrayList.getInt("media_layout_width", -1), paramArrayList.getInt("media_layout_height", -1));
      ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", paramArrayList.x);
      ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", paramArrayList.y);
      localRecordConfigProvider.hSN = ((Bundle)localObject1);
      localRecordConfigProvider.D(3, MultiVideoPluginLayout.class.getName());
      localRecordConfigProvider.D(4, MultiVideoPluginLayout.class.getName());
      if (i != 0) {}
      for (i = j;; i = 4)
      {
        paramArrayList = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
        com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, 2130772144, 2130772145, localRecordConfigProvider, i, 0);
        AppMethodBeat.o(203091);
        return;
      }
    }
  }
  
  private final boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(203089);
    int i;
    if ((d.n.n.I("video/hevc", paramVideoMediaItem.hTu, true)) && (f.dcU())) {
      i = 1;
    }
    for (;;)
    {
      int j = i;
      if (!bs.isNullOrNil(paramVideoMediaItem.hTv))
      {
        j = i;
        if (!d.n.n.I("audio/mp4a-latm", paramVideoMediaItem.hTv, true)) {
          j = 0;
        }
      }
      if (r.DP(paramVideoMediaItem.sKh))
      {
        if ((bs.isNullOrNil(paramVideoMediaItem.hTu)) || (!f.alR(paramVideoMediaItem.hTu)) || (bs.isNullOrNil(paramVideoMediaItem.hTv)) || (!f.alR(paramVideoMediaItem.hTv))) {
          break label162;
        }
        ac.i("Finder.AlbumUI", "qt video can decode");
      }
      for (j = 1;; j = 0)
      {
        if ((j == 0) || (bk(paramVideoMediaItem.sKh, false))) {
          break label176;
        }
        AppMethodBeat.o(203089);
        return true;
        if (!d.n.n.I("video/avc", paramVideoMediaItem.hTu, true)) {
          break label184;
        }
        i = 1;
        break;
        label162:
        ac.i("Finder.AlbumUI", "qt video cannot decode");
      }
      label176:
      AppMethodBeat.o(203089);
      return false;
      label184:
      i = 0;
    }
  }
  
  private final String cBv()
  {
    AppMethodBeat.i(167135);
    Object localObject = this.sPl;
    k.g(localObject, "adapter");
    int i = ((com.tencent.mm.plugin.gallery.ui.a)localObject).cNw().size();
    if (i > 0)
    {
      localObject = new StringBuilder();
      AppCompatActivity localAppCompatActivity = getContext();
      k.g(localAppCompatActivity, "context");
      localObject = localAppCompatActivity.getResources().getString(2131755830) + '(' + i + '/' + this.rXO + ')';
      AppMethodBeat.o(167135);
      return localObject;
    }
    localObject = getContext();
    k.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources().getString(2131755830);
    k.g(localObject, "context.resources.getString(R.string.app_nextstep)");
    AppMethodBeat.o(167135);
    return localObject;
  }
  
  public final boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(203088);
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      boolean bool = a((GalleryItem.VideoMediaItem)paramMediaItem);
      if (!bool)
      {
        i.e locale = i.e.ryW;
        i.e.Y(((GalleryItem.VideoMediaItem)paramMediaItem).hTu, ((GalleryItem.VideoMediaItem)paramMediaItem).hTv, paramMediaItem.sKh);
        h.cf((Context)this, getString(2131759790));
      }
      AppMethodBeat.o(203088);
      return bool;
    }
    AppMethodBeat.o(203088);
    return false;
  }
  
  public final boolean cBu()
  {
    AppMethodBeat.i(167131);
    if (this.sPN == 25)
    {
      Object localObject = this.sPl;
      k.g(localObject, "adapter");
      localObject = new ArrayList((Collection)((com.tencent.mm.plugin.gallery.ui.a)localObject).cNw());
      if (((ArrayList)localObject).isEmpty())
      {
        ac.e("Finder.AlbumUI", "[onSendItemClick] list isEmpty");
        AppMethodBeat.o(167131);
        return false;
      }
      X((ArrayList)localObject);
      AppMethodBeat.o(167131);
      return true;
    }
    AppMethodBeat.o(167131);
    return false;
  }
  
  public final void f(int paramInt, View paramView)
  {
    AppMethodBeat.i(167136);
    k.h(paramView, "itemView");
    paramView = this.sPl.FX(paramInt);
    if ((paramView == null) || (bs.isNullOrNil(paramView.cMQ())))
    {
      if (paramView == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.w("Finder.AlbumUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(167136);
        return;
      }
    }
    if (this.sPN == 25)
    {
      if ((paramView instanceof GalleryItem.VideoMediaItem))
      {
        paramInt = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVh, 300);
        this.rFF = ((GalleryItem.VideoMediaItem)paramView).hTw;
        localObject = ((GalleryItem.VideoMediaItem)paramView).cMQ();
        k.g(localObject, "item.originalPath");
        this.rFG = ((String)localObject);
        int i = ((GalleryItem.VideoMediaItem)paramView).hTw;
        localObject = d.aDL();
        k.g(localObject, "SubCoreVideoControl.getCore()");
        if (i < ((d)localObject).aDR().minDuration * 1000)
        {
          paramView = (Context)getContext();
          localObject = getResources();
          d locald = d.aDL();
          k.g(locald, "SubCoreVideoControl.getCore()");
          h.c(paramView, ((Resources)localObject).getString(2131759821, new Object[] { Integer.valueOf(locald.aDR().minDuration) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        if (((GalleryItem.VideoMediaItem)paramView).hTw > paramInt * 1000)
        {
          h.c((Context)getContext(), getResources().getString(2131759822, new Object[] { Integer.valueOf(paramInt) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        ac.i("Finder.AlbumUI", "onMediaClick, video mime:" + ((GalleryItem.VideoMediaItem)paramView).hTu + ", audio mime:" + ((GalleryItem.VideoMediaItem)paramView).hTv + ", path:" + paramView.sKh);
        if (!a((GalleryItem.VideoMediaItem)paramView))
        {
          localObject = i.e.ryW;
          i.e.Y(((GalleryItem.VideoMediaItem)paramView).hTu, ((GalleryItem.VideoMediaItem)paramView).hTv, paramView.sKh);
          paramView = new f.a((Context)getContext());
          paramView.av((CharSequence)com.tencent.mm.cc.a.aw((Context)getContext(), 2131759790));
          paramView.aRU(com.tencent.mm.cc.a.aw((Context)getContext(), 2131759769));
          paramView.b((f.c)FinderAlbumUI.b.rFI);
          paramView.show();
          AppMethodBeat.o(167136);
          return;
        }
        new ArrayList(1).add(paramView);
        localObject = this.sPl.FW(((GalleryItem.VideoMediaItem)paramView).getType());
        e.ab((ArrayList)localObject);
        Er(((ArrayList)localObject).indexOf(paramView));
        AppMethodBeat.o(167136);
        return;
      }
      Object localObject = this.sPl.FW(paramView.getType());
      e.ab((ArrayList)localObject);
      Er(((ArrayList)localObject).indexOf(paramView));
    }
    AppMethodBeat.o(167136);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167134);
    super.initView();
    removeOptionMenu(0);
    getController().wz(true);
    addTextOptionMenu(0, cBv(), this.sPS, null, s.b.Hox);
    RecyclerView localRecyclerView = this.sPh;
    k.g(localRecyclerView, "gallery");
    localRecyclerView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    FZ(0);
    AppMethodBeat.o(167134);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(167137);
    ac.i("Finder.AlbumUI", "onActivityResult requestCode " + paramInt1 + " resultCod " + paramInt2);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("clear_list", false)))
      {
        paramIntent = this.sPl;
        k.g(paramIntent, "adapter");
        paramIntent.cNw().clear();
        this.sPl.notifyDataSetChanged();
        FZ(0);
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
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringArrayListExtra("preview_image_list");; paramIntent = null)
      {
        if ((paramIntent != null) && (this.sPl != null))
        {
          this.sPl.ad(paramIntent);
          this.sPl.notifyDataSetChanged();
          FZ(paramIntent.size());
        }
        cBu();
        AppMethodBeat.o(167137);
        return;
      }
    }
    Object localObject1;
    Object localObject2;
    if ((291 == paramInt1) && (paramInt2 == -1))
    {
      localObject1 = new ArrayList(1);
      if (paramIntent == null) {
        k.fOy();
      }
      paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      k.g(paramIntent, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
      localObject2 = new GalleryItem.VideoMediaItem();
      ((GalleryItem.VideoMediaItem)localObject2).sKh = paramIntent.getVideoPath();
      ((GalleryItem.VideoMediaItem)localObject2).qCJ = paramIntent.auN();
      ((GalleryItem.VideoMediaItem)localObject2).hTw = ((int)paramIntent.dvi().longValue());
      ((ArrayList)localObject1).add(localObject2);
      paramInt1 = this.rFF;
      localObject2 = this.rFG;
      paramIntent = new Intent();
      paramIntent.putExtra("fromAppBrand", getIntent().getBooleanExtra("fromAppBrand", false));
      paramIntent.putParcelableArrayListExtra("select_path_list", (ArrayList)localObject1);
      paramIntent.putParcelableArrayListExtra("front_vlog_video", null);
      paramIntent.putExtra("select_video_path", (String)localObject2);
      paramIntent.putExtra("select_video_duration", paramInt1);
      paramIntent.setClass((Context)getContext(), FinderMediaCropUI.class);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
      localObject1 = getIntent();
      k.g(localObject1, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a(paramIntent, (Intent)localObject1);
      startActivityForResult(paramIntent, 1001);
      AppMethodBeat.o(167137);
      return;
    }
    if ((292 == paramInt1) && (paramInt2 == -1))
    {
      if (paramIntent == null) {
        k.fOy();
      }
      localObject1 = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      k.g(localObject1, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      localObject2 = (CaptureDataManager.CaptureVideoNormalModel)localObject1;
      localObject1 = new Intent();
      if ((((CaptureDataManager.CaptureVideoNormalModel)localObject2).dvl() == null) || (((CaptureDataManager.CaptureVideoNormalModel)localObject2).dvl().size() <= 0)) {
        break label784;
      }
      ((Intent)localObject1).putExtra("postType", 2);
      paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).dvl();
      k.g(paramIntent, "model.multiImagePath");
      Object localObject3 = (Iterable)paramIntent;
      paramIntent = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        k.g(str, "it");
        paramIntent.add(str);
      }
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramIntent);
      paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).dvl();
      k.g(paramIntent, "model.multiImagePath");
      localObject3 = (Iterable)paramIntent;
      paramIntent = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((Iterator)localObject3).next();
        paramIntent.add(Integer.valueOf(2));
      }
      ((Intent)localObject1).putExtra("postTypeList", (Serializable)paramIntent);
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.ab(new String[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject2).auN() }));
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)((CaptureDataManager.CaptureVideoNormalModel)localObject2).dvk().x("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramIntent = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramIntent = getIntent();
      k.g(paramIntent, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a((Intent)localObject1, paramIntent);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, (Intent)localObject1);
      AppMethodBeat.o(167137);
      return;
      label784:
      paramIntent = paramIntent.getBundleExtra("key_extra_data").getByteArray("video_composition");
      if (paramIntent != null) {
        ((Intent)localObject1).putExtra("video_composition", paramIntent);
      }
      ((Intent)localObject1).putExtra("postType", 4);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)j.ab(new String[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath() }));
      ((Intent)localObject1).putExtra("postTypeList", (Serializable)j.ab(new Integer[] { Integer.valueOf(4) }));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.ab(new String[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject2).auN() }));
    }
  }
  
  public final void onBackBtnClick()
  {
    AppMethodBeat.i(167133);
    c localc = c.rxi;
    c.DS(3);
    AppMethodBeat.o(167133);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203087);
    super.onCreate(paramBundle);
    String str = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = str;
    if (str == null)
    {
      paramBundle = new StringBuilder();
      k.g(g.agP(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.a.afE() + '_' + bs.eWj();
    }
    this.postId = paramBundle;
    paramBundle = c.rxi;
    c.adN(this.postId);
    AppMethodBeat.o(203087);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    AppMethodBeat.i(167132);
    super.updateOptionMenuText(paramInt, cBv());
    AppMethodBeat.o(167132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderAlbumUI
 * JD-Core Version:    0.7.0.1
 */