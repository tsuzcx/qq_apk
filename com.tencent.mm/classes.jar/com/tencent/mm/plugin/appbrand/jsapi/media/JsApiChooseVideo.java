package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  private static volatile boolean kYf = false;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46571);
    if (kYf)
    {
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46571);
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46571);
      return;
    }
    ChooseRequest localChooseRequest = new ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str = paramJSONObject.optString("maxDuration");
    ae.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[] { localJSONArray, str });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.kWX = true;
      localChooseRequest.kWY = true;
      localChooseRequest.kYh = paramJSONObject.optBoolean("compressed", true);
      if (!localChooseRequest.kWX) {
        break label304;
      }
      r.a(paramc.getAppId(), new a.a()
      {
        public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(46546);
          if (paramAnonymousInt != 115)
          {
            AppMethodBeat.o(46546);
            return;
          }
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            JsApiChooseVideo.this.a(paramc, paramJSONObject, paramInt);
            AppMethodBeat.o(46546);
            return;
          }
          paramc.h(paramInt, JsApiChooseVideo.this.e("fail:system permission denied", null));
          AppMethodBeat.o(46546);
        }
      });
      paramJSONObject = paramc.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label262;
      }
      paramc.h(paramInt, e("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label304;
      }
      AppMethodBeat.o(46571);
      return;
      localChooseRequest.kWX = localJSONArray.toString().contains("camera");
      localChooseRequest.kWY = localJSONArray.toString().contains("album");
      break;
      label262:
      boolean bool = b.a((Activity)paramJSONObject, "android.permission.CAMERA", 115, "", "");
      i = bool;
      if (bool)
      {
        r.UC(paramc.getAppId());
        i = bool;
      }
    }
    label304:
    kYf = true;
    h.a(paramc.getAppId(), new h.c()
    {
      public final void onResume()
      {
        AppMethodBeat.i(46544);
        JsApiChooseVideo.JG();
        h.b(paramc.getAppId(), this);
        AppMethodBeat.o(46544);
      }
    });
    localChooseRequest.maxDuration = bu.getInt(str, 60);
    localChooseRequest.appId = paramc.getAppId();
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localChooseRequest, new AppBrandProxyUIProcessTask.b() {});
    AppMethodBeat.o(46571);
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    boolean kWX;
    boolean kWY;
    boolean kYh;
    int maxDuration;
    
    static
    {
      AppMethodBeat.i(46551);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46551);
    }
    
    ChooseRequest() {}
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46550);
      j(paramParcel);
      AppMethodBeat.o(46550);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bhv()
    {
      return JsApiChooseVideo.a.class;
    }
    
    public final boolean biA()
    {
      return true;
    }
    
    public final String biB()
    {
      return "GalleryChooseVideo";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46548);
      this.appId = paramParcel.readString();
      this.maxDuration = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.kWX = bool1;
        if (paramParcel.readByte() == 0) {
          break label76;
        }
        bool1 = true;
        label46:
        this.kWY = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label76:
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kYh = bool1;
        AppMethodBeat.o(46548);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label46;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46549);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.maxDuration);
      if (this.kWX)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.kWY) {
          break label78;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.kYh) {
          break label83;
        }
      }
      label78:
      label83:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(46549);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label47;
      }
    }
  }
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    int bZU;
    AppBrandLocalVideoObject kYi;
    
    static
    {
      AppMethodBeat.i(46556);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46556);
    }
    
    ChooseResult() {}
    
    ChooseResult(Parcel paramParcel)
    {
      AppMethodBeat.i(46555);
      j(paramParcel);
      AppMethodBeat.o(46555);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(46553);
      this.bZU = paramParcel.readInt();
      this.kYi = ((AppBrandLocalVideoObject)paramParcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader()));
      AppMethodBeat.o(46553);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46554);
      paramParcel.writeInt(this.bZU);
      paramParcel.writeParcelable(this.kYi, paramInt);
      AppMethodBeat.o(46554);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo
 * JD-Core Version:    0.7.0.1
 */