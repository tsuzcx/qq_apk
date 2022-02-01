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
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Set;

public final class JsApiShowImageOperateSheet
  extends a<ae>
{
  public static final int CTRL_INDEX = 626;
  public static final String NAME = "showImageOperateSheet";
  
  static final class BottomSheetLogicHelper
  {
    private static Set<Integer> jZK;
    private static Set<Integer> jZL;
    private IPCQRCodeRecognizeResult jZM;
    private com.tencent.mm.ui.widget.a.e jZN;
    private final ae jZO;
    private final String jZP;
    private final String jZQ;
    private final Rect jZR;
    
    static
    {
      AppMethodBeat.i(45700);
      HashSet localHashSet = new HashSet();
      jZK = localHashSet;
      localHashSet.add(Integer.valueOf(3));
      localHashSet = new HashSet();
      jZL = localHashSet;
      localHashSet.add(Integer.valueOf(22));
      AppMethodBeat.o(45700);
    }
    
    public BottomSheetLogicHelper(ae paramae, String paramString1, String paramString2, Rect paramRect)
    {
      this.jZO = paramae;
      this.jZP = paramString1;
      this.jZQ = paramString2;
      this.jZR = paramRect;
    }
    
    private void a(b.a parama)
    {
      AppMethodBeat.i(45692);
      if (!bs.isNullOrNil(this.jZQ))
      {
        Object localObject = this.jZO.DH().IU("showSheet_base64_" + System.currentTimeMillis());
        if (localObject == null)
        {
          ac.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
          AppMethodBeat.o(45692);
          return;
        }
        localObject = q.B(((com.tencent.mm.vfs.e)localObject).fxV());
        byte[] arrayOfByte = Base64.decode(this.jZQ, 0);
        com.tencent.mm.vfs.i.f((String)localObject, arrayOfByte, arrayOfByte.length);
        parama.Jr((String)localObject);
        AppMethodBeat.o(45692);
        return;
      }
      com.tencent.mm.plugin.appbrand.utils.b.a(this.jZO, this.jZP, null, parama);
      AppMethodBeat.o(45692);
    }
    
    public final void beP()
    {
      AppMethodBeat.i(45691);
      boolean bool = com.tencent.luggage.h.f.aC(this.jZO.getContext());
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
        ap.n(local1, i);
        AppMethodBeat.o(45691);
        return;
      }
    }
    
    static final class IPCProcessQRCodeResultRequest
      extends AppBrandProxyUIProcessTask.ProcessRequest
    {
      public static final Parcelable.Creator<IPCProcessQRCodeResultRequest> CREATOR;
      private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult kab;
      private String kac;
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
        this.kab = ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult)paramParcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader()));
        this.kac = paramParcel.readString();
        this.pageUrl = paramParcel.readString();
        AppMethodBeat.o(45667);
      }
      
      public final Class<? extends AppBrandProxyUIProcessTask> bdj()
      {
        return JsApiShowImageOperateSheet.BottomSheetLogicHelper.b.class;
      }
      
      public final boolean ben()
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
        paramParcel.writeParcelable(this.kab, paramInt);
        paramParcel.writeString(this.kac);
        paramParcel.writeString(this.pageUrl);
        AppMethodBeat.o(45668);
      }
    }
    
    static final class IPCQRCodeRecognizeParam
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR;
      private String jtV;
      private String kak;
      
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
        this.jtV = paramParcel.readString();
        this.kak = paramParcel.readString();
        AppMethodBeat.o(45679);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(45680);
        paramParcel.writeString(this.jtV);
        paramParcel.writeString(this.kak);
        AppMethodBeat.o(45680);
      }
    }
    
    static final class IPCQRCodeRecognizeResult
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR;
      private String bLs;
      private int dbX;
      private int dbY;
      private String filePath;
      private String hlG;
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
        this.dbX = paramParcel.readInt();
        this.dbY = paramParcel.readInt();
        this.bLs = paramParcel.readString();
        this.hlG = paramParcel.readString();
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
        paramParcel.writeInt(this.dbX);
        paramParcel.writeInt(this.dbY);
        paramParcel.writeString(this.bLs);
        paramParcel.writeString(this.hlG);
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
          ac.e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
          AppMethodBeat.o(45670);
          return;
        }
        paramProcessRequest = (JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest)paramProcessRequest;
        cl localcl = new cl();
        localcl.dbW.activity = bef();
        localcl.dbW.dam = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcl.dbW.dbX = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcl.dbW.dbY = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.e(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcl.dbW.scene = 44;
        Bundle localBundle = new Bundle();
        localBundle.putInt("stat_scene", 6);
        localBundle.putString("stat_app_id", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.b(paramProcessRequest));
        localBundle.putString("stat_url", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.c(paramProcessRequest));
        localcl.dbW.dcb = localBundle;
        com.tencent.mm.sdk.b.a.GpY.l(localcl);
        AppMethodBeat.o(45670);
      }
    }
    
    static final class c
      implements com.tencent.mm.ipcinvoker.b<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult>
    {
      private boolean kad = false;
      
      private void a(final JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam paramIPCQRCodeRecognizeParam, final d<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult> paramd, boolean paramBoolean)
      {
        AppMethodBeat.i(45674);
        if (paramBoolean) {}
        for (final String str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(paramIPCQRCodeRecognizeParam);; str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(paramIPCQRCodeRecognizeParam))
        {
          ac.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", new Object[] { Boolean.valueOf(this.kad), Boolean.valueOf(paramBoolean), str });
          this.kad = paramBoolean;
          if (!bs.isNullOrNil(str)) {
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
        com.tencent.mm.sdk.b.a.GpY.c(local1);
        com.tencent.mm.sdk.b.a.GpY.c(paramIPCQRCodeRecognizeParam);
        paramIPCQRCodeRecognizeParam = new ps();
        paramIPCQRCodeRecognizeParam.dsJ.dao = System.currentTimeMillis();
        paramIPCQRCodeRecognizeParam.dsJ.filePath = str;
        paramIPCQRCodeRecognizeParam.dsJ.dsK = JsApiShowImageOperateSheet.BottomSheetLogicHelper.beR();
        com.tencent.mm.sdk.b.a.GpY.l(paramIPCQRCodeRecognizeParam);
        AppMethodBeat.o(45674);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet
 * JD-Core Version:    0.7.0.1
 */