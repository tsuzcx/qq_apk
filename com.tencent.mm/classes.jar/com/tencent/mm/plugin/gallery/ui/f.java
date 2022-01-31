package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.a.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class f
  extends RecyclerView.a<f.a>
  implements View.OnClickListener
{
  private boolean kIW;
  private ArrayList<String> kJF;
  c kKk;
  private int kKl;
  ArrayList<String> kKm = new ArrayList();
  f.b kKn;
  private int kKo = -1;
  private int kKp = -1;
  private int kKq;
  private int kKr;
  private Drawable kKs;
  a kKt = new a(new f.1(this));
  private Context mContext;
  
  public f(Context paramContext, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.kJF = paramArrayList;
    this.kKm.addAll(paramArrayList);
    this.kKl = paramInt;
    this.kIW = paramBoolean;
    this.kKs = paramContext.getResources().getDrawable(R.g.divider);
  }
  
  private GalleryItem.MediaItem a(int paramInt, f.a parama)
  {
    if ((paramInt < 0) || (paramInt >= this.kKm.size()))
    {
      y.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kKm.size()) });
      return null;
    }
    Object localObject = (String)this.kKm.get(paramInt);
    GalleryItem.MediaItem localMediaItem;
    if (this.kIW)
    {
      if (this.kKk.kHC != null)
      {
        localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = this.kKk.kHC.indexOf(localObject);
        if (paramInt >= 0)
        {
          parama.kKA = paramInt;
          return (GalleryItem.MediaItem)this.kKk.kHC.get(paramInt);
        }
        parama = com.tencent.mm.plugin.gallery.model.c.aXg().iterator();
        while (parama.hasNext())
        {
          localMediaItem = (GalleryItem.MediaItem)parama.next();
          if (localMediaItem.equals(localObject))
          {
            y.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { localMediaItem.eAu });
            return localMediaItem;
          }
        }
        return null;
      }
    }
    else
    {
      if (com.tencent.mm.plugin.gallery.model.c.aXd() != null)
      {
        parama = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = com.tencent.mm.plugin.gallery.model.c.aXd().indexOf(parama);
        if (paramInt >= 0) {
          return (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.c.aXd().get(paramInt);
        }
        localObject = com.tencent.mm.plugin.gallery.model.c.aXg().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
          if (localMediaItem.equals(parama))
          {
            y.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { localMediaItem.eAu });
            return localMediaItem;
          }
        }
        return null;
      }
      return GalleryItem.MediaItem.a(1, 0L, (String)localObject, (String)localObject, "");
    }
    return null;
  }
  
  private void a(f.a parama, int paramInt)
  {
    GalleryItem.MediaItem localMediaItem = a(paramInt, parama);
    if (localMediaItem == null)
    {
      y.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
      return;
    }
    Object localObject = parama.kKz.getLayoutParams();
    int i = this.kKl;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    c(parama.kHP, localMediaItem.eAu, paramInt);
    parama.kKz.setOnClickListener(this);
    if (this.kIW)
    {
      parama.kKz.setTag(Integer.valueOf(parama.kKA));
      if (localMediaItem.getType() != 2) {
        break label232;
      }
      parama.kHR.setVisibility(0);
      i = Math.round((float)((GalleryItem.VideoMediaItem)localMediaItem).eAx / 1000.0F);
      parama.kHS.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    }
    String str;
    for (;;)
    {
      localObject = localMediaItem.aXs();
      str = localMediaItem.eAu;
      if ((!bk.bl((String)localObject)) || (!bk.bl(str))) {
        break label244;
      }
      y.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: " + paramInt);
      return;
      parama.kKz.setTag(localMediaItem.eAu);
      break;
      label232:
      parama.kHR.setVisibility(8);
    }
    label244:
    h.a(parama.kHQ, localMediaItem.getType(), (String)localObject, str, localMediaItem.kGX, this.kKl, new f.2(this, parama));
    if (((com.tencent.mm.plugin.gallery.model.c.aXb().aXE() == 3) || (com.tencent.mm.plugin.gallery.model.c.aXb().aXE() == 11)) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      parama.kHV.setVisibility(0);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label370;
      }
      parama.kHW.setVisibility(0);
    }
    for (;;)
    {
      parama.kKy.setVisibility(8);
      return;
      parama.kHV.setVisibility(8);
      break;
      label370:
      parama.kHW.setVisibility(8);
    }
  }
  
  private void c(ImageView paramImageView, String paramString, int paramInt)
  {
    int i;
    if (this.kJF.contains(paramString))
    {
      paramImageView.setBackground(null);
      paramImageView.setImageDrawable(this.kKs);
      i = 0;
      paramImageView.setVisibility(0);
      if ((bk.bl(this.kKk.ke(this.kKq))) || (!this.kKk.ke(this.kKq).equals(paramString))) {
        break label112;
      }
      paramImageView.setVisibility(0);
      if ((i != 0) && (paramInt == this.kKr)) {
        paramImageView.setImageDrawable(this.kKs);
      }
    }
    label112:
    do
    {
      do
      {
        return;
        paramImageView.setBackgroundColor(-1090519041);
        paramImageView.setImageDrawable(null);
        i = 1;
        break;
      } while ((bk.bl(this.kKk.ke(this.kKq))) || (this.kKk.ke(this.kKq).equals(paramString)));
      if ((paramInt != this.kKr) && (i == 0))
      {
        paramImageView.setVisibility(8);
        return;
      }
    } while ((paramInt != this.kKr) || (i != 0));
    paramImageView.setImageDrawable(this.kKs);
  }
  
  public final void cX(int paramInt1, int paramInt2)
  {
    this.kKr = paramInt1;
    this.kKq = paramInt2;
  }
  
  public final int getItemCount()
  {
    return this.kKm.size();
  }
  
  public final void onClick(View paramView)
  {
    if (this.kKn != null)
    {
      if (this.kIW) {
        this.kKn.sc(((Integer)paramView.getTag()).intValue());
      }
    }
    else {
      return;
    }
    this.kKn.sc(this.kKm.indexOf(paramView.getTag()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */