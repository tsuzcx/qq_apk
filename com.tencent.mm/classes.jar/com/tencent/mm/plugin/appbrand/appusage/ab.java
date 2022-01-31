package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ui.recents.r;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

public final class ab
  extends r<LocalUsageInfo>
{
  public ab(List<LocalUsageInfo> paramList1, List<LocalUsageInfo> paramList2)
  {
    super(as(paramList1), as(paramList2));
  }
  
  private static <T> ArrayList<T> as(List<T> paramList)
  {
    if ((paramList instanceof ArrayList)) {
      return (ArrayList)paramList;
    }
    if (bk.dk(paramList)) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public final boolean C(int paramInt1, int paramInt2)
  {
    LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.hjX.get(paramInt1);
    LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.hjY.get(paramInt2);
    return (bk.pm(localLocalUsageInfo1.username).equals(localLocalUsageInfo2.username)) && (localLocalUsageInfo1.fJy == localLocalUsageInfo2.fJy);
  }
  
  public final boolean D(int paramInt1, int paramInt2)
  {
    LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.hjX.get(paramInt1);
    LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.hjY.get(paramInt2);
    return bk.pm(localLocalUsageInfo1.fJY).equals(localLocalUsageInfo2.fJY);
  }
  
  public final Object E(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.hjX.size()) {
      return null;
    }
    Bundle localBundle = new Bundle();
    try
    {
      LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.hjX.get(paramInt1);
      LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.hjY.get(paramInt2);
      if (!bk.pm(localLocalUsageInfo1.fJY).equals(localLocalUsageInfo2.fJY)) {
        localBundle.putString("icon", localLocalUsageInfo2.fJY);
      }
      if (!bk.pm(localLocalUsageInfo1.nickname).equals(localLocalUsageInfo2.nickname)) {
        localBundle.putString("nick_name", localLocalUsageInfo2.nickname);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localBundle.clear();
      }
    }
    if (localBundle.size() <= 0) {
      return null;
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ab
 * JD-Core Version:    0.7.0.1
 */