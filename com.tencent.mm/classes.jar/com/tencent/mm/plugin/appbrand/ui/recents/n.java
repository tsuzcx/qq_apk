package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

final class n
  extends r<Object>
{
  n(ArrayList<?> paramArrayList1, ArrayList<?> paramArrayList2)
  {
    super(paramArrayList1, paramArrayList2);
  }
  
  public final boolean F(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133497);
    if (!this.iVE.get(paramInt1).getClass().equals(this.iVF.get(paramInt2).getClass()))
    {
      AppMethodBeat.o(133497);
      return false;
    }
    if ((this.iVE.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.iVE.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.iVF.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.gXd == localAppBrandRecentTaskInfo2.gXd) && (localAppBrandRecentTaskInfo1.cmx.equals(localAppBrandRecentTaskInfo2.cmx)))
      {
        AppMethodBeat.o(133497);
        return true;
      }
      AppMethodBeat.o(133497);
      return false;
    }
    AppMethodBeat.o(133497);
    return false;
  }
  
  public final boolean G(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133498);
    if ((this.iVE.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.iVE.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.iVF.get(paramInt2);
      if ((localAppBrandRecentTaskInfo1.hcd == localAppBrandRecentTaskInfo2.hcd) && (bo.nullAsNil(localAppBrandRecentTaskInfo1.hcc).equals(localAppBrandRecentTaskInfo2.hcc)) && (bo.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)))
      {
        AppMethodBeat.o(133498);
        return true;
      }
      AppMethodBeat.o(133498);
      return false;
    }
    AppMethodBeat.o(133498);
    return true;
  }
  
  public final Object H(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133499);
    if (paramInt1 >= this.iVE.size())
    {
      AppMethodBeat.o(133499);
      return null;
    }
    Bundle localBundle = new Bundle();
    if ((this.iVE.get(paramInt1) instanceof AppBrandRecentTaskInfo))
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo1 = (AppBrandRecentTaskInfo)this.iVE.get(paramInt1);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo2 = (AppBrandRecentTaskInfo)this.iVF.get(paramInt2);
      if (localAppBrandRecentTaskInfo1.hcd != localAppBrandRecentTaskInfo2.hcd) {
        localBundle.putBoolean("star", localAppBrandRecentTaskInfo2.hcd);
      }
      if (!bo.nullAsNil(localAppBrandRecentTaskInfo1.hcc).equals(localAppBrandRecentTaskInfo2.hcc)) {
        localBundle.putString("icon", localAppBrandRecentTaskInfo2.hcc);
      }
      if (!bo.nullAsNil(localAppBrandRecentTaskInfo1.appName).equals(localAppBrandRecentTaskInfo2.appName)) {
        localBundle.putString("nick_name", localAppBrandRecentTaskInfo2.appName);
      }
    }
    if (localBundle.size() <= 0)
    {
      AppMethodBeat.o(133499);
      return null;
    }
    AppMethodBeat.o(133499);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */