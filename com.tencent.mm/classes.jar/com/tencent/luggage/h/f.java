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
  private static final WeakHashMap<Activity, f> cDp;
  @SuppressLint({"StaticFieldLeak"})
  private static final f cDq;
  private final SparseArray<f.b> cDk;
  private final SparseArray<f> cDl;
  final Set<f.c> cDm;
  public f.a cDn;
  private Random cDo;
  private Activity mActivity;
  
  static
  {
    AppMethodBeat.i(140516);
    cDp = new WeakHashMap();
    cDq = new f(null);
    AppMethodBeat.o(140516);
  }
  
  private f(Activity paramActivity)
  {
    AppMethodBeat.i(140506);
    this.cDk = new SparseArray();
    this.cDl = new SparseArray();
    this.cDm = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mActivity = paramActivity;
    this.cDo = new Random();
    AppMethodBeat.o(140506);
  }
  
  public static f aK(Context paramContext)
  {
    AppMethodBeat.i(140514);
    Assert.assertFalse("must implements ILuggageActivityHelper", false);
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if ((localActivity.isFinishing()) || (localActivity.isDestroyed()))
      {
        Log.e("Luggage.LuggageActivityHelper", "FOR(%s) instance destroyed, return DUMMY", new Object[] { localActivity });
        paramContext = cDq;
        AppMethodBeat.o(140514);
        return paramContext;
      }
      if (!cDp.containsKey(localActivity)) {
        cDp.put(localActivity, new f(localActivity));
      }
      paramContext = (f)cDp.get(paramContext);
      AppMethodBeat.o(140514);
      return paramContext;
    }
    Assert.assertFalse(false);
    paramContext = cDq;
    AppMethodBeat.o(140514);
    return paramContext;
  }
  
  public static void aL(Context paramContext)
  {
    AppMethodBeat.i(140515);
    if ((paramContext instanceof Activity))
    {
      paramContext = (f)cDp.remove(paramContext);
      if (paramContext != null)
      {
        paramContext.cDk.clear();
        paramContext.cDm.clear();
        paramContext.cDl.clear();
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
    int i = this.cDo.nextInt(2147483646);
    AppMethodBeat.o(140513);
    return i + 1 & 0xFFFF;
  }
  
  public final void a(Intent paramIntent, f.b paramb)
  {
    AppMethodBeat.i(140509);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(140509);
      return;
    }
    int i = b(this.cDk);
    this.cDk.put(i, paramb);
    this.mActivity.startActivityForResult(paramIntent, i);
    AppMethodBeat.o(140509);
  }
  
  public final void a(f.c paramc)
  {
    AppMethodBeat.i(174618);
    this.cDm.add(paramc);
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
    int i = b(this.cDl);
    this.cDl.put(i, paramf);
    paramf = this.mActivity;
    paramArrayOfString = c.a(i, new com.tencent.mm.hellhoundlib.b.a()).bl(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(paramf, paramArrayOfString.axQ(), "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    paramf.requestPermissions((String[])paramArrayOfString.pG(0), ((Integer)paramArrayOfString.pG(1)).intValue());
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
    f.d locald = (f.d)this.cDl.get(paramInt);
    this.cDl.delete(paramInt);
    if (locald != null) {
      ((f)locald).q(paramArrayOfInt);
    }
    AppMethodBeat.o(140508);
  }
  
  public final void b(Intent paramIntent, f.b paramb)
  {
    AppMethodBeat.i(174617);
    a(paramIntent, paramb);
    AppMethodBeat.o(174617);
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(174619);
    a(new f.1(this, paramc));
    AppMethodBeat.o(174619);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(221206);
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (!this.mActivity.isDestroyed()))
    {
      if (this.cDn != null) {
        this.cDn.Pg();
      }
      this.mActivity.finish();
    }
    AppMethodBeat.o(221206);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(140507);
    Object localObject = this.cDm.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((f.c)((Iterator)localObject).next()).c(paramInt1, paramInt2, paramIntent))
      {
        AppMethodBeat.o(140507);
        return;
      }
    }
    localObject = (f.d)this.cDk.get(paramInt1);
    this.cDk.delete(paramInt1);
    if (localObject != null) {
      ((f.b)localObject).a(paramInt2, paramIntent);
    }
    AppMethodBeat.o(140507);
  }
  
  public static abstract interface f
    extends f.d
  {
    public abstract void q(int[] paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.h.f
 * JD-Core Version:    0.7.0.1
 */