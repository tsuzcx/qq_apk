package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.q;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.u;

public final class t
  implements a
{
  private static Integer huE = null;
  private final Rect huA = new Rect();
  private boolean huB = false;
  private View huC;
  t.a huD;
  private int huy = 0;
  private final int[] huz = new int[2];
  
  private Context getContext()
  {
    if (this.huC == null) {
      return ae.getContext();
    }
    return this.huC.getContext();
  }
  
  private int getFrameHeight()
  {
    if (this.huC == null) {}
    for (Object localObject = null; localObject == null; localObject = this.huC.getRootView()) {
      return 0;
    }
    localObject = this.huA;
    getWindowVisibleDisplayFrame((Rect)localObject);
    if (q.al(this.huC)) {}
    for (int i = this.huC.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels) {
      return i - ((Rect)localObject).top;
    }
  }
  
  private void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    if (this.huC != null)
    {
      this.huC.getWindowVisibleDisplayFrame(paramRect);
      this.huC.getLocationInWindow(this.huz);
      paramRect.top = this.huz[1];
    }
  }
  
  public final void ck(View paramView)
  {
    int j = 1;
    this.huC = paramView;
    paramView = this.huA;
    getWindowVisibleDisplayFrame(paramView);
    int k = paramView.height();
    boolean bool;
    if (this.huy == 0)
    {
      this.huy = k;
      if (getFrameHeight() <= k) {
        break label204;
      }
      bool = true;
      label48:
      if (this.huB == bool) {
        break label210;
      }
    }
    label202:
    label204:
    label210:
    for (int i = j;; i = 0)
    {
      if ((i != 0) && (this.huD != null)) {
        this.huD.dW(bool);
      }
      this.huB = bool;
      this.huy = k;
      this.huC = null;
      return;
      int m = getFrameHeight() - k;
      if (m <= 0) {
        break;
      }
      paramView = getContext();
      if (m > 0)
      {
        if (huE == null) {
          huE = Integer.valueOf(u.fy(paramView));
        }
        if (huE.intValue() != m) {
          huE = Integer.valueOf(m);
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) || (this.huD == null) || (this.huD.getHeight() == m)) {
          break label202;
        }
        this.huD.mP(m);
        break;
      }
      break;
      bool = false;
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.t
 * JD-Core Version:    0.7.0.1
 */