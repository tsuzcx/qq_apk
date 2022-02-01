package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

final class l
  extends p<Object>
{
  l(ArrayList<?> paramArrayList1, ArrayList<?> paramArrayList2)
  {
    super(paramArrayList1, paramArrayList2);
  }
  
  public final Object aT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49227);
    if (paramInt1 >= this.uoj.size())
    {
      AppMethodBeat.o(49227);
      return null;
    }
    Bundle localBundle = new Bundle();
    if ((this.uoj.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.uoj.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.uok.get(paramInt2);
      if (localAppBrandRecentTaskInfo1.qPu != localAppBrandRecentTaskInfo2.qPu) {
        localBundle.putBoolean("star", localAppBrandRecentTaskInfo2.qPu);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.qPt).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.qPt))) {
        localBundle.putString("icon", localAppBrandRecentTaskInfo2.qPt);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.appName))) {
        localBundle.putString("nick_name", localAppBrandRecentTaskInfo2.appName);
      }
      if (!Util.nullAsNil(localAppBrandRecentTaskInfo1.qQf).equals(Util.nullAsNil(localAppBrandRecentTaskInfo2.qQf))) {
        localBundle.putString("third_party_app_using_desc", localAppBrandRecentTaskInfo2.qQf);
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
  
  public final boolean aU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49225);
    if (!this.uoj.get(paramInt1).getClass().equals(this.uok.get(paramInt2).getClass()))
    {
      AppMethodBeat.o(49225);
      return false;
    }
    if ((this.uoj.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.uoj.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.uok.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.eul == localAppBrandRecentTaskInfo2.eul) && (localAppBrandRecentTaskInfo1.hzi.equals(localAppBrandRecentTaskInfo2.hzi)))
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
  
  public final boolean aV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49226);
    if ((this.uoj.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.uoj.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.uok.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.qPu == localAppBrandRecentTaskInfo2.qPu) && (Util.nullAsNil(localAppBrandRecentTaskInfo1.qPt).equals(localAppBrandRecentTaskInfo2.qPt)) && (Util.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.l
 * JD-Core Version:    0.7.0.1
 */