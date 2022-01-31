package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class g$2
  implements g.a
{
  g$2(g paramg) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(19250);
    ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", new Object[] { this.lEP.fFo, Integer.valueOf(paramInt), paramc, paramd, Boolean.valueOf(this.lEP.lEv) });
    if (paramc != null) {}
    label560:
    label568:
    for (;;)
    {
      try
      {
        paramInt = (int)(paramc.field_finishedLength / paramc.field_toltalLength * 100.0F);
        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 100) {
          break label568;
        }
        paramInt = 99;
        paramString = this.lEP.lEx.keySet().iterator();
        if (paramString.hasNext())
        {
          paramc = (String)paramString.next();
          g.a(this.lEP, paramc, paramInt);
          continue;
        }
        if (paramd == null) {
          break label560;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", new Object[] { paramString });
        AppMethodBeat.o(19250);
        return 0;
      }
      if (this.lEP.lEv)
      {
        paramString = new avn();
        this.lEP.a(paramString, this.lEP.eaY);
        this.lEP.lEv = false;
        if ((g.jb(this.lEP.eaY).booleanValue()) || (g.jc(this.lEP.eaY).booleanValue()))
        {
          paramString.xkV.wDo = paramd.field_aesKey;
          paramString.xkV.xkZ = this.lEP.lEz;
          paramString.xkV.wDs = paramd.field_fileId;
          paramString.xkV.Url = paramd.field_fileUrl;
          ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", new Object[] { paramString.xkV.Url });
        }
        for (;;)
        {
          this.lEP.lEy = paramString;
          paramc = this.lEP.lEx.keySet().iterator();
          while (paramc.hasNext())
          {
            paramd = (String)paramc.next();
            paramd = new n(paramString, (String)this.lEP.lEx.get(paramd), paramd, 1);
            aw.Rc().a(paramd, 0);
          }
          if (g.ja(this.lEP.eaY).booleanValue())
          {
            paramString.xkW.wDo = paramd.field_aesKey;
            paramString.xkW.wDs = paramd.field_fileId;
            paramString.xkW.Url = paramd.field_fileUrl;
            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", new Object[] { paramString.xkW.Url });
          }
          else if (g.jd(this.lEP.eaY).booleanValue())
          {
            paramString.xkY.Url = paramd.field_fileUrl;
            ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", new Object[] { paramString.xkY.Url });
          }
        }
        this.lEP.lEx.clear();
      }
      AppMethodBeat.o(19250);
      return 0;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(19251);
    ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(19251);
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19252);
    ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
    AppMethodBeat.o(19252);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.2
 * JD-Core Version:    0.7.0.1
 */