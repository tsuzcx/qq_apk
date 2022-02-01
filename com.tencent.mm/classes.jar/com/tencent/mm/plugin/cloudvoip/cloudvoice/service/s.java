package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class s
{
  final Map<String, r> wXd;
  
  s()
  {
    AppMethodBeat.i(90935);
    this.wXd = new ConcurrentHashMap(1);
    AppMethodBeat.o(90935);
  }
  
  private void b(final String paramString1, String paramString2, final a parama)
  {
    AppMethodBeat.i(184491);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new chm();
    ((c.a)localObject).otF = new chn();
    ((c.a)localObject).funcId = 2985;
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    chm localchm = (chm)c.b.b(((c)localObject).otB);
    localchm.appid = paramString1;
    localchm.aaqn = paramString2;
    IPCRunCgi.a((c)localObject, new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
      {
        AppMethodBeat.i(90934);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (c.c.b(paramAnonymousc.otC) == null))
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
          s.a(s.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, false, parama);
          AppMethodBeat.o(90934);
          return;
        }
        paramAnonymousString = (chn)c.c.b(paramAnonymousc.otC);
        paramAnonymousc = new r();
        paramAnonymousc.wXa = paramAnonymousString.YPH;
        paramAnonymousc.wXc = Util.currentTicks();
        paramAnonymousc.wXb = paramAnonymousString.aaqo;
        Log.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", new Object[] { paramAnonymousc });
        s.this.wXd.put(paramString1, paramAnonymousc);
        s.a(s.this, 0, 0, "", paramAnonymousc, true, parama);
        AppMethodBeat.o(90934);
      }
    });
    AppMethodBeat.o(184491);
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString, final r paramr, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(90937);
    q.wVc.au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90933);
        parama.a(paramInt1, paramInt2, paramString, paramr, paramBoolean);
        AppMethodBeat.o(90933);
      }
    });
    AppMethodBeat.o(90937);
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(184490);
    r localr = (r)this.wXd.get(paramString1);
    if ((localr != null) && (localr.isValid()))
    {
      Log.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
      a(0, 0, "", localr, false, parama);
      AppMethodBeat.o(184490);
      return;
    }
    this.wXd.remove(paramString1);
    b(paramString1, paramString2, parama);
    AppMethodBeat.o(184490);
  }
  
  public final void ama(String paramString)
  {
    AppMethodBeat.i(90939);
    Log.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90939);
      return;
    }
    this.wXd.remove(paramString);
    AppMethodBeat.o(90939);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, r paramr, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.s
 * JD-Core Version:    0.7.0.1
 */