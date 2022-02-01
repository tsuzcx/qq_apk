package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class a
  extends RecyclerView.a<RecyclerView.v>
{
  int kyt;
  private Context mContext;
  private View.OnClickListener mOnClickListener;
  private SimpleDateFormat qDM;
  int xjo;
  int xnn;
  ArrayList<GalleryItem.MediaItem> xno;
  ArrayList<GalleryItem.MediaItem> xnp;
  private e xnq;
  String xnr;
  LinkedList<d> xns;
  boolean xnt;
  private View.OnLongClickListener xnu;
  private View.OnClickListener xnv;
  f xnw;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(111407);
    this.xnn = 9;
    this.xno = new ArrayList();
    this.xnp = new ArrayList();
    this.qDM = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.kyt = 10;
    this.xns = new LinkedList();
    this.xnt = false;
    this.xnu = new a.1(this);
    this.xnv = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(111388);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = paramAnonymousView.getTag(2131302847);
        if (!(localObject instanceof Integer))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111388);
          return;
        }
        int k = ((Integer)localObject).intValue();
        localObject = a.this.NK(k);
        if ((localObject == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject).xiW)))
        {
          Log.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
          a.this.ci(k);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111388);
          return;
        }
        Log.i("MicroMsg.AlbumAdapter", "click image path:" + ((GalleryItem.MediaItem)localObject).xiW);
        int j;
        if (a.b(a.this).contains(localObject))
        {
          a.b(a.this).indexOf(localObject);
          a.this.i((GalleryItem.MediaItem)localObject);
          i = 0;
          j = 1;
          if (i == 0)
          {
            if (a.h(a.this) != null) {
              a.h(a.this).ah(a.this.xnp.size(), k, j);
            }
            label247:
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
          }
        }
        else
        {
          long l1;
          if ((com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 3) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().amz(((GalleryItem.MediaItem)localObject).xiW)))
          {
            l1 = s.boW(((GalleryItem.MediaItem)localObject).xiW);
            com.tencent.mm.plugin.gallery.a.d.bw(13459, l1 + ",1,,0");
            com.tencent.mm.ui.base.h.cD(a.a(a.this), a.a(a.this).getString(2131761128));
            a.this.ci(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if ((a.c(a.this)) && (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 16) && ((a.d(a.this) == 2) || (a.d(a.this) == 3)) && (a.this.xnp.size() > 0) && (((GalleryItem.MediaItem)a.b(a.this).get(0)).getType() != ((GalleryItem.MediaItem)localObject).getType()))
          {
            com.tencent.mm.ui.base.h.cD(a.a(a.this), com.tencent.mm.cb.a.aI(a.a(a.this), 2131761101));
            a.this.ci(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if ((!Util.isNullOrNil(a.e(a.this))) && (a.e(a.this).equals("album_business_byp")) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().amA(((GalleryItem.MediaItem)localObject).xiW)))
          {
            com.tencent.mm.ui.base.h.cD(a.a(a.this), a.a(a.this).getString(2131761097));
            a.this.ci(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if (((a.d(a.this) == 2) || (a.d(a.this) == 3)) && ((localObject instanceof GalleryItem.VideoMediaItem)))
          {
            if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 25)
            {
              l1 = a.dRP();
              long l2 = a.dRQ();
              if (((GalleryItem.VideoMediaItem)localObject).jkS < com.tencent.mm.modelcontrol.e.baZ().bbf().minDuration * 1000)
              {
                com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getResources().getString(2131761151, new Object[] { Integer.valueOf(com.tencent.mm.modelcontrol.e.baZ().bbf().minDuration) }), "", false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(164790);
                    if ((paramAnonymousView instanceof MMNumberCheckbox)) {
                      ((MMNumberCheckbox)paramAnonymousView).setChecked(false);
                    }
                    AppMethodBeat.o(164790);
                  }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111388);
                return;
              }
              if (((GalleryItem.VideoMediaItem)localObject).jkS > l1 * 1000L)
              {
                com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getResources().getString(2131761152, new Object[] { Long.valueOf(l2) }), "", false, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(164791);
                    if ((paramAnonymousView instanceof MMNumberCheckbox)) {
                      ((MMNumberCheckbox)paramAnonymousView).setChecked(false);
                    }
                    AppMethodBeat.o(164791);
                  }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111388);
                return;
              }
            }
            if ((!Util.isNullOrNil(a.e(a.this))) && (a.e(a.this).equals("album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localObject).jkS >= a.f(a.this) * 1000 + 500))
            {
              com.tencent.mm.ui.base.h.cD(a.a(a.this), a.a(a.this).getResources().getString(2131761152, new Object[] { Integer.valueOf(a.f(a.this)) }));
              a.this.ci(k);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111388);
              return;
            }
          }
          if (a.b(a.this).size() >= a.g(a.this)) {
            break label1262;
          }
          a.b(a.this).add(localObject);
          a.b(a.this).size();
        }
        label1262:
        for (int i = 0;; i = 1)
        {
          j = 0;
          a.this.ci(k);
          break;
          if (a.d(a.this) == 1)
          {
            com.tencent.mm.ui.base.h.cD(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623950, a.g(a.this), new Object[] { Integer.valueOf(a.g(a.this)) }));
            break label247;
          }
          if (a.d(a.this) == 2)
          {
            com.tencent.mm.ui.base.h.cD(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623952, a.g(a.this), new Object[] { Integer.valueOf(a.g(a.this)) }));
            break label247;
          }
          com.tencent.mm.ui.base.h.cD(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623951, a.g(a.this), new Object[] { Integer.valueOf(a.g(a.this)) }));
          break label247;
        }
      }
    };
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111389);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = paramAnonymousView.getTag(2131302847);
        int i;
        if ((localObject instanceof Integer))
        {
          i = ((Integer)localObject).intValue();
          localObject = paramAnonymousView.getTag(2131302872);
          if (!(localObject instanceof Integer)) {
            break label145;
          }
        }
        label145:
        for (int j = ((Integer)localObject).intValue();; j = -1)
        {
          if ((i != -1) && (j != -1) && (a.i(a.this) != null)) {
            a.i(a.this).a(i, paramAnonymousView, j);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111389);
          return;
          i = -1;
          break;
        }
      }
    };
    this.mContext = paramContext;
    this.xnq = parame;
    while (i < 32)
    {
      paramContext = new GalleryItem.ImageMediaItem();
      this.xno.add(paramContext);
      i += 1;
    }
    this.atj.notifyChanged();
    AppMethodBeat.o(111407);
  }
  
  public final ArrayList<GalleryItem.MediaItem> NJ(int paramInt)
  {
    AppMethodBeat.i(111413);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.xno.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (localMediaItem.getType() == paramInt) {
        localArrayList.add(localMediaItem);
      }
    }
    AppMethodBeat.o(111413);
    return localArrayList;
  }
  
  public final GalleryItem.MediaItem NK(int paramInt)
  {
    AppMethodBeat.i(111418);
    if (paramInt < this.xns.size())
    {
      Log.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    paramInt -= this.xns.size();
    if (paramInt >= this.xno.size())
    {
      Log.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.xno.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.xno.get(paramInt);
    AppMethodBeat.o(111418);
    return localMediaItem;
  }
  
  final String NL(int paramInt)
  {
    AppMethodBeat.i(111419);
    int i = paramInt;
    if (paramInt < this.xns.size())
    {
      Log.d("MicroMsg.AlbumAdapter", "header, old pos[%d].", new Object[] { Integer.valueOf(paramInt) });
      i = this.xns.size();
    }
    Object localObject = NK(i);
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject).xjc))
      {
        localObject = ((GalleryItem.MediaItem)localObject).xjc;
        AppMethodBeat.o(111419);
        return localObject;
      }
      localObject = new Date(((GalleryItem.MediaItem)localObject).xja);
      localObject = com.tencent.mm.ui.gridviewheaders.a.gWr().a((Date)localObject, this.mContext);
      AppMethodBeat.o(111419);
      return localObject;
    }
    AppMethodBeat.o(111419);
    return "";
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111416);
    switch (paramInt)
    {
    default: 
      paramViewGroup = new a.a(LayoutInflater.from(this.mContext).inflate(2131496168, paramViewGroup, false));
      AppMethodBeat.o(111416);
      return paramViewGroup;
    }
    paramViewGroup = new a.c(LayoutInflater.from(this.mContext).inflate(2131493330, paramViewGroup, false));
    AppMethodBeat.o(111416);
    return paramViewGroup;
  }
  
  final void a(android.support.v4.e.b<Integer> paramb)
  {
    AppMethodBeat.i(111421);
    int i = 0;
    while (i < this.xnp.size())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.xnp.get(i);
      int j = this.xno.indexOf(localMediaItem);
      if (j != -1) {
        paramb.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramb = paramb.iterator();
    while (paramb.hasNext()) {
      ci(((Integer)paramb.next()).intValue() + this.xns.size());
    }
    AppMethodBeat.o(111421);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(111417);
    if ((paramv instanceof a.c))
    {
      paramv.aus.setTag(2131302847, Integer.valueOf(paramInt));
      paramv.aus.setTag(2131302872, Integer.valueOf(0));
      paramv.aus.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(111417);
      return;
    }
    GalleryItem.MediaItem localMediaItem;
    a.a locala;
    if ((paramv instanceof a.a))
    {
      paramv.aus.setTag(2131302847, Integer.valueOf(paramInt));
      paramv.aus.setTag(2131302872, Integer.valueOf(1));
      paramv.aus.setOnClickListener(this.mOnClickListener);
      localMediaItem = NK(paramInt);
      if (localMediaItem == null)
      {
        Log.e("MicroMsg.AlbumAdapter", "get item failed");
        AppMethodBeat.o(111417);
        return;
      }
      String str1 = localMediaItem.aQn();
      String str2 = localMediaItem.xiW;
      if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
      {
        Log.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111417);
        return;
      }
      locala = (a.a)paramv;
      locala.xnC.setTag(2131302847, Integer.valueOf(paramInt));
      locala.xnC.setOnClickListener(this.xnv);
      locala.xnA.setVisibility(0);
      locala.xnB.setVisibility(0);
      locala.xnD.setVisibility(0);
      if (2 != localMediaItem.getType()) {
        break label608;
      }
      locala.xnA.setImageResource(2131691695);
      a.g.a(locala.xnB, (GalleryItem.VideoMediaItem)localMediaItem);
      int i = this.xns.size();
      paramv = this.qDM.format(new Date(localMediaItem.xja));
      paramv = paramInt - i + 1 + ", " + paramv;
      if (2 != localMediaItem.getType()) {
        break label712;
      }
      paramv = "视频 ".concat(String.valueOf(paramv));
      label358:
      locala.xdY.setContentDescription(paramv);
      Log.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramv });
      h.a(locala.xdY, localMediaItem.getType(), str1, str2, localMediaItem.xiZ, localMediaItem.xja);
      locala.xnC.setVisibility(0);
      paramInt = com.tencent.mm.plugin.gallery.model.e.dQK().mcq;
      if ((paramInt != 0) && (5 != paramInt) && (10 != paramInt) && (11 != paramInt) && (24 != paramInt) && (paramInt != 27)) {
        break label726;
      }
      locala.xnC.setVisibility(4);
      label478:
      if (!this.xnt) {
        break label883;
      }
      if ((16 != paramInt) || ((localMediaItem.getType() != 2) && (localMediaItem.getType() != 3)) || (this.xnn <= 1)) {
        break label794;
      }
      locala.xnC.setVisibility(0);
      if (!this.xnp.contains(localMediaItem)) {
        break label771;
      }
      locala.xnC.setCheckedNumber(this.xnp.indexOf(localMediaItem) + 1);
      locala.xnz.setBackgroundResource(2131099835);
      label568:
      if (locala.xnC.getVisibility() != 0) {
        break label951;
      }
      a.a.a(locala, locala.xnC);
    }
    for (;;)
    {
      locala.aus.setOnLongClickListener(this.xnu);
      AppMethodBeat.o(111417);
      return;
      label608:
      if (localMediaItem.mMimeType.equalsIgnoreCase("edit"))
      {
        locala.xnA.setImageResource(2131691330);
        locala.xnB.setVisibility(4);
        break;
      }
      if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))
      {
        locala.xnA.setImageResource(2131232994);
        locala.xnB.setVisibility(4);
        break;
      }
      locala.xnA.setVisibility(4);
      locala.xnB.setVisibility(4);
      locala.xnD.setVisibility(4);
      break;
      label712:
      paramv = "图片".concat(String.valueOf(paramv));
      break label358;
      label726:
      if (15 == paramInt)
      {
        locala.xnC.setBackgroundResource(2131233190);
        break label478;
      }
      if (com.tencent.mm.plugin.gallery.model.e.dQK().mcq != 25) {
        break label478;
      }
      locala.xnC.setBackgroundResource(2131233189);
      break label478;
      label771:
      locala.xnC.setChecked(false);
      locala.xnz.setBackgroundResource(2131100641);
      break label568;
      label794:
      if (localMediaItem.getType() == 2)
      {
        locala.xnC.setVisibility(4);
        break label568;
      }
      if (this.xnp.contains(localMediaItem))
      {
        locala.xnC.setCheckedNumber(this.xnp.indexOf(localMediaItem) + 1);
        locala.xnz.setBackgroundResource(2131099835);
        break label568;
      }
      locala.xnC.setChecked(false);
      locala.xnz.setBackgroundResource(2131100641);
      break label568;
      label883:
      if (this.xnp.contains(localMediaItem))
      {
        locala.xnC.setCheckedNumber(this.xnp.indexOf(localMediaItem) + 1);
        locala.xnz.setBackgroundResource(2131099835);
        break label568;
      }
      locala.xnC.setChecked(false);
      locala.xnz.setBackgroundResource(2131100641);
      break label568;
      label951:
      a.a.el(locala.xnC);
    }
  }
  
  final void a(d paramd)
  {
    AppMethodBeat.i(111408);
    if (paramd == null)
    {
      Log.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
      AppMethodBeat.o(111408);
      return;
    }
    this.xns.remove(paramd);
    this.xns.add(paramd);
    AppMethodBeat.o(111408);
  }
  
  public final void aM(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(164792);
    this.xno.clear();
    this.xno.addAll(paramLinkedList);
    this.atj.notifyChanged();
    AppMethodBeat.o(164792);
  }
  
  public final void aN(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(111409);
    int i = getItemCount() - this.xns.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.xno.addAll(paramLinkedList.subList(i, j));
      as(i + this.xns.size(), getItemCount());
    }
    AppMethodBeat.o(111409);
  }
  
  public final void aq(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111412);
    Log.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", new Object[] { this.xnp });
    this.xnp.clear();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (String)paramArrayList.next();
        GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, (String)localObject, "", "");
        if (com.tencent.mm.plugin.gallery.model.e.dQM() != null)
        {
          int i = com.tencent.mm.plugin.gallery.model.e.dQM().indexOf(localMediaItem);
          if (i >= 0)
          {
            localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.dQM().get(i);
            this.xnp.add(localObject);
          }
          else
          {
            Log.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
            if (((String)localObject).toLowerCase().endsWith("mp4")) {
              this.xnp.add(GalleryItem.MediaItem.a(2, 0L, (String)localObject, "", ""));
            } else {
              this.xnp.add(GalleryItem.MediaItem.a(1, 0L, (String)localObject, "", ""));
            }
          }
        }
      }
    }
    Log.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", new Object[] { this.xnp });
    AppMethodBeat.o(111412);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(258739);
    this.xno.clear();
    AppMethodBeat.o(258739);
  }
  
  public final ArrayList<String> dRL()
  {
    AppMethodBeat.i(111410);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.xnp.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).xiW);
    }
    AppMethodBeat.o(111410);
    return localArrayList;
  }
  
  public final ArrayList<GalleryItem.MediaItem> dRM()
  {
    return this.xnp;
  }
  
  public final ArrayList<GalleryItem.MediaItem> dRN()
  {
    return this.xno;
  }
  
  public final int dRO()
  {
    AppMethodBeat.i(164794);
    int i = this.xnp.size();
    AppMethodBeat.o(164794);
    return i;
  }
  
  final void eX(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111411);
    this.xnp.clear();
    this.xnp.addAll(paramList);
    AppMethodBeat.o(111411);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111414);
    int i = this.xns.size();
    int j = this.xno.size();
    AppMethodBeat.o(111414);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(111415);
    if (paramInt < this.xns.size())
    {
      paramInt = ((d)this.xns.get(paramInt)).xnH;
      AppMethodBeat.o(111415);
      return paramInt;
    }
    AppMethodBeat.o(111415);
    return 1;
  }
  
  final void i(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111420);
    if (this.xnp.contains(paramMediaItem))
    {
      int i = this.xnp.indexOf(paramMediaItem);
      ArrayList localArrayList = new ArrayList();
      while (i < this.xnp.size())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.xnp.get(i);
        int j = this.xno.indexOf(localMediaItem);
        if (j != -1) {
          localArrayList.add(Integer.valueOf(j));
        }
        i += 1;
      }
      this.xnp.remove(paramMediaItem);
      paramMediaItem = localArrayList.iterator();
      while (paramMediaItem.hasNext()) {
        ci(((Integer)paramMediaItem.next()).intValue() + this.xns.size());
      }
    }
    AppMethodBeat.o(111420);
  }
  
  public final void setQueryType(int paramInt)
  {
    this.xjo = paramInt;
  }
  
  public final void setSelectLimitCount(int paramInt)
  {
    this.xnn = paramInt;
  }
  
  static final class b
    extends a.d
  {
    b()
    {
      this.xnH = 0;
    }
  }
  
  static abstract class d
  {
    int xnH;
  }
  
  public static abstract interface e
  {
    public abstract void ah(int paramInt1, int paramInt2, int paramInt3);
  }
  
  static abstract interface f
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a
 * JD-Core Version:    0.7.0.1
 */