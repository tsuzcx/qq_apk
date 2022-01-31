package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.protocal.u.b;

public final class f$b
  implements com.tencent.mm.network.q
{
  private final u.a fIy;
  private final u.b fIz;
  int uin;
  
  public f$b()
  {
    AppMethodBeat.i(58371);
    this.fIy = new u.a();
    this.fIz = new u.b();
    AppMethodBeat.o(58371);
  }
  
  public final boolean getIsUserCmd()
  {
    return false;
  }
  
  public final int getOptions()
  {
    return 0;
  }
  
  public final l.d getReqObj()
  {
    AppMethodBeat.i(58372);
    this.fIy.setDeviceID(com.tencent.mm.compatible.e.q.LK());
    this.fIy.setDeviceType(d.eQs);
    this.fIy.setClientVersion(d.whH);
    this.fIy.setUin(this.uin);
    u.a locala = this.fIy;
    AppMethodBeat.o(58372);
    return locala;
  }
  
  public final int getTimeOut()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 268369922;
  }
  
  public final String getUri()
  {
    return null;
  }
  
  public final boolean isSingleSession()
  {
    return true;
  }
  
  public final void setConnectionInfo(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelmulti.f.b
 * JD-Core Version:    0.7.0.1
 */