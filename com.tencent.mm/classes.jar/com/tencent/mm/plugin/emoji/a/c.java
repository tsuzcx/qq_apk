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
import com.tencent.mm.g.a.dp;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
  private ProgressDialog jZH;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void FK(int paramInt) {}
  
  public final void FL(int paramInt) {}
  
  public final void FM(int paramInt) {}
  
  public final com.tencent.mm.plugin.emoji.a.a.c a(g paramg)
  {
    AppMethodBeat.i(108306);
    paramg = new d(paramg);
    AppMethodBeat.o(108306);
    return paramg;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108304);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = FN(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((f)localObject).qYl;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.h.a.g((EmotionSummary)localObject)) {
          break label83;
        }
        paramViewGroup.cEW();
        paramViewGroup.cEY();
      }
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.qWL.setBackgroundResource(2131231901);
      }
      AppMethodBeat.o(108304);
      return paramView;
      label83:
      if (!Util.isNullOrNil(((EmotionSummary)localObject).PackName)) {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
      }
      for (;;)
      {
        if (Util.isNullOrNil(((EmotionSummary)localObject).IconUrl)) {
          break label157;
        }
        q.bcV().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.cEX(), e.fQ(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        break;
        paramViewGroup.setTitle(((EmotionSummary)localObject).ProductID);
      }
      label157:
      Log.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.cEX().setImageDrawable(null);
    }
  }
  
  public final void cFj()
  {
    AppMethodBeat.i(108309);
    super.cFj();
    AppMethodBeat.o(108309);
  }
  
  public final int cFk()
  {
    return 0;
  }
  
  public final int cFl()
  {
    return 0;
  }
  
  public final int cFm()
  {
    return 0;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108308);
    if (this.jZH != null) {
      this.jZH.cancel();
    }
    super.clear();
    AppMethodBeat.o(108308);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108305);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.qYa);
    AppMethodBeat.o(108305);
    return paramContext;
  }
  
  public final void dc(String paramString, int paramInt)
  {
    AppMethodBeat.i(108307);
    if (paramInt == 7) {
      super.dc(paramString, paramInt);
    }
    AppMethodBeat.o(108307);
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108303);
    if (this.qXZ == null) {
      this.qXZ = a(null);
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
      cFc();
      boolean bool = super.a(parama, paramView);
      AppMethodBeat.o(108299);
      return bool;
    }
    
    protected final void b(j.a parama, View paramView)
    {
      AppMethodBeat.i(108300);
      super.b(parama, paramView);
      if (com.tencent.mm.plugin.emoji.h.a.ang(getProductId()))
      {
        parama = new dp();
        parama.dGC.productId = getProductId();
        paramView = parama.dGC;
        if (!com.tencent.mm.plugin.emoji.h.a.cHz()) {
          break label98;
        }
      }
      label98:
      for (int i = 7;; i = 3)
      {
        paramView.status = i;
        parama.dGC.progress = getProgress();
        parama.dGC.dGD = this.qWK.qYo;
        EventCenter.instance.publish(parama);
        AppMethodBeat.o(108300);
        return;
      }
    }
    
    protected final void cET()
    {
      AppMethodBeat.i(108298);
      this.qWN.setVisibility(8);
      this.qWO.setVisibility(8);
      cFb();
      this.qWR.setVisibility(8);
      this.qWV.setVisibility(8);
      this.qWW.setVisibility(8);
      this.qWM.setVisibility(0);
      this.mPa.setVisibility(0);
      this.qWT.setVisibility(0);
      this.qWS.setVisibility(0);
      this.qWU.setVisibility(0);
      AppMethodBeat.o(108298);
    }
    
    protected final int[] cEU()
    {
      AppMethodBeat.i(108301);
      int i = this.mContext.getResources().getDimensionPixelSize(2131165192);
      AppMethodBeat.o(108301);
      return new int[] { i, i };
    }
    
    protected final int cEV()
    {
      return -1;
    }
    
    protected final boolean cFe()
    {
      return true;
    }
    
    public final void cFh()
    {
      AppMethodBeat.i(108302);
      if (this.qWK == null)
      {
        AppMethodBeat.o(108302);
        return;
      }
      switch (cFc())
      {
      default: 
        this.qWR.setVisibility(8);
        this.qWS.setBackgroundResource(2131231436);
        this.qWS.setVisibility(0);
        this.qWU.setVisibility(0);
        this.qWU.setText(2131758680);
        this.qWU.setTextColor(this.mContext.getResources().getColorStateList(2131100050));
        this.qWV.setVisibility(4);
        this.qWV.setImageResource(2131232111);
        this.qWW.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      case 0: 
      case 3: 
        this.qWR.setVisibility(8);
        this.qWS.setBackgroundResource(2131231429);
        this.qWS.setVisibility(0);
        this.qWU.setVisibility(0);
        this.qWU.setText(2131758613);
        this.qWU.setTextColor(this.mContext.getResources().getColorStateList(2131101430));
        this.qWV.setVisibility(4);
        this.qWV.setImageResource(2131232111);
        this.qWW.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      }
      cFf();
      AppMethodBeat.o(108302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */