package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public class f
  extends d
{
  private k.b qnG;
  public String qnQ;
  private String qnR;
  
  public f(g paramg, ca paramca, String paramString)
  {
    super(paramg, paramca);
    this.qnQ = paramString;
  }
  
  private k.b cyz()
  {
    AppMethodBeat.i(123267);
    if (this.qnG == null) {
      this.qnG = k.b.HD(this.qnv.field_content);
    }
    k.b localb = this.qnG;
    AppMethodBeat.o(123267);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(123272);
    if ((!cys().Cb(this.qnv.field_msgId)) && (!isInvalid()))
    {
      if (isEnable())
      {
        c.g(getContext(), this.qnv.field_msgId);
        AppMethodBeat.o(123272);
        return;
      }
      c.V(getContext(), cys().mMaxCount);
    }
    AppMethodBeat.o(123272);
  }
  
  public final void a(m paramm, int paramInt, a parama)
  {
    AppMethodBeat.i(162327);
    super.a(paramm, paramInt, parama);
    paramm.qod.setVisibility(0);
    paramm.qod.setText(getFileName());
    paramm.qoe.setVisibility(0);
    paramm.qoe.setText(Util.getSizeKB(cyt()));
    paramm = paramm.puw;
    if (this.qnR == null) {
      this.qnR = c.akB(getFileExt());
    }
    paramm.setBackgroundColor(Color.parseColor(this.qnR));
    AppMethodBeat.o(162327);
  }
  
  public int cyt()
  {
    AppMethodBeat.i(123270);
    if (cyz() != null)
    {
      int i = cyz().iwI;
      AppMethodBeat.o(123270);
      return i;
    }
    AppMethodBeat.o(123270);
    return 0;
  }
  
  public String getFileExt()
  {
    AppMethodBeat.i(123268);
    if (cyz() != null)
    {
      String str = cyz().iwJ;
      AppMethodBeat.o(123268);
      return str;
    }
    AppMethodBeat.o(123268);
    return "";
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(123269);
    if (cyz() != null)
    {
      String str = cyz().title;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.f
 * JD-Core Version:    0.7.0.1
 */