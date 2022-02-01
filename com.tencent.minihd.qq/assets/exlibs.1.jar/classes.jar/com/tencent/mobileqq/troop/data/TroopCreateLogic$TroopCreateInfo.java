package com.tencent.mobileqq.troop.data;

import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateLogic$TroopCreateInfo
{
  public static final int a = 0;
  public static final int b = -1;
  public TroopCreateAdvanceData a;
  public String a;
  public boolean a;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  
  public TroopCreateLogic$TroopCreateInfo()
  {
    a();
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData = null;
    this.e = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_c_of_type_Int = paramString.optInt("classify", 0);
      this.jdField_d_of_type_Int = paramString.optInt("verifyType", 2);
      this.jdField_a_of_type_JavaLangString = paramString.optString("classificationInfo", "");
      this.b = paramString.optString("name", "");
      this.jdField_c_of_type_JavaLangString = paramString.optString("introduction", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("location", "");
      this.e = paramString.optInt("group_type", -1);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo
 * JD-Core Version:    0.7.0.1
 */