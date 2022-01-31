package com.tencent.mm.compatible.e;

import android.hardware.Camera;

final class e
  implements d.a
{
  public static d.a.a yO()
  {
    d.a.a locala = new d.a.a();
    try
    {
      locala.dwJ = Camera.open();
      locala.rotate = 0;
      if (locala.dwJ == null) {
        return null;
      }
      return locala;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.e.e
 * JD-Core Version:    0.7.0.1
 */