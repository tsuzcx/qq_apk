package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class JsApiChooseImage$a
  extends AppBrandProxyUIProcessTask
{
  private p fSP;
  JsApiChooseImage.ChooseRequest kXd;
  JsApiChooseImage.ChooseResult kXe;
  final int kXf;
  int kXg;
  boolean kXh;
  boolean kXi;
  boolean kXj;
  private DialogInterface.OnCancelListener kXk;
  double latitude;
  double longitude;
  
  private JsApiChooseImage$a()
  {
    AppMethodBeat.i(46412);
    this.kXe = new JsApiChooseImage.ChooseResult();
    this.kXf = (hashCode() % 10000);
    AppMethodBeat.o(46412);
  }
  
  private void auk()
  {
    AppMethodBeat.i(180231);
    if ((!blS()) && (!this.kXh))
    {
      ae.i("MicroMsg.JsApiChooseImage", "requestLocationPermission fail, abort");
      AppMethodBeat.o(180231);
      return;
    }
    m.bCj().postToWorker(new JsApiChooseImage.a.2(this));
    AppMethodBeat.o(180231);
  }
  
  private boolean blS()
  {
    AppMethodBeat.i(180229);
    MMActivity localMMActivity = bis();
    if (localMMActivity == null)
    {
      ae.e("MicroMsg.JsApiChooseImage", "requestLocationPermission, pageContext is null");
      AppMethodBeat.o(180229);
      return false;
    }
    if (com.tencent.luggage.h.h.n(localMMActivity, "android.permission.ACCESS_FINE_LOCATION"))
    {
      this.kXi = true;
      AppMethodBeat.o(180229);
      return true;
    }
    if (this.kXh)
    {
      AppMethodBeat.o(180229);
      return false;
    }
    if (this.kXd != null) {
      this.kXd.kXb = false;
    }
    boolean bool = com.tencent.luggage.h.h.a(localMMActivity, "android.permission.ACCESS_FINE_LOCATION", this.kXf, null, null);
    AppMethodBeat.o(180229);
    return bool;
  }
  
  private void tl(int paramInt)
  {
    AppMethodBeat.i(46414);
    this.kXk = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(222567);
        JsApiChooseImage.a.this.kXe.bZU = 0;
        JsApiChooseImage.a.a(JsApiChooseImage.a.this, JsApiChooseImage.a.this.kXe);
        AppMethodBeat.o(222567);
      }
    };
    MMActivity localMMActivity = bis();
    ak.getResources().getString(2131755906);
    this.fSP = com.tencent.mm.ui.base.h.b(localMMActivity, ak.getResources().getString(paramInt), true, this.kXk);
    AppMethodBeat.o(46414);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(46413);
    this.kXd = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
    this.kXd.kXb = true;
    this.kXd.count = Math.max(1, Math.min(9, this.kXd.count));
    int i;
    if ((this.kXd.kWZ & this.kXd.kXa))
    {
      i = 8;
      this.kXg = i;
      if (bu.jk(bis()) <= 200L) {
        break label313;
      }
      i = 1;
      label86:
      if (i == 0) {
        t.makeText(bis(), ak.getResources().getString(2131755358), 1).show();
      }
      this.kXj = JsApiChooseImage.blc();
      ae.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot: %b", new Object[] { Boolean.valueOf(this.kXj) });
      bis().mmSetOnActivityResultCallback(this);
      paramProcessRequest = new Intent();
      if (this.kXd.kWZ) {
        break label318;
      }
      bool = true;
      label166:
      paramProcessRequest.putExtra("key_send_raw_image", bool);
      paramProcessRequest.putExtra("key_force_show_raw_image_button", this.kXd.kXa);
      if ((!this.kXd.kXa) || (this.kXd.kWZ)) {
        break label323;
      }
    }
    label313:
    label318:
    label323:
    for (boolean bool = true;; bool = false)
    {
      paramProcessRequest.putExtra("key_is_raw_image_button_disable", bool);
      paramProcessRequest.putExtra("query_media_type", 1);
      paramProcessRequest.putExtra("key_force_hide_edit_image_button_after_album_take_image", true);
      paramProcessRequest.putExtra("gallery_report_tag", 16);
      if ((!this.kXd.kWX) || (!this.kXd.kWY)) {
        break label354;
      }
      if (!this.kXj) {
        break label328;
      }
      ae.e("MicroMsg.JsApiChooseImage", "illegal scene, ignore this request");
      this.kXe.bZU = -2;
      b(this.kXe);
      AppMethodBeat.o(46413);
      return;
      i = 7;
      break;
      i = 0;
      break label86;
      bool = false;
      break label166;
    }
    label328:
    q.a(bis(), 1, this.kXd.count, this.kXg, paramProcessRequest);
    AppMethodBeat.o(46413);
    return;
    label354:
    if (this.kXd.kWY)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      q.a(bis(), 1, this.kXd.count, this.kXg, paramProcessRequest);
      AppMethodBeat.o(46413);
      return;
    }
    if (this.kXd.kWX)
    {
      if (this.kXj)
      {
        auk();
        AppMethodBeat.o(46413);
        return;
      }
      q.d(bis(), com.tencent.mm.loader.j.b.asv(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
      AppMethodBeat.o(46413);
      return;
    }
    ae.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
    this.kXe.bZU = -2;
    b(this.kXe);
    AppMethodBeat.o(46413);
  }
  
  public final void biz()
  {
    AppMethodBeat.i(46417);
    super.biz();
    if (this.fSP != null)
    {
      this.fSP.dismiss();
      this.fSP = null;
    }
    AppMethodBeat.o(46417);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(46418);
    if (paramInt2 == 0)
    {
      this.kXe.bZU = 0;
      b(this.kXe);
      AppMethodBeat.o(46418);
      return;
    }
    switch (paramInt1)
    {
    default: 
      this.kXe.bZU = -2;
      b(this.kXe);
      AppMethodBeat.o(46418);
      return;
    case 1: 
    case 3: 
      if (paramIntent == null)
      {
        this.kXe.bZU = 0;
        b(this.kXe);
        AppMethodBeat.o(46418);
        return;
      }
      final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      final int i = this.kXd.kWZ;
      label182:
      final boolean bool1;
      if (!this.kXd.kXa)
      {
        paramInt1 = 1;
        if (((paramInt1 & i) == 0) && (!(this.kXd.kWZ & this.kXd.kXa & bool2))) {
          break label344;
        }
        i = 1;
        if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
          break label350;
        }
        bool1 = true;
        label207:
        ae.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.kXd.kWZ), Boolean.valueOf(this.kXd.kXa), Boolean.valueOf(bool2), Boolean.valueOf(i) });
        if (i != 0) {
          tl(2131755359);
        }
        if ((i != 0) || (!r.br(localArrayList))) {
          break label356;
        }
      }
      label344:
      label350:
      label356:
      for (bool2 = true;; bool2 = false)
      {
        if (bool2) {
          tl(2131755481);
        }
        m.bCj().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222569);
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
                bool1 = u.aRG((String)localObject2);
                bool2 = bool1;
                if (!bool1) {
                  if (i)
                  {
                    str = r.QG((String)localObject2);
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
                    localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseImage.a.this.kXd.appId, (String)localObject1, bool1);
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
                str = r.QH((String)localObject2);
                localObject1 = localObject2;
                bool1 = bool2;
                if (str.equals(localObject2)) {
                  break label115;
                }
                bool1 = true;
                localObject1 = str;
                break label115;
                ae.i("MicroMsg.JsApiChooseImage", "path: %s is a GIF file", new Object[] { localObject2 });
                localObject1 = localObject2;
                bool1 = bool2;
                break label115;
                ae.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", new Object[] { localObject1 });
                continue;
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(222568);
                    JsApiChooseImage.a.this.kXe.bZU = -1;
                    JsApiChooseImage.a.this.kXe.kXc = localArrayList;
                    JsApiChooseImage.a.b(JsApiChooseImage.a.this, JsApiChooseImage.a.this.kXe);
                    AppMethodBeat.o(222568);
                  }
                });
                AppMethodBeat.o(222569);
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
        i = 0;
        break label182;
        bool1 = false;
        break label207;
      }
    }
    if (this.kXj)
    {
      if (paramIntent == null)
      {
        this.kXe.bZU = 0;
        b(this.kXe);
        AppMethodBeat.o(46418);
        return;
      }
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        this.kXe.bZU = 0;
        b(this.kXe);
        AppMethodBeat.o(46418);
        return;
      }
    }
    for (paramIntent = paramIntent.vYE; bu.isNullOrNil(paramIntent); paramIntent = q.i(bis().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.asv()))
    {
      ae.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
      this.kXe.bZU = -2;
      b(this.kXe);
      AppMethodBeat.o(46418);
      return;
    }
    if ((bis() != null) && (bis().getWindow() != null)) {
      bis().getWindow().getDecorView().setBackgroundColor(-16777216);
    }
    m.bCj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222571);
        try
        {
          com.tencent.mm.plugin.appbrand.l.b.a(paramIntent, JsApiChooseImage.a.this.latitude, JsApiChooseImage.a.this.longitude, System.currentTimeMillis());
          ae.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
          ar.f(new Runnable()
          {
            public final void run()
            {
              boolean bool2 = false;
              AppMethodBeat.i(222570);
              Intent localIntent = new Intent();
              if (!JsApiChooseImage.a.this.kXd.kWZ) {}
              for (boolean bool1 = true;; bool1 = false)
              {
                localIntent.putExtra("key_send_raw_image", bool1);
                localIntent.putExtra("key_force_show_raw_image_button", JsApiChooseImage.a.this.kXd.kXa);
                bool1 = bool2;
                if (JsApiChooseImage.a.this.kXd.kXa)
                {
                  bool1 = bool2;
                  if (!JsApiChooseImage.a.this.kXd.kWZ) {
                    bool1 = true;
                  }
                }
                localIntent.putExtra("key_is_raw_image_button_disable", bool1);
                localIntent.putExtra("max_select_count", JsApiChooseImage.a.this.kXd.count);
                localIntent.putExtra("query_source_type", JsApiChooseImage.a.this.kXg);
                localIntent.putExtra("isPreviewPhoto", true);
                localIntent.putExtra("max_select_count", 1);
                ArrayList localArrayList = new ArrayList(1);
                localArrayList.add(JsApiChooseImage.a.5.this.val$filePath);
                localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
                localIntent.putExtra("preview_image", true);
                localIntent.putExtra("key_force_hide_edit_image_button", true);
                localIntent.addFlags(67108864);
                JsApiChooseImage.a.a(JsApiChooseImage.a.this, "gallery", ".ui.GalleryEntryUI", localIntent);
                AppMethodBeat.o(222570);
                return;
              }
            }
          });
          AppMethodBeat.o(222571);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.w("MicroMsg.JsApiChooseImage", "set extra exif info error", new Object[] { localException });
          }
        }
      }
    });
    AppMethodBeat.o(46418);
  }
  
  public final void t(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(180230);
    if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      ae.i("MicroMsg.JsApiChooseImage", "PERMISSION_GRANTED, take photo again");
      this.kXi = true;
    }
    for (;;)
    {
      auk();
      AppMethodBeat.o(180230);
      return;
      ae.e("MicroMsg.JsApiChooseImage", "SYS_PERM_DENIED");
      this.kXh = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a
 * JD-Core Version:    0.7.0.1
 */