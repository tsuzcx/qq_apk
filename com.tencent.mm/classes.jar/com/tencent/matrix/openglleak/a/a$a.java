package com.tencent.matrix.openglleak.a;

import java.util.Objects;

public final class a$a
{
  public int eXZ;
  public String name;
  
  public a$a(int paramInt, String paramString)
  {
    this.eXZ = paramInt;
    this.name = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
    } while ((this.eXZ == paramObject.eXZ) && (Objects.equals(this.name, paramObject.name)));
    return false;
  }
  
  public final int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(this.eXZ), this.name });
  }
  
  public final String toString()
  {
    return "ActivityInfo{activityHashcode=" + this.eXZ + ", name='" + this.name + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.openglleak.a.a.a
 * JD-Core Version:    0.7.0.1
 */