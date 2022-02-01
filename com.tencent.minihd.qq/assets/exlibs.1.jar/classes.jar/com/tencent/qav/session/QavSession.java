package com.tencent.qav.session;

public class QavSession
{
  public int a;
  public long a;
  public QavSession.SessionStatus a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e = false;
  public int f;
  public boolean f;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  
  public QavSession(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus = QavSession.SessionStatus.NONE;
    this.jdField_b_of_type_Int = 6;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 3;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static String a(int paramInt, long paramLong)
  {
    return String.format("%s-%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.INVITING;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.BE_INVITING;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.CONNECTING;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.CONNECTED;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.CLOSING;
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.CLOSED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.session.QavSession
 * JD-Core Version:    0.7.0.1
 */