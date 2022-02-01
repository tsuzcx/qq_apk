package com.tencent.mm.plugin.finder.activity;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/FinderActivityParamUtil;", "", "()V", "isActivityDraftValid", "", "activityId", "", "from", "", "(Ljava/lang/Long;I)Z", "setActivityParam", "", "originIntent", "Landroid/content/Intent;", "startIntent", "plugin-finder_release"})
public final class b
{
  public static final b tqg;
  
  static
  {
    AppMethodBeat.i(241999);
    tqg = new b();
    AppMethodBeat.o(241999);
  }
  
  public static boolean b(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(241998);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.Oly, "").toString();
    if (!Util.isNullOrNil((String)localObject)) {}
    do
    {
      try
      {
        localObject = com.tencent.e.f.e.bqe((String)localObject);
        Parcel localParcel = Parcel.obtain();
        p.g(localParcel, "Parcel.obtain()");
        localParcel.unmarshall((byte[])localObject, 0, localObject.length);
        localParcel.setDataPosition(0);
        localObject = (Intent)Intent.CREATOR.createFromParcel(localParcel);
        if (((Intent)localObject).hasExtra("key_topic_id"))
        {
          if (paramInt != 9)
          {
            AppMethodBeat.o(241998);
            return true;
          }
          l = ((Intent)localObject).getLongExtra("key_topic_id", 0L);
          if (paramLong != null) {
            continue;
          }
          paramLong = g.aAh();
          p.g(paramLong, "MMKernel.storage()");
          paramLong.azQ().set(ar.a.Oly, "");
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
      AppMethodBeat.o(241998);
      return false;
    } while (l != paramLong.longValue());
    AppMethodBeat.o(241998);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.b
 * JD-Core Version:    0.7.0.1
 */