import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

public class khl
  extends TroopObserver
{
  public khl(TroopCreateAvatarActivity paramTroopCreateAvatarActivity) {}
  
  protected void a(String paramString, int paramInt1, List paramList, int paramInt2)
  {
    Object localObject = (TroopCreateLogic)this.a.app.getManager(31);
    label78:
    Message localMessage;
    Bundle localBundle;
    if (localObject != null)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        ((TroopCreateLogic)localObject).a().jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      if (!this.a.jdField_a_of_type_Boolean) {
        break label227;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label213;
      }
      TroopCreateAvatarActivity.a(this.a).setEnabled(true);
      localObject = ((FriendManager)this.a.app.getManager(8)).a(paramString);
      localMessage = new Message();
      localMessage.what = 10;
      localBundle = localMessage.getData();
      if (localObject == null) {
        break label252;
      }
      if (((TroopInfo)localObject).mTroopPicList == null) {
        break label241;
      }
      localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)((TroopInfo)localObject).mTroopPicList);
    }
    for (;;)
    {
      localBundle.putInt("newSeq", paramInt1);
      localBundle.putString("troopUin", paramString);
      localBundle.putInt("CMD_TYPE", paramInt2);
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      return;
      ((TroopCreateLogic)localObject).a().jdField_a_of_type_Boolean = false;
      break;
      label213:
      TroopCreateAvatarActivity.b(this.a).setEnabled(false);
      break label78;
      label227:
      TroopCreateAvatarActivity.c(this.a).setEnabled(true);
      break label78;
      label241:
      localBundle.putStringArrayList("AVATAR_WALL_LIST", null);
      continue;
      label252:
      if (paramList != null) {
        localBundle.putStringArrayList("AVATAR_WALL_LIST", (ArrayList)paramList);
      } else {
        localBundle.putStringArrayList("AVATAR_WALL_LIST", null);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    if (this.a.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!Utils.a(paramString1, this.a.jdField_b_of_type_JavaLangString)));
      if (paramInt1 == 0)
      {
        a(paramString1, paramInt2, paramList, 0);
        return;
      }
      if (paramString2 != null)
      {
        QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
        return;
      }
      if ((paramInt1 == 1) && (paramInt1 == 2))
      {
        QQToast.a(this.a, this.a.getString(2131363767), 1).b(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt1 == 19)
      {
        QQToast.a(this.a, this.a.getString(2131363768), 1).b(this.a.getTitleBarHeight());
        return;
      }
    } while (paramInt1 != 65);
    QQToast.a(this.a, this.a.getString(2131363769), 1).b(this.a.getTitleBarHeight());
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList)
  {
    if (this.a.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramInt1 == 0)
    {
      a(paramString1, 23, paramList, 1);
      return;
    }
    if (paramString2 != null)
    {
      a(paramString1, 23, paramList, 0);
      QQToast.a(this.a, paramString2, 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 1)
    {
      QQToast.a(this.a, this.a.getString(2131363767), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 2)
    {
      QQToast.a(this.a, this.a.getString(2131363768), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 3)
    {
      QQToast.a(this.a, this.a.getString(2131363771), 1).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramInt1 == 4)
    {
      QQToast.a(this.a, this.a.getString(2131363772), 1).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, this.a.getString(2131363773), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     khl
 * JD-Core Version:    0.7.0.1
 */