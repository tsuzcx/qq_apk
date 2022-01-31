package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static gx a(bi parambi, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(17467);
    if (parambi.field_msgSvrId == 0L)
    {
      ab.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { parambi.field_talker, Integer.valueOf(parambi.getType()) });
      AppMethodBeat.o(17467);
      return null;
    }
    int j = com.tencent.mm.pluginsdk.model.app.l.LD(parambi.getType());
    if (!rp(j))
    {
      ab.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { parambi.field_talker, Integer.valueOf(parambi.getType()) });
      AppMethodBeat.o(17467);
      return null;
    }
    gx localgx = new gx();
    localgx.pIG = parambi.field_msgSvrId;
    if (parambi.field_isSend == 1)
    {
      localgx.woP = new bwc().aoF(paramString);
      localgx.woQ = new bwc().aoF(parambi.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localgx.wtl = i;
      localgx.wtq = new SKBuiltinBuffer_t();
      localgx.wtr = 0;
      localgx.wts = 0;
      localgx.woU = "";
      localgx.jKs = j;
      localgx.wtm = ((int)(parambi.field_createTime / 1000L));
      localgx.wtu = parambi.field_createTime;
      localgx.wtt = ((int)parambi.field_msgSeq);
      localgx.wtv = parambi.field_flag;
      localObject = new bwc();
      ((bwc)localObject).aoF(bo.bf(parambi.field_content, ""));
      localgx.woR = ((bwc)localObject);
      localObject = c.aTT().ro(com.tencent.mm.pluginsdk.model.app.l.LD(parambi.getType()));
      if (localObject != null) {
        break;
      }
      ab.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(parambi.getType()) });
      AppMethodBeat.o(17467);
      return null;
      localgx.woP = new bwc().aoF(parambi.field_talker);
      localgx.woQ = new bwc().aoF(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localgx, paramBoolean1, parambi, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
    if (i < 0)
    {
      AppMethodBeat.o(17467);
      return null;
    }
    paramPLong.value += i;
    paramPLong.value += 60L;
    AppMethodBeat.o(17467);
    return localgx;
  }
  
  private static boolean rp(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 34) || (paramInt == 42) || (paramInt == 66) || (paramInt == 43) || (paramInt == 43) || (paramInt == 44) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 50) || (paramInt == 62) || (paramInt == 10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */