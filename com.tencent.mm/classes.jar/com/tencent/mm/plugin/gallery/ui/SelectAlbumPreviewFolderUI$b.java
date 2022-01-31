package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class SelectAlbumPreviewFolderUI$b
  extends RecyclerView.v
{
  public TextView eXP;
  public ImageView kHQ;
  public TextView kIS;
  public ImageView kIT;
  public View kKz;
  public ImageView kiI;
  
  public SelectAlbumPreviewFolderUI$b(SelectAlbumPreviewFolderUI paramSelectAlbumPreviewFolderUI, View paramView)
  {
    super(paramView);
    this.kKz = paramView;
    this.kHQ = ((ImageView)this.kKz.findViewById(R.h.folder_thumb));
    this.eXP = ((TextView)this.kKz.findViewById(R.h.folder_name));
    this.kiI = ((ImageView)this.kKz.findViewById(R.h.video_mask));
    this.kIS = ((TextView)this.kKz.findViewById(R.h.folder_count));
    this.kIT = ((ImageView)this.kKz.findViewById(R.h.folder_selected_iv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.b
 * JD-Core Version:    0.7.0.1
 */