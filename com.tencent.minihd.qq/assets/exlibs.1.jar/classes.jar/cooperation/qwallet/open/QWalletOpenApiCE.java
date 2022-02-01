package cooperation.qwallet.open;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletOpenApiCE
{
  private static QWalletOpenApiCE jdField_a_of_type_CooperationQwalletOpenQWalletOpenApiCE;
  public static final String a = "open_runtime_getOpenToken";
  public static final String b = "open_runtime_setDebug";
  public static final String c = "open_pay_pay";
  public static final String d = "open_userinfo_getOpenId";
  private static final String e = "Q.qwallet.open.QWalletOpenApiCE";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private List b;
  
  private QWalletOpenApiCE()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.add("open_runtime_getOpenToken");
    this.jdField_b_of_type_JavaUtilList.add("open_runtime_setDebug");
    this.jdField_b_of_type_JavaUtilList.add("open_pay_pay");
    this.jdField_b_of_type_JavaUtilList.add("open_userinfo_getOpenId");
  }
  
  public static QWalletOpenApiCE a()
  {
    try
    {
      if (jdField_a_of_type_CooperationQwalletOpenQWalletOpenApiCE == null) {
        jdField_a_of_type_CooperationQwalletOpenQWalletOpenApiCE = new QWalletOpenApiCE();
      }
      QWalletOpenApiCE localQWalletOpenApiCE = jdField_a_of_type_CooperationQwalletOpenQWalletOpenApiCE;
      return localQWalletOpenApiCE;
    }
    finally {}
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(String paramString1, String paramString2, List paramList1, List paramList2)
  {
    if ((paramList1 == null) || (paramList1.size() <= 0)) {}
    while ((paramList2 == null) || (paramList2.size() <= 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      localQWalletOpenApiInfo = (QWalletOpenApiInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localQWalletOpenApiInfo != null) && (localQWalletOpenApiInfo.jdField_a_of_type_JavaLangString.compareTo(paramString1) == 0)) {
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
      i -= 1;
    }
    QWalletOpenApiInfo localQWalletOpenApiInfo = new QWalletOpenApiInfo();
    localQWalletOpenApiInfo.jdField_a_of_type_JavaLangString = paramString1;
    localQWalletOpenApiInfo.jdField_b_of_type_JavaLangString = paramString2;
    localQWalletOpenApiInfo.jdField_a_of_type_JavaUtilList = paramList1;
    localQWalletOpenApiInfo.jdField_b_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_JavaUtilList.add(localQWalletOpenApiInfo);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      int i;
      int j;
      do
      {
        do
        {
          do
          {
            return false;
          } while (!paramString.startsWith("mqqopen://"));
          i = paramString.indexOf('/', 10);
        } while (i == -1);
        str = paramString.substring(10, i);
        j = paramString.indexOf('?', i);
      } while (j == -1);
      paramString = paramString.substring(i + 1, j);
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)));
    return this.jdField_b_of_type_JavaUtilList.contains(a(str, paramString));
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return !this.jdField_b_of_type_JavaUtilList.contains(a(paramString1, paramString2));
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4))) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
          paramString1 = Uri.parse(paramString1);
          paramString2 = paramString1.getScheme();
        } while ((!"http".equals(paramString2)) && (!"https".equals(paramString2)));
        str = paramString1.getHost();
        paramString1 = paramString5;
        if (!paramBoolean) {
          break;
        }
      } while ((paramVarArgs == null) || (paramVarArgs.length <= 0));
      if (("open_pay_pay".compareTo(a(paramString3, paramString4)) == 0) || ("open_runtime_getOpenToken".compareTo(a(paramString3, paramString4)) == 0) || ("open_runtime_setDebug".compareTo(a(paramString3, paramString4)) == 0)) {
        return true;
      }
      paramString2 = null;
      paramString1 = null;
      try
      {
        paramVarArgs = URLDecoder.decode(paramVarArgs[0], "UTF-8");
        paramString1 = paramVarArgs;
        paramString2 = paramVarArgs;
        paramVarArgs = new JSONObject(paramVarArgs).getString("openToken");
        paramString1 = paramVarArgs;
      }
      catch (UnsupportedEncodingException paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.open.QWalletOpenApiCE", 2, "jsonParams UnsupportedEncodingException,jsonParams=" + paramString1);
          }
          paramString2.printStackTrace();
          paramString1 = paramString5;
        }
      }
      catch (JSONException paramString1)
      {
        int i;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.open.QWalletOpenApiCE", 2, "jsonParams JSONException,jsonParams=" + paramString2);
          }
          paramString1.printStackTrace();
          paramString1 = paramString5;
        }
        i += 1;
        continue;
      }
      i = 0;
    } while (i >= this.jdField_a_of_type_JavaUtilList.size());
    paramString2 = (QWalletOpenApiInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if (paramString2 != null) {
      return paramString2.a(paramString1, str, a(paramString3, paramString4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.open.QWalletOpenApiCE
 * JD-Core Version:    0.7.0.1
 */