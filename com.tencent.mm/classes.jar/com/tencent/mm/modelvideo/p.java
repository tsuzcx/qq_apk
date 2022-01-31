package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bh;
import java.util.Arrays;

public final class p
  implements w
{
  private VideoTransPara fXm = null;
  private VideoTransPara fXn = null;
  private String fXo;
  Boolean fXp = Boolean.FALSE;
  private String srcPath;
  
  public final void uX(String paramString)
  {
    AppMethodBeat.i(50779);
    o.alE();
    this.srcPath = t.vf(paramString);
    Object localObject1 = new StringBuilder();
    o.alE();
    this.fXo = (t.vf(paramString) + ".tmp");
    ab.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.srcPath });
    ab.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.fXo });
    this.fXp = Boolean.valueOf(com.tencent.mm.bj.e.vB(this.srcPath));
    long l;
    if ((com.tencent.mm.vfs.e.cN(this.srcPath)) && (this.fXp.booleanValue()))
    {
      ab.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = bo.yB();
      if (!com.tencent.mm.vfs.e.cN(this.srcPath))
      {
        ab.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
        AppMethodBeat.o(50779);
        return;
      }
      h.qsU.idkeyStat(354L, 249L, 1L, false);
      this.fXn = com.tencent.mm.bj.e.vC(this.srcPath);
      this.fXm = com.tencent.mm.bj.e.a(this.fXn, this.srcPath);
      if ((this.fXn != null) && (this.fXm != null))
      {
        if (com.tencent.mm.bj.e.a(this.srcPath, this.fXo, this.fXm) < 0) {
          h.qsU.idkeyStat(354L, 250L, 1L, false);
        }
        FileOp.aT(this.fXo, this.srcPath);
        FileOp.deleteFile(this.fXo);
        paramString = u.vr(paramString);
        if (paramString != null)
        {
          paramString.videoFormat = 1;
          paramString.bsY = 2;
          o.alE().c(paramString);
        }
        ab.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      }
      AppMethodBeat.o(50779);
      return;
    }
    ab.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
    localObject1 = u.vr(paramString);
    if ((localObject1 != null) && (!bo.isNullOrNil(((s)localObject1).alO())) && (com.tencent.mm.vfs.e.cN(((s)localObject1).alO())))
    {
      Object localObject2 = ((s)localObject1).fXH;
      if ((localObject2 == null) || (!((bby)localObject2).xra))
      {
        localObject2 = ((s)localObject1).alO();
        o.alE();
        paramString = t.vf(paramString);
        this.fXn = com.tencent.mm.bj.e.vC((String)localObject2);
        this.fXm = com.tencent.mm.bj.e.a(this.fXn, (String)localObject2);
        if ((!com.tencent.mm.vfs.e.cN(paramString)) && (this.fXn != null) && (this.fXm != null))
        {
          int[] arrayOfInt = new int[2];
          j.c((String)localObject2, arrayOfInt);
          l = bo.yB();
          this.fXp = Boolean.valueOf(com.tencent.mm.bj.e.vB((String)localObject2));
          ab.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject2, this.fXp });
          int i;
          if (this.fXp.booleanValue())
          {
            i = com.tencent.mm.bj.e.a((String)localObject2, paramString, this.fXm);
            ab.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (this.fXn.duration > 0)
            {
              ((s)localObject1).fXx = this.fXn.duration;
              o.alE().c((s)localObject1);
            }
            AppMethodBeat.o(50779);
            return;
            i = SightVideoJNI.remuxing((String)localObject2, paramString, arrayOfInt[0], arrayOfInt[1], this.fXm.videoBitrate, this.fXm.fzW, 8, this.fXm.fzV, 25.0F, this.fXm.fps, null, 0, b.qSo, 0, 51);
            ab.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(bo.av(l)) });
            ((a)g.E(a.class)).YH().U((String)localObject2, paramString, i);
          }
        }
        ab.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
      }
    }
    AppMethodBeat.o(50779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */