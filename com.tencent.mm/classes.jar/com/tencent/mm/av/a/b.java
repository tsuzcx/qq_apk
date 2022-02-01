package com.tencent.mm.av.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.av.a.f.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  public com.tencent.mm.av.a.a.b hKb;
  j hKc;
  private Executor hKd;
  public final Map<Integer, String> hKe;
  public HashMap<Integer, com.tencent.mm.av.a.f.b> hKf;
  
  public b(com.tencent.mm.av.a.a.b paramb)
  {
    AppMethodBeat.i(130366);
    this.hKe = Collections.synchronizedMap(new HashMap());
    this.hKf = new HashMap();
    this.hKb = paramb;
    this.hKc = paramb.hKr;
    this.hKd = paramb.hKs;
    this.hKb.hKl.a(this.hKb.hKn);
    AppMethodBeat.o(130366);
  }
  
  private void anV()
  {
    AppMethodBeat.i(130371);
    if (this.hKb.hKr.isShutdown()) {
      this.hKc = com.tencent.mm.av.a.a.a.pb(this.hKb.hKh);
    }
    AppMethodBeat.o(130371);
  }
  
  public final Bitmap Cz(String paramString)
  {
    AppMethodBeat.i(130369);
    if (this.hKb != null)
    {
      paramString = this.hKb.hKk.te(paramString);
      AppMethodBeat.o(130369);
      return paramString;
    }
    AppMethodBeat.o(130369);
    return null;
  }
  
  public final boolean MZ()
  {
    AppMethodBeat.i(130368);
    boolean bool = this.hKc.MZ();
    AppMethodBeat.o(130368);
    return bool;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(130373);
    this.hKe.remove(Integer.valueOf(paramc.gLh));
    ac.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.hKe.size()), Integer.valueOf(paramc.gLh) });
    AppMethodBeat.o(130373);
  }
  
  public final void a(com.tencent.mm.av.a.f.a parama)
  {
    AppMethodBeat.i(198537);
    this.hKc.execute(parama);
    AppMethodBeat.o(198537);
  }
  
  public final void a(com.tencent.mm.av.a.f.b paramb)
  {
    AppMethodBeat.i(130374);
    if ((this.hKf != null) && (paramb.hLe != null))
    {
      com.tencent.mm.av.a.f.b localb = (com.tencent.mm.av.a.f.b)this.hKf.get(Integer.valueOf(paramb.hLe.gLh));
      if ((localb != null) && (localb.hLe != null) && (paramb.hLe.gLh == localb.hLe.gLh))
      {
        this.hKc.remove(localb);
        ac.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { localb.url });
      }
      this.hKf.put(Integer.valueOf(paramb.hLe.gLh), paramb);
    }
    AppMethodBeat.o(130374);
  }
  
  public final void a(com.tencent.mm.av.a.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(130367);
    anV();
    this.hKc.execute(paramb);
    if ((paramBoolean) && (com.tencent.mm.av.a.g.b.aFY())) {
      this.hKd.execute(new d());
    }
    AppMethodBeat.o(130367);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(130372);
    if (!bs.isNullOrNil(paramString))
    {
      String str = (String)this.hKe.get(Integer.valueOf(paramc.gLh));
      if ((bs.isNullOrNil(str)) || (!paramString.equals(str)))
      {
        this.hKe.put(Integer.valueOf(paramc.gLh), paramString);
        AppMethodBeat.o(130372);
        return true;
      }
    }
    AppMethodBeat.o(130372);
    return false;
  }
  
  public final void alK()
  {
    AppMethodBeat.i(130370);
    if (this.hKb != null)
    {
      this.hKb.hKk.clear();
      this.hKb.hKl.aFU();
    }
    AppMethodBeat.o(130370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.av.a.b
 * JD-Core Version:    0.7.0.1
 */