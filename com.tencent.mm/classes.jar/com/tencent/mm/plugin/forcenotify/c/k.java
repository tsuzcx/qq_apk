package com.tencent.mm.plugin.forcenotify.c;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.core.c;
import com.tencent.mm.plugin.forcenotify.ui.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "forcePushId", "", "username", "nickname", "wording", "createTime", "", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getCreateTime", "()J", "getNickname", "getUsername", "getWording", "getItemId", "getItemType", "", "getWindowTitle", "needSound", "", "needVibrate", "onAddToList", "", "onFullScreenClick", "view", "Landroid/view/View;", "onItemClick", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onRemoveFromList", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
{
  public final long createTime;
  public final String nVM;
  public final String nickname;
  public final String username;
  public final String wording;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    super(paramString1);
    AppMethodBeat.i(274846);
    this.username = paramString2;
    this.nickname = paramString3;
    this.wording = paramString4;
    this.createTime = paramLong;
    this.nVM = paramString5;
    AppMethodBeat.o(274846);
  }
  
  public final void a(j paramj, View paramView)
  {
    AppMethodBeat.i(274875);
    s.u(paramj, "holder");
    s.u(paramView, "view");
    paramView = (List)new ArrayList();
    Object localObject = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
    localObject = ((Iterable)b.a.fwZ().mZo).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala.bZB() == 0) || (locala.bZB() == 1)) {
        paramView.add(locala);
      }
    }
    int i = paramView.size();
    paramView = com.tencent.mm.plugin.forcenotify.e.b.HpK;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    com.tencent.mm.plugin.forcenotify.e.b.a(paramj, (a)this, i + 1);
    AppMethodBeat.o(274875);
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    return 0;
  }
  
  public final boolean dWY()
  {
    return true;
  }
  
  public final boolean dWZ()
  {
    return true;
  }
  
  public final String dXa()
  {
    AppMethodBeat.i(274894);
    String str = MMApplicationContext.getContext().getResources().getString(a.h.force_notify_msg);
    s.s(str, "getContext().resources.g….string.force_notify_msg)");
    AppMethodBeat.o(274894);
    return str;
  }
  
  public final void fwE()
  {
    AppMethodBeat.i(274861);
    super.fwE();
    String str = this.username;
    com.tencent.mm.plugin.forcenotify.a.a locala = (com.tencent.mm.plugin.forcenotify.a.a)h.ax(com.tencent.mm.plugin.forcenotify.a.a.class);
    int i;
    if (c.a(c.Hoc)) {
      if (c.b(c.Hoc)) {
        i = 1;
      }
    }
    for (;;)
    {
      locala.a(str, i, 1, this.id, false);
      AppMethodBeat.o(274861);
      return;
      i = 4;
      continue;
      if (c.b(c.Hoc)) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public final void fwG()
  {
    AppMethodBeat.i(274868);
    super.fwG();
    i.a locala = i.Hos;
    i.a.fwN().aDR(this.id);
    com.tencent.mm.plugin.forcenotify.d.b.Hoz.iP(this.id);
    AppMethodBeat.o(274868);
  }
  
  public final void hp(View paramView)
  {
    AppMethodBeat.i(274883);
    s.u(paramView, "view");
    Object localObject = com.tencent.mm.plugin.forcenotify.e.b.HpK;
    paramView = paramView.getContext();
    s.s(paramView, "view.context");
    localObject = (a)this;
    i.a locala = i.Hos;
    com.tencent.mm.plugin.forcenotify.e.b.a(paramView, (a)localObject, i.a.fwN().Hot.size());
    AppMethodBeat.o(274883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.k
 * JD-Core Version:    0.7.0.1
 */