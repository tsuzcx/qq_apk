package com.tencent.mm.live.core.core.trtc.sdkadapter.feature;

import java.io.Serializable;

public final class d
  implements Serializable
{
  public String kpe = "";
  public String kpf = "";
  public boolean kpg = false;
  private String kph = "";
  
  public final void NA(String paramString)
  {
    this.kpe = paramString;
  }
  
  public final void NB(String paramString)
  {
    this.kpf = paramString;
  }
  
  public final void NC(String paramString)
  {
    this.kph = paramString;
  }
  
  public final void fc(boolean paramBoolean)
  {
    this.kpg = paramBoolean;
  }
  
  public final void reset()
  {
    this.kpe = "";
    this.kpf = "";
    this.kpg = false;
    this.kph = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d
 * JD-Core Version:    0.7.0.1
 */