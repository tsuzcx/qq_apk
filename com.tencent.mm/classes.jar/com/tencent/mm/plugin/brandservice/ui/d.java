package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class d
  extends com.tencent.mm.ui.base.sortview.a
{
  private static a.b icr;
  String ics;
  
  public d(Object paramObject)
  {
    super(1, paramObject);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    if ((this.data instanceof String)) {
      this.ics = ((String)this.data);
    }
  }
  
  public final a.b axw()
  {
    if (icr == null) {
      icr = new a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, com.tencent.mm.ui.base.sortview.a paramAnonymousVarArgs)
        {
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null))
          {
            y.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            return;
          }
          if (!(paramAnonymousa instanceof d.a))
          {
            y.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
            return;
          }
          if (!(paramAnonymousVarArgs instanceof d))
          {
            y.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
            return;
          }
          paramAnonymousContext = (d.a)paramAnonymousa;
          paramAnonymousa = (d)paramAnonymousVarArgs;
          com.tencent.mm.plugin.brandservice.b.a.b(paramAnonymousContext.icl, paramAnonymousa.ics);
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof d.a))) {
            ((d.a)paramAnonymousa).icl = ((TextView)paramAnonymousView.findViewById(b.d.catalogTV));
          }
        }
        
        public final boolean a(Context paramAnonymousContext, com.tencent.mm.ui.base.sortview.a paramAnonymousa, Object... paramAnonymousVarArgs)
        {
          return true;
        }
        
        public final View b(Context paramAnonymousContext, View paramAnonymousView)
        {
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = View.inflate(paramAnonymousContext, b.e.search_result_item_catalog, null);
          }
          return localView;
        }
      };
    }
    return icr;
  }
  
  public final a.a axx()
  {
    return new d.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.d
 * JD-Core Version:    0.7.0.1
 */