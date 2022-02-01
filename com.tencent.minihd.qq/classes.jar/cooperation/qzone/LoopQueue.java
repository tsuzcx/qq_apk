package cooperation.qzone;

import java.util.Arrays;

public class LoopQueue
{
  private int jdField_a_of_type_Int = 10;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  private int b;
  private int c = 0;
  private int d = 0;
  
  public LoopQueue()
  {
    this.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.b];
  }
  
  public LoopQueue(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("size不能小于1,size=" + paramInt);
    }
    this.b = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.b];
  }
  
  public LoopQueue(Object paramObject)
  {
    this();
    this.jdField_a_of_type_ArrayOfJavaLangObject[0] = paramObject;
    this.d += 1;
  }
  
  public LoopQueue(Object paramObject, int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("initSize不能小于1,initSize=" + paramInt);
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("element不能为null,element=null");
    }
    this.b = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.b];
    this.jdField_a_of_type_ArrayOfJavaLangObject[0] = paramObject;
    this.d += 1;
  }
  
  public int a()
  {
    if (b()) {
      return 0;
    }
    if (this.d > this.c) {
      return this.d - this.c;
    }
    return this.b - (this.c - this.d);
  }
  
  public Object a()
  {
    if (b()) {
      throw new IndexOutOfBoundsException("空队列异常");
    }
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[this.c];
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = this.c;
    this.c = (i + 1);
    arrayOfObject[i] = null;
    if (this.c == this.b) {}
    for (i = 0;; i = this.c)
    {
      this.c = i;
      return localObject;
    }
  }
  
  public void a()
  {
    Arrays.fill(this.jdField_a_of_type_ArrayOfJavaLangObject, null);
    this.c = 0;
    this.d = 0;
  }
  
  public void a(Object paramObject)
  {
    if ((this.d == this.c) && (this.jdField_a_of_type_ArrayOfJavaLangObject[this.c] != null)) {
      throw new IndexOutOfBoundsException("队列已满的异常");
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("element不能为null,element=null");
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = this.d;
    this.d = (i + 1);
    arrayOfObject[i] = paramObject;
    if (this.d == this.b) {}
    for (i = 0;; i = this.d)
    {
      this.d = i;
      return;
    }
  }
  
  public boolean a()
  {
    return a() == this.b;
  }
  
  public Object b()
  {
    if (b()) {
      throw new IndexOutOfBoundsException("空队列异常");
    }
    return this.jdField_a_of_type_ArrayOfJavaLangObject[this.c];
  }
  
  public boolean b()
  {
    return (this.d == this.c) && (this.jdField_a_of_type_ArrayOfJavaLangObject[this.d] == null);
  }
  
  public String toString()
  {
    if (b()) {
      return "[]";
    }
    if (this.c < this.d)
    {
      localStringBuilder = new StringBuilder("[");
      i = this.c;
      while (i < this.d)
      {
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangObject[i].toString() + "->");
        i += 1;
      }
      i = localStringBuilder.length();
      return "]";
    }
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = this.c;
    while (i < this.b)
    {
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangObject[i].toString() + "->");
      i += 1;
    }
    i = 0;
    while (i < this.d)
    {
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangObject[i].toString() + "->");
      i += 1;
    }
    i = localStringBuilder.length();
    return "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qzone.LoopQueue
 * JD-Core Version:    0.7.0.1
 */