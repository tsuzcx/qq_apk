package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  public static void a(MMActivity paramMMActivity, g paramg)
  {
    AppMethodBeat.i(107255);
    Object localObject;
    if ((14 == paramg.field_type) && (!bs.isNullOrNil(paramg.field_favProto.title))) {
      localObject = paramg.field_favProto.title;
    }
    for (;;)
    {
      paramg = DateFormat.format("yyyy/M/d", paramg.field_updateTime);
      paramMMActivity.setMMSubTitle(String.format(paramMMActivity.getString(2131758857), new Object[] { localObject, paramg }));
      AppMethodBeat.o(107255);
      return;
      aht localaht = paramg.field_favProto.EBJ;
      if ((localaht != null) && (!bs.isNullOrNil(localaht.EBj)))
      {
        String str1 = b.acr(localaht.EBj);
        String str2;
        if (u.axw().equals(localaht.dng))
        {
          str2 = b.wl(localaht.toUser);
          localObject = str1;
          if (!bs.bG(str2, "").equals(localaht.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        else
        {
          str2 = b.wl(localaht.dng);
          localObject = str1;
          if (!bs.bG(str2, "").equals(localaht.dng)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      else
      {
        localObject = b.wl(paramg.field_fromUser);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.a
 * JD-Core Version:    0.7.0.1
 */