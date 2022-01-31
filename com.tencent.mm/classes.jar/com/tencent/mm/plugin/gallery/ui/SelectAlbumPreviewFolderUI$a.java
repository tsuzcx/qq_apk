package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import java.util.ArrayList;

final class SelectAlbumPreviewFolderUI$a
  extends RecyclerView.a<SelectAlbumPreviewFolderUI.b>
  implements View.OnClickListener
{
  Context mContext;
  
  public SelectAlbumPreviewFolderUI$a(SelectAlbumPreviewFolderUI paramSelectAlbumPreviewFolderUI, Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getItemCount()
  {
    return SelectAlbumPreviewFolderUI.a(this.kKF).size() + 1;
  }
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.kKF, AlbumPreviewUI.class);
    localIntent.putExtra("select_folder_name", (GalleryItem.AlbumItem)paramView.getTag());
    localIntent.setFlags(67108864);
    this.kKF.setResult(-1, localIntent);
    this.kKF.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.a
 * JD-Core Version:    0.7.0.1
 */