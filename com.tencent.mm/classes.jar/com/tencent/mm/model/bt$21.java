package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.bk;

final class bt$21
  extends bt.a
{
  bt$21(bt parambt)
  {
    super(parambt, (byte)0);
  }
  
  public final boolean a(br parambr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (System.currentTimeMillis() - parambr.dXA > 86400000L)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bt.21
 * JD-Core Version:    0.7.0.1
 */