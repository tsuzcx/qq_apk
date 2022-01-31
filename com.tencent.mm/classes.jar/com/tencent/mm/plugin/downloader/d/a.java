package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a
{
  public long kXs;
  public Pair<ByteBuffer, Long> kXt;
  public Pair<ByteBuffer, Long> kXu;
  public Pair<ByteBuffer, Long> kXv;
  public Pair<ByteBuffer, Long> kXw;
  public boolean lowMemory = false;
  
  public final String toString()
  {
    AppMethodBeat.i(2301);
    String str = "lowMemory : " + this.lowMemory + "\n apkSize : " + this.kXs + "\n contentEntry : " + this.kXt + "\n schemeV2Block : " + this.kXu + "\n centralDir : " + this.kXv + "\n eocd : " + this.kXw;
    AppMethodBeat.o(2301);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.a
 * JD-Core Version:    0.7.0.1
 */