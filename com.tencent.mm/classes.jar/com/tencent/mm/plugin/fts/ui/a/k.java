package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class k
  extends a
{
  private b BPn;
  private a BPo;
  public String header;
  
  public k(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(112091);
    this.BPn = new b();
    this.BPo = new a();
    AppMethodBeat.o(112091);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112092);
    this.header = Util.nullAs(n.SI(this.uMD), "");
    Log.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[] { this.header });
    AppMethodBeat.o(112092);
  }
  
  public a.b aEw()
  {
    return this.BPn;
  }
  
  public a.a erV()
  {
    return this.BPo;
  }
  
  public final class a
    extends a.a
  {
    public View BOI;
    public View contentView;
    public TextView tOY;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112089);
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_header_item, paramViewGroup, false);
      paramViewGroup = (k.a)k.this.erV();
      paramViewGroup.tOY = ((TextView)paramContext.findViewById(o.d.header_tv));
      paramViewGroup.BOI = paramContext.findViewById(o.d.padding_view);
      paramViewGroup.contentView = paramContext.findViewById(o.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112089);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112090);
      paramContext = (k.a)parama;
      n.a(k.this.header, paramContext.tOY);
      if (k.this.position == 0) {
        paramContext.BOI.setVisibility(8);
      }
      for (;;)
      {
        n.s(paramContext.contentView, k.this.BJG);
        AppMethodBeat.o(112090);
        return;
        paramContext.BOI.setVisibility(0);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.k
 * JD-Core Version:    0.7.0.1
 */