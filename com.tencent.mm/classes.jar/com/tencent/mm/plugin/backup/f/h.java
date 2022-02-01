package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static hy a(bo parambo, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(21526);
    if (parambo.field_msgSvrId == 0L)
    {
      ac.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { parambo.field_talker, Integer.valueOf(parambo.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    int j = m.Wz(parambo.getType());
    if (!wS(j))
    {
      ac.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { parambo.field_talker, Integer.valueOf(parambo.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    hy localhy = new hy();
    localhy.vTQ = parambo.field_msgSvrId;
    if (parambo.field_isSend == 1)
    {
      localhy.DPT = new crm().aJV(paramString);
      localhy.DPU = new crm().aJV(parambo.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localhy.DVn = i;
      localhy.DVs = new SKBuiltinBuffer_t();
      localhy.DVt = 0;
      localhy.DVu = 0;
      localhy.DPY = "";
      localhy.ndI = j;
      localhy.DVo = ((int)(parambo.field_createTime / 1000L));
      localhy.DVw = parambo.field_createTime;
      localhy.DVv = ((int)parambo.field_msgSeq);
      localhy.DVx = parambo.field_flag;
      localObject = new crm();
      ((crm)localObject).aJV(bs.bG(parambo.field_content, ""));
      localhy.DPV = ((crm)localObject);
      localObject = c.bDW().wR(m.Wz(parambo.getType()));
      if (localObject != null) {
        break;
      }
      ac.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(parambo.getType()) });
      AppMethodBeat.o(21526);
      return null;
      localhy.DPT = new crm().aJV(parambo.field_talker);
      localhy.DPU = new crm().aJV(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localhy, paramBoolean1, parambo, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
    if (i < 0)
    {
      AppMethodBeat.o(21526);
      return null;
    }
    paramPLong.value += i;
    paramPLong.value += 60L;
    AppMethodBeat.o(21526);
    return localhy;
  }
  
  private static boolean wS(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 34) || (paramInt == 42) || (paramInt == 66) || (paramInt == 43) || (paramInt == 43) || (paramInt == 44) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 62) || (paramInt == 10000);
  }
  
  public static final class a
  {
    public u mWT;
    public long mWU;
    public String mWV;
    public String md5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */