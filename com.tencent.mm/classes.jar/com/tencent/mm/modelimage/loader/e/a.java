package com.tencent.mm.modelimage.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a
  implements Runnable
{
  private final com.tencent.mm.modelimage.loader.a.b oJS;
  private final com.tencent.mm.modelimage.loader.b oKW;
  private final d oKX;
  private final com.tencent.mm.modelimage.loader.a.c oKb;
  private final com.tencent.mm.modelimage.loader.b.b oKd;
  private final com.tencent.mm.modelimage.loader.b.c oKe;
  private final String url;
  
  public a(String paramString, com.tencent.mm.modelimage.loader.a.c paramc, com.tencent.mm.modelimage.loader.b paramb, d paramd)
  {
    AppMethodBeat.i(130433);
    this.url = paramString;
    this.oKW = paramb;
    this.oJS = this.oKW.oJS;
    if (paramc == null)
    {
      this.oKb = this.oJS.oKb;
      this.oKX = paramd;
      if (this.oKb.oKe == null) {
        break label97;
      }
    }
    label97:
    for (this.oKe = this.oKb.oKe;; this.oKe = this.oJS.oKe)
    {
      this.oKd = this.oJS.oKd;
      AppMethodBeat.o(130433);
      return;
      this.oKb = paramc;
      break;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(130434);
    new com.tencent.mm.modelimage.loader.c.b();
    com.tencent.mm.modelimage.loader.c.b localb = this.oKe.Os(this.url);
    if (localb == null)
    {
      if (this.oKX != null)
      {
        this.oKX.onImageDownload(false, this.oKb.oKP);
        AppMethodBeat.o(130434);
      }
    }
    else if (((BitmapUtil.decodeByteArray(localb.data, 10, 10) != null) || (!this.oKb.oKK)) && (this.oKd.a(this.url, localb.data, this.oKb)))
    {
      if (this.oKX != null)
      {
        this.oKX.onImageDownload(true, this.oKb.oKP);
        AppMethodBeat.o(130434);
      }
    }
    else if (this.oKX != null) {
      this.oKX.onImageDownload(false, this.oKb.oKP);
    }
    AppMethodBeat.o(130434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.e.a
 * JD-Core Version:    0.7.0.1
 */