package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.q;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

public final class ad
  extends q<LocalUsageInfo>
{
  public ad(List<LocalUsageInfo> paramList1, List<LocalUsageInfo> paramList2)
  {
    super(aY(paramList1), aY(paramList2));
    AppMethodBeat.i(44643);
    AppMethodBeat.o(44643);
  }
  
  private static <T> ArrayList<T> aY(List<T> paramList)
  {
    AppMethodBeat.i(44644);
    if ((paramList instanceof ArrayList))
    {
      paramList = (ArrayList)paramList;
      AppMethodBeat.o(44644);
      return paramList;
    }
    if (bt.hj(paramList))
    {
      paramList = new ArrayList(0);
      AppMethodBeat.o(44644);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    localArrayList.addAll(paramList);
    AppMethodBeat.o(44644);
    return localArrayList;
  }
  
  public final Object h(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44647);
    if (paramInt1 >= this.mMq.size())
    {
      AppMethodBeat.o(44647);
      return null;
    }
    Bundle localBundle = new Bundle();
    try
    {
      LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.mMq.get(paramInt1);
      LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.mMr.get(paramInt2);
      if (!bt.nullAsNil(localLocalUsageInfo1.jPZ).equals(localLocalUsageInfo2.jPZ)) {
        localBundle.putString("icon", localLocalUsageInfo2.jPZ);
      }
      if (!bt.nullAsNil(localLocalUsageInfo1.nickname).equals(localLocalUsageInfo2.nickname)) {
        localBundle.putString("nick_name", localLocalUsageInfo2.nickname);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localBundle.clear();
      }
      AppMethodBeat.o(44647);
    }
    if (localBundle.size() <= 0)
    {
      AppMethodBeat.o(44647);
      return null;
    }
    return localBundle;
  }
  
  public final boolean i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44645);
    LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.mMq.get(paramInt1);
    LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.mMr.get(paramInt2);
    if ((bt.nullAsNil(localLocalUsageInfo1.username).equals(localLocalUsageInfo2.username)) && (localLocalUsageInfo1.hQh == localLocalUsageInfo2.hQh))
    {
      AppMethodBeat.o(44645);
      return true;
    }
    AppMethodBeat.o(44645);
    return false;
  }
  
  public final boolean j(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44646);
    LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.mMq.get(paramInt1);
    LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.mMr.get(paramInt2);
    boolean bool = bt.nullAsNil(localLocalUsageInfo1.jPZ).equals(localLocalUsageInfo2.jPZ);
    AppMethodBeat.o(44646);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ad
 * JD-Core Version:    0.7.0.1
 */