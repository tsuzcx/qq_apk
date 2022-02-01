package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static if a(bv parambv, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(21526);
    if (parambv.field_msgSvrId == 0L)
    {
      ae.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { parambv.field_talker, Integer.valueOf(parambv.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    int j = m.Zb(parambv.getType());
    if (!xC(j))
    {
      ae.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { parambv.field_talker, Integer.valueOf(parambv.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    if localif = new if();
    localif.xrk = parambv.field_msgSvrId;
    if (parambv.field_isSend == 1)
    {
      localif.FNG = new cxn().aQV(paramString);
      localif.FNH = new cxn().aQV(parambv.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localif.FTe = i;
      localif.FTj = new SKBuiltinBuffer_t();
      localif.FTk = 0;
      localif.FTl = 0;
      localif.FNL = "";
      localif.nJA = j;
      localif.FTf = ((int)(parambv.field_createTime / 1000L));
      localif.FTn = parambv.field_createTime;
      localif.FTm = ((int)parambv.field_msgSeq);
      localif.FTo = parambv.field_flag;
      localObject = new cxn();
      ((cxn)localObject).aQV(bu.bI(parambv.field_content, ""));
      localif.FNI = ((cxn)localObject);
      localObject = c.bJd().xB(m.Zb(parambv.getType()));
      if (localObject != null) {
        break;
      }
      ae.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(parambv.getType()) });
      AppMethodBeat.o(21526);
      return null;
      localif.FNG = new cxn().aQV(parambv.field_talker);
      localif.FNH = new cxn().aQV(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localif, paramBoolean1, parambv, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
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
  
  public static boolean xC(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 34) || (paramInt == 42) || (paramInt == 66) || (paramInt == 43) || (paramInt == 43) || (paramInt == 44) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 62) || (paramInt == 10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */