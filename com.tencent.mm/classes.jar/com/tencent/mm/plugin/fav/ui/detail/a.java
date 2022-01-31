package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  public static void a(MMActivity paramMMActivity, g paramg)
  {
    AppMethodBeat.i(74456);
    Object localObject;
    if ((14 == paramg.field_type) && (!bo.isNullOrNil(paramg.field_favProto.title))) {
      localObject = paramg.field_favProto.title;
    }
    for (;;)
    {
      paramg = DateFormat.format("yyyy/M/d", paramg.field_updateTime);
      paramMMActivity.setMMSubTitle(String.format(paramMMActivity.getString(2131299688), new Object[] { localObject, paramg }));
      AppMethodBeat.o(74456);
      return;
      acw localacw = paramg.field_favProto.wVa;
      if ((localacw != null) && (!bo.isNullOrNil(localacw.wUA)))
      {
        String str1 = b.NA(localacw.wUA);
        String str2;
        if (r.Zn().equals(localacw.czp))
        {
          str2 = b.nF(localacw.toUser);
          localObject = str1;
          if (!bo.bf(str2, "").equals(localacw.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        else
        {
          str2 = b.nF(localacw.czp);
          localObject = str1;
          if (!bo.bf(str2, "").equals(localacw.czp)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      else
      {
        localObject = b.nF(paramg.field_fromUser);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.a
 * JD-Core Version:    0.7.0.1
 */