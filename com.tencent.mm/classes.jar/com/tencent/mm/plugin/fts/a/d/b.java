package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.fts.a.d.a.a;
import java.util.List;

public abstract class b
  implements e
{
  public Context context;
  public e.b kxI;
  public int kxJ;
  
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    this.context = paramContext;
    this.kxI = paramb;
    this.kxJ = paramInt;
  }
  
  public static boolean bA(List<? extends Object> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  public boolean a(View paramView, a parama, boolean paramBoolean)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.d.b
 * JD-Core Version:    0.7.0.1
 */