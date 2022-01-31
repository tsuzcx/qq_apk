package com.google.android.exoplayer2.source.b.a;

import java.io.BufferedReader;
import java.util.Queue;

final class d$a
{
  private final BufferedReader aLK;
  private final Queue<String> aLL;
  private String aLM;
  
  public d$a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
  {
    this.aLL = paramQueue;
    this.aLK = paramBufferedReader;
  }
  
  public final boolean hasNext()
  {
    if (this.aLM != null) {
      return true;
    }
    if (!this.aLL.isEmpty())
    {
      this.aLM = ((String)this.aLL.poll());
      return true;
    }
    do
    {
      String str = this.aLK.readLine();
      this.aLM = str;
      if (str == null) {
        break;
      }
      this.aLM = this.aLM.trim();
    } while (this.aLM.isEmpty());
    return true;
    return false;
  }
  
  public final String next()
  {
    if (hasNext())
    {
      String str = this.aLM;
      this.aLM = null;
      return str;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */