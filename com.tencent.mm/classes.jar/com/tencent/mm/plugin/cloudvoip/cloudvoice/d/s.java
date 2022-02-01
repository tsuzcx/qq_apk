package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class s
{
  final Map<String, r> qva;
  
  s()
  {
    AppMethodBeat.i(90935);
    this.qva = new ConcurrentHashMap(1);
    AppMethodBeat.o(90935);
  }
  
  private void b(final String paramString1, String paramString2, final a parama)
  {
    AppMethodBeat.i(184491);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new blk();
    ((d.a)localObject).iLO = new bll();
    ((d.a)localObject).funcId = 2985;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    blk localblk = (blk)((d)localObject).iLK.iLR;
    localblk.dNI = paramString1;
    localblk.LUq = paramString2;
    IPCRunCgi.a((d)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(90934);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousd.iLL.iLR == null))
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + paramAnonymousInt1 + ",errCode:" + paramAnonymousInt2);
          s.a(s.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, false, parama);
          AppMethodBeat.o(90934);
          return;
        }
        paramAnonymousString = (bll)paramAnonymousd.iLL.iLR;
        paramAnonymousd = new r();
        paramAnonymousd.quX = paramAnonymousString.KRf;
        paramAnonymousd.quZ = Util.currentTicks();
        paramAnonymousd.quY = paramAnonymousString.LUr;
        Log.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", new Object[] { paramAnonymousd });
        s.this.qva.put(paramString1, paramAnonymousd);
        s.a(s.this, 0, 0, "", paramAnonymousd, true, parama);
        AppMethodBeat.o(90934);
      }
    });
    AppMethodBeat.o(184491);
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString, final r paramr, final boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(90937);
    q.qta.aj(new Runnable()
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
    r localr = (r)this.qva.get(paramString1);
    if ((localr != null) && (localr.isValid()))
    {
      Log.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
      a(0, 0, "", localr, false, parama);
      AppMethodBeat.o(184490);
      return;
    }
    this.qva.remove(paramString1);
    b(paramString1, paramString2, parama);
    AppMethodBeat.o(184490);
  }
  
  public final void akH(String paramString)
  {
    AppMethodBeat.i(90939);
    Log.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90939);
      return;
    }
    this.qva.remove(paramString);
    AppMethodBeat.o(90939);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, r paramr, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s
 * JD-Core Version:    0.7.0.1
 */