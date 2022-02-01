package com.tencent.mm.bc;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class a$a
{
  private static HashMap<String, a> lWm = new HashMap();
  
  public static void a(String paramString, a parama)
  {
    Assert.assertNotNull(paramString);
    Assert.assertNotNull(parama);
    synchronized (lWm)
    {
      lWm.put(paramString.toLowerCase(), parama);
      return;
    }
  }
  
  public static a b(Map<String, String> paramMap, ca paramca)
  {
    if (paramMap == null)
    {
      Log.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
      return null;
    }
    String str = Util.nullAs((String)paramMap.get(".sysmsg.$type"), "");
    synchronized (lWm)
    {
      a locala = (a)lWm.get(str.toLowerCase());
      if (locala == null)
      {
        Log.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
        return null;
      }
      paramMap = locala.a(paramMap, paramca);
      return paramMap;
    }
  }
  
  public abstract a a(Map<String, String> paramMap, ca paramca);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bc.a.a
 * JD-Core Version:    0.7.0.1
 */