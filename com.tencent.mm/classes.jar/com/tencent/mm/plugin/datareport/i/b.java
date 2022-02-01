package com.tencent.mm.plugin.datareport.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.protocal.protobuf.emk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;

public final class b
  implements a
{
  private static String TAG = "MMDataReportRouter";
  private List<Integer> xhT;
  
  public b()
  {
    AppMethodBeat.i(262867);
    this.xhT = new ArrayList();
    try
    {
      Object localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zqq, "");
      if (!i.hm((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        if ((localObject != null) && (localObject.length > 0))
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            String str = localObject[i];
            this.xhT.add(Integer.valueOf(Integer.parseInt(str)));
            i += 1;
          }
        }
      }
      AppMethodBeat.o(262867);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(262867);
    }
  }
  
  private static String eZ(List<String> paramList)
  {
    AppMethodBeat.i(262873);
    if (paramList == null)
    {
      AppMethodBeat.o(262873);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)paramList.get(i)).append(",");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((String)paramList.get(i));
      }
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(262873);
    return paramList;
  }
  
  public final void a(Object paramObject, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(262935);
    if ((i.hm(paramString)) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(262935);
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (List)com.tencent.mm.plugin.datareport.a.dtn().xgd.get(paramString);
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      ((List)localObject1).addAll((Collection)localObject2);
    }
    localObject2 = com.tencent.mm.plugin.datareport.d.a.h(paramObject, false);
    if (localObject2 != null)
    {
      localObject2 = com.tencent.mm.plugin.datareport.d.a.a((com.tencent.mm.plugin.datareport.d.a.b)localObject2, com.tencent.mm.plugin.datareport.j.b.amz(paramString));
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    paramObject = com.tencent.mm.plugin.datareport.d.a.g(paramObject, false);
    if (paramObject != null)
    {
      paramObject = com.tencent.mm.plugin.datareport.d.a.a(paramObject, com.tencent.mm.plugin.datareport.j.b.amy(paramString));
      if ((paramObject != null) && (paramObject.size() > 0)) {
        ((List)localObject1).addAll(paramObject);
      }
    }
    paramObject = ((List)localObject1).iterator();
    while (paramObject.hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.datareport.a.b.b)paramObject.next();
      if (!this.xhT.contains(Integer.valueOf(((com.tencent.mm.plugin.datareport.a.b.b)localObject2).xgH)))
      {
        if (((com.tencent.mm.plugin.datareport.a.b.b)localObject2).xgI)
        {
          int i = ((com.tencent.mm.plugin.datareport.a.b.b)localObject2).xgH;
          localObject1 = eZ(paramList);
          localObject2 = new b..ExternalSyntheticLambda1((com.tencent.mm.plugin.datareport.a.b.b)localObject2, paramList);
          Object localObject3 = new com.tencent.mm.am.c.a();
          ((com.tencent.mm.am.c.a)localObject3).otE = new emj();
          ((com.tencent.mm.am.c.a)localObject3).otF = new emk();
          ((com.tencent.mm.am.c.a)localObject3).uri = "/cgi-bin/micromsg-bin/rtkvreport";
          ((com.tencent.mm.am.c.a)localObject3).funcId = 716;
          localObject3 = ((com.tencent.mm.am.c.a)localObject3).bEF();
          emj localemj = (emj)c.b.b(((com.tencent.mm.am.c)localObject3).otB);
          localemj.mut = d.Yxb;
          localemj.muu = d.Yxa;
          localemj.muv = d.Yxd;
          localemj.muw = d.Yxe;
          localemj.mux = LocaleUtil.getApplicationLanguage();
          localemj.aaLf = i;
          localemj.OzQ = ((String)localObject1);
          z.a((com.tencent.mm.am.c)localObject3, new b..ExternalSyntheticLambda0(Util.nowMilliSecond(), localemj, (z.a)localObject2));
        }
        for (;;)
        {
          Log.d(TAG, "[route] eventId : " + paramString + ", reportVals : " + eZ(paramList));
          break;
          localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
          com.tencent.mm.plugin.report.service.h.d(((com.tencent.mm.plugin.datareport.a.b.b)localObject2).xgH, eZ(paramList), false, true);
        }
      }
    }
    AppMethodBeat.o(262935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.i.b
 * JD-Core Version:    0.7.0.1
 */