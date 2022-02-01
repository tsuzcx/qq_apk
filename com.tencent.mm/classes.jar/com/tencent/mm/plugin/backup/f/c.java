package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c rPA;
  private HashMap<Integer, l> rPB;
  
  public static c cti()
  {
    AppMethodBeat.i(21510);
    if (rPA == null)
    {
      localc = new c();
      rPA = localc;
      a(localc);
    }
    c localc = rPA;
    AppMethodBeat.o(21510);
    return localc;
  }
  
  private void ctj()
  {
    AppMethodBeat.i(21512);
    this.rPB = new HashMap();
    this.rPB.put(Integer.valueOf(3), new d());
    this.rPB.put(Integer.valueOf(47), new b());
    this.rPB.put(Integer.valueOf(49), new a());
    this.rPB.put(Integer.valueOf(34), new g());
    Object localObject = new f();
    this.rPB.put(Integer.valueOf(43), localObject);
    this.rPB.put(Integer.valueOf(44), localObject);
    this.rPB.put(Integer.valueOf(62), localObject);
    localObject = new e();
    this.rPB.put(Integer.valueOf(48), localObject);
    this.rPB.put(Integer.valueOf(42), localObject);
    this.rPB.put(Integer.valueOf(66), localObject);
    this.rPB.put(Integer.valueOf(10000), localObject);
    this.rPB.put(Integer.valueOf(1), localObject);
    this.rPB.put(Integer.valueOf(37), localObject);
    this.rPB.put(Integer.valueOf(40), localObject);
    this.rPB.put(Integer.valueOf(50), localObject);
    AppMethodBeat.o(21512);
  }
  
  public final l EI(int paramInt)
  {
    AppMethodBeat.i(21511);
    if (this.rPB == null) {
      ctj();
    }
    l locall = (l)this.rPB.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21511);
    return locall;
  }
  
  public final void crU()
  {
    rPA = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */