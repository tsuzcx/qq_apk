package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.media.h.d.b;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMultiMedia
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 549;
  public static final String NAME = "chooseMultiMedia";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46542);
    if (n.Do(paramc.getAppId()).iFT)
    {
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46542);
      return;
    }
    final Context localContext = paramc.getContext();
    if (!(localContext instanceof Activity))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46542);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(46542);
      return;
    }
    int i = paramJSONObject.optInt("maxDuration", 10);
    ad.i("MicroMsg.JsApiChooseMultiMedia", "videoMaxDuration: %d.", new Object[] { Integer.valueOf(i) });
    if ((i <= 0) || (i > 1800))
    {
      ad.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, invalid maxDuration parameter");
      paramc.h(paramInt, e("fail:invalid maxDuration parameter", null));
      AppMethodBeat.o(46542);
      return;
    }
    localContext.getSharedPreferences(aj.eFD() + "_locCache", 0).edit().putString("locStr", null).apply();
    Object localObject1 = new a.b()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, com.tencent.mm.plugin.appbrand.utils.b.a.a paramAnonymousa)
      {
        AppMethodBeat.i(46493);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousInt = (int)(paramAnonymousa.latitude * 1000000.0D);
          int i = (int)(paramAnonymousa.longitude * 1000000.0D);
          paramAnonymousString = new StringBuilder();
          paramAnonymousString.append(paramAnonymousInt);
          paramAnonymousString.append(",");
          paramAnonymousString.append(i);
          localContext.getSharedPreferences(aj.eFD() + "_locCache", 0).edit().putString("locStr", paramAnonymousString.toString()).apply();
          ad.d("MicroMsg.JsApiChooseMultiMedia", "onLocationChange latitude %f, longitude: %f, locStr: %s.", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude), paramAnonymousString });
          ((com.tencent.mm.plugin.appbrand.utils.b.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("wgs84", this, null);
          AppMethodBeat.o(46493);
          return;
        }
        ad.e("MicroMsg.JsApiChooseMultiMedia", "onLocationChange error, errCode: %d.", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(46493);
      }
    };
    ((com.tencent.mm.plugin.appbrand.utils.b.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("wgs84", (a.b)localObject1, null);
    int j = paramJSONObject.optInt("count", 9);
    localObject1 = paramJSONObject.optJSONObject("location");
    double d2 = 181.0D;
    double d1 = 91.0D;
    boolean bool1;
    if (localObject1 != null)
    {
      d2 = ((JSONObject)localObject1).optDouble("longitude");
      d1 = ((JSONObject)localObject1).optDouble("latitude");
      if ((!Double.isNaN(d2)) && (!Double.isNaN(d1))) {
        break label782;
      }
      d2 = 181.0D;
      d1 = 91.0D;
      bool1 = true;
    }
    for (;;)
    {
      localObject1 = paramJSONObject.optString("poiName", null);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = paramc.getContext().getString(2131756002);
      }
      for (;;)
      {
        double d3 = paramJSONObject.optDouble("locationRadius", 50.0D);
        Object localObject2 = paramJSONObject.optJSONArray("sourceType");
        JSONArray localJSONArray = paramJSONObject.optJSONArray("cameraType");
        int k = paramJSONObject.optInt("pickAlbumType", 0);
        boolean bool2;
        boolean bool3;
        label428:
        boolean bool5;
        boolean bool4;
        label447:
        int m;
        if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
        {
          bool2 = true;
          bool3 = true;
          if ((localJSONArray != null) && (localJSONArray.length() != 0)) {
            break label549;
          }
          bool5 = false;
          bool4 = false;
          if (!bool2) {
            break label623;
          }
          o.b(paramc.getAppId(), new JsApiChooseMultiMedia.4(this, paramc, paramJSONObject, paramInt));
          paramJSONObject = paramc.getContext();
          if ((paramJSONObject instanceof Activity)) {
            break label578;
          }
          paramc.h(paramInt, e("fail", null));
          m = 0;
        }
        for (;;)
        {
          if (m != 0) {
            break label623;
          }
          AppMethodBeat.o(46542);
          return;
          bool1 = true;
          break;
          bool2 = ((JSONArray)localObject2).toString().contains("camera");
          bool3 = ((JSONArray)localObject2).toString().contains("album");
          break label428;
          label549:
          bool4 = localJSONArray.toString().contains("video");
          bool5 = localJSONArray.toString().contains("photo");
          break label447;
          label578:
          boolean bool6 = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
          m = bool6;
          if (bool6)
          {
            o.Mi(paramc.getAppId());
            m = bool6;
          }
        }
        label623:
        n.Dp(paramc.getAppId()).iFT = true;
        com.tencent.mm.plugin.appbrand.g.a(paramc.getAppId(), new JsApiChooseMultiMedia.2(this, paramc));
        paramJSONObject = new ChooseRequest();
        paramJSONObject.appId = paramc.getAppId();
        paramJSONObject.count = j;
        localObject2 = com.tencent.mm.modelgeo.a.a.c(d2, d1);
        paramJSONObject.longitude = localObject2[0];
        paramJSONObject.latitude = localObject2[1];
        paramJSONObject.goQ = ((String)localObject1);
        paramJSONObject.hqY = d3;
        paramJSONObject.jWw = bool2;
        paramJSONObject.jWx = bool3;
        paramJSONObject.iBF = i;
        paramJSONObject.jXp = bool4;
        paramJSONObject.jXq = bool5;
        paramJSONObject.jXr = k;
        paramJSONObject.jXs = bool1;
        com.tencent.mm.plugin.appbrand.ipc.a.a(localContext, paramJSONObject, new AppBrandProxyUIProcessTask.b() {});
        AppMethodBeat.o(46542);
        return;
      }
      label782:
      bool1 = false;
    }
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int count;
    String goQ;
    double hqY;
    int iBF;
    boolean jWw;
    boolean jWx;
    boolean jXp;
    boolean jXq;
    int jXr;
    boolean jXs;
    double latitude;
    double longitude;
    
    static
    {
      AppMethodBeat.i(46501);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46501);
    }
    
    ChooseRequest() {}
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46500);
      j(paramParcel);
      AppMethodBeat.o(46500);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> aWl()
    {
      return JsApiChooseMultiMedia.a.class;
    }
    
    public final boolean aXq()
    {
      return true;
    }
    
    public final String aXr()
    {
      return "GalleryChooseMultiMedia";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46499);
      this.appId = paramParcel.readString();
      this.count = paramParcel.readInt();
      this.longitude = paramParcel.readDouble();
      this.latitude = paramParcel.readDouble();
      this.goQ = paramParcel.readString();
      this.hqY = paramParcel.readDouble();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.jWw = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label78:
        this.jWx = bool1;
        this.iBF = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
        bool1 = true;
        label100:
        this.jXp = bool1;
        if (paramParcel.readByte() == 0) {
          break label162;
        }
        bool1 = true;
        label114:
        this.jXq = bool1;
        this.jXr = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label167;
        }
      }
      label152:
      label157:
      label162:
      label167:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jXs = bool1;
        AppMethodBeat.o(46499);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label78;
        bool1 = false;
        break label100;
        bool1 = false;
        break label114;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46498);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.count);
      paramParcel.writeDouble(this.longitude);
      paramParcel.writeDouble(this.latitude);
      paramParcel.writeString(this.goQ);
      paramParcel.writeDouble(this.hqY);
      if (this.jWw)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.jWx) {
          break label154;
        }
        b1 = 1;
        label79:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.iBF);
        if (!this.jXp) {
          break label159;
        }
        b1 = 1;
        label101:
        paramParcel.writeByte(b1);
        if (!this.jXq) {
          break label164;
        }
        b1 = 1;
        label115:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.jXr);
        if (!this.jXs) {
          break label169;
        }
      }
      label154:
      label159:
      label164:
      label169:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(46498);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label79;
        b1 = 0;
        break label101;
        b1 = 0;
        break label115;
      }
    }
  }
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    int bRZ;
    String jXt;
    
    static
    {
      AppMethodBeat.i(46505);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46505);
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
      AppMethodBeat.i(46503);
      this.bRZ = paramParcel.readInt();
      this.jXt = paramParcel.readString();
      AppMethodBeat.o(46503);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46504);
      paramParcel.writeInt(this.bRZ);
      paramParcel.writeString(this.jXt);
      AppMethodBeat.o(46504);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private p ftP;
    int jWF;
    private DialogInterface.OnCancelListener jWJ;
    JsApiChooseMultiMedia.ChooseRequest jXu;
    JsApiChooseMultiMedia.ChooseResult jXv;
    
    private a()
    {
      AppMethodBeat.i(46511);
      this.jXv = new JsApiChooseMultiMedia.ChooseResult();
      this.jWF = 7;
      AppMethodBeat.o(46511);
    }
    
    private static String Iq(String paramString)
    {
      AppMethodBeat.i(46524);
      int i = Exif.fromFile(paramString).getOrientationInDegree();
      if (i != 0) {
        try
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          Object localObject1 = MMBitmapFactory.decodeFile(paramString, localOptions);
          if (localObject1 == null)
          {
            ad.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, get null bmp");
            AppMethodBeat.o(46524);
            return paramString;
          }
          float f = i % 360;
          Bitmap localBitmap = f.a((Bitmap)localObject1, f);
          Object localObject2 = new StringBuilder().append(com.tencent.mm.loader.j.b.ais()).append("microMsg.tmp.").append(System.currentTimeMillis());
          if (com.tencent.mm.plugin.appbrand.utils.c.d(localOptions))
          {
            localObject1 = ".jpg";
            localObject2 = (String)localObject1;
            if (!com.tencent.mm.plugin.appbrand.utils.c.d(localOptions)) {
              break label165;
            }
          }
          for (localObject1 = Bitmap.CompressFormat.JPEG;; localObject1 = Bitmap.CompressFormat.PNG)
          {
            try
            {
              f.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
              if (com.tencent.mm.plugin.appbrand.utils.c.d(localOptions)) {
                com.tencent.mm.plugin.appbrand.m.b.cH(paramString, (String)localObject2);
              }
              AppMethodBeat.o(46524);
              return localObject2;
            }
            catch (Exception localException)
            {
              label165:
              ad.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, exception occurred when saving | %s", new Object[] { localException });
              i.deleteFile((String)localObject2);
              AppMethodBeat.o(46524);
              return paramString;
            }
            localObject1 = ".png";
            break;
          }
          AppMethodBeat.o(46524);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          AppMethodBeat.o(46524);
          return paramString;
        }
        catch (NullPointerException localNullPointerException)
        {
          AppMethodBeat.o(46524);
          return paramString;
        }
      }
      return paramString;
    }
    
    private static String Ir(String paramString)
    {
      AppMethodBeat.i(46523);
      String str = i.k(com.tencent.mm.loader.j.b.ais() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
      try
      {
        Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
        if (localBitmap1 == null)
        {
          ad.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp return null");
          AppMethodBeat.o(46523);
          return null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          ad.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom");
          try
          {
            Bitmap localBitmap2 = f.decodeFile(paramString, null);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            ad.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, oom again");
            Object localObject1 = null;
          }
          catch (Exception localException1)
          {
            ad.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
            Object localObject2 = null;
          }
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          try
          {
            Bitmap localBitmap3 = f.decodeFile(paramString, null);
          }
          catch (Exception localException2)
          {
            ad.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
            Object localObject3 = null;
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          ad.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
          Object localObject4 = null;
        }
        long l = bt.eGO();
        boolean bool = com.tencent.mm.plugin.appbrand.utils.c.dX(str, paramString);
        ad.i("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bt.eGO() - l), paramString, Long.valueOf(i.aMN(paramString)), str, Long.valueOf(i.aMN(str)) });
        if (bool)
        {
          AppMethodBeat.o(46523);
          return str;
        }
        AppMethodBeat.o(46523);
      }
      return paramString;
    }
    
    /* Error */
    private static String Iy(String paramString)
    {
      // Byte code:
      //   0: ldc 236
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: iconst_2
      //   6: newarray int
      //   8: astore 13
      //   10: new 238	com/tencent/mm/compatible/h/d
      //   13: dup
      //   14: invokespecial 239	com/tencent/mm/compatible/h/d:<init>	()V
      //   17: astore 12
      //   19: aload 12
      //   21: aload_0
      //   22: invokevirtual 245	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
      //   25: aload 12
      //   27: bipush 18
      //   29: invokevirtual 249	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
      //   32: iconst_0
      //   33: invokestatic 253	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
      //   36: istore 6
      //   38: aload 12
      //   40: bipush 19
      //   42: invokevirtual 249	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
      //   45: iconst_0
      //   46: invokestatic 253	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
      //   49: istore 7
      //   51: aload 13
      //   53: iconst_0
      //   54: iload 6
      //   56: iastore
      //   57: aload 13
      //   59: iconst_1
      //   60: iload 7
      //   62: iastore
      //   63: invokestatic 259	com/tencent/mm/modelcontrol/d:awT	()Lcom/tencent/mm/modelcontrol/d;
      //   66: invokevirtual 263	com/tencent/mm/modelcontrol/d:axa	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
      //   69: astore 14
      //   71: aload 14
      //   73: getfield 268	com/tencent/mm/modelcontrol/VideoTransPara:width	I
      //   76: istore_3
      //   77: aload 14
      //   79: getfield 271	com/tencent/mm/modelcontrol/VideoTransPara:height	I
      //   82: istore 4
      //   84: ldc 93
      //   86: new 108	java/lang/StringBuilder
      //   89: dup
      //   90: ldc_w 273
      //   93: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   96: iload 6
      //   98: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   101: ldc_w 280
      //   104: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: iload 7
      //   109: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   112: ldc_w 282
      //   115: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   118: iload_3
      //   119: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   122: ldc_w 284
      //   125: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   128: iload 4
      //   130: invokevirtual 278	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   133: ldc_w 286
      //   136: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   139: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   142: invokestatic 288	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   145: iload 6
      //   147: iload_3
      //   148: if_icmpgt +275 -> 423
      //   151: iload 7
      //   153: iload 4
      //   155: if_icmpgt +268 -> 423
      //   158: ldc 93
      //   160: ldc_w 290
      //   163: invokestatic 292	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   166: aconst_null
      //   167: astore 11
      //   169: aload 11
      //   171: ifnull +21 -> 192
      //   174: aload 13
      //   176: iconst_0
      //   177: aload 11
      //   179: getfield 297	android/graphics/Point:x	I
      //   182: iastore
      //   183: aload 13
      //   185: iconst_1
      //   186: aload 11
      //   188: getfield 300	android/graphics/Point:y	I
      //   191: iastore
      //   192: ldc 93
      //   194: ldc_w 302
      //   197: bipush 6
      //   199: anewarray 164	java/lang/Object
      //   202: dup
      //   203: iconst_0
      //   204: iload 6
      //   206: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   209: aastore
      //   210: dup
      //   211: iconst_1
      //   212: iload 7
      //   214: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   217: aastore
      //   218: dup
      //   219: iconst_2
      //   220: aload 14
      //   222: getfield 268	com/tencent/mm/modelcontrol/VideoTransPara:width	I
      //   225: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   228: aastore
      //   229: dup
      //   230: iconst_3
      //   231: aload 14
      //   233: getfield 271	com/tencent/mm/modelcontrol/VideoTransPara:height	I
      //   236: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   239: aastore
      //   240: dup
      //   241: iconst_4
      //   242: aload 13
      //   244: iconst_0
      //   245: iaload
      //   246: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   249: aastore
      //   250: dup
      //   251: iconst_5
      //   252: aload 13
      //   254: iconst_1
      //   255: iaload
      //   256: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   259: aastore
      //   260: invokestatic 309	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   263: aload 12
      //   265: invokevirtual 312	android/media/MediaMetadataRetriever:release	()V
      //   268: aload 13
      //   270: iconst_0
      //   271: iaload
      //   272: istore_3
      //   273: aload 13
      //   275: iconst_1
      //   276: iaload
      //   277: istore 4
      //   279: new 108	java/lang/StringBuilder
      //   282: dup
      //   283: invokespecial 109	java/lang/StringBuilder:<init>	()V
      //   286: invokestatic 115	com/tencent/mm/loader/j/b:ais	()Ljava/lang/String;
      //   289: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   292: ldc 176
      //   294: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   297: invokestatic 127	java/lang/System:currentTimeMillis	()J
      //   300: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   303: ldc_w 314
      //   306: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   309: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   312: astore 11
      //   314: invokestatic 259	com/tencent/mm/modelcontrol/d:awT	()Lcom/tencent/mm/modelcontrol/d;
      //   317: invokevirtual 263	com/tencent/mm/modelcontrol/d:axa	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
      //   320: astore 12
      //   322: ldc 93
      //   324: ldc_w 316
      //   327: iconst_1
      //   328: anewarray 164	java/lang/Object
      //   331: dup
      //   332: iconst_0
      //   333: aload 12
      //   335: getfield 319	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
      //   338: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   341: aastore
      //   342: invokestatic 309	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   345: new 321	java/util/concurrent/CountDownLatch
      //   348: dup
      //   349: iconst_1
      //   350: invokespecial 323	java/util/concurrent/CountDownLatch:<init>	(I)V
      //   353: astore 13
      //   355: getstatic 329	com/tencent/mm/media/h/d:gsN	Lcom/tencent/mm/media/h/d$a;
      //   358: aload_0
      //   359: aload 11
      //   361: iload_3
      //   362: iload 4
      //   364: aload 12
      //   366: getfield 319	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
      //   369: aload 12
      //   371: getfield 332	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
      //   374: aload 12
      //   376: getfield 335	com/tencent/mm/modelcontrol/VideoTransPara:gnp	I
      //   379: aload 12
      //   381: getfield 338	com/tencent/mm/modelcontrol/VideoTransPara:gnq	I
      //   384: new 17	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5
      //   387: dup
      //   388: aload 13
      //   390: invokespecial 341	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5:<init>	(Ljava/util/concurrent/CountDownLatch;)V
      //   393: invokeinterface 346 10 0
      //   398: invokevirtual 349	com/tencent/mm/media/h/d:akd	()I
      //   401: pop
      //   402: ldc 93
      //   404: ldc_w 351
      //   407: invokestatic 288	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   410: aload 13
      //   412: invokevirtual 354	java/util/concurrent/CountDownLatch:await	()V
      //   415: ldc 236
      //   417: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   420: aload 11
      //   422: areturn
      //   423: iload 6
      //   425: iload 7
      //   427: invokestatic 360	java/lang/Math:max	(II)I
      //   430: istore 10
      //   432: iload 6
      //   434: iload 7
      //   436: invokestatic 363	java/lang/Math:min	(II)I
      //   439: istore 9
      //   441: iload_3
      //   442: iload 4
      //   444: invokestatic 360	java/lang/Math:max	(II)I
      //   447: istore 5
      //   449: iload_3
      //   450: iload 4
      //   452: invokestatic 363	java/lang/Math:min	(II)I
      //   455: istore 8
      //   457: iload 10
      //   459: bipush 16
      //   461: irem
      //   462: ifne +51 -> 513
      //   465: iload 10
      //   467: iload 5
      //   469: isub
      //   470: invokestatic 367	java/lang/Math:abs	(I)I
      //   473: bipush 16
      //   475: if_icmpge +38 -> 513
      //   478: iload 9
      //   480: bipush 16
      //   482: irem
      //   483: ifne +30 -> 513
      //   486: iload 9
      //   488: iload 8
      //   490: isub
      //   491: invokestatic 367	java/lang/Math:abs	(I)I
      //   494: bipush 16
      //   496: if_icmpge +17 -> 513
      //   499: ldc 93
      //   501: ldc_w 369
      //   504: invokestatic 292	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   507: aconst_null
      //   508: astore 11
      //   510: goto -341 -> 169
      //   513: iload 10
      //   515: iconst_2
      //   516: idiv
      //   517: istore 10
      //   519: iload 9
      //   521: iconst_2
      //   522: idiv
      //   523: istore 9
      //   525: iload 10
      //   527: bipush 16
      //   529: irem
      //   530: ifne +106 -> 636
      //   533: iload 10
      //   535: iload 5
      //   537: isub
      //   538: invokestatic 367	java/lang/Math:abs	(I)I
      //   541: bipush 16
      //   543: if_icmpge +93 -> 636
      //   546: iload 9
      //   548: bipush 16
      //   550: irem
      //   551: ifne +85 -> 636
      //   554: iload 9
      //   556: iload 8
      //   558: isub
      //   559: invokestatic 367	java/lang/Math:abs	(I)I
      //   562: bipush 16
      //   564: if_icmpge +72 -> 636
      //   567: ldc 93
      //   569: ldc_w 371
      //   572: invokestatic 292	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   575: iload 6
      //   577: iconst_2
      //   578: idiv
      //   579: istore_3
      //   580: iload 7
      //   582: iconst_2
      //   583: idiv
      //   584: istore 4
      //   586: iload_3
      //   587: iconst_2
      //   588: irem
      //   589: ifeq +196 -> 785
      //   592: iload_3
      //   593: iconst_1
      //   594: iadd
      //   595: istore_3
      //   596: goto +189 -> 785
      //   599: new 294	android/graphics/Point
      //   602: dup
      //   603: iload_3
      //   604: iload 4
      //   606: invokespecial 374	android/graphics/Point:<init>	(II)V
      //   609: astore 11
      //   611: goto -442 -> 169
      //   614: astore_0
      //   615: aload 12
      //   617: astore 11
      //   619: aload 11
      //   621: ifnull +8 -> 629
      //   624: aload 11
      //   626: invokevirtual 312	android/media/MediaMetadataRetriever:release	()V
      //   629: ldc 236
      //   631: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   634: aload_0
      //   635: athrow
      //   636: new 294	android/graphics/Point
      //   639: dup
      //   640: invokespecial 375	android/graphics/Point:<init>	()V
      //   643: astore 11
      //   645: iload 6
      //   647: iload 7
      //   649: if_icmpge +75 -> 724
      //   652: iload_3
      //   653: iload 4
      //   655: invokestatic 363	java/lang/Math:min	(II)I
      //   658: istore_3
      //   659: dconst_1
      //   660: iload 6
      //   662: i2d
      //   663: dmul
      //   664: iload_3
      //   665: i2d
      //   666: ddiv
      //   667: dstore_1
      //   668: iload 7
      //   670: i2d
      //   671: dload_1
      //   672: ddiv
      //   673: d2i
      //   674: istore 4
      //   676: goto +125 -> 801
      //   679: ldc 93
      //   681: ldc_w 377
      //   684: iconst_2
      //   685: anewarray 164	java/lang/Object
      //   688: dup
      //   689: iconst_0
      //   690: iload 4
      //   692: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   695: aastore
      //   696: dup
      //   697: iconst_1
      //   698: iload 5
      //   700: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   703: aastore
      //   704: invokestatic 232	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   707: aload 11
      //   709: iload 4
      //   711: putfield 297	android/graphics/Point:x	I
      //   714: aload 11
      //   716: iload 5
      //   718: putfield 300	android/graphics/Point:y	I
      //   721: goto -552 -> 169
      //   724: iload_3
      //   725: iload 4
      //   727: invokestatic 363	java/lang/Math:min	(II)I
      //   730: istore 4
      //   732: dconst_1
      //   733: iload 7
      //   735: i2d
      //   736: dmul
      //   737: iload 4
      //   739: i2d
      //   740: ddiv
      //   741: dstore_1
      //   742: iload 6
      //   744: i2d
      //   745: dload_1
      //   746: ddiv
      //   747: d2i
      //   748: istore_3
      //   749: goto +52 -> 801
      //   752: astore_0
      //   753: ldc 93
      //   755: ldc_w 379
      //   758: iconst_1
      //   759: anewarray 164	java/lang/Object
      //   762: dup
      //   763: iconst_0
      //   764: aload_0
      //   765: invokevirtual 382	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   768: aastore
      //   769: invokestatic 167	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   772: goto -357 -> 415
      //   775: astore_0
      //   776: aconst_null
      //   777: astore 11
      //   779: goto -160 -> 619
      //   782: goto -183 -> 599
      //   785: iload 4
      //   787: iconst_2
      //   788: irem
      //   789: ifeq -7 -> 782
      //   792: iload 4
      //   794: iconst_1
      //   795: iadd
      //   796: istore 4
      //   798: goto -199 -> 599
      //   801: iload 4
      //   803: istore 5
      //   805: iload 4
      //   807: iconst_2
      //   808: irem
      //   809: ifeq +9 -> 818
      //   812: iload 4
      //   814: iconst_1
      //   815: iadd
      //   816: istore 5
      //   818: iload_3
      //   819: istore 4
      //   821: iload_3
      //   822: iconst_2
      //   823: irem
      //   824: ifeq -145 -> 679
      //   827: iload_3
      //   828: iconst_1
      //   829: iadd
      //   830: istore 4
      //   832: goto -153 -> 679
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	835	0	paramString	String
      //   667	79	1	d	double
      //   76	754	3	i	int
      //   82	749	4	j	int
      //   447	370	5	k	int
      //   36	707	6	m	int
      //   49	685	7	n	int
      //   455	104	8	i1	int
      //   439	120	9	i2	int
      //   430	108	10	i3	int
      //   167	611	11	localObject1	Object
      //   17	599	12	localObject2	Object
      //   8	403	13	localObject3	Object
      //   69	163	14	localVideoTransPara	com.tencent.mm.modelcontrol.VideoTransPara
      // Exception table:
      //   from	to	target	type
      //   19	51	614	finally
      //   63	145	614	finally
      //   158	166	614	finally
      //   174	192	614	finally
      //   192	263	614	finally
      //   423	457	614	finally
      //   465	478	614	finally
      //   486	507	614	finally
      //   513	525	614	finally
      //   533	546	614	finally
      //   554	586	614	finally
      //   599	611	614	finally
      //   636	645	614	finally
      //   652	676	614	finally
      //   679	721	614	finally
      //   724	732	614	finally
      //   402	415	752	java/lang/InterruptedException
      //   10	19	775	finally
    }
    
    private static String Iz(String paramString)
    {
      AppMethodBeat.i(46520);
      String str2 = "";
      String str1 = str2;
      if (!bt.isNullOrNil(paramString))
      {
        Object localObject = new com.tencent.mm.vfs.e(paramString);
        str1 = str2;
        if (((com.tencent.mm.vfs.e)localObject).exists())
        {
          localObject = ((com.tencent.mm.vfs.e)localObject).getName();
          str2 = null;
          str1 = str2;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            str1 = str2;
            if (((String)localObject).contains(".")) {
              str1 = ((String)localObject).substring(0, ((String)localObject).lastIndexOf("."));
            }
          }
          if (!TextUtils.isEmpty(str1)) {
            if ((com.tencent.mm.loader.j.b.ais() != null) && (com.tencent.mm.loader.j.b.ais().endsWith("/"))) {
              str1 = com.tencent.mm.loader.j.b.ais() + str1 + System.currentTimeMillis() + ".jpeg";
            }
          }
          for (;;)
          {
            if (new com.tencent.mm.vfs.e(str1).exists()) {
              break label343;
            }
            ad.i("MicroMsg.JsApiChooseMultiMedia", "file not exist for path:%s! create it!", new Object[] { str1 });
            paramString = f.createVideoThumbnail(paramString, 2);
            if (paramString != null) {
              break;
            }
            ad.e("MicroMsg.JsApiChooseMultiMedia", "createVideoThumbnail bitmap fail for path:%s!", new Object[] { str1 });
            AppMethodBeat.o(46520);
            return "";
            str1 = com.tencent.mm.loader.j.b.ais() + "/" + str1 + System.currentTimeMillis() + ".jpeg";
            continue;
            str1 = "microMsg_" + System.currentTimeMillis();
            str1 = com.tencent.mm.loader.j.b.ais() + str1 + ".jpeg";
          }
        }
      }
      for (;;)
      {
        try
        {
          f.a(paramString, 80, Bitmap.CompressFormat.JPEG, str1, true);
          AppMethodBeat.o(46520);
          return str1;
        }
        catch (IOException paramString)
        {
          ad.e("MicroMsg.JsApiChooseMultiMedia", "saveBitmapToImage exist IOException:" + paramString.getMessage());
          continue;
        }
        label343:
        ad.i("MicroMsg.JsApiChooseMultiMedia", "file is exist for path:%s!", new Object[] { str1 });
      }
    }
    
    private static String a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
    {
      AppMethodBeat.i(46522);
      ad.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson()");
      JSONArray localJSONArray = new JSONArray();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", "video");
        localJSONObject.put("tempFilePath", paramString1);
        localJSONObject.put("size", paramLong);
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
        localJSONObject.put("duration", paramInt3);
        localJSONObject.put("thumbTempFilePath", paramString2);
        localJSONObject.put("mark", paramString3);
        localJSONObject.put("scene", "camera");
        localJSONArray.put(localJSONObject);
        paramString1 = localJSONArray.toString();
        AppMethodBeat.o(46522);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
        AppMethodBeat.o(46522);
      }
      return "";
    }
    
    private static String a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, String paramString3)
    {
      AppMethodBeat.i(46521);
      JSONArray localJSONArray = new JSONArray();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", "image");
        localJSONObject.put("tempFilePath", paramString1);
        localJSONObject.put("size", paramLong);
        localJSONObject.put("width", paramInt1);
        localJSONObject.put("height", paramInt2);
        localJSONObject.put("orientation", paramString2);
        localJSONObject.put("mark", paramString3);
        localJSONObject.put("scene", "camera");
        localJSONArray.put(localJSONObject);
        paramString1 = localJSONArray.toString();
        ad.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson, res: %s.", new Object[] { paramString1 });
        AppMethodBeat.o(46521);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
        AppMethodBeat.o(46521);
      }
      return "";
    }
    
    private AppBrandLocalVideoObject ao(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(46519);
      String str1 = paramString;
      if (paramBoolean) {}
      String str2;
      int i;
      int j;
      int m;
      try
      {
        str1 = Iy(paramString);
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
            ad.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, null meta data");
            AppMethodBeat.o(46519);
            return null;
            localException = localException;
            ad.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bt.m(localException) });
            str2 = paramString;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
            paramString = null;
          }
          i = bt.getInt(paramString.extractMetadata(18), 0);
          j = bt.getInt(paramString.extractMetadata(19), 0);
          m = bt.getInt(paramString.extractMetadata(9), 0);
          if (!"90".equals(paramString.extractMetadata(24))) {
            break label255;
          }
        }
      }
      if (i > j) {}
      for (;;)
      {
        paramString.release();
        paramString = AppBrandLocalMediaObjectManager.fT(this.jXu.appId, str2);
        if (paramString == null)
        {
          ad.e("MicroMsg.JsApiChooseMultiMedia", "attachVideo error, return null");
          AppMethodBeat.o(46519);
          return null;
        }
        paramString.duration = ((m + 500) / 1000);
        paramString.width = j;
        paramString.height = i;
        paramString.size = ((int)i.aMN(str2));
        ad.i("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, return %s", new Object[] { paramString });
        AppMethodBeat.o(46519);
        return paramString;
        label255:
        int k = i;
        i = j;
        j = k;
      }
    }
    
    private void baM()
    {
      AppMethodBeat.i(46516);
      this.jWJ = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(46509);
          ad.e("MicroMsg.JsApiChooseMultiMedia", "cancel show the progress dialog and finish progress");
          JsApiChooseMultiMedia.a.this.jXv.bRZ = 0;
          JsApiChooseMultiMedia.a.h(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.jXv);
          AppMethodBeat.o(46509);
        }
      };
      MMActivity localMMActivity = aXi();
      aj.getResources().getString(2131755906);
      this.ftP = h.b(localMMActivity, aj.getResources().getString(2131755360), true, this.jWJ);
      AppMethodBeat.o(46516);
    }
    
    private Intent baN()
    {
      AppMethodBeat.i(46513);
      Intent localIntent = new Intent();
      localIntent.putExtra("album_business_tag", "album_business_bubble_media_by_coordinate");
      localIntent.putExtra("album_video_max_duration", this.jXu.iBF);
      localIntent.putExtra("album_business_bubble_media_by_coordinate_distance", this.jXu.hqY);
      localIntent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.jXu.latitude);
      localIntent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.jXu.longitude);
      localIntent.putExtra("album_business_bubble_media_by_coordinate_posname", this.jXu.goQ);
      localIntent.putExtra("query_media_type", 3);
      localIntent.putExtra("send_btn_string", aj.getResources().getString(2131755830));
      localIntent.putExtra("gallery_report_tag", 18);
      AppMethodBeat.o(46513);
      return localIntent;
    }
    
    private static BackwardSupportUtil.ExifHelper.LatLongData baO()
    {
      AppMethodBeat.i(46515);
      Object localObject = aj.getContext().getSharedPreferences(aj.eFD() + "_locCache", 0).getString("locStr", null);
      String[] arrayOfString;
      float f1;
      float f2;
      if (localObject != null)
      {
        arrayOfString = ((String)localObject).split(",");
        f1 = bt.getInt(arrayOfString[0], 0) / 1000000.0F;
        f2 = bt.getInt(arrayOfString[1], 0) / 1000000.0F;
        ad.d("MicroMsg.JsApiChooseMultiMedia", "locStr: %s, latitude: %f, longitude: %f", new Object[] { localObject, Float.valueOf(f1), Float.valueOf(f2) });
        localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
      }
      for (;;)
      {
        AppMethodBeat.o(46515);
        return localObject;
        localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(67591, null);
        if (localObject != null) {
          for (;;)
          {
            try
            {
              arrayOfString = ((String)localObject).split(",");
              int i = Integer.valueOf(arrayOfString[0]).intValue();
              if (1 != Integer.valueOf(arrayOfString[1]).intValue()) {
                break label297;
              }
              localObject = "network";
              f1 = Integer.valueOf(arrayOfString[2]).intValue() / 1000000.0F;
              f2 = Integer.valueOf(arrayOfString[3]).intValue() / 1000000.0F;
              ad.d("MicroMsg.JsApiChooseMultiMedia", "cached gps coordinate, precision: %d source: %s latitude: %f longitude: %f", new Object[] { Integer.valueOf(i), localObject, Float.valueOf(f1), Float.valueOf(f2) });
              localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.JsApiChooseMultiMedia", "getCurrentGPSData parse value error.", new Object[] { localException });
              str = null;
            }
            break;
            label297:
            str = "gps";
          }
        }
        ad.i("MicroMsg.JsApiChooseMultiMedia", "lbs location is null, no cached data!");
        ad.e("MicroMsg.JsApiChooseMultiMedia", "location get error!");
        String str = null;
      }
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      int k = 3;
      int j = 0;
      AppMethodBeat.i(46512);
      this.jXu = ((JsApiChooseMultiMedia.ChooseRequest)paramProcessRequest);
      int i;
      boolean bool;
      if (bt.iJ(aXi()) > 200L)
      {
        i = 1;
        if (i == 0) {
          t.makeText(aXi(), aj.getResources().getString(2131755358), 1).show();
        }
        aXi().mmSetOnActivityResultCallback(this);
        if (this.jXu.jXr != 1) {
          break label160;
        }
        bool = true;
        i = k;
      }
      for (;;)
      {
        if ((this.jXu.jWw) && (this.jXu.jWx))
        {
          paramProcessRequest = baN();
          paramProcessRequest.putExtra("query_media_type", i);
          paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
          q.a(aXi(), 1, this.jXu.count, this.jWF, paramProcessRequest);
          AppMethodBeat.o(46512);
          return;
          i = 0;
          break;
          label160:
          if (this.jXu.jXr == 2)
          {
            i = 1;
            bool = false;
            continue;
          }
          if (this.jXu.jXr != 3) {
            break label462;
          }
          i = 2;
          bool = false;
          continue;
        }
        if (this.jXu.jWx)
        {
          paramProcessRequest = baN();
          paramProcessRequest.putExtra("show_header_view", false);
          paramProcessRequest.putExtra("query_media_type", i);
          paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
          q.a(aXi(), 1, this.jXu.count, this.jWF, paramProcessRequest);
          AppMethodBeat.o(46512);
          return;
        }
        if (this.jXu.jWw)
        {
          paramProcessRequest = new Intent();
          paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_latitude", this.jXu.latitude);
          paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_longitude", this.jXu.longitude);
          if ((this.jXu.jXp) && (!this.jXu.jXq)) {
            i = 1;
          }
          for (;;)
          {
            SightParams localSightParams = new SightParams(7, 1);
            localSightParams.mode = i;
            localSightParams.gCB.duration = this.jXu.iBF;
            paramProcessRequest.putExtra("KEY_SIGHT_PARAMS", localSightParams);
            q.a(aXi(), 2, paramProcessRequest, 7, i);
            AppMethodBeat.o(46512);
            return;
            i = j;
            if (this.jXu.jXq)
            {
              i = j;
              if (!this.jXu.jXp) {
                i = 2;
              }
            }
          }
        }
        ad.e("MicroMsg.JsApiChooseMultiMedia", "unknown scene, ignore this request");
        this.jXv.bRZ = -2;
        b(this.jXv);
        AppMethodBeat.o(46512);
        return;
        label462:
        bool = false;
        i = k;
      }
    }
    
    public final void aXp()
    {
      AppMethodBeat.i(46517);
      super.aXp();
      if (this.ftP != null)
      {
        this.ftP.dismiss();
        this.ftP = null;
      }
      AppMethodBeat.o(46517);
    }
    
    public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      final double d2 = 91.0D;
      final boolean bool1 = true;
      AppMethodBeat.i(46514);
      if (paramInt2 == 0)
      {
        this.jXv.bRZ = 0;
        b(this.jXv);
        AppMethodBeat.o(46514);
        return;
      }
      if (paramIntent != null) {}
      for (double d1 = paramIntent.getDoubleExtra("longitude", 181.0D);; d1 = 181.0D)
      {
        if (paramIntent != null) {
          d2 = paramIntent.getDoubleExtra("latitude", 91.0D);
        }
        ad.d("MicroMsg.JsApiChooseMultiMedia", "longitude: %f, latitude: %f.", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        ad.i("MicroMsg.JsApiChooseMultiMedia", "requestCode: %d.", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        default: 
          this.jXv.bRZ = -2;
          b(this.jXv);
          AppMethodBeat.o(46514);
          return;
        }
      }
      ad.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_GALLERY");
      if (paramIntent == null)
      {
        this.jXv.bRZ = 0;
        b(this.jXv);
        AppMethodBeat.o(46514);
        return;
      }
      Object localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      final ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_select_video_list");
      final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      baM();
      if (!bool2) {
        if (!bt.gL((List)localObject))
        {
          paramIntent = ((List)localObject).iterator();
          while (paramIntent.hasNext()) {
            if (Exif.fromFile((String)paramIntent.next()).getOrientationInDegree() != 0)
            {
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label336;
              }
            }
          }
        }
      }
      for (;;)
      {
        l.bqm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46506);
            JSONArray localJSONArray = new JSONArray();
            Object localObject4;
            Object localObject3;
            long l2;
            long l1;
            label125:
            double d;
            Object localObject5;
            boolean bool;
            if ((this.jXw != null) && (this.jXw.size() > 0))
            {
              localObject4 = this.jXw.iterator();
              for (;;)
              {
                if (((Iterator)localObject4).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject4).next();
                  if ((!bt.isNullOrNil((String)localObject3)) && (new com.tencent.mm.vfs.e((String)localObject3).exists()))
                  {
                    ad.i("MicroMsg.JsApiChooseMultiMedia", "local img file exist, success");
                    l2 = 0L;
                    l1 = l2;
                    try
                    {
                      if (!bt.isNullOrNil((String)localObject3)) {
                        break;
                      }
                      l1 = l2;
                      ad.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                      localObject1 = null;
                      l1 = l2;
                      if (localObject1 != null)
                      {
                        l1 = l2;
                        l2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse((String)localObject1).getTime() / 1000L;
                        l1 = l2;
                        ad.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, imgPath: %s.", new Object[] { Long.valueOf(l2), localObject3 });
                        l1 = l2;
                      }
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        Object localObject1;
                        ad.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, imgPath: %s.", new Object[] { localObject3 });
                        continue;
                        ad.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. imgPath: %s.", new Object[] { localObject3 });
                        continue;
                        ad.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. imgPath: %s.", new Object[] { localObject3 });
                      }
                    }
                    d = -1.0D;
                    if ((com.tencent.mm.modelgeo.a.m(d2)) && (com.tencent.mm.modelgeo.a.l(bool2)))
                    {
                      localObject1 = BackwardSupportUtil.ExifHelper.aFd((String)localObject3);
                      if (localObject1 != null)
                      {
                        d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject1).dpb, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject1).hil, d2, bool2);
                        localObject5 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l1, d);
                        if (!localArrayList) {
                          break label564;
                        }
                        localObject1 = JsApiChooseMultiMedia.a.IA((String)localObject3);
                        bool = true;
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              Object localObject6;
              for (;;)
              {
                localObject3 = JsApiChooseMultiMedia.Ix((String)localObject1);
                localObject6 = AppBrandLocalMediaObjectManager.h(JsApiChooseMultiMedia.a.this.jXu.appId, (String)localObject1, bool);
                if (localObject6 == null) {
                  break label594;
                }
                try
                {
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("type", "image");
                  ((JSONObject)localObject1).put("tempFilePath", ((AppBrandLocalMediaObject)localObject6).diQ);
                  ((JSONObject)localObject1).put("size", ((AppBrandLocalMediaObject)localObject6).hWY);
                  ((JSONObject)localObject1).put("width", ((JsApiChooseMultiMedia.b)localObject3).width);
                  ((JSONObject)localObject1).put("height", ((JsApiChooseMultiMedia.b)localObject3).height);
                  ((JSONObject)localObject1).put("orientation", ((JsApiChooseMultiMedia.b)localObject3).jbC);
                  ((JSONObject)localObject1).put("mark", localObject5);
                  ((JSONObject)localObject1).put("scene", "album");
                  localJSONArray.put(localObject1);
                }
                catch (Exception localException1)
                {
                  ad.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", localException1, "", new Object[0]);
                }
              }
              break;
              l1 = l2;
              if (!i.eK((String)localObject3))
              {
                l1 = l2;
                ad.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { localObject3 });
                str1 = null;
                break label125;
              }
              l1 = l2;
              String str1 = Exif.fromFile((String)localObject3).dateTime;
              break label125;
              label564:
              if (this.jWO)
              {
                String str2 = JsApiChooseMultiMedia.a.IB((String)localObject3);
                if (!str2.equals(localObject3))
                {
                  bool = true;
                  continue;
                  label594:
                  ad.e("MicroMsg.JsApiChooseMultiMedia", "handle chosen list from gallery, get null obj from path: %s", new Object[] { str2 });
                  break;
                  if ((this.jXx != null) && (this.jXx.size() > 0))
                  {
                    localObject3 = this.jXx.iterator();
                    while (((Iterator)localObject3).hasNext())
                    {
                      str2 = (String)((Iterator)localObject3).next();
                      if ((!bt.isNullOrNil(str2)) && (new com.tencent.mm.vfs.e(str2).exists()))
                      {
                        ad.i("MicroMsg.JsApiChooseMultiMedia", "local video file exist, success");
                        l2 = 0L;
                        l1 = l2;
                        try
                        {
                          localObject4 = BackwardSupportUtil.aFc(str2);
                          l1 = l2;
                          if (localObject4 != null)
                          {
                            l1 = l2;
                            long l3 = new SimpleDateFormat("yyyyMMdd'T'hhmmss.SSS'Z'").parse((String)localObject4).getTime();
                            l1 = l2;
                            localObject4 = Calendar.getInstance(TimeZone.getDefault());
                            l1 = l2;
                            int i = ((Calendar)localObject4).get(15);
                            l1 = l2;
                            int j = ((Calendar)localObject4).get(16);
                            l1 = l2;
                            localObject4 = Calendar.getInstance();
                            l1 = l2;
                            ((Calendar)localObject4).setTimeInMillis(l3);
                            l1 = l2;
                            ((Calendar)localObject4).add(14, i + j);
                            l1 = l2;
                            l2 = ((Calendar)localObject4).getTimeInMillis() / 1000L;
                            l1 = l2;
                            ad.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, videoPath: %s.", new Object[] { Long.valueOf(l2), str2 });
                            l1 = l2;
                          }
                          d = -1.0D;
                          if ((com.tencent.mm.modelgeo.a.m(d2)) && (com.tencent.mm.modelgeo.a.l(bool2)))
                          {
                            localObject4 = BackwardSupportUtil.aFb(str2);
                            if (localObject4 != null)
                            {
                              d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject4).dpb, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject4).hil, d2, bool2);
                              localObject4 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l1, d);
                              localObject5 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, str2, true);
                              if (localObject5 != null) {
                                break label1064;
                              }
                              ad.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail, mVideoFilePath is %s", new Object[] { str2 });
                              JsApiChooseMultiMedia.a.this.jXv.bRZ = -2;
                              JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.jXv);
                              AppMethodBeat.o(46506);
                              return;
                            }
                          }
                        }
                        catch (Exception localException4)
                        {
                          for (;;)
                          {
                            ad.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, videoPath: %s.", new Object[] { str2 });
                            continue;
                            ad.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. videoPath: %s.", new Object[] { str2 });
                            continue;
                            ad.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. videoPath: %s.", new Object[] { str2 });
                          }
                          localObject6 = JsApiChooseMultiMedia.a.IC(str2);
                          str2 = "";
                          if (!bt.isNullOrNil((String)localObject6)) {
                            str2 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, (String)localObject6);
                          }
                          try
                          {
                            localObject6 = new JSONObject();
                            ((JSONObject)localObject6).put("type", "video");
                            ((JSONObject)localObject6).put("tempFilePath", ((AppBrandLocalVideoObject)localObject5).diQ);
                            ((JSONObject)localObject6).put("size", ((AppBrandLocalVideoObject)localObject5).size);
                            ((JSONObject)localObject6).put("width", ((AppBrandLocalVideoObject)localObject5).width);
                            ((JSONObject)localObject6).put("height", ((AppBrandLocalVideoObject)localObject5).height);
                            ((JSONObject)localObject6).put("duration", ((AppBrandLocalVideoObject)localObject5).duration);
                            ((JSONObject)localObject6).put("thumbTempFilePath", str2);
                            ((JSONObject)localObject6).put("mark", localException4);
                            ((JSONObject)localObject6).put("scene", "album");
                            localJSONArray.put(localObject6);
                          }
                          catch (Exception localException3)
                          {
                            ad.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", localException3, "", new Object[0]);
                          }
                        }
                      }
                    }
                  }
                  JsApiChooseMultiMedia.a.this.jXv.bRZ = -1;
                  JsApiChooseMultiMedia.a.this.jXv.jXt = localJSONArray.toString();
                  JsApiChooseMultiMedia.a.b(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.jXv);
                  AppMethodBeat.o(46506);
                  return;
                }
              }
              label1064:
              bool = false;
              Object localObject2 = localObject3;
            }
          }
        });
        AppMethodBeat.o(46514);
        return;
        paramInt1 = 0;
        break;
        label336:
        bool1 = false;
      }
      ad.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
      if (paramIntent == null)
      {
        this.jXv.bRZ = 0;
        b(this.jXv);
        AppMethodBeat.o(46514);
        return;
      }
      ad.i("MicroMsg.JsApiChooseMultiMedia", "data is valid!");
      localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (localObject == null)
      {
        ad.e("MicroMsg.JsApiChooseMultiMedia", "sight capture result is null!");
        this.jXv.bRZ = -2;
        b(this.jXv);
        AppMethodBeat.o(46514);
        return;
      }
      if (((SightCaptureResult)localObject).tAP)
      {
        localObject = ((SightCaptureResult)localObject).tAX;
        if ((bt.isNullOrNil((String)localObject)) || (!i.eK((String)localObject)))
        {
          ad.e("MicroMsg.JsApiChooseMultiMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
          this.jXv.bRZ = -2;
          b(this.jXv);
          AppMethodBeat.o(46514);
          return;
        }
        ad.i("MicroMsg.JsApiChooseMultiMedia", "filePath:%s", new Object[] { localObject });
        bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        baM();
        l.bqm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46507);
            Object localObject1;
            JsApiChooseMultiMedia.b localb;
            long l;
            double d;
            Object localObject2;
            if (bool1)
            {
              localObject1 = JsApiChooseMultiMedia.a.IA(this.val$filePath);
              localb = JsApiChooseMultiMedia.Ix((String)localObject1);
              localObject1 = AppBrandLocalMediaObjectManager.h(JsApiChooseMultiMedia.a.this.jXu.appId, (String)localObject1, bool1 | true);
              if (localObject1 == null) {
                break label265;
              }
              l = Calendar.getInstance().getTimeInMillis() / 1000L;
              d = -1.0D;
              if ((!com.tencent.mm.modelgeo.a.m(d2)) || (!com.tencent.mm.modelgeo.a.l(this.heH))) {
                break label244;
              }
              localObject2 = JsApiChooseMultiMedia.a.baP();
              if (localObject2 == null) {
                break label223;
              }
              d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).dpb, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).hil, d2, this.heH);
            }
            for (;;)
            {
              localObject2 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l, d);
              ad.i("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight is done.");
              JsApiChooseMultiMedia.a.this.jXv.bRZ = -1;
              JsApiChooseMultiMedia.a.this.jXv.jXt = JsApiChooseMultiMedia.a.b(((AppBrandLocalMediaObject)localObject1).diQ, ((AppBrandLocalMediaObject)localObject1).hWY, localb.width, localb.height, localb.jbC, (String)localObject2);
              JsApiChooseMultiMedia.a.c(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.jXv);
              AppMethodBeat.o(46507);
              return;
              localObject1 = this.val$filePath;
              break;
              label223:
              ad.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. pic_Path: %s.", new Object[] { this.val$filePath });
              continue;
              label244:
              ad.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. pic_Path: %s.", new Object[] { this.val$filePath });
            }
            label265:
            ad.e("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
            JsApiChooseMultiMedia.a.this.jXv.bRZ = -2;
            JsApiChooseMultiMedia.a.d(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.jXv);
            AppMethodBeat.o(46507);
          }
        });
        AppMethodBeat.o(46514);
        return;
      }
      paramIntent = ((SightCaptureResult)localObject).tAR;
      if (bt.isNullOrNil(paramIntent))
      {
        ad.e("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath is null");
        this.jXv.bRZ = -2;
        b(this.jXv);
        AppMethodBeat.o(46514);
        return;
      }
      ad.i("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath:%s", new Object[] { paramIntent });
      baM();
      l.bqm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46508);
          AppBrandLocalVideoObject localAppBrandLocalVideoObject;
          if (new com.tencent.mm.vfs.e(paramIntent).exists())
          {
            ad.i("MicroMsg.JsApiChooseMultiMedia", "take media camera, the mVideoFilePath file exist, success");
            JsApiChooseMultiMedia.a.this.jXv.bRZ = -1;
            localAppBrandLocalVideoObject = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, paramIntent, false);
            if (localAppBrandLocalVideoObject == null)
            {
              ad.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { paramIntent });
              JsApiChooseMultiMedia.a.this.jXv.bRZ = -2;
              JsApiChooseMultiMedia.a.e(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.jXv);
              AppMethodBeat.o(46508);
              return;
            }
            str = JsApiChooseMultiMedia.a.IC(paramIntent);
            if (bt.isNullOrNil(str)) {
              break label372;
            }
          }
          label372:
          for (String str = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, str);; str = "")
          {
            long l = Calendar.getInstance().getTimeInMillis() / 1000L;
            double d = -1.0D;
            Object localObject;
            if ((com.tencent.mm.modelgeo.a.m(d2)) && (com.tencent.mm.modelgeo.a.l(this.heH)))
            {
              localObject = JsApiChooseMultiMedia.a.baP();
              if (localObject != null) {
                d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dpb, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).hil, d2, this.heH);
              }
            }
            for (;;)
            {
              localObject = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l, d);
              JsApiChooseMultiMedia.a.this.jXv.jXt = JsApiChooseMultiMedia.a.b(localAppBrandLocalVideoObject.diQ, localAppBrandLocalVideoObject.size, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.duration, str, (String)localObject);
              JsApiChooseMultiMedia.a.f(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.jXv);
              AppMethodBeat.o(46508);
              return;
              ad.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. video_Path: %s.", new Object[] { paramIntent });
              continue;
              ad.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. video_Path: %s.", new Object[] { paramIntent });
            }
            ad.e("MicroMsg.JsApiChooseMultiMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { paramIntent });
            JsApiChooseMultiMedia.a.this.jXv.bRZ = -2;
            JsApiChooseMultiMedia.a.g(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.jXv);
            AppMethodBeat.o(46508);
            return;
          }
        }
      });
      AppMethodBeat.o(46514);
    }
  }
  
  static final class b
  {
    public int height;
    public String jbC;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia
 * JD-Core Version:    0.7.0.1
 */