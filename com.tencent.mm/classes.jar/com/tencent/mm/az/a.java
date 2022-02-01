package com.tencent.mm.az;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String ikF = "";
  public static String ikG = "";
  public String TEXT;
  public String TYPE;
  public bv dCi;
  public String ikH = "";
  public String ikI;
  public LinkedList<String> ikJ = new LinkedList();
  public LinkedList<Integer> ikK = new LinkedList();
  public LinkedList<Integer> ikL = new LinkedList();
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap)
  {
    this.values = paramMap;
  }
  
  public a(Map<String, String> paramMap, bv parambv)
  {
    this.values = paramMap;
    this.dCi = parambv;
  }
  
  protected abstract boolean aAs();
  
  public final boolean aKk()
  {
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      ikF = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(ikF)) {
        this.TEXT = ((String)this.values.get(ikF));
      }
      ikG = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(ikG)) {
        this.ikI = ((String)this.values.get(ikG));
      }
      return aAs();
    }
    ae.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    return false;
  }
  
  public static abstract class a
  {
    private static HashMap<String, a> ikM = new HashMap();
    
    public static void a(String paramString, a parama)
    {
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (ikM)
      {
        ikM.put(paramString.toLowerCase(), parama);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, bv parambv)
    {
      if (paramMap == null)
      {
        ae.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        return null;
      }
      String str = bu.bI((String)paramMap.get(".sysmsg.$type"), "");
      synchronized (ikM)
      {
        a locala = (a)ikM.get(str.toLowerCase());
        if (locala == null)
        {
          ae.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
          return null;
        }
        paramMap = locala.a(paramMap, parambv);
        return paramMap;
      }
    }
    
    public abstract a a(Map<String, String> paramMap, bv parambv);
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, bv parambv, a parama, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.az.a
 * JD-Core Version:    0.7.0.1
 */