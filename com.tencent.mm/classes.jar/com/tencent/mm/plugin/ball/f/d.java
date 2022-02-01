package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v7.d.b;
import android.support.v7.d.b.a;
import android.support.v7.d.b.c;
import android.support.v7.d.b.d;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
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
  private static Map<String, Integer> oYD;
  private static Boolean oYE;
  private static Integer oYF;
  
  static
  {
    AppMethodBeat.i(106363);
    HashMap localHashMap = new HashMap();
    oYD = localHashMap;
    localHashMap.put("doc", Integer.valueOf(2131690215));
    oYD.put("docx", Integer.valueOf(2131690215));
    oYD.put("ppt", Integer.valueOf(2131690213));
    oYD.put("pptx", Integer.valueOf(2131690213));
    oYD.put("xls", Integer.valueOf(2131690208));
    oYD.put("xlsx", Integer.valueOf(2131690208));
    oYD.put("pdf", Integer.valueOf(2131690212));
    oYD.put("numbers", Integer.valueOf(2131690210));
    oYD.put("pages", Integer.valueOf(2131690211));
    oYD.put("key", Integer.valueOf(2131690209));
    oYD.put("txt", Integer.valueOf(2131690214));
    oYD.put("unknown", Integer.valueOf(2131690207));
    oYE = null;
    oYF = null;
    AppMethodBeat.o(106363);
  }
  
  public static int BK(int paramInt)
  {
    int i = 0;
    while (paramInt != 0)
    {
      i += 1;
      paramInt &= paramInt - 1;
    }
    return i;
  }
  
  public static int BL(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 5: 
    case 7: 
    default: 
      return 2131690312;
    case 1: 
      return 2131690307;
    case 3: 
      return 2131690308;
    case 4: 
      return 2131690309;
    case 6: 
      return 2131690310;
    }
    return 2131690311;
  }
  
  public static int BM(int paramInt)
  {
    AppMethodBeat.i(106356);
    if (eX(paramInt, 1))
    {
      AppMethodBeat.o(106356);
      return 2131690315;
    }
    if ((eX(paramInt, 2)) || (eX(paramInt, 128)))
    {
      AppMethodBeat.o(106356);
      return 2131690319;
    }
    if (eX(paramInt, 16))
    {
      AppMethodBeat.o(106356);
      return 2131690314;
    }
    if (eX(paramInt, 32))
    {
      AppMethodBeat.o(106356);
      return 2131690318;
    }
    if (eX(paramInt, 64))
    {
      AppMethodBeat.o(106356);
      return 2131690317;
    }
    if (eX(paramInt, 256))
    {
      AppMethodBeat.o(106356);
      return 2131690316;
    }
    AppMethodBeat.o(106356);
    return -1;
  }
  
  public static boolean H(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.type == 9) || (paramBallInfo.type == 21) || (paramBallInfo.type == 23));
  }
  
  public static boolean I(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.type == 17) || (paramBallInfo.type == 19));
  }
  
  public static e.a T(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106354);
    Object localObject = MMApplicationContext.getContext();
    localObject = new Point(a.jn((Context)localObject), a.jo((Context)localObject));
    int i = ((Point)localObject).x / 2;
    int j = ((Point)localObject).y / 2;
    paramInt2 = paramInt3 / 2 + paramInt2;
    if ((paramInt1 <= i) && (paramInt2 <= j))
    {
      localObject = e.a.oYX;
      AppMethodBeat.o(106354);
      return localObject;
    }
    if (paramInt1 <= i)
    {
      localObject = e.a.oYZ;
      AppMethodBeat.o(106354);
      return localObject;
    }
    if (paramInt2 <= j)
    {
      localObject = e.a.oYY;
      AppMethodBeat.o(106354);
      return localObject;
    }
    localObject = e.a.oZa;
    AppMethodBeat.o(106354);
    return localObject;
  }
  
  public static void a(Bitmap paramBitmap, a parama)
  {
    AppMethodBeat.i(106360);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.d(paramBitmap).a(new b.c()
      {
        public final void a(b paramAnonymousb)
        {
          AppMethodBeat.i(106337);
          if (paramAnonymousb != null)
          {
            paramAnonymousb = paramAnonymousb.abt;
            if (paramAnonymousb != null)
            {
              this.oYG.BN(paramAnonymousb.abF);
              AppMethodBeat.o(106337);
              return;
            }
            Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated but swatch is null");
            this.oYG.BN(this.oYH);
            AppMethodBeat.o(106337);
            return;
          }
          Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated fail");
          this.oYG.BN(this.oYH);
          AppMethodBeat.o(106337);
        }
      });
      AppMethodBeat.o(106360);
      return;
    }
    Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, bitmap is null");
    parama.BN(0);
    AppMethodBeat.o(106360);
  }
  
  public static boolean a(BallInfo paramBallInfo, long paramLong)
  {
    AppMethodBeat.i(258579);
    boolean bool = aG(paramBallInfo.crj, paramLong);
    AppMethodBeat.o(258579);
    return bool;
  }
  
  public static boolean aG(long paramLong1, long paramLong2)
  {
    return (paramLong1 != 0L) && (paramLong2 != 0L) && (paramLong2 - paramLong1 <= 1000L);
  }
  
  public static int aP(Context paramContext)
  {
    AppMethodBeat.i(106362);
    if (!eF(paramContext))
    {
      AppMethodBeat.o(106362);
      return 0;
    }
    if (oYF == null) {
      oYF = Integer.valueOf(ao.aP(paramContext));
    }
    int i = oYF.intValue();
    AppMethodBeat.o(106362);
    return i;
  }
  
  public static Integer agX(String paramString)
  {
    AppMethodBeat.i(106359);
    paramString = (Integer)oYD.get(paramString);
    AppMethodBeat.o(106359);
    return paramString;
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
  
  public static List<BallInfo> cd(List<BallInfo> paramList)
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
  
  public static List<BallInfo> ce(List<BallInfo> paramList)
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
  
  public static boolean cf(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106342);
    if (h(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (!((BallInfo)paramList.next()).oWr)
        {
          AppMethodBeat.o(106342);
          return true;
        }
      }
    }
    AppMethodBeat.o(106342);
    return false;
  }
  
  public static List<BallInfo> cg(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106343);
    if (h(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.oWr) {
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
  
  public static List<BallInfo> ch(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106344);
    if (h(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (localBallInfo.oWr) {
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
  
  public static List<BallInfo> ci(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106345);
    if (h(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.nno) {
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
  
  public static List<BallInfo> cj(List<BallInfo> paramList)
  {
    AppMethodBeat.i(217063);
    if (h(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!H(localBallInfo)) {
          localVector.add(localBallInfo);
        }
      }
      AppMethodBeat.o(217063);
      return localVector;
    }
    paramList = new Vector();
    AppMethodBeat.o(217063);
    return paramList;
  }
  
  public static int cjg()
  {
    AppMethodBeat.i(106352);
    e.ciJ();
    int i = e.ciK();
    AppMethodBeat.o(106352);
    return i;
  }
  
  public static int cjh()
  {
    AppMethodBeat.i(106353);
    e.ciJ();
    int i = e.ciL();
    AppMethodBeat.o(106353);
    return i;
  }
  
  public static BallInfo ck(List<BallInfo> paramList)
  {
    AppMethodBeat.i(217064);
    if (h(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (H(localBallInfo))
        {
          AppMethodBeat.o(217064);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(217064);
    return null;
  }
  
  public static BallInfo cl(List<BallInfo> paramList)
  {
    AppMethodBeat.i(217065);
    if (h(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if ((localBallInfo.type == 17) || (localBallInfo.type == 19))
        {
          AppMethodBeat.o(217065);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(217065);
    return null;
  }
  
  public static List<BallInfo> cm(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106346);
    paramList = cg(ci(paramList));
    AppMethodBeat.o(106346);
    return paramList;
  }
  
  public static boolean cn(List<BallInfo> paramList)
  {
    AppMethodBeat.i(217066);
    if (h(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (H((BallInfo)paramList.next()))
        {
          AppMethodBeat.o(217066);
          return true;
        }
      }
    }
    AppMethodBeat.o(217066);
    return false;
  }
  
  public static int co(List<BallInfo> paramList)
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
      Log.i("MicroMsg.FloatBallUtil", "filterBallInfoListForFloatMenu, single ball info true");
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
        if (!localBallInfo.nno) {
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
  
  public static boolean eF(Context paramContext)
  {
    AppMethodBeat.i(106361);
    if (oYE == null) {
      oYE = Boolean.valueOf(ao.aQ(paramContext));
    }
    boolean bool = oYE.booleanValue();
    AppMethodBeat.o(106361);
    return bool;
  }
  
  public static int eV(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int eW(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  private static boolean eX(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
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
  
  public static boolean q(View paramView, int paramInt1, int paramInt2)
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
  
  public static abstract interface a
  {
    public abstract void BN(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.d
 * JD-Core Version:    0.7.0.1
 */