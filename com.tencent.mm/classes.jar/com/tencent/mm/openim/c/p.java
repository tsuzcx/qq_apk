package com.tencent.mm.openim.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;

public final class p
  implements com.tencent.mm.openim.a.a
{
  public final void U(String paramString1, String paramString2)
  {
    ((j)g.r(j.class)).Fv().b(new k(paramString1, paramString2));
  }
  
  public final void iA(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new h(paramString, 1));
  }
  
  public final void iB(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new h(paramString, 2));
  }
  
  public final void iu(String paramString)
  {
    if (s.hb(paramString))
    {
      ((j)g.r(j.class)).Fv().b(new f(paramString, 1));
      return;
    }
    ((j)g.r(j.class)).Fv().b(new o(paramString, 1));
  }
  
  public final void iv(String paramString)
  {
    if (s.hb(paramString))
    {
      ((j)g.r(j.class)).Fv().b(new f(paramString, 2));
      return;
    }
    ((j)g.r(j.class)).Fv().b(new o(paramString, 2));
  }
  
  public final void iw(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new n(paramString, 1));
  }
  
  public final void ix(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new n(paramString, 2));
  }
  
  public final void iy(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new m(paramString, 1));
  }
  
  public final void iz(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new m(paramString, 2));
  }
  
  public final void oO(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new a(paramString));
  }
  
  public final void oP(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new l(paramString, 1));
  }
  
  public final void oQ(String paramString)
  {
    ((j)g.r(j.class)).Fv().b(new l(paramString, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.c.p
 * JD-Core Version:    0.7.0.1
 */