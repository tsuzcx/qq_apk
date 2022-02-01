package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class d
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Bh(int paramInt) {}
  
  public final void Bi(int paramInt) {}
  
  public final void Bj(int paramInt) {}
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108314);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = Bk(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((f)localObject).oYp = false;
      ((f)localObject).oYq = false;
      localObject = ((f)localObject).oYl;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
        o.aFB().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.cbr(), e.fk(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        paramViewGroup.Xy(h.bK("yyyy-MM-dd", ((EmotionSummary)localObject).Timestamp * 1000L));
      }
    }
    AppMethodBeat.o(108314);
    return paramView;
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
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108313);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.oYa);
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
    
    protected final void cbn()
    {
      AppMethodBeat.i(108310);
      this.oWN.setVisibility(8);
      this.oWQ.setVisibility(8);
      this.oWP.setVisibility(0);
      this.oWR.setVisibility(8);
      this.oWV.setVisibility(8);
      this.oWW.setVisibility(8);
      this.oWM.setVisibility(0);
      this.lfN.setVisibility(0);
      this.oWT.setVisibility(0);
      this.oWS.setVisibility(0);
      this.oWS.setBackgroundDrawable(null);
      this.oWU.setVisibility(0);
      AppMethodBeat.o(108310);
    }
    
    protected final int[] cbo()
    {
      AppMethodBeat.i(108311);
      int i = com.tencent.mm.cc.a.au(this.mContext, 2131166238);
      AppMethodBeat.o(108311);
      return new int[] { i, i };
    }
    
    protected final int cbp()
    {
      AppMethodBeat.i(108312);
      int i = com.tencent.mm.cc.a.au(this.mContext, 2131166239);
      AppMethodBeat.o(108312);
      return i;
    }
    
    protected final boolean cby()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */