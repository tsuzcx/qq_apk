package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;

public final class g
  extends c
{
  private s ooG;
  private bo ooz;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(s params, String paramString)
  {
    AppMethodBeat.i(123257);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = params.hux;
    localMsgFile.filePath = paramString;
    localMsgFile.fBR = com.tencent.mm.plugin.choosemsgfile.b.d.c.VW(localMsgFile.filePath);
    localMsgFile.type = "video";
    localMsgFile.fileName = (params.getFileName() + "." + localMsgFile.fBR);
    localMsgFile.timeStamp = params.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123257);
  }
  
  protected final boolean bUC()
  {
    AppMethodBeat.i(123255);
    if (this.ooG.aJN())
    {
      o.aJy();
      String str = t.DV(this.ooz.field_imgPath);
      if (i.eA(str))
      {
        a(this.ooG, str);
        AppMethodBeat.o(123255);
        return true;
      }
    }
    AppMethodBeat.o(123255);
    return false;
  }
  
  protected final void bpv()
  {
    AppMethodBeat.i(123256);
    o.aJy().a(new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(123253);
        paramAnonymousa = u.Ej(paramAnonymousa.fileName);
        if (paramAnonymousa != null)
        {
          int i = paramAnonymousa.iaE;
          int j = paramAnonymousa.hux;
          g.this.eT(i, j);
          if (paramAnonymousa.aJN())
          {
            o.aJy();
            String str = t.DV(g.a(g.this).field_imgPath);
            if (i.eA(str))
            {
              g.a(g.this, paramAnonymousa, str);
              AppMethodBeat.o(123253);
              return;
            }
            ac.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
            g.this.bUE();
          }
        }
        AppMethodBeat.o(123253);
      }
    }, Looper.getMainLooper());
    if (this.ooG.aJM())
    {
      ac.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
      u.Eq(this.ooz.field_imgPath);
      AppMethodBeat.o(123256);
      return;
    }
    ac.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
    u.at(this.ooz.field_imgPath, 10);
    u.Ee(this.ooz.field_imgPath);
    AppMethodBeat.o(123256);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123254);
    if ((this.oos == null) || (this.oos.ooz == null))
    {
      ac.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
      AppMethodBeat.o(123254);
      return false;
    }
    this.ooz = this.oos.ooz;
    if (this.ooz.fbQ())
    {
      ac.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", new Object[] { this.ooz });
      AppMethodBeat.o(123254);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).m(this.ooz))
    {
      ac.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", new Object[] { this.ooz });
      AppMethodBeat.o(123254);
      return false;
    }
    this.ooG = u.Ej(this.ooz.field_imgPath);
    if (this.ooG == null)
    {
      ac.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", new Object[] { this.ooz });
      AppMethodBeat.o(123254);
      return false;
    }
    if (this.ooG.status == 198)
    {
      ac.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", new Object[] { this.ooz });
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