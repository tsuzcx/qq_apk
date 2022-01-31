package com.tencent.matrix.f;

import java.util.LinkedList;
import java.util.List;

final class a$d
{
  List<a.e> list = new LinkedList();
  String name;
  
  a$d(String paramString)
  {
    this.name = paramString;
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
    return this.name + " " + this.list + " " + getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.f.a.d
 * JD-Core Version:    0.7.0.1
 */