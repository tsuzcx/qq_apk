package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bh;
import java.util.Arrays;

public final class p
  implements w
{
  private VideoTransPara eHv = null;
  private VideoTransPara eHw = null;
  private String eHx;
  private String eHy;
  Boolean eHz = Boolean.valueOf(false);
  
  public final void nK(String paramString)
  {
    o.Sr();
    this.eHx = t.nS(paramString);
    Object localObject1 = new StringBuilder();
    o.Sr();
    this.eHy = (t.nS(paramString) + ".tmp");
    y.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.eHx });
    y.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.eHy });
    this.eHz = Boolean.valueOf(com.tencent.mm.bi.e.om(this.eHx));
    long l;
    if ((com.tencent.mm.vfs.e.bK(this.eHx)) && (this.eHz.booleanValue()))
    {
      y.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = bk.UZ();
      if (!com.tencent.mm.vfs.e.bK(this.eHx)) {
        y.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
      }
    }
    for (;;)
    {
      return;
      h.nFQ.a(354L, 249L, 1L, false);
      this.eHw = com.tencent.mm.bi.e.on(this.eHx);
      this.eHv = com.tencent.mm.bi.e.a(this.eHw, this.eHx);
      if ((this.eHw != null) && (this.eHv != null))
      {
        if (com.tencent.mm.bi.e.a(this.eHx, this.eHy, this.eHv) < 0) {
          h.nFQ.a(354L, 250L, 1L, false);
        }
        FileOp.aA(this.eHy, this.eHx);
        FileOp.deleteFile(this.eHy);
        paramString = u.oe(paramString);
        if (paramString != null)
        {
          paramString.videoFormat = 1;
          paramString.bcw = 2;
          o.Sr().c(paramString);
        }
        y.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
        return;
        y.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
        localObject1 = u.oe(paramString);
        if ((localObject1 != null) && (!bk.bl(((s)localObject1).SC())) && (com.tencent.mm.vfs.e.bK(((s)localObject1).SC())))
        {
          Object localObject2 = ((s)localObject1).eHR;
          if ((localObject2 == null) || (!((avn)localObject2).tra))
          {
            localObject2 = ((s)localObject1).SC();
            o.Sr();
            paramString = t.nS(paramString);
            this.eHw = com.tencent.mm.bi.e.on((String)localObject2);
            this.eHv = com.tencent.mm.bi.e.a(this.eHw, (String)localObject2);
            if ((com.tencent.mm.vfs.e.bK(paramString)) || (this.eHw == null) || (this.eHv == null)) {
              break;
            }
            int[] arrayOfInt = new int[2];
            j.c((String)localObject2, arrayOfInt);
            l = bk.UZ();
            this.eHz = Boolean.valueOf(com.tencent.mm.bi.e.om((String)localObject2));
            y.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject2, this.eHz });
            int i;
            if (this.eHz.booleanValue())
            {
              i = com.tencent.mm.bi.e.a((String)localObject2, paramString, this.eHv);
              y.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(i) });
            }
            while (this.eHw.duration > 0)
            {
              ((s)localObject1).eHH = this.eHw.duration;
              o.Sr().c((s)localObject1);
              return;
              i = SightVideoJNI.remuxing((String)localObject2, paramString, arrayOfInt[0], arrayOfInt[1], this.eHv.videoBitrate, this.eHv.ejP, 8, this.eHv.ejO, 25.0F, this.eHv.fps, null, 0, b.odZ);
              y.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(bk.cp(l)) });
              ((a)g.r(a.class)).FD().L((String)localObject2, paramString, i);
            }
          }
        }
      }
    }
    y.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */