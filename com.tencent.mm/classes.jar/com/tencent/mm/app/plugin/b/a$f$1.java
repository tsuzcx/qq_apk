package com.tencent.mm.app.plugin.b;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$f$1
  implements am.a
{
  a$f$1(a.f paramf) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
    this.byW.byT = true;
    this.byW.stopRecord();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b.a.f.1
 * JD-Core Version:    0.7.0.1
 */