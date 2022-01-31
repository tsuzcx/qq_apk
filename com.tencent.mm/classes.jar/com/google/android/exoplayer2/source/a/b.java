package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.h.q.e;

public final class b
{
  public static boolean a(Exception paramException)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramException instanceof q.e))
    {
      int i = ((q.e)paramException).responseCode;
      if (i != 404)
      {
        bool1 = bool2;
        if (i != 410) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.b
 * JD-Core Version:    0.7.0.1
 */