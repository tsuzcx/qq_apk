package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.mmsight.model.g;

public abstract interface d
{
  public abstract void E(Runnable paramRunnable);
  
  public abstract void ON(String paramString);
  
  public abstract void OO(String paramString);
  
  public abstract void P(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(a parama);
  
  public abstract String aZC();
  
  public abstract float aZD();
  
  public abstract long aZE();
  
  public abstract c aZF();
  
  public abstract int aZG();
  
  public abstract Point aZH();
  
  public abstract int aZI();
  
  public abstract boolean aZJ();
  
  public abstract c.a aZK();
  
  public abstract void aZL();
  
  public abstract String aZe();
  
  public abstract void av(float paramFloat);
  
  public abstract int b(int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void cancel();
  
  public abstract void clear();
  
  public abstract void fU(boolean paramBoolean);
  
  public abstract String getFileName();
  
  public abstract String getFilePath();
  
  public abstract g getFrameDataCallback();
  
  public abstract String getMd5();
  
  public abstract boolean isLandscape();
  
  public abstract void pause();
  
  public abstract void reset();
  
  public abstract void setFilePath(String paramString);
  
  public abstract void setMirror(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean uw(int paramInt);
  
  public abstract void ux(int paramInt);
  
  public static abstract interface a
  {
    public abstract void bBE();
  }
  
  public static abstract interface b {}
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(148825);
      FaS = new c("WaitStart", 0);
      FaT = new c("Start", 1);
      FaU = new c("PrepareStop", 2);
      FaV = new c("WaitStop", 3);
      FaW = new c("Stop", 4);
      FaX = new c("WaitSend", 5);
      FaY = new c("Sent", 6);
      FaZ = new c("Error", 7);
      Fba = new c("Initialized", 8);
      Fbb = new c("Pause", 9);
      Fbc = new c[] { FaS, FaT, FaU, FaV, FaW, FaX, FaY, FaZ, Fba, Fbb };
      AppMethodBeat.o(148825);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.d
 * JD-Core Version:    0.7.0.1
 */