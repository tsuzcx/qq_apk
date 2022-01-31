package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.mm.sdk.platformtools.bk;

final class j
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
      if (Build.DISPLAY.startsWith("Flyme"))
      {
        locala.rotate = 90;
        locala.dwJ.setDisplayOrientation(90);
      }
      label150:
      for (;;)
      {
        return locala;
        int i;
        if (!Build.MODEL.equals("M9")) {
          i = -1;
        }
        for (;;)
        {
          if (i < 7093) {
            break label150;
          }
          locala.rotate = 90;
          locala.dwJ.setDisplayOrientation(180);
          break;
          Object localObject = Build.DISPLAY;
          if (((String)localObject).substring(0, 0).equals("1"))
          {
            i = -1;
          }
          else
          {
            localObject = ((String)localObject).split("-");
            if ((localObject == null) || (localObject.length < 2)) {
              i = -1;
            } else {
              i = bk.getInt(localObject[1], 0);
            }
          }
        }
      }
      return null;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.e.j
 * JD-Core Version:    0.7.0.1
 */