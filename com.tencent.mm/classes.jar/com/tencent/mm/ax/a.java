package com.tencent.mm.ax;

import android.view.View;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  public static String oPh = "";
  public static String oPi = "";
  public String SCENE;
  public String TYPE;
  public cc hTm;
  public String oPj = "";
  public String oPk;
  public LinkedList<String> oPl = new LinkedList();
  public LinkedList<Integer> oPm = new LinkedList();
  public LinkedList<Integer> oPn = new LinkedList();
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap)
  {
    this.values = paramMap;
  }
  
  public a(Map<String, String> paramMap, cc paramcc)
  {
    this.values = paramMap;
    this.hTm = paramcc;
  }
  
  protected abstract boolean bAo();
  
  public final boolean bLy()
  {
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      oPh = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(oPh)) {
        this.oPk = ((String)this.values.get(oPh));
      }
      oPi = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(oPi)) {
        this.SCENE = ((String)this.values.get(oPi));
      }
      return bAo();
    }
    Log.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    return false;
  }
  
  public static abstract class a
  {
    private static HashMap<String, a> oPo = new HashMap();
    
    public static void a(String paramString, a parama)
    {
      Assert.assertNotNull(paramString);
      Assert.assertNotNull(parama);
      synchronized (oPo)
      {
        oPo.put(paramString.toLowerCase(), parama);
        return;
      }
    }
    
    public static a b(Map<String, String> paramMap, cc paramcc)
    {
      if (paramMap == null)
      {
        Log.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
        return null;
      }
      String str = Util.nullAs((String)paramMap.get(".sysmsg.$type"), "");
      synchronized (oPo)
      {
        a locala = (a)oPo.get(str.toLowerCase());
        if (locala == null)
        {
          Log.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", new Object[] { str });
          return null;
        }
        paramMap = locala.a(paramMap, paramcc);
        return paramMap;
      }
    }
    
    public abstract a a(Map<String, String> paramMap, cc paramcc);
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, cc paramcc, a parama, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ax.a
 * JD-Core Version:    0.7.0.1
 */