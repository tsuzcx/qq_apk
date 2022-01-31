package com.tencent.mm.plugin.freewifi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
{
  private static volatile boolean mMg;
  static Pattern mMh;
  static Pattern mMi;
  
  static
  {
    AppMethodBeat.i(20872);
    mMg = true;
    mMh = Pattern.compile("\"result\":(-?[0-9]+)");
    mMi = Pattern.compile("\"stageName\":\"(.+?)\"");
    AppMethodBeat.o(20872);
  }
  
  static String U(LinkedList<aeb> paramLinkedList)
  {
    AppMethodBeat.i(20871);
    if (paramLinkedList.size() == 0)
    {
      AppMethodBeat.o(20871);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      paramLinkedList = (aeb)localIterator.next();
      localStringBuilder.append("|id=").append(m.Ov(paramLinkedList.id)).append("|");
      String[] arrayOfString = m.Ov(paramLinkedList.wWY).split("\\},");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Matcher localMatcher = mMi.matcher(str);
        paramLinkedList = "";
        if (localMatcher.find()) {
          paramLinkedList = localMatcher.group(1);
        }
        localMatcher = mMh.matcher(str);
        str = "0";
        if (localMatcher.find()) {
          str = localMatcher.group(1);
        }
        localStringBuilder.append(k.Ot(paramLinkedList) + "=" + str).append("|");
        i += 1;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(20871);
    return paramLinkedList;
  }
  
  public static void kS(int paramInt)
  {
    AppMethodBeat.i(20870);
    j.bAO().bAw().post(new b.1(paramInt));
    AppMethodBeat.o(20870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.f.b
 * JD-Core Version:    0.7.0.1
 */