import java.util.Map.Entry;

public class lwu
  implements Map.Entry
{
  private final Object a;
  private Object b;
  
  public lwu(Object paramObject1, Object paramObject2)
  {
    this.a = paramObject1;
    this.b = paramObject2;
  }
  
  public lwu(Map.Entry paramEntry)
  {
    this.a = paramEntry.getKey();
    this.b = paramEntry.getValue();
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
    } while ((!a(this.a, paramObject.getKey())) || (!a(this.b, paramObject.getValue())));
    return true;
  }
  
  public Object getKey()
  {
    return this.a;
  }
  
  public Object getValue()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.a == null)
    {
      i = 0;
      if (this.b != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.a.hashCode();
      break;
      label33:
      j = this.b.hashCode();
    }
  }
  
  public Object setValue(Object paramObject)
  {
    Object localObject = this.b;
    this.b = paramObject;
    return localObject;
  }
  
  public String toString()
  {
    return this.a + "=" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lwu
 * JD-Core Version:    0.7.0.1
 */