package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.Html;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.dbe;
import org.json.JSONObject;

public final class s
  extends a
{
  CharSequence gpH;
  public boolean mCu;
  public dbe mZR;
  public String mZS;
  public long mZT;
  CharSequence mZU;
  CharSequence mZV;
  private s.b mZW;
  s.a mZX;
  String thumbUrl;
  
  public s(int paramInt)
  {
    super(21, paramInt);
    AppMethodBeat.i(152160);
    this.mZW = new s.b(this);
    this.mZX = new s.a(this);
    AppMethodBeat.o(152160);
  }
  
  public final a.b Pr()
  {
    return this.mZW;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(152161);
    super.a(paramContext, parama, paramVarArgs);
    try
    {
      paramContext = new JSONObject(this.mZR.yhp);
      parama = paramContext.optString("title", "");
      this.thumbUrl = paramContext.optString("image", "");
      this.mZS = paramContext.optString("search_buffer", "");
      this.mZU = Html.fromHtml(parama.replaceAll("<em class=\"highlight\">", "<font color=\"#06AD56\">").replaceAll("</em>", "</font>"));
      if (paramContext.optString("content_type", "").equals("VIDEO")) {
        this.mCu = true;
      }
      label103:
      this.mZV = Html.fromHtml(this.mZR.woO.replaceAll("<em class=\"highlight\">", "<font color=\"#06AD56\">").replaceAll("</em>", "</font>"));
      this.gpH = this.mZR.jKG;
      this.mZT = System.currentTimeMillis();
      paramContext = new buq();
      paramContext.fKw = this.mZR.fKw;
      paramContext.Scene = 25;
      paramContext.xIh = e.mRl;
      paramContext.xIm = e.mRk;
      paramContext.xCj = this.mZT;
      paramContext.xIl = this.position;
      paramContext.xpv = 0;
      paramContext.xIi = this.mZS;
      paramContext.xIj = 1;
      paramContext = new d(paramContext);
      g.Rc().a(paramContext, 0);
      AppMethodBeat.o(152161);
      return;
    }
    catch (Exception paramContext)
    {
      break label103;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.s
 * JD-Core Version:    0.7.0.1
 */