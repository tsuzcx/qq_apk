package com.tencent.mm.n;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.autogen.a.acm.a;
import com.tencent.mm.autogen.a.hl;
import com.tencent.mm.autogen.a.hl.a;
import com.tencent.mm.autogen.a.iz;
import com.tencent.mm.autogen.a.iz.a;
import com.tencent.mm.autogen.a.jx;
import com.tencent.mm.autogen.a.jx.a;
import com.tencent.mm.autogen.a.ns;
import com.tencent.mm.autogen.a.ns.a;
import com.tencent.mm.autogen.a.os;
import com.tencent.mm.autogen.a.os.b;
import com.tencent.mm.autogen.a.x;
import com.tencent.mm.autogen.a.x.a;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;

public final class a
{
  private static ap hjH;
  
  public static boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(231192);
    if (aTe())
    {
      Log.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      k.a(paramContext, "", paramContext.getString(c.h.multitalk_in_toast), paramContext.getString(c.h.app_i_know), paramOnClickListener).setCanceledOnTouchOutside(false);
      AppMethodBeat.o(231192);
      return true;
    }
    AppMethodBeat.o(231192);
    return false;
  }
  
  public static ap aDI()
  {
    AppMethodBeat.i(150036);
    if (hjH == null) {
      hjH = com.tencent.mm.booter.a.aKj();
    }
    ap localap = hjH;
    AppMethodBeat.o(150036);
    return localap;
  }
  
  public static boolean aTe()
  {
    AppMethodBeat.i(150032);
    os localos = new os();
    localos.hRy.action = 1;
    localos.publish();
    boolean bool = localos.hRz.isStart;
    AppMethodBeat.o(150032);
    return bool;
  }
  
  public static boolean aTf()
  {
    AppMethodBeat.i(231196);
    acm localacm = new acm();
    localacm.publish();
    boolean bool = localacm.ifS.hzJ;
    AppMethodBeat.o(231196);
    return bool;
  }
  
  public static boolean aTg()
  {
    AppMethodBeat.i(231204);
    ns localns = new ns();
    localns.publish();
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localns.hQh.isStart), Boolean.valueOf(localns.hQh.hKC) });
    boolean bool = localns.hQh.isStart;
    AppMethodBeat.o(231204);
    return bool;
  }
  
  public static boolean aTh()
  {
    AppMethodBeat.i(231221);
    x localx = new x();
    localx.publish();
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localx.hzI.hzK), Boolean.valueOf(localx.hzI.hzJ) });
    if (localx.hzI.hzK) {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
    }
    boolean bool = localx.hzI.hzK;
    AppMethodBeat.o(231221);
    return bool;
  }
  
  public static boolean aTi()
  {
    AppMethodBeat.i(231223);
    x localx = new x();
    localx.publish();
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localx.hzI.hzK), Boolean.valueOf(localx.hzI.hzJ) });
    if (localx.hzI.hzJ) {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
    }
    boolean bool = localx.hzI.hzJ;
    AppMethodBeat.o(231223);
    return bool;
  }
  
  public static boolean aTj()
  {
    boolean bool = false;
    AppMethodBeat.i(231224);
    if ((q(null, false)) || (v(null, false))) {
      bool = true;
    }
    Log.i("MicroMsg.DeviceOccupy", "checkMutePlay=".concat(String.valueOf(bool)));
    AppMethodBeat.o(231224);
    return bool;
  }
  
  public static boolean aTk()
  {
    AppMethodBeat.i(231227);
    iz localiz = new iz();
    localiz.publish();
    Log.i("MicroMsg.DeviceOccupy", "checkFinderLiveStatePlaying isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localiz.hKB.isStart), Boolean.valueOf(localiz.hKB.hKC) });
    if ((localiz.hKB.isStart) && (!localiz.hKB.hKC))
    {
      AppMethodBeat.o(231227);
      return true;
    }
    AppMethodBeat.o(231227);
    return false;
  }
  
  public static boolean b(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(231199);
    acm localacm = new acm();
    localacm.publish();
    if (localacm.ifS.hzJ)
    {
      Log.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      k.a(paramContext, "", t(paramContext, localacm.ifS.ifT), paramContext.getString(c.h.app_i_know), paramOnClickListener);
      bool = localacm.ifS.hzJ;
      AppMethodBeat.o(231199);
      return bool;
    }
    boolean bool = c(paramContext, paramOnClickListener);
    AppMethodBeat.o(231199);
    return bool;
  }
  
  public static boolean c(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(231201);
    ns localns = new ns();
    localns.publish();
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localns.hQh.isStart), Boolean.valueOf(localns.hQh.hKC) });
    boolean bool = localns.hQh.isStart;
    if (bool) {
      k.a(paramContext, "", paramContext.getString(c.h.live_open_new_tip_busy), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(231194);
          if (a.this != null) {
            a.this.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
          }
          AppMethodBeat.o(231194);
        }
      });
    }
    AppMethodBeat.o(231201);
    return bool;
  }
  
  public static boolean d(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(231211);
    acm localacm = new acm();
    localacm.publish();
    if (localacm.ifS.hzK)
    {
      Log.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      k.a(paramContext, "", t(paramContext, localacm.ifS.ifT), paramContext.getString(c.h.app_i_know), paramOnClickListener);
      bool = localacm.ifS.hzK;
      AppMethodBeat.o(231211);
      return bool;
    }
    if (v(paramContext, true))
    {
      AppMethodBeat.o(231211);
      return true;
    }
    boolean bool = c(paramContext, null);
    AppMethodBeat.o(231211);
    return bool;
  }
  
  public static boolean dl(Context paramContext)
  {
    AppMethodBeat.i(150031);
    if (aTe())
    {
      Log.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      k.a(paramContext, "", paramContext.getString(c.h.multitalk_in_toast), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(150031);
      return true;
    }
    AppMethodBeat.o(150031);
    return false;
  }
  
  public static boolean dm(Context paramContext)
  {
    AppMethodBeat.i(150034);
    acm localacm = new acm();
    localacm.publish();
    if (localacm.ifS.hzK)
    {
      Log.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      k.a(paramContext, "", t(paramContext, localacm.ifS.ifT), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = localacm.ifS.hzK;
      AppMethodBeat.o(150034);
      return bool;
    }
    if (r(paramContext, true))
    {
      AppMethodBeat.o(150034);
      return true;
    }
    if (v(paramContext, true))
    {
      AppMethodBeat.o(150034);
      return true;
    }
    boolean bool = c(paramContext, null);
    AppMethodBeat.o(150034);
    return bool;
  }
  
  public static boolean dn(Context paramContext)
  {
    AppMethodBeat.i(231215);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if ((2 == paramContext.getCallState()) || (1 == paramContext.getCallState())) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(231215);
      return bool;
    }
  }
  
  public static boolean jdMethod_do(Context paramContext)
  {
    AppMethodBeat.i(231216);
    boolean bool = u(paramContext, true);
    AppMethodBeat.o(231216);
    return bool;
  }
  
  public static boolean dp(Context paramContext)
  {
    AppMethodBeat.i(231219);
    x localx = new x();
    localx.publish();
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localx.hzI.hzK), Boolean.valueOf(localx.hzI.hzJ) });
    if (localx.hzI.hzK)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      k.a(paramContext, "", t(paramContext, localx.hzI.hzJ), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    boolean bool = localx.hzI.hzK;
    AppMethodBeat.o(231219);
    return bool;
  }
  
  public static boolean e(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(231214);
    hl localhl = new hl();
    localhl.publish();
    if (localhl.hIs.hIt)
    {
      Log.i("MicroMsg.DeviceOccupy", "is Face page exist");
      k.a(paramContext, "", paramContext.getString(c.h.face_flash_page_exist), paramContext.getString(c.h.app_i_know), paramOnClickListener);
      boolean bool = localhl.hIs.hIt;
      AppMethodBeat.o(231214);
      return bool;
    }
    AppMethodBeat.o(231214);
    return false;
  }
  
  public static boolean f(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(231220);
    x localx = new x();
    localx.publish();
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localx.hzI.hzK), Boolean.valueOf(localx.hzI.hzJ) });
    if (localx.hzI.hzK)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      k.a(paramContext, "", t(paramContext, localx.hzI.hzJ), paramContext.getString(c.h.app_i_know), paramOnClickListener);
    }
    boolean bool = localx.hzI.hzK;
    AppMethodBeat.o(231220);
    return bool;
  }
  
  public static boolean p(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(231195);
    Object localObject = new acm();
    ((acm)localObject).publish();
    if (((acm)localObject).ifS.hzJ)
    {
      Log.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      if (paramBoolean) {
        k.a(paramContext, "", t(paramContext, ((acm)localObject).ifS.ifT), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      paramBoolean = ((acm)localObject).ifS.hzJ;
      AppMethodBeat.o(231195);
      return paramBoolean;
    }
    if (r(paramContext, paramBoolean))
    {
      AppMethodBeat.o(231195);
      return true;
    }
    localObject = new ns();
    ((ns)localObject).publish();
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b isAudioMicing %s isVideoMicing %s", new Object[] { Boolean.valueOf(((ns)localObject).hQh.isStart), Boolean.valueOf(((ns)localObject).hQh.hKC), Boolean.valueOf(((ns)localObject).hQh.hQi), Boolean.valueOf(((ns)localObject).hQh.hQj) });
    if (((ns)localObject).hQh.hKC) {}
    for (boolean bool = ((ns)localObject).hQh.isStart;; bool = ((ns)localObject).hQh.hQj)
    {
      if ((bool) && (paramBoolean)) {
        k.a(paramContext, "", paramContext.getString(c.h.live_open_new_tip_busy), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(231195);
      return bool;
    }
  }
  
  public static boolean q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(231206);
    Object localObject = new iz();
    ((iz)localObject).publish();
    Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((iz)localObject).hKB.isStart), Boolean.valueOf(((iz)localObject).hKB.hKC) });
    boolean bool = ((iz)localObject).hKB.isStart;
    if ((bool) && (paramBoolean)) {
      if (!((iz)localObject).hKB.hKC) {
        break label108;
      }
    }
    label108:
    for (localObject = paramContext.getString(c.h.finder_live_open_new_tip_anchor_busy);; localObject = paramContext.getString(c.h.finder_live_open_new_tip_visitor_busy))
    {
      aa.makeText(paramContext, (CharSequence)localObject, 0).show();
      AppMethodBeat.o(231206);
      return bool;
    }
  }
  
  public static boolean r(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(231208);
    Object localObject = new iz();
    ((iz)localObject).publish();
    Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((iz)localObject).hKB.isStart), Boolean.valueOf(((iz)localObject).hKB.hKC) });
    boolean bool;
    if ((((iz)localObject).hKB.isStart) && (((iz)localObject).hKB.hKC))
    {
      bool = true;
      if ((bool) && (paramBoolean)) {
        if (!((iz)localObject).hKB.hKC) {
          break label127;
        }
      }
    }
    label127:
    for (localObject = paramContext.getString(c.h.finder_live_open_new_tip_anchor_busy);; localObject = paramContext.getString(c.h.finder_live_open_new_tip_visitor_busy))
    {
      aa.makeText(paramContext, (CharSequence)localObject, 0).show();
      AppMethodBeat.o(231208);
      return bool;
      bool = false;
      break;
    }
  }
  
  public static boolean s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(231209);
    acm localacm = new acm();
    localacm.publish();
    if ((localacm.ifS.hzK) && (paramBoolean)) {
      aa.makeText(paramContext, t(paramContext, localacm.ifS.ifT), 0).show();
    }
    paramBoolean = localacm.ifS.hzK;
    AppMethodBeat.o(231209);
    return paramBoolean;
  }
  
  public static String t(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150035);
    if (paramBoolean)
    {
      paramContext = paramContext.getString(c.h.cannot_use_feature_bcz_camera_using);
      AppMethodBeat.o(150035);
      return paramContext;
    }
    paramContext = paramContext.getString(c.h.cannot_use_feature_bcz_voice_using);
    AppMethodBeat.o(150035);
    return paramContext;
  }
  
  public static boolean u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(231217);
    x localx = new x();
    localx.publish();
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localx.hzI.hzK), Boolean.valueOf(localx.hzI.hzJ) });
    if (localx.hzI.hzJ)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
      if (paramBoolean) {
        Toast.makeText(paramContext, t(paramContext, localx.hzI.hzJ), 0).show();
      }
    }
    paramBoolean = localx.hzI.hzJ;
    AppMethodBeat.o(231217);
    return paramBoolean;
  }
  
  public static boolean v(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(231225);
    jx localjx = new jx();
    localjx.publish();
    Log.i("MicroMsg.DeviceOccupy", "checkFinderVideoState isExist %b ", new Object[] { Boolean.valueOf(localjx.hLx.hIt) });
    if ((localjx.hLx.hIt) && (paramBoolean) && (paramContext != null)) {
      aa.makeText(paramContext, c.h.finder_mega_video_open_new_tip_busy, 0).show();
    }
    paramBoolean = localjx.hLx.hIt;
    AppMethodBeat.o(231225);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */