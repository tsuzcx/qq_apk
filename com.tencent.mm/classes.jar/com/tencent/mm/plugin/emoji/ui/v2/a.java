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
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private int mNumColumns;
  private int nbB;
  private int ndW;
  List<agk> pHD;
  private int pHU;
  private boolean pWg;
  private LinearLayout.LayoutParams pWh;
  private LinearLayout.LayoutParams pWi;
  a pWj;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(109414);
    this.mNumColumns = 3;
    this.pWg = true;
    this.mNumColumns = 3;
    this.mContext = paramContext;
    this.pHU = com.tencent.mm.cb.a.iu(this.mContext);
    this.ndW = this.mContext.getResources().getDimensionPixelSize(2131166219);
    this.nbB = ((int)((this.pHU - this.mNumColumns * this.ndW) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(109414);
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(109416);
    if (this.pHD == null)
    {
      AppMethodBeat.o(109416);
      return 0;
    }
    int i = this.pHD.size();
    AppMethodBeat.o(109416);
    return i;
  }
  
  public final agk Cv(int paramInt)
  {
    AppMethodBeat.i(109418);
    if ((paramInt < 0) || (paramInt >= getRealCount()))
    {
      AppMethodBeat.o(109418);
      return null;
    }
    if (this.pHD == null)
    {
      AppMethodBeat.o(109418);
      return null;
    }
    agk localagk = (agk)this.pHD.get(paramInt);
    AppMethodBeat.o(109418);
    return localagk;
  }
  
  public final void V(List<agk> paramList)
  {
    AppMethodBeat.i(109415);
    if (this.pHD == null) {
      this.pHD = new ArrayList();
    }
    for (;;)
    {
      this.pHD = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(109415);
      return;
      this.pHD.clear();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(109417);
    if (this.pHD == null)
    {
      AppMethodBeat.o(109417);
      return 0;
    }
    int i = (int)Math.ceil(this.pHD.size() / this.mNumColumns);
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
      localObject1 = z.jV(this.mContext).inflate(2131493825, null);
      localObject2 = new b();
      ((b)localObject2).pIa = ((LinearLayout)((View)localObject1).findViewById(2131301144));
      ((b)localObject2).pIa.setPadding(0, this.nbB, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.pWi = new LinearLayout.LayoutParams(-2, -2);
        this.pWi.leftMargin = this.nbB;
        this.pWh = new LinearLayout.LayoutParams(this.ndW, this.ndW);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.pWh;
        paramView.addView(paramView.cuP, paramViewGroup);
        paramView.addView(paramView.pWe, paramViewGroup);
        ((b)localObject2).pIa.addView(paramView, i, this.pWi);
        i += 1;
      }
    }
    paramViewGroup = (b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      final int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.pIa.getChildAt(i);
      Object localObject3;
      if (j <= getRealCount() - 1)
      {
        localObject2 = Cv(j);
        if (localObject2 != null) {
          if (!bu.isNullOrNil(((agk)localObject2).ThumbUrl))
          {
            localObject3 = com.tencent.mm.emoji.d.a.gsI;
            localObject3 = com.tencent.mm.emoji.d.a.wI(((agk)localObject2).Md5);
            q.aJb().a(((agk)localObject2).ThumbUrl, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.ndW, new Object[0]));
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
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/PreViewListGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (a.a(a.this) != null) {
                  a.a(a.this).Cg(j);
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
        if (!bu.isNullOrNil(((agk)localObject2).Url))
        {
          localObject3 = com.tencent.mm.emoji.d.a.gsI;
          localObject3 = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", ((agk)localObject2).Md5);
          k.cie().a(((agk)localObject2).Url, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.ndW, new Object[0]));
          break label324;
        }
        ae.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label324;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        q.aJb().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ae.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        q.aJb().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
      }
    }
    AppMethodBeat.o(109419);
    return paramView;
  }
  
  static abstract interface a
  {
    public abstract void Cg(int paramInt);
  }
  
  final class b
  {
    LinearLayout pIa;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */