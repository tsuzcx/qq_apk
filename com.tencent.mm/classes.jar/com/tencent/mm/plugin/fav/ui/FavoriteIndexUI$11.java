package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class FavoriteIndexUI$11
  implements Runnable
{
  FavoriteIndexUI$11(FavoriteIndexUI paramFavoriteIndexUI, double paramDouble1, double paramDouble2, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(74237);
    this.myP.mvt = true;
    double d1 = this.myV;
    double d2 = this.myW;
    int i = this.myX;
    Object localObject2 = this.ieQ;
    Object localObject1 = this.myY;
    String str = this.myZ;
    ArrayList localArrayList = this.mza;
    ach localach = new ach();
    localach.aoe((String)localObject2);
    localach.D(d1);
    localach.C(d2);
    localach.MN(i);
    localach.aof(str);
    localObject2 = new com.tencent.mm.plugin.fav.a.g();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 6;
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.b(localach);
    if ((localObject1 != null) && (!bo.isNullOrNil(((CharSequence)localObject1).toString())))
    {
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aok(((CharSequence)localObject1).toString());
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.nG(bo.aoy());
      com.tencent.mm.plugin.report.service.h.qsU.e(10873, new Object[] { Integer.valueOf(6) });
    }
    h.E((com.tencent.mm.plugin.fav.a.g)localObject2);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.fav.a.g)localObject2).NH((String)((Iterator)localObject1).next());
      }
    }
    b.B((com.tencent.mm.plugin.fav.a.g)localObject2);
    com.tencent.mm.plugin.report.service.h.qsU.e(10648, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
    com.tencent.mm.plugin.fav.a.b.jQ(((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId);
    long l = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId;
    localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(l);
    if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wUd != null)) {
      com.tencent.mm.plugin.fav.a.b.a(l, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wUd, "", "", new ArrayList(), this.myP.getContext());
    }
    AppMethodBeat.o(74237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.11
 * JD-Core Version:    0.7.0.1
 */