package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.protocal.c.aef;
import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class l
{
  final Map<String, k> iGz = new ConcurrentHashMap(1);
  
  private void a(int paramInt1, int paramInt2, String paramString, k paramk, boolean paramBoolean, l.a parama)
  {
    j.iFl.H(new l.1(this, parama, paramInt1, paramInt2, paramString, paramk, paramBoolean));
  }
  
  public final void a(String paramString, l.a parama)
  {
    Object localObject = (k)this.iGz.get(paramString);
    if ((localObject != null) && (((k)localObject).isValid()))
    {
      y.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
      a(0, 0, "", (k)localObject, false, parama);
      return;
    }
    this.iGz.remove(paramString);
    localObject = new b.a();
    ((b.a)localObject).ecH = new aef();
    ((b.a)localObject).ecI = new aeg();
    ((b.a)localObject).ecG = 2985;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    localObject = ((b.a)localObject).Kt();
    ((aef)((com.tencent.mm.ah.b)localObject).ecE.ecN).bOL = paramString;
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ah.b)localObject, new l.2(this, parama, paramString));
  }
  
  public final void reset(String paramString)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
    if (bk.bl(paramString)) {
      return;
    }
    this.iGz.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.l
 * JD-Core Version:    0.7.0.1
 */