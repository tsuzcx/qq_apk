package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import com.tencent.mm.vfs.u;
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
  int BVD;
  int BZF;
  ArrayList<GalleryItem.MediaItem> BZG;
  ArrayList<GalleryItem.MediaItem> BZH;
  private e BZI;
  String BZJ;
  LinkedList<d> BZK;
  boolean BZL;
  private View.OnLongClickListener BZM;
  private View.OnClickListener BZN;
  f BZO;
  private Context mContext;
  private View.OnClickListener mOnClickListener;
  int nrt;
  private SimpleDateFormat ucN;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(111407);
    this.BZF = 9;
    this.BZG = new ArrayList();
    this.BZH = new ArrayList();
    this.ucN = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.nrt = 10;
    this.BZK = new LinkedList();
    this.BZL = false;
    this.BZM = new a.1(this);
    this.BZN = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(111388);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = paramAnonymousView.getTag(b.e.item_position);
        if (!(localObject instanceof Integer))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111388);
          return;
        }
        int k = ((Integer)localObject).intValue();
        localObject = a.this.SY(k);
        if ((localObject == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject).AAz)))
        {
          Log.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
          a.this.cL(k);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111388);
          return;
        }
        Log.i("MicroMsg.AlbumAdapter", "click image path:" + ((GalleryItem.MediaItem)localObject).AAz);
        int j;
        if (a.b(a.this).contains(localObject))
        {
          a.b(a.this).indexOf(localObject);
          a.this.j((GalleryItem.MediaItem)localObject);
          i = 0;
          j = 1;
          if (i == 0)
          {
            if (a.h(a.this) != null) {
              a.h(a.this).ak(a.this.BZH.size(), k, j);
            }
            label248:
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
          }
        }
        else
        {
          long l1;
          if ((com.tencent.mm.plugin.gallery.model.e.etl().pag == 3) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((d)com.tencent.mm.kernel.h.ag(d.class)).getProvider().aus(((GalleryItem.MediaItem)localObject).AAz)))
          {
            l1 = u.bBQ(((GalleryItem.MediaItem)localObject).AAz);
            com.tencent.mm.plugin.gallery.a.e.bt(13459, l1 + ",1,,0");
            com.tencent.mm.ui.base.h.cO(a.a(a.this), a.a(a.this).getString(b.i.gallery_select_gif_to_big));
            a.this.cL(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if ((a.c(a.this)) && (com.tencent.mm.plugin.gallery.model.e.etl().pag == 16) && ((a.d(a.this) == 2) || (a.d(a.this) == 3)) && (a.this.BZH.size() > 0) && (((GalleryItem.MediaItem)a.b(a.this).get(0)).getType() != ((GalleryItem.MediaItem)localObject).getType()))
          {
            com.tencent.mm.ui.base.h.cO(a.a(a.this), com.tencent.mm.ci.a.ba(a.a(a.this), b.i.gallery_pic_can_not_choose_video));
            a.this.cL(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if ((!Util.isNullOrNil(a.e(a.this))) && (a.e(a.this).equals("album_business_byp")) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((d)com.tencent.mm.kernel.h.ag(d.class)).getProvider().aut(((GalleryItem.MediaItem)localObject).AAz)))
          {
            com.tencent.mm.ui.base.h.cO(a.a(a.this), a.a(a.this).getString(b.i.gallery_no_support_giant_gif_gamelife));
            a.this.cL(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if (((a.d(a.this) == 2) || (a.d(a.this) == 3)) && ((localObject instanceof GalleryItem.VideoMediaItem)))
          {
            if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25)
            {
              l1 = a.eur();
              long l2 = a.eus();
              if (((GalleryItem.VideoMediaItem)localObject).maT < com.tencent.mm.modelcontrol.e.bkp().bkv().minDuration * 1000)
              {
                com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getResources().getString(b.i.gallery_video_duration_below, new Object[] { Integer.valueOf(com.tencent.mm.modelcontrol.e.bkp().bkv().minDuration) }), "", false, new DialogInterface.OnClickListener()
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
              if (((GalleryItem.VideoMediaItem)localObject).maT > l1 * 1000L)
              {
                com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getResources().getString(b.i.gallery_video_duration_limit, new Object[] { Long.valueOf(l2) }), "", false, new DialogInterface.OnClickListener()
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
            if ((!Util.isNullOrNil(a.e(a.this))) && (a.e(a.this).equals("album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localObject).maT >= a.f(a.this) * 1000 + 500))
            {
              com.tencent.mm.ui.base.h.cO(a.a(a.this), a.a(a.this).getResources().getString(b.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(a.f(a.this)) }));
              a.this.cL(k);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111388);
              return;
            }
          }
          if (a.b(a.this).size() >= a.g(a.this)) {
            break label1266;
          }
          a.b(a.this).add(localObject);
          a.b(a.this).size();
        }
        label1266:
        for (int i = 0;; i = 1)
        {
          j = 0;
          a.this.cL(k);
          break;
          if (a.d(a.this) == 1)
          {
            com.tencent.mm.ui.base.h.cO(a.a(a.this), a.a(a.this).getResources().getQuantityString(b.g.gallery_pic_limit, a.g(a.this), new Object[] { Integer.valueOf(a.g(a.this)) }));
            break label248;
          }
          if (a.d(a.this) == 2)
          {
            com.tencent.mm.ui.base.h.cO(a.a(a.this), a.a(a.this).getResources().getQuantityString(b.g.gallery_video_limit, a.g(a.this), new Object[] { Integer.valueOf(a.g(a.this)) }));
            break label248;
          }
          com.tencent.mm.ui.base.h.cO(a.a(a.this), a.a(a.this).getResources().getQuantityString(b.g.gallery_pic_or_video_limit, a.g(a.this), new Object[] { Integer.valueOf(a.g(a.this)) }));
          break label248;
        }
      }
    };
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111389);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = paramAnonymousView.getTag(b.e.item_position);
        int i;
        if ((localObject instanceof Integer))
        {
          i = ((Integer)localObject).intValue();
          localObject = paramAnonymousView.getTag(b.e.item_type);
          if (!(localObject instanceof Integer)) {
            break label147;
          }
        }
        label147:
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
    this.BZI = parame;
    while (i < 32)
    {
      paramContext = new GalleryItem.ImageMediaItem();
      this.BZG.add(paramContext);
      i += 1;
    }
    this.alc.notifyChanged();
    AppMethodBeat.o(111407);
  }
  
  public final ArrayList<GalleryItem.MediaItem> SX(int paramInt)
  {
    AppMethodBeat.i(111413);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.BZG.iterator();
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
  
  public final GalleryItem.MediaItem SY(int paramInt)
  {
    AppMethodBeat.i(111418);
    if (paramInt < this.BZK.size())
    {
      Log.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    paramInt -= this.BZK.size();
    if (paramInt >= this.BZG.size())
    {
      Log.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.BZG.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.BZG.get(paramInt);
    AppMethodBeat.o(111418);
    return localMediaItem;
  }
  
  final String SZ(int paramInt)
  {
    AppMethodBeat.i(111419);
    int i = paramInt;
    if (paramInt < this.BZK.size())
    {
      Log.d("MicroMsg.AlbumAdapter", "header, old pos[%d].", new Object[] { Integer.valueOf(paramInt) });
      i = this.BZK.size();
    }
    Object localObject = SY(i);
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject).BVr))
      {
        localObject = ((GalleryItem.MediaItem)localObject).BVr;
        AppMethodBeat.o(111419);
        return localObject;
      }
      localObject = new Date(((GalleryItem.MediaItem)localObject).BVm);
      localObject = com.tencent.mm.ui.gridviewheaders.a.hWZ().a((Date)localObject, this.mContext);
      AppMethodBeat.o(111419);
      return localObject;
    }
    AppMethodBeat.o(111419);
    return "";
  }
  
  final void a(androidx.b.b<Integer> paramb)
  {
    AppMethodBeat.i(242859);
    int i = 0;
    while (i < this.BZH.size())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.BZH.get(i);
      int j = this.BZG.indexOf(localMediaItem);
      if (j != -1) {
        paramb.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramb = paramb.iterator();
    while (paramb.hasNext()) {
      cL(((Integer)paramb.next()).intValue() + this.BZK.size());
    }
    AppMethodBeat.o(242859);
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
    this.BZK.remove(paramd);
    this.BZK.add(paramd);
    AppMethodBeat.o(111408);
  }
  
  public final void aw(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111412);
    Log.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", new Object[] { this.BZH });
    this.BZH.clear();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (String)paramArrayList.next();
        GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, (String)localObject, "", "");
        if (com.tencent.mm.plugin.gallery.model.e.etn() != null)
        {
          int i = com.tencent.mm.plugin.gallery.model.e.etn().indexOf(localMediaItem);
          if (i >= 0)
          {
            localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.etn().get(i);
            this.BZH.add(localObject);
          }
          else
          {
            Log.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
            if (((String)localObject).toLowerCase().endsWith("mp4")) {
              this.BZH.add(GalleryItem.MediaItem.a(2, 0L, (String)localObject, "", ""));
            } else {
              this.BZH.add(GalleryItem.MediaItem.a(1, 0L, (String)localObject, "", ""));
            }
          }
        }
      }
    }
    Log.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", new Object[] { this.BZH });
    AppMethodBeat.o(111412);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(242855);
    switch (paramInt)
    {
    default: 
      paramViewGroup = new a(LayoutInflater.from(this.mContext).inflate(b.f.sd_card_media_folder_preview_item, paramViewGroup, false));
      AppMethodBeat.o(242855);
      return paramViewGroup;
    }
    paramViewGroup = new c(LayoutInflater.from(this.mContext).inflate(b.f.camera_icon, paramViewGroup, false));
    AppMethodBeat.o(242855);
    return paramViewGroup;
  }
  
  public final void bf(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(164792);
    this.BZG.clear();
    this.BZG.addAll(paramLinkedList);
    this.alc.notifyChanged();
    AppMethodBeat.o(164792);
  }
  
  public final void bg(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(111409);
    int i = getItemCount() - this.BZK.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.BZG.addAll(paramLinkedList.subList(i, j));
      aG(i + this.BZK.size(), getItemCount());
    }
    AppMethodBeat.o(111409);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(292880);
    this.BZG.clear();
    AppMethodBeat.o(292880);
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(242856);
    if ((paramv instanceof c))
    {
      paramv.amk.setTag(b.e.item_position, Integer.valueOf(paramInt));
      paramv.amk.setTag(b.e.item_type, Integer.valueOf(0));
      paramv.amk.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(242856);
      return;
    }
    GalleryItem.MediaItem localMediaItem;
    a locala;
    if ((paramv instanceof a))
    {
      paramv.amk.setTag(b.e.item_position, Integer.valueOf(paramInt));
      paramv.amk.setTag(b.e.item_type, Integer.valueOf(1));
      paramv.amk.setOnClickListener(this.mOnClickListener);
      localMediaItem = SY(paramInt);
      if (localMediaItem == null)
      {
        Log.e("MicroMsg.AlbumAdapter", "get item failed");
        AppMethodBeat.o(242856);
        return;
      }
      String str1 = localMediaItem.aZe();
      String str2 = localMediaItem.AAz;
      if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
      {
        Log.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(242856);
        return;
      }
      locala = (a)paramv;
      locala.BZU.setTag(b.e.item_position, Integer.valueOf(paramInt));
      locala.BZU.setOnClickListener(this.BZN);
      locala.BZS.setVisibility(0);
      locala.BZT.setVisibility(0);
      locala.BZV.setVisibility(0);
      if (2 != localMediaItem.getType()) {
        break label608;
      }
      locala.BZS.setImageResource(b.h.video_icon_in_gird);
      a.g.a(locala.BZT, (GalleryItem.VideoMediaItem)localMediaItem);
      int i = this.BZK.size();
      paramv = this.ucN.format(new Date(localMediaItem.BVm));
      paramv = paramInt - i + 1 + ", " + paramv;
      if (2 != localMediaItem.getType()) {
        break label712;
      }
      paramv = "视频 ".concat(String.valueOf(paramv));
      label358:
      locala.BPW.setContentDescription(paramv);
      Log.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramv });
      h.a(locala.BPW, localMediaItem.getType(), str1, str2, localMediaItem.BVl, localMediaItem.BVm);
      locala.BZU.setVisibility(0);
      paramInt = com.tencent.mm.plugin.gallery.model.e.etl().pag;
      if ((paramInt != 0) && (5 != paramInt) && (10 != paramInt) && (11 != paramInt) && (24 != paramInt) && (paramInt != 27)) {
        break label726;
      }
      locala.BZU.setVisibility(4);
      label478:
      if (!this.BZL) {
        break label908;
      }
      if ((16 != paramInt) || ((localMediaItem.getType() != 2) && (localMediaItem.getType() != 3)) || (this.BZF <= 1)) {
        break label819;
      }
      locala.BZU.setVisibility(0);
      if (!this.BZH.contains(localMediaItem)) {
        break label796;
      }
      locala.BZU.setCheckedNumber(this.BZH.indexOf(localMediaItem) + 1);
      locala.BZR.setBackgroundResource(b.b.UN_BW_0_Alpha_0_5);
      label568:
      if (locala.BZU.getVisibility() != 0) {
        break label976;
      }
      a.a(locala, locala.BZU);
    }
    for (;;)
    {
      locala.amk.setOnLongClickListener(this.BZM);
      AppMethodBeat.o(242856);
      return;
      label608:
      if (localMediaItem.mMimeType.equalsIgnoreCase("edit"))
      {
        locala.BZS.setImageResource(b.h.photo_edit_mark);
        locala.BZT.setVisibility(4);
        break;
      }
      if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))
      {
        locala.BZS.setImageResource(b.d.gif_tips_icon);
        locala.BZT.setVisibility(4);
        break;
      }
      locala.BZS.setVisibility(4);
      locala.BZT.setVisibility(4);
      locala.BZV.setVisibility(4);
      break;
      label712:
      paramv = "图片".concat(String.valueOf(paramv));
      break label358;
      label726:
      if (15 == paramInt)
      {
        locala.BZU.setBackgroundResource(b.d.item_checkbox_btn_game);
        break label478;
      }
      if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 25)
      {
        locala.BZU.setBackgroundResource(b.d.item_checkbox_btn_finder);
        break label478;
      }
      if (com.tencent.mm.plugin.gallery.model.e.etl().pag != 28) {
        break label478;
      }
      locala.BZU.setBackgroundResource(b.d.item_checkbox_btn_finder_live);
      break label478;
      label796:
      locala.BZU.setChecked(false);
      locala.BZR.setBackgroundResource(b.b.image_gallery_mask);
      break label568;
      label819:
      if (localMediaItem.getType() == 2)
      {
        locala.BZU.setVisibility(4);
        break label568;
      }
      if (this.BZH.contains(localMediaItem))
      {
        locala.BZU.setCheckedNumber(this.BZH.indexOf(localMediaItem) + 1);
        locala.BZR.setBackgroundResource(b.b.UN_BW_0_Alpha_0_5);
        break label568;
      }
      locala.BZU.setChecked(false);
      locala.BZR.setBackgroundResource(b.b.image_gallery_mask);
      break label568;
      label908:
      if (this.BZH.contains(localMediaItem))
      {
        locala.BZU.setCheckedNumber(this.BZH.indexOf(localMediaItem) + 1);
        locala.BZR.setBackgroundResource(b.b.UN_BW_0_Alpha_0_5);
        break label568;
      }
      locala.BZU.setChecked(false);
      locala.BZR.setBackgroundResource(b.b.image_gallery_mask);
      break label568;
      label976:
      a.eY(locala.BZU);
    }
  }
  
  public final ArrayList<String> eun()
  {
    AppMethodBeat.i(111410);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.BZH.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).AAz);
    }
    AppMethodBeat.o(111410);
    return localArrayList;
  }
  
  public final ArrayList<GalleryItem.MediaItem> euo()
  {
    return this.BZH;
  }
  
  public final ArrayList<GalleryItem.MediaItem> eup()
  {
    return this.BZG;
  }
  
  public final int euq()
  {
    AppMethodBeat.i(164794);
    int i = this.BZH.size();
    AppMethodBeat.o(164794);
    return i;
  }
  
  final void fn(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111411);
    this.BZH.clear();
    this.BZH.addAll(paramList);
    AppMethodBeat.o(111411);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111414);
    int i = this.BZK.size();
    int j = this.BZG.size();
    AppMethodBeat.o(111414);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(111415);
    if (paramInt < this.BZK.size())
    {
      paramInt = ((d)this.BZK.get(paramInt)).BZZ;
      AppMethodBeat.o(111415);
      return paramInt;
    }
    AppMethodBeat.o(111415);
    return 1;
  }
  
  final void j(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111420);
    if (this.BZH.contains(paramMediaItem))
    {
      int i = this.BZH.indexOf(paramMediaItem);
      ArrayList localArrayList = new ArrayList();
      while (i < this.BZH.size())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.BZH.get(i);
        int j = this.BZG.indexOf(localMediaItem);
        if (j != -1) {
          localArrayList.add(Integer.valueOf(j));
        }
        i += 1;
      }
      this.BZH.remove(paramMediaItem);
      paramMediaItem = localArrayList.iterator();
      while (paramMediaItem.hasNext()) {
        cL(((Integer)paramMediaItem.next()).intValue() + this.BZK.size());
      }
    }
    AppMethodBeat.o(111420);
  }
  
  public final void setQueryType(int paramInt)
  {
    this.BVD = paramInt;
  }
  
  public final void setSelectLimitCount(int paramInt)
  {
    this.BZF = paramInt;
  }
  
  static final class a
    extends RecyclerView.v
  {
    ImageView BPW;
    ImageView BZR;
    ImageView BZS;
    TextView BZT;
    MMNumberCheckbox BZU;
    View BZV;
    
    a(View paramView)
    {
      super();
      AppMethodBeat.i(111391);
      this.BPW = ((ImageView)paramView.findViewById(b.e.media_thumb));
      this.BZR = ((ImageView)paramView.findViewById(b.e.media_mask));
      this.BZS = ((ImageView)paramView.findViewById(b.e.type_mask_iv));
      this.BZT = ((TextView)paramView.findViewById(b.e.type_mask_tv));
      this.BZU = ((MMNumberCheckbox)paramView.findViewById(b.e.media_cbx));
      this.BZV = paramView.findViewById(b.e.type_mask_btm);
      AppMethodBeat.o(111391);
    }
  }
  
  static final class b
    extends a.d
  {
    b()
    {
      this.BZZ = 0;
    }
  }
  
  static final class c
    extends RecyclerView.v
  {
    private TextView BZY;
    
    c(View paramView)
    {
      super();
      AppMethodBeat.i(111394);
      this.BZY = ((TextView)paramView.findViewById(b.e.media_thumb));
      if ((com.tencent.mm.plugin.gallery.model.e.etl().BVD == 2) || (com.tencent.mm.plugin.gallery.model.e.etl().pag == 13))
      {
        this.BZY.setText(b.i.gallery_take_vedio);
        AppMethodBeat.o(111394);
        return;
      }
      if (com.tencent.mm.plugin.gallery.model.e.etl().BVD == 1) {
        this.BZY.setText(b.i.gallery_take_picture);
      }
      AppMethodBeat.o(111394);
    }
  }
  
  static abstract class d
  {
    int BZZ;
  }
  
  public static abstract interface e
  {
    public abstract void ak(int paramInt1, int paramInt2, int paramInt3);
  }
  
  static abstract interface f
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a
 * JD-Core Version:    0.7.0.1
 */