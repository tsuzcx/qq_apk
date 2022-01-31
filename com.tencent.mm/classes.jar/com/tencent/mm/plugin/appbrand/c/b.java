package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Vector;

public final class b
{
  public g.a fFy;
  public Vector<d.b> hgp;
  public Vector<d.a> hgq;
  public HashMap<String, d.c> hgr;
  public h.a hgs;
  
  public b()
  {
    AppMethodBeat.i(129818);
    this.hgq = new Vector();
    this.hgp = new Vector();
    this.fFy = new b.1(this);
    this.hgr = new HashMap();
    this.hgs = new b.2(this);
    AppMethodBeat.o(129818);
  }
  
  public static boolean zE(String paramString)
  {
    AppMethodBeat.i(129821);
    a locala = g.auO().zG(paramString);
    if (locala == null)
    {
      ab.e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      AppMethodBeat.o(129821);
      return false;
    }
    boolean bool = f.afO().sI(locala.cBO);
    AppMethodBeat.o(129821);
    return bool;
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(129820);
    if ((this.hgq != null) && (parama != null)) {
      this.hgq.remove(parama);
    }
    AppMethodBeat.o(129820);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(129819);
    if ((this.hgp != null) && (paramb != null)) {
      this.hgp.remove(paramb);
    }
    AppMethodBeat.o(129819);
  }
  
  public final void zF(String paramString)
  {
    AppMethodBeat.i(129822);
    this.hgr.remove(paramString);
    AppMethodBeat.o(129822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b
 * JD-Core Version:    0.7.0.1
 */