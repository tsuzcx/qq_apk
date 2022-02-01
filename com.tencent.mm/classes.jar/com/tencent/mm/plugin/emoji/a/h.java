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
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private Context mContext;
  private int mNumColumns;
  private int sJu;
  public int uAn;
  private int uAs;
  private int uAt;
  private int uAu;
  private int uAv;
  private boolean uAw;
  public a uAx;
  private HashMap<String, b> uAy;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(108333);
    this.mNumColumns = 3;
    this.uAn = 0;
    this.mContext = paramContext;
    this.uAw = false;
    this.uAs = this.mContext.getResources().getDimensionPixelSize(i.c.NormalPadding);
    this.uAt = this.mContext.getResources().getDimensionPixelSize(i.c.BigPadding);
    this.uAu = this.mContext.getResources().getDimensionPixelSize(i.c.emoji_grid_item_width_xhdpi);
    this.uAv = com.tencent.mm.ci.a.kr(this.mContext);
    this.sJu = ((int)((this.uAv - this.mNumColumns * this.uAu) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(108333);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(108337);
    switch (paramInt)
    {
    default: 
      paramb.txT.setTextColor(getContext().getResources().getColor(i.b.normal_text_color));
      paramb.txT.setCompoundDrawables(null, null, null, null);
      Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(108337);
      return;
    }
    paramb.txT.setTextColor(getContext().getResources().getColor(i.b.half_alpha_black));
    Drawable localDrawable = getContext().getResources().getDrawable(i.g.emoji_download_finish);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.txT.setCompoundDrawables(null, null, localDrawable, null);
    AppMethodBeat.o(108337);
  }
  
  public final void Js(int paramInt)
  {
    this.uAn = paramInt;
  }
  
  public final void Jt(int paramInt) {}
  
  public final void Ju(int paramInt) {}
  
  public final int Jw(int paramInt)
  {
    if (this.uAw) {
      return this.mNumColumns * paramInt;
    }
    return this.mNumColumns * paramInt + this.uAn;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final int cTM()
  {
    return this.uAn;
  }
  
  public final int cTN()
  {
    return 0;
  }
  
  public final int cTO()
  {
    return 0;
  }
  
  public final int cTQ()
  {
    AppMethodBeat.i(108334);
    if (this.uAw)
    {
      if (this.uAn == 0)
      {
        AppMethodBeat.o(108334);
        return 0;
      }
      if ((this.uAn > 0) && (super.getCount() > this.uAn))
      {
        i = this.uAn;
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
  
  public final void dw(String paramString, int paramInt)
  {
    AppMethodBeat.i(108338);
    if (this.uAy == null)
    {
      Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    b localb = (b)this.uAy.get(paramString);
    f localf = this.uAO.atV(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.uAO != null) && (localf.mStatus == -1))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.uAO.uAX, this.uAO.atZ(paramString), this.uAO.atX(paramString));
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
    if (this.uAw)
    {
      if (this.uAn == 0)
      {
        AppMethodBeat.o(108335);
        return 0;
      }
      if ((this.uAn > 0) && (cTQ() > this.uAn))
      {
        i = (int)Math.ceil(this.uAn / this.mNumColumns);
        AppMethodBeat.o(108335);
        return i;
      }
      i = (int)Math.ceil(cTQ() / this.mNumColumns);
      AppMethodBeat.o(108335);
      return i;
    }
    int j = cTQ();
    if (j <= this.uAn) {}
    for (;;)
    {
      AppMethodBeat.o(108335);
      return i;
      i = (int)Math.ceil((j - this.uAn) / this.mNumColumns);
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
        final int j = Jw(paramInt) + i;
        localObject1 = new b(this.mContext, paramView.uAB.getChildAt(i));
        ((b)localObject1).nBk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(108332);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (h.a(h.this) != null) {
              h.a(h.this).Jx(j);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108332);
          }
        });
        Object localObject2 = Jv(j);
        if ((j <= cTQ() - 1) && (localObject2 != null))
        {
          if (this.uAy == null) {
            this.uAy = new HashMap();
          }
          if (this.uAy.containsValue(localObject1)) {
            this.uAy.remove(((b)localObject1).uzW);
          }
          ((b)localObject1).uzW = a((f)localObject2);
          this.uAy.put(a((f)localObject2), localObject1);
          ((b)localObject1).nBk.setVisibility(0);
          ((b)localObject1).txT.setText(((f)localObject2).uBa.Suv);
          q.bml().a(((f)localObject2).uBa.CNj, ((b)localObject1).uzX, e.gd(((f)localObject2).uBa.ProductID, ((f)localObject2).uBa.CNj));
          ((b)localObject1).uzY.setBackgroundResource(i.d.emoji_grid_item_fg);
          ((b)localObject1).nBk.setClickable(true);
          a((b)localObject1, ((f)localObject2).mStatus);
        }
        for (;;)
        {
          i += 1;
          break;
          paramViewGroup = new LinearLayout(this.mContext);
          paramView = new AbsListView.LayoutParams(-1, -2);
          paramViewGroup.setBackgroundResource(i.d.transparent_background);
          paramViewGroup.setOrientation(0);
          paramViewGroup.setLayoutParams(paramView);
          paramViewGroup.setPadding(0, 0, 0, this.uAt);
          paramView = new b();
          paramView.uAB = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.sJu;
            localObject2 = new b(this.mContext, i.f.emoji_store_v2_person_item);
            paramView.uAB.addView(((b)localObject2).nBk, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          ((b)localObject1).nBk.setClickable(false);
          ((b)localObject1).nBk.setVisibility(8);
          ((b)localObject1).uzY.setBackgroundDrawable(null);
        }
      }
      AppMethodBeat.o(108336);
      return paramViewGroup;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Jx(int paramInt);
  }
  
  final class b
  {
    LinearLayout uAB;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */