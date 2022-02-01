package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class g
  extends c
{
  private com.tencent.mm.modelvideo.s qnC;
  private ca qnv;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(com.tencent.mm.modelvideo.s params, String paramString)
  {
    AppMethodBeat.i(123257);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = params.iKP;
    localMsgFile.filePath = paramString;
    localMsgFile.gCr = com.tencent.mm.plugin.choosemsgfile.b.d.c.akC(localMsgFile.filePath);
    localMsgFile.type = "video";
    localMsgFile.fileName = (params.getFileName() + "." + localMsgFile.gCr);
    localMsgFile.timeStamp = params.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123257);
  }
  
  protected final void bPM()
  {
    AppMethodBeat.i(123256);
    o.bhj().a(new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(123253);
        paramAnonymousa = u.QN(paramAnonymousa.fileName);
        if (paramAnonymousa != null)
        {
          int i = paramAnonymousa.jsj;
          int j = paramAnonymousa.iKP;
          g.this.fl(i, j);
          if (paramAnonymousa.bhy())
          {
            o.bhj();
            String str = t.Qw(g.a(g.this).field_imgPath);
            if (com.tencent.mm.vfs.s.YS(str))
            {
              g.a(g.this, paramAnonymousa, str);
              AppMethodBeat.o(123253);
              return;
            }
            Log.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
            g.this.cyp();
          }
        }
        AppMethodBeat.o(123253);
      }
    }, Looper.getMainLooper());
    if (this.qnC.bhx())
    {
      Log.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
      u.QT(this.qnv.field_imgPath);
      AppMethodBeat.o(123256);
      return;
    }
    Log.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
    u.aA(this.qnv.field_imgPath, 10);
    u.QI(this.qnv.field_imgPath);
    AppMethodBeat.o(123256);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123254);
    if ((this.qno == null) || (this.qno.qnv == null))
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
      AppMethodBeat.o(123254);
      return false;
    }
    this.qnv = this.qno.qnv;
    if (this.qnv.gDB())
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", new Object[] { this.qnv });
      AppMethodBeat.o(123254);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.b.class)).m(this.qnv))
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", new Object[] { this.qnv });
      AppMethodBeat.o(123254);
      return false;
    }
    this.qnC = u.QN(this.qnv.field_imgPath);
    if (this.qnC == null)
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", new Object[] { this.qnv });
      AppMethodBeat.o(123254);
      return false;
    }
    if (this.qnC.status == 198)
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", new Object[] { this.qnv });
      AppMethodBeat.o(123254);
      return false;
    }
    AppMethodBeat.o(123254);
    return true;
  }
  
  protected final boolean cyn()
  {
    AppMethodBeat.i(123255);
    if (this.qnC.bhy())
    {
      o.bhj();
      String str = t.Qw(this.qnv.field_imgPath);
      if (com.tencent.mm.vfs.s.YS(str))
      {
        a(this.qnC, str);
        AppMethodBeat.o(123255);
        return true;
      }
    }
    AppMethodBeat.o(123255);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.g
 * JD-Core Version:    0.7.0.1
 */