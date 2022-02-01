package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

final class f
{
  private int afo = -1;
  private d tOm;
  
  public f(d paramd)
  {
    this.tOm = paramd;
  }
  
  private void Hu(int paramInt)
  {
    AppMethodBeat.i(111557);
    d locald = this.tOm;
    if ((locald.tLn == null) || (locald.tLn.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(111557);
      return;
    }
    long l = ((GalleryItem.MediaItem)locald.tLn.get(paramInt)).tGV;
    String str3 = ((GalleryItem.MediaItem)locald.tLn.get(paramInt)).rmz;
    String str2 = ((GalleryItem.MediaItem)locald.tLn.get(paramInt)).tGS;
    String str1 = str3;
    if (bt.isNullOrNil(str3)) {
      str1 = str2;
    }
    e.cUL().a(str1, ((GalleryItem.MediaItem)locald.tLn.get(paramInt)).getType(), str2, l, ((GalleryItem.MediaItem)locald.tLn.get(paramInt)).tGW);
    AppMethodBeat.o(111557);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111558);
    if (this.afo == -1)
    {
      int i = 0;
      if (i == 0) {
        Hu(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label111;
        }
        if (paramInt + i <= paramInt + 3) {
          Hu(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          Hu(paramInt - i);
        }
      }
    }
    if (this.afo > paramInt) {
      Hu(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label111:
      this.afo = paramInt;
      AppMethodBeat.o(111558);
      return;
      if (this.afo < paramInt) {
        Hu(paramInt + 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */