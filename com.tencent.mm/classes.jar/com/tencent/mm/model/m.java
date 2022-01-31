package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class m
{
  public static List<Boolean> P(List<String> paramList)
  {
    AppMethodBeat.i(5508);
    if (paramList == null)
    {
      AppMethodBeat.o(5508);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    String str;
    boolean bool2;
    long l2;
    long l1;
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      if (!t.lA(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((j)g.E(j.class)).YF().arH(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((au)localObject).field_lastSeq != 0L)
          {
            l1 = l3;
            bool1 = bool3;
            if (((j)g.E(j.class)).bPQ().ah(str, ((au)localObject).field_lastSeq).field_msgId == 0L)
            {
              l1 = ((au)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((au)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((ak)localObject).fN(0L);
            ((ak)localObject).fM(0L);
            ((j)g.E(j.class)).YF().a((ak)localObject, str);
            ab.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label398;
        }
        localObject = ((j)g.E(j.class)).bPQ().TG(str);
        if ((localObject == null) || (((dd)localObject).field_msgId == 0L)) {
          break label398;
        }
      }
    }
    label398:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((j)g.E(j.class)).bPQ().TF(str);
      }
      if (l1 != 0L) {
        ((j)g.E(j.class)).Zc().ad(str, l1);
      }
      ab.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[] { str, Boolean.valueOf(bool1), Long.valueOf(l1) });
      break;
      AppMethodBeat.o(5508);
      return localArrayList;
    }
  }
  
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(5509);
    a(paramString1, paramList, paramString2, paramBoolean, paramString3, 2);
    AppMethodBeat.o(5509);
  }
  
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    AppMethodBeat.i(5510);
    bi localbi = new bi();
    localbi.kj(paramString1);
    localbi.setType(10000);
    localbi.fQ(System.currentTimeMillis());
    localbi.setStatus(4);
    localbi.hL(paramInt);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = r.Zn();
      String str2 = ah.getContext().getString(2131298140);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          ad localad = ((j)g.E(j.class)).YA().arw(str3);
          if ((localad != null) && ((int)localad.euF != 0))
          {
            if (paramBoolean) {
              paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + d(localad) + "</a>" + str2);
            } else {
              paramString1.append(d(localad) + str2);
            }
          }
          else if (paramBoolean) {
            paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + str3 + "</a>" + str2);
          } else {
            paramString1.append(str3 + str2);
          }
        }
      }
      if (paramString1.length() > 0) {
        paramString1.deleteCharAt(paramString1.lastIndexOf(str2));
      }
    }
    localbi.setContent(paramString2.replace("%s", paramString1));
    ((j)g.E(j.class)).bPQ().Z(localbi);
    AppMethodBeat.o(5510);
  }
  
  private static String d(ad paramad)
  {
    AppMethodBeat.i(5511);
    if (com.tencent.mm.openim.room.a.a.z(paramad))
    {
      String str = com.tencent.mm.openim.room.a.a.A(paramad);
      if (str != null)
      {
        paramad = paramad.Of() + str;
        AppMethodBeat.o(5511);
        return paramad;
      }
      paramad = paramad.Of();
      AppMethodBeat.o(5511);
      return paramad;
    }
    paramad = paramad.Of();
    AppMethodBeat.o(5511);
    return paramad;
  }
  
  public static boolean ni(String paramString)
  {
    AppMethodBeat.i(5512);
    if ((t.nH(paramString)) || (ad.arf(paramString)))
    {
      AppMethodBeat.o(5512);
      return true;
    }
    AppMethodBeat.o(5512);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.m
 * JD-Core Version:    0.7.0.1
 */