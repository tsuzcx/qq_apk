import common.qzone.component.cache.common.SoftHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class lwr
  implements Iterator
{
  int jdField_a_of_type_Int;
  Object jdField_a_of_type_JavaLangObject = null;
  lwo jdField_a_of_type_Lwo = null;
  int jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
  Object jdField_b_of_type_JavaLangObject = null;
  lwo jdField_b_of_type_Lwo = null;
  
  lwr(SoftHashMap paramSoftHashMap)
  {
    if (paramSoftHashMap.size() != 0) {}
    for (int i = SoftHashMap.a(paramSoftHashMap).length;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  protected lwo a()
  {
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    if ((this.jdField_a_of_type_JavaLangObject == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    this.jdField_b_of_type_Lwo = this.jdField_a_of_type_Lwo;
    this.jdField_a_of_type_Lwo = lwo.a(this.jdField_a_of_type_Lwo);
    this.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = null;
    return this.jdField_b_of_type_Lwo;
  }
  
  public boolean hasNext()
  {
    lwo[] arrayOflwo = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    while (this.jdField_a_of_type_JavaLangObject == null)
    {
      lwo locallwo = this.jdField_a_of_type_Lwo;
      int i = this.jdField_a_of_type_Int;
      while ((locallwo == null) && (i > 0))
      {
        i -= 1;
        locallwo = arrayOflwo[i];
      }
      this.jdField_a_of_type_Lwo = locallwo;
      this.jdField_a_of_type_Int = i;
      if (locallwo == null)
      {
        this.jdField_b_of_type_JavaLangObject = null;
        return false;
      }
      this.jdField_a_of_type_JavaLangObject = locallwo.get();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_Lwo = lwo.a(this.jdField_a_of_type_Lwo);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.jdField_b_of_type_Lwo == null) {
      throw new IllegalStateException();
    }
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap.remove(this.jdField_b_of_type_JavaLangObject);
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_b_of_type_Lwo = null;
    this.jdField_b_of_type_JavaLangObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lwr
 * JD-Core Version:    0.7.0.1
 */