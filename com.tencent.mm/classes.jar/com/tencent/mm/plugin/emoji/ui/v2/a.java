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
import com.tencent.mm.emoji.f.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private int mNumColumns;
  private int vPy;
  List<amn> xGG;
  private int xGX;
  private int xGY;
  private boolean xZc;
  private LinearLayout.LayoutParams xZd;
  private LinearLayout.LayoutParams xZe;
  a xZf;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(109414);
    this.mNumColumns = 3;
    this.xZc = true;
    this.mNumColumns = 3;
    this.mContext = paramContext;
    this.xGY = com.tencent.mm.cd.a.ms(this.mContext);
    this.xGX = this.mContext.getResources().getDimensionPixelSize(h.c.emoji_grid_item_width_xhdpi);
    this.vPy = ((int)((this.xGY - this.mNumColumns * this.xGX) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(109414);
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(109416);
    if (this.xGG == null)
    {
      AppMethodBeat.o(109416);
      return 0;
    }
    int i = this.xGG.size();
    AppMethodBeat.o(109416);
    return i;
  }
  
  public final amn Ky(int paramInt)
  {
    AppMethodBeat.i(109418);
    if ((paramInt < 0) || (paramInt >= getRealCount()))
    {
      AppMethodBeat.o(109418);
      return null;
    }
    if (this.xGG == null)
    {
      AppMethodBeat.o(109418);
      return null;
    }
    amn localamn = (amn)this.xGG.get(paramInt);
    AppMethodBeat.o(109418);
    return localamn;
  }
  
  public final void bz(List<amn> paramList)
  {
    AppMethodBeat.i(109415);
    if (this.xGG == null) {
      this.xGG = new ArrayList();
    }
    for (;;)
    {
      this.xGG = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(109415);
      return;
      this.xGG.clear();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(109417);
    if (this.xGG == null)
    {
      AppMethodBeat.o(109417);
      return 0;
    }
    int i = (int)Math.ceil(this.xGG.size() / this.mNumColumns);
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
      localObject1 = af.mU(this.mContext).inflate(h.f.emoji_store_v2_single_product_item_2, null);
      localObject2 = new b();
      ((b)localObject2).xHe = ((LinearLayout)((View)localObject1).findViewById(h.e.item_container));
      ((b)localObject2).xHe.setPadding(0, this.vPy, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.xZe = new LinearLayout.LayoutParams(-2, -2);
        this.xZe.leftMargin = this.vPy;
        this.xZd = new LinearLayout.LayoutParams(this.xGX, this.xGX);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.xZd;
        paramView.addView(paramView.ewg, paramViewGroup);
        paramView.addView(paramView.xZa, paramViewGroup);
        ((b)localObject2).xHe.addView(paramView, i, this.xZe);
        i += 1;
      }
    }
    paramViewGroup = (b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      final int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.xHe.getChildAt(i);
      Object localObject3;
      if (j <= getRealCount() - 1)
      {
        localObject2 = Ky(j);
        if (localObject2 != null) {
          if (!Util.isNullOrNil(((amn)localObject2).ThumbUrl))
          {
            localObject3 = c.moq;
            localObject3 = c.Ew(((amn)localObject2).Md5);
            r.bKe().a(((amn)localObject2).ThumbUrl, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.xGX, new Object[0]));
            ((PaddingImageView)localObject1).setImportantForAccessibility(1);
            ((PaddingImageView)localObject1).setContentDescription(MMApplicationContext.getString(h.h.emoji_desc));
            label343:
            ((PaddingImageView)localObject1).setClickable(true);
            ((PaddingImageView)localObject1).getImageViewFG().setBackgroundResource(h.d.emoji_grid_item_seq_fg);
            ((PaddingImageView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(109413);
                b localb = new b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v2/PreViewListGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if (a.a(a.this) != null) {
                  a.a(a.this).Kf(j);
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
        if (!Util.isNullOrNil(((amn)localObject2).Url))
        {
          localObject3 = EmojiLogic.W(d.bzQ(), "", ((amn)localObject2).Md5);
          s.dAi().a(((amn)localObject2).Url, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.xGX, new Object[0]));
          ((PaddingImageView)localObject1).setImportantForAccessibility(1);
          ((PaddingImageView)localObject1).setContentDescription(MMApplicationContext.getString(h.h.emoji_desc));
          break label343;
        }
        ((PaddingImageView)localObject1).setImportantForAccessibility(4);
        Log.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label343;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        r.bKe().loadImage("", ((PaddingImageView)localObject1).getImageView());
        Log.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        r.bKe().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        ((PaddingImageView)localObject1).setImportantForAccessibility(4);
      }
    }
    AppMethodBeat.o(109419);
    return paramView;
  }
  
  static abstract interface a
  {
    public abstract void Kf(int paramInt);
  }
  
  final class b
  {
    LinearLayout xHe;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */