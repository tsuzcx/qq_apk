package com.tencent.mm.chatroom.ui;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;

public final class GroupToolsManagereUI$a
  extends l.a
{
  private boolean fsS = false;
  private List iZZ;
  private GroupToolsManagereUI.b jaa;
  private boolean jab = true;
  
  public GroupToolsManagereUI$a(List paramList, GroupToolsManagereUI.b paramb)
  {
    this.iZZ = paramList;
    this.jaa = paramb;
  }
  
  public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(192241);
    int i = cA(3);
    AppMethodBeat.o(192241);
    return i;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192268);
    ViewPropertyAnimator localViewPropertyAnimator;
    if (this.jab)
    {
      localViewPropertyAnimator = paramv.amk.animate();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramv.amk.setTranslationZ(20.0F);
        localViewPropertyAnimator.start();
      }
      this.jab = false;
    }
    if (this.fsS)
    {
      localViewPropertyAnimator = paramv.amk.animate();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramv.amk.setTranslationZ(0.0F);
        localViewPropertyAnimator.start();
      }
      this.fsS = false;
      this.jab = true;
    }
    super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1, paramFloat2, paramInt, paramBoolean);
    AppMethodBeat.o(192268);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    AppMethodBeat.i(192253);
    int i = paramv1.md();
    int k = paramv2.md();
    Log.d("MicroMsg.roomtools.GroupToolsManagereUI", "onMove fromIndex:%s toIndex:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    if (i < k)
    {
      j = i;
      while (j < k)
      {
        Collections.swap(this.iZZ, j, j + 1);
        j += 1;
      }
    }
    int j = i;
    while (j > k)
    {
      Collections.swap(this.iZZ, j, j - 1);
      j -= 1;
    }
    paramRecyclerView.getAdapter().aF(i, k);
    if (this.jaa != null) {
      this.jaa.asM();
    }
    paramv1.amk.performHapticFeedback(0, 2);
    AppMethodBeat.o(192253);
    return true;
  }
  
  public final void b(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(192256);
    super.b(paramv, paramInt);
    AppMethodBeat.o(192256);
  }
  
  public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(192260);
    super.d(paramRecyclerView, paramv);
    this.fsS = true;
    AppMethodBeat.o(192260);
  }
  
  public final void g(RecyclerView.v paramv) {}
  
  public final boolean kz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.a
 * JD-Core Version:    0.7.0.1
 */