package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.plugin.finder.video.develop.DevFinderRecordPluginLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.vlog.MultiVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.a.j;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(7)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "fromRecordUI", "", "hasStopped", "postId", "", "router", "", "getLayoutId", "goRouter", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFinishBtnClick", "context", "Landroid/content/Context;", "extData", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "takePhoto", "Companion", "plugin-finder_release"})
public final class FinderPostRouterUI
  extends MMFinderUI
  implements CaptureDataManager.b
{
  public static final FinderPostRouterUI.a rJN;
  private HashMap _$_findViewCache;
  private String postId = "";
  private int rJK = -1;
  private boolean rJL;
  private boolean rJM;
  
  static
  {
    AppMethodBeat.i(203285);
    rJN = new FinderPostRouterUI.a((byte)0);
    AppMethodBeat.o(203285);
  }
  
  private void ari()
  {
    AppMethodBeat.i(167502);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    localObject1 = com.tencent.mm.plugin.finder.storage.b.cxY();
    ac.i("Finder.FinderPostRouterUI", "videoParams ".concat(String.valueOf(localObject1)));
    Object localObject2 = p.rQw;
    localObject1 = RecordConfigProvider.a(p.cDr(), "", (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 11);
    ((RecordConfigProvider)localObject1).wqB = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).wqP.wqT = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbo, true);
    ((RecordConfigProvider)localObject1).wqP.wqV = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbp, -1);
    ((RecordConfigProvider)localObject1).wqP.wqW = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbq, -1);
    ((RecordConfigProvider)localObject1).wqP.wqX = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbr, -1);
    ((RecordConfigProvider)localObject1).wqP.wqY = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbs, -1);
    ((RecordConfigProvider)localObject1).wqP.wqZ = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbt, -1);
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).YZ();
    ((UICustomParam.a)localObject2).YX();
    ((UICustomParam.a)localObject2).YW();
    ((UICustomParam.a)localObject2).YV();
    ((UICustomParam.a)localObject2).cN(false);
    ((UICustomParam.a)localObject2).YY();
    AppCompatActivity localAppCompatActivity = getContext();
    k.g(localAppCompatActivity, "context");
    ((UICustomParam.a)localObject2).lc(localAppCompatActivity.getResources().getColor(2131100725));
    ((RecordConfigProvider)localObject1).wqu = ((UICustomParam.a)localObject2).Za();
    ((RecordConfigProvider)localObject1).wqv = h.e.DnJ;
    ((RecordConfigProvider)localObject1).hSN = new Bundle();
    ((RecordConfigProvider)localObject1).hSN.putString("post_id", this.postId);
    ((RecordConfigProvider)localObject1).D(4, MultiVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject1).D(1, MultiVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject1).D(3, MultiVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject1).D(0, FinderRecordPluginLayout.class.getName());
    localObject2 = g.agR();
    k.g(localObject2, "MMKernel.storage()");
    if (((e)localObject2).agA().getInt(ah.a.GVO, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((RecordConfigProvider)localObject1).D(0, DevFinderRecordPluginLayout.class.getName());
      }
      CaptureDataManager.wqi.a((CaptureDataManager.b)this);
      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
      AppMethodBeat.o(167502);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203286);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(203286);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(167503);
    k.h(paramContext, "context");
    k.h(paramCaptureVideoNormalModel, "model");
    k.h(paramBundle, "extData");
    ac.i("Finder.FinderPostRouterUI", "onMediaGenerated");
    this.rJM = false;
    Object localObject1 = new bsz();
    ((bsz)localObject1).FhZ = true;
    ((bsz)localObject1).FhY = false;
    localObject1 = new Intent();
    Object localObject2 = (Collection)paramCaptureVideoNormalModel.dvl();
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)new ArrayList((Collection)paramCaptureVideoNormalModel.dvl()));
      paramBundle = paramCaptureVideoNormalModel.dvl();
      k.g(paramBundle, "model.multiImagePath");
      localObject2 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          ((Iterator)localObject2).next();
          paramBundle.add(Integer.valueOf(2));
          continue;
          i = 0;
          break;
        }
      }
      ((Intent)localObject1).putExtra("postTypeList", (Serializable)paramBundle);
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("KEY_POST_FROM_CAMERA", true);
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)paramCaptureVideoNormalModel.dvk().x("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramBundle = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramBundle = getIntent();
      k.g(paramBundle, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a((Intent)localObject1, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, (Intent)localObject1);
      paramContext = c.rxi;
      paramContext = paramCaptureVideoNormalModel.dvk();
      k.g(paramContext, "model.reportInfo");
      c.a(paramContext);
      AppMethodBeat.o(167503);
      return;
      localObject2 = paramCaptureVideoNormalModel.dvj();
      k.g(localObject2, "model.photo");
      if (!((Boolean)localObject2).booleanValue()) {
        break;
      }
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.auN());
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
    }
    if (paramBundle.getByteArray("video_composition") != null)
    {
      ((Intent)localObject1).putExtra("video_composition", paramBundle.getByteArray("video_composition"));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.ab(new String[] { paramCaptureVideoNormalModel.auN() }));
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("postType", 4);
      break;
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.getVideoPath());
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
    }
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(167504);
    k.h(paramContext, "context");
    k.h(paramBundle, "extData");
    k.h(parama, "finishController");
    AppMethodBeat.o(167504);
    return false;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(203284);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203284);
      return;
      if (paramInt2 == 0)
      {
        ac.i("Finder.FinderPostRouterUI", "record cancel");
        if (paramIntent != null)
        {
          paramIntent = (RecordMediaReportInfo)paramIntent.getParcelableExtra("report");
          if (paramIntent != null)
          {
            c localc = c.rxi;
            c.a(paramIntent);
          }
        }
        paramIntent = c.rxi;
        c.DS(1);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167499);
    super.onCreate(paramBundle);
    this.rJK = getIntent().getIntExtra("key_finder_post_router", -1);
    Object localObject = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      paramBundle = new StringBuilder();
      k.g(g.agP(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.a.afE() + '_' + bs.eWj();
    }
    this.postId = paramBundle;
    paramBundle = c.rxi;
    c.adN(this.postId);
    ac.i("Finder.FinderPostRouterUI", "router " + this.rJK);
    switch (this.rJK)
    {
    default: 
      ac.i("Finder.FinderPostRouterUI", "invalid router " + this.rJK + ", finish");
      finish();
      AppMethodBeat.o(167499);
      return;
    case 1: 
      paramBundle = new Intent();
      paramBundle.putExtra("finder_username", u.axE());
      paramBundle.addFlags(67108864);
      localObject = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a((Context)this, paramBundle, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramBundle);
      finish();
      AppMethodBeat.o(167499);
      return;
    case 3: 
      paramBundle = new Intent();
      paramBundle.putExtra("key_finder_post_id", this.postId);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      localObject = getIntent();
      k.g(localObject, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a(paramBundle, (Intent)localObject);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.F((Context)this, paramBundle);
      paramBundle = c.rxi;
      c.DR(1);
      AppMethodBeat.o(167499);
      return;
    case 2: 
      this.rJM = true;
      ari();
      paramBundle = c.rxi;
      c.DR(2);
      AppMethodBeat.o(167499);
      return;
    case 4: 
      paramBundle = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.A((Context)this, getIntent());
      AppMethodBeat.o(167499);
      return;
    }
    finish();
    AppMethodBeat.o(167499);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(167506);
    k.h(paramArrayOfString, "permissions");
    k.h(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfString = Thread.currentThread();
      k.g(paramArrayOfString, "Thread.currentThread()");
      ac.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(167506);
      return;
    }
    i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    k.g(paramArrayOfString, "Thread.currentThread()");
    ac.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(paramArrayOfString.getId()) });
    switch (paramInt)
    {
    }
    label260:
    label263:
    for (;;)
    {
      AppMethodBeat.o(167506);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        label186:
        if (paramInt != 0) {
          break label219;
        }
      }
      label219:
      for (paramInt = j; (paramInt != 0) && (paramArrayOfInt[0] == 0); paramInt = 0)
      {
        ari();
        AppMethodBeat.o(167506);
        return;
        paramInt = 0;
        break label186;
      }
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        label231:
        if (paramInt != 0) {
          break label260;
        }
      }
      for (paramInt = k;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label263;
        }
        ari();
        break;
        paramInt = 0;
        break label231;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167500);
    super.onResume();
    ac.i("Finder.FinderPostRouterUI", "onResume");
    if (this.rJL)
    {
      finish();
      if (this.rJM) {
        overridePendingTransition(0, 2130772138);
      }
    }
    AppMethodBeat.o(167500);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(167501);
    super.onStop();
    ac.i("Finder.FinderPostRouterUI", "onStop");
    this.rJL = true;
    AppMethodBeat.o(167501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostRouterUI
 * JD-Core Version:    0.7.0.1
 */