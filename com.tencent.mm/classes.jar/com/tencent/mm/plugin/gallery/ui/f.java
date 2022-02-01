package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

final class f
{
  private int afB = -1;
  private d xqr;
  
  public f(d paramd)
  {
    this.xqr = paramd;
  }
  
  private void NU(int paramInt)
  {
    AppMethodBeat.i(111557);
    d locald = this.xqr;
    if ((locald.xno == null) || (locald.xno.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(111557);
      return;
    }
    long l = ((GalleryItem.MediaItem)locald.xno.get(paramInt)).xiZ;
    String str3 = ((GalleryItem.MediaItem)locald.xno.get(paramInt)).sUB;
    String str2 = ((GalleryItem.MediaItem)locald.xno.get(paramInt)).xiW;
    String str1 = str3;
    if (Util.isNullOrNil(str3)) {
      str1 = str2;
    }
    e.dQJ().a(str1, ((GalleryItem.MediaItem)locald.xno.get(paramInt)).getType(), str2, l, ((GalleryItem.MediaItem)locald.xno.get(paramInt)).xja);
    AppMethodBeat.o(111557);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111558);
    if (this.afB == -1)
    {
      int i = 0;
      if (i == 0) {
        NU(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label111;
        }
        if (paramInt + i <= paramInt + 3) {
          NU(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          NU(paramInt - i);
        }
      }
    }
    if (this.afB > paramInt) {
      NU(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label111:
      this.afB = paramInt;
      AppMethodBeat.o(111558);
      return;
      if (this.afB < paramInt) {
        NU(paramInt + 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */