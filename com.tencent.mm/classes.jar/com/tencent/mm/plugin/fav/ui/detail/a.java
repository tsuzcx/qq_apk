package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  public static void a(MMActivity paramMMActivity, g paramg)
  {
    AppMethodBeat.i(107255);
    Object localObject;
    if ((14 == paramg.field_type) && (!bt.isNullOrNil(paramg.field_favProto.title))) {
      localObject = paramg.field_favProto.title;
    }
    for (;;)
    {
      paramg = DateFormat.format("yyyy/M/d", paramg.field_updateTime);
      paramMMActivity.setMMSubTitle(String.format(paramMMActivity.getString(2131758857), new Object[] { localObject, paramg }));
      AppMethodBeat.o(107255);
      return;
      agu localagu = paramg.field_favProto.DiD;
      if ((localagu != null) && (!bt.isNullOrNil(localagu.Did)))
      {
        String str1 = b.XV(localagu.Did);
        String str2;
        if (u.aqG().equals(localagu.dpv))
        {
          str2 = b.si(localagu.toUser);
          localObject = str1;
          if (!bt.by(str2, "").equals(localagu.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        else
        {
          str2 = b.si(localagu.dpv);
          localObject = str1;
          if (!bt.by(str2, "").equals(localagu.dpv)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      else
      {
        localObject = b.si(paramg.field_fromUser);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.a
 * JD-Core Version:    0.7.0.1
 */