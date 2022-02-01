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
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.finder.report.e.e;
import com.tencent.mm.plugin.finder.utils.i;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "()V", "originalVideoDuration", "", "originalVideoPath", "", "postId", "checkFinderVideoItemFormatValid", "", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "checkSelectedVideo", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "doCreateVLog", "", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "doEnterMMRecordVLogUI", "enterFinderMediaCropUI", "vlogVideo", "getMenuText", "initView", "isAllPathIsImage", "jumpImagePreviewUI", "mediaPosition", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackBtnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMediaClick", "position", "itemView", "Landroid/view/View;", "itemViewType", "onSendItemClick", "updateOptionMenuText", "menuID", "text", "Companion", "plugin-finder_release"})
public final class FinderAlbumUI
  extends AlbumPreviewUI
{
  public static final a qKS;
  private String postId = "";
  private int qKQ;
  private String qKR = "";
  
  static
  {
    AppMethodBeat.i(167139);
    qKS = new a((byte)0);
    AppMethodBeat.o(167139);
  }
  
  private final void aY(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(199116);
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    int[] arrayOfInt = new int[this.qXm];
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (localMediaItem.getType() == 1)
      {
        if ((k.g(localMediaItem.getMimeType(), "edit")) && (!bt.isNullOrNil(localMediaItem.rBr))) {
          ((ArrayList)localObject1).add(localMediaItem.fXR());
        }
        for (;;)
        {
          arrayOfInt[i] = 1;
          i += 1;
          break;
          ((ArrayList)localObject1).add(localMediaItem.czE());
        }
      }
      if (localMediaItem.getType() != 2) {
        break label229;
      }
      ((ArrayList)localObject2).add(localMediaItem.czE());
      int j = i + 1;
      arrayOfInt[i] = 2;
      i = j;
    }
    label229:
    for (;;)
    {
      break;
      localObject1 = ai.cf((Context)this);
      localObject2 = i.qTa;
      localObject1 = i.fA(((Point)localObject1).x, ((Point)localObject1).y);
      new Point(((Bundle)localObject1).getInt("media_layout_width", -1), ((Bundle)localObject1).getInt("media_layout_height", -1));
      aZ(paramArrayList);
      AppMethodBeat.o(199116);
      return;
    }
  }
  
  private final void aZ(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    int j = 3;
    AppMethodBeat.i(199121);
    Object localObject1 = new UICustomParam.a();
    ((UICustomParam.a)localObject1).Ya();
    ((UICustomParam.a)localObject1).XZ();
    ((UICustomParam.a)localObject1).cO(false);
    ((UICustomParam.a)localObject1).Yb();
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.id("", "");
    localRecordConfigProvider.scene = 11;
    localRecordConfigProvider.vhI = ((UICustomParam.a)localObject1).Yd();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    localRecordConfigProvider.vhH = com.tencent.mm.plugin.finder.storage.b.coC();
    localRecordConfigProvider.vhK = 3;
    localRecordConfigProvider.vhQ = (localRecordConfigProvider.vhH.duration * 1000);
    ((UICustomParam.a)localObject1).cN(false);
    int i = 1;
    localObject1 = ((Iterable)paramArrayList).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).getType() != 2) {
        break label332;
      }
      i = 0;
    }
    label332:
    for (;;)
    {
      break;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelableArrayList("media_list", paramArrayList);
      ((Bundle)localObject1).putString("post_id", this.postId);
      paramArrayList = ai.cf((Context)this);
      localObject2 = i.qTa;
      paramArrayList = i.fA(paramArrayList.x, paramArrayList.y);
      paramArrayList = new Point(paramArrayList.getInt("media_layout_width", -1), paramArrayList.getInt("media_layout_height", -1));
      ((Bundle)localObject1).putInt("KEY_PREVIEW_WIDTH", paramArrayList.x);
      ((Bundle)localObject1).putInt("KEY_PREVIEW_HEIGHT", paramArrayList.y);
      localRecordConfigProvider.hsl = ((Bundle)localObject1);
      localRecordConfigProvider.bx(3, MultiVideoPluginLayout.class.getName());
      localRecordConfigProvider.bx(4, MultiVideoPluginLayout.class.getName());
      if (i != 0) {}
      for (i = j;; i = 4)
      {
        paramArrayList = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
        com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)getContext(), 292, 2130772144, 2130772145, localRecordConfigProvider, i, 0);
        AppMethodBeat.o(199121);
        return;
      }
    }
  }
  
  private final void ahD(int paramInt)
  {
    AppMethodBeat.i(199120);
    Intent localIntent = new Intent((Context)this, ImagePreviewUI.class);
    Object localObject = this.rHw;
    k.g(localObject, "adapter");
    localIntent.putStringArrayListExtra("preview_image_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).cAm());
    localObject = this.rHw;
    k.g(localObject, "adapter");
    localIntent.putParcelableArrayListExtra("preview_media_item_list", ((com.tencent.mm.plugin.gallery.ui.a)localObject).cAn());
    localIntent.putExtra("preview_all", true);
    localIntent.putExtra("preview_position", paramInt);
    ag(paramInt, true);
    localIntent.putExtra("send_raw_img", this.nMQ);
    localIntent.putExtra("key_force_hide_edit_image_button", true);
    localIntent.putExtra("max_select_count", this.qXm);
    localIntent.putExtra("GalleryUI_FromUser", this.dpv);
    localIntent.putExtra("GalleryUI_ToUser", this.toUser);
    localIntent.putExtra("album_business_tag", this.rGX);
    localIntent.putExtra("album_video_max_duration", this.iBF);
    localIntent.putExtra("album_video_min_duration", this.rHU);
    localObject = e.czh();
    k.g(localObject, "GalleryCore.getMediaQueryService()");
    if (((o)localObject).czN() == 14) {
      localIntent.putExtra("key_edit_video_max_time_length", 300500);
    }
    startActivityForResult(localIntent, 0);
    AppMethodBeat.o(199120);
  }
  
  private final String cqR()
  {
    AppMethodBeat.i(167135);
    Object localObject = this.rHw;
    k.g(localObject, "adapter");
    int i = ((com.tencent.mm.plugin.gallery.ui.a)localObject).cAn().size();
    if (i > 0)
    {
      localObject = new StringBuilder();
      AppCompatActivity localAppCompatActivity = getContext();
      k.g(localAppCompatActivity, "context");
      localObject = localAppCompatActivity.getResources().getString(2131755830) + '(' + i + '/' + this.qXm + ')';
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
  
  private final boolean d(GalleryItem.VideoMediaItem paramVideoMediaItem)
  {
    AppMethodBeat.i(199119);
    int i;
    if ((n.I("video/hevc", paramVideoMediaItem.hsS, true)) && (f.cPl())) {
      i = 1;
    }
    for (;;)
    {
      int j = i;
      if (!bt.isNullOrNil(paramVideoMediaItem.hsT))
      {
        j = i;
        if (!n.I("audio/mp4a-latm", paramVideoMediaItem.hsT, true)) {
          j = 0;
        }
      }
      if (com.tencent.mm.modelvideo.r.zK(paramVideoMediaItem.rBp))
      {
        if ((bt.isNullOrNil(paramVideoMediaItem.hsS)) || (!f.aVK(paramVideoMediaItem.hsS)) || (bt.isNullOrNil(paramVideoMediaItem.hsT)) || (!f.aVK(paramVideoMediaItem.hsT))) {
          break label162;
        }
        ad.i("Finder.AlbumUI", "qt video can decode");
      }
      for (j = 1;; j = 0)
      {
        if ((j == 0) || (dp(paramVideoMediaItem.rBp, false))) {
          break label176;
        }
        AppMethodBeat.o(199119);
        return true;
        if (!n.I("video/avc", paramVideoMediaItem.hsS, true)) {
          break label184;
        }
        i = 1;
        break;
        label162:
        ad.i("Finder.AlbumUI", "qt video cannot decode");
      }
      label176:
      AppMethodBeat.o(199119);
      return false;
      label184:
      i = 0;
    }
  }
  
  public final boolean a(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(199118);
    if ((paramMediaItem instanceof GalleryItem.VideoMediaItem))
    {
      boolean bool = d((GalleryItem.VideoMediaItem)paramMediaItem);
      if (!bool)
      {
        e.e locale = e.e.qGc;
        e.e.Y(((GalleryItem.VideoMediaItem)paramMediaItem).hsS, ((GalleryItem.VideoMediaItem)paramMediaItem).hsT, paramMediaItem.rBp);
        h.ce((Context)this, getString(2131759790));
      }
      AppMethodBeat.o(199118);
      return bool;
    }
    AppMethodBeat.o(199118);
    return false;
  }
  
  public final boolean cqQ()
  {
    AppMethodBeat.i(167131);
    if (this.rHY == 25)
    {
      Object localObject = this.rHw;
      k.g(localObject, "adapter");
      localObject = new ArrayList((Collection)((com.tencent.mm.plugin.gallery.ui.a)localObject).cAn());
      if (((ArrayList)localObject).isEmpty())
      {
        ad.e("Finder.AlbumUI", "[onSendItemClick] list isEmpty");
        AppMethodBeat.o(167131);
        return false;
      }
      aY((ArrayList)localObject);
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
    paramView = this.rHw.Eb(paramInt);
    if ((paramView == null) || (bt.isNullOrNil(paramView.czE())))
    {
      if (paramView == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.w("Finder.AlbumUI", "item is null %s, item original path is null", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(167136);
        return;
      }
    }
    if (this.rHY == 25)
    {
      if ((paramView instanceof GalleryItem.VideoMediaItem))
      {
        paramInt = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pru, 300);
        this.qKQ = ((GalleryItem.VideoMediaItem)paramView).hsU;
        localObject = ((GalleryItem.VideoMediaItem)paramView).czE();
        k.g(localObject, "item.originalPath");
        this.qKR = ((String)localObject);
        int i = ((GalleryItem.VideoMediaItem)paramView).hsU;
        localObject = d.awT();
        k.g(localObject, "SubCoreVideoControl.getCore()");
        if (i < ((d)localObject).awZ().minDuration * 1000)
        {
          paramView = (Context)getContext();
          localObject = getResources();
          d locald = d.awT();
          k.g(locald, "SubCoreVideoControl.getCore()");
          h.c(paramView, ((Resources)localObject).getString(2131759821, new Object[] { Integer.valueOf(locald.awZ().minDuration) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        if (((GalleryItem.VideoMediaItem)paramView).hsU > paramInt * 1000)
        {
          h.c((Context)getContext(), getResources().getString(2131759822, new Object[] { Integer.valueOf(paramInt) }), "", false);
          AppMethodBeat.o(167136);
          return;
        }
        ad.i("Finder.AlbumUI", "onMediaClick, video mime:" + ((GalleryItem.VideoMediaItem)paramView).hsS + ", audio mime:" + ((GalleryItem.VideoMediaItem)paramView).hsT + ", path:" + paramView.rBp);
        if (!d((GalleryItem.VideoMediaItem)paramView))
        {
          localObject = e.e.qGc;
          e.e.Y(((GalleryItem.VideoMediaItem)paramView).hsS, ((GalleryItem.VideoMediaItem)paramView).hsT, paramView.rBp);
          paramView = new f.a((Context)getContext());
          paramView.au((CharSequence)com.tencent.mm.cd.a.aq((Context)getContext(), 2131759790));
          paramView.aMs(com.tencent.mm.cd.a.aq((Context)getContext(), 2131759769));
          paramView.b((f.c)FinderAlbumUI.b.qKT);
          paramView.show();
          AppMethodBeat.o(167136);
          return;
        }
        new ArrayList(1).add(paramView);
        localObject = this.rHw.Ea(((GalleryItem.VideoMediaItem)paramView).getType());
        e.Q((ArrayList)localObject);
        ahD(((ArrayList)localObject).indexOf(paramView));
        AppMethodBeat.o(167136);
        return;
      }
      Object localObject = this.rHw.Ea(paramView.getType());
      e.Q((ArrayList)localObject);
      ahD(((ArrayList)localObject).indexOf(paramView));
    }
    AppMethodBeat.o(167136);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167134);
    super.initView();
    removeOptionMenu(0);
    getController().vx(true);
    addTextOptionMenu(0, cqR(), this.rId, null, r.b.FOM);
    RecyclerView localRecyclerView = this.rHs;
    k.g(localRecyclerView, "gallery");
    localRecyclerView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    Ed(0);
    AppMethodBeat.o(167134);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(167137);
    ad.i("Finder.AlbumUI", "onActivityResult requestCode " + paramInt1 + " resultCod " + paramInt2);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("clear_list", false)))
      {
        paramIntent = this.rHw;
        k.g(paramIntent, "adapter");
        paramIntent.cAn().clear();
        this.rHw.notifyDataSetChanged();
        Ed(0);
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
        if ((paramIntent != null) && (this.rHw != null))
        {
          this.rHw.S(paramIntent);
          this.rHw.notifyDataSetChanged();
          Ed(paramIntent.size());
        }
        cqQ();
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
        k.fvU();
      }
      paramIntent = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      k.g(paramIntent, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent;
      localObject2 = new GalleryItem.VideoMediaItem();
      ((GalleryItem.VideoMediaItem)localObject2).rBp = paramIntent.getVideoPath();
      ((GalleryItem.VideoMediaItem)localObject2).pUe = paramIntent.anX();
      ((GalleryItem.VideoMediaItem)localObject2).hsU = ((int)paramIntent.dhB().longValue());
      ((ArrayList)localObject1).add(localObject2);
      paramInt1 = this.qKQ;
      localObject2 = this.qKR;
      paramIntent = new Intent();
      paramIntent.putExtra("fromAppBrand", getIntent().getBooleanExtra("fromAppBrand", false));
      paramIntent.putParcelableArrayListExtra("select_path_list", (ArrayList)localObject1);
      paramIntent.putParcelableArrayListExtra("front_vlog_video", null);
      paramIntent.putExtra("select_video_path", (String)localObject2);
      paramIntent.putExtra("select_video_duration", paramInt1);
      paramIntent.setClass((Context)getContext(), FinderMediaCropUI.class);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
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
        k.fvU();
      }
      localObject1 = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      k.g(localObject1, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      localObject2 = (CaptureDataManager.CaptureVideoNormalModel)localObject1;
      localObject1 = new Intent();
      if ((((CaptureDataManager.CaptureVideoNormalModel)localObject2).fYa() == null) || (((CaptureDataManager.CaptureVideoNormalModel)localObject2).fYa().size() <= 0)) {
        break label786;
      }
      ((Intent)localObject1).putExtra("postType", 2);
      paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).fYa();
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
      paramIntent = ((CaptureDataManager.CaptureVideoNormalModel)localObject2).fYa();
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
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.Z(new String[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject2).anX() }));
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)((CaptureDataManager.CaptureVideoNormalModel)localObject2).dhD().w("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramIntent = com.tencent.mm.plugin.finder.utils.a.qSb;
      paramIntent = getIntent();
      k.g(paramIntent, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a((Intent)localObject1, paramIntent);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, (Intent)localObject1);
      AppMethodBeat.o(167137);
      return;
      label786:
      paramIntent = paramIntent.getBundleExtra("key_extra_data").getByteArray("video_composition");
      if (paramIntent != null) {
        ((Intent)localObject1).putExtra("video_composition", paramIntent);
      }
      ((Intent)localObject1).putExtra("postType", 4);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)j.Z(new String[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject2).getVideoPath() }));
      ((Intent)localObject1).putExtra("postTypeList", (Serializable)j.Z(new Integer[] { Integer.valueOf(4) }));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.Z(new String[] { ((CaptureDataManager.CaptureVideoNormalModel)localObject2).anX() }));
    }
  }
  
  public final void onBackBtnClick()
  {
    AppMethodBeat.i(167133);
    com.tencent.mm.plugin.finder.report.a locala = com.tencent.mm.plugin.finder.report.a.qFo;
    com.tencent.mm.plugin.finder.report.a.CL(3);
    AppMethodBeat.o(167133);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199117);
    super.onCreate(paramBundle);
    String str = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = str;
    if (str == null)
    {
      paramBundle = new StringBuilder();
      k.g(g.afz(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.a.aeo() + '_' + bt.eGO();
    }
    this.postId = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.a.qFo;
    com.tencent.mm.plugin.finder.report.a.aVu(this.postId);
    AppMethodBeat.o(199117);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void updateOptionMenuText(int paramInt, String paramString)
  {
    AppMethodBeat.i(167132);
    super.updateOptionMenuText(paramInt, cqR());
    AppMethodBeat.o(167132);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderAlbumUI$Companion;", "", "()V", "REQUEST_CODE_EDIT_VIDEO", "", "REQUEST_CODE_EDIT_VLOG", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderAlbumUI
 * JD-Core Version:    0.7.0.1
 */