package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.LinkedList;

@a(19)
public class SelectAlbumPreviewFolderUI
  extends MMActivity
  implements i.a
{
  ArrayList<GalleryItem.AlbumItem> rLf;
  private a rLg;
  private RecyclerView rLh;
  GalleryItem.AlbumItem rLi;
  private String rLj;
  
  public SelectAlbumPreviewFolderUI()
  {
    AppMethodBeat.i(111665);
    this.rLf = new ArrayList(10);
    AppMethodBeat.o(111665);
  }
  
  public final void ah(final LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111669);
    e.czi().f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111659);
        SelectAlbumPreviewFolderUI.a(SelectAlbumPreviewFolderUI.this).addAll(paramLinkedList);
        SelectAlbumPreviewFolderUI.b(SelectAlbumPreviewFolderUI.this).aql.notifyChanged();
        AppMethodBeat.o(111659);
      }
    });
    AppMethodBeat.o(111669);
  }
  
  public int getLayoutId()
  {
    return 2131495347;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(111668);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(111668);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111666);
    super.onCreate(paramBundle);
    e.czh().b(this);
    e.czh().a(this);
    e.czh().czP();
    this.rLh = ((RecyclerView)findViewById(2131300184));
    this.rLg = new a(this);
    this.rLh.setLayoutManager(new LinearLayoutManager());
    this.rLh.setAdapter(this.rLg);
    this.rLj = getIntent().getStringExtra("select_folder_name");
    this.rLi = new GalleryItem.AlbumItem("", 0);
    this.rLi.Lmj = new GalleryItem.ImageMediaItem();
    setMMTitle(bt.nullAsNil(getString(2131755750)));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(111658);
        SelectAlbumPreviewFolderUI.this.finish();
        AppMethodBeat.o(111658);
        return false;
      }
    });
    AppMethodBeat.o(111666);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111667);
    super.onDestroy();
    e.czh().b(this);
    AppMethodBeat.o(111667);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends RecyclerView.a<SelectAlbumPreviewFolderUI.b>
    implements View.OnClickListener
  {
    Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111660);
      int i = SelectAlbumPreviewFolderUI.a(SelectAlbumPreviewFolderUI.this).size();
      AppMethodBeat.o(111660);
      return i + 1;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(111661);
      Intent localIntent = new Intent(SelectAlbumPreviewFolderUI.this, AlbumPreviewUI.class);
      localIntent.putExtra("select_folder_name", (GalleryItem.AlbumItem)paramView.getTag());
      localIntent.setFlags(67108864);
      SelectAlbumPreviewFolderUI.this.setResult(-1, localIntent);
      SelectAlbumPreviewFolderUI.this.finish();
      AppMethodBeat.o(111661);
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public TextView hJe;
    public ImageView qkZ;
    public TextView rIT;
    public ImageView rIU;
    public View rLd;
    public ImageView rww;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(111664);
      this.rLd = paramView;
      this.rww = ((ImageView)this.rLd.findViewById(2131300187));
      this.hJe = ((TextView)this.rLd.findViewById(2131300182));
      this.qkZ = ((ImageView)this.rLd.findViewById(2131306355));
      this.rIT = ((TextView)this.rLd.findViewById(2131300178));
      this.rIU = ((ImageView)this.rLd.findViewById(2131300186));
      AppMethodBeat.o(111664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI
 * JD-Core Version:    0.7.0.1
 */