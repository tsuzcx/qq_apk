package com.tencent.mm.plugin.backup.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static boolean Bi(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 34) || (paramInt == 42) || (paramInt == 66) || (paramInt == 43) || (paramInt == 43) || (paramInt == 44) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 62) || (paramInt == 10000);
  }
  
  public static is a(ca paramca, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(21526);
    if (paramca.field_msgSvrId == 0L)
    {
      Log.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { paramca.field_talker, Integer.valueOf(paramca.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    al(paramca);
    int j = m.ahM(paramca.getType());
    if (!Bi(j))
    {
      Log.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { paramca.field_talker, Integer.valueOf(paramca.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    is localis = new is();
    localis.Brn = paramca.field_msgSvrId;
    if (paramca.field_isSend == 1)
    {
      localis.KHl = new dqi().bhy(paramString);
      localis.KHm = new dqi().bhy(paramca.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localis.KMN = i;
      localis.KMS = new SKBuiltinBuffer_t();
      localis.KMT = 0;
      localis.KMU = 0;
      localis.KHq = "";
      localis.oUv = j;
      localis.KMO = ((int)(paramca.field_createTime / 1000L));
      localis.KMW = paramca.field_createTime;
      localis.KMV = ((int)paramca.field_msgSeq);
      localis.KMX = paramca.field_flag;
      localObject = new dqi();
      ((dqi)localObject).bhy(Util.nullAs(paramca.field_content, ""));
      localis.KHn = ((dqi)localObject);
      localObject = c.cfW().Bh(m.ahM(paramca.getType()));
      if (localObject != null) {
        break;
      }
      Log.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(paramca.getType()) });
      AppMethodBeat.o(21526);
      return null;
      localis.KHl = new dqi().bhy(paramca.field_talker);
      localis.KHm = new dqi().bhy(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localis, paramBoolean1, paramca, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
    if (i < 0)
    {
      AppMethodBeat.o(21526);
      return null;
    }
    paramPLong.value += i;
    paramPLong.value += 60L;
    AppMethodBeat.o(21526);
    return localis;
  }
  
  private static void al(ca paramca)
  {
    AppMethodBeat.i(231595);
    if ((paramca != null) && (paramca.getType() == 10002) && ((paramca.fqJ & 0x4) == 4))
    {
      paramca.setContent(MMApplicationContext.getContext().getString(2131757506));
      paramca.setType(10000);
    }
    AppMethodBeat.o(231595);
  }
  
  public static final class a
  {
    public String md5;
    public u oNI;
    public long oNJ;
    public String oNK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */