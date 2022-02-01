package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo
  extends d
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  private static volatile boolean mdp = false;
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46571);
    if (mdp)
    {
      paramf.i(paramInt, h("cancel", null));
      AppMethodBeat.o(46571);
      return;
    }
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(46571);
      return;
    }
    ChooseRequest localChooseRequest = new ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str = paramJSONObject.optString("maxDuration");
    Log.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[] { localJSONArray, str });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.mch = true;
      localChooseRequest.mci = true;
      localChooseRequest.mdr = paramJSONObject.optBoolean("compressed", true);
      if (!localChooseRequest.mch) {
        break label304;
      }
      r.a(paramf.getAppId(), new a.a()
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
            JsApiChooseVideo.this.a(paramf, paramJSONObject, paramInt);
            AppMethodBeat.o(46546);
            return;
          }
          paramf.i(paramInt, JsApiChooseVideo.this.h("fail:system permission denied", null));
          AppMethodBeat.o(46546);
        }
      });
      paramJSONObject = paramf.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label262;
      }
      paramf.i(paramInt, h("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label304;
      }
      AppMethodBeat.o(46571);
      return;
      localChooseRequest.mch = localJSONArray.toString().contains("camera");
      localChooseRequest.mci = localJSONArray.toString().contains("album");
      break;
      label262:
      boolean bool = b.a((Activity)paramJSONObject, "android.permission.CAMERA", 115, "", "");
      i = bool;
      if (bool)
      {
        r.aeq(paramf.getAppId());
        i = bool;
      }
    }
    label304:
    mdp = true;
    h.a(paramf.getAppId(), new h.c()
    {
      public final void onResume()
      {
        AppMethodBeat.i(46544);
        JsApiChooseVideo.TT();
        h.b(paramf.getAppId(), this);
        AppMethodBeat.o(46544);
      }
    });
    localChooseRequest.maxDuration = Util.getInt(str, 60);
    localChooseRequest.appId = paramf.getAppId();
    a.b(localContext, localChooseRequest, new JsApiChooseVideo.2(this, paramf, paramInt));
    AppMethodBeat.o(46571);
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int maxDuration;
    boolean mch;
    boolean mci;
    boolean mdr;
    
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
      k(paramParcel);
      AppMethodBeat.o(46550);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bCJ()
    {
      return JsApiChooseVideo.a.class;
    }
    
    public final boolean bDN()
    {
      return true;
    }
    
    public final String bDO()
    {
      return "GalleryChooseVideo";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46548);
      this.appId = paramParcel.readString();
      this.maxDuration = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.mch = bool1;
        if (paramParcel.readByte() == 0) {
          break label76;
        }
        bool1 = true;
        label46:
        this.mci = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label76:
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.mdr = bool1;
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
      if (this.mch)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.mci) {
          break label78;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.mdr) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo
 * JD-Core Version:    0.7.0.1
 */