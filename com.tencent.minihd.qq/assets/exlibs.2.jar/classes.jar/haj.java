import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class haj
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public static haj a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new haj();
    }
    haj localhaj = new haj();
    try
    {
      localhaj.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localhaj.jdField_a_of_type_JavaLangString = paramJSONObject.getString("soundName");
      localhaj.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localhaj.jdField_b_of_type_JavaLangString = paramJSONObject.getString("soundVersion");
      if (!TextUtils.isEmpty(paramJSONObject.getString("soundUrl"))) {
        localhaj.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      }
      localhaj.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localhaj.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localhaj.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localhaj.g = paramJSONObject.getString("classifyName");
      localhaj.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localhaj.jdField_f_of_type_JavaLangString = paramJSONObject.getString("access");
      localhaj.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localhaj.jdField_f_of_type_Int = paramJSONObject.getInt("isLimitFree");
      localhaj.h = paramJSONObject.getString("limitFreeStart");
      localhaj.i = paramJSONObject.getString("limitFreeEnd");
      localhaj.j = paramJSONObject.getString("bake1");
      localhaj.k = paramJSONObject.getString("bake1");
      localhaj.l = paramJSONObject.getString("bake1");
      return localhaj;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localhaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     haj
 * JD-Core Version:    0.7.0.1
 */