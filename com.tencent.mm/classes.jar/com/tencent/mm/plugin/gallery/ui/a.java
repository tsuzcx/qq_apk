package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
  implements com.tencent.mm.ui.gridviewheaders.e
{
  int gNT;
  private SimpleDateFormat kTX;
  private Context mContext;
  int ndK;
  com.tencent.mm.plugin.gallery.stub.a ndL;
  ArrayList<GalleryItem.MediaItem> ndM;
  ArrayList<GalleryItem.MediaItem> ndN;
  private a.b ndO;
  int ndP;
  String ndQ;
  LinkedList<a.a> ndR;
  boolean ndS;
  boolean ndT;
  private View.OnClickListener ndU;
  
  public a(Context paramContext, a.b paramb)
  {
    AppMethodBeat.i(21372);
    this.ndK = 9;
    this.ndL = null;
    this.ndM = new ArrayList();
    this.ndN = new ArrayList();
    this.kTX = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    this.gNT = 10;
    this.ndR = new LinkedList();
    this.ndS = false;
    this.ndT = true;
    this.ndU = new a.2(this);
    this.mContext = paramContext;
    this.ndO = paramb;
    while (i < 32)
    {
      paramContext = new GalleryItem.ImageMediaItem();
      this.ndM.add(paramContext);
      i += 1;
    }
    AppMethodBeat.o(21372);
  }
  
  public final void C(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(21375);
    ab.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", new Object[] { this.ndN });
    this.ndN.clear();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
        if (com.tencent.mm.plugin.gallery.model.e.bDS() != null)
        {
          int i = com.tencent.mm.plugin.gallery.model.e.bDS().indexOf(localMediaItem);
          if (i >= 0)
          {
            localMediaItem = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.bDS().get(i);
            if ((localMediaItem != null) && (localMediaItem.getType() == 2))
            {
              this.ndN.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
              continue;
            }
          }
        }
        ab.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
        this.ndN.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
      }
    }
    ab.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", new Object[] { this.ndN });
    AppMethodBeat.o(21375);
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(21384);
    int i = paramInt;
    if (paramInt < this.ndR.size())
    {
      ab.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      i = this.ndR.size();
    }
    if ((paramView == null) || (paramView.getParent() != null))
    {
      paramViewGroup = new ViewGroup.LayoutParams(-1, -2);
      paramView = new TextView(this.mContext);
      paramView.setBackgroundResource(2130839276);
      paramInt = this.mContext.getResources().getDimensionPixelSize(2131427854);
      int j = this.mContext.getResources().getDimensionPixelSize(2131427854);
      paramView.setPadding(j, paramInt, j, paramInt);
      paramView.setTextColor(this.mContext.getResources().getColor(2131690079));
      paramView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131427758));
      paramView.setTypeface(null, 1);
      paramView.setLayoutParams(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = wO(i);
      Date localDate = new Date(paramViewGroup.ndq);
      String str = com.tencent.mm.ui.gridviewheaders.a.dNj().a(localDate, this.mContext);
      ab.v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(paramViewGroup.ndq), localDate, str });
      ((TextView)paramView).setText(str);
      AppMethodBeat.o(21384);
      return paramView;
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(21373);
    if (parama == null)
    {
      ab.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
      AppMethodBeat.o(21373);
      return;
    }
    this.ndR.remove(parama);
    this.ndR.add(parama);
    AppMethodBeat.o(21373);
  }
  
  public final ArrayList<String> bEn()
  {
    AppMethodBeat.i(21374);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ndN.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).fQn);
    }
    AppMethodBeat.o(21374);
    return localArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(21377);
    int i = this.ndR.size();
    int j = this.ndM.size();
    AppMethodBeat.o(21377);
    return i + j;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(21379);
    if (paramInt < this.ndR.size())
    {
      AppMethodBeat.o(21379);
      return paramInt;
    }
    paramInt = this.ndR.size();
    AppMethodBeat.o(21379);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(21381);
    if (paramInt < this.ndR.size())
    {
      ab.i("MicroMsg.AlbumAdapter", "position[%d], get header view", new Object[] { Integer.valueOf(paramInt) });
      paramView = ((a.a)this.ndR.get(paramInt)).getView();
      AppMethodBeat.o(21381);
      return paramView;
    }
    int i = paramInt - this.ndR.size();
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.ndM.get(i);
    boolean bool;
    a.d locald;
    if ((paramView == null) || (!(paramView.getTag() instanceof a.d))) {
      if (paramView == null)
      {
        bool = true;
        ab.d("MicroMsg.AlbumAdapter", "converview is null?[%B]", new Object[] { Boolean.valueOf(bool) });
        paramView = LayoutInflater.from(this.mContext).inflate(2130970615, paramViewGroup, false);
        locald = new a.d((byte)0);
        locald.neb = ((ImageView)paramView.findViewById(2131826765));
        locald.mZY = ((ImageView)paramView.findViewById(2131822416));
        locald.nec = ((RelativeLayout)paramView.findViewById(2131825137));
        locald.ned = ((TextView)paramView.findViewById(2131826761));
        locald.mCC = ((CheckBox)paramView.findViewById(2131824025));
        if (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 15) {
          locald.mCC.setBackgroundResource(2130839187);
        }
        locald.nee = ((TextView)paramView.findViewById(2131827460));
        locald.mCD = paramView.findViewById(2131824026);
        locald.nef = ((ImageView)paramView.findViewById(2131826764));
        locald.mCD.setOnClickListener(this.ndU);
        locald.mCD.setTag(2131824025, locald.mCC);
        locald.mCD.setTag(2131827460, locald.nee);
        locald.mCD.setTag(2131826764, locald.nef);
        if ((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 0) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 5) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 10) || (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK == 11))
        {
          locald.mCC.setVisibility(8);
          locald.nee.setVisibility(8);
          locald.mCD.setVisibility(8);
          locald.nef.setVisibility(8);
        }
        locald.neg = ((ImageView)paramView.findViewById(2131826762));
        locald.neh = ((ImageView)paramView.findViewById(2131826763));
        paramView.setTag(locald);
      }
    }
    for (;;)
    {
      if (localMediaItem != null) {
        break label508;
      }
      ab.e("MicroMsg.AlbumAdapter", "get item failed");
      AppMethodBeat.o(21381);
      return paramView;
      bool = false;
      break;
      locald = (a.d)paramView.getTag();
    }
    label508:
    locald.neb.setVisibility(0);
    if (localMediaItem.getType() == 2)
    {
      locald.nec.setVisibility(0);
      a.c.a(locald.ned, (GalleryItem.VideoMediaItem)localMediaItem);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label638;
      }
      locald.neh.setVisibility(0);
    }
    Object localObject;
    String str;
    for (;;)
    {
      localObject = localMediaItem.Xi();
      str = localMediaItem.fQn;
      if ((!bo.isNullOrNil((String)localObject)) || (!bo.isNullOrNil(str))) {
        break label651;
      }
      ab.e("MicroMsg.AlbumAdapter", "null or nil filepath: ".concat(String.valueOf(i)));
      AppMethodBeat.o(21381);
      return paramView;
      locald.nec.setVisibility(8);
      break;
      label638:
      locald.neh.setVisibility(8);
    }
    label651:
    locald.mCD.setTag(2131824026, Integer.valueOf(i));
    i = 2131302098;
    if (localMediaItem.getType() == 2) {
      i = 2131304540;
    }
    paramViewGroup = paramViewGroup.getContext().getString(i, new Object[] { Integer.valueOf(paramInt + 1 - this.ndR.size()), this.kTX.format(new Date(localMediaItem.ndq)) });
    ab.d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", new Object[] { localObject, str, paramViewGroup });
    locald.mZY.setContentDescription(paramViewGroup);
    paramViewGroup = locald.neb;
    h.a(locald.mZY, localMediaItem.getType(), (String)localObject, str, localMediaItem.ndp, -1, new a.1(this, paramViewGroup));
    if (this.ndS) {
      if (localMediaItem.getType() == 2)
      {
        locald.mCC.setVisibility(8);
        locald.nee.setVisibility(8);
        locald.mCD.setVisibility(8);
        locald.nef.setVisibility(8);
        if (((com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 3) && (com.tencent.mm.plugin.gallery.model.e.bDQ().hQK != 11)) || (localMediaItem == null) || (!localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
          break label1181;
        }
        locald.neg.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(21381);
      return paramView;
      if (this.ndN.contains(localMediaItem))
      {
        locald.mCC.setChecked(true);
        paramViewGroup = locald.nee;
        localObject = new StringBuilder();
        if (localMediaItem == null) {}
        for (paramInt = -1;; paramInt = this.ndN.indexOf(localMediaItem))
        {
          paramViewGroup.setText(paramInt);
          locald.nef.setBackgroundResource(2131690159);
          locald.mCD.setVisibility(0);
          locald.mCC.setVisibility(0);
          locald.nef.setVisibility(0);
          break;
        }
      }
      locald.nee.setVisibility(8);
      locald.mCC.setChecked(false);
      locald.nef.setBackgroundResource(2131690180);
      locald.mCC.setVisibility(0);
      locald.mCD.setVisibility(0);
      locald.nef.setVisibility(0);
      break;
      if (this.ndN.contains(localMediaItem))
      {
        locald.mCC.setChecked(true);
        locald.nef.setVisibility(0);
        locald.nef.setBackgroundResource(2131690159);
        break;
      }
      locald.mCC.setChecked(false);
      locald.nee.setVisibility(8);
      locald.nef.setVisibility(0);
      locald.nef.setBackgroundResource(2131690180);
      break;
      label1181:
      locald.neg.setVisibility(8);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(21378);
    int i = this.ndR.size();
    AppMethodBeat.o(21378);
    return i + 1;
  }
  
  public final long tC(int paramInt)
  {
    AppMethodBeat.i(21382);
    int i = paramInt;
    if (paramInt < this.ndR.size())
    {
      ab.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      i = this.ndR.size();
    }
    GalleryItem.MediaItem localMediaItem = wO(i);
    Date localDate = new Date(localMediaItem.ndq);
    long l = com.tencent.mm.ui.gridviewheaders.a.dNj().b(localDate);
    ab.v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localMediaItem.ndq), localDate, Long.valueOf(l) });
    AppMethodBeat.o(21382);
    return l;
  }
  
  public final ArrayList<GalleryItem.MediaItem> wN(int paramInt)
  {
    AppMethodBeat.i(21376);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ndM.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (localMediaItem.getType() == paramInt) {
        localArrayList.add(localMediaItem);
      }
    }
    AppMethodBeat.o(21376);
    return localArrayList;
  }
  
  public final GalleryItem.MediaItem wO(int paramInt)
  {
    AppMethodBeat.i(21380);
    if (paramInt < this.ndR.size())
    {
      ab.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(21380);
      return null;
    }
    paramInt -= this.ndR.size();
    if (paramInt >= this.ndM.size())
    {
      ab.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.ndM.size()), Integer.valueOf(paramInt) });
      localObject = new GalleryItem.ImageMediaItem();
      ((GalleryItem.ImageMediaItem)localObject).ndq = bo.aoy();
      AppMethodBeat.o(21380);
      return localObject;
    }
    Object localObject = (GalleryItem.MediaItem)this.ndM.get(paramInt);
    AppMethodBeat.o(21380);
    return localObject;
  }
  
  public final String wP(int paramInt)
  {
    AppMethodBeat.i(21383);
    int i = paramInt;
    if (paramInt < this.ndR.size())
    {
      ab.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      i = this.ndR.size();
    }
    Object localObject = wO(i);
    if (!bo.isNullOrNil(((GalleryItem.MediaItem)localObject).nds))
    {
      localObject = ((GalleryItem.MediaItem)localObject).nds;
      AppMethodBeat.o(21383);
      return localObject;
    }
    localObject = new Date(((GalleryItem.MediaItem)localObject).ndq);
    localObject = com.tencent.mm.ui.gridviewheaders.a.dNj().a((Date)localObject, this.mContext);
    AppMethodBeat.o(21383);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a
 * JD-Core Version:    0.7.0.1
 */