package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageFolderMgrView$4
  implements Runnable
{
  ImageFolderMgrView$4(ImageFolderMgrView paramImageFolderMgrView) {}
  
  public final void run()
  {
    AppMethodBeat.i(21475);
    ImageFolderMgrView.d(this.nfM).notifyDataSetChanged();
    AppMethodBeat.o(21475);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(21476);
    String str = super.toString() + "|onQueryAlbumFinished";
    AppMethodBeat.o(21476);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.4
 * JD-Core Version:    0.7.0.1
 */