package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import java.util.HashMap;
import java.util.Map;

final class e$c
  extends t<AppBrandRecentTaskInfo, e.d>
{
  final Map<String, String> hhX = new HashMap();
  
  private e$c(e parame) {}
  
  private void a(e.d paramd)
  {
    e.i(this.hhH);
    if (LoadMoreRecyclerView.bg(paramd.aie) == e.b(this.hhH).getItemCount() - 1) {
      paramd.eYp.setVisibility(8);
    }
    while (e.A(this.hhH))
    {
      TextView localTextView = paramd.hib;
      e.i(this.hhH);
      localTextView.setText(String.valueOf(LoadMoreRecyclerView.bg(paramd.aie)));
      paramd.hib.setVisibility(0);
      return;
      paramd.eYp.setVisibility(0);
    }
    paramd.hib.setVisibility(8);
  }
  
  private static void a(e.d paramd, String paramString)
  {
    paramd.hhY.setText(paramString);
  }
  
  private void a(e.d paramd, boolean paramBoolean)
  {
    paramd = paramd.hid;
    if ((e.m(this.hhH)) && (paramBoolean)) {}
    for (int i = 0;; i = 8)
    {
      paramd.setVisibility(i);
      return;
    }
  }
  
  final void b(e.d paramd, String paramString)
  {
    e.B(this.hhH);
    paramd = b.JD().a(paramd.hic, paramString, a.JC(), f.eaL);
    this.hhX.put(paramString, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.c
 * JD-Core Version:    0.7.0.1
 */