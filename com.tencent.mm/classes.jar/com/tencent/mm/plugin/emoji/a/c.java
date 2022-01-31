package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
  private ProgressDialog gsr;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.c a(e parame)
  {
    AppMethodBeat.i(52730);
    parame = new d(parame);
    AppMethodBeat.o(52730);
    return parame;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(52728);
    paramViewGroup = (c.a)paramView.getTag();
    Object localObject = uj(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((f)localObject).lfa;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.h.a.g((EmotionSummary)localObject)) {
          break label83;
        }
        paramViewGroup.bkn();
        paramViewGroup.bkp();
      }
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.ldA.setBackgroundResource(2130838447);
      }
      AppMethodBeat.o(52728);
      return paramView;
      label83:
      if (!bo.isNullOrNil(((EmotionSummary)localObject).PackName)) {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
      }
      for (;;)
      {
        if (bo.isNullOrNil(((EmotionSummary)localObject).IconUrl)) {
          break label157;
        }
        o.ahG().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.bko(), g.dK(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        break;
        paramViewGroup.setTitle(((EmotionSummary)localObject).ProductID);
      }
      label157:
      ab.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.bko().setImageDrawable(null);
    }
  }
  
  public final void bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(52731);
    if (paramInt == 7) {
      super.bX(paramString, paramInt);
    }
    AppMethodBeat.o(52731);
  }
  
  public final void bkB()
  {
    AppMethodBeat.i(52733);
    super.bkB();
    AppMethodBeat.o(52733);
  }
  
  public final int bkC()
  {
    return 0;
  }
  
  public final int bkD()
  {
    return 0;
  }
  
  public final int bkE()
  {
    return 0;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(52732);
    if (this.gsr != null) {
      this.gsr.cancel();
    }
    super.clear();
    AppMethodBeat.o(52732);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(52729);
    paramContext = new c.a(this, paramContext, paramView);
    paramContext.a(this.leP);
    AppMethodBeat.o(52729);
    return paramContext;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(52727);
    if (this.leO == null) {
      this.leO = a(null);
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(52727);
  }
  
  public final void ug(int paramInt) {}
  
  public final void uh(int paramInt) {}
  
  public final void ui(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */