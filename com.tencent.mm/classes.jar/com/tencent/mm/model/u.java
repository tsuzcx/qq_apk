package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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

public final class u
{
  public static boolean Pg(String paramString)
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
    } while (ab.PM((String)paramString.next()));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(184632);
      return bool;
    }
  }
  
  public static boolean Ph(String paramString)
  {
    AppMethodBeat.i(101740);
    if ((ab.PM(paramString)) || (as.bvK(paramString)))
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
    ca localca = new ca();
    localca.Jm(paramString1);
    localca.setType(10000);
    localca.setCreateTime(System.currentTimeMillis());
    localca.setStatus(4);
    localca.pJ(2);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = z.bcZ();
      String str2 = MMApplicationContext.getContext().getString(b.a.chatroom_sys_msg_invite_split);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          as localas = ((n)h.ae(n.class)).bbL().RG(str3);
          if ((localas != null) && ((int)localas.jxt != 0))
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
    ((n)h.ae(n.class)).eSe().aM(localca);
    AppMethodBeat.o(101737);
  }
  
  public static List<Boolean> ak(List<String> paramList)
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
      if (!ab.Lj(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((n)h.ae(n.class)).bbR().bwx(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((bb)localObject).field_lastSeq != 0L)
          {
            l1 = l3;
            bool1 = bool3;
            if (((n)h.ae(n.class)).eSe().aM(str, ((bb)localObject).field_lastSeq).field_msgId == 0L)
            {
              l1 = ((bb)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((bb)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((az)localObject).EE(0L);
            ((az)localObject).ED(0L);
            ((n)h.ae(n.class)).bbR().a((az)localObject, str);
            Log.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label399;
        }
        localObject = ((n)h.ae(n.class)).eSe().aPc(str);
        if ((localObject == null) || (((et)localObject).field_msgId == 0L)) {
          break label399;
        }
      }
    }
    label399:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((n)h.ae(n.class)).eSe().aPb(str);
      }
      if (l1 != 0L) {
        ((n)h.ae(n.class)).bco().aI(str, l1);
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
    if (a.U(paramas))
    {
      String str = a.V(paramas);
      if (str != null)
      {
        paramas = paramas.ays() + str;
        AppMethodBeat.o(101739);
        return paramas;
      }
      paramas = paramas.ays();
      AppMethodBeat.o(101739);
      return paramas;
    }
    paramas = paramas.ays();
    AppMethodBeat.o(101739);
    return paramas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.u
 * JD-Core Version:    0.7.0.1
 */