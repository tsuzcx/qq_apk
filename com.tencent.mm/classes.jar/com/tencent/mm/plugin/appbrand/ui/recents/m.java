package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

final class m
  extends r<Object>
{
  m(ArrayList<?> paramArrayList1, ArrayList<?> paramArrayList2)
  {
    super(paramArrayList1, paramArrayList2);
  }
  
  public final boolean C(int paramInt1, int paramInt2)
  {
    if (!this.hjX.get(paramInt1).getClass().equals(this.hjY.get(paramInt2).getClass())) {
      return false;
    }
    if ((this.hjX.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.hjX.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.hjY.get(paramInt2);
      return (localAppBrandRecentTaskInfo1.fEL == localAppBrandRecentTaskInfo2.fEL) && (localAppBrandRecentTaskInfo1.bFn.equals(localAppBrandRecentTaskInfo2.bFn));
    }
    return false;
  }
  
  public final boolean D(int paramInt1, int paramInt2)
  {
    if ((this.hjX.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.hjX.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.hjY.get(paramInt2);
      long l = localAppBrandRecentTaskInfo1.fKa;
      l = localAppBrandRecentTaskInfo2.fKa;
      return (localAppBrandRecentTaskInfo1.fJl == localAppBrandRecentTaskInfo2.fJl) && (bk.pm(localAppBrandRecentTaskInfo1.fJk).equals(localAppBrandRecentTaskInfo2.fJk)) && (bk.pm(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName));
    }
    return true;
  }
  
  public final Object E(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.hjX.size()) {
      return null;
    }
    Bundle localBundle = new Bundle();
    if ((this.hjX.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.hjX.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.hjY.get(paramInt2);
      if (localAppBrandRecentTaskInfo1.fJl != localAppBrandRecentTaskInfo2.fJl) {
        localBundle.putBoolean("star", localAppBrandRecentTaskInfo2.fJl);
      }
      if (!bk.pm(localAppBrandRecentTaskInfo1.fJk).equals(localAppBrandRecentTaskInfo2.fJk)) {
        localBundle.putString("icon", localAppBrandRecentTaskInfo2.fJk);
      }
      if (!bk.pm(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)) {
        localBundle.putString("nick_name", localAppBrandRecentTaskInfo2.appName);
      }
    }
    if (localBundle.size() <= 0) {
      return null;
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.m
 * JD-Core Version:    0.7.0.1
 */