package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ag;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class d
{
  public static s Gt(String paramString)
  {
    AppMethodBeat.i(18042);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(18042);
      return null;
    }
    paramString = b.aVr().aVs().alE().vd(paramString);
    AppMethodBeat.o(18042);
    return paramString;
  }
  
  public static String Gu(String paramString)
  {
    AppMethodBeat.i(18043);
    String str = j.b(b.aVr().aVs().YM(), "msg_", paramString, ".amr", 2);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(18043);
      return null;
    }
    if (new com.tencent.mm.vfs.b(str).exists())
    {
      AppMethodBeat.o(18043);
      return str;
    }
    paramString = b.aVr().aVs().amy() + paramString;
    if (new com.tencent.mm.vfs.b(paramString + ".amr").exists()) {
      e.aT(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(18043);
      return str;
      if (new com.tencent.mm.vfs.b(paramString).exists()) {
        e.aT(paramString, str);
      }
    }
  }
  
  public static void k(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(18038);
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      bi localbi = b.aVr().aVs().YC().fi((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localbi != null)
      {
        int j = ((Integer)paramHashMap.get(localObject)).intValue();
        String str = localbi.field_talker;
        ab.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        int i = 0;
        ak localak = b.aVr().aVs().YF().arH(str);
        if ((localak != null) && (localak.field_conversationTime > localbi.field_createTime) && (localak.field_conversationTime != 9223372036854775807L))
        {
          ab.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
        else
        {
          localObject = localak;
          if (localak == null)
          {
            ab.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
            ab.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[] { str });
            localObject = new ak(str);
            i = 1;
          }
          ((ak)localObject).hL(localbi.field_isSend);
          ((ak)localObject).hJ(j + ((au)localObject).field_unReadCount);
          ((ak)localObject).aq(localbi);
          ((ak)localObject).jV(Integer.toString(localbi.getType()));
          ((ak)localObject).fL(((au)localObject).field_flag & 0x0 | localbi.field_createTime & 0xFFFFFFFF);
          ((ak)localObject).hI(0);
          if (i != 0)
          {
            ab.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((au)localObject).field_flag) });
            b.aVr().aVs().YF().d((ak)localObject);
          }
          else
          {
            b.aVr().aVs().YF().a((ak)localObject, str);
          }
        }
      }
    }
    b.aVr().aVs().YF().dxf();
    AppMethodBeat.o(18038);
  }
  
  public static long l(bi parambi)
  {
    AppMethodBeat.i(18040);
    ad localad = b.aVr().aVs().YA().arw(parambi.field_talker);
    if ((localad == null) || ((int)localad.euF == 0))
    {
      if (bo.isNullOrNil(parambi.field_talker)) {
        break label147;
      }
      b.aVr().aVt().h(2, parambi.field_talker);
      b.aVr().aVs().YA().Y(new ad(parambi.field_talker));
    }
    for (;;)
    {
      long l = b.aVr().aVs().YC().Z(parambi);
      if (l < 0L) {
        ab.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(parambi.getType()), parambi.field_talker });
      }
      AppMethodBeat.o(18040);
      return l;
      label147:
      if ((parambi.field_talker.endsWith("@chatroom")) && (b.aVr().aVs().YJ().oY(parambi.field_talker) == null)) {
        b.aVr().aVt().h(2, parambi.field_talker);
      }
    }
  }
  
  public static boolean lA(String paramString)
  {
    AppMethodBeat.i(18039);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(18039);
      return false;
    }
    boolean bool = paramString.endsWith("@chatroom");
    AppMethodBeat.o(18039);
    return bool;
  }
  
  public static int pt(String paramString)
  {
    AppMethodBeat.i(18041);
    if (paramString == null)
    {
      AppMethodBeat.o(18041);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      AppMethodBeat.o(18041);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      AppMethodBeat.o(18041);
      return -1;
    }
    AppMethodBeat.o(18041);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.d
 * JD-Core Version:    0.7.0.1
 */