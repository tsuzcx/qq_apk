package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  public static void a(MMActivity paramMMActivity, g paramg)
  {
    AppMethodBeat.i(107255);
    Object localObject;
    if ((14 == paramg.field_type) && (!bu.isNullOrNil(paramg.field_favProto.title))) {
      localObject = paramg.field_favProto.title;
    }
    for (;;)
    {
      paramg = DateFormat.format("yyyy/M/d", paramg.field_updateTime);
      paramMMActivity.setMMSubTitle(String.format(paramMMActivity.getString(2131758857), new Object[] { localObject, paramg }));
      AppMethodBeat.o(107255);
      return;
      akt localakt = paramg.field_favProto.GCe;
      if ((localakt != null) && (!bu.isNullOrNil(localakt.GBE)))
      {
        String str1 = b.ahd(localakt.GBE);
        String str2;
        if (v.aAC().equals(localakt.dzZ))
        {
          str2 = b.zQ(localakt.toUser);
          localObject = str1;
          if (!bu.bI(str2, "").equals(localakt.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        else
        {
          str2 = b.zQ(localakt.dzZ);
          localObject = str1;
          if (!bu.bI(str2, "").equals(localakt.dzZ)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      else
      {
        localObject = b.zQ(paramg.field_fromUser);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.a
 * JD-Core Version:    0.7.0.1
 */