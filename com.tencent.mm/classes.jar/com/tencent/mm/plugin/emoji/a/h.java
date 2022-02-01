package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private Context mContext;
  private int mNumColumns;
  private int mWv;
  private int mYP;
  public int pBj;
  private int pBo;
  private int pBp;
  private int pBq;
  private boolean pBr;
  public a pBs;
  private HashMap<String, b> pBt;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(108333);
    this.mNumColumns = 3;
    this.pBj = 0;
    this.mContext = paramContext;
    this.pBr = false;
    this.pBo = this.mContext.getResources().getDimensionPixelSize(2131165516);
    this.pBp = this.mContext.getResources().getDimensionPixelSize(2131165191);
    this.mYP = this.mContext.getResources().getDimensionPixelSize(2131166219);
    this.pBq = com.tencent.mm.cc.a.ip(this.mContext);
    this.mWv = ((int)((this.pBq - this.mNumColumns * this.mYP) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(108333);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(108337);
    switch (paramInt)
    {
    default: 
      paramb.oHF.setTextColor(this.mContext.getResources().getColor(2131100711));
      paramb.oHF.setCompoundDrawables(null, null, null, null);
      ad.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(108337);
      return;
    }
    paramb.oHF.setTextColor(this.mContext.getResources().getColor(2131100482));
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131690103);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.oHF.setCompoundDrawables(null, null, localDrawable, null);
    AppMethodBeat.o(108337);
  }
  
  public final void BP(int paramInt)
  {
    this.pBj = paramInt;
  }
  
  public final void BQ(int paramInt) {}
  
  public final void BR(int paramInt) {}
  
  public final int BT(int paramInt)
  {
    if (this.pBr) {
      return this.mNumColumns * paramInt;
    }
    return this.mNumColumns * paramInt + this.pBj;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final void cS(String paramString, int paramInt)
  {
    AppMethodBeat.i(108338);
    if (this.pBt == null)
    {
      ad.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    b localb = (b)this.pBt.get(paramString);
    f localf = this.pBJ.abi(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.pBJ != null) && (localf.mStatus == -1))
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.pBJ.pBS, this.pBJ.abm(paramString), this.pBJ.abk(paramString));
    }
    if (localb == null)
    {
      ad.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    a(localb, paramInt);
    AppMethodBeat.o(108338);
  }
  
  public final int cgi()
  {
    return this.pBj;
  }
  
  public final int cgj()
  {
    return 0;
  }
  
  public final int cgk()
  {
    return 0;
  }
  
  public final int cgm()
  {
    AppMethodBeat.i(108334);
    if (this.pBr)
    {
      if (this.pBj == 0)
      {
        AppMethodBeat.o(108334);
        return 0;
      }
      if ((this.pBj > 0) && (super.getCount() > this.pBj))
      {
        i = this.pBj;
        AppMethodBeat.o(108334);
        return i;
      }
      i = super.getCount();
      AppMethodBeat.o(108334);
      return i;
    }
    int i = super.getCount();
    AppMethodBeat.o(108334);
    return i;
  }
  
  public final a d(Context paramContext, View paramView)
  {
    return null;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(108335);
    if (this.pBr)
    {
      if (this.pBj == 0)
      {
        AppMethodBeat.o(108335);
        return 0;
      }
      if ((this.pBj > 0) && (cgm() > this.pBj))
      {
        i = (int)Math.ceil(this.pBj / this.mNumColumns);
        AppMethodBeat.o(108335);
        return i;
      }
      i = (int)Math.ceil(cgm() / this.mNumColumns);
      AppMethodBeat.o(108335);
      return i;
    }
    int j = cgm();
    if (j <= this.pBj) {}
    for (;;)
    {
      AppMethodBeat.o(108335);
      return i;
      i = (int)Math.ceil((j - this.pBj) / this.mNumColumns);
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108336);
    Object localObject1;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject1 = (b)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      int i = 0;
      if (i < this.mNumColumns)
      {
        final int j = BT(paramInt) + i;
        localObject1 = new b(this.mContext, paramView.pBw.getChildAt(i));
        ((b)localObject1).jCI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(108332);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (h.a(h.this) != null) {
              h.a(h.this).BU(j);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108332);
          }
        });
        Object localObject2 = BS(j);
        if ((j <= cgm() - 1) && (localObject2 != null))
        {
          if (this.pBt == null) {
            this.pBt = new HashMap();
          }
          if (this.pBt.containsValue(localObject1)) {
            this.pBt.remove(((b)localObject1).pAS);
          }
          ((b)localObject1).pAS = a((f)localObject2);
          this.pBt.put(a((f)localObject2), localObject1);
          ((b)localObject1).jCI.setVisibility(0);
          ((b)localObject1).oHF.setText(((f)localObject2).pBV.PackName);
          q.aIJ().a(((f)localObject2).pBV.IconUrl, ((b)localObject1).pAT, e.fu(((f)localObject2).pBV.ProductID, ((f)localObject2).pBV.IconUrl));
          ((b)localObject1).pAU.setBackgroundResource(2131232029);
          ((b)localObject1).jCI.setClickable(true);
          a((b)localObject1, ((f)localObject2).mStatus);
        }
        for (;;)
        {
          i += 1;
          break;
          paramViewGroup = new LinearLayout(this.mContext);
          paramView = new AbsListView.LayoutParams(-1, -2);
          paramViewGroup.setBackgroundResource(2131234429);
          paramViewGroup.setOrientation(0);
          paramViewGroup.setLayoutParams(paramView);
          paramViewGroup.setPadding(0, 0, 0, this.pBp);
          paramView = new b();
          paramView.pBw = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.mWv;
            localObject2 = new b(this.mContext);
            paramView.pBw.addView(((b)localObject2).jCI, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          ((b)localObject1).jCI.setClickable(false);
          ((b)localObject1).jCI.setVisibility(8);
          ((b)localObject1).pAU.setBackgroundDrawable(null);
        }
      }
      AppMethodBeat.o(108336);
      return paramViewGroup;
    }
  }
  
  public static abstract interface a
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */