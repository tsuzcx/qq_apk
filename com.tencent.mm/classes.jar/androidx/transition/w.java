package androidx.transition;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class w
{
  final ArrayList<Transition> chg;
  public final Map<String, Object> values;
  public View view;
  
  public w()
  {
    AppMethodBeat.i(201486);
    this.values = new HashMap();
    this.chg = new ArrayList();
    AppMethodBeat.o(201486);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201492);
    if (((paramObject instanceof w)) && (this.view == ((w)paramObject).view) && (this.values.equals(((w)paramObject).values)))
    {
      AppMethodBeat.o(201492);
      return true;
    }
    AppMethodBeat.o(201492);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201499);
    int i = this.view.hashCode();
    int j = this.values.hashCode();
    AppMethodBeat.o(201499);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201509);
    String str1 = "TransitionValues@" + Integer.toHexString(hashCode()) + ":\n";
    str1 = str1 + "    view = " + this.view + "\n";
    str1 = str1 + "    values:";
    Iterator localIterator = this.values.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      str1 = str1 + "    " + str2 + ": " + this.values.get(str2) + "\n";
    }
    AppMethodBeat.o(201509);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.transition.w
 * JD-Core Version:    0.7.0.1
 */