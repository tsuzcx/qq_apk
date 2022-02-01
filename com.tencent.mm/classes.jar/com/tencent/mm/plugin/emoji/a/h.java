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
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private Context mContext;
  private int mNumColumns;
  private int nbB;
  private int ndW;
  public int pHN;
  private int pHS;
  private int pHT;
  private int pHU;
  private boolean pHV;
  public a pHW;
  private HashMap<String, b> pHX;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(108333);
    this.mNumColumns = 3;
    this.pHN = 0;
    this.mContext = paramContext;
    this.pHV = false;
    this.pHS = this.mContext.getResources().getDimensionPixelSize(2131165516);
    this.pHT = this.mContext.getResources().getDimensionPixelSize(2131165191);
    this.ndW = this.mContext.getResources().getDimensionPixelSize(2131166219);
    this.pHU = com.tencent.mm.cb.a.iu(this.mContext);
    this.nbB = ((int)((this.pHU - this.mNumColumns * this.ndW) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(108333);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(108337);
    switch (paramInt)
    {
    default: 
      paramb.oOh.setTextColor(this.mContext.getResources().getColor(2131100711));
      paramb.oOh.setCompoundDrawables(null, null, null, null);
      ae.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(108337);
      return;
    }
    paramb.oOh.setTextColor(this.mContext.getResources().getColor(2131100482));
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131690103);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.oOh.setCompoundDrawables(null, null, localDrawable, null);
    AppMethodBeat.o(108337);
  }
  
  public final void Cb(int paramInt)
  {
    this.pHN = paramInt;
  }
  
  public final void Cc(int paramInt) {}
  
  public final void Cd(int paramInt) {}
  
  public final int Cf(int paramInt)
  {
    if (this.pHV) {
      return this.mNumColumns * paramInt;
    }
    return this.mNumColumns * paramInt + this.pHN;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final void cW(String paramString, int paramInt)
  {
    AppMethodBeat.i(108338);
    if (this.pHX == null)
    {
      ae.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    b localb = (b)this.pHX.get(paramString);
    f localf = this.pIn.abZ(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.pIn != null) && (localf.mStatus == -1))
    {
      ae.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.pIn.pIw, this.pIn.acd(paramString), this.pIn.acb(paramString));
    }
    if (localb == null)
    {
      ae.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    a(localb, paramInt);
    AppMethodBeat.o(108338);
  }
  
  public final int chA()
  {
    return 0;
  }
  
  public final int chC()
  {
    AppMethodBeat.i(108334);
    if (this.pHV)
    {
      if (this.pHN == 0)
      {
        AppMethodBeat.o(108334);
        return 0;
      }
      if ((this.pHN > 0) && (super.getCount() > this.pHN))
      {
        i = this.pHN;
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
  
  public final int chy()
  {
    return this.pHN;
  }
  
  public final int chz()
  {
    return 0;
  }
  
  public final a d(Context paramContext, View paramView)
  {
    return null;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(108335);
    if (this.pHV)
    {
      if (this.pHN == 0)
      {
        AppMethodBeat.o(108335);
        return 0;
      }
      if ((this.pHN > 0) && (chC() > this.pHN))
      {
        i = (int)Math.ceil(this.pHN / this.mNumColumns);
        AppMethodBeat.o(108335);
        return i;
      }
      i = (int)Math.ceil(chC() / this.mNumColumns);
      AppMethodBeat.o(108335);
      return i;
    }
    int j = chC();
    if (j <= this.pHN) {}
    for (;;)
    {
      AppMethodBeat.o(108335);
      return i;
      i = (int)Math.ceil((j - this.pHN) / this.mNumColumns);
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
        final int j = Cf(paramInt) + i;
        localObject1 = new b(this.mContext, paramView.pIa.getChildAt(i));
        ((b)localObject1).jFG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(108332);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (h.a(h.this) != null) {
              h.a(h.this).Cg(j);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108332);
          }
        });
        Object localObject2 = Ce(j);
        if ((j <= chC() - 1) && (localObject2 != null))
        {
          if (this.pHX == null) {
            this.pHX = new HashMap();
          }
          if (this.pHX.containsValue(localObject1)) {
            this.pHX.remove(((b)localObject1).pHw);
          }
          ((b)localObject1).pHw = a((f)localObject2);
          this.pHX.put(a((f)localObject2), localObject1);
          ((b)localObject1).jFG.setVisibility(0);
          ((b)localObject1).oOh.setText(((f)localObject2).pIz.PackName);
          q.aJb().a(((f)localObject2).pIz.IconUrl, ((b)localObject1).pHx, e.fy(((f)localObject2).pIz.ProductID, ((f)localObject2).pIz.IconUrl));
          ((b)localObject1).pHy.setBackgroundResource(2131232029);
          ((b)localObject1).jFG.setClickable(true);
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
          paramViewGroup.setPadding(0, 0, 0, this.pHT);
          paramView = new b();
          paramView.pIa = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.nbB;
            localObject2 = new b(this.mContext);
            paramView.pIa.addView(((b)localObject2).jFG, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          ((b)localObject1).jFG.setClickable(false);
          ((b)localObject1).jFG.setVisibility(8);
          ((b)localObject1).pHy.setBackgroundDrawable(null);
        }
      }
      AppMethodBeat.o(108336);
      return paramViewGroup;
    }
  }
  
  public static abstract interface a
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */