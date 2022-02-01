package com.tencent.mm.live.core.core.trtc.sdkadapter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class a
  implements Serializable
{
  public String luk;
  public String lyn;
  private int mRotation;
  private boolean mSJ;
  public int mStreamType;
  private boolean mTi;
  private boolean mTw;
  public int mTx;
  public boolean mTy;
  
  public a(String paramString)
  {
    AppMethodBeat.i(248307);
    reset();
    this.luk = paramString;
    AppMethodBeat.o(248307);
  }
  
  public a(String paramString, byte paramByte)
  {
    AppMethodBeat.i(248314);
    reset();
    this.luk = paramString;
    this.mStreamType = 0;
    AppMethodBeat.o(248314);
  }
  
  private void reset()
  {
    this.luk = "";
    this.mStreamType = 0;
    this.mTi = true;
    this.mSJ = true;
    this.mTw = false;
    this.mRotation = 0;
    this.mTx = 50;
    this.lyn = "";
    this.mTy = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b.a
 * JD-Core Version:    0.7.0.1
 */