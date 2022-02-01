package com.tencent.mm.chatroom.ui;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.a.a.a;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Collections;
import java.util.List;

public final class GroupToolsManagereUI$a
  extends a.a
{
  private boolean cWz = false;
  private List fvr;
  private GroupToolsManagereUI.b fvs;
  private boolean fvt = true;
  
  public GroupToolsManagereUI$a(List paramList, GroupToolsManagereUI.b paramb)
  {
    this.fvr = paramList;
    this.fvs = paramb;
  }
  
  public final void L(RecyclerView.w paramw) {}
  
  public final int a(RecyclerView paramRecyclerView, RecyclerView.w paramw)
  {
    AppMethodBeat.i(182175);
    int i = dh(3);
    AppMethodBeat.o(182175);
    return i;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.w paramw, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(182179);
    ViewPropertyAnimator localViewPropertyAnimator;
    if (this.fvt)
    {
      localViewPropertyAnimator = paramw.asD.animate();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramw.asD.setTranslationZ(20.0F);
        localViewPropertyAnimator.start();
      }
      this.fvt = false;
    }
    if (this.cWz)
    {
      localViewPropertyAnimator = paramw.asD.animate();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramw.asD.setTranslationZ(0.0F);
        localViewPropertyAnimator.start();
      }
      this.cWz = false;
      this.fvt = true;
    }
    super.a(paramCanvas, paramRecyclerView, paramw, paramFloat1, paramFloat2, paramInt, paramBoolean);
    AppMethodBeat.o(182179);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2)
  {
    AppMethodBeat.i(182176);
    int i = paramw1.lv();
    int k = paramw2.lv();
    ac.d("MicroMsg.roomtools.GroupToolsManagereUI", "onMove fromIndex:%s toIndex:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    if (i < k)
    {
      j = i;
      while (j < k)
      {
        Collections.swap(this.fvr, j, j + 1);
        j += 1;
      }
    }
    int j = i;
    while (j > k)
    {
      Collections.swap(this.fvr, j, j - 1);
      j -= 1;
    }
    paramRecyclerView.getAdapter().ap(i, k);
    if (this.fvs != null) {
      this.fvs.Ww();
    }
    paramw1.asD.performHapticFeedback(0, 2);
    AppMethodBeat.o(182176);
    return true;
  }
  
  public final void d(RecyclerView paramRecyclerView, RecyclerView.w paramw)
  {
    AppMethodBeat.i(182178);
    super.d(paramRecyclerView, paramw);
    this.cWz = true;
    AppMethodBeat.o(182178);
  }
  
  public final void f(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(182177);
    super.f(paramw, paramInt);
    AppMethodBeat.o(182177);
  }
  
  public final boolean mW()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.a
 * JD-Core Version:    0.7.0.1
 */