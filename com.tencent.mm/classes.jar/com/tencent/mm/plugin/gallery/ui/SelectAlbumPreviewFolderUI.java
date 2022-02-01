package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(19)
public class SelectAlbumPreviewFolderUI
  extends MMActivity
  implements i.a
{
  ArrayList<GalleryItem.AlbumItem> uap;
  private a uaq;
  private RecyclerView uar;
  GalleryItem.AlbumItem uas;
  private String uat;
  
  public SelectAlbumPreviewFolderUI()
  {
    AppMethodBeat.i(111665);
    this.uap = new ArrayList(10);
    AppMethodBeat.o(111665);
  }
  
  public final void aq(final LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111669);
    e.cXs().f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111659);
        SelectAlbumPreviewFolderUI.a(SelectAlbumPreviewFolderUI.this).addAll(paramLinkedList);
        SelectAlbumPreviewFolderUI.b(SelectAlbumPreviewFolderUI.this).asY.notifyChanged();
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
    e.cXr().b(this);
    e.cXr().a(this);
    e.cXr().cXY();
    this.uar = ((RecyclerView)findViewById(2131300184));
    this.uaq = new a(this);
    this.uar.setLayoutManager(new LinearLayoutManager());
    this.uar.setAdapter(this.uaq);
    this.uat = getIntent().getStringExtra("select_folder_name");
    this.uas = new GalleryItem.AlbumItem("", 0);
    this.uas.DRo = new GalleryItem.ImageMediaItem();
    setMMTitle(bu.nullAsNil(getString(2131755750)));
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
    e.cXr().b(this);
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
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SelectAlbumPreviewFolderUI$SelectImageFolderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
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
    extends RecyclerView.w
  {
    public TextView iFO;
    public ImageView rLP;
    public ImageView tMY;
    public TextView tYd;
    public ImageView tYe;
    public View uan;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(111664);
      this.uan = paramView;
      this.tMY = ((ImageView)this.uan.findViewById(2131300187));
      this.iFO = ((TextView)this.uan.findViewById(2131300182));
      this.rLP = ((ImageView)this.uan.findViewById(2131306355));
      this.tYd = ((TextView)this.uan.findViewById(2131300178));
      this.tYe = ((ImageView)this.uan.findViewById(2131300186));
      AppMethodBeat.o(111664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI
 * JD-Core Version:    0.7.0.1
 */