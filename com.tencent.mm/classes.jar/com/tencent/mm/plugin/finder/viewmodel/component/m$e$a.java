package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iq;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
final class m$e$a
  implements MMFragmentActivity.b
{
  m$e$a(WXMediaMessage paramWXMediaMessage, String paramString) {}
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(276926);
    if (paramInt2 == -1)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      p.j(paramIntent, "toUsers");
      paramIntent = (CharSequence)paramIntent;
      paramIntent = new k(",").u(paramIntent, 0);
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
      for (paramIntent = j.c((Iterable)paramIntent, ((ListIterator)localObject).nextIndex() + 1);; paramIntent = (List)v.aaAd)
      {
        paramIntent = ((Collection)paramIntent).toArray(new String[0]);
        if (paramIntent != null) {
          break label170;
        }
        paramIntent = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(276926);
        throw paramIntent;
        paramInt1 = 0;
        break label99;
        label158:
        break;
      }
      label170:
      paramIntent = Util.stringsToList((String[])paramIntent);
      p.j(paramIntent, "toUserList");
      paramIntent = ((Iterable)paramIntent).iterator();
      while (paramIntent.hasNext())
      {
        localObject = (String)paramIntent.next();
        iq localiq = new iq();
        localiq.fFN.fvl = this.BiS;
        localiq.fFN.username = ((String)localObject);
        localiq.fFN.fFO = 4;
        localiq.fFN.fFP = this.ybE;
        EventCenter.instance.publish((IEvent)localiq);
      }
    }
    AppMethodBeat.o(276926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.m.e.a
 * JD-Core Version:    0.7.0.1
 */