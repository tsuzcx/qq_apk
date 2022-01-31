package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.ak.f;
import com.tencent.mm.j.f.a;
import com.tencent.mm.j.g.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Vector;

public final class b
{
  public f.a epa = new b.1(this);
  public Vector<d.b> fNf = new Vector();
  public Vector<d.a> fNg = new Vector();
  public HashMap<String, d.c> fNh = new HashMap();
  public g.a fNi = new b.2(this);
  
  public static boolean rO(String paramString)
  {
    a locala = e.abd().rQ(paramString);
    if (locala == null)
    {
      y.e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[] { paramString });
      return false;
    }
    return f.Nd().lL(locala.bUi);
  }
  
  public final void a(d.a parama)
  {
    if ((this.fNg != null) && (parama != null)) {
      this.fNg.remove(parama);
    }
  }
  
  public final void a(d.b paramb)
  {
    if ((this.fNf != null) && (paramb != null)) {
      this.fNf.remove(paramb);
    }
  }
  
  public final void rP(String paramString)
  {
    this.fNh.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b
 * JD-Core Version:    0.7.0.1
 */