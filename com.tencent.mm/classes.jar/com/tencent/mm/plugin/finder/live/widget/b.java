package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.live.viewmodel.k.f;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "activity", "Landroid/app/Activity;", "coverIv", "Landroid/widget/ImageView;", "replaceCoverIv", "Landroid/view/View;", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Landroid/app/Activity;Landroid/widget/ImageView;Landroid/view/View;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "MENU_ID_SET_HEADIMG_ALBUM", "", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "TAG", "", "getActivity", "()Landroid/app/Activity;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "choosePath", "getChoosePath", "()Ljava/lang/String;", "setChoosePath", "(Ljava/lang/String;)V", "getCoverIv", "()Landroid/widget/ImageView;", "liveCoverMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getLiveCoverMedia", "()Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "setLiveCoverMedia", "(Lcom/tencent/mm/protocal/protobuf/FinderMedia;)V", "liveCoverUrl", "getLiveCoverUrl", "setLiveCoverUrl", "getReplaceCoverIv", "()Landroid/view/View;", "chooseNewCover", "", "editImage", "", "inputPath", "getCoverMedia", "getDefaultCoverSize", "Landroid/graphics/Point;", "goToPreviewUI", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onEditFinish", "p0", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "Landroid/os/Bundle;", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extData", "selectCover", "setCover", "coverUrl", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements CaptureDataManager.b
{
  private static final int ElB;
  private static final int ElC;
  public static final b.a Elw;
  private final View DXD;
  public String Ebq;
  public String EcY;
  public final int ElA;
  public final k.f Elx;
  public FinderMedia Ely;
  public final int Elz;
  public final String TAG;
  public final Activity activity;
  public final ImageView coverIv;
  
  static
  {
    AppMethodBeat.i(361092);
    Elw = new b.a((byte)0);
    ElB = 300;
    ElC = 400;
    AppMethodBeat.o(361092);
  }
  
  public b(Activity paramActivity, ImageView paramImageView, View paramView, k.f paramf)
  {
    AppMethodBeat.i(361029);
    this.activity = paramActivity;
    this.coverIv = paramImageView;
    this.DXD = paramView;
    this.Elx = paramf;
    this.TAG = "Finder.FinderLivePostCoverWidget";
    this.Ebq = "";
    this.EcY = "";
    this.Elz = 10010;
    this.ElA = 10011;
    this.coverIv.setOnClickListener(new b..ExternalSyntheticLambda0(this));
    this.DXD.setOnClickListener(new b..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(361029);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(361061);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    int i;
    if (((CharSequence)paramb.EcY).length() == 0)
    {
      i = 1;
      if (i != 0)
      {
        if (((CharSequence)paramb.Ebq).length() != 0) {
          break label199;
        }
        i = 1;
        label95:
        if (i != 0) {}
      }
      else
      {
        paramView = new Intent();
        if (((CharSequence)paramb.Ebq).length() <= 0) {
          break label204;
        }
        i = 1;
        label124:
        if (i == 0) {
          break label209;
        }
        paramView.putStringArrayListExtra("key_file_list", kotlin.a.p.al(new String[] { paramb.Ebq }));
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class)).v((Context)paramb.activity, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361061);
      return;
      i = 0;
      break;
      label199:
      i = 0;
      break label95;
      label204:
      i = 0;
      break label124;
      label209:
      paramView.putStringArrayListExtra("key_url_list", kotlin.a.p.al(new String[] { paramb.EcY }));
    }
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(361073);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    if (!h.baE().isSDCardAvailable()) {
      aa.nh((Context)paramb.activity);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361073);
      return;
      t.a(paramb.activity, paramb.Elz, 1, 28, null);
    }
  }
  
  public static Point ezT()
  {
    AppMethodBeat.i(361041);
    Point localPoint = new Point(ElB, ElC);
    AppMethodBeat.o(361041);
    return localPoint;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(361137);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_extra_data", paramBundle);
    if (paramCaptureVideoNormalModel == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.os.Parcelable");
      AppMethodBeat.o(361137);
      throw paramContext;
    }
    localIntent.putExtra("KSEGMENTMEDIAINFO", (Parcelable)paramCaptureVideoNormalModel);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(361137);
      throw paramContext;
    }
    ((Activity)paramContext).setResult(-1, localIntent);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(361137);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void setCover(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(361125);
    kotlin.g.b.s.u(paramString, "coverUrl");
    Log.i(this.TAG, kotlin.g.b.s.X("setCover liveCover:", paramString));
    this.EcY = paramString;
    this.Ely = null;
    paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
    paramString = com.tencent.mm.plugin.finder.loader.p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(this.EcY, v.FKZ));
    Object localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject2 = paramString.a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
    paramString = localObject1;
    if ((localObject2 instanceof com.tencent.mm.loader.a.a)) {
      paramString = (com.tencent.mm.loader.a.a)localObject2;
    }
    if (paramString != null) {
      paramString.a(this.coverIv, (m)new b(this));
    }
    this.Elx.onChange();
    AppMethodBeat.o(361125);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<g<?>, Bitmap, ah>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.b
 * JD-Core Version:    0.7.0.1
 */