package a.d.b;

import a.f.e;

public abstract class i
  extends a
  implements e
{
  protected final e cUl()
  {
    return (e)super.cUg();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof i)) {
        break;
      }
      paramObject = (i)paramObject;
    } while ((cUh().equals(paramObject.cUh())) && (getName().equals(paramObject.getName())) && (getSignature().equals(paramObject.getSignature())) && (g.e(cUe(), paramObject.cUe())));
    return false;
    if ((paramObject instanceof e)) {
      return paramObject.equals(cUf());
    }
    return false;
  }
  
  public int hashCode()
  {
    return (cUh().hashCode() * 31 + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  public String toString()
  {
    a.f.a locala = cUf();
    if (locala != this) {
      return locala.toString();
    }
    return "property " + getName() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.d.b.i
 * JD-Core Version:    0.7.0.1
 */