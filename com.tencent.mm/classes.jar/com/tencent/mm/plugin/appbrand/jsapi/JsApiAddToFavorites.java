package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;

public final class JsApiAddToFavorites
  extends d<c>
{
  public static final int CTRL_INDEX = 800;
  public static final String NAME = "addToFavorites";
  
  private static void a(c.a parama, ac paramac, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(226666);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        Log.i("MicroMsg.JsApiAddToFavorites", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramac.getAppId(), Integer.valueOf(paramac.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        parama.Wz(paramString);
      }
      for (;;)
      {
        return;
        Log.w("MicroMsg.JsApiAddToFavorites", "snapshot can not be taken");
        parama.Wz("");
      }
      AppMethodBeat.o(226666);
    }
    catch (Exception paramac)
    {
      Log.w("MicroMsg.JsApiAddToFavorites", "save temp bitmap to file failed, . exception : %s", new Object[] { paramac });
      parama.Wz("");
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(226666);
    }
  }
  
  static final class IPCFavRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<IPCFavRequest> CREATOR;
    String appId;
    String dCx;
    String eda;
    int iOo;
    String iconUrl;
    int leb;
    String lyD;
    int lyE;
    boolean lyF;
    int scene;
    int subType;
    String title;
    String username;
    int version;
    
    static
    {
      AppMethodBeat.i(226655);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(226655);
    }
    
    protected IPCFavRequest() {}
    
    protected IPCFavRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(226653);
      this.username = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.dCx = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.iOo = paramParcel.readInt();
      this.title = paramParcel.readString();
      this.lyD = paramParcel.readString();
      this.lyE = paramParcel.readInt();
      this.leb = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.eda = paramParcel.readString();
      this.subType = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lyF = bool;
        AppMethodBeat.o(226653);
        return;
        bool = false;
      }
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bCJ()
    {
      return JsApiAddToFavorites.a.class;
    }
    
    public final boolean bDQ()
    {
      return this.lyF;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(226654);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.dCx);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.iOo);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.lyD);
      paramParcel.writeInt(this.lyE);
      paramParcel.writeInt(this.leb);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.eda);
      paramParcel.writeInt(this.subType);
      if (this.lyF) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(226654);
        return;
      }
    }
  }
  
  static final class IPCFavResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<IPCFavResult> CREATOR;
    int ret;
    
    static
    {
      AppMethodBeat.i(226660);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(226660);
    }
    
    protected IPCFavResult() {}
    
    protected IPCFavResult(Parcel paramParcel)
    {
      AppMethodBeat.i(226657);
      k(paramParcel);
      AppMethodBeat.o(226657);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      AppMethodBeat.i(226658);
      this.ret = paramParcel.readInt();
      AppMethodBeat.o(226658);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(226659);
      paramParcel.writeInt(this.ret);
      AppMethodBeat.o(226659);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(226663);
      paramProcessRequest = (JsApiAddToFavorites.IPCFavRequest)paramProcessRequest;
      Object localObject = new aml();
      ((aml)localObject).ajd(19);
      ((aml)localObject).bgu(paramProcessRequest.lyD);
      if (Util.isNullOrNil(paramProcessRequest.lyD)) {
        ((aml)localObject).At(true);
      }
      ((aml)localObject).bgt(paramProcessRequest.lyD);
      ((aml)localObject).bgf(paramProcessRequest.title);
      ((aml)localObject).bgg(paramProcessRequest.title);
      ((aml)localObject).bgs(b.ds(localObject.toString(), 19));
      anh localanh = new anh();
      localanh.bhf(z.aTY());
      localanh.MA(Util.nowMilliSecond());
      localanh.ajm(paramProcessRequest.scene);
      amj localamj = new amj();
      localamj.appId = paramProcessRequest.appId;
      localamj.iconUrl = paramProcessRequest.iconUrl;
      localamj.dCx = paramProcessRequest.dCx;
      localamj.dMe = paramProcessRequest.iOo;
      localamj.version = paramProcessRequest.version;
      localamj.username = paramProcessRequest.username;
      localamj.lyE = paramProcessRequest.lyE;
      localamj.leb = paramProcessRequest.leb;
      localamj.eda = paramProcessRequest.eda;
      localamj.subType = paramProcessRequest.subType;
      anb localanb = new anb();
      localanb.ppH.add(localObject);
      localanb.c(localamj);
      localanb.a(localanh);
      localObject = new cz();
      localanb.bhd(paramProcessRequest.title);
      ((cz)localObject).dFZ.desc = paramProcessRequest.title;
      ((cz)localObject).dFZ.title = paramProcessRequest.title;
      ((cz)localObject).dFZ.dGb = localanb;
      ((cz)localObject).dFZ.type = 19;
      EventCenter.instance.publish((IEvent)localObject);
      int i = ((cz)localObject).dGa.ret;
      paramProcessRequest = new JsApiAddToFavorites.IPCFavResult();
      paramProcessRequest.ret = i;
      Log.i("MicroMsg.JsApiAddToFavorites", "fav result:%d", new Object[] { Integer.valueOf(i) });
      e.a(i, bDF(), new a.c()
      {
        public final void bDY() {}
        
        public final void onHide()
        {
          AppMethodBeat.i(226661);
          JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this, paramProcessRequest);
          AppMethodBeat.o(226661);
        }
        
        public final void onShow() {}
      }, null, new a.b()
      {
        public final void bDZ()
        {
          AppMethodBeat.i(226662);
          hb localhb = new hb();
          localhb.dLm.type = 35;
          localhb.dLm.context = JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this);
          EventCenter.instance.publish(localhb);
          AppMethodBeat.o(226662);
        }
      });
      AppMethodBeat.o(226663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites
 * JD-Core Version:    0.7.0.1
 */