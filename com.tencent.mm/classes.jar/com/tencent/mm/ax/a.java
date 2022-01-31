package com.tencent.mm.ax;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String evw = "";
  public static String evx = "";
  public String TEXT;
  public String TYPE;
  public bi bWO;
  public LinkedList<String> evA = new LinkedList();
  public LinkedList<Integer> evB = new LinkedList();
  public LinkedList<Integer> evC = new LinkedList();
  public String evy = "";
  public String evz;
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap, bi parambi)
  {
    this.values = paramMap;
    this.bWO = parambi;
  }
  
  public abstract boolean Ib();
  
  public static abstract class a
  {
    private static HashMap<String, a> evD = new HashMap();
    
    public static void a(String paramString, a parama)
    {
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (evD)
      {
        evD.put(paramString.toLowerCase(), parama);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, bi parambi)
    {
      if (paramMap == null)
      {
        y.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        return null;
      }
      String str = (String)paramMap.get(".sysmsg.$type");
      synchronized (evD)
      {
        a locala = (a)evD.get(str.toLowerCase());
        if (locala == null)
        {
          y.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
          return null;
        }
        paramMap = locala.a(paramMap, parambi);
        return paramMap;
      }
    }
    
    public abstract a a(Map<String, String> paramMap, bi parambi);
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, bi parambi, a parama, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ax.a
 * JD-Core Version:    0.7.0.1
 */