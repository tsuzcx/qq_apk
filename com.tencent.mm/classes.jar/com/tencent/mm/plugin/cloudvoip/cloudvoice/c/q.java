package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class q
{
  final Map<String, p> kMs;
  
  q()
  {
    AppMethodBeat.i(135591);
    this.kMs = new ConcurrentHashMap(1);
    AppMethodBeat.o(135591);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean, q.a parama)
  {
    AppMethodBeat.i(135593);
    o.kKN.O(new q.1(this, parama, paramInt1, paramInt2, paramString, paramp, paramBoolean));
    AppMethodBeat.o(135593);
  }
  
  private void b(String paramString, q.a parama)
  {
    AppMethodBeat.i(135594);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aiz();
    ((b.a)localObject).fsY = new aja();
    ((b.a)localObject).funcId = 2985;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    ((aiz)((com.tencent.mm.ai.b)localObject).fsV.fta).cwc = paramString;
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject, new q.2(this, parama, paramString));
    AppMethodBeat.o(135594);
  }
  
  public final void a(String paramString, q.a parama)
  {
    AppMethodBeat.i(135592);
    p localp = (p)this.kMs.get(paramString);
    if ((localp != null) && (localp.isValid()))
    {
      ab.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
      a(0, 0, "", localp, false, parama);
      AppMethodBeat.o(135592);
      return;
    }
    this.kMs.remove(paramString);
    b(paramString, parama);
    AppMethodBeat.o(135592);
  }
  
  public final void reset(String paramString)
  {
    AppMethodBeat.i(135595);
    ab.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(135595);
      return;
    }
    this.kMs.remove(paramString);
    AppMethodBeat.o(135595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.q
 * JD-Core Version:    0.7.0.1
 */