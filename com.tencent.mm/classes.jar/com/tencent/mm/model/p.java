package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.ba.a.a;
import com.tencent.mm.ba.d;
import com.tencent.mm.ba.e;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
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
    bl localbl = new bl();
    localbl.nY(paramString1);
    localbl.setType(10000);
    localbl.kY(System.currentTimeMillis());
    localbl.setStatus(4);
    localbl.jV(paramInt);
    paramString1 = new StringBuffer();
    if (paramList != null)
    {
      String str1 = u.aqG();
      String str2 = aj.getContext().getString(2131757106);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (!str3.equals(str1))
        {
          af localaf = ((k)g.ab(k.class)).apM().aHY(str3);
          if ((localaf != null) && ((int)localaf.fId != 0))
          {
            if (paramBoolean) {
              paramString1.append("<a href=\"" + paramString3 + str3 + "\">" + h(localaf) + "</a>" + str2);
            } else {
              paramString1.append(h(localaf) + str2);
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
    localbl.setContent(paramString2.replace("%s", paramString1));
    ((k)g.ab(k.class)).cOI().an(localbl);
    AppMethodBeat.o(101738);
  }
  
  public static List<Boolean> af(List<String> paramList)
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
      if (!w.pF(str))
      {
        bool1 = false;
        localArrayList.add(Boolean.valueOf(bool1));
      }
      else
      {
        bool2 = false;
        boolean bool3 = false;
        long l3 = 0L;
        Object localObject = ((k)g.ab(k.class)).apR().aIn(str);
        l2 = l3;
        if (localObject != null)
        {
          l1 = l3;
          bool1 = bool3;
          if (((ay)localObject).field_lastSeq != 0L)
          {
            l1 = l3;
            bool1 = bool3;
            if (((k)g.ab(k.class)).cOI().aE(str, ((ay)localObject).field_lastSeq).field_msgId == 0L)
            {
              l1 = ((ay)localObject).field_lastSeq;
              bool1 = true;
            }
          }
          l2 = l1;
          bool2 = bool1;
          if (((ay)localObject).field_firstUnDeliverSeq != 0L)
          {
            ((am)localObject).kV(0L);
            ((am)localObject).kU(0L);
            ((k)g.ab(k.class)).apR().a((am)localObject, str);
            ad.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
            bool2 = bool1;
            l2 = l1;
          }
        }
        if (bool2) {
          break label399;
        }
        localObject = ((k)g.ab(k.class)).cOI().agK(str);
        if ((localObject == null) || (((du)localObject).field_msgId == 0L)) {
          break label399;
        }
      }
    }
    label399:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = ((k)g.ab(k.class)).cOI().agJ(str);
      }
      if (l1 != 0L) {
        ((k)g.ab(k.class)).aqo().aA(str, l1);
      }
      ad.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", new Object[] { str, Boolean.valueOf(bool1), Long.valueOf(l1) });
      break;
      AppMethodBeat.o(101736);
      return localArrayList;
    }
  }
  
  private static String h(af paramaf)
  {
    AppMethodBeat.i(101739);
    if (com.tencent.mm.openim.room.a.a.F(paramaf))
    {
      String str = com.tencent.mm.openim.room.a.a.G(paramaf);
      if (str != null)
      {
        paramaf = paramaf.ZX() + str;
        AppMethodBeat.o(101739);
        return paramaf;
      }
      paramaf = paramaf.ZX();
      AppMethodBeat.o(101739);
      return paramaf;
    }
    paramaf = paramaf.ZX();
    AppMethodBeat.o(101739);
    return paramaf;
  }
  
  public static boolean rK(String paramString)
  {
    AppMethodBeat.i(184632);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(184632);
      return false;
    }
    paramString = bt.S(paramString.split(","));
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
    } while (w.sk((String)paramString.next()));
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(184632);
      return bool;
    }
  }
  
  public static boolean rL(String paramString)
  {
    AppMethodBeat.i(101740);
    if ((w.sk(paramString)) || (af.aHH(paramString)))
    {
      AppMethodBeat.o(101740);
      return true;
    }
    AppMethodBeat.o(101740);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.p
 * JD-Core Version:    0.7.0.1
 */