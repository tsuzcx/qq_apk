package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.ce;
import com.tencent.mm.plugin.finder.model.ce.b;
import com.tencent.mm.plugin.finder.model.ce.g;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.DirectSendPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverHelper;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "coroutineViewModel", "Lcom/tencent/mm/plugin/finder/model/SetProfileCoverViewModel;", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;)V", "getString", "", "strResId", "", "jumpToCrop", "", "imgPath", "loadingProfileCover", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCropCoverCoroutine", "coverPath", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSelectCover", "isHasCover", "", "selectPhotoFromAlbum", "sendSetCoverEvent", "localPath", "extractColor", "sendUnSetCoverEvent", "showProfileSelectCoverSheet", "takePhoto", "isUseNew", "takePhotoAfterPermissionGranted", "takePhotoNew", "unsetProfileCover", "uploadProfileCover", "coverUrl", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a FTf;
  com.tencent.mm.plugin.findersdk.b.b DiB;
  final ce FTg;
  final MMActivity lzt;
  
  static
  {
    AppMethodBeat.i(346675);
    FTf = new f.a((byte)0);
    AppMethodBeat.o(346675);
  }
  
  public f(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(346539);
    this.lzt = paramMMActivity;
    this.FTg = new ce();
    AppMethodBeat.o(346539);
  }
  
  private static final void a(f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(346606);
    kotlin.g.b.s.u(paramf, "this$0");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(346606);
      return;
      paramf.ui(false);
      AppMethodBeat.o(346606);
      return;
      paramf.ui(true);
      AppMethodBeat.o(346606);
      return;
      paramMenuItem = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      if (!com.tencent.mm.plugin.findersdk.d.a.aDj("personalInfo"))
      {
        if (!h.baE().isSDCardAvailable())
        {
          com.tencent.mm.ui.base.aa.j((Context)paramf.lzt, null);
          AppMethodBeat.o(346606);
          return;
        }
        t.r((Activity)paramf.lzt, 2001);
        AppMethodBeat.o(346606);
        return;
        paramMenuItem = new g.a((Context)paramf.lzt);
        paramMenuItem.bDE(paramf.lzt.getResources().getString(e.h.finder_clear_pic_from_phone)).NF(true);
        paramMenuItem.c(new f..ExternalSyntheticLambda3(paramf));
        paramMenuItem.d(f..ExternalSyntheticLambda0.INSTANCE);
        paramMenuItem.show();
      }
    }
  }
  
  private static final void a(f paramf, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(346572);
    kotlin.g.b.s.u(paramf, "this$0");
    Log.i("Finder.SelectCoverHelper", kotlin.g.b.s.X("ITEM_ID_CLEAR_PHOTO bOk：", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      paramf.fbF();
      paramString = paramf.FTg;
      paramf = (ce.b)new d(paramf);
      kotlin.g.b.s.u(paramf, "action");
      e.launch$default((e)paramString, null, null, (m)new ce.g(paramString, paramf, null), 3, null);
      AppMethodBeat.o(346572);
      return;
    }
    Log.i("Finder.SelectCoverHelper", "ITEM_ID_CLEAR_PHOTO 取消");
    AppMethodBeat.o(346572);
  }
  
  private static final void a(boolean paramBoolean, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(346564);
    if (params.jmw())
    {
      params.oh(4000, e.h.finder_profile_select_cover_capture);
      params.oh(4001, e.h.finder_select_pic_from_phone);
      if (paramBoolean) {
        params.oh(4003, e.h.finder_clear_pic_from_phone);
      }
    }
    AppMethodBeat.o(346564);
  }
  
  private static final void q(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(346582);
    Log.i("Finder.SelectCoverHelper", "ITEM_ID_CLEAR_PHOTO dismiss");
    AppMethodBeat.o(346582);
  }
  
  private final boolean ui(boolean paramBoolean)
  {
    AppMethodBeat.i(346555);
    if (!h.baE().isSDCardAvailable())
    {
      com.tencent.mm.ui.base.aa.j((Context)this.lzt, null);
      AppMethodBeat.o(346555);
      return false;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.lzt, "android.permission.CAMERA", 16, "");
    Log.i("Finder.SelectCoverHelper", "checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this.lzt });
    if (!bool)
    {
      AppMethodBeat.o(346555);
      return false;
    }
    if (paramBoolean)
    {
      Object localObject1 = (CaptureDataManager.b)new c(this);
      Object localObject3 = com.tencent.mm.modelvideo.aa.PW(com.tencent.mm.plugin.auth.a.a.cUx());
      kotlin.g.b.s.s(localObject3, "genFileName(Account.username())");
      v.bOh();
      Object localObject2 = com.tencent.mm.modelvideo.aa.PX((String)localObject3);
      v.bOh();
      localObject3 = com.tencent.mm.modelvideo.aa.PY((String)localObject3);
      Object localObject4 = com.tencent.mm.plugin.sns.cover.b.a.QkS;
      localObject4 = com.tencent.mm.plugin.sns.cover.b.a.hev();
      com.tencent.mm.plugin.sns.cover.b.a locala = com.tencent.mm.plugin.sns.cover.b.a.QkS;
      localObject2 = RecordConfigProvider.a((String)localObject2, (String)localObject3, (VideoTransPara)localObject4, com.tencent.mm.plugin.sns.cover.b.a.hev().duration * 1000, 11);
      kotlin.g.b.s.s(localObject2, "getRecordMediaConfig(\n  …ne.SCENE_FINDER\n        )");
      localObject3 = new UICustomParam.a();
      ((UICustomParam.a)localObject3).aQw();
      ((UICustomParam.a)localObject3).aQv();
      ((UICustomParam.a)localObject3).eL(true);
      ((RecordConfigProvider)localObject2).NHR = ((UICustomParam.a)localObject3).lZB;
      ((RecordConfigProvider)localObject2).NHY = Boolean.FALSE;
      ((RecordConfigProvider)localObject2).NHW = Boolean.FALSE;
      ((RecordConfigProvider)localObject2).NIk = false;
      ((RecordConfigProvider)localObject2).NIl = false;
      ((RecordConfigProvider)localObject2).NIm = true;
      ((RecordConfigProvider)localObject2).NHU = Boolean.TRUE;
      ((RecordConfigProvider)localObject2).NHT = 4;
      ((RecordConfigProvider)localObject2).cD(1, DirectSendPhotoPluginLayout.class.getName());
      ((RecordConfigProvider)localObject2).cD(0, RecordPluginLayout.class.getName());
      CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)localObject1);
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this.lzt, 2000, e.a.sight_slide_bottom_in, e.a.sight_slide_bottom_out, (RecordConfigProvider)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(346555);
      return true;
      if (!t.d((Activity)this.lzt, com.tencent.mm.plugin.image.d.bzL(), "finderProfileCover." + System.currentTimeMillis() + ".jpg", 2003)) {
        Toast.makeText((Context)this.lzt, (CharSequence)getString(e.h.selectcameraapp_none), 1).show();
      }
    }
  }
  
  final void aBc(String paramString)
  {
    AppMethodBeat.i(346736);
    if ((!Util.isNullOrNil(paramString)) && (y.ZC(paramString)))
    {
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.c((Activity)this.lzt, paramString, "finder_profile_cover_" + System.currentTimeMillis() + ".tmp");
      AppMethodBeat.o(346736);
      return;
    }
    Log.w("Finder.SelectCoverHelper", "no img select");
    AppMethodBeat.o(346736);
  }
  
  final void fbF()
  {
    AppMethodBeat.i(346747);
    Object localObject = this.DiB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).end();
    }
    localObject = com.tencent.mm.plugin.findersdk.b.b.HcE;
    this.DiB = b.a.d((Context)this.lzt, this.lzt.getString(e.h.app_waiting), 300L);
    localObject = this.DiB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).begin();
    }
    AppMethodBeat.o(346747);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(346754);
    String str = this.lzt.getResources().getString(paramInt);
    kotlin.g.b.s.s(str, "context.resources.getString(strResId)");
    AppMethodBeat.o(346754);
    return str;
  }
  
  public final void uh(boolean paramBoolean)
  {
    AppMethodBeat.i(346727);
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)this.lzt, 1, false);
    localf.af(af.mU((Context)this.lzt).inflate(e.f.finder_sheet_select_profile_cover_header, null), true);
    localf.Vtg = new f..ExternalSyntheticLambda1(paramBoolean);
    localf.GAC = new f..ExternalSyntheticLambda2(this);
    localf.dDn();
    AppMethodBeat.o(346727);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSelectCoverHelper$onCropCoverCoroutine$1", "Lcom/tencent/mm/plugin/finder/model/SetProfileCoverViewModel$ISettingProfileCoverAction;", "onSetCover", "", "coverUrl", "", "extractColor", "", "retCode", "hintMsg", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ce.b
  {
    b(f paramf, String paramString) {}
    
    public final void l(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      AppMethodBeat.i(346952);
      kotlin.g.b.s.u(paramString1, "coverUrl");
      paramString1 = this.FTh.DiB;
      if (paramString1 != null) {
        paramString1.end();
      }
      String str = this.EDR;
      paramString1 = str;
      if (str == null) {
        paramString1 = "";
      }
      f.eS(paramString1, paramInt1);
      if (paramInt2 != 0)
      {
        if ((paramInt2 == -5000) && (!Util.isNullOrNil(paramString2))) {
          kotlin.g.b.s.checkNotNull(paramString2);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.aa.dc((Context)f.a(this.FTh), paramString2);
          AppMethodBeat.o(346952);
          return;
          paramString2 = f.a(this.FTh, e.h.finder_update_profile_cover_failed);
        }
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)f.b.a.FTi);
      com.tencent.mm.ui.base.aa.db((Context)f.a(this.FTh), f.a(this.FTh, e.h.finder_mod_unblock_success));
      AppMethodBeat.o(346952);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSelectCoverHelper$takePhotoNew$generateCallback$1", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$SimpleVideoGenerateCallback;", "onFinishBtnClick", "", "context", "Landroid/content/Context;", "extData", "Landroid/os/Bundle;", "finishController", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends CaptureDataManager.c
  {
    c(f paramf) {}
    
    public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
    {
      AppMethodBeat.i(346940);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramCaptureVideoNormalModel, "model");
      kotlin.g.b.s.u(paramBundle, "extData");
      f localf = this.FTh;
      paramBundle = paramCaptureVideoNormalModel.thumbPath;
      paramCaptureVideoNormalModel = paramBundle;
      if (paramBundle == null) {
        paramCaptureVideoNormalModel = "";
      }
      f.a(localf, paramCaptureVideoNormalModel);
      if ((paramContext instanceof Activity)) {}
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        if (paramContext != null)
        {
          paramContext.setResult(-1);
          paramContext.finish();
        }
        AppMethodBeat.o(346940);
        return;
      }
    }
    
    public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
    {
      AppMethodBeat.i(346946);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramBundle, "extData");
      kotlin.g.b.s.u(parama, "finishController");
      AppMethodBeat.o(346946);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSelectCoverHelper$unsetProfileCover$1", "Lcom/tencent/mm/plugin/finder/model/SetProfileCoverViewModel$ISettingProfileCoverAction;", "onSetCover", "", "coverUrl", "", "extractColor", "", "retCode", "hintMsg", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ce.b
  {
    d(f paramf) {}
    
    public final void l(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      AppMethodBeat.i(346942);
      kotlin.g.b.s.u(paramString1, "coverUrl");
      paramString1 = this.FTh.DiB;
      if (paramString1 != null) {
        paramString1.end();
      }
      if (paramInt2 != 0) {
        if ((paramInt2 == -5000) && (!Util.isNullOrNil(paramString2)))
        {
          kotlin.g.b.s.checkNotNull(paramString2);
          com.tencent.mm.ui.base.aa.dc((Context)f.a(this.FTh), paramString2);
        }
      }
      for (;;)
      {
        f.fbG();
        AppMethodBeat.o(346942);
        return;
        paramString2 = f.a(this.FTh, e.h.finder_update_profile_cover_failed);
        break;
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)f.d.a.FTj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f
 * JD-Core Version:    0.7.0.1
 */