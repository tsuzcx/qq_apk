package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.vending.g.c;

public abstract interface b
  extends com.tencent.luggage.a.b
{
  public abstract <Resp extends cvp> c<Resp> a(String paramString, a parama, Class<Resp> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.b
 * JD-Core Version:    0.7.0.1
 */