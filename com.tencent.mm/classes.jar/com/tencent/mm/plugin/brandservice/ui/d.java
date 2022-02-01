package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class d
  extends a
{
  private static a.b swV;
  String swW;
  
  public d(Object paramObject)
  {
    super(1, paramObject);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    if ((this.bnW instanceof String)) {
      this.swW = ((String)this.bnW);
    }
  }
  
  public final a.b czw()
  {
    AppMethodBeat.i(5680);
    if (swV == null) {
      swV = new a.b()
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
          if (!(paramAnonymousa instanceof d.a))
          {
            Log.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
            AppMethodBeat.o(5678);
            return;
          }
          if (!(paramAnonymousVarArgs instanceof d))
          {
            Log.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
            AppMethodBeat.o(5678);
            return;
          }
          paramAnonymousContext = (d.a)paramAnonymousa;
          paramAnonymousa = (d)paramAnonymousVarArgs;
          e.c(paramAnonymousContext.swP, paramAnonymousa.swW);
          AppMethodBeat.o(5678);
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          AppMethodBeat.i(5679);
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof d.a))) {
            ((d.a)paramAnonymousa).swP = ((TextView)paramAnonymousView.findViewById(d.e.catalogTV));
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
            localView = View.inflate(paramAnonymousContext, d.f.sux, null);
          }
          AppMethodBeat.o(5677);
          return localView;
        }
      };
    }
    a.b localb = swV;
    AppMethodBeat.o(5680);
    return localb;
  }
  
  public final a.a czx()
  {
    AppMethodBeat.i(5681);
    a locala = new a();
    AppMethodBeat.o(5681);
    return locala;
  }
  
  public static final class a
    implements a.a
  {
    public TextView swP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.d
 * JD-Core Version:    0.7.0.1
 */