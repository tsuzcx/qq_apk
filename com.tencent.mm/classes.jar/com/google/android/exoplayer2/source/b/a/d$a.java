package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.util.Queue;

final class d$a
{
  private final BufferedReader bjf;
  private final Queue<String> bjg;
  private String bjh;
  
  public d$a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
  {
    this.bjg = paramQueue;
    this.bjf = paramBufferedReader;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(62889);
    if (this.bjh != null)
    {
      AppMethodBeat.o(62889);
      return true;
    }
    if (!this.bjg.isEmpty())
    {
      this.bjh = ((String)this.bjg.poll());
      AppMethodBeat.o(62889);
      return true;
    }
    do
    {
      String str = this.bjf.readLine();
      this.bjh = str;
      if (str == null) {
        break;
      }
      this.bjh = this.bjh.trim();
    } while (this.bjh.isEmpty());
    AppMethodBeat.o(62889);
    return true;
    AppMethodBeat.o(62889);
    return false;
  }
  
  public final String tV()
  {
    AppMethodBeat.i(62890);
    String str;
    if (hasNext())
    {
      str = this.bjh;
      this.bjh = null;
    }
    for (;;)
    {
      AppMethodBeat.o(62890);
      return str;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */