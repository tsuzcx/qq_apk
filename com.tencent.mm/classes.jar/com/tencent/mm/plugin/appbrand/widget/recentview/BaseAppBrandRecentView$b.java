package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class BaseAppBrandRecentView$b
  extends c.a
{
  private List<a> iVE;
  private List<a> iVF;
  
  public BaseAppBrandRecentView$b(BaseAppBrandRecentView paramBaseAppBrandRecentView, List paramList1, List paramList2)
  {
    this.iVF = paramList1;
    this.iVE = paramList2;
  }
  
  public final boolean F(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134348);
    a locala1 = (a)this.iVF.get(paramInt2);
    a locala2 = (a)this.iVE.get(paramInt1);
    if ((locala1 != null) && (locala2 != null) && (locala1.jfk != null) && (locala2.jfk != null))
    {
      if ((bo.nullAsNil(locala2.jfk.username).equals(locala1.jfk.username)) && (locala2.jfk.hcr == locala1.jfk.hcr))
      {
        AppMethodBeat.o(134348);
        return true;
      }
      AppMethodBeat.o(134348);
      return false;
    }
    if ((locala1 != null) && (locala2 != null))
    {
      if ((locala1.type == 3) && (locala2.type == 3))
      {
        AppMethodBeat.o(134348);
        return true;
      }
      AppMethodBeat.o(134348);
      return false;
    }
    AppMethodBeat.o(134348);
    return false;
  }
  
  public final boolean G(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134349);
    a locala1 = (a)this.iVF.get(paramInt2);
    a locala2 = (a)this.iVE.get(paramInt1);
    if ((locala1 != null) && (locala2 != null) && (locala1.jfk != null) && (locala2.jfk != null))
    {
      boolean bool = bo.nullAsNil(locala2.jfk.hcN).equals(locala1.jfk.hcN);
      AppMethodBeat.o(134349);
      return bool;
    }
    if ((locala1 != null) && (locala2 != null))
    {
      if ((locala1.type == 3) && (locala2.type == 3))
      {
        AppMethodBeat.o(134349);
        return true;
      }
      AppMethodBeat.o(134349);
      return false;
    }
    AppMethodBeat.o(134349);
    return false;
  }
  
  public final int fv()
  {
    AppMethodBeat.i(134346);
    if (this.iVE != null)
    {
      int i = this.iVE.size();
      AppMethodBeat.o(134346);
      return i;
    }
    AppMethodBeat.o(134346);
    return 0;
  }
  
  public final int fw()
  {
    AppMethodBeat.i(134347);
    if (this.iVF != null)
    {
      int i = this.iVF.size();
      AppMethodBeat.o(134347);
      return i;
    }
    AppMethodBeat.o(134347);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b
 * JD-Core Version:    0.7.0.1
 */