package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.component.network.module.common.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class QZoneClickReport$ReportInfo
{
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  private Map a;
  public boolean a;
  public long b;
  public String b;
  private boolean b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "0";
  public String g = "";
  
  public QZoneClickReport$ReportInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = NetworkState.a().a();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public QZoneClickReport$ReportInfo(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ArrayList paramArrayList)
  {
    this();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.c = paramString4;
    this.d = paramString5;
    this.e = paramString6;
    this.g = paramString2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public QZoneClickReport$ReportInfo(long paramLong, String paramString, Map paramMap)
  {
    this();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = true;
    if (paramMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
    }
  }
  
  public QZoneClickReport$ReportInfo(String paramString)
  {
    this();
    this.f = paramString;
    this.c = "12";
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("touin", this.jdField_a_of_type_Long);
    localJSONObject.put("network_type", String.valueOf(this.jdField_a_of_type_Int));
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
      {
        localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
    }
    else
    {
      localJSONObject.put("refer", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("actiontype", this.c);
      localJSONObject.put("subactiontype", this.d);
      localJSONObject.put("reserves", this.e);
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int j = this.jdField_a_of_type_JavaUtilArrayList.size();
        int i = 0;
        while (i < j)
        {
          localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localJSONObject.put("reserves" + (i + 2), localObject);
          }
          i += 1;
        }
      }
    }
    localJSONObject.put("read_source", this.f);
    localJSONObject.put("time", String.valueOf(this.jdField_b_of_type_Long));
    localJSONObject.put("info", this.g);
    return localJSONObject;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneClickReport.ReportInfo
 * JD-Core Version:    0.7.0.1
 */