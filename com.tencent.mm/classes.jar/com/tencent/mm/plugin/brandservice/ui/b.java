package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class b
  extends a
{
  private static a.b jTh;
  CharSequence gpH;
  protected String iconUrl;
  protected CharSequence jSW;
  protected boolean jSZ;
  protected boolean jTa;
  protected String jTi;
  protected String username;
  
  public b(Object paramObject, String paramString)
  {
    super(6, paramObject);
    this.jTi = paramString;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(13874);
    if (this.zsv)
    {
      AppMethodBeat.o(13874);
      return;
    }
    if ((paramContext == null) || (parama == null) || (this.data == null))
    {
      ab.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(13874);
      return;
    }
    if (!(parama instanceof b.a))
    {
      ab.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
      AppMethodBeat.o(13874);
      return;
    }
    if (!(this.data instanceof bxz))
    {
      ab.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
      AppMethodBeat.o(13874);
      return;
    }
    b.a locala = (b.a)parama;
    paramVarArgs = (bxz)this.data;
    if (paramVarArgs.xmi != null) {
      parama = paramVarArgs.xmi.toString();
    }
    try
    {
      for (;;)
      {
        this.gpH = j.b(paramContext, parama, locala.egr.getTextSize());
        this.iconUrl = paramVarArgs.wJr;
        this.username = paramVarArgs.wOT.toString();
        AppMethodBeat.o(13874);
        return;
        parama = "";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        this.gpH = "";
      }
    }
  }
  
  public final a.b aWu()
  {
    AppMethodBeat.i(13872);
    if (jTh == null) {
      jTh = new b.1(this);
    }
    a.b localb = jTh;
    AppMethodBeat.o(13872);
    return localb;
  }
  
  public final a.a aWv()
  {
    AppMethodBeat.i(13873);
    b.a locala = new b.a();
    AppMethodBeat.o(13873);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b
 * JD-Core Version:    0.7.0.1
 */