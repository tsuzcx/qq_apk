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
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private Context mContext;
  private int mNumColumns;
  private int mvQ;
  private int myh;
  private int oXE;
  private int oXF;
  private int oXG;
  private boolean oXH;
  public a oXI;
  private HashMap<String, b> oXJ;
  public int oXz;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(108333);
    this.mNumColumns = 3;
    this.oXz = 0;
    this.mContext = paramContext;
    this.oXH = false;
    this.oXE = this.mContext.getResources().getDimensionPixelSize(2131165516);
    this.oXF = this.mContext.getResources().getDimensionPixelSize(2131165191);
    this.myh = this.mContext.getResources().getDimensionPixelSize(2131166219);
    this.oXG = com.tencent.mm.cc.a.ig(this.mContext);
    this.mvQ = ((int)((this.oXG - this.mNumColumns * this.myh) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(108333);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(108337);
    switch (paramInt)
    {
    default: 
      paramb.oel.setTextColor(this.mContext.getResources().getColor(2131100711));
      paramb.oel.setCompoundDrawables(null, null, null, null);
      ac.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(108337);
      return;
    }
    paramb.oel.setTextColor(this.mContext.getResources().getColor(2131100482));
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131690103);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.oel.setCompoundDrawables(null, null, localDrawable, null);
    AppMethodBeat.o(108337);
  }
  
  public final void Bh(int paramInt)
  {
    this.oXz = paramInt;
  }
  
  public final void Bi(int paramInt) {}
  
  public final void Bj(int paramInt) {}
  
  public final int Bl(int paramInt)
  {
    if (this.oXH) {
      return this.mNumColumns * paramInt;
    }
    return this.mNumColumns * paramInt + this.oXz;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final void cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(108338);
    if (this.oXJ == null)
    {
      ac.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    b localb = (b)this.oXJ.get(paramString);
    f localf = this.oXZ.XB(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.oXZ != null) && (localf.mStatus == -1))
    {
      ac.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.oXZ.oYi, this.oXZ.XF(paramString), this.oXZ.XD(paramString));
    }
    if (localb == null)
    {
      ac.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    a(localb, paramInt);
    AppMethodBeat.o(108338);
  }
  
  public final int cbE()
  {
    return this.oXz;
  }
  
  public final int cbF()
  {
    return 0;
  }
  
  public final int cbG()
  {
    return 0;
  }
  
  public final int cbI()
  {
    AppMethodBeat.i(108334);
    if (this.oXH)
    {
      if (this.oXz == 0)
      {
        AppMethodBeat.o(108334);
        return 0;
      }
      if ((this.oXz > 0) && (super.getCount() > this.oXz))
      {
        i = this.oXz;
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
    if (this.oXH)
    {
      if (this.oXz == 0)
      {
        AppMethodBeat.o(108335);
        return 0;
      }
      if ((this.oXz > 0) && (cbI() > this.oXz))
      {
        i = (int)Math.ceil(this.oXz / this.mNumColumns);
        AppMethodBeat.o(108335);
        return i;
      }
      i = (int)Math.ceil(cbI() / this.mNumColumns);
      AppMethodBeat.o(108335);
      return i;
    }
    int j = cbI();
    if (j <= this.oXz) {}
    for (;;)
    {
      AppMethodBeat.o(108335);
      return i;
      i = (int)Math.ceil((j - this.oXz) / this.mNumColumns);
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
        final int j = Bl(paramInt) + i;
        localObject1 = new b(this.mContext, paramView.oXM.getChildAt(i));
        ((b)localObject1).jja.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(108332);
            if (h.a(h.this) != null) {
              h.a(h.this).Bm(j);
            }
            AppMethodBeat.o(108332);
          }
        });
        Object localObject2 = Bk(j);
        if ((j <= cbI() - 1) && (localObject2 != null))
        {
          if (this.oXJ == null) {
            this.oXJ = new HashMap();
          }
          if (this.oXJ.containsValue(localObject1)) {
            this.oXJ.remove(((b)localObject1).oXi);
          }
          ((b)localObject1).oXi = a((f)localObject2);
          this.oXJ.put(a((f)localObject2), localObject1);
          ((b)localObject1).jja.setVisibility(0);
          ((b)localObject1).oel.setText(((f)localObject2).oYl.PackName);
          o.aFB().a(((f)localObject2).oYl.IconUrl, ((b)localObject1).oXj, e.fk(((f)localObject2).oYl.ProductID, ((f)localObject2).oYl.IconUrl));
          ((b)localObject1).oXk.setBackgroundResource(2131232029);
          ((b)localObject1).jja.setClickable(true);
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
          paramViewGroup.setPadding(0, 0, 0, this.oXF);
          paramView = new b();
          paramView.oXM = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.mvQ;
            localObject2 = new b(this.mContext);
            paramView.oXM.addView(((b)localObject2).jja, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          ((b)localObject1).jja.setClickable(false);
          ((b)localObject1).jja.setVisibility(8);
          ((b)localObject1).oXk.setBackgroundDrawable(null);
        }
      }
      AppMethodBeat.o(108336);
      return paramViewGroup;
    }
  }
  
  public static abstract interface a
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */