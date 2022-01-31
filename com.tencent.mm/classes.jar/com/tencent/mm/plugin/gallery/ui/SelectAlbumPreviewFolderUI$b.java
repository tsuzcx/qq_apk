package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectAlbumPreviewFolderUI$b
  extends RecyclerView.v
{
  public TextView gpM;
  public ImageView mDn;
  public ImageView mZY;
  public TextView nfp;
  public ImageView nfq;
  public View ngZ;
  
  public SelectAlbumPreviewFolderUI$b(SelectAlbumPreviewFolderUI paramSelectAlbumPreviewFolderUI, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(21596);
    this.ngZ = paramView;
    this.mZY = ((ImageView)this.ngZ.findViewById(2131827461));
    this.gpM = ((TextView)this.ngZ.findViewById(2131827462));
    this.mDn = ((ImageView)this.ngZ.findViewById(2131825137));
    this.nfp = ((TextView)this.ngZ.findViewById(2131827463));
    this.nfq = ((ImageView)this.ngZ.findViewById(2131827464));
    AppMethodBeat.o(21596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.b
 * JD-Core Version:    0.7.0.1
 */