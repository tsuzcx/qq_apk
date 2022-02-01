package com.tencent.mm.kernel.a.c;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;

public abstract class a
  implements b
{
  public <T extends a> T after(com.tencent.mm.kernel.b.a parama)
  {
    i.aHL().aHD().aHf().kct.kdG.a(b.class, this, parama);
    return this;
  }
  
  public void alone()
  {
    i.aHL().aHD().aHf().kct.kdG.a(b.class, this, this);
  }
  
  public <T extends a> T before(com.tencent.mm.kernel.b.a parama)
  {
    i.aHL().aHD().aHf().kct.kdG.a(b.class, parama, this);
    return this;
  }
  
  public int hashCode()
  {
    return name().hashCode();
  }
  
  public String name()
  {
    return toString();
  }
  
  public String toString()
  {
    return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.a.c.a
 * JD-Core Version:    0.7.0.1
 */