package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.az.a.a;
import com.tencent.mm.az.d;
import com.tencent.mm.az.e;
import com.tencent.mm.az.f;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
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
    bo localbo = new bo();
    localbo.re(paramString1);
    localbo.setType(10000);
    localbo.oA(System.currentTimeMillis());
    localbo.setStatus(4);
    localbo.jT(paramInt);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = u.axw();
      String str2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757106);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          com.tencent.mm.storage.ai localai = ((k)g.ab(k.class)).awB().aNt(str3);
          if ((localai != null) && ((int)localai.fLJ != 0))
          {
            if (paramBoolean) {
              paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + h(localai) + "</a>" + str2);
            } else {
              paramString1.append(h(localai) + str2);
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
    localbo.setContent(paramString2.replace("%s", paramString1));
    ((k)g.ab(k.class)).dcr().ap(localbo);
    AppMethodBeat.o(101738);
  }
  
  public static List<Boolean> ac(List<String> paramList)
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
      if (!w.sQ(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((k)g.ab(k.class)).awG().aNI(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((az)localObject).field_lastSeq != 0L)
          {
            l1 = l3;
            bool1 = bool3;
            if (((k)g.ab(k.class)).dcr().aG(str, ((az)localObject).field_lastSeq).field_msgId == 0L)
            {
              l1 = ((az)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((az)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((ap)localObject).ox(0L);
            ((ap)localObject).ow(0L);
            ((k)g.ab(k.class)).awG().a((ap)localObject, str);
            ac.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label399;
        }
        localObject = ((k)g.ab(k.class)).dcr().alE(str);
        if ((localObject == null) || (((dy)localObject).field_msgId == 0L)) {
          break label399;
        }
      }
    }
    label399:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((k)g.ab(k.class)).dcr().alD(str);
      }
      if (l1 != 0L) {
        ((k)g.ab(k.class)).axd().aC(str, l1);
      }
      ac.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[] { str, Boolean.valueOf(bool1), Long.valueOf(l1) });
      break;
      AppMethodBeat.o(101736);
      return localArrayList;
    }
  }
  
  private static String h(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(101739);
    if (com.tencent.mm.openim.room.a.a.G(paramai))
    {
      String str = com.tencent.mm.openim.room.a.a.H(paramai);
      if (str != null)
      {
        paramai = paramai.aaS() + str;
        AppMethodBeat.o(101739);
        return paramai;
      }
      paramai = paramai.aaS();
      AppMethodBeat.o(101739);
      return paramai;
    }
    paramai = paramai.aaS();
    AppMethodBeat.o(101739);
    return paramai;
  }
  
  public static boolean vN(String paramString)
  {
    AppMethodBeat.i(184632);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184632);
      return false;
    }
    paramString = bs.S(paramString.split(","));
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
    } while (w.wn((String)paramString.next()));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(184632);
      return bool;
    }
  }
  
  public static boolean vO(String paramString)
  {
    AppMethodBeat.i(101740);
    if ((w.wn(paramString)) || (com.tencent.mm.storage.ai.aNc(paramString)))
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