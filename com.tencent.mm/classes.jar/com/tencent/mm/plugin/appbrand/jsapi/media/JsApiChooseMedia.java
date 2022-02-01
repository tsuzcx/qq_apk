package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.MenuItem;
import androidx.core.app.a.a;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f.b;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMedia
  extends c
{
  public static final int CTRL_INDEX = 193;
  public static final String NAME = "chooseMedia";
  private static volatile boolean sfM = false;
  private boolean sfo = false;
  
  private void a(final f paramf, final int paramInt, ChooseRequest paramChooseRequest)
  {
    AppMethodBeat.i(329381);
    Log.e("MicroMsg.JsApiChooseMedia", "invokeInternalImpl");
    Context localContext = paramf.getContext();
    if (localContext == null)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
      paramf.callback(paramInt, ZP("fail:page context is null"));
      AppMethodBeat.o(329381);
      return;
    }
    if ((paramChooseRequest.sfP) && (!d(paramf, paramInt)))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestExternalStoragePermission is fail");
      AppMethodBeat.o(329381);
      return;
    }
    if ((paramChooseRequest.sfQ) && (paramChooseRequest.sfS)) {}
    for (int i = 1; (i != 0) && (!i(paramf, paramInt)); i = 0)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
      AppMethodBeat.o(329381);
      return;
    }
    if ((paramChooseRequest.sfQ) && ((paramChooseRequest.sfR) || (paramChooseRequest.sfS))) {}
    for (i = 1; (i != 0) && (!e(paramf, paramInt)); i = 0)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
      AppMethodBeat.o(329381);
      return;
    }
    s.afs(paramf.getAppId());
    this.sfo = false;
    Log.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
    sfM = true;
    k.a(paramf.getAppId(), new k.c()
    {
      public final void onResume()
      {
        AppMethodBeat.i(329384);
        Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
        JsApiChooseMedia.cth();
        k.b(paramf.getAppId(), this);
        AppMethodBeat.o(329384);
      }
    });
    a.a(localContext, paramChooseRequest, new AppBrandProxyUIProcessTask.b() {});
    AppMethodBeat.o(329381);
  }
  
  private boolean d(f paramf, int paramInt)
  {
    AppMethodBeat.i(329386);
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestExternalStoragePermission pageContext is null");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(329386);
      return false;
    }
    boolean bool = i.a((Activity)localContext, paramf, "android.permission.WRITE_EXTERNAL_STORAGE", 145, "", "");
    AppMethodBeat.o(329386);
    return bool;
  }
  
  private boolean e(f paramf, int paramInt)
  {
    AppMethodBeat.i(329390);
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(329390);
      return false;
    }
    boolean bool = i.a((Activity)localContext, paramf, "android.permission.CAMERA", 119, "", "");
    AppMethodBeat.o(329390);
    return bool;
  }
  
  private boolean i(f paramf, int paramInt)
  {
    AppMethodBeat.i(329389);
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(329389);
      return false;
    }
    boolean bool = i.a((Activity)localContext, paramf, "android.permission.RECORD_AUDIO", 120, "", "");
    AppMethodBeat.o(329389);
    return bool;
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46489);
    if (sfM)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
      paramf.callback(paramInt, ZP("cancel"));
      AppMethodBeat.o(46489);
      return;
    }
    Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia %s", new Object[] { paramJSONObject });
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
      paramf.callback(paramInt, ZP("fail:page context is null"));
      AppMethodBeat.o(46489);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(46489);
      return;
    }
    Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + paramJSONObject.toString());
    Object localObject1 = "";
    Object localObject2;
    if ((paramJSONObject.optJSONArray("sourceType") != null) && (paramJSONObject.optJSONArray("sourceType").length() > 0))
    {
      localObject1 = paramJSONObject.optJSONArray("sourceType").toString();
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = "camera|album";
      }
      localObject1 = "";
      if ((paramJSONObject.optJSONArray("mediaType") == null) || (paramJSONObject.optJSONArray("mediaType").length() <= 0)) {
        break label322;
      }
      localObject1 = paramJSONObject.optJSONArray("mediaType").toString();
    }
    Object localObject3;
    int i;
    for (;;)
    {
      localObject3 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject3 = "video|image";
      }
      i = Math.min(paramJSONObject.optInt("maxDuration", 10), 60);
      if ((i >= 3) && (i <= 60)) {
        break label333;
      }
      paramf.callback(paramInt, ZP("fail:error maxDuration"));
      AppMethodBeat.o(46489);
      return;
      Log.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
      break;
      label322:
      Log.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
    }
    label333:
    localObject1 = paramJSONObject.optString("camera");
    Object localObject4 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject4 = "back";
    }
    int j = Math.min(paramJSONObject.optInt("count", 9), 9);
    localObject1 = "";
    Object localObject5;
    if ((paramJSONObject.optJSONArray("sizeType") != null) && (paramJSONObject.optJSONArray("sizeType").length() > 0))
    {
      localObject1 = paramJSONObject.optJSONArray("sizeType").toString();
      localObject5 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject5 = "original|compressed";
      }
      Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { localObject2, localObject3, Integer.valueOf(i), localObject4, Integer.valueOf(j), localObject5 });
      localObject1 = new ChooseRequest();
      ((ChooseRequest)localObject1).appId = paramf.getAppId();
      ((ChooseRequest)localObject1).sfP = ((String)localObject2).contains("album");
      ((ChooseRequest)localObject1).sfQ = ((String)localObject2).contains("camera");
      ((ChooseRequest)localObject1).sfR = ((String)localObject3).contains("image");
      ((ChooseRequest)localObject1).sfS = ((String)localObject3).contains("video");
      ((ChooseRequest)localObject1).sfT = ((String)localObject3).contains("mix");
      ((ChooseRequest)localObject1).sfy = i.a(localContext, paramf, "android.permission.WRITE_EXTERNAL_STORAGE");
      if ((((String)localObject4).contains("back")) || (!((String)localObject4).contains("front"))) {
        break label729;
      }
    }
    label729:
    for (((ChooseRequest)localObject1).isFront = true;; ((ChooseRequest)localObject1).isFront = false)
    {
      ((ChooseRequest)localObject1).maxDuration = i;
      ((ChooseRequest)localObject1).count = j;
      ((ChooseRequest)localObject1).sfv = ((String)localObject5).contains("compressed");
      ((ChooseRequest)localObject1).sfw = ((String)localObject5).contains("original");
      if (!this.sfo)
      {
        s.c(paramf.getAppId(), new a.a()
        {
          public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
          {
            AppMethodBeat.i(329382);
            if (paramAnonymousInt == 145)
            {
              if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
              {
                Log.i("MicroMsg.JsApiChooseMedia", "requestExternalStoragePermission permission is grant for choose media");
                JsApiChooseMedia.a(JsApiChooseMedia.this, paramf, paramInt, this.sfN);
                AppMethodBeat.o(329382);
                return;
              }
              Log.e("MicroMsg.JsApiChooseMedia", "requestExternalStoragePermission sys perm denied for choose media");
              paramf.callback(paramInt, JsApiChooseMedia.this.ZP("fail:system permission denied"));
              s.afs(paramf.getAppId());
              JsApiChooseMedia.a(JsApiChooseMedia.this);
              AppMethodBeat.o(329382);
              return;
            }
            if (paramAnonymousInt == 119)
            {
              if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
              {
                Log.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                JsApiChooseMedia.a(JsApiChooseMedia.this, paramf, paramInt, this.sfN);
                AppMethodBeat.o(329382);
                return;
              }
              Log.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
              paramf.callback(paramInt, JsApiChooseMedia.this.ZP("fail:system permission denied"));
              s.afs(paramf.getAppId());
              JsApiChooseMedia.a(JsApiChooseMedia.this);
              AppMethodBeat.o(329382);
              return;
            }
            if (paramAnonymousInt == 120)
            {
              if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
              {
                Log.i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
                JsApiChooseMedia.a(JsApiChooseMedia.this, paramf, paramInt, this.sfN);
                AppMethodBeat.o(329382);
                return;
              }
              Log.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
              paramf.callback(paramInt, JsApiChooseMedia.this.ZP("fail:system permission denied"));
              s.afs(paramf.getAppId());
              JsApiChooseMedia.a(JsApiChooseMedia.this);
            }
            AppMethodBeat.o(329382);
          }
        });
        this.sfo = true;
      }
      if ((!((ChooseRequest)localObject1).sfP) || (!((ChooseRequest)localObject1).sfQ)) {
        break label738;
      }
      o.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329251);
          JsApiChooseMedia.a(JsApiChooseMedia.this, paramf, paramJSONObject, paramInt, this.sfN);
          AppMethodBeat.o(329251);
        }
      });
      AppMethodBeat.o(46489);
      return;
      Log.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
      break;
    }
    label738:
    a(paramf, paramInt, (ChooseRequest)localObject1);
    AppMethodBeat.o(46489);
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int count;
    boolean isFront;
    int maxDuration;
    boolean sfP;
    boolean sfQ;
    boolean sfR;
    boolean sfS;
    boolean sfT;
    boolean sfv;
    boolean sfw;
    boolean sfy;
    
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
      readParcel(paramParcel);
      AppMethodBeat.o(46435);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
    {
      return JsApiChooseMedia.a.class;
    }
    
    public final String getUIAlias()
    {
      return "GalleryChooseMedia";
    }
    
    public final boolean oneShotForeground()
    {
      return true;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46433);
      this.appId = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.sfP = bool1;
        if (paramParcel.readByte() == 0) {
          break label168;
        }
        bool1 = true;
        label38:
        this.sfQ = bool1;
        if (paramParcel.readByte() == 0) {
          break label173;
        }
        bool1 = true;
        label52:
        this.sfR = bool1;
        if (paramParcel.readByte() == 0) {
          break label178;
        }
        bool1 = true;
        label66:
        this.sfS = bool1;
        if (paramParcel.readByte() == 0) {
          break label183;
        }
        bool1 = true;
        label80:
        this.sfT = bool1;
        if (paramParcel.readByte() == 0) {
          break label188;
        }
        bool1 = true;
        label94:
        this.isFront = bool1;
        this.maxDuration = paramParcel.readInt();
        this.count = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label193;
        }
        bool1 = true;
        label124:
        this.sfv = bool1;
        if (paramParcel.readByte() == 0) {
          break label198;
        }
        bool1 = true;
        label138:
        this.sfw = bool1;
        if (paramParcel.readByte() == 0) {
          break label203;
        }
      }
      label168:
      label173:
      label178:
      label183:
      label188:
      label193:
      label198:
      label203:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.sfy = bool1;
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
        break label94;
        bool1 = false;
        break label124;
        bool1 = false;
        break label138;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46434);
      paramParcel.writeString(this.appId);
      if (this.sfP)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.sfQ) {
          break label170;
        }
        b1 = 1;
        label39:
        paramParcel.writeByte(b1);
        if (!this.sfR) {
          break label175;
        }
        b1 = 1;
        label53:
        paramParcel.writeByte(b1);
        if (!this.sfS) {
          break label180;
        }
        b1 = 1;
        label67:
        paramParcel.writeByte(b1);
        if (!this.sfT) {
          break label185;
        }
        b1 = 1;
        label81:
        paramParcel.writeByte(b1);
        if (!this.isFront) {
          break label190;
        }
        b1 = 1;
        label95:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.maxDuration);
        paramParcel.writeInt(this.count);
        if (!this.sfv) {
          break label195;
        }
        b1 = 1;
        label125:
        paramParcel.writeByte(b1);
        if (!this.sfw) {
          break label200;
        }
        b1 = 1;
        label139:
        paramParcel.writeByte(b1);
        if (!this.sfy) {
          break label205;
        }
      }
      label170:
      label175:
      label180:
      label185:
      label190:
      label195:
      label200:
      label205:
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
        break label95;
        b1 = 0;
        break label125;
        b1 = 0;
        break label139;
      }
    }
  }
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    int resultCode;
    String sfU;
    String type;
    
    static
    {
      AppMethodBeat.i(46441);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46441);
    }
    
    ChooseResult() {}
    
    ChooseResult(Parcel paramParcel)
    {
      AppMethodBeat.i(46440);
      readParcel(paramParcel);
      AppMethodBeat.o(46440);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(46438);
      this.resultCode = paramParcel.readInt();
      this.type = paramParcel.readString();
      this.sfU = paramParcel.readString();
      AppMethodBeat.o(46438);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46439);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.sfU);
      AppMethodBeat.o(46439);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia
 * JD-Core Version:    0.7.0.1
 */