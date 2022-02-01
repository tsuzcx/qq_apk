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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.o.a;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  public int mPosition;
  protected View nBk;
  protected TextView pPT;
  protected ImageView uzA;
  protected ImageView uzB;
  protected View uzC;
  protected TextView uzD;
  protected TextView uzE;
  protected ProgressBar uzF;
  protected ViewGroup uzG;
  protected View uzH;
  protected TextView uzI;
  protected ImageView uzJ;
  protected View uzK;
  protected ProgressBar uzL;
  protected TextView uzM;
  protected TextView uzN;
  protected FrameLayout uzO;
  private View uzs;
  private final int uzt = i.f.emoji_list_item;
  private final int uzu = i.f.emoji_store_v2_grid_item;
  private final int uzv = i.f.emoji_store_v2_grid_item_main;
  private int[] uzw = { -1, -1 };
  private int uzx = -1;
  public f uzy;
  protected View uzz;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.uzS);
  }
  
  private a(Context paramContext, View paramView, a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label467:
    int i;
    switch (2.uzR[parama.ordinal()])
    {
    default: 
      paramContext = Jn(this.uzt);
      this.nBk = paramContext;
      if (paramContext != null)
      {
        this.uzs = paramContext;
        this.uzz = this.uzs.findViewById(i.e.item_container);
        this.uzB = ((ImageView)this.uzs.findViewById(i.e.item_tip));
        this.uzA = ((ImageView)this.uzs.findViewById(i.e.item_icon));
        this.pPT = ((TextView)this.uzs.findViewById(i.e.item_name));
        this.uzC = this.uzs.findViewById(i.e.item_name_new_tip);
        this.uzD = ((TextView)this.uzs.findViewById(i.e.item_date));
        this.uzE = ((TextView)this.uzs.findViewById(i.e.item_introduce));
        this.uzF = ((ProgressBar)this.uzs.findViewById(i.e.price_loading));
        this.uzH = this.uzs.findViewById(i.e.item_option);
        this.uzG = ((ViewGroup)this.uzs.findViewById(i.e.item_root));
        this.uzI = ((TextView)this.uzs.findViewById(i.e.item_state));
        this.uzJ = ((ImageView)this.uzs.findViewById(i.e.item_state_image));
        this.uzK = this.uzs.findViewById(i.e.item_progress_bar);
        this.uzL = ((ProgressBar)this.uzs.findViewById(i.e.item_download_progress));
        this.uzM = ((TextView)this.uzs.findViewById(i.e.item_category));
        this.uzN = ((TextView)this.uzs.findViewById(i.e.item_new));
        this.uzO = ((FrameLayout)this.uzs.findViewById(i.e.item_list_content));
      }
      cTy();
      if (parama == a.uzS)
      {
        paramView = cTz();
        if ((this.uzA != null) && (paramView[0] >= 0) && (paramView[1] >= 0) && ((paramView[0] != this.uzw[0]) || (paramView[1] != this.uzw[1]))) {
          break label536;
        }
        i = cTA();
        if ((this.uzs != null) && (i >= 0) && (this.uzx != i)) {
          break label574;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = Jn(this.uzt);
      break;
      paramContext = Jn(this.uzv);
      break;
      paramContext = Jn(this.uzu);
      break;
      label536:
      parama = this.uzA.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.uzA.setLayoutParams(parama);
      this.uzw = paramView;
      break label467;
      label574:
      this.uzs.setMinimumHeight(i);
      if (this.uzz != null) {
        this.uzz.setMinimumHeight(i);
      }
    }
  }
  
  private View Jn(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  private void cTI()
  {
    this.uzF.setVisibility(8);
    this.uzG.setBackgroundResource(i.d.btn_solid_green);
    this.uzG.setVisibility(0);
    this.uzH.setEnabled(true);
    this.uzI.setText("");
    if (this.uzK == null) {
      this.uzL.setVisibility(4);
    }
    for (;;)
    {
      this.uzI.setVisibility(0);
      this.uzI.setText(i.h.emoji_store_download);
      this.uzI.setTextColor(this.mContext.getResources().getColorStateList(i.b.white_text_color_selector));
      this.uzJ.setVisibility(8);
      return;
      this.uzK.setVisibility(4);
    }
  }
  
  public final void Jo(int paramInt)
  {
    this.uzA.setImageResource(paramInt);
  }
  
  public final void Jp(int paramInt)
  {
    this.uzB.setVisibility(paramInt);
  }
  
  public final void Jq(int paramInt)
  {
    this.uzB.setImageResource(paramInt);
  }
  
  public final void Jr(int paramInt)
  {
    this.uzH.setVisibility(paramInt);
  }
  
  public final void a(final o.a parama)
  {
    if (this.uzH != null) {
      this.uzH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108290);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (a.this.a(parama, paramAnonymousView)) {
            a.this.b(parama, paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108290);
        }
      });
    }
  }
  
  protected boolean a(o.a parama, View paramView)
  {
    return true;
  }
  
  public final void atS(String paramString)
  {
    this.uzD.setText(paramString);
  }
  
  public final void atT(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      this.uzE.setVisibility(8);
      return;
    }
    this.uzE.setVisibility(0);
    this.uzE.setText(paramString);
  }
  
  protected void b(o.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  protected abstract int cTA();
  
  public final ImageView cTB()
  {
    return this.uzA;
  }
  
  public final ImageView cTC()
  {
    return this.uzB;
  }
  
  public final void cTD()
  {
    this.uzD.setVisibility(8);
    this.uzE.setVisibility(8);
  }
  
  public final int cTE()
  {
    if (this.uzy == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.uzy.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String cTF()
  {
    if (this.uzy == null) {}
    while (this.uzy.uBa == null) {
      return null;
    }
    return this.uzy.uBa.Tex;
  }
  
  protected abstract boolean cTG();
  
  protected final void cTH()
  {
    this.uzF.setVisibility(8);
    this.uzG.setVisibility(8);
    this.uzH.setEnabled(false);
    this.uzJ.setVisibility(8);
    this.uzL.setVisibility(0);
    this.uzL.setProgress(getProgress());
    if (this.uzK == null)
    {
      this.uzL.setVisibility(0);
      return;
    }
    this.uzK.setVisibility(0);
  }
  
  public void cTJ()
  {
    if (this.uzy == null) {}
    while (!cTG()) {
      return;
    }
    this.uzI.setVisibility(8);
    this.uzI.setTextColor(this.mContext.getResources().getColorStateList(i.b.black_text_color_selector));
    switch (cTE())
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      Log.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(cTE()) });
      return;
    case 8: 
      this.uzF.setVisibility(8);
      this.uzG.setBackgroundDrawable(null);
      this.uzG.setVisibility(0);
      this.uzH.setEnabled(false);
      this.uzI.setVisibility(0);
      this.uzI.setText(i.h.emoji_store_expire);
      this.uzJ.setVisibility(4);
      if (this.uzK == null)
      {
        this.uzL.setVisibility(4);
        return;
      }
      this.uzK.setVisibility(4);
      return;
    case 0: 
      cTI();
      return;
    case 6: 
      cTH();
      return;
    case 7: 
      if (this.uzy.uBe)
      {
        Log.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
        this.uzF.setVisibility(8);
        this.uzG.setBackgroundResource(i.d.btn_solid_green);
        this.uzG.setVisibility(0);
        this.uzG.setTag(getProductId());
        this.uzH.setEnabled(true);
        this.uzI.setVisibility(0);
        this.uzI.setText(i.h.emoji_store_use);
        this.uzI.setTextColor(this.mContext.getResources().getColorStateList(i.b.white_text_color_selector));
        this.uzJ.setVisibility(4);
        if (this.uzK == null)
        {
          this.uzL.setVisibility(4);
          return;
        }
        this.uzK.setVisibility(4);
        return;
      }
      if ((this.uzy.uBg) && (e.fX(this.uzy.uBa.TOG, 64)))
      {
        this.uzG.setVisibility(0);
        this.uzG.setBackgroundResource(i.d.btn_solid_red);
        this.uzI.setVisibility(0);
        this.uzI.setText(i.h.emoji_store_reward);
        this.uzI.setTextColor(this.mContext.getResources().getColorStateList(i.b.white_text_color_selector));
        this.uzJ.setVisibility(4);
        this.uzH.setEnabled(true);
        if (this.uzK == null)
        {
          this.uzL.setVisibility(4);
          return;
        }
        this.uzK.setVisibility(4);
        return;
      }
      this.uzF.setVisibility(8);
      this.uzG.setVisibility(0);
      this.uzG.setBackgroundResource(i.d.btn_solid_white);
      this.uzI.setVisibility(0);
      this.uzI.setText(i.h.emoji_store_downloaded);
      this.uzI.setTextColor(this.mContext.getResources().getColorStateList(i.b.black_text_color_disabled));
      this.uzJ.setVisibility(4);
      this.uzH.setEnabled(false);
      if (this.uzK == null)
      {
        this.uzL.setVisibility(4);
        return;
      }
      this.uzK.setVisibility(4);
      return;
    case 3: 
      cTI();
      return;
    case 4: 
    case 12: 
      this.uzF.setVisibility(8);
      this.uzG.setBackgroundResource(i.d.btn_solid_white);
      this.uzG.setVisibility(0);
      if (this.uzK == null) {
        this.uzL.setVisibility(4);
      }
      for (;;)
      {
        this.uzH.setEnabled(true);
        this.uzJ.setVisibility(4);
        this.uzI.setVisibility(0);
        if (this.uzy.uBa == null) {
          break;
        }
        this.uzI.setText(this.uzy.uBa.Tex);
        return;
        this.uzK.setVisibility(4);
      }
    case 10: 
      this.uzF.setVisibility(8);
      this.uzG.setBackgroundResource(i.d.btn_solid_white);
      this.uzG.setVisibility(0);
      this.uzI.setVisibility(0);
      this.uzI.setText(i.h.emoji_store_play);
      this.uzJ.setVisibility(4);
      this.uzH.setEnabled(true);
      if (this.uzK == null)
      {
        this.uzL.setVisibility(4);
        return;
      }
      this.uzK.setVisibility(4);
      return;
    }
    this.uzF.setVisibility(0);
    this.uzG.setBackgroundResource(i.d.btn_solid_white);
    this.uzG.setVisibility(0);
    this.uzI.setVisibility(0);
    this.uzI.setText("");
    this.uzH.setEnabled(false);
    this.uzJ.setVisibility(4);
    if (this.uzK == null)
    {
      this.uzL.setVisibility(4);
      return;
    }
    this.uzK.setVisibility(4);
  }
  
  protected abstract void cTy();
  
  protected abstract int[] cTz();
  
  protected final Context getContext()
  {
    return this.mContext;
  }
  
  public final String getProductId()
  {
    if (this.uzy == null) {}
    while (this.uzy.uBa == null) {
      return null;
    }
    return this.uzy.uBa.ProductID;
  }
  
  public final int getProgress()
  {
    if (this.uzy == null) {
      return 0;
    }
    return this.uzy.IB;
  }
  
  public final View getRoot()
  {
    return this.nBk;
  }
  
  public final void setTitle(int paramInt)
  {
    this.pPT.setText(paramInt);
  }
  
  public final void setTitle(String paramString)
  {
    this.pPT.setText(paramString);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108294);
      uzS = new a("LIST", 0);
      uzT = new a("GRID_MAIN", 1);
      uzU = new a("GRID_RECOMMEND", 2);
      uzV = new a[] { uzS, uzT, uzU };
      AppMethodBeat.o(108294);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */