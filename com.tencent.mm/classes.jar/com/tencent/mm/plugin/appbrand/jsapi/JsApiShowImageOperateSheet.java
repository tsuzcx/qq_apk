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
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.HashSet;
import java.util.Set;

public final class JsApiShowImageOperateSheet
  extends a<ad>
{
  public static final int CTRL_INDEX = 626;
  public static final String NAME = "showImageOperateSheet";
  
  static final class BottomSheetLogicHelper
  {
    private static Set<Integer> kxw;
    private static Set<Integer> kxx;
    private final ad kxA;
    private final String kxB;
    private final String kxC;
    private final Rect kxD;
    private IPCQRCodeRecognizeResult kxy;
    private e kxz;
    
    static
    {
      AppMethodBeat.i(45700);
      HashSet localHashSet = new HashSet();
      kxw = localHashSet;
      localHashSet.add(Integer.valueOf(3));
      localHashSet = new HashSet();
      kxx = localHashSet;
      localHashSet.add(Integer.valueOf(22));
      AppMethodBeat.o(45700);
    }
    
    public BottomSheetLogicHelper(ad paramad, String paramString1, String paramString2, Rect paramRect)
    {
      this.kxA = paramad;
      this.kxB = paramString1;
      this.kxC = paramString2;
      this.kxD = paramRect;
    }
    
    private void a(c.a parama)
    {
      AppMethodBeat.i(45692);
      if (!bu.isNullOrNil(this.kxC))
      {
        Object localObject = this.kxA.Fl().MR("showSheet_base64_" + System.currentTimeMillis());
        if (localObject == null)
        {
          ae.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
          AppMethodBeat.o(45692);
          return;
        }
        localObject = w.B(((k)localObject).fTh());
        byte[] arrayOfByte = Base64.decode(this.kxC, 0);
        o.f((String)localObject, arrayOfByte, arrayOfByte.length);
        parama.Nr((String)localObject);
        AppMethodBeat.o(45692);
        return;
      }
      com.tencent.mm.plugin.appbrand.utils.c.a(this.kxA, this.kxB, null, parama);
      AppMethodBeat.o(45692);
    }
    
    public final void bjc()
    {
      AppMethodBeat.i(45691);
      boolean bool = f.aD(this.kxA.getContext());
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
        ar.o(local1, i);
        AppMethodBeat.o(45691);
        return;
      }
    }
    
    static final class IPCProcessQRCodeResultRequest
      extends AppBrandProxyUIProcessTask.ProcessRequest
    {
      public static final Parcelable.Creator<IPCProcessQRCodeResultRequest> CREATOR;
      private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult kxN;
      private String kxO;
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
        this.kxN = ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult)paramParcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader()));
        this.kxO = paramParcel.readString();
        this.pageUrl = paramParcel.readString();
        AppMethodBeat.o(45667);
      }
      
      public final Class<? extends AppBrandProxyUIProcessTask> bhv()
      {
        return JsApiShowImageOperateSheet.BottomSheetLogicHelper.b.class;
      }
      
      public final boolean biA()
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
        paramParcel.writeParcelable(this.kxN, paramInt);
        paramParcel.writeString(this.kxO);
        paramParcel.writeString(this.pageUrl);
        AppMethodBeat.o(45668);
      }
    }
    
    static final class IPCQRCodeRecognizeParam
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR;
      private String jRg;
      private String kxW;
      
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
        this.jRg = paramParcel.readString();
        this.kxW = paramParcel.readString();
        AppMethodBeat.o(45679);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(45680);
        paramParcel.writeString(this.jRg);
        paramParcel.writeString(this.kxW);
        AppMethodBeat.o(45680);
      }
    }
    
    static final class IPCQRCodeRecognizeResult
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR;
      private String bVF;
      private int dov;
      private int dow;
      private String filePath;
      private String hGI;
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
        this.dov = paramParcel.readInt();
        this.dow = paramParcel.readInt();
        this.bVF = paramParcel.readString();
        this.hGI = paramParcel.readString();
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
        paramParcel.writeInt(this.dov);
        paramParcel.writeInt(this.dow);
        paramParcel.writeString(this.bVF);
        paramParcel.writeString(this.hGI);
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
          ae.e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
          AppMethodBeat.o(45670);
          return;
        }
        paramProcessRequest = (JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest)paramProcessRequest;
        co localco = new co();
        localco.dou.activity = bis();
        localco.dou.dmI = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localco.dou.dov = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localco.dou.dow = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.e(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localco.dou.scene = 44;
        Bundle localBundle = new Bundle();
        localBundle.putInt("stat_scene", 6);
        localBundle.putString("stat_app_id", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.b(paramProcessRequest));
        localBundle.putString("stat_url", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.c(paramProcessRequest));
        localco.dou.doz = localBundle;
        com.tencent.mm.sdk.b.a.IvT.l(localco);
        AppMethodBeat.o(45670);
      }
    }
    
    static final class c
      implements com.tencent.mm.ipcinvoker.b<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult>
    {
      private boolean kxP = false;
      
      private void a(final JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam paramIPCQRCodeRecognizeParam, final com.tencent.mm.ipcinvoker.d<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult> paramd, boolean paramBoolean)
      {
        AppMethodBeat.i(45674);
        if (paramBoolean) {}
        for (final String str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(paramIPCQRCodeRecognizeParam);; str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(paramIPCQRCodeRecognizeParam))
        {
          ae.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", new Object[] { Boolean.valueOf(this.kxP), Boolean.valueOf(paramBoolean), str });
          this.kxP = paramBoolean;
          if (!bu.isNullOrNil(str)) {
            break;
          }
          AppMethodBeat.o(45674);
          return;
        }
        final i locali2 = new i();
        final i locali1 = new i();
        com.tencent.mm.sdk.b.c local1 = new com.tencent.mm.sdk.b.c() {};
        locali2.value = local1;
        paramIPCQRCodeRecognizeParam = new com.tencent.mm.sdk.b.c() {};
        locali1.value = paramIPCQRCodeRecognizeParam;
        com.tencent.mm.sdk.b.a.IvT.c(local1);
        com.tencent.mm.sdk.b.a.IvT.c(paramIPCQRCodeRecognizeParam);
        paramIPCQRCodeRecognizeParam = new qd();
        paramIPCQRCodeRecognizeParam.dFH.dmK = System.currentTimeMillis();
        paramIPCQRCodeRecognizeParam.dFH.filePath = str;
        paramIPCQRCodeRecognizeParam.dFH.dFI = JsApiShowImageOperateSheet.BottomSheetLogicHelper.bje();
        com.tencent.mm.sdk.b.a.IvT.l(paramIPCQRCodeRecognizeParam);
        AppMethodBeat.o(45674);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet
 * JD-Core Version:    0.7.0.1
 */