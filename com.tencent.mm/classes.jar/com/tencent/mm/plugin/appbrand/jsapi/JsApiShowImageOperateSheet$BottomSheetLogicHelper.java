package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Set;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper
{
  private static Set<Integer> kug;
  private static Set<Integer> kuh;
  private IPCQRCodeRecognizeResult kui;
  private com.tencent.mm.ui.widget.a.e kuj;
  private final ae kuk;
  private final String kul;
  private final String kum;
  private final Rect kun;
  
  static
  {
    AppMethodBeat.i(45700);
    HashSet localHashSet = new HashSet();
    kug = localHashSet;
    localHashSet.add(Integer.valueOf(3));
    localHashSet = new HashSet();
    kuh = localHashSet;
    localHashSet.add(Integer.valueOf(22));
    AppMethodBeat.o(45700);
  }
  
  public JsApiShowImageOperateSheet$BottomSheetLogicHelper(ae paramae, String paramString1, String paramString2, Rect paramRect)
  {
    this.kuk = paramae;
    this.kul = paramString1;
    this.kum = paramString2;
    this.kun = paramRect;
  }
  
  private void a(b.a parama)
  {
    AppMethodBeat.i(45692);
    if (!bt.isNullOrNil(this.kum))
    {
      Object localObject = this.kuk.Fg().Ml("showSheet_base64_" + System.currentTimeMillis());
      if (localObject == null)
      {
        ad.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
        AppMethodBeat.o(45692);
        return;
      }
      localObject = q.B(((com.tencent.mm.vfs.e)localObject).fOK());
      byte[] arrayOfByte = Base64.decode(this.kum, 0);
      com.tencent.mm.vfs.i.f((String)localObject, arrayOfByte, arrayOfByte.length);
      parama.MK((String)localObject);
      AppMethodBeat.o(45692);
      return;
    }
    com.tencent.mm.plugin.appbrand.utils.b.a(this.kuk, this.kul, null, parama);
    AppMethodBeat.o(45692);
  }
  
  public final void bit()
  {
    AppMethodBeat.i(45691);
    boolean bool = com.tencent.luggage.h.f.aC(this.kuk.getContext());
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45653);
        JsApiShowImageOperateSheet.BottomSheetLogicHelper.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.this);
        AppMethodBeat.o(45653);
      }
    };
    if (bool) {}
    for (int i = 100;; i = 0)
    {
      aq.o(local1, i);
      AppMethodBeat.o(45691);
      return;
    }
  }
  
  static final class IPCProcessQRCodeResultRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<IPCProcessQRCodeResultRequest> CREATOR;
    private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult kux;
    private String kuy;
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
      this.kux = ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult)paramParcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader()));
      this.kuy = paramParcel.readString();
      this.pageUrl = paramParcel.readString();
      AppMethodBeat.o(45667);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bgN()
    {
      return JsApiShowImageOperateSheet.BottomSheetLogicHelper.b.class;
    }
    
    public final boolean bhR()
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
      paramParcel.writeParcelable(this.kux, paramInt);
      paramParcel.writeString(this.kuy);
      paramParcel.writeString(this.pageUrl);
      AppMethodBeat.o(45668);
    }
  }
  
  static final class IPCQRCodeRecognizeParam
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR;
    private String jNP;
    private String kuG;
    
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
      this.jNP = paramParcel.readString();
      this.kuG = paramParcel.readString();
      AppMethodBeat.o(45679);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45680);
      paramParcel.writeString(this.jNP);
      paramParcel.writeString(this.kuG);
      AppMethodBeat.o(45680);
    }
  }
  
  static final class IPCQRCodeRecognizeResult
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR;
    private String bVF;
    private int dnt;
    private int dnu;
    private String filePath;
    private String hDQ;
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
      this.dnt = paramParcel.readInt();
      this.dnu = paramParcel.readInt();
      this.bVF = paramParcel.readString();
      this.hDQ = paramParcel.readString();
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
      paramParcel.writeInt(this.dnt);
      paramParcel.writeInt(this.dnu);
      paramParcel.writeString(this.bVF);
      paramParcel.writeString(this.hDQ);
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
        ad.e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
        AppMethodBeat.o(45670);
        return;
      }
      paramProcessRequest = (JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest)paramProcessRequest;
      co localco = new co();
      localco.dns.activity = bhJ();
      localco.dns.dlG = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localco.dns.dnt = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localco.dns.dnu = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.e(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
      localco.dns.scene = 44;
      Bundle localBundle = new Bundle();
      localBundle.putInt("stat_scene", 6);
      localBundle.putString("stat_app_id", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.b(paramProcessRequest));
      localBundle.putString("stat_url", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.c(paramProcessRequest));
      localco.dns.dnx = localBundle;
      a.IbL.l(localco);
      AppMethodBeat.o(45670);
    }
  }
  
  static final class c
    implements com.tencent.mm.ipcinvoker.b<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult>
  {
    private boolean kuz = false;
    
    private void a(final JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam paramIPCQRCodeRecognizeParam, final d<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult> paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(45674);
      if (paramBoolean) {}
      for (final String str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(paramIPCQRCodeRecognizeParam);; str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(paramIPCQRCodeRecognizeParam))
      {
        ad.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", new Object[] { Boolean.valueOf(this.kuz), Boolean.valueOf(paramBoolean), str });
        this.kuz = paramBoolean;
        if (!bt.isNullOrNil(str)) {
          break;
        }
        AppMethodBeat.o(45674);
        return;
      }
      final com.tencent.mm.plugin.appbrand.z.i locali2 = new com.tencent.mm.plugin.appbrand.z.i();
      final com.tencent.mm.plugin.appbrand.z.i locali1 = new com.tencent.mm.plugin.appbrand.z.i();
      c local1 = new c() {};
      locali2.value = local1;
      paramIPCQRCodeRecognizeParam = new c() {};
      locali1.value = paramIPCQRCodeRecognizeParam;
      a.IbL.c(local1);
      a.IbL.c(paramIPCQRCodeRecognizeParam);
      paramIPCQRCodeRecognizeParam = new qc();
      paramIPCQRCodeRecognizeParam.dEC.dlI = System.currentTimeMillis();
      paramIPCQRCodeRecognizeParam.dEC.filePath = str;
      paramIPCQRCodeRecognizeParam.dEC.dED = JsApiShowImageOperateSheet.BottomSheetLogicHelper.biv();
      a.IbL.l(paramIPCQRCodeRecognizeParam);
      AppMethodBeat.o(45674);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper
 * JD-Core Version:    0.7.0.1
 */