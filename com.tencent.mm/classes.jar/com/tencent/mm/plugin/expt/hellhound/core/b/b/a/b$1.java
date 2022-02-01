package com.tencent.mm.plugin.expt.hellhound.core.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.sdk.platformtools.ac;

final class b$1
  implements c
{
  b$1(b paramb) {}
  
  public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(184336);
    if ("onPostOpen".equals(paramString2))
    {
      if (paramArrayOfObject.length > 0)
      {
        ac.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostOpen: %b", new Object[] { paramArrayOfObject[0] });
        b.a(this.qjU, 0, System.currentTimeMillis());
        AppMethodBeat.o(184336);
      }
    }
    else if ("onPostClose".equals(paramString2))
    {
      ac.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostClose:");
      b.a(this.qjU, 1, System.currentTimeMillis());
    }
    AppMethodBeat.o(184336);
  }
  
  public final void f(String paramString, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.1
 * JD-Core Version:    0.7.0.1
 */