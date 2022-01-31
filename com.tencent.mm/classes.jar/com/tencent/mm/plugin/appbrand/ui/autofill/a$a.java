package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.protocal.c.ev;
import java.util.List;

public final class a$a
  extends RecyclerView.a<a.a.a>
{
  private List<ev> hfb;
  
  public a$a(List<ev> paramList)
  {
    this.hfb = paramList;
  }
  
  public final int getItemCount()
  {
    if (this.hfb == null) {
      return 0;
    }
    return this.hfb.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */