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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  LinkedList<GalleryItem.AlbumItem> sQF;
  String sQG;
  volatile int sQH;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(111496);
    this.sQG = "";
    this.mContext = paramContext;
    this.sQF = new LinkedList();
    AppMethodBeat.o(111496);
  }
  
  public final GalleryItem.AlbumItem Ga(int paramInt)
  {
    AppMethodBeat.i(111498);
    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.sQF.get(paramInt);
    AppMethodBeat.o(111498);
    return localAlbumItem;
  }
  
  public final void a(GalleryItem.PrivateAlbumItem paramPrivateAlbumItem, LinkedList<GalleryItem.PrivateAlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(179460);
    int i;
    int j;
    GalleryItem.AlbumItem localAlbumItem;
    if ((this.sQF != null) && ((paramPrivateAlbumItem != null) || (this.sQF.size() > 0))) {
      if (paramPrivateAlbumItem != null)
      {
        ac.i("MicroMsg.GalleryAdapter", "add favorite album item.");
        if (bs.gY(this.sQF)) {
          break label187;
        }
        i = 0;
        j = -1;
        if (i >= this.sQF.size()) {
          break label181;
        }
        localAlbumItem = (GalleryItem.AlbumItem)this.sQF.get(i);
        if (!localAlbumItem.xNm) {
          break label151;
        }
      }
    }
    for (;;)
    {
      i += 1;
      if (i < this.sQF.size()) {
        this.sQF.add(i, paramPrivateAlbumItem);
      }
      for (;;)
      {
        if (paramLinkedList.size() > 0)
        {
          ac.i("MicroMsg.GalleryAdapter", "add other private album, size: [%s].", new Object[] { Integer.valueOf(paramLinkedList.size()) });
          this.sQF.addAll(paramLinkedList);
        }
        AppMethodBeat.o(179460);
        return;
        label151:
        if (localAlbumItem.xIc) {
          j = i;
        }
        i += 1;
        break;
        this.sQF.add(paramPrivateAlbumItem);
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
    int i = this.sQF.size();
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
    ac.i("MicroMsg.GalleryAdapter", "duanyi test getView:".concat(String.valueOf(paramInt)));
    GalleryItem.AlbumItem localAlbumItem = Ga(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131495311, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.sFo = ((ImageView)paramView.findViewById(2131300187));
      paramViewGroup.ijE = ((TextView)paramView.findViewById(2131300182));
      paramViewGroup.qTB = ((ImageView)paramView.findViewById(2131306355));
      paramViewGroup.sQI = ((TextView)paramView.findViewById(2131300178));
      paramViewGroup.sQJ = ((ImageView)paramView.findViewById(2131300186));
      paramViewGroup.sQK = paramView.findViewById(2131300188);
      paramViewGroup.sQL = paramView.findViewById(2131300180);
      paramViewGroup.sQM = paramView.findViewById(2131300181);
      paramView.setTag(paramViewGroup);
      if (!this.sQG.equals(localAlbumItem.sJZ)) {
        break label357;
      }
      paramViewGroup.sQJ.setVisibility(0);
      label177:
      paramViewGroup.sQL.setVisibility(0);
      paramViewGroup.sQM.setVisibility(8);
      if (paramInt != 0) {
        break label412;
      }
      paramViewGroup.sFo.setImageResource(2131233613);
      if (localAlbumItem.xIb != null) {
        h.a(paramViewGroup.sFo, localAlbumItem.cMS(), localAlbumItem.auN(), localAlbumItem.cMQ(), localAlbumItem.cMR(), paramInt, localAlbumItem.dzx());
      }
      paramViewGroup.sFo.setVisibility(0);
      if (e.cMt().sKz != 1) {
        break label368;
      }
      localAlbumItem.bLs = ai.getContext().getString(2131759757);
    }
    for (;;)
    {
      paramViewGroup.ijE.setText(localAlbumItem.bLs);
      paramViewGroup.ijE.setVisibility(0);
      paramViewGroup.sQI.setVisibility(0);
      paramViewGroup.sQI.setText(this.mContext.getString(2131759762, new Object[] { Integer.valueOf(localAlbumItem.dfy) }));
      AppMethodBeat.o(111499);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label357:
      paramViewGroup.sQJ.setVisibility(4);
      break label177;
      label368:
      if (e.cMt().sKz == 3) {
        localAlbumItem.bLs = ai.getContext().getString(2131759758);
      } else {
        localAlbumItem.bLs = ai.getContext().getString(2131759759);
      }
    }
    label412:
    paramViewGroup.sFo.setVisibility(0);
    paramViewGroup.ijE.setVisibility(0);
    paramViewGroup.ijE.setText(localAlbumItem.bLs);
    paramViewGroup.sQI.setVisibility(0);
    paramViewGroup.sQI.setText(this.mContext.getString(2131759762, new Object[] { Integer.valueOf(localAlbumItem.dfy) }));
    paramViewGroup.sQK.setVisibility(8);
    String str = localAlbumItem.auN();
    if (!bs.isNullOrNil(str)) {
      h.a(paramViewGroup.sFo, localAlbumItem.cMS(), str, localAlbumItem.cMQ(), localAlbumItem.cMR(), paramInt, localAlbumItem.dzx());
    }
    for (;;)
    {
      AppMethodBeat.o(111499);
      return paramView;
      if ((localAlbumItem.xIb != null) && (localAlbumItem.xIb.getType() == 2))
      {
        h.a(paramViewGroup.sFo, localAlbumItem.cMS(), null, localAlbumItem.cMQ(), localAlbumItem.cMR(), paramInt, localAlbumItem.dzx());
      }
      else
      {
        ac.e("MicroMsg.GalleryAdapter", "get folder failed");
        paramViewGroup.sFo.setVisibility(8);
        paramViewGroup.ijE.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public TextView ijE;
    public ImageView qTB;
    public ImageView sFo;
    public TextView sQI;
    public ImageView sQJ;
    public View sQK;
    View sQL;
    View sQM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */