package com.tencent.mm.az;

import android.view.View;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String jfE = "";
  public static String jfF = "";
  public String TEXT;
  public String TYPE;
  public ca dTX;
  public String jfG = "";
  public String jfH;
  public LinkedList<String> jfI = new LinkedList();
  public LinkedList<Integer> jfJ = new LinkedList();
  public LinkedList<Integer> jfK = new LinkedList();
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap)
  {
    this.values = paramMap;
  }
  
  public a(Map<String, String> paramMap, ca paramca)
  {
    this.values = paramMap;
    this.dTX = paramca;
  }
  
  protected abstract boolean aTA();
  
  public final boolean ben()
  {
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      jfE = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(jfE)) {
        this.TEXT = ((String)this.values.get(jfE));
      }
      jfF = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(jfF)) {
        this.jfH = ((String)this.values.get(jfF));
      }
      return aTA();
    }
    Log.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    return false;
  }
  
  public static abstract class a
  {
    private static HashMap<String, a> jfL = new HashMap();
    
    public static void a(String paramString, a parama)
    {
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (jfL)
      {
        jfL.put(paramString.toLowerCase(), parama);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, ca paramca)
    {
      if (paramMap == null)
      {
        Log.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        return null;
      }
      String str = Util.nullAs((String)paramMap.get(".sysmsg.$type"), "");
      synchronized (jfL)
      {
        a locala = (a)jfL.get(str.toLowerCase());
        if (locala == null)
        {
          Log.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
          return null;
        }
        paramMap = locala.a(paramMap, paramca);
        return paramMap;
      }
    }
    
    public abstract a a(Map<String, String> paramMap, ca paramca);
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, ca paramca, a parama, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.az.a
 * JD-Core Version:    0.7.0.1
 */