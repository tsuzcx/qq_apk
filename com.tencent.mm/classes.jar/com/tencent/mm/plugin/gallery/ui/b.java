package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.i;
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
import java.util.concurrent.atomic.AtomicReference;

public final class b
  extends BaseAdapter
{
  LinkedList<GalleryItem.AlbumItem> CbD;
  String CbE;
  volatile int CbF;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(111496);
    this.CbE = "";
    this.mContext = paramContext;
    this.CbD = new LinkedList();
    AppMethodBeat.o(111496);
  }
  
  public final GalleryItem.AlbumItem Tb(int paramInt)
  {
    AppMethodBeat.i(111498);
    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.CbD.get(paramInt);
    AppMethodBeat.o(111498);
    return localAlbumItem;
  }
  
  public final void a(GalleryItem.PrivateAlbumItem paramPrivateAlbumItem, LinkedList<GalleryItem.PrivateAlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(179460);
    int i;
    int j;
    GalleryItem.AlbumItem localAlbumItem;
    if ((this.CbD != null) && ((paramPrivateAlbumItem != null) || (this.CbD.size() > 0))) {
      if (paramPrivateAlbumItem != null)
      {
        Log.i("MicroMsg.GalleryAdapter", "add favorite album item.");
        if (Util.isNullOrNil(this.CbD)) {
          break label187;
        }
        i = 0;
        j = -1;
        if (i >= this.CbD.size()) {
          break label181;
        }
        localAlbumItem = (GalleryItem.AlbumItem)this.CbD.get(i);
        if (!localAlbumItem.NSW) {
          break label151;
        }
      }
    }
    for (;;)
    {
      i += 1;
      if (i < this.CbD.size()) {
        this.CbD.add(i, paramPrivateAlbumItem);
      }
      for (;;)
      {
        if (paramLinkedList.size() > 0)
        {
          Log.i("MicroMsg.GalleryAdapter", "add other private album, size: [%s].", new Object[] { Integer.valueOf(paramLinkedList.size()) });
          this.CbD.addAll(paramLinkedList);
        }
        AppMethodBeat.o(179460);
        return;
        label151:
        if (localAlbumItem.MtX) {
          j = i;
        }
        i += 1;
        break;
        this.CbD.add(paramPrivateAlbumItem);
      }
      label181:
      i = j;
      continue;
      label187:
      i = -1;
    }
  }
  
  public final void euE()
  {
    AppMethodBeat.i(241381);
    if ((this.CbD == null) || (this.CbD.size() == 0))
    {
      AppMethodBeat.o(241381);
      return;
    }
    int i = 0;
    while (i < this.CbD.size())
    {
      Object localObject = (GalleryItem.AlbumItem)this.CbD.get(i);
      if ((localObject != null) && (((GalleryItem.AlbumItem)localObject).NSX))
      {
        localObject = new AtomicReference(localObject);
        e.etm().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241405);
            GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.CbG.get();
            if (localAlbumItem == null)
            {
              AppMethodBeat.o(241405);
              return;
            }
            i locali = e.etl().BVC;
            if ((localAlbumItem.NSX) && (locali != null) && (!locali.isCancelled())) {
              try
              {
                long l = System.currentTimeMillis();
                final int i = locali.aIq(localAlbumItem.albumName);
                int j = locali.aIp(localAlbumItem.albumName);
                e.etm().postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(242174);
                    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)b.1.this.CbG.get();
                    if (localAlbumItem == null)
                    {
                      AppMethodBeat.o(242174);
                      return;
                    }
                    i locali = e.etl().BVC;
                    if ((locali == null) || (locali.isCancelled()))
                    {
                      AppMethodBeat.o(242174);
                      return;
                    }
                    if (localAlbumItem.NSX)
                    {
                      localAlbumItem.fCa = this.CbI;
                      localAlbumItem.xzT = i;
                      localAlbumItem.NSX = false;
                      b.this.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(242174);
                  }
                });
                Log.d("MicroMsg.GalleryAdapter", "costTime = " + (System.currentTimeMillis() - l));
                AppMethodBeat.o(241405);
                return;
              }
              catch (Throwable localThrowable)
              {
                Log.printErrStackTrace("MicroMsg.GalleryAdapter", localThrowable, "counting album size fail", new Object[0]);
              }
            }
            AppMethodBeat.o(241405);
          }
        });
      }
      i += 1;
    }
    AppMethodBeat.o(241381);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111497);
    int i = this.CbD.size();
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
    GalleryItem.AlbumItem localAlbumItem1 = Tb(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(b.f.sd_card_medial_folder_item, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.BPW = ((ImageView)paramView.findViewById(b.e.folder_thumb));
      paramViewGroup.mrM = ((TextView)paramView.findViewById(b.e.folder_name));
      paramViewGroup.wSa = ((ImageView)paramView.findViewById(b.e.video_mask));
      paramViewGroup.CbL = ((TextView)paramView.findViewById(b.e.folder_count));
      paramViewGroup.CbM = ((ImageView)paramView.findViewById(b.e.folder_selected_iv));
      paramViewGroup.CbN = paramView.findViewById(b.e.folder_title);
      paramViewGroup.CbO = paramView.findViewById(b.e.folder_item_line_0);
      paramViewGroup.CbP = paramView.findViewById(b.e.folder_item_line_1);
      paramView.setTag(paramViewGroup);
      if (!this.CbE.equals(localAlbumItem1.albumName)) {
        break label393;
      }
      paramViewGroup.CbM.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.CbO.setVisibility(0);
      paramViewGroup.CbP.setVisibility(8);
      if ((localAlbumItem1.MtX) || (localAlbumItem1.NSW)) {
        break label404;
      }
      i = localAlbumItem1.fCa;
      if (paramInt != 0) {
        break label620;
      }
      paramViewGroup.BPW.setImageResource(b.d.pic_thumb_bg);
      if (localAlbumItem1.BVd != null) {
        h.a(paramViewGroup.BPW, localAlbumItem1.etK(), localAlbumItem1.aZe(), localAlbumItem1.etI(), localAlbumItem1.etJ(), paramInt, localAlbumItem1.exq());
      }
      paramViewGroup.BPW.setVisibility(0);
      if (e.etl().BVD != 1) {
        break label564;
      }
      localAlbumItem1.nickName = MMApplicationContext.getContext().getString(b.i.gallery_all_pic);
      label313:
      paramViewGroup.mrM.setText(localAlbumItem1.nickName);
      paramViewGroup.mrM.setVisibility(0);
      paramViewGroup.CbL.setVisibility(0);
      if (i <= 0) {
        break label608;
      }
      paramViewGroup.CbL.setText(this.mContext.getString(b.i.gallery_chooser_album_count, new Object[] { Integer.valueOf(i) }));
      label375:
      AppMethodBeat.o(111499);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label393:
      paramViewGroup.CbM.setVisibility(4);
    }
    label404:
    int j = 0;
    int i = 0;
    Object localObject;
    label427:
    GalleryItem.AlbumItem localAlbumItem2;
    if (localAlbumItem1.MtX)
    {
      localObject = this.CbD.iterator();
      if (((Iterator)localObject).hasNext())
      {
        localAlbumItem2 = (GalleryItem.AlbumItem)((Iterator)localObject).next();
        if ((localAlbumItem2.MtX) || (localAlbumItem2.NSW) || (localAlbumItem2.fCa <= 0)) {
          break label847;
        }
        i = localAlbumItem2.fCa + i;
      }
    }
    label564:
    label844:
    label847:
    for (;;)
    {
      break label427;
      break;
      localObject = this.CbD.iterator();
      i = j;
      label502:
      if (((Iterator)localObject).hasNext())
      {
        localAlbumItem2 = (GalleryItem.AlbumItem)((Iterator)localObject).next();
        if ((localAlbumItem2.MtX) || (localAlbumItem2.NSW) || (localAlbumItem2.xzT <= 0)) {
          break label844;
        }
        i = localAlbumItem2.xzT + i;
      }
      for (;;)
      {
        break label502;
        break;
        if (e.etl().BVD == 3)
        {
          localAlbumItem1.nickName = MMApplicationContext.getContext().getString(b.i.gallery_all_pic_and_video);
          break label313;
        }
        localAlbumItem1.nickName = MMApplicationContext.getContext().getString(b.i.gallery_all_video);
        break label313;
        label608:
        paramViewGroup.CbL.setText("");
        break label375;
        label620:
        paramViewGroup.BPW.setVisibility(0);
        paramViewGroup.mrM.setVisibility(0);
        paramViewGroup.mrM.setText(localAlbumItem1.nickName);
        paramViewGroup.CbL.setVisibility(0);
        if (i > 0)
        {
          paramViewGroup.CbL.setText(this.mContext.getString(b.i.gallery_chooser_album_count, new Object[] { Integer.valueOf(i) }));
          paramViewGroup.CbN.setVisibility(8);
          localObject = localAlbumItem1.aZe();
          if (Util.isNullOrNil((String)localObject)) {
            break label763;
          }
          h.a(paramViewGroup.BPW, localAlbumItem1.etK(), (String)localObject, localAlbumItem1.etI(), localAlbumItem1.etJ(), paramInt, localAlbumItem1.exq());
        }
        for (;;)
        {
          AppMethodBeat.o(111499);
          return paramView;
          paramViewGroup.CbL.setText("");
          break;
          label763:
          if ((localAlbumItem1.BVd != null) && (localAlbumItem1.BVd.getType() == 2))
          {
            h.a(paramViewGroup.BPW, localAlbumItem1.etK(), null, localAlbumItem1.etI(), localAlbumItem1.etJ(), paramInt, localAlbumItem1.exq());
          }
          else
          {
            Log.e("MicroMsg.GalleryAdapter", "get folder failed");
            paramViewGroup.BPW.setVisibility(8);
            paramViewGroup.mrM.setVisibility(8);
          }
        }
      }
    }
  }
  
  static final class a
  {
    public ImageView BPW;
    public TextView CbL;
    public ImageView CbM;
    public View CbN;
    View CbO;
    View CbP;
    public TextView mrM;
    public ImageView wSa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */