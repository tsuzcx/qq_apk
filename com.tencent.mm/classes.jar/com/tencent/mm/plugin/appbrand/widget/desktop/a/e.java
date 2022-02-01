package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;

public final class e<T extends RecyclerView.v>
  extends b<T>
{
  int bNu = 0;
  FrameLayout cIL;
  int endPos = 0;
  private List nZr;
  View ooN;
  public com.tencent.mm.plugin.appbrand.widget.desktop.f ooV = null;
  public a opC;
  Object opL;
  private f opM;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public e(FrameLayout paramFrameLayout, List paramList, f paramf)
  {
    this.cIL = paramFrameLayout;
    this.nZr = paramList;
    this.opM = paramf;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49840);
    if (this.opC != null)
    {
      boolean bool = this.opC.R(paramT);
      AppMethodBeat.o(49840);
      return bool;
    }
    if (paramT == null)
    {
      AppMethodBeat.o(49840);
      return false;
    }
    AppMethodBeat.o(49840);
    return true;
  }
  
  public final boolean S(T paramT)
  {
    AppMethodBeat.i(49846);
    if (this.opC != null)
    {
      boolean bool = this.opC.S(paramT);
      AppMethodBeat.o(49846);
      return bool;
    }
    AppMethodBeat.o(49846);
    return false;
  }
  
  public final boolean T(T paramT)
  {
    AppMethodBeat.i(49842);
    if (this.opC != null)
    {
      boolean bool = this.opC.c(paramT, null);
      AppMethodBeat.o(49842);
      return bool;
    }
    AppMethodBeat.o(49842);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, T paramT, int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49844);
    if (this.opC != null) {
      this.opC.cR(this.ooN);
    }
    paramRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49838);
        if (e.this.opC != null) {
          e.this.opC.b(e.this.bNu, e.this.endPos, e.this.opL, true);
        }
        paramRunnable.run();
        AppMethodBeat.o(49838);
      }
    };
    RecyclerView.v localv;
    float f2;
    float f1;
    if ((paramT != null) && (this.ooN != null))
    {
      Log.i("ItemMoveHelper", "[finishMove] position" + paramT.lR() + " dragViewPosition:" + paramInt);
      localv = paramRecyclerView.ch(paramInt);
      f2 = this.ooN.getTranslationX();
      f1 = this.ooN.getTranslationY();
      if ((paramInt == paramT.lR()) || (localv != null)) {
        break label253;
      }
      if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).ks() <= paramInt) {
        break label240;
      }
      f1 -= paramRecyclerView.getHeight();
    }
    for (;;)
    {
      paramT = this.opM.cQ(this.ooN);
      paramRecyclerView = paramT;
      if (paramT == null) {
        paramRecyclerView = this.ooN;
      }
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.ooN.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new e.2(this, localv, paramRunnable)).start();
      AppMethodBeat.o(49844);
      return;
      label240:
      f1 = paramRecyclerView.getHeight() + f1;
      continue;
      label253:
      if (localv != null)
      {
        f2 = f(paramRecyclerView, localv);
        float f3 = this.opM.cam();
        f1 = e(paramRecyclerView, localv) + this.opM.can();
        f2 = f3 + f2;
      }
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(49845);
    if (paramView == null)
    {
      AppMethodBeat.o(49845);
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    AppMethodBeat.o(49845);
  }
  
  public final boolean a(RecyclerView paramRecyclerView, T paramT1, T paramT2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49843);
    Log.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + paramT1.lR() + " target:" + paramT2.lR());
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", new Object[] { Integer.valueOf(this.nZr.hashCode()) });
    if ((paramInt1 < 0) || (paramInt1 >= this.nZr.size()) || (paramInt2 < 0) || (paramInt2 >= this.nZr.size()))
    {
      AppMethodBeat.o(49843);
      return false;
    }
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      while (i < paramInt2)
      {
        Collections.swap(this.nZr, i, i + 1);
        i += 1;
      }
    }
    int i = paramInt1;
    while (i > paramInt2)
    {
      Collections.swap(this.nZr, i, i - 1);
      i -= 1;
    }
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", new Object[] { Integer.valueOf(this.nZr.hashCode()) });
    paramRecyclerView.getAdapter().ar(paramInt1, paramInt2);
    if (this.opM != null)
    {
      this.endPos = paramInt2;
      this.opM.i(this.opL, paramInt2);
    }
    AppMethodBeat.o(49843);
    return true;
  }
  
  public final View g(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49841);
    paramRecyclerView = this.cIL;
    paramT.aus.setVisibility(4);
    View localView = this.opC.Q(paramT);
    localView.setAlpha(1.0F);
    localView.setScaleX(1.0F);
    localView.setScaleY(1.0F);
    localView.setVisibility(0);
    this.ooN = localView;
    paramRecyclerView.addView(localView);
    Log.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + paramT.lR());
    if ((paramT.lR() < 0) && (this.ooN != null))
    {
      this.cIL.removeView(this.ooN);
      this.ooN = null;
      AppMethodBeat.o(49841);
      return null;
    }
    if ((this.opM != null) && (this.nZr.size() > paramT.lR()))
    {
      this.opL = this.opM.cS(this.nZr.get(paramT.lR()));
      this.bNu = paramT.lR();
      this.endPos = this.bNu;
    }
    paramRecyclerView = this.ooN;
    AppMethodBeat.o(49841);
    return paramRecyclerView;
  }
  
  public final void h(RecyclerView paramRecyclerView) {}
  
  public final void h(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49847);
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", new Object[] { Integer.valueOf(paramT.lR()) });
    if ((paramT instanceof d)) {
      Log.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", new Object[] { ((d)paramT).titleTv.getText() });
    }
    this.nZr.remove(paramT.lR());
    Log.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", new Object[] { Integer.valueOf(this.nZr.hashCode()) });
    paramRecyclerView.getAdapter().ck(paramT.lR());
    if (this.opC != null) {
      this.opC.cT(this.opL);
    }
    AppMethodBeat.o(49847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.e
 * JD-Core Version:    0.7.0.1
 */