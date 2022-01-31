package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private int hrb;
  private int hrq;
  public int iVj = 0;
  private int iVo;
  private int iVp;
  private int iVq;
  private boolean iVr;
  public h.a iVs;
  private HashMap<String, b> iVt;
  private Context mContext;
  private int mNumColumns = 3;
  
  public h(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.iVr = false;
    this.iVo = this.mContext.getResources().getDimensionPixelSize(f.c.NormalPadding);
    this.iVp = this.mContext.getResources().getDimensionPixelSize(f.c.BigPadding);
    this.hrq = this.mContext.getResources().getDimensionPixelSize(f.c.emoji_grid_item_width_xhdpi);
    this.iVq = com.tencent.mm.cb.a.fj(this.mContext);
    this.hrb = ((int)((this.iVq - this.mNumColumns * this.hrq) / (this.mNumColumns + 1.0F)));
  }
  
  private void a(b paramb, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramb.iuO.setTextColor(this.mContext.getResources().getColor(f.b.normal_text_color));
      paramb.iuO.setCompoundDrawables(null, null, null, null);
      y.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramb.iuO.setTextColor(this.mContext.getResources().getColor(f.b.half_alpha_black));
    Drawable localDrawable = this.mContext.getResources().getDrawable(f.g.emoji_download_finish);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.iuO.setCompoundDrawables(null, null, localDrawable, null);
  }
  
  public final int aGQ()
  {
    return this.iVj;
  }
  
  public final int aGR()
  {
    return 0;
  }
  
  public final int aGS()
  {
    return 0;
  }
  
  public final int aGV()
  {
    if (this.iVr)
    {
      if (this.iVj == 0) {
        return 0;
      }
      if ((this.iVj > 0) && (super.getCount() > this.iVj)) {
        return this.iVj;
      }
      return super.getCount();
    }
    return super.getCount();
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final void bt(String paramString, int paramInt)
  {
    if (this.iVt == null)
    {
      y.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      return;
    }
    b localb = (b)this.iVt.get(paramString);
    f localf = this.iVI.Al(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.iVI != null) && (localf.mStatus == -1))
    {
      y.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.iVI.iVR, this.iVI.Ap(paramString), this.iVI.An(paramString));
    }
    if (localb == null)
    {
      y.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
      return;
    }
    a(localb, paramInt);
  }
  
  protected final a c(Context paramContext, View paramView)
  {
    return null;
  }
  
  public final int getCount()
  {
    if (this.iVr) {
      if (this.iVj != 0) {}
    }
    int i;
    do
    {
      return 0;
      if ((this.iVj > 0) && (aGV() > this.iVj)) {
        return (int)Math.ceil(this.iVj / this.mNumColumns);
      }
      return (int)Math.ceil(aGV() / this.mNumColumns);
      i = aGV();
    } while (i <= this.iVj);
    return (int)Math.ceil((i - this.iVj) / this.mNumColumns);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject1 = (h.b)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      int i = 0;
      if (i < this.mNumColumns)
      {
        int j;
        label52:
        Object localObject2;
        if (this.iVr)
        {
          j = this.mNumColumns * paramInt;
          j += i;
          localObject1 = new b(this.mContext, paramView.iVw.getChildAt(i));
          ((b)localObject1).iUL.setOnClickListener(new h.1(this, (b)localObject1, j));
          localObject2 = pP(j);
          if ((j > aGV() - 1) || (localObject2 == null)) {
            break label457;
          }
          if (this.iVt == null) {
            this.iVt = new HashMap();
          }
          if (this.iVt.containsValue(localObject1)) {
            this.iVt.remove(((b)localObject1).iUT);
          }
          ((b)localObject1).iUT = a((f)localObject2);
          this.iVt.put(a((f)localObject2), localObject1);
          ((b)localObject1).iUL.setVisibility(0);
          ((b)localObject1).iuO.setText(((f)localObject2).iVU.sSc);
          o.ON().a(((f)localObject2).iVU.kSy, ((b)localObject1).iUU, e.cJ(((f)localObject2).iVU.syc, ((f)localObject2).iVU.kSy));
          ((b)localObject1).iUV.setBackgroundResource(f.d.emoji_grid_item_fg);
          ((b)localObject1).iUL.setClickable(true);
          a((b)localObject1, ((f)localObject2).mStatus);
        }
        for (;;)
        {
          i += 1;
          break;
          paramViewGroup = new LinearLayout(this.mContext);
          paramView = new AbsListView.LayoutParams(-1, -2);
          paramViewGroup.setBackgroundResource(f.d.transparent_background);
          paramViewGroup.setOrientation(0);
          paramViewGroup.setLayoutParams(paramView);
          paramViewGroup.setPadding(0, 0, 0, this.iVp);
          paramView = new h.b(this);
          paramView.iVw = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.hrb;
            localObject2 = new b(this.mContext, f.f.emoji_store_v2_person_item);
            paramView.iVw.addView(((b)localObject2).iUL, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          j = this.mNumColumns * paramInt + this.iVj;
          break label52;
          label457:
          ((b)localObject1).iUL.setClickable(false);
          ((b)localObject1).iUL.setVisibility(8);
          ((b)localObject1).iUV.setBackgroundDrawable(null);
        }
      }
      return paramViewGroup;
    }
  }
  
  public final void pM(int paramInt)
  {
    this.iVj = paramInt;
  }
  
  public final void pN(int paramInt) {}
  
  public final void pO(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */