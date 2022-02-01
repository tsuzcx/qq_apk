package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
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
  
  public final void Ap(int paramInt) {}
  
  public final void Aq(int paramInt) {}
  
  public final void Ar(int paramInt) {}
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108314);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = As(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((f)localObject).ouP = false;
      ((f)localObject).ouQ = false;
      localObject = ((f)localObject).ouL;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((EmotionSummary)localObject).PackName);
        o.ayJ().a(((EmotionSummary)localObject).IconUrl, paramViewGroup.bUd(), e.eX(((EmotionSummary)localObject).ProductID, ((EmotionSummary)localObject).IconUrl));
        paramViewGroup.Tm(h.bI("yyyy-MM-dd", ((EmotionSummary)localObject).Timestamp * 1000L));
      }
    }
    AppMethodBeat.o(108314);
    return paramView;
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
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108313);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.ouA);
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
    
    protected final void bTZ()
    {
      AppMethodBeat.i(108310);
      this.otm.setVisibility(8);
      this.otp.setVisibility(8);
      this.oto.setVisibility(0);
      this.otq.setVisibility(8);
      this.otu.setVisibility(8);
      this.otv.setVisibility(8);
      this.otl.setVisibility(0);
      this.kEu.setVisibility(0);
      this.ots.setVisibility(0);
      this.otr.setVisibility(0);
      this.otr.setBackgroundDrawable(null);
      this.ott.setVisibility(0);
      AppMethodBeat.o(108310);
    }
    
    protected final int[] bUa()
    {
      AppMethodBeat.i(108311);
      int i = com.tencent.mm.cd.a.ao(this.mContext, 2131166238);
      AppMethodBeat.o(108311);
      return new int[] { i, i };
    }
    
    protected final int bUb()
    {
      AppMethodBeat.i(108312);
      int i = com.tencent.mm.cd.a.ao(this.mContext, 2131166239);
      AppMethodBeat.o(108312);
      return i;
    }
    
    protected final boolean bUk()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */