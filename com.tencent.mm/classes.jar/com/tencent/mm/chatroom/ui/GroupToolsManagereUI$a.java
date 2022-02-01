package com.tencent.mm.chatroom.ui;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;

public final class GroupToolsManagereUI$a
  extends k.a
{
  private List dTG;
  private boolean hxh = false;
  private GroupToolsManagereUI.b lBV;
  private boolean lBW = true;
  
  public GroupToolsManagereUI$a(List paramList, GroupToolsManagereUI.b paramb)
  {
    this.dTG = paramList;
    this.lBV = paramb;
  }
  
  public final boolean Ji()
  {
    return false;
  }
  
  public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(241509);
    int i = bk(3, 0);
    AppMethodBeat.o(241509);
    return i;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(241532);
    ViewPropertyAnimator localViewPropertyAnimator;
    if (this.lBW)
    {
      localViewPropertyAnimator = paramv.caK.animate();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramv.caK.setTranslationZ(20.0F);
        localViewPropertyAnimator.start();
      }
      this.lBW = false;
    }
    if (this.hxh)
    {
      localViewPropertyAnimator = paramv.caK.animate();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramv.caK.setTranslationZ(0.0F);
        localViewPropertyAnimator.start();
      }
      this.hxh = false;
      this.lBW = true;
    }
    super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1, paramFloat2, paramInt, paramBoolean);
    AppMethodBeat.o(241532);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    AppMethodBeat.i(241514);
    int i = paramv1.KJ();
    int k = paramv2.KJ();
    Log.d("MicroMsg.roomtools.GroupToolsManagereUI", "onMove fromIndex:%s toIndex:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    if (i < k)
    {
      j = i;
      while (j < k)
      {
        Collections.swap(this.dTG, j, j + 1);
        j += 1;
      }
    }
    int j = i;
    while (j > k)
    {
      Collections.swap(this.dTG, j, j - 1);
      j -= 1;
    }
    paramRecyclerView.getAdapter().bz(i, k);
    if (this.lBV != null) {
      this.lBV.onAlert();
    }
    paramv1.caK.performHapticFeedback(0, 2);
    AppMethodBeat.o(241514);
    return true;
  }
  
  public final void b(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(241523);
    super.b(paramv, paramInt);
    AppMethodBeat.o(241523);
  }
  
  public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(241530);
    super.d(paramRecyclerView, paramv);
    this.hxh = true;
    AppMethodBeat.o(241530);
  }
  
  public final void h(RecyclerView.v paramv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.a
 * JD-Core Version:    0.7.0.1
 */