package com.tencent.mm.plugin.finder.activity;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/FinderActivityParamUtil;", "", "()V", "convertJumpInfoList", "", "", "jumpInfoList", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "isActivityDraftValid", "", "activityId", "", "from", "", "(Ljava/lang/Long;I)Z", "reconvertJumpInfoList", "jumpInfoBytes", "setActivityParam", "", "originIntent", "Landroid/content/Intent;", "startIntent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Aty;
  
  static
  {
    AppMethodBeat.i(347984);
    Aty = new b();
    AppMethodBeat.o(347984);
  }
  
  public static boolean c(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(347977);
    Object localObject = h.baE().ban().get(at.a.adcL, "").toString();
    if (!Util.isNullOrNil((String)localObject)) {}
    do
    {
      try
      {
        localObject = e.bFB((String)localObject);
        Parcel localParcel = Parcel.obtain();
        s.s(localParcel, "obtain()");
        localParcel.unmarshall((byte[])localObject, 0, localObject.length);
        localParcel.setDataPosition(0);
        localObject = (Intent)Intent.CREATOR.createFromParcel(localParcel);
        if (((Intent)localObject).hasExtra("key_topic_id"))
        {
          if (paramInt != 9)
          {
            AppMethodBeat.o(347977);
            return true;
          }
          l = ((Intent)localObject).getLongExtra("key_topic_id", 0L);
          if (paramLong != null) {
            continue;
          }
          h.baE().ban().set(at.a.adcL, "");
        }
      }
      catch (Exception paramLong)
      {
        for (;;)
        {
          long l;
          Log.e("Finder.ActivityRouter", s.X("goDraft() ", paramLong));
        }
      }
      AppMethodBeat.o(347977);
      return false;
    } while (l != paramLong.longValue());
    AppMethodBeat.o(347977);
    return true;
  }
  
  public static List<byte[]> fQ(List<? extends FinderJumpInfo> paramList)
  {
    AppMethodBeat.i(347958);
    if (paramList == null) {}
    ArrayList localArrayList;
    for (paramList = null;; paramList = localArrayList)
    {
      paramList = (List)paramList;
      AppMethodBeat.o(347958);
      return paramList;
      localArrayList = new ArrayList();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        FinderJumpInfo localFinderJumpInfo = (FinderJumpInfo)paramList.next();
        if (localFinderJumpInfo != null) {
          localArrayList.add(localFinderJumpInfo.toByteArray());
        }
      }
    }
  }
  
  public static List<FinderJumpInfo> fR(List<byte[]> paramList)
  {
    AppMethodBeat.i(347969);
    if (paramList == null) {}
    ArrayList localArrayList;
    for (paramList = null;; paramList = localArrayList)
    {
      paramList = (List)paramList;
      AppMethodBeat.o(347969);
      return paramList;
      localArrayList = new ArrayList();
      Iterator localIterator = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          byte[] arrayOfByte = (byte[])localIterator.next();
          paramList = (a)new FinderJumpInfo();
          try
          {
            paramList.parseFrom(arrayOfByte);
            paramList = (FinderJumpInfo)paramList;
            if (paramList != null) {
              localArrayList.add(paramList);
            }
          }
          catch (Exception paramList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramList });
              paramList = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.b
 * JD-Core Version:    0.7.0.1
 */