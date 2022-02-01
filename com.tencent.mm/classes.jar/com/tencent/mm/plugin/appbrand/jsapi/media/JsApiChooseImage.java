package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Images.Media;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
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
  private static Boolean kxd = null;
  
  private static boolean bhA()
  {
    AppMethodBeat.i(186694);
    if (kxd == null)
    {
      ac.i("MicroMsg.JsApiChooseImage", "inti wx style field");
      kxd = Boolean.valueOf(((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSJ, false));
    }
    if (kxd == null)
    {
      ac.e("MicroMsg.JsApiChooseImage", "get shoot style fail, use default style");
      AppMethodBeat.o(186694);
      return false;
    }
    ac.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot, flag: %b", new Object[] { kxd });
    boolean bool = kxd.booleanValue();
    AppMethodBeat.o(186694);
    return bool;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46425);
    if (paramc.getAppId() == null)
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46425);
      return;
    }
    if (n.Hr(paramc.getAppId()).jfT)
    {
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46425);
      return;
    }
    final Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46425);
      return;
    }
    final ChooseRequest localChooseRequest = new ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str1 = paramJSONObject.optString("sizeType");
    String str2 = paramJSONObject.optString("count");
    ac.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[] { localJSONArray, str1, str2 });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.kxi = true;
      localChooseRequest.kxj = true;
      if (!localChooseRequest.kxi) {
        break label347;
      }
      o.b(paramc.getAppId(), new android.support.v4.app.a.a()
      {
        public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(186678);
          if (paramAnonymousInt != 113)
          {
            AppMethodBeat.o(186678);
            return;
          }
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            JsApiChooseImage.this.a(paramc, paramJSONObject, paramInt);
            AppMethodBeat.o(186678);
            return;
          }
          paramc.h(paramInt, JsApiChooseImage.this.e("fail:system permission denied", null));
          AppMethodBeat.o(186678);
        }
      });
      paramJSONObject = paramc.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label302;
      }
      paramc.h(paramInt, e("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label347;
      }
      AppMethodBeat.o(46425);
      return;
      localChooseRequest.kxi = localJSONArray.toString().contains("camera");
      localChooseRequest.kxj = localJSONArray.toString().contains("album");
      break;
      label302:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
      i = bool;
      if (bool)
      {
        o.Qo(paramc.getAppId());
        i = bool;
      }
    }
    label347:
    n.Hs(paramc.getAppId()).jfT = true;
    com.tencent.mm.plugin.appbrand.g.a(paramc.getAppId(), new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(180217);
        if (paramc.getAppId() != null) {
          n.Hs(paramc.getAppId()).jfT = false;
        }
        com.tencent.mm.plugin.appbrand.g.b(paramc.getAppId(), this);
        AppMethodBeat.o(180217);
      }
    });
    if (bs.isNullOrNil(str1)) {}
    for (paramJSONObject = "compressed";; paramJSONObject = str1)
    {
      localChooseRequest.kxk = paramJSONObject.contains("compressed");
      localChooseRequest.kxl = paramJSONObject.contains("original");
      localChooseRequest.count = bs.getInt(str2, 9);
      localChooseRequest.appId = paramc.getAppId();
      paramJSONObject = new AppBrandProxyUIProcessTask.b() {};
      if ((localChooseRequest.kxi) && (localChooseRequest.kxj) && (bhA()))
      {
        l.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186677);
            JsApiChooseImage.a(JsApiChooseImage.this, paramc.getContext(), new n.d()new DialogInterface.OnCancelListener
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(186675);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  ac.i("MicroMsg.JsApiChooseImage", "start select after source choose");
                  com.tencent.mm.plugin.appbrand.ipc.a.b(JsApiChooseImage.3.this.krt, JsApiChooseImage.3.this.kxf, JsApiChooseImage.3.this.kxg);
                  AppMethodBeat.o(186675);
                  return;
                  JsApiChooseImage.3.this.kxf.kxj = false;
                  continue;
                  JsApiChooseImage.3.this.kxf.kxi = false;
                }
              }
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(186676);
                ac.i("MicroMsg.JsApiChooseImage", "cancel when select source from");
                n.Hs(JsApiChooseImage.3.this.cds.getAppId()).jfT = false;
                JsApiChooseImage.3.this.cds.h(JsApiChooseImage.3.this.bZy, JsApiChooseImage.this.e("cancel", null));
                AppMethodBeat.o(186676);
              }
            });
            AppMethodBeat.o(186677);
          }
        });
        AppMethodBeat.o(46425);
        return;
      }
      ac.i("MicroMsg.JsApiChooseImage", "start select");
      com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localChooseRequest, paramJSONObject);
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
    boolean kxi;
    boolean kxj;
    boolean kxk;
    boolean kxl;
    boolean kxm;
    
    static
    {
      AppMethodBeat.i(46403);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46403);
    }
    
    ChooseRequest()
    {
      this.kxm = true;
    }
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46402);
      this.kxm = true;
      j(paramParcel);
      AppMethodBeat.o(46402);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bdj()
    {
      return JsApiChooseImage.a.class;
    }
    
    public final boolean ben()
    {
      boolean bool = true;
      if (!this.kxm)
      {
        this.kxm = true;
        bool = false;
      }
      return bool;
    }
    
    public final String beo()
    {
      return "GalleryChooseImage";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46400);
      this.appId = paramParcel.readString();
      this.count = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.kxi = bool1;
        if (paramParcel.readByte() == 0) {
          break label90;
        }
        bool1 = true;
        label46:
        this.kxj = bool1;
        if (paramParcel.readByte() == 0) {
          break label95;
        }
        bool1 = true;
        label60:
        this.kxk = bool1;
        if (paramParcel.readByte() == 0) {
          break label100;
        }
      }
      label90:
      label95:
      label100:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kxl = bool1;
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
      if (this.kxi)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.kxj) {
          break label92;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.kxk) {
          break label97;
        }
        b1 = 1;
        label61:
        paramParcel.writeByte(b1);
        if (!this.kxl) {
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
    int bPH;
    ArrayList<AppBrandLocalMediaObject> kxn;
    
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
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(46405);
      this.bPH = paramParcel.readInt();
      this.kxn = paramParcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
      AppMethodBeat.o(46405);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46406);
      paramParcel.writeInt(this.bPH);
      paramParcel.writeTypedList(this.kxn);
      AppMethodBeat.o(46406);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private p fxw;
    JsApiChooseImage.ChooseRequest kxo;
    JsApiChooseImage.ChooseResult kxp;
    final int kxq;
    int kxr;
    boolean kxs;
    boolean kxt;
    boolean kxu;
    private DialogInterface.OnCancelListener kxv;
    double latitude;
    double longitude;
    
    private a()
    {
      AppMethodBeat.i(46412);
      this.kxp = new JsApiChooseImage.ChooseResult();
      this.kxq = (hashCode() % 10000);
      AppMethodBeat.o(46412);
    }
    
    private void ari()
    {
      AppMethodBeat.i(180231);
      if ((!bhC()) && (!this.kxs))
      {
        ac.i("MicroMsg.JsApiChooseImage", "requestLocationPermission fail, abort");
        AppMethodBeat.o(180231);
        return;
      }
      l.bxj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46410);
          if (JsApiChooseImage.a.this.kxt) {
            JsApiChooseImage.a.a(JsApiChooseImage.a.this);
          }
          Object localObject = GetSightParamsIPCTask.kxa;
          localObject = GetSightParamsIPCTask.a.o(2, 0, false);
          ((SightParams)localObject).uJE = false;
          Intent localIntent = new Intent();
          localIntent.setClassName(JsApiChooseImage.a.b(JsApiChooseImage.a.this), "com.tencent.mm.plugin.mmsight.ui.SightCaptureUI");
          localIntent.putExtra("KEY_SIGHT_PARAMS", (Parcelable)localObject);
          JsApiChooseImage.a.a(JsApiChooseImage.a.this, localIntent);
          AppMethodBeat.o(46410);
        }
      });
      AppMethodBeat.o(180231);
    }
    
    private boolean bhC()
    {
      AppMethodBeat.i(180229);
      MMActivity localMMActivity = bef();
      if (localMMActivity == null)
      {
        ac.e("MicroMsg.JsApiChooseImage", "requestLocationPermission, pageContext is null");
        AppMethodBeat.o(180229);
        return false;
      }
      if (com.tencent.luggage.h.h.o(localMMActivity, "android.permission.ACCESS_FINE_LOCATION"))
      {
        this.kxt = true;
        AppMethodBeat.o(180229);
        return true;
      }
      if (this.kxs)
      {
        AppMethodBeat.o(180229);
        return false;
      }
      if (this.kxo != null) {
        this.kxo.kxm = false;
      }
      boolean bool = com.tencent.luggage.h.h.a(localMMActivity, "android.permission.ACCESS_FINE_LOCATION", this.kxq, null, null);
      AppMethodBeat.o(180229);
      return bool;
    }
    
    private void sF(int paramInt)
    {
      AppMethodBeat.i(46414);
      this.kxv = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(186683);
          JsApiChooseImage.a.this.kxp.bPH = 0;
          JsApiChooseImage.a.a(JsApiChooseImage.a.this, JsApiChooseImage.a.this.kxp);
          AppMethodBeat.o(186683);
        }
      };
      MMActivity localMMActivity = bef();
      ai.getResources().getString(2131755906);
      this.fxw = com.tencent.mm.ui.base.h.b(localMMActivity, ai.getResources().getString(paramInt), true, this.kxv);
      AppMethodBeat.o(46414);
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46413);
      this.kxo = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
      this.kxo.kxm = true;
      this.kxo.count = Math.max(1, Math.min(9, this.kxo.count));
      int i;
      if ((this.kxo.kxk & this.kxo.kxl))
      {
        i = 8;
        this.kxr = i;
        if (bs.iU(bef()) <= 200L) {
          break label313;
        }
        i = 1;
        label86:
        if (i == 0) {
          t.makeText(bef(), ai.getResources().getString(2131755358), 1).show();
        }
        this.kxu = JsApiChooseImage.bhB();
        ac.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot: %b", new Object[] { Boolean.valueOf(this.kxu) });
        bef().mmSetOnActivityResultCallback(this);
        paramProcessRequest = new Intent();
        if (this.kxo.kxk) {
          break label318;
        }
        bool = true;
        label166:
        paramProcessRequest.putExtra("key_send_raw_image", bool);
        paramProcessRequest.putExtra("key_force_show_raw_image_button", this.kxo.kxl);
        if ((!this.kxo.kxl) || (this.kxo.kxk)) {
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
        if ((!this.kxo.kxi) || (!this.kxo.kxj)) {
          break label354;
        }
        if (!this.kxu) {
          break label328;
        }
        ac.e("MicroMsg.JsApiChooseImage", "illegal scene, ignore this request");
        this.kxp.bPH = -2;
        b(this.kxp);
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
      com.tencent.mm.pluginsdk.ui.tools.q.a(bef(), 1, this.kxo.count, this.kxr, paramProcessRequest);
      AppMethodBeat.o(46413);
      return;
      label354:
      if (this.kxo.kxj)
      {
        paramProcessRequest.putExtra("show_header_view", false);
        com.tencent.mm.pluginsdk.ui.tools.q.a(bef(), 1, this.kxo.count, this.kxr, paramProcessRequest);
        AppMethodBeat.o(46413);
        return;
      }
      if (this.kxo.kxi)
      {
        if (this.kxu)
        {
          ari();
          AppMethodBeat.o(46413);
          return;
        }
        com.tencent.mm.pluginsdk.ui.tools.q.d(bef(), com.tencent.mm.loader.j.b.aps(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(46413);
        return;
      }
      ac.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
      this.kxp.bPH = -2;
      b(this.kxp);
      AppMethodBeat.o(46413);
    }
    
    public final void bem()
    {
      AppMethodBeat.i(46417);
      super.bem();
      if (this.fxw != null)
      {
        this.fxw.dismiss();
        this.fxw = null;
      }
      AppMethodBeat.o(46417);
    }
    
    public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      AppMethodBeat.i(46418);
      if (paramInt2 == 0)
      {
        this.kxp.bPH = 0;
        b(this.kxp);
        AppMethodBeat.o(46418);
        return;
      }
      switch (paramInt1)
      {
      default: 
        this.kxp.bPH = -2;
        b(this.kxp);
        AppMethodBeat.o(46418);
        return;
      case 1: 
      case 3: 
        if (paramIntent == null)
        {
          this.kxp.bPH = 0;
          b(this.kxp);
          AppMethodBeat.o(46418);
          return;
        }
        final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        final int i = this.kxo.kxk;
        label182:
        final boolean bool1;
        if (!this.kxo.kxl)
        {
          paramInt1 = 1;
          if (((paramInt1 & i) == 0) && (!(this.kxo.kxk & this.kxo.kxl & bool2))) {
            break label344;
          }
          i = 1;
          if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
            break label350;
          }
          bool1 = true;
          label207:
          ac.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.kxo.kxk), Boolean.valueOf(this.kxo.kxl), Boolean.valueOf(bool2), Boolean.valueOf(i) });
          if (i != 0) {
            sF(2131755359);
          }
          if ((i != 0) || (!q.bn(localArrayList))) {
            break label356;
          }
        }
        label344:
        label350:
        label356:
        for (bool2 = true;; bool2 = false)
        {
          if (bool2) {
            sF(2131755481);
          }
          l.bxj().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186685);
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
                  bool1 = s.aKD((String)localObject2);
                  bool2 = bool1;
                  if (!bool1) {
                    if (i)
                    {
                      str = q.Mz((String)localObject2);
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
                      localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseImage.a.this.kxo.appId, (String)localObject1, bool1);
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
                  str = q.MA((String)localObject2);
                  localObject1 = localObject2;
                  bool1 = bool2;
                  if (str.equals(localObject2)) {
                    break label115;
                  }
                  bool1 = true;
                  localObject1 = str;
                  break label115;
                  ac.i("MicroMsg.JsApiChooseImage", "path: %s is a GIF file", new Object[] { localObject2 });
                  localObject1 = localObject2;
                  bool1 = bool2;
                  break label115;
                  ac.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", new Object[] { localObject1 });
                  continue;
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(186684);
                      JsApiChooseImage.a.this.kxp.bPH = -1;
                      JsApiChooseImage.a.this.kxp.kxn = localArrayList;
                      JsApiChooseImage.a.b(JsApiChooseImage.a.this, JsApiChooseImage.a.this.kxp);
                      AppMethodBeat.o(186684);
                    }
                  });
                  AppMethodBeat.o(186685);
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
      if (this.kxu)
      {
        if (paramIntent == null)
        {
          this.kxp.bPH = 0;
          b(this.kxp);
          AppMethodBeat.o(46418);
          return;
        }
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          this.kxp.bPH = 0;
          b(this.kxp);
          AppMethodBeat.o(46418);
          return;
        }
      }
      for (paramIntent = paramIntent.uJu; bs.isNullOrNil(paramIntent); paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(bef().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aps()))
      {
        ac.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
        this.kxp.bPH = -2;
        b(this.kxp);
        AppMethodBeat.o(46418);
        return;
      }
      if ((bef() != null) && (bef().getWindow() != null)) {
        bef().getWindow().getDecorView().setBackgroundColor(-16777216);
      }
      l.bxj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186687);
          try
          {
            com.tencent.mm.plugin.appbrand.m.b.a(paramIntent, JsApiChooseImage.a.this.latitude, JsApiChooseImage.a.this.longitude, System.currentTimeMillis());
            ac.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
            ap.f(new Runnable()
            {
              public final void run()
              {
                boolean bool2 = false;
                AppMethodBeat.i(186686);
                Intent localIntent = new Intent();
                if (!JsApiChooseImage.a.this.kxo.kxk) {}
                for (boolean bool1 = true;; bool1 = false)
                {
                  localIntent.putExtra("key_send_raw_image", bool1);
                  localIntent.putExtra("key_force_show_raw_image_button", JsApiChooseImage.a.this.kxo.kxl);
                  bool1 = bool2;
                  if (JsApiChooseImage.a.this.kxo.kxl)
                  {
                    bool1 = bool2;
                    if (!JsApiChooseImage.a.this.kxo.kxk) {
                      bool1 = true;
                    }
                  }
                  localIntent.putExtra("key_is_raw_image_button_disable", bool1);
                  localIntent.putExtra("max_select_count", JsApiChooseImage.a.this.kxo.count);
                  localIntent.putExtra("query_source_type", JsApiChooseImage.a.this.kxr);
                  localIntent.putExtra("isPreviewPhoto", true);
                  localIntent.putExtra("max_select_count", 1);
                  ArrayList localArrayList = new ArrayList(1);
                  localArrayList.add(JsApiChooseImage.a.5.this.val$filePath);
                  localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
                  localIntent.putExtra("preview_image", true);
                  localIntent.putExtra("key_force_hide_edit_image_button", true);
                  localIntent.addFlags(67108864);
                  JsApiChooseImage.a.a(JsApiChooseImage.a.this, "gallery", ".ui.GalleryEntryUI", localIntent);
                  AppMethodBeat.o(186686);
                  return;
                }
              }
            });
            AppMethodBeat.o(186687);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.w("MicroMsg.JsApiChooseImage", "set extra exif info error", new Object[] { localException });
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
        ac.i("MicroMsg.JsApiChooseImage", "PERMISSION_GRANTED, take photo again");
        this.kxt = true;
      }
      for (;;)
      {
        ari();
        AppMethodBeat.o(180230);
        return;
        ac.e("MicroMsg.JsApiChooseImage", "SYS_PERM_DENIED");
        this.kxs = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage
 * JD-Core Version:    0.7.0.1
 */