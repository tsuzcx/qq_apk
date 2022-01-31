package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ag;
import com.tencent.mm.modelvideo.s;
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

public final class c
{
  public static s Gt(String paramString)
  {
    AppMethodBeat.i(17704);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(17704);
      return null;
    }
    paramString = d.aUK().aUL().alE().vd(paramString);
    AppMethodBeat.o(17704);
    return paramString;
  }
  
  public static String Gu(String paramString)
  {
    AppMethodBeat.i(17705);
    String str = j.b(d.aUK().aUL().YM(), "msg_", paramString, ".amr", 2);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(17705);
      return null;
    }
    if (new com.tencent.mm.vfs.b(str).exists())
    {
      AppMethodBeat.o(17705);
      return str;
    }
    paramString = d.aUK().aUL().amy() + paramString;
    if (new com.tencent.mm.vfs.b(paramString + ".amr").exists()) {
      e.aT(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(17705);
      return str;
      if (new com.tencent.mm.vfs.b(paramString).exists()) {
        e.aT(paramString, str);
      }
    }
  }
  
  public static void k(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(17700);
    ab.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[] { Integer.valueOf(paramHashMap.size()) });
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      bi localbi = d.aUK().aUL().YC().fi(str1, " and not ( type = 10000 and isSend != 2 ) ");
      int i;
      String str2;
      ak localak;
      if (localbi != null)
      {
        i = ((Integer)paramHashMap.get(str1)).intValue();
        str2 = localbi.field_talker;
        ab.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[] { str2, Integer.valueOf(i) });
        localak = d.aUK().aUL().YF().arH(str2);
        if ((localak == null) || (localak.field_conversationTime <= localbi.field_createTime) || (localak.field_conversationTime == 9223372036854775807L)) {
          break label216;
        }
        ab.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      }
      Object localObject;
      for (;;)
      {
        localObject = d.aUK().aUL();
        if (((b)localObject).uin != 0) {
          break;
        }
        paramHashMap = new com.tencent.mm.model.b();
        AppMethodBeat.o(17700);
        throw paramHashMap;
        label216:
        boolean bool = false;
        localObject = localak;
        if (localak == null)
        {
          localObject = new ak(str2);
          bool = true;
        }
        ((ak)localObject).hL(localbi.field_isSend);
        ((ak)localObject).hJ(i + ((au)localObject).field_unReadCount);
        ((ak)localObject).aq(localbi);
        ((ak)localObject).jV(Integer.toString(localbi.getType()));
        long l = ((au)localObject).field_flag;
        ((ak)localObject).fL(localbi.field_createTime & 0xFFFFFFFF | l & 0x0);
        ((ak)localObject).hI(0);
        ab.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[] { Boolean.valueOf(bool), str2, Long.valueOf(((au)localObject).field_flag) });
        if (bool) {
          d.aUK().aUL().YF().d((ak)localObject);
        } else {
          d.aUK().aUL().YF().a((ak)localObject, str2);
        }
      }
      ((b)localObject).jGy.ae(str1, 0L);
    }
    d.aUK().aUL().YF().dxf();
    AppMethodBeat.o(17700);
  }
  
  public static long l(bi parambi)
  {
    AppMethodBeat.i(17702);
    ad localad = d.aUK().aUL().YA().arw(parambi.field_talker);
    if ((localad == null) || ((int)localad.euF == 0))
    {
      if (bo.isNullOrNil(parambi.field_talker)) {
        break label147;
      }
      d.aUK().aUM().h(2, parambi.field_talker);
      d.aUK().aUL().YA().Y(new ad(parambi.field_talker));
    }
    for (;;)
    {
      long l = d.aUK().aUL().YC().Z(parambi);
      if (l < 0L) {
        ab.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(parambi.getType()), parambi.field_talker });
      }
      AppMethodBeat.o(17702);
      return l;
      label147:
      if ((parambi.field_talker.endsWith("@chatroom")) && (d.aUK().aUL().YJ().oY(parambi.field_talker) == null)) {
        d.aUK().aUM().h(2, parambi.field_talker);
      }
    }
  }
  
  public static boolean lA(String paramString)
  {
    AppMethodBeat.i(17701);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(17701);
      return false;
    }
    boolean bool = com.tencent.mm.model.t.nI(paramString);
    AppMethodBeat.o(17701);
    return bool;
  }
  
  public static int pt(String paramString)
  {
    AppMethodBeat.i(17703);
    if (paramString == null)
    {
      AppMethodBeat.o(17703);
      return -1;
    }
    if (paramString.length() <= 0)
    {
      AppMethodBeat.o(17703);
      return -1;
    }
    int i = paramString.indexOf(':');
    if ((i != -1) && (paramString.substring(0, i).contains("<")))
    {
      AppMethodBeat.o(17703);
      return -1;
    }
    AppMethodBeat.o(17703);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.c
 * JD-Core Version:    0.7.0.1
 */