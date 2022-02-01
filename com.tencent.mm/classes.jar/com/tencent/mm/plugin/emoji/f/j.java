package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class j
  extends q
  implements m
{
  private i jQg;
  private final com.tencent.mm.an.d rr;
  private String uFX;
  
  public j(String paramString)
  {
    AppMethodBeat.i(108689);
    d.a locala = new d.a();
    locala.lBU = new btq();
    locala.lBV = new btr();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
    locala.funcId = 239;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uFX = paramString;
    AppMethodBeat.o(108689);
  }
  
  public final btr cVc()
  {
    AppMethodBeat.i(256483);
    if (this.rr == null)
    {
      AppMethodBeat.o(256483);
      return null;
    }
    btr localbtr = (btr)d.c.b(this.rr.lBS);
    AppMethodBeat.o(256483);
    return localbtr;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108691);
    this.jQg = parami;
    ((btq)d.b.b(this.rr.lBR)).DesignerID = this.uFX;
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
      params = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFN;
      paramArrayOfByte = this.uFX;
      localObject = cVc();
      if ((!Util.isNullOrNil(paramArrayOfByte)) && (localObject != null)) {
        break label113;
      }
      Log.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
    }
    for (;;)
    {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108690);
      return;
      try
      {
        label113:
        com.tencent.mm.storage.emotion.j localj = new com.tencent.mm.storage.emotion.j();
        localj.field_designerIDAndType = (paramArrayOfByte + k.a.VII.value);
        localj.field_content = ((btr)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(paramArrayOfByte).append(k.a.VII.value).toString();
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
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.j
 * JD-Core Version:    0.7.0.1
 */