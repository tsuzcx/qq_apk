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
import android.support.v4.app.a.a;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class JsApiChooseMedia
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 193;
  public static final String NAME = "chooseMedia";
  private static volatile boolean kTK = false;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46489);
    if (kTK)
    {
      ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46489);
      return;
    }
    ad.i("MicroMsg.JsApiChooseMedia", "chooseMedia %s", new Object[] { paramJSONObject });
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
        if (!bt.isNullOrNil(str1)) {
          break label913;
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
          break label240;
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
              break label907;
            }
            str1 = "original|compressed";
          }
          for (;;)
          {
            ad.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { str2, str3, Integer.valueOf(i), str4, Integer.valueOf(j), str1 });
            com.tencent.mm.plugin.appbrand.permission.p.b(paramc.getAppId(), new a.a()
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
                break label587;
              }
              ad.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
              AppMethodBeat.o(46489);
              return;
              ad.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
              break;
              bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext2, "android.permission.RECORD_AUDIO", 120, "", "");
              k = bool;
              if (bool)
              {
                com.tencent.mm.plugin.appbrand.permission.p.TS(paramc.getAppId());
                k = bool;
              }
            }
            label587:
            com.tencent.mm.plugin.appbrand.permission.p.b(paramc.getAppId(), new a.a()
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
              bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 119, "", "");
              k = bool;
              if (bool)
              {
                com.tencent.mm.plugin.appbrand.permission.p.TS(paramc.getAppId());
                k = bool;
              }
            }
            ad.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
            kTK = true;
            g.a(paramc.getAppId(), new g.c()
            {
              public final void onResume()
              {
                AppMethodBeat.i(46428);
                ad.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
                JsApiChooseMedia.Jy();
                g.b(paramc.getAppId(), this);
                AppMethodBeat.o(46428);
              }
            });
            paramJSONObject = new ChooseRequest();
            paramJSONObject.appId = paramc.getAppId();
            paramJSONObject.kTM = str2.contains("album");
            paramJSONObject.kTN = str2.contains("camera");
            paramJSONObject.kTO = str3.contains("image");
            paramJSONObject.kTP = str3.contains("video");
            paramJSONObject.kTQ = str3.contains("mix");
            if ((!str4.contains("back")) && (str4.contains("front"))) {}
            for (paramJSONObject.isFront = true;; paramJSONObject.isFront = false)
            {
              paramJSONObject.maxDuration = i;
              paramJSONObject.count = j;
              paramJSONObject.kTq = str1.contains("compressed");
              paramJSONObject.kTr = str1.contains("original");
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
    boolean kTM;
    boolean kTN;
    boolean kTO;
    boolean kTP;
    boolean kTQ;
    boolean kTq;
    boolean kTr;
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
    
    public final Class<? extends AppBrandProxyUIProcessTask> bgN()
    {
      return JsApiChooseMedia.a.class;
    }
    
    public final boolean bhR()
    {
      return true;
    }
    
    public final String bhS()
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
        this.kTM = bool1;
        if (paramParcel.readByte() == 0) {
          break label154;
        }
        bool1 = true;
        label38:
        this.kTN = bool1;
        if (paramParcel.readByte() == 0) {
          break label159;
        }
        bool1 = true;
        label52:
        this.kTO = bool1;
        if (paramParcel.readByte() == 0) {
          break label164;
        }
        bool1 = true;
        label66:
        this.kTP = bool1;
        if (paramParcel.readByte() == 0) {
          break label169;
        }
        bool1 = true;
        label80:
        this.kTQ = bool1;
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
        this.kTq = bool1;
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
        this.kTr = bool1;
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
      if (this.kTM)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.kTN) {
          break label156;
        }
        b1 = 1;
        label39:
        paramParcel.writeByte(b1);
        if (!this.kTO) {
          break label161;
        }
        b1 = 1;
        label53:
        paramParcel.writeByte(b1);
        if (!this.kTP) {
          break label166;
        }
        b1 = 1;
        label67:
        paramParcel.writeByte(b1);
        if (!this.kTQ) {
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
        if (!this.kTq) {
          break label181;
        }
        b1 = 1;
        label125:
        paramParcel.writeByte(b1);
        if (!this.kTr) {
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
    int bZU;
    String kTR;
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
      j(paramParcel);
      AppMethodBeat.o(46440);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(46438);
      this.bZU = paramParcel.readInt();
      this.type = paramParcel.readString();
      this.kTR = paramParcel.readString();
      AppMethodBeat.o(46438);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46439);
      paramParcel.writeInt(this.bZU);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.kTR);
      AppMethodBeat.o(46439);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private com.tencent.mm.ui.base.p fQJ;
    private DialogInterface.OnCancelListener kTB;
    private JsApiChooseMedia.ChooseResult kTS;
    private JsApiChooseMedia.ChooseRequest kTT;
    private String kTU;
    private String kTV;
    private l kTW;
    int kTx;
    
    private a()
    {
      AppMethodBeat.i(46453);
      this.kTS = new JsApiChooseMedia.ChooseResult();
      AppMethodBeat.o(46453);
    }
    
    private static boolean PT(String paramString)
    {
      AppMethodBeat.i(46463);
      if (!TextUtils.isEmpty(paramString))
      {
        com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString);
        ad.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[] { paramString });
        if (locale.exists())
        {
          ad.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
          AppMethodBeat.o(46463);
          return true;
        }
        ad.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
        AppMethodBeat.o(46463);
        return false;
      }
      ad.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
      AppMethodBeat.o(46463);
      return false;
    }
    
    private static void a(JSONStringer paramJSONStringer, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(188439);
      if (bt.isNullOrNil(paramString1))
      {
        ad.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
        AppMethodBeat.o(188439);
        return;
      }
      ad.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
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
        paramJSONStringer.value(String.valueOf(paramInt4));
        paramJSONStringer.key("fileType");
        paramJSONStringer.value("video");
        paramJSONStringer.endObject();
        AppMethodBeat.o(188439);
        return;
      }
      catch (Exception paramJSONStringer)
      {
        ad.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramJSONStringer, "", new Object[0]);
        AppMethodBeat.o(188439);
      }
    }
    
    private static void a(JSONStringer paramJSONStringer, ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
    {
      AppMethodBeat.i(188438);
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        ad.e("MicroMsg.JsApiChooseMedia", "_parseImageItemToJson localIds is null");
        AppMethodBeat.o(188438);
        return;
      }
      ad.i("MicroMsg.JsApiChooseMedia", "_parseImageItemToJson()");
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
        AppMethodBeat.o(188438);
        return;
      }
      catch (Exception paramJSONStringer)
      {
        ad.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramJSONStringer, "", new Object[0]);
        AppMethodBeat.o(188438);
      }
    }
    
    private AppBrandLocalVideoObject aq(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(188436);
      String str1 = paramString;
      if (paramBoolean) {}
      try
      {
        str1 = t.PV(paramString);
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
            ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
            AppMethodBeat.o(188436);
            return null;
            localException = localException;
            ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bt.n(localException) });
            str2 = paramString;
          }
        }
        catch (Exception paramString)
        {
          String str2;
          for (;;)
          {
            ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
            paramString = null;
          }
          int i = bt.getInt(paramString.extractMetadata(18), 0);
          int j = bt.getInt(paramString.extractMetadata(19), 0);
          int k = bt.getInt(paramString.extractMetadata(9), 0);
          paramString.release();
          paramString = AppBrandLocalMediaObjectManager.ck(this.kTT.appId, str2);
          if (paramString == null)
          {
            ad.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
            AppMethodBeat.o(188436);
            return null;
          }
          paramString.duration = ((k + 500) / 1000);
          paramString.width = i;
          paramString.height = j;
          paramString.size = ((int)i.aYo(str2));
          ad.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[] { paramString });
          AppMethodBeat.o(188436);
        }
      }
      return paramString;
    }
    
    private static String b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(46465);
      if (bt.isNullOrNil(paramString1))
      {
        ad.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
        AppMethodBeat.o(46465);
        return "";
      }
      ad.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.array();
        a(localJSONStringer, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4);
        localJSONStringer.endArray();
        paramString1 = localJSONStringer.toString();
        AppMethodBeat.o(46465);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramString1, "", new Object[0]);
        AppMethodBeat.o(46465);
      }
      return "";
    }
    
    private static String b(ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
    {
      AppMethodBeat.i(188437);
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        ad.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
        AppMethodBeat.o(188437);
        return "";
      }
      ad.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.array();
        a(localJSONStringer, paramArrayList, paramArrayList1);
        localJSONStringer.endArray();
        paramArrayList = localJSONStringer.toString();
        AppMethodBeat.o(188437);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        ad.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramArrayList, "", new Object[0]);
        AppMethodBeat.o(188437);
      }
      return "";
    }
    
    private void blk()
    {
      int i = 0;
      AppMethodBeat.i(46456);
      ad.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
      if ((this.kTT.kTP) && (this.kTT.kTO)) {}
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("KEY_SIGHT_PARAMS", tj(i));
        q.a(bhJ(), 7, localIntent, 3, i);
        AppMethodBeat.o(46456);
        return;
        if (this.kTT.kTP) {
          i = 1;
        } else if (this.kTT.kTO) {
          i = 2;
        }
      }
    }
    
    private void bll()
    {
      int j = 3;
      boolean bool = true;
      AppMethodBeat.i(46458);
      ad.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
      int i;
      Intent localIntent;
      if (this.kTT.kTQ)
      {
        i = j;
        localIntent = new Intent();
        if (!this.kTT.kTQ) {
          localIntent.putExtra("key_can_select_video_and_pic", true);
        }
        if (this.kTT.kTq) {
          break label198;
        }
      }
      for (;;)
      {
        localIntent.putExtra("key_send_raw_image", bool);
        localIntent.putExtra("gallery_report_tag", 16);
        localIntent.putExtra("album_video_max_duration", 86400);
        localIntent.putExtra("album_business_tag", "album_business_bubble_media_by_jsapi_choosevideo");
        q.a(bhJ(), 8, this.kTT.count, this.kTx, i, localIntent);
        AppMethodBeat.o(46458);
        return;
        if (this.kTT.kTO)
        {
          i = j;
          if (this.kTT.kTP) {
            break;
          }
        }
        if (this.kTT.kTO)
        {
          i = 1;
          break;
        }
        i = j;
        if (!this.kTT.kTP) {
          break;
        }
        i = 2;
        break;
        label198:
        bool = false;
      }
    }
    
    private void ti(int paramInt)
    {
      AppMethodBeat.i(188435);
      this.kTB = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(188432);
          ad.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
          JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = 0;
          JsApiChooseMedia.a.n(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
          AppMethodBeat.o(188432);
        }
      };
      MMActivity localMMActivity = bhJ();
      aj.getResources().getString(2131755906);
      this.fQJ = h.b(localMMActivity, aj.getResources().getString(paramInt), true, this.kTB);
      AppMethodBeat.o(188435);
    }
    
    private SightParams tj(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46457);
      String str1 = "microMsg." + System.currentTimeMillis() + ".jpg";
      this.kTU = i.k(com.tencent.mm.loader.j.b.asg() + "microMsg." + str1 + ".mp4", false);
      this.kTV = i.k(com.tencent.mm.loader.j.b.asg() + "microMsg." + str1 + ".jpeg", true);
      int j = this.kTT.maxDuration;
      SightParams localSightParams = new SightParams(3, 1);
      if (this.kTT.isFront) {}
      for (;;)
      {
        localSightParams.vMB = i;
        localSightParams.mode = paramInt;
        if (localSightParams.hvh == null) {
          localSightParams.hvh = new VideoTransPara();
        }
        localSightParams.hvh.duration = j;
        localSightParams.vMI = false;
        String str2 = com.tencent.mm.loader.j.b.asg();
        localSightParams.r(str1, this.kTU, this.kTV, str2);
        AppMethodBeat.o(46457);
        return localSightParams;
        i = 2;
      }
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46454);
      this.kTT = ((JsApiChooseMedia.ChooseRequest)paramProcessRequest);
      if ((this.kTT.kTq & this.kTT.kTr))
      {
        i = 8;
        this.kTx = i;
        if (bt.je(bhJ()) <= 200L) {
          break label199;
        }
      }
      label199:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          ad.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
          com.tencent.mm.ui.base.t.makeText(bhJ(), aj.getResources().getString(2131755358), 1).show();
        }
        ad.i("MicroMsg.JsApiChooseMedia", "goVideo");
        bhJ().mmSetOnActivityResultCallback(this);
        if ((!this.kTT.kTM) || (!this.kTT.kTN)) {
          break label204;
        }
        this.kTW = new l(bhJ());
        this.kTW.a(new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(160599);
            ad.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = 0;
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
            AppMethodBeat.o(160599);
          }
        });
        this.kTW.a(null, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(46443);
            paramAnonymousContextMenu.add(0, 1, 0, JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).getString(2131755747));
            paramAnonymousContextMenu.add(0, 2, 1, JsApiChooseMedia.a.c(JsApiChooseMedia.a.this).getString(2131755754));
            AppMethodBeat.o(46443);
          }
        }, new n.e()new e.b
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
            ad.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = 0;
            JsApiChooseMedia.a.b(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
            AppMethodBeat.o(46445);
          }
        });
        AppMethodBeat.o(46454);
        return;
        i = 7;
        break;
      }
      label204:
      if (this.kTT.kTM)
      {
        bll();
        AppMethodBeat.o(46454);
        return;
      }
      if (this.kTT.kTN)
      {
        blk();
        AppMethodBeat.o(46454);
        return;
      }
      this.kTS.bZU = -2;
      ad.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
      b(this.kTS);
      AppMethodBeat.o(46454);
    }
    
    public final void bhQ()
    {
      AppMethodBeat.i(46455);
      super.bhQ();
      if (this.fQJ != null)
      {
        this.fQJ.dismiss();
        this.fQJ = null;
      }
      if (this.kTW != null)
      {
        this.kTW.dismiss();
        this.kTW = null;
      }
      AppMethodBeat.o(46455);
    }
    
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(46459);
      if (paramInt2 == 0)
      {
        ad.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
        this.kTS.bZU = 0;
        b(this.kTS);
        AppMethodBeat.o(46459);
        return;
      }
      if (-1 != paramInt2)
      {
        ad.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
        this.kTS.bZU = -2;
        b(this.kTS);
        AppMethodBeat.o(46459);
        return;
      }
      switch (paramInt1)
      {
      }
      for (;;)
      {
        this.kTS.bZU = -2;
        b(this.kTS);
        AppMethodBeat.o(46459);
        return;
        ad.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
        final boolean bool1;
        if (this.kTT.kTQ)
        {
          localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
          final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            bool1 = true;
            if ((localArrayList == null) || (localArrayList.size() <= 0)) {
              break label253;
            }
          }
          label253:
          for (final boolean bool2 = true;; bool2 = false)
          {
            i = 0;
            if (bool1) {
              i = 1;
            }
            if ((bool1) || (bool2)) {
              break label259;
            }
            ad.e("MicroMsg.JsApiChooseMedia", "none select any image or video");
            this.kTS.bZU = -2;
            b(this.kTS);
            AppMethodBeat.o(46459);
            return;
            bool1 = false;
            break;
          }
          label259:
          int m = i;
          label330:
          final int n;
          if (i == 0)
          {
            boolean bool3 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
            i = this.kTT.kTq;
            if (!this.kTT.kTr)
            {
              paramInt1 = 1;
              if (((paramInt1 & i) == 0) && (!(this.kTT.kTq & this.kTT.kTr & bool3))) {
                break label473;
              }
              i = 1;
              ad.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.kTT.kTq), Boolean.valueOf(this.kTT.kTr), Boolean.valueOf(bool3), Boolean.valueOf(i) });
              n = i;
            }
          }
          else
          {
            if (n != 0) {
              ti(2131755359);
            }
            if ((n != 0) || (!r.bp(localArrayList))) {
              break label479;
            }
          }
          label473:
          label479:
          for (final int i = 1;; i = 0)
          {
            if (i != 0) {
              ti(2131755360);
            }
            com.tencent.mm.plugin.appbrand.utils.e.bBp().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(46446);
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -2;
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
                    Iterator localIterator1 = this.kTZ.iterator();
                    if (!localIterator1.hasNext()) {
                      break;
                    }
                    localObject3 = (String)localIterator1.next();
                    if (!new com.tencent.mm.vfs.e((String)localObject3).exists()) {
                      break label260;
                    }
                    ad.i("MicroMsg.JsApiChooseMedia", "take media local, the path file exist, success, path:%s", new Object[] { localObject3 });
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -1;
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";
                    localObject2 = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, (String)localObject3, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).kTq);
                    if (localObject2 != null) {
                      break label212;
                    }
                    ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,videoFilePath is %s", new Object[] { localObject3 });
                    continue;
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).kTR = localJSONStringer.toString();
                  }
                  catch (Exception localException)
                  {
                    ad.printErrStackTrace("MicroMsg.JsApiChooseMedia", localException, "", new Object[0]);
                  }
                  JsApiChooseMedia.a.c(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46446);
                  return;
                  label212:
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, (String)localObject3);
                  localObject3 = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                  JsApiChooseMedia.a.b(localJSONStringer, ((AppBrandLocalVideoObject)localObject2).drH, (String)localObject3, ((AppBrandLocalVideoObject)localObject2).duration, ((AppBrandLocalVideoObject)localObject2).height, ((AppBrandLocalVideoObject)localObject2).width, ((AppBrandLocalVideoObject)localObject2).size);
                  continue;
                  label260:
                  ad.e("MicroMsg.JsApiChooseMedia", "take media local, videoFilePath is %s, the file not exist, fail", new Object[] { localObject3 });
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
                    if (n)
                    {
                      localObject2 = r.PX((String)localObject1);
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
                    ((ArrayList)localObject3).add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).iQl));
                    localArrayList.add(((AppBrandLocalMediaObject)localObject2).drH);
                    break label333;
                    if (!i) {
                      break label539;
                    }
                    localObject2 = r.PY((String)localObject1);
                    if (((String)localObject2).equals(localObject1)) {
                      break label539;
                    }
                    bool = true;
                    localObject1 = localObject2;
                    continue;
                  }
                  ad.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
                  break label333;
                  if (localArrayList.size() == 0) {
                    ad.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                  }
                  for (;;)
                  {
                    localJSONStringer.endArray();
                    break;
                    ad.i("MicroMsg.JsApiChooseMedia", "handle images success");
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -1;
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
            paramInt1 = 0;
            break;
            i = 0;
            break label330;
          }
        }
        Object localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          this.kTU = i.k((String)((ArrayList)localObject).get(0), false);
          if (bt.isNullOrNil(this.kTU))
          {
            ad.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
          }
          else
          {
            ti(2131755359);
            com.tencent.mm.plugin.appbrand.utils.e.bBp().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(46448);
                if (new com.tencent.mm.vfs.e(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this)).exists())
                {
                  ad.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -1;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                  AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.h(JsApiChooseMedia.a.this), JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).kTq);
                  if (localAppBrandLocalVideoObject == null)
                  {
                    ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.h(JsApiChooseMedia.a.this) });
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -2;
                    JsApiChooseMedia.a.d(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(46448);
                    return;
                  }
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.h(JsApiChooseMedia.a.this));
                  String str = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).kTR = JsApiChooseMedia.a.c(localAppBrandLocalVideoObject.drH, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                  JsApiChooseMedia.a.e(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46448);
                  return;
                }
                ad.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.h(JsApiChooseMedia.a.this) });
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -2;
                JsApiChooseMedia.a.f(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46448);
              }
            });
            AppMethodBeat.o(46459);
          }
        }
        else
        {
          localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
          if ((localObject == null) || (((List)localObject).size() == 0))
          {
            ad.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
            this.kTS.bZU = -2;
            b(this.kTS);
            AppMethodBeat.o(46459);
            return;
          }
          bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
          final int j = this.kTT.kTq;
          if (!this.kTT.kTr)
          {
            paramInt1 = 1;
            if (((paramInt1 & j) == 0) && (!(this.kTT.kTq & this.kTT.kTr & bool1))) {
              break label825;
            }
            j = 1;
            label692:
            ad.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.kTT.kTq), Boolean.valueOf(this.kTT.kTr), Boolean.valueOf(bool1), Boolean.valueOf(j) });
            if (j != 0) {
              ti(2131755359);
            }
            if ((j != 0) || (!r.bp((List)localObject))) {
              break label831;
            }
          }
          label825:
          label831:
          for (bool1 = true;; bool1 = false)
          {
            if (bool1) {
              ti(2131755360);
            }
            com.tencent.mm.plugin.appbrand.z.m.bBp().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(46450);
                final ArrayList localArrayList1 = new ArrayList(this.kTD.size());
                final ArrayList localArrayList2 = new ArrayList(this.kTD.size());
                Iterator localIterator = this.kTD.iterator();
                Object localObject1;
                Object localObject2;
                boolean bool;
                if (localIterator.hasNext())
                {
                  localObject1 = (String)localIterator.next();
                  if (j)
                  {
                    localObject2 = r.PX((String)localObject1);
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
                    localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).iQl));
                    localArrayList2.add(((AppBrandLocalMediaObject)localObject2).drH);
                    break;
                    if (!bool1) {
                      break label260;
                    }
                    localObject2 = r.PY((String)localObject1);
                    if (((String)localObject2).equals(localObject1)) {
                      break label260;
                    }
                    bool = true;
                    localObject1 = localObject2;
                    continue;
                  }
                  ad.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
                  break;
                  if (localArrayList2.size() == 0)
                  {
                    ad.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -2;
                    JsApiChooseMedia.a.g(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(46450);
                    return;
                  }
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(46449);
                      ad.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -1;
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image";
                      JsApiChooseMedia.ChooseResult localChooseResult = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this);
                      ArrayList localArrayList1 = localArrayList2;
                      ArrayList localArrayList2 = localArrayList1;
                      JsApiChooseMedia.a.f(JsApiChooseMedia.a.this);
                      localChooseResult.kTR = JsApiChooseMedia.a.c(localArrayList1, localArrayList2);
                      JsApiChooseMedia.a.h(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
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
            break label692;
          }
          ad.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
          if (paramIntent != null)
          {
            ad.i("MicroMsg.JsApiChooseMedia", "data is valid!");
            localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
            if (localObject == null)
            {
              ad.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
              this.kTS.bZU = -2;
              b(this.kTS);
              AppMethodBeat.o(46459);
              return;
            }
            if (((SightCaptureResult)localObject).vMs)
            {
              localObject = i.k(((SightCaptureResult)localObject).vMA, false);
              if (bt.isNullOrNil((String)localObject))
              {
                ad.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
                this.kTS.bZU = -2;
                b(this.kTS);
                AppMethodBeat.o(46459);
                return;
              }
              bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
              final int k = this.kTT.kTq;
              if (!this.kTT.kTr)
              {
                paramInt1 = 1;
                if (((paramInt1 & k) == 0) && (!(this.kTT.kTq & this.kTT.kTr & bool1))) {
                  break label1169;
                }
                k = 1;
                label1036:
                ad.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.TRUE, Boolean.valueOf(this.kTT.kTq), Boolean.valueOf(this.kTT.kTr), Boolean.valueOf(bool1), Boolean.valueOf(k) });
                if (k != 0) {
                  ti(2131755359);
                }
                if ((k != 0) || (!r.Qc((String)localObject))) {
                  break label1175;
                }
              }
              label1169:
              label1175:
              for (bool1 = true;; bool1 = false)
              {
                if (bool1) {
                  ti(2131755360);
                }
                com.tencent.mm.plugin.appbrand.z.m.bBp().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(46451);
                    Object localObject2 = this.val$filePath;
                    Object localObject1;
                    if (k)
                    {
                      localObject1 = r.PX((String)localObject2);
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
                        ((ArrayList)localObject2).add(Long.valueOf(((AppBrandLocalMediaObject)localObject1).iQl));
                        ((ArrayList)localObject3).add(((AppBrandLocalMediaObject)localObject1).drH);
                        aq.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(188433);
                            ad.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -1;
                            if (JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).kTQ) {}
                            for (JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";; JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image")
                            {
                              JsApiChooseMedia.ChooseResult localChooseResult = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this);
                              ArrayList localArrayList1 = this.kUb;
                              ArrayList localArrayList2 = this.kUe;
                              JsApiChooseMedia.a.f(JsApiChooseMedia.a.this);
                              localChooseResult.kTR = JsApiChooseMedia.a.c(localArrayList1, localArrayList2);
                              JsApiChooseMedia.a.i(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                              AppMethodBeat.o(188433);
                              return;
                            }
                          }
                        });
                        AppMethodBeat.o(46451);
                        return;
                        localObject1 = localObject2;
                        if (bool1)
                        {
                          localObject3 = r.PY((String)localObject2);
                          localObject1 = localObject2;
                          if (!((String)localObject3).equals(localObject2)) {
                            localObject1 = localObject3;
                          }
                        }
                      }
                      else
                      {
                        ad.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -2;
                        JsApiChooseMedia.a.j(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
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
                break label1036;
              }
            }
            this.kTU = i.k(((SightCaptureResult)localObject).vMu, false);
            if (bt.isNullOrNil(this.kTU))
            {
              ad.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
            }
            else
            {
              ad.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[] { this.kTU });
              if ((!PT(this.kTV)) && (PT(((SightCaptureResult)localObject).vMv))) {
                this.kTV = i.k(((SightCaptureResult)localObject).vMv, true);
              }
              ti(2131755359);
              com.tencent.mm.plugin.appbrand.z.m.bBp().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(188434);
                  if (new com.tencent.mm.vfs.e(JsApiChooseMedia.a.h(JsApiChooseMedia.a.this)).exists())
                  {
                    ad.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -1;
                    if (JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).kTQ) {}
                    AppBrandLocalVideoObject localAppBrandLocalVideoObject;
                    for (JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "mix";; JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video")
                    {
                      localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.h(JsApiChooseMedia.a.this), JsApiChooseMedia.a.f(JsApiChooseMedia.a.this).kTq);
                      if (localAppBrandLocalVideoObject != null) {
                        break;
                      }
                      ad.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.h(JsApiChooseMedia.a.this) });
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -2;
                      JsApiChooseMedia.a.k(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                      AppMethodBeat.o(188434);
                      return;
                    }
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.h(JsApiChooseMedia.a.this));
                    String str = JsApiChooseMedia.a.g(JsApiChooseMedia.a.this);
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).kTR = JsApiChooseMedia.a.c(localAppBrandLocalVideoObject.drH, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                    JsApiChooseMedia.a.l(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(188434);
                    return;
                  }
                  ad.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.h(JsApiChooseMedia.a.this) });
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bZU = -2;
                  JsApiChooseMedia.a.m(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(188434);
                }
              });
              AppMethodBeat.o(46459);
            }
          }
          else
          {
            ad.e("MicroMsg.JsApiChooseMedia", "data is null!");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia
 * JD-Core Version:    0.7.0.1
 */