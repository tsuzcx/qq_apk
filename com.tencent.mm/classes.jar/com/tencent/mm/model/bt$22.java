package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.bk;

final class bt$22
  extends bt.a
{
  bt$22(bt parambt)
  {
    super(parambt, (byte)0);
  }
  
  public final boolean a(br parambr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (System.currentTimeMillis() - parambr.dXA > 1800000L)
    {
      bool1 = bool2;
      if (bk.getInt(parambr.dXz, 0) > 0)
      {
        bt.o(parambr.key, parambr.dXz);
        parambr.dXz = "0";
        parambr.dXA = System.currentTimeMillis();
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bt.22
 * JD-Core Version:    0.7.0.1
 */