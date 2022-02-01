package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppUserAuthorizeScopeListWithAttrs;", "", "fetchStatus", "", "userAuthScopeList", "", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppAuthorizeScopeListWithAttrs;", "allShownScopeList", "", "(ILjava/util/List;Ljava/util/List;)V", "getAllShownScopeList", "()Ljava/util/List;", "getFetchStatus", "()I", "getUserAuthScopeList", "getNextFetchToken", "()Ljava/lang/Integer;", "hasMoreInfo", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  private final int ujA;
  final List<j> ujB;
  final List<String> ujC;
  
  public l(int paramInt, List<j> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(322999);
    this.ujA = paramInt;
    this.ujB = paramList;
    this.ujC = paramList1;
    AppMethodBeat.o(322999);
  }
  
  public final boolean cMv()
  {
    return 1 == this.ujA;
  }
  
  public final Integer cMw()
  {
    AppMethodBeat.i(323020);
    if (cMv())
    {
      j localj = (j)p.oN(this.ujB);
      if (localj != null)
      {
        int i = localj.hdp;
        AppMethodBeat.o(323020);
        return Integer.valueOf(i);
      }
    }
    AppMethodBeat.o(323020);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.l
 * JD-Core Version:    0.7.0.1
 */