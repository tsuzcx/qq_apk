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
  public abstract void FE(int paramInt);
  
  public abstract void FF(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
  
  public abstract void a(int paramInt, e parame);
  
  public abstract void a(long paramLong, a parama);
  
  public abstract void a(d paramd);
  
  public abstract void a(g paramg);
  
  public abstract void a(i parami);
  
  public abstract void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver);
  
  public abstract void a(BallInfo paramBallInfo, boolean paramBoolean);
  
  public abstract void aZq();
  
  public abstract void b(int paramInt, e parame);
  
  public abstract void b(ResultReceiver paramResultReceiver);
  
  public abstract void b(d paramd);
  
  public abstract void b(g paramg);
  
  public abstract boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter);
  
  public abstract boolean cXG();
  
  public abstract boolean cXH();
  
  public abstract boolean cXI();
  
  public abstract long cXJ();
  
  public abstract void cXK();
  
  public abstract void cXL();
  
  public abstract List<BallInfo> cXM();
  
  public abstract List<BallInfo> cXN();
  
  public abstract Set<g> cXO();
  
  public abstract boolean cXP();
  
  public abstract void cXQ();
  
  public abstract boolean cXR();
  
  public abstract void cXS();
  
  public abstract void cXT();
  
  public abstract void cXU();
  
  public abstract void ex(View paramView);
  
  public abstract Point getBallPosition();
  
  public abstract BallInfo h(BallInfo paramBallInfo);
  
  public abstract boolean i(BallInfo paramBallInfo);
  
  public abstract void j(BallInfo paramBallInfo);
  
  public abstract void k(BallInfo paramBallInfo);
  
  public abstract void kc(long paramLong);
  
  public abstract void l(BallInfo paramBallInfo);
  
  public abstract void m(BallInfo paramBallInfo);
  
  public abstract void mi(boolean paramBoolean);
  
  public abstract void mj(boolean paramBoolean);
  
  public abstract void mk(boolean paramBoolean);
  
  public abstract void ml(boolean paramBoolean);
  
  public abstract void mm(boolean paramBoolean);
  
  public abstract void mn(boolean paramBoolean);
  
  public abstract void mo(boolean paramBoolean);
  
  public abstract void mp(boolean paramBoolean);
  
  public abstract void mq(boolean paramBoolean);
  
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
    public abstract void onAddResult(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.c.b
 * JD-Core Version:    0.7.0.1
 */