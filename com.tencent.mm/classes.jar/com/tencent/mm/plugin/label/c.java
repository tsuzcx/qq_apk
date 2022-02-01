package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.List;

public final class c
{
  public static void d(long paramLong1, long paramLong2, final long paramLong3, long paramLong4, final long paramLong5)
  {
    AppMethodBeat.i(268626);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268637);
        ay localay = new ay();
        localay.ipZ = this.JUb;
        localay.ila = paramLong3;
        localay.iqa = paramLong5;
        localay.iqb = this.JUd;
        localay.iqc = this.JUe;
        localay.bMH();
        Log.i("MicroMsg.Label.LabelUtils", "24176 setSource = " + this.JUb + ",setAction = " + paramLong3 + ",setOperate_label_cnt = " + paramLong5 + ",setAdd_member_cnt = " + this.JUd + ",setRemove_member_cnt = " + this.JUe);
        AppMethodBeat.o(268637);
      }
    });
    AppMethodBeat.o(268626);
  }
  
  public static String iF(List<String> paramList)
  {
    AppMethodBeat.i(26131);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)paramList.get(i));
        if (i < j - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append("");
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(26131);
    return paramList;
  }
  
  public static String jQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26129);
    Log.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26129);
      return paramString1;
    }
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = paramString2 + "";
      AppMethodBeat.o(26129);
      return paramString1;
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    paramString1 = Util.stringsToList(str.split(","));
    if ((paramString1 != null) && (paramString1.contains(paramString2)))
    {
      paramString1 = str + "";
      AppMethodBeat.o(26129);
      return paramString1;
    }
    paramString1 = str + "," + paramString2 + "";
    AppMethodBeat.o(26129);
    return paramString1;
  }
  
  public static String jR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26130);
    Log.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(26130);
      return paramString1;
    }
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(26130);
      return "";
    }
    String str = paramString1;
    if (paramString1.endsWith("")) {
      str = paramString1.replace("", "");
    }
    paramString1 = Util.stringsToList(str.split(","));
    if (paramString1.contains(paramString2))
    {
      paramString1.remove(paramString2);
      paramString1 = iF(paramString1);
      AppMethodBeat.o(26130);
      return paramString1;
    }
    AppMethodBeat.o(26130);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.c
 * JD-Core Version:    0.7.0.1
 */