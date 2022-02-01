package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.protocal.protobuf.akh;

public final class d
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Js(int paramInt) {}
  
  public final void Jt(int paramInt) {}
  
  public final void Ju(int paramInt) {}
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108314);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = Jv(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((com.tencent.mm.plugin.emoji.a.a.f)localObject).uBe = false;
      ((com.tencent.mm.plugin.emoji.a.a.f)localObject).uBf = false;
      localObject = ((com.tencent.mm.plugin.emoji.a.a.f)localObject).uBa;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((akh)localObject).Suv);
        q.bml().a(((akh)localObject).CNj, paramViewGroup.cTB(), e.gd(((akh)localObject).ProductID, ((akh)localObject).CNj));
        paramViewGroup.atS(com.tencent.mm.pluginsdk.j.f.bX("yyyy-MM-dd", ((akh)localObject).Svi * 1000L));
      }
    }
    AppMethodBeat.o(108314);
    return paramView;
  }
  
  public final int cTM()
  {
    return 0;
  }
  
  public final int cTN()
  {
    return 0;
  }
  
  public final int cTO()
  {
    return 0;
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108313);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.uAP);
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
    
    protected final int cTA()
    {
      AppMethodBeat.i(108312);
      int i = com.tencent.mm.ci.a.aY(getContext(), i.c.emoji_paid_item_min_height);
      AppMethodBeat.o(108312);
      return i;
    }
    
    protected final boolean cTG()
    {
      return true;
    }
    
    protected final void cTy()
    {
      AppMethodBeat.i(108310);
      this.uzB.setVisibility(8);
      this.uzE.setVisibility(8);
      this.uzD.setVisibility(0);
      this.uzF.setVisibility(8);
      this.uzJ.setVisibility(8);
      this.uzK.setVisibility(8);
      this.uzA.setVisibility(0);
      this.pPT.setVisibility(0);
      this.uzH.setVisibility(0);
      this.uzG.setVisibility(0);
      this.uzG.setBackgroundDrawable(null);
      this.uzI.setVisibility(0);
      AppMethodBeat.o(108310);
    }
    
    protected final int[] cTz()
    {
      AppMethodBeat.i(108311);
      int i = com.tencent.mm.ci.a.aY(getContext(), i.c.emoji_paid_item_icon_height);
      AppMethodBeat.o(108311);
      return new int[] { i, i };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */