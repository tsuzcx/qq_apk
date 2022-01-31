package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends BaseAdapter
{
  private int hrb;
  private int hrq;
  List<ut> iVa;
  private int iVq;
  private boolean jjq = true;
  private LinearLayout.LayoutParams jjr;
  private LinearLayout.LayoutParams jjs;
  d.a jjt;
  private Context mContext;
  private int mNumColumns = 3;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
    this.iVq = com.tencent.mm.cb.a.fj(this.mContext);
    this.hrq = this.mContext.getResources().getDimensionPixelSize(f.c.emoji_grid_item_width_xhdpi);
    this.hrb = ((int)((this.iVq - this.mNumColumns * this.hrq) / (this.mNumColumns + 1.0F)));
  }
  
  private int getRealCount()
  {
    if (this.iVa == null) {
      return 0;
    }
    return this.iVa.size();
  }
  
  public final void bc(List<ut> paramList)
  {
    if (this.iVa == null) {
      this.iVa = new ArrayList();
    }
    for (;;)
    {
      this.iVa = paramList;
      notifyDataSetChanged();
      return;
      this.iVa.clear();
    }
  }
  
  public final int getCount()
  {
    if (this.iVa == null) {
      return 0;
    }
    return (int)Math.ceil(this.iVa.size() / this.mNumColumns);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject1 = com.tencent.mm.ui.y.gt(this.mContext).inflate(f.f.emoji_store_v2_single_product_item_2, null);
      localObject2 = new d.b(this);
      ((d.b)localObject2).iVw = ((LinearLayout)((View)localObject1).findViewById(f.e.item_container));
      ((d.b)localObject2).iVw.setPadding(0, this.hrb, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.jjs = new LinearLayout.LayoutParams(-2, -2);
        this.jjs.leftMargin = this.hrb;
        this.jjr = new LinearLayout.LayoutParams(this.hrq, this.hrq);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.jjr;
        paramView.addView(paramView.jjn, paramViewGroup);
        paramView.addView(paramView.jjo, paramViewGroup);
        ((d.b)localObject2).iVw.addView(paramView, i, this.jjs);
        i += 1;
      }
    }
    paramViewGroup = (d.b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.iVw.getChildAt(i);
      String str1;
      com.tencent.mm.as.a.a locala;
      String str2;
      ImageView localImageView;
      if (j <= getRealCount() - 1)
      {
        localObject2 = qf(j);
        if (localObject2 != null) {
          if (!bk.bl(((ut)localObject2).mQp))
          {
            str1 = EmojiLogic.J(b.FL(), "", ((ut)localObject2).jnU) + "_cover";
            locala = o.ON();
            str2 = ((ut)localObject2).mQp;
            localImageView = ((PaddingImageView)localObject1).getImageView();
            localObject2 = ((ut)localObject2).mQp;
            locala.a(str2, localImageView, e.a(str1, this.hrq, new Object[0]));
            label358:
            ((PaddingImageView)localObject1).setClickable(true);
            ((PaddingImageView)localObject1).getImageViewFG().setBackgroundResource(f.d.emoji_grid_item_seq_fg);
            ((PaddingImageView)localObject1).setOnClickListener(new d.1(this, (PaddingImageView)localObject1, j));
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (!bk.bl(((ut)localObject2).kSC))
        {
          str1 = EmojiLogic.J(b.FL(), "", ((ut)localObject2).jnU);
          locala = i.aHr();
          str2 = ((ut)localObject2).kSC;
          localImageView = ((PaddingImageView)localObject1).getImageView();
          localObject2 = ((ut)localObject2).kSC;
          locala.a(str2, localImageView, e.a(str1, this.hrq, new Object[0]));
          break label358;
        }
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label358;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        o.ON().a("", ((PaddingImageView)localObject1).getImageView());
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        o.ON().a("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
      }
    }
    return paramView;
  }
  
  public final ut qf(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getRealCount())) {}
    while (this.iVa == null) {
      return null;
    }
    return (ut)this.iVa.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.d
 * JD-Core Version:    0.7.0.1
 */