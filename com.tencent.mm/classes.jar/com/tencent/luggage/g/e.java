package com.tencent.luggage.g;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
  private static final WeakHashMap<Activity, e> bFC;
  @SuppressLint({"StaticFieldLeak"})
  private static final e bFD;
  public final Set<b> bFA;
  private Random bFB;
  private final SparseArray<e.a> bFy;
  public final SparseArray<e.d> bFz;
  private Activity mActivity;
  
  static
  {
    AppMethodBeat.i(90904);
    bFC = new WeakHashMap();
    bFD = new e(null);
    AppMethodBeat.o(90904);
  }
  
  private e(Activity paramActivity)
  {
    AppMethodBeat.i(90896);
    this.bFy = new SparseArray();
    this.bFz = new SparseArray();
    this.bFA = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mActivity = paramActivity;
    this.bFB = new Random();
    AppMethodBeat.o(90896);
  }
  
  public static e at(Context paramContext)
  {
    AppMethodBeat.i(90902);
    Assert.assertFalse("must implements ILuggageActivityHelper", false);
    if ((paramContext instanceof Activity))
    {
      if (!bFC.containsKey(paramContext)) {
        bFC.put((Activity)paramContext, new e((Activity)paramContext));
      }
      paramContext = (e)bFC.get(paramContext);
      AppMethodBeat.o(90902);
      return paramContext;
    }
    Assert.assertFalse(false);
    paramContext = bFD;
    AppMethodBeat.o(90902);
    return paramContext;
  }
  
  public static void au(Context paramContext)
  {
    AppMethodBeat.i(90903);
    if ((paramContext instanceof Activity)) {
      bFC.remove(paramContext);
    }
    AppMethodBeat.o(90903);
  }
  
  private int b(SparseArray paramSparseArray)
  {
    AppMethodBeat.i(90900);
    int i;
    do
    {
      i = rand();
    } while (paramSparseArray.get(i) != null);
    AppMethodBeat.o(90900);
    return i;
  }
  
  private int rand()
  {
    AppMethodBeat.i(90901);
    int i = this.bFB.nextInt(2147483646);
    AppMethodBeat.o(90901);
    return i + 1 & 0xFFFF;
  }
  
  public final void a(Intent paramIntent, e.a parama)
  {
    AppMethodBeat.i(90898);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(90898);
      return;
    }
    int i = b(this.bFy);
    this.bFy.put(i, parama);
    this.mActivity.startActivityForResult(paramIntent, i);
    AppMethodBeat.o(90898);
  }
  
  @TargetApi(23)
  public final void a(String[] paramArrayOfString, e.d paramd)
  {
    AppMethodBeat.i(141787);
    if (this.mActivity == null)
    {
      AppMethodBeat.o(141787);
      return;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      paramArrayOfString = new int[paramArrayOfString.length];
      Arrays.fill(paramArrayOfString, 0);
      paramd.n(paramArrayOfString);
      AppMethodBeat.o(141787);
      return;
    }
    int i = b(this.bFz);
    this.bFz.put(i, paramd);
    this.mActivity.requestPermissions(paramArrayOfString, i);
    AppMethodBeat.o(141787);
  }
  
  public final boolean a(String paramString, e.d paramd)
  {
    AppMethodBeat.i(90899);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(90899);
      return true;
    }
    if (this.mActivity == null)
    {
      AppMethodBeat.o(90899);
      return false;
    }
    try
    {
      int i = b.checkSelfPermission(this.mActivity, paramString);
      if (i == 0)
      {
        AppMethodBeat.o(90899);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ab.e("Luggage.LuggageActivityHelper", "check mpermission exception:%s.", new Object[] { paramString });
      AppMethodBeat.o(90899);
      return true;
    }
    a(new String[] { paramString }, paramd);
    AppMethodBeat.o(90899);
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(90897);
    Object localObject = this.bFA.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((b)((Iterator)localObject).next()).b(paramInt1, paramInt2, paramIntent))
      {
        AppMethodBeat.o(90897);
        return;
      }
    }
    localObject = (e.c)this.bFy.get(paramInt1);
    this.bFy.delete(paramInt1);
    if (localObject != null) {
      ((e.a)localObject).b(paramInt2, paramIntent);
    }
    AppMethodBeat.o(90897);
  }
  
  public static abstract interface b
    extends e.c
  {
    public abstract boolean b(int paramInt1, int paramInt2, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.g.e
 * JD-Core Version:    0.7.0.1
 */