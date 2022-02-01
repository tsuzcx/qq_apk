package com.tencent.matrix.f;

import java.util.LinkedList;
import java.util.List;

public final class a$d
{
  List<a.e> list = new LinkedList();
  public String name;
  
  a$d(String paramString)
  {
    this.name = paramString;
  }
  
  public final boolean HA()
  {
    boolean bool = false;
    if (this.list.size() > 0) {
      bool = ((a.e)this.list.get(0)).cyz;
    }
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a.e))
    {
      paramObject = (a.e)paramObject;
      return this.name.equals(paramObject.name);
    }
    return false;
  }
  
  public final int getSize()
  {
    return this.list.size();
  }
  
  public final int hashCode()
  {
    return this.name.hashCode();
  }
  
  public final String toString()
  {
    return this.name + "=" + getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.matrix.f.a.d
 * JD-Core Version:    0.7.0.1
 */