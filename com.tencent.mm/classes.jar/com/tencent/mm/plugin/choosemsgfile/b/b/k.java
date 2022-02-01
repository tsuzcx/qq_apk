package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class k
  extends a<n>
{
  private String foE;
  private k.b ooK;
  public String ooU;
  private String ooX;
  private Integer ooY;
  private String ooZ;
  private String opa;
  
  public k(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bo parambo, String paramString)
  {
    super(paramg, parambo);
    this.ooU = paramString;
  }
  
  private String Tm()
  {
    AppMethodBeat.i(123290);
    Object localObject;
    if (this.opa == null)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.ooU);
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (this.opa = ((av)localObject).field_conRemark;; this.opa = "")
    {
      localObject = this.opa;
      AppMethodBeat.o(123290);
      return localObject;
    }
  }
  
  private void a(final n paramn)
  {
    AppMethodBeat.i(123292);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      b(paramn);
      AppMethodBeat.o(123292);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123282);
        k.a(k.this, paramn);
        AppMethodBeat.o(123282);
      }
    });
    AppMethodBeat.o(123292);
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(123293);
    switch (this.ooJ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123293);
      return;
      paramn.iIW.setVisibility(0);
      paramn.oph.setVisibility(8);
      paramn.fwP.setVisibility(8);
      paramn.opq.setVisibility(8);
      paramn.opo.setVisibility(8);
      AppMethodBeat.o(123293);
      return;
      paramn.iIW.setVisibility(0);
      paramn.oph.setVisibility(0);
      paramn.fwP.setVisibility(8);
      paramn.opq.setVisibility(8);
      paramn.opo.setVisibility(8);
      if (this.aoe > 0)
      {
        int i = (int)(this.MW / this.aoe * 100.0F);
        if ((i == -1) || (i >= 100))
        {
          paramn.oph.setProgress(100);
          AppMethodBeat.o(123293);
          return;
        }
        paramn.oph.setProgress(i);
        AppMethodBeat.o(123293);
        return;
        paramn.iIW.setVisibility(8);
        paramn.oph.setVisibility(8);
        paramn.fwP.setVisibility(0);
        paramn.opq.setVisibility(0);
        paramn.opo.setVisibility(8);
        AppMethodBeat.o(123293);
        return;
        paramn.iIW.setVisibility(8);
        paramn.oph.setVisibility(8);
        paramn.fwP.setVisibility(8);
        paramn.opq.setVisibility(8);
        paramn.opo.setVisibility(0);
        paramn.gAI.setText(bUI().toUpperCase() + " " + getContext().getString(2131757351));
        AppMethodBeat.o(123293);
        return;
        paramn.iIW.setVisibility(8);
        paramn.oph.setVisibility(8);
        paramn.fwP.setVisibility(8);
        paramn.opq.setVisibility(8);
        paramn.opo.setVisibility(0);
        paramn.gAI.setText(bUI().toUpperCase() + " " + getContext().getString(2131757350));
        AppMethodBeat.o(123293);
        return;
        paramn.iIW.setVisibility(8);
        paramn.oph.setVisibility(8);
        paramn.fwP.setVisibility(0);
        paramn.opq.setVisibility(0);
        paramn.fwP.setChecked(false);
        paramn.opo.setVisibility(8);
      }
    }
  }
  
  private k.b bUP()
  {
    AppMethodBeat.i(123283);
    if (this.ooK == null) {
      this.ooK = k.b.vA(this.ooz.field_content);
    }
    k.b localb = this.ooK;
    AppMethodBeat.o(123283);
    return localb;
  }
  
  private String bUR()
  {
    AppMethodBeat.i(123289);
    Object localObject;
    if (this.ooZ == null)
    {
      localObject = null;
      if (w.sQ(this.ooU)) {
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.ooU);
      }
      if (localObject == null) {
        break label75;
      }
    }
    label75:
    for (this.ooZ = ((x)localObject).wk(getUsername());; this.ooZ = "")
    {
      localObject = this.ooZ;
      AppMethodBeat.o(123289);
      return localObject;
    }
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123291);
    if ((!bUH().rG(this.ooz.field_msgId)) && (!bj()))
    {
      if (isEnable())
      {
        com.tencent.mm.plugin.choosemsgfile.b.d.c.g(getContext(), this.ooz.field_msgId);
        AppMethodBeat.o(123291);
        return;
      }
      com.tencent.mm.plugin.choosemsgfile.b.d.c.P(getContext(), bUH().mMaxCount);
    }
    AppMethodBeat.o(123291);
  }
  
  public String bUI()
  {
    AppMethodBeat.i(123285);
    if (bUP() != null)
    {
      String str = bUP().hhG;
      AppMethodBeat.o(123285);
      return str;
    }
    AppMethodBeat.o(123285);
    return "";
  }
  
  public int bUJ()
  {
    AppMethodBeat.i(123288);
    if (bUP() != null)
    {
      int i = bUP().hhF;
      AppMethodBeat.o(123288);
      return i;
    }
    AppMethodBeat.o(123288);
    return 0;
  }
  
  public int bUQ()
  {
    AppMethodBeat.i(123286);
    if (this.ooY == null) {
      this.ooY = Integer.valueOf(e.acR(bUI()));
    }
    int i = this.ooY.intValue();
    AppMethodBeat.o(123286);
    return i;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123287);
    if (bUP() != null)
    {
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.ooU);
      if (localObject != null) {
        this.ooX = ((ai)localObject).aaR();
      }
      localObject = bUP().title;
      AppMethodBeat.o(123287);
      return localObject;
    }
    AppMethodBeat.o(123287);
    return "";
  }
  
  public int getType()
  {
    return 1;
  }
  
  public String getUsername()
  {
    AppMethodBeat.i(123284);
    if (this.foE == null) {
      this.foE = com.tencent.mm.plugin.choosemsgfile.b.d.c.b(this.ooz, w.sQ(this.ooU));
    }
    String str = this.foE;
    AppMethodBeat.o(123284);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.k
 * JD-Core Version:    0.7.0.1
 */