package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private static volatile boolean kqu = true;
  static Pattern kqv = Pattern.compile("\"result\":(-?[0-9]+)");
  static Pattern kqw = Pattern.compile("\"stageName\":\"(.+?)\"");
  
  static String S(LinkedList<zk> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      paramLinkedList = (zk)localIterator.next();
      localStringBuilder.append("|id=").append(m.Dn(paramLinkedList.id)).append("|");
      String[] arrayOfString = m.Dn(paramLinkedList.sYJ).split("\\},");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Matcher localMatcher = kqw.matcher(str);
        paramLinkedList = "";
        if (localMatcher.find()) {
          paramLinkedList = localMatcher.group(1);
        }
        localMatcher = kqv.matcher(str);
        str = "0";
        if (localMatcher.find()) {
          str = localMatcher.group(1);
        }
        localStringBuilder.append(k.Dl(paramLinkedList) + "=" + str).append("|");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void jdMethod_if(int paramInt)
  {
    j.aUm().aTT().post(new b.1(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.f.b
 * JD-Core Version:    0.7.0.1
 */