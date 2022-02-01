import com.tencent.mobileqq.richmedia.dc.DataAdapter;
import java.util.HashMap;

public class jqq
  extends DataAdapter
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = false;
  private long c;
  
  public HashMap a(String paramString)
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.c == 0L)) {
      paramString = null;
    }
    HashMap localHashMap;
    do
    {
      do
      {
        do
        {
          return paramString;
          localHashMap = new HashMap();
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          localHashMap.put("is_progressive", "progressive");
          localHashMap.put("view_count", "1");
          if (this.jdField_b_of_type_Boolean)
          {
            localHashMap.put("failure", "1");
            return localHashMap;
          }
          if (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) {
            localHashMap.put("to_dp", String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
          }
          paramString = localHashMap;
        } while (this.c <= this.jdField_a_of_type_Long);
        paramString = localHashMap;
      } while (this.c <= this.jdField_b_of_type_Long);
      localHashMap.put("to_large", String.valueOf(this.c - this.jdField_a_of_type_Long));
      return localHashMap;
      localHashMap.put("is_progressive", "baseline");
      localHashMap.put("view_count", "1");
      if (this.jdField_b_of_type_Boolean)
      {
        localHashMap.put("failure", "1");
        return localHashMap;
      }
      paramString = localHashMap;
    } while (this.c <= this.jdField_a_of_type_Long);
    localHashMap.put("to_large", String.valueOf(this.c - this.jdField_a_of_type_Long));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jqq
 * JD-Core Version:    0.7.0.1
 */