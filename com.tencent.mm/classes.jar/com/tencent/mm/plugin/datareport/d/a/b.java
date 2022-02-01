package com.tencent.mm.plugin.datareport.d.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public String viewId;
  public List<WeakReference<Object>> xhe;
  public Map<String, Object> xhf;
  public Map<Integer, List<com.tencent.mm.plugin.datareport.a.b.b>> xhg;
  public Map<String, Object> xhi;
  public WeakReference<View> xhj;
  
  public b()
  {
    AppMethodBeat.i(262841);
    this.xhi = new HashMap();
    this.xhe = new ArrayList();
    this.xhf = new HashMap();
    this.xhg = new HashMap();
    AppMethodBeat.o(262841);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(262848);
    String str = "ViewDataEntity{viewId='" + this.viewId + '\'' + ", viewParams=" + this.xhi + ", innerProperty='" + this.xhf + '}';
    AppMethodBeat.o(262848);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.d.a.b
 * JD-Core Version:    0.7.0.1
 */