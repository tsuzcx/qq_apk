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
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private int lTO;
  private int lWf;
  private Context mContext;
  private int mNumColumns;
  public int otY;
  private int oud;
  private int oue;
  private int ouf;
  private boolean oug;
  public a ouh;
  private HashMap<String, b> oui;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(108333);
    this.mNumColumns = 3;
    this.otY = 0;
    this.mContext = paramContext;
    this.oug = false;
    this.oud = this.mContext.getResources().getDimensionPixelSize(2131165516);
    this.oue = this.mContext.getResources().getDimensionPixelSize(2131165191);
    this.lWf = this.mContext.getResources().getDimensionPixelSize(2131166219);
    this.ouf = com.tencent.mm.cd.a.hV(this.mContext);
    this.lTO = ((int)((this.ouf - this.mNumColumns * this.lWf) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(108333);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(108337);
    switch (paramInt)
    {
    default: 
      paramb.nBl.setTextColor(this.mContext.getResources().getColor(2131100711));
      paramb.nBl.setCompoundDrawables(null, null, null, null);
      ad.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(108337);
      return;
    }
    paramb.nBl.setTextColor(this.mContext.getResources().getColor(2131100482));
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131690103);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.nBl.setCompoundDrawables(null, null, localDrawable, null);
    AppMethodBeat.o(108337);
  }
  
  public final void Ap(int paramInt)
  {
    this.otY = paramInt;
  }
  
  public final void Aq(int paramInt) {}
  
  public final void Ar(int paramInt) {}
  
  public final int At(int paramInt)
  {
    if (this.oug) {
      return this.mNumColumns * paramInt;
    }
    return this.mNumColumns * paramInt + this.otY;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final int bUr()
  {
    return this.otY;
  }
  
  public final int bUs()
  {
    return 0;
  }
  
  public final int bUt()
  {
    return 0;
  }
  
  public final int bUv()
  {
    AppMethodBeat.i(108334);
    if (this.oug)
    {
      if (this.otY == 0)
      {
        AppMethodBeat.o(108334);
        return 0;
      }
      if ((this.otY > 0) && (super.getCount() > this.otY))
      {
        i = this.otY;
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
  
  public final void cK(String paramString, int paramInt)
  {
    AppMethodBeat.i(108338);
    if (this.oui == null)
    {
      ad.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    b localb = (b)this.oui.get(paramString);
    f localf = this.ouz.Tp(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.ouz != null) && (localf.mStatus == -1))
    {
      ad.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.ouz.ouI, this.ouz.Tt(paramString), this.ouz.Tr(paramString));
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
  
  public final a d(Context paramContext, View paramView)
  {
    return null;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(108335);
    if (this.oug)
    {
      if (this.otY == 0)
      {
        AppMethodBeat.o(108335);
        return 0;
      }
      if ((this.otY > 0) && (bUv() > this.otY))
      {
        i = (int)Math.ceil(this.otY / this.mNumColumns);
        AppMethodBeat.o(108335);
        return i;
      }
      i = (int)Math.ceil(bUv() / this.mNumColumns);
      AppMethodBeat.o(108335);
      return i;
    }
    int j = bUv();
    if (j <= this.otY) {}
    for (;;)
    {
      AppMethodBeat.o(108335);
      return i;
      i = (int)Math.ceil((j - this.otY) / this.mNumColumns);
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
        final int j = At(paramInt) + i;
        localObject1 = new b(this.mContext, paramView.oul.getChildAt(i));
        ((b)localObject1).iIW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(108332);
            if (h.a(h.this) != null) {
              h.a(h.this).Au(j);
            }
            AppMethodBeat.o(108332);
          }
        });
        Object localObject2 = As(j);
        if ((j <= bUv() - 1) && (localObject2 != null))
        {
          if (this.oui == null) {
            this.oui = new HashMap();
          }
          if (this.oui.containsValue(localObject1)) {
            this.oui.remove(((b)localObject1).otH);
          }
          ((b)localObject1).otH = a((f)localObject2);
          this.oui.put(a((f)localObject2), localObject1);
          ((b)localObject1).iIW.setVisibility(0);
          ((b)localObject1).nBl.setText(((f)localObject2).ouL.PackName);
          o.ayJ().a(((f)localObject2).ouL.IconUrl, ((b)localObject1).otI, e.eX(((f)localObject2).ouL.ProductID, ((f)localObject2).ouL.IconUrl));
          ((b)localObject1).otJ.setBackgroundResource(2131232029);
          ((b)localObject1).iIW.setClickable(true);
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
          paramViewGroup.setPadding(0, 0, 0, this.oue);
          paramView = new b();
          paramView.oul = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.lTO;
            localObject2 = new b(this.mContext);
            paramView.oul.addView(((b)localObject2).iIW, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          ((b)localObject1).iIW.setClickable(false);
          ((b)localObject1).iIW.setVisibility(8);
          ((b)localObject1).otJ.setBackgroundDrawable(null);
        }
      }
      AppMethodBeat.o(108336);
      return paramViewGroup;
    }
  }
  
  public static abstract interface a
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */