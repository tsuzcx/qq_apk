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
  
  public final Object h(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49227);
    if (paramInt1 >= this.oew.size())
    {
      AppMethodBeat.o(49227);
      return null;
    }
    Bundle localBundle = new Bundle();
    if ((this.oew.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.oew.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.oex.get(paramInt2);
      if (localAppBrandRecentTaskInfo1.kVp != localAppBrandRecentTaskInfo2.kVp) {
        localBundle.putBoolean("star", localAppBrandRecentTaskInfo2.kVp);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.kVo).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.kVo))) {
        localBundle.putString("icon", localAppBrandRecentTaskInfo2.kVo);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.appName))) {
        localBundle.putString("nick_name", localAppBrandRecentTaskInfo2.appName);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.kWd).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.kWd))) {
        localBundle.putString("third_party_app_using_desc", localAppBrandRecentTaskInfo2.kWd);
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
    if (!this.oew.get(paramInt1).getClass().equals(this.oex.get(paramInt2).getClass()))
    {
      AppMethodBeat.o(49225);
      return false;
    }
    if ((this.oew.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.oew.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.oex.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.eix == localAppBrandRecentTaskInfo2.eix) && (localAppBrandRecentTaskInfo1.dCl.equals(localAppBrandRecentTaskInfo2.dCl)))
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
    if ((this.oew.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.oew.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.oex.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.kVp == localAppBrandRecentTaskInfo2.kVp) && (Util.nullAsNil(localAppBrandRecentTaskInfo1.kVo).equals(localAppBrandRecentTaskInfo2.kVo)) && (Util.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.m
 * JD-Core Version:    0.7.0.1
 */