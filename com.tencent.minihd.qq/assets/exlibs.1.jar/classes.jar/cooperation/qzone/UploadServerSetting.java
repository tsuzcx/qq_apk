package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.uinterface.Utility.TestServerCategory;
import java.util.ArrayList;
import java.util.Iterator;
import mbk;
import mbl;
import mbm;
import mbn;

public class UploadServerSetting
  extends Activity
{
  public static final int a = 0;
  public static final String a = "113.108.67.20";
  public static final int b = 1;
  public static final String b = "113.108.76.228";
  public static final int c = 2;
  public static final String c = "119.147.14.28";
  public static final int d = 3;
  protected static final String d = "UploadServerSetting";
  public static final int e = 4;
  public static final int f = 19995;
  public static final int g = 8080;
  public static final int h = 19994;
  public BaseAdapter a;
  private UploadServerSetting.ConfigItem jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String e = "";
  private int i;
  
  private void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    try
    {
      this.e = paramString1;
      this.i = Integer.parseInt(paramString2);
      LocalMultiProcConfig.a("ServerUploadCustomIp", paramString1);
      LocalMultiProcConfig.a("ServerUploadCustomPort", this.i);
      this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem.jdField_a_of_type_Int = this.i;
      a(this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem);
      Utility.CUSTOM_IP = this.e;
      Utility.CUSTOM_PORT = this.i;
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void b()
  {
    d();
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem(Utility.TestServerCategory.getTestServerInfo(0), 0));
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem(Utility.TestServerCategory.getTestServerInfo(1), 1));
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem(Utility.TestServerCategory.getTestServerInfo(2), 2));
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem(Utility.TestServerCategory.getTestServerInfo(3), 3));
    this.jdField_a_of_type_JavaUtilArrayList.add(new UploadServerSetting.ConfigItem(Utility.TestServerCategory.getTestServerInfo(4), 4));
    if (this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem);
    }
    Utility.CUSTOM_IP = this.e;
    Utility.CUSTOM_PORT = this.i;
  }
  
  private void c()
  {
    int j = LocalMultiProcConfig.a("ServerUploadEnvironment", 0);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      UploadServerSetting.ConfigItem localConfigItem = (UploadServerSetting.ConfigItem)localIterator.next();
      if (localConfigItem.b == j) {
        localConfigItem.jdField_a_of_type_Boolean = true;
      } else {
        localConfigItem.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void d()
  {
    this.e = LocalMultiProcConfig.a("ServerUploadCustomIp", "113.108.67.16");
    this.i = LocalMultiProcConfig.a("ServerUploadCustomPort", 19994);
    this.jdField_a_of_type_CooperationQzoneUploadServerSetting$ConfigItem = new UploadServerSetting.ConfigItem("自定义：" + this.e, this.i, 5);
    Utility.CUSTOM_IP = this.e;
    Utility.CUSTOM_PORT = this.i;
    if (QLog.isColorLevel()) {
      QLog.d("upload", 2, "custom server loaded:" + Utility.CUSTOM_IP + ":" + Utility.CUSTOM_PORT);
    }
  }
  
  public QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131558902);
    paramContext.setContentView(2130904344);
    EditText localEditText1 = (EditText)paramContext.findViewById(2131301867);
    EditText localEditText2 = (EditText)paramContext.findViewById(2131301868);
    if (!TextUtils.isEmpty(this.e))
    {
      localEditText1.setText(this.e);
      localEditText2.setText(this.i + "");
    }
    paramContext.setNegativeButton(paramInt1, new mbl(this, paramContext));
    paramContext.setPositiveButton(paramInt2, new mbm(this, localEditText1, localEditText2, paramContext));
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public void a()
  {
    a(this, 2131365736, 2131365117).show();
  }
  
  public void a(UploadServerSetting.ConfigItem paramConfigItem)
  {
    LocalMultiProcConfig.a("ServerUploadEnvironment", paramConfigItem.b);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      UploadServerSetting.ConfigItem localConfigItem = (UploadServerSetting.ConfigItem)localIterator.next();
      if (paramConfigItem.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localConfigItem.jdField_a_of_type_JavaLangString)) {
        localConfigItem.jdField_a_of_type_Boolean = true;
      } else {
        localConfigItem.jdField_a_of_type_Boolean = false;
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    c();
    paramBundle = new mbn(this, this.jdField_a_of_type_JavaUtilArrayList);
    setContentView(2130904341);
    ListView localListView = (ListView)findViewById(2131301842);
    localListView.setAdapter(paramBundle);
    localListView.setOnItemClickListener(new mbk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.UploadServerSetting
 * JD-Core Version:    0.7.0.1
 */