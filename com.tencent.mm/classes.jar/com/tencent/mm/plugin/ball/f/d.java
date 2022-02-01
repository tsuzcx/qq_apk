package com.tencent.mm.plugin.ball.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.view.View;
import androidx.j.a.b;
import androidx.j.a.b.a;
import androidx.j.a.b.c;
import androidx.j.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.ball.a.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
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
  private static Map<String, Integer> saE;
  private static Boolean saF;
  private static Integer saG;
  
  static
  {
    AppMethodBeat.i(106363);
    HashMap localHashMap = new HashMap();
    saE = localHashMap;
    localHashMap.put("doc", Integer.valueOf(a.g.file_float_ball_icon_word));
    saE.put("docx", Integer.valueOf(a.g.file_float_ball_icon_word));
    saE.put("ppt", Integer.valueOf(a.g.file_float_ball_icon_ppt));
    saE.put("pptx", Integer.valueOf(a.g.file_float_ball_icon_ppt));
    saE.put("xls", Integer.valueOf(a.g.file_float_ball_icon_excel));
    saE.put("xlsx", Integer.valueOf(a.g.file_float_ball_icon_excel));
    saE.put("pdf", Integer.valueOf(a.g.file_float_ball_icon_pdf));
    saE.put("numbers", Integer.valueOf(a.g.file_float_ball_icon_numbers));
    saE.put("pages", Integer.valueOf(a.g.file_float_ball_icon_pages));
    saE.put("key", Integer.valueOf(a.g.file_float_ball_icon_key));
    saE.put("txt", Integer.valueOf(a.g.file_float_ball_icon_txt));
    saE.put("unknown", Integer.valueOf(a.g.file_float_ball_icon_default));
    saF = null;
    saG = null;
    AppMethodBeat.o(106363);
  }
  
  public static int Fl(int paramInt)
  {
    int i = 0;
    while (paramInt != 0)
    {
      i += 1;
      paramInt &= paramInt - 1;
    }
    return i;
  }
  
  public static int Fm(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return a.g.float_ball_icon_webpage_default;
    case 1: 
      return a.g.float_ball_icon_appbrand_default;
    case 2: 
      return a.g.float_ball_icon_webpage_default;
    case 5: 
      return a.g.float_ball_icon_webpage_default;
    case 3: 
      return a.g.float_ball_icon_fav_default;
    case 4: 
      return a.g.float_ball_icon_files_default;
    case 6: 
      return a.g.float_ball_icon_music_default;
    }
    return a.g.float_ball_icon_topstory_default;
  }
  
  public static int Fn(int paramInt)
  {
    AppMethodBeat.i(106356);
    if (fw(paramInt, 1))
    {
      paramInt = a.g.float_ball_state_location;
      AppMethodBeat.o(106356);
      return paramInt;
    }
    if ((fw(paramInt, 2)) || (fw(paramInt, 128)))
    {
      paramInt = a.g.float_ball_state_music;
      AppMethodBeat.o(106356);
      return paramInt;
    }
    if (fw(paramInt, 16))
    {
      paramInt = a.g.float_ball_state_game_download_stable;
      AppMethodBeat.o(106356);
      return paramInt;
    }
    if (fw(paramInt, 32))
    {
      paramInt = a.g.float_ball_state_mike_on;
      AppMethodBeat.o(106356);
      return paramInt;
    }
    if (fw(paramInt, 64))
    {
      paramInt = a.g.float_ball_state_mike_off;
      AppMethodBeat.o(106356);
      return paramInt;
    }
    if (fw(paramInt, 256))
    {
      paramInt = a.g.float_ball_state_message;
      AppMethodBeat.o(106356);
      return paramInt;
    }
    AppMethodBeat.o(106356);
    return -1;
  }
  
  public static boolean H(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.type == 9) || (paramBallInfo.type == 21) || (paramBallInfo.type == 22) || (paramBallInfo.type == 23) || (paramBallInfo.type == 24));
  }
  
  public static boolean I(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.type == 17) || (paramBallInfo.type == 19));
  }
  
  public static boolean M(long paramLong1, long paramLong2)
  {
    return (paramLong1 != 0L) && (paramLong2 != 0L) && (paramLong2 - paramLong1 <= 1000L);
  }
  
  public static e.a U(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106354);
    Object localObject = MMApplicationContext.getContext();
    localObject = new Point(a.kr((Context)localObject), a.ks((Context)localObject));
    int i = ((Point)localObject).x / 2;
    int j = ((Point)localObject).y / 2;
    paramInt2 = paramInt3 / 2 + paramInt2;
    if ((paramInt1 <= i) && (paramInt2 <= j))
    {
      localObject = e.a.saY;
      AppMethodBeat.o(106354);
      return localObject;
    }
    if (paramInt1 <= i)
    {
      localObject = e.a.sba;
      AppMethodBeat.o(106354);
      return localObject;
    }
    if (paramInt2 <= j)
    {
      localObject = e.a.saZ;
      AppMethodBeat.o(106354);
      return localObject;
    }
    localObject = e.a.sbb;
    AppMethodBeat.o(106354);
    return localObject;
  }
  
  public static void a(Bitmap paramBitmap, a parama)
  {
    AppMethodBeat.i(106360);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.e(paramBitmap).a(new b.c()
      {
        public final void a(b paramAnonymousb)
        {
          AppMethodBeat.i(186837);
          if (paramAnonymousb != null)
          {
            paramAnonymousb = paramAnonymousb.aeY;
            if (paramAnonymousb != null)
            {
              this.saH.Fo(paramAnonymousb.afk);
              AppMethodBeat.o(186837);
              return;
            }
            Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated but swatch is null");
            this.saH.Fo(this.saI);
            AppMethodBeat.o(186837);
            return;
          }
          Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, palette generated fail");
          this.saH.Fo(this.saI);
          AppMethodBeat.o(186837);
        }
      });
      AppMethodBeat.o(106360);
      return;
    }
    Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, bitmap is null");
    parama.Fo(0);
    AppMethodBeat.o(106360);
  }
  
  public static boolean a(BallInfo paramBallInfo, long paramLong)
  {
    AppMethodBeat.i(187413);
    boolean bool = M(paramBallInfo.coZ, paramLong);
    AppMethodBeat.o(187413);
    return bool;
  }
  
  public static int aM(Context paramContext)
  {
    AppMethodBeat.i(106362);
    if (!eI(paramContext))
    {
      AppMethodBeat.o(106362);
      return 0;
    }
    if (saG == null) {
      saG = Integer.valueOf(ar.aM(paramContext));
    }
    int i = saG.intValue();
    AppMethodBeat.o(106362);
    return i;
  }
  
  public static Integer aoD(String paramString)
  {
    AppMethodBeat.i(106359);
    paramString = (Integer)saE.get(paramString);
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
  
  public static List<BallInfo> bZ(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106340);
    if (checkListNotEmpty(paramList))
    {
      Collections.sort(paramList, new Comparator() {});
      AppMethodBeat.o(106340);
      return paramList;
    }
    paramList = new Vector();
    AppMethodBeat.o(106340);
    return paramList;
  }
  
  public static List<BallInfo> ca(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106341);
    if (checkListNotEmpty(paramList))
    {
      Collections.sort(paramList, new Comparator() {});
      AppMethodBeat.o(106341);
      return paramList;
    }
    paramList = new Vector();
    AppMethodBeat.o(106341);
    return paramList;
  }
  
  public static boolean cb(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106342);
    if (checkListNotEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (!((BallInfo)paramList.next()).rYr)
        {
          AppMethodBeat.o(106342);
          return true;
        }
      }
    }
    AppMethodBeat.o(106342);
    return false;
  }
  
  public static List<BallInfo> cc(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106343);
    if (checkListNotEmpty(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.rYr) {
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
  
  public static List<BallInfo> cd(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106344);
    if (checkListNotEmpty(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (localBallInfo.rYr) {
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
  
  public static List<BallInfo> ce(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106345);
    if (checkListNotEmpty(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.qmt) {
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
  
  public static List<BallInfo> cf(List<BallInfo> paramList)
  {
    AppMethodBeat.i(187388);
    if (checkListNotEmpty(paramList))
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
      AppMethodBeat.o(187388);
      return localVector;
    }
    paramList = new Vector();
    AppMethodBeat.o(187388);
    return paramList;
  }
  
  public static BallInfo cg(List<BallInfo> paramList)
  {
    AppMethodBeat.i(187390);
    if (checkListNotEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (H(localBallInfo))
        {
          AppMethodBeat.o(187390);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(187390);
    return null;
  }
  
  public static BallInfo ch(List<BallInfo> paramList)
  {
    AppMethodBeat.i(187392);
    if (checkListNotEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if ((localBallInfo.type == 17) || (localBallInfo.type == 19))
        {
          AppMethodBeat.o(187392);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(187392);
    return null;
  }
  
  public static boolean checkListNotEmpty(Collection paramCollection)
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
  
  public static List<BallInfo> ci(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106346);
    paramList = cc(ce(paramList));
    AppMethodBeat.o(106346);
    return paramList;
  }
  
  public static boolean cj(List<BallInfo> paramList)
  {
    AppMethodBeat.i(187393);
    if (checkListNotEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (H((BallInfo)paramList.next()))
        {
          AppMethodBeat.o(187393);
          return true;
        }
      }
    }
    AppMethodBeat.o(187393);
    return false;
  }
  
  public static int ck(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106357);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((BallInfo)paramList.next()).state | i) {}
    AppMethodBeat.o(106357);
    return i;
  }
  
  public static int cwy()
  {
    AppMethodBeat.i(106352);
    com.tencent.mm.plugin.ball.service.d.cwb();
    int i = com.tencent.mm.plugin.ball.service.d.cwc();
    AppMethodBeat.o(106352);
    return i;
  }
  
  public static int cwz()
  {
    AppMethodBeat.i(106353);
    com.tencent.mm.plugin.ball.service.d.cwb();
    int i = com.tencent.mm.plugin.ball.service.d.cwd();
    AppMethodBeat.o(106353);
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
    if (checkListNotEmpty(paramList))
    {
      paramBallInfo = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.qmt) {
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
    if (checkListNotEmpty(paramList))
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
  
  public static boolean eI(Context paramContext)
  {
    AppMethodBeat.i(106361);
    if (saF == null) {
      saF = Boolean.valueOf(ar.aN(paramContext));
    }
    boolean bool = saF.booleanValue();
    AppMethodBeat.o(106361);
    return bool;
  }
  
  public static boolean f(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106349);
    if ((h(paramList)) && (paramList.contains(paramBallInfo)))
    {
      AppMethodBeat.o(106349);
      return true;
    }
    AppMethodBeat.o(106349);
    return false;
  }
  
  public static int fu(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int fv(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  private static boolean fw(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  private static boolean h(Collection paramCollection)
  {
    AppMethodBeat.i(106339);
    if ((checkListNotEmpty(paramCollection)) && (paramCollection.size() == 1))
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
    public abstract void Fo(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.d
 * JD-Core Version:    0.7.0.1
 */