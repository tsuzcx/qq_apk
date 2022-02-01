package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

final class bq$c
  implements Closeable
{
  FileChannel luL;
  ByteBuffer luM;
  long luN;
  long luO;
  
  bq$c()
  {
    AppMethodBeat.i(178869);
    q localq = new q(MMApplicationContext.getContext().getCacheDir(), "asyncClearMsgStat");
    try
    {
      this.luL = u.a(localq.getUri(), true).getChannel();
      this.luM = ByteBuffer.allocate(8);
      this.luL.read(this.luM, 0L);
      if (this.luM.remaining() == 8) {
        this.luN = this.luM.getLong(0);
      }
      this.luM.clear();
      AppMethodBeat.o(178869);
      return;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", localIOException, "Cannot init time statistics", new Object[0]);
      ad.closeQuietly(this.luL);
      this.luL = null;
      AppMethodBeat.o(178869);
    }
  }
  
  static void reset()
  {
    AppMethodBeat.i(178872);
    new q(MMApplicationContext.getContext().getCacheDir(), "asyncClearMsgStat").cFq();
    AppMethodBeat.o(178872);
  }
  
  public final void close()
  {
    AppMethodBeat.i(178871);
    this.luL.close();
    AppMethodBeat.o(178871);
  }
  
  final void end()
  {
    AppMethodBeat.i(178870);
    if (this.luO == 0L)
    {
      AppMethodBeat.o(178870);
      return;
    }
    this.luN = (System.currentTimeMillis() - this.luO + this.luN);
    if (this.luL != null) {
      this.luM.putLong(0, this.luN);
    }
    try
    {
      this.luL.write(this.luM, 0L);
      this.luM.clear();
      this.luO = 0L;
      AppMethodBeat.o(178870);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MsgInfoStorageLogic", "Cannot update time statistics: " + localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bq.c
 * JD-Core Version:    0.7.0.1
 */