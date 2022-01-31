package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.caj;
import com.tencent.mm.protocal.c.cak;

final class aa
  extends a<cak>
{
  private final caj fJM;
  private final b fJN;
  private final String fJO;
  private volatile w.a fJP;
  
  aa(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    this.fJO = paramString2;
    b.a locala = new b.a();
    caj localcaj = new caj();
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = 1000;
    }
    localcaj.scene = i;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localcaj.tPF = paramInt1;
      localcaj.sEr = paramInt2;
      localcaj.tPG = 2;
      localcaj.tPH = paramInt3;
      localcaj.username = paramString1;
      localcaj.aQw = paramInt4;
      localcaj.session_id = paramString2;
      this.fJM = localcaj;
      locala.ecH = localcaj;
      locala.ecI = new cak();
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
      locala.ecG = 1149;
      paramString1 = locala.Kt();
      this.fJN = paramString1;
      this.dmK = paramString1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aa
 * JD-Core Version:    0.7.0.1
 */