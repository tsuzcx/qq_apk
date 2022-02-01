package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class k
  extends a<n>
{
  private String flk;
  private k.b nLK;
  public String nLU;
  private String nLX;
  private Integer nLY;
  private String nLZ;
  private String nMa;
  
  public k(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bl parambl, String paramString)
  {
    super(paramg, parambl);
    this.nLU = paramString;
  }
  
  private String St()
  {
    AppMethodBeat.i(123290);
    Object localObject;
    if (this.nMa == null)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.nLU);
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (this.nMa = ((au)localObject).field_conRemark;; this.nMa = "")
    {
      localObject = this.nMa;
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
    aq.f(new Runnable()
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
    switch (this.nLJ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123293);
      return;
      paramn.iiP.setVisibility(0);
      paramn.nMh.setVisibility(8);
      paramn.fti.setVisibility(8);
      paramn.nMq.setVisibility(8);
      paramn.nMo.setVisibility(8);
      AppMethodBeat.o(123293);
      return;
      paramn.iiP.setVisibility(0);
      paramn.nMh.setVisibility(0);
      paramn.fti.setVisibility(8);
      paramn.nMq.setVisibility(8);
      paramn.nMo.setVisibility(8);
      if (this.anj > 0)
      {
        int i = (int)(this.LZ / this.anj * 100.0F);
        if ((i == -1) || (i >= 100))
        {
          paramn.nMh.setProgress(100);
          AppMethodBeat.o(123293);
          return;
        }
        paramn.nMh.setProgress(i);
        AppMethodBeat.o(123293);
        return;
        paramn.iiP.setVisibility(8);
        paramn.nMh.setVisibility(8);
        paramn.fti.setVisibility(0);
        paramn.nMq.setVisibility(0);
        paramn.nMo.setVisibility(8);
        AppMethodBeat.o(123293);
        return;
        paramn.iiP.setVisibility(8);
        paramn.nMh.setVisibility(8);
        paramn.fti.setVisibility(8);
        paramn.nMq.setVisibility(8);
        paramn.nMo.setVisibility(0);
        paramn.lEA.setText(bNx().toUpperCase() + " " + getContext().getString(2131757351));
        AppMethodBeat.o(123293);
        return;
        paramn.iiP.setVisibility(8);
        paramn.nMh.setVisibility(8);
        paramn.fti.setVisibility(8);
        paramn.nMq.setVisibility(8);
        paramn.nMo.setVisibility(0);
        paramn.lEA.setText(bNx().toUpperCase() + " " + getContext().getString(2131757350));
        AppMethodBeat.o(123293);
        return;
        paramn.iiP.setVisibility(8);
        paramn.nMh.setVisibility(8);
        paramn.fti.setVisibility(0);
        paramn.nMq.setVisibility(0);
        paramn.fti.setChecked(false);
        paramn.nMo.setVisibility(8);
      }
    }
  }
  
  private k.b bNE()
  {
    AppMethodBeat.i(123283);
    if (this.nLK == null) {
      this.nLK = k.b.rx(this.nLz.field_content);
    }
    k.b localb = this.nLK;
    AppMethodBeat.o(123283);
    return localb;
  }
  
  private String bNG()
  {
    AppMethodBeat.i(123289);
    Object localObject;
    if (this.nLZ == null)
    {
      localObject = null;
      if (com.tencent.mm.model.w.pF(this.nLU)) {
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.nLU);
      }
      if (localObject == null) {
        break label75;
      }
    }
    label75:
    for (this.nLZ = ((com.tencent.mm.storage.w)localObject).sh(getUsername());; this.nLZ = "")
    {
      localObject = this.nLZ;
      AppMethodBeat.o(123289);
      return localObject;
    }
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123291);
    if ((!bNw().nU(this.nLz.field_msgId)) && (!bc()))
    {
      if (isEnable())
      {
        com.tencent.mm.plugin.choosemsgfile.b.d.c.g(getContext(), this.nLz.field_msgId);
        AppMethodBeat.o(123291);
        return;
      }
      com.tencent.mm.plugin.choosemsgfile.b.d.c.L(getContext(), bNw().mMaxCount);
    }
    AppMethodBeat.o(123291);
  }
  
  public int bNF()
  {
    AppMethodBeat.i(123286);
    if (this.nLY == null) {
      this.nLY = Integer.valueOf(e.Yv(bNx()));
    }
    int i = this.nLY.intValue();
    AppMethodBeat.o(123286);
    return i;
  }
  
  public String bNx()
  {
    AppMethodBeat.i(123285);
    if (bNE() != null)
    {
      String str = bNE().gHf;
      AppMethodBeat.o(123285);
      return str;
    }
    AppMethodBeat.o(123285);
    return "";
  }
  
  public int bNy()
  {
    AppMethodBeat.i(123288);
    if (bNE() != null)
    {
      int i = bNE().gHe;
      AppMethodBeat.o(123288);
      return i;
    }
    AppMethodBeat.o(123288);
    return 0;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123287);
    if (bNE() != null)
    {
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.nLU);
      if (localObject != null) {
        this.nLX = ((af)localObject).ZW();
      }
      localObject = bNE().title;
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
    if (this.flk == null) {
      this.flk = com.tencent.mm.plugin.choosemsgfile.b.d.c.b(this.nLz, com.tencent.mm.model.w.pF(this.nLU));
    }
    String str = this.flk;
    AppMethodBeat.o(123284);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.k
 * JD-Core Version:    0.7.0.1
 */