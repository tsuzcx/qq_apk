package com.tencent.mm.kernel.a.c;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.h;

public abstract class a
  implements b
{
  public <T extends a> T after(com.tencent.mm.kernel.b.a parama)
  {
    h.RP().RI().Rj().eHJ.eIR.a(b.class, this, parama);
    return this;
  }
  
  public void alone()
  {
    h.RP().RI().Rj().eHJ.eIR.a(b.class, this, this);
  }
  
  public <T extends a> T before(com.tencent.mm.kernel.b.a parama)
  {
    h.RP().RI().Rj().eHJ.eIR.a(b.class, parama, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.a.c.a
 * JD-Core Version:    0.7.0.1
 */