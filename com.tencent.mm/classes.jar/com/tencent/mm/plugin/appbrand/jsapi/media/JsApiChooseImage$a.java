package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class JsApiChooseImage$a
  extends AppBrandProxyUIProcessTask
{
  private p ftP;
  JsApiChooseImage.ChooseRequest jWC;
  JsApiChooseImage.ChooseResult jWD;
  final int jWE;
  int jWF;
  boolean jWG;
  boolean jWH;
  boolean jWI;
  private DialogInterface.OnCancelListener jWJ;
  double latitude;
  double longitude;
  
  private JsApiChooseImage$a()
  {
    AppMethodBeat.i(46412);
    this.jWD = new JsApiChooseImage.ChooseResult();
    this.jWE = (hashCode() % 10000);
    AppMethodBeat.o(46412);
  }
  
  private static String Iq(String paramString)
  {
    AppMethodBeat.i(46415);
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    if (i != 0) {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        Object localObject1 = MMBitmapFactory.decodeFile(paramString, localOptions);
        if (localObject1 == null)
        {
          ad.e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
          AppMethodBeat.o(46415);
          return paramString;
        }
        float f = i % 360;
        Bitmap localBitmap = f.a((Bitmap)localObject1, f);
        Object localObject2 = new StringBuilder().append(com.tencent.mm.loader.j.b.aif()).append("microMsg.tmp.").append(System.currentTimeMillis());
        if (c.d(localOptions))
        {
          localObject1 = ".jpg";
          localObject2 = (String)localObject1;
          if (!c.d(localOptions)) {
            break label165;
          }
        }
        for (localObject1 = Bitmap.CompressFormat.JPEG;; localObject1 = Bitmap.CompressFormat.PNG)
        {
          try
          {
            f.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
            if (c.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.m.b.cH(paramString, (String)localObject2);
            }
            AppMethodBeat.o(46415);
            return localObject2;
          }
          catch (Exception localException)
          {
            label165:
            ad.e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", new Object[] { localException });
            i.deleteFile((String)localObject2);
            AppMethodBeat.o(46415);
            return paramString;
          }
          localObject1 = ".png";
          break;
        }
        AppMethodBeat.o(46415);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        AppMethodBeat.o(46415);
        return paramString;
      }
      catch (NullPointerException localNullPointerException)
      {
        AppMethodBeat.o(46415);
        return paramString;
      }
    }
    return paramString;
  }
  
  private static String Ir(String paramString)
  {
    AppMethodBeat.i(46416);
    String str = i.k(com.tencent.mm.loader.j.b.ais() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        ad.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(46416);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = f.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          ad.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          ad.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
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
          ad.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      Object localObject4;
      for (;;)
      {
        ad.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
        localObject4 = null;
      }
      localObject4.recycle();
      long l = bt.eGO();
      try
      {
        boolean bool = c.dX(str, paramString);
        ad.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bt.eGO() - l), paramString, Long.valueOf(i.aMN(paramString)), str, Long.valueOf(new e(str).length()) });
        if (bool)
        {
          AppMethodBeat.o(46416);
          return str;
        }
        AppMethodBeat.o(46416);
        return paramString;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        ad.e("MicroMsg.JsApiChooseImage", "compressImage, oom");
        AppMethodBeat.o(46416);
      }
    }
    return paramString;
  }
  
  private void akm()
  {
    AppMethodBeat.i(180231);
    if ((!baJ()) && (!this.jWG))
    {
      ad.i("MicroMsg.JsApiChooseImage", "requestLocationPermission fail, abort");
      AppMethodBeat.o(180231);
      return;
    }
    l.bqm().postToWorker(new JsApiChooseImage.a.2(this));
    AppMethodBeat.o(180231);
  }
  
  private boolean baJ()
  {
    AppMethodBeat.i(180229);
    MMActivity localMMActivity = aXi();
    if (localMMActivity == null)
    {
      ad.e("MicroMsg.JsApiChooseImage", "requestLocationPermission, pageContext is null");
      AppMethodBeat.o(180229);
      return false;
    }
    if (com.tencent.luggage.h.h.o(localMMActivity, "android.permission.ACCESS_FINE_LOCATION"))
    {
      this.jWH = true;
      AppMethodBeat.o(180229);
      return true;
    }
    if (this.jWG)
    {
      AppMethodBeat.o(180229);
      return false;
    }
    if (this.jWC != null) {
      this.jWC.jWA = false;
    }
    boolean bool = com.tencent.luggage.h.h.a(localMMActivity, "android.permission.ACCESS_FINE_LOCATION", this.jWE, null, null);
    AppMethodBeat.o(180229);
    return bool;
  }
  
  private void rP(int paramInt)
  {
    AppMethodBeat.i(46414);
    this.jWJ = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(195904);
        JsApiChooseImage.a.this.jWD.bRZ = 0;
        JsApiChooseImage.a.a(JsApiChooseImage.a.this, JsApiChooseImage.a.this.jWD);
        AppMethodBeat.o(195904);
      }
    };
    MMActivity localMMActivity = aXi();
    aj.getResources().getString(2131755906);
    this.ftP = com.tencent.mm.ui.base.h.b(localMMActivity, aj.getResources().getString(paramInt), true, this.jWJ);
    AppMethodBeat.o(46414);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(46413);
    this.jWC = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
    this.jWC.jWA = true;
    this.jWC.count = Math.max(1, Math.min(9, this.jWC.count));
    int i;
    if ((this.jWC.jWy & this.jWC.jWz))
    {
      i = 8;
      this.jWF = i;
      if (bt.iJ(aXi()) <= 200L) {
        break label316;
      }
      i = 1;
      label87:
      if (i == 0) {
        com.tencent.mm.ui.base.t.makeText(aXi(), aj.getResources().getString(2131755358), 1).show();
      }
      this.jWI = JsApiChooseImage.baI();
      ad.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot: %b", new Object[] { Boolean.valueOf(this.jWI) });
      aXi().mmSetOnActivityResultCallback(this);
      paramProcessRequest = new Intent();
      if (this.jWC.jWy) {
        break label321;
      }
      bool = true;
      label168:
      paramProcessRequest.putExtra("key_send_raw_image", bool);
      paramProcessRequest.putExtra("key_force_show_raw_image_button", this.jWC.jWz);
      if ((!this.jWC.jWz) || (this.jWC.jWy)) {
        break label326;
      }
    }
    label316:
    label321:
    label326:
    for (boolean bool = true;; bool = false)
    {
      paramProcessRequest.putExtra("key_is_raw_image_button_disable", bool);
      paramProcessRequest.putExtra("query_media_type", 1);
      paramProcessRequest.putExtra("key_force_hide_edit_image_button_after_album_take_image", true);
      paramProcessRequest.putExtra("gallery_report_tag", 16);
      if ((!this.jWC.jWw) || (!this.jWC.jWx)) {
        break label358;
      }
      if (!this.jWI) {
        break label331;
      }
      ad.e("MicroMsg.JsApiChooseImage", "illegal scene, ignore this request");
      this.jWD.bRZ = -2;
      b(this.jWD);
      AppMethodBeat.o(46413);
      return;
      i = 7;
      break;
      i = 0;
      break label87;
      bool = false;
      break label168;
    }
    label331:
    q.a(aXi(), 1, this.jWC.count, this.jWF, paramProcessRequest);
    AppMethodBeat.o(46413);
    return;
    label358:
    if (this.jWC.jWx)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      q.a(aXi(), 1, this.jWC.count, this.jWF, paramProcessRequest);
      AppMethodBeat.o(46413);
      return;
    }
    if (this.jWC.jWw)
    {
      if (this.jWI)
      {
        akm();
        AppMethodBeat.o(46413);
        return;
      }
      q.d(aXi(), com.tencent.mm.loader.j.b.ais(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
      AppMethodBeat.o(46413);
      return;
    }
    ad.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
    this.jWD.bRZ = -2;
    b(this.jWD);
    AppMethodBeat.o(46413);
  }
  
  public final void aXp()
  {
    AppMethodBeat.i(46417);
    super.aXp();
    if (this.ftP != null)
    {
      this.ftP.dismiss();
      this.ftP = null;
    }
    AppMethodBeat.o(46417);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    final boolean bool2 = true;
    AppMethodBeat.i(46418);
    if (paramInt2 == 0)
    {
      this.jWD.bRZ = 0;
      b(this.jWD);
      AppMethodBeat.o(46418);
      return;
    }
    switch (paramInt1)
    {
    default: 
      this.jWD.bRZ = -2;
      b(this.jWD);
      AppMethodBeat.o(46418);
      return;
    case 1: 
    case 3: 
      if (paramIntent == null)
      {
        this.jWD.bRZ = 0;
        b(this.jWD);
        AppMethodBeat.o(46418);
        return;
      }
      final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      boolean bool3 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      final int i = this.jWC.jWy;
      label186:
      final boolean bool1;
      if (!this.jWC.jWz)
      {
        paramInt1 = 1;
        if (((paramInt1 & i) == 0) && (!(this.jWC.jWy & this.jWC.jWz & bool3))) {
          break label386;
        }
        i = 1;
        if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
          break label392;
        }
        bool1 = true;
        label211:
        ad.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.jWC.jWy), Boolean.valueOf(this.jWC.jWz), Boolean.valueOf(bool3), Boolean.valueOf(i) });
        if (i != 0) {
          rP(2131755359);
        }
        if (i != 0) {
          break label403;
        }
        if (bt.gL(localArrayList)) {
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
          rP(2131755481);
        }
        l.bqm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195906);
            final ArrayList localArrayList = new ArrayList(localArrayList.size());
            Iterator localIterator = localArrayList.iterator();
            for (;;)
            {
              Object localObject2;
              boolean bool1;
              boolean bool2;
              String str;
              Object localObject1;
              if (localIterator.hasNext())
              {
                localObject2 = (String)localIterator.next();
                bool1 = com.tencent.mm.sdk.platformtools.t.aFm((String)localObject2);
                bool2 = bool1;
                if (!bool1) {
                  if (i)
                  {
                    str = JsApiChooseImage.a.Is((String)localObject2);
                    localObject1 = localObject2;
                    bool1 = bool2;
                    if (str != null)
                    {
                      localObject1 = localObject2;
                      bool1 = bool2;
                      if (!str.equals(localObject2))
                      {
                        bool1 = true;
                        localObject1 = str;
                      }
                    }
                    label115:
                    localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseImage.a.this.jWC.appId, (String)localObject1, bool1);
                    if ((localObject2 != null) && (!bool1)) {}
                  }
                }
              }
              try
              {
                JsApiChooseImage.a.c(JsApiChooseImage.a.this).getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { localObject1 });
                label168:
                localArrayList.add(localObject2);
                continue;
                localObject1 = localObject2;
                bool1 = bool2;
                if (!bool2) {
                  break label115;
                }
                str = JsApiChooseImage.a.It((String)localObject2);
                localObject1 = localObject2;
                bool1 = bool2;
                if (str.equals(localObject2)) {
                  break label115;
                }
                bool1 = true;
                localObject1 = str;
                break label115;
                ad.i("MicroMsg.JsApiChooseImage", "path: %s is a GIF file", new Object[] { localObject2 });
                localObject1 = localObject2;
                bool1 = bool2;
                break label115;
                ad.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", new Object[] { localObject1 });
                continue;
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(195905);
                    JsApiChooseImage.a.this.jWD.bRZ = -1;
                    JsApiChooseImage.a.this.jWD.jWB = localArrayList;
                    JsApiChooseImage.a.b(JsApiChooseImage.a.this, JsApiChooseImage.a.this.jWD);
                    AppMethodBeat.o(195905);
                  }
                });
                AppMethodBeat.o(195906);
                return;
              }
              catch (Exception localException)
              {
                break label168;
              }
            }
          }
        });
        AppMethodBeat.o(46418);
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
    if (this.jWI)
    {
      if (paramIntent == null)
      {
        this.jWD.bRZ = 0;
        b(this.jWD);
        AppMethodBeat.o(46418);
        return;
      }
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        this.jWD.bRZ = 0;
        b(this.jWD);
        AppMethodBeat.o(46418);
        return;
      }
    }
    for (paramIntent = paramIntent.tAX; bt.isNullOrNil(paramIntent); paramIntent = q.h(aXi().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.ais()))
    {
      ad.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
      this.jWD.bRZ = -2;
      b(this.jWD);
      AppMethodBeat.o(46418);
      return;
    }
    if ((aXi() != null) && (aXi().getWindow() != null)) {
      aXi().getWindow().getDecorView().setBackgroundColor(-16777216);
    }
    l.bqm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195908);
        try
        {
          com.tencent.mm.plugin.appbrand.m.b.a(paramIntent, JsApiChooseImage.a.this.latitude, JsApiChooseImage.a.this.longitude, System.currentTimeMillis());
          ad.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
          aq.f(new Runnable()
          {
            public final void run()
            {
              boolean bool2 = false;
              AppMethodBeat.i(195907);
              Intent localIntent = new Intent();
              if (!JsApiChooseImage.a.this.jWC.jWy) {}
              for (boolean bool1 = true;; bool1 = false)
              {
                localIntent.putExtra("key_send_raw_image", bool1);
                localIntent.putExtra("key_force_show_raw_image_button", JsApiChooseImage.a.this.jWC.jWz);
                bool1 = bool2;
                if (JsApiChooseImage.a.this.jWC.jWz)
                {
                  bool1 = bool2;
                  if (!JsApiChooseImage.a.this.jWC.jWy) {
                    bool1 = true;
                  }
                }
                localIntent.putExtra("key_is_raw_image_button_disable", bool1);
                localIntent.putExtra("max_select_count", JsApiChooseImage.a.this.jWC.count);
                localIntent.putExtra("query_source_type", JsApiChooseImage.a.this.jWF);
                localIntent.putExtra("isPreviewPhoto", true);
                localIntent.putExtra("max_select_count", 1);
                ArrayList localArrayList = new ArrayList(1);
                localArrayList.add(JsApiChooseImage.a.5.this.val$filePath);
                localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
                localIntent.putExtra("preview_image", true);
                localIntent.putExtra("key_force_hide_edit_image_button", true);
                localIntent.addFlags(67108864);
                JsApiChooseImage.a.a(JsApiChooseImage.a.this, "gallery", ".ui.GalleryEntryUI", localIntent);
                AppMethodBeat.o(195907);
                return;
              }
            }
          });
          AppMethodBeat.o(195908);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.w("MicroMsg.JsApiChooseImage", "set extra exif info error", new Object[] { localException });
          }
        }
      }
    });
    AppMethodBeat.o(46418);
  }
  
  public final void s(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(180230);
    if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      ad.i("MicroMsg.JsApiChooseImage", "PERMISSION_GRANTED, take photo again");
      this.jWH = true;
    }
    for (;;)
    {
      akm();
      AppMethodBeat.o(180230);
      return;
      ad.e("MicroMsg.JsApiChooseImage", "SYS_PERM_DENIED");
      this.jWG = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a
 * JD-Core Version:    0.7.0.1
 */