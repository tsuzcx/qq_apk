package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.protocal.c.gk;
import com.tencent.mm.protocal.c.gl;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class c
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.as.a.c.c iXU = new c.1(this);
  
  public static void bx(String paramString, int paramInt)
  {
    q localq = new q();
    localq.bFD.bFE = paramString;
    localq.bFD.status = paramInt;
    localq.bFD.bFF = 0;
    com.tencent.mm.sdk.b.a.udP.m(localq);
    y.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "attachid:%s percentage:%d status:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    default: 
      y.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no download app attach scene");
    case 221: 
      return;
    }
    String str1 = "";
    Object localObject = (com.tencent.mm.plugin.emoji.f.f)paramm;
    if (((com.tencent.mm.plugin.emoji.f.f)localObject).iZz == com.tencent.mm.plugin.emoji.f.f.iZx)
    {
      if (((com.tencent.mm.plugin.emoji.f.f)localObject).dmK == null)
      {
        paramm = null;
        paramString = str1;
        if (paramm != null)
        {
          paramString = str1;
          if (paramm.sAt != null)
          {
            paramString = str1;
            if (paramm.sAt.size() > 0) {
              paramString = (String)paramm.sAt.get(0);
            }
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label549;
        }
        if (((com.tencent.mm.plugin.emoji.f.f)localObject).dmK != null) {
          break label222;
        }
      }
      label222:
      for (paramm = null;; paramm = (gl)((com.tencent.mm.plugin.emoji.f.f)localObject).dmK.ecF.ecN)
      {
        if ((paramm != null) && (paramm.sAu != null) && (paramm.sAu.size() > 0)) {
          break label241;
        }
        bx(paramString, 2);
        y.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "NetSceneBatchEmojiDownLoad MD5 to URL failed.");
        return;
        paramm = (gk)((com.tencent.mm.plugin.emoji.f.f)localObject).dmK.ecE.ecN;
        break;
      }
      label241:
      paramm = (ut)paramm.sAu.get(0);
      str1 = EmojiLogic.J(com.tencent.mm.plugin.emoji.h.b.FL(), "", paramm.jnU);
      String str2;
      if ((l.aHF()) && (l.aHG()) && (!bk.bl(paramm.sRv)) && (!bk.bl(paramm.sRw)))
      {
        paramString = i.aHr();
        localObject = paramm.sRv;
        str2 = paramm.sRv;
        paramString.a((String)localObject, e.p(str1 + "_extern", new Object[] { paramm, Integer.valueOf(101) }), this.iXU);
        return;
      }
      if ((!bk.bl(paramm.sRt)) && (!bk.bl(paramm.sRu)))
      {
        paramString = i.aHr();
        localObject = paramm.sRt;
        str2 = paramm.sRt;
        paramString.a((String)localObject, e.p(str1 + "_encrypt", new Object[] { paramm, Integer.valueOf(102) }), this.iXU);
        com.tencent.mm.plugin.emoji.c.dt(6L);
        return;
      }
      if (!bk.bl(paramm.kSC))
      {
        paramString = i.aHr();
        localObject = paramm.kSC;
        str2 = paramm.kSC;
        paramString.a((String)localObject, e.o(str1, new Object[] { paramm, Integer.valueOf(100) }), this.iXU);
        com.tencent.mm.plugin.emoji.c.dt(1L);
        return;
      }
      y.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no url info. download faild.");
      bx(paramString, 2);
      return;
      label549:
      bx(paramString, 2);
      return;
    }
    y.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no request type ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c
 * JD-Core Version:    0.7.0.1
 */