package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class b
{
  public static ArrayList<b.a> TQ(String paramString)
  {
    AppMethodBeat.i(136941);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.SysMsgTemplateParser", "hy: null text!!");
      AppMethodBeat.o(136941);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split("\\$");
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (i % 2 == 0) {}
      for (paramString = new b.a(0, arrayOfString[i]);; paramString = new b.a(1, arrayOfString[i]))
      {
        localArrayList.add(paramString);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(136941);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.b
 * JD-Core Version:    0.7.0.1
 */