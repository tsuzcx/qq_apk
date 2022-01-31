package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class b
  extends BaseAdapter
{
  private int kHp;
  ArrayList<GalleryItem.AlbumItem> kIO;
  GalleryItem.AlbumItem kIP;
  String kIQ = "";
  private int kIR = 0;
  private Context mContext;
  
  public b(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.kIO = new ArrayList();
    this.kHp = paramInt;
    this.kIP = new GalleryItem.AlbumItem("", 0);
    this.kIP.kGU = new GalleryItem.ImageMediaItem();
    this.kIR = paramContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
  }
  
  public final int getCount()
  {
    return this.kIO.size() + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    y.i("MicroMsg.GalleryAdapter", "duanyi test getview:" + paramInt);
    GalleryItem.AlbumItem localAlbumItem = rW(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.sd_card_medial_folder_item, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.kHQ = ((ImageView)paramView.findViewById(R.h.folder_thumb));
      paramViewGroup.eXP = ((TextView)paramView.findViewById(R.h.folder_name));
      paramViewGroup.kiI = ((ImageView)paramView.findViewById(R.h.video_mask));
      paramViewGroup.kIS = ((TextView)paramView.findViewById(R.h.folder_count));
      paramViewGroup.kIT = ((ImageView)paramView.findViewById(R.h.folder_selected_iv));
      paramView.setTag(paramViewGroup);
      if (!this.kIQ.equals(localAlbumItem.kGT)) {
        break label268;
      }
      paramViewGroup.kIT.setVisibility(0);
      label155:
      if (paramInt != 0) {
        break label315;
      }
      paramViewGroup.kHQ.setImageResource(R.g.pic_thumb_bg);
      if (localAlbumItem.kGU != null) {
        h.a(paramViewGroup.kHQ, localAlbumItem.kGU.getType(), localAlbumItem.aXs(), localAlbumItem.kGU.eAu, localAlbumItem.aXt());
      }
      if (c.aXb().aXF() != 1) {
        break label279;
      }
      paramViewGroup.eXP.setText(R.l.gallery_all_pic);
    }
    for (;;)
    {
      paramViewGroup.kHQ.setVisibility(0);
      paramViewGroup.eXP.setVisibility(0);
      paramViewGroup.kIS.setVisibility(8);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label268:
      paramViewGroup.kIT.setVisibility(4);
      break label155;
      label279:
      if (c.aXb().aXF() == 3) {
        paramViewGroup.eXP.setText(R.l.gallery_all_pic_and_video);
      } else {
        paramViewGroup.eXP.setText(R.l.gallery_all_video);
      }
    }
    label315:
    paramViewGroup.kHQ.setVisibility(0);
    paramViewGroup.eXP.setVisibility(0);
    paramViewGroup.eXP.setText(localAlbumItem.kGT);
    paramViewGroup.kIS.setVisibility(0);
    paramViewGroup.kIS.setText(this.mContext.getString(R.l.gallery_pic_count, new Object[] { Integer.valueOf(localAlbumItem.bLO) }));
    Object localObject;
    if ((paramViewGroup.kiI != null) && (localAlbumItem.kGU != null))
    {
      localObject = paramViewGroup.kiI;
      if (localAlbumItem.kGU.getType() != 2) {
        break label479;
      }
    }
    label479:
    for (paramInt = 0;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      localObject = localAlbumItem.aXs();
      if ((bk.bl((String)localObject)) || (localAlbumItem.kGU == null)) {
        break;
      }
      h.a(paramViewGroup.kHQ, localAlbumItem.kGU.getType(), (String)localObject, localAlbumItem.kGU.eAu, localAlbumItem.aXt());
      return paramView;
    }
    if ((localAlbumItem.kGU != null) && (localAlbumItem.kGU.getType() == 2))
    {
      h.a(paramViewGroup.kHQ, localAlbumItem.kGU.getType(), null, localAlbumItem.kGU.eAu, localAlbumItem.aXt());
      return paramView;
    }
    y.e("MicroMsg.GalleryAdapter", "get folder failed");
    paramViewGroup.kHQ.setVisibility(8);
    paramViewGroup.eXP.setVisibility(8);
    return paramView;
  }
  
  public final GalleryItem.AlbumItem rW(int paramInt)
  {
    if (paramInt == 0) {
      return this.kIP;
    }
    return (GalleryItem.AlbumItem)this.kIO.get(paramInt - 1);
  }
  
  private static final class a
  {
    public TextView eXP;
    public ImageView kHQ;
    public TextView kIS;
    public ImageView kIT;
    public ImageView kiI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */