package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.c.vn;

public final class d
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int aGQ()
  {
    return 0;
  }
  
  public final int aGR()
  {
    return 0;
  }
  
  public final int aGS()
  {
    return 0;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (d.a)paramView.getTag();
    Object localObject = pP(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      ((f)localObject).iVY = false;
      ((f)localObject).iVZ = false;
      localObject = ((f)localObject).iVU;
      if (localObject != null)
      {
        paramViewGroup.setTitle(((vn)localObject).sSc);
        o.ON().a(((vn)localObject).kSy, paramViewGroup.aGE(), e.cJ(((vn)localObject).syc, ((vn)localObject).kSy));
        paramViewGroup.Ai(h.aq("yyyy-MM-dd", ((vn)localObject).sSK * 1000L));
      }
    }
    return paramView;
  }
  
  protected final a c(Context paramContext, View paramView)
  {
    paramContext = new d.a(this, paramContext, paramView);
    paramContext.a(this.iVJ);
    return paramContext;
  }
  
  public final void pM(int paramInt) {}
  
  public final void pN(int paramInt) {}
  
  public final void pO(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */