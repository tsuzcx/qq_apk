import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class kqd
  implements Runnable
{
  public kqd(BaseActivity paramBaseActivity, String paramString1, boolean paramBoolean, String paramString2, String paramString3, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    boolean bool;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a(this.jdField_a_of_type_JavaLangString, 0, 10);
        localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(8);
        MessageRecord localMessageRecord;
        Object localObject4;
        if (localObject1 == null)
        {
          bool = false;
          if ((localList == null) || (localList.size() <= 0)) {
            break label616;
          }
          localObject1 = new JSONArray();
          localObject2 = new JSONObject();
          i = 0;
          if ((i >= localList.size()) || (i >= 10)) {
            break;
          }
          localObject3 = new JSONObject();
          localMessageRecord = (MessageRecord)localList.get(i);
          if ((localMessageRecord instanceof MessageForPtt))
          {
            localObject4 = (MessageForPtt)localMessageRecord;
            ((MessageForPtt)localObject4).parse();
            ((JSONObject)localObject3).put("content", localMessageRecord.msg + ",urlAtServer:" + ((MessageForPtt)localObject4).urlAtServer);
            ((JSONObject)localObject3).put("contentType", "" + localMessageRecord.msgtype);
            ((JSONObject)localObject3).put("time", "" + localMessageRecord.time);
            ((JSONArray)localObject1).put(i, localObject3);
            i += 1;
            continue;
          }
        }
        else
        {
          bool = ((FriendManager)localObject1).b(this.jdField_a_of_type_JavaLangString);
          continue;
        }
        if ((localMessageRecord instanceof MessageForPic))
        {
          localObject4 = (MessageForPic)localMessageRecord;
          ((MessageForPic)localObject4).parse();
          ((JSONObject)localObject3).put("content", ((MessageForPic)localObject4).msg + ",uuid:" + ((MessageForPic)localObject4).uuid);
        }
        else
        {
          ((JSONObject)localObject3).put("content", localMessageRecord.msg);
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new kqf(this, localException));
        return;
      }
    }
    Object localObject3 = new StringBuilder().append("");
    String str;
    if (localException.size() <= 10)
    {
      i = localException.size();
      ((JSONObject)localObject2).put("msgnum", i);
      ((JSONObject)localObject2).put("contentlist", localObject1);
      str = ((JSONObject)localObject2).toString();
      label428:
      localObject2 = new StringBuilder().append("appname=KQQ&jubaotype=uin&system=android&");
      if (!this.jdField_a_of_type_Boolean) {
        break label628;
      }
    }
    label616:
    label628:
    for (Object localObject1 = "subapp=tips&";; localObject1 = "subapp=BusinessCard&")
    {
      localObject2 = (String)localObject1;
      localObject1 = "0";
      if (!TextUtils.isEmpty(this.b)) {
        localObject1 = this.b;
      }
      localObject3 = this.jdField_a_of_type_JavaLangString;
      str = "groupuin=" + (String)localObject1 + "&eviluin=" + (String)localObject3 + "&impeachuin=" + this.c + "&msglist=" + str;
      localObject1 = new StringBuilder().append(str);
      if (bool) {}
      for (str = "&uin_source=friend";; str = "&uin_source=0")
      {
        str = str;
        str = (String)localObject2 + str;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new kqe(this, str));
        return;
      }
      str = "0";
      break label428;
      i = 10;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kqd
 * JD-Core Version:    0.7.0.1
 */