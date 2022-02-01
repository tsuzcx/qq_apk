package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
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
      paramMMActivity.setMMSubTitle(String.format(paramMMActivity.getString(s.i.favorite_detail_header_desc), new Object[] { localObject, paramg }));
      AppMethodBeat.o(107255);
      return;
      aoi localaoi = paramg.field_favProto.SAB;
      if ((localaoi != null) && (!Util.isNullOrNil(localaoi.SAb)))
      {
        String str1 = b.azM(localaoi.SAb);
        String str2;
        if (z.bcZ().equals(localaoi.fLi))
        {
          str2 = b.PK(localaoi.toUser);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localaoi.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        else
        {
          str2 = b.PK(localaoi.fLi);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localaoi.fLi)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      else
      {
        localObject = b.PK(paramg.field_fromUser);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.a
 * JD-Core Version:    0.7.0.1
 */