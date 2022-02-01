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
  
  public abstract void bJV();
  
  public abstract boolean bJW();
  
  public abstract boolean bJX();
  
  public abstract long bJY();
  
  public abstract void bJZ();
  
  public abstract void bKa();
  
  public abstract List<BallInfo> bKb();
  
  public abstract void bKc();
  
  public abstract boolean bKd();
  
  public abstract void bKe();
  
  public abstract void bKf();
  
  public abstract void bKg();
  
  public abstract boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter);
  
  public abstract void dw(View paramView);
  
  public abstract Point getBallPosition();
  
  public abstract BallInfo i(BallInfo paramBallInfo);
  
  public abstract void iN(boolean paramBoolean);
  
  public abstract void iO(boolean paramBoolean);
  
  public abstract void iP(boolean paramBoolean);
  
  public abstract void iQ(boolean paramBoolean);
  
  public abstract void iR(boolean paramBoolean);
  
  public abstract void iS(boolean paramBoolean);
  
  public abstract void iT(boolean paramBoolean);
  
  public abstract void iU(boolean paramBoolean);
  
  public abstract void iV(boolean paramBoolean);
  
  public abstract boolean j(BallInfo paramBallInfo);
  
  public abstract void k(BallInfo paramBallInfo);
  
  public abstract void l(BallInfo paramBallInfo);
  
  public abstract void m(BallInfo paramBallInfo);
  
  public abstract void n(BallInfo paramBallInfo);
  
  public abstract void o(BallInfo paramBallInfo);
  
  public abstract void onAccountRelease();
  
  public abstract void p(BallInfo paramBallInfo);
  
  public abstract void q(BallInfo paramBallInfo);
  
  public abstract void r(BallInfo paramBallInfo);
  
  public abstract void s(BallInfo paramBallInfo);
  
  public abstract void setEnableClick(boolean paramBoolean);
  
  public abstract void t(BallInfo paramBallInfo);
  
  public abstract void te(long paramLong);
  
  public abstract boolean xS(int paramInt);
  
  public abstract void xT(int paramInt);
  
  public abstract void xU(int paramInt);
  
  public static abstract interface a
  {
    public abstract void xV(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.c.c
 * JD-Core Version:    0.7.0.1
 */