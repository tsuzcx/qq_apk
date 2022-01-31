package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.af;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class d
{
  public static boolean fn(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@chatroom");
  }
  
  public static long h(bi parambi)
  {
    Object localObject = b.avO().avP().Fw().abl(parambi.field_talker);
    if ((localObject == null) || ((int)((com.tencent.mm.n.a)localObject).dBe == 0))
    {
      if (bk.bl(parambi.field_talker)) {
        break label134;
      }
      b.avO().avQ().f(2, parambi.field_talker);
      b.avO().avP().Fw().V(new ad(parambi.field_talker));
    }
    for (;;)
    {
      long l = b.avO().avP().Fy().T(parambi);
      if (l < 0L) {
        y.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(parambi.getType()), parambi.field_talker });
      }
      return l;
      label134:
      if (parambi.field_talker.endsWith("@chatroom"))
      {
        localObject = b.avO().avP();
        if (((c)localObject).uin == 0) {
          throw new com.tencent.mm.model.b();
        }
        if (((c)localObject).hMS.ir(parambi.field_talker) == null) {
          b.avO().avQ().f(2, parambi.field_talker);
        }
      }
    }
  }
  
  public static int iH(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (paramString.length() <= 0);
      i = paramString.indexOf(':');
    } while ((i != -1) && (paramString.substring(0, i).contains("<")));
    return i;
  }
  
  public static void k(HashMap<String, Integer> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    Object localObject;
    bi localbi;
    int j;
    String str;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      localbi = b.avO().avP().Fy().dP((String)localObject, " and not ( type = 10000 and isSend != 2 ) ");
      if (localbi != null)
      {
        j = ((Integer)paramHashMap.get(localObject)).intValue();
        str = localbi.field_talker;
        y.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[] { str, Integer.valueOf(j) });
        localObject = b.avO().avP().FB().abv(str);
        if ((localObject != null) && (((as)localObject).field_conversationTime > localbi.field_createTime) && (((as)localObject).field_conversationTime != 9223372036854775807L))
        {
          y.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
        else
        {
          if (localObject != null) {
            break label342;
          }
          y.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
          y.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[] { str });
          localObject = new ak(str);
        }
      }
    }
    label342:
    for (int i = 1;; i = 0)
    {
      ((ak)localObject).fA(localbi.field_isSend);
      ((ak)localObject).fy(j + ((as)localObject).field_unReadCount);
      ((ak)localObject).ai(localbi);
      ((ak)localObject).dP(Integer.toString(localbi.getType()));
      ((ak)localObject).bb(((as)localObject).field_flag & 0x0 | localbi.field_createTime & 0xFFFFFFFF);
      ((ak)localObject).fx(0);
      if (i != 0)
      {
        y.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[] { str, Long.valueOf(((as)localObject).field_flag) });
        b.avO().avP().FB().d((ak)localObject);
        break;
      }
      b.avO().avP().FB().a((ak)localObject, str);
      break;
      b.avO().avP().FB().cuF();
      return;
    }
  }
  
  public static s xA(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return b.avO().avP().Sr().nQ(paramString);
  }
  
  public static String xB(String paramString)
  {
    Object localObject = b.avO().avP();
    if (((c)localObject).uin == 0) {
      throw new com.tencent.mm.model.b();
    }
    String str = h.b(((c)localObject).dKt + "voice2/", "msg_", paramString, ".amr", 2);
    if (bk.bl(str)) {
      localObject = null;
    }
    do
    {
      do
      {
        return localObject;
        localObject = str;
      } while (new com.tencent.mm.vfs.b(str).exists());
      localObject = new StringBuilder();
      c localc = b.avO().avP();
      if (localc.uin == 0) {
        throw new com.tencent.mm.model.b();
      }
      paramString = new StringBuilder().append(localc.dKt).append("voice/").toString() + paramString;
      if (new com.tencent.mm.vfs.b(paramString + ".amr").exists())
      {
        e.aA(paramString + ".amr", str);
        return str;
      }
      localObject = str;
    } while (!new com.tencent.mm.vfs.b(paramString).exists());
    e.aA(paramString, str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.d
 * JD-Core Version:    0.7.0.1
 */