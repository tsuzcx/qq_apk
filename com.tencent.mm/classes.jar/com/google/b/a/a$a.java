package com.google.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a$a
{
  private final String className;
  private final a dAN;
  public a dAO;
  private boolean dAP;
  
  private a$a(String paramString)
  {
    AppMethodBeat.i(208705);
    this.dAN = new a((byte)0);
    this.dAO = this.dAN;
    this.dAP = false;
    this.className = ((String)b.checkNotNull(paramString));
    AppMethodBeat.o(208705);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208711);
    boolean bool = this.dAP;
    Object localObject2 = "";
    StringBuilder localStringBuilder = new StringBuilder(32).append(this.className).append('{');
    Object localObject1 = this.dAN.dAQ;
    if (localObject1 != null)
    {
      Object localObject4 = ((a)localObject1).value;
      Object localObject3;
      if (bool)
      {
        localObject3 = localObject2;
        if (localObject4 == null) {}
      }
      else
      {
        localStringBuilder.append((String)localObject2);
        localObject3 = ", ";
        if (((a)localObject1).name != null) {
          localStringBuilder.append(((a)localObject1).name).append('=');
        }
        if ((localObject4 == null) || (!localObject4.getClass().isArray())) {
          break label153;
        }
        localObject2 = Arrays.deepToString(new Object[] { localObject4 });
        localStringBuilder.append((CharSequence)localObject2, 1, ((String)localObject2).length() - 1);
      }
      for (;;)
      {
        localObject1 = ((a)localObject1).dAQ;
        localObject2 = localObject3;
        break;
        label153:
        localStringBuilder.append(localObject4);
      }
    }
    localObject1 = '}';
    AppMethodBeat.o(208711);
    return localObject1;
  }
  
  public static final class a
  {
    public a dAQ;
    String name;
    public Object value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */