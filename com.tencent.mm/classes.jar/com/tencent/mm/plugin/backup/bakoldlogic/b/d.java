package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d
  extends a
{
  private static String TAG = "MicroMsg.BakOldItemFactory";
  private static d nao;
  private HashMap<Integer, j> mWQ;
  
  public static d bEY()
  {
    AppMethodBeat.i(21843);
    if (nao == null)
    {
      locald = new d();
      nao = locald;
      a(locald);
    }
    d locald = nao;
    AppMethodBeat.o(21843);
    return locald;
  }
  
  public final void bCK()
  {
    nao = null;
  }
  
  public final j xd(int paramInt)
  {
    AppMethodBeat.i(21844);
    if (this.mWQ == null)
    {
      this.mWQ = new HashMap();
      this.mWQ.put(Integer.valueOf(3), new e());
      this.mWQ.put(Integer.valueOf(47), new c());
      this.mWQ.put(Integer.valueOf(49), new b());
      this.mWQ.put(Integer.valueOf(34), new h());
      localObject = new g();
      this.mWQ.put(Integer.valueOf(43), localObject);
      this.mWQ.put(Integer.valueOf(44), localObject);
      this.mWQ.put(Integer.valueOf(62), localObject);
      localObject = new f();
      this.mWQ.put(Integer.valueOf(48), localObject);
      this.mWQ.put(Integer.valueOf(42), localObject);
      this.mWQ.put(Integer.valueOf(66), localObject);
      this.mWQ.put(Integer.valueOf(10000), localObject);
      this.mWQ.put(Integer.valueOf(1), localObject);
      this.mWQ.put(Integer.valueOf(37), localObject);
      this.mWQ.put(Integer.valueOf(40), localObject);
      this.mWQ.put(Integer.valueOf(50), localObject);
    }
    Object localObject = (j)this.mWQ.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21844);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.d
 * JD-Core Version:    0.7.0.1
 */