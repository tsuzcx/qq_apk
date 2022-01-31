package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.be;
import java.lang.ref.WeakReference;

final class EnterpriseBizContactListView$a
  implements com.tencent.mm.ai.f
{
  public String jUp;
  com.tencent.mm.ui.widget.f jUq;
  WeakReference<EnterpriseBizContactListView> jUr;
  com.tencent.mm.ui.base.p tipDialog;
  
  public EnterpriseBizContactListView$a(EnterpriseBizContactListView paramEnterpriseBizContactListView)
  {
    AppMethodBeat.i(13962);
    this.jUr = new WeakReference(paramEnterpriseBizContactListView);
    AppMethodBeat.o(13962);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(13963);
    g.Rc().b(1394, this);
    super.finalize();
    AppMethodBeat.o(13963);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(13964);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(13964);
      return;
    }
    if (paramm.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramm).cbP();
      Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramm).cbO();
      if ((localObject == null) || (((cit)localObject).wyn == null) || (((cit)localObject).wyn.ret != 0))
      {
        if ((localObject != null) && (((cit)localObject).wyn != null))
        {
          ab.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(((cit)localObject).wyn.ret) });
          AppMethodBeat.o(13964);
          return;
        }
        ab.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramm.getType()) });
        AppMethodBeat.o(13964);
        return;
      }
      if (!paramString.xTc)
      {
        AppMethodBeat.o(13964);
        return;
      }
      paramm = com.tencent.mm.aj.f.rS(paramString.wyh);
      paramm.field_brandFlag |= 0x1;
      localObject = new bdm();
      ((bdm)localObject).gxd = paramm.field_brandFlag;
      ((bdm)localObject).jJA = paramString.wyh;
      ((j)g.E(j.class)).Yz().c(new j.a(47, (a)localObject));
      z.afi().update(paramm, new String[0]);
      ((j)g.E(j.class)).YF().arF(paramm.field_username);
      if (((j)g.E(j.class)).YF().arS(paramm.field_enterpriseFather) <= 0) {
        ((j)g.E(j.class)).YF().arF(paramm.field_enterpriseFather);
      }
      for (;;)
      {
        paramString = (EnterpriseBizContactListView)this.jUr.get();
        if (paramString != null) {
          break;
        }
        AppMethodBeat.o(13964);
        return;
        ((o)g.E(o.class)).YE().aqR(paramm.field_enterpriseFather);
      }
      paramString.refresh();
    }
    AppMethodBeat.o(13964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a
 * JD-Core Version:    0.7.0.1
 */