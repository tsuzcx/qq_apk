package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.util.Queue;

final class d$a
{
  private final BufferedReader bph;
  private final Queue<String> bpi;
  private String bpj;
  
  public d$a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
  {
    this.bpi = paramQueue;
    this.bph = paramBufferedReader;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(62889);
    if (this.bpj != null)
    {
      AppMethodBeat.o(62889);
      return true;
    }
    if (!this.bpi.isEmpty())
    {
      this.bpj = ((String)this.bpi.poll());
      AppMethodBeat.o(62889);
      return true;
    }
    do
    {
      String str = this.bph.readLine();
      this.bpj = str;
      if (str == null) {
        break;
      }
      this.bpj = this.bpj.trim();
    } while (this.bpj.isEmpty());
    AppMethodBeat.o(62889);
    return true;
    AppMethodBeat.o(62889);
    return false;
  }
  
  public final String next()
  {
    AppMethodBeat.i(62890);
    String str;
    if (hasNext())
    {
      str = this.bpj;
      this.bpj = null;
    }
    for (;;)
    {
      AppMethodBeat.o(62890);
      return str;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */