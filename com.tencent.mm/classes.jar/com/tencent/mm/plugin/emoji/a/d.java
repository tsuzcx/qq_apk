package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
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
  
  public final void Cb(int paramInt) {}
  
  public final void Cc(int paramInt) {}
  
  public final void Cd(int paramInt) {}
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108314);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = Ce(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((f)localObject).pID = false;
      ((f)localObject).pIE = false;
      localObject = ((f)localObject).pIz;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
        q.aJb().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.chl(), e.fy(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        paramViewGroup.abW(i.bP("yyyy-MM-dd", ((EmotionSummary)localObject).Timestamp * 1000L));
      }
    }
    AppMethodBeat.o(108314);
    return paramView;
  }
  
  public final int chA()
  {
    return 0;
  }
  
  public final int chy()
  {
    return 0;
  }
  
  public final int chz()
  {
    return 0;
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108313);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.pIo);
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
    
    protected final void chh()
    {
      AppMethodBeat.i(108310);
      this.pHb.setVisibility(8);
      this.pHe.setVisibility(8);
      this.pHd.setVisibility(0);
      this.pHf.setVisibility(8);
      this.pHj.setVisibility(8);
      this.pHk.setVisibility(8);
      this.pHa.setVisibility(0);
      this.lHk.setVisibility(0);
      this.pHh.setVisibility(0);
      this.pHg.setVisibility(0);
      this.pHg.setBackgroundDrawable(null);
      this.pHi.setVisibility(0);
      AppMethodBeat.o(108310);
    }
    
    protected final int[] chi()
    {
      AppMethodBeat.i(108311);
      int i = com.tencent.mm.cb.a.ax(this.mContext, 2131166238);
      AppMethodBeat.o(108311);
      return new int[] { i, i };
    }
    
    protected final int chj()
    {
      AppMethodBeat.i(108312);
      int i = com.tencent.mm.cb.a.ax(this.mContext, 2131166239);
      AppMethodBeat.o(108312);
      return i;
    }
    
    protected final boolean chs()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */