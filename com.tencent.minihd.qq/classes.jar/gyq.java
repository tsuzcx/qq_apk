import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.Comparator;

public class gyq
  implements Comparator
{
  private gyq(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
  {
    return paramTroopMemberInfo1.displayedNamePinyinFirst.compareToIgnoreCase(paramTroopMemberInfo2.displayedNamePinyinFirst);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gyq
 * JD-Core Version:    0.7.0.1
 */