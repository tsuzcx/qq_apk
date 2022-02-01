package com.tencent.mm.plugin.backup.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.LinkedList;

public final class h
{
  public static boolean Fk(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 34) || (paramInt == 42) || (paramInt == 66) || (paramInt == 43) || (paramInt == 43) || (paramInt == 44) || (paramInt == 47) || (paramInt == 48) || (paramInt == 49) || (paramInt == 62) || (paramInt == 10000);
  }
  
  public static jd a(cc paramcc, boolean paramBoolean1, String paramString, PLong paramPLong, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    AppMethodBeat.i(21526);
    if (paramcc.field_msgSvrId == 0L)
    {
      Log.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[] { paramcc.field_talker, Integer.valueOf(paramcc.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    aB(paramcc);
    int j = n.va(paramcc.getType());
    if (!Fk(j))
    {
      Log.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", new Object[] { paramcc.field_talker, Integer.valueOf(paramcc.getType()) });
      AppMethodBeat.o(21526);
      return null;
    }
    jd localjd = new jd();
    localjd.Njv = paramcc.field_msgSvrId;
    if (paramcc.field_isSend == 1)
    {
      localjd.YFE = new etl().btH(paramString);
      localjd.YFF = new etl().btH(paramcc.field_talker);
      i = 2;
    }
    Object localObject;
    for (;;)
    {
      localjd.YKV = i;
      localjd.YLa = new gol();
      localjd.YLb = 0;
      localjd.YLc = 0;
      localjd.YFJ = "";
      localjd.vhJ = j;
      localjd.YKW = ((int)(paramcc.getCreateTime() / 1000L));
      localjd.YLe = paramcc.getCreateTime();
      localjd.YLd = ((int)paramcc.field_msgSeq);
      localjd.YLf = paramcc.field_flag;
      localObject = new etl();
      ((etl)localObject).btH(Util.nullAs(paramcc.field_content, ""));
      localjd.YFG = ((etl)localObject);
      localObject = c.cVS().Fj(n.va(paramcc.getType()));
      if (localObject != null) {
        break;
      }
      Log.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[] { Integer.valueOf(paramcc.getType()) });
      AppMethodBeat.o(21526);
      return null;
      localjd.YFE = new etl().btH(paramcc.field_talker);
      localjd.YFF = new etl().btH(paramString);
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 4;
      }
    }
    int i = ((l)localObject).a(localjd, paramBoolean1, paramcc, paramString, paramLinkedList, paramHashMap, paramBoolean3, paramLong);
    if (i < 0)
    {
      AppMethodBeat.o(21526);
      return null;
    }
    paramPLong.value += i;
    paramPLong.value += 60L;
    AppMethodBeat.o(21526);
    return localjd;
  }
  
  private static void aB(cc paramcc)
  {
    AppMethodBeat.i(300695);
    if (paramcc != null)
    {
      if (((paramcc.getType() == 10002) || (paramcc.getType() == 268445458)) && ((paramcc.jUq & 0x4) == 4))
      {
        paramcc.setContent(MMApplicationContext.getContext().getString(R.l.gzs));
        paramcc.setType(10000);
      }
      if (paramcc.getType() == 268445456)
      {
        paramcc.setContent(paramcc.kLy);
        paramcc.setType(10000);
      }
    }
    AppMethodBeat.o(300695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.h
 * JD-Core Version:    0.7.0.1
 */