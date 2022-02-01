package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public class f
  extends d
{
  private k.b ooK;
  public String ooU;
  private String ooV;
  
  public f(g paramg, bo parambo, String paramString)
  {
    super(paramg, parambo);
    this.ooU = paramString;
  }
  
  private k.b bUP()
  {
    AppMethodBeat.i(123267);
    if (this.ooK == null) {
      this.ooK = k.b.vA(this.ooz.field_content);
    }
    k.b localb = this.ooK;
    AppMethodBeat.o(123267);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123272);
    if ((!bUH().rG(this.ooz.field_msgId)) && (!bj()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.ooz.field_msgId);
        AppMethodBeat.o(123272);
        return;
      }
      c.P(getContext(), bUH().mMaxCount);
    }
    AppMethodBeat.o(123272);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162327);
    super.a(paramm, paramInt, parama);
    paramm.opi.setVisibility(0);
    paramm.opi.setText(getFileName());
    paramm.opj.setVisibility(0);
    paramm.opj.setText(bs.qz(bUJ()));
    paramm = paramm.opg;
    if (this.ooV == null) {
      this.ooV = c.VV(bUI());
    }
    paramm.setBackgroundColor(Color.parseColor(this.ooV));
    AppMethodBeat.o(162327);
  }
  
  public String bUI()
  {
    AppMethodBeat.i(123268);
    if (bUP() != null)
    {
      String str = bUP().hhG;
      AppMethodBeat.o(123268);
      return str;
    }
    AppMethodBeat.o(123268);
    return "";
  }
  
  public int bUJ()
  {
    AppMethodBeat.i(123270);
    if (bUP() != null)
    {
      int i = bUP().hhF;
      AppMethodBeat.o(123270);
      return i;
    }
    AppMethodBeat.o(123270);
    return 0;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123269);
    if (bUP() != null)
    {
      String str = bUP().title;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.f
 * JD-Core Version:    0.7.0.1
 */