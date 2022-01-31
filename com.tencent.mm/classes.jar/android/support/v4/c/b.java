package android.support.v4.c;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.content.a.f.a;
import android.support.v4.e.g;
import android.support.v4.e.l;
import android.support.v4.e.m;
import android.support.v4.graphics.d;
import android.support.v4.graphics.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class b
{
  static final g<String, Typeface> AB = new g(16);
  private static final c DO = new c("fonts");
  static final m<String, ArrayList<c.a<c>>> DP = new m();
  private static final Comparator<byte[]> DQ = new Comparator() {};
  static final Object sLock = new Object();
  
  public static Typeface a(Context paramContext, final a parama, f.a arg2, boolean paramBoolean, int paramInt1, final int paramInt2)
  {
    final String str = parama.DN + "-" + paramInt2;
    Object localObject = (Typeface)AB.get(str);
    if (localObject != null)
    {
      if (??? != null) {
        ???.b((Typeface)localObject);
      }
      return localObject;
    }
    if ((paramBoolean) && (paramInt1 == -1))
    {
      paramContext = a(paramContext, parama, paramInt2);
      if (??? != null)
      {
        if (paramContext.DW != 0) {
          break label103;
        }
        ???.a(paramContext.mp, null);
      }
      for (;;)
      {
        return paramContext.mp;
        label103:
        ???.a(paramContext.DW, null);
      }
    }
    parama = new Callable() {};
    if (paramBoolean) {}
    try
    {
      paramContext = ((c)DO.a(parama, paramInt1)).mp;
      return paramContext;
    }
    catch (InterruptedException paramContext) {}
    if (??? == null) {}
    for (paramContext = null;; paramContext = new c.a() {}) {
      synchronized (sLock)
      {
        if (!DP.containsKey(str)) {
          break;
        }
        if (paramContext != null) {
          ((ArrayList)DP.get(str)).add(paramContext);
        }
        return null;
      }
    }
    if (paramContext != null)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramContext);
      DP.put(str, localObject);
    }
    paramContext = DO;
    ??? = new c.a() {};
    paramContext.post(new c.2(paramContext, parama, new Handler(), ???));
    return null;
    return null;
  }
  
  static c a(Context paramContext, a parama, int paramInt)
  {
    int j = -3;
    Object localObject3;
    ProviderInfo localProviderInfo;
    try
    {
      localObject2 = paramContext.getPackageManager();
      localObject1 = paramContext.getResources();
      localObject3 = parama.DI;
      localProviderInfo = ((PackageManager)localObject2).resolveContentProvider((String)localObject3, 0);
      if (localProviderInfo == null) {
        throw new PackageManager.NameNotFoundException("No package found for authority: ".concat(String.valueOf(localObject3)));
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      return new c(null, -1);
    }
    if (!localProviderInfo.packageName.equals(parama.DJ)) {
      throw new PackageManager.NameNotFoundException("Found content provider " + (String)localObject3 + ", but package was not " + parama.DJ);
    }
    Object localObject2 = a(((PackageManager)localObject2).getPackageInfo(localProviderInfo.packageName, 64).signatures);
    Collections.sort((List)localObject2, DQ);
    int i;
    if (parama.DL != null)
    {
      localObject1 = parama.DL;
      break label329;
      if (i >= ((List)localObject1).size()) {
        break label341;
      }
      localObject3 = new ArrayList((Collection)((List)localObject1).get(i));
      Collections.sort((List)localObject3, DQ);
      if (!b((List)localObject2, (List)localObject3)) {
        break label334;
      }
    }
    label299:
    label305:
    label329:
    label334:
    label341:
    for (Object localObject1 = localProviderInfo;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        parama = new a(1, null);
        if (parama.mStatusCode != 0) {
          break label305;
        }
        paramContext = d.a(paramContext, parama.DV, paramInt);
        if (paramContext == null) {
          break label299;
        }
      }
      for (paramInt = 0;; paramInt = -3)
      {
        return new c(paramContext, paramInt);
        localObject1 = android.support.v4.content.a.c.a((Resources)localObject1, parama.DM);
        break label329;
        parama = new a(0, a(paramContext, parama, ((ProviderInfo)localObject1).authority));
        break;
      }
      paramInt = j;
      if (parama.mStatusCode == 1) {
        paramInt = -2;
      }
      return new c(null, paramInt);
      i = 0;
      break;
      i += 1;
      break;
    }
  }
  
  private static List<byte[]> a(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map<Uri, ByteBuffer> a(Context paramContext, b[] paramArrayOfb)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfb[i];
      if (((b)localObject).DG == 0)
      {
        localObject = ((b)localObject).mUri;
        if (!localHashMap.containsKey(localObject)) {
          localHashMap.put(localObject, j.b(paramContext, (Uri)localObject));
        }
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private static b[] a(Context paramContext, a parama, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT <= 16) {
          continue;
        }
        paramContext = paramContext.getContentResolver();
        parama = parama.DK;
        paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { parama }, null, null);
        if (paramContext == null) {
          continue;
        }
        try
        {
          if (paramContext.getCount() <= 0) {
            continue;
          }
          int m = paramContext.getColumnIndex("result_code");
          paramString = new ArrayList();
          int n = paramContext.getColumnIndex("_id");
          i1 = paramContext.getColumnIndex("file_id");
          int i2 = paramContext.getColumnIndex("font_ttc_index");
          int i3 = paramContext.getColumnIndex("font_weight");
          int i4 = paramContext.getColumnIndex("font_italic");
          parama = paramString;
          if (!paramContext.moveToNext()) {
            continue;
          }
          if (m == -1) {
            continue;
          }
          i = paramContext.getInt(m);
          if (i2 == -1) {
            continue;
          }
          j = paramContext.getInt(i2);
          if (i1 != -1) {
            continue;
          }
          parama = ContentUris.withAppendedId(localUri1, paramContext.getLong(n));
          if (i3 == -1) {
            continue;
          }
          k = paramContext.getInt(i3);
          if ((i4 == -1) || (paramContext.getInt(i4) != 1)) {
            continue;
          }
          bool = true;
          paramString.add(new b(parama, j, k, bool, i));
          continue;
          if (parama == null) {
            continue;
          }
        }
        finally
        {
          parama = paramContext;
          paramContext = paramString;
        }
      }
      finally
      {
        int i1;
        int i;
        int j;
        int k;
        boolean bool;
        parama = null;
        continue;
      }
      parama.close();
      throw paramContext;
      paramContext = paramContext.getContentResolver();
      parama = parama.DK;
      paramContext = paramContext.query(localUri1, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { parama }, null);
      continue;
      i = 0;
      continue;
      j = 0;
      continue;
      parama = ContentUris.withAppendedId(localUri2, paramContext.getLong(i1));
      continue;
      k = 400;
      continue;
      bool = false;
    }
    parama = localArrayList;
    if (paramContext != null) {
      paramContext.close();
    }
    return (b[])parama.toArray(new b[0]);
  }
  
  private static boolean b(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label62;
      }
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
  
  public static final class a
  {
    final b.b[] DV;
    final int mStatusCode;
    
    public a(int paramInt, b.b[] paramArrayOfb)
    {
      this.mStatusCode = paramInt;
      this.DV = paramArrayOfb;
    }
  }
  
  public static final class b
  {
    public final int Ai;
    public final boolean Aj;
    public final int Al;
    final int DG;
    public final Uri mUri;
    
    public b(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      this.mUri = ((Uri)l.checkNotNull(paramUri));
      this.Al = paramInt1;
      this.Ai = paramInt2;
      this.Aj = paramBoolean;
      this.DG = paramInt3;
    }
  }
  
  static final class c
  {
    final int DW;
    final Typeface mp;
    
    c(Typeface paramTypeface, int paramInt)
    {
      this.mp = paramTypeface;
      this.DW = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.c.b
 * JD-Core Version:    0.7.0.1
 */