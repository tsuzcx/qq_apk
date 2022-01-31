package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Vector;

final class d$2
  implements d.b
{
  d$2(d paramd) {}
  
  public final void PA(String paramString)
  {
    AppMethodBeat.i(21241);
    ab.i("MicroMsg.GalleryCache", "now listener size : " + this.ncN.gjA.size());
    int i = this.ncN.gjA.size() - 1;
    for (;;)
    {
      if (i >= 0) {
        try
        {
          d.b localb = (d.b)this.ncN.gjA.get(i);
          if (localb == null)
          {
            ab.d("MicroMsg.GalleryCache", "get listener is null! filePath:%s", new Object[] { paramString });
            i -= 1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.GalleryCache", "get wathcer failed:[%s] filePath:%s", new Object[] { localException.toString(), paramString });
            Object localObject = null;
            continue;
            localObject.PA(paramString);
          }
        }
      }
    }
    AppMethodBeat.o(21241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.d.2
 * JD-Core Version:    0.7.0.1
 */