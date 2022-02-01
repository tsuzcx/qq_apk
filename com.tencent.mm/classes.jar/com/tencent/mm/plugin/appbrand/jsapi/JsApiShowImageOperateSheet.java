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
import androidx.lifecycle.q;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.tn;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.utils.g;
import com.tencent.mm.plugin.appbrand.utils.g.a;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Set;

public final class JsApiShowImageOperateSheet
  extends c<com.tencent.mm.plugin.appbrand.page.ah>
{
  public static final int CTRL_INDEX = 626;
  public static final String NAME = "showImageOperateSheet";
  
  static final class BottomSheetLogicHelper
  {
    private static Set<Integer> rAI;
    private IPCQRCodeRecognizeResult rAJ;
    private com.tencent.mm.ui.widget.a.f rAK;
    final com.tencent.mm.plugin.appbrand.page.ah rAL;
    private final String rAM;
    private final String rAN;
    private final Rect rAO;
    ScanCodeSheetItemLogic rAP;
    
    static
    {
      AppMethodBeat.i(45700);
      HashSet localHashSet = new HashSet();
      rAI = localHashSet;
      localHashSet.add(Integer.valueOf(3));
      AppMethodBeat.o(45700);
    }
    
    public BottomSheetLogicHelper(com.tencent.mm.plugin.appbrand.page.ah paramah, String paramString1, String paramString2, Rect paramRect)
    {
      AppMethodBeat.i(325556);
      this.rAL = paramah;
      this.rAM = paramString1;
      this.rAN = paramString2;
      this.rAO = paramRect;
      this.rAP = new ScanCodeSheetItemLogic(paramah.getContext(), new ScanCodeSheetItemLogic.a()
      {
        public final void onFetchedCodeInfo()
        {
          AppMethodBeat.i(325652);
          if ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.this) != null) && (JsApiShowImageOperateSheet.BottomSheetLogicHelper.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.this).isShowing())) {
            JsApiShowImageOperateSheet.BottomSheetLogicHelper.this.cpX();
          }
          AppMethodBeat.o(325652);
        }
      });
      AppMethodBeat.o(325556);
    }
    
    private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(325559);
      Object localObject;
      String str1;
      String str2;
      if ((this.rAL != null) && (this.rAL.getRuntime() != null))
      {
        localObject = this.rAL.getRuntime().getInitConfig();
        if (localObject != null)
        {
          str1 = ((AppBrandInitConfigLU)localObject).eoP;
          str2 = this.rAL.getAppId();
          if (((AppBrandInitConfigLU)localObject).epn == null) {
            break label113;
          }
        }
      }
      label113:
      for (int i = ((AppBrandInitConfigLU)localObject).epn.scene;; i = 0)
      {
        localObject = com.tencent.mm.plugin.scanner.a.OGI;
        com.tencent.mm.plugin.scanner.a.a(str1, i, str2, false, this.rAL.cEE(), paramInt, paramString, paramBoolean1, paramBoolean2, this.rAL.cgR());
        AppMethodBeat.o(325559);
        return;
      }
    }
    
    private void a(g.a parama)
    {
      AppMethodBeat.i(45692);
      if (!Util.isNullOrNil(this.rAN))
      {
        Object localObject = this.rAL.getFileSystem().Wo("showSheet_base64_" + System.currentTimeMillis());
        if (localObject == null)
        {
          Log.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
          AppMethodBeat.o(45692);
          return;
        }
        localObject = com.tencent.mm.vfs.ah.v(((u)localObject).jKT());
        byte[] arrayOfByte = Base64.decode(this.rAN, 0);
        y.f((String)localObject, arrayOfByte, arrayOfByte.length);
        parama.onLoad((String)localObject);
        AppMethodBeat.o(45692);
        return;
      }
      g.a(this.rAL, this.rAM, null, parama);
      AppMethodBeat.o(45692);
    }
    
    public final void cpX()
    {
      AppMethodBeat.i(45691);
      boolean bool = com.tencent.luggage.l.f.bv(this.rAL.getContext());
      Runnable local3 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(325649);
          JsApiShowImageOperateSheet.BottomSheetLogicHelper.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.this);
          AppMethodBeat.o(325649);
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
      private String pageUrl;
      private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult rAZ;
      
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
        this.rAZ = ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult)paramParcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader()));
        this.appID = paramParcel.readString();
        this.pageUrl = paramParcel.readString();
        AppMethodBeat.o(45667);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
      {
        return JsApiShowImageOperateSheet.BottomSheetLogicHelper.b.class;
      }
      
      public final boolean oneShotForeground()
      {
        return true;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(45668);
        paramParcel.writeParcelable(this.rAZ, paramInt);
        paramParcel.writeString(this.appID);
        paramParcel.writeString(this.pageUrl);
        AppMethodBeat.o(45668);
      }
    }
    
    static final class IPCQRCodeRecognizeParam
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR;
      private String rBg;
      private String rBh;
      
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
        this.rBg = paramParcel.readString();
        this.rBh = paramParcel.readString();
        AppMethodBeat.o(45679);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(45680);
        paramParcel.writeString(this.rBg);
        paramParcel.writeString(this.rBh);
        AppMethodBeat.o(45680);
      }
    }
    
    static final class IPCQRCodeRecognizeResult
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR;
      private String filePath;
      private int hDb;
      private int hDc;
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
        this.hDb = paramParcel.readInt();
        this.hDc = paramParcel.readInt();
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
        paramParcel.writeInt(this.hDb);
        paramParcel.writeInt(this.hDc);
        AppMethodBeat.o(45684);
      }
    }
    
    static final class b
      extends AppBrandProxyUIProcessTask
    {
      public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
      {
        AppMethodBeat.i(45670);
        if (!(paramProcessRequest instanceof JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest))
        {
          Log.e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
          AppMethodBeat.o(45670);
          return;
        }
        paramProcessRequest = (JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest)paramProcessRequest;
        df localdf = new df();
        localdf.hDa.activity = getActivityContext();
        localdf.hDa.hBi = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localdf.hDa.hDb = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localdf.hDa.hDc = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.c(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localdf.hDa.scene = 44;
        Bundle localBundle = new Bundle();
        localBundle.putInt("stat_scene", 6);
        localBundle.putString("stat_app_id", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.b(paramProcessRequest));
        localBundle.putString("stat_url", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.c(paramProcessRequest));
        localdf.hDa.hDf = localBundle;
        localdf.publish();
        AppMethodBeat.o(45670);
      }
    }
    
    static final class c
      implements d<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult>
    {
      private boolean rBa = false;
      
      private void a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam paramIPCQRCodeRecognizeParam, com.tencent.mm.ipcinvoker.f<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult> paramf, boolean paramBoolean)
      {
        AppMethodBeat.i(45674);
        if (paramBoolean) {}
        for (String str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(paramIPCQRCodeRecognizeParam);; str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(paramIPCQRCodeRecognizeParam))
        {
          Log.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", new Object[] { Boolean.valueOf(this.rBa), Boolean.valueOf(paramBoolean), str });
          this.rBa = paramBoolean;
          if (!Util.isNullOrNil(str)) {
            break;
          }
          AppMethodBeat.o(45674);
          return;
        }
        com.tencent.mm.plugin.appbrand.af.k localk2 = new com.tencent.mm.plugin.appbrand.af.k();
        com.tencent.mm.plugin.appbrand.af.k localk1 = new com.tencent.mm.plugin.appbrand.af.k();
        JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognize.1 local1 = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognize.1(this, com.tencent.mm.app.f.hfK, localk2, localk1, str, paramf);
        localk2.value = local1;
        paramIPCQRCodeRecognizeParam = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognize.2(this, com.tencent.mm.app.f.hfK, localk2, localk1, str, paramIPCQRCodeRecognizeParam, paramf);
        localk1.value = paramIPCQRCodeRecognizeParam;
        local1.alive();
        paramIPCQRCodeRecognizeParam.alive();
        paramIPCQRCodeRecognizeParam = new tm();
        paramIPCQRCodeRecognizeParam.hXd.hBk = System.currentTimeMillis();
        paramIPCQRCodeRecognizeParam.hXd.filePath = str;
        paramIPCQRCodeRecognizeParam.hXd.hXe = JsApiShowImageOperateSheet.BottomSheetLogicHelper.cpY();
        paramIPCQRCodeRecognizeParam.publish();
        AppMethodBeat.o(45674);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet
 * JD-Core Version:    0.7.0.1
 */