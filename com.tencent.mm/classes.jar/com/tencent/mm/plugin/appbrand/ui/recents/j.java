package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.l.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Set;

final class j
  extends a
  implements l.b, h.b
{
  Activity gQx;
  private j.a iUN;
  h iUO;
  private boolean iUP;
  private View.OnClickListener iUQ;
  volatile boolean mFinished;
  
  j(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133473);
    this.iUN = new j.a((byte)0);
    this.mFinished = false;
    this.iUP = false;
    this.iUQ = null;
    this.iUO = new h(paramViewGroup);
    this.iUO.iUf = this;
    this.gQx = paramActivity;
    AppMethodBeat.o(133473);
  }
  
  private static Integer Fi(String paramString)
  {
    AppMethodBeat.i(133477);
    try
    {
      int i = Color.parseColor(paramString);
      AppMethodBeat.o(133477);
      return Integer.valueOf(i);
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(133477);
    }
    return null;
  }
  
  public final void a(h.c paramc, View paramView)
  {
    AppMethodBeat.i(133478);
    if ((paramc == null) || (paramc == h.c.iUo) || (paramc == h.c.iUn))
    {
      ab.v("MicroMsg.AppBrandListRecentsListWAGameHeader", "onClick ");
      AppMethodBeat.o(133478);
      return;
    }
    if (paramc == h.c.iUq)
    {
      this.iUO.showLoading();
      l.axc().refresh();
      AppMethodBeat.o(133478);
      return;
    }
    if ((paramc == h.c.iUp) && (this.iUQ != null))
    {
      this.iUQ.onClick(paramView);
      if (this.iUP)
      {
        paramc = this.iUO;
        if (paramc.iUh.iUv != null) {
          paramc.iUh.iUv.animate().alpha(0.0F).setDuration(200L).start();
        }
      }
    }
    AppMethodBeat.o(133478);
  }
  
  public final void aNd()
  {
    AppMethodBeat.i(133474);
    l locall = l.axc();
    eR(l.enabled());
    if (!l.enabled())
    {
      AppMethodBeat.o(133474);
      return;
    }
    synchronized (locall.mLock)
    {
      locall.hbl.add(this);
      locall.refresh();
      this.iUO.showLoading();
      this.mFinished = false;
      AppMethodBeat.o(133474);
      return;
    }
  }
  
  public final View aNe()
  {
    return this.iUO.iUh.aku;
  }
  
  public final void axd()
  {
    AppMethodBeat.i(133476);
    ab.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "AppBrandListRecentsListWAGameHeader.onWAGameDataUpdate");
    l.axc();
    if (!l.enabled())
    {
      AppMethodBeat.o(133476);
      return;
    }
    if (this.mFinished)
    {
      AppMethodBeat.o(133476);
      return;
    }
    View localView = this.iUO.iUh.aku;
    if (localView == null)
    {
      AppMethodBeat.o(133476);
      return;
    }
    localView.post(new j.1(this));
    AppMethodBeat.o(133476);
  }
  
  public final void eS(boolean paramBoolean) {}
  
  public final void onDetached()
  {
    AppMethodBeat.i(133475);
    this.mFinished = true;
    l locall = l.axc();
    synchronized (locall.mLock)
    {
      locall.hbl.remove(this);
      AppMethodBeat.o(133475);
      return;
    }
  }
  
  public final void onResume() {}
  
  public final void pF(int paramInt)
  {
    AppMethodBeat.i(133479);
    if (this.iUO != null)
    {
      h localh = this.iUO;
      if ((localh.iUh != null) && (localh.iUh.iUx != null)) {
        localh.iUh.iUx.setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(133479);
  }
  
  public final void pG(int paramInt)
  {
    AppMethodBeat.i(133480);
    h localh = this.iUO;
    if ((localh.iUh != null) && (localh.iUh.aku != null)) {
      localh.iUh.aku.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(133480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j
 * JD-Core Version:    0.7.0.1
 */