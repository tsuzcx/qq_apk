package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ak;
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

public final class d
{
  public static int Bj(String paramString)
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
  
  public static s Wc(String paramString)
  {
    AppMethodBeat.i(22099);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22099);
      return null;
    }
    paramString = b.bJF().bJG().aMJ().Hb(paramString);
    AppMethodBeat.o(22099);
    return paramString;
  }
  
  public static String Wd(String paramString)
  {
    AppMethodBeat.i(22100);
    String str = m.d(b.bJF().bJG().azC(), "msg_", paramString, ".amr", 2);
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
    paramString = b.bJF().bJG().aNE() + paramString;
    if (new e(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.i.mA(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(22100);
      return str;
      if (new e(paramString).exists()) {
        com.tencent.mm.vfs.i.mA(paramString, str);
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
      bu localbu = b.bJF().bJG().azs().hQ((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localbu != null)
      {
        int j = ((Integer)paramHashMap.get(localObject)).intValue();
        String str = localbu.field_talker;
        ad.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        int i = 0;
        at localat = b.bJF().bJG().azv().aTz(str);
        if ((localat != null) && (localat.field_conversationTime > localbu.field_createTime) && (localat.field_conversationTime != 9223372036854775807L))
        {
          ad.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
        else
        {
          localObject = localat;
          if (localat == null)
          {
            ad.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
            ad.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[] { str });
            localObject = new at(str);
            i = 1;
          }
          ((at)localObject).kr(localbu.field_isSend);
          ((at)localObject).kp(j + ((ba)localObject).field_unReadCount);
          ((at)localObject).aL(localbu);
          ((at)localObject).tA(Integer.toString(localbu.getType()));
          ((at)localObject).qv(((ba)localObject).field_flag & 0x0 | localbu.field_createTime & 0xFFFFFFFF);
          ((at)localObject).ko(0);
          if (i != 0)
          {
            ad.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((ba)localObject).field_flag) });
            b.bJF().bJG().azv().e((at)localObject);
          }
          else
          {
            b.bJF().bJG().azv().a((at)localObject, str);
          }
        }
      }
    }
    b.bJF().bJG().azv().fqN();
    AppMethodBeat.o(22095);
  }
  
  public static long v(bu parambu)
  {
    AppMethodBeat.i(22097);
    am localam = b.bJF().bJG().azp().Bf(parambu.field_talker);
    if ((localam == null) || ((int)localam.gfj == 0))
    {
      if (bt.isNullOrNil(parambu.field_talker)) {
        break label147;
      }
      b.bJF().bJH().i(2, parambu.field_talker);
      b.bJF().bJG().azp().ag(new am(parambu.field_talker));
    }
    for (;;)
    {
      long l = b.bJF().bJG().azs().as(parambu);
      if (l < 0L) {
        ad.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(parambu.getType()), parambu.field_talker });
      }
      AppMethodBeat.o(22097);
      return l;
      label147:
      if ((parambu.field_talker.endsWith("@chatroom")) && (b.bJF().bJG().azz().AR(parambu.field_talker) == null)) {
        b.bJF().bJH().i(2, parambu.field_talker);
      }
    }
  }
  
  public static boolean vF(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.d
 * JD-Core Version:    0.7.0.1
 */