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
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private int lTO;
  private int lWf;
  private Context mContext;
  private int mNumColumns;
  private boolean oIB;
  private LinearLayout.LayoutParams oIC;
  private LinearLayout.LayoutParams oID;
  a oIE;
  List<act> otO;
  private int ouf;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(109414);
    this.mNumColumns = 3;
    this.oIB = true;
    this.mNumColumns = 3;
    this.mContext = paramContext;
    this.ouf = com.tencent.mm.cd.a.hV(this.mContext);
    this.lWf = this.mContext.getResources().getDimensionPixelSize(2131166219);
    this.lTO = ((int)((this.ouf - this.mNumColumns * this.lWf) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(109414);
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(109416);
    if (this.otO == null)
    {
      AppMethodBeat.o(109416);
      return 0;
    }
    int i = this.otO.size();
    AppMethodBeat.o(109416);
    return i;
  }
  
  public final act AJ(int paramInt)
  {
    AppMethodBeat.i(109418);
    if ((paramInt < 0) || (paramInt >= getRealCount()))
    {
      AppMethodBeat.o(109418);
      return null;
    }
    if (this.otO == null)
    {
      AppMethodBeat.o(109418);
      return null;
    }
    act localact = (act)this.otO.get(paramInt);
    AppMethodBeat.o(109418);
    return localact;
  }
  
  public final void ad(List<act> paramList)
  {
    AppMethodBeat.i(109415);
    if (this.otO == null) {
      this.otO = new ArrayList();
    }
    for (;;)
    {
      this.otO = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(109415);
      return;
      this.otO.clear();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(109417);
    if (this.otO == null)
    {
      AppMethodBeat.o(109417);
      return 0;
    }
    int i = (int)Math.ceil(this.otO.size() / this.mNumColumns);
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
      localObject1 = y.js(this.mContext).inflate(2131493825, null);
      localObject2 = new b();
      ((b)localObject2).oul = ((LinearLayout)((View)localObject1).findViewById(2131301144));
      ((b)localObject2).oul.setPadding(0, this.lTO, 0, 0);
      ((View)localObject1).setTag(localObject2);
      i = 0;
      for (;;)
      {
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i >= this.mNumColumns) {
          break;
        }
        this.oID = new LinearLayout.LayoutParams(-2, -2);
        this.oID.leftMargin = this.lTO;
        this.oIC = new LinearLayout.LayoutParams(this.lWf, this.lWf);
        paramView = new PaddingImageView(this.mContext);
        paramViewGroup = this.oIC;
        paramView.addView(paramView.kPl, paramViewGroup);
        paramView.addView(paramView.oIz, paramViewGroup);
        ((b)localObject2).oul.addView(paramView, i, this.oID);
        i += 1;
      }
    }
    paramViewGroup = (b)paramView.getTag();
    int i = 0;
    if (i < this.mNumColumns)
    {
      final int j = this.mNumColumns * paramInt + i;
      localObject1 = (PaddingImageView)paramViewGroup.oul.getChildAt(i);
      Object localObject3;
      if (j <= getRealCount() - 1)
      {
        localObject2 = AJ(j);
        if (localObject2 != null) {
          if (!bt.isNullOrNil(((act)localObject2).ThumbUrl))
          {
            localObject3 = com.tencent.mm.emoji.d.a.fSR;
            localObject3 = com.tencent.mm.emoji.d.a.pY(((act)localObject2).Md5);
            o.ayJ().a(((act)localObject2).ThumbUrl, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.lWf, new Object[0]));
            label324:
            ((PaddingImageView)localObject1).setClickable(true);
            ((PaddingImageView)localObject1).getImageViewFG().setBackgroundResource(2131232034);
            ((PaddingImageView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(109413);
                if (a.a(a.this) != null) {
                  a.a(a.this).Au(j);
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
        if (!bt.isNullOrNil(((act)localObject2).Url))
        {
          localObject3 = com.tencent.mm.emoji.d.a.fSR;
          localObject3 = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", ((act)localObject2).Md5);
          k.bUX().a(((act)localObject2).Url, ((PaddingImageView)localObject1).getImageView(), e.a((String)localObject3, this.lWf, new Object[0]));
          break label324;
        }
        ad.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
        break label324;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        o.ayJ().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ad.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
        continue;
        ((PaddingImageView)localObject1).getImageViewFG().setBackgroundDrawable(null);
        o.ayJ().loadImage("", ((PaddingImageView)localObject1).getImageView());
        ((PaddingImageView)localObject1).setClickable(false);
        ((PaddingImageView)localObject1).setOnClickListener(null);
      }
    }
    AppMethodBeat.o(109419);
    return paramView;
  }
  
  static abstract interface a
  {
    public abstract void Au(int paramInt);
  }
  
  final class b
  {
    LinearLayout oul;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */