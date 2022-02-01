package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

final class f
{
  private d HOO;
  private int mI = -1;
  
  public f(d paramd)
  {
    this.HOO = paramd;
  }
  
  private void WR(int paramInt)
  {
    AppMethodBeat.i(111557);
    d locald = this.HOO;
    if ((locald.HLA == null) || (locald.HLA.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(111557);
      return;
    }
    long l = ((GalleryItem.MediaItem)locald.HLA.get(paramInt)).HHJ;
    String str3 = ((GalleryItem.MediaItem)locald.HLA.get(paramInt)).zWJ;
    String str2 = ((GalleryItem.MediaItem)locald.HLA.get(paramInt)).Gcc;
    String str1 = str3;
    if (Util.isNullOrNil(str3)) {
      str1 = str2;
    }
    e.fAm().a(str1, ((GalleryItem.MediaItem)locald.HLA.get(paramInt)).getType(), str2, l, ((GalleryItem.MediaItem)locald.HLA.get(paramInt)).HHK);
    AppMethodBeat.o(111557);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111558);
    if (this.mI == -1)
    {
      int i = 0;
      if (i == 0) {
        WR(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label111;
        }
        if (paramInt + i <= paramInt + 3) {
          WR(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          WR(paramInt - i);
        }
      }
    }
    if (this.mI > paramInt) {
      WR(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label111:
      this.mI = paramInt;
      AppMethodBeat.o(111558);
      return;
      if (this.mI < paramInt) {
        WR(paramInt + 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */