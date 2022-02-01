package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class r
{
  final Map<String, q> ovX;
  
  r()
  {
    AppMethodBeat.i(90935);
    this.ovX = new ConcurrentHashMap(1);
    AppMethodBeat.o(90935);
  }
  
  private void b(final String paramString1, String paramString2, final a parama)
  {
    AppMethodBeat.i(184491);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new avm();
    ((b.a)localObject).hvu = new avn();
    ((b.a)localObject).funcId = 2985;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    avm localavm = (avm)((b)localObject).hvr.hvw;
    localavm.djj = paramString1;
    localavm.ENF = paramString2;
    IPCRunCgi.a((b)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(90934);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hvs.hvw == null))
        {
          ac.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
          r.a(r.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, false, parama);
          AppMethodBeat.o(90934);
          return;
        }
        paramAnonymousString = (avn)paramAnonymousb.hvs.hvw;
        paramAnonymousb = new q();
        paramAnonymousb.ovU = paramAnonymousString.DZz;
        paramAnonymousb.ovW = bs.Gn();
        paramAnonymousb.ovV = paramAnonymousString.ENG;
        ac.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", new Object[] { paramAnonymousb });
        r.this.ovX.put(paramString1, paramAnonymousb);
        r.a(r.this, 0, 0, "", paramAnonymousb, true, parama);
        AppMethodBeat.o(90934);
      }
    });
    AppMethodBeat.o(184491);
  }
  
  public final void Wd(String paramString)
  {
    AppMethodBeat.i(90939);
    ac.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90939);
      return;
    }
    this.ovX.remove(paramString);
    AppMethodBeat.o(90939);
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString, final q paramq, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(90937);
    p.otZ.ag(new Runnable()
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
    q localq = (q)this.ovX.get(paramString1);
    if ((localq != null) && (localq.isValid()))
    {
      ac.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
      a(0, 0, "", localq, false, parama);
      AppMethodBeat.o(184490);
      return;
    }
    this.ovX.remove(paramString1);
    b(paramString1, paramString2, parama);
    AppMethodBeat.o(184490);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, q paramq, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.r
 * JD-Core Version:    0.7.0.1
 */