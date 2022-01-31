package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class d
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(52738);
    paramViewGroup = (d.a)paramView.getTag();
    Object localObject = uj(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((f)localObject).lfe = false;
      ((f)localObject).lff = false;
      localObject = ((f)localObject).lfa;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
        o.ahG().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.bko(), g.dK(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        paramViewGroup.Kg(h.aY("yyyy-MM-dd", ((EmotionSummary)localObject).Timestamp * 1000L));
      }
    }
    AppMethodBeat.o(52738);
    return paramView;
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
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(52737);
    paramContext = new d.a(this, paramContext, paramView);
    paramContext.a(this.leP);
    AppMethodBeat.o(52737);
    return paramContext;
  }
  
  public final void ug(int paramInt) {}
  
  public final void uh(int paramInt) {}
  
  public final void ui(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */