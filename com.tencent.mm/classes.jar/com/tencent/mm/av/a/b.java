package com.tencent.mm.av.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.av.a.f.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  public com.tencent.mm.av.a.a.b jaJ;
  j jaK;
  private Executor jaL;
  public final Map<Integer, String> jaM;
  public HashMap<Integer, com.tencent.mm.av.a.f.b> jaN;
  
  public b(com.tencent.mm.av.a.a.b paramb)
  {
    AppMethodBeat.i(130366);
    this.jaM = Collections.synchronizedMap(new HashMap());
    this.jaN = new HashMap();
    this.jaJ = paramb;
    this.jaK = paramb.jaZ;
    this.jaL = paramb.jba;
    this.jaJ.jaT.a(this.jaJ.jaV);
    AppMethodBeat.o(130366);
  }
  
  private void aJv()
  {
    AppMethodBeat.i(130371);
    if (this.jaJ.jaZ.isShutdown()) {
      this.jaK = com.tencent.mm.av.a.a.a.tv(this.jaJ.jaP);
    }
    AppMethodBeat.o(130371);
  }
  
  public final Bitmap OQ(String paramString)
  {
    AppMethodBeat.i(130369);
    if (this.jaJ != null)
    {
      paramString = this.jaJ.jaS.EP(paramString);
      AppMethodBeat.o(130369);
      return paramString;
    }
    AppMethodBeat.o(130369);
    return null;
  }
  
  public final boolean YY()
  {
    AppMethodBeat.i(130368);
    boolean bool = this.jaK.YY();
    AppMethodBeat.o(130368);
    return bool;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(130373);
    this.jaM.remove(Integer.valueOf(paramc.iaH));
    Log.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.jaM.size()), Integer.valueOf(paramc.iaH) });
    AppMethodBeat.o(130373);
  }
  
  public final void a(com.tencent.mm.av.a.f.a parama)
  {
    AppMethodBeat.i(212680);
    this.jaK.execute(parama);
    AppMethodBeat.o(212680);
  }
  
  public final void a(com.tencent.mm.av.a.f.b paramb)
  {
    AppMethodBeat.i(130374);
    if ((this.jaN != null) && (paramb.jbM != null))
    {
      com.tencent.mm.av.a.f.b localb = (com.tencent.mm.av.a.f.b)this.jaN.get(Integer.valueOf(paramb.jbM.iaH));
      if ((localb != null) && (localb.jbM != null) && (paramb.jbM.iaH == localb.jbM.iaH))
      {
        this.jaK.remove(localb);
        Log.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { localb.url });
      }
      this.jaN.put(Integer.valueOf(paramb.jbM.iaH), paramb);
    }
    AppMethodBeat.o(130374);
  }
  
  public final void a(com.tencent.mm.av.a.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(130367);
    aJv();
    this.jaK.execute(paramb);
    if ((paramBoolean) && (com.tencent.mm.av.a.g.b.bdA())) {
      this.jaL.execute(new d());
    }
    AppMethodBeat.o(130367);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(130372);
    if (!Util.isNullOrNil(paramString))
    {
      String str = (String)this.jaM.get(Integer.valueOf(paramc.iaH));
      if ((Util.isNullOrNil(str)) || (!paramString.equals(str)))
      {
        this.jaM.put(Integer.valueOf(paramc.iaH), paramString);
        AppMethodBeat.o(130372);
        return true;
      }
    }
    AppMethodBeat.o(130372);
    return false;
  }
  
  public final void aHn()
  {
    AppMethodBeat.i(130370);
    if (this.jaJ != null)
    {
      this.jaJ.jaS.clear();
      this.jaJ.jaT.bdw();
    }
    AppMethodBeat.o(130370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.b
 * JD-Core Version:    0.7.0.1
 */