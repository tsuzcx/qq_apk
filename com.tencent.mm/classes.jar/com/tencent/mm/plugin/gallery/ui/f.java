package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

final class f
{
  private d CcL;
  private int lL = -1;
  
  public f(d paramd)
  {
    this.CcL = paramd;
  }
  
  private void Tj(int paramInt)
  {
    AppMethodBeat.i(111557);
    d locald = this.CcL;
    if ((locald.BZG == null) || (locald.BZG.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(111557);
      return;
    }
    long l = ((GalleryItem.MediaItem)locald.BZG.get(paramInt)).BVl;
    String str3 = ((GalleryItem.MediaItem)locald.BZG.get(paramInt)).wAy;
    String str2 = ((GalleryItem.MediaItem)locald.BZG.get(paramInt)).AAz;
    String str1 = str3;
    if (Util.isNullOrNil(str3)) {
      str1 = str2;
    }
    e.etk().a(str1, ((GalleryItem.MediaItem)locald.BZG.get(paramInt)).getType(), str2, l, ((GalleryItem.MediaItem)locald.BZG.get(paramInt)).BVm);
    AppMethodBeat.o(111557);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(111558);
    if (this.lL == -1)
    {
      int i = 0;
      if (i == 0) {
        Tj(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label111;
        }
        if (paramInt + i <= paramInt + 3) {
          Tj(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          Tj(paramInt - i);
        }
      }
    }
    if (this.lL > paramInt) {
      Tj(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label111:
      this.lL = paramInt;
      AppMethodBeat.o(111558);
      return;
      if (this.lL < paramInt) {
        Tj(paramInt + 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */