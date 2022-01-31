package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d
  extends a
{
  private static String TAG = "MicroMsg.BakOldItemFactory";
  private static d hNr;
  private HashMap<Integer, j> hJS;
  
  public static d avq()
  {
    if (hNr == null)
    {
      d locald = new d();
      hNr = locald;
      a(locald);
    }
    return hNr;
  }
  
  public final void ati()
  {
    hNr = null;
  }
  
  public final j nM(int paramInt)
  {
    if (this.hJS == null)
    {
      this.hJS = new HashMap();
      this.hJS.put(Integer.valueOf(3), new e());
      this.hJS.put(Integer.valueOf(47), new c());
      this.hJS.put(Integer.valueOf(49), new b());
      this.hJS.put(Integer.valueOf(34), new h());
      Object localObject = new g();
      this.hJS.put(Integer.valueOf(43), localObject);
      this.hJS.put(Integer.valueOf(44), localObject);
      this.hJS.put(Integer.valueOf(62), localObject);
      localObject = new f();
      this.hJS.put(Integer.valueOf(48), localObject);
      this.hJS.put(Integer.valueOf(42), localObject);
      this.hJS.put(Integer.valueOf(66), localObject);
      this.hJS.put(Integer.valueOf(10000), localObject);
      this.hJS.put(Integer.valueOf(1), localObject);
      this.hJS.put(Integer.valueOf(37), localObject);
      this.hJS.put(Integer.valueOf(40), localObject);
      this.hJS.put(Integer.valueOf(50), localObject);
    }
    return (j)this.hJS.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.d
 * JD-Core Version:    0.7.0.1
 */