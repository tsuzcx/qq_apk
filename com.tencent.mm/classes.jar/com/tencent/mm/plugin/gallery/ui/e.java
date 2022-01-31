package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class e
{
  int Vy = -1;
  private c nfZ;
  
  public e(c paramc)
  {
    this.nfZ = paramc;
  }
  
  final void wX(int paramInt)
  {
    AppMethodBeat.i(21496);
    c localc = this.nfZ;
    if ((localc.ndM == null) || (localc.ndM.size() <= paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(21496);
      return;
    }
    long l = ((GalleryItem.MediaItem)localc.ndM.get(paramInt)).ndp;
    String str3 = ((GalleryItem.MediaItem)localc.ndM.get(paramInt)).mnt;
    String str2 = ((GalleryItem.MediaItem)localc.ndM.get(paramInt)).fQn;
    String str1 = str3;
    if (bo.isNullOrNil(str3)) {
      str1 = str2;
    }
    com.tencent.mm.plugin.gallery.model.e.bDP().b(str1, ((GalleryItem.MediaItem)localc.ndM.get(paramInt)).getType(), str2, l);
    AppMethodBeat.o(21496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.e
 * JD-Core Version:    0.7.0.1
 */