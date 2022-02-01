import android.os.Bundle;
import android.util.SparseArray;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.data.TroopBarPostEntity;
import com.tencent.mobileqq.troop.activity.TroopBarPageActivity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.TroopBarPostAdapter;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kgb
  implements HttpWebCgiAsyncTask.Callback
{
  public kgb(TroopBarPageActivity paramTroopBarPageActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    boolean bool1;
    int i;
    label374:
    Object localObject1;
    label546:
    long l;
    label658:
    label669:
    if (paramJSONObject != null)
    {
      if (paramInt == 0)
      {
        if (paramBundle == null) {}
        for (bool1 = false; paramJSONObject.optInt("retcode", -1) == 100000; bool1 = paramBundle.getBoolean("requestPageOnly"))
        {
          this.a.b(false);
          if (!this.a.b)
          {
            this.a.b = true;
            this.a.a(this.a.r, bool1, true);
          }
          if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarActivity", 2, "requestTroopbarPage---RESULT_CODE_SIGN_ERROR");
          }
          return;
        }
        this.a.b = false;
        paramInt = paramJSONObject.optInt("errno", -1);
        if (paramInt == 0)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null) {}
          for (paramBundle = TroopBarUtils.a;; paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType)
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity = new TroopBarPageEntity();
              this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.id = this.a.r;
              this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType = paramBundle;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.refreshData(paramJSONObject);
            TroopBarPageActivity.a(this.a).setVisibility(0);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.notifyDataSetChanged();
            TroopBarUtils.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity);
            if ((bool1) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType == null)) {
              break;
            }
            this.a.b(false);
            this.a.a(this.a.r, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType.type, 0L, true, false);
            return;
          }
        }
        i = paramJSONObject.optInt("retcode", -1);
        if (i != 0)
        {
          QQToast.a(this.a, 1, this.a.getString(2131363871, new Object[] { Integer.valueOf(i) }), 0).b(this.a.getTitleBarHeight());
          this.a.b(false);
        }
      }
      label567:
      do
      {
        this.a.b(false);
        return;
        QQToast.a(this.a, 1, this.a.getString(2131363871, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.getTitleBarHeight());
        break label374;
        i = 0;
        if ((paramInt == -1001) || (paramInt == -1002)) {
          i = 1;
        }
        int j = i;
        if (i == 0)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity == null) {}
          for (localObject1 = null;; localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.getTypeList())
          {
            j = i;
            if (localObject1 == null) {
              break label546;
            }
            j = 0;
            while (j < ((ArrayList)localObject1).size())
            {
              if (paramInt == ((TroopBarPageEntity.TypeListEntity)((ArrayList)localObject1).get(j)).type) {
                i = 1;
              }
              j += 1;
            }
          }
          j = i;
        }
        if (j == 0)
        {
          this.a.b(false);
          return;
        }
        if (paramBundle == null)
        {
          l = 0L;
          if (paramBundle != null) {
            break label658;
          }
        }
        for (bool1 = false;; bool1 = paramBundle.getBoolean("clear_data"))
        {
          if (paramJSONObject.optInt("retcode", -1) != 100000) {
            break label669;
          }
          this.a.b(false);
          if (!this.a.c)
          {
            this.a.c = true;
            this.a.a(this.a.r, paramInt, l, bool1, true);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("IphoneTitleBarActivity", 2, "requestPost---RESULT_CODE_SIGN_ERROR");
          return;
          l = paramBundle.getLong("start_post_index");
          break label567;
        }
        this.a.c = false;
      } while (paramJSONObject == null);
    }
    label700:
    label1086:
    label1092:
    for (;;)
    {
      boolean bool2;
      try
      {
        paramBundle = this.a;
        if (paramJSONObject.optInt("isend", -1) != 1) {
          break label1086;
        }
        bool2 = true;
        paramBundle.c(bool2);
        localObject1 = paramJSONObject.getJSONArray("posts");
        paramBundle = new ArrayList();
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break label1092;
        }
        Object localObject2 = new TroopBarPostEntity(((JSONArray)localObject1).getJSONObject(i));
        ((TroopBarPostEntity)localObject2).type = String.valueOf(paramInt);
        paramBundle.add(localObject2);
        i += 1;
        continue;
        this.a.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Long.valueOf(20L + l));
        if (!bool1) {
          break label989;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(paramBundle);
        if (l == 0L)
        {
          localObject1 = SecurityUtile.b(this.a.r);
          localObject2 = SecurityUtile.b(String.valueOf(paramInt));
          TroopBarUtils.a(this.a.app, paramBundle);
          TroopBarUtils.a(this.a.app, TroopBarPostEntity.class, "bid=? and type = ?", new String[] { localObject1, localObject2 });
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.notifyDataSetChanged();
      }
      catch (JSONException paramBundle) {}
      if (paramJSONObject.optInt("isend", -1) == 1) {
        break;
      }
      paramInt = paramJSONObject.optInt("retcode", -1);
      if (paramInt != 0)
      {
        QQToast.a(this.a, 1, this.a.getString(2131363871, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.getTitleBarHeight());
        break;
      }
      label989:
      do
      {
        localObject1 = this.a.jdField_a_of_type_AndroidUtilSparseArray;
        l += 1L;
        ((SparseArray)localObject1).put(paramInt, Long.valueOf(l));
        break label796;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.a(paramBundle);
        break label812;
        paramInt = paramJSONObject.optInt("errno", -1);
        QQToast.a(this.a, 1, this.a.getString(2131363871, new Object[] { Integer.valueOf(paramInt) }), 0).b(this.a.getTitleBarHeight());
        break;
        QQToast.a(this.a, 1, this.a.getString(2131363870), 0).b(this.a.getTitleBarHeight());
        break;
        bool2 = false;
        break label700;
        if (paramInt == -1001) {
          break label776;
        }
      } while (paramInt != -1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgb
 * JD-Core Version:    0.7.0.1
 */