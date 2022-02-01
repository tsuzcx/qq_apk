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
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.report.o.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.o.f;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.a.j;
import d.l;
import d.n.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "originalVideoDuration", "", "originalVideoPath", "", "postId", "checkFinderVideoItemFormatValid", "", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "checkSelectedVideo", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "doEnterMMRecordVLogUI", "", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "enterFinderMediaCropUI", "vlogVideo", "getMenuText", "initView", "isAllPathIsImage", "jumpImagePreviewUI", "mediaPosition", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackBtnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "context", "Landroid/content/Context;", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaClick", "position", "itemView", "Landroid/view/View;", "itemViewType", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onSendItemClick", "updateOptionMenuText", "menuID", "text", "Companion", "plugin-finder_release"})
public final class FinderAlbumUI
  extends AlbumPreviewUI
  implements CaptureDataManager.b
{
  public static final FinderAlbumUI.a sLG;
  private String postId = "";
  private int sLE;
  private String sLF = "";
  
  static
  {
    AppMethodBeat.i(167139);
    sLG = new FinderAlbumUI.a((byte)0);
    AppMethodBeat.o(167139);
  }
  
  private final void FX(int paramInt)
  {
    AppMethodBeat.i(204480);
    Intent localIntent = new Intent((Context)this, ImagePreviewUI.class);
    Object localObject = this.tWG;
    d.g.b.p.g(localObject, "adapter");
    localIntent.putStringArrayListExtra("preview_image_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).cYs());
    localObject = this.tWG;
    d.g.b.p.g(localObject, "adapter");
    localIntent.putParcelableArrayListExtra("preview_media_item_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).cYt());
    localIntent.putExtra("preview_all", true);
    localIntent.putExtra("preview_position", paramInt);
    aq(paramInt, true);
    localIntent.putExtra("send_raw_img", this.oZN);
    localIntent.putExtra("key_force_hide_edit_image_button", true);
    localIntent.putExtra("max_select_count", this.tfW);
    localIntent.putExtra("GalleryUI_FromUser", this.dzZ);
    localIntent.putExtra("GalleryUI_ToUser", this.toUser);
    localIntent.putExtra("album_business_tag", this.tWh);
    localIntent.putExtra("album_video_max_duration", this.jxK);
    localIntent.putExtra("album_video_min_duration", this.tXe);
    localIntent.putExtra("media_type", 2);
    localObject = e.cXr();
    d.g.b.p.g(localObject, "GalleryCore.getMediaQueryService()");
    if (((o)localObject).cXW() == 14) {
      localIntent.putExtra("key_edit_video_max_time_length", 300500);
    }
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(204480);
  }
  
  private final void W(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    int j = 3;
    AppMethodBeat.i(204482);
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).abH();
    ((UICustomParam.a)localObject1).abG();
    ((UICustomParam.a)localObject1).cP(false);
    ((UICustomParam.a)localObject1).abI();
    ((UICustomParam.a)localObject1).a(2131231368, 0, "", 0);
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.iP("", "");
    localRecordConfigProvider.scene = 11;
    localRecordConfigProvider.xOh = ((UICustomParam.a)localObject1).abJ();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    localRecordConfigProvider.xOg = com.tencent.mm.plugin.finder.storage.b.cGU();
    localRecordConfigProvider.xOj = 3;
    localRecordConfigProvider.xOp = (localRecordConfigProvider.xOg.duration * 1000);
    ((UICustomParam.a)localObject1).cO(false);
    int i = 1;
    localObject1 = ((Iterable)paramArrayList).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).getType() == 2) {
        i = 0;
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putParcelableArrayList("media_list", paramArrayList);
    ((Bundle)localObject1).putString("post_id", this.postId);
    paramArrayList = al.ck((Context)this);
    localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
    paramArrayList = com.tencent.mm.plugin.finder.utils.p.fS(paramArrayList.x, paramArrayList.y);
    paramArrayList = new Point(paramArrayList.getInt("media_layout_width", -1), paramArrayList.getInt("media_layout_height", -1));
    ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", paramArrayList.x);
    ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", paramArrayList.y);
    paramArrayList = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((Bundle)localObject1).putLong("video_max_duration", com.tencent.mm.plugin.finder.storage.b.cHW() * 1000L);
    paramArrayList = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((Bundle)localObject1).putInt("image_max_height", com.tencent.mm.plugin.finder.storage.b.cHf());
    paramArrayList = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((Bundle)localObject1).putInt("image_max_width", com.tencent.mm.plugin.finder.storage.b.cHe());
    paramArrayList = com.tencent.mm.plugin.finder.storage.b.sHP;
    ((Bundle)localObject1).putInt("image_compress_quality", com.tencent.mm.plugin.finder.storage.b.cHg());
    paramArrayList = com.tencent.mm.plugin.finder.utils.r.sYn;
    ((Bundle)localObject1).putString("output_dir", com.tencent.mm.plugin.finder.utils.r.cOx());
    localRecordConfigProvider.ioY = ((Bundle)localObject1);
    localRecordConfigProvider.D(3, MultiVideoPluginLayout.class.getName());
    localRecordConfigProvider.D(4, MultiVideoPluginLayout.class.getName());
    if (i != 0) {}
    for (i = j;; i = 4)
    {
      CaptureDataManager.xNV.a((CaptureDataManager.b)this);
      paramArrayList = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, 0, 0, localRecordConfigProvider, i, 0);
      AppMethodBeat.o(204482);
      return;
    }
  }
  
  private final boolean a(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(204479);
    int i;
    if ((n.H("video/hevc", paramVideoMediaItem.ipJ, true)) && (f.dpm())) {
      i = 1;
    }
    for (;;)
    {
      int j = i;
      if (!bu.isNullOrNil(paramVideoMediaItem.ipK))
      {
        j = i;
        if (!n.H("audio/mp4a-latm", paramVideoMediaItem.ipK, true)) {
          j = 0;
        }
      }
      if (com.tencent.mm.modelvideo.r.Hy(paramVideoMediaItem.tRJ))
      {
        if ((bu.isNullOrNil(paramVideoMediaItem.ipJ)) || (!f.arL(paramVideoMediaItem.ipJ)) || (bu.isNullOrNil(paramVideoMediaItem.ipK)) || (!f.arL(paramVideoMediaItem.ipK))) {
          break label162;
        }
        ae.i("Finder.AlbumUI", "qt video can decode");
      }
      for (j = 1;; j = 0)
      {
        if ((j == 0) || (bs(paramVideoMediaItem.tRJ, false))) {
          break label176;
        }
        AppMethodBeat.o(204479);
        return true;
        if (!n.H("video/avc", paramVideoMediaItem.ipJ, true)) {
          break label184;
        }
        i = 1;
        break;
        label162:
        ae.i("Finder.AlbumUI", "qt video cannot decode");
      }
      label176:
      AppMethodBeat.o(204479);
      return false;
      label184:
      i = 0;
    }
  }
  
  private final String cLY()
  {
    AppMethodBeat.i(167135);
    Object localObject = this.tWG;
    d.g.b.p.g(localObject, "adapter");
    int i = ((com.tencent.mm.plugin.gallery.ui.a)localObject).cYt().size();
    if (i > 0)
    {
      localObject = new StringBuilder();
      AppCompatActivity localAppCompatActivity = getContext();
      d.g.b.p.g(localAppCompatActivity, "context");
      localObject = localAppCompatActivity.getResources().getString(2131755830) + '(' + i + '/' + this.tfW + ')';
      AppMethodBeat.o(167135);
      return localObject;
    }
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getResources().getString(2131755830);
    d.g.b.p.g(localObject, "context.resources.getString(R.string.app_nextstep)");
    AppMethodBeat.o(167135);
    return localObject;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(204483);
    paramContext = com.tencent.mm.plugin.finder.report.g.syJ;
    paramContext = c.xWV;
    com.tencent.mm.plugin.finder.report.g.b(c.dKb());
    ArrayList localArrayList;
    if (paramCaptureVideoNormalModel != null)
    {
      paramContext = new Intent();
      localArrayList = (ArrayList)paramCaptureVideoNormalModel.dIW().v("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
      if ((paramCaptureVideoNormalModel.dIX() == null) || (paramCaptureVideoNormalModel.dIX().size() <= 0)) {
        break label391;
      }
      paramContext.putExtra("postType", 2);
      paramBundle = paramCaptureVideoNormalModel.dIX();
      d.g.b.p.g(paramBundle, "model.multiImagePath");
      Object localObject = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList();
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        d.g.b.p.g(str, "it");
        paramBundle.add(str);
      }
      paramContext.putExtra("postMediaList", (Serializable)paramBundle);
      paramBundle = paramCaptureVideoNormalModel.dIX();
      d.g.b.p.g(paramBundle, "model.multiImagePath");
      localObject = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList();
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        paramBundle.add(Integer.valueOf(2));
      }
      paramContext.putExtra("postTypeList", (Serializable)paramBundle);
      paramContext.putExtra("postThumbList", (Serializable)j.ab(new String[] { paramCaptureVideoNormalModel.axP() }));
      if ((localArrayList != null) && (localArrayList.size() == paramCaptureVideoNormalModel.dIX().size())) {
        paramContext.putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
    }
    for (;;)
    {
      paramContext.putExtra("post_id", this.postId);
      paramContext.putExtra("edit_id", (String)paramCaptureVideoNormalModel.dIW().v("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramCaptureVideoNormalModel = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramCaptureVideoNormalModel = getIntent();
      d.g.b.p.g(paramCaptureVideoNormalModel, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a(paramContext, paramCaptureVideoNormalModel);
      paramCaptureVideoNormalModel = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, paramContext);
      AppMethodBeat.o(204483);
      return;
      label391:
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getByteArray("video_composition");
        if (paramBundle != null) {
          paramContext.putExtra("video_composition", paramBundle);
        }
      }
      paramContext.putExtra("postType", 4);
      paramContext.putExtra("postMediaList", (Serializable)j.ab(new String[] { paramCaptureVideoNormalModel.getVideoPath() }));
      paramContext.putExtra("postTypeList", (Serializable)j.ab(new Integer[] { Integer.valueOf(4) }));
      paramContext.putExtra("postThumbList", (Serializable)j.ab(new String[] { paramCaptureVideoNormalModel.axP() }));
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        paramContext.putExtra("key_post_media_quality_list", (Serializable)localArrayList);
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
    AppMethodBeat.i(204478);
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      boolean bool = a((GalleryItem.VideoMediaItem)paramMediaItem);
      if (!bool)
      {
        o.e locale = o.e.sAP;
        o.e.ac(((GalleryItem.VideoMediaItem)paramMediaItem).ipJ, ((GalleryItem.VideoMediaItem)paramMediaItem).ipK, paramMediaItem.tRJ);
        h.cl((Context)this, getString(2131759790));
      }
      AppMethodBeat.o(204478);
      return bool;
    }
    AppMethodBeat.o(204478);
    return false;
  }
  
  public final boolean cLX()
  {
    AppMethodBeat.i(167131);
    if (this.tXi == 25)
    {
      Object localObject = this.tWG;
      d.g.b.p.g(localObject, "adapter");
      localObject = new ArrayList((Collection)((com.tencent.mm.plugin.gallery.ui.a)localObject).cYt());
      if (((ArrayList)localObject).isEmpty())
      {
        ae.e("Finder.AlbumUI", "[onSendItemClick] list isEmpty");
        AppMethodBeat.o(167131);
        return false;
      }
      W((ArrayList)localObject);
      AppMethodBeat.o(167131);
      return true;
    }
    AppMethodBeat.o(167131);
    return false;
  }
  
  public final void f(int paramInt, View paramView)
  {
    AppMethodBeat.i(167136);
    d.g.b.p.h(paramView, "itemView");
    paramView = this.tWG.HJ(paramInt);
    if ((paramView == null) || (bu.isNullOrNil(paramView.cXO())))
    {
      if (paramView == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.w("Finder.AlbumUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(167136);
        return;
      }
    }
    if (this.tXi == 25)
    {
      if ((paramView instanceof GalleryItem.VideoMediaItem))
      {
        paramInt = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGX, 300);
        this.sLE = ((GalleryItem.VideoMediaItem)paramView).ipL;
        localObject = ((GalleryItem.VideoMediaItem)paramView).cXO();
        d.g.b.p.g(localObject, "item.originalPath");
        this.sLF = ((String)localObject);
        int i = ((GalleryItem.VideoMediaItem)paramView).ipL;
        localObject = d.aHh();
        d.g.b.p.g(localObject, "SubCoreVideoControl.getCore()");
        if (i < ((d)localObject).aHn().minDuration * 1000)
        {
          paramView = (Context)getContext();
          localObject = getResources();
          d locald = d.aHh();
          d.g.b.p.g(locald, "SubCoreVideoControl.getCore()");
          h.c(paramView, ((Resources)localObject).getString(2131759821, new Object[] { Integer.valueOf(locald.aHn().minDuration) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        if (((GalleryItem.VideoMediaItem)paramView).ipL > paramInt * 1000)
        {
          h.c((Context)getContext(), getResources().getString(2131759822, new Object[] { Integer.valueOf(paramInt) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        ae.i("Finder.AlbumUI", "onMediaClick, video mime:" + ((GalleryItem.VideoMediaItem)paramView).ipJ + ", audio mime:" + ((GalleryItem.VideoMediaItem)paramView).ipK + ", path:" + paramView.tRJ);
        if (!a((GalleryItem.VideoMediaItem)paramView))
        {
          localObject = o.e.sAP;
          o.e.ac(((GalleryItem.VideoMediaItem)paramView).ipJ, ((GalleryItem.VideoMediaItem)paramView).ipK, paramView.tRJ);
          paramView = new f.a((Context)getContext());
          paramView.au((CharSequence)com.tencent.mm.cb.a.az((Context)getContext(), 2131759790));
          paramView.aZu(com.tencent.mm.cb.a.az((Context)getContext(), 2131759769));
          paramView.b((f.c)FinderAlbumUI.b.sLH);
          paramView.show();
          AppMethodBeat.o(167136);
          return;
        }
        new ArrayList(1).add(paramView);
        localObject = this.tWG.HI(((GalleryItem.VideoMediaItem)paramView).getType());
        e.aa((ArrayList)localObject);
        FX(((ArrayList)localObject).indexOf(paramView));
        AppMethodBeat.o(167136);
        return;
      }
      Object localObject = this.tWG.HI(paramView.getType());
      e.aa((ArrayList)localObject);
      FX(((ArrayList)localObject).indexOf(paramView));
    }
    AppMethodBeat.o(167136);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167134);
    super.initView();
    removeOptionMenu(0);
    getController().xt(true);
    addTextOptionMenu(0, cLY(), this.tXn, null, s.b.JwL);
    RecyclerView localRecyclerView = this.tWC;
    d.g.b.p.g(localRecyclerView, "gallery");
    localRecyclerView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    HL(0);
    AppMethodBeat.o(167134);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(167137);
    ae.i("Finder.AlbumUI", "onActivityResult requestCode " + paramInt1 + " resultCod " + paramInt2);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("clear_list", false)))
      {
        paramIntent = this.tWG;
        d.g.b.p.g(paramIntent, "adapter");
        paramIntent.cYt().clear();
        this.tWG.notifyDataSetChanged();
        HL(0);
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
      if ((localObject1 != null) && (this.tWG != null))
      {
        this.tWG.ac((ArrayList)localObject1);
        this.tWG.notifyDataSetChanged();
        HL(((ArrayList)localObject1).size());
      }
      cLX();
      AppMethodBeat.o(167137);
      return;
    }
    if ((291 == paramInt1) && (paramInt2 == -1))
    {
      localObject1 = new ArrayList(1);
      if (paramIntent == null) {
        d.g.b.p.gkB();
      }
      paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      d.g.b.p.g(paramIntent, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
      localObject2 = new GalleryItem.VideoMediaItem();
      ((GalleryItem.VideoMediaItem)localObject2).tRJ = paramIntent.getVideoPath();
      ((GalleryItem.VideoMediaItem)localObject2).ruE = paramIntent.axP();
      ((GalleryItem.VideoMediaItem)localObject2).ipL = ((int)paramIntent.dIU().longValue());
      ((ArrayList)localObject1).add(localObject2);
      paramInt1 = this.sLE;
      localObject2 = this.sLF;
      paramIntent = new Intent();
      paramIntent.putExtra("fromAppBrand", getIntent().getBooleanExtra("fromAppBrand", false));
      paramIntent.putParcelableArrayListExtra("select_path_list", (ArrayList)localObject1);
      paramIntent.putParcelableArrayListExtra("front_vlog_video", null);
      paramIntent.putExtra("select_video_path", (String)localObject2);
      paramIntent.putExtra("select_video_duration", paramInt1);
      paramIntent.setClass((Context)getContext(), FinderMediaCropUI.class);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
      localObject1 = getIntent();
      d.g.b.p.g(localObject1, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a(paramIntent, (Intent)localObject1);
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
      paramIntent = CaptureDataManager.xNV;
      d.g.b.p.g(paramIntent, "CaptureDataManager.INSTANCE");
      a((Context)localObject2, (CaptureDataManager.CaptureVideoNormalModel)localObject1, paramIntent.getExtData());
    }
    AppMethodBeat.o(167137);
  }
  
  public final void onBackBtnClick()
  {
    AppMethodBeat.i(167133);
    com.tencent.mm.plugin.finder.report.g localg = com.tencent.mm.plugin.finder.report.g.syJ;
    com.tencent.mm.plugin.finder.report.g.Fs(3);
    AppMethodBeat.o(167133);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204477);
    super.onCreate(paramBundle);
    String str = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = str;
    if (str == null)
    {
      paramBundle = new StringBuilder();
      d.g.b.p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.a.aiF() + '_' + bu.fpO();
    }
    this.postId = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.g.syJ;
    com.tencent.mm.plugin.finder.report.g.aiJ(this.postId);
    AppMethodBeat.o(204477);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204481);
    CaptureDataManager.xNV.a(null);
    super.onDestroy();
    AppMethodBeat.o(204481);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    AppMethodBeat.i(167132);
    super.updateOptionMenuText(paramInt, cLY());
    AppMethodBeat.o(167132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderAlbumUI
 * JD-Core Version:    0.7.0.1
 */