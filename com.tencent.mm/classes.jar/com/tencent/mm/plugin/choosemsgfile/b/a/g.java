package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.i;

public final class g
  extends c
{
  private bu oRU;
  private s oSb;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(s params, String paramString)
  {
    AppMethodBeat.i(123257);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = params.hMP;
    localMsgFile.filePath = paramString;
    localMsgFile.fVf = com.tencent.mm.plugin.choosemsgfile.b.d.c.ZF(localMsgFile.filePath);
    localMsgFile.type = "video";
    localMsgFile.fileName = (params.getFileName() + "." + localMsgFile.fVf);
    localMsgFile.timeStamp = params.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123257);
  }
  
  protected final boolean bZh()
  {
    AppMethodBeat.i(123255);
    if (this.oSb.aMY())
    {
      o.aMJ();
      String str = t.Hh(this.oRU.field_imgPath);
      if (i.fv(str))
      {
        a(this.oSb, str);
        AppMethodBeat.o(123255);
        return true;
      }
    }
    AppMethodBeat.o(123255);
    return false;
  }
  
  protected final void btu()
  {
    AppMethodBeat.i(123256);
    o.aMJ().a(new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(123253);
        paramAnonymousa = u.Hy(paramAnonymousa.fileName);
        if (paramAnonymousa != null)
        {
          int i = paramAnonymousa.iua;
          int j = paramAnonymousa.hMP;
          g.this.eX(i, j);
          if (paramAnonymousa.aMY())
          {
            o.aMJ();
            String str = t.Hh(g.a(g.this).field_imgPath);
            if (i.fv(str))
            {
              g.a(g.this, paramAnonymousa, str);
              AppMethodBeat.o(123253);
              return;
            }
            ad.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
            g.this.bZj();
          }
        }
        AppMethodBeat.o(123253);
      }
    }, Looper.getMainLooper());
    if (this.oSb.aMX())
    {
      ad.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
      u.HF(this.oRU.field_imgPath);
      AppMethodBeat.o(123256);
      return;
    }
    ad.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
    u.av(this.oRU.field_imgPath, 10);
    u.Ht(this.oRU.field_imgPath);
    AppMethodBeat.o(123256);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123254);
    if ((this.oRN == null) || (this.oRN.oRU == null))
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
      AppMethodBeat.o(123254);
      return false;
    }
    this.oRU = this.oRN.oRU;
    if (this.oRU.frT())
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", new Object[] { this.oRU });
      AppMethodBeat.o(123254);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).m(this.oRU))
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", new Object[] { this.oRU });
      AppMethodBeat.o(123254);
      return false;
    }
    this.oSb = u.Hy(this.oRU.field_imgPath);
    if (this.oSb == null)
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", new Object[] { this.oRU });
      AppMethodBeat.o(123254);
      return false;
    }
    if (this.oSb.status == 198)
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", new Object[] { this.oRU });
      AppMethodBeat.o(123254);
      return false;
    }
    AppMethodBeat.o(123254);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.g
 * JD-Core Version:    0.7.0.1
 */