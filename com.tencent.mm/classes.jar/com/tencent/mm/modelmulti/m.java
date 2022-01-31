package com.tencent.mm.modelmulti;

import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.storage.bi;

public final class m
  implements q
{
  private final m.a etC = new m.a((byte)0);
  private g etD;
  
  public final com.tencent.mm.plugin.messenger.foundation.a.m Pk()
  {
    return this.etC;
  }
  
  public final void a(g paramg)
  {
    this.etD = paramg;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.m paramm)
  {
    this.etC.aj(paramm);
  }
  
  public final String v(bi parambi)
  {
    if (this.etD != null) {
      return this.etD.v(parambi);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelmulti.m
 * JD-Core Version:    0.7.0.1
 */