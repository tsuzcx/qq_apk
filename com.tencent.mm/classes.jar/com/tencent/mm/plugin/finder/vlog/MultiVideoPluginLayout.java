package com.tencent.mm.plugin.finder.vlog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.w;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.b.b.b;
import com.tencent.mm.plugin.gallery.picker.b.b.e;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.vlog.model.ab;
import com.tencent.mm.plugin.vlog.model.k.c;
import com.tencent.mm.plugin.vlog.model.u.a;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.ui.plugin.a.e;
import com.tencent.mm.plugin.vlog.ui.plugin.h.b;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.Player;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bh;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "calculatePlugin", "Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "captionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropVideoPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin;", "currentPath", "", "currentStyle", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editId", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editReport", "Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport;", "edited", "", "footRecyclerViewPlugin", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "isInImageEdit", "lastMusicPosition", "", "maxCropVideoDurationMs", "", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "multiHintTextPlugin", "Lcom/tencent/mm/plugin/finder/vlog/MultiHintTextPlugin;", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiPreviewPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoEditItemContainer", "Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin;", "postId", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "sortCallback", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$sortCallback$1", "Lcom/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$sortCallback$1;", "thumbLoadingPlugin", "Lcom/tencent/mm/plugin/finder/vlog/ThumbLoadingPlugin;", "vLogMode", "vLogThumbPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin;", "vLogTrackEditPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "videoEditItemContainer", "Lcom/tencent/mm/plugin/recordvideo/plugin/MultiEditItemContainerPlugin;", "vlogSelectPlugin", "Lcom/tencent/mm/plugin/finder/vlog/EditImageVLogSelectPlugin;", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "exportVideo", "", "musicPath", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "thumb", "generateCropImage", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "resultImage", "", "outputModel", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "index", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;[Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;I)V", "getLayoutId", "hideOperation", "initLogic", "initSafeArea", "loadCurrentPage", "model", "onBackPress", "release", "reportEdit", "requestVLogScript", "sid", "fid", "Lkotlin/Function0;", "reset", "setupImageEditPlugins", "selectFirst", "setupMediaData", "Lkotlinx/coroutines/Job;", "setupNormalVideoPlugins", "setupVLogVideoPlugins", "showImageEditPlugins", "showOperation", "showVideoEditPlugins", "startMux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class MultiVideoPluginLayout
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final MultiVideoPluginLayout.a she;
  private String editId;
  private String kLZ;
  private String postId;
  private com.tencent.mm.plugin.recordvideo.activity.a rRh;
  private RecordConfigProvider rRi;
  private final d sgA;
  private final com.tencent.mm.plugin.recordvideo.plugin.a sgB;
  private final com.tencent.mm.plugin.recordvideo.plugin.c sgC;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a sgD;
  private final com.tencent.mm.plugin.vlog.ui.plugin.e sgE;
  private final com.tencent.mm.plugin.recordvideo.plugin.f sgF;
  private final com.tencent.mm.plugin.recordvideo.plugin.e sgG;
  private final com.tencent.mm.plugin.recordvideo.plugin.ac sgH;
  private final com.tencent.mm.plugin.recordvideo.plugin.p sgI;
  private final com.tencent.mm.plugin.recordvideo.plugin.q sgJ;
  private final com.tencent.mm.plugin.recordvideo.plugin.g sgK;
  private final com.tencent.mm.plugin.vlog.ui.plugin.caption.b sgL;
  private final g sgM;
  private final com.tencent.mm.plugin.vlog.model.k sgN;
  private com.tencent.mm.plugin.vlog.ui.plugin.a sgO;
  private a sgP;
  private com.tencent.mm.plugin.recordvideo.plugin.m sgQ;
  private b sgR;
  private com.tencent.mm.plugin.vlog.ui.plugin.h sgS;
  private final com.tencent.mm.plugin.vlog.ui.plugin.i sgT;
  private c sgU;
  private com.tencent.mm.plugin.recordvideo.e.e sgV;
  private int sgW;
  private boolean sgX;
  private ArrayList<GalleryItem.MediaItem> sgY;
  private WxCropOperationLayout.j sgZ;
  private com.tencent.mm.media.widget.camerarecordview.b.b sgm;
  private final long sgx;
  private final com.tencent.mm.plugin.recordvideo.plugin.u sgy;
  private final com.tencent.mm.plugin.recordvideo.plugin.r sgz;
  private com.tencent.mm.plugin.recordvideo.d.b sha;
  private boolean shb;
  private boolean shc;
  private final j shd;
  
  static
  {
    AppMethodBeat.i(204853);
    she = new MultiVideoPluginLayout.a((byte)0);
    AppMethodBeat.o(204853);
  }
  
  public MultiVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204852);
    paramAttributeSet = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.sgx = (com.tencent.mm.plugin.finder.storage.b.cze() * 1000L);
    this.sgH = new com.tencent.mm.plugin.recordvideo.plugin.ac(paramContext);
    this.kLZ = "";
    this.sgN = new com.tencent.mm.plugin.vlog.model.k();
    this.sgV = new com.tencent.mm.plugin.recordvideo.e.e();
    this.postId = "";
    this.editId = "";
    this.sgY = new ArrayList();
    this.sgZ = WxCropOperationLayout.j.wzH;
    this.sha = new com.tencent.mm.plugin.recordvideo.d.b();
    this.shd = new j(this);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "init VLogTAVKitPreviewPluginLayout");
    LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131307877);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.multi_crop_layout)");
    paramAttributeSet = (CropLayout)paramAttributeSet;
    Object localObject = findViewById(2131307305);
    d.g.b.k.g(localObject, "findViewById(R.id.crop_ope_layout)");
    this.sgO = new com.tencent.mm.plugin.vlog.ui.plugin.a(paramAttributeSet, (WxCropOperationLayout)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = this.sgO;
    if (paramAttributeSet == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    paramAttributeSet.sgN = this.sgN;
    paramAttributeSet = (ViewGroup)this;
    localObject = findViewById(2131299273);
    d.g.b.k.g(localObject, "findViewById(R.id.editor_add_emoji)");
    this.sgB = new com.tencent.mm.plugin.recordvideo.plugin.a(paramAttributeSet, (ImageView)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131308057);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_editor_item_container)");
    this.sgy = new com.tencent.mm.plugin.recordvideo.plugin.u((EditorItemContainer)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = this.sgO;
    if (paramAttributeSet == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    localObject = (CropLayout.b)this.sgy.wsp;
    paramAttributeSet.AsV.setCropLayoutTouchListener((CropLayout.b)localObject);
    paramAttributeSet = findViewById(2131298784);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.control_container)");
    this.sgz = new com.tencent.mm.plugin.recordvideo.plugin.r((ViewGroup)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131307911);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.photo_editor_item_container)");
    this.sgA = new d((FrameLayout)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131297952);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.sgK = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramAttributeSet);
    this.sgC = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, this.sgK.wsh);
    this.sgD = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.sgD.wvm.setBackground(2131234973);
    this.sgE = new com.tencent.mm.plugin.vlog.ui.plugin.e((View)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131299295);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.editor_mix)");
    this.sgF = new com.tencent.mm.plugin.recordvideo.plugin.f(paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131299285);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.editor_close)");
    this.sgG = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131299621);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.ext_text_area)");
    this.sgI = new com.tencent.mm.plugin.recordvideo.plugin.p((TextView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131303907);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.recorder_black_mask)");
    this.sgJ = new com.tencent.mm.plugin.recordvideo.plugin.q((ImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131308063);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.vlog_editor_multi_hint_text)");
    this.sgU = new c((TextView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131300206);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.footer_preview)");
    this.sgP = new a((RecyclerView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.sgQ = new com.tencent.mm.plugin.recordvideo.plugin.m((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = this.sgK.wsh.getCaptionView();
    if (paramAttributeSet == null) {
      d.g.b.k.fOy();
    }
    this.sgL = new com.tencent.mm.plugin.vlog.ui.plugin.caption.b(paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131307915);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.preview_thumb)");
    this.sgM = new g((ImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = this.sgO;
    if (paramAttributeSet == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    float f1 = paramAttributeSet.AsI.top;
    paramAttributeSet = this.sgO;
    if (paramAttributeSet == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    f1 = (f1 + paramAttributeSet.AsI.bottom) / 2.0F;
    paramAttributeSet = this.sgM;
    f1 -= aq.cl(paramContext).y / 2;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ThumbLoadingPlugin", "setTranslateY ".concat(String.valueOf(f1)));
    paramAttributeSet.qQT.setTranslationY(f1);
    boolean bool = this.sgN.Ang;
    paramContext = findViewById(2131307321);
    d.g.b.k.g(paramContext, "findViewById(R.id.edit_vlog_select_content_parent)");
    this.sgR = new b((ViewGroup)paramContext, bool, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.sgS = new com.tencent.mm.plugin.vlog.ui.plugin.h((View)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.sgS.AtF = ((h.b)this.shd);
    paramContext = this.sgO;
    if (paramContext == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    paramContext.a((com.tencent.mm.plugin.vlog.ui.plugin.a.b)this.sgS);
    paramContext = findViewById(2131307324);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_track_edit_panel)");
    this.sgT = new com.tencent.mm.plugin.vlog.ui.plugin.i((EditorPanelHolder)paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    getPluginList().add(this.sgT);
    paramContext = this.sgO;
    if (paramContext == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    paramContext.a((com.tencent.mm.plugin.vlog.ui.plugin.a.b)this.sgT);
    getPluginList().add(this.sgB);
    getPluginList().add(this.sgy);
    getPluginList().add(this.sgz);
    getPluginList().add(this.sgA);
    getPluginList().add(this.sgC);
    getPluginList().add(this.sgD);
    getPluginList().add(this.sgE);
    getPluginList().add(this.sgF);
    getPluginList().add(this.sgH);
    getPluginList().add(this.sgG);
    getPluginList().add(this.sgI);
    getPluginList().add(this.sgJ);
    getPluginList().add(this.sgL);
    getPluginList().add(this.sgR);
    getPluginList().add(this.sgS);
    paramContext = getPluginList();
    paramAttributeSet = this.sgO;
    if (paramAttributeSet == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    paramContext.add(paramAttributeSet);
    getPluginList().add(this.sgU);
    getPluginList().add(this.sgP);
    getPluginList().add(this.sgV);
    getPluginList().add(this.sgM);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.wra;
    int i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.wra;
    int j = com.tencent.mm.plugin.recordvideo.model.a.dvp();
    f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = i;
    float f5 = (i - f4) / 2.0F;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "initSafeArea, displaySize:[" + j + ", " + i + "], scale:" + f1 + ", safeAreaWidth:" + f2 + ", safeAreaFrameWidth:" + f3 + ", safeAreaHeight:" + f4 + ", safeAreaFrameHeight:" + f5);
    if (f1 <= 1.78F)
    {
      this.sgK.bp(f3);
      this.sgy.V(f2, f3);
      AppMethodBeat.o(204852);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.sgK.bq(f3);
      this.sgy.W(f4, f5);
      AppMethodBeat.o(204852);
      return;
    }
    this.sgK.bp(f3);
    this.sgK.bq(f3);
    this.sgy.V(f2, f3);
    this.sgy.W(f4, f5);
    AppMethodBeat.o(204852);
  }
  
  private final void a(final b.e parame, final String[] paramArrayOfString, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, final int paramInt)
  {
    AppMethodBeat.i(204839);
    d locald = this.sgA;
    Object localObject = this.sgN.And.get(paramInt);
    d.g.b.k.g(localObject, "multiMedia.pathList[index]");
    locald.b((String)localObject, (d.g.a.q)new c(this, paramInt, parame, paramArrayOfString, paramCaptureVideoNormalModel));
    AppMethodBeat.o(204839);
  }
  
  private final void c(int paramInt, final d.g.a.a<y> parama)
  {
    AppMethodBeat.i(204846);
    com.tencent.mm.plugin.vlog.model.k localk = this.sgN;
    parama = (d.g.a.a)new f(this, parama);
    d.g.b.k.h(parama, "callback");
    if ((paramInt == 0) && (localk.Ans))
    {
      parama.invoke();
      AppMethodBeat.o(204846);
      return;
    }
    localk.Ano = parama;
    localk.isLoading = true;
    parama = localk.Anp;
    List localList = (List)localk.Anf;
    d.g.b.k.h(localList, "sourceTrackList");
    parama.Ane.clear();
    parama.Ane.addAll((Collection)localList);
    localk.Anp.a(paramInt, localk.Anq);
    AppMethodBeat.o(204846);
  }
  
  private final void c(String paramString, final d.g.a.q<? super Boolean, ? super yo, ? super Bitmap, y> paramq)
  {
    int j = 0;
    AppMethodBeat.i(204845);
    Object localObject1 = this.rRi;
    if (localObject1 == null) {
      d.g.b.k.fOy();
    }
    final String str = ((RecordConfigProvider)localObject1).wqG;
    final float[] arrayOfFloat = this.sgy.dvO();
    final ArrayList localArrayList = this.sgy.dvN();
    localObject1 = com.tencent.mm.plugin.recordvideo.plugin.u.a(this.sgy);
    Object localObject2 = new StringBuilder("exportVideo, editor item drawing rect:");
    Object localObject3 = Arrays.toString(arrayOfFloat);
    d.g.b.k.g(localObject3, "java.util.Arrays.toString(this)");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", (String)localObject3 + ", editData:" + localArrayList.size() + ", editItems:" + ((ArrayList)localObject1).size());
    localObject1 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).agA().get(ah.a.GVU, Integer.valueOf(-1));
    final boolean bool1;
    int i;
    if (d.g.b.k.g(localObject1, Integer.valueOf(0)))
    {
      bool1 = false;
      localObject1 = this.sgO;
      if (localObject1 == null) {
        d.g.b.k.aVY("multiPreviewPlugin");
      }
      if (((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject1).AsL) {
        break label491;
      }
      i = 1;
      label200:
      if (i != 0) {
        break label496;
      }
      localObject1 = this.sgN.efu();
      label213:
      localObject2 = this.sgO;
      if (localObject2 == null) {
        d.g.b.k.aVY("multiPreviewPlugin");
      }
      localObject2 = new Rect(((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject2).ege());
      localObject3 = new com.tencent.mm.plugin.vlog.model.r(this.sgN.AmR);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "exportVideo musicPath:" + paramString + ", remuxBackgroud:" + bool1);
      if (paramString != null) {
        ((com.tencent.mm.plugin.vlog.model.r)localObject3).ayj(paramString);
      }
      if (this.sgD.wvm.getMuteOrigin()) {
        break label508;
      }
    }
    label409:
    label491:
    label496:
    label508:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((com.tencent.mm.plugin.vlog.model.r)localObject3).sj(bool2);
      final com.tencent.mm.plugin.vlog.model.b localb = new com.tencent.mm.plugin.vlog.model.b((com.tencent.mm.plugin.vlog.model.r)localObject3);
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        i = j;
        if (!((Collection)localArrayList).isEmpty()) {
          i = 1;
        }
        if ((i == 0) && (((List)((com.tencent.mm.plugin.vlog.model.r)localObject3).AnT).size() <= 1))
        {
          paramString = this.sgm;
          if ((paramString == null) || (paramString.hbH != true)) {
            break label409;
          }
        }
      }
      this.shc = true;
      com.tencent.mm.ac.c.b("MultiVideoPluginLayout_exportVideo", (d.g.a.a)new b(this, localb, str, (Size)localObject1, (Rect)localObject2, arrayOfFloat, localArrayList, bool1, (com.tencent.mm.plugin.vlog.model.r)localObject3, paramq));
      AppMethodBeat.o(204845);
      return;
      if (d.g.b.k.g(localObject1, Integer.valueOf(1)))
      {
        bool1 = true;
        break;
      }
      bool1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbw, true);
      break;
      i = 0;
      break label200;
      localObject1 = this.sgN.efv();
      break label213;
    }
  }
  
  private final void cGl()
  {
    AppMethodBeat.i(204840);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "showImageEditPlugins");
    this.sgD.setVisibility(8);
    this.sgD.dwi();
    this.sgE.setVisibility(8);
    this.sgS.setVisibility(8);
    this.sgP.setVisibility(0);
    this.sgQ.setVisibility(0);
    this.sgA.setVisibility(0);
    this.sgU.setVisibility(8);
    AppMethodBeat.o(204840);
  }
  
  private final void cGm()
  {
    AppMethodBeat.i(204842);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "showVideoEditPlugins");
    this.sgD.setVisibility(0);
    this.sgE.setVisibility(0);
    this.sgS.setVisibility(0);
    this.sgP.setVisibility(8);
    this.sgQ.setVisibility(8);
    this.sgA.setVisibility(8);
    AppMethodBeat.o(204842);
  }
  
  private final void cGn()
  {
    AppMethodBeat.i(204844);
    com.tencent.mm.plugin.vlog.ui.plugin.a locala = this.sgO;
    if (locala == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    locala.AsW.setStyle(this.sgZ);
    this.sgz.setVisibility(0);
    if (!this.sgX)
    {
      if (this.sgN.And.size() > 1) {
        this.sgU.setVisibility(0);
      }
      this.sgS.setVisibility(0);
    }
    AppMethodBeat.o(204844);
  }
  
  private final void cGo()
  {
    int k = 0;
    AppMethodBeat.i(204848);
    this.sha.wxX.hX(this.sgS.AtE);
    Object localObject1 = this.sha.wxX;
    Object localObject2 = this.sgO;
    if (localObject2 == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    ((cq)localObject1).hW(((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject2).AsM);
    localObject1 = this.sha.wxX;
    if (this.sgN.AmR.efz() > 60000L) {}
    for (long l = 1L;; l = 0L)
    {
      ((cq)localObject1).hY(l);
      localObject1 = this.sha;
      Object localObject3 = (Iterable)this.sgN.Anf;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((com.tencent.mm.plugin.vlog.model.u)((Iterator)localObject3).next()).AoE);
      }
    }
    ((com.tencent.mm.plugin.recordvideo.d.b)localObject1).g((List)localObject2, this.sgN.Ang);
    this.sha.wxX.aHZ();
    this.sha.reset();
    int i;
    if (((List)this.sgN.Anf).size() == 1)
    {
      i = 0;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(this.sgy.dvQ()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(this.sgy.dvR()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      if (this.sgD.wpt != null) {
        break label473;
      }
      j = 0;
      label306:
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_MUSIC_INT", Integer.valueOf(j));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      if (!this.sgD.wvm.getMuteOrigin()) {
        break label478;
      }
    }
    label473:
    label478:
    for (int j = k;; j = 1)
    {
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_SELECT_ORIGIN_INT", Integer.valueOf(j));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MULTI_MEDIA_POST_ID_STRING", this.postId);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MULTI_MEDIA_EDIT_ID_STRING", this.editId);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(i));
      AppMethodBeat.o(204848);
      return;
      if (this.sgN.Anh)
      {
        i = 2;
        break;
      }
      if ((this.sgN.Ang) && (this.sgN.efw()))
      {
        i = 1;
        break;
      }
      if (this.sgN.Ang)
      {
        i = 0;
        break;
      }
      i = 3;
      break;
      j = 1;
      break label306;
    }
  }
  
  private final void cas()
  {
    AppMethodBeat.i(204843);
    this.sgz.setVisibility(4);
    this.sgU.setVisibility(4);
    com.tencent.mm.plugin.vlog.ui.plugin.a locala = this.sgO;
    if (locala == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    locala.AsW.setStyle(WxCropOperationLayout.j.wzI);
    this.sgS.setVisibility(8);
    AppMethodBeat.o(204843);
  }
  
  private final void setupImageEditPlugins(boolean paramBoolean)
  {
    AppMethodBeat.i(204841);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "setupImageEditPlugins, selectFirst:".concat(String.valueOf(paramBoolean)));
    Object localObject = this.sgO;
    if (localObject == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    ((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject).stopPreview();
    localObject = this.sgO;
    if (localObject == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    localObject = ((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject).sOk;
    if (localObject != null) {
      ((VLogCompositionPlayView)localObject).setVisibility(8);
    }
    cGl();
    if (paramBoolean)
    {
      localObject = this.sgP;
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((a)localObject).sgc.get(0);
      ((a)localObject).rIq = localMediaItem.sKk;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE", (Parcelable)localMediaItem);
      ((a)localObject).rTT.a(d.c.wxs, localBundle);
    }
    this.sgX = true;
    AppMethodBeat.o(204841);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(204837);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "loadCurrentPage time:" + System.currentTimeMillis() + " model:" + paramb);
    super.a(paramb);
    Object localObject = this.sgV;
    d.g.b.k.h("start", "tag");
    long l = System.currentTimeMillis();
    ((Map)((com.tencent.mm.plugin.recordvideo.e.e)localObject).wDV).put("start", Long.valueOf(l));
    this.sgm = paramb;
    kotlinx.coroutines.f.b((ag)bh.LRM, (d.d.f)ay.gdO(), (d.g.a.m)new g(this, null), 2);
    if (paramb != null)
    {
      localObject = this.sgA;
      RecordConfigProvider localRecordConfigProvider = this.rRi;
      if (localRecordConfigProvider == null) {
        d.g.b.k.fOy();
      }
      d.g.b.k.h(localRecordConfigProvider, "configProvider");
      d.g.b.k.h(paramb, "captureInfo");
      ((d)localObject).rRi = localRecordConfigProvider;
      ((d)localObject).sgm = paramb;
    }
    l = bs.eWj();
    paramb = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(l));
    paramb = new StringBuilder();
    d.g.b.k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
    this.editId = (com.tencent.mm.kernel.a.afE() + '_' + l);
    this.sha.wxX.kC(this.editId);
    this.sgS.AtE = 0;
    paramb = this.sgO;
    if (paramb == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    paramb.AsM = 0;
    AppMethodBeat.o(204837);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    AppMethodBeat.i(204836);
    d.g.b.k.h(parama, "navigator");
    d.g.b.k.h(paramRecordConfigProvider, "configProvider");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "initLogic");
    this.rRh = parama;
    this.rRi = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.wDE;
    com.tencent.mm.plugin.recordvideo.e.b.e(paramRecordConfigProvider);
    parama = this.sgy;
    d.g.b.k.h(paramRecordConfigProvider, "configProvider");
    parama.wsp.a(paramRecordConfigProvider);
    this.sgE.setVisibility(8);
    com.tencent.mm.plugin.recordvideo.plugin.f localf = this.sgF;
    parama = paramRecordConfigProvider.wqu;
    label123:
    Object localObject2;
    label141:
    Object localObject3;
    label162:
    label197:
    label218:
    label249:
    boolean bool;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.fKz);
      localObject1 = paramRecordConfigProvider.wqu;
      if (localObject1 == null) {
        break label457;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fKA);
      localObject2 = paramRecordConfigProvider.wqu;
      if (localObject2 == null) {
        break label463;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.wqu;
      if (localObject3 == null) {
        break label469;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).fKB);
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.sgD;
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label475;
      }
      parama = Integer.valueOf(parama.fKz);
      localObject1 = paramRecordConfigProvider.wqu;
      if (localObject1 == null) {
        break label480;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fKA);
      ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2).a(parama, (Integer)localObject1, 2131691551);
      localObject1 = this.sgI;
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label486;
      }
      parama = parama.fKC;
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = this.sgC;
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label491;
      }
      parama = Integer.valueOf(parama.fKz);
      label278:
      localObject3 = paramRecordConfigProvider.wqu;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).fKA);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      parama = this.sgO;
      if (parama == null) {
        d.g.b.k.aVY("multiPreviewPlugin");
      }
      parama.AsK = ((CropLayout.c)new d(this));
      parama = ((Iterable)getPluginList()).iterator();
      label354:
      if (!parama.hasNext()) {
        break label513;
      }
      localObject1 = (t)parama.next();
      localObject2 = paramRecordConfigProvider.wqu;
      if (localObject2 == null) {
        break label496;
      }
      localObject2 = ((UICustomParam)localObject2).fKy;
      if (localObject2 == null) {
        break label496;
      }
      localObject2 = (Boolean)((Map)localObject2).get(((t)localObject1).name());
      if (localObject2 == null) {
        break label496;
      }
      bool = ((Boolean)localObject2).booleanValue();
      label428:
      if (bool) {
        break label502;
      }
      i = 1;
      label435:
      if (i == 0) {
        break label507;
      }
    }
    label457:
    label463:
    label469:
    label475:
    label480:
    label486:
    label491:
    label496:
    label502:
    label507:
    for (int i = 0;; i = 8)
    {
      ((t)localObject1).setVisibility(i);
      break label354;
      parama = null;
      break;
      localObject1 = null;
      break label123;
      localObject2 = null;
      break label141;
      localObject3 = null;
      break label162;
      parama = null;
      break label197;
      localObject1 = null;
      break label218;
      parama = null;
      break label249;
      parama = null;
      break label278;
      bool = false;
      break label428;
      i = 0;
      break label435;
    }
    label513:
    parama = new e(this);
    this.sgS.AsO = ((a.e)parama);
    paramRecordConfigProvider = this.sgO;
    if (paramRecordConfigProvider == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    paramRecordConfigProvider.AsO = ((a.e)parama);
    paramRecordConfigProvider = this.sgT;
    Object localObject1 = this.sgO;
    if (localObject1 == null) {
      d.g.b.k.aVY("multiPreviewPlugin");
    }
    localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject1).AsN;
    parama = (a.e)parama;
    paramRecordConfigProvider.AsN = ((a.e)localObject1);
    paramRecordConfigProvider.AsO = parama;
    this.sgS.AtI = false;
    AppMethodBeat.o(204836);
  }
  
  public final void a(final d.c paramc, final Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    int i = 1;
    AppMethodBeat.i(204838);
    d.g.b.k.h(paramc, "status");
    Object localObject1 = d.c.wwI;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "statusChange " + paramc + "  param:" + paramBundle);
    int j;
    label575:
    label1261:
    label1272:
    long l1;
    switch (f.cfA[paramc.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "unknown key ".concat(String.valueOf(paramc)));
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
      do
      {
        AppMethodBeat.o(204838);
        return;
        this.sgy.wsp.bringToFront();
        cas();
        AppMethodBeat.o(204838);
        return;
        this.sgJ.dwa();
        AppMethodBeat.o(204838);
        return;
        if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP"))) {
          this.sgD.dwk();
        }
        this.sgM.hideLoading();
        AppMethodBeat.o(204838);
        return;
        post((Runnable)new o(this));
        cGn();
        paramc = this.sgy;
        paramBundle = paramc.wsn;
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        paramc = paramc.wso;
        if (paramc != null)
        {
          paramc.setVisibility(0);
          AppMethodBeat.o(204838);
          return;
        }
        AppMethodBeat.o(204838);
        return;
        if (paramBundle != null)
        {
          paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
          if (paramc != null)
          {
            paramBundle = this.sgy;
            if (paramc != null) {
              paramBundle.wsp.C(paramc);
            }
            paramc = y.KTp;
            AppMethodBeat.o(204838);
            return;
          }
        }
        AppMethodBeat.o(204838);
        return;
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          paramc = this.sgy;
          paramBundle = localObject1.toString();
          d.g.b.k.h(paramBundle, "text");
          if (paramc.wsn == null) {
            break label575;
          }
          localObject1 = paramc.wsn;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject1).setVisibility(0);
          }
          localObject1 = paramc.wsn;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject1).setText((CharSequence)paramBundle, i, j);
          }
          paramc.wsn = null;
        }
        for (;;)
        {
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
          paramc.wsp.k((CharSequence)paramBundle, i, j);
        }
        if (paramBundle != null)
        {
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          this.sgC.g(paramc, i, j);
          paramc = y.KTp;
        }
        AppMethodBeat.o(204838);
        return;
        cas();
        this.sgN.RQ(-1);
        this.sgS.setVisibility(8);
        paramc = this.sgT;
        if (!this.sgN.efw()) {}
        for (bool1 = true;; bool1 = false)
        {
          paramc.setEnableLengthEdit(bool1);
          this.sgT.setTrack(this.sgN.AmR);
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          paramc.ao(this.sgN.efw(), this.sgD.wvm.getMuteOrigin());
          AppMethodBeat.o(204838);
          return;
        }
        if (paramBundle != null)
        {
          paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
          paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
          paramc = y.KTp;
        }
        AppMethodBeat.o(204838);
        return;
        AppMethodBeat.o(204838);
        return;
        AppMethodBeat.o(204838);
        return;
        if (paramBundle != null)
        {
          paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
          paramc = y.KTp;
        }
        AppMethodBeat.o(204838);
        return;
        AppMethodBeat.o(204838);
        return;
        this.sgP.setVisibility(4);
        AppMethodBeat.o(204838);
        return;
        paramc = this.sgm;
        if (paramc != null)
        {
          paramBundle = this.rRi;
          if (paramBundle != null) {
            i = paramBundle.wqC;
          }
          while (paramc.hbI - paramc.cSh > i + 250)
          {
            paramc = getContext();
            if (paramc == null)
            {
              paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(204838);
              throw paramc;
              i = 10000;
            }
            else
            {
              ((Activity)paramc).setResult(3000);
              paramc = getContext();
              if (paramc == null)
              {
                paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(204838);
                throw paramc;
              }
              ((Activity)paramc).finish();
              AppMethodBeat.o(204838);
              return;
            }
          }
          this.sgz.setVisibility(0);
          this.sgy.dvP();
          paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
        }
        AppMethodBeat.o(204838);
        return;
        this.sgz.setVisibility(0);
        this.sgD.dwk();
        this.sgy.dvP();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(204838);
        return;
        alO();
        AppMethodBeat.o(204838);
        return;
        Object localObject3;
        if (paramBundle != null)
        {
          bool1 = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
          paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
          paramc = new ArrayList();
          if (paramBundle != null)
          {
            paramBundle = ((Iterable)paramBundle.wrS).iterator();
            for (;;)
            {
              if (paramBundle.hasNext())
              {
                byte[] arrayOfByte = (byte[])paramBundle.next();
                localObject1 = new brn();
                localObject3 = (com.tencent.mm.bw.a)localObject1;
                try
                {
                  ((com.tencent.mm.bw.a)localObject3).parseFrom(arrayOfByte);
                  paramc.add(localObject1);
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ac.l("safeParser", "", new Object[] { localException });
                  }
                }
              }
            }
            paramBundle = y.KTp;
          }
          paramBundle = this.sgy;
          paramc = (List)paramc;
          d.g.b.k.h(paramc, "lyricsInfo");
          if (!bool1) {
            break label1272;
          }
          if (!paramBundle.wsp.dwT()) {
            break label1261;
          }
          paramBundle.wsp.eT(paramc);
        }
        for (;;)
        {
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
          paramBundle.wsp.eU(paramc);
          continue;
          paramBundle.wsp.dwU();
        }
        if (paramBundle != null)
        {
          if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.item.b.wCN.ordinal()) {
            this.sgD.dwj();
          }
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
        }
        AppMethodBeat.o(204838);
        return;
        this.sgM.Fl(2131764707);
        paramc = this.rRi;
        if (paramc == null) {
          d.g.b.k.fOy();
        }
        paramc = paramc.wqG;
        this.sha.wxX.hZ(2L);
        cGo();
        paramBundle = (d.g.a.q)new l(this, paramc);
        if (this.sgR.oae == 1) {}
        while (i != 0)
        {
          paramBundle = new b.b();
          localObject1 = com.tencent.mm.plugin.finder.utils.p.rQw;
          paramBundle.agu(com.tencent.mm.plugin.finder.utils.p.cDv());
          localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
          paramBundle.maxHeight = com.tencent.mm.plugin.finder.storage.b.cyf();
          localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
          paramBundle.maxWidth = com.tencent.mm.plugin.finder.storage.b.cyg();
          localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
          paramBundle.sMo = com.tencent.mm.plugin.finder.storage.b.cyh();
          paramBundle = new b.e(paramBundle);
          localObject1 = new String[this.sgN.And.size()];
          Object localObject2 = Boolean.TRUE;
          localObject3 = Boolean.TRUE;
          com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          paramc = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject2, paramc, "", Long.valueOf(0L), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.c.dwq());
          localObject2 = com.tencent.mm.plugin.finder.report.c.rxi;
          localObject2 = paramc.dvk();
          d.g.b.k.g(localObject2, "outputModel.reportInfo");
          com.tencent.mm.plugin.finder.report.c.b((RecordMediaReportInfo)localObject2);
          a(paramBundle, (String[])localObject1, paramc, 0);
          AppMethodBeat.o(204838);
          return;
          i = 0;
        }
        paramc = this.sgO;
        if (paramc == null) {
          d.g.b.k.aVY("multiPreviewPlugin");
        }
        paramc.onPause();
        this.sgD.onPause();
        if (this.sgD.wpt != null)
        {
          paramc = com.tencent.mm.plugin.recordvideo.model.audio.i.wrV;
          paramc = com.tencent.mm.plugin.recordvideo.model.audio.i.dvK();
          localObject1 = this.sgD.wpt;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          paramc.a((AudioCacheInfo)localObject1, (d.g.a.m)new k(this, paramBundle));
          AppMethodBeat.o(204838);
          return;
        }
        c(null, paramBundle);
        AppMethodBeat.o(204838);
        return;
        if (paramBundle != null)
        {
          paramc = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
          if (paramc != null)
          {
            i = paramc.dbL;
            paramBundle = AudioCacheInfo.wry;
            if (i == AudioCacheInfo.dvB())
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "current script index is :" + paramc.position);
              if (paramc.position != this.sgW)
              {
                if (this.sgR.oae != 3) {
                  break label1899;
                }
                i = 1;
                if (i != 0)
                {
                  this.sgN.ay(paramc.position, this.sgx);
                  paramBundle = this.sgO;
                  if (paramBundle == null) {
                    d.g.b.k.aVY("multiPreviewPlugin");
                  }
                  localObject1 = this.sgO;
                  if (localObject1 == null) {
                    d.g.b.k.aVY("multiPreviewPlugin");
                  }
                  paramBundle.ao(((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject1).AsL, this.sgD.wvm.getMuteOrigin());
                  paramBundle = this.sgT;
                  localObject1 = this.sgO;
                  if (localObject1 == null) {
                    d.g.b.k.aVY("multiPreviewPlugin");
                  }
                  if (((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject1).AsL) {
                    break label1905;
                  }
                }
              }
            }
            for (;;)
            {
              paramBundle.setEnableLengthEdit(bool1);
              paramBundle = this.sgN.RP(paramc.position);
              localObject1 = ab.Apg;
              ab.a(paramBundle);
              this.sgW = paramc.position;
              paramc = y.KTp;
              AppMethodBeat.o(204838);
              return;
              i = 0;
              break;
              bool1 = false;
            }
          }
        }
        AppMethodBeat.o(204838);
        return;
      } while (!this.shb);
      if (paramBundle != null)
      {
        paramc = (AudioCacheInfo)paramBundle.getParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE");
        if (paramc != null)
        {
          this.sgM.Fl(2131764707);
          a(this, paramc.wri, (d.g.a.a)new m(this), 2);
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
        }
      }
      AppMethodBeat.o(204838);
      return;
    case 26: 
      this.sgD.eP(this.sgN.Anp.diF());
      AppMethodBeat.o(204838);
      return;
    case 27: 
      if (paramBundle != null)
      {
        bool1 = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.sgO;
        if (paramc == null) {
          d.g.b.k.aVY("multiPreviewPlugin");
        }
        paramc = paramc.sOk;
        if (paramc != null) {
          paramc.sl(bool1);
        }
        paramc = y.KTp;
        AppMethodBeat.o(204838);
        return;
      }
      AppMethodBeat.o(204838);
      return;
    case 28: 
      cas();
      AppMethodBeat.o(204838);
      return;
    case 29: 
      if (paramBundle != null)
      {
        i = ((Number)Integer.valueOf(paramBundle.getInt("PARAM_SELECT_IMAGE_VLOG_SWITCH"))).intValue();
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.VLogTAVKitPreviewPluginLayout", "EDIT_VLOG_SELECT_IMAGE_VLOG: ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
          this.shb = false;
          setupImageEditPlugins(true);
          this.sgy.pn(false);
          continue;
          this.shb = false;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "setupNormalVideoPlugins");
          this.sgP.setVisibility(8);
          this.sgS.setVisibility(0);
          cGm();
          this.sgT.setEnableLengthEdit(true);
          this.sgy.setFullScreen(true);
          this.sgS.AtI = false;
          this.sgX = false;
          if (this.sgN.And.size() <= 1) {
            this.sgU.setVisibility(8);
          }
          for (;;)
          {
            kotlinx.coroutines.f.b((ag)bh.LRM, (d.d.f)ay.gdO(), (d.g.a.m)new h(this, null), 2);
            paramc = this.sgD;
            paramBundle = this.sgm;
            if (paramBundle == null) {
              d.g.b.k.fOy();
            }
            com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, paramBundle, this.rRi);
            break;
            this.sgU.setVisibility(0);
          }
          this.shb = true;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "setupVLogVideoPlugins");
          paramc = new b.b();
          paramBundle = com.tencent.mm.plugin.finder.utils.p.rQw;
          paramc.agu(com.tencent.mm.plugin.finder.utils.p.cDv());
          paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
          paramc.maxHeight = com.tencent.mm.plugin.finder.storage.b.cyf();
          paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
          paramc.maxWidth = com.tencent.mm.plugin.finder.storage.b.cyg();
          paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
          paramc.sMo = com.tencent.mm.plugin.finder.storage.b.cyh();
          this.sgM.Fl(2131764707);
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          paramBundle = new Rect();
          paramc.AsW.getVisibilityRect().round(paramBundle);
          this.sgN.hX(paramBundle.width(), paramBundle.height());
          this.sgy.setFullScreen(false);
          this.sgS.AtI = false;
          a(this, 0, (d.g.a.a)new i(this), 3);
          this.sgU.setVisibility(0);
          this.sgX = false;
        }
      }
      AppMethodBeat.o(204838);
      return;
    case 30: 
      if (paramBundle != null)
      {
        paramBundle = (GalleryItem.MediaItem)paramBundle.getParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE");
        if (paramBundle != null)
        {
          this.sgV.iD("start", "select first image");
          this.sgQ.reset();
          this.sgA.reset();
          paramc = this.sgA;
          paramBundle = (d.g.a.a)new n(paramBundle, this);
          d.g.b.k.h(paramBundle, "r");
          paramc.sgs.post((Runnable)new e(paramBundle));
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
        }
      }
      AppMethodBeat.o(204838);
      return;
    case 31: 
      if (paramBundle != null)
      {
        paramBundle.getInt("EDIT_FILTER_INDEX_INT", -1);
        float f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT", 0.0F);
        paramBundle = paramBundle.getString("EDIT_FILTER_COLOR_PATH_STRING");
        paramc = this.sgO;
        if (paramc == null) {
          d.g.b.k.aVY("multiPreviewPlugin");
        }
        localObject1 = paramc.AmR;
        if (localObject1 != null)
        {
          paramc = paramBundle;
          if (paramBundle == null) {
            paramc = "";
          }
          d.g.b.k.h(paramc, "path");
          paramBundle = ((com.tencent.mm.plugin.vlog.model.r)localObject1).AnS;
          if (paramBundle == null) {
            d.g.b.k.aVY("effect");
          }
          d.g.b.k.h(paramc, "path");
          paramBundle = paramBundle.Arn;
          d.g.b.k.h(paramc, "path");
          paramBundle = paramBundle.AqV;
          d.g.b.k.h(paramc, "path");
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MultiVideoXLabEffectRenderProc", "setFilter, path:" + paramc + ", weight:" + f + ", xLabEffect:" + paramBundle.fZP);
          paramBundle.Ark = paramc;
          paramBundle.Arl = f;
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
        }
        AppMethodBeat.o(204838);
        return;
      }
      AppMethodBeat.o(204838);
      return;
    case 32: 
      this.sgP.setVisibility(0);
      this.sgA.reset();
      AppMethodBeat.o(204838);
      return;
    case 33: 
      paramc = this.sgA;
      paramc.sgr = com.tencent.mm.api.g.cGC;
      paramc.gPA = 0;
      paramBundle = paramc.sgo;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGC);
      }
      paramc = paramc.sgo;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGC, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.aqO("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.Mn(8);
      AppMethodBeat.o(204838);
      return;
    case 34: 
      paramc = this.sgA;
      paramc.sgr = com.tencent.mm.api.g.cGC;
      paramc.gPA = 1;
      paramBundle = paramc.sgo;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGC);
      }
      paramc = paramc.sgo;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGC, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.aqO("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.Mn(9);
      AppMethodBeat.o(204838);
      return;
    case 35: 
      this.sgA.reset();
      if (paramBundle != null)
      {
        paramc = this.sgA;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.sgr = com.tencent.mm.api.g.cGz;
        paramc.gPA = i;
        paramBundle = paramc.sgo;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGz);
        }
        paramc = paramc.sgo;
        if (paramc != null) {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGz, i, null);
        }
        paramc = y.KTp;
      }
      AppMethodBeat.o(204838);
      return;
    case 36: 
      paramc = this.sgA;
      paramBundle = paramc.sgo;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.Vr().Vs(), -1, null);
      }
      paramBundle = paramc.sgo;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.sgr);
      }
      paramBundle = paramc.sgo;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.sgr, paramc.gPA, null);
        AppMethodBeat.o(204838);
        return;
      }
      AppMethodBeat.o(204838);
      return;
    case 37: 
      if (paramBundle != null)
      {
        cas();
        i = paramBundle.getInt("EDIT_VLOG_SELECT_TRACK", -1);
        if (i >= 0)
        {
          paramc = this.sgN.AmR;
          if ((i < 0) || (i >= ((List)paramc.AnT).size())) {
            break label3481;
          }
          paramBundle = this.sgO;
          if (paramBundle == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          paramBundle.AsP = (((com.tencent.mm.plugin.vlog.model.u)((List)paramc.AnT).get(i)).bvf - paramc.efB());
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          paramBundle = (com.tencent.mm.plugin.vlog.model.u)j.C((List)this.sgN.AmR.AnT, i);
          if (paramBundle == null) {
            break label3504;
          }
          l1 = paramBundle.Aox;
          paramc.AsQ = l1;
          this.sgN.RQ(i);
          this.sgS.setVisibility(8);
          paramc = this.sgT;
          if (this.sgN.efw()) {
            break label3510;
          }
        }
        for (bool1 = bool2;; bool1 = false)
        {
          paramc.setEnableLengthEdit(bool1);
          this.sgT.setTrack(this.sgN.AmR);
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          com.tencent.mm.plugin.vlog.ui.plugin.a.a(paramc, this.sgN.efw());
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          paramc.AsP = 0L;
          break;
          l1 = 0L;
          break label3381;
        }
      }
      AppMethodBeat.o(204838);
      return;
    case 38: 
      if (paramBundle != null)
      {
        if (paramBundle.getBoolean("EDIT_VLOG_TRACK_CROP_CHANGE"))
        {
          l1 = paramBundle.getLong("EDIT_VLOG_TRACK_CROP_START");
          long l2 = paramBundle.getLong("EDIT_VLOG_TRAKC_CROP_END");
          if (this.sgN.Anw != null)
          {
            paramc = this.sgO;
            if (paramc == null) {
              d.g.b.k.aVY("multiPreviewPlugin");
            }
            paramc.AsQ = l1;
          }
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          paramc = paramc.sOk;
          if (paramc != null)
          {
            paramc = paramc.Apu;
            if (paramc != null)
            {
              paramc = paramc.player;
              if (paramc != null) {
                paramc.setPlayRange(CMTimeRange.fromMs(l1, l2 - l1));
              }
            }
          }
          this.sgN.AmR.an(l1, l2);
        }
        for (;;)
        {
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
          cGn();
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          paramc.AsP = 0L;
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          paramc.AsQ = 0L;
          bool1 = paramBundle.getBoolean("EDIT_VLOG_TRACK_CROP_CONFIRM");
          i = paramBundle.getInt("EDIT_TRACK_DURATION_CUT_COUNT");
          j = paramBundle.getInt("EDIT_TRACK_DURATION_SCROLL_COUNT");
          this.sgN.j(bool1, i, j);
          paramc = this.sgO;
          if (paramc == null) {
            d.g.b.k.aVY("multiPreviewPlugin");
          }
          com.tencent.mm.plugin.vlog.ui.plugin.a.a(paramc, this.sgN.efw());
        }
      }
      AppMethodBeat.o(204838);
      return;
    case 39: 
      if (paramBundle != null)
      {
        if (paramBundle.getBoolean("EDIT_FILTER_SHOW")) {
          cas();
        }
        for (;;)
        {
          paramc = y.KTp;
          AppMethodBeat.o(204838);
          return;
          cGn();
        }
      }
      AppMethodBeat.o(204838);
      return;
    case 40: 
      label1899:
      label1905:
      cas();
      label3381:
      label3510:
      AppMethodBeat.o(204838);
      label3481:
      label3504:
      return;
    }
    cGn();
    AppMethodBeat.o(204838);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(204850);
    if (!super.alO())
    {
      localObject = this.sgO;
      if (localObject == null) {
        d.g.b.k.aVY("multiPreviewPlugin");
      }
      ((com.tencent.mm.plugin.vlog.ui.plugin.a)localObject).stopPreview();
      localObject = this.rRh;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    this.sha.wxX.hZ(1L);
    cGo();
    Object localObject = com.tencent.mm.plugin.finder.report.c.rxi;
    localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
    com.tencent.mm.plugin.finder.report.c.b(com.tencent.mm.plugin.recordvideo.d.c.dwq());
    AppMethodBeat.o(204850);
    return true;
  }
  
  public final int getLayoutId()
  {
    return 2131496362;
  }
  
  public final void release()
  {
    AppMethodBeat.i(204851);
    super.release();
    this.sgN.dead();
    u.a locala = com.tencent.mm.plugin.vlog.model.u.AoG;
    com.tencent.mm.plugin.vlog.model.u.efK().clear();
    AppMethodBeat.o(204851);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(204849);
    super.reset();
    this.sgZ = WxCropOperationLayout.j.wzH;
    setBackgroundColor(0);
    AppMethodBeat.o(204849);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(MultiVideoPluginLayout paramMultiVideoPluginLayout, com.tencent.mm.plugin.vlog.model.b paramb, String paramString, Size paramSize, Rect paramRect, float[] paramArrayOfFloat, ArrayList paramArrayList, boolean paramBoolean, com.tencent.mm.plugin.vlog.model.r paramr, d.g.a.q paramq)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ret", "", "path", "", "edited", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.q<Boolean, String, Boolean, y>
  {
    c(MultiVideoPluginLayout paramMultiVideoPluginLayout, int paramInt, b.e parame, String[] paramArrayOfString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$initLogic$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-finder_release"})
  public static final class d
    implements CropLayout.c
  {
    public final void onChange()
    {
      AppMethodBeat.i(204812);
      Object localObject1 = MultiVideoPluginLayout.a(this.shf).AsW.getVisibilityRect();
      Object localObject2 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      com.tencent.mm.plugin.recordvideo.background.g.dus().set((int)((RectF)localObject1).left, (int)((RectF)localObject1).top, (int)((RectF)localObject1).right, (int)((RectF)localObject1).bottom);
      localObject2 = MultiVideoPluginLayout.b(this.shf);
      localObject1 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      localObject1 = com.tencent.mm.plugin.recordvideo.background.g.dus();
      d.g.b.k.h(localObject1, "validRect");
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.u)localObject2).wsp;
      d.g.b.k.h(localObject1, "validRect");
      int j = ((EditorItemContainer)localObject2).ptG.getChildCount();
      int i = 0;
      while (i < j)
      {
        if ((((EditorItemContainer)localObject2).ptG.getChildAt(i) instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.d))
        {
          View localView = ((EditorItemContainer)localObject2).ptG.getChildAt(i);
          if (localView == null)
          {
            localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.item.IEditView");
            AppMethodBeat.o(204812);
            throw ((Throwable)localObject1);
          }
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localView).setValidArea((Rect)localObject1);
        }
        i += 1;
      }
      AppMethodBeat.o(204812);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$initLogic$audioSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-finder_release"})
  public static final class e
    implements a.e
  {
    public final void pause()
    {
      AppMethodBeat.i(204814);
      MultiVideoPluginLayout.c(this.shf).onPause();
      AppMethodBeat.o(204814);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(204815);
      if (MultiVideoPluginLayout.c(this.shf).wpt != null) {
        MultiVideoPluginLayout.c(this.shf).aGs();
      }
      AppMethodBeat.o(204815);
    }
    
    public final void vr(long paramLong)
    {
      AppMethodBeat.i(204813);
      MultiVideoPluginLayout.c(this.shf).sOl.seekTo(paramLong);
      AppMethodBeat.o(204813);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(MultiVideoPluginLayout paramMultiVideoPluginLayout, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.d.b.a.e(c="com.tencent.mm.plugin.finder.vlog.MultiVideoPluginLayout$setupMediaData$1", f="MultiVideoPluginLayout.kt", l={345}, m="invokeSuspend")
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class g
    extends d.d.b.a.i
    implements d.g.a.m<ag, d.d.d<? super y>, Object>
  {
    int label;
    Object nIC;
    Object nID;
    Object nIE;
    Object nIF;
    Object nIG;
    int nIN;
    int nIO;
    private ag nvs;
    Object nvt;
    
    g(MultiVideoPluginLayout paramMultiVideoPluginLayout, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(204822);
      d.g.b.k.h(paramd, "completion");
      paramd = new g(this.shf, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(204822);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(204821);
      paramObject = d.d.a.a.KUd;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int j;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204821);
        throw paramObject;
      case 0: 
        localObject1 = this.nvs;
        MultiVideoPluginLayout.d(this.shf).clear();
        localObject2 = MultiVideoPluginLayout.e(this.shf);
        if (localObject2 != null)
        {
          localObject2 = ((RecordConfigProvider)localObject2).hSN;
          if (localObject2 != null)
          {
            ((Bundle)localObject2).setClassLoader(GalleryItem.MediaItem.class.getClassLoader());
            localObject3 = ((Bundle)localObject2).getString("post_id");
            if (localObject3 != null)
            {
              MultiVideoPluginLayout.a(this.shf, (String)localObject3);
              MultiVideoPluginLayout.g(this.shf).wxX.kB(MultiVideoPluginLayout.f(this.shf));
            }
            localObject3 = ((Bundle)localObject2).getParcelableArrayList("media_list");
            if (localObject3 != null) {
              MultiVideoPluginLayout.d(this.shf).addAll((Collection)localObject3);
            }
            localObject3 = (GalleryItem.MediaItem)j.iO((List)MultiVideoPluginLayout.d(this.shf));
            g.a(MultiVideoPluginLayout.h(this.shf), (GalleryItem.MediaItem)localObject3);
            j = ((Bundle)localObject2).getInt("KEY_PREVIEW_WIDTH");
            i = ((Bundle)localObject2).getInt("KEY_PREVIEW_HEIGHT");
            localObject3 = aj.cl(this.shf.getContext());
            if ((j > 0) && (i > 0)) {
              break label1307;
            }
            j = ((Point)localObject3).x;
            i = ((Point)localObject3).y;
          }
        }
        break;
      }
      label1307:
      for (;;)
      {
        MultiVideoPluginLayout.i(this.shf).hX(j, i);
        Object localObject4 = MultiVideoPluginLayout.i(this.shf);
        int k = ((Point)localObject3).x;
        int m = ((Point)localObject3).y;
        ((com.tencent.mm.plugin.vlog.model.k)localObject4).Ank = k;
        ((com.tencent.mm.plugin.vlog.model.k)localObject4).Anl = m;
        Object localObject5 = (Iterable)MultiVideoPluginLayout.d(this.shf);
        localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext()) {
          ((Collection)localObject4).add(((GalleryItem.MediaItem)((Iterator)localObject5).next()).cMQ());
        }
        localObject4 = (List)localObject4;
        Object localObject6 = (Iterable)MultiVideoPluginLayout.d(this.shf);
        localObject5 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((Collection)localObject5).add(Integer.valueOf(((GalleryItem.MediaItem)((Iterator)localObject6).next()).getType()));
        }
        localObject5 = (List)localObject5;
        int n = MultiVideoPluginLayout.d(this.shf).size();
        localObject6 = new Integer[n];
        k = 0;
        if (k < n)
        {
          ((Number)Integer.valueOf(k)).intValue();
          localObject7 = MultiVideoPluginLayout.j(this.shf);
          if ((localObject7 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject7).hbH == true)) {}
          for (m = 1;; m = 0)
          {
            localObject6[k] = Integer.valueOf(m);
            k += 1;
            break;
          }
        }
        Object localObject7 = (d.d.f)ay.gdP();
        d.g.a.m localm = (d.g.a.m)new a((List)localObject4, (List)localObject5, (Integer[])localObject6, null, this);
        this.nvt = localObject1;
        this.nIC = localObject2;
        this.nIN = j;
        this.nIO = i;
        this.nID = localObject3;
        this.nIE = localObject4;
        this.nIF = localObject5;
        this.nIG = localObject6;
        this.label = 1;
        if (kotlinx.coroutines.g.a((d.d.f)localObject7, localm, this) == paramObject)
        {
          AppMethodBeat.o(204821);
          return paramObject;
        }
        paramObject = (Iterable)MultiVideoPluginLayout.i(this.shf).Anf;
        i = 0;
        paramObject = paramObject.iterator();
        if (paramObject.hasNext())
        {
          localObject1 = paramObject.next();
          if (i < 0) {
            j.fOc();
          }
          localObject1 = (com.tencent.mm.plugin.vlog.model.u)localObject1;
          j = ((Number)Integer.valueOf(i)).intValue();
          localObject1 = ((com.tencent.mm.plugin.vlog.model.u)localObject1).AoE;
          localObject2 = (GalleryItem.MediaItem)j.C((List)MultiVideoPluginLayout.d(this.shf), j);
          if (localObject2 != null)
          {
            localObject2 = (Boolean)((GalleryItem.MediaItem)localObject2).v("KEY_MEDIA_IS_BEAUTY", Boolean.FALSE);
            if (localObject2 == null) {}
          }
          for (bool = ((Boolean)localObject2).booleanValue();; bool = false)
          {
            ((MediaEditReportInfo.EditItem)localObject1).isBeauty = bool;
            i += 1;
            break;
          }
        }
        paramObject = MultiVideoPluginLayout.a(this.shf).AsI;
        localObject1 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
        paramObject.round(com.tencent.mm.plugin.recordvideo.background.g.dus());
        localObject1 = MultiVideoPluginLayout.i(this.shf);
        d.g.b.k.h(paramObject, "maxVisibleRect");
        ((com.tencent.mm.plugin.vlog.model.k)localObject1).Ann.set(paramObject);
        float f = (paramObject.height() - paramObject.width() * ((com.tencent.mm.plugin.vlog.model.k)localObject1).Anm) / 2.0F;
        ((com.tencent.mm.plugin.vlog.model.k)localObject1).Ann.inset(0.0F, f);
        MultiVideoPluginLayout.i(this.shf).eft();
        paramObject = MultiVideoPluginLayout.a(this.shf);
        localObject1 = MultiVideoPluginLayout.i(this.shf).Ann;
        d.g.b.k.h(localObject1, "rect");
        localObject2 = paramObject.AsS;
        d.g.b.k.h(localObject1, "rect");
        ((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject2).Ann.set((RectF)localObject1);
        localObject2 = paramObject.AsT;
        d.g.b.k.h(localObject1, "rect");
        ((com.tencent.mm.plugin.vlog.ui.plugin.f)localObject2).Ann.set((RectF)localObject1);
        paramObject.sOm.set((RectF)localObject1);
        paramObject.AsW.getVisibilityRect().set((RectF)localObject1);
        paramObject.AsW.postInvalidate();
        paramObject.AsW.setVisibility(0);
        boolean bool = MultiVideoPluginLayout.i(this.shf).Ang;
        MultiVideoPluginLayout.k(this.shf).sgj = bool;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "initLogic isAllImage:".concat(String.valueOf(bool)));
        if (bool)
        {
          paramObject = MultiVideoPluginLayout.l(this.shf);
          localObject1 = MultiVideoPluginLayout.d(this.shf);
          d.g.b.k.h(localObject1, "list");
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditFooterRecyclerPlugin", "updateList = " + ((ArrayList)localObject1).size());
          paramObject.sgc.clear();
          paramObject.sgc.addAll((Collection)localObject1);
          localObject1 = paramObject.sgd;
          if (localObject1 == null) {
            d.g.b.k.aVY("adapter");
          }
          ((a.b)localObject1).setItems((List)paramObject.sgc);
          paramObject = paramObject.sgd;
          if (paramObject == null) {
            d.g.b.k.aVY("adapter");
          }
          paramObject.notifyDataSetChanged();
          MultiVideoPluginLayout.m(this.shf);
          MultiVideoPluginLayout.b(this.shf).pn(false);
          MultiVideoPluginLayout.b(this.shf).setFullScreen(true);
        }
        for (;;)
        {
          paramObject = MultiVideoPluginLayout.k(this.shf);
          paramObject.mg(paramObject.sgi);
          if ((MultiVideoPluginLayout.d(this.shf).size() <= 1) || (MultiVideoPluginLayout.i(this.shf).Ang)) {
            MultiVideoPluginLayout.p(this.shf).setVisibility(8);
          }
          paramObject = y.KTp;
          AppMethodBeat.o(204821);
          return paramObject;
          MultiVideoPluginLayout.n(this.shf).setVisibility(8);
          MultiVideoPluginLayout.o(this.shf);
          MultiVideoPluginLayout.b(this.shf).setFullScreen(true);
        }
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(204823);
      paramObject1 = ((g)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(204823);
      return paramObject1;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$setupMediaData$1$1$4"})
    static final class a
      extends d.d.b.a.i
      implements d.g.a.m<ag, d.d.d<? super Boolean>, Object>
    {
      int label;
      private ag nvs;
      Object nvt;
      
      a(List paramList1, List paramList2, Integer[] paramArrayOfInteger, d.d.d paramd, MultiVideoPluginLayout.g paramg)
      {
        super();
      }
      
      public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(204819);
        d.g.b.k.h(paramd, "completion");
        paramd = new a(this.shy, this.shz, this.shA, paramd, jdField_this);
        paramd.nvs = ((ag)paramObject);
        AppMethodBeat.o(204819);
        return paramd;
      }
      
      public final Object cO(Object paramObject)
      {
        AppMethodBeat.i(204818);
        d.d.a.a locala = d.d.a.a.KUd;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(204818);
          throw paramObject;
        case 0: 
          paramObject = this.nvs;
          Object localObject = MultiVideoPluginLayout.i(jdField_this.shf);
          List localList1 = this.shy;
          List localList2 = this.shz;
          List localList3 = d.a.e.V(this.shA);
          this.nvt = paramObject;
          this.label = 1;
          localObject = kotlinx.coroutines.g.a((d.d.f)ay.gdP(), (d.g.a.m)new k.c((com.tencent.mm.plugin.vlog.model.k)localObject, localList1, localList2, localList3, null), this);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(204818);
            return locala;
          }
          break;
        }
        AppMethodBeat.o(204818);
        return paramObject;
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(204820);
        paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
        AppMethodBeat.o(204820);
        return paramObject1;
      }
    }
  }
  
  @d.d.b.a.e(c="com.tencent.mm.plugin.finder.vlog.MultiVideoPluginLayout$setupNormalVideoPlugins$1", f="MultiVideoPluginLayout.kt", l={1000}, m="invokeSuspend")
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class h
    extends d.d.b.a.i
    implements d.g.a.m<ag, d.d.d<? super y>, Object>
  {
    int label;
    private ag nvs;
    Object nvt;
    
    h(MultiVideoPluginLayout paramMultiVideoPluginLayout, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(204825);
      d.g.b.k.h(paramd, "completion");
      paramd = new h(this.shf, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(204825);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(204824);
      paramObject = d.d.a.a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204824);
        throw paramObject;
      case 0: 
        ag localag = this.nvs;
        com.tencent.mm.plugin.vlog.model.k localk = MultiVideoPluginLayout.i(this.shf);
        long l = MultiVideoPluginLayout.t(this.shf);
        this.nvt = localag;
        this.label = 1;
        if (localk.a(l, this) == paramObject)
        {
          AppMethodBeat.o(204824);
          return paramObject;
        }
        break;
      }
      MultiVideoPluginLayout.c(this.shf).sOl.seekTo(0L);
      MultiVideoPluginLayout.a(this.shf).ao(false, MultiVideoPluginLayout.c(this.shf).wvm.getMuteOrigin());
      this.shf.setBackgroundColor(-16777216);
      paramObject = y.KTp;
      AppMethodBeat.o(204824);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(204826);
      paramObject1 = ((h)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(204826);
      return paramObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(MultiVideoPluginLayout paramMultiVideoPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$sortCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$TrackSortCallback;", "onMove", "", "fromPosition", "", "toPosition", "onSortEnd", "plugin-finder_release"})
  public static final class j
    implements h.b
  {
    public final void cGp()
    {
      AppMethodBeat.i(204829);
      com.tencent.mm.plugin.vlog.model.k localk = MultiVideoPluginLayout.i(this.shf);
      long l1 = 0L;
      Iterator localIterator = ((Iterable)localk.Ant).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.vlog.model.u localu = (com.tencent.mm.plugin.vlog.model.u)localIterator.next();
        long l2 = localu.gOz - localu.bvf;
        localu.bvf = l1;
        localu.gOz = (l1 + l2);
        l1 += l2;
      }
      localk.AmR = new com.tencent.mm.plugin.vlog.model.r((List)localk.Ant, null, 6);
      com.tencent.mm.plugin.vlog.ui.plugin.a.a(MultiVideoPluginLayout.a(this.shf), false);
      AppMethodBeat.o(204829);
    }
    
    public final void fo(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204828);
      Collections.swap((List)MultiVideoPluginLayout.i(this.shf).Ant, paramInt1, paramInt2);
      AppMethodBeat.o(204828);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.m<Boolean, String, y>
  {
    k(MultiVideoPluginLayout paramMultiVideoPluginLayout, d.g.a.q paramq)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "thumb", "Landroid/graphics/Bitmap;", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.q<Boolean, yo, Bitmap, y>
  {
    l(MultiVideoPluginLayout paramMultiVideoPluginLayout, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$statusChange$11$1"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(MultiVideoPluginLayout paramMultiVideoPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$statusChange$14$1"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    n(GalleryItem.MediaItem paramMediaItem, MultiVideoPluginLayout paramMultiVideoPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(MultiVideoPluginLayout paramMultiVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(204835);
      Object localObject = MultiVideoPluginLayout.b(this.shf).wsp.getParent();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(204835);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      ((ViewGroup)localObject).removeView((View)MultiVideoPluginLayout.b(this.shf).wsp);
      View localView = (View)MultiVideoPluginLayout.b(this.shf).wsp;
      com.tencent.mm.plugin.vlog.ui.plugin.a locala = MultiVideoPluginLayout.a(this.shf);
      ((ViewGroup)localObject).addView(localView, locala.fWU.indexOfChild((View)locala.AsV) + 1);
      AppMethodBeat.o(204835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.MultiVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */