import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResponseBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItemGroup;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class che
  implements BusinessObserver
{
  public che(Handler paramHandler, SharedPreferences paramSharedPreferences) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new SearchProtocol.WordItem();
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        mobileqq_dynamic_search.ResponseBody localResponseBody = new mobileqq_dynamic_search.ResponseBody();
        try
        {
          localResponseBody.mergeFrom(paramBundle);
          if ((localResponseBody.item_groups.has()) && (((mobileqq_dynamic_search.ResultItemGroup)localResponseBody.item_groups.get(0)).result_items.has()) && (((mobileqq_dynamic_search.ResultItem)((mobileqq_dynamic_search.ResultItemGroup)localResponseBody.item_groups.get(0)).result_items.get(0)).word.has()))
          {
            ((SearchProtocol.WordItem)localObject).word = ((mobileqq_dynamic_search.ResultItem)((mobileqq_dynamic_search.ResultItemGroup)localResponseBody.item_groups.get(0)).result_items.get(0)).word.get().toStringUtf8();
            ((SearchProtocol.WordItem)localObject).id = ((mobileqq_dynamic_search.ResultItem)((mobileqq_dynamic_search.ResultItemGroup)localResponseBody.item_groups.get(0)).result_items.get(0)).result_id.get().toStringUtf8();
            paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
            paramBundle.what = 3;
            paramBundle.obj = localObject;
            paramBundle.arg1 = 0;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("active_search_home_hot_word", ((SearchProtocol.WordItem)localObject).word).commit();
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("active_search_home_hot_word_id", ((SearchProtocol.WordItem)localObject).id).commit();
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("active_search_home_hot_word_time", System.currentTimeMillis()).commit();
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SearchProtocol", 2, paramBundle.getMessage());
          }
        }
      }
    }
    paramBundle = SearchProtocol.a(this.jdField_a_of_type_AndroidContentSharedPreferences);
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    if (!TextUtils.isEmpty(paramBundle.word))
    {
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).obj = paramBundle;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    ((Message)localObject).arg1 = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     che
 * JD-Core Version:    0.7.0.1
 */