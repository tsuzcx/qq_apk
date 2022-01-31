package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

public enum i
  implements f
{
  private ProgressDialog eeN;
  private boolean lFg;
  public i.a lFh;
  
  static
  {
    AppMethodBeat.i(19305);
    lFf = new i("INSTANCE");
    lFi = new i[] { lFf };
    AppMethodBeat.o(19305);
  }
  
  private i()
  {
    AppMethodBeat.i(19299);
    this.lFg = false;
    Object localObject = ah.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    aw.aaz();
    long l = ((SharedPreferences)localObject).getLong(c.getUin(), 0L);
    if (l != 0L)
    {
      ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(19299);
      return;
    }
    ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    AppMethodBeat.o(19299);
  }
  
  public static void jf(long paramLong)
  {
    AppMethodBeat.i(19302);
    ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = ah.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    aw.aaz();
    localEditor.putLong(c.getUin(), paramLong).commit();
    AppMethodBeat.o(19302);
  }
  
  public final void a(Context paramContext, i.a parama)
  {
    AppMethodBeat.i(19300);
    ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.lFg)
    {
      if (this.lFh == null) {
        this.lFh = parama;
      }
      ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      AppMethodBeat.o(19300);
      return;
    }
    o localo = new o();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.eeN != null) && (this.eeN.isShowing()))
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      paramContext.getString(2131297087);
      this.eeN = h.b(paramContext, paramContext.getString(2131302913), new i.1(this, localo, parama));
    }
    this.lFh = parama;
    aw.Rc().a(localo, 0);
    AppMethodBeat.o(19300);
  }
  
  public final boolean he(boolean paramBoolean)
  {
    AppMethodBeat.i(19301);
    if (this.lFg)
    {
      ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      AppMethodBeat.o(19301);
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    aw.aaz();
    long l2 = localSharedPreferences.getLong(c.getUin(), 0L);
    if ((!paramBoolean) && (l1 - l2 < 86400000L))
    {
      ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
      AppMethodBeat.o(19301);
      return false;
    }
    AppMethodBeat.o(19301);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(19303);
    ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.lFg = false;
    if ((paramm == null) || (paramInt2 != 0) || (paramInt1 != 0))
    {
      ab.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if ((this.eeN != null) && (this.eeN.isShowing()))
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      AppMethodBeat.o(19303);
      return;
    }
    ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    if (paramm.getType() == 539)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.lFh != null) {
          this.lFh.hd(false);
        }
        if ((this.eeN != null) && (this.eeN.isShowing()))
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        AppMethodBeat.o(19303);
        return;
      }
      paramString = (o)paramm;
      if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
      for (paramString = (ahp)paramString.rr.fsW.fta; (paramString == null) || (paramString.wZO == null); paramString = null)
      {
        if (this.lFh != null) {
          this.lFh.hd(false);
        }
        if ((this.eeN != null) && (this.eeN.isShowing())) {
          this.eeN.dismiss();
        }
        AppMethodBeat.o(19303);
        return;
      }
      aw.RO().ac(new i.2(this, paramString));
      if (this.lFh != null) {
        this.lFh.hd(true);
      }
    }
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    AppMethodBeat.o(19303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */