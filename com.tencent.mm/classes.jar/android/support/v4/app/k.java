package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.f.d;
import android.support.v4.f.e;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class k
  extends j
  implements LayoutInflater.Factory2
{
  static boolean DEBUG = false;
  static Field vC = null;
  static final Interpolator vQ = new DecelerateInterpolator(2.5F);
  static final Interpolator vR = new DecelerateInterpolator(1.5F);
  static final Interpolator vS = new AccelerateInterpolator(2.5F);
  static final Interpolator vT = new AccelerateInterpolator(1.5F);
  i mHost;
  boolean mStopped;
  Fragment vA;
  Fragment vB;
  boolean vD;
  boolean vE;
  boolean vF;
  String vG;
  boolean vH;
  ArrayList<b> vI;
  ArrayList<Boolean> vJ;
  ArrayList<Fragment> vK;
  Bundle vL = null;
  SparseArray<Parcelable> vM = null;
  ArrayList<i> vN;
  l vO;
  Runnable vP = new Runnable()
  {
    public final void run()
    {
      k.this.execPendingActions();
    }
  };
  ArrayList<g> vn;
  boolean vo;
  int vp = 0;
  final ArrayList<Fragment> vq = new ArrayList();
  SparseArray<Fragment> vr;
  ArrayList<b> vs;
  ArrayList<Fragment> vt;
  ArrayList<b> vu;
  ArrayList<Integer> vv;
  ArrayList<Object> vw;
  private final CopyOnWriteArrayList<android.support.v4.f.j<Object, Boolean>> vx = new CopyOnWriteArrayList();
  int vy = 0;
  g vz;
  
  private int a(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, android.support.v4.f.b<Fragment> paramb)
  {
    int j = paramInt2 - 1;
    int i = paramInt2;
    b localb;
    int k;
    label165:
    if (j >= paramInt1)
    {
      localb = (b)paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      k = 0;
      label44:
      if (k < localb.uh.size()) {
        if (b.b((b.a)localb.uh.get(k)))
        {
          k = 1;
          label79:
          if ((k == 0) || (localb.a(paramArrayList, j + 1, paramInt2))) {
            break label223;
          }
          k = 1;
          label102:
          if (k == 0) {
            break label241;
          }
          if (this.vN == null) {
            this.vN = new ArrayList();
          }
          i locali = new i(localb, bool);
          this.vN.add(locali);
          localb.a(locali);
          if (!bool) {
            break label229;
          }
          localb.bL();
          i -= 1;
          if (j != i)
          {
            paramArrayList.remove(j);
            paramArrayList.add(i, localb);
          }
          b(paramb);
        }
      }
    }
    label223:
    label229:
    label241:
    for (;;)
    {
      j -= 1;
      break;
      k += 1;
      break label44;
      k = 0;
      break label79;
      k = 0;
      break label102;
      localb.x(false);
      break label165;
      return i;
    }
  }
  
  private c a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int j = paramFragment.getNextAnim();
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, j);
    if (localAnimation != null) {
      return new c(localAnimation, (byte)0);
    }
    paramFragment = paramFragment.onCreateAnimator(paramInt1, paramBoolean, j);
    if (paramFragment != null) {
      return new c(paramFragment, (byte)0);
    }
    if (j != 0)
    {
      boolean bool = "anim".equals(this.mHost.mContext.getResources().getResourceTypeName(j));
      if (bool) {}
      for (;;)
      {
        try
        {
          paramFragment = AnimationUtils.loadAnimation(this.mHost.mContext, j);
          if (paramFragment != null)
          {
            paramFragment = new c(paramFragment, (byte)0);
            return paramFragment;
          }
        }
        catch (Resources.NotFoundException paramFragment)
        {
          throw paramFragment;
          i = 1;
          if (i != 0) {
            break label198;
          }
          try
          {
            paramFragment = AnimatorInflater.loadAnimator(this.mHost.mContext, j);
            if (paramFragment == null) {
              break label198;
            }
            paramFragment = new c(paramFragment, (byte)0);
            return paramFragment;
          }
          catch (RuntimeException paramFragment)
          {
            if (!bool) {
              break;
            }
          }
          throw paramFragment;
        }
        catch (RuntimeException paramFragment) {}
        i = 0;
      }
      paramFragment = AnimationUtils.loadAnimation(this.mHost.mContext, j);
      if (paramFragment != null) {
        return new c(paramFragment, (byte)0);
      }
    }
    label198:
    if (paramInt1 == 0) {
      return null;
    }
    int i = -1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
    }
    while (paramInt1 < 0)
    {
      return null;
      if (paramBoolean)
      {
        paramInt1 = 1;
      }
      else
      {
        paramInt1 = 2;
        continue;
        if (paramBoolean)
        {
          paramInt1 = 3;
        }
        else
        {
          paramInt1 = 4;
          continue;
          if (paramBoolean) {
            paramInt1 = 5;
          } else {
            paramInt1 = 6;
          }
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.mHost.onHasWindowAnimations()) {
          paramInt1 = this.mHost.onGetWindowAnimations();
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return b(1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return b(1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return b(0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return b(1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return s(0.0F, 1.0F);
    case 6: 
      return s(1.0F, 0.0F);
    }
    return null;
  }
  
  /* Error */
  private void a(int paramInt, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 296	android/support/v4/app/k:vu	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 137	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 138	java/util/ArrayList:<init>	()V
    //   17: putfield 296	android/support/v4/app/k:vu	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 296	android/support/v4/app/k:vu	Ljava/util/ArrayList;
    //   24: invokevirtual 176	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +47 -> 82
    //   38: getstatic 109	android/support/v4/app/k:DEBUG	Z
    //   41: ifeq +28 -> 69
    //   44: new 298	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 300
    //   51: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: iload_1
    //   55: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: ldc_w 309
    //   61: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_0
    //   70: getfield 296	android/support/v4/app/k:vu	Ljava/util/ArrayList;
    //   73: iload_1
    //   74: aload_2
    //   75: invokevirtual 319	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: iload_3
    //   83: iload_1
    //   84: if_icmpge +49 -> 133
    //   87: aload_0
    //   88: getfield 296	android/support/v4/app/k:vu	Ljava/util/ArrayList;
    //   91: aconst_null
    //   92: invokevirtual 193	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_0
    //   97: getfield 321	android/support/v4/app/k:vv	Ljava/util/ArrayList;
    //   100: ifnonnull +14 -> 114
    //   103: aload_0
    //   104: new 137	java/util/ArrayList
    //   107: dup
    //   108: invokespecial 138	java/util/ArrayList:<init>	()V
    //   111: putfield 321	android/support/v4/app/k:vv	Ljava/util/ArrayList;
    //   114: aload_0
    //   115: getfield 321	android/support/v4/app/k:vv	Ljava/util/ArrayList;
    //   118: iload_3
    //   119: invokestatic 327	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: invokevirtual 193	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: iload_3
    //   127: iconst_1
    //   128: iadd
    //   129: istore_3
    //   130: goto -48 -> 82
    //   133: getstatic 109	android/support/v4/app/k:DEBUG	Z
    //   136: ifeq +28 -> 164
    //   139: new 298	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 329
    //   146: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: iload_1
    //   150: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc_w 331
    //   156: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_0
    //   165: getfield 296	android/support/v4/app/k:vu	Ljava/util/ArrayList;
    //   168: aload_2
    //   169: invokevirtual 193	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: goto -94 -> 79
    //   176: astore_2
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_2
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	k
    //   0	181	1	paramInt	int
    //   0	181	2	paramb	b
    //   31	99	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	176	finally
    //   20	29	176	finally
    //   38	69	176	finally
    //   69	79	176	finally
    //   79	81	176	finally
    //   87	114	176	finally
    //   114	126	176	finally
    //   133	164	176	finally
    //   164	173	176	finally
    //   177	179	176	finally
  }
  
  private void a(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    if (this.vA != null)
    {
      j localj = this.vA.getFragmentManager();
      if ((localj instanceof k)) {
        ((k)localj).a(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      paramContext = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramContext.second).booleanValue();
      }
    }
  }
  
  private void a(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.vA != null)
    {
      j localj = this.vA.getFragmentManager();
      if ((localj instanceof k)) {
        ((k)localj).a(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.second).booleanValue();
      }
    }
  }
  
  private void a(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.vA != null)
    {
      j localj = this.vA.getFragmentManager();
      if ((localj instanceof k)) {
        ((k)localj).a(paramFragment, paramView, paramBundle, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      paramView = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramView.second).booleanValue();
      }
    }
  }
  
  static void a(l paraml)
  {
    if (paraml == null) {}
    for (;;)
    {
      return;
      Object localObject = paraml.wk;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Fragment)((Iterator)localObject).next()).mRetaining = true;
        }
      }
      paraml = paraml.wl;
      if (paraml != null)
      {
        paraml = paraml.iterator();
        while (paraml.hasNext()) {
          a((l)paraml.next());
        }
      }
    }
  }
  
  private static void a(android.support.v4.f.b<Fragment> paramb)
  {
    int j = paramb.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramb.DZ[i];
      if (!localFragment.mAdded)
      {
        View localView = localFragment.getView();
        localFragment.mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  private static void a(View paramView, c paramc)
  {
    int j = 0;
    if ((paramView == null) || (paramc == null)) {
      return;
    }
    int i = j;
    if (paramView != null)
    {
      if (paramc != null) {
        break label50;
      }
      i = j;
    }
    label23:
    label50:
    boolean bool;
    while (i != 0)
    {
      if (paramc.wc == null) {
        break label183;
      }
      paramc.wc.addListener(new d(paramView));
      return;
      i = j;
      if (Build.VERSION.SDK_INT >= 19)
      {
        i = j;
        if (paramView.getLayerType() == 0)
        {
          i = j;
          if (q.af(paramView))
          {
            if (!(paramc.wb instanceof AlphaAnimation)) {
              break label103;
            }
            bool = true;
          }
        }
      }
    }
    label165:
    for (;;)
    {
      i = j;
      if (!bool) {
        break label23;
      }
      i = 1;
      break label23;
      break;
      label103:
      if ((paramc.wb instanceof AnimationSet))
      {
        localObject = ((AnimationSet)paramc.wb).getAnimations();
        i = 0;
        for (;;)
        {
          if (i >= ((List)localObject).size()) {
            break label165;
          }
          if ((((List)localObject).get(i) instanceof AlphaAnimation))
          {
            bool = true;
            break;
          }
          i += 1;
        }
        bool = false;
      }
      else
      {
        bool = d(paramc.wc);
      }
    }
    label183:
    Object localObject = e(paramc.wb);
    paramView.setLayerType(2, null);
    paramc.wb.setAnimationListener(new a(paramView, (Animation.AnimationListener)localObject));
  }
  
  private void a(RuntimeException paramRuntimeException)
  {
    paramRuntimeException.getMessage();
    PrintWriter localPrintWriter = new PrintWriter(new e("FragmentManager"));
    if (this.mHost != null) {}
    try
    {
      this.mHost.a("  ", localPrintWriter, new String[0]);
      for (;;)
      {
        label45:
        throw paramRuntimeException;
        try
        {
          dump("  ", null, localPrintWriter, new String[0]);
        }
        catch (Exception localException1) {}
      }
    }
    catch (Exception localException2)
    {
      break label45;
    }
  }
  
  private void a(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool = ((b)paramArrayList.get(paramInt1)).uA;
    Object localObject;
    int j;
    label55:
    b localb;
    if (this.vK == null)
    {
      this.vK = new ArrayList();
      this.vK.addAll(this.vq);
      localObject = this.vB;
      j = paramInt1;
      i = 0;
      if (j >= paramInt2) {
        break label158;
      }
      localb = (b)paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
        break label136;
      }
      localObject = localb.a(this.vK, (Fragment)localObject);
      label101:
      if ((i == 0) && (!localb.uq)) {
        break label152;
      }
    }
    label136:
    label152:
    for (int i = 1;; i = 0)
    {
      j += 1;
      break label55;
      this.vK.clear();
      break;
      localObject = localb.b(this.vK, (Fragment)localObject);
      break label101;
    }
    label158:
    this.vK.clear();
    if (!bool) {
      p.a(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false);
    }
    b(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    int k;
    if (bool)
    {
      localObject = new android.support.v4.f.b();
      b((android.support.v4.f.b)localObject);
      k = a(paramArrayList, paramArrayList1, paramInt1, paramInt2, (android.support.v4.f.b)localObject);
      a((android.support.v4.f.b)localObject);
    }
    for (;;)
    {
      j = paramInt1;
      if (k != paramInt1)
      {
        j = paramInt1;
        if (bool)
        {
          p.a(this, paramArrayList, paramArrayList1, paramInt1, k, true);
          k(this.vy, true);
          j = paramInt1;
        }
      }
      while (j < paramInt2)
      {
        localObject = (b)paramArrayList.get(j);
        if ((((Boolean)paramArrayList1.get(j)).booleanValue()) && (((b)localObject).mIndex >= 0)) {
          paramInt1 = ((b)localObject).mIndex;
        }
        try
        {
          this.vu.set(paramInt1, null);
          if (this.vv == null) {
            this.vv = new ArrayList();
          }
          this.vv.add(Integer.valueOf(paramInt1));
          ((b)localObject).mIndex = -1;
          ((b)localObject).bK();
          j += 1;
        }
        finally {}
      }
      if (i != 0) {
        bX();
      }
      return;
      k = paramInt2;
    }
  }
  
  public static int ad(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private static c b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(vQ);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(vR);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return new c(localAnimationSet, (byte)0);
  }
  
  private void b(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    if (this.vA != null)
    {
      j localj = this.vA.getFragmentManager();
      if ((localj instanceof k)) {
        ((k)localj).b(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      paramContext = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramContext.second).booleanValue();
      }
    }
  }
  
  private void b(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.vA != null)
    {
      j localj = this.vA.getFragmentManager();
      if ((localj instanceof k)) {
        ((k)localj).b(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.second).booleanValue();
      }
    }
  }
  
  private void b(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.vA != null)
    {
      localObject = this.vA.getFragmentManager();
      if ((localObject instanceof k)) {
        ((k)localObject).b(paramFragment, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((android.support.v4.f.j)localObject).second).booleanValue();
      }
    }
  }
  
  private void b(android.support.v4.f.b<Fragment> paramb)
  {
    if (this.vy <= 0) {}
    for (;;)
    {
      return;
      int j = Math.min(this.vy, 4);
      int k = this.vq.size();
      int i = 0;
      while (i < k)
      {
        Fragment localFragment = (Fragment)this.vq.get(i);
        if (localFragment.mState < j)
        {
          a(localFragment, j, localFragment.getNextAnim(), localFragment.getNextTransition(), false);
          if ((localFragment.mView != null) && (!localFragment.mHidden) && (localFragment.mIsNewlyAdded)) {
            paramb.add(localFragment);
          }
        }
        i += 1;
      }
    }
  }
  
  private static void b(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      b localb = (b)paramArrayList.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue())
      {
        localb.X(-1);
        if (paramInt1 == paramInt2 - 1)
        {
          bool = true;
          label45:
          localb.x(bool);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        bool = false;
        break label45;
        localb.X(1);
        localb.bL();
      }
    }
  }
  
  private boolean bQ()
  {
    execPendingActions();
    y(true);
    if (this.vB != null)
    {
      j localj = this.vB.peekChildFragmentManager();
      if ((localj != null) && (localj.popBackStackImmediate())) {
        return true;
      }
    }
    boolean bool = a(this.vI, this.vJ, null, -1, 0);
    if (bool) {
      this.vo = true;
    }
    try
    {
      e(this.vI, this.vJ);
      bU();
      bW();
      return bool;
    }
    finally
    {
      bU();
    }
  }
  
  private void bR()
  {
    if (this.vr == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.vr.size())
      {
        Fragment localFragment = (Fragment)this.vr.valueAt(i);
        if (localFragment != null) {
          f(localFragment);
        }
        i += 1;
      }
    }
  }
  
  private void bS()
  {
    if (isStateSaved()) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.vG != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.vG);
    }
  }
  
  private void bT()
  {
    int j = 1;
    label44:
    label73:
    label92:
    label97:
    label100:
    for (;;)
    {
      int i;
      try
      {
        if ((this.vN == null) || (this.vN.isEmpty())) {
          break label92;
        }
        i = 1;
        if ((this.vn == null) || (this.vn.size() != 1)) {
          break label97;
        }
      }
      finally {}
      this.mHost.mHandler.removeCallbacks(this.vP);
      this.mHost.mHandler.post(this.vP);
      return;
      for (;;)
      {
        if (i != 0) {
          break label100;
        }
        if (j == 0) {
          break label73;
        }
        break label44;
        i = 0;
        break;
        j = 0;
      }
    }
  }
  
  private void bU()
  {
    this.vo = false;
    this.vJ.clear();
    this.vI.clear();
  }
  
  private void bV()
  {
    if (this.vN != null) {
      while (!this.vN.isEmpty()) {
        ((i)this.vN.remove(0)).ca();
      }
    }
  }
  
  private void bW()
  {
    if (this.vH)
    {
      this.vH = false;
      bR();
    }
  }
  
  private void bX()
  {
    if (this.vw != null)
    {
      int i = 0;
      while (i < this.vw.size())
      {
        this.vw.get(i);
        i += 1;
      }
    }
  }
  
  private void bY()
  {
    if (this.vr != null)
    {
      int i = 0;
      Object localObject1 = null;
      Object localObject3 = null;
      Object localObject7;
      for (Object localObject2 = null;; localObject2 = localObject7)
      {
        localObject6 = localObject1;
        localObject5 = localObject3;
        localObject4 = localObject2;
        if (i >= this.vr.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.vr.valueAt(i);
        localObject5 = localObject1;
        localObject6 = localObject3;
        localObject7 = localObject2;
        if (localFragment != null)
        {
          localObject4 = localObject2;
          int j;
          if (localFragment.mRetainInstance)
          {
            localObject5 = localObject2;
            if (localObject2 == null) {
              localObject5 = new ArrayList();
            }
            ((ArrayList)localObject5).add(localFragment);
            if (localFragment.mTarget == null) {
              break label244;
            }
            j = localFragment.mTarget.mIndex;
            localFragment.mTargetIndex = j;
            localObject4 = localObject5;
            if (DEBUG)
            {
              new StringBuilder("retainNonConfig: keeping retained ").append(localFragment);
              localObject4 = localObject5;
            }
          }
          if (localFragment.mChildFragmentManager != null) {
            localFragment.mChildFragmentManager.bY();
          }
          for (localObject5 = localFragment.mChildFragmentManager.vO;; localObject5 = localFragment.mChildNonConfig)
          {
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label259;
            }
            localObject2 = localObject3;
            if (localObject5 == null) {
              break label259;
            }
            localObject3 = new ArrayList(this.vr.size());
            j = 0;
            for (;;)
            {
              localObject2 = localObject3;
              if (j >= i) {
                break;
              }
              ((ArrayList)localObject3).add(null);
              j += 1;
            }
            label244:
            j = -1;
            break;
          }
          label259:
          if (localObject2 != null) {
            localObject2.add(localObject5);
          }
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = localObject1;
            if (localFragment.mViewModelStore != null)
            {
              localObject1 = new ArrayList(this.vr.size());
              j = 0;
              for (;;)
              {
                localObject3 = localObject1;
                if (j >= i) {
                  break;
                }
                ((ArrayList)localObject1).add(null);
                j += 1;
              }
            }
          }
          localObject5 = localObject3;
          localObject6 = localObject2;
          localObject7 = localObject4;
          if (localObject3 != null)
          {
            ((ArrayList)localObject3).add(localFragment.mViewModelStore);
            localObject7 = localObject4;
            localObject6 = localObject2;
            localObject5 = localObject3;
          }
        }
        i += 1;
        localObject1 = localObject5;
        localObject3 = localObject6;
      }
    }
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    if ((localObject4 == null) && (localObject5 == null) && (localObject6 == null))
    {
      this.vO = null;
      return;
    }
    this.vO = new l(localObject4, (List)localObject5, localObject6);
  }
  
  private void bZ()
  {
    if (this.vr != null)
    {
      int i = this.vr.size() - 1;
      while (i >= 0)
      {
        if (this.vr.valueAt(i) == null) {
          this.vr.delete(this.vr.keyAt(i));
        }
        i -= 1;
      }
    }
  }
  
  private void c(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.vA != null)
    {
      j localj = this.vA.getFragmentManager();
      if ((localj instanceof k)) {
        ((k)localj).c(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.second).booleanValue();
      }
    }
  }
  
  private void c(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.vA != null)
    {
      localObject = this.vA.getFragmentManager();
      if ((localObject instanceof k)) {
        ((k)localObject).c(paramFragment, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((android.support.v4.f.j)localObject).second).booleanValue();
      }
    }
  }
  
  private void d(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.vA != null)
    {
      j localj = this.vA.getFragmentManager();
      if ((localj instanceof k)) {
        ((k)localj).d(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.second).booleanValue();
      }
    }
  }
  
  private void d(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.vA != null)
    {
      localObject = this.vA.getFragmentManager();
      if ((localObject instanceof k)) {
        ((k)localObject).d(paramFragment, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((android.support.v4.f.j)localObject).second).booleanValue();
      }
    }
  }
  
  private void d(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i;
    int j;
    label12:
    i locali;
    int k;
    if (this.vN == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      locali = (i)this.vN.get(j);
      if ((paramArrayList == null) || (locali.wh)) {
        break label101;
      }
      k = paramArrayList.indexOf(locali.wi);
      if ((k == -1) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label101;
      }
      locali.cb();
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = this.vN.size();
      break;
      label101:
      if (locali.wj == 0) {}
      int m;
      for (k = 1;; k = 0)
      {
        if (k == 0)
        {
          m = j;
          k = i;
          if (paramArrayList == null) {
            break label240;
          }
          m = j;
          k = i;
          if (!locali.wi.a(paramArrayList, 0, paramArrayList.size())) {
            break label240;
          }
        }
        this.vN.remove(j);
        m = j - 1;
        k = i - 1;
        if ((paramArrayList == null) || (locali.wh)) {
          break label235;
        }
        i = paramArrayList.indexOf(locali.wi);
        if ((i == -1) || (!((Boolean)paramArrayList1.get(i)).booleanValue())) {
          break label235;
        }
        locali.cb();
        j = m;
        i = k;
        break;
      }
      label235:
      locali.ca();
      label240:
      j = m;
      i = k;
    }
  }
  
  private static boolean d(Animator paramAnimator)
  {
    if (paramAnimator == null) {}
    for (;;)
    {
      return false;
      int i;
      if ((paramAnimator instanceof ValueAnimator))
      {
        paramAnimator = ((ValueAnimator)paramAnimator).getValues();
        i = 0;
        while (i < paramAnimator.length)
        {
          if ("alpha".equals(paramAnimator[i].getPropertyName())) {
            return true;
          }
          i += 1;
        }
      }
      else if ((paramAnimator instanceof AnimatorSet))
      {
        paramAnimator = ((AnimatorSet)paramAnimator).getChildAnimations();
        i = 0;
        while (i < paramAnimator.size())
        {
          if (d((Animator)paramAnimator.get(i))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static Animation.AnimationListener e(Animation paramAnimation)
  {
    try
    {
      if (vC == null)
      {
        Field localField = Animation.class.getDeclaredField("mListener");
        vC = localField;
        localField.setAccessible(true);
      }
      paramAnimation = (Animation.AnimationListener)vC.get(paramAnimation);
      return paramAnimation;
    }
    catch (NoSuchFieldException paramAnimation)
    {
      return null;
    }
    catch (IllegalAccessException paramAnimation) {}
    return null;
  }
  
  private void e(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.vA != null)
    {
      localObject = this.vA.getFragmentManager();
      if ((localObject instanceof k)) {
        ((k)localObject).e(paramFragment, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((android.support.v4.f.j)localObject).second).booleanValue();
      }
    }
  }
  
  private void e(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    if ((paramArrayList1 == null) || (paramArrayList.size() != paramArrayList1.size())) {
      throw new IllegalStateException("Internal error with the back stack records");
    }
    d(paramArrayList, paramArrayList1);
    int m = paramArrayList.size();
    int i = 0;
    int j = 0;
    label55:
    int k;
    if (i < m)
    {
      if (((b)paramArrayList.get(i)).uA) {
        break label222;
      }
      if (j != i) {
        a(paramArrayList, paramArrayList1, j, i);
      }
      k = i + 1;
      j = k;
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        for (;;)
        {
          j = k;
          if (k >= m) {
            break;
          }
          j = k;
          if (!((Boolean)paramArrayList1.get(k)).booleanValue()) {
            break;
          }
          j = k;
          if (((b)paramArrayList.get(k)).uA) {
            break;
          }
          k += 1;
        }
      }
      a(paramArrayList, paramArrayList1, i, j);
      k = j - 1;
    }
    for (i = j;; i = j)
    {
      k += 1;
      j = i;
      i = k;
      break label55;
      if (j == m) {
        break;
      }
      a(paramArrayList, paramArrayList1, j, m);
      return;
      label222:
      k = i;
    }
  }
  
  private void f(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.vA != null)
    {
      localObject = this.vA.getFragmentManager();
      if ((localObject instanceof k)) {
        ((k)localObject).f(paramFragment, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((android.support.v4.f.j)localObject).second).booleanValue();
      }
    }
  }
  
  private boolean f(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    try
    {
      if ((this.vn == null) || (this.vn.size() == 0)) {
        return false;
      }
      int j = this.vn.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= ((g)this.vn.get(i)).c(paramArrayList, paramArrayList1);
        i += 1;
      }
      this.vn.clear();
      this.mHost.mHandler.removeCallbacks(this.vP);
      return bool;
    }
    finally {}
  }
  
  private void g(Fragment paramFragment)
  {
    a(paramFragment, this.vy, 0, 0, false);
  }
  
  private void g(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.vA != null)
    {
      localObject = this.vA.getFragmentManager();
      if ((localObject instanceof k)) {
        ((k)localObject).g(paramFragment, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((android.support.v4.f.j)localObject).second).booleanValue();
      }
    }
  }
  
  private void h(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject;
    if (this.vA != null)
    {
      localObject = this.vA.getFragmentManager();
      if ((localObject instanceof k)) {
        ((k)localObject).h(paramFragment, true);
      }
    }
    paramFragment = this.vx.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (android.support.v4.f.j)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((android.support.v4.f.j)localObject).second).booleanValue();
      }
    }
  }
  
  public static void k(Fragment paramFragment)
  {
    boolean bool = true;
    if (DEBUG) {
      new StringBuilder("hide: ").append(paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mHiddenChanged) {
        break label48;
      }
    }
    for (;;)
    {
      paramFragment.mHiddenChanged = bool;
      return;
      label48:
      bool = false;
    }
  }
  
  public static void l(Fragment paramFragment)
  {
    boolean bool = false;
    if (DEBUG) {
      new StringBuilder("show: ").append(paramFragment);
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (!paramFragment.mHiddenChanged) {
        bool = true;
      }
      paramFragment.mHiddenChanged = bool;
    }
  }
  
  private void o(Fragment paramFragment)
  {
    if (paramFragment.mInnerView == null) {
      return;
    }
    if (this.vM == null) {
      this.vM = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.vM);
      if (this.vM.size() <= 0) {
        break;
      }
      paramFragment.mSavedViewState = this.vM;
      this.vM = null;
      return;
      this.vM.clear();
    }
  }
  
  private Bundle p(Fragment paramFragment)
  {
    if (this.vL == null) {
      this.vL = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.vL);
    d(paramFragment, this.vL, false);
    Object localObject2;
    if (!this.vL.isEmpty())
    {
      localObject2 = this.vL;
      this.vL = null;
    }
    for (;;)
    {
      if (paramFragment.mView != null) {
        o(paramFragment);
      }
      Object localObject1 = localObject2;
      if (paramFragment.mSavedViewState != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
      }
      localObject2 = localObject1;
      if (!paramFragment.mUserVisibleHint)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
      }
      return localObject2;
      localObject2 = null;
    }
  }
  
  private static c s(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(vR);
    localAlphaAnimation.setDuration(220L);
    return new c(localAlphaAnimation, (byte)0);
  }
  
  private void y(boolean paramBoolean)
  {
    if (this.vo) {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    if (this.mHost == null) {
      throw new IllegalStateException("Fragment host has been destroyed");
    }
    if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    if (!paramBoolean) {
      bS();
    }
    if (this.vI == null)
    {
      this.vI = new ArrayList();
      this.vJ = new ArrayList();
    }
    this.vo = true;
    try
    {
      d(null, null);
      return;
    }
    finally
    {
      this.vo = false;
    }
  }
  
  public final Fragment G(String paramString)
  {
    int i;
    Object localObject;
    if (paramString != null)
    {
      i = this.vq.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.vq.get(i);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).mTag))) {
          return localObject;
        }
        i -= 1;
      }
    }
    if ((this.vr != null) && (paramString != null))
    {
      i = this.vr.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label119;
        }
        Fragment localFragment = (Fragment)this.vr.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(localFragment.mTag)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label119:
    return null;
  }
  
  public final Fragment Z(int paramInt)
  {
    int i = this.vq.size() - 1;
    Object localObject;
    while (i >= 0)
    {
      localObject = (Fragment)this.vq.get(i);
      if ((localObject != null) && (((Fragment)localObject).mFragmentId == paramInt)) {
        return localObject;
      }
      i -= 1;
    }
    if (this.vr != null)
    {
      i = this.vr.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label105;
        }
        Fragment localFragment = (Fragment)this.vr.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (localFragment.mFragmentId == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label105:
    return null;
  }
  
  public final int a(b paramb)
  {
    try
    {
      if ((this.vv == null) || (this.vv.size() <= 0))
      {
        if (this.vu == null) {
          this.vu = new ArrayList();
        }
        i = this.vu.size();
        if (DEBUG) {
          new StringBuilder("Setting back stack index ").append(i).append(" to ").append(paramb);
        }
        this.vu.add(paramb);
        return i;
      }
      int i = ((Integer)this.vv.remove(this.vv.size() - 1)).intValue();
      if (DEBUG) {
        new StringBuilder("Adding back stack index ").append(i).append(" with ").append(paramb);
      }
      this.vu.set(i, paramb);
      return i;
    }
    finally {}
  }
  
  public final void a(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      a(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  final void a(Parcelable arg1, l paraml)
  {
    if (??? == null) {}
    FragmentManagerState localFragmentManagerState;
    do
    {
      return;
      localFragmentManagerState = (FragmentManagerState)???;
    } while (localFragmentManagerState.wn == null);
    List localList = null;
    Object localObject1;
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    if (paraml != null)
    {
      localObject1 = paraml.wk;
      localList = paraml.wl;
      ??? = paraml.wm;
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label299;
        }
        localObject2 = (Fragment)((List)localObject1).get(j);
        if (DEBUG) {
          new StringBuilder("restoreAllState: re-attaching retained ").append(localObject2);
        }
        int k = 0;
        for (;;)
        {
          if ((k < localFragmentManagerState.wn.length) && (localFragmentManagerState.wn[k].mIndex != ((Fragment)localObject2).mIndex))
          {
            k += 1;
            continue;
            i = 0;
            break;
          }
        }
        if (k == localFragmentManagerState.wn.length) {
          a(new IllegalStateException("Could not find active fragment with index " + ((Fragment)localObject2).mIndex));
        }
        localObject3 = localFragmentManagerState.wn[k];
        ((FragmentState)localObject3).wu = ((Fragment)localObject2);
        ((Fragment)localObject2).mSavedViewState = null;
        ((Fragment)localObject2).mBackStackNesting = 0;
        ((Fragment)localObject2).mInLayout = false;
        ((Fragment)localObject2).mAdded = false;
        ((Fragment)localObject2).mTarget = null;
        if (((FragmentState)localObject3).mSavedFragmentState != null)
        {
          ((FragmentState)localObject3).mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
          ((Fragment)localObject2).mSavedViewState = ((FragmentState)localObject3).mSavedFragmentState.getSparseParcelableArray("android:view_state");
          ((Fragment)localObject2).mSavedFragmentState = ((FragmentState)localObject3).mSavedFragmentState;
        }
        j += 1;
      }
    }
    for (;;)
    {
      label299:
      this.vr = new SparseArray(localFragmentManagerState.wn.length);
      i = 0;
      FragmentState localFragmentState;
      if (i < localFragmentManagerState.wn.length)
      {
        localFragmentState = localFragmentManagerState.wn[i];
        if (localFragmentState != null) {
          if ((localList == null) || (i >= localList.size())) {
            break label1269;
          }
        }
      }
      label1269:
      for (localObject1 = (l)localList.get(i);; localObject1 = null)
      {
        localObject3 = null;
        localObject2 = localObject3;
        if (??? != null)
        {
          localObject2 = localObject3;
          if (i < ???.size()) {
            localObject2 = (ViewModelStore)???.get(i);
          }
        }
        localObject3 = this.mHost;
        g localg = this.vz;
        Fragment localFragment = this.vA;
        Context localContext;
        if (localFragmentState.wu == null)
        {
          localContext = ((i)localObject3).mContext;
          if (localFragmentState.mArguments != null) {
            localFragmentState.mArguments.setClassLoader(localContext.getClassLoader());
          }
          if (localg == null) {
            break label762;
          }
        }
        label762:
        for (localFragmentState.wu = localg.instantiate(localContext, localFragmentState.mClassName, localFragmentState.mArguments);; localFragmentState.wu = Fragment.instantiate(localContext, localFragmentState.mClassName, localFragmentState.mArguments))
        {
          if (localFragmentState.mSavedFragmentState != null)
          {
            localFragmentState.mSavedFragmentState.setClassLoader(localContext.getClassLoader());
            localFragmentState.wu.mSavedFragmentState = localFragmentState.mSavedFragmentState;
          }
          localFragmentState.wu.setIndex(localFragmentState.mIndex, localFragment);
          localFragmentState.wu.mFromLayout = localFragmentState.mFromLayout;
          localFragmentState.wu.mRestored = true;
          localFragmentState.wu.mFragmentId = localFragmentState.mFragmentId;
          localFragmentState.wu.mContainerId = localFragmentState.mContainerId;
          localFragmentState.wu.mTag = localFragmentState.mTag;
          localFragmentState.wu.mRetainInstance = localFragmentState.mRetainInstance;
          localFragmentState.wu.mDetached = localFragmentState.mDetached;
          localFragmentState.wu.mHidden = localFragmentState.mHidden;
          localFragmentState.wu.mFragmentManager = ((i)localObject3).mFragmentManager;
          if (DEBUG) {
            new StringBuilder("Instantiated fragment ").append(localFragmentState.wu);
          }
          localFragmentState.wu.mChildNonConfig = ((l)localObject1);
          localFragmentState.wu.mViewModelStore = ((ViewModelStore)localObject2);
          localObject1 = localFragmentState.wu;
          if (DEBUG) {
            new StringBuilder("restoreAllState: active #").append(i).append(": ").append(localObject1);
          }
          this.vr.put(((Fragment)localObject1).mIndex, localObject1);
          localFragmentState.wu = null;
          i += 1;
          break;
        }
        if (paraml != null)
        {
          ??? = paraml.wk;
          if (??? != null) {}
          for (i = ???.size();; i = 0)
          {
            j = 0;
            while (j < i)
            {
              paraml = (Fragment)???.get(j);
              if (paraml.mTargetIndex >= 0)
              {
                paraml.mTarget = ((Fragment)this.vr.get(paraml.mTargetIndex));
                if (paraml.mTarget == null) {
                  new StringBuilder("Re-attaching retained fragment ").append(paraml).append(" target no longer exists: ").append(paraml.mTargetIndex);
                }
              }
              j += 1;
            }
          }
        }
        this.vq.clear();
        if (localFragmentManagerState.wo != null)
        {
          i = 0;
          while (i < localFragmentManagerState.wo.length)
          {
            paraml = (Fragment)this.vr.get(localFragmentManagerState.wo[i]);
            if (paraml == null) {
              a(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.wo[i]));
            }
            paraml.mAdded = true;
            if (DEBUG) {
              new StringBuilder("restoreAllState: added #").append(i).append(": ").append(paraml);
            }
            if (this.vq.contains(paraml)) {
              throw new IllegalStateException("Already added!");
            }
            synchronized (this.vq)
            {
              this.vq.add(paraml);
              i += 1;
            }
          }
        }
        if (localFragmentManagerState.wp != null)
        {
          this.vs = new ArrayList(localFragmentManagerState.wp.length);
          i = 0;
          while (i < localFragmentManagerState.wp.length)
          {
            ??? = localFragmentManagerState.wp[i].a(this);
            if (DEBUG)
            {
              new StringBuilder("restoreAllState: back stack #").append(i).append(" (index ").append(???.mIndex).append("): ").append(???);
              paraml = new PrintWriter(new e("FragmentManager"));
              ???.a("  ", paraml, false);
              paraml.close();
            }
            this.vs.add(???);
            if (???.mIndex >= 0) {
              a(???.mIndex, ???);
            }
            i += 1;
          }
        }
        this.vs = null;
        if (localFragmentManagerState.wq >= 0) {
          this.vB = ((Fragment)this.vr.get(localFragmentManagerState.wq));
        }
        this.vp = localFragmentManagerState.vp;
        return;
      }
      ??? = null;
    }
  }
  
  final void a(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = true;
    int j;
    if (paramFragment.mAdded)
    {
      j = paramInt1;
      if (!paramFragment.mDetached) {}
    }
    else
    {
      j = paramInt1;
      if (paramInt1 > 1) {
        j = 1;
      }
    }
    int i = j;
    if (paramFragment.mRemoving)
    {
      i = j;
      if (j > paramFragment.mState)
      {
        if ((paramFragment.mState != 0) || (!paramFragment.isInBackStack())) {
          break label127;
        }
        i = 1;
      }
    }
    paramInt1 = i;
    if (paramFragment.mDeferStart)
    {
      paramInt1 = i;
      if (paramFragment.mState < 4)
      {
        paramInt1 = i;
        if (i > 3) {
          paramInt1 = 3;
        }
      }
    }
    label127:
    Object localObject1;
    label543:
    label573:
    label595:
    label725:
    Object localObject3;
    if (paramFragment.mState <= paramInt1)
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {}
      do
      {
        return;
        i = paramFragment.mState;
        break;
        if ((paramFragment.getAnimatingAway() != null) || (paramFragment.getAnimator() != null))
        {
          paramFragment.setAnimatingAway(null);
          paramFragment.setAnimator(null);
          a(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
        }
        paramInt3 = paramInt1;
        i = paramInt1;
        j = paramInt1;
        paramInt2 = paramInt1;
        switch (paramFragment.mState)
        {
        default: 
          i = paramInt1;
        }
      } while (paramFragment.mState == i);
      new StringBuilder("moveToState: Fragment state for ").append(paramFragment).append(" not updated inline; expected state ").append(i).append(" found ").append(paramFragment.mState);
      paramFragment.mState = i;
      return;
      paramInt3 = paramInt1;
      if (paramInt1 > 0)
      {
        if (DEBUG) {
          new StringBuilder("moveto CREATED: ").append(paramFragment);
        }
        paramInt3 = paramInt1;
        if (paramFragment.mSavedFragmentState != null)
        {
          paramFragment.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
          paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
          paramFragment.mTarget = d(paramFragment.mSavedFragmentState, "android:target_state");
          if (paramFragment.mTarget != null) {
            paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
          }
          if (paramFragment.mSavedUserVisibleHint == null) {
            break label543;
          }
          paramFragment.mUserVisibleHint = paramFragment.mSavedUserVisibleHint.booleanValue();
          paramFragment.mSavedUserVisibleHint = null;
          paramInt3 = paramInt1;
          if (!paramFragment.mUserVisibleHint)
          {
            paramFragment.mDeferStart = true;
            paramInt3 = paramInt1;
            if (paramInt1 > 3) {
              paramInt3 = 3;
            }
          }
        }
        paramFragment.mHost = this.mHost;
        paramFragment.mParentFragment = this.vA;
        if (this.vA != null) {}
        for (localObject1 = this.vA.mChildFragmentManager;; localObject1 = this.mHost.mFragmentManager)
        {
          paramFragment.mFragmentManager = ((k)localObject1);
          if (paramFragment.mTarget == null) {
            break label595;
          }
          if (this.vr.get(paramFragment.mTarget.mIndex) == paramFragment.mTarget) {
            break label573;
          }
          throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.mTarget + " that does not belong to this FragmentManager!");
          paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
          break;
        }
        if (paramFragment.mTarget.mState <= 0) {
          a(paramFragment.mTarget, 1, 0, 0, true);
        }
        a(paramFragment, this.mHost.mContext, false);
        paramFragment.mCalled = false;
        paramFragment.onAttach(this.mHost.mContext);
        if (!paramFragment.mCalled) {
          throw new ae("Fragment " + paramFragment + " did not call through to super.onAttach()");
        }
        if (paramFragment.mParentFragment == null)
        {
          this.mHost.onAttachFragment(paramFragment);
          label677:
          b(paramFragment, this.mHost.mContext, false);
          if (paramFragment.mIsCreated) {
            break label1329;
          }
          a(paramFragment, paramFragment.mSavedFragmentState, false);
          paramFragment.performCreate(paramFragment.mSavedFragmentState);
          b(paramFragment, paramFragment.mSavedFragmentState, false);
          paramFragment.mRetaining = false;
        }
      }
      else
      {
        if ((paramFragment.mFromLayout) && (!paramFragment.mPerformedCreateView))
        {
          paramFragment.mView = paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
          if (paramFragment.mView == null) {
            break label1345;
          }
          paramFragment.mInnerView = paramFragment.mView;
          paramFragment.mView.setSaveFromParentEnabled(false);
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          a(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
        }
        i = paramInt3;
        if (paramInt3 > 1)
        {
          if (DEBUG) {
            new StringBuilder("moveto ACTIVITY_CREATED: ").append(paramFragment);
          }
          if (!paramFragment.mFromLayout)
          {
            if (paramFragment.mContainerId == 0) {
              break label2115;
            }
            if (paramFragment.mContainerId == -1) {
              a(new IllegalArgumentException("Cannot create fragment " + paramFragment + " for a container view with no id"));
            }
            localObject3 = (ViewGroup)this.vz.onFindViewById(paramFragment.mContainerId);
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = localObject3;
              if (paramFragment.mRestored) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      label1329:
      label1345:
      Object localObject2;
      try
      {
        localObject1 = paramFragment.getResources().getResourceName(paramFragment.mContainerId);
        a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + (String)localObject1 + ") for fragment " + paramFragment));
        localObject1 = localObject3;
        paramFragment.mContainer = ((ViewGroup)localObject1);
        paramFragment.mView = paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject1, paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null)
        {
          paramFragment.mInnerView = paramFragment.mView;
          paramFragment.mView.setSaveFromParentEnabled(false);
          if (localObject1 != null) {
            ((ViewGroup)localObject1).addView(paramFragment.mView);
          }
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          a(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
          if ((paramFragment.mView.getVisibility() == 0) && (paramFragment.mContainer != null))
          {
            paramBoolean = bool;
            paramFragment.mIsNewlyAdded = paramBoolean;
            paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
            c(paramFragment, paramFragment.mSavedFragmentState, false);
            if (paramFragment.mView != null) {
              paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
            }
            paramFragment.mSavedFragmentState = null;
            i = paramInt3;
            j = i;
            if (i > 2)
            {
              paramFragment.mState = 3;
              j = i;
            }
            paramInt2 = j;
            if (j > 3)
            {
              if (DEBUG) {
                new StringBuilder("moveto STARTED: ").append(paramFragment);
              }
              paramFragment.performStart();
              b(paramFragment, false);
              paramInt2 = j;
            }
            i = paramInt2;
            if (paramInt2 <= 4) {
              break;
            }
            if (DEBUG) {
              new StringBuilder("moveto RESUMED: ").append(paramFragment);
            }
            paramFragment.performResume();
            c(paramFragment, false);
            paramFragment.mSavedFragmentState = null;
            paramFragment.mSavedViewState = null;
            i = paramInt2;
            break;
            paramFragment.mParentFragment.onAttachFragment(paramFragment);
            break label677;
            paramFragment.restoreChildFragmentState(paramFragment.mSavedFragmentState);
            paramFragment.mState = 1;
            break label725;
            paramFragment.mInnerView = null;
          }
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        localObject2 = "unknown";
        continue;
        paramBoolean = false;
        continue;
        paramFragment.mInnerView = null;
        continue;
      }
      i = paramInt1;
      if (paramFragment.mState <= paramInt1) {
        break;
      }
      switch (paramFragment.mState)
      {
      default: 
        i = paramInt1;
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        label1471:
        do
        {
          i = paramInt1;
          if (paramInt1 > 0) {
            break;
          }
          if (this.vF)
          {
            if (paramFragment.getAnimatingAway() == null) {
              break label1938;
            }
            localObject2 = paramFragment.getAnimatingAway();
            paramFragment.setAnimatingAway(null);
            ((View)localObject2).clearAnimation();
          }
          if ((paramFragment.getAnimatingAway() == null) && (paramFragment.getAnimator() == null)) {
            break label1964;
          }
          paramFragment.setStateAfterAnimating(paramInt1);
          i = 1;
          break;
          if (paramInt1 < 5)
          {
            if (DEBUG) {
              new StringBuilder("movefrom RESUMED: ").append(paramFragment);
            }
            paramFragment.performPause();
            d(paramFragment, false);
          }
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              new StringBuilder("movefrom STARTED: ").append(paramFragment);
            }
            paramFragment.performStop();
            e(paramFragment, false);
          }
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              new StringBuilder("movefrom STOPPED: ").append(paramFragment);
            }
            paramFragment.performReallyStop();
          }
        } while (paramInt1 >= 2);
        if (DEBUG) {
          new StringBuilder("movefrom ACTIVITY_CREATED: ").append(paramFragment);
        }
        if ((paramFragment.mView != null) && (this.mHost.bN()) && (paramFragment.mSavedViewState == null)) {
          o(paramFragment);
        }
        paramFragment.performDestroyView();
        f(paramFragment, false);
        if ((paramFragment.mView != null) && (paramFragment.mContainer != null))
        {
          paramFragment.mContainer.endViewTransition(paramFragment.mView);
          paramFragment.mView.clearAnimation();
          if ((this.vy <= 0) || (this.vF) || (paramFragment.mView.getVisibility() != 0) || (paramFragment.mPostponedAlpha < 0.0F)) {
            break label2109;
          }
        }
        label1938:
        label1964:
        label2109:
        for (localObject2 = a(paramFragment, paramInt2, false, paramInt3);; localObject2 = null)
        {
          paramFragment.mPostponedAlpha = 0.0F;
          final ViewGroup localViewGroup;
          Object localObject4;
          if (localObject2 != null)
          {
            localObject3 = paramFragment.mView;
            localViewGroup = paramFragment.mContainer;
            localViewGroup.startViewTransition((View)localObject3);
            paramFragment.setStateAfterAnimating(paramInt1);
            if (((c)localObject2).wb == null) {
              break label1878;
            }
            localObject4 = new e(((c)localObject2).wb, localViewGroup, (View)localObject3);
            paramFragment.setAnimatingAway(paramFragment.mView);
            ((Animation)localObject4).setAnimationListener(new b(e((Animation)localObject4), localViewGroup)
            {
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                super.onAnimationEnd(paramAnonymousAnimation);
                localViewGroup.post(new Runnable()
                {
                  public final void run()
                  {
                    if (k.2.this.val$fragment.getAnimatingAway() != null)
                    {
                      k.2.this.val$fragment.setAnimatingAway(null);
                      k.this.a(k.2.this.val$fragment, k.2.this.val$fragment.getStateAfterAnimating(), 0, 0, false);
                    }
                  }
                });
              }
            });
            a((View)localObject3, (c)localObject2);
            paramFragment.mView.startAnimation((Animation)localObject4);
          }
          for (;;)
          {
            paramFragment.mContainer.removeView(paramFragment.mView);
            paramFragment.mContainer = null;
            paramFragment.mView = null;
            paramFragment.mInnerView = null;
            paramFragment.mInLayout = false;
            break;
            label1878:
            localObject4 = ((c)localObject2).wc;
            paramFragment.setAnimator(((c)localObject2).wc);
            ((Animator)localObject4).addListener(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                localViewGroup.endViewTransition(this.vX);
                paramAnonymousAnimator = paramFragment.getAnimator();
                paramFragment.setAnimator(null);
                if ((paramAnonymousAnimator != null) && (localViewGroup.indexOfChild(this.vX) < 0)) {
                  k.this.a(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, false);
                }
              }
            });
            ((Animator)localObject4).setTarget(paramFragment.mView);
            a(paramFragment.mView, (c)localObject2);
            ((Animator)localObject4).start();
          }
          if (paramFragment.getAnimator() == null) {
            break label1471;
          }
          localObject2 = paramFragment.getAnimator();
          paramFragment.setAnimator(null);
          ((Animator)localObject2).cancel();
          break label1471;
          if (DEBUG) {
            new StringBuilder("movefrom CREATED: ").append(paramFragment);
          }
          if (!paramFragment.mRetaining)
          {
            paramFragment.performDestroy();
            g(paramFragment, false);
          }
          for (;;)
          {
            paramFragment.performDetach();
            h(paramFragment, false);
            i = paramInt1;
            if (paramBoolean) {
              break;
            }
            if (paramFragment.mRetaining) {
              break label2088;
            }
            i = paramInt1;
            if (paramFragment.mIndex < 0) {
              break;
            }
            if (DEBUG) {
              new StringBuilder("Freeing fragment index ").append(paramFragment);
            }
            this.vr.put(paramFragment.mIndex, null);
            paramFragment.initState();
            i = paramInt1;
            break;
            paramFragment.mState = 0;
          }
          paramFragment.mHost = null;
          paramFragment.mParentFragment = null;
          paramFragment.mFragmentManager = null;
          i = paramInt1;
          break;
        }
        label2088:
        label2115:
        localObject2 = null;
      }
    }
  }
  
  public final void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (DEBUG) {
      new StringBuilder("add: ").append(paramFragment);
    }
    i(paramFragment);
    if (!paramFragment.mDetached) {
      if (this.vq.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
    }
    synchronized (this.vq)
    {
      this.vq.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if (paramFragment.mView == null) {
        paramFragment.mHiddenChanged = false;
      }
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.vD = true;
      }
      if (paramBoolean) {
        g(paramFragment);
      }
      return;
    }
  }
  
  public final void a(i parami, g paramg, Fragment paramFragment)
  {
    if (this.mHost != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mHost = parami;
    this.vz = paramg;
    this.vA = paramFragment;
  }
  
  public final void a(g paramg, boolean paramBoolean)
  {
    if (!paramBoolean) {
      bS();
    }
    try
    {
      if ((this.vF) || (this.mHost == null))
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally {}
    if (this.vn == null) {
      this.vn = new ArrayList();
    }
    this.vn.add(paramg);
    bT();
  }
  
  final boolean a(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    if (this.vs == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = this.vs.size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(this.vs.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
    }
    for (;;)
    {
      return true;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int j = this.vs.size() - 1;
        b localb;
        while (j >= 0)
        {
          localb = (b)this.vs.get(j);
          if (((paramString != null) && (paramString.equals(localb.mName))) || ((paramInt1 >= 0) && (paramInt1 == localb.mIndex))) {
            break;
          }
          j -= 1;
        }
        if (j < 0) {
          return false;
        }
        i = j;
        if ((paramInt2 & 0x1) != 0)
        {
          paramInt2 = j - 1;
          for (;;)
          {
            i = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            localb = (b)this.vs.get(paramInt2);
            if ((paramString == null) || (!paramString.equals(localb.mName)))
            {
              i = paramInt2;
              if (paramInt1 < 0) {
                break;
              }
              i = paramInt2;
              if (paramInt1 != localb.mIndex) {
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
      }
      if (i == this.vs.size() - 1) {
        return false;
      }
      paramInt1 = this.vs.size() - 1;
      while (paramInt1 > i)
      {
        paramArrayList.add(this.vs.remove(paramInt1));
        paramArrayList1.add(Boolean.valueOf(true));
        paramInt1 -= 1;
      }
    }
  }
  
  public final void ab(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt);
    }
    a(new h(paramInt, 1), false);
  }
  
  final void ac(int paramInt)
  {
    try
    {
      this.vo = true;
      k(paramInt, false);
      this.vo = false;
      execPendingActions();
      return;
    }
    finally
    {
      this.vo = false;
    }
  }
  
  public final void b(g paramg, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.mHost == null) || (this.vF))) {
      return;
    }
    y(paramBoolean);
    if (paramg.c(this.vI, this.vJ)) {
      this.vo = true;
    }
    try
    {
      e(this.vI, this.vJ);
      bU();
      bW();
      return;
    }
    finally
    {
      bU();
    }
  }
  
  public final o bP()
  {
    return new b(this);
  }
  
  public final Fragment d(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      localFragment = (Fragment)this.vr.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    a(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  public final void dispatchActivityCreated()
  {
    this.vE = false;
    this.mStopped = false;
    ac(2);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    int i = 0;
    while (i < this.vq.size())
    {
      Fragment localFragment = (Fragment)this.vq.get(i);
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
      i += 1;
    }
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.vy <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.vq.size())
      {
        Fragment localFragment = (Fragment)this.vq.get(i);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchCreate()
  {
    this.vE = false;
    this.mStopped = false;
    ac(1);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int j = 0;
    if (this.vy <= 0) {
      return false;
    }
    Object localObject1 = null;
    int i = 0;
    boolean bool1 = false;
    while (i < this.vq.size())
    {
      Fragment localFragment = (Fragment)this.vq.get(i);
      Object localObject2 = localObject1;
      boolean bool2 = bool1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
        {
          bool2 = true;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localFragment);
        }
      }
      i += 1;
      bool1 = bool2;
      localObject1 = localObject2;
    }
    if (this.vt != null)
    {
      i = j;
      while (i < this.vt.size())
      {
        paramMenu = (Fragment)this.vt.get(i);
        if ((localObject1 == null) || (!localObject1.contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i += 1;
      }
    }
    this.vt = localObject1;
    return bool1;
  }
  
  public final void dispatchDestroy()
  {
    this.vF = true;
    execPendingActions();
    ac(0);
    this.mHost = null;
    this.vz = null;
    this.vA = null;
  }
  
  public final void dispatchLowMemory()
  {
    int i = 0;
    while (i < this.vq.size())
    {
      Fragment localFragment = (Fragment)this.vq.get(i);
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
      i += 1;
    }
  }
  
  public final void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    int i = this.vq.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.vq.get(i);
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.vy <= 0) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.vq.size())
      {
        Fragment localFragment = (Fragment)this.vq.get(i);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.vy <= 0) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.vq.size())
      {
        Fragment localFragment = (Fragment)this.vq.get(i);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
        i += 1;
      }
    }
  }
  
  public final void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    int i = this.vq.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.vq.get(i);
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.vy <= 0) {
      return false;
    }
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < this.vq.size(); bool1 = bool2)
    {
      Fragment localFragment = (Fragment)this.vq.get(i);
      bool2 = bool1;
      if (localFragment != null)
      {
        bool2 = bool1;
        if (localFragment.performPrepareOptionsMenu(paramMenu)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public final void dispatchResume()
  {
    this.vE = false;
    this.mStopped = false;
    ac(5);
  }
  
  public final void dispatchStart()
  {
    this.vE = false;
    this.mStopped = false;
    ac(4);
  }
  
  public final void dispatchStop()
  {
    this.mStopped = true;
    ac(3);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    int i;
    if (this.vr != null)
    {
      k = this.vr.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < k)
        {
          Fragment localFragment = (Fragment)this.vr.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment);
          if (localFragment != null) {
            localFragment.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    int k = this.vq.size();
    if (k > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i = 0;
      while (i < k)
      {
        paramFileDescriptor = (Fragment)this.vq.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
    if (this.vt != null)
    {
      k = this.vt.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (Fragment)this.vt.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    if (this.vs != null)
    {
      k = this.vs.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (b)this.vs.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.a(str, paramPrintWriter);
          i += 1;
        }
      }
    }
    try
    {
      if (this.vu != null)
      {
        k = this.vu.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < k)
          {
            paramFileDescriptor = (b)this.vu.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((this.vv != null) && (this.vv.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.vv.toArray()));
      }
      if (this.vn != null)
      {
        k = this.vn.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = j;
          while (i < k)
          {
            paramFileDescriptor = (g)this.vn.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mHost=");
    paramPrintWriter.println(this.mHost);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.vz);
    if (this.vA != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.vA);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.vy);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.vE);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.vF);
    if (this.vD)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.vD);
    }
    if (this.vG != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.vG);
    }
  }
  
  public final Fragment.SavedState e(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (paramFragment.mIndex < 0) {
      a(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (paramFragment.mState > 0)
    {
      paramFragment = p(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return localObject1;
  }
  
  public final boolean execPendingActions()
  {
    y(true);
    boolean bool = false;
    for (;;)
    {
      if (f(this.vI, this.vJ)) {
        this.vo = true;
      }
      try
      {
        e(this.vI, this.vJ);
        bU();
        bool = true;
      }
      finally
      {
        bU();
      }
    }
    bZ();
    return bool;
  }
  
  public final boolean executePendingTransactions()
  {
    boolean bool = execPendingActions();
    bV();
    return bool;
  }
  
  public final void f(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (this.vo) {
        this.vH = true;
      }
    }
    else {
      return;
    }
    paramFragment.mDeferStart = false;
    a(paramFragment, this.vy, 0, 0, false);
  }
  
  public final Fragment findFragmentByWho(String paramString)
  {
    if ((this.vr != null) && (paramString != null))
    {
      int i = this.vr.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)this.vr.valueAt(i);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment != null) {
            return localFragment;
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public final List<Fragment> getFragments()
  {
    if (this.vq.isEmpty()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.vq)
    {
      List localList = (List)this.vq.clone();
      return localList;
    }
  }
  
  final void h(final Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    int j = this.vy;
    int i = j;
    label32:
    Object localObject3;
    Object localObject1;
    label79:
    Object localObject2;
    label230:
    boolean bool;
    if (paramFragment.mRemoving)
    {
      if (paramFragment.isInBackStack()) {
        i = Math.min(j, 1);
      }
    }
    else
    {
      a(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
      if (paramFragment.mView != null)
      {
        localObject3 = paramFragment.mContainer;
        localObject1 = paramFragment.mView;
        if ((localObject3 != null) && (localObject1 != null)) {
          break label383;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = ((Fragment)localObject1).mView;
          localObject2 = paramFragment.mContainer;
          i = ((ViewGroup)localObject2).indexOfChild((View)localObject1);
          j = ((ViewGroup)localObject2).indexOfChild(paramFragment.mView);
          if (j < i)
          {
            ((ViewGroup)localObject2).removeViewAt(j);
            ((ViewGroup)localObject2).addView(paramFragment.mView, i);
          }
        }
        if ((paramFragment.mIsNewlyAdded) && (paramFragment.mContainer != null))
        {
          if (paramFragment.mPostponedAlpha > 0.0F) {
            paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha);
          }
          paramFragment.mPostponedAlpha = 0.0F;
          paramFragment.mIsNewlyAdded = false;
          localObject1 = a(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
          if (localObject1 != null)
          {
            a(paramFragment.mView, (c)localObject1);
            if (((c)localObject1).wb == null) {
              break label446;
            }
            paramFragment.mView.startAnimation(((c)localObject1).wb);
          }
        }
      }
      if (!paramFragment.mHiddenChanged) {
        break label467;
      }
      if (paramFragment.mView != null)
      {
        i = paramFragment.getNextTransition();
        if (paramFragment.mHidden) {
          break label469;
        }
        bool = true;
        label259:
        localObject1 = a(paramFragment, i, bool, paramFragment.getNextTransitionStyle());
        if ((localObject1 == null) || (((c)localObject1).wc == null)) {
          break label529;
        }
        ((c)localObject1).wc.setTarget(paramFragment.mView);
        if (!paramFragment.mHidden) {
          break label518;
        }
        if (!paramFragment.isHideReplaced()) {
          break label475;
        }
        paramFragment.setHideReplaced(false);
      }
    }
    for (;;)
    {
      a(paramFragment.mView, (c)localObject1);
      ((c)localObject1).wc.start();
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.vD = true;
      }
      paramFragment.mHiddenChanged = false;
      paramFragment.onHiddenChanged(paramFragment.mHidden);
      return;
      i = Math.min(j, 0);
      break label32;
      label383:
      i = this.vq.indexOf(paramFragment) - 1;
      for (;;)
      {
        if (i < 0) {
          break label440;
        }
        localObject2 = (Fragment)this.vq.get(i);
        if (((Fragment)localObject2).mContainer == localObject3)
        {
          localObject1 = localObject2;
          if (((Fragment)localObject2).mView != null) {
            break;
          }
        }
        i -= 1;
      }
      label440:
      localObject1 = null;
      break label79;
      label446:
      ((c)localObject1).wc.setTarget(paramFragment.mView);
      ((c)localObject1).wc.start();
      break label230;
      label467:
      break;
      label469:
      bool = false;
      break label259;
      label475:
      localObject2 = paramFragment.mContainer;
      localObject3 = paramFragment.mView;
      ((ViewGroup)localObject2).startViewTransition((View)localObject3);
      ((c)localObject1).wc.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          this.vV.endViewTransition(this.vY);
          paramAnonymousAnimator.removeListener(this);
          if (paramFragment.mView != null) {
            paramFragment.mView.setVisibility(8);
          }
        }
      });
      continue;
      label518:
      paramFragment.mView.setVisibility(0);
    }
    label529:
    if (localObject1 != null)
    {
      a(paramFragment.mView, (c)localObject1);
      paramFragment.mView.startAnimation(((c)localObject1).wb);
      ((c)localObject1).wb.start();
    }
    if ((paramFragment.mHidden) && (!paramFragment.isHideReplaced())) {}
    for (i = 8;; i = 0)
    {
      paramFragment.mView.setVisibility(i);
      if (!paramFragment.isHideReplaced()) {
        break;
      }
      paramFragment.setHideReplaced(false);
      break;
    }
  }
  
  final void i(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {}
    do
    {
      return;
      int i = this.vp;
      this.vp = (i + 1);
      paramFragment.setIndex(i, this.vA);
      if (this.vr == null) {
        this.vr = new SparseArray();
      }
      this.vr.put(paramFragment.mIndex, paramFragment);
    } while (!DEBUG);
    new StringBuilder("Allocated fragment index ").append(paramFragment);
  }
  
  public final boolean isStateSaved()
  {
    return (this.vE) || (this.mStopped);
  }
  
  public final void j(Fragment paramFragment)
  {
    if (DEBUG) {
      new StringBuilder("remove: ").append(paramFragment).append(" nesting=").append(paramFragment.mBackStackNesting);
    }
    int i;
    if (!paramFragment.isInBackStack()) {
      i = 1;
    }
    for (;;)
    {
      if ((!paramFragment.mDetached) || (i != 0)) {}
      synchronized (this.vq)
      {
        this.vq.remove(paramFragment);
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.vD = true;
        }
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        return;
        i = 0;
      }
    }
  }
  
  final void k(int paramInt, boolean paramBoolean)
  {
    if ((this.mHost == null) && (paramInt != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.vy)) {}
    do
    {
      do
      {
        return;
        this.vy = paramInt;
      } while (this.vr == null);
      int i = this.vq.size();
      paramInt = 0;
      while (paramInt < i)
      {
        h((Fragment)this.vq.get(paramInt));
        paramInt += 1;
      }
      i = this.vr.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Fragment localFragment = (Fragment)this.vr.valueAt(paramInt);
        if ((localFragment != null) && ((localFragment.mRemoving) || (localFragment.mDetached)) && (!localFragment.mIsNewlyAdded)) {
          h(localFragment);
        }
        paramInt += 1;
      }
      bR();
    } while ((!this.vD) || (this.mHost == null) || (this.vy != 5));
    this.mHost.bO();
    this.vD = false;
  }
  
  public final void m(Fragment paramFragment)
  {
    if (DEBUG) {
      new StringBuilder("detach: ").append(paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded) {
        if (DEBUG) {
          new StringBuilder("remove from detach: ").append(paramFragment);
        }
      }
    }
    synchronized (this.vq)
    {
      this.vq.remove(paramFragment);
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.vD = true;
      }
      paramFragment.mAdded = false;
      return;
    }
  }
  
  public final void n(Fragment paramFragment)
  {
    if (DEBUG) {
      new StringBuilder("attach: ").append(paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.vq.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          new StringBuilder("add from attach: ").append(paramFragment);
        }
      }
    }
    synchronized (this.vq)
    {
      this.vq.add(paramFragment);
      paramFragment.mAdded = true;
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.vD = true;
      }
      return;
    }
  }
  
  public final void noteStateNotSaved()
  {
    this.vO = null;
    this.vE = false;
    this.mStopped = false;
    int j = this.vq.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)this.vq.get(i);
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
      i += 1;
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, f.wf);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int k = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if (!Fragment.isSupportFragmentClass(this.mHost.mContext, str1)) {
        return null;
      }
      if (paramView != null) {}
      for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      }
      int j;
      if (k != -1)
      {
        paramString = Z(k);
        paramView = paramString;
        if (paramString == null)
        {
          paramView = paramString;
          if (str2 != null) {
            paramView = G(str2);
          }
        }
        paramString = paramView;
        if (paramView == null)
        {
          paramString = paramView;
          if (i != -1) {
            paramString = Z(i);
          }
        }
        if (DEBUG) {
          new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(k)).append(" fname=").append(str1).append(" existing=").append(paramString);
        }
        if (paramString != null) {
          break label418;
        }
        paramView = this.vz.instantiate(paramContext, str1, null);
        paramView.mFromLayout = true;
        if (k == 0) {
          break label411;
        }
        j = k;
        label285:
        paramView.mFragmentId = j;
        paramView.mContainerId = i;
        paramView.mTag = str2;
        paramView.mInLayout = true;
        paramView.mFragmentManager = this;
        paramView.mHost = this.mHost;
        paramView.onInflate(this.mHost.mContext, paramAttributeSet, paramView.mSavedFragmentState);
        a(paramView, true);
        label344:
        if ((this.vy > 0) || (!paramView.mFromLayout)) {
          break label545;
        }
        a(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (paramView.mView != null) {
          break label553;
        }
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        paramString = null;
        break;
        label411:
        j = i;
        break label285;
        label418:
        if (paramString.mInLayout) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
        }
        paramString.mInLayout = true;
        paramString.mHost = this.mHost;
        if (!paramString.mRetaining) {
          paramString.onInflate(this.mHost.mContext, paramAttributeSet, paramString.mSavedFragmentState);
        }
        paramView = paramString;
        break label344;
        label545:
        g(paramView);
      }
      label553:
      if (k != 0) {
        paramView.mView.setId(k);
      }
      if (paramView.mView.getTag() == null) {
        paramView.mView.setTag(str2);
      }
      return paramView.mView;
    }
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final void popBackStack()
  {
    a(new h(-1, 0), false);
  }
  
  public final boolean popBackStackImmediate()
  {
    bS();
    return bQ();
  }
  
  public final void q(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((this.vr.get(paramFragment.mIndex) != paramFragment) || ((paramFragment.mHost != null) && (paramFragment.getFragmentManager() != this)))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    this.vB = paramFragment;
  }
  
  final Parcelable saveAllState()
  {
    Object localObject3 = null;
    int k = 0;
    bV();
    label20:
    Object localObject1;
    Object localObject2;
    if (this.vr == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        break label141;
      }
      localObject1 = (Fragment)this.vr.valueAt(j);
      if (localObject1 != null)
      {
        if (((Fragment)localObject1).getAnimatingAway() == null) {
          break label122;
        }
        m = ((Fragment)localObject1).getStateAfterAnimating();
        localObject2 = ((Fragment)localObject1).getAnimatingAway();
        localObject4 = ((View)localObject2).getAnimation();
        if (localObject4 != null)
        {
          ((Animation)localObject4).cancel();
          ((View)localObject2).clearAnimation();
        }
        ((Fragment)localObject1).setAnimatingAway(null);
        a((Fragment)localObject1, m, 0, 0, false);
      }
    }
    for (;;)
    {
      j += 1;
      break label20;
      i = this.vr.size();
      break;
      label122:
      if (((Fragment)localObject1).getAnimator() != null) {
        ((Fragment)localObject1).getAnimator().end();
      }
    }
    label141:
    execPendingActions();
    this.vE = true;
    this.vO = null;
    if ((this.vr == null) || (this.vr.size() <= 0)) {
      return null;
    }
    int m = this.vr.size();
    Object localObject4 = new FragmentState[m];
    int j = 0;
    int i = 0;
    label195:
    if (j < m)
    {
      localObject1 = (Fragment)this.vr.valueAt(j);
      if (localObject1 == null) {
        break label824;
      }
      if (((Fragment)localObject1).mIndex < 0) {
        a(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).mIndex));
      }
      localObject2 = new FragmentState((Fragment)localObject1);
      localObject4[j] = localObject2;
      if ((((Fragment)localObject1).mState > 0) && (((FragmentState)localObject2).mSavedFragmentState == null))
      {
        ((FragmentState)localObject2).mSavedFragmentState = p((Fragment)localObject1);
        if (((Fragment)localObject1).mTarget != null)
        {
          if (((Fragment)localObject1).mTarget.mIndex < 0) {
            a(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).mTarget));
          }
          if (((FragmentState)localObject2).mSavedFragmentState == null) {
            ((FragmentState)localObject2).mSavedFragmentState = new Bundle();
          }
          a(((FragmentState)localObject2).mSavedFragmentState, "android:target_state", ((Fragment)localObject1).mTarget);
          if (((Fragment)localObject1).mTargetRequestCode != 0) {
            ((FragmentState)localObject2).mSavedFragmentState.putInt("android:target_req_state", ((Fragment)localObject1).mTargetRequestCode);
          }
        }
        if (DEBUG) {
          new StringBuilder("Saved state of ").append(localObject1).append(": ").append(((FragmentState)localObject2).mSavedFragmentState);
        }
        i = 1;
      }
    }
    label437:
    label824:
    for (;;)
    {
      j += 1;
      break label195;
      ((FragmentState)localObject2).mSavedFragmentState = ((Fragment)localObject1).mSavedFragmentState;
      break label437;
      if (i == 0) {
        break;
      }
      j = this.vq.size();
      if (j > 0)
      {
        localObject2 = new int[j];
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject2[i] = ((Fragment)this.vq.get(i)).mIndex;
          if (localObject2[i] < 0) {
            a(new IllegalStateException("Failure saving state: active " + this.vq.get(i) + " has cleared index: " + localObject2[i]));
          }
          if (DEBUG) {
            new StringBuilder("saveAllState: adding fragment #").append(i).append(": ").append(this.vq.get(i));
          }
          i += 1;
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (this.vs != null)
      {
        j = this.vs.size();
        localObject2 = localObject3;
        if (j > 0)
        {
          localObject3 = new BackStackState[j];
          i = k;
          for (;;)
          {
            localObject2 = localObject3;
            if (i >= j) {
              break;
            }
            localObject3[i] = new BackStackState((b)this.vs.get(i));
            if (DEBUG) {
              new StringBuilder("saveAllState: adding back stack #").append(i).append(": ").append(this.vs.get(i));
            }
            i += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).wn = ((FragmentState[])localObject4);
      ((FragmentManagerState)localObject3).wo = ((int[])localObject1);
      ((FragmentManagerState)localObject3).wp = ((BackStackState[])localObject2);
      if (this.vB != null) {
        ((FragmentManagerState)localObject3).wq = this.vB.mIndex;
      }
      ((FragmentManagerState)localObject3).vp = this.vp;
      bY();
      return localObject3;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.vA != null) {
      d.a(this.vA, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      d.a(this.mHost, localStringBuilder);
    }
  }
  
  private static final class a
    extends k.b
  {
    View mView;
    
    a(View paramView, Animation.AnimationListener paramAnimationListener)
    {
      super((byte)0);
      this.mView = paramView;
    }
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      if ((q.ao(this.mView)) || (Build.VERSION.SDK_INT >= 24)) {
        this.mView.post(new Runnable()
        {
          public final void run()
          {
            k.a.this.mView.setLayerType(0, null);
          }
        });
      }
      for (;;)
      {
        super.onAnimationEnd(paramAnimation);
        return;
        this.mView.setLayerType(0, null);
      }
    }
  }
  
  private static class b
    implements Animation.AnimationListener
  {
    private final Animation.AnimationListener wa;
    
    private b(Animation.AnimationListener paramAnimationListener)
    {
      this.wa = paramAnimationListener;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (this.wa != null) {
        this.wa.onAnimationEnd(paramAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation)
    {
      if (this.wa != null) {
        this.wa.onAnimationRepeat(paramAnimation);
      }
    }
    
    public void onAnimationStart(Animation paramAnimation)
    {
      if (this.wa != null) {
        this.wa.onAnimationStart(paramAnimation);
      }
    }
  }
  
  private static final class c
  {
    public final Animation wb;
    public final Animator wc;
    
    private c(Animator paramAnimator)
    {
      this.wb = null;
      this.wc = paramAnimator;
      if (paramAnimator == null) {
        throw new IllegalStateException("Animator cannot be null");
      }
    }
    
    private c(Animation paramAnimation)
    {
      this.wb = paramAnimation;
      this.wc = null;
      if (paramAnimation == null) {
        throw new IllegalStateException("Animation cannot be null");
      }
    }
  }
  
  private static final class d
    extends AnimatorListenerAdapter
  {
    View mView;
    
    d(View paramView)
    {
      this.mView = paramView;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      this.mView.setLayerType(0, null);
      paramAnimator.removeListener(this);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      this.mView.setLayerType(2, null);
    }
  }
  
  private static final class e
    extends AnimationSet
    implements Runnable
  {
    private boolean so;
    private final ViewGroup tQ;
    private final View wd;
    private boolean we;
    
    e(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
    {
      super();
      this.tQ = paramViewGroup;
      this.wd = paramView;
      addAnimation(paramAnimation);
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation)
    {
      if (this.so) {
        if (this.we) {}
      }
      while (super.getTransformation(paramLong, paramTransformation))
      {
        return true;
        return false;
      }
      this.so = true;
      ab.a(this.tQ, this);
      return true;
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
    {
      if (this.so) {
        if (this.we) {}
      }
      while (super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        return true;
        return false;
      }
      this.so = true;
      ab.a(this.tQ, this);
      return true;
    }
    
    public final void run()
    {
      this.tQ.endViewTransition(this.wd);
      this.we = true;
    }
  }
  
  static final class f
  {
    public static final int[] wf = { 16842755, 16842960, 16842961 };
  }
  
  static abstract interface g
  {
    public abstract boolean c(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1);
  }
  
  private final class h
    implements k.g
  {
    final int mId;
    final String mName = null;
    final int wg;
    
    h(int paramInt1, int paramInt2)
    {
      this.mId = paramInt1;
      this.wg = paramInt2;
    }
    
    public final boolean c(ArrayList<b> paramArrayList, ArrayList<Boolean> paramArrayList1)
    {
      if ((k.this.vB != null) && (this.mId < 0) && (this.mName == null))
      {
        j localj = k.this.vB.peekChildFragmentManager();
        if ((localj != null) && (localj.popBackStackImmediate())) {
          return false;
        }
      }
      return k.this.a(paramArrayList, paramArrayList1, this.mName, this.mId, this.wg);
    }
  }
  
  static final class i
    implements Fragment.c
  {
    final boolean wh;
    final b wi;
    int wj;
    
    i(b paramb, boolean paramBoolean)
    {
      this.wh = paramBoolean;
      this.wi = paramb;
    }
    
    public final void bM()
    {
      this.wj -= 1;
      if (this.wj != 0) {
        return;
      }
      k.b(this.wi.ug);
    }
    
    public final void ca()
    {
      boolean bool1 = false;
      if (this.wj > 0) {}
      for (int i = 1;; i = 0)
      {
        localk = this.wi.ug;
        int k = localk.vq.size();
        int j = 0;
        while (j < k)
        {
          localObject = (Fragment)localk.vq.get(j);
          ((Fragment)localObject).setOnStartEnterTransitionListener(null);
          if ((i != 0) && (((Fragment)localObject).isPostponed())) {
            ((Fragment)localObject).startPostponedEnterTransition();
          }
          j += 1;
        }
      }
      k localk = this.wi.ug;
      Object localObject = this.wi;
      boolean bool2 = this.wh;
      if (i == 0) {
        bool1 = true;
      }
      k.a(localk, (b)localObject, bool2, bool1, true);
    }
    
    public final void cb()
    {
      k.a(this.wi.ug, this.wi, this.wh, false, false);
    }
    
    public final void startListening()
    {
      this.wj += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.k
 * JD-Core Version:    0.7.0.1
 */