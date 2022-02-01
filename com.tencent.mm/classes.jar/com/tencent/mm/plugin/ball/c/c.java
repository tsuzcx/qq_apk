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
  
  public abstract void a(i parami);
  
  public abstract void a(BallInfo paramBallInfo, float paramFloat);
  
  public abstract void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver);
  
  public abstract void a(BallInfo paramBallInfo, boolean paramBoolean);
  
  public abstract void b(int paramInt, f paramf);
  
  public abstract void bKT();
  
  public abstract boolean bKU();
  
  public abstract boolean bKV();
  
  public abstract long bKW();
  
  public abstract void bKX();
  
  public abstract void bKY();
  
  public abstract List<BallInfo> bKZ();
  
  public abstract void bLa();
  
  public abstract boolean bLb();
  
  public abstract void bLc();
  
  public abstract void bLd();
  
  public abstract boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter);
  
  public abstract void dw(View paramView);
  
  public abstract Point getBallPosition();
  
  public abstract BallInfo i(BallInfo paramBallInfo);
  
  public abstract void iM(boolean paramBoolean);
  
  public abstract void iN(boolean paramBoolean);
  
  public abstract void iO(boolean paramBoolean);
  
  public abstract void iP(boolean paramBoolean);
  
  public abstract void iQ(boolean paramBoolean);
  
  public abstract void iR(boolean paramBoolean);
  
  public abstract void iS(boolean paramBoolean);
  
  public abstract void iT(boolean paramBoolean);
  
  public abstract void iU(boolean paramBoolean);
  
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
  
  public abstract void ts(long paramLong);
  
  public abstract void u(BallInfo paramBallInfo);
  
  public abstract void v(BallInfo paramBallInfo);
  
  public abstract boolean xW(int paramInt);
  
  public abstract void xX(int paramInt);
  
  public abstract void xY(int paramInt);
  
  public static abstract interface a
  {
    public abstract void xZ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.c.c
 * JD-Core Version:    0.7.0.1
 */