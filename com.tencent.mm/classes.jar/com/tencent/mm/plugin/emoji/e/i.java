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
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.k.a;
import java.io.IOException;

public final class i
  extends p
  implements m
{
  private com.tencent.mm.am.h mAY;
  public int pTf;
  private final c rr;
  private int xOv;
  public byte[] xOw;
  private int xOx;
  private String xOy;
  private int xOz;
  
  public i(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108686);
    c.a locala = new c.a();
    locala.otE = new cih();
    locala.otF = new cii();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.funcId = 821;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.pTf = paramInt1;
    this.xOv = paramInt2;
    this.xOx = paramInt3;
    this.xOy = paramString;
    this.xOw = paramArrayOfByte;
    this.xOz = paramInt4;
    AppMethodBeat.o(108686);
  }
  
  public final cii dAA()
  {
    AppMethodBeat.i(269829);
    if (this.rr == null)
    {
      AppMethodBeat.o(269829);
      return null;
    }
    cii localcii = (cii)c.c.b(this.rr.otC);
    AppMethodBeat.o(269829);
    return localcii;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108688);
    this.mAY = paramh;
    cih localcih = (cih)c.b.b(this.rr.otB);
    if (this.xOw != null)
    {
      localcih.aaqV = w.aN(this.xOw);
      if (localcih.aaqV != null) {
        break label139;
      }
    }
    label139:
    for (paramh = "Buf is NULL";; paramh = localcih.aaqV.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", paramh);
      localcih.ZtX = this.xOv;
      localcih.YIq = this.pTf;
      localcih.ZtG = this.xOx;
      localcih.aaqW = this.xOy;
      localcih.aaqX = this.xOz;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108688);
      return i;
      localcih.aaqV = new gol();
      break;
    }
  }
  
  public final int getType()
  {
    return 821;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108687);
    Log.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    Object localObject;
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.xOw == null) || (this.xOw.length <= 0)) && (this.pTf != 3) && (this.xOv != 0)))
    {
      paramArrayOfByte = ((d)com.tencent.mm.kernel.h.az(d.class)).getEmojiStorageMgr().adjB;
      str = this.xOv;
      localObject = dAA();
      if ((!Util.isNullOrNil(str)) && (localObject != null)) {
        break label207;
      }
      Log.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      params = (cii)c.c.b(((c)params).otC);
      if (params.aaqV != null) {
        this.xOw = w.a(params.aaqV);
      }
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108687);
      return;
      try
      {
        label207:
        j localj = new j();
        localj.field_designerIDAndType = (str + k.a.admG.value);
        localj.field_content = ((cii)localObject).toByteArray();
        localObject = localj.convertTo();
        new StringBuilder().append(str).append(k.a.admG.value).toString();
        if (paramArrayOfByte.db.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label355;
        }
        Log.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[] { str });
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      }
      continue;
      label355:
      Log.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.i
 * JD-Core Version:    0.7.0.1
 */