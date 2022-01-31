package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.b.a.a;
import android.support.v4.b.a.b;
import android.view.Menu;
import android.view.MenuItem;

public final class q
{
  public static Menu a(Context paramContext, a parama)
  {
    return new r(paramContext, parama);
  }
  
  public static MenuItem a(Context paramContext, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new l(paramContext, paramb);
    }
    return new k(paramContext, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.q
 * JD-Core Version:    0.7.0.1
 */