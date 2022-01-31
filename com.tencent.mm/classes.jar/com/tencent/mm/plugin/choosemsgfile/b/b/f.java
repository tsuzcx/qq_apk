package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public class f
  extends d
{
  private j.b kEK;
  public String kET;
  private String kEU;
  
  public f(g paramg, bi parambi, String paramString)
  {
    super(paramg, parambi);
    this.kET = paramString;
  }
  
  private j.b bgt()
  {
    AppMethodBeat.i(54295);
    if (this.kEK == null) {
      this.kEK = j.b.mY(this.kEz.field_content);
    }
    j.b localb = this.kEK;
    AppMethodBeat.o(54295);
    return localb;
  }
  
  public void a(View paramView, a parama)
  {
    AppMethodBeat.i(54300);
    if ((!bgl().im(this.kEz.field_msgId)) && (!jU()))
    {
      if (isEnable())
      {
        b.f(getContext(), this.kEz.field_msgId);
        AppMethodBeat.o(54300);
        return;
      }
      b.J(getContext(), bgl().mMaxCount);
    }
    AppMethodBeat.o(54300);
  }
  
  public final void a(m paramm, int paramInt)
  {
    AppMethodBeat.i(54299);
    super.a(paramm, paramInt);
    paramm.kFg.setVisibility(0);
    paramm.kFg.setText(getFileName());
    paramm.kFh.setVisibility(0);
    paramm.kFh.setText(bo.hk(bgn()));
    paramm = paramm.kha;
    if (this.kEU == null) {
      this.kEU = b.IZ(bgm());
    }
    paramm.setBackgroundColor(Color.parseColor(this.kEU));
    AppMethodBeat.o(54299);
  }
  
  public String bgm()
  {
    AppMethodBeat.i(54296);
    if (bgt() != null)
    {
      String str = bgt().fgx;
      AppMethodBeat.o(54296);
      return str;
    }
    AppMethodBeat.o(54296);
    return "";
  }
  
  public int bgn()
  {
    AppMethodBeat.i(54298);
    if (bgt() != null)
    {
      int i = bgt().fgw;
      AppMethodBeat.o(54298);
      return i;
    }
    AppMethodBeat.o(54298);
    return 0;
  }
  
  public String getFileName()
  {
    AppMethodBeat.i(54297);
    if (bgt() != null)
    {
      String str = bgt().title;
      AppMethodBeat.o(54297);
      return str;
    }
    AppMethodBeat.o(54297);
    return "";
  }
  
  public int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.f
 * JD-Core Version:    0.7.0.1
 */