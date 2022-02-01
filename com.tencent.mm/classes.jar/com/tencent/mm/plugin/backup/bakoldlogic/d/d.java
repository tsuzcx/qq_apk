package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aq;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class d
{
  public static boolean Lj(String paramString)
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
  
  public static int RK(String paramString)
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
  
  public static w aom(String paramString)
  {
    AppMethodBeat.i(22099);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22099);
      return null;
    }
    paramString = b.cuH().cuI().bqB().XN(paramString);
    AppMethodBeat.o(22099);
    return paramString;
  }
  
  public static String aon(String paramString)
  {
    AppMethodBeat.i(22100);
    String str = FilePathGenerator.genPath(b.cuH().cuI().bbY(), "msg_", paramString, ".amr", 2);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(22100);
      return null;
    }
    if (new q(str).ifE())
    {
      AppMethodBeat.o(22100);
      return str;
    }
    paramString = b.cuH().cuI().brH() + paramString;
    if (new q(paramString + ".amr").ifE()) {
      u.oo(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(22100);
      return str;
      if (new q(paramString).ifE()) {
        u.oo(paramString, str);
      }
    }
  }
  
  public static void i(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(22095);
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      ca localca = b.cuH().cuI().bbO().iR((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localca != null)
      {
        int j = ((Integer)paramHashMap.get(localObject)).intValue();
        String str = localca.field_talker;
        Log.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        int i = 0;
        az localaz = b.cuH().cuI().bbR().bwx(str);
        if ((localaz != null) && (localaz.field_conversationTime > localca.field_createTime) && (localaz.field_conversationTime != 9223372036854775807L))
        {
          Log.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
        else
        {
          localObject = localaz;
          if (localaz == null)
          {
            Log.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
            Log.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[] { str });
            localObject = new az(str);
            i = 1;
          }
          ((az)localObject).pJ(localca.field_isSend);
          ((az)localObject).pH(j + ((bb)localObject).field_unReadCount);
          ((az)localObject).bq(localca);
          ((az)localObject).IZ(Integer.toString(localca.getType()));
          ((az)localObject).EC(((bb)localObject).field_flag & 0x0 | localca.field_createTime & 0xFFFFFFFF);
          ((az)localObject).pG(0);
          if (i != 0)
          {
            Log.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((bb)localObject).field_flag) });
            b.cuH().cuI().bbR().e((az)localObject);
          }
          else
          {
            b.cuH().cuI().bbR().a((az)localObject, str);
          }
        }
      }
    }
    b.cuH().cuI().bbR().hyH();
    AppMethodBeat.o(22095);
  }
  
  public static long z(ca paramca)
  {
    AppMethodBeat.i(22097);
    as localas = b.cuH().cuI().bbL().RG(paramca.field_talker);
    if ((localas == null) || ((int)localas.jxt == 0))
    {
      if (Util.isNullOrNil(paramca.field_talker)) {
        break label147;
      }
      b.cuH().cuJ().m(2, paramca.field_talker);
      b.cuH().cuI().bbL().av(new as(paramca.field_talker));
    }
    for (;;)
    {
      long l = b.cuH().cuI().bbO().aM(paramca);
      if (l < 0L) {
        Log.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(paramca.getType()), paramca.field_talker });
      }
      AppMethodBeat.o(22097);
      return l;
      label147:
      if ((paramca.field_talker.endsWith("@chatroom")) && (b.cuH().cuI().bbV().RA(paramca.field_talker) == null)) {
        b.cuH().cuJ().m(2, paramca.field_talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.d
 * JD-Core Version:    0.7.0.1
 */