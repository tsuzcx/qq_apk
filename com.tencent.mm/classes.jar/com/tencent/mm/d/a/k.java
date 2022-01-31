package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.utils.MemoryManager;

public class k
{
  public final h byY = new h(this.bzA);
  a byZ;
  private final MultiContextV8 bzA = MultiContextV8.createMultiContextV8();
  private final MemoryManager bzM = this.bzA.createMemoryManager();
  
  static
  {
    com.tencent.mm.compatible.util.k.b("mmv8", k.class.getClassLoader());
    com.tencent.mm.compatible.util.k.b("j2v8", k.class.getClassLoader());
  }
  
  public static k tF()
  {
    return new k();
  }
  
  public final b ev(int paramInt)
  {
    MultiContextV8 localMultiContextV8 = this.bzA;
    h localh = this.byY;
    if (this.byZ == null) {
      this.byZ = new g();
    }
    return new b(localMultiContextV8, localh, this.byZ, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.k
 * JD-Core Version:    0.7.0.1
 */