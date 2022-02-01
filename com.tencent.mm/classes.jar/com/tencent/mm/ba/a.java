package com.tencent.mm.ba;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String hnV = "";
  public static String hnW = "";
  public String TEXT;
  public String TYPE;
  public bl drF;
  public String hnX = "";
  public String hnY;
  public LinkedList<String> hnZ = new LinkedList();
  public LinkedList<Integer> hoa = new LinkedList();
  public LinkedList<Integer> hob = new LinkedList();
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap)
  {
    this.values = paramMap;
  }
  
  public a(Map<String, String> paramMap, bl parambl)
  {
    this.values = paramMap;
    this.drF = parambl;
  }
  
  protected abstract boolean aqx();
  
  public final boolean azQ()
  {
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      hnV = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(hnV)) {
        this.TEXT = ((String)this.values.get(hnV));
      }
      hnW = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(hnW)) {
        this.hnY = ((String)this.values.get(hnW));
      }
      return aqx();
    }
    ad.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    return false;
  }
  
  public static abstract class a
  {
    private static HashMap<String, a> hoc = new HashMap();
    
    public static void a(String paramString, a parama)
    {
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (hoc)
      {
        hoc.put(paramString.toLowerCase(), parama);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, bl parambl)
    {
      if (paramMap == null)
      {
        ad.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        return null;
      }
      String str = bt.by((String)paramMap.get(".sysmsg.$type"), "");
      synchronized (hoc)
      {
        a locala = (a)hoc.get(str.toLowerCase());
        if (locala == null)
        {
          ad.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
          return null;
        }
        paramMap = locala.a(paramMap, parambl);
        return paramMap;
      }
    }
    
    public abstract a a(Map<String, String> paramMap, bl parambl);
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, bl parambl, a parama, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ba.a
 * JD-Core Version:    0.7.0.1
 */