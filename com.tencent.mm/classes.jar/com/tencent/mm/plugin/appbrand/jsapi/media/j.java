package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.l.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.ba.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiEditImage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "REQUEST_CODE", "", "getREQUEST_CODE$annotations", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
{
  private static final int CTRL_INDEX = 1071;
  private static final String NAME = "editImage";
  public static final j.a sgO;
  private final int REQUEST_CODE;
  
  static
  {
    AppMethodBeat.i(329286);
    sgO = new j.a((byte)0);
    AppMethodBeat.o(329286);
  }
  
  public j()
  {
    AppMethodBeat.i(329283);
    this.REQUEST_CODE = com.tencent.luggage.sdk.h.a.ce(this);
    AppMethodBeat.o(329283);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/media/JsApiEditImage$invoke$1", "Lcom/tencent/mm/plugin/appbrand/utils/IPathResolveListener;", "onPathResolve", "", "resolvedPath", "", "isPathCreated", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.appbrand.utils.w
  {
    b(String paramString, g paramg, int paramInt, j paramj) {}
    
    private static final void a(Activity paramActivity, String paramString, j paramj, g paramg, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(329276);
      s.u(paramj, "this$0");
      e.bt((Context)paramActivity).b(new j.b..ExternalSyntheticLambda0(paramj, paramg, paramInt, paramBoolean, paramString));
      paramg = ah.v(new u(b.bmx(), "microMsg." + System.currentTimeMillis() + ".jpg").jKT());
      s.s(paramg, "VFSFile(CConstants.DATAR…            .absolutePath");
      Log.i("MicroMsg.AppBrand.JsApiEditImage", s.X("onPathResolve, tempOutputPath: ", paramg));
      paramString = RecordConfigProvider.lj(paramString, paramg);
      paramString.scene = 9;
      paramString.NIc = false;
      paramString.NHR = new UICustomParam.a().aQw().aQv().eL(true).lZB;
      paramg = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      paramActivity = (Context)paramActivity;
      paramInt = j.a(paramj);
      int i = ba.a.sight_slide_bottom_in;
      paramj = com.tencent.mm.plugin.recordvideo.jumper.a.a((Activity)paramActivity, "com.tencent.mm.plugin.recordvideo.activity.MMRecordUI", 1);
      if (paramj != null)
      {
        paramj.putExtra("KEY_PARAMS_CONFIG", paramString);
        paramj.putExtra("KEY_PARAMS_EXIT_ANIM", -1);
        paramj.putExtra("KEY_PARAMS_SELECTED_BIZ_INT", 1);
        paramj.putExtra("KEY_PARAMS_TO_WHERE", 1);
        Log.i("MicroMsg.VideoCaptureJumper", "configProvider: %s", new Object[] { paramString });
        com.tencent.mm.hellhoundlib.a.a.a((Activity)paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramj).aYi(), "com/tencent/mm/plugin/recordvideo/jumper/VideoCaptureJumper", "jumpToCaptureViewForResult", "(Landroid/content/Context;IIILcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;II)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        com.tencent.mm.plugin.recordvideo.jumper.a.l(paramActivity, i, -1);
      }
      AppMethodBeat.o(329276);
    }
    
    private static final boolean a(j paramj, g paramg, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3, Intent paramIntent)
    {
      AppMethodBeat.i(329271);
      s.u(paramj, "this$0");
      Log.i("MicroMsg.AppBrand.JsApiEditImage", "onResult, requestCode: " + paramInt2 + ", resultCode: " + paramInt3);
      if (j.a(paramj) != paramInt2)
      {
        AppMethodBeat.o(329271);
        return false;
      }
      if (-1 != paramInt3)
      {
        paramg.callback(paramInt1, paramj.a(null, a.e.rVu, null));
        AppMethodBeat.o(329271);
        return true;
      }
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      if (paramIntent == null)
      {
        Log.w("MicroMsg.AppBrand.JsApiEditImage", "onResult, editResultModel is null");
        paramg.callback(paramInt1, paramj.a(null, a.e.rVx, null));
        AppMethodBeat.o(329271);
        return true;
      }
      paramIntent = paramIntent.thumbPath;
      Log.i("MicroMsg.AppBrand.JsApiEditImage", s.X("onResult, outputPath: ", paramIntent));
      Object localObject = (CharSequence)paramIntent;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (paramInt2 = 1; (paramInt2 != 0) || (!new u(paramIntent).jKS()); paramInt2 = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiEditImage", "onResult, outputPath is not exist");
        paramg.callback(paramInt1, paramj.a(null, a.e.rVx, null));
        AppMethodBeat.o(329271);
        return true;
      }
      localObject = new k();
      com.tencent.mm.plugin.appbrand.appstorage.w localw = paramg.getFileSystem();
      if (localw != null) {
        localw.a(new u(paramIntent), y.alV(paramIntent), true, (k)localObject);
      }
      paramIntent = (String)((k)localObject).value;
      Log.i("MicroMsg.AppBrand.JsApiEditImage", s.X("onResult, callbackTempPath: ", paramIntent));
      localObject = (CharSequence)paramIntent;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (paramInt2 = 1; paramInt2 != 0; paramInt2 = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiEditImage", "onResult, callbackTempPath is not exist");
        paramg.callback(paramInt1, paramj.a(null, a.e.rVx, null));
        AppMethodBeat.o(329271);
        return true;
      }
      localObject = a.e.rVt;
      s.s(paramIntent, "callbackTempPath");
      paramg.callback(paramInt1, paramj.a(null, (a.d)localObject, (Map)ak.g(new r[] { v.Y("tempFilePath", paramIntent) })));
      if (paramBoolean)
      {
        Log.i("MicroMsg.AppBrand.JsApiEditImage", "onResult, delete created resolved file");
        new u(paramString).diJ();
      }
      AppMethodBeat.o(329271);
      return true;
    }
    
    public final void aA(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(329280);
      Log.i("MicroMsg.AppBrand.JsApiEditImage", "onPathResolve, imageUrl: " + this.sgP + ", resolvedPath: " + paramString + ", isPathCreated: " + paramBoolean);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; (i != 0) || (!new u(paramString).jKS()); i = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiEditImage", "onPathResolve, resolvedPath is not exist");
        this.rCg.callback(this.rxe, this.sgQ.a("Parse imageUrl fail, maybe imageUrl is illegal?", a.e.rVz, null));
        AppMethodBeat.o(329280);
        return;
      }
      localObject = AndroidContextUtil.castActivityOrNull(this.rCg.getRuntime().mContext);
      if (localObject == null)
      {
        Log.w("MicroMsg.AppBrand.JsApiEditImage", "onPathResolve, hostActivity is null");
        this.rCg.callback(this.rxe, this.sgQ.a(null, a.e.rVx, null));
        AppMethodBeat.o(329280);
        return;
      }
      this.rCg.V(new j.b..ExternalSyntheticLambda1((Activity)localObject, paramString, this.sgQ, this.rCg, this.rxe, paramBoolean));
      AppMethodBeat.o(329280);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.j
 * JD-Core Version:    0.7.0.1
 */