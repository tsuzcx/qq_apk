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
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class h
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private Context mContext;
  private int mNumColumns;
  private int vPy;
  public int xGQ;
  private int xGV;
  private int xGW;
  private int xGX;
  private int xGY;
  private boolean xGZ;
  public a xHa;
  private HashMap<String, b> xHb;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(108333);
    this.mNumColumns = 3;
    this.xGQ = 0;
    this.mContext = paramContext;
    this.xGZ = false;
    this.xGV = this.mContext.getResources().getDimensionPixelSize(h.c.NormalPadding);
    this.xGW = this.mContext.getResources().getDimensionPixelSize(h.c.BigPadding);
    this.xGX = this.mContext.getResources().getDimensionPixelSize(h.c.emoji_grid_item_width_xhdpi);
    this.xGY = com.tencent.mm.cd.a.ms(this.mContext);
    this.vPy = ((int)((this.xGY - this.mNumColumns * this.xGX) / (this.mNumColumns + 1.0F)));
    AppMethodBeat.o(108333);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(108337);
    switch (paramInt)
    {
    default: 
      paramb.wCq.setTextColor(getContext().getResources().getColor(com.tencent.mm.plugin.emoji.h.b.normal_text_color));
      paramb.wCq.setCompoundDrawables(null, null, null, null);
      Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(108337);
      return;
    }
    paramb.wCq.setTextColor(getContext().getResources().getColor(com.tencent.mm.plugin.emoji.h.b.half_alpha_black));
    Drawable localDrawable = getContext().getResources().getDrawable(h.g.emoji_download_finish);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramb.wCq.setCompoundDrawables(null, null, localDrawable, null);
    AppMethodBeat.o(108337);
  }
  
  public final void JZ(int paramInt)
  {
    this.xGQ = paramInt;
  }
  
  public final void Ka(int paramInt) {}
  
  public final void Kb(int paramInt) {}
  
  public final int Ke(int paramInt)
  {
    if (this.xGZ) {
      return this.mNumColumns * paramInt;
    }
    return this.mNumColumns * paramInt + this.xGQ;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final a d(Context paramContext, View paramView)
  {
    return null;
  }
  
  public final void dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(108338);
    if (this.xHb == null)
    {
      Log.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
      AppMethodBeat.o(108338);
      return;
    }
    b localb = (b)this.xHb.get(paramString);
    f localf = this.xHr.anN(paramString);
    if (localf != null) {
      a(localf, paramString, paramInt);
    }
    if ((localf != null) && (this.xHr != null) && (localf.mStatus == -1))
    {
      Log.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
      localf.a(this.xHr.xHB, this.xHr.anR(paramString), this.xHr.anP(paramString));
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
  
  public final int dyh()
  {
    return this.xGQ;
  }
  
  public final int dyi()
  {
    return 0;
  }
  
  public final int dyj()
  {
    return 0;
  }
  
  public final int dyl()
  {
    AppMethodBeat.i(108334);
    if (this.xGZ)
    {
      if (this.xGQ == 0)
      {
        AppMethodBeat.o(108334);
        return 0;
      }
      if ((this.xGQ > 0) && (super.getCount() > this.xGQ))
      {
        i = this.xGQ;
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
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(108335);
    if (this.xGZ)
    {
      if (this.xGQ == 0)
      {
        AppMethodBeat.o(108335);
        return 0;
      }
      if ((this.xGQ > 0) && (dyl() > this.xGQ))
      {
        i = (int)Math.ceil(this.xGQ / this.mNumColumns);
        AppMethodBeat.o(108335);
        return i;
      }
      i = (int)Math.ceil(dyl() / this.mNumColumns);
      AppMethodBeat.o(108335);
      return i;
    }
    int j = dyl();
    if (j <= this.xGQ) {}
    for (;;)
    {
      AppMethodBeat.o(108335);
      return i;
      i = (int)Math.ceil((j - this.xGQ) / this.mNumColumns);
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
        final int j = Ke(paramInt) + i;
        localObject1 = new b(this.mContext, paramView.xHe.getChildAt(i));
        ((b)localObject1).qAv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(108332);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (h.a(h.this) != null) {
              h.a(h.this).Kf(j);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreV2PersonAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108332);
          }
        });
        Object localObject2 = Kd(j);
        if ((j <= dyl() - 1) && (localObject2 != null))
        {
          if (this.xHb == null) {
            this.xHb = new HashMap();
          }
          if (this.xHb.containsValue(localObject1)) {
            this.xHb.remove(((b)localObject1).xGz);
          }
          ((b)localObject1).xGz = a((f)localObject2);
          this.xHb.put(a((f)localObject2), localObject1);
          ((b)localObject1).qAv.setVisibility(0);
          ((b)localObject1).wCq.setText(((f)localObject2).xHE.Zul);
          r.bKe().a(((f)localObject2).xHE.IHo, ((b)localObject1).xGA, e.gJ(((f)localObject2).xHE.ProductID, ((f)localObject2).xHE.IHo));
          ((b)localObject1).xGB.setBackgroundResource(h.d.emoji_grid_item_fg);
          ((b)localObject1).qAv.setClickable(true);
          a((b)localObject1, ((f)localObject2).mStatus);
        }
        for (;;)
        {
          i += 1;
          break;
          paramViewGroup = new LinearLayout(this.mContext);
          paramView = new AbsListView.LayoutParams(-1, -2);
          paramViewGroup.setBackgroundResource(h.d.transparent_background);
          paramViewGroup.setOrientation(0);
          paramViewGroup.setLayoutParams(paramView);
          paramViewGroup.setPadding(0, 0, 0, this.xGW);
          paramView = new b();
          paramView.xHe = paramViewGroup;
          paramViewGroup.setTag(paramView);
          i = 0;
          while (i < this.mNumColumns)
          {
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject1).leftMargin = this.vPy;
            localObject2 = new b(this.mContext, h.f.emoji_store_v2_person_item);
            paramView.xHe.addView(((b)localObject2).qAv, i, (ViewGroup.LayoutParams)localObject1);
            i += 1;
          }
          ((b)localObject1).qAv.setClickable(false);
          ((b)localObject1).qAv.setVisibility(8);
          ((b)localObject1).xGB.setBackgroundDrawable(null);
        }
      }
      AppMethodBeat.o(108336);
      return paramViewGroup;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Kf(int paramInt);
  }
  
  final class b
  {
    LinearLayout xHe;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.h
 * JD-Core Version:    0.7.0.1
 */