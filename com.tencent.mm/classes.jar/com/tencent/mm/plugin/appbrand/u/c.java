package com.tencent.mm.plugin.appbrand.u;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static LinkedList<e> dtH = new LinkedList();
  private static HashSet<c.a> hkQ = new HashSet();
  private static boolean hkR = false;
  private static boolean hkS = false;
  
  protected static String a(bi parambi, boolean paramBoolean, String paramString)
  {
    if (parambi.field_isSend == 1) {
      paramString = q.Gj();
    }
    String str;
    do
    {
      return paramString;
      str = null;
      if (paramBoolean) {
        str = bd.iI(parambi.field_content);
      }
    } while (bk.bl(str));
    return str;
  }
  
  public static void a(String paramString, c.a parama)
  {
    for (;;)
    {
      try
      {
        if (hkR)
        {
          hkQ.add(parama);
          return;
        }
        if (hkS)
        {
          parama.y(dtH);
          continue;
        }
        hkR = true;
      }
      finally {}
      hkQ.add(parama);
      g.DQ();
      g.DS().O(new c.1(paramString));
    }
  }
  
  private static void done()
  {
    try
    {
      y.i("MicroMsg.AppBrandHistoryListLogic", "done");
      hkS = true;
      hkR = false;
      Iterator localIterator = hkQ.iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala != null) {
          locala.y(dtH);
        }
      }
      hkQ.clear();
    }
    finally {}
  }
  
  public static boolean mv(int paramInt)
  {
    return (33 == paramInt) || (36 == paramInt);
  }
  
  public static void reset()
  {
    try
    {
      hkR = false;
      hkS = false;
      dtH.clear();
      hkQ.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c
 * JD-Core Version:    0.7.0.1
 */