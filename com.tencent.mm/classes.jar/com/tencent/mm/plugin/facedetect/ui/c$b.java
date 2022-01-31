package com.tencent.mm.plugin.facedetect.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.n;
import java.security.InvalidParameterException;

final class c$b
  extends n
{
  public c$b(c paramc, j paramj)
  {
    super(paramj);
  }
  
  public final Fragment ae(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new InvalidParameterException("hy: invalid page status");
    }
    return new c.c(this.jSi);
  }
  
  public final int getCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.c.b
 * JD-Core Version:    0.7.0.1
 */