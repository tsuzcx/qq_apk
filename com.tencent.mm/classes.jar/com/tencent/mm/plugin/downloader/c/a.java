package com.tencent.mm.plugin.downloader.c;

import android.util.Pair;
import java.nio.ByteBuffer;

public final class a
{
  public long iOB;
  public Pair<ByteBuffer, Long> iOC;
  public Pair<ByteBuffer, Long> iOD;
  public Pair<ByteBuffer, Long> iOE;
  public Pair<ByteBuffer, Long> iOF;
  public boolean lowMemory = false;
  
  public final String toString()
  {
    return "lowMemory : " + this.lowMemory + "\n apkSize : " + this.iOB + "\n contentEntry : " + this.iOC + "\n schemeV2Block : " + this.iOD + "\n centralDir : " + this.iOE + "\n eocd : " + this.iOF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a
 * JD-Core Version:    0.7.0.1
 */