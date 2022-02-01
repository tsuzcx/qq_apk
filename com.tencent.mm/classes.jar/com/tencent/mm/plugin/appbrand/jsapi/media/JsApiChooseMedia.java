package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMedia
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 193;
  public static final String NAME = "chooseMedia";
  private static volatile boolean jWS = false;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46489);
    if (jWS)
    {
      ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46489);
      return;
    }
    Context localContext1 = paramc.getContext();
    if ((localContext1 == null) || (!(localContext1 instanceof Activity)))
    {
      ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
      paramc.h(paramInt, e("fail:page context is null", null));
      AppMethodBeat.o(46489);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(46489);
      return;
    }
    ad.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + paramJSONObject.toString());
    String str1 = "";
    if ((paramJSONObject.optJSONArray("sourceType") != null) && (paramJSONObject.optJSONArray("sourceType").length() > 0))
    {
      str1 = paramJSONObject.optJSONArray("sourceType").toString();
      if (!bt.isNullOrNil(str1)) {
        break label890;
      }
    }
    label225:
    label877:
    label883:
    label890:
    for (String str2 = "camera|album";; str2 = str1)
    {
      str1 = "";
      if ((paramJSONObject.optJSONArray("mediaType") != null) && (paramJSONObject.optJSONArray("mediaType").length() > 0))
      {
        str1 = paramJSONObject.optJSONArray("mediaType").toString();
        if (!bt.isNullOrNil(str1)) {
          break label883;
        }
      }
      for (String str3 = "video|image";; str3 = str1)
      {
        int i = Math.min(paramJSONObject.optInt("maxDuration", 10), 60);
        if ((i < 3) || (i > 60))
        {
          paramc.h(paramInt, e("fail:error maxDuration", null));
          AppMethodBeat.o(46489);
          return;
          ad.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
          break;
          ad.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
          break label225;
        }
        String str4 = paramJSONObject.optString("camera");
        if (bt.isNullOrNil(str4)) {
          str4 = "back";
        }
        for (;;)
        {
          int j = Math.min(paramJSONObject.optInt("count", 9), 9);
          str1 = "";
          if ((paramJSONObject.optJSONArray("sizeType") != null) && (paramJSONObject.optJSONArray("sizeType").length() > 0))
          {
            str1 = paramJSONObject.optJSONArray("sizeType").toString();
            if (!bt.isNullOrNil(str1)) {
              break label877;
            }
            str1 = "original|compressed";
          }
          for (;;)
          {
            ad.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { str2, str3, Integer.valueOf(i), str4, Integer.valueOf(j), str1 });
            o.b(paramc.getAppId(), new a.a()
            {
              public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
              {
                AppMethodBeat.i(46430);
                if (paramAnonymousInt != 120)
                {
                  ad.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission requestCode is not for choose media");
                  AppMethodBeat.o(46430);
                  return;
                }
                if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
                {
                  ad.i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
                  JsApiChooseMedia.this.a(paramc, paramJSONObject, paramInt);
                  AppMethodBeat.o(46430);
                  return;
                }
                ad.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
                paramc.h(paramInt, JsApiChooseMedia.this.e("fail:system permission denied", null));
                AppMethodBeat.o(46430);
              }
            });
            Context localContext2 = paramc.getContext();
            int k;
            if ((localContext2 == null) || (!(localContext2 instanceof Activity)))
            {
              ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
              paramc.h(paramInt, e("fail", null));
              k = 0;
            }
            boolean bool;
            for (;;)
            {
              if (k != 0) {
                break label572;
              }
              ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
              AppMethodBeat.o(46489);
              return;
              ad.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
              break;
              bool = b.a((Activity)localContext2, "android.permission.RECORD_AUDIO", 120, "", "");
              k = bool;
              if (bool)
              {
                o.Mi(paramc.getAppId());
                k = bool;
              }
            }
            o.b(paramc.getAppId(), new a.a()
            {
              public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
              {
                AppMethodBeat.i(46431);
                if (paramAnonymousInt != 119)
                {
                  ad.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
                  AppMethodBeat.o(46431);
                  return;
                }
                if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
                {
                  ad.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                  JsApiChooseMedia.this.a(paramc, paramJSONObject, paramInt);
                  AppMethodBeat.o(46431);
                  return;
                }
                ad.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
                paramc.h(paramInt, JsApiChooseMedia.this.e("fail:system permission denied", null));
                AppMethodBeat.o(46431);
              }
            });
            paramJSONObject = paramc.getContext();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof Activity)))
            {
              ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
              paramc.h(paramInt, e("fail", null));
              k = 0;
            }
            while (k == 0)
            {
              ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
              AppMethodBeat.o(46489);
              return;
              bool = b.a((Activity)paramJSONObject, "android.permission.CAMERA", 119, "", "");
              k = bool;
              if (bool)
              {
                o.Mi(paramc.getAppId());
                k = bool;
              }
            }
            ad.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
            jWS = true;
            g.a(paramc.getAppId(), new g.c()
            {
              public final void onResume()
              {
                AppMethodBeat.i(46428);
                ad.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
                JsApiChooseMedia.acT();
                g.b(paramc.getAppId(), this);
                AppMethodBeat.o(46428);
              }
            });
            paramJSONObject = new ChooseRequest();
            paramJSONObject.appId = paramc.getAppId();
            paramJSONObject.jWU = str2.contains("album");
            paramJSONObject.jWV = str2.contains("camera");
            paramJSONObject.jWW = str3.contains("image");
            paramJSONObject.jWX = str3.contains("video");
            if ((!str4.contains("back")) && (str4.contains("front"))) {}
            for (paramJSONObject.isFront = true;; paramJSONObject.isFront = false)
            {
              paramJSONObject.maxDuration = i;
              paramJSONObject.count = j;
              paramJSONObject.jWy = str1.contains("compressed");
              paramJSONObject.jWz = str1.contains("original");
              com.tencent.mm.plugin.appbrand.ipc.a.a(localContext1, paramJSONObject, new AppBrandProxyUIProcessTask.b() {});
              AppMethodBeat.o(46489);
              return;
            }
          }
        }
      }
    }
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int count;
    boolean isFront;
    boolean jWU;
    boolean jWV;
    boolean jWW;
    boolean jWX;
    boolean jWy;
    boolean jWz;
    int maxDuration;
    
    static
    {
      AppMethodBeat.i(46436);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46436);
    }
    
    ChooseRequest() {}
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46435);
      j(paramParcel);
      AppMethodBeat.o(46435);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> aWl()
    {
      return JsApiChooseMedia.a.class;
    }
    
    public final boolean aXq()
    {
      return true;
    }
    
    public final String aXr()
    {
      return "GalleryChooseMedia";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46433);
      this.appId = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.jWU = bool1;
        if (paramParcel.readByte() == 0) {
          break label140;
        }
        bool1 = true;
        label38:
        this.jWV = bool1;
        if (paramParcel.readByte() == 0) {
          break label145;
        }
        bool1 = true;
        label52:
        this.jWW = bool1;
        if (paramParcel.readByte() == 0) {
          break label150;
        }
        bool1 = true;
        label66:
        this.jWX = bool1;
        if (paramParcel.readByte() == 0) {
          break label155;
        }
        bool1 = true;
        label80:
        this.isFront = bool1;
        this.maxDuration = paramParcel.readInt();
        this.count = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label160;
        }
        bool1 = true;
        label110:
        this.jWy = bool1;
        if (paramParcel.readByte() == 0) {
          break label165;
        }
      }
      label140:
      label145:
      label150:
      label155:
      label160:
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jWz = bool1;
        AppMethodBeat.o(46433);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label38;
        bool1 = false;
        break label52;
        bool1 = false;
        break label66;
        bool1 = false;
        break label80;
        bool1 = false;
        break label110;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46434);
      paramParcel.writeString(this.appId);
      if (this.jWU)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.jWV) {
          break label142;
        }
        b1 = 1;
        label39:
        paramParcel.writeByte(b1);
        if (!this.jWW) {
          break label147;
        }
        b1 = 1;
        label53:
        paramParcel.writeByte(b1);
        if (!this.jWX) {
          break label152;
        }
        b1 = 1;
        label67:
        paramParcel.writeByte(b1);
        if (!this.isFront) {
          break label157;
        }
        b1 = 1;
        label81:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.maxDuration);
        paramParcel.writeInt(this.count);
        if (!this.jWy) {
          break label162;
        }
        b1 = 1;
        label111:
        paramParcel.writeByte(b1);
        if (!this.jWz) {
          break label167;
        }
      }
      label142:
      label147:
      label152:
      label157:
      label162:
      label167:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(46434);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label39;
        b1 = 0;
        break label53;
        b1 = 0;
        break label67;
        b1 = 0;
        break label81;
        b1 = 0;
        break label111;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia
 * JD-Core Version:    0.7.0.1
 */