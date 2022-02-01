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
  
  public abstract void byP();
  
  public abstract boolean byQ();
  
  public abstract boolean byR();
  
  public abstract long byS();
  
  public abstract void byT();
  
  public abstract void byU();
  
  public abstract List<BallInfo> byV();
  
  public abstract void byW();
  
  public abstract boolean byX();
  
  public abstract void byY();
  
  public abstract void byZ();
  
  public abstract boolean c(AnimatorListenerAdapter paramAnimatorListenerAdapter);
  
  public abstract void ds(View paramView);
  
  public abstract BallInfo g(BallInfo paramBallInfo);
  
  public abstract Point getBallPosition();
  
  public abstract boolean h(BallInfo paramBallInfo);
  
  public abstract void i(BallInfo paramBallInfo);
  
  public abstract void ie(boolean paramBoolean);
  
  public abstract void jdMethod_if(boolean paramBoolean);
  
  public abstract void ig(boolean paramBoolean);
  
  public abstract void ih(boolean paramBoolean);
  
  public abstract void ii(boolean paramBoolean);
  
  public abstract void ij(boolean paramBoolean);
  
  public abstract void ik(boolean paramBoolean);
  
  public abstract void il(boolean paramBoolean);
  
  public abstract void im(boolean paramBoolean);
  
  public abstract void j(BallInfo paramBallInfo);
  
  public abstract void k(BallInfo paramBallInfo);
  
  public abstract void l(BallInfo paramBallInfo);
  
  public abstract void m(BallInfo paramBallInfo);
  
  public abstract void n(BallInfo paramBallInfo);
  
  public abstract void nt(long paramLong);
  
  public abstract void o(BallInfo paramBallInfo);
  
  public abstract void onAccountRelease();
  
  public abstract void p(BallInfo paramBallInfo);
  
  public abstract void q(BallInfo paramBallInfo);
  
  public abstract void r(BallInfo paramBallInfo);
  
  public abstract void setEnableClick(boolean paramBoolean);
  
  public abstract boolean wu(int paramInt);
  
  public abstract void wv(int paramInt);
  
  public abstract void ww(int paramInt);
  
  public static abstract interface a
  {
    public abstract void wx(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.c.c
 * JD-Core Version:    0.7.0.1
 */