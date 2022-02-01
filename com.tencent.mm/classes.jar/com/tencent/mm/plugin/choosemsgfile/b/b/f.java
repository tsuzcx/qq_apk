package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public class f
  extends d
{
  private k.b oYH;
  public String oYR;
  private String oYS;
  
  public f(g paramg, bv parambv, String paramString)
  {
    super(paramg, parambv);
    this.oYR = paramString;
  }
  
  private k.b caJ()
  {
    AppMethodBeat.i(123267);
    if (this.oYH == null) {
      this.oYH = k.b.zb(this.oYw.field_content);
    }
    k.b localb = this.oYH;
    AppMethodBeat.o(123267);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123272);
    if ((!caB().tW(this.oYw.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.oYw.field_msgId);
        AppMethodBeat.o(123272);
        return;
      }
      c.Q(getContext(), caB().mMaxCount);
    }
    AppMethodBeat.o(123272);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162327);
    super.a(paramm, paramInt, parama);
    paramm.oZf.setVisibility(0);
    paramm.oZf.setText(getFileName());
    paramm.oZg.setVisibility(0);
    paramm.oZg.setText(bu.sL(caD()));
    paramm = paramm.oZd;
    if (this.oYS == null) {
      this.oYS = c.aav(caC());
    }
    paramm.setBackgroundColor(Color.parseColor(this.oYS));
    AppMethodBeat.o(162327);
  }
  
  public String caC()
  {
    AppMethodBeat.i(123268);
    if (caJ() != null)
    {
      String str = caJ().hCD;
      AppMethodBeat.o(123268);
      return str;
    }
    AppMethodBeat.o(123268);
    return "";
  }
  
  public int caD()
  {
    AppMethodBeat.i(123270);
    if (caJ() != null)
    {
      int i = caJ().hCC;
      AppMethodBeat.o(123270);
      return i;
    }
    AppMethodBeat.o(123270);
    return 0;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123269);
    if (caJ() != null)
    {
      String str = caJ().title;
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