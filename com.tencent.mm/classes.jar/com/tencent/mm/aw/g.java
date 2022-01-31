package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class g
  extends f
{
  public static e a(j.b paramb, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108011);
    if (paramb == null)
    {
      AppMethodBeat.o(108011);
      return null;
    }
    e locale = new e();
    locale.fKh = 0;
    locale.fKj = paramString1;
    locale.fKk = 0.0F;
    locale.fKn = "";
    locale.fKo = paramString2;
    locale.fKt = paramString4;
    locale.fKi = 1;
    locale.fKs = null;
    locale.fKl = paramb.title;
    locale.fKm = paramb.description;
    locale.fKr = paramb.url;
    if (!bo.isNullOrNil(paramb.fgV)) {}
    for (paramString1 = paramb.fgV;; paramString1 = paramb.fgv)
    {
      locale.fKq = paramString1;
      locale.fKp = paramb.fgU;
      locale.fKw = paramb.appId;
      locale.fKu = paramString3;
      AppMethodBeat.o(108011);
      return locale;
    }
  }
  
  public static e a(String paramString, TimeLineObject paramTimeLineObject, int paramInt)
  {
    String str = null;
    AppMethodBeat.i(108010);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.xTS == null) || (paramTimeLineObject.xTS.wOa == null) || (paramTimeLineObject.xTS.wOa.size() <= 0))
    {
      AppMethodBeat.o(108010);
      return null;
    }
    bcs localbcs = (bcs)paramTimeLineObject.xTS.wOa.get(0);
    if (localbcs == null)
    {
      AppMethodBeat.o(108010);
      return null;
    }
    e locale = new e();
    locale.fKh = paramInt;
    locale.fKj = paramTimeLineObject.Id;
    locale.fKk = 0.0F;
    locale.fKn = "";
    locale.fKo = localbcs.xrS;
    locale.fKt = null;
    locale.fKi = 1;
    locale.fKs = null;
    locale.fKl = localbcs.Title;
    locale.fKm = localbcs.Desc;
    if (paramTimeLineObject.xTS != null) {
      str = paramTimeLineObject.xTS.Url;
    }
    locale.fKr = str;
    locale.fKq = localbcs.xrW;
    locale.fKp = localbcs.Url;
    locale.fKx = localbcs.xrT;
    locale.fKz = localbcs.Id;
    locale.fKu = paramString;
    locale.fKw = paramTimeLineObject.xTR.Id;
    locale.fKD = paramTimeLineObject.jJA;
    AppMethodBeat.o(108010);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aw.g
 * JD-Core Version:    0.7.0.1
 */