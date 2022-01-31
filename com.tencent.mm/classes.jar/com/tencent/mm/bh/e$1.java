package com.tencent.mm.bh;

import com.tencent.mm.h.a.iy;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;

final class e$1
  implements am.b.a
{
  e$1(e parame, bi.d paramd) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    au.Hx();
    y.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.Fw().abl(this.eFf.uCl)));
    paramString = new iy();
    paramString.bRi.bRj = this.eFf.uCl;
    paramString.bRi.type = 1;
    a.udP.m(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bh.e.1
 * JD-Core Version:    0.7.0.1
 */