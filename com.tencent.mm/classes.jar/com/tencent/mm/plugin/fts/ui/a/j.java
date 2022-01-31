package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.f;

public final class j
  extends a
{
  public int actionType = -1;
  public l fYx;
  public CharSequence kDo;
  public String kDp;
  public c kDq;
  private b kDr = new b();
  j.a kDs = new j.a(this);
  public CharSequence kgQ;
  public String kgT;
  
  public j(int paramInt)
  {
    super(3, paramInt);
  }
  
  public final a.b BD()
  {
    return this.kDr;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    this.kDq = ((c)this.fYx.userData);
    if (this.kDq == null) {
      return;
    }
    this.kgQ = this.kDq.field_title;
    this.kDo = this.kDq.field_tag;
    this.kgT = this.kDq.field_iconPath;
    this.kDp = this.kDq.field_androidUrl;
    this.actionType = this.kDq.field_actionType;
    boolean bool1;
    switch (this.fYx.kwf)
    {
    default: 
      return;
    case 1: 
      bool2 = false;
      bool1 = false;
    }
    for (;;)
    {
      this.kgQ = f.a(d.a(this.kgQ, this.kwi, bool2, bool1)).kwz;
      return;
      bool1 = true;
      continue;
      this.kDo = f.a(d.a(this.kDo, this.kwi)).kwz;
      return;
      bool1 = false;
    }
  }
  
  protected final a.a afK()
  {
    return this.kDs;
  }
  
  public final String afL()
  {
    return this.kDq.field_title;
  }
  
  public final int afM()
  {
    return this.fYx.kxt;
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
      paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_contact_item, paramViewGroup, false);
      paramViewGroup = (j.a)j.this.kDs;
      paramViewGroup.doU = ((ImageView)paramContext.findViewById(n.d.avatar_iv));
      paramViewGroup.eXO = ((TextView)paramContext.findViewById(n.d.title_tv));
      paramViewGroup.eXP = ((TextView)paramContext.findViewById(n.d.desc_tv));
      paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      parama = (j.a)parama;
      parama1 = (j)parama1;
      m.k(parama.contentView, j.this.kxT);
      m.a(j.this.kgQ, parama.eXO);
      m.a(j.this.kDo, parama.eXP);
      m.a(paramContext, parama.doU, null, parama1.kgT, n.f.fts_default_img);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return ((n)g.t(n.class)).getItemClickHandler(j.this.ivk).a(paramContext, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j
 * JD-Core Version:    0.7.0.1
 */