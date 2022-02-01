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
  LinkedList<GalleryItem.AlbumItem> tNj;
  String tNk;
  volatile int tNl;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(111496);
    this.tNk = "";
    this.mContext = paramContext;
    this.tNj = new LinkedList();
    AppMethodBeat.o(111496);
  }
  
  public final GalleryItem.AlbumItem Hp(int paramInt)
  {
    AppMethodBeat.i(111498);
    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.tNj.get(paramInt);
    AppMethodBeat.o(111498);
    return localAlbumItem;
  }
  
  public final void a(GalleryItem.PrivateAlbumItem paramPrivateAlbumItem, LinkedList<GalleryItem.PrivateAlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(179460);
    int i;
    int j;
    GalleryItem.AlbumItem localAlbumItem;
    if ((this.tNj != null) && ((paramPrivateAlbumItem != null) || (this.tNj.size() > 0))) {
      if (paramPrivateAlbumItem != null)
      {
        ad.i("MicroMsg.GalleryAdapter", "add favorite album item.");
        if (bt.hj(this.tNj)) {
          break label187;
        }
        i = 0;
        j = -1;
        if (i >= this.tNj.size()) {
          break label181;
        }
        localAlbumItem = (GalleryItem.AlbumItem)this.tNj.get(i);
        if (!localAlbumItem.Odp) {
          break label151;
        }
      }
    }
    for (;;)
    {
      i += 1;
      if (i < this.tNj.size()) {
        this.tNj.add(i, paramPrivateAlbumItem);
      }
      for (;;)
      {
        if (paramLinkedList.size() > 0)
        {
          ad.i("MicroMsg.GalleryAdapter", "add other private album, size: [%s].", new Object[] { Integer.valueOf(paramLinkedList.size()) });
          this.tNj.addAll(paramLinkedList);
        }
        AppMethodBeat.o(179460);
        return;
        label151:
        if (localAlbumItem.Odo) {
          j = i;
        }
        i += 1;
        break;
        this.tNj.add(paramPrivateAlbumItem);
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
    int i = this.tNj.size();
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
    GalleryItem.AlbumItem localAlbumItem = Hp(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131495311, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.tCh = ((ImageView)paramView.findViewById(2131300187));
      paramViewGroup.iCV = ((TextView)paramView.findViewById(2131300182));
      paramViewGroup.rDE = ((ImageView)paramView.findViewById(2131306355));
      paramViewGroup.tNm = ((TextView)paramView.findViewById(2131300178));
      paramViewGroup.tNn = ((ImageView)paramView.findViewById(2131300186));
      paramViewGroup.tNo = paramView.findViewById(2131300188);
      paramViewGroup.tNp = paramView.findViewById(2131300180);
      paramViewGroup.tNq = paramView.findViewById(2131300181);
      paramView.setTag(paramViewGroup);
      if (!this.tNk.equals(localAlbumItem.tGK)) {
        break label357;
      }
      paramViewGroup.tNn.setVisibility(0);
      label177:
      paramViewGroup.tNp.setVisibility(0);
      paramViewGroup.tNq.setVisibility(8);
      if (paramInt != 0) {
        break label412;
      }
      paramViewGroup.tCh.setImageResource(2131233613);
      if (localAlbumItem.Odn != null) {
        h.a(paramViewGroup.tCh, localAlbumItem.cVl(), localAlbumItem.axA(), localAlbumItem.cVj(), localAlbumItem.cVk(), paramInt, localAlbumItem.fsO());
      }
      paramViewGroup.tCh.setVisibility(0);
      if (e.cUM().tHk != 1) {
        break label368;
      }
      localAlbumItem.bVF = aj.getContext().getString(2131759757);
    }
    for (;;)
    {
      paramViewGroup.iCV.setText(localAlbumItem.bVF);
      paramViewGroup.iCV.setVisibility(0);
      paramViewGroup.tNm.setVisibility(0);
      paramViewGroup.tNm.setText(this.mContext.getString(2131759762, new Object[] { Integer.valueOf(localAlbumItem.dqU) }));
      AppMethodBeat.o(111499);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label357:
      paramViewGroup.tNn.setVisibility(4);
      break label177;
      label368:
      if (e.cUM().tHk == 3) {
        localAlbumItem.bVF = aj.getContext().getString(2131759758);
      } else {
        localAlbumItem.bVF = aj.getContext().getString(2131759759);
      }
    }
    label412:
    paramViewGroup.tCh.setVisibility(0);
    paramViewGroup.iCV.setVisibility(0);
    paramViewGroup.iCV.setText(localAlbumItem.bVF);
    paramViewGroup.tNm.setVisibility(0);
    paramViewGroup.tNm.setText(this.mContext.getString(2131759762, new Object[] { Integer.valueOf(localAlbumItem.dqU) }));
    paramViewGroup.tNo.setVisibility(8);
    String str = localAlbumItem.axA();
    if (!bt.isNullOrNil(str)) {
      h.a(paramViewGroup.tCh, localAlbumItem.cVl(), str, localAlbumItem.cVj(), localAlbumItem.cVk(), paramInt, localAlbumItem.fsO());
    }
    for (;;)
    {
      AppMethodBeat.o(111499);
      return paramView;
      if ((localAlbumItem.Odn != null) && (localAlbumItem.Odn.getType() == 2))
      {
        h.a(paramViewGroup.tCh, localAlbumItem.cVl(), null, localAlbumItem.cVj(), localAlbumItem.cVk(), paramInt, localAlbumItem.fsO());
      }
      else
      {
        ad.e("MicroMsg.GalleryAdapter", "get folder failed");
        paramViewGroup.tCh.setVisibility(8);
        paramViewGroup.iCV.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public TextView iCV;
    public ImageView rDE;
    public ImageView tCh;
    public TextView tNm;
    public ImageView tNn;
    public View tNo;
    View tNp;
    View tNq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */