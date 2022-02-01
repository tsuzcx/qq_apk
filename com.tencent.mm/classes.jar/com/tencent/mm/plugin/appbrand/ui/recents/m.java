package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;

final class m
  extends q<Object>
{
  m(ArrayList<?> paramArrayList1, ArrayList<?> paramArrayList2)
  {
    super(paramArrayList1, paramArrayList2);
  }
  
  public final boolean H(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49225);
    if (!this.mlO.get(paramInt1).getClass().equals(this.mlP.get(paramInt2).getClass()))
    {
      AppMethodBeat.o(49225);
      return false;
    }
    if ((this.mlO.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mlO.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mlP.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.joY == localAppBrandRecentTaskInfo2.joY) && (localAppBrandRecentTaskInfo1.cYF.equals(localAppBrandRecentTaskInfo2.cYF)))
      {
        AppMethodBeat.o(49225);
        return true;
      }
      AppMethodBeat.o(49225);
      return false;
    }
    AppMethodBeat.o(49225);
    return false;
  }
  
  public final boolean I(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49226);
    if ((this.mlO.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mlO.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mlP.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.jvu == localAppBrandRecentTaskInfo2.jvu) && (bs.nullAsNil(localAppBrandRecentTaskInfo1.jvt).equals(localAppBrandRecentTaskInfo2.jvt)) && (bs.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)))
      {
        AppMethodBeat.o(49226);
        return true;
      }
      AppMethodBeat.o(49226);
      return false;
    }
    AppMethodBeat.o(49226);
    return true;
  }
  
  public final Object J(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49227);
    if (paramInt1 >= this.mlO.size())
    {
      AppMethodBeat.o(49227);
      return null;
    }
    Bundle localBundle = new Bundle();
    if ((this.mlO.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mlO.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mlP.get(paramInt2);
      if (localAppBrandRecentTaskInfo1.jvu != localAppBrandRecentTaskInfo2.jvu) {
        localBundle.putBoolean("star", localAppBrandRecentTaskInfo2.jvu);
      }
      if (!bs.nullAsNil(localAppBrandRecentTaskInfo1.jvt).equals(bs.nullAsNil(localAppBrandRecentTaskInfo2.jvt))) {
        localBundle.putString("icon", localAppBrandRecentTaskInfo2.jvt);
      }
      if (!bs.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(bs.nullAsNil(localAppBrandRecentTaskInfo2.appName))) {
        localBundle.putString("nick_name", localAppBrandRecentTaskInfo2.appName);
      }
    }
    if (localBundle.size() <= 0)
    {
      AppMethodBeat.o(49227);
      return null;
    }
    AppMethodBeat.o(49227);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.m
 * JD-Core Version:    0.7.0.1
 */