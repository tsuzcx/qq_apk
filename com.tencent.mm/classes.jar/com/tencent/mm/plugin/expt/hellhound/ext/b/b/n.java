package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.hellhoundlib.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n
{
  final Map<String, Map<String, List<Pair<String, String>>>> zCw;
  final d zIp;
  
  public n()
  {
    AppMethodBeat.i(300549);
    this.zCw = new HashMap();
    this.zIp = new n.1(this);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("com/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener", localArrayList);
    this.zCw.put("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$", localHashMap);
    AppMethodBeat.o(300549);
  }
  
  public final void ayW()
  {
    AppMethodBeat.i(300555);
    a.aYh();
    a.e(this.zCw, this.zIp);
    AppMethodBeat.o(300555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.n
 * JD-Core Version:    0.7.0.1
 */