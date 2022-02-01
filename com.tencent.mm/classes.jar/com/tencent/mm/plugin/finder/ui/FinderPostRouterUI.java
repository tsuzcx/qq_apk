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
import com.tencent.mm.model.v;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "fromRecordUI", "", "hasStopped", "postId", "", "router", "", "getLayoutId", "goRouter", "", "gotoMediaEdit", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "forward", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "onFinishBtnClick", "context", "Landroid/content/Context;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "takePhoto", "Companion", "plugin-finder_release"})
public final class FinderPostRouterUI
  extends MMFinderUI
  implements CaptureDataManager.b
{
  public static final FinderPostRouterUI.a sPM;
  private HashMap _$_findViewCache;
  private String postId = "";
  private int sPJ = -1;
  private boolean sPK;
  private boolean sPL;
  
  static
  {
    AppMethodBeat.i(204682);
    sPM = new FinderPostRouterUI.a((byte)0);
    AppMethodBeat.o(204682);
  }
  
  private void auk()
  {
    AppMethodBeat.i(167502);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    localObject1 = com.tencent.mm.plugin.finder.storage.b.cGT();
    Object localObject2 = d.CeI;
    if (d.ewY()) {
      ((VideoTransPara)localObject1).height = ((int)(((VideoTransPara)localObject1).width / 0.75F));
    }
    ae.i("Finder.FinderPostRouterUI", "videoParams ".concat(String.valueOf(localObject1)));
    localObject2 = r.sYn;
    localObject1 = RecordConfigProvider.a(r.cOt(), "", (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 11);
    ((RecordConfigProvider)localObject1).xOo = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).xOC.xOG = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOt, true);
    ((RecordConfigProvider)localObject1).xOC.xOI = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOu, -1);
    ((RecordConfigProvider)localObject1).xOC.xOJ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOv, -1);
    ((RecordConfigProvider)localObject1).xOC.xOK = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOw, -1);
    ((RecordConfigProvider)localObject1).xOC.xOL = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOx, -1);
    ((RecordConfigProvider)localObject1).xOC.xOM = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOy, -1);
    localObject2 = new UICustomParam.a();
    Object localObject3 = d.CeI;
    if (d.ewY())
    {
      ((UICustomParam.a)localObject2).ah(0.75F);
      ((UICustomParam.a)localObject2).abH();
      ((UICustomParam.a)localObject2).abG();
      ((UICustomParam.a)localObject2).abF();
      ((UICustomParam.a)localObject2).cP(false);
      ((UICustomParam.a)localObject2).abI();
      localObject3 = getContext();
      p.g(localObject3, "context");
      ((UICustomParam.a)localObject2).lD(((AppCompatActivity)localObject3).getResources().getColor(2131100725));
      ((UICustomParam.a)localObject2).a(2131231368, 0, "", 0);
      ((RecordConfigProvider)localObject1).xOh = ((UICustomParam.a)localObject2).abJ();
      ((RecordConfigProvider)localObject1).xOi = i.e.Flj;
      ((RecordConfigProvider)localObject1).ioY = new Bundle();
      ((RecordConfigProvider)localObject1).ioY.putString("post_id", this.postId);
      ((RecordConfigProvider)localObject1).D(4, MultiVideoPluginLayout.class.getName());
      ((RecordConfigProvider)localObject1).D(1, MultiVideoPluginLayout.class.getName());
      ((RecordConfigProvider)localObject1).D(3, MultiVideoPluginLayout.class.getName());
      ((RecordConfigProvider)localObject1).D(0, FinderRecordPluginLayout.class.getName());
      localObject2 = com.tencent.mm.kernel.g.ajR();
      p.g(localObject2, "MMKernel.storage()");
      if (((e)localObject2).ajA().getInt(am.a.Jdh, 0) != 1) {
        break label495;
      }
    }
    label495:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((RecordConfigProvider)localObject1).D(0, DevFinderRecordPluginLayout.class.getName());
      }
      CaptureDataManager.xNV.a((CaptureDataManager.b)this);
      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
      AppMethodBeat.o(167502);
      return;
      ((UICustomParam.a)localObject2).ah(0.8571429F);
      break;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204683);
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
    AppMethodBeat.o(204683);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(167503);
    p.h(paramContext, "context");
    p.h(paramCaptureVideoNormalModel, "model");
    p.h(paramBundle, "extData");
    ae.i("Finder.FinderPostRouterUI", "onMediaGenerated");
    this.sPL = false;
    Object localObject1 = new byg();
    ((byg)localObject1).Hlb = true;
    ((byg)localObject1).Hla = false;
    localObject1 = new Intent();
    ArrayList localArrayList = (ArrayList)paramCaptureVideoNormalModel.dIW().v("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
    Object localObject2 = (Collection)paramCaptureVideoNormalModel.dIX();
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        ((Intent)localObject1).putExtra("postType", 2);
        ((Intent)localObject1).putExtra("postMediaList", (Serializable)new ArrayList((Collection)paramCaptureVideoNormalModel.dIX()));
        paramBundle = paramCaptureVideoNormalModel.dIX();
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
        if ((localArrayList != null) && (localArrayList.size() == paramCaptureVideoNormalModel.dIX().size())) {
          ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("KEY_POST_FROM_CAMERA", true);
      ((Intent)localObject1).putExtra("post_id", this.postId);
      ((Intent)localObject1).putExtra("edit_id", (String)paramCaptureVideoNormalModel.dIW().v("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramBundle = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramBundle = getIntent();
      p.g(paramBundle, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a((Intent)localObject1, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, (Intent)localObject1);
      paramContext = com.tencent.mm.plugin.finder.report.g.syJ;
      paramContext = paramCaptureVideoNormalModel.dIW();
      p.g(paramContext, "model.reportInfo");
      com.tencent.mm.plugin.finder.report.g.a(paramContext);
      AppMethodBeat.o(167503);
      return;
      localObject2 = paramCaptureVideoNormalModel.dIV();
      p.g(localObject2, "model.photo");
      if (!((Boolean)localObject2).booleanValue()) {
        break;
      }
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.axP());
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        ((Intent)localObject1).putExtra("key_post_media_quality_list", (Serializable)localArrayList);
      }
    }
    if (paramBundle.getByteArray("video_composition") != null)
    {
      ((Intent)localObject1).putExtra("video_composition", paramBundle.getByteArray("video_composition"));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.ab(new String[] { paramCaptureVideoNormalModel.axP() }));
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
    AppMethodBeat.i(204680);
    p.h(paramRecordMediaReportInfo, "reportInfo");
    p.h(paramBundle, "extData");
    paramBundle = com.tencent.mm.plugin.finder.report.g.syJ;
    com.tencent.mm.plugin.finder.report.g.b(paramRecordMediaReportInfo);
    AppMethodBeat.o(204680);
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
    AppMethodBeat.i(204681);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204681);
      return;
      if (paramInt2 == 0)
      {
        ae.i("Finder.FinderPostRouterUI", "record cancel");
        if (paramIntent != null)
        {
          paramIntent = (RecordMediaReportInfo)paramIntent.getParcelableExtra("report");
          if (paramIntent != null)
          {
            localObject = com.tencent.mm.plugin.finder.report.g.syJ;
            com.tencent.mm.plugin.finder.report.g.a(paramIntent);
          }
        }
        paramIntent = com.tencent.mm.plugin.finder.report.g.syJ;
        com.tencent.mm.plugin.finder.report.g.Fs(1);
      }
      finish();
      AppMethodBeat.o(204681);
      return;
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(204681);
        return;
      }
      if (paramIntent == null) {
        p.gkB();
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
      ((Intent)localObject).putExtra("postMediaList", (Serializable)j.ab(new String[] { localCaptureVideoNormalModel.getVideoPath() }));
      ((Intent)localObject).putExtra("postTypeList", (Serializable)j.ab(new Integer[] { Integer.valueOf(4) }));
      ((Intent)localObject).putExtra("postThumbList", (Serializable)j.ab(new String[] { localCaptureVideoNormalModel.axP() }));
      ((Intent)localObject).putExtra("post_id", this.postId);
      ((Intent)localObject).putExtra("edit_id", (String)localCaptureVideoNormalModel.dIW().v("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramIntent = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.am(4, false);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramIntent = getIntent();
      p.g(paramIntent, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a((Intent)localObject, paramIntent);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)this, (Intent)localObject);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167499);
    super.onCreate(paramBundle);
    this.sPJ = getIntent().getIntExtra("key_finder_post_router", -1);
    Object localObject = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      paramBundle = new StringBuilder();
      p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.a.aiF() + '_' + bu.fpO();
    }
    this.postId = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.g.syJ;
    com.tencent.mm.plugin.finder.report.g.aiJ(this.postId);
    ae.i("Finder.FinderPostRouterUI", "router " + this.sPJ);
    switch (this.sPJ)
    {
    default: 
      ae.i("Finder.FinderPostRouterUI", "invalid router " + this.sPJ + ", finish");
      finish();
      AppMethodBeat.o(167499);
      return;
    case 1: 
      paramBundle = new Intent();
      paramBundle.putExtra("finder_username", v.aAK());
      paramBundle.addFlags(67108864);
      localObject = FinderReporterUIC.tnG;
      FinderReporterUIC.a.a((Context)this, paramBundle, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramBundle);
      finish();
      AppMethodBeat.o(167499);
      return;
    case 3: 
      paramBundle = new Intent();
      paramBundle.putExtra("key_finder_post_id", this.postId);
      localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
      localObject = getIntent();
      p.g(localObject, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a(paramBundle, (Intent)localObject);
      localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.G((Context)this, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.Fr(1);
      AppMethodBeat.o(167499);
      return;
    case 2: 
      this.sPL = true;
      auk();
      paramBundle = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.Fr(2);
      AppMethodBeat.o(167499);
      return;
    case 4: 
      paramBundle = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.B((Context)this, getIntent());
      AppMethodBeat.o(167499);
      return;
    case 5: 
      finish();
      AppMethodBeat.o(167499);
      return;
    }
    paramBundle = com.tencent.mm.plugin.finder.utils.a.sVQ;
    paramBundle = (Context)this;
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_comment_scene", 41);
    com.tencent.mm.plugin.finder.utils.a.W(paramBundle, (Intent)localObject);
    overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
    AppMethodBeat.o(167499);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204679);
    CaptureDataManager.xNV.a(null);
    super.onDestroy();
    AppMethodBeat.o(204679);
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
      ae.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(167506);
      return;
    }
    i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    p.g(paramArrayOfString, "Thread.currentThread()");
    ae.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(paramArrayOfString.getId()) });
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
        auk();
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
        auk();
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
    ae.i("Finder.FinderPostRouterUI", "onResume");
    if (this.sPK)
    {
      finish();
      if (this.sPL) {
        overridePendingTransition(0, 2130772138);
      }
      if (this.sPJ == 6) {
        overridePendingTransition(MMFragmentActivity.a.mTk, MMFragmentActivity.a.mTl);
      }
    }
    AppMethodBeat.o(167500);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(167501);
    super.onStop();
    ae.i("Finder.FinderPostRouterUI", "onStop");
    this.sPK = true;
    AppMethodBeat.o(167501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostRouterUI
 * JD-Core Version:    0.7.0.1
 */