package com.tencent.luggage.k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class f
{
  private static final WeakHashMap<Activity, f> cDW;
  @SuppressLint({"StaticFieldLeak"})
  private static final f cDX;
  private final SparseArray<b> cDR;
  private final SparseArray<f> cDS;
  final Set<c> cDT;
  public a cDU;
  private Random cDV;
  private Activity mActivity;
  
  static
  {
    AppMethodBeat.i(140516);
    cDW = new WeakHashMap();
    cDX = new f(null);
    AppMethodBeat.o(140516);
  }
  
  private f(Activity paramActivity)
  {
    AppMethodBeat.i(140506);
    this.cDR = new SparseArray();
    this.cDS = new SparseArray();
    this.cDT = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mActivity = paramActivity;
    this.cDV = new Random();
    AppMethodBeat.o(140506);
  }
  
  public static f aI(Context paramContext)
  {
    AppMethodBeat.i(140514);
    Assert.assertFalse("must implements ILuggageActivityHelper", false);
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if ((localActivity.isFinishing()) || (localActivity.isDestroyed()))
      {
        Log.e("Luggage.LuggageActivityHelper", "FOR(%s) instance destroyed, return DUMMY", new Object[] { localActivity });
        paramContext = cDX;
        AppMethodBeat.o(140514);
        return paramContext;
      }
      if (!cDW.containsKey(localActivity)) {
        cDW.put(localActivity, new f(localActivity));
      }
      paramContext = (f)cDW.get(paramContext);
      AppMethodBeat.o(140514);
      return paramContext;
    }
    Assert.assertFalse(false);
    paramContext = cDX;
    AppMethodBeat.o(140514);
    return paramContext;
  }
  
  public static void aJ(Context paramContext)
  {
    AppMethodBeat.i(140515);
    if ((paramContext instanceof Activity))
    {
      paramContext = (f)cDW.remove(paramContext);
      if (paramContext != null)
      {
        paramContext.cDR.clear();
        paramContext.cDT.clear();
        paramContext.cDS.clear();
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
    int i = this.cDV.nextInt(2147483646);
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
    int i = b(this.cDR);
    this.cDR.put(i, paramb);
    this.mActivity.startActivityForResult(paramIntent, i);
    AppMethodBeat.o(140509);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(174618);
    this.cDT.add(paramc);
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
      paramf.q(paramArrayOfString);
      AppMethodBeat.o(140511);
      return;
    }
    int i = b(this.cDS);
    this.cDS.put(i, paramf);
    paramf = this.mActivity;
    paramArrayOfString = c.a(i, new com.tencent.mm.hellhoundlib.b.a()).bm(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.b(paramf, paramArrayOfString.aFh(), "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    paramf.requestPermissions((String[])paramArrayOfString.sf(0), ((Integer)paramArrayOfString.sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
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
      int i = androidx.core.content.a.checkSelfPermission(this.mActivity, paramString);
      if (i == 0)
      {
        AppMethodBeat.o(140510);
        return true;
      }
    }
    catch (Exception paramString)
    {
      Log.e("Luggage.LuggageActivityHelper", "check mpermission exception:%s.", new Object[] { paramString });
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
    d locald = (d)this.cDS.get(paramInt);
    this.cDS.delete(paramInt);
    if (locald != null) {
      ((f)locald).q(paramArrayOfInt);
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
    if (paramc == null)
    {
      AppMethodBeat.o(174619);
      return;
    }
    a(new c()
    {
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174616);
        f.this.cDT.remove(this);
        boolean bool = paramc.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(174616);
        return bool;
      }
    });
    AppMethodBeat.o(174619);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(208973);
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (!this.mActivity.isDestroyed()))
    {
      if (this.cDU != null) {
        this.cDU.SF();
      }
      this.mActivity.finish();
    }
    AppMethodBeat.o(208973);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(140507);
    Object localObject = this.cDT.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((c)((Iterator)localObject).next()).c(paramInt1, paramInt2, paramIntent))
      {
        AppMethodBeat.o(140507);
        return;
      }
    }
    localObject = (d)this.cDR.get(paramInt1);
    this.cDR.delete(paramInt1);
    if (localObject != null) {
      ((b)localObject).a(paramInt2, paramIntent);
    }
    AppMethodBeat.o(140507);
  }
  
  public static abstract interface a
  {
    public abstract boolean SF();
  }
  
  public static abstract interface b
    extends f.d
  {
    public abstract void a(int paramInt, Intent paramIntent);
  }
  
  public static abstract interface c
    extends f.d
  {
    public abstract boolean c(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  static abstract interface d {}
  
  public static abstract interface e {}
  
  public static abstract interface f
    extends f.d
  {
    public abstract void q(int[] paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.k.f
 * JD-Core Version:    0.7.0.1
 */