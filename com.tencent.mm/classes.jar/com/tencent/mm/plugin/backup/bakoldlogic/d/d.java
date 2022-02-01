package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.al;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class d
{
  public static int BL(String paramString)
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
  
  public static s WO(String paramString)
  {
    AppMethodBeat.i(22099);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22099);
      return null;
    }
    paramString = b.bKD().bKE().aNh().HD(paramString);
    AppMethodBeat.o(22099);
    return paramString;
  }
  
  public static String WP(String paramString)
  {
    AppMethodBeat.i(22100);
    String str = n.d(b.bKD().bKE().azS(), "msg_", paramString, ".amr", 2);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(22100);
      return null;
    }
    if (new k(str).exists())
    {
      AppMethodBeat.o(22100);
      return str;
    }
    paramString = b.bKD().bKE().aOc() + paramString;
    if (new k(paramString + ".amr").exists()) {
      o.mG(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(22100);
      return str;
      if (new k(paramString).exists()) {
        o.mG(paramString, str);
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
      bv localbv = b.bKD().bKE().azI().hX((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localbv != null)
      {
        int j = ((Integer)paramHashMap.get(localObject)).intValue();
        String str = localbv.field_talker;
        ae.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        int i = 0;
        au localau = b.bKD().bKE().azL().aVa(str);
        if ((localau != null) && (localau.field_conversationTime > localbv.field_createTime) && (localau.field_conversationTime != 9223372036854775807L))
        {
          ae.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
        else
        {
          localObject = localau;
          if (localau == null)
          {
            ae.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
            ae.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[] { str });
            localObject = new au(str);
            i = 1;
          }
          ((au)localObject).kt(localbv.field_isSend);
          ((au)localObject).kr(j + ((ba)localObject).field_unReadCount);
          ((au)localObject).aK(localbv);
          ((au)localObject).tV(Integer.toString(localbv.getType()));
          ((au)localObject).qI(((ba)localObject).field_flag & 0x0 | localbv.field_createTime & 0xFFFFFFFF);
          ((au)localObject).kq(0);
          if (i != 0)
          {
            ae.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((ba)localObject).field_flag) });
            b.bKD().bKE().azL().e((au)localObject);
          }
          else
          {
            b.bKD().bKE().azL().a((au)localObject, str);
          }
        }
      }
    }
    b.bKD().bKE().azL().fuN();
    AppMethodBeat.o(22095);
  }
  
  public static long v(bv parambv)
  {
    AppMethodBeat.i(22097);
    an localan = b.bKD().bKE().azF().BH(parambv.field_talker);
    if ((localan == null) || ((int)localan.ght == 0))
    {
      if (bu.isNullOrNil(parambv.field_talker)) {
        break label147;
      }
      b.bKD().bKF().i(2, parambv.field_talker);
      b.bKD().bKE().azF().an(new an(parambv.field_talker));
    }
    for (;;)
    {
      long l = b.bKD().bKE().azI().ar(parambv);
      if (l < 0L) {
        ae.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(parambv.getType()), parambv.field_talker });
      }
      AppMethodBeat.o(22097);
      return l;
      label147:
      if ((parambv.field_talker.endsWith("@chatroom")) && (b.bKD().bKE().azP().BB(parambv.field_talker) == null)) {
        b.bKD().bKF().i(2, parambv.field_talker);
      }
    }
  }
  
  public static boolean wb(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.d
 * JD-Core Version:    0.7.0.1
 */