import com.tencent.component.network.NetworkManager;

public class cuu
{
  public boolean a = false;
  public boolean b = false;
  
  public cuu()
  {
    if (NetworkManager.a())
    {
      this.a = true;
      this.b = true;
      return;
    }
    this.a = false;
    this.b = false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof cuu))) {
        return false;
      }
      paramObject = (cuu)paramObject;
    } while ((this.a == paramObject.a) && (this.b) && (paramObject.b));
    return false;
  }
  
  public int hashCode()
  {
    int j = 1;
    int i;
    if (this.a)
    {
      i = 1;
      if (!this.b) {
        break label34;
      }
    }
    for (;;)
    {
      return (i + 527) * 31 + j;
      i = 0;
      break;
      label34:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cuu
 * JD-Core Version:    0.7.0.1
 */