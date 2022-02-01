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
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  LinkedList<GalleryItem.AlbumItem> xpj;
  String xpk;
  volatile int xpl;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(111496);
    this.xpk = "";
    this.mContext = paramContext;
    this.xpj = new LinkedList();
    AppMethodBeat.o(111496);
  }
  
  public final GalleryItem.AlbumItem NN(int paramInt)
  {
    AppMethodBeat.i(111498);
    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.xpj.get(paramInt);
    AppMethodBeat.o(111498);
    return localAlbumItem;
  }
  
  public final void a(GalleryItem.PrivateAlbumItem paramPrivateAlbumItem, LinkedList<GalleryItem.PrivateAlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(179460);
    int i;
    int j;
    GalleryItem.AlbumItem localAlbumItem;
    if ((this.xpj != null) && ((paramPrivateAlbumItem != null) || (this.xpj.size() > 0))) {
      if (paramPrivateAlbumItem != null)
      {
        Log.i("MicroMsg.GalleryAdapter", "add favorite album item.");
        if (Util.isNullOrNil(this.xpj)) {
          break label187;
        }
        i = 0;
        j = -1;
        if (i >= this.xpj.size()) {
          break label181;
        }
        localAlbumItem = (GalleryItem.AlbumItem)this.xpj.get(i);
        if (!localAlbumItem.Uqb) {
          break label151;
        }
      }
    }
    for (;;)
    {
      i += 1;
      if (i < this.xpj.size()) {
        this.xpj.add(i, paramPrivateAlbumItem);
      }
      for (;;)
      {
        if (paramLinkedList.size() > 0)
        {
          Log.i("MicroMsg.GalleryAdapter", "add other private album, size: [%s].", new Object[] { Integer.valueOf(paramLinkedList.size()) });
          this.xpj.addAll(paramLinkedList);
        }
        AppMethodBeat.o(179460);
        return;
        label151:
        if (localAlbumItem.Uqa) {
          j = i;
        }
        i += 1;
        break;
        this.xpj.add(paramPrivateAlbumItem);
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
    int i = this.xpj.size();
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
    Log.i("MicroMsg.GalleryAdapter", "duanyi test getView:".concat(String.valueOf(paramInt)));
    GalleryItem.AlbumItem localAlbumItem1 = NN(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131496169, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.xdY = ((ImageView)paramView.findViewById(2131301643));
      paramViewGroup.jBR = ((TextView)paramView.findViewById(2131301638));
      paramViewGroup.tlC = ((ImageView)paramView.findViewById(2131309781));
      paramViewGroup.xpr = ((TextView)paramView.findViewById(2131301634));
      paramViewGroup.xps = ((ImageView)paramView.findViewById(2131301642));
      paramViewGroup.xpt = paramView.findViewById(2131301644);
      paramViewGroup.xpu = paramView.findViewById(2131301636);
      paramViewGroup.xpv = paramView.findViewById(2131301637);
      paramView.setTag(paramViewGroup);
      if (!this.xpk.equals(localAlbumItem1.albumName)) {
        break label383;
      }
      paramViewGroup.xps.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.xpu.setVisibility(0);
      paramViewGroup.xpv.setVisibility(8);
      if ((localAlbumItem1.Uqa) || (localAlbumItem1.Uqb)) {
        break label394;
      }
      i = localAlbumItem1.dJl;
      if (paramInt != 0) {
        break label610;
      }
      paramViewGroup.xdY.setImageResource(2131234422);
      if (localAlbumItem1.UpZ != null) {
        h.a(paramViewGroup.xdY, localAlbumItem1.dRj(), localAlbumItem1.aQn(), localAlbumItem1.dRh(), localAlbumItem1.dRi(), paramInt, localAlbumItem1.gEV());
      }
      paramViewGroup.xdY.setVisibility(0);
      if (e.dQK().xjo != 1) {
        break label554;
      }
      localAlbumItem1.nickName = MMApplicationContext.getContext().getString(2131761081);
      label303:
      paramViewGroup.jBR.setText(localAlbumItem1.nickName);
      paramViewGroup.jBR.setVisibility(0);
      paramViewGroup.xpr.setVisibility(0);
      if (i <= 0) {
        break label598;
      }
      paramViewGroup.xpr.setText(this.mContext.getString(2131761086, new Object[] { Integer.valueOf(i) }));
      label365:
      AppMethodBeat.o(111499);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label383:
      paramViewGroup.xps.setVisibility(4);
    }
    label394:
    int j = 0;
    int i = 0;
    Object localObject;
    label417:
    GalleryItem.AlbumItem localAlbumItem2;
    if (localAlbumItem1.Uqa)
    {
      localObject = this.xpj.iterator();
      if (((Iterator)localObject).hasNext())
      {
        localAlbumItem2 = (GalleryItem.AlbumItem)((Iterator)localObject).next();
        if ((localAlbumItem2.Uqa) || (localAlbumItem2.Uqb) || (localAlbumItem2.dJl <= 0)) {
          break label895;
        }
        i = localAlbumItem2.dJl + i;
      }
    }
    label492:
    label892:
    label895:
    for (;;)
    {
      break label417;
      break;
      localObject = this.xpj.iterator();
      i = j;
      if (((Iterator)localObject).hasNext())
      {
        localAlbumItem2 = (GalleryItem.AlbumItem)((Iterator)localObject).next();
        if ((localAlbumItem2.Uqa) || (localAlbumItem2.Uqb) || (localAlbumItem2.xiP <= 0)) {
          break label892;
        }
        i = localAlbumItem2.xiP + i;
      }
      for (;;)
      {
        break label492;
        break;
        if (e.dQK().xjo == 3)
        {
          localAlbumItem1.nickName = MMApplicationContext.getContext().getString(2131761082);
          break label303;
        }
        localAlbumItem1.nickName = MMApplicationContext.getContext().getString(2131761083);
        break label303;
        paramViewGroup.xpr.setText("");
        break label365;
        paramViewGroup.xdY.setVisibility(0);
        paramViewGroup.jBR.setVisibility(0);
        paramViewGroup.jBR.setText(localAlbumItem1.nickName);
        paramViewGroup.xpr.setVisibility(0);
        if (i > 0)
        {
          paramViewGroup.xpr.setText(this.mContext.getString(2131761086, new Object[] { Integer.valueOf(i) }));
          paramViewGroup.xpt.setVisibility(8);
          localObject = localAlbumItem1.aQn();
          if (Util.isNullOrNil((String)localObject)) {
            break label811;
          }
          h.a(paramViewGroup.xdY, localAlbumItem1.dRj(), (String)localObject, localAlbumItem1.dRh(), localAlbumItem1.dRi(), paramInt, localAlbumItem1.gEV());
        }
        for (;;)
        {
          AppMethodBeat.o(111499);
          return paramView;
          paramViewGroup.xpr.setText("");
          localObject = e.dQK().xjn;
          if ((!localAlbumItem1.Uqc) || (localObject == null) || (((i)localObject).isCancelled())) {
            break;
          }
          localObject = new AtomicReference(localAlbumItem1);
          e.dQL().as(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(257747);
              GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.xpm.get();
              if (localAlbumItem == null)
              {
                AppMethodBeat.o(257747);
                return;
              }
              i locali = e.dQK().xjn;
              if ((localAlbumItem.Uqc) && (locali != null) && (!locali.isCancelled())) {
                try
                {
                  final int i = locali.a(localAlbumItem.albumName, 3, null, System.currentTimeMillis()).size();
                  final int j = locali.a(localAlbumItem.albumName, 2, null, System.currentTimeMillis()).size();
                  e.dQL().postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(257746);
                      GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)b.1.this.xpm.get();
                      if (localAlbumItem == null)
                      {
                        AppMethodBeat.o(257746);
                        return;
                      }
                      i locali = e.dQK().xjn;
                      if ((localAlbumItem.Uqc) && (locali != null) && (!locali.isCancelled()))
                      {
                        localAlbumItem.dJl = i;
                        localAlbumItem.xiP = j;
                        localAlbumItem.Uqc = false;
                        b.this.notifyDataSetChanged();
                      }
                      AppMethodBeat.o(257746);
                    }
                  });
                  AppMethodBeat.o(257747);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  Log.printErrStackTrace("MicroMsg.GalleryAdapter", localThrowable, "counting album size fail", new Object[0]);
                }
              }
              AppMethodBeat.o(257747);
            }
          });
          break;
          if ((localAlbumItem1.UpZ != null) && (localAlbumItem1.UpZ.getType() == 2))
          {
            h.a(paramViewGroup.xdY, localAlbumItem1.dRj(), null, localAlbumItem1.dRh(), localAlbumItem1.dRi(), paramInt, localAlbumItem1.gEV());
          }
          else
          {
            Log.e("MicroMsg.GalleryAdapter", "get folder failed");
            paramViewGroup.xdY.setVisibility(8);
            paramViewGroup.jBR.setVisibility(8);
          }
        }
      }
    }
  }
  
  static final class a
  {
    public TextView jBR;
    public ImageView tlC;
    public ImageView xdY;
    public TextView xpr;
    public ImageView xps;
    public View xpt;
    View xpu;
    View xpv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */