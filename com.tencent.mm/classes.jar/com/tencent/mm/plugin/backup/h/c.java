package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  public static long B(cc paramcc)
  {
    AppMethodBeat.i(21759);
    au localau = d.cWK().cWL().bzA().JE(paramcc.field_talker);
    if ((localau == null) || ((int)localau.maN == 0))
    {
      if (Util.isNullOrNil(paramcc.field_talker)) {
        break label145;
      }
      d.cWK().cWM().E(2, paramcc.field_talker);
      d.cWK().cWL().bzA().aB(new au(paramcc.field_talker));
    }
    for (;;)
    {
      long l = d.cWK().cWL().bzD().ba(paramcc);
      if (l < 0L) {
        Log.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact failed: type:%d, talker:%s", new Object[] { Integer.valueOf(paramcc.getType()), paramcc.field_talker });
      }
      AppMethodBeat.o(21759);
      return l;
      label145:
      if ((paramcc.field_talker.endsWith("@chatroom")) && (d.cWK().cWL().bzK().Jy(paramcc.field_talker) == null)) {
        d.cWK().cWM().E(2, paramcc.field_talker);
      }
    }
  }
  
  public static boolean DQ(String paramString)
  {
    AppMethodBeat.i(21758);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(21758);
      return false;
    }
    boolean bool = au.bwE(paramString);
    AppMethodBeat.o(21758);
    return bool;
  }
  
  public static int JI(String paramString)
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
  
  public static z ahJ(String paramString)
  {
    AppMethodBeat.i(21761);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21761);
      return null;
    }
    paramString = d.cWK().cWL().bOh().PR(paramString);
    AppMethodBeat.o(21761);
    return paramString;
  }
  
  public static String ahK(String paramString)
  {
    AppMethodBeat.i(21762);
    String str = FilePathGenerator.genPath(d.cWK().cWL().bzN(), "msg_", paramString, ".amr", 2);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(21762);
      return null;
    }
    if (new u(str).jKS())
    {
      AppMethodBeat.o(21762);
      return str;
    }
    paramString = d.cWK().cWL().bPn() + paramString;
    if (new u(paramString + ".amr").jKS()) {
      y.qn(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(21762);
      return str;
      if (new u(paramString).jKS()) {
        y.qn(paramString, str);
      }
    }
  }
  
  public static void k(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(21757);
    Log.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[] { Integer.valueOf(paramHashMap.size()) });
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      cc localcc = d.cWK().cWL().bzD().kf(str1, " and not ( type = 10000 and isSend != 2 ) ");
      int i;
      String str2;
      bb localbb;
      if (localcc != null)
      {
        i = ((Integer)paramHashMap.get(str1)).intValue();
        str2 = localcc.field_talker;
        Log.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[] { str2, Integer.valueOf(i) });
        localbb = d.cWK().cWL().bzG().bxM(str2);
        if ((localbb == null) || (localbb.field_conversationTime <= localcc.getCreateTime()) || (localbb.field_conversationTime == 9223372036854775807L)) {
          break label217;
        }
        Log.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      }
      Object localObject;
      for (;;)
      {
        localObject = d.cWK().cWL();
        if (((b)localObject).uin != 0) {
          break;
        }
        paramHashMap = new com.tencent.mm.model.b();
        AppMethodBeat.o(21757);
        throw paramHashMap;
        label217:
        boolean bool = false;
        localObject = localbb;
        if (localbb == null)
        {
          localObject = new bb(str2);
          bool = true;
        }
        ((bb)localObject).pI(localcc.field_isSend);
        ((bb)localObject).pG(i + ((bd)localObject).field_unReadCount);
        ((bb)localObject).bG(localcc);
        ((bb)localObject).BE(Integer.toString(localcc.getType()));
        long l = ((bd)localObject).field_flag;
        ((bb)localObject).gS(localcc.getCreateTime() & 0xFFFFFFFF | l & 0x0);
        ((bb)localObject).pF(0);
        Log.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[] { Boolean.valueOf(bool), str2, Long.valueOf(((bd)localObject).field_flag) });
        if (bool) {
          d.cWK().cWL().bzG().h((bb)localObject);
        } else {
          d.cWK().cWL().bzG().c((bb)localObject, str2);
        }
      }
      ((b)localObject).vdT.aS(str1, 0L);
    }
    d.cWK().cWL().bzG().jaM();
    AppMethodBeat.o(21757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.c
 * JD-Core Version:    0.7.0.1
 */