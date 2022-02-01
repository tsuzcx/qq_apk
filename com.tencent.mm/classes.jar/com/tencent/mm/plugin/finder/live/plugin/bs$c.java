package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveRandomMatchLinkMicStatePlugin$ItemData;", "", "bitmap", "Landroid/graphics/Bitmap;", "url", "", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
final class bs$c
{
  Bitmap bitmap = null;
  String url = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(353790);
    if (this == paramObject)
    {
      AppMethodBeat.o(353790);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(353790);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.bitmap, paramObject.bitmap))
    {
      AppMethodBeat.o(353790);
      return false;
    }
    if (!s.p(this.url, paramObject.url))
    {
      AppMethodBeat.o(353790);
      return false;
    }
    AppMethodBeat.o(353790);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(353783);
    int i;
    if (this.bitmap == null)
    {
      i = 0;
      if (this.url != null) {
        break label46;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(353783);
      return i * 31 + j;
      i = this.bitmap.hashCode();
      break;
      label46:
      j = this.url.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(353780);
    String str = "ItemData(bitmap=" + this.bitmap + ", url=" + this.url + ')';
    AppMethodBeat.o(353780);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bs.c
 * JD-Core Version:    0.7.0.1
 */