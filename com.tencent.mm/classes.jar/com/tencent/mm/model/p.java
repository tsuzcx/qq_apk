package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.ba.a.a;
import com.tencent.mm.ba.d;
import com.tencent.mm.ba.e;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class p
{
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(101737);
    a(paramString1, paramList, paramString2, paramBoolean, paramString3, 2);
    AppMethodBeat.o(101737);
  }
  
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    AppMethodBeat.i(101738);
    bu localbu = new bu();
    localbu.tN(paramString1);
    localbu.setType(10000);
    localbu.qA(System.currentTimeMillis());
    localbu.setStatus(4);
    localbu.kr(paramInt);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = u.aAm();
      String str2 = aj.getContext().getString(2131757106);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(str3);
          if ((localam != null) && ((int)localam.gfj != 0))
          {
            if (paramBoolean) {
              paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + h(localam) + "</a>" + str2);
            } else {
              paramString1.append(h(localam) + str2);
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
    localbu.setContent(paramString2.replace("%s", paramString1));
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as(localbu);
    AppMethodBeat.o(101738);
  }
  
  public static List<Boolean> ad(List<String> paramList)
  {
    AppMethodBeat.i(101736);
    if (paramList == null)
    {
      AppMethodBeat.o(101736);
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
      if (!w.vF(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((ba)localObject).field_lastSeq != 0L)
          {
            l1 = l3;
            bool1 = bool3;
            if (((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aJ(str, ((ba)localObject).field_lastSeq).field_msgId == 0L)
            {
              l1 = ((ba)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((ba)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((at)localObject).qx(0L);
            ((at)localObject).qw(0L);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a((at)localObject, str);
            ad.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label399;
        }
        localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqs(str);
        if ((localObject == null) || (((ei)localObject).field_msgId == 0L)) {
          break label399;
        }
      }
    }
    label399:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqr(str);
      }
      if (l1 != 0L) {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azS().aF(str, l1);
      }
      ad.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[] { str, Boolean.valueOf(bool1), Long.valueOf(l1) });
      break;
      AppMethodBeat.o(101736);
      return localArrayList;
    }
  }
  
  private static String h(am paramam)
  {
    AppMethodBeat.i(101739);
    if (com.tencent.mm.openim.room.a.a.G(paramam))
    {
      String str = com.tencent.mm.openim.room.a.a.H(paramam);
      if (str != null)
      {
        paramam = paramam.adv() + str;
        AppMethodBeat.o(101739);
        return paramam;
      }
      paramam = paramam.adv();
      AppMethodBeat.o(101739);
      return paramam;
    }
    paramam = paramam.adv();
    AppMethodBeat.o(101739);
    return paramam;
  }
  
  public static boolean yE(String paramString)
  {
    AppMethodBeat.i(184632);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184632);
      return false;
    }
    paramString = bt.U(paramString.split(","));
    if (paramString == null)
    {
      AppMethodBeat.o(184632);
      return false;
    }
    paramString = paramString.iterator();
    do
    {
      if (!paramString.hasNext()) {
        break;
      }
    } while (w.zi((String)paramString.next()));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(184632);
      return bool;
    }
  }
  
  public static boolean yF(String paramString)
  {
    AppMethodBeat.i(101740);
    if ((w.zi(paramString)) || (am.aSQ(paramString)))
    {
      AppMethodBeat.o(101740);
      return true;
    }
    AppMethodBeat.o(101740);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.p
 * JD-Core Version:    0.7.0.1
 */