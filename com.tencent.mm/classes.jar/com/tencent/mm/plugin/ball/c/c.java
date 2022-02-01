package com.tencent.mm.plugin.ball.c;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import java.util.List;

public abstract interface c
  extends a
{
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
  
  public abstract void a(int paramInt, f paramf);
  
  public abstract void a(long paramLong, a parama);
  
  public abstract void a(ResultReceiver paramResultReceiver);
  
  public abstract void a(h paramh);
  
  public abstract void a(BallInfo paramBallInfo, float paramFloat);
  
  public abstract void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver);
  
  public abstract void a(BallInfo paramBallInfo, boolean paramBoolean);
  
  public abstract void b(int paramInt, f paramf);
  
  public abstract void bFL();
  
  public abstract boolean bFM();
  
  public abstract boolean bFN();
  
  public abstract long bFO();
  
  public abstract void bFP();
  
  public abstract void bFQ();
  
  public abstract List<BallInfo> bFR();
  
  public abstract void bFS();
  
  public abstract boolean bFT();
  
  public abstract void bFU();
  
  public abstract void bFV();
  
  public abstract boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter);
  
  public abstract void du(View paramView);
  
  public abstract Point getBallPosition();
  
  public abstract BallInfo h(BallInfo paramBallInfo);
  
  public abstract boolean i(BallInfo paramBallInfo);
  
  public abstract void iE(boolean paramBoolean);
  
  public abstract void iF(boolean paramBoolean);
  
  public abstract void iG(boolean paramBoolean);
  
  public abstract void iH(boolean paramBoolean);
  
  public abstract void iI(boolean paramBoolean);
  
  public abstract void iJ(boolean paramBoolean);
  
  public abstract void iK(boolean paramBoolean);
  
  public abstract void iL(boolean paramBoolean);
  
  public abstract void iM(boolean paramBoolean);
  
  public abstract void j(BallInfo paramBallInfo);
  
  public abstract void k(BallInfo paramBallInfo);
  
  public abstract void l(BallInfo paramBallInfo);
  
  public abstract void m(BallInfo paramBallInfo);
  
  public abstract void n(BallInfo paramBallInfo);
  
  public abstract void o(BallInfo paramBallInfo);
  
  public abstract void onAccountRelease();
  
  public abstract void p(BallInfo paramBallInfo);
  
  public abstract void q(BallInfo paramBallInfo);
  
  public abstract void r(BallInfo paramBallInfo);
  
  public abstract void rf(long paramLong);
  
  public abstract void s(BallInfo paramBallInfo);
  
  public abstract void setEnableClick(boolean paramBoolean);
  
  public abstract boolean xm(int paramInt);
  
  public abstract void xn(int paramInt);
  
  public abstract void xo(int paramInt);
  
  public static abstract interface a
  {
    public abstract void xp(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.c.c
 * JD-Core Version:    0.7.0.1
 */