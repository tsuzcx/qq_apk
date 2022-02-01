package com.tencent.mm.modelimage.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.j;
import com.tencent.mm.modelimage.loader.b.o;
import com.tencent.mm.modelimage.loader.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  public com.tencent.mm.modelimage.loader.a.b oJS;
  j oJT;
  private Executor oJU;
  public final Map<Integer, String> oJV;
  public HashMap<Integer, com.tencent.mm.modelimage.loader.e.b> oJW;
  
  public b(com.tencent.mm.modelimage.loader.a.b paramb)
  {
    AppMethodBeat.i(130366);
    this.oJV = Collections.synchronizedMap(new HashMap());
    this.oJW = new HashMap();
    this.oJS = paramb;
    this.oJT = paramb.oKj;
    this.oJU = paramb.oKk;
    this.oJS.oKd.a(this.oJS.oKf);
    AppMethodBeat.o(130366);
  }
  
  private void blk()
  {
    AppMethodBeat.i(130371);
    if (this.oJS.oKj.isShutdown()) {
      this.oJT = com.tencent.mm.modelimage.loader.a.a.wA(this.oJS.oJZ);
    }
    AppMethodBeat.o(130371);
  }
  
  public final Bitmap Oo(String paramString)
  {
    AppMethodBeat.i(130369);
    if (this.oJS != null)
    {
      paramString = this.oJS.oKc.Eo(paramString);
      AppMethodBeat.o(130369);
      return paramString;
    }
    AppMethodBeat.o(130369);
    return null;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(130373);
    this.oJV.remove(Integer.valueOf(paramc.nqQ));
    Log.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.oJV.size()), Integer.valueOf(paramc.nqQ) });
    AppMethodBeat.o(130373);
  }
  
  public final void a(com.tencent.mm.modelimage.loader.e.a parama)
  {
    AppMethodBeat.i(239052);
    this.oJT.execute(parama);
    AppMethodBeat.o(239052);
  }
  
  public final void a(com.tencent.mm.modelimage.loader.e.b paramb)
  {
    AppMethodBeat.i(130374);
    if ((this.oJW != null) && (paramb.oKY != null))
    {
      com.tencent.mm.modelimage.loader.e.b localb = (com.tencent.mm.modelimage.loader.e.b)this.oJW.get(Integer.valueOf(paramb.oKY.nqQ));
      if ((localb != null) && (localb.oKY != null) && (paramb.oKY.nqQ == localb.oKY.nqQ))
      {
        this.oJT.remove(localb);
        Log.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { localb.url });
      }
      this.oJW.put(Integer.valueOf(paramb.oKY.nqQ), paramb);
    }
    AppMethodBeat.o(130374);
  }
  
  public final void a(com.tencent.mm.modelimage.loader.e.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(130367);
    blk();
    this.oJT.execute(paramb);
    if ((paramBoolean) && (com.tencent.mm.modelimage.loader.f.b.bKG())) {
      this.oJU.execute(new d());
    }
    AppMethodBeat.o(130367);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(130372);
    if (!Util.isNullOrNil(paramString))
    {
      String str = (String)this.oJV.get(Integer.valueOf(paramc.nqQ));
      if ((Util.isNullOrNil(str)) || (!paramString.equals(str)))
      {
        this.oJV.put(Integer.valueOf(paramc.nqQ), paramString);
        AppMethodBeat.o(130372);
        return true;
      }
    }
    AppMethodBeat.o(130372);
    return false;
  }
  
  public final boolean aFF()
  {
    AppMethodBeat.i(130368);
    boolean bool = this.oJT.aFF();
    AppMethodBeat.o(130368);
    return bool;
  }
  
  public final void bja()
  {
    AppMethodBeat.i(130370);
    if (this.oJS != null)
    {
      this.oJS.oKc.clear();
      this.oJS.oKd.bKy();
    }
    AppMethodBeat.o(130370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.b
 * JD-Core Version:    0.7.0.1
 */