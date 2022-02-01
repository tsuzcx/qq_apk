package com.tencent.mm.openim.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
{
  public String key;
  public String prk;
  public boolean prl;
  public boolean prm;
  public boolean prn;
  public boolean pro;
  public int scene;
  public String url;
  
  public i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(235774);
    this.scene = 0;
    this.url = "";
    this.prk = "";
    this.prl = false;
    this.prm = false;
    this.prn = true;
    this.pro = false;
    this.key = "";
    this.scene = paramInt;
    this.prk = paramString1;
    this.url = paramString2;
    if (!Util.isNullOrNil(this.prk)) {}
    for (paramString1 = this.prk;; paramString1 = Util.nullAs(paramString2, ""))
    {
      this.key = paramString1;
      AppMethodBeat.o(235774);
      return;
    }
  }
  
  public i(String paramString)
  {
    this(0, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.api.i
 * JD-Core Version:    0.7.0.1
 */