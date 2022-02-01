package androidx.g.a;

import android.os.Bundle;
import androidx.lifecycle.ab;
import androidx.lifecycle.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a
{
  public static <T extends l,  extends ab> a e(T paramT)
  {
    return new b(paramT, ((ab)paramT).getViewModelStore());
  }
  
  public abstract <D> androidx.g.b.b<D> a(a<D> parama);
  
  @Deprecated
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract void jn();
  
  public static abstract interface a<D>
  {
    public abstract androidx.g.b.b<D> onCreateLoader(int paramInt, Bundle paramBundle);
    
    public abstract void onLoadFinished(androidx.g.b.b<D> paramb, D paramD);
    
    public abstract void onLoaderReset(androidx.g.b.b<D> paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.g.a.a
 * JD-Core Version:    0.7.0.1
 */