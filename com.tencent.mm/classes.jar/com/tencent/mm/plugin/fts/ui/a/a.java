package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n.g;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence kCs;
  private a.b kCt = new a.b(this);
  private a kCu = new a();
  
  public a(int paramInt)
  {
    super(10, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b BD()
  {
    return this.kCt;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    this.kCs = f.a(paramContext.getResources().getString(n.g.fts_find_comm_tip_prefix), "", d.b(this.kwi.kwG, this.kwi.kwG)).kwz;
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a.a afK()
  {
    return this.kCu;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.a
 * JD-Core Version:    0.7.0.1
 */