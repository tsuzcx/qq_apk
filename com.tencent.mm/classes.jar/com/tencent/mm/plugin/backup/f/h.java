package com.tencent.mm.plugin.backup.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static boolean EJ(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 34) || (paramInt == 42) || (paramInt == 66) || (paramInt == 43) || (paramInt == 43) || (paramInt == 44) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 62) || (paramInt == 10000);
  }
  
  public static ih a(ca paramca, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(21526);
    if (paramca.field_msgSvrId == 0L)
    {
      Log.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { paramca.field_talker, Integer.valueOf(paramca.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    at(paramca);
    int j = m.apL(paramca.getType());
    if (!EJ(j))
    {
      Log.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { paramca.field_talker, Integer.valueOf(paramca.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    ih localih = new ih();
    localih.HlH = paramca.field_msgSvrId;
    if (paramca.field_isSend == 1)
    {
      localih.RID = new eaf().btQ(paramString);
      localih.RIE = new eaf().btQ(paramca.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localih.RNH = i;
      localih.RNM = new eae();
      localih.RNN = 0;
      localih.RNO = 0;
      localih.RII = "";
      localih.rWu = j;
      localih.RNI = ((int)(paramca.field_createTime / 1000L));
      localih.RNQ = paramca.field_createTime;
      localih.RNP = ((int)paramca.field_msgSeq);
      localih.RNR = paramca.field_flag;
      localObject = new eaf();
      ((eaf)localObject).btQ(Util.nullAs(paramca.field_content, ""));
      localih.RIF = ((eaf)localObject);
      localObject = c.cti().EI(m.apL(paramca.getType()));
      if (localObject != null) {
        break;
      }
      Log.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(paramca.getType()) });
      AppMethodBeat.o(21526);
      return null;
      localih.RID = new eaf().btQ(paramca.field_talker);
      localih.RIE = new eaf().btQ(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localih, paramBoolean1, paramca, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
    if (i < 0)
    {
      AppMethodBeat.o(21526);
      return null;
    }
    paramPLong.value += i;
    paramPLong.value += 60L;
    AppMethodBeat.o(21526);
    return localih;
  }
  
  private static void at(ca paramca)
  {
    AppMethodBeat.i(276105);
    if (paramca != null)
    {
      if (((paramca.getType() == 10002) || (paramca.getType() == 268445458)) && ((paramca.hxx & 0x4) == 4))
      {
        paramca.setContent(MMApplicationContext.getContext().getString(R.l.ewP));
        paramca.setType(10000);
      }
      if (paramca.getType() == 268445456)
      {
        paramca.setContent(paramca.ilz);
        paramca.setType(10000);
      }
    }
    AppMethodBeat.o(276105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */