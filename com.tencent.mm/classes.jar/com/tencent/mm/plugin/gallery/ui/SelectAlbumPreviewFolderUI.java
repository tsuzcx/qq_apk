package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.l.a;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(19)
public class SelectAlbumPreviewFolderUI
  extends MMActivity
  implements l.a
{
  ArrayList<GalleryItem.AlbumItem> HQd;
  private a HQe;
  private RecyclerView HQf;
  GalleryItem.AlbumItem HQg;
  private String HQh;
  
  public SelectAlbumPreviewFolderUI()
  {
    AppMethodBeat.i(111665);
    this.HQd = new ArrayList(10);
    AppMethodBeat.o(111665);
  }
  
  public final void bm(final LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111669);
    e.fAo().postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111659);
        SelectAlbumPreviewFolderUI.a(SelectAlbumPreviewFolderUI.this).addAll(paramLinkedList);
        SelectAlbumPreviewFolderUI.b(SelectAlbumPreviewFolderUI.this).bZE.notifyChanged();
        AppMethodBeat.o(111659);
      }
    });
    AppMethodBeat.o(111669);
  }
  
  public int getLayoutId()
  {
    return b.f.select_image_folder_ui;
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
    e.fAn().b(this);
    e.fAn().a(this);
    e.fAn().fAR();
    this.HQf = ((RecyclerView)findViewById(b.e.folder_recycler_view));
    this.HQe = new a(this);
    this.HQf.setLayoutManager(new LinearLayoutManager());
    this.HQf.setAdapter(this.HQe);
    this.HQh = getIntent().getStringExtra("select_folder_name");
    this.HQg = new GalleryItem.AlbumItem("", 0);
    this.HQg.HHB = new GalleryItem.ImageMediaItem();
    setMMTitle(Util.nullAsNil(getString(b.i.app_field_new_pic)));
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
    e.fAn().b(this);
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
      ((b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SelectAlbumPreviewFolderUI$SelectImageFolderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
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
    public ImageView AoD;
    public ImageView HLM;
    public TextView HNN;
    public ImageView HNO;
    public View convertView;
    public TextView plr;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(111664);
      this.convertView = paramView;
      this.HLM = ((ImageView)this.convertView.findViewById(b.e.folder_thumb));
      this.plr = ((TextView)this.convertView.findViewById(b.e.folder_name));
      this.AoD = ((ImageView)this.convertView.findViewById(b.e.video_mask));
      this.HNN = ((TextView)this.convertView.findViewById(b.e.folder_count));
      this.HNO = ((ImageView)this.convertView.findViewById(b.e.folder_selected_iv));
      AppMethodBeat.o(111664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI
 * JD-Core Version:    0.7.0.1
 */