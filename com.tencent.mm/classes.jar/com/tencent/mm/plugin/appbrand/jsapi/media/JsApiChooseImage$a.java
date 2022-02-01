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
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class JsApiChooseImage$a
  extends AppBrandProxyUIProcessTask
{
  private p fQJ;
  boolean kTA;
  private DialogInterface.OnCancelListener kTB;
  JsApiChooseImage.ChooseRequest kTu;
  JsApiChooseImage.ChooseResult kTv;
  final int kTw;
  int kTx;
  boolean kTy;
  boolean kTz;
  double latitude;
  double longitude;
  
  private JsApiChooseImage$a()
  {
    AppMethodBeat.i(46412);
    this.kTv = new JsApiChooseImage.ChooseResult();
    this.kTw = (hashCode() % 10000);
    AppMethodBeat.o(46412);
  }
  
  private void atV()
  {
    AppMethodBeat.i(180231);
    if ((!blj()) && (!this.kTy))
    {
      ad.i("MicroMsg.JsApiChooseImage", "requestLocationPermission fail, abort");
      AppMethodBeat.o(180231);
      return;
    }
    m.bBp().postToWorker(new JsApiChooseImage.a.2(this));
    AppMethodBeat.o(180231);
  }
  
  private boolean blj()
  {
    AppMethodBeat.i(180229);
    MMActivity localMMActivity = bhJ();
    if (localMMActivity == null)
    {
      ad.e("MicroMsg.JsApiChooseImage", "requestLocationPermission, pageContext is null");
      AppMethodBeat.o(180229);
      return false;
    }
    if (com.tencent.luggage.h.h.n(localMMActivity, "android.permission.ACCESS_FINE_LOCATION"))
    {
      this.kTz = true;
      AppMethodBeat.o(180229);
      return true;
    }
    if (this.kTy)
    {
      AppMethodBeat.o(180229);
      return false;
    }
    if (this.kTu != null) {
      this.kTu.kTs = false;
    }
    boolean bool = com.tencent.luggage.h.h.a(localMMActivity, "android.permission.ACCESS_FINE_LOCATION", this.kTw, null, null);
    AppMethodBeat.o(180229);
    return bool;
  }
  
  private void ti(int paramInt)
  {
    AppMethodBeat.i(46414);
    this.kTB = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(188418);
        JsApiChooseImage.a.this.kTv.bZU = 0;
        JsApiChooseImage.a.a(JsApiChooseImage.a.this, JsApiChooseImage.a.this.kTv);
        AppMethodBeat.o(188418);
      }
    };
    MMActivity localMMActivity = bhJ();
    aj.getResources().getString(2131755906);
    this.fQJ = com.tencent.mm.ui.base.h.b(localMMActivity, aj.getResources().getString(paramInt), true, this.kTB);
    AppMethodBeat.o(46414);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(46413);
    this.kTu = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
    this.kTu.kTs = true;
    this.kTu.count = Math.max(1, Math.min(9, this.kTu.count));
    int i;
    if ((this.kTu.kTq & this.kTu.kTr))
    {
      i = 8;
      this.kTx = i;
      if (bt.je(bhJ()) <= 200L) {
        break label313;
      }
      i = 1;
      label86:
      if (i == 0) {
        com.tencent.mm.ui.base.t.makeText(bhJ(), aj.getResources().getString(2131755358), 1).show();
      }
      this.kTA = JsApiChooseImage.bli();
      ad.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot: %b", new Object[] { Boolean.valueOf(this.kTA) });
      bhJ().mmSetOnActivityResultCallback(this);
      paramProcessRequest = new Intent();
      if (this.kTu.kTq) {
        break label318;
      }
      bool = true;
      label166:
      paramProcessRequest.putExtra("key_send_raw_image", bool);
      paramProcessRequest.putExtra("key_force_show_raw_image_button", this.kTu.kTr);
      if ((!this.kTu.kTr) || (this.kTu.kTq)) {
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
      if ((!this.kTu.kTo) || (!this.kTu.kTp)) {
        break label354;
      }
      if (!this.kTA) {
        break label328;
      }
      ad.e("MicroMsg.JsApiChooseImage", "illegal scene, ignore this request");
      this.kTv.bZU = -2;
      b(this.kTv);
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
    q.a(bhJ(), 1, this.kTu.count, this.kTx, paramProcessRequest);
    AppMethodBeat.o(46413);
    return;
    label354:
    if (this.kTu.kTp)
    {
      paramProcessRequest.putExtra("show_header_view", false);
      q.a(bhJ(), 1, this.kTu.count, this.kTx, paramProcessRequest);
      AppMethodBeat.o(46413);
      return;
    }
    if (this.kTu.kTo)
    {
      if (this.kTA)
      {
        atV();
        AppMethodBeat.o(46413);
        return;
      }
      q.d(bhJ(), com.tencent.mm.loader.j.b.asg(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
      AppMethodBeat.o(46413);
      return;
    }
    ad.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
    this.kTv.bZU = -2;
    b(this.kTv);
    AppMethodBeat.o(46413);
  }
  
  public final void bhQ()
  {
    AppMethodBeat.i(46417);
    super.bhQ();
    if (this.fQJ != null)
    {
      this.fQJ.dismiss();
      this.fQJ = null;
    }
    AppMethodBeat.o(46417);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(46418);
    if (paramInt2 == 0)
    {
      this.kTv.bZU = 0;
      b(this.kTv);
      AppMethodBeat.o(46418);
      return;
    }
    switch (paramInt1)
    {
    default: 
      this.kTv.bZU = -2;
      b(this.kTv);
      AppMethodBeat.o(46418);
      return;
    case 1: 
    case 3: 
      if (paramIntent == null)
      {
        this.kTv.bZU = 0;
        b(this.kTv);
        AppMethodBeat.o(46418);
        return;
      }
      final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      final int i = this.kTu.kTq;
      label182:
      final boolean bool1;
      if (!this.kTu.kTr)
      {
        paramInt1 = 1;
        if (((paramInt1 & i) == 0) && (!(this.kTu.kTq & this.kTu.kTr & bool2))) {
          break label344;
        }
        i = 1;
        if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
          break label350;
        }
        bool1 = true;
        label207:
        ad.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.kTu.kTq), Boolean.valueOf(this.kTu.kTr), Boolean.valueOf(bool2), Boolean.valueOf(i) });
        if (i != 0) {
          ti(2131755359);
        }
        if ((i != 0) || (!r.bp(localArrayList))) {
          break label356;
        }
      }
      label344:
      label350:
      label356:
      for (bool2 = true;; bool2 = false)
      {
        if (bool2) {
          ti(2131755481);
        }
        m.bBp().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(188420);
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
                bool1 = com.tencent.mm.sdk.platformtools.t.aQj((String)localObject2);
                bool2 = bool1;
                if (!bool1) {
                  if (i)
                  {
                    str = r.PX((String)localObject2);
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
                    localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseImage.a.this.kTu.appId, (String)localObject1, bool1);
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
                str = r.PY((String)localObject2);
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
                    AppMethodBeat.i(188419);
                    JsApiChooseImage.a.this.kTv.bZU = -1;
                    JsApiChooseImage.a.this.kTv.kTt = localArrayList;
                    JsApiChooseImage.a.b(JsApiChooseImage.a.this, JsApiChooseImage.a.this.kTv);
                    AppMethodBeat.o(188419);
                  }
                });
                AppMethodBeat.o(188420);
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
    if (this.kTA)
    {
      if (paramIntent == null)
      {
        this.kTv.bZU = 0;
        b(this.kTv);
        AppMethodBeat.o(46418);
        return;
      }
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        this.kTv.bZU = 0;
        b(this.kTv);
        AppMethodBeat.o(46418);
        return;
      }
    }
    for (paramIntent = paramIntent.vMA; bt.isNullOrNil(paramIntent); paramIntent = q.i(bhJ().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.asg()))
    {
      ad.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
      this.kTv.bZU = -2;
      b(this.kTv);
      AppMethodBeat.o(46418);
      return;
    }
    if ((bhJ() != null) && (bhJ().getWindow() != null)) {
      bhJ().getWindow().getDecorView().setBackgroundColor(-16777216);
    }
    m.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188422);
        try
        {
          com.tencent.mm.plugin.appbrand.l.b.a(paramIntent, JsApiChooseImage.a.this.latitude, JsApiChooseImage.a.this.longitude, System.currentTimeMillis());
          ad.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
          aq.f(new Runnable()
          {
            public final void run()
            {
              boolean bool2 = false;
              AppMethodBeat.i(188421);
              Intent localIntent = new Intent();
              if (!JsApiChooseImage.a.this.kTu.kTq) {}
              for (boolean bool1 = true;; bool1 = false)
              {
                localIntent.putExtra("key_send_raw_image", bool1);
                localIntent.putExtra("key_force_show_raw_image_button", JsApiChooseImage.a.this.kTu.kTr);
                bool1 = bool2;
                if (JsApiChooseImage.a.this.kTu.kTr)
                {
                  bool1 = bool2;
                  if (!JsApiChooseImage.a.this.kTu.kTq) {
                    bool1 = true;
                  }
                }
                localIntent.putExtra("key_is_raw_image_button_disable", bool1);
                localIntent.putExtra("max_select_count", JsApiChooseImage.a.this.kTu.count);
                localIntent.putExtra("query_source_type", JsApiChooseImage.a.this.kTx);
                localIntent.putExtra("isPreviewPhoto", true);
                localIntent.putExtra("max_select_count", 1);
                ArrayList localArrayList = new ArrayList(1);
                localArrayList.add(JsApiChooseImage.a.5.this.val$filePath);
                localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
                localIntent.putExtra("preview_image", true);
                localIntent.putExtra("key_force_hide_edit_image_button", true);
                localIntent.addFlags(67108864);
                JsApiChooseImage.a.a(JsApiChooseImage.a.this, "gallery", ".ui.GalleryEntryUI", localIntent);
                AppMethodBeat.o(188421);
                return;
              }
            }
          });
          AppMethodBeat.o(188422);
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
  
  public final void t(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(180230);
    if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      ad.i("MicroMsg.JsApiChooseImage", "PERMISSION_GRANTED, take photo again");
      this.kTz = true;
    }
    for (;;)
    {
      atV();
      AppMethodBeat.o(180230);
      return;
      ad.e("MicroMsg.JsApiChooseImage", "SYS_PERM_DENIED");
      this.kTy = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a
 * JD-Core Version:    0.7.0.1
 */