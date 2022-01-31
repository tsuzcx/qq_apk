package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public class n
  extends FrameLayout
{
  private i fzT;
  private LinkedList<k> gSU = new LinkedList();
  private LinkedList<k> gSV = new LinkedList();
  private LinkedList<Runnable> gSW = new LinkedList();
  private q gSX;
  private boolean gSY = true;
  private n.a gSZ;
  private String mAppId;
  
  public n(Context paramContext, i parami)
  {
    super(paramContext);
    this.fzT = parami;
    this.mAppId = parami.mAppId;
  }
  
  private void a(Animator paramAnimator, final Runnable paramRunnable)
  {
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (paramRunnable != null) {
          n.this.post(paramRunnable);
        }
      }
    });
    paramAnimator.start();
  }
  
  private void amY()
  {
    Iterator localIterator = this.gSW.descendingIterator();
    while (localIterator.hasNext())
    {
      ((Runnable)localIterator.next()).run();
      localIterator.remove();
    }
    this.gSV.clear();
  }
  
  private void b(k paramk1, k paramk2)
  {
    Iterator localIterator = this.gSU.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk == paramk1)
      {
        i = 1;
      }
      else
      {
        if (localk == paramk2) {
          break;
        }
        if (i != 0)
        {
          c(localk);
          localIterator.remove();
        }
      }
    }
  }
  
  private void b(k paramk1, k paramk2, al paramal)
  {
    this.gSU.remove(paramk2);
    if (!paramk2.mSwiping)
    {
      n.4 local4 = new n.4(this, paramk2);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramk2, "translationX", new float[] { 0.0F, paramk2.getWidth() });
      localObjectAnimator.setDuration(250L);
      a(localObjectAnimator, local4);
    }
    for (;;)
    {
      y.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[] { paramk1.getCurrentUrl(), paramk2.getCurrentUrl() });
      paramk1.a(paramal);
      paramk1.agH();
      if (paramk2.mSwiping) {
        break;
      }
      paramk2 = new n.5(this, paramk1);
      paramk1 = ObjectAnimator.ofFloat(paramk1, "translationX", new float[] { -(paramk1.getWidth() * 0.25F), 0.0F });
      paramk1.setDuration(250L);
      a(paramk1, paramk2);
      return;
      c(paramk2);
    }
    paramk1.amV();
  }
  
  private void b(k paramk, boolean paramBoolean)
  {
    if (paramk == null) {}
    for (;;)
    {
      return;
      n.7 local7;
      try
      {
        this.gSU.remove(paramk);
        this.gSU.push(paramk);
        this.gSV.remove(paramk);
        paramk.bringToFront();
        requestLayout();
        invalidate();
        paramk.agH();
        local7 = new n.7(this, paramk);
        if (paramBoolean)
        {
          paramk = ObjectAnimator.ofFloat(paramk, "translationX", new float[] { paramk.getWidth(), 0.0F });
          paramk.setDuration(250L);
          a(paramk, local7);
          continue;
        }
      }
      finally {}
      local7.run();
    }
  }
  
  private void c(k paramk)
  {
    paramk.setVisibility(8);
    paramk.agG();
    removeView(paramk);
    paramk.cleanup();
  }
  
  private void c(String paramString, al paramal)
  {
    y.d("MicroMsg.AppBrandPageContainer", "navigateToNext: %s (%s), Staging Count: %d", new Object[] { paramString, paramal.name(), Integer.valueOf(this.gSV.size()) });
    k localk = b(paramString, paramal);
    addView(localk, 0);
    if (!this.gSU.isEmpty()) {
      this.gSU.getFirst();
    }
    a(paramal, paramString);
    n.2 local2 = new n.2(this, new boolean[] { false }, paramal, localk);
    this.gSV.push(localk);
    this.gSW.push(local2);
    if (this.gSU.size() == 0) {
      postDelayed(local2, 5000L);
    }
    for (;;)
    {
      localk.getCurrentPageView().a(new n.3(this, localk, local2));
      localk.loadUrl(paramString);
      localk.a(paramal);
      return;
      postDelayed(local2, 500L);
    }
  }
  
  private void vG(String paramString)
  {
    k localk1 = getCurrentPage();
    k localk2 = vH(paramString);
    if (localk2 != null)
    {
      a(al.gVR, paramString);
      localk2.loadUrl(paramString);
      localk2.a(al.gVR);
      localk2.amV();
      a(localk1, localk2, al.gVR);
    }
    do
    {
      return;
      localk2 = vI(paramString);
    } while (localk2 == null);
    a(al.gVR, paramString);
    localk2.loadUrl(paramString);
    paramString = (k)this.gSU.getFirst();
    b(paramString, localk2);
    b(localk2, paramString, al.gVR);
    a(localk1, localk2, al.gVR);
  }
  
  private k vH(String paramString)
  {
    if (this.gSU.size() == 0) {
      return null;
    }
    if (((this.gSU.getFirst() instanceof d)) && (((k)this.gSU.getFirst()).tz(paramString))) {
      return (k)this.gSU.getFirst();
    }
    return null;
  }
  
  private k vI(String paramString)
  {
    if (this.gSU.size() < 2) {
      return null;
    }
    int i = 1;
    while (i < this.gSU.size())
    {
      if (((this.gSU.get(i) instanceof d)) && (((k)this.gSU.get(i)).tz(paramString))) {
        return (k)this.gSU.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  protected void a(al paramal, String paramString) {}
  
  protected void a(k paramk1, k paramk2) {}
  
  protected void a(k paramk1, k paramk2, al paramal) {}
  
  public void aa(String paramString, boolean paramBoolean)
  {
    runOnUiThread(new n.12(this, paramString, paramBoolean));
  }
  
  public void agL()
  {
    runOnUiThread(new n.16(this));
  }
  
  public boolean agM()
  {
    return (this.gSU.size() > 1) || (getRuntime().fyD);
  }
  
  public q amZ()
  {
    return null;
  }
  
  public final void ana()
  {
    postDelayed(new n.9(this), 200L);
  }
  
  protected final void anb()
  {
    if (this.gSY)
    {
      onReady();
      this.gSY = false;
    }
  }
  
  protected k b(String paramString, al paramal)
  {
    boolean bool = true;
    if (paramal == al.gVR) {}
    label115:
    while (bool)
    {
      return new d(getContext(), this);
      if ((paramal == al.gVP) || (paramal == al.gVQ))
      {
        bool = this.fzT.getAppConfig().fND.sf(paramString);
      }
      else
      {
        int j = this.gSU.size();
        if (paramal == al.gVO) {}
        for (int i = 1;; i = 0)
        {
          if ((this.fzT.getAppConfig().fND.sf(paramString)) && (j + 1 - i == 1)) {
            break label115;
          }
          bool = false;
          break;
        }
      }
    }
    return new v(getContext(), this);
  }
  
  public void c(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    runOnUiThread(new n.8(this, paramString1, paramString2, paramArrayOfInt));
  }
  
  public final void cleanup()
  {
    onDestroy();
    Iterator localIterator = this.gSU.iterator();
    k localk;
    while (localIterator.hasNext())
    {
      localk = (k)localIterator.next();
      localk.agG();
      localk.cleanup();
    }
    localIterator = this.gSV.iterator();
    while (localIterator.hasNext())
    {
      localk = (k)localIterator.next();
      localk.agG();
      localk.cleanup();
    }
    if (this.gSX != null) {
      this.gSX.cleanup();
    }
    this.gSU.clear();
    this.gSV.clear();
  }
  
  /* Error */
  public final k d(k paramk)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/tencent/mm/plugin/appbrand/page/n:gSU	Ljava/util/LinkedList;
    //   6: aload_1
    //   7: invokevirtual 493	java/util/LinkedList:indexOf	(Ljava/lang/Object;)I
    //   10: istore_2
    //   11: aload_0
    //   12: getfield 45	com/tencent/mm/plugin/appbrand/page/n:gSU	Ljava/util/LinkedList;
    //   15: invokevirtual 82	java/util/LinkedList:size	()I
    //   18: istore_3
    //   19: iload_2
    //   20: iload_3
    //   21: iconst_1
    //   22: isub
    //   23: if_icmplt +9 -> 32
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: areturn
    //   32: aload_0
    //   33: getfield 45	com/tencent/mm/plugin/appbrand/page/n:gSU	Ljava/util/LinkedList;
    //   36: iload_2
    //   37: iconst_1
    //   38: iadd
    //   39: invokevirtual 106	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   42: checkcast 102	com/tencent/mm/plugin/appbrand/page/k
    //   45: astore_1
    //   46: goto -18 -> 28
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	n
    //   0	54	1	paramk	k
    //   10	29	2	i	int
    //   18	5	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	19	49	finally
    //   32	46	49	finally
  }
  
  public a getAppConfig()
  {
    return this.fzT.getAppConfig();
  }
  
  public String getAppId()
  {
    return this.mAppId;
  }
  
  /* Error */
  public k getCurrentPage()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/mm/plugin/appbrand/page/n:gSV	Ljava/util/LinkedList;
    //   6: invokevirtual 384	java/util/LinkedList:isEmpty	()Z
    //   9: ifne +18 -> 27
    //   12: aload_0
    //   13: getfield 47	com/tencent/mm/plugin/appbrand/page/n:gSV	Ljava/util/LinkedList;
    //   16: invokevirtual 100	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   19: checkcast 102	com/tencent/mm/plugin/appbrand/page/k
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aload_0
    //   28: getfield 45	com/tencent/mm/plugin/appbrand/page/n:gSU	Ljava/util/LinkedList;
    //   31: invokevirtual 100	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   34: checkcast 102	com/tencent/mm/plugin/appbrand/page/k
    //   37: astore_1
    //   38: goto -15 -> 23
    //   41: astore_1
    //   42: ldc 184
    //   44: aload_1
    //   45: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   48: invokestatic 503	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aconst_null
    //   52: astore_1
    //   53: goto -30 -> 23
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	n
    //   22	16	1	localk	k
    //   41	4	1	localException	java.lang.Exception
    //   52	1	1	localObject1	Object
    //   56	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	38	41	java/lang/Exception
    //   2	23	56	finally
    //   27	38	56	finally
    //   42	51	56	finally
  }
  
  /* Error */
  public String getCurrentUrl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 421	com/tencent/mm/plugin/appbrand/page/n:getCurrentPage	()Lcom/tencent/mm/plugin/appbrand/page/k;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: invokevirtual 304	com/tencent/mm/plugin/appbrand/page/k:getCurrentUrl	()Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aconst_null
    //   21: astore_1
    //   22: goto -6 -> 16
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	n
    //   6	16	1	localObject1	Object
    //   25	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   11	16	25	finally
  }
  
  public int getPageCount()
  {
    return this.gSU.size() + this.gSV.size();
  }
  
  protected LinkedList<k> getPageStack()
  {
    return this.gSU;
  }
  
  public q getPageView()
  {
    k localk = getCurrentPage();
    if (localk == null) {
      return null;
    }
    return localk.getCurrentPageView();
  }
  
  q getPageViewPrivate()
  {
    if (this.gSX == null)
    {
      q localq2 = amZ();
      localq1 = localq2;
      if (localq2 == null) {
        localq1 = new q();
      }
      localq1.a(getContext(), this.fzT);
      return localq1;
    }
    q localq1 = this.gSX;
    this.gSX = null;
    localq1.show();
    removeView(localq1.getContentView());
    return localq1;
  }
  
  public i getRuntime()
  {
    return this.fzT;
  }
  
  public void kV(int paramInt)
  {
    runOnUiThread(new n.17(this, paramInt));
  }
  
  protected void onDestroy() {}
  
  protected void onReady()
  {
    if (this.gSZ != null) {
      this.gSZ.ZT();
    }
  }
  
  public void pY()
  {
    if (this.gSU.size() == 0) {
      return;
    }
    ((k)this.gSU.getFirst()).agH();
  }
  
  public void qa()
  {
    if (this.gSU.size() == 0) {
      return;
    }
    ((k)this.gSU.getFirst()).agI();
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  public void setOnReadyListener(n.a parama)
  {
    this.gSZ = parama;
  }
  
  public void tA(String paramString)
  {
    runOnUiThread(new n.1(this, paramString));
  }
  
  public final void vF(String paramString)
  {
    runOnUiThread(new n.14(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.n
 * JD-Core Version:    0.7.0.1
 */