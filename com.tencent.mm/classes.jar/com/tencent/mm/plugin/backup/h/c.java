package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  public static s SE(String paramString)
  {
    AppMethodBeat.i(21761);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21761);
      return null;
    }
    paramString = d.bEP().bEQ().aJy().DT(paramString);
    AppMethodBeat.o(21761);
    return paramString;
  }
  
  public static String SF(String paramString)
  {
    AppMethodBeat.i(21762);
    String str = l.d(d.bEP().bEQ().awN(), "msg_", paramString, ".amr", 2);
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(21762);
      return null;
    }
    if (new e(str).exists())
    {
      AppMethodBeat.o(21762);
      return str;
    }
    paramString = d.bEP().bEQ().aKv() + paramString;
    if (new e(paramString + ".amr").exists()) {
      i.ma(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(21762);
      return str;
      if (new e(paramString).exists()) {
        i.ma(paramString, str);
      }
    }
  }
  
  public static void g(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(21757);
    ac.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[] { Integer.valueOf(paramHashMap.size()) });
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      bo localbo = d.bEP().bEQ().awD().hG(str1, " and not ( type = 10000 and isSend != 2 ) ");
      int i;
      String str2;
      ap localap;
      if (localbo != null)
      {
        i = ((Integer)paramHashMap.get(str1)).intValue();
        str2 = localbo.field_talker;
        ac.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[] { str2, Integer.valueOf(i) });
        localap = d.bEP().bEQ().awG().aNI(str2);
        if ((localap == null) || (localap.field_conversationTime <= localbo.field_createTime) || (localap.field_conversationTime == 9223372036854775807L)) {
          break label216;
        }
        ac.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      }
      Object localObject;
      for (;;)
      {
        localObject = d.bEP().bEQ();
        if (((b)localObject).uin != 0) {
          break;
        }
        paramHashMap = new com.tencent.mm.model.b();
        AppMethodBeat.o(21757);
        throw paramHashMap;
        label216:
        boolean bool = false;
        localObject = localap;
        if (localap == null)
        {
          localObject = new ap(str2);
          bool = true;
        }
        ((ap)localObject).jT(localbo.field_isSend);
        ((ap)localObject).jR(i + ((az)localObject).field_unReadCount);
        ((ap)localObject).aI(localbo);
        ((ap)localObject).qQ(Integer.toString(localbo.getType()));
        long l = ((az)localObject).field_flag;
        ((ap)localObject).ov(localbo.field_createTime & 0xFFFFFFFF | l & 0x0);
        ((ap)localObject).jQ(0);
        ac.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[] { Boolean.valueOf(bool), str2, Long.valueOf(((az)localObject).field_flag) });
        if (bool) {
          d.bEP().bEQ().awG().e((ap)localObject);
        } else {
          d.bEP().bEQ().awG().a((ap)localObject, str2);
        }
      }
      ((b)localObject).mZS.aD(str1, 0L);
    }
    d.bEP().bEQ().awG().faK();
    AppMethodBeat.o(21757);
  }
  
  public static boolean sQ(String paramString)
  {
    AppMethodBeat.i(21758);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(21758);
      return false;
    }
    boolean bool = w.wo(paramString);
    AppMethodBeat.o(21758);
    return bool;
  }
  
  public static long u(bo parambo)
  {
    AppMethodBeat.i(21759);
    ai localai = d.bEP().bEQ().awB().aNt(parambo.field_talker);
    if ((localai == null) || ((int)localai.fLJ == 0))
    {
      if (bs.isNullOrNil(parambo.field_talker)) {
        break label146;
      }
      d.bEP().bER().h(2, parambo.field_talker);
      d.bEP().bEQ().awB().ag(new ai(parambo.field_talker));
    }
    for (;;)
    {
      long l = d.bEP().bEQ().awD().ap(parambo);
      if (l < 0L) {
        ac.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact failed: type:%d, talker:%s", new Object[] { Integer.valueOf(parambo.getType()), parambo.field_talker });
      }
      AppMethodBeat.o(21759);
      return l;
      label146:
      if ((parambo.field_talker.endsWith("@chatroom")) && (d.bEP().bEQ().awK().xR(parambo.field_talker) == null)) {
        d.bEP().bER().h(2, parambo.field_talker);
      }
    }
  }
  
  public static int yk(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.c
 * JD-Core Version:    0.7.0.1
 */