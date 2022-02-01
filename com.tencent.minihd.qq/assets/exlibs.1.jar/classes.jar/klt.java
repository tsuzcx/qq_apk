import android.text.Editable;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import java.util.Comparator;

public final class klt
  implements Comparator
{
  public klt(Editable paramEditable) {}
  
  public int a(AtTroopMemberSpan paramAtTroopMemberSpan1, AtTroopMemberSpan paramAtTroopMemberSpan2)
  {
    int i = 0;
    int j = this.a.getSpanStart(paramAtTroopMemberSpan1);
    int k = this.a.getSpanStart(paramAtTroopMemberSpan2);
    if (j < k) {
      i = -1;
    }
    while (j <= k) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     klt
 * JD-Core Version:    0.7.0.1
 */