package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
  extends y
{
  private static TimeInterpolator afY;
  private ArrayList<RecyclerView.v> afZ;
  private ArrayList<RecyclerView.v> aga;
  private ArrayList<b> agb;
  private ArrayList<a> agc;
  ArrayList<ArrayList<RecyclerView.v>> agd;
  ArrayList<ArrayList<b>> age;
  ArrayList<ArrayList<a>> agf;
  ArrayList<RecyclerView.v> agg;
  ArrayList<RecyclerView.v> agh;
  ArrayList<RecyclerView.v> agi;
  ArrayList<RecyclerView.v> agj;
  
  public g()
  {
    AppMethodBeat.i(260953);
    this.afZ = new ArrayList();
    this.aga = new ArrayList();
    this.agb = new ArrayList();
    this.agc = new ArrayList();
    this.agd = new ArrayList();
    this.age = new ArrayList();
    this.agf = new ArrayList();
    this.agg = new ArrayList();
    this.agh = new ArrayList();
    this.agi = new ArrayList();
    this.agj = new ArrayList();
    AppMethodBeat.o(260953);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(260978);
    if (parama.agw != null) {
      a(parama, parama.agw);
    }
    if (parama.agx != null) {
      a(parama, parama.agx);
    }
    AppMethodBeat.o(260978);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(260975);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.agw == null) && (locala.agx == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(260975);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(260981);
    if (parama.agx == paramv) {
      parama.agx = null;
    }
    for (;;)
    {
      paramv.amk.setAlpha(1.0F);
      paramv.amk.setTranslationX(0.0F);
      paramv.amk.setTranslationY(0.0F);
      q(paramv);
      AppMethodBeat.o(260981);
      return true;
      if (parama.agw != paramv) {
        break;
      }
      parama.agw = null;
    }
    AppMethodBeat.o(260981);
    return false;
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(260989);
    if (afY == null) {
      afY = new ValueAnimator().getInterpolator();
    }
    paramv.amk.animate().setInterpolator(afY);
    c(paramv);
    AppMethodBeat.o(260989);
  }
  
  private static void l(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(261001);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).amk.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(261001);
  }
  
  public boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(260962);
    d(paramv);
    this.afZ.add(paramv);
    AppMethodBeat.o(260962);
    return true;
  }
  
  public boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(260968);
    View localView = paramv.amk;
    paramInt1 += (int)paramv.amk.getTranslationX();
    paramInt2 += (int)paramv.amk.getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      A(paramv);
      AppMethodBeat.o(260968);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.agb.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(260968);
    return true;
  }
  
  public boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(260971);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(260971);
      return bool;
    }
    float f1 = paramv1.amk.getTranslationX();
    float f2 = paramv1.amk.getTranslationY();
    float f3 = paramv1.amk.getAlpha();
    d(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.amk.setTranslationX(f1);
    paramv1.amk.setTranslationY(f2);
    paramv1.amk.setAlpha(f3);
    if (paramv2 != null)
    {
      d(paramv2);
      paramv2.amk.setTranslationX(-i);
      paramv2.amk.setTranslationY(-j);
      paramv2.amk.setAlpha(0.0F);
    }
    this.agc.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(260971);
    return true;
  }
  
  public boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(261002);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(261002);
      return true;
    }
    AppMethodBeat.o(261002);
    return false;
  }
  
  public boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(260965);
    d(paramv);
    paramv.amk.setAlpha(0.0F);
    this.aga.add(paramv);
    AppMethodBeat.o(260965);
    return true;
  }
  
  public void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(260987);
    View localView = paramv.amk;
    localView.animate().cancel();
    int i = this.agb.size() - 1;
    while (i >= 0)
    {
      if (((b)this.agb.get(i)).agC == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        A(paramv);
        this.agb.remove(i);
      }
      i -= 1;
    }
    a(this.agc, paramv);
    if (this.afZ.remove(paramv))
    {
      localView.setAlpha(1.0F);
      z(paramv);
    }
    if (this.aga.remove(paramv))
    {
      localView.setAlpha(1.0F);
      q(paramv);
    }
    i = this.agf.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.agf.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.agf.remove(i);
      }
      i -= 1;
    }
    i = this.age.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.age.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((b)localArrayList.get(j)).agC != paramv) {
            break label298;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          A(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.age.remove(i);
          }
        }
        i -= 1;
        break;
        label298:
        j -= 1;
      }
    }
    i = this.agd.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.agd.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        q(paramv);
        if (localArrayList.isEmpty()) {
          this.agd.remove(i);
        }
      }
      i -= 1;
    }
    this.agi.remove(paramv);
    this.agg.remove(paramv);
    this.agj.remove(paramv);
    this.agh.remove(paramv);
    km();
    AppMethodBeat.o(260987);
  }
  
  public boolean isRunning()
  {
    AppMethodBeat.i(260992);
    if ((!this.aga.isEmpty()) || (!this.agc.isEmpty()) || (!this.agb.isEmpty()) || (!this.afZ.isEmpty()) || (!this.agh.isEmpty()) || (!this.agi.isEmpty()) || (!this.agg.isEmpty()) || (!this.agj.isEmpty()) || (!this.age.isEmpty()) || (!this.agd.isEmpty()) || (!this.agf.isEmpty()))
    {
      AppMethodBeat.o(260992);
      return true;
    }
    AppMethodBeat.o(260992);
    return false;
  }
  
  public void kl()
  {
    AppMethodBeat.i(260958);
    int i;
    int j;
    label29:
    int k;
    if (!this.afZ.isEmpty())
    {
      i = 1;
      if (this.agb.isEmpty()) {
        break label82;
      }
      j = 1;
      if (this.agc.isEmpty()) {
        break label87;
      }
      k = 1;
      label41:
      if (this.aga.isEmpty()) {
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
      AppMethodBeat.o(260958);
      return;
      i = 0;
      break;
      j = 0;
      break label29;
      k = 0;
      break label41;
    }
    label98:
    Object localObject1 = this.afZ.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      final View localView = ((RecyclerView.v)localObject2).amk;
      final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.agi.add(localObject2);
      localViewPropertyAnimator.setDuration(lK()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(260899);
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          g.this.z(this.ago);
          g.this.agi.remove(this.ago);
          g.this.km();
          AppMethodBeat.o(260899);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(260897);
          g.this.F(this.ago);
          AppMethodBeat.o(260897);
        }
      }).start();
    }
    this.afZ.clear();
    label356:
    long l1;
    label431:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.agb);
      this.age.add(localObject1);
      this.agb.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(260866);
          Iterator localIterator = this.agk.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (g.b)localIterator.next();
            g localg = g.this;
            RecyclerView.v localv = ((g.b)localObject).agC;
            int k = ((g.b)localObject).agy;
            int i = ((g.b)localObject).agz;
            int m = ((g.b)localObject).agA;
            int j = ((g.b)localObject).agB;
            localObject = localv.amk;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            localg.agh.add(localv);
            localViewPropertyAnimator.setDuration(localg.ali).setListener(new g.6(localg, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.agk.clear();
          g.this.age.remove(this.agk);
          AppMethodBeat.o(260866);
        }
      };
      if (i != 0) {
        w.a(((b)((ArrayList)localObject1).get(0)).agC.amk, (Runnable)localObject2, lK());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.agc);
        this.agf.add(localObject1);
        this.agc.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(260878);
            Iterator localIterator = this.agm.iterator();
            if (localIterator.hasNext())
            {
              g.a locala = (g.a)localIterator.next();
              g localg = g.this;
              Object localObject1 = locala.agw;
              if (localObject1 == null)
              {
                localObject1 = null;
                label51:
                localObject2 = locala.agx;
                if (localObject2 == null) {
                  break label234;
                }
              }
              label234:
              for (Object localObject2 = ((RecyclerView.v)localObject2).amk;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localg.alj);
                  localg.agj.add(locala.agw);
                  localViewPropertyAnimator.translationX(locala.agA - locala.agy);
                  localViewPropertyAnimator.translationY(locala.agB - locala.agz);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new g.7(localg, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localg.agj.add(locala.agx);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localg.alj).alpha(1.0F).setListener(new g.8(localg, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).amk;
                break label51;
              }
            }
            this.agm.clear();
            g.this.agf.remove(this.agm);
            AppMethodBeat.o(260878);
          }
        };
        if (i == 0) {
          break label498;
        }
        w.a(((a)((ArrayList)localObject1).get(0)).agw.amk, (Runnable)localObject2, lK());
      }
      if (m == 0) {
        break label533;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.aga);
      this.agd.add(localObject1);
      this.aga.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(260889);
          Iterator localIterator = this.agn.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            g localg = g.this;
            View localView = localv.amk;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localg.agg.add(localv);
            localViewPropertyAnimator.alpha(1.0F).setDuration(localg.lJ()).setListener(new g.5(localg, localv, localView, localViewPropertyAnimator)).start();
          }
          this.agn.clear();
          g.this.agd.remove(this.agn);
          AppMethodBeat.o(260889);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label526;
      }
      if (i == 0) {
        break label508;
      }
      l1 = lK();
      if (j == 0) {
        break label514;
      }
      l2 = this.ali;
      label441:
      if (k == 0) {
        break label520;
      }
    }
    label514:
    label520:
    for (long l3 = this.alj;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      w.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).amk, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(260958);
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
    AppMethodBeat.o(260958);
  }
  
  final void km()
  {
    AppMethodBeat.i(260994);
    if (!isRunning()) {
      lM();
    }
    AppMethodBeat.o(260994);
  }
  
  public final void kn()
  {
    AppMethodBeat.i(261000);
    int i = this.agb.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.agb.get(i);
      localObject2 = ((b)localObject1).agC.amk;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      A(((b)localObject1).agC);
      this.agb.remove(i);
      i -= 1;
    }
    i = this.afZ.size() - 1;
    while (i >= 0)
    {
      z((RecyclerView.v)this.afZ.get(i));
      this.afZ.remove(i);
      i -= 1;
    }
    i = this.aga.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.aga.get(i);
      ((RecyclerView.v)localObject1).amk.setAlpha(1.0F);
      q((RecyclerView.v)localObject1);
      this.aga.remove(i);
      i -= 1;
    }
    i = this.agc.size() - 1;
    while (i >= 0)
    {
      a((a)this.agc.get(i));
      i -= 1;
    }
    this.agc.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(261000);
      return;
    }
    i = this.age.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.age.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).agC.amk;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        A(((b)localObject2).agC);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.age.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.agd.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.agd.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).amk.setAlpha(1.0F);
        q((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.agd.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.agf.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.agf.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.agf.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    l(this.agi);
    l(this.agh);
    l(this.agg);
    l(this.agj);
    lM();
    AppMethodBeat.o(261000);
  }
  
  static final class a
  {
    public int agA;
    public int agB;
    public RecyclerView.v agw;
    public RecyclerView.v agx;
    public int agy;
    public int agz;
    
    private a(RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      this.agw = paramv1;
      this.agx = paramv2;
    }
    
    a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramv1, paramv2);
      this.agy = paramInt1;
      this.agz = paramInt2;
      this.agA = paramInt3;
      this.agB = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(260936);
      String str = "ChangeInfo{oldHolder=" + this.agw + ", newHolder=" + this.agx + ", fromX=" + this.agy + ", fromY=" + this.agz + ", toX=" + this.agA + ", toY=" + this.agB + '}';
      AppMethodBeat.o(260936);
      return str;
    }
  }
  
  static final class b
  {
    public int agA;
    public int agB;
    public RecyclerView.v agC;
    public int agy;
    public int agz;
    
    b(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.agC = paramv;
      this.agy = paramInt1;
      this.agz = paramInt2;
      this.agA = paramInt3;
      this.agB = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.recyclerview.widget.g
 * JD-Core Version:    0.7.0.1
 */