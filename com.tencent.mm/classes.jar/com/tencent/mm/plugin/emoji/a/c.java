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
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
  private ProgressDialog iYL;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void BP(int paramInt) {}
  
  public final void BQ(int paramInt) {}
  
  public final void BR(int paramInt) {}
  
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
    Object localObject = BS(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((com.tencent.mm.plugin.emoji.a.a.f)localObject).pBV;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.h.a.g((EmotionSummary)localObject)) {
          break label83;
        }
        paramViewGroup.cfU();
        paramViewGroup.cfW();
      }
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.pAv.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(108304);
      return paramView;
      label83:
      if (!bt.isNullOrNil(((EmotionSummary)localObject).PackName)) {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
      }
      for (;;)
      {
        if (bt.isNullOrNil(((EmotionSummary)localObject).IconUrl)) {
          break label157;
        }
        q.aIJ().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.cfV(), e.fu(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        break;
        paramViewGroup.setTitle(((EmotionSummary)localObject).ProductID);
      }
      label157:
      ad.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.cfV().setImageDrawable(null);
    }
  }
  
  public final void cS(String paramString, int paramInt)
  {
    AppMethodBeat.i(108307);
    if (paramInt == 7) {
      super.cS(paramString, paramInt);
    }
    AppMethodBeat.o(108307);
  }
  
  public final void cgh()
  {
    AppMethodBeat.i(108309);
    super.cgh();
    AppMethodBeat.o(108309);
  }
  
  public final int cgi()
  {
    return 0;
  }
  
  public final int cgj()
  {
    return 0;
  }
  
  public final int cgk()
  {
    return 0;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108308);
    if (this.iYL != null) {
      this.iYL.cancel();
    }
    super.clear();
    AppMethodBeat.o(108308);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108305);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.pBK);
    AppMethodBeat.o(108305);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108303);
    if (this.pBJ == null) {
      this.pBJ = a(null);
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
      cga();
      boolean bool = super.a(parama, paramView);
      AppMethodBeat.o(108299);
      return bool;
    }
    
    protected final void b(j.a parama, View paramView)
    {
      AppMethodBeat.i(108300);
      super.b(parama, paramView);
      if (com.tencent.mm.plugin.emoji.h.a.ach(getProductId()))
      {
        parama = new dl();
        parama.doj.dok = getProductId();
        paramView = parama.doj;
        if (!com.tencent.mm.plugin.emoji.h.a.cii()) {
          break label98;
        }
      }
      label98:
      for (int i = 7;; i = 3)
      {
        paramView.status = i;
        parama.doj.progress = getProgress();
        parama.doj.dol = this.pAu.pBY;
        com.tencent.mm.sdk.b.a.IbL.l(parama);
        AppMethodBeat.o(108300);
        return;
      }
    }
    
    protected final void cfR()
    {
      AppMethodBeat.i(108298);
      this.pAx.setVisibility(8);
      this.pAy.setVisibility(8);
      cfZ();
      this.pAB.setVisibility(8);
      this.pAF.setVisibility(8);
      this.pAG.setVisibility(8);
      this.pAw.setVisibility(0);
      this.lCL.setVisibility(0);
      this.pAD.setVisibility(0);
      this.pAC.setVisibility(0);
      this.pAE.setVisibility(0);
      AppMethodBeat.o(108298);
    }
    
    protected final int[] cfS()
    {
      AppMethodBeat.i(108301);
      int i = this.mContext.getResources().getDimensionPixelSize(2131165189);
      AppMethodBeat.o(108301);
      return new int[] { i, i };
    }
    
    protected final int cfT()
    {
      return -1;
    }
    
    protected final boolean cgc()
    {
      return true;
    }
    
    public final void cgf()
    {
      AppMethodBeat.i(108302);
      if (this.pAu == null)
      {
        AppMethodBeat.o(108302);
        return;
      }
      switch (cga())
      {
      default: 
        this.pAB.setVisibility(8);
        this.pAC.setBackgroundResource(2131231372);
        this.pAC.setVisibility(0);
        this.pAE.setVisibility(0);
        this.pAE.setText(2131758386);
        this.pAE.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
        this.pAF.setVisibility(4);
        this.pAF.setImageResource(2131232020);
        this.pAG.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      case 0: 
      case 3: 
        this.pAB.setVisibility(8);
        this.pAC.setBackgroundResource(2131231365);
        this.pAC.setVisibility(0);
        this.pAE.setVisibility(0);
        this.pAE.setText(2131758319);
        this.pAE.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.pAF.setVisibility(4);
        this.pAF.setImageResource(2131232020);
        this.pAG.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      }
      cgd();
      AppMethodBeat.o(108302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */