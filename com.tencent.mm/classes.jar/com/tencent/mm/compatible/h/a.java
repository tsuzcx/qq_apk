package com.tencent.mm.compatible.h;

import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public int bIC = -1;
  public String dzp = null;
  public long dzq = -1L;
  public int dzr = -1;
  
  public final String zC()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.dzp);
    localStringBuffer.append(",");
    localStringBuffer.append(this.dzq);
    localStringBuffer.append(",");
    localStringBuffer.append(this.dzr);
    localStringBuffer.append(",");
    localStringBuffer.append(this.bIC);
    y.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + localStringBuffer.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.h.a
 * JD-Core Version:    0.7.0.1
 */