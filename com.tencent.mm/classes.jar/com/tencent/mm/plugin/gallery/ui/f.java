package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;

final class f
{
  private int adx = -1;
  private d sRI;
  
  public f(d paramd)
  {
    this.sRI = paramd;
  }
  
  private void Gf(int paramInt)
  {
    AppMethodBeat.i(111557);
    d locald = this.sRI;
    if ((locald.sOJ == null) || (locald.sOJ.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(111557);
      return;
    }
    long l = ((GalleryItem.MediaItem)locald.sOJ.get(paramInt)).sKk;
    String str3 = ((GalleryItem.MediaItem)locald.sOJ.get(paramInt)).qCJ;
    String str2 = ((GalleryItem.MediaItem)locald.sOJ.get(paramInt)).sKh;
    String str1 = str3;
    if (bs.isNullOrNil(str3)) {
      str1 = str2;
    }
    e.cMs().a(str1, ((GalleryItem.MediaItem)locald.sOJ.get(paramInt)).getType(), str2, l, ((GalleryItem.MediaItem)locald.sOJ.get(paramInt)).sKl);
    AppMethodBeat.o(111557);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111558);
    if (this.adx == -1)
    {
      int i = 0;
      if (i == 0) {
        Gf(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label111;
        }
        if (paramInt + i <= paramInt + 3) {
          Gf(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          Gf(paramInt - i);
        }
      }
    }
    if (this.adx > paramInt) {
      Gf(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label111:
      this.adx = paramInt;
      AppMethodBeat.o(111558);
      return;
      if (this.adx < paramInt) {
        Gf(paramInt + 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */