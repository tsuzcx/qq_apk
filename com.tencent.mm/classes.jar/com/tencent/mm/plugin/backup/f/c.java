package com.tencent.mm.plugin.backup.f;

import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c hJR;
  private HashMap<Integer, l> hJS;
  
  public static c aut()
  {
    if (hJR == null)
    {
      c localc = new c();
      hJR = localc;
      a(localc);
    }
    return hJR;
  }
  
  public final void ati()
  {
    hJR = null;
  }
  
  public final l nA(int paramInt)
  {
    if (this.hJS == null)
    {
      this.hJS = new HashMap();
      this.hJS.put(Integer.valueOf(3), new d());
      this.hJS.put(Integer.valueOf(47), new b());
      this.hJS.put(Integer.valueOf(49), new a());
      this.hJS.put(Integer.valueOf(34), new g());
      Object localObject = new f();
      this.hJS.put(Integer.valueOf(43), localObject);
      this.hJS.put(Integer.valueOf(44), localObject);
      this.hJS.put(Integer.valueOf(62), localObject);
      localObject = new e();
      this.hJS.put(Integer.valueOf(48), localObject);
      this.hJS.put(Integer.valueOf(42), localObject);
      this.hJS.put(Integer.valueOf(66), localObject);
      this.hJS.put(Integer.valueOf(10000), localObject);
      this.hJS.put(Integer.valueOf(1), localObject);
      this.hJS.put(Integer.valueOf(37), localObject);
      this.hJS.put(Integer.valueOf(40), localObject);
      this.hJS.put(Integer.valueOf(50), localObject);
    }
    return (l)this.hJS.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */