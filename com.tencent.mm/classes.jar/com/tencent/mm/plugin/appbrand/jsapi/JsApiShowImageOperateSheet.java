package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
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
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vending.g.d.b;
import java.util.HashSet;
import java.util.Set;

public final class JsApiShowImageOperateSheet
  extends a<ae>
{
  public static final int CTRL_INDEX = 626;
  public static final String NAME = "showImageOperateSheet";
  
  static final class BottomSheetLogicHelper
  {
    private static Set<Integer> jzn;
    private static Set<Integer> jzo;
    private IPCQRCodeRecognizeResult jzp;
    private com.tencent.mm.ui.widget.a.e jzq;
    private final ae jzr;
    private final String jzs;
    private final String jzt;
    private final Rect jzu;
    
    static
    {
      AppMethodBeat.i(45700);
      HashSet localHashSet = new HashSet();
      jzn = localHashSet;
      localHashSet.add(Integer.valueOf(3));
      localHashSet = new HashSet();
      jzo = localHashSet;
      localHashSet.add(Integer.valueOf(22));
      AppMethodBeat.o(45700);
    }
    
    public BottomSheetLogicHelper(ae paramae, String paramString1, String paramString2, Rect paramRect)
    {
      this.jzr = paramae;
      this.jzs = paramString1;
      this.jzt = paramString2;
      this.jzu = paramRect;
    }
    
    private void a(b.a parama)
    {
      AppMethodBeat.i(45692);
      if (!bt.isNullOrNil(this.jzt))
      {
        Object localObject = this.jzr.Ee().ER("showSheet_base64_" + System.currentTimeMillis());
        if (localObject == null)
        {
          ad.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
          AppMethodBeat.o(45692);
          return;
        }
        localObject = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject).fhU());
        byte[] arrayOfByte = Base64.decode(this.jzt, 0);
        com.tencent.mm.vfs.i.f((String)localObject, arrayOfByte, arrayOfByte.length);
        parama.Fn((String)localObject);
        AppMethodBeat.o(45692);
        return;
      }
      com.tencent.mm.plugin.appbrand.utils.b.a(this.jzr, this.jzs, null, parama);
      AppMethodBeat.o(45692);
    }
    
    public final void aXS()
    {
      AppMethodBeat.i(45691);
      boolean bool = com.tencent.luggage.h.f.aB(this.jzr.getContext());
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
        aq.n(local1, i);
        AppMethodBeat.o(45691);
        return;
      }
    }
    
    static final class IPCProcessQRCodeResultRequest
      extends AppBrandProxyUIProcessTask.ProcessRequest
    {
      public static final Parcelable.Creator<IPCProcessQRCodeResultRequest> CREATOR;
      private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult jzE;
      private String jzF;
      private String jzG;
      
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
        this.jzE = ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult)paramParcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader()));
        this.jzF = paramParcel.readString();
        this.jzG = paramParcel.readString();
        AppMethodBeat.o(45667);
      }
      
      public final Class<? extends AppBrandProxyUIProcessTask> aWl()
      {
        return JsApiShowImageOperateSheet.BottomSheetLogicHelper.b.class;
      }
      
      public final boolean aXq()
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
        paramParcel.writeParcelable(this.jzE, paramInt);
        paramParcel.writeString(this.jzF);
        paramParcel.writeString(this.jzG);
        AppMethodBeat.o(45668);
      }
    }
    
    static final class IPCQRCodeRecognizeParam
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR;
      private String iTJ;
      private String jzO;
      
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
        this.iTJ = paramParcel.readString();
        this.jzO = paramParcel.readString();
        AppMethodBeat.o(45679);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(45680);
        paramParcel.writeString(this.iTJ);
        paramParcel.writeString(this.jzO);
        AppMethodBeat.o(45680);
      }
    }
    
    static final class IPCQRCodeRecognizeResult
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR;
      private String bNK;
      private int deB;
      private int deC;
      private String filePath;
      private String gLg;
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
        this.deB = paramParcel.readInt();
        this.deC = paramParcel.readInt();
        this.bNK = paramParcel.readString();
        this.gLg = paramParcel.readString();
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
        paramParcel.writeInt(this.deB);
        paramParcel.writeInt(this.deC);
        paramParcel.writeString(this.bNK);
        paramParcel.writeString(this.gLg);
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
        cl localcl = new cl();
        localcl.deA.activity = aXi();
        localcl.deA.dcO = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcl.deA.deB = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcl.deA.deC = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.e(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcl.deA.scene = 44;
        Bundle localBundle = new Bundle();
        localBundle.putInt("stat_scene", 6);
        localBundle.putString("stat_app_id", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.b(paramProcessRequest));
        localBundle.putString("stat_url", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.c(paramProcessRequest));
        localcl.deA.deG = localBundle;
        com.tencent.mm.sdk.b.a.ESL.l(localcl);
        AppMethodBeat.o(45670);
      }
    }
    
    static final class c
      implements com.tencent.mm.ipcinvoker.b<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult>
    {
      private boolean jzH = false;
      
      private void a(final JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam paramIPCQRCodeRecognizeParam, final com.tencent.mm.ipcinvoker.d<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult> paramd, boolean paramBoolean)
      {
        AppMethodBeat.i(45674);
        if (paramBoolean) {}
        for (final String str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(paramIPCQRCodeRecognizeParam);; str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(paramIPCQRCodeRecognizeParam))
        {
          ad.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", new Object[] { Boolean.valueOf(this.jzH), Boolean.valueOf(paramBoolean), str });
          this.jzH = paramBoolean;
          if (!bt.isNullOrNil(str)) {
            break;
          }
          AppMethodBeat.o(45674);
          return;
        }
        final com.tencent.mm.plugin.appbrand.aa.i locali2 = new com.tencent.mm.plugin.appbrand.aa.i();
        final com.tencent.mm.plugin.appbrand.aa.i locali1 = new com.tencent.mm.plugin.appbrand.aa.i();
        c local1 = new c() {};
        locali2.value = local1;
        paramIPCQRCodeRecognizeParam = new c() {};
        locali1.value = paramIPCQRCodeRecognizeParam;
        com.tencent.mm.sdk.b.a.ESL.c(local1);
        com.tencent.mm.sdk.b.a.ESL.c(paramIPCQRCodeRecognizeParam);
        paramIPCQRCodeRecognizeParam = new pj();
        paramIPCQRCodeRecognizeParam.duX.dcQ = System.currentTimeMillis();
        paramIPCQRCodeRecognizeParam.duX.filePath = str;
        paramIPCQRCodeRecognizeParam.duX.duY = JsApiShowImageOperateSheet.BottomSheetLogicHelper.aXU();
        com.tencent.mm.sdk.b.a.ESL.l(paramIPCQRCodeRecognizeParam);
        AppMethodBeat.o(45674);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet
 * JD-Core Version:    0.7.0.1
 */