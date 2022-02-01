package com.google.b;

import java.util.Collections;

abstract class bl
{
  private static final bl bZE = new a((byte)0);
  private static final bl bZF = new b((byte)0);
  
  static bl Iy()
  {
    return bZE;
  }
  
  static bl Iz()
  {
    return bZF;
  }
  
  static final class a
    extends bl
  {
    private static final Class<?> bZG = Collections.unmodifiableList(Collections.emptyList()).getClass();
    
    private a()
    {
      super();
    }
  }
  
  static final class b
    extends bl
  {
    private b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.bl
 * JD-Core Version:    0.7.0.1
 */