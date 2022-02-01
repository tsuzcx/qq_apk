package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class d
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void FK(int paramInt) {}
  
  public final void FL(int paramInt) {}
  
  public final void FM(int paramInt) {}
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108314);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = FN(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((com.tencent.mm.plugin.emoji.a.a.f)localObject).qYp = false;
      ((com.tencent.mm.plugin.emoji.a.a.f)localObject).qYq = false;
      localObject = ((com.tencent.mm.plugin.emoji.a.a.f)localObject).qYl;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
        q.bcV().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.cEX(), e.fQ(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        paramViewGroup.alY(com.tencent.mm.pluginsdk.i.f.bQ("yyyy-MM-dd", ((EmotionSummary)localObject).Timestamp * 1000L));
      }
    }
    AppMethodBeat.o(108314);
    return paramView;
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
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108313);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.qYa);
    AppMethodBeat.o(108313);
    return paramContext;
  }
  
  public final class a
    extends a
  {
    public a(Context paramContext, View paramView)
    {
      super(paramView);
    }
    
    protected final void cET()
    {
      AppMethodBeat.i(108310);
      this.qWN.setVisibility(8);
      this.qWQ.setVisibility(8);
      this.qWP.setVisibility(0);
      this.qWR.setVisibility(8);
      this.qWV.setVisibility(8);
      this.qWW.setVisibility(8);
      this.qWM.setVisibility(0);
      this.mPa.setVisibility(0);
      this.qWT.setVisibility(0);
      this.qWS.setVisibility(0);
      this.qWS.setBackgroundDrawable(null);
      this.qWU.setVisibility(0);
      AppMethodBeat.o(108310);
    }
    
    protected final int[] cEU()
    {
      AppMethodBeat.i(108311);
      int i = com.tencent.mm.cb.a.aG(this.mContext, 2131166281);
      AppMethodBeat.o(108311);
      return new int[] { i, i };
    }
    
    protected final int cEV()
    {
      AppMethodBeat.i(108312);
      int i = com.tencent.mm.cb.a.aG(this.mContext, 2131166282);
      AppMethodBeat.o(108312);
      return i;
    }
    
    protected final boolean cFe()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */