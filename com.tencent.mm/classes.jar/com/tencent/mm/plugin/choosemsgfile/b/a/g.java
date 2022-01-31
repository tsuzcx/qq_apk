package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public final class g
  extends c
{
  private s kEG;
  private bi kEz;
  
  public g(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void a(s params, String paramString)
  {
    AppMethodBeat.i(54285);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = params.fsd;
    localMsgFile.filePath = paramString;
    localMsgFile.elt = com.tencent.mm.plugin.choosemsgfile.b.d.b.cP(localMsgFile.filePath);
    localMsgFile.type = "video";
    localMsgFile.fileName = (params.getFileName() + "." + localMsgFile.elt);
    localMsgFile.timeStamp = params.createTime;
    b(localMsgFile);
    AppMethodBeat.o(54285);
  }
  
  protected final boolean bgf()
  {
    AppMethodBeat.i(54283);
    if (this.kEG.alS())
    {
      o.alE();
      String str = t.vf(this.kEz.field_imgPath);
      if (e.cN(str))
      {
        a(this.kEG, str);
        AppMethodBeat.o(54283);
        return true;
      }
    }
    AppMethodBeat.o(54283);
    return false;
  }
  
  protected final void bgg()
  {
    AppMethodBeat.i(54284);
    o.alE().a(new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(54281);
        paramAnonymousa = u.vr(paramAnonymousa.fileName);
        if (paramAnonymousa != null)
        {
          int i = paramAnonymousa.fXs;
          int j = paramAnonymousa.fsd;
          g.this.dU(i, j);
          if (paramAnonymousa.alS())
          {
            o.alE();
            String str = t.vf(g.a(g.this).field_imgPath);
            if (e.cN(str))
            {
              g.a(g.this, paramAnonymousa, str);
              AppMethodBeat.o(54281);
              return;
            }
            ab.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
            g.this.bgi();
          }
        }
        AppMethodBeat.o(54281);
      }
    }, Looper.getMainLooper());
    if (this.kEG.alR())
    {
      ab.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
      u.vy(this.kEz.field_imgPath);
      AppMethodBeat.o(54284);
      return;
    }
    ab.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
    u.ag(this.kEz.field_imgPath, 10);
    u.vn(this.kEz.field_imgPath);
    AppMethodBeat.o(54284);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(54282);
    if ((this.kEs == null) || (this.kEs.kEz == null))
    {
      ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
      AppMethodBeat.o(54282);
      return false;
    }
    this.kEz = this.kEs.kEz;
    if (this.kEz.dyc())
    {
      ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", new Object[] { this.kEz });
      AppMethodBeat.o(54282);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)com.tencent.mm.kernel.g.E(com.tencent.mm.choosemsgfile.compat.b.class)).f(this.kEz))
    {
      ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", new Object[] { this.kEz });
      AppMethodBeat.o(54282);
      return false;
    }
    this.kEG = u.vr(this.kEz.field_imgPath);
    if (this.kEG == null)
    {
      ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", new Object[] { this.kEz });
      AppMethodBeat.o(54282);
      return false;
    }
    if (this.kEG.status == 198)
    {
      ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", new Object[] { this.kEz });
      AppMethodBeat.o(54282);
      return false;
    }
    AppMethodBeat.o(54282);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.g
 * JD-Core Version:    0.7.0.1
 */