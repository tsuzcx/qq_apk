package com.tencent.mobileqq.transfile;

public class PicFowardDbRecordData
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public String a()
  {
    String str = null + this.jdField_a_of_type_Long;
    str = str + "|";
    str = str + this.jdField_a_of_type_JavaLangString;
    str = str + "|";
    str = str + this.jdField_a_of_type_Int;
    str = str + "|";
    str = str + this.jdField_b_of_type_JavaLangString;
    str = str + "|";
    str = str + this.c;
    str = str + "|";
    return str + this.jdField_b_of_type_Int;
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 12))
    {
      paramString = paramString.split("\\|");
      if ((paramString != null) && (paramString.length < 13)) {}
    }
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramString[12]);
      if (paramString.length >= 14) {
        this.jdField_a_of_type_JavaLangString = paramString[13];
      }
      if (paramString.length < 15) {}
    }
    catch (Exception localException3)
    {
      try
      {
        this.jdField_a_of_type_Int = Integer.parseInt(paramString[14]);
        if (paramString.length < 16) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.jdField_b_of_type_JavaLangString = paramString[15];
          if (paramString.length < 17) {}
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              this.c = paramString[16];
              if (paramString.length >= 18) {}
              try
              {
                this.jdField_b_of_type_Int = Integer.parseInt(paramString[17]);
                return;
              }
              catch (Exception paramString)
              {
                this.jdField_b_of_type_Int = -1;
              }
              localException1 = localException1;
              this.jdField_a_of_type_Long = -1L;
              continue;
              localException2 = localException2;
              this.jdField_a_of_type_Int = -1;
            }
            localException3 = localException3;
            this.jdField_b_of_type_JavaLangString = null;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              this.c = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicFowardDbRecordData
 * JD-Core Version:    0.7.0.1
 */