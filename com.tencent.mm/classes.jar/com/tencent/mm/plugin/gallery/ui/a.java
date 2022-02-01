package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
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
import com.tencent.mm.autogen.mmdata.rpt.ql;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import com.tencent.mm.vfs.y;
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
  extends RecyclerView.a<RecyclerView.v>
{
  public int HIa;
  public ArrayList<GalleryItem.MediaItem> HLA;
  public ArrayList<GalleryItem.MediaItem> HLB;
  private e HLC;
  String HLD;
  private boolean HLE;
  LinkedList<d> HLF;
  boolean HLG;
  private View.OnLongClickListener HLH;
  private View.OnClickListener HLI;
  f HLJ;
  public int HLz;
  private Context mContext;
  private View.OnClickListener mOnClickListener;
  int qqa;
  String toUser;
  private SimpleDateFormat xiR;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(111407);
    this.HLz = 9;
    this.HLA = new ArrayList();
    this.HLB = new ArrayList();
    this.xiR = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.qqa = 10;
    this.toUser = "";
    this.HLF = new LinkedList();
    this.HLG = false;
    this.HLH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111387);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        paramAnonymousView = paramAnonymousView.getTag(b.e.item_position);
        if ((paramAnonymousView instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView).intValue();
          paramAnonymousView = a.this.WF(i);
          if (paramAnonymousView != null) {
            ClipboardHelper.setText(a.a(a.this), "media info", paramAnonymousView.toString());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(111387);
        return true;
      }
    };
    this.HLI = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(111388);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = paramAnonymousView.getTag(b.e.item_position);
        if (!(localObject instanceof Integer))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111388);
          return;
        }
        int k = ((Integer)localObject).intValue();
        localObject = a.this.WF(k);
        if ((localObject == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject).Gcc)))
        {
          Log.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
          a.this.fV(k);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111388);
          return;
        }
        Log.i("MicroMsg.AlbumAdapter", "click image path:" + ((GalleryItem.MediaItem)localObject).Gcc);
        int j;
        if (a.b(a.this).contains(localObject))
        {
          a.b(a.this).indexOf(localObject);
          a.this.i((GalleryItem.MediaItem)localObject);
          i = 0;
          j = 1;
          if (i == 0)
          {
            if (a.i(a.this) != null) {
              a.i(a.this).aG(a.this.HLB.size(), k, j);
            }
            label248:
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
          }
        }
        else
        {
          long l1;
          if ((com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 3) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((d)com.tencent.mm.kernel.h.az(d.class)).getProvider().aot(((GalleryItem.MediaItem)localObject).Gcc)))
          {
            l1 = y.bEl(((GalleryItem.MediaItem)localObject).Gcc);
            com.tencent.mm.plugin.gallery.b.h.bZ(13459, l1 + ",1,,0");
            if (ab.bOG()) {
              a.a(a.this, a.a(a.this).getString(b.i.gallery_album_can_not_send_too_large_gif, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(com.tencent.mm.plugin.gallery.b.h.aRi()) }));
            }
            for (;;)
            {
              paramAnonymousView = new ql();
              paramAnonymousView.jrX = 4L;
              paramAnonymousView.jrY = l1;
              paramAnonymousView.xF(a.c(a.this));
              paramAnonymousView.bMH();
              a.this.fV(k);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111388);
              return;
              k.cZ(a.a(a.this), a.a(a.this).getString(b.i.gallery_select_gif_to_big));
            }
          }
          if ((a.d(a.this)) && (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 16) && ((a.e(a.this) == 2) || (a.e(a.this) == 3)) && (a.this.HLB.size() > 0) && (((GalleryItem.MediaItem)a.b(a.this).get(0)).getType() != ((GalleryItem.MediaItem)localObject).getType()))
          {
            k.cZ(a.a(a.this), com.tencent.mm.cd.a.bt(a.a(a.this), b.i.gallery_pic_can_not_choose_video));
            a.this.fV(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if ((!Util.isNullOrNil(a.f(a.this))) && (a.f(a.this).equals("album_business_byp")) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((d)com.tencent.mm.kernel.h.az(d.class)).getProvider().aou(((GalleryItem.MediaItem)localObject).Gcc)))
          {
            k.cZ(a.a(a.this), a.a(a.this).getString(b.i.gallery_no_support_giant_gif_gamelife));
            a.this.fV(k);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111388);
            return;
          }
          if (((a.e(a.this) == 2) || (a.e(a.this) == 3)) && ((localObject instanceof GalleryItem.VideoMediaItem)))
          {
            if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25)
            {
              l1 = a.fBl();
              long l2 = a.fBm();
              if (((GalleryItem.VideoMediaItem)localObject).oTN < com.tencent.mm.modelcontrol.e.bIg().bIn().minDuration * 1000)
              {
                k.a(a.a(a.this), a.a(a.this).getResources().getString(b.i.gallery_video_duration_below, new Object[] { Integer.valueOf(com.tencent.mm.modelcontrol.e.bIg().bIn().minDuration) }), "", false, new DialogInterface.OnClickListener()
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
              if (((GalleryItem.VideoMediaItem)localObject).oTN > l1 * 1000L)
              {
                k.a(a.a(a.this), a.a(a.this).getResources().getString(b.i.gallery_video_duration_limit, new Object[] { Long.valueOf(l2) }), "", false, new DialogInterface.OnClickListener()
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
            if ((!Util.isNullOrNil(a.f(a.this))) && (a.f(a.this).equals("album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localObject).oTN >= a.g(a.this) * 1000 + 500))
            {
              k.cZ(a.a(a.this), a.a(a.this).getResources().getString(b.i.gallery_video_duration_limit, new Object[] { Integer.valueOf(a.g(a.this)) }));
              a.this.fV(k);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111388);
              return;
            }
          }
          paramAnonymousView = com.tencent.mm.plugin.gallery.a.c.HFY;
          if ((com.tencent.mm.plugin.gallery.a.c.fzN()) && ((localObject instanceof GalleryItem.VideoMediaItem)))
          {
            paramAnonymousView = com.tencent.mm.plugin.gallery.a.c.HFY;
            paramAnonymousView = com.tencent.mm.plugin.gallery.a.c.HGb;
            if (paramAnonymousView == null)
            {
              paramAnonymousView = null;
              com.tencent.mm.plugin.gallery.a.a locala = com.tencent.mm.plugin.gallery.a.c.HFZ;
              if ((locala == null) || (locala.HFJ != true)) {
                break label1316;
              }
              i = 1;
              label1156:
              if (i == 0) {
                break label1339;
              }
              locala = com.tencent.mm.plugin.gallery.a.c.HFZ;
              if ((locala == null) || (locala.fzK() != true)) {
                break label1321;
              }
              i = 1;
              label1181:
              if ((i == 0) || (paramAnonymousView == null)) {
                break label1339;
              }
              paramAnonymousView = com.tencent.mm.plugin.sns.m.a.QZO;
              j = com.tencent.mm.plugin.sns.m.a.hlq();
              if (com.tencent.mm.plugin.gallery.a.c.HGe / 1000 <= j)
              {
                if (!(localObject instanceof GalleryItem.VideoMediaItem)) {
                  break label1326;
                }
                paramAnonymousView = (GalleryItem.VideoMediaItem)localObject;
                label1222:
                if (paramAnonymousView != null) {
                  break label1331;
                }
                i = 0;
                label1228:
                if (i / 1000 <= j) {
                  break label1339;
                }
              }
              k.cZ(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(b.i.gallery_album_template_media_exceed_duration_limit, new Object[] { Integer.valueOf(kotlin.h.a.eH(j / 60.0F)) }));
            }
            label1316:
            label1321:
            label1326:
            label1331:
            label1339:
            for (i = 0;; i = 1)
            {
              if (i != 0) {
                break label1344;
              }
              a.this.fV(k);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(111388);
              return;
              paramAnonymousView = (AlbumPreviewUI)com.tencent.mm.plugin.gallery.a.c.h(paramAnonymousView);
              break;
              i = 0;
              break label1156;
              i = 0;
              break label1181;
              paramAnonymousView = null;
              break label1222;
              i = paramAnonymousView.oTN;
              break label1228;
            }
          }
          label1344:
          if (a.b(a.this).size() >= a.h(a.this)) {
            break label1630;
          }
          a.b(a.this).add(localObject);
          a.b(a.this).size();
        }
        label1630:
        for (int i = 0;; i = 1)
        {
          j = 0;
          a.this.fV(k);
          break;
          if (a.e(a.this) == 1)
          {
            k.cZ(a.a(a.this), a.a(a.this).getResources().getQuantityString(b.g.gallery_pic_limit, a.h(a.this), new Object[] { Integer.valueOf(a.h(a.this)) }));
            break label248;
          }
          if (a.e(a.this) == 2)
          {
            k.cZ(a.a(a.this), a.a(a.this).getResources().getQuantityString(b.g.gallery_video_limit, a.h(a.this), new Object[] { Integer.valueOf(a.h(a.this)) }));
            break label248;
          }
          k.cZ(a.a(a.this), a.a(a.this).getResources().getQuantityString(b.g.gallery_pic_or_video_limit, a.h(a.this), new Object[] { Integer.valueOf(a.h(a.this)) }));
          if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB != 3) {
            break label248;
          }
          paramAnonymousView = new ql();
          paramAnonymousView.jrX = 5L;
          paramAnonymousView.xF(a.c(a.this));
          paramAnonymousView.bMH();
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
          if ((i != -1) && (j != -1) && (a.j(a.this) != null)) {
            a.j(a.this).a(i, paramAnonymousView, j);
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
    this.HLC = parame;
    while (i < 32)
    {
      paramContext = new GalleryItem.ImageMediaItem();
      this.HLA.add(paramContext);
      i += 1;
    }
    this.bZE.notifyChanged();
    AppMethodBeat.o(111407);
  }
  
  public final ArrayList<GalleryItem.MediaItem> WE(int paramInt)
  {
    AppMethodBeat.i(111413);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.HLA.iterator();
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
  
  public final GalleryItem.MediaItem WF(int paramInt)
  {
    AppMethodBeat.i(111418);
    if (paramInt < this.HLF.size())
    {
      Log.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    paramInt -= this.HLF.size();
    if (paramInt >= this.HLA.size())
    {
      Log.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.HLA.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.HLA.get(paramInt);
    AppMethodBeat.o(111418);
    return localMediaItem;
  }
  
  final String WG(int paramInt)
  {
    AppMethodBeat.i(111419);
    int i = paramInt;
    if (paramInt < this.HLF.size())
    {
      Log.d("MicroMsg.AlbumAdapter", "header, old pos[%d].", new Object[] { Integer.valueOf(paramInt) });
      i = this.HLF.size();
    }
    Object localObject = WF(i);
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject).HHP))
      {
        localObject = ((GalleryItem.MediaItem)localObject).HHP;
        AppMethodBeat.o(111419);
        return localObject;
      }
      localObject = new Date(((GalleryItem.MediaItem)localObject).HHK);
      localObject = com.tencent.mm.ui.gridviewheaders.a.jBw().a((Date)localObject, this.mContext);
      AppMethodBeat.o(111419);
      return localObject;
    }
    AppMethodBeat.o(111419);
    return "";
  }
  
  final void a(androidx.b.b<Integer> paramb)
  {
    AppMethodBeat.i(289606);
    int i = 0;
    while (i < this.HLB.size())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.HLB.get(i);
      int j = this.HLA.indexOf(localMediaItem);
      if (j != -1) {
        paramb.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramb = paramb.iterator();
    while (paramb.hasNext()) {
      fV(((Integer)paramb.next()).intValue() + this.HLF.size());
    }
    AppMethodBeat.o(289606);
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
    this.HLF.remove(paramd);
    this.HLF.add(paramd);
    AppMethodBeat.o(111408);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(289583);
    switch (paramInt)
    {
    default: 
      paramViewGroup = new a(LayoutInflater.from(this.mContext).inflate(b.f.sd_card_media_folder_preview_item, paramViewGroup, false));
      AppMethodBeat.o(289583);
      return paramViewGroup;
    }
    paramViewGroup = new c(LayoutInflater.from(this.mContext).inflate(b.f.camera_icon, paramViewGroup, false));
    AppMethodBeat.o(289583);
    return paramViewGroup;
  }
  
  public final void bn(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(164792);
    this.HLA.clear();
    this.HLA.addAll(paramLinkedList);
    this.bZE.notifyChanged();
    AppMethodBeat.o(164792);
  }
  
  public final void bo(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(111409);
    int i = getItemCount() - this.HLF.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.HLA.addAll(paramLinkedList.subList(i, j));
      bA(i + this.HLF.size(), getItemCount());
    }
    AppMethodBeat.o(111409);
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(289592);
    if ((paramv instanceof c))
    {
      paramv.caK.setTag(b.e.item_position, Integer.valueOf(paramInt));
      paramv.caK.setTag(b.e.item_type, Integer.valueOf(0));
      paramv.caK.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(289592);
      return;
    }
    GalleryItem.MediaItem localMediaItem;
    a locala;
    int i;
    if ((paramv instanceof a))
    {
      paramv.caK.setTag(b.e.item_position, Integer.valueOf(paramInt));
      paramv.caK.setTag(b.e.item_type, Integer.valueOf(1));
      paramv.caK.setOnClickListener(this.mOnClickListener);
      localMediaItem = WF(paramInt);
      if (localMediaItem == null)
      {
        Log.e("MicroMsg.AlbumAdapter", "get item failed");
        AppMethodBeat.o(289592);
        return;
      }
      String str1 = localMediaItem.bud();
      String str2 = localMediaItem.Gcc;
      if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
      {
        Log.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(289592);
        return;
      }
      locala = (a)paramv;
      locala.HLT.setTag(b.e.item_position, Integer.valueOf(paramInt));
      locala.HLT.setOnClickListener(this.HLI);
      locala.HLO.setVisibility(0);
      locala.HLP.setVisibility(0);
      locala.HLP.setTextSize(0, com.tencent.mm.cd.a.bs(this.mContext, b.c.NormalTextSize));
      locala.HLU.setVisibility(0);
      locala.HLQ.setVisibility(8);
      locala.HLR.setVisibility(8);
      i = com.tencent.mm.plugin.gallery.model.e.fAn().sfB;
      if (2 != localMediaItem.getType()) {
        break label999;
      }
      locala.HLO.setImageResource(b.h.video_icon_in_gird);
      g.a(locala.HLP, (GalleryItem.VideoMediaItem)localMediaItem);
      if ((!ab.bOG()) || (!this.HLE) || (i != 3)) {
        break label976;
      }
      if (y.bEl(localMediaItem.Gcc) <= com.tencent.mm.plugin.gallery.b.h.aRj()) {
        break label935;
      }
      locala.HLQ.setVisibility(0);
      locala.HLR.setVisibility(0);
      locala.HLR.setText(this.mContext.getString(b.i.gallery_album_item_too_large_video_disable_tips, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(com.tencent.mm.plugin.gallery.b.h.aRj()) }));
      locala.HLN.setBackgroundResource(b.b.image_gallery_mask);
      locala.HLN.setVisibility(8);
      locala.HLT.setEnabled(locala.HLT.isChecked());
      if ((localMediaItem.getType() == 1) && (ab.bOG()) && (this.HLE) && (i == 3))
      {
        if (y.bEl(localMediaItem.Gcc) <= 26214400L) {
          break label1103;
        }
        locala.HLQ.setVisibility(0);
        locala.HLR.setVisibility(0);
        locala.HLR.setText(this.mContext.getString(b.i.gallery_album_item_too_large_image_disable_tips, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(26214400L) }));
        locala.HLN.setBackgroundResource(b.b.image_gallery_mask);
        locala.HLN.setVisibility(8);
        locala.HLT.setEnabled(locala.HLT.isChecked());
      }
      label577:
      int j = this.HLF.size();
      paramv = this.xiR.format(new Date(localMediaItem.HHK));
      paramv = paramInt - j + 1 + ", " + paramv;
      if (2 != localMediaItem.getType()) {
        break label1144;
      }
      paramv = this.mContext.getResources().getString(b.i.app_field_video) + paramv;
      label676:
      locala.HLM.setContentDescription(paramv);
      Log.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramv });
      h.a(locala.HLM, localMediaItem.getType(), str1, str2, localMediaItem.HHJ, localMediaItem.HHK);
      locala.HLT.setVisibility(0);
      if ((i != 0) && (5 != i) && (10 != i) && (11 != i) && (24 != i) && (i != 31) && (i != 27)) {
        break label1178;
      }
      locala.HLT.setVisibility(4);
      label796:
      if (!this.HLG) {
        break label1369;
      }
      if ((16 != i) || ((localMediaItem.getType() != 2) && (localMediaItem.getType() != 3)) || (this.HLz <= 1)) {
        break label1271;
      }
      locala.HLT.setVisibility(0);
      if (!this.HLB.contains(localMediaItem)) {
        break label1248;
      }
      locala.HLT.setCheckedNumber(this.HLB.indexOf(localMediaItem) + 1);
      locala.HLT.setEnabled(true);
      locala.HLN.setBackgroundResource(b.b.UN_BW_0_Alpha_0_5);
      label895:
      if (locala.HLT.getVisibility() != 0) {
        break label1446;
      }
      a.a(locala, locala.HLT);
    }
    for (;;)
    {
      locala.caK.setOnLongClickListener(this.HLH);
      AppMethodBeat.o(289592);
      return;
      label935:
      locala.HLR.setVisibility(8);
      locala.HLQ.setVisibility(8);
      locala.HLN.setVisibility(0);
      locala.HLT.setEnabled(true);
      break;
      label976:
      locala.HLR.setVisibility(8);
      locala.HLQ.setVisibility(8);
      break;
      label999:
      if (localMediaItem.mMimeType.equalsIgnoreCase("edit"))
      {
        locala.HLO.setImageResource(b.h.photo_edit_mark);
        locala.HLP.setVisibility(4);
        break;
      }
      if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))
      {
        locala.HLO.setImageResource(b.d.gif_tips_icon);
        locala.HLP.setVisibility(4);
        break;
      }
      locala.HLO.setVisibility(4);
      locala.HLP.setVisibility(4);
      locala.HLU.setVisibility(4);
      break;
      label1103:
      locala.HLR.setVisibility(8);
      locala.HLQ.setVisibility(8);
      locala.HLN.setVisibility(0);
      locala.HLT.setEnabled(true);
      break label577;
      label1144:
      paramv = this.mContext.getResources().getString(b.i.app_field_pic) + paramv;
      break label676;
      label1178:
      if (15 == i)
      {
        locala.HLT.setBackgroundResource(b.d.item_checkbox_btn_game);
        break label796;
      }
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 25)
      {
        locala.HLT.setBackgroundResource(b.d.item_checkbox_btn_finder);
        break label796;
      }
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB != 28) {
        break label796;
      }
      locala.HLT.setBackgroundResource(b.d.item_checkbox_btn_finder_live);
      break label796;
      label1248:
      locala.HLT.setChecked(false);
      locala.HLN.setBackgroundResource(b.b.image_gallery_mask);
      break label895;
      label1271:
      if (localMediaItem.getType() == 2)
      {
        locala.HLT.setVisibility(4);
        break label895;
      }
      if (this.HLB.contains(localMediaItem))
      {
        locala.HLT.setCheckedNumber(this.HLB.indexOf(localMediaItem) + 1);
        locala.HLT.setEnabled(true);
        locala.HLN.setBackgroundResource(b.b.UN_BW_0_Alpha_0_5);
        break label895;
      }
      locala.HLT.setChecked(false);
      locala.HLN.setBackgroundResource(b.b.image_gallery_mask);
      break label895;
      label1369:
      if (this.HLB.contains(localMediaItem))
      {
        locala.HLT.setCheckedNumber(this.HLB.indexOf(localMediaItem) + 1);
        locala.HLT.setEnabled(true);
        locala.HLN.setBackgroundResource(b.b.UN_BW_0_Alpha_0_5);
        break label895;
      }
      locala.HLT.setChecked(false);
      locala.HLN.setBackgroundResource(b.b.image_gallery_mask);
      break label895;
      label1446:
      a.ht(locala.HLT);
    }
  }
  
  public final ArrayList<String> fBk()
  {
    AppMethodBeat.i(111410);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.HLB.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).Gcc);
    }
    AppMethodBeat.o(111410);
    return localArrayList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111414);
    int i = this.HLF.size();
    int j = this.HLA.size();
    AppMethodBeat.o(111414);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(111415);
    if (paramInt < this.HLF.size())
    {
      paramInt = ((d)this.HLF.get(paramInt)).HLY;
      AppMethodBeat.o(111415);
      return paramInt;
    }
    AppMethodBeat.o(111415);
    return 1;
  }
  
  final void i(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111420);
    if (this.HLB.contains(paramMediaItem))
    {
      int i = this.HLB.indexOf(paramMediaItem);
      ArrayList localArrayList = new ArrayList();
      while (i < this.HLB.size())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.HLB.get(i);
        int j = this.HLA.indexOf(localMediaItem);
        if (j != -1) {
          localArrayList.add(Integer.valueOf(j));
        }
        i += 1;
      }
      this.HLB.remove(paramMediaItem);
      paramMediaItem = localArrayList.iterator();
      while (paramMediaItem.hasNext()) {
        fV(((Integer)paramMediaItem.next()).intValue() + this.HLF.size());
      }
    }
    AppMethodBeat.o(111420);
  }
  
  final void id(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111411);
    this.HLB.clear();
    this.HLB.addAll(paramList);
    AppMethodBeat.o(111411);
  }
  
  public final void j(ArrayList<String> paramArrayList, ArrayList<GalleryItem.MediaItem> paramArrayList1)
  {
    AppMethodBeat.i(289570);
    Log.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", new Object[] { this.HLB });
    this.HLB.clear();
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        paramArrayList = GalleryItem.MediaItem.a(0, 0L, str2, "", "");
        if (paramArrayList1 != null)
        {
          int i = paramArrayList1.indexOf(paramArrayList);
          if (i >= 0)
          {
            paramArrayList = (GalleryItem.MediaItem)paramArrayList1.get(i);
            this.HLB.add(paramArrayList);
          }
          else
          {
            String str1 = MimeTypeUtil.getMimeTypeByFilePath(str2);
            Log.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
            if (str2.toLowerCase().endsWith("mp4"))
            {
              this.HLB.add(GalleryItem.MediaItem.a(2, 0L, str2, "", ""));
            }
            else
            {
              ArrayList localArrayList = this.HLB;
              paramArrayList = str1;
              if (Util.isNullOrNil(str1)) {
                paramArrayList = "";
              }
              localArrayList.add(GalleryItem.MediaItem.a(1, 0L, str2, "", paramArrayList));
            }
          }
        }
      }
    }
    Log.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", new Object[] { this.HLB });
    AppMethodBeat.o(289570);
  }
  
  public final void vU(boolean paramBoolean)
  {
    AppMethodBeat.i(289555);
    this.HLE = paramBoolean;
    this.bZE.notifyChanged();
    AppMethodBeat.o(289555);
  }
  
  static final class a
    extends RecyclerView.v
  {
    ImageView HLM;
    ImageView HLN;
    ImageView HLO;
    TextView HLP;
    ImageView HLQ;
    TextView HLR;
    MMNumberCheckbox HLT;
    View HLU;
    
    a(View paramView)
    {
      super();
      AppMethodBeat.i(111391);
      this.HLM = ((ImageView)paramView.findViewById(b.e.media_thumb));
      this.HLN = ((ImageView)paramView.findViewById(b.e.media_mask));
      this.HLO = ((ImageView)paramView.findViewById(b.e.type_mask_iv));
      this.HLP = ((TextView)paramView.findViewById(b.e.type_mask_tv));
      this.HLT = ((MMNumberCheckbox)paramView.findViewById(b.e.media_cbx));
      this.HLQ = ((ImageView)paramView.findViewById(b.e.disable_mask));
      this.HLR = ((TextView)paramView.findViewById(b.e.disable_mask_tv));
      this.HLU = paramView.findViewById(b.e.type_mask_btm);
      AppMethodBeat.o(111391);
    }
  }
  
  static final class b
    extends a.d
  {
    b()
    {
      this.HLY = 0;
    }
  }
  
  static final class c
    extends RecyclerView.v
  {
    private TextView HLX;
    
    c(View paramView)
    {
      super();
      AppMethodBeat.i(111394);
      this.HLX = ((TextView)paramView.findViewById(b.e.media_thumb));
      if (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 4)
      {
        this.HLX.setText(b.i.gallery_take_capture);
        AppMethodBeat.o(111394);
        return;
      }
      if ((com.tencent.mm.plugin.gallery.model.e.fAn().HIa == 2) || (com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 13))
      {
        this.HLX.setText(b.i.gallery_take_vedio);
        AppMethodBeat.o(111394);
        return;
      }
      if (com.tencent.mm.plugin.gallery.model.e.fAn().HIa == 1) {
        this.HLX.setText(b.i.gallery_take_picture);
      }
      AppMethodBeat.o(111394);
    }
  }
  
  static abstract class d
  {
    int HLY;
  }
  
  public static abstract interface e
  {
    public abstract void aG(int paramInt1, int paramInt2, int paramInt3);
  }
  
  static abstract interface f
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
  }
  
  public static final class g
    implements Runnable
  {
    private static HashMap<TextView, g> HMb;
    private GalleryItem.VideoMediaItem HLZ;
    private a HMa;
    private boolean nzW;
    private WeakReference<TextView> zVE;
    
    static
    {
      AppMethodBeat.i(111406);
      HMb = new HashMap();
      AppMethodBeat.o(111406);
    }
    
    private g(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, a parama)
    {
      AppMethodBeat.i(111397);
      this.zVE = new WeakReference(paramTextView);
      this.HLZ = paramVideoMediaItem;
      this.HMa = parama;
      AppMethodBeat.o(111397);
    }
    
    public static void a(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem)
    {
      AppMethodBeat.i(111399);
      if ((paramTextView == null) || (paramVideoMediaItem == null))
      {
        Log.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
        AppMethodBeat.o(111399);
        return;
      }
      if (HMb.containsKey(paramTextView))
      {
        g localg = (g)HMb.get(paramTextView);
        if (localg != null)
        {
          if (localg.HLZ.equals(paramVideoMediaItem))
          {
            AppMethodBeat.o(111399);
            return;
          }
          if (paramTextView.equals(localg.zVE.get()))
          {
            localg.zVE = new WeakReference(null);
            localg.nzW = true;
          }
        }
      }
      if (paramVideoMediaItem.oTN >= 0)
      {
        Log.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.oTN), paramVideoMediaItem });
        l(paramTextView, paramVideoMediaItem.oTN);
        HMb.remove(paramTextView);
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
          a.g.m(paramAnonymousg, paramAnonymousInt);
          a.g.fBp().remove(paramAnonymousg);
          AppMethodBeat.o(111396);
        }
      });
      com.tencent.mm.plugin.gallery.model.e.fAo().aF(paramVideoMediaItem);
      HMb.put(paramTextView, paramVideoMediaItem);
      AppMethodBeat.o(111399);
    }
    
    private static boolean aBm(String paramString)
    {
      AppMethodBeat.i(173745);
      Object localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoa, "");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(173745);
        return false;
      }
      Log.i("MicroMsg.AlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
      Log.i("MicroMsg.AlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, com.tencent.mm.compatible.deviceinfo.q.aPo() });
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
          if ((Build.MANUFACTURER.equalsIgnoreCase(((JSONObject)localObject2).optString("brand"))) && (com.tencent.mm.compatible.deviceinfo.q.aPo().equalsIgnoreCase(((JSONObject)localObject2).optString("model"))))
          {
            long l = y.bEl(paramString);
            if ((j != 0) && (l > j * 1024 * 1024))
            {
              Log.i("MicroMsg.AlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
              AppMethodBeat.o(173745);
              return false;
            }
            int k = ((JSONObject)localObject2).optInt("androidVersion");
            if (-1 == k)
            {
              Log.i("MicroMsg.AlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, com.tencent.mm.compatible.deviceinfo.q.aPo() });
              AppMethodBeat.o(173745);
              return true;
            }
            if (Build.VERSION.SDK_INT == k)
            {
              Log.i("MicroMsg.AlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, com.tencent.mm.compatible.deviceinfo.q.aPo() });
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
        Log.printErrStackTrace("MicroMsg.AlbumAdapter", paramString, "parse json error", new Object[0]);
        AppMethodBeat.o(173745);
      }
    }
    
    public static void fBn()
    {
      AppMethodBeat.i(111398);
      HMb.clear();
      AppMethodBeat.o(111398);
    }
    
    private void fBo()
    {
      AppMethodBeat.i(173746);
      if (this.HLZ == null)
      {
        AppMethodBeat.o(173746);
        return;
      }
      long l = Util.currentTicks();
      try
      {
        String str = this.HLZ.bud();
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        Log.d("MicroMsg.AlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
        localObject = new JSONObject((String)localObject);
        this.HLZ.oTN = ((JSONObject)localObject).getInt("videoDuration");
        this.HLZ.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
        this.HLZ.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
        this.HLZ.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
        this.HLZ.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
        this.HLZ.nCg = SightVideoJNI.getMp4RotateVFS(str);
        this.HLZ.videoIFrameInterval = 0;
        this.HLZ.oTL = f.aFg(((JSONObject)localObject).getString("videoType"));
        this.HLZ.oTM = f.aFg(((JSONObject)localObject).getString("audioType"));
        Log.d("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.HLZ });
        Log.i("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        AppMethodBeat.o(173746);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AlbumAdapter", localException, "loadItemFromSimpleMP4Info fail", new Object[0]);
        }
      }
    }
    
    private static void l(TextView paramTextView, int paramInt)
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
      boolean bool = this.HLZ.equals(((g)paramObject).HLZ);
      AppMethodBeat.o(111401);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111402);
      int i = this.HLZ.hashCode();
      AppMethodBeat.o(111402);
      return i;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111404);
      if (this.nzW)
      {
        AppMethodBeat.o(111404);
        return;
      }
      int i;
      label123:
      long l;
      com.tencent.mm.compatible.i.c localc;
      String str1;
      if (aBm(this.HLZ.bud()))
      {
        fBo();
        if (this.nzW) {
          break label818;
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          if (this.HMa != null) {
            this.HMa.a(this, this.HLZ.oTN);
          }
          AppMethodBeat.o(111404);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zns, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label123;
          }
          fBo();
          break;
        }
        l = Util.currentTicks();
        localc = new com.tencent.mm.compatible.i.c();
        str1 = this.HLZ.bud();
      }
      for (;;)
      {
        Object localObject4;
        Object localObject7;
        Object localObject8;
        try
        {
          localc.setDataSource(str1);
          int j = localc.lZm.getTrackCount();
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
              Log.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
              localObject7 = localObject4;
              localObject8 = localObject1;
              break label825;
            }
            str2 = localMediaFormat.getString("mime");
            Log.d("MicroMsg.AlbumAdapter", "find video mime : %s", new Object[] { str2 });
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
          if (this.HLZ != null)
          {
            if (localObject6 != null)
            {
              localObject1 = this.HLZ;
              if (localObject6.containsKey("durationUs")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).oTN = i;
              localObject1 = this.HLZ;
              if (localObject6.containsKey("height")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
              localObject1 = this.HLZ;
              if (localObject6.containsKey("width")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
              localObject4 = this.HLZ;
              if (localObject6.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).oTL = ((String)localObject1);
              localObject1 = this.HLZ;
              if (localObject6.containsKey("bitrate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
              localObject1 = this.HLZ;
              if (localObject6.containsKey("i-frame-interval")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoIFrameInterval = i;
              localObject1 = this.HLZ;
              if (localObject6.containsKey("frame-rate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
              this.HLZ.nCg = SightVideoJNI.getMp4RotateVFS(str1);
            }
            if (localObject5 != null)
            {
              localObject4 = this.HLZ;
              if (localObject5.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).oTM = ((String)localObject1);
            }
          }
          Log.d("MicroMsg.AlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.HLZ });
          Log.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
          localc.lZm.release();
        }
        catch (Exception localException)
        {
          Object localObject1;
          MediaFormat localMediaFormat;
          String str2;
          Log.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
          localc.lZm.release();
          continue;
        }
        finally
        {
          localc.lZm.release();
          AppMethodBeat.o(111404);
        }
        Log.i("MicroMsg.AlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
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
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111395);
                if (a.g.a(a.g.this) != null) {
                  a.g.a(a.g.this).a(a.g.this, a.g.b(a.g.this).oTN);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a
 * JD-Core Version:    0.7.0.1
 */