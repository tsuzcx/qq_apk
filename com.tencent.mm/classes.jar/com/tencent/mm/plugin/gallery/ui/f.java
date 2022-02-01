package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

final class f
{
  private int afo = -1;
  private d tZd;
  
  public f(d paramd)
  {
    this.tZd = paramd;
  }
  
  private void HR(int paramInt)
  {
    AppMethodBeat.i(111557);
    d locald = this.tZd;
    if ((locald.tWe == null) || (locald.tWe.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(111557);
      return;
    }
    long l = ((GalleryItem.MediaItem)locald.tWe.get(paramInt)).tRM;
    String str3 = ((GalleryItem.MediaItem)locald.tWe.get(paramInt)).ruE;
    String str2 = ((GalleryItem.MediaItem)locald.tWe.get(paramInt)).tRJ;
    String str1 = str3;
    if (bu.isNullOrNil(str3)) {
      str1 = str2;
    }
    e.cXq().a(str1, ((GalleryItem.MediaItem)locald.tWe.get(paramInt)).getType(), str2, l, ((GalleryItem.MediaItem)locald.tWe.get(paramInt)).tRN);
    AppMethodBeat.o(111557);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111558);
    if (this.afo == -1)
    {
      int i = 0;
      if (i == 0) {
        HR(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label111;
        }
        if (paramInt + i <= paramInt + 3) {
          HR(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          HR(paramInt - i);
        }
      }
    }
    if (this.afo > paramInt) {
      HR(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label111:
      this.afo = paramInt;
      AppMethodBeat.o(111558);
      return;
      if (this.afo < paramInt) {
        HR(paramInt + 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */