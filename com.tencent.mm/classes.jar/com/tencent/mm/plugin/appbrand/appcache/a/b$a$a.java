package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a$a
{
  public final int code;
  
  static
  {
    AppMethodBeat.i(59555);
    gXl = new a("OK", 0, 0);
    gXm = new a("FAILED", 1, 101);
    gXn = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
    gXo = new a("PKG_INTEGRITY_FAILED", 3, 104);
    gXp = new a("PKG_INVALID", 4, 105);
    gXq = new a("SEVER_FILE_NOT_FOUND", 5, 106);
    gXr = new a("DISK_FULL", 6, 110);
    gXs = new a("ENV_ERR", 7, 200);
    gXt = new a("ZSTD_OP_FAILED", 8, 301);
    gXu = new a[] { gXl, gXm, gXn, gXo, gXp, gXq, gXr, gXs, gXt };
    AppMethodBeat.o(59555);
  }
  
  private b$a$a(int paramInt)
  {
    this.code = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */