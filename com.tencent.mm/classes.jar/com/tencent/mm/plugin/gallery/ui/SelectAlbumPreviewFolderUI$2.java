package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;

final class SelectAlbumPreviewFolderUI$2
  implements Runnable
{
  SelectAlbumPreviewFolderUI$2(SelectAlbumPreviewFolderUI paramSelectAlbumPreviewFolderUI, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(21591);
    SelectAlbumPreviewFolderUI.a(this.nhg).addAll(this.nhh);
    SelectAlbumPreviewFolderUI.b(this.nhg).ajb.notifyChanged();
    AppMethodBeat.o(21591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.2
 * JD-Core Version:    0.7.0.1
 */