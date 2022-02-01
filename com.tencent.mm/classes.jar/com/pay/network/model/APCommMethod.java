package com.pay.network.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class APCommMethod
{
  public static void transformStrToList(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(193304);
    int i = paramString.indexOf("[");
    int j = paramString.indexOf("]");
    paramList.clear();
    if ((i != -1) && (j != -1) && (j > i))
    {
      paramString = paramString.substring(i + 1, j);
      if (paramString.length() != 0)
      {
        paramString = paramString.split(",");
        j = paramString.length;
        i = 0;
        while (i < j)
        {
          paramList.add(paramString[i]);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(193304);
  }
  
  public static void transformStrToMpInfoList(String paramString, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(193303);
    int i = paramString.indexOf("[");
    int j = paramString.indexOf("]");
    if ((i != -1) && (j != -1) && (j > i))
    {
      paramString = paramString.substring(i + 1, j);
      if (paramString.length() == 0)
      {
        paramList1.clear();
        paramList2.clear();
        AppMethodBeat.o(193303);
        return;
      }
      paramString = paramString.split(",");
      j = paramString.length;
      if ((j > 0) && (j % 2 == 0))
      {
        paramList1.clear();
        paramList2.clear();
        i = 0;
        while (i < j / 2)
        {
          Object localObject1 = paramString[(i * 2)];
          Object localObject2 = paramString[(i * 2 + 1)];
          paramList1.add(localObject1);
          paramList2.add(localObject2);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(193303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.pay.network.model.APCommMethod
 * JD-Core Version:    0.7.0.1
 */