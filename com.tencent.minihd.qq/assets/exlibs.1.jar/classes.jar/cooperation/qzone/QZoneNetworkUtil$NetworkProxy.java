package cooperation.qzone;

public class QZoneNetworkUtil$NetworkProxy
  implements Cloneable
{
  public final int a;
  public final String a;
  
  QZoneNetworkUtil$NetworkProxy(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  final NetworkProxy a()
  {
    try
    {
      NetworkProxy localNetworkProxy = (NetworkProxy)clone();
      return localNetworkProxy;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneNetworkUtil.NetworkProxy
 * JD-Core Version:    0.7.0.1
 */