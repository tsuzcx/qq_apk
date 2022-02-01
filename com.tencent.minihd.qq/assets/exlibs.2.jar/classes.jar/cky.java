import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import java.util.Comparator;

public class cky
  implements Comparator
{
  public cky(TroopBarAssistantManager paramTroopBarAssistantManager) {}
  
  public int a(TroopBarData paramTroopBarData1, TroopBarData paramTroopBarData2)
  {
    long l1 = Math.max(paramTroopBarData1.mLastMsgTime, paramTroopBarData1.mLastDraftTime);
    long l2 = Math.max(paramTroopBarData2.mLastMsgTime, paramTroopBarData2.mLastDraftTime);
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
 * Qualified Name:     cky
 * JD-Core Version:    0.7.0.1
 */