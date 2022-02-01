import com.tencent.component.network.utils.thread.a.a;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class cwn
  implements Iterator
{
  private int jdField_a_of_type_Int = a.a(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA);
  private int b = a.b(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA);
  private int c = -1;
  
  private cwn(a parama) {}
  
  public boolean hasNext()
  {
    return this.jdField_a_of_type_Int != this.b;
  }
  
  public Object next()
  {
    if (this.jdField_a_of_type_Int == this.b) {
      throw new NoSuchElementException();
    }
    Object localObject = a.c(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA)[this.jdField_a_of_type_Int];
    if ((a.b(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA) != this.b) || (localObject == null)) {
      throw new ConcurrentModificationException();
    }
    this.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int + 1 & a.c(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA).length - 1);
    return localObject;
  }
  
  public void remove()
  {
    if (this.c < 0) {
      throw new IllegalStateException();
    }
    if (a.a(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA, this.c))
    {
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int - 1 & a.c(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA).length - 1);
      this.b = a.b(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA);
    }
    this.c = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cwn
 * JD-Core Version:    0.7.0.1
 */