package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.protocal.protobuf.cjb;

public final class d
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void JZ(int paramInt) {}
  
  public final void Ka(int paramInt) {}
  
  public final void Kb(int paramInt) {}
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108314);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = Kd(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((com.tencent.mm.plugin.emoji.a.a.f)localObject).xHJ = false;
      ((com.tencent.mm.plugin.emoji.a.a.f)localObject).xHK = false;
      localObject = ((com.tencent.mm.plugin.emoji.a.a.f)localObject).xHE;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((cjb)localObject).Zul);
        paramViewGroup.Kc(((cjb)localObject).akkd);
        r.bKe().a(((cjb)localObject).IHo, paramViewGroup.dxW(), com.tencent.mm.plugin.emoji.mgr.e.gJ(((cjb)localObject).ProductID, ((cjb)localObject).IHo));
        paramViewGroup.anJ(com.tencent.mm.pluginsdk.platformtools.f.cj("yyyy-MM-dd", ((cjb)localObject).Zvi * 1000L));
      }
    }
    AppMethodBeat.o(108314);
    return paramView;
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108313);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.xHs);
    AppMethodBeat.o(108313);
    return paramContext;
  }
  
  public final int dyh()
  {
    return 0;
  }
  
  public final int dyi()
  {
    return 0;
  }
  
  public final int dyj()
  {
    return 0;
  }
  
  public final class a
    extends a
  {
    public a(Context paramContext, View paramView)
    {
      super(paramView);
    }
    
    public final void Kc(int paramInt)
    {
      AppMethodBeat.i(269933);
      if ((this.xGd != null) && (!com.tencent.mm.plugin.emoji.a.a.e.Kj(paramInt))) {
        this.xGd.setText(getContext().getString(h.h.similar_emoji_pay));
      }
      AppMethodBeat.o(269933);
    }
    
    protected final void dxT()
    {
      AppMethodBeat.i(108310);
      this.xGb.setVisibility(8);
      this.xGg.setVisibility(8);
      this.xGe.setVisibility(0);
      this.xGi.setVisibility(8);
      this.xGm.setVisibility(8);
      this.xGn.setVisibility(8);
      this.xGa.setVisibility(0);
      this.sUt.setVisibility(0);
      this.xGk.setVisibility(0);
      this.xGj.setVisibility(0);
      this.xGj.setBackgroundDrawable(null);
      this.xGl.setVisibility(0);
      this.xGd.setVisibility(0);
      AppMethodBeat.o(108310);
    }
    
    protected final int[] dxU()
    {
      AppMethodBeat.i(108311);
      int i = com.tencent.mm.cd.a.br(getContext(), h.c.emoji_paid_item_icon_height);
      AppMethodBeat.o(108311);
      return new int[] { i, i };
    }
    
    protected final int dxV()
    {
      AppMethodBeat.i(108312);
      int i = com.tencent.mm.cd.a.br(getContext(), h.c.emoji_paid_item_min_height);
      AppMethodBeat.o(108312);
      return i;
    }
    
    protected final boolean dyb()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */