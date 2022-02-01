package com.tencent.mm.plugin.appbrand.shortlink;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkRiskManager;", "", "()V", "IMAGE_WIDTH", "", "KEY_DATA", "", "KEY_DATA_MMKV_KEY", "KEY_LINK_URL", "QUALITY", "", "TAG", "uploadScreenshotToCdn", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "shortLink", "Task", "UploadResult", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaShortLinkRiskManager
{
  public static final WxaShortLinkRiskManager tVc;
  
  static
  {
    AppMethodBeat.i(321848);
    tVc = new WxaShortLinkRiskManager();
    AppMethodBeat.o(321848);
  }
  
  private static final void a(w paramw, ah paramah, String paramString, UploadResult paramUploadResult)
  {
    AppMethodBeat.i(321843);
    s.u(paramah, "$pageView");
    s.u(paramString, "$shortLink");
    int i;
    if (paramUploadResult.hCQ) {
      switch (paramw.qsh.eul)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      h.OAn.a(21830, true, true, true, new Object[] { paramah.getAppId(), Integer.valueOf(paramw.asw()), Integer.valueOf(i), paramString, paramUploadResult.fileUrl, paramah.cEE(), paramah.coY() });
      AppMethodBeat.o(321843);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public static void c(ah paramah, String paramString)
  {
    AppMethodBeat.i(321830);
    s.u(paramah, "pageView");
    s.u(paramString, "shortLink");
    Object localObject1 = paramah.cEW();
    if (localObject1 == null)
    {
      Log.e("MicroMsg.WxaShortLinkRiskManager", "uploadScreenshotToCdn screenshot null, appId:" + paramah.getAppId() + ", shortLink:" + paramString);
      AppMethodBeat.o(321830);
      return;
    }
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).setScale(720.0F / ((Bitmap)localObject1).getWidth(), 720.0F / ((Bitmap)localObject1).getWidth());
    localObject1 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2, true);
    s.s(localObject1, "createBitmap(screenshot,…hot.height, matrix, true)");
    localObject2 = new ByteArrayOutputStream();
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 10, (OutputStream)localObject2);
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    Log.i("MicroMsg.WxaShortLinkRiskManager", "data size %dBYTE", new Object[] { Integer.valueOf(localObject2.length) });
    localObject1 = new Bundle();
    Object localObject3 = com.tencent.mm.plugin.appbrand.ipc.a.a.rvP;
    s.s(localObject2, "data");
    localObject3 = com.tencent.mm.plugin.appbrand.ipc.a.a.aT((byte[])localObject2);
    if (((Boolean)((r)localObject3).bsC).booleanValue())
    {
      ((Bundle)localObject1).putString("data_mmkv_key", (String)((r)localObject3).bsD);
      Log.i("MicroMsg.WxaShortLinkRiskManager", "transfer data with mmkv");
    }
    for (;;)
    {
      ((Bundle)localObject1).putString("linkUrl", paramString);
      localObject2 = paramah.getRuntime();
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, a.class, new WxaShortLinkRiskManager..ExternalSyntheticLambda0((w)localObject2, paramah, paramString));
      AppMethodBeat.o(321830);
      return;
      ((Bundle)localObject1).putByteArray("data", (byte[])localObject2);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkRiskManager$UploadResult;", "Landroid/os/Parcelable;", "ret", "", "fileUrl", "", "(ZLjava/lang/String;)V", "getFileUrl", "()Ljava/lang/String;", "getRet", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class UploadResult
    implements Parcelable
  {
    public static final Parcelable.Creator<UploadResult> CREATOR;
    final String fileUrl;
    final boolean hCQ;
    
    static
    {
      AppMethodBeat.i(321802);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(321802);
    }
    
    public UploadResult(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(321791);
      this.hCQ = paramBoolean;
      this.fileUrl = paramString;
      AppMethodBeat.o(321791);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(321823);
      if (this == paramObject)
      {
        AppMethodBeat.o(321823);
        return true;
      }
      if (!(paramObject instanceof UploadResult))
      {
        AppMethodBeat.o(321823);
        return false;
      }
      paramObject = (UploadResult)paramObject;
      if (this.hCQ != paramObject.hCQ)
      {
        AppMethodBeat.o(321823);
        return false;
      }
      if (!s.p(this.fileUrl, paramObject.fileUrl))
      {
        AppMethodBeat.o(321823);
        return false;
      }
      AppMethodBeat.o(321823);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(321809);
      String str = "UploadResult(ret=" + this.hCQ + ", fileUrl=" + this.fileUrl + ')';
      AppMethodBeat.o(321809);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(321833);
      s.u(paramParcel, "out");
      if (this.hCQ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.fileUrl);
        AppMethodBeat.o(321833);
        return;
      }
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<WxaShortLinkRiskManager.UploadResult>
    {}
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkRiskManager$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeCallbackOnceTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkRiskManager$UploadResult;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.ipcinvoker.c<Bundle, WxaShortLinkRiskManager.UploadResult>
  {
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkRiskManager$Task$invoke$2", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "p2", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "p4", "", "decodePrepareResponse", "", "p0", "p1", "getCdnAuthInfo", "", "Ljava/io/ByteArrayOutputStream;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements g.a
    {
      a(f<WxaShortLinkRiskManager.UploadResult> paramf) {}
      
      public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, d paramd, boolean paramBoolean)
      {
        AppMethodBeat.i(321841);
        if (paramd == null)
        {
          paramString = this.mht;
          if (paramString != null) {
            paramString.onCallback(new WxaShortLinkRiskManager.UploadResult());
          }
          AppMethodBeat.o(321841);
          return 0;
        }
        if (paramInt != 0)
        {
          paramString = this.mht;
          if (paramString != null) {
            paramString.onCallback(new WxaShortLinkRiskManager.UploadResult());
          }
          Log.i("MicroMsg.WxaShortLinkRiskManager", "cdn upload failed, startRet : %d", new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(321841);
          return 0;
        }
        if (paramd.field_retCode != 0)
        {
          Log.e("MicroMsg.WxaShortLinkRiskManager", "cdn upload failed, retCode:%d sceneResult[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd });
          paramString = this.mht;
          if (paramString != null) {
            paramString.onCallback(new WxaShortLinkRiskManager.UploadResult());
          }
        }
        for (;;)
        {
          AppMethodBeat.o(321841);
          return 0;
          Log.i("MicroMsg.WxaShortLinkRiskManager", "cdn upload success, media id : %s  file url=%s   thumb url=%s", new Object[] { paramString, paramd.field_fileUrl, paramd.field_thumbUrl });
          paramString = this.mht;
          if (paramString != null)
          {
            paramc = paramd.field_fileUrl;
            s.s(paramc, "sceneResult.field_fileUrl");
            paramString.onCallback(new WxaShortLinkRiskManager.UploadResult(true, paramc));
          }
        }
      }
      
      public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
      
      public final byte[] h(String paramString, byte[] paramArrayOfByte)
      {
        return new byte[0];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkRiskManager
 * JD-Core Version:    0.7.0.1
 */