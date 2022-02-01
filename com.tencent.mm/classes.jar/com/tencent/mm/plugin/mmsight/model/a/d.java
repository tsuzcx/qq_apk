package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.mmsight.model.g;

public abstract interface d
{
  public abstract void E(Runnable paramRunnable);
  
  public abstract void HA(String paramString);
  
  public abstract void HB(String paramString);
  
  public abstract void M(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(a parama);
  
  public abstract String aQK();
  
  public abstract float aQL();
  
  public abstract long aQM();
  
  public abstract c aQN();
  
  public abstract int aQO();
  
  public abstract Point aQP();
  
  public abstract int aQQ();
  
  public abstract boolean aQR();
  
  public abstract c.a aQS();
  
  public abstract void aQT();
  
  public abstract String aQn();
  
  public abstract void av(float paramFloat);
  
  public abstract int b(int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void cancel();
  
  public abstract void clear();
  
  public abstract void fk(boolean paramBoolean);
  
  public abstract String getFileName();
  
  public abstract String getFilePath();
  
  public abstract g getFrameDataCallback();
  
  public abstract String getMd5();
  
  public abstract boolean isLandscape();
  
  public abstract void pause();
  
  public abstract boolean rC(int paramInt);
  
  public abstract void rD(int paramInt);
  
  public abstract void reset();
  
  public abstract void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setFilePath(String paramString);
  
  public abstract void setMirror(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void bqP();
  }
  
  public static abstract interface b {}
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(148825);
      zvt = new c("WaitStart", 0);
      zvu = new c("Start", 1);
      zvv = new c("PrepareStop", 2);
      zvw = new c("WaitStop", 3);
      zvx = new c("Stop", 4);
      zvy = new c("WaitSend", 5);
      zvz = new c("Sent", 6);
      zvA = new c("Error", 7);
      zvB = new c("Initialized", 8);
      zvC = new c("Pause", 9);
      zvD = new c[] { zvt, zvu, zvv, zvw, zvx, zvy, zvz, zvA, zvB, zvC };
      AppMethodBeat.o(148825);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.d
 * JD-Core Version:    0.7.0.1
 */