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
import com.tencent.mm.plugin.gallery.model.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public final class b
  extends BaseAdapter
{
  LinkedList<GalleryItem.AlbumItem> HNF;
  String HNG;
  volatile int HNH;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(111496);
    this.HNG = "";
    this.mContext = paramContext;
    this.HNF = new LinkedList();
    AppMethodBeat.o(111496);
  }
  
  public final GalleryItem.AlbumItem WJ(int paramInt)
  {
    AppMethodBeat.i(111498);
    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.HNF.get(paramInt);
    AppMethodBeat.o(111498);
    return localAlbumItem;
  }
  
  public final void a(PrivateAlbumItem paramPrivateAlbumItem, LinkedList<PrivateAlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(289500);
    int i;
    int j;
    GalleryItem.AlbumItem localAlbumItem;
    if ((this.HNF != null) && ((paramPrivateAlbumItem != null) || (this.HNF.size() > 0))) {
      if (paramPrivateAlbumItem != null)
      {
        Log.i("MicroMsg.GalleryAdapter", "add favorite album item.");
        if (Util.isNullOrNil(this.HNF)) {
          break label187;
        }
        i = 0;
        j = -1;
        if (i >= this.HNF.size()) {
          break label181;
        }
        localAlbumItem = (GalleryItem.AlbumItem)this.HNF.get(i);
        if (!localAlbumItem.akiv) {
          break label151;
        }
      }
    }
    for (;;)
    {
      i += 1;
      if (i < this.HNF.size()) {
        this.HNF.add(i, paramPrivateAlbumItem);
      }
      for (;;)
      {
        if (paramLinkedList.size() > 0)
        {
          Log.i("MicroMsg.GalleryAdapter", "add other private album, size: [%s].", new Object[] { Integer.valueOf(paramLinkedList.size()) });
          this.HNF.addAll(paramLinkedList);
        }
        AppMethodBeat.o(289500);
        return;
        label151:
        if (localAlbumItem.akiu) {
          j = i;
        }
        i += 1;
        break;
        this.HNF.add(paramPrivateAlbumItem);
      }
      label181:
      i = j;
      continue;
      label187:
      i = -1;
    }
  }
  
  public final void fBA()
  {
    AppMethodBeat.i(289534);
    if ((this.HNF == null) || (this.HNF.size() == 0))
    {
      AppMethodBeat.o(289534);
      return;
    }
    int i = 0;
    while (i < this.HNF.size())
    {
      Object localObject = (GalleryItem.AlbumItem)this.HNF.get(i);
      if ((localObject != null) && (((GalleryItem.AlbumItem)localObject).akiw))
      {
        localObject = new AtomicReference(localObject);
        e.fAo().aH(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(289493);
            GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)this.HNI.get();
            if (localAlbumItem == null)
            {
              AppMethodBeat.o(289493);
              return;
            }
            l locall = e.fAn().HHZ;
            if ((localAlbumItem.akiw) && (locall != null) && (!locall.isCancelled())) {
              try
              {
                long l = System.currentTimeMillis();
                final int i = localAlbumItem.AXs;
                final int j = localAlbumItem.hGP;
                e.fAo().postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(289557);
                    GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)b.1.this.HNI.get();
                    if (localAlbumItem == null)
                    {
                      AppMethodBeat.o(289557);
                      return;
                    }
                    l locall = e.fAn().HHZ;
                    if ((locall == null) || (locall.isCancelled()))
                    {
                      AppMethodBeat.o(289557);
                      return;
                    }
                    if (localAlbumItem.akiw)
                    {
                      localAlbumItem.hGP = j;
                      localAlbumItem.AXs = i;
                      localAlbumItem.akiw = false;
                      b.this.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(289557);
                  }
                });
                Log.d("MicroMsg.GalleryAdapter", "costTime = " + (System.currentTimeMillis() - l));
                AppMethodBeat.o(289493);
                return;
              }
              finally
              {
                Log.printErrStackTrace("MicroMsg.GalleryAdapter", localThrowable, "counting album size fail", new Object[0]);
              }
            }
            AppMethodBeat.o(289493);
          }
        });
      }
      i += 1;
    }
    AppMethodBeat.o(289534);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(111497);
    int i = this.HNF.size();
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
    GalleryItem.AlbumItem localAlbumItem1 = WJ(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(b.f.sd_card_medial_folder_item, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.HLM = ((ImageView)paramView.findViewById(b.e.folder_thumb));
      paramViewGroup.plr = ((TextView)paramView.findViewById(b.e.folder_name));
      paramViewGroup.AoD = ((ImageView)paramView.findViewById(b.e.video_mask));
      paramViewGroup.HNN = ((TextView)paramView.findViewById(b.e.folder_count));
      paramViewGroup.HNO = ((ImageView)paramView.findViewById(b.e.folder_selected_iv));
      paramViewGroup.HNP = paramView.findViewById(b.e.folder_title);
      paramViewGroup.HNQ = paramView.findViewById(b.e.folder_item_line_0);
      paramViewGroup.HNR = paramView.findViewById(b.e.folder_item_line_1);
      paramView.setTag(paramViewGroup);
      if (!this.HNG.equals(localAlbumItem1.albumName)) {
        break label393;
      }
      paramViewGroup.HNO.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.HNQ.setVisibility(0);
      paramViewGroup.HNR.setVisibility(8);
      if ((localAlbumItem1.akiu) || (localAlbumItem1.akiv)) {
        break label404;
      }
      i = localAlbumItem1.hGP;
      if (paramInt != 0) {
        break label620;
      }
      paramViewGroup.HLM.setImageResource(b.d.pic_thumb_bg);
      if (localAlbumItem1.HHB != null) {
        h.a(paramViewGroup.HLM, localAlbumItem1.fAL(), localAlbumItem1.bud(), localAlbumItem1.fAJ(), localAlbumItem1.fAK(), paramInt, localAlbumItem1.kLG());
      }
      paramViewGroup.HLM.setVisibility(0);
      if (e.fAn().HIa != 1) {
        break label564;
      }
      localAlbumItem1.nickName = MMApplicationContext.getContext().getString(b.i.gallery_all_pic);
      label313:
      paramViewGroup.plr.setText(localAlbumItem1.nickName);
      paramViewGroup.plr.setVisibility(0);
      paramViewGroup.HNN.setVisibility(0);
      if (i <= 0) {
        break label608;
      }
      paramViewGroup.HNN.setText(this.mContext.getString(b.i.gallery_chooser_album_count, new Object[] { Integer.valueOf(i) }));
      label375:
      AppMethodBeat.o(111499);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label393:
      paramViewGroup.HNO.setVisibility(4);
    }
    label404:
    int j = 0;
    int i = 0;
    Object localObject;
    label427:
    GalleryItem.AlbumItem localAlbumItem2;
    if (localAlbumItem1.akiu)
    {
      localObject = this.HNF.iterator();
      if (((Iterator)localObject).hasNext())
      {
        localAlbumItem2 = (GalleryItem.AlbumItem)((Iterator)localObject).next();
        if ((localAlbumItem2.akiu) || (localAlbumItem2.akiv) || (localAlbumItem2.hGP <= 0)) {
          break label847;
        }
        i = localAlbumItem2.hGP + i;
      }
    }
    label564:
    label844:
    label847:
    for (;;)
    {
      break label427;
      break;
      localObject = this.HNF.iterator();
      i = j;
      label502:
      if (((Iterator)localObject).hasNext())
      {
        localAlbumItem2 = (GalleryItem.AlbumItem)((Iterator)localObject).next();
        if ((localAlbumItem2.akiu) || (localAlbumItem2.akiv) || (localAlbumItem2.AXs <= 0)) {
          break label844;
        }
        i = localAlbumItem2.AXs + i;
      }
      for (;;)
      {
        break label502;
        break;
        if (e.fAn().HIa == 3)
        {
          localAlbumItem1.nickName = MMApplicationContext.getContext().getString(b.i.gallery_all_pic_and_video);
          break label313;
        }
        localAlbumItem1.nickName = MMApplicationContext.getContext().getString(b.i.gallery_all_video);
        break label313;
        label608:
        paramViewGroup.HNN.setText("");
        break label375;
        label620:
        paramViewGroup.HLM.setVisibility(0);
        paramViewGroup.plr.setVisibility(0);
        paramViewGroup.plr.setText(localAlbumItem1.nickName);
        paramViewGroup.HNN.setVisibility(0);
        if (i > 0)
        {
          paramViewGroup.HNN.setText(this.mContext.getString(b.i.gallery_chooser_album_count, new Object[] { Integer.valueOf(i) }));
          paramViewGroup.HNP.setVisibility(8);
          localObject = localAlbumItem1.bud();
          if (Util.isNullOrNil((String)localObject)) {
            break label763;
          }
          h.a(paramViewGroup.HLM, localAlbumItem1.fAL(), (String)localObject, localAlbumItem1.fAJ(), localAlbumItem1.fAK(), paramInt, localAlbumItem1.kLG());
        }
        for (;;)
        {
          AppMethodBeat.o(111499);
          return paramView;
          paramViewGroup.HNN.setText("");
          break;
          label763:
          if ((localAlbumItem1.HHB != null) && (localAlbumItem1.HHB.getType() == 2))
          {
            h.a(paramViewGroup.HLM, localAlbumItem1.fAL(), null, localAlbumItem1.fAJ(), localAlbumItem1.fAK(), paramInt, localAlbumItem1.kLG());
          }
          else
          {
            Log.e("MicroMsg.GalleryAdapter", "get folder failed");
            paramViewGroup.HLM.setVisibility(8);
            paramViewGroup.plr.setVisibility(8);
          }
        }
      }
    }
  }
  
  static final class a
  {
    public ImageView AoD;
    public ImageView HLM;
    public TextView HNN;
    public ImageView HNO;
    public View HNP;
    View HNQ;
    View HNR;
    public TextView plr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.b
 * JD-Core Version:    0.7.0.1
 */