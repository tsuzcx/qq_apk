package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.al;
import com.tencent.mm.model.x;
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

public final class c
{
  public static int BL(String paramString)
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
  
  public static s WO(String paramString)
  {
    AppMethodBeat.i(21761);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21761);
      return null;
    }
    paramString = d.bJW().bJX().aNh().HD(paramString);
    AppMethodBeat.o(21761);
    return paramString;
  }
  
  public static String WP(String paramString)
  {
    AppMethodBeat.i(21762);
    String str = n.d(d.bJW().bJX().azS(), "msg_", paramString, ".amr", 2);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(21762);
      return null;
    }
    if (new k(str).exists())
    {
      AppMethodBeat.o(21762);
      return str;
    }
    paramString = d.bJW().bJX().aOc() + paramString;
    if (new k(paramString + ".amr").exists()) {
      o.mG(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(21762);
      return str;
      if (new k(paramString).exists()) {
        o.mG(paramString, str);
      }
    }
  }
  
  public static void g(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(21757);
    ae.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[] { Integer.valueOf(paramHashMap.size()) });
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      bv localbv = d.bJW().bJX().azI().hX(str1, " and not ( type = 10000 and isSend != 2 ) ");
      int i;
      String str2;
      au localau;
      if (localbv != null)
      {
        i = ((Integer)paramHashMap.get(str1)).intValue();
        str2 = localbv.field_talker;
        ae.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[] { str2, Integer.valueOf(i) });
        localau = d.bJW().bJX().azL().aVa(str2);
        if ((localau == null) || (localau.field_conversationTime <= localbv.field_createTime) || (localau.field_conversationTime == 9223372036854775807L)) {
          break label216;
        }
        ae.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      }
      Object localObject;
      for (;;)
      {
        localObject = d.bJW().bJX();
        if (((b)localObject).uin != 0) {
          break;
        }
        paramHashMap = new com.tencent.mm.model.b();
        AppMethodBeat.o(21757);
        throw paramHashMap;
        label216:
        boolean bool = false;
        localObject = localau;
        if (localau == null)
        {
          localObject = new au(str2);
          bool = true;
        }
        ((au)localObject).kt(localbv.field_isSend);
        ((au)localObject).kr(i + ((ba)localObject).field_unReadCount);
        ((au)localObject).aK(localbv);
        ((au)localObject).tV(Integer.toString(localbv.getType()));
        long l = ((ba)localObject).field_flag;
        ((au)localObject).qI(localbv.field_createTime & 0xFFFFFFFF | l & 0x0);
        ((au)localObject).kq(0);
        ae.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[] { Boolean.valueOf(bool), str2, Long.valueOf(((ba)localObject).field_flag) });
        if (bool) {
          d.bJW().bJX().azL().e((au)localObject);
        } else {
          d.bJW().bJX().azL().a((au)localObject, str2);
        }
      }
      ((b)localObject).nFK.aH(str1, 0L);
    }
    d.bJW().bJX().azL().fuN();
    AppMethodBeat.o(21757);
  }
  
  public static long v(bv parambv)
  {
    AppMethodBeat.i(21759);
    an localan = d.bJW().bJX().azF().BH(parambv.field_talker);
    if ((localan == null) || ((int)localan.ght == 0))
    {
      if (bu.isNullOrNil(parambv.field_talker)) {
        break label146;
      }
      d.bJW().bJY().h(2, parambv.field_talker);
      d.bJW().bJX().azF().an(new an(parambv.field_talker));
    }
    for (;;)
    {
      long l = d.bJW().bJX().azI().ar(parambv);
      if (l < 0L) {
        ae.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact failed: type:%d, talker:%s", new Object[] { Integer.valueOf(parambv.getType()), parambv.field_talker });
      }
      AppMethodBeat.o(21759);
      return l;
      label146:
      if ((parambv.field_talker.endsWith("@chatroom")) && (d.bJW().bJX().azP().BB(parambv.field_talker) == null)) {
        d.bJW().bJY().h(2, parambv.field_talker);
      }
    }
  }
  
  public static boolean wb(String paramString)
  {
    AppMethodBeat.i(21758);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(21758);
      return false;
    }
    boolean bool = x.zT(paramString);
    AppMethodBeat.o(21758);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.c
 * JD-Core Version:    0.7.0.1
 */