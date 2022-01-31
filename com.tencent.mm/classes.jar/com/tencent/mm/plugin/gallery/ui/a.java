package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
  implements com.tencent.mm.ui.gridviewheaders.e
{
  private SimpleDateFormat iMX = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  int kHA = 9;
  com.tencent.mm.plugin.gallery.stub.a kHB = null;
  ArrayList<GalleryItem.MediaItem> kHC = new ArrayList();
  ArrayList<GalleryItem.MediaItem> kHD = new ArrayList();
  private a.b kHE;
  int kHF;
  LinkedList<a.a> kHG = new LinkedList();
  boolean kHH = false;
  private View.OnClickListener kHI = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      Integer localInteger = (Integer)paramAnonymousView.getTag(R.h.media_cbx_clickarea);
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)a.a(a.this).get(localInteger.intValue());
      if (localMediaItem == null)
      {
        y.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
        return;
      }
      y.i("MicroMsg.AlbumAdapter", "click Image path:" + localMediaItem.eAu);
      int i;
      int j;
      if (a.b(a.this).contains(localMediaItem))
      {
        a.b(a.this).indexOf(localMediaItem);
        a.b(a.this).remove(localMediaItem);
        i = 1;
        j = 0;
      }
      for (;;)
      {
        if (j == 0) {
          if (a.f(a.this) != null) {
            a.f(a.this).J(a.this.kHD.size(), localInteger.intValue(), i);
          }
        }
        for (;;)
        {
          if (1 != i) {
            break label580;
          }
          ((CheckBox)paramAnonymousView.getTag(R.h.media_cbx)).setChecked(false);
          ((View)paramAnonymousView.getTag(R.h.media_mask)).setVisibility(0);
          ((View)paramAnonymousView.getTag(R.h.media_mask)).setBackgroundResource(R.e.image_gallery_mask);
          return;
          if ((c.aXb().aXE() == 3) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
          {
            i = com.tencent.mm.a.e.bJ(localMediaItem.eAu);
            if (!((d)g.t(d.class)).getProvider().AG(localMediaItem.eAu)) {
              try
              {
                a.c(a.this).aq(13459, i + ",1,,0");
                com.tencent.mm.ui.base.h.bC(a.d(a.this), a.d(a.this).getString(R.l.gallery_select_gif_to_big));
                return;
              }
              catch (RemoteException paramAnonymousView)
              {
                for (;;)
                {
                  y.printErrStackTrace("MicroMsg.AlbumAdapter", paramAnonymousView, "", new Object[0]);
                }
              }
            }
          }
          if (a.b(a.this).size() >= a.e(a.this)) {
            break label625;
          }
          a.b(a.this).add(localMediaItem);
          a.b(a.this).size();
          i = 0;
          j = 0;
          break;
          if (a.g(a.this) == 1) {
            com.tencent.mm.ui.base.h.bC(a.d(a.this), a.d(a.this).getResources().getQuantityString(R.j.gallery_pic_limit, a.e(a.this), new Object[] { Integer.valueOf(a.e(a.this)) }));
          } else if (a.g(a.this) == 2) {
            com.tencent.mm.ui.base.h.bC(a.d(a.this), a.d(a.this).getResources().getQuantityString(R.j.gallery_video_limit, a.e(a.this), new Object[] { Integer.valueOf(a.e(a.this)) }));
          } else {
            com.tencent.mm.ui.base.h.bC(a.d(a.this), a.d(a.this).getResources().getQuantityString(R.j.gallery_pic_or_video_limit, a.e(a.this), new Object[] { Integer.valueOf(a.e(a.this)) }));
          }
        }
        label580:
        ((CheckBox)paramAnonymousView.getTag(R.h.media_cbx)).setChecked(true);
        ((View)paramAnonymousView.getTag(R.h.media_mask)).setVisibility(0);
        ((View)paramAnonymousView.getTag(R.h.media_mask)).setBackgroundResource(R.e.half_alpha_black);
        return;
        label625:
        i = 1;
        j = 1;
      }
    }
  };
  private Context mContext;
  
  public a(Context paramContext, a.b paramb)
  {
    this.mContext = paramContext;
    this.kHE = paramb;
  }
  
  public final void A(ArrayList<String> paramArrayList)
  {
    y.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", new Object[] { this.kHD });
    this.kHD.clear();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
        if (c.aXd() != null)
        {
          int i = c.aXd().indexOf(localMediaItem);
          if (i >= 0)
          {
            localMediaItem = (GalleryItem.MediaItem)c.aXd().get(i);
            if ((localMediaItem != null) && (localMediaItem.getType() == 2))
            {
              this.kHD.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
              continue;
            }
          }
        }
        y.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
        this.kHD.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
      }
    }
    y.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", new Object[] { this.kHD });
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = paramInt;
    if (paramInt < this.kHG.size())
    {
      y.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      i = this.kHG.size();
    }
    if ((paramView == null) || (paramView.getParent() != null))
    {
      paramViewGroup = new ViewGroup.LayoutParams(-1, -2);
      paramView = new TextView(this.mContext);
      paramView.setBackgroundResource(R.g.list_item_normal);
      paramInt = this.mContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
      int j = this.mContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
      paramView.setPadding(j, paramInt, j, paramInt);
      paramView.setTextColor(this.mContext.getResources().getColor(R.e.gallery_catalog_color));
      paramView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.f.HintTextSize));
      paramView.setTypeface(null, 1);
      paramView.setLayoutParams(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = rS(i);
      Date localDate = new Date(paramViewGroup.kGY);
      String str = com.tencent.mm.ui.gridviewheaders.a.cIz().a(localDate, this.mContext);
      y.v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(paramViewGroup.kGY), localDate, str });
      ((TextView)paramView).setText(str);
      return paramView;
    }
  }
  
  public final void a(a.a parama)
  {
    if (parama == null)
    {
      y.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
      return;
    }
    this.kHG.remove(parama);
    this.kHG.add(parama);
  }
  
  public final ArrayList<String> aXJ()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kHD.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).eAu);
    }
    return localArrayList;
  }
  
  public final int getCount()
  {
    return this.kHG.size() + this.kHC.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt < this.kHG.size()) {
      return paramInt;
    }
    return this.kHG.size();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    y.v("MicroMsg.AlbumAdapter", "duanyi getview index[%d] header size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kHG.size()) });
    if (paramInt < this.kHG.size())
    {
      y.i("MicroMsg.AlbumAdapter", "position[%d], get header view", new Object[] { Integer.valueOf(paramInt) });
      return ((a.a)this.kHG.get(paramInt)).getView();
    }
    int i = paramInt - this.kHG.size();
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.kHC.get(i);
    y.i("MicroMsg.AlbumAdapter", "addtime:%s", new Object[] { Long.valueOf(localMediaItem.kGY) });
    boolean bool;
    d locald;
    if ((paramView == null) || (!(paramView.getTag() instanceof d))) {
      if (paramView == null)
      {
        bool = true;
        y.d("MicroMsg.AlbumAdapter", "converview is null?[%B]", new Object[] { Boolean.valueOf(bool) });
        paramView = LayoutInflater.from(this.mContext).inflate(R.i.sd_card_media_folder_preview_item, paramViewGroup, false);
        locald = new d((byte)0);
        locald.kHP = ((ImageView)paramView.findViewById(R.h.media_placeholder));
        locald.kHQ = ((ImageView)paramView.findViewById(R.h.media_thumb));
        locald.kHR = ((RelativeLayout)paramView.findViewById(R.h.video_mask));
        locald.kHS = ((TextView)paramView.findViewById(R.h.video_mask_tv));
        locald.khV = ((CheckBox)paramView.findViewById(R.h.media_cbx));
        locald.kHT = ((TextView)paramView.findViewById(R.h.select_num));
        locald.khW = paramView.findViewById(R.h.media_cbx_clickarea);
        locald.kHU = ((ImageView)paramView.findViewById(R.h.media_mask));
        locald.khW.setOnClickListener(this.kHI);
        locald.khW.setTag(R.h.media_cbx, locald.khV);
        locald.khW.setTag(R.h.select_num, locald.kHT);
        locald.khW.setTag(R.h.media_mask, locald.kHU);
        if ((c.aXb().aXE() == 0) || (c.aXb().aXE() == 5) || (c.aXb().aXE() == 10) || (c.aXb().aXE() == 11))
        {
          locald.khV.setVisibility(8);
          locald.kHT.setVisibility(8);
          locald.khW.setVisibility(8);
          locald.kHU.setVisibility(8);
        }
        locald.kHV = ((ImageView)paramView.findViewById(R.h.gif_mask));
        locald.kHW = ((ImageView)paramView.findViewById(R.h.edit_mark_iv));
        paramView.setTag(locald);
      }
    }
    for (;;)
    {
      if (localMediaItem != null) {
        break label521;
      }
      y.e("MicroMsg.AlbumAdapter", "get item failed");
      return paramView;
      bool = false;
      break;
      locald = (d)paramView.getTag();
    }
    label521:
    locald.kHP.setVisibility(0);
    if (localMediaItem.getType() == 2)
    {
      locald.kHR.setVisibility(0);
      a.c.a(locald.kHS, (GalleryItem.VideoMediaItem)localMediaItem);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label652;
      }
      locald.kHW.setVisibility(0);
    }
    Object localObject;
    String str;
    for (;;)
    {
      localObject = localMediaItem.aXs();
      str = localMediaItem.eAu;
      if ((!bk.bl((String)localObject)) || (!bk.bl(str))) {
        break label665;
      }
      y.e("MicroMsg.AlbumAdapter", "null or nil filepath: " + i);
      return paramView;
      locald.kHR.setVisibility(8);
      break;
      label652:
      locald.kHW.setVisibility(8);
    }
    label665:
    locald.khW.setTag(R.h.media_cbx_clickarea, Integer.valueOf(i));
    i = R.l.picture_tips;
    if (localMediaItem.getType() == 2) {
      i = R.l.video_tips;
    }
    paramViewGroup = paramViewGroup.getContext().getString(i, new Object[] { Integer.valueOf(paramInt + 1 - this.kHG.size()), this.iMX.format(new Date(localMediaItem.kGY)) });
    y.d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", new Object[] { localObject, str, paramViewGroup });
    locald.kHQ.setContentDescription(paramViewGroup);
    paramViewGroup = locald.kHP;
    h.a(locald.kHQ, localMediaItem.getType(), (String)localObject, str, localMediaItem.kGX, -1, new a.1(this, paramViewGroup));
    if (this.kHH) {
      if (localMediaItem.getType() == 2)
      {
        locald.khV.setVisibility(8);
        locald.kHT.setVisibility(8);
        locald.khW.setVisibility(8);
        locald.kHU.setVisibility(8);
        if (((c.aXb().aXE() != 3) && (c.aXb().aXE() != 11)) || (localMediaItem == null) || (!localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))) {
          break label1189;
        }
        locald.kHV.setVisibility(0);
      }
    }
    for (;;)
    {
      return paramView;
      if (this.kHD.contains(localMediaItem))
      {
        locald.khV.setChecked(true);
        paramViewGroup = locald.kHT;
        localObject = new StringBuilder();
        if (localMediaItem == null) {}
        for (paramInt = -1;; paramInt = this.kHD.indexOf(localMediaItem))
        {
          paramViewGroup.setText(paramInt);
          locald.kHU.setBackgroundResource(R.e.half_alpha_black);
          locald.khW.setVisibility(0);
          locald.khV.setVisibility(0);
          locald.kHU.setVisibility(0);
          break;
        }
      }
      locald.kHT.setVisibility(8);
      locald.khV.setChecked(false);
      locald.kHU.setBackgroundResource(R.e.image_gallery_mask);
      locald.khV.setVisibility(0);
      locald.khW.setVisibility(0);
      locald.kHU.setVisibility(0);
      break;
      if (this.kHD.contains(localMediaItem))
      {
        locald.khV.setChecked(true);
        locald.kHU.setVisibility(0);
        locald.kHU.setBackgroundResource(R.e.half_alpha_black);
        break;
      }
      locald.khV.setChecked(false);
      locald.kHT.setVisibility(8);
      locald.kHU.setVisibility(0);
      locald.kHU.setBackgroundResource(R.e.image_gallery_mask);
      break;
      label1189:
      locald.kHV.setVisibility(8);
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.kHG.size() + 1;
  }
  
  public final long pm(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.kHG.size())
    {
      y.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      i = this.kHG.size();
    }
    GalleryItem.MediaItem localMediaItem = rS(i);
    Date localDate = new Date(localMediaItem.kGY);
    long l = com.tencent.mm.ui.gridviewheaders.a.cIz().b(localDate);
    y.v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(localMediaItem.kGY), localDate, Long.valueOf(l) });
    return l;
  }
  
  public final ArrayList<GalleryItem.MediaItem> rR(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kHC.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (localMediaItem.getType() == paramInt) {
        localArrayList.add(localMediaItem);
      }
    }
    return localArrayList;
  }
  
  public final GalleryItem.MediaItem rS(int paramInt)
  {
    if (paramInt < this.kHG.size())
    {
      y.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    paramInt -= this.kHG.size();
    if (paramInt >= this.kHC.size())
    {
      y.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.kHC.size()), Integer.valueOf(paramInt) });
      GalleryItem.ImageMediaItem localImageMediaItem = new GalleryItem.ImageMediaItem();
      localImageMediaItem.kGY = bk.UY();
      return localImageMediaItem;
    }
    return (GalleryItem.MediaItem)this.kHC.get(paramInt);
  }
  
  public final String rT(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.kHG.size())
    {
      y.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      i = this.kHG.size();
    }
    Date localDate = new Date(rS(i).kGY);
    return com.tencent.mm.ui.gridviewheaders.a.cIz().a(localDate, this.mContext);
  }
  
  private static final class d
  {
    public ImageView kHP;
    public ImageView kHQ;
    public RelativeLayout kHR;
    public TextView kHS;
    public TextView kHT;
    public ImageView kHU;
    public ImageView kHV;
    public ImageView kHW;
    public CheckBox khV;
    public View khW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a
 * JD-Core Version:    0.7.0.1
 */