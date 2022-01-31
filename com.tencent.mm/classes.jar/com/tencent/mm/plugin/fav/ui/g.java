package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class g
{
  private static String CV(String paramString)
  {
    return paramString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
  }
  
  private static String a(Context paramContext, xv paramxv)
  {
    switch (paramxv.aYU)
    {
    default: 
      paramContext = paramxv.desc;
    }
    Object localObject;
    do
    {
      do
      {
        return paramContext;
        paramContext = "";
        localObject = paramContext;
        if (paramxv.sVA != null)
        {
          localObject = paramContext;
          if (paramxv.sVA.sWd != null) {
            localObject = paramxv.sVA.sWd.eAl;
          }
        }
        paramContext = (Context)localObject;
      } while (!bk.bl((String)localObject));
      return paramxv.sUN;
      return paramContext.getString(n.i.app_record);
      paramContext = paramContext.getString(n.i.app_app_brand);
      try
      {
        paramxv = paramContext + " " + paramxv.sVA.sWu.sUv;
        return paramxv;
      }
      catch (Exception paramxv) {}
      paramContext = paramContext.getString(n.i.app_friend_card);
      try
      {
        com.tencent.mm.kernel.g.DQ();
        paramxv = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HN(paramxv.desc);
        paramxv = paramContext + " " + paramxv.nickname;
        return paramxv;
      }
      catch (Exception paramxv)
      {
        return paramContext;
      }
      return paramContext.getString(n.i.app_voice) + " " + j.x(paramContext, paramxv.duration / 1000) + "\n";
      localObject = paramxv.desc;
      paramContext = (Context)localObject;
    } while (bk.bl(paramxv.title));
    return paramxv.title + " " + (String)localObject;
    return paramContext;
  }
  
  private static void a(com.tencent.mm.plugin.fav.a.g paramg, int paramInt, String paramString)
  {
    xv localxv = new xv();
    localxv.EH(1);
    localxv.Xv(paramString);
    paramg.field_favProto.sXc.add(paramInt, localxv);
  }
  
  public static void a(MMActivity paramMMActivity, long paramLong, h.a parama)
  {
    for (;;)
    {
      int k;
      try
      {
        com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramLong);
        h.nFQ.f(15378, new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        y.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(localg.field_type) });
        localg.field_flag = 0;
        localg.field_updateTime = System.currentTimeMillis();
        localg.field_localId = -1L;
        localg.field_sourceType = 6;
        if (localg.field_favProto.sXa != null)
        {
          localg.field_favProto.sXa.Ys("");
          localg.field_favProto.sXa.EQ(6);
          localg.field_favProto.sXa.Yq(q.Gj());
        }
        localg.field_fromUser = q.Gj();
        Object localObject1;
        Object localObject2;
        if (localg.field_type == 1)
        {
          localObject1 = new LinkedList();
          localg.field_favProto.az((LinkedList)localObject1);
          a(localg, 0, CV(localg.field_favProto.desc));
          localg.field_localId = System.currentTimeMillis();
          localg.field_type = 18;
          localg.field_xml = com.tencent.mm.plugin.fav.a.g.s(localg);
          localObject1 = new yl();
          if (parama != null)
          {
            ((yl)localObject1).scene = parama.scene;
            ((yl)localObject1).jYS = parama.jYS;
            ((yl)localObject1).index = parama.index;
            ((yl)localObject1).bVk = parama.bVk;
            ((yl)localObject1).bIB = parama.sid;
            ((yl)localObject1).jYU = parama.jYU;
          }
          parama = new ku();
          parama.bTL.field_localId = localg.field_localId;
          parama.bTL.bTR = 5;
          parama.bTL.bTN = localg.field_xml;
          parama.bTL.context = paramMMActivity;
          localObject2 = new Bundle();
          localObject3 = localg.field_favProto.sro;
          if (localObject3 != null)
          {
            ((Bundle)localObject2).putString("noteauthor", ((yd)localObject3).sWT);
            ((Bundle)localObject2).putString("noteeditor", ((yd)localObject3).sWU);
          }
          ((Bundle)localObject2).putLong("edittime", localg.field_updateTime);
          parama.bTL.bTQ = ((Bundle)localObject2);
          parama.bTL.field_favProto = localg.field_favProto;
          parama.bTL.type = 2;
          parama.bTL.bTT = true;
          parama.bTL.bTU = ((yl)localObject1);
          a.udP.m(parama);
          paramMMActivity.finish();
          return;
        }
        if (localg.field_favProto.sXc == null) {
          continue;
        }
        j = 1;
        i = 0;
        if (i >= localg.field_favProto.sXc.size()) {
          continue;
        }
        Object localObject3 = (xv)localg.field_favProto.sXc.get(i);
        if ((localg.field_type != 18) || (!((xv)localObject3).sVI.equals("WeNoteHtmlFile")))
        {
          localObject1 = b.b((xv)localObject3);
          localObject2 = b.c((xv)localObject3);
          ((xv)localObject3).XH(b.bB(localObject3.toString(), 18));
          String str1 = b.b((xv)localObject3);
          String str2 = b.c((xv)localObject3);
          if ((!bk.bl((String)localObject1)) && (!bk.bl(str1)) && (e.bK((String)localObject1))) {
            e.r((String)localObject1, str1);
          }
          if ((!bk.bl((String)localObject2)) && (!bk.bl(str2)) && (e.bK((String)localObject2))) {
            e.r((String)localObject2, str2);
          }
        }
        if (localg.field_type != 18)
        {
          if (((xv)localObject3).aYU == 1)
          {
            if (localg.field_type == 14)
            {
              if (((xv)localObject3).desc == null)
              {
                localObject1 = "\n";
                if (((xv)localObject3).sVC == null)
                {
                  localObject2 = "";
                  ((xv)localObject3).Xv(CV((String)localObject2 + (String)localObject1 + "\n"));
                  break label1161;
                }
              }
              else
              {
                localObject1 = ((xv)localObject3).desc + "\n";
                continue;
              }
              localObject2 = ((xv)localObject3).sVC + ":\n";
              continue;
            }
            if (!bk.bl(((xv)localObject3).desc))
            {
              ((xv)localObject3).Xv(CV(((xv)localObject3).desc));
              break label1161;
            }
          }
          else
          {
            localObject1 = new StringBuilder("WeNote_");
            k = j + 1;
            ((xv)localObject3).XR(j);
            j = i;
            if (localg.field_type == 14)
            {
              j = i;
              if (((xv)localObject3).sVC != null)
              {
                a(localg, i, CV(((xv)localObject3).sVC + ":"));
                j = i + 1;
              }
            }
            i = ((xv)localObject3).aYU;
            if ((i == 1) || (i == 2) || (i == 3) || (i == 6) || (i == 8) || (i == 4)) {
              break label1170;
            }
            if (i != 0) {
              break label1176;
            }
            break label1170;
            if (i == 0)
            {
              localg.field_favProto.sXc.remove(j);
              localObject1 = a(paramMMActivity, (xv)localObject3);
              if (localObject1 == null)
              {
                localObject1 = "\n\n";
                a(localg, j, CV((String)localObject1));
              }
            }
            else
            {
              if (((xv)localObject3).aYU != 3) {
                break label1150;
              }
              ((xv)localObject3).EH(20);
              i = j;
              j = k;
              break label1161;
            }
            localObject1 = "\n" + (String)localObject1 + "\n\n";
            continue;
          }
        }
        else if (((xv)localObject3).aYU == 20)
        {
          ((xv)localObject3).Xy("");
          ((xv)localObject3).Xz("");
        }
      }
      catch (Throwable parama)
      {
        Toast.makeText(paramMMActivity, paramMMActivity.getString(n.i.favorite_save_as_note_failed), 0).show();
        return;
      }
      label1150:
      int i = j;
      int j = k;
      label1161:
      i += 1;
      continue;
      label1170:
      i = 1;
      continue;
      label1176:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.g
 * JD-Core Version:    0.7.0.1
 */