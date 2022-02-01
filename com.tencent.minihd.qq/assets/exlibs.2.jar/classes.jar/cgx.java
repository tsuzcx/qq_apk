import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistoryEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cgx
  implements Runnable
{
  public cgx(SearchActivity paramSearchActivity, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentBizLebasearchSearchActivity.app.a().createEntityManager();
    Object localObject2 = localEntityManager.a(SearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Object localObject1;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (SearchHistoryEntity)localIterator.next();
        if (((SearchHistoryEntity)localObject1).keyWord.equals(this.jdField_a_of_type_JavaLangString)) {
          localEntityManager.b((Entity)localObject1);
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((List)localObject2).remove(localObject1);
      }
      if (((List)localObject2).size() == 20)
      {
        localEntityManager.b((Entity)((List)localObject2).get(((List)localObject2).size() - 1));
        ((List)localObject2).remove(((List)localObject2).size() - 1);
      }
      for (localObject1 = localObject2;; localObject1 = new ArrayList())
      {
        localObject2 = new SearchHistoryEntity();
        ((SearchHistoryEntity)localObject2).keyWord = this.jdField_a_of_type_JavaLangString;
        ((SearchHistoryEntity)localObject2).timestamp = System.currentTimeMillis();
        localEntityManager.a((Entity)localObject2);
        ((List)localObject1).add(0, localObject2);
        localEntityManager.a();
        localObject2 = this.jdField_a_of_type_ComTencentBizLebasearchSearchActivity.a.obtainMessage(2);
        ((Message)localObject2).obj = localObject1;
        this.jdField_a_of_type_ComTencentBizLebasearchSearchActivity.a.sendMessage((Message)localObject2);
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgx
 * JD-Core Version:    0.7.0.1
 */