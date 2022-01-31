package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.bk;

final class k
{
  String iGw = null;
  long iGx = -1L;
  long iGy = -1L;
  
  public final boolean isValid()
  {
    return (!bk.bl(this.iGw)) && (bk.cp(this.iGy + 3600L) / 1000L < this.iGx);
  }
  
  public final String toString()
  {
    return "OpenVoiceSessionKey{sessionKey='" + this.iGw + '\'' + ", expireTicks=" + this.iGx + ", initTicks=" + this.iGy + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.k
 * JD-Core Version:    0.7.0.1
 */