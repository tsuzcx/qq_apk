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
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.di;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
  private ProgressDialog iFC;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Bh(int paramInt) {}
  
  public final void Bi(int paramInt) {}
  
  public final void Bj(int paramInt) {}
  
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
    Object localObject = Bk(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((com.tencent.mm.plugin.emoji.a.a.f)localObject).oYl;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.h.a.g((EmotionSummary)localObject)) {
          break label83;
        }
        paramViewGroup.cbq();
        paramViewGroup.cbs();
      }
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.oWL.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(108304);
      return paramView;
      label83:
      if (!bs.isNullOrNil(((EmotionSummary)localObject).PackName)) {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
      }
      for (;;)
      {
        if (bs.isNullOrNil(((EmotionSummary)localObject).IconUrl)) {
          break label157;
        }
        o.aFB().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.cbr(), e.fk(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        break;
        paramViewGroup.setTitle(((EmotionSummary)localObject).ProductID);
      }
      label157:
      ac.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.cbr().setImageDrawable(null);
    }
  }
  
  public final void cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(108307);
    if (paramInt == 7) {
      super.cP(paramString, paramInt);
    }
    AppMethodBeat.o(108307);
  }
  
  public final void cbD()
  {
    AppMethodBeat.i(108309);
    super.cbD();
    AppMethodBeat.o(108309);
  }
  
  public final int cbE()
  {
    return 0;
  }
  
  public final int cbF()
  {
    return 0;
  }
  
  public final int cbG()
  {
    return 0;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108308);
    if (this.iFC != null) {
      this.iFC.cancel();
    }
    super.clear();
    AppMethodBeat.o(108308);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108305);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.oYa);
    AppMethodBeat.o(108305);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108303);
    if (this.oXZ == null) {
      this.oXZ = a(null);
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
      cbw();
      boolean bool = super.a(parama, paramView);
      AppMethodBeat.o(108299);
      return bool;
    }
    
    protected final void b(j.a parama, View paramView)
    {
      AppMethodBeat.i(108300);
      super.b(parama, paramView);
      if (com.tencent.mm.plugin.emoji.h.a.YB(getProductId()))
      {
        parama = new di();
        parama.dcN.dcO = getProductId();
        paramView = parama.dcN;
        if (!com.tencent.mm.plugin.emoji.h.a.cdF()) {
          break label98;
        }
      }
      label98:
      for (int i = 7;; i = 3)
      {
        paramView.status = i;
        parama.dcN.progress = getProgress();
        parama.dcN.dcP = this.oWK.oYo;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
        AppMethodBeat.o(108300);
        return;
      }
    }
    
    public final void cbB()
    {
      AppMethodBeat.i(108302);
      if (this.oWK == null)
      {
        AppMethodBeat.o(108302);
        return;
      }
      switch (cbw())
      {
      default: 
        this.oWR.setVisibility(8);
        this.oWS.setBackgroundResource(2131231372);
        this.oWS.setVisibility(0);
        this.oWU.setVisibility(0);
        this.oWU.setText(2131758386);
        this.oWU.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
        this.oWV.setVisibility(4);
        this.oWV.setImageResource(2131232020);
        this.oWW.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      case 0: 
      case 3: 
        this.oWR.setVisibility(8);
        this.oWS.setBackgroundResource(2131231365);
        this.oWS.setVisibility(0);
        this.oWU.setVisibility(0);
        this.oWU.setText(2131758319);
        this.oWU.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.oWV.setVisibility(4);
        this.oWV.setImageResource(2131232020);
        this.oWW.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      }
      cbz();
      AppMethodBeat.o(108302);
    }
    
    protected final void cbn()
    {
      AppMethodBeat.i(108298);
      this.oWN.setVisibility(8);
      this.oWO.setVisibility(8);
      cbv();
      this.oWR.setVisibility(8);
      this.oWV.setVisibility(8);
      this.oWW.setVisibility(8);
      this.oWM.setVisibility(0);
      this.lfN.setVisibility(0);
      this.oWT.setVisibility(0);
      this.oWS.setVisibility(0);
      this.oWU.setVisibility(0);
      AppMethodBeat.o(108298);
    }
    
    protected final int[] cbo()
    {
      AppMethodBeat.i(108301);
      int i = this.mContext.getResources().getDimensionPixelSize(2131165189);
      AppMethodBeat.o(108301);
      return new int[] { i, i };
    }
    
    protected final int cbp()
    {
      return -1;
    }
    
    protected final boolean cby()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */