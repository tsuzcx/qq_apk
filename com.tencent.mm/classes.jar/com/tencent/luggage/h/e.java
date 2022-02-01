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
  private static final WeakHashMap<Activity, e> cjh;
  @SuppressLint({"StaticFieldLeak"})
  private static final e cji;
  private final SparseArray<a> cjd;
  private final SparseArray<e> cje;
  final Set<b> cjf;
  private Random cjg;
  private Activity mActivity;
  
  static
  {
    AppMethodBeat.i(140516);
    cjh = new WeakHashMap();
    cji = new e(null);
    AppMethodBeat.o(140516);
  }
  
  private e(Activity paramActivity)
  {
    AppMethodBeat.i(140506);
    this.cjd = new SparseArray();
    this.cje = new SparseArray();
    this.cjf = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mActivity = paramActivity;
    this.cjg = new Random();
    AppMethodBeat.o(140506);
  }
  
  public static void aA(Context paramContext)
  {
    AppMethodBeat.i(140515);
    if ((paramContext instanceof Activity))
    {
      paramContext = (e)cjh.remove(paramContext);
      if (paramContext != null)
      {
        paramContext.cjd.clear();
        paramContext.cjf.clear();
        paramContext.cje.clear();
      }
    }
    AppMethodBeat.o(140515);
  }
  
  public static e az(Context paramContext)
  {
    AppMethodBeat.i(140514);
    Assert.assertFalse("must implements ILuggageActivityHelper", false);
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if ((localActivity.isFinishing()) || (localActivity.isDestroyed()))
      {
        ad.e("Luggage.LuggageActivityHelper", "FOR(%s) instance destroyed, return DUMMY", new Object[] { localActivity });
        paramContext = cji;
        AppMethodBeat.o(140514);
        return paramContext;
      }
      if (!cjh.containsKey(localActivity)) {
        cjh.put(localActivity, new e(localActivity));
      }
      paramContext = (e)cjh.get(paramContext);
      AppMethodBeat.o(140514);
      return paramContext;
    }
    Assert.assertFalse(false);
    paramContext = cji;
    AppMethodBeat.o(140514);
    return paramContext;
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
    int i = this.cjg.nextInt(2147483646);
    AppMethodBeat.o(140513);
    return i + 1 & 0xFFFF;
  }
  
  public final void a(Intent paramIntent, a parama)
  {
    AppMethodBeat.i(140509);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(140509);
      return;
    }
    int i = b(this.cjd);
    this.cjd.put(i, parama);
    this.mActivity.startActivityForResult(paramIntent, i);
    AppMethodBeat.o(140509);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(174618);
    this.cjf.add(paramb);
    AppMethodBeat.o(174618);
  }
  
  @TargetApi(23)
  public final void a(String[] paramArrayOfString, e parame)
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
      parame.o(paramArrayOfString);
      AppMethodBeat.o(140511);
      return;
    }
    int i = b(this.cje);
    this.cje.put(i, parame);
    parame = this.mActivity;
    paramArrayOfString = c.a(i, new com.tencent.mm.hellhoundlib.b.a()).bd(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(parame, paramArrayOfString.adn(), "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    parame.requestPermissions((String[])paramArrayOfString.lS(0), ((Integer)paramArrayOfString.lS(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(parame, "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    AppMethodBeat.o(140511);
  }
  
  public final boolean a(String paramString, e parame)
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
    a(new String[] { paramString }, parame);
    AppMethodBeat.o(140510);
    return false;
  }
  
  public final void b(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(140508);
    c localc = (c)this.cje.get(paramInt);
    this.cje.delete(paramInt);
    if (localc != null) {
      ((e)localc).o(paramArrayOfInt);
    }
    AppMethodBeat.o(140508);
  }
  
  public final void b(Intent paramIntent, a parama)
  {
    AppMethodBeat.i(174617);
    a(paramIntent, parama);
    AppMethodBeat.o(174617);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(174619);
    a(new b()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174616);
        e.this.cjf.remove(this);
        boolean bool = paramb.b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(174616);
        return bool;
      }
    });
    AppMethodBeat.o(174619);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(140507);
    Object localObject = this.cjf.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((b)((Iterator)localObject).next()).b(paramInt1, paramInt2, paramIntent))
      {
        AppMethodBeat.o(140507);
        return;
      }
    }
    localObject = (c)this.cjd.get(paramInt1);
    this.cjd.delete(paramInt1);
    if (localObject != null) {
      ((a)localObject).a(paramInt2, paramIntent);
    }
    AppMethodBeat.o(140507);
  }
  
  public static abstract interface a
    extends e.c
  {
    public abstract void a(int paramInt, Intent paramIntent);
  }
  
  public static abstract interface b
    extends e.c
  {
    public abstract boolean b(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  static abstract interface c {}
  
  public static abstract interface d {}
  
  public static abstract interface e
    extends e.c
  {
    public abstract void o(int[] paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.e
 * JD-Core Version:    0.7.0.1
 */