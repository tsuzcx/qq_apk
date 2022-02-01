package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static if a(bu parambu, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(21526);
    if (parambu.field_msgSvrId == 0L)
    {
      ad.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { parambu.field_talker, Integer.valueOf(parambu.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    int j = m.Yv(parambu.getType());
    if (!xy(j))
    {
      ad.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { parambu.field_talker, Integer.valueOf(parambu.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    if localif = new if();
    localif.xbt = parambu.field_msgSvrId;
    if (parambu.field_isSend == 1)
    {
      localif.Fvi = new cwt().aPy(paramString);
      localif.Fvj = new cwt().aPy(parambu.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localif.FAI = i;
      localif.FAN = new SKBuiltinBuffer_t();
      localif.FAO = 0;
      localif.FAP = 0;
      localif.Fvn = "";
      localif.nEf = j;
      localif.FAJ = ((int)(parambu.field_createTime / 1000L));
      localif.FAS = parambu.field_createTime;
      localif.FAQ = ((int)parambu.field_msgSeq);
      localif.FAT = parambu.field_flag;
      localObject = new cwt();
      ((cwt)localObject).aPy(bt.bI(parambu.field_content, ""));
      localif.Fvk = ((cwt)localObject);
      localObject = c.bIf().xx(m.Yv(parambu.getType()));
      if (localObject != null) {
        break;
      }
      ad.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(parambu.getType()) });
      AppMethodBeat.o(21526);
      return null;
      localif.Fvi = new cwt().aPy(parambu.field_talker);
      localif.Fvj = new cwt().aPy(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localif, paramBoolean1, parambu, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
    if (i < 0)
    {
      AppMethodBeat.o(21526);
      return null;
    }
    paramPLong.value += i;
    paramPLong.value += 60L;
    AppMethodBeat.o(21526);
    return localif;
  }
  
  public static boolean xy(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 34) || (paramInt == 42) || (paramInt == 66) || (paramInt == 43) || (paramInt == 43) || (paramInt == 44) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 62) || (paramInt == 10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */