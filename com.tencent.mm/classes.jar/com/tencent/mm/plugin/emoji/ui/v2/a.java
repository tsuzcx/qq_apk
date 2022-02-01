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
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private int mNumColumns;
  private int omS;
  private int opk;
  private int qXG;
  List<ait> qXp;
  private boolean rnf;
  private LinearLayout.LayoutParams rng;
  private LinearLayout.LayoutParams rnh;
  a rni;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(109414);
    this.mNumColumns = 3;
    this.rnf = true;
    this.mNumColumns = 3;
    this.mContext = paramContext;
    this.qXG = com.tencent.mm.cb.a.jn(this.mContext);
    this.opk = this.mContext.getResources().getDimensionPixelSize(2131166262);
    this.omS = ((int)((this.qXG - this.mNumColumns * this.opk) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(109414);
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(109416);
    if (this.qXp == null)
    {
      AppMethodBeat.o(109416);
      return 0;
    }
    int i = this.qXp.size();
    AppMethodBeat.o(109416);
    return i;
  }
  
  public final ait Gg(int paramInt)
  {
    AppMethodBeat.i(109418);
    if ((paramInt < 0) || (paramInt >= getRealCount()))
    {
      AppMethodBeat.o(109418);
      return null;
    }
    if (this.qXp == null)
    {
      AppMethodBeat.o(109418);
      return null;
    }
    ait localait = (ait)this.qXp.get(paramInt);
    AppMethodBeat.o(109418);
    return localait;
  }
  
  public final void ad(List<ait> paramList)
  {
    AppMethodBeat.i(109415);
    if (this.qXp == null) {
      this.qXp = new ArrayList();
    }
    for (;;)
    {
      this.qXp = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(109415);
      return;
      this.qXp.clear();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(109417);
    if (this.qXp == null)
    {
      AppMethodBeat.o(109417);
      return 0;
    }
    int i = (int)Math.ceil(this.qXp.size() / this.mNumColumns);
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
      localObject1 = aa.jQ(this.mContext).inflate(2131493979, null);
      localObject2 = new b();
      ((b)localObject2).qXM = ((LinearLayout)((View)localObject1).findViewById(2131302798));
      ((b)localObject2).qXM.setPadding(0, this.omS, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.rnh = new LinearLayout.LayoutParams(-2, -2);
        this.rnh.leftMargin = this.omS;
        this.rng = new LinearLayout.LayoutParams(this.opk, this.opk);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.rng;
        paramView.addView(paramView.cIN, paramViewGroup);
        paramView.addView(paramView.rnd, paramViewGroup);
        ((b)localObject2).qXM.addView(paramView, i, this.rnh);
        i += 1;
      }
    }
    paramViewGroup = (b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      final int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.qXM.getChildAt(i);
      Object localObject3;
      if (j <= getRealCount() - 1)
      {
        localObject2 = Gg(j);
        if (localObject2 != null) {
          if (!Util.isNullOrNil(((ait)localObject2).ThumbUrl))
          {
            localObject3 = com.tencent.mm.emoji.e.a.hdT;
            localObject3 = com.tencent.mm.emoji.e.a.EX(((ait)localObject2).Md5);
            q.bcV().a(((ait)localObject2).ThumbUrl, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.opk, new Object[0]));
            label324:
            ((PaddingImageView)localObject1).setClickable(true);
            ((PaddingImageView)localObject1).getImageViewFG().setBackgroundResource(2131232125);
            ((PaddingImageView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(109413);
                b localb = new b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/PreViewListGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (a.a(a.this) != null) {
                  a.a(a.this).FP(j);
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
        if (!Util.isNullOrNil(((ait)localObject2).Url))
        {
          localObject3 = com.tencent.mm.emoji.e.a.hdT;
          localObject3 = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", ((ait)localObject2).Md5);
          k.cGc().a(((ait)localObject2).Url, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.opk, new Object[0]));
          break label324;
        }
        Log.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label324;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        q.bcV().loadImage("", ((PaddingImageView)localObject1).getImageView());
        Log.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        q.bcV().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
      }
    }
    AppMethodBeat.o(109419);
    return paramView;
  }
  
  static abstract interface a
  {
    public abstract void FP(int paramInt);
  }
  
  final class b
  {
    LinearLayout qXM;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */