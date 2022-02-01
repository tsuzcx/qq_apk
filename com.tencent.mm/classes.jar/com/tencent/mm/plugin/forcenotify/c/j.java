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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "forcePushId", "", "avatarUrl", "nickname", "wording", "feedId", "liveId", "nonceId", "authIconUrl", "subject", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthIconUrl", "()Ljava/lang/String;", "getAvatarUrl", "getFeedId", "getLiveId", "getNickname", "getNonceId", "getSubject", "getWording", "getItemId", "", "getItemType", "", "getWindowTitle", "needSound", "", "needVibrate", "onAddToList", "", "onFullScreenClick", "view", "Landroid/view/View;", "onItemClick", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onRemoveFromList", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends a
{
  public final String Hox;
  public final String authIconUrl;
  public final String feedId;
  public final String liveId;
  private final String nVM;
  public final String nickname;
  public final String nonceId;
  private final String wording;
  
  public j(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    super(paramString1);
    AppMethodBeat.i(274854);
    this.nVM = paramString2;
    this.nickname = paramString3;
    this.wording = paramString4;
    this.feedId = paramString5;
    this.liveId = paramString6;
    this.nonceId = paramString7;
    this.authIconUrl = paramString8;
    this.Hox = paramString9;
    AppMethodBeat.o(274854);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(274885);
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
    AppMethodBeat.o(274885);
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    return 1;
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
    AppMethodBeat.i(274897);
    String str = MMApplicationContext.getContext().getResources().getString(a.h.force_notify_live);
    s.s(str, "getContext().resources.g…string.force_notify_live)");
    AppMethodBeat.o(274897);
    return str;
  }
  
  public final void fwE()
  {
    AppMethodBeat.i(274871);
    super.fwE();
    String str = this.feedId;
    com.tencent.mm.plugin.forcenotify.a.a locala = (com.tencent.mm.plugin.forcenotify.a.a)h.ax(com.tencent.mm.plugin.forcenotify.a.a.class);
    int i;
    if (c.a(c.Hoc)) {
      if (c.b(c.Hoc)) {
        i = 1;
      }
    }
    for (;;)
    {
      locala.a(str, i, 2, this.id, false);
      AppMethodBeat.o(274871);
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
    AppMethodBeat.i(274876);
    super.fwG();
    i.a locala = i.Hos;
    i.a.fwN().aDR(this.id);
    com.tencent.mm.plugin.forcenotify.d.b.Hoz.iP(this.id);
    AppMethodBeat.o(274876);
  }
  
  public final void hp(View paramView)
  {
    AppMethodBeat.i(274889);
    s.u(paramView, "view");
    Object localObject = com.tencent.mm.plugin.forcenotify.e.b.HpK;
    paramView = paramView.getContext();
    s.s(paramView, "view.context");
    localObject = (a)this;
    i.a locala = i.Hos;
    com.tencent.mm.plugin.forcenotify.e.b.a(paramView, (a)localObject, i.a.fwN().Hot.size());
    AppMethodBeat.o(274889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.j
 * JD-Core Version:    0.7.0.1
 */