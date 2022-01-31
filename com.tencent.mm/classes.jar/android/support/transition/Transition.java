package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.support.v4.content.a.g;
import android.support.v4.e.f;
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
  private static final int[] sN = { 2, 1, 3, 4 };
  private static final PathMotion sO = new Transition.1();
  private static ThreadLocal<android.support.v4.e.a<Animator, Transition.a>> ti = new ThreadLocal();
  long mDuration = -1L;
  private ArrayList<c> mListeners = null;
  private String mName = getClass().getName();
  private boolean mPaused = false;
  private ArrayList<Animator> nD = new ArrayList();
  long sP = -1L;
  private TimeInterpolator sQ = null;
  ArrayList<Integer> sR = new ArrayList();
  ArrayList<View> sS = new ArrayList();
  ArrayList<String> sT = null;
  ArrayList<Class> sU = null;
  private ArrayList<Integer> sV = null;
  private ArrayList<View> sW = null;
  private ArrayList<Class> sX = null;
  private ArrayList<String> sY = null;
  private ArrayList<Integer> sZ = null;
  private ViewGroup sq = null;
  private ArrayList<View> ta = null;
  private ArrayList<Class> tb = null;
  private ai tc = new ai();
  private ai td = new ai();
  TransitionSet te = null;
  private int[] tf = sN;
  private ArrayList<ah> tg;
  private ArrayList<ah> th;
  boolean tj = false;
  private ArrayList<Animator> tk = new ArrayList();
  private int tm = 0;
  private boolean tn = false;
  af to;
  private b tp;
  private android.support.v4.e.a<String, String> tq;
  PathMotion tt = sO;
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ac.sE);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = g.a(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      d(l);
    }
    l = g.a(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      e(l);
    }
    int i = g.b(localTypedArray, paramAttributeSet, "interpolator", 0);
    if (i > 0) {
      a(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = g.c(localTypedArray, paramAttributeSet, "matchOrder", 3);
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
  
  private void a(ai paramai1, ai paramai2)
  {
    android.support.v4.e.a locala2 = new android.support.v4.e.a(paramai1.tP);
    android.support.v4.e.a locala1 = new android.support.v4.e.a(paramai2.tP);
    int i = 0;
    if (i < this.tf.length)
    {
      switch (this.tf[i])
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
          if ((localObject1 != null) && (C((View)localObject1)))
          {
            localObject1 = (ah)locala1.remove(localObject1);
            if ((localObject1 != null) && (((ah)localObject1).view != null) && (C(((ah)localObject1).view)))
            {
              localObject2 = (ah)locala2.removeAt(j);
              this.tg.add(localObject2);
              this.th.add(localObject1);
            }
          }
          j -= 1;
        }
        Object localObject1 = paramai1.tS;
        Object localObject2 = paramai2.tS;
        int k = ((android.support.v4.e.a)localObject1).size();
        j = 0;
        View localView1;
        View localView2;
        ah localah1;
        ah localah2;
        while (j < k)
        {
          localView1 = (View)((android.support.v4.e.a)localObject1).valueAt(j);
          if ((localView1 != null) && (C(localView1)))
          {
            localView2 = (View)((android.support.v4.e.a)localObject2).get(((android.support.v4.e.a)localObject1).keyAt(j));
            if ((localView2 != null) && (C(localView2)))
            {
              localah1 = (ah)locala2.get(localView1);
              localah2 = (ah)locala1.get(localView2);
              if ((localah1 != null) && (localah2 != null))
              {
                this.tg.add(localah1);
                this.th.add(localah2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramai1.tQ;
        localObject2 = paramai2.tQ;
        k = ((SparseArray)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((SparseArray)localObject1).valueAt(j);
          if ((localView1 != null) && (C(localView1)))
          {
            localView2 = (View)((SparseArray)localObject2).get(((SparseArray)localObject1).keyAt(j));
            if ((localView2 != null) && (C(localView2)))
            {
              localah1 = (ah)locala2.get(localView1);
              localah2 = (ah)locala1.get(localView2);
              if ((localah1 != null) && (localah2 != null))
              {
                this.tg.add(localah1);
                this.th.add(localah2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramai1.tR;
        localObject2 = paramai2.tR;
        k = ((f)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((f)localObject1).valueAt(j);
          if ((localView1 != null) && (C(localView1)))
          {
            localView2 = (View)((f)localObject2).get(((f)localObject1).keyAt(j), null);
            if ((localView2 != null) && (C(localView2)))
            {
              localah1 = (ah)locala2.get(localView1);
              localah2 = (ah)locala1.get(localView2);
              if ((localah1 != null) && (localah2 != null))
              {
                this.tg.add(localah1);
                this.th.add(localah2);
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
      paramai1 = (ah)locala2.valueAt(i);
      if (C(paramai1.view))
      {
        this.tg.add(paramai1);
        this.th.add(null);
      }
      i += 1;
    }
    i = 0;
    while (i < locala1.size())
    {
      paramai1 = (ah)locala1.valueAt(i);
      if (C(paramai1.view))
      {
        this.th.add(paramai1);
        this.tg.add(null);
      }
      i += 1;
    }
  }
  
  private static void a(ai paramai, View paramView, ah paramah)
  {
    paramai.tP.put(paramView, paramah);
    int i = paramView.getId();
    if (i >= 0)
    {
      if (paramai.tQ.indexOfKey(i) >= 0) {
        paramai.tQ.put(i, null);
      }
    }
    else
    {
      paramah = t.ai(paramView);
      if (paramah != null)
      {
        if (!paramai.tS.containsKey(paramah)) {
          break label168;
        }
        paramai.tS.put(paramah, null);
      }
    }
    long l;
    for (;;)
    {
      if ((paramView.getParent() instanceof ListView))
      {
        paramah = (ListView)paramView.getParent();
        if (paramah.getAdapter().hasStableIds())
        {
          l = paramah.getItemIdAtPosition(paramah.getPositionForView(paramView));
          if (paramai.tR.indexOfKey(l) < 0) {
            break label181;
          }
          paramView = (View)paramai.tR.get(l, null);
          if (paramView != null)
          {
            t.d(paramView, false);
            paramai.tR.put(l, null);
          }
        }
      }
      return;
      paramai.tQ.put(i, paramView);
      break;
      label168:
      paramai.tS.put(paramah, paramView);
    }
    label181:
    t.d(paramView, true);
    paramai.tR.put(l, paramView);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j = paramView.getId();
      if (((this.sV == null) || (!this.sV.contains(Integer.valueOf(j)))) && ((this.sW == null) || (!this.sW.contains(paramView))))
      {
        if (this.sX != null)
        {
          int k = this.sX.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label100;
            }
            if (((Class)this.sX.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label100:
        ah localah;
        if ((paramView.getParent() instanceof ViewGroup))
        {
          localah = new ah();
          localah.view = paramView;
          if (!paramBoolean) {
            break label261;
          }
          a(localah);
          label135:
          localah.tO.add(this);
          d(localah);
          if (!paramBoolean) {
            break label270;
          }
          a(this.tc, paramView, localah);
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.sZ != null) && (this.sZ.contains(Integer.valueOf(j)))) || ((this.ta != null) && (this.ta.contains(paramView)))) {
            break label281;
          }
          if (this.tb == null) {
            break label283;
          }
          j = this.tb.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label283;
            }
            if (((Class)this.tb.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          label261:
          b(localah);
          break label135;
          label270:
          a(this.td, paramView, localah);
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
  
  private static boolean a(ah paramah1, ah paramah2, String paramString)
  {
    paramah1 = paramah1.values.get(paramString);
    paramah2 = paramah2.values.get(paramString);
    if ((paramah1 != null) || (paramah2 != null))
    {
      if ((paramah1 == null) || (paramah2 == null)) {}
      while (!paramah1.equals(paramah2)) {
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
  
  private static android.support.v4.e.a<Animator, Transition.a> cm()
  {
    android.support.v4.e.a locala2 = (android.support.v4.e.a)ti.get();
    android.support.v4.e.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new android.support.v4.e.a();
      ti.set(locala1);
    }
    return locala1;
  }
  
  private void setMatchOrder(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      this.tf = sN;
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
    this.tf = ((int[])paramVarArgs.clone());
  }
  
  final boolean C(View paramView)
  {
    int j = paramView.getId();
    if ((this.sV != null) && (this.sV.contains(Integer.valueOf(j)))) {}
    for (;;)
    {
      return false;
      if ((this.sW == null) || (!this.sW.contains(paramView)))
      {
        int i;
        if (this.sX != null)
        {
          int k = this.sX.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label95;
            }
            if (((Class)this.sX.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label95:
        if ((this.sY == null) || (t.ai(paramView) == null) || (!this.sY.contains(t.ai(paramView))))
        {
          if ((this.sR.size() == 0) && (this.sS.size() == 0) && ((this.sU == null) || (this.sU.isEmpty())) && ((this.sT == null) || (this.sT.isEmpty()))) {
            return true;
          }
          if ((this.sR.contains(Integer.valueOf(j))) || (this.sS.contains(paramView))) {
            return true;
          }
          if ((this.sT != null) && (this.sT.contains(t.ai(paramView)))) {
            return true;
          }
          if (this.sU != null)
          {
            i = 0;
            while (i < this.sU.size())
            {
              if (((Class)this.sU.get(i)).isInstance(paramView)) {
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  public Transition D(View paramView)
  {
    this.sS.add(paramView);
    return this;
  }
  
  public Transition E(View paramView)
  {
    this.sS.remove(paramView);
    return this;
  }
  
  public void F(View paramView)
  {
    if (!this.tn)
    {
      android.support.v4.e.a locala = cm();
      int i = locala.size();
      paramView = au.K(paramView);
      i -= 1;
      while (i >= 0)
      {
        Transition.a locala1 = (Transition.a)locala.valueAt(i);
        if ((locala1.mView != null) && (paramView.equals(locala1.tz))) {
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
          ((c)paramView.get(i)).ce();
          i += 1;
        }
      }
      this.mPaused = true;
    }
  }
  
  public void G(View paramView)
  {
    if (this.mPaused)
    {
      if (!this.tn)
      {
        android.support.v4.e.a locala = cm();
        int i = locala.size();
        paramView = au.K(paramView);
        i -= 1;
        while (i >= 0)
        {
          Transition.a locala1 = (Transition.a)locala.valueAt(i);
          if ((locala1.mView != null) && (paramView.equals(locala1.tz))) {
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
            ((c)paramView.get(i)).cf();
            i += 1;
          }
        }
      }
      this.mPaused = false;
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, ah paramah1, ah paramah2)
  {
    return null;
  }
  
  public Transition a(TimeInterpolator paramTimeInterpolator)
  {
    this.sQ = paramTimeInterpolator;
    return this;
  }
  
  public Transition a(c paramc)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramc);
    return this;
  }
  
  public void a(b paramb)
  {
    this.tp = paramb;
  }
  
  public void a(af paramaf)
  {
    this.to = paramaf;
  }
  
  public abstract void a(ah paramah);
  
  protected void a(ViewGroup paramViewGroup, ai paramai1, ai paramai2, ArrayList<ah> paramArrayList1, ArrayList<ah> paramArrayList2)
  {
    android.support.v4.e.a locala = cm();
    long l1 = 9223372036854775807L;
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    int i = 0;
    ah localah1;
    ah localah2;
    if (i < k)
    {
      localah1 = (ah)paramArrayList1.get(i);
      localah2 = (ah)paramArrayList2.get(i);
      if ((localah1 == null) || (localah1.tO.contains(this))) {
        break label615;
      }
      localah1 = null;
    }
    label312:
    label615:
    for (;;)
    {
      if ((localah2 != null) && (!localah2.tO.contains(this))) {
        localah2 = null;
      }
      for (;;)
      {
        long l2;
        int j;
        Animator localAnimator;
        Object localObject2;
        Object localObject1;
        if (localah1 == null)
        {
          l2 = l1;
          if (localah2 == null) {}
        }
        else
        {
          if ((localah1 == null) || (localah2 == null) || (a(localah1, localah2))) {}
          for (j = 1;; j = 0)
          {
            l2 = l1;
            if (j == 0) {
              break label493;
            }
            localAnimator = a(paramViewGroup, localah1, localah2);
            l2 = l1;
            if (localAnimator == null) {
              break label493;
            }
            localObject2 = null;
            if (localah2 == null) {
              break label528;
            }
            localObject1 = localah2.view;
            String[] arrayOfString = getTransitionProperties();
            paramai1 = (ai)localObject2;
            if (localObject1 == null) {
              break label515;
            }
            paramai1 = (ai)localObject2;
            if (arrayOfString == null) {
              break label515;
            }
            paramai1 = (ai)localObject2;
            if (arrayOfString.length <= 0) {
              break label515;
            }
            paramai1 = new ah();
            paramai1.view = ((View)localObject1);
            localObject2 = (ah)paramai2.tP.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            j = 0;
            while (j < arrayOfString.length)
            {
              paramai1.values.put(arrayOfString[j], ((ah)localObject2).values.get(arrayOfString[j]));
              j += 1;
            }
          }
          int m = locala.size();
          j = 0;
          if (j >= m) {
            break label515;
          }
          localObject2 = (Transition.a)locala.get((Animator)locala.keyAt(j));
          if ((((Transition.a)localObject2).tw == null) || (((Transition.a)localObject2).mView != localObject1) || (!((Transition.a)localObject2).mName.equals(this.mName)) || (!((Transition.a)localObject2).tw.equals(paramai1))) {
            break label506;
          }
          localAnimator = null;
          localObject2 = localObject1;
          localObject1 = paramai1;
          paramai1 = (ai)localObject2;
        }
        for (;;)
        {
          l2 = l1;
          if (localAnimator != null)
          {
            l2 = l1;
            if (this.to != null)
            {
              l2 = this.to.a(paramViewGroup, this, localah1, localah2);
              localSparseIntArray.put(this.nD.size(), (int)l2);
              l2 = Math.min(l2, l1);
            }
            locala.put(localAnimator, new Transition.a(paramai1, this.mName, this, au.K(paramViewGroup), (ah)localObject1));
            this.nD.add(localAnimator);
          }
          label493:
          i += 1;
          l1 = l2;
          break;
          label506:
          j += 1;
          break label312;
          localObject2 = paramai1;
          paramai1 = (ai)localObject1;
          localObject1 = localObject2;
          continue;
          paramai1 = localah1.view;
          localObject1 = null;
        }
        if (l1 != 0L)
        {
          i = 0;
          while (i < localSparseIntArray.size())
          {
            j = localSparseIntArray.keyAt(i);
            paramViewGroup = (Animator)this.nD.get(j);
            paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i) - l1 + paramViewGroup.getStartDelay());
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  public boolean a(ah paramah1, ah paramah2)
  {
    if ((paramah1 != null) && (paramah2 != null))
    {
      Object localObject = getTransitionProperties();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (a(paramah1, paramah2, localObject[i])) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      localObject = paramah1.values.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramah1, paramah2, (String)((Iterator)localObject).next())) {
          return true;
        }
      }
    }
    return false;
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
  
  public final ah b(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).te != null; localObject = ((Transition)localObject).te) {}
    if (paramBoolean) {}
    for (localObject = ((Transition)localObject).tc;; localObject = ((Transition)localObject).td) {
      return (ah)((ai)localObject).tP.get(paramView);
    }
  }
  
  public abstract void b(ah paramah);
  
  final void b(ViewGroup paramViewGroup)
  {
    this.tg = new ArrayList();
    this.th = new ArrayList();
    a(this.tc, this.td);
    android.support.v4.e.a locala = cm();
    int i = locala.size();
    be localbe = au.K(paramViewGroup);
    i -= 1;
    if (i >= 0)
    {
      Animator localAnimator = (Animator)locala.keyAt(i);
      int j;
      if (localAnimator != null)
      {
        Transition.a locala1 = (Transition.a)locala.get(localAnimator);
        if ((locala1 != null) && (locala1.mView != null) && (localbe.equals(locala1.tz)))
        {
          ah localah1 = locala1.tw;
          Object localObject = locala1.mView;
          ah localah2 = b((View)localObject, true);
          localObject = c((View)localObject, true);
          if (((localah2 == null) && (localObject == null)) || (!locala1.tA.a(localah1, (ah)localObject))) {
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
    a(paramViewGroup, this.tc, this.td, this.tg, this.th);
    cn();
  }
  
  final void b(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int k = 0;
    v(paramBoolean);
    int i;
    Object localObject1;
    Object localObject2;
    if (((this.sR.size() > 0) || (this.sS.size() > 0)) && ((this.sT == null) || (this.sT.isEmpty())) && ((this.sU == null) || (this.sU.isEmpty())))
    {
      i = 0;
      if (i < this.sR.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.sR.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new ah();
          ((ah)localObject2).view = ((View)localObject1);
          if (!paramBoolean) {
            break label164;
          }
          a((ah)localObject2);
          label126:
          ((ah)localObject2).tO.add(this);
          d((ah)localObject2);
          if (!paramBoolean) {
            break label173;
          }
          a(this.tc, (View)localObject1, (ah)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          label164:
          b((ah)localObject2);
          break label126;
          label173:
          a(this.td, (View)localObject1, (ah)localObject2);
        }
      }
      i = 0;
      if (i < this.sS.size())
      {
        paramViewGroup = (View)this.sS.get(i);
        localObject1 = new ah();
        ((ah)localObject1).view = paramViewGroup;
        if (paramBoolean)
        {
          a((ah)localObject1);
          label237:
          ((ah)localObject1).tO.add(this);
          d((ah)localObject1);
          if (!paramBoolean) {
            break label283;
          }
          a(this.tc, paramViewGroup, (ah)localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          b((ah)localObject1);
          break label237;
          label283:
          a(this.td, paramViewGroup, (ah)localObject1);
        }
      }
    }
    else
    {
      a(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.tq != null))
    {
      int m = this.tq.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.tq.keyAt(i);
        paramViewGroup.add(this.tc.tS.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.tq.valueAt(j);
          this.tc.tS.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  final ah c(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).te != null; localObject = ((Transition)localObject).te) {}
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = ((Transition)localObject).tg;
      if (localArrayList != null) {
        break label49;
      }
    }
    label49:
    int i;
    ah localah;
    do
    {
      return null;
      localArrayList = ((Transition)localObject).th;
      break;
      int j = localArrayList.size();
      i = 0;
      if (i >= j) {
        break label135;
      }
      localah = (ah)localArrayList.get(i);
    } while (localah == null);
    if (localah.view == paramView) {}
    for (;;)
    {
      if (i >= 0) {
        if (paramBoolean) {
          paramView = ((Transition)localObject).th;
        }
      }
      label103:
      for (paramView = (ah)paramView.get(i);; paramView = null)
      {
        return paramView;
        i += 1;
        break;
        paramView = ((Transition)localObject).tg;
        break label103;
      }
      label135:
      i = -1;
    }
  }
  
  protected void cn()
  {
    start();
    android.support.v4.e.a locala = cm();
    Iterator localIterator = this.nD.iterator();
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
            if (this.sP >= 0L) {
              localAnimator.setStartDelay(this.sP);
            }
            if (this.sQ != null) {
              localAnimator.setInterpolator(this.sQ);
            }
            localAnimator.addListener(new Transition.3(this));
            localAnimator.start();
          }
        }
      }
    }
    this.nD.clear();
    end();
  }
  
  public Transition co()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.nD = new ArrayList();
      localTransition.tc = new ai();
      localTransition.td = new ai();
      localTransition.tg = null;
      localTransition.th = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public Transition d(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  void d(ah paramah)
  {
    int j = 0;
    String[] arrayOfString;
    if ((this.to != null) && (!paramah.values.isEmpty()))
    {
      arrayOfString = this.to.getPropagationProperties();
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
        if (paramah.values.containsKey(arrayOfString[i])) {}
      }
      for (i = j;; i = 1)
      {
        if (i != 0) {
          break label86;
        }
        this.to.c(paramah);
        return;
        i += 1;
        break;
      }
    }
  }
  
  public Transition e(long paramLong)
  {
    this.sP = paramLong;
    return this;
  }
  
  protected final void end()
  {
    this.tm -= 1;
    if (this.tm == 0)
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
      while (i < this.tc.tR.size())
      {
        localObject = (View)this.tc.tR.valueAt(i);
        if (localObject != null) {
          t.d((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.td.tR.size())
      {
        localObject = (View)this.td.tR.valueAt(i);
        if (localObject != null) {
          t.d((View)localObject, false);
        }
        i += 1;
      }
      this.tn = true;
    }
  }
  
  public final Rect getEpicenter()
  {
    if (this.tp == null) {
      return null;
    }
    return this.tp.ci();
  }
  
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  protected final void start()
  {
    if (this.tm == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((c)localArrayList.get(i)).cj();
          i += 1;
        }
      }
      this.tn = false;
    }
    this.tm += 1;
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
    if (this.sP != -1L) {
      str = paramString + "dly(" + this.sP + ") ";
    }
    paramString = str;
    if (this.sQ != null) {
      paramString = str + "interp(" + this.sQ + ") ";
    }
    if (this.sR.size() <= 0)
    {
      str = paramString;
      if (this.sS.size() <= 0) {}
    }
    else
    {
      str = paramString + "tgts(";
      paramString = str;
      int i;
      if (this.sR.size() > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= this.sR.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + this.sR.get(i);
          i += 1;
        }
      }
      str = paramString;
      if (this.sS.size() > 0)
      {
        i = j;
        for (;;)
        {
          str = paramString;
          if (i >= this.sS.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + this.sS.get(i);
          i += 1;
        }
      }
      str = str + ")";
    }
    return str;
  }
  
  final void v(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.tc.tP.clear();
      this.tc.tQ.clear();
      this.tc.tR.clear();
      return;
    }
    this.td.tP.clear();
    this.td.tQ.clear();
    this.td.tR.clear();
  }
  
  public static abstract class b
  {
    public abstract Rect ci();
  }
  
  public static abstract interface c
  {
    public abstract void a(Transition paramTransition);
    
    public abstract void ce();
    
    public abstract void cf();
    
    public abstract void cj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Transition
 * JD-Core Version:    0.7.0.1
 */