package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KJumpRemindInfo;
import com.tencent.kinda.gen.KRedirectUrl;
import com.tencent.kinda.gen.KindaJumpRemindManager;
import com.tencent.kinda.gen.VoidBoolStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.m;

public class KindaJumpRemindManagerImpl
  implements KindaJumpRemindManager
{
  private m jumpRemind;
  
  public KindaJumpRemindManagerImpl()
  {
    AppMethodBeat.i(18450);
    this.jumpRemind = new m();
    AppMethodBeat.o(18450);
  }
  
  public void jumpRemindImpl(KJumpRemindInfo paramKJumpRemindInfo, int paramInt1, int paramInt2, final VoidBoolStringCallback paramVoidBoolStringCallback1, final VoidBoolStringCallback paramVoidBoolStringCallback2)
  {
    AppMethodBeat.i(18451);
    bno localbno = new bno();
    localbno.vjP = paramKJumpRemindInfo.mJumpType;
    localbno.Fdo = paramKJumpRemindInfo.mIsPopUpWindows;
    localbno.dlQ = paramKJumpRemindInfo.mWording;
    localbno.unW = paramKJumpRemindInfo.mLeftButtonWording;
    localbno.unX = paramKJumpRemindInfo.mRightButtonWording;
    cnk localcnk = new cnk();
    localcnk.type = paramKJumpRemindInfo.mUrl.mType;
    localcnk.djj = paramKJumpRemindInfo.mUrl.mAppid;
    localcnk.FAG = paramKJumpRemindInfo.mUrl.mAppVersion;
    localcnk.path = paramKJumpRemindInfo.mUrl.mPath;
    localcnk.AWx = paramKJumpRemindInfo.mUrl.mBtnName;
    localbno.Fdp = localcnk;
    localbno.title = paramKJumpRemindInfo.mTitle;
    this.jumpRemind = m.a(localbno);
    this.jumpRemind.JFd = true;
    this.jumpRemind.fAk();
    this.jumpRemind.a((Activity)KindaContext.get(), new f()
    {
      public void onCancel()
      {
        AppMethodBeat.i(18447);
        if (KindaJumpRemindManagerImpl.this.jumpRemind.fAj()) {
          if (paramVoidBoolStringCallback2 != null) {
            paramVoidBoolStringCallback2.call(false, null);
          }
        }
        for (;;)
        {
          KindaJumpRemindManagerImpl.this.jumpRemind.fAl();
          AppMethodBeat.o(18447);
          return;
          if (paramVoidBoolStringCallback1 != null) {
            paramVoidBoolStringCallback1.call(false, null);
          }
        }
      }
      
      public void onEnter() {}
      
      public void onUrlCancel()
      {
        AppMethodBeat.i(18449);
        if (KindaJumpRemindManagerImpl.this.jumpRemind.fAj()) {
          if (paramVoidBoolStringCallback2 != null) {
            paramVoidBoolStringCallback2.call(false, null);
          }
        }
        for (;;)
        {
          KindaJumpRemindManagerImpl.this.jumpRemind.fAl();
          AppMethodBeat.o(18449);
          return;
          if (paramVoidBoolStringCallback1 != null) {
            paramVoidBoolStringCallback1.call(false, null);
          }
        }
      }
      
      public void onUrlOk()
      {
        AppMethodBeat.i(18448);
        if (KindaJumpRemindManagerImpl.this.jumpRemind.fAj()) {
          if (paramVoidBoolStringCallback2 != null) {
            paramVoidBoolStringCallback2.call(true, null);
          }
        }
        for (;;)
        {
          KindaJumpRemindManagerImpl.this.jumpRemind.fAl();
          AppMethodBeat.o(18448);
          return;
          if (paramVoidBoolStringCallback1 != null) {
            paramVoidBoolStringCallback1.call(true, null);
          }
        }
      }
    });
    AppMethodBeat.o(18451);
  }
  
  public void onDestroyJumpRemindManager()
  {
    AppMethodBeat.i(18452);
    if (this.jumpRemind != null) {
      this.jumpRemind.fAl();
    }
    AppMethodBeat.o(18452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaJumpRemindManagerImpl
 * JD-Core Version:    0.7.0.1
 */