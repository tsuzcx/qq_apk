package com.tencent.mm.chatroom.ui;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.a.a.a;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.List;

public final class GroupToolsManagereUI$a
  extends a.a
{
  private boolean cZd = false;
  private List frK;
  private GroupToolsManagereUI.b frL;
  private boolean frM = true;
  
  public GroupToolsManagereUI$a(List paramList, GroupToolsManagereUI.b paramb)
  {
    this.frK = paramList;
    this.frL = paramb;
  }
  
  public final void L(RecyclerView.v paramv) {}
  
  public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(182175);
    int i = di(3);
    AppMethodBeat.o(182175);
    return i;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(182179);
    ViewPropertyAnimator localViewPropertyAnimator;
    if (this.frM)
    {
      localViewPropertyAnimator = paramv.arI.animate();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramv.arI.setTranslationZ(20.0F);
        localViewPropertyAnimator.start();
      }
      this.frM = false;
    }
    if (this.cZd)
    {
      localViewPropertyAnimator = paramv.arI.animate();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramv.arI.setTranslationZ(0.0F);
        localViewPropertyAnimator.start();
      }
      this.cZd = false;
      this.frM = true;
    }
    super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1, paramFloat2, paramInt, paramBoolean);
    AppMethodBeat.o(182179);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    AppMethodBeat.i(182176);
    int i = paramv1.ln();
    int k = paramv2.ln();
    ad.d("MicroMsg.roomtools.GroupToolsManagereUI", "onMove fromIndex:%s toIndex:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    if (i < k)
    {
      j = i;
      while (j < k)
      {
        Collections.swap(this.frK, j, j + 1);
        j += 1;
      }
    }
    int j = i;
    while (j > k)
    {
      Collections.swap(this.frK, j, j - 1);
      j -= 1;
    }
    paramRecyclerView.getAdapter().ap(i, k);
    if (this.frL != null) {
      this.frL.Vy();
    }
    paramv1.arI.performHapticFeedback(0, 2);
    AppMethodBeat.o(182176);
    return true;
  }
  
  public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(182178);
    super.d(paramRecyclerView, paramv);
    this.cZd = true;
    AppMethodBeat.o(182178);
  }
  
  public final void f(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(182177);
    super.f(paramv, paramInt);
    AppMethodBeat.o(182177);
  }
  
  public final boolean mM()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.a
 * JD-Core Version:    0.7.0.1
 */