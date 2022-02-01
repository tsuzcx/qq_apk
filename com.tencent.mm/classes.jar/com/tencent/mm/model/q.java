package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.az.a.a;
import com.tencent.mm.az.d;
import com.tencent.mm.az.e;
import com.tencent.mm.az.f;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class q
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
    bv localbv = new bv();
    localbv.ui(paramString1);
    localbv.setType(10000);
    localbv.qN(System.currentTimeMillis());
    localbv.setStatus(4);
    localbv.kt(paramInt);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = v.aAC();
      String str2 = ak.getContext().getString(2131757106);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(str3);
          if ((localan != null) && ((int)localan.ght != 0))
          {
            if (paramBoolean) {
              paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + o(localan) + "</a>" + str2);
            } else {
              paramString1.append(o(localan) + str2);
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
    localbv.setContent(paramString2.replace("%s", paramString1));
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ar(localbv);
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
      if (!x.wb(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((ba)localObject).field_lastSeq != 0L)
          {
            l1 = l3;
            bool1 = bool3;
            if (((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aK(str, ((ba)localObject).field_lastSeq).field_msgId == 0L)
            {
              l1 = ((ba)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((ba)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((au)localObject).qK(0L);
            ((au)localObject).qJ(0L);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a((au)localObject, str);
            ae.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label399;
        }
        localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arx(str);
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
        l1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arw(str);
      }
      if (l1 != 0L) {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).aAi().aG(str, l1);
      }
      ae.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[] { str, Boolean.valueOf(bool1), Long.valueOf(l1) });
      break;
      AppMethodBeat.o(101736);
      return localArrayList;
    }
  }
  
  private static String o(an paraman)
  {
    AppMethodBeat.i(101739);
    if (com.tencent.mm.openim.room.a.a.N(paraman))
    {
      String str = com.tencent.mm.openim.room.a.a.O(paraman);
      if (str != null)
      {
        paraman = paraman.adG() + str;
        AppMethodBeat.o(101739);
        return paraman;
      }
      paraman = paraman.adG();
      AppMethodBeat.o(101739);
      return paraman;
    }
    paraman = paraman.adG();
    AppMethodBeat.o(101739);
    return paraman;
  }
  
  public static boolean zo(String paramString)
  {
    AppMethodBeat.i(184632);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184632);
      return false;
    }
    paramString = bu.U(paramString.split(","));
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
    } while (x.zS((String)paramString.next()));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(184632);
      return bool;
    }
  }
  
  public static boolean zp(String paramString)
  {
    AppMethodBeat.i(101740);
    if ((x.zS(paramString)) || (an.aUq(paramString)))
    {
      AppMethodBeat.o(101740);
      return true;
    }
    AppMethodBeat.o(101740);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */