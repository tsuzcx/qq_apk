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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private int jdO;
  private int jfZ;
  List<zg> lee;
  private int lev;
  private boolean lsi;
  private LinearLayout.LayoutParams lsj;
  private LinearLayout.LayoutParams lsk;
  a lsl;
  private Context mContext;
  private int mNumColumns;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(53841);
    this.mNumColumns = 3;
    this.lsi = true;
    this.mNumColumns = 3;
    this.mContext = paramContext;
    this.lev = com.tencent.mm.cb.a.gw(this.mContext);
    this.jfZ = this.mContext.getResources().getDimensionPixelSize(2131428362);
    this.jdO = ((int)((this.lev - this.mNumColumns * this.jfZ) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(53841);
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(53843);
    if (this.lee == null)
    {
      AppMethodBeat.o(53843);
      return 0;
    }
    int i = this.lee.size();
    AppMethodBeat.o(53843);
    return i;
  }
  
  public final void bt(List<zg> paramList)
  {
    AppMethodBeat.i(53842);
    if (this.lee == null) {
      this.lee = new ArrayList();
    }
    for (;;)
    {
      this.lee = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(53842);
      return;
      this.lee.clear();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(53844);
    if (this.lee == null)
    {
      AppMethodBeat.o(53844);
      return 0;
    }
    int i = (int)Math.ceil(this.lee.size() / this.mNumColumns);
    AppMethodBeat.o(53844);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(53846);
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject1 = w.hM(this.mContext).inflate(2130969413, null);
      localObject2 = new b();
      ((b)localObject2).leB = ((LinearLayout)((View)localObject1).findViewById(2131823588));
      ((b)localObject2).leB.setPadding(0, this.jdO, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.lsk = new LinearLayout.LayoutParams(-2, -2);
        this.lsk.leftMargin = this.jdO;
        this.lsj = new LinearLayout.LayoutParams(this.jfZ, this.jfZ);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.lsj;
        paramView.addView(paramView.ioq, paramViewGroup);
        paramView.addView(paramView.lsg, paramViewGroup);
        ((b)localObject2).leB.addView(paramView, i, this.lsk);
        i += 1;
      }
    }
    paramViewGroup = (b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.leB.getChildAt(i);
      String str;
      if (j <= getRealCount() - 1)
      {
        localObject2 = uA(j);
        if (localObject2 != null) {
          if (!bo.isNullOrNil(((zg)localObject2).ThumbUrl))
          {
            str = EmojiLogic.M(b.YP(), "", ((zg)localObject2).Md5) + "_cover";
            o.ahG().a(((zg)localObject2).ThumbUrl, ((PaddingImageView)localObject1).getImageView(), g.a(str, this.jfZ, new Object[0]));
            label342:
            ((PaddingImageView)localObject1).setClickable(true);
            ((PaddingImageView)localObject1).getImageViewFG().setBackgroundResource(2130838623);
            ((PaddingImageView)localObject1).setOnClickListener(new a.1(this, (PaddingImageView)localObject1, j));
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (!bo.isNullOrNil(((zg)localObject2).Url))
        {
          str = EmojiLogic.M(b.YP(), "", ((zg)localObject2).Md5);
          i.bld().a(((zg)localObject2).Url, ((PaddingImageView)localObject1).getImageView(), g.a(str, this.jfZ, new Object[0]));
          break label342;
        }
        ab.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label342;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        o.ahG().a("", ((PaddingImageView)localObject1).getImageView());
        ab.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        o.ahG().a("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
      }
    }
    AppMethodBeat.o(53846);
    return paramView;
  }
  
  public final zg uA(int paramInt)
  {
    AppMethodBeat.i(53845);
    if ((paramInt < 0) || (paramInt >= getRealCount()))
    {
      AppMethodBeat.o(53845);
      return null;
    }
    if (this.lee == null)
    {
      AppMethodBeat.o(53845);
      return null;
    }
    zg localzg = (zg)this.lee.get(paramInt);
    AppMethodBeat.o(53845);
    return localzg;
  }
  
  static abstract interface a
  {
    public abstract void uk(int paramInt);
  }
  
  final class b
  {
    LinearLayout leB;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */