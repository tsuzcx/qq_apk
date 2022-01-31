package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.ui.n.b;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class f
  extends RecyclerView.a
{
  private c drd = null;
  List<f.c> heL = null;
  g.b khF;
  private boolean khG = true;
  boolean khH;
  b khI;
  boolean khJ = false;
  yl khf = new yl();
  Context mContext;
  
  public f(Context paramContext, List<f.c> paramList, g.b paramb)
  {
    this.heL = paramList;
    this.khG = g.DP().isSDCardAvailable();
    this.mContext = paramContext;
    this.khF = paramb;
    paramList = new c.a();
    paramList.erk = 1;
    paramList.erF = true;
    paramList.erm = (com.tencent.mm.cb.a.fj(paramContext) / 4);
    paramList.erl = (com.tencent.mm.cb.a.fj(paramContext) / 4);
    paramList.ery = n.b.pic_thum_bg_color;
    this.drd = paramList.OV();
  }
  
  private static long eM(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return com.tencent.mm.ui.gridviewheaders.a.cIz().b(localDate);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483647) {
      return new f.a(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(n.f.fav_gallery_date_item, paramViewGroup, false));
    }
    return new f.d(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(n.f.fav_image_gallary_grid_item, paramViewGroup, false));
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    if (!this.khG)
    {
      y.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.khG) });
      return;
    }
    Object localObject2 = rf(paramInt);
    if (paramv.aii == 2147483647)
    {
      if ((paramInt == getItemCount() - 1) || (eM(rf(paramInt + 1).timeStamp) != eM(((f.c)localObject2).timeStamp)))
      {
        ((f.a)paramv).eXs.setVisibility(8);
        return;
      }
      ((f.a)paramv).eXs.setVisibility(0);
      ((f.a)paramv).eXs.setText(eL(((f.c)localObject2).timeStamp));
      if (this.khH)
      {
        ((f.a)paramv).frw.setVisibility(0);
        return;
      }
      ((f.a)paramv).frw.setVisibility(8);
      return;
    }
    ((f.d)paramv).khQ.setTag(n.e.fav_filter_data_pos, Integer.valueOf(paramInt));
    ((f.d)paramv).khW.setTag(Integer.valueOf(paramInt));
    o.ON().a(((f.c)localObject2).imagePath, ((f.d)paramv).khQ, this.drd);
    if (((f.c)localObject2).khM)
    {
      ((f.d)paramv).khR.setVisibility(0);
      ((f.d)paramv).khS.setVisibility(0);
      ((f.d)paramv).khS.setText(bk.aM(((f.c)localObject2).khN.khO, ""));
      ((f.d)paramv).khQ.getViewTreeObserver().addOnGlobalLayoutListener(new f.1(this, paramv));
      if (!this.khJ) {
        break label460;
      }
      ((f.d)paramv).khW.setVisibility(0);
      ((f.d)paramv).khV.setVisibility(0);
      Object localObject1 = e.a.aRT();
      localObject2 = ((f.c)localObject2).khL;
      if (localObject2 == null) {
        break label431;
      }
      localObject1 = ((e)localObject1).khB.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((d)((Iterator)localObject1).next()).bNH.kgC.equals(((d)localObject2).bNH.kgC));
    }
    label431:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label436;
      }
      ((f.d)paramv).khT.setVisibility(0);
      ((f.d)paramv).khV.setChecked(true);
      return;
      ((f.d)paramv).khS.setVisibility(8);
      ((f.d)paramv).khR.setVisibility(8);
      break;
    }
    label436:
    ((f.d)paramv).khT.setVisibility(8);
    ((f.d)paramv).khV.setChecked(false);
    return;
    label460:
    ((f.d)paramv).khT.setVisibility(8);
    ((f.d)paramv).khW.setVisibility(8);
    ((f.d)paramv).khV.setVisibility(8);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && ((paramv instanceof f.d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((f.d)paramv).khV.setChecked(false);
        ((f.d)paramv).khV.setVisibility(0);
        ((f.d)paramv).khW.setVisibility(0);
        return;
      }
      ((f.d)paramv).khV.setChecked(false);
      ((f.d)paramv).khV.setVisibility(8);
      ((f.d)paramv).khW.setVisibility(8);
      return;
    }
    super.a(paramv, paramInt, paramList);
  }
  
  public final String eL(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return com.tencent.mm.ui.gridviewheaders.a.cIz().a(localDate, this.mContext);
  }
  
  public final int getItemCount()
  {
    return this.heL.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return rf(paramInt).type;
  }
  
  public final f.c rf(int paramInt)
  {
    return (f.c)this.heL.get(paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, f.c paramc, int paramInt);
  }
  
  final class c$a
  {
    public String khO;
    
    c$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f
 * JD-Core Version:    0.7.0.1
 */