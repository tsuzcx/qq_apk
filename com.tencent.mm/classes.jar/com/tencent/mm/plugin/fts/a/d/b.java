package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import java.util.ArrayList;
import java.util.List;

public abstract class b
  implements e
{
  protected Context context;
  protected int kme;
  public e.b rqr;
  
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    this.context = paramContext;
    this.rqr = paramb;
    this.kme = paramInt;
  }
  
  protected static boolean dF(List<? extends Object> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  protected static <T> List<T> dG(List<T> paramList)
  {
    Object localObject = paramList;
    if (dF(paramList))
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
  
  public int cxq()
  {
    return 0;
  }
  
  public List<c> qR(long paramLong)
  {
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.b
 * JD-Core Version:    0.7.0.1
 */