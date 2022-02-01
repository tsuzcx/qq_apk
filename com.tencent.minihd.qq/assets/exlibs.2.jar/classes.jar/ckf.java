import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import java.util.Comparator;

public class ckf
  implements Comparator
{
  public ckf(PubAccountAssistantManager paramPubAccountAssistantManager) {}
  
  public int a(PubAccountAssistantData paramPubAccountAssistantData1, PubAccountAssistantData paramPubAccountAssistantData2)
  {
    long l1 = Math.max(paramPubAccountAssistantData1.mLastMsgTime, paramPubAccountAssistantData1.mLastDraftTime);
    long l2 = Math.max(paramPubAccountAssistantData2.mLastMsgTime, paramPubAccountAssistantData2.mLastDraftTime);
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ckf
 * JD-Core Version:    0.7.0.1
 */