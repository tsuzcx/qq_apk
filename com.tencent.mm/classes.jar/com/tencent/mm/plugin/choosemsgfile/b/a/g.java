package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;

public final class g
  extends c
{
  private s nLG;
  private bl nLz;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(s params, String paramString)
  {
    AppMethodBeat.i(123257);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = params.gTY;
    localMsgFile.filePath = paramString;
    localMsgFile.fyk = com.tencent.mm.plugin.choosemsgfile.b.d.c.RK(localMsgFile.filePath);
    localMsgFile.type = "video";
    localMsgFile.fileName = (params.getFileName() + "." + localMsgFile.fyk);
    localMsgFile.timeStamp = params.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123257);
  }
  
  protected final boolean bNr()
  {
    AppMethodBeat.i(123255);
    if (this.nLG.aCW())
    {
      o.aCI();
      String str = t.zQ(this.nLz.field_imgPath);
      if (i.eK(str))
      {
        a(this.nLG, str);
        AppMethodBeat.o(123255);
        return true;
      }
    }
    AppMethodBeat.o(123255);
    return false;
  }
  
  protected final void biB()
  {
    AppMethodBeat.i(123256);
    o.aCI().a(new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(123253);
        paramAnonymousa = u.Ae(paramAnonymousa.fileName);
        if (paramAnonymousa != null)
        {
          int i = paramAnonymousa.hAd;
          int j = paramAnonymousa.gTY;
          g.this.eQ(i, j);
          if (paramAnonymousa.aCW())
          {
            o.aCI();
            String str = t.zQ(g.a(g.this).field_imgPath);
            if (i.eK(str))
            {
              g.a(g.this, paramAnonymousa, str);
              AppMethodBeat.o(123253);
              return;
            }
            ad.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
            g.this.bNt();
          }
        }
        AppMethodBeat.o(123253);
      }
    }, Looper.getMainLooper());
    if (this.nLG.aCV())
    {
      ad.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
      u.Al(this.nLz.field_imgPath);
      AppMethodBeat.o(123256);
      return;
    }
    ad.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
    u.ap(this.nLz.field_imgPath, 10);
    u.zZ(this.nLz.field_imgPath);
    AppMethodBeat.o(123256);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123254);
    if ((this.nLs == null) || (this.nLs.nLz == null))
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
      AppMethodBeat.o(123254);
      return false;
    }
    this.nLz = this.nLs.nLz;
    if (this.nLz.eMl())
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", new Object[] { this.nLz });
      AppMethodBeat.o(123254);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).m(this.nLz))
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", new Object[] { this.nLz });
      AppMethodBeat.o(123254);
      return false;
    }
    this.nLG = u.Ae(this.nLz.field_imgPath);
    if (this.nLG == null)
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", new Object[] { this.nLz });
      AppMethodBeat.o(123254);
      return false;
    }
    if (this.nLG.status == 198)
    {
      ad.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", new Object[] { this.nLz });
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