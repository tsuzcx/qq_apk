package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

final class f
{
  private int acD = -1;
  private d rJT;
  
  public f(d paramd)
  {
    this.rJT = paramd;
  }
  
  private void Ej(int paramInt)
  {
    AppMethodBeat.i(111557);
    d locald = this.rJT;
    if ((locald.rGU == null) || (locald.rGU.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(111557);
      return;
    }
    long l = ((GalleryItem.MediaItem)locald.rGU.get(paramInt)).rBs;
    String str3 = ((GalleryItem.MediaItem)locald.rGU.get(paramInt)).pUe;
    String str2 = ((GalleryItem.MediaItem)locald.rGU.get(paramInt)).rBp;
    String str1 = str3;
    if (bt.isNullOrNil(str3)) {
      str1 = str2;
    }
    e.czg().a(str1, ((GalleryItem.MediaItem)locald.rGU.get(paramInt)).getType(), str2, l, ((GalleryItem.MediaItem)locald.rGU.get(paramInt)).rBt);
    AppMethodBeat.o(111557);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111558);
    if (this.acD == -1)
    {
      int i = 0;
      if (i == 0) {
        Ej(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label111;
        }
        if (paramInt + i <= paramInt + 3) {
          Ej(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          Ej(paramInt - i);
        }
      }
    }
    if (this.acD > paramInt) {
      Ej(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label111:
      this.acD = paramInt;
      AppMethodBeat.o(111558);
      return;
      if (this.acD < paramInt) {
        Ej(paramInt + 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */