package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.util.Queue;

final class d$a
{
  private final BufferedReader aTe;
  private final Queue<String> aTf;
  private String aTg;
  
  public d$a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
  {
    this.aTf = paramQueue;
    this.aTe = paramBufferedReader;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(125965);
    if (this.aTg != null)
    {
      AppMethodBeat.o(125965);
      return true;
    }
    if (!this.aTf.isEmpty())
    {
      this.aTg = ((String)this.aTf.poll());
      AppMethodBeat.o(125965);
      return true;
    }
    do
    {
      String str = this.aTe.readLine();
      this.aTg = str;
      if (str == null) {
        break;
      }
      this.aTg = this.aTg.trim();
    } while (this.aTg.isEmpty());
    AppMethodBeat.o(125965);
    return true;
    AppMethodBeat.o(125965);
    return false;
  }
  
  public final String next()
  {
    AppMethodBeat.i(125966);
    String str;
    if (hasNext())
    {
      str = this.aTg;
      this.aTg = null;
    }
    for (;;)
    {
      AppMethodBeat.o(125966);
      return str;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */