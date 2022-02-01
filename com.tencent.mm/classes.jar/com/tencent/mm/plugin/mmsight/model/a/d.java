package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.mmsight.model.g;

public abstract interface d
{
  public abstract void D(Runnable paramRunnable);
  
  public abstract void L(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String Lb();
  
  public abstract void a(a parama);
  
  public abstract void am(float paramFloat);
  
  public abstract boolean aol();
  
  public abstract String axA();
  
  public abstract String axR();
  
  public abstract float axS();
  
  public abstract long axT();
  
  public abstract c axU();
  
  public abstract int axV();
  
  public abstract Point axW();
  
  public abstract int axX();
  
  public abstract boolean axY();
  
  public abstract c.a axZ();
  
  public abstract void aya();
  
  public abstract int b(int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void cancel();
  
  public abstract void clear();
  
  public abstract void es(boolean paramBoolean);
  
  public abstract String getFileName();
  
  public abstract String getFilePath();
  
  public abstract g getFrameDataCallback();
  
  public abstract boolean od(int paramInt);
  
  public abstract void oe(int paramInt);
  
  public abstract void pause();
  
  public abstract void reset();
  
  public abstract void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setFilePath(String paramString);
  
  public abstract void setMirror(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void yo(String paramString);
  
  public abstract void yp(String paramString);
  
  public static abstract interface a
  {
    public abstract void aVt();
  }
  
  public static abstract interface b {}
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(148825);
      vPo = new c("WaitStart", 0);
      vPp = new c("Start", 1);
      vPq = new c("PrepareStop", 2);
      vPr = new c("WaitStop", 3);
      vPs = new c("Stop", 4);
      vPt = new c("WaitSend", 5);
      vPu = new c("Sent", 6);
      vPv = new c("Error", 7);
      vPw = new c("Initialized", 8);
      vPx = new c("Pause", 9);
      vPy = new c[] { vPo, vPp, vPq, vPr, vPs, vPt, vPu, vPv, vPw, vPx };
      AppMethodBeat.o(148825);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.d
 * JD-Core Version:    0.7.0.1
 */