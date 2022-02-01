import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;
import java.util.HashMap;

public class dtf
  implements Comparator
{
  public dtf(Conversation paramConversation) {}
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    int k = 1;
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      int i;
      if ((paramRecentBaseData1.a.lastmsgtime >= 9223372036854775803L) || (paramRecentBaseData2.a.lastmsgtime >= 9223372036854775803L)) {
        i = Conversation.a(this.a, paramRecentBaseData1.a, paramRecentBaseData2.a);
      }
      int j;
      label268:
      label274:
      do
      {
        return i;
        if ((QvipSpecialCareManager.a == null) || (QvipSpecialCareManager.a.isEmpty())) {
          return Conversation.a(this.a, paramRecentBaseData1.a, paramRecentBaseData2.a);
        }
        if ((paramRecentBaseData1 != null) && (paramRecentBaseData1.B > 0) && (paramRecentBaseData1.a.type == 0) && (QvipSpecialCareManager.a(this.a.app.a() + paramRecentBaseData1.a.uin)))
        {
          i = 1;
          if ((paramRecentBaseData2 == null) || (paramRecentBaseData2.B <= 0) || (paramRecentBaseData2.a.type != 0) || (!QvipSpecialCareManager.a(this.a.app.a() + paramRecentBaseData2.a.uin))) {
            break label268;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) && (j == 0)) {
            break label299;
          }
          if ((i == 0) || (j == 0)) {
            break label274;
          }
          return Conversation.a(this.a, paramRecentBaseData1.a, paramRecentBaseData2.a);
          i = 0;
          break;
        }
        if ((i != 0) && (j == 0)) {
          return -1;
        }
        if (i != 0) {
          break;
        }
        i = k;
      } while (j != 0);
    }
    return 0;
    label299:
    return Conversation.a(this.a, paramRecentBaseData1.a, paramRecentBaseData2.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtf
 * JD-Core Version:    0.7.0.1
 */