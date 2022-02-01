package com.tencent.mm.az;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String hOy = "";
  public static String hOz = "";
  public String TEXT;
  public String TYPE;
  public bo dpq;
  public String hOA = "";
  public String hOB;
  public LinkedList<String> hOC = new LinkedList();
  public LinkedList<Integer> hOD = new LinkedList();
  public LinkedList<Integer> hOE = new LinkedList();
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap)
  {
    this.values = paramMap;
  }
  
  public a(Map<String, String> paramMap, bo parambo)
  {
    this.values = paramMap;
    this.dpq = parambo;
  }
  
  public final boolean aGG()
  {
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      hOy = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(hOy)) {
        this.TEXT = ((String)this.values.get(hOy));
      }
      hOz = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(hOz)) {
        this.hOB = ((String)this.values.get(hOz));
      }
      return axn();
    }
    ac.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    return false;
  }
  
  protected abstract boolean axn();
  
  public static abstract class a
  {
    private static HashMap<String, a> hOF = new HashMap();
    
    public static void a(String paramString, a parama)
    {
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (hOF)
      {
        hOF.put(paramString.toLowerCase(), parama);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, bo parambo)
    {
      if (paramMap == null)
      {
        ac.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        return null;
      }
      String str = bs.bG((String)paramMap.get(".sysmsg.$type"), "");
      synchronized (hOF)
      {
        a locala = (a)hOF.get(str.toLowerCase());
        if (locala == null)
        {
          ac.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
          return null;
        }
        paramMap = locala.a(paramMap, parambo);
        return paramMap;
      }
    }
    
    public abstract a a(Map<String, String> paramMap, bo parambo);
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, bo parambo, a parama, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.az.a
 * JD-Core Version:    0.7.0.1
 */