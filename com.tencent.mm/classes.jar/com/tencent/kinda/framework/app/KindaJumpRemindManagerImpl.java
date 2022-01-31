package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KJumpRemindInfo;
import com.tencent.kinda.gen.KRedirectUrl;
import com.tencent.kinda.gen.KindaJumpRemindManager;
import com.tencent.kinda.gen.VoidBoolStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.wallet_core.c.k;

public class KindaJumpRemindManagerImpl
  implements KindaJumpRemindManager
{
  private k jumpRemind;
  
  public KindaJumpRemindManagerImpl()
  {
    AppMethodBeat.i(144367);
    this.jumpRemind = new k();
    AppMethodBeat.o(144367);
  }
  
  public void jumpRemindImpl(KJumpRemindInfo paramKJumpRemindInfo, int paramInt1, int paramInt2, VoidBoolStringCallback paramVoidBoolStringCallback1, VoidBoolStringCallback paramVoidBoolStringCallback2)
  {
    AppMethodBeat.i(144368);
    aym localaym = new aym();
    localaym.pdt = paramKJumpRemindInfo.mJumpType;
    localaym.xog = paramKJumpRemindInfo.mIsPopUpWindows;
    localaym.cyA = paramKJumpRemindInfo.mWording;
    localaym.opC = paramKJumpRemindInfo.mLeftButtonWording;
    localaym.opD = paramKJumpRemindInfo.mRightButtonWording;
    bsx localbsx = new bsx();
    localbsx.type = paramKJumpRemindInfo.mUrl.mType;
    localbsx.cwc = paramKJumpRemindInfo.mUrl.mAppid;
    localbsx.xGz = paramKJumpRemindInfo.mUrl.mAppVersion;
    localbsx.path = paramKJumpRemindInfo.mUrl.mPath;
    localbsx.tMg = paramKJumpRemindInfo.mUrl.mBtnName;
    localaym.xoh = localbsx;
    localaym.title = paramKJumpRemindInfo.mTitle;
    this.jumpRemind = k.a(localaym);
    this.jumpRemind.AWQ = true;
    this.jumpRemind.a((Activity)KindaContext.get(), new KindaJumpRemindManagerImpl.1(this, paramVoidBoolStringCallback2, paramVoidBoolStringCallback1));
    AppMethodBeat.o(144368);
  }
  
  public void onDestroyJumpRemindManager()
  {
    AppMethodBeat.i(144369);
    if (this.jumpRemind != null) {
      this.jumpRemind.dSm();
    }
    AppMethodBeat.o(144369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaJumpRemindManagerImpl
 * JD-Core Version:    0.7.0.1
 */