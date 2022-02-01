package com.tencent.mm.plugin.datareport.g.a;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.e.d;
import com.tencent.mm.sdk.platformtools.Log;

public class a
  implements e.d
{
  public void Jv(int paramInt)
  {
    AppMethodBeat.i(262966);
    Log.d("HellEventMonitor", "[onHellFragmentPause]");
    AppMethodBeat.o(262966);
  }
  
  public void V(Activity paramActivity)
  {
    AppMethodBeat.i(263055);
    Log.d("HellEventMonitor", "[onHellActivityDestroy]");
    AppMethodBeat.o(263055);
  }
  
  public void W(Activity paramActivity)
  {
    AppMethodBeat.i(263062);
    Log.d("HellEventMonitor", "[onHellActivityResumed]");
    AppMethodBeat.o(263062);
  }
  
  public final void dtA()
  {
    AppMethodBeat.i(263005);
    Log.d("HellEventMonitor", "[onHellActivityStartActivity]");
    AppMethodBeat.o(263005);
  }
  
  public final void dtB()
  {
    AppMethodBeat.i(263011);
    Log.d("HellEventMonitor", "[onHellActivityFinishActivity]");
    AppMethodBeat.o(263011);
  }
  
  public final void dtC()
  {
    AppMethodBeat.i(263018);
    Log.d("HellEventMonitor", "[onHellActivityMoveActivityTaskToBack]");
    AppMethodBeat.o(263018);
  }
  
  public final void dtD()
  {
    AppMethodBeat.i(263021);
    Log.d("HellEventMonitor", "[onHellActivityCreate]");
    AppMethodBeat.o(263021);
  }
  
  public final void dtE()
  {
    AppMethodBeat.i(263029);
    Log.d("HellEventMonitor", "[onHellActivityNewIntent]");
    AppMethodBeat.o(263029);
  }
  
  public final void dtF()
  {
    AppMethodBeat.i(263036);
    Log.d("HellEventMonitor", "[onHellActivityResume]");
    AppMethodBeat.o(263036);
  }
  
  public final void dtG()
  {
    AppMethodBeat.i(263042);
    Log.d("HellEventMonitor", "[onHellActivityPause]");
    AppMethodBeat.o(263042);
  }
  
  public final void dtH()
  {
    AppMethodBeat.i(263048);
    Log.d("HellEventMonitor", "[onHellActivityStop]");
    AppMethodBeat.o(263048);
  }
  
  public final void dtI()
  {
    AppMethodBeat.i(263066);
    Log.d("HellEventMonitor", "[onHellActivityPaused]");
    AppMethodBeat.o(263066);
  }
  
  public final void dtw()
  {
    AppMethodBeat.i(262972);
    Log.d("HellEventMonitor", "[onHellFragmentEnter]");
    AppMethodBeat.o(262972);
  }
  
  public final void dtx()
  {
    AppMethodBeat.i(262979);
    Log.d("HellEventMonitor", "[onHellFragmentExit]");
    AppMethodBeat.o(262979);
  }
  
  public final void dty()
  {
    AppMethodBeat.i(262993);
    Log.d("HellEventMonitor", "[onHellActivityPushStack]");
    AppMethodBeat.o(262993);
  }
  
  public final void dtz()
  {
    AppMethodBeat.i(263000);
    Log.d("HellEventMonitor", "[onHellActivityPopStackUnRegular]");
    AppMethodBeat.o(263000);
  }
  
  public void eT(View paramView)
  {
    AppMethodBeat.i(263069);
    Log.d("HellEventMonitor", "[onHellViewClick]");
    AppMethodBeat.o(263069);
  }
  
  public void eV(Object paramObject)
  {
    AppMethodBeat.i(262958);
    Log.d("HellEventMonitor", "[onHellFragmentResume]");
    AppMethodBeat.o(262958);
  }
  
  public void eW(Object paramObject)
  {
    AppMethodBeat.i(262985);
    Log.d("HellEventMonitor", "[onHellChatFragmentFinish]");
    AppMethodBeat.o(262985);
  }
  
  public void kL(long paramLong)
  {
    AppMethodBeat.i(262943);
    Log.d("HellEventMonitor", "[onHellBackToFront]");
    AppMethodBeat.o(262943);
  }
  
  public void kM(long paramLong)
  {
    AppMethodBeat.i(262950);
    Log.d("HellEventMonitor", "[onHellFrontToBack]");
    AppMethodBeat.o(262950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.g.a.a
 * JD-Core Version:    0.7.0.1
 */