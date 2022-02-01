package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements g
{
  private boolean hsO = false;
  private e hsP;
  private com.tencent.mm.al.b hsd;
  private volatile boolean stop = true;
  
  public b(e parame)
  {
    this.hsP = parame;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(236207);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDownloadProcess", "download process end, download finish:%b", new Object[] { Boolean.valueOf(this.hsO) });
    d.b(paramc);
    if (this.hsO) {
      if (this.hsP != null) {
        this.hsP.c(this.hsd);
      }
    }
    for (;;)
    {
      this.stop = true;
      paramc.hsR = null;
      this.hsP = null;
      AppMethodBeat.o(236207);
      return;
      if (this.hsP != null) {
        this.hsP.d(this.hsd);
      }
    }
  }
  
  public final void a(com.tencent.mm.audio.mix.g.c paramc)
  {
    AppMethodBeat.i(236204);
    this.stop = false;
    if (paramc == null)
    {
      if (this.hsP != null) {
        this.hsP.d(null);
      }
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDownloadProcess", "process source is null");
      this.stop = true;
      AppMethodBeat.o(236204);
      return;
    }
    this.hsO = false;
    Object localObject1 = paramc.aGB();
    if (localObject1 != null) {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDownloadProcess", "audio:%s, url:%s", new Object[] { ((com.tencent.mm.al.b)localObject1).hqQ, ((com.tencent.mm.al.b)localObject1).hsg });
    }
    this.hsd = ((com.tencent.mm.al.b)localObject1);
    paramc.connect();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDownloadProcess", "source connect, stop:%b", new Object[] { Boolean.valueOf(this.stop) });
    localObject1 = "";
    long l = -1L;
    int i = 0;
    if ((i < 3) && (!this.stop))
    {
      i += 1;
      if (l > 0L) {
        break label380;
      }
      l = paramc.getSize();
    }
    label380:
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramc.aGC();
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDownloadProcess", "fileSize:%d, mimetype:%s, tryCount:%d", new Object[] { Long.valueOf(l), localObject2, Integer.valueOf(i) });
      if ((l > 0L) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains("text/")))
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDownloadProcess", "mimetype not support");
          paramc.disconnect();
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDownloadProcess", "source disconnect");
          AppMethodBeat.o(236204);
          return;
        }
        localObject1 = new byte[8192];
        i = 0;
        for (;;)
        {
          int j;
          if ((i < l) && (!this.stop))
          {
            j = paramc.readAt(i, (byte[])localObject1, 0, 8192);
            if (j < 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDownloadProcess", "readSize:%d, terminal process or read end", new Object[] { Integer.valueOf(j) });
            }
          }
          else
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDownloadProcess", "offSize:%d", new Object[] { Integer.valueOf(i) });
            this.hsO = true;
            break;
          }
          i += j;
        }
      }
      localObject1 = localObject2;
      break;
    }
  }
  
  public final void stop()
  {
    this.stop = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.b
 * JD-Core Version:    0.7.0.1
 */