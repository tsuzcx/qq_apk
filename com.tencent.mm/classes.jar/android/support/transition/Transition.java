package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.support.v4.f.f;
import android.support.v4.view.q;
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
  private static final int[] rM = { 2, 1, 3, 4 };
  private static final PathMotion rN = new Transition.1();
  private static ThreadLocal<android.support.v4.f.a<Animator, Transition.a>> sj = new ThreadLocal();
  long mDuration = -1L;
  private ArrayList<Animator> mG = new ArrayList();
  private ArrayList<Transition.c> mListeners = null;
  private String mName = getClass().getName();
  long rO = -1L;
  private TimeInterpolator rP = null;
  ArrayList<Integer> rQ = new ArrayList();
  ArrayList<View> rR = new ArrayList();
  ArrayList<String> rS = null;
  ArrayList<Class> rT = null;
  private ArrayList<Integer> rU = null;
  private ArrayList<View> rV = null;
  private ArrayList<Class> rW = null;
  private ArrayList<String> rX = null;
  private ArrayList<Integer> rY = null;
  private ArrayList<View> rZ = null;
  private ViewGroup rq = null;
  private ArrayList<Class> sa = null;
  private aj sc = new aj();
  private aj sd = new aj();
  TransitionSet se = null;
  private int[] sf = rM;
  private ArrayList<ai> sg;
  private ArrayList<ai> si;
  boolean sk = false;
  private ArrayList<Animator> sl = new ArrayList();
  private int sm = 0;
  private boolean sn = false;
  private boolean so = false;
  ag sp;
  private Transition.b sq;
  private android.support.v4.f.a<String, String> sr;
  PathMotion ss = rN;
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ad.rD);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = android.support.v4.content.a.c.a(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      g(l);
    }
    l = android.support.v4.content.a.c.a(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      h(l);
    }
    int i = android.support.v4.content.a.c.a(localTypedArray, paramAttributeSet, "interpolator", 0);
    if (i > 0) {
      a(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = android.support.v4.content.a.c.b(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      setMatchOrder(E(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private static int[] E(String paramString)
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
            break label137;
          }
          localObject = new int[paramString.length - 1];
          System.arraycopy(paramString, 0, localObject, 0, i);
          i -= 1;
          paramString = (String)localObject;
        }
      }
      label137:
      throw new InflateException("Unknown match type in matchOrder: '" + (String)localObject + "'");
    }
    return paramString;
  }
  
  private void a(aj paramaj1, aj paramaj2)
  {
    android.support.v4.f.a locala2 = new android.support.v4.f.a(paramaj1.sN);
    android.support.v4.f.a locala1 = new android.support.v4.f.a(paramaj2.sN);
    int i = 0;
    if (i < this.sf.length)
    {
      switch (this.sf[i])
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
          if ((localObject1 != null) && (z((View)localObject1)))
          {
            localObject1 = (ai)locala1.remove(localObject1);
            if ((localObject1 != null) && (((ai)localObject1).view != null) && (z(((ai)localObject1).view)))
            {
              localObject2 = (ai)locala2.removeAt(j);
              this.sg.add(localObject2);
              this.si.add(localObject1);
            }
          }
          j -= 1;
        }
        Object localObject1 = paramaj1.sQ;
        Object localObject2 = paramaj2.sQ;
        int k = ((android.support.v4.f.a)localObject1).size();
        j = 0;
        View localView1;
        View localView2;
        ai localai1;
        ai localai2;
        while (j < k)
        {
          localView1 = (View)((android.support.v4.f.a)localObject1).valueAt(j);
          if ((localView1 != null) && (z(localView1)))
          {
            localView2 = (View)((android.support.v4.f.a)localObject2).get(((android.support.v4.f.a)localObject1).keyAt(j));
            if ((localView2 != null) && (z(localView2)))
            {
              localai1 = (ai)locala2.get(localView1);
              localai2 = (ai)locala1.get(localView2);
              if ((localai1 != null) && (localai2 != null))
              {
                this.sg.add(localai1);
                this.si.add(localai2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramaj1.sO;
        localObject2 = paramaj2.sO;
        k = ((SparseArray)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((SparseArray)localObject1).valueAt(j);
          if ((localView1 != null) && (z(localView1)))
          {
            localView2 = (View)((SparseArray)localObject2).get(((SparseArray)localObject1).keyAt(j));
            if ((localView2 != null) && (z(localView2)))
            {
              localai1 = (ai)locala2.get(localView1);
              localai2 = (ai)locala1.get(localView2);
              if ((localai1 != null) && (localai2 != null))
              {
                this.sg.add(localai1);
                this.si.add(localai2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramaj1.sP;
        localObject2 = paramaj2.sP;
        k = ((f)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((f)localObject1).valueAt(j);
          if ((localView1 != null) && (z(localView1)))
          {
            localView2 = (View)((f)localObject2).get(((f)localObject1).keyAt(j));
            if ((localView2 != null) && (z(localView2)))
            {
              localai1 = (ai)locala2.get(localView1);
              localai2 = (ai)locala1.get(localView2);
              if ((localai1 != null) && (localai2 != null))
              {
                this.sg.add(localai1);
                this.si.add(localai2);
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
      paramaj1 = (ai)locala2.valueAt(i);
      if (z(paramaj1.view))
      {
        this.sg.add(paramaj1);
        this.si.add(null);
      }
      i += 1;
    }
    i = 0;
    while (i < locala1.size())
    {
      paramaj1 = (ai)locala1.valueAt(i);
      if (z(paramaj1.view))
      {
        this.si.add(paramaj1);
        this.sg.add(null);
      }
      i += 1;
    }
  }
  
  private static void a(aj paramaj, View paramView, ai paramai)
  {
    paramaj.sN.put(paramView, paramai);
    int i = paramView.getId();
    if (i >= 0)
    {
      if (paramaj.sO.indexOfKey(i) >= 0) {
        paramaj.sO.put(i, null);
      }
    }
    else
    {
      paramai = q.ab(paramView);
      if (paramai != null)
      {
        if (!paramaj.sQ.containsKey(paramai)) {
          break label187;
        }
        paramaj.sQ.put(paramai, null);
      }
    }
    long l;
    for (;;)
    {
      if ((paramView.getParent() instanceof ListView))
      {
        paramai = (ListView)paramView.getParent();
        if (paramai.getAdapter().hasStableIds())
        {
          l = paramai.getItemIdAtPosition(paramai.getPositionForView(paramView));
          paramai = paramaj.sP;
          if (paramai.Ef) {
            paramai.gc();
          }
          if (android.support.v4.f.c.a(paramai.Eg, paramai.mSize, l) < 0) {
            break label200;
          }
          paramView = (View)paramaj.sP.get(l);
          if (paramView != null)
          {
            q.d(paramView, false);
            paramaj.sP.put(l, null);
          }
        }
      }
      return;
      paramaj.sO.put(i, paramView);
      break;
      label187:
      paramaj.sQ.put(paramai, paramView);
    }
    label200:
    q.d(paramView, true);
    paramaj.sP.put(l, paramView);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j = paramView.getId();
      if (((this.rU == null) || (!this.rU.contains(Integer.valueOf(j)))) && ((this.rV == null) || (!this.rV.contains(paramView))))
      {
        if (this.rW != null)
        {
          int k = this.rW.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label100;
            }
            if (((Class)this.rW.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label100:
        ai localai;
        if ((paramView.getParent() instanceof ViewGroup))
        {
          localai = new ai();
          localai.view = paramView;
          if (!paramBoolean) {
            break label261;
          }
          a(localai);
          label135:
          localai.sM.add(this);
          d(localai);
          if (!paramBoolean) {
            break label270;
          }
          a(this.sc, paramView, localai);
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.rY != null) && (this.rY.contains(Integer.valueOf(j)))) || ((this.rZ != null) && (this.rZ.contains(paramView)))) {
            break label281;
          }
          if (this.sa == null) {
            break label283;
          }
          j = this.sa.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label283;
            }
            if (((Class)this.sa.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          label261:
          b(localai);
          break label135;
          label270:
          a(this.sd, paramView, localai);
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
  
  private static boolean a(ai paramai1, ai paramai2, String paramString)
  {
    paramai1 = paramai1.values.get(paramString);
    paramai2 = paramai2.values.get(paramString);
    if ((paramai1 != null) || (paramai2 != null))
    {
      if ((paramai1 == null) || (paramai2 == null)) {}
      while (!paramai1.equals(paramai2)) {
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
  
  private static android.support.v4.f.a<Animator, Transition.a> by()
  {
    android.support.v4.f.a locala2 = (android.support.v4.f.a)sj.get();
    android.support.v4.f.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new android.support.v4.f.a();
      sj.set(locala1);
    }
    return locala1;
  }
  
  private void setMatchOrder(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      this.sf = rM;
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
    this.sf = ((int[])paramVarArgs.clone());
  }
  
  public Transition A(View paramView)
  {
    this.rR.add(paramView);
    return this;
  }
  
  public Transition B(View paramView)
  {
    this.rR.remove(paramView);
    return this;
  }
  
  public void C(View paramView)
  {
    if (!this.so)
    {
      android.support.v4.f.a locala = by();
      int i = locala.size();
      paramView = av.G(paramView);
      i -= 1;
      while (i >= 0)
      {
        Transition.a locala1 = (Transition.a)locala.valueAt(i);
        if ((locala1.mView != null) && (paramView.equals(locala1.sx))) {
          a.b((Animator)locala.keyAt(i));
        }
        i -= 1;
      }
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        paramView = (ArrayList)this.mListeners.clone();
        int j = paramView.size();
        i = 0;
        while (i < j)
        {
          ((Transition.c)paramView.get(i)).bq();
          i += 1;
        }
      }
      this.sn = true;
    }
  }
  
  public void D(View paramView)
  {
    if (this.sn)
    {
      if (!this.so)
      {
        android.support.v4.f.a locala = by();
        int i = locala.size();
        paramView = av.G(paramView);
        i -= 1;
        while (i >= 0)
        {
          Transition.a locala1 = (Transition.a)locala.valueAt(i);
          if ((locala1.mView != null) && (paramView.equals(locala1.sx))) {
            a.c((Animator)locala.keyAt(i));
          }
          i -= 1;
        }
        if ((this.mListeners != null) && (this.mListeners.size() > 0))
        {
          paramView = (ArrayList)this.mListeners.clone();
          int j = paramView.size();
          i = 0;
          while (i < j)
          {
            ((Transition.c)paramView.get(i)).br();
            i += 1;
          }
        }
      }
      this.sn = false;
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, ai paramai1, ai paramai2)
  {
    return null;
  }
  
  public Transition a(TimeInterpolator paramTimeInterpolator)
  {
    this.rP = paramTimeInterpolator;
    return this;
  }
  
  public Transition a(Transition.c paramc)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramc);
    return this;
  }
  
  public void a(Transition.b paramb)
  {
    this.sq = paramb;
  }
  
  public void a(ag paramag)
  {
    this.sp = paramag;
  }
  
  public abstract void a(ai paramai);
  
  protected void a(ViewGroup paramViewGroup, aj paramaj1, aj paramaj2, ArrayList<ai> paramArrayList1, ArrayList<ai> paramArrayList2)
  {
    android.support.v4.f.a locala = by();
    long l1 = 9223372036854775807L;
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    int i = 0;
    ai localai1;
    ai localai2;
    if (i < k)
    {
      localai1 = (ai)paramArrayList1.get(i);
      localai2 = (ai)paramArrayList2.get(i);
      if ((localai1 == null) || (localai1.sM.contains(this))) {
        break label615;
      }
      localai1 = null;
    }
    label312:
    label615:
    for (;;)
    {
      if ((localai2 != null) && (!localai2.sM.contains(this))) {
        localai2 = null;
      }
      for (;;)
      {
        long l2;
        int j;
        Animator localAnimator;
        Object localObject2;
        Object localObject1;
        if (localai1 == null)
        {
          l2 = l1;
          if (localai2 == null) {}
        }
        else
        {
          if ((localai1 == null) || (localai2 == null) || (a(localai1, localai2))) {}
          for (j = 1;; j = 0)
          {
            l2 = l1;
            if (j == 0) {
              break label493;
            }
            localAnimator = a(paramViewGroup, localai1, localai2);
            l2 = l1;
            if (localAnimator == null) {
              break label493;
            }
            localObject2 = null;
            if (localai2 == null) {
              break label528;
            }
            localObject1 = localai2.view;
            String[] arrayOfString = getTransitionProperties();
            paramaj1 = (aj)localObject2;
            if (localObject1 == null) {
              break label515;
            }
            paramaj1 = (aj)localObject2;
            if (arrayOfString == null) {
              break label515;
            }
            paramaj1 = (aj)localObject2;
            if (arrayOfString.length <= 0) {
              break label515;
            }
            paramaj1 = new ai();
            paramaj1.view = ((View)localObject1);
            localObject2 = (ai)paramaj2.sN.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            j = 0;
            while (j < arrayOfString.length)
            {
              paramaj1.values.put(arrayOfString[j], ((ai)localObject2).values.get(arrayOfString[j]));
              j += 1;
            }
          }
          int m = locala.size();
          j = 0;
          if (j >= m) {
            break label515;
          }
          localObject2 = (Transition.a)locala.get((Animator)locala.keyAt(j));
          if ((((Transition.a)localObject2).sv == null) || (((Transition.a)localObject2).mView != localObject1) || (!((Transition.a)localObject2).mName.equals(this.mName)) || (!((Transition.a)localObject2).sv.equals(paramaj1))) {
            break label506;
          }
          localAnimator = null;
          localObject2 = localObject1;
          localObject1 = paramaj1;
          paramaj1 = (aj)localObject2;
        }
        for (;;)
        {
          l2 = l1;
          if (localAnimator != null)
          {
            l2 = l1;
            if (this.sp != null)
            {
              l2 = this.sp.a(paramViewGroup, this, localai1, localai2);
              localSparseIntArray.put(this.mG.size(), (int)l2);
              l2 = Math.min(l2, l1);
            }
            locala.put(localAnimator, new Transition.a(paramaj1, this.mName, this, av.G(paramViewGroup), (ai)localObject1));
            this.mG.add(localAnimator);
          }
          label493:
          i += 1;
          l1 = l2;
          break;
          label506:
          j += 1;
          break label312;
          localObject2 = paramaj1;
          paramaj1 = (aj)localObject1;
          localObject1 = localObject2;
          continue;
          paramaj1 = localai1.view;
          localObject1 = null;
        }
        if (l1 != 0L)
        {
          i = 0;
          while (i < localSparseIntArray.size())
          {
            j = localSparseIntArray.keyAt(i);
            paramViewGroup = (Animator)this.mG.get(j);
            paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i) - l1 + paramViewGroup.getStartDelay());
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  public boolean a(ai paramai1, ai paramai2)
  {
    if ((paramai1 != null) && (paramai2 != null))
    {
      Object localObject = getTransitionProperties();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (a(paramai1, paramai2, localObject[i])) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      localObject = paramai1.values.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramai1, paramai2, (String)((Iterator)localObject).next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Transition b(Transition.c paramc)
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
  
  public final ai b(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).se != null; localObject = ((Transition)localObject).se) {}
    if (paramBoolean) {}
    for (localObject = ((Transition)localObject).sc;; localObject = ((Transition)localObject).sd) {
      return (ai)((aj)localObject).sN.get(paramView);
    }
  }
  
  public abstract void b(ai paramai);
  
  final void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int k = 0;
    u(paramBoolean);
    int i;
    Object localObject1;
    Object localObject2;
    if (((this.rQ.size() > 0) || (this.rR.size() > 0)) && ((this.rS == null) || (this.rS.isEmpty())) && ((this.rT == null) || (this.rT.isEmpty())))
    {
      i = 0;
      if (i < this.rQ.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.rQ.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new ai();
          ((ai)localObject2).view = ((View)localObject1);
          if (!paramBoolean) {
            break label164;
          }
          a((ai)localObject2);
          label126:
          ((ai)localObject2).sM.add(this);
          d((ai)localObject2);
          if (!paramBoolean) {
            break label173;
          }
          a(this.sc, (View)localObject1, (ai)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          label164:
          b((ai)localObject2);
          break label126;
          label173:
          a(this.sd, (View)localObject1, (ai)localObject2);
        }
      }
      i = 0;
      if (i < this.rR.size())
      {
        paramViewGroup = (View)this.rR.get(i);
        localObject1 = new ai();
        ((ai)localObject1).view = paramViewGroup;
        if (paramBoolean)
        {
          a((ai)localObject1);
          label237:
          ((ai)localObject1).sM.add(this);
          d((ai)localObject1);
          if (!paramBoolean) {
            break label283;
          }
          a(this.sc, paramViewGroup, (ai)localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          b((ai)localObject1);
          break label237;
          label283:
          a(this.sd, paramViewGroup, (ai)localObject1);
        }
      }
    }
    else
    {
      a(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.sr != null))
    {
      int m = this.sr.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.sr.keyAt(i);
        paramViewGroup.add(this.sc.sQ.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.sr.valueAt(j);
          this.sc.sQ.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  public Transition bA()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.mG = new ArrayList();
      localTransition.sc = new aj();
      localTransition.sd = new aj();
      localTransition.sg = null;
      localTransition.si = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  protected void bz()
  {
    start();
    android.support.v4.f.a locala = by();
    Iterator localIterator = this.mG.iterator();
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
            if (this.rO >= 0L) {
              localAnimator.setStartDelay(this.rO);
            }
            if (this.rP != null) {
              localAnimator.setInterpolator(this.rP);
            }
            localAnimator.addListener(new Transition.3(this));
            localAnimator.start();
          }
        }
      }
    }
    this.mG.clear();
    end();
  }
  
  final ai c(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).se != null; localObject = ((Transition)localObject).se) {}
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = ((Transition)localObject).sg;
      if (localArrayList != null) {
        break label49;
      }
    }
    label49:
    int i;
    ai localai;
    do
    {
      return null;
      localArrayList = ((Transition)localObject).si;
      break;
      int j = localArrayList.size();
      i = 0;
      if (i >= j) {
        break label135;
      }
      localai = (ai)localArrayList.get(i);
    } while (localai == null);
    if (localai.view == paramView) {}
    for (;;)
    {
      if (i >= 0) {
        if (paramBoolean) {
          paramView = ((Transition)localObject).si;
        }
      }
      label103:
      for (paramView = (ai)paramView.get(i);; paramView = null)
      {
        return paramView;
        i += 1;
        break;
        paramView = ((Transition)localObject).sg;
        break label103;
      }
      label135:
      i = -1;
    }
  }
  
  final void c(ViewGroup paramViewGroup)
  {
    this.sg = new ArrayList();
    this.si = new ArrayList();
    a(this.sc, this.sd);
    android.support.v4.f.a locala = by();
    int i = locala.size();
    bf localbf = av.G(paramViewGroup);
    i -= 1;
    if (i >= 0)
    {
      Animator localAnimator = (Animator)locala.keyAt(i);
      int j;
      if (localAnimator != null)
      {
        Transition.a locala1 = (Transition.a)locala.get(localAnimator);
        if ((locala1 != null) && (locala1.mView != null) && (localbf.equals(locala1.sx)))
        {
          ai localai1 = locala1.sv;
          Object localObject = locala1.mView;
          ai localai2 = b((View)localObject, true);
          localObject = c((View)localObject, true);
          if (((localai2 == null) && (localObject == null)) || (!locala1.sy.a(localai1, (ai)localObject))) {
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
    a(paramViewGroup, this.sc, this.sd, this.sg, this.si);
    bz();
  }
  
  void d(ai paramai)
  {
    int j = 0;
    String[] arrayOfString;
    if ((this.sp != null) && (!paramai.values.isEmpty()))
    {
      arrayOfString = this.sp.getPropagationProperties();
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
        if (paramai.values.containsKey(arrayOfString[i])) {}
      }
      for (i = j;; i = 1)
      {
        if (i != 0) {
          break label86;
        }
        this.sp.c(paramai);
        return;
        i += 1;
        break;
      }
    }
  }
  
  protected final void end()
  {
    this.sm -= 1;
    if (this.sm == 0)
    {
      Object localObject;
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        localObject = (ArrayList)this.mListeners.clone();
        int j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((Transition.c)((ArrayList)localObject).get(i)).a(this);
          i += 1;
        }
      }
      int i = 0;
      while (i < this.sc.sP.size())
      {
        localObject = (View)this.sc.sP.valueAt(i);
        if (localObject != null) {
          q.d((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.sd.sP.size())
      {
        localObject = (View)this.sd.sP.valueAt(i);
        if (localObject != null) {
          q.d((View)localObject, false);
        }
        i += 1;
      }
      this.so = true;
    }
  }
  
  public Transition g(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public final Rect getEpicenter()
  {
    if (this.sq == null) {
      return null;
    }
    return this.sq.bu();
  }
  
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  public Transition h(long paramLong)
  {
    this.rO = paramLong;
    return this;
  }
  
  protected final void start()
  {
    if (this.sm == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((Transition.c)localArrayList.get(i)).bv();
          i += 1;
        }
      }
      this.so = false;
    }
    this.sm += 1;
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
    if (this.rO != -1L) {
      str = paramString + "dly(" + this.rO + ") ";
    }
    paramString = str;
    if (this.rP != null) {
      paramString = str + "interp(" + this.rP + ") ";
    }
    if (this.rQ.size() <= 0)
    {
      str = paramString;
      if (this.rR.size() <= 0) {}
    }
    else
    {
      str = paramString + "tgts(";
      paramString = str;
      int i;
      if (this.rQ.size() > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= this.rQ.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + this.rQ.get(i);
          i += 1;
        }
      }
      str = paramString;
      if (this.rR.size() > 0)
      {
        i = j;
        for (;;)
        {
          str = paramString;
          if (i >= this.rR.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + this.rR.get(i);
          i += 1;
        }
      }
      str = str + ")";
    }
    return str;
  }
  
  final void u(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sc.sN.clear();
      this.sc.sO.clear();
      this.sc.sP.clear();
      return;
    }
    this.sd.sN.clear();
    this.sd.sO.clear();
    this.sd.sP.clear();
  }
  
  final boolean z(View paramView)
  {
    int j = paramView.getId();
    if ((this.rU != null) && (this.rU.contains(Integer.valueOf(j)))) {}
    for (;;)
    {
      return false;
      if ((this.rV == null) || (!this.rV.contains(paramView)))
      {
        int i;
        if (this.rW != null)
        {
          int k = this.rW.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label95;
            }
            if (((Class)this.rW.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label95:
        if ((this.rX == null) || (q.ab(paramView) == null) || (!this.rX.contains(q.ab(paramView))))
        {
          if ((this.rQ.size() == 0) && (this.rR.size() == 0) && ((this.rT == null) || (this.rT.isEmpty())) && ((this.rS == null) || (this.rS.isEmpty()))) {
            return true;
          }
          if ((this.rQ.contains(Integer.valueOf(j))) || (this.rR.contains(paramView))) {
            return true;
          }
          if ((this.rS != null) && (this.rS.contains(q.ab(paramView)))) {
            return true;
          }
          if (this.rT != null)
          {
            i = 0;
            while (i < this.rT.size())
            {
              if (((Class)this.rT.get(i)).isInstance(paramView)) {
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.Transition
 * JD-Core Version:    0.7.0.1
 */