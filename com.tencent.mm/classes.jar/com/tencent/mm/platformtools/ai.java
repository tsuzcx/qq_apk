package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ai
{
  public static boolean a(Context paramContext, ArrayList<ai.c> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList.size() == 0) {
      return false;
    }
    Iterator localIterator = paramArrayList.iterator();
    ai.c localc;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int i;
    label115:
    label244:
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
          } while (TextUtils.isEmpty(localc.bwQ));
          localObject2 = localc.bwQ;
          localObject1 = new ArrayList();
          localObject3 = paramContext.getPackageResourcePath();
          if (Build.VERSION.SDK_INT < 21) {
            break label581;
          }
          paramArrayList = ((String)localObject3).split("/");
          if (paramArrayList != null)
          {
            i = 0;
            if (i >= paramArrayList.length) {
              break label799;
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
    label225:
    paramArrayList = "";
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        if (paramBoolean)
        {
          localObject2 = paramContext.getPackageManager().getPackageInfo(localc.bwQ, 64);
          if (((PackageInfo)localObject2).signatures.length <= 0) {
            break label805;
          }
          paramArrayList = ad.bB(localObject2.signatures[(localObject2.signatures.length - 1)].toCharsString());
          break label805;
          localObject2 = localc.bwQ;
          localObject3 = localc.eTW;
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.eTW))) {
            break label808;
          }
          bool = true;
          y.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), localObject2, localObject3, paramArrayList, Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.eTW))) {
            break label244;
          }
          l = System.currentTimeMillis();
          if (!paramBoolean) {
            continue;
          }
          i = paramContext.getPackageManager().getPackageInfo(localc.bwQ, 0).versionCode;
          paramArrayList = localc.bwQ;
          int j = localc.eTV;
          if (i > localc.eTV) {
            continue;
          }
          bool = true;
          y.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), paramArrayList, Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          j = localc.eTV;
          if (i > j) {
            break label244;
          }
          return true;
          i += 1;
          break;
          label581:
          paramArrayList = ((String)localObject3).split("/");
          if (paramArrayList == null) {
            break label225;
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
            break label225;
          }
          ((List)localObject1).add(paramArrayList);
          break label225;
        }
        paramArrayList = ai.b.r(((File)localObject2).getAbsoluteFile());
        continue;
        i = ai.a.J(paramContext, localc.bwQ);
        continue;
        bool = false;
        continue;
      }
      catch (Exception paramArrayList)
      {
        y.printErrStackTrace("MicroMsg.YYBMarketVerify", paramArrayList, "", new Object[0]);
      }
      return false;
      label799:
      paramArrayList = "";
      break label115;
      label805:
      continue;
      label808:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.ai
 * JD-Core Version:    0.7.0.1
 */