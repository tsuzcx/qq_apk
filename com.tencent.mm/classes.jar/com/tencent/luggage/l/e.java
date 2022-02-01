package com.tencent.luggage.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.sdk.platformtools.Log;
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
  private static j exa;
  private static final WeakHashMap<Activity, e> exb;
  private static final e exc;
  private final SparseArray<b> ewV;
  private final SparseArray<f> ewW;
  final Set<c> ewX;
  public a ewY;
  private Random ewZ;
  private Activity mActivity;
  
  static
  {
    AppMethodBeat.i(140516);
    exa = null;
    exb = new WeakHashMap();
    exc = new e(null);
    AppMethodBeat.o(140516);
  }
  
  private e(Activity paramActivity)
  {
    AppMethodBeat.i(140506);
    this.ewV = new SparseArray();
    this.ewW = new SparseArray();
    this.ewX = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mActivity = paramActivity;
    this.ewZ = new Random();
    AppMethodBeat.o(140506);
  }
  
  private void a(f paramf, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt, f paramf1)
  {
    AppMethodBeat.i(219973);
    if (paramInt == paramArrayOfString.length)
    {
      paramf = new StringBuilder();
      int i = paramArrayOfInt.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramf.append(paramArrayOfInt[paramInt]).append(",");
        paramInt += 1;
      }
      Log.i("Luggage.LuggageActivityHelper", "delegateBatchRequestPermissionToSeqLogic finally callback, grantResult:%s", new Object[] { paramf });
      paramf1.onResult(paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(219973);
      return;
    }
    if (exa == null)
    {
      AppMethodBeat.o(219973);
      return;
    }
    String str = paramArrayOfString[paramInt];
    Log.i("Luggage.LuggageActivityHelper", "doReqPerm index:%d permission:%s", new Object[] { Integer.valueOf(paramInt), str });
    exa.a(this.mActivity, paramf, str, new e..ExternalSyntheticLambda1(this, paramArrayOfInt, paramInt, str, paramf, paramArrayOfString, paramf1));
    AppMethodBeat.o(219973);
  }
  
  public static void a(j paramj)
  {
    exa = paramj;
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
  
  private void b(f paramf, String[] paramArrayOfString, f paramf1)
  {
    AppMethodBeat.i(219971);
    a(paramf, 0, paramArrayOfString, new int[paramArrayOfString.length], paramf1);
    AppMethodBeat.o(219971);
  }
  
  public static e bt(Context paramContext)
  {
    AppMethodBeat.i(140514);
    Assert.assertFalse("must implements ILuggageActivityHelper", false);
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if ((localActivity.isFinishing()) || (localActivity.isDestroyed()))
      {
        Log.e("Luggage.LuggageActivityHelper", "FOR(%s) instance destroyed, return DUMMY", new Object[] { localActivity });
        paramContext = exc;
        AppMethodBeat.o(140514);
        return paramContext;
      }
      if (!exb.containsKey(localActivity)) {
        exb.put(localActivity, new e(localActivity));
      }
      paramContext = (e)exb.get(paramContext);
      AppMethodBeat.o(140514);
      return paramContext;
    }
    Assert.assertFalse(false);
    paramContext = exc;
    AppMethodBeat.o(140514);
    return paramContext;
  }
  
  public static void bu(Context paramContext)
  {
    AppMethodBeat.i(140515);
    if ((paramContext instanceof Activity))
    {
      paramContext = (e)exb.remove(paramContext);
      if (paramContext != null)
      {
        paramContext.ewV.clear();
        paramContext.ewX.clear();
        paramContext.ewW.clear();
      }
    }
    AppMethodBeat.o(140515);
  }
  
  private int rand()
  {
    AppMethodBeat.i(140513);
    int i = this.ewZ.nextInt(2147483646);
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
    int i = b(this.ewV);
    this.ewV.put(i, paramb);
    com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, c.a(i, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/luggage/util/LuggageActivityHelper", "startActivityForResult", "(Landroid/content/Intent;Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultCallback;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(140509);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(174618);
    if (paramc == null)
    {
      AppMethodBeat.o(174618);
      return;
    }
    this.ewX.add(paramc);
    AppMethodBeat.o(174618);
  }
  
  public final void a(f paramf, String[] paramArrayOfString, f paramf1)
  {
    AppMethodBeat.i(220069);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(220069);
      return;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      paramf = new int[paramArrayOfString.length];
      Arrays.fill(paramf, 0);
      paramf1.onResult(paramArrayOfString, paramf);
      AppMethodBeat.o(220069);
      return;
    }
    if ((exa != null) && (paramf != null) && (exa.cGU()))
    {
      b(paramf, paramArrayOfString, paramf1);
      AppMethodBeat.o(220069);
      return;
    }
    int i = b(this.ewW);
    this.ewW.put(i, paramf1);
    paramf = this.mActivity;
    paramArrayOfString = c.a(i, new com.tencent.mm.hellhoundlib.b.a()).cG(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.b(paramf, paramArrayOfString.aYi(), "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;[Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    paramf.requestPermissions((String[])paramArrayOfString.sb(0), ((Integer)paramArrayOfString.sb(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;[Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    AppMethodBeat.o(220069);
  }
  
  public final boolean a(f paramf, String paramString, f paramf1)
  {
    AppMethodBeat.i(220059);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(220059);
      return true;
    }
    if (this.mActivity == null)
    {
      AppMethodBeat.o(220059);
      return false;
    }
    if ((exa != null) && (paramf != null) && (exa.cGU()))
    {
      if (exa.a(this.mActivity, paramf, paramString))
      {
        AppMethodBeat.o(220059);
        return true;
      }
      exa.a(this.mActivity, paramf, paramString, new e..ExternalSyntheticLambda0(paramf1, paramString));
      AppMethodBeat.o(220059);
      return false;
    }
    try
    {
      int i = androidx.core.content.a.checkSelfPermission(this.mActivity, paramString);
      if (i == 0)
      {
        AppMethodBeat.o(220059);
        return true;
      }
    }
    catch (Exception paramf)
    {
      Log.e("Luggage.LuggageActivityHelper", "check mpermission exception:%s.", new Object[] { paramf });
      AppMethodBeat.o(220059);
      return true;
    }
    a(null, new String[] { paramString }, paramf1);
    AppMethodBeat.o(220059);
    return false;
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
      public final boolean onResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174616);
        e.this.ewX.remove(this);
        boolean bool = paramc.onResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
        AppMethodBeat.o(174616);
        return bool;
      }
    });
    AppMethodBeat.o(174619);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(220065);
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (!this.mActivity.isDestroyed())) {
      if (this.ewY == null) {
        break label68;
      }
    }
    label68:
    for (boolean bool = this.ewY.ati();; bool = true)
    {
      if (bool) {
        this.mActivity.finish();
      }
      AppMethodBeat.o(220065);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(140507);
    Object localObject = this.ewX.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((c)((Iterator)localObject).next()).onResult(paramInt1, paramInt2, paramIntent))
      {
        AppMethodBeat.o(140507);
        return;
      }
    }
    localObject = (d)this.ewV.get(paramInt1);
    this.ewV.delete(paramInt1);
    if (localObject != null) {
      ((b)localObject).onResult(paramInt2, paramIntent);
    }
    AppMethodBeat.o(140507);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(220033);
    d locald = (d)this.ewW.get(paramInt);
    this.ewW.delete(paramInt);
    if (locald != null) {
      ((f)locald).onResult(paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(220033);
  }
  
  public static abstract interface a
  {
    public abstract boolean ati();
  }
  
  public static abstract interface b
    extends e.d
  {
    public abstract void onResult(int paramInt, Intent paramIntent);
  }
  
  public static abstract interface c
    extends e.d
  {
    public abstract boolean onResult(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  static abstract interface d {}
  
  public static abstract interface e {}
  
  public static abstract interface f
    extends e.d
  {
    public abstract void onResult(String[] paramArrayOfString, int[] paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.l.e
 * JD-Core Version:    0.7.0.1
 */