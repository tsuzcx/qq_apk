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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private Context mContext;
  private int mNumColumns;
  private int omS;
  private int opk;
  private int qXE;
  private int qXF;
  private int qXG;
  private boolean qXH;
  public a qXI;
  private HashMap<String, b> qXJ;
  public int qXz;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(108333);
    this.mNumColumns = 3;
    this.qXz = 0;
    this.mContext = paramContext;
    this.qXH = false;
    this.qXE = this.mContext.getResources().getDimensionPixelSize(2131165534);
    this.qXF = this.mContext.getResources().getDimensionPixelSize(2131165194);
    this.opk = this.mContext.getResources().getDimensionPixelSize(2131166262);
    this.qXG = com.tencent.mm.cb.a.jn(this.mContext);
    this.omS = ((int)((this.qXG - this.mNumColumns * this.opk) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(108333);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(108337);
    switch (paramInt)
    {
    default: 
      paramb.qbV.setTextColor(this.mContext.getResources().getColor(2131100904));
      paramb.qbV.setCompoundDrawables(null, null, null, null);
      Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(108337);
      return;
    }
    paramb.qbV.setTextColor(this.mContext.getResources().getColor(2131100584));
    Drawable localDrawable = this.mContext.getResources().getDrawable(2131690135);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.qbV.setCompoundDrawables(null, null, localDrawable, null);
    AppMethodBeat.o(108337);
  }
  
  public final void FK(int paramInt)
  {
    this.qXz = paramInt;
  }
  
  public final void FL(int paramInt) {}
  
  public final void FM(int paramInt) {}
  
  public final int FO(int paramInt)
  {
    if (this.qXH) {
      return this.mNumColumns * paramInt;
    }
    return this.mNumColumns * paramInt + this.qXz;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final int cFk()
  {
    return this.qXz;
  }
  
  public final int cFl()
  {
    return 0;
  }
  
  public final int cFm()
  {
    return 0;
  }
  
  public final int cFo()
  {
    AppMethodBeat.i(108334);
    if (this.qXH)
    {
      if (this.qXz == 0)
      {
        AppMethodBeat.o(108334);
        return 0;
      }
      if ((this.qXz > 0) && (super.getCount() > this.qXz))
      {
        i = this.qXz;
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
  
  public final void dc(String paramString, int paramInt)
  {
    AppMethodBeat.i(108338);
    if (this.qXJ == null)
    {
      Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    b localb = (b)this.qXJ.get(paramString);
    f localf = this.qXZ.amb(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.qXZ != null) && (localf.mStatus == -1))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.qXZ.qYi, this.qXZ.amf(paramString), this.qXZ.amd(paramString));
    }
    if (localb == null)
    {
      Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    a(localb, paramInt);
    AppMethodBeat.o(108338);
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(108335);
    if (this.qXH)
    {
      if (this.qXz == 0)
      {
        AppMethodBeat.o(108335);
        return 0;
      }
      if ((this.qXz > 0) && (cFo() > this.qXz))
      {
        i = (int)Math.ceil(this.qXz / this.mNumColumns);
        AppMethodBeat.o(108335);
        return i;
      }
      i = (int)Math.ceil(cFo() / this.mNumColumns);
      AppMethodBeat.o(108335);
      return i;
    }
    int j = cFo();
    if (j <= this.qXz) {}
    for (;;)
    {
      AppMethodBeat.o(108335);
      return i;
      i = (int)Math.ceil((j - this.qXz) / this.mNumColumns);
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
        final int j = FO(paramInt) + i;
        localObject1 = new b(this.mContext, paramView.qXM.getChildAt(i));
        ((b)localObject1).kHq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(108332);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (h.a(h.this) != null) {
              h.a(h.this).FP(j);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108332);
          }
        });
        Object localObject2 = FN(j);
        if ((j <= cFo() - 1) && (localObject2 != null))
        {
          if (this.qXJ == null) {
            this.qXJ = new HashMap();
          }
          if (this.qXJ.containsValue(localObject1)) {
            this.qXJ.remove(((b)localObject1).qXi);
          }
          ((b)localObject1).qXi = a((f)localObject2);
          this.qXJ.put(a((f)localObject2), localObject1);
          ((b)localObject1).kHq.setVisibility(0);
          ((b)localObject1).qbV.setText(((f)localObject2).qYl.PackName);
          q.bcV().a(((f)localObject2).qYl.IconUrl, ((b)localObject1).qXj, e.fQ(((f)localObject2).qYl.ProductID, ((f)localObject2).qYl.IconUrl));
          ((b)localObject1).qXk.setBackgroundResource(2131232120);
          ((b)localObject1).kHq.setClickable(true);
          a((b)localObject1, ((f)localObject2).mStatus);
        }
        for (;;)
        {
          i += 1;
          break;
          paramViewGroup = new LinearLayout(this.mContext);
          paramView = new AbsListView.LayoutParams(-1, -2);
          paramViewGroup.setBackgroundResource(2131235359);
          paramViewGroup.setOrientation(0);
          paramViewGroup.setLayoutParams(paramView);
          paramViewGroup.setPadding(0, 0, 0, this.qXF);
          paramView = new b();
          paramView.qXM = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.omS;
            localObject2 = new b(this.mContext);
            paramView.qXM.addView(((b)localObject2).kHq, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          ((b)localObject1).kHq.setClickable(false);
          ((b)localObject1).kHq.setVisibility(8);
          ((b)localObject1).qXk.setBackgroundDrawable(null);
        }
      }
      AppMethodBeat.o(108336);
      return paramViewGroup;
    }
  }
  
  public static abstract interface a
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */