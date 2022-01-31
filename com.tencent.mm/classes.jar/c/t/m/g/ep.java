package c.t.m.g;

import java.util.Iterator;

public final class ep
{
  private final String a;
  
  public ep(String paramString)
  {
    this.a = paramString;
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    Object localObject;
    if (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null) {
        paramStringBuilder.append(localObject.toString());
      }
    }
    while (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null)
      {
        paramStringBuilder.append(this.a);
        paramStringBuilder.append(localObject.toString());
      }
    }
    return paramStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.g.ep
 * JD-Core Version:    0.7.0.1
 */