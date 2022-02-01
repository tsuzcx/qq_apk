package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;

public final class g
  extends c
{
  private s oYD;
  private bv oYw;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(s params, String paramString)
  {
    AppMethodBeat.i(123257);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = params.hPI;
    localMsgFile.filePath = paramString;
    localMsgFile.fXl = com.tencent.mm.plugin.choosemsgfile.b.d.c.aaw(localMsgFile.filePath);
    localMsgFile.type = "video";
    localMsgFile.fileName = (params.getFileName() + "." + localMsgFile.fXl);
    localMsgFile.timeStamp = params.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123257);
  }
  
  protected final void buf()
  {
    AppMethodBeat.i(123256);
    com.tencent.mm.modelvideo.o.aNh().a(new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(123253);
        paramAnonymousa = u.Ia(paramAnonymousa.fileName);
        if (paramAnonymousa != null)
        {
          int i = paramAnonymousa.iwU;
          int j = paramAnonymousa.hPI;
          g.this.eY(i, j);
          if (paramAnonymousa.aNw())
          {
            com.tencent.mm.modelvideo.o.aNh();
            String str = t.HJ(g.a(g.this).field_imgPath);
            if (com.tencent.mm.vfs.o.fB(str))
            {
              g.a(g.this, paramAnonymousa, str);
              AppMethodBeat.o(123253);
              return;
            }
            ae.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
            g.this.cay();
          }
        }
        AppMethodBeat.o(123253);
      }
    }, Looper.getMainLooper());
    if (this.oYD.aNv())
    {
      ae.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
      u.Ih(this.oYw.field_imgPath);
      AppMethodBeat.o(123256);
      return;
    }
    ae.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
    u.aw(this.oYw.field_imgPath, 10);
    u.HV(this.oYw.field_imgPath);
    AppMethodBeat.o(123256);
  }
  
  protected final boolean caw()
  {
    AppMethodBeat.i(123255);
    if (this.oYD.aNw())
    {
      com.tencent.mm.modelvideo.o.aNh();
      String str = t.HJ(this.oYw.field_imgPath);
      if (com.tencent.mm.vfs.o.fB(str))
      {
        a(this.oYD, str);
        AppMethodBeat.o(123255);
        return true;
      }
    }
    AppMethodBeat.o(123255);
    return false;
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123254);
    if ((this.oYp == null) || (this.oYp.oYw == null))
    {
      ae.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
      AppMethodBeat.o(123254);
      return false;
    }
    this.oYw = this.oYp.oYw;
    if (this.oYw.fvU())
    {
      ae.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", new Object[] { this.oYw });
      AppMethodBeat.o(123254);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).m(this.oYw))
    {
      ae.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", new Object[] { this.oYw });
      AppMethodBeat.o(123254);
      return false;
    }
    this.oYD = u.Ia(this.oYw.field_imgPath);
    if (this.oYD == null)
    {
      ae.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", new Object[] { this.oYw });
      AppMethodBeat.o(123254);
      return false;
    }
    if (this.oYD.status == 198)
    {
      ae.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", new Object[] { this.oYw });
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