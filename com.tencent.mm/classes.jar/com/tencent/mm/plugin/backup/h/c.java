package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  public static s Ou(String paramString)
  {
    AppMethodBeat.i(21761);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21761);
      return null;
    }
    paramString = d.bxT().bxU().aCI().zO(paramString);
    AppMethodBeat.o(21761);
    return paramString;
  }
  
  public static String Ov(String paramString)
  {
    AppMethodBeat.i(21762);
    String str = l.d(d.bxT().bxU().apY(), "msg_", paramString, ".amr", 2);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(21762);
      return null;
    }
    if (new e(str).exists())
    {
      AppMethodBeat.o(21762);
      return str;
    }
    paramString = d.bxT().bxU().aDE() + paramString;
    if (new e(paramString + ".amr").exists()) {
      i.lD(paramString + ".amr", str);
    }
    for (;;)
    {
      AppMethodBeat.o(21762);
      return str;
      if (new e(paramString).exists()) {
        i.lD(paramString, str);
      }
    }
  }
  
  public static void g(HashMap<String, Integer> paramHashMap)
  {
    AppMethodBeat.i(21757);
    ad.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[] { Integer.valueOf(paramHashMap.size()) });
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      bl localbl = d.bxT().bxU().apO().hn(str1, " and not ( type = 10000 and isSend != 2 ) ");
      int i;
      String str2;
      am localam;
      if (localbl != null)
      {
        i = ((Integer)paramHashMap.get(str1)).intValue();
        str2 = localbl.field_talker;
        ad.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[] { str2, Integer.valueOf(i) });
        localam = d.bxT().bxU().apR().aIn(str2);
        if ((localam == null) || (localam.field_conversationTime <= localbl.field_createTime) || (localam.field_conversationTime == 9223372036854775807L)) {
          break label216;
        }
        ad.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
      }
      Object localObject;
      for (;;)
      {
        localObject = d.bxT().bxU();
        if (((b)localObject).uin != 0) {
          break;
        }
        paramHashMap = new com.tencent.mm.model.b();
        AppMethodBeat.o(21757);
        throw paramHashMap;
        label216:
        boolean bool = false;
        localObject = localam;
        if (localam == null)
        {
          localObject = new am(str2);
          bool = true;
        }
        ((am)localObject).jV(localbl.field_isSend);
        ((am)localObject).jT(i + ((ay)localObject).field_unReadCount);
        ((am)localObject).aG(localbl);
        ((am)localObject).nK(Integer.toString(localbl.getType()));
        long l = ((ay)localObject).field_flag;
        ((am)localObject).kT(localbl.field_createTime & 0xFFFFFFFF | l & 0x0);
        ((am)localObject).jS(0);
        ad.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[] { Boolean.valueOf(bool), str2, Long.valueOf(((ay)localObject).field_flag) });
        if (bool) {
          d.bxT().bxU().apR().e((am)localObject);
        } else {
          d.bxT().bxU().apR().a((am)localObject, str2);
        }
      }
      ((b)localObject).mxR.aB(str1, 0L);
    }
    d.bxT().bxU().apR().eLi();
    AppMethodBeat.o(21757);
  }
  
  public static boolean pF(String paramString)
  {
    AppMethodBeat.i(21758);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(21758);
      return false;
    }
    boolean bool = w.sl(paramString);
    AppMethodBeat.o(21758);
    return bool;
  }
  
  public static long u(bl parambl)
  {
    AppMethodBeat.i(21759);
    af localaf = d.bxT().bxU().apM().aHY(parambl.field_talker);
    if ((localaf == null) || ((int)localaf.fId == 0))
    {
      if (bt.isNullOrNil(parambl.field_talker)) {
        break label146;
      }
      d.bxT().bxV().h(2, parambl.field_talker);
      d.bxT().bxU().apM().af(new af(parambl.field_talker));
    }
    for (;;)
    {
      long l = d.bxT().bxU().apO().an(parambl);
      if (l < 0L) {
        ad.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact failed: type:%d, talker:%s", new Object[] { Integer.valueOf(parambl.getType()), parambl.field_talker });
      }
      AppMethodBeat.o(21759);
      return l;
      label146:
      if ((parambl.field_talker.endsWith("@chatroom")) && (d.bxT().bxU().apV().tL(parambl.field_talker) == null)) {
        d.bxT().bxV().h(2, parambl.field_talker);
      }
    }
  }
  
  public static int ue(String paramString)
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