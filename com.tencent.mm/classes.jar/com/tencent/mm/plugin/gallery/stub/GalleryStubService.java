package com.tencent.mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.h.a.io;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.m.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class GalleryStubService
  extends Service
{
  private a.a kHy = new a.a()
  {
    private int dmY;
    
    public final int Ag()
    {
      return b.Ag();
    }
    
    public final int Ah()
    {
      return b.Ah();
    }
    
    public final int Aj()
    {
      return b.Aj();
    }
    
    public final int Es(String paramAnonymousString)
    {
      PInt localPInt = new PInt();
      u.a(paramAnonymousString, localPInt, new PInt());
      return localPInt.value;
    }
    
    public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean1, int paramAnonymousInt, boolean paramAnonymousBoolean2)
    {
      if (a.udP != null)
      {
        io localio = new io();
        localio.bQL.bQM = Boolean.valueOf(paramAnonymousBoolean1);
        localio.bQL.imagePath = paramAnonymousString1;
        localio.bQL.bQN = paramAnonymousInt;
        localio.bQL.toUser = paramAnonymousString2;
        localio.bQL.bQO = Boolean.valueOf(paramAnonymousBoolean2);
        a.udP.m(localio);
      }
    }
    
    public final void aXH()
    {
      g.wJ(19);
    }
    
    public final int aXI()
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcAlbumScrollEnable, this.dmY);
      boolean bool = WXHardCoderJNI.hcAlbumScrollEnable;
      int j = WXHardCoderJNI.hcAlbumScrollDelay;
      int k = WXHardCoderJNI.hcAlbumScrollCPU;
      int m = WXHardCoderJNI.hcAlbumScrollIO;
      if (WXHardCoderJNI.hcAlbumScrollThr) {}
      for (int i = Process.myTid();; i = 0) {
        return WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.GalleryStubService");
      }
    }
    
    public final void aq(int paramAnonymousInt, String paramAnonymousString)
    {
      h.nFQ.aC(paramAnonymousInt, paramAnonymousString);
    }
    
    public final boolean gp(boolean paramAnonymousBoolean)
    {
      au.Hx();
      return c.Dz().getBoolean(ac.a.uuF, paramAnonymousBoolean);
    }
    
    public final int rQ(int paramAnonymousInt)
    {
      paramAnonymousInt = WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcAlbumScrollEnable, this.dmY);
      this.dmY = 0;
      return paramAnonymousInt;
    }
  };
  
  public IBinder onBind(Intent paramIntent)
  {
    y.d("MicroMsg.GalleryStubService", "on bind, intent[%s]", new Object[] { paramIntent });
    return this.kHy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.stub.GalleryStubService
 * JD-Core Version:    0.7.0.1
 */