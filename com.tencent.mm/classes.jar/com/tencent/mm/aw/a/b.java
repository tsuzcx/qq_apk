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
  private Executor hjA;
  public final Map<Integer, String> hjB;
  public HashMap<Integer, com.tencent.mm.aw.a.f.b> hjC;
  public com.tencent.mm.aw.a.a.b hjy;
  j hjz;
  
  public b(com.tencent.mm.aw.a.a.b paramb)
  {
    AppMethodBeat.i(130366);
    this.hjB = Collections.synchronizedMap(new HashMap());
    this.hjC = new HashMap();
    this.hjy = paramb;
    this.hjz = paramb.hjO;
    this.hjA = paramb.hjP;
    this.hjy.hjI.a(this.hjy.hjK);
    AppMethodBeat.o(130366);
  }
  
  private void agU()
  {
    AppMethodBeat.i(130371);
    if (this.hjy.hjO.isShutdown()) {
      this.hjz = com.tencent.mm.aw.a.a.a.on(this.hjy.hjE);
    }
    AppMethodBeat.o(130371);
  }
  
  public final boolean Nb()
  {
    AppMethodBeat.i(130368);
    boolean bool = this.hjz.Nb();
    AppMethodBeat.o(130368);
    return bool;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(130373);
    this.hjB.remove(Integer.valueOf(paramc.gku));
    ad.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.hjB.size()), Integer.valueOf(paramc.gku) });
    AppMethodBeat.o(130373);
  }
  
  public final void a(com.tencent.mm.aw.a.f.a parama)
  {
    AppMethodBeat.i(194592);
    this.hjz.execute(parama);
    AppMethodBeat.o(194592);
  }
  
  public final void a(com.tencent.mm.aw.a.f.b paramb)
  {
    AppMethodBeat.i(130374);
    if ((this.hjC != null) && (paramb.hkB != null))
    {
      com.tencent.mm.aw.a.f.b localb = (com.tencent.mm.aw.a.f.b)this.hjC.get(Integer.valueOf(paramb.hkB.gku));
      if ((localb != null) && (localb.hkB != null) && (paramb.hkB.gku == localb.hkB.gku))
      {
        this.hjz.remove(localb);
        ad.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { localb.url });
      }
      this.hjC.put(Integer.valueOf(paramb.hkB.gku), paramb);
    }
    AppMethodBeat.o(130374);
  }
  
  public final void a(com.tencent.mm.aw.a.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(130367);
    agU();
    this.hjz.execute(paramb);
    if ((paramBoolean) && (com.tencent.mm.aw.a.g.b.azh())) {
      this.hjA.execute(new d());
    }
    AppMethodBeat.o(130367);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(130372);
    if (!bt.isNullOrNil(paramString))
    {
      String str = (String)this.hjB.get(Integer.valueOf(paramc.gku));
      if ((bt.isNullOrNil(str)) || (!paramString.equals(str)))
      {
        this.hjB.put(Integer.valueOf(paramc.gku), paramString);
        AppMethodBeat.o(130372);
        return true;
      }
    }
    AppMethodBeat.o(130372);
    return false;
  }
  
  public final void ayP()
  {
    AppMethodBeat.i(130370);
    if (this.hjy != null)
    {
      this.hjy.hjH.clear();
      this.hjy.hjI.azd();
    }
    AppMethodBeat.o(130370);
  }
  
  public final Bitmap yu(String paramString)
  {
    AppMethodBeat.i(130369);
    if (this.hjy != null)
    {
      paramString = this.hjy.hjH.pT(paramString);
      AppMethodBeat.o(130369);
      return paramString;
    }
    AppMethodBeat.o(130369);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.a.b
 * JD-Core Version:    0.7.0.1
 */