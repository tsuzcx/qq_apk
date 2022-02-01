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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class k
  extends a<n>
{
  private String fGM;
  private k.b oSf;
  public String oSp;
  private String oSs;
  private Integer oSt;
  private String oSu;
  private String oSv;
  
  public k(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bu parambu, String paramString)
  {
    super(paramg, parambu);
    this.oSp = paramString;
  }
  
  private String VB()
  {
    AppMethodBeat.i(123290);
    Object localObject;
    if (this.oSv == null)
    {
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.oSp);
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (this.oSv = ((aw)localObject).field_conRemark;; this.oSv = "")
    {
      localObject = this.oSv;
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
    switch (this.oSe)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123293);
      return;
      paramn.jcf.setVisibility(0);
      paramn.oSC.setVisibility(8);
      paramn.fQc.setVisibility(8);
      paramn.oSL.setVisibility(8);
      paramn.oSJ.setVisibility(8);
      AppMethodBeat.o(123293);
      return;
      paramn.jcf.setVisibility(0);
      paramn.oSC.setVisibility(0);
      paramn.fQc.setVisibility(8);
      paramn.oSL.setVisibility(8);
      paramn.oSJ.setVisibility(8);
      if (this.apW > 0)
      {
        int i = (int)(this.fq / this.apW * 100.0F);
        if ((i == -1) || (i >= 100))
        {
          paramn.oSC.setProgress(100);
          AppMethodBeat.o(123293);
          return;
        }
        paramn.oSC.setProgress(i);
        AppMethodBeat.o(123293);
        return;
        paramn.jcf.setVisibility(8);
        paramn.oSC.setVisibility(8);
        paramn.fQc.setVisibility(0);
        paramn.oSL.setVisibility(0);
        paramn.oSJ.setVisibility(8);
        AppMethodBeat.o(123293);
        return;
        paramn.jcf.setVisibility(8);
        paramn.oSC.setVisibility(8);
        paramn.fQc.setVisibility(8);
        paramn.oSL.setVisibility(8);
        paramn.oSJ.setVisibility(0);
        paramn.gUs.setText(bZn().toUpperCase() + " " + getContext().getString(2131757351));
        AppMethodBeat.o(123293);
        return;
        paramn.jcf.setVisibility(8);
        paramn.oSC.setVisibility(8);
        paramn.fQc.setVisibility(8);
        paramn.oSL.setVisibility(8);
        paramn.oSJ.setVisibility(0);
        paramn.gUs.setText(bZn().toUpperCase() + " " + getContext().getString(2131757350));
        AppMethodBeat.o(123293);
        return;
        paramn.jcf.setVisibility(8);
        paramn.oSC.setVisibility(8);
        paramn.fQc.setVisibility(0);
        paramn.oSL.setVisibility(0);
        paramn.fQc.setChecked(false);
        paramn.oSJ.setVisibility(8);
      }
    }
  }
  
  private k.b bZu()
  {
    AppMethodBeat.i(123283);
    if (this.oSf == null) {
      this.oSf = k.b.yr(this.oRU.field_content);
    }
    k.b localb = this.oSf;
    AppMethodBeat.o(123283);
    return localb;
  }
  
  private String bZw()
  {
    AppMethodBeat.i(123289);
    Object localObject;
    if (this.oSu == null)
    {
      localObject = null;
      if (w.vF(this.oSp)) {
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.oSp);
      }
      if (localObject == null) {
        break label75;
      }
    }
    label75:
    for (this.oSu = ((ab)localObject).zf(getUsername());; this.oSu = "")
    {
      localObject = this.oSu;
      AppMethodBeat.o(123289);
      return localObject;
    }
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123291);
    if ((!bZm().tF(this.oRU.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        com.tencent.mm.plugin.choosemsgfile.b.d.c.g(getContext(), this.oRU.field_msgId);
        AppMethodBeat.o(123291);
        return;
      }
      com.tencent.mm.plugin.choosemsgfile.b.d.c.Q(getContext(), bZm().mMaxCount);
    }
    AppMethodBeat.o(123291);
  }
  
  public String bZn()
  {
    AppMethodBeat.i(123285);
    if (bZu() != null)
    {
      String str = bZu().hzP;
      AppMethodBeat.o(123285);
      return str;
    }
    AppMethodBeat.o(123285);
    return "";
  }
  
  public int bZo()
  {
    AppMethodBeat.i(123288);
    if (bZu() != null)
    {
      int i = bZu().hzO;
      AppMethodBeat.o(123288);
      return i;
    }
    AppMethodBeat.o(123288);
    return 0;
  }
  
  public int bZv()
  {
    AppMethodBeat.i(123286);
    if (this.oSt == null) {
      this.oSt = Integer.valueOf(e.agG(bZn()));
    }
    int i = this.oSt.intValue();
    AppMethodBeat.o(123286);
    return i;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123287);
    if (bZu() != null)
    {
      Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.oSp);
      if (localObject != null) {
        this.oSs = ((am)localObject).adu();
      }
      localObject = bZu().title;
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
    if (this.fGM == null) {
      this.fGM = com.tencent.mm.plugin.choosemsgfile.b.d.c.b(this.oRU, w.vF(this.oSp));
    }
    String str = this.fGM;
    AppMethodBeat.o(123284);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.k
 * JD-Core Version:    0.7.0.1
 */