package com.tencent.mm.ba;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String ihM = "";
  public static String ihN = "";
  public String TEXT;
  public String TYPE;
  public bu dBd;
  public String ihO = "";
  public String ihP;
  public LinkedList<String> ihQ = new LinkedList();
  public LinkedList<Integer> ihR = new LinkedList();
  public LinkedList<Integer> ihS = new LinkedList();
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap)
  {
    this.values = paramMap;
  }
  
  public a(Map<String, String> paramMap, bu parambu)
  {
    this.values = paramMap;
    this.dBd = parambu;
  }
  
  protected abstract boolean aAc();
  
  public final boolean aJR()
  {
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      ihM = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(ihM)) {
        this.TEXT = ((String)this.values.get(ihM));
      }
      ihN = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(ihN)) {
        this.ihP = ((String)this.values.get(ihN));
      }
      return aAc();
    }
    ad.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    return false;
  }
  
  public static abstract class a
  {
    private static HashMap<String, a> ihT = new HashMap();
    
    public static void a(String paramString, a parama)
    {
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (ihT)
      {
        ihT.put(paramString.toLowerCase(), parama);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, bu parambu)
    {
      if (paramMap == null)
      {
        ad.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        return null;
      }
      String str = bt.bI((String)paramMap.get(".sysmsg.$type"), "");
      synchronized (ihT)
      {
        a locala = (a)ihT.get(str.toLowerCase());
        if (locala == null)
        {
          ad.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
          return null;
        }
        paramMap = locala.a(paramMap, parambu);
        return paramMap;
      }
    }
    
    public abstract a a(Map<String, String> paramMap, bu parambu);
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, bu parambu, a parama, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ba.a
 * JD-Core Version:    0.7.0.1
 */