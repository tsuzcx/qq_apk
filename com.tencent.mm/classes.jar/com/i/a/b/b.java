package com.i.a.b;

import com.i.a.d;
import java.util.List;

public abstract class b
  implements f
{
  protected abstract g alw();
  
  public d alx()
  {
    return new d((String)er("sql"), (List)er("arguments"));
  }
  
  public Boolean aly()
  {
    Object localObject = er("inTransaction");
    if ((localObject instanceof Boolean)) {
      return (Boolean)localObject;
    }
    return null;
  }
  
  public boolean alz()
  {
    return Boolean.TRUE.equals(er("noResult"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.i.a.b.b
 * JD-Core Version:    0.7.0.1
 */