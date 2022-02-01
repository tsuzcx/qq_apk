package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import java.util.LinkedList;

final class ac$1
  implements DialogInterface.OnClickListener
{
  ac$1(ac paramac, w paramw) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(6035);
    Object localObject1;
    aiq localaiq;
    ol localol;
    Object localObject2;
    int i;
    if (this.olG.ftb())
    {
      ag.aGv().DU(this.olG.field_msgId);
      j.a(3, this.olG.ftk(), null);
      paramDialogInterface = this.olH.oll.ogr;
      localObject1 = this.olG;
      if (!((w)localObject1).ftb()) {
        break label523;
      }
      localObject1 = ((w)localObject1).ftk();
      if ((localObject1 == null) || (((dmq)localObject1).style != 101)) {
        break label284;
      }
      localaiq = ((dmq)localObject1).HTS;
      localol = (ol)((om)localaiq.Gal.get(0)).Gcu.get(0);
      localObject2 = localol.FYs;
      i = 0;
      paramInt = 0;
      l2 = 0L;
      l1 = l2;
      if (!bu.isNullOrNil((String)localObject2)) {
        paramInt = i;
      }
    }
    try
    {
      localObject2 = Uri.parse((String)localObject2);
      paramInt = i;
      i = bu.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      paramInt = i;
      l1 = bu.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      paramInt = i;
    }
    catch (Exception localException2)
    {
      label521:
      label523:
      for (;;)
      {
        label284:
        l1 = l2;
      }
    }
    paramDialogInterface.a(((om)localaiq.Gal.get(0)).nIJ, l1, paramInt, 3, ((dmq)localObject1).HDI, "", 0, localaiq.Gau, ((dmq)localObject1).dmp, localaiq.Gaq, localol.Gcq, ((dmq)localObject1).style, localol.Gcr);
    for (;;)
    {
      this.olH.oll.ogh.j(this.olG);
      AppMethodBeat.o(6035);
      return;
      bl.rW(this.olG.field_msgId);
      break;
      if ((localObject1 != null) && ((((dmq)localObject1).style == 102) || (((dmq)localObject1).style == 103)))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((dmq)localObject1).HTS.Gal.size()) {
            break label521;
          }
          localaiq = ((dmq)localObject1).HTS;
          int j;
          if (((om)localaiq.Gal.get(i)).FNv == 0)
          {
            localol = (ol)((om)localaiq.Gal.get(i)).Gcu.get(0);
            if (localol != null)
            {
              localObject2 = localol.FYs;
              j = 0;
              paramInt = 0;
              l2 = 0L;
              l1 = l2;
              if (!bu.isNullOrNil((String)localObject2)) {
                paramInt = j;
              }
            }
          }
          try
          {
            localObject2 = Uri.parse((String)localObject2);
            paramInt = j;
            j = bu.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
            paramInt = j;
            l1 = bu.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
            paramInt = j;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              l1 = l2;
            }
          }
          paramDialogInterface.a(((om)localaiq.Gal.get(i)).nIJ, l1, paramInt, 3, ((dmq)localObject1).HDI, "", 0, localaiq.Gau, ((dmq)localObject1).dmp, localaiq.Gaq, localol.Gcq, ((dmq)localObject1).style, localol.Gcr);
          break;
          i += 1;
        }
        continue;
        paramDialogInterface.d((w)localObject1, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ac.1
 * JD-Core Version:    0.7.0.1
 */