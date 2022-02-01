package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class ab
  extends p<LocalUsageInfo>
{
  public ab(List<LocalUsageInfo> paramList1, List<LocalUsageInfo> paramList2)
  {
    super(cU(paramList1), cU(paramList2));
    AppMethodBeat.i(44643);
    AppMethodBeat.o(44643);
  }
  
  private static <T> ArrayList<T> cU(List<T> paramList)
  {
    AppMethodBeat.i(44644);
    if ((paramList instanceof ArrayList))
    {
      paramList = (ArrayList)paramList;
      AppMethodBeat.o(44644);
      return paramList;
    }
    if (Util.isNullOrNil(paramList))
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
  
  public final Object aT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44647);
    if (paramInt1 >= this.uoj.size())
    {
      AppMethodBeat.o(44647);
      return null;
    }
    Bundle localBundle = new Bundle();
    try
    {
      LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.uoj.get(paramInt1);
      LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.uok.get(paramInt2);
      if (!Util.nullAsNil(localLocalUsageInfo1.qQb).equals(localLocalUsageInfo2.qQb)) {
        localBundle.putString("icon", localLocalUsageInfo2.qQb);
      }
      if (!Util.nullAsNil(localLocalUsageInfo1.nickname).equals(localLocalUsageInfo2.nickname)) {
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
  
  public final boolean aU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44645);
    LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.uoj.get(paramInt1);
    LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.uok.get(paramInt2);
    if ((Util.nullAsNil(localLocalUsageInfo1.username).equals(localLocalUsageInfo2.username)) && (localLocalUsageInfo1.euz == localLocalUsageInfo2.euz))
    {
      AppMethodBeat.o(44645);
      return true;
    }
    AppMethodBeat.o(44645);
    return false;
  }
  
  public final boolean aV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44646);
    LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.uoj.get(paramInt1);
    LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.uok.get(paramInt2);
    boolean bool = Util.nullAsNil(localLocalUsageInfo1.qQb).equals(localLocalUsageInfo2.qQb);
    AppMethodBeat.o(44646);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ab
 * JD-Core Version:    0.7.0.1
 */