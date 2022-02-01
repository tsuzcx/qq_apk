package cooperation.qwallet.open;

import android.text.TextUtils;
import java.util.List;

public class QWalletOpenApiInfo
{
  public String a;
  public List a;
  public String b;
  public List b;
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString3))) {}
    for (;;)
    {
      return false;
      if ((this.a != null) && (this.a.size() > 0) && (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0) && (paramString1.compareTo(this.jdField_b_of_type_JavaLangString) == 0))
      {
        int i = 0;
        if (i < this.jdField_b_of_type_JavaUtilList.size())
        {
          if (TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilList.get(i))) {}
          while (paramString2.indexOf((String)this.jdField_b_of_type_JavaUtilList.get(i)) == -1)
          {
            i += 1;
            break;
          }
        }
        for (i = 1; (i != 0) && (this.a.contains(paramString3)); i = 0) {
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.open.QWalletOpenApiInfo
 * JD-Core Version:    0.7.0.1
 */