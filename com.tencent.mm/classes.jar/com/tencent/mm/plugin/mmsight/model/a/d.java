package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.mmsight.model.g;

public abstract interface d
{
  public abstract void B(Runnable paramRunnable);
  
  public abstract void L(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String Lj();
  
  public abstract void a(a parama);
  
  public abstract void am(float paramFloat);
  
  public abstract boolean aoA();
  
  public abstract String axP();
  
  public abstract String ayg();
  
  public abstract float ayh();
  
  public abstract long ayi();
  
  public abstract c ayj();
  
  public abstract int ayk();
  
  public abstract Point ayl();
  
  public abstract int aym();
  
  public abstract boolean ayn();
  
  public abstract c.a ayo();
  
  public abstract void ayp();
  
  public abstract int b(int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void cancel();
  
  public abstract void clear();
  
  public abstract void eu(boolean paramBoolean);
  
  public abstract String getFileName();
  
  public abstract String getFilePath();
  
  public abstract g getFrameDataCallback();
  
  public abstract boolean og(int paramInt);
  
  public abstract void oh(int paramInt);
  
  public abstract void pause();
  
  public abstract void reset();
  
  public abstract void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setFilePath(String paramString);
  
  public abstract void setMirror(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void yY(String paramString);
  
  public abstract void yZ(String paramString);
  
  public static abstract interface a
  {
    public abstract void aVS();
  }
  
  public static abstract interface b {}
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(148825);
      wbr = new c("WaitStart", 0);
      wbs = new c("Start", 1);
      wbt = new c("PrepareStop", 2);
      wbu = new c("WaitStop", 3);
      wbv = new c("Stop", 4);
      wbw = new c("WaitSend", 5);
      wbx = new c("Sent", 6);
      wby = new c("Error", 7);
      wbz = new c("Initialized", 8);
      wbA = new c("Pause", 9);
      wbB = new c[] { wbr, wbs, wbt, wbu, wbv, wbw, wbx, wby, wbz, wbA };
      AppMethodBeat.o(148825);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.d
 * JD-Core Version:    0.7.0.1
 */