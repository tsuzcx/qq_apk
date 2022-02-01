package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v7.d.b;
import android.support.v7.d.b.a;
import android.support.v7.d.b.a.1;
import android.support.v7.d.b.c;
import android.support.v7.d.b.d;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class d
{
  private static Map<String, Integer> nhJ;
  private static Boolean nhK;
  private static Integer nhL;
  
  static
  {
    AppMethodBeat.i(106363);
    HashMap localHashMap = new HashMap();
    nhJ = localHashMap;
    localHashMap.put("doc", Integer.valueOf(2131690178));
    nhJ.put("docx", Integer.valueOf(2131690178));
    nhJ.put("ppt", Integer.valueOf(2131690176));
    nhJ.put("pptx", Integer.valueOf(2131690176));
    nhJ.put("xls", Integer.valueOf(2131690171));
    nhJ.put("xlsx", Integer.valueOf(2131690171));
    nhJ.put("pdf", Integer.valueOf(2131690175));
    nhJ.put("numbers", Integer.valueOf(2131690173));
    nhJ.put("pages", Integer.valueOf(2131690174));
    nhJ.put("key", Integer.valueOf(2131690172));
    nhJ.put("txt", Integer.valueOf(2131690177));
    nhJ.put("unknown", Integer.valueOf(2131690170));
    nhK = null;
    nhL = null;
    AppMethodBeat.o(106363);
  }
  
  public static boolean H(long paramLong1, long paramLong2)
  {
    return (paramLong1 != 0L) && (paramLong2 != 0L) && (paramLong2 - paramLong1 <= 1000L);
  }
  
  public static e.a Q(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106354);
    Object localObject = ai.getContext();
    localObject = new Point(a.ig((Context)localObject), a.ih((Context)localObject));
    int i = ((Point)localObject).x / 2;
    int j = ((Point)localObject).y / 2;
    paramInt2 = paramInt3 / 2 + paramInt2;
    if ((paramInt1 <= i) && (paramInt2 <= j))
    {
      localObject = e.a.nie;
      AppMethodBeat.o(106354);
      return localObject;
    }
    if (paramInt1 <= i)
    {
      localObject = e.a.nig;
      AppMethodBeat.o(106354);
      return localObject;
    }
    if (paramInt2 <= j)
    {
      localObject = e.a.nif;
      AppMethodBeat.o(106354);
      return localObject;
    }
    localObject = e.a.nih;
    AppMethodBeat.o(106354);
    return localObject;
  }
  
  public static Integer SU(String paramString)
  {
    AppMethodBeat.i(106359);
    paramString = (Integer)nhJ.get(paramString);
    AppMethodBeat.o(106359);
    return paramString;
  }
  
  public static void a(Bitmap paramBitmap, a parama)
  {
    AppMethodBeat.i(106360);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap = b.d(paramBitmap);
      new b.a.1(paramBitmap, new b.c()
      {
        public final void a(b paramAnonymousb)
        {
          AppMethodBeat.i(106337);
          if (paramAnonymousb != null)
          {
            paramAnonymousb = paramAnonymousb.Zq;
            if (paramAnonymousb != null)
            {
              this.nhM.xy(paramAnonymousb.ZC);
              AppMethodBeat.o(106337);
              return;
            }
            ac.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated but swatch is null");
            this.nhM.xy(this.nhN);
            AppMethodBeat.o(106337);
            return;
          }
          ac.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated fail");
          this.nhM.xy(this.nhN);
          AppMethodBeat.o(106337);
        }
      }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[] { paramBitmap.mBitmap });
      AppMethodBeat.o(106360);
      return;
    }
    ac.i("MicroMsg.FloatBallUtil", "getPrimaryColor, bitmap is null");
    parama.xy(0);
    AppMethodBeat.o(106360);
  }
  
  public static boolean a(BallInfo paramBallInfo, long paramLong)
  {
    AppMethodBeat.i(208036);
    boolean bool = H(paramBallInfo.fto, paramLong);
    AppMethodBeat.o(208036);
    return bool;
  }
  
  public static int aF(Context paramContext)
  {
    AppMethodBeat.i(106362);
    if (!ei(paramContext))
    {
      AppMethodBeat.o(106362);
      return 0;
    }
    if (nhL == null) {
      nhL = Integer.valueOf(aj.aF(paramContext));
    }
    int i = nhL.intValue();
    AppMethodBeat.o(106362);
    return i;
  }
  
  public static ResultReceiver b(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(106358);
    Parcel localParcel = Parcel.obtain();
    paramResultReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(106358);
    return paramResultReceiver;
  }
  
  public static int bHj()
  {
    AppMethodBeat.i(106352);
    e.bGN();
    int i = e.bGO();
    AppMethodBeat.o(106352);
    return i;
  }
  
  public static int bHk()
  {
    AppMethodBeat.i(106353);
    e.bGN();
    int i = e.bGP();
    AppMethodBeat.o(106353);
    return i;
  }
  
  public static List<BallInfo> bM(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106340);
    if (h(paramList))
    {
      Collections.sort(paramList, new Comparator() {});
      AppMethodBeat.o(106340);
      return paramList;
    }
    paramList = new Vector();
    AppMethodBeat.o(106340);
    return paramList;
  }
  
  public static List<BallInfo> bN(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106341);
    if (h(paramList))
    {
      Collections.sort(paramList, new Comparator() {});
      AppMethodBeat.o(106341);
      return paramList;
    }
    paramList = new Vector();
    AppMethodBeat.o(106341);
    return paramList;
  }
  
  public static boolean bO(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106342);
    if (h(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (!((BallInfo)paramList.next()).nfB)
        {
          AppMethodBeat.o(106342);
          return true;
        }
      }
    }
    AppMethodBeat.o(106342);
    return false;
  }
  
  public static List<BallInfo> bP(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106343);
    if (h(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.nfB) {
          localVector.add(localBallInfo);
        }
      }
      AppMethodBeat.o(106343);
      return localVector;
    }
    paramList = new Vector();
    AppMethodBeat.o(106343);
    return paramList;
  }
  
  public static List<BallInfo> bQ(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106344);
    if (h(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (localBallInfo.nfB) {
          localVector.add(localBallInfo);
        }
      }
      AppMethodBeat.o(106344);
      return localVector;
    }
    paramList = new Vector();
    AppMethodBeat.o(106344);
    return paramList;
  }
  
  public static List<BallInfo> bR(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106345);
    if (h(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.nfC) {
          localVector.add(localBallInfo);
        }
      }
      AppMethodBeat.o(106345);
      return localVector;
    }
    paramList = new Vector();
    AppMethodBeat.o(106345);
    return paramList;
  }
  
  public static List<BallInfo> bS(List<BallInfo> paramList)
  {
    AppMethodBeat.i(176972);
    if (h(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (localBallInfo.type != 9) {
          localVector.add(localBallInfo);
        }
      }
      AppMethodBeat.o(176972);
      return localVector;
    }
    paramList = new Vector();
    AppMethodBeat.o(176972);
    return paramList;
  }
  
  public static BallInfo bT(List<BallInfo> paramList)
  {
    AppMethodBeat.i(176973);
    if (h(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (localBallInfo.type == 9)
        {
          AppMethodBeat.o(176973);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(176973);
    return null;
  }
  
  public static BallInfo bU(List<BallInfo> paramList)
  {
    AppMethodBeat.i(208035);
    if (h(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if ((localBallInfo.type == 17) || (localBallInfo.type == 19))
        {
          AppMethodBeat.o(208035);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(208035);
    return null;
  }
  
  public static List<BallInfo> bV(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106346);
    paramList = bP(bR(paramList));
    AppMethodBeat.o(106346);
    return paramList;
  }
  
  public static int bW(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106357);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((BallInfo)paramList.next()).state | i) {}
    AppMethodBeat.o(106357);
    return i;
  }
  
  public static List<BallInfo> d(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106347);
    if (f(paramList, paramBallInfo))
    {
      ac.i("MicroMsg.FloatBallUtil", "filterBallInfoListForFloatMenu, single ball info true");
      paramList = new Vector();
      AppMethodBeat.o(106347);
      return paramList;
    }
    if (h(paramList))
    {
      paramBallInfo = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.nfC) {
          paramBallInfo.add(localBallInfo);
        }
      }
      AppMethodBeat.o(106347);
      return paramBallInfo;
    }
    paramList = new Vector();
    AppMethodBeat.o(106347);
    return paramList;
  }
  
  public static boolean e(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106348);
    if (h(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (!((BallInfo)paramList.next()).equals(paramBallInfo))
        {
          AppMethodBeat.o(106348);
          return true;
        }
      }
    }
    AppMethodBeat.o(106348);
    return false;
  }
  
  public static int eE(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int eF(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  private static boolean eG(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public static boolean ei(Context paramContext)
  {
    AppMethodBeat.i(106361);
    if (nhK == null) {
      nhK = Boolean.valueOf(aj.aG(paramContext));
    }
    boolean bool = nhK.booleanValue();
    AppMethodBeat.o(106361);
    return bool;
  }
  
  public static boolean f(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106349);
    if ((i(paramList)) && (paramList.contains(paramBallInfo)))
    {
      AppMethodBeat.o(106349);
      return true;
    }
    AppMethodBeat.o(106349);
    return false;
  }
  
  public static boolean h(Collection paramCollection)
  {
    AppMethodBeat.i(106338);
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      AppMethodBeat.o(106338);
      return true;
    }
    AppMethodBeat.o(106338);
    return false;
  }
  
  private static boolean i(Collection paramCollection)
  {
    AppMethodBeat.i(106339);
    if ((h(paramCollection)) && (paramCollection.size() == 1))
    {
      AppMethodBeat.o(106339);
      return true;
    }
    AppMethodBeat.o(106339);
    return false;
  }
  
  public static boolean r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106355);
    if (paramView == null)
    {
      AppMethodBeat.o(106355);
      return false;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    boolean bool = new Rect(i, j, paramView.getWidth() + i, paramView.getHeight() + j).contains(paramInt1, paramInt2);
    AppMethodBeat.o(106355);
    return bool;
  }
  
  public static int xv(int paramInt)
  {
    int i = 0;
    while (paramInt != 0)
    {
      i += 1;
      paramInt &= paramInt - 1;
    }
    return i;
  }
  
  public static int xw(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 5: 
    case 7: 
    default: 
      return 2131690217;
    case 1: 
      return 2131690212;
    case 3: 
      return 2131690213;
    case 4: 
      return 2131690214;
    case 6: 
      return 2131690215;
    }
    return 2131690216;
  }
  
  public static int xx(int paramInt)
  {
    AppMethodBeat.i(106356);
    if (eG(paramInt, 1))
    {
      AppMethodBeat.o(106356);
      return 2131690220;
    }
    if ((eG(paramInt, 2)) || (eG(paramInt, 128)))
    {
      AppMethodBeat.o(106356);
      return 2131690223;
    }
    if (eG(paramInt, 16))
    {
      AppMethodBeat.o(106356);
      return 2131690219;
    }
    if (eG(paramInt, 32))
    {
      AppMethodBeat.o(106356);
      return 2131690222;
    }
    if (eG(paramInt, 64))
    {
      AppMethodBeat.o(106356);
      return 2131690221;
    }
    if (eG(paramInt, 256))
    {
      AppMethodBeat.o(106356);
      return 2131691464;
    }
    AppMethodBeat.o(106356);
    return -1;
  }
  
  public static abstract interface a
  {
    public abstract void xy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.d
 * JD-Core Version:    0.7.0.1
 */