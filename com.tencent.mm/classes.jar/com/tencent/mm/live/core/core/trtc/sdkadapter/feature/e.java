package com.tencent.mm.live.core.core.trtc.sdkadapter.feature;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class e
  implements Serializable
{
  public boolean cIZ = false;
  private transient boolean koZ = true;
  public int kpA = 5;
  public int kpB = 10;
  public int kpC = 0;
  public int kpD = 0;
  public int kpi = 108;
  public int kpj = 15;
  public int kpk = 110;
  public int kpl = 15;
  public int kpm = 1500;
  public int kpn = 600;
  public boolean kpo = true;
  public boolean kpp = false;
  public int kpq = 0;
  public boolean kpr = true;
  public boolean kps = false;
  public boolean kpt = false;
  public boolean kpu = false;
  public boolean kpv = false;
  public boolean kpw = true;
  public int kpx = 0;
  public boolean kpy = true;
  public boolean kpz = false;
  public int mMinVideoBitrate = 600;
  public int mQosMode = 1;
  public int mQosPreference = 2;
  public int mVideoBitrate = 600;
  
  public final int aLV()
  {
    return this.kpj;
  }
  
  public final boolean aLW()
  {
    return this.kpo;
  }
  
  public final boolean aLX()
  {
    return this.kpz;
  }
  
  public final void fd(boolean paramBoolean)
  {
    this.kpo = paramBoolean;
  }
  
  public final void fe(boolean paramBoolean)
  {
    this.kpy = paramBoolean;
  }
  
  public final void ff(boolean paramBoolean)
  {
    this.kpr = paramBoolean;
  }
  
  public final void fg(boolean paramBoolean)
  {
    this.kpz = paramBoolean;
  }
  
  public final String key()
  {
    AppMethodBeat.i(199504);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.kpi).append("-").append(this.kpj).append("-").append(this.mVideoBitrate).append("-").append(this.mQosPreference).append("-").append(this.mQosMode);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(199504);
    return localObject;
  }
  
  public final void sZ(int paramInt)
  {
    this.mQosMode = paramInt;
  }
  
  public final void setMinVideoBitrate(int paramInt)
  {
    this.mMinVideoBitrate = paramInt;
  }
  
  public final void setVideoBitrate(int paramInt)
  {
    this.mVideoBitrate = paramInt;
  }
  
  public final void setVideoResolution(int paramInt)
  {
    this.kpi = paramInt;
  }
  
  public final void ta(int paramInt)
  {
    this.kpj = paramInt;
  }
  
  public final void tb(int paramInt)
  {
    this.kpk = paramInt;
  }
  
  public final void tc(int paramInt)
  {
    this.kpl = paramInt;
  }
  
  public final void td(int paramInt)
  {
    this.kpm = paramInt;
  }
  
  public final void te(int paramInt)
  {
    this.kpn = paramInt;
  }
  
  public final void tf(int paramInt)
  {
    this.mQosPreference = paramInt;
  }
  
  public final void tg(int paramInt)
  {
    this.kpC = paramInt;
  }
  
  public final void th(int paramInt)
  {
    this.kpD = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e
 * JD-Core Version:    0.7.0.1
 */