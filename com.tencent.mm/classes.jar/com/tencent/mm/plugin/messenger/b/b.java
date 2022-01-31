package com.tencent.mm.plugin.messenger.b;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class b
{
  public static ArrayList<b.a> Ig(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.SysMsgTemplateParser", "hy: null text!!");
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
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.b
 * JD-Core Version:    0.7.0.1
 */