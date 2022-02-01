package androidx.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.b.a;
import androidx.b.d;
import androidx.core.content.a.g;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Transition
  implements Cloneable
{
  private static final int[] cgc = { 2, 1, 3, 4 };
  private static final PathMotion cgd = new PathMotion()
  {
    public final Path getPath(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      AppMethodBeat.i(201456);
      Path localPath = new Path();
      localPath.moveTo(paramAnonymousFloat1, paramAnonymousFloat2);
      localPath.lineTo(paramAnonymousFloat3, paramAnonymousFloat4);
      AppMethodBeat.o(201456);
      return localPath;
    }
  };
  private static ThreadLocal<a<Animator, a>> cgy = new ThreadLocal();
  private boolean bCD = false;
  boolean cgA = false;
  ArrayList<Animator> cgB = new ArrayList();
  private int cgC = 0;
  private boolean cgD = false;
  u cgE;
  private c cgF;
  private a<String, String> cgG;
  private PathMotion cgH = cgd;
  private long cge = -1L;
  private TimeInterpolator cgf = null;
  ArrayList<Integer> cgg = new ArrayList();
  ArrayList<View> cgh = new ArrayList();
  ArrayList<String> cgj = null;
  ArrayList<Class> cgk = null;
  private ArrayList<Integer> cgl = null;
  private ArrayList<View> cgm = null;
  private ArrayList<Class> cgn = null;
  private ArrayList<String> cgo = null;
  private ArrayList<Integer> cgp = null;
  private ArrayList<View> cgq = null;
  private ArrayList<Class> cgr = null;
  private x cgs = new x();
  private x cgt = new x();
  TransitionSet cgu = null;
  private int[] cgv = cgc;
  private ArrayList<w> cgw;
  private ArrayList<w> cgx;
  private ViewGroup cgz = null;
  private ArrayList<Animator> lB = new ArrayList();
  long mDuration = -1L;
  private ArrayList<d> mListeners = null;
  private String mName = getClass().getName();
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, q.cfT);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = g.a(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      bB(l);
    }
    l = g.a(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      bC(l);
    }
    int i = g.b(localTypedArray, paramAttributeSet, "interpolator", 0);
    if (i > 0) {
      a(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = g.c(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      p(aS(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private static a<Animator, a> LT()
  {
    a locala2 = (a)cgy.get();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      cgy.set(locala1);
    }
    return locala1;
  }
  
  private static void a(x paramx, View paramView, w paramw)
  {
    paramx.chh.put(paramView, paramw);
    int i = paramView.getId();
    if (i >= 0)
    {
      if (paramx.chi.indexOfKey(i) >= 0) {
        paramx.chi.put(i, null);
      }
    }
    else
    {
      paramw = z.ai(paramView);
      if (paramw != null)
      {
        if (!paramx.chk.containsKey(paramw)) {
          break label168;
        }
        paramx.chk.put(paramw, null);
      }
    }
    long l;
    for (;;)
    {
      if ((paramView.getParent() instanceof ListView))
      {
        paramw = (ListView)paramView.getParent();
        if (paramw.getAdapter().hasStableIds())
        {
          l = paramw.getItemIdAtPosition(paramw.getPositionForView(paramView));
          if (paramx.chj.j(l) < 0) {
            break label181;
          }
          paramView = (View)paramx.chj.get(l, null);
          if (paramView != null)
          {
            z.b(paramView, false);
            paramx.chj.a(l, null);
          }
        }
      }
      return;
      paramx.chi.put(i, paramView);
      break;
      label168:
      paramx.chk.put(paramw, paramView);
    }
    label181:
    z.b(paramView, true);
    paramx.chj.a(l, paramView);
  }
  
  private void a(x paramx1, x paramx2)
  {
    a locala2 = new a(paramx1.chh);
    a locala1 = new a(paramx2.chh);
    int i = 0;
    if (i < this.cgv.length)
    {
      switch (this.cgv[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int j = locala2.size() - 1;
        while (j >= 0)
        {
          localObject1 = (View)locala2.bn(j);
          if ((localObject1 != null) && (bY((View)localObject1)))
          {
            localObject1 = (w)locala1.remove(localObject1);
            if ((localObject1 != null) && (((w)localObject1).view != null) && (bY(((w)localObject1).view)))
            {
              localObject2 = (w)locala2.removeAt(j);
              this.cgw.add(localObject2);
              this.cgx.add(localObject1);
            }
          }
          j -= 1;
        }
        Object localObject1 = paramx1.chk;
        Object localObject2 = paramx2.chk;
        int k = ((a)localObject1).size();
        j = 0;
        View localView1;
        View localView2;
        w localw1;
        w localw2;
        while (j < k)
        {
          localView1 = (View)((a)localObject1).bl(j);
          if ((localView1 != null) && (bY(localView1)))
          {
            localView2 = (View)((a)localObject2).get(((a)localObject1).bn(j));
            if ((localView2 != null) && (bY(localView2)))
            {
              localw1 = (w)locala2.get(localView1);
              localw2 = (w)locala1.get(localView2);
              if ((localw1 != null) && (localw2 != null))
              {
                this.cgw.add(localw1);
                this.cgx.add(localw2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramx1.chi;
        localObject2 = paramx2.chi;
        k = ((SparseArray)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((SparseArray)localObject1).valueAt(j);
          if ((localView1 != null) && (bY(localView1)))
          {
            localView2 = (View)((SparseArray)localObject2).get(((SparseArray)localObject1).keyAt(j));
            if ((localView2 != null) && (bY(localView2)))
            {
              localw1 = (w)locala2.get(localView1);
              localw2 = (w)locala1.get(localView2);
              if ((localw1 != null) && (localw2 != null))
              {
                this.cgw.add(localw1);
                this.cgx.add(localw2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramx1.chj;
        localObject2 = paramx2.chj;
        k = ((d)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((d)localObject1).bl(j);
          if ((localView1 != null) && (bY(localView1)))
          {
            localView2 = (View)((d)localObject2).get(((d)localObject1).bk(j), null);
            if ((localView2 != null) && (bY(localView2)))
            {
              localw1 = (w)locala2.get(localView1);
              localw2 = (w)locala1.get(localView2);
              if ((localw1 != null) && (localw2 != null))
              {
                this.cgw.add(localw1);
                this.cgx.add(localw2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
      }
    }
    i = 0;
    while (i < locala2.size())
    {
      paramx1 = (w)locala2.bl(i);
      if (bY(paramx1.view))
      {
        this.cgw.add(paramx1);
        this.cgx.add(null);
      }
      i += 1;
    }
    i = 0;
    while (i < locala1.size())
    {
      paramx1 = (w)locala1.bl(i);
      if (bY(paramx1.view))
      {
        this.cgx.add(paramx1);
        this.cgw.add(null);
      }
      i += 1;
    }
  }
  
  private static boolean a(w paramw1, w paramw2, String paramString)
  {
    paramw1 = paramw1.values.get(paramString);
    paramw2 = paramw2.values.get(paramString);
    if ((paramw1 != null) || (paramw2 != null))
    {
      if ((paramw1 == null) || (paramw2 == null)) {}
      while (!paramw1.equals(paramw2)) {
        return true;
      }
    }
    return false;
  }
  
  private static int[] aS(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    paramString = new int[localStringTokenizer.countTokens()];
    int i = 0;
    if (localStringTokenizer.hasMoreTokens())
    {
      Object localObject = localStringTokenizer.nextToken().trim();
      if ("id".equalsIgnoreCase((String)localObject)) {
        paramString[i] = 3;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("instance".equalsIgnoreCase((String)localObject))
        {
          paramString[i] = 1;
        }
        else if ("name".equalsIgnoreCase((String)localObject))
        {
          paramString[i] = 2;
        }
        else if ("itemId".equalsIgnoreCase((String)localObject))
        {
          paramString[i] = 4;
        }
        else
        {
          if (!((String)localObject).isEmpty()) {
            break label139;
          }
          localObject = new int[paramString.length - 1];
          System.arraycopy(paramString, 0, localObject, 0, i);
          i -= 1;
          paramString = (String)localObject;
        }
      }
      label139:
      throw new InflateException("Unknown match type in matchOrder: '" + (String)localObject + "'");
    }
    return paramString;
  }
  
  private void g(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j = paramView.getId();
      if (((this.cgl == null) || (!this.cgl.contains(Integer.valueOf(j)))) && ((this.cgm == null) || (!this.cgm.contains(paramView))))
      {
        if (this.cgn != null)
        {
          int k = this.cgn.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label100;
            }
            if (((Class)this.cgn.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label100:
        w localw;
        if ((paramView.getParent() instanceof ViewGroup))
        {
          localw = new w();
          localw.view = paramView;
          if (!paramBoolean) {
            break label261;
          }
          b(localw);
          label135:
          localw.chg.add(this);
          d(localw);
          if (!paramBoolean) {
            break label270;
          }
          a(this.cgs, paramView, localw);
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.cgp != null) && (this.cgp.contains(Integer.valueOf(j)))) || ((this.cgq != null) && (this.cgq.contains(paramView)))) {
            break label281;
          }
          if (this.cgr == null) {
            break label283;
          }
          j = this.cgr.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label283;
            }
            if (((Class)this.cgr.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          label261:
          c(localw);
          break label135;
          label270:
          a(this.cgt, paramView, localw);
        }
        label281:
        continue;
        label283:
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          g(paramView.getChildAt(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  private void p(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      this.cgv = cgc;
      return;
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      int j = paramVarArgs[i];
      if ((j > 0) && (j <= 4)) {}
      for (j = 1; j == 0; j = 0) {
        throw new IllegalArgumentException("matches contains invalid value");
      }
      if (q(paramVarArgs, i)) {
        throw new IllegalArgumentException("matches contains a duplicate value");
      }
      i += 1;
    }
    this.cgv = ((int[])paramVarArgs.clone());
  }
  
  private static boolean q(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt[paramInt];
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramInt)
      {
        if (paramArrayOfInt[i] == j) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String[] LI()
  {
    return null;
  }
  
  public final long LR()
  {
    return this.cge;
  }
  
  public final TimeInterpolator LS()
  {
    return this.cgf;
  }
  
  protected void LU()
  {
    start();
    a locala = LT();
    Iterator localIterator = this.lB.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (locala.containsKey(localAnimator))
      {
        start();
        if (localAnimator != null)
        {
          localAnimator.addListener(new Transition.2(this, locala));
          if (localAnimator == null)
          {
            end();
          }
          else
          {
            if (this.mDuration >= 0L) {
              localAnimator.setDuration(this.mDuration);
            }
            if (this.cge >= 0L) {
              localAnimator.setStartDelay(this.cge);
            }
            if (this.cgf != null) {
              localAnimator.setInterpolator(this.cgf);
            }
            localAnimator.addListener(new Transition.3(this));
            localAnimator.start();
          }
        }
      }
    }
    this.lB.clear();
    end();
  }
  
  public final PathMotion LV()
  {
    return this.cgH;
  }
  
  public final c LW()
  {
    return this.cgF;
  }
  
  public final Rect LX()
  {
    if (this.cgF == null) {
      return null;
    }
    return this.cgF.LN();
  }
  
  public Transition LY()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.lB = new ArrayList();
      localTransition.cgs = new x();
      localTransition.cgt = new x();
      localTransition.cgw = null;
      localTransition.cgx = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public Animator a(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    return null;
  }
  
  public Transition a(TimeInterpolator paramTimeInterpolator)
  {
    this.cgf = paramTimeInterpolator;
    return this;
  }
  
  public Transition a(d paramd)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramd);
    return this;
  }
  
  public Transition a(Class paramClass, boolean paramBoolean)
  {
    ArrayList localArrayList2 = this.cgn;
    ArrayList localArrayList1 = localArrayList2;
    if (paramClass != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (localArrayList1 = Transition.b.c(localArrayList2, paramClass);; localArrayList1 = Transition.b.d(localArrayList2, paramClass))
    {
      this.cgn = localArrayList1;
      return this;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, x paramx1, x paramx2, ArrayList<w> paramArrayList1, ArrayList<w> paramArrayList2)
  {
    a locala = LT();
    long l1 = 9223372036854775807L;
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    int i = 0;
    w localw1;
    w localw2;
    if (i < k)
    {
      localw1 = (w)paramArrayList1.get(i);
      localw2 = (w)paramArrayList2.get(i);
      if ((localw1 == null) || (localw1.chg.contains(this))) {
        break label615;
      }
      localw1 = null;
    }
    label312:
    label615:
    for (;;)
    {
      if ((localw2 != null) && (!localw2.chg.contains(this))) {
        localw2 = null;
      }
      for (;;)
      {
        long l2;
        int j;
        Animator localAnimator;
        Object localObject2;
        Object localObject1;
        if (localw1 == null)
        {
          l2 = l1;
          if (localw2 == null) {}
        }
        else
        {
          if ((localw1 == null) || (localw2 == null) || (a(localw1, localw2))) {}
          for (j = 1;; j = 0)
          {
            l2 = l1;
            if (j == 0) {
              break label493;
            }
            localAnimator = a(paramViewGroup, localw1, localw2);
            l2 = l1;
            if (localAnimator == null) {
              break label493;
            }
            localObject2 = null;
            if (localw2 == null) {
              break label528;
            }
            localObject1 = localw2.view;
            String[] arrayOfString = LI();
            paramx1 = (x)localObject2;
            if (localObject1 == null) {
              break label515;
            }
            paramx1 = (x)localObject2;
            if (arrayOfString == null) {
              break label515;
            }
            paramx1 = (x)localObject2;
            if (arrayOfString.length <= 0) {
              break label515;
            }
            paramx1 = new w();
            paramx1.view = ((View)localObject1);
            localObject2 = (w)paramx2.chh.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            j = 0;
            while (j < arrayOfString.length)
            {
              paramx1.values.put(arrayOfString[j], ((w)localObject2).values.get(arrayOfString[j]));
              j += 1;
            }
          }
          int m = locala.size();
          j = 0;
          if (j >= m) {
            break label515;
          }
          localObject2 = (a)locala.get((Animator)locala.bn(j));
          if ((((a)localObject2).cgK == null) || (((a)localObject2).mView != localObject1) || (!((a)localObject2).mName.equals(this.mName)) || (!((a)localObject2).cgK.equals(paramx1))) {
            break label506;
          }
          localAnimator = null;
          localObject2 = localObject1;
          localObject1 = paramx1;
          paramx1 = (x)localObject2;
        }
        for (;;)
        {
          l2 = l1;
          if (localAnimator != null)
          {
            l2 = l1;
            if (this.cgE != null)
            {
              l2 = this.cgE.a(paramViewGroup, this, localw1, localw2);
              localSparseIntArray.put(this.lB.size(), (int)l2);
              l2 = Math.min(l2, l1);
            }
            locala.put(localAnimator, new a(paramx1, this.mName, this, ai.ch(paramViewGroup), (w)localObject1));
            this.lB.add(localAnimator);
          }
          label493:
          i += 1;
          l1 = l2;
          break;
          label506:
          j += 1;
          break label312;
          localObject2 = paramx1;
          paramx1 = (x)localObject1;
          localObject1 = localObject2;
          continue;
          paramx1 = localw1.view;
          localObject1 = null;
        }
        if (l1 != 0L)
        {
          i = 0;
          while (i < localSparseIntArray.size())
          {
            j = localSparseIntArray.keyAt(i);
            paramViewGroup = (Animator)this.lB.get(j);
            paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i) - l1 + paramViewGroup.getStartDelay());
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  public void a(PathMotion paramPathMotion)
  {
    if (paramPathMotion == null)
    {
      this.cgH = cgd;
      return;
    }
    this.cgH = paramPathMotion;
  }
  
  public void a(c paramc)
  {
    this.cgF = paramc;
  }
  
  public void a(u paramu)
  {
    this.cgE = paramu;
  }
  
  public boolean a(w paramw1, w paramw2)
  {
    if ((paramw1 != null) && (paramw2 != null))
    {
      Object localObject = LI();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (a(paramw1, paramw2, localObject[i])) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      localObject = paramw1.values.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramw1, paramw2, (String)((Iterator)localObject).next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Transition aT(String paramString)
  {
    if (this.cgj == null) {
      this.cgj = new ArrayList();
    }
    this.cgj.add(paramString);
    return this;
  }
  
  public Transition b(d paramd)
  {
    if (this.mListeners == null) {}
    do
    {
      return this;
      this.mListeners.remove(paramd);
    } while (this.mListeners.size() != 0);
    this.mListeners = null;
    return this;
  }
  
  final void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int k = 0;
    bl(paramBoolean);
    int i;
    Object localObject1;
    Object localObject2;
    if (((this.cgg.size() > 0) || (this.cgh.size() > 0)) && ((this.cgj == null) || (this.cgj.isEmpty())) && ((this.cgk == null) || (this.cgk.isEmpty())))
    {
      i = 0;
      if (i < this.cgg.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.cgg.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new w();
          ((w)localObject2).view = ((View)localObject1);
          if (!paramBoolean) {
            break label164;
          }
          b((w)localObject2);
          label126:
          ((w)localObject2).chg.add(this);
          d((w)localObject2);
          if (!paramBoolean) {
            break label173;
          }
          a(this.cgs, (View)localObject1, (w)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          label164:
          c((w)localObject2);
          break label126;
          label173:
          a(this.cgt, (View)localObject1, (w)localObject2);
        }
      }
      i = 0;
      if (i < this.cgh.size())
      {
        paramViewGroup = (View)this.cgh.get(i);
        localObject1 = new w();
        ((w)localObject1).view = paramViewGroup;
        if (paramBoolean)
        {
          b((w)localObject1);
          label237:
          ((w)localObject1).chg.add(this);
          d((w)localObject1);
          if (!paramBoolean) {
            break label283;
          }
          a(this.cgs, paramViewGroup, (w)localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          c((w)localObject1);
          break label237;
          label283:
          a(this.cgt, paramViewGroup, (w)localObject1);
        }
      }
    }
    else
    {
      g(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.cgG != null))
    {
      int m = this.cgG.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.cgG.bn(i);
        paramViewGroup.add(this.cgs.chk.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.cgG.bl(j);
          this.cgs.chk.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  public abstract void b(w paramw);
  
  public Transition bB(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public Transition bC(long paramLong)
  {
    this.cge = paramLong;
    return this;
  }
  
  final boolean bY(View paramView)
  {
    int j = paramView.getId();
    if ((this.cgl != null) && (this.cgl.contains(Integer.valueOf(j)))) {}
    for (;;)
    {
      return false;
      if ((this.cgm == null) || (!this.cgm.contains(paramView)))
      {
        int i;
        if (this.cgn != null)
        {
          int k = this.cgn.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label95;
            }
            if (((Class)this.cgn.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label95:
        if ((this.cgo == null) || (z.ai(paramView) == null) || (!this.cgo.contains(z.ai(paramView))))
        {
          if ((this.cgg.size() == 0) && (this.cgh.size() == 0) && ((this.cgk == null) || (this.cgk.isEmpty())) && ((this.cgj == null) || (this.cgj.isEmpty()))) {
            return true;
          }
          if ((this.cgg.contains(Integer.valueOf(j))) || (this.cgh.contains(paramView))) {
            return true;
          }
          if ((this.cgj != null) && (this.cgj.contains(z.ai(paramView)))) {
            return true;
          }
          if (this.cgk != null)
          {
            i = 0;
            while (i < this.cgk.size())
            {
              if (((Class)this.cgk.get(i)).isInstance(paramView)) {
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  public Transition bZ(View paramView)
  {
    this.cgh.add(paramView);
    return this;
  }
  
  final void bl(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.cgs.chh.clear();
      this.cgs.chi.clear();
      this.cgs.chj.clear();
      return;
    }
    this.cgt.chh.clear();
    this.cgt.chi.clear();
    this.cgt.chj.clear();
  }
  
  public Transition c(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList2 = this.cgo;
    ArrayList localArrayList1 = localArrayList2;
    if (paramString != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (localArrayList1 = Transition.b.c(localArrayList2, paramString);; localArrayList1 = Transition.b.d(localArrayList2, paramString))
    {
      this.cgo = localArrayList1;
      return this;
    }
  }
  
  public abstract void c(w paramw);
  
  public Transition ca(View paramView)
  {
    this.cgh.remove(paramView);
    return this;
  }
  
  public void cb(View paramView)
  {
    int k = 0;
    if (!this.bCD)
    {
      a locala = LT();
      int i = locala.size();
      paramView = ai.ch(paramView);
      i -= 1;
      label96:
      int j;
      if (i >= 0)
      {
        Object localObject = (a)locala.bl(i);
        if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).cgL)))
        {
          localObject = (Animator)locala.bn(i);
          if (Build.VERSION.SDK_INT < 19) {
            break label96;
          }
          ((Animator)localObject).pause();
        }
        for (;;)
        {
          i -= 1;
          break;
          ArrayList localArrayList = ((Animator)localObject).getListeners();
          if (localArrayList != null)
          {
            int m = localArrayList.size();
            j = 0;
            while (j < m)
            {
              Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(j);
              if ((localAnimatorListener instanceof a.a)) {
                ((a.a)localAnimatorListener).onAnimationPause((Animator)localObject);
              }
              j += 1;
            }
          }
        }
      }
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        paramView = (ArrayList)this.mListeners.clone();
        j = paramView.size();
        i = k;
        while (i < j)
        {
          ((d)paramView.get(i)).LJ();
          i += 1;
        }
      }
      this.cgD = true;
    }
  }
  
  public void cc(View paramView)
  {
    if (this.cgD)
    {
      if (!this.bCD)
      {
        a locala = LT();
        int i = locala.size();
        paramView = ai.ch(paramView);
        i -= 1;
        label100:
        int j;
        if (i >= 0)
        {
          Object localObject = (a)locala.bl(i);
          if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).cgL)))
          {
            localObject = (Animator)locala.bn(i);
            if (Build.VERSION.SDK_INT < 19) {
              break label100;
            }
            ((Animator)localObject).resume();
          }
          for (;;)
          {
            i -= 1;
            break;
            ArrayList localArrayList = ((Animator)localObject).getListeners();
            if (localArrayList != null)
            {
              int k = localArrayList.size();
              j = 0;
              while (j < k)
              {
                Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(j);
                if ((localAnimatorListener instanceof a.a)) {
                  ((a.a)localAnimatorListener).onAnimationResume((Animator)localObject);
                }
                j += 1;
              }
            }
          }
        }
        if ((this.mListeners != null) && (this.mListeners.size() > 0))
        {
          paramView = (ArrayList)this.mListeners.clone();
          j = paramView.size();
          i = 0;
          while (i < j)
          {
            ((d)paramView.get(i)).LK();
            i += 1;
          }
        }
      }
      this.cgD = false;
    }
  }
  
  void d(w paramw)
  {
    int j = 0;
    String[] arrayOfString;
    if ((this.cgE != null) && (!paramw.values.isEmpty()))
    {
      arrayOfString = this.cgE.Mb();
      if (arrayOfString != null) {
        break label36;
      }
    }
    label36:
    label86:
    for (;;)
    {
      return;
      int i = 0;
      if (i < arrayOfString.length) {
        if (paramw.values.containsKey(arrayOfString[i])) {}
      }
      for (i = j;; i = 1)
      {
        if (i != 0) {
          break label86;
        }
        this.cgE.a(paramw);
        return;
        i += 1;
        break;
      }
    }
  }
  
  protected final void end()
  {
    this.cgC -= 1;
    if (this.cgC == 0)
    {
      Object localObject;
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        localObject = (ArrayList)this.mListeners.clone();
        int j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((d)((ArrayList)localObject).get(i)).a(this);
          i += 1;
        }
      }
      int i = 0;
      while (i < this.cgs.chj.size())
      {
        localObject = (View)this.cgs.chj.bl(i);
        if (localObject != null) {
          z.b((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.cgt.chj.size())
      {
        localObject = (View)this.cgt.chj.bl(i);
        if (localObject != null) {
          z.b((View)localObject, false);
        }
        i += 1;
      }
      this.bCD = true;
    }
  }
  
  final void f(ViewGroup paramViewGroup)
  {
    this.cgw = new ArrayList();
    this.cgx = new ArrayList();
    a(this.cgs, this.cgt);
    a locala = LT();
    int i = locala.size();
    aq localaq = ai.ch(paramViewGroup);
    i -= 1;
    if (i >= 0)
    {
      Animator localAnimator = (Animator)locala.bn(i);
      int j;
      if (localAnimator != null)
      {
        a locala1 = (a)locala.get(localAnimator);
        if ((locala1 != null) && (locala1.mView != null) && (localaq.equals(locala1.cgL)))
        {
          w localw1 = locala1.cgK;
          Object localObject = locala1.mView;
          w localw2 = h((View)localObject, true);
          localObject = i((View)localObject, true);
          if (((localw2 == null) && (localObject == null)) || (!locala1.cgM.a(localw1, (w)localObject))) {
            break label204;
          }
          j = 1;
          label172:
          if (j != 0)
          {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              break label209;
            }
            localAnimator.cancel();
          }
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label204:
        j = 0;
        break label172;
        label209:
        locala.remove(localAnimator);
      }
    }
    a(paramViewGroup, this.cgs, this.cgt, this.cgw, this.cgx);
    LU();
  }
  
  public Transition gH(int paramInt)
  {
    if (paramInt != 0) {
      this.cgg.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public final w h(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).cgu != null; localObject = ((Transition)localObject).cgu) {}
    if (paramBoolean) {}
    for (localObject = ((Transition)localObject).cgs;; localObject = ((Transition)localObject).cgt) {
      return (w)((x)localObject).chh.get(paramView);
    }
  }
  
  final w i(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).cgu != null; localObject = ((Transition)localObject).cgu) {}
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = ((Transition)localObject).cgw;
      if (localArrayList != null) {
        break label49;
      }
    }
    label49:
    int i;
    w localw;
    do
    {
      return null;
      localArrayList = ((Transition)localObject).cgx;
      break;
      int j = localArrayList.size();
      i = 0;
      if (i >= j) {
        break label135;
      }
      localw = (w)localArrayList.get(i);
    } while (localw == null);
    if (localw.view == paramView) {}
    for (;;)
    {
      if (i >= 0) {
        if (paramBoolean) {
          paramView = ((Transition)localObject).cgx;
        }
      }
      label103:
      for (paramView = (w)paramView.get(i);; paramView = null)
      {
        return paramView;
        i += 1;
        break;
        paramView = ((Transition)localObject).cgw;
        break label103;
      }
      label135:
      i = -1;
    }
  }
  
  public Transition s(Class paramClass)
  {
    if (this.cgk == null) {
      this.cgk = new ArrayList();
    }
    this.cgk.add(paramClass);
    return this;
  }
  
  protected final void start()
  {
    if (this.cgC == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((d)localArrayList.get(i)).LO();
          i += 1;
        }
      }
      this.bCD = false;
    }
    this.cgC += 1;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  String toString(String paramString)
  {
    int j = 0;
    String str = paramString + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
    paramString = str;
    if (this.mDuration != -1L) {
      paramString = str + "dur(" + this.mDuration + ") ";
    }
    str = paramString;
    if (this.cge != -1L) {
      str = paramString + "dly(" + this.cge + ") ";
    }
    paramString = str;
    if (this.cgf != null) {
      paramString = str + "interp(" + this.cgf + ") ";
    }
    if (this.cgg.size() <= 0)
    {
      str = paramString;
      if (this.cgh.size() <= 0) {}
    }
    else
    {
      str = paramString + "tgts(";
      paramString = str;
      int i;
      if (this.cgg.size() > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= this.cgg.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + this.cgg.get(i);
          i += 1;
        }
      }
      str = paramString;
      if (this.cgh.size() > 0)
      {
        i = j;
        for (;;)
        {
          str = paramString;
          if (i >= this.cgh.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + this.cgh.get(i);
          i += 1;
        }
      }
      str = str + ")";
    }
    return str;
  }
  
  public Transition z(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList2 = this.cgl;
    ArrayList localArrayList1 = localArrayList2;
    if (paramInt > 0) {
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (localArrayList1 = Transition.b.c(localArrayList2, Integer.valueOf(paramInt));; localArrayList1 = Transition.b.d(localArrayList2, Integer.valueOf(paramInt)))
    {
      this.cgl = localArrayList1;
      return this;
    }
  }
  
  static final class a
  {
    w cgK;
    aq cgL;
    Transition cgM;
    String mName;
    View mView;
    
    a(View paramView, String paramString, Transition paramTransition, aq paramaq, w paramw)
    {
      this.mView = paramView;
      this.mName = paramString;
      this.cgK = paramw;
      this.cgL = paramaq;
      this.cgM = paramTransition;
    }
  }
  
  public static abstract class c
  {
    public abstract Rect LN();
  }
  
  public static abstract interface d
  {
    public abstract void LJ();
    
    public abstract void LK();
    
    public abstract void LO();
    
    public abstract void a(Transition paramTransition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.Transition
 * JD-Core Version:    0.7.0.1
 */