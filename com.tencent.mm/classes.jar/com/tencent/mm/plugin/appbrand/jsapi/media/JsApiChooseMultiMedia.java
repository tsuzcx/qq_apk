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
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46542);
    if (n.Hr(paramc.getAppId()).jfV)
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
      ac.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(46542);
      return;
    }
    int i = paramJSONObject.optInt("maxDuration", 10);
    ac.i("MicroMsg.JsApiChooseMultiMedia", "videoMaxDuration: %d.", new Object[] { Integer.valueOf(i) });
    if ((i <= 0) || (i > 1800))
    {
      ac.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, invalid maxDuration parameter");
      paramc.h(paramInt, e("fail:invalid maxDuration parameter", null));
      AppMethodBeat.o(46542);
      return;
    }
    localContext.getSharedPreferences(ai.eUX() + "_locCache", 0).edit().putString("locStr", null).apply();
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
          localContext.getSharedPreferences(ai.eUX() + "_locCache", 0).edit().putString("locStr", paramAnonymousString.toString()).apply();
          ac.d("MicroMsg.JsApiChooseMultiMedia", "onLocationChange latitude %f, longitude: %f, locStr: %s.", new Object[] { Double.valueOf(paramAnonymousa.latitude), Double.valueOf(paramAnonymousa.longitude), paramAnonymousString });
          ((com.tencent.mm.plugin.appbrand.utils.b.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("wgs84", this, null);
          AppMethodBeat.o(46493);
          return;
        }
        ac.e("MicroMsg.JsApiChooseMultiMedia", "onLocationChange error, errCode: %d.", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
          o.b(paramc.getAppId(), new android.support.v4.app.a.a()
          {
            public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
            {
              AppMethodBeat.i(46496);
              if (paramAnonymousInt != 113)
              {
                AppMethodBeat.o(46496);
                return;
              }
              if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
              {
                JsApiChooseMultiMedia.this.a(paramc, paramJSONObject, paramInt);
                AppMethodBeat.o(46496);
                return;
              }
              paramc.h(paramInt, JsApiChooseMultiMedia.this.e("fail:system permission denied", null));
              AppMethodBeat.o(46496);
            }
          });
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
            o.Qo(paramc.getAppId());
            m = bool6;
          }
        }
        label623:
        n.Hs(paramc.getAppId()).jfV = true;
        com.tencent.mm.plugin.appbrand.g.a(paramc.getAppId(), new g.c()
        {
          public final void onResume()
          {
            AppMethodBeat.i(46494);
            n.Hs(paramc.getAppId()).jfV = false;
            com.tencent.mm.plugin.appbrand.g.b(paramc.getAppId(), this);
            AppMethodBeat.o(46494);
          }
        });
        paramJSONObject = new ChooseRequest();
        paramJSONObject.appId = paramc.getAppId();
        paramJSONObject.count = j;
        localObject2 = com.tencent.mm.modelgeo.a.a.c(d2, d1);
        paramJSONObject.longitude = localObject2[0];
        paramJSONObject.latitude = localObject2[1];
        paramJSONObject.gPy = ((String)localObject1);
        paramJSONObject.hRA = d3;
        paramJSONObject.kxi = bool2;
        paramJSONObject.kxj = bool3;
        paramJSONObject.jbG = i;
        paramJSONObject.kyb = bool4;
        paramJSONObject.kyc = bool5;
        paramJSONObject.kyd = k;
        paramJSONObject.kye = bool1;
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
    String gPy;
    double hRA;
    int jbG;
    boolean kxi;
    boolean kxj;
    boolean kyb;
    boolean kyc;
    int kyd;
    boolean kye;
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
    
    public final Class<? extends AppBrandProxyUIProcessTask> bdj()
    {
      return JsApiChooseMultiMedia.a.class;
    }
    
    public final boolean ben()
    {
      return true;
    }
    
    public final String beo()
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
      this.gPy = paramParcel.readString();
      this.hRA = paramParcel.readDouble();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.kxi = bool1;
        if (paramParcel.readByte() == 0) {
          break label152;
        }
        bool1 = true;
        label78:
        this.kxj = bool1;
        this.jbG = paramParcel.readInt();
        if (paramParcel.readByte() == 0) {
          break label157;
        }
        bool1 = true;
        label100:
        this.kyb = bool1;
        if (paramParcel.readByte() == 0) {
          break label162;
        }
        bool1 = true;
        label114:
        this.kyc = bool1;
        this.kyd = paramParcel.readInt();
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
        this.kye = bool1;
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
      paramParcel.writeString(this.gPy);
      paramParcel.writeDouble(this.hRA);
      if (this.kxi)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.kxj) {
          break label154;
        }
        b1 = 1;
        label79:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.jbG);
        if (!this.kyb) {
          break label159;
        }
        b1 = 1;
        label101:
        paramParcel.writeByte(b1);
        if (!this.kyc) {
          break label164;
        }
        b1 = 1;
        label115:
        paramParcel.writeByte(b1);
        paramParcel.writeInt(this.kyd);
        if (!this.kye) {
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
    int bPH;
    String kyf;
    
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
      this.bPH = paramParcel.readInt();
      this.kyf = paramParcel.readString();
      AppMethodBeat.o(46503);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46504);
      paramParcel.writeInt(this.bPH);
      paramParcel.writeString(this.kyf);
      AppMethodBeat.o(46504);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private p fxw;
    int kxr;
    private DialogInterface.OnCancelListener kxv;
    JsApiChooseMultiMedia.ChooseRequest kyg;
    JsApiChooseMultiMedia.ChooseResult kyh;
    
    private a()
    {
      AppMethodBeat.i(46511);
      this.kyh = new JsApiChooseMultiMedia.ChooseResult();
      this.kxr = 7;
      AppMethodBeat.o(46511);
    }
    
    private static String MA(String paramString)
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
            ac.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, get null bmp");
            AppMethodBeat.o(46524);
            return paramString;
          }
          float f = i % 360;
          Bitmap localBitmap = f.a((Bitmap)localObject1, f);
          Object localObject2 = new StringBuilder().append(com.tencent.mm.loader.j.b.aps()).append("microMsg.tmp.").append(System.currentTimeMillis());
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
                com.tencent.mm.plugin.appbrand.m.b.cR(paramString, (String)localObject2);
              }
              AppMethodBeat.o(46524);
              return localObject2;
            }
            catch (Exception localException)
            {
              label165:
              ac.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, exception occurred when saving | %s", new Object[] { localException });
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
    
    /* Error */
    private static String Mx(String paramString)
    {
      // Byte code:
      //   0: ldc 177
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: iconst_2
      //   6: newarray int
      //   8: astore 13
      //   10: new 179	com/tencent/mm/compatible/h/d
      //   13: dup
      //   14: invokespecial 180	com/tencent/mm/compatible/h/d:<init>	()V
      //   17: astore 12
      //   19: aload 12
      //   21: aload_0
      //   22: invokevirtual 186	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
      //   25: aload 12
      //   27: bipush 18
      //   29: invokevirtual 190	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
      //   32: iconst_0
      //   33: invokestatic 196	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
      //   36: istore 6
      //   38: aload 12
      //   40: bipush 19
      //   42: invokevirtual 190	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
      //   45: iconst_0
      //   46: invokestatic 196	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
      //   49: istore 7
      //   51: aload 13
      //   53: iconst_0
      //   54: iload 6
      //   56: iastore
      //   57: aload 13
      //   59: iconst_1
      //   60: iload 7
      //   62: iastore
      //   63: invokestatic 202	com/tencent/mm/modelcontrol/d:aDL	()Lcom/tencent/mm/modelcontrol/d;
      //   66: invokevirtual 206	com/tencent/mm/modelcontrol/d:aDS	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
      //   69: astore 14
      //   71: aload 14
      //   73: getfield 211	com/tencent/mm/modelcontrol/VideoTransPara:width	I
      //   76: istore_3
      //   77: aload 14
      //   79: getfield 214	com/tencent/mm/modelcontrol/VideoTransPara:height	I
      //   82: istore 4
      //   84: ldc 79
      //   86: new 94	java/lang/StringBuilder
      //   89: dup
      //   90: ldc 216
      //   92: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   95: iload 6
      //   97: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   100: ldc 223
      //   102: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: iload 7
      //   107: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   110: ldc 225
      //   112: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   115: iload_3
      //   116: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   119: ldc 227
      //   121: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   124: iload 4
      //   126: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   129: ldc 229
      //   131: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   134: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   137: invokestatic 231	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   140: iload 6
      //   142: iload_3
      //   143: if_icmpgt +274 -> 417
      //   146: iload 7
      //   148: iload 4
      //   150: if_icmpgt +267 -> 417
      //   153: ldc 79
      //   155: ldc 233
      //   157: invokestatic 235	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   160: aconst_null
      //   161: astore 11
      //   163: aload 11
      //   165: ifnull +21 -> 186
      //   168: aload 13
      //   170: iconst_0
      //   171: aload 11
      //   173: getfield 240	android/graphics/Point:x	I
      //   176: iastore
      //   177: aload 13
      //   179: iconst_1
      //   180: aload 11
      //   182: getfield 243	android/graphics/Point:y	I
      //   185: iastore
      //   186: ldc 79
      //   188: ldc 245
      //   190: bipush 6
      //   192: anewarray 150	java/lang/Object
      //   195: dup
      //   196: iconst_0
      //   197: iload 6
      //   199: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   202: aastore
      //   203: dup
      //   204: iconst_1
      //   205: iload 7
      //   207: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   210: aastore
      //   211: dup
      //   212: iconst_2
      //   213: aload 14
      //   215: getfield 211	com/tencent/mm/modelcontrol/VideoTransPara:width	I
      //   218: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   221: aastore
      //   222: dup
      //   223: iconst_3
      //   224: aload 14
      //   226: getfield 214	com/tencent/mm/modelcontrol/VideoTransPara:height	I
      //   229: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   232: aastore
      //   233: dup
      //   234: iconst_4
      //   235: aload 13
      //   237: iconst_0
      //   238: iaload
      //   239: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   242: aastore
      //   243: dup
      //   244: iconst_5
      //   245: aload 13
      //   247: iconst_1
      //   248: iaload
      //   249: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   252: aastore
      //   253: invokestatic 253	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   256: aload 12
      //   258: invokevirtual 256	android/media/MediaMetadataRetriever:release	()V
      //   261: aload 13
      //   263: iconst_0
      //   264: iaload
      //   265: istore_3
      //   266: aload 13
      //   268: iconst_1
      //   269: iaload
      //   270: istore 4
      //   272: new 94	java/lang/StringBuilder
      //   275: dup
      //   276: invokespecial 95	java/lang/StringBuilder:<init>	()V
      //   279: invokestatic 101	com/tencent/mm/loader/j/b:aps	()Ljava/lang/String;
      //   282: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   285: ldc_w 258
      //   288: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   291: invokestatic 113	java/lang/System:currentTimeMillis	()J
      //   294: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   297: ldc_w 260
      //   300: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   303: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   306: astore 11
      //   308: invokestatic 202	com/tencent/mm/modelcontrol/d:aDL	()Lcom/tencent/mm/modelcontrol/d;
      //   311: invokevirtual 206	com/tencent/mm/modelcontrol/d:aDS	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
      //   314: astore 12
      //   316: ldc 79
      //   318: ldc_w 262
      //   321: iconst_1
      //   322: anewarray 150	java/lang/Object
      //   325: dup
      //   326: iconst_0
      //   327: aload 12
      //   329: getfield 265	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
      //   332: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   335: aastore
      //   336: invokestatic 253	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   339: new 267	java/util/concurrent/CountDownLatch
      //   342: dup
      //   343: iconst_1
      //   344: invokespecial 269	java/util/concurrent/CountDownLatch:<init>	(I)V
      //   347: astore 13
      //   349: getstatic 275	com/tencent/mm/media/h/d:gTv	Lcom/tencent/mm/media/h/d$a;
      //   352: aload_0
      //   353: aload 11
      //   355: iload_3
      //   356: iload 4
      //   358: aload 12
      //   360: getfield 265	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
      //   363: aload 12
      //   365: getfield 278	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
      //   368: aload 12
      //   370: getfield 281	com/tencent/mm/modelcontrol/VideoTransPara:gOb	I
      //   373: aload 12
      //   375: getfield 284	com/tencent/mm/modelcontrol/VideoTransPara:gOc	I
      //   378: new 17	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5
      //   381: dup
      //   382: aload 13
      //   384: invokespecial 287	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5:<init>	(Ljava/util/concurrent/CountDownLatch;)V
      //   387: invokeinterface 292 10 0
      //   392: invokevirtual 295	com/tencent/mm/media/h/d:arc	()I
      //   395: pop
      //   396: ldc 79
      //   398: ldc_w 297
      //   401: invokestatic 231	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   404: aload 13
      //   406: invokevirtual 300	java/util/concurrent/CountDownLatch:await	()V
      //   409: ldc 177
      //   411: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   414: aload 11
      //   416: areturn
      //   417: iload 6
      //   419: iload 7
      //   421: invokestatic 306	java/lang/Math:max	(II)I
      //   424: istore 10
      //   426: iload 6
      //   428: iload 7
      //   430: invokestatic 309	java/lang/Math:min	(II)I
      //   433: istore 9
      //   435: iload_3
      //   436: iload 4
      //   438: invokestatic 306	java/lang/Math:max	(II)I
      //   441: istore 5
      //   443: iload_3
      //   444: iload 4
      //   446: invokestatic 309	java/lang/Math:min	(II)I
      //   449: istore 8
      //   451: iload 10
      //   453: bipush 16
      //   455: irem
      //   456: ifne +51 -> 507
      //   459: iload 10
      //   461: iload 5
      //   463: isub
      //   464: invokestatic 313	java/lang/Math:abs	(I)I
      //   467: bipush 16
      //   469: if_icmpge +38 -> 507
      //   472: iload 9
      //   474: bipush 16
      //   476: irem
      //   477: ifne +30 -> 507
      //   480: iload 9
      //   482: iload 8
      //   484: isub
      //   485: invokestatic 313	java/lang/Math:abs	(I)I
      //   488: bipush 16
      //   490: if_icmpge +17 -> 507
      //   493: ldc 79
      //   495: ldc_w 315
      //   498: invokestatic 235	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   501: aconst_null
      //   502: astore 11
      //   504: goto -341 -> 163
      //   507: iload 10
      //   509: iconst_2
      //   510: idiv
      //   511: istore 10
      //   513: iload 9
      //   515: iconst_2
      //   516: idiv
      //   517: istore 9
      //   519: iload 10
      //   521: bipush 16
      //   523: irem
      //   524: ifne +106 -> 630
      //   527: iload 10
      //   529: iload 5
      //   531: isub
      //   532: invokestatic 313	java/lang/Math:abs	(I)I
      //   535: bipush 16
      //   537: if_icmpge +93 -> 630
      //   540: iload 9
      //   542: bipush 16
      //   544: irem
      //   545: ifne +85 -> 630
      //   548: iload 9
      //   550: iload 8
      //   552: isub
      //   553: invokestatic 313	java/lang/Math:abs	(I)I
      //   556: bipush 16
      //   558: if_icmpge +72 -> 630
      //   561: ldc 79
      //   563: ldc_w 317
      //   566: invokestatic 235	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   569: iload 6
      //   571: iconst_2
      //   572: idiv
      //   573: istore_3
      //   574: iload 7
      //   576: iconst_2
      //   577: idiv
      //   578: istore 4
      //   580: iload_3
      //   581: iconst_2
      //   582: irem
      //   583: ifeq +196 -> 779
      //   586: iload_3
      //   587: iconst_1
      //   588: iadd
      //   589: istore_3
      //   590: goto +189 -> 779
      //   593: new 237	android/graphics/Point
      //   596: dup
      //   597: iload_3
      //   598: iload 4
      //   600: invokespecial 320	android/graphics/Point:<init>	(II)V
      //   603: astore 11
      //   605: goto -442 -> 163
      //   608: astore_0
      //   609: aload 12
      //   611: astore 11
      //   613: aload 11
      //   615: ifnull +8 -> 623
      //   618: aload 11
      //   620: invokevirtual 256	android/media/MediaMetadataRetriever:release	()V
      //   623: ldc 177
      //   625: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   628: aload_0
      //   629: athrow
      //   630: new 237	android/graphics/Point
      //   633: dup
      //   634: invokespecial 321	android/graphics/Point:<init>	()V
      //   637: astore 11
      //   639: iload 6
      //   641: iload 7
      //   643: if_icmpge +75 -> 718
      //   646: iload_3
      //   647: iload 4
      //   649: invokestatic 309	java/lang/Math:min	(II)I
      //   652: istore_3
      //   653: dconst_1
      //   654: iload 6
      //   656: i2d
      //   657: dmul
      //   658: iload_3
      //   659: i2d
      //   660: ddiv
      //   661: dstore_1
      //   662: iload 7
      //   664: i2d
      //   665: dload_1
      //   666: ddiv
      //   667: d2i
      //   668: istore 4
      //   670: goto +125 -> 795
      //   673: ldc 79
      //   675: ldc_w 323
      //   678: iconst_2
      //   679: anewarray 150	java/lang/Object
      //   682: dup
      //   683: iconst_0
      //   684: iload 4
      //   686: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   689: aastore
      //   690: dup
      //   691: iconst_1
      //   692: iload 5
      //   694: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   697: aastore
      //   698: invokestatic 325	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   701: aload 11
      //   703: iload 4
      //   705: putfield 240	android/graphics/Point:x	I
      //   708: aload 11
      //   710: iload 5
      //   712: putfield 243	android/graphics/Point:y	I
      //   715: goto -552 -> 163
      //   718: iload_3
      //   719: iload 4
      //   721: invokestatic 309	java/lang/Math:min	(II)I
      //   724: istore 4
      //   726: dconst_1
      //   727: iload 7
      //   729: i2d
      //   730: dmul
      //   731: iload 4
      //   733: i2d
      //   734: ddiv
      //   735: dstore_1
      //   736: iload 6
      //   738: i2d
      //   739: dload_1
      //   740: ddiv
      //   741: d2i
      //   742: istore_3
      //   743: goto +52 -> 795
      //   746: astore_0
      //   747: ldc 79
      //   749: ldc_w 327
      //   752: iconst_1
      //   753: anewarray 150	java/lang/Object
      //   756: dup
      //   757: iconst_0
      //   758: aload_0
      //   759: invokevirtual 330	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   762: aastore
      //   763: invokestatic 153	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   766: goto -357 -> 409
      //   769: astore_0
      //   770: aconst_null
      //   771: astore 11
      //   773: goto -160 -> 613
      //   776: goto -183 -> 593
      //   779: iload 4
      //   781: iconst_2
      //   782: irem
      //   783: ifeq -7 -> 776
      //   786: iload 4
      //   788: iconst_1
      //   789: iadd
      //   790: istore 4
      //   792: goto -199 -> 593
      //   795: iload 4
      //   797: istore 5
      //   799: iload 4
      //   801: iconst_2
      //   802: irem
      //   803: ifeq +9 -> 812
      //   806: iload 4
      //   808: iconst_1
      //   809: iadd
      //   810: istore 5
      //   812: iload_3
      //   813: istore 4
      //   815: iload_3
      //   816: iconst_2
      //   817: irem
      //   818: ifeq -145 -> 673
      //   821: iload_3
      //   822: iconst_1
      //   823: iadd
      //   824: istore 4
      //   826: goto -153 -> 673
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	829	0	paramString	String
      //   661	79	1	d	double
      //   76	748	3	i	int
      //   82	743	4	j	int
      //   441	370	5	k	int
      //   36	701	6	m	int
      //   49	679	7	n	int
      //   449	104	8	i1	int
      //   433	120	9	i2	int
      //   424	108	10	i3	int
      //   161	611	11	localObject1	Object
      //   17	593	12	localObject2	Object
      //   8	397	13	localObject3	Object
      //   69	156	14	localVideoTransPara	com.tencent.mm.modelcontrol.VideoTransPara
      // Exception table:
      //   from	to	target	type
      //   19	51	608	finally
      //   63	140	608	finally
      //   153	160	608	finally
      //   168	186	608	finally
      //   186	256	608	finally
      //   417	451	608	finally
      //   459	472	608	finally
      //   480	501	608	finally
      //   507	519	608	finally
      //   527	540	608	finally
      //   548	580	608	finally
      //   593	605	608	finally
      //   630	639	608	finally
      //   646	670	608	finally
      //   673	715	608	finally
      //   718	726	608	finally
      //   396	409	746	java/lang/InterruptedException
      //   10	19	769	finally
    }
    
    private static String My(String paramString)
    {
      AppMethodBeat.i(46520);
      String str2 = "";
      String str1 = str2;
      if (!bs.isNullOrNil(paramString))
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
            if ((com.tencent.mm.loader.j.b.aps() != null) && (com.tencent.mm.loader.j.b.aps().endsWith("/"))) {
              str1 = com.tencent.mm.loader.j.b.aps() + str1 + System.currentTimeMillis() + ".jpeg";
            }
          }
          for (;;)
          {
            if (new com.tencent.mm.vfs.e(str1).exists()) {
              break label343;
            }
            ac.i("MicroMsg.JsApiChooseMultiMedia", "file not exist for path:%s! create it!", new Object[] { str1 });
            paramString = f.createVideoThumbnail(paramString, 2);
            if (paramString != null) {
              break;
            }
            ac.e("MicroMsg.JsApiChooseMultiMedia", "createVideoThumbnail bitmap fail for path:%s!", new Object[] { str1 });
            AppMethodBeat.o(46520);
            return "";
            str1 = com.tencent.mm.loader.j.b.aps() + "/" + str1 + System.currentTimeMillis() + ".jpeg";
            continue;
            str1 = "microMsg_" + System.currentTimeMillis();
            str1 = com.tencent.mm.loader.j.b.aps() + str1 + ".jpeg";
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
          ac.e("MicroMsg.JsApiChooseMultiMedia", "saveBitmapToImage exist IOException:" + paramString.getMessage());
          continue;
        }
        label343:
        ac.i("MicroMsg.JsApiChooseMultiMedia", "file is exist for path:%s!", new Object[] { str1 });
      }
    }
    
    private static String Mz(String paramString)
    {
      AppMethodBeat.i(46523);
      String str = i.k(com.tencent.mm.loader.j.b.aps() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
      try
      {
        Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
        if (localBitmap1 == null)
        {
          ac.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp return null");
          AppMethodBeat.o(46523);
          return null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          ac.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom");
          try
          {
            Bitmap localBitmap2 = f.decodeFile(paramString, null);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            ac.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, oom again");
            Object localObject1 = null;
          }
          catch (Exception localException1)
          {
            ac.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
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
            ac.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
            Object localObject3 = null;
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          ac.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
          Object localObject4 = null;
        }
        long l = bs.eWj();
        boolean bool = com.tencent.mm.plugin.appbrand.utils.c.ej(str, paramString);
        ac.i("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bs.eWj() - l), paramString, Long.valueOf(i.aSp(paramString)), str, Long.valueOf(i.aSp(str)) });
        if (bool)
        {
          AppMethodBeat.o(46523);
          return str;
        }
        AppMethodBeat.o(46523);
      }
      return paramString;
    }
    
    private static String a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
    {
      AppMethodBeat.i(46522);
      ac.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson()");
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
        ac.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
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
        ac.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson, res: %s.", new Object[] { paramString1 });
        AppMethodBeat.o(46521);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
        AppMethodBeat.o(46521);
      }
      return "";
    }
    
    private AppBrandLocalVideoObject ap(String paramString, boolean paramBoolean)
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
        str1 = Mx(paramString);
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
            ac.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, null meta data");
            AppMethodBeat.o(46519);
            return null;
            localException = localException;
            ac.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bs.m(localException) });
            str2 = paramString;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ac.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
            paramString = null;
          }
          i = bs.getInt(paramString.extractMetadata(18), 0);
          j = bs.getInt(paramString.extractMetadata(19), 0);
          m = bs.getInt(paramString.extractMetadata(9), 0);
          if (!"90".equals(paramString.extractMetadata(24))) {
            break label255;
          }
        }
      }
      if (i > j) {}
      for (;;)
      {
        paramString.release();
        paramString = AppBrandLocalMediaObjectManager.cj(this.kyg.appId, str2);
        if (paramString == null)
        {
          ac.e("MicroMsg.JsApiChooseMultiMedia", "attachVideo error, return null");
          AppMethodBeat.o(46519);
          return null;
        }
        paramString.duration = ((m + 500) / 1000);
        paramString.width = j;
        paramString.height = i;
        paramString.size = ((int)i.aSp(str2));
        ac.i("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, return %s", new Object[] { paramString });
        AppMethodBeat.o(46519);
        return paramString;
        label255:
        int k = i;
        i = j;
        j = k;
      }
    }
    
    private Intent bhF()
    {
      AppMethodBeat.i(46513);
      Intent localIntent = new Intent();
      localIntent.putExtra("album_business_tag", "album_business_bubble_media_by_coordinate");
      localIntent.putExtra("album_video_max_duration", this.kyg.jbG);
      localIntent.putExtra("album_business_bubble_media_by_coordinate_distance", this.kyg.hRA);
      localIntent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.kyg.latitude);
      localIntent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.kyg.longitude);
      localIntent.putExtra("album_business_bubble_media_by_coordinate_posname", this.kyg.gPy);
      localIntent.putExtra("query_media_type", 3);
      localIntent.putExtra("send_btn_string", ai.getResources().getString(2131755830));
      localIntent.putExtra("gallery_report_tag", 18);
      AppMethodBeat.o(46513);
      return localIntent;
    }
    
    private static BackwardSupportUtil.ExifHelper.LatLongData bhG()
    {
      AppMethodBeat.i(46515);
      Object localObject = ai.getContext().getSharedPreferences(ai.eUX() + "_locCache", 0).getString("locStr", null);
      String[] arrayOfString;
      float f1;
      float f2;
      if (localObject != null)
      {
        arrayOfString = ((String)localObject).split(",");
        f1 = bs.getInt(arrayOfString[0], 0) / 1000000.0F;
        f2 = bs.getInt(arrayOfString[1], 0) / 1000000.0F;
        ac.d("MicroMsg.JsApiChooseMultiMedia", "locStr: %s, latitude: %f, longitude: %f", new Object[] { localObject, Float.valueOf(f1), Float.valueOf(f2) });
        localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
      }
      for (;;)
      {
        AppMethodBeat.o(46515);
        return localObject;
        localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(67591, null);
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
              ac.d("MicroMsg.JsApiChooseMultiMedia", "cached gps coordinate, precision: %d source: %s latitude: %f longitude: %f", new Object[] { Integer.valueOf(i), localObject, Float.valueOf(f1), Float.valueOf(f2) });
              localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.JsApiChooseMultiMedia", "getCurrentGPSData parse value error.", new Object[] { localException });
              str = null;
            }
            break;
            label297:
            str = "gps";
          }
        }
        ac.i("MicroMsg.JsApiChooseMultiMedia", "lbs location is null, no cached data!");
        ac.e("MicroMsg.JsApiChooseMultiMedia", "location get error!");
        String str = null;
      }
    }
    
    private void bhH()
    {
      AppMethodBeat.i(46516);
      this.kxv = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(46509);
          ac.e("MicroMsg.JsApiChooseMultiMedia", "cancel show the progress dialog and finish progress");
          JsApiChooseMultiMedia.a.this.kyh.bPH = 0;
          JsApiChooseMultiMedia.a.h(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kyh);
          AppMethodBeat.o(46509);
        }
      };
      MMActivity localMMActivity = bef();
      ai.getResources().getString(2131755906);
      this.fxw = h.b(localMMActivity, ai.getResources().getString(2131755360), true, this.kxv);
      AppMethodBeat.o(46516);
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      int k = 3;
      int j = 0;
      AppMethodBeat.i(46512);
      this.kyg = ((JsApiChooseMultiMedia.ChooseRequest)paramProcessRequest);
      int i;
      boolean bool;
      if (bs.iU(bef()) > 200L)
      {
        i = 1;
        if (i == 0) {
          t.makeText(bef(), ai.getResources().getString(2131755358), 1).show();
        }
        bef().mmSetOnActivityResultCallback(this);
        if (this.kyg.kyd != 1) {
          break label160;
        }
        bool = true;
        i = k;
      }
      for (;;)
      {
        if ((this.kyg.kxi) && (this.kyg.kxj))
        {
          paramProcessRequest = bhF();
          paramProcessRequest.putExtra("query_media_type", i);
          paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
          q.a(bef(), 1, this.kyg.count, this.kxr, paramProcessRequest);
          AppMethodBeat.o(46512);
          return;
          i = 0;
          break;
          label160:
          if (this.kyg.kyd == 2)
          {
            i = 1;
            bool = false;
            continue;
          }
          if (this.kyg.kyd != 3) {
            break label462;
          }
          i = 2;
          bool = false;
          continue;
        }
        if (this.kyg.kxj)
        {
          paramProcessRequest = bhF();
          paramProcessRequest.putExtra("show_header_view", false);
          paramProcessRequest.putExtra("query_media_type", i);
          paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
          q.a(bef(), 1, this.kyg.count, this.kxr, paramProcessRequest);
          AppMethodBeat.o(46512);
          return;
        }
        if (this.kyg.kxi)
        {
          paramProcessRequest = new Intent();
          paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_latitude", this.kyg.latitude);
          paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_longitude", this.kyg.longitude);
          if ((this.kyg.kyb) && (!this.kyg.kyc)) {
            i = 1;
          }
          for (;;)
          {
            SightParams localSightParams = new SightParams(7, 1);
            localSightParams.mode = i;
            localSightParams.hcZ.duration = this.kyg.jbG;
            paramProcessRequest.putExtra("KEY_SIGHT_PARAMS", localSightParams);
            q.a(bef(), 2, paramProcessRequest, 7, i);
            AppMethodBeat.o(46512);
            return;
            i = j;
            if (this.kyg.kyc)
            {
              i = j;
              if (!this.kyg.kyb) {
                i = 2;
              }
            }
          }
        }
        ac.e("MicroMsg.JsApiChooseMultiMedia", "unknown scene, ignore this request");
        this.kyh.bPH = -2;
        b(this.kyh);
        AppMethodBeat.o(46512);
        return;
        label462:
        bool = false;
        i = k;
      }
    }
    
    public final void bem()
    {
      AppMethodBeat.i(46517);
      super.bem();
      if (this.fxw != null)
      {
        this.fxw.dismiss();
        this.fxw = null;
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
        this.kyh.bPH = 0;
        b(this.kyh);
        AppMethodBeat.o(46514);
        return;
      }
      if (paramIntent != null) {}
      for (double d1 = paramIntent.getDoubleExtra("longitude", 181.0D);; d1 = 181.0D)
      {
        if (paramIntent != null) {
          d2 = paramIntent.getDoubleExtra("latitude", 91.0D);
        }
        ac.d("MicroMsg.JsApiChooseMultiMedia", "longitude: %f, latitude: %f.", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
        ac.i("MicroMsg.JsApiChooseMultiMedia", "requestCode: %d.", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        default: 
          this.kyh.bPH = -2;
          b(this.kyh);
          AppMethodBeat.o(46514);
          return;
        }
      }
      ac.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_GALLERY");
      if (paramIntent == null)
      {
        this.kyh.bPH = 0;
        b(this.kyh);
        AppMethodBeat.o(46514);
        return;
      }
      Object localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      final ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_select_video_list");
      final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      bhH();
      if (!bool2) {
        if (!bs.gY((List)localObject))
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
        l.bxj().postToWorker(new Runnable()
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
            if ((this.kyi != null) && (this.kyi.size() > 0))
            {
              localObject4 = this.kyi.iterator();
              for (;;)
              {
                if (((Iterator)localObject4).hasNext())
                {
                  localObject3 = (String)((Iterator)localObject4).next();
                  if ((!bs.isNullOrNil((String)localObject3)) && (new com.tencent.mm.vfs.e((String)localObject3).exists()))
                  {
                    ac.i("MicroMsg.JsApiChooseMultiMedia", "local img file exist, success");
                    l2 = 0L;
                    l1 = l2;
                    try
                    {
                      if (!bs.isNullOrNil((String)localObject3)) {
                        break;
                      }
                      l1 = l2;
                      ac.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                      localObject1 = null;
                      l1 = l2;
                      if (localObject1 != null)
                      {
                        l1 = l2;
                        l2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse((String)localObject1).getTime() / 1000L;
                        l1 = l2;
                        ac.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, imgPath: %s.", new Object[] { Long.valueOf(l2), localObject3 });
                        l1 = l2;
                      }
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        Object localObject1;
                        ac.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, imgPath: %s.", new Object[] { localObject3 });
                        continue;
                        ac.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. imgPath: %s.", new Object[] { localObject3 });
                        continue;
                        ac.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. imgPath: %s.", new Object[] { localObject3 });
                      }
                    }
                    d = -1.0D;
                    if ((com.tencent.mm.modelgeo.a.m(d2)) && (com.tencent.mm.modelgeo.a.l(bool2)))
                    {
                      localObject1 = BackwardSupportUtil.ExifHelper.aKu((String)localObject3);
                      if (localObject1 != null)
                      {
                        d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject1).dmL, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject1).hIO, d2, bool2);
                        localObject5 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l1, d);
                        if (!localArrayList) {
                          break label564;
                        }
                        localObject1 = JsApiChooseMultiMedia.a.MB((String)localObject3);
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
                localObject3 = JsApiChooseMultiMedia.Mw((String)localObject1);
                localObject6 = AppBrandLocalMediaObjectManager.h(JsApiChooseMultiMedia.a.this.kyg.appId, (String)localObject1, bool);
                if (localObject6 == null) {
                  break label594;
                }
                try
                {
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("type", "image");
                  ((JSONObject)localObject1).put("tempFilePath", ((AppBrandLocalMediaObject)localObject6).dgl);
                  ((JSONObject)localObject1).put("size", ((AppBrandLocalMediaObject)localObject6).ixc);
                  ((JSONObject)localObject1).put("width", ((JsApiChooseMultiMedia.b)localObject3).width);
                  ((JSONObject)localObject1).put("height", ((JsApiChooseMultiMedia.b)localObject3).height);
                  ((JSONObject)localObject1).put("orientation", ((JsApiChooseMultiMedia.b)localObject3).jBP);
                  ((JSONObject)localObject1).put("mark", localObject5);
                  ((JSONObject)localObject1).put("scene", "album");
                  localJSONArray.put(localObject1);
                }
                catch (Exception localException1)
                {
                  ac.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", localException1, "", new Object[0]);
                }
              }
              break;
              l1 = l2;
              if (!i.eA((String)localObject3))
              {
                l1 = l2;
                ac.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { localObject3 });
                str1 = null;
                break label125;
              }
              l1 = l2;
              String str1 = Exif.fromFile((String)localObject3).dateTime;
              break label125;
              label564:
              if (this.kxA)
              {
                String str2 = JsApiChooseMultiMedia.a.MC((String)localObject3);
                if (!str2.equals(localObject3))
                {
                  bool = true;
                  continue;
                  label594:
                  ac.e("MicroMsg.JsApiChooseMultiMedia", "handle chosen list from gallery, get null obj from path: %s", new Object[] { str2 });
                  break;
                  if ((this.kyj != null) && (this.kyj.size() > 0))
                  {
                    localObject3 = this.kyj.iterator();
                    while (((Iterator)localObject3).hasNext())
                    {
                      str2 = (String)((Iterator)localObject3).next();
                      if ((!bs.isNullOrNil(str2)) && (new com.tencent.mm.vfs.e(str2).exists()))
                      {
                        ac.i("MicroMsg.JsApiChooseMultiMedia", "local video file exist, success");
                        l2 = 0L;
                        l1 = l2;
                        try
                        {
                          localObject4 = BackwardSupportUtil.aKt(str2);
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
                            ac.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, videoPath: %s.", new Object[] { Long.valueOf(l2), str2 });
                            l1 = l2;
                          }
                          d = -1.0D;
                          if ((com.tencent.mm.modelgeo.a.m(d2)) && (com.tencent.mm.modelgeo.a.l(bool2)))
                          {
                            localObject4 = BackwardSupportUtil.aKs(str2);
                            if (localObject4 != null)
                            {
                              d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject4).dmL, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject4).hIO, d2, bool2);
                              localObject4 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l1, d);
                              localObject5 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, str2, true);
                              if (localObject5 != null) {
                                break label1064;
                              }
                              ac.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail, mVideoFilePath is %s", new Object[] { str2 });
                              JsApiChooseMultiMedia.a.this.kyh.bPH = -2;
                              JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kyh);
                              AppMethodBeat.o(46506);
                              return;
                            }
                          }
                        }
                        catch (Exception localException4)
                        {
                          for (;;)
                          {
                            ac.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, videoPath: %s.", new Object[] { str2 });
                            continue;
                            ac.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. videoPath: %s.", new Object[] { str2 });
                            continue;
                            ac.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. videoPath: %s.", new Object[] { str2 });
                          }
                          localObject6 = JsApiChooseMultiMedia.a.MD(str2);
                          str2 = "";
                          if (!bs.isNullOrNil((String)localObject6)) {
                            str2 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, (String)localObject6);
                          }
                          try
                          {
                            localObject6 = new JSONObject();
                            ((JSONObject)localObject6).put("type", "video");
                            ((JSONObject)localObject6).put("tempFilePath", ((AppBrandLocalVideoObject)localObject5).dgl);
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
                            ac.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", localException3, "", new Object[0]);
                          }
                        }
                      }
                    }
                  }
                  JsApiChooseMultiMedia.a.this.kyh.bPH = -1;
                  JsApiChooseMultiMedia.a.this.kyh.kyf = localJSONArray.toString();
                  JsApiChooseMultiMedia.a.b(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kyh);
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
      ac.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
      if (paramIntent == null)
      {
        this.kyh.bPH = 0;
        b(this.kyh);
        AppMethodBeat.o(46514);
        return;
      }
      ac.i("MicroMsg.JsApiChooseMultiMedia", "data is valid!");
      localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (localObject == null)
      {
        ac.e("MicroMsg.JsApiChooseMultiMedia", "sight capture result is null!");
        this.kyh.bPH = -2;
        b(this.kyh);
        AppMethodBeat.o(46514);
        return;
      }
      if (((SightCaptureResult)localObject).uJm)
      {
        localObject = ((SightCaptureResult)localObject).uJu;
        if ((bs.isNullOrNil((String)localObject)) || (!i.eA((String)localObject)))
        {
          ac.e("MicroMsg.JsApiChooseMultiMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
          this.kyh.bPH = -2;
          b(this.kyh);
          AppMethodBeat.o(46514);
          return;
        }
        ac.i("MicroMsg.JsApiChooseMultiMedia", "filePath:%s", new Object[] { localObject });
        bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        bhH();
        l.bxj().postToWorker(new Runnable()
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
              localObject1 = JsApiChooseMultiMedia.a.MB(this.val$filePath);
              localb = JsApiChooseMultiMedia.Mw((String)localObject1);
              localObject1 = AppBrandLocalMediaObjectManager.h(JsApiChooseMultiMedia.a.this.kyg.appId, (String)localObject1, bool1 | true);
              if (localObject1 == null) {
                break label265;
              }
              l = Calendar.getInstance().getTimeInMillis() / 1000L;
              d = -1.0D;
              if ((!com.tencent.mm.modelgeo.a.m(d2)) || (!com.tencent.mm.modelgeo.a.l(this.hFk))) {
                break label244;
              }
              localObject2 = JsApiChooseMultiMedia.a.bhI();
              if (localObject2 == null) {
                break label223;
              }
              d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).dmL, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).hIO, d2, this.hFk);
            }
            for (;;)
            {
              localObject2 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l, d);
              ac.i("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight is done.");
              JsApiChooseMultiMedia.a.this.kyh.bPH = -1;
              JsApiChooseMultiMedia.a.this.kyh.kyf = JsApiChooseMultiMedia.a.b(((AppBrandLocalMediaObject)localObject1).dgl, ((AppBrandLocalMediaObject)localObject1).ixc, localb.width, localb.height, localb.jBP, (String)localObject2);
              JsApiChooseMultiMedia.a.c(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kyh);
              AppMethodBeat.o(46507);
              return;
              localObject1 = this.val$filePath;
              break;
              label223:
              ac.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. pic_Path: %s.", new Object[] { this.val$filePath });
              continue;
              label244:
              ac.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. pic_Path: %s.", new Object[] { this.val$filePath });
            }
            label265:
            ac.e("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
            JsApiChooseMultiMedia.a.this.kyh.bPH = -2;
            JsApiChooseMultiMedia.a.d(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kyh);
            AppMethodBeat.o(46507);
          }
        });
        AppMethodBeat.o(46514);
        return;
      }
      paramIntent = ((SightCaptureResult)localObject).uJo;
      if (bs.isNullOrNil(paramIntent))
      {
        ac.e("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath is null");
        this.kyh.bPH = -2;
        b(this.kyh);
        AppMethodBeat.o(46514);
        return;
      }
      ac.i("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath:%s", new Object[] { paramIntent });
      bhH();
      l.bxj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46508);
          AppBrandLocalVideoObject localAppBrandLocalVideoObject;
          if (new com.tencent.mm.vfs.e(paramIntent).exists())
          {
            ac.i("MicroMsg.JsApiChooseMultiMedia", "take media camera, the mVideoFilePath file exist, success");
            JsApiChooseMultiMedia.a.this.kyh.bPH = -1;
            localAppBrandLocalVideoObject = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, paramIntent, false);
            if (localAppBrandLocalVideoObject == null)
            {
              ac.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { paramIntent });
              JsApiChooseMultiMedia.a.this.kyh.bPH = -2;
              JsApiChooseMultiMedia.a.e(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kyh);
              AppMethodBeat.o(46508);
              return;
            }
            str = JsApiChooseMultiMedia.a.MD(paramIntent);
            if (bs.isNullOrNil(str)) {
              break label372;
            }
          }
          label372:
          for (String str = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, str);; str = "")
          {
            long l = Calendar.getInstance().getTimeInMillis() / 1000L;
            double d = -1.0D;
            Object localObject;
            if ((com.tencent.mm.modelgeo.a.m(d2)) && (com.tencent.mm.modelgeo.a.l(this.hFk)))
            {
              localObject = JsApiChooseMultiMedia.a.bhI();
              if (localObject != null) {
                d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dmL, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).hIO, d2, this.hFk);
              }
            }
            for (;;)
            {
              localObject = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l, d);
              JsApiChooseMultiMedia.a.this.kyh.kyf = JsApiChooseMultiMedia.a.b(localAppBrandLocalVideoObject.dgl, localAppBrandLocalVideoObject.size, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.duration, str, (String)localObject);
              JsApiChooseMultiMedia.a.f(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kyh);
              AppMethodBeat.o(46508);
              return;
              ac.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. video_Path: %s.", new Object[] { paramIntent });
              continue;
              ac.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. video_Path: %s.", new Object[] { paramIntent });
            }
            ac.e("MicroMsg.JsApiChooseMultiMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { paramIntent });
            JsApiChooseMultiMedia.a.this.kyh.bPH = -2;
            JsApiChooseMultiMedia.a.g(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kyh);
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
    public String jBP;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia
 * JD-Core Version:    0.7.0.1
 */