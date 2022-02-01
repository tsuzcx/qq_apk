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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  LinkedList<GalleryItem.AlbumItem> rIQ;
  String rIR;
  volatile int rIS;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(111496);
    this.rIR = "";
    this.mContext = paramContext;
    this.rIQ = new LinkedList();
    AppMethodBeat.o(111496);
  }
  
  public final GalleryItem.AlbumItem Ee(int paramInt)
  {
    AppMethodBeat.i(111498);
    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.rIQ.get(paramInt);
    AppMethodBeat.o(111498);
    return localAlbumItem;
  }
  
  public final void a(GalleryItem.PrivateAlbumItem paramPrivateAlbumItem, LinkedList<GalleryItem.PrivateAlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(179460);
    int i;
    int j;
    GalleryItem.AlbumItem localAlbumItem;
    if ((this.rIQ != null) && ((paramPrivateAlbumItem != null) || (this.rIQ.size() > 0))) {
      if (paramPrivateAlbumItem != null)
      {
        ad.i("MicroMsg.GalleryAdapter", "add favorite album item.");
        if (bt.gL(this.rIQ)) {
          break label187;
        }
        i = 0;
        j = -1;
        if (i >= this.rIQ.size()) {
          break label181;
        }
        localAlbumItem = (GalleryItem.AlbumItem)this.rIQ.get(i);
        if (!localAlbumItem.Lml) {
          break label151;
        }
      }
    }
    for (;;)
    {
      i += 1;
      if (i < this.rIQ.size()) {
        this.rIQ.add(i, paramPrivateAlbumItem);
      }
      for (;;)
      {
        if (paramLinkedList.size() > 0)
        {
          ad.i("MicroMsg.GalleryAdapter", "add other private album, size: [%s].", new Object[] { Integer.valueOf(paramLinkedList.size()) });
          this.rIQ.addAll(paramLinkedList);
        }
        AppMethodBeat.o(179460);
        return;
        label151:
        if (localAlbumItem.Lmk) {
          j = i;
        }
        i += 1;
        break;
        this.rIQ.add(paramPrivateAlbumItem);
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
    int i = this.rIQ.size();
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
    ad.i("MicroMsg.GalleryAdapter", "duanyi test getView:".concat(String.valueOf(paramInt)));
    GalleryItem.AlbumItem localAlbumItem = Ee(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131495311, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.rww = ((ImageView)paramView.findViewById(2131300187));
      paramViewGroup.hJe = ((TextView)paramView.findViewById(2131300182));
      paramViewGroup.qkZ = ((ImageView)paramView.findViewById(2131306355));
      paramViewGroup.rIT = ((TextView)paramView.findViewById(2131300178));
      paramViewGroup.rIU = ((ImageView)paramView.findViewById(2131300186));
      paramViewGroup.rIV = paramView.findViewById(2131300188);
      paramViewGroup.rIW = paramView.findViewById(2131300180);
      paramViewGroup.rIX = paramView.findViewById(2131300181);
      paramView.setTag(paramViewGroup);
      if (!this.rIR.equals(localAlbumItem.rBh)) {
        break label357;
      }
      paramViewGroup.rIU.setVisibility(0);
      label177:
      paramViewGroup.rIW.setVisibility(0);
      paramViewGroup.rIX.setVisibility(8);
      if (paramInt != 0) {
        break label412;
      }
      paramViewGroup.rww.setImageResource(2131233613);
      if (localAlbumItem.Lmj != null) {
        h.a(paramViewGroup.rww, localAlbumItem.czG(), localAlbumItem.anX(), localAlbumItem.czE(), localAlbumItem.czF(), paramInt, localAlbumItem.fXQ());
      }
      paramViewGroup.rww.setVisibility(0);
      if (e.czh().rBG != 1) {
        break label368;
      }
      localAlbumItem.bNK = aj.getContext().getString(2131759757);
    }
    for (;;)
    {
      paramViewGroup.hJe.setText(localAlbumItem.bNK);
      paramViewGroup.hJe.setVisibility(0);
      paramViewGroup.rIT.setVisibility(0);
      paramViewGroup.rIT.setText(this.mContext.getString(2131759762, new Object[] { Integer.valueOf(localAlbumItem.did) }));
      AppMethodBeat.o(111499);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label357:
      paramViewGroup.rIU.setVisibility(4);
      break label177;
      label368:
      if (e.czh().rBG == 3) {
        localAlbumItem.bNK = aj.getContext().getString(2131759758);
      } else {
        localAlbumItem.bNK = aj.getContext().getString(2131759759);
      }
    }
    label412:
    paramViewGroup.rww.setVisibility(0);
    paramViewGroup.hJe.setVisibility(0);
    paramViewGroup.hJe.setText(localAlbumItem.bNK);
    paramViewGroup.rIT.setVisibility(0);
    paramViewGroup.rIT.setText(this.mContext.getString(2131759762, new Object[] { Integer.valueOf(localAlbumItem.did) }));
    paramViewGroup.rIV.setVisibility(8);
    String str = localAlbumItem.anX();
    if (!bt.isNullOrNil(str)) {
      h.a(paramViewGroup.rww, localAlbumItem.czG(), str, localAlbumItem.czE(), localAlbumItem.czF(), paramInt, localAlbumItem.fXQ());
    }
    for (;;)
    {
      AppMethodBeat.o(111499);
      return paramView;
      if ((localAlbumItem.Lmj != null) && (localAlbumItem.Lmj.getType() == 2))
      {
        h.a(paramViewGroup.rww, localAlbumItem.czG(), null, localAlbumItem.czE(), localAlbumItem.czF(), paramInt, localAlbumItem.fXQ());
      }
      else
      {
        ad.e("MicroMsg.GalleryAdapter", "get folder failed");
        paramViewGroup.rww.setVisibility(8);
        paramViewGroup.hJe.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public TextView hJe;
    public ImageView qkZ;
    public TextView rIT;
    public ImageView rIU;
    public View rIV;
    View rIW;
    View rIX;
    public ImageView rww;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */