package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private c eiK;
  List<c> jfV;
  private boolean kFs;
  boolean kFv;
  acs mBU;
  Context mContext;
  g.b mCp;
  b mCq;
  boolean mCr;
  
  public f(Context paramContext, List<c> paramList, g.b paramb)
  {
    AppMethodBeat.i(74578);
    this.jfV = null;
    this.eiK = null;
    this.kFs = true;
    this.mBU = new acs();
    this.mCr = false;
    this.jfV = paramList;
    this.kFs = com.tencent.mm.kernel.g.RL().isSDCardAvailable();
    this.mContext = paramContext;
    this.mCp = paramb;
    paramList = new c.a();
    paramList.fHt = 1;
    paramList.eOf = true;
    paramList.eNT = (com.tencent.mm.cb.a.gw(paramContext) / 4);
    paramList.eNS = (com.tencent.mm.cb.a.gw(paramContext) / 4);
    paramList.eOa = 2131690341;
    this.eiK = paramList.ahY();
    AppMethodBeat.o(74578);
  }
  
  private static long io(long paramLong)
  {
    AppMethodBeat.i(74584);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.dNj().b(localDate);
    AppMethodBeat.o(74584);
    return paramLong;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(74580);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new f.a(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969534, paramViewGroup, false));
      AppMethodBeat.o(74580);
      return paramViewGroup;
    }
    paramViewGroup = new f.d(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969535, paramViewGroup, false));
    AppMethodBeat.o(74580);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(74582);
    if (!this.kFs)
    {
      ab.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.kFs) });
      AppMethodBeat.o(74582);
      return;
    }
    Object localObject2 = wb(paramInt);
    if (paramv.aky == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (io(wb(paramInt + 1).timeStamp) != io(((c)localObject2).timeStamp)))
      {
        ((f.a)paramv).gpp.setVisibility(8);
        AppMethodBeat.o(74582);
        return;
      }
      ((f.a)paramv).gpp.setVisibility(0);
      ((f.a)paramv).gpp.setText(in(((c)localObject2).timeStamp));
      if (this.kFv)
      {
        ((f.a)paramv).progressBar.setVisibility(0);
        AppMethodBeat.o(74582);
        return;
      }
      ((f.a)paramv).progressBar.setVisibility(8);
      AppMethodBeat.o(74582);
      return;
    }
    ((f.d)paramv).mCy.setTag(2131820604, Integer.valueOf(paramInt));
    ((f.d)paramv).mCD.setTag(Integer.valueOf(paramInt));
    o.ahG().a(((c)localObject2).imagePath, ((f.d)paramv).mCy, this.eiK);
    if (((c)localObject2).mCu)
    {
      ((f.d)paramv).mCz.setVisibility(0);
      ((f.d)paramv).kFj.setVisibility(0);
      ((f.d)paramv).kFj.setText(bo.bf(((c)localObject2).mCv.mCw, ""));
      ((f.d)paramv).mCy.getViewTreeObserver().addOnGlobalLayoutListener(new f.1(this, paramv));
      if (!this.mCr) {
        break label494;
      }
      ((f.d)paramv).mCD.setVisibility(0);
      ((f.d)paramv).mCC.setVisibility(0);
      Object localObject1 = e.a.bym();
      localObject2 = ((c)localObject2).mCt;
      if (localObject2 == null) {
        break label460;
      }
      localObject1 = ((e)localObject1).mCl.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject1).next()).cuZ.mBq.equals(((d)localObject2).cuZ.mBq));
    }
    label460:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label465;
      }
      ((f.d)paramv).mCA.setVisibility(0);
      ((f.d)paramv).mCC.setChecked(true);
      AppMethodBeat.o(74582);
      return;
      ((f.d)paramv).kFj.setVisibility(8);
      ((f.d)paramv).mCz.setVisibility(8);
      break;
    }
    label465:
    ((f.d)paramv).mCA.setVisibility(8);
    ((f.d)paramv).mCC.setChecked(false);
    AppMethodBeat.o(74582);
    return;
    label494:
    ((f.d)paramv).mCA.setVisibility(8);
    ((f.d)paramv).mCD.setVisibility(8);
    ((f.d)paramv).mCC.setVisibility(8);
    AppMethodBeat.o(74582);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(74581);
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof f.d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((f.d)paramv).mCC.setChecked(false);
        ((f.d)paramv).mCC.setVisibility(0);
        ((f.d)paramv).mCD.setVisibility(0);
        AppMethodBeat.o(74581);
        return;
      }
      ((f.d)paramv).mCC.setChecked(false);
      ((f.d)paramv).mCC.setVisibility(8);
      ((f.d)paramv).mCD.setVisibility(8);
      AppMethodBeat.o(74581);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(74581);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(74585);
    int i = this.jfV.size();
    AppMethodBeat.o(74585);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(74579);
    paramInt = wb(paramInt).type;
    AppMethodBeat.o(74579);
    return paramInt;
  }
  
  public final String in(long paramLong)
  {
    AppMethodBeat.i(74583);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.dNj().a((Date)localObject, this.mContext);
    AppMethodBeat.o(74583);
    return localObject;
  }
  
  public final c wb(int paramInt)
  {
    AppMethodBeat.i(74586);
    c localc = (c)this.jfV.get(paramInt);
    AppMethodBeat.o(74586);
    return localc;
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, f.c paramc, int paramInt);
  }
  
  public static final class c
  {
    public String imagePath;
    public d mCt;
    boolean mCu;
    public a mCv;
    public long timeStamp;
    public int type;
    
    public c(d paramd)
    {
      AppMethodBeat.i(74568);
      this.type = 0;
      this.mCv = new a();
      this.mCt = paramd;
      Object localObject;
      if ((paramd.byj()) || (paramd.byk())) {
        localObject = com.tencent.mm.plugin.fav.a.b.c(paramd.cuZ);
      }
      for (;;)
      {
        this.imagePath = ((String)localObject);
        this.timeStamp = paramd.mCk.field_updateTime;
        if ((paramd.byj()) || (paramd.byk()))
        {
          this.mCu = true;
          this.mCv.mCw = bo.mH(paramd.cuZ.duration);
        }
        AppMethodBeat.o(74568);
        return;
        String str = com.tencent.mm.plugin.fav.a.b.b(paramd.cuZ);
        localObject = str;
        if (!new com.tencent.mm.vfs.b(str).exists()) {
          localObject = com.tencent.mm.plugin.fav.a.b.c(paramd.cuZ);
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(74567);
      if ((this.mCt != null) && ((paramObject instanceof d)) && (paramObject != null))
      {
        bool = this.mCt.cuZ.mBq.equals(((d)paramObject).cuZ.mBq);
        AppMethodBeat.o(74567);
        return bool;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(74567);
      return bool;
    }
    
    final class a
    {
      public String mCw;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f
 * JD-Core Version:    0.7.0.1
 */