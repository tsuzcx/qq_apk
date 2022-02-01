package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import androidx.core.app.a.a;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage
  extends c
{
  public static final int CTRL_INDEX = 29;
  public static final String NAME = "chooseImage";
  boolean sfo = false;
  ChooseRequest sfp;
  AppBrandProxyUIProcessTask.b<JsApiChooseImage.ChooseResult> sfq;
  
  private boolean f(f paramf, int paramInt)
  {
    AppMethodBeat.i(329273);
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(329273);
      return false;
    }
    boolean bool = i.a((Activity)localContext, paramf, "android.permission.WRITE_EXTERNAL_STORAGE", 145, "", "");
    AppMethodBeat.o(329273);
    return bool;
  }
  
  private boolean g(f paramf, int paramInt)
  {
    AppMethodBeat.i(329275);
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(329275);
      return false;
    }
    boolean bool = i.a((Activity)localContext, paramf, "android.permission.CAMERA", 113, "", "");
    AppMethodBeat.o(329275);
    return bool;
  }
  
  private void h(final f paramf, final int paramInt)
  {
    AppMethodBeat.i(329277);
    s.c(paramf.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(329264);
        if (paramAnonymousInt == 145)
        {
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            Log.i("MicroMsg.JsApiChooseImage", "requestExternalStoragePermission permission is grant for choose image");
            a.b(paramf.getContext(), JsApiChooseImage.this.sfp, JsApiChooseImage.this.sfq);
          }
          for (;;)
          {
            s.afs(paramf.getAppId());
            JsApiChooseImage.this.sfo = false;
            AppMethodBeat.o(329264);
            return;
            Log.e("MicroMsg.JsApiChooseImage", "requestExternalStoragePermission sys perm denied for choose image");
            u.Uy(paramf.getAppId()).qvd = false;
            paramf.callback(paramInt, JsApiChooseImage.this.ZP("fail:system permission denied"));
          }
        }
        if (paramAnonymousInt == 113)
        {
          if ((paramAnonymousArrayOfInt == null) || (paramAnonymousArrayOfInt.length <= 0) || (paramAnonymousArrayOfInt[0] != 0)) {
            break label214;
          }
          Log.i("MicroMsg.JsApiChooseImage", "requestCameraPermission permission is grant for choose image");
          a.b(paramf.getContext(), JsApiChooseImage.this.sfp, JsApiChooseImage.this.sfq);
        }
        for (;;)
        {
          s.afs(paramf.getAppId());
          JsApiChooseImage.this.sfo = false;
          AppMethodBeat.o(329264);
          return;
          label214:
          Log.e("MicroMsg.JsApiChooseImage", "requestCameraPermission sys perm denied for choose image");
          u.Uy(paramf.getAppId()).qvd = false;
          paramf.callback(paramInt, JsApiChooseImage.this.ZP("fail:system permission denied"));
        }
      }
    });
    this.sfo = true;
    AppMethodBeat.o(329277);
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46425);
    if (paramf.getAppId() == null)
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(46425);
      return;
    }
    if (u.Ux(paramf.getAppId()).qvd)
    {
      paramf.callback(paramInt, ZP("cancel"));
      AppMethodBeat.o(46425);
      return;
    }
    final Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(46425);
      return;
    }
    this.sfp = new ChooseRequest();
    this.sfp.sfy = i.a(localContext, paramf, "android.permission.WRITE_EXTERNAL_STORAGE");
    Object localObject = paramJSONObject.optJSONArray("sourceType");
    String str1 = paramJSONObject.optString("sizeType");
    String str2 = paramJSONObject.optString("count");
    Log.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[] { localObject, str1, str2 });
    if ((localObject == null) || (((JSONArray)localObject).length() == 0)) {
      this.sfp.sft = true;
    }
    for (this.sfp.sfu = true;; this.sfp.sfu = ((JSONArray)localObject).toString().contains("album"))
    {
      u.Uy(paramf.getAppId()).qvd = true;
      k.a(paramf.getAppId(), new k.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(180217);
          if (paramf.getAppId() != null) {
            u.Uy(paramf.getAppId()).qvd = false;
          }
          k.b(paramf.getAppId(), this);
          AppMethodBeat.o(180217);
        }
      });
      localObject = str1;
      if (Util.isNullOrNil(str1)) {
        localObject = "compressed";
      }
      this.sfp.sfv = ((String)localObject).contains("compressed");
      this.sfp.sfw = ((String)localObject).contains("original");
      this.sfp.count = Util.getInt(str2, 9);
      this.sfp.appId = paramf.getAppId();
      this.sfq = new AppBrandProxyUIProcessTask.b() {};
      if ((!this.sfp.sft) || (!this.sfp.sfu)) {
        break;
      }
      o.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329249);
          JsApiChooseImage localJsApiChooseImage = JsApiChooseImage.this;
          Context localContext = paramf.getContext();
          u.i local1 = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(329364);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              while ((paramAnonymous2MenuItem.getItemId() == 1) && (!JsApiChooseImage.this.e(JsApiChooseImage.3.this.erj, JsApiChooseImage.3.this.elZ)))
              {
                Log.w("MicroMsg.JsApiChooseImage", "check camera permission fail");
                AppMethodBeat.o(329364);
                return;
                JsApiChooseImage.this.sfp.sfu = false;
                continue;
                JsApiChooseImage.this.sfp.sft = false;
              }
              if ((paramAnonymous2MenuItem.getItemId() == 2) && (!JsApiChooseImage.this.d(JsApiChooseImage.3.this.erj, JsApiChooseImage.3.this.elZ)))
              {
                Log.w("MicroMsg.JsApiChooseImage", "check external storage permission fail");
                AppMethodBeat.o(329364);
                return;
              }
              Log.i("MicroMsg.JsApiChooseImage", "start select after source choose");
              a.b(JsApiChooseImage.3.this.rXK, JsApiChooseImage.this.sfp, JsApiChooseImage.this.sfq);
              AppMethodBeat.o(329364);
            }
          };
          DialogInterface.OnCancelListener local2 = new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(329361);
              Log.i("MicroMsg.JsApiChooseImage", "cancel when select source from");
              u.Uy(JsApiChooseImage.3.this.erj.getAppId()).qvd = false;
              JsApiChooseImage.3.this.erj.callback(JsApiChooseImage.3.this.elZ, JsApiChooseImage.this.ZP("cancel"));
              AppMethodBeat.o(329361);
            }
          };
          l locall = new l(localContext);
          locall.a(new JsApiChooseImage.5(localJsApiChooseImage, local2));
          locall.a(null, new JsApiChooseImage.6(localJsApiChooseImage, localContext), local1, new JsApiChooseImage.7(localJsApiChooseImage, local2));
          AppMethodBeat.o(329249);
        }
      });
      AppMethodBeat.o(46425);
      return;
      this.sfp.sft = ((JSONArray)localObject).toString().contains("camera");
    }
    Log.i("MicroMsg.JsApiChooseImage", "start select");
    if ((this.sfp.sfu) && (!this.sfp.sft) && (!d(paramf, paramInt)))
    {
      Log.i("MicroMsg.JsApiChooseImage", "requestExternalStoragePermission fail, abort");
      AppMethodBeat.o(46425);
      return;
    }
    if ((!this.sfp.sfu) && (this.sfp.sft) && (!e(paramf, paramInt)))
    {
      Log.i("MicroMsg.JsApiChooseImage", "requestCameraPermission fail, abort");
      AppMethodBeat.o(46425);
      return;
    }
    a.b(localContext, this.sfp, this.sfq);
    AppMethodBeat.o(46425);
  }
  
  final boolean d(f paramf, int paramInt)
  {
    AppMethodBeat.i(329285);
    if (!this.sfo) {
      h(paramf, paramInt);
    }
    if (!f(paramf, paramInt))
    {
      Log.i("MicroMsg.JsApiChooseImage", "requestExternalStoragePermission fail, abort");
      AppMethodBeat.o(329285);
      return false;
    }
    s.afs(paramf.getAppId());
    this.sfo = false;
    AppMethodBeat.o(329285);
    return true;
  }
  
  final boolean e(f paramf, int paramInt)
  {
    AppMethodBeat.i(329287);
    if (!this.sfo) {
      h(paramf, paramInt);
    }
    if (!g(paramf, paramInt))
    {
      Log.i("MicroMsg.JsApiChooseImage", "requestCameraPermission fail, abort");
      AppMethodBeat.o(329287);
      return false;
    }
    s.afs(paramf.getAppId());
    this.sfo = false;
    AppMethodBeat.o(329287);
    return true;
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int count;
    boolean sft;
    boolean sfu;
    boolean sfv;
    boolean sfw;
    boolean sfx;
    boolean sfy;
    
    static
    {
      AppMethodBeat.i(46403);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46403);
    }
    
    ChooseRequest()
    {
      this.sfx = true;
    }
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46402);
      this.sfx = true;
      readParcel(paramParcel);
      AppMethodBeat.o(46402);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
    {
      return JsApiChooseImage.a.class;
    }
    
    public final String getUIAlias()
    {
      return "GalleryChooseImage";
    }
    
    public final boolean oneShotForeground()
    {
      boolean bool = true;
      if (!this.sfx)
      {
        this.sfx = true;
        bool = false;
      }
      return bool;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46400);
      this.appId = paramParcel.readString();
      this.count = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.sft = bool1;
        if (paramParcel.readByte() == 0) {
          break label104;
        }
        bool1 = true;
        label46:
        this.sfu = bool1;
        if (paramParcel.readByte() == 0) {
          break label109;
        }
        bool1 = true;
        label60:
        this.sfv = bool1;
        if (paramParcel.readByte() == 0) {
          break label114;
        }
        bool1 = true;
        label74:
        this.sfw = bool1;
        if (paramParcel.readByte() == 0) {
          break label119;
        }
      }
      label104:
      label109:
      label114:
      label119:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.sfy = bool1;
        AppMethodBeat.o(46400);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label46;
        bool1 = false;
        break label60;
        bool1 = false;
        break label74;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46401);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.count);
      if (this.sft)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.sfu) {
          break label106;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.sfv) {
          break label111;
        }
        b1 = 1;
        label61:
        paramParcel.writeByte(b1);
        if (!this.sfw) {
          break label116;
        }
        b1 = 1;
        label75:
        paramParcel.writeByte(b1);
        if (!this.sfy) {
          break label121;
        }
      }
      label106:
      label111:
      label116:
      label121:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(46401);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label47;
        b1 = 0;
        break label61;
        b1 = 0;
        break label75;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage
 * JD-Core Version:    0.7.0.1
 */