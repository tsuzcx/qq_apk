package com.tencent.mm.plugin.messenger.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

public final class c
{
  public static ArrayList<a> agU(String paramString)
  {
    AppMethodBeat.i(90772);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.SysMsgTemplateParser", "hy: null text!!");
      AppMethodBeat.o(90772);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split("\\$");
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (i % 2 == 0) {}
      for (paramString = new a(0, arrayOfString[i]);; paramString = new a(1, arrayOfString[i]))
      {
        localArrayList.add(paramString);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(90772);
    return localArrayList;
  }
  
  public static final class a
  {
    public String content;
    public int type;
    
    public a(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.content = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.c
 * JD-Core Version:    0.7.0.1
 */