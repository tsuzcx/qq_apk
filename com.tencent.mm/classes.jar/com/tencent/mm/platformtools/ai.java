package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ai
{
  public static boolean a(Context paramContext, ArrayList<ai.c> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(16711);
    if (paramArrayList.size() == 0)
    {
      AppMethodBeat.o(16711);
      return false;
    }
    Iterator localIterator = paramArrayList.iterator();
    ai.c localc;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int i;
    label127:
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localc = (ai.c)localIterator.next();
          } while (TextUtils.isEmpty(localc.bYA));
          localObject2 = localc.bYA;
          localObject1 = new ArrayList();
          localObject3 = paramContext.getPackageResourcePath();
          if (Build.VERSION.SDK_INT < 21) {
            break label599;
          }
          paramArrayList = ((String)localObject3).split("/");
          if (paramArrayList != null)
          {
            i = 0;
            if (i >= paramArrayList.length) {
              break label823;
            }
            if (!paramArrayList[i].contains(paramContext.getPackageName())) {
              break;
            }
            paramArrayList = paramArrayList[i];
            if (!TextUtils.isEmpty(paramArrayList))
            {
              String str = ((String)localObject3).replace(paramArrayList, (String)localObject2 + "-1");
              if (new File(str).exists()) {
                ((List)localObject1).add(str);
              }
              paramArrayList = ((String)localObject3).replace(paramArrayList, (String)localObject2 + "-2");
              if (new File(paramArrayList).exists()) {
                ((List)localObject1).add(paramArrayList);
              }
            }
          }
        } while (((List)localObject1).size() <= 0);
        localObject1 = ((List)localObject1).iterator();
      }
      localObject2 = new File((String)((Iterator)localObject1).next());
    } while (!((File)localObject2).exists());
    label237:
    paramArrayList = "";
    for (;;)
    {
      try
      {
        label256:
        long l = System.currentTimeMillis();
        if (paramBoolean)
        {
          localObject2 = paramContext.getPackageManager().getPackageInfo(localc.bYA, 64);
          if (((PackageInfo)localObject2).signatures.length <= 0) {
            break label829;
          }
          paramArrayList = ag.cE(localObject2.signatures[(localObject2.signatures.length - 1)].toCharsString());
          break label829;
          localObject2 = localc.bYA;
          localObject3 = localc.glU;
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.glU))) {
            break label832;
          }
          bool = true;
          ab.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), localObject2, localObject3, paramArrayList, Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.glU))) {
            break label256;
          }
          l = System.currentTimeMillis();
          if (!paramBoolean) {
            continue;
          }
          i = paramContext.getPackageManager().getPackageInfo(localc.bYA, 0).versionCode;
          paramArrayList = localc.bYA;
          int j = localc.glT;
          if (i > localc.glT) {
            continue;
          }
          bool = true;
          ab.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), paramArrayList, Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          j = localc.glT;
          if (i > j) {
            break label256;
          }
          AppMethodBeat.o(16711);
          return true;
          i += 1;
          break;
          label599:
          paramArrayList = ((String)localObject3).split("/");
          if (paramArrayList == null) {
            break label237;
          }
          localObject3 = new StringBuilder();
          i = 0;
          if (i < paramArrayList.length)
          {
            if (i != paramArrayList.length - 1)
            {
              ((StringBuilder)localObject3).append(paramArrayList[i]);
              ((StringBuilder)localObject3).append("/");
            }
            i += 1;
            continue;
          }
          paramArrayList = ((StringBuilder)localObject3).toString();
          localObject3 = paramArrayList + (String)localObject2 + "-1.apk";
          if (new File((String)localObject3).exists()) {
            ((List)localObject1).add(localObject3);
          }
          paramArrayList = paramArrayList + (String)localObject2 + "-2.apk";
          if (!new File(paramArrayList).exists()) {
            break label237;
          }
          ((List)localObject1).add(paramArrayList);
          break label237;
        }
        paramArrayList = ai.b.x(((File)localObject2).getAbsoluteFile());
        continue;
        i = ai.a.N(paramContext, localc.bYA);
        continue;
        bool = false;
        continue;
      }
      catch (Exception paramArrayList)
      {
        ab.printErrStackTrace("MicroMsg.YYBMarketVerify", paramArrayList, "", new Object[0]);
      }
      AppMethodBeat.o(16711);
      return false;
      label823:
      paramArrayList = "";
      break label127;
      label829:
      continue;
      label832:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.ai
 * JD-Core Version:    0.7.0.1
 */