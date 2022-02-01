package com.tencent.mm.plugin.emoji.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.dy;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.event.EmojiPostTaskListener;
import com.tencent.mm.plugin.emoji.event.EmojiResUpdateListener;
import com.tencent.mm.plugin.emoji.event.EmojiResUpdateOperationListener;
import com.tencent.mm.plugin.emoji.event.EmojiRevokeMsgListener;
import com.tencent.mm.sdk.event.IListener;

public final class b
{
  public static q.a appForegroundListener;
  public final IListener checkLanguageChangeIListener;
  public EmojiPostTaskListener xKC;
  public EmojiResUpdateListener xKD;
  public EmojiRevokeMsgListener xKE;
  public EmojiResUpdateOperationListener xKF;
  public IListener xKG;
  public IListener xKH;
  public IListener xKI;
  public IListener xKJ;
  public IListener xKK;
  public IListener xKL;
  public IListener xKM;
  public IListener xKN;
  public IListener xKO;
  
  static
  {
    AppMethodBeat.i(108411);
    appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(108403);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            paramAnonymousString = new dy();
            paramAnonymousString.hDO.state = 0;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(108403);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(108402);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            paramAnonymousString = new dy();
            paramAnonymousString.hDO.state = 1;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(108402);
      }
    };
    AppMethodBeat.o(108411);
  }
  
  public b()
  {
    AppMethodBeat.i(108410);
    this.xKC = new EmojiPostTaskListener();
    this.xKD = new EmojiResUpdateListener();
    this.xKE = new EmojiRevokeMsgListener();
    this.xKF = new EmojiResUpdateOperationListener();
    this.xKG = new EmojiEventMgr.1(this, f.hfK);
    this.xKH = new EmojiEventMgr.2(this, f.hfK);
    this.xKI = new EmojiEventMgr.3(this, f.hfK);
    this.xKJ = new EmojiEventMgr.5(this, f.hfK);
    this.xKK = new EmojiEventMgr.6(this, f.hfK);
    this.checkLanguageChangeIListener = new EmojiEventMgr.7(this, f.hfK);
    this.xKL = new EmojiEventMgr.8(this, f.hfK);
    this.xKM = new EmojiEventMgr.9(this, f.hfK);
    this.xKN = new EmojiEventMgr.10(this, f.hfK);
    this.xKO = new EmojiEventMgr.11(this, f.hfK);
    AppMethodBeat.o(108410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.b
 * JD-Core Version:    0.7.0.1
 */