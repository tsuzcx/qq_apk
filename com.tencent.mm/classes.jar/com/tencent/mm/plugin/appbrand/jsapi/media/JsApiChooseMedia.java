package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import androidx.core.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class JsApiChooseMedia
  extends c
{
  public static final int CTRL_INDEX = 193;
  public static final String NAME = "chooseMedia";
  private static volatile boolean pat = false;
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46489);
    if (pat)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
      parame.j(paramInt, h("cancel", null));
      AppMethodBeat.o(46489);
      return;
    }
    Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia %s", new Object[] { paramJSONObject });
    Context localContext1 = parame.getContext();
    if ((localContext1 == null) || (!(localContext1 instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
      parame.j(paramInt, h("fail:page context is null", null));
      AppMethodBeat.o(46489);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
      parame.j(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(46489);
      return;
    }
    Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + paramJSONObject.toString());
    String str1 = "";
    if ((paramJSONObject.optJSONArray("sourceType") != null) && (paramJSONObject.optJSONArray("sourceType").length() > 0))
    {
      str1 = paramJSONObject.optJSONArray("sourceType").toString();
      if (!Util.isNullOrNil(str1)) {
        break label920;
      }
    }
    label907:
    label913:
    label920:
    for (String str2 = "camera|album";; str2 = str1)
    {
      str1 = "";
      if ((paramJSONObject.optJSONArray("mediaType") != null) && (paramJSONObject.optJSONArray("mediaType").length() > 0))
      {
        str1 = paramJSONObject.optJSONArray("mediaType").toString();
        label240:
        if (!Util.isNullOrNil(str1)) {
          break label913;
        }
      }
      for (String str3 = "video|image";; str3 = str1)
      {
        int i = Math.min(paramJSONObject.optInt("maxDuration", 10), 60);
        if ((i < 3) || (i > 60))
        {
          parame.j(paramInt, h("fail:error maxDuration", null));
          AppMethodBeat.o(46489);
          return;
          Log.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
          break;
          Log.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
          break label240;
        }
        String str4 = paramJSONObject.optString("camera");
        if (Util.isNullOrNil(str4)) {
          str4 = "back";
        }
        for (;;)
        {
          int j = Math.min(paramJSONObject.optInt("count", 9), 9);
          str1 = "";
          if ((paramJSONObject.optJSONArray("sizeType") != null) && (paramJSONObject.optJSONArray("sizeType").length() > 0))
          {
            str1 = paramJSONObject.optJSONArray("sizeType").toString();
            if (!Util.isNullOrNil(str1)) {
              break label907;
            }
            str1 = "original|compressed";
          }
          for (;;)
          {
            Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { str2, str3, Integer.valueOf(i), str4, Integer.valueOf(j), str1 });
            com.tencent.mm.plugin.appbrand.permission.r.b(parame.getAppId(), new a.a()
            {
              public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
              {
                AppMethodBeat.i(46430);
                if (paramAnonymousInt != 120)
                {
                  Log.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission requestCode is not for choose media");
                  AppMethodBeat.o(46430);
                  return;
                }
                if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
                {
                  Log.i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
                  JsApiChooseMedia.this.a(parame, paramJSONObject, paramInt);
                  AppMethodBeat.o(46430);
                  return;
                }
                Log.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
                parame.j(paramInt, JsApiChooseMedia.this.h("fail:system permission denied", null));
                AppMethodBeat.o(46430);
              }
            });
            Context localContext2 = parame.getContext();
            int k;
            if ((localContext2 == null) || (!(localContext2 instanceof Activity)))
            {
              Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
              parame.j(paramInt, h("fail", null));
              k = 0;
            }
            boolean bool;
            for (;;)
            {
              if (k != 0) {
                break label587;
              }
              Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
              AppMethodBeat.o(46489);
              return;
              Log.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
              break;
              bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext2, "android.permission.RECORD_AUDIO", 120, "", "");
              k = bool;
              if (bool)
              {
                com.tencent.mm.plugin.appbrand.permission.r.amk(parame.getAppId());
                k = bool;
              }
            }
            label587:
            com.tencent.mm.plugin.appbrand.permission.r.b(parame.getAppId(), new a.a()
            {
              public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
              {
                AppMethodBeat.i(46431);
                if (paramAnonymousInt != 119)
                {
                  Log.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
                  AppMethodBeat.o(46431);
                  return;
                }
                if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
                {
                  Log.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                  JsApiChooseMedia.this.a(parame, paramJSONObject, paramInt);
                  AppMethodBeat.o(46431);
                  return;
                }
                Log.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
                parame.j(paramInt, JsApiChooseMedia.this.h("fail:system permission denied", null));
                AppMethodBeat.o(46431);
              }
            });
            paramJSONObject = parame.getContext();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof Activity)))
            {
              Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
              parame.j(paramInt, h("fail", null));
              k = 0;
            }
            while (k == 0)
            {
              Log.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
              AppMethodBeat.o(46489);
              return;
              bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 119, "", "");
              k = bool;
              if (bool)
              {
                com.tencent.mm.plugin.appbrand.permission.r.amk(parame.getAppId());
                k = bool;
              }
            }
            Log.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
            pat = true;
            k.a(parame.getAppId(), new k.c()
            {
              public final void onResume()
              {
                AppMethodBeat.i(46428);
                Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
                JsApiChooseMedia.Yy();
                k.b(parame.getAppId(), this);
                AppMethodBeat.o(46428);
              }
            });
            paramJSONObject = new ChooseRequest();
            paramJSONObject.appId = parame.getAppId();
            paramJSONObject.pav = str2.contains("album");
            paramJSONObject.paw = str2.contains("camera");
            paramJSONObject.pax = str3.contains("image");
            paramJSONObject.pay = str3.contains("video");
            paramJSONObject.paz = str3.contains("mix");
            if ((!str4.contains("back")) && (str4.contains("front"))) {}
            for (paramJSONObject.isFront = true;; paramJSONObject.isFront = false)
            {
              paramJSONObject.maxDuration = i;
              paramJSONObject.count = j;
              paramJSONObject.oZZ = str1.contains("compressed");
              paramJSONObject.paa = str1.contains("original");
              a.a(localContext1, paramJSONObject, new AppBrandProxyUIProcessTask.b() {});
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
    int maxDuration;
    boolean oZZ;
    boolean paa;
    boolean pav;
    boolean paw;
    boolean pax;
    boolean pay;
    boolean paz;
    
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
      k(paramParcel);
      AppMethodBeat.o(46435);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bOe()
    {
      return JsApiChooseMedia.a.class;
    }
    
    public final boolean bPn()
    {
      return true;
    }
    
    public final String bPo()
    {
      return "GalleryChooseMedia";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46433);
      this.appId = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.pav = bool1;
        if (paramParcel.readByte() == 0) {
          break label154;
        }
        bool1 = true;
        label38:
        this.paw = bool1;
        if (paramParcel.readByte() == 0) {
          break label159;
        }
        bool1 = true;
        label52:
        this.pax = bool1;
        if (paramParcel.readByte() == 0) {
          break label164;
        }
        bool1 = true;
        label66:
        this.pay = bool1;
        if (paramParcel.readByte() == 0) {
          break label169;
        }
        bool1 = true;
        label80:
        this.paz = bool1;
        if (paramParcel.readByte() == 0) {
          break label174;
        }
        bool1 = true;
        label94:
        this.isFront = bool1;
        this.maxDuration = paramParcel.readInt();
        this.count = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label179;
        }
        bool1 = true;
        label124:
        this.oZZ = bool1;
        if (paramParcel.readByte() == 0) {
          break label184;
        }
      }
      label154:
      label159:
      label164:
      label169:
      label174:
      label179:
      label184:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.paa = bool1;
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
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46434);
      paramParcel.writeString(this.appId);
      if (this.pav)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.paw) {
          break label156;
        }
        b1 = 1;
        label39:
        paramParcel.writeByte(b1);
        if (!this.pax) {
          break label161;
        }
        b1 = 1;
        label53:
        paramParcel.writeByte(b1);
        if (!this.pay) {
          break label166;
        }
        b1 = 1;
        label67:
        paramParcel.writeByte(b1);
        if (!this.paz) {
          break label171;
        }
        b1 = 1;
        label81:
        paramParcel.writeByte(b1);
        if (!this.isFront) {
          break label176;
        }
        b1 = 1;
        label95:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.maxDuration);
        paramParcel.writeInt(this.count);
        if (!this.oZZ) {
          break label181;
        }
        b1 = 1;
        label125:
        paramParcel.writeByte(b1);
        if (!this.paa) {
          break label186;
        }
      }
      label156:
      label161:
      label166:
      label171:
      label176:
      label181:
      label186:
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
      }
    }
  }
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    String paA;
    int resultCode;
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
      k(paramParcel);
      AppMethodBeat.o(46440);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      AppMethodBeat.i(46438);
      this.resultCode = paramParcel.readInt();
      this.type = paramParcel.readString();
      this.paA = paramParcel.readString();
      AppMethodBeat.o(46438);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46439);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.paA);
      AppMethodBeat.o(46439);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private s jhZ;
    private JsApiChooseMedia.ChooseResult paB;
    private JsApiChooseMedia.ChooseRequest paC;
    private String paD;
    private String paE;
    private com.tencent.mm.ui.tools.m paF;
    int pag;
    private DialogInterface.OnCancelListener pak;
    
    private a()
    {
      AppMethodBeat.i(46453);
      this.paB = new JsApiChooseMedia.ChooseResult();
      AppMethodBeat.o(46453);
    }
    
    private void AD(int paramInt)
    {
      AppMethodBeat.i(250483);
      this.pak = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(283770);
          Log.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
          JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = 0;
          JsApiChooseMedia.a.p(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
          AppMethodBeat.o(283770);
        }
      };
      MMActivity localMMActivity = bPf();
      int i = au.i.app_tip;
      MMApplicationContext.getResources().getString(i);
      this.jhZ = com.tencent.mm.ui.base.h.a(localMMActivity, MMApplicationContext.getResources().getString(paramInt), true, this.pak);
      AppMethodBeat.o(250483);
    }
    
    private SightParams AE(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46457);
      String str1 = "microMsg." + System.currentTimeMillis() + ".jpg";
      this.paD = com.tencent.mm.vfs.u.n(com.tencent.mm.loader.j.b.aSX() + "microMsg." + str1 + ".mp4", false);
      this.paE = com.tencent.mm.vfs.u.n(com.tencent.mm.loader.j.b.aSX() + "microMsg." + str1 + ".jpeg", true);
      int j = this.paC.maxDuration;
      SightParams localSightParams = new SightParams(3, 1);
      if (this.paC.isFront) {}
      for (;;)
      {
        localSightParams.EYi = i;
        localSightParams.mode = paramInt;
        if (localSightParams.lgX == null) {
          localSightParams.lgX = new VideoTransPara();
        }
        localSightParams.lgX.duration = j;
        localSightParams.EYp = false;
        String str2 = com.tencent.mm.loader.j.b.aSX();
        localSightParams.A(str1, this.paD, this.paE, str2);
        AppMethodBeat.o(46457);
        return localSightParams;
        i = 2;
      }
    }
    
    private static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(250490);
      if (Util.isNullOrNil(paramString1))
      {
        Log.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
        AppMethodBeat.o(250490);
        return "";
      }
      Log.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.array();
        a(localJSONStringer, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramLong);
        localJSONStringer.endArray();
        paramString1 = localJSONStringer.toString();
        AppMethodBeat.o(250490);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramString1, "", new Object[0]);
        AppMethodBeat.o(250490);
      }
      return "";
    }
    
    private static void a(JSONStringer paramJSONStringer, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(250491);
      if (Util.isNullOrNil(paramString1))
      {
        Log.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
        AppMethodBeat.o(250491);
        return;
      }
      Log.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
      try
      {
        paramJSONStringer.object();
        paramJSONStringer.key("tempFilePath");
        paramJSONStringer.value(paramString1);
        paramJSONStringer.key("thumbTempFilePath");
        paramJSONStringer.value(paramString2);
        paramJSONStringer.key("duration");
        paramJSONStringer.value(String.valueOf(paramInt1));
        paramJSONStringer.key("height");
        paramJSONStringer.value(String.valueOf(paramInt2));
        paramJSONStringer.key("width");
        paramJSONStringer.value(String.valueOf(paramInt3));
        paramJSONStringer.key("size");
        paramJSONStringer.value(String.valueOf(paramLong));
        paramJSONStringer.key("fileType");
        paramJSONStringer.value("video");
        paramJSONStringer.endObject();
        AppMethodBeat.o(250491);
        return;
      }
      catch (Exception paramJSONStringer)
      {
        Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramJSONStringer, "", new Object[0]);
        AppMethodBeat.o(250491);
      }
    }
    
    private static void a(JSONStringer paramJSONStringer, ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
    {
      AppMethodBeat.i(250489);
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        Log.e("MicroMsg.JsApiChooseMedia", "_parseImageItemToJson localIds is null");
        AppMethodBeat.o(250489);
        return;
      }
      Log.i("MicroMsg.JsApiChooseMedia", "_parseImageItemToJson()");
      int i = 0;
      try
      {
        while (i < paramArrayList.size())
        {
          paramJSONStringer.object();
          String str = (String)paramArrayList.get(i);
          Long localLong = (Long)paramArrayList1.get(i);
          paramJSONStringer.key("tempFilePath");
          paramJSONStringer.value(str);
          paramJSONStringer.key("size");
          paramJSONStringer.value(String.valueOf(localLong.longValue()));
          paramJSONStringer.key("fileType");
          paramJSONStringer.value("image");
          paramJSONStringer.endObject();
          i += 1;
        }
        AppMethodBeat.o(250489);
        return;
      }
      catch (Exception paramJSONStringer)
      {
        Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramJSONStringer, "", new Object[0]);
        AppMethodBeat.o(250489);
      }
    }
    
    private static boolean ahU(String paramString)
    {
      AppMethodBeat.i(46463);
      if (!TextUtils.isEmpty(paramString))
      {
        q localq = new q(paramString);
        Log.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[] { paramString });
        if (localq.ifE())
        {
          Log.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
          AppMethodBeat.o(46463);
          return true;
        }
        Log.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
        AppMethodBeat.o(46463);
        return false;
      }
      Log.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
      AppMethodBeat.o(46463);
      return false;
    }
    
    private AppBrandLocalVideoObject au(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(250486);
      String str1 = paramString;
      if (paramBoolean) {}
      String str2;
      int i;
      int j;
      int m;
      int k;
      try
      {
        str1 = t.ahW(paramString);
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            paramString = new d();
            paramString.setDataSource(str1);
            if (paramString != null) {
              break;
            }
            Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
            AppMethodBeat.o(250486);
            return null;
            localException = localException;
            Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[] { Util.stackTraceToString(localException) });
            str2 = paramString;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
            paramString = null;
          }
          i = Util.getInt(paramString.extractMetadata(18), 0);
          j = Util.getInt(paramString.extractMetadata(19), 0);
          m = Util.getInt(paramString.extractMetadata(9), 0);
          k = Util.getInt(paramString.extractMetadata(24), 0);
          Log.i("MicroMsg.JsApiChooseMedia", "outputWidth:%d, outputHeight:%d, rotation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
          if (k == 90) {
            break label200;
          }
        }
      }
      if (k == 270) {}
      for (;;)
      {
        label200:
        paramString.release();
        paramString = AppBrandLocalMediaObjectManager.cE(this.paC.appId, str2);
        if (paramString == null)
        {
          Log.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
          AppMethodBeat.o(250486);
          return null;
        }
        paramString.duration = ((m + 500) / 1000);
        paramString.width = j;
        paramString.height = i;
        paramString.size = com.tencent.mm.vfs.u.bBQ(str2);
        Log.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[] { paramString });
        AppMethodBeat.o(250486);
        return paramString;
        k = i;
        i = j;
        j = k;
      }
    }
    
    private static String b(ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
    {
      AppMethodBeat.i(250488);
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        Log.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
        AppMethodBeat.o(250488);
        return "";
      }
      Log.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.array();
        a(localJSONStringer, paramArrayList, paramArrayList1);
        localJSONStringer.endArray();
        paramArrayList = localJSONStringer.toString();
        AppMethodBeat.o(250488);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramArrayList, "", new Object[0]);
        AppMethodBeat.o(250488);
      }
      return "";
    }
    
    private void bSZ()
    {
      int i = 0;
      AppMethodBeat.i(46456);
      Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
      if ((this.paC.pay) && (this.paC.pax)) {}
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("KEY_SIGHT_PARAMS", AE(i));
        com.tencent.mm.pluginsdk.ui.tools.u.a(bPf(), 7, localIntent, 3, i);
        AppMethodBeat.o(46456);
        return;
        if (this.paC.pay) {
          i = 1;
        } else if (this.paC.pax) {
          i = 2;
        }
      }
    }
    
    private void bTa()
    {
      int j = 3;
      boolean bool3 = true;
      AppMethodBeat.i(46458);
      Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
      boolean bool2 = this.paC.paa;
      int i;
      Intent localIntent;
      if (this.paC.paz)
      {
        i = j;
        bool1 = bool2;
        localIntent = new Intent();
        if (!this.paC.paz) {
          localIntent.putExtra("key_can_select_video_and_pic", true);
        }
        if (this.paC.oZZ) {
          break label269;
        }
        bool2 = true;
        label85:
        localIntent.putExtra("key_send_raw_image", bool2);
        localIntent.putExtra("key_force_show_raw_image_button", bool1);
        if ((!this.paC.paa) || (this.paC.oZZ)) {
          break label275;
        }
      }
      label269:
      label275:
      for (boolean bool1 = bool3;; bool1 = false)
      {
        localIntent.putExtra("key_is_raw_image_button_disable", bool1);
        localIntent.putExtra("gallery_report_tag", 16);
        localIntent.putExtra("album_video_max_duration", 86400);
        localIntent.putExtra("album_business_tag", "album_business_bubble_media_by_jsapi_choosevideo");
        com.tencent.mm.pluginsdk.ui.tools.u.a(bPf(), 8, this.paC.count, this.pag, i, localIntent);
        AppMethodBeat.o(46458);
        return;
        if (this.paC.pax)
        {
          bool1 = bool2;
          i = j;
          if (this.paC.pay) {
            break;
          }
        }
        if (this.paC.pax)
        {
          i = 1;
          bool1 = bool2;
          break;
        }
        bool1 = bool2;
        i = j;
        if (!this.paC.pay) {
          break;
        }
        i = 2;
        bool1 = false;
        break;
        bool2 = false;
        break label85;
      }
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46454);
      this.paC = ((JsApiChooseMedia.ChooseRequest)paramProcessRequest);
      this.pag = 16;
      if (Util.getAvailableMemoryMB(bPf()) > 200L) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          Log.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
          paramProcessRequest = bPf();
          i = au.i.app_brand_choose_media_memory_check_message;
          w.makeText(paramProcessRequest, MMApplicationContext.getResources().getString(i), 1).show();
        }
        Log.i("MicroMsg.JsApiChooseMedia", "goVideo");
        bPf().mmSetOnActivityResultCallback(this);
        if ((!this.paC.pav) || (!this.paC.paw)) {
          break;
        }
        this.paF = new com.tencent.mm.ui.tools.m(bPf());
        this.paF.a(new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(160599);
            Log.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = 0;
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
            AppMethodBeat.o(160599);
          }
        });
        this.paF.a(null, new View.OnCreateContextMenuListener()new q.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(46443);
            paramAnonymousContextMenu.add(0, 1, 0, JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).getString(au.i.app_field_mmsight));
            paramAnonymousContextMenu.add(0, 2, 1, JsApiChooseMedia.a.c(JsApiChooseMedia.a.this).getString(au.i.app_field_select_new_pic));
            AppMethodBeat.o(46443);
          }
        }, new q.g()new e.b
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(46444);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(46444);
              return;
              JsApiChooseMedia.a.d(JsApiChooseMedia.a.this);
              AppMethodBeat.o(46444);
              return;
              JsApiChooseMedia.a.e(JsApiChooseMedia.a.this);
            }
          }
        }, new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(46445);
            Log.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = 0;
            JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
            AppMethodBeat.o(46445);
          }
        });
        AppMethodBeat.o(46454);
        return;
      }
      if (this.paC.pav)
      {
        bTa();
        AppMethodBeat.o(46454);
        return;
      }
      if (this.paC.paw)
      {
        bSZ();
        AppMethodBeat.o(46454);
        return;
      }
      this.paB.resultCode = -2;
      Log.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
      b(this.paB);
      AppMethodBeat.o(46454);
    }
    
    public final void bPm()
    {
      AppMethodBeat.i(46455);
      super.bPm();
      if (this.jhZ != null)
      {
        this.jhZ.dismiss();
        this.jhZ = null;
      }
      if (this.paF != null)
      {
        this.paF.dismiss();
        this.paF = null;
      }
      AppMethodBeat.o(46455);
    }
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(46459);
      if (paramInt2 == 0)
      {
        Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
        this.paB.resultCode = 0;
        b(this.paB);
        AppMethodBeat.o(46459);
        return;
      }
      if (-1 != paramInt2)
      {
        Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
        this.paB.resultCode = -2;
        b(this.paB);
        AppMethodBeat.o(46459);
        return;
      }
      Object localObject;
      final ArrayList localArrayList;
      final boolean bool1;
      final boolean bool2;
      final int i;
      label254:
      final boolean bool3;
      switch (paramInt1)
      {
      default: 
        this.paB.resultCode = -2;
        b(this.paB);
        AppMethodBeat.o(46459);
        return;
      case 8: 
        Log.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
        if (this.paC.paz)
        {
          localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
          localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            bool1 = true;
            if ((localArrayList == null) || (localArrayList.size() <= 0)) {
              break label254;
            }
          }
          for (bool2 = true;; bool2 = false)
          {
            i = 0;
            paramInt1 = 0;
            if (bool1) {
              paramInt1 = 1;
            }
            if ((bool1) || (bool2)) {
              break label260;
            }
            Log.e("MicroMsg.JsApiChooseMedia", "none select any image or video");
            this.paB.resultCode = -2;
            b(this.paB);
            AppMethodBeat.o(46459);
            return;
            bool1 = false;
            break;
          }
          label260:
          if (bool2)
          {
            bool3 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
            i = this.paC.oZZ;
            if (!this.paC.paa)
            {
              paramInt2 = 1;
              if (((paramInt2 & i) == 0) && (!(this.paC.oZZ & this.paC.paa & bool3))) {
                break label477;
              }
              i = 1;
              label327:
              Log.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.paC.oZZ), Boolean.valueOf(this.paC.paa), Boolean.valueOf(bool3), Boolean.valueOf(i) });
            }
          }
          else
          {
            if (i == 0) {
              break label1276;
            }
            paramInt1 = 1;
          }
        }
        break;
      }
      label477:
      label1004:
      label1137:
      label1143:
      label1276:
      for (;;)
      {
        if (paramInt1 != 0) {
          AD(au.i.app_brand_choose_media_video_compressing);
        }
        if ((i == 0) && (localArrayList != null) && (r.bC(localArrayList))) {}
        for (bool3 = true;; bool3 = false)
        {
          if (bool3) {
            AD(au.i.app_brand_choose_media_video_processing);
          }
          com.tencent.mm.plugin.appbrand.utils.h.clV().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46446);
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
              JSONStringer localJSONStringer = new JSONStringer();
              Object localObject3;
              Object localObject2;
              for (;;)
              {
                try
                {
                  localJSONStringer.array();
                  if (!bool1) {
                    break;
                  }
                  Iterator localIterator1 = this.paI.iterator();
                  if (!localIterator1.hasNext()) {
                    break;
                  }
                  localObject3 = (String)localIterator1.next();
                  if (!new q((String)localObject3).ifE()) {
                    break label260;
                  }
                  Log.i("MicroMsg.JsApiChooseMedia", "take media local, the path file exist, success, path:%s", new Object[] { localObject3 });
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";
                  localObject2 = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, (String)localObject3, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).oZZ);
                  if (localObject2 != null) {
                    break label212;
                  }
                  Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,videoFilePath is %s", new Object[] { localObject3 });
                  continue;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).paA = localJSONStringer.toString();
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", localException, "", new Object[0]);
                }
                JsApiChooseMedia.a.c(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46446);
                return;
                label212:
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, (String)localObject3);
                localObject3 = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                JsApiChooseMedia.a.b(localJSONStringer, ((AppBrandLocalVideoObject)localObject2).fCM, (String)localObject3, ((AppBrandLocalVideoObject)localObject2).duration, ((AppBrandLocalVideoObject)localObject2).height, ((AppBrandLocalVideoObject)localObject2).width, ((AppBrandLocalVideoObject)localObject2).size);
                continue;
                label260:
                Log.e("MicroMsg.JsApiChooseMedia", "take media local, videoFilePath is %s, the file not exist, fail", new Object[] { localObject3 });
              }
              ArrayList localArrayList;
              label333:
              Object localObject1;
              boolean bool;
              if (bool2)
              {
                localObject3 = new ArrayList(localArrayList.size());
                localArrayList = new ArrayList(localArrayList.size());
                Iterator localIterator2 = localArrayList.iterator();
                if (localIterator2.hasNext())
                {
                  localObject1 = (String)localIterator2.next();
                  if (i)
                  {
                    localObject2 = r.ahY((String)localObject1);
                    if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                      break label539;
                    }
                    bool = true;
                    localObject1 = localObject2;
                  }
                }
              }
              for (;;)
              {
                localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).appId, (String)localObject1, bool);
                if (localObject2 != null)
                {
                  ((ArrayList)localObject3).add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).mHi));
                  localArrayList.add(((AppBrandLocalMediaObject)localObject2).fCM);
                  break label333;
                  if (!bool3) {
                    break label539;
                  }
                  localObject2 = r.ahZ((String)localObject1);
                  if (((String)localObject2).equals(localObject1)) {
                    break label539;
                  }
                  bool = true;
                  localObject1 = localObject2;
                  continue;
                }
                Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
                break label333;
                if (localArrayList.size() == 0) {
                  Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                }
                for (;;)
                {
                  localJSONStringer.endArray();
                  break;
                  Log.i("MicroMsg.JsApiChooseMedia", "handle images success");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";
                  JsApiChooseMedia.a.b(localJSONStringer, localArrayList, (ArrayList)localObject3);
                }
                label539:
                bool = false;
              }
            }
          });
          AppMethodBeat.o(46459);
          return;
          paramInt2 = 0;
          break;
          i = 0;
          break label327;
        }
        localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          AD(au.i.app_brand_choose_media_video_compressing);
          com.tencent.mm.plugin.appbrand.utils.h.clV().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46448);
              Object localObject1;
              Object localObject2;
              if (this.paI.size() == 1)
              {
                JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, com.tencent.mm.vfs.u.n((String)this.paI.get(0), false));
                if (Util.isNullOrNil(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this)))
                {
                  Log.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                  JsApiChooseMedia.a.d(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46448);
                  return;
                }
                if (new q(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this)).ifE())
                {
                  Log.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                  localObject1 = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.h(JsApiChooseMedia.a.this), JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).oZZ);
                  if (localObject1 == null)
                  {
                    Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.h(JsApiChooseMedia.a.this) });
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                    JsApiChooseMedia.a.e(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(46448);
                    return;
                  }
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.h(JsApiChooseMedia.a.this));
                  localObject2 = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).paA = JsApiChooseMedia.a.b(((AppBrandLocalVideoObject)localObject1).fCM, (String)localObject2, ((AppBrandLocalVideoObject)localObject1).duration, ((AppBrandLocalVideoObject)localObject1).height, ((AppBrandLocalVideoObject)localObject1).width, ((AppBrandLocalVideoObject)localObject1).size);
                  JsApiChooseMedia.a.f(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46448);
                  return;
                }
                Log.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.h(JsApiChooseMedia.a.this) });
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                JsApiChooseMedia.a.g(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46448);
                return;
              }
              String str;
              AppBrandLocalVideoObject localAppBrandLocalVideoObject;
              if (this.paI.size() > 1)
              {
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                localObject1 = new JSONStringer();
                try
                {
                  ((JSONStringer)localObject1).array();
                  localObject2 = this.paI.iterator();
                  for (;;)
                  {
                    if (((Iterator)localObject2).hasNext())
                    {
                      str = (String)((Iterator)localObject2).next();
                      if (new q(str).ifE())
                      {
                        Log.i("MicroMsg.JsApiChooseMedia", "take media local, the path file exist, success, path:%s", new Object[] { str });
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                        localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, str, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).oZZ);
                        if (localAppBrandLocalVideoObject == null)
                        {
                          Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,videoFilePath is %s", new Object[] { str });
                          continue;
                          JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).paA = ((JSONStringer)localObject1).toString();
                        }
                      }
                    }
                  }
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("MicroMsg.JsApiChooseMedia", localException, "", new Object[0]);
                }
              }
              for (;;)
              {
                JsApiChooseMedia.a.h(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46448);
                return;
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, str);
                str = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                JsApiChooseMedia.a.b((JSONStringer)localObject1, localAppBrandLocalVideoObject.fCM, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                break;
                Log.e("MicroMsg.JsApiChooseMedia", "take media local, videoFilePath is %s, the file not exist, fail", new Object[] { str });
                break;
                ((JSONStringer)localObject1).endArray();
              }
            }
          });
          AppMethodBeat.o(46459);
          return;
        }
        localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          Log.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
          this.paB.resultCode = -2;
          b(this.paB);
          AppMethodBeat.o(46459);
          return;
        }
        bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        final int j = this.paC.oZZ;
        if (!this.paC.paa)
        {
          paramInt1 = 1;
          if (((paramInt1 & j) == 0) && (!(this.paC.oZZ & this.paC.paa & bool1))) {
            break label793;
          }
          j = 1;
          Log.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.paC.oZZ), Boolean.valueOf(this.paC.paa), Boolean.valueOf(bool1), Boolean.valueOf(j) });
          if (j != 0) {
            AD(au.i.app_brand_choose_media_video_compressing);
          }
          if ((j != 0) || (!r.bC((List)localObject))) {
            break label799;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          if (bool1) {
            AD(au.i.app_brand_choose_media_video_processing);
          }
          com.tencent.mm.plugin.appbrand.ac.m.clV().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46450);
              final ArrayList localArrayList1 = new ArrayList(this.pam.size());
              final ArrayList localArrayList2 = new ArrayList(this.pam.size());
              Iterator localIterator = this.pam.iterator();
              Object localObject1;
              Object localObject2;
              boolean bool;
              if (localIterator.hasNext())
              {
                localObject1 = (String)localIterator.next();
                if (j)
                {
                  localObject2 = r.ahY((String)localObject1);
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label260;
                  }
                  bool = true;
                  localObject1 = localObject2;
                }
              }
              for (;;)
              {
                localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).appId, (String)localObject1, bool);
                if (localObject2 != null)
                {
                  localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).mHi));
                  localArrayList2.add(((AppBrandLocalMediaObject)localObject2).fCM);
                  break;
                  if (!bool1) {
                    break label260;
                  }
                  localObject2 = r.ahZ((String)localObject1);
                  if (((String)localObject2).equals(localObject1)) {
                    break label260;
                  }
                  bool = true;
                  localObject1 = localObject2;
                  continue;
                }
                Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
                break;
                if (localArrayList2.size() == 0)
                {
                  Log.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                  JsApiChooseMedia.a.i(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46450);
                  return;
                }
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(46449);
                    Log.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image";
                    JsApiChooseMedia.ChooseResult localChooseResult = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this);
                    ArrayList localArrayList1 = localArrayList2;
                    ArrayList localArrayList2 = localArrayList1;
                    JsApiChooseMedia.a.f(JsApiChooseMedia.a.this);
                    localChooseResult.paA = JsApiChooseMedia.a.c(localArrayList1, localArrayList2);
                    JsApiChooseMedia.a.j(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(46449);
                  }
                });
                AppMethodBeat.o(46450);
                return;
                label260:
                bool = false;
              }
            }
          });
          AppMethodBeat.o(46459);
          return;
          paramInt1 = 0;
          break;
          j = 0;
          break label660;
        }
        Log.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
        if (paramIntent != null)
        {
          Log.i("MicroMsg.JsApiChooseMedia", "data is valid!");
          localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
          if (localObject == null)
          {
            Log.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
            this.paB.resultCode = -2;
            b(this.paB);
            AppMethodBeat.o(46459);
            return;
          }
          if (((SightCaptureResult)localObject).EXZ)
          {
            localObject = com.tencent.mm.vfs.u.n(((SightCaptureResult)localObject).EYh, false);
            if (Util.isNullOrNil((String)localObject))
            {
              Log.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
              this.paB.resultCode = -2;
              b(this.paB);
              AppMethodBeat.o(46459);
              return;
            }
            bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
            final int k = this.paC.oZZ;
            if (!this.paC.paa)
            {
              paramInt1 = 1;
              if (((paramInt1 & k) == 0) && (!(this.paC.oZZ & this.paC.paa & bool1))) {
                break label1137;
              }
              k = 1;
              Log.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.TRUE, Boolean.valueOf(this.paC.oZZ), Boolean.valueOf(this.paC.paa), Boolean.valueOf(bool1), Boolean.valueOf(k) });
              if (k != 0) {
                AD(au.i.app_brand_choose_media_video_compressing);
              }
              if ((k != 0) || (!r.aid((String)localObject))) {
                break label1143;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              if (bool1) {
                AD(au.i.app_brand_choose_media_video_processing);
              }
              com.tencent.mm.plugin.appbrand.ac.m.clV().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(46451);
                  Object localObject2 = this.val$filePath;
                  Object localObject1;
                  if (k)
                  {
                    localObject1 = r.ahY((String)localObject2);
                    if ((localObject1 == null) || (((String)localObject1).equals(localObject2))) {
                      break label189;
                    }
                  }
                  for (;;)
                  {
                    localObject2 = new ArrayList();
                    Object localObject3 = new ArrayList();
                    localObject1 = AppBrandLocalMediaObjectManager.h(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).appId, (String)localObject1, true);
                    if (localObject1 != null)
                    {
                      ((ArrayList)localObject2).add(Long.valueOf(((AppBrandLocalMediaObject)localObject1).mHi));
                      ((ArrayList)localObject3).add(((AppBrandLocalMediaObject)localObject1).fCM);
                      MMHandlerThread.postToMainThread(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(271873);
                          Log.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                          JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                          if (JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).paz) {}
                          for (JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";; JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image")
                          {
                            JsApiChooseMedia.ChooseResult localChooseResult = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this);
                            ArrayList localArrayList1 = this.paK;
                            ArrayList localArrayList2 = this.paN;
                            JsApiChooseMedia.a.f(JsApiChooseMedia.a.this);
                            localChooseResult.paA = JsApiChooseMedia.a.c(localArrayList1, localArrayList2);
                            JsApiChooseMedia.a.k(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                            AppMethodBeat.o(271873);
                            return;
                          }
                        }
                      });
                      AppMethodBeat.o(46451);
                      return;
                      localObject1 = localObject2;
                      if (bool1)
                      {
                        localObject3 = r.ahZ((String)localObject2);
                        localObject1 = localObject2;
                        if (!((String)localObject3).equals(localObject2)) {
                          localObject1 = localObject3;
                        }
                      }
                    }
                    else
                    {
                      Log.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                      JsApiChooseMedia.a.l(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                      AppMethodBeat.o(46451);
                      return;
                      label189:
                      localObject1 = localObject2;
                    }
                  }
                }
              });
              AppMethodBeat.o(46459);
              return;
              paramInt1 = 0;
              break;
              k = 0;
              break label1004;
            }
          }
          this.paD = com.tencent.mm.vfs.u.n(((SightCaptureResult)localObject).EYb, false);
          if (Util.isNullOrNil(this.paD))
          {
            Log.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
            break;
          }
          Log.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[] { this.paD });
          if ((!ahU(this.paE)) && (ahU(((SightCaptureResult)localObject).EYc))) {
            this.paE = com.tencent.mm.vfs.u.n(((SightCaptureResult)localObject).EYc, true);
          }
          AD(au.i.app_brand_choose_media_video_compressing);
          com.tencent.mm.plugin.appbrand.ac.m.clV().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(277996);
              if (new q(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this)).ifE())
              {
                Log.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -1;
                if (JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).paz) {}
                AppBrandLocalVideoObject localAppBrandLocalVideoObject;
                for (JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";; JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video")
                {
                  localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.h(JsApiChooseMedia.a.this), JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).oZZ);
                  if (localAppBrandLocalVideoObject != null) {
                    break;
                  }
                  Log.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.h(JsApiChooseMedia.a.this) });
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
                  JsApiChooseMedia.a.m(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(277996);
                  return;
                }
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.h(JsApiChooseMedia.a.this));
                String str = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).paA = JsApiChooseMedia.a.b(localAppBrandLocalVideoObject.fCM, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                JsApiChooseMedia.a.n(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(277996);
                return;
              }
              Log.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.h(JsApiChooseMedia.a.this) });
              JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).resultCode = -2;
              JsApiChooseMedia.a.o(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
              AppMethodBeat.o(277996);
            }
          });
          AppMethodBeat.o(46459);
          return;
        }
        Log.e("MicroMsg.JsApiChooseMedia", "data is null!");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia
 * JD-Core Version:    0.7.0.1
 */