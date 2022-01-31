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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class f
  extends RecyclerView.a<f.a>
  implements View.OnClickListener
{
  private Context mContext;
  private boolean nft;
  c ngK;
  private int ngL;
  ArrayList<String> ngM;
  f.b ngN;
  private int ngO;
  private int ngP;
  private int ngQ;
  private int ngR;
  private Drawable ngS;
  a ngT;
  private ArrayList<String> ngd;
  
  public f(Context paramContext, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(21578);
    this.ngM = new ArrayList();
    this.ngO = -1;
    this.ngP = -1;
    this.ngT = new a(new f.1(this));
    this.mContext = paramContext;
    this.ngd = paramArrayList;
    this.ngM.addAll(paramArrayList);
    this.ngL = paramInt;
    this.nft = paramBoolean;
    if (e.bDQ().hQK == 15)
    {
      this.ngS = paramContext.getResources().getDrawable(2130839020);
      AppMethodBeat.o(21578);
      return;
    }
    this.ngS = paramContext.getResources().getDrawable(2130838558);
    AppMethodBeat.o(21578);
  }
  
  private GalleryItem.MediaItem a(int paramInt, f.a parama)
  {
    AppMethodBeat.i(21586);
    if ((paramInt < 0) || (paramInt >= this.ngM.size()))
    {
      ab.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ngM.size()) });
      AppMethodBeat.o(21586);
      return null;
    }
    Object localObject = (String)this.ngM.get(paramInt);
    if (this.nft)
    {
      if (this.ngK.ndM == null) {
        break label324;
      }
      localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
      paramInt = this.ngK.ndM.indexOf(localObject);
      if (paramInt >= 0)
      {
        parama.nha = paramInt;
        parama = (GalleryItem.MediaItem)this.ngK.ndM.get(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(21586);
      return parama;
      Iterator localIterator = e.bDV().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          parama = (GalleryItem.MediaItem)localIterator.next();
          if (parama.equals(localObject))
          {
            ab.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.fQn });
            break;
          }
        }
      }
      parama = null;
      continue;
      if (e.bDS() != null)
      {
        localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = e.bDS().indexOf(localObject);
        if (paramInt >= 0)
        {
          parama = (GalleryItem.MediaItem)e.bDS().get(paramInt);
        }
        else
        {
          localIterator = e.bDV().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              parama = (GalleryItem.MediaItem)localIterator.next();
              if (parama.equals(localObject))
              {
                ab.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.fQn });
                break;
              }
            }
          }
          parama = null;
        }
      }
      else
      {
        parama = GalleryItem.MediaItem.a(1, 0L, (String)localObject, (String)localObject, "");
        continue;
        label324:
        parama = null;
      }
    }
  }
  
  private void a(f.a parama, int paramInt)
  {
    AppMethodBeat.i(21582);
    GalleryItem.MediaItem localMediaItem = a(paramInt, parama);
    if (localMediaItem == null)
    {
      ab.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
      AppMethodBeat.o(21582);
      return;
    }
    Object localObject = parama.ngZ.getLayoutParams();
    int i = this.ngL;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    c(parama.neb, localMediaItem.fQn, paramInt);
    parama.ngZ.setOnClickListener(this);
    if (this.nft)
    {
      parama.ngZ.setTag(Integer.valueOf(parama.nha));
      if (localMediaItem.getType() != 2) {
        break label244;
      }
      parama.nec.setVisibility(0);
      i = Math.round((float)((GalleryItem.VideoMediaItem)localMediaItem).fQq / 1000.0F);
      parama.ned.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    }
    String str;
    for (;;)
    {
      localObject = localMediaItem.Xi();
      str = localMediaItem.fQn;
      if ((!bo.isNullOrNil((String)localObject)) || (!bo.isNullOrNil(str))) {
        break label256;
      }
      ab.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(21582);
      return;
      parama.ngZ.setTag(localMediaItem.fQn);
      break;
      label244:
      parama.nec.setVisibility(8);
    }
    label256:
    h.a(parama.mZY, localMediaItem.getType(), (String)localObject, str, localMediaItem.ndp, this.ngL, new f.2(this, parama));
    if (((e.bDQ().hQK == 3) || (e.bDQ().hQK == 11)) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      parama.neg.setVisibility(0);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label388;
      }
      parama.neh.setVisibility(0);
    }
    for (;;)
    {
      parama.ngY.setVisibility(8);
      AppMethodBeat.o(21582);
      return;
      parama.neg.setVisibility(8);
      break;
      label388:
      parama.neh.setVisibility(8);
    }
  }
  
  private void c(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(21583);
    if (this.ngd.contains(paramString))
    {
      paramImageView.setBackground(null);
      paramImageView.setImageDrawable(this.ngS);
    }
    for (int i = 0;; i = 1)
    {
      paramImageView.setVisibility(0);
      if ((bo.isNullOrNil(this.ngK.getItem(this.ngQ))) || (!this.ngK.getItem(this.ngQ).equals(paramString))) {
        break;
      }
      paramImageView.setVisibility(0);
      if ((i == 0) || (paramInt != this.ngR)) {
        break label206;
      }
      paramImageView.setImageDrawable(this.ngS);
      AppMethodBeat.o(21583);
      return;
      paramImageView.setBackgroundColor(-1090519041);
      paramImageView.setImageDrawable(null);
    }
    if ((!bo.isNullOrNil(this.ngK.getItem(this.ngQ))) && (!this.ngK.getItem(this.ngQ).equals(paramString)))
    {
      if ((paramInt != this.ngR) && (i == 0))
      {
        paramImageView.setVisibility(8);
        AppMethodBeat.o(21583);
        return;
      }
      if ((paramInt == this.ngR) && (i == 0)) {
        paramImageView.setImageDrawable(this.ngS);
      }
    }
    label206:
    AppMethodBeat.o(21583);
  }
  
  public final void addItem(String paramString)
  {
    AppMethodBeat.i(21579);
    this.ngM.add(paramString);
    AppMethodBeat.o(21579);
  }
  
  public final void eu(int paramInt1, int paramInt2)
  {
    this.ngR = paramInt1;
    this.ngQ = paramInt2;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(21584);
    int i = this.ngM.size();
    AppMethodBeat.o(21584);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(21580);
    int i = this.ngM.indexOf(paramString);
    AppMethodBeat.o(21580);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21585);
    if (this.ngN != null)
    {
      if (this.nft)
      {
        this.ngN.wY(((Integer)paramView.getTag()).intValue());
        AppMethodBeat.o(21585);
        return;
      }
      this.ngN.wY(this.ngM.indexOf(paramView.getTag()));
    }
    AppMethodBeat.o(21585);
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(21581);
    this.ngM.remove(paramInt);
    AppMethodBeat.o(21581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f
 * JD-Core Version:    0.7.0.1
 */