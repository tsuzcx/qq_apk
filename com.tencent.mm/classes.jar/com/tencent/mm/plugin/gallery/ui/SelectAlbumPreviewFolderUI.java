package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.LinkedList;

@a(19)
public class SelectAlbumPreviewFolderUI
  extends MMActivity
  implements i.a
{
  ArrayList<GalleryItem.AlbumItem> nhb;
  private SelectAlbumPreviewFolderUI.a nhc;
  private RecyclerView nhd;
  GalleryItem.AlbumItem nhe;
  private String nhf;
  
  public SelectAlbumPreviewFolderUI()
  {
    AppMethodBeat.i(21597);
    this.nhb = new ArrayList(10);
    AppMethodBeat.o(21597);
  }
  
  public final void V(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(21601);
    new ak(Looper.getMainLooper()).post(new SelectAlbumPreviewFolderUI.2(this, paramLinkedList));
    AppMethodBeat.o(21601);
  }
  
  public int getLayoutId()
  {
    return 2130970652;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(21600);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(21600);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21598);
    super.onCreate(paramBundle);
    e.bDQ().b(this);
    e.bDQ().a(this);
    e.bDQ().bEl();
    this.nhd = ((RecyclerView)findViewById(2131827533));
    this.nhc = new SelectAlbumPreviewFolderUI.a(this, this);
    this.nhd.setLayoutManager(new LinearLayoutManager());
    this.nhd.setAdapter(this.nhc);
    this.nhf = getIntent().getStringExtra("select_folder_name");
    this.nhe = new GalleryItem.AlbumItem("", 0);
    this.nhe.ndm = new GalleryItem.ImageMediaItem();
    setMMTitle(bo.nullAsNil(getString(2131296941)));
    setBackBtn(new SelectAlbumPreviewFolderUI.1(this));
    AppMethodBeat.o(21598);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21599);
    super.onDestroy();
    e.bDQ().b(this);
    AppMethodBeat.o(21599);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI
 * JD-Core Version:    0.7.0.1
 */