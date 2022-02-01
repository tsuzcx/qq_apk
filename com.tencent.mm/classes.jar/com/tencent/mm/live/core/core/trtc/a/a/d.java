package com.tencent.mm.live.core.core.trtc.a.a;

import java.io.Serializable;

public final class d
  implements Serializable
{
  public boolean cjK = false;
  public int gpC = 15;
  public boolean gpD = true;
  public boolean gpE = false;
  public int gpF = 0;
  private boolean gpG = true;
  private boolean gpH = false;
  public boolean gpI = false;
  public boolean gpJ = false;
  public boolean gpK = false;
  public boolean gpL = true;
  public int gpM = 0;
  public boolean gpN = true;
  private transient boolean gpw = true;
  public int mQosMode = 1;
  public int mQosPreference = 2;
  public int mVideoBitrate = 600;
  public int mVideoResolution = 108;
  
  public final boolean ajm()
  {
    return this.gpD;
  }
  
  public final void dF(boolean paramBoolean)
  {
    this.gpD = paramBoolean;
  }
  
  public final void dG(boolean paramBoolean)
  {
    this.gpN = paramBoolean;
  }
  
  public final void dH(boolean paramBoolean)
  {
    this.gpG = paramBoolean;
  }
  
  public final void mA(int paramInt)
  {
    this.mQosMode = paramInt;
  }
  
  public final void mB(int paramInt)
  {
    this.gpC = paramInt;
  }
  
  public final void mC(int paramInt)
  {
    this.mQosPreference = paramInt;
  }
  
  public final void setVideoBitrate(int paramInt)
  {
    this.mVideoBitrate = paramInt;
  }
  
  public final void setVideoResolution(int paramInt)
  {
    this.mVideoResolution = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.a.d
 * JD-Core Version:    0.7.0.1
 */