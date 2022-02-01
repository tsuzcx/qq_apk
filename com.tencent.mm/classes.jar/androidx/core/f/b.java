package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(196007);
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
      AppMethodBeat.o(196007);
      return;
    }
    String str2 = paramObject.getClass().getSimpleName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 0) {}
    }
    else
    {
      str2 = paramObject.getClass().getName();
      int i = str2.lastIndexOf('.');
      str1 = str2;
      if (i > 0) {
        str1 = str2.substring(i + 1);
      }
    }
    paramStringBuilder.append(str1);
    paramStringBuilder.append('{');
    paramStringBuilder.append(Integer.toHexString(System.identityHashCode(paramObject)));
    AppMethodBeat.o(196007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.f.b
 * JD-Core Version:    0.7.0.1
 */