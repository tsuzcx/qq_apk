package androidx.core.d;

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
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.a.f.a;
import androidx.core.graphics.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  static final androidx.b.e<String, Typeface> Kt;
  private static final c Lr;
  static final androidx.b.g<String, ArrayList<c.a<c>>> Ls;
  private static final Comparator<byte[]> Lt;
  static final Object sLock;
  
  static
  {
    AppMethodBeat.i(251099);
    Kt = new androidx.b.e(16);
    Lr = new c("fonts");
    sLock = new Object();
    Ls = new androidx.b.g();
    Lt = new Comparator() {};
    AppMethodBeat.o(251099);
  }
  
  public static Typeface a(Context paramContext, final a parama, f.a arg2, final Handler paramHandler, boolean paramBoolean, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(251092);
    final String str = parama.Lq + "-" + paramInt2;
    Typeface localTypeface = (Typeface)Kt.get(str);
    if (localTypeface != null)
    {
      if (??? != null) {
        ???.a(localTypeface);
      }
      AppMethodBeat.o(251092);
      return localTypeface;
    }
    if ((paramBoolean) && (paramInt1 == -1))
    {
      paramContext = a(paramContext, parama, paramInt2);
      if (??? != null)
      {
        if (paramContext.Lz != 0) {
          break label121;
        }
        ???.a(paramContext.Ly, paramHandler);
      }
      for (;;)
      {
        paramContext = paramContext.Ly;
        AppMethodBeat.o(251092);
        return paramContext;
        label121:
        ???.a(paramContext.Lz, paramHandler);
      }
    }
    parama = new Callable() {};
    if (paramBoolean) {
      try
      {
        paramContext = ((c)Lr.a(parama, paramInt1)).Ly;
        AppMethodBeat.o(251092);
        return paramContext;
      }
      catch (InterruptedException paramContext)
      {
        AppMethodBeat.o(251092);
        return null;
      }
    }
    if (??? == null) {
      paramContext = null;
    }
    synchronized (sLock)
    {
      for (;;)
      {
        paramHandler = (ArrayList)Ls.get(str);
        if (paramHandler == null) {
          break;
        }
        if (paramContext != null) {
          paramHandler.add(paramContext);
        }
        AppMethodBeat.o(251092);
        return null;
        paramContext = new c.a() {};
      }
      if (paramContext != null)
      {
        paramHandler = new ArrayList();
        paramHandler.add(paramContext);
        Ls.put(str, paramHandler);
      }
      paramContext = Lr;
      ??? = new c.a() {};
      paramContext.post(new c.2(paramContext, parama, new Handler(), ???));
      AppMethodBeat.o(251092);
      return null;
    }
  }
  
  static c a(Context paramContext, a parama, int paramInt)
  {
    int j = -3;
    AppMethodBeat.i(251089);
    Object localObject3;
    ProviderInfo localProviderInfo;
    try
    {
      localObject2 = paramContext.getPackageManager();
      localObject1 = paramContext.getResources();
      localObject3 = parama.Ll;
      localProviderInfo = ((PackageManager)localObject2).resolveContentProvider((String)localObject3, 0);
      if (localProviderInfo == null)
      {
        paramContext = new PackageManager.NameNotFoundException("No package found for authority: ".concat(String.valueOf(localObject3)));
        AppMethodBeat.o(251089);
        throw paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new c(null, -1);
      AppMethodBeat.o(251089);
      return paramContext;
    }
    if (!localProviderInfo.packageName.equals(parama.Lm))
    {
      paramContext = new PackageManager.NameNotFoundException("Found content provider " + (String)localObject3 + ", but package was not " + parama.Lm);
      AppMethodBeat.o(251089);
      throw paramContext;
    }
    Object localObject2 = a(((PackageManager)localObject2).getPackageInfo(localProviderInfo.packageName, 64).signatures);
    Collections.sort((List)localObject2, Lt);
    int i;
    if (parama.Lo != null)
    {
      localObject1 = parama.Lo;
      break label369;
      if (i >= ((List)localObject1).size()) {
        break label381;
      }
      localObject3 = new ArrayList((Collection)((List)localObject1).get(i));
      Collections.sort((List)localObject3, Lt);
      if (!b((List)localObject2, (List)localObject3)) {
        break label374;
      }
    }
    label332:
    label338:
    label369:
    label374:
    label381:
    for (Object localObject1 = localProviderInfo;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        parama = new a(1, null);
        if (parama.mStatusCode != 0) {
          break label338;
        }
        paramContext = androidx.core.graphics.e.a(paramContext, parama.Lx, paramInt);
        if (paramContext == null) {
          break label332;
        }
      }
      for (paramInt = 0;; paramInt = -3)
      {
        paramContext = new c(paramContext, paramInt);
        AppMethodBeat.o(251089);
        return paramContext;
        localObject1 = androidx.core.content.a.c.b((Resources)localObject1, parama.Lp);
        break label369;
        parama = new a(0, a(paramContext, parama, ((ProviderInfo)localObject1).authority));
        break;
      }
      paramInt = j;
      if (parama.mStatusCode == 1) {
        paramInt = -2;
      }
      paramContext = new c(null, paramInt);
      AppMethodBeat.o(251089);
      return paramContext;
      i = 0;
      break;
      i += 1;
      break;
    }
  }
  
  private static List<byte[]> a(Signature[] paramArrayOfSignature)
  {
    AppMethodBeat.i(251097);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    AppMethodBeat.o(251097);
    return localArrayList;
  }
  
  public static Map<Uri, ByteBuffer> a(Context paramContext, b[] paramArrayOfb, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(251094);
    paramCancellationSignal = new HashMap();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfb[i];
      if (((b)localObject).mResultCode == 0)
      {
        localObject = ((b)localObject).mUri;
        if (!paramCancellationSignal.containsKey(localObject)) {
          paramCancellationSignal.put(localObject, l.a(paramContext, null, (Uri)localObject));
        }
      }
      i += 1;
    }
    paramContext = Collections.unmodifiableMap(paramCancellationSignal);
    AppMethodBeat.o(251094);
    return paramContext;
  }
  
  private static b[] a(Context paramContext, a parama, String paramString)
  {
    AppMethodBeat.i(251098);
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
        parama = parama.Ln;
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
      AppMethodBeat.o(251098);
      throw paramContext;
      paramContext = paramContext.getContentResolver();
      parama = parama.Ln;
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
    paramContext = (b[])parama.toArray(new b[0]);
    AppMethodBeat.o(251098);
    return paramContext;
  }
  
  private static boolean b(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    AppMethodBeat.i(251095);
    if (paramList1.size() != paramList2.size())
    {
      AppMethodBeat.o(251095);
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i)))
      {
        AppMethodBeat.o(251095);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(251095);
    return true;
  }
  
  public static final class a
  {
    final b.b[] Lx;
    final int mStatusCode;
    
    public a(int paramInt, b.b[] paramArrayOfb)
    {
      this.mStatusCode = paramInt;
      this.Lx = paramArrayOfb;
    }
  }
  
  public static final class b
  {
    public final int Kb;
    public final boolean Kc;
    public final int Ke;
    final int mResultCode;
    public final Uri mUri;
    
    public b(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      AppMethodBeat.i(251076);
      this.mUri = ((Uri)androidx.core.f.g.checkNotNull(paramUri));
      this.Ke = paramInt1;
      this.Kb = paramInt2;
      this.Kc = paramBoolean;
      this.mResultCode = paramInt3;
      AppMethodBeat.o(251076);
    }
  }
  
  static final class c
  {
    final Typeface Ly;
    final int Lz;
    
    c(Typeface paramTypeface, int paramInt)
    {
      this.Ly = paramTypeface;
      this.Lz = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.d.b
 * JD-Core Version:    0.7.0.1
 */