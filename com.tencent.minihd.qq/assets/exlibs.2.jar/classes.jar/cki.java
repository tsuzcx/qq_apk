import android.os.Handler;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingActivity;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class cki
  extends PublicAccountObserver
{
  public cki(PubAccountAssistantSettingActivity paramPubAccountAssistantSettingActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = (PublicAccountDataManager)this.a.app.getManager(54);
      PubAccountAssistantSettingActivity.a(this.a, ((PublicAccountDataManager)localObject).a());
      localObject = PubAccountAssistantSettingActivity.a(this.a).iterator();
      label103:
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((localPublicAccountInfo.accountFlag & 0x800000) != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((localPublicAccountInfo.mShowMsgFlag != -1) && (paramInt == 0)) {
            break label103;
          }
          ((Iterator)localObject).remove();
          break;
        }
      }
      if ((PubAccountAssistantSettingActivity.a(this.a) != null) && (PubAccountAssistantSettingActivity.a(this.a).size() > 0)) {
        Collections.sort(PubAccountAssistantSettingActivity.a(this.a), PubAccountAssistantSettingActivity.a(this.a));
      }
      PubAccountAssistantSettingActivity.a(this.a).a(PubAccountAssistantSettingActivity.a(this.a));
      PubAccountAssistantSettingActivity.a(this.a).sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cki
 * JD-Core Version:    0.7.0.1
 */