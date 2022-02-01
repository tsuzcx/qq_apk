package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;

public final class JsApiAddToFavorites
  extends a<c>
{
  public static final int CTRL_INDEX = 800;
  public static final String NAME = "addToFavorites";
  
  private static void a(b.a parama, aa paramaa, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(186561);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        ac.i("MicroMsg.JsApiAddToFavorites", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramaa.getAppId(), Integer.valueOf(paramaa.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        parama.Jr(paramString);
      }
      for (;;)
      {
        return;
        ac.w("MicroMsg.JsApiAddToFavorites", "snapshot can not be taken");
        parama.Jr("");
      }
      AppMethodBeat.o(186561);
    }
    catch (Exception paramaa)
    {
      ac.w("MicroMsg.JsApiAddToFavorites", "save temp bitmap to file failed, . exception : %s", new Object[] { paramaa });
      parama.Jr("");
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(186561);
    }
  }
  
  static final class IPCFavRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<IPCFavRequest> CREATOR;
    String appId;
    String cYQ;
    int ccR;
    String dxK;
    int hxM;
    String iconUrl;
    String jWW;
    int jWX;
    boolean jWY;
    int scene;
    int subType;
    String title;
    String username;
    int version;
    
    static
    {
      AppMethodBeat.i(186550);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(186550);
    }
    
    protected IPCFavRequest() {}
    
    protected IPCFavRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(186548);
      this.username = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.cYQ = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.hxM = paramParcel.readInt();
      this.title = paramParcel.readString();
      this.jWW = paramParcel.readString();
      this.jWX = paramParcel.readInt();
      this.ccR = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.dxK = paramParcel.readString();
      this.subType = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jWY = bool;
        AppMethodBeat.o(186548);
        return;
        bool = false;
      }
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bdj()
    {
      return JsApiAddToFavorites.a.class;
    }
    
    public final boolean beq()
    {
      return this.jWY;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(186549);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.cYQ);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.hxM);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jWW);
      paramParcel.writeInt(this.jWX);
      paramParcel.writeInt(this.ccR);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.dxK);
      paramParcel.writeInt(this.subType);
      if (this.jWY) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(186549);
        return;
      }
    }
  }
  
  static final class IPCFavResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<IPCFavResult> CREATOR;
    int ret;
    
    static
    {
      AppMethodBeat.i(186555);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(186555);
    }
    
    protected IPCFavResult() {}
    
    protected IPCFavResult(Parcel paramParcel)
    {
      AppMethodBeat.i(186552);
      j(paramParcel);
      AppMethodBeat.o(186552);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(186553);
      this.ret = paramParcel.readInt();
      AppMethodBeat.o(186553);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(186554);
      paramParcel.writeInt(this.ret);
      AppMethodBeat.o(186554);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites
 * JD-Core Version:    0.7.0.1
 */