package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class EnterpriseBizContactListView$2
  implements AdapterView.OnItemLongClickListener
{
  EnterpriseBizContactListView$2(EnterpriseBizContactListView paramEnterpriseBizContactListView) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13956);
    if (EnterpriseBizContactListView.a(this.jUo) == null) {
      EnterpriseBizContactListView.a(this.jUo, new EnterpriseBizContactListView.a(this.jUo));
    }
    EnterpriseBizContactListView.a locala = EnterpriseBizContactListView.a(this.jUo);
    int i = EnterpriseBizContactListView.b(this.jUo);
    int j = EnterpriseBizContactListView.c(this.jUo);
    if (locala.jUq == null)
    {
      localObject = (EnterpriseBizContactListView)locala.jUr.get();
      if (localObject == null)
      {
        AppMethodBeat.o(13956);
        return false;
      }
      locala.jUq = new com.tencent.mm.ui.widget.f(((EnterpriseBizContactListView)localObject).getContext());
    }
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.c)))
    {
      AppMethodBeat.o(13956);
      return false;
    }
    locala.jUp = ((EnterpriseBizContactListView.c)localObject).username;
    if ((bo.isNullOrNil(locala.jUp)) || (com.tencent.mm.aj.f.lg(locala.jUp)))
    {
      AppMethodBeat.o(13956);
      return false;
    }
    locala.jUq.AIF = paramView;
    locala.jUq.a(paramAdapterView, paramInt, paramLong, new EnterpriseBizContactListView.a.1(locala, paramInt), new EnterpriseBizContactListView.a.2(locala), i, j);
    AppMethodBeat.o(13956);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.2
 * JD-Core Version:    0.7.0.1
 */