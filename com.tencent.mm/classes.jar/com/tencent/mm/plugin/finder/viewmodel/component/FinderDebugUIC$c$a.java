package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity.a;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
final class FinderDebugUIC$c$a
  implements MMActivity.a
{
  FinderDebugUIC$c$a(WXMediaMessage paramWXMediaMessage, String paramString) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(206111);
    if (paramInt2 == -1)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      p.g(paramIntent, "toUsers");
      paramIntent = (CharSequence)paramIntent;
      paramIntent = new k(",").q(paramIntent, 0);
      Object localObject;
      if (!paramIntent.isEmpty())
      {
        localObject = paramIntent.listIterator(paramIntent.size());
        if (((ListIterator)localObject).hasPrevious()) {
          if (((CharSequence)((ListIterator)localObject).previous()).length() == 0)
          {
            paramInt1 = 1;
            label99:
            if (paramInt1 != 0) {
              break label158;
            }
          }
        }
      }
      for (paramIntent = j.b((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)d.a.v.NhH)
      {
        paramIntent = ((Collection)paramIntent).toArray(new String[0]);
        if (paramIntent != null) {
          break label170;
        }
        paramIntent = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(206111);
        throw paramIntent;
        paramInt1 = 0;
        break label99;
        label158:
        break;
      }
      label170:
      paramIntent = bu.U((String[])paramIntent);
      p.g(paramIntent, "toUserList");
      paramIntent = ((Iterable)paramIntent).iterator();
      while (paramIntent.hasNext())
      {
        localObject = (String)paramIntent.next();
        ho localho = new ho();
        localho.dvd.dve = this.tlI;
        localho.dvd.username = ((String)localObject);
        localho.dvd.dvf = 4;
        localho.dvd.dvg = this.tlJ;
        a.IvT.l((b)localho);
      }
    }
    AppMethodBeat.o(206111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.c.a
 * JD-Core Version:    0.7.0.1
 */