package com.tencent.mm.live.core.core.trtc.a.a;

import java.io.Serializable;

public final class d
  implements Serializable
{
  public boolean cuD = false;
  private transient boolean gLO = true;
  public int gLU = 108;
  public int gLV = 15;
  public boolean gLW = true;
  public boolean gLX = false;
  public int gLY = 0;
  private boolean gLZ = true;
  private boolean gMa = false;
  public boolean gMb = false;
  public boolean gMc = false;
  public boolean gMd = false;
  public boolean gMe = true;
  public int gMf = 0;
  public boolean gMg = true;
  public int mQosMode = 1;
  public int mQosPreference = 2;
  public int mVideoBitrate = 600;
  
  public final boolean amn()
  {
    return this.gLW;
  }
  
  public final void dI(boolean paramBoolean)
  {
    this.gLW = paramBoolean;
  }
  
  public final void dJ(boolean paramBoolean)
  {
    this.gMg = paramBoolean;
  }
  
  public final void dK(boolean paramBoolean)
  {
    this.gLZ = paramBoolean;
  }
  
  public final void nc(int paramInt)
  {
    this.mQosMode = paramInt;
  }
  
  public final void nd(int paramInt)
  {
    this.gLV = paramInt;
  }
  
  public final void ne(int paramInt)
  {
    this.mQosPreference = paramInt;
  }
  
  public final void setVideoBitrate(int paramInt)
  {
    this.mVideoBitrate = paramInt;
  }
  
  public final void setVideoResolution(int paramInt)
  {
    this.gLU = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.a.d
 * JD-Core Version:    0.7.0.1
 */