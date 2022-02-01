package com.tencent.mm.plugin.datareport.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.a.b.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public String hJW;
  public int tBy;
  public String xhb;
  public Map<String, Object> xhc;
  public a xhd;
  public List<WeakReference<Object>> xhe;
  public Map<String, Object> xhf;
  public Map<Integer, List<b>> xhg;
  public int xhh;
  
  public a()
  {
    AppMethodBeat.i(262842);
    this.xhc = new HashMap();
    this.xhe = new ArrayList();
    this.xhf = new HashMap();
    this.xhg = new HashMap();
    this.xhh = -1;
    AppMethodBeat.o(262842);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(262850);
    String str = "PageDataEntity{pageId='" + this.tBy + '\'' + ", pageName='" + this.hJW + '\'' + ", pageStep='" + this.xhh + '\'' + ", pageContentId='" + this.xhb + '\'' + ", innerProperty='" + this.xhf + '\'' + ", pageParams=" + this.xhc + '}';
    AppMethodBeat.o(262850);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.d.a.a
 * JD-Core Version:    0.7.0.1
 */