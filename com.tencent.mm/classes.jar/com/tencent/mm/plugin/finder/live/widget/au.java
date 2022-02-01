package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.k.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "coverLayout", "Landroid/view/ViewGroup;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "MENU_ID_SET_HEADIMG_ALBUM", "", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "avatarUrl", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "choosePath", "getChoosePath", "setChoosePath", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "getCoverLayout", "()Landroid/view/ViewGroup;", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "chooseNewCover", "", "editImage", "", "inputPath", "getDefaultCover", "getDefaultCoverSize", "Landroid/graphics/Point;", "getThumbCover", "isReady", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onEditFinish", "p0", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "Landroid/os/Bundle;", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extData", "setCover", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  implements CaptureDataManager.b
{
  private static final int ElB;
  private static final int ElC;
  public static final au.a EsL;
  public String Ebq;
  public String EcY;
  public final int ElA;
  public final k.f Elx;
  public final int Elz;
  private final ViewGroup EsM;
  public final String TAG;
  public final MMActivity activity;
  public final ImageView coverIv;
  public String nVM;
  
  static
  {
    AppMethodBeat.i(361496);
    EsL = new au.a((byte)0);
    ElB = 300;
    ElC = 350;
    AppMethodBeat.o(361496);
  }
  
  public au(MMActivity paramMMActivity, ViewGroup paramViewGroup, k.f paramf)
  {
    AppMethodBeat.i(361473);
    this.activity = paramMMActivity;
    this.EsM = paramViewGroup;
    this.Elx = paramf;
    this.TAG = "Finder.FinderLivePostCoverWidget";
    this.Ebq = "";
    this.nVM = "";
    this.EcY = "";
    this.Elz = 10010;
    this.ElA = 10011;
    paramMMActivity = this.EsM.findViewById(p.e.BKg);
    s.s(paramMMActivity, "coverLayout.findViewById….id.finder_live_cover_iv)");
    this.coverIv = ((ImageView)paramMMActivity);
    this.EsM.setOnClickListener(new au..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(361473);
  }
  
  private static final void a(au paramau, View paramView)
  {
    AppMethodBeat.i(361488);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramau);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramau, "this$0");
    if (!h.baE().isSDCardAvailable()) {
      aa.nh((Context)paramau.activity);
    }
    for (;;)
    {
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361488);
      return;
      t.a((Activity)paramau.activity, paramau.Elz, 1, 28, null);
    }
  }
  
  public static Point ezT()
  {
    AppMethodBeat.i(361477);
    Point localPoint = new Point(ElB, ElC);
    AppMethodBeat.o(361477);
    return localPoint;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(361531);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", paramBundle);
    if (paramCaptureVideoNormalModel == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.os.Parcelable");
      AppMethodBeat.o(361531);
      throw paramContext;
    }
    localIntent.putExtra("KSEGMENTMEDIAINFO", (Parcelable)paramCaptureVideoNormalModel);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(361531);
      throw paramContext;
    }
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(361531);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final boolean eBl()
  {
    AppMethodBeat.i(361512);
    if ((!Util.isNullOrNil(this.Ebq)) && (y.ZC(this.Ebq)))
    {
      AppMethodBeat.o(361512);
      return true;
    }
    AppMethodBeat.o(361512);
    return false;
  }
  
  public final String eBm()
  {
    AppMethodBeat.i(361520);
    if (!Util.isNullOrNil(this.EcY))
    {
      str = this.EcY;
      AppMethodBeat.o(361520);
      return str;
    }
    String str = this.nVM;
    AppMethodBeat.o(361520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.au
 * JD-Core Version:    0.7.0.1
 */