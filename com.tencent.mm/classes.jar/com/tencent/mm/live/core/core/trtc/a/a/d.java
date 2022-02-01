package com.tencent.mm.live.core.core.trtc.a.a;

import java.io.Serializable;

public final class d
  implements Serializable
{
  public boolean cua = false;
  private transient boolean gJf = true;
  public int gJl = 108;
  public int gJm = 15;
  public boolean gJn = true;
  public boolean gJo = false;
  public int gJp = 0;
  private boolean gJq = true;
  private boolean gJr = false;
  public boolean gJs = false;
  public boolean gJt = false;
  public boolean gJu = false;
  public boolean gJv = true;
  public int gJw = 0;
  public boolean gJx = true;
  public int mQosMode = 1;
  public int mQosPreference = 2;
  public int mVideoBitrate = 600;
  
  public final boolean alY()
  {
    return this.gJn;
  }
  
  public final void dH(boolean paramBoolean)
  {
    this.gJn = paramBoolean;
  }
  
  public final void dI(boolean paramBoolean)
  {
    this.gJx = paramBoolean;
  }
  
  public final void dJ(boolean paramBoolean)
  {
    this.gJq = paramBoolean;
  }
  
  public final void mZ(int paramInt)
  {
    this.mQosMode = paramInt;
  }
  
  public final void na(int paramInt)
  {
    this.gJm = paramInt;
  }
  
  public final void nb(int paramInt)
  {
    this.mQosPreference = paramInt;
  }
  
  public final void setVideoBitrate(int paramInt)
  {
    this.mVideoBitrate = paramInt;
  }
  
  public final void setVideoResolution(int paramInt)
  {
    this.gJl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.a.d
 * JD-Core Version:    0.7.0.1
 */