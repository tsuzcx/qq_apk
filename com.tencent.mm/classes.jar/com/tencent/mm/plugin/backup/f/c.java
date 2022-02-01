package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c nxm;
  private HashMap<Integer, l> nxn;
  
  public static c bIf()
  {
    AppMethodBeat.i(21510);
    if (nxm == null)
    {
      localc = new c();
      nxm = localc;
      a(localc);
    }
    c localc = nxm;
    AppMethodBeat.o(21510);
    return localc;
  }
  
  private void bIg()
  {
    AppMethodBeat.i(21512);
    this.nxn = new HashMap();
    this.nxn.put(Integer.valueOf(3), new d());
    this.nxn.put(Integer.valueOf(47), new b());
    this.nxn.put(Integer.valueOf(49), new a());
    this.nxn.put(Integer.valueOf(34), new g());
    Object localObject = new f();
    this.nxn.put(Integer.valueOf(43), localObject);
    this.nxn.put(Integer.valueOf(44), localObject);
    this.nxn.put(Integer.valueOf(62), localObject);
    localObject = new e();
    this.nxn.put(Integer.valueOf(48), localObject);
    this.nxn.put(Integer.valueOf(42), localObject);
    this.nxn.put(Integer.valueOf(66), localObject);
    this.nxn.put(Integer.valueOf(10000), localObject);
    this.nxn.put(Integer.valueOf(1), localObject);
    this.nxn.put(Integer.valueOf(37), localObject);
    this.nxn.put(Integer.valueOf(40), localObject);
    this.nxn.put(Integer.valueOf(50), localObject);
    AppMethodBeat.o(21512);
  }
  
  public final void bGS()
  {
    nxm = null;
  }
  
  public final l xx(int paramInt)
  {
    AppMethodBeat.i(21511);
    if (this.nxn == null) {
      bIg();
    }
    l locall = (l)this.nxn.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21511);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */