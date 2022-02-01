package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c nCH;
  private HashMap<Integer, l> nCI;
  
  public static c bJd()
  {
    AppMethodBeat.i(21510);
    if (nCH == null)
    {
      localc = new c();
      nCH = localc;
      a(localc);
    }
    c localc = nCH;
    AppMethodBeat.o(21510);
    return localc;
  }
  
  private void bJe()
  {
    AppMethodBeat.i(21512);
    this.nCI = new HashMap();
    this.nCI.put(Integer.valueOf(3), new d());
    this.nCI.put(Integer.valueOf(47), new b());
    this.nCI.put(Integer.valueOf(49), new a());
    this.nCI.put(Integer.valueOf(34), new g());
    Object localObject = new f();
    this.nCI.put(Integer.valueOf(43), localObject);
    this.nCI.put(Integer.valueOf(44), localObject);
    this.nCI.put(Integer.valueOf(62), localObject);
    localObject = new e();
    this.nCI.put(Integer.valueOf(48), localObject);
    this.nCI.put(Integer.valueOf(42), localObject);
    this.nCI.put(Integer.valueOf(66), localObject);
    this.nCI.put(Integer.valueOf(10000), localObject);
    this.nCI.put(Integer.valueOf(1), localObject);
    this.nCI.put(Integer.valueOf(37), localObject);
    this.nCI.put(Integer.valueOf(40), localObject);
    this.nCI.put(Integer.valueOf(50), localObject);
    AppMethodBeat.o(21512);
  }
  
  public final void bHQ()
  {
    nCH = null;
  }
  
  public final l xB(int paramInt)
  {
    AppMethodBeat.i(21511);
    if (this.nCI == null) {
      bJe();
    }
    l locall = (l)this.nCI.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21511);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */