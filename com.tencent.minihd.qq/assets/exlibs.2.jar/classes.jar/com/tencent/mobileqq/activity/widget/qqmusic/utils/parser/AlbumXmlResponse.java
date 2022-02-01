package com.tencent.mobileqq.activity.widget.qqmusic.utils.parser;

public class AlbumXmlResponse
  extends XmlResponse
{
  private static String[] a;
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static final int g = 4;
  private static final int h = 5;
  private static final int i = 6;
  private static final int j = 7;
  private static final int k = 8;
  private static final int l = 9;
  
  public AlbumXmlResponse()
  {
    if (jdField_a_of_type_ArrayOfJavaLangString == null) {
      jdField_a_of_type_ArrayOfJavaLangString = new String[] { "root.body.item.gl", "root.body.item.albumbigpic", "root.body.item.albumsmallpic", "root.body.item.singerbigpic", "root.body.item.singersmallpic", "root.body.item.albumid", "root.body.item.singerid", "root.body.item.albumname", "root.body.item.singername", "root.meta.ret" };
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(jdField_a_of_type_ArrayOfJavaLangString);
  }
  
  public int a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(9), -1);
  }
  
  public long a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(0), 0);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(1);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(2);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(3);
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(4);
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(5);
  }
  
  public String f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(6);
  }
  
  public String g()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(7));
  }
  
  public String h()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUtilsParserReader.a(8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.AlbumXmlResponse
 * JD-Core Version:    0.7.0.1
 */