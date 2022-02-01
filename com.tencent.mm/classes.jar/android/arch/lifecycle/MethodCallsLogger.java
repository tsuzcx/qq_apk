package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Map;

public class MethodCallsLogger
{
  private Map<String, Integer> da = new HashMap();
  
  public boolean approveCall(String paramString, int paramInt)
  {
    Integer localInteger = (Integer)this.da.get(paramString);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      if ((i & paramInt) == 0) {
        break label64;
      }
    }
    label64:
    for (int j = 1;; j = 0)
    {
      this.da.put(paramString, Integer.valueOf(i | paramInt));
      if (j != 0) {
        break label70;
      }
      return true;
      i = 0;
      break;
    }
    label70:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.MethodCallsLogger
 * JD-Core Version:    0.7.0.1
 */