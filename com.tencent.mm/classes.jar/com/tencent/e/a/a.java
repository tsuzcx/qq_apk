package com.tencent.e.a;

import android.util.Log;

final class a
  implements b.a
{
  public final boolean isLoggable(String paramString, int paramInt)
  {
    return Log.isLoggable(paramString, paramInt);
  }
  
  public final void println(int paramInt, String paramString1, String paramString2)
  {
    Log.println(paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.a.a
 * JD-Core Version:    0.7.0.1
 */