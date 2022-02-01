package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public class f
  extends d
{
  private k.b tMt;
  public String tMy;
  private String tMz;
  
  public f(g paramg, ca paramca, String paramString)
  {
    super(paramg, paramca);
    this.tMy = paramString;
  }
  
  private k.b cMU()
  {
    AppMethodBeat.i(123267);
    if (this.tMt == null) {
      this.tMt = k.b.OQ(this.tMi.field_content);
    }
    k.b localb = this.tMt;
    AppMethodBeat.o(123267);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123272);
    if ((!cMN().Ik(this.tMi.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.tMi.field_msgId);
        AppMethodBeat.o(123272);
        return;
      }
      c.aa(getContext(), cMN().mMaxCount);
    }
    AppMethodBeat.o(123272);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162327);
    super.a(paramm, paramInt, parama);
    paramm.tML.setVisibility(0);
    paramm.tML.setText(getFileName());
    paramm.tMM.setVisibility(0);
    paramm.tMM.setText(Util.getSizeKB(cMO()));
    paramm = paramm.sDJ;
    if (this.tMz == null) {
      this.tMz = c.asp(getFileExt());
    }
    paramm.setBackgroundColor(Color.parseColor(this.tMz));
    AppMethodBeat.o(162327);
  }
  
  public int cMO()
  {
    AppMethodBeat.i(123270);
    if (cMU() != null)
    {
      int i = cMU().llX;
      AppMethodBeat.o(123270);
      return i;
    }
    AppMethodBeat.o(123270);
    return 0;
  }
  
  public String getFileExt()
  {
    AppMethodBeat.i(123268);
    if (cMU() != null)
    {
      String str = cMU().llY;
      AppMethodBeat.o(123268);
      return str;
    }
    AppMethodBeat.o(123268);
    return "";
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123269);
    if (cMU() != null)
    {
      String str = cMU().title;
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