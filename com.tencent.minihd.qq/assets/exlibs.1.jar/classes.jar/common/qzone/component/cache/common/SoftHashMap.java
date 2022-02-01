package common.qzone.component.cache.common;

import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lwo;
import lwq;
import lwt;
import lww;

public final class SoftHashMap
  extends AbstractMap
{
  private static final float jdField_a_of_type_Float = 0.75F;
  private static final int jdField_a_of_type_Int = 16;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int jdField_b_of_type_Int = 1073741824;
  private final ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private volatile transient Collection jdField_a_of_type_JavaUtilCollection = null;
  private transient Set jdField_a_of_type_JavaUtilSet = null;
  private lwo[] jdField_a_of_type_ArrayOfLwo;
  private final float jdField_b_of_type_Float;
  private volatile transient Set jdField_b_of_type_JavaUtilSet = null;
  private int c;
  private int d;
  private volatile int e;
  
  public SoftHashMap()
  {
    this.jdField_b_of_type_Float = 0.75F;
    this.d = 16;
    this.jdField_a_of_type_ArrayOfLwo = new lwo[16];
  }
  
  public SoftHashMap(int paramInt, float paramFloat)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Illegal Initial Capacity: " + paramInt);
    }
    int i = paramInt;
    if (paramInt > 1073741824) {
      i = 1073741824;
    }
    if ((paramFloat <= 0.0F) || (Float.isNaN(paramFloat))) {
      throw new IllegalArgumentException("Illegal Load factor: " + paramFloat);
    }
    paramInt = 1;
    while (paramInt < i) {
      paramInt <<= 1;
    }
    this.jdField_a_of_type_ArrayOfLwo = new lwo[paramInt];
    this.jdField_b_of_type_Float = paramFloat;
    this.d = ((int)(paramInt * paramFloat));
  }
  
  private static int a(int paramInt)
  {
    paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 - 1 & paramInt1;
  }
  
  private static int a(Object paramObject)
  {
    return a(paramObject.hashCode());
  }
  
  private lwo a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((lwo.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = lwo.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    lwo locallwo2 = (lwo)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (locallwo2 != null)
    {
      int i = a(lwo.a(locallwo2), this.jdField_a_of_type_ArrayOfLwo.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfLwo[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        lwo locallwo1 = lwo.a((lwo)localObject1);
        if (localObject1 == locallwo2)
        {
          if (localObject2 == locallwo2) {
            this.jdField_a_of_type_ArrayOfLwo[i] = locallwo1;
          }
          for (;;)
          {
            lwo.a(locallwo2, null);
            lwo.a(locallwo2, null);
            this.c -= 1;
            break;
            lwo.a(localObject2, locallwo1);
          }
        }
        localObject2 = localObject1;
        localObject1 = locallwo1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    lwo[] arrayOflwo1 = a();
    if (arrayOflwo1.length == 1073741824)
    {
      this.d = 2147483647;
      return;
    }
    lwo[] arrayOflwo2 = new lwo[paramInt];
    a(arrayOflwo1, arrayOflwo2);
    this.jdField_a_of_type_ArrayOfLwo = arrayOflwo2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.jdField_b_of_type_Float));
      return;
    }
    a();
    a(arrayOflwo2, arrayOflwo1);
    this.jdField_a_of_type_ArrayOfLwo = arrayOflwo1;
  }
  
  private void a(lwo[] paramArrayOflwo1, lwo[] paramArrayOflwo2)
  {
    int i = 0;
    while (i < paramArrayOflwo1.length)
    {
      Object localObject = paramArrayOflwo1[i];
      paramArrayOflwo1[i] = null;
      if (localObject != null)
      {
        lwo locallwo = lwo.a((lwo)localObject);
        if (((lwo)localObject).get() == null)
        {
          lwo.a((lwo)localObject, null);
          lwo.a((lwo)localObject, null);
          this.c -= 1;
        }
        for (;;)
        {
          localObject = locallwo;
          break;
          int j = a(lwo.a((lwo)localObject), paramArrayOflwo2.length);
          lwo.a((lwo)localObject, paramArrayOflwo2[j]);
          paramArrayOflwo2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    lwo[] arrayOflwo = a();
    int j;
    for (int i = arrayOflwo.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (lwo locallwo = arrayOflwo[j]; locallwo != null; locallwo = lwo.a(locallwo)) {
        if (lwo.a(locallwo) == null) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || (paramObject1.equals(paramObject2));
  }
  
  private lwo[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfLwo;
  }
  
  private static Object b(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = jdField_a_of_type_JavaLangObject;
    }
    return localObject;
  }
  
  private lwo b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      lwo[] arrayOflwo = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOflwo.length);
      paramObject = arrayOflwo[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        lwo locallwo = lwo.a(paramObject);
        if ((i == lwo.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.e += 1;
          this.c -= 1;
          if (localObject == paramObject) {
            arrayOflwo[j] = locallwo;
          }
          for (;;)
          {
            return paramObject;
            lwo.a(localObject, locallwo);
          }
        }
        localObject = paramObject;
        paramObject = locallwo;
      }
    }
  }
  
  private static Object c(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == jdField_a_of_type_JavaLangObject) {
      localObject = null;
    }
    return localObject;
  }
  
  public void clear()
  {
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
    this.e += 1;
    lwo[] arrayOflwo = this.jdField_a_of_type_ArrayOfLwo;
    int i = 0;
    while (i < arrayOflwo.length)
    {
      arrayOflwo[i] = null;
      i += 1;
    }
    this.c = 0;
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
  }
  
  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    lwo[] arrayOflwo = a();
    int j;
    for (int i = arrayOflwo.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (lwo locallwo = arrayOflwo[j]; locallwo != null; locallwo = lwo.a(locallwo)) {
        if (paramObject.equals(lwo.a(locallwo))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Set entrySet()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new lwq(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = lwo.a(paramObject)) {
      if ((lwo.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return lwo.a(paramObject);
      }
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public Set keySet()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilSet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new lwt(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    lwo[] arrayOflwo = a();
    int j = a(i, arrayOflwo.length);
    for (paramObject1 = arrayOflwo[j]; paramObject1 != null; paramObject1 = lwo.a(paramObject1)) {
      if ((i == lwo.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = lwo.a(paramObject1);
        if (paramObject2 != localObject) {
          lwo.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.e += 1;
    paramObject1 = arrayOflwo[j];
    arrayOflwo[j] = new lwo(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a(arrayOflwo.length * 2);
    }
    return null;
  }
  
  public void putAll(Map paramMap)
  {
    int i = 1073741824;
    int j = paramMap.size();
    if (j == 0) {
      return;
    }
    if (j > this.d)
    {
      j = (int)(j / this.jdField_b_of_type_Float + 1.0F);
      if (j <= 1073741824) {
        break label126;
      }
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ArrayOfLwo.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfLwo.length) {
        a(j);
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put(localEntry.getKey(), localEntry.getValue());
      }
      break;
      label126:
      i = j;
    }
  }
  
  public Object remove(Object paramObject)
  {
    Object localObject2 = b(paramObject);
    int i = a(localObject2);
    lwo[] arrayOflwo = a();
    int j = a(i, arrayOflwo.length);
    paramObject = arrayOflwo[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      lwo locallwo = lwo.a(paramObject);
      if ((i == lwo.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.e += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOflwo[j] = locallwo;
        }
        for (;;)
        {
          return lwo.a(paramObject);
          lwo.a(localObject1, locallwo);
        }
      }
      localObject1 = paramObject;
      paramObject = locallwo;
    }
    return null;
  }
  
  public int size()
  {
    if (this.c == 0) {
      return 0;
    }
    a();
    return this.c;
  }
  
  public Collection values()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilCollection;
    if (localObject != null) {
      return localObject;
    }
    localObject = new lww(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */