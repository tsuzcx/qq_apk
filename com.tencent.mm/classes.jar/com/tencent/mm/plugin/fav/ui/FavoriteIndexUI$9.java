package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class FavoriteIndexUI$9
  implements Runnable
{
  FavoriteIndexUI$9(FavoriteIndexUI paramFavoriteIndexUI, double paramDouble1, double paramDouble2, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, ArrayList paramArrayList) {}
  
  public final void run()
  {
    this.kee.kaX = true;
    double d1 = this.kek;
    double d2 = this.kel;
    int i = this.kem;
    Object localObject2 = this.ken;
    Object localObject1 = this.keo;
    String str = this.kep;
    ArrayList localArrayList = this.keq;
    yc localyc = new yc();
    localyc.Yh((String)localObject2);
    localyc.z(d1);
    localyc.y(d2);
    localyc.EM(i);
    localyc.Yi(str);
    localObject2 = new com.tencent.mm.plugin.fav.a.g();
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = 6;
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_sourceType = 6;
    ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.b(localyc);
    if ((localObject1 != null) && (!bk.bl(((CharSequence)localObject1).toString())))
    {
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Yn(((CharSequence)localObject1).toString());
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.hj(bk.UY());
      com.tencent.mm.plugin.report.service.h.nFQ.f(10873, new Object[] { Integer.valueOf(6) });
    }
    h.D((com.tencent.mm.plugin.fav.a.g)localObject2);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.fav.a.g)localObject2).CF((String)((Iterator)localObject1).next());
      }
    }
    b.B((com.tencent.mm.plugin.fav.a.g)localObject2);
    com.tencent.mm.plugin.report.service.h.nFQ.f(10648, new Object[] { Integer.valueOf(3), Integer.valueOf(0) });
    com.tencent.mm.plugin.fav.a.b.et(((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId);
    long l = ((com.tencent.mm.plugin.fav.a.g)localObject2).field_localId;
    localObject1 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(l);
    if ((localObject1 != null) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.sWf != null)) {
      com.tencent.mm.plugin.fav.a.b.a(l, ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.sWf, "", "", new ArrayList(), this.kee.mController.uMN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.9
 * JD-Core Version:    0.7.0.1
 */