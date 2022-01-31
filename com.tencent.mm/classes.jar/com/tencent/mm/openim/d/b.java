package com.tencent.mm.openim.d;

import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "OpenIMAccTypeInfo") };
  public h dXo;
  
  public b(h paramh)
  {
    super(paramh, a.buS, "OpenIMAccTypeInfo", null);
    this.dXo = paramh;
  }
  
  public final boolean a(a parama)
  {
    parama.field_updateTime = bk.UX();
    return super.a(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.d.b
 * JD-Core Version:    0.7.0.1
 */