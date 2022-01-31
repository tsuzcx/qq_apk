package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.af;
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

public final class c
{
  public static boolean fn(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return com.tencent.mm.model.s.gZ(paramString);
  }
  
  public static long h(bi parambi)
  {
    Object localObject = d.avi().avj().Fw().abl(parambi.field_talker);
    if ((localObject == null) || ((int)((com.tencent.mm.n.a)localObject).dBe == 0))
    {
      if (bk.bl(parambi.field_talker)) {
        break label134;
      }
      d.avi().avk().f(2, parambi.field_talker);
      d.avi().avj().Fw().V(new ad(parambi.field_talker));
    }
    for (;;)
    {
      long l = d.avi().avj().Fy().T(parambi);
      if (l < 0L) {
        y.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[] { Integer.valueOf(parambi.getType()), parambi.field_talker });
      }
      return l;
      label134:
      if (parambi.field_talker.endsWith("@chatroom"))
      {
        localObject = d.avi().avj();
        if (((b)localObject).uin == 0) {
          throw new com.tencent.mm.model.b();
        }
        if (((b)localObject).hMS.ir(parambi.field_talker) == null) {
          d.avi().avk().f(2, parambi.field_talker);
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
    y.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", new Object[] { Integer.valueOf(paramHashMap.size()) });
    Iterator localIterator = paramHashMap.keySet().iterator();
    String str1;
    bi localbi;
    int i;
    String str2;
    Object localObject;
    if (localIterator.hasNext())
    {
      str1 = (String)localIterator.next();
      localbi = d.avi().avj().Fy().dP(str1, " and not ( type = 10000 and isSend != 2 ) ");
      if (localbi != null)
      {
        i = ((Integer)paramHashMap.get(str1)).intValue();
        str2 = localbi.field_talker;
        y.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", new Object[] { str2, Integer.valueOf(i) });
        localObject = d.avi().avj().FB().abv(str2);
        if ((localObject != null) && (((as)localObject).field_conversationTime > localbi.field_createTime) && (((as)localObject).field_conversationTime != 9223372036854775807L)) {
          y.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        }
      }
      else
      {
        label178:
        localObject = d.avi().avj();
        if (((b)localObject).uin != 0) {
          break label375;
        }
        throw new com.tencent.mm.model.b();
      }
      if (localObject != null) {
        break label407;
      }
      localObject = new ak(str2);
    }
    label407:
    for (boolean bool = true;; bool = false)
    {
      ((ak)localObject).fA(localbi.field_isSend);
      ((ak)localObject).fy(i + ((as)localObject).field_unReadCount);
      ((ak)localObject).ai(localbi);
      ((ak)localObject).dP(Integer.toString(localbi.getType()));
      long l = ((as)localObject).field_flag;
      ((ak)localObject).bb(localbi.field_createTime & 0xFFFFFFFF | l & 0x0);
      ((ak)localObject).fx(0);
      y.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", new Object[] { Boolean.valueOf(bool), str2, Long.valueOf(((as)localObject).field_flag) });
      if (bool)
      {
        d.avi().avj().FB().d((ak)localObject);
        break label178;
      }
      d.avi().avj().FB().a((ak)localObject, str2);
      break label178;
      label375:
      ((b)localObject).hMW.M(str1, 0L);
      break;
      d.avi().avj().FB().cuF();
      return;
    }
  }
  
  public static com.tencent.mm.modelvideo.s xA(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return d.avi().avj().Sr().nQ(paramString);
  }
  
  public static String xB(String paramString)
  {
    Object localObject = d.avi().avj();
    if (((b)localObject).uin == 0) {
      throw new com.tencent.mm.model.b();
    }
    String str = h.b(((b)localObject).dKt + "voice2/", "msg_", paramString, ".amr", 2);
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
      b localb = d.avi().avj();
      if (localb.uin == 0) {
        throw new com.tencent.mm.model.b();
      }
      paramString = new StringBuilder().append(localb.dKt).append("voice/").toString() + paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.c
 * JD-Core Version:    0.7.0.1
 */