package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProfileInstallReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(194303);
    if (paramIntent == null)
    {
      AppMethodBeat.o(194303);
      return;
    }
    if (!"androidx.profileinstaller.action.INSTALL_PROFILE".equals(paramIntent.getAction()))
    {
      AppMethodBeat.o(194303);
      return;
    }
    d.a(paramContext, ProfileInstallReceiver..ExternalSyntheticLambda0.INSTANCE, new a());
    AppMethodBeat.o(194303);
  }
  
  final class a
    implements d.a
  {
    a() {}
    
    public final void r(int paramInt, Object paramObject)
    {
      AppMethodBeat.i(194305);
      d.bTY.r(paramInt, paramObject);
      AppMethodBeat.o(194305);
    }
    
    public final void s(int paramInt, Object paramObject)
    {
      AppMethodBeat.i(194309);
      d.bTY.s(paramInt, paramObject);
      ProfileInstallReceiver.this.setResultCode(paramInt);
      AppMethodBeat.o(194309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.profileinstaller.ProfileInstallReceiver
 * JD-Core Version:    0.7.0.1
 */