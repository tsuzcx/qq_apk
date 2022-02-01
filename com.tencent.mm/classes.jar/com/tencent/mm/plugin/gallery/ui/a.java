package com.tencent.mm.plugin.gallery.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Rect;
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
import android.view.TouchDelegate;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  extends RecyclerView.a<RecyclerView.w>
{
  int jbG;
  private Context mContext;
  private View.OnClickListener mOnClickListener;
  private SimpleDateFormat oEa;
  int sKz;
  int sOI;
  ArrayList<GalleryItem.MediaItem> sOJ;
  ArrayList<GalleryItem.MediaItem> sOK;
  private e sOL;
  String sOM;
  LinkedList<d> sON;
  boolean sOO;
  private View.OnLongClickListener sOP;
  private View.OnClickListener sOQ;
  f sOR;
  
  public a(Context paramContext, e parame)
  {
    AppMethodBeat.i(111407);
    this.sOI = 9;
    this.sOJ = new ArrayList();
    this.sOK = new ArrayList();
    this.oEa = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.jbG = 10;
    this.sON = new LinkedList();
    this.sOO = false;
    this.sOP = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111387);
        paramAnonymousView = paramAnonymousView.getTag(2131301175);
        if ((paramAnonymousView instanceof Integer))
        {
          int i = ((Integer)paramAnonymousView).intValue();
          paramAnonymousView = a.this.FX(i);
          if (paramAnonymousView != null) {
            ((ClipboardManager)a.a(a.this).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("media info", paramAnonymousView.toString()));
          }
        }
        AppMethodBeat.o(111387);
        return true;
      }
    };
    this.sOQ = new View.OnClickListener()
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
        localObject = a.this.FX(k);
        if ((localObject == null) || (bs.isNullOrNil(((GalleryItem.MediaItem)localObject).sKh)))
        {
          ac.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
          a.this.cj(k);
          AppMethodBeat.o(111388);
          return;
        }
        ac.i("MicroMsg.AlbumAdapter", "click image path:" + ((GalleryItem.MediaItem)localObject).sKh);
        int j;
        if (a.b(a.this).contains(localObject))
        {
          a.b(a.this).indexOf(localObject);
          a.this.h((GalleryItem.MediaItem)localObject);
          j = 1;
          i = 0;
          if (i == 0)
          {
            if (a.g(a.this) == null) {
              break label909;
            }
            a.g(a.this).ac(a.this.sOK.size(), k, j);
            AppMethodBeat.o(111388);
          }
        }
        else
        {
          long l;
          if ((com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 3) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")) && (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().XY(((GalleryItem.MediaItem)localObject).sKh)))
          {
            l = i.aSp(((GalleryItem.MediaItem)localObject).sKh);
            com.tencent.mm.plugin.gallery.a.d.bi(13459, l + ",1,,0");
            com.tencent.mm.ui.base.h.cg(a.a(a.this), a.a(a.this).getString(2131759800));
            a.this.cj(k);
            AppMethodBeat.o(111388);
            return;
          }
          if (((a.c(a.this) == 2) || (a.c(a.this) == 3)) && ((localObject instanceof GalleryItem.VideoMediaItem)))
          {
            if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 25)
            {
              l = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVh, 300);
              if (((GalleryItem.VideoMediaItem)localObject).hTw < com.tencent.mm.modelcontrol.d.aDL().aDR().minDuration * 1000)
              {
                com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getResources().getString(2131759821, new Object[] { Integer.valueOf(com.tencent.mm.modelcontrol.d.aDL().aDR().minDuration) }), "", false, new DialogInterface.OnClickListener()
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
              if (((GalleryItem.VideoMediaItem)localObject).hTw > 1000L * l)
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
            if ((!bs.isNullOrNil(a.d(a.this))) && (a.d(a.this).equals("album_business_bubble_media_by_coordinate")) && (((GalleryItem.VideoMediaItem)localObject).hTw >= a.e(a.this) * 1000 + 500))
            {
              com.tencent.mm.ui.base.h.cg(a.a(a.this), a.a(a.this).getResources().getString(2131759822, new Object[] { Integer.valueOf(a.e(a.this)) }));
              a.this.cj(k);
              AppMethodBeat.o(111388);
              return;
            }
          }
          if (a.b(a.this).size() >= a.f(a.this)) {
            break label915;
          }
          a.b(a.this).add(localObject);
          a.b(a.this).size();
        }
        label909:
        label915:
        for (int i = 0;; i = 1)
        {
          a.this.cj(k);
          j = 0;
          break;
          if (a.c(a.this) == 1)
          {
            com.tencent.mm.ui.base.h.cg(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623950, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
            AppMethodBeat.o(111388);
            return;
          }
          if (a.c(a.this) == 2)
          {
            com.tencent.mm.ui.base.h.cg(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623952, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
            AppMethodBeat.o(111388);
            return;
          }
          com.tencent.mm.ui.base.h.cg(a.a(a.this), a.a(a.this).getResources().getQuantityString(2131623951, a.f(a.this), new Object[] { Integer.valueOf(a.f(a.this)) }));
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
    this.sOL = parame;
    while (i < 32)
    {
      paramContext = new GalleryItem.ImageMediaItem();
      this.sOJ.add(paramContext);
      i += 1;
    }
    this.arg.notifyChanged();
    AppMethodBeat.o(111407);
  }
  
  public final ArrayList<GalleryItem.MediaItem> FW(int paramInt)
  {
    AppMethodBeat.i(111413);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.sOJ.iterator();
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
  
  public final GalleryItem.MediaItem FX(int paramInt)
  {
    AppMethodBeat.i(111418);
    if (paramInt < this.sON.size())
    {
      ac.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    paramInt -= this.sON.size();
    if (paramInt >= this.sOJ.size())
    {
      ac.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[] { Integer.valueOf(this.sOJ.size()), Integer.valueOf(paramInt) });
      AppMethodBeat.o(111418);
      return null;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.sOJ.get(paramInt);
    AppMethodBeat.o(111418);
    return localMediaItem;
  }
  
  final String FY(int paramInt)
  {
    AppMethodBeat.i(111419);
    int i = paramInt;
    if (paramInt < this.sON.size())
    {
      ac.d("MicroMsg.AlbumAdapter", "header, old pos[%d].", new Object[] { Integer.valueOf(paramInt) });
      i = this.sON.size();
    }
    Object localObject = FX(i);
    if (localObject != null)
    {
      if (!bs.isNullOrNil(((GalleryItem.MediaItem)localObject).sKn))
      {
        localObject = ((GalleryItem.MediaItem)localObject).sKn;
        AppMethodBeat.o(111419);
        return localObject;
      }
      localObject = new Date(((GalleryItem.MediaItem)localObject).sKl);
      localObject = com.tencent.mm.ui.gridviewheaders.a.fsS().a((Date)localObject, this.mContext);
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
    while (i < this.sOK.size())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.sOK.get(i);
      int j = this.sOJ.indexOf(localMediaItem);
      if (j != -1) {
        paramb.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramb = paramb.iterator();
    while (paramb.hasNext()) {
      cj(((Integer)paramb.next()).intValue() + this.sON.size());
    }
    AppMethodBeat.o(111421);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(111417);
    if ((paramw instanceof c))
    {
      paramw.asD.setTag(2131301175, Integer.valueOf(paramInt));
      paramw.asD.setTag(2131301200, Integer.valueOf(0));
      paramw.asD.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(111417);
      return;
    }
    GalleryItem.MediaItem localMediaItem;
    a locala;
    if ((paramw instanceof a))
    {
      paramw.asD.setTag(2131301175, Integer.valueOf(paramInt));
      paramw.asD.setTag(2131301200, Integer.valueOf(1));
      paramw.asD.setOnClickListener(this.mOnClickListener);
      localMediaItem = FX(paramInt);
      if (localMediaItem == null)
      {
        ac.e("MicroMsg.AlbumAdapter", "get item failed");
        AppMethodBeat.o(111417);
        return;
      }
      String str1 = localMediaItem.auN();
      String str2 = localMediaItem.sKh;
      if ((bs.isNullOrNil(str1)) && (bs.isNullOrNil(str2)))
      {
        ac.e("MicroMsg.AlbumAdapter", "null or nil filepath, poi: %s.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(111417);
        return;
      }
      locala = (a)paramw;
      locala.sOX.setTag(2131301175, Integer.valueOf(paramInt));
      locala.sOX.setOnClickListener(this.sOQ);
      locala.sOV.setVisibility(0);
      locala.sOW.setVisibility(0);
      locala.sOY.setVisibility(0);
      if (2 != localMediaItem.getType()) {
        break label537;
      }
      locala.sOV.setImageResource(2131691361);
      g.a(locala.sOW, (GalleryItem.VideoMediaItem)localMediaItem);
      int i = this.sON.size();
      paramw = this.oEa.format(new Date(localMediaItem.sKl));
      paramw = paramInt - i + 1 + ", " + paramw;
      if (2 != localMediaItem.getType()) {
        break label641;
      }
      paramw = "视频 ".concat(String.valueOf(paramw));
      label358:
      locala.sFo.setContentDescription(paramw);
      ac.d("MicroMsg.AlbumAdapter", "thumbFilePath: %s | origFilePath: %s | contentDescription %s", new Object[] { str1, str2, paramw });
      h.a(locala.sFo, localMediaItem.getType(), str1, str2, localMediaItem.sKk, localMediaItem.sKl);
      locala.sOX.setVisibility(0);
      paramInt = com.tencent.mm.plugin.gallery.model.e.cMt().kxr;
      if ((paramInt != 0) && (5 != paramInt) && (10 != paramInt) && (11 != paramInt) && (24 != paramInt)) {
        break label655;
      }
      locala.sOX.setVisibility(4);
      label472:
      if (!this.sOO) {
        break label768;
      }
      if (localMediaItem.getType() != 2) {
        break label700;
      }
      locala.sOX.setVisibility(4);
      label497:
      if (locala.sOX.getVisibility() != 0) {
        break label836;
      }
      a.a(locala, locala.sOX);
    }
    for (;;)
    {
      locala.asD.setOnLongClickListener(this.sOP);
      AppMethodBeat.o(111417);
      return;
      label537:
      if (localMediaItem.mMimeType.equalsIgnoreCase("edit"))
      {
        locala.sOV.setImageResource(2131691030);
        locala.sOW.setVisibility(4);
        break;
      }
      if (localMediaItem.mMimeType.equalsIgnoreCase("image/gif"))
      {
        locala.sOV.setImageResource(2131232599);
        locala.sOW.setVisibility(4);
        break;
      }
      locala.sOV.setVisibility(4);
      locala.sOW.setVisibility(4);
      locala.sOY.setVisibility(4);
      break;
      label641:
      paramw = "图片".concat(String.valueOf(paramw));
      break label358;
      label655:
      if (15 == paramInt)
      {
        locala.sOX.setBackgroundResource(2131232750);
        break label472;
      }
      if (com.tencent.mm.plugin.gallery.model.e.cMt().kxr != 25) {
        break label472;
      }
      locala.sOX.setBackgroundResource(2131232749);
      break label472;
      label700:
      if (this.sOK.contains(localMediaItem))
      {
        locala.sOX.setCheckedNumber(this.sOK.indexOf(localMediaItem) + 1);
        locala.sOU.setBackgroundResource(2131099819);
        break label497;
      }
      locala.sOX.setChecked(false);
      locala.sOU.setBackgroundResource(2131100506);
      break label497;
      label768:
      if (this.sOK.contains(localMediaItem))
      {
        locala.sOX.setCheckedNumber(this.sOK.indexOf(localMediaItem) + 1);
        locala.sOU.setBackgroundResource(2131099819);
        break label497;
      }
      locala.sOX.setChecked(false);
      locala.sOU.setBackgroundResource(2131100506);
      break label497;
      label836:
      a.ef(locala.sOX);
    }
  }
  
  final void a(d paramd)
  {
    AppMethodBeat.i(111408);
    if (paramd == null)
    {
      ac.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
      AppMethodBeat.o(111408);
      return;
    }
    this.sON.remove(paramd);
    this.sON.add(paramd);
    AppMethodBeat.o(111408);
  }
  
  public final void ad(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(111412);
    ac.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", new Object[] { this.sOK });
    this.sOK.clear();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (String)paramArrayList.next();
        GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, (String)localObject, "", "");
        if (com.tencent.mm.plugin.gallery.model.e.cMv() != null)
        {
          int i = com.tencent.mm.plugin.gallery.model.e.cMv().indexOf(localMediaItem);
          if (i >= 0)
          {
            localObject = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.cMv().get(i);
            this.sOK.add(localObject);
          }
          else
          {
            ac.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
            if (((String)localObject).toLowerCase().endsWith("mp4")) {
              this.sOK.add(GalleryItem.MediaItem.a(2, 0L, (String)localObject, "", ""));
            } else {
              this.sOK.add(GalleryItem.MediaItem.a(1, 0L, (String)localObject, "", ""));
            }
          }
        }
      }
    }
    ac.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", new Object[] { this.sOK });
    AppMethodBeat.o(111412);
  }
  
  public final void ap(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(164792);
    this.sOJ.clear();
    this.sOJ.addAll(paramLinkedList);
    this.arg.notifyChanged();
    AppMethodBeat.o(164792);
  }
  
  public final void aq(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(111409);
    int i = getItemCount() - this.sON.size();
    int j = paramLinkedList.size();
    if (i < j)
    {
      this.sOJ.addAll(paramLinkedList.subList(i, j));
      aq(i + this.sON.size(), getItemCount());
    }
    AppMethodBeat.o(111409);
  }
  
  public final ArrayList<String> cNv()
  {
    AppMethodBeat.i(111410);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.sOK.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).sKh);
    }
    AppMethodBeat.o(111410);
    return localArrayList;
  }
  
  public final ArrayList<GalleryItem.MediaItem> cNw()
  {
    return this.sOK;
  }
  
  public final ArrayList<GalleryItem.MediaItem> cNx()
  {
    return this.sOJ;
  }
  
  public final int cNy()
  {
    AppMethodBeat.i(164794);
    int i = this.sOK.size();
    AppMethodBeat.o(164794);
    return i;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(210016);
    this.sOJ.clear();
    AppMethodBeat.o(210016);
  }
  
  final void dQ(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(111411);
    this.sOK.clear();
    this.sOK.addAll(paramList);
    AppMethodBeat.o(111411);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111414);
    int i = this.sON.size();
    int j = this.sOJ.size();
    AppMethodBeat.o(111414);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(111415);
    if (paramInt < this.sON.size())
    {
      paramInt = ((d)this.sON.get(paramInt)).sPc;
      AppMethodBeat.o(111415);
      return paramInt;
    }
    AppMethodBeat.o(111415);
    return 1;
  }
  
  final void h(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(111420);
    if (this.sOK.contains(paramMediaItem))
    {
      int i = this.sOK.indexOf(paramMediaItem);
      ArrayList localArrayList = new ArrayList();
      while (i < this.sOK.size())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.sOK.get(i);
        int j = this.sOJ.indexOf(localMediaItem);
        if (j != -1) {
          localArrayList.add(Integer.valueOf(j));
        }
        i += 1;
      }
      this.sOK.remove(paramMediaItem);
      paramMediaItem = localArrayList.iterator();
      while (paramMediaItem.hasNext()) {
        cj(((Integer)paramMediaItem.next()).intValue() + this.sON.size());
      }
    }
    AppMethodBeat.o(111420);
  }
  
  public final void setQueryType(int paramInt)
  {
    this.sKz = paramInt;
  }
  
  public final void setSelectLimitCount(int paramInt)
  {
    this.sOI = paramInt;
  }
  
  static final class a
    extends RecyclerView.w
  {
    ImageView sFo;
    ImageView sOU;
    ImageView sOV;
    TextView sOW;
    MMNumberCheckbox sOX;
    View sOY;
    
    a(View paramView)
    {
      super();
      AppMethodBeat.i(111391);
      this.sFo = ((ImageView)paramView.findViewById(2131302221));
      this.sOU = ((ImageView)paramView.findViewById(2131302212));
      this.sOV = ((ImageView)paramView.findViewById(2131306177));
      this.sOW = ((TextView)paramView.findViewById(2131306178));
      this.sOX = ((MMNumberCheckbox)paramView.findViewById(2131302204));
      this.sOY = paramView.findViewById(2131306176);
      AppMethodBeat.o(111391);
    }
  }
  
  static final class b
    extends a.d
  {
    b()
    {
      this.sPc = 0;
    }
  }
  
  static final class c
    extends RecyclerView.w
  {
    private TextView sPb;
    
    c(View paramView)
    {
      super();
      AppMethodBeat.i(111394);
      this.sPb = ((TextView)paramView.findViewById(2131302221));
      if ((com.tencent.mm.plugin.gallery.model.e.cMt().sKz == 2) || (com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 13))
      {
        this.sPb.setText(2131759820);
        AppMethodBeat.o(111394);
        return;
      }
      if (com.tencent.mm.plugin.gallery.model.e.cMt().sKz == 1) {
        this.sPb.setText(2131759819);
      }
      AppMethodBeat.o(111394);
    }
  }
  
  static abstract class d
  {
    int sPc;
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
    private static HashMap<TextView, g> sPf;
    private boolean gRx;
    private WeakReference<TextView> qAv;
    private GalleryItem.VideoMediaItem sPd;
    private a sPe;
    
    static
    {
      AppMethodBeat.i(111406);
      sPf = new HashMap();
      AppMethodBeat.o(111406);
    }
    
    private g(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem, a parama)
    {
      AppMethodBeat.i(111397);
      this.qAv = new WeakReference(paramTextView);
      this.sPd = paramVideoMediaItem;
      this.sPe = parama;
      AppMethodBeat.o(111397);
    }
    
    public static void a(TextView paramTextView, GalleryItem.VideoMediaItem paramVideoMediaItem)
    {
      AppMethodBeat.i(111399);
      if ((paramTextView == null) || (paramVideoMediaItem == null))
      {
        ac.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
        AppMethodBeat.o(111399);
        return;
      }
      if (sPf.containsKey(paramTextView))
      {
        localObject = (g)sPf.get(paramTextView);
        if (localObject != null)
        {
          if (((g)localObject).sPd.equals(paramVideoMediaItem))
          {
            AppMethodBeat.o(111399);
            return;
          }
          if (paramTextView.equals(((g)localObject).qAv.get()))
          {
            ((g)localObject).qAv = new WeakReference(null);
            ((g)localObject).gRx = true;
          }
        }
      }
      if (paramVideoMediaItem.hTw >= 0)
      {
        ac.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[] { Integer.valueOf(paramVideoMediaItem.hTw), paramVideoMediaItem });
        j(paramTextView, paramVideoMediaItem.hTw);
        sPf.remove(paramTextView);
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
          a.g.cNB().remove(paramAnonymousg);
          AppMethodBeat.o(111396);
        }
      });
      Object localObject = com.tencent.mm.plugin.gallery.model.e.cMu().cML();
      if (localObject != null) {
        ((ao)localObject).post(paramVideoMediaItem);
      }
      for (;;)
      {
        sPf.put(paramTextView, paramVideoMediaItem);
        AppMethodBeat.o(111399);
        return;
        ac.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
      }
    }
    
    private static boolean agy(String paramString)
    {
      AppMethodBeat.i(173745);
      Object localObject1 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaR, "");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AppMethodBeat.o(173745);
        return false;
      }
      ac.i("MicroMsg.AlbumAdapter", "devices configuration: %s", new Object[] { localObject1 });
      ac.i("MicroMsg.AlbumAdapter", "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
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
            long l = i.aSp(paramString);
            if ((j != 0) && (l > j * 1024 * 1024))
            {
              ac.i("MicroMsg.AlbumAdapter", "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
              AppMethodBeat.o(173745);
              return false;
            }
            int k = ((JSONObject)localObject2).optInt("androidVersion");
            if (-1 == k)
            {
              ac.i("MicroMsg.AlbumAdapter", "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, Build.MODEL });
              AppMethodBeat.o(173745);
              return true;
            }
            if (Build.VERSION.SDK_INT == k)
            {
              ac.i("MicroMsg.AlbumAdapter", "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
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
        ac.printErrStackTrace("MicroMsg.AlbumAdapter", paramString, "parse json error", new Object[0]);
        AppMethodBeat.o(173745);
      }
    }
    
    private void cNA()
    {
      AppMethodBeat.i(173746);
      if (this.sPd == null)
      {
        AppMethodBeat.o(173746);
        return;
      }
      long l = bs.Gn();
      try
      {
        String str = this.sPd.auN();
        Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(str);
        ac.d("MicroMsg.AlbumAdapter", "get simple mp4 info %s", new Object[] { localObject });
        localObject = new JSONObject((String)localObject);
        this.sPd.hTw = ((JSONObject)localObject).getInt("videoDuration");
        this.sPd.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
        this.sPd.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
        this.sPd.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
        this.sPd.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
        this.sPd.gTI = SightVideoJNI.getMp4RotateVFS(str);
        this.sPd.hTx = 0;
        this.sPd.hTu = com.tencent.mm.plugin.gallery.a.b.agI(((JSONObject)localObject).getString("videoType"));
        this.sPd.hTv = com.tencent.mm.plugin.gallery.a.b.agI(((JSONObject)localObject).getString("audioType"));
        ac.d("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info mediaItem: %s", new Object[] { this.sPd });
        ac.i("MicroMsg.AlbumAdapter", "loadItemFromSimpleMP4Info used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
        AppMethodBeat.o(173746);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AlbumAdapter", localException, "loadItemFromSimpleMP4Info fail", new Object[0]);
        }
      }
    }
    
    public static void cNz()
    {
      AppMethodBeat.i(111398);
      sPf.clear();
      AppMethodBeat.o(111398);
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
      boolean bool = this.sPd.equals(((g)paramObject).sPd);
      AppMethodBeat.o(111401);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111402);
      int i = this.sPd.hashCode();
      AppMethodBeat.o(111402);
      return i;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111404);
      if (this.gRx)
      {
        AppMethodBeat.o(111404);
        return;
      }
      int i;
      label123:
      long l;
      c localc;
      String str1;
      if (agy(this.sPd.auN()))
      {
        cNA();
        if (this.gRx) {
          break label818;
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          if (this.sPe != null) {
            this.sPe.a(this, this.sPd.hTw);
          }
          AppMethodBeat.o(111404);
        }
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qav, 0) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label123;
          }
          cNA();
          break;
        }
        l = bs.Gn();
        localc = new c();
        str1 = this.sPd.auN();
      }
      for (;;)
      {
        Object localObject4;
        Object localObject7;
        Object localObject8;
        try
        {
          localc.sI(str1);
          int j = localc.fKr.getTrackCount();
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
              ac.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
              localObject7 = localObject4;
              localObject8 = localObject1;
              break label825;
            }
            str2 = localMediaFormat.getString("mime");
            ac.d("MicroMsg.AlbumAdapter", "find video mime : %s", new Object[] { str2 });
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
          if (this.sPd != null)
          {
            if (localObject6 != null)
            {
              localObject1 = this.sPd;
              if (localObject6.containsKey("durationUs")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).hTw = i;
              localObject1 = this.sPd;
              if (localObject6.containsKey("height")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoHeight = i;
              localObject1 = this.sPd;
              if (localObject6.containsKey("width")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoWidth = i;
              localObject4 = this.sPd;
              if (localObject6.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).hTu = ((String)localObject1);
              localObject1 = this.sPd;
              if (localObject6.containsKey("bitrate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoBitRate = i;
              localObject1 = this.sPd;
              if (localObject6.containsKey("i-frame-interval")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).hTx = i;
              localObject1 = this.sPd;
              if (localObject6.containsKey("frame-rate")) {
                continue;
              }
              i = 0;
              ((GalleryItem.VideoMediaItem)localObject1).videoFrameRate = i;
              this.sPd.gTI = SightVideoJNI.getMp4RotateVFS(str1);
            }
            if (localObject5 != null)
            {
              localObject4 = this.sPd;
              if (localObject5.containsKey("mime")) {
                continue;
              }
              localObject1 = "";
              ((GalleryItem.VideoMediaItem)localObject4).hTv = ((String)localObject1);
            }
          }
          ac.d("MicroMsg.AlbumAdapter", "loadItemFromExtractor mediaItem: %s", new Object[] { this.sPd });
          ac.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", new Object[] { localObject6, str1 });
          localc.fKr.release();
        }
        catch (Exception localException)
        {
          Object localObject1;
          MediaFormat localMediaFormat;
          String str2;
          ac.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { str1, localException.getMessage() });
          localc.fKr.release();
          continue;
        }
        finally
        {
          localc.fKr.release();
          AppMethodBeat.o(111404);
        }
        ac.i("MicroMsg.AlbumAdapter", "loadItemFromExtractor used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
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
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111395);
                if (a.g.a(a.g.this) != null) {
                  a.g.a(a.g.this).a(a.g.this, a.g.b(a.g.this).hTw);
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