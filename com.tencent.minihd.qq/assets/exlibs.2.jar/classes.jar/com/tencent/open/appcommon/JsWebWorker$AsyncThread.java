package com.tencent.open.appcommon;

public class JsWebWorker$AsyncThread
  implements Runnable
{
  protected String a;
  protected String[] a;
  protected String b;
  protected String c;
  
  public JsWebWorker$AsyncThread(JsWebWorker paramJsWebWorker, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsWebWorker.b(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.JsWebWorker.AsyncThread
 * JD-Core Version:    0.7.0.1
 */