package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ap;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class d
{
  public static boolean Eq(String paramString)
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
  
  public static int Kr(String paramString)
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
  
  public static com.tencent.mm.modelvideo.s agI(String paramString)
  {
    AppMethodBeat.i(22099);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22099);
      return null;
    }
    paramString = b.chw().chx().bhj().Qq(paramString);
    AppMethodBeat.o(22099);
    return paramString;
  }
  
  public static String agJ(String paramString)
  {
    AppMethodBeat.i(22100);
    String str = FilePathGenerator.genPath(b.chw().chx().aTa(), "msg_", paramString, ".amr", 2);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(22100);
      return null;
    }
    if (new o(str).exists())
    {
      AppMethodBeat.o(22100);
      return str;
    }
    paramString = b.chw().chx().bij() + paramString;
    if (new o(paramString + ".amr").exists()) {
      com.tencent.mm.vfs.s.nx(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(22100);
      return str;
      if (new o(paramString).exists()) {
        com.tencent.mm.vfs.s.nx(paramString, str);
      }
    }
  }
  
  public static void h(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(22095);
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      ca localca = b.chw().chx().aSQ().iG((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localca != null)
      {
        int j = ((Integer)paramHashMap.get(localObject)).intValue();
        String str = localca.field_talker;
        Log.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        int i = 0;
        az localaz = b.chw().chx().aST().bjY(str);
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
          ((az)localObject).nv(localca.field_isSend);
          ((az)localObject).nt(j + ((bb)localObject).field_unReadCount);
          ((az)localObject).aX(localca);
          ((az)localObject).Cl(Integer.toString(localca.getType()));
          ((az)localObject).yB(((bb)localObject).field_flag & 0x0 | localca.field_createTime & 0xFFFFFFFF);
          ((az)localObject).ns(0);
          if (i != 0)
          {
            Log.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((bb)localObject).field_flag) });
            b.chw().chx().aST().e((az)localObject);
          }
          else
          {
            b.chw().chx().aST().a((az)localObject, str);
          }
        }
      }
    }
    b.chw().chx().aST().gCu();
    AppMethodBeat.o(22095);
  }
  
  public static long x(ca paramca)
  {
    AppMethodBeat.i(22097);
    as localas = b.chw().chx().aSN().Kn(paramca.field_talker);
    if ((localas == null) || ((int)localas.gMZ == 0))
    {
      if (Util.isNullOrNil(paramca.field_talker)) {
        break label147;
      }
      b.chw().chy().j(2, paramca.field_talker);
      b.chw().chx().aSN().ap(new as(paramca.field_talker));
    }
    for (;;)
    {
      long l = b.chw().chx().aSQ().aC(paramca);
      if (l < 0L) {
        Log.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(paramca.getType()), paramca.field_talker });
      }
      AppMethodBeat.o(22097);
      return l;
      label147:
      if ((paramca.field_talker.endsWith("@chatroom")) && (b.chw().chx().aSX().Kh(paramca.field_talker) == null)) {
        b.chw().chy().j(2, paramca.field_talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.d
 * JD-Core Version:    0.7.0.1
 */