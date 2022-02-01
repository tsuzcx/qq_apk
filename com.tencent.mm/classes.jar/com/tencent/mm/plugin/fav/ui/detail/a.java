package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
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
      paramMMActivity.setMMSubTitle(String.format(paramMMActivity.getString(q.i.favorite_detail_header_desc), new Object[] { localObject, paramg }));
      AppMethodBeat.o(107255);
      return;
      asb localasb = paramg.field_favProto.ZBt;
      if ((localasb != null) && (!Util.isNullOrNil(localasb.ZAT)))
      {
        String str1 = b.atS(localasb.ZAT);
        String str2;
        if (z.bAM().equals(localasb.hQQ))
        {
          str2 = b.IE(localasb.toUser);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localasb.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        else
        {
          str2 = b.IE(localasb.hQQ);
          localObject = str1;
          if (!Util.nullAs(str2, "").equals(localasb.hQQ)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      else
      {
        localObject = b.IE(paramg.field_fromUser);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.a
 * JD-Core Version:    0.7.0.1
 */