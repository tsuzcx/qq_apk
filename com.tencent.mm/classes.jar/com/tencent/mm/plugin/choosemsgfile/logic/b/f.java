package com.tencent.mm.plugin.choosemsgfile.logic.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.choosemsgfile.logic.c.c;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public class f
  extends d
{
  private k.b wPJ;
  public String wPO;
  private String wPP;
  
  public f(g paramg, cc paramcc, String paramString)
  {
    super(paramg, paramcc);
    this.wPO = paramString;
  }
  
  private k.b dqz()
  {
    AppMethodBeat.i(123267);
    if (this.wPJ == null) {
      this.wPJ = k.b.Hf(this.wPy.field_content);
    }
    k.b localb = this.wPJ;
    AppMethodBeat.o(123267);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123272);
    if ((!dqs().kC(this.wPy.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.wPy.field_msgId);
        AppMethodBeat.o(123272);
        return;
      }
      c.ah(getContext(), dqs().sfk);
    }
    AppMethodBeat.o(123272);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162327);
    super.a(paramm, paramInt, parama);
    paramm.wQb.setVisibility(0);
    paramm.wQb.setText(getFileName());
    paramm.wQc.setVisibility(0);
    paramm.wQc.setText(Util.getSizeKB(dqt()));
    paramm = paramm.coverIv;
    if (this.wPP == null) {
      this.wPP = c.alU(getFileExt());
    }
    paramm.setBackgroundColor(Color.parseColor(this.wPP));
    AppMethodBeat.o(162327);
  }
  
  public int dqt()
  {
    AppMethodBeat.i(123270);
    if (dqz() != null)
    {
      int i = dqz().nRd;
      AppMethodBeat.o(123270);
      return i;
    }
    AppMethodBeat.o(123270);
    return 0;
  }
  
  public String getFileExt()
  {
    AppMethodBeat.i(123268);
    if (dqz() != null)
    {
      String str = dqz().nRe;
      AppMethodBeat.o(123268);
      return str;
    }
    AppMethodBeat.o(123268);
    return "";
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123269);
    if (dqz() != null)
    {
      String str = dqz().title;
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
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.f
 * JD-Core Version:    0.7.0.1
 */