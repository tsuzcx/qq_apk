package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.ax.a.a;
import com.tencent.mm.ax.e;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
{
  public static List<Boolean> I(List<String> paramList)
  {
    if (paramList == null) {
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
      if (!s.fn(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((as)localObject).field_lastSeq != 0L)
          {
            l1 = l3;
            bool1 = bool3;
            if (((j)com.tencent.mm.kernel.g.r(j.class)).bhO().P(str, ((as)localObject).field_lastSeq).field_msgId == 0L)
            {
              l1 = ((as)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((as)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((ak)localObject).bd(0L);
            ((ak)localObject).bc(0L);
            ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a((ak)localObject, str);
            y.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label380;
        }
        localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HX(str);
        if ((localObject == null) || (((cs)localObject).field_msgId == 0L)) {
          break label380;
        }
      }
    }
    label380:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HW(str);
      }
      if (l1 != 0L) {
        ((j)com.tencent.mm.kernel.g.r(j.class)).Gb().L(str, l1);
      }
      y.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[] { str, Boolean.valueOf(bool1), Long.valueOf(l1) });
      break;
      return localArrayList;
    }
  }
  
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3)
  {
    a(paramString1, paramList, paramString2, paramBoolean, paramString3, 2);
  }
  
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    bi localbi = new bi();
    localbi.ec(paramString1);
    localbi.setType(10000);
    localbi.bg(System.currentTimeMillis());
    localbi.setStatus(4);
    localbi.fA(paramInt);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = q.Gj();
      String str2 = ae.getContext().getString(b.a.chatroom_sys_msg_invite_split);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          ad localad = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(str3);
          if ((localad != null) && ((int)localad.dBe != 0))
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
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(localbi);
  }
  
  private static String d(ad paramad)
  {
    int i;
    if ((paramad != null) && (ad.aaU(paramad.field_username)) && (!bk.bl(paramad.field_openImAppid)) && ("3552365301".equals(paramad.field_openImAppid))) {
      i = 1;
    }
    while (i != 0)
    {
      String str = com.tencent.mm.openim.room.a.a.z(paramad);
      if (str != null)
      {
        return paramad.Bq() + str;
        i = 0;
      }
      else
      {
        return paramad.Bq();
      }
    }
    return paramad.Bq();
  }
  
  public static boolean gA(String paramString)
  {
    return (s.gY(paramString)) || (ad.aaU(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.l
 * JD-Core Version:    0.7.0.1
 */