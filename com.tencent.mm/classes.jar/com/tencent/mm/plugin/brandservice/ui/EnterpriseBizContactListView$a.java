package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.z;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bwk;
import com.tencent.mm.protocal.c.bwl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import java.lang.ref.WeakReference;

final class EnterpriseBizContactListView$a
  implements com.tencent.mm.ah.f
{
  public String idB;
  com.tencent.mm.ui.widget.e idC;
  WeakReference<EnterpriseBizContactListView> idD;
  com.tencent.mm.ui.base.p tipDialog;
  
  public EnterpriseBizContactListView$a(EnterpriseBizContactListView paramEnterpriseBizContactListView)
  {
    this.idD = new WeakReference(paramEnterpriseBizContactListView);
  }
  
  protected final void finalize()
  {
    g.Dk().b(1394, this);
    super.finalize();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {}
    do
    {
      do
      {
        return;
      } while (paramm.getType() != 1394);
      paramString = ((c)paramm).bst();
      localObject = ((c)paramm).bss();
      if ((localObject == null) || (((bwl)localObject).sCU == null) || (((bwl)localObject).sCU.ret != 0))
      {
        if ((localObject != null) && (((bwl)localObject).sCU != null))
        {
          y.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(((bwl)localObject).sCU.ret) });
          return;
        }
        y.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramm.getType()) });
        return;
      }
    } while (!paramString.tMS);
    paramm = com.tencent.mm.ai.f.kX(paramString.sCO);
    paramm.field_brandFlag |= 0x1;
    Object localObject = new aww();
    ((aww)localObject).ffv = paramm.field_brandFlag;
    ((aww)localObject).hPY = paramString.sCO;
    ((j)g.r(j.class)).Fv().b(new i.a(47, (a)localObject));
    z.My().c(paramm, new String[0]);
    ((j)g.r(j.class)).FB().abu(paramm.field_username);
    if (((j)g.r(j.class)).FB().abI(paramm.field_enterpriseFather) <= 0) {
      ((j)g.r(j.class)).FB().abu(paramm.field_enterpriseFather);
    }
    for (;;)
    {
      paramString = (EnterpriseBizContactListView)this.idD.get();
      if (paramString == null) {
        break;
      }
      paramString.refresh();
      return;
      ((o)g.r(o.class)).FA().aaG(paramm.field_enterpriseFather);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a
 * JD-Core Version:    0.7.0.1
 */