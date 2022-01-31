package com.tencent.mm.plugin.emojicapture.e;

import a.d.b.g;
import com.tencent.mm.plugin.emojicapture.c.a.b;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$f
  implements am.a
{
  a$f(a parama) {}
  
  public final boolean tC()
  {
    boolean bool = false;
    Object localObject;
    if (this.jme.jlY != null)
    {
      localObject = this.jme.jlY;
      if (localObject != null)
      {
        localObject = Integer.valueOf(((VoiceInputProxy)localObject).getMaxAmplitudeRate());
        if (localObject == null) {
          g.cUk();
        }
      }
    }
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      y.d(this.jme.TAG, "voice detect " + i);
      localObject = this.jme.jma;
      if (i > 10) {
        bool = true;
      }
      ((a.b)localObject).fr(bool);
      return true;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a.f
 * JD-Core Version:    0.7.0.1
 */