package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;

public final class g
  extends c
{
  private ca tMi;
  private w tMp;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(w paramw, String paramString)
  {
    AppMethodBeat.i(123257);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramw.lAW;
    localMsgFile.filePath = paramString;
    localMsgFile.jmx = com.tencent.mm.plugin.choosemsgfile.b.d.c.asq(localMsgFile.filePath);
    localMsgFile.type = "video";
    localMsgFile.fileName = (paramw.getFileName() + "." + localMsgFile.jmx);
    localMsgFile.timeStamp = paramw.createTime;
    b(localMsgFile);
    AppMethodBeat.o(123257);
  }
  
  protected final boolean cMI()
  {
    AppMethodBeat.i(123255);
    if (this.tMp.bqS())
    {
      s.bqB();
      String str = x.XT(this.tMi.field_imgPath);
      if (u.agG(str))
      {
        a(this.tMp, str);
        AppMethodBeat.o(123255);
        return true;
      }
    }
    AppMethodBeat.o(123255);
    return false;
  }
  
  protected final void ccd()
  {
    AppMethodBeat.i(123256);
    s.bqB().a(new x.a()
    {
      public final void a(x.a.a paramAnonymousa)
      {
        AppMethodBeat.i(123253);
        paramAnonymousa = y.Yk(paramAnonymousa.fileName);
        if (paramAnonymousa != null)
        {
          int i = paramAnonymousa.mhM;
          int j = paramAnonymousa.lAW;
          g.this.fI(i, j);
          if (paramAnonymousa.bqS())
          {
            s.bqB();
            String str = x.XT(g.a(g.this).field_imgPath);
            if (u.agG(str))
            {
              g.a(g.this, paramAnonymousa, str);
              AppMethodBeat.o(123253);
              return;
            }
            Log.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
            g.this.cMK();
          }
        }
        AppMethodBeat.o(123253);
      }
    }, Looper.getMainLooper());
    if (this.tMp.bqR())
    {
      Log.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
      y.Yq(this.tMi.field_imgPath);
      AppMethodBeat.o(123256);
      return;
    }
    Log.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
    y.aT(this.tMi.field_imgPath, 10);
    y.Yf(this.tMi.field_imgPath);
    AppMethodBeat.o(123256);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123254);
    if ((this.tMc == null) || (this.tMc.tMi == null))
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
      AppMethodBeat.o(123254);
      return false;
    }
    this.tMi = this.tMc.tMi;
    if (this.tMi.Ic())
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", new Object[] { this.tMi });
      AppMethodBeat.o(123254);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)h.ae(com.tencent.mm.choosemsgfile.compat.b.class)).m(this.tMi))
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", new Object[] { this.tMi });
      AppMethodBeat.o(123254);
      return false;
    }
    this.tMp = y.Yk(this.tMi.field_imgPath);
    if (this.tMp == null)
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", new Object[] { this.tMi });
      AppMethodBeat.o(123254);
      return false;
    }
    if (this.tMp.status == 198)
    {
      Log.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", new Object[] { this.tMi });
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