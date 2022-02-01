package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
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

public final class c
{
  public static boolean Lj(String paramString)
  {
    AppMethodBeat.i(21758);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(21758);
      return false;
    }
    boolean bool = ab.PO(paramString);
    AppMethodBeat.o(21758);
    return bool;
  }
  
  public static int RK(String paramString)
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
  
  public static w aom(String paramString)
  {
    AppMethodBeat.i(21761);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21761);
      return null;
    }
    paramString = d.cua().cub().bqB().XN(paramString);
    AppMethodBeat.o(21761);
    return paramString;
  }
  
  public static String aon(String paramString)
  {
    AppMethodBeat.i(21762);
    String str = FilePathGenerator.genPath(d.cua().cub().bbY(), "msg_", paramString, ".amr", 2);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(21762);
      return null;
    }
    if (new q(str).ifE())
    {
      AppMethodBeat.o(21762);
      return str;
    }
    paramString = d.cua().cub().brH() + paramString;
    if (new q(paramString + ".amr").ifE()) {
      u.oo(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(21762);
      return str;
      if (new q(paramString).ifE()) {
        u.oo(paramString, str);
      }
    }
  }
  
  public static void i(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(21757);
    Log.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[] { Integer.valueOf(paramHashMap.size()) });
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      ca localca = d.cua().cub().bbO().iR(str1, " and not ( type = 10000 and isSend != 2 ) ");
      int i;
      String str2;
      az localaz;
      if (localca != null)
      {
        i = ((Integer)paramHashMap.get(str1)).intValue();
        str2 = localca.field_talker;
        Log.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[] { str2, Integer.valueOf(i) });
        localaz = d.cua().cub().bbR().bwx(str2);
        if ((localaz == null) || (localaz.field_conversationTime <= localca.field_createTime) || (localaz.field_conversationTime == 9223372036854775807L)) {
          break label216;
        }
        Log.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      }
      Object localObject;
      for (;;)
      {
        localObject = d.cua().cub();
        if (((b)localObject).uin != 0) {
          break;
        }
        paramHashMap = new com.tencent.mm.model.b();
        AppMethodBeat.o(21757);
        throw paramHashMap;
        label216:
        boolean bool = false;
        localObject = localaz;
        if (localaz == null)
        {
          localObject = new az(str2);
          bool = true;
        }
        ((az)localObject).pJ(localca.field_isSend);
        ((az)localObject).pH(i + ((bb)localObject).field_unReadCount);
        ((az)localObject).bq(localca);
        ((az)localObject).IZ(Integer.toString(localca.getType()));
        long l = ((bb)localObject).field_flag;
        ((az)localObject).EC(localca.field_createTime & 0xFFFFFFFF | l & 0x0);
        ((az)localObject).pG(0);
        Log.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[] { Boolean.valueOf(bool), str2, Long.valueOf(((bb)localObject).field_flag) });
        if (bool) {
          d.cua().cub().bbR().e((az)localObject);
        } else {
          d.cua().cub().bbR().a((az)localObject, str2);
        }
      }
      ((b)localObject).rSE.aJ(str1, 0L);
    }
    d.cua().cub().bbR().hyH();
    AppMethodBeat.o(21757);
  }
  
  public static long z(ca paramca)
  {
    AppMethodBeat.i(21759);
    as localas = d.cua().cub().bbL().RG(paramca.field_talker);
    if ((localas == null) || ((int)localas.jxt == 0))
    {
      if (Util.isNullOrNil(paramca.field_talker)) {
        break label146;
      }
      d.cua().cuc().l(2, paramca.field_talker);
      d.cua().cub().bbL().av(new as(paramca.field_talker));
    }
    for (;;)
    {
      long l = d.cua().cub().bbO().aM(paramca);
      if (l < 0L) {
        Log.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact failed: type:%d, talker:%s", new Object[] { Integer.valueOf(paramca.getType()), paramca.field_talker });
      }
      AppMethodBeat.o(21759);
      return l;
      label146:
      if ((paramca.field_talker.endsWith("@chatroom")) && (d.cua().cub().bbV().RA(paramca.field_talker) == null)) {
        d.cua().cuc().l(2, paramca.field_talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.c
 * JD-Core Version:    0.7.0.1
 */