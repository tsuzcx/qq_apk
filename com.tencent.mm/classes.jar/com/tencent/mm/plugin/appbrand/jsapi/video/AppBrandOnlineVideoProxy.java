package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class AppBrandOnlineVideoProxy
  implements com.tencent.mm.modelvideo.b
{
  private OnlineVideoProxy ibK;
  private b.a ibL;
  
  public final void a(b.a parama)
  {
    this.ibL = parama;
    if (this.ibK != null) {
      this.ibK.ibY = parama;
    }
  }
  
  public final void er(String paramString)
  {
    AppMethodBeat.i(131518);
    ab.i("MicroMsg.AppBrandOnlineVideoProxy", "%s stop http stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.ibK != null)
    {
      this.ibK.ibY = null;
      paramString = this.ibK;
      paramString.ibP = 4;
      AppBrandMainProcessService.a(paramString);
      this.ibK.aBk();
    }
    this.ibK = null;
    AppMethodBeat.o(131518);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131520);
    if (this.ibK == null)
    {
      AppMethodBeat.o(131520);
      return false;
    }
    paramString = this.ibK;
    paramString.offset = paramInt1;
    paramString.length = paramInt2;
    paramString.ibP = 3;
    AppBrandMainProcessService.b(paramString);
    boolean bool = paramString.ibV;
    AppMethodBeat.o(131520);
    return bool;
  }
  
  public final void r(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131517);
    ab.i("MicroMsg.AppBrandOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3 });
    if (this.ibK == null)
    {
      this.ibK = new OnlineVideoProxy();
      this.ibK.ibY = this.ibL;
      this.ibK.aBj();
    }
    OnlineVideoProxy localOnlineVideoProxy = this.ibK;
    ab.i("MicroMsg.AppBrandOnlineVideoProxy", "%s OnlineVideoProxy start http stream[%s %s %s] ", new Object[] { Integer.valueOf(localOnlineVideoProxy.hashCode()), paramString1, paramString2, paramString3 });
    localOnlineVideoProxy.fVf = paramString1;
    localOnlineVideoProxy.path = paramString2;
    localOnlineVideoProxy.url = paramString3;
    localOnlineVideoProxy.ibP = 1;
    AppBrandMainProcessService.a(localOnlineVideoProxy);
    AppMethodBeat.o(131517);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131519);
    ab.i("MicroMsg.AppBrandOnlineVideoProxy", "%s requestVideoData [%s, %d %d]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ibK != null)
    {
      paramString = this.ibK;
      paramString.offset = paramInt1;
      paramString.length = paramInt2;
      paramString.ibP = 2;
      AppBrandMainProcessService.a(paramString);
    }
    AppMethodBeat.o(131519);
  }
  
  static class OnlineVideoProxy
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OnlineVideoProxy> CREATOR;
    final int START;
    final int STOP;
    String fVf;
    final int ibM;
    final int ibN;
    final int ibO;
    int ibP;
    final int ibQ;
    final int ibR;
    final int ibS;
    final int ibT;
    int ibU;
    boolean ibV;
    int ibW;
    int ibX;
    b.a ibY;
    d.c ibZ;
    int length;
    int offset;
    String path;
    String url;
    
    static
    {
      AppMethodBeat.i(131516);
      CREATOR = new AppBrandOnlineVideoProxy.OnlineVideoProxy.2();
      AppMethodBeat.o(131516);
    }
    
    public OnlineVideoProxy()
    {
      AppMethodBeat.i(131506);
      this.ibM = 0;
      this.START = 1;
      this.ibN = 2;
      this.ibO = 3;
      this.STOP = 4;
      this.ibQ = 10;
      this.ibR = 11;
      this.ibS = 12;
      this.ibT = 13;
      this.ibV = false;
      this.ibZ = new AppBrandOnlineVideoProxy.OnlineVideoProxy.1(this);
      AppMethodBeat.o(131506);
    }
    
    public OnlineVideoProxy(Parcel paramParcel)
    {
      AppMethodBeat.i(131507);
      this.ibM = 0;
      this.START = 1;
      this.ibN = 2;
      this.ibO = 3;
      this.STOP = 4;
      this.ibQ = 10;
      this.ibR = 11;
      this.ibS = 12;
      this.ibT = 13;
      this.ibV = false;
      this.ibZ = new AppBrandOnlineVideoProxy.OnlineVideoProxy.1(this);
      f(paramParcel);
      AppMethodBeat.o(131507);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(131509);
      ab.d("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess cdnMediaId[%s] state[%d]", new Object[] { this.fVf, Integer.valueOf(this.ibP) });
      switch (this.ibP)
      {
      default: 
        ab.w("MicroMsg.AppBrandOnlineVideoProxy", "unknow state ");
      case 1: 
      case 4: 
      case 2: 
        for (;;)
        {
          this.ibP = 0;
          ab.i("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess reset mainState[%d] ", new Object[] { Integer.valueOf(this.ibP) });
          aBp();
          AppMethodBeat.o(131509);
          return;
          localObject1 = g.auP();
          String str1 = this.fVf;
          Object localObject2 = this.ibZ;
          ((com.tencent.mm.plugin.appbrand.c.b)localObject1).hgr.put(str1, localObject2);
          localObject1 = g.auP();
          str1 = this.fVf;
          localObject2 = this.url;
          String str2 = this.path;
          ab.i("MicroMsg.AppbrandCdnService", "add online video task [%s] url[%s] path[%s]", new Object[] { str1, localObject2, str2 });
          h localh = new h();
          localh.field_mediaId = str1;
          localh.field_fullpath = str2;
          localh.url = ((String)localObject2);
          localh.edQ = ((com.tencent.mm.plugin.appbrand.c.b)localObject1).hgs;
          localh.edJ = 1;
          localh.edE = 4;
          o.alF().a(localh, false);
          continue;
          g.auP().zF(this.fVf);
          g.auP();
          localObject1 = this.fVf;
          ab.i("MicroMsg.AppbrandCdnService", "cancel online video task [%s]", new Object[] { localObject1 });
          o.alF().j((String)localObject1, null);
          continue;
          g.auP();
          localObject1 = this.fVf;
          i = this.offset;
          j = this.length;
          ab.i("MicroMsg.AppbrandCdnService", "request online video task [%s]", new Object[] { localObject1 });
          o.alF();
          e.r((String)localObject1, i, j);
        }
      }
      g.auP();
      Object localObject1 = this.fVf;
      int i = this.offset;
      int j = this.length;
      ab.i("MicroMsg.AppbrandCdnService", "check online video task [%s]", new Object[] { localObject1 });
      this.ibV = o.alF().isVideoDataAvailable((String)localObject1, i, j);
      aBp();
      AppMethodBeat.o(131509);
    }
    
    public final void atb()
    {
      AppMethodBeat.i(131508);
      ab.d("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess cdnMediaId[%s] clientState[%d] [%d %d]", new Object[] { this.fVf, Integer.valueOf(this.ibU), Integer.valueOf(this.ibW), Integer.valueOf(this.ibX) });
      if (this.ibY == null)
      {
        AppMethodBeat.o(131508);
        return;
      }
      switch (this.ibU)
      {
      }
      for (;;)
      {
        this.ibU = 0;
        ab.i("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess reset clientState[%d] ", new Object[] { Integer.valueOf(this.ibU) });
        AppMethodBeat.o(131508);
        return;
        this.ibY.mi(this.ibW);
        continue;
        this.ibY.m(this.fVf, this.ibW, this.ibX);
        continue;
        this.ibY.n(this.fVf, this.ibW, this.ibX);
        continue;
        this.ibY.ad(this.fVf, this.ibW);
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(131510);
      this.fVf = paramParcel.readString();
      this.ibP = paramParcel.readInt();
      this.path = paramParcel.readString();
      this.url = paramParcel.readString();
      this.offset = paramParcel.readInt();
      this.length = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ibV = bool;
        this.ibU = paramParcel.readInt();
        this.ibW = paramParcel.readInt();
        this.ibX = paramParcel.readInt();
        AppMethodBeat.o(131510);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(131511);
      paramParcel.writeString(this.fVf);
      paramParcel.writeInt(this.ibP);
      paramParcel.writeString(this.path);
      paramParcel.writeString(this.url);
      paramParcel.writeInt(this.offset);
      paramParcel.writeInt(this.length);
      if (this.ibV) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.ibU);
        paramParcel.writeInt(this.ibW);
        paramParcel.writeInt(this.ibX);
        AppMethodBeat.o(131511);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy
 * JD-Core Version:    0.7.0.1
 */