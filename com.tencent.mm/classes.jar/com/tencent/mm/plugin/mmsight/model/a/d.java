package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.mmsight.model.g;

public abstract interface d
{
  public abstract void E(Runnable paramRunnable);
  
  public abstract String JC();
  
  public abstract void K(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(a parama);
  
  public abstract void aj(float paramFloat);
  
  public abstract boolean aly();
  
  public abstract String auN();
  
  public abstract String ave();
  
  public abstract float avf();
  
  public abstract long avg();
  
  public abstract c avh();
  
  public abstract int avi();
  
  public abstract Point avj();
  
  public abstract int avk();
  
  public abstract boolean avl();
  
  public abstract c.a avm();
  
  public abstract void avn();
  
  public abstract int b(int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void cancel();
  
  public abstract void clear();
  
  public abstract void eq(boolean paramBoolean);
  
  public abstract String getFileName();
  
  public abstract String getFilePath();
  
  public abstract g getFrameDataCallback();
  
  public abstract boolean nE(int paramInt);
  
  public abstract void nF(int paramInt);
  
  public abstract void pause();
  
  public abstract void reset();
  
  public abstract void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setFilePath(String paramString);
  
  public abstract void setMirror(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void vx(String paramString);
  
  public abstract void vy(String paramString);
  
  public static abstract interface a
  {
    public abstract void aSh();
  }
  
  public static abstract interface b {}
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(148825);
      uMi = new c("WaitStart", 0);
      uMj = new c("Start", 1);
      uMk = new c("PrepareStop", 2);
      uMl = new c("WaitStop", 3);
      uMm = new c("Stop", 4);
      uMn = new c("WaitSend", 5);
      uMo = new c("Sent", 6);
      uMp = new c("Error", 7);
      uMq = new c("Initialized", 8);
      uMr = new c("Pause", 9);
      uMs = new c[] { uMi, uMj, uMk, uMl, uMm, uMn, uMo, uMp, uMq, uMr };
      AppMethodBeat.o(148825);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.d
 * JD-Core Version:    0.7.0.1
 */