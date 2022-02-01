package android.support.v4.util;

import java.util.Iterator;
import java.util.Map.Entry;

final class MapCollections$MapIterator
  implements Iterator, Map.Entry
{
  int mEnd;
  boolean mEntryValid = false;
  int mIndex;
  
  MapCollections$MapIterator(MapCollections paramMapCollections)
  {
    this.mEnd = (paramMapCollections.colGetSize() - 1);
    this.mIndex = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    if ((ContainerHelpers.equal(paramObject.getKey(), this.this$0.colGetEntry(this.mIndex, 0))) && (ContainerHelpers.equal(paramObject.getValue(), this.this$0.colGetEntry(this.mIndex, 1)))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public Object getKey()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.this$0.colGetEntry(this.mIndex, 0);
  }
  
  public Object getValue()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.this$0.colGetEntry(this.mIndex, 1);
  }
  
  public boolean hasNext()
  {
    return this.mIndex < this.mEnd;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    Object localObject1 = this.this$0.colGetEntry(this.mIndex, 0);
    Object localObject2 = this.this$0.colGetEntry(this.mIndex, 1);
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label69;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label69:
      j = localObject2.hashCode();
    }
  }
  
  public Map.Entry next()
  {
    this.mIndex += 1;
    this.mEntryValid = true;
    return this;
  }
  
  public void remove()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException();
    }
    this.mIndex -= 1;
    this.mEnd -= 1;
    this.mEntryValid = false;
    this.this$0.colRemoveAt(this.mIndex);
  }
  
  public Object setValue(Object paramObject)
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.this$0.colSetValue(this.mIndex, paramObject);
  }
  
  public final String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     android.support.v4.util.MapCollections.MapIterator
 * JD-Core Version:    0.7.0.1
 */