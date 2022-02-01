package com.tencent.luggage.h;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class e
{
  private static final WeakHashMap<Activity, e> cqu;
  @SuppressLint({"StaticFieldLeak"})
  private static final e cqv;
  private final SparseArray<b> cqp;
  private final SparseArray<f> cqq;
  final Set<c> cqr;
  public a cqs;
  private Random cqt;
  private Activity mActivity;
  
  static
  {
    AppMethodBeat.i(140516);
    cqu = new WeakHashMap();
    cqv = new e(null);
    AppMethodBeat.o(140516);
  }
  
  private e(Activity paramActivity)
  {
    AppMethodBeat.i(140506);
    this.cqp = new SparseArray();
    this.cqq = new SparseArray();
    this.cqr = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mActivity = paramActivity;
    this.cqt = new Random();
    AppMethodBeat.o(140506);
  }
  
  public static e aA(Context paramContext)
  {
    AppMethodBeat.i(140514);
    Assert.assertFalse("must implements ILuggageActivityHelper", false);
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if ((localActivity.isFinishing()) || (localActivity.isDestroyed()))
      {
        ad.e("Luggage.LuggageActivityHelper", "FOR(%s) instance destroyed, return DUMMY", new Object[] { localActivity });
        paramContext = cqv;
        AppMethodBeat.o(140514);
        return paramContext;
      }
      if (!cqu.containsKey(localActivity)) {
        cqu.put(localActivity, new e(localActivity));
      }
      paramContext = (e)cqu.get(paramContext);
      AppMethodBeat.o(140514);
      return paramContext;
    }
    Assert.assertFalse(false);
    paramContext = cqv;
    AppMethodBeat.o(140514);
    return paramContext;
  }
  
  public static void aB(Context paramContext)
  {
    AppMethodBeat.i(140515);
    if ((paramContext instanceof Activity))
    {
      paramContext = (e)cqu.remove(paramContext);
      if (paramContext != null)
      {
        paramContext.cqp.clear();
        paramContext.cqr.clear();
        paramContext.cqq.clear();
      }
    }
    AppMethodBeat.o(140515);
  }
  
  private int b(SparseArray paramSparseArray)
  {
    AppMethodBeat.i(140512);
    int i;
    do
    {
      i = rand();
    } while (paramSparseArray.get(i) != null);
    AppMethodBeat.o(140512);
    return i;
  }
  
  private int rand()
  {
    AppMethodBeat.i(140513);
    int i = this.cqt.nextInt(2147483646);
    AppMethodBeat.o(140513);
    return i + 1 & 0xFFFF;
  }
  
  public final void a(Intent paramIntent, b paramb)
  {
    AppMethodBeat.i(140509);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(140509);
      return;
    }
    int i = b(this.cqp);
    this.cqp.put(i, paramb);
    this.mActivity.startActivityForResult(paramIntent, i);
    AppMethodBeat.o(140509);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(174618);
    this.cqr.add(paramc);
    AppMethodBeat.o(174618);
  }
  
  @TargetApi(23)
  public final void a(String[] paramArrayOfString, f paramf)
  {
    AppMethodBeat.i(140511);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(140511);
      return;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      paramArrayOfString = new int[paramArrayOfString.length];
      Arrays.fill(paramArrayOfString, 0);
      paramf.p(paramArrayOfString);
      AppMethodBeat.o(140511);
      return;
    }
    int i = b(this.cqq);
    this.cqq.put(i, paramf);
    paramf = this.mActivity;
    paramArrayOfString = c.a(i, new com.tencent.mm.hellhoundlib.b.a()).bc(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(paramf, paramArrayOfString.ahp(), "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    paramf.requestPermissions((String[])paramArrayOfString.mq(0), ((Integer)paramArrayOfString.mq(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    AppMethodBeat.o(140511);
  }
  
  public final boolean a(String paramString, f paramf)
  {
    AppMethodBeat.i(140510);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(140510);
      return true;
    }
    if (this.mActivity == null)
    {
      AppMethodBeat.o(140510);
      return false;
    }
    try
    {
      int i = b.checkSelfPermission(this.mActivity, paramString);
      if (i == 0)
      {
        AppMethodBeat.o(140510);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ad.e("Luggage.LuggageActivityHelper", "check mpermission exception:%s.", new Object[] { paramString });
      AppMethodBeat.o(140510);
      return true;
    }
    a(new String[] { paramString }, paramf);
    AppMethodBeat.o(140510);
    return false;
  }
  
  public final void b(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(140508);
    d locald = (d)this.cqq.get(paramInt);
    this.cqq.delete(paramInt);
    if (locald != null) {
      ((f)locald).p(paramArrayOfInt);
    }
    AppMethodBeat.o(140508);
  }
  
  public final void b(Intent paramIntent, b paramb)
  {
    AppMethodBeat.i(174617);
    a(paramIntent, paramb);
    AppMethodBeat.o(174617);
  }
  
  public final void b(final c paramc)
  {
    AppMethodBeat.i(174619);
    a(new c()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174616);
        e.this.cqr.remove(this);
        boolean bool = paramc.b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(174616);
        return bool;
      }
    });
    AppMethodBeat.o(174619);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(187600);
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (!this.mActivity.isDestroyed()))
    {
      if (this.cqs != null) {
        this.cqs.Fr();
      }
      this.mActivity.finish();
    }
    AppMethodBeat.o(187600);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(140507);
    Object localObject = this.cqr.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((c)((Iterator)localObject).next()).b(paramInt1, paramInt2, paramIntent))
      {
        AppMethodBeat.o(140507);
        return;
      }
    }
    localObject = (d)this.cqp.get(paramInt1);
    this.cqp.delete(paramInt1);
    if (localObject != null) {
      ((b)localObject).a(paramInt2, paramIntent);
    }
    AppMethodBeat.o(140507);
  }
  
  public static abstract interface a
  {
    public abstract boolean Fr();
  }
  
  public static abstract interface b
    extends e.d
  {
    public abstract void a(int paramInt, Intent paramIntent);
  }
  
  public static abstract interface c
    extends e.d
  {
    public abstract boolean b(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  static abstract interface d {}
  
  public static abstract interface e {}
  
  public static abstract interface f
    extends e.d
  {
    public abstract void p(int[] paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.e
 * JD-Core Version:    0.7.0.1
 */