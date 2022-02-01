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
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Set;

public final class JsApiShowImageOperateSheet
  extends d<ag>
{
  public static final int CTRL_INDEX = 626;
  public static final String NAME = "showImageOperateSheet";
  
  static final class BottomSheetLogicHelper
  {
    private static Set<Integer> lBJ;
    private static Set<Integer> lBK;
    private IPCQRCodeRecognizeResult lBL;
    private e lBM;
    private final ag lBN;
    private final String lBO;
    private final String lBP;
    private final Rect lBQ;
    
    static
    {
      AppMethodBeat.i(45700);
      HashSet localHashSet = new HashSet();
      lBJ = localHashSet;
      localHashSet.add(Integer.valueOf(3));
      localHashSet = new HashSet();
      lBK = localHashSet;
      localHashSet.add(Integer.valueOf(22));
      AppMethodBeat.o(45700);
    }
    
    public BottomSheetLogicHelper(ag paramag, String paramString1, String paramString2, Rect paramRect)
    {
      this.lBN = paramag;
      this.lBO = paramString1;
      this.lBP = paramString2;
      this.lBQ = paramRect;
    }
    
    private void a(c.a parama)
    {
      AppMethodBeat.i(45692);
      if (!Util.isNullOrNil(this.lBP))
      {
        Object localObject = this.lBN.getFileSystem().Wa("showSheet_base64_" + System.currentTimeMillis());
        if (localObject == null)
        {
          Log.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
          AppMethodBeat.o(45692);
          return;
        }
        localObject = aa.z(((o)localObject).her());
        byte[] arrayOfByte = Base64.decode(this.lBP, 0);
        com.tencent.mm.vfs.s.f((String)localObject, arrayOfByte, arrayOfByte.length);
        parama.Wz((String)localObject);
        AppMethodBeat.o(45692);
        return;
      }
      com.tencent.mm.plugin.appbrand.utils.c.a(this.lBN, this.lBO, null, parama);
      AppMethodBeat.o(45692);
    }
    
    public final void bEq()
    {
      AppMethodBeat.i(45691);
      boolean bool = com.tencent.luggage.h.g.aM(this.lBN.getContext());
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
        MMHandlerThread.postToMainThreadDelayed(local1, i);
        AppMethodBeat.o(45691);
        return;
      }
    }
    
    static final class IPCProcessQRCodeResultRequest
      extends AppBrandProxyUIProcessTask.ProcessRequest
    {
      public static final Parcelable.Creator<IPCProcessQRCodeResultRequest> CREATOR;
      private String appID;
      private JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult lCa;
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
        this.lCa = ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult)paramParcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader()));
        this.appID = paramParcel.readString();
        this.pageUrl = paramParcel.readString();
        AppMethodBeat.o(45667);
      }
      
      public final Class<? extends AppBrandProxyUIProcessTask> bCJ()
      {
        return JsApiShowImageOperateSheet.BottomSheetLogicHelper.b.class;
      }
      
      public final boolean bDN()
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
        paramParcel.writeParcelable(this.lCa, paramInt);
        paramParcel.writeString(this.appID);
        paramParcel.writeString(this.pageUrl);
        AppMethodBeat.o(45668);
      }
    }
    
    static final class IPCQRCodeRecognizeParam
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR;
      private String kTQ;
      private String lCi;
      
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
        this.kTQ = paramParcel.readString();
        this.lCi = paramParcel.readString();
        AppMethodBeat.o(45679);
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(45680);
        paramParcel.writeString(this.kTQ);
        paramParcel.writeString(this.lCi);
        AppMethodBeat.o(45680);
      }
    }
    
    static final class IPCQRCodeRecognizeResult
      implements Parcelable
    {
      public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR;
      private int dFL;
      private int dFM;
      private String filePath;
      private String iAR;
      private String nickName;
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
        this.dFL = paramParcel.readInt();
        this.dFM = paramParcel.readInt();
        this.nickName = paramParcel.readString();
        this.iAR = paramParcel.readString();
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
        paramParcel.writeInt(this.dFL);
        paramParcel.writeInt(this.dFM);
        paramParcel.writeString(this.nickName);
        paramParcel.writeString(this.iAR);
        AppMethodBeat.o(45684);
      }
    }
    
    static final class IPCSendToFriendEmojiRequest
      extends AppBrandProxyUIProcessTask.ProcessRequest
    {
      public static final Parcelable.Creator<IPCSendToFriendEmojiRequest> CREATOR;
      private String lCj;
      
      static
      {
        AppMethodBeat.i(45689);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(45689);
      }
      
      protected IPCSendToFriendEmojiRequest() {}
      
      protected IPCSendToFriendEmojiRequest(Parcel paramParcel)
      {
        AppMethodBeat.i(45687);
        this.lCj = paramParcel.readString();
        AppMethodBeat.o(45687);
      }
      
      public final Class<? extends AppBrandProxyUIProcessTask> bCJ()
      {
        return JsApiShowImageOperateSheet.BottomSheetLogicHelper.d.class;
      }
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(45688);
        paramParcel.writeString(this.lCj);
        AppMethodBeat.o(45688);
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
        cr localcr = new cr();
        localcr.dFK.activity = bDF();
        localcr.dFK.dDX = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcr.dFK.dFL = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcr.dFK.dFM = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.e(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.a(paramProcessRequest));
        localcr.dFK.scene = 44;
        Bundle localBundle = new Bundle();
        localBundle.putInt("stat_scene", 6);
        localBundle.putString("stat_app_id", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.b(paramProcessRequest));
        localBundle.putString("stat_url", JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.c(paramProcessRequest));
        localcr.dFK.dFP = localBundle;
        EventCenter.instance.publish(localcr);
        AppMethodBeat.o(45670);
      }
    }
    
    static final class c
      implements com.tencent.mm.ipcinvoker.b<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult>
    {
      private boolean lCb = false;
      
      private void a(final JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam paramIPCQRCodeRecognizeParam, final com.tencent.mm.ipcinvoker.d<JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult> paramd, boolean paramBoolean)
      {
        AppMethodBeat.i(45674);
        if (paramBoolean) {}
        for (final String str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.a(paramIPCQRCodeRecognizeParam);; str = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.b(paramIPCQRCodeRecognizeParam))
        {
          Log.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", new Object[] { Boolean.valueOf(this.lCb), Boolean.valueOf(paramBoolean), str });
          this.lCb = paramBoolean;
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
        paramIPCQRCodeRecognizeParam = new qx();
        paramIPCQRCodeRecognizeParam.dXu.dDZ = System.currentTimeMillis();
        paramIPCQRCodeRecognizeParam.dXu.filePath = str;
        paramIPCQRCodeRecognizeParam.dXu.dXv = JsApiShowImageOperateSheet.BottomSheetLogicHelper.bEs();
        EventCenter.instance.publish(paramIPCQRCodeRecognizeParam);
        AppMethodBeat.o(45674);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet
 * JD-Core Version:    0.7.0.1
 */