package androidx.camera.core.impl;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class aq<T>
{
  final x<a<T>> MP;
  private final Map<Object<? super T>, Object<T>> MQ;
  
  public aq()
  {
    AppMethodBeat.i(198633);
    this.MP = new x();
    this.MQ = new HashMap();
    AppMethodBeat.o(198633);
  }
  
  public final void t(T paramT)
  {
    AppMethodBeat.i(198637);
    this.MP.t(a.u(paramT));
    AppMethodBeat.o(198637);
  }
  
  public static final class a<T>
  {
    private final Throwable MR;
    private final T mValue;
    
    private a(T paramT)
    {
      this.mValue = paramT;
      this.MR = null;
    }
    
    static <T> a<T> u(T paramT)
    {
      AppMethodBeat.i(198935);
      paramT = new a(paramT);
      AppMethodBeat.o(198935);
      return paramT;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198938);
      StringBuilder localStringBuilder = new StringBuilder("[Result: <");
      int i;
      if (this.MR == null)
      {
        i = 1;
        if (i == 0) {
          break label74;
        }
      }
      label74:
      for (String str = "Value: " + this.mValue;; str = "Error: " + this.MR)
      {
        str = str + ">]";
        AppMethodBeat.o(198938);
        return str;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.camera.core.impl.aq
 * JD-Core Version:    0.7.0.1
 */