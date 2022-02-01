package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  public static void a(MMActivity paramMMActivity, g paramg)
  {
    AppMethodBeat.i(107255);
    Object localObject;
    if ((14 == paramg.field_type) && (!Util.isNullOrNil(paramg.field_favProto.title))) {
      localObject = paramg.field_favProto.title;
    }
    for (;;)
    {
      paramg = DateFormat.format("yyyy/M/d", paramg.field_updateTime);
      paramMMActivity.setMMSubTitle(String.format(paramMMActivity.getString(2131759180), new Object[] { localObject, paramg }));
      AppMethodBeat.o(107255);
      return;
      anh localanh = paramg.field_favProto.Lya;
      if ((localanh != null) && (!Util.isNullOrNil(localanh.LxA)))
      {
        String str1 = b.arL(localanh.LxA);
        String str2;
        if (z.aTY().equals(localanh.dRL))
        {
          str2 = b.Is(localanh.toUser);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localanh.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        else
        {
          str2 = b.Is(localanh.dRL);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localanh.dRL)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      else
      {
        localObject = b.Is(paramg.field_fromUser);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.a
 * JD-Core Version:    0.7.0.1
 */