package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class r
{
  final Map<String, q> oZs;
  
  r()
  {
    AppMethodBeat.i(90935);
    this.oZs = new ConcurrentHashMap(1);
    AppMethodBeat.o(90935);
  }
  
  private void b(final String paramString1, String paramString2, final a parama)
  {
    AppMethodBeat.i(184491);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new azk();
    ((b.a)localObject).hNN = new azl();
    ((b.a)localObject).funcId = 2985;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    azk localazk = (azk)((b)localObject).hNK.hNQ;
    localazk.duW = paramString1;
    localazk.GwJ = paramString2;
    IPCRunCgi.a((b)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(90934);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hNL.hNQ == null))
        {
          ad.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
          r.a(r.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, false, parama);
          AppMethodBeat.o(90934);
          return;
        }
        paramAnonymousString = (azl)paramAnonymousb.hNL.hNQ;
        paramAnonymousb = new q();
        paramAnonymousb.oZp = paramAnonymousString.FEX;
        paramAnonymousb.oZr = bt.HI();
        paramAnonymousb.oZq = paramAnonymousString.GwK;
        ad.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", new Object[] { paramAnonymousb });
        r.this.oZs.put(paramString1, paramAnonymousb);
        r.a(r.this, 0, 0, "", paramAnonymousb, true, parama);
        AppMethodBeat.o(90934);
      }
    });
    AppMethodBeat.o(184491);
  }
  
  public final void ZK(String paramString)
  {
    AppMethodBeat.i(90939);
    ad.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90939);
      return;
    }
    this.oZs.remove(paramString);
    AppMethodBeat.o(90939);
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString, final q paramq, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(90937);
    p.oXv.af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90933);
        parama.a(paramInt1, paramInt2, paramString, paramq, paramBoolean);
        AppMethodBeat.o(90933);
      }
    });
    AppMethodBeat.o(90937);
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(184490);
    q localq = (q)this.oZs.get(paramString1);
    if ((localq != null) && (localq.isValid()))
    {
      ad.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
      a(0, 0, "", localq, false, parama);
      AppMethodBeat.o(184490);
      return;
    }
    this.oZs.remove(paramString1);
    b(paramString1, paramString2, parama);
    AppMethodBeat.o(184490);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, q paramq, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.r
 * JD-Core Version:    0.7.0.1
 */