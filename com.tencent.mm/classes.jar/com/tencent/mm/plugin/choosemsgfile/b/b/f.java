package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public class f
  extends d
{
  private k.b nLK;
  public String nLU;
  private String nLV;
  
  public f(g paramg, bl parambl, String paramString)
  {
    super(paramg, parambl);
    this.nLU = paramString;
  }
  
  private k.b bNE()
  {
    AppMethodBeat.i(123267);
    if (this.nLK == null) {
      this.nLK = k.b.rx(this.nLz.field_content);
    }
    k.b localb = this.nLK;
    AppMethodBeat.o(123267);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123272);
    if ((!bNw().nU(this.nLz.field_msgId)) && (!bc()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.nLz.field_msgId);
        AppMethodBeat.o(123272);
        return;
      }
      c.L(getContext(), bNw().mMaxCount);
    }
    AppMethodBeat.o(123272);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162327);
    super.a(paramm, paramInt, parama);
    paramm.nMi.setVisibility(0);
    paramm.nMi.setText(getFileName());
    paramm.nMj.setVisibility(0);
    paramm.nMj.setText(bt.mK(bNy()));
    paramm = paramm.nMg;
    if (this.nLV == null) {
      this.nLV = c.RJ(bNx());
    }
    paramm.setBackgroundColor(Color.parseColor(this.nLV));
    AppMethodBeat.o(162327);
  }
  
  public String bNx()
  {
    AppMethodBeat.i(123268);
    if (bNE() != null)
    {
      String str = bNE().gHf;
      AppMethodBeat.o(123268);
      return str;
    }
    AppMethodBeat.o(123268);
    return "";
  }
  
  public int bNy()
  {
    AppMethodBeat.i(123270);
    if (bNE() != null)
    {
      int i = bNE().gHe;
      AppMethodBeat.o(123270);
      return i;
    }
    AppMethodBeat.o(123270);
    return 0;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123269);
    if (bNE() != null)
    {
      String str = bNE().title;
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