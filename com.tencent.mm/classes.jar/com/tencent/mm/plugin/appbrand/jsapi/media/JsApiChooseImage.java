package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 29;
  public static final String NAME = "chooseImage";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131151);
    if (com.tencent.mm.plugin.appbrand.n.yc(paramc.getAppId()).gRb)
    {
      paramc.h(paramInt, j("cancel", null));
      AppMethodBeat.o(131151);
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(131151);
      return;
    }
    JsApiChooseImage.ChooseRequest localChooseRequest = new JsApiChooseImage.ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str1 = paramJSONObject.optString("sizeType");
    String str2 = paramJSONObject.optString("count");
    ab.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[] { localJSONArray, str1, str2 });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.hQD = true;
      localChooseRequest.hQE = true;
      if (!localChooseRequest.hQD) {
        break label314;
      }
      com.tencent.mm.plugin.appbrand.permission.n.b(paramc.getAppId(), new JsApiChooseImage.3(this, paramc, paramJSONObject, paramInt));
      paramJSONObject = paramc.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label272;
      }
      paramc.h(paramInt, j("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label314;
      }
      AppMethodBeat.o(131151);
      return;
      localChooseRequest.hQD = localJSONArray.toString().contains("camera");
      localChooseRequest.hQE = localJSONArray.toString().contains("album");
      break;
      label272:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.n.EA(paramc.getAppId());
        i = bool;
      }
    }
    label314:
    com.tencent.mm.plugin.appbrand.n.yd(paramc.getAppId()).gRb = true;
    com.tencent.mm.plugin.appbrand.e.a(paramc.getAppId(), new JsApiChooseImage.1(this, paramc));
    if (bo.isNullOrNil(str1)) {}
    for (paramJSONObject = "compressed";; paramJSONObject = str1)
    {
      localChooseRequest.hQF = paramJSONObject.contains("compressed");
      localChooseRequest.hQG = paramJSONObject.contains("original");
      localChooseRequest.count = bo.getInt(str2, 9);
      localChooseRequest.appId = paramc.getAppId();
      com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localChooseRequest, new JsApiChooseImage.2(this, paramc, paramInt));
      AppMethodBeat.o(131151);
      return;
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private p ehb;
    JsApiChooseImage.ChooseRequest hQI;
    JsApiChooseImage.ChooseResult hQJ;
    int hQK;
    private DialogInterface.OnCancelListener hQL;
    
    private a()
    {
      AppMethodBeat.i(131139);
      this.hQJ = new JsApiChooseImage.ChooseResult();
      AppMethodBeat.o(131139);
    }
    
    private static String Cn(String paramString)
    {
      AppMethodBeat.i(131142);
      int i = Exif.fromFile(paramString).getOrientationInDegree();
      if (i != 0) {
        try
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          Object localObject1 = MMBitmapFactory.decodeFile(paramString, localOptions);
          if (localObject1 == null)
          {
            ab.e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
            AppMethodBeat.o(131142);
            return paramString;
          }
          float f = i % 360;
          Bitmap localBitmap = d.b((Bitmap)localObject1, f);
          Object localObject2 = new StringBuilder().append(com.tencent.mm.compatible.util.e.esr).append("microMsg.tmp.").append(System.currentTimeMillis());
          if (com.tencent.mm.plugin.appbrand.t.c.b(localOptions))
          {
            localObject1 = ".jpg";
            localObject2 = (String)localObject1;
            if (!com.tencent.mm.plugin.appbrand.t.c.b(localOptions)) {
              break label164;
            }
          }
          for (localObject1 = Bitmap.CompressFormat.JPEG;; localObject1 = Bitmap.CompressFormat.PNG)
          {
            try
            {
              d.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
              if (com.tencent.mm.plugin.appbrand.t.c.b(localOptions)) {
                com.tencent.mm.plugin.appbrand.h.b.bZ(paramString, (String)localObject2);
              }
              AppMethodBeat.o(131142);
              return localObject2;
            }
            catch (Exception localException)
            {
              label164:
              ab.e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", new Object[] { localException });
              com.tencent.mm.a.e.deleteFile((String)localObject2);
              AppMethodBeat.o(131142);
              return paramString;
            }
            localObject1 = ".png";
            break;
          }
          AppMethodBeat.o(131142);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          AppMethodBeat.o(131142);
          return paramString;
        }
        catch (NullPointerException localNullPointerException)
        {
          AppMethodBeat.o(131142);
          return paramString;
        }
      }
      return paramString;
    }
    
    private static String Co(String paramString)
    {
      AppMethodBeat.i(131143);
      String str = com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".jpg";
      try
      {
        Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
        if (localBitmap1 == null)
        {
          ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
          AppMethodBeat.o(131143);
          return null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
          try
          {
            Bitmap localBitmap2 = d.decodeFile(paramString, null);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
            Object localObject1 = null;
          }
          catch (Exception localException1)
          {
            ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
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
            Bitmap localBitmap3 = d.decodeFile(paramString, null);
          }
          catch (Exception localException2)
          {
            ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
            Object localObject3 = null;
          }
        }
      }
      catch (Exception localException3)
      {
        Object localObject4;
        for (;;)
        {
          ab.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
          localObject4 = null;
        }
        localObject4.recycle();
        long l = bo.aoy();
        try
        {
          boolean bool = com.tencent.mm.plugin.appbrand.t.c.cW(str, paramString);
          ab.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bo.aoy() - l), paramString, Long.valueOf(new File(paramString).length()), str, Long.valueOf(new File(str).length()) });
          if (bool)
          {
            AppMethodBeat.o(131143);
            return str;
          }
          AppMethodBeat.o(131143);
          return paramString;
        }
        catch (OutOfMemoryError localOutOfMemoryError3)
        {
          ab.e("MicroMsg.JsApiChooseImage", "compressImage, oom");
          AppMethodBeat.o(131143);
        }
      }
      return paramString;
    }
    
    private void of(int paramInt)
    {
      AppMethodBeat.i(131141);
      this.hQL = new JsApiChooseImage.a.1(this);
      MMActivity localMMActivity = aBf();
      ah.getResources().getString(2131297087);
      this.ehb = h.b(localMMActivity, ah.getResources().getString(paramInt), true, this.hQL);
      AppMethodBeat.o(131141);
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(131140);
      this.hQI = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
      this.hQI.count = Math.max(1, Math.min(9, this.hQI.count));
      int i;
      if ((this.hQI.hQF & this.hQI.hQG))
      {
        i = 8;
        this.hQK = i;
        if (bo.hg(aBf()) <= 200L) {
          break label202;
        }
        i = 1;
        label79:
        if (i == 0) {
          t.makeText(aBf(), ah.getResources().getString(2131296593), 1).show();
        }
        aBf().mmSetOnActivityResultCallback(this);
        paramProcessRequest = new Intent();
        if (this.hQI.hQF) {
          break label207;
        }
      }
      label202:
      label207:
      for (boolean bool = true;; bool = false)
      {
        paramProcessRequest.putExtra("key_send_raw_image", bool);
        paramProcessRequest.putExtra("query_media_type", 1);
        if ((!this.hQI.hQD) || (!this.hQI.hQE)) {
          break label212;
        }
        com.tencent.mm.pluginsdk.ui.tools.n.a(aBf(), 1, this.hQI.count, this.hQK, paramProcessRequest);
        AppMethodBeat.o(131140);
        return;
        i = 7;
        break;
        i = 0;
        break label79;
      }
      label212:
      if (this.hQI.hQE)
      {
        paramProcessRequest.putExtra("show_header_view", false);
        com.tencent.mm.pluginsdk.ui.tools.n.a(aBf(), 1, this.hQI.count, this.hQK, paramProcessRequest);
        AppMethodBeat.o(131140);
        return;
      }
      if (this.hQI.hQD)
      {
        com.tencent.mm.pluginsdk.ui.tools.n.c(aBf(), com.tencent.mm.compatible.util.e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(131140);
        return;
      }
      ab.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
      this.hQJ.bpE = -2;
      a(this.hQJ);
      AppMethodBeat.o(131140);
    }
    
    public final void aBl()
    {
      AppMethodBeat.i(131144);
      super.aBl();
      if (this.ehb != null)
      {
        this.ehb.dismiss();
        this.ehb = null;
      }
      AppMethodBeat.o(131144);
    }
    
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      final boolean bool2 = true;
      AppMethodBeat.i(131145);
      if (paramInt2 == 0)
      {
        this.hQJ.bpE = 0;
        a(this.hQJ);
        AppMethodBeat.o(131145);
        return;
      }
      switch (paramInt1)
      {
      default: 
        this.hQJ.bpE = -2;
        a(this.hQJ);
        AppMethodBeat.o(131145);
        return;
      case 1: 
      case 3: 
        if (paramIntent == null)
        {
          this.hQJ.bpE = 0;
          a(this.hQJ);
          AppMethodBeat.o(131145);
          return;
        }
        final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        boolean bool3 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        final int i = this.hQI.hQF;
        label186:
        final boolean bool1;
        if (!this.hQI.hQG)
        {
          paramInt1 = 1;
          if (((paramInt1 & i) == 0) && (!(this.hQI.hQF & this.hQI.hQG & bool3))) {
            break label386;
          }
          i = 1;
          if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
            break label392;
          }
          bool1 = true;
          label211:
          ab.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.hQI.hQF), Boolean.valueOf(this.hQI.hQG), Boolean.valueOf(bool3), Boolean.valueOf(i) });
          if (i != 0) {
            of(2131296594);
          }
          if (i != 0) {
            break label403;
          }
          if (bo.es(localArrayList)) {
            break label398;
          }
          paramIntent = localArrayList.iterator();
          while (paramIntent.hasNext()) {
            if (Exif.fromFile((String)paramIntent.next()).getOrientationInDegree() != 0)
            {
              paramInt1 = 1;
              label335:
              if (paramInt1 == 0) {
                break label403;
              }
            }
          }
        }
        for (;;)
        {
          if (bool2) {
            of(2131296700);
          }
          com.tencent.mm.plugin.appbrand.s.m.aNS().ac(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131137);
              ArrayList localArrayList = new ArrayList(localArrayList.size());
              Iterator localIterator = localArrayList.iterator();
              Object localObject1;
              boolean bool;
              if (localIterator.hasNext())
              {
                localObject1 = (String)localIterator.next();
                bool = bool1;
                if (i)
                {
                  localObject1 = JsApiChooseImage.a.Cp((String)localObject1);
                  bool |= true;
                }
              }
              label172:
              for (;;)
              {
                Object localObject2 = AppBrandLocalMediaObjectManager.j(JsApiChooseImage.a.this.hQI.appId, (String)localObject1, bool);
                if (localObject2 != null)
                {
                  localArrayList.add(localObject2);
                  break;
                  if (!bool2) {
                    break label172;
                  }
                  localObject2 = JsApiChooseImage.a.Cq((String)localObject1);
                  if (((String)localObject2).equals(localObject1)) {
                    break label172;
                  }
                  bool |= true;
                  localObject1 = localObject2;
                  continue;
                }
                ab.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", new Object[] { localObject1 });
                break;
                al.d(new JsApiChooseImage.a.2.1(this, localArrayList));
                AppMethodBeat.o(131137);
                return;
              }
            }
          });
          AppMethodBeat.o(131145);
          return;
          paramInt1 = 0;
          break;
          label386:
          i = 0;
          break label186;
          label392:
          bool1 = false;
          break label211;
          label398:
          paramInt1 = 0;
          break label335;
          label403:
          bool2 = false;
        }
      }
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.n.h(aBf().getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.esr);
      if (bo.isNullOrNil(paramIntent))
      {
        ab.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
        this.hQJ.bpE = -2;
        a(this.hQJ);
        AppMethodBeat.o(131145);
        return;
      }
      ab.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
      al.d(new JsApiChooseImage.a.3(this, paramIntent));
      AppMethodBeat.o(131145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage
 * JD-Core Version:    0.7.0.1
 */