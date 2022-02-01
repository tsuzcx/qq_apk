package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static hu a(bl parambl, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(21526);
    if (parambl.field_msgSvrId == 0L)
    {
      ad.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { parambl.field_talker, Integer.valueOf(parambl.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    int j = m.Up(parambl.getType());
    if (!wb(j))
    {
      ad.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { parambl.field_talker, Integer.valueOf(parambl.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    hu localhu = new hu();
    localhu.uKZ = parambl.field_msgSvrId;
    if (parambl.field_isSend == 1)
    {
      localhu.Cxx = new cmf().aEE(paramString);
      localhu.Cxy = new cmf().aEE(parambl.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localhu.CCQ = i;
      localhu.CCV = new SKBuiltinBuffer_t();
      localhu.CCW = 0;
      localhu.CCX = 0;
      localhu.CxC = "";
      localhu.mBH = j;
      localhu.CCR = ((int)(parambl.field_createTime / 1000L));
      localhu.CCZ = parambl.field_createTime;
      localhu.CCY = ((int)parambl.field_msgSeq);
      localhu.CDa = parambl.field_flag;
      localObject = new cmf();
      ((cmf)localObject).aEE(bt.by(parambl.field_content, ""));
      localhu.Cxz = ((cmf)localObject);
      localObject = c.bxa().wa(m.Up(parambl.getType()));
      if (localObject != null) {
        break;
      }
      ad.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(parambl.getType()) });
      AppMethodBeat.o(21526);
      return null;
      localhu.Cxx = new cmf().aEE(parambl.field_talker);
      localhu.Cxy = new cmf().aEE(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localhu, paramBoolean1, parambl, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
    if (i < 0)
    {
      AppMethodBeat.o(21526);
      return null;
    }
    paramPLong.value += i;
    paramPLong.value += 60L;
    AppMethodBeat.o(21526);
    return localhu;
  }
  
  private static boolean wb(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 34) || (paramInt == 42) || (paramInt == 66) || (paramInt == 43) || (paramInt == 43) || (paramInt == 44) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 62) || (paramInt == 10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */