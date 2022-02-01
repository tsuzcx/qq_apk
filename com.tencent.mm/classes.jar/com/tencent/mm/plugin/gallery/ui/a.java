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
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import com.tencent.mm.vfs.i;
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
  int iBF;
  private Context mContext;
  private View.OnClickListener mOnClickListener;
  private SimpleDateFormat oaB;
  int rBG;
  int rGT;
  ArrayList<GalleryItem.MediaItem> rGU;
  ArrayList<GalleryItem.MediaItem> rGV;
  private e rGW;
  String rGX;
  LinkedList<d> rGY;
  boolean rGZ;
  private View.OnLongClickListener rHa;
  private View.OnClickListener rHb;
  f rHc;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(111407);
    this.rGT = 9;
    this.rGU = new ArrayList();
    this.rGV = new ArrayList();
    this.oaB = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.iBF = 10;
    this.rGY = new LinkedList();
    this.rGZ = false;
    this.rHa = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111387);
        paramAnonymousView = paramAnonymousView.getTag(2131301175);
        if ((paramAnonymousView instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView).intValue();
          paramAnonymousView = a.this.Eb(i);
          if (paramAnonymousView != null) {
            ((ClipboardManager)a.a(a.this).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("media info", paramAnonymousView.toString()));
          }
        }
        AppMethodBeat.o(111387);
        return true;
      }
    };
    this.rHb = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(111388);
        Object localObject = paramAnonymousView.getTag(2131301175);
        if (!(localObject instanceof Integer))
        {
          AppMethodBeat.o(111388);
          return;
        }
        int k = ((Integer)localObject).intValue();
        localObject = a.this.Eb(k);
        if ((localObject == null) || (bt.isNullOrNil(((GalleryItem.MediaItem)localObject).rBp)))
        {
          ad.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
          a.this.ck(k);
          AppMethodBeat.o(111388);
          return;
        }
        ad.i("MicroMsg.AlbumAdapter", "click image path:" + ((GalleryItem.MediaItem)localObject).rBp);
        int j;
        if (a.b(a.this).contains(localObject))
        {
          a.b(a.this).indexOf(localObject);
          a.this.g((GalleryItem.MediaItem)localObject);
          j = 1;
          i = 0;
          if (i == 0)
          {
            if (a.g(a.this) == null) {
              break label907;
            }
            a.g(a.this).ab(a.this.rGV.size(), k, j);
            AppMethodBeat.o(111388);
          }
        }
        else
        {
          long l;
          if ((com.tencent.mm.plugin.gallery.model.e.czh().jWF == 3) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().TM(((GalleryItem.MediaItem)localObject).rBp)))
          {
            l = i.aMN(((GalleryItem.MediaItem)localObject).rBp);
            com.tencent.mm.plugin.gallery.a.d.bd(13459, l + ",1,,0");
            com.tencent.mm.ui.base.h.cf(a.a(a.this), a.a(a.this).getString(2131759800));
            a.this.ck(k);
            AppMethodBeat.o(111388);
            return;
          }
          if (((a.c(a.this) == 2) || (a.c(a.this) == 3)) && ((localObject instanceof GalleryItem.VideoMediaItem)))
          {
            if (com.tencent.mm.plugin.gallery.model.e.czh().jWF == 25)
            {
              l = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pru, 300);
              if (((GalleryItem.VideoMediaItem)localObject).hsU < com.tencent.mm.modelcontrol.d.awT().awZ().minDuration * 1000)
              {
                com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getResources().getString(2131759821, new Object[] { Integer.valueOf(com.tencent.mm.modelcontrol.d.awT().awZ().minDuration) }), "", false, new DialogInterface.OnClickListener()
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
                AppMethodBeat.o(111388);
                return;
              }
              if (((GalleryItem.VideoMediaItem)localObject).hsU > 1000L * l)
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
                AppMethodBeat.o(111388);
                return;
              }
            }
            if ((!bt.isNullOrNil(a.d(a.this))) && (a.d(a.this).equals("album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localObject).hsU >= a.e(a.this) * 1000 + 500))
            {
              com.tencent.mm.ui.base.h.cf(a.a(a.this), a.a(a.this).getResources().getString(2131759822, new Object[] { Integer.valueOf(a.e(a.this)) }));
              a.this.ck(k);
              AppMethodBeat.o(111388);
              return;
            }
          }
          if (a.b(a.this).size() >= a.f(a.this)) {
            break label913;
          }
          a.b(a.this).add(localObject);
          a.b(a.this).size();
        }
        label907:
        label913:
        for (int i = 0;; i = 1)
        {
          a.this.ck(k);
          j = 0;
          break;
          if (a.c(a.this) == 1)
          {
            com.tencent.mm.ui.base.h.cf(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623950, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
            AppMethodBeat.o(111388);
            return;
          }
          if (a.c(a.this) == 2)
          {
            com.tencent.mm.ui.base.h.cf(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623952, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
            AppMethodBeat.o(111388);
            return;
          }
          com.tencent.mm.ui.base.h.cf(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623951, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
          AppMethodBeat.o(111388);
          return;
        }
      }
    };
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111389);
        Object localObject = paramAnonymousView.getTag(2131301175);
        int i;
        if ((localObject instanceof Integer))
        {
          i = ((Integer)localObject).intValue();
          localObject = paramAnonymousView.getTag(2131301200);
          if (!(localObject instanceof Integer)) {
            break label101;
          }
        }
        label101:
        for (int j = ((Integer)localObject).intValue();; j = -1)
        {
          if ((i != -1) && (j != -1) && (a.h(a.this) != null)) {
            a.h(a.this).a(i, paramAnonymousView, j);
          }
          AppMethodBeat.o(111389);
          return;
          i = -1;
          break;
        }
      }
    };
    this.mContext = paramContext;
    this.rGW = parame;
    while (i < 32)
    {
      paramContext = new GalleryItem.ImageMediaItem();
      this.rGU.add(paramContext);
      i += 1;
    }
    this.aql.notifyChanged();
    AppMethodBeat.o(111407);
  }
  
  public final ArrayList<GalleryItem.MediaItem> Ea(int paramInt)
  {
    AppMethodBeat.i(111413);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.rGU.iterator();
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
  
  public final GalleryItem.MediaItem Eb(int paramInt)
  {
    AppMethodBeat.i(111418);
    if (paramInt < this.rGY.size())
    {
      ad.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    paramInt -= this.rGY.size();
    if (paramInt >= this.rGU.size())
    {
      ad.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.rGU.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.rGU.get(paramInt);
    AppMethodBeat.o(111418);
    return localMediaItem;
  }
  
  final String Ec(int paramInt)
  {
    AppMethodBeat.i(111419);
    int i = paramInt;
    if (paramInt < this.rGY.size())
    {
      ad.d("MicroMsg.AlbumAdapter", "header, old pos[%d].", new Object[] { Integer.valueOf(paramInt) });
      i = this.rGY.size();
    }
    Object localObject = Eb(i);
    if (localObject != null)
    {
      if (!bt.isNullOrNil(((GalleryItem.MediaItem)localObject).rBv))
      {
        localObject = ((GalleryItem.MediaItem)localObject).rBv;
        AppMethodBeat.o(111419);
        return localObject;
      }
      localObject = new Date(((GalleryItem.MediaItem)localObject).rBt);
      localObject = com.tencent.mm.ui.gridviewheaders.a.fcX().a((Date)localObject, this.mContext);
      AppMethodBeat.o(111419);
      return localObject;
    }
    AppMethodBeat.o(111419);
    return "";
  }
  
  public final void S(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111412);
    ad.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", new Object[] { this.rGV });
    this.rGV.clear();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (String)paramArrayList.next();
        GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, (String)localObject, "", "");
        if (com.tencent.mm.plugin.gallery.model.e.czj() != null)
        {
          int i = com.tencent.mm.plugin.gallery.model.e.czj().indexOf(localMediaItem);
          if (i >= 0)
          {
            localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.czj().get(i);
            this.rGV.add(localObject);
          }
          else
          {
            ad.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
            if (((String)localObject).toLowerCase().endsWith("mp4")) {
              this.rGV.add(GalleryItem.MediaItem.a(2, 0L, (String)localObject, "", ""));
            } else {
              this.rGV.add(GalleryItem.MediaItem.a(1, 0L, (String)localObject, "", ""));
            }
          }
        }
      }
    }
    ad.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", new Object[] { this.rGV });
    AppMethodBeat.o(111412);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(111416);
    switch (paramInt)
    {
    default: 
      paramViewGroup = new a.a(LayoutInflater.from(this.mContext).inflate(2131495310, paramViewGroup, false));
      AppMethodBeat.o(111416);
      return paramViewGroup;
    }
    paramViewGroup = new a.c(LayoutInflater.from(this.mContext).inflate(2131493244, paramViewGroup, false));
    AppMethodBeat.o(111416);
    return paramViewGroup;
  }
  
  final void a(android.support.v4.e.b<Integer> paramb)
  {
    AppMethodBeat.i(111421);
    int i = 0;
    while (i < this.rGV.size())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.rGV.get(i);
      int j = this.rGU.indexOf(localMediaItem);
      if (j != -1) {
        paramb.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramb = paramb.iterator();
    while (paramb.hasNext()) {
      ck(((Integer)paramb.next()).intValue() + this.rGY.size());
    }
    AppMethodBeat.o(111421);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(111417);
    if ((paramv instanceof a.c))
    {
      paramv.arI.setTag(2131301175, Integer.valueOf(paramInt));
      paramv.arI.setTag(2131301200, Integer.valueOf(0));
      paramv.arI.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(111417);
      return;
    }
    GalleryItem.MediaItem localMediaItem;
    a.a locala;
    if ((paramv instanceof a.a))
    {
      paramv.arI.setTag(2131301175, Integer.valueOf(paramInt));
      paramv.arI.setTag(2131301200, Integer.valueOf(1));
      paramv.arI.setOnClickListener(this.mOnClickListener);
      localMediaItem = Eb(paramInt);
      if (localMediaItem == null)
      {
        ad.e("MicroMsg.AlbumAdapter", "get item failed");
        AppMethodBeat.o(111417);
        return;
      }
      String str1 = localMediaItem.anX();
      String str2 = localMediaItem.rBp;
      if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)))
      {
        ad.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111417);
        return;
      }
      locala = (a.a)paramv;
      locala.rHi.setTag(2131301175, Integer.valueOf(paramInt));
      locala.rHi.setOnClickListener(this.rHb);
      locala.rHg.setVisibility(0);
      locala.rHh.setVisibility(0);
      locala.rHj.setVisibility(0);
      if (2 != localMediaItem.getType()) {
        break label537;
      }
      locala.rHg.setImageResource(2131691361);
      g.a(locala.rHh, (GalleryItem.VideoMediaItem)localMediaItem);
      int i = this.rGY.size();
      paramv = this.oaB.format(new Date(localMediaItem.rBt));
      paramv = paramInt - i + 1 + ", " + paramv;
      if (2 != localMediaItem.getType()) {
        break label641;
      }
      paramv = "视频 ".concat(String.valueOf(paramv));
      label358:
      locala.rww.setContentDescription(paramv);
      ad.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramv });
      h.a(locala.rww, localMediaItem.getType(), str1, str2, localMediaItem.rBs, localMediaItem.rBt);
      locala.rHi.setVisibility(0);
      paramInt = com.tencent.mm.plugin.gallery.model.e.czh().jWF;
      if ((paramInt != 0) && (5 != paramInt) && (10 != paramInt) && (11 != paramInt) && (24 != paramInt)) {
        break label655;
      }
      locala.rHi.setVisibility(4);
      label472:
      if (!this.rGZ) {
        break label768;
      }
      if (localMediaItem.getType() != 2) {
        break label700;
      }
      locala.rHi.setVisibility(4);
      label497:
      if (locala.rHi.getVisibility() != 0) {
        break label836;
      }
      a.a.a(locala, locala.rHi);
    }
    for (;;)
    {
      locala.arI.setOnLongClickListener(this.rHa);
      AppMethodBeat.o(111417);
      return;
      label537:
      if (localMediaItem.mMimeType.equalsIgnoreCase("edit"))
      {
        locala.rHg.setImageResource(2131691030);
        locala.rHh.setVisibility(4);
        break;
      }
      if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))
      {
        locala.rHg.setImageResource(2131232599);
        locala.rHh.setVisibility(4);
        break;
      }
      locala.rHg.setVisibility(4);
      locala.rHh.setVisibility(4);
      locala.rHj.setVisibility(4);
      break;
      label641:
      paramv = "图片".concat(String.valueOf(paramv));
      break label358;
      label655:
      if (15 == paramInt)
      {
        locala.rHi.setBackgroundResource(2131232750);
        break label472;
      }
      if (com.tencent.mm.plugin.gallery.model.e.czh().jWF != 25) {
        break label472;
      }
      locala.rHi.setBackgroundResource(2131232749);
      break label472;
      label700:
      if (this.rGV.contains(localMediaItem))
      {
        locala.rHi.setCheckedNumber(this.rGV.indexOf(localMediaItem) + 1);
        locala.rHf.setBackgroundResource(2131099819);
        break label497;
      }
      locala.rHi.setChecked(false);
      locala.rHf.setBackgroundResource(2131100506);
      break label497;
      label768:
      if (this.rGV.contains(localMediaItem))
      {
        locala.rHi.setCheckedNumber(this.rGV.indexOf(localMediaItem) + 1);
        locala.rHf.setBackgroundResource(2131099819);
        break label497;
      }
      locala.rHi.setChecked(false);
      locala.rHf.setBackgroundResource(2131100506);
      break label497;
      label836:
      a.a.dX(locala.rHi);
    }
  }
  
  final void a(d paramd)
  {
    AppMethodBeat.i(111408);
    if (paramd == null)
    {
      ad.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
      AppMethodBeat.o(111408);
      return;
    }
    this.rGY.remove(paramd);
    this.rGY.add(paramd);
    AppMethodBeat.o(111408);
  }
  
  public final void ai(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(164792);
    this.rGU.clear();
    this.rGU.addAll(paramLinkedList);
    this.aql.notifyChanged();
    AppMethodBeat.o(164792);
  }
  
  public final void aj(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(111409);
    int i = getItemCount() - this.rGY.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.rGU.addAll(paramLinkedList.subList(i, j));
      aq(i + this.rGY.size(), getItemCount());
    }
    AppMethodBeat.o(111409);
  }
  
  public final ArrayList<String> cAm()
  {
    AppMethodBeat.i(111410);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.rGV.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).rBp);
    }
    AppMethodBeat.o(111410);
    return localArrayList;
  }
  
  public final ArrayList<GalleryItem.MediaItem> cAn()
  {
    return this.rGV;
  }
  
  public final ArrayList<GalleryItem.MediaItem> cAo()
  {
    return this.rGU;
  }
  
  public final int cAp()
  {
    AppMethodBeat.i(164794);
    int i = this.rGV.size();
    AppMethodBeat.o(164794);
    return i;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(200773);
    this.rGU.clear();
    AppMethodBeat.o(200773);
  }
  
  final void dM(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111411);
    this.rGV.clear();
    this.rGV.addAll(paramList);
    AppMethodBeat.o(111411);
  }
  
  final void g(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111420);
    if (this.rGV.contains(paramMediaItem))
    {
      int i = this.rGV.indexOf(paramMediaItem);
      ArrayList localArrayList = new ArrayList();
      while (i < this.rGV.size())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.rGV.get(i);
        int j = this.rGU.indexOf(localMediaItem);
        if (j != -1) {
          localArrayList.add(Integer.valueOf(j));
        }
        i += 1;
      }
      this.rGV.remove(paramMediaItem);
      paramMediaItem = localArrayList.iterator();
      while (paramMediaItem.hasNext()) {
        ck(((Integer)paramMediaItem.next()).intValue() + this.rGY.size());
      }
    }
    AppMethodBeat.o(111420);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111414);
    int i = this.rGY.size();
    int j = this.rGU.size();
    AppMethodBeat.o(111414);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(111415);
    if (paramInt < this.rGY.size())
    {
      paramInt = ((d)this.rGY.get(paramInt)).rHn;
      AppMethodBeat.o(111415);
      return paramInt;
    }
    AppMethodBeat.o(111415);
    return 1;
  }
  
  public final void setQueryType(int paramInt)
  {
    this.rBG = paramInt;
  }
  
  public final void setSelectLimitCount(int paramInt)
  {
    this.rGT = paramInt;
  }
  
  static final class b
    extends a.d
  {
    b()
    {
      this.rHn = 0;
    }
  }
  
  static abstract class d
  {
    int rHn;
  }
  
  public static abstract interface e
  {
    public abstract void ab(int paramInt1, int paramInt2, int paramInt3);
  }
  
  static abstract interface f
  {
    public abstract void a(int paramInt1, View paramView, int paramInt2);
  }
  
  public static final class g
    implements Runnable
  {
    private static HashMap<TextView, g> rHq;
    private boolean gqP;
    private WeakReference<TextView> pRN;
    private GalleryItem.VideoMediaItem rHo;
    private a rHp;
    
    static
    {
      AppMethodBeat.i(111406);
      rHq = new HashMap();
      AppMethodBeat.o(111406);
    }
    
    private g(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, a parama)
    {
      AppMethodBeat.i(111397);
      this.pRN = new WeakReference(paramTextView);
      this.rHo = paramVideoMediaItem;
      this.rHp = parama;
      AppMethodBeat.o(111397);
    }
    
    public static void a(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem)
    {
      AppMethodBeat.i(111399);
      if ((paramTextView == null) || (paramVideoMediaItem == null))
      {
        ad.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
        AppMethodBeat.o(111399);
        return;
      }
      if (rHq.containsKey(paramTextView))
      {
        localObject = (g)rHq.get(paramTextView);
        if (localObject != null)
        {
          if (((g)localObject).rHo.equals(paramVideoMediaItem))
          {
            AppMethodBeat.o(111399);
            return;
          }
          if (paramTextView.equals(((g)localObject).pRN.get()))
          {
            ((g)localObject).pRN = new WeakReference(null);
            ((g)localObject).gqP = true;
          }
        }
      }
      if (paramVideoMediaItem.hsU >= 0)
      {
        ad.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.hsU), paramVideoMediaItem });
        j(paramTextView, paramVideoMediaItem.hsU);
        rHq.remove(paramTextView);
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
          a.g.cAs().remove(paramAnonymousg);
          AppMethodBeat.o(111396);
        }
      });
      Object localObject = com.tencent.mm.plugin.gallery.model.e.czi().czz();
      if (localObject != null) {
        ((ap)localObject).post(paramVideoMediaItem);
      }
      for (;;)
      {
        rHq.put(paramTextView, paramVideoMediaItem);
        AppMethodBeat.o(111399);
        return;
        ad.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
      }
    }
    
    private static boolean abG(String paramString)
    {
      AppMethodBeat.i(173745);
      Object localObject1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwC, "");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(173745);
        return false;
      }
      ad.i("MicroMsg.AlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
      ad.i("MicroMsg.AlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
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
            long l = i.aMN(paramString);
            if ((j != 0) && (l > j * 1024 * 1024))
            {
              ad.i("MicroMsg.AlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
              AppMethodBeat.o(173745);
              return false;
            }
            int k = ((JSONObject)localObject2).optInt("androidVersion");
            if (-1 == k)
            {
              ad.i("MicroMsg.AlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(173745);
              return true;
            }
            if (Build.VERSION.SDK_INT == k)
            {
              ad.i("MicroMsg.AlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
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
        ad.printErrStackTrace("MicroMsg.AlbumAdapter", paramString, "parse json error", new Object[0]);
        AppMethodBeat.o(173745);
      }
    }
    
    public static void cAq()
    {
      AppMethodBeat.i(111398);
      rHq.clear();
      AppMethodBeat.o(111398);
    }
    
    private void cAr()
    {
      AppMethodBeat.i(173746);
      if (this.rHo == null)
      {
        AppMethodBeat.o(173746);
        return;
      }
      long l = bt.GC();
      try
      {
        String str = this.rHo.anX();
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        ad.d("MicroMsg.AlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
        localObject = new JSONObject((String)localObject);
        this.rHo.hsU = ((JSONObject)localObject).getInt("videoDuration");
        this.rHo.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
        this.rHo.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
        this.rHo.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
        this.rHo.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
        this.rHo.gta = SightVideoJNI.getMp4RotateVFS(str);
        this.rHo.hsV = 0;
        this.rHo.hsS = com.tencent.mm.plugin.gallery.a.b.abQ(((JSONObject)localObject).getString("videoType"));
        this.rHo.hsT = com.tencent.mm.plugin.gallery.a.b.abQ(((JSONObject)localObject).getString("audioType"));
        ad.d("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.rHo });
        ad.i("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
        AppMethodBeat.o(173746);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AlbumAdapter", localException, "loadItemFromSimpleMP4Info fail", new Object[0]);
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
      boolean bool = this.rHo.equals(((g)paramObject).rHo);
      AppMethodBeat.o(111401);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111402);
      int i = this.rHo.hashCode();
      AppMethodBeat.o(111402);
      return i;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111404);
      if (this.gqP)
      {
        AppMethodBeat.o(111404);
        return;
      }
      int i;
      label123:
      long l;
      c localc;
      String str1;
      if (abG(this.rHo.anX()))
      {
        cAr();
        if (this.gqP) {
          break label818;
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          if (this.rHp != null) {
            this.rHp.a(this, this.rHo.hsU);
          }
          AppMethodBeat.o(111404);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwh, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label123;
          }
          cAr();
          break;
        }
        l = bt.GC();
        localc = new c();
        str1 = this.rHo.anX();
      }
      for (;;)
      {
        Object localObject4;
        Object localObject7;
        Object localObject8;
        try
        {
          localc.px(str1);
          int j = localc.fGK.getTrackCount();
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
              ad.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
              localObject7 = localObject4;
              localObject8 = localObject1;
              break label825;
            }
            str2 = localMediaFormat.getString("mime");
            ad.d("MicroMsg.AlbumAdapter", "find video mime : %s", new Object[] { str2 });
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
          if (this.rHo != null)
          {
            if (localObject6 != null)
            {
              localObject1 = this.rHo;
              if (localObject6.containsKey("durationUs")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).hsU = i;
              localObject1 = this.rHo;
              if (localObject6.containsKey("height")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
              localObject1 = this.rHo;
              if (localObject6.containsKey("width")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
              localObject4 = this.rHo;
              if (localObject6.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).hsS = ((String)localObject1);
              localObject1 = this.rHo;
              if (localObject6.containsKey("bitrate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
              localObject1 = this.rHo;
              if (localObject6.containsKey("i-frame-interval")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).hsV = i;
              localObject1 = this.rHo;
              if (localObject6.containsKey("frame-rate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
              this.rHo.gta = SightVideoJNI.getMp4RotateVFS(str1);
            }
            if (localObject5 != null)
            {
              localObject4 = this.rHo;
              if (localObject5.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).hsT = ((String)localObject1);
            }
          }
          ad.d("MicroMsg.AlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.rHo });
          ad.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
          localc.fGK.release();
        }
        catch (Exception localException)
        {
          Object localObject1;
          MediaFormat localMediaFormat;
          String str2;
          ad.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
          localc.fGK.release();
          continue;
        }
        finally
        {
          localc.fGK.release();
          AppMethodBeat.o(111404);
        }
        ad.i("MicroMsg.AlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
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
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111395);
                if (a.g.a(a.g.this) != null) {
                  a.g.a(a.g.this).a(a.g.this, a.g.b(a.g.this).hsU);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a
 * JD-Core Version:    0.7.0.1
 */