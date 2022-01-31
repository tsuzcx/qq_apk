package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static fo a(bi parambi, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    if (parambi.field_msgSvrId == 0L)
    {
      y.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { parambi.field_talker, Integer.valueOf(parambi.getType()) });
      return null;
    }
    fo localfo = new fo();
    localfo.ndp = parambi.field_msgSvrId;
    if (parambi.field_isSend == 1)
    {
      localfo.svF = new bml().YI(paramString);
      localfo.svG = new bml().YI(parambi.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localfo.szk = i;
      localfo.szp = new bmk();
      localfo.szq = 0;
      localfo.szr = 0;
      localfo.svK = "";
      localfo.hQR = com.tencent.mm.pluginsdk.model.app.l.DK(parambi.getType());
      localfo.szl = ((int)(parambi.field_createTime / 1000L));
      localfo.szt = parambi.field_createTime;
      localfo.szs = ((int)parambi.field_msgSeq);
      localfo.szu = parambi.field_flag;
      localObject = new bml();
      ((bml)localObject).YI(bk.aM(parambi.field_content, ""));
      localfo.svH = ((bml)localObject);
      localObject = c.aut().nA(com.tencent.mm.pluginsdk.model.app.l.DK(parambi.getType()));
      if (localObject != null) {
        break;
      }
      y.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(parambi.getType()) });
      return null;
      localfo.svF = new bml().YI(parambi.field_talker);
      localfo.svG = new bml().YI(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localfo, paramBoolean1, parambi, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
    if (i < 0) {
      return null;
    }
    paramPLong.value += i;
    paramPLong.value += 60L;
    return localfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */