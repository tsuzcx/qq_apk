package com.tencent.mm.live.core.core.trtc.sdkadapter.feature;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class e
  implements Serializable
{
  public boolean eCF = false;
  public int mMinVideoBitrate = 600;
  public int mQosMode = 1;
  public int mQosPreference = 2;
  private transient boolean mSN = true;
  public int mSZ = 108;
  public int mTa = 15;
  public int mTb = 110;
  public int mTc = 15;
  public int mTd = 1500;
  public int mTe = 600;
  public boolean mTf = true;
  public boolean mTg = false;
  public int mTh = 0;
  public boolean mTi = true;
  public boolean mTj = false;
  public boolean mTk = false;
  public boolean mTl = false;
  public boolean mTm = false;
  public boolean mTn = true;
  public int mTo = 0;
  public boolean mTp = true;
  public boolean mTq = false;
  public boolean mTr = false;
  public int mTs = 5;
  public int mTt = 10;
  public int mTu = 0;
  public int mTv = 0;
  public int mVideoBitrate = 600;
  
  public final String key()
  {
    AppMethodBeat.i(248301);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mSZ).append("-").append(this.mTa).append("-").append(this.mVideoBitrate).append("-").append(this.mQosPreference).append("-").append(this.mQosMode);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(248301);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e
 * JD-Core Version:    0.7.0.1
 */