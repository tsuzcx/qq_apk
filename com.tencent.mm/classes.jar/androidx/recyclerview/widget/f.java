package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
  extends w
{
  private static TimeInterpolator bUE;
  private ArrayList<RecyclerView.v> bUF;
  private ArrayList<RecyclerView.v> bUG;
  private ArrayList<b> bUH;
  private ArrayList<a> bUI;
  ArrayList<ArrayList<RecyclerView.v>> bUJ;
  ArrayList<ArrayList<b>> bUK;
  ArrayList<ArrayList<a>> bUL;
  ArrayList<RecyclerView.v> bUM;
  ArrayList<RecyclerView.v> bUN;
  ArrayList<RecyclerView.v> bUO;
  ArrayList<RecyclerView.v> bUP;
  
  public f()
  {
    AppMethodBeat.i(194804);
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
    AppMethodBeat.o(194804);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(194832);
    if (parama.bVc != null) {
      a(parama, parama.bVc);
    }
    if (parama.bVd != null) {
      a(parama, parama.bVd);
    }
    AppMethodBeat.o(194832);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(194819);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.bVc == null) && (locala.bVd == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(194819);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(194847);
    if (parama.bVd == paramv) {
      parama.bVd = null;
    }
    for (;;)
    {
      paramv.caK.setAlpha(1.0F);
      paramv.caK.setTranslationX(0.0F);
      paramv.caK.setTranslationY(0.0F);
      r(paramv);
      AppMethodBeat.o(194847);
      return true;
      if (parama.bVc != paramv) {
        break;
      }
      parama.bVc = null;
    }
    AppMethodBeat.o(194847);
    return false;
  }
  
  private static void ae(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(194875);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).caK.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(194875);
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194861);
    if (bUE == null) {
      bUE = new ValueAnimator().getInterpolator();
    }
    paramv.caK.animate().setInterpolator(bUE);
    c(paramv);
    AppMethodBeat.o(194861);
  }
  
  public void IW()
  {
    AppMethodBeat.i(194894);
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
      AppMethodBeat.o(194894);
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
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      final View localView = ((RecyclerView.v)localObject2).caK;
      final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.bUO.add(localObject2);
      localViewPropertyAnimator.setDuration(Ku()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(195265);
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          f.this.A(this.bUU);
          f.this.bUO.remove(this.bUU);
          f.this.IX();
          AppMethodBeat.o(195265);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(195259);
          f.this.C(this.bUU);
          AppMethodBeat.o(195259);
        }
      }).start();
    }
    this.bUF.clear();
    label356:
    long l1;
    label431:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUH);
      this.bUK.add(localObject1);
      this.bUH.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195276);
          Iterator localIterator = this.bUQ.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (f.b)localIterator.next();
            f localf = f.this;
            RecyclerView.v localv = ((f.b)localObject).bVi;
            int k = ((f.b)localObject).bVe;
            int i = ((f.b)localObject).bVf;
            int m = ((f.b)localObject).bVg;
            int j = ((f.b)localObject).bVh;
            localObject = localv.caK;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            localf.bUN.add(localv);
            localViewPropertyAnimator.setDuration(localf.bZK).setListener(new f.6(localf, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.bUQ.clear();
          f.this.bUK.remove(this.bUQ);
          AppMethodBeat.o(195276);
        }
      };
      if (i != 0) {
        z.a(((b)((ArrayList)localObject1).get(0)).bVi.caK, (Runnable)localObject2, Ku());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.bUI);
        this.bUL.add(localObject1);
        this.bUI.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195266);
            Iterator localIterator = this.bUS.iterator();
            if (localIterator.hasNext())
            {
              f.a locala = (f.a)localIterator.next();
              f localf = f.this;
              Object localObject1 = locala.bVc;
              if (localObject1 == null)
              {
                localObject1 = null;
                label51:
                localObject2 = locala.bVd;
                if (localObject2 == null) {
                  break label234;
                }
              }
              label234:
              for (Object localObject2 = ((RecyclerView.v)localObject2).caK;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localf.bZL);
                  localf.bUP.add(locala.bVc);
                  localViewPropertyAnimator.translationX(locala.bVg - locala.bVe);
                  localViewPropertyAnimator.translationY(locala.bVh - locala.bVf);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new f.7(localf, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localf.bUP.add(locala.bVd);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localf.bZL).alpha(1.0F).setListener(new f.8(localf, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).caK;
                break label51;
              }
            }
            this.bUS.clear();
            f.this.bUL.remove(this.bUS);
            AppMethodBeat.o(195266);
          }
        };
        if (i == 0) {
          break label498;
        }
        z.a(((a)((ArrayList)localObject1).get(0)).bVc.caK, (Runnable)localObject2, Ku());
      }
      if (m == 0) {
        break label533;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUG);
      this.bUJ.add(localObject1);
      this.bUG.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195264);
          Iterator localIterator = this.bUT.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            f localf = f.this;
            View localView = localv.caK;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localf.bUM.add(localv);
            localViewPropertyAnimator.alpha(1.0F).setDuration(localf.Kt()).setListener(new f.5(localf, localv, localView, localViewPropertyAnimator)).start();
          }
          this.bUT.clear();
          f.this.bUJ.remove(this.bUT);
          AppMethodBeat.o(195264);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label526;
      }
      if (i == 0) {
        break label508;
      }
      l1 = Ku();
      if (j == 0) {
        break label514;
      }
      l2 = this.bZK;
      label441:
      if (k == 0) {
        break label520;
      }
    }
    label514:
    label520:
    for (long l3 = this.bZL;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      z.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).caK, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(194894);
      return;
      ((Runnable)localObject2).run();
      break;
      label498:
      ((Runnable)localObject2).run();
      break label356;
      label508:
      l1 = 0L;
      break label431;
      l2 = 0L;
      break label441;
    }
    label526:
    ((Runnable)localObject2).run();
    label533:
    AppMethodBeat.o(194894);
  }
  
  final void IX()
  {
    AppMethodBeat.i(194991);
    if (!isRunning()) {
      Kv();
    }
    AppMethodBeat.o(194991);
  }
  
  public final void IY()
  {
    AppMethodBeat.i(195010);
    int i = this.bUH.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.bUH.get(i);
      localObject2 = ((b)localObject1).bVi.caK;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      B(((b)localObject1).bVi);
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
      a((a)this.bUI.get(i));
      i -= 1;
    }
    this.bUI.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(195010);
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
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).bVi.caK;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        B(((b)localObject2).bVi);
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
        a((a)((ArrayList)localObject1).get(j));
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
    AppMethodBeat.o(195010);
  }
  
  public boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194905);
    d(paramv);
    this.bUF.add(paramv);
    AppMethodBeat.o(194905);
    return true;
  }
  
  public boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194936);
    View localView = paramv.caK;
    paramInt1 += (int)paramv.caK.getTranslationX();
    paramInt2 += (int)paramv.caK.getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      B(paramv);
      AppMethodBeat.o(194936);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.bUH.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(194936);
    return true;
  }
  
  public boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194949);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(194949);
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
    this.bUI.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(194949);
    return true;
  }
  
  public boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(195020);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(195020);
      return true;
    }
    AppMethodBeat.o(195020);
    return false;
  }
  
  public boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194917);
    d(paramv);
    paramv.caK.setAlpha(0.0F);
    this.bUG.add(paramv);
    AppMethodBeat.o(194917);
    return true;
  }
  
  public void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194968);
    View localView = paramv.caK;
    localView.animate().cancel();
    int i = this.bUH.size() - 1;
    while (i >= 0)
    {
      if (((b)this.bUH.get(i)).bVi == paramv)
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
          if (((b)localArrayList.get(j)).bVi != paramv) {
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
    AppMethodBeat.o(194968);
  }
  
  public boolean isRunning()
  {
    AppMethodBeat.i(194980);
    if ((!this.bUG.isEmpty()) || (!this.bUI.isEmpty()) || (!this.bUH.isEmpty()) || (!this.bUF.isEmpty()) || (!this.bUN.isEmpty()) || (!this.bUO.isEmpty()) || (!this.bUM.isEmpty()) || (!this.bUP.isEmpty()) || (!this.bUK.isEmpty()) || (!this.bUJ.isEmpty()) || (!this.bUL.isEmpty()))
    {
      AppMethodBeat.o(194980);
      return true;
    }
    AppMethodBeat.o(194980);
    return false;
  }
  
  static final class a
  {
    public RecyclerView.v bVc;
    public RecyclerView.v bVd;
    public int bVe;
    public int bVf;
    public int bVg;
    public int bVh;
    
    private a(RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      this.bVc = paramv1;
      this.bVd = paramv2;
    }
    
    a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramv1, paramv2);
      this.bVe = paramInt1;
      this.bVf = paramInt2;
      this.bVg = paramInt3;
      this.bVh = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195232);
      String str = "ChangeInfo{oldHolder=" + this.bVc + ", newHolder=" + this.bVd + ", fromX=" + this.bVe + ", fromY=" + this.bVf + ", toX=" + this.bVg + ", toY=" + this.bVh + '}';
      AppMethodBeat.o(195232);
      return str;
    }
  }
  
  static final class b
  {
    public int bVe;
    public int bVf;
    public int bVg;
    public int bVh;
    public RecyclerView.v bVi;
    
    b(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.bVi = paramv;
      this.bVe = paramInt1;
      this.bVf = paramInt2;
      this.bVg = paramInt3;
      this.bVh = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.f
 * JD-Core Version:    0.7.0.1
 */