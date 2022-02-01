package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity.a;
import d.a.j;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
final class FinderDebugUIC$c$a
  implements MMActivity.a
{
  FinderDebugUIC$c$a(WXMediaMessage paramWXMediaMessage, String paramString) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(204480);
    if (paramInt2 == -1)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      d.g.b.k.g(paramIntent, "toUsers");
      paramIntent = (CharSequence)paramIntent;
      paramIntent = new d.n.k(",").q(paramIntent, 0);
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
      for (paramIntent = j.b((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)d.a.v.KTF)
      {
        paramIntent = ((Collection)paramIntent).toArray(new String[0]);
        if (paramIntent != null) {
          break label170;
        }
        paramIntent = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(204480);
        throw paramIntent;
        paramInt1 = 0;
        break label99;
        label158:
        break;
      }
      label170:
      paramIntent = bs.S((String[])paramIntent);
      d.g.b.k.g(paramIntent, "toUserList");
      paramIntent = ((Iterable)paramIntent).iterator();
      while (paramIntent.hasNext())
      {
        localObject = (String)paramIntent.next();
        hh localhh = new hh();
        localhh.dir.dis = this.sds;
        localhh.dir.username = ((String)localObject);
        localhh.dir.dit = 4;
        localhh.dir.diu = this.sdt;
        a.GpY.l((b)localhh);
      }
    }
    AppMethodBeat.o(204480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.c.a
 * JD-Core Version:    0.7.0.1
 */