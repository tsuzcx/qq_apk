package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c muO;
  private HashMap<Integer, l> muP;
  
  public static c bxa()
  {
    AppMethodBeat.i(21510);
    if (muO == null)
    {
      localc = new c();
      muO = localc;
      a(localc);
    }
    c localc = muO;
    AppMethodBeat.o(21510);
    return localc;
  }
  
  private void bxb()
  {
    AppMethodBeat.i(21512);
    this.muP = new HashMap();
    this.muP.put(Integer.valueOf(3), new d());
    this.muP.put(Integer.valueOf(47), new b());
    this.muP.put(Integer.valueOf(49), new a());
    this.muP.put(Integer.valueOf(34), new g());
    Object localObject = new f();
    this.muP.put(Integer.valueOf(43), localObject);
    this.muP.put(Integer.valueOf(44), localObject);
    this.muP.put(Integer.valueOf(62), localObject);
    localObject = new e();
    this.muP.put(Integer.valueOf(48), localObject);
    this.muP.put(Integer.valueOf(42), localObject);
    this.muP.put(Integer.valueOf(66), localObject);
    this.muP.put(Integer.valueOf(10000), localObject);
    this.muP.put(Integer.valueOf(1), localObject);
    this.muP.put(Integer.valueOf(37), localObject);
    this.muP.put(Integer.valueOf(40), localObject);
    this.muP.put(Integer.valueOf(50), localObject);
    AppMethodBeat.o(21512);
  }
  
  public final void bvO()
  {
    muO = null;
  }
  
  public final l wa(int paramInt)
  {
    AppMethodBeat.i(21511);
    if (this.muP == null) {
      bxb();
    }
    l locall = (l)this.muP.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21511);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */