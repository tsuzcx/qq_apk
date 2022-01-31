package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.sdk.platformtools.y;

public class n
  extends a
{
  public String kDH;
  private n.b kDI = new n.b(this);
  private a kDJ = new a();
  
  public n(int paramInt)
  {
    super(12, paramInt);
  }
  
  public a.b BD()
  {
    return this.kDI;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    parama = m.rF(this.kxU);
    if (parama == null) {}
    for (this.kDH = "";; this.kDH = paramContext.getResources().getString(n.g.search_contact_button_find_more, new Object[] { parama }))
    {
      y.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[] { this.kDH });
      return;
    }
  }
  
  public a.a afK()
  {
    return this.kDJ;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView gSx;
    public TextView kCv;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.n
 * JD-Core Version:    0.7.0.1
 */