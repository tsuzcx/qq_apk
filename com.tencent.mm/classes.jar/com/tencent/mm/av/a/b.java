package com.tencent.mm.av.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.av.a.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  public com.tencent.mm.av.a.a.b ifO;
  j ifP;
  private Executor ifQ;
  public final Map<Integer, String> ifR;
  public HashMap<Integer, com.tencent.mm.av.a.f.b> ifS;
  
  public b(com.tencent.mm.av.a.a.b paramb)
  {
    AppMethodBeat.i(130366);
    this.ifR = Collections.synchronizedMap(new HashMap());
    this.ifS = new HashMap();
    this.ifO = paramb;
    this.ifP = paramb.ige;
    this.ifQ = paramb.igf;
    this.ifO.ifY.a(this.ifO.iga);
    AppMethodBeat.o(130366);
  }
  
  private void aqW()
  {
    AppMethodBeat.i(130371);
    if (this.ifO.ige.isShutdown()) {
      this.ifP = com.tencent.mm.av.a.a.a.pH(this.ifO.ifU);
    }
    AppMethodBeat.o(130371);
  }
  
  public final Bitmap Gf(String paramString)
  {
    AppMethodBeat.i(130369);
    if (this.ifO != null)
    {
      paramString = this.ifO.ifX.wA(paramString);
      AppMethodBeat.o(130369);
      return paramString;
    }
    AppMethodBeat.o(130369);
    return null;
  }
  
  public final boolean OG()
  {
    AppMethodBeat.i(130368);
    boolean bool = this.ifP.OG();
    AppMethodBeat.o(130368);
    return bool;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(130373);
    this.ifR.remove(Integer.valueOf(paramc.hhK));
    ae.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.ifR.size()), Integer.valueOf(paramc.hhK) });
    AppMethodBeat.o(130373);
  }
  
  public final void a(com.tencent.mm.av.a.f.a parama)
  {
    AppMethodBeat.i(209403);
    this.ifP.execute(parama);
    AppMethodBeat.o(209403);
  }
  
  public final void a(com.tencent.mm.av.a.f.b paramb)
  {
    AppMethodBeat.i(130374);
    if ((this.ifS != null) && (paramb.igR != null))
    {
      com.tencent.mm.av.a.f.b localb = (com.tencent.mm.av.a.f.b)this.ifS.get(Integer.valueOf(paramb.igR.hhK));
      if ((localb != null) && (localb.igR != null) && (paramb.igR.hhK == localb.igR.hhK))
      {
        this.ifP.remove(localb);
        ae.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { localb.url });
      }
      this.ifS.put(Integer.valueOf(paramb.igR.hhK), paramb);
    }
    AppMethodBeat.o(130374);
  }
  
  public final void a(com.tencent.mm.av.a.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(130367);
    aqW();
    this.ifP.execute(paramb);
    if ((paramBoolean) && (com.tencent.mm.av.a.g.b.aJz())) {
      this.ifQ.execute(new d());
    }
    AppMethodBeat.o(130367);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(130372);
    if (!bu.isNullOrNil(paramString))
    {
      String str = (String)this.ifR.get(Integer.valueOf(paramc.hhK));
      if ((bu.isNullOrNil(str)) || (!paramString.equals(str)))
      {
        this.ifR.put(Integer.valueOf(paramc.hhK), paramString);
        AppMethodBeat.o(130372);
        return true;
      }
    }
    AppMethodBeat.o(130372);
    return false;
  }
  
  public final void aoM()
  {
    AppMethodBeat.i(130370);
    if (this.ifO != null)
    {
      this.ifO.ifX.clear();
      this.ifO.ifY.aJv();
    }
    AppMethodBeat.o(130370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.b
 * JD-Core Version:    0.7.0.1
 */