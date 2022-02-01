package com.tencent.mm.bc;

import android.view.View;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.Map;

public abstract class a
{
  public static String lWe = "";
  public static String lWf = "";
  public String TYPE;
  public ca fNz;
  public String lWg = "";
  public String lWh;
  public String lWi;
  public LinkedList<String> lWj = new LinkedList();
  public LinkedList<Integer> lWk = new LinkedList();
  public LinkedList<Integer> lWl = new LinkedList();
  public Map<String, String> values;
  
  public a(Map<String, String> paramMap)
  {
    this.values = paramMap;
  }
  
  public a(Map<String, String> paramMap, ca paramca)
  {
    this.values = paramMap;
    this.fNz = paramca;
  }
  
  protected abstract boolean bcz();
  
  public final boolean bnL()
  {
    if ((this.values != null) && (this.values.size() > 0))
    {
      if (this.values.containsKey(".sysmsg.$type")) {
        this.TYPE = ((String)this.values.get(".sysmsg.$type"));
      }
      lWe = ".sysmsg." + this.TYPE + ".text";
      if (this.values.containsKey(lWe)) {
        this.lWh = ((String)this.values.get(lWe));
      }
      lWf = ".sysmsg." + this.TYPE + ".link.scene";
      if (this.values.containsKey(lWf)) {
        this.lWi = ((String)this.values.get(lWf));
      }
      return bcz();
    }
    Log.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
    return false;
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, ca paramca, a parama, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bc.a
 * JD-Core Version:    0.7.0.1
 */