package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.g.z;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends w
{
  private static TimeInterpolator bUE;
  protected ArrayList<RecyclerView.v> bUF;
  protected ArrayList<RecyclerView.v> bUG;
  private ArrayList<a.b> bUH;
  private ArrayList<a.a> bUI;
  ArrayList<ArrayList<RecyclerView.v>> bUJ;
  ArrayList<ArrayList<a.b>> bUK;
  ArrayList<ArrayList<a.a>> bUL;
  ArrayList<RecyclerView.v> bUM;
  ArrayList<RecyclerView.v> bUN;
  ArrayList<RecyclerView.v> bUO;
  protected ArrayList<RecyclerView.v> bUP;
  
  public a()
  {
    AppMethodBeat.i(168662);
    this.bUF = new ArrayList();
    this.bUG = new ArrayList();
    this.bUH = new ArrayList();
    this.bUI = new ArrayList();
    this.bUJ = new ArrayList();
    this.bUK = new ArrayList();
    this.bUL = new ArrayList();
    this.bUM = new ArrayList();
    this.bUN = new ArrayList();
    this.bUO = new ArrayList();
    this.bUP = new ArrayList();
    AppMethodBeat.o(168662);
  }
  
  private void a(List<a.a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(345945);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a.a locala = (a.a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.bVc == null) && (locala.bVd == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(345945);
  }
  
  private boolean a(a.a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(345965);
    if (parama.bVd == paramv) {
      parama.bVd = null;
    }
    for (;;)
    {
      paramv.caK.setAlpha(1.0F);
      paramv.caK.setTranslationX(0.0F);
      paramv.caK.setTranslationY(0.0F);
      r(paramv);
      AppMethodBeat.o(345965);
      return true;
      if (parama.bVc != paramv) {
        break;
      }
      parama.bVc = null;
    }
    AppMethodBeat.o(345965);
    return false;
  }
  
  private static void ae(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(168680);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).caK.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(168680);
  }
  
  private void b(a.a parama)
  {
    AppMethodBeat.i(168673);
    if (parama.bVc != null) {
      a(parama, parama.bVc);
    }
    if (parama.bVd != null) {
      a(parama, parama.bVd);
    }
    AppMethodBeat.o(168673);
  }
  
  public final void IW()
  {
    AppMethodBeat.i(168664);
    int i;
    int j;
    label29:
    int k;
    if (!this.bUF.isEmpty())
    {
      i = 1;
      if (this.bUH.isEmpty()) {
        break label82;
      }
      j = 1;
      if (this.bUI.isEmpty()) {
        break label87;
      }
      k = 1;
      label41:
      if (this.bUG.isEmpty()) {
        break label92;
      }
    }
    label82:
    label87:
    label92:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label98;
      }
      AppMethodBeat.o(168664);
      return;
      i = 0;
      break;
      j = 0;
      break label29;
      k = 0;
      break label41;
    }
    label98:
    Object localObject1 = this.bUF.iterator();
    while (((Iterator)localObject1).hasNext()) {
      W((RecyclerView.v)((Iterator)localObject1).next());
    }
    this.bUF.clear();
    Object localObject2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUH);
      this.bUK.add(localObject1);
      this.bUH.clear();
      localObject2 = new a.1(this, (ArrayList)localObject1);
      if (i != 0) {
        z.a(((a.b)((ArrayList)localObject1).get(0)).bVi.caK, (Runnable)localObject2, Ku());
      }
    }
    else if (k != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUI);
      this.bUL.add(localObject1);
      this.bUI.clear();
      localObject2 = new a.2(this, (ArrayList)localObject1);
      if (i == 0) {
        break label403;
      }
      z.a(((a.a)((ArrayList)localObject1).get(0)).bVc.caK, (Runnable)localObject2, Ku());
    }
    for (;;)
    {
      if (m != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.bUG);
        this.bUJ.add(localObject1);
        this.bUG.clear();
        localObject2 = new a.3(this, (ArrayList)localObject1);
        if ((i != 0) || (j != 0) || (k != 0))
        {
          z.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).caK, (Runnable)localObject2, flM());
          AppMethodBeat.o(168664);
          return;
          ((Runnable)localObject2).run();
          break;
          label403:
          ((Runnable)localObject2).run();
          continue;
        }
        ((Runnable)localObject2).run();
      }
    }
    AppMethodBeat.o(168664);
  }
  
  final void IX()
  {
    AppMethodBeat.i(168678);
    if (!isRunning()) {
      Kv();
    }
    AppMethodBeat.o(168678);
  }
  
  public final void IY()
  {
    AppMethodBeat.i(168679);
    int i = this.bUH.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (a.b)this.bUH.get(i);
      localObject2 = ((a.b)localObject1).bVi.caK;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      B(((a.b)localObject1).bVi);
      this.bUH.remove(i);
      i -= 1;
    }
    i = this.bUF.size() - 1;
    while (i >= 0)
    {
      A((RecyclerView.v)this.bUF.get(i));
      this.bUF.remove(i);
      i -= 1;
    }
    i = this.bUG.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.bUG.get(i);
      ((RecyclerView.v)localObject1).caK.setAlpha(1.0F);
      r((RecyclerView.v)localObject1);
      this.bUG.remove(i);
      i -= 1;
    }
    i = this.bUI.size() - 1;
    while (i >= 0)
    {
      b((a.a)this.bUI.get(i));
      i -= 1;
    }
    this.bUI.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(168679);
      return;
    }
    i = this.bUK.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUK.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (a.b)((ArrayList)localObject1).get(j);
        View localView = ((a.b)localObject2).bVi.caK;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        B(((a.b)localObject2).bVi);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUK.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.bUJ.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUJ.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).caK.setAlpha(1.0F);
        r((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUJ.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.bUL.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUL.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        b((a.a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUL.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    ae(this.bUO);
    ae(this.bUN);
    ae(this.bUM);
    ae(this.bUP);
    Kv();
    AppMethodBeat.o(168679);
  }
  
  protected void W(RecyclerView.v paramv)
  {
    AppMethodBeat.i(345998);
    View localView = paramv.caK;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.bUO.add(paramv);
    localViewPropertyAnimator.setDuration(Ku()).alpha(0.0F).setListener(new a.4(this, paramv, localViewPropertyAnimator, localView)).start();
    AppMethodBeat.o(345998);
  }
  
  void X(RecyclerView.v paramv)
  {
    AppMethodBeat.i(346011);
    View localView = paramv.caK;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.bUM.add(paramv);
    localViewPropertyAnimator.alpha(1.0F).setDuration(Kt()).setListener(new a.5(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(346011);
  }
  
  protected final void a(a.a parama)
  {
    View localView = null;
    AppMethodBeat.i(168671);
    Object localObject1 = parama.bVc;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((RecyclerView.v)localObject1).caK)
    {
      Object localObject2 = parama.bVd;
      if (localObject2 != null) {
        localView = ((RecyclerView.v)localObject2).caK;
      }
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).animate().setDuration(this.bZL);
        this.bUP.add(parama.bVc);
        ((ViewPropertyAnimator)localObject2).translationX(parama.bVg - parama.bVe);
        ((ViewPropertyAnimator)localObject2).translationY(parama.bVh - parama.bVf);
        ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new a.7(this, parama, (ViewPropertyAnimator)localObject2, (View)localObject1)).start();
      }
      if (localView != null)
      {
        localObject1 = localView.animate();
        this.bUP.add(parama.bVd);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(this.bZL).alpha(1.0F).setListener(new a.8(this, parama, (ViewPropertyAnimator)localObject1, localView)).start();
      }
      AppMethodBeat.o(168671);
      return;
    }
  }
  
  public boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(345994);
    d(paramv);
    this.bUF.add(paramv);
    AppMethodBeat.o(345994);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(346016);
    View localView = paramv.caK;
    paramInt1 += (int)paramv.caK.getTranslationX();
    paramInt2 += (int)paramv.caK.getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      B(paramv);
      AppMethodBeat.o(346016);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.bUH.add(new a.b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(346016);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(346025);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(346025);
      return bool;
    }
    float f1 = paramv1.caK.getTranslationX();
    float f2 = paramv1.caK.getTranslationY();
    float f3 = paramv1.caK.getAlpha();
    d(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.caK.setTranslationX(f1);
    paramv1.caK.setTranslationY(f2);
    paramv1.caK.setAlpha(f3);
    if (paramv2 != null)
    {
      d(paramv2);
      paramv2.caK.setTranslationX(-i);
      paramv2.caK.setTranslationY(-j);
      paramv2.caK.setAlpha(0.0F);
    }
    this.bUI.add(new a.a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(346025);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(346063);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(346063);
      return true;
    }
    AppMethodBeat.o(346063);
    return false;
  }
  
  public boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(346004);
    d(paramv);
    paramv.caK.setAlpha(0.0F);
    this.bUG.add(paramv);
    AppMethodBeat.o(346004);
    return true;
  }
  
  public final void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(346038);
    View localView = paramv.caK;
    localView.animate().cancel();
    int i = this.bUH.size() - 1;
    while (i >= 0)
    {
      if (((a.b)this.bUH.get(i)).bVi == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        B(paramv);
        this.bUH.remove(i);
      }
      i -= 1;
    }
    a(this.bUI, paramv);
    if (this.bUF.remove(paramv))
    {
      localView.setAlpha(1.0F);
      A(paramv);
    }
    if (this.bUG.remove(paramv))
    {
      localView.setAlpha(1.0F);
      r(paramv);
    }
    i = this.bUL.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.bUL.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.bUL.remove(i);
      }
      i -= 1;
    }
    i = this.bUK.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.bUK.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((a.b)localArrayList.get(j)).bVi != paramv) {
            break label299;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          B(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.bUK.remove(i);
          }
        }
        i -= 1;
        break;
        label299:
        j -= 1;
      }
    }
    i = this.bUJ.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.bUJ.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        r(paramv);
        if (localArrayList.isEmpty()) {
          this.bUJ.remove(i);
        }
      }
      i -= 1;
    }
    this.bUO.remove(paramv);
    this.bUM.remove(paramv);
    this.bUP.remove(paramv);
    this.bUN.remove(paramv);
    IX();
    AppMethodBeat.o(346038);
  }
  
  protected final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(346044);
    if (bUE == null) {
      bUE = new ValueAnimator().getInterpolator();
    }
    paramv.caK.animate().setInterpolator(bUE);
    c(paramv);
    AppMethodBeat.o(346044);
  }
  
  protected long flM()
  {
    AppMethodBeat.i(168663);
    long l = Ku();
    AppMethodBeat.o(168663);
    return l;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(168677);
    if ((!this.bUG.isEmpty()) || (!this.bUI.isEmpty()) || (!this.bUH.isEmpty()) || (!this.bUF.isEmpty()) || (!this.bUN.isEmpty()) || (!this.bUO.isEmpty()) || (!this.bUM.isEmpty()) || (!this.bUP.isEmpty()) || (!this.bUK.isEmpty()) || (!this.bUJ.isEmpty()) || (!this.bUL.isEmpty()))
    {
      AppMethodBeat.o(168677);
      return true;
    }
    AppMethodBeat.o(168677);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a
 * JD-Core Version:    0.7.0.1
 */