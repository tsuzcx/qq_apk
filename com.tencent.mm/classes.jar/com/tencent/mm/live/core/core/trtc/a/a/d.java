package com.tencent.mm.live.core.core.trtc.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class d
  implements Serializable
{
  public boolean cIw = false;
  private boolean hBA = false;
  public boolean hBB = false;
  public boolean hBC = false;
  public boolean hBD = false;
  public boolean hBE = true;
  public int hBF = 0;
  public boolean hBG = true;
  private transient boolean hBm = true;
  public int hBu = 108;
  public int hBv = 15;
  public boolean hBw = true;
  public boolean hBx = false;
  public int hBy = 0;
  private boolean hBz = true;
  public int mQosMode = 1;
  public int mQosPreference = 2;
  public int mVideoBitrate = 600;
  
  public final String Lb()
  {
    AppMethodBeat.i(196278);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.hBu).append("-").append(this.hBv).append("-").append(this.mVideoBitrate).append("-").append(this.mQosPreference).append("-").append(this.mQosMode);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(196278);
    return localObject;
  }
  
  public final int aDR()
  {
    return this.hBv;
  }
  
  public final boolean aDS()
  {
    return this.hBw;
  }
  
  public final void eA(boolean paramBoolean)
  {
    this.hBw = paramBoolean;
  }
  
  public final void eB(boolean paramBoolean)
  {
    this.hBG = paramBoolean;
  }
  
  public final void eC(boolean paramBoolean)
  {
    this.hBz = paramBoolean;
  }
  
  public final void qt(int paramInt)
  {
    this.mQosMode = paramInt;
  }
  
  public final void qu(int paramInt)
  {
    this.hBv = paramInt;
  }
  
  public final void qv(int paramInt)
  {
    this.mQosPreference = paramInt;
  }
  
  public final void setVideoBitrate(int paramInt)
  {
    this.mVideoBitrate = paramInt;
  }
  
  public final void setVideoResolution(int paramInt)
  {
    this.hBu = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.a.d
 * JD-Core Version:    0.7.0.1
 */