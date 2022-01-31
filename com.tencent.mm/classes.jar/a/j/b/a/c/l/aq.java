package a.j.b.a.c.l;

public abstract class aq
  implements ap
{
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ap)) {
        return false;
      }
      paramObject = (ap)paramObject;
      if (eoN() != paramObject.eoN()) {
        return false;
      }
      if (eoO() != paramObject.eoO()) {
        return false;
      }
    } while (eer().equals(paramObject.eer()));
    return false;
  }
  
  public int hashCode()
  {
    int j = eoO().hashCode();
    if (eoN()) {}
    for (int i = 17;; i = eer().hashCode()) {
      return i + j * 31;
    }
  }
  
  public String toString()
  {
    if (eoN()) {
      return "*";
    }
    if (eoO() == ba.CBX) {
      return eer().toString();
    }
    return eoO() + " " + eer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.l.aq
 * JD-Core Version:    0.7.0.1
 */