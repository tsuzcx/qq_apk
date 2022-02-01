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
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class b
{
  private static final Comparator<byte[]> brA;
  
  static
  {
    AppMethodBeat.i(196268);
    brA = new b.1();
    AppMethodBeat.o(196268);
  }
  
  static e.a a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(196220);
    Object localObject2 = paramContext.getPackageManager();
    Object localObject1 = paramContext.getResources();
    Object localObject3 = paramc.brB;
    ProviderInfo localProviderInfo = ((PackageManager)localObject2).resolveContentProvider((String)localObject3, 0);
    if (localProviderInfo == null)
    {
      paramContext = new PackageManager.NameNotFoundException("No package found for authority: ".concat(String.valueOf(localObject3)));
      AppMethodBeat.o(196220);
      throw paramContext;
    }
    if (!localProviderInfo.packageName.equals(paramc.brC))
    {
      paramContext = new PackageManager.NameNotFoundException("Found content provider " + (String)localObject3 + ", but package was not " + paramc.brC);
      AppMethodBeat.o(196220);
      throw paramContext;
    }
    localObject2 = a(((PackageManager)localObject2).getPackageInfo(localProviderInfo.packageName, 64).signatures);
    Collections.sort((List)localObject2, brA);
    int i;
    if (paramc.brE != null)
    {
      localObject1 = paramc.brE;
      i = 0;
      label163:
      if (i >= ((List)localObject1).size()) {
        break label249;
      }
      localObject3 = new ArrayList((Collection)((List)localObject1).get(i));
      Collections.sort((List)localObject3, brA);
      if (!g((List)localObject2, (List)localObject3)) {
        break label242;
      }
    }
    label242:
    label249:
    for (localObject1 = localProviderInfo;; localObject1 = null)
    {
      if (localObject1 != null) {
        break label254;
      }
      paramContext = e.a.a(1, null);
      AppMethodBeat.o(196220);
      return paramContext;
      localObject1 = androidx.core.content.a.c.c((Resources)localObject1, paramc.brF);
      break;
      i += 1;
      break label163;
    }
    label254:
    paramContext = e.a.a(0, a(paramContext, paramc, ((ProviderInfo)localObject1).authority));
    AppMethodBeat.o(196220);
    return paramContext;
  }
  
  private static List<byte[]> a(Signature[] paramArrayOfSignature)
  {
    AppMethodBeat.i(196263);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfSignature.length)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    AppMethodBeat.o(196263);
    return localArrayList;
  }
  
  private static e.b[] a(Context paramContext, c paramc, String paramString)
  {
    AppMethodBeat.i(196239);
    ArrayList localArrayList = new ArrayList();
    Uri localUri1 = new Uri.Builder().scheme("content").authority(paramString).build();
    Uri localUri2 = new Uri.Builder().scheme("content").authority(paramString).appendPath("file").build();
    for (;;)
    {
      try
      {
        paramString = new String[7];
        paramString[0] = "_id";
        paramString[1] = "file_id";
        paramString[2] = "font_ttc_index";
        paramString[3] = "font_variation_settings";
        paramString[4] = "font_weight";
        paramString[5] = "font_italic";
        paramString[6] = "result_code";
        if (Build.VERSION.SDK_INT <= 16) {
          continue;
        }
        paramContext = paramContext.getContentResolver().query(localUri1, paramString, "query = ?", new String[] { paramc.brD }, null, null);
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
          paramc = paramString;
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
          paramc = ContentUris.withAppendedId(localUri1, paramContext.getLong(n));
          if (i3 == -1) {
            continue;
          }
          k = paramContext.getInt(i3);
          if ((i4 == -1) || (paramContext.getInt(i4) != 1)) {
            continue;
          }
          bool = true;
          paramString.add(new e.b(paramc, j, k, bool, i));
          continue;
          if (paramc == null) {
            continue;
          }
        }
        finally
        {
          paramc = paramContext;
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
        paramc = null;
        continue;
      }
      paramc.close();
      AppMethodBeat.o(196239);
      throw paramContext;
      paramContext = paramContext.getContentResolver().query(localUri1, paramString, "query = ?", new String[] { paramc.brD }, null);
      continue;
      i = 0;
      continue;
      j = 0;
      continue;
      paramc = ContentUris.withAppendedId(localUri2, paramContext.getLong(i1));
      continue;
      k = 400;
      continue;
      bool = false;
    }
    paramc = localArrayList;
    if (paramContext != null) {
      paramContext.close();
    }
    paramContext = (e.b[])paramc.toArray(new e.b[0]);
    AppMethodBeat.o(196239);
    return paramContext;
  }
  
  private static boolean g(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    AppMethodBeat.i(196250);
    if (paramList1.size() != paramList2.size())
    {
      AppMethodBeat.o(196250);
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!Arrays.equals((byte[])paramList1.get(i), (byte[])paramList2.get(i)))
      {
        AppMethodBeat.o(196250);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(196250);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.d.b
 * JD-Core Version:    0.7.0.1
 */