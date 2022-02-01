import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.qcall.QCallProxy;
import java.util.Comparator;

public class jpy
  implements Comparator
{
  public jpy(QCallProxy paramQCallProxy) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    if (paramQCallRecord1.type == QCallRecord.TYPE_DATE) {
      return 0;
    }
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpy
 * JD-Core Version:    0.7.0.1
 */