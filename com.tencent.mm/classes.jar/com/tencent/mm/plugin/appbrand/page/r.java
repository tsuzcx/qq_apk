package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

@SuppressLint({"ViewConstructor"})
public class r
  extends FrameLayout
{
  private static final int iwf = 2131820566;
  private i gRG;
  private boolean iwg;
  private boolean iwh;
  private r.a iwi;
  final LinkedList<o> iwj;
  private final LinkedList<o> iwk;
  private final LinkedList<Runnable> iwl;
  private v iwm;
  private be iwn;
  private boolean iwo;
  private r.c iwp;
  private String mAppId;
  
  public r(Context paramContext, i parami)
  {
    super(paramContext);
    AppMethodBeat.i(87099);
    this.iwg = false;
    this.iwh = false;
    this.iwj = new LinkedList();
    this.iwk = new LinkedList();
    this.iwl = new LinkedList();
    this.iwo = true;
    this.gRG = parami;
    this.mAppId = parami.mAppId;
    this.iwn = new be.a();
    AppMethodBeat.o(87099);
  }
  
  private o Ek(String paramString)
  {
    AppMethodBeat.i(87121);
    if (this.iwj.size() == 0)
    {
      AppMethodBeat.o(87121);
      return null;
    }
    if (((this.iwj.getFirst() instanceof h)) && (((o)this.iwj.getFirst()).bV(paramString)))
    {
      paramString = (o)this.iwj.getFirst();
      AppMethodBeat.o(87121);
      return paramString;
    }
    AppMethodBeat.o(87121);
    return null;
  }
  
  private o El(String paramString)
  {
    AppMethodBeat.i(87122);
    if (this.iwj.size() < 2)
    {
      AppMethodBeat.o(87122);
      return null;
    }
    ListIterator localListIterator = this.iwj.listIterator(1);
    while (localListIterator.hasNext())
    {
      o localo = (o)localListIterator.next();
      if (((localo instanceof h)) && (localo.bV(paramString)))
      {
        AppMethodBeat.o(87122);
        return localo;
      }
    }
    AppMethodBeat.o(87122);
    return null;
  }
  
  private void a(o paramo, Object paramObject, Runnable paramRunnable)
  {
    AppMethodBeat.i(87142);
    if ((paramObject instanceof Animator))
    {
      paramObject = (Animator)paramObject;
      j(paramo);
      paramo.setTag(iwf, paramObject);
      paramObject.addListener(new r.11(this, paramo));
      paramObject.addListener(new r.13(this, paramRunnable));
      paramObject.start();
      AppMethodBeat.o(87142);
      return;
    }
    if ((paramObject instanceof Animation))
    {
      paramObject = (Animation)paramObject;
      paramObject.setAnimationListener(new r.14(this, paramRunnable, paramo));
      j(paramo);
      paramo.setTag(iwf, paramObject);
      paramo.startAnimation(paramObject);
      AppMethodBeat.o(87142);
      return;
    }
    if (paramObject == null)
    {
      paramRunnable.run();
      AppMethodBeat.o(87142);
      return;
    }
    paramo = new IllegalArgumentException("Page animation should be Animator or Animation");
    AppMethodBeat.o(87142);
    throw paramo;
  }
  
  private void aJa()
  {
    AppMethodBeat.i(87117);
    Iterator localIterator = this.iwl.descendingIterator();
    while (localIterator.hasNext())
    {
      ((Runnable)localIterator.next()).run();
      localIterator.remove();
    }
    this.iwk.clear();
    AppMethodBeat.o(87117);
  }
  
  private v aJc()
  {
    AppMethodBeat.i(141674);
    if (this.iwi != null)
    {
      v localv = this.iwi.vw();
      if (localv != null)
      {
        AppMethodBeat.o(141674);
        return localv;
      }
    }
    AppMethodBeat.o(141674);
    return null;
  }
  
  private o b(String paramString, bf parambf)
  {
    boolean bool = true;
    AppMethodBeat.i(141672);
    if (parambf == bf.izW) {}
    label129:
    while (bool)
    {
      paramString = new h(getContext(), this);
      AppMethodBeat.o(141672);
      return paramString;
      if ((parambf == bf.izU) || (parambf == bf.izV))
      {
        bool = this.gRG.getAppConfig().hgO.zW(paramString);
      }
      else
      {
        int j = this.iwj.size();
        if (parambf == bf.izT) {}
        for (int i = 1;; i = 0)
        {
          if ((this.gRG.getAppConfig().hgO.zW(paramString)) && (j + 1 - i == 1)) {
            break label129;
          }
          bool = false;
          break;
        }
      }
    }
    paramString = new ac(getContext(), this);
    AppMethodBeat.o(141672);
    return paramString;
  }
  
  private void b(o paramo1, o paramo2)
  {
    AppMethodBeat.i(87118);
    Iterator localIterator = this.iwj.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo == paramo1)
      {
        i = 1;
      }
      else
      {
        if (localo == paramo2) {
          break;
        }
        if (i != 0)
        {
          d(localo);
          localIterator.remove();
        }
      }
    }
    AppMethodBeat.o(87118);
  }
  
  private void b(o paramo1, o paramo2, bf parambf)
  {
    AppMethodBeat.i(87119);
    this.iwj.remove(paramo2);
    int i;
    if (!paramo2.mSwiping)
    {
      i = 1;
      if (i == 0) {
        break label127;
      }
      r.5 local5 = new r.5(this, paramo2);
      a(paramo2, i(paramo2), local5);
    }
    for (;;)
    {
      ab.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramo1.getCurrentUrl(), paramo2.getCurrentUrl() });
      paramo1.a(parambf);
      paramo1.aIU();
      if (i == 0) {
        break label135;
      }
      paramo2 = new r.6(this, paramo1);
      a(paramo1, h(paramo1), paramo2);
      AppMethodBeat.o(87119);
      return;
      i = 0;
      break;
      label127:
      d(paramo2);
    }
    label135:
    paramo1.aIW();
    AppMethodBeat.o(87119);
  }
  
  private void b(o paramo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(87120);
        if (paramo == null)
        {
          AppMethodBeat.o(87120);
          return;
        }
        this.iwj.remove(paramo);
        this.iwj.push(paramo);
        this.iwk.remove(paramo);
        paramo.bringToFront();
        requestLayout();
        invalidate();
        paramo.aIU();
        r.8 local8 = new r.8(this, paramo);
        if (paramBoolean)
        {
          a(paramo, f(paramo), local8);
          AppMethodBeat.o(87120);
          continue;
        }
        local8.run();
      }
      finally {}
      AppMethodBeat.o(87120);
    }
  }
  
  private static boolean b(bf parambf)
  {
    return (parambf == bf.izT) || (parambf == bf.izW) || (parambf == bf.izU) || (parambf == bf.izV);
  }
  
  private static boolean c(bf parambf)
  {
    AppMethodBeat.i(87116);
    boolean bool = com.tencent.mm.compatible.loader.a.contains(new bf[] { bf.izW, bf.izU, bf.izV }, parambf);
    AppMethodBeat.o(87116);
    return bool;
  }
  
  private void d(o paramo)
  {
    AppMethodBeat.i(87123);
    paramo.setVisibility(8);
    paramo.aIV();
    paramo.performDestroy();
    removeView(paramo);
    paramo.wm();
    AppMethodBeat.o(87123);
  }
  
  private static void j(o paramo)
  {
    AppMethodBeat.i(87141);
    paramo.clearAnimation();
    paramo = paramo.getTag(iwf);
    if ((paramo instanceof Animator))
    {
      paramo = (Animator)paramo;
      paramo.cancel();
      paramo.removeAllListeners();
    }
    AppMethodBeat.o(87141);
  }
  
  public void Eg(String paramString)
  {
    AppMethodBeat.i(87104);
    runOnUiThread(new r.1(this, paramString));
    AppMethodBeat.o(87104);
  }
  
  public final void Eh(String paramString)
  {
    AppMethodBeat.i(87105);
    runOnUiThread(new r.12(this, paramString));
    AppMethodBeat.o(87105);
  }
  
  public final void Ei(String paramString)
  {
    AppMethodBeat.i(87107);
    runOnUiThread(new r.16(this, paramString));
    AppMethodBeat.o(87107);
  }
  
  public final void Ej(String paramString)
  {
    AppMethodBeat.i(87108);
    runOnUiThread(new r.17(this, paramString));
    AppMethodBeat.o(87108);
  }
  
  protected void a(o paramo1, o paramo2)
  {
    AppMethodBeat.i(87112);
    if (this.iwg) {
      paramo2.getCurrentPageView().aJp();
    }
    if (paramo1 != null) {
      paramo1.hideVKB();
    }
    AppMethodBeat.o(87112);
  }
  
  public void a(o paramo1, o paramo2, bf parambf)
  {
    AppMethodBeat.i(87115);
    if (this.iwg) {
      paramo2.getCurrentPageView().aJp();
    }
    AppMethodBeat.o(87115);
  }
  
  public void a(o paramo1, o paramo2, bf parambf, String paramString)
  {
    AppMethodBeat.i(87114);
    if (paramo1 != null) {
      paramo1.hideVKB();
    }
    AppMethodBeat.o(87114);
  }
  
  public final void aIZ()
  {
    AppMethodBeat.i(87109);
    runOnUiThread(new r.19(this));
    AppMethodBeat.o(87109);
  }
  
  public final v aJb()
  {
    AppMethodBeat.i(141673);
    if (this.iwm == null)
    {
      localObject2 = aJc();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new v();
      }
      ((v)localObject1).iwn = getDecorWidgetFactory();
      ((v)localObject1).a(getContext(), this.gRG);
      AppMethodBeat.o(141673);
      return localObject1;
    }
    Object localObject1 = this.iwm;
    this.iwm = null;
    Object localObject2 = ((c)localObject1).getContentView();
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(0);
    }
    removeView(((v)localObject1).hmw);
    AppMethodBeat.o(141673);
    return localObject1;
  }
  
  public final void aJd()
  {
    AppMethodBeat.i(87131);
    if (!this.iwg)
    {
      this.iwh = true;
      AppMethodBeat.o(87131);
      return;
    }
    this.iwh = false;
    if ((this.iwi != null) && (this.iwi.vx()))
    {
      AppMethodBeat.o(87131);
      return;
    }
    getRuntime().k(new r.10(this), 200L);
    AppMethodBeat.o(87131);
  }
  
  protected final void aJe()
  {
    AppMethodBeat.i(87135);
    if (this.gRG == null)
    {
      AppMethodBeat.o(87135);
      return;
    }
    if (this.iwo)
    {
      if (this.iwp != null) {
        this.iwp.atF();
      }
      onReady();
      this.iwo = false;
    }
    AppMethodBeat.o(87135);
  }
  
  public final void aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(87106);
    runOnUiThread(new r.15(this, paramString, paramBoolean));
    AppMethodBeat.o(87106);
  }
  
  public final void c(o paramo)
  {
    AppMethodBeat.i(87111);
    runOnUiThread(new r.21(this, paramo));
    AppMethodBeat.o(87111);
  }
  
  public final void c(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(87124);
    runOnUiThread(new r.9(this, paramString1, paramString2, paramArrayOfInt));
    AppMethodBeat.o(87124);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(87128);
    onDestroy();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.iwj);
    localLinkedList.addAll(this.iwk);
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      localo.aIV();
      localo.performDestroy();
      localo.wm();
      j(localo);
    }
    localLinkedList.clear();
    if (this.iwm != null) {}
    try
    {
      this.iwm.onDestroy();
      try
      {
        label97:
        this.iwm.cleanup();
        label104:
        this.iwj.clear();
        this.iwk.clear();
        removeAllViews();
        this.iwp = null;
        this.gRG = null;
        AppMethodBeat.o(87128);
        return;
      }
      catch (Exception localException1)
      {
        break label104;
      }
    }
    catch (Exception localException2)
    {
      break label97;
    }
  }
  
  /* Error */
  public final o e(o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 710
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 65	com/tencent/mm/plugin/appbrand/page/r:iwj	Ljava/util/LinkedList;
    //   12: aload_1
    //   13: invokevirtual 714	java/util/LinkedList:indexOf	(Ljava/lang/Object;)I
    //   16: istore_2
    //   17: iload_2
    //   18: aload_0
    //   19: getfield 65	com/tencent/mm/plugin/appbrand/page/r:iwj	Ljava/util/LinkedList;
    //   22: invokevirtual 93	java/util/LinkedList:size	()I
    //   25: iconst_1
    //   26: isub
    //   27: if_icmplt +15 -> 42
    //   30: aconst_null
    //   31: astore_1
    //   32: ldc_w 710
    //   35: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aload_0
    //   43: getfield 65	com/tencent/mm/plugin/appbrand/page/r:iwj	Ljava/util/LinkedList;
    //   46: iload_2
    //   47: iconst_1
    //   48: iadd
    //   49: invokevirtual 203	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   52: checkcast 101	com/tencent/mm/plugin/appbrand/page/o
    //   55: astore_1
    //   56: ldc_w 710
    //   59: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: goto -24 -> 38
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	r
    //   0	70	1	paramo	o
    //   16	33	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	30	65	finally
    //   32	38	65	finally
    //   42	62	65	finally
  }
  
  public Object f(o paramo)
  {
    AppMethodBeat.i(87137);
    paramo = ObjectAnimator.ofFloat(paramo, "translationX", new float[] { paramo.getWidth(), 0.0F });
    paramo.setDuration(250L);
    AppMethodBeat.o(87137);
    return paramo;
  }
  
  public Object g(o paramo)
  {
    AppMethodBeat.i(87138);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramo, "translationX", new float[] { 0.0F, -(paramo.getWidth() * 0.25F) });
    localObjectAnimator.setDuration(250L);
    paramo = ObjectAnimator.ofFloat(paramo, "translationX", new float[] { 0.0F });
    paramo.setDuration(0L);
    new AnimatorSet().playSequentially(new Animator[] { localObjectAnimator, paramo });
    AppMethodBeat.o(87138);
    return localObjectAnimator;
  }
  
  public com.tencent.mm.plugin.appbrand.config.a getAppConfig()
  {
    AppMethodBeat.i(87132);
    com.tencent.mm.plugin.appbrand.config.a locala = this.gRG.getAppConfig();
    AppMethodBeat.o(87132);
    return locala;
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  /* Error */
  public o getCurrentPage()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 744
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 67	com/tencent/mm/plugin/appbrand/page/r:iwk	Ljava/util/LinkedList;
    //   12: invokevirtual 364	java/util/LinkedList:isEmpty	()Z
    //   15: ifne +24 -> 39
    //   18: aload_0
    //   19: getfield 67	com/tencent/mm/plugin/appbrand/page/r:iwk	Ljava/util/LinkedList;
    //   22: invokevirtual 97	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   25: checkcast 101	com/tencent/mm/plugin/appbrand/page/o
    //   28: astore_1
    //   29: ldc_w 744
    //   32: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aload_0
    //   40: getfield 65	com/tencent/mm/plugin/appbrand/page/r:iwj	Ljava/util/LinkedList;
    //   43: invokevirtual 402	java/util/LinkedList:peekFirst	()Ljava/lang/Object;
    //   46: checkcast 101	com/tencent/mm/plugin/appbrand/page/o
    //   49: astore_1
    //   50: ldc_w 744
    //   53: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -21 -> 35
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	r
    //   28	22	1	localo	o
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	59	finally
    //   39	56	59	finally
  }
  
  /* Error */
  public String getCurrentUrl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 745
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 307	com/tencent/mm/plugin/appbrand/page/r:getCurrentPage	()Lcom/tencent/mm/plugin/appbrand/page/o;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +18 -> 32
    //   17: aload_1
    //   18: invokevirtual 515	com/tencent/mm/plugin/appbrand/page/o:getCurrentUrl	()Ljava/lang/String;
    //   21: astore_1
    //   22: ldc_w 745
    //   25: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: areturn
    //   32: aconst_null
    //   33: astore_1
    //   34: ldc_w 745
    //   37: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -12 -> 28
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	r
    //   12	22	1	localObject1	Object
    //   43	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	43	finally
    //   17	28	43	finally
    //   34	40	43	finally
  }
  
  public be getDecorWidgetFactory()
  {
    return this.iwn;
  }
  
  public int getPageCount()
  {
    AppMethodBeat.i(87103);
    int i = this.iwj.size();
    int j = this.iwk.size();
    AppMethodBeat.o(87103);
    return i + j;
  }
  
  public v getPageView()
  {
    AppMethodBeat.i(87130);
    Object localObject = getCurrentPage();
    if (localObject == null)
    {
      AppMethodBeat.o(87130);
      return null;
    }
    localObject = ((o)localObject).getCurrentPageView();
    AppMethodBeat.o(87130);
    return localObject;
  }
  
  public i getRuntime()
  {
    return this.gRG;
  }
  
  public Object h(o paramo)
  {
    AppMethodBeat.i(87139);
    paramo = ObjectAnimator.ofFloat(paramo, "translationX", new float[] { -(paramo.getWidth() * 0.25F), 0.0F });
    paramo.setDuration(250L);
    AppMethodBeat.o(87139);
    return paramo;
  }
  
  public Object i(o paramo)
  {
    AppMethodBeat.i(87140);
    paramo = ObjectAnimator.ofFloat(paramo, "translationX", new float[] { 0.0F, paramo.getWidth() });
    paramo.setDuration(250L);
    AppMethodBeat.o(87140);
    return paramo;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(87143);
    if (getCurrentPage() == null)
    {
      AppMethodBeat.o(87143);
      return;
    }
    if (getCurrentPage().getCurrentPageView().onBackPressed())
    {
      AppMethodBeat.o(87143);
      return;
    }
    if ((!this.iwk.isEmpty()) || (getCurrentPage().getTag(iwf) != null))
    {
      ab.w("MicroMsg.AppBrandPageContainer", "onBackPressed, has navigating pages, skip");
      AppMethodBeat.o(87143);
      return;
    }
    aIZ();
    AppMethodBeat.o(87143);
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(87134);
    if (this.iwj.size() == 0)
    {
      AppMethodBeat.o(87134);
      return;
    }
    ((o)this.iwj.getFirst()).aIV();
    AppMethodBeat.o(87134);
  }
  
  protected void onDestroy() {}
  
  public void onForeground()
  {
    AppMethodBeat.i(87133);
    if (this.iwj.size() == 0)
    {
      AppMethodBeat.o(87133);
      return;
    }
    ((o)this.iwj.getFirst()).aIU();
    if (this.iwg) {
      ((o)this.iwj.getFirst()).getCurrentPageView().aJp();
    }
    AppMethodBeat.o(87133);
  }
  
  protected void onReady()
  {
    AppMethodBeat.i(87136);
    AppMethodBeat.o(87136);
  }
  
  public final void pa(int paramInt)
  {
    AppMethodBeat.i(87110);
    runOnUiThread(new r.20(this, paramInt));
    AppMethodBeat.o(87110);
  }
  
  protected final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(87102);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(87102);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(87102);
  }
  
  public void setActuallyVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(87101);
    if (this.iwg != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.iwg = paramBoolean;
      if ((paramBoolean) && (i != 0))
      {
        getCurrentPage().getCurrentPageView().aJp();
        super.setVisibility(0);
        if (this.iwh) {
          aJd();
        }
      }
      if ((!paramBoolean) && (i != 0)) {
        super.setVisibility(4);
      }
      AppMethodBeat.o(87101);
      return;
    }
  }
  
  public void setDecorWidgetFactory(be parambe)
  {
    AppMethodBeat.i(87100);
    if (parambe == null)
    {
      parambe = new NullPointerException("Should not be null");
      AppMethodBeat.o(87100);
      throw parambe;
    }
    this.iwn = parambe;
    AppMethodBeat.o(87100);
  }
  
  public final void setDelegate(r.a parama)
  {
    AppMethodBeat.i(141671);
    if (this.iwi != null)
    {
      parama = new IllegalAccessError("Duplicated call!!!");
      AppMethodBeat.o(141671);
      throw parama;
    }
    this.iwi = parama;
    AppMethodBeat.o(141671);
  }
  
  public void setOnReadyListener(r.c paramc)
  {
    this.iwp = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r
 * JD-Core Version:    0.7.0.1
 */