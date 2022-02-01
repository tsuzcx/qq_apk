package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.fts.a.d.a.a;
import java.util.ArrayList;
import java.util.List;

public abstract class b
  implements e
{
  private e.b Hui;
  private Context context;
  private int syO;
  
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    this.context = paramContext;
    this.Hui = paramb;
    this.syO = paramInt;
  }
  
  protected static boolean hS(List<? extends Object> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  protected static <T> List<T> hT(List<T> paramList)
  {
    Object localObject = paramList;
    if (hS(paramList))
    {
      localObject = paramList;
      if (paramList.size() > 3) {
        localObject = paramList.subList(0, 3);
      }
    }
    return localObject;
  }
  
  public boolean a(View paramView, a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final e.b fxE()
  {
    return this.Hui;
  }
  
  protected final int fxF()
  {
    return this.syO;
  }
  
  protected final Context getContext()
  {
    return this.context;
  }
  
  public List<com.tencent.mm.plugin.fts.a.a.e> rs(long paramLong)
  {
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.b
 * JD-Core Version:    0.7.0.1
 */