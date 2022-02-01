package com.tencent.mm.aw.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.j;
import com.tencent.mm.aw.a.c.o;
import com.tencent.mm.aw.a.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  public com.tencent.mm.aw.a.a.b icV;
  j icW;
  private Executor icX;
  public final Map<Integer, String> icY;
  public HashMap<Integer, com.tencent.mm.aw.a.f.b> icZ;
  
  public b(com.tencent.mm.aw.a.a.b paramb)
  {
    AppMethodBeat.i(130366);
    this.icY = Collections.synchronizedMap(new HashMap());
    this.icZ = new HashMap();
    this.icV = paramb;
    this.icW = paramb.idl;
    this.icX = paramb.idm;
    this.icV.idf.a(this.icV.idh);
    AppMethodBeat.o(130366);
  }
  
  private void aqH()
  {
    AppMethodBeat.i(130371);
    if (this.icV.idl.isShutdown()) {
      this.icW = com.tencent.mm.aw.a.a.a.pE(this.icV.idb);
    }
    AppMethodBeat.o(130371);
  }
  
  public final Bitmap FD(String paramString)
  {
    AppMethodBeat.i(130369);
    if (this.icV != null)
    {
      paramString = this.icV.ide.vT(paramString);
      AppMethodBeat.o(130369);
      return paramString;
    }
    AppMethodBeat.o(130369);
    return null;
  }
  
  public final boolean OI()
  {
    AppMethodBeat.i(130368);
    boolean bool = this.icW.OI();
    AppMethodBeat.o(130368);
    return bool;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(130373);
    this.icY.remove(Integer.valueOf(paramc.heW));
    ad.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.icY.size()), Integer.valueOf(paramc.heW) });
    AppMethodBeat.o(130373);
  }
  
  public final void a(com.tencent.mm.aw.a.f.a parama)
  {
    AppMethodBeat.i(193071);
    this.icW.execute(parama);
    AppMethodBeat.o(193071);
  }
  
  public final void a(com.tencent.mm.aw.a.f.b paramb)
  {
    AppMethodBeat.i(130374);
    if ((this.icZ != null) && (paramb.idZ != null))
    {
      com.tencent.mm.aw.a.f.b localb = (com.tencent.mm.aw.a.f.b)this.icZ.get(Integer.valueOf(paramb.idZ.heW));
      if ((localb != null) && (localb.idZ != null) && (paramb.idZ.heW == localb.idZ.heW))
      {
        this.icW.remove(localb);
        ad.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { localb.url });
      }
      this.icZ.put(Integer.valueOf(paramb.idZ.heW), paramb);
    }
    AppMethodBeat.o(130374);
  }
  
  public final void a(com.tencent.mm.aw.a.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(130367);
    aqH();
    this.icW.execute(paramb);
    if ((paramBoolean) && (com.tencent.mm.aw.a.g.b.aJh())) {
      this.icX.execute(new d());
    }
    AppMethodBeat.o(130367);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(130372);
    if (!bt.isNullOrNil(paramString))
    {
      String str = (String)this.icY.get(Integer.valueOf(paramc.heW));
      if ((bt.isNullOrNil(str)) || (!paramString.equals(str)))
      {
        this.icY.put(Integer.valueOf(paramc.heW), paramString);
        AppMethodBeat.o(130372);
        return true;
      }
    }
    AppMethodBeat.o(130372);
    return false;
  }
  
  public final void aox()
  {
    AppMethodBeat.i(130370);
    if (this.icV != null)
    {
      this.icV.ide.clear();
      this.icV.idf.aJd();
    }
    AppMethodBeat.o(130370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a.b
 * JD-Core Version:    0.7.0.1
 */