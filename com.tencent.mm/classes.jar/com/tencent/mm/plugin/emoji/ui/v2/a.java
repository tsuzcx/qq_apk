package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private int mNumColumns;
  private int sJu;
  List<aji> uAd;
  private int uAu;
  private int uAv;
  private boolean uQr;
  private LinearLayout.LayoutParams uQs;
  private LinearLayout.LayoutParams uQt;
  a uQu;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(109414);
    this.mNumColumns = 3;
    this.uQr = true;
    this.mNumColumns = 3;
    this.mContext = paramContext;
    this.uAv = com.tencent.mm.ci.a.kr(this.mContext);
    this.uAu = this.mContext.getResources().getDimensionPixelSize(i.c.emoji_grid_item_width_xhdpi);
    this.sJu = ((int)((this.uAv - this.mNumColumns * this.uAu) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(109414);
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(109416);
    if (this.uAd == null)
    {
      AppMethodBeat.o(109416);
      return 0;
    }
    int i = this.uAd.size();
    AppMethodBeat.o(109416);
    return i;
  }
  
  public final aji JN(int paramInt)
  {
    AppMethodBeat.i(109418);
    if ((paramInt < 0) || (paramInt >= getRealCount()))
    {
      AppMethodBeat.o(109418);
      return null;
    }
    if (this.uAd == null)
    {
      AppMethodBeat.o(109418);
      return null;
    }
    aji localaji = (aji)this.uAd.get(paramInt);
    AppMethodBeat.o(109418);
    return localaji;
  }
  
  public final void aa(List<aji> paramList)
  {
    AppMethodBeat.i(109415);
    if (this.uAd == null) {
      this.uAd = new ArrayList();
    }
    for (;;)
    {
      this.uAd = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(109415);
      return;
      this.uAd.clear();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(109417);
    if (this.uAd == null)
    {
      AppMethodBeat.o(109417);
      return 0;
    }
    int i = (int)Math.ceil(this.uAd.size() / this.mNumColumns);
    AppMethodBeat.o(109417);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(109419);
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject1 = ad.kS(this.mContext).inflate(i.f.emoji_store_v2_single_product_item_2, null);
      localObject2 = new b();
      ((b)localObject2).uAB = ((LinearLayout)((View)localObject1).findViewById(i.e.item_container));
      ((b)localObject2).uAB.setPadding(0, this.sJu, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.uQt = new LinearLayout.LayoutParams(-2, -2);
        this.uQt.leftMargin = this.sJu;
        this.uQs = new LinearLayout.LayoutParams(this.uAu, this.uAu);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.uQs;
        paramView.addView(paramView.cJr, paramViewGroup);
        paramView.addView(paramView.uQp, paramViewGroup);
        ((b)localObject2).uAB.addView(paramView, i, this.uQt);
        i += 1;
      }
    }
    paramViewGroup = (b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      final int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.uAB.getChildAt(i);
      Object localObject3;
      if (j <= getRealCount() - 1)
      {
        localObject2 = JN(j);
        if (localObject2 != null) {
          if (!Util.isNullOrNil(((aji)localObject2).ThumbUrl))
          {
            localObject3 = com.tencent.mm.emoji.e.a.jPz;
            localObject3 = com.tencent.mm.emoji.e.a.LQ(((aji)localObject2).Md5);
            q.bml().a(((aji)localObject2).ThumbUrl, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.uAu, new Object[0]));
            label326:
            ((PaddingImageView)localObject1).setClickable(true);
            ((PaddingImageView)localObject1).getImageViewFG().setBackgroundResource(i.d.emoji_grid_item_seq_fg);
            ((PaddingImageView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(109413);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/PreViewListGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                if (a.a(a.this) != null) {
                  a.a(a.this).Jx(j);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/PreViewListGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109413);
              }
            });
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (!Util.isNullOrNil(((aji)localObject2).Url))
        {
          localObject3 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", ((aji)localObject2).Md5);
          p.cUL().a(((aji)localObject2).Url, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.uAu, new Object[0]));
          break label326;
        }
        Log.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label326;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        q.bml().loadImage("", ((PaddingImageView)localObject1).getImageView());
        Log.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        q.bml().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
      }
    }
    AppMethodBeat.o(109419);
    return paramView;
  }
  
  static abstract interface a
  {
    public abstract void Jx(int paramInt);
  }
  
  final class b
  {
    LinearLayout uAB;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */