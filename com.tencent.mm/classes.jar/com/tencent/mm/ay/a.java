package com.tencent.mm.ay;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String fLj = "";
  public static String fLk = "";
  public String TEXT;
  public String TYPE;
  public bi cEE;
  public String fLl = "";
  public String fLm;
  public LinkedList<String> fLn = new LinkedList();
  public LinkedList<Integer> fLo = new LinkedList();
  public LinkedList<Integer> fLp = new LinkedList();
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap)
  {
    this.values = paramMap;
  }
  
  public a(Map<String, String> paramMap, bi parambi)
  {
    this.values = paramMap;
    this.cEE = parambi;
  }
  
  protected abstract boolean Zh();
  
  public final boolean aiH()
  {
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      fLj = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(fLj)) {
        this.TEXT = ((String)this.values.get(fLj));
      }
      fLk = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(fLk)) {
        this.fLm = ((String)this.values.get(fLk));
      }
      return Zh();
    }
    ab.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    return false;
  }
  
  public static abstract class a
  {
    private static HashMap<String, a> fLq = new HashMap();
    
    public static void a(String paramString, a parama)
    {
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (fLq)
      {
        fLq.put(paramString.toLowerCase(), parama);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, bi parambi)
    {
      if (paramMap == null)
      {
        ab.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        return null;
      }
      String str = bo.bf((String)paramMap.get(".sysmsg.$type"), "");
      synchronized (fLq)
      {
        a locala = (a)fLq.get(str.toLowerCase());
        if (locala == null)
        {
          ab.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
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
 * Qualified Name:     com.tencent.mm.ay.a
 * JD-Core Version:    0.7.0.1
 */