package com.tencent.mm.plugin.ab;

import com.tencent.mm.model.p;
import com.tencent.mm.modelcontrol.c;

public final class a
  extends p
{
  private static a mRK;
  
  private a()
  {
    super(c.class);
  }
  
  public static a brM()
  {
    try
    {
      if (mRK == null) {
        mRK = new a();
      }
      a locala = mRK;
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.a
 * JD-Core Version:    0.7.0.1
 */