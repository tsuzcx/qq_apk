package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(19)
public class SelectAlbumPreviewFolderUI
  extends MMActivity
  implements g.a
{
  ArrayList<GalleryItem.AlbumItem> kIO = new ArrayList(0);
  private SelectAlbumPreviewFolderUI.a kKB;
  private RecyclerView kKC;
  GalleryItem.AlbumItem kKD;
  private String kKE;
  
  protected final int getLayoutId()
  {
    return R.i.select_image_folder_ui;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c.aXb().b(this);
    c.aXb().a(this);
    c.aXb().aXG();
    this.kKC = ((RecyclerView)findViewById(R.h.folder_recycler_view));
    this.kKB = new SelectAlbumPreviewFolderUI.a(this, this);
    this.kKC.setLayoutManager(new LinearLayoutManager());
    this.kKC.setAdapter(this.kKB);
    this.kKE = getIntent().getStringExtra("select_folder_name");
    this.kKD = new GalleryItem.AlbumItem("", 0);
    this.kKD.kGU = new GalleryItem.ImageMediaItem();
    setMMTitle(bk.pm(getString(R.l.app_field_new_pic)));
    setBackBtn(new SelectAlbumPreviewFolderUI.1(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c.aXb().b(this);
  }
  
  public final void z(ArrayList<GalleryItem.AlbumItem> paramArrayList)
  {
    new ah(Looper.getMainLooper()).post(new SelectAlbumPreviewFolderUI.2(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI
 * JD-Core Version:    0.7.0.1
 */