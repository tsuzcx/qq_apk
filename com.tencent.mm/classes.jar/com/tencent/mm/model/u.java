package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.az.a.a;
import com.tencent.mm.az.d;
import com.tencent.mm.az.e;
import com.tencent.mm.az.f;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class u
{
  public static boolean HQ(String paramString)
  {
    AppMethodBeat.i(184632);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184632);
      return false;
    }
    paramString = Util.stringsToList(paramString.split(","));
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
    } while (ab.Iu((String)paramString.next()));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(184632);
      return bool;
    }
  }
  
  public static boolean HR(String paramString)
  {
    AppMethodBeat.i(101740);
    if ((ab.Iu(paramString)) || (as.bjp(paramString)))
    {
      AppMethodBeat.o(101740);
      return true;
    }
    AppMethodBeat.o(101740);
    return false;
  }
  
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(101737);
    a(paramString1, paramList, paramString2, paramBoolean, paramString3, 2);
    AppMethodBeat.o(101737);
  }
  
  public static void a(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    AppMethodBeat.i(101738);
    ca localca = new ca();
    localca.Cy(paramString1);
    localca.setType(10000);
    localca.setCreateTime(System.currentTimeMillis());
    localca.setStatus(4);
    localca.nv(paramInt);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = z.aTY();
      String str2 = MMApplicationContext.getContext().getString(2131757307);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          as localas = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str3);
          if ((localas != null) && ((int)localas.gMZ != 0))
          {
            if (paramBoolean) {
              paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + o(localas) + "</a>" + str2);
            } else {
              paramString1.append(o(localas) + str2);
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
    localca.setContent(paramString2.replace("%s", paramString1));
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aC(localca);
    AppMethodBeat.o(101738);
  }
  
  public static List<Boolean> am(List<String> paramList)
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
      if (!ab.Eq(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((bb)localObject).field_lastSeq != 0L)
          {
            l1 = l3;
            bool1 = bool3;
            if (((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aK(str, ((bb)localObject).field_lastSeq).field_msgId == 0L)
            {
              l1 = ((bb)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((bb)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((az)localObject).yD(0L);
            ((az)localObject).yC(0L);
            ((l)com.tencent.mm.kernel.g.af(l.class)).aST().a((az)localObject, str);
            Log.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label399;
        }
        localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aES(str);
        if ((localObject == null) || (((eo)localObject).field_msgId == 0L)) {
          break label399;
        }
      }
    }
    label399:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aER(str);
      }
      if (l1 != 0L) {
        ((l)com.tencent.mm.kernel.g.af(l.class)).aTq().aG(str, l1);
      }
      Log.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[] { str, Boolean.valueOf(bool1), Long.valueOf(l1) });
      break;
      AppMethodBeat.o(101736);
      return localArrayList;
    }
  }
  
  private static String o(as paramas)
  {
    AppMethodBeat.i(101739);
    if (com.tencent.mm.openim.room.a.a.N(paramas))
    {
      String str = com.tencent.mm.openim.room.a.a.O(paramas);
      if (str != null)
      {
        paramas = paramas.arJ() + str;
        AppMethodBeat.o(101739);
        return paramas;
      }
      paramas = paramas.arJ();
      AppMethodBeat.o(101739);
      return paramas;
    }
    paramas = paramas.arJ();
    AppMethodBeat.o(101739);
    return paramas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.u
 * JD-Core Version:    0.7.0.1
 */