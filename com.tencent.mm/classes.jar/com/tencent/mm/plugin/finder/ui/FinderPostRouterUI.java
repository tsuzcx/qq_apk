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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.plugin.finder.video.develop.DevFinderRecordPluginLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.plugin.vlog.ui.plugin.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import d.a.j;
import d.g.b.p;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "fromRecordUI", "", "hasStopped", "postId", "", "router", "", "getLayoutId", "goRouter", "", "gotoMediaEdit", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "context", "Landroid/content/Context;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "takePhoto", "Companion", "plugin-finder_release"})
public final class FinderPostRouterUI
  extends MMFinderUI
  implements CaptureDataManager.b
{
  public static final a sEN;
  private HashMap _$_findViewCache;
  private String postId = "";
  private int sEK = -1;
  private boolean sEL;
  private boolean sEM;
  
  static
  {
    AppMethodBeat.i(204086);
    sEN = new a((byte)0);
    AppMethodBeat.o(204086);
  }
  
  private void atV()
  {
    AppMethodBeat.i(167502);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    localObject1 = com.tencent.mm.plugin.finder.storage.b.cEX();
    Object localObject2 = d.BNj;
    if (d.etr()) {
      ((VideoTransPara)localObject1).height = ((int)(((VideoTransPara)localObject1).width / 0.75F));
    }
    ad.i("Finder.FinderPostRouterUI", "videoParams ".concat(String.valueOf(localObject1)));
    localObject2 = r.sNc;
    localObject1 = RecordConfigProvider.a(r.cLL(), "", (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 11);
    ((RecordConfigProvider)localObject1).xyr = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).xyG.xyK = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGN, true);
    ((RecordConfigProvider)localObject1).xyG.xyM = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGO, -1);
    ((RecordConfigProvider)localObject1).xyG.xyN = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGP, -1);
    ((RecordConfigProvider)localObject1).xyG.xyO = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGQ, -1);
    ((RecordConfigProvider)localObject1).xyG.xyP = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGR, -1);
    ((RecordConfigProvider)localObject1).xyG.xyQ = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGS, -1);
    localObject2 = new UICustomParam.a();
    Object localObject3 = d.BNj;
    if (d.etr())
    {
      ((UICustomParam.a)localObject2).ah(0.75F);
      ((UICustomParam.a)localObject2).aby();
      ((UICustomParam.a)localObject2).abx();
      ((UICustomParam.a)localObject2).abw();
      ((UICustomParam.a)localObject2).cP(false);
      ((UICustomParam.a)localObject2).abz();
      localObject3 = getContext();
      p.g(localObject3, "context");
      ((UICustomParam.a)localObject2).lB(((AppCompatActivity)localObject3).getResources().getColor(2131100725));
      ((UICustomParam.a)localObject2).a(2131231368, 0, "", 0);
      ((RecordConfigProvider)localObject1).xyk = ((UICustomParam.a)localObject2).abA();
      ((RecordConfigProvider)localObject1).xyl = i.e.ESO;
      ((RecordConfigProvider)localObject1).ime = new Bundle();
      ((RecordConfigProvider)localObject1).ime.putString("post_id", this.postId);
      ((RecordConfigProvider)localObject1).D(4, MultiVideoPluginLayout.class.getName());
      ((RecordConfigProvider)localObject1).D(1, MultiVideoPluginLayout.class.getName());
      ((RecordConfigProvider)localObject1).D(3, MultiVideoPluginLayout.class.getName());
      ((RecordConfigProvider)localObject1).D(0, FinderRecordPluginLayout.class.getName());
      localObject2 = g.ajC();
      p.g(localObject2, "MMKernel.storage()");
      if (((e)localObject2).ajl().getInt(al.a.IIE, 0) != 1) {
        break label495;
      }
    }
    label495:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((RecordConfigProvider)localObject1).D(0, DevFinderRecordPluginLayout.class.getName());
      }
      CaptureDataManager.xxY.a((CaptureDataManager.b)this);
      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
      AppMethodBeat.o(167502);
      return;
      ((UICustomParam.a)localObject2).ah(0.8571429F);
      break;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204087);
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
    AppMethodBeat.o(204087);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(167503);
    p.h(paramContext, "context");
    p.h(paramCaptureVideoNormalModel, "model");
    p.h(paramBundle, "extData");
    ad.i("Finder.FinderPostRouterUI", "onMediaGenerated");
    this.sEM = false;
    Object localObject1 = new bxm();
    ((bxm)localObject1).GRA = true;
    ((bxm)localObject1).GRz = false;
    localObject1 = new Intent();
    ArrayList localArrayList = (ArrayList)paramCaptureVideoNormalModel.dFF().v("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
    Object localObject2 = (Collection)paramCaptureVideoNormalModel.dFG();
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        ((Intent)localObject1).putExtra("postType", 2);
        ((Intent)localObject1).putExtra("postMediaList", (Serializable)new ArrayList((Collection)paramCaptureVideoNormalModel.dFG()));
        paramBundle = paramCaptureVideoNormalModel.dFG();
        p.g(paramBundle, "model.multiImagePath");
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
        if ((localArrayList != null) && (localArrayList.size() == paramCaptureVideoNormalModel.dFG().size())) {
          ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("KEY_POST_FROM_CAMERA", true);
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)paramCaptureVideoNormalModel.dFF().v("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramBundle = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramBundle = getIntent();
      p.g(paramBundle, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a((Intent)localObject1, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, (Intent)localObject1);
      paramContext = f.soC;
      paramContext = paramCaptureVideoNormalModel.dFF();
      p.g(paramContext, "model.reportInfo");
      f.a(paramContext);
      AppMethodBeat.o(167503);
      return;
      localObject2 = paramCaptureVideoNormalModel.dFE();
      p.g(localObject2, "model.photo");
      if (!((Boolean)localObject2).booleanValue()) {
        break;
      }
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.axA());
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
    }
    if (paramBundle.getByteArray("video_composition") != null)
    {
      ((Intent)localObject1).putExtra("video_composition", paramBundle.getByteArray("video_composition"));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.ac(new String[] { paramCaptureVideoNormalModel.axA() }));
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
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(204084);
    p.h(paramRecordMediaReportInfo, "reportInfo");
    p.h(paramBundle, "extData");
    paramBundle = f.soC;
    f.b(paramRecordMediaReportInfo);
    AppMethodBeat.o(204084);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(167504);
    p.h(paramContext, "context");
    p.h(paramBundle, "extData");
    p.h(parama, "finishController");
    AppMethodBeat.o(167504);
    return false;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(204085);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204085);
      return;
      if (paramInt2 == 0)
      {
        ad.i("Finder.FinderPostRouterUI", "record cancel");
        if (paramIntent != null)
        {
          paramIntent = (RecordMediaReportInfo)paramIntent.getParcelableExtra("report");
          if (paramIntent != null)
          {
            localObject = f.soC;
            f.a(paramIntent);
          }
        }
        paramIntent = f.soC;
        f.EW(1);
      }
      finish();
      AppMethodBeat.o(204085);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(204085);
        return;
      }
      if (paramIntent == null) {
        p.gfZ();
      }
      Object localObject = paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      p.g(localObject, "data!!.getParcelableExtr…mageUI.KSEGMENTMEDIAINFO)");
      CaptureDataManager.CaptureVideoNormalModel localCaptureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel)localObject;
      localObject = new Intent();
      paramIntent = paramIntent.getBundleExtra("key_extra_data").getByteArray("video_composition");
      if (paramIntent != null) {
        ((Intent)localObject).putExtra("video_composition", paramIntent);
      }
      ((Intent)localObject).putExtra("postType", 4);
      ((Intent)localObject).putExtra("postMediaList", (Serializable)j.ac(new String[] { localCaptureVideoNormalModel.getVideoPath() }));
      ((Intent)localObject).putExtra("postTypeList", (Serializable)j.ac(new Integer[] { Integer.valueOf(4) }));
      ((Intent)localObject).putExtra("postThumbList", (Serializable)j.ac(new String[] { localCaptureVideoNormalModel.axA() }));
      ((Intent)localObject).putExtra("post_id", this.postId);
      ((Intent)localObject).putExtra("edit_id", (String)localCaptureVideoNormalModel.dFF().v("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramIntent = f.soC;
      f.ai(4, false);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramIntent = getIntent();
      p.g(paramIntent, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a((Intent)localObject, paramIntent);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, (Intent)localObject);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167499);
    super.onCreate(paramBundle);
    this.sEK = getIntent().getIntExtra("key_finder_post_router", -1);
    Object localObject = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      paramBundle = new StringBuilder();
      p.g(g.ajA(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.a.aiq() + '_' + bt.flT();
    }
    this.postId = paramBundle;
    paramBundle = f.soC;
    f.ahM(this.postId);
    ad.i("Finder.FinderPostRouterUI", "router " + this.sEK);
    switch (this.sEK)
    {
    default: 
      ad.i("Finder.FinderPostRouterUI", "invalid router " + this.sEK + ", finish");
      finish();
      AppMethodBeat.o(167499);
      return;
    case 1: 
      paramBundle = new Intent();
      paramBundle.putExtra("finder_username", u.aAu());
      paramBundle.addFlags(67108864);
      localObject = FinderReporterUIC.tcM;
      FinderReporterUIC.a.a((Context)this, paramBundle, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramBundle);
      finish();
      AppMethodBeat.o(167499);
      return;
    case 3: 
      paramBundle = new Intent();
      paramBundle.putExtra("key_finder_post_id", this.postId);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      localObject = getIntent();
      p.g(localObject, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a(paramBundle, (Intent)localObject);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.G((Context)this, paramBundle);
      paramBundle = f.soC;
      f.EV(1);
      AppMethodBeat.o(167499);
      return;
    case 2: 
      this.sEM = true;
      atV();
      paramBundle = f.soC;
      f.EV(2);
      AppMethodBeat.o(167499);
      return;
    case 4: 
      paramBundle = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.B((Context)this, getIntent());
      AppMethodBeat.o(167499);
      return;
    case 5: 
      finish();
      AppMethodBeat.o(167499);
      return;
    }
    paramBundle = com.tencent.mm.plugin.finder.utils.a.sKD;
    paramBundle = (Context)this;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_comment_scene", 41);
    com.tencent.mm.plugin.finder.utils.a.W(paramBundle, (Intent)localObject);
    overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
    AppMethodBeat.o(167499);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204083);
    CaptureDataManager.xxY.a(null);
    super.onDestroy();
    AppMethodBeat.o(204083);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(167506);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfString = Thread.currentThread();
      p.g(paramArrayOfString, "Thread.currentThread()");
      ad.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(167506);
      return;
    }
    i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    p.g(paramArrayOfString, "Thread.currentThread()");
    ad.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(paramArrayOfString.getId()) });
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
        atV();
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
        atV();
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
    ad.i("Finder.FinderPostRouterUI", "onResume");
    if (this.sEL)
    {
      finish();
      if (this.sEM) {
        overridePendingTransition(0, 2130772138);
      }
      if (this.sEK == 6) {
        overridePendingTransition(MMFragmentActivity.a.mOg, MMFragmentActivity.a.mOh);
      }
    }
    AppMethodBeat.o(167500);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(167501);
    super.onStop();
    ad.i("Finder.FinderPostRouterUI", "onStop");
    this.sEL = true;
    AppMethodBeat.o(167501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI$Companion;", "", "()V", "REQUEST_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostRouterUI
 * JD-Core Version:    0.7.0.1
 */