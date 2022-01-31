package com.tencent.mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.m.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class GalleryStubService
  extends Service
{
  private a.a ndI;
  
  public GalleryStubService()
  {
    AppMethodBeat.i(21349);
    this.ndI = new a.a()
    {
      public final int MV()
      {
        AppMethodBeat.i(21346);
        int i = b.MV();
        AppMethodBeat.o(21346);
        return i;
      }
      
      public final int MW()
      {
        AppMethodBeat.i(21345);
        int i = b.MW();
        AppMethodBeat.o(21345);
        return i;
      }
      
      public final int MY()
      {
        AppMethodBeat.i(21344);
        int i = b.MY();
        AppMethodBeat.o(21344);
        return i;
      }
      
      public final int PD(String paramAnonymousString)
      {
        AppMethodBeat.i(21348);
        PInt localPInt = new PInt();
        u.a(paramAnonymousString, localPInt, new PInt());
        int i = localPInt.value;
        AppMethodBeat.o(21348);
        return i;
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean1, int paramAnonymousInt, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(21342);
        if (a.ymk != null)
        {
          iv localiv = new iv();
          localiv.cyl.cym = Boolean.valueOf(paramAnonymousBoolean1);
          localiv.cyl.imagePath = paramAnonymousString1;
          localiv.cyl.cyn = paramAnonymousInt;
          localiv.cyl.toUser = paramAnonymousString2;
          localiv.cyl.cyo = Boolean.valueOf(paramAnonymousBoolean2);
          a.ymk.l(localiv);
        }
        AppMethodBeat.o(21342);
      }
      
      public final void aK(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(21341);
        h.qsU.kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(21341);
      }
      
      public final void bEm()
      {
        AppMethodBeat.i(21343);
        com.tencent.mm.plugin.report.service.g.Cy(19);
        AppMethodBeat.o(21343);
      }
      
      public final boolean hT(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(21347);
        paramAnonymousBoolean = com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yEI, paramAnonymousBoolean);
        AppMethodBeat.o(21347);
        return paramAnonymousBoolean;
      }
    };
    AppMethodBeat.o(21349);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(21350);
    ab.d("MicroMsg.GalleryStubService", "on bind, intent[%s]", new Object[] { paramIntent });
    paramIntent = this.ndI;
    AppMethodBeat.o(21350);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.stub.GalleryStubService
 * JD-Core Version:    0.7.0.1
 */