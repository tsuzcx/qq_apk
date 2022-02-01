package cooperation.qqwifi;

public class QQWifiUtil
{
  private static long a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "^&*Qd6";
    jdField_a_of_type_Long = 4294967295L;
  }
  
  public static long a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = 0;
      l1 = 0L;
      for (;;)
      {
        l2 = l1;
        if (i >= paramString.length()) {
          break;
        }
        l1 = l1 + paramString.charAt(i) & jdField_a_of_type_Long;
        l1 = l1 + (l1 << 10) & jdField_a_of_type_Long;
        l1 = (l1 ^ l1 >> 6) & jdField_a_of_type_Long;
        i += 1;
      }
    }
    long l2 = 0L;
    long l1 = l2 + (l2 << 3) & jdField_a_of_type_Long;
    l1 = (l1 ^ l1 >> 11) & jdField_a_of_type_Long;
    l2 = l1 + (l1 << 15) & jdField_a_of_type_Long;
    l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWifiUtil
 * JD-Core Version:    0.7.0.1
 */