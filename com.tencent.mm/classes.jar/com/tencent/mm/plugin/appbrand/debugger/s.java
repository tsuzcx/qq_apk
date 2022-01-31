package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.LinkedList;

public final class s
  extends FrameLayout
{
  ViewGroup fSV;
  RemoteDebugMoveView fSW;
  private LinkedList<String> fSX = new LinkedList();
  TextView fSY;
  TextView fSZ;
  private j fSm;
  TextView fTa;
  TextView fTb;
  TextView fTc;
  TextView fTd;
  TextView fTe;
  ImageView fTf;
  ImageView fTg;
  View fTh;
  boolean fTi = false;
  private s.a fTj;
  private c fTk;
  View.OnClickListener mOnClickListener = new s.3(this);
  
  public s(Context paramContext, j paramj, s.a parama)
  {
    super(paramContext);
    this.fSm = paramj;
    this.fTj = parama;
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setBackgroundColor(getContext().getResources().getColor(y.d.transparent));
    setId(y.g.app_brand_debug_view);
  }
  
  private boolean aeP()
  {
    boolean bool = false;
    if ((!this.fSm.aeC()) && (!this.fSm.aeD())) {
      if (this.fSm.getStatus() != 5) {
        break label43;
      }
    }
    label43:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final void aeO()
  {
    ai.d(new s.2(this));
  }
  
  final void aeQ()
  {
    if ((this.fTk != null) && (this.fTk.isShowing())) {
      return;
    }
    this.fTk = h.a(getContext(), getContext().getString(y.j.app_brand_remote_debug_quit_confirm), "", getContext().getString(y.j.app_ok), getContext().getString(y.j.app_cancel), new s.4(this), null);
  }
  
  public final void aeR()
  {
    ai.d(new s.5(this));
  }
  
  public final void aeS()
  {
    aeO();
    aeR();
  }
  
  public final void bringToFront()
  {
    if (this.fSV == null)
    {
      y.w("MicroMsg.RemoteDebugView", "bringoFront mContentView is null");
      return;
    }
    this.fSV.bringChildToFront(this);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (aeP()) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void sS(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    ai.d(new s.9(this, paramString));
  }
  
  public final void show()
  {
    if (this.fTi)
    {
      this.fTh.setVisibility(0);
      if (this.fSX.size() > 0)
      {
        this.fTe.setVisibility(0);
        this.fTc.setVisibility(8);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.fTe.setVisibility(8);
      break;
      this.fTh.setVisibility(8);
      this.fTe.setVisibility(8);
      this.fTc.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s
 * JD-Core Version:    0.7.0.1
 */