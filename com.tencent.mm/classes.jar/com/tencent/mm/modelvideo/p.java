package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.n.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bn;
import com.tencent.mm.vfs.i;
import java.util.Arrays;

public final class p
  implements w
{
  private String iaA;
  Boolean iaB = Boolean.FALSE;
  private VideoTransPara iay = null;
  private VideoTransPara iaz = null;
  private String srcPath;
  
  public final void DO(String paramString)
  {
    AppMethodBeat.i(126944);
    o.aJy();
    this.srcPath = t.DV(paramString);
    Object localObject1 = new StringBuilder();
    o.aJy();
    this.iaA = (t.DV(paramString) + ".tmp");
    ac.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.srcPath });
    ac.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.iaA });
    this.iaB = Boolean.valueOf(e.Et(this.srcPath));
    long l;
    if ((i.eA(this.srcPath)) && (this.iaB.booleanValue()))
    {
      ac.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = bs.Gn();
      if (!i.eA(this.srcPath))
      {
        ac.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
        AppMethodBeat.o(126944);
        return;
      }
      h.wUl.idkeyStat(354L, 249L, 1L, false);
      this.iaz = e.Eu(this.srcPath);
      this.iay = e.a(this.iaz, this.srcPath);
      if ((this.iaz != null) && (this.iay != null))
      {
        if (e.a(this.srcPath, this.iaA, this.iay) < 0) {
          h.wUl.idkeyStat(354L, 250L, 1L, false);
        }
        i.ma(this.iaA, this.srcPath);
        i.deleteFile(this.iaA);
        paramString = u.Ej(paramString);
        if (paramString != null)
        {
          paramString.videoFormat = 1;
          paramString.drx = 2;
          o.aJy().c(paramString);
        }
        ac.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      }
      AppMethodBeat.o(126944);
      return;
    }
    ac.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
    localObject1 = u.Ej(paramString);
    if ((localObject1 != null) && (!bs.isNullOrNil(((s)localObject1).aJJ())) && (i.eA(((s)localObject1).aJJ())))
    {
      Object localObject2 = ((s)localObject1).iaS;
      if ((localObject2 == null) || (!((bsz)localObject2).FhZ))
      {
        localObject2 = ((s)localObject1).aJJ();
        o.aJy();
        paramString = t.DV(paramString);
        this.iaz = e.Eu((String)localObject2);
        this.iay = e.a(this.iaz, (String)localObject2);
        if ((!i.eA(paramString)) && (this.iaz != null) && (this.iay != null))
        {
          int[] arrayOfInt = new int[2];
          l.d((String)localObject2, arrayOfInt);
          l = bs.Gn();
          this.iaB = Boolean.valueOf(e.Et((String)localObject2));
          ac.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject2, this.iaB });
          int i;
          if (this.iaB.booleanValue())
          {
            i = e.a((String)localObject2, paramString, this.iay);
            ac.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (this.iaz.duration > 0)
            {
              ((s)localObject1).hpy = this.iaz.duration;
              o.aJy().c((s)localObject1);
            }
            AppMethodBeat.o(126944);
            return;
            i = SightVideoJNI.remuxingVFS((String)localObject2, paramString, arrayOfInt[0], arrayOfInt[1], this.iay.videoBitrate, this.iay.hCA, 8, this.iay.hCz, 25.0F, this.iay.fps, null, 0, c.xCq, 0, 51);
            ac.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(bs.aO(l)) });
            ((a)g.ab(a.class)).awI().ah((String)localObject2, paramString, i);
          }
        }
        ac.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
      }
    }
    AppMethodBeat.o(126944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */