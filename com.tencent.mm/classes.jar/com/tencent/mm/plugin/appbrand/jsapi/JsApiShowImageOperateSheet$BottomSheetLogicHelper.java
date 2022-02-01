package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.k.g;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Set;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper
{
  private static Set<Integer> oxj;
  private IPCQRCodeRecognizeResult oxk;
  private com.tencent.mm.ui.widget.a.e oxl;
  private final ah oxm;
  private final String oxn;
  private final String oxo;
  private final Rect oxp;
  ScanCodeSheetItemLogic oxq;
  
  static
  {
    AppMethodBeat.i(45700);
    HashSet localHashSet = new HashSet();
    oxj = localHashSet;
    localHashSet.add(Integer.valueOf(3));
    AppMethodBeat.o(45700);
  }
  
  public JsApiShowImageOperateSheet$BottomSheetLogicHelper(ah paramah, String paramString1, String paramString2, Rect paramRect)
  {
    AppMethodBeat.i(276472);
    this.oxm = paramah;
    this.oxn = paramString1;
    this.oxo = paramString2;
    this.oxp = paramRect;
    this.oxq = new ScanCodeSheetItemLogic(paramah.getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
      {
        AppMethodBeat.i(274942);
        if ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.this) != null) && (JsApiShowImageOperateSheet.BottomSheetLogicHelper.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.this).isShowing())) {
          JsApiShowImageOperateSheet.BottomSheetLogicHelper.this.bPQ();
        }
        AppMethodBeat.o(274942);
      }
    });
    AppMethodBeat.o(276472);
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(276476);
    Object localObject;
    String str1;
    String str2;
    if ((this.oxm != null) && (this.oxm.getRuntime() != null))
    {
      localObject = this.oxm.getRuntime().bDy();
      if (localObject != null)
      {
        str1 = ((AppBrandInitConfigLU)localObject).cwP;
        str2 = this.oxm.getAppId();
        if (((AppBrandInitConfigLU)localObject).cxf == null) {
          break label113;
        }
      }
    }
    label113:
    for (int i = ((AppBrandInitConfigLU)localObject).cxf.scene;; i = 0)
    {
      localObject = com.tencent.mm.plugin.scanner.a.IAB;
      com.tencent.mm.plugin.scanner.a.a(str1, i, str2, false, this.oxm.qoI, paramInt, paramString, paramBoolean1, paramBoolean2, this.oxm.oxe);
      AppMethodBeat.o(276476);
      return;
    }
  }
  
  private void a(e.a parama)
  {
    AppMethodBeat.i(45692);
    if (!Util.isNullOrNil(this.oxo))
    {
      Object localObject = this.oxm.getFileSystem().adN("showSheet_base64_" + System.currentTimeMillis());
      if (localObject == null)
      {
        Log.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
        AppMethodBeat.o(45692);
        return;
      }
      localObject = ((q)localObject).bOF();
      byte[] arrayOfByte = Base64.decode(this.oxo, 0);
      u.f((String)localObject, arrayOfByte, arrayOfByte.length);
      parama.dR((String)localObject);
      AppMethodBeat.o(45692);
      return;
    }
    com.tencent.mm.plugin.appbrand.utils.e.a(this.oxm, this.oxn, null, parama);
    AppMethodBeat.o(45692);
  }
  
  public final void bPQ()
  {
    AppMethodBeat.i(45691);
    boolean bool = g.aK(this.oxm.getContext());
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(281987);
        JsApiShowImageOperateSheet.BottomSheetLogicHelper.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.this);
        AppMethodBeat.o(281987);
      }
    };
    if (bool) {}
    for (int i = 100;; i = 0)
    {
      MMHandlerThread.postToMainThreadDelayed(local3, i);
      AppMethodBeat.o(45691);
      return;
    }
  }
  
  static final class IPCProcessQRCodeResultRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<IPCProcessQRCodeResultRequest> CREATOR;
    private String appID;
    private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult oxA;
    private String pageUrl;
    
    static
    {
      AppMethodBeat.i(45669);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45669);
    }
    
    protected IPCProcessQRCodeResultRequest() {}
    
    protected IPCProcessQRCodeResultRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(45667);
      this.oxA = ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult)paramParcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader()));
      this.appID = paramParcel.readString();
      this.pageUrl = paramParcel.readString();
      AppMethodBeat.o(45667);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bOe()
    {
      return JsApiShowImageOperateSheet.BottomSheetLogicHelper.b.class;
    }
    
    public final boolean bPn()
    {
      return true;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45668);
      paramParcel.writeParcelable(this.oxA, paramInt);
      paramParcel.writeString(this.appID);
      paramParcel.writeString(this.pageUrl);
      AppMethodBeat.o(45668);
    }
  }
  
  static final class IPCQRCodeRecognizeParam
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR;
    private String oxH;
    private String oxI;
    
    static
    {
      AppMethodBeat.i(45681);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45681);
    }
    
    protected IPCQRCodeRecognizeParam() {}
    
    protected IPCQRCodeRecognizeParam(Parcel paramParcel)
    {
      AppMethodBeat.i(45679);
      this.oxH = paramParcel.readString();
      this.oxI = paramParcel.readString();
      AppMethodBeat.o(45679);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45680);
      paramParcel.writeString(this.oxH);
      paramParcel.writeString(this.oxI);
      AppMethodBeat.o(45680);
    }
  }
  
  static final class IPCQRCodeRecognizeResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR;
    private String filePath;
    private int fys;
    private int fyt;
    private String result;
    
    static
    {
      AppMethodBeat.i(45685);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45685);
    }
    
    protected IPCQRCodeRecognizeResult() {}
    
    protected IPCQRCodeRecognizeResult(Parcel paramParcel)
    {
      AppMethodBeat.i(45683);
      this.result = paramParcel.readString();
      this.filePath = paramParcel.readString();
      this.fys = paramParcel.readInt();
      this.fyt = paramParcel.readInt();
      AppMethodBeat.o(45683);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45684);
      paramParcel.writeString(this.result);
      paramParcel.writeString(this.filePath);
      paramParcel.writeInt(this.fys);
      paramParcel.writeInt(this.fyt);
      AppMethodBeat.o(45684);
    }
  }
  
  static final class b
    extends AppBrandProxyUIProcessTask
  {
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(45670);
      if (!(paramProcessRequest instanceof JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest))
      {
        Log.e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
        AppMethodBeat.o(45670);
        return;
      }
      paramProcessRequest = (JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest)paramProcessRequest;
      cv localcv = new cv();
      localcv.fyr.activity = bPf();
      localcv.fyr.fwI = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localcv.fyr.fys = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localcv.fyr.fyt = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.c(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localcv.fyr.scene = 44;
      Bundle localBundle = new Bundle();
      localBundle.putInt("stat_scene", 6);
      localBundle.putString("stat_app_id", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.b(paramProcessRequest));
      localBundle.putString("stat_url", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.c(paramProcessRequest));
      localcv.fyr.fyw = localBundle;
      EventCenter.instance.publish(localcv);
      AppMethodBeat.o(45670);
    }
  }
  
  static final class c
    implements d<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult>
  {
    private boolean oxB = false;
    
    private void a(final JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam paramIPCQRCodeRecognizeParam, final f<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult> paramf, boolean paramBoolean)
    {
      AppMethodBeat.i(45674);
      if (paramBoolean) {}
      for (final String str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(paramIPCQRCodeRecognizeParam);; str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(paramIPCQRCodeRecognizeParam))
      {
        Log.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", new Object[] { Boolean.valueOf(this.oxB), Boolean.valueOf(paramBoolean), str });
        this.oxB = paramBoolean;
        if (!Util.isNullOrNil(str)) {
          break;
        }
        AppMethodBeat.o(45674);
        return;
      }
      final i locali2 = new i();
      final i locali1 = new i();
      IListener local1 = new IListener() {};
      locali2.value = local1;
      paramIPCQRCodeRecognizeParam = new IListener() {};
      locali1.value = paramIPCQRCodeRecognizeParam;
      EventCenter.instance.addListener(local1);
      EventCenter.instance.addListener(paramIPCQRCodeRecognizeParam);
      paramIPCQRCodeRecognizeParam = new rx();
      paramIPCQRCodeRecognizeParam.fRg.fwK = System.currentTimeMillis();
      paramIPCQRCodeRecognizeParam.fRg.filePath = str;
      paramIPCQRCodeRecognizeParam.fRg.fRh = JsApiShowImageOperateSheet.BottomSheetLogicHelper.bPR();
      EventCenter.instance.publish(paramIPCQRCodeRecognizeParam);
      AppMethodBeat.o(45674);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper
 * JD-Core Version:    0.7.0.1
 */