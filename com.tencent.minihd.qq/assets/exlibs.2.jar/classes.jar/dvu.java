import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import java.util.Comparator;

public class dvu
  implements Comparator
{
  public dvu(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public int a(DiscussionMemberInfo paramDiscussionMemberInfo1, DiscussionMemberInfo paramDiscussionMemberInfo2)
  {
    if ((paramDiscussionMemberInfo1 != null) && (paramDiscussionMemberInfo2 != null)) {
      return paramDiscussionMemberInfo1.discussionUin.compareTo(paramDiscussionMemberInfo2.discussionUin);
    }
    if (paramDiscussionMemberInfo1 != null) {
      return 1;
    }
    if (paramDiscussionMemberInfo2 != null) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvu
 * JD-Core Version:    0.7.0.1
 */