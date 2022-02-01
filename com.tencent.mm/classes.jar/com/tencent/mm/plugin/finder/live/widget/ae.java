package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.viewmodel.i.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "coverLayout", "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "MENU_ID_SET_HEADIMG_ALBUM", "", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "avatarUrl", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "choosePath", "getChoosePath", "setChoosePath", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "getCoverLayout", "()Landroid/view/ViewGroup;", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "chooseNewCover", "", "editImage", "", "inputPath", "getDefaultCover", "getDefaultCoverSize", "Landroid/graphics/Point;", "getThumbCover", "isReady", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onEditFinish", "p0", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "Landroid/os/Bundle;", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extData", "setCover", "Companion", "plugin-finder_release"})
public final class ae
  implements CaptureDataManager.b
{
  private static final int zln = 300;
  private static final int zlo = 350;
  public static final a zqf;
  public final String TAG;
  public final MMActivity activity;
  public String nfY;
  public final ImageView sDJ;
  public String zex;
  public String zfA;
  public final int zlk;
  public final int zll;
  public final i.e zlm;
  private final ViewGroup zqe;
  
  static
  {
    AppMethodBeat.i(290397);
    zqf = new a((byte)0);
    zln = 300;
    zlo = 350;
    AppMethodBeat.o(290397);
  }
  
  public ae(MMActivity paramMMActivity, ViewGroup paramViewGroup, i.e parame)
  {
    AppMethodBeat.i(290396);
    this.activity = paramMMActivity;
    this.zqe = paramViewGroup;
    this.zlm = parame;
    this.TAG = "Finder.FinderLivePostCoverWidget";
    this.zex = "";
    this.nfY = "";
    this.zfA = "";
    this.zlk = 10010;
    this.zll = 10011;
    paramMMActivity = this.zqe.findViewById(b.f.finder_live_cover_iv);
    p.j(paramMMActivity, "coverLayout.findViewById….id.finder_live_cover_iv)");
    this.sDJ = ((ImageView)paramMMActivity);
    this.zqe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(275045);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!h.aHG().isSDCardAvailable()) {
          w.ld((Context)this.zqg.activity);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(275045);
          return;
          u.a((Activity)this.zqg.activity, ae.a(this.zqg), 1, 28, null);
        }
      }
    });
    AppMethodBeat.o(290396);
  }
  
  public static Point dHG()
  {
    AppMethodBeat.i(290394);
    Point localPoint = new Point(zln, zlo);
    AppMethodBeat.o(290394);
    return localPoint;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(290395);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", paramBundle);
    if (paramCaptureVideoNormalModel == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.os.Parcelable");
      AppMethodBeat.o(290395);
      throw paramContext;
    }
    localIntent.putExtra("KSEGMENTMEDIAINFO", (Parcelable)paramCaptureVideoNormalModel);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(290395);
      throw paramContext;
    }
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(290395);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$Companion;", "", "()V", "DEFAULT_COVER_HEIGHT", "", "getDEFAULT_COVER_HEIGHT", "()I", "DEFAULT_COVER_WIDTH", "getDEFAULT_COVER_WIDTH", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ae
 * JD-Core Version:    0.7.0.1
 */