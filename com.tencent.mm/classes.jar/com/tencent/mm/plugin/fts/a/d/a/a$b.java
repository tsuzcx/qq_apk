package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;

public abstract class a$b
{
  public a$b(a parama) {}
  
  protected static void a(String paramString, m paramm)
  {
    ((n)g.ad(n.class)).updateTopHitsRank(paramString, paramm, 0);
  }
  
  public abstract View a(Context paramContext, ViewGroup paramViewGroup);
  
  public abstract void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs);
  
  public abstract boolean a(Context paramContext, a paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */