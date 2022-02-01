package androidx.fragment.app;

import android.content.Context;
import android.view.View;

public abstract class d
{
  @Deprecated
  public static Fragment i(Context paramContext, String paramString)
  {
    return Fragment.instantiate(paramContext, paramString, null);
  }
  
  public abstract View onFindViewById(int paramInt);
  
  public abstract boolean onHasView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.d
 * JD-Core Version:    0.7.0.1
 */