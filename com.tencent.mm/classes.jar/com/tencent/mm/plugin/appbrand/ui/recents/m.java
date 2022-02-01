package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

final class m
  extends q<Object>
{
  m(ArrayList<?> paramArrayList1, ArrayList<?> paramArrayList2)
  {
    super(paramArrayList1, paramArrayList2);
  }
  
  public final Object Y(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49227);
    if (paramInt1 >= this.rgi.size())
    {
      AppMethodBeat.o(49227);
      return null;
    }
    Bundle localBundle = new Bundle();
    if ((this.rgi.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.rgi.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.rgj.get(paramInt2);
      if (localAppBrandRecentTaskInfo1.nPC != localAppBrandRecentTaskInfo2.nPC) {
        localBundle.putBoolean("star", localAppBrandRecentTaskInfo2.nPC);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.nPB).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.nPB))) {
        localBundle.putString("icon", localAppBrandRecentTaskInfo2.nPB);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.appName))) {
        localBundle.putString("nick_name", localAppBrandRecentTaskInfo2.appName);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.nQq).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.nQq))) {
        localBundle.putString("third_party_app_using_desc", localAppBrandRecentTaskInfo2.nQq);
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
  
  public final boolean Z(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49225);
    if (!this.rgi.get(paramInt1).getClass().equals(this.rgj.get(paramInt2).getClass()))
    {
      AppMethodBeat.o(49225);
      return false;
    }
    if ((this.rgi.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.rgi.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.rgj.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.cBI == localAppBrandRecentTaskInfo2.cBI) && (localAppBrandRecentTaskInfo1.fuO.equals(localAppBrandRecentTaskInfo2.fuO)))
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
  
  public final boolean ab(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49226);
    if ((this.rgi.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.rgi.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.rgj.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.nPC == localAppBrandRecentTaskInfo2.nPC) && (Util.nullAsNil(localAppBrandRecentTaskInfo1.nPB).equals(localAppBrandRecentTaskInfo2.nPB)) && (Util.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.m
 * JD-Core Version:    0.7.0.1
 */