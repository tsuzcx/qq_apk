package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.widget.Toast;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.plugin.appbrand.v.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class JsApiChooseImage$a
  extends AppBrandProxyUIProcessTask
{
  private p dpF;
  JsApiChooseImage.ChooseRequest gvr;
  JsApiChooseImage.ChooseResult gvs = new JsApiChooseImage.ChooseResult();
  int gvt;
  private DialogInterface.OnCancelListener gvu;
  
  private void lw(int paramInt)
  {
    this.gvu = new JsApiChooseImage.a.1(this);
    MMActivity localMMActivity = ahy();
    int i = y.j.app_tip;
    ae.getResources().getString(i);
    this.dpF = h.b(localMMActivity, ae.getResources().getString(paramInt), true, this.gvu);
  }
  
  private static String ul(String paramString)
  {
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    if (i != 0) {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        Object localObject1 = MMBitmapFactory.decodeFile(paramString, localOptions, 0);
        if (localObject1 == null)
        {
          y.e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
          return paramString;
        }
        Bitmap localBitmap = c.b((Bitmap)localObject1, i % 360);
        Object localObject2 = new StringBuilder().append(com.tencent.mm.compatible.util.e.dzD).append("microMsg.tmp.").append(System.currentTimeMillis());
        if (a.a(localOptions))
        {
          localObject1 = ".jpg";
          localObject2 = (String)localObject1;
          if (!a.a(localOptions)) {
            break label143;
          }
        }
        for (localObject1 = Bitmap.CompressFormat.JPEG;; localObject1 = Bitmap.CompressFormat.PNG)
        {
          try
          {
            c.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
            if (a.a(localOptions)) {
              b.bv(paramString, (String)localObject2);
            }
            return localObject2;
          }
          catch (Exception localException)
          {
            label143:
            y.e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", new Object[] { localException });
            com.tencent.mm.a.e.deleteFile((String)localObject2);
            return paramString;
          }
          localObject1 = ".png";
          break;
        }
        return paramString;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        return paramString;
      }
      catch (NullPointerException localNullPointerException) {}
    }
  }
  
  private static String um(String paramString)
  {
    String str = com.tencent.mm.compatible.util.e.dzD + "microMsg." + System.currentTimeMillis() + ".jpg";
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString, 0);
      if (localBitmap1 == null)
      {
        y.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
        paramString = null;
        return paramString;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = c.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          y.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          y.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e " + localException1);
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
          Bitmap localBitmap3 = c.decodeFile(paramString, null);
        }
        catch (Exception localException2)
        {
          y.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e " + localException2);
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      boolean bool;
      do
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e " + localException3);
          Object localObject4 = null;
        }
        long l = bk.UY();
        bool = a.ch(str, paramString);
        y.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bk.UY() - l), paramString, Long.valueOf(new File(paramString).length()), str, Long.valueOf(new File(str).length()) });
      } while (!bool);
    }
    return str;
  }
  
  protected final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    this.gvr = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
    this.gvr.count = Math.max(1, Math.min(9, this.gvr.count));
    int i;
    if ((this.gvr.gvo & this.gvr.gvp))
    {
      i = 8;
      this.gvt = i;
      if (bk.fQ(ahy()) <= 200L) {
        break label194;
      }
      i = 1;
      label73:
      if (i == 0)
      {
        paramProcessRequest = ahy();
        i = y.j.app_brand_choose_media_memory_check_message;
        s.makeText(paramProcessRequest, ae.getResources().getString(i), 1).show();
      }
      ahy().gJb = this;
      paramProcessRequest = new Intent();
      if (this.gvr.gvo) {
        break label199;
      }
    }
    label194:
    label199:
    for (boolean bool = true;; bool = false)
    {
      paramProcessRequest.putExtra("key_send_raw_image", bool);
      paramProcessRequest.putExtra("query_media_type", 1);
      if ((!this.gvr.gvm) || (!this.gvr.gvn)) {
        break label204;
      }
      l.a(ahy(), 1, this.gvr.count, this.gvt, paramProcessRequest);
      return;
      i = 7;
      break;
      i = 0;
      break label73;
    }
    label204:
    if (this.gvr.gvn)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      l.a(ahy(), 1, this.gvr.count, this.gvt, paramProcessRequest);
      return;
    }
    if (this.gvr.gvm)
    {
      l.c(ahy(), com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
      return;
    }
    y.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
    this.gvs.aYY = -2;
    a(this.gvs);
  }
  
  protected final void ahE()
  {
    super.ahE();
    if (this.dpF != null)
    {
      this.dpF.dismiss();
      this.dpF = null;
    }
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    if (paramInt2 == 0)
    {
      this.gvs.aYY = 0;
      a(this.gvs);
      return;
    }
    switch (paramInt1)
    {
    default: 
      this.gvs.aYY = -2;
      a(this.gvs);
      return;
    case 1: 
    case 3: 
      if (paramIntent == null)
      {
        this.gvs.aYY = 0;
        a(this.gvs);
        return;
      }
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      boolean bool3 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      int i = this.gvr.gvo;
      label162:
      boolean bool1;
      if (!this.gvr.gvp)
      {
        paramInt1 = 1;
        if (((paramInt1 & i) == 0) && (!(this.gvr.gvo & this.gvr.gvp & bool3))) {
          break label356;
        }
        i = 1;
        if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
          break label362;
        }
        bool1 = true;
        label187:
        y.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.gvr.gvo), Boolean.valueOf(this.gvr.gvp), Boolean.valueOf(bool3), Boolean.valueOf(i) });
        if (i != 0) {
          lw(y.j.app_brand_choose_media_video_compressing);
        }
        if (i != 0) {
          break label373;
        }
        if (bk.dk(localArrayList)) {
          break label368;
        }
        paramIntent = localArrayList.iterator();
        while (paramIntent.hasNext()) {
          if (Exif.fromFile((String)paramIntent.next()).getOrientationInDegree() != 0)
          {
            paramInt1 = 1;
            label311:
            if (paramInt1 == 0) {
              break label373;
            }
          }
        }
      }
      for (;;)
      {
        if (bool2) {
          lw(y.j.app_brand_jsapi_choose_image_processing);
        }
        n.DS().O(new JsApiChooseImage.a.2(this, localArrayList, bool1, i, bool2));
        return;
        paramInt1 = 0;
        break;
        label356:
        i = 0;
        break label162;
        label362:
        bool1 = false;
        break label187;
        label368:
        paramInt1 = 0;
        break label311;
        label373:
        bool2 = false;
      }
    }
    paramIntent = l.f(ahy().getApplicationContext(), paramIntent, com.tencent.mm.compatible.util.e.dzD);
    if (bk.bl(paramIntent))
    {
      y.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
      this.gvs.aYY = -2;
      a(this.gvs);
      return;
    }
    y.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
    ai.d(new JsApiChooseImage.a.3(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a
 * JD-Core Version:    0.7.0.1
 */