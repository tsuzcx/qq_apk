package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Images.Media;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage
  extends d
{
  public static final int CTRL_INDEX = 29;
  public static final String NAME = "chooseImage";
  private static Boolean mcb = null;
  
  private static boolean bHo()
  {
    AppMethodBeat.i(226877);
    if (mcb == null)
    {
      Log.i("MicroMsg.JsApiChooseImage", "inti wx style field");
      mcb = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXA, false));
    }
    if (mcb == null)
    {
      Log.e("MicroMsg.JsApiChooseImage", "get shoot style fail, use default style");
      AppMethodBeat.o(226877);
      return false;
    }
    Log.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot, flag: %b", new Object[] { mcb });
    boolean bool = mcb.booleanValue();
    AppMethodBeat.o(226877);
    return bool;
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46425);
    if (paramf.getAppId() == null)
    {
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(46425);
      return;
    }
    if (com.tencent.mm.plugin.appbrand.p.Um(paramf.getAppId()).kCV)
    {
      paramf.i(paramInt, h("cancel", null));
      AppMethodBeat.o(46425);
      return;
    }
    final Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(46425);
      return;
    }
    final ChooseRequest localChooseRequest = new ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str1 = paramJSONObject.optString("sizeType");
    String str2 = paramJSONObject.optString("count");
    Log.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[] { localJSONArray, str1, str2 });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.mch = true;
      localChooseRequest.mci = true;
      if (!localChooseRequest.mch) {
        break label347;
      }
      com.tencent.mm.plugin.appbrand.permission.r.b(paramf.getAppId(), new android.support.v4.app.a.a()
      {
        public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(226861);
          if (paramAnonymousInt != 113)
          {
            AppMethodBeat.o(226861);
            return;
          }
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            JsApiChooseImage.this.a(paramf, paramJSONObject, paramInt);
            AppMethodBeat.o(226861);
            return;
          }
          paramf.i(paramInt, JsApiChooseImage.this.h("fail:system permission denied", null));
          AppMethodBeat.o(226861);
        }
      });
      paramJSONObject = paramf.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label302;
      }
      paramf.i(paramInt, h("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label347;
      }
      AppMethodBeat.o(46425);
      return;
      localChooseRequest.mch = localJSONArray.toString().contains("camera");
      localChooseRequest.mci = localJSONArray.toString().contains("album");
      break;
      label302:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.r.aeq(paramf.getAppId());
        i = bool;
      }
    }
    label347:
    com.tencent.mm.plugin.appbrand.p.Un(paramf.getAppId()).kCV = true;
    com.tencent.mm.plugin.appbrand.h.a(paramf.getAppId(), new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(180217);
        if (paramf.getAppId() != null) {
          com.tencent.mm.plugin.appbrand.p.Un(paramf.getAppId()).kCV = false;
        }
        com.tencent.mm.plugin.appbrand.h.b(paramf.getAppId(), this);
        AppMethodBeat.o(180217);
      }
    });
    if (Util.isNullOrNil(str1)) {}
    for (paramJSONObject = "compressed";; paramJSONObject = str1)
    {
      localChooseRequest.mcj = paramJSONObject.contains("compressed");
      localChooseRequest.mck = paramJSONObject.contains("original");
      localChooseRequest.count = Util.getInt(str2, 9);
      localChooseRequest.appId = paramf.getAppId();
      paramJSONObject = new AppBrandProxyUIProcessTask.b() {};
      if ((localChooseRequest.mch) && (localChooseRequest.mci) && (bHo()))
      {
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(226860);
            JsApiChooseImage.a(JsApiChooseImage.this, paramf.getContext(), new o.g()new DialogInterface.OnCancelListener
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(226858);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  Log.i("MicroMsg.JsApiChooseImage", "start select after source choose");
                  a.b(JsApiChooseImage.3.this.lVp, JsApiChooseImage.3.this.mce, JsApiChooseImage.3.this.mcf);
                  AppMethodBeat.o(226858);
                  return;
                  JsApiChooseImage.3.this.mce.mci = false;
                  continue;
                  JsApiChooseImage.3.this.mce.mch = false;
                }
              }
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(226859);
                Log.i("MicroMsg.JsApiChooseImage", "cancel when select source from");
                com.tencent.mm.plugin.appbrand.p.Un(JsApiChooseImage.3.this.czN.getAppId()).kCV = false;
                JsApiChooseImage.3.this.czN.i(JsApiChooseImage.3.this.cvP, JsApiChooseImage.this.h("cancel", null));
                AppMethodBeat.o(226859);
              }
            });
            AppMethodBeat.o(226860);
          }
        });
        AppMethodBeat.o(46425);
        return;
      }
      Log.i("MicroMsg.JsApiChooseImage", "start select");
      a.b(localContext, localChooseRequest, paramJSONObject);
      AppMethodBeat.o(46425);
      return;
    }
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int count;
    boolean mch;
    boolean mci;
    boolean mcj;
    boolean mck;
    boolean mcl;
    
    static
    {
      AppMethodBeat.i(46403);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46403);
    }
    
    ChooseRequest()
    {
      this.mcl = true;
    }
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46402);
      this.mcl = true;
      k(paramParcel);
      AppMethodBeat.o(46402);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bCJ()
    {
      return JsApiChooseImage.a.class;
    }
    
    public final boolean bDN()
    {
      boolean bool = true;
      if (!this.mcl)
      {
        this.mcl = true;
        bool = false;
      }
      return bool;
    }
    
    public final String bDO()
    {
      return "GalleryChooseImage";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46400);
      this.appId = paramParcel.readString();
      this.count = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.mch = bool1;
        if (paramParcel.readByte() == 0) {
          break label90;
        }
        bool1 = true;
        label46:
        this.mci = bool1;
        if (paramParcel.readByte() == 0) {
          break label95;
        }
        bool1 = true;
        label60:
        this.mcj = bool1;
        if (paramParcel.readByte() == 0) {
          break label100;
        }
      }
      label90:
      label95:
      label100:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.mck = bool1;
        AppMethodBeat.o(46400);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label46;
        bool1 = false;
        break label60;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46401);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.count);
      if (this.mch)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.mci) {
          break label92;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.mcj) {
          break label97;
        }
        b1 = 1;
        label61:
        paramParcel.writeByte(b1);
        if (!this.mck) {
          break label102;
        }
      }
      label92:
      label97:
      label102:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(46401);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label47;
        b1 = 0;
        break label61;
      }
    }
  }
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    ArrayList<AppBrandLocalMediaObject> mcm;
    int resultCode;
    
    static
    {
      AppMethodBeat.i(46407);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46407);
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
    
    public final void k(Parcel paramParcel)
    {
      AppMethodBeat.i(46405);
      this.resultCode = paramParcel.readInt();
      this.mcm = paramParcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
      AppMethodBeat.o(46405);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46406);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeTypedList(this.mcm);
      AppMethodBeat.o(46406);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private q gxX;
    double latitude;
    double longitude;
    JsApiChooseImage.ChooseRequest mcn;
    JsApiChooseImage.ChooseResult mco;
    final int mcp;
    int mcq;
    boolean mcr;
    boolean mcs;
    boolean mct;
    private DialogInterface.OnCancelListener mcu;
    
    private a()
    {
      AppMethodBeat.i(46412);
      this.mco = new JsApiChooseImage.ChooseResult();
      this.mcp = (hashCode() % 10000);
      AppMethodBeat.o(46412);
    }
    
    private void aML()
    {
      AppMethodBeat.i(180231);
      if ((!bHq()) && (!this.mcr))
      {
        Log.i("MicroMsg.JsApiChooseImage", "requestLocationPermission fail, abort");
        AppMethodBeat.o(180231);
        return;
      }
      m.bZn().postToWorker(new JsApiChooseImage.a.2(this));
      AppMethodBeat.o(180231);
    }
    
    private boolean bHq()
    {
      AppMethodBeat.i(180229);
      MMActivity localMMActivity = bDF();
      if (localMMActivity == null)
      {
        Log.e("MicroMsg.JsApiChooseImage", "requestLocationPermission, pageContext is null");
        AppMethodBeat.o(180229);
        return false;
      }
      if (i.n(localMMActivity, "android.permission.ACCESS_FINE_LOCATION"))
      {
        this.mcs = true;
        AppMethodBeat.o(180229);
        return true;
      }
      if (this.mcr)
      {
        AppMethodBeat.o(180229);
        return false;
      }
      if (this.mcn != null) {
        this.mcn.mcl = false;
      }
      boolean bool = i.a(localMMActivity, "android.permission.ACCESS_FINE_LOCATION", this.mcp, null, null);
      AppMethodBeat.o(180229);
      return bool;
    }
    
    private void xh(int paramInt)
    {
      AppMethodBeat.i(46414);
      this.mcu = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(226866);
          JsApiChooseImage.a.this.mco.resultCode = 0;
          JsApiChooseImage.a.a(JsApiChooseImage.a.this, JsApiChooseImage.a.this.mco);
          AppMethodBeat.o(226866);
        }
      };
      MMActivity localMMActivity = bDF();
      MMApplicationContext.getResources().getString(2131755998);
      this.gxX = com.tencent.mm.ui.base.h.a(localMMActivity, MMApplicationContext.getResources().getString(paramInt), true, this.mcu);
      AppMethodBeat.o(46414);
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46413);
      this.mcn = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
      this.mcn.mcl = true;
      this.mcn.count = Math.max(1, Math.min(9, this.mcn.count));
      this.mcq = 16;
      int i;
      if (Util.getAvailableMemoryMB(bDF()) > 200L)
      {
        i = 1;
        if (i == 0) {
          u.makeText(bDF(), MMApplicationContext.getResources().getString(2131755395), 1).show();
        }
        this.mct = JsApiChooseImage.bHp();
        Log.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot: %b", new Object[] { Boolean.valueOf(this.mct) });
        bDF().mmSetOnActivityResultCallback(this);
        paramProcessRequest = new Intent();
        if (this.mcn.mcj) {
          break label291;
        }
        bool = true;
        label145:
        paramProcessRequest.putExtra("key_send_raw_image", bool);
        paramProcessRequest.putExtra("key_force_show_raw_image_button", this.mcn.mck);
        if ((!this.mcn.mck) || (this.mcn.mcj)) {
          break label296;
        }
      }
      label291:
      label296:
      for (boolean bool = true;; bool = false)
      {
        paramProcessRequest.putExtra("key_is_raw_image_button_disable", bool);
        paramProcessRequest.putExtra("query_media_type", 1);
        paramProcessRequest.putExtra("key_force_hide_edit_image_button_after_album_take_image", true);
        paramProcessRequest.putExtra("gallery_report_tag", 16);
        if ((!this.mcn.mch) || (!this.mcn.mci)) {
          break label327;
        }
        if (!this.mct) {
          break label301;
        }
        Log.e("MicroMsg.JsApiChooseImage", "illegal scene, ignore this request");
        this.mco.resultCode = -2;
        b(this.mco);
        AppMethodBeat.o(46413);
        return;
        i = 0;
        break;
        bool = false;
        break label145;
      }
      label301:
      s.a(bDF(), 1, this.mcn.count, this.mcq, paramProcessRequest);
      AppMethodBeat.o(46413);
      return;
      label327:
      if (this.mcn.mci)
      {
        paramProcessRequest.putExtra("show_header_view", false);
        s.a(bDF(), 1, this.mcn.count, this.mcq, paramProcessRequest);
        AppMethodBeat.o(46413);
        return;
      }
      if (this.mcn.mch)
      {
        if (this.mct)
        {
          aML();
          AppMethodBeat.o(46413);
          return;
        }
        s.d(bDF(), com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(46413);
        return;
      }
      Log.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
      this.mco.resultCode = -2;
      b(this.mco);
      AppMethodBeat.o(46413);
    }
    
    public final void bDM()
    {
      AppMethodBeat.i(46417);
      super.bDM();
      if (this.gxX != null)
      {
        this.gxX.dismiss();
        this.gxX = null;
      }
      AppMethodBeat.o(46417);
    }
    
    public final void d(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      AppMethodBeat.i(46418);
      if (paramInt2 == 0)
      {
        this.mco.resultCode = 0;
        b(this.mco);
        AppMethodBeat.o(46418);
        return;
      }
      switch (paramInt1)
      {
      default: 
        this.mco.resultCode = -2;
        b(this.mco);
        AppMethodBeat.o(46418);
        return;
      case 1: 
      case 3: 
        if (paramIntent == null)
        {
          this.mco.resultCode = 0;
          b(this.mco);
          AppMethodBeat.o(46418);
          return;
        }
        final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        final int i = this.mcn.mcj;
        label182:
        final boolean bool1;
        if (!this.mcn.mck)
        {
          paramInt1 = 1;
          if (((paramInt1 & i) == 0) && (!(this.mcn.mcj & this.mcn.mck & bool2))) {
            break label344;
          }
          i = 1;
          if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
            break label350;
          }
          bool1 = true;
          label207:
          Log.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.mcn.mcj), Boolean.valueOf(this.mcn.mck), Boolean.valueOf(bool2), Boolean.valueOf(i) });
          if (i != 0) {
            xh(2131755396);
          }
          if ((i != 0) || (!r.bD(localArrayList))) {
            break label356;
          }
        }
        label344:
        label350:
        label356:
        for (bool2 = true;; bool2 = false)
        {
          if (bool2) {
            xh(2131755519);
          }
          m.bZn().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(226868);
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
                  bool1 = ImgUtil.isGif((String)localObject2);
                  bool2 = bool1;
                  if (!bool1) {
                    if (i)
                    {
                      str = r.aah((String)localObject2);
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
                      localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseImage.a.this.mcn.appId, (String)localObject1, bool1);
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
                  str = r.aai((String)localObject2);
                  localObject1 = localObject2;
                  bool1 = bool2;
                  if (str.equals(localObject2)) {
                    break label115;
                  }
                  bool1 = true;
                  localObject1 = str;
                  break label115;
                  Log.i("MicroMsg.JsApiChooseImage", "path: %s is a GIF file", new Object[] { localObject2 });
                  localObject1 = localObject2;
                  bool1 = bool2;
                  break label115;
                  Log.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", new Object[] { localObject1 });
                  continue;
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(226867);
                      JsApiChooseImage.a.this.mco.resultCode = -1;
                      JsApiChooseImage.a.this.mco.mcm = localArrayList;
                      JsApiChooseImage.a.b(JsApiChooseImage.a.this, JsApiChooseImage.a.this.mco);
                      AppMethodBeat.o(226867);
                    }
                  });
                  AppMethodBeat.o(226868);
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
      if (this.mct)
      {
        if (paramIntent == null)
        {
          this.mco.resultCode = 0;
          b(this.mco);
          AppMethodBeat.o(46418);
          return;
        }
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          this.mco.resultCode = 0;
          b(this.mco);
          AppMethodBeat.o(46418);
          return;
        }
      }
      for (paramIntent = paramIntent.zsG; Util.isNullOrNil(paramIntent); paramIntent = s.h(bDF().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aKV()))
      {
        Log.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
        this.mco.resultCode = -2;
        b(this.mco);
        AppMethodBeat.o(46418);
        return;
      }
      if ((bDF() != null) && (bDF().getWindow() != null)) {
        bDF().getWindow().getDecorView().setBackgroundColor(-16777216);
      }
      m.bZn().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226870);
          try
          {
            com.tencent.mm.plugin.appbrand.l.b.a(paramIntent, JsApiChooseImage.a.this.latitude, JsApiChooseImage.a.this.longitude, System.currentTimeMillis());
            Log.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                boolean bool2 = false;
                AppMethodBeat.i(226869);
                Intent localIntent = new Intent();
                if (!JsApiChooseImage.a.this.mcn.mcj) {}
                for (boolean bool1 = true;; bool1 = false)
                {
                  localIntent.putExtra("key_send_raw_image", bool1);
                  localIntent.putExtra("key_force_show_raw_image_button", JsApiChooseImage.a.this.mcn.mck);
                  bool1 = bool2;
                  if (JsApiChooseImage.a.this.mcn.mck)
                  {
                    bool1 = bool2;
                    if (!JsApiChooseImage.a.this.mcn.mcj) {
                      bool1 = true;
                    }
                  }
                  localIntent.putExtra("key_is_raw_image_button_disable", bool1);
                  localIntent.putExtra("max_select_count", JsApiChooseImage.a.this.mcn.count);
                  localIntent.putExtra("query_source_type", JsApiChooseImage.a.this.mcq);
                  localIntent.putExtra("isPreviewPhoto", true);
                  localIntent.putExtra("max_select_count", 1);
                  ArrayList localArrayList = new ArrayList(1);
                  localArrayList.add(JsApiChooseImage.a.5.this.val$filePath);
                  localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
                  localIntent.putExtra("preview_image", true);
                  localIntent.putExtra("key_force_hide_edit_image_button", true);
                  localIntent.addFlags(67108864);
                  JsApiChooseImage.a.a(JsApiChooseImage.a.this, "gallery", ".ui.GalleryEntryUI", localIntent);
                  AppMethodBeat.o(226869);
                  return;
                }
              }
            });
            AppMethodBeat.o(226870);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.w("MicroMsg.JsApiChooseImage", "set extra exif info error", new Object[] { localException });
            }
          }
        }
      });
      AppMethodBeat.o(46418);
    }
    
    public final void u(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(180230);
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        Log.i("MicroMsg.JsApiChooseImage", "PERMISSION_GRANTED, take photo again");
        this.mcs = true;
      }
      for (;;)
      {
        aML();
        AppMethodBeat.o(180230);
        return;
        Log.e("MicroMsg.JsApiChooseImage", "SYS_PERM_DENIED");
        this.mcr = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage
 * JD-Core Version:    0.7.0.1
 */