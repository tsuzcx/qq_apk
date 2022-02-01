package com.tencent.mm.plugin.ball.c;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import java.util.List;
import java.util.Set;

public abstract interface b
  extends a
{
  public abstract void BC(int paramInt);
  
  public abstract void BD(int paramInt);
  
  public abstract void By(long paramLong);
  
  public abstract void Dw(boolean paramBoolean);
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
  
  public abstract void a(int paramInt, e parame);
  
  public abstract void a(long paramLong, a parama);
  
  public abstract void a(ResultReceiver paramResultReceiver);
  
  public abstract void a(d paramd);
  
  public abstract void a(g paramg);
  
  public abstract void a(i parami);
  
  public abstract void a(BallInfo paramBallInfo, float paramFloat);
  
  public abstract void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver);
  
  public abstract void a(BallInfo paramBallInfo, boolean paramBoolean);
  
  public abstract void b(int paramInt, e parame);
  
  public abstract void b(d paramd);
  
  public abstract void b(g paramg);
  
  public abstract boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter);
  
  public abstract void chL();
  
  public abstract boolean chM();
  
  public abstract boolean chN();
  
  public abstract boolean chO();
  
  public abstract void chP();
  
  public abstract List<BallInfo> chQ();
  
  public abstract List<BallInfo> chR();
  
  public abstract Set<g> chS();
  
  public abstract boolean chT();
  
  public abstract void chU();
  
  public abstract boolean chV();
  
  public abstract void chW();
  
  public abstract void chX();
  
  public abstract void dn(View paramView);
  
  public abstract long fvY();
  
  public abstract void fwa();
  
  public abstract Point getBallPosition();
  
  public abstract BallInfo h(BallInfo paramBallInfo);
  
  public abstract boolean i(BallInfo paramBallInfo);
  
  public abstract void j(BallInfo paramBallInfo);
  
  public abstract void jL(boolean paramBoolean);
  
  public abstract void jM(boolean paramBoolean);
  
  public abstract void jN(boolean paramBoolean);
  
  public abstract void jO(boolean paramBoolean);
  
  public abstract void jP(boolean paramBoolean);
  
  public abstract void jQ(boolean paramBoolean);
  
  public abstract void jR(boolean paramBoolean);
  
  public abstract void jS(boolean paramBoolean);
  
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
  
  public abstract void u(BallInfo paramBallInfo);
  
  public static abstract interface a
  {
    public abstract void BE(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.c.b
 * JD-Core Version:    0.7.0.1
 */