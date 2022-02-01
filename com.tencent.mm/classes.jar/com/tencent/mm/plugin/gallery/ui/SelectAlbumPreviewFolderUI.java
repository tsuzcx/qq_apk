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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(19)
public class SelectAlbumPreviewFolderUI
  extends MMActivity
  implements i.a
{
  ArrayList<GalleryItem.AlbumItem> xrD;
  private a xrE;
  private RecyclerView xrF;
  GalleryItem.AlbumItem xrG;
  private String xrH;
  
  public SelectAlbumPreviewFolderUI()
  {
    AppMethodBeat.i(111665);
    this.xrD = new ArrayList(10);
    AppMethodBeat.o(111665);
  }
  
  public final void aL(final LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111669);
    e.dQL().postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111659);
        SelectAlbumPreviewFolderUI.a(SelectAlbumPreviewFolderUI.this).addAll(paramLinkedList);
        SelectAlbumPreviewFolderUI.b(SelectAlbumPreviewFolderUI.this).atj.notifyChanged();
        AppMethodBeat.o(111659);
      }
    });
    AppMethodBeat.o(111669);
  }
  
  public int getLayoutId()
  {
    return 2131496208;
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
    e.dQK().b(this);
    e.dQK().a(this);
    e.dQK().dRr();
    this.xrF = ((RecyclerView)findViewById(2131301640));
    this.xrE = new a(this);
    this.xrF.setLayoutManager(new LinearLayoutManager());
    this.xrF.setAdapter(this.xrE);
    this.xrH = getIntent().getStringExtra("select_folder_name");
    this.xrG = new GalleryItem.AlbumItem("", 0);
    this.xrG.UpZ = new GalleryItem.ImageMediaItem();
    setMMTitle(Util.nullAsNil(getString(2131755825)));
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
    e.dQK().b(this);
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
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SelectAlbumPreviewFolderUI$SelectImageFolderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = new Intent(SelectAlbumPreviewFolderUI.this, AlbumPreviewUI.class);
      ((Intent)localObject).putExtra("select_folder_name", (GalleryItem.AlbumItem)paramView.getTag());
      ((Intent)localObject).setFlags(67108864);
      SelectAlbumPreviewFolderUI.this.setResult(-1, (Intent)localObject);
      SelectAlbumPreviewFolderUI.this.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SelectAlbumPreviewFolderUI$SelectImageFolderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111661);
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    public View convertView;
    public TextView jBR;
    public ImageView tlC;
    public ImageView xdY;
    public TextView xpr;
    public ImageView xps;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(111664);
      this.convertView = paramView;
      this.xdY = ((ImageView)this.convertView.findViewById(2131301643));
      this.jBR = ((TextView)this.convertView.findViewById(2131301638));
      this.tlC = ((ImageView)this.convertView.findViewById(2131309781));
      this.xpr = ((TextView)this.convertView.findViewById(2131301634));
      this.xps = ((ImageView)this.convertView.findViewById(2131301642));
      AppMethodBeat.o(111664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI
 * JD-Core Version:    0.7.0.1
 */