package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.apn;
import com.tencent.mm.protocal.c.apo;
import com.tencent.mm.protocal.c.app;
import com.tencent.mm.protocal.c.apt;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class g$2
  implements f.a
{
  g$2(g paramg) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", new Object[] { this.jvq.eoQ, Integer.valueOf(paramInt), paramc, paramd, Boolean.valueOf(this.jvq.juW) });
    if (paramc != null) {}
    label550:
    for (;;)
    {
      try
      {
        paramInt = (int)(paramc.field_finishedLength / paramc.field_toltalLength * 100.0F);
        y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 100) {
          break label550;
        }
        paramInt = 99;
        paramString = this.jvq.juY.keySet().iterator();
        if (paramString.hasNext())
        {
          paramc = (String)paramString.next();
          g.a(this.jvq, paramc, paramInt);
          continue;
          return 0;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", new Object[] { paramString });
      }
      while ((paramd == null) || (!this.jvq.juW)) {}
      paramString = new apo();
      this.jvq.a(paramString, this.jvq.djE);
      this.jvq.juW = false;
      if ((g.dJ(this.jvq.djE).booleanValue()) || (g.dK(this.jvq.djE).booleanValue()))
      {
        paramString.tlC.sGQ = paramd.field_aesKey;
        paramString.tlC.tlG = this.jvq.jva;
        paramString.tlC.sGU = paramd.field_fileId;
        paramString.tlC.kSC = paramd.field_fileUrl;
        y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", new Object[] { paramString.tlC.kSC });
      }
      for (;;)
      {
        this.jvq.juZ = paramString;
        paramc = this.jvq.juY.keySet().iterator();
        while (paramc.hasNext())
        {
          paramd = (String)paramc.next();
          paramd = new n(paramString, (String)this.jvq.juY.get(paramd), paramd, 1);
          au.Dk().a(paramd, 0);
        }
        if (g.dI(this.jvq.djE).booleanValue())
        {
          paramString.tlD.sGQ = paramd.field_aesKey;
          paramString.tlD.sGU = paramd.field_fileId;
          paramString.tlD.kSC = paramd.field_fileUrl;
          y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", new Object[] { paramString.tlD.kSC });
        }
        else if (g.dL(this.jvq.djE).booleanValue())
        {
          paramString.tlF.kSC = paramd.field_fileUrl;
          y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", new Object[] { paramString.tlF.kSC });
        }
      }
      this.jvq.juY.clear();
      return 0;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = " + paramString);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.2
 * JD-Core Version:    0.7.0.1
 */