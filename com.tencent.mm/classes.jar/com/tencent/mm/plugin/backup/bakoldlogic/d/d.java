package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
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

public final class d
{
  public static s SE(String paramString)
  {
    AppMethodBeat.i(22099);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22099);
      return null;
    }
    paramString = b.bFw().bFx().aJy().DT(paramString);
    AppMethodBeat.o(22099);
    return paramString;
  }
  
  public static String SF(String paramString)
  {
    AppMethodBeat.i(22100);
    String str = l.d(b.bFw().bFx().awN(), "msg_", paramString, ".amr", 2);
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(22100);
      return null;
    }
    if (new e(str).exists())
    {
      AppMethodBeat.o(22100);
      return str;
    }
    paramString = b.bFw().bFx().aKv() + paramString;
    if (new e(paramString + ".amr").exists()) {
      i.ma(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(22100);
      return str;
      if (new e(paramString).exists()) {
        i.ma(paramString, str);
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
      bo localbo = b.bFw().bFx().awD().hG((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localbo != null)
      {
        int j = ((Integer)paramHashMap.get(localObject)).intValue();
        String str = localbo.field_talker;
        ac.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        int i = 0;
        ap localap = b.bFw().bFx().awG().aNI(str);
        if ((localap != null) && (localap.field_conversationTime > localbo.field_createTime) && (localap.field_conversationTime != 9223372036854775807L))
        {
          ac.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
        else
        {
          localObject = localap;
          if (localap == null)
          {
            ac.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
            ac.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[] { str });
            localObject = new ap(str);
            i = 1;
          }
          ((ap)localObject).jT(localbo.field_isSend);
          ((ap)localObject).jR(j + ((az)localObject).field_unReadCount);
          ((ap)localObject).aI(localbo);
          ((ap)localObject).qQ(Integer.toString(localbo.getType()));
          ((ap)localObject).ov(((az)localObject).field_flag & 0x0 | localbo.field_createTime & 0xFFFFFFFF);
          ((ap)localObject).jQ(0);
          if (i != 0)
          {
            ac.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((az)localObject).field_flag) });
            b.bFw().bFx().awG().e((ap)localObject);
          }
          else
          {
            b.bFw().bFx().awG().a((ap)localObject, str);
          }
        }
      }
    }
    b.bFw().bFx().awG().faK();
    AppMethodBeat.o(22095);
  }
  
  public static boolean sQ(String paramString)
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
  
  public static long u(bo parambo)
  {
    AppMethodBeat.i(22097);
    ai localai = b.bFw().bFx().awB().aNt(parambo.field_talker);
    if ((localai == null) || ((int)localai.fLJ == 0))
    {
      if (bs.isNullOrNil(parambo.field_talker)) {
        break label147;
      }
      b.bFw().bFy().i(2, parambo.field_talker);
      b.bFw().bFx().awB().ag(new ai(parambo.field_talker));
    }
    for (;;)
    {
      long l = b.bFw().bFx().awD().ap(parambo);
      if (l < 0L) {
        ac.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(parambo.getType()), parambo.field_talker });
      }
      AppMethodBeat.o(22097);
      return l;
      label147:
      if ((parambo.field_talker.endsWith("@chatroom")) && (b.bFw().bFx().awK().xR(parambo.field_talker) == null)) {
        b.bFw().bFy().i(2, parambo.field_talker);
      }
    }
  }
  
  public static int yk(String paramString)
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