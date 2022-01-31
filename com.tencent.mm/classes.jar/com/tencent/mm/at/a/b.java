package com.tencent.mm.at.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.h;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.at.a.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  public com.tencent.mm.at.a.a.b fGZ;
  h fHa;
  private Executor fHb;
  public final Map<Integer, String> fHc;
  public HashMap<Integer, com.tencent.mm.at.a.f.b> fHd;
  
  public b(com.tencent.mm.at.a.a.b paramb)
  {
    AppMethodBeat.i(116037);
    this.fHc = Collections.synchronizedMap(new HashMap());
    this.fHd = new HashMap();
    this.fGZ = paramb;
    this.fHa = paramb.fHp;
    this.fHb = paramb.fHq;
    this.fGZ.fHj.a(this.fGZ.fHl);
    AppMethodBeat.o(116037);
  }
  
  private void SZ()
  {
    AppMethodBeat.i(116042);
    if (this.fGZ.fHp.isShutdown()) {
      this.fHa = com.tencent.mm.at.a.a.a.cw(this.fGZ.fHf, this.fGZ.fHg);
    }
    AppMethodBeat.o(116042);
  }
  
  public final boolean Ds()
  {
    AppMethodBeat.i(116039);
    boolean bool = this.fHa.Ds();
    AppMethodBeat.o(116039);
    return bool;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(116044);
    this.fHc.remove(Integer.valueOf(paramc.eOR));
    ab.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.fHc.size()), Integer.valueOf(paramc.eOR) });
    AppMethodBeat.o(116044);
  }
  
  public final void a(com.tencent.mm.at.a.f.b paramb)
  {
    AppMethodBeat.i(116045);
    if ((this.fHd != null) && (paramb.fHG != null))
    {
      com.tencent.mm.at.a.f.b localb = (com.tencent.mm.at.a.f.b)this.fHd.get(Integer.valueOf(paramb.fHG.eOR));
      if ((localb != null) && (localb.fHG != null) && (paramb.fHG.eOR == localb.fHG.eOR))
      {
        this.fHa.remove(localb);
        ab.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { localb.url });
      }
      this.fHd.put(Integer.valueOf(paramb.fHG.eOR), paramb);
    }
    AppMethodBeat.o(116045);
  }
  
  public final void a(com.tencent.mm.at.a.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(116038);
    SZ();
    this.fHa.execute(paramb);
    if ((paramBoolean) && (com.tencent.mm.at.a.g.b.Ur())) {
      this.fHb.execute(new d());
    }
    AppMethodBeat.o(116038);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(116043);
    if (!bo.isNullOrNil(paramString))
    {
      String str = (String)this.fHc.get(Integer.valueOf(paramc.eOR));
      if ((bo.isNullOrNil(str)) || (!paramString.equals(str)))
      {
        this.fHc.put(Integer.valueOf(paramc.eOR), paramString);
        AppMethodBeat.o(116043);
        return true;
      }
    }
    AppMethodBeat.o(116043);
    return false;
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(116041);
    if (this.fGZ != null)
    {
      this.fGZ.fHi.clear();
      this.fGZ.fHj.ahZ();
    }
    AppMethodBeat.o(116041);
  }
  
  public final Bitmap tx(String paramString)
  {
    AppMethodBeat.i(116040);
    if (this.fGZ != null)
    {
      paramString = this.fGZ.fHi.lK(paramString);
      AppMethodBeat.o(116040);
      return paramString;
    }
    AppMethodBeat.o(116040);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.at.a.b
 * JD-Core Version:    0.7.0.1
 */