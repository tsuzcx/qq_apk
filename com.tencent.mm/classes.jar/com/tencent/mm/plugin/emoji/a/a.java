package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.r.a;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  public int mPosition;
  protected View qAv;
  protected TextView sUt;
  private View xFS;
  private final int xFT = h.f.emoji_list_item;
  private final int xFU = h.f.emoji_store_v2_grid_item;
  private final int xFV = h.f.emoji_store_v2_grid_item_main;
  private int[] xFW = { -1, -1 };
  private int xFX = -1;
  public f xFY;
  protected View xFZ;
  protected ImageView xGa;
  protected ImageView xGb;
  protected View xGc;
  protected TextView xGd;
  protected TextView xGe;
  protected ViewGroup xGf;
  protected TextView xGg;
  protected View xGh;
  protected ProgressBar xGi;
  protected ViewGroup xGj;
  protected View xGk;
  protected TextView xGl;
  protected ImageView xGm;
  protected View xGn;
  protected ProgressBar xGo;
  protected TextView xGp;
  protected TextView xGq;
  protected FrameLayout xGr;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.xGv);
  }
  
  private a(Context paramContext, View paramView, a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label483:
    int i;
    switch (2.xGu[parama.ordinal()])
    {
    default: 
      paramContext = JU(this.xFT);
      this.qAv = paramContext;
      if (paramContext != null)
      {
        this.xFS = paramContext;
        this.xFZ = this.xFS.findViewById(h.e.item_container);
        this.xGb = ((ImageView)this.xFS.findViewById(h.e.item_tip));
        this.xGa = ((ImageView)this.xFS.findViewById(h.e.item_icon));
        this.sUt = ((TextView)this.xFS.findViewById(h.e.item_name));
        this.xGc = this.xFS.findViewById(h.e.item_name_new_tip);
        this.xGd = ((TextView)this.xFS.findViewById(h.e.item_name_pack_type));
        this.xGe = ((TextView)this.xFS.findViewById(h.e.item_date));
        this.xGf = ((ViewGroup)this.xFS.findViewById(h.e.item_introduce_root));
        this.xGg = ((TextView)this.xFS.findViewById(h.e.item_introduce));
        this.xGh = this.xFS.findViewById(h.e.emoji_preview_info_tag);
        this.xGi = ((ProgressBar)this.xFS.findViewById(h.e.price_loading));
        this.xGk = this.xFS.findViewById(h.e.item_option);
        this.xGj = ((ViewGroup)this.xFS.findViewById(h.e.item_root));
        this.xGl = ((TextView)this.xFS.findViewById(h.e.item_state));
        this.xGm = ((ImageView)this.xFS.findViewById(h.e.item_state_image));
        this.xGn = this.xFS.findViewById(h.e.item_progress_bar);
        this.xGo = ((ProgressBar)this.xFS.findViewById(h.e.item_download_progress));
        this.xGp = ((TextView)this.xFS.findViewById(h.e.item_category));
        this.xGq = ((TextView)this.xFS.findViewById(h.e.item_new));
        this.xGr = ((FrameLayout)this.xFS.findViewById(h.e.item_list_content));
      }
      dxT();
      if (parama == a.xGv)
      {
        paramView = dxU();
        if ((paramView != null) && (this.xGa != null)) {
          break label552;
        }
        i = dxV();
        if ((this.xFS != null) && (i >= 0) && (this.xFX != i)) {
          break label632;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = JU(this.xFT);
      break;
      paramContext = JU(this.xFV);
      break;
      paramContext = JU(this.xFU);
      break;
      label552:
      if ((paramView.length != 2) || (paramView[0] < 0) || (paramView[1] < 0) || ((paramView[0] == this.xFW[0]) && (paramView[1] == this.xFW[1]))) {
        break label483;
      }
      parama = this.xGa.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.xGa.setLayoutParams(parama);
      this.xFW = paramView;
      break label483;
      label632:
      this.xFS.setMinimumHeight(i);
      if (this.xFZ != null) {
        this.xFZ.setMinimumHeight(i);
      }
    }
  }
  
  private View JU(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  private void dyd()
  {
    this.xGi.setVisibility(8);
    this.xGj.setBackgroundResource(h.d.btn_solid_green);
    this.xGj.setVisibility(0);
    this.xGk.setEnabled(true);
    this.xGl.setText("");
    if (this.xGn == null) {
      this.xGo.setVisibility(4);
    }
    for (;;)
    {
      this.xGl.setVisibility(0);
      this.xGl.setText(h.h.emoji_store_download);
      this.xGl.setTextColor(this.mContext.getResources().getColorStateList(h.b.white_text_color_selector));
      this.xGm.setVisibility(8);
      return;
      this.xGn.setVisibility(4);
    }
  }
  
  public final void JV(int paramInt)
  {
    this.xGa.setImageResource(paramInt);
  }
  
  public final void JW(int paramInt)
  {
    this.xGb.setVisibility(paramInt);
  }
  
  public final void JX(int paramInt)
  {
    this.xGb.setImageResource(paramInt);
  }
  
  public final void JY(int paramInt)
  {
    this.xGk.setVisibility(paramInt);
  }
  
  public final void a(final r.a parama)
  {
    if (this.xGk != null) {
      this.xGk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108290);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (a.this.a(parama, paramAnonymousView)) {
            a.this.b(parama, paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108290);
        }
      });
    }
  }
  
  protected boolean a(r.a parama, View paramView)
  {
    return true;
  }
  
  public final void anJ(String paramString)
  {
    this.xGe.setText(paramString);
  }
  
  public final void anK(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      this.xGf.setVisibility(8);
      this.xGg.setVisibility(8);
      return;
    }
    this.xGf.setVisibility(0);
    this.xGg.setVisibility(0);
    this.xGg.setText(paramString);
  }
  
  public final void anL(String paramString)
  {
    this.xGf.setVisibility(0);
    this.xGg.setVisibility(0);
    this.xGg.setText(paramString);
    this.xGh.setVisibility(0);
  }
  
  protected void b(r.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  protected abstract void dxT();
  
  protected abstract int[] dxU();
  
  protected abstract int dxV();
  
  public final ImageView dxW()
  {
    return this.xGa;
  }
  
  public final ImageView dxX()
  {
    return this.xGb;
  }
  
  public final void dxY()
  {
    this.xGe.setVisibility(8);
    this.xGg.setVisibility(8);
  }
  
  public final int dxZ()
  {
    if (this.xFY == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.xFY.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String dya()
  {
    if (this.xFY == null) {}
    while (this.xFY.xHE == null) {
      return null;
    }
    return String.valueOf(this.xFY.xHE.akkv);
  }
  
  protected abstract boolean dyb();
  
  protected final void dyc()
  {
    this.xGi.setVisibility(8);
    this.xGj.setVisibility(8);
    this.xGk.setEnabled(false);
    this.xGm.setVisibility(8);
    this.xGo.setVisibility(0);
    this.xGo.setProgress(getProgress());
    this.xGo.setContentDescription(String.format(MMApplicationContext.getString(h.h.emoji_download), new Object[] { Integer.valueOf(getProgress()) }));
    if (this.xGn == null)
    {
      this.xGo.setVisibility(0);
      return;
    }
    this.xGn.setVisibility(0);
  }
  
  public void dye()
  {
    if (this.xFY == null) {}
    do
    {
      do
      {
        return;
      } while (!dyb());
      this.xGl.setVisibility(8);
      this.xGl.setTextColor(this.mContext.getResources().getColorStateList(h.b.black_text_color_selector));
      switch (dxZ())
      {
      case -1: 
      case 1: 
      case 2: 
      case 5: 
      case 9: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        Log.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(dxZ()) });
        return;
      case 8: 
        this.xGi.setVisibility(8);
        this.xGj.setBackgroundDrawable(null);
        this.xGj.setVisibility(0);
        this.xGk.setEnabled(false);
        this.xGl.setVisibility(0);
        this.xGl.setText(h.h.emoji_store_expire);
        this.xGm.setVisibility(4);
        if (this.xGn == null)
        {
          this.xGo.setVisibility(4);
          return;
        }
        this.xGn.setVisibility(4);
        return;
      case -2: 
        this.xGi.setVisibility(8);
        this.xGj.setBackgroundDrawable(null);
        this.xGj.setVisibility(0);
        this.xGk.setEnabled(false);
        this.xGl.setVisibility(0);
        this.xGl.setText(h.h.emoji_store_not_available_for_buy);
        this.xGm.setVisibility(4);
        if (this.xGn == null)
        {
          this.xGo.setVisibility(4);
          return;
        }
        this.xGn.setVisibility(4);
        return;
      case 0: 
        dyd();
        return;
      case 6: 
        dyc();
        return;
      case 7: 
        if (this.xFY.xHJ)
        {
          Log.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
          this.xGi.setVisibility(8);
          this.xGj.setBackgroundResource(h.d.btn_solid_green);
          this.xGj.setVisibility(0);
          this.xGj.setTag(getProductId());
          this.xGk.setEnabled(true);
          this.xGl.setVisibility(0);
          this.xGl.setText(h.h.emoji_store_use);
          this.xGl.setTextColor(this.mContext.getResources().getColorStateList(h.b.white_text_color_selector));
          this.xGm.setVisibility(4);
          if (this.xGn == null)
          {
            this.xGo.setVisibility(4);
            return;
          }
          this.xGn.setVisibility(4);
          return;
        }
        if ((this.xFY.xHL) && (e.gO(this.xFY.xHE.akke, 64)))
        {
          this.xGj.setVisibility(0);
          this.xGj.setBackgroundResource(h.d.btn_solid_red);
          this.xGl.setVisibility(0);
          this.xGl.setText(h.h.emoji_store_reward);
          this.xGl.setTextColor(this.mContext.getResources().getColorStateList(h.b.white_text_color_selector));
          this.xGm.setVisibility(4);
          this.xGk.setEnabled(true);
          if (this.xGn == null)
          {
            this.xGo.setVisibility(4);
            return;
          }
          this.xGn.setVisibility(4);
          return;
        }
        this.xGi.setVisibility(8);
        this.xGj.setVisibility(0);
        this.xGj.setBackgroundResource(h.d.btn_solid_white);
        this.xGl.setVisibility(0);
        this.xGl.setText(h.h.emoji_store_downloaded);
        this.xGl.setTextColor(this.mContext.getResources().getColorStateList(h.b.black_text_color_disabled));
        this.xGm.setVisibility(4);
        this.xGk.setEnabled(false);
        if (this.xGn == null)
        {
          this.xGo.setVisibility(4);
          return;
        }
        this.xGn.setVisibility(4);
        return;
      case 3: 
        dyd();
        return;
      case 4: 
      case 12: 
        this.xGi.setVisibility(8);
        this.xGj.setBackgroundResource(h.d.btn_solid_white);
        this.xGj.setVisibility(0);
        if (this.xGn != null) {
          break label914;
        }
        this.xGo.setVisibility(4);
        this.xGk.setEnabled(true);
        this.xGm.setVisibility(4);
        this.xGl.setVisibility(0);
      }
    } while (this.xFY.xHE == null);
    if (com.tencent.mm.plugin.emoji.g.b.KK(this.xFY.xHE.akke))
    {
      this.xGl.setText(com.tencent.mm.plugin.emoji.g.b.c(this.mContext, this.xFY.xHE.akkv, ""));
      this.xGl.setContentDescription(String.format(MMApplicationContext.getString(h.h.emoji_wecoin_price_unit), new Object[] { Integer.valueOf(this.xFY.xHE.akkv) }));
    }
    for (;;)
    {
      this.xGl.setTextColor(this.mContext.getResources().getColorStateList(h.b.white_text_color_selector));
      this.xGj.setBackgroundResource(h.d.btn_solid_green);
      return;
      label914:
      this.xGn.setVisibility(4);
      break;
      this.xGl.setText(this.xFY.xHE.akkc);
      this.xGl.setContentDescription(String.format(MMApplicationContext.getString(h.h.emoji_price_unit), new Object[] { this.xGl.getText() }));
    }
    this.xGi.setVisibility(8);
    this.xGj.setBackgroundResource(h.d.btn_solid_white);
    this.xGj.setVisibility(0);
    this.xGl.setVisibility(0);
    this.xGl.setText(h.h.emoji_store_play);
    this.xGm.setVisibility(4);
    this.xGk.setEnabled(true);
    if (this.xGn == null)
    {
      this.xGo.setVisibility(4);
      return;
    }
    this.xGn.setVisibility(4);
    return;
    this.xGi.setVisibility(0);
    this.xGj.setBackgroundResource(h.d.btn_solid_white);
    this.xGj.setVisibility(0);
    this.xGl.setVisibility(0);
    this.xGl.setText("");
    this.xGk.setEnabled(false);
    this.xGm.setVisibility(4);
    if (this.xGn == null)
    {
      this.xGo.setVisibility(4);
      return;
    }
    this.xGn.setVisibility(4);
    return;
    this.xGi.setVisibility(8);
    this.xGj.setBackgroundResource(h.d.btn_solid_green);
    this.xGj.setEnabled(false);
    this.xGj.setVisibility(0);
    this.xGh.setVisibility(0);
    this.xGk.setEnabled(false);
    this.xGl.setTextColor(this.xGl.getResources().getColorStateList(h.b.emoji_download_finish_color));
    this.xGl.setVisibility(0);
    this.xGl.setText(h.h.emoji_preview_activity_limit);
    this.xGm.setVisibility(4);
    if (this.xGn == null)
    {
      this.xGo.setVisibility(4);
      return;
    }
    this.xGn.setVisibility(4);
  }
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  public final String getProductId()
  {
    if (this.xFY == null) {}
    while (this.xFY.xHE == null) {
      return null;
    }
    return this.xFY.xHE.ProductID;
  }
  
  public final int getProgress()
  {
    if (this.xFY == null) {
      return 0;
    }
    return this.xFY.boE;
  }
  
  public final View getRoot()
  {
    return this.qAv;
  }
  
  public final void setTitle(int paramInt)
  {
    this.sUt.setText(paramInt);
  }
  
  public final void setTitle(String paramString)
  {
    this.sUt.setText(paramString);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108294);
      xGv = new a("LIST", 0);
      xGw = new a("GRID_MAIN", 1);
      xGx = new a("GRID_RECOMMEND", 2);
      xGy = new a[] { xGv, xGw, xGx };
      AppMethodBeat.o(108294);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */