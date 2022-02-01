import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;

public class cgn
  implements Runnable
{
  public cgn(SearchActivity paramSearchActivity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
    List localList = localEntityManager.a(SearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.a.a.obtainMessage(1);
    localMessage.obj = localList;
    this.a.a.sendMessage(localMessage);
    localEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgn
 * JD-Core Version:    0.7.0.1
 */