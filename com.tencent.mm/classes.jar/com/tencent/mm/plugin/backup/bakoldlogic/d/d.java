package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aj;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class d
{
  public static s Ou(String paramString)
  {
    AppMethodBeat.i(22099);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22099);
      return null;
    }
    paramString = b.byA().byB().aCI().zO(paramString);
    AppMethodBeat.o(22099);
    return paramString;
  }
  
  public static String Ov(String paramString)
  {
    AppMethodBeat.i(22100);
    String str = l.d(b.byA().byB().apY(), "msg_", paramString, ".amr", 2);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(22100);
      return null;
    }
    if (new e(str).exists())
    {
      AppMethodBeat.o(22100);
      return str;
    }
    paramString = b.byA().byB().aDE() + paramString;
    if (new e(paramString + ".amr").exists()) {
      i.lD(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(22100);
      return str;
      if (new e(paramString).exists()) {
        i.lD(paramString, str);
      }
    }
  }
  
  public static void g(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(22095);
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      bl localbl = b.byA().byB().apO().hn((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localbl != null)
      {
        int j = ((Integer)paramHashMap.get(localObject)).intValue();
        String str = localbl.field_talker;
        ad.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        int i = 0;
        am localam = b.byA().byB().apR().aIn(str);
        if ((localam != null) && (localam.field_conversationTime > localbl.field_createTime) && (localam.field_conversationTime != 9223372036854775807L))
        {
          ad.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
        else
        {
          localObject = localam;
          if (localam == null)
          {
            ad.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
            ad.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[] { str });
            localObject = new am(str);
            i = 1;
          }
          ((am)localObject).jV(localbl.field_isSend);
          ((am)localObject).jT(j + ((ay)localObject).field_unReadCount);
          ((am)localObject).aG(localbl);
          ((am)localObject).nK(Integer.toString(localbl.getType()));
          ((am)localObject).kT(((ay)localObject).field_flag & 0x0 | localbl.field_createTime & 0xFFFFFFFF);
          ((am)localObject).jS(0);
          if (i != 0)
          {
            ad.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((ay)localObject).field_flag) });
            b.byA().byB().apR().e((am)localObject);
          }
          else
          {
            b.byA().byB().apR().a((am)localObject, str);
          }
        }
      }
    }
    b.byA().byB().apR().eLi();
    AppMethodBeat.o(22095);
  }
  
  public static boolean pF(String paramString)
  {
    AppMethodBeat.i(22096);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(22096);
      return false;
    }
    boolean bool = paramString.endsWith("@chatroom");
    AppMethodBeat.o(22096);
    return bool;
  }
  
  public static long u(bl parambl)
  {
    AppMethodBeat.i(22097);
    af localaf = b.byA().byB().apM().aHY(parambl.field_talker);
    if ((localaf == null) || ((int)localaf.fId == 0))
    {
      if (bt.isNullOrNil(parambl.field_talker)) {
        break label147;
      }
      b.byA().byC().i(2, parambl.field_talker);
      b.byA().byB().apM().af(new af(parambl.field_talker));
    }
    for (;;)
    {
      long l = b.byA().byB().apO().an(parambl);
      if (l < 0L) {
        ad.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(parambl.getType()), parambl.field_talker });
      }
      AppMethodBeat.o(22097);
      return l;
      label147:
      if ((parambl.field_talker.endsWith("@chatroom")) && (b.byA().byB().apV().tL(parambl.field_talker) == null)) {
        b.byA().byC().i(2, parambl.field_talker);
      }
    }
  }
  
  public static int ue(String paramString)
  {
    AppMethodBeat.i(22098);
    if (paramString == null)
    {
      AppMethodBeat.o(22098);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      AppMethodBeat.o(22098);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      AppMethodBeat.o(22098);
      return -1;
    }
    AppMethodBeat.o(22098);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.d
 * JD-Core Version:    0.7.0.1
 */