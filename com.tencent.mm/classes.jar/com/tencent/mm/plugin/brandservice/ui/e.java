package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class e
  extends a
{
  private static a.b vCC;
  String vCD;
  
  public e(Object paramObject)
  {
    super(1, paramObject);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    if ((this.cpt instanceof String)) {
      this.vCD = ((String)this.cpt);
    }
  }
  
  public final a.b dco()
  {
    AppMethodBeat.i(5680);
    if (vCC == null) {
      vCC = new a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, a paramAnonymousVarArgs)
        {
          AppMethodBeat.i(5678);
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null))
          {
            Log.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5678);
            return;
          }
          if (!(paramAnonymousa instanceof e.a))
          {
            Log.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
            AppMethodBeat.o(5678);
            return;
          }
          if (!(paramAnonymousVarArgs instanceof e))
          {
            Log.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
            AppMethodBeat.o(5678);
            return;
          }
          paramAnonymousContext = (e.a)paramAnonymousa;
          paramAnonymousa = (e)paramAnonymousVarArgs;
          com.tencent.mm.plugin.brandservice.model.e.c(paramAnonymousContext.vCw, paramAnonymousa.vCD);
          AppMethodBeat.o(5678);
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          AppMethodBeat.i(5679);
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof e.a))) {
            ((e.a)paramAnonymousa).vCw = ((TextView)paramAnonymousView.findViewById(d.e.catalogTV));
          }
          AppMethodBeat.o(5679);
        }
        
        public final boolean a(Context paramAnonymousContext, a paramAnonymousa, Object... paramAnonymousVarArgs)
        {
          return true;
        }
        
        public final View c(Context paramAnonymousContext, View paramAnonymousView)
        {
          AppMethodBeat.i(5677);
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = View.inflate(paramAnonymousContext, d.f.search_result_item_catalog, null);
          }
          AppMethodBeat.o(5677);
          return localView;
        }
      };
    }
    a.b localb = vCC;
    AppMethodBeat.o(5680);
    return localb;
  }
  
  public final a.a dcp()
  {
    AppMethodBeat.i(5681);
    a locala = new a();
    AppMethodBeat.o(5681);
    return locala;
  }
  
  public static final class a
    implements a.a
  {
    public TextView vCw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */