package com.tencent.mm.plugin.emoji.e;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class j
  extends p
  implements m
{
  private com.tencent.mm.am.h mAY;
  private final c rr;
  private String xOA;
  
  public j(String paramString)
  {
    AppMethodBeat.i(108689);
    c.a locala = new c.a();
    locala.otE = new cij();
    locala.otF = new cik();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
    locala.funcId = 239;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xOA = paramString;
    AppMethodBeat.o(108689);
  }
  
  public final cik dAB()
  {
    AppMethodBeat.i(269815);
    if (this.rr == null)
    {
      AppMethodBeat.o(269815);
      return null;
    }
    cik localcik = (cik)c.c.b(this.rr.otC);
    AppMethodBeat.o(269815);
    return localcik;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108691);
    this.mAY = paramh;
    ((cij)c.b.b(this.rr.otB)).DesignerID = this.xOA;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108691);
    return i;
  }
  
  public final int getType()
  {
    return 239;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108690);
    Log.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = ((d)com.tencent.mm.kernel.h.az(d.class)).getEmojiStorageMgr().adjB;
      paramArrayOfByte = this.xOA;
      localObject = dAB();
      if ((!Util.isNullOrNil(paramArrayOfByte)) && (localObject != null)) {
        break label113;
      }
      Log.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
    }
    for (;;)
    {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108690);
      return;
      try
      {
        label113:
        com.tencent.mm.storage.emotion.j localj = new com.tencent.mm.storage.emotion.j();
        localj.field_designerIDAndType = (paramArrayOfByte + k.a.admE.value);
        localj.field_content = ((cik)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(paramArrayOfByte).append(k.a.admE.value).toString();
        if (params.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label257;
        }
        Log.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[] { paramArrayOfByte });
      }
      catch (IOException params)
      {
        Log.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { Util.stackTraceToString(params) });
      }
      continue;
      label257:
      Log.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[] { paramArrayOfByte });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.j
 * JD-Core Version:    0.7.0.1
 */