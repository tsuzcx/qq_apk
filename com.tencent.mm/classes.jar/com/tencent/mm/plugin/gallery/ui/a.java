package com.tencent.mm.plugin.gallery.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends RecyclerView.a<RecyclerView.w>
{
  int jxK;
  private Context mContext;
  private View.OnClickListener mOnClickListener;
  private SimpleDateFormat pog;
  int tSb;
  int tWd;
  ArrayList<GalleryItem.MediaItem> tWe;
  ArrayList<GalleryItem.MediaItem> tWf;
  private e tWg;
  String tWh;
  LinkedList<d> tWi;
  boolean tWj;
  private View.OnLongClickListener tWk;
  private View.OnClickListener tWl;
  f tWm;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(111407);
    this.tWd = 9;
    this.tWe = new ArrayList();
    this.tWf = new ArrayList();
    this.pog = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.jxK = 10;
    this.tWi = new LinkedList();
    this.tWj = false;
    this.tWk = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111387);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        paramAnonymousView = paramAnonymousView.getTag(2131301175);
        if ((paramAnonymousView instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView).intValue();
          paramAnonymousView = a.this.HJ(i);
          if (paramAnonymousView != null) {
            ((ClipboardManager)a.a(a.this).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("media info", paramAnonymousView.toString()));
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(111387);
        return true;
      }
    };
    this.tWl = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(111388);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = paramAnonymousView.getTag(2131301175);
        if (!(localObject instanceof Integer))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111388);
          return;
        }
        int k = ((Integer)localObject).intValue();
        localObject = a.this.HJ(k);
        if ((localObject == null) || (bu.isNullOrNil(((GalleryItem.MediaItem)localObject).tRJ)))
        {
          ae.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
          a.this.cj(k);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111388);
          return;
        }
        ae.i("MicroMsg.AlbumAdapter", "click image path:" + ((GalleryItem.MediaItem)localObject).tRJ);
        int j;
        if (a.b(a.this).contains(localObject))
        {
          a.b(a.this).indexOf(localObject);
          a.this.h((GalleryItem.MediaItem)localObject);
          j = 1;
          i = 0;
          if (i == 0)
          {
            if (a.g(a.this) != null) {
              a.g(a.this).ac(a.this.tWf.size(), k, j);
            }
            label247:
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
          }
        }
        else
        {
          long l;
          if ((com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 3) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().acv(((GalleryItem.MediaItem)localObject).tRJ)))
          {
            l = com.tencent.mm.vfs.o.aZR(((GalleryItem.MediaItem)localObject).tRJ);
            com.tencent.mm.plugin.gallery.a.d.bk(13459, l + ",1,,0");
            com.tencent.mm.ui.base.h.cm(a.a(a.this), a.a(a.this).getString(2131759800));
            a.this.cj(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if ((!bu.isNullOrNil(a.c(a.this))) && (a.c(a.this).equals("album_business_byp")) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")))
          {
            com.tencent.mm.ui.base.h.cm(a.a(a.this), a.a(a.this).getString(2131767086));
            a.this.cj(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if (((a.d(a.this) == 2) || (a.d(a.this) == 3)) && ((localObject instanceof GalleryItem.VideoMediaItem)))
          {
            if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 25)
            {
              l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGX, 300);
              if (((GalleryItem.VideoMediaItem)localObject).ipL < com.tencent.mm.modelcontrol.d.aHh().aHn().minDuration * 1000)
              {
                com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getResources().getString(2131759821, new Object[] { Integer.valueOf(com.tencent.mm.modelcontrol.d.aHh().aHn().minDuration) }), "", false, new DialogInterface.OnClickListener()
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
              if (((GalleryItem.VideoMediaItem)localObject).ipL > 1000L * l)
              {
                com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getResources().getString(2131759822, new Object[] { Long.valueOf(l) }), "", false, new DialogInterface.OnClickListener()
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
            if ((!bu.isNullOrNil(a.c(a.this))) && (a.c(a.this).equals("album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localObject).ipL >= a.e(a.this) * 1000 + 500))
            {
              com.tencent.mm.ui.base.h.cm(a.a(a.this), a.a(a.this).getResources().getString(2131759822, new Object[] { Integer.valueOf(a.e(a.this)) }));
              a.this.cj(k);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111388);
              return;
            }
          }
          if (a.b(a.this).size() >= a.f(a.this)) {
            break label1114;
          }
          a.b(a.this).add(localObject);
          a.b(a.this).size();
        }
        label1114:
        for (int i = 0;; i = 1)
        {
          a.this.cj(k);
          j = 0;
          break;
          if (a.d(a.this) == 1)
          {
            com.tencent.mm.ui.base.h.cm(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623950, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
            break label247;
          }
          if (a.d(a.this) == 2)
          {
            com.tencent.mm.ui.base.h.cm(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623952, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
            break label247;
          }
          com.tencent.mm.ui.base.h.cm(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623951, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = paramAnonymousView.getTag(2131301175);
        int i;
        if ((localObject instanceof Integer))
        {
          i = ((Integer)localObject).intValue();
          localObject = paramAnonymousView.getTag(2131301200);
          if (!(localObject instanceof Integer)) {
            break label145;
          }
        }
        label145:
        for (int j = ((Integer)localObject).intValue();; j = -1)
        {
          if ((i != -1) && (j != -1) && (a.h(a.this) != null)) {
            a.h(a.this).a(i, paramAnonymousView, j);
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
    this.tWg = parame;
    while (i < 32)
    {
      paramContext = new GalleryItem.ImageMediaItem();
      this.tWe.add(paramContext);
      i += 1;
    }
    this.asY.notifyChanged();
    AppMethodBeat.o(111407);
  }
  
  public final ArrayList<GalleryItem.MediaItem> HI(int paramInt)
  {
    AppMethodBeat.i(111413);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tWe.iterator();
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
  
  public final GalleryItem.MediaItem HJ(int paramInt)
  {
    AppMethodBeat.i(111418);
    if (paramInt < this.tWi.size())
    {
      ae.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    paramInt -= this.tWi.size();
    if (paramInt >= this.tWe.size())
    {
      ae.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.tWe.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.tWe.get(paramInt);
    AppMethodBeat.o(111418);
    return localMediaItem;
  }
  
  final String HK(int paramInt)
  {
    AppMethodBeat.i(111419);
    int i = paramInt;
    if (paramInt < this.tWi.size())
    {
      ae.d("MicroMsg.AlbumAdapter", "header, old pos[%d].", new Object[] { Integer.valueOf(paramInt) });
      i = this.tWi.size();
    }
    Object localObject = HJ(i);
    if (localObject != null)
    {
      if (!bu.isNullOrNil(((GalleryItem.MediaItem)localObject).tRP))
      {
        localObject = ((GalleryItem.MediaItem)localObject).tRP;
        AppMethodBeat.o(111419);
        return localObject;
      }
      localObject = new Date(((GalleryItem.MediaItem)localObject).tRN);
      localObject = com.tencent.mm.ui.gridviewheaders.a.fNX().a((Date)localObject, this.mContext);
      AppMethodBeat.o(111419);
      return localObject;
    }
    AppMethodBeat.o(111419);
    return "";
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111416);
    switch (paramInt)
    {
    default: 
      paramViewGroup = new a(LayoutInflater.from(this.mContext).inflate(2131495310, paramViewGroup, false));
      AppMethodBeat.o(111416);
      return paramViewGroup;
    }
    paramViewGroup = new c(LayoutInflater.from(this.mContext).inflate(2131493244, paramViewGroup, false));
    AppMethodBeat.o(111416);
    return paramViewGroup;
  }
  
  final void a(android.support.v4.e.b<Integer> paramb)
  {
    AppMethodBeat.i(111421);
    int i = 0;
    while (i < this.tWf.size())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.tWf.get(i);
      int j = this.tWe.indexOf(localMediaItem);
      if (j != -1) {
        paramb.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramb = paramb.iterator();
    while (paramb.hasNext()) {
      cj(((Integer)paramb.next()).intValue() + this.tWi.size());
    }
    AppMethodBeat.o(111421);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(111417);
    if ((paramw instanceof c))
    {
      paramw.auu.setTag(2131301175, Integer.valueOf(paramInt));
      paramw.auu.setTag(2131301200, Integer.valueOf(0));
      paramw.auu.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(111417);
      return;
    }
    GalleryItem.MediaItem localMediaItem;
    a locala;
    if ((paramw instanceof a))
    {
      paramw.auu.setTag(2131301175, Integer.valueOf(paramInt));
      paramw.auu.setTag(2131301200, Integer.valueOf(1));
      paramw.auu.setOnClickListener(this.mOnClickListener);
      localMediaItem = HJ(paramInt);
      if (localMediaItem == null)
      {
        ae.e("MicroMsg.AlbumAdapter", "get item failed");
        AppMethodBeat.o(111417);
        return;
      }
      String str1 = localMediaItem.axP();
      String str2 = localMediaItem.tRJ;
      if ((bu.isNullOrNil(str1)) && (bu.isNullOrNil(str2)))
      {
        ae.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111417);
        return;
      }
      locala = (a)paramw;
      locala.tWs.setTag(2131301175, Integer.valueOf(paramInt));
      locala.tWs.setOnClickListener(this.tWl);
      locala.tWq.setVisibility(0);
      locala.tWr.setVisibility(0);
      locala.tWt.setVisibility(0);
      if (2 != localMediaItem.getType()) {
        break label537;
      }
      locala.tWq.setImageResource(2131691361);
      g.a(locala.tWr, (GalleryItem.VideoMediaItem)localMediaItem);
      int i = this.tWi.size();
      paramw = this.pog.format(new Date(localMediaItem.tRN));
      paramw = paramInt - i + 1 + ", " + paramw;
      if (2 != localMediaItem.getType()) {
        break label641;
      }
      paramw = "视频 ".concat(String.valueOf(paramw));
      label358:
      locala.tMY.setContentDescription(paramw);
      ae.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramw });
      h.a(locala.tMY, localMediaItem.getType(), str1, str2, localMediaItem.tRM, localMediaItem.tRN);
      locala.tWs.setVisibility(0);
      paramInt = com.tencent.mm.plugin.gallery.model.e.cXr().kXg;
      if ((paramInt != 0) && (5 != paramInt) && (10 != paramInt) && (11 != paramInt) && (24 != paramInt)) {
        break label655;
      }
      locala.tWs.setVisibility(4);
      label472:
      if (!this.tWj) {
        break label768;
      }
      if (localMediaItem.getType() != 2) {
        break label700;
      }
      locala.tWs.setVisibility(4);
      label497:
      if (locala.tWs.getVisibility() != 0) {
        break label836;
      }
      a.a(locala, locala.tWs);
    }
    for (;;)
    {
      locala.auu.setOnLongClickListener(this.tWk);
      AppMethodBeat.o(111417);
      return;
      label537:
      if (localMediaItem.mMimeType.equalsIgnoreCase("edit"))
      {
        locala.tWq.setImageResource(2131691030);
        locala.tWr.setVisibility(4);
        break;
      }
      if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))
      {
        locala.tWq.setImageResource(2131232599);
        locala.tWr.setVisibility(4);
        break;
      }
      locala.tWq.setVisibility(4);
      locala.tWr.setVisibility(4);
      locala.tWt.setVisibility(4);
      break;
      label641:
      paramw = "图片".concat(String.valueOf(paramw));
      break label358;
      label655:
      if (15 == paramInt)
      {
        locala.tWs.setBackgroundResource(2131232750);
        break label472;
      }
      if (com.tencent.mm.plugin.gallery.model.e.cXr().kXg != 25) {
        break label472;
      }
      locala.tWs.setBackgroundResource(2131232749);
      break label472;
      label700:
      if (this.tWf.contains(localMediaItem))
      {
        locala.tWs.setCheckedNumber(this.tWf.indexOf(localMediaItem) + 1);
        locala.tWp.setBackgroundResource(2131099819);
        break label497;
      }
      locala.tWs.setChecked(false);
      locala.tWp.setBackgroundResource(2131100506);
      break label497;
      label768:
      if (this.tWf.contains(localMediaItem))
      {
        locala.tWs.setCheckedNumber(this.tWf.indexOf(localMediaItem) + 1);
        locala.tWp.setBackgroundResource(2131099819);
        break label497;
      }
      locala.tWs.setChecked(false);
      locala.tWp.setBackgroundResource(2131100506);
      break label497;
      label836:
      a.en(locala.tWs);
    }
  }
  
  final void a(d paramd)
  {
    AppMethodBeat.i(111408);
    if (paramd == null)
    {
      ae.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
      AppMethodBeat.o(111408);
      return;
    }
    this.tWi.remove(paramd);
    this.tWi.add(paramd);
    AppMethodBeat.o(111408);
  }
  
  public final void ac(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111412);
    ae.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", new Object[] { this.tWf });
    this.tWf.clear();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (String)paramArrayList.next();
        GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, (String)localObject, "", "");
        if (com.tencent.mm.plugin.gallery.model.e.cXt() != null)
        {
          int i = com.tencent.mm.plugin.gallery.model.e.cXt().indexOf(localMediaItem);
          if (i >= 0)
          {
            localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.cXt().get(i);
            this.tWf.add(localObject);
          }
          else
          {
            ae.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
            if (((String)localObject).toLowerCase().endsWith("mp4")) {
              this.tWf.add(GalleryItem.MediaItem.a(2, 0L, (String)localObject, "", ""));
            } else {
              this.tWf.add(GalleryItem.MediaItem.a(1, 0L, (String)localObject, "", ""));
            }
          }
        }
      }
    }
    ae.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", new Object[] { this.tWf });
    AppMethodBeat.o(111412);
  }
  
  public final void ar(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(164792);
    this.tWe.clear();
    this.tWe.addAll(paramLinkedList);
    this.asY.notifyChanged();
    AppMethodBeat.o(164792);
  }
  
  public final void as(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(111409);
    int i = getItemCount() - this.tWi.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.tWe.addAll(paramLinkedList.subList(i, j));
      ar(i + this.tWi.size(), getItemCount());
    }
    AppMethodBeat.o(111409);
  }
  
  public final ArrayList<String> cYs()
  {
    AppMethodBeat.i(111410);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tWf.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).tRJ);
    }
    AppMethodBeat.o(111410);
    return localArrayList;
  }
  
  public final ArrayList<GalleryItem.MediaItem> cYt()
  {
    return this.tWf;
  }
  
  public final ArrayList<GalleryItem.MediaItem> cYu()
  {
    return this.tWe;
  }
  
  public final int cYv()
  {
    AppMethodBeat.i(164794);
    int i = this.tWf.size();
    AppMethodBeat.o(164794);
    return i;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(224176);
    this.tWe.clear();
    AppMethodBeat.o(224176);
  }
  
  final void ee(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111411);
    this.tWf.clear();
    this.tWf.addAll(paramList);
    AppMethodBeat.o(111411);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111414);
    int i = this.tWi.size();
    int j = this.tWe.size();
    AppMethodBeat.o(111414);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(111415);
    if (paramInt < this.tWi.size())
    {
      paramInt = ((d)this.tWi.get(paramInt)).tWx;
      AppMethodBeat.o(111415);
      return paramInt;
    }
    AppMethodBeat.o(111415);
    return 1;
  }
  
  final void h(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111420);
    if (this.tWf.contains(paramMediaItem))
    {
      int i = this.tWf.indexOf(paramMediaItem);
      ArrayList localArrayList = new ArrayList();
      while (i < this.tWf.size())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.tWf.get(i);
        int j = this.tWe.indexOf(localMediaItem);
        if (j != -1) {
          localArrayList.add(Integer.valueOf(j));
        }
        i += 1;
      }
      this.tWf.remove(paramMediaItem);
      paramMediaItem = localArrayList.iterator();
      while (paramMediaItem.hasNext()) {
        cj(((Integer)paramMediaItem.next()).intValue() + this.tWi.size());
      }
    }
    AppMethodBeat.o(111420);
  }
  
  public final void setQueryType(int paramInt)
  {
    this.tSb = paramInt;
  }
  
  public final void setSelectLimitCount(int paramInt)
  {
    this.tWd = paramInt;
  }
  
  static final class a
    extends RecyclerView.w
  {
    ImageView tMY;
    ImageView tWp;
    ImageView tWq;
    TextView tWr;
    MMNumberCheckbox tWs;
    View tWt;
    
    a(View paramView)
    {
      super();
      AppMethodBeat.i(111391);
      this.tMY = ((ImageView)paramView.findViewById(2131302221));
      this.tWp = ((ImageView)paramView.findViewById(2131302212));
      this.tWq = ((ImageView)paramView.findViewById(2131306177));
      this.tWr = ((TextView)paramView.findViewById(2131306178));
      this.tWs = ((MMNumberCheckbox)paramView.findViewById(2131302204));
      this.tWt = paramView.findViewById(2131306176);
      AppMethodBeat.o(111391);
    }
  }
  
  static final class b
    extends a.d
  {
    b()
    {
      this.tWx = 0;
    }
  }
  
  static final class c
    extends RecyclerView.w
  {
    private TextView tWw;
    
    c(View paramView)
    {
      super();
      AppMethodBeat.i(111394);
      this.tWw = ((TextView)paramView.findViewById(2131302221));
      if ((com.tencent.mm.plugin.gallery.model.e.cXr().tSb == 2) || (com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 13))
      {
        this.tWw.setText(2131759820);
        AppMethodBeat.o(111394);
        return;
      }
      if (com.tencent.mm.plugin.gallery.model.e.cXr().tSb == 1) {
        this.tWw.setText(2131759819);
      }
      AppMethodBeat.o(111394);
    }
  }
  
  static abstract class d
  {
    int tWx;
  }
  
  public static abstract interface e
  {
    public abstract void ac(int paramInt1, int paramInt2, int paramInt3);
  }
  
  static abstract interface f
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
  }
  
  public static final class g
    implements Runnable
  {
    private static HashMap<TextView, g> tWA;
    private boolean hmD;
    private WeakReference<TextView> rso;
    private GalleryItem.VideoMediaItem tWy;
    private a tWz;
    
    static
    {
      AppMethodBeat.i(111406);
      tWA = new HashMap();
      AppMethodBeat.o(111406);
    }
    
    private g(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, a parama)
    {
      AppMethodBeat.i(111397);
      this.rso = new WeakReference(paramTextView);
      this.tWy = paramVideoMediaItem;
      this.tWz = parama;
      AppMethodBeat.o(111397);
    }
    
    public static void a(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem)
    {
      AppMethodBeat.i(111399);
      if ((paramTextView == null) || (paramVideoMediaItem == null))
      {
        ae.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
        AppMethodBeat.o(111399);
        return;
      }
      if (tWA.containsKey(paramTextView))
      {
        localObject = (g)tWA.get(paramTextView);
        if (localObject != null)
        {
          if (((g)localObject).tWy.equals(paramVideoMediaItem))
          {
            AppMethodBeat.o(111399);
            return;
          }
          if (paramTextView.equals(((g)localObject).rso.get()))
          {
            ((g)localObject).rso = new WeakReference(null);
            ((g)localObject).hmD = true;
          }
        }
      }
      if (paramVideoMediaItem.ipL >= 0)
      {
        ae.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.ipL), paramVideoMediaItem });
        j(paramTextView, paramVideoMediaItem.ipL);
        tWA.remove(paramTextView);
        AppMethodBeat.o(111399);
        return;
      }
      paramTextView.setText("");
      paramVideoMediaItem = new g(paramTextView, paramVideoMediaItem, new a()
      {
        public final void a(a.g paramAnonymousg, int paramAnonymousInt)
        {
          AppMethodBeat.i(111396);
          if ((paramAnonymousg == null) || (a.g.c(paramAnonymousg) == null))
          {
            AppMethodBeat.o(111396);
            return;
          }
          paramAnonymousg = (TextView)a.g.c(paramAnonymousg).get();
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(111396);
            return;
          }
          a.g.k(paramAnonymousg, paramAnonymousInt);
          a.g.cYy().remove(paramAnonymousg);
          AppMethodBeat.o(111396);
        }
      });
      Object localObject = com.tencent.mm.plugin.gallery.model.e.cXs().cXJ();
      if (localObject != null) {
        ((aq)localObject).post(paramVideoMediaItem);
      }
      for (;;)
      {
        tWA.put(paramTextView, paramVideoMediaItem);
        AppMethodBeat.o(111399);
        return;
        ae.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
      }
    }
    
    private static boolean alT(String paramString)
    {
      AppMethodBeat.i(173745);
      Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNU, "");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(173745);
        return false;
      }
      ae.i("MicroMsg.AlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
      ae.i("MicroMsg.AlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject2 = ((JSONObject)localObject1).optString("devices");
        int j = ((JSONObject)localObject1).optInt("maxsize");
        localObject1 = new JSONArray((String)localObject2);
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if ((Build.MANUFACTURER.equalsIgnoreCase(((JSONObject)localObject2).optString("brand"))) && (Build.MODEL.equalsIgnoreCase(((JSONObject)localObject2).optString("model"))))
          {
            long l = com.tencent.mm.vfs.o.aZR(paramString);
            if ((j != 0) && (l > j * 1024 * 1024))
            {
              ae.i("MicroMsg.AlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
              AppMethodBeat.o(173745);
              return false;
            }
            int k = ((JSONObject)localObject2).optInt("androidVersion");
            if (-1 == k)
            {
              ae.i("MicroMsg.AlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(173745);
              return true;
            }
            if (Build.VERSION.SDK_INT == k)
            {
              ae.i("MicroMsg.AlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(173745);
              return true;
            }
          }
          i += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        ae.printErrStackTrace("MicroMsg.AlbumAdapter", paramString, "parse json error", new Object[0]);
        AppMethodBeat.o(173745);
      }
    }
    
    public static void cYw()
    {
      AppMethodBeat.i(111398);
      tWA.clear();
      AppMethodBeat.o(111398);
    }
    
    private void cYx()
    {
      AppMethodBeat.i(173746);
      if (this.tWy == null)
      {
        AppMethodBeat.o(173746);
        return;
      }
      long l = bu.HQ();
      try
      {
        String str = this.tWy.axP();
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        ae.d("MicroMsg.AlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
        localObject = new JSONObject((String)localObject);
        this.tWy.ipL = ((JSONObject)localObject).getInt("videoDuration");
        this.tWy.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
        this.tWy.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
        this.tWy.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
        this.tWy.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
        this.tWy.hoy = SightVideoJNI.getMp4RotateVFS(str);
        this.tWy.videoIFrameInterval = 0;
        this.tWy.ipJ = com.tencent.mm.plugin.gallery.a.b.amd(((JSONObject)localObject).getString("videoType"));
        this.tWy.ipK = com.tencent.mm.plugin.gallery.a.b.amd(((JSONObject)localObject).getString("audioType"));
        ae.d("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.tWy });
        ae.i("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
        AppMethodBeat.o(173746);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AlbumAdapter", localException, "loadItemFromSimpleMP4Info fail", new Object[0]);
        }
      }
    }
    
    private static void j(TextView paramTextView, int paramInt)
    {
      AppMethodBeat.i(111400);
      if (paramTextView == null)
      {
        AppMethodBeat.o(111400);
        return;
      }
      if (paramInt < 0)
      {
        paramTextView.setText("--:--");
        AppMethodBeat.o(111400);
        return;
      }
      paramInt = Math.round(paramInt / 1000.0F);
      String str2 = String.valueOf(paramInt % 60);
      String str1 = str2;
      if (str2.length() < 2) {
        str1 = "0".concat(String.valueOf(str2));
      }
      paramTextView.setText(paramInt / 60 + ":" + str1);
      AppMethodBeat.o(111400);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111401);
      if (!(paramObject instanceof g))
      {
        AppMethodBeat.o(111401);
        return false;
      }
      boolean bool = this.tWy.equals(((g)paramObject).tWy);
      AppMethodBeat.o(111401);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111402);
      int i = this.tWy.hashCode();
      AppMethodBeat.o(111402);
      return i;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111404);
      if (this.hmD)
      {
        AppMethodBeat.o(111404);
        return;
      }
      int i;
      label123:
      long l;
      c localc;
      String str1;
      if (alT(this.tWy.axP()))
      {
        cYx();
        if (this.hmD) {
          break label818;
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          if (this.tWz != null) {
            this.tWz.a(this, this.tWy.ipL);
          }
          AppMethodBeat.o(111404);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNx, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label123;
          }
          cYx();
          break;
        }
        l = bu.HQ();
        localc = new c();
        str1 = this.tWy.axP();
      }
      for (;;)
      {
        Object localObject4;
        Object localObject7;
        Object localObject8;
        try
        {
          localc.vT(str1);
          int j = localc.gga.getTrackCount();
          localObject1 = null;
          localObject4 = null;
          i = 0;
          localObject5 = localObject4;
          localObject6 = localObject1;
          if (i < j)
          {
            localMediaFormat = localc.getTrackFormat(i);
            if (!localMediaFormat.containsKey("mime"))
            {
              ae.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
              localObject7 = localObject4;
              localObject8 = localObject1;
              break label825;
            }
            str2 = localMediaFormat.getString("mime");
            ae.d("MicroMsg.AlbumAdapter", "find video mime : %s", new Object[] { str2 });
            localObject7 = localObject4;
            localObject8 = localObject1;
            if (str2 == null) {
              break label825;
            }
            if (!str2.startsWith("video/")) {
              continue;
            }
            localObject5 = localObject4;
            localObject6 = localObject1;
            if (localObject1 != null) {
              break label840;
            }
            localObject6 = localMediaFormat;
            localObject5 = localObject4;
            break label840;
          }
          if (this.tWy != null)
          {
            if (localObject6 != null)
            {
              localObject1 = this.tWy;
              if (localObject6.containsKey("durationUs")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).ipL = i;
              localObject1 = this.tWy;
              if (localObject6.containsKey("height")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
              localObject1 = this.tWy;
              if (localObject6.containsKey("width")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
              localObject4 = this.tWy;
              if (localObject6.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).ipJ = ((String)localObject1);
              localObject1 = this.tWy;
              if (localObject6.containsKey("bitrate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
              localObject1 = this.tWy;
              if (localObject6.containsKey("i-frame-interval")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoIFrameInterval = i;
              localObject1 = this.tWy;
              if (localObject6.containsKey("frame-rate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
              this.tWy.hoy = SightVideoJNI.getMp4RotateVFS(str1);
            }
            if (localObject5 != null)
            {
              localObject4 = this.tWy;
              if (localObject5.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).ipK = ((String)localObject1);
            }
          }
          ae.d("MicroMsg.AlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.tWy });
          ae.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
          localc.gga.release();
        }
        catch (Exception localException)
        {
          Object localObject1;
          MediaFormat localMediaFormat;
          String str2;
          ae.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
          localc.gga.release();
          continue;
        }
        finally
        {
          localc.gga.release();
          AppMethodBeat.o(111404);
        }
        ae.i("MicroMsg.AlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
        break;
        Object localObject5 = localObject4;
        Object localObject6 = localObject1;
        if (str2.startsWith("audio/"))
        {
          localObject5 = localObject4;
          localObject6 = localObject1;
          if (localObject4 == null)
          {
            localObject5 = localMediaFormat;
            localObject6 = localObject1;
            break label840;
            i = (int)(localObject6.getLong("durationUs") / 1000L);
            continue;
            i = localObject6.getInteger("height");
            continue;
            i = localObject6.getInteger("width");
            continue;
            localObject1 = localObject6.getString("mime");
            continue;
            i = localObject6.getInteger("bitrate");
            continue;
            i = localObject6.getInteger("i-frame-interval");
            continue;
            i = localObject6.getInteger("frame-rate");
            continue;
            localObject1 = localObject5.getString("mime");
            continue;
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111395);
                if (a.g.a(a.g.this) != null) {
                  a.g.a(a.g.this).a(a.g.this, a.g.b(a.g.this).ipL);
                }
                AppMethodBeat.o(111395);
              }
            });
            label818:
            AppMethodBeat.o(111404);
            return;
          }
        }
        label825:
        label840:
        do
        {
          do
          {
            i += 1;
            localObject4 = localObject7;
            Object localObject3 = localObject8;
            break;
            localObject7 = localObject5;
            localObject8 = localObject6;
          } while (localObject5 == null);
          localObject7 = localObject5;
          localObject8 = localObject6;
        } while (localObject6 == null);
      }
    }
    
    static abstract interface a
    {
      public abstract void a(a.g paramg, int paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a
 * JD-Core Version:    0.7.0.1
 */