package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.mmsight.model.g;

public abstract interface d
{
  public abstract void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void Hd(String paramString);
  
  public abstract void He(String paramString);
  
  public abstract void J(Runnable paramRunnable);
  
  public abstract void a(a parama);
  
  public abstract void ae(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int b(int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void bq(float paramFloat);
  
  public abstract String buA();
  
  public abstract float buB();
  
  public abstract long buC();
  
  public abstract c buD();
  
  public abstract int buE();
  
  public abstract Point buF();
  
  public abstract int buG();
  
  public abstract boolean buH();
  
  public abstract c.a buI();
  
  public abstract void buJ();
  
  public abstract String bud();
  
  public abstract void cancel();
  
  public abstract void clear();
  
  public abstract void gI(boolean paramBoolean);
  
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
  
  public abstract boolean uw(int paramInt);
  
  public abstract void ux(int paramInt);
  
  public static abstract interface a
  {
    public abstract void cba();
  }
  
  public static abstract interface b {}
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(148825);
      KWB = new c("WaitStart", 0);
      KWC = new c("Start", 1);
      KWD = new c("PrepareStop", 2);
      KWE = new c("WaitStop", 3);
      KWF = new c("Stop", 4);
      KWG = new c("WaitSend", 5);
      KWH = new c("Sent", 6);
      KWI = new c("Error", 7);
      KWJ = new c("Initialized", 8);
      KWK = new c("Pause", 9);
      KWL = new c[] { KWB, KWC, KWD, KWE, KWF, KWG, KWH, KWI, KWJ, KWK };
      AppMethodBeat.o(148825);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.d
 * JD-Core Version:    0.7.0.1
 */