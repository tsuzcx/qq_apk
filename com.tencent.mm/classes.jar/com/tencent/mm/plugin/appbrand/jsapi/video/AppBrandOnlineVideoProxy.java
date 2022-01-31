package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.j.g;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class AppBrandOnlineVideoProxy
  implements com.tencent.mm.modelvideo.b
{
  private OnlineVideoProxy gCI;
  private b.a gCJ;
  
  public final void a(b.a parama)
  {
    this.gCJ = parama;
    if (this.gCI != null) {
      this.gCI.gCW = parama;
    }
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    if (this.gCI == null) {
      return false;
    }
    paramString = this.gCI;
    paramString.offset = paramInt1;
    paramString.length = paramInt2;
    paramString.gCN = 3;
    AppBrandMainProcessService.b(paramString);
    return paramString.gCT;
  }
  
  public final void j(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppBrandOnlineVideoProxy", "%s requestVideoData [%s, %d %d]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.gCI != null)
    {
      paramString = this.gCI;
      paramString.offset = paramInt1;
      paramString.length = paramInt2;
      paramString.gCN = 2;
      AppBrandMainProcessService.a(paramString);
    }
  }
  
  public final void nF(String paramString)
  {
    y.i("MicroMsg.AppBrandOnlineVideoProxy", "%s stop http stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.gCI != null)
    {
      this.gCI.gCW = null;
      paramString = this.gCI;
      paramString.gCN = 4;
      AppBrandMainProcessService.a(paramString);
      this.gCI.ahD();
    }
    this.gCI = null;
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.AppBrandOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3 });
    if (this.gCI == null)
    {
      this.gCI = new OnlineVideoProxy();
      this.gCI.gCW = this.gCJ;
      this.gCI.ahC();
    }
    OnlineVideoProxy localOnlineVideoProxy = this.gCI;
    y.i("MicroMsg.AppBrandOnlineVideoProxy", "%s OnlineVideoProxy start http stream[%s %s %s] ", new Object[] { Integer.valueOf(localOnlineVideoProxy.hashCode()), paramString1, paramString2, paramString3 });
    localOnlineVideoProxy.eFo = paramString1;
    localOnlineVideoProxy.path = paramString2;
    localOnlineVideoProxy.url = paramString3;
    localOnlineVideoProxy.gCN = 1;
    AppBrandMainProcessService.a(localOnlineVideoProxy);
  }
  
  private static class OnlineVideoProxy
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OnlineVideoProxy> CREATOR = new AppBrandOnlineVideoProxy.OnlineVideoProxy.2();
    final int START = 1;
    final int STOP = 4;
    String eFo;
    final int gCK = 0;
    final int gCL = 2;
    final int gCM = 3;
    int gCN;
    final int gCO = 10;
    final int gCP = 11;
    final int gCQ = 12;
    final int gCR = 13;
    int gCS;
    boolean gCT = false;
    int gCU;
    int gCV;
    b.a gCW;
    d.c gCX = new AppBrandOnlineVideoProxy.OnlineVideoProxy.1(this);
    int length;
    int offset;
    String path;
    String url;
    
    public OnlineVideoProxy() {}
    
    public OnlineVideoProxy(Parcel paramParcel)
    {
      e(paramParcel);
    }
    
    public final void Zu()
    {
      y.d("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess cdnMediaId[%s] state[%d]", new Object[] { this.eFo, Integer.valueOf(this.gCN) });
      switch (this.gCN)
      {
      default: 
        y.w("MicroMsg.AppBrandOnlineVideoProxy", "unknow state ");
      case 1: 
      case 4: 
      case 2: 
        for (;;)
        {
          this.gCN = 0;
          y.i("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess reset mainState[%d] ", new Object[] { Integer.valueOf(this.gCN) });
          ahI();
          return;
          localObject1 = com.tencent.mm.plugin.appbrand.app.e.abe();
          String str1 = this.eFo;
          Object localObject2 = this.gCX;
          ((com.tencent.mm.plugin.appbrand.c.b)localObject1).fNh.put(str1, localObject2);
          localObject1 = com.tencent.mm.plugin.appbrand.app.e.abe();
          str1 = this.eFo;
          localObject2 = this.url;
          String str2 = this.path;
          y.i("MicroMsg.AppbrandCdnService", "add online video task [%s] url[%s] path[%s]", new Object[] { str1, localObject2, str2 });
          g localg = new g();
          localg.field_mediaId = str1;
          localg.field_fullpath = str2;
          localg.url = ((String)localObject2);
          localg.dmn = ((com.tencent.mm.plugin.appbrand.c.b)localObject1).fNi;
          localg.dmg = 1;
          localg.dmb = 3;
          o.Ss().a(localg, false);
          continue;
          com.tencent.mm.plugin.appbrand.app.e.abe().rP(this.eFo);
          com.tencent.mm.plugin.appbrand.app.e.abe();
          localObject1 = this.eFo;
          y.i("MicroMsg.AppbrandCdnService", "cancel online video task [%s]", new Object[] { localObject1 });
          o.Ss().k((String)localObject1, null);
          continue;
          com.tencent.mm.plugin.appbrand.app.e.abe();
          localObject1 = this.eFo;
          i = this.offset;
          j = this.length;
          y.i("MicroMsg.AppbrandCdnService", "request online video task [%s]", new Object[] { localObject1 });
          o.Ss();
          com.tencent.mm.ak.e.h((String)localObject1, i, j);
        }
      }
      com.tencent.mm.plugin.appbrand.app.e.abe();
      Object localObject1 = this.eFo;
      int i = this.offset;
      int j = this.length;
      y.i("MicroMsg.AppbrandCdnService", "check online video task [%s]", new Object[] { localObject1 });
      this.gCT = o.Ss().isVideoDataAvailable((String)localObject1, i, j);
      ahI();
    }
    
    public final void Zv()
    {
      y.d("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess cdnMediaId[%s] clientState[%d] [%d %d]", new Object[] { this.eFo, Integer.valueOf(this.gCS), Integer.valueOf(this.gCU), Integer.valueOf(this.gCV) });
      if (this.gCW == null) {
        return;
      }
      switch (this.gCS)
      {
      }
      for (;;)
      {
        this.gCS = 0;
        y.i("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess reset clientState[%d] ", new Object[] { Integer.valueOf(this.gCS) });
        return;
        this.gCW.jq(this.gCU);
        continue;
        this.gCW.onDataAvailable(this.eFo, this.gCU, this.gCV);
        continue;
        this.gCW.e(this.eFo, this.gCU, this.gCV);
        continue;
        this.gCW.V(this.eFo, this.gCU);
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      this.eFo = paramParcel.readString();
      this.gCN = paramParcel.readInt();
      this.path = paramParcel.readString();
      this.url = paramParcel.readString();
      this.offset = paramParcel.readInt();
      this.length = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.gCT = bool;
        this.gCS = paramParcel.readInt();
        this.gCU = paramParcel.readInt();
        this.gCV = paramParcel.readInt();
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.eFo);
      paramParcel.writeInt(this.gCN);
      paramParcel.writeString(this.path);
      paramParcel.writeString(this.url);
      paramParcel.writeInt(this.offset);
      paramParcel.writeInt(this.length);
      if (this.gCT) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.gCS);
        paramParcel.writeInt(this.gCU);
        paramParcel.writeInt(this.gCV);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy
 * JD-Core Version:    0.7.0.1
 */