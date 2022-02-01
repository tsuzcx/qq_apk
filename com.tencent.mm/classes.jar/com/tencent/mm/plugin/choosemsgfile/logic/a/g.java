package com.tencent.mm.plugin.choosemsgfile.logic.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;

public final class g
  extends c
{
  private z wPF;
  private cc wPy;
  
  public g(com.tencent.mm.plugin.choosemsgfile.logic.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(z paramz, String paramString)
  {
    AppMethodBeat.i(123257);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramz.osy;
    localMsgFile.filePath = paramString;
    localMsgFile.lPJ = com.tencent.mm.plugin.choosemsgfile.logic.c.c.alV(localMsgFile.filePath);
    localMsgFile.type = "video";
    localMsgFile.fileName = (paramz.getFileName() + "." + localMsgFile.lPJ);
    localMsgFile.timeStamp = paramz.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123257);
  }
  
  protected final void cCw()
  {
    AppMethodBeat.i(123256);
    v.bOh().a(new aa.a()
    {
      public final void a(aa.a.a paramAnonymousa)
      {
        AppMethodBeat.i(123253);
        paramAnonymousa = ab.Qo(paramAnonymousa.fileName);
        if (paramAnonymousa != null)
        {
          int i = paramAnonymousa.paX;
          int j = paramAnonymousa.osy;
          g.this.gA(i, j);
          if (paramAnonymousa.bOx())
          {
            v.bOh();
            String str = aa.PX(g.a(g.this).field_imgPath);
            if (y.ZC(str))
            {
              g.a(g.this, paramAnonymousa, str);
              AppMethodBeat.o(123253);
              return;
            }
            Log.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
            g.this.dqo();
          }
        }
        AppMethodBeat.o(123253);
      }
    }, Looper.getMainLooper());
    if (this.wPF.bOw())
    {
      Log.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
      ab.Qu(this.wPy.field_imgPath);
      AppMethodBeat.o(123256);
      return;
    }
    Log.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
    ab.bh(this.wPy.field_imgPath, 10);
    ab.Qj(this.wPy.field_imgPath);
    AppMethodBeat.o(123256);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123254);
    if ((this.wPs == null) || (this.wPs.wPy == null))
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
      AppMethodBeat.o(123254);
      return false;
    }
    this.wPy = this.wPs.wPy;
    if (this.wPy.isClean())
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", new Object[] { this.wPy });
      AppMethodBeat.o(123254);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).m(this.wPy))
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", new Object[] { this.wPy });
      AppMethodBeat.o(123254);
      return false;
    }
    this.wPF = ab.Qo(this.wPy.field_imgPath);
    if (this.wPF == null)
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", new Object[] { this.wPy });
      AppMethodBeat.o(123254);
      return false;
    }
    if (this.wPF.status == 198)
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", new Object[] { this.wPy });
      AppMethodBeat.o(123254);
      return false;
    }
    AppMethodBeat.o(123254);
    return true;
  }
  
  protected final boolean dqm()
  {
    AppMethodBeat.i(123255);
    if (this.wPF.bOx())
    {
      v.bOh();
      String str = aa.PX(this.wPy.field_imgPath);
      if (y.ZC(str))
      {
        a(this.wPF, str);
        AppMethodBeat.o(123255);
        return true;
      }
    }
    AppMethodBeat.o(123255);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.a.g
 * JD-Core Version:    0.7.0.1
 */