import android.os.SystemClock;
import com.tencent.common.app.ThreadTracker;
import com.tencent.widget.TraceUtils;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.Vector;

class crw
  implements Iterator
{
  private Thread jdField_a_of_type_JavaLangThread;
  private final Iterator jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_Crv.jdField_a_of_type_JavaLangIterable.iterator();
  private boolean jdField_a_of_type_Boolean;
  private Thread b;
  
  crw(crv paramcrv) {}
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    while ((this.jdField_a_of_type_JavaLangThread == null) && (this.jdField_a_of_type_JavaUtilIterator.hasNext()))
    {
      this.jdField_a_of_type_JavaLangThread = ((Thread)((Reference)this.jdField_a_of_type_JavaUtilIterator.next()).get());
      if ((this.jdField_a_of_type_Crv.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangThread == null)) {
        this.jdField_a_of_type_JavaUtilIterator.remove();
      }
    }
  }
  
  public Thread a()
  {
    if (!hasNext()) {
      throw new IllegalStateException();
    }
    Thread localThread = this.jdField_a_of_type_JavaLangThread;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangThread = null;
    this.b = localThread;
    return localThread;
  }
  
  public boolean hasNext()
  {
    a();
    return this.jdField_a_of_type_JavaLangThread != null;
  }
  
  public void remove()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_JavaUtilIterator.remove();
    crx localcrx;
    if (this.b != null)
    {
      if (!this.b.getName().startsWith("SharedPreferencesImpl")) {
        TraceUtils.a("Thread." + this.b.getName() + "." + this.b.getId());
      }
      if (ThreadTracker.a())
      {
        localcrx = ThreadTracker.a(this.b.getId(), ThreadTracker.a);
        if (localcrx == null) {
          break label161;
        }
        crx.a(localcrx, this.b.getName());
        crx.a(localcrx, SystemClock.uptimeMillis() - ThreadTracker.a());
      }
    }
    for (;;)
    {
      if (!this.b.getName().startsWith("SharedPreferencesImpl")) {
        TraceUtils.a();
      }
      this.b = null;
      return;
      label161:
      localcrx = new crx(this.b.getId(), this.b.getName(), 0L, null);
      crx.a(localcrx, this.b.getName());
      crx.a(localcrx, SystemClock.uptimeMillis() - ThreadTracker.a());
      ThreadTracker.a.add(localcrx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     crw
 * JD-Core Version:    0.7.0.1
 */