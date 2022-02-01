package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c mWP;
  private HashMap<Integer, l> mWQ;
  
  public static c bDW()
  {
    AppMethodBeat.i(21510);
    if (mWP == null)
    {
      localc = new c();
      mWP = localc;
      a(localc);
    }
    c localc = mWP;
    AppMethodBeat.o(21510);
    return localc;
  }
  
  private void bDX()
  {
    AppMethodBeat.i(21512);
    this.mWQ = new HashMap();
    this.mWQ.put(Integer.valueOf(3), new d());
    this.mWQ.put(Integer.valueOf(47), new b());
    this.mWQ.put(Integer.valueOf(49), new a());
    this.mWQ.put(Integer.valueOf(34), new g());
    Object localObject = new f();
    this.mWQ.put(Integer.valueOf(43), localObject);
    this.mWQ.put(Integer.valueOf(44), localObject);
    this.mWQ.put(Integer.valueOf(62), localObject);
    localObject = new e();
    this.mWQ.put(Integer.valueOf(48), localObject);
    this.mWQ.put(Integer.valueOf(42), localObject);
    this.mWQ.put(Integer.valueOf(66), localObject);
    this.mWQ.put(Integer.valueOf(10000), localObject);
    this.mWQ.put(Integer.valueOf(1), localObject);
    this.mWQ.put(Integer.valueOf(37), localObject);
    this.mWQ.put(Integer.valueOf(40), localObject);
    this.mWQ.put(Integer.valueOf(50), localObject);
    AppMethodBeat.o(21512);
  }
  
  public final void bCK()
  {
    mWP = null;
  }
  
  public final l wR(int paramInt)
  {
    AppMethodBeat.i(21511);
    if (this.mWQ == null) {
      bDX();
    }
    l locall = (l)this.mWQ.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21511);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */