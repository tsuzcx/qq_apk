package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public String openId;
  public int status;
  public int tQm;
  
  public final String toString()
  {
    AppMethodBeat.i(90786);
    String str = "OpenVoiceMember{memberId=" + this.tQm + ", openId='" + this.openId + '\'' + ", status='" + this.status + '\'' + '}';
    AppMethodBeat.o(90786);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b
 * JD-Core Version:    0.7.0.1
 */