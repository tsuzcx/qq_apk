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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private int jdO;
  private int jfZ;
  public int leo;
  private int let;
  private int leu;
  private int lev;
  private boolean lew;
  public h.a lex;
  private HashMap<String, b> ley;
  private Context mContext;
  private int mNumColumns;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(52757);
    this.mNumColumns = 3;
    this.leo = 0;
    this.mContext = paramContext;
    this.lew = false;
    this.let = this.mContext.getResources().getDimensionPixelSize(2131427808);
    this.leu = this.mContext.getResources().getDimensionPixelSize(2131427500);
    this.jfZ = this.mContext.getResources().getDimensionPixelSize(2131428362);
    this.lev = com.tencent.mm.cb.a.gw(this.mContext);
    this.jdO = ((int)((this.lev - this.mNumColumns * this.jfZ) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(52757);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(52761);
    switch (paramInt)
    {
    default: 
      paramb.kvS.setTextColor(this.mContext.getResources().getColor(2131690322));
      paramb.kvS.setCompoundDrawables(null, null, null, null);
      ab.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(52761);
      return;
    }
    paramb.kvS.setTextColor(this.mContext.getResources().getColor(2131690159));
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131231262);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.kvS.setCompoundDrawables(null, null, localDrawable, null);
    AppMethodBeat.o(52761);
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final void bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(52762);
    if (this.ley == null)
    {
      ab.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      AppMethodBeat.o(52762);
      return;
    }
    b localb = (b)this.ley.get(paramString);
    f localf = this.leO.Kj(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.leO != null) && (localf.mStatus == -1))
    {
      ab.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.leO.leX, this.leO.Kn(paramString), this.leO.Kl(paramString));
    }
    if (localb == null)
    {
      ab.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
      AppMethodBeat.o(52762);
      return;
    }
    a(localb, paramInt);
    AppMethodBeat.o(52762);
  }
  
  public final int bkC()
  {
    return this.leo;
  }
  
  public final int bkD()
  {
    return 0;
  }
  
  public final int bkE()
  {
    return 0;
  }
  
  public final int bkH()
  {
    AppMethodBeat.i(52758);
    if (this.lew)
    {
      if (this.leo == 0)
      {
        AppMethodBeat.o(52758);
        return 0;
      }
      if ((this.leo > 0) && (super.getCount() > this.leo))
      {
        i = this.leo;
        AppMethodBeat.o(52758);
        return i;
      }
      i = super.getCount();
      AppMethodBeat.o(52758);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(52758);
    return i;
  }
  
  public final a d(Context paramContext, View paramView)
  {
    return null;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(52759);
    if (this.lew)
    {
      if (this.leo == 0)
      {
        AppMethodBeat.o(52759);
        return 0;
      }
      if ((this.leo > 0) && (bkH() > this.leo))
      {
        i = (int)Math.ceil(this.leo / this.mNumColumns);
        AppMethodBeat.o(52759);
        return i;
      }
      i = (int)Math.ceil(bkH() / this.mNumColumns);
      AppMethodBeat.o(52759);
      return i;
    }
    int j = bkH();
    if (j <= this.leo) {}
    for (;;)
    {
      AppMethodBeat.o(52759);
      return i;
      i = (int)Math.ceil((j - this.leo) / this.mNumColumns);
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(52760);
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
        label57:
        Object localObject2;
        if (this.lew)
        {
          j = this.mNumColumns * paramInt;
          j += i;
          localObject1 = new b(this.mContext, paramView.leB.getChildAt(i));
          ((b)localObject1).ldP.setOnClickListener(new h.1(this, (b)localObject1, j));
          localObject2 = uj(j);
          if ((j > bkH() - 1) || (localObject2 == null)) {
            break label459;
          }
          if (this.ley == null) {
            this.ley = new HashMap();
          }
          if (this.ley.containsValue(localObject1)) {
            this.ley.remove(((b)localObject1).ldX);
          }
          ((b)localObject1).ldX = a((f)localObject2);
          this.ley.put(a((f)localObject2), localObject1);
          ((b)localObject1).ldP.setVisibility(0);
          ((b)localObject1).kvS.setText(((f)localObject2).lfa.PackName);
          o.ahG().a(((f)localObject2).lfa.IconUrl, ((b)localObject1).ldY, g.dK(((f)localObject2).lfa.ProductID, ((f)localObject2).lfa.IconUrl));
          ((b)localObject1).ldZ.setBackgroundResource(2130838618);
          ((b)localObject1).ldP.setClickable(true);
          a((b)localObject1, ((f)localObject2).mStatus);
        }
        for (;;)
        {
          i += 1;
          break;
          paramViewGroup = new LinearLayout(this.mContext);
          paramView = new AbsListView.LayoutParams(-1, -2);
          paramViewGroup.setBackgroundResource(2130840999);
          paramViewGroup.setOrientation(0);
          paramViewGroup.setLayoutParams(paramView);
          paramViewGroup.setPadding(0, 0, 0, this.leu);
          paramView = new h.b(this);
          paramView.leB = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.jdO;
            localObject2 = new b(this.mContext);
            paramView.leB.addView(((b)localObject2).ldP, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          j = this.mNumColumns * paramInt + this.leo;
          break label57;
          label459:
          ((b)localObject1).ldP.setClickable(false);
          ((b)localObject1).ldP.setVisibility(8);
          ((b)localObject1).ldZ.setBackgroundDrawable(null);
        }
      }
      AppMethodBeat.o(52760);
      return paramViewGroup;
    }
  }
  
  public final void ug(int paramInt)
  {
    this.leo = paramInt;
  }
  
  public final void uh(int paramInt) {}
  
  public final void ui(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */