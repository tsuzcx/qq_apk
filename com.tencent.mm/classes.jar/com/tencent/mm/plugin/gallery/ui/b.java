package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  LinkedList<GalleryItem.AlbumItem> tYa;
  String tYb;
  volatile int tYc;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(111496);
    this.tYb = "";
    this.mContext = paramContext;
    this.tYa = new LinkedList();
    AppMethodBeat.o(111496);
  }
  
  public final GalleryItem.AlbumItem HM(int paramInt)
  {
    AppMethodBeat.i(111498);
    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.tYa.get(paramInt);
    AppMethodBeat.o(111498);
    return localAlbumItem;
  }
  
  public final void a(GalleryItem.PrivateAlbumItem paramPrivateAlbumItem, LinkedList<GalleryItem.PrivateAlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(179460);
    int i;
    int j;
    GalleryItem.AlbumItem localAlbumItem;
    if ((this.tYa != null) && ((paramPrivateAlbumItem != null) || (this.tYa.size() > 0))) {
      if (paramPrivateAlbumItem != null)
      {
        ae.i("MicroMsg.GalleryAdapter", "add favorite album item.");
        if (bu.ht(this.tYa)) {
          break label187;
        }
        i = 0;
        j = -1;
        if (i >= this.tYa.size()) {
          break label181;
        }
        localAlbumItem = (GalleryItem.AlbumItem)this.tYa.get(i);
        if (!localAlbumItem.DRq) {
          break label151;
        }
      }
    }
    for (;;)
    {
      i += 1;
      if (i < this.tYa.size()) {
        this.tYa.add(i, paramPrivateAlbumItem);
      }
      for (;;)
      {
        if (paramLinkedList.size() > 0)
        {
          ae.i("MicroMsg.GalleryAdapter", "add other private album, size: [%s].", new Object[] { Integer.valueOf(paramLinkedList.size()) });
          this.tYa.addAll(paramLinkedList);
        }
        AppMethodBeat.o(179460);
        return;
        label151:
        if (localAlbumItem.DRp) {
          j = i;
        }
        i += 1;
        break;
        this.tYa.add(paramPrivateAlbumItem);
      }
      label181:
      i = j;
      continue;
      label187:
      i = -1;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111497);
    int i = this.tYa.size();
    AppMethodBeat.o(111497);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111499);
    ae.i("MicroMsg.GalleryAdapter", "duanyi test getView:".concat(String.valueOf(paramInt)));
    GalleryItem.AlbumItem localAlbumItem = HM(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131495311, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.tMY = ((ImageView)paramView.findViewById(2131300187));
      paramViewGroup.iFO = ((TextView)paramView.findViewById(2131300182));
      paramViewGroup.rLP = ((ImageView)paramView.findViewById(2131306355));
      paramViewGroup.tYd = ((TextView)paramView.findViewById(2131300178));
      paramViewGroup.tYe = ((ImageView)paramView.findViewById(2131300186));
      paramViewGroup.tYf = paramView.findViewById(2131300188);
      paramViewGroup.tYg = paramView.findViewById(2131300180);
      paramViewGroup.tYh = paramView.findViewById(2131300181);
      paramView.setTag(paramViewGroup);
      if (!this.tYb.equals(localAlbumItem.tRB)) {
        break label357;
      }
      paramViewGroup.tYe.setVisibility(0);
      label177:
      paramViewGroup.tYg.setVisibility(0);
      paramViewGroup.tYh.setVisibility(8);
      if (paramInt != 0) {
        break label412;
      }
      paramViewGroup.tMY.setImageResource(2131233613);
      if (localAlbumItem.DRo != null) {
        h.a(paramViewGroup.tMY, localAlbumItem.cXQ(), localAlbumItem.axP(), localAlbumItem.cXO(), localAlbumItem.cXP(), paramInt, localAlbumItem.dWi());
      }
      paramViewGroup.tMY.setVisibility(0);
      if (e.cXr().tSb != 1) {
        break label368;
      }
      localAlbumItem.bVF = ak.getContext().getString(2131759757);
    }
    for (;;)
    {
      paramViewGroup.iFO.setText(localAlbumItem.bVF);
      paramViewGroup.iFO.setVisibility(0);
      paramViewGroup.tYd.setVisibility(0);
      paramViewGroup.tYd.setText(this.mContext.getString(2131759762, new Object[] { Integer.valueOf(localAlbumItem.drZ) }));
      AppMethodBeat.o(111499);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label357:
      paramViewGroup.tYe.setVisibility(4);
      break label177;
      label368:
      if (e.cXr().tSb == 3) {
        localAlbumItem.bVF = ak.getContext().getString(2131759758);
      } else {
        localAlbumItem.bVF = ak.getContext().getString(2131759759);
      }
    }
    label412:
    paramViewGroup.tMY.setVisibility(0);
    paramViewGroup.iFO.setVisibility(0);
    paramViewGroup.iFO.setText(localAlbumItem.bVF);
    paramViewGroup.tYd.setVisibility(0);
    paramViewGroup.tYd.setText(this.mContext.getString(2131759762, new Object[] { Integer.valueOf(localAlbumItem.drZ) }));
    paramViewGroup.tYf.setVisibility(8);
    String str = localAlbumItem.axP();
    if (!bu.isNullOrNil(str)) {
      h.a(paramViewGroup.tMY, localAlbumItem.cXQ(), str, localAlbumItem.cXO(), localAlbumItem.cXP(), paramInt, localAlbumItem.dWi());
    }
    for (;;)
    {
      AppMethodBeat.o(111499);
      return paramView;
      if ((localAlbumItem.DRo != null) && (localAlbumItem.DRo.getType() == 2))
      {
        h.a(paramViewGroup.tMY, localAlbumItem.cXQ(), null, localAlbumItem.cXO(), localAlbumItem.cXP(), paramInt, localAlbumItem.dWi());
      }
      else
      {
        ae.e("MicroMsg.GalleryAdapter", "get folder failed");
        paramViewGroup.tMY.setVisibility(8);
        paramViewGroup.iFO.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public TextView iFO;
    public ImageView rLP;
    public ImageView tMY;
    public TextView tYd;
    public ImageView tYe;
    public View tYf;
    View tYg;
    View tYh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */