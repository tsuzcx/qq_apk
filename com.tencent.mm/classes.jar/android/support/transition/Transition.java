package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.e.a;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Transition
  implements Cloneable
{
  private static final int[] Cb = { 2, 1, 3, 4 };
  private static final PathMotion Cc = new PathMotion()
  {
    public final Path getPath(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramAnonymousFloat1, paramAnonymousFloat2);
      localPath.lineTo(paramAnonymousFloat3, paramAnonymousFloat4);
      return localPath;
    }
  };
  private static ThreadLocal<a<Animator, a>> Cw = new ThreadLocal();
  private ViewGroup BF = null;
  private boolean CA = false;
  private boolean CB = false;
  t CC;
  c CD;
  private a<String, String> CE;
  PathMotion CF = Cc;
  long Cd = -1L;
  TimeInterpolator Ce = null;
  ArrayList<Integer> Cf = new ArrayList();
  ArrayList<View> Cg = new ArrayList();
  ArrayList<String> Ch = null;
  ArrayList<Class> Ci = null;
  private ArrayList<Integer> Cj = null;
  private ArrayList<View> Ck = null;
  private ArrayList<Class> Cl = null;
  private ArrayList<String> Cm = null;
  private ArrayList<Integer> Cn = null;
  private ArrayList<View> Co = null;
  private ArrayList<Class> Cp = null;
  private w Cq = new w();
  private w Cr = new w();
  TransitionSet Cs = null;
  private int[] Ct = Cb;
  private ArrayList<v> Cu;
  private ArrayList<v> Cv;
  boolean Cx = false;
  ArrayList<Animator> Cy = new ArrayList();
  private int Cz = 0;
  long mDuration = -1L;
  private ArrayList<d> mListeners = null;
  private String mName = getClass().getName();
  private ArrayList<Animator> xd = new ArrayList();
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, p.BS);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = android.support.v4.content.a.g.a(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      f(l);
    }
    l = android.support.v4.content.a.g.a(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      g(l);
    }
    int i = android.support.v4.content.a.g.b(localTypedArray, paramAttributeSet, "interpolator", 0);
    if (i > 0) {
      b(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = android.support.v4.content.a.g.c(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      setMatchOrder(p(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private void a(w paramw1, w paramw2)
  {
    a locala2 = new a(paramw1.Dg);
    a locala1 = new a(paramw2.Dg);
    int i = 0;
    if (i < this.Ct.length)
    {
      switch (this.Ct[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int j = locala2.size() - 1;
        while (j >= 0)
        {
          localObject1 = (View)locala2.keyAt(j);
          if ((localObject1 != null) && (H((View)localObject1)))
          {
            localObject1 = (v)locala1.remove(localObject1);
            if ((localObject1 != null) && (((v)localObject1).view != null) && (H(((v)localObject1).view)))
            {
              localObject2 = (v)locala2.removeAt(j);
              this.Cu.add(localObject2);
              this.Cv.add(localObject1);
            }
          }
          j -= 1;
        }
        Object localObject1 = paramw1.Dj;
        Object localObject2 = paramw2.Dj;
        int k = ((a)localObject1).size();
        j = 0;
        View localView1;
        View localView2;
        v localv1;
        v localv2;
        while (j < k)
        {
          localView1 = (View)((a)localObject1).valueAt(j);
          if ((localView1 != null) && (H(localView1)))
          {
            localView2 = (View)((a)localObject2).get(((a)localObject1).keyAt(j));
            if ((localView2 != null) && (H(localView2)))
            {
              localv1 = (v)locala2.get(localView1);
              localv2 = (v)locala1.get(localView2);
              if ((localv1 != null) && (localv2 != null))
              {
                this.Cu.add(localv1);
                this.Cv.add(localv2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramw1.Dh;
        localObject2 = paramw2.Dh;
        k = ((SparseArray)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((SparseArray)localObject1).valueAt(j);
          if ((localView1 != null) && (H(localView1)))
          {
            localView2 = (View)((SparseArray)localObject2).get(((SparseArray)localObject1).keyAt(j));
            if ((localView2 != null) && (H(localView2)))
            {
              localv1 = (v)locala2.get(localView1);
              localv2 = (v)locala1.get(localView2);
              if ((localv1 != null) && (localv2 != null))
              {
                this.Cu.add(localv1);
                this.Cv.add(localv2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramw1.Di;
        localObject2 = paramw2.Di;
        k = ((android.support.v4.e.g)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((android.support.v4.e.g)localObject1).valueAt(j);
          if ((localView1 != null) && (H(localView1)))
          {
            localView2 = (View)((android.support.v4.e.g)localObject2).get(((android.support.v4.e.g)localObject1).keyAt(j), null);
            if ((localView2 != null) && (H(localView2)))
            {
              localv1 = (v)locala2.get(localView1);
              localv2 = (v)locala1.get(localView2);
              if ((localv1 != null) && (localv2 != null))
              {
                this.Cu.add(localv1);
                this.Cv.add(localv2);
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
      paramw1 = (v)locala2.valueAt(i);
      if (H(paramw1.view))
      {
        this.Cu.add(paramw1);
        this.Cv.add(null);
      }
      i += 1;
    }
    i = 0;
    while (i < locala1.size())
    {
      paramw1 = (v)locala1.valueAt(i);
      if (H(paramw1.view))
      {
        this.Cv.add(paramw1);
        this.Cu.add(null);
      }
      i += 1;
    }
  }
  
  private static void a(w paramw, View paramView, v paramv)
  {
    paramw.Dg.put(paramView, paramv);
    int i = paramView.getId();
    if (i >= 0)
    {
      if (paramw.Dh.indexOfKey(i) >= 0) {
        paramw.Dh.put(i, null);
      }
    }
    else
    {
      paramv = u.an(paramView);
      if (paramv != null)
      {
        if (!paramw.Dj.containsKey(paramv)) {
          break label168;
        }
        paramw.Dj.put(paramv, null);
      }
    }
    long l;
    for (;;)
    {
      if ((paramView.getParent() instanceof ListView))
      {
        paramv = (ListView)paramView.getParent();
        if (paramv.getAdapter().hasStableIds())
        {
          l = paramv.getItemIdAtPosition(paramv.getPositionForView(paramView));
          if (paramw.Di.indexOfKey(l) < 0) {
            break label181;
          }
          paramView = (View)paramw.Di.get(l, null);
          if (paramView != null)
          {
            u.d(paramView, false);
            paramw.Di.put(l, null);
          }
        }
      }
      return;
      paramw.Dh.put(i, paramView);
      break;
      label168:
      paramw.Dj.put(paramv, paramView);
    }
    label181:
    u.d(paramView, true);
    paramw.Di.put(l, paramView);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j = paramView.getId();
      if (((this.Cj == null) || (!this.Cj.contains(Integer.valueOf(j)))) && ((this.Ck == null) || (!this.Ck.contains(paramView))))
      {
        if (this.Cl != null)
        {
          int k = this.Cl.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label100;
            }
            if (((Class)this.Cl.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label100:
        v localv;
        if ((paramView.getParent() instanceof ViewGroup))
        {
          localv = new v();
          localv.view = paramView;
          if (!paramBoolean) {
            break label261;
          }
          a(localv);
          label135:
          localv.Df.add(this);
          d(localv);
          if (!paramBoolean) {
            break label270;
          }
          a(this.Cq, paramView, localv);
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.Cn != null) && (this.Cn.contains(Integer.valueOf(j)))) || ((this.Co != null) && (this.Co.contains(paramView)))) {
            break label281;
          }
          if (this.Cp == null) {
            break label283;
          }
          j = this.Cp.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label283;
            }
            if (((Class)this.Cp.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          label261:
          b(localv);
          break label135;
          label270:
          a(this.Cr, paramView, localv);
        }
        label281:
        continue;
        label283:
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          a(paramView.getChildAt(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  private static boolean a(v paramv1, v paramv2, String paramString)
  {
    paramv1 = paramv1.values.get(paramString);
    paramv2 = paramv2.values.get(paramString);
    if ((paramv1 != null) || (paramv2 != null))
    {
      if ((paramv1 == null) || (paramv2 == null)) {}
      while (!paramv1.equals(paramv2)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(int[] paramArrayOfInt, int paramInt)
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
  
  private static a<Animator, a> dN()
  {
    a locala2 = (a)Cw.get();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      Cw.set(locala1);
    }
    return locala1;
  }
  
  private static int[] p(String paramString)
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
  
  private void setMatchOrder(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      this.Ct = Cb;
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
      if (b(paramVarArgs, i)) {
        throw new IllegalArgumentException("matches contains a duplicate value");
      }
      i += 1;
    }
    this.Ct = ((int[])paramVarArgs.clone());
  }
  
  final void B(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Cq.Dg.clear();
      this.Cq.Dh.clear();
      this.Cq.Di.clear();
      return;
    }
    this.Cr.Dg.clear();
    this.Cr.Dh.clear();
    this.Cr.Di.clear();
  }
  
  final boolean H(View paramView)
  {
    int j = paramView.getId();
    if ((this.Cj != null) && (this.Cj.contains(Integer.valueOf(j)))) {}
    for (;;)
    {
      return false;
      if ((this.Ck == null) || (!this.Ck.contains(paramView)))
      {
        int i;
        if (this.Cl != null)
        {
          int k = this.Cl.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label95;
            }
            if (((Class)this.Cl.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label95:
        if ((this.Cm == null) || (u.an(paramView) == null) || (!this.Cm.contains(u.an(paramView))))
        {
          if ((this.Cf.size() == 0) && (this.Cg.size() == 0) && ((this.Ci == null) || (this.Ci.isEmpty())) && ((this.Ch == null) || (this.Ch.isEmpty()))) {
            return true;
          }
          if ((this.Cf.contains(Integer.valueOf(j))) || (this.Cg.contains(paramView))) {
            return true;
          }
          if ((this.Ch != null) && (this.Ch.contains(u.an(paramView)))) {
            return true;
          }
          if (this.Ci != null)
          {
            i = 0;
            while (i < this.Ci.size())
            {
              if (((Class)this.Ci.get(i)).isInstance(paramView)) {
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  public Transition I(View paramView)
  {
    this.Cg.add(paramView);
    return this;
  }
  
  public Transition J(View paramView)
  {
    this.Cg.remove(paramView);
    return this;
  }
  
  public void K(View paramView)
  {
    int k = 0;
    if (!this.CB)
    {
      a locala = dN();
      int i = locala.size();
      paramView = ah.O(paramView);
      i -= 1;
      label96:
      int j;
      if (i >= 0)
      {
        Object localObject = (a)locala.valueAt(i);
        if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).CJ)))
        {
          localObject = (Animator)locala.keyAt(i);
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
          ((d)paramView.get(i)).dF();
          i += 1;
        }
      }
      this.CA = true;
    }
  }
  
  public void L(View paramView)
  {
    if (this.CA)
    {
      if (!this.CB)
      {
        a locala = dN();
        int i = locala.size();
        paramView = ah.O(paramView);
        i -= 1;
        label100:
        int j;
        if (i >= 0)
        {
          Object localObject = (a)locala.valueAt(i);
          if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).CJ)))
          {
            localObject = (Animator)locala.keyAt(i);
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
            ((d)paramView.get(i)).dG();
            i += 1;
          }
        }
      }
      this.CA = false;
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, v paramv1, v paramv2)
  {
    return null;
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
    ArrayList localArrayList2 = this.Cl;
    ArrayList localArrayList1 = localArrayList2;
    if (paramClass != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (localArrayList1 = Transition.b.a(localArrayList2, paramClass);; localArrayList1 = Transition.b.b(localArrayList2, paramClass))
    {
      this.Cl = localArrayList1;
      return this;
    }
  }
  
  public void a(PathMotion paramPathMotion)
  {
    if (paramPathMotion == null)
    {
      this.CF = Cc;
      return;
    }
    this.CF = paramPathMotion;
  }
  
  public void a(c paramc)
  {
    this.CD = paramc;
  }
  
  public void a(t paramt)
  {
    this.CC = paramt;
  }
  
  public abstract void a(v paramv);
  
  final void a(ViewGroup paramViewGroup)
  {
    this.Cu = new ArrayList();
    this.Cv = new ArrayList();
    a(this.Cq, this.Cr);
    a locala = dN();
    int i = locala.size();
    ap localap = ah.O(paramViewGroup);
    i -= 1;
    if (i >= 0)
    {
      Animator localAnimator = (Animator)locala.keyAt(i);
      int j;
      if (localAnimator != null)
      {
        a locala1 = (a)locala.get(localAnimator);
        if ((locala1 != null) && (locala1.mView != null) && (localap.equals(locala1.CJ)))
        {
          v localv1 = locala1.CI;
          Object localObject = locala1.mView;
          v localv2 = b((View)localObject, true);
          localObject = c((View)localObject, true);
          if (((localv2 == null) && (localObject == null)) || (!locala1.CK.a(localv1, (v)localObject))) {
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
    a(paramViewGroup, this.Cq, this.Cr, this.Cu, this.Cv);
    dO();
  }
  
  protected void a(ViewGroup paramViewGroup, w paramw1, w paramw2, ArrayList<v> paramArrayList1, ArrayList<v> paramArrayList2)
  {
    a locala = dN();
    long l1 = 9223372036854775807L;
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    int i = 0;
    v localv1;
    v localv2;
    if (i < k)
    {
      localv1 = (v)paramArrayList1.get(i);
      localv2 = (v)paramArrayList2.get(i);
      if ((localv1 == null) || (localv1.Df.contains(this))) {
        break label615;
      }
      localv1 = null;
    }
    label312:
    label615:
    for (;;)
    {
      if ((localv2 != null) && (!localv2.Df.contains(this))) {
        localv2 = null;
      }
      for (;;)
      {
        long l2;
        int j;
        Animator localAnimator;
        Object localObject2;
        Object localObject1;
        if (localv1 == null)
        {
          l2 = l1;
          if (localv2 == null) {}
        }
        else
        {
          if ((localv1 == null) || (localv2 == null) || (a(localv1, localv2))) {}
          for (j = 1;; j = 0)
          {
            l2 = l1;
            if (j == 0) {
              break label493;
            }
            localAnimator = a(paramViewGroup, localv1, localv2);
            l2 = l1;
            if (localAnimator == null) {
              break label493;
            }
            localObject2 = null;
            if (localv2 == null) {
              break label528;
            }
            localObject1 = localv2.view;
            String[] arrayOfString = getTransitionProperties();
            paramw1 = (w)localObject2;
            if (localObject1 == null) {
              break label515;
            }
            paramw1 = (w)localObject2;
            if (arrayOfString == null) {
              break label515;
            }
            paramw1 = (w)localObject2;
            if (arrayOfString.length <= 0) {
              break label515;
            }
            paramw1 = new v();
            paramw1.view = ((View)localObject1);
            localObject2 = (v)paramw2.Dg.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            j = 0;
            while (j < arrayOfString.length)
            {
              paramw1.values.put(arrayOfString[j], ((v)localObject2).values.get(arrayOfString[j]));
              j += 1;
            }
          }
          int m = locala.size();
          j = 0;
          if (j >= m) {
            break label515;
          }
          localObject2 = (a)locala.get((Animator)locala.keyAt(j));
          if ((((a)localObject2).CI == null) || (((a)localObject2).mView != localObject1) || (!((a)localObject2).mName.equals(this.mName)) || (!((a)localObject2).CI.equals(paramw1))) {
            break label506;
          }
          localAnimator = null;
          localObject2 = localObject1;
          localObject1 = paramw1;
          paramw1 = (w)localObject2;
        }
        for (;;)
        {
          l2 = l1;
          if (localAnimator != null)
          {
            l2 = l1;
            if (this.CC != null)
            {
              l2 = this.CC.a(paramViewGroup, this, localv1, localv2);
              localSparseIntArray.put(this.xd.size(), (int)l2);
              l2 = Math.min(l2, l1);
            }
            locala.put(localAnimator, new a(paramw1, this.mName, this, ah.O(paramViewGroup), (v)localObject1));
            this.xd.add(localAnimator);
          }
          label493:
          i += 1;
          l1 = l2;
          break;
          label506:
          j += 1;
          break label312;
          localObject2 = paramw1;
          paramw1 = (w)localObject1;
          localObject1 = localObject2;
          continue;
          paramw1 = localv1.view;
          localObject1 = null;
        }
        if (l1 != 0L)
        {
          i = 0;
          while (i < localSparseIntArray.size())
          {
            j = localSparseIntArray.keyAt(i);
            paramViewGroup = (Animator)this.xd.get(j);
            paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i) - l1 + paramViewGroup.getStartDelay());
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  public boolean a(v paramv1, v paramv2)
  {
    if ((paramv1 != null) && (paramv2 != null))
    {
      Object localObject = getTransitionProperties();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (a(paramv1, paramv2, localObject[i])) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      localObject = paramv1.values.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramv1, paramv2, (String)((Iterator)localObject).next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Transition an(int paramInt)
  {
    if (paramInt != 0) {
      this.Cf.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public Transition b(TimeInterpolator paramTimeInterpolator)
  {
    this.Ce = paramTimeInterpolator;
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
  
  public Transition b(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList2 = this.Cm;
    ArrayList localArrayList1 = localArrayList2;
    if (paramString != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (localArrayList1 = Transition.b.a(localArrayList2, paramString);; localArrayList1 = Transition.b.b(localArrayList2, paramString))
    {
      this.Cm = localArrayList1;
      return this;
    }
  }
  
  public final v b(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).Cs != null; localObject = ((Transition)localObject).Cs) {}
    if (paramBoolean) {}
    for (localObject = ((Transition)localObject).Cq;; localObject = ((Transition)localObject).Cr) {
      return (v)((w)localObject).Dg.get(paramView);
    }
  }
  
  public abstract void b(v paramv);
  
  final void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int k = 0;
    B(paramBoolean);
    int i;
    Object localObject1;
    Object localObject2;
    if (((this.Cf.size() > 0) || (this.Cg.size() > 0)) && ((this.Ch == null) || (this.Ch.isEmpty())) && ((this.Ci == null) || (this.Ci.isEmpty())))
    {
      i = 0;
      if (i < this.Cf.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.Cf.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new v();
          ((v)localObject2).view = ((View)localObject1);
          if (!paramBoolean) {
            break label164;
          }
          a((v)localObject2);
          label126:
          ((v)localObject2).Df.add(this);
          d((v)localObject2);
          if (!paramBoolean) {
            break label173;
          }
          a(this.Cq, (View)localObject1, (v)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          label164:
          b((v)localObject2);
          break label126;
          label173:
          a(this.Cr, (View)localObject1, (v)localObject2);
        }
      }
      i = 0;
      if (i < this.Cg.size())
      {
        paramViewGroup = (View)this.Cg.get(i);
        localObject1 = new v();
        ((v)localObject1).view = paramViewGroup;
        if (paramBoolean)
        {
          a((v)localObject1);
          label237:
          ((v)localObject1).Df.add(this);
          d((v)localObject1);
          if (!paramBoolean) {
            break label283;
          }
          a(this.Cq, paramViewGroup, (v)localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          b((v)localObject1);
          break label237;
          label283:
          a(this.Cr, paramViewGroup, (v)localObject1);
        }
      }
    }
    else
    {
      a(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.CE != null))
    {
      int m = this.CE.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.CE.keyAt(i);
        paramViewGroup.add(this.Cq.Dj.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.CE.valueAt(j);
          this.Cq.Dj.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  final v c(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).Cs != null; localObject = ((Transition)localObject).Cs) {}
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = ((Transition)localObject).Cu;
      if (localArrayList != null) {
        break label49;
      }
    }
    label49:
    int i;
    v localv;
    do
    {
      return null;
      localArrayList = ((Transition)localObject).Cv;
      break;
      int j = localArrayList.size();
      i = 0;
      if (i >= j) {
        break label135;
      }
      localv = (v)localArrayList.get(i);
    } while (localv == null);
    if (localv.view == paramView) {}
    for (;;)
    {
      if (i >= 0) {
        if (paramBoolean) {
          paramView = ((Transition)localObject).Cv;
        }
      }
      label103:
      for (paramView = (v)paramView.get(i);; paramView = null)
      {
        return paramView;
        i += 1;
        break;
        paramView = ((Transition)localObject).Cu;
        break label103;
      }
      label135:
      i = -1;
    }
  }
  
  void d(v paramv)
  {
    int j = 0;
    String[] arrayOfString;
    if ((this.CC != null) && (!paramv.values.isEmpty()))
    {
      arrayOfString = this.CC.getPropagationProperties();
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
        if (paramv.values.containsKey(arrayOfString[i])) {}
      }
      for (i = j;; i = 1)
      {
        if (i != 0) {
          break label86;
        }
        this.CC.c(paramv);
        return;
        i += 1;
        break;
      }
    }
  }
  
  protected void dO()
  {
    start();
    final a locala = dN();
    Iterator localIterator = this.xd.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (locala.containsKey(localAnimator))
      {
        start();
        if (localAnimator != null)
        {
          localAnimator.addListener(new AnimatorListenerAdapter()
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              locala.remove(paramAnonymousAnimator);
              Transition.this.Cy.remove(paramAnonymousAnimator);
            }
            
            public final void onAnimationStart(Animator paramAnonymousAnimator)
            {
              Transition.this.Cy.add(paramAnonymousAnimator);
            }
          });
          if (localAnimator == null)
          {
            end();
          }
          else
          {
            if (this.mDuration >= 0L) {
              localAnimator.setDuration(this.mDuration);
            }
            if (this.Cd >= 0L) {
              localAnimator.setStartDelay(this.Cd);
            }
            if (this.Ce != null) {
              localAnimator.setInterpolator(this.Ce);
            }
            localAnimator.addListener(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                Transition.this.end();
                paramAnonymousAnimator.removeListener(this);
              }
            });
            localAnimator.start();
          }
        }
      }
    }
    this.xd.clear();
    end();
  }
  
  public Transition dP()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.xd = new ArrayList();
      localTransition.Cq = new w();
      localTransition.Cr = new w();
      localTransition.Cu = null;
      localTransition.Cv = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  protected final void end()
  {
    this.Cz -= 1;
    if (this.Cz == 0)
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
      while (i < this.Cq.Di.size())
      {
        localObject = (View)this.Cq.Di.valueAt(i);
        if (localObject != null) {
          u.d((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.Cr.Di.size())
      {
        localObject = (View)this.Cr.Di.valueAt(i);
        if (localObject != null) {
          u.d((View)localObject, false);
        }
        i += 1;
      }
      this.CB = true;
    }
  }
  
  public Transition f(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList2 = this.Cj;
    ArrayList localArrayList1 = localArrayList2;
    if (paramInt > 0) {
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (localArrayList1 = Transition.b.a(localArrayList2, Integer.valueOf(paramInt));; localArrayList1 = Transition.b.b(localArrayList2, Integer.valueOf(paramInt)))
    {
      this.Cj = localArrayList1;
      return this;
    }
  }
  
  public Transition f(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public Transition g(long paramLong)
  {
    this.Cd = paramLong;
    return this;
  }
  
  public final Rect getEpicenter()
  {
    if (this.CD == null) {
      return null;
    }
    return this.CD.dJ();
  }
  
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  public Transition h(Class paramClass)
  {
    if (this.Ci == null) {
      this.Ci = new ArrayList();
    }
    this.Ci.add(paramClass);
    return this;
  }
  
  public Transition q(String paramString)
  {
    if (this.Ch == null) {
      this.Ch = new ArrayList();
    }
    this.Ch.add(paramString);
    return this;
  }
  
  protected final void start()
  {
    if (this.Cz == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((d)localArrayList.get(i)).dK();
          i += 1;
        }
      }
      this.CB = false;
    }
    this.Cz += 1;
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
    if (this.Cd != -1L) {
      str = paramString + "dly(" + this.Cd + ") ";
    }
    paramString = str;
    if (this.Ce != null) {
      paramString = str + "interp(" + this.Ce + ") ";
    }
    if (this.Cf.size() <= 0)
    {
      str = paramString;
      if (this.Cg.size() <= 0) {}
    }
    else
    {
      str = paramString + "tgts(";
      paramString = str;
      int i;
      if (this.Cf.size() > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= this.Cf.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + this.Cf.get(i);
          i += 1;
        }
      }
      str = paramString;
      if (this.Cg.size() > 0)
      {
        i = j;
        for (;;)
        {
          str = paramString;
          if (i >= this.Cg.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + this.Cg.get(i);
          i += 1;
        }
      }
      str = str + ")";
    }
    return str;
  }
  
  static final class a
  {
    v CI;
    ap CJ;
    Transition CK;
    String mName;
    View mView;
    
    a(View paramView, String paramString, Transition paramTransition, ap paramap, v paramv)
    {
      this.mView = paramView;
      this.mName = paramString;
      this.CI = paramv;
      this.CJ = paramap;
      this.CK = paramTransition;
    }
  }
  
  public static abstract class c
  {
    public abstract Rect dJ();
  }
  
  public static abstract interface d
  {
    public abstract void a(Transition paramTransition);
    
    public abstract void dF();
    
    public abstract void dG();
    
    public abstract void dK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Transition
 * JD-Core Version:    0.7.0.1
 */