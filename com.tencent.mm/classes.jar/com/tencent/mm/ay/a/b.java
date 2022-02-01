package com.tencent.mm.ay.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.j;
import com.tencent.mm.ay.a.c.o;
import com.tencent.mm.ay.a.f.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  public com.tencent.mm.ay.a.a.b lRg;
  j lRh;
  private Executor lRi;
  public final Map<Integer, String> lRj;
  public HashMap<Integer, com.tencent.mm.ay.a.f.b> lRk;
  
  public b(com.tencent.mm.ay.a.a.b paramb)
  {
    AppMethodBeat.i(130366);
    this.lRj = Collections.synchronizedMap(new HashMap());
    this.lRk = new HashMap();
    this.lRg = paramb;
    this.lRh = paramb.lRx;
    this.lRi = paramb.lRy;
    this.lRg.lRr.a(this.lRg.lRt);
    AppMethodBeat.o(130366);
  }
  
  private void aRv()
  {
    AppMethodBeat.i(130371);
    if (this.lRg.lRx.isShutdown()) {
      this.lRh = com.tencent.mm.ay.a.a.a.wv(this.lRg.lRn);
    }
    AppMethodBeat.o(130371);
  }
  
  public final Bitmap Wo(String paramString)
  {
    AppMethodBeat.i(130369);
    if (this.lRg != null)
    {
      paramString = this.lRg.lRq.LI(paramString);
      AppMethodBeat.o(130369);
      return paramString;
    }
    AppMethodBeat.o(130369);
    return null;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(130373);
    this.lRj.remove(Integer.valueOf(paramc.kPn));
    Log.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.lRj.size()), Integer.valueOf(paramc.kPn) });
    AppMethodBeat.o(130373);
  }
  
  public final void a(com.tencent.mm.ay.a.f.a parama)
  {
    AppMethodBeat.i(245881);
    this.lRh.execute(parama);
    AppMethodBeat.o(245881);
  }
  
  public final void a(com.tencent.mm.ay.a.f.b paramb)
  {
    AppMethodBeat.i(130374);
    if ((this.lRk != null) && (paramb.lSm != null))
    {
      com.tencent.mm.ay.a.f.b localb = (com.tencent.mm.ay.a.f.b)this.lRk.get(Integer.valueOf(paramb.lSm.kPn));
      if ((localb != null) && (localb.lSm != null) && (paramb.lSm.kPn == localb.lSm.kPn))
      {
        this.lRh.remove(localb);
        Log.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { localb.url });
      }
      this.lRk.put(Integer.valueOf(paramb.lSm.kPn), paramb);
    }
    AppMethodBeat.o(130374);
  }
  
  public final void a(com.tencent.mm.ay.a.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(130367);
    aRv();
    this.lRh.execute(paramb);
    if ((paramBoolean) && (com.tencent.mm.ay.a.g.b.bmU())) {
      this.lRi.execute(new d());
    }
    AppMethodBeat.o(130367);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(130372);
    if (!Util.isNullOrNil(paramString))
    {
      String str = (String)this.lRj.get(Integer.valueOf(paramc.kPn));
      if ((Util.isNullOrNil(str)) || (!paramString.equals(str)))
      {
        this.lRj.put(Integer.valueOf(paramc.kPn), paramString);
        AppMethodBeat.o(130372);
        return true;
      }
    }
    AppMethodBeat.o(130372);
    return false;
  }
  
  public final void aPn()
  {
    AppMethodBeat.i(130370);
    if (this.lRg != null)
    {
      this.lRg.lRq.clear();
      this.lRg.lRr.bmM();
    }
    AppMethodBeat.o(130370);
  }
  
  public final boolean adH()
  {
    AppMethodBeat.i(130368);
    boolean bool = this.lRh.adH();
    AppMethodBeat.o(130368);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ay.a.b
 * JD-Core Version:    0.7.0.1
 */