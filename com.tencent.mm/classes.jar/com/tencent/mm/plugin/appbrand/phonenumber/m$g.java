package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class m$g
  implements Runnable
{
  m$g(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(143963);
    m localm = this.iEc;
    String str = this.iEc.appId;
    Context localContext = this.iEc.getContext();
    a.f.b.j.p(localContext, "context");
    m.a(localm, new j(str, localContext, this.iEc.iDe));
    this.iEc.adt.setAdapter((RecyclerView.a)m.a(this.iEc));
    if (this.iEc.iDe.size() == 0)
    {
      this.iEc.ejC.setVisibility(0);
      this.iEc.adt.setVisibility(8);
      this.iEc.iCu.setVisibility(8);
      AppMethodBeat.o(143963);
      return;
    }
    if (this.iEc.iDe.size() == 1)
    {
      this.iEc.ejC.setVisibility(8);
      this.iEc.adt.setVisibility(0);
      this.iEc.adt.getAdapter().notifyDataSetChanged();
      this.iEc.iCu.setVisibility(0);
      this.iEc.iCu.setText((CharSequence)this.iEc.getContext().getString(2131297178));
      AppMethodBeat.o(143963);
      return;
    }
    this.iEc.ejC.setVisibility(8);
    this.iEc.adt.setVisibility(0);
    this.iEc.iCu.setVisibility(0);
    this.iEc.adt.getAdapter().notifyDataSetChanged();
    this.iEc.iCu.setText((CharSequence)this.iEc.getContext().getString(2131297176));
    AppMethodBeat.o(143963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.m.g
 * JD-Core Version:    0.7.0.1
 */