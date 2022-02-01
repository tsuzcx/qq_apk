package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;

final class e$1
  implements q.b
{
  e$1(e parame, PBool paramPBool, i parami, PInt paramPInt) {}
  
  public final void a(m.c paramc)
  {
    this.coC.value = paramc;
    this.coE.value = paramc.sourceLength;
  }
  
  public final void cT(String paramString)
  {
    this.kkq.value = false;
  }
  
  public final void onSuccess(String paramString)
  {
    this.kkq.value = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.1
 * JD-Core Version:    0.7.0.1
 */