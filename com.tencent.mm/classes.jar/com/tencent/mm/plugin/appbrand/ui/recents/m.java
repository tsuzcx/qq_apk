package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

final class m
  extends q<Object>
{
  m(ArrayList<?> paramArrayList1, ArrayList<?> paramArrayList2)
  {
    super(paramArrayList1, paramArrayList2);
  }
  
  public final Object h(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49227);
    if (paramInt1 >= this.mMq.size())
    {
      AppMethodBeat.o(49227);
      return null;
    }
    Bundle localBundle = new Bundle();
    if ((this.mMq.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mMq.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mMr.get(paramInt2);
      if (localAppBrandRecentTaskInfo1.jPn != localAppBrandRecentTaskInfo2.jPn) {
        localBundle.putBoolean("star", localAppBrandRecentTaskInfo2.jPn);
      }
      if (!bt.nullAsNil(localAppBrandRecentTaskInfo1.jPm).equals(bt.nullAsNil(localAppBrandRecentTaskInfo2.jPm))) {
        localBundle.putString("icon", localAppBrandRecentTaskInfo2.jPm);
      }
      if (!bt.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(bt.nullAsNil(localAppBrandRecentTaskInfo2.appName))) {
        localBundle.putString("nick_name", localAppBrandRecentTaskInfo2.appName);
      }
      if (!bt.nullAsNil(localAppBrandRecentTaskInfo1.jQd).equals(bt.nullAsNil(localAppBrandRecentTaskInfo2.jQd))) {
        localBundle.putString("third_party_app_using_desc", localAppBrandRecentTaskInfo2.jQd);
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
  
  public final boolean i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49225);
    if (!this.mMq.get(paramInt1).getClass().equals(this.mMr.get(paramInt2).getClass()))
    {
      AppMethodBeat.o(49225);
      return false;
    }
    if ((this.mMq.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mMq.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mMr.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.dPf == localAppBrandRecentTaskInfo2.dPf) && (localAppBrandRecentTaskInfo1.djX.equals(localAppBrandRecentTaskInfo2.djX)))
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
  
  public final boolean j(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49226);
    if ((this.mMq.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mMq.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mMr.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.jPn == localAppBrandRecentTaskInfo2.jPn) && (bt.nullAsNil(localAppBrandRecentTaskInfo1.jPm).equals(localAppBrandRecentTaskInfo2.jPm)) && (bt.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.m
 * JD-Core Version:    0.7.0.1
 */