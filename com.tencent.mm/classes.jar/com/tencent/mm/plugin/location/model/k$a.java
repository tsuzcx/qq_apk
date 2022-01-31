package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class k$a
  implements az.a
{
  private byte[] data;
  private String mFilePath;
  boolean oaE;
  private int oaF;
  private int oaG;
  String url;
  
  public k$a(k paramk, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(113330);
    this.url = "";
    this.oaE = true;
    this.oaE = paramBoolean;
    this.oaF = paramk.w;
    this.oaG = paramk.h;
    this.url = paramString1;
    while (this.oaF * this.oaG > 270000)
    {
      this.oaF = ((int)(this.oaF / 1.2D));
      this.oaG = ((int)(this.oaG / 1.2D));
    }
    this.mFilePath = paramString2;
    ab.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[] { paramString1, bo.bf(this.mFilePath, "") });
    AppMethodBeat.o(113330);
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(113331);
    this.data = bo.apZ(this.url);
    if (this.data != null) {
      e.b(this.mFilePath, this.data, this.data.length);
    }
    AppMethodBeat.o(113331);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(113332);
    StringBuilder localStringBuilder = new StringBuilder("http onPostExecute ");
    if (this.data == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.StaticMapServer", bool + " isGoole: " + this.oaE);
      if (this.data != null) {
        break label233;
      }
      if (!this.oaE) {
        break label218;
      }
      if (this.oaH.oaD != null) {
        break;
      }
      k.a(this.oaH, false);
      AppMethodBeat.o(113332);
      return false;
    }
    this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(this.oaF), Integer.valueOf(this.oaG), Float.valueOf(this.oaH.oaD.fBC), Float.valueOf(this.oaH.oaD.fBB), Integer.valueOf(this.oaH.oaD.cyX) });
    this.oaH.fBI.e(new a(this.oaH, false, this.url, k.b(this.oaH.oaD)));
    AppMethodBeat.o(113332);
    return false;
    label218:
    k.a(this.oaH, false);
    AppMethodBeat.o(113332);
    return false;
    label233:
    k.a(this.oaH, true);
    AppMethodBeat.o(113332);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k.a
 * JD-Core Version:    0.7.0.1
 */