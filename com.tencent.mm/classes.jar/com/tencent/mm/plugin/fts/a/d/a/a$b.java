package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;

public abstract class a$b
{
  public a$b(a parama) {}
  
  protected static void a(String paramString, l paraml)
  {
    ((n)g.G(n.class)).updateTopHitsRank(paramString, paraml, 0);
  }
  
  public abstract View a(Context paramContext, ViewGroup paramViewGroup);
  
  public abstract void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs);
  
  public abstract boolean a(Context paramContext, a paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */