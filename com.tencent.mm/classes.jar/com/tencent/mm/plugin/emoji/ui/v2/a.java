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
import com.tencent.mm.aw.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private int mNumColumns;
  private int mWv;
  private int mYP;
  List<agb> pAZ;
  private int pBq;
  private boolean pPB;
  private LinearLayout.LayoutParams pPC;
  private LinearLayout.LayoutParams pPD;
  a pPE;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(109414);
    this.mNumColumns = 3;
    this.pPB = true;
    this.mNumColumns = 3;
    this.mContext = paramContext;
    this.pBq = com.tencent.mm.cc.a.ip(this.mContext);
    this.mYP = this.mContext.getResources().getDimensionPixelSize(2131166219);
    this.mWv = ((int)((this.pBq - this.mNumColumns * this.mYP) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(109414);
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(109416);
    if (this.pAZ == null)
    {
      AppMethodBeat.o(109416);
      return 0;
    }
    int i = this.pAZ.size();
    AppMethodBeat.o(109416);
    return i;
  }
  
  public final agb Cj(int paramInt)
  {
    AppMethodBeat.i(109418);
    if ((paramInt < 0) || (paramInt >= getRealCount()))
    {
      AppMethodBeat.o(109418);
      return null;
    }
    if (this.pAZ == null)
    {
      AppMethodBeat.o(109418);
      return null;
    }
    agb localagb = (agb)this.pAZ.get(paramInt);
    AppMethodBeat.o(109418);
    return localagb;
  }
  
  public final void V(List<agb> paramList)
  {
    AppMethodBeat.i(109415);
    if (this.pAZ == null) {
      this.pAZ = new ArrayList();
    }
    for (;;)
    {
      this.pAZ = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(109415);
      return;
      this.pAZ.clear();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(109417);
    if (this.pAZ == null)
    {
      AppMethodBeat.o(109417);
      return 0;
    }
    int i = (int)Math.ceil(this.pAZ.size() / this.mNumColumns);
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
      localObject1 = z.jO(this.mContext).inflate(2131493825, null);
      localObject2 = new b();
      ((b)localObject2).pBw = ((LinearLayout)((View)localObject1).findViewById(2131301144));
      ((b)localObject2).pBw.setPadding(0, this.mWv, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.pPD = new LinearLayout.LayoutParams(-2, -2);
        this.pPD.leftMargin = this.mWv;
        this.pPC = new LinearLayout.LayoutParams(this.mYP, this.mYP);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.pPC;
        paramView.addView(paramView.cum, paramViewGroup);
        paramView.addView(paramView.pPz, paramViewGroup);
        ((b)localObject2).pBw.addView(paramView, i, this.pPD);
        i += 1;
      }
    }
    paramViewGroup = (b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      final int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.pBw.getChildAt(i);
      Object localObject3;
      if (j <= getRealCount() - 1)
      {
        localObject2 = Cj(j);
        if (localObject2 != null) {
          if (!bt.isNullOrNil(((agb)localObject2).ThumbUrl))
          {
            localObject3 = com.tencent.mm.emoji.d.a.gqn;
            localObject3 = com.tencent.mm.emoji.d.a.wb(((agb)localObject2).Md5);
            q.aIJ().a(((agb)localObject2).ThumbUrl, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.mYP, new Object[0]));
            label324:
            ((PaddingImageView)localObject1).setClickable(true);
            ((PaddingImageView)localObject1).getImageViewFG().setBackgroundResource(2131232034);
            ((PaddingImageView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(109413);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/PreViewListGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if (a.a(a.this) != null) {
                  a.a(a.this).BU(j);
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
        if (!bt.isNullOrNil(((agb)localObject2).Url))
        {
          localObject3 = com.tencent.mm.emoji.d.a.gqn;
          localObject3 = EmojiLogic.Q(com.tencent.mm.emoji.d.a.agp(), "", ((agb)localObject2).Md5);
          k.cgO().a(((agb)localObject2).Url, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.mYP, new Object[0]));
          break label324;
        }
        ad.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label324;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        q.aIJ().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ad.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        q.aIJ().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
      }
    }
    AppMethodBeat.o(109419);
    return paramView;
  }
  
  static abstract interface a
  {
    public abstract void BU(int paramInt);
  }
  
  final class b
  {
    LinearLayout pBw;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */