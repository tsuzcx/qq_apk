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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
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
  private static Map<String, Integer> vlV;
  private static Boolean vlW;
  private static Integer vlX;
  private static Integer vlY;
  
  static
  {
    AppMethodBeat.i(106363);
    Object localObject = new HashMap();
    vlV = (Map)localObject;
    ((Map)localObject).put("doc", Integer.valueOf(a.g.file_float_ball_icon_word));
    vlV.put("docx", Integer.valueOf(a.g.file_float_ball_icon_word));
    vlV.put("ppt", Integer.valueOf(a.g.file_float_ball_icon_ppt));
    vlV.put("pptx", Integer.valueOf(a.g.file_float_ball_icon_ppt));
    vlV.put("xls", Integer.valueOf(a.g.file_float_ball_icon_excel));
    vlV.put("xlsx", Integer.valueOf(a.g.file_float_ball_icon_excel));
    vlV.put("pdf", Integer.valueOf(a.g.file_float_ball_icon_pdf));
    vlV.put("numbers", Integer.valueOf(a.g.file_float_ball_icon_numbers));
    vlV.put("pages", Integer.valueOf(a.g.file_float_ball_icon_pages));
    vlV.put("key", Integer.valueOf(a.g.file_float_ball_icon_key));
    vlV.put("txt", Integer.valueOf(a.g.file_float_ball_icon_txt));
    vlV.put("unknown", Integer.valueOf(a.g.file_float_ball_icon_default));
    vlV.put("ofd", Integer.valueOf(a.g.file_float_ball_icon_ofd));
    vlW = null;
    vlX = null;
    vlY = null;
    localObject = Integer.valueOf(((c)h.ax(c.class)).a(c.a.zgB, 3000));
    vlY = (Integer)localObject;
    if (((Integer)localObject).intValue() <= 0) {
      vlY = Integer.valueOf(3000);
    }
    for (;;)
    {
      Log.i("MicroMsg.FloatBallUtil", "addMessageBallTimeLimitInMs %s", new Object[] { vlY });
      AppMethodBeat.o(106363);
      return;
      if (vlY.intValue() > 10000) {
        vlY = Integer.valueOf(10000);
      }
    }
  }
  
  public static int FM(int paramInt)
  {
    int i = 0;
    while (paramInt != 0)
    {
      i += 1;
      paramInt &= paramInt - 1;
    }
    return i;
  }
  
  public static boolean H(BallInfo paramBallInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBallInfo != null)
    {
      int j = paramBallInfo.type;
      int i = j;
      if (j == 20) {
        i = paramBallInfo.cIh;
      }
      if ((i != 9) && (i != 21) && (i != 22) && (i != 32) && (i != 23))
      {
        bool1 = bool2;
        if (i != 24) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean I(BallInfo paramBallInfo)
  {
    return (paramBallInfo != null) && ((paramBallInfo.type == 17) || (paramBallInfo.type == 19));
  }
  
  public static int J(BallInfo paramBallInfo)
  {
    int i = paramBallInfo.type;
    if (paramBallInfo.type == 20)
    {
      int j = paramBallInfo.cIh;
      i = j;
      if (j == 5) {
        return a.g.float_ball_icon_game_center_default;
      }
    }
    switch (i)
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
  
  public static int K(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(288370);
    int i = paramBallInfo.state;
    if (go(i, 1))
    {
      i = a.g.float_ball_state_location;
      AppMethodBeat.o(288370);
      return i;
    }
    if ((go(i, 2)) || (go(i, 128)))
    {
      i = a.g.float_ball_state_music;
      AppMethodBeat.o(288370);
      return i;
    }
    if (go(i, 16))
    {
      i = a.g.float_ball_state_game_download_stable;
      AppMethodBeat.o(288370);
      return i;
    }
    if (go(i, 32))
    {
      i = a.g.float_ball_state_mike_on;
      AppMethodBeat.o(288370);
      return i;
    }
    if (go(i, 64))
    {
      i = a.g.float_ball_state_mike_off;
      AppMethodBeat.o(288370);
      return i;
    }
    if (go(i, 256))
    {
      if (paramBallInfo.cIh == 32)
      {
        i = paramBallInfo.tus;
        AppMethodBeat.o(288370);
        return i;
      }
      i = a.g.float_ball_state_message;
      AppMethodBeat.o(288370);
      return i;
    }
    if (go(i, 4096))
    {
      i = a.g.float_ball_state_appbrand_bluetooth;
      AppMethodBeat.o(288370);
      return i;
    }
    AppMethodBeat.o(288370);
    return -1;
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    AppMethodBeat.i(288399);
    paramFloat3 = Math.max(0.0F, Math.min(1.0F, (paramFloat3 - paramFloat4) / (paramFloat5 - paramFloat4)));
    AppMethodBeat.o(288399);
    return paramFloat3 * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  public static void a(Bitmap paramBitmap, d.a parama)
  {
    AppMethodBeat.i(106360);
    if (parama == null)
    {
      AppMethodBeat.o(106360);
      return;
    }
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      b.l(paramBitmap).a(new d.3(parama));
      AppMethodBeat.o(106360);
      return;
    }
    Log.i("MicroMsg.FloatBallUtil", "getPrimaryColor, bitmap is null");
    parama.onGetColor(0);
    AppMethodBeat.o(106360);
  }
  
  public static boolean a(BallInfo paramBallInfo, long paramLong)
  {
    AppMethodBeat.i(288393);
    long l = paramBallInfo.egK;
    if ((l != 0L) && (paramLong != 0L) && (paramLong - l <= vlY.intValue()))
    {
      AppMethodBeat.o(288393);
      return true;
    }
    AppMethodBeat.o(288393);
    return false;
  }
  
  public static Integer ahZ(String paramString)
  {
    AppMethodBeat.i(106359);
    paramString = (Integer)vlV.get(paramString);
    AppMethodBeat.o(106359);
    return paramString;
  }
  
  public static boolean ak(long paramLong1, long paramLong2)
  {
    return (paramLong1 != 0L) && (paramLong2 != 0L) && (paramLong2 - paramLong1 <= 1000L);
  }
  
  public static e.a al(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106354);
    Object localObject = MMApplicationContext.getContext();
    localObject = new Point(a.ms((Context)localObject), a.mt((Context)localObject));
    int i = ((Point)localObject).x / 2;
    int j = ((Point)localObject).y / 2;
    paramInt2 = paramInt3 / 2 + paramInt2;
    if ((paramInt1 <= i) && (paramInt2 <= j))
    {
      localObject = e.a.vmq;
      AppMethodBeat.o(106354);
      return localObject;
    }
    if (paramInt1 <= i)
    {
      localObject = e.a.vms;
      AppMethodBeat.o(106354);
      return localObject;
    }
    if (paramInt2 <= j)
    {
      localObject = e.a.vmr;
      AppMethodBeat.o(106354);
      return localObject;
    }
    localObject = e.a.vmt;
    AppMethodBeat.o(106354);
    return localObject;
  }
  
  public static int bw(Context paramContext)
  {
    AppMethodBeat.i(106362);
    if (!fD(paramContext))
    {
      AppMethodBeat.o(106362);
      return 0;
    }
    if (vlX == null) {
      vlX = Integer.valueOf(aw.bw(paramContext));
    }
    int i = vlX.intValue();
    AppMethodBeat.o(106362);
    return i;
  }
  
  public static ResultReceiver c(ResultReceiver paramResultReceiver)
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
  
  public static int cZh()
  {
    AppMethodBeat.i(106352);
    com.tencent.mm.plugin.ball.service.d.cYL();
    int i = com.tencent.mm.plugin.ball.service.d.cYM();
    AppMethodBeat.o(106352);
    return i;
  }
  
  public static int cZi()
  {
    AppMethodBeat.i(106353);
    com.tencent.mm.plugin.ball.service.d.cYL();
    int i = com.tencent.mm.plugin.ball.service.d.cYN();
    AppMethodBeat.o(106353);
    return i;
  }
  
  public static int cZj()
  {
    AppMethodBeat.i(288398);
    if (vlY != null)
    {
      int i = vlY.intValue();
      AppMethodBeat.o(288398);
      return i;
    }
    AppMethodBeat.o(288398);
    return -1;
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
        if (!localBallInfo.trn) {
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
  
  public static List<BallInfo> dR(List<BallInfo> paramList)
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
  
  public static List<BallInfo> dS(List<BallInfo> paramList)
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
  
  public static boolean dT(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106342);
    if (checkListNotEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (!((BallInfo)paramList.next()).vjH)
        {
          AppMethodBeat.o(106342);
          return true;
        }
      }
    }
    AppMethodBeat.o(106342);
    return false;
  }
  
  public static List<BallInfo> dU(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106343);
    if (checkListNotEmpty(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.vjH) {
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
  
  public static List<BallInfo> dV(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106344);
    if (checkListNotEmpty(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (localBallInfo.vjH) {
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
  
  public static List<BallInfo> dW(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106345);
    if (checkListNotEmpty(paramList))
    {
      Vector localVector = new Vector();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (!localBallInfo.trn) {
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
  
  public static List<BallInfo> dX(List<BallInfo> paramList)
  {
    AppMethodBeat.i(288296);
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
      AppMethodBeat.o(288296);
      return localVector;
    }
    paramList = new Vector();
    AppMethodBeat.o(288296);
    return paramList;
  }
  
  public static BallInfo dY(List<BallInfo> paramList)
  {
    AppMethodBeat.i(288298);
    if (checkListNotEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if (H(localBallInfo))
        {
          AppMethodBeat.o(288298);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(288298);
    return null;
  }
  
  public static BallInfo dZ(List<BallInfo> paramList)
  {
    AppMethodBeat.i(288302);
    if (checkListNotEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BallInfo localBallInfo = (BallInfo)paramList.next();
        if ((localBallInfo.type == 17) || (localBallInfo.type == 19))
        {
          AppMethodBeat.o(288302);
          return localBallInfo;
        }
      }
    }
    AppMethodBeat.o(288302);
    return null;
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
  
  public static List<BallInfo> ea(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106346);
    paramList = dU(dW(paramList));
    AppMethodBeat.o(106346);
    return paramList;
  }
  
  public static boolean eb(List<BallInfo> paramList)
  {
    AppMethodBeat.i(288325);
    if (checkListNotEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (H((BallInfo)paramList.next()))
        {
          AppMethodBeat.o(288325);
          return true;
        }
      }
    }
    AppMethodBeat.o(288325);
    return false;
  }
  
  public static int ec(List<BallInfo> paramList)
  {
    AppMethodBeat.i(106357);
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = ((BallInfo)paramList.next()).state | i) {}
    AppMethodBeat.o(106357);
    return i;
  }
  
  public static boolean f(List<BallInfo> paramList, BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106349);
    if ((w(paramList)) && (paramList.contains(paramBallInfo)))
    {
      AppMethodBeat.o(106349);
      return true;
    }
    AppMethodBeat.o(106349);
    return false;
  }
  
  public static boolean fD(Context paramContext)
  {
    AppMethodBeat.i(106361);
    if (vlW == null) {
      vlW = Boolean.valueOf(aw.bx(paramContext));
    }
    boolean bool = vlW.booleanValue();
    AppMethodBeat.o(106361);
    return bool;
  }
  
  public static int gm(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public static int gn(int paramInt1, int paramInt2)
  {
    return (paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  private static boolean go(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
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
  
  private static boolean w(Collection paramCollection)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.d
 * JD-Core Version:    0.7.0.1
 */