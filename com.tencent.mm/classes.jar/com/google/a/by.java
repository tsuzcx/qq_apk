package com.google.a;

final class by
{
  static String a(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder(parama.size());
    int i = 0;
    if (i < parama.size())
    {
      int j = parama.fB(i);
      switch (j)
      {
      default: 
        if ((j >= 32) && (j <= 126)) {
          localStringBuilder.append((char)j);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("\\a");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\v");
        continue;
        localStringBuilder.append("\\\\");
        continue;
        localStringBuilder.append("\\'");
        continue;
        localStringBuilder.append("\\\"");
        continue;
        localStringBuilder.append('\\');
        localStringBuilder.append((char)((j >>> 6 & 0x3) + 48));
        localStringBuilder.append((char)((j >>> 3 & 0x7) + 48));
        localStringBuilder.append((char)((j & 0x7) + 48));
      }
    }
    return localStringBuilder.toString();
  }
  
  static String e(g paramg)
  {
    a(new a()
    {
      public final byte fB(int paramAnonymousInt)
      {
        return this.bZJ.fB(paramAnonymousInt);
      }
      
      public final int size()
      {
        return this.bZJ.size();
      }
    });
  }
  
  static abstract interface a
  {
    public abstract byte fB(int paramInt);
    
    public abstract int size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.by
 * JD-Core Version:    0.7.0.1
 */