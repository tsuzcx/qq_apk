package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.mmsight.model.g;

public abstract interface d
{
  public abstract void C(Runnable paramRunnable);
  
  public abstract void J(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String JS();
  
  public abstract void a(a parama);
  
  public abstract void af(float paramFloat);
  
  public abstract String anX();
  
  public abstract String aon();
  
  public abstract float aoo();
  
  public abstract long aop();
  
  public abstract c aoq();
  
  public abstract int aor();
  
  public abstract Point aos();
  
  public abstract int aot();
  
  public abstract boolean aou();
  
  public abstract boolean aov();
  
  public abstract c.a aow();
  
  public abstract void aox();
  
  public abstract int b(int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void cancel();
  
  public abstract void clear();
  
  public abstract void dV(boolean paramBoolean);
  
  public abstract String getFileName();
  
  public abstract String getFilePath();
  
  public abstract g getFrameDataCallback();
  
  public abstract boolean mQ(int paramInt);
  
  public abstract void mR(int paramInt);
  
  public abstract void pause();
  
  public abstract void reset();
  
  public abstract void ru(String paramString);
  
  public abstract void rv(String paramString);
  
  public abstract void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setFilePath(String paramString);
  
  public abstract void setMirror(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void aLq();
  }
  
  public static abstract interface b {}
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(148825);
      tDN = new c("WaitStart", 0);
      tDO = new c("Start", 1);
      tDP = new c("PrepareStop", 2);
      tDQ = new c("WaitStop", 3);
      tDR = new c("Stop", 4);
      tDS = new c("WaitSend", 5);
      tDT = new c("Sent", 6);
      tDU = new c("Error", 7);
      tDV = new c("Initialized", 8);
      tDW = new c("Pause", 9);
      tDX = new c[] { tDN, tDO, tDP, tDQ, tDR, tDS, tDT, tDU, tDV, tDW };
      AppMethodBeat.o(148825);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.d
 * JD-Core Version:    0.7.0.1
 */