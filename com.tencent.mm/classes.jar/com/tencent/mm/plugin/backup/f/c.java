package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c jDu;
  private HashMap<Integer, l> jDv;
  
  public static c aTT()
  {
    AppMethodBeat.i(17451);
    if (jDu == null)
    {
      localc = new c();
      jDu = localc;
      a(localc);
    }
    c localc = jDu;
    AppMethodBeat.o(17451);
    return localc;
  }
  
  private void aTU()
  {
    AppMethodBeat.i(17453);
    this.jDv = new HashMap();
    this.jDv.put(Integer.valueOf(3), new d());
    this.jDv.put(Integer.valueOf(47), new b());
    this.jDv.put(Integer.valueOf(49), new a());
    this.jDv.put(Integer.valueOf(34), new g());
    Object localObject = new f();
    this.jDv.put(Integer.valueOf(43), localObject);
    this.jDv.put(Integer.valueOf(44), localObject);
    this.jDv.put(Integer.valueOf(62), localObject);
    localObject = new e();
    this.jDv.put(Integer.valueOf(48), localObject);
    this.jDv.put(Integer.valueOf(42), localObject);
    this.jDv.put(Integer.valueOf(66), localObject);
    this.jDv.put(Integer.valueOf(10000), localObject);
    this.jDv.put(Integer.valueOf(1), localObject);
    this.jDv.put(Integer.valueOf(37), localObject);
    this.jDv.put(Integer.valueOf(40), localObject);
    this.jDv.put(Integer.valueOf(50), localObject);
    AppMethodBeat.o(17453);
  }
  
  public final void aSG()
  {
    jDu = null;
  }
  
  public final l ro(int paramInt)
  {
    AppMethodBeat.i(17452);
    if (this.jDv == null) {
      aTU();
    }
    l locall = (l)this.jDv.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(17452);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */