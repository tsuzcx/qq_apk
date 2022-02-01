package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public class f
  extends d
{
  private k.b oSf;
  public String oSp;
  private String oSq;
  
  public f(g paramg, bu parambu, String paramString)
  {
    super(paramg, parambu);
    this.oSp = paramString;
  }
  
  private k.b bZu()
  {
    AppMethodBeat.i(123267);
    if (this.oSf == null) {
      this.oSf = k.b.yr(this.oRU.field_content);
    }
    k.b localb = this.oSf;
    AppMethodBeat.o(123267);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123272);
    if ((!bZm().tF(this.oRU.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.oRU.field_msgId);
        AppMethodBeat.o(123272);
        return;
      }
      c.Q(getContext(), bZm().mMaxCount);
    }
    AppMethodBeat.o(123272);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162327);
    super.a(paramm, paramInt, parama);
    paramm.oSD.setVisibility(0);
    paramm.oSD.setText(getFileName());
    paramm.oSE.setVisibility(0);
    paramm.oSE.setText(bt.sy(bZo()));
    paramm = paramm.oSB;
    if (this.oSq == null) {
      this.oSq = c.ZE(bZn());
    }
    paramm.setBackgroundColor(Color.parseColor(this.oSq));
    AppMethodBeat.o(162327);
  }
  
  public String bZn()
  {
    AppMethodBeat.i(123268);
    if (bZu() != null)
    {
      String str = bZu().hzP;
      AppMethodBeat.o(123268);
      return str;
    }
    AppMethodBeat.o(123268);
    return "";
  }
  
  public int bZo()
  {
    AppMethodBeat.i(123270);
    if (bZu() != null)
    {
      int i = bZu().hzO;
      AppMethodBeat.o(123270);
      return i;
    }
    AppMethodBeat.o(123270);
    return 0;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123269);
    if (bZu() != null)
    {
      String str = bZu().title;
      AppMethodBeat.o(123269);
      return str;
    }
    AppMethodBeat.o(123269);
    return "";
  }
  
  public int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.f
 * JD-Core Version:    0.7.0.1
 */