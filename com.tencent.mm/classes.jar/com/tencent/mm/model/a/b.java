package com.tencent.mm.model.a;

import java.util.HashMap;

public final class b
{
  public String dYa;
  public String dYb;
  public String dYc;
  public String dYd;
  public HashMap<String, e> dYe = new HashMap();
  
  public final e iX(String paramString)
  {
    if ((this.dYe != null) && (this.dYe.containsKey(paramString))) {
      return (e)this.dYe.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.a.b
 * JD-Core Version:    0.7.0.1
 */