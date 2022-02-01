package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.live.viewmodel.i.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "activity", "Landroid/app/Activity;", "coverIv", "Landroid/widget/ImageView;", "replaceCoverIv", "Landroid/view/View;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Landroid/app/Activity;Landroid/widget/ImageView;Landroid/view/View;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "MENU_ID_SET_HEADIMG_ALBUM", "", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "TAG", "", "getActivity", "()Landroid/app/Activity;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "choosePath", "getChoosePath", "()Ljava/lang/String;", "setChoosePath", "(Ljava/lang/String;)V", "getCoverIv", "()Landroid/widget/ImageView;", "liveCoverMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getLiveCoverMedia", "()Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "setLiveCoverMedia", "(Lcom/tencent/mm/protocal/protobuf/FinderMedia;)V", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "getReplaceCoverIv", "()Landroid/view/View;", "chooseNewCover", "", "editImage", "", "inputPath", "getCoverMedia", "getDefaultCoverSize", "Landroid/graphics/Point;", "goToPreviewUI", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onEditFinish", "p0", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "Landroid/os/Bundle;", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extData", "selectCover", "setCover", "coverUrl", "Companion", "plugin-finder_release"})
public final class a
  implements CaptureDataManager.b
{
  private static final int zln = 300;
  private static final int zlo = 400;
  public static final a zlp;
  public final String TAG;
  public final Activity activity;
  public final ImageView sDJ;
  private final View zbu;
  public String zex;
  public String zfA;
  public FinderMedia zlj;
  public final int zlk;
  public final int zll;
  public final i.e zlm;
  
  static
  {
    AppMethodBeat.i(289456);
    zlp = new a((byte)0);
    zln = 300;
    zlo = 400;
    AppMethodBeat.o(289456);
  }
  
  public a(Activity paramActivity, ImageView paramImageView, View paramView, i.e parame)
  {
    AppMethodBeat.i(289455);
    this.activity = paramActivity;
    this.sDJ = paramImageView;
    this.zbu = paramView;
    this.zlm = parame;
    this.TAG = "Finder.FinderLivePostCoverWidget";
    this.zex = "";
    this.zfA = "";
    this.zlk = 10010;
    this.zll = 10011;
    this.sDJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(289821);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        a.a(this.zlq);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289821);
      }
    });
    this.zbu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(287437);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        a.b(this.zlq);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287437);
      }
    });
    AppMethodBeat.o(289455);
  }
  
  public static Point dHG()
  {
    AppMethodBeat.i(289453);
    Point localPoint = new Point(zln, zlo);
    AppMethodBeat.o(289453);
    return localPoint;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(289454);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", paramBundle);
    if (paramCaptureVideoNormalModel == null)
    {
      paramContext = new kotlin.t("null cannot be cast to non-null type android.os.Parcelable");
      AppMethodBeat.o(289454);
      throw paramContext;
    }
    localIntent.putExtra("KSEGMENTMEDIAINFO", (Parcelable)paramCaptureVideoNormalModel);
    if (paramContext == null)
    {
      paramContext = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(289454);
      throw paramContext;
    }
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(289454);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void setCover(String paramString)
  {
    AppMethodBeat.i(289452);
    p.k(paramString, "coverUrl");
    Log.i(this.TAG, "setCover liveCover:".concat(String.valueOf(paramString)));
    this.zfA = paramString;
    this.zlj = null;
    paramString = com.tencent.mm.plugin.finder.loader.t.ztT;
    paramString = com.tencent.mm.plugin.finder.loader.t.dJe().bQ(new x(this.zfA, u.Alz));
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    paramString.a(com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).a((e)new b(this)).c(this.sDJ);
    this.zlm.onChange();
    AppMethodBeat.o(289452);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget$Companion;", "", "()V", "DEFAULT_COVER_HEIGHT", "", "getDEFAULT_COVER_HEIGHT", "()I", "DEFAULT_COVER_WIDTH", "getDEFAULT_COVER_WIDTH", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class b<T, R>
    implements e<w, Bitmap>
  {
    b(a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.a
 * JD-Core Version:    0.7.0.1
 */