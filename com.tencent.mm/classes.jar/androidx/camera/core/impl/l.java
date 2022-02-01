package androidx.camera.core.impl;

import androidx.camera.core.al;
import androidx.camera.core.impl.a.g.a;

public abstract interface l
{
  public abstract void a(g.a parama);
  
  public abstract long getTimestamp();
  
  public abstract k.e gn();
  
  public abstract bi go();
  
  public static abstract class a
    implements l
  {
    public void a(g.a parama)
    {
      k.e locale = gn();
      if (locale != k.e.Ll) {}
      int i;
      switch (androidx.camera.core.impl.a.g.1.Oz[locale.ordinal()])
      {
      default: 
        "Unknown flash state: ".concat(String.valueOf(locale));
        al.R("ExifData");
        return;
      case 1: 
        i = 0;
      }
      for (;;)
      {
        if ((i & 0x1) == 1) {
          parama.l("LightSource", "4");
        }
        parama.l("Flash", String.valueOf(i));
        return;
        i = 32;
        continue;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.l
 * JD-Core Version:    0.7.0.1
 */