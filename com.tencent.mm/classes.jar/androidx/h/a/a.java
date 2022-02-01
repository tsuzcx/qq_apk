package androidx.h.a;

import androidx.lifecycle.ak;
import androidx.lifecycle.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a
{
  public static <T extends q,  extends ak> a l(T paramT)
  {
    return new b(paramT, ((ak)paramT).getViewModelStore());
  }
  
  public abstract void Hr();
  
  public abstract <D> androidx.h.b.b<D> a(a.a<D> parama);
  
  @Deprecated
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.h.a.a
 * JD-Core Version:    0.7.0.1
 */