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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.al;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class k
  extends a<n>
{
  private String fIQ;
  private k.b oYH;
  public String oYR;
  private String oYU;
  private Integer oYV;
  private String oYW;
  private String oYX;
  
  public k(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bv parambv, String paramString)
  {
    super(paramg, parambv);
    this.oYR = paramString;
  }
  
  private String VJ()
  {
    AppMethodBeat.i(123290);
    Object localObject;
    if (this.oYX == null)
    {
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.oYR);
      if (localObject == null) {
        break label59;
      }
    }
    label59:
    for (this.oYX = ((aw)localObject).field_conRemark;; this.oYX = "")
    {
      localObject = this.oYX;
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
    ar.f(new Runnable()
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
    switch (this.oYG)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123293);
      return;
      paramn.jeY.setVisibility(0);
      paramn.oZe.setVisibility(8);
      paramn.fSi.setVisibility(8);
      paramn.oZn.setVisibility(8);
      paramn.oZl.setVisibility(8);
      AppMethodBeat.o(123293);
      return;
      paramn.jeY.setVisibility(0);
      paramn.oZe.setVisibility(0);
      paramn.fSi.setVisibility(8);
      paramn.oZn.setVisibility(8);
      paramn.oZl.setVisibility(8);
      if (this.apW > 0)
      {
        int i = (int)(this.fq / this.apW * 100.0F);
        if ((i == -1) || (i >= 100))
        {
          paramn.oZe.setProgress(100);
          AppMethodBeat.o(123293);
          return;
        }
        paramn.oZe.setProgress(i);
        AppMethodBeat.o(123293);
        return;
        paramn.jeY.setVisibility(8);
        paramn.oZe.setVisibility(8);
        paramn.fSi.setVisibility(0);
        paramn.oZn.setVisibility(0);
        paramn.oZl.setVisibility(8);
        AppMethodBeat.o(123293);
        return;
        paramn.jeY.setVisibility(8);
        paramn.oZe.setVisibility(8);
        paramn.fSi.setVisibility(8);
        paramn.oZn.setVisibility(8);
        paramn.oZl.setVisibility(0);
        paramn.gXb.setText(caC().toUpperCase() + " " + getContext().getString(2131757351));
        AppMethodBeat.o(123293);
        return;
        paramn.jeY.setVisibility(8);
        paramn.oZe.setVisibility(8);
        paramn.fSi.setVisibility(8);
        paramn.oZn.setVisibility(8);
        paramn.oZl.setVisibility(0);
        paramn.gXb.setText(caC().toUpperCase() + " " + getContext().getString(2131757350));
        AppMethodBeat.o(123293);
        return;
        paramn.jeY.setVisibility(8);
        paramn.oZe.setVisibility(8);
        paramn.fSi.setVisibility(0);
        paramn.oZn.setVisibility(0);
        paramn.fSi.setChecked(false);
        paramn.oZl.setVisibility(8);
      }
    }
  }
  
  private k.b caJ()
  {
    AppMethodBeat.i(123283);
    if (this.oYH == null) {
      this.oYH = k.b.zb(this.oYw.field_content);
    }
    k.b localb = this.oYH;
    AppMethodBeat.o(123283);
    return localb;
  }
  
  private String caL()
  {
    AppMethodBeat.i(123289);
    Object localObject;
    if (this.oYW == null)
    {
      localObject = null;
      if (x.wb(this.oYR)) {
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.oYR);
      }
      if (localObject == null) {
        break label75;
      }
    }
    label75:
    for (this.oYW = ((ac)localObject).zP(getUsername());; this.oYW = "")
    {
      localObject = this.oYW;
      AppMethodBeat.o(123289);
      return localObject;
    }
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123291);
    if ((!caB().tW(this.oYw.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        com.tencent.mm.plugin.choosemsgfile.b.d.c.g(getContext(), this.oYw.field_msgId);
        AppMethodBeat.o(123291);
        return;
      }
      com.tencent.mm.plugin.choosemsgfile.b.d.c.Q(getContext(), caB().mMaxCount);
    }
    AppMethodBeat.o(123291);
  }
  
  public String caC()
  {
    AppMethodBeat.i(123285);
    if (caJ() != null)
    {
      String str = caJ().hCD;
      AppMethodBeat.o(123285);
      return str;
    }
    AppMethodBeat.o(123285);
    return "";
  }
  
  public int caD()
  {
    AppMethodBeat.i(123288);
    if (caJ() != null)
    {
      int i = caJ().hCC;
      AppMethodBeat.o(123288);
      return i;
    }
    AppMethodBeat.o(123288);
    return 0;
  }
  
  public int caK()
  {
    AppMethodBeat.i(123286);
    if (this.oYV == null) {
      this.oYV = Integer.valueOf(e.ahD(caC()));
    }
    int i = this.oYV.intValue();
    AppMethodBeat.o(123286);
    return i;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123287);
    if (caJ() != null)
    {
      Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.oYR);
      if (localObject != null) {
        this.oYU = ((an)localObject).adF();
      }
      localObject = caJ().title;
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
    if (this.fIQ == null) {
      this.fIQ = com.tencent.mm.plugin.choosemsgfile.b.d.c.b(this.oYw, x.wb(this.oYR));
    }
    String str = this.fIQ;
    AppMethodBeat.o(123284);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.k
 * JD-Core Version:    0.7.0.1
 */