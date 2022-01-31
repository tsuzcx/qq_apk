package com.tencent.mm.plugin.location.model;

import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class k$a
  implements av.a
{
  private byte[] data;
  boolean lDs = true;
  private int lDt;
  private int lDu;
  private String mFilePath;
  String url = "";
  
  public k$a(k paramk, boolean paramBoolean, String paramString1, String paramString2)
  {
    this.lDs = paramBoolean;
    this.lDt = paramk.w;
    this.lDu = paramk.h;
    this.url = paramString1;
    while (this.lDt * this.lDu > 270000)
    {
      this.lDt = ((int)(this.lDt / 1.2D));
      this.lDu = ((int)(this.lDu / 1.2D));
    }
    this.mFilePath = paramString2;
    y.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[] { paramString1, bk.aM(this.mFilePath, "") });
  }
  
  public final boolean JS()
  {
    this.data = bk.ZV(this.url);
    if (this.data != null) {
      e.b(this.mFilePath, this.data, this.data.length);
    }
    return true;
  }
  
  public final boolean JT()
  {
    StringBuilder localStringBuilder = new StringBuilder("http onPostExecute ");
    if (this.data == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.StaticMapServer", bool + " isGoole: " + this.lDs);
      if (this.data != null) {
        break label213;
      }
      if (!this.lDs) {
        break label203;
      }
      if (this.lDv.lDr != null) {
        break;
      }
      k.a(this.lDv, false);
      return false;
    }
    this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[] { Integer.valueOf(this.lDt), Integer.valueOf(this.lDu), Float.valueOf(this.lDv.lDr.ell), Float.valueOf(this.lDv.lDr.elk), Integer.valueOf(this.lDv.lDr.bRv) });
    this.lDv.elq.c(new a(this.lDv, false, this.url, k.b(this.lDv.lDr)));
    return false;
    label203:
    k.a(this.lDv, false);
    return false;
    label213:
    k.a(this.lDv, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.k.a
 * JD-Core Version:    0.7.0.1
 */