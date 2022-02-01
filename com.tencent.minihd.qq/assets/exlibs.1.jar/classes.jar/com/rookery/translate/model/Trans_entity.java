package com.rookery.translate.model;

public class Trans_entity
{
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final String jdField_a_of_type_JavaLangString;
  
  public Trans_entity(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public Boolean a()
  {
    return this.jdField_a_of_type_JavaLangBoolean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.rookery.translate.model.Trans_entity
 * JD-Core Version:    0.7.0.1
 */