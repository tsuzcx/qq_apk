package com.tencent.mm.plugin.finder.activity;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.d.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/FinderActivityParamUtil;", "", "()V", "isActivityDraftValid", "", "activityId", "", "from", "", "(Ljava/lang/Long;I)Z", "setActivityParam", "", "originIntent", "Landroid/content/Intent;", "startIntent", "plugin-finder_release"})
public final class b
{
  public static final b wWK;
  
  static
  {
    AppMethodBeat.i(286174);
    wWK = new b();
    AppMethodBeat.o(286174);
  }
  
  public static boolean b(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(286172);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.VAt, "").toString();
    if (!Util.isNullOrNil((String)localObject)) {}
    do
    {
      try
      {
        localObject = e.bCW((String)localObject);
        Parcel localParcel = Parcel.obtain();
        p.j(localParcel, "Parcel.obtain()");
        localParcel.unmarshall((byte[])localObject, 0, localObject.length);
        localParcel.setDataPosition(0);
        localObject = (Intent)Intent.CREATOR.createFromParcel(localParcel);
        if (((Intent)localObject).hasExtra("key_topic_id"))
        {
          if (paramInt != 9)
          {
            AppMethodBeat.o(286172);
            return true;
          }
          l = ((Intent)localObject).getLongExtra("key_topic_id", 0L);
          if (paramLong != null) {
            continue;
          }
          paramLong = h.aHG();
          p.j(paramLong, "MMKernel.storage()");
          paramLong.aHp().set(ar.a.VAt, "");
        }
      }
      catch (Exception paramLong)
      {
        for (;;)
        {
          long l;
          Log.e("Finder.ActivityRouter", "goDraft() ".concat(String.valueOf(paramLong)));
        }
      }
      AppMethodBeat.o(286172);
      return false;
    } while (l != paramLong.longValue());
    AppMethodBeat.o(286172);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.b
 * JD-Core Version:    0.7.0.1
 */