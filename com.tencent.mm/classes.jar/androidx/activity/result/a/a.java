package androidx.activity.result.a;

import android.content.Context;
import android.content.Intent;

public abstract class a<I, O>
{
  public a<O> a(Context paramContext, I paramI)
  {
    return null;
  }
  
  public abstract O a(int paramInt, Intent paramIntent);
  
  public abstract Intent n(I paramI);
  
  public static final class a<T>
  {
    public final T mValue;
    
    public a(T paramT)
    {
      this.mValue = paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.result.a.a
 * JD-Core Version:    0.7.0.1
 */