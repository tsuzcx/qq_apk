package com.tencent.mm.live.core.core.trtc.a.a;

import java.io.Serializable;

public final class d
  implements Serializable
{
  public boolean cmI = false;
  public int mQosMode = 1;
  public int mQosPreference = 2;
  public int mVideoBitrate = 600;
  public int mVideoResolution = 108;
  private boolean qGY = false;
  public boolean qGZ = false;
  private transient boolean qGj = true;
  public int qGp = 15;
  public boolean qGq = true;
  public boolean qGs = false;
  public int qGt = 0;
  private boolean qGy = true;
  public boolean qHJ = false;
  public boolean qHK = false;
  public boolean qHL = true;
  public int qHY = 0;
  public boolean qJb = true;
  
  public final void BA(int paramInt)
  {
    this.qGp = paramInt;
  }
  
  public final void BE(int paramInt)
  {
    this.mQosPreference = paramInt;
  }
  
  public final void Bz(int paramInt)
  {
    this.mQosMode = paramInt;
  }
  
  public final boolean crr()
  {
    return this.qGq;
  }
  
  public final void kN(boolean paramBoolean)
  {
    this.qGq = paramBoolean;
  }
  
  public final void kO(boolean paramBoolean)
  {
    this.qJb = paramBoolean;
  }
  
  public final void kP(boolean paramBoolean)
  {
    this.qGy = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.a.d
 * JD-Core Version:    0.7.0.1
 */