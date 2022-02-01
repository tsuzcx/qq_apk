package com.tencent.mm.plugin.appbrand.jsapi.z.e.c;

import com.tencent.luggage.k.a.a.b.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.n;
import com.tencent.mm.sdk.platformtools.ac;
import java.math.BigInteger;

public final class a
{
  public static final BigInteger lee;
  public a lef;
  
  static
  {
    AppMethodBeat.i(139618);
    lee = BigInteger.valueOf(1024L);
    AppMethodBeat.o(139618);
  }
  
  public a()
  {
    AppMethodBeat.i(139616);
    this.lef = new a();
    AppMethodBeat.o(139616);
  }
  
  public final void a(e parame, com.tencent.luggage.k.a.a parama, b paramb, String paramString)
  {
    AppMethodBeat.i(206770);
    if (this.lef.lej < this.lef.lei)
    {
      ac.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
      this.lef.reset();
      AppMethodBeat.o(206770);
      return;
    }
    int i;
    label70:
    int j;
    label86:
    int k;
    label102:
    int n;
    long l1;
    long l2;
    long l3;
    int i1;
    int i2;
    if (parama != null)
    {
      parama = parama.getAppId();
      if (!(paramb instanceof c)) {
        break label626;
      }
      i = ((c)paramb).bkE();
      if (!(paramb instanceof c)) {
        break label632;
      }
      j = ((c)paramb).bkF();
      if (!(paramb instanceof c)) {
        break label638;
      }
      k = ((c)paramb).bkG();
      ac.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", new Object[] { paramString, parama, Boolean.valueOf(n.bjG().kPp), Integer.valueOf(this.lef.kWn), Long.valueOf(this.lef.leg), this.lef.videoPath, Long.valueOf(this.lef.leh), Long.valueOf(this.lef.duration), Long.valueOf(this.lef.lek), Integer.valueOf(this.lef.lel), Long.valueOf(this.lef.lem), Integer.valueOf(this.lef.les), Integer.valueOf(this.lef.let), this.lef.errorMsg, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      n = this.lef.kWn;
      paramb = this.lef.videoPath;
      l1 = this.lef.lek;
      l2 = this.lef.duration;
      l3 = this.lef.leh;
      i1 = this.lef.les;
      i2 = this.lef.let;
      paramString = this.lef.errorMsg;
      if (!n.bjG().kPp) {
        break label644;
      }
    }
    label644:
    for (int m = 1;; m = 0)
    {
      parame.e(new Object[] { parama, Integer.valueOf(n), paramb, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i1), Integer.valueOf(i2), paramString, Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(this.lef.lel), Long.valueOf(this.lef.lem), Long.valueOf(this.lef.leg), Long.valueOf(this.lef.lei), Long.valueOf(this.lef.lej), Long.valueOf(this.lef.leq), Long.valueOf(this.lef.ler), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.lef.reset();
      AppMethodBeat.o(206770);
      return;
      parama = "";
      break;
      label626:
      i = 0;
      break label70;
      label632:
      j = 0;
      break label86;
      label638:
      k = 0;
      break label102;
    }
  }
  
  public final class a
  {
    public long duration = 0L;
    public String errorMsg = "";
    public int kWn = 0;
    public long leg = 0L;
    public long leh = 0L;
    public long lei = 0L;
    public long lej = 0L;
    public long lek = 0L;
    public int lel = 0;
    public long lem = 0L;
    public long leo = 0L;
    public long lep = 0L;
    public long leq = 0L;
    public long ler = 0L;
    public int les = 0;
    public int let = 0;
    public String videoPath = "";
    
    a() {}
    
    final void reset()
    {
      this.videoPath = "";
      this.kWn = 0;
      this.leg = 0L;
      this.duration = 0L;
      this.leh = 0L;
      this.lei = 0L;
      this.lej = 0L;
      this.lek = 0L;
      this.lel = 0;
      this.leo = 0L;
      this.lep = 0L;
      this.lem = 0L;
      this.leq = 0L;
      this.ler = 0L;
      this.les = 0;
      this.let = 0;
      this.errorMsg = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.c.a
 * JD-Core Version:    0.7.0.1
 */