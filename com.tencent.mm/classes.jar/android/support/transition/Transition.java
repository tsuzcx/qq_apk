package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.e.a;
import android.support.v4.view.t;
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
  private static final int[] Ad = { 2, 1, 3, 4 };
  private static final PathMotion Ae = new Transition.1();
  private static ThreadLocal<a<Animator, a>> Ay = new ThreadLocal();
  ArrayList<Animator> AA = new ArrayList();
  private int AB = 0;
  private boolean AC = false;
  private boolean AD = false;
  s AE;
  b AF;
  private a<String, String> AG;
  PathMotion AH = Ae;
  long Af = -1L;
  TimeInterpolator Ag = null;
  ArrayList<Integer> Ah = new ArrayList();
  ArrayList<View> Ai = new ArrayList();
  ArrayList<String> Aj = null;
  ArrayList<Class> Ak = null;
  private ArrayList<Integer> Al = null;
  private ArrayList<View> Am = null;
  private ArrayList<Class> An = null;
  private ArrayList<String> Ao = null;
  private ArrayList<Integer> Ap = null;
  private ArrayList<View> Aq = null;
  private ArrayList<Class> Ar = null;
  private v As = new v();
  private v At = new v();
  TransitionSet Au = null;
  private int[] Av = Ad;
  private ArrayList<u> Aw;
  private ArrayList<u> Ax;
  boolean Az = false;
  long mDuration = -1L;
  private ArrayList<c> mListeners = null;
  private String mName = getClass().getName();
  private ArrayList<Animator> vd = new ArrayList();
  private ViewGroup zH = null;
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, p.zU);
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
      setMatchOrder(q(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private void a(v paramv1, v paramv2)
  {
    a locala2 = new a(paramv1.Bf);
    a locala1 = new a(paramv2.Bf);
    int i = 0;
    if (i < this.Av.length)
    {
      switch (this.Av[i])
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
          if ((localObject1 != null) && (G((View)localObject1)))
          {
            localObject1 = (u)locala1.remove(localObject1);
            if ((localObject1 != null) && (((u)localObject1).view != null) && (G(((u)localObject1).view)))
            {
              localObject2 = (u)locala2.removeAt(j);
              this.Aw.add(localObject2);
              this.Ax.add(localObject1);
            }
          }
          j -= 1;
        }
        Object localObject1 = paramv1.Bi;
        Object localObject2 = paramv2.Bi;
        int k = ((a)localObject1).size();
        j = 0;
        View localView1;
        View localView2;
        u localu1;
        u localu2;
        while (j < k)
        {
          localView1 = (View)((a)localObject1).valueAt(j);
          if ((localView1 != null) && (G(localView1)))
          {
            localView2 = (View)((a)localObject2).get(((a)localObject1).keyAt(j));
            if ((localView2 != null) && (G(localView2)))
            {
              localu1 = (u)locala2.get(localView1);
              localu2 = (u)locala1.get(localView2);
              if ((localu1 != null) && (localu2 != null))
              {
                this.Aw.add(localu1);
                this.Ax.add(localu2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramv1.Bg;
        localObject2 = paramv2.Bg;
        k = ((SparseArray)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((SparseArray)localObject1).valueAt(j);
          if ((localView1 != null) && (G(localView1)))
          {
            localView2 = (View)((SparseArray)localObject2).get(((SparseArray)localObject1).keyAt(j));
            if ((localView2 != null) && (G(localView2)))
            {
              localu1 = (u)locala2.get(localView1);
              localu2 = (u)locala1.get(localView2);
              if ((localu1 != null) && (localu2 != null))
              {
                this.Aw.add(localu1);
                this.Ax.add(localu2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramv1.Bh;
        localObject2 = paramv2.Bh;
        k = ((android.support.v4.e.g)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((android.support.v4.e.g)localObject1).valueAt(j);
          if ((localView1 != null) && (G(localView1)))
          {
            localView2 = (View)((android.support.v4.e.g)localObject2).get(((android.support.v4.e.g)localObject1).keyAt(j), null);
            if ((localView2 != null) && (G(localView2)))
            {
              localu1 = (u)locala2.get(localView1);
              localu2 = (u)locala1.get(localView2);
              if ((localu1 != null) && (localu2 != null))
              {
                this.Aw.add(localu1);
                this.Ax.add(localu2);
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
      paramv1 = (u)locala2.valueAt(i);
      if (G(paramv1.view))
      {
        this.Aw.add(paramv1);
        this.Ax.add(null);
      }
      i += 1;
    }
    i = 0;
    while (i < locala1.size())
    {
      paramv1 = (u)locala1.valueAt(i);
      if (G(paramv1.view))
      {
        this.Ax.add(paramv1);
        this.Aw.add(null);
      }
      i += 1;
    }
  }
  
  private static void a(v paramv, View paramView, u paramu)
  {
    paramv.Bf.put(paramView, paramu);
    int i = paramView.getId();
    if (i >= 0)
    {
      if (paramv.Bg.indexOfKey(i) >= 0) {
        paramv.Bg.put(i, null);
      }
    }
    else
    {
      paramu = t.an(paramView);
      if (paramu != null)
      {
        if (!paramv.Bi.containsKey(paramu)) {
          break label168;
        }
        paramv.Bi.put(paramu, null);
      }
    }
    long l;
    for (;;)
    {
      if ((paramView.getParent() instanceof ListView))
      {
        paramu = (ListView)paramView.getParent();
        if (paramu.getAdapter().hasStableIds())
        {
          l = paramu.getItemIdAtPosition(paramu.getPositionForView(paramView));
          if (paramv.Bh.indexOfKey(l) < 0) {
            break label181;
          }
          paramView = (View)paramv.Bh.get(l, null);
          if (paramView != null)
          {
            t.d(paramView, false);
            paramv.Bh.put(l, null);
          }
        }
      }
      return;
      paramv.Bg.put(i, paramView);
      break;
      label168:
      paramv.Bi.put(paramu, paramView);
    }
    label181:
    t.d(paramView, true);
    paramv.Bh.put(l, paramView);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j = paramView.getId();
      if (((this.Al == null) || (!this.Al.contains(Integer.valueOf(j)))) && ((this.Am == null) || (!this.Am.contains(paramView))))
      {
        if (this.An != null)
        {
          int k = this.An.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label100;
            }
            if (((Class)this.An.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label100:
        u localu;
        if ((paramView.getParent() instanceof ViewGroup))
        {
          localu = new u();
          localu.view = paramView;
          if (!paramBoolean) {
            break label261;
          }
          a(localu);
          label135:
          localu.Be.add(this);
          d(localu);
          if (!paramBoolean) {
            break label270;
          }
          a(this.As, paramView, localu);
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.Ap != null) && (this.Ap.contains(Integer.valueOf(j)))) || ((this.Aq != null) && (this.Aq.contains(paramView)))) {
            break label281;
          }
          if (this.Ar == null) {
            break label283;
          }
          j = this.Ar.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label283;
            }
            if (((Class)this.Ar.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          label261:
          b(localu);
          break label135;
          label270:
          a(this.At, paramView, localu);
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
  
  private static boolean a(u paramu1, u paramu2, String paramString)
  {
    paramu1 = paramu1.values.get(paramString);
    paramu2 = paramu2.values.get(paramString);
    if ((paramu1 != null) || (paramu2 != null))
    {
      if ((paramu1 == null) || (paramu2 == null)) {}
      while (!paramu1.equals(paramu2)) {
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
  
  private static a<Animator, a> dv()
  {
    a locala2 = (a)Ay.get();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      Ay.set(locala1);
    }
    return locala1;
  }
  
  private static int[] q(String paramString)
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
      this.Av = Ad;
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
    this.Av = ((int[])paramVarArgs.clone());
  }
  
  final void B(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.As.Bf.clear();
      this.As.Bg.clear();
      this.As.Bh.clear();
      return;
    }
    this.At.Bf.clear();
    this.At.Bg.clear();
    this.At.Bh.clear();
  }
  
  final boolean G(View paramView)
  {
    int j = paramView.getId();
    if ((this.Al != null) && (this.Al.contains(Integer.valueOf(j)))) {}
    for (;;)
    {
      return false;
      if ((this.Am == null) || (!this.Am.contains(paramView)))
      {
        int i;
        if (this.An != null)
        {
          int k = this.An.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label95;
            }
            if (((Class)this.An.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label95:
        if ((this.Ao == null) || (t.an(paramView) == null) || (!this.Ao.contains(t.an(paramView))))
        {
          if ((this.Ah.size() == 0) && (this.Ai.size() == 0) && ((this.Ak == null) || (this.Ak.isEmpty())) && ((this.Aj == null) || (this.Aj.isEmpty()))) {
            return true;
          }
          if ((this.Ah.contains(Integer.valueOf(j))) || (this.Ai.contains(paramView))) {
            return true;
          }
          if ((this.Aj != null) && (this.Aj.contains(t.an(paramView)))) {
            return true;
          }
          if (this.Ak != null)
          {
            i = 0;
            while (i < this.Ak.size())
            {
              if (((Class)this.Ak.get(i)).isInstance(paramView)) {
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  public Transition H(View paramView)
  {
    this.Ai.add(paramView);
    return this;
  }
  
  public Transition I(View paramView)
  {
    this.Ai.remove(paramView);
    return this;
  }
  
  public void J(View paramView)
  {
    int k = 0;
    if (!this.AD)
    {
      a locala = dv();
      int i = locala.size();
      paramView = ag.N(paramView);
      i -= 1;
      label96:
      int j;
      if (i >= 0)
      {
        Object localObject = (a)locala.valueAt(i);
        if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).AL)))
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
          ((c)paramView.get(i)).dn();
          i += 1;
        }
      }
      this.AC = true;
    }
  }
  
  public void K(View paramView)
  {
    if (this.AC)
    {
      if (!this.AD)
      {
        a locala = dv();
        int i = locala.size();
        paramView = ag.N(paramView);
        i -= 1;
        label100:
        int j;
        if (i >= 0)
        {
          Object localObject = (a)locala.valueAt(i);
          if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).AL)))
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
            ((c)paramView.get(i)).jdMethod_do();
            i += 1;
          }
        }
      }
      this.AC = false;
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, u paramu1, u paramu2)
  {
    return null;
  }
  
  public Transition a(c paramc)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramc);
    return this;
  }
  
  public void a(PathMotion paramPathMotion)
  {
    if (paramPathMotion == null)
    {
      this.AH = Ae;
      return;
    }
    this.AH = paramPathMotion;
  }
  
  public void a(b paramb)
  {
    this.AF = paramb;
  }
  
  public void a(s params)
  {
    this.AE = params;
  }
  
  public abstract void a(u paramu);
  
  final void a(ViewGroup paramViewGroup)
  {
    this.Aw = new ArrayList();
    this.Ax = new ArrayList();
    a(this.As, this.At);
    a locala = dv();
    int i = locala.size();
    ao localao = ag.N(paramViewGroup);
    i -= 1;
    if (i >= 0)
    {
      Animator localAnimator = (Animator)locala.keyAt(i);
      int j;
      if (localAnimator != null)
      {
        a locala1 = (a)locala.get(localAnimator);
        if ((locala1 != null) && (locala1.mView != null) && (localao.equals(locala1.AL)))
        {
          u localu1 = locala1.AK;
          Object localObject = locala1.mView;
          u localu2 = b((View)localObject, true);
          localObject = c((View)localObject, true);
          if (((localu2 == null) && (localObject == null)) || (!locala1.AM.a(localu1, (u)localObject))) {
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
    a(paramViewGroup, this.As, this.At, this.Aw, this.Ax);
    dw();
  }
  
  protected void a(ViewGroup paramViewGroup, v paramv1, v paramv2, ArrayList<u> paramArrayList1, ArrayList<u> paramArrayList2)
  {
    a locala = dv();
    long l1 = 9223372036854775807L;
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    int i = 0;
    u localu1;
    u localu2;
    if (i < k)
    {
      localu1 = (u)paramArrayList1.get(i);
      localu2 = (u)paramArrayList2.get(i);
      if ((localu1 == null) || (localu1.Be.contains(this))) {
        break label615;
      }
      localu1 = null;
    }
    label312:
    label615:
    for (;;)
    {
      if ((localu2 != null) && (!localu2.Be.contains(this))) {
        localu2 = null;
      }
      for (;;)
      {
        long l2;
        int j;
        Animator localAnimator;
        Object localObject2;
        Object localObject1;
        if (localu1 == null)
        {
          l2 = l1;
          if (localu2 == null) {}
        }
        else
        {
          if ((localu1 == null) || (localu2 == null) || (a(localu1, localu2))) {}
          for (j = 1;; j = 0)
          {
            l2 = l1;
            if (j == 0) {
              break label493;
            }
            localAnimator = a(paramViewGroup, localu1, localu2);
            l2 = l1;
            if (localAnimator == null) {
              break label493;
            }
            localObject2 = null;
            if (localu2 == null) {
              break label528;
            }
            localObject1 = localu2.view;
            String[] arrayOfString = getTransitionProperties();
            paramv1 = (v)localObject2;
            if (localObject1 == null) {
              break label515;
            }
            paramv1 = (v)localObject2;
            if (arrayOfString == null) {
              break label515;
            }
            paramv1 = (v)localObject2;
            if (arrayOfString.length <= 0) {
              break label515;
            }
            paramv1 = new u();
            paramv1.view = ((View)localObject1);
            localObject2 = (u)paramv2.Bf.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            j = 0;
            while (j < arrayOfString.length)
            {
              paramv1.values.put(arrayOfString[j], ((u)localObject2).values.get(arrayOfString[j]));
              j += 1;
            }
          }
          int m = locala.size();
          j = 0;
          if (j >= m) {
            break label515;
          }
          localObject2 = (a)locala.get((Animator)locala.keyAt(j));
          if ((((a)localObject2).AK == null) || (((a)localObject2).mView != localObject1) || (!((a)localObject2).mName.equals(this.mName)) || (!((a)localObject2).AK.equals(paramv1))) {
            break label506;
          }
          localAnimator = null;
          localObject2 = localObject1;
          localObject1 = paramv1;
          paramv1 = (v)localObject2;
        }
        for (;;)
        {
          l2 = l1;
          if (localAnimator != null)
          {
            l2 = l1;
            if (this.AE != null)
            {
              l2 = this.AE.a(paramViewGroup, this, localu1, localu2);
              localSparseIntArray.put(this.vd.size(), (int)l2);
              l2 = Math.min(l2, l1);
            }
            locala.put(localAnimator, new a(paramv1, this.mName, this, ag.N(paramViewGroup), (u)localObject1));
            this.vd.add(localAnimator);
          }
          label493:
          i += 1;
          l1 = l2;
          break;
          label506:
          j += 1;
          break label312;
          localObject2 = paramv1;
          paramv1 = (v)localObject1;
          localObject1 = localObject2;
          continue;
          paramv1 = localu1.view;
          localObject1 = null;
        }
        if (l1 != 0L)
        {
          i = 0;
          while (i < localSparseIntArray.size())
          {
            j = localSparseIntArray.keyAt(i);
            paramViewGroup = (Animator)this.vd.get(j);
            paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i) - l1 + paramViewGroup.getStartDelay());
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  public boolean a(u paramu1, u paramu2)
  {
    if ((paramu1 != null) && (paramu2 != null))
    {
      Object localObject = getTransitionProperties();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (a(paramu1, paramu2, localObject[i])) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      localObject = paramu1.values.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramu1, paramu2, (String)((Iterator)localObject).next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Transition b(TimeInterpolator paramTimeInterpolator)
  {
    this.Ag = paramTimeInterpolator;
    return this;
  }
  
  public Transition b(c paramc)
  {
    if (this.mListeners == null) {}
    do
    {
      return this;
      this.mListeners.remove(paramc);
    } while (this.mListeners.size() != 0);
    this.mListeners = null;
    return this;
  }
  
  public final u b(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).Au != null; localObject = ((Transition)localObject).Au) {}
    if (paramBoolean) {}
    for (localObject = ((Transition)localObject).As;; localObject = ((Transition)localObject).At) {
      return (u)((v)localObject).Bf.get(paramView);
    }
  }
  
  public abstract void b(u paramu);
  
  final void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int k = 0;
    B(paramBoolean);
    int i;
    Object localObject1;
    Object localObject2;
    if (((this.Ah.size() > 0) || (this.Ai.size() > 0)) && ((this.Aj == null) || (this.Aj.isEmpty())) && ((this.Ak == null) || (this.Ak.isEmpty())))
    {
      i = 0;
      if (i < this.Ah.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.Ah.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new u();
          ((u)localObject2).view = ((View)localObject1);
          if (!paramBoolean) {
            break label164;
          }
          a((u)localObject2);
          label126:
          ((u)localObject2).Be.add(this);
          d((u)localObject2);
          if (!paramBoolean) {
            break label173;
          }
          a(this.As, (View)localObject1, (u)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          label164:
          b((u)localObject2);
          break label126;
          label173:
          a(this.At, (View)localObject1, (u)localObject2);
        }
      }
      i = 0;
      if (i < this.Ai.size())
      {
        paramViewGroup = (View)this.Ai.get(i);
        localObject1 = new u();
        ((u)localObject1).view = paramViewGroup;
        if (paramBoolean)
        {
          a((u)localObject1);
          label237:
          ((u)localObject1).Be.add(this);
          d((u)localObject1);
          if (!paramBoolean) {
            break label283;
          }
          a(this.As, paramViewGroup, (u)localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          b((u)localObject1);
          break label237;
          label283:
          a(this.At, paramViewGroup, (u)localObject1);
        }
      }
    }
    else
    {
      a(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.AG != null))
    {
      int m = this.AG.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.AG.keyAt(i);
        paramViewGroup.add(this.As.Bi.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.AG.valueAt(j);
          this.As.Bi.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  final u c(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).Au != null; localObject = ((Transition)localObject).Au) {}
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = ((Transition)localObject).Aw;
      if (localArrayList != null) {
        break label49;
      }
    }
    label49:
    int i;
    u localu;
    do
    {
      return null;
      localArrayList = ((Transition)localObject).Ax;
      break;
      int j = localArrayList.size();
      i = 0;
      if (i >= j) {
        break label135;
      }
      localu = (u)localArrayList.get(i);
    } while (localu == null);
    if (localu.view == paramView) {}
    for (;;)
    {
      if (i >= 0) {
        if (paramBoolean) {
          paramView = ((Transition)localObject).Ax;
        }
      }
      label103:
      for (paramView = (u)paramView.get(i);; paramView = null)
      {
        return paramView;
        i += 1;
        break;
        paramView = ((Transition)localObject).Aw;
        break label103;
      }
      label135:
      i = -1;
    }
  }
  
  void d(u paramu)
  {
    int j = 0;
    String[] arrayOfString;
    if ((this.AE != null) && (!paramu.values.isEmpty()))
    {
      arrayOfString = this.AE.getPropagationProperties();
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
        if (paramu.values.containsKey(arrayOfString[i])) {}
      }
      for (i = j;; i = 1)
      {
        if (i != 0) {
          break label86;
        }
        this.AE.c(paramu);
        return;
        i += 1;
        break;
      }
    }
  }
  
  protected void dw()
  {
    start();
    final a locala = dv();
    Iterator localIterator = this.vd.iterator();
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
              Transition.this.AA.remove(paramAnonymousAnimator);
            }
            
            public final void onAnimationStart(Animator paramAnonymousAnimator)
            {
              Transition.this.AA.add(paramAnonymousAnimator);
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
            if (this.Af >= 0L) {
              localAnimator.setStartDelay(this.Af);
            }
            if (this.Ag != null) {
              localAnimator.setInterpolator(this.Ag);
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
    this.vd.clear();
    end();
  }
  
  public Transition dx()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.vd = new ArrayList();
      localTransition.As = new v();
      localTransition.At = new v();
      localTransition.Aw = null;
      localTransition.Ax = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  protected final void end()
  {
    this.AB -= 1;
    if (this.AB == 0)
    {
      Object localObject;
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        localObject = (ArrayList)this.mListeners.clone();
        int j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((c)((ArrayList)localObject).get(i)).a(this);
          i += 1;
        }
      }
      int i = 0;
      while (i < this.As.Bh.size())
      {
        localObject = (View)this.As.Bh.valueAt(i);
        if (localObject != null) {
          t.d((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.At.Bh.size())
      {
        localObject = (View)this.At.Bh.valueAt(i);
        if (localObject != null) {
          t.d((View)localObject, false);
        }
        i += 1;
      }
      this.AD = true;
    }
  }
  
  public Transition f(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public Transition g(long paramLong)
  {
    this.Af = paramLong;
    return this;
  }
  
  public final Rect getEpicenter()
  {
    if (this.AF == null) {
      return null;
    }
    return this.AF.dr();
  }
  
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  protected final void start()
  {
    if (this.AB == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((c)localArrayList.get(i)).ds();
          i += 1;
        }
      }
      this.AD = false;
    }
    this.AB += 1;
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
    if (this.Af != -1L) {
      str = paramString + "dly(" + this.Af + ") ";
    }
    paramString = str;
    if (this.Ag != null) {
      paramString = str + "interp(" + this.Ag + ") ";
    }
    if (this.Ah.size() <= 0)
    {
      str = paramString;
      if (this.Ai.size() <= 0) {}
    }
    else
    {
      str = paramString + "tgts(";
      paramString = str;
      int i;
      if (this.Ah.size() > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= this.Ah.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + this.Ah.get(i);
          i += 1;
        }
      }
      str = paramString;
      if (this.Ai.size() > 0)
      {
        i = j;
        for (;;)
        {
          str = paramString;
          if (i >= this.Ai.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + this.Ai.get(i);
          i += 1;
        }
      }
      str = str + ")";
    }
    return str;
  }
  
  static final class a
  {
    u AK;
    ao AL;
    Transition AM;
    String mName;
    View mView;
    
    a(View paramView, String paramString, Transition paramTransition, ao paramao, u paramu)
    {
      this.mView = paramView;
      this.mName = paramString;
      this.AK = paramu;
      this.AL = paramao;
      this.AM = paramTransition;
    }
  }
  
  public static abstract class b
  {
    public abstract Rect dr();
  }
  
  public static abstract interface c
  {
    public abstract void a(Transition paramTransition);
    
    public abstract void dn();
    
    public abstract void jdMethod_do();
    
    public abstract void ds();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.Transition
 * JD-Core Version:    0.7.0.1
 */