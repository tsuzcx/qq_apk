package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ah
{
  final ArrayList<Transition> tO = new ArrayList();
  public final Map<String, Object> values = new HashMap();
  public View view;
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ah)) && (this.view == ((ah)paramObject).view) && (this.values.equals(((ah)paramObject).values));
  }
  
  public final int hashCode()
  {
    return this.view.hashCode() * 31 + this.values.hashCode();
  }
  
  public final String toString()
  {
    String str1 = "TransitionValues@" + Integer.toHexString(hashCode()) + ":\n";
    str1 = str1 + "    view = " + this.view + "\n";
    str1 = str1 + "    values:";
    Iterator localIterator = this.values.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      str1 = str1 + "    " + str2 + ": " + this.values.get(str2) + "\n";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.ah
 * JD-Core Version:    0.7.0.1
 */