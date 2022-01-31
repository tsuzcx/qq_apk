package com.tencent.mm.plugin;

import com.tencent.mm.model.p;
import com.tencent.mm.modelstat.q;

public final class a
  extends p
{
  private static a eUQ;
  
  private a()
  {
    super(q.class);
  }
  
  public static a Vh()
  {
    try
    {
      if (eUQ == null) {
        eUQ = new a();
      }
      a locala = eUQ;
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.a
 * JD-Core Version:    0.7.0.1
 */