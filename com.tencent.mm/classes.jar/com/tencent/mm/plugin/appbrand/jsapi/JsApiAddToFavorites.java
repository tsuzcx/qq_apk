package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;

public final class JsApiAddToFavorites
  extends a<c>
{
  public static final int CTRL_INDEX = 800;
  public static final String NAME = "addToFavorites";
  
  private static void a(b.a parama, aa paramaa, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(195798);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        ad.i("MicroMsg.JsApiAddToFavorites", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramaa.getAppId(), Integer.valueOf(paramaa.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        parama.Fn(paramString);
      }
      for (;;)
      {
        return;
        ad.w("MicroMsg.JsApiAddToFavorites", "snapshot can not be taken");
        parama.Fn("");
      }
      AppMethodBeat.o(195798);
    }
    catch (Exception paramaa)
    {
      ad.w("MicroMsg.JsApiAddToFavorites", "save temp bitmap to file failed, . exception : %s", new Object[] { paramaa });
      parama.Fn("");
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(195798);
    }
  }
  
  static final class IPCFavRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<IPCFavRequest> CREATOR;
    String appId;
    int cfU;
    String dbu;
    String dzY;
    int gXn;
    String iconUrl;
    String jwA;
    int jwB;
    boolean jwC;
    int scene;
    int subType;
    String title;
    String username;
    int version;
    
    static
    {
      AppMethodBeat.i(195787);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195787);
    }
    
    protected IPCFavRequest() {}
    
    protected IPCFavRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(195785);
      this.username = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.dbu = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.gXn = paramParcel.readInt();
      this.title = paramParcel.readString();
      this.jwA = paramParcel.readString();
      this.jwB = paramParcel.readInt();
      this.cfU = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.dzY = paramParcel.readString();
      this.subType = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jwC = bool;
        AppMethodBeat.o(195785);
        return;
        bool = false;
      }
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> aWl()
    {
      return JsApiAddToFavorites.a.class;
    }
    
    public final boolean aXt()
    {
      return this.jwC;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195786);
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.dbu);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeInt(this.version);
      paramParcel.writeInt(this.gXn);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.jwA);
      paramParcel.writeInt(this.jwB);
      paramParcel.writeInt(this.cfU);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.dzY);
      paramParcel.writeInt(this.subType);
      if (this.jwC) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(195786);
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
      AppMethodBeat.i(195792);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195792);
    }
    
    protected IPCFavResult() {}
    
    protected IPCFavResult(Parcel paramParcel)
    {
      AppMethodBeat.i(195789);
      j(paramParcel);
      AppMethodBeat.o(195789);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(195790);
      this.ret = paramParcel.readInt();
      AppMethodBeat.o(195790);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195791);
      paramParcel.writeInt(this.ret);
      AppMethodBeat.o(195791);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(195795);
      paramProcessRequest = (JsApiAddToFavorites.IPCFavRequest)paramProcessRequest;
      Object localObject = new afy();
      ((afy)localObject).VD(19);
      ((afy)localObject).aDA(paramProcessRequest.jwA);
      if (bt.isNullOrNil(paramProcessRequest.jwA)) {
        ((afy)localObject).ux(true);
      }
      ((afy)localObject).aDz(paramProcessRequest.jwA);
      ((afy)localObject).aDl(paramProcessRequest.title);
      ((afy)localObject).aDm(paramProcessRequest.title);
      ((afy)localObject).aDy(com.tencent.mm.plugin.fav.a.b.cT(localObject.toString(), 19));
      agu localagu = new agu();
      localagu.aEl(u.aqG());
      localagu.vv(bt.eGO());
      localagu.VM(paramProcessRequest.scene);
      afw localafw = new afw();
      localafw.appId = paramProcessRequest.appId;
      localafw.iconUrl = paramProcessRequest.iconUrl;
      localafw.dbu = paramProcessRequest.dbu;
      localafw.dkC = paramProcessRequest.gXn;
      localafw.version = paramProcessRequest.version;
      localafw.username = paramProcessRequest.username;
      localafw.jwB = paramProcessRequest.jwB;
      localafw.cfU = paramProcessRequest.cfU;
      localafw.dzY = paramProcessRequest.dzY;
      localafw.subType = paramProcessRequest.subType;
      ago localago = new ago();
      localago.mVb.add(localObject);
      localago.c(localafw);
      localago.a(localagu);
      localObject = new cs();
      localago.aEj(paramProcessRequest.title);
      ((cs)localObject).deQ.desc = paramProcessRequest.title;
      ((cs)localObject).deQ.title = paramProcessRequest.title;
      ((cs)localObject).deQ.deS = localago;
      ((cs)localObject).deQ.type = 19;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      int i = ((cs)localObject).deR.ret;
      paramProcessRequest = new JsApiAddToFavorites.IPCFavResult();
      paramProcessRequest.ret = i;
      ad.i("MicroMsg.JsApiAddToFavorites", "fav result:%d", new Object[] { Integer.valueOf(i) });
      e.a(-1, i, aXi(), null, new a.c()
      {
        public final void aXN() {}
        
        public final void onHide()
        {
          AppMethodBeat.i(195793);
          JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this, paramProcessRequest);
          AppMethodBeat.o(195793);
        }
        
        public final void onShow() {}
      }, null, new a.b()
      {
        public final void aXO()
        {
          AppMethodBeat.i(195794);
          gs localgs = new gs();
          localgs.dkc.type = 35;
          localgs.dkc.context = JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this);
          com.tencent.mm.sdk.b.a.ESL.l(localgs);
          AppMethodBeat.o(195794);
        }
      });
      AppMethodBeat.o(195795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites
 * JD-Core Version:    0.7.0.1
 */