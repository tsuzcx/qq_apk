package a.f.b;

import a.j.a;
import a.j.k;

public abstract class p
  extends c
  implements k
{
  protected final k ebk()
  {
    return (k)super.ebd();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof p)) {
        break;
      }
      paramObject = (p)paramObject;
    } while ((ebe().equals(paramObject.ebe())) && (getName().equals(paramObject.getName())) && (dyz().equals(paramObject.dyz())) && (j.e(ebb(), paramObject.ebb())));
    return false;
    if ((paramObject instanceof k)) {
      return paramObject.equals(ebc());
    }
    return false;
  }
  
  public int hashCode()
  {
    return (ebe().hashCode() * 31 + getName().hashCode()) * 31 + dyz().hashCode();
  }
  
  public String toString()
  {
    a locala = ebc();
    if (locala != this) {
      return locala.toString();
    }
    return "property " + getName() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.p
 * JD-Core Version:    0.7.0.1
 */