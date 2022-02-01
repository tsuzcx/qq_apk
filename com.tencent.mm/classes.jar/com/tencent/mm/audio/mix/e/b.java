package com.tencent.mm.audio.mix.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements g
{
  private boolean dvV = false;
  private e dvW;
  private com.tencent.mm.ai.b dvk;
  private volatile boolean stop = true;
  
  public b(e parame)
  {
    this.dvW = parame;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(198117);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "download process end, download finish:%b", new Object[] { Boolean.valueOf(this.dvV) });
    d.b(paramc);
    if (this.dvV) {
      if (this.dvW != null) {
        this.dvW.c(this.dvk);
      }
    }
    for (;;)
    {
      this.stop = true;
      paramc.dvY = null;
      this.dvW = null;
      AppMethodBeat.o(198117);
      return;
      if (this.dvW != null) {
        this.dvW.d(this.dvk);
      }
    }
  }
  
  public final void a(com.tencent.mm.audio.mix.h.c paramc)
  {
    AppMethodBeat.i(198116);
    this.stop = false;
    if (paramc == null)
    {
      if (this.dvW != null) {
        this.dvW.d(null);
      }
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDownloadProcess", "process source is null");
      this.stop = true;
      AppMethodBeat.o(198116);
      return;
    }
    this.dvV = false;
    Object localObject1 = paramc.ZU();
    if (localObject1 != null) {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "audio:%s, url:%s", new Object[] { ((com.tencent.mm.ai.b)localObject1).dtX, ((com.tencent.mm.ai.b)localObject1).dvn });
    }
    this.dvk = ((com.tencent.mm.ai.b)localObject1);
    paramc.connect();
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "source connect, stop:%b", new Object[] { Boolean.valueOf(this.stop) });
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
        localObject2 = paramc.ZV();
      }
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "fileSize:%d, mimetype:%s, tryCount:%d", new Object[] { Long.valueOf(l), localObject2, Integer.valueOf(i) });
      if ((l > 0L) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains("text/")))
        {
          com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDownloadProcess", "mimetype not support");
          paramc.disconnect();
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "source disconnect");
          AppMethodBeat.o(198116);
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
              com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDownloadProcess", "readSize:%d, terminal process or read end", new Object[] { Integer.valueOf(j) });
            }
          }
          else
          {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDownloadProcess", "offSize:%d", new Object[] { Integer.valueOf(i) });
            this.dvV = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.b
 * JD-Core Version:    0.7.0.1
 */