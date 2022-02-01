package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.a.a;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 29;
  public static final String NAME = "chooseImage";
  private static Boolean kWS = null;
  
  private static boolean blR()
  {
    AppMethodBeat.i(222578);
    if (kWS == null)
    {
      ae.i("MicroMsg.JsApiChooseImage", "inti wx style field");
      kWS = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEt, false));
    }
    if (kWS == null)
    {
      ae.e("MicroMsg.JsApiChooseImage", "get shoot style fail, use default style");
      AppMethodBeat.o(222578);
      return false;
    }
    ae.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot, flag: %b", new Object[] { kWS });
    boolean bool = kWS.booleanValue();
    AppMethodBeat.o(222578);
    return bool;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46425);
    if (paramc.getAppId() == null)
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46425);
      return;
    }
    if (o.Ld(paramc.getAppId()).jBZ)
    {
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46425);
      return;
    }
    final Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46425);
      return;
    }
    final ChooseRequest localChooseRequest = new ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str1 = paramJSONObject.optString("sizeType");
    String str2 = paramJSONObject.optString("count");
    ae.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[] { localJSONArray, str1, str2 });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.kWX = true;
      localChooseRequest.kWY = true;
      if (!localChooseRequest.kWX) {
        break label343;
      }
      r.b(paramc.getAppId(), new a.a()
      {
        public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(222562);
          if (paramAnonymousInt != 113)
          {
            AppMethodBeat.o(222562);
            return;
          }
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            JsApiChooseImage.this.a(paramc, paramJSONObject, paramInt);
            AppMethodBeat.o(222562);
            return;
          }
          paramc.h(paramInt, JsApiChooseImage.this.e("fail:system permission denied", null));
          AppMethodBeat.o(222562);
        }
      });
      paramJSONObject = paramc.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label301;
      }
      paramc.h(paramInt, e("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label343;
      }
      AppMethodBeat.o(46425);
      return;
      localChooseRequest.kWX = localJSONArray.toString().contains("camera");
      localChooseRequest.kWY = localJSONArray.toString().contains("album");
      break;
      label301:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
      i = bool;
      if (bool)
      {
        r.UC(paramc.getAppId());
        i = bool;
      }
    }
    label343:
    o.Le(paramc.getAppId()).jBZ = true;
    h.a(paramc.getAppId(), new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(180217);
        if (paramc.getAppId() != null) {
          o.Le(paramc.getAppId()).jBZ = false;
        }
        h.b(paramc.getAppId(), this);
        AppMethodBeat.o(180217);
      }
    });
    if (bu.isNullOrNil(str1)) {}
    for (paramJSONObject = "compressed";; paramJSONObject = str1)
    {
      localChooseRequest.kWZ = paramJSONObject.contains("compressed");
      localChooseRequest.kXa = paramJSONObject.contains("original");
      localChooseRequest.count = bu.getInt(str2, 9);
      localChooseRequest.appId = paramc.getAppId();
      paramJSONObject = new AppBrandProxyUIProcessTask.b() {};
      if ((localChooseRequest.kWX) && (localChooseRequest.kWY) && (blR()))
      {
        com.tencent.mm.plugin.appbrand.y.m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222561);
            JsApiChooseImage.a(JsApiChooseImage.this, paramc.getContext(), new n.e()new DialogInterface.OnCancelListener
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(222559);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  ae.i("MicroMsg.JsApiChooseImage", "start select after source choose");
                  com.tencent.mm.plugin.appbrand.ipc.a.b(JsApiChooseImage.3.this.kQk, JsApiChooseImage.3.this.kWU, JsApiChooseImage.3.this.kWV);
                  AppMethodBeat.o(222559);
                  return;
                  JsApiChooseImage.3.this.kWU.kWY = false;
                  continue;
                  JsApiChooseImage.3.this.kWU.kWX = false;
                }
              }
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(222560);
                ae.i("MicroMsg.JsApiChooseImage", "cancel when select source from");
                o.Le(JsApiChooseImage.3.this.cnL.getAppId()).jBZ = false;
                JsApiChooseImage.3.this.cnL.h(JsApiChooseImage.3.this.cjS, JsApiChooseImage.this.e("cancel", null));
                AppMethodBeat.o(222560);
              }
            });
            AppMethodBeat.o(222561);
          }
        });
        AppMethodBeat.o(46425);
        return;
      }
      ae.i("MicroMsg.JsApiChooseImage", "start select");
      com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localChooseRequest, paramJSONObject);
      AppMethodBeat.o(46425);
      return;
    }
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int count;
    boolean kWX;
    boolean kWY;
    boolean kWZ;
    boolean kXa;
    boolean kXb;
    
    static
    {
      AppMethodBeat.i(46403);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46403);
    }
    
    ChooseRequest()
    {
      this.kXb = true;
    }
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46402);
      this.kXb = true;
      j(paramParcel);
      AppMethodBeat.o(46402);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bhv()
    {
      return JsApiChooseImage.a.class;
    }
    
    public final boolean biA()
    {
      boolean bool = true;
      if (!this.kXb)
      {
        this.kXb = true;
        bool = false;
      }
      return bool;
    }
    
    public final String biB()
    {
      return "GalleryChooseImage";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46400);
      this.appId = paramParcel.readString();
      this.count = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.kWX = bool1;
        if (paramParcel.readByte() == 0) {
          break label90;
        }
        bool1 = true;
        label46:
        this.kWY = bool1;
        if (paramParcel.readByte() == 0) {
          break label95;
        }
        bool1 = true;
        label60:
        this.kWZ = bool1;
        if (paramParcel.readByte() == 0) {
          break label100;
        }
      }
      label90:
      label95:
      label100:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kXa = bool1;
        AppMethodBeat.o(46400);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label46;
        bool1 = false;
        break label60;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46401);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.count);
      if (this.kWX)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.kWY) {
          break label92;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.kWZ) {
          break label97;
        }
        b1 = 1;
        label61:
        paramParcel.writeByte(b1);
        if (!this.kXa) {
          break label102;
        }
      }
      label92:
      label97:
      label102:
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
      }
    }
  }
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    int bZU;
    ArrayList<AppBrandLocalMediaObject> kXc;
    
    static
    {
      AppMethodBeat.i(46407);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46407);
    }
    
    ChooseResult() {}
    
    ChooseResult(Parcel paramParcel)
    {
      super();
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(46405);
      this.bZU = paramParcel.readInt();
      this.kXc = paramParcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
      AppMethodBeat.o(46405);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46406);
      paramParcel.writeInt(this.bZU);
      paramParcel.writeTypedList(this.kXc);
      AppMethodBeat.o(46406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage
 * JD-Core Version:    0.7.0.1
 */