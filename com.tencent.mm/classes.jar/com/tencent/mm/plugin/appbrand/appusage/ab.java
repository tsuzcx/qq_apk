package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.r;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class ab
  extends r<LocalUsageInfo>
{
  public ab(List<LocalUsageInfo> paramList1, List<LocalUsageInfo> paramList2)
  {
    super(aB(paramList1), aB(paramList2));
    AppMethodBeat.i(129710);
    AppMethodBeat.o(129710);
  }
  
  private static <T> ArrayList<T> aB(List<T> paramList)
  {
    AppMethodBeat.i(129711);
    if ((paramList instanceof ArrayList))
    {
      paramList = (ArrayList)paramList;
      AppMethodBeat.o(129711);
      return paramList;
    }
    if (bo.es(paramList))
    {
      paramList = new ArrayList(0);
      AppMethodBeat.o(129711);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    localArrayList.addAll(paramList);
    AppMethodBeat.o(129711);
    return localArrayList;
  }
  
  public final boolean F(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129712);
    LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.iVE.get(paramInt1);
    LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.iVF.get(paramInt2);
    if ((bo.nullAsNil(localLocalUsageInfo1.username).equals(localLocalUsageInfo2.username)) && (localLocalUsageInfo1.hcr == localLocalUsageInfo2.hcr))
    {
      AppMethodBeat.o(129712);
      return true;
    }
    AppMethodBeat.o(129712);
    return false;
  }
  
  public final boolean G(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129713);
    LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.iVE.get(paramInt1);
    LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.iVF.get(paramInt2);
    boolean bool = bo.nullAsNil(localLocalUsageInfo1.hcN).equals(localLocalUsageInfo2.hcN);
    AppMethodBeat.o(129713);
    return bool;
  }
  
  public final Object H(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129714);
    if (paramInt1 >= this.iVE.size())
    {
      AppMethodBeat.o(129714);
      return null;
    }
    Bundle localBundle = new Bundle();
    try
    {
      LocalUsageInfo localLocalUsageInfo1 = (LocalUsageInfo)this.iVE.get(paramInt1);
      LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)this.iVF.get(paramInt2);
      if (!bo.nullAsNil(localLocalUsageInfo1.hcN).equals(localLocalUsageInfo2.hcN)) {
        localBundle.putString("icon", localLocalUsageInfo2.hcN);
      }
      if (!bo.nullAsNil(localLocalUsageInfo1.nickname).equals(localLocalUsageInfo2.nickname)) {
        localBundle.putString("nick_name", localLocalUsageInfo2.nickname);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localBundle.clear();
      }
      AppMethodBeat.o(129714);
    }
    if (localBundle.size() <= 0)
    {
      AppMethodBeat.o(129714);
      return null;
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ab
 * JD-Core Version:    0.7.0.1
 */