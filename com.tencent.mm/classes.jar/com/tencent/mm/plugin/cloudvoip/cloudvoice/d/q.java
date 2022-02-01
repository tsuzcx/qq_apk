package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class q
{
  final Map<String, p> nSD;
  
  q()
  {
    AppMethodBeat.i(90935);
    this.nSD = new ConcurrentHashMap(1);
    AppMethodBeat.o(90935);
  }
  
  private void a(final int paramInt1, final int paramInt2, final String paramString, final p paramp, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(90937);
    o.nQO.ae(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90933);
        parama.a(paramInt1, paramInt2, paramString, paramp, paramBoolean);
        AppMethodBeat.o(90933);
      }
    });
    AppMethodBeat.o(90937);
  }
  
  private void b(final String paramString1, String paramString2, final a parama)
  {
    AppMethodBeat.i(184491);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new asi();
    ((b.a)localObject).gUV = new asj();
    ((b.a)localObject).funcId = 2985;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    asi localasi = (asi)((b)localObject).gUS.gUX;
    localasi.dlB = paramString1;
    localasi.DsB = paramString2;
    IPCRunCgi.a((b)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(90934);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.gUT.gUX == null))
        {
          ad.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
          q.a(q.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, false, parama);
          AppMethodBeat.o(90934);
          return;
        }
        paramAnonymousString = (asj)paramAnonymousb.gUT.gUX;
        paramAnonymousb = new p();
        paramAnonymousb.nSA = paramAnonymousString.CGY;
        paramAnonymousb.nSC = bt.GC();
        paramAnonymousb.nSB = paramAnonymousString.DsC;
        ad.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", new Object[] { paramAnonymousb });
        q.this.nSD.put(paramString1, paramAnonymousb);
        q.a(q.this, 0, 0, "", paramAnonymousb, true, parama);
        AppMethodBeat.o(90934);
      }
    });
    AppMethodBeat.o(184491);
  }
  
  public final void RR(String paramString)
  {
    AppMethodBeat.i(90939);
    ad.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90939);
      return;
    }
    this.nSD.remove(paramString);
    AppMethodBeat.o(90939);
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(184490);
    p localp = (p)this.nSD.get(paramString1);
    if ((localp != null) && (localp.isValid()))
    {
      ad.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
      a(0, 0, "", localp, false, parama);
      AppMethodBeat.o(184490);
      return;
    }
    this.nSD.remove(paramString1);
    b(paramString1, paramString2, parama);
    AppMethodBeat.o(184490);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q
 * JD-Core Version:    0.7.0.1
 */