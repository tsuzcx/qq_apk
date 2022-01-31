package com.tencent.mm.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  public String bvy;
  private Map<String, i.a> bvz = new HashMap();
  public int versionCode;
  
  public i(String paramString, int paramInt)
  {
    if (paramString == null) {}
    for (this.bvy = "http://dldir1.qq.com/weixin/android/";; this.bvy = paramString)
    {
      this.versionCode = paramInt;
      return;
    }
  }
  
  public static i cf(String paramString)
  {
    Map localMap = f.s(paramString, "patchupdate");
    if (localMap == null) {
      return null;
    }
    i locali = new i((String)localMap.get(".patchupdate.$base"), j.getInt((String)localMap.get(".patchupdate.$versioncode"), 0));
    int k = j.getInt((String)localMap.get(".patchupdate.$count"), 0);
    int i = 0;
    if (i >= k) {
      return locali;
    }
    StringBuilder localStringBuilder = new StringBuilder(".patchupdate.item");
    if (i > 0)
    {
      paramString = Integer.valueOf(i);
      label99:
      paramString = paramString;
      paramString = new i.a((String)localMap.get(paramString + ".$old"), (String)localMap.get(paramString + ".$new"), (String)localMap.get(paramString + ".$patch"), (String)localMap.get(paramString + ".$url"), j.getInt((String)localMap.get(paramString + ".$size"), 0));
      if ((paramString.bvA == null) || (paramString.bvB == null) || (paramString.bvC == null) || (paramString.url == null)) {
        break label329;
      }
    }
    label329:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        locali.bvz.put(paramString.bvA, paramString);
      }
      i += 1;
      break;
      paramString = "";
      break label99;
    }
  }
  
  public final void a(i.a parama)
  {
    this.bvz.put(parama.bvA, parama);
  }
  
  public final i.a ce(String paramString)
  {
    return (i.a)this.bvz.get(paramString);
  }
  
  public final String st()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[] { this.bvy, Integer.valueOf(this.bvz.size()), Integer.valueOf(this.versionCode) }));
    Iterator localIterator = this.bvz.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localStringBuilder.append("</patchupdate>");
        return localStringBuilder.toString();
      }
      i.a locala = (i.a)((Map.Entry)localIterator.next()).getValue();
      localStringBuilder.append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[] { locala.bvA, locala.bvB, locala.bvC, locala.url, Integer.valueOf(locala.size) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.c.i
 * JD-Core Version:    0.7.0.1
 */