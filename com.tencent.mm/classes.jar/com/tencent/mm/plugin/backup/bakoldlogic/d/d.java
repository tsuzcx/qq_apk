package com.tencent.mm.plugin.backup.bakoldlogic.d;

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

public final class d
{
  public static long B(cc paramcc)
  {
    AppMethodBeat.i(22097);
    au localau = b.cXr().cXs().bzA().JE(paramcc.field_talker);
    if ((localau == null) || ((int)localau.maN == 0))
    {
      if (Util.isNullOrNil(paramcc.field_talker)) {
        break label146;
      }
      b.cXr().cXt().F(2, paramcc.field_talker);
      b.cXr().cXs().bzA().aB(new au(paramcc.field_talker));
    }
    for (;;)
    {
      long l = b.cXr().cXs().bzD().ba(paramcc);
      if (l < 0L) {
        Log.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(paramcc.getType()), paramcc.field_talker });
      }
      AppMethodBeat.o(22097);
      return l;
      label146:
      if ((paramcc.field_talker.endsWith("@chatroom")) && (b.cXr().cXs().bzK().Jy(paramcc.field_talker) == null)) {
        b.cXr().cXt().F(2, paramcc.field_talker);
      }
    }
  }
  
  public static boolean DQ(String paramString)
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
  
  public static int JI(String paramString)
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
  
  public static z ahJ(String paramString)
  {
    AppMethodBeat.i(22099);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22099);
      return null;
    }
    paramString = b.cXr().cXs().bOh().PR(paramString);
    AppMethodBeat.o(22099);
    return paramString;
  }
  
  public static String ahK(String paramString)
  {
    AppMethodBeat.i(22100);
    String str = FilePathGenerator.genPath(b.cXr().cXs().bzN(), "msg_", paramString, ".amr", 2);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(22100);
      return null;
    }
    if (new u(str).jKS())
    {
      AppMethodBeat.o(22100);
      return str;
    }
    paramString = b.cXr().cXs().bPn() + paramString;
    if (new u(paramString + ".amr").jKS()) {
      y.qn(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(22100);
      return str;
      if (new u(paramString).jKS()) {
        y.qn(paramString, str);
      }
    }
  }
  
  public static void k(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(22095);
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      cc localcc = b.cXr().cXs().bzD().kf((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localcc != null)
      {
        int j = ((Integer)paramHashMap.get(localObject)).intValue();
        String str = localcc.field_talker;
        Log.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        int i = 0;
        bb localbb = b.cXr().cXs().bzG().bxM(str);
        if ((localbb != null) && (localbb.field_conversationTime > localcc.getCreateTime()) && (localbb.field_conversationTime != 9223372036854775807L))
        {
          Log.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
        else
        {
          localObject = localbb;
          if (localbb == null)
          {
            Log.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
            Log.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[] { str });
            localObject = new bb(str);
            i = 1;
          }
          ((bb)localObject).pI(localcc.field_isSend);
          ((bb)localObject).pG(j + ((bd)localObject).field_unReadCount);
          ((bb)localObject).bG(localcc);
          ((bb)localObject).BE(Integer.toString(localcc.getType()));
          ((bb)localObject).gS(((bd)localObject).field_flag & 0x0 | localcc.getCreateTime() & 0xFFFFFFFF);
          ((bb)localObject).pF(0);
          if (i != 0)
          {
            Log.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((bd)localObject).field_flag) });
            b.cXr().cXs().bzG().h((bb)localObject);
          }
          else
          {
            b.cXr().cXs().bzG().c((bb)localObject, str);
          }
        }
      }
    }
    b.cXr().cXs().bzG().jaM();
    AppMethodBeat.o(22095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.d
 * JD-Core Version:    0.7.0.1
 */