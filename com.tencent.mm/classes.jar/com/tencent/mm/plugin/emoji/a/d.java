package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class d
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void BP(int paramInt) {}
  
  public final void BQ(int paramInt) {}
  
  public final void BR(int paramInt) {}
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108314);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = BS(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((f)localObject).pBZ = false;
      ((f)localObject).pCa = false;
      localObject = ((f)localObject).pBV;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
        q.aIJ().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.cfV(), e.fu(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        paramViewGroup.abf(i.bO("yyyy-MM-dd", ((EmotionSummary)localObject).Timestamp * 1000L));
      }
    }
    AppMethodBeat.o(108314);
    return paramView;
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
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108313);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.pBK);
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
    
    protected final void cfR()
    {
      AppMethodBeat.i(108310);
      this.pAx.setVisibility(8);
      this.pAA.setVisibility(8);
      this.pAz.setVisibility(0);
      this.pAB.setVisibility(8);
      this.pAF.setVisibility(8);
      this.pAG.setVisibility(8);
      this.pAw.setVisibility(0);
      this.lCL.setVisibility(0);
      this.pAD.setVisibility(0);
      this.pAC.setVisibility(0);
      this.pAC.setBackgroundDrawable(null);
      this.pAE.setVisibility(0);
      AppMethodBeat.o(108310);
    }
    
    protected final int[] cfS()
    {
      AppMethodBeat.i(108311);
      int i = com.tencent.mm.cc.a.ax(this.mContext, 2131166238);
      AppMethodBeat.o(108311);
      return new int[] { i, i };
    }
    
    protected final int cfT()
    {
      AppMethodBeat.i(108312);
      int i = com.tencent.mm.cc.a.ax(this.mContext, 2131166239);
      AppMethodBeat.o(108312);
      return i;
    }
    
    protected final boolean cgc()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */