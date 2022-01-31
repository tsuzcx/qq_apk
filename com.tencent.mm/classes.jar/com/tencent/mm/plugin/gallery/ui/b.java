package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  private int ndz;
  LinkedList<GalleryItem.AlbumItem> nfl;
  GalleryItem.AlbumItem nfm;
  String nfn;
  private int nfo;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(21447);
    this.nfn = "";
    this.nfo = 0;
    this.mContext = paramContext;
    this.nfl = new LinkedList();
    this.ndz = paramInt;
    this.nfm = new GalleryItem.AlbumItem("", 0);
    this.nfm.ndm = new GalleryItem.ImageMediaItem();
    this.nfo = paramContext.getResources().getDimensionPixelSize(2131427854);
    AppMethodBeat.o(21447);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21448);
    int i = this.nfl.size();
    AppMethodBeat.o(21448);
    return i + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(21450);
    ab.i("MicroMsg.GalleryAdapter", "duanyi test getview:".concat(String.valueOf(paramInt)));
    GalleryItem.AlbumItem localAlbumItem = wS(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2130970616, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.mZY = ((ImageView)paramView.findViewById(2131827461));
      paramViewGroup.gpM = ((TextView)paramView.findViewById(2131827462));
      paramViewGroup.mDn = ((ImageView)paramView.findViewById(2131825137));
      paramViewGroup.nfp = ((TextView)paramView.findViewById(2131827463));
      paramViewGroup.nfq = ((ImageView)paramView.findViewById(2131827464));
      paramView.setTag(paramViewGroup);
      if (!this.nfn.equals(localAlbumItem.ndl)) {
        break label265;
      }
      paramViewGroup.nfq.setVisibility(0);
      label148:
      if (paramInt != 0) {
        break label310;
      }
      paramViewGroup.mZY.setImageResource(2130839944);
      if (localAlbumItem.ndm != null) {
        h.a(paramViewGroup.mZY, localAlbumItem.ndm.getType(), localAlbumItem.Xi(), localAlbumItem.ndm.fQn, localAlbumItem.dbW());
      }
      if (e.bDQ().ndz != 1) {
        break label276;
      }
      paramViewGroup.gpM.setText(2131300270);
    }
    for (;;)
    {
      paramViewGroup.mZY.setVisibility(0);
      paramViewGroup.gpM.setVisibility(0);
      paramViewGroup.nfp.setVisibility(8);
      AppMethodBeat.o(21450);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label265:
      paramViewGroup.nfq.setVisibility(4);
      break label148;
      label276:
      if (e.bDQ().ndz == 3) {
        paramViewGroup.gpM.setText(2131300271);
      } else {
        paramViewGroup.gpM.setText(2131300272);
      }
    }
    label310:
    paramViewGroup.mZY.setVisibility(0);
    paramViewGroup.gpM.setVisibility(0);
    paramViewGroup.gpM.setText(localAlbumItem.ndl);
    paramViewGroup.nfp.setVisibility(0);
    paramViewGroup.nfp.setText(this.mContext.getString(2131300284, new Object[] { Integer.valueOf(localAlbumItem.cti) }));
    Object localObject;
    if ((paramViewGroup.mDn != null) && (localAlbumItem.ndm != null))
    {
      localObject = paramViewGroup.mDn;
      if (localAlbumItem.ndm.getType() == 2)
      {
        paramInt = 0;
        ((ImageView)localObject).setVisibility(paramInt);
      }
    }
    else
    {
      localObject = localAlbumItem.Xi();
      if ((bo.isNullOrNil((String)localObject)) || (localAlbumItem.ndm == null)) {
        break label485;
      }
      h.a(paramViewGroup.mZY, localAlbumItem.ndm.getType(), (String)localObject, localAlbumItem.ndm.fQn, localAlbumItem.dbW());
    }
    for (;;)
    {
      AppMethodBeat.o(21450);
      return paramView;
      paramInt = 8;
      break;
      label485:
      if ((localAlbumItem.ndm != null) && (localAlbumItem.ndm.getType() == 2))
      {
        h.a(paramViewGroup.mZY, localAlbumItem.ndm.getType(), null, localAlbumItem.ndm.fQn, localAlbumItem.dbW());
      }
      else
      {
        ab.e("MicroMsg.GalleryAdapter", "get folder failed");
        paramViewGroup.mZY.setVisibility(8);
        paramViewGroup.gpM.setVisibility(8);
      }
    }
  }
  
  public final GalleryItem.AlbumItem wS(int paramInt)
  {
    AppMethodBeat.i(21449);
    if (paramInt == 0)
    {
      localAlbumItem = this.nfm;
      AppMethodBeat.o(21449);
      return localAlbumItem;
    }
    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.nfl.get(paramInt - 1);
    AppMethodBeat.o(21449);
    return localAlbumItem;
  }
  
  static final class a
  {
    public TextView gpM;
    public ImageView mDn;
    public ImageView mZY;
    public TextView nfp;
    public ImageView nfq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */