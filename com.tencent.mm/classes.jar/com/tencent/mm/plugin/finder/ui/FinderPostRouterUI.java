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
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.a.j;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(7)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderPostRouterUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "fromRecordUI", "", "hasStopped", "postId", "", "router", "", "getLayoutId", "goRouter", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFinishBtnClick", "context", "Landroid/content/Context;", "extData", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "takePhoto", "Companion", "plugin-finder_release"})
public final class FinderPostRouterUI
  extends MMFinderUI
  implements CaptureDataManager.b
{
  public static final FinderPostRouterUI.a KYP;
  private boolean KYO;
  private HashMap _$_findViewCache;
  private String postId = "";
  private int qOw = -1;
  private boolean qOx;
  
  static
  {
    AppMethodBeat.i(199314);
    KYP = new FinderPostRouterUI.a((byte)0);
    AppMethodBeat.o(199314);
  }
  
  private void akm()
  {
    AppMethodBeat.i(167502);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    localObject1 = com.tencent.mm.plugin.finder.storage.b.coB();
    ad.i("Finder.FinderPostRouterUI", "videoParams ".concat(String.valueOf(localObject1)));
    Object localObject2 = com.tencent.mm.plugin.finder.utils.k.qTp;
    localObject1 = RecordConfigProvider.a(com.tencent.mm.plugin.finder.utils.k.crZ(), "", (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 11);
    ((RecordConfigProvider)localObject1).vhP = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).vif.vij = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwZ, true);
    ((RecordConfigProvider)localObject1).vif.vil = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxa, -1);
    ((RecordConfigProvider)localObject1).vif.vim = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxb, -1);
    ((RecordConfigProvider)localObject1).vif.vin = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxc, -1);
    ((RecordConfigProvider)localObject1).vif.vio = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxd, -1);
    ((RecordConfigProvider)localObject1).vif.vip = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxe, -1);
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).Yc();
    ((UICustomParam.a)localObject2).Ya();
    ((UICustomParam.a)localObject2).XZ();
    ((UICustomParam.a)localObject2).XY();
    ((UICustomParam.a)localObject2).cO(false);
    ((UICustomParam.a)localObject2).Yb();
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.k.g(localAppCompatActivity, "context");
    ((UICustomParam.a)localObject2).li(localAppCompatActivity.getResources().getColor(2131100725));
    ((RecordConfigProvider)localObject1).vhI = ((UICustomParam.a)localObject2).Yd();
    ((RecordConfigProvider)localObject1).vhJ = h.e.BVs;
    ((RecordConfigProvider)localObject1).hsl = new Bundle();
    ((RecordConfigProvider)localObject1).hsl.putString("post_id", this.postId);
    ((RecordConfigProvider)localObject1).bx(4, MultiVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject1).bx(1, MultiVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject1).bx(3, MultiVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject1).bx(0, FinderRecordPluginLayout.class.getName());
    localObject2 = g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    if (((e)localObject2).afk().getInt(ae.a.LBq, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((RecordConfigProvider)localObject1).bx(0, DevFinderRecordPluginLayout.class.getName());
      }
      CaptureDataManager.vhw.a((CaptureDataManager.b)this);
      localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
      AppMethodBeat.o(167502);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199315);
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
    AppMethodBeat.o(199315);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(167503);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramCaptureVideoNormalModel, "model");
    d.g.b.k.h(paramBundle, "extData");
    ad.i("Finder.FinderPostRouterUI", "onMediaGenerated");
    this.KYO = false;
    Object localObject1 = new boj();
    ((boj)localObject1).DLK = true;
    ((boj)localObject1).DLJ = false;
    localObject1 = new Intent();
    Object localObject2 = (Collection)paramCaptureVideoNormalModel.fYa();
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)new ArrayList((Collection)paramCaptureVideoNormalModel.fYa()));
      paramBundle = paramCaptureVideoNormalModel.fYa();
      d.g.b.k.g(paramBundle, "model.multiImagePath");
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
      ((Intent)localObject1).putExtra("edit_id", (String)paramCaptureVideoNormalModel.dhD().w("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      paramBundle = com.tencent.mm.plugin.finder.utils.a.qSb;
      paramBundle = getIntent();
      d.g.b.k.g(paramBundle, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a((Intent)localObject1, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, (Intent)localObject1);
      paramContext = com.tencent.mm.plugin.finder.report.a.qFo;
      paramContext = paramCaptureVideoNormalModel.dhD();
      d.g.b.k.g(paramContext, "model.reportInfo");
      com.tencent.mm.plugin.finder.report.a.b(paramContext);
      AppMethodBeat.o(167503);
      return;
      localObject2 = paramCaptureVideoNormalModel.dhC();
      d.g.b.k.g(localObject2, "model.photo");
      if (!((Boolean)localObject2).booleanValue()) {
        break;
      }
      paramBundle = new ArrayList();
      paramBundle.add(paramCaptureVideoNormalModel.anX());
      ((Intent)localObject1).putExtra("postType", 2);
      ((Intent)localObject1).putExtra("postMediaList", (Serializable)paramBundle);
    }
    if (paramBundle.getByteArray("video_composition") != null)
    {
      ((Intent)localObject1).putExtra("video_composition", paramBundle.getByteArray("video_composition"));
      ((Intent)localObject1).putExtra("postThumbList", (Serializable)j.Z(new String[] { paramCaptureVideoNormalModel.anX() }));
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
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramBundle, "extData");
    d.g.b.k.h(parama, "finishController");
    AppMethodBeat.o(167504);
    return false;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(199313);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199313);
      return;
      if (paramInt2 == 0)
      {
        ad.i("Finder.FinderPostRouterUI", "record cancel");
        if (paramIntent != null)
        {
          paramIntent = (RecordMediaReportInfo)paramIntent.getParcelableExtra("report");
          if (paramIntent != null)
          {
            com.tencent.mm.plugin.finder.report.a locala = com.tencent.mm.plugin.finder.report.a.qFo;
            com.tencent.mm.plugin.finder.report.a.b(paramIntent);
          }
        }
        paramIntent = com.tencent.mm.plugin.finder.report.a.qFo;
        com.tencent.mm.plugin.finder.report.a.CL(1);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167499);
    super.onCreate(paramBundle);
    this.qOw = getIntent().getIntExtra("key_finder_post_router", -1);
    Object localObject = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      paramBundle = new StringBuilder();
      d.g.b.k.g(g.afz(), "MMKernel.account()");
      paramBundle = com.tencent.mm.kernel.a.aeo() + '_' + bt.eGO();
    }
    this.postId = paramBundle;
    paramBundle = com.tencent.mm.plugin.finder.report.a.qFo;
    com.tencent.mm.plugin.finder.report.a.aVu(this.postId);
    ad.i("Finder.FinderPostRouterUI", "router " + this.qOw);
    switch (this.qOw)
    {
    default: 
      ad.i("Finder.FinderPostRouterUI", "invalid router " + this.qOw + ", finish");
      finish();
      AppMethodBeat.o(167499);
      return;
    case 1: 
      paramBundle = new Intent();
      paramBundle.putExtra("finder_username", u.aqO());
      paramBundle.addFlags(67108864);
      localObject = FinderReporterUIC.Ljl;
      FinderReporterUIC.a.a((Context)this, paramBundle, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramBundle);
      finish();
      AppMethodBeat.o(167499);
      return;
    case 3: 
      paramBundle = new Intent();
      paramBundle.putExtra("key_finder_post_id", this.postId);
      localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      localObject = getIntent();
      d.g.b.k.g(localObject, "getIntent()");
      com.tencent.mm.plugin.finder.utils.a.a(paramBundle, (Intent)localObject);
      localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.C((Context)this, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.report.a.qFo;
      com.tencent.mm.plugin.finder.report.a.CK(1);
      AppMethodBeat.o(167499);
      return;
    case 2: 
      this.KYO = true;
      akm();
      paramBundle = com.tencent.mm.plugin.finder.report.a.qFo;
      com.tencent.mm.plugin.finder.report.a.CK(2);
      AppMethodBeat.o(167499);
      return;
    case 4: 
      paramBundle = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.y((Context)this, getIntent());
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
    d.g.b.k.h(paramArrayOfString, "permissions");
    d.g.b.k.h(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfString = Thread.currentThread();
      d.g.b.k.g(paramArrayOfString, "Thread.currentThread()");
      ad.i("Finder.FinderPostRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(167506);
      return;
    }
    i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    d.g.b.k.g(paramArrayOfString, "Thread.currentThread()");
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
        akm();
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
        akm();
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
    if (this.qOx)
    {
      finish();
      if (this.KYO) {
        overridePendingTransition(0, 2130772138);
      }
    }
    AppMethodBeat.o(167500);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(167501);
    super.onStop();
    ad.i("Finder.FinderPostRouterUI", "onStop");
    this.qOx = true;
    AppMethodBeat.o(167501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostRouterUI
 * JD-Core Version:    0.7.0.1
 */