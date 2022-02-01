import com.tencent.component.network.utils.a.b.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public abstract class cvs
{
  private final Object jdField_a_of_type_JavaLangObject;
  private final LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final Set jdField_a_of_type_JavaUtilSet;
  private final LinkedList b;
  
  cvs(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.b = new LinkedList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size() + this.jdField_a_of_type_JavaUtilSet.size();
  }
  
  public f a()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return (f)this.jdField_a_of_type_JavaUtilLinkedList.getLast();
    }
    return null;
  }
  
  protected abstract f a(Object paramObject);
  
  public cvr a()
  {
    return (cvr)this.b.poll();
  }
  
  public void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((cvr)localIterator.next()).cancel(true);
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(f paramf, boolean paramBoolean)
  {
    if (paramf == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    if (!this.jdField_a_of_type_JavaUtilSet.remove(paramf)) {
      throw new IllegalStateException("Entry " + paramf + " has not been leased from this pool");
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramf);
    }
  }
  
  public void a(cvr paramcvr)
  {
    if (paramcvr == null) {
      return;
    }
    this.b.add(paramcvr);
  }
  
  public boolean a(f paramf)
  {
    if (paramf == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    return (this.jdField_a_of_type_JavaUtilLinkedList.remove(paramf)) || (this.jdField_a_of_type_JavaUtilSet.remove(paramf));
  }
  
  public f b(Object paramObject)
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject;
      if (paramObject != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          if (paramObject.equals(localf.c()))
          {
            ((Iterator)localObject).remove();
            this.jdField_a_of_type_JavaUtilSet.add(localf);
            return localf;
          }
        }
      }
      paramObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (paramObject.hasNext())
      {
        localObject = (f)paramObject.next();
        if (((f)localObject).c() == null)
        {
          paramObject.remove();
          this.jdField_a_of_type_JavaUtilSet.add(localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public void b(cvr paramcvr)
  {
    if (paramcvr == null) {
      return;
    }
    this.b.remove(paramcvr);
  }
  
  public f c(Object paramObject)
  {
    paramObject = a(paramObject);
    this.jdField_a_of_type_JavaUtilSet.add(paramObject);
    return paramObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangObject);
    localStringBuilder.append("][leased: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet.size());
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cvs
 * JD-Core Version:    0.7.0.1
 */