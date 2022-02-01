package com.tencent.live2.impl;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a$c
{
  public Bitmap a;
  public int b = 5;
  public boolean c = true;
  public boolean d = false;
  public int e = 300;
  
  public String toString()
  {
    AppMethodBeat.i(211529);
    String str = "[fps:" + this.b + "][pauseVideo:" + this.c + "][pauseAudio:" + this.d + "][duration:" + this.e + "]";
    AppMethodBeat.o(211529);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.impl.a.c
 * JD-Core Version:    0.7.0.1
 */