package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  public static int Bj(String paramString)
  {
    AppMethodBeat.i(21760);
    if (paramString == null)
    {
      AppMethodBeat.o(21760);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      AppMethodBeat.o(21760);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      AppMethodBeat.o(21760);
      return -1;
    }
    AppMethodBeat.o(21760);
    return i;
  }
  
  public static s Wc(String paramString)
  {
    AppMethodBeat.i(21761);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21761);
      return null;
    }
    paramString = d.bIY().bIZ().aMJ().Hb(paramString);
    AppMethodBeat.o(21761);
    return paramString;
  }
  
  public static String Wd(String paramString)
  {
    AppMethodBeat.i(21762);
    String str = m.d(d.bIY().bIZ().azC(), "msg_", paramString, ".amr", 2);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(21762);
      return null;
    }
    if (new e(str).exists())
    {
      AppMethodBeat.o(21762);
      return str;
    }
    paramString = d.bIY().bIZ().aNE() + paramString;
    if (new e(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.i.mA(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(21762);
      return str;
      if (new e(paramString).exists()) {
        com.tencent.mm.vfs.i.mA(paramString, str);
      }
    }
  }
  
  public static void g(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(21757);
    ad.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[] { Integer.valueOf(paramHashMap.size()) });
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      bu localbu = d.bIY().bIZ().azs().hQ(str1, " and not ( type = 10000 and isSend != 2 ) ");
      int i;
      String str2;
      at localat;
      if (localbu != null)
      {
        i = ((Integer)paramHashMap.get(str1)).intValue();
        str2 = localbu.field_talker;
        ad.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[] { str2, Integer.valueOf(i) });
        localat = d.bIY().bIZ().azv().aTz(str2);
        if ((localat == null) || (localat.field_conversationTime <= localbu.field_createTime) || (localat.field_conversationTime == 9223372036854775807L)) {
          break label216;
        }
        ad.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      }
      Object localObject;
      for (;;)
      {
        localObject = d.bIY().bIZ();
        if (((b)localObject).uin != 0) {
          break;
        }
        paramHashMap = new com.tencent.mm.model.b();
        AppMethodBeat.o(21757);
        throw paramHashMap;
        label216:
        boolean bool = false;
        localObject = localat;
        if (localat == null)
        {
          localObject = new at(str2);
          bool = true;
        }
        ((at)localObject).kr(localbu.field_isSend);
        ((at)localObject).kp(i + ((ba)localObject).field_unReadCount);
        ((at)localObject).aL(localbu);
        ((at)localObject).tA(Integer.toString(localbu.getType()));
        long l = ((ba)localObject).field_flag;
        ((at)localObject).qv(localbu.field_createTime & 0xFFFFFFFF | l & 0x0);
        ((at)localObject).ko(0);
        ad.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[] { Boolean.valueOf(bool), str2, Long.valueOf(((ba)localObject).field_flag) });
        if (bool) {
          d.bIY().bIZ().azv().e((at)localObject);
        } else {
          d.bIY().bIZ().azv().a((at)localObject, str2);
        }
      }
      ((b)localObject).nAp.aG(str1, 0L);
    }
    d.bIY().bIZ().azv().fqN();
    AppMethodBeat.o(21757);
  }
  
  public static long v(bu parambu)
  {
    AppMethodBeat.i(21759);
    am localam = d.bIY().bIZ().azp().Bf(parambu.field_talker);
    if ((localam == null) || ((int)localam.gfj == 0))
    {
      if (bt.isNullOrNil(parambu.field_talker)) {
        break label146;
      }
      d.bIY().bJa().h(2, parambu.field_talker);
      d.bIY().bIZ().azp().ag(new am(parambu.field_talker));
    }
    for (;;)
    {
      long l = d.bIY().bIZ().azs().as(parambu);
      if (l < 0L) {
        ad.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact failed: type:%d, talker:%s", new Object[] { Integer.valueOf(parambu.getType()), parambu.field_talker });
      }
      AppMethodBeat.o(21759);
      return l;
      label146:
      if ((parambu.field_talker.endsWith("@chatroom")) && (d.bIY().bIZ().azz().AR(parambu.field_talker) == null)) {
        d.bIY().bJa().h(2, parambu.field_talker);
      }
    }
  }
  
  public static boolean vF(String paramString)
  {
    AppMethodBeat.i(21758);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(21758);
      return false;
    }
    boolean bool = w.zj(paramString);
    AppMethodBeat.o(21758);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.c
 * JD-Core Version:    0.7.0.1
 */