package com.tencent.component.network.utils.thread.a;

import cwn;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class a
  extends AbstractCollection
  implements b, Serializable, Cloneable
{
  private transient int jdField_a_of_type_Int;
  private transient Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[16];
  private transient int b;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != this.b)) {
      throw new AssertionError();
    }
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    int k = j - i;
    int m = j << 1;
    if (m < 0) {
      throw new IllegalStateException("Sorry, deque too big");
    }
    Object[] arrayOfObject = new Object[m];
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, i, arrayOfObject, 0, k);
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, k, i);
    this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
    this.jdField_a_of_type_Int = 0;
    this.b = j;
  }
  
  private boolean a(int paramInt)
  {
    b();
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = arrayOfObject.length - 1;
    int j = this.jdField_a_of_type_Int;
    int k = this.b;
    int m = paramInt - j & i;
    int n = k - paramInt & i;
    if (m >= (k - j & i)) {
      throw new ConcurrentModificationException();
    }
    if (m < n)
    {
      if (j <= paramInt) {
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, m);
      }
      for (;;)
      {
        arrayOfObject[j] = null;
        this.jdField_a_of_type_Int = (j + 1 & i);
        return false;
        System.arraycopy(arrayOfObject, 0, arrayOfObject, 1, paramInt);
        arrayOfObject[0] = arrayOfObject[i];
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, i - j);
      }
    }
    if (paramInt < k) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, n);
    }
    for (this.b = (k - 1);; this.b = (k - 1 & i))
    {
      return true;
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
      arrayOfObject[i] = arrayOfObject[0];
      System.arraycopy(arrayOfObject, 1, arrayOfObject, 0, k);
    }
  }
  
  private Object[] a(Object[] paramArrayOfObject)
  {
    if (this.jdField_a_of_type_Int < this.b) {
      System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_Int, paramArrayOfObject, 0, size());
    }
    while (this.jdField_a_of_type_Int <= this.b) {
      return paramArrayOfObject;
    }
    int i = this.jdField_a_of_type_ArrayOfJavaLangObject.length - this.jdField_a_of_type_Int;
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_Int, paramArrayOfObject, 0, i);
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, paramArrayOfObject, i, this.b);
    return paramArrayOfObject;
  }
  
  private void b()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangObject[this.b] != null)) {
      throw new AssertionError();
    }
    if (!jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int != this.b) {
        break label91;
      }
      if (this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_a_of_type_Int] != null) {
        break label125;
      }
    }
    label91:
    while ((this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_a_of_type_Int] != null) && (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.b - 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] != null))
    {
      if ((jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.jdField_a_of_type_Int - 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] == null)) {
        break;
      }
      throw new AssertionError();
    }
    label125:
    throw new AssertionError();
  }
  
  public Object a()
  {
    Object localObject = b();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("e == null");
    }
    this.jdField_a_of_type_ArrayOfJavaLangObject[this.b] = paramObject;
    int i = this.b + 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1;
    this.b = i;
    if (i == this.jdField_a_of_type_Int) {
      a();
    }
  }
  
  public boolean add(Object paramObject)
  {
    a(paramObject);
    return true;
  }
  
  public Object b()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
    if (localObject == null) {
      return null;
    }
    this.jdField_a_of_type_ArrayOfJavaLangObject[i] = null;
    this.jdField_a_of_type_Int = (i + 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1);
    return localObject;
  }
  
  public boolean b(Object paramObject)
  {
    a(paramObject);
    return true;
  }
  
  public Object c()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_a_of_type_Int];
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean c(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    for (int i = this.jdField_a_of_type_Int;; i = i + 1 & j - 1)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject))
      {
        a(i);
        return true;
      }
    }
    return false;
  }
  
  public void clear()
  {
    int i = this.jdField_a_of_type_Int;
    int k = this.b;
    if (i != k)
    {
      this.b = 0;
      this.jdField_a_of_type_Int = 0;
      int m = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
      int j;
      do
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject[i] = null;
        j = i + 1 & m - 1;
        i = j;
      } while (j != k);
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    for (int i = this.jdField_a_of_type_Int;; i = i + 1 & j - 1)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject)) {
        return true;
      }
    }
    return false;
  }
  
  public Object d()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_a_of_type_Int];
  }
  
  public a e()
  {
    try
    {
      a locala = (a)super.clone();
      locala.jdField_a_of_type_ArrayOfJavaLangObject = Arrays.copyOf(this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_ArrayOfJavaLangObject.length);
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public Object element()
  {
    return c();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_Int == this.b;
  }
  
  public Iterator iterator()
  {
    return new cwn(this, null);
  }
  
  public boolean offer(Object paramObject)
  {
    return b(paramObject);
  }
  
  public Object peek()
  {
    return d();
  }
  
  public Object poll()
  {
    return b();
  }
  
  public Object remove()
  {
    return a();
  }
  
  public boolean remove(Object paramObject)
  {
    return c(paramObject);
  }
  
  public int size()
  {
    return this.b - this.jdField_a_of_type_Int & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1;
  }
  
  public Object[] toArray()
  {
    return a(new Object[size()]);
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    int i = size();
    if (paramArrayOfObject.length < i) {
      paramArrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
    }
    for (;;)
    {
      a(paramArrayOfObject);
      if (paramArrayOfObject.length > i) {
        paramArrayOfObject[i] = null;
      }
      return paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.a.a
 * JD-Core Version:    0.7.0.1
 */