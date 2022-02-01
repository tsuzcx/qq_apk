package androidx.transition;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Transition
  implements Cloneable
{
  private static ThreadLocal<a<Animator, a>> arP = new ThreadLocal();
  private static final int[] aru = { 2, 1, 3, 4 };
  private static final PathMotion arv = new PathMotion()
  {
    public final Path getPath(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      AppMethodBeat.i(192545);
      Path localPath = new Path();
      localPath.moveTo(paramAnonymousFloat1, paramAnonymousFloat2);
      localPath.lineTo(paramAnonymousFloat3, paramAnonymousFloat4);
      AppMethodBeat.o(192545);
      return localPath;
    }
  };
  private boolean VX = false;
  ArrayList<String> arA = null;
  ArrayList<Class> arB = null;
  private ArrayList<Integer> arC = null;
  private ArrayList<View> arD = null;
  private ArrayList<Class> arE = null;
  private ArrayList<String> arF = null;
  private ArrayList<Integer> arG = null;
  private ArrayList<View> arH = null;
  private ArrayList<Class> arI = null;
  private x arJ = new x();
  private x arK = new x();
  TransitionSet arL = null;
  private int[] arM = aru;
  private ArrayList<w> arN;
  private ArrayList<w> arO;
  private ViewGroup arQ = null;
  boolean arR = false;
  ArrayList<Animator> arS = new ArrayList();
  private int arT = 0;
  private boolean arU = false;
  u arV;
  private c arW;
  private a<String, String> arX;
  private PathMotion arY = arv;
  private long arw = -1L;
  private TimeInterpolator arx = null;
  ArrayList<Integer> ary = new ArrayList();
  ArrayList<View> arz = new ArrayList();
  private ArrayList<Animator> kF = new ArrayList();
  long mDuration = -1L;
  private ArrayList<d> mListeners = null;
  private String mName = getClass().getName();
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, q.ark);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = g.a(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      p(l);
    }
    l = g.a(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      q(l);
    }
    int i = g.b(localTypedArray, paramAttributeSet, "interpolator", 0);
    if (i > 0) {
      a(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = g.c(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      m(R(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private static int[] R(String paramString)
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
            break label138;
          }
          localObject = new int[paramString.length - 1];
          System.arraycopy(paramString, 0, localObject, 0, i);
          i -= 1;
          paramString = (String)localObject;
        }
      }
      label138:
      throw new InflateException("Unknown match type in matchOrder: '" + (String)localObject + "'");
    }
    return paramString;
  }
  
  private static void a(x paramx, View paramView, w paramw)
  {
    paramx.asy.put(paramView, paramw);
    int i = paramView.getId();
    if (i >= 0)
    {
      if (paramx.asz.indexOfKey(i) >= 0) {
        paramx.asz.put(i, null);
      }
    }
    else
    {
      paramw = androidx.core.g.w.W(paramView);
      if (paramw != null)
      {
        if (!paramx.asB.containsKey(paramw)) {
          break label168;
        }
        paramx.asB.put(paramw, null);
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
          if (paramx.asA.d(l) < 0) {
            break label181;
          }
          paramView = (View)paramx.asA.get(l, null);
          if (paramView != null)
          {
            androidx.core.g.w.b(paramView, false);
            paramx.asA.a(l, null);
          }
        }
      }
      return;
      paramx.asz.put(i, paramView);
      break;
      label168:
      paramx.asB.put(paramw, paramView);
    }
    label181:
    androidx.core.g.w.b(paramView, true);
    paramx.asA.a(l, paramView);
  }
  
  private void a(x paramx1, x paramx2)
  {
    a locala2 = new a(paramx1.asy);
    a locala1 = new a(paramx2.asy);
    int i = 0;
    if (i < this.arM.length)
    {
      switch (this.arM[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        int j = locala2.size() - 1;
        while (j >= 0)
        {
          localObject1 = (View)locala2.aO(j);
          if ((localObject1 != null) && (bE((View)localObject1)))
          {
            localObject1 = (w)locala1.remove(localObject1);
            if ((localObject1 != null) && (((w)localObject1).view != null) && (bE(((w)localObject1).view)))
            {
              localObject2 = (w)locala2.removeAt(j);
              this.arN.add(localObject2);
              this.arO.add(localObject1);
            }
          }
          j -= 1;
        }
        Object localObject1 = paramx1.asB;
        Object localObject2 = paramx2.asB;
        int k = ((a)localObject1).size();
        j = 0;
        View localView1;
        View localView2;
        w localw1;
        w localw2;
        while (j < k)
        {
          localView1 = (View)((a)localObject1).aM(j);
          if ((localView1 != null) && (bE(localView1)))
          {
            localView2 = (View)((a)localObject2).get(((a)localObject1).aO(j));
            if ((localView2 != null) && (bE(localView2)))
            {
              localw1 = (w)locala2.get(localView1);
              localw2 = (w)locala1.get(localView2);
              if ((localw1 != null) && (localw2 != null))
              {
                this.arN.add(localw1);
                this.arO.add(localw2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramx1.asz;
        localObject2 = paramx2.asz;
        k = ((SparseArray)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((SparseArray)localObject1).valueAt(j);
          if ((localView1 != null) && (bE(localView1)))
          {
            localView2 = (View)((SparseArray)localObject2).get(((SparseArray)localObject1).keyAt(j));
            if ((localView2 != null) && (bE(localView2)))
            {
              localw1 = (w)locala2.get(localView1);
              localw2 = (w)locala1.get(localView2);
              if ((localw1 != null) && (localw2 != null))
              {
                this.arN.add(localw1);
                this.arO.add(localw2);
                locala2.remove(localView1);
                locala1.remove(localView2);
              }
            }
          }
          j += 1;
        }
        localObject1 = paramx1.asA;
        localObject2 = paramx2.asA;
        k = ((d)localObject1).size();
        j = 0;
        while (j < k)
        {
          localView1 = (View)((d)localObject1).aM(j);
          if ((localView1 != null) && (bE(localView1)))
          {
            localView2 = (View)((d)localObject2).get(((d)localObject1).aL(j), null);
            if ((localView2 != null) && (bE(localView2)))
            {
              localw1 = (w)locala2.get(localView1);
              localw2 = (w)locala1.get(localView2);
              if ((localw1 != null) && (localw2 != null))
              {
                this.arN.add(localw1);
                this.arO.add(localw2);
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
      paramx1 = (w)locala2.aM(i);
      if (bE(paramx1.view))
      {
        this.arN.add(paramx1);
        this.arO.add(null);
      }
      i += 1;
    }
    i = 0;
    while (i < locala1.size())
    {
      paramx1 = (w)locala1.aM(i);
      if (bE(paramx1.view))
      {
        this.arO.add(paramx1);
        this.arN.add(null);
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
  
  private static boolean c(int[] paramArrayOfInt, int paramInt)
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
  
  private void g(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j = paramView.getId();
      if (((this.arC == null) || (!this.arC.contains(Integer.valueOf(j)))) && ((this.arD == null) || (!this.arD.contains(paramView))))
      {
        if (this.arE != null)
        {
          int k = this.arE.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label100;
            }
            if (((Class)this.arE.get(i)).isInstance(paramView)) {
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
          localw.asx.add(this);
          d(localw);
          if (!paramBoolean) {
            break label270;
          }
          a(this.arJ, paramView, localw);
        }
        for (;;)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.arG != null) && (this.arG.contains(Integer.valueOf(j)))) || ((this.arH != null) && (this.arH.contains(paramView)))) {
            break label281;
          }
          if (this.arI == null) {
            break label283;
          }
          j = this.arI.size();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label283;
            }
            if (((Class)this.arI.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
          label261:
          c(localw);
          break label135;
          label270:
          a(this.arK, paramView, localw);
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
  
  private void m(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      this.arM = aru;
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
      if (c(paramVarArgs, i)) {
        throw new IllegalArgumentException("matches contains a duplicate value");
      }
      i += 1;
    }
    this.arM = ((int[])paramVarArgs.clone());
  }
  
  private static a<Animator, a> nq()
  {
    a locala2 = (a)arP.get();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      arP.set(locala1);
    }
    return locala1;
  }
  
  public Transition S(String paramString)
  {
    if (this.arA == null) {
      this.arA = new ArrayList();
    }
    this.arA.add(paramString);
    return this;
  }
  
  public Animator a(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    return null;
  }
  
  public Transition a(TimeInterpolator paramTimeInterpolator)
  {
    this.arx = paramTimeInterpolator;
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
    ArrayList localArrayList2 = this.arE;
    ArrayList localArrayList1 = localArrayList2;
    if (paramClass != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (localArrayList1 = Transition.b.a(localArrayList2, paramClass);; localArrayList1 = Transition.b.b(localArrayList2, paramClass))
    {
      this.arE = localArrayList1;
      return this;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, x paramx1, x paramx2, ArrayList<w> paramArrayList1, ArrayList<w> paramArrayList2)
  {
    a locala = nq();
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
      if ((localw1 == null) || (localw1.asx.contains(this))) {
        break label615;
      }
      localw1 = null;
    }
    label312:
    label615:
    for (;;)
    {
      if ((localw2 != null) && (!localw2.asx.contains(this))) {
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
            String[] arrayOfString = nf();
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
            localObject2 = (w)paramx2.asy.get(localObject1);
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
          localObject2 = (a)locala.get((Animator)locala.aO(j));
          if ((((a)localObject2).asb == null) || (((a)localObject2).mView != localObject1) || (!((a)localObject2).mName.equals(this.mName)) || (!((a)localObject2).asb.equals(paramx1))) {
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
            if (this.arV != null)
            {
              l2 = this.arV.a(paramViewGroup, this, localw1, localw2);
              localSparseIntArray.put(this.kF.size(), (int)l2);
              l2 = Math.min(l2, l1);
            }
            locala.put(localAnimator, new a(paramx1, this.mName, this, ai.bN(paramViewGroup), (w)localObject1));
            this.kF.add(localAnimator);
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
            paramViewGroup = (Animator)this.kF.get(j);
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
      this.arY = arv;
      return;
    }
    this.arY = paramPathMotion;
  }
  
  public void a(c paramc)
  {
    this.arW = paramc;
  }
  
  public void a(u paramu)
  {
    this.arV = paramu;
  }
  
  public boolean a(w paramw1, w paramw2)
  {
    if ((paramw1 != null) && (paramw2 != null))
    {
      Object localObject = nf();
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
  
  final void aD(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.arJ.asy.clear();
      this.arJ.asz.clear();
      this.arJ.asA.clear();
      return;
    }
    this.arK.asy.clear();
    this.arK.asz.clear();
    this.arK.asA.clear();
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
    aD(paramBoolean);
    int i;
    Object localObject1;
    Object localObject2;
    if (((this.ary.size() > 0) || (this.arz.size() > 0)) && ((this.arA == null) || (this.arA.isEmpty())) && ((this.arB == null) || (this.arB.isEmpty())))
    {
      i = 0;
      if (i < this.ary.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.ary.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new w();
          ((w)localObject2).view = ((View)localObject1);
          if (!paramBoolean) {
            break label164;
          }
          b((w)localObject2);
          label126:
          ((w)localObject2).asx.add(this);
          d((w)localObject2);
          if (!paramBoolean) {
            break label173;
          }
          a(this.arJ, (View)localObject1, (w)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          label164:
          c((w)localObject2);
          break label126;
          label173:
          a(this.arK, (View)localObject1, (w)localObject2);
        }
      }
      i = 0;
      if (i < this.arz.size())
      {
        paramViewGroup = (View)this.arz.get(i);
        localObject1 = new w();
        ((w)localObject1).view = paramViewGroup;
        if (paramBoolean)
        {
          b((w)localObject1);
          label237:
          ((w)localObject1).asx.add(this);
          d((w)localObject1);
          if (!paramBoolean) {
            break label283;
          }
          a(this.arJ, paramViewGroup, (w)localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          c((w)localObject1);
          break label237;
          label283:
          a(this.arK, paramViewGroup, (w)localObject1);
        }
      }
    }
    else
    {
      g(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.arX != null))
    {
      int m = this.arX.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.arX.aO(i);
        paramViewGroup.add(this.arJ.asB.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.arX.aM(j);
          this.arJ.asB.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  public abstract void b(w paramw);
  
  final boolean bE(View paramView)
  {
    int j = paramView.getId();
    if ((this.arC != null) && (this.arC.contains(Integer.valueOf(j)))) {}
    for (;;)
    {
      return false;
      if ((this.arD == null) || (!this.arD.contains(paramView)))
      {
        int i;
        if (this.arE != null)
        {
          int k = this.arE.size();
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label95;
            }
            if (((Class)this.arE.get(i)).isInstance(paramView)) {
              break;
            }
            i += 1;
          }
        }
        label95:
        if ((this.arF == null) || (androidx.core.g.w.W(paramView) == null) || (!this.arF.contains(androidx.core.g.w.W(paramView))))
        {
          if ((this.ary.size() == 0) && (this.arz.size() == 0) && ((this.arB == null) || (this.arB.isEmpty())) && ((this.arA == null) || (this.arA.isEmpty()))) {
            return true;
          }
          if ((this.ary.contains(Integer.valueOf(j))) || (this.arz.contains(paramView))) {
            return true;
          }
          if ((this.arA != null) && (this.arA.contains(androidx.core.g.w.W(paramView)))) {
            return true;
          }
          if (this.arB != null)
          {
            i = 0;
            while (i < this.arB.size())
            {
              if (((Class)this.arB.get(i)).isInstance(paramView)) {
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  public Transition bF(View paramView)
  {
    this.arz.add(paramView);
    return this;
  }
  
  public Transition bG(View paramView)
  {
    this.arz.remove(paramView);
    return this;
  }
  
  public void bH(View paramView)
  {
    int k = 0;
    if (!this.VX)
    {
      a locala = nq();
      int i = locala.size();
      paramView = ai.bN(paramView);
      i -= 1;
      label96:
      int j;
      if (i >= 0)
      {
        Object localObject = (a)locala.aM(i);
        if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).asc)))
        {
          localObject = (Animator)locala.aO(i);
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
          ((d)paramView.get(i)).ng();
          i += 1;
        }
      }
      this.arU = true;
    }
  }
  
  public void bI(View paramView)
  {
    if (this.arU)
    {
      if (!this.VX)
      {
        a locala = nq();
        int i = locala.size();
        paramView = ai.bN(paramView);
        i -= 1;
        label100:
        int j;
        if (i >= 0)
        {
          Object localObject = (a)locala.aM(i);
          if ((((a)localObject).mView != null) && (paramView.equals(((a)localObject).asc)))
          {
            localObject = (Animator)locala.aO(i);
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
            ((d)paramView.get(i)).nh();
            i += 1;
          }
        }
      }
      this.arU = false;
    }
  }
  
  public Transition c(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList2 = this.arF;
    ArrayList localArrayList1 = localArrayList2;
    if (paramString != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (localArrayList1 = Transition.b.a(localArrayList2, paramString);; localArrayList1 = Transition.b.b(localArrayList2, paramString))
    {
      this.arF = localArrayList1;
      return this;
    }
  }
  
  final void c(ViewGroup paramViewGroup)
  {
    this.arN = new ArrayList();
    this.arO = new ArrayList();
    a(this.arJ, this.arK);
    a locala = nq();
    int i = locala.size();
    aq localaq = ai.bN(paramViewGroup);
    i -= 1;
    if (i >= 0)
    {
      Animator localAnimator = (Animator)locala.aO(i);
      int j;
      if (localAnimator != null)
      {
        a locala1 = (a)locala.get(localAnimator);
        if ((locala1 != null) && (locala1.mView != null) && (localaq.equals(locala1.asc)))
        {
          w localw1 = locala1.asb;
          Object localObject = locala1.mView;
          w localw2 = h((View)localObject, true);
          localObject = i((View)localObject, true);
          if (((localw2 == null) && (localObject == null)) || (!locala1.asd.a(localw1, (w)localObject))) {
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
    a(paramViewGroup, this.arJ, this.arK, this.arN, this.arO);
    nr();
  }
  
  public abstract void c(w paramw);
  
  void d(w paramw)
  {
    int j = 0;
    String[] arrayOfString;
    if ((this.arV != null) && (!paramw.values.isEmpty()))
    {
      arrayOfString = this.arV.ny();
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
        this.arV.a(paramw);
        return;
        i += 1;
        break;
      }
    }
  }
  
  public Transition dx(int paramInt)
  {
    if (paramInt != 0) {
      this.ary.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  protected final void end()
  {
    this.arT -= 1;
    if (this.arT == 0)
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
      while (i < this.arJ.asA.size())
      {
        localObject = (View)this.arJ.asA.aM(i);
        if (localObject != null) {
          androidx.core.g.w.b((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.arK.asA.size())
      {
        localObject = (View)this.arK.asA.aM(i);
        if (localObject != null) {
          androidx.core.g.w.b((View)localObject, false);
        }
        i += 1;
      }
      this.VX = true;
    }
  }
  
  public final w h(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).arL != null; localObject = ((Transition)localObject).arL) {}
    if (paramBoolean) {}
    for (localObject = ((Transition)localObject).arJ;; localObject = ((Transition)localObject).arK) {
      return (w)((x)localObject).asy.get(paramView);
    }
  }
  
  final w i(View paramView, boolean paramBoolean)
  {
    for (Object localObject = this; ((Transition)localObject).arL != null; localObject = ((Transition)localObject).arL) {}
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = ((Transition)localObject).arN;
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
      localArrayList = ((Transition)localObject).arO;
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
          paramView = ((Transition)localObject).arO;
        }
      }
      label103:
      for (paramView = (w)paramView.get(i);; paramView = null)
      {
        return paramView;
        i += 1;
        break;
        paramView = ((Transition)localObject).arN;
        break label103;
      }
      label135:
      i = -1;
    }
  }
  
  public Transition j(Class paramClass)
  {
    if (this.arB == null) {
      this.arB = new ArrayList();
    }
    this.arB.add(paramClass);
    return this;
  }
  
  public Transition l(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList2 = this.arC;
    ArrayList localArrayList1 = localArrayList2;
    if (paramInt > 0) {
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (localArrayList1 = Transition.b.a(localArrayList2, Integer.valueOf(paramInt));; localArrayList1 = Transition.b.b(localArrayList2, Integer.valueOf(paramInt)))
    {
      this.arC = localArrayList1;
      return this;
    }
  }
  
  public String[] nf()
  {
    return null;
  }
  
  public final long no()
  {
    return this.arw;
  }
  
  public final TimeInterpolator np()
  {
    return this.arx;
  }
  
  protected void nr()
  {
    start();
    final a locala = nq();
    Iterator localIterator = this.kF.iterator();
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
              AppMethodBeat.i(192553);
              locala.remove(paramAnonymousAnimator);
              Transition.this.arS.remove(paramAnonymousAnimator);
              AppMethodBeat.o(192553);
            }
            
            public final void onAnimationStart(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(192548);
              Transition.this.arS.add(paramAnonymousAnimator);
              AppMethodBeat.o(192548);
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
            if (this.arw >= 0L) {
              localAnimator.setStartDelay(this.arw);
            }
            if (this.arx != null) {
              localAnimator.setInterpolator(this.arx);
            }
            localAnimator.addListener(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(192559);
                Transition.this.end();
                paramAnonymousAnimator.removeListener(this);
                AppMethodBeat.o(192559);
              }
            });
            localAnimator.start();
          }
        }
      }
    }
    this.kF.clear();
    end();
  }
  
  public final PathMotion ns()
  {
    return this.arY;
  }
  
  public final c nt()
  {
    return this.arW;
  }
  
  public final Rect nu()
  {
    if (this.arW == null) {
      return null;
    }
    return this.arW.nk();
  }
  
  public Transition nv()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.kF = new ArrayList();
      localTransition.arJ = new x();
      localTransition.arK = new x();
      localTransition.arN = null;
      localTransition.arO = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public Transition p(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public Transition q(long paramLong)
  {
    this.arw = paramLong;
    return this;
  }
  
  protected final void start()
  {
    if (this.arT == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((d)localArrayList.get(i)).nl();
          i += 1;
        }
      }
      this.VX = false;
    }
    this.arT += 1;
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
    if (this.arw != -1L) {
      str = paramString + "dly(" + this.arw + ") ";
    }
    paramString = str;
    if (this.arx != null) {
      paramString = str + "interp(" + this.arx + ") ";
    }
    if (this.ary.size() <= 0)
    {
      str = paramString;
      if (this.arz.size() <= 0) {}
    }
    else
    {
      str = paramString + "tgts(";
      paramString = str;
      int i;
      if (this.ary.size() > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= this.ary.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = str + ", ";
          }
          str = paramString + this.ary.get(i);
          i += 1;
        }
      }
      str = paramString;
      if (this.arz.size() > 0)
      {
        i = j;
        for (;;)
        {
          str = paramString;
          if (i >= this.arz.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = paramString + ", ";
          }
          paramString = str + this.arz.get(i);
          i += 1;
        }
      }
      str = str + ")";
    }
    return str;
  }
  
  static final class a
  {
    w asb;
    aq asc;
    Transition asd;
    String mName;
    View mView;
    
    a(View paramView, String paramString, Transition paramTransition, aq paramaq, w paramw)
    {
      this.mView = paramView;
      this.mName = paramString;
      this.asb = paramw;
      this.asc = paramaq;
      this.asd = paramTransition;
    }
  }
  
  public static abstract class c
  {
    public abstract Rect nk();
  }
  
  public static abstract interface d
  {
    public abstract void a(Transition paramTransition);
    
    public abstract void ng();
    
    public abstract void nh();
    
    public abstract void nl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.Transition
 * JD-Core Version:    0.7.0.1
 */