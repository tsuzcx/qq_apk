package com.tencent.mm.bs;

import com.tencent.mm.model.au;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> sox = new HashMap();
  
  public static void EA(int paramInt)
  {
    int i = bk.g((Integer)sox.get(Integer.valueOf(paramInt)));
    sox.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
  }
  
  public static void Xn(String paramString)
  {
    paramString = paramString + coA();
    Iterator localIterator = sox.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry != null) && (localEntry.getKey() != null) && (localEntry.getValue() != null) && (((Integer)localEntry.getValue()).intValue() != 0))
      {
        localStringBuilder.append(localEntry.getKey());
        localStringBuilder.append('=');
        localStringBuilder.append(localEntry.getValue());
        localStringBuilder.append(',');
      }
    }
    sox.clear();
    if (localStringBuilder.length() > 0)
    {
      y.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      bt.o(10, localStringBuilder.toString());
    }
    paramString = paramString + coA();
    y.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :" + paramString);
    try
    {
      au.Hx();
      c.Dz().o(66819, Long.valueOf(bk.UX()));
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
    }
  }
  
  public static String coA()
  {
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (au.Hx() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (au.Hx() != null) {
        break;
      }
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    au.Hx();
    if (c.Dz() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!au.DK()) {
        break label137;
      }
    }
    label137:
    for (str = "1";; str = "0")
    {
      return str + "]";
      str = "1";
      break;
    }
  }
  
  public static void run()
  {
    au.Hx();
    if (bk.cn(bk.a((Long)c.Dz().get(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        Xn("");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bs.a
 * JD-Core Version:    0.7.0.1
 */