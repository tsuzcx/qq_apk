package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.c.aer;
import com.tencent.mm.protocal.c.aes;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.h;
import com.tencent.mm.storage.emotion.h.a;
import java.io.IOException;

public final class i
  extends m
  implements k
{
  private f dIJ;
  private final b dmK;
  public int fgi;
  private int iZL;
  public byte[] iZM;
  private int iZN;
  private String iZO;
  private int iZP;
  
  public i(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    b.a locala = new b.a();
    locala.ecH = new aer();
    locala.ecI = new aes();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
    locala.ecG = 821;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.fgi = paramInt1;
    this.iZL = paramInt2;
    this.iZN = paramInt3;
    this.iZO = paramString;
    this.iZM = paramArrayOfByte;
    this.iZP = paramInt4;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dIJ = paramf;
    aer localaer = (aer)this.dmK.ecE.ecN;
    if (this.iZM != null)
    {
      localaer.tcI = aa.I(this.iZM);
      if (localaer.tcI != null) {
        break label118;
      }
    }
    label118:
    for (paramf = "Buf is NULL";; paramf = localaer.tcI.toString())
    {
      y.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", paramf);
      localaer.tcH = this.iZL;
      localaer.ssq = this.fgi;
      localaer.sRy = this.iZN;
      localaer.tcJ = this.iZO;
      localaer.tcK = this.iZP;
      return a(parame, this.dmK, this);
      localaer.tcI = new bmk();
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    String str;
    Object localObject;
    if (((paramInt2 == 0) && (paramInt3 == 0)) || ((paramInt2 == 4) && ((paramInt3 == 2) || (paramInt3 == 3)) && ((this.iZM == null) || (this.iZM.length <= 0)) && (this.fgi != 3)))
    {
      paramArrayOfByte = ((d)com.tencent.mm.kernel.g.t(d.class)).getEmojiStorageMgr().uBh;
      str = this.iZL;
      localObject = aId();
      if ((!bk.bl(str)) && (localObject != null)) {
        break label190;
      }
      y.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
    }
    for (;;)
    {
      paramq = (aes)((b)paramq).ecF.ecN;
      if (paramq.tcI != null) {
        this.iZM = aa.a(paramq.tcI);
      }
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      try
      {
        label190:
        com.tencent.mm.storage.emotion.g localg = new com.tencent.mm.storage.emotion.g();
        localg.field_designerIDAndType = (str + h.a.uDt.value);
        localg.field_content = ((aes)localObject).toByteArray();
        localObject = localg.vf();
        new StringBuilder().append(str).append(h.a.uDt.value).toString();
        if (paramArrayOfByte.dXw.replace("EmotionDesignerInfo", "designerIDAndType", (ContentValues)localObject) <= 0L) {
          break label335;
        }
        y.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[] { str });
      }
      catch (IOException paramArrayOfByte)
      {
        y.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[] { bk.j(paramArrayOfByte) });
      }
      continue;
      label335:
      y.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[] { str });
    }
  }
  
  public final aes aId()
  {
    if (this.dmK == null) {
      return null;
    }
    return (aes)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 821;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.i
 * JD-Core Version:    0.7.0.1
 */