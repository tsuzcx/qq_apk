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
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private int mNumColumns;
  private int mvQ;
  private int myh;
  private int oXG;
  List<ads> oXp;
  private boolean pmb;
  private LinearLayout.LayoutParams pmc;
  private LinearLayout.LayoutParams pmd;
  a pme;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(109414);
    this.mNumColumns = 3;
    this.pmb = true;
    this.mNumColumns = 3;
    this.mContext = paramContext;
    this.oXG = com.tencent.mm.cc.a.ig(this.mContext);
    this.myh = this.mContext.getResources().getDimensionPixelSize(2131166219);
    this.mvQ = ((int)((this.oXG - this.mNumColumns * this.myh) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(109414);
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(109416);
    if (this.oXp == null)
    {
      AppMethodBeat.o(109416);
      return 0;
    }
    int i = this.oXp.size();
    AppMethodBeat.o(109416);
    return i;
  }
  
  public final ads BB(int paramInt)
  {
    AppMethodBeat.i(109418);
    if ((paramInt < 0) || (paramInt >= getRealCount()))
    {
      AppMethodBeat.o(109418);
      return null;
    }
    if (this.oXp == null)
    {
      AppMethodBeat.o(109418);
      return null;
    }
    ads localads = (ads)this.oXp.get(paramInt);
    AppMethodBeat.o(109418);
    return localads;
  }
  
  public final void U(List<ads> paramList)
  {
    AppMethodBeat.i(109415);
    if (this.oXp == null) {
      this.oXp = new ArrayList();
    }
    for (;;)
    {
      this.oXp = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(109415);
      return;
      this.oXp.clear();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(109417);
    if (this.oXp == null)
    {
      AppMethodBeat.o(109417);
      return 0;
    }
    int i = (int)Math.ceil(this.oXp.size() / this.mNumColumns);
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
      localObject1 = z.jD(this.mContext).inflate(2131493825, null);
      localObject2 = new b();
      ((b)localObject2).oXM = ((LinearLayout)((View)localObject1).findViewById(2131301144));
      ((b)localObject2).oXM.setPadding(0, this.mvQ, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.pmd = new LinearLayout.LayoutParams(-2, -2);
        this.pmd.leftMargin = this.mvQ;
        this.pmc = new LinearLayout.LayoutParams(this.myh, this.myh);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.pmc;
        paramView.addView(paramView.lqK, paramViewGroup);
        paramView.addView(paramView.plZ, paramViewGroup);
        ((b)localObject2).oXM.addView(paramView, i, this.pmd);
        i += 1;
      }
    }
    paramViewGroup = (b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      final int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.oXM.getChildAt(i);
      Object localObject3;
      if (j <= getRealCount() - 1)
      {
        localObject2 = BB(j);
        if (localObject2 != null) {
          if (!bs.isNullOrNil(((ads)localObject2).ThumbUrl))
          {
            localObject3 = com.tencent.mm.emoji.d.a.fWM;
            localObject3 = com.tencent.mm.emoji.d.a.tl(((ads)localObject2).Md5);
            o.aFB().a(((ads)localObject2).ThumbUrl, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.myh, new Object[0]));
            label324:
            ((PaddingImageView)localObject1).setClickable(true);
            ((PaddingImageView)localObject1).getImageViewFG().setBackgroundResource(2131232034);
            ((PaddingImageView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(109413);
                if (a.a(a.this) != null) {
                  a.a(a.this).Bm(j);
                }
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
        if (!bs.isNullOrNil(((ads)localObject2).Url))
        {
          localObject3 = com.tencent.mm.emoji.d.a.fWM;
          localObject3 = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", ((ads)localObject2).Md5);
          k.cck().a(((ads)localObject2).Url, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.myh, new Object[0]));
          break label324;
        }
        ac.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label324;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        o.aFB().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ac.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        o.aFB().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
      }
    }
    AppMethodBeat.o(109419);
    return paramView;
  }
  
  static abstract interface a
  {
    public abstract void Bm(int paramInt);
  }
  
  final class b
  {
    LinearLayout oXM;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */