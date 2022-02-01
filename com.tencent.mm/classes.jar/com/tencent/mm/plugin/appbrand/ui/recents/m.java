package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bu;
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
    if (paramInt1 >= this.mRt.size())
    {
      AppMethodBeat.o(49227);
      return null;
    }
    Bundle localBundle = new Bundle();
    if ((this.mRt.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mRt.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mRu.get(paramInt2);
      if (localAppBrandRecentTaskInfo1.jSF != localAppBrandRecentTaskInfo2.jSF) {
        localBundle.putBoolean("star", localAppBrandRecentTaskInfo2.jSF);
      }
      if (!bu.nullAsNil(localAppBrandRecentTaskInfo1.jSE).equals(bu.nullAsNil(localAppBrandRecentTaskInfo2.jSE))) {
        localBundle.putString("icon", localAppBrandRecentTaskInfo2.jSE);
      }
      if (!bu.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(bu.nullAsNil(localAppBrandRecentTaskInfo2.appName))) {
        localBundle.putString("nick_name", localAppBrandRecentTaskInfo2.appName);
      }
      if (!bu.nullAsNil(localAppBrandRecentTaskInfo1.jTv).equals(bu.nullAsNil(localAppBrandRecentTaskInfo2.jTv))) {
        localBundle.putString("third_party_app_using_desc", localAppBrandRecentTaskInfo2.jTv);
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
    if (!this.mRt.get(paramInt1).getClass().equals(this.mRu.get(paramInt2).getClass()))
    {
      AppMethodBeat.o(49225);
      return false;
    }
    if ((this.mRt.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mRt.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mRu.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.dQv == localAppBrandRecentTaskInfo2.dQv) && (localAppBrandRecentTaskInfo1.dkZ.equals(localAppBrandRecentTaskInfo2.dkZ)))
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
    if ((this.mRt.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.mRt.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.mRu.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.jSF == localAppBrandRecentTaskInfo2.jSF) && (bu.nullAsNil(localAppBrandRecentTaskInfo1.jSE).equals(localAppBrandRecentTaskInfo2.jSE)) && (bu.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)))
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