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
import com.tencent.mm.g.b.a.im;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ac;
import com.tencent.mm.plugin.recordvideo.plugin.ac.b;
import com.tencent.mm.plugin.recordvideo.plugin.p;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.r;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.vlog.model.q.c;
import com.tencent.mm.plugin.vlog.model.y.a;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.ui.plugin.h.b;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "calculatePlugin", "Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "captionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropVideoPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin;", "currentPath", "", "currentStyle", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editId", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editReport", "Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport;", "edited", "", "footRecyclerViewPlugin", "Lcom/tencent/mm/plugin/finder/vlog/EditFooterRecyclerPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "isInImageEdit", "lastMusicPosition", "", "maxCropVideoDurationMs", "", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "multiHintTextPlugin", "Lcom/tencent/mm/plugin/finder/vlog/MultiHintTextPlugin;", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiPreviewPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoEditItemContainer", "Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin;", "postId", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "selectFilterPath", "selectFilterWeight", "", "sortCallback", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$sortCallback$1", "Lcom/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$sortCallback$1;", "thumbLoadingPlugin", "Lcom/tencent/mm/plugin/finder/vlog/ThumbLoadingPlugin;", "vLogMode", "vLogThumbPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin;", "vLogTrackEditPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "videoEditItemContainer", "Lcom/tencent/mm/plugin/recordvideo/plugin/MultiEditItemContainerPlugin;", "videoFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterEffectPlugin;", "vlogSelectPlugin", "Lcom/tencent/mm/plugin/finder/vlog/EditImageVLogSelectPlugin;", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "exportVideo", "", "musicPath", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "thumb", "generateCropImage", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "resultImage", "", "outputModel", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "index", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;[Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;I)V", "getLayoutId", "hideOperation", "initLogic", "initSafeArea", "loadCurrentPage", "model", "onBackPress", "release", "reportEdit", "requestVLogScript", "sid", "fid", "Lkotlin/Function0;", "reset", "setupFilterPreview", "setupImageEditPlugins", "selectFirst", "setupMediaData", "Lkotlinx/coroutines/Job;", "setupNormalVideoPlugins", "setupVLogVideoPlugins", "showImageEditPlugins", "showOperation", "showVideoEditPlugins", "startMux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class MultiVideoPluginLayout
  extends BasePluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final a Llh;
  private final long LkI;
  private final ac LkJ;
  private final d LkK;
  private final com.tencent.mm.plugin.vlog.ui.plugin.f LkL;
  private final com.tencent.mm.plugin.vlog.ui.plugin.caption.b LkM;
  private final g LkN;
  private final com.tencent.mm.plugin.vlog.model.q LkO;
  private com.tencent.mm.plugin.vlog.ui.plugin.b LkP;
  private a LkQ;
  private b LkR;
  private com.tencent.mm.plugin.vlog.ui.plugin.h LkS;
  private final com.tencent.mm.plugin.vlog.ui.plugin.i LkT;
  private com.tencent.mm.plugin.recordvideo.plugin.effect.b LkU;
  private c LkV;
  private com.tencent.mm.plugin.recordvideo.e.f LkW;
  private int LkX;
  private String LkY;
  private float LkZ;
  private boolean Lla;
  private ArrayList<GalleryItem.MediaItem> Llb;
  private WxCropOperationLayout.j Llc;
  private com.tencent.mm.plugin.recordvideo.d.f Lld;
  private boolean Lle;
  private boolean Llf;
  private final k Llg;
  private String editId;
  private String kkH;
  private String postId;
  private RecordConfigProvider vcC;
  private com.tencent.mm.media.widget.camerarecordview.b.b vjS;
  private com.tencent.mm.plugin.recordvideo.activity.a vmM;
  private final com.tencent.mm.plugin.recordvideo.plugin.a vmO;
  private final r vmQ;
  private final com.tencent.mm.plugin.recordvideo.plugin.c vmR;
  private final com.tencent.mm.plugin.recordvideo.plugin.d vmS;
  private final com.tencent.mm.plugin.recordvideo.plugin.b vmT;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a vmU;
  private final com.tencent.mm.plugin.recordvideo.plugin.f vmW;
  private final com.tencent.mm.plugin.recordvideo.plugin.e vmX;
  private final com.tencent.mm.plugin.recordvideo.plugin.ab vmY;
  private final p vmZ;
  private final com.tencent.mm.plugin.recordvideo.plugin.q vna;
  private final com.tencent.mm.plugin.recordvideo.plugin.g vnc;
  private com.tencent.mm.plugin.recordvideo.plugin.m vnh;
  
  static
  {
    AppMethodBeat.i(200724);
    Llh = new a((byte)0);
    AppMethodBeat.o(200724);
  }
  
  public MultiVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200723);
    paramAttributeSet = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.LkI = (com.tencent.mm.plugin.finder.storage.b.cpG() * 1000L);
    this.vmY = new com.tencent.mm.plugin.recordvideo.plugin.ab(paramContext);
    this.kkH = "";
    this.LkO = new com.tencent.mm.plugin.vlog.model.q();
    this.LkW = new com.tencent.mm.plugin.recordvideo.e.f();
    this.LkY = "";
    this.LkZ = 1.0F;
    this.postId = "";
    this.editId = "";
    this.Llb = new ArrayList();
    this.Llc = WxCropOperationLayout.j.LpK;
    this.Lld = new com.tencent.mm.plugin.recordvideo.d.f();
    this.Llg = new k(this);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "init VLogTAVKitPreviewPluginLayout");
    LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    paramAttributeSet = findViewById(2131307790);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.multi_crop_layout)");
    paramAttributeSet = (CropLayout)paramAttributeSet;
    Object localObject = findViewById(2131307281);
    d.g.b.k.g(localObject, "findViewById(R.id.crop_ope_layout)");
    this.LkP = new com.tencent.mm.plugin.vlog.ui.plugin.b(paramAttributeSet, (WxCropOperationLayout)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = this.LkP;
    if (paramAttributeSet == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    paramAttributeSet.LkO = this.LkO;
    paramAttributeSet = (ViewGroup)this;
    localObject = findViewById(2131299273);
    d.g.b.k.g(localObject, "findViewById(R.id.editor_add_emoji)");
    this.vmO = new com.tencent.mm.plugin.recordvideo.plugin.a(paramAttributeSet, (ImageView)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131307914);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.video_editor_item_container)");
    this.LkJ = new ac((EditorItemContainer)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = this.LkP;
    if (paramAttributeSet == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    localObject = (CropLayout.p)this.LkJ.vjE;
    paramAttributeSet.LtD.setCropLayoutTouchListener((CropLayout.p)localObject);
    paramAttributeSet = findViewById(2131298784);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.control_container)");
    this.vmQ = new r((ViewGroup)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131307819);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.photo_editor_item_container)");
    this.LkK = new d((FrameLayout)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131297952);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.vnc = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramAttributeSet);
    this.vmR = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, this.vnc.vjw);
    this.vmU = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.vmU.vmE.setBackground(2131234954);
    this.LkL = new com.tencent.mm.plugin.vlog.ui.plugin.f((View)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131299295);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.editor_mix)");
    this.vmW = new com.tencent.mm.plugin.recordvideo.plugin.f(paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131299285);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.editor_close)");
    this.vmX = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131299621);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.ext_text_area)");
    this.vmZ = new p((TextView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131303907);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.recorder_black_mask)");
    this.vna = new com.tencent.mm.plugin.recordvideo.plugin.q((ImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.vmS = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this, this.vnc.vjw);
    this.vmT = new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131307920);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.vlog_editor_multi_hint_text)");
    this.LkV = new c((TextView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131300206);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.footer_preview)");
    this.LkQ = new a((RecyclerView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.vnh = new com.tencent.mm.plugin.recordvideo.plugin.m((ViewGroup)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = this.vnc.vjw.getCaptionView();
    if (paramAttributeSet == null) {
      d.g.b.k.fvU();
    }
    this.LkM = new com.tencent.mm.plugin.vlog.ui.plugin.caption.b(paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = findViewById(2131307823);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.preview_thumb)");
    this.LkN = new g((ImageView)paramAttributeSet, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    paramAttributeSet = this.LkP;
    if (paramAttributeSet == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    float f1 = paramAttributeSet.Ltr.top;
    paramAttributeSet = this.LkP;
    if (paramAttributeSet == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    f1 = (f1 + paramAttributeSet.Ltr.bottom) / 2.0F;
    paramAttributeSet = this.LkN;
    f1 -= aq.cf(paramContext).y / 2;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ThumbLoadingPlugin", "setTranslateY ".concat(String.valueOf(f1)));
    paramAttributeSet.qir.setTranslationY(f1);
    paramContext = findViewById(2131299287);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_control_icons_layout)");
    this.LkU = new com.tencent.mm.plugin.recordvideo.plugin.effect.b((ViewGroup)paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    boolean bool = this.LkO.Lqj;
    paramContext = findViewById(2131307290);
    d.g.b.k.g(paramContext, "findViewById(R.id.edit_vlog_select_content_parent)");
    this.LkR = new b((ViewGroup)paramContext, bool, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.LkS = new com.tencent.mm.plugin.vlog.ui.plugin.h((View)this, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    this.LkS.Lum = ((h.b)this.Llg);
    paramContext = this.LkP;
    if (paramContext == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    paramContext.a((com.tencent.mm.plugin.vlog.ui.plugin.b.b)this.LkS);
    paramContext = findViewById(2131307293);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_track_edit_panel)");
    this.LkT = new com.tencent.mm.plugin.vlog.ui.plugin.i((EditorPanelHolder)paramContext, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    getPluginList().add(this.LkT);
    paramContext = this.LkP;
    if (paramContext == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    paramContext.a((com.tencent.mm.plugin.vlog.ui.plugin.b.b)this.LkT);
    getPluginList().add(this.vmO);
    getPluginList().add(this.LkJ);
    getPluginList().add(this.vmQ);
    getPluginList().add(this.LkK);
    getPluginList().add(this.vmR);
    getPluginList().add(this.vmU);
    getPluginList().add(this.LkL);
    getPluginList().add(this.vmW);
    getPluginList().add(this.vmY);
    getPluginList().add(this.vmX);
    getPluginList().add(this.vmZ);
    getPluginList().add(this.vna);
    getPluginList().add(this.vmS);
    getPluginList().add(this.vmT);
    getPluginList().add(this.LkM);
    getPluginList().add(this.LkU);
    getPluginList().add(this.LkR);
    getPluginList().add(this.LkS);
    paramContext = getPluginList();
    paramAttributeSet = this.LkP;
    if (paramAttributeSet == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    paramContext.add(paramAttributeSet);
    getPluginList().add(this.LkV);
    getPluginList().add(this.LkQ);
    getPluginList().add(this.LkW);
    getPluginList().add(this.LkN);
    this.LkU.setVisibility(8);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.viq;
    int i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.viq;
    int j = com.tencent.mm.plugin.recordvideo.model.a.dhH();
    f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = i;
    float f5 = (i - f4) / 2.0F;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "initSafeArea, displaySize:[" + j + ", " + i + "], scale:" + f1 + ", safeAreaWidth:" + f2 + ", safeAreaFrameWidth:" + f3 + ", safeAreaHeight:" + f4 + ", safeAreaFrameHeight:" + f5);
    if (f1 <= 1.78F)
    {
      this.vnc.bi(f3);
      this.LkJ.R(f2, f3);
      AppMethodBeat.o(200723);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.vnc.bj(f3);
      this.LkJ.S(f4, f5);
      AppMethodBeat.o(200723);
      return;
    }
    this.vnc.bi(f3);
    this.vnc.bj(f3);
    this.LkJ.R(f2, f3);
    this.LkJ.S(f4, f5);
    AppMethodBeat.o(200723);
  }
  
  private final void a(final com.tencent.mm.plugin.gallery.picker.b.b.e parame, final String[] paramArrayOfString, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, final int paramInt)
  {
    AppMethodBeat.i(200709);
    d locald = this.LkK;
    Object localObject = this.LkO.Lqg.get(paramInt);
    d.g.b.k.g(localObject, "multiMedia.pathList[index]");
    locald.b((String)localObject, (d.g.a.q)new c(this, paramInt, parame, paramArrayOfString, paramCaptureVideoNormalModel));
    AppMethodBeat.o(200709);
  }
  
  private final void bTd()
  {
    AppMethodBeat.i(200713);
    this.vmQ.setVisibility(4);
    this.LkV.setVisibility(4);
    com.tencent.mm.plugin.vlog.ui.plugin.b localb = this.LkP;
    if (localb == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    localb.LtE.setStyle(WxCropOperationLayout.j.LpL);
    this.LkS.setVisibility(8);
    AppMethodBeat.o(200713);
  }
  
  private final void c(int paramInt, final d.g.a.a<d.y> parama)
  {
    AppMethodBeat.i(200717);
    com.tencent.mm.plugin.vlog.model.q localq = this.LkO;
    parama = (d.g.a.a)new f(this, parama);
    d.g.b.k.h(parama, "callback");
    if ((paramInt == 0) && (localq.Lqs))
    {
      parama.invoke();
      AppMethodBeat.o(200717);
      return;
    }
    localq.Lqp = parama;
    localq.isLoading = true;
    parama = localq.Lqq;
    List localList = (List)localq.Lqi;
    d.g.b.k.h(localList, "sourceTrackList");
    parama.Lqh.clear();
    parama.Lqh.addAll((Collection)localList);
    localq.Lqq.a(paramInt, localq.Lqr);
    AppMethodBeat.o(200717);
  }
  
  private final void c(String paramString, final d.g.a.q<? super Boolean, ? super dxw, ? super Bitmap, d.y> paramq)
  {
    int j = 0;
    AppMethodBeat.i(200716);
    Object localObject1 = this.vcC;
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    final String str = ((RecordConfigProvider)localObject1).vhU;
    final float[] arrayOfFloat = this.LkJ.die();
    final ArrayList localArrayList = this.LkJ.did();
    localObject1 = ac.a(this.LkJ);
    Object localObject2 = new StringBuilder("exportVideo, editor item drawing rect:");
    Object localObject3 = Arrays.toString(arrayOfFloat);
    d.g.b.k.g(localObject3, "java.util.Arrays.toString(this)");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", (String)localObject3 + ", editData:" + localArrayList.size() + ", editItems:" + ((ArrayList)localObject1).size());
    localObject1 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).afk().get(ae.a.LBw, Integer.valueOf(-1));
    final boolean bool1;
    int i;
    if (d.g.b.k.g(localObject1, Integer.valueOf(0)))
    {
      bool1 = false;
      localObject1 = this.LkP;
      if (localObject1 == null) {
        d.g.b.k.aPZ("multiPreviewPlugin");
      }
      if (((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject1).Ltt) {
        break label504;
      }
      i = 1;
      label200:
      if (i != 0) {
        break label509;
      }
      localObject1 = this.LkO.fYC();
      label213:
      localObject2 = this.LkP;
      if (localObject2 == null) {
        d.g.b.k.aPZ("multiPreviewPlugin");
      }
      localObject2 = new Rect(((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject2).fZe());
      localObject3 = new com.tencent.mm.plugin.vlog.model.v(this.LkO.Lqf);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "exportVideo musicPath:" + paramString + ", remuxBackgroud:" + bool1);
      if (paramString != null) {
        ((com.tencent.mm.plugin.vlog.model.v)localObject3).aVU(paramString);
      }
      ((com.tencent.mm.plugin.vlog.model.v)localObject3).p(this.LkY, this.LkZ);
      if (this.vmU.vmE.getMuteOrigin()) {
        break label521;
      }
    }
    label521:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((com.tencent.mm.plugin.vlog.model.v)localObject3).zd(bool2);
      final com.tencent.mm.plugin.vlog.model.l locall = new com.tencent.mm.plugin.vlog.model.l((com.tencent.mm.plugin.vlog.model.v)localObject3);
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        i = j;
        if (!((Collection)localArrayList).isEmpty()) {
          i = 1;
        }
        if ((i == 0) && (((List)((com.tencent.mm.plugin.vlog.model.v)localObject3).LqL).size() <= 1))
        {
          paramString = this.vjS;
          if ((paramString == null) || (paramString.gBl != true)) {
            break label422;
          }
        }
      }
      this.Llf = true;
      label422:
      com.tencent.mm.ad.c.b("MultiVideoPluginLayout_exportVideo", (d.g.a.a)new b(this, locall, str, (Size)localObject1, (Rect)localObject2, arrayOfFloat, localArrayList, bool1, (com.tencent.mm.plugin.vlog.model.v)localObject3, paramq));
      AppMethodBeat.o(200716);
      return;
      if (d.g.b.k.g(localObject1, Integer.valueOf(1)))
      {
        bool1 = true;
        break;
      }
      bool1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.KED, true);
      break;
      label504:
      i = 0;
      break label200;
      label509:
      localObject1 = this.LkO.fYD();
      break label213;
    }
  }
  
  private final void fXB()
  {
    AppMethodBeat.i(200710);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "showImageEditPlugins");
    this.vmU.setVisibility(8);
    this.vmU.fYm();
    this.LkL.setVisibility(8);
    this.LkS.setVisibility(8);
    this.LkU.setVisibility(8);
    this.LkQ.setVisibility(0);
    this.vnh.setVisibility(0);
    this.LkK.setVisibility(0);
    this.LkV.setVisibility(8);
    AppMethodBeat.o(200710);
  }
  
  private final void fXC()
  {
    AppMethodBeat.i(200712);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "showVideoEditPlugins");
    this.vmU.setVisibility(0);
    this.LkL.setVisibility(0);
    this.LkS.setVisibility(0);
    this.LkQ.setVisibility(8);
    this.vnh.setVisibility(8);
    this.LkK.setVisibility(8);
    AppMethodBeat.o(200712);
  }
  
  private final void fXD()
  {
    AppMethodBeat.i(200714);
    com.tencent.mm.plugin.vlog.ui.plugin.b localb = this.LkP;
    if (localb == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    localb.LtE.setStyle(this.Llc);
    this.vmQ.setVisibility(0);
    if (!this.Lla)
    {
      if (this.LkO.Lqg.size() > 1) {
        this.LkV.setVisibility(0);
      }
      this.LkS.setVisibility(0);
    }
    AppMethodBeat.o(200714);
  }
  
  private final void fXE()
  {
    AppMethodBeat.i(200715);
    Object localObject = this.LkP;
    if (localObject == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    localObject = ((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject).Lqf;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.vlog.model.v)localObject).U((d.g.a.a)new g((com.tencent.mm.plugin.vlog.model.v)localObject, this));
      ((com.tencent.mm.plugin.vlog.model.v)localObject).p(this.LkY, this.LkZ);
      AppMethodBeat.o(200715);
      return;
    }
    AppMethodBeat.o(200715);
  }
  
  private final void fXF()
  {
    int k = 0;
    AppMethodBeat.i(200719);
    this.Lld.LoO.AR(this.LkS.Luk);
    Object localObject1 = this.Lld.LoO;
    Object localObject2 = this.LkP;
    if (localObject2 == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    ((im)localObject1).AQ(((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject2).Ltu);
    localObject1 = this.Lld.LoO;
    if (this.LkO.Lqf.fYH() > 60000L) {}
    for (long l = 1L;; l = 0L)
    {
      ((im)localObject1).AS(l);
      localObject1 = this.Lld;
      Object localObject3 = (Iterable)this.LkO.Lqi;
      localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((com.tencent.mm.plugin.vlog.model.y)((Iterator)localObject3).next()).Lrv);
      }
    }
    ((com.tencent.mm.plugin.recordvideo.d.f)localObject1).r((List)localObject2, this.LkO.Lqj);
    this.Lld.LoO.aBj();
    this.Lld.reset();
    int i;
    if (((List)this.LkO.Lqi).size() == 1)
    {
      i = 0;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(this.LkJ.dig()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(this.LkJ.dih()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      if (this.vmU.vgH != null) {
        break label473;
      }
      j = 0;
      label306:
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_SELECT_MUSIC_INT", Integer.valueOf(j));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      if (!this.vmU.vmE.getMuteOrigin()) {
        break label478;
      }
    }
    label473:
    label478:
    for (int j = k;; j = 1)
    {
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_SELECT_ORIGIN_INT", Integer.valueOf(j));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_MULTI_MEDIA_POST_ID_STRING", this.postId);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_MULTI_MEDIA_EDIT_ID_STRING", this.editId);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_VIDEO_SUB_TYPE_INT", Integer.valueOf(i));
      AppMethodBeat.o(200719);
      return;
      if (this.LkO.Lqk)
      {
        i = 2;
        break;
      }
      if ((this.LkO.Lqj) && (this.LkO.fYE()))
      {
        i = 1;
        break;
      }
      if (this.LkO.Lqj)
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
  
  private final void setupImageEditPlugins(boolean paramBoolean)
  {
    AppMethodBeat.i(200711);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "setupImageEditPlugins, selectFirst:".concat(String.valueOf(paramBoolean)));
    Object localObject = this.LkP;
    if (localObject == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    ((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject).stopPreview();
    localObject = this.LkP;
    if (localObject == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    localObject = ((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject).Lmo;
    if (localObject != null) {
      ((VLogCompositionPlayView)localObject).setVisibility(8);
    }
    fXB();
    if (paramBoolean)
    {
      localObject = this.LkQ;
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((a)localObject).Lkv.get(0);
      ((a)localObject).qMV = localMediaItem.rBs;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE", (Parcelable)localMediaItem);
      ((a)localObject).vjo.a(d.c.LoB, localBundle);
    }
    this.Lla = true;
    AppMethodBeat.o(200711);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(200707);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "loadCurrentPage time:" + System.currentTimeMillis() + " model:" + paramb);
    super.a(paramb);
    Object localObject = this.LkW;
    d.g.b.k.h("start", "tag");
    long l = System.currentTimeMillis();
    ((Map)((com.tencent.mm.plugin.recordvideo.e.f)localObject).LpW).put("start", Long.valueOf(l));
    this.vjS = paramb;
    kotlinx.coroutines.d.a((kotlinx.coroutines.ad)bc.Kem, (d.d.f)at.gaG(), (d.g.a.m)new h(this, null), 2);
    if (paramb != null)
    {
      localObject = this.LkK;
      RecordConfigProvider localRecordConfigProvider = this.vcC;
      if (localRecordConfigProvider == null) {
        d.g.b.k.fvU();
      }
      d.g.b.k.h(localRecordConfigProvider, "configProvider");
      d.g.b.k.h(paramb, "captureInfo");
      ((d)localObject).vcC = localRecordConfigProvider;
      ((d)localObject).vjS = paramb;
    }
    l = bt.eGO();
    paramb = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(l));
    paramb = new StringBuilder();
    d.g.b.k.g(com.tencent.mm.kernel.g.afz(), "MMKernel.account()");
    this.editId = (com.tencent.mm.kernel.a.aeo() + '_' + l);
    this.Lld.LoO.aTr(this.editId);
    this.LkS.Luk = 0;
    paramb = this.LkP;
    if (paramb == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    paramb.Ltu = 0;
    AppMethodBeat.o(200707);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    AppMethodBeat.i(200706);
    d.g.b.k.h(parama, "navigator");
    d.g.b.k.h(paramRecordConfigProvider, "configProvider");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "initLogic");
    this.vmM = parama;
    this.vcC = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.vtE;
    com.tencent.mm.plugin.recordvideo.e.b.d(paramRecordConfigProvider);
    parama = this.LkJ;
    d.g.b.k.h(paramRecordConfigProvider, "configProvider");
    parama.vjE.a(paramRecordConfigProvider);
    this.LkL.setVisibility(8);
    com.tencent.mm.plugin.recordvideo.plugin.f localf = this.vmW;
    parama = paramRecordConfigProvider.vhI;
    Object localObject1;
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
      parama = Integer.valueOf(parama.fGS);
      localObject1 = paramRecordConfigProvider.vhI;
      if (localObject1 == null) {
        break label500;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fGT);
      localObject2 = paramRecordConfigProvider.vhI;
      if (localObject2 == null) {
        break label506;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.vhI;
      if (localObject3 == null) {
        break label512;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).fGU);
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.vmU;
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label518;
      }
      parama = Integer.valueOf(parama.fGS);
      localObject1 = paramRecordConfigProvider.vhI;
      if (localObject1 == null) {
        break label523;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fGT);
      ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2).a(parama, (Integer)localObject1, 2131691536);
      localObject1 = this.vmZ;
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label529;
      }
      parama = parama.fGV;
      ((p)localObject1).setText(parama);
      localObject2 = this.vmR;
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label534;
      }
      parama = Integer.valueOf(parama.fGS);
      label278:
      localObject3 = paramRecordConfigProvider.vhI;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).fGT);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      parama = this.vmS;
      localObject1 = paramRecordConfigProvider.vhI.fGR;
      d.g.b.k.g(localObject1, "configProvider.uiParam.pluginHiddenMap");
      if (!((Map)localObject1).containsKey("plugin_tip")) {
        break label539;
      }
      i = 8;
      label349:
      parama.vjz = i;
      parama = this.LkP;
      if (parama == null) {
        d.g.b.k.aPZ("multiPreviewPlugin");
      }
      parama.HDf = ((CropLayout.b)new d(this));
      parama = ((Iterable)getPluginList()).iterator();
      label397:
      if (!parama.hasNext()) {
        break label561;
      }
      localObject1 = (t)parama.next();
      localObject2 = paramRecordConfigProvider.vhI;
      if (localObject2 == null) {
        break label544;
      }
      localObject2 = ((UICustomParam)localObject2).fGR;
      if (localObject2 == null) {
        break label544;
      }
      localObject2 = (Boolean)((Map)localObject2).get(((t)localObject1).name());
      if (localObject2 == null) {
        break label544;
      }
      bool = ((Boolean)localObject2).booleanValue();
      label471:
      if (bool) {
        break label550;
      }
      i = 1;
      label478:
      if (i == 0) {
        break label555;
      }
    }
    label512:
    label518:
    label523:
    label529:
    label534:
    label539:
    label544:
    label550:
    label555:
    for (int i = 0;; i = 8)
    {
      ((t)localObject1).setVisibility(i);
      break label397;
      parama = null;
      break;
      label500:
      localObject1 = null;
      break label123;
      label506:
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
      i = 0;
      break label349;
      bool = false;
      break label471;
      i = 0;
      break label478;
    }
    label561:
    parama = new e(this);
    this.LkS.Ltw = ((com.tencent.mm.plugin.vlog.ui.plugin.b.e)parama);
    paramRecordConfigProvider = this.LkP;
    if (paramRecordConfigProvider == null) {
      d.g.b.k.aPZ("multiPreviewPlugin");
    }
    paramRecordConfigProvider.Ltw = ((com.tencent.mm.plugin.vlog.ui.plugin.b.e)parama);
    this.LkS.Lup = false;
    AppMethodBeat.o(200706);
  }
  
  public final void a(final d.c paramc, final Bundle paramBundle)
  {
    int m = 1;
    int i = 1;
    boolean bool2 = true;
    boolean bool3 = true;
    int j = 1;
    int k = 0;
    int n = 0;
    boolean bool1 = false;
    AppMethodBeat.i(200708);
    d.g.b.k.h(paramc, "status");
    Object localObject1 = d.c.vob;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "statusChange " + paramc + "  param:" + paramBundle);
    label603:
    label744:
    label750:
    label764:
    float f;
    switch (f.ciE[paramc.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "unknown key ".concat(String.valueOf(paramc)));
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
    case 26: 
    case 27: 
    case 28: 
    case 29: 
      do
      {
        AppMethodBeat.o(200708);
        return;
        this.LkJ.vjE.bringToFront();
        bTd();
        AppMethodBeat.o(200708);
        return;
        this.vna.fYe();
        AppMethodBeat.o(200708);
        return;
        if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP"))) {
          this.vmU.dit();
        }
        this.LkN.hideLoading();
        AppMethodBeat.o(200708);
        return;
        post((Runnable)new p(this));
        fXD();
        paramc = this.LkJ;
        paramBundle = paramc.vjC;
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
        paramc = paramc.vjD;
        if (paramc != null)
        {
          paramc.setVisibility(0);
          AppMethodBeat.o(200708);
          return;
        }
        AppMethodBeat.o(200708);
        return;
        if (paramBundle != null)
        {
          paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
          if (paramc != null)
          {
            paramBundle = this.LkJ;
            if (paramc != null) {
              paramBundle.vjE.O(paramc);
            }
            paramc = d.y.JfV;
            AppMethodBeat.o(200708);
            return;
          }
        }
        AppMethodBeat.o(200708);
        return;
        if (paramBundle != null)
        {
          localObject1 = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          paramc = this.LkJ;
          paramBundle = localObject1.toString();
          d.g.b.k.h(paramBundle, "text");
          if (paramc.vjC == null) {
            break label603;
          }
          localObject1 = paramc.vjC;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject1).setVisibility(0);
          }
          localObject1 = paramc.vjC;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject1).setText((CharSequence)paramBundle, i, j);
          }
          paramc.vjC = null;
        }
        for (;;)
        {
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
          paramc.vjE.n((CharSequence)paramBundle, i, j);
        }
        if (paramBundle != null)
        {
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          k = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          m = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          i = j;
          if (paramc != null)
          {
            if (paramc.length() != 0) {
              break label744;
            }
            i = j;
          }
          if (i == 0) {
            break label764;
          }
          this.LkJ.vjE.diW();
          j = this.LkJ.vjE.getLocationItemHeight();
          if (j != 0) {
            break label750;
          }
          i = 0;
          k = ao.fromDPToPix(getContext(), 44);
          this.vmS.Kk(i + j + k);
        }
        for (;;)
        {
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
          i = 0;
          break;
          i = ao.fromDPToPix(getContext(), 24);
          break label707;
          this.LkJ.as(paramc.toString(), k, m);
        }
        if (paramBundle != null)
        {
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          this.vmR.g(paramc, i, j);
          paramc = d.y.JfV;
        }
        AppMethodBeat.o(200708);
        return;
        if (paramBundle != null)
        {
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          this.vmS.g(paramc, i, j);
          paramc = d.y.JfV;
        }
        AppMethodBeat.o(200708);
        return;
        bTd();
        this.LkO.aig(-1);
        this.LkS.setVisibility(8);
        paramc = this.LkT;
        if (!this.LkO.fYE()) {
          bool1 = true;
        }
        paramc.setEnableLengthEdit(bool1);
        this.LkT.setTrack(this.LkO.Lqf);
        paramc = this.LkP;
        if (paramc == null) {
          d.g.b.k.aPZ("multiPreviewPlugin");
        }
        paramc.aW(this.LkO.fYE(), this.vmU.vmE.getMuteOrigin());
        AppMethodBeat.o(200708);
        return;
        if (paramBundle != null)
        {
          paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
          paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
          paramc = d.y.JfV;
        }
        AppMethodBeat.o(200708);
        return;
        AppMethodBeat.o(200708);
        return;
        AppMethodBeat.o(200708);
        return;
        if (paramBundle != null)
        {
          paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
          paramc = d.y.JfV;
        }
        AppMethodBeat.o(200708);
        return;
        AppMethodBeat.o(200708);
        return;
        this.LkQ.setVisibility(4);
        AppMethodBeat.o(200708);
        return;
        paramc = this.vjS;
        if (paramc != null)
        {
          paramBundle = this.vcC;
          if (paramBundle != null) {
            i = paramBundle.vhQ;
          }
          while (paramc.gBm - paramc.cUL > i + 250)
          {
            paramc = getContext();
            if (paramc == null)
            {
              paramc = new d.v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(200708);
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
                AppMethodBeat.o(200708);
                throw paramc;
              }
              ((Activity)paramc).finish();
              AppMethodBeat.o(200708);
              return;
            }
          }
          this.vmQ.setVisibility(0);
          this.LkJ.dif();
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
        }
        AppMethodBeat.o(200708);
        return;
        this.vmQ.setVisibility(0);
        this.vmU.dit();
        this.LkJ.dif();
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(200708);
        return;
        dia();
        AppMethodBeat.o(200708);
        return;
        int i1;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getByteArray("PARAM_EDIT_POI_INFO");
          paramc = this.LkJ;
          paramBundle = new chx().parseFrom(paramBundle);
          if (paramBundle == null)
          {
            paramc = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecordLocationInfo");
            AppMethodBeat.o(200708);
            throw paramc;
          }
          paramBundle = (chx)paramBundle;
          d.g.b.k.h(paramBundle, "storyLocation");
          if ((bt.isNullOrNil(paramBundle.goQ)) && (bt.isNullOrNil(paramBundle.ijO))) {
            break label1594;
          }
          i = 1;
          if (i == 0) {
            break label1611;
          }
          if (!paramc.vjE.diY()) {
            break label1600;
          }
          paramc.vjE.c(paramBundle);
          n = this.LkJ.vjE.getLocationItemHeight();
          if (n != 0) {
            break label1637;
          }
          i = 0;
          i1 = ao.fromDPToPix(getContext(), 44);
          localObject1 = this.LkJ;
          if (!((ac)localObject1).vjE.fYu()) {
            break label1657;
          }
          paramc = ((ac)localObject1).vjE.getTipItemView();
          if (paramc != null)
          {
            paramc = paramc.getText();
            if (paramc != null)
            {
              paramBundle = paramc.toString();
              paramc = paramBundle;
              if (paramBundle != null) {
                break label1511;
              }
            }
          }
          paramc = "";
          paramBundle = ((ac)localObject1).vjE.getTipItemView();
          if (paramBundle == null) {
            break label1651;
          }
          j = paramBundle.getColor();
          paramBundle = ((ac)localObject1).vjE.getTipItemView();
          if (paramBundle != null) {
            k = paramBundle.getTextBg();
          }
          ((ac)localObject1).as(paramc, j, k);
        }
        for (j = m;; j = 0)
        {
          if (j == 0) {
            this.vmS.Kk(i + n + i1);
          }
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
          i = 0;
          break;
          paramc.vjE.a(paramBundle);
          break label1426;
          if (!paramc.vjE.diY()) {
            break label1426;
          }
          paramc.vjE.y((d.g.a.a)ac.b.Lnl);
          break label1426;
          i = ao.fromDPToPix(getContext(), 24);
          break label1446;
          j = 0;
          break label1530;
        }
        this.vmT.dib();
        AppMethodBeat.o(200708);
        return;
        Object localObject3;
        if (paramBundle != null)
        {
          bool1 = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
          paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
          paramc = new ArrayList();
          if (paramBundle != null)
          {
            paramBundle = ((Iterable)paramBundle.vjg).iterator();
            for (;;)
            {
              if (paramBundle.hasNext())
              {
                byte[] arrayOfByte = (byte[])paramBundle.next();
                localObject1 = new bmx();
                localObject3 = (com.tencent.mm.bx.a)localObject1;
                try
                {
                  ((com.tencent.mm.bx.a)localObject3).parseFrom(arrayOfByte);
                  paramc.add(localObject1);
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ad.l("safeParser", "", new Object[] { localException });
                  }
                }
              }
            }
            paramBundle = d.y.JfV;
          }
          paramBundle = this.LkJ;
          paramc = (List)paramc;
          d.g.b.k.h(paramc, "lyricsInfo");
          if (!bool1) {
            break label1869;
          }
          if (!paramBundle.vjE.fYt()) {
            break label1858;
          }
          paramBundle.vjE.iY(paramc);
        }
        for (;;)
        {
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
          paramBundle.vjE.eO(paramc);
          continue;
          paramBundle.vjE.diX();
        }
        if (paramBundle != null)
        {
          if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.item.b.vsN.ordinal()) {
            this.vmU.fYn();
          }
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
        }
        AppMethodBeat.o(200708);
        return;
        this.LkN.aib(2131764707);
        paramc = this.vcC;
        if (paramc == null) {
          d.g.b.k.fvU();
        }
        paramc = paramc.vhU;
        this.Lld.LoO.AT(2L);
        fXF();
        paramBundle = (d.g.a.q)new m(this, paramc);
        if (this.LkR.nxe == 1) {}
        while (i != 0)
        {
          paramBundle = new com.tencent.mm.plugin.gallery.picker.b.b.b();
          localObject1 = com.tencent.mm.plugin.finder.utils.k.qTp;
          paramBundle.abC(com.tencent.mm.plugin.finder.utils.k.csc());
          localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
          paramBundle.maxHeight = com.tencent.mm.plugin.finder.storage.b.coH();
          localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
          paramBundle.maxWidth = com.tencent.mm.plugin.finder.storage.b.coI();
          localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
          paramBundle.rDv = com.tencent.mm.plugin.finder.storage.b.coJ();
          paramBundle = new com.tencent.mm.plugin.gallery.picker.b.b.e(paramBundle);
          localObject1 = new String[this.LkO.Lqg.size()];
          Object localObject2 = Boolean.TRUE;
          localObject3 = Boolean.TRUE;
          com.tencent.mm.plugin.recordvideo.d.b localb = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          paramc = new CaptureDataManager.CaptureVideoNormalModel((Boolean)localObject2, paramc, "", Long.valueOf(0L), (Boolean)localObject3, com.tencent.mm.plugin.recordvideo.d.b.dix());
          localObject2 = com.tencent.mm.plugin.finder.report.a.qFo;
          localObject2 = paramc.dhD();
          d.g.b.k.g(localObject2, "outputModel.reportInfo");
          com.tencent.mm.plugin.finder.report.a.c((RecordMediaReportInfo)localObject2);
          a(paramBundle, (String[])localObject1, paramc, 0);
          AppMethodBeat.o(200708);
          return;
          i = 0;
        }
        paramc = this.LkP;
        if (paramc == null) {
          d.g.b.k.aPZ("multiPreviewPlugin");
        }
        paramc.onPause();
        this.vmU.onPause();
        if (this.vmU.vgH != null)
        {
          paramc = com.tencent.mm.plugin.recordvideo.model.audio.i.vjj;
          paramc = com.tencent.mm.plugin.recordvideo.model.audio.i.dhZ();
          localObject1 = this.vmU.vgH;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          paramc.a((AudioCacheInfo)localObject1, (d.g.a.m)new l(this, paramBundle));
          AppMethodBeat.o(200708);
          return;
        }
        c(null, paramBundle);
        AppMethodBeat.o(200708);
        return;
        if (paramBundle != null)
        {
          paramc = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
          if (paramc != null)
          {
            i = paramc.dep;
            paramBundle = AudioCacheInfo.viM;
            if (i == AudioCacheInfo.dhQ())
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "current script index is :" + paramc.position);
              if (paramc.position != this.LkX)
              {
                if (this.LkR.nxe != 3) {
                  break label2504;
                }
                i = 1;
                if (i != 0)
                {
                  this.LkO.aI(paramc.position, this.LkI);
                  paramBundle = this.LkP;
                  if (paramBundle == null) {
                    d.g.b.k.aPZ("multiPreviewPlugin");
                  }
                  localObject1 = this.LkP;
                  if (localObject1 == null) {
                    d.g.b.k.aPZ("multiPreviewPlugin");
                  }
                  paramBundle.aW(((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject1).Ltt, this.vmU.vmE.getMuteOrigin());
                  paramBundle = this.LkT;
                  localObject1 = this.LkP;
                  if (localObject1 == null) {
                    d.g.b.k.aPZ("multiPreviewPlugin");
                  }
                  if (((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject1).Ltt) {
                    break label2510;
                  }
                }
              }
            }
            for (bool1 = bool2;; bool1 = false)
            {
              paramBundle.setEnableLengthEdit(bool1);
              paramBundle = this.LkO.aif(paramc.position);
              localObject1 = com.tencent.mm.plugin.vlog.model.j.yZD;
              com.tencent.mm.plugin.vlog.model.j.a(paramBundle);
              this.LkX = paramc.position;
              fXE();
              paramc = d.y.JfV;
              AppMethodBeat.o(200708);
              return;
              i = 0;
              break;
            }
          }
        }
        AppMethodBeat.o(200708);
        return;
      } while (!this.Lle);
      if (paramBundle != null)
      {
        paramc = (AudioCacheInfo)paramBundle.getParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE");
        if (paramc != null)
        {
          this.LkN.aib(2131764707);
          a(this, paramc.viz, (d.g.a.a)new n(this), 2);
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
        }
      }
      AppMethodBeat.o(200708);
      return;
    case 30: 
      this.vmU.eK(this.LkO.cUZ());
      AppMethodBeat.o(200708);
      return;
    case 31: 
      if (paramBundle != null)
      {
        bool1 = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.LkP;
        if (paramc == null) {
          d.g.b.k.aPZ("multiPreviewPlugin");
        }
        paramc = paramc.Lmo;
        if (paramc != null) {
          paramc.ze(bool1);
        }
        paramc = d.y.JfV;
        AppMethodBeat.o(200708);
        return;
      }
      AppMethodBeat.o(200708);
      return;
    case 32: 
      bTd();
      paramc = (Collection)this.LkO.cUZ();
      if (paramc != null)
      {
        i = n;
        if (!paramc.isEmpty()) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        paramc = this.vmU;
        paramBundle = this.vjS;
        if (paramBundle == null) {
          d.g.b.k.fvU();
        }
        com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, paramBundle, this.vcC);
        AppMethodBeat.o(200708);
        return;
      }
      this.vmU.eJ(this.LkO.cUZ());
      AppMethodBeat.o(200708);
      return;
    case 33: 
      if (paramBundle != null)
      {
        i = ((Number)Integer.valueOf(paramBundle.getInt("PARAM_SELECT_IMAGE_VLOG_SWITCH"))).intValue();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.VLogTAVKitPreviewPluginLayout", "EDIT_VLOG_SELECT_IMAGE_VLOG: ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
          this.Lle = false;
          setupImageEditPlugins(true);
          this.LkJ.yZ(false);
          continue;
          this.Lle = false;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "setupNormalVideoPlugins");
          this.LkQ.setVisibility(8);
          this.LkS.setVisibility(0);
          fXE();
          fXC();
          this.LkT.setEnableLengthEdit(true);
          this.LkJ.setFullScreen(true);
          this.LkS.Lup = false;
          this.Lla = false;
          if (this.LkO.Lqg.size() <= 1) {
            this.LkV.setVisibility(8);
          }
          for (;;)
          {
            kotlinx.coroutines.d.a((kotlinx.coroutines.ad)bc.Kem, (d.d.f)at.gaG(), (d.g.a.m)new i(this, null), 2);
            break;
            this.LkV.setVisibility(0);
          }
          this.Lle = true;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "setupVLogVideoPlugins");
          paramc = new com.tencent.mm.plugin.gallery.picker.b.b.b();
          paramBundle = com.tencent.mm.plugin.finder.utils.k.qTp;
          paramc.abC(com.tencent.mm.plugin.finder.utils.k.csc());
          paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
          paramc.maxHeight = com.tencent.mm.plugin.finder.storage.b.coH();
          paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
          paramc.maxWidth = com.tencent.mm.plugin.finder.storage.b.coI();
          paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
          paramc.rDv = com.tencent.mm.plugin.finder.storage.b.coJ();
          this.LkN.aib(2131764707);
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          paramBundle = new Rect();
          paramc.LtE.getVisibilityRect().round(paramBundle);
          this.LkO.lf(paramBundle.width(), paramBundle.height());
          this.LkJ.setFullScreen(false);
          this.LkS.Lup = false;
          a(this, 0, (d.g.a.a)new j(this), 3);
          this.LkV.setVisibility(0);
          this.Lla = false;
        }
      }
      AppMethodBeat.o(200708);
      return;
    case 34: 
      label1858:
      label1869:
      label2510:
      if (paramBundle != null)
      {
        paramBundle = (GalleryItem.MediaItem)paramBundle.getParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE");
        if (paramBundle != null)
        {
          this.LkW.mU("start", "select first image");
          this.vnh.reset();
          this.LkK.reset();
          paramc = this.LkK;
          paramBundle = (d.g.a.a)new o(paramBundle, this);
          d.g.b.k.h(paramBundle, "r");
          paramc.vjX.post((Runnable)new e(paramBundle));
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
        }
      }
      label2504:
      AppMethodBeat.o(200708);
      return;
    case 35: 
      label707:
      label1511:
      label1530:
      if (paramBundle != null)
      {
        paramBundle.getInt("EDIT_FILTER_INDEX_INT", -1);
        f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT", 0.0F);
        paramBundle = paramBundle.getString("EDIT_FILTER_COLOR_PATH_STRING");
        paramc = this.LkP;
        if (paramc == null) {
          d.g.b.k.aPZ("multiPreviewPlugin");
        }
        localObject1 = paramc.Lqf;
        if (localObject1 != null) {
          if (paramBundle != null) {
            break label4349;
          }
        }
      }
      label1426:
      label1446:
      label1594:
      label1600:
      label1611:
      label1637:
      label1651:
      label1657:
      break;
    }
    label3931:
    label4349:
    for (paramc = "";; paramc = paramBundle)
    {
      ((com.tencent.mm.plugin.vlog.model.v)localObject1).p(paramc, f);
      paramc = d.y.JfV;
      d.g.b.k.g(paramBundle, "path");
      this.LkY = paramBundle;
      this.LkZ = f;
      paramc = d.y.JfV;
      AppMethodBeat.o(200708);
      return;
      AppMethodBeat.o(200708);
      return;
      this.LkQ.setVisibility(0);
      this.LkK.reset();
      AppMethodBeat.o(200708);
      return;
      paramc = this.LkK;
      paramc.vjW = com.tencent.mm.api.g.cJv;
      paramc.goS = 0;
      paramBundle = paramc.vjU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJv);
      }
      paramc = paramc.vjU;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJv, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.alO("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.Ko(8);
      AppMethodBeat.o(200708);
      return;
      paramc = this.LkK;
      paramc.vjW = com.tencent.mm.api.g.cJv;
      paramc.goS = 1;
      paramBundle = paramc.vjU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJv);
      }
      paramc = paramc.vjU;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJv, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.alO("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.Ko(9);
      AppMethodBeat.o(200708);
      return;
      this.LkK.reset();
      if (paramBundle != null)
      {
        paramc = this.LkK;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.vjW = com.tencent.mm.api.g.cJs;
        paramc.goS = i;
        paramBundle = paramc.vjU;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJs);
        }
        paramc = paramc.vjU;
        if (paramc != null) {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJs, i, null);
        }
        paramc = d.y.JfV;
      }
      AppMethodBeat.o(200708);
      return;
      paramc = this.LkK;
      paramBundle = paramc.vjU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.Uw().Ux(), -1, null);
      }
      paramBundle = paramc.vjU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.vjW);
      }
      paramBundle = paramc.vjU;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.vjW, paramc.goS, null);
        AppMethodBeat.o(200708);
        return;
      }
      AppMethodBeat.o(200708);
      return;
      long l1;
      if (paramBundle != null)
      {
        bTd();
        i = paramBundle.getInt("EDIT_VLOG_SELECT_TRACK", -1);
        if (i >= 0)
        {
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          paramBundle = (com.tencent.mm.plugin.vlog.model.y)d.a.j.C((List)this.LkO.Lqf.LqL, i);
          if (paramBundle == null) {
            break label4031;
          }
          l1 = paramBundle.bxw;
          paramc.Ltx = l1;
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          paramBundle = (com.tencent.mm.plugin.vlog.model.y)d.a.j.C((List)this.LkO.Lqf.LqL, i);
          if (paramBundle == null) {
            break label4037;
          }
          l1 = paramBundle.Lro;
          paramc.Lty = l1;
          this.LkO.aig(i);
          this.LkS.setVisibility(8);
          paramc = this.LkT;
          if (this.LkO.fYE()) {
            break label4043;
          }
        }
        for (bool1 = bool3;; bool1 = false)
        {
          paramc.setEnableLengthEdit(bool1);
          this.LkT.setTrack(this.LkO.Lqf);
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          com.tencent.mm.plugin.vlog.ui.plugin.b.a(paramc, this.LkO.fYE());
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
          l1 = 0L;
          break;
          l1 = 0L;
          break label3931;
        }
      }
      AppMethodBeat.o(200708);
      return;
      if (paramBundle != null)
      {
        if (paramBundle.getBoolean("EDIT_VLOG_TRACK_CROP_CHANGE"))
        {
          l1 = paramBundle.getLong("EDIT_VLOG_TRACK_CROP_START");
          long l2 = paramBundle.getLong("EDIT_VLOG_TRAKC_CROP_END");
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          paramc.Lty = l1;
          this.LkO.Lqf.aD(l1, l2);
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          com.tencent.mm.plugin.vlog.ui.plugin.b.a(paramc, this.LkO.fYE());
        }
        for (;;)
        {
          fXE();
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
          fXD();
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          paramc.Ltx = 0L;
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          paramc.Lty = 0L;
          bool1 = paramBundle.getBoolean("EDIT_VLOG_TRACK_CROP_CONFIRM");
          i = paramBundle.getInt("EDIT_TRACK_DURATION_CUT_COUNT");
          j = paramBundle.getInt("EDIT_TRACK_DURATION_SCROLL_COUNT");
          this.LkO.k(bool1, i, j);
          paramc = this.LkP;
          if (paramc == null) {
            d.g.b.k.aPZ("multiPreviewPlugin");
          }
          com.tencent.mm.plugin.vlog.ui.plugin.b.a(paramc, this.LkO.fYE());
        }
      }
      AppMethodBeat.o(200708);
      return;
      if (paramBundle != null)
      {
        if (paramBundle.getBoolean("EDIT_FILTER_SHOW")) {
          bTd();
        }
        for (;;)
        {
          paramc = d.y.JfV;
          AppMethodBeat.o(200708);
          return;
          fXD();
        }
      }
      AppMethodBeat.o(200708);
      return;
      bTd();
      AppMethodBeat.o(200708);
      return;
      fXD();
      AppMethodBeat.o(200708);
      return;
    }
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(200721);
    if (!super.dia())
    {
      localObject = this.LkP;
      if (localObject == null) {
        d.g.b.k.aPZ("multiPreviewPlugin");
      }
      ((com.tencent.mm.plugin.vlog.ui.plugin.b)localObject).stopPreview();
      localObject = this.vmM;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    this.Lld.LoO.AT(1L);
    fXF();
    Object localObject = com.tencent.mm.plugin.finder.report.a.qFo;
    localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.finder.report.a.c(com.tencent.mm.plugin.recordvideo.d.b.dix());
    AppMethodBeat.o(200721);
    return true;
  }
  
  public final int getLayoutId()
  {
    return 2131496350;
  }
  
  public final void release()
  {
    AppMethodBeat.i(200722);
    super.release();
    this.LkO.dead();
    y.a locala = com.tencent.mm.plugin.vlog.model.y.Lrx;
    com.tencent.mm.plugin.vlog.model.y.fYQ().clear();
    AppMethodBeat.o(200722);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(200720);
    super.reset();
    this.Llc = WxCropOperationLayout.j.LpK;
    setBackgroundColor(0);
    AppMethodBeat.o(200720);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$Companion;", "", "()V", "KEY_IS_BEAUTY", "", "KEY_MEDIA_LIST", "KEY_POST_ID", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    b(MultiVideoPluginLayout paramMultiVideoPluginLayout, com.tencent.mm.plugin.vlog.model.l paraml, String paramString, Size paramSize, Rect paramRect, float[] paramArrayOfFloat, ArrayList paramArrayList, boolean paramBoolean, com.tencent.mm.plugin.vlog.model.v paramv, d.g.a.q paramq)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ret", "", "path", "", "edited", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.q<Boolean, String, Boolean, d.y>
  {
    c(MultiVideoPluginLayout paramMultiVideoPluginLayout, int paramInt, com.tencent.mm.plugin.gallery.picker.b.b.e parame, String[] paramArrayOfString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$initLogic$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-finder_release"})
  public static final class d
    implements CropLayout.b
  {
    public final void onChange()
    {
      AppMethodBeat.i(200681);
      Object localObject1 = MultiVideoPluginLayout.a(this.Lli).LtE.getVisibilityRect();
      Object localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      com.tencent.mm.plugin.recordvideo.background.f.dgK().set((int)((RectF)localObject1).left, (int)((RectF)localObject1).top, (int)((RectF)localObject1).right, (int)((RectF)localObject1).bottom);
      localObject2 = MultiVideoPluginLayout.b(this.Lli);
      localObject1 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      localObject1 = com.tencent.mm.plugin.recordvideo.background.f.dgK();
      d.g.b.k.h(localObject1, "validRect");
      localObject2 = ((ac)localObject2).vjE;
      d.g.b.k.h(localObject1, "validRect");
      int j = ((EditorItemContainer)localObject2).oQt.getChildCount();
      int i = 0;
      while (i < j)
      {
        if ((((EditorItemContainer)localObject2).oQt.getChildAt(i) instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.d))
        {
          View localView = ((EditorItemContainer)localObject2).oQt.getChildAt(i);
          if (localView == null)
          {
            localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.item.IEditView");
            AppMethodBeat.o(200681);
            throw ((Throwable)localObject1);
          }
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.d)localView).setValidArea((Rect)localObject1);
        }
        i += 1;
      }
      AppMethodBeat.o(200681);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$initLogic$audioSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.vlog.ui.plugin.b.e
  {
    public final void Cf(long paramLong)
    {
      AppMethodBeat.i(200682);
      MultiVideoPluginLayout.c(this.Lli).vmF.seekTo(paramLong);
      AppMethodBeat.o(200682);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(200683);
      MultiVideoPluginLayout.c(this.Lli).onPause();
      AppMethodBeat.o(200683);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(200684);
      MultiVideoPluginLayout.c(this.Lli).azC();
      AppMethodBeat.o(200684);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    f(MultiVideoPluginLayout paramMultiVideoPluginLayout, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$setupFilterPreview$1$1"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    g(com.tencent.mm.plugin.vlog.model.v paramv, MultiVideoPluginLayout paramMultiVideoPluginLayout)
    {
      super();
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.finder.vlog.MultiVideoPluginLayout$setupMediaData$1", f="MultiVideoPluginLayout.kt", l={384}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class h
    extends d.d.b.a.j
    implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super d.y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    Object nfO;
    Object nfP;
    Object nfQ;
    Object nfR;
    Object nfS;
    int nfX;
    int nfY;
    
    h(MultiVideoPluginLayout paramMultiVideoPluginLayout, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(200692);
      d.g.b.k.h(paramd, "completion");
      paramd = new h(this.Lli, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(200692);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(200691);
      paramObject = d.d.a.a.JgJ;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int j;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(200691);
        throw paramObject;
      case 0: 
        localObject1 = this.mTa;
        MultiVideoPluginLayout.d(this.Lli).clear();
        localObject2 = MultiVideoPluginLayout.e(this.Lli);
        if (localObject2 != null)
        {
          localObject2 = ((RecordConfigProvider)localObject2).hsl;
          if (localObject2 != null)
          {
            ((Bundle)localObject2).setClassLoader(GalleryItem.MediaItem.class.getClassLoader());
            localObject3 = ((Bundle)localObject2).getString("post_id");
            if (localObject3 != null)
            {
              MultiVideoPluginLayout.a(this.Lli, (String)localObject3);
              MultiVideoPluginLayout.g(this.Lli).LoO.aTq(MultiVideoPluginLayout.f(this.Lli));
            }
            localObject3 = ((Bundle)localObject2).getParcelableArrayList("media_list");
            if (localObject3 != null) {
              MultiVideoPluginLayout.d(this.Lli).addAll((Collection)localObject3);
            }
            localObject3 = (GalleryItem.MediaItem)d.a.j.iy((List)MultiVideoPluginLayout.d(this.Lli));
            g.a(MultiVideoPluginLayout.h(this.Lli), (GalleryItem.MediaItem)localObject3);
            j = ((Bundle)localObject2).getInt("KEY_PREVIEW_WIDTH");
            i = ((Bundle)localObject2).getInt("KEY_PREVIEW_HEIGHT");
            localObject3 = ai.cf(this.Lli.getContext());
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
        MultiVideoPluginLayout.i(this.Lli).lf(j, i);
        Object localObject4 = MultiVideoPluginLayout.i(this.Lli);
        int k = ((Point)localObject3).x;
        int m = ((Point)localObject3).y;
        ((com.tencent.mm.plugin.vlog.model.q)localObject4).BBm = k;
        ((com.tencent.mm.plugin.vlog.model.q)localObject4).CeA = m;
        Object localObject5 = (Iterable)MultiVideoPluginLayout.d(this.Lli);
        localObject4 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject5, 10));
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext()) {
          ((Collection)localObject4).add(((GalleryItem.MediaItem)((Iterator)localObject5).next()).czE());
        }
        localObject4 = (List)localObject4;
        Object localObject6 = (Iterable)MultiVideoPluginLayout.d(this.Lli);
        localObject5 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((Collection)localObject5).add(Integer.valueOf(((GalleryItem.MediaItem)((Iterator)localObject6).next()).getType()));
        }
        localObject5 = (List)localObject5;
        int n = MultiVideoPluginLayout.d(this.Lli).size();
        localObject6 = new Integer[n];
        k = 0;
        if (k < n)
        {
          ((Number)Integer.valueOf(k)).intValue();
          localObject7 = MultiVideoPluginLayout.j(this.Lli);
          if ((localObject7 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject7).gBl == true)) {}
          for (m = 1;; m = 0)
          {
            localObject6[k] = Integer.valueOf(m);
            k += 1;
            break;
          }
        }
        Object localObject7 = (d.d.f)at.fLg();
        d.g.a.m localm = (d.g.a.m)new a((List)localObject4, (List)localObject5, (Integer[])localObject6, null, this);
        this.mTb = localObject1;
        this.nfO = localObject2;
        this.nfX = j;
        this.nfY = i;
        this.nfP = localObject3;
        this.nfQ = localObject4;
        this.nfR = localObject5;
        this.nfS = localObject6;
        this.label = 1;
        if (kotlinx.coroutines.e.a((d.d.f)localObject7, localm, this) == paramObject)
        {
          AppMethodBeat.o(200691);
          return paramObject;
        }
        paramObject = (Iterable)MultiVideoPluginLayout.i(this.Lli).Lqi;
        i = 0;
        paramObject = paramObject.iterator();
        if (paramObject.hasNext())
        {
          localObject1 = paramObject.next();
          if (i < 0) {
            d.a.j.fvx();
          }
          localObject1 = (com.tencent.mm.plugin.vlog.model.y)localObject1;
          j = ((Number)Integer.valueOf(i)).intValue();
          localObject1 = ((com.tencent.mm.plugin.vlog.model.y)localObject1).Lrv;
          localObject2 = (GalleryItem.MediaItem)d.a.j.C((List)MultiVideoPluginLayout.d(this.Lli), j);
          if (localObject2 != null)
          {
            localObject2 = (Boolean)((GalleryItem.MediaItem)localObject2).E("KEY_MEDIA_IS_BEAUTY", Boolean.FALSE);
            if (localObject2 == null) {}
          }
          for (bool = ((Boolean)localObject2).booleanValue();; bool = false)
          {
            ((MediaEditReportInfo.EditItem)localObject1).isBeauty = bool;
            i += 1;
            break;
          }
        }
        paramObject = MultiVideoPluginLayout.a(this.Lli).Ltr;
        localObject1 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
        paramObject.round(com.tencent.mm.plugin.recordvideo.background.f.dgK());
        localObject1 = MultiVideoPluginLayout.i(this.Lli);
        d.g.b.k.h(paramObject, "maxVisibleRect");
        ((com.tencent.mm.plugin.vlog.model.q)localObject1).Lqo.set(paramObject);
        float f = (paramObject.height() - paramObject.width() * ((com.tencent.mm.plugin.vlog.model.q)localObject1).Lqn) / 2.0F;
        ((com.tencent.mm.plugin.vlog.model.q)localObject1).Lqo.inset(0.0F, f);
        MultiVideoPluginLayout.i(this.Lli).fYB();
        paramObject = MultiVideoPluginLayout.a(this.Lli);
        localObject1 = MultiVideoPluginLayout.i(this.Lli).Lqo;
        d.g.b.k.h(localObject1, "rect");
        localObject2 = paramObject.LtA;
        d.g.b.k.h(localObject1, "rect");
        ((com.tencent.mm.plugin.vlog.ui.plugin.c)localObject2).Lqo.set((RectF)localObject1);
        localObject2 = paramObject.LtB;
        d.g.b.k.h(localObject1, "rect");
        ((com.tencent.mm.plugin.vlog.ui.plugin.g)localObject2).Lqo.set((RectF)localObject1);
        paramObject.rGB.set((RectF)localObject1);
        paramObject.LtE.getVisibilityRect().set((RectF)localObject1);
        paramObject.LtE.postInvalidate();
        paramObject.LtE.setVisibility(0);
        boolean bool = MultiVideoPluginLayout.i(this.Lli).Lqj;
        MultiVideoPluginLayout.k(this.Lli).LkC = bool;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogTAVKitPreviewPluginLayout", "initLogic isAllImage:".concat(String.valueOf(bool)));
        if (bool)
        {
          paramObject = MultiVideoPluginLayout.l(this.Lli);
          localObject1 = MultiVideoPluginLayout.d(this.Lli);
          d.g.b.k.h(localObject1, "list");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EditFooterRecyclerPlugin", "updateList = " + ((ArrayList)localObject1).size());
          paramObject.Lkv.clear();
          paramObject.Lkv.addAll((Collection)localObject1);
          localObject1 = paramObject.Lkw;
          if (localObject1 == null) {
            d.g.b.k.aPZ("adapter");
          }
          ((a.b)localObject1).setItems((List)paramObject.Lkv);
          paramObject = paramObject.Lkw;
          if (paramObject == null) {
            d.g.b.k.aPZ("adapter");
          }
          paramObject.notifyDataSetChanged();
          MultiVideoPluginLayout.m(this.Lli);
          MultiVideoPluginLayout.b(this.Lli).yZ(false);
          MultiVideoPluginLayout.b(this.Lli).setFullScreen(true);
        }
        for (;;)
        {
          paramObject = MultiVideoPluginLayout.k(this.Lli);
          paramObject.yU(paramObject.LkB);
          if ((MultiVideoPluginLayout.d(this.Lli).size() <= 1) || (MultiVideoPluginLayout.i(this.Lli).Lqj)) {
            MultiVideoPluginLayout.p(this.Lli).setVisibility(8);
          }
          paramObject = d.y.JfV;
          AppMethodBeat.o(200691);
          return paramObject;
          MultiVideoPluginLayout.n(this.Lli).setVisibility(8);
          MultiVideoPluginLayout.o(this.Lli);
          MultiVideoPluginLayout.b(this.Lli).setFullScreen(true);
        }
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(200693);
      paramObject1 = ((h)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(200693);
      return paramObject1;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$setupMediaData$1$1$4"})
    static final class a
      extends d.d.b.a.j
      implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super Boolean>, Object>
    {
      int label;
      private kotlinx.coroutines.ad mTa;
      Object mTb;
      
      a(List paramList1, List paramList2, Integer[] paramArrayOfInteger, d.d.d paramd, MultiVideoPluginLayout.h paramh)
      {
        super();
      }
      
      public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(200689);
        d.g.b.k.h(paramd, "completion");
        paramd = new a(this.LlB, this.LlC, this.LlD, paramd, jdField_this);
        paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
        AppMethodBeat.o(200689);
        return paramd;
      }
      
      public final Object cP(Object paramObject)
      {
        AppMethodBeat.i(200688);
        d.d.a.a locala = d.d.a.a.JgJ;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(200688);
          throw paramObject;
        case 0: 
          paramObject = this.mTa;
          Object localObject = MultiVideoPluginLayout.i(jdField_this.Lli);
          List localList1 = this.LlB;
          List localList2 = this.LlC;
          List localList3 = d.a.e.T(this.LlD);
          this.mTb = paramObject;
          this.label = 1;
          localObject = kotlinx.coroutines.e.a((d.d.f)at.fLg(), (d.g.a.m)new q.c((com.tencent.mm.plugin.vlog.model.q)localObject, localList1, localList2, localList3, null), this);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(200688);
            return locala;
          }
          break;
        }
        AppMethodBeat.o(200688);
        return paramObject;
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(200690);
        paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
        AppMethodBeat.o(200690);
        return paramObject1;
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.finder.vlog.MultiVideoPluginLayout$setupNormalVideoPlugins$1", f="MultiVideoPluginLayout.kt", l={1079}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class i
    extends d.d.b.a.j
    implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super d.y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    
    i(MultiVideoPluginLayout paramMultiVideoPluginLayout, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(200695);
      d.g.b.k.h(paramd, "completion");
      paramd = new i(this.Lli, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(200695);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(200694);
      paramObject = d.d.a.a.JgJ;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(200694);
        throw paramObject;
      case 0: 
        kotlinx.coroutines.ad localad = this.mTa;
        com.tencent.mm.plugin.vlog.model.q localq = MultiVideoPluginLayout.i(this.Lli);
        long l = MultiVideoPluginLayout.t(this.Lli);
        this.mTb = localad;
        this.label = 1;
        if (localq.b(l, this) == paramObject)
        {
          AppMethodBeat.o(200694);
          return paramObject;
        }
        break;
      }
      MultiVideoPluginLayout.c(this.Lli).vmF.seekTo(0L);
      MultiVideoPluginLayout.a(this.Lli).aW(false, MultiVideoPluginLayout.c(this.Lli).vmE.getMuteOrigin());
      this.Lli.setBackgroundColor(-16777216);
      paramObject = d.y.JfV;
      AppMethodBeat.o(200694);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(200696);
      paramObject1 = ((i)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(200696);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    j(MultiVideoPluginLayout paramMultiVideoPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$sortCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$TrackSortCallback;", "onMove", "", "fromPosition", "", "toPosition", "onSortEnd", "plugin-finder_release"})
  public static final class k
    implements h.b
  {
    public final void fXG()
    {
      AppMethodBeat.i(200699);
      com.tencent.mm.plugin.vlog.model.q localq = MultiVideoPluginLayout.i(this.Lli);
      long l1 = 0L;
      Iterator localIterator = ((Iterable)localq.Lqt).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.vlog.model.y localy = (com.tencent.mm.plugin.vlog.model.y)localIterator.next();
        long l2 = localy.gnO - localy.bxw;
        localy.bxw = l1;
        localy.gnO = (l1 + l2);
        l1 += l2;
      }
      localq.Lqf = new com.tencent.mm.plugin.vlog.model.v((List)localq.Lqt, null, 6);
      com.tencent.mm.plugin.vlog.ui.plugin.b.a(MultiVideoPluginLayout.a(this.Lli), false);
      MultiVideoPluginLayout.v(this.Lli);
      AppMethodBeat.o(200699);
    }
    
    public final void fl(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200698);
      Collections.swap((List)MultiVideoPluginLayout.i(this.Lli).Lqt, paramInt1, paramInt2);
      AppMethodBeat.o(200698);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.m<Boolean, String, d.y>
  {
    l(MultiVideoPluginLayout paramMultiVideoPluginLayout, d.g.a.q paramq)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "thumb", "Landroid/graphics/Bitmap;", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.q<Boolean, dxw, Bitmap, d.y>
  {
    m(MultiVideoPluginLayout paramMultiVideoPluginLayout, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$statusChange$14$1"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    n(MultiVideoPluginLayout paramMultiVideoPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/vlog/MultiVideoPluginLayout$statusChange$17$1"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    o(GalleryItem.MediaItem paramMediaItem, MultiVideoPluginLayout paramMultiVideoPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(MultiVideoPluginLayout paramMultiVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(200705);
      Object localObject = MultiVideoPluginLayout.b(this.Lli).vjE.getParent();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(200705);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      ((ViewGroup)localObject).removeView((View)MultiVideoPluginLayout.b(this.Lli).vjE);
      View localView = (View)MultiVideoPluginLayout.b(this.Lli).vjE;
      com.tencent.mm.plugin.vlog.ui.plugin.b localb = MultiVideoPluginLayout.a(this.Lli);
      ((ViewGroup)localObject).addView(localView, localb.fSZ.indexOfChild((View)localb.LtD) + 1);
      AppMethodBeat.o(200705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.MultiVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */