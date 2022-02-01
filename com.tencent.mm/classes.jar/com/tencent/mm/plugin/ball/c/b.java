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
  public abstract void Fd(int paramInt);
  
  public abstract void Fe(int paramInt);
  
  public abstract void HL(long paramLong);
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
  
  public abstract void a(int paramInt, e parame);
  
  public abstract void a(long paramLong, a parama);
  
  public abstract void a(ResultReceiver paramResultReceiver);
  
  public abstract void a(d paramd);
  
  public abstract void a(g paramg);
  
  public abstract void a(i parami);
  
  public abstract void a(BallInfo paramBallInfo, ResultReceiver paramResultReceiver);
  
  public abstract void a(BallInfo paramBallInfo, boolean paramBoolean);
  
  public abstract void aGp();
  
  public abstract void b(int paramInt, e parame);
  
  public abstract void b(d paramd);
  
  public abstract void b(g paramg);
  
  public abstract boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter);
  
  public abstract boolean cuW();
  
  public abstract boolean cuX();
  
  public abstract boolean cuY();
  
  public abstract long cuZ();
  
  public abstract void cva();
  
  public abstract void cvb();
  
  public abstract List<BallInfo> cvc();
  
  public abstract List<BallInfo> cvd();
  
  public abstract Set<g> cve();
  
  public abstract boolean cvf();
  
  public abstract void cvg();
  
  public abstract boolean cvh();
  
  public abstract void cvi();
  
  public abstract void cvj();
  
  public abstract void dK(View paramView);
  
  public abstract Point getBallPosition();
  
  public abstract BallInfo h(BallInfo paramBallInfo);
  
  public abstract boolean i(BallInfo paramBallInfo);
  
  public abstract void j(BallInfo paramBallInfo);
  
  public abstract void k(BallInfo paramBallInfo);
  
  public abstract void kV(boolean paramBoolean);
  
  public abstract void kW(boolean paramBoolean);
  
  public abstract void kX(boolean paramBoolean);
  
  public abstract void kY(boolean paramBoolean);
  
  public abstract void kZ(boolean paramBoolean);
  
  public abstract void l(BallInfo paramBallInfo);
  
  public abstract void la(boolean paramBoolean);
  
  public abstract void lb(boolean paramBoolean);
  
  public abstract void lc(boolean paramBoolean);
  
  public abstract void ld(boolean paramBoolean);
  
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
    public abstract void Ff(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.c.b
 * JD-Core Version:    0.7.0.1
 */