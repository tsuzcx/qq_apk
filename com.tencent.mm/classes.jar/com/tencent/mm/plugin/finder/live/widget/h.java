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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "coverLayout", "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "MENU_ID_SET_HEADIMG_ALBUM", "", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "avatarUrl", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "choosePath", "getChoosePath", "setChoosePath", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "getCoverLayout", "()Landroid/view/ViewGroup;", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "chooseNewCover", "", "editImage", "", "inputPath", "getDefaultCover", "getDefaultCoverSize", "Landroid/graphics/Point;", "getThumbCover", "isReady", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onEditFinish", "p0", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "Landroid/os/Bundle;", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extData", "setCover", "Companion", "plugin-finder_release"})
public final class h
  implements CaptureDataManager.b
{
  private static final int uGK = 300;
  private static final int uGL = 350;
  public static final a uGM;
  public final String TAG;
  public final MMActivity activity;
  public String kog;
  public final ImageView puw;
  public String uEu;
  public String uGF;
  public final int uGG;
  public final int uGH;
  private final ViewGroup uGI;
  public final FinderLivePostUIC.e uGJ;
  
  static
  {
    AppMethodBeat.i(248108);
    uGM = new a((byte)0);
    uGK = 300;
    uGL = 350;
    AppMethodBeat.o(248108);
  }
  
  public h(MMActivity paramMMActivity, ViewGroup paramViewGroup, FinderLivePostUIC.e parame)
  {
    AppMethodBeat.i(248107);
    this.activity = paramMMActivity;
    this.uGI = paramViewGroup;
    this.uGJ = parame;
    this.TAG = "Finder.FinderLivePostCoverWidget";
    this.uGF = "";
    this.kog = "";
    this.uEu = "";
    this.uGG = 10010;
    this.uGH = 10011;
    paramMMActivity = this.uGI.findViewById(2131300978);
    p.g(paramMMActivity, "coverLayout.findViewById….id.finder_live_cover_iv)");
    this.puw = ((ImageView)paramMMActivity);
    this.uGI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248104);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!g.aAh().isSDCardAvailable()) {
          u.kf((Context)this.uGN.activity);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(248104);
          return;
          s.c((Activity)this.uGN.activity, h.a(this.uGN), null);
        }
      }
    });
    AppMethodBeat.o(248107);
  }
  
  public static Point djK()
  {
    AppMethodBeat.i(248105);
    Point localPoint = new Point(uGK, uGL);
    AppMethodBeat.o(248105);
    return localPoint;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(248106);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", paramBundle);
    if (paramCaptureVideoNormalModel == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.os.Parcelable");
      AppMethodBeat.o(248106);
      throw paramContext;
    }
    localIntent.putExtra("KSEGMENTMEDIAINFO", (Parcelable)paramCaptureVideoNormalModel);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(248106);
      throw paramContext;
    }
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(248106);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget$Companion;", "", "()V", "DEFAULT_COVER_HEIGHT", "", "getDEFAULT_COVER_HEIGHT", "()I", "DEFAULT_COVER_WIDTH", "getDEFAULT_COVER_WIDTH", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.h
 * JD-Core Version:    0.7.0.1
 */