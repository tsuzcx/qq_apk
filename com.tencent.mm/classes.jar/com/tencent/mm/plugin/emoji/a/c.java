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
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dh;
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
  private ProgressDialog ift;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Ap(int paramInt) {}
  
  public final void Aq(int paramInt) {}
  
  public final void Ar(int paramInt) {}
  
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
    Object localObject = As(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((com.tencent.mm.plugin.emoji.a.a.f)localObject).ouL;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.h.a.g((EmotionSummary)localObject)) {
          break label83;
        }
        paramViewGroup.bUc();
        paramViewGroup.bUe();
      }
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.otk.setBackgroundResource(2131231820);
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
        o.ayJ().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.bUd(), e.eX(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        break;
        paramViewGroup.setTitle(((EmotionSummary)localObject).ProductID);
      }
      label157:
      ad.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.bUd().setImageDrawable(null);
    }
  }
  
  public final void bUq()
  {
    AppMethodBeat.i(108309);
    super.bUq();
    AppMethodBeat.o(108309);
  }
  
  public final int bUr()
  {
    return 0;
  }
  
  public final int bUs()
  {
    return 0;
  }
  
  public final int bUt()
  {
    return 0;
  }
  
  public final void cK(String paramString, int paramInt)
  {
    AppMethodBeat.i(108307);
    if (paramInt == 7) {
      super.cK(paramString, paramInt);
    }
    AppMethodBeat.o(108307);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108308);
    if (this.ift != null) {
      this.ift.cancel();
    }
    super.clear();
    AppMethodBeat.o(108308);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108305);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.ouA);
    AppMethodBeat.o(108305);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108303);
    if (this.ouz == null) {
      this.ouz = a(null);
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
      bUi();
      boolean bool = super.a(parama, paramView);
      AppMethodBeat.o(108299);
      return bool;
    }
    
    protected final void b(j.a parama, View paramView)
    {
      AppMethodBeat.i(108300);
      super.b(parama, paramView);
      if (com.tencent.mm.plugin.emoji.h.a.Up(getProductId()))
      {
        parama = new dh();
        parama.dfs.dft = getProductId();
        paramView = parama.dfs;
        if (!com.tencent.mm.plugin.emoji.h.a.bWs()) {
          break label98;
        }
      }
      label98:
      for (int i = 7;; i = 3)
      {
        paramView.status = i;
        parama.dfs.progress = getProgress();
        parama.dfs.dfu = this.otj.ouO;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
        AppMethodBeat.o(108300);
        return;
      }
    }
    
    protected final void bTZ()
    {
      AppMethodBeat.i(108298);
      this.otm.setVisibility(8);
      this.otn.setVisibility(8);
      bUh();
      this.otq.setVisibility(8);
      this.otu.setVisibility(8);
      this.otv.setVisibility(8);
      this.otl.setVisibility(0);
      this.kEu.setVisibility(0);
      this.ots.setVisibility(0);
      this.otr.setVisibility(0);
      this.ott.setVisibility(0);
      AppMethodBeat.o(108298);
    }
    
    protected final int[] bUa()
    {
      AppMethodBeat.i(108301);
      int i = this.mContext.getResources().getDimensionPixelSize(2131165189);
      AppMethodBeat.o(108301);
      return new int[] { i, i };
    }
    
    protected final int bUb()
    {
      return -1;
    }
    
    protected final boolean bUk()
    {
      return true;
    }
    
    public final void bUn()
    {
      AppMethodBeat.i(108302);
      if (this.otj == null)
      {
        AppMethodBeat.o(108302);
        return;
      }
      switch (bUi())
      {
      default: 
        this.otq.setVisibility(8);
        this.otr.setBackgroundResource(2131231372);
        this.otr.setVisibility(0);
        this.ott.setVisibility(0);
        this.ott.setText(2131758386);
        this.ott.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
        this.otu.setVisibility(4);
        this.otu.setImageResource(2131232020);
        this.otv.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      case 0: 
      case 3: 
        this.otq.setVisibility(8);
        this.otr.setBackgroundResource(2131231365);
        this.otr.setVisibility(0);
        this.ott.setVisibility(0);
        this.ott.setText(2131758319);
        this.ott.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.otu.setVisibility(4);
        this.otu.setImageResource(2131232020);
        this.otv.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      }
      bUl();
      AppMethodBeat.o(108302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */