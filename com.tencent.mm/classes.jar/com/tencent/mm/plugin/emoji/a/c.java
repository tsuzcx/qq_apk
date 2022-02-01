package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
  private ProgressDialog jbE;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Cb(int paramInt) {}
  
  public final void Cc(int paramInt) {}
  
  public final void Cd(int paramInt) {}
  
  public final com.tencent.mm.plugin.emoji.a.a.c a(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    AppMethodBeat.i(108306);
    paramf = new d(paramf);
    AppMethodBeat.o(108306);
    return paramf;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108304);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = Ce(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((com.tencent.mm.plugin.emoji.a.a.f)localObject).pIz;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.h.a.g((EmotionSummary)localObject)) {
          break label83;
        }
        paramViewGroup.chk();
        paramViewGroup.chm();
      }
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.pGZ.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(108304);
      return paramView;
      label83:
      if (!bu.isNullOrNil(((EmotionSummary)localObject).PackName)) {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
      }
      for (;;)
      {
        if (bu.isNullOrNil(((EmotionSummary)localObject).IconUrl)) {
          break label157;
        }
        q.aJb().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.chl(), e.fy(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        break;
        paramViewGroup.setTitle(((EmotionSummary)localObject).ProductID);
      }
      label157:
      ae.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.chl().setImageDrawable(null);
    }
  }
  
  public final void cW(String paramString, int paramInt)
  {
    AppMethodBeat.i(108307);
    if (paramInt == 7) {
      super.cW(paramString, paramInt);
    }
    AppMethodBeat.o(108307);
  }
  
  public final int chA()
  {
    return 0;
  }
  
  public final void chx()
  {
    AppMethodBeat.i(108309);
    super.chx();
    AppMethodBeat.o(108309);
  }
  
  public final int chy()
  {
    return 0;
  }
  
  public final int chz()
  {
    return 0;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108308);
    if (this.jbE != null) {
      this.jbE.cancel();
    }
    super.clear();
    AppMethodBeat.o(108308);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108305);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.pIo);
    AppMethodBeat.o(108305);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108303);
    if (this.pIn == null) {
      this.pIn = a(null);
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(108303);
  }
  
  public final class a
    extends a
  {
    public a(Context paramContext, View paramView)
    {
      super(paramView);
    }
    
    protected final boolean a(j.a parama, View paramView)
    {
      AppMethodBeat.i(108299);
      chq();
      boolean bool = super.a(parama, paramView);
      AppMethodBeat.o(108299);
      return bool;
    }
    
    protected final void b(j.a parama, View paramView)
    {
      AppMethodBeat.i(108300);
      super.b(parama, paramView);
      if (com.tencent.mm.plugin.emoji.h.a.acY(getProductId()))
      {
        parama = new dm();
        parama.dpo.dpp = getProductId();
        paramView = parama.dpo;
        if (!com.tencent.mm.plugin.emoji.h.a.cjy()) {
          break label98;
        }
      }
      label98:
      for (int i = 7;; i = 3)
      {
        paramView.status = i;
        parama.dpo.progress = getProgress();
        parama.dpo.dpq = this.pGY.pIC;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
        AppMethodBeat.o(108300);
        return;
      }
    }
    
    protected final void chh()
    {
      AppMethodBeat.i(108298);
      this.pHb.setVisibility(8);
      this.pHc.setVisibility(8);
      chp();
      this.pHf.setVisibility(8);
      this.pHj.setVisibility(8);
      this.pHk.setVisibility(8);
      this.pHa.setVisibility(0);
      this.lHk.setVisibility(0);
      this.pHh.setVisibility(0);
      this.pHg.setVisibility(0);
      this.pHi.setVisibility(0);
      AppMethodBeat.o(108298);
    }
    
    protected final int[] chi()
    {
      AppMethodBeat.i(108301);
      int i = this.mContext.getResources().getDimensionPixelSize(2131165189);
      AppMethodBeat.o(108301);
      return new int[] { i, i };
    }
    
    protected final int chj()
    {
      return -1;
    }
    
    protected final boolean chs()
    {
      return true;
    }
    
    public final void chv()
    {
      AppMethodBeat.i(108302);
      if (this.pGY == null)
      {
        AppMethodBeat.o(108302);
        return;
      }
      switch (chq())
      {
      default: 
        this.pHf.setVisibility(8);
        this.pHg.setBackgroundResource(2131231372);
        this.pHg.setVisibility(0);
        this.pHi.setVisibility(0);
        this.pHi.setText(2131758386);
        this.pHi.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
        this.pHj.setVisibility(4);
        this.pHj.setImageResource(2131232020);
        this.pHk.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      case 0: 
      case 3: 
        this.pHf.setVisibility(8);
        this.pHg.setBackgroundResource(2131231365);
        this.pHg.setVisibility(0);
        this.pHi.setVisibility(0);
        this.pHi.setText(2131758319);
        this.pHi.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.pHj.setVisibility(4);
        this.pHj.setImageResource(2131232020);
        this.pHk.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      }
      cht();
      AppMethodBeat.o(108302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */