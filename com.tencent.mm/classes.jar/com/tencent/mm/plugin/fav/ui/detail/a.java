package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public final class a
{
  public static void a(MMActivity paramMMActivity, g paramg)
  {
    Object localObject;
    if ((14 == paramg.field_type) && (!bk.bl(paramg.field_favProto.title))) {
      localObject = paramg.field_favProto.title;
    }
    for (;;)
    {
      paramg = DateFormat.format("yyyy/M/d", paramg.field_updateTime);
      paramMMActivity.setMMSubTitle(String.format(paramMMActivity.getString(n.i.favorite_detail_header_desc), new Object[] { localObject, paramg }));
      return;
      yp localyp = paramg.field_favProto.sXa;
      if ((localyp != null) && (!bk.bl(localyp.sWB)))
      {
        String str1 = b.Cy(localyp.sWB);
        String str2;
        if (q.Gj().equals(localyp.bRO))
        {
          str2 = b.gW(localyp.toUser);
          localObject = str1;
          if (!bk.aM(str2, "").equals(localyp.toUser)) {
            localObject = str1 + " - " + str2;
          }
        }
        else
        {
          str2 = b.gW(localyp.bRO);
          localObject = str1;
          if (!bk.aM(str2, "").equals(localyp.bRO)) {
            localObject = str1 + " - " + str2;
          }
        }
      }
      else
      {
        localObject = b.gW(paramg.field_fromUser);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.a
 * JD-Core Version:    0.7.0.1
 */