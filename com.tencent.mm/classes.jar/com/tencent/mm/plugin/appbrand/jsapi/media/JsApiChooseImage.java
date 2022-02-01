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
import com.tencent.luggage.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage
  extends c
{
  public static final int CTRL_INDEX = 29;
  public static final String NAME = "chooseImage";
  private static Boolean oZS = null;
  
  private static boolean bSW()
  {
    AppMethodBeat.i(284656);
    if (oZS == null)
    {
      Log.i("MicroMsg.JsApiChooseImage", "inti wx style field");
      oZS = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEs, false));
    }
    if (oZS == null)
    {
      Log.e("MicroMsg.JsApiChooseImage", "get shoot style fail, use default style");
      AppMethodBeat.o(284656);
      return false;
    }
    Log.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot, flag: %b", new Object[] { oZS });
    boolean bool = oZS.booleanValue();
    AppMethodBeat.o(284656);
    return bool;
  }
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46425);
    if (parame.getAppId() == null)
    {
      parame.j(paramInt, h("fail", null));
      AppMethodBeat.o(46425);
      return;
    }
    if (com.tencent.mm.plugin.appbrand.s.abV(parame.getAppId()).nwg)
    {
      parame.j(paramInt, h("cancel", null));
      AppMethodBeat.o(46425);
      return;
    }
    final Context localContext = parame.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      parame.j(paramInt, h("fail", null));
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
      localChooseRequest.oZX = true;
      localChooseRequest.oZY = true;
      if (!localChooseRequest.oZX) {
        break label347;
      }
      com.tencent.mm.plugin.appbrand.permission.r.b(parame.getAppId(), new androidx.core.app.a.a()
      {
        public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(268691);
          if (paramAnonymousInt != 113)
          {
            AppMethodBeat.o(268691);
            return;
          }
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            JsApiChooseImage.this.a(parame, paramJSONObject, paramInt);
            AppMethodBeat.o(268691);
            return;
          }
          parame.j(paramInt, JsApiChooseImage.this.h("fail:system permission denied", null));
          AppMethodBeat.o(268691);
        }
      });
      paramJSONObject = parame.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label302;
      }
      parame.j(paramInt, h("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label347;
      }
      AppMethodBeat.o(46425);
      return;
      localChooseRequest.oZX = localJSONArray.toString().contains("camera");
      localChooseRequest.oZY = localJSONArray.toString().contains("album");
      break;
      label302:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
      i = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.r.amk(parame.getAppId());
        i = bool;
      }
    }
    label347:
    com.tencent.mm.plugin.appbrand.s.abW(parame.getAppId()).nwg = true;
    k.a(parame.getAppId(), new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(180217);
        if (parame.getAppId() != null) {
          com.tencent.mm.plugin.appbrand.s.abW(parame.getAppId()).nwg = false;
        }
        k.b(parame.getAppId(), this);
        AppMethodBeat.o(180217);
      }
    });
    if (Util.isNullOrNil(str1)) {}
    for (paramJSONObject = "compressed";; paramJSONObject = str1)
    {
      localChooseRequest.oZZ = paramJSONObject.contains("compressed");
      localChooseRequest.paa = paramJSONObject.contains("original");
      localChooseRequest.count = Util.getInt(str2, 9);
      localChooseRequest.appId = parame.getAppId();
      paramJSONObject = new AppBrandProxyUIProcessTask.b() {};
      if ((localChooseRequest.oZX) && (localChooseRequest.oZY) && (bSW()))
      {
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(278936);
            JsApiChooseImage.a(JsApiChooseImage.this, parame.getContext(), new q.g()new DialogInterface.OnCancelListener
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(278626);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  Log.i("MicroMsg.JsApiChooseImage", "start select after source choose");
                  a.b(JsApiChooseImage.3.this.oSt, JsApiChooseImage.3.this.oZU, JsApiChooseImage.3.this.oZV);
                  AppMethodBeat.o(278626);
                  return;
                  JsApiChooseImage.3.this.oZU.oZY = false;
                  continue;
                  JsApiChooseImage.3.this.oZU.oZX = false;
                }
              }
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(264906);
                Log.i("MicroMsg.JsApiChooseImage", "cancel when select source from");
                com.tencent.mm.plugin.appbrand.s.abW(JsApiChooseImage.3.this.cyJ.getAppId()).nwg = false;
                JsApiChooseImage.3.this.cyJ.j(JsApiChooseImage.3.this.cuf, JsApiChooseImage.this.h("cancel", null));
                AppMethodBeat.o(264906);
              }
            });
            AppMethodBeat.o(278936);
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
    boolean oZX;
    boolean oZY;
    boolean oZZ;
    boolean paa;
    boolean pab;
    
    static
    {
      AppMethodBeat.i(46403);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46403);
    }
    
    ChooseRequest()
    {
      this.pab = true;
    }
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46402);
      this.pab = true;
      k(paramParcel);
      AppMethodBeat.o(46402);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bOe()
    {
      return JsApiChooseImage.a.class;
    }
    
    public final boolean bPn()
    {
      boolean bool = true;
      if (!this.pab)
      {
        this.pab = true;
        bool = false;
      }
      return bool;
    }
    
    public final String bPo()
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
        this.oZX = bool1;
        if (paramParcel.readByte() == 0) {
          break label90;
        }
        bool1 = true;
        label46:
        this.oZY = bool1;
        if (paramParcel.readByte() == 0) {
          break label95;
        }
        bool1 = true;
        label60:
        this.oZZ = bool1;
        if (paramParcel.readByte() == 0) {
          break label100;
        }
      }
      label90:
      label95:
      label100:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.paa = bool1;
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
      if (this.oZX)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.oZY) {
          break label92;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.oZZ) {
          break label97;
        }
        b1 = 1;
        label61:
        paramParcel.writeByte(b1);
        if (!this.paa) {
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
    ArrayList<AppBrandLocalMediaObject> pac;
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
      this.pac = paramParcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
      AppMethodBeat.o(46405);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46406);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeTypedList(this.pac);
      AppMethodBeat.o(46406);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private com.tencent.mm.ui.base.s jhZ;
    double latitude;
    double longitude;
    JsApiChooseImage.ChooseRequest pad;
    JsApiChooseImage.ChooseResult pae;
    final int paf;
    int pag;
    boolean pah;
    boolean pai;
    boolean paj;
    private DialogInterface.OnCancelListener pak;
    
    private a()
    {
      AppMethodBeat.i(46412);
      this.pae = new JsApiChooseImage.ChooseResult();
      this.paf = (hashCode() % 10000);
      AppMethodBeat.o(46412);
    }
    
    private void AD(int paramInt)
    {
      AppMethodBeat.i(46414);
      this.pak = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(249422);
          JsApiChooseImage.a.this.pae.resultCode = 0;
          JsApiChooseImage.a.a(JsApiChooseImage.a.this, JsApiChooseImage.a.this.pae);
          AppMethodBeat.o(249422);
        }
      };
      MMActivity localMMActivity = bPf();
      int i = au.i.app_tip;
      MMApplicationContext.getResources().getString(i);
      this.jhZ = com.tencent.mm.ui.base.h.a(localMMActivity, MMApplicationContext.getResources().getString(paramInt), true, this.pak);
      AppMethodBeat.o(46414);
    }
    
    private void aVe()
    {
      AppMethodBeat.i(180231);
      if ((!bSY()) && (!this.pah))
      {
        Log.i("MicroMsg.JsApiChooseImage", "requestLocationPermission fail, abort");
        AppMethodBeat.o(180231);
        return;
      }
      m.clV().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46410);
          if (JsApiChooseImage.a.this.pai) {
            JsApiChooseImage.a.a(JsApiChooseImage.a.this);
          }
          Object localObject = GetSightParamsIPCTask.oZP;
          localObject = GetSightParamsIPCTask.a.q(2, 0, false);
          ((SightParams)localObject).EYq = false;
          Intent localIntent = new Intent();
          localIntent.setClassName(JsApiChooseImage.a.b(JsApiChooseImage.a.this), "com.tencent.mm.plugin.mmsight.ui.SightCaptureUI");
          localIntent.putExtra("KEY_SIGHT_PARAMS", (Parcelable)localObject);
          JsApiChooseImage.a.a(JsApiChooseImage.a.this, localIntent);
          AppMethodBeat.o(46410);
        }
      });
      AppMethodBeat.o(180231);
    }
    
    private boolean bSY()
    {
      AppMethodBeat.i(180229);
      MMActivity localMMActivity = bPf();
      if (localMMActivity == null)
      {
        Log.e("MicroMsg.JsApiChooseImage", "requestLocationPermission, pageContext is null");
        AppMethodBeat.o(180229);
        return false;
      }
      if (i.o(localMMActivity, "android.permission.ACCESS_FINE_LOCATION"))
      {
        this.pai = true;
        AppMethodBeat.o(180229);
        return true;
      }
      if (this.pah)
      {
        AppMethodBeat.o(180229);
        return false;
      }
      if (this.pad != null) {
        this.pad.pab = false;
      }
      boolean bool = i.a(localMMActivity, "android.permission.ACCESS_FINE_LOCATION", this.paf, null, null);
      AppMethodBeat.o(180229);
      return bool;
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46413);
      this.pad = ((JsApiChooseImage.ChooseRequest)paramProcessRequest);
      this.pad.pab = true;
      this.pad.count = Math.max(1, Math.min(9, this.pad.count));
      this.pag = 16;
      int i;
      if (Util.getAvailableMemoryMB(bPf()) > 200L)
      {
        i = 1;
        if (i == 0)
        {
          paramProcessRequest = bPf();
          i = au.i.app_brand_choose_media_memory_check_message;
          w.makeText(paramProcessRequest, MMApplicationContext.getResources().getString(i), 1).show();
        }
        this.paj = JsApiChooseImage.bSX();
        Log.i("MicroMsg.JsApiChooseImage", "isWxStyleShoot: %b", new Object[] { Boolean.valueOf(this.paj) });
        bPf().mmSetOnActivityResultCallback(this);
        paramProcessRequest = new Intent();
        if (this.pad.oZZ) {
          break label308;
        }
        bool = true;
        label151:
        paramProcessRequest.putExtra("key_send_raw_image", bool);
        paramProcessRequest.putExtra("key_force_show_raw_image_button", this.pad.paa);
        if ((!this.pad.paa) || (this.pad.oZZ)) {
          break label313;
        }
      }
      label308:
      label313:
      for (boolean bool = true;; bool = false)
      {
        paramProcessRequest.putExtra("key_is_raw_image_button_disable", bool);
        paramProcessRequest.putExtra("query_media_type", 1);
        paramProcessRequest.putExtra("key_force_hide_edit_image_button_after_album_take_image", true);
        paramProcessRequest.putExtra("album_business_tag", "album_business_bubble_media_by_jsapi_chooseimage");
        paramProcessRequest.putExtra("gallery_report_tag", 16);
        if ((!this.pad.oZX) || (!this.pad.oZY)) {
          break label344;
        }
        if (!this.paj) {
          break label318;
        }
        Log.e("MicroMsg.JsApiChooseImage", "illegal scene, ignore this request");
        this.pae.resultCode = -2;
        b(this.pae);
        AppMethodBeat.o(46413);
        return;
        i = 0;
        break;
        bool = false;
        break label151;
      }
      label318:
      u.a(bPf(), 1, this.pad.count, this.pag, paramProcessRequest);
      AppMethodBeat.o(46413);
      return;
      label344:
      if (this.pad.oZY)
      {
        paramProcessRequest.putExtra("show_header_view", false);
        u.a(bPf(), 1, this.pad.count, this.pag, paramProcessRequest);
        AppMethodBeat.o(46413);
        return;
      }
      if (this.pad.oZX)
      {
        if (this.paj)
        {
          aVe();
          AppMethodBeat.o(46413);
          return;
        }
        u.d(bPf(), com.tencent.mm.loader.j.b.aSX(), "microMsg." + System.currentTimeMillis() + ".jpg", 2);
        AppMethodBeat.o(46413);
        return;
      }
      Log.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
      this.pae.resultCode = -2;
      b(this.pae);
      AppMethodBeat.o(46413);
    }
    
    public final void bPm()
    {
      AppMethodBeat.i(46417);
      super.bPm();
      if (this.jhZ != null)
      {
        this.jhZ.dismiss();
        this.jhZ = null;
      }
      AppMethodBeat.o(46417);
    }
    
    public final void d(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      AppMethodBeat.i(46418);
      if (paramInt2 == 0)
      {
        this.pae.resultCode = 0;
        b(this.pae);
        AppMethodBeat.o(46418);
        return;
      }
      switch (paramInt1)
      {
      default: 
        this.pae.resultCode = -2;
        b(this.pae);
        AppMethodBeat.o(46418);
        return;
      case 1: 
      case 3: 
        if (paramIntent == null)
        {
          this.pae.resultCode = 0;
          b(this.pae);
          AppMethodBeat.o(46418);
          return;
        }
        final ArrayList localArrayList = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
        final int i = this.pad.oZZ;
        label182:
        final boolean bool1;
        if (!this.pad.paa)
        {
          paramInt1 = 1;
          if (((paramInt1 & i) == 0) && (!(this.pad.oZZ & this.pad.paa & bool2))) {
            break label344;
          }
          i = 1;
          if ((!paramIntent.getBooleanExtra("isTakePhoto", false)) && (!paramIntent.getBooleanExtra("isPreviewPhoto", false))) {
            break label350;
          }
          bool1 = true;
          label207:
          Log.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.pad.oZZ), Boolean.valueOf(this.pad.paa), Boolean.valueOf(bool2), Boolean.valueOf(i) });
          if (i != 0) {
            AD(au.i.app_brand_choose_media_video_compressing);
          }
          if ((i != 0) || (!r.bC(localArrayList))) {
            break label356;
          }
        }
        label344:
        label350:
        label356:
        for (bool2 = true;; bool2 = false)
        {
          if (bool2) {
            AD(au.i.app_brand_jsapi_choose_image_processing);
          }
          m.clV().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(270314);
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
                      str = r.ahY((String)localObject2);
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
                      localObject2 = AppBrandLocalMediaObjectManager.h(JsApiChooseImage.a.this.pad.appId, (String)localObject1, bool1);
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
                  str = r.ahZ((String)localObject2);
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
                      AppMethodBeat.i(279241);
                      JsApiChooseImage.a.this.pae.resultCode = -1;
                      JsApiChooseImage.a.this.pae.pac = localArrayList;
                      JsApiChooseImage.a.b(JsApiChooseImage.a.this, JsApiChooseImage.a.this.pae);
                      AppMethodBeat.o(279241);
                    }
                  });
                  AppMethodBeat.o(270314);
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
      if (this.paj)
      {
        if (paramIntent == null)
        {
          this.pae.resultCode = 0;
          b(this.pae);
          AppMethodBeat.o(46418);
          return;
        }
        paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
        if (paramIntent == null)
        {
          this.pae.resultCode = 0;
          b(this.pae);
          AppMethodBeat.o(46418);
          return;
        }
      }
      for (paramIntent = paramIntent.EYh; Util.isNullOrNil(paramIntent); paramIntent = u.g(bPf().getApplicationContext(), paramIntent, com.tencent.mm.loader.j.b.aSX()))
      {
        Log.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
        this.pae.resultCode = -2;
        b(this.pae);
        AppMethodBeat.o(46418);
        return;
      }
      if ((bPf() != null) && (bPf().getWindow() != null)) {
        bPf().getWindow().getDecorView().setBackgroundColor(-16777216);
      }
      m.clV().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278464);
          try
          {
            com.tencent.mm.plugin.appbrand.l.b.a(paramIntent, JsApiChooseImage.a.this.latitude, JsApiChooseImage.a.this.longitude, System.currentTimeMillis());
            Log.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[] { paramIntent });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                boolean bool2 = false;
                AppMethodBeat.i(282427);
                Intent localIntent = new Intent();
                if (!JsApiChooseImage.a.this.pad.oZZ) {}
                for (boolean bool1 = true;; bool1 = false)
                {
                  localIntent.putExtra("key_send_raw_image", bool1);
                  localIntent.putExtra("key_force_show_raw_image_button", JsApiChooseImage.a.this.pad.paa);
                  bool1 = bool2;
                  if (JsApiChooseImage.a.this.pad.paa)
                  {
                    bool1 = bool2;
                    if (!JsApiChooseImage.a.this.pad.oZZ) {
                      bool1 = true;
                    }
                  }
                  localIntent.putExtra("key_is_raw_image_button_disable", bool1);
                  localIntent.putExtra("max_select_count", JsApiChooseImage.a.this.pad.count);
                  localIntent.putExtra("query_source_type", JsApiChooseImage.a.this.pag);
                  localIntent.putExtra("isPreviewPhoto", true);
                  localIntent.putExtra("max_select_count", 1);
                  ArrayList localArrayList = new ArrayList(1);
                  localArrayList.add(JsApiChooseImage.a.5.this.val$filePath);
                  localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
                  localIntent.putExtra("preview_image", true);
                  localIntent.putExtra("key_force_hide_edit_image_button", true);
                  localIntent.addFlags(67108864);
                  JsApiChooseImage.a.a(JsApiChooseImage.a.this, "gallery", ".ui.GalleryEntryUI", localIntent);
                  AppMethodBeat.o(282427);
                  return;
                }
              }
            });
            AppMethodBeat.o(278464);
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
        this.pai = true;
      }
      for (;;)
      {
        aVe();
        AppMethodBeat.o(180230);
        return;
        Log.e("MicroMsg.JsApiChooseImage", "SYS_PERM_DENIED");
        this.pah = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage
 * JD-Core Version:    0.7.0.1
 */