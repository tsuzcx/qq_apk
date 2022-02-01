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
  private static ThreadLocal<a<Animator, a>> zA = new ThreadLocal();
  private static final int[] zd = { 2, 1, 3, 4 };
  private static final PathMotion ze = new PathMotion()
  {
    public final Path getPath(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramAnonymousFloat1, paramAnonymousFloat2);
      localPath.lineTo(paramAnonymousFloat3, paramAnonymousFloat4);
      return localPath;
    }
  };
  long mDuration = -1L;
  private ArrayList<c> mListeners = null;
  private String mName = getClass().getName();
  private ArrayList<Animator> ud = new ArrayList();
  private ViewGroup yH = null;
  boolean zB = false;
  ArrayList<Animator> zC = new ArrayList();
  private int zD = 0;
  private boolean zE = false;
  private boolean zF = false;
  s zG;
  b zH;
  private a<String, String> zI;
  PathMotion zJ = ze;
  long zf = -1L;
  TimeInterpolator zg = null;
  ArrayList<Integer> zi = new ArrayList();
  ArrayList<View> zj = new ArrayList();
  ArrayList<String> zk = null;
  ArrayList<Class> zl = null;
  private ArrayList<Integer> zm = null;
  private ArrayList<View> zn = null;
  private ArrayList<Class> zo = null;
  private ArrayList<String> zp = null;
  private ArrayList<Integer> zq = null;
  private ArrayList<View> zr = null;
  private ArrayList<Class> zt = null;
  private v zu = new v();
  private v zv = new v();
  TransitionSet zw = null;
  private int[] zx = zd;
  private ArrayList<u> zy;
  private ArrayList<u> zz;
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, p.yU);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = android.support.v4.content.a.g.a(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      d(l);
    }
    l = android.support.v4.content.a.g.a(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      e(l);
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
  
  private void a(v paramv1, v paramv2)
  {
    a locala2 = new a(paramv1.Ah);
    a locala1 = new a(paramv2.Ah);
    int i = 0;
    if (i < this.zx.length)
    {
      switch (this.zx[i])
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
              this.zy.add(localObject2);
              this.zz.add(localObject1);
            }
          }
          j -= 1;
        }
        Object localObject1 = paramv1.Ak;
        Object localObject2 = paramv2.Ak;
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
                this.zy.add(localu1);
                this.zz.add(localu2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramv1.Ai;
        localObject2 = paramv2.Ai;
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
                this.zy.add(localu1);
                this.zz.add(localu2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramv1.Aj;
        localObject2 = paramv2.Aj;
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
                this.zy.add(localu1);
                this.zz.add(localu2);
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
        this.zy.add(paramv1);
        this.zz.add(null);
      }
      i += 1;
    }
    i = 0;
    while (i < locala1.size())
    {
      paramv1 = (u)locala1.valueAt(i);
      if (G(paramv1.view))
      {
        this.zz.add(paramv1);
        this.zy.add(null);
      }
      i += 1;
    }
  }
  
  private static void a(v paramv, View paramView, u paramu)
  {
    paramv.Ah.put(paramView, paramu);
    int i = paramView.getId();
    if (i >= 0)
    {
      if (paramv.Ai.indexOfKey(i) >= 0) {
        paramv.Ai.put(i, null);
      }
    }
    else
    {
      paramu = t.an(paramView);
      if (paramu != null)
      {
        if (!paramv.Ak.containsKey(paramu)) {
          break label168;
        }
        paramv.Ak.put(paramu, null);
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
          if (paramv.Aj.indexOfKey(l) < 0) {
            break label181;
          }
          paramView = (View)paramv.Aj.get(l, null);
          if (paramView != null)
          {
            t.d(paramView, false);
            paramv.Aj.put(l, null);
          }
        }
      }
      return;
      paramv.Ai.put(i, paramView);
      break;
      label168:
      paramv.Ak.put(paramu, paramView);
    }
    label181:
    t.d(paramView, true);
    paramv.Aj.put(l, paramView);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j = paramView.getId();
      if (((this.zm == null) || (!this.zm.contains(Integer.valueOf(j)))) && ((this.zn == null) || (!this.zn.contains(paramView))))
      {
        if (this.zo != null)
        {
          int k = this.zo.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label100;
            }
            if (((Class)this.zo.get(i)).isInstance(paramView)) {
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
          localu.Ag.add(this);
          d(localu);
          if (!paramBoolean) {
            break label270;
          }
          a(this.zu, paramView, localu);
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.zq != null) && (this.zq.contains(Integer.valueOf(j)))) || ((this.zr != null) && (this.zr.contains(paramView)))) {
            break label281;
          }
          if (this.zt == null) {
            break label283;
          }
          j = this.zt.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label283;
            }
            if (((Class)this.zt.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          label261:
          b(localu);
          break label135;
          label270:
          a(this.zv, paramView, localu);
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
  
  private static a<Animator, a> jdMethod_do()
  {
    a locala2 = (a)zA.get();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      zA.set(locala1);
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
      this.zx = zd;
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
    this.zx = ((int[])paramVarArgs.clone());
  }
  
  final void B(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.zu.Ah.clear();
      this.zu.Ai.clear();
      this.zu.Aj.clear();
      return;
    }
    this.zv.Ah.clear();
    this.zv.Ai.clear();
    this.zv.Aj.clear();
  }
  
  final boolean G(View paramView)
  {
    int j = paramView.getId();
    if ((this.zm != null) && (this.zm.contains(Integer.valueOf(j)))) {}
    for (;;)
    {
      return false;
      if ((this.zn == null) || (!this.zn.contains(paramView)))
      {
        int i;
        if (this.zo != null)
        {
          int k = this.zo.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label95;
            }
            if (((Class)this.zo.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label95:
        if ((this.zp == null) || (t.an(paramView) == null) || (!this.zp.contains(t.an(paramView))))
        {
          if ((this.zi.size() == 0) && (this.zj.size() == 0) && ((this.zl == null) || (this.zl.isEmpty())) && ((this.zk == null) || (this.zk.isEmpty()))) {
            return true;
          }
          if ((this.zi.contains(Integer.valueOf(j))) || (this.zj.contains(paramView))) {
            return true;
          }
          if ((this.zk != null) && (this.zk.contains(t.an(paramView)))) {
            return true;
          }
          if (this.zl != null)
          {
            i = 0;
            while (i < this.zl.size())
            {
              if (((Class)this.zl.get(i)).isInstance(paramView)) {
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
    this.zj.add(paramView);
    return this;
  }
  
  public Transition I(View paramView)
  {
    this.zj.remove(paramView);
    return this;
  }
  
  public void J(View paramView)
  {
    int k = 0;
    if (!this.zF)
    {
      a locala = jdMethod_do();
      int i = locala.size();
      paramView = ag.N(paramView);
      i -= 1;
      label96:
      int j;
      if (i >= 0)
      {
        Object localObject = (a)locala.valueAt(i);
        if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).zN)))
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
          ((c)paramView.get(i)).dg();
          i += 1;
        }
      }
      this.zE = true;
    }
  }
  
  public void K(View paramView)
  {
    if (this.zE)
    {
      if (!this.zF)
      {
        a locala = jdMethod_do();
        int i = locala.size();
        paramView = ag.N(paramView);
        i -= 1;
        label100:
        int j;
        if (i >= 0)
        {
          Object localObject = (a)locala.valueAt(i);
          if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).zN)))
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
            ((c)paramView.get(i)).dh();
            i += 1;
          }
        }
      }
      this.zE = false;
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
      this.zJ = ze;
      return;
    }
    this.zJ = paramPathMotion;
  }
  
  public void a(b paramb)
  {
    this.zH = paramb;
  }
  
  public void a(s params)
  {
    this.zG = params;
  }
  
  public abstract void a(u paramu);
  
  final void a(ViewGroup paramViewGroup)
  {
    this.zy = new ArrayList();
    this.zz = new ArrayList();
    a(this.zu, this.zv);
    a locala = jdMethod_do();
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
        if ((locala1 != null) && (locala1.mView != null) && (localao.equals(locala1.zN)))
        {
          u localu1 = locala1.zM;
          Object localObject = locala1.mView;
          u localu2 = b((View)localObject, true);
          localObject = c((View)localObject, true);
          if (((localu2 == null) && (localObject == null)) || (!locala1.zO.a(localu1, (u)localObject))) {
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
    a(paramViewGroup, this.zu, this.zv, this.zy, this.zz);
    dp();
  }
  
  protected void a(ViewGroup paramViewGroup, v paramv1, v paramv2, ArrayList<u> paramArrayList1, ArrayList<u> paramArrayList2)
  {
    a locala = jdMethod_do();
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
      if ((localu1 == null) || (localu1.Ag.contains(this))) {
        break label615;
      }
      localu1 = null;
    }
    label312:
    label615:
    for (;;)
    {
      if ((localu2 != null) && (!localu2.Ag.contains(this))) {
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
            localObject2 = (u)paramv2.Ah.get(localObject1);
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
          if ((((a)localObject2).zM == null) || (((a)localObject2).mView != localObject1) || (!((a)localObject2).mName.equals(this.mName)) || (!((a)localObject2).zM.equals(paramv1))) {
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
            if (this.zG != null)
            {
              l2 = this.zG.a(paramViewGroup, this, localu1, localu2);
              localSparseIntArray.put(this.ud.size(), (int)l2);
              l2 = Math.min(l2, l1);
            }
            locala.put(localAnimator, new a(paramv1, this.mName, this, ag.N(paramViewGroup), (u)localObject1));
            this.ud.add(localAnimator);
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
            paramViewGroup = (Animator)this.ud.get(j);
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
    this.zg = paramTimeInterpolator;
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
    for (Object localObject = this; ((Transition)localObject).zw != null; localObject = ((Transition)localObject).zw) {}
    if (paramBoolean) {}
    for (localObject = ((Transition)localObject).zu;; localObject = ((Transition)localObject).zv) {
      return (u)((v)localObject).Ah.get(paramView);
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
    if (((this.zi.size() > 0) || (this.zj.size() > 0)) && ((this.zk == null) || (this.zk.isEmpty())) && ((this.zl == null) || (this.zl.isEmpty())))
    {
      i = 0;
      if (i < this.zi.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.zi.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new u();
          ((u)localObject2).view = ((View)localObject1);
          if (!paramBoolean) {
            break label164;
          }
          a((u)localObject2);
          label126:
          ((u)localObject2).Ag.add(this);
          d((u)localObject2);
          if (!paramBoolean) {
            break label173;
          }
          a(this.zu, (View)localObject1, (u)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          label164:
          b((u)localObject2);
          break label126;
          label173:
          a(this.zv, (View)localObject1, (u)localObject2);
        }
      }
      i = 0;
      if (i < this.zj.size())
      {
        paramViewGroup = (View)this.zj.get(i);
        localObject1 = new u();
        ((u)localObject1).view = paramViewGroup;
        if (paramBoolean)
        {
          a((u)localObject1);
          label237:
          ((u)localObject1).Ag.add(this);
          d((u)localObject1);
          if (!paramBoolean) {
            break label283;
          }
          a(this.zu, paramViewGroup, (u)localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          b((u)localObject1);
          break label237;
          label283:
          a(this.zv, paramViewGroup, (u)localObject1);
        }
      }
    }
    else
    {
      a(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.zI != null))
    {
      int m = this.zI.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.zI.keyAt(i);
        paramViewGroup.add(this.zu.Ak.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.zI.valueAt(j);
          this.zu.Ak.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  final u c(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).zw != null; localObject = ((Transition)localObject).zw) {}
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = ((Transition)localObject).zy;
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
      localArrayList = ((Transition)localObject).zz;
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
          paramView = ((Transition)localObject).zz;
        }
      }
      label103:
      for (paramView = (u)paramView.get(i);; paramView = null)
      {
        return paramView;
        i += 1;
        break;
        paramView = ((Transition)localObject).zy;
        break label103;
      }
      label135:
      i = -1;
    }
  }
  
  public Transition d(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  void d(u paramu)
  {
    int j = 0;
    String[] arrayOfString;
    if ((this.zG != null) && (!paramu.values.isEmpty()))
    {
      arrayOfString = this.zG.getPropagationProperties();
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
        this.zG.c(paramu);
        return;
        i += 1;
        break;
      }
    }
  }
  
  protected void dp()
  {
    start();
    final a locala = jdMethod_do();
    Iterator localIterator = this.ud.iterator();
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
              Transition.this.zC.remove(paramAnonymousAnimator);
            }
            
            public final void onAnimationStart(Animator paramAnonymousAnimator)
            {
              Transition.this.zC.add(paramAnonymousAnimator);
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
            if (this.zf >= 0L) {
              localAnimator.setStartDelay(this.zf);
            }
            if (this.zg != null) {
              localAnimator.setInterpolator(this.zg);
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
    this.ud.clear();
    end();
  }
  
  public Transition dq()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.ud = new ArrayList();
      localTransition.zu = new v();
      localTransition.zv = new v();
      localTransition.zy = null;
      localTransition.zz = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public Transition e(long paramLong)
  {
    this.zf = paramLong;
    return this;
  }
  
  protected final void end()
  {
    this.zD -= 1;
    if (this.zD == 0)
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
      while (i < this.zu.Aj.size())
      {
        localObject = (View)this.zu.Aj.valueAt(i);
        if (localObject != null) {
          t.d((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.zv.Aj.size())
      {
        localObject = (View)this.zv.Aj.valueAt(i);
        if (localObject != null) {
          t.d((View)localObject, false);
        }
        i += 1;
      }
      this.zF = true;
    }
  }
  
  public final Rect getEpicenter()
  {
    if (this.zH == null) {
      return null;
    }
    return this.zH.dk();
  }
  
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  protected final void start()
  {
    if (this.zD == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((c)localArrayList.get(i)).dl();
          i += 1;
        }
      }
      this.zF = false;
    }
    this.zD += 1;
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
    if (this.zf != -1L) {
      str = paramString + "dly(" + this.zf + ") ";
    }
    paramString = str;
    if (this.zg != null) {
      paramString = str + "interp(" + this.zg + ") ";
    }
    if (this.zi.size() <= 0)
    {
      str = paramString;
      if (this.zj.size() <= 0) {}
    }
    else
    {
      str = paramString + "tgts(";
      paramString = str;
      int i;
      if (this.zi.size() > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= this.zi.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + this.zi.get(i);
          i += 1;
        }
      }
      str = paramString;
      if (this.zj.size() > 0)
      {
        i = j;
        for (;;)
        {
          str = paramString;
          if (i >= this.zj.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + this.zj.get(i);
          i += 1;
        }
      }
      str = str + ")";
    }
    return str;
  }
  
  static final class a
  {
    String mName;
    View mView;
    u zM;
    ao zN;
    Transition zO;
    
    a(View paramView, String paramString, Transition paramTransition, ao paramao, u paramu)
    {
      this.mView = paramView;
      this.mName = paramString;
      this.zM = paramu;
      this.zN = paramao;
      this.zO = paramTransition;
    }
  }
  
  public static abstract class b
  {
    public abstract Rect dk();
  }
  
  public static abstract interface c
  {
    public abstract void a(Transition paramTransition);
    
    public abstract void dg();
    
    public abstract void dh();
    
    public abstract void dl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Transition
 * JD-Core Version:    0.7.0.1
 */