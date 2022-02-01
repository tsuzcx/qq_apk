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
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
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
  private static volatile boolean kxE = false;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46489);
    if (kxE)
    {
      ac.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46489);
      return;
    }
    ac.i("MicroMsg.JsApiChooseMedia", "chooseMedia %s", new Object[] { paramJSONObject });
    Context localContext1 = paramc.getContext();
    if ((localContext1 == null) || (!(localContext1 instanceof Activity)))
    {
      ac.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
      paramc.h(paramInt, e("fail:page context is null", null));
      AppMethodBeat.o(46489);
      return;
    }
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(46489);
      return;
    }
    ac.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + paramJSONObject.toString());
    String str1 = "";
    if ((paramJSONObject.optJSONArray("sourceType") != null) && (paramJSONObject.optJSONArray("sourceType").length() > 0))
    {
      str1 = paramJSONObject.optJSONArray("sourceType").toString();
      if (!bs.isNullOrNil(str1)) {
        break label908;
      }
    }
    label901:
    label908:
    for (String str2 = "camera|album";; str2 = str1)
    {
      str1 = "";
      if ((paramJSONObject.optJSONArray("mediaType") != null) && (paramJSONObject.optJSONArray("mediaType").length() > 0))
      {
        str1 = paramJSONObject.optJSONArray("mediaType").toString();
        label240:
        if (!bs.isNullOrNil(str1)) {
          break label901;
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
          ac.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
          break;
          ac.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
          break label240;
        }
        String str4 = paramJSONObject.optString("camera");
        if (bs.isNullOrNil(str4)) {
          str4 = "back";
        }
        for (;;)
        {
          int j = Math.min(paramJSONObject.optInt("count", 9), 9);
          str1 = "";
          if ((paramJSONObject.optJSONArray("sizeType") != null) && (paramJSONObject.optJSONArray("sizeType").length() > 0))
          {
            str1 = paramJSONObject.optJSONArray("sizeType").toString();
            if (!bs.isNullOrNil(str1)) {
              break label895;
            }
            str1 = "original|compressed";
          }
          label587:
          label895:
          for (;;)
          {
            ac.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { str2, str3, Integer.valueOf(i), str4, Integer.valueOf(j), str1 });
            o.b(paramc.getAppId(), new a.a()
            {
              public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
              {
                AppMethodBeat.i(46430);
                if (paramAnonymousInt != 120)
                {
                  ac.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission requestCode is not for choose media");
                  AppMethodBeat.o(46430);
                  return;
                }
                if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
                {
                  ac.i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
                  JsApiChooseMedia.this.a(paramc, paramJSONObject, paramInt);
                  AppMethodBeat.o(46430);
                  return;
                }
                ac.e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
                paramc.h(paramInt, JsApiChooseMedia.this.e("fail:system permission denied", null));
                AppMethodBeat.o(46430);
              }
            });
            Context localContext2 = paramc.getContext();
            int k;
            if ((localContext2 == null) || (!(localContext2 instanceof Activity)))
            {
              ac.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
              paramc.h(paramInt, e("fail", null));
              k = 0;
            }
            boolean bool;
            for (;;)
            {
              if (k != 0) {
                break label587;
              }
              ac.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
              AppMethodBeat.o(46489);
              return;
              ac.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
              break;
              bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext2, "android.permission.RECORD_AUDIO", 120, "", "");
              k = bool;
              if (bool)
              {
                o.Qo(paramc.getAppId());
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
                  ac.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
                  AppMethodBeat.o(46431);
                  return;
                }
                if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
                {
                  ac.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                  JsApiChooseMedia.this.a(paramc, paramJSONObject, paramInt);
                  AppMethodBeat.o(46431);
                  return;
                }
                ac.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
                paramc.h(paramInt, JsApiChooseMedia.this.e("fail:system permission denied", null));
                AppMethodBeat.o(46431);
              }
            });
            paramJSONObject = paramc.getContext();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof Activity)))
            {
              ac.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
              paramc.h(paramInt, e("fail", null));
              k = 0;
            }
            while (k == 0)
            {
              ac.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
              AppMethodBeat.o(46489);
              return;
              bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 119, "", "");
              k = bool;
              if (bool)
              {
                o.Qo(paramc.getAppId());
                k = bool;
              }
            }
            ac.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
            kxE = true;
            g.a(paramc.getAppId(), new g.c()
            {
              public final void onResume()
              {
                AppMethodBeat.i(46428);
                ac.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
                JsApiChooseMedia.adZ();
                g.b(paramc.getAppId(), this);
                AppMethodBeat.o(46428);
              }
            });
            paramJSONObject = new ChooseRequest();
            paramJSONObject.appId = paramc.getAppId();
            paramJSONObject.kxG = str2.contains("album");
            paramJSONObject.kxH = str2.contains("camera");
            paramJSONObject.kxI = str3.contains("image");
            paramJSONObject.kxJ = str3.contains("video");
            if ((!str4.contains("back")) && (str4.contains("front"))) {}
            for (paramJSONObject.isFront = true;; paramJSONObject.isFront = false)
            {
              paramJSONObject.maxDuration = i;
              paramJSONObject.count = j;
              paramJSONObject.kxk = str1.contains("compressed");
              paramJSONObject.kxl = str1.contains("original");
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
    boolean kxG;
    boolean kxH;
    boolean kxI;
    boolean kxJ;
    boolean kxk;
    boolean kxl;
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
    
    public final Class<? extends AppBrandProxyUIProcessTask> bdj()
    {
      return JsApiChooseMedia.a.class;
    }
    
    public final boolean ben()
    {
      return true;
    }
    
    public final String beo()
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
        this.kxG = bool1;
        if (paramParcel.readByte() == 0) {
          break label140;
        }
        bool1 = true;
        label38:
        this.kxH = bool1;
        if (paramParcel.readByte() == 0) {
          break label145;
        }
        bool1 = true;
        label52:
        this.kxI = bool1;
        if (paramParcel.readByte() == 0) {
          break label150;
        }
        bool1 = true;
        label66:
        this.kxJ = bool1;
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
        this.kxk = bool1;
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
        this.kxl = bool1;
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
      if (this.kxG)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.kxH) {
          break label142;
        }
        b1 = 1;
        label39:
        paramParcel.writeByte(b1);
        if (!this.kxI) {
          break label147;
        }
        b1 = 1;
        label53:
        paramParcel.writeByte(b1);
        if (!this.kxJ) {
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
        if (!this.kxk) {
          break label162;
        }
        b1 = 1;
        label111:
        paramParcel.writeByte(b1);
        if (!this.kxl) {
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
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    int bPH;
    String kxK;
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
      this.bPH = paramParcel.readInt();
      this.type = paramParcel.readString();
      this.kxK = paramParcel.readString();
      AppMethodBeat.o(46438);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46439);
      paramParcel.writeInt(this.bPH);
      paramParcel.writeString(this.type);
      paramParcel.writeString(this.kxK);
      AppMethodBeat.o(46439);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private p fxw;
    private JsApiChooseMedia.ChooseResult kxL;
    private JsApiChooseMedia.ChooseRequest kxM;
    private String kxN;
    private String kxO;
    private com.tencent.mm.ui.tools.l kxP;
    int kxr;
    private DialogInterface.OnCancelListener kxv;
    
    private a()
    {
      AppMethodBeat.i(46453);
      this.kxL = new JsApiChooseMedia.ChooseResult();
      AppMethodBeat.o(46453);
    }
    
    private static boolean Mv(String paramString)
    {
      AppMethodBeat.i(46463);
      if (!TextUtils.isEmpty(paramString))
      {
        com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString);
        ac.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[] { paramString });
        if (locale.exists())
        {
          ac.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
          AppMethodBeat.o(46463);
          return true;
        }
        ac.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
        AppMethodBeat.o(46463);
        return false;
      }
      ac.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
      AppMethodBeat.o(46463);
      return false;
    }
    
    private AppBrandLocalVideoObject ap(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(186698);
      String str1 = paramString;
      if (paramBoolean) {}
      try
      {
        str1 = s.Mx(paramString);
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
            ac.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
            AppMethodBeat.o(186698);
            return null;
            localException = localException;
            ac.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bs.m(localException) });
            str2 = paramString;
          }
        }
        catch (Exception paramString)
        {
          String str2;
          for (;;)
          {
            ac.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
            paramString = null;
          }
          int i = bs.getInt(paramString.extractMetadata(18), 0);
          int j = bs.getInt(paramString.extractMetadata(19), 0);
          int k = bs.getInt(paramString.extractMetadata(9), 0);
          paramString.release();
          paramString = AppBrandLocalMediaObjectManager.cj(this.kxM.appId, str2);
          if (paramString == null)
          {
            ac.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
            AppMethodBeat.o(186698);
            return null;
          }
          paramString.duration = ((k + 500) / 1000);
          paramString.width = i;
          paramString.height = j;
          paramString.size = ((int)i.aSp(str2));
          ac.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[] { paramString });
          AppMethodBeat.o(186698);
        }
      }
      return paramString;
    }
    
    private static String b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(46465);
      if (bs.isNullOrNil(paramString1))
      {
        ac.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
        AppMethodBeat.o(46465);
        return "";
      }
      ac.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.array();
        localJSONStringer.object();
        localJSONStringer.key("tempFilePath");
        localJSONStringer.value(paramString1);
        localJSONStringer.key("thumbTempFilePath");
        localJSONStringer.value(paramString2);
        localJSONStringer.key("duration");
        localJSONStringer.value(String.valueOf(paramInt1));
        localJSONStringer.key("height");
        localJSONStringer.value(String.valueOf(paramInt2));
        localJSONStringer.key("width");
        localJSONStringer.value(String.valueOf(paramInt3));
        localJSONStringer.key("size");
        localJSONStringer.value(String.valueOf(paramInt4));
        localJSONStringer.endObject();
        localJSONStringer.endArray();
        paramString1 = localJSONStringer.toString();
        AppMethodBeat.o(46465);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramString1, "", new Object[0]);
        AppMethodBeat.o(46465);
      }
      return "";
    }
    
    private static String b(ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1)
    {
      AppMethodBeat.i(46464);
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        ac.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
        AppMethodBeat.o(46464);
        return "";
      }
      ac.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
      JSONStringer localJSONStringer = new JSONStringer();
      try
      {
        localJSONStringer.array();
        int i = 0;
        while (i < paramArrayList.size())
        {
          localJSONStringer.object();
          String str = (String)paramArrayList.get(i);
          Long localLong = (Long)paramArrayList1.get(i);
          localJSONStringer.key("tempFilePath");
          localJSONStringer.value(str);
          localJSONStringer.key("size");
          localJSONStringer.value(String.valueOf(localLong.longValue()));
          localJSONStringer.endObject();
          i += 1;
        }
        localJSONStringer.endArray();
        paramArrayList = localJSONStringer.toString();
        AppMethodBeat.o(46464);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        ac.printErrStackTrace("MicroMsg.JsApiChooseMedia", paramArrayList, "", new Object[0]);
        AppMethodBeat.o(46464);
      }
      return "";
    }
    
    private void bhD()
    {
      int i = 0;
      AppMethodBeat.i(46456);
      ac.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
      if ((this.kxM.kxJ) && (this.kxM.kxI)) {}
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("KEY_SIGHT_PARAMS", sG(i));
        com.tencent.mm.pluginsdk.ui.tools.q.a(bef(), 7, localIntent, 3, i);
        AppMethodBeat.o(46456);
        return;
        if (this.kxM.kxJ) {
          i = 1;
        } else if (this.kxM.kxI) {
          i = 2;
        }
      }
    }
    
    private void bhE()
    {
      int i = 3;
      boolean bool = true;
      AppMethodBeat.i(46458);
      ac.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
      Intent localIntent;
      if ((this.kxM.kxI) && (this.kxM.kxJ))
      {
        localIntent = new Intent();
        localIntent.putExtra("key_can_select_video_and_pic", true);
        if (this.kxM.kxk) {
          break label143;
        }
      }
      for (;;)
      {
        localIntent.putExtra("key_send_raw_image", bool);
        localIntent.putExtra("gallery_report_tag", 16);
        com.tencent.mm.pluginsdk.ui.tools.q.a(bef(), 8, this.kxM.count, this.kxr, i, localIntent);
        AppMethodBeat.o(46458);
        return;
        if (this.kxM.kxI)
        {
          i = 1;
          break;
        }
        if (!this.kxM.kxJ) {
          break;
        }
        i = 2;
        break;
        label143:
        bool = false;
      }
    }
    
    private void sF(int paramInt)
    {
      AppMethodBeat.i(186697);
      this.kxv = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(46452);
          ac.e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
          JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = 0;
          JsApiChooseMedia.a.m(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
          AppMethodBeat.o(46452);
        }
      };
      MMActivity localMMActivity = bef();
      ai.getResources().getString(2131755906);
      this.fxw = h.b(localMMActivity, ai.getResources().getString(paramInt), true, this.kxv);
      AppMethodBeat.o(186697);
    }
    
    private SightParams sG(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46457);
      String str1 = "microMsg." + System.currentTimeMillis() + ".jpg";
      this.kxN = i.k(com.tencent.mm.loader.j.b.aps() + "microMsg." + str1 + ".mp4", false);
      this.kxO = i.k(com.tencent.mm.loader.j.b.aps() + "microMsg." + str1 + ".jpeg", true);
      int j = this.kxM.maxDuration;
      SightParams localSightParams = new SightParams(3, 1);
      if (this.kxM.isFront) {}
      for (;;)
      {
        localSightParams.uJv = i;
        localSightParams.mode = paramInt;
        if (localSightParams.hcZ == null) {
          localSightParams.hcZ = new VideoTransPara();
        }
        localSightParams.hcZ.duration = j;
        localSightParams.uJC = false;
        String str2 = com.tencent.mm.loader.j.b.aps();
        localSightParams.r(str1, this.kxN, this.kxO, str2);
        AppMethodBeat.o(46457);
        return localSightParams;
        i = 2;
      }
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46454);
      this.kxM = ((JsApiChooseMedia.ChooseRequest)paramProcessRequest);
      if ((this.kxM.kxk & this.kxM.kxl))
      {
        i = 8;
        this.kxr = i;
        if (bs.iU(bef()) <= 200L) {
          break label199;
        }
      }
      label199:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          ac.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
          t.makeText(bef(), ai.getResources().getString(2131755358), 1).show();
        }
        ac.i("MicroMsg.JsApiChooseMedia", "goVideo");
        bef().mmSetOnActivityResultCallback(this);
        if ((!this.kxM.kxG) || (!this.kxM.kxH)) {
          break label204;
        }
        this.kxP = new com.tencent.mm.ui.tools.l(bef());
        this.kxP.a(new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(160599);
            ac.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = 0;
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
            AppMethodBeat.o(160599);
          }
        });
        this.kxP.a(null, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(46443);
            paramAnonymousContextMenu.add(0, 1, 0, JsApiChooseMedia.a.b(JsApiChooseMedia.a.this).getString(2131755747));
            paramAnonymousContextMenu.add(0, 2, 1, JsApiChooseMedia.a.c(JsApiChooseMedia.a.this).getString(2131755754));
            AppMethodBeat.o(46443);
          }
        }, new n.d()new e.b
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
            ac.e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = 0;
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
      if (this.kxM.kxG)
      {
        bhE();
        AppMethodBeat.o(46454);
        return;
      }
      if (this.kxM.kxH)
      {
        bhD();
        AppMethodBeat.o(46454);
        return;
      }
      this.kxL.bPH = -2;
      ac.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
      b(this.kxL);
      AppMethodBeat.o(46454);
    }
    
    public final void bem()
    {
      AppMethodBeat.i(46455);
      super.bem();
      if (this.fxw != null)
      {
        this.fxw.dismiss();
        this.fxw = null;
      }
      if (this.kxP != null)
      {
        this.kxP.dismiss();
        this.kxP = null;
      }
      AppMethodBeat.o(46455);
    }
    
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      boolean bool2 = true;
      final boolean bool1 = true;
      AppMethodBeat.i(46459);
      if (paramInt2 == 0)
      {
        ac.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
        this.kxL.bPH = 0;
        b(this.kxL);
        AppMethodBeat.o(46459);
        return;
      }
      if (-1 != paramInt2)
      {
        ac.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
        this.kxL.bPH = -2;
        b(this.kxL);
        AppMethodBeat.o(46459);
        return;
      }
      switch (paramInt1)
      {
      }
      for (;;)
      {
        this.kxL.bPH = -2;
        b(this.kxL);
        AppMethodBeat.o(46459);
        return;
        ac.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
        Object localObject = paramIntent.getStringArrayListExtra("key_select_video_list");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          this.kxN = i.k((String)((ArrayList)localObject).get(0), false);
          if (bs.isNullOrNil(this.kxN))
          {
            ac.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
          }
          else
          {
            sF(2131755359);
            com.tencent.mm.plugin.appbrand.utils.e.bxj().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(46446);
                if (new com.tencent.mm.vfs.e(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this)).exists())
                {
                  ac.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -1;
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                  AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this), JsApiChooseMedia.a.g(JsApiChooseMedia.a.this).kxk);
                  if (localAppBrandLocalVideoObject == null)
                  {
                    ac.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -2;
                    JsApiChooseMedia.a.c(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(46446);
                    return;
                  }
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                  String str = JsApiChooseMedia.a.h(JsApiChooseMedia.a.this);
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).kxK = JsApiChooseMedia.a.c(localAppBrandLocalVideoObject.dgl, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                  JsApiChooseMedia.a.d(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46446);
                  return;
                }
                ac.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -2;
                JsApiChooseMedia.a.e(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                AppMethodBeat.o(46446);
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
            ac.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
            this.kxL.bPH = -2;
            b(this.kxL);
            AppMethodBeat.o(46459);
            return;
          }
          bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
          final int i = this.kxM.kxk;
          if (!this.kxM.kxl)
          {
            paramInt1 = 1;
            if (((paramInt1 & i) == 0) && (!(this.kxM.kxk & this.kxM.kxl & bool2))) {
              break label477;
            }
            i = 1;
            label347:
            ac.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.kxM.kxk), Boolean.valueOf(this.kxM.kxl), Boolean.valueOf(bool2), Boolean.valueOf(i) });
            if (i != 0) {
              sF(2131755359);
            }
            if ((i != 0) || (!q.bn((List)localObject))) {
              break label483;
            }
          }
          for (;;)
          {
            if (bool1) {
              sF(2131755360);
            }
            com.tencent.mm.plugin.appbrand.z.l.bxj().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(46448);
                final ArrayList localArrayList1 = new ArrayList(this.kxx.size());
                final ArrayList localArrayList2 = new ArrayList(this.kxx.size());
                Iterator localIterator = this.kxx.iterator();
                Object localObject1;
                Object localObject2;
                boolean bool;
                if (localIterator.hasNext())
                {
                  localObject1 = (String)localIterator.next();
                  if (i)
                  {
                    localObject2 = q.Mz((String)localObject1);
                    if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                      break label260;
                    }
                    bool = true;
                    localObject1 = localObject2;
                  }
                }
                for (;;)
                {
                  localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseMedia.a.g(JsApiChooseMedia.a.this).appId, (String)localObject1, bool);
                  if (localObject2 != null)
                  {
                    localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject2).ixc));
                    localArrayList2.add(((AppBrandLocalMediaObject)localObject2).dgl);
                    break;
                    if (!bool1) {
                      break label260;
                    }
                    localObject2 = q.MA((String)localObject1);
                    if (((String)localObject2).equals(localObject1)) {
                      break label260;
                    }
                    bool = true;
                    localObject1 = localObject2;
                    continue;
                  }
                  ac.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[] { localObject1 });
                  break;
                  if (localArrayList2.size() == 0)
                  {
                    ac.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -2;
                    JsApiChooseMedia.a.f(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(46448);
                    return;
                  }
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(46447);
                      ac.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -1;
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image";
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).kxK = JsApiChooseMedia.a.c(localArrayList2, localArrayList1);
                      JsApiChooseMedia.a.g(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                      AppMethodBeat.o(46447);
                    }
                  });
                  AppMethodBeat.o(46448);
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
            label477:
            i = 0;
            break label347;
            label483:
            bool1 = false;
          }
          ac.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
          if (paramIntent != null)
          {
            ac.i("MicroMsg.JsApiChooseMedia", "data is valid!");
            localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
            if (localObject == null)
            {
              ac.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
              this.kxL.bPH = -2;
              b(this.kxL);
              AppMethodBeat.o(46459);
              return;
            }
            if (((SightCaptureResult)localObject).uJm)
            {
              localObject = i.k(((SightCaptureResult)localObject).uJu, false);
              if (bs.isNullOrNil((String)localObject))
              {
                ac.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
                this.kxL.bPH = -2;
                b(this.kxL);
                AppMethodBeat.o(46459);
                return;
              }
              bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
              final int j = this.kxM.kxk;
              if (!this.kxM.kxl)
              {
                paramInt1 = 1;
                if (((paramInt1 & j) == 0) && (!(this.kxM.kxk & this.kxM.kxl & bool1))) {
                  break label822;
                }
                j = 1;
                label688:
                ac.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.TRUE, Boolean.valueOf(this.kxM.kxk), Boolean.valueOf(this.kxM.kxl), Boolean.valueOf(bool1), Boolean.valueOf(j) });
                if (j != 0) {
                  sF(2131755359);
                }
                if ((j != 0) || (!q.ME((String)localObject))) {
                  break label828;
                }
              }
              label822:
              label828:
              for (bool1 = bool2;; bool1 = false)
              {
                if (bool1) {
                  sF(2131755360);
                }
                com.tencent.mm.plugin.appbrand.z.l.bxj().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(46450);
                    Object localObject2 = this.val$filePath;
                    Object localObject1;
                    if (j)
                    {
                      localObject1 = q.Mz((String)localObject2);
                      if ((localObject1 == null) || (((String)localObject1).equals(localObject2))) {
                        break label189;
                      }
                    }
                    for (;;)
                    {
                      localObject2 = new ArrayList();
                      Object localObject3 = new ArrayList();
                      localObject1 = AppBrandLocalMediaObjectManager.h(JsApiChooseMedia.a.g(JsApiChooseMedia.a.this).appId, (String)localObject1, true);
                      if (localObject1 != null)
                      {
                        ((ArrayList)localObject2).add(Long.valueOf(((AppBrandLocalMediaObject)localObject1).ixc));
                        ((ArrayList)localObject3).add(((AppBrandLocalMediaObject)localObject1).dgl);
                        ap.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(46449);
                            ac.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -1;
                            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "image";
                            JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).kxK = JsApiChooseMedia.a.c(this.kxR, this.kxU);
                            JsApiChooseMedia.a.h(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                            AppMethodBeat.o(46449);
                          }
                        });
                        AppMethodBeat.o(46450);
                        return;
                        localObject1 = localObject2;
                        if (bool1)
                        {
                          localObject3 = q.MA((String)localObject2);
                          localObject1 = localObject2;
                          if (!((String)localObject3).equals(localObject2)) {
                            localObject1 = localObject3;
                          }
                        }
                      }
                      else
                      {
                        ac.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
                        JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -2;
                        JsApiChooseMedia.a.i(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                        AppMethodBeat.o(46450);
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
                j = 0;
                break label688;
              }
            }
            this.kxN = i.k(((SightCaptureResult)localObject).uJo, false);
            if (bs.isNullOrNil(this.kxN))
            {
              ac.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
            }
            else
            {
              ac.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[] { this.kxN });
              if ((!Mv(this.kxO)) && (Mv(((SightCaptureResult)localObject).uJp))) {
                this.kxO = i.k(((SightCaptureResult)localObject).uJp, true);
              }
              sF(2131755359);
              com.tencent.mm.plugin.appbrand.z.l.bxj().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(46451);
                  if (new com.tencent.mm.vfs.e(JsApiChooseMedia.a.f(JsApiChooseMedia.a.this)).exists())
                  {
                    ac.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -1;
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).type = "video";
                    AppBrandLocalVideoObject localAppBrandLocalVideoObject = JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this), JsApiChooseMedia.a.g(JsApiChooseMedia.a.this).kxk);
                    if (localAppBrandLocalVideoObject == null)
                    {
                      ac.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                      JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -2;
                      JsApiChooseMedia.a.j(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                      AppMethodBeat.o(46451);
                      return;
                    }
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this, JsApiChooseMedia.a.f(JsApiChooseMedia.a.this));
                    String str = JsApiChooseMedia.a.h(JsApiChooseMedia.a.this);
                    JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).kxK = JsApiChooseMedia.a.c(localAppBrandLocalVideoObject.dgl, str, localAppBrandLocalVideoObject.duration, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.size);
                    JsApiChooseMedia.a.k(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                    AppMethodBeat.o(46451);
                    return;
                  }
                  ac.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { JsApiChooseMedia.a.f(JsApiChooseMedia.a.this) });
                  JsApiChooseMedia.a.a(JsApiChooseMedia.a.this).bPH = -2;
                  JsApiChooseMedia.a.l(JsApiChooseMedia.a.this, JsApiChooseMedia.a.a(JsApiChooseMedia.a.this));
                  AppMethodBeat.o(46451);
                }
              });
              AppMethodBeat.o(46459);
            }
          }
          else
          {
            ac.e("MicroMsg.JsApiChooseMedia", "data is null!");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia
 * JD-Core Version:    0.7.0.1
 */